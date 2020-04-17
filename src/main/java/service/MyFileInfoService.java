package service;

import java.util.List;

import bean.FileCheckInfo;

public interface MyFileInfoService {
	// 条件查询和分页
	List<FileCheckInfo> selectPage(Long userId,String startTime, String endTime,
			Long ftId,Long checkState,String start,String limit);
	// 计算条数
	Long countPage(Long userId,String startTime, String endTime,
			Long ftId,Long checkState);
	
	
}
