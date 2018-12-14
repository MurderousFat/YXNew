package com.tenze.pms.action.sys;

import com.tenze.action.common.BaseAction;
import com.tenze.pms.dao.sys.SysRoleDao;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;
import com.tenze.pms.facade.dto.bi.BiRegionDto;
import com.tenze.pms.facade.dto.sys.HisEntity;
import com.tenze.pms.facade.dto.sys.SysUserDto;
import com.tenze.pms.facade.service.bi.BiMerchantService;
import com.tenze.pms.facade.service.bi.BiRegionService;
import com.tenze.pms.facade.service.his.HisConfigService;
import com.tenze.pms.facade.service.sys.SysRoleService;
import com.tenze.pms.facade.service.sys.SysUserService;
import com.tenze.pms.servlet.RandCodeImageServlet;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;
import com.tenze.utils.JsonHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller("RegAction")
@Scope(value="prototype")
public class RegAction extends BaseAction {

	@Autowired
	private HisConfigService hisConfigService;

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private BiMerchantService biMerchantService;
	@Autowired
	SysRoleDao sysRoleDao;
	@Autowired
	BiRegionService biRegionService;



	private String account;
	private String username;
	private String password;
	private String repassword;
	private String merchantid;
	private String mphone;
	private String randCode;

	private String cho_Province;
	private String cho_City;
	private String cho_Area;
	private String cho_Insurer;


	private String provice;
	private String selectCity;

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getSelectCity() {
		return selectCity;
	}

	public void setSelectCity(String selectCity) {
		this.selectCity = selectCity;
	}

	public String getCho_City() {
		return cho_City;
	}

	public void setCho_City(String cho_City) {
		this.cho_City = cho_City;
	}

	public String getCho_Area() {
		return cho_Area;
	}

	public void setCho_Area(String cho_Area) {
		this.cho_Area = cho_Area;
	}

	public String getCho_Insurer() {
		return cho_Insurer;
	}

	public void setCho_Insurer(String cho_Insurer) {
		this.cho_Insurer = cho_Insurer;
	}

	public String getCho_Province() {
		return cho_Province;
	}

	public void setCho_Province(String cho_Province) {
		this.cho_Province = cho_Province;
	}

	public String getRandCode() {
		return randCode;
	}

	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	//获取归属医院信息
	public String getBiMerchant2() throws IOException {

		Map<String,Object> map=new HashMap<>();
		map.put("parentNo", "0");//获取一级
		List<BiMerchantDto> biMerchant2Dtos = biMerchantService.listBy(map);

		List<HisEntity> hisEntities=new ArrayList<>();
		//封装
		for (BiMerchantDto biMerchantDto : biMerchant2Dtos) {
			//判断是否有子节点
			String rgnNo = biMerchantDto.getRgnNo();//获取二级id
			map=new HashMap<>();
			map.put("parentNo",rgnNo );
			List<BiMerchantDto> biMerchant2Dtos2 = biMerchantService.listBy(map);
			if(biMerchant2Dtos2.size()!=0) {
				List<HisEntity> list = new ArrayList<>();
				for (BiMerchantDto merchant2Dto : biMerchant2Dtos2) {
					HisEntity en=new HisEntity();
					String merNames = merchant2Dto.getMerNames();
					en.setName(merNames);
					en.setId(String.valueOf(merchant2Dto.getId()));

					map = new HashMap<>();
					map.put("parentNo", merchant2Dto.getRgnNo());
					List<BiMerchantDto> biMerchant2Dtos3 = biMerchantService.listBy(map);//获取三级
					if (biMerchant2Dtos3.size() != 0) {
						HisEntity my=new HisEntity();
						my.setName(merNames);
						my.setId(String.valueOf(merchant2Dto.getId()));
						my.setParentNode(merNames);
						list.add(my);
						for (BiMerchantDto merchantDto : biMerchant2Dtos3) {
							HisEntity en2 = new HisEntity();
							en2.setParentNode(merNames);
							en2.setName(merchantDto.getMerNames());
							en2.setId(String.valueOf(merchantDto.getId()));
							list.add(en2);
							en.setItems(list);
						}
					} else {
						en.setItems(new ArrayList<HisEntity>());
					}
					hisEntities.add(en);
				}
			}

		}


		Dto jsonDto = new BaseDto();
		jsonDto.put("citylist", hisEntities);
		write(jsonDto.toJson());
		return SUCCESS;
	}

