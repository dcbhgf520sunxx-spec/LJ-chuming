package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactStandardPartLinkDTO;
import java.util.List;

public interface TechArtifactStandardPartLinkService extends IService<TechArtifactStandardPartLink> {
   List<TechArtifactStandardPartLinkDTO> listByCondition(List<Long> artifactIdList, List<String> nameList);
}
