package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.FileSearch;
import mapper.FileSearchMapper;
import util.SqlSessionUtil;

public class FileSearchServiceImpl implements FileSearchService {

	@Override
	public List<FileSearch> selectPage(String fileName,String start,String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileSearchMapper mapper=session.getMapper(FileSearchMapper.class);
		if(fileName == null||fileName.trim().equals("")) {
			fileName=null;
		}
		List<FileSearch> fileSearch=mapper.selectPage(fileName, new RowBounds(Integer.parseInt(start),
				Integer.parseInt(limit)));
		session.close();
		return fileSearch;
	}

	@Override
	public Long countPage(String fileName) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileSearchMapper mapper=session.getMapper(FileSearchMapper.class);
		if(fileName == null||fileName.trim().equals("")) {
			fileName=null;
		}
		Long count=mapper.countPage(fileName);
		session.close();
		return count;
	}

}
