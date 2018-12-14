package com.tenze.pms.dao.impl.bi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.bi.BiOrgDao;
import com.tenze.pms.facade.dto.bi.BiOrgDto;

@Repository("biOrgDao")
public class BiOrgDaoImpl extends BaseDaoImpl<BiOrgDto> implements BiOrgDao {

}