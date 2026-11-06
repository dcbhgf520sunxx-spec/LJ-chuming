package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingFinishProductTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CuttingReportMethodEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessPartDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPSemiAutoCutTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.SemiAutoCutPartDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingCutConfigService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartNoProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceTeamReportMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingFinishProductTaskBizImpl implements MesBuildingFinishProductTaskBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProduceTeamReportMapper mesBuildingProduceTeamReportMapper;
   @Autowired
   private MesBuildingMachinePartSchedulingService mesBuildingMachinePartSchedulingService;
   @Autowired
   private MesBuildingNestCutPlatePartService mesBuildingNestCutPlatePartService;
   @Autowired
   private TechMachinePartService techMachinePartService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Autowired
   private MesBuildingNestCutPlateService mesBuildingNestCutPlateService;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private MesBuildingCutConfigService mesBuildingCutConfigService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private ConfigService configService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private MesBuildingMachinePartNoProcessService mesBuildingMachinePartNoProcessService;

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .filter(projectId == null ? id -> true : id -> id.equals(projectId))
         .collect(Collectors.toList());
      if (projectIds.isEmpty()) {
         return new PageVO<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         List<AppTaskOrderSummaryDO> appTaskOrderSummaryDOS = this.mesBuildingTaskProcessService
            .selectTaskOrderIdListNoGroupFinishProduct(
               teamIds, projectId, projectIds, monomerId, areaId, null, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
            );
         if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDOS)) {
            appTaskOrderSummaryDOS.forEach(e -> {
               MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(e.getCutType());
               e.setCutTypeName(mesBuildingProcess.getName());
            });
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(型)"))
               .collect(Collectors.toList());
         }

         List<AppTaskOrderSummaryDO> machinePartNoProcessResult = this.mesBuildingMachinePartNoProcessService.getMachinePartNoProcessResult(teamIds);
         appTaskOrderSummaryDOS.addAll(machinePartNoProcessResult);
         MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
         if (inventoryTypeConfig.getInventoryGainType().equals(2)) {
            appTaskOrderSummaryDOS.forEach(e -> e.setApproveState(1));
         } else {
            appTaskOrderSummaryDOS.forEach(
               e -> {
                  Long schedulingId = e.getSchedulingId();
                  List<WmsApproveRecord> wmsApproveRecordOKList = this.wmsApproveRecordService
                     .list(
                        (Wrapper<WmsApproveRecord>)(new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getDataId, schedulingId))
                           .eq(WmsApproveRecord::getApproveProcessType, ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType())
                     );
                  if (CollectionUtils.isNotEmpty(wmsApproveRecordOKList)) {
                     boolean hasReviewStatus2 = wmsApproveRecordOKList.stream().anyMatch(record -> record.getReviewStatus() == 2);
                     e.setApproveState(2);
                     if (hasReviewStatus2) {
                        e.setApproveState(1);
                     }
                  } else {
                     e.setApproveState(0);
                  }
               }
            );
         }

         List<AppTaskOrderSummaryDTO> appTaskOrderSummaryDTOList = appTaskOrderSummaryDOS.stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
         appTaskOrderSummaryDTOList = appTaskOrderSummaryDTOList.stream()
            .sorted(Comparator.comparing(AppTaskOrderSummaryDTO::getAskCompleteTime).thenComparing((o1, o2) -> {
               if (o1.getApproveState() == 1 && o2.getApproveState() != 1) {
                  return -1;
               } else if (o1.getApproveState() == 2 && o2.getApproveState() != 2) {
                  return -1;
               } else if (o1.getApproveState() == 0 && o2.getApproveState() != 0) {
                  return 1;
               } else if (o1.getApproveState() == 2 && o2.getApproveState() == 1) {
                  return 1;
               } else if (o1.getApproveState() == 0 && o2.getApproveState() == 1) {
                  return 1;
               } else {
                  return o1.getApproveState() == 0 && o2.getApproveState() == 2 ? 1 : 0;
               }
            }).thenComparing(AppTaskOrderSummaryDTO::getId))
            .collect(Collectors.toList());
         return listPage(pageNumber, pageSize, appTaskOrderSummaryDTOList);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public APPCutTaskProcessDetailDTO taskOrderProcessDetail(Long schedulingId) {
      APPCutTaskProcessDetailDTO appSemiAutoCutTaskProcessDetailDTO = new APPCutTaskProcessDetailDTO();
      List<MesBuildingTask> mesBuildingTaskList = this.mesBuildingTaskService
         .list((Wrapper<MesBuildingTask>)new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getMachinePartSchedulingId, schedulingId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTaskList), "该工单不存在");
      Long workshopId = mesBuildingTaskList.get(0).getWorkshopId();
      MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
      Preconditions.checkArgument(mesBuildingWorkshop != null, "车间不存在");
      List<WmsApproveRecord> wmsApproveRecordOKList = this.wmsApproveRecordService
         .list(
            (Wrapper<WmsApproveRecord>)(new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getDataId, schedulingId))
               .eq(WmsApproveRecord::getApproveProcessType, ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType())
         );
      appSemiAutoCutTaskProcessDetailDTO.setWorkshopId(workshopId);
      appSemiAutoCutTaskProcessDetailDTO.setWorkshopName(mesBuildingWorkshop.getName());
      if (CollectionUtils.isNotEmpty(wmsApproveRecordOKList)) {
         Long id = wmsApproveRecordOKList.get(0).getId();
         Integer reviewStatus = wmsApproveRecordOKList.get(0).getReviewStatus();
         String serialNumber = wmsApproveRecordOKList.get(0).getSerialNumber();
         appSemiAutoCutTaskProcessDetailDTO.setApproveStatus(reviewStatus);
         WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(id);
         appSemiAutoCutTaskProcessDetailDTO.setWmsApproveRecordFlowDTO(wmsApproveRecordFlowDTO);
         appSemiAutoCutTaskProcessDetailDTO.setSerialNumber(serialNumber);
      } else {
         appSemiAutoCutTaskProcessDetailDTO.setApproveStatus(0);
      }

      Long projectId = this.mesBuildingTaskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getMachinePartSchedulingId, schedulingId))
         .get(0)
         .getProjectId();
      ContractProject project = this.projectService.getById(projectId);
      appSemiAutoCutTaskProcessDetailDTO.setProjectName(project.getShortName());
      appSemiAutoCutTaskProcessDetailDTO.setProject(
         ProjectInfo.builder().id(project.getId()).name(project.getName()).serialNumber(project.getSerialNumber()).shortName(project.getShortName()).build()
      );
      List<APPCutTaskProcessPartDetailDTO> appCutTaskProcessPartDetailDTOList = this.mesBuildingMachinePartNoProcessService
         .taskOrderProcessDetail(schedulingId);
      if (CollectionUtils.isNotEmpty(appCutTaskProcessPartDetailDTOList)) {
         appSemiAutoCutTaskProcessDetailDTO.setSemiAutoCutPartDTOList(appCutTaskProcessPartDetailDTOList);
         appSemiAutoCutTaskProcessDetailDTO.setOrderNumber(appCutTaskProcessPartDetailDTOList.get(0).getOrderNumber());
         BigDecimal totalNetWeight = appCutTaskProcessPartDetailDTOList.stream()
            .map(APPCutTaskProcessPartDetailDTO::getTotalNetWeight)
            .filter(weight -> weight != null)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         appSemiAutoCutTaskProcessDetailDTO.setTotalNetWeight(totalNetWeight);
         return appSemiAutoCutTaskProcessDetailDTO;
      } else {
         return appSemiAutoCutTaskProcessDetailDTO;
      }
   }

   @Override
   public APPSemiAutoCutTaskDetailDTO taskOrderDetail(Long taskOrderId, Long queryMonomerId, Long queryAreaId) {
      APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTO = new APPSemiAutoCutTaskDetailDTO();
      MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
      Preconditions.checkArgument(mesBuildingTaskOrder != null, "找不到工单信息");
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId));
      Long cutId = null;
      Long projectId = null;
      User user = this.userService.getById(mesBuildingTaskOrder.getUserId());
      if (CollectionUtils.isEmpty(mesBuildingTaskProcessList)) {
         return appSemiAutoCutTaskDetailDTO;
      }

      cutId = mesBuildingTaskProcessList.get(0).getNestCutPlateId();
      projectId = mesBuildingTaskProcessList.get(0).getProjectId();
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      ContractProject contractProject = this.contractProjectService.getById(projectId);
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService
         .getById(mesBuildingTaskOrder.getCutConfigId());
      MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingMachinePartTeamDetail.getDeviceType());
      appSemiAutoCutTaskDetailDTO.setCutName(mesBuildingProcess.getName());
      appSemiAutoCutTaskDetailDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
      appSemiAutoCutTaskDetailDTO.setCompleteTime(mesBuildingTaskOrder.getCompleteTime());
      appSemiAutoCutTaskDetailDTO.setAskCompleteTime(mesBuildingTaskOrder.getAskCompleteTime());
      appSemiAutoCutTaskDetailDTO.setQuantity(mesBuildingTaskOrder.getQuantity());
      appSemiAutoCutTaskDetailDTO.setProjectName(contractProject.getShortName());
      appSemiAutoCutTaskDetailDTO.setProjectNumber(contractProject.getSerialNumber());
      appSemiAutoCutTaskDetailDTO.setUserName(user.getName());
      appSemiAutoCutTaskDetailDTO.setDrillReportMethod(mesBuildingMachinePartTeamDetail.getDrillReportMethod());
      appSemiAutoCutTaskDetailDTO.setCuttingReportMethod(mesBuildingMachinePartTeamDetail.getCuttingReportMethod());
      if (appSemiAutoCutTaskDetailDTO.getCuttingReportMethod().equals(CuttingReportMethodEnum.APP.getCode())) {
         appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(true);
      } else {
         appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(false);
      }

      MesBuildingNestCutPlate mesBuildingNestCutPlate = this.mesBuildingNestCutPlateService
         .list(
            (Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>()
               .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, mesBuildingTaskOrder.getSchedulingId())
         )
         .get(0);
      appSemiAutoCutTaskDetailDTO.setNestCutPlateId(mesBuildingNestCutPlate.getId());
      List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService
         .getMachinePartOffLineAuto(cutId, queryMonomerId, queryAreaId);
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
         Map<Long, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
            .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
         listMap.forEach((monomerId, drillingList) -> {
            Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
            Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
            drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
         });
      }

      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
         Map<String, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
            .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
         listMap.forEach((areaId, drillingList) -> {
            Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
            Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
            drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
         });
      }

      List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
      mesBuildingMachineTaskDTOList.forEach(
         e -> semiAutoCutPartDTOList.add(
            SemiAutoCutPartDTO.builder()
               .partNumber(e.getSerialNumber())
               .id(e.getId())
               .partId(e.getPartId())
               .specification(e.getSpecification())
               .quantity(e.getQuantity())
               .completeQuantity(e.getCompleteQuantity())
               .thumbnail(e.getPicturePath())
               .thick(null)
               .length(e.getLength())
               .material(e.getMaterial())
               .boolCompleteEnum(e.getBoolCompleteEnum())
               .labelStatus(e.getLabelStatus())
               .monomerId(e.getMonomerId())
               .monomerName(monomerMap.get(e.getMonomerId()).getName())
               .build()
         )
      );
      appSemiAutoCutTaskDetailDTO.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
      return appSemiAutoCutTaskDetailDTO;
   }

   @Override
   public PageVO<APPSemiAutoCutTaskDetailDTO> taskOrderDetailHistory(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new PageVO<>();
      }

      List<APPSemiAutoCutTaskDetailDTO> appSemiAutoCutTaskDetailDTOList = new ArrayList<>();
      List<MesBuildingNestCutPlateDTO> mesBuildingNestCutPlateDTOList = this.mesBuildingProduceTeamReportMapper
         .teamReportNestCutPlateList(startDate, endDate, taskTypeEnum, processType, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toSet()));
      Map<Long, List<MesBuildingNestCutPlateDTO>> taskOrderIdMap = mesBuildingNestCutPlateDTOList.stream()
         .collect(Collectors.groupingBy(MesBuildingNestCutPlateDTO::getTaskOrderId));
      taskOrderIdMap.forEach(
         (taskOrderId, mesBuildingNestCutPlateDTOList1) -> {
            APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTO = new APPSemiAutoCutTaskDetailDTO();
            MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
            if (null == serialNumber || mesBuildingTaskOrder.getOrderNumber().contains(serialNumber)) {
               if (mesBuildingTaskOrder.getOrderNumber().contains("(型)")) {
                  List<MesBuildingTaskProcess> mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
                     .list(
                        (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId))
                           .eq(MesBuildingTaskProcess::getSequence, 0)
                     );
                  Long cutId = null;
                  Long projectId = null;
                  Integer completeQuantity = 0;
                  BigDecimal completeWeight = BigDecimal.ZERO;
                  User user = this.userService.getById(mesBuildingTaskOrder.getUserId());
                  if (CollectionUtils.isNotEmpty(mesBuildingTaskProcessList)) {
                     MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcessList.get(0);
                     cutId = mesBuildingTaskProcessList.get(0).getNestCutPlateId();
                     projectId = mesBuildingTaskProcessList.get(0).getProjectId();
                     completeQuantity = mesBuildingTaskProcessList.stream().mapToInt(MesBuildingTaskProcess::getCompleteQuantity).sum();

                     for (int i = 0; i < mesBuildingTaskProcessList.size(); i++) {
                        MesBuildingTaskProcess e = mesBuildingTaskProcessList.get(i);
                        Long productId = e.getProductId();
                        TechMachinePart techMachinePart = this.techMachinePartService.getById(productId);
                        completeWeight = completeWeight.add(techMachinePart.getNetWeight().multiply(new BigDecimal(e.getCompleteQuantity())));
                     }

                     appSemiAutoCutTaskDetailDTO.setCompleteTime(mesBuildingTaskProcess.getCompleteTime());
                     appSemiAutoCutTaskDetailDTO.setId(mesBuildingTaskProcess.getTaskOrderId());
                  }

                  MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService
                     .getById(mesBuildingTaskOrder.getCutConfigId());
                  MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingMachinePartTeamDetail.getDeviceType());
                  appSemiAutoCutTaskDetailDTO.setCutName(mesBuildingProcess.getName());
                  appSemiAutoCutTaskDetailDTO.setSchedulingDate(mesBuildingTaskOrder.getCreateTime());
                  appSemiAutoCutTaskDetailDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
                  appSemiAutoCutTaskDetailDTO.setAskCompleteTime(mesBuildingTaskOrder.getAskCompleteTime());
                  appSemiAutoCutTaskDetailDTO.setUserName(user.getName());
                  ContractProject contractProject = this.contractProjectService.getById(projectId);
                  appSemiAutoCutTaskDetailDTO.setProjectName(contractProject.getShortName());
                  appSemiAutoCutTaskDetailDTO.setProjectNumber(contractProject.getSerialNumber());
                  appSemiAutoCutTaskDetailDTO.setQuantity(mesBuildingTaskOrder.getQuantity());
                  appSemiAutoCutTaskDetailDTO.setCompleteQuantity(completeQuantity);
                  appSemiAutoCutTaskDetailDTO.setCompleteWeight(completeWeight);
                  List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
                  List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService.getMachinePartOffLine(cutId);
                  Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
                  if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
                     Map<Long, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
                     listMap.forEach((monomerId, drillingList) -> {
                        Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
                        Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
                        drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
                     });
                  }

                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     Map<String, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
                     listMap.forEach((areaId, drillingList) -> {
                        Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
                        Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
                        drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
                     });
                  }

                  mesBuildingMachineTaskDTOList.forEach(
                     e -> {
                        if (e.getBoolCompleteEnum()) {
                           semiAutoCutPartDTOList.add(
                              SemiAutoCutPartDTO.builder()
                                 .partNumber(e.getSerialNumber())
                                 .id(e.getId())
                                 .partId(e.getPartId())
                                 .specification(e.getSpecification())
                                 .quantity(e.getQuantity())
                                 .completeQuantity(e.getCompleteQuantity())
                                 .thumbnail(e.getPicturePath())
                                 .thick(e.getThick())
                                 .material(e.getMaterial())
                                 .boolCompleteEnum(e.getBoolCompleteEnum())
                                 .labelStatus(e.getLabelStatus())
                                 .build()
                           );
                        }
                     }
                  );
                  appSemiAutoCutTaskDetailDTO.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
                  appSemiAutoCutTaskDetailDTOList.add(appSemiAutoCutTaskDetailDTO);
               }
            }
         }
      );
      List<AppTaskOrderSummaryDO> machinePartNoProcessResult = this.mesBuildingMachinePartNoProcessService
         .getMachinePartNoProcessResult(teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()));
      List<APPSemiAutoCutTaskDetailDTO> appSemiAutoCutTaskNoProcessDetailDTOList = new ArrayList<>();
      machinePartNoProcessResult.forEach(
         appSemiAutoCutTaskDetailDTO -> {
            Long schedulingId = appSemiAutoCutTaskDetailDTO.getSchedulingId();
            APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTONoProcess = new APPSemiAutoCutTaskDetailDTO();
            List<APPCutTaskProcessPartDetailDTO> appCutTaskProcessPartDetailDTOList = this.mesBuildingMachinePartNoProcessService
               .taskOrderProcessDetail(schedulingId);
            List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
            appCutTaskProcessPartDetailDTOList.forEach(
               e -> {
                  SemiAutoCutPartDTO semiAutoCutPartDTO = SemiAutoCutPartDTO.builder()
                     .partNumber(e.getSerialNumber())
                     .specification(e.getSpecification())
                     .quantity(e.getQuantity())
                     .material(e.getMaterial())
                     .build();
                  semiAutoCutPartDTOList.add(semiAutoCutPartDTO);
               }
            );
            appSemiAutoCutTaskDetailDTONoProcess.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
            appSemiAutoCutTaskNoProcessDetailDTOList.add(appSemiAutoCutTaskDetailDTONoProcess);
         }
      );
      appSemiAutoCutTaskDetailDTOList.addAll(appSemiAutoCutTaskNoProcessDetailDTOList);
      return listPage(pageNumber, pageSize, appSemiAutoCutTaskDetailDTOList);
   }

   @Override
   public String updatePartLabelStatus(Long id) {
      MesBuildingNestCutPlatePart mesBuildingNestCutPlatePart = this.mesBuildingNestCutPlatePartService.getById(id);
      if (null != mesBuildingNestCutPlatePart && mesBuildingNestCutPlatePart.getLabelStatus() == 0) {
         mesBuildingNestCutPlatePart.setLabelStatus(1);
         this.mesBuildingNestCutPlatePartService.updateById(mesBuildingNestCutPlatePart);
         return "修改打标状态成功";
      } else {
         return "已打标，无需修改打标状态";
      }
   }

   public static <T> PageVO<T> listPage(Integer pageNum, Integer pageSize, List<T> collect) {
      Page<T> pages = new Page<>(pageNum, pageSize);
      int total = collect.size();
      pages.setTotal(total);
      int startIndex = (pageNum - 1) * pageSize;
      int endIndex = Math.min(startIndex + pageSize, total);
      pages.addAll(collect.subList(startIndex, endIndex));
      return new PageVO<>(pages);
   }
}
