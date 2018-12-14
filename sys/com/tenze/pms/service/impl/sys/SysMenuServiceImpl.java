package com.tenze.pms.service.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.common.utils.CommonException;
import com.tenze.pms.dao.sys.SysMenuDao;
import com.tenze.pms.facade.dto.sys.SysMenuDto;
import com.tenze.pms.facade.service.sys.SysMenuService;
import com.tenze.utils.SysConstants;


@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDto> implements
        SysMenuService {
    
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    protected BaseDao<SysMenuDto> getDao() {
        return sysMenuDao;
    }

	@Override
	public long saveWithParent(SysMenuDto menuDto) {
		String parentNo = menuDto.getParentNo();
		if(parentNo==null || parentNo.trim().length()<1)parentNo=SysConstants.TREE_ROOT_NO;
		boolean needNewMenuNo = false;
		String preMenuNo = null;
		if(menuDto.getId()!=null && menuDto.getId()!=0){
			SysMenuDto preMenuDto = this.getById(menuDto.getId());
			if(!parentNo.equals(preMenuDto.getParentNo())){
				needNewMenuNo = true;
				preMenuNo = preMenuDto.getMenuNo();
			}
		}else{
			needNewMenuNo = true;
		}
		
		if(needNewMenuNo){
			if(preMenuNo!=null && parentNo.startsWith(preMenuNo) && parentNo.length()>preMenuNo.length())
				throw new CommonException("上级菜单禁止直接下移到下级菜单");
			String maxSeq = sysMenuDao.maxSeq(parentNo);
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("menuNo", parentNo);
			params.put("root", "root");
			SysMenuDto parentDto = this.getBy(params);
			
			String menuNo = null;
			if(maxSeq==null || maxSeq.trim().length()<1){
				menuNo = parentNo + "01";
			}else if(SysConstants.TREE_ROOT_NO.equals(parentNo)){
				Integer curSeq = Integer.valueOf(maxSeq.substring(maxSeq.length()-2,maxSeq.length()))+1;
				menuNo =  (curSeq<10?("0"+ curSeq):(""+ curSeq));
				menuDto.setParentNo(SysConstants.TREE_ROOT_NO);
			}else{
				Integer curSeq = Integer.valueOf(maxSeq.substring(maxSeq.length()-2,maxSeq.length()))+1;
				menuNo = parentNo + (curSeq<10?("0"+ curSeq):(""+ curSeq));
			}
			
			menuDto.setMenuNo(menuNo);
			menuDto.setLeafFlag(Byte.valueOf("1"));
			parentDto.setLeafFlag(Byte.valueOf("0"));
			
			this.save(parentDto);
			
			if(preMenuNo!=null)this.sysMenuDao.updateSubMenu(menuNo, preMenuNo);
		}
				
		return this.save(menuDto);
	}

	@Override
	public List<SysMenuDto> listByRole(Long roleId) {
		return sysMenuDao.listByRole(roleId);
	}


}