package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import java.time.LocalDateTime;
import java.util.List;

public interface TechArtifactMachinePartLinkService extends IService<TechArtifactMachinePartLink> {
   List<TechArtifactDTO> listArtifactPartByConditions(
      Long areaId,
      Long areaBatchId,
      String name,
      String serialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Long userId,
      String assembleSerialNumber,
      Integer permissionCheck,
      List<LocalDateTime> dateTimeList,
      String userName
   );

   List<ArtifactAssociationCount> getArtifactPartConvertCounts(List<Long> artifactId);
}
