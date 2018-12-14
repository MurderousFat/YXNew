package com.tenze.pms.service.impl.bi;

import com.tenze.background.common.core.dao.BaseDao;
import com.tenze.background.common.core.service.BaseServiceImpl;
import com.tenze.common.utils.CommonException;
import com.tenze.pms.dao.bi.BiUnionDao;
import com.tenze.pms.facade.dto.bi.BiUnionDto;
import com.tenze.pms.facade.service.bi.BiUnionService;
import com.tenze.utils.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("biUnionService")
public class BiUnionServiceImpl extends BaseServiceImpl<BiUnionDto> implements
        BiUnionService {
    
    @Autowired
    private BiUnionDao biUnionDao;

    @Override
    protected BaseDao<BiUnionDto> getDao() {
        return biUnionDao;
    }

    @Override
	public long saveTree(BiUnionDto dto) {
		String parentNo = dto.getParentNo();
		if(parentNo==null || parentNo.trim().length()<1)parentNo=SysConstants.TREE_ROOT_NO;
		boolean needNewMenuNo = false;
		String preMenuNo = null;
		if(dto.getId()!=null && dto.getId()!=0){
			BiUnionDto preMenuDto = this.getById(dto.getId());
			if(!parentNo.equals(preMenuDto.getParentNo())){
				needNewMenuNo = true;
				preMenuNo = preMenuDto.getUnionNo();
			}
		}else{
			needNewMenuNo = true;
		}
		
		if(needNewMenuNo){
			if(preMenuNo!=null && parentNo.startsWith(preMenuNo) && parentNo.length()>preMenuNo.length())
				throw new CommonException("上级菜单禁止直接下移到下级菜单");
			String maxSeq = biUnionDao.maxSeq(parentNo);
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("singleUnionNo", parentNo);
			params.put("root", "root");
			BiUnionDto parentDto = this.getBy(params);
			
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
			
			dto.setUnionNo(menuNo);
			dto.setLeafFlag(Byte.valueOf("1"));
			parentDto.setLeafFlag(Byte.valueOf("0"));
			
			this.save(parentDto);
			
			if(preMenuNo!=null)this.biUnionDao.updateSubMenu(menuNo, preMenuNo);
		}
				
		return this.save(dto);
	}



}