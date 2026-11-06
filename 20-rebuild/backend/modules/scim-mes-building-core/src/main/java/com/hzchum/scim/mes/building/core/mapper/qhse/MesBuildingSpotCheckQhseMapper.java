package com.hzchum.scim.mes.building.core.mapper.qhse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingSpotCheckQhse;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDetailDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingSpotCheckQhseMapper extends BaseMapper<MesBuildingSpotCheckQhse> {
   List<MesBuildingSpotStatisticsCountDTO> findSpotCheckList(
      @Param("projectId") Long projectId, @Param("projectName") String projectName, @Param("userName") String userName
   );

   List<MesBuildingSpotStatisticsCountDTO> findMonomerSpotCheckList(@Param("projectIds") List<Long> projectIds, @Param("userName") String userName);

   List<MesBuildingSpotStatisticsCountDetailDTO> findSpotCheckDetailList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("userName") String userName,
      @Param("monomerName") String monomerName,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification
   );
}
