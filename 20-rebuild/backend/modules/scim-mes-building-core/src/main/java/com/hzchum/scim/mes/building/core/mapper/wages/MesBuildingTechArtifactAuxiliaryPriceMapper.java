package com.hzchum.scim.mes.building.core.mapper.wages;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingTechArtifactAuxiliaryPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.StudSleeveDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTechArtifactAuxiliaryPriceMapper extends BaseMapper<MesBuildingTechArtifactAuxiliaryPrice> {
   List<StudSleeveDTO> studSleeveList(
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("auxiliaryTypeEnum") Integer auxiliaryTypeEnum
   );
}
