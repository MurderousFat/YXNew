package com.tenze.pms.dao.impl.bi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tenze.background.common.core.dao.BaseDaoImpl;
import com.tenze.pms.dao.bi.BiPartDao;
import com.tenze.pms.facade.dto.bi.BiPartDto;

@Repository("biPartDao")
public class BiPartDaoImpl extends BaseDaoImpl<BiPartDto> implements BiPartDao {

}