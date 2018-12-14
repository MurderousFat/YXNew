package com.tenze.pms.facade.service.his;

import java.io.Serializable;

public interface HisService extends Serializable {

	boolean doLogin(String ckz543,String vid);
	
	String doprocess(String interfaceId, String input);
	
	boolean findKey(String ckz543, String aae011, String sessiond);
}
