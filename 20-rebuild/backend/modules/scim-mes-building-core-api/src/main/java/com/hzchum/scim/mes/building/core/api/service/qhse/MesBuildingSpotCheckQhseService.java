package com.hzchum.scim.mes.building.core.api.service.qhse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingSpotCheckQhse;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDetailDTO;
import java.util.List;

public interface MesBuildingSpotCheckQhseService extends IService<MesBuildingSpotCheckQhse> {
   List<MesBuildingSpotStatisticsCountDTO> findSpotCheckList(Long projectId, String projectName, String userName);

   List<MesBuildingSpotStatisticsCountDTO> findMonomerSpotCheckList(List<Long> projectIds, String userName);

   List<MesBuildingSpotStatisticsCountDetailDTO> findSpotCheckDetailList(
      Long projectId, Long monomerId, String userName, String monomerName, String name, String serialNumber, String specification
   );
}
