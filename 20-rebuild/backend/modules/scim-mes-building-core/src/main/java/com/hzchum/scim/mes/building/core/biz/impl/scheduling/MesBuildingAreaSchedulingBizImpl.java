package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import cn.hutool.core.lang.Pair;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.utils.ListPageUtil;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingFactoryBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWorkshopBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingAreaSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingAreaScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.AreaSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.AssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSchedulingTreeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.SchedulingDataSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.productionLineInformationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingAreaSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingAreaSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingAreaSchedulingMapper;
import com.hzchum.scim.plan.core.api.biz.TechArtifactBiz;
import com.hzchum.scim.plan.core.api.biz.TechAssembleBiz;
import com.hzchum.scim.plan.core.api.biz.TechMachinePartBiz;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductMetesDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingAreaSchedulingBizImpl
   extends IBizImpl<MesBuildingAreaSchedulingService, MesBuildingAreaSchedulingMapper, MesBuildingAreaScheduling>
   implements MesBuildingAreaSchedulingBiz {
   @Resource
   private PlanAreaBatchService planAreaBatchService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private ContractProjectBiz contractProjectBiz;
   @Autowired
   private TechArtifactBiz techArtifactBiz;
   @Autowired
   private TechAssembleBiz techAssembleBiz;
   @Autowired
   private TechMachinePartBiz techMachinePartBiz;
   @Autowired
   private SysSteelClassificationBiz steelClassificationBiz;
   @Autowired
   private MesBuildingProductionLineBiz mesBuildingProductionLineBiz;
   @Autowired
   private MesBuildingArtifactSchedulingBiz artifactSchedulingBiz;
   @Autowired
   private MesBuildingFactoryBiz mesBuildingFactoryBiz;
   @Autowired
   private MesBuildingWorkshopBiz mesBuildingWorkshopBiz;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;

   @Override
   public List<ProjectSchedulingDTO> getProjectScheduling(
      LocalDateTime dateTime, Integer status, LocalDateTime endDate, List<LocalDateTime> endTimeList, List<Long> projectIds
   ) {
      return this.baseService
         .getProjectScheduling(dateTime, status, endDate, endTimeList, projectIds)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectSchedulingDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectSchedulingDTO> getProjectSchedulingPage(
      LocalDateTime dateTime,
      Integer status,
      LocalDateTime endDate,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize,
      Integer month,
      Long projectId,
      Integer level
   ) {
      List<LocalDateTime> endTimeList = month == null ? null : Arrays.asList(LocalDateTime.now(), LocalDateTime.now().minusMonths(month.intValue()));
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(projectType, null, lumpSumSystemType, level)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() != 0 && (projectId == null || projectIds.contains(projectId))) {
         List<Long> queryProjectIds = projectId == null ? projectIds : Collections.singletonList(projectId);
         List<ProjectSchedulingDTO> dtoList = this.getProjectScheduling(dateTime, status, endDate, endTimeList, queryProjectIds);
         return ListPageUtil.getPages(pageNumber, pageSize, dtoList);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public List<AreaSchedulingDTO> getAreaSchedulingList(Integer projectId, Integer projectType) {
      List<AreaSchedulingDTO> areaSchedulingDTOS = this.baseService
         .getAreaSchedulingList(projectId, projectType)
         .stream()
         .map(e -> BeanUtil.copy(e, AreaSchedulingDTO.class))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(areaSchedulingDTOS)) {
         Map<Long, List<AreaSchedulingDTO>> monomerSchedulingDTOMap = areaSchedulingDTOS.stream().collect(Collectors.groupingBy(e -> e.getMonomer().getId()));

         for (AreaSchedulingDTO schedulingDTO : areaSchedulingDTOS) {
            List<AreaSchedulingDTO> schedulingDTOList = monomerSchedulingDTOMap.get(schedulingDTO.getMonomer().getId());
            MonomerDetailDO monomer = schedulingDTO.getMonomer();
            monomer.setNetWeight(schedulingDTOList.stream().map(AreaSchedulingDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         }
      }

      return areaSchedulingDTOS;
   }

   @Override
   public PageVO<AreaSchedulingDTO> getAreaSchedulingPage(Integer projectId, Integer projectType, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getAreaSchedulingList(projectId, projectType));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateAreaScheduling(List<MesBuildingAreaSchedulingDTOParam> dtoParamList) {
      Long projectId = dtoParamList.get(0).getProjectId();
      ContractProject project = this.contractProjectService.getById(projectId);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      dtoParamList.forEach(
         e -> {
            if (e.getId() != null && e.getWorkshopId() == null && e.getEndDate() == null) {
               this.baseService.removeById(e.getId());
            } else if (e.getWorkshopId() != null) {
               PlanAreaBatch areaBatch = this.planAreaBatchService.getById(e.getAreaBatchId());
               Preconditions.checkArgument(areaBatch != null, "操作失败,批次不存在!");
               MesBuildingAreaScheduling areaScheduling = this.baseService
                  .getOne(Wrappers.lambdaQuery(MesBuildingAreaScheduling.class).eq(MesBuildingAreaScheduling::getId, e.getId()));
               MesBuildingWorkshop workshop = this.mesBuildingWorkshopBiz.getById(e.getWorkshopId());
               Preconditions.checkArgument(workshop != null, "车间不存在");
               if (areaScheduling != null && areaScheduling.getStartDate() != null && e.getStartDate() == null) {
                  List<MesBuildingArtifactScheduling> schedulingList = this.artifactSchedulingBiz
                     .list(
                        Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                           .eq(MesBuildingArtifactScheduling::getWorkshopId, areaScheduling.getWorkshopId())
                     );
                  Preconditions.checkArgument(schedulingList.size() == 0, "操作失败：批次下构件已排产，无法删除排产时间");
               }

               PlanMonomer monomer = this.monomerService.getById(areaBatch.getMonomerId());
               Preconditions.checkArgument(
                  monomer.getBuildingTypeEnum() != null && !monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.UNKNOWN.getType()),
                  "操作失败,单体" + monomer.getName() + "未导入清单!"
               );
               Integer mesProductTypeByType = BuildingTypeEnum.getMesProductTypeByType(monomer.getBuildingTypeEnum());
               Preconditions.checkArgument(workshop.getType().equals(mesProductTypeByType), "操作失败,单体[" + monomer.getName() + "]的清单类型与所选车间类型不一致!");
               this.baseService
                  .saveOrUpdate(
                     MesBuildingAreaScheduling.builder()
                        .id(areaScheduling == null ? null : areaScheduling.getId())
                        .productType(ProductTypeEnum.ARTIFACT.getType())
                        .projectId(e.getProjectId())
                        .monomerId(e.getMonomerId())
                        .areaId(e.getAreaId())
                        .areaBatchId(e.getAreaBatchId())
                        .factoryId(workshop.getFactoryId())
                        .workshopId(e.getWorkshopId())
                        .productionLineId(e.getProductionLineId())
                        .userId(UserUtil.getCurrentUserId())
                        .startDate(e.getStartDate())
                        .endDate(e.getEndDate())
                        .startTime(e.getStartTime())
                        .build()
                  );
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public List<ComponentCrderInformationDTO> getComponentsDetailed(Integer productType, Long projectId) {
      ContractProject contractProject = this.contractProjectBiz.getById(projectId);
      Preconditions.checkArgument(contractProject != null, "项目不存在");
      List<ComponentCrderInformationDTO> componentCrderInformationDTO = null;
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         componentCrderInformationDTO = this.techArtifactBiz.selectByProjectId(projectId);
      }

      if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         componentCrderInformationDTO = this.techAssembleBiz.selectByProjectId(projectId);
      }

      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         List<Long> collect = this.steelClassificationBiz
            .list(null, null, null)
            .stream()
            .filter(s -> s.getBasicClass().equals(1))
            .map(e -> e.getId())
            .collect(Collectors.toList());
         componentCrderInformationDTO = this.techMachinePartBiz.selectByProjectId(projectId);

         for (ComponentCrderInformationDTO crderInformationDTO : componentCrderInformationDTO) {
            if (collect.contains(crderInformationDTO.getClassificationId())) {
               List<TechMachinePart> list = this.machinePartService
                  .list(
                     Wrappers.lambdaQuery(TechMachinePart.class)
                        .eq(TechMachinePart::getSteelId, crderInformationDTO.getClassificationId())
                        .eq(TechMachinePart::getMaterial, crderInformationDTO.getMaterial())
                        .eq(TechMachinePart::getProjectId, projectId)
                  );
               List<String> stringList = list.stream()
                  .map(e -> this.getSpec(e.getSpecification(), e.getSpecPrefix()))
                  .distinct()
                  .sorted()
                  .collect(Collectors.toList());
               crderInformationDTO.setSpecifications(stringList);
            }
         }
      }

      return componentCrderInformationDTO;
   }

   @Override
   public ProductMetesDTO getSumMeteByCondition(Long projectId) {
      ProductMeteDTO machinePart = this.baseService.getSumMeteByCondition(projectId, ProductTypeEnum.MACHINE_PART.getType());
      ProductMeteDTO artifact = this.baseService.getSumMeteByCondition(projectId, ProductTypeEnum.ARTIFACT.getType());
      ProductMeteDTO assemble = this.baseService.getSumMeteByCondition(projectId, ProductTypeEnum.ASSEMBLE.getType());
      return ProductMetesDTO.builder()
         .artifactMete(artifact.getMete())
         .artifactQuantity(artifact.getQuantity())
         .assembleQuantity(assemble.getQuantity())
         .assembleMete(assemble.getMete())
         .machinePartMete(machinePart.getMete())
         .machinePartQuantity(machinePart.getQuantity())
         .build();
   }

   @Override
   public List<ArtifactDTO> getArtifactList(String classificationName, String material, Long projectId) {
      return this.artifactService
         .getArtifactList(classificationName, material, projectId)
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<AssembleDTO> getAssembleList(String classificationName, String material, Long projectId) {
      return this.assembleService
         .getAssembleList(classificationName, material, projectId)
         .stream()
         .map(e -> BeanUtil.copy(e, AssembleDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MachinePartDTO> getMachinePartList(String classificationName, String material, String specification, Boolean boolHaveHole, Long projectId) {
      return this.machinePartService
         .getMachinePartList(classificationName, material, specification, boolHaveHole, projectId)
         .stream()
         .map(e -> BeanUtil.copy(e, MachinePartDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<productionLineInformationDTO> productionLineInformation(Long projectId, Long factoryId) {
      ContractProject contractProject = this.contractProjectBiz.getById(projectId);
      Preconditions.checkArgument(contractProject != null, "项目不存在");
      List<MesBuildingProductionLine> lines = this.mesBuildingProductionLineBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingProductionLine.class)
               .eq(MesBuildingProductionLine::getBoolEnabledEnum, 1)
               .orderByAsc(MesBuildingProductionLine::getFactoryId)
         );
      if (factoryId != null) {
         lines = lines.stream().filter(e -> e.getFactoryId().equals(factoryId)).collect(Collectors.toList());
      }

      List<productionLineInformationDTO> productionLineInformationDTOS = new ArrayList<>();

      for (MesBuildingProductionLine line : lines) {
         Long allocationWeight = 0L;
         Long completionWeight = 0L;
         Long unCompletionWeight = 0L;
         ProductLineSummary artifactSummary = this.techArtifactBiz.selectByProjectIdAndLine(line.getId(), projectId, ProductTypeEnum.ARTIFACT.getType());
         if (artifactSummary != null) {
            allocationWeight = allocationWeight + artifactSummary.getAllocationWeight();
            completionWeight = completionWeight + artifactSummary.getCompletionWeight();
            unCompletionWeight = unCompletionWeight + artifactSummary.getUnCompletionWeight();
         }

         ProductLineSummary techAssembleSummary = this.techArtifactBiz.selectByProjectIdAndLine(line.getId(), projectId, ProductTypeEnum.ASSEMBLE.getType());
         if (techAssembleSummary != null) {
            allocationWeight = allocationWeight + techAssembleSummary.getAllocationWeight();
            completionWeight = completionWeight + techAssembleSummary.getCompletionWeight();
            unCompletionWeight = unCompletionWeight + techAssembleSummary.getUnCompletionWeight();
         }

         ProductLineSummary machinePartSummary = this.techArtifactBiz.selectByProjectIdAndLine(line.getId(), projectId, ProductTypeEnum.MACHINE_PART.getType());
         if (machinePartSummary != null) {
            allocationWeight = allocationWeight + machinePartSummary.getAllocationWeight();
            completionWeight = completionWeight + machinePartSummary.getCompletionWeight();
            unCompletionWeight = unCompletionWeight + machinePartSummary.getUnCompletionWeight();
         }

         productionLineInformationDTO copy = BeanUtil.copy(line, productionLineInformationDTO.class);
         copy.setCapacity(line.getTargetProduction());
         copy.setIncomplete(unCompletionWeight);
         copy.setCompleted(completionWeight);
         copy.setAllocationWeight(allocationWeight);
         copy.setProductionLineId(line.getId());
         copy.setProductionLineName(line.getName());
         copy.setFactoryName(this.mesBuildingFactoryBiz.getById(line.getFactoryId()).getName());
         copy.setWorkshopName(this.mesBuildingWorkshopBiz.getById(line.getWorkshopId()).getName());
         copy.setDate(LocalDateTime.now());
         productionLineInformationDTOS.add(copy);
      }

      return productionLineInformationDTOS;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printArtifactByCondition(String classificationName, String material, Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("date", LocalDateTime.now());
      printVO.setHeader(header);
      List<ArtifactDTO> artifactList = this.getArtifactList(classificationName, material, projectId);
      List<Map<String, Object>> mapList = artifactList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printAssembleByCondition(String classificationName, String material, Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("date", LocalDateTime.now());
      printVO.setHeader(header);
      List<AssembleDTO> assembleList = this.getAssembleList(classificationName, material, projectId);
      List<Map<String, Object>> mapList = assembleList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printMachinePartByCondition(
      String classificationName, String material, String specification, Boolean boolHaveHole, Long projectId
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("date", LocalDateTime.now());
      printVO.setHeader(header);
      List<MachinePartDTO> machinePartList = this.getMachinePartList(classificationName, material, specification, boolHaveHole, projectId);
      List<Map<String, Object>> mapList = machinePartList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ProjectSummaryDTO getProjectSchedulingSummay(
      LocalDateTime dateTime, Integer status, LocalDateTime endDate, Integer month, Long projectId, Integer projectType, Integer lumpSumSystemType
   ) {
      List<LocalDateTime> endTimeList = month == null ? null : Arrays.asList(LocalDateTime.now(), LocalDateTime.now().minusMonths(month.intValue()));
      new ArrayList();
      List projectIds;
      if (projectId == null) {
         projectIds = this.contractProjectService
            .listSimpleProject(projectType, null, lumpSumSystemType, null)
            .getContent()
            .stream()
            .map(ProjectSimpleInfoDTO::getId)
            .collect(Collectors.toList());
      } else {
         projectIds = Arrays.asList(projectId);
      }

      if (projectIds.size() == 0) {
         return ProjectSummaryDTO.builder()
            .projectQuantity(0)
            .projectQuantity(0)
            .schedulingTotalNetWeight(new BigDecimal(0))
            .schedulingTotalNetWeight(new BigDecimal(0))
            .build();
      }

      List<ProjectSchedulingDTO> projectScheduling = this.getProjectScheduling(dateTime, status, endDate, endTimeList, projectIds);
      BigDecimal projectQuantityWeight = projectScheduling.stream().map(s -> s.getTotalNetWeight()).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal schedulingTotalNetWeight = projectScheduling.stream().map(s -> s.getSchedulingTotalNetWeight()).reduce(BigDecimal.ZERO, BigDecimal::add);
      return ProjectSummaryDTO.builder()
         .projectQuantity(projectScheduling.size())
         .projectQuantityWeight(projectQuantityWeight)
         .schedulingTotalNetWeight(schedulingTotalNetWeight)
         .unSchedulingTotalNetWeight(projectQuantityWeight.subtract(schedulingTotalNetWeight))
         .build();
   }

   private String getSpec(String specification, String specPrefix) {
      int separatorIndex = specification.indexOf("*");
      return specification.substring(specPrefix.length(), separatorIndex < 0 ? specification.length() : separatorIndex);
   }

   @Override
   public List<String> getSchedulingTime(Integer projectType, Integer lumpSumSystemType, Long workshopId, Integer level) {
      List<String> date = new ArrayList<>();
      this.getScheduling(null, projectType, lumpSumSystemType, workshopId, level)
         .forEach(
            project -> project.getMonomerSchedulingTreeDO()
               .forEach(
                  monomer -> monomer.getAreaSchedulingTreeDO()
                     .stream()
                     .filter(s -> s.getEndDate() != null)
                     .forEach(area -> date.add(area.getEndDate().format(DateTimeFormatter.ofPattern("yyyy/MM"))))
               )
         );
      return date.stream().distinct().sorted().collect(Collectors.toList());
   }

   @Override
   public List<ProjectSchedulingTreeDTO> getProjectScheduling(
      LocalDateTime dateTime, Integer projectType, Integer lumpSumSystemType, Long workshopId, Integer level
   ) {
      return this.getScheduling(dateTime, projectType, lumpSumSystemType, workshopId, level);
   }

   @Override
   public List<ProjectSchedulingTreeDTO> getScheduling(LocalDateTime dateTime, Integer projectType, Integer lumpSumSystemType, Long workshopId, Integer level) {
      List<ProjectSchedulingTreeDO> scheduling = this.baseService.getScheduling(dateTime, projectType, workshopId);
      List<ProjectSchedulingTreeDTO> collect = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(scheduling)) {
         List<ProjectSimpleInfoDTO> dtoList = this.contractProjectService
            .listSimpleProject(projectType, null, lumpSumSystemType, level)
            .getContent()
            .stream()
            .filter(e -> !e.getStatus().equals(ProjectStatusEnum.COMPLETED.getType()))
            .collect(Collectors.toList());
         List<Long> pids = dtoList.stream().map(ProjectSimpleInfoDTO::getId).collect(Collectors.toList());
         collect = scheduling.stream()
            .map(e -> BeanUtil.copy(e, ProjectSchedulingTreeDTO.class))
            .collect(Collectors.toList())
            .stream()
            .filter(s -> pids.contains(s.getId()))
            .collect(Collectors.toList());
      }

      return collect;
   }

   @Override
   public List<WorkshopDetailDO> getSchedulingWorkshop(Integer projectType, Integer lumpSumSystemType, Integer level) {
      List<WorkshopDetailDO> collect = this.getScheduling(null, null, null, null, level)
         .stream()
         .map(s -> s.getMonomerSchedulingTreeDO())
         .flatMap(Collection::stream)
         .map(s -> s.getAreaSchedulingTreeDO())
         .flatMap(Collection::stream)
         .map(s -> s.getWorkshop())
         .distinct()
         .collect(Collectors.toList());
      collect.removeAll(Collections.singleton(null));
      return collect;
   }

   @Override
   public SchedulingDataSummaryDTO getSchedulingDataSummary(Long factoryId, Long workshopId, LocalDateTime dateTime, Integer level) {
      List<ProjectSchedulingTreeDTO> scheduling = this.getScheduling(dateTime, null, null, workshopId, level);
      if (CollectionUtils.isEmpty(scheduling)) {
         return this.createEmptySummary();
      }

      Map<Long, Pair<Integer, BigDecimal>> projectQuantityMap = scheduling.stream()
         .collect(
            Collectors.toMap(
               ProjectDetailDO::getId,
               project -> {
                  int sum = project.getMonomerSchedulingTreeDO()
                     .stream()
                     .flatMap(monomer -> monomer.getAreaSchedulingTreeDO().stream())
                     .mapToInt(area -> area.getQuantity())
                     .sum();
                  BigDecimal reduce = project.getMonomerSchedulingTreeDO()
                     .stream()
                     .flatMap(monomer -> monomer.getAreaSchedulingTreeDO().stream().map(s -> s.getTotalNetWeight()))
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  return new Pair<>(sum, reduce);
               },
               (pair1, pair2) -> new Pair<>((Integer)pair1.getKey() + (Integer)pair2.getKey(), ((BigDecimal)pair1.getValue()).add((BigDecimal)pair2.getValue())),
               LinkedHashMap::new
            )
         );
      long projectCount = projectQuantityMap.keySet().size();
      int quantity = projectQuantityMap.values().stream().mapToInt(Pair::getKey).sum();
      BigDecimal totalNetWeight = projectQuantityMap.values().stream().map(Pair::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);
      return SchedulingDataSummaryDTO.builder().projectCount(projectCount).quantity(quantity).totalWeight(totalNetWeight.divide(new BigDecimal(1000))).build();
   }

   private SchedulingDataSummaryDTO createEmptySummary() {
      return SchedulingDataSummaryDTO.builder().projectCount(0L).quantity(0).totalWeight(BigDecimal.ZERO).build();
   }
}
