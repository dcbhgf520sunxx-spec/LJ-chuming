package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import java.util.List;

public interface ProjectInspectionService extends IService<ProjectInspection> {
   List<ProjectInspectionDTO> getInspectionList(List<Long> inspectionIds, Long inspectionUserId);
}
