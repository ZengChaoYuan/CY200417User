package dao;

import java.sql.Connection;

import bean.UserInfo;

public interface UserInfoDao {
  UserInfo selectUser(Connection conn,String userName,String password);
  int insertUser(Connection conn,UserInfo userInfo);
}
