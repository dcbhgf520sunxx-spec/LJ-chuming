package com.hzchum.scim.plan.core.mapper.production_scheduling;

import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingWorkshopDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingWorkshopSchedulingDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.NotSchedulingArtifactDTO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ListSchedulingMapper {
   List<ListSchedulingProjectDTO> projectList(
      @Param("year") Integer year, @Param("schedulingStatus") Integer schedulingStatus, @Param("projectNoOrName") Long projectNoOrName
   );

   List<ListSchedulingWorkshopDTO> workshopList(@Param("projectId") Long projectId, @Param("listTotalWeight") BigDecimal listTotalWeight);

   List<ListSchedulingWorkshopSchedulingDetailDTO> workshopSchedulingDetailList(
      @Param("projectId") Long projectId,
      @Param("productionWay") Integer productionWay,
      @Param("workshopId") Long workshopId,
      @Param("boolScheduling") Boolean boolScheduling
   );

   List<NotSchedulingArtifactDTO> notSchedulingList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("artifactClassId") Long artifactClassId,
      @Param("artifactNoOrName") Long artifactNoOrName
   );
}
