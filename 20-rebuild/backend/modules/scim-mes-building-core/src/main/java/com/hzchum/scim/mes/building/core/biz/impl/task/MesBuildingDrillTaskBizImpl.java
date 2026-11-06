package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingDrillTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.DrillReportMethodEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPSemiAutoCutTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.SemiAutoCutPartDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingDrillTaskBizImpl implements MesBuildingDrillTaskBiz {
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
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Autowired
   private MesBuildingGroupsTeamLinkBiz groupsTeamLinkBiz;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private MesBuildingNestCutPlateService nestCutPlateService;
   @Autowired
   private ConfigService configService;
   @Autowired
   private PlanMonomerService monomerService;

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
      Long projectId, Long monomerId, Long areaId, String orderNumber, String sort, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> processIdList = this.processService
            .list(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
            )
            .stream()
            .map(MesBuildingProcess::getId)
            .collect(Collectors.toList());
         if (processIdList.size() == 0) {
            return new PageVO<>();
         }

         List<Long> teamIdList = teamList.stream()
            .filter(e -> processIdList.contains(e.getProcessId()))
            .map(MesBuildingTeam::getId)
            .collect(Collectors.toList());
         if (teamIdList.size() == 0) {
            return new PageVO<>();
         }

         List<AppTaskOrderSummaryDTO> appTaskOrderSummaryDTOList = this.taskProcessService
            .drillTaskOrderList(projectId, projectIds, monomerId, areaId, orderNumber, teamIdList)
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDTOList)) {
            appTaskOrderSummaryDTOList.forEach(e -> {
               MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(e.getCutType());
               e.setCutTypeName(mesBuildingProcess.getName());
            });
         }

         appTaskOrderSummaryDTOList = appTaskOrderSummaryDTOList.stream().filter(e -> e.getQuantity() > 0).collect(Collectors.toList());
         appTaskOrderSummaryDTOList = appTaskOrderSummaryDTOList.stream()
            .sorted(Comparator.comparing(AppTaskOrderSummaryDTO::getAskCompleteTime).thenComparing(AppTaskOrderSummaryDTO::getId))
            .collect(Collectors.toList());
         return listPage(pageNumber, pageSize, appTaskOrderSummaryDTOList);
      } else {
         return new PageVO<>();
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
      if (mesBuildingTaskOrder.getSchedulingId() != null) {
         MesBuildingNestCutPlate nestCutPlate = this.nestCutPlateService
            .getOne(
               (Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>()
                  .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, mesBuildingTaskOrder.getSchedulingId())
            );
         appSemiAutoCutTaskDetailDTO.setNestCutPlateId(nestCutPlate.getId());
      }

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
      if (appSemiAutoCutTaskDetailDTO.getDrillReportMethod().equals(DrillReportMethodEnum.APP.getCode())) {
         appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(true);
      } else {
         appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(false);
      }

      List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService
         .getMachinePartOffLineDrill(cutId, queryMonomerId, queryAreaId);
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
         e -> {
            MesBuildingTaskProcess mesBuildingTaskProcesses = this.taskProcessService
               .getOne(
                  (Wrapper<MesBuildingTaskProcess>)((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                           .eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId))
                        .eq(MesBuildingTaskProcess::getProductId, e.getPartId()))
                     .eq(MesBuildingTaskProcess::getSequence, 1)
               );
            MesBuildingTaskProcess mesBuildingTaskProcessesOne = this.taskProcessService
               .getOne(
                  (Wrapper<MesBuildingTaskProcess>)((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                           .eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId))
                        .eq(MesBuildingTaskProcess::getProductId, e.getPartId()))
                     .eq(MesBuildingTaskProcess::getSequence, 0)
               );
            Integer completeQuantity = mesBuildingTaskProcessesOne.getCompleteQuantity();
            Integer needQuantity = mesBuildingTaskProcessesOne.getNeedQuantity();
            SemiAutoCutPartDTO semiAutoCutPartDTO = SemiAutoCutPartDTO.builder()
               .partNumber(e.getSerialNumber())
               .id(e.getId())
               .partId(e.getPartId())
               .specification(e.getSpecification())
               .quantity(e.getQuantity())
               .thumbnail(e.getPicturePath())
               .completeQuantity(mesBuildingTaskProcesses.getCompleteQuantity())
               .thick(e.getThick())
               .material(e.getMaterial())
               .boolCompleteEnum(e.getBoolCompleteEnum())
               .labelStatus(e.getLabelStatus())
               .monomerId(e.getMonomerId())
               .monomerName(monomerMap.get(e.getMonomerId()).getName())
               .length(e.getLength())
               .build();
            if (completeQuantity.equals(needQuantity)) {
               semiAutoCutPartDTO.setBoolLayoffCompleteEnum(true);
            } else {
               semiAutoCutPartDTO.setBoolLayoffCompleteEnum(false);
            }

            semiAutoCutPartDTOList.add(semiAutoCutPartDTO);
         }
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
         .teamReportNestCutPlateList(
            startDate, endDate, taskTypeEnum, ProcessTypeEnum.DRILL_HOLE.getType(), teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toSet())
         );
      Map<Long, List<MesBuildingNestCutPlateDTO>> taskOrderIdMap = mesBuildingNestCutPlateDTOList.stream()
         .collect(Collectors.groupingBy(MesBuildingNestCutPlateDTO::getTaskOrderId));
      taskOrderIdMap.forEach(
         (taskOrderId, mesBuildingNestCutPlateDTOList1) -> {
            APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTO = new APPSemiAutoCutTaskDetailDTO();
            MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
            if (null == serialNumber || mesBuildingTaskOrder.getOrderNumber().contains(serialNumber)) {
               if (mesBuildingTaskOrder.getOrderNumber().contains("(套)") || mesBuildingTaskOrder.getOrderNumber().contains("(直)")) {
                  List<MesBuildingTaskProcess> mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
                     .list(
                        (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId))
                           .eq(MesBuildingTaskProcess::getSequence, 1)
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

                     appSemiAutoCutTaskDetailDTO.setAskCompleteTime(mesBuildingTaskProcess.getAskCompleteTime());
                     appSemiAutoCutTaskDetailDTO.setId(mesBuildingTaskProcess.getTaskOrderId());
                     appSemiAutoCutTaskDetailDTO.setCompleteTime(mesBuildingTaskProcess.getCompleteTime());
                  }

                  if (completeQuantity != 0) {
                     MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService
                        .getById(mesBuildingTaskOrder.getCutConfigId());
                     MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingMachinePartTeamDetail.getDeviceType());
                     appSemiAutoCutTaskDetailDTO.setCutName(mesBuildingProcess.getName());
                     appSemiAutoCutTaskDetailDTO.setSchedulingDate(mesBuildingTaskOrder.getCreateTime());
                     appSemiAutoCutTaskDetailDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
                     appSemiAutoCutTaskDetailDTO.setUserName(user.getName());
                     ContractProject contractProject = this.contractProjectService.getById(projectId);
                     appSemiAutoCutTaskDetailDTO.setProjectName(contractProject.getShortName());
                     appSemiAutoCutTaskDetailDTO.setProjectNumber(contractProject.getSerialNumber());
                     appSemiAutoCutTaskDetailDTO.setCompleteWeight(completeWeight);
                     List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
                     List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService
                        .getMachinePartOffLineDrill(cutId, null, null);
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
                           if (e.getCompleteQuantity() > 0) {
                              SemiAutoCutPartDTO semiAutoCutPartDTO = SemiAutoCutPartDTO.builder()
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
                                 .build();
                              if (e.getCompleteQuantity().equals(e.getQuantity())) {
                                 semiAutoCutPartDTO.setBoolCompleteEnum(true);
                              } else {
                                 semiAutoCutPartDTO.setBoolCompleteEnum(false);
                              }

                              semiAutoCutPartDTOList.add(semiAutoCutPartDTO);
                           }
                        }
                     );
                     int totalCompleteQuantity = semiAutoCutPartDTOList.stream().mapToInt(SemiAutoCutPartDTO::getCompleteQuantity).sum();
                     int totalQuantity = semiAutoCutPartDTOList.stream().mapToInt(SemiAutoCutPartDTO::getQuantity).sum();
                     appSemiAutoCutTaskDetailDTO.setCompleteQuantity(totalCompleteQuantity);
                     appSemiAutoCutTaskDetailDTO.setQuantity(totalQuantity);
                     appSemiAutoCutTaskDetailDTO.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
                     appSemiAutoCutTaskDetailDTOList.add(appSemiAutoCutTaskDetailDTO);
                  }
               }
            }
         }
      );
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
