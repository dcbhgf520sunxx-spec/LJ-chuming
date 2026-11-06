package com.hzchum.scim.mes.enclosure.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.TaskProductDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopMonthAndMeteDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopSummaryDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.EnclosureTaskPrintDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureTaskMapper extends BaseMapper<MesEnclosureTask> {
   List<TaskProductDetailDTO> listAllProductDetail();

   List<AppEnclosureTaskDTO> listTasks(
      @Param("projectId") Long projectId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("teamIds") List<Long> teamIds,
      @Param("projectIds") List<Long> projectIds
   );

   List<AppEnclosureTaskDTO> listTasksV2(
      @Param("projectId") Long projectId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("teamIds") List<Long> teamIds,
      @Param("projectIds") List<Long> projectIds
   );

   List<WorkshopMonthAndMeteDTO> getYearList(@Param("dateTime") LocalDateTime dateTime, @Param("type") Integer type, @Param("category") Integer category);

   List<WorkshopMonthAndMeteDTO> getYearListV2(
      @Param("dateTime") LocalDateTime dateTime, @Param("type") Integer type, @Param("dictionaryId") Integer dictionaryId
   );

   List<WorkshopSummaryDTO> getOverviewDetail(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("projectId") Long projectId,
      @Param("category") Integer category
   );

   List<WorkshopSummaryDTO> getOverviewDetailV2(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("projectId") Long projectId,
      @Param("dictionaryId") Long dictionaryId
   );

   BigDecimal getOverviewTotal(@Param("time") LocalDateTime time, @Param("category") Integer category);

   BigDecimal getOverviewTotalV2(@Param("time") LocalDateTime time, @Param("dictionaryId") Integer dictionaryId);

   List<TeamProduceDTO> getTeamProduce(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("category") LocalDateTime category,
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime
   );

   List<EnclosureTaskPrintDTO> listEnclosurePrint(
      @Param("projectId") Long projectId,
      @Param("planId") Long planId,
      @Param("category") Integer category,
      @Param("lineId") Long lineId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("warehousingStatusEnum") Integer warehousingStatusEnum
   );

   AppEnclosureTaskDTO taskByTaskId(@Param("id") Long id);

   List<MesEnclosureTask> findProductReportCountByOrderId(@Param("orderId") Long orderId);

   List<ProjectProductDTO> getEnclosureTaskDetails(Long areaId, Long processId);
}
