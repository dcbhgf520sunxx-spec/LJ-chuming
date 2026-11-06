package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingNestCutPlateDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingNestCutPlateMapper extends BaseMapper<MesBuildingNestCutPlate> {
   List<MesBuildingMachineTaskOrderDTO> getAllnetCut(
      @Param("boolNestCut") Integer boolNestCut,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerIds") List<Long> monomerIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("serialNumber") String serialNumber,
      @Param("processType") Integer processType,
      @Param("processIds") List<Long> processIds,
      @Param("printType") Boolean printType,
      @Param("workshopId") Long workshopId,
      @Param("localDateTime") LocalDateTime localDateTime,
      @Param("cutNumber") String cutNumber,
      @Param("cutConfigId") Long cutConfigId
   );

   List<MesBuildingNestCutPlateDO> getMachinePartTaskIssuedDetails(@Param("id") Long id);
}
