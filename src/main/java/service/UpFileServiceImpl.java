package service;

import org.apache.ibatis.session.SqlSession;

import bean.FileCheck;
import bean.FileInfo;
import mapper.UpFileMapper;
import util.SqlSessionUtil;

public class UpFileServiceImpl implements UpFileService {

	@Override
	public Integer insertByFileInfo(FileInfo fileInfo) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UpFileMapper mapper=session.getMapper(UpFileMapper.class);
		Integer info=mapper.insertByFileInfo(fileInfo);
		session.commit();
		session.close();
		return info;
	}

	@Override
	public Integer insertByFileCheck(FileCheck fileCheck) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UpFileMapper mapper=session.getMapper(UpFileMapper.class);
		Integer info=mapper.insertByFileCheck(fileCheck);
		session.commit();
		session.close();
		return info;
	}

}
