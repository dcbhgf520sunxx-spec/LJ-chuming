package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.dto.TwoQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.vo.BimArtifactStatusDetailVO;
import com.hzchum.scim.common.core.api.utils.BigDecimalSageUtils;
import com.hzchum.scim.common.core.api.utils.ListPageUtil;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesBuildingWarehousingStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskPrintEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbonrmalTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.HysteresisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ArtifactSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.EnclosureSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.FormSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.KanBanMachinePartSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProductKanBanDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskArtifactPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskPartPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskTrackingLineMonthDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskTrackingProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppCompleteSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormArtifactAssembleProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormEnclosureDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormProcessDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.HysteresisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionStatements.ProductionStatementsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.FormSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.ProductKanbanDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.ProjectSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskArtifactPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskEnclosurePrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskPartPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.teamForm.TeamFormDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.AvgProductionLineInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.OrderArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.OrderUncompletedInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProductWastageLossCostMesDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ArtifactProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.SummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactKanbanDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductKanBanInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanArtifactTaskWorkShopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanProductProductionStateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TaskConditionByDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamCapacityAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamEachMonthRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductProduceCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanBySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.YearQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingPartReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingSteelFeedingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingOrderProductDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionStatements.ProductionStatementsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProjectSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskMapper;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveDateDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveOutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskServiceImpl extends ServiceImpl<MesBuildingTaskMapper, MesBuildingTask> implements MesBuildingTaskService {
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProduceTeamReportService mesBuildingProduceTeamReportService;
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Autowired
   private MesBuildingWarehouseRecordService recordService;
   @Autowired
   private ConfigService configService;
   @Resource
   ReportService reportService;
   @Resource
   ContractProjectService projectService;
   @Resource
   MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingPrintRecordService printRecordService;

   @Override
   public Integer countByCompleteAndProductProcessId(Long id) {
      return this.baseMapper.countByCompleteAndProductProcessId(id);
   }

   @Override
   public List<KanBanMachinePartSummaryDO> machinePartSteelSpec(ProductKanbanDOParam doParam) {
      return this.baseMapper.machinePartSteelSpec(doParam);
   }

   @Override
   public List<ProductKanBanDO> productKanban(ProductKanbanDOParam doParam) {
      if (doParam.getProductType().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<ProductKanBanDO> dtoList = new ArrayList<>();
         dtoList.addAll(this.baseMapper.productKanban(doParam.setProductType(TaskTypeEnum.ASSEMBLE.getType())));
         return dtoList;
      }

      if (doParam.getProductType().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         List<ProductKanBanDO> dtoList = this.baseMapper.productKanban(doParam);
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
            Map<Long, List<ProductKanBanDO>> listMap = dtoList.stream().collect(Collectors.groupingBy(ProductKanBanDO::getMonomerId));
            listMap.forEach((monomerId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(ProductKanBanDO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
               drillingList.forEach(e -> e.setPictureUrl(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            Map<Long, List<ProductKanBanDO>> listMap = dtoList.stream().collect(Collectors.groupingBy(ProductKanBanDO::getAreaId));
            listMap.forEach((areaId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(ProductKanBanDO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(areaId, serialNumberList);
               drillingList.forEach(e -> e.setPictureUrl(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         return dtoList;
      } else {
         return this.baseMapper.productKanban(doParam);
      }
   }

   @Override
   public List<ProcessSummaryDetailsDTO> getSummaryByIdAndType(Long id, Integer type) {
      return this.baseMapper.getSummaryByIdAndType(id, type).stream().map(e -> BeanUtil.copy(e, ProcessSummaryDetailsDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<ProcessSummaryDetailsDTO> getSummaryByTaskIdAndType(List<Long> taskIds, Integer type) {
      return this.baseMapper
         .getSummaryByTaskIdAndType(taskIds, type)
         .stream()
         .map(e -> BeanUtil.copy(e, ProcessSummaryDetailsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProcessSummaryDetailsDTO> getSummaryBySerialNumberAndType(String serialNumber, Long monomerId, Integer type) {
      return this.baseMapper
         .getSummaryBySerialNumberAndType(serialNumber, monomerId, type)
         .stream()
         .map(e -> BeanUtil.copy(e, ProcessSummaryDetailsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProcessSummaryDetailsDTO> getSummaryByCondition(Long id, Integer type, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper
         .getSummaryByCondition(id, type, startDate, endDate)
         .stream()
         .map(e -> BeanUtil.copy(e, ProcessSummaryDetailsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public ArtifactSummaryDO artifactSummary(ProjectSummaryDTOParam dtoParam) {
      return this.baseMapper.artifactSummaryByPeoject(BeanUtil.copy(dtoParam, ProjectSummaryDOParam.class));
   }

   @Override
   public List<EnclosureSummaryDO> enclosureSummary(ProjectSummaryDTOParam dtoParam) {
      return this.baseMapper.enclosureSummaryByPeoject(BeanUtil.copy(dtoParam, ProjectSummaryDOParam.class));
   }

   @Override
   public SummaryDTO summary(ProductionStatementsDOParam doParam) {
      List<ProductionStatementsDTO> statementsDTOList = this.listByCondition(doParam);
      SummaryDTO summaryDTO = SummaryDTO.builder()
         .quantity(0)
         .totalGrossWeight(BigDecimal.ZERO)
         .totalNetWeight(BigDecimal.ZERO)
         .totalArea(BigDecimal.ZERO)
         .totalLength(BigDecimal.ZERO)
         .build();
      statementsDTOList.forEach(e -> {
         summaryDTO.setQuantity(summaryDTO.getQuantity() + e.getQuantity());
         if (doParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            summaryDTO.setTotalLength(summaryDTO.getTotalLength().add(e.getTotalLength()));
            summaryDTO.setTotalLength(summaryDTO.getTotalArea().add(e.getTotalArea()));
         } else {
            if (doParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               summaryDTO.setTotalGrossWeight(summaryDTO.getTotalNetWeight().add(e.getTotalGrossWeight()));
            }

            summaryDTO.setTotalNetWeight(summaryDTO.getTotalNetWeight().add(e.getTotalNetWeight()));
         }
      });
      return summaryDTO;
   }

   @Override
   public List<ArtifactProductionStatementsDTO> artifactlistByCondition(ProductionStatementsDTOParam dtoParam) {
      return this.baseMapper
         .artifactlistByCondition(BeanUtil.copy(dtoParam, ProductionStatementsDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactProductionStatementsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProductionStatementsDTO> listByCondition(ProductionStatementsDOParam doParam) {
      return this.baseMapper.listByCondition(doParam).stream().map(e -> BeanUtil.copy(e, ProductionStatementsDTO.class)).collect(Collectors.toList());
   }

   @Override
   public PageVO<ProductionStatementsDTO> pageByCondition(ProductionStatementsDOParam doParam, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(doParam));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> print(ProductionStatementsDOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getFactoryId() != null) {
         header.put("factory", this.factoryService.getById(param.getFactoryId()).getName());
      }

      String date = param.getStartDate() != null && param.getEndDate() != null
         ? DateTimeUtil.getLocalDateStr(param.getStartDate()) + "-" + DateTimeUtil.getLocalDateStr(param.getEndDate())
         : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(this.listByCondition(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<HysteresisDO> hysteresisSummaryList(HysteresisDOParam doParam) {
      return this.baseMapper.hysteresisSummaryList(doParam);
   }

   @Override
   public List<HysteresisDO> hysteresisList(HysteresisDOParam doParam) {
      return this.baseMapper.hysteresisList(doParam);
   }

   @Override
   public List<TeamFormDO> teamFormProcessSummary(TeamFormDOParam doParam) {
      return this.baseMapper.teamFormProcessSummary(doParam);
   }

   @Override
   public List<TeamFormProcessDetailsDO> teamFormSummary(
      Long projectId, List<Long> projectIds, List<Long> productionLineIds, List<Integer> productTypes, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.teamFormSummary(projectId, projectIds, productionLineIds, productTypes, startDate, endDate);
   }

   @Override
   public TeamFormProcessDetailsDO teamFormProcessDetail(
      Long projectId, List<Long> projectIds, Long processId, Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.teamFormProcessDetail(projectId, projectIds, processId, productionLineId, productType, startDate, endDate);
   }

   @Override
   public TeamFormProcessDetailsDO teamFormTaskProcessDetail(
      Long projectId, List<Long> projectIds, Long processId, Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.teamFormTaskProcessDetail(projectId, projectIds, processId, productionLineId, productType, startDate, endDate);
   }

   @Override
   public List<TeamFormDetailsDO> teamFormProcessDetails(TeamFormDOParam doParam) {
      return this.baseMapper.teamFormProcessDetails(doParam);
   }

   @Override
   public List<TeamFormArtifactAssembleProcessDO> teamFormProcess(TeamFormDOParam doParam) {
      return this.baseMapper.teamFormProcess(doParam);
   }

   @Override
   public ProcessSummaryDetailsDO processSummary(Long taskId, Long processId, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper.formProcessDetails(taskId, processId, startDate, endDate);
   }

   @Override
   public List<TeamFormEnclosureDO> teamFormEnclosure(TeamFormDOParam doParam) {
      return this.baseMapper.teamFormEnclosure(doParam);
   }

   @Override
   public List<TeamFormEnclosureDetailsDO> teamFormEnclosureDetails(TeamFormDOParam doParam) {
      return this.baseMapper.teamFormEnclosureDetails(doParam);
   }

   @Override
   public ProductMeteDO sumTaskMeteByCondition(Long monomerId, Long factoryId, Integer productType) {
      return this.baseMapper.sumTaskMeteByCondition(monomerId, factoryId, productType);
   }

   @Override
   public PageVO listArtifactPrint(TaskArtifactPrintDOParam param) {
      if (param.getTaskPrintEnum() != null) {
         List<TaskArtifactPrintDO> taskArtifactPrintDOSV2 = this.getTaskArtifactPrintDOSV2(param);
         if (CollectionUtils.isEmpty(taskArtifactPrintDOSV2)) {
            return new PageVO();
         }

         param.setTaskIds(taskArtifactPrintDOSV2.stream().map(TaskArtifactPrintDO::getTaskId).distinct().collect(Collectors.toList()));
      }

      return new PageVO<>(
         PageHelper.startPage(param.getPageNumber(), param.getPageSize(), StringUtils.analyzeSortConditions(param.getSort())),
         this.getTaskArtifactPrintDOS(param)
      );
   }

   @Nullable
   private List<TaskArtifactPrintDO> getTaskArtifactPrintDOS(TaskArtifactPrintDOParam param) {
      List<TaskArtifactPrintDO> taskArtifactPrintDOS = this.baseMapper.listArtifactPrint(param);
      Long areaId = param.getAreaId();
      Long monomerId = param.getMonomerId();
      Long projectId = param.getProjectId();
      if (CollectionUtils.isNotEmpty(taskArtifactPrintDOS)) {
         List<ProductProduceCargoDTO> dtos = taskArtifactPrintDOS.stream()
            .map(
               s -> ProductProduceCargoDTO.builder()
                  .taskId(s.getTaskId())
                  .productId(s.getId())
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .areaId(areaId)
                  .monomerId(monomerId)
                  .projectId(projectId)
                  .build()
            )
            .collect(Collectors.toList());
         List<MesBuildingReportNumberStatusDTO> allNumberStatusDTOS = this.mesBuildingProduceTeamReportService
            .listStatusBydata(dtos, TaskTypeEnum.ARTIFACT.getType(), areaId, monomerId, projectId);
         Map<String, List<MesBuildingReportNumberStatusDTO>> statusMap = allNumberStatusDTOS.stream()
            .collect(Collectors.groupingBy(s -> s.getProductId() + "_" + s.getTaskId()));
         List<String> serialNumberList = taskArtifactPrintDOS.stream().map(ArtifactBaseInfo::getSerialNumber).distinct().collect(Collectors.toList());
         List<Long> monomerIdList = taskArtifactPrintDOS.stream().map(i -> i.getMonomer().getId()).distinct().collect(Collectors.toList());
         Map<String, List<TechDrawing>> drawingListMap = CollUtil.isNotEmpty(serialNumberList) && CollUtil.isNotEmpty(monomerIdList)
            ? this.techDrawingService
               .list(
                  (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                           .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                        .in(TechDrawing::getSerialNumber, serialNumberList))
                     .in(TechDrawing::getMonomerId, monomerIdList)
               )
               .stream()
               .collect(Collectors.groupingBy(i -> i.getMonomerId() + "&" + i.getSerialNumber()))
            : Collections.emptyMap();
         Map<Long, List<MesBuildingPrintRecord>> printRecordTaskMap = this.printRecordService
            .list(
               (Wrapper<MesBuildingPrintRecord>)((new LambdaQueryWrapper<MesBuildingPrintRecord>()
                        .eq(MesBuildingPrintRecord::getType, PrintTypeEnum.TASK.getType()))
                     .isNotNull(MesBuildingPrintRecord::getNumbers))
                  .in(MesBuildingPrintRecord::getRelateId, taskArtifactPrintDOS.stream().map(TaskArtifactPrintDO::getTaskId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingPrintRecord::getRelateId));
         taskArtifactPrintDOS.forEach(
            e -> {
               if (e.getBoolOneCode()) {
                  String key = e.getId() + "_" + e.getTaskId();
                  List<MesBuildingReportNumberStatusDTO> numberStatusDTOS = statusMap.get(key)
                     .stream()
                     .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getNumber(), Function.identity(), (s1, s2) -> s1))
                     .values()
                     .stream()
                     .sorted(Comparator.comparing(MesBuildingReportNumberStatusDTO::getNumber))
                     .collect(Collectors.toList());
                  List<MesBuildingPrintRecord> mesBuildingPrintRecords = printRecordTaskMap.get(e.getTaskId());
                  Set<Integer> allNumbers = new HashSet<>();
                  if (CollectionUtils.isNotEmpty(mesBuildingPrintRecords)) {
                     allNumbers = mesBuildingPrintRecords.stream()
                        .flatMap(record -> Arrays.stream(record.getNumbers().split(",")))
                        .map(String::trim)
                        .filter(str -> !str.isEmpty())
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
                  }

                  for (MesBuildingReportNumberStatusDTO statusDTO : numberStatusDTOS) {
                     if (statusDTO.getStatus() != null) {
                        statusDTO.setName(WarehouseRecordStatusTypeEnum.getNameByType(statusDTO.getStatus()));
                     }

                     statusDTO.setBoolPrint(allNumbers.contains(statusDTO.getNumber().intValue()));
                  }

                  e.setNumberStatusDTOS(numberStatusDTOS);
                  int printQuantity = (int)numberStatusDTOS.stream().filter(MesBuildingReportNumberStatusDTO::getBoolPrint).count();
                  e.setTaskPrintEnum(TaskPrintEnum.NOT_PRINTED.getType());
                  if (printQuantity != 0 && e.getPrintQuantity() < e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.part_printed.getType());
                  }

                  if (printQuantity >= e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.PRINTED.getType());
                  }
               } else {
                  e.setTaskPrintEnum(TaskPrintEnum.NOT_PRINTED.getType());
                  if (e.getPrintQuantity() != null && e.getPrintQuantity() != 0 && e.getPrintQuantity() < e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.part_printed.getType());
                  }

                  if (e.getPrintQuantity() != null && e.getPrintQuantity() >= e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.PRINTED.getType());
                  }
               }

               if (drawingListMap.containsKey(e.getMonomer().getId() + "&" + e.getSerialNumber())) {
                  e.setNumbers(
                     drawingListMap.get(e.getMonomer().getId() + "&" + e.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList())
                  );
                  e.setDrawingAndSerialNumber(
                     drawingListMap.get(e.getMonomer().getId() + "&" + e.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }
            }
         );
         if (param.getTaskPrintEnum() != null) {
            taskArtifactPrintDOS = taskArtifactPrintDOS.stream()
               .filter(e -> e.getTaskPrintEnum().equals(param.getTaskPrintEnum()))
               .collect(Collectors.toList());
         }
      }

      return taskArtifactPrintDOS;
   }

   @Nullable
   private List<TaskArtifactPrintDO> getTaskArtifactPrintDOSV2(TaskArtifactPrintDOParam param) {
      List<TaskArtifactPrintDO> taskArtifactPrintDOS = this.baseMapper.listArtifactPrint(param);
      Long areaId = param.getAreaId();
      Long monomerId = param.getMonomerId();
      Long projectId = param.getProjectId();
      if (CollectionUtils.isNotEmpty(taskArtifactPrintDOS)) {
         List<ProductProduceCargoDTO> dtos = taskArtifactPrintDOS.stream()
            .map(
               s -> ProductProduceCargoDTO.builder()
                  .taskId(s.getTaskId())
                  .productId(s.getId())
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .areaId(areaId)
                  .monomerId(monomerId)
                  .projectId(projectId)
                  .build()
            )
            .collect(Collectors.toList());
         List<MesBuildingReportNumberStatusDTO> allNumberStatusDTOS = this.mesBuildingProduceTeamReportService
            .listStatusBydata(dtos, TaskTypeEnum.ARTIFACT.getType(), areaId, monomerId, projectId);
         Map<String, List<MesBuildingReportNumberStatusDTO>> statusMap = allNumberStatusDTOS.stream()
            .collect(Collectors.groupingBy(s -> s.getProductId() + "_" + s.getTaskId()));
         Map<Long, List<MesBuildingPrintRecord>> printRecordTaskMap = this.printRecordService
            .list(
               (Wrapper<MesBuildingPrintRecord>)((new LambdaQueryWrapper<MesBuildingPrintRecord>()
                        .eq(MesBuildingPrintRecord::getType, PrintTypeEnum.TASK.getType()))
                     .isNotNull(MesBuildingPrintRecord::getNumbers))
                  .in(MesBuildingPrintRecord::getRelateId, taskArtifactPrintDOS.stream().map(TaskArtifactPrintDO::getTaskId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingPrintRecord::getRelateId));
         taskArtifactPrintDOS.forEach(
            e -> {
               if (e.getBoolOneCode()) {
                  String key = e.getId() + "_" + e.getTaskId();
                  List<MesBuildingReportNumberStatusDTO> numberStatusDTOS = statusMap.get(key)
                     .stream()
                     .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getNumber(), Function.identity(), (s1, s2) -> s1))
                     .values()
                     .stream()
                     .sorted(Comparator.comparing(MesBuildingReportNumberStatusDTO::getNumber))
                     .collect(Collectors.toList());
                  List<MesBuildingPrintRecord> mesBuildingPrintRecords = printRecordTaskMap.get(e.getTaskId());
                  Set<Integer> allNumbers = new HashSet<>();
                  if (CollectionUtils.isNotEmpty(mesBuildingPrintRecords)) {
                     allNumbers = mesBuildingPrintRecords.stream()
                        .flatMap(record -> Arrays.stream(record.getNumbers().split(",")))
                        .map(String::trim)
                        .filter(str -> !str.isEmpty())
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
                  }

                  for (MesBuildingReportNumberStatusDTO statusDTO : numberStatusDTOS) {
                     if (statusDTO.getStatus() != null) {
                        statusDTO.setName(WarehouseRecordStatusTypeEnum.getNameByType(statusDTO.getStatus()));
                     }

                     statusDTO.setBoolPrint(allNumbers.contains(statusDTO.getNumber().intValue()));
                  }

                  e.setNumberStatusDTOS(numberStatusDTOS);
                  int printQuantity = (int)numberStatusDTOS.stream().filter(MesBuildingReportNumberStatusDTO::getBoolPrint).count();
                  e.setTaskPrintEnum(TaskPrintEnum.NOT_PRINTED.getType());
                  if (printQuantity != 0 && e.getPrintQuantity() < e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.part_printed.getType());
                  }

                  if (printQuantity >= e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.PRINTED.getType());
                  }
               } else {
                  e.setTaskPrintEnum(TaskPrintEnum.NOT_PRINTED.getType());
                  if (e.getPrintQuantity() != null && e.getPrintQuantity() != 0 && e.getPrintQuantity() < e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.part_printed.getType());
                  }

                  if (e.getPrintQuantity() != null && e.getPrintQuantity() >= e.getTaskQuantity()) {
                     e.setTaskPrintEnum(TaskPrintEnum.PRINTED.getType());
                  }
               }
            }
         );
         if (param.getTaskPrintEnum() != null) {
            taskArtifactPrintDOS = taskArtifactPrintDOS.stream()
               .filter(e -> e.getTaskPrintEnum().equals(param.getTaskPrintEnum()))
               .collect(Collectors.toList());
         }
      }

      return taskArtifactPrintDOS;
   }

   @Override
   public PageVO listPartPrint(TaskPartPrintDOParam param) {
      List<TaskPartPrintDO> all = new ArrayList<>();
      List<TaskPartPrintDO> taskPartPrintDOS = this.baseMapper.partPrintSummary(param);
      List<TaskPartPrintDO> taskAssPrintDOS = this.baseMapper.assPrintSummary(param);
      all.addAll(taskPartPrintDOS);
      all.addAll(taskAssPrintDOS);
      if (!MesBuildingWarehousingStatusEnum.NO_WAREHOUSING.getType().equals(param.getWarehousingStatusEnum())) {
         List<TaskPartPrintDO> unProcessList = this.recordService
            .sumlistSendUnProcess(
               param.getAreaId(),
               param.getAreaBatchId(),
               param.getName(),
               param.getMaterial(),
               param.getProductionLineId(),
               param.getSpecification(),
               param.getSerialNumber()
            );
         all.addAll(unProcessList);
      }

      return ListPageUtil.getPages(param.getPageNumber(), param.getPageSize(), all);
   }

   @Override
   public PageVO listEnclosurePrint(TaskEnclosurePrintDOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      return new PageVO<>(this.baseMapper.listEnclosurePrint(param));
   }

   @Override
   public List<AbonrmalTaskDO> taskQuantityList(Long productId, Integer productType) {
      return this.baseMapper.taskQuantityList(productId, productType);
   }

   @Override
   public Boolean checkStatus(Long productionLine) {
      return this.baseMapper
         .selectList((Wrapper<MesBuildingTask>)Wrappers.<MesBuildingTask>lambdaQuery().eq(MesBuildingTask::getProductionLineId, productionLine))
         .stream()
         .noneMatch(e -> e.getTaskQuantity().equals(e.getCompleteQuantity()));
   }

   @Override
   public List<FormSummaryDO> formSummary(FormSummaryDOParam doParam) {
      return this.baseMapper.formSummary(doParam);
   }

   @Override
   public Integer getTotalInProductQuantity(Long productId, Integer productType) {
      return this.baseMapper.selectTotalInProductQuantity(productId, productType);
   }

   @Override
   public List<BimArtifactStatusDetailVO> getBimArtifactAsStatus(Integer productType, Integer status, Long monomerId, List<Long> areaIds, Integer menuBar) {
      return this.baseMapper.getBimArtifactAsStatus(productType, status, monomerId, areaIds, menuBar);
   }

   @Override
   public List<AppCompleteSumDO> completeSum(Long projectId, Long monomerId, Integer productType) {
      return this.baseMapper.completeSum(projectId, monomerId, productType);
   }

   @Override
   public List<TaskProductDTO> getTaskByProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long workShopId, Long projectId) {
      return this.baseMapper.getTaskByProductionLine(startTime, endTime, taskType, workShopId, projectId);
   }

   @Override
   public List<TaskProductDTO> getAssembleProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer type, Long workShopId, Long projectId) {
      return this.baseMapper.getAssembleProductionLine(startTime, endTime, type, workShopId, projectId);
   }

   @Override
   public List<TaskProcessProductDTO> taskTrackProductionLineDetail(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Integer taskType,
      Long productionLineId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      String serialNumber
   ) {
      return this.baseMapper.taskTrackProductionLineDetail(startTime, endTime, taskType, productionLineId, projectIds, monomerId, areaId, serialNumber);
   }

   @Override
   public List<TaskTrackingLineMonthDO> taskTrackingMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      return this.baseMapper.taskTrackingMonth(dateTime, workShopId, productionLineId);
   }

   @Override
   public List<TaskTrackingProductionLineDO> taskTrackingMonthDetail(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      return this.baseMapper.taskTrackingMonthDetail(dateTime, workShopId, productionLineId);
   }

   @Override
   public List<TaskTrackingProductDTO> taskTrackingMonthProject(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.baseMapper.taskTrackingMonthProject(dateTime, workShopId, productionLineId, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public List<TaskTrackingProductDTO> processSummaryDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      List<Long> assembleIds,
      List<Long> typesettingIds
   ) {
      return this.baseMapper
         .processSummaryDetail(
            projectId,
            monomerId,
            areaId,
            dateTime,
            workshopId,
            productionLineId,
            serialNumber,
            taskType,
            processId,
            startDate,
            endDate,
            status,
            assembleIds,
            typesettingIds
         );
   }

   @Override
   public List<TaskProcessProductDTO> groupTaskDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper.groupTaskDetail(projectId, monomerId, areaId, productId, productionLineId, taskType, processId, startDate, endDate);
   }

   @Override
   public List<TaskProductDTO> taskProductionLineList(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Integer type, Long processId) {
      return this.baseMapper.taskProductionLineList(startTime, endTime, productType, type, processId);
   }

   @Override
   public List<TaskProductDTO> getTaskAssembleProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer type, Long processId) {
      return this.baseMapper.getTaskAssembleProductionLine(startTime, endTime, type, processId);
   }

   @Override
   public List<ProductMonitorKanbanDTO> getProductMonitorKanban(Long workshopId, Integer status, String name, List<Long> projectIds) {
      return this.baseMapper.getProductMonitorKanban(workshopId, status, name, projectIds);
   }

   @Override
   public List<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(Long workshopId, Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getProductMonitorKanbanDetail(workshopId, projectId, monomerId, areaId);
   }

   @Override
   public QuantityAndWeightDetailDO taskMeteByProject(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Long workshopId) {
      return this.baseMapper.taskMeteByProject(projectId, startDate, endDate, workshopId);
   }

   @Override
   public List<QuantityAndWeightDetailDO> listTaskMeteByProject(List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate, Long workshopId) {
      return this.baseMapper.listTaskMeteByProject(projectIds, startDate, endDate, workshopId);
   }

   @Override
   public List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      return this.baseMapper.projectProgressingTaskList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId);
   }

   @Override
   public ProductMonitorKanbanBySummaryDTO getArtifactTaskMete(Long workshopId) {
      return this.baseMapper.getArtifactTaskMete(workshopId);
   }

   @Override
   public List<TaskProductionVO> getTaskProduction(Date date) {
      return this.baseMapper.getTaskProduction(date);
   }

   @Override
   public List<MesBuildingTaskDTO> listTasks(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer productType) {
      return this.baseMapper.listTasks(projectId, monomerId, areaId, areaBatchId, productType);
   }

   @Override
   public List<ArtifactSchedulingDO> artifactSchedulingProjectList(LocalDateTime dateTime, Long workshopId, List<Long> projectIds) {
      return this.baseMapper.artifactSchedulingProjectList(dateTime, workshopId, projectIds);
   }

   @Override
   public List<YearQuantityAndMeteDTO> artifactSchedulingMeteList(LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId) {
      return this.baseMapper.artifactSchedulingMeteList(dateTime, workshopId, projectId, monomerId);
   }

   @Override
   public List<ArtifactSchedulingDetailDTO> artifactSchedulingDetail(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.baseMapper.artifactSchedulingDetail(dateTime, workshopId, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public YearQuantityAndMeteDTO artifactSchedulingMeteByMonth(String startDate, String endDate, Long workshopId, Long projectId, Long monomerId) {
      return this.baseMapper.artifactSchedulingMeteByMonth(startDate, endDate, workshopId, projectId, monomerId);
   }

   @Override
   public List<TaskTrackingProductDTO> taskSummaryDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer taskType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      List<Long> singleArtifactIds
   ) {
      return this.baseMapper
         .taskSummaryDetail(projectId, monomerId, areaId, workshopId, productionLineId, serialNumber, taskType, startDate, endDate, status, singleArtifactIds);
   }

   @Override
   public List<SendPurlinDTO> listAssKitByTaskIds(Long taskId) {
      return this.baseMapper.listAssKitByTaskIds(taskId);
   }

   @Override
   public List<SendPurlinDTO> listPartKitByTaskIds(Long taskId) {
      return this.baseMapper.listPartKitByTaskIds(taskId);
   }

   @Override
   public List<MesBuildingOrderProductDetailDTO> listOrderProduceDetail(List<Long> orderIds) {
      return this.baseMapper.listOrderProduceDetail(orderIds);
   }

   @Override
   public List<MesBuildingTask> listTasksByData(Long taskOrderId, Long areaId, String serialNumber, String specification, Integer taskType) {
      return this.baseMapper.listTasksByData(taskOrderId, areaId, serialNumber, specification, taskType);
   }

   @Override
   public List<TaskConditionByDateDTO> getEachWorkShopTaskCondition(LocalDateTime date) {
      return this.baseMapper.getEachWorkShopTaskCondition(date);
   }

   @Override
   public List<TeamEachMonthRateDTO> getEachTeamTaskCondition(List<Long> teamIds, LocalDateTime time) {
      return this.baseMapper.getEachTeamTaskCondition(teamIds, time);
   }

   @Override
   public List<WorkShopTaskCompleteDetailDTO> findWorkshopTaskPercentageDetail(LocalDateTime date, Long workShopId) {
      return this.baseMapper.findWorkshopTaskPercentageDetail(date, workShopId);
   }

   @Override
   public List<TeamTaskCompleteDetailDTO> getEachTeamTaskDetail(LocalDateTime date, Long teamId) {
      return this.baseMapper.getEachTeamTaskDetail(date, teamId);
   }

   @Override
   public List<ArtifactKanbanDetailDTO> getArtifactKanbanInfo(Long productId) {
      return this.baseMapper.getArtifactKanbanInfo(productId);
   }

   @Override
   public List<ProductKanBanInfoDTO> findArtifactAssembleLinkInfo(List<Long> productId) {
      return this.baseMapper.findArtifactAssembleLinkInfo(productId);
   }

   @Override
   public List<TeamCapacityAnalysisDTO> findTeamCapacityAnalysis(List<Long> teamIds, LocalDateTime time, List<Long> projectIds) {
      return this.baseMapper.findTeamCapacityAnalysis(teamIds, time, projectIds);
   }

   @Override
   public List<ProjectProductionKanBanListDTO> findKanBanArtifactTaskList(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Integer productKanBanEnum,
      List<LocalDateTime> dateTimeList,
      List<Long> areaBatchIds,
      List<Long> artifactIds
   ) {
      return this.baseMapper
         .findKanBanArtifactTaskList(
            projectId, workShopId, productionLineId, monomerId, areaIds, classId, serialNumber, productKanBanEnum, dateTimeList, areaBatchIds, artifactIds
         );
   }

   @Override
   public List<ProjectKanBanIdAndQuantityDTO> findArtifactTaskAndPartTask(List<Long> artifactTaskIds) {
      return this.baseMapper.findArtifactTaskAndPartTask(artifactTaskIds);
   }

   @Override
   public List<ProjectKanArtifactTaskWorkShopDTO> findArtifactTaskAssistWorkShop(List<Long> artifactTaskIds) {
      return this.baseMapper.findArtifactTaskAssistWorkShop(artifactTaskIds);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getTaskWastageLossCostSummary(
      Long projectId, Long workShopId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.baseMapper.getTaskWastageLossCostSummary(projectId, workShopId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getTaskCompleteWastageLossCostSummary(
      Long projectId, Long workShopId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.baseMapper.getTaskCompleteWastageLossCostSummary(projectId, workShopId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getTaskPendingProductsWastageLossCostSummary(
      Long projectId, Long workShopId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.baseMapper.getTaskPendingProductsWastageLossCostSummary(projectId, workShopId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> getTaskProductSchedulingDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   ) {
      return this.baseMapper
         .getTaskProductSchedulingDetailList(
            dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
         );
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> getTaskPendingProductsWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   ) {
      return this.baseMapper
         .getTaskPendingProductsWastageLossCostDetailList(
            dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
         );
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> getTaskProcessProductsWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   ) {
      return this.baseMapper
         .getTaskProcessProductsWastageLossCostDetailList(
            dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
         );
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> getTaskCompleteWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   ) {
      return this.baseMapper
         .getTaskCompleteWastageLossCostDetailList(
            dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
         );
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> getTaskProcessCompleteWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   ) {
      return this.baseMapper
         .getTaskProcessCompleteWastageLossCostDetailList(
            dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
         );
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> getPartsAllocationDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      List<Integer> relationTypeList
   ) {
      return this.baseMapper
         .getPartsAllocationDetailList(
            dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType, relationTypeList
         );
   }

   @Override
   public List<WastageCostSummaryValueDTO> getPartsAllocationWastageLossCostSummary(
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      String minYearMonth,
      String maxYearMonth,
      List<LocalDate> yearMonthDateList,
      List<Integer> relationTypeList
   ) {
      return this.baseMapper
         .getPartsAllocationWastageLossCostSummary(projectId, workShopId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList, relationTypeList);
   }

   @Override
   public List<ProjectKanBanProductProductionStateDTO> findSignageProductProductionStateList(
      Long projectId,
      Integer productType,
      Long monomerId,
      List<Long> areaIds,
      Long workShopId,
      Long productionLineId,
      Long classId,
      String serialNumber,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds
   ) {
      return this.baseMapper
         .findSignageProductProductionStateList(
            projectId, productType, monomerId, areaIds, workShopId, productionLineId, classId, serialNumber, productKanBanCompanyEnum, areaBatchIds
         );
   }

   @Override
   public List<ProjectKanBanProductProductionStateDTO> findArtifactSchedulingList(
      Long projectId, Long monomerId, List<Long> areaIds, Long classId, String serialNumber, List<Long> areaBatchIds
   ) {
      return this.baseMapper.findArtifactSchedulingList(projectId, monomerId, areaIds, classId, serialNumber, areaBatchIds);
   }

   @Override
   public Integer findTotalAmountByDate(LocalDate date, Long workShopId, String format) {
      return this.baseMapper.findTotalAmountByDate(date, workShopId, format);
   }

   @Override
   public Integer findTotalQuantityByDate(LocalDate date, Long workShopId, String format) {
      return this.baseMapper.findTotalQuantityByDate(date, workShopId, format);
   }

   @Override
   public TwoQuantityDTO achievementRate(Long workShopId) {
      return this.baseMapper.achievementRate(workShopId);
   }

   @Override
   public PageVO<LossStatisticsDTO> getLossStatisticsList(
      Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String date, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<LossStatisticsDTO> lossStatisticsList = this.baseMapper.getLossStatisticsList(workShopId, branchCompanyId, projectStatus, projectName, date);
      PageVO<LossStatisticsDTO> pageVO = new PageVO<>(lossStatisticsList);
      if (CollectionUtils.isEmpty(lossStatisticsList)) {
         return new PageVO<>();
      }

      QueryReceiveDateDTOParam param = new QueryReceiveDateDTOParam();
      if (workShopId != null) {
         param.setWorkShopIds(Collections.singletonList(workShopId));
      }

      if (date != null) {
         param.setYear(Integer.valueOf(date));
      }

      ReceiveDateDTO receiveDateDTO = this.reportService.getReceiveDate(param);
      Map<Long, List<ReceiveOutboundDetailDTO>> plantOutboundDetailMap = receiveDateDTO.getPlantOutboundDetailList()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId()));
      Map<Long, List<ReceiveOutboundDetailDTO>> sectionOutboundDetailMap = receiveDateDTO.getSectionOutboundDetailList()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId()));
      Map<Long, List<ReceiveReturnDetailDTO>> plantReturnDetailMap = receiveDateDTO.getPlantReturnDetailList()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId()));
      Map<Long, List<ReceiveReturnDetailDTO>> sectionReturnDetailMap = receiveDateDTO.getSectionReturnDetailList()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId()));
      lossStatisticsList.forEach(
         e -> {
            List<ReceiveOutboundDetailDTO> plantOutboundDetailDTOList = plantOutboundDetailMap.get(e.getProject().getId());
            List<ReceiveOutboundDetailDTO> sectionOutboundDetailDTOList = sectionOutboundDetailMap.get(e.getProject().getId());
            List<ReceiveReturnDetailDTO> plantReturnDetailDTOList = plantReturnDetailMap.get(e.getProject().getId());
            List<ReceiveReturnDetailDTO> sectionReturnDetailDTOList = sectionReturnDetailMap.get(e.getProject().getId());
            boolean hasPlantOutbound = CollectionUtils.isNotEmpty(plantOutboundDetailDTOList);
            boolean hasPlantReturn = CollectionUtils.isNotEmpty(plantReturnDetailDTOList);
            if (!hasPlantOutbound) {
               e.setSteelPickingWeight(BigDecimal.ZERO);
            } else if (hasPlantOutbound && !hasPlantReturn) {
               BigDecimal totalMete = getReduce(plantOutboundDetailDTOList);
               e.setSteelPickingWeight(BigDecimalSageUtils.divideSafe(totalMete, BigDecimalSageUtils.G_TO_KG_CONVERSION, 2, RoundingMode.HALF_UP));
            } else if (hasPlantOutbound && hasPlantReturn) {
               BigDecimal totalMete = getReduce(plantOutboundDetailDTOList);
               BigDecimal totalReturnMete = plantReturnDetailDTOList.stream().map(ReceiveReturnDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               e.setSteelPickingWeight(
                  BigDecimalSageUtils.divideSafe(totalMete.subtract(totalReturnMete), BigDecimalSageUtils.G_TO_KG_CONVERSION, 2, RoundingMode.HALF_UP)
               );
            }

            e.setSteelLossWeight(e.getSteelFeedingWeight().add(e.getSteelPickingWeight()).subtract(e.getSteelReportWeight()));
            boolean hasSectionOutbound = CollectionUtils.isNotEmpty(sectionOutboundDetailDTOList);
            boolean hasSectionReturn = CollectionUtils.isNotEmpty(sectionReturnDetailDTOList);
            if (!hasSectionOutbound) {
               e.setProfilesPickingWeight(BigDecimal.ZERO);
            } else if (hasSectionOutbound && !hasSectionReturn) {
               BigDecimal totalMete = getReduce(sectionOutboundDetailDTOList);
               e.setProfilesPickingWeight(BigDecimalSageUtils.divideSafe(totalMete, BigDecimalSageUtils.G_TO_KG_CONVERSION, 2, RoundingMode.HALF_UP));
            } else if (hasSectionOutbound && hasSectionReturn) {
               BigDecimal totalMete = getReduce(sectionOutboundDetailDTOList);
               BigDecimal totalReturnMete = sectionReturnDetailDTOList.stream().map(ReceiveReturnDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               e.setProfilesPickingWeight(
                  BigDecimalSageUtils.divideSafe(totalMete.subtract(totalReturnMete), BigDecimalSageUtils.G_TO_KG_CONVERSION, 2, RoundingMode.HALF_UP)
               );
            }

            e.setProfilesFeedingWeight(BigDecimal.ZERO);
            e.setProfilesLossWeight(e.getProfilesPickingWeight().subtract(e.getProfilesReportWeight()));
            e.setTotalLossWeight(e.getProfilesLossWeight().add(e.getSteelLossWeight()));
            BigDecimal denominator = e.getSteelFeedingWeight()
               .add(e.getProfilesFeedingWeight())
               .add(e.getProfilesPickingWeight())
               .add(e.getSteelPickingWeight());
            if (denominator.compareTo(BigDecimal.ZERO) == 0) {
               e.setLossRate(BigDecimal.ZERO);
            } else {
               e.setLossRate(BigDecimalSageUtils.divideSafe(e.getTotalLossWeight(), denominator, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)));
            }
         }
      );
      return pageVO;
   }

   @Override
   public PrintVO<List<LossStatisticsDTO>> getLossStatisticsListPrint(
      Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String date
   ) {
      PrintVO printVO = new PrintVO();
      List<LossStatisticsDTO> dtos = this.getLossStatisticsList(workShopId, branchCompanyId, projectStatus, projectName, date, 1, Integer.MAX_VALUE)
         .getContent();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (workShopId != null) {
         header.put("workshopName", this.workshopService.getById(workShopId).getName());
      }

      header.put("year", date);
      printVO.setHeader(header);
      printVO.setTable(dtos);
      return printVO;
   }

   @Override
   public List<LossStatisticsDetailDTO> getLossStatisticsTaskDetail(Long projectId, Long workShopId, Integer projectStatus, String projectName, String date) {
      return this.baseMapper.getLossStatisticsTaskDetail(projectId, workShopId, projectStatus, projectName, date);
   }

   @NotNull
   private static BigDecimal getReduce(List<ReceiveOutboundDetailDTO> sectionOutboundDetailDTOList) {
      return sectionOutboundDetailDTOList.stream().map(ReceiveOutboundDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public LossStatisticsSummaryDTO getLossStatisticsSummary(Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String date) {
      List<LossStatisticsDTO> lossStatisticsList = this.getLossStatisticsList(
            workShopId, branchCompanyId, projectStatus, projectName, date, 1, Integer.MAX_VALUE
         )
         .getContent();
      BigDecimal pickWeight = lossStatisticsList.stream()
         .map(e -> e.getSteelPickingWeight().add(e.getProfilesPickingWeight()))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal feedWeight = lossStatisticsList.stream()
         .map(e -> e.getSteelFeedingWeight().add(e.getProfilesFeedingWeight()))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal reportWeight = lossStatisticsList.stream()
         .map(e -> e.getSteelReportWeight().add(e.getProfilesReportWeight()))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal avgLossRate = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(lossStatisticsList)) {
         avgLossRate = lossStatisticsList.stream()
            .map(e -> e.getLossRate())
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(lossStatisticsList.size()), 2, RoundingMode.HALF_UP);
      }

      return LossStatisticsSummaryDTO.builder()
         .totalFeedingWeight(feedWeight.divide(BigDecimalSageUtils.KG_TO_TON_CONVERSION, 2, RoundingMode.HALF_UP))
         .totalPickingWeight(pickWeight.divide(BigDecimalSageUtils.KG_TO_TON_CONVERSION, 2, RoundingMode.HALF_UP))
         .totalReportWeight(reportWeight.divide(BigDecimalSageUtils.KG_TO_TON_CONVERSION, 2, RoundingMode.HALF_UP))
         .avgLossRate(avgLossRate)
         .build();
   }

   @Override
   public List<MesBuildingSteelFeedingDTO> getSteelFeedingDetail(Long projectId, Long workShopId, Integer basicClass, String date) {
      return this.baseMapper.getSteelFeedingDetail(projectId, workShopId, date);
   }

   @Override
   public PrintVO<List<MesBuildingSteelFeedingDTO>> getSteelFeedingDetailPrint(Long projectId, Long workShopId, Integer basicClass, String date) {
      PrintVO printVO = new PrintVO();
      List<MesBuildingSteelFeedingDTO> dtos = this.getSteelFeedingDetail(projectId, workShopId, basicClass, date);
      ContractProject project = this.projectService.getById(projectId);
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getShortName());
      if (workShopId != null) {
         header.put("workshopName", this.workshopService.getById(workShopId).getName());
      }

      header.put("year", date);
      printVO.setHeader(header);
      printVO.setTable(dtos);
      return printVO;
   }

   @Override
   public List<MesBuildingPartReportDetailDTO> getPartReportDetail(Long projectId, Long workShopId, Integer partType, String date) {
      return this.baseMapper.getPartReportDetail(projectId, workShopId, partType, date);
   }

   @Override
   public PrintVO<List<MesBuildingPartReportDetailDTO>> getPartReportDetailPrint(Long projectId, Long workShopId, Integer partType, String date) {
      PrintVO printVO = new PrintVO();
      List<MesBuildingPartReportDetailDTO> dtos = this.baseMapper.getPartReportDetail(projectId, workShopId, partType, date);
      ContractProject project = this.projectService.getById(projectId);
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getShortName());
      if (workShopId != null) {
         header.put("workshopName", this.workshopService.getById(workShopId).getName());
      }

      header.put("year", date);
      printVO.setHeader(header);
      printVO.setTable(dtos);
      return printVO;
   }

   @Override
   public PrintVO<List<LossStatisticsDetailDTO>> getLossStatisticsTaskDetailPrint(
      Long projectId, Long workShopId, Integer projectStatus, String projectName, String year
   ) {
      PrintVO printVO = new PrintVO();
      List<LossStatisticsDetailDTO> dtos = this.getLossStatisticsTaskDetail(projectId, workShopId, projectStatus, projectName, year);
      ContractProject project = this.projectService.getById(projectId);
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getShortName());
      if (workShopId != null) {
         header.put("workshopName", this.workshopService.getById(workShopId).getName());
      }

      header.put("year", year);
      printVO.setHeader(header);
      printVO.setTable(dtos);
      return printVO;
   }

   @Override
   public List<AvgProductionLineInfoDTO> getAvgProductionLineInfo(LineSchedulingInfoDTOParam param) {
      return this.baseMapper.getAvgProductionLineInfo(param);
   }

   @Override
   public List<OrderUncompletedInfoDTO> getOrderUncompletedInfo(LineSchedulingInfoDTOParam param) {
      return this.baseMapper.getOrderUncompletedInfo(param);
   }

   @Override
   public List<OrderArtifactDetailDTO> getOrderUncompletedDetailInfo(Long orderId, Long teamId) {
      return this.baseMapper.getOrderUncompletedDetailInfo(orderId, teamId);
   }

   @Override
   public List<OrderArtifactDetailDTO> getCurrentProjectScheduling(Long projectId, String serialNumber, Long teamId) {
      return this.baseMapper.getCurrentProjectScheduling(projectId, serialNumber, teamId);
   }

   @Override
   public List<SchedulingArtifactSummaryDTO> findSchedulingArtifactSummary(Long projectId, Long monomerId) {
      return this.baseMapper.findSchedulingArtifactSummary(projectId, monomerId);
   }

   @Override
   public List<SchedulingArtifactDetailDTO> findSchedulingArtifactDetail(MesBuildingArtifactSchedulingParam param) {
      return this.baseMapper.findSchedulingArtifactDetail(param);
   }
}
