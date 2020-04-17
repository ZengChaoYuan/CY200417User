package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.UserScore;

public interface UserScoreMapper {
  List<UserScore> selectPage(@Param("userId")Long userId,RowBounds row);
  
  Long countPage(@Param("userId")Long userId);
  
}
