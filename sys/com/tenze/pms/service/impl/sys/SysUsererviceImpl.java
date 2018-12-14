package com.tenze.pms.service.impl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.common.utils.CommonException;
import com.tenze.common.utils.Md5;
import com.tenze.pms.dao.sys.SysUserDao;
import com.tenze.pms.facade.dto.sys.SysUserDto;
import com.tenze.pms.facade.service.sys.SysUserService;
import com.tenze.utils.SysConstants;


@Service("sysUserService")
public class SysUsererviceImpl extends BaseServiceImpl<SysUserDto> implements
        SysUserService {
    
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    protected BaseDao<SysUserDto> getDao() {
        return sysUserDao;
    }

    @Override
	public long saveUser(SysUserDto sysUserDto) {
    	Long id = sysUserDto.getId();
    	if(id==null || id==0){
	    	String account = sysUserDto.getAccount();
	    	long accountExists = sysUserDao.checkAccountExists(account);
	    	if(accountExists>0)throw new CommonException("该账号已存在， 请另外命名账号");
	    	sysUserDto.setEnabled(SysConstants.ENABLED);
    	}
		String password = sysUserDto.getPassword();
		if(password!=null && password.trim().length()>0){
			if(!password.equals(sysUserDto.getConfirmPassword())){
				throw new CommonException("两次输入的密码不一致");
			}
			sysUserDto.setPassword(Md5.MD5Encode(password));
		}
		return this.save(sysUserDto);
	}

}