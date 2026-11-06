package com.hzchum.scim.mes.building.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.ProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingLineSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingProductionLineDTOParam;
import java.util.List;
import java.util.Set;

public interface MesBuildingProductionLineService extends IService<MesBuildingProductionLine> {
   PageVO<MesBuildingProductionLineDTO> productionLinePage(MesBuildingProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   List<MesBuildingProductionLineDTO> listByCondition(MesBuildingProductionLineDTOParam dtoParam);

   List<DistributionDO> listByCondition(Long factory, Long workshopId);

   ListVO<NameInfo> listProductionLineSimple(Long workshopId);

   ListVO<NameInfo> listProductionLineUser(Long workshopId);

   List<ProductionLineDO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType);

   List<MesBuildingProductionLineSumDO> selectProductLine(String factoryId, String workShopId, String productionLineId, int type);

   List<MesBuildingProductionLineSumDO> selectProductLineByids(Set<Long> lineIds);

   List<MesBuildingFactoryDTO> getSchedulingLineTree(MesBuildingTeamDOParam copy, Integer type);

   List<MesBuildingFactoryDTO> getEnclosureSchedulingLineTree(MesBuildingTeamDOParam copy, Integer type);

   List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary(MesBuildingArtifactSchedulingDOParam copy);

   List<ProductLineDetailDTO> getTreeByLineIds(List<Long> lineIds);

   ProductLineDetailDTO getTreeByLineId(Long lineId);
}
