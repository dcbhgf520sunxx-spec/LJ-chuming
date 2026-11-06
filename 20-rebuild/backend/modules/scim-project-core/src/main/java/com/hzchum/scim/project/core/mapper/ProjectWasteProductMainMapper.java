package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductMain;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductMainDTO;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectWasteProductMainMapper extends BaseMapper<ProjectWasteProductMain> {
   List<ProjectWasteProductMainDTO> selectWasteProductMainList(
      @Param("productType") Integer productType,
      @Param("relationType") Integer relationType,
      @Param("serialNumber") String serialNumber,
      @Param("projectName") String projectName,
      @Param("createTimeStartDate") Date createTimeStartDate,
      @Param("createTimeEndDate") Date createTimeEndDate,
      @Param("createUserName") String createUserName,
      @Param("auditUserName") String auditUserName,
      @Param("auditStatus") Integer auditStatus
   );
}
