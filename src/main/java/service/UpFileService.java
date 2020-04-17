package service;

import bean.FileCheck;
import bean.FileInfo;

public interface UpFileService {
	  //上传文档
	  //1.插入文件信息表
	  Integer insertByFileInfo(FileInfo fileInfo);
	  //2.插入文件审核表
	  Integer insertByFileCheck(FileCheck fileCheck);
}
