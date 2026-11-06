package com.hzchum.scim.plan.core.service.impl;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSummaryExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.mapper.TechMachinePartMapper;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechMachinePartServiceImpl extends ServiceImpl<TechMachinePartMapper, TechMachinePart> implements TechMachinePartService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private SysSteelClassificationMatchService classificationMatchService;
   @Resource
   private SysSteelClassificationService classificationService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;

   @Override
   public List<MachinePartResponseDTO> listByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum
   ) {
      return this.baseMapper
         .selectListByCondition(projectId, monomerId, areaId, areaBatchId, status, type, serialNumber, specification, material, thick, steelPlateTypeEnum);
   }

   @Override
   public List<MachinePartResponseExportDTO> listByConditionExport(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum
   ) {
      return this.baseMapper
         .selectListByConditionExport(projectId, monomerId, areaId, areaBatchId, status, type, serialNumber, specification, material, thick, steelPlateTypeEnum);
   }

   @Override
   public List<TechMachinePartDTO> listMachinePartByArtifact(Long artifactId) {
      List<TechMachinePartDTO> techMachinePartDTOS = this.baseMapper.selectByArtifactId(artifactId);
      List<TechMachinePartDTO> assemblePartDTOs = techMachinePartDTOS.stream()
         .filter(e -> ProductTypeEnum.ASSEMBLE.getType().equals(e.getProductType()))
         .collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(assemblePartDTOs)) {
         List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
            .list(
               (Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>()
                  .in(TechAssembleMachinePartLink::getAssembleId, assemblePartDTOs.stream().map(TechMachinePartDTO::getId).collect(Collectors.toList()))
            );
         if (CollectionUtil.isNotEmpty(assembleMachinePartLinks)) {
            Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkMap = assembleMachinePartLinks.stream()
               .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
            List<TechMachinePart> machinePartList = this.baseMapper
               .selectBatchIds(assembleMachinePartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList()));
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(machinePartList), "查询失败,零件不存在!");
            Map<Long, TechMachinePart> partMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

            for (TechMachinePartDTO machinePartDTO : techMachinePartDTOS) {
               if (ProductTypeEnum.ASSEMBLE.getType().equals(machinePartDTO.getProductType())) {
                  List<TechAssembleMachinePartLink> techAssembleMachinePartLinks = assembleMachinePartLinkMap.get(machinePartDTO.getId());
                  if (CollectionUtil.isNotEmpty(techAssembleMachinePartLinks)) {
                     List<TechMachinePartDTO> assembleMachinePartDTOList = techAssembleMachinePartLinks.stream()
                        .map(
                           link -> {
                              TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                              TechMachinePartDTO techMachinePartDTO = BeanUtil.copy(machinePart, TechMachinePartDTO.class);
                              techMachinePartDTO.setQuantity(machinePartDTO.getQuantity() * link.getQuantity());
                              techMachinePartDTO.setUserName(machinePartDTO.getUserName());
                              techMachinePartDTO.setTotalNetWeight(
                                 techMachinePartDTO.getNetWeight().multiply(BigDecimal.valueOf(techMachinePartDTO.getQuantity().intValue()))
                              );
                              techMachinePartDTO.setTotalGrossWeight(
                                 techMachinePartDTO.getNetWeight().multiply(BigDecimal.valueOf(techMachinePartDTO.getQuantity().intValue()))
                              );
                              techMachinePartDTO.setSurfaceArea(techMachinePartDTO.getSurfaceArea().divide(new BigDecimal(100000000)));
                              techMachinePartDTO.setTotalSurfaceArea(
                                 techMachinePartDTO.getSurfaceArea()
                                    .multiply(BigDecimal.valueOf(techMachinePartDTO.getQuantity().intValue()))
                                    .divide(new BigDecimal(100000000))
                              );
                              techMachinePartDTO.setProductType(ProductTypeEnum.MACHINE_PART.getType());
                              return techMachinePartDTO;
                           }
                        )
                        .collect(Collectors.toList());
                     machinePartDTO.setAssembleMachinePartDTOList(assembleMachinePartDTOList);
                  }
               }
            }
         }
      }

      return techMachinePartDTOS;
   }

   @Override
   public ProductMeteDTO sumMeteByCondition(Long areaId) {
      return this.baseMapper.sumMeteByCondition(areaId);
   }

   @Override
   public List<ProductMeteGroupDTO> sumMeteGroup(Long projectId, Long monomerId, Integer permissionCheck, Long userId) {
      return monomerId == null
         ? this.baseMapper.sumMeteGroupByMonomerId(projectId, permissionCheck, userId)
         : this.baseMapper.sumMeteGroupByAreaId(monomerId, permissionCheck, userId);
   }

   @Override
   public List<TechMachinePart> listBySteelId(Long steelId) {
      LambdaQueryWrapper wrapper;
      if (steelId == null) {
         wrapper = Wrappers.<TechMachinePart>lambdaQuery().isNull(TechMachinePart::getSteelId);
      } else {
         wrapper = ((Wrappers.<TechMachinePart>lambdaQuery().eq(TechMachinePart::getSteelId, steelId)).or())
            .isNull(TechMachinePart::getSteelId);
      }

      return this.baseMapper.selectList(wrapper);
   }

   @Override
   public List<TechMachinePartDTO> listByArtifactId(Long artifactId) {
      return this.baseMapper.listMachinePartByArtifactId(artifactId, null);
   }

   @Override
   public List<TechMachinePartDTO> listByArtifactIds(List<Long> artifactIds) {
      return this.baseMapper.listMachinePartByArtifactIds(artifactIds);
   }

   @Override
   public List<MachinePartSimpleDTO> listSimpleByMonomerId(Long monomerId, String serialNumber) {
      return this.baseMapper.listSimpleByMonomerId(monomerId, serialNumber);
   }

   @Override
   public TechMachinePart getByIdIgnoreDelete(Long id) {
      Preconditions.checkArgument(id != null, "零件id为空!");
      return this.baseMapper.selectByIdIgnoreDelete(id);
   }

   @Override
   public TechMachinePart getOneByPrefix(Long steelId, String specPrefix) {
      return this.baseMapper.selectOneByPrefix(steelId, specPrefix);
   }

   @Override
   public TechMachinePart getOneBySerialNumber(String serialNumber) {
      return this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getSerialNumber, serialNumber)
               .in(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ARTIFACT.getType(), MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
               .last("limit 1")
         );
   }

   @Override
   public List<ComponentCrderInformationDTO> selectByProjectId(Long projectId) {
      return this.baseMapper.selectByProjectId(projectId);
   }

   @Override
   public List<MachinePartsDTO> getMachinePartList(String classificationName, String material, String specification, Boolean boolHaveHole, Long projectId) {
      List<SysSteelClassification> classificationList = this.classificationService
         .list(Wrappers.lambdaQuery(SysSteelClassification.class).eq(SysSteelClassification::getName, classificationName));
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(classificationList), "零件分类不能为空");
      List<String> specPrefixs = this.classificationMatchService
         .list(
            Wrappers.lambdaQuery(SysSteelClassificationMatch.class)
               .in(SysSteelClassificationMatch::getSteelId, classificationList.stream().map(SysSteelClassification::getId).collect(Collectors.toList()))
         )
         .stream()
         .map(SysSteelClassificationMatch::getKeyword)
         .collect(Collectors.toList());
      List<TechMachinePart> techMachineParts = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .in(TechMachinePart::getSpecPrefix, specPrefixs)
               .eq(TechMachinePart::getMaterial, material)
               .eq(TechMachinePart::getProjectId, projectId)
         );
      SysSteelClassification classification = classificationList.get(0);
      if (classification.getBasicClass().equals(BasicClassEnum.STEEL_PLATE.getType())) {
         return techMachineParts.stream()
            .filter(e -> specification == null || this.getSpec(e.getSpecification(), e.getSpecPrefix()).equals(specification))
            .filter(e -> boolHaveHole == null || e.getBoolHaveHole().equals(boolHaveHole))
            .map(e -> BeanUtil.copy(e, MachinePartsDTO.class))
            .collect(Collectors.toList());
      } else {
         return classification.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())
            ? techMachineParts.stream()
               .filter(e -> specification == null || e.getSpecification().contains(specification))
               .map(e -> BeanUtil.copy(e, MachinePartsDTO.class))
               .collect(Collectors.toList())
            : techMachineParts.stream().map(e -> BeanUtil.copy(e, MachinePartsDTO.class)).collect(Collectors.toList());
      }
   }

   @Override
   public void updateBoolProcess(Boolean flag, Long steelId) {
      List<Long> projectIds = this.projectService
         .list(
            (Wrapper<ContractProject>)(new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getMode, ProjectModeEnum.STANDARD_MODE.getType()))
               .ne(ContractProject::getStatus, ProjectStatusEnum.COMPLETED.getType())
         )
         .stream()
         .map(ContractProject::getId)
         .collect(Collectors.toList());
      if (!CollectionUtil.isEmpty(projectIds)) {
         List<TechMachinePart> partList = this.baseMapper
            .selectList(
               (Wrapper<TechMachinePart>)((new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getSteelId, steelId))
                     .eq(TechMachinePart::getBoolProcess, !flag))
                  .in(TechMachinePart::getProjectId, projectIds)
            );
         if (CollectionUtil.isNotEmpty(partList)) {
            Set<Long> partIds = partList.stream().map(TechMachinePart::getId).collect(Collectors.toSet());
            List<MesBuildingTask> taskList = this.mesBuildingTaskService
               .list(
                  (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                        .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.MACHINE_PART.getType()))
                     .in(MesBuildingTask::getProductId, partIds)
               );
            if (CollectionUtil.isNotEmpty(taskList)) {
               Set<Long> productIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toSet());
               partList = partList.stream()
                  .filter(partId -> productIds.stream().noneMatch(productId -> productId.equals(partId.getId())))
                  .collect(Collectors.toList());
            }

            if (CollectionUtil.isNotEmpty(partList)) {
               partList.forEach(e -> {
                  e.setBoolProcess(flag);
                  e.setBoolSchedulingEnum(flag);
                  e.setProducedQuantity(flag ? 0 : e.getQuantity());
                  this.baseMapper.updateById(e);
               });
            }
         }
      }
   }

   private String getSpec(String specification, String specPrefix) {
      int separatorIndex = specification.indexOf("*");
      return specification.substring(specPrefix.length(), separatorIndex < 0 ? specification.length() : separatorIndex);
   }

   @Override
   public List<MachinePartSummaryDTO> listSummary(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer steelPlateTypeEnum, Integer permissionCheck
   ) {
      if (UserUtil.getCurrentUser().isAdmin()) {
         permissionCheck = null;
      }

      if (permissionCheck != null && monomerId != null) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(
               Wrappers.lambdaQuery(MonomerUserLink.class)
                  .eq(MonomerUserLink::getMonomerId, monomerId)
                  .eq(MonomerUserLink::getDeepenedPersonId, UserUtil.getCurrentUser().getId())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(monomerUserLinkList), "您没有查看此清单的权限!");
      }

      return this.baseMapper
         .selectSummary(projectId, monomerId, areaId, areaBatchId, steelPlateTypeEnum, permissionCheck, UserUtil.getCurrentUser().getId())
         .stream()
         .sorted(Comparator.comparing(MachinePartSummaryDTO::getThick, Comparator.comparingInt(this::parseToInt).thenComparing(Comparator.naturalOrder())))
         .collect(Collectors.toList());
   }

   private int parseToInt(String id) {
      try {
         return Integer.parseInt(id);
      } catch (NumberFormatException e) {
         return Integer.MAX_VALUE;
      }
   }

   @Override
   public void listSummaryExport(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer steelPlateTypeEnum, HttpServletResponse response) {
      List<MachinePartSummaryExportDTO> machinePartSummaryExportDTOList = this.baseMapper
         .selectSummaryExport(projectId, monomerId, areaId, areaBatchId, steelPlateTypeEnum);
      machinePartSummaryExportDTOList = machinePartSummaryExportDTOList.stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId() + e.getMonomerId() + e.getAreaId() + e.getMaterial() + e.getThick()))
         .values()
         .stream()
         .map(
            e -> {
               MachinePartSummaryExportDTO machinePartSummaryExportDTO = e.get(0);
               machinePartSummaryExportDTO.setQuantity(e.stream().map(MachinePartSummaryExportDTO::getQuantity).reduce(0, Integer::sum));
               machinePartSummaryExportDTO.setTotalNetWeight(
                  e.stream().map(MachinePartSummaryExportDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
               );
               return machinePartSummaryExportDTO;
            }
         )
         .collect(Collectors.toList());
      String sheetName = "零件汇总";
      String fileName = "零件汇总.xlsx";
      String title = "零件汇总";
      PoiUtils.exportExcel(machinePartSummaryExportDTOList, title, sheetName, MachinePartSummaryExportDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public List<TechMachinePartDTO> listSpacerByCondition(String serialNumber, String specification, String thick, String material) {
      LambdaQueryWrapper<TechMachinePart> queryWrapper = (LambdaQueryWrapper<TechMachinePart>)(((new LambdaQueryWrapper<TechMachinePart>()
                  .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.SPACER_PARALLEL.getType()))
               .like(StringUtils.isNotBlank(serialNumber), TechMachinePart::getSerialNumber, serialNumber))
            .like(StringUtils.isNotBlank(specification), TechMachinePart::getSpecification, specification))
         .eq(StringUtils.isNotBlank(material), TechMachinePart::getMaterial, material);
      if (StringUtils.isNotBlank(thick)) {
         queryWrapper.eq(TechMachinePart::getThick, thick);
      }

      List<TechMachinePart> techMachineParts = this.baseMapper.selectList(queryWrapper);
      return techMachineParts.stream()
         .map(e -> BeanUtil.copy(e, TechMachinePartDTO.class))
         .sorted(Comparator.comparing(TechMachinePartDTO::getThick, Comparator.nullsLast(String::compareTo)))
         .collect(Collectors.toList());
   }

   @Override
   public ListVO<TechMachinePartDTO> appListMachinePart(Long artifactId) {
      List<TechMachinePartDTO> techMachinePartDTOS = this.baseMapper.selectByArtifactId(artifactId);
      return new ListVO<>(techMachinePartDTOS);
   }

   @Override
   public List<TechMachinePart> listByBusinessId(Long businessId) {
      return this.baseMapper.selectList(Wrappers.lambdaQuery(TechMachinePart.builder().businessId(businessId).build()));
   }

   @Override
   public List<SendPurlinDTO> listAllByArtifactIds(List<Long> ids) {
      return this.baseMapper.listAllByArtifactIds(ids);
   }

   @Override
   public BigDecimal sumTnventoryTon(Long projectId) {
      return this.baseMapper.sumTnventoryTon(projectId);
   }
}
