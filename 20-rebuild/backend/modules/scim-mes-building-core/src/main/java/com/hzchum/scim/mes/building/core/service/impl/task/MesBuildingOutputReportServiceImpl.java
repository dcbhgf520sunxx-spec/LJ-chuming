package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.FinishedProductWarehousingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.FinishedProductWarehousingSummaryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MonthlyWorkshopOutPutDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TeamOutputStatisticsDetailsReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TeamOutputStatisticsReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.YearlyOutputComparisonDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.FinishedProductWarehousingSummaryDetailReport;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertAssembleDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertAssembleDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MonthlyWorkshopOutPutReport;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.TeamOutputStatisticsDetailsReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReportDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.MonthlyWorkshopOutPutProjectVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.MonthlyWorkshopOutPutVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.YearlyOutputComparisonMonthVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.YearlyOutputComparisonRowVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.YearlyOutputComparisonVO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesMaterialFeedingReportDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingOutputReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingOutputReportMapper;
import com.hzchum.scim.mes.building.core.service.impl.task.util.CustomTemplateSheetStrategy;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClass;
import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import com.hzchum.scim.system.core.api.service.MesArtifactClassService;
import com.hzchum.scim.system.core.api.service.MesProcessConversionRateService;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingOutputReportServiceImpl implements MesBuildingOutputReportService {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingOutputReportServiceImpl.class);
   @Resource
   private MesBuildingOutputReportMapper mesBuildingOutputReportMapper;
   @Resource
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MesArtifactClassService mesArtifactClassService;
   @Resource
   private MesProcessConversionRateService mesProcessConversionRateService;
   @Resource
   private MesBuildingProduceTeamReportService mesBuildingProduceTeamReportService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Resource
   private MesMaterialFeedingReportDetailService feedingReportDetailService;

   @Override
   public List<FinishedProductWarehousingSummaryDO> finishedProductWarehousingSummary(String yearMonth, Long workshopId, String workshopName) {
      LocalDate date = Instant.ofEpochMilli(Long.valueOf(yearMonth)).atZone(ZoneId.systemDefault()).toLocalDate();
      List<MesBuildingProcess> mesBuildingProcessList = this.mesBuildingProcessService.list();
      Map<Long, MesBuildingProcess> mesBuildingProcessMap = mesBuildingProcessList.stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      LocalDate lastMonth = date.minusMonths(1L);
      Map<String, MesBuildingProduceTeamReport> mesBuildingProduceTeamReportMap = this.mesBuildingProduceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
               .select(
                  BaseEntity::getCreateTime,
                  MesBuildingProduceTeamReport::getProcessId,
                  MesBuildingProduceTeamReport::getProductId,
                  MesBuildingProduceTeamReport::getNumber
               )
               .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getProcessId() + "-" + e.getProductId() + "-" + e.getNumber(), Function.identity()));
      List<MesArtifactClass> mesArtifactClassList = this.mesArtifactClassService.list();
      List<MesProcessConversionRate> mesProcessConversionRateList = this.mesProcessConversionRateService.list();
      Map<String, Map<Long, MesProcessConversionRate>> artifactClassProcessConversionRateMap = mesProcessConversionRateList.stream()
         .collect(
            Collectors.groupingBy(MesProcessConversionRate::getStructureType, Collectors.toMap(MesProcessConversionRate::getProcessId, Function.identity()))
         );
      List<FinishedProductWarehousingSummaryDO> monthlyWorkshopOutPutDOListBeginUsed = this.mesBuildingOutputReportMapper
         .beginPutPart(lastMonth.toString(), workshopId);
      List<FinishedProductWarehousingSummaryDO> monthlyWorkshopOutPutDOListBeginFinish = this.mesBuildingOutputReportMapper
         .beginFinishProduct(lastMonth.toString(), workshopId);
      List<MesBeginConvertDO> mesBeginConvertDOArtifactList = this.mesBuildingOutputReportMapper.beginConvertArtifact(yearMonth, workshopId);
      this.updateAritifactCompleteQuantity(mesBeginConvertDOArtifactList);
      Map<String, BigDecimal> structureWeightMap = new HashMap<>(20);
      Map<String, BigDecimal> structureConvertWeightMap = new HashMap<>(20);
      this.getStructureWeightMap(mesBeginConvertDOArtifactList, structureWeightMap);
      this.getStructureConvertWeightMap(mesBeginConvertDOArtifactList, structureConvertWeightMap, artifactClassProcessConversionRateMap);
      List<MesBeginConvertAssembleDO> mesBeginConvertAssembleDOList = this.mesBuildingOutputReportMapper.beginConvertAssemble(yearMonth, workshopId);
      Set<Long> taskIds = mesBeginConvertAssembleDOList.stream()
         .filter(item -> item.getAssembleTaskProcessId() == 0L)
         .map(MesBeginConvertAssembleDO::getTaskId)
         .collect(Collectors.toSet());
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList = new ArrayList<>();
      if (taskIds.size() > 0) {
         mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIds))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
      }

      Map<Long, List<MesBuildingTaskProcess>> mesBuildingTaskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      Map<String, List<MesBeginConvertAssembleDO>> mesBeginConvertAssembleDOMap = mesBeginConvertAssembleDOList.stream()
         .collect(Collectors.groupingBy(MesBeginConvertAssembleDO::getStructureType));

      for (Entry<String, List<MesBeginConvertAssembleDO>> entry : mesBeginConvertAssembleDOMap.entrySet()) {
         String structureType = entry.getKey();
         Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(structureType, new HashMap<>());
         List<MesBeginConvertAssembleDO> taskList = entry.getValue();
         BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
         BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

         for (int i = 0; i < taskList.size(); i++) {
            MesBeginConvertAssembleDO mesBeginConvertAssembleDO = taskList.get(i);
            BigDecimal grossWeight = mesBeginConvertAssembleDO.getGrossWeight();
            Long processId = mesBeginConvertAssembleDO.getProcessId();
            if (mesBeginConvertAssembleDO.getAssembleTaskProcessId() == 0L) {
               List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMap.get(mesBeginConvertAssembleDO.getTaskId());
               mesBuildingTaskProcesses.sort(Comparator.comparingInt(MesBuildingTaskProcess::getSequence));
               MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcesses.get(0);
               processId = mesBuildingTaskProcess.getProcessId();
            }

            if (processId != null) {
               MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                  processId + "-" + mesBeginConvertAssembleDO.getAssembleId() + "-" + mesBeginConvertAssembleDO.getAssembleNumber()
               );
               if (mesBuildingProduceTeamReport != null) {
                  LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                  if (localDate.getMonthValue() > lastMonth.getMonthValue()) {
                     MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                     totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                     if (mesProcessConversionRate != null) {
                        totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                           grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                        );
                     }
                  }
               }
            }
         }

         structureConvertWeightMap.merge(structureType, totalGrossWeightSum, BigDecimal::add);
         structureWeightMap.merge(structureType, totalGrossWeightSum, BigDecimal::add);
      }

      List<MesBeginConvertAssembleDO> mesBeginConvertAssembleDOListFinish = this.mesBuildingOutputReportMapper
         .beginConvertAssembleFinish(yearMonth, workshopId);
      Set<Long> taskIdsFinish = mesBeginConvertAssembleDOListFinish.stream().map(MesBeginConvertAssembleDO::getTaskId).collect(Collectors.toSet());
      if (taskIdsFinish.size() > 0) {
         List<MesBuildingTaskProcess> mesBuildingTaskProcessListFinish = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIdsFinish))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
         Map<Long, Map<Integer, List<MesBuildingTaskProcess>>> mesBuildingTaskProcessMapFinish = mesBuildingTaskProcessListFinish.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId, Collectors.groupingBy(MesBuildingTaskProcess::getSequence)));
         Map<String, List<MesBeginConvertAssembleDO>> mesBeginConvertAssembleDOMapFinish = mesBeginConvertAssembleDOListFinish.stream()
            .collect(Collectors.groupingBy(MesBeginConvertAssembleDO::getStructureType));

         for (Entry<String, List<MesBeginConvertAssembleDO>> entry : mesBeginConvertAssembleDOMapFinish.entrySet()) {
            String structureType = entry.getKey();
            Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(structureType, new HashMap<>());
            List<MesBeginConvertAssembleDO> taskList = entry.getValue();
            BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
            BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

            for (int i = 0; i < taskList.size(); i++) {
               MesBeginConvertAssembleDO mesBeginConvertAssembleDO = taskList.get(i);
               BigDecimal grossWeight = mesBeginConvertAssembleDO.getGrossWeight();
               List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMapFinish.get(mesBeginConvertAssembleDO.getTaskId())
                  .get(mesBeginConvertAssembleDO.getSequence() - 1);
               Long processId = mesBuildingTaskProcesses.get(0).getProcessId();
               if (processId != null) {
                  MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                     processId + "-" + mesBeginConvertAssembleDO.getAssembleId() + "-" + mesBeginConvertAssembleDO.getAssembleNumber()
                  );
                  if (mesBuildingProduceTeamReport != null) {
                     LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                     if (localDate.getMonthValue() > lastMonth.getMonthValue()) {
                        MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                        totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                        if (mesProcessConversionRate != null) {
                           totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                              grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                           );
                        }
                     }
                  }
               }
            }

            structureWeightMap.merge(structureType, totalGrossWeightSum, BigDecimal::add);
            structureConvertWeightMap.merge(structureType, totalConvertGrossWeightSum, BigDecimal::add);
         }
      }

      List<MesBeginConvertDO> mesBeginConvertDOPartList = this.mesBuildingOutputReportMapper.beginConvertPart(yearMonth, workshopId);
      this.getStructureWeightMap(mesBeginConvertDOPartList, structureWeightMap);
      this.getStructureConvertWeightMap(mesBeginConvertDOPartList, structureConvertWeightMap, artifactClassProcessConversionRateMap);
      List<FinishedProductWarehousingSummaryDO> monthlyWorkshopOutPutDOListThisMonthUsed = this.mesBuildingOutputReportMapper
         .beginPutPartThisMonth(yearMonth, workshopId);
      List<FinishedProductWarehousingSummaryDO> monthlyWorkshopOutPutDOListThisMonthFinish = this.mesBuildingOutputReportMapper
         .beginFinishProductThisMonth(yearMonth, workshopId);
      List<MesBeginConvertDO> mesBeginConvertDOArtifactListThisMonth = this.mesBuildingOutputReportMapper.beginConvertArtifactThisMonth(yearMonth, workshopId);
      this.updateAritifactCompleteQuantity(mesBeginConvertDOArtifactListThisMonth);
      Map<String, BigDecimal> structureWeightMapThisMonth = new HashMap<>(20);
      Map<String, BigDecimal> structureConvertWeightMapThisMonth = new HashMap<>(20);
      this.getStructureConvertWeightMap(mesBeginConvertDOArtifactListThisMonth, structureConvertWeightMapThisMonth, artifactClassProcessConversionRateMap);
      List<MesBeginConvertAssembleDO> mesBeginConvertAssembleDOListThisMonth = this.mesBuildingOutputReportMapper.beginConvertAssemble(yearMonth, workshopId);
      Set<Long> taskIdsThisMonth = mesBeginConvertAssembleDOListThisMonth.stream()
         .filter(item -> item.getAssembleTaskProcessId() == 0L)
         .map(MesBeginConvertAssembleDO::getTaskId)
         .collect(Collectors.toSet());
      List<MesBuildingTaskProcess> mesBuildingTaskProcessListThisMonth = new ArrayList<>();
      if (taskIdsThisMonth.size() > 0) {
         mesBuildingTaskProcessListThisMonth = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIdsThisMonth))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
      }

      Map<Long, List<MesBuildingTaskProcess>> mesBuildingTaskProcessMapThisMonth = mesBuildingTaskProcessListThisMonth.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      Map<String, List<MesBeginConvertAssembleDO>> mesBeginConvertAssembleDOMapThisMonth = mesBeginConvertAssembleDOList.stream()
         .collect(Collectors.groupingBy(MesBeginConvertAssembleDO::getStructureType));

      for (Entry<String, List<MesBeginConvertAssembleDO>> entry : mesBeginConvertAssembleDOMapThisMonth.entrySet()) {
         String structureType = entry.getKey();
         Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(structureType, new HashMap<>());
         List<MesBeginConvertAssembleDO> taskList = entry.getValue();
         BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
         BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

         for (int i = 0; i < taskList.size(); i++) {
            MesBeginConvertAssembleDO mesBeginConvertAssembleDO = taskList.get(i);
            BigDecimal grossWeight = mesBeginConvertAssembleDO.getGrossWeight();
            Long processId = mesBeginConvertAssembleDO.getProcessId();
            if (mesBeginConvertAssembleDO.getAssembleTaskProcessId() == 0L) {
               List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMapThisMonth.get(mesBeginConvertAssembleDO.getTaskId());
               mesBuildingTaskProcesses.sort(Comparator.comparingInt(MesBuildingTaskProcess::getSequence));
               MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcesses.get(0);
               processId = mesBuildingTaskProcess.getProcessId();
            }

            if (processId != null) {
               MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                  processId + "-" + mesBeginConvertAssembleDO.getAssembleId() + "-" + mesBeginConvertAssembleDO.getAssembleNumber()
               );
               if (mesBuildingProduceTeamReport != null) {
                  LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                  if (localDate.getMonthValue() == date.getMonthValue()) {
                     MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                     totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                     if (mesProcessConversionRate != null) {
                        totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                           grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                        );
                     }
                  }
               }
            }
         }

         structureWeightMapThisMonth.merge(structureType, totalGrossWeightSum, BigDecimal::add);
         structureConvertWeightMapThisMonth.merge(structureType, totalConvertGrossWeightSum, BigDecimal::add);
      }

      List<MesBeginConvertAssembleDO> mesBeginConvertAssembleDOListFinishThisMonth = this.mesBuildingOutputReportMapper
         .beginConvertAssembleFinish(yearMonth, workshopId);
      Set<Long> taskIdsFinishThisMonth = mesBeginConvertAssembleDOListFinish.stream().map(MesBeginConvertAssembleDO::getTaskId).collect(Collectors.toSet());
      new ArrayList();
      if (taskIdsFinishThisMonth.size() > 0) {
         List<MesBuildingTaskProcess> var94 = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIdsFinish))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
         Map<Long, Map<Integer, List<MesBuildingTaskProcess>>> mesBuildingTaskProcessMapFinishThisMonth = var94.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId, Collectors.groupingBy(MesBuildingTaskProcess::getSequence)));
         Map<String, List<MesBeginConvertAssembleDO>> mesBeginConvertAssembleDOMapFinishThisMonth = mesBeginConvertAssembleDOListFinishThisMonth.stream()
            .collect(Collectors.groupingBy(MesBeginConvertAssembleDO::getStructureType));

         for (Entry<String, List<MesBeginConvertAssembleDO>> entry : mesBeginConvertAssembleDOMapFinishThisMonth.entrySet()) {
            String structureType = entry.getKey();
            Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(structureType, new HashMap<>());
            List<MesBeginConvertAssembleDO> taskList = entry.getValue();
            BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
            BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

            for (int i = 0; i < taskList.size(); i++) {
               MesBeginConvertAssembleDO mesBeginConvertAssembleDO = taskList.get(i);
               BigDecimal grossWeight = mesBeginConvertAssembleDO.getGrossWeight();
               List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMapFinishThisMonth.get(mesBeginConvertAssembleDO.getTaskId())
                  .get(mesBeginConvertAssembleDO.getSequence() - 1);
               Long processId = mesBuildingTaskProcesses.get(0).getProcessId();
               totalGrossWeightSum.add(grossWeight);
               if (processId != null) {
                  MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                     processId + "-" + mesBeginConvertAssembleDO.getAssembleId() + "-" + mesBeginConvertAssembleDO.getAssembleNumber()
                  );
                  if (mesBuildingProduceTeamReport != null) {
                     LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                     if (localDate.getMonthValue() == date.getMonthValue()) {
                        MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                        totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                        if (mesProcessConversionRate != null) {
                           totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                              grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                           );
                        }
                     }
                  }
               }
            }

            structureWeightMapThisMonth.merge(structureType, totalGrossWeightSum, BigDecimal::add);
            structureConvertWeightMapThisMonth.merge(structureType, totalConvertGrossWeightSum, BigDecimal::add);
         }
      }

      List<MesBeginConvertDO> mesBeginConvertDOPartListThisMonth = this.mesBuildingOutputReportMapper.beginConvertPart(yearMonth, workshopId);
      this.getStructureWeightMap(mesBeginConvertDOPartListThisMonth, structureWeightMapThisMonth);
      this.getStructureConvertWeightMap(mesBeginConvertDOPartListThisMonth, structureConvertWeightMapThisMonth, artifactClassProcessConversionRateMap);
      List<FinishedProductWarehousingSummaryDO> finishedProductWarehousingSummaryDOList = new ArrayList<>();
      Map<String, BigDecimal> beginPutPartMap = monthlyWorkshopOutPutDOListBeginUsed.stream()
         .collect(Collectors.toMap(FinishedProductWarehousingSummaryDO::getStructureType, FinishedProductWarehousingSummaryDO::getBeginPutPart));
      Map<String, BigDecimal> beginFinishProductMap = monthlyWorkshopOutPutDOListBeginFinish.stream()
         .collect(Collectors.toMap(FinishedProductWarehousingSummaryDO::getStructureType, FinishedProductWarehousingSummaryDO::getBeginFinishProduct));
      Map<String, BigDecimal> thisMonthPutPartMap = monthlyWorkshopOutPutDOListThisMonthUsed.stream()
         .collect(Collectors.toMap(FinishedProductWarehousingSummaryDO::getStructureType, FinishedProductWarehousingSummaryDO::getThisMonthPutPart));
      Map<String, BigDecimal> thisMonthFinishProductMap = monthlyWorkshopOutPutDOListThisMonthFinish.stream()
         .collect(Collectors.toMap(FinishedProductWarehousingSummaryDO::getStructureType, FinishedProductWarehousingSummaryDO::getThisMonthFinishProduct));
      Integer typeNumber = 1;

      for (MesArtifactClass mesArtifactClass : mesArtifactClassList) {
         String name = mesArtifactClass.getName();
         FinishedProductWarehousingSummaryDO finishedProductWarehousingSummaryDO = new FinishedProductWarehousingSummaryDO();
         Integer var129 = typeNumber;
         typeNumber = typeNumber + 1;
         finishedProductWarehousingSummaryDO.setTypeNumber(var129);
         finishedProductWarehousingSummaryDO.setStructureType(name);
         finishedProductWarehousingSummaryDO.setBeginPutPart(
            beginPutPartMap.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setBeginFinishProduct(
            beginFinishProductMap.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setBeginHalfProduct(
            structureWeightMap.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setBeginConvertFinishProduct(
            structureConvertWeightMap.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setThisMonthPutPart(
            thisMonthPutPartMap.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setThisMonthFinishProduct(
            thisMonthFinishProductMap.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setThisMonthHalfProduct(
            structureWeightMapThisMonth.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setThisMonthConvertFinishProduct(
            structureConvertWeightMapThisMonth.getOrDefault(name, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
         );
         finishedProductWarehousingSummaryDO.setTotalPutPart(
            finishedProductWarehousingSummaryDO.getBeginPutPart().add(finishedProductWarehousingSummaryDO.getThisMonthPutPart())
         );
         finishedProductWarehousingSummaryDO.setTotalFinishProduct(
            finishedProductWarehousingSummaryDO.getBeginFinishProduct().add(finishedProductWarehousingSummaryDO.getThisMonthFinishProduct())
         );
         finishedProductWarehousingSummaryDO.setThisMonthFinishOutput(
            finishedProductWarehousingSummaryDO.getThisMonthFinishProduct()
               .subtract(
                  finishedProductWarehousingSummaryDO.getBeginConvertFinishProduct()
                     .add(finishedProductWarehousingSummaryDO.getThisMonthConvertFinishProduct())
               )
         );
         finishedProductWarehousingSummaryDO.setWorkshopId(workshopId);
         finishedProductWarehousingSummaryDO.setWorkshopName(workshopName);
         finishedProductWarehousingSummaryDOList.add(finishedProductWarehousingSummaryDO);
      }

      List<MesMaterialFeedingReportDetailDTO> mesMaterialFeedingReportDetailDTOS = this.feedingReportDetailService.allFeedingList(workshopId, null);
      YearMonth dateYearMonth = YearMonth.from(date);
      if (CollectionUtils.isNotEmpty(mesMaterialFeedingReportDetailDTOS) && CollectionUtils.isNotEmpty(finishedProductWarehousingSummaryDOList)) {
         Map<String, List<MesMaterialFeedingReportDetailDTO>> feedingReportDetailDTOMap = mesMaterialFeedingReportDetailDTOS.stream()
            .collect(Collectors.groupingBy(MesMaterialFeedingReportDetail::getStructureType));

         for (FinishedProductWarehousingSummaryDO productWarehousingSummaryDO : finishedProductWarehousingSummaryDOList) {
            if (productWarehousingSummaryDO.getStructureType() != null) {
               List<MesMaterialFeedingReportDetailDTO> detailDTOS = feedingReportDetailDTOMap.get(productWarehousingSummaryDO.getStructureType());
               if (CollectionUtils.isNotEmpty(detailDTOS)) {
                  List<MesMaterialFeedingReportDetailDTO> beginningPeriodReportDetailDTOs = detailDTOS.stream()
                     .filter(e -> YearMonth.from(e.getCreateTime()).isBefore(dateYearMonth))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(beginningPeriodReportDetailDTOs)) {
                     productWarehousingSummaryDO.setBeginPutPart(
                        beginningPeriodReportDetailDTOs.stream()
                           .map(MesMaterialFeedingReportDetail::getFeedingQuantity)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(BigDecimal.valueOf(1000L))
                     );
                  }

                  List<MesMaterialFeedingReportDetailDTO> endPeriodReportDetailDTOs = detailDTOS.stream()
                     .filter(e -> YearMonth.from(e.getCreateTime()).equals(dateYearMonth))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(endPeriodReportDetailDTOs)) {
                     productWarehousingSummaryDO.setThisMonthPutPart(
                        endPeriodReportDetailDTOs.stream()
                           .map(MesMaterialFeedingReportDetail::getFeedingQuantity)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(BigDecimal.valueOf(1000L))
                     );
                  }

                  productWarehousingSummaryDO.setTotalPutPart(
                     detailDTOS.stream()
                        .map(MesMaterialFeedingReportDetail::getFeedingQuantity)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L))
                  );
               }
            }
         }
      }

      FinishedProductWarehousingSummaryDO finishedProductWarehousingSummaryDO = new FinishedProductWarehousingSummaryDO();
      String structureType = "合计";
      BigDecimal beginPutPart = BigDecimal.ZERO;
      BigDecimal beginFinishProduct = BigDecimal.ZERO;
      BigDecimal beginHalfProduct = BigDecimal.ZERO;
      BigDecimal beginConvertFinishProduct = BigDecimal.ZERO;
      BigDecimal thisMonthPutPart = BigDecimal.ZERO;
      BigDecimal thisMonthFinishProduct = BigDecimal.ZERO;
      BigDecimal thisMonthHalfProduct = BigDecimal.ZERO;
      BigDecimal thisMonthConvertFinishProduct = BigDecimal.ZERO;
      BigDecimal totalPutPart = BigDecimal.ZERO;
      BigDecimal totalFinishProduct = BigDecimal.ZERO;
      BigDecimal thisMonthFinishOutput = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(finishedProductWarehousingSummaryDOList)) {
         for (FinishedProductWarehousingSummaryDO productWarehousingSummaryDO : finishedProductWarehousingSummaryDOList) {
            beginPutPart = beginPutPart.add(productWarehousingSummaryDO.getBeginPutPart());
            beginFinishProduct = beginFinishProduct.add(productWarehousingSummaryDO.getBeginFinishProduct());
            beginHalfProduct = beginHalfProduct.add(productWarehousingSummaryDO.getBeginHalfProduct());
            beginConvertFinishProduct = beginConvertFinishProduct.add(productWarehousingSummaryDO.getBeginConvertFinishProduct());
            thisMonthPutPart = thisMonthPutPart.add(productWarehousingSummaryDO.getThisMonthPutPart());
            thisMonthFinishProduct = thisMonthFinishProduct.add(productWarehousingSummaryDO.getThisMonthFinishProduct());
            thisMonthHalfProduct = thisMonthHalfProduct.add(productWarehousingSummaryDO.getThisMonthHalfProduct());
            thisMonthConvertFinishProduct = thisMonthConvertFinishProduct.add(productWarehousingSummaryDO.getThisMonthConvertFinishProduct());
            totalPutPart = totalPutPart.add(productWarehousingSummaryDO.getTotalPutPart());
            totalFinishProduct = totalFinishProduct.add(productWarehousingSummaryDO.getTotalFinishProduct());
            thisMonthFinishOutput = thisMonthFinishOutput.add(productWarehousingSummaryDO.getThisMonthFinishOutput());
            finishedProductWarehousingSummaryDO.setStructureType(structureType);
            finishedProductWarehousingSummaryDO.setBeginPutPart(beginPutPart);
            finishedProductWarehousingSummaryDO.setBeginFinishProduct(beginFinishProduct);
            finishedProductWarehousingSummaryDO.setBeginHalfProduct(beginHalfProduct);
            finishedProductWarehousingSummaryDO.setBeginConvertFinishProduct(beginConvertFinishProduct);
            finishedProductWarehousingSummaryDO.setThisMonthPutPart(thisMonthPutPart);
            finishedProductWarehousingSummaryDO.setThisMonthFinishProduct(thisMonthFinishProduct);
            finishedProductWarehousingSummaryDO.setThisMonthHalfProduct(thisMonthHalfProduct);
            finishedProductWarehousingSummaryDO.setThisMonthConvertFinishProduct(thisMonthConvertFinishProduct);
            finishedProductWarehousingSummaryDO.setTotalPutPart(totalPutPart);
            finishedProductWarehousingSummaryDO.setTotalFinishProduct(totalFinishProduct);
            finishedProductWarehousingSummaryDO.setThisMonthFinishOutput(thisMonthFinishOutput);
         }

         finishedProductWarehousingSummaryDOList.add(finishedProductWarehousingSummaryDO);
      }

      return finishedProductWarehousingSummaryDOList;
   }

   private void updateAritifactCompleteQuantity(List<MesBeginConvertDO> mesBeginConvertDOArtifactList) {
      List<Long> collect = mesBeginConvertDOArtifactList.stream().map(MesBeginConvertDO::getTaskId).collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(collect)) {
         List<MesBuildingComplete> mesBuildingCompletes = this.mesBuildingCompleteService
            .list(
               (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().in(MesBuildingComplete::getTaskId, collect))
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         Map<Long, Integer> completeQuantityMap = mesBuildingCompletes.stream()
            .collect(Collectors.toMap(MesBuildingComplete::getTaskId, MesBuildingComplete::getQuantity, Integer::sum));
         mesBeginConvertDOArtifactList.forEach(
            mesBeginConvertDOArtifact -> {
               if (completeQuantityMap.containsKey(mesBeginConvertDOArtifact.getTaskId())) {
                  mesBeginConvertDOArtifact.setCompleteQuantity(
                     mesBeginConvertDOArtifact.getCompleteQuantity() - completeQuantityMap.get(mesBeginConvertDOArtifact.getTaskId())
                  );
               }
            }
         );
      }
   }

   private void updateAritifactCompleteQuantityDetail(List<MesBeginConvertDetailDO> mesBeginConvertDOArtifactList) {
      List<Long> collect = mesBeginConvertDOArtifactList.stream().map(MesBeginConvertDetailDO::getTaskId).collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(collect)) {
         List<MesBuildingComplete> mesBuildingCompletes = this.mesBuildingCompleteService
            .list(
               (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().in(MesBuildingComplete::getTaskId, collect))
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         Map<Long, Integer> completeQuantityMap = mesBuildingCompletes.stream()
            .collect(Collectors.toMap(MesBuildingComplete::getTaskId, MesBuildingComplete::getQuantity, Integer::sum));
         mesBeginConvertDOArtifactList.forEach(
            mesBeginConvertDOArtifact -> {
               if (completeQuantityMap.containsKey(mesBeginConvertDOArtifact.getTaskId())) {
                  mesBeginConvertDOArtifact.setCompleteQuantity(
                     mesBeginConvertDOArtifact.getCompleteQuantity() - completeQuantityMap.get(mesBeginConvertDOArtifact.getTaskId())
                  );
               }
            }
         );
      }
   }

   @Override
   public void finishedProductWarehousingSummaryDownload(String yearMonth, Long workshopId, String workshopName, HttpServletResponse response) {
      List<FinishedProductWarehousingSummaryDO> finishedProductWarehousingSummaryDOList = this.finishedProductWarehousingSummary(
         yearMonth, workshopId, workshopName
      );
      response.reset();
      response.setContentType("application/vnd.ms-excel;charset=UTF-8");
      String fileName = null;

      try {
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Access-Control-Allow-Origin", "*");
         fileName = "制成品入库汇总.xlsx";
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }

      response.setCharacterEncoding("utf-8");
      ClassPathResource classPathResource = new ClassPathResource("/files/finishedProductWarehousingSummary.xlsx");

      try (
         InputStream inputStream = classPathResource.getInputStream();
         ServletOutputStream outputStream = response.getOutputStream();
      ) {
         ExcelWriter excelWriter = EasyExcel.write(outputStream, FinishedProductWarehousingSummaryDO.class)
            .withTemplate(inputStream)
            .excelType(ExcelTypeEnum.XLSX)
            .build();
         WriteSheet writeSheet = EasyExcel.writerSheet().build();
         Map<String, Object> dateMap = new HashMap<>();
         LocalDate date = Instant.ofEpochMilli(Long.valueOf(yearMonth)).atZone(ZoneId.systemDefault()).toLocalDate();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月");
         String formattedDate = date.format(formatter);
         dateMap.put("date", formattedDate);
         dateMap.put("workshopName", workshopName);
         excelWriter.fill(dateMap, writeSheet);
         excelWriter.fill(finishedProductWarehousingSummaryDOList, writeSheet);
         excelWriter.finish();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   public List<FinishedProductWarehousingSummaryDetailDO> finishedProductWarehousingSummaryDetail(
      String yearMonth, Long workshopId, String structureType, String workshopName
   ) {
      LocalDate date = Instant.ofEpochMilli(Long.valueOf(yearMonth)).atZone(ZoneId.systemDefault()).toLocalDate();
      LocalDate lastMonth = date.minusMonths(1L);
      Map<String, MesBuildingProduceTeamReport> mesBuildingProduceTeamReportMap = this.mesBuildingProduceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
               .select(
                  BaseEntity::getCreateTime,
                  MesBuildingProduceTeamReport::getProcessId,
                  MesBuildingProduceTeamReport::getProductId,
                  MesBuildingProduceTeamReport::getNumber
               )
               .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getProcessId() + "-" + e.getProductId() + "-" + e.getNumber(), Function.identity()));
      List<MesArtifactClass> mesArtifactClassList = this.mesArtifactClassService.list();
      List<MesBuildingProcess> mesBuildingProcessList = this.mesBuildingProcessService.list();
      Map<Long, MesBuildingProcess> mesBuildingProcessMap = mesBuildingProcessList.stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      List<MesProcessConversionRate> mesProcessConversionRateList = this.mesProcessConversionRateService.list();
      Map<String, Map<Long, MesProcessConversionRate>> artifactClassProcessConversionRateMap = mesProcessConversionRateList.stream()
         .collect(
            Collectors.groupingBy(MesProcessConversionRate::getStructureType, Collectors.toMap(MesProcessConversionRate::getProcessId, Function.identity()))
         );
      Map<Long, MesProcessConversionRate> mesProcessConversionRateMap1 = mesProcessConversionRateList.stream()
         .collect(Collectors.toMap(MesProcessConversionRate::getProcessId, Function.identity()));
      List<FinishedProductWarehousingSummaryDetailDO> monthlyWorkshopOutPutDOListBeginUsed = this.mesBuildingOutputReportMapper
         .beginPutPartGroupProject(lastMonth.toString(), workshopId, structureType);
      List<FinishedProductWarehousingSummaryDetailDO> monthlyWorkshopOutPutDOListBeginFinish = this.mesBuildingOutputReportMapper
         .beginFinishProductGroupProject(lastMonth.toString(), workshopId, structureType);
      List<MesBeginConvertDetailDO> mesBeginConvertDOArtifactList = this.mesBuildingOutputReportMapper
         .beginConvertArtifactGroupProject(yearMonth, workshopId, structureType);
      this.updateAritifactCompleteQuantityDetail(mesBeginConvertDOArtifactList);
      Map<String, Map<Long, BigDecimal>> structureWeightMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightMap = new HashMap<>(20);
      getProjectWeightMap(mesBeginConvertDOArtifactList, structureWeightMap);
      getProjectConvertWeightMap(mesBeginConvertDOArtifactList, structureConvertWeightMap, artifactClassProcessConversionRateMap);
      List<MesBeginConvertAssembleDetailDO> mesBeginConvertAssembleDetailDOList = this.mesBuildingOutputReportMapper
         .beginConvertAssembleGroupProject(yearMonth, workshopId, structureType);
      Set<Long> taskIds = mesBeginConvertAssembleDetailDOList.stream()
         .filter(item -> item.getAssembleTaskProcessId() == 0L)
         .map(MesBeginConvertAssembleDetailDO::getTaskId)
         .collect(Collectors.toSet());
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList = new ArrayList<>();
      if (taskIds.size() > 0) {
         mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIds))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
      }

      Map<Long, List<MesBuildingTaskProcess>> mesBuildingTaskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      Map<String, List<MesBeginConvertAssembleDetailDO>> mesBeginConvertAssembleDOMap = mesBeginConvertAssembleDetailDOList.stream()
         .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getStructureType));
      Map<String, Map<Long, BigDecimal>> structureWeightAssembleOneMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightAssembleOneMap = new HashMap<>(20);

      for (Entry<String, List<MesBeginConvertAssembleDetailDO>> entry : mesBeginConvertAssembleDOMap.entrySet()) {
         String key = entry.getKey();
         Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(key, new HashMap<>());
         List<MesBeginConvertAssembleDetailDO> structureTypeList = entry.getValue();
         Map<Long, List<MesBeginConvertAssembleDetailDO>> projectMap = structureTypeList.stream()
            .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getProjectId));
         Map<Long, BigDecimal> projectWeightMap = new HashMap<>();
         Map<Long, BigDecimal> projectWeightConvertMap = new HashMap<>();

         for (Entry<Long, List<MesBeginConvertAssembleDetailDO>> projectEntry : projectMap.entrySet()) {
            Long projectId = projectEntry.getKey();
            List<MesBeginConvertAssembleDetailDO> taskList = projectEntry.getValue();
            BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
            BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

            for (int i = 0; i < taskList.size(); i++) {
               MesBeginConvertAssembleDetailDO mesBeginConvertAssembleDetailDO = taskList.get(i);
               BigDecimal grossWeight = mesBeginConvertAssembleDetailDO.getGrossWeight();
               Long processId = mesBeginConvertAssembleDetailDO.getProcessId();
               if (mesBeginConvertAssembleDetailDO.getAssembleTaskProcessId() == 0L) {
                  List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMap.get(mesBeginConvertAssembleDetailDO.getTaskId());
                  mesBuildingTaskProcesses.sort(Comparator.comparingInt(MesBuildingTaskProcess::getSequence));
                  MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcesses.get(0);
                  processId = mesBuildingTaskProcess.getProcessId();
               }

               if (processId != null) {
                  MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                     processId + "-" + mesBeginConvertAssembleDetailDO.getAssembleId() + "-" + mesBeginConvertAssembleDetailDO.getAssembleNumber()
                  );
                  if (mesBuildingProduceTeamReport != null) {
                     LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                     if (localDate.getMonthValue() > lastMonth.getMonthValue()) {
                        MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                        totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                        if (mesProcessConversionRate != null) {
                           totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                              grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                           );
                        }
                     }
                  }
               }
            }

            projectWeightMap.merge(projectId, totalGrossWeightSum, BigDecimal::add);
            projectWeightConvertMap.merge(projectId, totalConvertGrossWeightSum, BigDecimal::add);
         }

         structureWeightAssembleOneMap.put(key, projectWeightMap);
         structureConvertWeightAssembleOneMap.put(key, projectWeightConvertMap);
      }

      List<MesBeginConvertAssembleDetailDO> mesBeginConvertAssembleDOListFinish = this.mesBuildingOutputReportMapper
         .beginConvertAssembleFinishGroupProject(yearMonth, workshopId, structureType);
      Set<Long> taskIdsFinish = mesBeginConvertAssembleDOListFinish.stream().map(MesBeginConvertAssembleDetailDO::getTaskId).collect(Collectors.toSet());
      new ArrayList();
      Map<String, Map<Long, BigDecimal>> structureWeightAssembleTwoMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightAssembleTwoMap = new HashMap<>(20);
      if (taskIdsFinish.size() > 0) {
         List<MesBuildingTaskProcess> var82 = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIdsFinish))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
         Map<Long, Map<Integer, List<MesBuildingTaskProcess>>> mesBuildingTaskProcessMapFinish = var82.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId, Collectors.groupingBy(MesBuildingTaskProcess::getSequence)));
         Map<String, List<MesBeginConvertAssembleDetailDO>> mesBeginConvertAssembleDOMapFinish = mesBeginConvertAssembleDOListFinish.stream()
            .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getStructureType));

         for (Entry<String, List<MesBeginConvertAssembleDetailDO>> entry : mesBeginConvertAssembleDOMapFinish.entrySet()) {
            String key = entry.getKey();
            Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(key, new HashMap<>());
            List<MesBeginConvertAssembleDetailDO> structureTypeList = entry.getValue();
            Map<Long, List<MesBeginConvertAssembleDetailDO>> projectMap = structureTypeList.stream()
               .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getProjectId));
            Map<Long, BigDecimal> projectWeightMap = new HashMap<>();
            Map<Long, BigDecimal> projectWeightConvertMap = new HashMap<>();

            for (Entry<Long, List<MesBeginConvertAssembleDetailDO>> projectEntry : projectMap.entrySet()) {
               Long projectId = projectEntry.getKey();
               List<MesBeginConvertAssembleDetailDO> taskList = projectEntry.getValue();
               BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
               BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

               for (int i = 0; i < taskList.size(); i++) {
                  MesBeginConvertAssembleDetailDO mesBeginConvertAssembleDO = taskList.get(i);
                  BigDecimal grossWeight = mesBeginConvertAssembleDO.getGrossWeight();
                  List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMapFinish.get(mesBeginConvertAssembleDO.getTaskId())
                     .get(mesBeginConvertAssembleDO.getSequence() - 1);
                  Long processId = mesBuildingTaskProcesses.get(0).getProcessId();
                  if (processId != null) {
                     MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                        processId + "-" + mesBeginConvertAssembleDO.getAssembleId() + "-" + mesBeginConvertAssembleDO.getAssembleNumber()
                     );
                     if (mesBuildingProduceTeamReport != null) {
                        LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                        if (localDate.getMonthValue() > lastMonth.getMonthValue()) {
                           MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                           totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                           if (mesProcessConversionRate != null) {
                              totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                                 grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                              );
                           }
                        }
                     }
                  }
               }

               projectWeightMap.merge(projectId, totalGrossWeightSum, BigDecimal::add);
               projectWeightConvertMap.merge(projectId, totalConvertGrossWeightSum, BigDecimal::add);
            }

            structureWeightAssembleTwoMap.put(key, projectWeightMap);
            structureConvertWeightAssembleTwoMap.put(key, projectWeightConvertMap);
         }
      }

      Map<String, Map<Long, BigDecimal>> structureWeightPartMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightPartMap = new HashMap<>(20);
      List<MesBeginConvertDetailDO> mesBeginConvertDOPartList = this.mesBuildingOutputReportMapper
         .beginConvertPartGroupProject(yearMonth, workshopId, structureType);
      getProjectWeightMap(mesBeginConvertDOPartList, structureWeightPartMap);
      getProjectConvertWeightMap(mesBeginConvertDOPartList, structureConvertWeightPartMap, artifactClassProcessConversionRateMap);
      List<FinishedProductWarehousingSummaryDetailDO> monthlyWorkshopOutPutDOListThisMonthUsed = this.mesBuildingOutputReportMapper
         .beginPutPartThisMonthGroupProject(yearMonth, workshopId);
      List<FinishedProductWarehousingSummaryDetailDO> monthlyWorkshopOutPutDOListThisMonthFinish = this.mesBuildingOutputReportMapper
         .beginFinishProductThisMonthGroupProject(yearMonth, workshopId);
      List<MesBeginConvertDetailDO> mesBeginConvertDOArtifactListThisMonth = this.mesBuildingOutputReportMapper
         .beginConvertArtifactGroupProject(yearMonth, workshopId, structureType);
      this.updateAritifactCompleteQuantityDetail(mesBeginConvertDOArtifactList);
      Map<String, Map<Long, BigDecimal>> structureWeightMapThisMonth = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightMapThisMonth = new HashMap<>(20);
      this.updateAritifactCompleteQuantityDetail(mesBeginConvertDOArtifactListThisMonth);
      getProjectWeightMap(mesBeginConvertDOArtifactListThisMonth, structureWeightMapThisMonth);
      getProjectConvertWeightMap(mesBeginConvertDOArtifactListThisMonth, structureConvertWeightMapThisMonth, artifactClassProcessConversionRateMap);
      List<MesBeginConvertAssembleDetailDO> mesBeginConvertAssembleDOListThisMonth = this.mesBuildingOutputReportMapper
         .beginConvertAssembleGroupProject(yearMonth, workshopId, structureType);
      Set<Long> taskIdsThisMonth = mesBeginConvertAssembleDOListThisMonth.stream()
         .filter(item -> item.getAssembleTaskProcessId() == 0L)
         .map(MesBeginConvertAssembleDetailDO::getTaskId)
         .collect(Collectors.toSet());
      List<MesBuildingTaskProcess> mesBuildingTaskProcessListThisMonth = new ArrayList<>();
      if (taskIdsThisMonth.size() > 0) {
         mesBuildingTaskProcessListThisMonth = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIdsThisMonth))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
      }

      Map<Long, List<MesBuildingTaskProcess>> mesBuildingTaskProcessMapThisMonth = mesBuildingTaskProcessListThisMonth.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      List<MesBuildingProcess> mesBuildingProcessListThisMonth = this.mesBuildingProcessService.list();
      Map<Long, MesBuildingProcess> mesBuildingProcessMapThisMonth = mesBuildingProcessList.stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<String, List<MesBeginConvertAssembleDetailDO>> mesBeginConvertAssembleDOMapThisMonth = mesBeginConvertAssembleDOListThisMonth.stream()
         .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getStructureType));
      Map<String, Map<Long, BigDecimal>> structureWeightAssembleOneThisMonthMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightAssembleOneThisMonthMap = new HashMap<>(20);

      for (Entry<String, List<MesBeginConvertAssembleDetailDO>> entry : mesBeginConvertAssembleDOMapThisMonth.entrySet()) {
         String key = entry.getKey();
         Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(key, new HashMap<>());
         List<MesBeginConvertAssembleDetailDO> structureTypeList = entry.getValue();
         Map<Long, List<MesBeginConvertAssembleDetailDO>> projectMap = structureTypeList.stream()
            .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getProjectId));
         Map<Long, BigDecimal> projectWeightMap = new HashMap<>();
         Map<Long, BigDecimal> projectWeightConvertMap = new HashMap<>();

         for (Entry<Long, List<MesBeginConvertAssembleDetailDO>> projectEntry : projectMap.entrySet()) {
            Long projectId = projectEntry.getKey();
            List<MesBeginConvertAssembleDetailDO> taskList = projectEntry.getValue();
            BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
            BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

            for (int i = 0; i < taskList.size(); i++) {
               MesBeginConvertAssembleDetailDO mesBeginConvertAssembleDetailDO = taskList.get(i);
               BigDecimal grossWeight = mesBeginConvertAssembleDetailDO.getGrossWeight();
               Long processId = mesBeginConvertAssembleDetailDO.getProcessId();
               if (mesBeginConvertAssembleDetailDO.getAssembleTaskProcessId() == 0L) {
                  List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMap.get(mesBeginConvertAssembleDetailDO.getTaskId());
                  mesBuildingTaskProcesses.sort(Comparator.comparingInt(MesBuildingTaskProcess::getSequence));
                  MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcesses.get(0);
                  processId = mesBuildingTaskProcess.getProcessId();
               }

               if (processId != null) {
                  MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                     processId + "-" + mesBeginConvertAssembleDetailDO.getAssembleId() + "-" + mesBeginConvertAssembleDetailDO.getAssembleNumber()
                  );
                  if (mesBuildingProduceTeamReport != null) {
                     LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                     if (localDate.getMonthValue() != date.getMonthValue()) {
                        MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                        totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                        if (mesProcessConversionRate != null) {
                           totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                              grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                           );
                        }
                     }
                  }
               }
            }

            projectWeightMap.merge(projectId, totalGrossWeightSum, BigDecimal::add);
            projectWeightConvertMap.merge(projectId, totalConvertGrossWeightSum, BigDecimal::add);
         }

         structureWeightAssembleOneThisMonthMap.put(key, projectWeightMap);
         structureConvertWeightAssembleOneThisMonthMap.put(key, projectWeightConvertMap);
      }

      List<MesBeginConvertAssembleDetailDO> mesBeginConvertAssembleDOListFinishThisMonth = this.mesBuildingOutputReportMapper
         .beginConvertAssembleFinishGroupProject(yearMonth, workshopId, structureType);
      Map<String, Map<Long, BigDecimal>> structureWeightAssembleTwoThisMonthMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightAssembleTwoThisMonthMap = new HashMap<>(20);
      Set<Long> taskIdsFinishThisMonth = mesBeginConvertAssembleDOListFinishThisMonth.stream()
         .map(MesBeginConvertAssembleDetailDO::getTaskId)
         .collect(Collectors.toSet());
      new ArrayList();
      if (taskIdsFinishThisMonth.size() > 0) {
         List<MesBuildingTaskProcess> var129 = this.mesBuildingTaskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIdsFinishThisMonth))
                  .orderByDesc(MesBuildingTaskProcess::getSequence)
            );
         Map<Long, Map<Integer, List<MesBuildingTaskProcess>>> mesBuildingTaskProcessMapFinishThisMonth = var129.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId, Collectors.groupingBy(MesBuildingTaskProcess::getSequence)));
         Map<String, List<MesBeginConvertAssembleDetailDO>> mesBeginConvertAssembleDOMapFinishThisMonth = mesBeginConvertAssembleDOListFinish.stream()
            .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getStructureType));

         for (Entry<String, List<MesBeginConvertAssembleDetailDO>> entry : mesBeginConvertAssembleDOMapFinishThisMonth.entrySet()) {
            String key = entry.getKey();
            Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(key, new HashMap<>());
            List<MesBeginConvertAssembleDetailDO> projectList = entry.getValue();
            Map<Long, List<MesBeginConvertAssembleDetailDO>> projectMap = projectList.stream()
               .collect(Collectors.groupingBy(MesBeginConvertAssembleDetailDO::getProjectId));
            Map<Long, BigDecimal> projectWeightMap = new HashMap<>();
            Map<Long, BigDecimal> projectWeightConvertMap = new HashMap<>();

            for (Entry<Long, List<MesBeginConvertAssembleDetailDO>> projectEntry : projectMap.entrySet()) {
               Long projectId = projectEntry.getKey();
               List<MesBeginConvertAssembleDetailDO> taskList = projectEntry.getValue();
               BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
               BigDecimal totalConvertGrossWeightSum = BigDecimal.ZERO;

               for (int i = 0; i < taskList.size(); i++) {
                  MesBeginConvertAssembleDetailDO mesBeginConvertAssembleDetailDO = taskList.get(i);
                  BigDecimal grossWeight = mesBeginConvertAssembleDetailDO.getGrossWeight();
                  List<MesBuildingTaskProcess> mesBuildingTaskProcesses = mesBuildingTaskProcessMapFinishThisMonth.get(
                        mesBeginConvertAssembleDetailDO.getTaskId()
                     )
                     .get(mesBeginConvertAssembleDetailDO.getSequence() - 1);
                  Long processId = mesBuildingTaskProcesses.get(0).getProcessId();
                  MesProcessConversionRate mesProcessConversionRate = mesProcessConversionRateMap.get(processId);
                  if (processId != null) {
                     MesBuildingProduceTeamReport mesBuildingProduceTeamReport = mesBuildingProduceTeamReportMap.get(
                        processId + "-" + mesBeginConvertAssembleDetailDO.getAssembleId() + "-" + mesBeginConvertAssembleDetailDO.getAssembleNumber()
                     );
                     if (mesBuildingProduceTeamReport != null) {
                        LocalDate localDate = mesBuildingProduceTeamReport.getCreateTime().toLocalDate();
                        if (localDate.getMonthValue() != date.getMonthValue()) {
                           totalGrossWeightSum = totalGrossWeightSum.add(grossWeight);
                           if (mesProcessConversionRate != null) {
                              totalConvertGrossWeightSum = totalConvertGrossWeightSum.add(
                                 grossWeight.multiply(mesProcessConversionRate.getConversionRate()).divide(BigDecimal.valueOf(100L))
                              );
                           }
                        }
                     }
                  }
               }

               projectWeightMap.merge(projectId, totalGrossWeightSum, BigDecimal::add);
               projectWeightConvertMap.merge(projectId, totalConvertGrossWeightSum, BigDecimal::add);
            }

            structureWeightAssembleTwoThisMonthMap.put(key, projectWeightMap);
            structureConvertWeightAssembleTwoThisMonthMap.put(key, projectWeightConvertMap);
         }
      }

      List<MesBeginConvertDetailDO> mesBeginConvertDOPartListThisMonth = this.mesBuildingOutputReportMapper
         .beginConvertPartGroupProjectThisMonth(yearMonth, workshopId, structureType);
      Map<String, Map<Long, BigDecimal>> structureWeightPartThisMonthMap = new HashMap<>(20);
      Map<String, Map<Long, BigDecimal>> structureConvertWeightPartThisMonthMap = new HashMap<>(20);
      getProjectWeightMap(mesBeginConvertDOPartListThisMonth, structureWeightPartThisMonthMap);
      getProjectConvertWeightMap(mesBeginConvertDOPartListThisMonth, structureConvertWeightPartThisMonthMap, artifactClassProcessConversionRateMap);
      this.mergeMaps(structureWeightMap, structureWeightAssembleOneMap);
      this.mergeMaps(structureWeightMap, structureWeightAssembleTwoMap);
      this.mergeMaps(structureWeightMap, structureWeightPartMap);
      this.mergeMaps(structureConvertWeightMap, structureConvertWeightAssembleOneMap);
      this.mergeMaps(structureConvertWeightMap, structureConvertWeightAssembleTwoMap);
      this.mergeMaps(structureConvertWeightMap, structureConvertWeightPartMap);
      this.mergeMaps(structureWeightMapThisMonth, structureWeightAssembleOneThisMonthMap);
      this.mergeMaps(structureWeightMapThisMonth, structureWeightAssembleTwoThisMonthMap);
      this.mergeMaps(structureWeightMapThisMonth, structureWeightPartThisMonthMap);
      this.mergeMaps(structureConvertWeightMapThisMonth, structureConvertWeightAssembleOneThisMonthMap);
      this.mergeMaps(structureConvertWeightMapThisMonth, structureConvertWeightAssembleTwoThisMonthMap);
      this.mergeMaps(structureConvertWeightMapThisMonth, structureConvertWeightPartThisMonthMap);
      List<FinishedProductWarehousingSummaryDetailDO> finishedProductWarehousingSummaryDOList = new ArrayList<>();
      Map<String, Map<Long, BigDecimal>> beginPutPartMap = new HashMap<>();

      for (FinishedProductWarehousingSummaryDetailDO outputDO : monthlyWorkshopOutPutDOListBeginUsed) {
         beginPutPartMap.computeIfAbsent(outputDO.getStructureType(), k -> new HashMap<>())
            .merge(outputDO.getProjectId(), outputDO.getBeginPutPart(), BigDecimal::add);
      }

      Map<String, Map<Long, BigDecimal>> beginFinishProductMap = new HashMap<>();

      for (FinishedProductWarehousingSummaryDetailDO outputDO : monthlyWorkshopOutPutDOListBeginFinish) {
         beginFinishProductMap.computeIfAbsent(outputDO.getStructureType(), k -> new HashMap<>())
            .merge(outputDO.getProjectId(), outputDO.getBeginFinishProduct(), BigDecimal::add);
      }

      Map<String, Map<Long, BigDecimal>> thisMonthPutPartMap = new HashMap<>();

      for (FinishedProductWarehousingSummaryDetailDO outputDO : monthlyWorkshopOutPutDOListThisMonthUsed) {
         thisMonthPutPartMap.computeIfAbsent(outputDO.getStructureType(), k -> new HashMap<>())
            .merge(outputDO.getProjectId(), outputDO.getThisMonthPutPart(), BigDecimal::add);
      }

      Map<String, Map<Long, BigDecimal>> thisMonthFinishProductMap = new HashMap<>();

      for (FinishedProductWarehousingSummaryDetailDO outputDO : monthlyWorkshopOutPutDOListThisMonthFinish) {
         thisMonthFinishProductMap.computeIfAbsent(outputDO.getStructureType(), k -> new HashMap<>())
            .merge(outputDO.getProjectId(), outputDO.getThisMonthFinishProduct(), BigDecimal::add);
      }

      // A project with only finished products still needs a detail row, with no half-product weight.
      thisMonthFinishProductMap.forEach((type, projects) -> projects.keySet().forEach(projectId -> {
         structureWeightMap.computeIfAbsent(type, k -> new HashMap<>()).putIfAbsent(projectId, BigDecimal.ZERO);
         structureConvertWeightMap.computeIfAbsent(type, k -> new HashMap<>()).putIfAbsent(projectId, BigDecimal.ZERO);
         structureWeightMapThisMonth.computeIfAbsent(type, k -> new HashMap<>()).putIfAbsent(projectId, BigDecimal.ZERO);
         structureConvertWeightMapThisMonth.computeIfAbsent(type, k -> new HashMap<>()).putIfAbsent(projectId, BigDecimal.ZERO);
      }));
      List<ContractProject> contractProjectList = this.contractProjectService.list();
      Map<Long, String> projectMap = contractProjectList.stream().collect(Collectors.toMap(ContractProject::getId, ContractProject::getShortName));
      structureWeightMap.forEach(
         (key, value) -> {
            Map<Long, BigDecimal> projectWeightMap = structureWeightMap.get(key);
            Integer typeNumber = 1;

            for (Entry<Long, BigDecimal> entry : projectWeightMap.entrySet()) {
               Long projectId = entry.getKey();
               FinishedProductWarehousingSummaryDetailDO finishedProductWarehousingSummaryDO = new FinishedProductWarehousingSummaryDetailDO();
               Integer var18x = typeNumber;
               typeNumber = typeNumber + 1;
               finishedProductWarehousingSummaryDO.setTypeNumber(var18x);
               finishedProductWarehousingSummaryDO.setProjectName(projectMap.get(projectId));
               finishedProductWarehousingSummaryDO.setProjectId(projectId);
               finishedProductWarehousingSummaryDO.setStructureType(key);
               finishedProductWarehousingSummaryDO.setBeginPutPart(
                  beginPutPartMap.getOrDefault(key, new HashMap<>()).getOrDefault(projectId, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, 4)
               );
               finishedProductWarehousingSummaryDO.setBeginFinishProduct(
                  beginFinishProductMap.getOrDefault(key, new HashMap<>()).getOrDefault(projectId, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 3, 4)
               );
               finishedProductWarehousingSummaryDO.setBeginHalfProduct(entry.getValue().divide(BigDecimal.valueOf(1000L), 3, 4));
               finishedProductWarehousingSummaryDO.setBeginConvertFinishProduct(
                  structureConvertWeightMap.get(key).get(projectId).divide(BigDecimal.valueOf(1000L), 3, 4)
               );
               finishedProductWarehousingSummaryDO.setThisMonthPutPart(
                  thisMonthPutPartMap.getOrDefault(key, new HashMap<>())
                     .getOrDefault(projectId, BigDecimal.ZERO)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
               );
               finishedProductWarehousingSummaryDO.setThisMonthFinishProduct(
                  thisMonthFinishProductMap.getOrDefault(key, new HashMap<>())
                     .getOrDefault(projectId, BigDecimal.ZERO)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
               );
               finishedProductWarehousingSummaryDO.setThisMonthHalfProduct(
                  structureWeightMapThisMonth.get(key).get(projectId).divide(BigDecimal.valueOf(1000L), 3, 4)
               );
               finishedProductWarehousingSummaryDO.setThisMonthConvertFinishProduct(
                  structureConvertWeightMapThisMonth.get(key).get(projectId).divide(BigDecimal.valueOf(1000L), 3, 4)
               );
               finishedProductWarehousingSummaryDO.setTotalPutPart(
                  finishedProductWarehousingSummaryDO.getBeginPutPart().add(finishedProductWarehousingSummaryDO.getThisMonthPutPart())
               );
               finishedProductWarehousingSummaryDO.setTotalFinishProduct(
                  finishedProductWarehousingSummaryDO.getBeginFinishProduct().add(finishedProductWarehousingSummaryDO.getThisMonthFinishProduct())
               );
               finishedProductWarehousingSummaryDO.setThisMonthFinishOutput(
                  finishedProductWarehousingSummaryDO.getThisMonthFinishProduct()
                     .subtract(finishedProductWarehousingSummaryDO.getBeginConvertFinishProduct())
                     .add(finishedProductWarehousingSummaryDO.getThisMonthConvertFinishProduct())
               );
               finishedProductWarehousingSummaryDOList.add(finishedProductWarehousingSummaryDO);
            }
         }
      );
      List<MesMaterialFeedingReportDetailDTO> mesMaterialFeedingReportDetailDTOS = this.feedingReportDetailService.allFeedingList(workshopId, structureType);
      YearMonth dateYearMonth = YearMonth.from(date);
      if (CollectionUtils.isNotEmpty(mesMaterialFeedingReportDetailDTOS) && CollectionUtils.isNotEmpty(finishedProductWarehousingSummaryDOList)) {
         Map<Long, List<MesMaterialFeedingReportDetailDTO>> feedingReportDetailDTOMap = mesMaterialFeedingReportDetailDTOS.stream()
            .collect(Collectors.groupingBy(MesMaterialFeedingReportDetail::getProjectId));

         for (FinishedProductWarehousingSummaryDetailDO productWarehousingSummaryDO : finishedProductWarehousingSummaryDOList) {
            if (productWarehousingSummaryDO.getProjectId() != null) {
               List<MesMaterialFeedingReportDetailDTO> detailDTOS = feedingReportDetailDTOMap.get(productWarehousingSummaryDO.getProjectId());
               if (CollectionUtils.isNotEmpty(detailDTOS)) {
                  List<MesMaterialFeedingReportDetailDTO> beginningPeriodReportDetailDTOs = detailDTOS.stream()
                     .filter(e -> YearMonth.from(e.getCreateTime()).isBefore(dateYearMonth))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(beginningPeriodReportDetailDTOs)) {
                     productWarehousingSummaryDO.setBeginPutPart(
                        beginningPeriodReportDetailDTOs.stream()
                           .map(MesMaterialFeedingReportDetail::getFeedingQuantity)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(BigDecimal.valueOf(1000L))
                     );
                  }

                  List<MesMaterialFeedingReportDetailDTO> endPeriodReportDetailDTOs = detailDTOS.stream()
                     .filter(e -> YearMonth.from(e.getCreateTime()).equals(dateYearMonth))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(endPeriodReportDetailDTOs)) {
                     productWarehousingSummaryDO.setThisMonthPutPart(
                        endPeriodReportDetailDTOs.stream()
                           .map(MesMaterialFeedingReportDetail::getFeedingQuantity)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(BigDecimal.valueOf(1000L))
                     );
                  }

                  productWarehousingSummaryDO.setTotalPutPart(
                     detailDTOS.stream()
                        .map(MesMaterialFeedingReportDetail::getFeedingQuantity)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L))
                  );
               }
            }
         }
      }

      FinishedProductWarehousingSummaryDetailDO finishedProductWarehousingSummaryDetailDO = new FinishedProductWarehousingSummaryDetailDO();
      String projectName = "合计";
      finishedProductWarehousingSummaryDetailDO.setProjectName(projectName);
      BigDecimal beginPutPart = BigDecimal.ZERO;
      BigDecimal beginFinishProduct = BigDecimal.ZERO;
      BigDecimal beginHalfProduct = BigDecimal.ZERO;
      BigDecimal beginConvertFinishProduct = BigDecimal.ZERO;
      BigDecimal thisMonthPutPart = BigDecimal.ZERO;
      BigDecimal thisMonthFinishProduct = BigDecimal.ZERO;
      BigDecimal thisMonthHalfProduct = BigDecimal.ZERO;
      BigDecimal thisMonthConvertFinishProduct = BigDecimal.ZERO;
      BigDecimal totalPutPart = BigDecimal.ZERO;
      BigDecimal totalFinishProduct = BigDecimal.ZERO;
      BigDecimal thisMonthFinishOutput = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(finishedProductWarehousingSummaryDOList)) {
         for (FinishedProductWarehousingSummaryDetailDO obj : finishedProductWarehousingSummaryDOList) {
            beginPutPart = beginPutPart.add(obj.getBeginPutPart());
            beginFinishProduct = beginFinishProduct.add(obj.getBeginFinishProduct());
            beginHalfProduct = beginHalfProduct.add(obj.getBeginHalfProduct());
            beginConvertFinishProduct = beginConvertFinishProduct.add(obj.getBeginConvertFinishProduct());
            thisMonthPutPart = thisMonthPutPart.add(obj.getThisMonthPutPart());
            thisMonthFinishProduct = thisMonthFinishProduct.add(obj.getThisMonthFinishProduct());
            thisMonthHalfProduct = thisMonthHalfProduct.add(obj.getThisMonthHalfProduct());
            thisMonthConvertFinishProduct = thisMonthConvertFinishProduct.add(obj.getThisMonthConvertFinishProduct());
            totalPutPart = totalPutPart.add(obj.getTotalPutPart());
            totalFinishProduct = totalFinishProduct.add(obj.getTotalFinishProduct());
            thisMonthFinishOutput = thisMonthFinishOutput.add(obj.getThisMonthFinishOutput());
            finishedProductWarehousingSummaryDetailDO.setStructureType(obj.getStructureType());
            finishedProductWarehousingSummaryDetailDO.setBeginPutPart(beginPutPart);
            finishedProductWarehousingSummaryDetailDO.setBeginFinishProduct(beginFinishProduct);
            finishedProductWarehousingSummaryDetailDO.setBeginHalfProduct(beginHalfProduct);
            finishedProductWarehousingSummaryDetailDO.setBeginConvertFinishProduct(beginConvertFinishProduct);
            finishedProductWarehousingSummaryDetailDO.setThisMonthPutPart(thisMonthPutPart);
            finishedProductWarehousingSummaryDetailDO.setThisMonthFinishProduct(thisMonthFinishProduct);
            finishedProductWarehousingSummaryDetailDO.setThisMonthHalfProduct(thisMonthHalfProduct);
            finishedProductWarehousingSummaryDetailDO.setThisMonthConvertFinishProduct(thisMonthConvertFinishProduct);
            finishedProductWarehousingSummaryDetailDO.setTotalPutPart(totalPutPart);
            finishedProductWarehousingSummaryDetailDO.setTotalFinishProduct(totalFinishProduct);
            finishedProductWarehousingSummaryDetailDO.setThisMonthFinishOutput(thisMonthFinishOutput);
         }

         finishedProductWarehousingSummaryDOList.add(finishedProductWarehousingSummaryDetailDO);
      }

      return finishedProductWarehousingSummaryDOList;
   }

   @Override
   public void finishedProductWarehousingSummaryDetailDownload(
      String yearMonth, Long workshopId, String structureType, String workshopName, HttpServletResponse response
   ) {
      List<FinishedProductWarehousingSummaryDetailDO> finishedProductWarehousingSummaryDetailDOS = this.finishedProductWarehousingSummaryDetail(
         yearMonth, workshopId, null, workshopName
      );
      finishedProductWarehousingSummaryDetailDOS = finishedProductWarehousingSummaryDetailDOS.stream()
         .filter(obj -> !"".equals(obj.getStructureType()))
         .collect(Collectors.toList());
      String structureTypes = finishedProductWarehousingSummaryDetailDOS.stream()
         .map(FinishedProductWarehousingSummaryDetailDO::getStructureType)
         .distinct()
         .collect(Collectors.joining(","));
      Map<String, List<FinishedProductWarehousingSummaryDetailDO>> groupedByStructureType = finishedProductWarehousingSummaryDetailDOS.stream()
         .collect(Collectors.groupingBy(FinishedProductWarehousingSummaryDetailDO::getStructureType));
      List<FinishedProductWarehousingSummaryDetailReport> finishedProductWarehousingSummaryDetailReportList = new ArrayList<>();
      groupedByStructureType.forEach(
         (structureTypeName, finishedProductWarehousingSummaryDetailDOList) -> {
            Integer typeNumber = 1;

            for (FinishedProductWarehousingSummaryDetailDO finishedProductWarehousingSummaryDetailDO : finishedProductWarehousingSummaryDetailDOList) {
               if (typeNumber == 1) {
                  FinishedProductWarehousingSummaryDetailReport finishedProductWarehousingSummaryDetailReport = new FinishedProductWarehousingSummaryDetailReport();
                  finishedProductWarehousingSummaryDetailReport.setProjectName(structureTypeName);
                  finishedProductWarehousingSummaryDetailReportList.add(finishedProductWarehousingSummaryDetailReport);
               }

               FinishedProductWarehousingSummaryDetailReport finishedProductWarehousingSummaryDetailReportTwo = new FinishedProductWarehousingSummaryDetailReport();
               finishedProductWarehousingSummaryDetailReportTwo.setProjectName(finishedProductWarehousingSummaryDetailDO.getProjectName());
               finishedProductWarehousingSummaryDetailReportTwo.setBeginPutPart(finishedProductWarehousingSummaryDetailDO.getBeginPutPart());
               finishedProductWarehousingSummaryDetailReportTwo.setBeginFinishProduct(finishedProductWarehousingSummaryDetailDO.getBeginFinishProduct());
               finishedProductWarehousingSummaryDetailReportTwo.setBeginHalfProduct(finishedProductWarehousingSummaryDetailDO.getBeginHalfProduct());
               finishedProductWarehousingSummaryDetailReportTwo.setBeginConvertFinishProduct(
                  finishedProductWarehousingSummaryDetailDO.getBeginConvertFinishProduct()
               );
               finishedProductWarehousingSummaryDetailReportTwo.setThisMonthPutPart(finishedProductWarehousingSummaryDetailDO.getThisMonthPutPart());
               finishedProductWarehousingSummaryDetailReportTwo.setThisMonthFinishProduct(finishedProductWarehousingSummaryDetailDO.getThisMonthFinishProduct());
               finishedProductWarehousingSummaryDetailReportTwo.setThisMonthHalfProduct(finishedProductWarehousingSummaryDetailDO.getThisMonthHalfProduct());
               finishedProductWarehousingSummaryDetailReportTwo.setThisMonthConvertFinishProduct(
                  finishedProductWarehousingSummaryDetailDO.getThisMonthConvertFinishProduct()
               );
               finishedProductWarehousingSummaryDetailReportTwo.setTotalPutPart(finishedProductWarehousingSummaryDetailDO.getTotalPutPart());
               finishedProductWarehousingSummaryDetailReportTwo.setTotalFinishProduct(finishedProductWarehousingSummaryDetailDO.getTotalFinishProduct());
               finishedProductWarehousingSummaryDetailReportTwo.setThisMonthFinishOutput(finishedProductWarehousingSummaryDetailDO.getThisMonthFinishOutput());
               if (!finishedProductWarehousingSummaryDetailDO.getProjectName().equals("合计")) {
                  Integer var7x = typeNumber;
                  typeNumber = typeNumber + 1;
                  finishedProductWarehousingSummaryDetailReportTwo.setTypeNumber(var7x);
               }

               finishedProductWarehousingSummaryDetailReportList.add(finishedProductWarehousingSummaryDetailReportTwo);
            }
         }
      );
      LocalDate date = Instant.ofEpochMilli(Long.valueOf(yearMonth)).atZone(ZoneId.systemDefault()).toLocalDate();
      response.reset();
      response.setContentType("application/vnd.ms-excel;charset=UTF-8");
      String fileName = null;

      try {
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Access-Control-Allow-Origin", "*");
         fileName = "制成品入库汇总明细.xlsx";
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }

      response.setCharacterEncoding("utf-8");
      ClassPathResource classPathResource = new ClassPathResource("/files/finishedProductWarehousingSummaryDetail.xlsx");

      try (
         InputStream inputStream = classPathResource.getInputStream();
         ServletOutputStream outputStream = response.getOutputStream();
      ) {
         ExcelWriter excelWriter = EasyExcel.write(outputStream, FinishedProductWarehousingSummaryDetailReport.class)
            .withTemplate(inputStream)
            .excelType(ExcelTypeEnum.XLSX)
            .build();
         WriteSheet writeSheet = EasyExcel.writerSheet().build();
         Map<String, Object> dateMap = new HashMap<>();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月");
         String formattedDate = date.format(formatter);
         dateMap.put("date", formattedDate);
         dateMap.put("workshopName", workshopName);
         dateMap.put("structureTypes", structureTypes);
         excelWriter.fill(dateMap, writeSheet);
         excelWriter.fill(finishedProductWarehousingSummaryDetailReportList, writeSheet);
         excelWriter.finish();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private void getStructureWeightMap(List<MesBeginConvertDO> mesBeginConvertDOArtifactList, Map<String, BigDecimal> structureWeightMap) {
      Map<String, List<MesBeginConvertDO>> groupedTasks = mesBeginConvertDOArtifactList.stream()
         .collect(Collectors.groupingBy(MesBeginConvertDO::getStructureType));

      for (Entry<String, List<MesBeginConvertDO>> entry : groupedTasks.entrySet()) {
         String structureType = entry.getKey();
         List<MesBeginConvertDO> taskList = entry.getValue();
         taskList.sort(Comparator.comparingInt(MesBeginConvertDO::getSequence));
         BigDecimal totalGrossWeightSum = BigDecimal.ZERO;

         for (int i = 0; i < taskList.size(); i++) {
            MesBeginConvertDO task = taskList.get(i);
            if (i == 0 && i == taskList.size() - 1) {
               BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
               totalGrossWeightSum = totalGrossWeightSum.add(result);
               break;
            }

            if (i == taskList.size() - 1) {
               BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
               totalGrossWeightSum = totalGrossWeightSum.add(result);
               break;
            }

            if (i > 0) {
               MesBeginConvertDO previousTask = taskList.get(i - 1);
               int difference = previousTask.getCompleteQuantity() - task.getCompleteQuantity();
               BigDecimal weightDifference = new BigDecimal(difference).multiply(task.getGrossWeight());
               totalGrossWeightSum = totalGrossWeightSum.add(weightDifference);
            }
         }

         structureWeightMap.merge(structureType, totalGrossWeightSum, BigDecimal::add);
      }

      structureWeightMap.forEach(
         (structureTypex, totalGrossWeight) -> System.out.println("Total Gross Weight for structureType " + structureTypex + ": " + totalGrossWeight)
      );
   }

   private void getStructureConvertWeightMap(
      List<MesBeginConvertDO> mesBeginConvertDOArtifactList,
      Map<String, BigDecimal> structureConvertWeightMap,
      Map<String, Map<Long, MesProcessConversionRate>> artifactClassProcessConversionRateMap
   ) {
      Map<String, List<MesBeginConvertDO>> groupedTasks = mesBeginConvertDOArtifactList.stream()
         .collect(Collectors.groupingBy(MesBeginConvertDO::getStructureType));

      for (Entry<String, List<MesBeginConvertDO>> entry : groupedTasks.entrySet()) {
         String structureType = entry.getKey();
         Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(structureType, new HashMap<>());
         List<MesBeginConvertDO> taskList = entry.getValue();
         taskList.sort(Comparator.comparingInt(MesBeginConvertDO::getSequence));
         BigDecimal totalGrossWeightSum = BigDecimal.ZERO;

         for (int i = 0; i < taskList.size(); i++) {
            MesBeginConvertDO task = taskList.get(i);
            if (i == 0 && i == taskList.size() - 1) {
               BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
               if (mesProcessConversionRateMap.get(task.getProcessId()) != null) {
                  BigDecimal conversionRate = mesProcessConversionRateMap.get(task.getProcessId()).getConversionRate().divide(BigDecimal.valueOf(100L));
                  result = result.multiply(conversionRate);
                  totalGrossWeightSum = totalGrossWeightSum.add(result);
               }
               break;
            }

            if (i == taskList.size() - 1) {
               if (mesProcessConversionRateMap.get(task.getProcessId()) != null) {
                  BigDecimal conversionRate = mesProcessConversionRateMap.get(task.getProcessId()).getConversionRate().divide(BigDecimal.valueOf(100L));
                  BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
                  result = result.multiply(conversionRate);
                  totalGrossWeightSum = totalGrossWeightSum.add(result);
               }
               break;
            }

            if (i > 0) {
               MesBeginConvertDO previousTask = taskList.get(i - 1);
               int difference = previousTask.getCompleteQuantity() - task.getCompleteQuantity();
               BigDecimal weightDifference = new BigDecimal(difference).multiply(task.getGrossWeight());
               if (mesProcessConversionRateMap.get(task.getProcessId()) != null) {
                  BigDecimal conversionRate = mesProcessConversionRateMap.get(task.getProcessId()).getConversionRate().divide(BigDecimal.valueOf(100L));
                  weightDifference = weightDifference.multiply(conversionRate);
                  totalGrossWeightSum = totalGrossWeightSum.add(weightDifference);
               }
            }
         }

         structureConvertWeightMap.merge(structureType, totalGrossWeightSum, BigDecimal::add);
      }

      structureConvertWeightMap.forEach(
         (structureTypex, totalGrossWeight) -> System.out.println("Total Gross Weight for structureType " + structureTypex + ": " + totalGrossWeight)
      );
   }

   private static void getProjectWeightMap(List<MesBeginConvertDetailDO> mesBeginConvertDetailDOList, Map<String, Map<Long, BigDecimal>> structureWeightMap) {
      Map<String, List<MesBeginConvertDetailDO>> groupedTasks = mesBeginConvertDetailDOList.stream().collect(Collectors.groupingBy(e -> e.getStructureType()));

      for (Entry<String, List<MesBeginConvertDetailDO>> entry : groupedTasks.entrySet()) {
         String structureType = entry.getKey();
         List<MesBeginConvertDetailDO> structureTypeList = entry.getValue();
         Map<Long, List<MesBeginConvertDetailDO>> mesProjectList = structureTypeList.stream().collect(Collectors.groupingBy(e -> e.getProjectId()));
         Map<Long, BigDecimal> projectWeightMap = new HashMap<>();

         for (Entry<Long, List<MesBeginConvertDetailDO>> mesProject : mesProjectList.entrySet()) {
            Long projectId = mesProject.getKey();
            BigDecimal totalGrossWeightSum = BigDecimal.ZERO;
            List<MesBeginConvertDetailDO> mesProjectListValue = mesProject.getValue();
            mesProjectListValue.sort(Comparator.comparingInt(MesBeginConvertDetailDO::getSequence));

            for (int i = 0; i < mesProjectListValue.size(); i++) {
               MesBeginConvertDetailDO task = mesProjectListValue.get(i);
               if (i == 0 && i == mesProjectListValue.size() - 1) {
                  BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
                  totalGrossWeightSum = totalGrossWeightSum.add(result);
                  break;
               }

               if (i == mesProjectListValue.size() - 1) {
                  BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
                  totalGrossWeightSum = totalGrossWeightSum.add(result);
                  break;
               }

               if (i > 0) {
                  MesBeginConvertDetailDO previousTask = mesProjectListValue.get(i - 1);
                  int difference = previousTask.getCompleteQuantity() - task.getCompleteQuantity();
                  BigDecimal weightDifference = new BigDecimal(difference).multiply(task.getGrossWeight());
                  totalGrossWeightSum = totalGrossWeightSum.add(weightDifference);
               }
            }

            projectWeightMap.merge(projectId, totalGrossWeightSum, BigDecimal::add);
         }

         structureWeightMap.put(structureType, projectWeightMap);
      }

      structureWeightMap.forEach(
         (structureTypex, totalGrossWeight) -> System.out.println("Total Gross Weight for structureType " + structureTypex + ": " + totalGrossWeight)
      );
   }

   private static void getProjectConvertWeightMap(
      List<MesBeginConvertDetailDO> mesBeginConvertDetailDOList,
      Map<String, Map<Long, BigDecimal>> structureConvertWeightMap,
      Map<String, Map<Long, MesProcessConversionRate>> artifactClassProcessConversionRateMap
   ) {
      Map<String, List<MesBeginConvertDetailDO>> groupedTasks = mesBeginConvertDetailDOList.stream()
         .collect(Collectors.groupingBy(MesBeginConvertDetailDO::getStructureType));

      for (Entry<String, List<MesBeginConvertDetailDO>> entry : groupedTasks.entrySet()) {
         String structureType = entry.getKey();
         Map<Long, MesProcessConversionRate> mesProcessConversionRateMap = artifactClassProcessConversionRateMap.getOrDefault(structureType, new HashMap<>());
         List<MesBeginConvertDetailDO> structureTypeList = entry.getValue();
         structureTypeList.sort(Comparator.comparingInt(MesBeginConvertDetailDO::getSequence));
         Map<Long, List<MesBeginConvertDetailDO>> mesProjectList = structureTypeList.stream().collect(Collectors.groupingBy(e -> e.getProjectId()));
         Map<Long, BigDecimal> projectWeightMap = new HashMap<>();

         for (Entry<Long, List<MesBeginConvertDetailDO>> mesProject : mesProjectList.entrySet()) {
            Long projectId = mesProject.getKey();
            List<MesBeginConvertDetailDO> mesProjectListValue = mesProject.getValue();
            BigDecimal totalGrossWeightSum = BigDecimal.ZERO;

            for (int i = 0; i < structureTypeList.size(); i++) {
               MesBeginConvertDetailDO task = mesProjectListValue.get(i);
               if (i == 0 && i == mesProjectListValue.size() - 1) {
                  BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
                  if (mesProcessConversionRateMap.get(task.getProcessId()) != null) {
                     BigDecimal conversionRate = mesProcessConversionRateMap.get(task.getProcessId()).getConversionRate().divide(BigDecimal.valueOf(100L));
                     result = result.multiply(conversionRate);
                     totalGrossWeightSum = totalGrossWeightSum.add(result);
                  }
                  break;
               }

               if (i == mesProjectListValue.size() - 1) {
                  if (mesProcessConversionRateMap.get(task.getProcessId()) != null) {
                     BigDecimal conversionRate = mesProcessConversionRateMap.get(task.getProcessId()).getConversionRate().divide(BigDecimal.valueOf(100L));
                     BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
                     result = result.multiply(conversionRate);
                     totalGrossWeightSum = totalGrossWeightSum.add(result);
                  }
                  break;
               }

               if (i > 0) {
                  MesBeginConvertDetailDO previousTask = mesProjectListValue.get(i - 1);
                  int difference = previousTask.getCompleteQuantity() - task.getCompleteQuantity();
                  BigDecimal weightDifference = new BigDecimal(difference).multiply(task.getGrossWeight());
                  if (mesProcessConversionRateMap.get(task.getProcessId()) != null) {
                     BigDecimal conversionRate = mesProcessConversionRateMap.get(task.getProcessId()).getConversionRate().divide(BigDecimal.valueOf(100L));
                     weightDifference = weightDifference.multiply(conversionRate);
                     totalGrossWeightSum = totalGrossWeightSum.add(weightDifference);
                  }
               }
            }

            projectWeightMap.merge(projectId, totalGrossWeightSum, BigDecimal::add);
         }

         structureConvertWeightMap.put(structureType, projectWeightMap);
      }

      structureConvertWeightMap.forEach(
         (structureTypex, totalGrossWeight) -> System.out.println("Total Gross Weight for structureType " + structureTypex + ": " + totalGrossWeight)
      );
   }

   public static void main(String[] args) {
      Map<String, Map<Long, BigDecimal>> map1 = new HashMap<>();
      Map<String, Map<Long, BigDecimal>> map2 = new HashMap<>();
      Map<Long, BigDecimal> subMap1 = new HashMap<>();
      subMap1.put(1L, new BigDecimal("100.50"));
      subMap1.put(2L, new BigDecimal("200.75"));
      map1.put("key1", subMap1);
      Map<Long, BigDecimal> subMap2 = new HashMap<>();
      subMap2.put(1L, new BigDecimal("50.25"));
      subMap2.put(3L, new BigDecimal("300.10"));
      map2.put("key1", subMap2);
      map2.put("key2", subMap2);

      for (Entry<String, Map<Long, BigDecimal>> entry : map2.entrySet()) {
         String key = entry.getKey();
         Map<Long, BigDecimal> subMap = entry.getValue();
         if (map1.containsKey(key)) {
            Map<Long, BigDecimal> targetSubMap = map1.get(key);

            for (Entry<Long, BigDecimal> subEntry : subMap.entrySet()) {
               Long subKey = subEntry.getKey();
               BigDecimal subValue = subEntry.getValue();
               if (targetSubMap.containsKey(subKey)) {
                  targetSubMap.put(subKey, targetSubMap.get(subKey).add(subValue));
               } else {
                  targetSubMap.put(subKey, subValue);
               }
            }
         } else {
            map1.put(key, new HashMap<>(subMap));
         }
      }

      System.out.println("Merged map1:");

      for (Entry<String, Map<Long, BigDecimal>> entry : map1.entrySet()) {
         System.out.println("Key: " + entry.getKey());

         for (Entry<Long, BigDecimal> subEntry : entry.getValue().entrySet()) {
            System.out.println("  Long key: " + subEntry.getKey() + ", Value: " + subEntry.getValue());
         }
      }

      List<MesBeginConvertDO> tasks = new ArrayList<>();
      tasks.add(new MesBeginConvertDO(7918L, "轻钢类", 14066L, 35L, "涂装", 4, 2, 3, new BigDecimal(1)));
      tasks.add(new MesBeginConvertDO(7918L, "轻钢类", 14066L, 35L, "清磨", 4, 2, 2, new BigDecimal(1)));
      tasks.add(new MesBeginConvertDO(7918L, "轻钢类", 14066L, 35L, "焊接", 4, 3, 1, new BigDecimal(1)));
      tasks.add(new MesBeginConvertDO(7918L, "轻钢类", 14066L, 35L, "装配", 4, 4, 0, new BigDecimal(1)));
      Map<String, BigDecimal> structureWeightMap = new HashMap<>();
      Map<String, List<MesBeginConvertDO>> groupedTasks = tasks.stream().collect(Collectors.groupingBy(MesBeginConvertDO::getStructureType));

      for (Entry<String, List<MesBeginConvertDO>> entry : groupedTasks.entrySet()) {
         String structureType = entry.getKey();
         List<MesBeginConvertDO> taskList = entry.getValue();
         taskList.sort(Comparator.comparingInt(MesBeginConvertDO::getSequence));
         BigDecimal totalGrossWeightSum = BigDecimal.ZERO;

         for (int i = 0; i < taskList.size(); i++) {
            MesBeginConvertDO task = taskList.get(i);
            if (i == 0 && i == taskList.size() - 1) {
               BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
               totalGrossWeightSum = totalGrossWeightSum.add(result);
               break;
            }

            if (i == taskList.size() - 1) {
               BigDecimal result = new BigDecimal(task.getCompleteQuantity()).multiply(task.getGrossWeight());
               totalGrossWeightSum = totalGrossWeightSum.add(result);
               break;
            }

            if (i > 0) {
               MesBeginConvertDO previousTask = taskList.get(i - 1);
               int difference = previousTask.getCompleteQuantity() - task.getCompleteQuantity();
               BigDecimal weightDifference = new BigDecimal(difference).multiply(task.getGrossWeight());
               totalGrossWeightSum = totalGrossWeightSum.add(weightDifference);
            }
         }

         structureWeightMap.merge(structureType, totalGrossWeightSum, BigDecimal::add);
      }

      structureWeightMap.forEach(
         (structureType, totalGrossWeight) -> System.out.println("Total Gross Weight for structureType " + structureType + ": " + totalGrossWeight)
      );
   }

   @Override
   public List<YearlyOutputComparisonVO> yearlyOutputComparison(String year, Long workshopId) {
      List<String> structureTypeList = this.mesArtifactClassService.list().stream().map(MesArtifactClass::getName).collect(Collectors.toList());
      List<YearlyOutputComparisonDO> yearlyOutputComparisonDOList = this.mesBuildingOutputReportMapper
         .yearlyOutputComparison(year, workshopId, structureTypeList);
      List<YearlyOutputComparisonVO> yearlyOutputComparisonVOList = this.yearlyOutputComparisonListConvertToVOList(yearlyOutputComparisonDOList);
      YearlyOutputComparisonVO yearlyOutputComparisonVOAll = new YearlyOutputComparisonVO();
      yearlyOutputComparisonVOAll.setStructureType("产量合计");
      List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOAllList = new ArrayList<>();

      for (int month = 1; month <= 12; month++) {
         String productMonth = String.format("%02d", month);
         BigDecimal totalNetWeight = BigDecimal.ZERO;

         for (YearlyOutputComparisonVO yearlyOutputComparisonVO : yearlyOutputComparisonVOList) {
            for (YearlyOutputComparisonMonthVO monthData : yearlyOutputComparisonVO.getYearlyOutputComparisonMonthVOList()) {
               if (monthData.getProductMonth().equals(productMonth)) {
                  totalNetWeight = totalNetWeight.add(monthData.getTotalNetWeight());
               }
            }
         }

         yearlyOutputComparisonMonthVOAllList.add(new YearlyOutputComparisonMonthVO(productMonth, totalNetWeight));
      }

      yearlyOutputComparisonVOAll.setYearlyOutputComparisonMonthVOList(yearlyOutputComparisonMonthVOAllList);
      yearlyOutputComparisonVOList.add(yearlyOutputComparisonVOAll);

      for (YearlyOutputComparisonVO yearlyOutputComparisonVO : yearlyOutputComparisonVOList) {
         List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList = yearlyOutputComparisonVO.getYearlyOutputComparisonMonthVOList();
         List<YearlyOutputComparisonMonthVO> updatedList = new ArrayList<>(yearlyOutputComparisonMonthVOList);
         YearlyOutputComparisonMonthVO firstHalf = mergeData(yearlyOutputComparisonMonthVOList, "01", "06");
         firstHalf.setProductMonth("1-6");
         YearlyOutputComparisonMonthVO secondHalf = mergeData(yearlyOutputComparisonMonthVOList, "07", "12");
         secondHalf.setProductMonth("7-12");
         YearlyOutputComparisonMonthVO thridHalf = mergeData(yearlyOutputComparisonMonthVOList, "01", "12");
         thridHalf.setProductMonth("全年合计");
         updatedList.add(6, firstHalf);
         updatedList.add(13, secondHalf);
         updatedList.add(14, thridHalf);
         yearlyOutputComparisonVO.setYearlyOutputComparisonMonthVOList(updatedList);
      }

      return yearlyOutputComparisonVOList;
   }

   @Override
   public void yearlyOutputComparisonDownload(String year, Long workshopId, String workshopName, HttpServletResponse response) {
      List<String> structureTypeList = this.mesArtifactClassService.list().stream().map(MesArtifactClass::getName).collect(Collectors.toList());
      List<YearlyOutputComparisonDO> yearlyOutputComparisonDOList = this.mesBuildingOutputReportMapper
         .yearlyOutputComparison(year, workshopId, structureTypeList);
      List<YearlyOutputComparisonVO> yearlyOutputComparisonVOList = this.yearlyOutputComparisonListConvertToVOList(yearlyOutputComparisonDOList);
      YearlyOutputComparisonVO yearlyOutputComparisonVOAll = new YearlyOutputComparisonVO();
      yearlyOutputComparisonVOAll.setStructureType("产量合计");
      List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOAllList = new ArrayList<>();

      for (int month = 1; month <= 12; month++) {
         String productMonth = String.format("%02d", month);
         BigDecimal totalNetWeight = BigDecimal.ZERO;

         for (YearlyOutputComparisonVO yearlyOutputComparisonVO : yearlyOutputComparisonVOList) {
            for (YearlyOutputComparisonMonthVO monthData : yearlyOutputComparisonVO.getYearlyOutputComparisonMonthVOList()) {
               if (monthData.getProductMonth().equals(productMonth)) {
                  totalNetWeight = totalNetWeight.add(monthData.getTotalNetWeight());
               }
            }
         }

         yearlyOutputComparisonMonthVOAllList.add(new YearlyOutputComparisonMonthVO(productMonth, totalNetWeight));
      }

      yearlyOutputComparisonVOAll.setYearlyOutputComparisonMonthVOList(yearlyOutputComparisonMonthVOAllList);
      yearlyOutputComparisonVOList.add(yearlyOutputComparisonVOAll);

      for (YearlyOutputComparisonVO yearlyOutputComparisonVO : yearlyOutputComparisonVOList) {
         List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList = yearlyOutputComparisonVO.getYearlyOutputComparisonMonthVOList();
         List<YearlyOutputComparisonMonthVO> updatedList = new ArrayList<>(yearlyOutputComparisonMonthVOList);
         YearlyOutputComparisonMonthVO firstHalf = mergeData(yearlyOutputComparisonMonthVOList, "01", "06");
         firstHalf.setProductMonth("1-6");
         YearlyOutputComparisonMonthVO secondHalf = mergeData(yearlyOutputComparisonMonthVOList, "07", "12");
         secondHalf.setProductMonth("7-12");
         YearlyOutputComparisonMonthVO thridHalf = mergeData(yearlyOutputComparisonMonthVOList, "01", "12");
         thridHalf.setProductMonth("全年合计");
         updatedList.add(6, firstHalf);
         updatedList.add(13, secondHalf);
         updatedList.add(14, thridHalf);
         yearlyOutputComparisonVO.setYearlyOutputComparisonMonthVOList(updatedList);
      }

      List<YearlyOutputComparisonRowVO> yearlyOutputComparisonRowVOList = new ArrayList<>();

      for (YearlyOutputComparisonVO yearlyOutputComparisonVO : yearlyOutputComparisonVOList) {
         YearlyOutputComparisonRowVO yearlyOutputComparisonRowVO = new YearlyOutputComparisonRowVO();
         yearlyOutputComparisonRowVO.setStructureType(yearlyOutputComparisonVO.getStructureType());
         List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList = yearlyOutputComparisonVO.getYearlyOutputComparisonMonthVOList();
         yearlyOutputComparisonRowVO.setJanuaryOutput(yearlyOutputComparisonMonthVOList.get(0).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setFebruaryOutput(yearlyOutputComparisonMonthVOList.get(1).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setMarchOutput(yearlyOutputComparisonMonthVOList.get(2).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setAprilOutput(yearlyOutputComparisonMonthVOList.get(3).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setMayOutput(yearlyOutputComparisonMonthVOList.get(4).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setJuneOutput(yearlyOutputComparisonMonthVOList.get(5).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setFirstHalfOutput(yearlyOutputComparisonMonthVOList.get(6).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setJulyOutput(yearlyOutputComparisonMonthVOList.get(7).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setAugustOutput(yearlyOutputComparisonMonthVOList.get(8).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setSeptemberOutput(yearlyOutputComparisonMonthVOList.get(9).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setOctoberOutput(yearlyOutputComparisonMonthVOList.get(10).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setNovemberOutput(yearlyOutputComparisonMonthVOList.get(11).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setDecemberOutput(yearlyOutputComparisonMonthVOList.get(12).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setSecondHalfOutput(yearlyOutputComparisonMonthVOList.get(13).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVO.setYearlyOutput(yearlyOutputComparisonMonthVOList.get(14).getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
         yearlyOutputComparisonRowVOList.add(yearlyOutputComparisonRowVO);
      }

      response.reset();
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/vnd.ms-excel;charset=utf-8");
      String fileName = null;

      try {
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Access-Control-Allow-Origin", "*");
         fileName = "年度产量报表.xlsx";
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }

      ClassPathResource classPathResource = new ClassPathResource("/files/yearlyOutputComparison.xlsx");

      try (
         InputStream inputStream = classPathResource.getInputStream();
         ServletOutputStream outputStream = response.getOutputStream();
      ) {
         ExcelWriter excelWriter = EasyExcel.write(outputStream, YearlyOutputComparisonVO.class)
            .withTemplate(inputStream)
            .excelType(ExcelTypeEnum.XLSX)
            .build();
         WriteSheet writeSheet = EasyExcel.writerSheet(0).registerWriteHandler(new CustomTemplateSheetStrategy(0, year + "年度产量")).build();
         Map<String, Object> dateMap = new HashMap<>(2);
         dateMap.put("date", year);
         dateMap.put("year", year);
         if (workshopName == null) {
            workshopName = "";
         }

         dateMap.put("workshopName", workshopName);
         excelWriter.fill(dateMap, writeSheet);
         excelWriter.fill(yearlyOutputComparisonRowVOList, writeSheet);
         excelWriter.finish();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   public List<TeamOutputStatisticsReportDO> teamOutputStatisticsReport(
      String startDate, String endDate, Long workshopId, Long productionLineId, String teamName, String processName, String processType
   ) {
      List<TeamOutputStatisticsReportDO> teamOutputStatisticsReportDOList = this.mesBuildingOutputReportMapper
         .teamOutputStatisticsReport(startDate, endDate, workshopId, productionLineId, teamName, processName, processType);
      List<TeamOutputStatisticsReportDO> teamOutputStatisticsReportDOAllList = this.mesBuildingOutputReportMapper
         .teamOutputStatisticsReport(null, null, workshopId, productionLineId, teamName, processName, processType);

      for (TeamOutputStatisticsReportDO teamOutputStatisticsReportDO : teamOutputStatisticsReportDOList) {
         for (TeamOutputStatisticsReportDO teamOutputStatisticsReportDOAll : teamOutputStatisticsReportDOAllList) {
            if (teamOutputStatisticsReportDO.getTeamId().equals(teamOutputStatisticsReportDOAll.getTeamId())) {
               teamOutputStatisticsReportDO.setTotalTaskNetWeightAll(teamOutputStatisticsReportDOAll.getTotalTaskNetWeight());
               teamOutputStatisticsReportDO.setTotalCompleteNetWeightAll(teamOutputStatisticsReportDOAll.getTotalCompleteNetWeight());
               teamOutputStatisticsReportDO.setTotalUncompleteNetWeightAll(teamOutputStatisticsReportDOAll.getTotalUncompleteNetWeight());
               break;
            }
         }
      }

      return teamOutputStatisticsReportDOList;
   }

   @Override
   public List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReport(
      String startDate,
      String endDate,
      Long workshopId,
      Long productionLineId,
      Long teamId,
      Long processId,
      String processType,
      String teamName,
      String processName
   ) {
      List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReportDOList = new ArrayList<>();
      if (processType != null && processType.equals("1")) {
         teamOutputStatisticsDetailsReportDOList = this.mesBuildingOutputReportMapper
            .teamOutputStatisticsDetailsReportPart(startDate, endDate, workshopId, productionLineId, teamId, processId, processType);
      } else if (processType != null && processType.equals("2")) {
         teamOutputStatisticsDetailsReportDOList = this.mesBuildingOutputReportMapper
            .teamOutputStatisticsDetailsReportArtifact(startDate, endDate, workshopId, productionLineId, teamId, processId, processType);
      } else if (processType != null && processType.equals("16")) {
         teamOutputStatisticsDetailsReportDOList = this.mesBuildingOutputReportMapper
            .teamOutputStatisticsDetailsReportAssemble(startDate, endDate, workshopId, productionLineId, teamId, processId, processType);
      }

      return teamOutputStatisticsDetailsReportDOList;
   }

   @Override
   public List<TeamOutputStatisticsDetailsReport> teamOutputStatisticsDetailsReportDownload(
      String startDate,
      String endDate,
      Long workshopId,
      Long productionLineId,
      Long teamId,
      Long processId,
      String processType,
      String teamName,
      String processName,
      String workshopName,
      HttpServletResponse response
   ) {
      List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReportDOList = new ArrayList<>();
      if (processType != null && processType.equals("1")) {
         teamOutputStatisticsDetailsReportDOList = this.mesBuildingOutputReportMapper
            .teamOutputStatisticsDetailsReportPart(startDate, endDate, workshopId, productionLineId, teamId, processId, processType);
      } else if (processType != null && processType.equals("2")) {
         teamOutputStatisticsDetailsReportDOList = this.mesBuildingOutputReportMapper
            .teamOutputStatisticsDetailsReportArtifact(startDate, endDate, workshopId, productionLineId, teamId, processId, processType);
      } else if (processType != null && processType.equals("16")) {
         teamOutputStatisticsDetailsReportDOList = this.mesBuildingOutputReportMapper
            .teamOutputStatisticsDetailsReportAssemble(startDate, endDate, workshopId, productionLineId, teamId, processId, processType);
      }

      List<TeamOutputStatisticsDetailsReport> teamOutputStatisticsDetailsReportList = new ArrayList<>();
      Integer typeNumber = 1;

      for (TeamOutputStatisticsDetailsReportDO teamOutputStatisticsDetailsReportDO : teamOutputStatisticsDetailsReportDOList) {
         TeamOutputStatisticsDetailsReport teamOutputStatisticsDetailsReport = BeanUtil.copy(
            teamOutputStatisticsDetailsReportDO, TeamOutputStatisticsDetailsReport.class
         );
         Integer var18 = typeNumber;
         typeNumber = typeNumber + 1;
         teamOutputStatisticsDetailsReport.setTypeNumber(var18);
         teamOutputStatisticsDetailsReportList.add(teamOutputStatisticsDetailsReport);
      }

      response.reset();
      response.setContentType("application/vnd.ms-excel;charset=UTF-8");
      String fileName = null;

      try {
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Access-Control-Allow-Origin", "*");
         fileName = "班组排产统计详情.xlsx";
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }

      response.setCharacterEncoding("UTF-8");
      ClassPathResource classPathResource = null;
      if (processType != null && processType.equals("1")) {
         classPathResource = new ClassPathResource("/files/teamOutputStatisticsPartDetail.xlsx");
      } else if (processType != null && processType.equals("2")) {
         classPathResource = new ClassPathResource("/files/teamOutputStatisticsArtifactDetail.xlsx");
      } else if (processType != null && processType.equals("16")) {
         classPathResource = new ClassPathResource("/files/teamOutputStatisticsAssembleDetail.xlsx");
      }

      try (
         InputStream inputStream = classPathResource.getInputStream();
         ServletOutputStream outputStream = response.getOutputStream();
      ) {
         ExcelWriter excelWriter = EasyExcel.write(outputStream, TeamOutputStatisticsDetailsReport.class)
            .withTemplate(inputStream)
            .excelType(ExcelTypeEnum.XLSX)
            .build();
         WriteSheet writeSheet = EasyExcel.writerSheet().build();
         Map<String, Object> dateMap = new HashMap<>();
         dateMap.put("date", DateUtil.format(new Date(), "yyyy-MM"));
         dateMap.put("processType", processName);
         dateMap.put("teamName", teamName);
         dateMap.put("workshopName", workshopName);
         dateMap.put("nowDate", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
         dateMap.put("downloadUser", UserUtil.getCurrentName());
         excelWriter.fill(dateMap, writeSheet);
         excelWriter.fill(teamOutputStatisticsDetailsReportList, writeSheet);
         excelWriter.finish();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return teamOutputStatisticsDetailsReportList;
   }

   @Override
   public List<MonthlyWorkshopOutPutDO> workshopProductionOutputStatisticsMonthlyReport(String yearMonth, Long workshopId, Long projectId, String structureType) {
      List<MonthlyWorkshopOutPutDO> monthlyWorkshopOutPutDOList = this.mesBuildingOutputReportMapper
         .workshopProductionOutputStatisticsMonthlyReport(yearMonth, workshopId, projectId, structureType);
      List<MonthlyWorkshopOutPutDO> monthlyWorkshopOutPutDOListResult = new ArrayList<>();

      for (MonthlyWorkshopOutPutVO monthlyWorkshopOutPutVO : monthlyWorkshopOutPutDOList.stream()
         .collect(Collectors.groupingBy(MonthlyWorkshopOutPutDO::getStructureType))
         .entrySet()
         .stream()
         .map(
            entry -> {
               String structureTypeTemp = entry.getKey();
               List<MonthlyWorkshopOutPutDO> workshopOutPutDOList = entry.getValue();
               BigDecimal totalNetWeightAll = workshopOutPutDOList.stream()
                  .map(MonthlyWorkshopOutPutDO::getTotalNetWeight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               List<MonthlyWorkshopOutPutProjectVO> projectVOList = workshopOutPutDOList.stream()
                  .map(doItem -> new MonthlyWorkshopOutPutProjectVO(doItem.getProjectName(), doItem.getTotalNetWeight()))
                  .collect(Collectors.toList());
               return new MonthlyWorkshopOutPutVO(structureTypeTemp, totalNetWeightAll, projectVOList);
            }
         )
         .collect(Collectors.toList())) {
         for (MonthlyWorkshopOutPutProjectVO monthlyWorkshopOutPutProjectVO : monthlyWorkshopOutPutVO.getMonthlyWorkshopOutPutProjectVOList()) {
            MonthlyWorkshopOutPutDO monthlyWorkshopOutPutDO = new MonthlyWorkshopOutPutDO();
            monthlyWorkshopOutPutDO.setStructureType(monthlyWorkshopOutPutVO.getStructureType());
            monthlyWorkshopOutPutDO.setProjectName(monthlyWorkshopOutPutProjectVO.getProjectName());
            monthlyWorkshopOutPutDO.setTotalNetWeight(monthlyWorkshopOutPutProjectVO.getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
            monthlyWorkshopOutPutDO.setTotalNetWeightAll(monthlyWorkshopOutPutVO.getTotalNetWeightAll().setScale(3, RoundingMode.HALF_UP));
            monthlyWorkshopOutPutDOListResult.add(monthlyWorkshopOutPutDO);
         }
      }

      return monthlyWorkshopOutPutDOListResult;
   }

   @Override
   public void workshopProductionOutputStatisticsMonthlyReportDownload(
      String yearMonth, Long workshopId, String workshopName, Long projectId, String structureType, HttpServletResponse response
   ) {
      List<MonthlyWorkshopOutPutDO> monthlyWorkshopOutPutDOList = this.mesBuildingOutputReportMapper
         .workshopProductionOutputStatisticsMonthlyReport(yearMonth, workshopId, projectId, structureType);
      List<MonthlyWorkshopOutPutDO> monthlyWorkshopOutPutDOListResult = new ArrayList<>();

      for (MonthlyWorkshopOutPutVO monthlyWorkshopOutPutVO : monthlyWorkshopOutPutDOList.stream()
         .collect(Collectors.groupingBy(MonthlyWorkshopOutPutDO::getStructureType))
         .entrySet()
         .stream()
         .map(
            entry -> {
               String structureTypeTemp = entry.getKey();
               List<MonthlyWorkshopOutPutDO> workshopOutPutDOList = entry.getValue();
               BigDecimal totalNetWeightAll = workshopOutPutDOList.stream()
                  .map(MonthlyWorkshopOutPutDO::getTotalNetWeight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               List<MonthlyWorkshopOutPutProjectVO> projectVOList = workshopOutPutDOList.stream()
                  .map(doItem -> new MonthlyWorkshopOutPutProjectVO(doItem.getProjectName(), doItem.getTotalNetWeight()))
                  .collect(Collectors.toList());
               return new MonthlyWorkshopOutPutVO(structureTypeTemp, totalNetWeightAll, projectVOList);
            }
         )
         .collect(Collectors.toList())) {
         for (MonthlyWorkshopOutPutProjectVO monthlyWorkshopOutPutProjectVO : monthlyWorkshopOutPutVO.getMonthlyWorkshopOutPutProjectVOList()) {
            MonthlyWorkshopOutPutDO monthlyWorkshopOutPutDO = new MonthlyWorkshopOutPutDO();
            monthlyWorkshopOutPutDO.setStructureType(monthlyWorkshopOutPutVO.getStructureType());
            monthlyWorkshopOutPutDO.setProjectName(monthlyWorkshopOutPutProjectVO.getProjectName());
            monthlyWorkshopOutPutDO.setTotalNetWeightAll(monthlyWorkshopOutPutVO.getTotalNetWeightAll().setScale(3, RoundingMode.HALF_UP));
            monthlyWorkshopOutPutDO.setTotalNetWeight(monthlyWorkshopOutPutProjectVO.getTotalNetWeight().setScale(3, RoundingMode.HALF_UP));
            monthlyWorkshopOutPutDOListResult.add(monthlyWorkshopOutPutDO);
         }
      }

      List<MonthlyWorkshopOutPutReport> monthlyWorkshopOutPutReportList = new ArrayList<>();
      Map<String, List<MonthlyWorkshopOutPutDO>> monthlyWorkshopOutPutDOMap = monthlyWorkshopOutPutDOListResult.stream()
         .collect(Collectors.groupingBy(MonthlyWorkshopOutPutDO::getStructureType));
      monthlyWorkshopOutPutDOMap.forEach(
         (structureTypeName, monthlyWorkshopOutPutDOListTemp) -> {
            MonthlyWorkshopOutPutReport monthlyWorkshopOutPutReportFirst = new MonthlyWorkshopOutPutReport();
            monthlyWorkshopOutPutReportFirst.setSerialNumber(structureTypeName);
            monthlyWorkshopOutPutReportList.add(monthlyWorkshopOutPutReportFirst);
            Integer index = 0;
            BigDecimal totalNetWeightAll = monthlyWorkshopOutPutDOListTemp.stream()
               .map(MonthlyWorkshopOutPutDO::getTotalNetWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);

            for (MonthlyWorkshopOutPutDO monthlyWorkshopOutPutDOx : monthlyWorkshopOutPutDOListTemp) {
               index = index + 1;
               MonthlyWorkshopOutPutReport monthlyWorkshopOutPutReport = new MonthlyWorkshopOutPutReport();
               monthlyWorkshopOutPutReport.setSerialNumber(index.toString());
               monthlyWorkshopOutPutReport.setProjectName(monthlyWorkshopOutPutDOx.getProjectName());
               monthlyWorkshopOutPutReport.setTotalNetWeight(monthlyWorkshopOutPutDOx.getTotalNetWeight());
               monthlyWorkshopOutPutReportList.add(monthlyWorkshopOutPutReport);
               if (index == monthlyWorkshopOutPutDOListTemp.size()) {
                  MonthlyWorkshopOutPutReport monthlyWorkshopOutPutReportLast = new MonthlyWorkshopOutPutReport();
                  monthlyWorkshopOutPutReportLast.setSerialNumber("");
                  monthlyWorkshopOutPutReportLast.setProjectName("小计");
                  monthlyWorkshopOutPutReportLast.setTotalNetWeight(totalNetWeightAll.setScale(3, RoundingMode.HALF_UP));
                  monthlyWorkshopOutPutReportList.add(monthlyWorkshopOutPutReportLast);
               }
            }
         }
      );
      response.reset();
      response.setContentType("application/vnd.ms-excel;charset=UTF-8");
      String fileName = null;

      try {
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Access-Control-Allow-Origin", "*");
         fileName = "车间制作产量月报.xlsx";
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }

      response.setCharacterEncoding("utf-8");
      ClassPathResource classPathResource = new ClassPathResource("/files/workshopProductionOutput.xlsx");

      try (
         InputStream inputStream = classPathResource.getInputStream();
         ServletOutputStream outputStream = response.getOutputStream();
      ) {
         ExcelWriter excelWriter = EasyExcel.write(outputStream, MonthlyWorkshopOutPutReport.class)
            .withTemplate(inputStream)
            .excelType(ExcelTypeEnum.XLSX)
            .build();
         WriteSheet writeSheet = EasyExcel.writerSheet().build();
         LocalDate date = Instant.ofEpochMilli(Long.valueOf(yearMonth)).atZone(ZoneId.systemDefault()).toLocalDate();
         Map<String, Object> dateMap = new HashMap<>();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月");
         String formattedDate = date.format(formatter);
         dateMap.put("date", formattedDate);
         dateMap.put("year", date);
         dateMap.put("workshopName", workshopName);
         excelWriter.fill(dateMap, writeSheet);
         excelWriter.fill(monthlyWorkshopOutPutReportList, writeSheet);
         excelWriter.finish();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public List<YearlyOutputComparisonVO> yearlyOutputComparisonListConvertToVOList(List<YearlyOutputComparisonDO> doList) {
      Map<String, List<YearlyOutputComparisonDO>> groupedMap = doList.stream().collect(Collectors.groupingBy(YearlyOutputComparisonDO::getStructureType));
      List<YearlyOutputComparisonVO> voList = new ArrayList<>();

      for (Entry<String, List<YearlyOutputComparisonDO>> entry : groupedMap.entrySet()) {
         String structureType = entry.getKey();
         List<YearlyOutputComparisonMonthVO> monthVOList = entry.getValue()
            .stream()
            .map(item -> new YearlyOutputComparisonMonthVO(item.getProductMonth(), item.getTotalNetWeight()))
            .collect(Collectors.toList());
         YearlyOutputComparisonVO vo = new YearlyOutputComparisonVO();
         vo.setStructureType(structureType);
         vo.setYearlyOutputComparisonMonthVOList(monthVOList);
         voList.add(vo);
      }

      return voList;
   }

   private static YearlyOutputComparisonMonthVO mergeData(List<YearlyOutputComparisonMonthVO> data, String startMonth, String endMonth) {
      BigDecimal totalNetWeight = BigDecimal.ZERO;

      for (YearlyOutputComparisonMonthVO vo : data) {
         String month = vo.getProductMonth();
         if (isInRange(month, startMonth, endMonth)) {
            totalNetWeight = totalNetWeight.add(vo.getTotalNetWeight());
         }
      }

      return new YearlyOutputComparisonMonthVO(endMonth, totalNetWeight);
   }

   private static boolean isInRange(String month, String startMonth, String endMonth) {
      return month.compareTo(startMonth) >= 0 && month.compareTo(endMonth) <= 0;
   }

   public void mergeMaps(Map<String, Map<Long, BigDecimal>> map1, Map<String, Map<Long, BigDecimal>> map2) {
      for (Entry<String, Map<Long, BigDecimal>> entry : map2.entrySet()) {
         String key = entry.getKey();
         Map<Long, BigDecimal> subMap = entry.getValue();
         if (map1.containsKey(key)) {
            Map<Long, BigDecimal> targetSubMap = map1.get(key);

            for (Entry<Long, BigDecimal> subEntry : subMap.entrySet()) {
               Long subKey = subEntry.getKey();
               BigDecimal subValue = subEntry.getValue();
               if (targetSubMap.containsKey(subKey)) {
                  targetSubMap.put(subKey, targetSubMap.get(subKey).add(subValue));
               } else {
                  targetSubMap.put(subKey, subValue);
               }
            }
         } else {
            map1.put(key, new HashMap<>(subMap));
         }
      }
   }
}
