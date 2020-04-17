package service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import bean.UserInfo;
import dao.UserInfoDao;
import mapper.UserInfoMapper;
import util.DBUtil;
import util.DaoFactory;
import util.SqlSessionUtil;

public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public UserInfo login(String name, String pwd) {
		Connection conn=DBUtil.getConnection();
		UserInfoDao info=(UserInfoDao)DaoFactory.getDaoImpl(UserInfoDao.class.getName());
		return info.selectUser(conn, name, pwd);
	}

	@Override
	public int register(UserInfo userInfo) {
		Connection conn=DBUtil.getConnection();
		UserInfoDao info=(UserInfoDao)DaoFactory.getDaoImpl(UserInfoDao.class.getName());
		return info.insertUser(conn, userInfo);
	}

	@Override
	public UserInfo selectUserInfoById(Long userId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		UserInfo user=mapper.selectUserInfoById(userId);
		session.close();
		return user;
	}



	

}