	//获取地区
	public String getBiRegion() throws IOException {

		Dto mapResp = new BaseDto();
		List<String> shi=new ArrayList<>();

		Map<String,Object> map=new HashMap<>();
		map.put("parentNo", "0101");//获取市
		List<BiRegionDto> biRegionDtos = biRegionService.listBy(map);
		for (int i = 0; i < biRegionDtos.size(); i++) {
			BiRegionDto biRegionDto =  biRegionDtos.get(i);
			shi.add(biRegionDto.getRgnName());	//市

			List<String>  xianList=new ArrayList<>();
			map=new HashMap<>();
			map.put("parentNo",biRegionDto.getRgnNo() );//获取县
			List<BiRegionDto> xian = biRegionService.listBy(map);
			if(xian.size()==0){
				continue;
			}
			for (int j = 0; j < xian.size(); j++) {
				BiRegionDto regionDto =  xian.get(j);
				xianList.add(regionDto.getRgnName());

				map=new HashMap<>();
				map.put("parentNo",regionDto.getRgnNo() );//获取镇
				List<BiRegionDto> temp = biRegionService.listBy(map);
				if(temp.size()==0){
					continue;
				}
				List<String>  zhenList=new ArrayList<>();
				for (int z = 0; z < temp.size(); z++) {
					BiRegionDto region =  temp.get(z);
					zhenList.add(region.getRgnName());

					map=new HashMap<>();
					map.put("parentNo",region.getRgnNo() );
					List<BiRegionDto> temps = biRegionService.listBy(map);
					if(temps.size()==0){
						continue;
					}
					List<String>  cunList=new ArrayList<>();
					for (int x = 0; x < temps.size(); x++) {
						BiRegionDto reg =  temps.get(x);
						cunList.add(reg.getRgnName());
					}
					mapResp.put("0_"+i+"_"+j+"_"+z,JsonHelper.toJSON(cunList)); //村
				}
				mapResp.put("0_"+i+"_"+j,JsonHelper.toJSON(zhenList)); //镇
			}
			mapResp.put("0_"+i,JsonHelper.toJSON(xianList));   //县
		}
		mapResp.put("0",JsonHelper.toJSON(shi));             //市

		write(mapResp.toJson());
		return SUCCESS;

	}

	public String RegisterPage(){
		return SUCCESS;
	}

	public String userAgreePage(){
		return SUCCESS;
	}

