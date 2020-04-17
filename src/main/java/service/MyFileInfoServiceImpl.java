package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.FileCheckInfo;
import mapper.MyFileInfoMapper;
import util.SqlSessionUtil;

public class MyFileInfoServiceImpl implements MyFileInfoService {

	@Override
	public List<FileCheckInfo> selectPage(Long userId, String startTime, String endTime, Long ftId, Long checkState,
			String start, String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		MyFileInfoMapper mapper=session.getMapper(MyFileInfoMapper.class);
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(ftId==null) {
			ftId=null;
		}
		if(checkState==null) {
		checkState=null;
	    }
		List<FileCheckInfo> myFileInfo=mapper.selectPage(userId, startTime, endTime, ftId, checkState, new RowBounds(Integer.parseInt(start),
				Integer.parseInt(limit)));
		session.close();
		return myFileInfo;
	}

	@Override
	public Long countPage(Long userId, String startTime, String endTime, Long ftId, Long checkState) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		MyFileInfoMapper mapper=session.getMapper(MyFileInfoMapper.class);
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(ftId==null) {
			ftId=null;
		}
		if(checkState==null) {
		checkState=null;
	    }
		Long count=mapper.countPage(userId, startTime, endTime, ftId, checkState);
		session.close();
		return count;
	}
}
