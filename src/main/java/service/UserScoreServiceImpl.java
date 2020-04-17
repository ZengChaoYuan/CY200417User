package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.UserScore;
import mapper.UserScoreMapper;
import util.SqlSessionUtil;

public class UserScoreServiceImpl implements UserScoreService {

	@Override
	public List<UserScore> selectPage(Long userId, String start, String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserScoreMapper mapper=session.getMapper(UserScoreMapper.class);
		List<UserScore> userScore=mapper.selectPage(userId, new RowBounds(Integer.parseInt(start),Integer.parseInt(limit)));
		session.close();
		return userScore;
	}

	@Override
	public Long countPage(Long userId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserScoreMapper mapper=session.getMapper(UserScoreMapper.class);
		Long countPage=mapper.countPage(userId);
		session.close();
		return countPage;
	}

}
