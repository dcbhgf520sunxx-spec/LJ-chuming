package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSubVisa;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectSubVisaQueryDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface ProjectSubVisaService extends IService<ProjectSubVisa> {
   List<ProjectSubVisaDTO> listSubVisa(ProjectSubVisaQueryDTOParam param);

   BigDecimal getSumVisaAmount(Long subcontractOrderId);
}
