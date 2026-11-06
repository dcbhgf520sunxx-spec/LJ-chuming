package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectVisaReason;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectVisaReasonDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectVisaReasonDTOParam;
import java.util.List;

public interface ProjectVisaReasonService extends IService<ProjectVisaReason> {
   List<ProjectVisaReasonDTO> listVisaReason(String name);

   Boolean saveVisaReason(List<ProjectVisaReasonDTOParam> params);

   Boolean updateVisaReason(ProjectVisaReasonDTOParam param);
}
