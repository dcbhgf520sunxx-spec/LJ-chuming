package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleExtTaskCargoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskNumberLinkMapper extends BaseMapper<MesBuildingTaskNumberLink> {
   List<ArtifactStatusDTO> listProductType(@Param("artifactIds") List<Long> artifactIds);

   List<MesBuildingTaskNumberLink> listLinksBydata(@Param("numbers") List<NumberInfoDTO> numbers, @Param("taskType") Integer taskType);

   List<MesBuildingAssembleExtTaskCargoDTO> listAssembleExtWarehouseStatusList(@Param("numbers") List<NumberInfoDTO> numbers);

   List<MesBuildingTaskNumberLink> listNumberLinksByTaskIds(@Param("taskIds") List<Long> taskIds);
}
