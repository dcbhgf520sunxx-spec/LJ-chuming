package com.hzchum.scim.rest.controller.largeScreen;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutSendEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesBuildingBoChuNestingResultInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.rest.pojo.request.large_screen.KanbanQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "切割任务看板大屏")
@RestController
@RequestMapping("/api/large-screen/cutting-task-kanban")
public class CuttingTaskKanbanLargeScreenController {
   private static final Logger log = LoggerFactory.getLogger(CuttingTaskKanbanLargeScreenController.class);
   @Autowired
   private MesBuildingBoChuNestingResultService nestingResultService;
   @Autowired
   private InitializationService service;
   @Autowired
   private ContractProjectService projectService;

   @ApiOperation("车间机床树")
   @GetMapping("workshop-machine-tool-tree")
   public ResultVO workshopMachineToolTree() {
      log.info("API调用: 切割任务看板大屏-车间机床树");
      String sql = "SELECT   workshop.id AS workshopId,   workshop.name AS workshopName,   mbmptd.mid,   mbmptd.device_name AS deviceName FROM mes_building_machine_part_team_detail mbmptd LEFT JOIN mes_building_production_line mbpl ON mbpl.bool_delete_enum = 0 AND mbpl.id = mbmptd.production_line_id LEFT JOIN mes_building_workshop workshop ON workshop.bool_delete_enum = 0 AND workshop.id = mbpl.workshop_id WHERE mbmptd.bool_delete_enum = 0 AND IFNULL(mbmptd.mid, '') != ''";
      List<JSONObject> resultList = this.service
         .selectList(sql)
         .stream()
         .collect(Collectors.groupingBy(k -> k.getLong("workshopId")))
         .values()
         .stream()
         .filter(CollUtil::isNotEmpty)
         .map(jsonObjects -> {
            List<JSONObject> machineToolList = jsonObjects.stream().map(v -> {
               JSONObject vj = new JSONObject();
               vj.put("mid", v.getString("mid"));
               vj.put("name", v.getString("deviceName"));
               vj.put("workshopId", v.getString("workshopId"));
               return vj;
            }).collect(Collectors.toList());
            JSONObject first = jsonObjects.get(0);
            JSONObject workshop = new JSONObject();
            workshop.put("id", first.getString("workshopId"));
            workshop.put("name", first.getString("workshopName"));
            workshop.put("machineToolList", machineToolList);
            return workshop;
         })
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("实时作业任务")
   @GetMapping("real-time-job-task")
   public ResultVO realTimeJobTask(KanbanQuery query) {
      log.info("API调用: 切割任务看板大屏-实时作业任务");
      JSONObject result = new JSONObject();
      result.put("todayJobVolume", 0);
      result.put("todayJobCompleteVolume", 0);
      result.put("completeRate", 0);
      if (StrUtil.isBlank(query.getMid())) {
         return ResultBuilder.success(result);
      }

      List<MesBuildingBoChuNestingResultInfoDTO> nestingResultInfoDTOList = this.nestingResultService
         .listByQueryCondition(
            NestingResultQuery.builder().cutSendStatus(CutSendEnum.DISPATCHED.getCode()).mid(query.getMid()).cutSendTimeStart(LocalDateTime.now()).build()
         );
      if (CollUtil.isEmpty(nestingResultInfoDTOList)) {
         return ResultBuilder.success(result);
      }

      BigDecimal todayJobVolume = nestingResultInfoDTOList.stream()
         .map(
            nr -> nr.getPartList()
               .stream()
               .map(
                  part -> BigDecimal.valueOf(part.getQuantity().intValue())
                     .multiply(part.getNetWeight())
                     .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
               )
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<MesBuildingBoChuNestingResultInfoDTO> collect = nestingResultInfoDTOList.stream()
         .filter(nr -> ObjectUtil.equals(nr.getCutStatus(), CutStatusEnum.CUT_COMPLETED.getCode()))
         .collect(Collectors.toList());
      collect.forEach(System.out::println);
      BigDecimal todayJobCompleteVolume = nestingResultInfoDTOList.stream()
         .filter(nr -> ObjectUtil.equals(nr.getCutStatus(), CutStatusEnum.CUT_COMPLETED.getCode()))
         .map(
            nr -> nr.getPartList()
               .stream()
               .map(
                  part -> BigDecimal.valueOf(part.getQuantity().intValue())
                     .multiply(part.getNetWeight())
                     .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
               )
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal completeRate = Optional.of(todayJobVolume)
         .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
         .map(o -> todayJobCompleteVolume.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
         .orElse(BigDecimal.ZERO);
      result.put("todayJobVolume", todayJobVolume);
      result.put("todayJobCompleteVolume", todayJobCompleteVolume);
      result.put("completeRate", completeRate);
      return ResultBuilder.success(result);
   }

   @ApiOperation("任务状态")
   @GetMapping("task-status")
   public ResultVO taskStatus(KanbanQuery query) {
      log.info("API调用: 切割任务看板大屏-任务状态");
      if (StrUtil.isBlank(query.getMid())) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<MesBuildingBoChuNestingResultInfoDTO> nestingResultInfoDTOList = this.nestingResultService
         .listByQueryCondition(
            NestingResultQuery.builder().cutSendStatus(CutSendEnum.DISPATCHED.getCode()).mid(query.getMid()).cutSendTimeStart(LocalDateTime.now()).build()
         );
      if (CollUtil.isEmpty(nestingResultInfoDTOList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<JSONObject> resultList = nestingResultInfoDTOList.stream().map(nr -> {
         JSONObject result = new JSONObject();
         result.put("programNumber", StrUtil.subBefore(nr.getFileName(), ".", true));
         boolean status = ObjectUtil.equals(nr.getCutStatus(), CutStatusEnum.CUT_COMPLETED.getCode());
         result.put("status", status);
         return result;
      }).collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("今日完成项目")
   @GetMapping("today-complete-project")
   public ResultVO todayCompleteProject(KanbanQuery query) {
      log.info("API调用: 切割任务看板大屏-今日完成项目");
      if (StrUtil.isBlank(query.getMid())) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<MesBuildingBoChuNestingResultInfoDTO> nestingResultInfoDTOList = this.nestingResultService
         .listByQueryCondition(
            NestingResultQuery.builder()
               .cutSendStatus(CutSendEnum.DISPATCHED.getCode())
               .cutStatus(CutStatusEnum.CUT_COMPLETED.getCode())
               .mid(query.getMid())
               .cutSendTimeStart(LocalDateTime.now())
               .build()
         );
      if (CollUtil.isEmpty(nestingResultInfoDTOList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = nestingResultInfoDTOList.stream()
         .map(MesBuildingBoChuNestingResultInfoDTO::getProjectId)
         .filter(ObjectUtil::isNotNull)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = Optional.of(projectIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.projectService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Long, BigDecimal> projectCompleteVolumeMap = nestingResultInfoDTOList.stream()
         .filter(nr -> ObjectUtil.isNotNull(nr.getProjectId()))
         .collect(
            Collectors.groupingBy(
               MesBuildingBoChuNestingResultInfoDTO::getProjectId,
               Collectors.mapping(
                  nr -> nr.getPartList()
                     .stream()
                     .map(
                        part -> BigDecimal.valueOf(part.getQuantity().intValue())
                           .multiply(part.getNetWeight())
                           .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                     )
                     .reduce(BigDecimal.ZERO, BigDecimal::add),
                  Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      BigDecimal totalCompleteVolume = projectCompleteVolumeMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
      List<JSONObject> resultList = projectCompleteVolumeMap.entrySet()
         .stream()
         .map(
            entry -> {
               ContractProject project = projectMap.get(entry.getKey());
               if (BeanUtil.isEmpty(project)) {
                  return null;
               }

               JSONObject result = new JSONObject();
               result.put("projectId", project.getId());
               result.put("projectName", project.getName());
               result.put("projectShortName", project.getShortName());
               result.put("projectSerialNumber", project.getSerialNumber());
               BigDecimal completeRate = Optional.of(totalCompleteVolume)
                  .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
                  .map(o -> ((BigDecimal)entry.getValue()).divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               result.put("completeRate", completeRate);
               return result;
            }
         )
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("近12个月产量统计")
   @GetMapping("recent-12-month-production-statistics")
   public ResultVO recent12MonthProductionStatistics(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-近12个月产量统计");
      JSONObject result = new JSONObject();
      if (StrUtil.isBlank(query.getMid())) {
         return ResultBuilder.success(result);
      }

      LocalDateTime now = LocalDateTime.now();
      List<MesBuildingBoChuNestingResultInfoDTO> nestingResultInfoDTOList = this.nestingResultService
         .listByQueryCondition(
            NestingResultQuery.builder()
               .cutSendStatus(CutSendEnum.DISPATCHED.getCode())
               .cutStatus(CutStatusEnum.CUT_COMPLETED.getCode())
               .mid(query.getMid())
               .cutSendTimeStart(now.minusMonths(11L))
               .cutSendTimeFormat("%Y-%m")
               .build()
         );
      if (CollUtil.isEmpty(nestingResultInfoDTOList)) {
         return ResultBuilder.success(result);
      }

      Map<String, BigDecimal> yearMonthCompleteVolumeMap = nestingResultInfoDTOList.stream()
         .collect(
            Collectors.groupingBy(
               k -> k.getCutSendTime().format(DateTimeFormatter.ofPattern("yy-MM")),
               Collectors.mapping(
                  nr -> nr.getPartList()
                     .stream()
                     .map(
                        part -> BigDecimal.valueOf(part.getQuantity().intValue())
                           .multiply(part.getNetWeight())
                           .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                     )
                     .reduce(BigDecimal.ZERO, BigDecimal::add),
                  Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      BigDecimal totalCompleteVolume = yearMonthCompleteVolumeMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
      List<JSONObject> yearMonthCompleteVolumeList = new ArrayList<>();

      for (int i = 11; i >= 0; i--) {
         String yearMonth = now.minusMonths(i).format(DateTimeFormatter.ofPattern("yy-MM"));
         BigDecimal completeVolume = yearMonthCompleteVolumeMap.getOrDefault(yearMonth, BigDecimal.ZERO);
         JSONObject yearMonthCompleteVolume = new JSONObject();
         yearMonthCompleteVolume.put("yearMonth", yearMonth);
         yearMonthCompleteVolume.put("completeVolume", completeVolume);
         yearMonthCompleteVolumeList.add(yearMonthCompleteVolume);
      }

      result.put("totalCompleteVolume", totalCompleteVolume);
      result.put("yearMonthCompleteVolumeList", yearMonthCompleteVolumeList);
      return ResultBuilder.success(result);
   }
}
