package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.FileType;
import mapper.FileTypeListMapper;
import util.SqlSessionUtil;

public class FileTypeServiceImpl implements FileTypeService {

	@Override
	public List<FileType> selectFileTypeList() {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		List<FileType> fileType=mapper.selectFileTypeList();
		session.close();
		return fileType;
	}

}
