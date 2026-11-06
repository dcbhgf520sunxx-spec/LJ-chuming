package com.hzchum.scim.mes.building.core.service.impl._package;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionQuerySumDTO;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.mapper._package.MesBuildingPackageLinkMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingPackageLinkServiceImpl
   extends ServiceImpl<MesBuildingPackageLinkMapper, MesBuildingPackageLink>
   implements MesBuildingPackageLinkService {
   @Override
   public List<ArtifactDetailDO> listArtifactDetailsByPackageId(Long packageId) {
      return this.baseMapper.listArtifactDetailsByPackageId(packageId);
   }

   @Override
   public List<SendDirectlyDetailDO> listPartDetailsByPackageId(Long packageId) {
      return this.baseMapper.listPartDetailsByPackageId(packageId);
   }

   @Override
   public List<SendDirectlyDetailDO> listAssembleDetailsByPackageId(Long packageId) {
      return this.baseMapper.listAssembleDetailsByPackageId(packageId);
   }

   @Override
   public List<EnclosureDetailDO> listEnclosureDetailsByPackageId(Long packageId) {
      return this.baseMapper.listEnclosureDetailsByPackageId(packageId);
   }

   @Override
   public List<TechStandardPartDetailDO> listAuxiliaryMaterialDetailsByPackageId(Long packageId) {
      return this.baseMapper.listAuxiliaryMaterialDetailsByPackageId(packageId);
   }

   @Override
   public List<MesDailyProductionQuerySumDTO> getArtifactPackSumMete(List<Long> workShopIds, Integer meteUnitEnum, Long projectId, LocalDateTime dateTime) {
      return this.baseMapper.getArtifactPackSumMete(workShopIds, meteUnitEnum, projectId, dateTime);
   }

   @Override
   public List<ArtifactBaseInfo> getArtifactPackDetailMete(List<Long> workShopIds, Long projectId, LocalDateTime dateTime) {
      return this.baseMapper.getArtifactPackDetailMete(workShopIds, projectId, dateTime);
   }
}
