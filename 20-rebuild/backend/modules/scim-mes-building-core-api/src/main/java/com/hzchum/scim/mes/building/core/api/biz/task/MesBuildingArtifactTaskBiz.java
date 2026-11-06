package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusQHSEDTO;
import java.util.List;

public interface MesBuildingArtifactTaskBiz extends IBiz<MesBuildingTask> {
   List<ArtifactStatusQHSEDTO> listArtifactQHSEStatus(Long artifactId);

   List<ArtifactStatusQHSEDTO> listArtifactCompanyQHSEStatus(Long artifactId);
}
