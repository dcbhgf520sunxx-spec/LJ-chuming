package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechArtifactBiz;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.check.TechArtifactRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactRemarkUpdateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactSpecAmendService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.check.TechArtifactRecordService;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechArtifactBizImpl implements TechArtifactBiz {
   private static final Logger log = LoggerFactory.getLogger(TechArtifactBizImpl.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechDrawingService techDrawingService;
   @Resource
   private TechArtifactSpecAmendService artifactSpecAmendService;
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private SysStructureSpecService structureSpecService;
   @Resource
   private SysStructureSerialNumberPrefixService serialNumberPrefixService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Resource
   private TechArtifactRecordService artifactRecordService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechEnclosureService enclosureService;

   @Override
   public PageVO<ArtifactResponseDTO> ListByConditions(
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
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Integer permissionCheck
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

      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, orderBy);
      List<ArtifactResponseDTO> artifactResponseDTOList = this.artifactService
         .listByCondition(projectId, monomerId, areaId, areaBatchId, status, name, serialNumber, specification, material, boolSchedulingEnum, null, null, null);
      artifactResponseDTOList.forEach(
         a -> {
            a.setSurfaceArea(a.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
            a.setTotalSurfaceArea(a.getSurfaceArea().multiply(BigDecimal.valueOf(a.getQuantity().intValue())));
            List<TechDrawing> techDrawings = this.techDrawingService
               .list(
                  (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                           .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                        .eq(TechDrawing::getSerialNumber, a.getSerialNumber()))
                     .eq(TechDrawing::getMonomerId, a.getMonomerId())
               );
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               a.setNumbers(techDrawings.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               a.setDrawingAndSerialNumber(
                  techDrawings.stream().map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }
         }
      );
      return new PageVO<>(artifactResponseDTOList);
   }

   @Override
   public List<ComponentCrderInformationDTO> selectByProjectId(Long projectId) {
      return this.artifactService.selectProjectGroupBySpec(projectId);
   }

   @Override
   public List<TechArtifact> selectByProductIds(List<Long> ids) {
      return this.artifactService.listByIds(ids);
   }

   @Override
   public ProductLineSummary selectByProjectIdAndLine(Long lineId, Long projectId, Integer type) {
      return this.artifactService.selectByProjectIdAndLine(lineId, projectId, type);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void fillArtifactFiled(Long structureClassId) {
      SysStructureClassification classification = this.structureClassificationService.getById(structureClassId);
      Preconditions.checkArgument(classification != null, "构件种类不存在");
      List<String> specPrefixList = this.structureSpecService
         .list(Wrappers.lambdaQuery(SysStructureSpec.builder().structureClassificationId(structureClassId).build()))
         .stream()
         .map(SysStructureSpec::getSpecPrefix)
         .collect(Collectors.toList());
      List<String> snPrefixList = new ArrayList<>(8);
      if (classification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
         snPrefixList = this.serialNumberPrefixService
            .list(Wrappers.lambdaQuery(SysStructureSerialNumberPrefix.builder().structureClassificationId(structureClassId).build()))
            .stream()
            .map(SysStructureSerialNumberPrefix::getSerialNumberPrefix)
            .collect(Collectors.toList());
      }

      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getStatus, ProjectStatusEnum.PROCESSING.getType(), ProjectStatusEnum.PAUSE.getType())
         );
      if (CollectionUtils.isNotEmpty(projectList)) {
         List<Long> projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
         List<TechArtifactRecord> artifactRecordList = this.artifactRecordService
            .list(
               (Wrapper<TechArtifactRecord>)(new LambdaQueryWrapper<TechArtifactRecord>().in(TechArtifactRecord::getProjectId, projectIds))
                  .isNull(TechArtifactRecord::getStructureClassId)
            );
         if (CollectionUtils.isNotEmpty(artifactRecordList)) {
            List<TechArtifactRecord> artifacts = new ArrayList<>(1024);
            List<String> finalSnPrefixList = snPrefixList;
            artifactRecordList.forEach(
               artifact -> {
                  if (classification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())
                     && specPrefixList.contains(artifact.getSpecPrefix())
                     && finalSnPrefixList.contains(artifact.getSerialNumberPrefix())) {
                     artifact.setStructureClassId(structureClassId);
                  } else if (classification.getArtifactType().equals(ArtifactTypeEnum.COMMON.getType()) && specPrefixList.contains(artifact.getSpecPrefix())) {
                     artifact.setStructureClassId(structureClassId);
                  }

                  if (artifact.getStructureClassId() != null) {
                     artifact.setArtifactType(classification.getArtifactType());
                     artifact.setCodingType(classification.getCodingType());
                     artifact.setBoolSchedulingEnum(true);
                     artifacts.add(artifact);
                  }
               }
            );
            if (CollectionUtils.isNotEmpty(artifacts)) {
               this.artifactRecordService.updateBatchById(artifacts);
               List<Long> artifactIds = artifacts.stream().map(TechArtifactRecord::getId).collect(Collectors.toList());
               this.artifactSpecAmendService.delByArtifactIds(artifactIds);
            }
         }
      }
   }

   @Override
   public Integer countNotScheduling(Long projectId, Long monomerId, Long areaId) {
      return this.artifactService
         .count(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(projectId != null, TechArtifact::getProjectId, projectId)
               .eq(monomerId != null, TechArtifact::getMonomerId, monomerId)
               .eq(areaId != null, TechArtifact::getAreaId, areaId)
               .eq(TechArtifact::getBoolSchedulingEnum, false)
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateArtifactRemark(List<ArtifactRemarkUpdateDtoParam> params) {
      params.forEach(param -> {
         TechArtifact artifact = this.artifactService.getById(param.getId());
         Preconditions.checkArgument(artifact != null, "构件不存在!");
         Preconditions.checkArgument(artifact.getBoolStatusEnum().equals(true), "构件处于暂停状态,不能修改备注!");
         this.projectService.checkProjectStatus(artifact.getProjectId());
         artifact.setRemark(param.getRemark());
         this.artifactService.updateById(artifact);
      });
      return true;
   }

   @Override
   public PageVO<ArtifactSimpleVO> getArtifactListBySerialNumber(
      String serialNumber, Integer pageNumber, Integer pageSize, Long projectId, Long monomerId, Long areaId
   ) {
      Page<ArtifactSimpleVO> page = PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactSimpleVO> voList = this.artifactService.getArtifactListBySerialNumber(serialNumber, projectId, monomerId, areaId);
      return new PageVO<>(page, voList);
   }

   @Override
   public PageVO<ArtifactSimpleVO> getArtifact(
      String serialNumber, Integer pageNumber, Integer pageSize, Long projectId, Long monomerId, Long areaId, Integer productType
   ) {
      Page<ArtifactSimpleVO> page = PageHelper.startPage(pageNumber, pageSize);
      if (productType == null || ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         List<ArtifactSimpleVO> voList = this.artifactService.getArtifact(serialNumber, projectId, monomerId, areaId);
         voList.forEach(e -> {
            if (StrUtil.isNotBlank(e.getNumber())) {
               List<String> numbers = Arrays.asList(e.getNumber().split(","));
               e.setNumbers(numbers);
            }
         });
         return new PageVO<>(page, voList);
      } else if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         List<ArtifactSimpleVO> voList = this.assembleService.getAssemble(serialNumber, projectId, monomerId, areaId);
         voList.forEach(e -> {
            if (StrUtil.isNotBlank(e.getNumber())) {
               List<String> numbers = Arrays.asList(e.getNumber().split(","));
               e.setNumbers(numbers);
            }
         });
         return new PageVO<>(page, voList);
      } else if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         List<ArtifactSimpleVO> voList = this.enclosureService.getEnclosure(serialNumber, projectId, monomerId, areaId);
         return new PageVO<>(page, voList);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public List<ArtifactResponseDTO> listByProjectIdAndStructureClassId(
      Long projectId, Long structureClassId, String name, String serialNumber, String specification, String material
   ) {
      List<ArtifactResponseDTO> artifactResponseDTOList = this.artifactService
         .listByCondition(projectId, structureClassId, name, serialNumber, specification, material);
      Preconditions.checkArgument(CollUtil.isNotEmpty(artifactResponseDTOList), "当前查询无构件清单数据");
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, artifactResponseDTOList.stream().map(ArtifactResponseDTO::getId).collect(Collectors.toList()))
               .isNull(TechArtifactExt::getBooleanPainting)
         );
      if (CollUtil.isNotEmpty(artifactExtList)) {
         List<Long> unassociatedArtifactIdList = artifactExtList.stream().map(TechArtifactExt::getArtifactId).collect(Collectors.toList());
         Map<Long, Long> unassociatedArtifactExtCountMap = artifactExtList.stream()
            .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId, Collectors.counting()));
         artifactResponseDTOList = artifactResponseDTOList.stream()
            .filter(dto -> unassociatedArtifactIdList.contains(dto.getId()))
            .peek(dto -> dto.setQuantity(unassociatedArtifactExtCountMap.get(dto.getId()).intValue()))
            .collect(Collectors.toList());
      }

      return artifactResponseDTOList;
   }
}
