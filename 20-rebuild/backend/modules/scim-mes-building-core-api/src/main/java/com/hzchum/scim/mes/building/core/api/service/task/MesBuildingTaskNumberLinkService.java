package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleExtTaskCargoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import java.util.List;

public interface MesBuildingTaskNumberLinkService extends IService<MesBuildingTaskNumberLink> {
   List<ArtifactStatusDTO> listProductType(List<Long> artifactIds);

   List<MesBuildingTaskNumberLink> listLinksBydata(List<NumberInfoDTO> numbers, Integer taskType);

   List<MesBuildingAssembleExtTaskCargoDTO> listAssembleExtWarehouseStatusList(List<NumberInfoDTO> numbers);

   List<MesBuildingTaskNumberLink> listNumberLinksByTaskIds(List<Long> taskIds);
}
