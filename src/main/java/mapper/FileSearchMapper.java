package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.FileSearch;

public interface FileSearchMapper {

  List<FileSearch> selectPage(@Param("fileName") String fileName,RowBounds row);
  
  Long countPage(@Param("fileName") String fileName);
  
}
