package service;

import bean.UserInfo;

public interface UserInfoService {
   UserInfo login(String name,String pwd);
   int register(UserInfo userInfo);
   
   //查找个人信息
   UserInfo selectUserInfoById(Long userId);
}
