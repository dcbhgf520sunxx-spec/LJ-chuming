package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactAuxiliaryLinkDTO;
import java.util.List;

public interface TechArtifactAuxiliaryLinkService extends IService<TechArtifactAuxiliaryLink> {
   List<TechArtifactAuxiliaryLinkDTO> listByCondition(List<Long> artifactIdList, List<String> auxiliaryPartNameList);
}
