package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.enums.EnclosureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.biz.ProjectReceivedProblemBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivedProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedProblemDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedProblemDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListProductDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.put.ProjectReceivedProblemPutDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReceivedProblemService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.project.core.mapper.ProjectReceivedProblemMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProjectReceivedProblemBizImpl
   extends IBizImpl<ProjectReceivedProblemService, ProjectReceivedProblemMapper, ProjectReceivedProblem>
   implements ProjectReceivedProblemBiz {
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectReceivingRecordService receivingRecordService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private TechStandardPartService standardPartService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;

   @Override
   public PageVO<ProjectReceivedProblemDTO> getProblemPage(Long projectId, Long supplierId, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivedProblem> problemList = this.baseService
         .list(
            Wrappers.lambdaQuery(ProjectReceivedProblem.class)
               .eq(ProjectReceivedProblem::getProjectId, projectId)
               .eq(supplierId != null, ProjectReceivedProblem::getSupplierId, supplierId)
         );
      List<ProjectReceivedProblemDTO> dtoList = problemList.stream().map(e -> {
         ProjectReceivedProblemDTO problemDTO = BeanUtil.copy(e, ProjectReceivedProblemDTO.class);
         problemDTO.setSupplier(NameInfo.builder().name(e.getSupplierName()).id(e.getSupplierId()).build());
         if (StringUtils.isNotBlank(e.getAttachmentIds())) {
            problemDTO.setAttachmentDTOList(this.attachmentService.listByIds(e.getAttachmentIds()));
         }

         return problemDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(page, dtoList);
   }

   @Override
   public ProjectReceivedProblemDetailsDTO getProblemDetails(Long problemId) {
      ProjectReceivedProblem problem = this.baseService.getById(problemId);
      Preconditions.checkArgument(problem != null, "问题信息不存在！");
      MesBuildingCargoList cargoList = this.cargoListService.getById(problem.getCargoListId());
      ContractProject project = this.projectService.getById(problem.getProjectId());
      Preconditions.checkArgument(project != null, "项目信息不存在！");
      Preconditions.checkArgument(cargoList != null, "车次信息不存在！");
      List<ProjectReceivingRecord> productLinks = this.receivingRecordService
         .list(
            Wrappers.lambdaQuery(ProjectReceivingRecord.class)
               .eq(ProjectReceivingRecord::getProblemId, problem.getId())
               .orderByAsc(ProjectReceivingRecord::getProductType)
               .orderByAsc(ProjectReceivingRecord::getProductId)
         );
      List<ProjectCargoListProductDTO> productDTOList = productLinks.stream()
         .map(
            s -> {
               ProjectCargoListProductDTO detailsDTO = ProjectCargoListProductDTO.builder()
                  .quantity(s.getQuantity())
                  .productId(s.getProductId())
                  .productType(s.getProductType())
                  .accountingMete(s.getMete())
                  .problemDesc(s.getProblemDesc())
                  .build();
               if (s.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart machinePart = this.machinePartService.getById(s.getProductId());
                  BeanUtil.copy(machinePart, detailsDTO);
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(s.getProductId());
                  BeanUtil.copy(artifact, detailsDTO);
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(s.getProductId());
                  BeanUtil.copy(enclosure, detailsDTO);
                  detailsDTO.setMeasureUnit("张");
                  detailsDTO.setSpecification(
                     enclosure.getThickness() != null
                        ? enclosure.getThickness().intValue() + "*" + enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                        : enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                  );
                  Integer measureMode = this.contractTechService
                     .getMeasureMode(problem.getProjectId(), ProductTypeEnum.ENCLOSURE.getType(), enclosure.getCategory());
                  if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                     detailsDTO.setAccountingUnit("m");
                  }

                  if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
                     detailsDTO.setAccountingUnit("㎡");
                  }
               }

               if (s.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart auxiliaryMaterial = this.standardPartService.getById(s.getProductId());
                  BeanUtil.copy(auxiliaryMaterial, detailsDTO);
                  detailsDTO.setAccountingUnit(auxiliaryMaterial.getMeasureUnit());
                  detailsDTO.setMeasureUnit("件");
               }

               detailsDTO.setProject(this.projectService.getSimpleById(detailsDTO.getProjectId()));
               detailsDTO.setMonomer(detailsDTO.getMonomerId() != null ? this.monomerService.getSimpleById(detailsDTO.getMonomerId()) : null);
               detailsDTO.setArea(detailsDTO.getAreaId() != null ? this.areaService.getSimpleById(detailsDTO.getAreaId()) : null);
               return detailsDTO;
            }
         )
         .collect(Collectors.toList());
      ProjectReceivedProblemDetailsDTO problemDetailsDTO = new ProjectReceivedProblemDetailsDTO();
      problemDetailsDTO.setId(problem.getId());
      problemDetailsDTO.setProject(ProjectInfo.builder().id(project.getId()).shortName(project.getShortName()).serialNumber(project.getSerialNumber()).build());
      problemDetailsDTO.setProblemProductList(new ListVO<>(productDTOList));
      problemDetailsDTO.setUserName(problem.getUserName());
      problemDetailsDTO.setShippingTime(cargoList.getAuditTime());
      problemDetailsDTO.setReceivedTime(problem.getCreateTime());
      problemDetailsDTO.setRemark(problem.getRemark());
      if (StringUtils.isNotBlank(problem.getCloseAttachmentIds())) {
         problemDetailsDTO.setAttachmentDTOList(this.attachmentService.listByIds(problem.getCloseAttachmentIds()));
      }

      return problemDetailsDTO;
   }

   @Override
   public boolean closeProblem(ProjectReceivedProblemPutDTOParam param) {
      ProjectReceivedProblem problem = this.baseService.getById(param.getProblemId());
      Preconditions.checkArgument(problem != null, "问题信息不存在！");
      Preconditions.checkArgument(problem.getState().equals(0), "问题已关闭！");
      problem.setState(1);
      problem.setRemark(param.getDescribe());
      problem.setCloseAttachmentIds(
         CollectionUtils.isNotEmpty(param.getAttachmentIds()) ? org.apache.commons.lang3.StringUtils.join(param.getAttachmentIds(), ",") : null
      );
      this.baseService.updateById(problem);
      return true;
   }
}
