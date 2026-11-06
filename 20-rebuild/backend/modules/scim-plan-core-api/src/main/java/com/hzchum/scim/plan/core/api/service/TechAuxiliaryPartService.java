package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechAuxiliaryPartQueryDTOParam;
import java.util.List;

public interface TechAuxiliaryPartService extends IService<TechAuxiliaryPart> {
   List<TechAuxiliaryPartDTO> listAuxiliaryPart(TechAuxiliaryPartQueryDTOParam param);

   List<TechAuxiliaryPartSummaryDTO> listAuxiliaryPartSummary(Long projectId, Long monomerId, Long areaId);
}
