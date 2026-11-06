package com.hzchum.scim.mes.building.core.mapper._package;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionQuerySumDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingPackageLinkMapper extends BaseMapper<MesBuildingPackageLink> {
   List<ArtifactDetailDO> listArtifactDetailsByPackageId(Long packageId);

   List<SendDirectlyDetailDO> listPartDetailsByPackageId(Long packageId);

   List<SendDirectlyDetailDO> listAssembleDetailsByPackageId(Long packageId);

   List<EnclosureDetailDO> listEnclosureDetailsByPackageId(Long packageId);

   List<TechStandardPartDetailDO> listAuxiliaryMaterialDetailsByPackageId(Long packageId);

   List<MesDailyProductionQuerySumDTO> getArtifactPackSumMete(
      @Param("workShopIds") List<Long> workShopIds,
      @Param("meteUnitEnum") Integer meteUnitEnum,
      @Param("projectId") Long projectId,
      @Param("dateTime") LocalDateTime dateTime
   );

   List<ArtifactBaseInfo> getArtifactPackDetailMete(
      @Param("workShopIds") List<Long> workShopIds, @Param("projectId") Long projectId, @Param("dateTime") LocalDateTime dateTime
   );
}
