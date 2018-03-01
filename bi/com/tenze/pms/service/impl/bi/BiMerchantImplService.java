package com.tenze.pms.service.impl.bi;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.common.utils.CommonException;
import com.tenze.pms.dao.bi.BiMerchantDao;
import com.tenze.pms.facade.dto.bi.BiMerchantDto;
import com.tenze.pms.facade.service.bi.BiMerchantService;
import com.tenze.utils.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("biMerchantService")
public class BiMerchantImplService extends BaseServiceImpl<BiMerchantDto> implements
		BiMerchantService {
    
    @Autowired
    private BiMerchantDao biRegionDao;

    @Override
    protected BaseDao<BiMerchantDto> getDao() {
        return biRegionDao;
    }

	@Override
	public long saveTree(BiMerchantDto dto) {
		String parentNo = dto.getParentNo();
		if(parentNo==null || parentNo.trim().length()<1)parentNo= SysConstants.TREE_ROOT_NO;
		boolean needNewMenuNo = false;
		String preMenuNo = null;
		if(dto.getId()!=null && dto.getId()!=0){
			BiMerchantDto preMenuDto = this.getById(dto.getId());
			if(!parentNo.equals(preMenuDto.getParentNo())){
				needNewMenuNo = true;
				preMenuNo = preMenuDto.getRgnNo();
			}
		}else{
			needNewMenuNo = true;
		}
		
		if(needNewMenuNo){
			//新建?
			if(preMenuNo!=null && parentNo.startsWith(preMenuNo) && parentNo.length()>preMenuNo.length())
				throw new CommonException("上级菜单禁止直接下移到下级菜单");
			String maxSeq = biRegionDao.maxSeq(parentNo);
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("singleRgnNo", parentNo);
			params.put("root", "root");
			BiMerchantDto parentDto = this.getBy(params);
			
			String menuNo = null;
			if(maxSeq==null || maxSeq.trim().length()<1){
				if(SysConstants.TREE_ROOT_NO.equals(parentNo)){
					menuNo = "01";
					dto.setParentNo(SysConstants.TREE_ROOT_NO);
				}else{
					menuNo = parentNo+"01";
				}
			}else if(SysConstants.TREE_ROOT_NO.equals(parentNo)){
				Integer curSeq = Integer.valueOf(maxSeq.substring(maxSeq.length()-2,maxSeq.length()))+1;
				menuNo =  (curSeq<10?("0"+ curSeq):(""+ curSeq));
				dto.setParentNo(SysConstants.TREE_ROOT_NO);
			}else{
				Integer curSeq = Integer.valueOf(maxSeq.substring(maxSeq.length()-2,maxSeq.length()))+1;
				menuNo = parentNo + (curSeq<10?("0"+ curSeq):(""+ curSeq));
			}
			
			dto.setRgnNo(menuNo);
			dto.setLeafFlag(Byte.valueOf("1"));
			parentDto.setLeafFlag(Byte.valueOf("0"));
			
			this.save(parentDto);
			
			if(preMenuNo!=null)this.biRegionDao.updateSubMenu(menuNo, preMenuNo);
		}
				
		return this.save(dto);
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		this.getDao().deleteByIds(ids);
		for (Long id : ids) {
			Map<String,Object> map=new HashMap<>();
			map.put("rgnNo",id);
			BiMerchantDto biMerchant2Dto = biRegionDao.getByRgnNo(map);
			String parentNo = biMerchant2Dto.getParentNo();//上级id
			if ("0".equals(parentNo)){
				continue;
			}
			map=new HashMap<>(); //查询是否有子集
			map.put("parentNo",parentNo );
			List<BiMerchantDto> biMerchant2Dtos = biRegionDao.listBy(map);
			if(biMerchant2Dtos.size()==0){ //没有 修改状态
				map=new HashMap<>();
				map.put("rgnNo",parentNo);
				BiMerchantDto prarnt = biRegionDao.getBy(map);
				Byte leafFlag = prarnt.getLeafFlag();
				if(!"1".equals(String.valueOf(leafFlag))){
					prarnt.setLeafFlag(Byte.valueOf("1"));
					this.save(prarnt);
				}
			}
		}
	}

}