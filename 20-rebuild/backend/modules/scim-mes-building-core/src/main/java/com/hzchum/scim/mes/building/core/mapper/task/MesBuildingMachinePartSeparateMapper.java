package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachinePartSeparateDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingMachinePartSeparateMapper extends BaseMapper<MesBuildingMachinePartSeparate> {
   List<MesBuildingMachinePartSeparateDO> getListByCutId(@Param("cutId") Long cutId, @Param("processType") Integer processType);

   List<MesBuildingMachinePartSeparateDO> getDrillListByCutId(@Param("cutId") Long cutId);

   List<Long> getIds(@Param("cutId") Long cutId, @Param("processType") Integer processType);
}
