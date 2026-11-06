package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductMain;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductMainDTO;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductMainService;
import com.hzchum.scim.project.core.mapper.ProjectWasteProductMainMapper;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectWasteProductMainServiceImpl
   extends ServiceImpl<ProjectWasteProductMainMapper, ProjectWasteProductMain>
   implements ProjectWasteProductMainService {
   @Override
   public List<ProjectWasteProductMainDTO> listByCondition(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus
   ) {
      return this.baseMapper
         .selectWasteProductMainList(
            productType, relationType, serialNumber, projectName, createTimeStartDate, createTimeEndDate, createUserName, auditUserName, auditStatus
         );
   }
}
