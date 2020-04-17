package util;

import java.util.HashMap;
import java.util.Map;
import dao.UserInfoDao;
import dao.UserInfoDaoImpl;


public class DaoFactory {
	 
		private static Map<String,Object> config=new HashMap<String,Object>();
		
		static {
			config.put(UserInfoDao.class.getName(),new UserInfoDaoImpl());
		}
		
		public static Object getDaoImpl(String name) {
			return config.get(name);
		}
}
