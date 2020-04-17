package service;

import java.util.List;

import bean.UserScore;

public interface UserScoreService {

	List<UserScore> selectPage(Long userId,String start,String limit);
	
	Long countPage(Long userId);
}
