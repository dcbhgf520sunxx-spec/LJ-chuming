package com.hzchum.scim.common.core.api.service;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersionsFlow;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateVersionsDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsModuleDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveTemplateVersionsDTOParam;
import java.util.List;

public interface WmsApproveTemplateService {
   List<WmsApproveTemplateVersionsDTO> getAll();

   Boolean add(WmsApproveTemplateVersionsDTOParam request);

   Boolean delete(List<Long> ids);

   Boolean enabled(WmsApproveTemplateVersionsDTOParam wmsApproveTemplateVersionsDTOParam);

   List<WmsApproveTemplateVersionsFlow> getWmsApproveTemplateVersionsFlows(Integer ApproveProcessType, Boolean boolDetail, MountMessageDTO mountMessageDTO) throws RuntimeException;

   List<WmsModuleDTO> getType();
}
