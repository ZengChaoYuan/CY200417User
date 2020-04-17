package service;

import java.util.List;

import bean.FileSearch;

public interface FileSearchService {

	List<FileSearch> selectPage(String fileName,String start,String limit);
	
	Long countPage(String fileName);
}
