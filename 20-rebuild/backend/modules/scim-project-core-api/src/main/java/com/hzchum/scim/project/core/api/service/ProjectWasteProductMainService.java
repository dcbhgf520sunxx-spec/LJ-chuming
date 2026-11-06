package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductMain;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductMainDTO;
import java.util.Date;
import java.util.List;

public interface ProjectWasteProductMainService extends IService<ProjectWasteProductMain> {
   List<ProjectWasteProductMainDTO> listByCondition(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus
   );
}
