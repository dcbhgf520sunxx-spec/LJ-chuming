package com.hzchum.scim.rest.controller.largeScreen;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.largesreen.CompleteLargeScreenService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ArtifactCompleteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.DateAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = " 齐套大屏接口")
@RestController
@RequestMapping("/api/complete/largeScreen")
public class CompleteLargeScreenController {
   private static final Logger log = LoggerFactory.getLogger(CompleteLargeScreenController.class);
   @Autowired
   private CompleteLargeScreenService completeLargeScreenService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private InitializationService service;

   @ApiOperation("齐套看板-统计数据")
   @GetMapping("/statistics")
   public ResultVO<?> statistics(
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(defaultValue = "拼装") String processName
   ) {
      log.info("API 调用 ：齐套看板-统计数据");
      Map<String, Object> resultMap = new HashMap<>();
      List<Long> processIdList = this.processService
         .lambdaQuery()
         .in(MesBuildingProcess::getName, StrUtil.splitTrim(processName, ","))
         .list()
         .stream()
         .map(MesBuildingProcess::getId)
         .filter(ObjectUtil::isNotNull)
         .distinct()
         .collect(Collectors.toList());
      if (CollUtil.isEmpty(processIdList)) {
         return ResultBuilder.success(resultMap);
      }

      String param0 = CollUtil.join(processIdList, ",");
      String param1 = Optional.ofNullable(workshopId).map(o -> "AND mbtp.workshop_id = " + o).orElse("");
      String param2 = Optional.ofNullable(teamId).map(o -> "AND mbtp.team_id = " + o).orElse("");
      String sql1 = "SELECT  IFNULL((SUM((mbtp.task_quantity - mbtp.inspection_quantity) * IFNULL(artt.net_weight, 0)) / 1000), 0) AS onHandTaskVolume FROM mes_building_task_process mbtp LEFT JOIN tech_artifact artt ON artt.bool_delete_enum = 0 AND artt.id = mbtp.product_id WHERE mbtp.bool_delete_enum = 0 AND mbtp.task_type_enum = 2 AND mbtp.task_quantity > mbtp.inspection_quantity     AND mbtp.process_id IN ({0})     {1}     {2} ";
      BigDecimal onHandTaskVolume = this.service
         .selectList(StrUtil.indexedFormat(sql1, param0, param1, param2))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj)
         .getBigDecimal("onHandTaskVolume", BigDecimal.ZERO)
         .setScale(2, RoundingMode.HALF_UP);
      resultMap.put("在手任务", onHandTaskVolume);
      String sql2 = "SELECT  IFNULL(SUM(mbc.quantity * IFNULL(artt.net_weight, 0)) / 1000, 0) AS productionVolume FROM mes_building_complete mbc left join mes_building_task_process mbtp ON mbtp.bool_delete_enum = 0 AND mbtp.task_id = mbc.task_id left join tech_artifact artt ON artt.bool_delete_enum = 0 AND artt.id = mbc.product_id WHERE mbc.bool_delete_enum = 0 AND mbc.task_type_enum = 2     AND mbtp.process_id IN ({0})     {1}     {2}     {3} ";
      LocalDate now = LocalDate.now();
      String param3 = "";
      param3 = "AND YEAR(mbc.create_time) = " + now.getYear();
      BigDecimal thisYearProductionVolume = this.service
         .selectList(StrUtil.indexedFormat(sql2, param0, param1, param2, param3))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj)
         .getBigDecimal("productionVolume", BigDecimal.ZERO)
         .setScale(2, RoundingMode.HALF_UP);
      resultMap.put("当年产量", thisYearProductionVolume);
      param3 = "AND mbc.in_year_month_date = '" + now.format(DatePattern.NORM_MONTH_FORMATTER) + "'";
      BigDecimal thisMonthProductionVolume = this.service
         .selectList(StrUtil.indexedFormat(sql2, param0, param1, param2, param3))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj)
         .getBigDecimal("productionVolume", BigDecimal.ZERO)
         .setScale(2, RoundingMode.HALF_UP);
      resultMap.put("本月产量", thisMonthProductionVolume);
      param3 = "AND YEARWEEK(mbc.create_time, 3) = YEARWEEK('" + now + "', 3)";
      BigDecimal thisWeekProductionVolume = this.service
         .selectList(StrUtil.indexedFormat(sql2, param0, param1, param2, param3))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj)
         .getBigDecimal("productionVolume", BigDecimal.ZERO)
         .setScale(2, RoundingMode.HALF_UP);
      resultMap.put("本周产量", thisWeekProductionVolume);
      BigDecimal monthlyAverageProductionVolume = thisYearProductionVolume.divide(BigDecimal.valueOf(now.getMonthValue()), 2, RoundingMode.HALF_UP);
      resultMap.put("月度平均产能", monthlyAverageProductionVolume);
      String sql3 = "SELECT  IFNULL(SUM(IF(mt.completeSetQuantity > mt.artifactQuantity, mt.artifactQuantity, mt.completeSetQuantity)), 0) AS completeSetQuantity,  (IFNULL(SUM(IF(mt.completeSetQuantity > mt.artifactQuantity, mt.artifactQuantity, mt.completeSetQuantity) * IFNULL(artifact.net_weight, 0)), 0) / 1000) AS completeSetWeight FROM (  SELECT   t1.artifactId,   t1.artifactQuantity,   IF(IFNULL(t2.completeSetQuantity, t1.artifactQuantity) > IFNULL(t3.completeSetQuantity, t1.artifactQuantity),      IFNULL(t3.completeSetQuantity, t1.artifactQuantity),      IFNULL(t2.completeSetQuantity, t1.artifactQuantity)) AS completeSetQuantity  FROM (   SELECT    mbtp.product_id AS artifactId,    SUM(IFNULL(mbtp.task_quantity - mbtp.inspection_quantity, 0)) AS artifactQuantity   FROM mes_building_task_process mbtp   WHERE mbtp.bool_delete_enum = 0 AND mbtp.task_type_enum = 2 AND mbtp.task_quantity > mbtp.inspection_quantity     AND mbtp.process_id IN ({0})     {1}     {2}   GROUP BY mbtp.product_id  ) t1  LEFT JOIN (    SELECT     tampl.artifact_id AS artifactId,     MIN(((IFNULL(tmp.produced_quantity, 0) - IFNULL(tmp.used_quantity, 0)) DIV tampl.quantity)) AS completeSetQuantity    FROM tech_artifact_machine_part_link tampl    LEFT JOIN tech_machine_part tmp ON tmp.bool_delete_enum = 0 AND tmp.id = tampl.machine_part_id    GROUP BY tampl.artifact_id   ) t2 ON t2.artifactId = t1.artifactId  LEFT JOIN (    SELECT     tad.artifact_id AS artifactId,     MIN(((IFNULL(asse.produced_quantity, 0) - IFNULL(asse.used_quantity, 0)) DIV tad.quantity)) AS completeSetQuantity    FROM tech_assemble_detail tad    LEFT JOIN tech_assemble asse ON asse.bool_delete_enum = 0 AND asse.id = tad.assemble_id    GROUP BY tad.artifact_id   ) t3 ON t3.artifactId = t1.artifactId ) mt LEFT JOIN tech_artifact artifact ON artifact.bool_delete_enum = 0 AND artifact.id = mt.artifactId ";
      cn.hutool.json.JSONObject completeSetResult = this.service
         .selectList(StrUtil.indexedFormat(sql3, param0, param1, param2))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj);
      BigDecimal completeSetWeight = completeSetResult.getBigDecimal("completeSetWeight", BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
      resultMap.put("齐套重量", completeSetWeight);
      BigDecimal completeSetQuantity = completeSetResult.getBigDecimal("completeSetQuantity", BigDecimal.ZERO);
      resultMap.put("齐套数量", completeSetQuantity);
      String sql4 = " SELECT   IFNULL(SUM(IFNULL(mbtp.problem_quantity, 1)), 0) AS quantity  FROM mes_building_qhse mbtp  WHERE mbtp.bool_delete_enum = 0 AND mbtp.type IN (1, 8) AND mbtp.task_type_enum = 2     AND mbtp.process_id IN ({0})     {1}     {2} ";
      BigDecimal totalProblemQuantity = this.service
         .selectList(StrUtil.indexedFormat(sql4, param0, param1, param2))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj)
         .getBigDecimal("quantity", BigDecimal.ZERO);
      String sql5 = "SELECT    IFNULL(SUM(tr.inspection_quantity), 0) AS quantity   FROM mes_building_produce_team_report tr   LEFT JOIN mes_building_task_process mbtp ON tr.task_id = mbtp.task_id AND mbtp.bool_delete_enum = 0   WHERE tr.bool_delete_enum = 0 AND mbtp.task_type_enum = 2     AND mbtp.process_id IN ({0})     {1}     {2} ";
      BigDecimal inspectionQuantity = this.service
         .selectList(StrUtil.indexedFormat(sql5, param0, param1, param2))
         .stream()
         .findFirst()
         .map(JSONUtil::parseObj)
         .orElseGet(JSONUtil::createObj)
         .getBigDecimal("quantity", BigDecimal.ZERO);
      BigDecimal firstTimeQualityInspectionPassRate = Optional.ofNullable(inspectionQuantity)
         .filter(o -> o.compareTo(BigDecimal.ZERO) > 0)
         .map(o -> inspectionQuantity.subtract(totalProblemQuantity).divide(inspectionQuantity, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
         .orElse(BigDecimal.valueOf(100L));
      resultMap.put("一次质检合格率", firstTimeQualityInspectionPassRate);
      return ResultBuilder.success(resultMap);
   }

   @ApiOperation("构件月产量分析")
   @GetMapping("/monthlyOutput")
   public ResultVO<?> monthlyOutput(
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(defaultValue = "拼装") String processName
   ) {
      log.info("API 调用 ：构件月产量分析");
      List<Long> processIdList = this.processService
         .lambdaQuery()
         .in(MesBuildingProcess::getName, StrUtil.splitTrim(processName, ","))
         .list()
         .stream()
         .map(MesBuildingProcess::getId)
         .filter(ObjectUtil::isNotNull)
         .distinct()
         .collect(Collectors.toList());
      if (CollUtil.isEmpty(processIdList)) {
         return ResultBuilder.success(Collections.EMPTY_LIST);
      }

      String param0 = CollUtil.join(processIdList, ",");
      String param1 = Optional.ofNullable(workshopId).map(o -> "AND mbtp.workshop_id = " + o).orElse("");
      String param2 = Optional.ofNullable(teamId).map(o -> "AND mbtp.team_id = " + o).orElse("");
      String sql = "SELECT  mbc.in_year_month_date AS yearMonth,  IFNULL(SUM(mbc.quantity * IFNULL(artt.net_weight, 0)) / 1000, 0) AS productionVolume FROM mes_building_complete mbc LEFT JOIN mes_building_task_process mbtp ON mbtp.bool_delete_enum = 0 AND mbtp.task_id = mbc.task_id LEFT JOIN tech_artifact artt ON artt.bool_delete_enum = 0 AND artt.id = mbc.product_id WHERE mbc.bool_delete_enum = 0 AND mbc.task_type_enum = 2     AND mbtp.process_id IN ({0})     {1}     {2}     {3} GROUP BY mbc.in_year_month_date ";
      LocalDate now = LocalDate.now();
      String param3 = "AND YEAR(mbc.create_time) = " + now.getYear();
      Map<String, BigDecimal> productionVolumeMap = this.service
         .selectList(StrUtil.indexedFormat(sql, param0, param1, param2, param3))
         .stream()
         .collect(Collectors.toMap(k -> k.getString("yearMonth"), v -> v.getBigDecimal("productionVolume")));
      List<DateAndMeteDTO> list = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         YearMonth ym = YearMonth.of(now.getYear(), i);
         BigDecimal productionVolume = productionVolumeMap.getOrDefault(ym.toString(), BigDecimal.ZERO);
         DateAndMeteDTO dateAndMeteDTO = DateAndMeteDTO.builder().dateStr(String.format("%02d月", ym.getMonthValue())).value(productionVolume).build();
         list.add(dateAndMeteDTO);
      }

      return ResultBuilder.success(list);
   }

   @ApiOperation("未完成任务信息")
   @GetMapping("/unfinished/task")
   public ResultVO<?> unfinishedTask(
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(defaultValue = "拼装") String processName
   ) {
      log.info("API 调用 ：未完成任务信息");
      List<Long> processIdList = this.processService
         .lambdaQuery()
         .in(MesBuildingProcess::getName, StrUtil.splitTrim(processName, ","))
         .list()
         .stream()
         .map(MesBuildingProcess::getId)
         .filter(ObjectUtil::isNotNull)
         .distinct()
         .collect(Collectors.toList());
      String param0 = CollUtil.join(processIdList, ",");
      String param1 = Optional.ofNullable(workshopId).map(o -> "AND mbtp.workshop_id = " + o).orElse("");
      String param2 = Optional.ofNullable(teamId).map(o -> "AND mbtp.team_id = " + o).orElse("");
      String param3 = "'%Y/%m/%d'";
      String sql1 = "SELECT   mbto.project_id AS projectId,   project.name AS project,   mbtp.task_order_id AS taskOrderId,   mbto.order_number AS orderNumber,   DATE_FORMAT(mbto.ask_complete_time, {3}) AS dateStr,   IFNULL(SUM(mbtp.task_quantity), 0) AS taskQuantity,   IFNULL(SUM(mbtp.inspection_quantity), 0) AS inspectionQuantity  FROM mes_building_task_process mbtp  LEFT JOIN mes_building_task_order mbto ON mbto.bool_delete_enum = 0 AND mbto.id = mbtp.task_order_id  LEFT JOIN contract_project project ON project.bool_delete_enum = 0 AND project.id = mbto.project_id  WHERE mbtp.bool_delete_enum = 0 AND mbtp.task_type_enum = 2 AND mbtp.task_quantity > mbtp.inspection_quantity     AND mbtp.process_id IN ({0})     {1}     {2}  GROUP BY mbtp.task_order_id  ORDER BY dateStr";
      List<JSONObject> masterList = this.service
         .selectList(StrUtil.indexedFormat(sql1, param0, param1, param2, param3))
         .parallelStream()
         .peek(
            i -> {
               BigDecimal taskQuantity = i.getBigDecimal("taskQuantity");
               BigDecimal inspectionQuantity = i.getBigDecimal("inspectionQuantity");
               BigDecimal finishingRate = Optional.ofNullable(taskQuantity)
                  .filter(o -> o.compareTo(BigDecimal.ZERO) != 0)
                  .map(o -> inspectionQuantity.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               Integer unfinishedQuantity = taskQuantity.subtract(inspectionQuantity).intValue();
               ConcurrentHashMap<String, Object> safeMap = new ConcurrentHashMap<>(i);
               safeMap.put("finishingRate", finishingRate);
               safeMap.put("unfinishedQuantity", unfinishedQuantity);
               List<ArtifactCompleteDTO> artifactCompleteDTOList = this.getTaskCompleteList(workshopId, teamId, i.getLong("taskOrderId"), processName);
               Integer completeQuantity = artifactCompleteDTOList.stream().map(ArtifactCompleteDTO::getCompleteQuantity).reduce(0, Integer::sum);
               safeMap.put("completeQuantity", completeQuantity);
               i.clear();
               i.putAll(safeMap);
            }
         )
         .collect(Collectors.toList());
      masterList.sort(Comparator.comparing(ke -> {
         Integer completeQuantity = ke.getInteger("completeQuantity");
         Integer unfinishedQuantity = ke.getInteger("unfinishedQuantity");
         if (completeQuantity > 0) {
            return completeQuantity < unfinishedQuantity ? 2 : 1;
         } else {
            return 3;
         }
      }));
      return ResultBuilder.success(masterList);
   }

   @ApiOperation("获取产品生产报表汇总")
   @GetMapping("/taskComplete/list")
   public ResultVO<?> taskCompleteList(
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "teamId", required = false) Long teamId,
      @RequestParam(required = false) Long taskOrderId,
      @RequestParam(defaultValue = "拼装") String processName
   ) {
      log.info("API 调用 ：获取产品生产报表汇总");
      List<ArtifactCompleteDTO> list = this.getTaskCompleteList(workshopId, teamId, taskOrderId, processName);
      list.sort(Comparator.comparing(ArtifactCompleteDTO::getStatus));
      return ResultBuilder.success(list);
   }

   private List<ArtifactCompleteDTO> getTaskCompleteList(Long workshopId, Long teamId, Long taskOrderId, String processName) {
      if (taskOrderId == null) {
         return Collections.emptyList();
      }

      List<Long> processIdList = this.processService
         .lambdaQuery()
         .in(MesBuildingProcess::getName, StrUtil.splitTrim(processName, ","))
         .list()
         .stream()
         .map(MesBuildingProcess::getId)
         .filter(ObjectUtil::isNotNull)
         .distinct()
         .collect(Collectors.toList());
      String param0 = CollUtil.join(processIdList, ",");
      String param1 = Optional.ofNullable(workshopId).map(o -> "AND mbtp.workshop_id = " + o).orElse("");
      String param2 = Optional.ofNullable(teamId).map(o -> "AND mbtp.team_id = " + o).orElse("");
      String param3 = Optional.ofNullable(taskOrderId).map(o -> "AND mbtp.task_order_id = " + o).orElse("");
      String sql1 = "SELECT   mbtp.product_id AS artifactId,   artt.serial_number AS serialNumber,   SUM(IFNULL(mbtp.task_quantity - mbtp.inspection_quantity, 0)) AS artifactQuantity  FROM mes_building_task_process mbtp  LEFT JOIN tech_artifact artt ON artt.bool_delete_enum = 0 AND artt.id = mbtp.product_id  WHERE mbtp.bool_delete_enum = 0 AND mbtp.task_type_enum = 2 AND mbtp.task_quantity > mbtp.inspection_quantity     AND mbtp.process_id IN ({0})     {1}     {2}     {3}  GROUP BY mbtp.product_id";
      List<JSONObject> masterList = this.service.selectList(StrUtil.indexedFormat(sql1, param0, param1, param2, param3));
      String sql2 = "SELECT  t1.artifactId,  t1.artifactQuantity,  SUM(IFNULL(tampl.quantity, 0) * t1.artifactQuantity) AS needQuantity,  SUM(IF((IFNULL(tmp.produced_quantity, 0) - IFNULL(tmp.used_quantity, 0)) > (IFNULL(tampl.quantity, 0) * t1.artifactQuantity),      (IFNULL(tampl.quantity, 0) * t1.artifactQuantity),      (IFNULL(tmp.produced_quantity, 0) - IFNULL(tmp.used_quantity, 0)))  )  AS producedQuantity,  MIN(IF(tampl.quantity IS NULL,      t1.artifactQuantity,      ((IFNULL(tmp.produced_quantity, 0) - IFNULL(tmp.used_quantity, 0)) DIV tampl.quantity))  ) AS completeSetQuantity FROM (  SELECT   mbtp.product_id AS artifactId,   SUM(IFNULL(mbtp.task_quantity, 0) - IFNULL(mbtp.inspection_quantity, 0)) AS artifactQuantity  FROM mes_building_task_process mbtp  WHERE mbtp.bool_delete_enum = 0 AND mbtp.task_type_enum = 2 AND mbtp.task_quantity > mbtp.inspection_quantity     AND mbtp.process_id IN ({0})     {1}     {2}     {3}  GROUP BY mbtp.product_id ) t1 LEFT JOIN tech_artifact_machine_part_link tampl ON tampl.bool_delete_enum = 0 AND tampl.artifact_id = t1.artifactId LEFT JOIN tech_machine_part tmp ON tmp.bool_delete_enum = 0 AND tmp.id = tampl.machine_part_id GROUP BY t1.artifactId";
      Map<Long, JSONObject> partBoardMap = this.service
         .selectList(StrUtil.indexedFormat(sql2, param0, param1, param2, param3))
         .stream()
         .collect(Collectors.toMap(k -> k.getLong("artifactId"), Function.identity()));
      String sql3 = "SELECT  t1.artifactId,  t1.artifactQuantity,  SUM(IFNULL(tad.quantity, 0) * t1.artifactQuantity) AS assembleNeedQuantity,  SUM(IF((IFNULL(asse.produced_quantity, 0) - IFNULL(asse.used_quantity, 0)) > (IFNULL(tad.quantity, 0) * t1.artifactQuantity),      (IFNULL(tad.quantity, 0) * t1.artifactQuantity),      (IFNULL(asse.produced_quantity, 0) - IFNULL(asse.used_quantity, 0)))  ) AS assembleProducedQuantity,  MIN(IF(tad.quantity IS NULL,      t1.artifactQuantity,      ((IFNULL(asse.produced_quantity, 0) - IFNULL(asse.used_quantity, 0)) DIV tad.quantity))  ) AS assembleCompleteSetQuantity,  SUM(IFNULL(wwp.partNeedQuantity, 0) * IFNULL(tad.quantity, 0) * t1.artifactQuantity) AS wingWebPlateNeedQuantity,  SUM(IF(wwp.partProductedQuantity IS NULL, 0,      IF(wwp.partProductedQuantity > (IFNULL(wwp.partNeedQuantity, 0) * IFNULL(tad.quantity, 0) * t1.artifactQuantity),      (IFNULL(wwp.partNeedQuantity, 0) * IFNULL(tad.quantity, 0) * t1.artifactQuantity),      wwp.partProductedQuantity))  ) AS wingWebPlateProducedQuantity FROM (  SELECT   mbtp.product_id AS artifactId,   SUM(IFNULL(mbtp.task_quantity, 0) - IFNULL(mbtp.inspection_quantity, 0)) AS artifactQuantity  FROM mes_building_task_process mbtp  WHERE mbtp.bool_delete_enum = 0 AND mbtp.task_type_enum = 2 AND mbtp.task_quantity > mbtp.inspection_quantity     AND mbtp.process_id IN ({0})     {1}     {2}     {3}  GROUP BY mbtp.product_id ) t1 LEFT JOIN tech_assemble_detail tad ON tad.bool_delete_enum = 0 AND tad.artifact_id = t1.artifactId LEFT JOIN tech_assemble asse ON asse.bool_delete_enum = 0 AND asse.id = tad.assemble_id LEFT JOIN (   SELECT    tampl2.assemble_id,    SUM(tampl2.quantity) AS partNeedQuantity,    SUM(tmp2.produced_quantity) AS partProductedQuantity   FROM tech_assemble_machine_part_link tampl2   LEFT JOIN tech_machine_part tmp2 ON tmp2.bool_delete_enum = 0 AND tmp2.id = tampl2.machine_part_id   WHERE tampl2.bool_delete_enum = 0   GROUP BY tampl2.assemble_id ) wwp ON wwp.assemble_id = tad.assemble_id GROUP BY t1.artifactId";
      Map<Long, JSONObject> assembleWingWebBoardMap = this.service
         .selectList(StrUtil.indexedFormat(sql3, param0, param1, param2, param3))
         .stream()
         .collect(Collectors.toMap(k -> k.getLong("artifactId"), Function.identity()));
      return masterList.stream().map(i -> {
         Long artifactId = i.getLong("artifactId");
         Integer artifactQuantity = i.getInteger("artifactQuantity");
         JSONObject partBoard = partBoardMap.get(artifactId);
         JSONObject assembleWingWebBoard = assembleWingWebBoardMap.get(artifactId);
         Integer partBoardCompleteSetQuantity = artifactQuantity;
         Integer assembleCompleteSetQuantity = artifactQuantity;
         if (partBoard == null) {
            i.put("partBoardNeedQuantity", 0);
            i.put("partBoardProductionQuantity", 0);
         } else {
            partBoardCompleteSetQuantity = partBoard.getInteger("completeSetQuantity");
            Integer needQuantity = partBoard.getInteger("needQuantity");
            Integer producedQuantity = partBoard.getInteger("producedQuantity");
            i.put("partBoardNeedQuantity", needQuantity);
            i.put("partBoardProductionQuantity", producedQuantity);
         }

         if (assembleWingWebBoard == null) {
            i.put("wingBoardNeedQuantity", 0);
            i.put("wingBoardProductionQuantity", 0);
            i.put("partNeedQuantity", 0);
            i.put("partProductionQuantity", 0);
         } else {
            assembleCompleteSetQuantity = assembleWingWebBoard.getInteger("assembleCompleteSetQuantity");
            Integer assembleNeedQuantity = assembleWingWebBoard.getInteger("assembleNeedQuantity");
            Integer assembleProducedQuantity = assembleWingWebBoard.getInteger("assembleProducedQuantity");
            Integer wingWebPlateNeedQuantity = assembleWingWebBoard.getInteger("wingWebPlateNeedQuantity");
            Integer wingWebPlateProducedQuantity = assembleWingWebBoard.getInteger("wingWebPlateProducedQuantity");
            i.put("wingBoardNeedQuantity", wingWebPlateNeedQuantity);
            i.put("wingBoardProductionQuantity", wingWebPlateProducedQuantity);
            i.put("partNeedQuantity", assembleNeedQuantity);
            i.put("partProductionQuantity", assembleProducedQuantity);
         }

         int completeQuantity = Math.min(assembleCompleteSetQuantity, partBoardCompleteSetQuantity);
         i.put("completeQuantity", completeQuantity);
         if (completeQuantity >= artifactQuantity) {
            if (completeQuantity > artifactQuantity) {
               i.put("completeQuantity", artifactQuantity);
            }

            i.put("status", 1);
         } else if (completeQuantity > 0) {
            i.put("status", 2);
         } else {
            i.put("status", 3);
         }

         return JSONObject.toJavaObject(i, ArtifactCompleteDTO.class);
      }).collect(Collectors.toList());
   }

   public CompleteLargeScreenController(
      final CompleteLargeScreenService completeLargeScreenService, final MesBuildingProcessService processService, final InitializationService service
   ) {
      this.completeLargeScreenService = completeLargeScreenService;
      this.processService = processService;
      this.service = service;
   }
}
