package com.hzchum.scim.plan.core.api.biz.production_scheduling;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingWorkshopDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingWorkshopSchedulingDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.NotSchedulingArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.production_scheduling.ListSchedulingSaveParam;
import java.util.List;

public interface ListSchedulingBiz {
   PageVO<ListSchedulingProjectDTO> projectList(
      Integer year, Integer schedulingStatus, Long projectNoOrName, Integer pageNumber, Integer pageSize, List<String> sort
   );

   List<ListSchedulingWorkshopDTO> workshopList(Long projectId);

   PageVO<NotSchedulingArtifactDTO> notSchedulingList(
      Long projectId, Long monomerId, Long areaId, Long artifactClassId, Long artifactNoOrName, Integer pageNumber, Integer pageSize, List<String> sort
   );

   Boolean batchSave(List<ListSchedulingSaveParam> params);

   PageVO<ListSchedulingWorkshopSchedulingDetailDTO> workshopSchedulingDetailPage(
      Long projectId, Integer productionWay, Long workshopId, Boolean boolScheduling, Integer pageNumber, Integer pageSize, List<String> sort
   );

   Boolean beforehandSchedulingBatchUpdate(List<ListSchedulingSaveParam> params);
}
