package util;

import java.util.HashMap;
import java.util.Map;

import service.UserInfoService;
import service.UserInfoServiceImpl;

public class ServiceFactory {
	private static Map<String,Object> config=new HashMap<String,Object>();
    static {
    	config.put(UserInfoService.class.getName(), new UserInfoServiceImpl());
    }
    public static Object getServiceImpl(String name) {
    	return config.get(name);
    }
}


