package mapper;
import org.apache.ibatis.annotations.Param;

import bean.FileCheck;
import bean.FileInfo;

public interface UpFileMapper {
  
	  //上传文档
	  //1.插入文件信息表
	  Integer insertByFileInfo(@Param("fileInfo") FileInfo fileInfo);
	  //2.插入文件审核表
	  Integer insertByFileCheck(@Param("fileCheck") FileCheck fileCheck);
	  
}
