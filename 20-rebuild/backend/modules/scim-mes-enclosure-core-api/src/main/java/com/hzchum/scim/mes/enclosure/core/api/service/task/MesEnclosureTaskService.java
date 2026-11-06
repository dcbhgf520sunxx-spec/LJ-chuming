package com.hzchum.scim.mes.enclosure.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.TaskProductDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import java.util.List;

public interface MesEnclosureTaskService extends IService<MesEnclosureTask> {
   Boolean checkStatus(Long productionLine);

   List<TaskProductDetailDTO> listAllProductDetail();

   List<AppEnclosureTaskDTO> listTasks(Long projectId, Long areaId, String serialNumber, Long taskOrderId, List<Long> teamIds, List<Long> projectIds);

   List<AppEnclosureTaskDTO> listTasksV2(Long projectId, Long areaId, String serialNumber, Long taskOrderId, List<Long> teamIds, List<Long> projectIds);

   List<MesEnclosureTask> findProductReportCountByOrderId(Long orderId);

   List<ProjectProductDTO> getEnclosureTaskDetails(Long areaId, Long processId);
}
