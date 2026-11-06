package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ArtifactTaskMarkingBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeProductTaskInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeProductTaskInfoV3DTO;

public interface MesBuildingTaskScanCodeBiz {
   ScanCodeProductTaskInfoDTO getProductTaskV2(Long taskId, Long productId, Integer productType, Integer number);

   ScanCodeProductTaskInfoV3DTO getProductTaskV3(Long taskId, Long productId, Integer productType, Integer number);

   ArtifactTaskMarkingBaseInfo getArtifactMarkingTask(Long productId);

   ArtifactTaskMarkingBaseInfo getAssembleMarkingTask(Long productId);
}
