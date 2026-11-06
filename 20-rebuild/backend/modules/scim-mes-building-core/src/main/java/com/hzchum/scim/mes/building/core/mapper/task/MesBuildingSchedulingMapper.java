package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingAssembleDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingMachinePartDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingMachinePartSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingSchedulingProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingAssembleSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingEnclosureSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingMachinePartSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.SchedulingDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MachinePartSummartDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingAssembleDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingEnclosureDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingMachinePartDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.SchedulingSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.get.SchedulingDetailListDOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingSchedulingMapper extends BaseMapper<MesBuildingScheduling> {
   List<MesBuildingSchedulingDO> listByCondition(SchedulingDetailListDOParam doParam);

   MesBuildingSchedulingDO listById(@Param("id") Long id, @Param("productType") Integer productType);

   MesBuildingSchedulingSummaryDO selectSummary(MesBuildingSchedulingDOParam mesBuildingSchedulingDOParam);

   List<MesBuildingAssembleSchedulingSummaryDO> getAssembleSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingArtifactSchedulingSummaryDO> getArtifactSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingEnclosureSchedulingSummaryDO> getEnclosureSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingMachinePartSchedulingSummaryDO> getMachinePartSchedulingGroupByDay(SchedulingSummaryDOParam doParam);

   List<MesBuildingSchedulingProductionLineDO> getSchedulingGroupProductionLineId(Long productId, Integer productType);

   List<MesBuildingSchedulingProductionLineDO> getSchedulingGroupProductionLineIds(
      @Param("productIds") List<Long> productIds, @Param("productType") Integer productType
   );

   SchedulingDetailDO selectSchedulingDetailByProductIdAndProductType(
      @Param("productId") Long productId, @Param("productType") Integer productType, @Param("assembleId") Long assembleId
   );

   List<MesBuildingArtifactDO> listSchedulingArtifactByCondition(@Param("copy") MesBuildingArtifactDO copy);

   List<MesBuildingAssembleDO> listSchedulingAssembleByCondition(@Param("assemble") MesBuildingAssembleDOParam assembleDOParam);

   List<MesBuildingEnclosureDO> listSchedulingEnclosureByCondition(MesBuildingEnclosureDOParam enclosureDOParam);

   List<MesBuildingMachinePartDO> listSchedulingMachinePartByCondition(@Param("copy") MesBuildingMachinePartDOParam copy);

   List<MesBuildingMachinePartSummaryDO> schedulingSummaryMachinePartByConditionList(MachinePartSummartDOParam copy);

   MesBuildingScheduling getScheduling(
      @Param("today") LocalDateTime today,
      @Param("askTime") LocalDateTime askTime,
      @Param("productId") Long productId,
      @Param("productType") Integer productType,
      @Param("productionLineId") Long productionLineId
   );

   int selectTotalScheduling(@Param("productId") Long productId);

   List<NameInfo> getProductLine(Integer productType);

   ProductLineSummary selectSummaryData(Long lineId, Long projectId);
}
