package com.hzchum.scim.mes.building.core.api.service._package;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionQuerySumDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingPackageLinkService extends IService<MesBuildingPackageLink> {
   List<ArtifactDetailDO> listArtifactDetailsByPackageId(Long packageId);

   List<SendDirectlyDetailDO> listPartDetailsByPackageId(Long packageId);

   List<SendDirectlyDetailDO> listAssembleDetailsByPackageId(Long packageId);

   List<EnclosureDetailDO> listEnclosureDetailsByPackageId(Long packageId);

   List<TechStandardPartDetailDO> listAuxiliaryMaterialDetailsByPackageId(Long packageId);

   List<MesDailyProductionQuerySumDTO> getArtifactPackSumMete(List<Long> workShopIds, Integer meteUnitEnum, Long projectId, LocalDateTime dateTime);

   List<ArtifactBaseInfo> getArtifactPackDetailMete(List<Long> workShopIds, Long projectId, LocalDateTime dateTime);
}
