package com.hzchum.scim.mes.building.core.api.biz._package;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageLinkDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageAddDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageUpdateDTOParam;
import java.util.List;

public interface MesBuildingPackageBiz {
   PageVO<PackageDTO> packagePage(MesBuildingPackageDOParam param);

   PackageLinkDetailsDTO getDetailById(Long id);

   ListVO<PackageLinkDetailsDTO> getDetailByProjectId(Long projectId, Integer productType);

   PrintVO printDetailById(Long id);

   PackageDTO getPackageInfo(Long packageId);

   Boolean savePackage(MesBuildingPackageDTOParam doParam);

   Boolean addPackage(MesBuildingPackageAddDTOParam dtoParam);

   Boolean updatePackage(MesBuildingPackageUpdateDTOParam dtoParam);

   Boolean deletePackage(List<Long> ids);

   ProductSumInfoDTO getInfoByPackageId(Long packageId);
}
