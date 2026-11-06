package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import com.hzchum.scim.system.core.api.service.ProjectInspectionService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionServiceImpl extends ServiceImpl<ProjectInspectionMapper, ProjectInspection> implements ProjectInspectionService {
   @Override
   public List<ProjectInspectionDTO> getInspectionList(List<Long> inspectionIds, Long inspectionUserId) {
      return this.baseMapper.getInspectionList(inspectionIds, inspectionUserId);
   }
}
