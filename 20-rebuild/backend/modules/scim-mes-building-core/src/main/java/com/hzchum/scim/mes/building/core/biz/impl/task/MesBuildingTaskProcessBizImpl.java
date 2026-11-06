package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.enums.AssistEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingFactoryBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTopTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProductMonitorKanbanByGroupDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorByGroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleExtTaskCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProduceStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProduceStatisticsProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProductProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProductProcessQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProgressProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProjectProcessingOutBoundDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskArtifactProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessDullDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductFromArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingNumberReplaceDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskProcessMapper;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechArtifactChangeService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailBasicDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskProcessBizImpl
   extends IBizImpl<MesBuildingTaskProcessService, MesBuildingTaskProcessMapper, MesBuildingTaskProcess>
   implements MesBuildingTaskProcessBiz {
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingTopTaskOrderBiz topTaskOrderBiz;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private TechArtifactService techArtifactService;
   @Autowired
   private TechAssembleService techAssembleService;
   @Autowired
   private TechAssembleDetailService techAssembleDetailService;
   @Autowired
   private TechArtifactMachinePartLinkService techArtifactMachinePartLinkService;
   @Resource
   private ContractProjectService contractProjectService;
   @Autowired
   private MesBuildingProcessBiz processBiz;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private MesBuildingFactoryBiz factoryBiz;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private SysAssembleConfigService sysAssembleConfigService;
   @Resource
   private OutboundService outboundService;
   @Resource
   private ReturnService returnService;
   @Resource
   private MesBuildingTaskBiz taskBiz;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingService taskNeedMachinePartSchedulingService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingAssistService mesBuildingAssistService;
   @Autowired
   private TechArtifactChangeService techArtifactChangeService;
   @Autowired
   private MesBuildingTaskNumberLinkService numberLinkService;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Resource
   private ConfigService configService;

   @Override
   public List<MesBuildingProcessDTO> getProcessList(Integer taskType, Long orderId) {
      return this.baseService.getProcessList(taskType, orderId).stream().map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProductionTaskDTO> getProductTaskList(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   ) {
      List<MesBuildingProductionTaskDTO> dtoList = new ArrayList<>();
      if (productType.equals(TaskTypeEnum.ARTIFACT.getType()) && productionLineTypeEnum.equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType())) {
         dtoList = this.baseService
            .getArtifactTaskProcessList(projectId, processId, orderId, startDate, endDate, serialNumber, specification, boolAccurateQuery)
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingProductionTaskDTO.class))
            .collect(Collectors.toList());
         MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(orderId);
         return this.computeBoolCanRevokeOnecode(dtoList, taskOrder, Boolean.FALSE);
      } else {
         return productType.equals(TaskTypeEnum.ASSEMBLE.getType())
            ? this.baseService
               .getAssembleTaskProcessList(projectId, processId, orderId, startDate, endDate, serialNumber, specification, boolAccurateQuery)
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingProductionTaskDTO.class))
               .collect(Collectors.toList())
            : dtoList;
      }
   }

   private List<MesBuildingProductionTaskDTO> computeBoolCanRevoke(List<MesBuildingProductionTaskDTO> dtoList, MesBuildingTaskOrder artifactTaskOrder) {
      if (dtoList.size() == 0) {
         return dtoList;
      }

      dtoList.forEach(e -> e.setBoolCanRevoke(Boolean.TRUE));
      ContractProject project = this.projectService.getById(artifactTaskOrder.getProjectId());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(dtoList.stream().map(MesBuildingProductionTaskDTO::getProductId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      dtoList.forEach(e -> {
         if (e.getInProductionQuantity() > 0) {
            e.setBoolCanRevoke(Boolean.FALSE);
         } else {
            e.setBoolCanRevoke(Boolean.TRUE);
         }
      });
      if (project.getMode().equals(ProjectModeEnum.STANDARD_MODE.getType())) {
         Map<Long, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingMap = this.taskNeedMachinePartSchedulingService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class)
                  .in(
                     MesBuildingTaskNeedMachinePartScheduling::getTaskId,
                     dtoList.stream().map(MesBuildingProductionTaskDTO::getTaskId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNeedMachinePartScheduling::getTaskId));
         List<Long> artifactTaskIds = dtoList.stream().map(MesBuildingProductionTaskDTO::getTaskId).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> numerLinks = this.numberLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class).in(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskIds));
         numerLinks.forEach(s -> s.setBoolAssembleInproduce(s.getAssembleId() == null ? Boolean.FALSE : s.getBoolAssembleInproduce()));
         Map<Long, Boolean> artifactNumberLinkMap = numerLinks.stream()
            .collect(Collectors.toMap(MesBuildingTaskNumberLink::getArtifactTaskId, MesBuildingTaskNumberLink::getBoolAssembleInproduce, (s1, s2) -> s1 || s2));
         dtoList.stream().forEach(e -> {
            if (taskNeedMachinePartSchedulingMap.get(e.getTaskId()) != null) {
               taskNeedMachinePartSchedulingMap.get(e.getTaskId()).forEach(machinePartTask -> {
                  if (machinePartTask.getSchedulingQuantity() > 0 && e.getBoolCanRevoke()) {
                     e.setBoolCanRevoke(Boolean.FALSE);
                  }
               });
            }

            Boolean aBoolean = artifactNumberLinkMap.get(e.getTaskId());
            e.setBoolCanRevoke(e.getBoolCanRevoke() && !aBoolean);
         });
      }

      this.checkBoolRevoke(dtoList, artifactTaskOrder);
      return dtoList;
   }

   @Override
   public void checkBoolRevoke(List<MesBuildingProductionTaskDTO> tasks, MesBuildingTaskOrder artifactTaskOrder) {
      List<Long> artifactIds = tasks.stream().map(MesBuildingProductionTaskDTO::getProductId).collect(Collectors.toList());
      Long workshopId = this.groupsBiz.getById(artifactTaskOrder.getGroupsId()).getWorkshopId();
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         Map<Long, Integer> assHouseMap = new HashMap<>();
         Map<Long, Integer> parHouseMap = new HashMap<>();
         Map<Long, List<Long>> assChangMap = new HashMap<>();
         Map<Long, List<Long>> partChangMap = new HashMap<>();
         List<Long> senPartIds = new ArrayList<>();
         List<Long> senAssIds = new ArrayList<>();
         List<TechAssembleDetail> assDetails = this.techAssembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
         Map<Long, List<TechAssembleDetail>> assMap = assDetails.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         if (CollectionUtils.isNotEmpty(assDetails)) {
            List<TechAssemble> allAss = this.assembleService.listByIds(assDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
            List<TechAssemble> sendAss = allAss.stream()
               .filter(s -> !s.getBoolProcess())
               .filter(TechAssemble::getBoolSendDirectly)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(sendAss)) {
               senAssIds = sendAss.stream().map(TechAssemble::getId).collect(Collectors.toList());
               List<TechAssembleDetail> sendlinks = this.techAssembleDetailService
                  .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, senAssIds));
               assChangMap = sendlinks.stream()
                  .collect(Collectors.groupingBy(TechAssembleDetail::getAssembleId, Collectors.mapping(TechAssembleDetail::getArtifactId, Collectors.toList())));
               List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                        .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.ASSEMBLE.getType())
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                        .eq(MesBuildingWarehouseSummary::getWorkshopId, workshopId)
                        .in(MesBuildingWarehouseSummary::getProductId, senAssIds)
                  );
               assHouseMap = summaryList.stream()
                  .collect(
                     Collectors.toMap(
                        MesBuildingWarehouseSummary::getProductId,
                        s -> s.getQuantity().intValue() - s.getCargoQuantity().intValue() - s.getPackageQuantity().intValue()
                     )
                  );
            }
         }

         List<TechArtifactMachinePartLink> partLinks = this.techArtifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
         Map<Long, List<TechArtifactMachinePartLink>> partMap = partLinks.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         if (CollectionUtils.isNotEmpty(partLinks)) {
            List<TechMachinePart> machineParts = this.machinePartService
               .listByIds(partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
            List<TechMachinePart> senParts = machineParts.stream()
               .filter(s -> !s.getBoolProcess())
               .filter(s -> s.getRelationType().equals(2))
               .filter(TechMachinePart::getBoolSendDirectly)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(senParts)) {
               senPartIds = senParts.stream().map(TechMachinePart::getId).collect(Collectors.toList());
               List<TechArtifactMachinePartLink> sendlinks = this.techArtifactMachinePartLinkService
                  .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, senPartIds));
               partChangMap = sendlinks.stream()
                  .collect(
                     Collectors.groupingBy(
                        TechArtifactMachinePartLink::getMachinePartId, Collectors.mapping(TechArtifactMachinePartLink::getArtifactId, Collectors.toList())
                     )
                  );
               List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                        .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                        .eq(MesBuildingWarehouseSummary::getWorkshopId, workshopId)
                        .in(MesBuildingWarehouseSummary::getProductId, senPartIds)
                  );
               parHouseMap = summaryList.stream()
                  .collect(
                     Collectors.toMap(
                        MesBuildingWarehouseSummary::getProductId,
                        s -> s.getQuantity().intValue() - s.getCargoQuantity().intValue() - s.getPackageQuantity().intValue()
                     )
                  );
            }
         }

         List<Long> changeArtifactIds = this.techArtifactChangeService
            .list(Wrappers.lambdaQuery(TechArtifactChange.class).eq(TechArtifactChange::getHandleStatusEnum, 1))
            .stream()
            .map(TechArtifactChange::getArtifactId)
            .collect(Collectors.toList());

         for (MesBuildingProductionTaskDTO taskDTO : tasks) {
            Long productId = taskDTO.getProductId();
            List<TechAssembleDetail> assembleDetailList = assMap.get(productId);
            if (CollectionUtils.isNotEmpty(assembleDetailList)) {
               for (TechAssembleDetail detail : assembleDetailList) {
                  if (senAssIds.contains(detail.getAssembleId())) {
                     List<Long> artIds = assChangMap.get(detail.getAssembleId());
                     if (CollectionUtils.isNotEmpty(artIds)) {
                        artIds.retainAll(changeArtifactIds);
                        if (CollectionUtils.isNotEmpty(artIds)) {
                           taskDTO.setBoolCanRevoke(false);
                        }
                     }

                     Integer quantity = assHouseMap.get(detail.getAssembleId());
                     if (quantity / detail.getQuantity() < taskDTO.getQuantity()) {
                        taskDTO.setBoolCanRevoke(false);
                     }
                  }
               }
            }

            List<TechArtifactMachinePartLink> machinePartLinks = partMap.get(productId);
            if (CollectionUtils.isNotEmpty(machinePartLinks)) {
               for (TechArtifactMachinePartLink machinePartLink : machinePartLinks) {
                  if (senPartIds.contains(machinePartLink.getMachinePartId())) {
                     List<Long> artIds = partChangMap.get(machinePartLink.getMachinePartId());
                     if (CollectionUtils.isNotEmpty(artIds)) {
                        artIds.retainAll(changeArtifactIds);
                        if (CollectionUtils.isNotEmpty(artIds)) {
                           taskDTO.setBoolCanRevoke(false);
                        }
                     }

                     Integer quantity = parHouseMap.get(machinePartLink.getMachinePartId());
                     if (quantity / machinePartLink.getQuantity() < taskDTO.getQuantity()) {
                        taskDTO.setBoolCanRevoke(false);
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public PageVO<MesBuildingProductionTaskDTO> getProductTaskListPage(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.getProductTaskList(
            projectId, processId, orderId, productType, type, productionLineTypeEnum, startDate, endDate, serialNumber, specification, boolAccurateQuery
         )
      );
   }

   @Override
   public Boolean getTaskOrderRevoke(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   ) {
      new ArrayList();
      if (productType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         if (productionLineTypeEnum.equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType())) {
            List<MesBuildingProductionTaskDTO> dtoList = this.baseService
               .getArtifactTaskProcessList(projectId, processId, orderId, startDate, endDate, serialNumber, specification, boolAccurateQuery)
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingProductionTaskDTO.class))
               .collect(Collectors.toList());
            MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(orderId);
            dtoList = this.computeBoolCanRevokeOnecode(dtoList, taskOrder, Boolean.FALSE);
            return dtoList.stream().allMatch(MesBuildingProductionTaskDTO::getBoolCanRevoke);
         } else {
            return Boolean.FALSE;
         }
      } else {
         return Boolean.FALSE;
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProductTaskListPrint(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      MesBuildingTaskOrder orderBizById = this.taskOrderBiz.getById(orderId);
      MesBuildingProductionLine productionLine = this.productionLineService.getById(orderBizById.getProductionLineId());
      String workName = this.workshopService.getById(productionLine.getWorkshopId()).getName();
      header.put("name", workName + ">" + productionLine.getName());
      header.put("taskOrder", orderBizById.getOrderNumber());
      MesBuildingTaskOrder ArtifactOrder = this.taskOrderBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
               .eq(MesBuildingTaskOrder::getTopTaskOrderId, orderBizById.getTopTaskOrderId())
               .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      MesBuildingProductionLine mesBuildingProductionLine = this.productionLineService.getById(ArtifactOrder.getProductionLineId());
      String artworkName = this.workshopService.getById(mesBuildingProductionLine.getWorkshopId()).getName();
      String artProductionLineName = this.productionLineService.getById(mesBuildingProductionLine.getId()).getName();
      header.put("artifactName", artworkName + ">" + artProductionLineName);
      header.put("artifactOrder", ArtifactOrder.getOrderNumber());
      List<MesBuildingProductionTaskDTO> productTaskList = this.getProductTaskList(
         projectId, processId, orderId, productType, type, productionLineTypeEnum, startDate, endDate, null, null, null
      );
      header.put("serialNumber", productTaskList.get(0).getProject().getSerialNumber());
      header.put("shortName", productTaskList.get(0).getProject().getShortName());
      header.put("Name", productTaskList.get(0).getProject().getName());
      printVO.setHeader(header);
      printVO.setTable(productTaskList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProductTasksListPrint(
      Long projectId,
      Long processId,
      List<Long> orderIds,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<MesBuildingProductionTaskDTO> productTaskAllList = new ArrayList<>();

      for (Long orderId : orderIds) {
         MesBuildingTaskOrder orderBizById = this.taskOrderBiz.getById(orderId);
         MesBuildingProductionLine productionLine = this.productionLineService.getById(orderBizById.getProductionLineId());
         String workName = this.workshopService.getById(productionLine.getWorkshopId()).getName();
         header.put("name", workName + ">" + productionLine.getName() + ">");
         MesBuildingTaskOrder ArtifactOrder = this.taskOrderBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
                  .eq(MesBuildingTaskOrder::getTopTaskOrderId, orderBizById.getTopTaskOrderId())
                  .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         MesBuildingProductionLine mesBuildingProductionLine = this.productionLineService.getById(orderBizById.getProductionLineId());
         String artworkName = this.workshopService.getById(mesBuildingProductionLine.getWorkshopId()).getName();
         header.put("artifactName", artworkName + ">" + mesBuildingProductionLine.getName());
         header.put("artifactOrder", ArtifactOrder.getOrderNumber());
         new ArrayList();
         List<MesBuildingProductionTaskDTO> productTaskList = this.getProductTaskList(
            projectId, processId, orderId, productType, type, productionLineTypeEnum, startDate, endDate, null, null, null
         );
         productTaskList.forEach(e -> e.setOrderNumber(ArtifactOrder.getOrderNumber()));
         header.put("serialNumber", ((MesBuildingProductionTaskDTO)productTaskList.get(0)).getProject().getSerialNumber());
         header.put("shortName", ((MesBuildingProductionTaskDTO)productTaskList.get(0)).getProject().getShortName());
         header.put("Name", ((MesBuildingProductionTaskDTO)productTaskList.get(0)).getProject().getName());
         productTaskAllList.addAll(productTaskList);
      }

      printVO.setHeader(header);
      printVO.setTable(productTaskAllList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProductTasksListPrintV2(
      Long projectId,
      Long processId,
      List<Long> orderIds,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<MesBuildingProductionTaskDTO> productTaskAllList = new ArrayList<>();

      for (Long orderId : orderIds) {
         MesBuildingTaskOrder orderBizById = this.taskOrderBiz.getById(orderId);
         MesBuildingProductionLine productionLine = this.productionLineService.getById(orderBizById.getProductionLineId());
         String workName = this.workshopService.getById(productionLine.getWorkshopId()).getName();
         header.put("name", workName + ">" + productionLine.getName() + ">");
         MesBuildingTaskOrder ArtifactOrder = this.taskOrderBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
                  .eq(MesBuildingTaskOrder::getTopTaskOrderId, orderBizById.getTopTaskOrderId())
                  .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         MesBuildingProductionLine mesBuildingProductionLine = this.productionLineService.getById(orderBizById.getProductionLineId());
         String artworkName = this.workshopService.getById(mesBuildingProductionLine.getWorkshopId()).getName();
         header.put("artifactName", artworkName + ">" + mesBuildingProductionLine.getName());
         header.put("artifactOrder", ArtifactOrder.getOrderNumber());
         new ArrayList();
         List<MesBuildingProductionTaskDTO> productTaskList = this.getProductTaskList(
            projectId, processId, orderId, orderBizById.getTaskTypeEnum(), type, productionLineTypeEnum, startDate, endDate, null, null, null
         );
         productTaskList.forEach(e -> e.setOrderNumber(ArtifactOrder.getOrderNumber()));
         header.put("serialNumber", ((MesBuildingProductionTaskDTO)productTaskList.get(0)).getProject().getSerialNumber());
         header.put("shortName", ((MesBuildingProductionTaskDTO)productTaskList.get(0)).getProject().getShortName());
         header.put("Name", ((MesBuildingProductionTaskDTO)productTaskList.get(0)).getProject().getName());
         productTaskAllList.addAll(productTaskList);
      }

      printVO.setHeader(header);
      printVO.setTable(productTaskAllList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<List<TaskTrackingProcessDTO>> taskMachinePartProcess(
      Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer taskType
   ) {
      List<List<TaskTrackingProcessDTO>> dtoList = new ArrayList<>();
      List<TaskTrackingProcessDTO> taskTrackingProcessDTOS = this.baseService
         .taskTrackProcess(taskOrderId, projectId, monomerId, areaId, workshopId, productionLineId, taskType, null, null)
         .stream()
         .map(e -> BeanUtil.copy(e, TaskTrackingProcessDTO.class))
         .collect(Collectors.toList());
      taskTrackingProcessDTOS.forEach(
         e -> {
            Long cutConfigId = e.getCutConfigId();
            MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
            if (mesBuildingMachinePartTeamDetail.getPartProdMode().equals(1)) {
               e.setPartProdModeName("数控切割");
            } else {
               e.setPartProdModeName("半自动切割");
            }

            List<TaskProcessProductDTO> taskProcessProductDTOS;
            if (e.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType())) {
               taskProcessProductDTOS = this.taskProcessProduct(e.getId(), e.getProductType(), taskOrderId, null, null, projectId, monomerId, areaId, null);
            } else {
               taskProcessProductDTOS = this.taskProcessProduct(
                  e.getId(), e.getProductType(), taskOrderId, e.getProductionLine().getId(), null, projectId, monomerId, areaId, null
               );
            }

            Integer quantity = 0;
            Integer completeQuantity = 0;
            BigDecimal mete = BigDecimal.ZERO;
            BigDecimal completeMete = BigDecimal.ZERO;
            BigDecimal totalGrossWeight = BigDecimal.ZERO;
            BigDecimal totalNetWeight = BigDecimal.ZERO;
            BigDecimal completeGrossWeight = BigDecimal.ZERO;
            BigDecimal completeNetWeight = BigDecimal.ZERO;
            Integer status = 1;
            Integer unQuantity = 0;

            for (TaskProcessProductDTO dto : taskProcessProductDTOS) {
               quantity = quantity + dto.getQuantity();
               completeQuantity = completeQuantity + dto.getCompleteQuantity();
               mete = mete.add(dto.getNetWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
               completeMete = completeMete.add(dto.getNetWeight().multiply(BigDecimal.valueOf(dto.getCompleteQuantity().intValue())));
               totalNetWeight = totalNetWeight.add(dto.getNetWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
               totalGrossWeight = totalGrossWeight.add(dto.getGrossWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
               completeNetWeight = completeNetWeight.add(dto.getNetWeight().multiply(BigDecimal.valueOf(dto.getCompleteQuantity().intValue())));
               completeGrossWeight = completeGrossWeight.add(dto.getGrossWeight().multiply(BigDecimal.valueOf(dto.getCompleteQuantity().intValue())));
               status = status.equals(1) ? dto.getStatus() : status;
               unQuantity = unQuantity + dto.getUnQuantity();
            }

            e.setQuantity(quantity);
            e.setMete(mete);
            e.setCompleteMete(completeMete);
            e.setCompleteQuantity(completeQuantity);
            e.setTotalGrossWeight(totalGrossWeight);
            e.setTotalNetWeight(totalNetWeight);
            e.setCompleteNetWeight(completeNetWeight);
            e.setCompleteGrossWeight(completeGrossWeight);
            e.setStatus(status);
            e.setUnQuantity(unQuantity);
            e.setRate(new BigDecimal(e.getCompleteQuantity()).divide(new BigDecimal(e.getQuantity()), 2, 4));
         }
      );
      dtoList.add(taskTrackingProcessDTOS);
      return dtoList;
   }

   @Override
   public ProgressProcessDTO taskArtifactProcess(Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId) {
      List<MesBuildingTaskOrder> taskOrderList = this.taskOrderBiz
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrder.class).eq(MesBuildingTaskOrder::getTopTaskOrderId, taskOrderId));
      ProgressProcessDTO processDTO = new ProgressProcessDTO();
      List<List<TaskTrackingProcessDTO>> artifactLists = new ArrayList<>();
      List<List<TaskTrackingProcessDTO>> assembleLists = new ArrayList<>();

      for (MesBuildingTaskOrder e : taskOrderList) {
         if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            if (e.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType())) {
               List<TaskTrackingProcessDTO> artifactTaskList = new ArrayList<>();
               List<MesBuildingTask> taskList = this.taskBiz
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTask.class)
                        .eq(MesBuildingTask::getTaskOrderId, e.getId())
                        .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                  );
               List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
               List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
               List<Long> singleArtifactIds = new ArrayList<>();
               List<Long> allPartArtifactIds = techArtifacts.stream()
                  .filter(TechArtifact::getBoolAllPartSendDirectly)
                  .map(TechArtifact::getId)
                  .collect(Collectors.toList());
               singleArtifactIds.addAll(allPartArtifactIds);
               if (singleArtifactIds.size() != 0) {
                  artifactTaskList = this.baseService
                     .taskTrack(e.getId(), projectId, monomerId, areaId, workshopId, productionLineId, e.getTaskTypeEnum(), singleArtifactIds)
                     .stream()
                     .map(artifactTaskDTO -> BeanUtil.copy(artifactTaskDTO, TaskTrackingProcessDTO.class))
                     .collect(Collectors.toList());

                  for (TaskTrackingProcessDTO taskTrackingDTO : artifactTaskList) {
                     taskTrackingDTO.setName("散发檩条");
                     taskTrackingDTO.setType(1);
                     taskTrackingDTO.setId(-1L);
                     List<TaskProcessProductDTO> taskProcessProductDTOS = this.taskProcessProduct(
                        null, taskTrackingDTO.getProductType(), e.getId(), null, null, projectId, monomerId, areaId, null
                     );
                     Integer quantity = 0;
                     Integer completeQuantity = 0;
                     BigDecimal mete = BigDecimal.ZERO;
                     BigDecimal completeMete = BigDecimal.ZERO;
                     BigDecimal totalGrossWeight = BigDecimal.ZERO;
                     BigDecimal totalNetWeight = BigDecimal.ZERO;
                     BigDecimal completeGrossWeight = BigDecimal.ZERO;
                     BigDecimal completeNetWeight = BigDecimal.ZERO;
                     Integer status = 1;
                     Integer unQuantity = 0;

                     for (TaskProcessProductDTO productDTO : taskProcessProductDTOS) {
                        quantity = quantity + productDTO.getQuantity();
                        completeQuantity = completeQuantity + productDTO.getCompleteQuantity();
                        mete = mete.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                        completeMete = completeMete.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue())));
                        totalNetWeight = totalNetWeight.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                        totalGrossWeight = totalGrossWeight.add(productDTO.getGrossWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                        completeNetWeight = completeNetWeight.add(
                           productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue()))
                        );
                        completeGrossWeight = completeGrossWeight.add(
                           productDTO.getGrossWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue()))
                        );
                        status = status.equals(1) ? productDTO.getStatus() : status;
                        unQuantity = unQuantity + productDTO.getUnQuantity();
                     }

                     taskTrackingDTO.setQuantity(quantity);
                     taskTrackingDTO.setCompleteQuantity(completeQuantity);
                     taskTrackingDTO.setMete(mete);
                     taskTrackingDTO.setCompleteMete(completeMete);
                     taskTrackingDTO.setTotalGrossWeight(totalGrossWeight);
                     taskTrackingDTO.setTotalNetWeight(totalNetWeight);
                     taskTrackingDTO.setCompleteNetWeight(completeNetWeight);
                     taskTrackingDTO.setCompleteGrossWeight(completeGrossWeight);
                     taskTrackingDTO.setStatus(status);
                     taskTrackingDTO.setUnQuantity(unQuantity);
                     taskTrackingDTO.setRate(new BigDecimal(taskTrackingDTO.getCompleteQuantity()).divide(new BigDecimal(taskTrackingDTO.getQuantity()), 2, 4));
                  }
               }

               List<TaskTrackingProcessDTO> artifactTaskProcessList = this.baseService
                  .taskTrackProcess(e.getId(), projectId, monomerId, areaId, workshopId, productionLineId, e.getTaskTypeEnum(), null, null)
                  .stream()
                  .map(artifactTaskProcessDTO -> BeanUtil.copy(artifactTaskProcessDTO, TaskTrackingProcessDTO.class))
                  .collect(Collectors.toList());
               if (artifactTaskProcessList.size() > 0) {
                  for (TaskTrackingProcessDTO dto : artifactTaskProcessList) {
                     List<TaskProcessProductDTO> taskProcessProductDTOS = this.taskProcessProduct(
                        dto.getId(), dto.getProductType(), e.getId(), null, null, projectId, monomerId, areaId, null
                     );
                     Integer quantity = 0;
                     Integer completeQuantity = 0;
                     BigDecimal mete = BigDecimal.ZERO;
                     BigDecimal completeMete = BigDecimal.ZERO;
                     BigDecimal totalGrossWeight = BigDecimal.ZERO;
                     BigDecimal totalNetWeight = BigDecimal.ZERO;
                     BigDecimal completeGrossWeight = BigDecimal.ZERO;
                     BigDecimal completeNetWeight = BigDecimal.ZERO;
                     Integer status = 1;
                     Integer unQuantity = 0;

                     for (TaskProcessProductDTO productDTO : taskProcessProductDTOS) {
                        quantity = quantity + productDTO.getQuantity();
                        completeQuantity = completeQuantity + productDTO.getCompleteQuantity();
                        mete = mete.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                        completeMete = completeMete.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue())));
                        totalNetWeight = totalNetWeight.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                        totalGrossWeight = totalGrossWeight.add(productDTO.getGrossWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                        completeNetWeight = completeNetWeight.add(
                           productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue()))
                        );
                        completeGrossWeight = completeGrossWeight.add(
                           productDTO.getGrossWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue()))
                        );
                        status = status.equals(1) ? productDTO.getStatus() : status;
                        unQuantity = unQuantity + productDTO.getUnQuantity();
                     }

                     dto.setQuantity(quantity);
                     dto.setCompleteQuantity(completeQuantity);
                     dto.setMete(mete);
                     dto.setCompleteMete(completeMete);
                     dto.setTotalGrossWeight(totalGrossWeight);
                     dto.setTotalNetWeight(totalNetWeight);
                     dto.setCompleteNetWeight(completeNetWeight);
                     dto.setCompleteGrossWeight(completeGrossWeight);
                     dto.setStatus(status);
                     dto.setUnQuantity(unQuantity);
                     dto.setRate(new BigDecimal(dto.getCompleteQuantity()).divide(new BigDecimal(dto.getQuantity()), 2, 4));
                  }
               }

               artifactTaskProcessList.addAll(artifactTaskList);
               artifactLists.add(artifactTaskProcessList);
            }

            if (e.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.SMART_LINE.getType())) {
               List<TaskTrackingProcessDTO> artifactList = this.baseService
                  .taskOrderNumber(e.getId(), e.getTaskTypeEnum(), workshopId, productionLineId)
                  .stream()
                  .map(artifactDto -> BeanUtil.copy(artifactDto, TaskTrackingProcessDTO.class))
                  .collect(Collectors.toList());
               artifactLists.add(artifactList);
            }
         }

         processDTO.setArtifactList(artifactLists);
         if (e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            List<Long> assembleIds = null;
            if (areaId != null) {
               List<TechAssemble> assembleList = this.techAssembleService.list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getAreaId, areaId));
               assembleIds = assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
            }

            List<TaskTrackingProcessDTO> assembleList = this.baseService
               .taskTrackProcess(e.getId(), projectId, monomerId, areaId, workshopId, productionLineId, e.getTaskTypeEnum(), assembleIds, null)
               .stream()
               .map(assembleDto -> BeanUtil.copy(assembleDto, TaskTrackingProcessDTO.class))
               .collect(Collectors.toList());

            for (TaskTrackingProcessDTO dto : assembleList) {
               List<TaskProcessProductDTO> taskProcessProductDTOS = this.taskProcessProduct(
                  dto.getId(), dto.getProductType(), e.getId(), null, null, projectId, monomerId, areaId, null
               );
               Integer quantity = 0;
               Integer completeQuantity = 0;
               BigDecimal mete = BigDecimal.ZERO;
               BigDecimal completeMete = BigDecimal.ZERO;
               BigDecimal totalNetWeight = BigDecimal.ZERO;
               BigDecimal completeNetWeight = BigDecimal.ZERO;
               Integer status = 1;
               Integer unQuantity = 0;

               for (TaskProcessProductDTO productDTO : taskProcessProductDTOS) {
                  quantity = quantity + productDTO.getQuantity();
                  completeQuantity = completeQuantity + productDTO.getCompleteQuantity();
                  mete = mete.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                  completeMete = completeMete.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue())));
                  totalNetWeight = totalNetWeight.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getQuantity().intValue())));
                  completeNetWeight = completeNetWeight.add(productDTO.getNetWeight().multiply(BigDecimal.valueOf(productDTO.getCompleteQuantity().intValue())));
                  status = status.equals(1) ? productDTO.getStatus() : status;
                  unQuantity = unQuantity + productDTO.getUnQuantity();
               }

               dto.setQuantity(quantity);
               dto.setCompleteQuantity(completeQuantity);
               dto.setMete(mete);
               dto.setCompleteMete(completeMete);
               dto.setTotalNetWeight(totalNetWeight);
               dto.setCompleteNetWeight(completeNetWeight);
               dto.setStatus(status);
               dto.setUnQuantity(unQuantity);
               dto.setRate(new BigDecimal(dto.getCompleteQuantity()).divide(new BigDecimal(dto.getQuantity()), 2, 4));
            }

            assembleLists.add(assembleList);
         }

         processDTO.setAssembleList(assembleLists);
      }

      return processDTO;
   }

   @Override
   public List<TaskArtifactProductDTO> taskArtifactList(
      Long topTaskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId
   ) {
      MesBuildingTaskOrder taskOrder = this.taskOrderBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
               .eq(MesBuildingTaskOrder::getTopTaskOrderId, topTaskOrderId)
               .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingTaskOrder::getProductionLineTypeEnum, ProductionLineTypeEnum.SMART_LINE.getType())
         );
      List<TaskArtifactProductDTO> dtoList = this.baseService.taskArtifactList(taskOrder.getId(), projectId, monomerId, areaId, workshopId, productionLineId);
      dtoList.forEach(e -> {
         int i = LocalDate.now().toString().compareTo(e.getCompleteDate().toLocalDate().toString());
         if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
            e.setStatus(0);
         } else {
            e.setStatus(1);
         }

         e.setUnQuantity(e.getQuantity() - e.getCompleteQuantity());
      });
      return dtoList;
   }

   @Override
   public PageVO<TaskArtifactProductDTO> taskArtifactPage(
      Long topTaskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer pageNumber, Integer pageSize
   ) {
      MesBuildingTaskOrder taskOrder = this.taskOrderBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
               .eq(MesBuildingTaskOrder::getTopTaskOrderId, topTaskOrderId)
               .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingTaskOrder::getProductionLineTypeEnum, ProductionLineTypeEnum.SMART_LINE.getType())
         );
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<TaskArtifactProductDTO> dtoList = this.baseService.taskArtifactList(taskOrder.getId(), projectId, monomerId, areaId, workshopId, productionLineId);
      dtoList.forEach(e -> e.setUnQuantity(e.getQuantity() - e.getCompleteQuantity()));
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<TaskProcessProductDTO> taskProcessProduct(
      Long processId, Integer taskType, Long orderId, Long prodLineId, String name, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      List<Long> projectIds = new ArrayList<>();
      if (projectId != null) {
         projectIds.add(projectId);
      }

      if (processId == null) {
         List<MesBuildingTask> taskList = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getTaskOrderId, orderId)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
         List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
         List<Long> singleArtifactIds = new ArrayList<>();

         for (TechArtifact techArtifact : techArtifacts.stream()
            .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
            .collect(Collectors.toList())) {
            if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
               singleArtifactIds.add(techArtifact.getId());
            }
         }

         List<Long> allPartArtifactIds = techArtifacts.stream()
            .filter(TechArtifact::getBoolAllPartSendDirectly)
            .map(TechArtifact::getId)
            .collect(Collectors.toList());
         singleArtifactIds.addAll(allPartArtifactIds);
         if (taskType.equals(TaskTypeEnum.ARTIFACT.getType()) && singleArtifactIds.size() != 0) {
            List<TaskProcessProductDTO> dtoList = this.baseService
               .taskProduct(taskType, orderId, prodLineId, name, projectIds, monomerId, areaId, serialNumber, singleArtifactIds)
               .stream()
               .map(e -> BeanUtil.copy(e, TaskProcessProductDTO.class))
               .collect(Collectors.toList());
            String dateTime = LocalDate.now().toString();
            dtoList.forEach(e -> {
               int i = dateTime.compareTo(e.getCompleteDate().toLocalDate().toString());
               if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
                  e.setStatus(0);
               } else {
                  e.setStatus(1);
               }

               e.setUnQuantity(e.getQuantity() - e.getCompleteQuantity());
            });
            dtoList.sort(Comparator.comparing(TaskProcessProductDTO::getStatus));
            return dtoList;
         }
      }

      List<Long> assembleIds = null;
      if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType()) && areaId != null) {
         List<TechAssemble> assembleList = this.techAssembleService.list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getAreaId, areaId));
         assembleIds = assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
      }

      List<TaskProcessProductDTO> dtoList = this.baseService
         .taskProcessProduct(processId, taskType, orderId, prodLineId, name, projectIds, monomerId, areaId, serialNumber, assembleIds)
         .stream()
         .map(e -> BeanUtil.copy(e, TaskProcessProductDTO.class))
         .collect(Collectors.toList());
      String dateTime = LocalDate.now().toString();
      dtoList.forEach(e -> {
         int i = dateTime.compareTo(e.getCompleteDate().toLocalDate().toString());
         if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
            e.setStatus(0);
         } else {
            e.setStatus(1);
         }

         e.setUnQuantity(e.getQuantity() - e.getCompleteQuantity());
      });
      dtoList.sort(Comparator.comparing(TaskProcessProductDTO::getStatus));
      return dtoList;
   }

   @Override
   public PageVO<TaskProcessProductDTO> taskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = new ArrayList<>();
      if (projectId != null) {
         projectIds.add(projectId);
      }

      if (processId == null || processId == -1L) {
         List<MesBuildingTask> taskList = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getTaskOrderId, orderId)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
         List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
         List<Long> singleArtifactIds = new ArrayList<>();

         for (TechArtifact techArtifact : techArtifacts.stream()
            .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
            .collect(Collectors.toList())) {
            if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
               singleArtifactIds.add(techArtifact.getId());
            }
         }

         List<Long> allPartArtifactIds = techArtifacts.stream()
            .filter(TechArtifact::getBoolAllPartSendDirectly)
            .map(TechArtifact::getId)
            .collect(Collectors.toList());
         singleArtifactIds.addAll(allPartArtifactIds);
         if (taskType.equals(TaskTypeEnum.ARTIFACT.getType()) && singleArtifactIds.size() != 0) {
            Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
            List<TaskProcessProductDTO> dtoList = this.baseService
               .taskProduct(taskType, orderId, groupId, name, projectIds, monomerId, areaId, serialNumber, singleArtifactIds)
               .stream()
               .map(e -> BeanUtil.copy(e, TaskProcessProductDTO.class))
               .collect(Collectors.toList());
            String dateTime = LocalDate.now().toString();
            dtoList.forEach(e -> {
               int i = dateTime.compareTo(e.getCompleteDate().toLocalDate().toString());
               if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
                  e.setStatus(0);
               } else {
                  e.setStatus(1);
               }

               e.setUnQuantity(e.getQuantity() - e.getCompleteQuantity());
            });
            dtoList.sort(Comparator.comparing(TaskProcessProductDTO::getStatus));
            return new PageVO<>(page, dtoList);
         }
      }

      List<Long> assembleIds = null;
      if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType()) && areaId != null) {
         List<TechAssemble> assembleList = this.techAssembleService.list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getAreaId, areaId));
         assembleIds = assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<TaskProcessProductDTO> dtoList = this.baseService
         .taskProcessProduct(processId, taskType, orderId, groupId, name, projectIds, monomerId, areaId, serialNumber, assembleIds)
         .stream()
         .map(e -> BeanUtil.copy(e, TaskProcessProductDTO.class))
         .collect(Collectors.toList());
      String dateTime = LocalDate.now().toString();
      dtoList.forEach(e -> {
         int i = dateTime.compareTo(e.getCompleteDate().toLocalDate().toString());
         if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
            e.setStatus(0);
         } else {
            e.setStatus(1);
         }

         e.setUnQuantity(e.getQuantity() - e.getCompleteQuantity());
      });
      dtoList.sort(Comparator.comparing(TaskProcessProductDTO::getStatus));
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> taskProcessProductPrint(
      LocalDateTime dateTime,
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (dateTime != null) {
         header.put("date", dateTime.getYear() + "-" + dateTime.getMonth());
      }

      printVO.setHeader(header);
      printVO.setTable(
         this.taskProcessProduct(processId, taskType, orderId, groupId, name, projectId, monomerId, areaId, serialNumber)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<TaskProcessDullDTO> taskDullProcess(Long workShopId) {
      List<TaskProcessDullDTO> taskProcessDullDTOS = this.baseService.taskDullProcess(workShopId);

      for (TaskProcessDullDTO dullDTO : taskProcessDullDTOS) {
         List<NameInfo> groupsList = this.groupsBiz
            .list(Wrappers.lambdaQuery(MesBuildingGroups.class).eq(MesBuildingGroups::getProductionLineId, dullDTO.getProductionLine().getId()))
            .stream()
            .map(e -> BeanUtil.copy(e, NameInfo.class))
            .collect(Collectors.toList());
         dullDTO.setGroupList(groupsList);
      }

      List<TaskProcessDullDTO> taskProcessDrilingAssemble = this.baseService.taskDullProcessByAssemble(workShopId);

      for (TaskProcessDullDTO dullDTO : taskProcessDrilingAssemble) {
         List<NameInfo> groupsList = this.groupsBiz
            .list(Wrappers.lambdaQuery(MesBuildingGroups.class).eq(MesBuildingGroups::getProductionLineId, dullDTO.getProductionLine().getId()))
            .stream()
            .map(e -> BeanUtil.copy(e, NameInfo.class))
            .collect(Collectors.toList());
         dullDTO.setGroupList(groupsList);
      }

      taskProcessDullDTOS.addAll(taskProcessDrilingAssemble);
      return taskProcessDullDTOS;
   }

   @Override
   public PageVO<TaskProcessDullDTO> taskDullProcessV2(
      Long workShopId, Long productionLineId, Long projectId, Long processId, Long teamId, Integer pageNumber, Integer pageSize
   ) {
      List<TaskProcessDullDTO> taskProcessDullDTOS = this.baseMapper.taskDullProcessV2(workShopId, productionLineId, projectId, processId, teamId);
      List<TaskProcessDullDTO> taskProcessDrilingAssemble = this.baseMapper
         .taskDullProcessByAssembleV2(workShopId, productionLineId, projectId, processId, teamId);
      taskProcessDullDTOS.addAll(taskProcessDrilingAssemble);
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<TaskProcessDullDTO> visibleList = taskProcessDullDTOS.stream().filter(e -> projectIds.contains(e.getProject().getId())).collect(Collectors.toList());
      return PageUtil.listPage(pageNumber, pageSize, visibleList);
   }

   @Override
   public List<TaskProcessProductDTO> taskDullProcessDetail(
      Integer taskType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   ) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      return this.baseService.taskDullProcessDetail(taskType, processId, productionLineId, projectIds, monomerId, areaId, serialNumber, groupId);
   }

   private List<TaskProcessProductDTO> taskDullProcessDetailV2(
      Integer taskType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   ) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      return this.baseMapper.taskDullProcessDetailV2(taskType, processId, productionLineId, projectIds, monomerId, areaId, serialNumber, groupId);
   }

   @Override
   public PageVO<TaskProcessProductDTO> taskDullProcessDetailPage(
      Integer taskType,
      Long processId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long groupId,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<TaskProcessProductDTO> dtoList = this.baseService
         .taskDullProcessDetail(taskType, processId, productionLineId, projectIds, monomerId, areaId, serialNumber, groupId);
      return new PageVO<>(dtoList);
   }

   @Override
   public PageVO<TaskProcessProductDTO> taskDullProcessDetailPageV2(
      Integer taskType,
      Long processId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long groupId,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<TaskProcessProductDTO> dtoList = this.baseMapper
         .taskDullProcessDetailV2(taskType, processId, productionLineId, projectIds, monomerId, areaId, serialNumber, groupId);
      return new PageVO<>(dtoList);
   }

   @Override
   public List<ProjectDetailDO> taskDullProcessProject(Integer productType, Long processId, Long productionLineId) {
      return this.taskDullProcessDetail(productType, processId, productionLineId, null, null, null, null, null)
         .stream()
         .map(TaskProcessProductDTO::getProject)
         .distinct()
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> taskDullProcessDetailPrint(
      Integer productType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(
         this.taskDullProcessDetail(productType, processId, productionLineId, projectId, monomerId, areaId, serialNumber, groupId)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> taskDullProcessDetailPrintV2(
      Integer productType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(
         this.taskDullProcessDetailV2(productType, processId, productionLineId, projectId, monomerId, areaId, serialNumber, groupId)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public Boolean getProductTaskListPrintSign(Long orderId) {
      MesBuildingTaskOrder byId = this.taskOrderBiz.getById(orderId);
      Preconditions.checkArgument(byId != null, "打印失败,任务工单不存在");
      byId.setPrintQuantity(byId.getPrintQuantity() + 1);
      this.taskOrderBiz.updateById(byId);
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingAssistProcessDTO> getAssistProcessListByTaskOrderIdList(List<Long> taskOrderIds) {
      return this.baseService
         .getAssistProcessListByTaskOrderIdList(taskOrderIds)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingAssistProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingAssistProductDTO> getProductAssistList(
      Long taskOrderId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      List<Long> taskProcessIdList,
      Integer assistEnum
   ) {
      List<MesBuildingAssistProductDTO> processList = this.baseService
         .productProcessList(taskOrderId, areaId, processId, taskTypeEnum, serialNumber, specification, taskProcessIdList, assistEnum);
      if (CollectionUtils.isEmpty(processList)) {
         return new ArrayList<>();
      }

      List<Long> taskProcessIds = processList.stream().map(MesBuildingAssistProductDTO::getId).collect(Collectors.toList());
      List<Long> taskIds = processList.stream().map(MesBuildingAssistProductDTO::getTaskId).collect(Collectors.toList());
      Map<Long, MesBuildingAssistProductDTO> assistProductDTOMap = processList.stream()
         .collect(Collectors.toMap(MesBuildingAssistProductDTO::getTaskId, Function.identity()));
      Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().apply(" task_type_enum & {0} ", taskTypeEnum))
               .in(MesBuildingProduceTeamReport::getTaskProcessId, taskProcessIds)
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskId));
      List<MesBuildingTaskNumberLink> allLinks = this.numberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .in(taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType()), MesBuildingTaskNumberLink::getArtifactTaskId, taskIds)
               .in((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0, MesBuildingTaskNumberLink::getAssembleTaskId, taskIds)
         );
      List<MesBuildingTaskNumberLink> links = new ArrayList<>();

      for (MesBuildingTaskNumberLink link : allLinks) {
         if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
            link.setArtifactTaskProcessId(assistProductDTOMap.get(link.getArtifactTaskId()).getId());
            List<MesBuildingProduceTeamReport> reports = produceTeamReportMap.get(link.getArtifactTaskId());
            if (CollectionUtils.isNotEmpty(reports)) {
               List<Integer> numbers = reports.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
               if (numbers.contains(link.getArtifactNumber())) {
                  continue;
               }
            }
         }

         if ((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0) {
            link.setAssembleTaskProcessId(assistProductDTOMap.get(link.getAssembleTaskId()).getId());
            List<MesBuildingProduceTeamReport> reports = produceTeamReportMap.get(link.getAssembleTaskId());
            if (CollectionUtils.isNotEmpty(reports)) {
               List<Integer> numbers = reports.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
               if (numbers.contains(link.getAssembleNumber())) {
                  continue;
               }
            }
         }

         links.add(link);
      }

      Map<Long, Set<Integer>> taskProcessNumberMap = new HashMap<>();
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         taskProcessNumberMap = links.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingTaskNumberLink::getArtifactTaskProcessId, Collectors.mapping(MesBuildingTaskNumberLink::getArtifactNumber, Collectors.toSet())
               )
            );
      }

      if ((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0) {
         taskProcessNumberMap = links.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingTaskNumberLink::getAssembleTaskProcessId, Collectors.mapping(MesBuildingTaskNumberLink::getAssembleNumber, Collectors.toSet())
               )
            );
      }

      if (CollectionUtils.isNotEmpty(processList)) {
         Map<Long, List<MesBuildingAssist>> assistMap = new HashMap<>();
         Map<Long, List<MesBuildingAssistNumberDetail>> assistNumberMap = new HashMap<>();
         Map<Long, ProductLineDetailDTO> productLineDetailDTOMap = new HashMap<>();
         List<MesBuildingAssist> assists = this.mesBuildingAssistService
            .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, taskProcessIds));
         if (CollectionUtils.isNotEmpty(assists)) {
            List<MesBuildingAssistNumberDetail> assistDetails = this.assistNumberDetailService
               .list(
                  Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                     .in(MesBuildingAssistNumberDetail::getAssistId, assists.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()))
               );
            assistNumberMap = assistDetails.stream().collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getAssistId));
            assistMap = assists.stream().collect(Collectors.groupingBy(MesBuildingAssist::getTaskProcessId));
            List<Long> productionLineIds = assists.stream().map(MesBuildingAssist::getProductionLineId).collect(Collectors.toList());
            productLineDetailDTOMap = this.productionLineService
               .getTreeByLineIds(productionLineIds)
               .stream()
               .collect(Collectors.toMap(ProductLineDetailDTO::getProductionLineId, Function.identity()));
         }

         for (MesBuildingAssistProductDTO dto : processList) {
            Set<Integer> allNumbers = taskProcessNumberMap.get(dto.getId());
            List<MesBuildingAssistDetailDTO> assistDetailDTOS = new ArrayList<>();
            List<MesBuildingAssist> mesBuildingAssists = assistMap.get(dto.getId());
            if (CollectionUtils.isNotEmpty(mesBuildingAssists)) {
               for (MesBuildingAssist mesBuildingAssist : mesBuildingAssists) {
                  ProductLineDetailDTO productLineDetailDTO = productLineDetailDTOMap.get(mesBuildingAssist.getProductionLineId());
                  List<MesBuildingNumberReplaceDTO> assNumbers = assistNumberMap.get(mesBuildingAssist.getId())
                     .stream()
                     .map(s -> MesBuildingNumberReplaceDTO.builder().number(s.getNumber()).boolReplace(!s.getBoolFinishEnum()).build())
                     .collect(Collectors.toList());
                  List<Integer> assNumberList = assNumbers.stream().map(MesBuildingNumberReplaceDTO::getNumber).collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(allNumbers)) {
                     allNumbers.removeAll(assNumberList);
                  }

                  MesBuildingAssistDetailDTO build = MesBuildingAssistDetailDTO.builder()
                     .assistId(mesBuildingAssist.getId())
                     .numbers(assNumbers)
                     .factoryId(productLineDetailDTO.getFactoryId())
                     .workshop(WorkshopDetailDO.builder().id(productLineDetailDTO.getWorkshopId()).name(productLineDetailDTO.getWorkshopName()).build())
                     .productionLine(
                        ProductionLineDetailDO.builder()
                           .id(productLineDetailDTO.getProductionLineId())
                           .name(productLineDetailDTO.getProductionLineName())
                           .build()
                     )
                     .processId(mesBuildingAssist.getProcessId())
                     .quantity(mesBuildingAssist.getQuantity())
                     .boolCanDelete(mesBuildingAssist.getProduceQuantity() == 0)
                     .boolUpdateGroup(mesBuildingAssist.getProduceQuantity() == 0)
                     .produceQuantity(mesBuildingAssist.getProduceQuantity())
                     .build();
                  assistDetailDTOS.add(build);
               }
            }

            dto.setMesBuildingAssistDetailDTOS(assistDetailDTOS);
            dto.setBoolOperations(CollectionUtils.isNotEmpty(allNumbers));
            if (CollectionUtils.isNotEmpty(allNumbers)) {
               dto.setNumberList(new ArrayList<>(allNumbers));
            }

            dto.setBoolOnecode(Boolean.FALSE);
            dto.setTotalAssistQuantity(assistDetailDTOS.stream().mapToInt(MesBuildingAssistDetailDTO::getQuantity).sum());
            QuantityAndWeightDetailDO totalCanAssistMete = dto.getTotalCanAssistMete();
            totalCanAssistMete.setQuantity(CollectionUtils.isEmpty(allNumbers) ? 0 : allNumbers.size());
         }
      }

      if (AssistEnum.CAN_OPERATED.getType().equals(assistEnum)) {
         processList = processList.stream().filter(e -> CollectionUtils.isNotEmpty(e.getNumberList())).collect(Collectors.toList());
      }

      return processList;
   }

   @Override
   public PageVO<TaskProcessProductDTO> appTaskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.appTaskProcessProductList(processId, taskType, orderId, groupId, name, monomerId, areaId, serialNumber)
      );
   }

   @Override
   public List<TaskProcessProductDTO> appTaskProcessProductList(
      Long processId, Integer taskType, Long orderId, Long groupId, String name, Long monomerId, Long areaId, String serialNumber
   ) {
      List<TaskProcessProductDTO> taskProcessProductDTOS = this.taskProcessProduct(
         processId, taskType, orderId, groupId, name, null, monomerId, areaId, serialNumber
      );
      if (taskType.equals(TaskTypeEnum.MACHINE_PART.getType())) {
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
            Map<Long, List<TaskProcessProductDTO>> listMap = taskProcessProductDTOS.stream().collect(Collectors.groupingBy(e -> e.getMonomer().getId()));
            listMap.forEach((useMonomerId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(TaskProcessProductDTO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(useMonomerId, serialNumberList);
               drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            Map<Long, List<TaskProcessProductDTO>> listMap = taskProcessProductDTOS.stream().collect(Collectors.groupingBy(e -> e.getArea().getId()));
            listMap.forEach((useAreaId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(TaskProcessProductDTO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(useAreaId, serialNumberList);
               drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         return taskProcessProductDTOS.stream().filter(e -> e.getUnQuantity() > 0).collect(Collectors.toList());
      } else {
         return taskProcessProductDTOS.stream().filter(e -> e.getUnQuantity() > 0).collect(Collectors.toList());
      }
   }

   @Override
   public PageVO<ProjectProcessingOutBoundDTO> projectProgressingOutBoundPage(
      Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.projectProgressingOutBound(projectId, type, startDate, endDate));
   }

   @Override
   public List<ProjectProcessingOutBoundDTO> projectProgressingOutBound(Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate) {
      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      return type == 1
         ? this.outboundService
            .getDetailByCondition(basicClass, projectId, startDate, endDate)
            .stream()
            .map(e -> BeanUtil.copy(e, ProjectProcessingOutBoundDTO.class))
            .collect(Collectors.toList())
         : this.returnService.getDetailByCondition(basicClass, projectId, startDate, endDate).stream().map(e -> {
            ProjectProcessingOutBoundDTO copy = BeanUtil.copy(e, ProjectProcessingOutBoundDTO.class);
            copy.setOutboundTime(e.getUpdateTime());
            return copy;
         }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectProgressingOutBoundPrint(Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(this.projectProgressingOutBound(projectId, type, startDate, endDate).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<MesBuildingProductionTaskDTO> projectProgressingTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.projectProgressingTaskList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId)
      );
   }

   @Override
   public List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      return this.taskBiz.projectProgressingTaskList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectProgressingTaskPrint(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(
         this.projectProgressingTaskList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PageVO<MesBuildingProductionTaskDTO> projectProgressingProcessPage(
      Long projectId,
      Long processId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingProductionTaskDTO> dtoList = this.baseMapper
            .projectProgressingProcessList(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId);
         List<MesBuildingTask> taskList = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getProjectId, projectId)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                  .eq(workshopId != null, MesBuildingTask::getWorkshopId, workshopId)
            );
         Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
         List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         if (artifactIds.size() > 0) {
            List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
            List<Long> singleArtifactIds = new ArrayList<>();

            for (TechArtifact techArtifact : techArtifacts.stream()
               .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
               .collect(Collectors.toList())) {
               if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
                  singleArtifactIds.add(techArtifact.getId());
               }
            }

            List<Long> allPartArtifactIds = techArtifacts.stream()
               .filter(TechArtifact::getBoolAllPartSendDirectly)
               .map(TechArtifact::getId)
               .collect(Collectors.toList());
            singleArtifactIds.addAll(allPartArtifactIds);
            if (singleArtifactIds.size() != 0) {
               List<MesBuildingProductionTaskDTO> taskDTOList = this.taskBiz
                  .projectProgressingList(projectId, monomerId, areaId, serialNumber, singleArtifactIds, workshopId);
               dtoList.addAll(taskDTOList);
            }
         }

         return this.getPages(pageNumber, pageSize, dtoList);
      } else {
         Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
         List<MesBuildingProductionTaskDTO> dtoList = this.baseMapper
            .projectProgressingProcessList(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId);
         return new PageVO<>(page, dtoList);
      }
   }

   private PageVO getPages(Integer pageNumber, Integer pageSize, List list) {
      PageVO page = new PageVO();
      if (list == null) {
         return null;
      }

      int size = list.size();
      if (pageSize > size) {
         pageSize = size;
      }

      if (pageSize != 0) {
         int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
         if (pageNumber > maxPage) {
            pageNumber = maxPage;
         }

         page.setHasNextPage(pageNumber < maxPage);
      }

      int curIdx = pageNumber > 1 ? (pageNumber - 1) * pageSize : 0;
      List pageList = new ArrayList();

      for (int i = 0; i < pageSize && curIdx + i < size; i++) {
         pageList.add(list.get(curIdx + i));
      }

      page.setHasPreviousPage(pageNumber > 1);
      page.setContent(pageList);
      page.setTotalElements(list.size());
      return page;
   }

   @Override
   public List<MesBuildingProductionTaskDTO> projectProgressingProcessList(
      Long projectId, Long processId, Integer taskTypeEnum, Long monomerId, Long areaId, String serialNumber, Long workshopId
   ) {
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingProductionTaskDTO> dtoList = this.baseMapper
            .projectProgressingProcessList(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId);
         List<MesBuildingTask> taskList = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getProjectId, projectId)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                  .eq(workshopId != null, MesBuildingTask::getWorkshopId, workshopId)
            );
         Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
         List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         if (artifactIds.size() > 0) {
            List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
            List<Long> singleArtifactIds = new ArrayList<>();

            for (TechArtifact techArtifact : techArtifacts.stream()
               .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
               .collect(Collectors.toList())) {
               if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
                  singleArtifactIds.add(techArtifact.getId());
               }
            }

            List<Long> allPartArtifactIds = techArtifacts.stream()
               .filter(TechArtifact::getBoolAllPartSendDirectly)
               .map(TechArtifact::getId)
               .collect(Collectors.toList());
            singleArtifactIds.addAll(allPartArtifactIds);
            if (singleArtifactIds.size() != 0) {
               List<MesBuildingProductionTaskDTO> taskDTOList = this.taskBiz
                  .projectProgressingList(projectId, monomerId, areaId, serialNumber, singleArtifactIds, workshopId);
               dtoList.addAll(taskDTOList);
            }
         }

         return dtoList;
      } else {
         return this.baseMapper.projectProgressingProcessList(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectProgressingProcessPrint(
      Long projectId, Long processId, Integer taskTypeEnum, Long monomerId, Long areaId, String serialNumber, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("process", this.processService.getById(processId).getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.projectProgressingProcessList(projectId, processId, taskTypeEnum, monomerId, areaId, serialNumber, workshopId)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<ProductMonitorKanbanByGroupDO> getProductByLastMonth(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseService.getProductByLastMonth(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDO> getProductByYear(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseService.getProductByYear(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDO> getProductByUnComplete(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseService.getProductByUnComplete(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorByGroupDetailDTO> getProductMonitorKanbanByGroupDetail(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   ) {
      return this.baseService
         .getProductMonitorKanbanByGroupDetail(
            workshopId, productionLineId, groupId, teamId, processId, taskTypeEnum, projectId, monomerId, areaId, serialNumber
         );
   }

   @Override
   public PageVO<ProductProcessDTO> pageArtifactProcessByCondition(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      PlanArea area = this.planAreaService.getById(areaId);
      Preconditions.checkArgument(area != null, "查询失败，区域信息不存在");
      if (factoryId != null) {
         MesBuildingFactory factory = this.factoryBiz.getById(factoryId);
         Preconditions.checkArgument(factory != null, "查询失败，工厂信息不存在");
      }

      if (classificationId != null) {
         SysStructureClassification classification = this.structureClassificationService.getById(classificationId);
         Preconditions.checkArgument(classification != null, "查询失败，结构类型信息不存在");
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ProductProcessDTO> productProcessDTOS = this.baseService
         .productByConditionList(
            areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, TaskTypeEnum.ARTIFACT.getType()
         );
      productProcessDTOS.forEach(
         e -> {
            List<ProductProcessQuantityDTO> processDTOList = this.baseService.listProductProcessByProductIdAndType(e.getId(), TaskTypeEnum.ARTIFACT.getType());
            TechArtifact techArtifact = this.techArtifactService.getById(e.getId());
            List<MesBuildingProductProcessLinkDO> processLinkDOList = this.productProcessLinkService
               .getProcessListByTypeIdAndProductType(techArtifact.getStructureClassId(), ProductTypeEnum.ARTIFACT.getType());
            List<ProductProcessQuantityDTO> productProcessResponseVOS = new ArrayList<>();

            for (MesBuildingProductProcessLinkDO processLinkDO : processLinkDOList) {
               ProductProcessQuantityDTO productProcessResponseVO = new ProductProcessQuantityDTO();
               productProcessResponseVO.setId(processLinkDO.getProcessId());
               productProcessResponseVO.setQuantity(0);
               productProcessResponseVO.setInspectionQuantity(0);
               productProcessResponseVOS.add(productProcessResponseVO);
            }

            if (CollectionUtils.isEmpty(processDTOList)) {
               if (techArtifact.getBoolSinglePartEnum() || techArtifact.getBoolAllPartSendDirectly()) {
                  MesBuildingProcess process = null;
                  if (process != null) {
                     MesBuildingTask task = this.taskBiz
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTask.class)
                              .eq(MesBuildingTask::getProductId, e.getId())
                              .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                        );
                     ProductProcessQuantityDTO build = ProductProcessQuantityDTO.builder()
                        .id(process.getId())
                        .quantity(task == null ? 0 : task.getTaskQuantity())
                        .inspectionQuantity(task == null ? 0 : task.getCompleteQuantity())
                        .build();
                     processDTOList.add(build);
                  }
               }

               e.setProcess(productProcessResponseVOS);
            }

            if (CollectionUtils.isNotEmpty(processDTOList)) {
               e.setProcess(processDTOList);
            }
         }
      );
      return new PageVO<>(page, productProcessDTOS);
   }

   @Override
   public PageVO<ProductProcessDTO> pageAssembleProcessByCondition(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      PlanArea area = this.planAreaService.getById(areaId);
      Preconditions.checkArgument(area != null, "查询失败，区域信息不存在");
      if (factoryId != null) {
         MesBuildingFactory factory = this.factoryBiz.getById(factoryId);
         Preconditions.checkArgument(factory != null, "查询失败，工厂信息不存在");
      }

      if (classificationId != null) {
         SysAssembleConfig assembleConfig = this.sysAssembleConfigService.getById(classificationId);
         Preconditions.checkArgument(assembleConfig != null, "查询失败，部件类型信息不存在");
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ProductProcessDTO> assembleProcessDTOS = this.baseService
         .productByConditionList(
            areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, TaskTypeEnum.ASSEMBLE.getType()
         );
      assembleProcessDTOS.forEach(
         e -> {
            List<ProductProcessQuantityDTO> processDTOList = this.baseService.listProductProcessByProductIdAndType(e.getId(), TaskTypeEnum.ASSEMBLE.getType());
            TechAssemble techAssemble = this.techAssembleService.getById(e.getId());
            List<MesBuildingProductProcessLinkDO> processLinkDOList = this.productProcessLinkService
               .getProcessListByTypeIdAndProductType(techAssemble.getAssembleConfigId(), ProductTypeEnum.ASSEMBLE.getType());
            List<ProductProcessQuantityDTO> productProcessResponseVOS = new ArrayList<>();

            for (MesBuildingProductProcessLinkDO processLinkDO : processLinkDOList) {
               ProductProcessQuantityDTO productProcessResponseVO = new ProductProcessQuantityDTO();
               productProcessResponseVO.setId(processLinkDO.getProcessId());
               productProcessResponseVO.setQuantity(0);
               productProcessResponseVO.setInspectionQuantity(0);
               productProcessResponseVOS.add(productProcessResponseVO);
            }

            if (CollectionUtils.isEmpty(processDTOList)) {
               e.setProcess(productProcessResponseVOS);
            } else {
               e.setProcess(processDTOList);
            }
         }
      );
      return new PageVO<>(page, assembleProcessDTOS);
   }

   @Override
   public Map<Long, String> pageArtifactOrAssembleProdLineList(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer taskTypeEnum
   ) {
      List<ProductProcessDTO> assembleProcessDTOS;
      if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         assembleProcessDTOS = this.baseService
            .productByConditionList(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, TaskTypeEnum.ASSEMBLE.getType()
            );
      } else {
         assembleProcessDTOS = this.baseService
            .productByConditionList(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, TaskTypeEnum.ARTIFACT.getType()
            );
      }

      Map<Long, String> ProdLineList = null;
      if (CollectionUtils.isNotEmpty(assembleProcessDTOS)) {
         List<ProductProcessDTO> productProcessDTOS = assembleProcessDTOS.stream().filter(e -> e.getProductionLineId() != null).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(productProcessDTOS)) {
            ProdLineList = productProcessDTOS.stream()
               .collect(Collectors.toMap(ProductProcessDTO::getProductionLineId, ProductProcessDTO::getProductionName, (oldValue, newValue) -> oldValue));
         }
      }

      return ProdLineList;
   }

   @Override
   public void pageArtifactOrAssemblePrint(
      Long projectId,
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer processType,
      HttpServletResponse response
   ) {
      ContractProject project = this.contractProjectService.getOne((Wrapper<ContractProject>)new QueryWrapper().select("name").eq("id", projectId));
      Preconditions.checkArgument(project != null, "项目信息不存在");
      Map<String, Object> exportMap = new HashMap<>();
      exportMap.put("name", project.getName());
      List<ProductProcessDTO> PrintList;
      if (processType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         PrintList = this.pageArtifactProcessByCondition(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, 1, Integer.MAX_VALUE
            )
            .getContent();
      } else {
         PrintList = this.pageAssembleProcessByCondition(
               areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, 1, Integer.MAX_VALUE
            )
            .getContent();
      }

      exportMap.put("printListsize", PrintList.size());
      exportMap.put("printList", PrintList);
      String exportFileName = "生产跟踪.xlsx";
      Workbook sheets = this.ExportExcel(exportMap, processType);
      PoiUtils.unBuilderDownLoadExcel(exportFileName, response, sheets);
   }

   public Workbook ExportExcel(Map<String, Object> exportMap, Integer processType) {
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("生产跟踪");
      Row row = sheet.createRow(0);
      Cell cell = row.createCell(0);
      cell.setCellValue("生产跟踪清单");
      List<MesBuildingProcessDTO> processNameList = null;
      if (processType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         processNameList = this.processBiz.listByCondition(TaskTypeEnum.ARTIFACT.getType(), ProductionLineTypeEnum.TRADITIONAL_LINE.getType());
      } else if (processType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         processNameList = this.processBiz.listByCondition(TaskTypeEnum.ASSEMBLE.getType(), ProductionLineTypeEnum.TRADITIONAL_LINE.getType());
      }

      Row row1 = sheet.createRow(1);
      Cell cella1 = row1.createCell(0);
      Cell cella2 = row1.createCell(processNameList.size());
      cella1.setCellValue("项目：" + exportMap.get("name"));
      if (processType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         cella2.setCellValue("导出类型：构件");
      } else if (processType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         cella2.setCellValue("导出类型：部件");
      }

      Row row2 = sheet.createRow(2);
      row.setHeightInPoints(40.0F);
      row1.setHeightInPoints(30.0F);
      row2.setHeightInPoints(20.0F);
      List<ProductProcessDTO> PrintList = (List<ProductProcessDTO>)exportMap.get("printList");
      Map<Long, Integer> coordinateMap = new HashMap<>();
      Integer cellindex = this.createBaseheaderCells(row2, processType);

      for (int i = 0; i < processNameList.size(); i++) {
         row2.createCell(i + cellindex).setCellValue(processNameList.get(i).getName());
         coordinateMap.put(processNameList.get(i).getId(), i + cellindex);
         sheet.autoSizeColumn(i + cellindex);
         sheet.setColumnWidth(i + cellindex, Math.max(sheet.getColumnWidth(i + cellindex), 4000));
         this.setExcelData(PrintList, coordinateMap, processNameList.size(), processType, sheet);
      }

      CellRangeAddress cellAddresses = new CellRangeAddress(0, 0, 0, cellindex + processNameList.size() - 1);
      CellRangeAddress cellAddresses1 = new CellRangeAddress(1, 1, 0, processNameList.size() - 1);
      CellRangeAddress cellAddresses2 = new CellRangeAddress(1, 1, processNameList.size(), cellindex + processNameList.size() - 1);
      sheet.addMergedRegion(cellAddresses);
      sheet.addMergedRegion(cellAddresses1);
      sheet.addMergedRegion(cellAddresses2);
      copyBorderStyle(sheet, cellAddresses);
      copyBorderStyle(sheet, cellAddresses1);
      copyBorderStyle(sheet, cellAddresses2);
      return workbook;
   }

   private Integer createBaseheaderCells(Row row2, Integer processType) {
      Integer cellindex = 0;
      Cell cellb1 = row2.createCell(0);
      Cell cellb2 = row2.createCell(1);
      Cell cellb3 = row2.createCell(2);
      if (processType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         Cell cellb4 = row2.createCell(3);
         cellb1.setCellValue("序号");
         cellb2.setCellValue("名称");
         cellb3.setCellValue("编号");
         cellb4.setCellValue("清单数量");
         cellindex = 4;
      } else if (processType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         cellb1.setCellValue("序号");
         cellb2.setCellValue("编号");
         cellb3.setCellValue("清单数量");
         cellindex = 3;
      }

      return cellindex;
   }

   public void setExcelData(List<ProductProcessDTO> printList, Map<Long, Integer> coordinateMap, Integer processSize, Integer processType, Sheet sheet) {
      int rowindex = 3;

      for (int i = 0; i < printList.size(); i++) {
         List<ProductProcessQuantityDTO> process = printList.get(i).getProcess();
         Row row = sheet.createRow(rowindex + i);
         row.setHeightInPoints(25.0F);
         this.createBaseInfoCells(row, i, printList.get(i), processType);
         this.setProcessvalue(row, process, coordinateMap, processSize, processType);
      }
   }

   private void createBaseInfoCells(Row row, int index, ProductProcessDTO productProcessDTO, Integer processType) {
      Cell cell1 = row.createCell(0);
      Cell cell2 = row.createCell(1);
      Cell cell3 = row.createCell(2);
      cell1.setCellValue(index + 1);
      if (processType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         Cell cell4 = row.createCell(3);
         cell2.setCellValue(productProcessDTO.getName());
         cell3.setCellValue(productProcessDTO.getSerialNumber());
         cell4.setCellValue(productProcessDTO.getQuantity().intValue());
      } else if (processType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         cell2.setCellValue(productProcessDTO.getSerialNumber());
         cell3.setCellValue(productProcessDTO.getQuantity().intValue());
      }
   }

   public void setProcessvalue(Row row, List<ProductProcessQuantityDTO> processList, Map<Long, Integer> coordinateMap, Integer processSize, Integer processType) {
      Integer cellindex = 0;
      if (processType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         cellindex = 4;
      } else if (processType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         cellindex = 3;
      }

      for (int j = 0; j < processSize; j++) {
         Integer integer = cellindex;
         cellindex = cellindex + 1;
         Cell cell = row.createCell(integer);
         cell.setCellValue(" / ");
      }

      for (ProductProcessQuantityDTO quantityDTO : processList) {
         Integer integer = coordinateMap.get(quantityDTO.getId());
         if (integer != null) {
            Cell cell = row.createCell(integer);
            cell.setCellValue(quantityDTO.getQuantity() + " / " + quantityDTO.getInspectionQuantity());
         }
      }
   }

   private static void copyBorderStyle(Sheet sheet, CellRangeAddress mergedRegion) {
      int firstRow = mergedRegion.getFirstRow();
      int lastRow = mergedRegion.getLastRow();
      int firstColumn = mergedRegion.getFirstColumn();
      int lastColumn = mergedRegion.getLastColumn();

      for (int rowIndex = firstRow; rowIndex <= lastRow; rowIndex++) {
         Row row = sheet.getRow(rowIndex);
         if (row == null) {
            row = sheet.createRow(rowIndex);
         }

         for (int columnIndex = firstColumn; columnIndex <= lastColumn; columnIndex++) {
            Cell cell = row.getCell(columnIndex);
            if (cell == null) {
               cell = row.createCell(columnIndex);
            }

            CellStyle style = cell.getCellStyle();
            if (style == null) {
               style = sheet.getWorkbook().createCellStyle();
            }

            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            cell.setCellStyle(style);
         }
      }
   }

   @Override
   public PageVO<ProduceStatisticsDTO> produceStatistics(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      Long workshopId,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> userProjectIds = this.contractProjectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (userProjectIds.size() == 0) {
         return new PageVO<>();
      }

      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      MesBuildingProcess process = this.processService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, TaskTypeEnum.ARTIFACT.getType())
               .in(MesBuildingProcess::getName, "焊接")
         );
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProject> contractProjectList = this.contractProjectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(status != null, ContractProject::getStatus, status)
               .in(CollectionUtils.isNotEmpty(userProjectIds), ContractProject::getId, userProjectIds)
               .apply("project_type & 3")
         );
      if (CollectionUtils.isEmpty(contractProjectList)) {
         return new PageVO<>();
      }

      List<ProduceStatisticsDTO> summaryDTOList = contractProjectList.stream().map(e -> {
         ProjectDetailDO project = ProjectDetailDO.builder().id(e.getId()).shortName(e.getName()).name(e.getName()).serialNumber(e.getSerialNumber()).build();
         return ProduceStatisticsDTO.builder().project(project).build();
      }).collect(Collectors.toList());
      List<Long> projectIds = contractProjectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingTask> tasks = this.taskBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .in(MesBuildingTask::getProjectId, projectIds)
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               .eq(workshopId != null, MesBuildingTask::getWorkshopId, workshopId)
         );
      Map<Long, List<MesBuildingTask>> taskProjectMap = tasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getProjectId));
      List<Long> taskProjectIds = summaryDTOList.stream().map(e -> e.getProject().getId()).distinct().collect(Collectors.toList());
      Map<Long, QuantityAndWeightDetailDO> quantityAndWeightDetailDOMap = this.taskBiz
         .listTaskMeteByProject(taskProjectIds, startDate, endDate, workshopId)
         .stream()
         .collect(Collectors.toMap(QuantityAndWeightDetailDO::getProjectId, Function.identity()));
      Map<Long, List<ProduceStatisticsProcessDTO>> statisticsProcessDtoMap = this.baseService
         .listProjectProcessList(taskProjectIds, workshopId)
         .stream()
         .collect(Collectors.groupingBy(ProduceStatisticsProcessDTO::getProjectId));
      Map<Long, List<MesBuildingProductProcessLink>> productProcessLinkMap = this.productProcessLinkService
         .list((Wrapper<MesBuildingProductProcessLink>)new LambdaQueryWrapper<MesBuildingProductProcessLink>().eq(MesBuildingProductProcessLink::getBoolHistory, Boolean.FALSE))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductProcessLink::getProductProcessId));
      List<MesBuildingProcess> processes = this.processService
         .list((Wrapper<MesBuildingProcess>)new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()));
      Map<String, MesBuildingProductProcess> productProcessMap = this.productProcessService
         .list(
            (Wrapper<MesBuildingProductProcess>)(new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE))
               .eq(MesBuildingProductProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getProductionLineId() + "-" + e.getTypeId(), Function.identity()));
      Map<Long, OutboundDetailBasicDTO> outboundDetailBasicDTOMap = this.outboundService
         .getMeteByProject(basicClass, taskProjectIds, null, null)
         .stream()
         .collect(Collectors.toMap(OutboundDetailBasicDTO::getProjectId, Function.identity()));
      Map<Long, OutboundDetailBasicDTO> mouthOutboundDetailBasicDTOMap = this.outboundService
         .getMeteByProject(basicClass, taskProjectIds, startDate, endDate)
         .stream()
         .collect(Collectors.toMap(OutboundDetailBasicDTO::getProjectId, Function.identity()));
      Map<Long, QuantityAndWeightDetailDO> projectQuantityAndWeightDetailDOMap = this.warehouseSummaryService
         .getMeteSummaryByProjectIds(taskProjectIds, startDate, endDate, workshopId)
         .stream()
         .collect(Collectors.toMap(QuantityAndWeightDetailDO::getProjectId, Function.identity()));
      summaryDTOList.forEach(
         e -> {
            QuantityAndWeightDetailDO taskMete = quantityAndWeightDetailDOMap.get(e.getProject().getId());
            e.setTaskQuantity(taskMete == null ? 0 : taskMete.getQuantity());
            e.setTaskNetWeight(taskMete == null ? BigDecimal.ZERO : taskMete.getNetWeight());
            e.setTaskGrossWeight(taskMete == null ? BigDecimal.ZERO : taskMete.getGrossWeight());
            List<ProduceStatisticsProcessDTO> processDTOList = statisticsProcessDtoMap.get(e.getProject().getId());
            List<MesBuildingTask> taskList = taskProjectMap.get(e.getProject().getId());
            if (CollectionUtils.isNotEmpty(taskList)) {
               Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId(), (old, val) -> old));
               List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
               List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
               List<Long> singleArtifactIds = new ArrayList<>();

               for (TechArtifact techArtifact : techArtifacts.stream()
                  .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
                  .collect(Collectors.toList())) {
                  Long productionLineId = productMap.get(techArtifact.getId());
                  if (!this.utilsBiz.getBoolSinglePartArtifactPaintV2(techArtifact, productProcessMap, productProcessLinkMap, processes, productionLineId)) {
                     singleArtifactIds.add(techArtifact.getId());
                  }
               }

               List<Long> allPartArtifactIds = techArtifacts.stream()
                  .filter(TechArtifact::getBoolAllPartSendDirectly)
                  .map(TechArtifact::getId)
                  .collect(Collectors.toList());
               singleArtifactIds.addAll(allPartArtifactIds);
               if (singleArtifactIds.size() != 0 && process != null) {
                  QuantityAndWeightDetailDO quantityAndWeightDetailDO = this.taskBiz
                     .unCompletTaskMeteByProject(e.getProject().getId(), null, null, singleArtifactIds, workshopId);
                  ProduceStatisticsProcessDTO build = ProduceStatisticsProcessDTO.builder()
                     .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
                     .id(process.getId())
                     .unQuantity(quantityAndWeightDetailDO.getQuantity())
                     .unNetWeight(quantityAndWeightDetailDO.getNetWeight())
                     .unGrossWeight(quantityAndWeightDetailDO.getGrossWeight())
                     .build();
                  processDTOList.add(build);
               }
            }

            e.setProcessDTOList(processDTOList);
            e.setUnit("kg");
            BigDecimal rawTotalNetWeight = BigDecimal.ZERO;
            OutboundDetailBasicDTO outboundDetailBasicDTO = outboundDetailBasicDTOMap.get(e.getProject().getId());
            if (outboundDetailBasicDTO != null) {
               rawTotalNetWeight = outboundDetailBasicDTO.getMete();
            }

            e.setRawTotalNetWeight(rawTotalNetWeight);
            e.setRawTotalGrossWeight(rawTotalNetWeight);
            OutboundDetailBasicDTO mouthOutboundDetailBasicDTO = mouthOutboundDetailBasicDTOMap.get(e.getProject().getId());
            BigDecimal rawNetWeight = BigDecimal.ZERO;
            if (mouthOutboundDetailBasicDTO != null) {
               rawNetWeight = mouthOutboundDetailBasicDTO.getMete();
            }

            e.setRawNetWeight(rawNetWeight);
            e.setRawGrossWeight(rawNetWeight);
            QuantityAndWeightDetailDO finishMete = projectQuantityAndWeightDetailDOMap.get(e.getProject().getId());
            e.setFinishNetWeight(BigDecimal.ZERO);
            e.setFinishGrossWeight(BigDecimal.ZERO);
            if (finishMete != null) {
               e.setFinishNetWeight(finishMete.getNetWeight());
               e.setFinishGrossWeight(finishMete.getGrossWeight());
            }

            BigDecimal producingNetWeight = BigDecimal.ZERO;
            BigDecimal producingGrossWeight = BigDecimal.ZERO;
            if (CollectionUtils.isNotEmpty(processDTOList)) {
               producingNetWeight = processDTOList.stream()
                  .filter(t -> t.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()))
                  .map(ProduceStatisticsProcessDTO::getUnNetWeight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               producingGrossWeight = processDTOList.stream()
                  .filter(t -> t.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()))
                  .map(ProduceStatisticsProcessDTO::getUnGrossWeight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            e.setTotalNetWeight(finishMete == null ? producingNetWeight : finishMete.getNetWeight().add(producingNetWeight));
            e.setTotalGrossWeight(finishMete == null ? producingGrossWeight : finishMete.getGrossWeight().add(producingGrossWeight));
            BigDecimal lossNetWeight = rawNetWeight.compareTo(BigDecimal.ZERO) == 0
               ? BigDecimal.ZERO
               : rawNetWeight.subtract(finishMete == null ? BigDecimal.ZERO : finishMete.getNetWeight());
            e.setLossNetWeight(lossNetWeight);
            BigDecimal lossGrossWeight = rawNetWeight.compareTo(BigDecimal.ZERO) == 0
               ? BigDecimal.ZERO
               : rawNetWeight.subtract(finishMete == null ? BigDecimal.ZERO : finishMete.getGrossWeight());
            e.setLossGrossWeight(lossGrossWeight);
            e.setLossRate(
               (rawNetWeight.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : lossNetWeight.divide(rawNetWeight, 2, RoundingMode.HALF_UP))
                  .multiply(new BigDecimal(100))
            );
         }
      );
      summaryDTOList = summaryDTOList.stream()
         .sorted(Comparator.comparing(s -> s.getProject().getId(), Comparator.reverseOrder()))
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(summaryDTOList, contractProjectList));
   }

   @Override
   public List<ProduceStatisticsDTO> produceStatisticsList(LocalDateTime startDate, LocalDateTime endDate, Integer status, Long workshopId) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      List<ProduceStatisticsDTO> summaryDTOList = this.contractProjectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(status != null, ContractProject::getStatus, status)
               .in(ContractProject::getProjectType, ProjectTypeEnum.MES.getType(), ProjectTypeEnum.BRIDGE.getType())
               .in(CollectionUtils.isNotEmpty(projectIds), ContractProject::getId, projectIds)
         )
         .stream()
         .map(e -> {
            ProjectDetailDO project = ProjectDetailDO.builder()
               .id(e.getId())
               .shortName(e.getName())
               .name(e.getName())
               .serialNumber(e.getSerialNumber())
               .build();
            return ProduceStatisticsDTO.builder().project(project).build();
         })
         .collect(Collectors.toList());
      summaryDTOList.forEach(
         e -> {
            QuantityAndWeightDetailDO taskMete = this.taskBiz.taskMeteByProject(e.getProject().getId(), startDate, endDate, workshopId);
            e.setTaskQuantity(taskMete.getQuantity());
            e.setTaskNetWeight(taskMete.getNetWeight());
            e.setTaskGrossWeight(taskMete.getGrossWeight());
            List<ProduceStatisticsProcessDTO> processDTOList = this.baseService.projectProcessList(e.getProject().getId(), workshopId);
            List<MesBuildingTask> taskList = this.taskBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingTask.class)
                     .eq(MesBuildingTask::getProjectId, e.getProject().getId())
                     .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                     .eq(workshopId != null, MesBuildingTask::getWorkshopId, workshopId)
               );
            Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
            List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
            if (artifactIds.size() > 0) {
               List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(artifactIds);
               List<Long> singleArtifactIds = new ArrayList<>();

               for (TechArtifact techArtifact : techArtifacts.stream()
                  .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
                  .collect(Collectors.toList())) {
                  if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
                     singleArtifactIds.add(techArtifact.getId());
                  }
               }

               List<Long> allPartArtifactIds = techArtifacts.stream()
                  .filter(TechArtifact::getBoolAllPartSendDirectly)
                  .map(TechArtifact::getId)
                  .collect(Collectors.toList());
               singleArtifactIds.addAll(allPartArtifactIds);
               if (singleArtifactIds.size() != 0) {
                  MesBuildingProcess process = this.processService
                     .getOne(
                        Wrappers.lambdaQuery(MesBuildingProcess.class)
                           .eq(MesBuildingProcess::getProductType, TaskTypeEnum.ARTIFACT.getType())
                           .in(MesBuildingProcess::getName, "制造")
                     );
                  if (process != null) {
                     QuantityAndWeightDetailDO quantityAndWeightDetailDO = this.taskBiz
                        .unCompletTaskMeteByProject(e.getProject().getId(), null, null, singleArtifactIds, workshopId);
                     ProduceStatisticsProcessDTO build = ProduceStatisticsProcessDTO.builder()
                        .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
                        .id(process.getId())
                        .unQuantity(quantityAndWeightDetailDO.getQuantity())
                        .unNetWeight(quantityAndWeightDetailDO.getNetWeight())
                        .unGrossWeight(quantityAndWeightDetailDO.getGrossWeight())
                        .build();
                     processDTOList.add(build);
                  }
               }
            }

            e.setProcessDTOList(processDTOList);
            e.setUnit("kg");
            BigDecimal rawTotalNetWeight = this.outboundService
               .getDetailByCondition(basicClass, e.getProject().getId(), null, null)
               .stream()
               .map(OutboundDetailDTO::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(new BigDecimal(1000));
            e.setRawTotalNetWeight(rawTotalNetWeight);
            e.setRawTotalGrossWeight(rawTotalNetWeight);
            BigDecimal rawNetWeight = this.outboundService
               .getDetailByCondition(basicClass, e.getProject().getId(), startDate, endDate)
               .stream()
               .map(OutboundDetailDTO::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(new BigDecimal(1000));
            e.setRawNetWeight(rawNetWeight);
            e.setRawGrossWeight(rawNetWeight);
            QuantityAndWeightDetailDO finishMete = this.warehouseSummaryService
               .getMeteSummaryByCondition(e.getProject().getId(), startDate, endDate, workshopId);
            e.setFinishNetWeight(finishMete.getNetWeight());
            e.setFinishGrossWeight(finishMete.getGrossWeight());
            BigDecimal producingNetWeight = processDTOList.stream()
               .filter(t -> t.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()))
               .map(ProduceStatisticsProcessDTO::getUnNetWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal producingGrossWeight = processDTOList.stream()
               .filter(t -> t.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()))
               .map(ProduceStatisticsProcessDTO::getUnGrossWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            e.setTotalNetWeight(finishMete.getNetWeight().add(producingNetWeight));
            e.setTotalGrossWeight(finishMete.getGrossWeight().add(producingGrossWeight));
            BigDecimal lossNetWeight = rawNetWeight.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : rawNetWeight.subtract(finishMete.getNetWeight());
            e.setLossNetWeight(lossNetWeight);
            BigDecimal lossGrossWeight = rawNetWeight.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : rawNetWeight.subtract(finishMete.getGrossWeight());
            e.setLossGrossWeight(lossGrossWeight);
            e.setLossRate(
               (rawNetWeight.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : lossNetWeight.divide(rawNetWeight, 2, RoundingMode.HALF_UP))
                  .multiply(new BigDecimal(100))
            );
         }
      );
      return summaryDTOList.stream().sorted(Comparator.comparing(s -> s.getProject().getId(), Comparator.reverseOrder())).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> produceStatisticsPrint(LocalDateTime startDate, LocalDateTime endDate, Integer status, Long workshopId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(this.produceStatisticsList(startDate, endDate, status, workshopId).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<MesBuildingArtifactTypeDTO> getProductTypeList(Long areaId, Long areaBatchId, Long factoryId, Integer taskTypeEnum) {
      return this.baseService
         .getProductTypeList(areaId, areaBatchId, factoryId, taskTypeEnum)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTypeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingProductionTaskDTO> produceStatisticsFinishPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.produceStatisticsFinishList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId)
      );
   }

   @Override
   public List<MesBuildingProductionTaskDTO> produceStatisticsFinishList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      return this.warehouseSummaryService.produceStatisticsFinishList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> produceStatisticsFinishPrint(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(
         this.produceStatisticsFinishList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<List<TaskTrackingProcessDTO>> taskDullMachine(Long topTaskOrderId, Long workshopId, Long productionLineId, Integer productType) {
      List<List<TaskTrackingProcessDTO>> lists = this.taskMachinePartProcess(topTaskOrderId, null, null, null, workshopId, productionLineId, productType);

      for (List<TaskTrackingProcessDTO> list : lists) {
         List<TaskTrackingProcessDTO> collect = list.stream().filter(e -> e.getStatus().equals(0) && e.getUnQuantity() > 0).collect(Collectors.toList());
         lists.add(collect);
      }

      return lists;
   }

   @Override
   public ProgressProcessDTO taskDullArtifact(Long topTaskOrderId, Long workshopId, Long productionLineId) {
      ProgressProcessDTO processDTO = this.taskArtifactProcess(topTaskOrderId, null, null, null, workshopId, productionLineId);
      if (processDTO.getArtifactList() != null) {
         List<List<TaskTrackingProcessDTO>> dto = new ArrayList<>();

         for (List<TaskTrackingProcessDTO> dtoList : processDTO.getArtifactList()) {
            List<TaskTrackingProcessDTO> collect = dtoList.stream().filter(e -> e.getStatus().equals(0) && e.getUnQuantity() > 0).collect(Collectors.toList());
            dto.add(collect);
            processDTO.setArtifactList(dto);
         }
      }

      if (processDTO.getAssembleList() != null) {
         List<List<TaskTrackingProcessDTO>> dto = new ArrayList<>();

         for (List<TaskTrackingProcessDTO> dtoList : processDTO.getAssembleList()) {
            List<TaskTrackingProcessDTO> collect = dtoList.stream().filter(e -> e.getStatus().equals(0) && e.getUnQuantity() > 0).collect(Collectors.toList());
            dto.add(collect);
            processDTO.setAssembleList(dto);
         }
      }

      return processDTO;
   }

   @Override
   public List<TaskProcessProductDTO> taskDullProductProcessDetail(Long processId, Integer taskType, Long orderId, Long groupId) {
      return this.taskProcessProduct(processId, taskType, orderId, groupId, null, null, null, null, null)
         .stream()
         .filter(e -> e.getStatus().equals(0) && e.getUnQuantity() > 0)
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<TaskProcessProductDTO> taskDullProductProcessDetailPage(
      Long processId, Integer taskType, Long orderId, Long groupId, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.taskDullProductProcessDetail(processId, taskType, orderId, groupId));
   }

   @Override
   public List<MesBuildingProductionTaskDTO> computeBoolCanRevokeOnecode(
      List<MesBuildingProductionTaskDTO> dtoList, MesBuildingTaskOrder taskOrder, Boolean boolAllCheck
   ) {
      if (CollectionUtils.isEmpty(dtoList)) {
         return dtoList;
      }

      List<Long> taskIds = dtoList.stream().map(MesBuildingProductionTaskDTO::getTaskId).distinct().collect(Collectors.toList());
      List<MesBuildingTaskProcess> taskProcessList = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).in(MesBuildingTaskProcess::getTaskId, taskIds));
      List<Long> assistTaskIds = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(taskProcessList)) {
         List<Long> taskProcessIds = taskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList());
         List<MesBuildingAssistNumberDetail> assistNumbers = this.assistNumberDetailService
            .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).in(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessIds));
         List<Long> assistProcessIds = assistNumbers.stream().map(MesBuildingAssistNumberDetail::getTaskProcessId).distinct().collect(Collectors.toList());
         assistTaskIds = taskProcessList.stream()
            .filter(s -> assistProcessIds.contains(s.getId()))
            .map(MesBuildingTaskProcess::getTaskId)
            .distinct()
            .collect(Collectors.toList());
      }

      List<MesBuildingTask> tasks = this.taskBiz.listByIds(taskIds);
      Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      List<MesBuildingTaskNumberLink> taskNumberLinks = this.numberLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class).in(MesBuildingTaskNumberLink::getArtifactTaskId, taskIds));
      Map<Long, List<MesBuildingTaskNumberLink>> artTaskNumbers = taskNumberLinks.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
      List<Long> assIds = taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
      List<TechAssemble> techAssembles = this.assembleService.listByIds(assIds);
      Map<Long, TechAssemble> assembleMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<NumberInfoDTO> numberInfoDTOS = taskNumberLinks.stream()
         .map(e -> NumberInfoDTO.builder().productId(e.getArtifactId()).number(e.getArtifactNumber()).build())
         .collect(Collectors.toList());
      List<MesBuildingAssembleExtTaskCargoDTO> allResult = new ArrayList<>();
      if (!CollectionUtils.isEmpty(numberInfoDTOS)) {
         int total = numberInfoDTOS.size();

         for (int i = 0; i < total; i += 50) {
            int end = Math.min(i + 50, total);
            List<NumberInfoDTO> subBatch = numberInfoDTOS.subList(i, end);
            List<MesBuildingAssembleExtTaskCargoDTO> batchData = this.numberLinkService.listAssembleExtWarehouseStatusList(subBatch);
            allResult.addAll(batchData);
         }
      }

      Map<String, List<MesBuildingAssembleExtTaskCargoDTO>> assembleExtTaskCargoDTOMap = allResult.stream()
         .collect(Collectors.groupingBy(e -> e.getAssembleId() + "_" + e.getAssembleNumber()));
      List<Long> artIds = dtoList.stream().map(MesBuildingProductionTaskDTO::getProductId).distinct().collect(Collectors.toList());
      dtoList.forEach(s -> s.setBoolCanRevoke(Boolean.TRUE));

      for (MesBuildingProductionTaskDTO taskDTO : dtoList) {
         List<MesBuildingTaskNumberLink> links = artTaskNumbers.get(taskDTO.getTaskId());
         boolean canRevoke = !assistTaskIds.contains(taskDTO.getTaskId());
         canRevoke &= links.stream().noneMatch(s -> s.getBoolArtifactInproduce() || s.getBoolArtifactComplete());
         canRevoke &= links.stream().noneMatch(MesBuildingTaskNumberLink::getBoolSecondUse);

         for (MesBuildingTaskNumberLink link : links) {
            TechAssemble techAssemble = assembleMap.get(link.getAssembleId());
            if (techAssemble != null) {
               if (techAssemble.getBoolProcess()) {
                  canRevoke &= !link.getBoolAssembleInproduce() && !link.getBoolAssembleComplete();
               }

               List<MesBuildingAssembleExtTaskCargoDTO> dtos = assembleExtTaskCargoDTOMap.get(link.getAssembleId() + "_" + link.getAssembleNumber());
               if (CollectionUtils.isNotEmpty(dtos)) {
                  canRevoke &= dtos.stream().allMatch(s -> s.getStatus() == 1);
               }
            }
         }

         taskDTO.setBoolCanRevoke(canRevoke);
      }

      List<TechArtifactMachinePartLink> artPartLinks = this.techArtifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artIds));
      Map<Long, List<TechArtifactMachinePartLink>> artPartLinkMap = artPartLinks.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      List<Long> partIds = artPartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(partIds)) {
         List<TechMachinePart> partList = this.machinePartService.listByIds(partIds);
         List<Long> sendPartIds = partList.stream()
            .filter(TechMachinePart::getBoolSendDirectly)
            .filter(s -> s.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()))
            .map(TechMachinePart::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(sendPartIds)) {
            Map<Long, TechMachinePart> partMap = partList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .in(MesBuildingWarehouseSummary::getProductId, partIds)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
               );
            Map<String, Integer> cargoQuantiyiMap = warehouseSummaryList.stream()
               .collect(
                  Collectors.toMap(
                     s -> s.getWorkshopId() + "_" + s.getProductId(), s -> s.getPackageQuantity().intValue() + s.getCargoQuantity().intValue(), Integer::sum
                  )
               );
            Map<String, Integer> sendWarehouseMap = new HashMap<>();
            List<TechArtifactMachinePartLink> allSendLinks = this.techArtifactMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, sendPartIds));
            List<Long> allSenLinkArtIds = allSendLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).distinct().collect(Collectors.toList());

            for (MesBuildingTask task : this.taskBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingTask.class)
                     .in(MesBuildingTask::getProductId, allSenLinkArtIds)
                     .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               )) {
               Long shopId = task.getWorkshopId();

               for (TechArtifactMachinePartLink link : artPartLinkMap.getOrDefault(task.getProductId(), new ArrayList<>())) {
                  TechMachinePart part = partMap.get(link.getMachinePartId());
                  if (part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()) || part.getBoolSendDirectly()) {
                     String reduceKey = shopId + "_" + link.getMachinePartId();
                     Integer reduceQuantity = sendWarehouseMap.getOrDefault(reduceKey, 0);
                     reduceQuantity = reduceQuantity + task.getTaskQuantity() * link.getQuantity();
                     sendWarehouseMap.put(reduceKey, reduceQuantity);
                  }
               }
            }

            Map<String, Integer> partChangeReduceMap = new HashMap<>();

            for (MesBuildingProductionTaskDTO taskDTO : dtoList) {
               MesBuildingTask task = taskMap.get(taskDTO.getTaskId());
               List<TechArtifactMachinePartLink> links = artPartLinkMap.get(taskDTO.getProductId());
               Long shopId = task.getWorkshopId();
               if (CollectionUtils.isNotEmpty(links)) {
                  for (TechArtifactMachinePartLink link : links) {
                     TechMachinePart part = partMap.get(link.getMachinePartId());
                     if (part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()) && part.getBoolSendDirectly()) {
                        String key = shopId + "_" + link.getMachinePartId();
                        Integer canWarehouseQuantity = sendWarehouseMap.get(key);
                        Integer cargoPackageQuantity = cargoQuantiyiMap.getOrDefault(key, 0);
                        int taskReduceQuantity = taskDTO.getQuantity() * link.getQuantity();
                        if (canWarehouseQuantity < cargoPackageQuantity + taskReduceQuantity) {
                           taskDTO.setBoolCanRevoke(Boolean.FALSE);
                        }

                        Integer reduceQuantity = partChangeReduceMap.getOrDefault(key, 0);
                        reduceQuantity = reduceQuantity + taskReduceQuantity;
                        partChangeReduceMap.put(key, reduceQuantity);
                     }
                  }
               }
            }

            if (boolAllCheck) {
               for (String reduceKey : partChangeReduceMap.keySet()) {
                  Integer needReduceQuantity = partChangeReduceMap.get(reduceKey);
                  Integer canWareQuantity = sendWarehouseMap.get(reduceKey);
                  Preconditions.checkArgument(canWareQuantity != null, "操作失败,请联系管理员!!!");
                  Integer cargoPackageQuantity = cargoQuantiyiMap.getOrDefault(reduceKey, 0);
                  Preconditions.checkArgument(canWareQuantity - cargoPackageQuantity >= needReduceQuantity, "操作失败!!!车间下直发零件库存数量不足!!!");
               }
            }
         }
      }

      return dtoList;
   }

   @Override
   public List<MesBuildingAssistProductFromArtifactDTO> getAssembleAssistListByComponent(
      Long taskOrderId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      List<Long> taskProcessIdList,
      Integer assistEnum,
      String artifactSerialNumber,
      String artifactSpecification
   ) {
      List<MesBuildingAssistProductDTO> processList = this.baseService
         .productProcessList(taskOrderId, areaId, processId, taskTypeEnum, serialNumber, specification, taskProcessIdList, assistEnum);
      if (CollectionUtils.isEmpty(processList)) {
         return new ArrayList<>();
      }

      List<MesBuildingAssistProductFromArtifactDTO> artifactDTOS = new ArrayList<>();
      List<Long> taskProcessIds = processList.stream().map(MesBuildingAssistProductDTO::getId).collect(Collectors.toList());
      List<Long> taskIds = processList.stream().map(MesBuildingAssistProductDTO::getTaskId).collect(Collectors.toList());
      Map<Long, MesBuildingAssistProductDTO> assistProductDTOMap = processList.stream()
         .collect(Collectors.toMap(MesBuildingAssistProductDTO::getTaskId, Function.identity()));
      Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().apply(" task_type_enum & {0} ", taskTypeEnum))
               .in(MesBuildingProduceTeamReport::getTaskProcessId, taskProcessIds)
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskId));
      List<MesBuildingTaskNumberLink> allLinks = this.numberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .in((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0, MesBuildingTaskNumberLink::getAssembleTaskId, taskIds)
         );
      List<MesBuildingTaskNumberLink> links = new ArrayList<>();

      for (MesBuildingTaskNumberLink link : allLinks) {
         if ((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0) {
            link.setAssembleTaskProcessId(assistProductDTOMap.get(link.getAssembleTaskId()).getId());
            List<MesBuildingProduceTeamReport> reports = produceTeamReportMap.get(link.getAssembleTaskId());
            if (CollectionUtils.isNotEmpty(reports)) {
               List<Integer> numbers = reports.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
               if (numbers.contains(link.getAssembleNumber())) {
                  continue;
               }
            }
         }

         links.add(link);
      }

      Map<Long, List<MesBuildingTaskNumberLink>> artifactNumberLinkMap = allLinks.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(allLinks.stream().map(MesBuildingTaskNumberLink::getArtifactId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, Set<Integer>> taskProcessNumberMap = links.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingTaskNumberLink::getAssembleTaskProcessId, Collectors.mapping(MesBuildingTaskNumberLink::getAssembleNumber, Collectors.toSet())
            )
         );
      Map<Long, List<MesBuildingAssist>> assistMap = new HashMap<>();
      Map<Long, List<MesBuildingAssistNumberDetail>> assistNumberMap = new HashMap<>();
      Map<Long, ProductLineDetailDTO> groupMap = new HashMap<>();
      List<MesBuildingAssist> assists = this.mesBuildingAssistService
         .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, taskProcessIds));
      if (CollectionUtils.isNotEmpty(assists)) {
         List<MesBuildingAssistNumberDetail> assistDetails = this.assistNumberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .in(MesBuildingAssistNumberDetail::getAssistId, assists.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()))
            );
         assistNumberMap = assistDetails.stream().collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getAssistId));
         assistMap = assists.stream().collect(Collectors.groupingBy(MesBuildingAssist::getTaskProcessId));
         List<Long> assistGroupIds = assists.stream().map(MesBuildingAssist::getProductionLineId).collect(Collectors.toList());
         groupMap = this.productionLineService
            .getTreeByLineIds(assistGroupIds)
            .stream()
            .collect(Collectors.toMap(ProductLineDetailDTO::getProductionLineId, Function.identity()));
      }

      Map<Long, MesBuildingAssistProductDTO> mesBuildingAssistProductDTOMap = processList.stream()
         .collect(Collectors.toMap(MesBuildingAssistProductDTO::getProductId, Function.identity()));
      Map<Long, List<MesBuildingAssist>> finalAssistMap = assistMap;
      Map<Long, ProductLineDetailDTO> finalGroupMap = groupMap;
      Map<Long, List<MesBuildingAssistNumberDetail>> finalAssistNumberMap = assistNumberMap;
      artifactNumberLinkMap.forEach(
         (artifactTaskId, linkList) -> {
            TechArtifact artifact = artifactMap.get(linkList.get(0).getArtifactId());
            if (!StringUtils.isNotBlank(artifactSerialNumber) || artifact.getSerialNumber().contains(artifactSerialNumber)) {
               if (!StringUtils.isNotBlank(artifactSpecification) || artifact.getSpecification().contains(artifactSpecification)) {
                  List<Long> collect = linkList.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
                  List<MesBuildingAssistProductDTO> assistProductDTOList = cn.hutool.core.bean.BeanUtil.copyToList(
                     collect.stream().map(mesBuildingAssistProductDTOMap::get).collect(Collectors.toList()), MesBuildingAssistProductDTO.class
                  );
                  Map<Long, List<MesBuildingTaskNumberLink>> artifactAssembleTaskNumberLinkMap = linkList.stream()
                     .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));

                  for (MesBuildingAssistProductDTO dto : assistProductDTOList) {
                     List<Integer> assembleNumbers = artifactAssembleTaskNumberLinkMap.get(dto.getProductId())
                        .stream()
                        .map(MesBuildingTaskNumberLink::getAssembleNumber)
                        .distinct()
                        .collect(Collectors.toList());
                     QuantityAndWeightDetailDO totalTaskMete = dto.getTotalTaskMete();
                     totalTaskMete.setNetWeight(
                        totalTaskMete.getNetWeight()
                           .multiply(
                              BigDecimal.valueOf(assembleNumbers.size())
                                 .divide(BigDecimal.valueOf(totalTaskMete.getQuantity().intValue()), 2, RoundingMode.HALF_UP)
                           )
                     );
                     totalTaskMete.setQuantity(assembleNumbers.size());
                     dto.setTotalTaskMete(totalTaskMete);
                     dto.setArtifactTaskId(artifactTaskId);
                     Set<Integer> allNumbers = taskProcessNumberMap.get(dto.getId());
                     List<MesBuildingAssistDetailDTO> assistDetailDTOS = new ArrayList<>();
                     List<MesBuildingAssist> mesBuildingAssists = finalAssistMap.get(dto.getId());
                     if (CollectionUtils.isNotEmpty(allNumbers)) {
                        allNumbers = allNumbers.stream().filter(assembleNumbers::contains).collect(Collectors.toSet());
                     }

                     if (CollectionUtils.isNotEmpty(mesBuildingAssists)) {
                        for (MesBuildingAssist mesBuildingAssist : mesBuildingAssists) {
                           ProductLineDetailDTO groupDetailDTO = finalGroupMap.get(mesBuildingAssist.getProductionLineId());
                           List<MesBuildingNumberReplaceDTO> assNumbers = finalAssistNumberMap.get(mesBuildingAssist.getId())
                              .stream()
                              .map(s -> MesBuildingNumberReplaceDTO.builder().number(s.getNumber()).boolReplace(!s.getBoolFinishEnum()).build())
                              .collect(Collectors.toList());
                           List<MesBuildingNumberReplaceDTO> numberReplaceDTOS = assNumbers.stream()
                              .filter(e -> assembleNumbers.contains(e.getNumber()))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isNotEmpty(numberReplaceDTOS)) {
                              List<Integer> assNumberList = numberReplaceDTOS.stream().map(MesBuildingNumberReplaceDTO::getNumber).collect(Collectors.toList());
                              if (CollectionUtils.isNotEmpty(allNumbers)) {
                                 assNumberList.forEach(allNumbers::remove);
                              }

                              MesBuildingAssistDetailDTO build = MesBuildingAssistDetailDTO.builder()
                                 .assistId(mesBuildingAssist.getId())
                                 .numbers(assNumbers)
                                 .factoryId(groupDetailDTO.getFactoryId())
                                 .workshop(WorkshopDetailDO.builder().id(groupDetailDTO.getWorkshopId()).name(groupDetailDTO.getWorkshopName()).build())
                                 .productionLine(
                                    ProductionLineDetailDO.builder()
                                       .id(groupDetailDTO.getProductionLineId())
                                       .name(groupDetailDTO.getProductionLineName())
                                       .build()
                                 )
                                 .processId(mesBuildingAssist.getProcessId())
                                 .quantity(assNumbers.size())
                                 .boolCanDelete(numberReplaceDTOS.stream().allMatch(MesBuildingNumberReplaceDTO::getBoolReplace))
                                 .boolUpdateGroup(numberReplaceDTOS.stream().allMatch(MesBuildingNumberReplaceDTO::getBoolReplace))
                                 .produceQuantity((int)numberReplaceDTOS.stream().filter(e -> !e.getBoolReplace()).count())
                                 .build();
                              assistDetailDTOS.add(build);
                           }
                        }
                     }

                     dto.setMesBuildingAssistDetailDTOS(assistDetailDTOS);
                     dto.setBoolOperations(CollectionUtils.isNotEmpty(allNumbers));
                     if (CollectionUtils.isNotEmpty(allNumbers)) {
                        dto.setNumberList(new ArrayList<>(allNumbers));
                     }

                     dto.setBoolOnecode(Boolean.FALSE);
                     dto.setTotalAssistQuantity(assistDetailDTOS.stream().mapToInt(MesBuildingAssistDetailDTO::getQuantity).sum());
                     QuantityAndWeightDetailDO totalCanAssistMete = dto.getTotalCanAssistMete();
                     totalCanAssistMete.setQuantity(CollectionUtils.isEmpty(allNumbers) ? 0 : allNumbers.size());
                  }

                  if (AssistEnum.CAN_OPERATED.getType().equals(assistEnum)) {
                     assistProductDTOList = assistProductDTOList.stream()
                        .filter(e -> CollectionUtils.isNotEmpty(e.getNumberList()))
                        .collect(Collectors.toList());
                  }

                  if (CollectionUtils.isNotEmpty(assistProductDTOList)) {
                     MesBuildingAssistProductFromArtifactDTO build = MesBuildingAssistProductFromArtifactDTO.builder()
                        .artifactTaskId(artifactTaskId)
                        .artifactProductId(artifact.getId())
                        .length(artifact.getLength())
                        .serialNumber(artifact.getSerialNumber())
                        .specification(artifact.getSpecification())
                        .area(assistProductDTOList.get(0).getArea())
                        .assistProductDTOList(assistProductDTOList)
                        .taskTypeEnum(ProductTypeEnum.ARTIFACT.getType())
                        .totalAssistQuantity(assistProductDTOList.stream().mapToInt(MesBuildingAssistProductDTO::getTotalAssistQuantity).sum())
                        .build();
                     List<QuantityAndWeightDetailDO> quantityAndWeightDetailDOS = assistProductDTOList.stream()
                        .map(MesBuildingAssistProductDTO::getTotalCanAssistMete)
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(quantityAndWeightDetailDOS)) {
                        build.setTotalCanAssistMete(
                           QuantityAndWeightDetailDO.builder()
                              .quantity(quantityAndWeightDetailDOS.stream().mapToInt(QuantityAndWeightDetailDO::getQuantity).sum())
                              .build()
                        );
                     }

                     List<QuantityAndWeightDetailDO> totalCompleteMeteList = assistProductDTOList.stream()
                        .map(MesBuildingAssistProductDTO::getTotalCompleteMete)
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(totalCompleteMeteList)) {
                        build.setTotalCompleteMete(
                           QuantityAndWeightDetailDO.builder()
                              .quantity(totalCompleteMeteList.stream().mapToInt(QuantityAndWeightDetailDO::getQuantity).sum())
                              .netWeight(totalCompleteMeteList.stream().map(QuantityAndWeightDetailDO::getNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                              .build()
                        );
                     }

                     List<QuantityAndWeightDetailDO> totalTaskMeteList = assistProductDTOList.stream()
                        .map(MesBuildingAssistProductDTO::getTotalTaskMete)
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(totalTaskMeteList)) {
                        build.setTotalTaskMete(
                           QuantityAndWeightDetailDO.builder()
                              .quantity(totalTaskMeteList.stream().mapToInt(QuantityAndWeightDetailDO::getQuantity).sum())
                              .netWeight(totalTaskMeteList.stream().map(QuantityAndWeightDetailDO::getNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                              .build()
                        );
                     }

                     artifactDTOS.add(build);
                  }
               }
            }
         }
      );
      return artifactDTOS;
   }

   @Override
   public List<MesBuildingWIPStatisticsDTO> findWipStatisticsList(MesBuildingWIPStatisticsVO query) {
      return this.baseService.findWipStatisticsList(query);
   }

   @Override
   public List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query) {
      return this.baseService.findWipStatisticsProcessList(query);
   }

   @Override
   public List<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query) {
      return this.baseService.findWipStatisticsDetail(query);
   }
}
