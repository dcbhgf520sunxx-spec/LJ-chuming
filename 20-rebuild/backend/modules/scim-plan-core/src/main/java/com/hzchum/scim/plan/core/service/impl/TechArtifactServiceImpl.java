package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductInfoDTO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingArtifactTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.NewArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechAssembleRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.AllSendArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaArtifactSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactClassSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSnDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusQHSEDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactAssembleMatchingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.StructureClassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.MachinePartInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupByProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.mapper.TechArtifactMapper;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechArtifactServiceImpl extends ServiceImpl<TechArtifactMapper, TechArtifact> implements TechArtifactService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Autowired
   private BusinessArtifactService businessArtifactService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private BimModelCommonService bimModelCommonService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private MesBuildingArtifactTaskBiz mesBuildingArtifactTaskBiz;
   @Resource
   private PlanAreaBatchService areaBatchService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;

   @Override
   public List<ArtifactResponseDTO> listByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      String name,
      String serialNumber,
      String specification,
      String material,
      Boolean boolSchedulingEnum,
      Integer artifactType,
      Integer permissionCheck,
      Long userId
   ) {
      return this.baseMapper
         .selectListByCondition(
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            null,
            status,
            name,
            serialNumber,
            specification,
            material,
            boolSchedulingEnum,
            ProductTypeEnum.ARTIFACT.getType(),
            null,
            TechDataTypeEnum.DEEPEN.getType(),
            artifactType,
            permissionCheck,
            userId
         );
   }

   @Override
   public List<ArtifactResponseDTO> listByCondition(Long projectId, Long monomerId, Long structureClassId, Long areaId) {
      return this.baseMapper
         .selectListByCondition(projectId, monomerId, areaId, null, structureClassId, null, null, null, null, null, null, null, 1, null, null, null, null);
   }

   @Override
   public List<ArtifactResponseDTO> listByCondition(
      Long projectId, Long structureClassId, String name, String serialNumber, String specification, String material
   ) {
      return this.baseMapper
         .selectListByCondition(
            projectId, null, null, null, structureClassId, null, name, serialNumber, specification, material, null, null, null, null, null, null, null
         );
   }

   @Override
   public ArtifactDTO getInfoById(Long id) {
      TechArtifact techArtifact = this.baseMapper.selectById(id);
      Preconditions.checkArgument(techArtifact != null, "构件不存在,传入的构件id可能有误!");
      ArtifactDTO artifactDTO = BeanUtil.copy(techArtifact, ArtifactDTO.class);
      ProjectInfo info = this.projectService.getSimpleById(techArtifact.getProjectId());
      artifactDTO.setProject(info);
      artifactDTO.setUserName(techArtifact.getUserNames());
      NameInfo monomerNameInfo = this.monomerService.getSimpleById(techArtifact.getMonomerId());
      artifactDTO.setMonomer(monomerNameInfo);
      NameInfo areaNameInfo = this.areaService.getSimpleById(techArtifact.getAreaId());
      artifactDTO.setArea(areaNameInfo);
      PlanAreaBatch areaBatch = this.areaBatchService.getById(techArtifact.getAreaBatchId());
      artifactDTO.setAreaBatch(BeanUtil.copy(areaBatch, NameInfo.class));
      List<TechMachinePartDTO> machinePartDTOS = this.machinePartService.listMachinePartByArtifact(id);
      artifactDTO.setMachinePartDTOList(machinePartDTOS);
      List<Long> assembleIds = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, id))
         .stream()
         .map(TechAssembleDetail::getAssembleId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         artifactDTO.setAssembleSerialNumbers(
            this.assembleService.listByIds(assembleIds).stream().map(TechAssemble::getSerialNumber).collect(Collectors.toList())
         );
      }

      return artifactDTO;
   }

   @Override
   public ArtifactDTO getInfoById(Long id, int type) {
      return this.baseMapper.getInfoById(id);
   }

   @Override
   public ArtifactInfoDTO getInfo(Long monomerId, Long areaId, String serialNumber) {
      List<TechArtifact> artifacts = new ArrayList<>();
      if (areaId != null) {
         PlanArea area = this.areaService.getById(areaId);
         Long projectId = area.getProjectId();
         TechArtifact oldArtifact = this.baseMapper
            .selectOne(
               (Wrapper<TechArtifact>)(Wrappers.<TechArtifact>lambdaQuery().eq(TechArtifact::getAreaId, areaId))
                  .eq(TechArtifact::getSerialNumber, serialNumber)
            );
         Preconditions.checkArgument(oldArtifact != null, "原构件不存在");
         artifacts.add(oldArtifact);
      } else {
         if (monomerId == null) {
            throw new BusinessException("单体或区域缺失");
         }

         PlanMonomer monomer = this.monomerService.getById(monomerId);
         Long projectId = monomer.getProjectId();
         List<TechArtifact> oldArtifacts = this.baseMapper
            .selectList(
               (Wrapper<TechArtifact>)(Wrappers.<TechArtifact>lambdaQuery().eq(TechArtifact::getMonomerId, monomerId))
                  .eq(TechArtifact::getSerialNumber, serialNumber)
            );
         Preconditions.checkArgument(org.apache.commons.collections4.CollectionUtils.isNotEmpty(oldArtifacts), "原构件不存在");
         artifacts.addAll(oldArtifacts);
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifacts), "构件不存在,传入的构件id可能有误!");
      AtomicReference<Integer> quantity = new AtomicReference<>(0);
      AtomicReference<Integer> shipQuantity = new AtomicReference<>(0);
      AtomicReference<Integer> producedQuantity = new AtomicReference<>(0);
      artifacts.forEach(artifact -> {
         shipQuantity.updateAndGet(v -> v + this.cargoListProductLinkService.getShipQuantityByProduct(artifact.getId(), ProductTypeEnum.ARTIFACT.getType()));
         quantity.updateAndGet(v -> v + artifact.getQuantity());
         producedQuantity.updateAndGet(v -> v + artifact.getProducedQuantity());
      });
      ArtifactInfoDTO result = BeanUtil.copy(artifacts.get(0), ArtifactInfoDTO.class);
      List<TechArtifactMachinePartLink> machinePartLinkList = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, result.getId()));
      List<MachinePartInfoDTO> links = new ArrayList<>();
      machinePartLinkList.forEach(link -> {
         TechMachinePart machinePart = this.machinePartService.getById(link.getMachinePartId());
         if (machinePart.getRelationType() < 18) {
            MachinePartInfoDTO machinePartDTO = BeanUtil.copy(machinePart, MachinePartInfoDTO.class);
            machinePartDTO.setQuantity(quantity.get() * link.getQuantity());
            links.add(machinePartDTO);
         }
      });
      result.setParts(links);
      result.setId(areaId == null ? null : result.getId());
      result.setQuantity(quantity.get());
      result.setShipQuantity(shipQuantity.get());
      result.setProducedQuantity(producedQuantity.get());
      return result;
   }

   @Override
   public List<TechArtifact> listByBusinessId(Long businessId) {
      return this.baseMapper.selectList((Wrapper<TechArtifact>)Wrappers.<TechArtifact>lambdaQuery().eq(TechArtifact::getBusinessId, businessId));
   }

   @Override
   public ProductMeteDTO sumMeteByCondition(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.sumMete(projectId, monomerId, areaId);
   }

   @Override
   public List<ProductMeteGroupByProjectDTO> sumMeteGroupByProject(Long projectId) {
      return this.baseMapper.sumMeteGroupByProject(projectId);
   }

   @Override
   public List<ProductMeteGroupDTO> sumMeteGroup(Long projectId, Long monomerId, Integer permissionCheck, Long userId) {
      return monomerId == null
         ? this.baseMapper.sumMeteGroupByMonomerId(projectId, permissionCheck, userId)
         : this.baseMapper.sumMeteGroupByAreaId(monomerId, permissionCheck, userId);
   }

   @Override
   public List<ProductMeteGroupDTO> sumMeteGroupByAreaIds(List<Long> areaIds) {
      return this.baseMapper.sumMeteGroupByAreaIds(areaIds);
   }

   @Override
   public void setQuantity(TechArtifact artifact, Integer newQuantity) {
      Integer oldQuantity = artifact.getQuantity();
      Integer changeQuantity = newQuantity - oldQuantity;
      artifact.setQuantity(newQuantity);
      if (artifact.getQuantity() == 0) {
         this.baseMapper.updateById(artifact);
         this.baseMapper.deleteById(artifact);
      } else {
         artifact.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(newQuantity.intValue())));
         artifact.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(newQuantity.intValue())));
         this.baseMapper.updateById(artifact);
      }

      this.businessArtifactService
         .editBusinessInfo(
            ArtifactEditDTOParam.builder()
               .businessId(artifact.getBusinessId())
               .quantity(changeQuantity)
               .totalWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(changeQuantity.intValue())))
               .totalLength(artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)))
               .build()
         );
   }

   @Override
   public TechArtifact getByIdIgnoreDelete(Long id) {
      Preconditions.checkArgument(id != null, "构件id为空!");
      return this.baseMapper.selectByIdIgnoreDelete(id);
   }

   @Override
   public BimArtifactVO selectArtifactByBim(Long monomerId, List<Long> areaIds, String serialNumber) {
      return this.baseMapper.selectArtifactByBim(monomerId, areaIds, serialNumber);
   }

   @Override
   public BimBoxOrElementsVO selectBridgeArtifactByBim(Long monomerId, List<Long> areaIds, String serialNumber) {
      return this.baseMapper.selectBridgeArtifactByBim(monomerId, areaIds, serialNumber);
   }

   @Override
   public TechArtifact getOneByClassIdAndPrefix(Long structureClassId, String specPrefix, String snPrefix) {
      return this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getStructureClassId, structureClassId)
               .eq(StringUtils.isNotBlank(specPrefix), TechArtifact::getSpecPrefix, specPrefix)
               .eq(StringUtils.isNotBlank(snPrefix), TechArtifact::getSerialNumberPrefix, snPrefix)
               .last("limit 1")
         );
   }

   @Override
   public TechArtifact getOneBySerialNumber(String serialNumber) {
      return this.baseMapper.selectOne(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getSpecPrefix, serialNumber).last("limit 1"));
   }

   @Override
   public List<ComponentCrderInformationDTO> selectProjectGroupBySpec(Long projectId) {
      return this.baseMapper.selectProjectGroupBySpec(projectId);
   }

   @Override
   public List<ArtifactsDTO> getArtifactList(String classificationName, String material, Long projectId) {
      return this.baseMapper.getArtifactList(classificationName, material, projectId);
   }

   @Override
   public ProductLineSummary selectByProjectIdAndLine(Long lineId, Long projectId, Integer type) {
      return this.baseMapper.selectByProjectIdAndLine(lineId, projectId, type);
   }

   @Override
   public String selectByTypeAndId(Integer productType, Long productId) {
      return this.baseMapper.selectByTypeAndId(productType, productId);
   }

   @Override
   public Boolean listByConditionsDownLoad(
      Long areaId, Long areaBatchId, Integer status, String name, String serialNumber, String specification, String material, HttpServletResponse response
   ) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在");
      PlanMonomer monomer = this.monomerService.getById(area.getMonomerId());
      ProjectInfo projectInfo = this.projectService.getSimpleById(area.getProjectId());
      Map<String, Object> result = new HashMap<>(1024);
      String resourcePath = "files/ArtifactInventory.xls";
      String tempFileName = "ArtifactInventory";
      String exportFileName = "构件-构件清单.xls";
      List<ArtifactResponseDTO> dtoList = this.baseMapper
         .selectListByCondition(
            null,
            null,
            areaId,
            areaBatchId,
            null,
            status,
            name,
            serialNumber,
            specification,
            material,
            null,
            ProductTypeEnum.ARTIFACT.getType(),
            null,
            null,
            null,
            null,
            null
         );
      AtomicInteger i = new AtomicInteger(1);
      dtoList.forEach(a -> {
         a.setPid(i.getAndIncrement());
         a.setNetWeight(a.getNetWeight().setScale(2, RoundingMode.HALF_UP));
         a.setGrossWeight(a.getGrossWeight().setScale(2, RoundingMode.HALF_UP));
         a.setTotalNetWeight(a.getTotalNetWeight().setScale(2, RoundingMode.HALF_UP));
         a.setTotalGrossWeight(a.getTotalGrossWeight().setScale(2, RoundingMode.HALF_UP));
         a.setSurfaceArea(a.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
         a.setTotalSurfaceArea(a.getSurfaceArea().multiply(BigDecimal.valueOf(a.getQuantity().intValue())));
      });
      result.put("dtoList", dtoList);
      result.put("projectName", projectInfo.getName());
      result.put("monomerName", monomer.getName());
      result.put("areaName", area.getName());
      PoiUtils.mesDownLoadExcel(exportFileName, response, tempFileName, resourcePath, result);
      return Boolean.TRUE;
   }

   @Override
   public ArtifactSumDTO listByConditionsSummary(
      Long areaId, Long areaBatchId, Integer status, String name, String serialNumber, String specification, String material
   ) {
      List<ArtifactResponseDTO> dtoList = this.baseMapper
         .selectListByCondition(
            null,
            null,
            areaId,
            areaBatchId,
            null,
            status,
            name,
            serialNumber,
            specification,
            material,
            null,
            ProductTypeEnum.ARTIFACT.getType(),
            null,
            TechDataTypeEnum.DEEPEN.getType(),
            null,
            null,
            null
         );
      ArtifactSumDTO dto = ArtifactSumDTO.builder().quantity(0).totalGrossWeight(BigDecimal.ZERO).totalNetWeight(BigDecimal.ZERO).build();
      dtoList.forEach(e -> {
         dto.setTotalNetWeight(dto.getTotalNetWeight().add(e.getTotalNetWeight()));
         dto.setTotalGrossWeight(dto.getTotalGrossWeight().add(e.getTotalGrossWeight()));
         dto.setQuantity(dto.getQuantity() + e.getQuantity());
      });
      return dto;
   }

   @Override
   public TechArtifact getOneOutLengthScope(Long structureClassId, BigDecimal minLength, BigDecimal maxLength) {
      LambdaQueryWrapper<TechArtifact> wrapper = Wrappers.lambdaQuery(TechArtifact.class)
         .eq(TechArtifact::getStructureClassId, structureClassId)
         .lt(maxLength == null, TechArtifact::getLength, minLength)
         .gt(minLength == null, TechArtifact::getLength, maxLength);
      if (minLength != null && maxLength != null) {
         wrapper.and(w -> {
            LambdaQueryWrapper var10000 = w.lt(TechArtifact::getLength, minLength).or().gt(TechArtifact::getLength, maxLength);
         });
      }

      wrapper.last("limit 1");
      return this.baseMapper.selectOne(wrapper);
   }

   @Override
   public List<AreaArtifactSummaryDTO> areaArtifactSummary(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.areaArtifactSummary(projectId, monomerId, areaId);
   }

   @Override
   public List<PlanArtifactAssembleMatchingDTO> listArtifactProcess(
      List<Long> ids,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long structureClassId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Long areaBatchId
   ) {
      return this.baseMapper.listArtifactProcess(ids, projectId, monomerId, areaId, structureClassId, name, serialNumber, specification, material, areaBatchId);
   }

   @Override
   public Object artifactSourceProductList(Long productId, Integer productType, Long taskId, Integer number) {
      return this.baseMapper.artifactSourceProductList(productId);
   }

   @Override
   public List<ArtifactReportSourceDTO> artifactSourceReportProductList(Long productId, Integer number, Long taskId, Integer productType) {
      if (productType == null || ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         return this.utilsBiz.getBoolOneCode(productId)
            ? this.teamReportService.artifactSourceReportProductList(productId, number, taskId)
            : this.teamReportService.artifactSourceReportProductList(productId, null, taskId);
      } else {
         return ProductTypeEnum.ASSEMBLE.getType().equals(productType)
            ? this.teamReportService.assembleSourceReportProductList(productId, number, taskId)
            : new ArrayList<>();
      }
   }

   @Override
   public List<NewArtifactReportSourceDTO> newArtifactSourceReportProductList(Long taskProcessId, Long productId, Integer number) {
      List<NewArtifactReportSourceDTO> sourceDTOS = null;
      MesBuildingTaskProcess taskProcess = new MesBuildingTaskProcess();
      Boolean boolOneCode = true;
      if (taskProcessId != null) {
         taskProcess = this.taskProcessService.getById(taskProcessId);
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            boolOneCode = this.utilsBiz.getBoolOneCode(productId);
         } else {
            boolOneCode = this.utilsBiz.getAssBoolOneCode(taskProcess.getProductId(), taskProcess.getTaskId());
         }
      }

      if (boolOneCode) {
         sourceDTOS = this.teamReportService.newArtifactSourceReportProductList(productId, taskProcess.getTaskTypeEnum(), number);
      } else {
         sourceDTOS = this.teamReportService.newArtifactSourceReportProductList(productId, taskProcess.getTaskTypeEnum(), number);
      }

      sourceDTOS = sourceDTOS.stream().map(e -> e.setBoolInspect(false)).collect(Collectors.toList());
      List<NewArtifactReportSourceDTO> dtoList = this.teamReportService
         .ArtifactSourceInspectReportProductList(productId, taskProcess.getTaskTypeEnum(), number);
      dtoList = dtoList.stream().map(e -> e.setBoolInspect(true)).collect(Collectors.toList());
      Map<Long, NewArtifactReportSourceDTO> map = dtoList.stream().collect(Collectors.toMap(e -> e.getProcess().getId(), Function.identity()));
      List<NewArtifactReportSourceDTO> finalSourceDTOS = new ArrayList<>(sourceDTOS);
      if (CollectionUtils.isNotEmpty(dtoList)) {
         for (NewArtifactReportSourceDTO dto : sourceDTOS) {
            NewArtifactReportSourceDTO insepctSourceDTO = map.get(dto.getProcess().getId());
            if (insepctSourceDTO != null) {
               finalSourceDTOS.add(finalSourceDTOS.indexOf(dto) + 1, insepctSourceDTO);
            }
         }
      }

      return finalSourceDTOS;
   }

   @Override
   public List<StructureClassDTO> getStructureClass(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getStructureClass(projectId, monomerId, areaId);
   }

   @Override
   public ArtifactSumDTO appListByConditionsSummary(
      Long projectId, Long monomerId, Long areaId, Integer status, String name, String serialNumber, String specification, String material
   ) {
      List<ArtifactResponseDTO> dtoList = this.baseMapper
         .selectListByCondition(
            projectId,
            monomerId,
            areaId,
            null,
            null,
            status,
            name,
            serialNumber,
            specification,
            material,
            null,
            ProductTypeEnum.ARTIFACT.getType(),
            TechDataTypeEnum.DEEPEN.getType(),
            null,
            null,
            null,
            null
         );
      ArtifactSumDTO dto = ArtifactSumDTO.builder().quantity(0).totalGrossWeight(BigDecimal.ZERO).totalNetWeight(BigDecimal.ZERO).build();
      dtoList.forEach(e -> {
         dto.setTotalNetWeight(dto.getTotalNetWeight().add(e.getTotalNetWeight()));
         dto.setTotalGrossWeight(dto.getTotalGrossWeight().add(e.getTotalGrossWeight()));
         dto.setQuantity(dto.getQuantity() + e.getQuantity());
      });
      return dto;
   }

   @Override
   public PageVO<ArtifactStatusQHSEDTO> listArtifactDetail(
      Long projectId, Long areaId, Long monomerId, String serialNumber, Boolean boolCompany, Integer pageNumber, Integer pageSize
   ) {
      List<ArtifactStatusQHSEDTO> artifactStatusQHSEDTOList = new ArrayList<>();
      if (boolCompany != null && !boolCompany) {
         PageVO<ArtifactSimpleVO> pageVO = new PageVO<>(this.baseMapper.getArtifactDetail(projectId, areaId, monomerId, serialNumber));
         List<ArtifactSimpleVO> artifactSimpleVOList = pageVO.getContent();
         if (CollectionUtils.isNotEmpty(artifactSimpleVOList)) {
            for (ArtifactSimpleVO artifactSimpleVO : artifactSimpleVOList) {
               if (artifactSimpleVO != null) {
                  artifactStatusQHSEDTOList = this.mesBuildingArtifactTaskBiz.listArtifactQHSEStatus(artifactSimpleVO.getId());
                  artifactStatusQHSEDTOList.forEach(e -> {
                     e.setArtifactName(artifactSimpleVO.getName());
                     e.setSerialNumber(artifactSimpleVO.getSerialNumber());
                     e.setSpecification(artifactSimpleVO.getSpecification());
                     e.setProject(artifactSimpleVO.getProject());
                     e.setArtifactId(artifactSimpleVO.getId());
                     e.setArea(artifactSimpleVO.getArea());
                     e.setMonomer(artifactSimpleVO.getMonomer());
                  });
               }
            }
         }
      } else {
         PageVO<ArtifactSimpleVO> pageVO = new PageVO<>(this.baseMapper.getCompanyArtifactDetail(projectId, areaId, monomerId, serialNumber));
         List<ArtifactSimpleVO> artifactSimpleVOList = pageVO.getContent();
         if (CollectionUtils.isNotEmpty(artifactSimpleVOList)) {
            for (ArtifactSimpleVO artifactSimpleVO : artifactSimpleVOList) {
               if (artifactSimpleVO != null) {
                  artifactStatusQHSEDTOList = this.mesBuildingArtifactTaskBiz.listArtifactCompanyQHSEStatus(artifactSimpleVO.getId());
                  if (CollectionUtils.isNotEmpty(artifactStatusQHSEDTOList)) {
                     artifactStatusQHSEDTOList.forEach(e -> {
                        e.setArtifactName(artifactSimpleVO.getName());
                        e.setSerialNumber(artifactSimpleVO.getSerialNumber());
                        e.setSpecification(artifactSimpleVO.getSpecification());
                        e.setProject(artifactSimpleVO.getProject());
                        e.setArtifactId(artifactSimpleVO.getId());
                        e.setArea(artifactSimpleVO.getArea());
                        e.setMonomer(artifactSimpleVO.getMonomer());
                     });
                  }
               }
            }
         }
      }

      return new PageVO<>(CommonUtil.getPage(pageNumber, pageSize, artifactStatusQHSEDTOList));
   }

   @Override
   public PageVO<String> listSerialNumber(
      Long projectId, Long areaId, Long monomerId, String serialNumber, Boolean boolCompany, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      return boolCompany != null && !boolCompany
         ? new PageVO<>(this.baseMapper.listSerialNumber(projectId, areaId, monomerId, serialNumber))
         : new PageVO<>(this.baseMapper.listCompanySerialNumber(projectId, areaId, monomerId, serialNumber));
   }

   @Override
   public BigDecimal sumTnventoryTon(Long projectId) {
      return this.baseMapper.sumTnventoryTon(projectId);
   }

   @Override
   public List<ArtifactClassSummaryDTO> listClassSnQuantity(Long projectId, Long monomerId) {
      return this.baseMapper.selectClassSnQuantity(projectId, monomerId);
   }

   @Override
   public List<ArtifactSnDTO> listArtifactSn(
      Long projectId, Long monomerId, String name, String serialNumber, String specification, String material, List<Long> structureClassIdList
   ) {
      return this.baseMapper.selectArtifactSnList(projectId, monomerId, name, serialNumber, specification, material, structureClassIdList);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean changeBusinessArtifact(Long productId) {
      TechArtifact techArtifact = this.baseMapper.selectById(productId);
      Preconditions.checkArgument(techArtifact != null, "变更后的构件id不存在");
      Preconditions.checkArgument(techArtifact.getOldArtifactId() != null, "变更前的构件id不存在");
      TechArtifact oldArtifact = this.baseMapper.selectById(techArtifact.getOldArtifactId());
      Preconditions.checkArgument(oldArtifact != null, "变更前的构件数据不存在");
      BusinessArtifact oldBusinessArtifact = this.businessArtifactService.getById(oldArtifact.getBusinessId());
      Preconditions.checkArgument(oldBusinessArtifact != null, "变更前的构件商务不存在!!!");
      this.businessArtifactService.removeById(oldBusinessArtifact.getId());
      ArtifactAddDTOParam dtoParam = BeanUtil.copy(techArtifact, ArtifactAddDTOParam.class);
      dtoParam.setTotalWeight(techArtifact.getTotalGrossWeight());
      dtoParam.setTotalLength(
         techArtifact.getLength().multiply(BigDecimal.valueOf(techArtifact.getQuantity().intValue())).divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP)
      );
      Long businessId = this.businessArtifactService.addBusinessInfo(dtoParam);
      techArtifact.setBusinessId(businessId);
      this.baseMapper.updateById(techArtifact);
      return Boolean.TRUE;
   }

   @Override
   public List<AllSendArtifactDTO> listAllPartsByIds(List<Long> artifactIds) {
      return this.baseMapper.listAllPartsByIds(artifactIds);
   }

   @Override
   public List<AllSendArtifactDTO> listAllAsssByIds(List<Long> artifactIds) {
      return this.baseMapper.listAllAsssByIds(artifactIds);
   }

   @Override
   public List<ArtifactSimpleVO> getArtifact(String serialNumber, Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getArtifact(serialNumber, projectId, monomerId, areaId);
   }

   @Override
   public List<ArtifactSimpleVO> getArtifactListBySerialNumber(String serialNumber, Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getArtifactListBySerialNumber(serialNumber, projectId, monomerId, areaId);
   }

   @Override
   public BigDecimal selectListQuantity(Long projectId) {
      return this.baseMapper.selectListQuantity(projectId);
   }

   @Override
   public List<ProjectProductInfoDTO> findSchedulingArtifactInfo(
      List<Long> userProjectIds, List<Long> areaIds, Long monmerId, Long areaId, Long classId, String serialNumber
   ) {
      return this.baseMapper.findSchedulingArtifactInfo(userProjectIds, areaIds, monmerId, areaId, classId, serialNumber);
   }

   @Override
   public List<TechAssembleRecord> getAssembleRecordList(Long monomerId, Long areaId, String serialNumber, Long inventoryOperationId) {
      return this.baseMapper.getAssembleRecordList(monomerId, areaId, serialNumber, inventoryOperationId);
   }

   @Override
   public List<ArtifactResponseDTO> listByConditionV2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer status,
      String name,
      String serialNumber,
      String specification,
      String material,
      Boolean boolSchedulingEnum,
      Integer artifactType,
      String batchNumber
   ) {
      return this.baseMapper
         .selectListByConditionV2(
            projectId,
            monomerId,
            areaId,
            null,
            status,
            name,
            serialNumber,
            specification,
            material,
            boolSchedulingEnum,
            ProductTypeEnum.ARTIFACT.getType(),
            null,
            TechDataTypeEnum.DEEPEN.getType(),
            artifactType,
            batchNumber
         );
   }

   @Override
   public List<PlanArtifactAssembleMatchingDTO> listArtifactProcessByTaskOrderId(Long taskOrderId) {
      return this.baseMapper.listArtifactProcessByTaskOrderId(taskOrderId);
   }
}
