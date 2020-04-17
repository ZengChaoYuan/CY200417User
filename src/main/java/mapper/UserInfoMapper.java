package mapper;

import org.apache.ibatis.annotations.Param;

import bean.UserInfo;

public interface UserInfoMapper {
  UserInfo selectUserInfoById(@Param("userId") Long userId);
}
