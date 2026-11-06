package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessArtifactSimpleDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindDTOParam;

public interface BusinessArtifactService extends IService<BusinessArtifact> {
   Long addBusinessInfo(ArtifactAddDTOParam param);

   BusinessArtifact editBusinessInfo(ArtifactEditDTOParam param);

   BusinessArtifact getByCondition(ArtifactFindDTOParam param);

   SummaryDTO summary(Long projectId, Long monomerId, Long areaId);

   ListVO<BusinessArtifactSimpleDTO> listSimple(Long monomerId);
}
