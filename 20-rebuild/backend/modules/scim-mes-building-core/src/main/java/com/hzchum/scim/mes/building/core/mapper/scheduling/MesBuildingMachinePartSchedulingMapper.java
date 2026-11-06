package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingParNeedSchedulingDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingMachinePartSchedulingMapper extends BaseMapper<MesBuildingMachinePartScheduling> {
   List<MesBuildingMachinePartSchedulingDO> getMachinePartSchedulingRecordList(
      @Param("issueStatusEnum") Integer issueStatusEnum, @Param("dateTime") LocalDateTime dateTime
   );

   int passDeleteCount(LocalDateTime now);

   List<String> listNeedSchedulingMonth(@Param("workshopId") Long workshopId);

   List<String> listNeedSchedulingMonthTwo(
      @Param("workshopIds") List<Long> workshopIds, @Param("steelPlateTypeEnum") List<Integer> steelPlateTypeEnum, @Param("sendStatus") Boolean sendStatus
   );

   List<MesBuildingParNeedSchedulingDTO> listNeedSchedulingParts(
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerIds") List<Long> monomerIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("monthList") List<LocalDateTime> monthList,
      @Param("workshopIds") List<Long> workshopIds,
      @Param("productionLineIds") List<Long> productionLineIds,
      @Param("groupsIds") List<Long> groupsIds,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("material") String material,
      @Param("thicks") List<String> thicks,
      @Param("serialNumber") String serialNumber,
      @Param("minLength") BigDecimal minLength,
      @Param("maxLength") BigDecimal maxLength,
      @Param("boolDxfEnum") Boolean boolDxfEnum
   );

   List<MesBuildingParNeedSchedulingDTO> listNeedSchedulingPartsForNesting(
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerIds") List<Long> monomerIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("monthList") List<LocalDateTime> monthList,
      @Param("workshopIds") List<Long> workshopIds,
      @Param("productionLineIds") List<Long> productionLineIds,
      @Param("groupsIds") List<Long> groupsIds,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("material") String material,
      @Param("thicks") List<String> thicks,
      @Param("serialNumber") String serialNumber,
      @Param("minLength") BigDecimal minLength,
      @Param("maxLength") BigDecimal maxLength,
      @Param("boolDxfEnum") Boolean boolDxfEnum,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum
   );
}