	public String RegSave() throws IOException {
		//校验
		/******************************************************
		if(account==null ||  account.trim().length()<1){
			setFailureTipMsg("请输入登录账号");
			return NULL_SUCCESS;
		}
		 ******************************************************/
		if(mphone==null || mphone.trim().length()<1){
			setFailureTipMsg("请输入手机号码");
			return NULL_SUCCESS;
		}
		//验证手机号格式
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		if(mphone.length()!=11){
			return NULL_SUCCESS;
		}else{
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(mphone);
			boolean isMatch = m.matches();
			if(!isMatch){
				return NULL_SUCCESS;
			}
		}

		if( cho_Province==null ||  "请选择市".equals(cho_Province)){
			setFailureTipMsg("请选择市");
			return NULL_SUCCESS;
		}
		if( cho_City==null ||  "请选择区(县)".equals(cho_City)){
			setFailureTipMsg("请选择区(县)");
			return NULL_SUCCESS;
		}
		if( cho_Area==null ||  "请选择镇".equals(cho_Area)){
			setFailureTipMsg("请选择镇");
			return NULL_SUCCESS;
		}
		if(cho_Insurer==null||"请选择村".equals(cho_Insurer)) {
			setCho_Insurer("");
		}
		if(username==null ||  username.trim().length()<1){
			setFailureTipMsg("请输入用户名");
			return NULL_SUCCESS;
		}
		if(password==null || password.trim().length()<1){
			setFailureTipMsg("请输入密码");
			return NULL_SUCCESS;
		}

		if(provice==null || provice.trim().length()<1){
			setFailureTipMsg("请选择卫生院");
			return SUCCESS;
		}
		if(randCode==null || randCode.trim().length()<1){
			setFailureTipMsg("请输入验证码");
			return NULL_SUCCESS;
		}

		//校验验证码
		HttpSession session = this.getSession();
		Dto d = new BaseDto();
		if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute(RandCodeImageServlet.SESSION_KEY_OF_RAND_CODE)))){
			setFailureTipMsg("验证码错误");
			return NULL_SUCCESS;
		}

		//手机号代替账号
		account = mphone;

		//判断是否存在帐号
		Map<String,Object>  accmap= new HashMap<String,Object>();
		accmap.put("account", account);
		List<SysUserDto> sysUserDtos = sysUserService.listBy(accmap);
		if(sysUserDtos.size()>0){
			setFailureTipMsg("注册失败,帐号已存在,请重新输入换帐号");
			return NULL_SUCCESS;
		}



		//地址
		String address = cho_Province+cho_City+cho_Area+cho_Insurer;


		//封装数据
		SysUserDto sysUserDto = new SysUserDto();
		//所属组织
		sysUserDto.setUnionId(860005115052949504L);
		sysUserDto.setUsername(username);
		sysUserDto.setAccount(account);
		sysUserDto.setPassword(password);
		sysUserDto.setConfirmPassword(repassword);
		sysUserDto.setMphone(mphone);
		sysUserDto.setAddress(address);
		//权限相关---所属医院
		String hisid;
		if(StringUtils.isEmpty(selectCity)){ //卫生站
			hisid=provice;
		}else {
			hisid=selectCity;
		}


		BiMerchantDto by = biMerchantService.getById(Long.parseLong(hisid));
		if(by==null || by.getId()==null){
			setFailureTipMsg("所属医院无效");
			return NULL_SUCCESS;
		}
		sysUserDto.setMerchantId(by.getId());
		 /***********************************************************************
		//设置角色
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("merchantId", by.getId());
		List<SysRoleDto> byMid = sysRoleDao.getByMid(param);
		if(byMid.size()==0){
			setFailureTipMsg("权限分配出错,请联系管理员");
			return NULL_SUCCESS;
		}
		for (SysRoleDto sysRoleDto : byMid) {
			if("村医".equals(sysRoleDto.getRoleName())){
				sysUserDto.setRoleId(sysRoleDto.getId());
				sysUserDto.setRoleName(sysRoleDto.getRoleName());
				break;
			}
		}
		if(sysUserDto.getRoleId()==null){
			setFailureTipMsg("权限分配出错,请联系管理员");
			return NULL_SUCCESS;
		}
		 ***********************************************************************/
		sysUserDto.setRoleId(960353535227068416L);
		sysUserDto.setRoleName("村医");

		long result = sysUserService.saveUser(sysUserDto);
		if(result<1){
			setFailureTipMsg("注册失败,请重新尝试或者联系管理员");
			return NULL_SUCCESS;
		}
		Dto jsonDto = new BaseDto();
		jsonDto.put("success", new Boolean(true));
		write(jsonDto.toJson());

		return NULL_SUCCESS;
	}

	public String checkAcc() throws IOException {
		Dto jsonDto = new BaseDto();
		account = java.net.URLDecoder.decode(account, "utf-8");
		if(StringUtils.isEmpty(account)){
			jsonDto.put("msg", "参数异常");
			write(jsonDto.toJson());
			return NULL_SUCCESS;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("account",account);
		List<SysUserDto> sysUserDtos = sysUserService.listBy(map);
		int size = sysUserDtos.size();
		if(size>0){
			jsonDto.put("data", 1);
			write(jsonDto.toJson());
		}
		return SUCCESS;
	};
}
