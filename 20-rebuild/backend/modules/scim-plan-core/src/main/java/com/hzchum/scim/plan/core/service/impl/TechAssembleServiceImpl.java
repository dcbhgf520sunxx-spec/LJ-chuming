package com.hzchum.scim.plan.core.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.enums.IsImportEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleArtifactSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleNestingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleStructureConfigDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssemblesDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.BridgeElementPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.mapper.TechAssembleMapper;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechAssembleServiceImpl extends ServiceImpl<TechAssembleMapper, TechAssemble> implements TechAssembleService {
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingSchedulingService schedulingService;
   @Resource
   private MesBuildingTaskService buildingTaskService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private UserService userService;
   @Resource
   private PlanAreaBatchService areaBatchService;

   @Override
   public void downloadTemplate() {
      String resourcePath = "template/AssembleImportTemplate.xlsx";
      String exportFileName = "组立清单模版.xlsx";
      File file = null;
      ClassPathResource pathResource = new ClassPathResource(resourcePath);

      try (InputStream fis = pathResource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(fis, file);
      } catch (IOException e) {
         this.log.error("文件下载异常，请联系管理员, {}", e);
      }

      FileUtil.downloadFile(file, exportFileName);
   }

   @Override
   public List<AssembleDTO> listByCondition(
      Long areaId, Long areaBatchId, String serialNumber, String specification, String material, Integer permissionCheck, Long userId
   ) {
      return this.baseMapper.selectListByConditions(areaId, areaBatchId, serialNumber, specification, material, permissionCheck, userId);
   }

   @Override
   public ListVO<String> listAbnormalAssemble(Long areaId) {
      List<String> abnormalSerialNumberList = this.baseMapper.selectAbnormalSerialNumber(areaId);
      return new ListVO<>(abnormalSerialNumberList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteAssembleById(Long id) {
      TechAssemble assemble = this.baseMapper.selectById(id);
      Preconditions.checkArgument(assemble != null, "组立不存在,id输入有误");
      this.projectService.checkProjectStatus(assemble.getProjectId());
      this.removeAssemble(id);
      return Boolean.TRUE;
   }

   private void removeAssemble(Long assembleId) {
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().eq(TechAssembleDetail::getAssembleId, assembleId));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         assembleDetailList.forEach(d -> {
            Preconditions.checkArgument(d.getArtifactId() == null, "请先删除组立匹配的所有构件!");
            this.assembleDetailService.removeById(d.getId());
         });
      }

      List<TechAssembleMachinePartLink> techAssembleMachinePartLinks = this.assembleMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, assembleId));
      this.baseMapper.deleteById(assembleId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteByIdList(List<Long> ids) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(ids), "未选中要删除的组立");
      ids.forEach(this::deleteAssembleById);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean clearAssembles(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在!");
      this.projectService.checkProjectStatus(area.getProjectId());
      List<TechAssemble> assembleList = this.baseMapper.selectList(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getAreaId, areaId));
      if (assembleList.isEmpty()) {
         return Boolean.TRUE;
      }

      List<Long> idList = new ArrayList<>(128);
      assembleList.forEach(
         assemble -> {
            List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
               .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getAssembleId, assemble.getId()));
            if (assembleDetailList.isEmpty()) {
               idList.add(assemble.getId());
            } else {
               int i = 0;

               for (TechAssembleDetail assembleDetail : assembleDetailList) {
                  if (assembleDetail.getArtifactId() != null) {
                     i++;
                     break;
                  }
               }

               if (i == 0) {
                  idList.add(assemble.getId());
               }
            }
         }
      );
      if (CollectionUtils.isNotEmpty(idList)) {
         idList.forEach(this::removeAssemble);
      }

      return Boolean.TRUE;
   }

   @Override
   public AssembleDTO getAssembleById(Long id) {
      TechAssemble techAssemble = this.baseMapper.selectById(id);
      Preconditions.checkArgument(techAssemble != null, "组立不存在,组立id可能传入有误!");
      ProjectInfo projectInfo = this.projectService.getSimpleById(techAssemble.getProjectId());
      PlanMonomer planMonomer = this.monomerService.getById(techAssemble.getMonomerId());
      NameInfo monomer = BeanUtil.copy(planMonomer, NameInfo.class);
      PlanArea planArea = this.areaService.getById(techAssemble.getAreaId());
      NameInfo area = BeanUtil.copy(planArea, NameInfo.class);
      PlanAreaBatch areaBatch = this.areaBatchService.getById(techAssemble.getAreaBatchId());
      NameInfo areaBatchInfo = BeanUtil.copy(areaBatch, NameInfo.class);
      AssembleDTO assembleDTO = BeanUtil.copy(techAssemble, AssembleDTO.class);
      assembleDTO.setProject(projectInfo);
      assembleDTO.setMonomer(monomer);
      assembleDTO.setArea(area);
      assembleDTO.setAreaBatch(areaBatchInfo);
      User user = this.userService.getById(techAssemble.getId());
      if (user != null) {
         assembleDTO.setUserName(user.getName());
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().eq(TechAssembleDetail::getAssembleId, id));
      List<AssembleArtifactDTO> detailDTOList = new ArrayList<>(16);
      assembleDetailList.forEach(detail -> {
         TechArtifact artifact = this.artifactService.getById(detail.getArtifactId());
         AssembleArtifactDTO detailDTO = BeanUtil.copy(artifact, AssembleArtifactDTO.class);
         detailDTO.setExistStatus(IsImportEnum.IS_IMPORT.getType());
         detailDTOList.add(detailDTO);
      });
      assembleDTO.setArtifactDTOList(detailDTOList);
      Integer inProductQuantity = this.buildingTaskService.getTotalInProductQuantity(id, ProductTypeEnum.ASSEMBLE.getType());
      List<AssembleMachinePartDTO> assembleMachinePartDTOList = new ArrayList<>();
      List<TechAssembleMachinePartLink> links = this.assembleMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, id));
      links.forEach(link -> {
         TechMachinePart machinePart = this.machinePartService.getById(link.getMachinePartId());
         AssembleMachinePartDTO assembleMachinePartDTO = BeanUtil.copy(machinePart, AssembleMachinePartDTO.class);
         assembleMachinePartDTO.setQuantity(techAssemble.getQuantity() * link.getQuantity());
         assembleMachinePartDTO.setUsedQuantity(inProductQuantity * link.getQuantity());
         assembleMachinePartDTOList.add(assembleMachinePartDTO);
      });
      assembleDTO.setDetailDTOList(assembleMachinePartDTOList);
      return assembleDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteAssembleArtifact(Long assembleId, String artifactNo) {
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean insertAssembleArtifact(AssembleArtifactSaveDTOParam saveDTOParam) {
      return Boolean.TRUE;
   }

   private void checkAssembleArtifact(AssembleArtifactSaveDTOParam saveDTOParam, TechArtifact artifact) {
      Preconditions.checkArgument(saveDTOParam.getSpecification().equals(artifact.getSpecification()), "构件规格和数据库中不一致");
      Preconditions.checkArgument(saveDTOParam.getLength().compareTo(artifact.getLength()) == 0, "构件长度和数据库中不一致");
      Preconditions.checkArgument(saveDTOParam.getMaterial().equals(artifact.getMaterial()), "构件材质和数据库中不一致");
      Preconditions.checkArgument(saveDTOParam.getNetWeight().compareTo(artifact.getNetWeight()) == 0, "构件单净重和数据库中不一致");
   }

   @Override
   public TechAssemble getByIdIgnoreDelete(Long id) {
      Preconditions.checkArgument(id != null, "组立id为空!");
      return this.baseMapper.selectByIdIgnoreDelete(id);
   }

   @Override
   public TechAssemble getOneByPrefix(Long assembleConfigId, String specPrefix) {
      return this.baseMapper.selectOneByPrefix(assembleConfigId, specPrefix);
   }

   @Override
   public TechAssemble getOneBySerialNumber(String serialNumber) {
      return this.baseMapper.selectOne(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getSerialNumber, serialNumber).last("limit 1"));
   }

   @Override
   public List<ComponentCrderInformationDTO> selectProjectGroupBySpec(Long projectId) {
      return this.baseMapper.selectProjectGroupBySpec(projectId);
   }

   @Override
   public List<AssemblesDTO> getAssembleList(String classificationName, String material, Long projectId) {
      return this.baseMapper.getAssembleList(classificationName, material, projectId);
   }

   @Override
   public void updateBoolProcess(Boolean flag, Long assembleConfigId) {
      List<Long> projectIds = this.projectService
         .list(
            (Wrapper<ContractProject>)(new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getMode, ProjectModeEnum.STANDARD_MODE.getType()))
               .ne(ContractProject::getStatus, ProjectStatusEnum.COMPLETED.getType())
         )
         .stream()
         .map(ContractProject::getId)
         .collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(projectIds)) {
         List<TechAssemble> assembleList = this.baseMapper
            .selectList(
               (Wrapper<TechAssemble>)((new LambdaQueryWrapper<TechAssemble>()
                        .eq(TechAssemble::getAssembleConfigId, assembleConfigId))
                     .eq(TechAssemble::getBoolProcess, !flag))
                  .in(TechAssemble::getProjectId, projectIds)
            );
         if (CollectionUtil.isNotEmpty(assembleList)) {
            Set<Long> assembleIds = assembleList.stream().map(TechAssemble::getId).collect(Collectors.toSet());
            List<MesBuildingTask> taskList = this.mesBuildingTaskService
               .list(
                  (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                        .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ASSEMBLE.getType()))
                     .in(MesBuildingTask::getProductId, assembleIds)
               );
            if (CollectionUtil.isNotEmpty(taskList)) {
               Set<Long> productIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toSet());
               List<TechAssemble> collect = assembleList.stream()
                  .filter(assemble -> productIds.stream().noneMatch(productId -> productId.equals(assemble.getId())))
                  .collect(Collectors.toList());
               if (CollectionUtil.isNotEmpty(collect)) {
                  collect.forEach(e -> {
                     e.setBoolSchedulingEnum(flag);
                     e.setBoolProcess(flag);
                     e.setProducedQuantity(flag ? 0 : e.getQuantity());
                     this.baseMapper.updateById(e);
                  });
               }
            }
         }
      }
   }

   @Override
   public TechAssemble listBySpecification(Long artifactId, Long monomerId, String specification, Long areaId) {
      return this.baseMapper.listBySpecification(artifactId, monomerId, specification, areaId);
   }

   @Override
   public List<TechAssemble> listByArtifactIds(List<Long> ids, String specification, BigDecimal length) {
      return this.baseMapper.listByArtifactIds(ids, specification, length);
   }

   @Override
   public List<AssembleNestingDTOParam> listAssembleNesting(
      Long projectId,
      Long monomerId,
      Set<Long> areaIds,
      Integer productionLineTypeEnum,
      Integer boolMainAssemble,
      String specPrefix,
      String specification,
      String material,
      String serialNumber,
      boolean boolLength,
      BigDecimal length,
      List<Long> structureClassIds,
      Integer boolHaveNC1
   ) {
      return this.baseMapper
         .listAssembleNesting(
            projectId,
            monomerId,
            areaIds,
            productionLineTypeEnum,
            boolMainAssemble,
            specPrefix,
            specification,
            material,
            serialNumber,
            boolLength,
            length,
            structureClassIds,
            boolHaveNC1
         );
   }

   @Override
   public List<AssembleNestingDTOParam> listAssembleNoNesting(
      Long projectId,
      Long monomerId,
      Set<Long> areaIds,
      Integer productionLineTypeEnum,
      String specPrefix,
      String specification,
      String material,
      String serialNumber,
      BigDecimal length
   ) {
      return this.baseMapper
         .listAssembleNoNesting(projectId, monomerId, areaIds, productionLineTypeEnum, specPrefix, specification, material, serialNumber, length);
   }

   @Override
   public List<AssembleStructureConfigDTOParam> listAssembleAndStructureClassIdConfig(
      Long projectId, Long monomerId, Set<Long> areaIds, Set<Long> structureClassIds, Integer productionLineTypeEnum
   ) {
      return this.baseMapper.listAssembleAndStructureClassIdConfig(projectId, monomerId, areaIds, structureClassIds, productionLineTypeEnum);
   }

   @Override
   public AssembleDTO assembleSourceProductList(Long productId, Integer productType, Long taskId, Integer number) {
      return this.baseMapper.assembleSourceProductList(productId);
   }

   @Override
   public List<ArtifactReportSourceDTO> assembleSourceReportProductList(Long productId, Integer number, Long taskId) {
      return this.teamReportService.assembleSourceReportProductList(productId, number, taskId);
   }

   @Override
   public List<SendPurlinDTO> listAllByArtifactIds(List<Long> ids) {
      return this.baseMapper.listAllByArtifactIds(ids);
   }

   @Override
   public BigDecimal sumTnventoryTon(Long projectId) {
      return this.baseMapper.sumTnventoryTon(projectId);
   }

   @Override
   public BimBoxOrElementsVO selectElementByBim(Long monomerId, List<Long> areaIds, String serialNumber) {
      return this.baseMapper.selectElementByBim(monomerId, areaIds, serialNumber);
   }

   @Override
   public List<BridgeElementPartDTO> listMachinePartByArtifact(Long artifactId) {
      return this.baseMapper.selectByArtifactId(artifactId);
   }

   @Override
   public List<ArtifactSimpleVO> getAssemble(String serialNumber, Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getAssemble(serialNumber, projectId, monomerId, areaId);
   }
}
