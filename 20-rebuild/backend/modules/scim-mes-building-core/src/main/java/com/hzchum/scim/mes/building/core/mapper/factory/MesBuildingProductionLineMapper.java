package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.ProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ArtifactSchedulingLineInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductionLineSchedulingInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingLineSummaryDTO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProductionLineMapper extends BaseMapper<MesBuildingProductionLine> {
   List<DistributionDO> listByCondition(@Param("factory") Long factory, @Param("workshopId") Long workshopId);

   List<NameInfo> listProductionLineUser(@Param("workshopId") Long workshopId, @Param("currentUserId") Long currentUserId);

   List<ProductionLineDO> productionLineList(
      @Param("factoryId") Long factoryId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("productType") Integer productType
   );

   List<MesBuildingProductionLineSumDO> selectProductLine(
      @Param("factoryId") String factoryId,
      @Param("workshopId") String workshopId,
      @Param("productionLineId") String productionLineId,
      @Param("productType") int productType
   );

   List<MesBuildingProductionLineSumDO> selectProductLineByids(@Param("lineIds") Set<Long> lineIds);

   List<MesBuildingFactoryDTO> getSchedulingLineTree(@Param("doParam") MesBuildingTeamDOParam doParam, @Param("type") Integer type);

   List<MesBuildingFactoryDTO> getEnclosureSchedulingLineTree(@Param("doParam") MesBuildingTeamDOParam doParam, @Param("type") Integer type);

   List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary(MesBuildingArtifactSchedulingDOParam dtoParam);

   List<ProductLineDetailDTO> getTreeByLineIds(@Param("lineIds") List<Long> lineIds);

   ProductLineDetailDTO getTreeByLineId(@Param("lineId") Long lineId);

   List<GroupDetailDTO> getWorkShopAndProductionLineList(
      @Param("productType") Integer productType, @Param("structureClassId") Long structureClassId, @Param("mesProductEnum") Integer mesProductEnum
   );

   List<ProductionLineSchedulingInfoDTO> productionLineSchedulingInfo(
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workshopId,
      @Param("productType") Integer productType,
      @Param("typeId") Integer typeId,
      @Param("type") Integer type
   );

   List<SchedulingInfoDTO> findLineSchedulingInfo(
      @Param("projectId") Long projectId, @Param("workshopId") Long workshopId, @Param("productType") Integer productType, @Param("typeId") Integer typeId
   );

   List<ArtifactSchedulingLineInfoDTO> getArtifactSchedulingLineInfoSummaryV8(Long areaId);
}
