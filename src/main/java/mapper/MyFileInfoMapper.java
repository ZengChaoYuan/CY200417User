package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.FileCheckInfo;

public interface MyFileInfoMapper {
	//我的文档，条件查询和分页
	List<FileCheckInfo> selectPage(@Param("userId") Long userId,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,@Param("ftId")Long ftId,@Param("checkState")Long checkState,
			 RowBounds row);
	//我的文档，计算条数
	Long countPage(@Param("userId") Long userId,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,@Param("ftId")Long ftId,@Param("checkState")Long checkState);
	
}
