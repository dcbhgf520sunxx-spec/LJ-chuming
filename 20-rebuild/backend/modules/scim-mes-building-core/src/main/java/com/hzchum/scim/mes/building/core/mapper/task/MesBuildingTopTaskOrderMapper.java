package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingTopTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingOrderIdAndQuantityDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTopTaskOrderMapper extends BaseMapper<MesBuildingTopTaskOrder> {
   List<MesBuildingTopTaskOrderDO> getTopTaskOrderAssistList(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   int getNumber(@Param("now") LocalDateTime now);

   List<MesBuildingOrderIdAndQuantityDTO> boolOrderComplete(@Param("topOrderIds") List<Long> topOrderIds);
}
