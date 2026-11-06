package com.hzchum.scim.mes.building.core.api.service._package;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingPackageService extends IService<MesBuildingPackage> {
   List<PackageDetailDO> listByPackageIds(List<Long> packageIds);

   PageVO<PackageDO> packagePage(MesBuildingPackageDOParam copy);

   List<PackageDO> listByProjectId(Long projectId);

   Integer countByDate(Long projectId, LocalDateTime now);

   void setStatus(Long packageId, Integer status);
}
