package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactChangeQueryDtoParam;
import java.time.LocalDateTime;
import java.util.List;

public interface TechArtifactChangeService extends IService<TechArtifactChange> {
   List<TechArtifactChangeDTO> listByCondition(TechArtifactChangeQueryDtoParam param);

   List<TechArtifactChangeDTO> warehousingListByCondition(TechArtifactChangeQueryDtoParam param);

   List<TechArtifactChange> listNewChanges(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String specification, LocalDateTime startDate, LocalDateTime endDate
   );
}
