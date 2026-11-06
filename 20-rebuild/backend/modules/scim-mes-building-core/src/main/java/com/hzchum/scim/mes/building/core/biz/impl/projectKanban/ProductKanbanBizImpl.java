package com.hzchum.scim.mes.building.core.biz.impl.projectKanban;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.enums.ArtifactAssembleMatchingTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.FormSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.ProductKanbanDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingAreaProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingProjectProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactAssembleMatchingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactFormDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactKanbanDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.AssembleDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.AssembleMatchingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.EnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.EnclosureFormDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.FormSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.InspectionTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.KanBanMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.MachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductKanBanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductKanBanInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTraceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.produceTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.SchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.FormDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.FormSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProductKanbanDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactAssembleMatchingDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductKanbanBizImpl implements ProductKanbanBiz {
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechArtifactMachinePartLinkService machinePartLinkService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Autowired
   private ProjectInstallSummaryService installSummaryService;
   @Autowired
   private MesBuildingCargoListService mesBuildingCargoListService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingAssistService assistService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingMachinePartSchedulingArtifactTaskLinkService schedulingArtifactTaskLinkService;
   @Autowired
   private MesBuildingMachinePartSchedulingLinkService partSchedulingLinkService;

   @Override
   public List<KanBanMachinePartSummaryDTO> machinePartSteelSpec(ProductKanbanDTOParam dtoParam) {
      return this.taskService
         .machinePartSteelSpec(BeanUtil.copy(dtoParam, ProductKanbanDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, KanBanMachinePartSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProductKanBanDTO> productKanban(ProductKanbanDTOParam dtoParam) {
      List<Long> productProcessIds = new ArrayList<>();
      if (dtoParam.getProcessId() != null) {
         productProcessIds = this.productProcessLinkService
            .list((Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery().eq(MesBuildingProductProcessLink::getProcessId, dtoParam.getProcessId()))
            .stream()
            .map(MesBuildingProductProcessLink::getProductProcessId)
            .collect(Collectors.toList());
      }

      return productProcessIds.size() == 0
         ? this.taskService
            .productKanban(BeanUtil.copy(dtoParam, ProductKanbanDOParam.class).setProductProcessIds(null))
            .stream()
            .map(e -> BeanUtil.copy(e, ProductKanBanDTO.class))
            .collect(Collectors.toList())
         : this.taskService
            .productKanban(BeanUtil.copy(dtoParam, ProductKanbanDOParam.class).setProductProcessIds(productProcessIds))
            .stream()
            .map(e -> BeanUtil.copy(e, ProductKanBanDTO.class))
            .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProductKanBanDTO> productKanbanPage(ProductKanbanDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      List<Long> productProcessIds = new ArrayList<>();
      if (dtoParam.getProcessId() != null) {
         productProcessIds = this.productProcessLinkService
            .list((Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery().eq(MesBuildingProductProcessLink::getProcessId, dtoParam.getProcessId()))
            .stream()
            .map(MesBuildingProductProcessLink::getProductProcessId)
            .collect(Collectors.toList());
      }

      return productProcessIds.size() == 0
         ? new PageVO<>(
            PageHelper.startPage(pageNumber, pageSize),
            this.taskService
               .productKanban(BeanUtil.copy(dtoParam, ProductKanbanDOParam.class).setProductProcessIds(null))
               .stream()
               .map(e -> BeanUtil.copy(e, ProductKanBanDTO.class))
               .collect(Collectors.toList())
         )
         : new PageVO<>(
            PageHelper.startPage(pageNumber, pageSize),
            this.taskService
               .productKanban(BeanUtil.copy(dtoParam, ProductKanbanDOParam.class).setProductProcessIds(productProcessIds))
               .stream()
               .map(e -> BeanUtil.copy(e, ProductKanBanDTO.class))
               .collect(Collectors.toList())
         );
   }

   @Override
   public ArtifactDetailDTO artifactDetail(Long id) {
      TechArtifact artifact = this.artifactService.getById(id);
      Preconditions.checkArgument(artifact != null, "构件不存在");
      List<ProcessSummaryDetailsDTO> detailsDTOS = this.getProcessSummaryDetailsDTOS(id, TaskTypeEnum.ARTIFACT.getType());
      ArtifactDetailDTO copy = BeanUtil.copy(artifact, ArtifactDetailDTO.class);
      copy.setArea(artifact.getSurfaceArea());
      copy.setProcessSummaryDetailsList(detailsDTOS);
      return copy;
   }

   @Override
   public EnclosureDetailDTO enclosureDetail(Long id) {
      EnclosureDetailDTO dto = BeanUtil.copy(this.enclosureService.getById(id), EnclosureDetailDTO.class);
      dto.setProcessSummaryDetailsList(this.taskService.getSummaryByIdAndType(id, ProductTypeEnum.ENCLOSURE.getType()));
      return dto;
   }

   @Override
   public AssembleDetailDTO assembleDetail(Long id) {
      TechAssemble assemble = this.assembleService.getById(id);
      Preconditions.checkArgument(assemble != null, "部件不存在");
      List<ProcessSummaryDetailsDTO> detailsDTOS = this.getProcessSummaryDetailsDTOS(id, TaskTypeEnum.ASSEMBLE.getType());
      AssembleDetailDTO copy = BeanUtil.copy(assemble, AssembleDetailDTO.class);
      copy.setGrossWeight(assemble.getNetWeight());
      copy.setProcessSummaryDetailsList(detailsDTOS);
      copy.setUseComplete(assemble.getUseCompleteQuantity());
      return copy;
   }

   @Override
   public MachinePartDTO machinePartDetail(Long id) {
      TechMachinePart machinePart = this.machinePartService.getById(id);
      Preconditions.checkArgument(machinePart != null, "零件不存在");
      List<ProcessSummaryDetailsDTO> detailsDTOS = this.getProcessSummaryDetailsDTOS(id, TaskTypeEnum.MACHINE_PART.getType());
      MachinePartDTO copy = BeanUtil.copy(machinePart, MachinePartDTO.class);
      copy.setProcessSummaryDetailsList(detailsDTOS);
      copy.setUseComplete(machinePart.getUseCompleteQuantity());
      return copy;
   }

   @NotNull
   private List<ProcessSummaryDetailsDTO> getProcessSummaryDetailsDTOS(Long productId, Integer taskTypeEnum) {
      List<ProcessSummaryDetailsDTO> detailsDTOS = this.taskService.getSummaryByIdAndType(productId, taskTypeEnum);
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getProductId, productId)
               .eq(MesBuildingTaskProcess::getTaskTypeEnum, taskTypeEnum)
         );
      List<Long> processIds = taskProcessList.stream().map(MesBuildingTaskProcess::getId).distinct().collect(Collectors.toList());
      List<Long> assitLinesIds = this.assistService
         .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(CollectionUtils.isNotEmpty(processIds), MesBuildingAssist::getTaskProcessId, processIds))
         .stream()
         .map(MesBuildingAssist::getProductionLineId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, String> teamUserMap = new HashMap<>();
      detailsDTOS.forEach(
         process -> {
            List<produceTeamRecourseDTO> produceTeamDTOS = this.produceTeamReportService
               .listproduceInfo(Arrays.asList(process.getProcessId()), productId, taskTypeEnum, assitLinesIds);
            Map<String, Map<Long, List<produceTeamRecourseDTO>>> teamProduceMap = produceTeamDTOS.stream()
               .collect(
                  Collectors.groupingBy(
                     e -> e.getWorkshopName() + "delimiter" + e.getProductLineName(), Collectors.groupingBy(produceTeamRecourseDTO::getTeamId)
                  )
               );
            List<InspectionTeamRecourseDTO> inspectionTeamDTOS = this.inspectionTeamReportService
               .listInspectionInfoAV2(process.getProcessId(), productId, taskTypeEnum, assitLinesIds);
            Map<String, Map<Long, List<InspectionTeamRecourseDTO>>> teamInspectionMap = inspectionTeamDTOS.stream()
               .collect(Collectors.groupingBy(InspectionTeamRecourseDTO::getProductLineName, Collectors.groupingBy(InspectionTeamRecourseDTO::getTeamId)));
            List<TeamTraceDTO> teamTraceList = new ArrayList<>();

            for (String workshopAndlineName : teamProduceMap.keySet()) {
               String lineName = workshopAndlineName.split("delimiter")[1];
               String workshopName = workshopAndlineName.split("delimiter")[0];

               for (Long teamId : teamProduceMap.get(workshopAndlineName).keySet()) {
                  TeamTraceDTO teamTraceDTO = new TeamTraceDTO();
                  teamTraceDTO.setProductLineName(lineName);
                  teamTraceDTO.setWorkshopName(workshopName);
                  Long leaderUserId = this.teamUserLinkService
                     .getOne(
                        Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                           .eq(MesBuildingTeamUserLink::getTeamId, teamId)
                           .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
                     )
                     .getUserId();
                  if (teamUserMap.get(leaderUserId) == null) {
                     User user = this.userService.getById(leaderUserId);
                     teamUserMap.put(user.getId(), user.getName());
                  }

                  teamTraceDTO.setTeamId(teamId);
                  teamTraceDTO.setUserId(leaderUserId);
                  teamTraceDTO.setUserName(teamUserMap.get(leaderUserId));
                  List<produceTeamRecourseDTO> teamManufacture = teamProduceMap.get(workshopAndlineName).get(teamId);
                  teamTraceDTO.setProduceTeamRecourseList(teamManufacture);
                  if (CollectionUtils.isNotEmpty(teamInspectionMap)) {
                     Map<Long, List<InspectionTeamRecourseDTO>> mapMap = teamInspectionMap.get(lineName);
                     if (CollectionUtils.isNotEmpty(mapMap)) {
                        teamTraceDTO.setInspectionTeamRecourseList(mapMap.get(teamId));
                     }
                  }

                  teamTraceList.add(teamTraceDTO);
               }
            }

            process.setTeamTraceList(teamTraceList);
         }
      );
      return detailsDTOS;
   }

   @Override
   public List<ArtifactFormDTO> projectArtifactForm(FormDTOParam dtoParam) {
      List<ArtifactFormDTO> dtoList = this.artifactService
         .list(
            ((((((Wrappers.<TechArtifact>lambdaQuery()
                                 .eq(dtoParam.getProjectId() != null, TechArtifact::getProjectId, dtoParam.getProjectId()))
                              .eq(dtoParam.getMonomerId() != null, TechArtifact::getMonomerId, dtoParam.getMonomerId()))
                           .eq(dtoParam.getAreaId() != null, TechArtifact::getAreaId, dtoParam.getAreaId()))
                        .like(dtoParam.getName() != null, TechArtifact::getName, dtoParam.getName()))
                     .like(dtoParam.getSerialNumber() != null, TechArtifact::getSerialNumber, dtoParam.getSerialNumber()))
                  .like(dtoParam.getSpecification() != null, TechArtifact::getSpecification, dtoParam.getSpecification()))
               .like(dtoParam.getMaterial() != null, TechArtifact::getMaterial, dtoParam.getMaterial())
         )
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactFormDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(e -> {
         SchedulingDetailDTO dto = this.schedulingService.getSchedulingDetailByProductIdAndProductType(e.getId(), ProductTypeEnum.ARTIFACT.getType(), null);
         e.setInProductionQuantity(dto.getInProductionQuantity());
         e.setTotalSchedulingQuantity(dto.getTotalSchedulingQuantity());
         e.setTotalTaskQuantity(dto.getTotalTaskQuantity());
         e.setCompleteQuantity(dto.getCompleteQuantity());
         e.setSendQuantity(this.cargoListProductLinkService.getShipQuantityByProduct(e.getId(), ProductTypeEnum.ARTIFACT.getType()));
      });
      return dtoList;
   }

   @Override
   public PageVO<ArtifactFormDTO> projectArtifactFormPage(FormDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.projectArtifactForm(dtoParam));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectArtifactFormPrint(FormDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getProjectId() != null) {
         header.put("project", this.projectService.getSimpleById(param.getProjectId()));
      }

      if (param.getProjectId() != null) {
         header.put("monomer", BeanUtil.copy(this.monomerService.getById(param.getMonomerId()), NameInfo.class));
      }

      if (param.getProjectId() != null) {
         header.put("area", BeanUtil.copy(this.areaService.getById(param.getAreaId()), NameInfo.class));
      }

      String date = param.getStartDate() != null && param.getEndDate() != null
         ? DateTimeUtil.getLocalDateStr(param.getStartDate()) + "-" + DateTimeUtil.getLocalDateStr(param.getEndDate())
         : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(this.projectArtifactForm(param).stream().map(e -> {
         Map<String, Object> result = BeanUtil.beanToMap(e);
         result.put("productType", ProductTypeEnum.ARTIFACT.getType());
         return result;
      }).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<EnclosureFormDTO> projectEnclosureForm(FormDTOParam dtoParam) {
      List<EnclosureFormDTO> dtoList = this.enclosureService
         .list(
            ((((((Wrappers.<TechEnclosure>lambdaQuery()
                                 .eq(dtoParam.getProjectId() != null, TechEnclosure::getProjectId, dtoParam.getProjectId()))
                              .eq(dtoParam.getAreaId() != null, TechEnclosure::getEnclosurePlanId, dtoParam.getAreaId()))
                           .eq(TechEnclosure::getCategory, dtoParam.getCategory()))
                        .like(dtoParam.getName() != null, TechEnclosure::getName, dtoParam.getName()))
                     .like(dtoParam.getSerialNumber() != null, TechEnclosure::getSerialNumber, dtoParam.getSerialNumber()))
                  .like(dtoParam.getColor() != null, TechEnclosure::getColor, dtoParam.getColor()))
               .like(dtoParam.getPlate() != null, TechEnclosure::getPlate, dtoParam.getPlate())
         )
         .stream()
         .map(e -> BeanUtil.copy(e, EnclosureFormDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(e -> {
         SchedulingDetailDTO dto = this.schedulingService.getSchedulingDetailByProductIdAndProductType(e.getId(), ProductTypeEnum.ENCLOSURE.getType(), null);
         e.setInProductionQuantity(dto.getInProductionQuantity());
         e.setTotalSchedulingQuantity(dto.getTotalSchedulingQuantity());
         e.setTotalTaskQuantity(dto.getTotalTaskQuantity());
         e.setCompleteQuantity(dto.getCompleteQuantity());
         e.setSendQuantity(this.cargoListProductLinkService.getShipQuantityByProduct(e.getId(), ProductTypeEnum.ENCLOSURE.getType()));
      });
      return dtoList;
   }

   @Override
   public PageVO<EnclosureFormDTO> projectEnclosureFormPage(FormDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.projectEnclosureForm(dtoParam));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectEnclosureFormPrint(FormDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getProjectId() != null) {
         header.put("project", this.projectService.getSimpleById(param.getProjectId()));
      }

      if (param.getProjectId() != null) {
         header.put("monomer", BeanUtil.copy(this.monomerService.getById(param.getMonomerId()), NameInfo.class));
      }

      if (param.getProjectId() != null) {
         header.put("area", BeanUtil.copy(this.areaService.getById(param.getAreaId()), NameInfo.class));
      }

      String date = param.getStartDate() != null && param.getEndDate() != null
         ? DateTimeUtil.getLocalDateStr(param.getStartDate()) + "-" + DateTimeUtil.getLocalDateStr(param.getEndDate())
         : "全部";
      header.put("date", date);
      header.put("category", EnclosureCategoryEnum.getNameByCategory(param.getCategory()));
      printVO.setHeader(header);
      printVO.setTable(this.projectEnclosureForm(param).stream().map(e -> {
         Map<String, Object> result = BeanUtil.beanToMap(e);
         result.put("productType", ProductTypeEnum.ENCLOSURE.getType());
         return result;
      }).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<ArtifactAssembleMatchingDTO> artifactAssembleMatchingList(ProductKanbanDTOParam dtoParam) {
      List<PlanArtifactAssembleMatchingDTO> planArtifactAssembleMatchingDTOS = this.artifactService
         .listArtifactProcess(
            null,
            dtoParam.getProjectId(),
            dtoParam.getMonomerId(),
            dtoParam.getAreaId(),
            dtoParam.getStructureClassId(),
            dtoParam.getName(),
            dtoParam.getSerialNumber(),
            dtoParam.getSpecification(),
            dtoParam.getMaterial(),
            dtoParam.getAreaBatchId()
         );
      if (CollectionUtils.isEmpty(planArtifactAssembleMatchingDTOS)) {
         return new ArrayList<>();
      }

      Integer projectMode = this.projectService.getProjectMode(dtoParam.getProjectId());
      List<ArtifactAssembleMatchingDTO> dtoList = planArtifactAssembleMatchingDTOS.stream()
         .map(e -> BeanUtil.copy(e, ArtifactAssembleMatchingDTO.class))
         .collect(Collectors.toList());
      if (!projectMode.equals(ProjectModeEnum.STANDARD_MODE.getType())) {
         dtoList.forEach(dto -> {
            dto.setType(ArtifactAssembleMatchingTypeEnum.WHOLE.getType());
            dto.setBoolHaveTask(Boolean.TRUE);
         });
         return dtoList.stream().filter(e -> dtoParam.getStatus() == null || e.getType().equals(dtoParam.getStatus())).collect(Collectors.toList());
      }

      List<Long> artifactIds = dtoList.stream().map(ArtifactAssembleMatchingDTO::getId).collect(Collectors.toList());
      List<TechArtifactMachinePartLink> artifactMachinePartLinks = this.machinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
      Map<Long, List<TechArtifactMachinePartLink>> artifactMachinePartLinkMap = artifactMachinePartLinks.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      Map<Long, TechMachinePart> partMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(artifactMachinePartLinks)) {
         partMap = this.machinePartService
            .listByIds(artifactMachinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      }

      List<MesBuildingTask> tasks = this.taskService
         .list(
            (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .in(MesBuildingTask::getProductId, artifactIds)
         );
      List<Long> artifactTaskIds = tasks.stream().map(MesBuildingTask::getId).distinct().collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = this.taskNumberLinkService
         .list(
            (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>().isNotNull(MesBuildingTaskNumberLink::getAssembleTaskId))
               .in(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskIds)
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
      Map<Long, List<MesBuildingTask>> artifactTaskMap = tasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getProductId));
      Map<Long, TechMachinePart> finalPartMap = partMap;
      dtoList.forEach(
         e -> {
            e.setBoolHaveTask(Boolean.TRUE);
            e.setType(ArtifactAssembleMatchingTypeEnum.WHOLE.getType());
            List<TechArtifactMachinePartLink> machinePartLinkList = artifactMachinePartLinkMap.get(e.getId());
            List<TechMachinePart> machinePartList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(machinePartLinkList)
               && machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).findAny().isPresent()) {
               machinePartList = machinePartLinkList.stream()
                  .map(machinePartLink -> finalPartMap.get(machinePartLink.getMachinePartId()))
                  .collect(Collectors.toList());
            }

            if (CollectionUtils.isNotEmpty(machinePartList)) {
               if (machinePartList.stream().noneMatch(machinePart -> machinePart.getProducedQuantity() > machinePart.getUsedQuantity())) {
                  e.setType(ArtifactAssembleMatchingTypeEnum.NOTHING.getType());
               } else {
                  e.setType(ArtifactAssembleMatchingTypeEnum.WHOLE.getType());
                  machinePartLinkList.forEach(
                     temp -> {
                        if (e.getType().equals(ArtifactAssembleMatchingTypeEnum.WHOLE.getType())) {
                           TechMachinePart machinePart = finalPartMap.get(temp.getMachinePartId());
                           if (machinePart.getProducedQuantity() - machinePart.getUsedQuantity()
                              < (e.getQuantity() - e.getProducedQuantity()) * temp.getQuantity()) {
                              e.setType(ArtifactAssembleMatchingTypeEnum.PART.getType());
                           }
                        }
                     }
                  );
               }
            }

            if (!e.getType().equals(ArtifactAssembleMatchingTypeEnum.PART.getType())) {
               for (MesBuildingTask artifactTask : artifactTaskMap.get(e.getId())) {
                  List<MesBuildingTaskNumberLink> numberLinks = taskNumberLinkMap.get(artifactTask.getId());
                  if (CollectionUtils.isNotEmpty(numberLinks)) {
                     if (e.getType().equals(ArtifactAssembleMatchingTypeEnum.WHOLE.getType())
                        && !numberLinks.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                        e.setType(ArtifactAssembleMatchingTypeEnum.PART.getType());
                        return;
                     }

                     if (e.getType().equals(ArtifactAssembleMatchingTypeEnum.NOTHING.getType())
                        && numberLinks.stream().anyMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                        e.setType(ArtifactAssembleMatchingTypeEnum.PART.getType());
                        return;
                     }

                     if (e.getType().equals(ArtifactAssembleMatchingTypeEnum.NOTHING.getType())
                        && numberLinks.stream().anyMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                        e.setType(ArtifactAssembleMatchingTypeEnum.PART.getType());
                        return;
                     }
                  }
               }
            }
         }
      );
      return dtoList.stream().filter(e -> dtoParam.getStatus() == null || e.getType().equals(dtoParam.getStatus())).collect(Collectors.toList());
   }

   @Override
   public PageVO<ArtifactAssembleMatchingDTO> artifactAssembleMatchingPage(ProductKanbanDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.artifactAssembleMatchingList(dtoParam));
   }

   @Override
   public List<AssembleMatchingDTO> machinePartList(List<Long> ids) {
      List<AssembleMatchingDTO> dtoList = new ArrayList<>();
      List<TechArtifact> artifacts = this.artifactService.listByIds(ids);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifacts), "操作失败,所选构件清单不存在!");
      List<TechAssembleDetail> assembleDetailsList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)Wrappers.<TechAssembleDetail>lambdaQuery().in(TechAssembleDetail::getArtifactId, ids));
      List<TechArtifactMachinePartLink> machinePartLinkList = this.machinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().in(TechArtifactMachinePartLink::getArtifactId, ids));
      List<Long> assembleIds = assembleDetailsList.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList());
      List<Long> machinePartIds = machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isEmpty(assembleIds) && CollectionUtils.isEmpty(machinePartIds)) {
         return dtoList;
      }

      Map<Long, MesBuildingWorkshop> workshopMap = this.workshopService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> productionLineMap = this.productionLineService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         List<TechAssemble> assembles = this.assembleService
            .list(
               (Wrapper<TechAssemble>)((new LambdaQueryWrapper<TechAssemble>().in(TechAssemble::getId, assembleIds))
                     .eq(TechAssemble::getBoolProcess, Boolean.TRUE))
                  .eq(TechAssemble::getBoolSendDirectly, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(assembles)) {
            Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getArtifactId, ids));
            if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
               List<Long> assembleTaskIds = mesBuildingTaskNumberLinks.stream()
                  .map(MesBuildingTaskNumberLink::getAssembleTaskId)
                  .distinct()
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(assembleTaskIds)) {
                  List<MesBuildingTask> assembleTasks = this.taskService.listByIds(assembleTaskIds);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleTasks), "操作失败,部件任务不存在!");
                  Map<String, List<MesBuildingTask>> assembleTaskMap = assembleTasks.stream()
                     .collect(Collectors.groupingBy(e -> e.getProductId() + "-" + e.getProductionLineId()));
                  assembleTaskMap.forEach(
                     (productIdAndLine, assembleTaskList) -> {
                        TechAssemble assemble = assembleMap.get(Long.valueOf(productIdAndLine.split("-")[0]));
                        if (assemble != null) {
                           AssembleMatchingDTO assembleMatchingDTO = BeanUtil.copy(assemble, AssembleMatchingDTO.class);
                           List<Long> taskIds = assembleTaskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
                           List<MesBuildingTaskNumberLink> taskNumberLinks = mesBuildingTaskNumberLinks.stream()
                              .filter(e -> taskIds.contains(e.getAssembleTaskId()))
                              .collect(Collectors.toList());
                           assembleMatchingDTO.setTaskQuantity(
                              (int)taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count()
                           );
                           assembleMatchingDTO.setCompanyQuantity(
                              (int)taskNumberLinks.stream()
                                 .filter(MesBuildingTaskNumberLink::getBoolAssembleComplete)
                                 .map(MesBuildingTaskNumberLink::getAssembleNumber)
                                 .distinct()
                                 .count()
                           );
                           MesBuildingProductionLine productionLine = productionLineMap.get(Long.valueOf(productIdAndLine.split("-")[1]));
                           Preconditions.checkArgument(productionLine != null, "生产线不存在!");
                           MesBuildingWorkshop workshop = workshopMap.get(productionLine.getWorkshopId());
                           Preconditions.checkArgument(workshop != null, "操作失败,车间不存在!");
                           assembleMatchingDTO.setWorkShopLineName(workshop.getName() + "/" + productionLine.getName());
                           assembleMatchingDTO.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                           dtoList.add(assembleMatchingDTO);
                        }
                     }
                  );
               }
            }
         }
      }

      if (CollectionUtils.isNotEmpty(machinePartIds)) {
         List<TechMachinePart> machinePartList = this.machinePartService
            .list(
               (Wrapper<TechMachinePart>)((new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, machinePartIds))
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE))
                  .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
            );
         if (CollectionUtils.isEmpty(machinePartList)) {
            return dtoList;
         }

         List<MesBuildingTask> partTasks = this.taskService
            .list(
               (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                     .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                  .in(MesBuildingTask::getProductId, machinePartList.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(partTasks)) {
            Map<Long, TechMachinePart> partMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            Map<String, List<MesBuildingTask>> patTaskMap = partTasks.stream()
               .collect(Collectors.groupingBy(e -> e.getProductId() + "-" + e.getProductionLineId()));
            patTaskMap.forEach((productIdAndLine, partTaskList) -> {
               TechMachinePart partx = partMap.get(Long.valueOf(productIdAndLine.split("-")[0]));
               AssembleMatchingDTO partMatchingDTO = BeanUtil.copy(partx, AssembleMatchingDTO.class);
               partMatchingDTO.setTaskQuantity(partTaskList.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum());
               partMatchingDTO.setCompanyQuantity(partTaskList.stream().mapToInt(MesBuildingTask::getCompleteQuantity).sum());
               MesBuildingProductionLine productionLine = productionLineMap.get(Long.valueOf(productIdAndLine.split("-")[1]));
               Preconditions.checkArgument(productionLine != null, "生产线不存在!");
               MesBuildingWorkshop workshop = workshopMap.get(productionLine.getWorkshopId());
               Preconditions.checkArgument(workshop != null, "操作失败,车间不存在!");
               partMatchingDTO.setWorkShopLineName(workshop.getName() + "/" + productionLine.getName());
               partMatchingDTO.setProductType(ProductTypeEnum.MACHINE_PART.getType());
               dtoList.add(partMatchingDTO);
            });
         }

         if (CollectionUtils.isNotEmpty(partTasks)) {
            List<Long> taskPartIds = partTasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
            machinePartList = machinePartList.stream().filter(e -> !taskPartIds.contains(e.getId())).collect(Collectors.toList());
         }

         if (CollectionUtils.isNotEmpty(machinePartList)) {
            for (TechMachinePart part : machinePartList) {
               AssembleMatchingDTO build = AssembleMatchingDTO.builder()
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .material(part.getMaterial())
                  .serialNumber(part.getSerialNumber())
                  .grossWeight(part.getGrossWeight())
                  .netWeight(part.getNetWeight())
                  .companyQuantity(0)
                  .taskQuantity(0)
                  .specification(part.getSpecification())
                  .length(part.getLength())
                  .workShopLineName("未排产")
                  .build();
               dtoList.add(build);
            }
         }
      }

      return dtoList.stream().sorted(Comparator.comparing(AssembleMatchingDTO::getTaskQuantity)).collect(Collectors.toList());
   }

   @Override
   public List<ProductKanBanInfoDTO> machinePartListV2(List<Long> ids, Integer taskTypeEnum) {
      List<ProductKanBanInfoDTO> dtos = new ArrayList<>();
      if (CollectionUtils.isEmpty(ids)) {
         return dtos;
      }

      Map<Long, Integer> artifactMap = this.artifactService.listByIds(ids).stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getProducedQuantity()));
      if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         Map<String, TechAssembleDetail> artAssDetailMap = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, ids))
            .stream()
            .collect(Collectors.toMap(e -> e.getArtifactId() + "_" + e.getAssembleId(), Function.identity()));
         List<ProductKanBanInfoDTO> artifactAssembleLinkList = this.taskService.findArtifactAssembleLinkInfo(ids);
         Map<Long, List<ProductKanBanInfoDTO>> artifactAssembleLinkMap = artifactAssembleLinkList.stream().collect(Collectors.groupingBy(e -> e.getArtId()));

         for (Entry<Long, List<ProductKanBanInfoDTO>> entry : artifactAssembleLinkMap.entrySet()) {
            for (ProductKanBanInfoDTO productInfoDTO : entry.getValue()) {
               String key = productInfoDTO.getArtId() + "_" + productInfoDTO.getProductId();
               if (artAssDetailMap.get(key) != null) {
                  Integer producedQuantity = artifactMap.get(productInfoDTO.getProductId());
                  if (producedQuantity != null) {
                     int userQuantity = producedQuantity * artAssDetailMap.get(key).getQuantity();
                     productInfoDTO.setUsableQuantity(productInfoDTO.getProducedQuantity() - userQuantity);
                  }
               }
            }

            ProductKanBanInfoDTO dto = new ProductKanBanInfoDTO();
            BeanUtils.copyProperties(entry.getValue().get(0), dto);
            Integer quantitySum = entry.getValue().stream().map(e -> e.getQuantity()).reduce(0, Integer::sum);
            Integer usableQuantitySum = entry.getValue().stream().map(e -> e.getUsableQuantity()).reduce(0, Integer::sum);
            List<String> nameList = entry.getValue().stream().map(e -> e.getTeamLeaderName()).collect(Collectors.toList());
            dto.setQuantity(quantitySum);
            dto.setUsableQuantity(usableQuantitySum);
            dto.setTeamLeaderNames(nameList);
            dto.setProducedQuantity(null);
            dto.setTeamLeaderName(null);
            dtos.add(dto);
         }
      } else if (taskTypeEnum.equals(TaskTypeEnum.MACHINE_PART.getType())) {
      }

      return dtos;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> machinePartListPrint(List<Long> ids) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String serialNumber = this.artifactService.listByIds(ids).stream().map(TechArtifact::getSerialNumber).distinct().collect(Collectors.joining("、"));
      header.put("serialNumber", serialNumber);
      printVO.setHeader(header);
      List<Long> machinePartIds = this.machinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().in(TechArtifactMachinePartLink::getArtifactId, ids))
         .stream()
         .map(TechArtifactMachinePartLink::getMachinePartId)
         .collect(Collectors.toList());
      List<AssembleMatchingDTO> assembleMatchingDTOS = this.machinePartList(ids);
      printVO.setTable(
         CollectionUtils.isEmpty(assembleMatchingDTOS)
            ? new ArrayList<>()
            : assembleMatchingDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<FormSummaryDTO> formSummary(FormSummaryDTOParam dtoParam) {
      return this.taskService
         .formSummary(BeanUtil.copy(dtoParam, FormSummaryDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, FormSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ArtifactAssembleMatchingDTO> areaProductList(Long projectId, Long monomerId, Long areaId) {
      List<ArtifactAssembleMatchingDTO> collect = this.assembleService
         .list(
            (Wrapper<TechAssemble>)((Wrappers.<TechAssemble>lambdaQuery().eq(TechAssemble::getProjectId, projectId))
                  .eq(TechAssemble::getMonomerId, monomerId))
               .eq(TechAssemble::getAreaId, areaId)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactAssembleMatchingDTO.class))
         .collect(Collectors.toList());
      collect.addAll(
         this.machinePartService
            .list(
               (Wrapper<TechMachinePart>)(((Wrappers.<TechMachinePart>lambdaQuery()
                           .eq(TechMachinePart::getProjectId, projectId))
                        .eq(TechMachinePart::getMonomerId, monomerId))
                     .eq(TechMachinePart::getAreaId, areaId))
                  .in(TechMachinePart::getRelationType, 2, 16)
            )
            .stream()
            .map(e -> BeanUtil.copy(e, ArtifactAssembleMatchingDTO.class))
            .collect(Collectors.toList())
      );
      return collect;
   }

   @Override
   public PageVO<ArtifactAssembleMatchingDTO> areaProductListPage(Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.areaProductList(projectId, monomerId, areaId));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> areaProductListPrint(Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(this.areaProductList(projectId, monomerId, areaId).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<ArtifactSummaryDTO> areaArtifactSummary(Long projectId, Long monomerId, Long areaId) {
      return this.artifactService
         .areaArtifactSummary(projectId, monomerId, areaId)
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProductKanBanDTO> appProductDetails(
      Long projectId, Long monomerId, Long areaId, Integer productType, String serialNumber, Integer pageNumber, Integer pageSize, Integer status
   ) {
      ProductKanbanDTOParam dtoParam = ProductKanbanDTOParam.builder()
         .projectId(projectId)
         .monomerId(monomerId)
         .areaId(areaId)
         .status(status)
         .productType(productType)
         .serialNumber(serialNumber)
         .build();
      return this.productKanbanPage(dtoParam, pageNumber, pageSize);
   }

   @Override
   public List<MesBuildingAreaProductDTO> monomerDetails(Long projectId, Long monomerId, Integer productType) {
      ContractProject project = this.projectService.getById(projectId);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      List<PlanArea> areas = this.areaService.list(Wrappers.lambdaQuery(PlanArea.class).eq(monomerId != null, PlanArea::getMonomerId, monomerId));
      new ArrayList();
      return this.getAreaData(project, monomer, areas, productType);
   }

   @Override
   public MesBuildingProjectProductDTO projectDetails(Long projectId, Long monomerId, Long areaId) {
      MesBuildingProjectProductDTO build = MesBuildingProjectProductDTO.builder().build();
      ContractProject project = this.projectService.getById(projectId);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      List<PlanArea> areas = this.areaService
         .list(
            Wrappers.lambdaQuery(PlanArea.class)
               .eq(projectId != null, PlanArea::getProjectId, projectId)
               .eq(monomerId != null, PlanArea::getMonomerId, monomerId)
               .eq(areaId != null, PlanArea::getId, areaId)
         );
      List<MesBuildingAreaProductDTO> machineParts = this.getAreaData(project, monomer, areas, TaskTypeEnum.MACHINE_PART.getType());
      List<MesBuildingAreaProductDTO> assembles = this.getAreaData(project, monomer, areas, TaskTypeEnum.ASSEMBLE.getType());
      List<MesBuildingAreaProductDTO> artifacts = this.getAreaData(project, monomer, areas, TaskTypeEnum.ARTIFACT.getType());
      List<Long> areaIds = areas.stream().map(PlanArea::getId).collect(Collectors.toList());
      List<MesBuildingAreaProductDTO> installs = this.installSummaryService.getAreaInstallData(areaIds, TaskTypeEnum.ARTIFACT.getType());
      List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetailDTOS = this.mesBuildingCargoListService
         .projectCargoListMeteDetail(projectId, monomerId, areaId, null, null, null, null, null);
      MesBuildingAreaProductDTO machinePartData = MesBuildingAreaProductDTO.builder()
         .listQuantity(machineParts.stream().mapToInt(MesBuildingAreaProductDTO::getListQuantity).sum())
         .listWeight(machineParts.stream().map(MesBuildingAreaProductDTO::getListWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeQuantity(machineParts.stream().mapToInt(MesBuildingAreaProductDTO::getCompleteQuantity).sum())
         .completeWeight(machineParts.stream().map(MesBuildingAreaProductDTO::getCompleteWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
      build.setMachinePartData(machinePartData);
      MesBuildingAreaProductDTO assembleData = MesBuildingAreaProductDTO.builder()
         .listQuantity(assembles.stream().mapToInt(MesBuildingAreaProductDTO::getListQuantity).sum())
         .listWeight(assembles.stream().map(MesBuildingAreaProductDTO::getListWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeQuantity(assembles.stream().mapToInt(MesBuildingAreaProductDTO::getCompleteQuantity).sum())
         .completeWeight(assembles.stream().map(MesBuildingAreaProductDTO::getCompleteWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
      build.setAssembleData(assembleData);
      MesBuildingAreaProductDTO artifactData = MesBuildingAreaProductDTO.builder()
         .listQuantity(artifacts.stream().mapToInt(MesBuildingAreaProductDTO::getListQuantity).sum())
         .listWeight(artifacts.stream().map(MesBuildingAreaProductDTO::getListWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeQuantity(artifacts.stream().mapToInt(MesBuildingAreaProductDTO::getCompleteQuantity).sum())
         .completeWeight(artifacts.stream().map(MesBuildingAreaProductDTO::getCompleteWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
      build.setArtifactData(artifactData);
      MesBuildingAreaProductDTO installData = MesBuildingAreaProductDTO.builder()
         .listQuantity(installs.stream().mapToInt(MesBuildingAreaProductDTO::getListQuantity).sum())
         .listWeight(installs.stream().map(MesBuildingAreaProductDTO::getListWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeQuantity(installs.stream().mapToInt(MesBuildingAreaProductDTO::getCompleteQuantity).sum())
         .completeWeight(installs.stream().map(MesBuildingAreaProductDTO::getCompleteWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
      build.setInstallData(installData);
      MesBuildingAreaProductDTO carGoData = MesBuildingAreaProductDTO.builder()
         .listQuantity(projectCargoListMeteDetailDTOS.stream().mapToInt(ProjectCargoListMeteDetailDTO::getQuantity).sum())
         .listWeight(projectCargoListMeteDetailDTOS.stream().map(ProjectCargoListMeteDetailDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeQuantity(projectCargoListMeteDetailDTOS.stream().mapToInt(ProjectCargoListMeteDetailDTO::getCargoQuantity).sum())
         .completeWeight(projectCargoListMeteDetailDTOS.stream().map(ProjectCargoListMeteDetailDTO::getCargoNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
      build.setCarGoData(carGoData);
      return build;
   }

   public List<MesBuildingAreaProductDTO> getAreaData(ContractProject project, PlanMonomer monomer, List<PlanArea> areas, Integer productType) {
      List<MesBuildingAreaProductDTO> productDTOS = new ArrayList<>();
      if (CollectionUtils.isEmpty(areas)) {
         return productDTOS;
      }

      List<MesBuildingComplete> settingToAssemle = new ArrayList<>();
      List<Long> areaIds = areas.stream().map(PlanArea::getId).collect(Collectors.toList());
      Map<Long, List<MesBuildingComplete>> areaMap = settingToAssemle.stream().collect(Collectors.groupingBy(MesBuildingComplete::getAreaId));
      Map<String, List<MesBuildingComplete>> completeMap = this.mesBuildingCompleteService
         .list(
            Wrappers.lambdaQuery(MesBuildingComplete.class).in(MesBuildingComplete::getAreaId, areaIds).eq(MesBuildingComplete::getTaskTypeEnum, productType)
         )
         .stream()
         .collect(Collectors.groupingBy(e -> e.getAreaId() + "-" + e.getTaskTypeEnum()));
      Map<Long, List<TechMachinePart>> machinePartMap = new HashMap<>();
      Map<Long, List<TechAssemble>> assembleMap = new HashMap<>();
      Map<Long, List<TechArtifact>> artifactMap = new HashMap<>();
      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         machinePartMap = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .in(TechMachinePart::getAreaId, areaIds)
                  .eq(TechMachinePart::getBoolSchedulingEnum, true)
                  .in(TechMachinePart::getRelationType, 2, 16)
            )
            .stream()
            .collect(Collectors.groupingBy(TechMachinePart::getAreaId));
      }

      if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         assembleMap = this.assembleService
            .list(Wrappers.lambdaQuery(TechAssemble.class).in(TechAssemble::getAreaId, areaIds).eq(TechAssemble::getBoolSchedulingEnum, true))
            .stream()
            .collect(Collectors.groupingBy(TechAssemble::getAreaId));
      }

      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         artifactMap = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getAreaId, areaIds))
            .stream()
            .collect(Collectors.groupingBy(TechArtifact::getAreaId));
      }

      for (PlanArea area : areas) {
         int allQuantity = 0;
         BigDecimal allWeight = BigDecimal.ZERO;
         int productQuantity = 0;
         BigDecimal productWeight = BigDecimal.ZERO;
         List<MesBuildingComplete> buildingCompletes = completeMap.getOrDefault(area.getId() + "-" + productType, new ArrayList<>());
         if (productType.equals(TaskTypeEnum.ASSEMBLE.getType()) && CollectionUtils.isNotEmpty(areaMap.get(area.getId()))) {
            buildingCompletes.addAll(areaMap.get(area.getId()));
         }

         Map<Long, List<MesBuildingComplete>> productMap = buildingCompletes.stream().collect(Collectors.groupingBy(MesBuildingComplete::getProductId));
         if (productType.equals(TaskTypeEnum.MACHINE_PART.getType())) {
            List<Integer> relationType = new ArrayList<>();
            relationType.add(2);
            relationType.add(16);
            List<TechMachinePart> techMachineParts = machinePartMap.getOrDefault(area.getId(), new ArrayList<>());
            Map<Long, TechMachinePart> allMap = techMachineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

            for (Long productId : techMachineParts.stream().map(TechMachinePart::getId).collect(Collectors.toList())) {
               Integer quantity = allMap.get(productId).getQuantity();
               Integer producedQuantity = allMap.get(productId).getProducedQuantity();
               allQuantity += quantity;
               productQuantity += producedQuantity;
               allWeight = allWeight.add(allMap.get(productId).getNetWeight().multiply(new BigDecimal(quantity))).setScale(5, 5);
               productWeight = productWeight.add(allMap.get(productId).getNetWeight().multiply(new BigDecimal(producedQuantity))).setScale(5, 5);
            }
         } else if (productType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
            List<TechAssemble> techAssembles = assembleMap.getOrDefault(area.getId(), new ArrayList<>());
            Map<Long, TechAssemble> allMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

            for (Long productId : techAssembles.stream().map(TechAssemble::getId).collect(Collectors.toList())) {
               if (productMap.get(productId) != null) {
                  productWeight = productWeight.add(
                        allMap.get(productId)
                           .getNetWeight()
                           .multiply(new BigDecimal(productMap.get(productId).stream().mapToInt(MesBuildingComplete::getQuantity).sum()))
                     )
                     .setScale(5, 5);
                  productQuantity += productMap.get(productId).stream().mapToInt(MesBuildingComplete::getQuantity).sum();
               }

               Integer quantity = allMap.get(productId).getQuantity();
               allQuantity += quantity;
               allWeight = allWeight.add(allMap.get(productId).getNetWeight().multiply(new BigDecimal(quantity))).setScale(5, 5);
            }
         } else if (productType.equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<TechArtifact> techArtifacts = artifactMap.getOrDefault(area.getId(), new ArrayList<>());
            Map<Long, TechArtifact> allMap = techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));

            for (Long productId : techArtifacts.stream().map(TechArtifact::getId).collect(Collectors.toList())) {
               if (productMap.get(productId) != null) {
                  productWeight = productWeight.add(
                        allMap.get(productId)
                           .getNetWeight()
                           .multiply(new BigDecimal(productMap.get(productId).stream().mapToInt(MesBuildingComplete::getQuantity).sum()))
                     )
                     .setScale(5, 5);
                  productQuantity += productMap.get(productId).stream().mapToInt(MesBuildingComplete::getQuantity).sum();
               }

               Integer quantity = allMap.get(productId).getQuantity();
               allQuantity += quantity;
               allWeight = allWeight.add(allMap.get(productId).getNetWeight().multiply(new BigDecimal(quantity))).setScale(5, 5);
            }
         }

         MesBuildingAreaProductDTO build = MesBuildingAreaProductDTO.builder()
            .areaId(area.getId())
            .areaName(area.getName())
            .listQuantity(allQuantity)
            .listWeight(allWeight)
            .completeQuantity(productQuantity)
            .completeWeight(productWeight)
            .build();
         if (monomer != null) {
            build.setMonomerId(monomer.getId());
            build.setMonomerName(monomer.getName());
         }

         productDTOS.add(build);
      }

      return productDTOS;
   }

   @Override
   public ArtifactKanbanDetailDTO getArtifactKanbanInfo(Long productId) {
      List<ArtifactKanbanDetailDTO> artKanbanList = this.taskService.getArtifactKanbanInfo(productId);
      if (artKanbanList.isEmpty()) {
         return null;
      }

      Map<String, List<ArtifactKanbanDetailDTO>> artKanbanMap = artKanbanList.stream()
         .collect(Collectors.groupingBy(e -> e.getSerialNumber() + e.getSpecification()));
      ArtifactKanbanDetailDTO artDTO = this.summarizeArtifactData(artKanbanMap);
      List<ProductKanBanInfoDTO> artifactAssembleLinkList = this.taskService.findArtifactAssembleLinkInfo(Arrays.asList(productId));
      if (artifactAssembleLinkList.isEmpty()) {
         artDTO.setProductKanBanInfos(Collections.emptyList());
      } else {
         Map<String, List<ProductKanBanInfoDTO>> artifactAssembleLinkMap = artifactAssembleLinkList.stream()
            .collect(Collectors.groupingBy(e -> e.getSerialNumber() + e.getSpecification()));
         List<ProductKanBanInfoDTO> dtos = this.summarizeArtifactAssembleLinkData(artifactAssembleLinkMap);
         artDTO.setProductKanBanInfos(dtos);
      }

      return artDTO;
   }

   private ArtifactKanbanDetailDTO summarizeArtifactData(Map<String, List<ArtifactKanbanDetailDTO>> map) {
      ArtifactKanbanDetailDTO artDTO = new ArtifactKanbanDetailDTO();

      for (Entry<String, List<ArtifactKanbanDetailDTO>> entry : map.entrySet()) {
         Optional<ArtifactKanbanDetailDTO> firstElement = entry.getValue().stream().findFirst();
         firstElement.ifPresent(dto -> BeanUtils.copyProperties(dto, artDTO));
         Integer quantitySum = entry.getValue().stream().mapToInt(e -> e.getQuantity()).sum();
         Integer producedQuantitiySum = entry.getValue().stream().mapToInt(e -> e.getProducedQuantity()).sum();
         List<String> nameList = entry.getValue().stream().map(e -> e.getTeamLeaderName()).collect(Collectors.toList());
         artDTO.setQuantity(quantitySum);
         artDTO.setProducedQuantity(producedQuantitiySum);
         artDTO.setTeamLeaderNames(nameList);
         artDTO.setTeamLeaderName(null);
      }

      return artDTO;
   }

   private List<ProductKanBanInfoDTO> summarizeArtifactAssembleLinkData(Map<String, List<ProductKanBanInfoDTO>> map) {
      List<ProductKanBanInfoDTO> dtos = new ArrayList<>();

      for (Entry<String, List<ProductKanBanInfoDTO>> entry : map.entrySet()) {
         ProductKanBanInfoDTO dto = new ProductKanBanInfoDTO();
         Optional<ProductKanBanInfoDTO> firstElement = entry.getValue().stream().findFirst();
         firstElement.ifPresent(d -> BeanUtils.copyProperties(d, dto));
         Integer quantitySum = entry.getValue().stream().mapToInt(e -> e.getQuantity()).sum();
         Integer producedQuantitiySum = entry.getValue().stream().mapToInt(e -> e.getProducedQuantity()).sum();
         List<String> nameList = entry.getValue().stream().map(e -> e.getTeamLeaderName()).collect(Collectors.toList());
         dto.setQuantity(quantitySum);
         dto.setProducedQuantity(producedQuantitiySum);
         dto.setTeamLeaderNames(nameList);
         dto.setTeamLeaderName(null);
         dtos.add(dto);
      }

      return dtos;
   }
}
