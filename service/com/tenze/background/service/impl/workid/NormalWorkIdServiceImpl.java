package com.tenze.background.service.impl.workid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tenze.background.facade.service.workid.WorkIdService;
import com.tenze.background.generator.common.IdWorker;

@Service
@Scope(value="singleton")
public class NormalWorkIdServiceImpl implements WorkIdService {
	
	private IdWorker idWorker = new IdWorker(0,0);

	@Override
	public long nextId() {
		return idWorker.nextId();
	}

}
