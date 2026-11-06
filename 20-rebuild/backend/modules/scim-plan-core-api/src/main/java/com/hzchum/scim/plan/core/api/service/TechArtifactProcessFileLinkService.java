package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFileLink;
import java.util.List;

public interface TechArtifactProcessFileLinkService extends IService<TechArtifactProcessFileLink> {
   List<TechArtifactProcessFileLink> listByCondition(
      Long processFileId, Long projectId, Long monomerId, Long structureClassId, String name, String serialNumber, String specification, String material
   );
}
