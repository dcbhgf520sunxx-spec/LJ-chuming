package com.hzchum.scim.mes.building.core.api.manager;

import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import java.util.List;
import java.util.Map;

public interface MesBuildingTaskManager {
   List<ArtifactStatusDTO> listBatchArtifactStatus(Map<Long, TechArtifact> artifactMap, Map<Long, List<TechArtifactExt>> artifactExtMap);
}
