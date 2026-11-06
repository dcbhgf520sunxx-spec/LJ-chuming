package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingProductionLineTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ArtifactSchedulingLineInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductionLineSchedulingInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingLineSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingProductionLineDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import java.util.List;
import java.util.Set;

public interface MesBuildingProductionLineBiz extends IBiz<MesBuildingProductionLine> {
   Boolean productionLineUpdateState(MesBuildingProductionLineDTOParam dtoParam);

   Boolean saveProductionLine(MesBuildingProductionLineDTOParam dtoParam);

   Boolean removeByIds(List<Long> ids);

   List<ProductionLineDTO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType);

   List<IdAndNameDTO> getTypeByProductType(Integer productType, Integer productionLineTypeEnum);

   PageVO<MesBuildingProductionLineDTO> productionLinePage(MesBuildingProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   List<MesBuildingProductionLineDTO> listByCondition(MesBuildingProductionLineDTOParam dtoParam);

   Boolean update(MesBuildingProductionLineDTOParam dtoParam);

   List<MesBuildingProductionLineSumDO> selectProductLine(
      String factoryId, String workShopId, String productionLineId, Integer pageNumber, Integer pageSize, int type
   );

   MesBuildingProductionLine selectByid(Long productionLineId);

   List<MesBuildingProductionLineSumDO> selectProductLineByids(Set<Long> lineIds);

   List<String> productionLineByNameList(MesBuildingProductionLineDTOParam dtoParam);

   List<MesBuildingFactoryDTO> getSchedulingLineTree(MesBuildingTeamDTOParam dtoParam, Integer type);

   List<ProductionLineSchedulingInfoDTO> getProductionLineSchedulingInfoV8(LineSchedulingInfoDTOParam dtoParam, Integer type);

   List<MesBuildingFactoryDTO> getEnclosureSchedulingLineTree(MesBuildingTeamDTOParam dtoParam);

   List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary2(MesBuildingArtifactSchedulingDTOParam dtoParam);

   List<MesBuildingProductionLine> getProdLinesList(Long userId, Boolean teamType);

   List<MesBuildingProductionLineTreeDO> getInspectTeamLink(List<Long> inspectConfigIds);

   Boolean saveTeam(Long id, List<Long> teamIds, Boolean teamType);

   List<GroupDetailDTO> getWorkShopAndProductionLineList(Integer productType, Long structureClassId, Integer mesProductEnum);

   List<ArtifactSchedulingLineInfoDTO> getArtifactSchedulingLineInfoSummaryV8(Long areaId);
}
