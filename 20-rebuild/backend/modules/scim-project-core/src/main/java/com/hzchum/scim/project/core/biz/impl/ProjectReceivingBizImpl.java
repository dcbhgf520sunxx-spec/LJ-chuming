package com.hzchum.scim.project.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.DivideMethodEnum;
import com.hzchum.scim.contract.core.api.enums.EnclosureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListRecordDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.enums.AreaTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductDeepenMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.TechProductDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.biz.ProjectReceivingBiz;
import com.hzchum.scim.project.core.api.enums.BoolProblemReceivingEnum;
import com.hzchum.scim.project.core.api.enums.OutReceiveState;
import com.hzchum.scim.project.core.api.enums.ProductTypeUpEnum;
import com.hzchum.scim.project.core.api.enums.SourceTypeEnum;
import com.hzchum.scim.project.core.api.enums.StoreTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivedProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.pojo._doModel.ProjectPurchaseOrderReceivedOperateRecord;
import com.hzchum.scim.project.core.api.pojo.daoParam.ReceivingBoardQueryDOParam;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallMeteSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectPurchaseOrderSimpleDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectPurchaseProductDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedInstallStoreMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedInstallStoreSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedOperateRecordDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallSumDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingRecordDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubAppReceivingDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListProductDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListReceivingDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.CargoListQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectConfirmCargoListReceivingDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectConfirmCargoListReceivingDTOParamV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectPurchaseReceiveDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectPurchaseReceivingDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectReceiveProductDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderProductLinkService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.api.service.ProjectPurchaseOrderReceivedOperateRecordService;
import com.hzchum.scim.project.core.api.service.ProjectReceivedProblemService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.project.core.api.utils.ProjectInstallBizUtil;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDTO;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectReceivingBizImpl implements ProjectReceivingBiz {
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private ProjectReceivingRecordService receivingRecordService;
   @Resource
   private ProjectReceivingSummaryService receivingSummaryService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechStandardPartService standardPartService;
   @Resource
   private ProjectInstallBizUtil projectInstallBizUtil;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   private ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   private ProjectInstallReportService installReportService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private ProjectReceivedProblemService problemService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectLaborSubsupplierOrderProductLinkService orderProductLinkService;
   @Resource
   private ProjectManageRosterService rosterService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   private MeasureService measureService;
   @Resource
   private ProjectPurchaseOrderReceivedOperateRecordService receivedOperateRecordService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SpecificationService specificationService;
   @Resource
   ApplyPurchaseService applyPurchaseService;

   @Override
   public PageVO<ProjectCargoListReceivingDTO> listProjectSelfReceiving(CargoListQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      PageHelper.startPage(pageNumber, pageSize);
      if (param.getStatus() == null) {
         param.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      }

      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持建钢和桥梁外的其他项目类型...");
      }

      List<MesBuildingCargoList> cargoListDOList = this.cargoListService.listCargoRecord(BeanUtil.copy(param, CargoListRecordDTOParam.class));
      List<ProjectCargoListReceivingDTO> receivingDTOList = cargoListDOList.stream().map(s -> {
         ProjectCargoListReceivingDTO receivingDTO = BeanUtil.copy(s, ProjectCargoListReceivingDTO.class);
         receivingDTO.setProject(this.projectService.getSimpleById(s.getProjectId()));
         return receivingDTO;
      }).collect(Collectors.toList());
      PageInfo<ProjectCargoListReceivingDTO> pageInfo = PageUtils.getPageInfo(receivingDTOList, cargoListDOList);
      return new PageVO<>(pageInfo);
   }

   @Override
   public ListVO<ProjectCargoListProductDTO> listCargoListProduct(Long cargoListId, Long projectId) {
      return new ListVO<>(this.privateListReceivingDetails(cargoListId, projectId));
   }

   @Override
   public ListVO<ProjectCargoListProductDTO> listCargoListProductUp(Long cargoListId, Long projectId) {
      return new ListVO<>(this.privateListReceivingDetailsUp(cargoListId, projectId));
   }

   @Override
   public ListVO<ProjectCargoListProductDTO> listCargoListProductV2(Long cargoListId) {
      return new ListVO<>(this.privateListReceivingDetailsV2(cargoListId));
   }

   private List<ProjectCargoListProductDTO> privateListReceivingDetails(Long cargoListId, Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂时支持建钢项目和较量项目!!!");
      }

      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      Preconditions.checkArgument(cargoList != null, "发货记录不存在");
      List<MesBuildingCargoListProductLink> productLinks = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId)
               .orderByAsc(MesBuildingCargoListProductLink::getProductType)
               .orderByAsc(MesBuildingCargoListProductLink::getProductId)
         );
      return productLinks.stream()
         .map(
            s -> {
               ProjectCargoListProductDTO detailsDTO = ProjectCargoListProductDTO.builder()
                  .boolProblemReceiving(s.getBoolProblemReceiving())
                  .productId(s.getProductId())
                  .productType(s.getProductType())
                  .build();
               if (s.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart machinePart = this.machinePartService.getById(s.getProductId());
                  BeanUtil.copy(machinePart, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight());
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  TechAssemble techAssemble = this.assembleService.getById(s.getProductId());
                  BeanUtil.copy(techAssemble, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight());
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(s.getProductId());
                  BeanUtil.copy(artifact, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight());
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(s.getProductId());
                  BeanUtil.copy(enclosure, detailsDTO);
                  detailsDTO.setMonomerId(null);
                  detailsDTO.setAreaId(enclosure.getEnclosurePlanId());
                  detailsDTO.setMeasureUnit("张");
                  detailsDTO.setSpecification(
                     enclosure.getThickness() != null
                        ? enclosure.getThickness().intValue() + "*" + enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                        : enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                  );
                  Integer measureMode = this.contractTechService
                     .getMeasureMode(cargoList.getProjectId(), ProductTypeEnum.ENCLOSURE.getType(), enclosure.getCategory());
                  if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                     detailsDTO.setAccountingMete(s.getLength().multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000L)));
                     detailsDTO.setAccountingUnit("m");
                  }

                  if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
                     detailsDTO.setAccountingMete(
                        enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000000L))
                     );
                     detailsDTO.setAccountingUnit("㎡");
                  }
               }

               if (s.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart auxiliaryMaterial = this.standardPartService.getById(s.getProductId());
                  BeanUtil.copy(auxiliaryMaterial, detailsDTO);
                  detailsDTO.setAccountingMete(
                     auxiliaryMaterial.getMete().multiply(s.getQuantity()).divide(auxiliaryMaterial.getQuantity(), 4, RoundingMode.HALF_UP)
                  );
                  detailsDTO.setAccountingUnit(auxiliaryMaterial.getAccountingUnit());
                  detailsDTO.setMeasureUnit(auxiliaryMaterial.getMeasureUnit());
               }

               detailsDTO.setProject(this.projectService.getSimpleById(detailsDTO.getProjectId()));
               detailsDTO.setMonomer(detailsDTO.getMonomerId() != null ? this.monomerService.getSimpleById(detailsDTO.getMonomerId()) : null);
               if (detailsDTO.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(detailsDTO.getAreaId());
                  detailsDTO.setArea(BeanUtil.copy(enclosurePlan, NameInfo.class));
               } else {
                  detailsDTO.setArea(detailsDTO.getAreaId() != null ? this.areaService.getSimpleById(detailsDTO.getAreaId()) : null);
               }

               detailsDTO.setQuantity(s.getQuantity());
               return detailsDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private List<ProjectCargoListProductDTO> privateListReceivingDetailsUp(Long cargoListId, Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂时支持建钢项目和较量项目!!!");
      }

      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      Preconditions.checkArgument(cargoList != null, "发货记录不存在");
      List<MesBuildingCargoListProductLink> productLinks = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId)
               .orderByAsc(MesBuildingCargoListProductLink::getProductType)
               .orderByAsc(MesBuildingCargoListProductLink::getProductId)
         );
      return productLinks.stream()
         .map(
            s -> {
               ProjectCargoListProductDTO detailsDTO = ProjectCargoListProductDTO.builder()
                  .boolProblemReceiving(s.getBoolProblemReceiving())
                  .productId(s.getProductId())
                  .productType(s.getProductType())
                  .build();
               if (s.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart machinePart = this.machinePartService.getById(s.getProductId());
                  BeanUtil.copy(machinePart, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight());
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  TechAssemble techAssemble = this.assembleService.getById(s.getProductId());
                  BeanUtil.copy(techAssemble, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight());
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(s.getProductId());
                  BeanUtil.copy(artifact, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight());
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(s.getProductId());
                  BeanUtil.copy(enclosure, detailsDTO);
                  detailsDTO.setMeasureUnit("张");
                  BigDecimal thickness = enclosure.getThickness() != null ? enclosure.getThickness() : BigDecimal.ZERO;
                  BigDecimal weight = enclosure.getUnfoldedWidth() != null ? enclosure.getUnfoldedWidth() : BigDecimal.ZERO;
                  BigDecimal length = enclosure.getLength() != null ? enclosure.getLength() : BigDecimal.ZERO;
                  detailsDTO.setSpecification(
                     thickness.stripTrailingZeros().toPlainString()
                        + "*"
                        + weight.stripTrailingZeros().toPlainString()
                        + "*"
                        + length.stripTrailingZeros().toPlainString()
                  );
                  detailsDTO.setAccountingMete(enclosure.getLength().multiply(s.getQuantity()).divide(BigDecimal.valueOf(1000L)));
                  detailsDTO.setAccountingUnit("m");
               }

               if (s.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart auxiliaryMaterial = this.standardPartService.getById(s.getProductId());
                  BeanUtil.copy(auxiliaryMaterial, detailsDTO);
                  detailsDTO.setAccountingMete(
                     auxiliaryMaterial.getMete().multiply(s.getQuantity()).divide(auxiliaryMaterial.getQuantity(), 4, RoundingMode.HALF_UP)
                  );
                  detailsDTO.setAccountingUnit(auxiliaryMaterial.getAccountingUnit());
                  detailsDTO.setMeasureUnit(auxiliaryMaterial.getMeasureUnit());
               }

               detailsDTO.setProject(this.projectService.getSimpleById(detailsDTO.getProjectId()));
               detailsDTO.setMonomer(detailsDTO.getMonomerId() != null ? this.monomerService.getSimpleById(detailsDTO.getMonomerId()) : null);
               detailsDTO.setArea(detailsDTO.getAreaId() != null ? this.areaService.getSimpleById(detailsDTO.getAreaId()) : null);
               detailsDTO.setQuantity(s.getQuantity());
               return detailsDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private List<ProjectCargoListProductDTO> privateListReceivingDetailsV2(Long cargoListId) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      Preconditions.checkArgument(cargoList != null, "发货记录不存在");
      if (cargoList.getStatus().equals(CargoListStatusEnum.RECEIPT.getType())) {
         throw new BusinessException("该车次已完成收货！");
      }

      ContractProject project = this.projectService.getById(cargoList.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂时支持建钢项目和较量项目!!!");
      }

      List<MesBuildingCargoListProductLink> productLinks = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId)
               .orderByAsc(MesBuildingCargoListProductLink::getProductType)
               .orderByAsc(MesBuildingCargoListProductLink::getProductId)
         );
      List<ProjectReceivingRecord> receivedRecordList = this.receivingRecordService
         .list(
            Wrappers.lambdaQuery(ProjectReceivingRecord.class)
               .eq(ProjectReceivingRecord::getSourceId, cargoListId)
               .eq(ProjectReceivingRecord::getSourceType, SourceTypeEnum.SELF_SOURCE.getType())
               .in(ProjectReceivingRecord::getProjectType, ProjectTypeEnum.MES.getType(), ProjectTypeEnum.BRIDGE.getType())
         );
      Map<Long, BigDecimal> quantityMap = receivedRecordList.stream()
         .collect(
            Collectors.groupingBy(ProjectReceivingRecord::getLinkId, Collectors.reducing(BigDecimal.ZERO, ProjectReceivingRecord::getQuantity, BigDecimal::add))
         );
      return productLinks.stream()
         .map(
            s -> {
               ProjectCargoListProductDTO detailsDTO = ProjectCargoListProductDTO.builder()
                  .linkId(s.getId())
                  .productId(s.getProductId())
                  .productType(s.getProductType())
                  .build();
               BigDecimal receivedQuantity = quantityMap.getOrDefault(s.getId(), BigDecimal.ZERO);
               BigDecimal canReceivedQuantity = s.getQuantity().subtract(receivedQuantity);
               BigDecimal p = canReceivedQuantity.divide(s.getQuantity(), 20, 4);
               if (s.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart machinePart = this.machinePartService.getById(s.getProductId());
                  BeanUtil.copy(machinePart, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight().multiply(p).setScale(3, 4));
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  TechAssemble techAssemble = this.assembleService.getById(s.getProductId());
                  BeanUtil.copy(techAssemble, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight().multiply(p).setScale(3, 4));
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setMeasureUnit("件");
               }

               if (s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(s.getProductId());
                  BeanUtil.copy(artifact, detailsDTO);
                  detailsDTO.setAccountingMete(s.getWeight().multiply(p).setScale(3, 4));
                  detailsDTO.setMeasureUnit("件");
                  detailsDTO.setAccountingUnit("kg");
               }

               if (s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(s.getProductId());
                  BeanUtil.copy(enclosure, detailsDTO);
                  detailsDTO.setMeasureUnit("张");
                  BigDecimal thickness = enclosure.getThickness() != null ? enclosure.getThickness() : BigDecimal.ZERO;
                  BigDecimal weight = enclosure.getUnfoldedWidth() != null ? enclosure.getUnfoldedWidth() : BigDecimal.ZERO;
                  BigDecimal length = enclosure.getLength() != null ? enclosure.getLength() : BigDecimal.ZERO;
                  detailsDTO.setSpecification(
                     thickness.stripTrailingZeros().toPlainString()
                        + "*"
                        + weight.stripTrailingZeros().toPlainString()
                        + "*"
                        + length.stripTrailingZeros().toPlainString()
                  );
                  detailsDTO.setAccountingMete(enclosure.getLength().multiply(canReceivedQuantity).divide(BigDecimal.valueOf(1000L)));
                  detailsDTO.setAccountingUnit("m");
               }

               if (s.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart auxiliaryMaterial = this.standardPartService.getById(s.getProductId());
                  BeanUtil.copy(auxiliaryMaterial, detailsDTO);
                  detailsDTO.setAccountingMete(
                     auxiliaryMaterial.getMete().multiply(canReceivedQuantity).divide(auxiliaryMaterial.getQuantity(), 4, RoundingMode.HALF_UP)
                  );
                  detailsDTO.setAccountingUnit(auxiliaryMaterial.getAccountingUnit());
                  detailsDTO.setMeasureUnit(auxiliaryMaterial.getMeasureUnit());
               }

               detailsDTO.setProject(this.projectService.getSimpleById(detailsDTO.getProjectId()));
               detailsDTO.setMonomer(detailsDTO.getMonomerId() != null ? this.monomerService.getSimpleById(detailsDTO.getMonomerId()) : null);
               detailsDTO.setArea(detailsDTO.getAreaId() != null ? this.areaService.getSimpleById(detailsDTO.getAreaId()) : null);
               detailsDTO.setQuantity(canReceivedQuantity);
               return detailsDTO;
            }
         )
         .filter(e -> e.getQuantity().compareTo(BigDecimal.ZERO) > 0)
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListCargoListProduct(Long cargoListId, Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(projectId);
      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      header.put("receiveUserName", StrUtil.isNotBlank(cargoList.getAuditReceiptName()) ? cargoList.getAuditReceiptName() : "");
      header.put("receiveDate", cargoList.getAuditReceiptTime() != null ? cargoList.getAuditReceiptTime() : "");
      header.put("licensePlate", StrUtil.isNotBlank(cargoList.getLicensePlate()) ? cargoList.getLicensePlate() : "");
      header.put("project", project);
      header.put("totalQuantity", BigDecimal.ZERO);
      List<ProjectCargoListProductDTO> list = this.privateListReceivingDetails(cargoListId, projectId);
      if (CollUtil.isNotEmpty(list)) {
         BigDecimal totalQuantity = list.stream()
            .map(ProjectCargoListProductDTO::getQuantity)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalQuantity", totalQuantity);
      }

      List<Map<String, Object>> mapList = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListCargoListProductUp(Long cargoListId, Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(projectId);
      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      header.put("receiveUserName", StrUtil.isNotBlank(cargoList.getAuditReceiptName()) ? cargoList.getAuditReceiptName() : "");
      header.put("receiveDate", cargoList.getAuditReceiptTime() != null ? cargoList.getAuditReceiptTime() : "");
      header.put("licensePlate", StrUtil.isNotBlank(cargoList.getLicensePlate()) ? cargoList.getLicensePlate() : "");
      header.put("project", project);
      header.put("totalQuantity", BigDecimal.ZERO);
      List<ProjectCargoListProductDTO> list = this.privateListReceivingDetailsUp(cargoListId, projectId);
      if (CollUtil.isNotEmpty(list)) {
         BigDecimal totalQuantity = list.stream()
            .map(ProjectCargoListProductDTO::getQuantity)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalQuantity", totalQuantity);
      }

      List<Map<String, Object>> mapList = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean confirmCargoListReceiving(ProjectConfirmCargoListReceivingDTOParam param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持其他项目类型收货!!!");
      }

      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getCargoListId());
      Preconditions.checkArgument(cargoList != null, "收货失败,数据不存在");
      Preconditions.checkArgument(!cargoList.getStatus().equals(CargoListStatusEnum.RECEIPT.getType()), "收货失败,本次发货记录已确认收货");
      Preconditions.checkArgument(cargoList.getStatus().equals(CargoListStatusEnum.SHIPMENT.getType()), "收货失败,本次发货未发车");
      Preconditions.checkArgument(
         param.getBoolProblemReceiving().equals(BoolProblemReceivingEnum.NORMAL_RECEIVING.isType()) || StringUtils.isNotBlank(param.getProblemDesc()),
         "收货失败,请填写问题描述"
      );
      cargoList.setBoolProblemReceiving(param.getBoolProblemReceiving());
      cargoList.setProblemDesc(param.getBoolProblemReceiving() ? param.getProblemDesc() : null);
      cargoList.setStatus(CargoListStatusEnum.RECEIPT.getType());
      cargoList.setAuditReceiptId(UserUtil.getCurrentUserId());
      cargoList.setAuditReceiptName(UserUtil.getCurrentName());
      cargoList.setAuditReceiptTime(LocalDateTime.now());
      cargoList.setShipmentStatus(ShipmentStatusEnum.SIGN_IN.getType());
      cargoList.setStatusUpdateDate(LocalDateTime.now());
      this.cargoListService.updateById(cargoList);
      this.saveReceiving(param.getCargoListId(), project.getProjectType());
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean confirmCargoListReceivingV2(ProjectConfirmCargoListReceivingDTOParamV2 param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持其他项目类型收货!!!");
      }

      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getCargoListId());
      Preconditions.checkArgument(cargoList != null, "收货失败,数据不存在");
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectIds), "操作失败,当前登陆人未配置可见项目!");
      Preconditions.checkArgument(projectIds.contains(cargoList.getProjectId()), "操作失败,当前登陆人可见项目未包含该包所在项目!");
      Preconditions.checkArgument(!cargoList.getStatus().equals(CargoListStatusEnum.RECEIPT.getType()), "收货失败,本次发货记录已确认收货");
      Preconditions.checkArgument(cargoList.getStatus().equals(CargoListStatusEnum.SHIPMENT.getType()), "收货失败,本次发货未发车");
      List<ProjectReceiveProductDTOParam> receiveProductDTOParam = param.getReceiveProductDTOParam();
      List<ProjectCargoListProductDTO> cargoListProductDTOList = this.privateListReceivingDetailsV2(param.getCargoListId());
      Map<Long, BigDecimal> cargoCanReceivedMap = cargoListProductDTOList.stream()
         .collect(
            Collectors.groupingBy(
               ProjectCargoListProductDTO::getLinkId, Collectors.reducing(BigDecimal.ZERO, ProjectCargoListProductDTO::getQuantity, BigDecimal::add)
            )
         );
      boolean isAll = true;

      for (ProjectReceiveProductDTOParam receivedParam : receiveProductDTOParam) {
         Long key = receivedParam.getLinkId();
         Preconditions.checkArgument(cargoCanReceivedMap.containsKey(key), "可收货产品不存在！请刷新重试！");
         BigDecimal quantity = cargoCanReceivedMap.get(key);
         Preconditions.checkArgument(quantity.compareTo(receivedParam.getQuantity()) >= 0, "产品可收货数量不足！");
         if (receivedParam.getQuantity().compareTo(quantity) != 0) {
            isAll = false;
         }
      }

      if (!Boolean.valueOf(BoolProblemReceivingEnum.PROBLEM_RECEIVING.isType()).equals(cargoList.getBoolProblemReceiving())) {
         cargoList.setBoolProblemReceiving(param.getBoolProblemReceiving());
      }

      cargoList.setShipmentStatus(ShipmentStatusEnum.SIGN_IN.getType());
      if (cargoListProductDTOList.size() == receiveProductDTOParam.size() && isAll) {
         cargoList.setStatus(CargoListStatusEnum.RECEIPT.getType());
         cargoList.setStatusUpdateDate(LocalDateTime.now());
      }

      cargoList.setAuditReceiptId(UserUtil.getCurrentUserId());
      cargoList.setAuditReceiptName(UserUtil.getCurrentName());
      cargoList.setAuditReceiptTime(LocalDateTime.now());
      this.cargoListService.updateById(cargoList);
      Long problemId = null;
      if (Boolean.valueOf(BoolProblemReceivingEnum.PROBLEM_RECEIVING.isType()).equals(param.getBoolProblemReceiving())) {
         ProjectReceivedProblem problem = new ProjectReceivedProblem();
         problem.setProjectId(project.getId());
         problem.setCargoListId(cargoList.getId());
         problem.setLicensePlate(cargoList.getLicensePlate());
         problem.setUserId(UserUtil.getCurrentUserId());
         problem.setUserName(UserUtil.getCurrentName());
         problem.setAttachmentIds(StringUtils.join(param.getProblemAttachmentIds().stream().distinct().collect(Collectors.toList()), ","));
         this.problemService.save(problem);
         problemId = problem.getId();
      }

      this.saveReceivingV2(param.getBoolProblemReceiving(), problemId, param.getCargoListId(), project.getProjectType(), param.getReceiveProductDTOParam());
      return true;
   }

   @Override
   public List<ProjectPurchaseOrderSimpleDTO> getPurchaseOrderSimpleInfo(Long projectId, Long supplierId) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            (Wrapper<PurchaseOrder>)(((((Wrappers.<PurchaseOrder>lambdaQuery()
                              .eq(supplierId != null, PurchaseOrder::getSupplierId, supplierId))
                           .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId)))
                        .eq(PurchaseOrder::getOrderPlace, 1))
                     .eq(PurchaseOrder::getPurchaseStatus, 1))
                  .eq(PurchaseOrder::getDataStatus, 2))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(orderList)) {
         return new ArrayList<>();
      }

      List<Long> projectIds = orderList.stream().map(e -> Long.valueOf(e.getProjectIds())).collect(Collectors.toList());
      List<Long> supplierIds = orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toList());
      Map<Long, String> projectNameMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, ContractProject::getName));
      Map<Long, String> supplierNameMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      return orderList.stream().map(e -> {
         ProjectPurchaseOrderSimpleDTO simpleDTO = BeanUtil.copy(e, ProjectPurchaseOrderSimpleDTO.class);
         simpleDTO.setSupplierName(supplierNameMap.getOrDefault(e.getSupplierId(), null));
         simpleDTO.setProjectName(projectNameMap.getOrDefault(Long.valueOf(e.getProjectIds()), null));
         return simpleDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public List<SupplierInfo> getPurchaseOrderSupplier(Long projectId) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            (Wrapper<PurchaseOrder>)(((Wrappers.<PurchaseOrder>lambdaQuery()
                        .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId)))
                     .eq(PurchaseOrder::getOrderPlace, 1))
                  .eq(PurchaseOrder::getPurchaseStatus, 1))
               .eq(PurchaseOrder::getDataStatus, 2)
         )
         .stream()
         .filter(
            e -> CollectionUtils.isNotEmpty(
               this.purchaseOrderDetailService.list(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, e.getId()))
            )
         )
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(orderList)) {
         return new ArrayList<>();
      }

      List<Long> orderSupplierIds = orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toList());
      return this.supplierService
         .listByIds(orderSupplierIds)
         .stream()
         .map(e -> SupplierInfo.builder().supplierId(e.getId()).supplierName(e.getName()).build())
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectPurchaseProductDetailsDTO> getPurchaseProductDetailsInfo(
      Long contractId, String name, String serialNumber, String specification, String material
   ) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(contractId);
      Preconditions.checkArgument(purchaseOrder != null, "采购合同不存在,请刷新重试！");
      ContractProject project = this.projectService.getById(Integer.valueOf(purchaseOrder.getProjectIds()));
      Preconditions.checkArgument(project != null, "项目不存在");
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂时支持建钢项目和较量项目!!!");
      } else if (purchaseOrder.getPurchaseType().equals(1)) {
         return this.getCanReceiveMaterialList(name, serialNumber, specification, purchaseOrder.getId());
      } else {
         return purchaseOrder.getPurchaseType().equals(2)
            ? this.getCanReceiveManufacturedList(name, serialNumber, specification, material, purchaseOrder)
            : new ArrayList<>();
      }
   }

   private List<ProjectPurchaseProductDetailsDTO> getCanReceiveMaterialList(String name, String serialNumber, String specification, Long purchaseId) {
      List<PurchaseOrderDetail> orderDetailList = this.purchaseOrderDetailService
         .list(
            Wrappers.lambdaQuery(PurchaseOrderDetail.class)
               .eq(PurchaseOrderDetail::getPurchaseId, purchaseId)
               .like(StrUtil.isNotBlank(name), PurchaseOrderDetail::getClassifyName, name)
               .like(StrUtil.isNotBlank(serialNumber), PurchaseOrderDetail::getMaterialSn, serialNumber)
               .like(StrUtil.isNotBlank(specification), PurchaseOrderDetail::getSpecification, specification)
               .apply("(quantity > received_quantity or mete > received_mete)")
         );
      return orderDetailList.stream().map(e -> {
         ProjectPurchaseProductDetailsDTO detailsDTO = BeanUtil.copy(e, ProjectPurchaseProductDetailsDTO.class);
         SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(e.getClassifyId());
         detailsDTO.setDetailId(e.getId());
         detailsDTO.setClassifyId(e.getClassifyId());
         detailsDTO.setName(e.getClassifyName());
         detailsDTO.setQuantity(e.getQuantity());
         detailsDTO.setSerialNumber(e.getMaterialSn());
         detailsDTO.setMete(e.getMete());
         if (e.getQuantity() != null) {
            detailsDTO.setCanReceivedQuantity(e.getQuantity().subtract(e.getReceivedQuantity()));
         }

         if (e.getMete() != null) {
            detailsDTO.setCanReceivedMete(e.getMete().subtract(e.getReceivedMete()));
         }

         if (subjectMeasureDTO != null) {
            detailsDTO.setMeasureUnit(subjectMeasureDTO.getMeasureUnit());
            detailsDTO.setAccountingUnit(subjectMeasureDTO.getAccountingUnit());
            detailsDTO.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
            detailsDTO.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
         }

         return detailsDTO;
      }).collect(Collectors.toList());
   }

   public void setSpecs(PurchaseOrderDetail detailDO, StringBuilder sb, StringBuilder lengths, StringBuilder material) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : "";
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : "";
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : "";
      boolean b = StrUtil.isNotBlank(detailDO.getSpecification());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         lengths.append(length);
         material.append(StrUtil.isNotBlank(detailDO.getSpecification()) ? detailDO.getSpecification() : "-");
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
         lengths = lengths.append(length);
         if (b && detailDO.getSpecification().contains("*")) {
            int index = detailDO.getSpecification().lastIndexOf("*");
            if (index != -1) {
               String result = detailDO.getSpecification().substring(0, index);
               sb.append(result);
            }

            String[] parts = detailDO.getSpecification().split("\\*");
            String lastPart = parts[parts.length - 1];
            material.append(StrUtil.isNotBlank(lastPart) ? lastPart : "-");
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness)
            .append("*")
            .append(width)
            .append("*")
            .append(detailDO.getLength().divide(BigDecimal.valueOf(1000L)).stripTrailingZeros().toPlainString());
         if (b) {
            if (detailDO.getSpecification().contains("*")) {
               int index = detailDO.getSpecification().lastIndexOf("*");
               if (index != -1) {
                  String result = detailDO.getSpecification().substring(0, index);
                  sb.append(result);
               }

               String[] parts = detailDO.getSpecification().split("\\*");
               String lastPart = parts[parts.length - 1];
               material.append(lastPart);
            } else {
               material.append(detailDO.getSpecification());
            }
         }

         if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(" * ").append(detailDO.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         if (StrUtil.isNotBlank(detailDO.getSpecification())) {
            sb.append(detailDO.getSpecification());
            if (StrUtil.isNotBlank(detailDO.getColor())) {
               sb.append(" * ").append(detailDO.getColor());
            }
         } else if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(detailDO.getColor());
         }
      }
   }

   private List<ProjectPurchaseProductDetailsDTO> getCanReceiveManufacturedList(
      String name, String serialNumber, String specification, String material, PurchaseOrder purchaseOrder
   ) {
      List<PurchaseOrderDetail> orderDetailList = this.purchaseOrderDetailService
         .list(
            Wrappers.lambdaQuery(PurchaseOrderDetail.class)
               .eq(PurchaseOrderDetail::getPurchaseId, purchaseOrder.getId())
               .like(StrUtil.isNotBlank(name), PurchaseOrderDetail::getManufacturedName, name)
               .like(StrUtil.isNotBlank(serialNumber), PurchaseOrderDetail::getManufacturedSn, serialNumber)
               .like(StrUtil.isNotBlank(material), PurchaseOrderDetail::getMaterial, material)
               .like(StrUtil.isNotBlank(specification), PurchaseOrderDetail::getSpecification, specification)
               .apply("quantity > received_quantity")
         );
      Integer productType = null;
      if (Integer.valueOf(32).equals(purchaseOrder.getBasicClass())) {
         productType = ProductTypeEnum.ARTIFACT.getType();
      }

      if (Integer.valueOf(64).equals(purchaseOrder.getBasicClass())) {
         productType = ProductTypeEnum.ENCLOSURE.getType();
      }

      Preconditions.checkArgument(productType != null, "产品类型有误！暂仅支持结构和围护制品");
      Integer finalProductType = productType;
      return orderDetailList.stream()
         .map(
            e -> {
               ProjectPurchaseProductDetailsDTO detailsDTO = BeanUtil.copy(e, ProjectPurchaseProductDetailsDTO.class);
               detailsDTO.setDetailId(e.getId());
               detailsDTO.setProductType(e.getManufacturedType());
               detailsDTO.setProductId(e.getArtifactEnclosureId());
               detailsDTO.setProductType(finalProductType);
               detailsDTO.setName(e.getManufacturedName());
               detailsDTO.setQuantity(e.getQuantity());
               detailsDTO.setSerialNumber(e.getManufacturedSn());
               detailsDTO.setCanReceivedQuantity(e.getQuantity().subtract(e.getReceivedQuantity()));
               detailsDTO.setMonomer(detailsDTO.getMonomerId() != null ? this.monomerService.getSimpleById(detailsDTO.getMonomerId()) : null);
               detailsDTO.setArea(detailsDTO.getAreaId() != null ? this.areaService.getSimpleById(detailsDTO.getAreaId()) : null);
               if (finalProductType.equals(ProductTypeEnum.ARTIFACT.getType())) {
                  detailsDTO.setMete(e.getTotalWeight().divide(BigDecimal.valueOf(1000L)));
                  detailsDTO.setMeasureUnit("件");
               }

               if (finalProductType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(e.getArtifactEnclosureId());
                  BeanUtil.copy(enclosure, detailsDTO);
                  detailsDTO.setMeasureUnit("张");
                  detailsDTO.setMonomer(enclosure.getMonomerId() != null ? this.monomerService.getSimpleById(enclosure.getMonomerId()) : null);
                  detailsDTO.setArea(enclosure.getAreaId() != null ? this.areaService.getSimpleById(enclosure.getAreaId()) : null);
                  BigDecimal thickness = enclosure.getThickness() != null ? enclosure.getThickness() : BigDecimal.ZERO;
                  BigDecimal weight = enclosure.getUnfoldedWidth() != null ? enclosure.getUnfoldedWidth() : BigDecimal.ZERO;
                  BigDecimal length = enclosure.getLength() != null ? enclosure.getLength() : BigDecimal.ZERO;
                  detailsDTO.setSpecification(
                     thickness.stripTrailingZeros().toPlainString()
                        + "*"
                        + weight.stripTrailingZeros().toPlainString()
                        + "*"
                        + length.stripTrailingZeros().toPlainString()
                  );
               }

               if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == e.getWageQuotaType()) {
                  detailsDTO.setMete(e.getQuantity());
                  detailsDTO.setAccountingUnit(ProductTypeEnum.ARTIFACT.getType().equals(finalProductType) ? "件" : "张");
                  detailsDTO.setCanReceivedMete(detailsDTO.getMete().subtract(e.getReceivedMete()));
               } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == e.getWageQuotaType()) {
                  detailsDTO.setMete(e.getTotalLength().divide(BigDecimal.valueOf(1000L)));
                  detailsDTO.setCanReceivedMete(detailsDTO.getMete().subtract(e.getReceivedMete().divide(BigDecimal.valueOf(1000L))));
                  detailsDTO.setAccountingUnit("m");
               } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == e.getWageQuotaType()) {
                  detailsDTO.setMete(e.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
                  detailsDTO.setAccountingUnit("㎡");
                  detailsDTO.setCanReceivedMete(detailsDTO.getMete().subtract(e.getReceivedMete().divide(BigDecimal.valueOf(1000000L))));
               } else {
                  if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != e.getWageQuotaType()) {
                     throw new BusinessException("制成品计价方式类型不存在！");
                  }

                  detailsDTO.setMete(e.getTotalWeight().divide(BigDecimal.valueOf(1000L)));
                  detailsDTO.setAccountingUnit("kg");
                  detailsDTO.setCanReceivedMete(detailsDTO.getMete().subtract(e.getReceivedMete().divide(BigDecimal.valueOf(1000L))));
               }

               return detailsDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional
   @Override
   public Boolean purchaseReceiving(ProjectPurchaseReceivingDTOParam param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      if (!project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持其他项目类型收货!!!");
      }

      List<ProjectPurchaseProductDetailsDTO> detailsDTOList = this.getPurchaseProductDetailsInfo(param.getContractId(), null, null, null, null);
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(param.getContractId());
      Preconditions.checkArgument(purchaseOrder.getPurchaseStatus().equals(1), "操作失败，采购单状态为已完成!");
      List<ProjectPurchaseReceiveDTOParam> receiveParamList = param.getReceiveDTOParam();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailsDTOList), "操作失败！,没有可收货的产品！");
      Preconditions.checkArgument(
         receiveParamList.size() == receiveParamList.stream().map(ProjectPurchaseReceiveDTOParam::getDetailId).distinct().count(), "操作失败！采购详情id重复!"
      );
      Map<Long, BigDecimal> canReceivedMap = detailsDTOList.stream()
         .collect(
            Collectors.toMap(
               ProjectPurchaseProductDetailsDTO::getDetailId,
               e -> e.getQuantity() != null && e.getQuantity().compareTo(BigDecimal.ZERO) > 0 ? e.getCanReceivedQuantity() : e.getCanReceivedMete()
            )
         );
      boolean flag = true;

      for (ProjectPurchaseReceiveDTOParam receivedParam : receiveParamList) {
         Preconditions.checkArgument(receivedParam.getReceivedQuantity().compareTo(BigDecimal.ZERO) > 0, "收货数量必须大于0");
         Preconditions.checkArgument(receivedParam.getActualReceivedMete().compareTo(BigDecimal.ZERO) > 0, "收货重量必须大于0");
         BigDecimal canReceivedQuantity = canReceivedMap.get(receivedParam.getDetailId());
         Preconditions.checkArgument(canReceivedMap.containsKey(receivedParam.getDetailId()), "操作失败！,可收货产品不存在,请刷新重试！");
         Preconditions.checkArgument(canReceivedQuantity.compareTo(receivedParam.getReceivedQuantity()) >= 0, "操作失败！,可收货产品数量不足！,请刷新重试！");
         if (canReceivedQuantity.compareTo(receivedParam.getReceivedQuantity()) != 0) {
            flag = false;
         }
      }

      if (flag && receiveParamList.size() == detailsDTOList.size()) {
         purchaseOrder.setReceiveState(OutReceiveState.FINISH_RECEIVED.getType());
         purchaseOrder.setPurchaseStatus(2);
      } else {
         purchaseOrder.setReceiveState(OutReceiveState.SOME_RECEIVED.getType());
      }

      this.purchaseOrderService.updateById(purchaseOrder);
      Map<Long, ProjectPurchaseProductDetailsDTO> detailsDTOMap = detailsDTOList.stream()
         .collect(Collectors.toMap(ProjectPurchaseProductDetailsDTO::getDetailId, Function.identity()));
      List<Long> detailIds = detailsDTOList.stream().map(ProjectPurchaseProductDetailsDTO::getDetailId).collect(Collectors.toList());
      List<PurchaseOrderDetail> orderDetailList = this.purchaseOrderDetailService.listByIds(detailIds);
      PurchaseOrder order = this.purchaseOrderService.getById(orderDetailList.get(0).getPurchaseId());
      Preconditions.checkArgument(order != null, "采购单发生变化,请刷新重试！");
      Map<Long, PurchaseOrderDetail> purchaseOrderDetailMap = orderDetailList.stream()
         .collect(Collectors.toMap(PurchaseOrderDetail::getId, Function.identity()));
      if (purchaseOrder.getPurchaseType().equals(1)) {
         this.materialToReceivied(project, purchaseOrder, receiveParamList, detailsDTOMap, purchaseOrderDetailMap);
      }

      if (purchaseOrder.getPurchaseType().equals(2)) {
         this.manufacturedToReceivied(project, purchaseOrder, receiveParamList, detailsDTOMap, purchaseOrderDetailMap);
      }

      return true;
   }

   private void manufacturedToReceivied(
      ContractProject project,
      PurchaseOrder purchaseOrder,
      List<ProjectPurchaseReceiveDTOParam> receiveParamList,
      Map<Long, ProjectPurchaseProductDetailsDTO> detailsDTOMap,
      Map<Long, PurchaseOrderDetail> purchaseOrderDetailMap
   ) {
      Integer productType = null;
      if (Integer.valueOf(32).equals(purchaseOrder.getBasicClass())) {
         productType = ProductTypeEnum.ARTIFACT.getType();
      }

      if (Integer.valueOf(64).equals(purchaseOrder.getBasicClass())) {
         productType = ProductTypeEnum.ENCLOSURE.getType();
      }

      Preconditions.checkArgument(productType != null, "产品类型有误！暂仅支持结构和围护制品");
      Integer finalProductType = productType;
      ProjectPurchaseOrderReceivedOperateRecord build = ProjectPurchaseOrderReceivedOperateRecord.builder()
         .projectId(project.getId())
         .productType(finalProductType)
         .receivedTime(LocalDateTime.now())
         .supplierId(purchaseOrder.getSupplierId())
         .orderId(purchaseOrder.getId())
         .serialNumber(purchaseOrder.getSerialNumber())
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .build();
      this.receivedOperateRecordService.save(build);
      receiveParamList.forEach(
         receiveParam -> {
            ProjectPurchaseProductDetailsDTO detailsDTO = detailsDTOMap.get(receiveParam.getDetailId());
            ProjectReceivingRecord record = BeanUtil.copy(detailsDTO, ProjectReceivingRecord.class);
            record.setPurchaseDetailsId(detailsDTO.getDetailId());
            record.setProjectId(Long.valueOf(purchaseOrder.getProjectIds()));
            record.setSupplierId(purchaseOrder.getSupplierId());
            record.setProductType(detailsDTO.getProductType());
            record.setQuantity(receiveParam.getReceivedQuantity());
            record.setProjectType(project.getProjectType());
            record.setAreaType(AreaTypeEnum.EPIBOLY.getType());
            record.setSourceType(SourceTypeEnum.OUT_SOURCE.getType());
            record.setSourceId(purchaseOrder.getId());
            record.setOperateRecordId(build.getId());
            record.setActualReceivedMete(receiveParam.getActualReceivedMete());
            TechProductDTO techProductDTO = this.productBiz.getProductInfoBy(detailsDTO.getProductId(), detailsDTO.getProductType());
            if (finalProductType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               record.setProjectId(techProductDTO.getProjectId());
               record.setProductId(techProductDTO.getId());
               record.setMonomerId(techProductDTO.getMonomerId());
               record.setAreaId(techProductDTO.getAreaId());
               record.setThickness(techProductDTO.getThickness());
               record.setWidth(techProductDTO.getWidth());
               record.setNetWeight(techProductDTO.getNetWeight());
               record.setMete(techProductDTO.getNetWeight().multiply(receiveParam.getReceivedQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(receiveParam.getReceivedQuantity()));
            }

            if (finalProductType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               record.setProjectId(techProductDTO.getProjectId());
               record.setProductId(techProductDTO.getId());
               record.setMonomerId(techProductDTO.getMonomerId());
               record.setAreaId(techProductDTO.getAreaId());
               record.setThickness(techProductDTO.getThickness());
               record.setWidth(techProductDTO.getUnfoldedWidth());
               record.setMete(techProductDTO.getLength().multiply(receiveParam.getReceivedQuantity()));
               record.setTotalArea(techProductDTO.getUnfoldedWidth().multiply(techProductDTO.getLength()).multiply(receiveParam.getReceivedQuantity()));
            }

            PurchaseOrderDetail purchaseDetail = purchaseOrderDetailMap.get(detailsDTO.getDetailId());
            purchaseDetail.setReceivedQuantity(purchaseDetail.getReceivedQuantity().add(receiveParam.getReceivedQuantity()));
            if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == purchaseDetail.getWageQuotaType()) {
               purchaseDetail.setReceivedMete(purchaseDetail.getReceivedMete().add(receiveParam.getReceivedQuantity()));
            } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == purchaseDetail.getWageQuotaType()) {
               purchaseDetail.setReceivedMete(
                  purchaseDetail.getReceivedMete()
                     .add(receiveParam.getReceivedQuantity().multiply(purchaseDetail.getTotalLength()).divide(detailsDTO.getQuantity(), 8, 4))
               );
            } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == purchaseDetail.getWageQuotaType()) {
               purchaseDetail.setReceivedMete(
                  purchaseDetail.getReceivedMete()
                     .add(receiveParam.getReceivedQuantity().multiply(purchaseDetail.getTotalArea()).divide(detailsDTO.getQuantity(), 8, 4))
               );
            } else {
               if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != purchaseDetail.getWageQuotaType()) {
                  throw new BusinessException("制成品计价方式类型不存在！");
               }

               purchaseDetail.setReceivedMete(
                  purchaseDetail.getReceivedMete()
                     .add(receiveParam.getReceivedQuantity().multiply(purchaseDetail.getTotalWeight()).divide(detailsDTO.getQuantity(), 8, 4))
               );
            }

            purchaseDetail.setActualReceivedMete(purchaseDetail.getActualReceivedMete().add(receiveParam.getActualReceivedMete()));
            this.purchaseOrderDetailService.updateById(purchaseDetail);
            this.receivingRecordService.save(record);
            this.receivingSummaryService.updateReceivingSummary(record);
         }
      );
   }

   private void materialToReceivied(
      ContractProject project,
      PurchaseOrder purchaseOrder,
      List<ProjectPurchaseReceiveDTOParam> receiveParamList,
      Map<Long, ProjectPurchaseProductDetailsDTO> detailsDTOMap,
      Map<Long, PurchaseOrderDetail> purchaseOrderDetailMap
   ) {
      ProjectPurchaseOrderReceivedOperateRecord build = ProjectPurchaseOrderReceivedOperateRecord.builder()
         .projectId(project.getId())
         .productType(ProductTypeUpEnum.RAW_MATERIAL.getType())
         .receivedTime(LocalDateTime.now())
         .supplierId(purchaseOrder.getSupplierId())
         .orderId(purchaseOrder.getId())
         .serialNumber(purchaseOrder.getSerialNumber())
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .build();
      this.receivedOperateRecordService.save(build);
      receiveParamList.forEach(receiveParam -> {
         ProjectPurchaseProductDetailsDTO detailsDTO = detailsDTOMap.get(receiveParam.getDetailId());
         ProjectReceivingRecord record = BeanUtil.copy(detailsDTO, ProjectReceivingRecord.class);
         record.setPurchaseDetailsId(detailsDTO.getDetailId());
         record.setProjectId(Long.valueOf(purchaseOrder.getProjectIds()));
         record.setSupplierId(purchaseOrder.getSupplierId());
         record.setProductType(ProductTypeUpEnum.RAW_MATERIAL.getType());
         record.setAreaType(AreaTypeEnum.EPIBOLY.getType());
         record.setSourceId(purchaseOrder.getId());
         record.setClassifyId(detailsDTO.getClassifyId());
         record.setSourceType(SourceTypeEnum.OUT_SOURCE.getType());
         record.setTotalArea(BigDecimal.ZERO);
         record.setProjectType(project.getProjectType());
         record.setOperateRecordId(build.getId());
         record.setActualReceivedMete(receiveParam.getActualReceivedMete());
         PurchaseOrderDetail purchaseDetail = purchaseOrderDetailMap.get(detailsDTO.getDetailId());
         Preconditions.checkArgument(purchaseDetail != null, "采购单详情信息不存在！");
         if (purchaseDetail.getQuantity() != null && purchaseDetail.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
            record.setQuantity(receiveParam.getReceivedQuantity());
            BigDecimal receivedMete = receiveParam.getReceivedQuantity().multiply(detailsDTO.getMete()).divide(detailsDTO.getQuantity(), 8, 4);
            record.setMete(receivedMete);
            purchaseDetail.setReceivedQuantity(purchaseDetail.getReceivedQuantity().add(receiveParam.getReceivedQuantity()));
            purchaseDetail.setReceivedMete(purchaseDetail.getReceivedMete().add(receivedMete));
         } else {
            purchaseDetail.setReceivedMete(purchaseDetail.getReceivedMete().add(receiveParam.getReceivedQuantity()));
            record.setMete(receiveParam.getReceivedQuantity());
            record.setQuantity(BigDecimal.ZERO);
         }

         purchaseDetail.setActualReceivedMete(purchaseDetail.getActualReceivedMete().add(receiveParam.getActualReceivedMete()));
         this.purchaseOrderDetailService.updateById(purchaseDetail);
         this.receivingRecordService.save(record);
         this.receivingSummaryService.updateRawMaterialReceivingSummary(record);
      });
   }

   @Override
   public PageVO<ProjectReceivedOperateRecordDTO> getOperateRecordPage(Long projectId, Long supplierId, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectPurchaseOrderReceivedOperateRecord> operateRecordList = this.receivedOperateRecordService
         .list(
            Wrappers.lambdaQuery(ProjectPurchaseOrderReceivedOperateRecord.class)
               .eq(ProjectPurchaseOrderReceivedOperateRecord::getProjectId, projectId)
               .eq(supplierId != null, ProjectPurchaseOrderReceivedOperateRecord::getSupplierId, supplierId)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(operateRecordList)) {
         return new PageVO<>();
      }

      List<Long> supplierIds = operateRecordList.stream().map(ProjectPurchaseOrderReceivedOperateRecord::getSupplierId).distinct().collect(Collectors.toList());
      Map<Long, String> supplierNameMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      List<Long> projectIds = operateRecordList.stream().map(ProjectPurchaseOrderReceivedOperateRecord::getProjectId).collect(Collectors.toList());
      Map<Long, String> projectNameMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, ContractProject::getName));
      List<ProjectReceivedOperateRecordDTO> recordDTOList = operateRecordList.stream().map(e -> {
         ProjectReceivedOperateRecordDTO recordDTO = BeanUtil.copy(e, ProjectReceivedOperateRecordDTO.class);
         recordDTO.setOrderSerialNumber(e.getSerialNumber());
         recordDTO.setSupplierName(supplierNameMap.getOrDefault(e.getSupplierId(), null));
         recordDTO.setProjectName(projectNameMap.getOrDefault(e.getProjectId(), null));
         return recordDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(page, recordDTOList);
   }

   @Override
   public List<ProjectPurchaseProductDetailsDTO> getOperateRecordDetails(Long operateId) {
      List<ProjectReceivingRecord> receivedRecordList = this.receivingRecordService
         .list(
            Wrappers.lambdaQuery(ProjectReceivingRecord.class)
               .eq(ProjectReceivingRecord::getOperateRecordId, operateId)
               .eq(ProjectReceivingRecord::getSourceType, SourceTypeEnum.OUT_SOURCE.getType())
               .in(ProjectReceivingRecord::getProjectType, ProjectTypeEnum.MES.getType(), ProjectTypeEnum.BRIDGE.getType())
         );
      return CollectionUtils.isEmpty(receivedRecordList) ? new ArrayList<>() : receivedRecordList.stream().map(e -> {
         ProjectPurchaseProductDetailsDTO detailsDTO = BeanUtil.copy(e, ProjectPurchaseProductDetailsDTO.class);
         if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(e.getProductType())) {
            if (e.getClassifyId() != null) {
               SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(e.getClassifyId());
               detailsDTO.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
               detailsDTO.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
               PurchaseOrderDetail orderDetail = this.purchaseOrderDetailService.getById(e.getPurchaseDetailsId());
               if (orderDetail != null) {
                  detailsDTO.setBasicClass(orderDetail.getBasicClass());
                  detailsDTO.setLength(orderDetail.getLength());
                  detailsDTO.setWidth(orderDetail.getWidth());
                  detailsDTO.setThickness(orderDetail.getThickness());
                  detailsDTO.setColor(orderDetail.getColor());
               }
            }
         } else {
            PurchaseOrderDetail orderDetail = this.purchaseOrderDetailService.getById(e.getPurchaseDetailsId());
            if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == orderDetail.getWageQuotaType()) {
               detailsDTO.setMete(e.getQuantity());
               detailsDTO.setActualReceivedMete(e.getQuantity());
            } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == orderDetail.getWageQuotaType()) {
               detailsDTO.setMete(e.getMete().divide(BigDecimal.valueOf(1000L)));
               detailsDTO.setActualReceivedMete(e.getActualReceivedMete().divide(BigDecimal.valueOf(1000L)));
            } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == orderDetail.getWageQuotaType()) {
               detailsDTO.setMete(e.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
               detailsDTO.setActualReceivedMete(e.getActualReceivedMete().divide(BigDecimal.valueOf(1000000L)));
            } else {
               if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != orderDetail.getWageQuotaType()) {
                  throw new BusinessException("制成品计价方式类型不存在！");
               }

               detailsDTO.setMete(e.getMete());
               detailsDTO.setActualReceivedMete(e.getActualReceivedMete().divide(BigDecimal.valueOf(1000L)));
            }
         }

         detailsDTO.setQuantity(e.getQuantity());
         detailsDTO.setMonomer(detailsDTO.getMonomerId() != null ? this.monomerService.getSimpleById(detailsDTO.getMonomerId()) : null);
         detailsDTO.setArea(detailsDTO.getAreaId() != null ? this.areaService.getSimpleById(detailsDTO.getAreaId()) : null);
         return detailsDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> operateRecordDetailsPrint(Long operateId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      ProjectPurchaseOrderReceivedOperateRecord operateRecord = this.receivedOperateRecordService.getById(operateId);
      Preconditions.checkArgument(operateRecord != null);
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(operateRecord.getProjectId());
      Supplier supplier = this.supplierService.getById(operateRecord.getSupplierId());
      SupplierDTO supplierDTO = BeanUtil.copy(supplier, SupplierDTO.class);
      header.put("productType", ProductTypeUpEnum.getNameByType(operateRecord.getProductType()));
      header.put("supplier", supplierDTO);
      header.put("project", projectInfo);
      header.put("operateRecord", operateRecord);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.getOperateRecordDetails(operateId).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> listCargoListCanReceiveProductPrint(Long cargoListId, Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(projectId);
      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      header.put("receiveUserName", StrUtil.isNotBlank(cargoList.getAuditReceiptName()) ? cargoList.getAuditReceiptName() : "");
      header.put("receiveDate", cargoList.getAuditReceiptTime() != null ? cargoList.getAuditReceiptTime() : "");
      header.put("licensePlate", StrUtil.isNotBlank(cargoList.getLicensePlate()) ? cargoList.getLicensePlate() : "");
      header.put("project", project);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.privateListReceivingDetailsV2(cargoListId).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   private void saveReceivingV2(
      Boolean boolProblemReceiving, Long problemId, Long cargoListId, Integer projectType, List<ProjectReceiveProductDTOParam> receiveProductDTOParam
   ) {
      if (!projectType.equals(ProjectTypeEnum.MES.getType()) && !projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持改项目类型!!!");
      }

      Map<Long, ProjectReceiveProductDTOParam> receiveProductParamMap = receiveProductDTOParam.stream()
         .collect(Collectors.toMap(ProjectReceiveProductDTOParam::getLinkId, Function.identity()));
      List<MesBuildingCargoListProductLink> cargoListProductLinks = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId)
               .orderByAsc(MesBuildingCargoListProductLink::getProductType)
               .orderByAsc(MesBuildingCargoListProductLink::getProductId)
         )
         .stream()
         .filter(cargo -> receiveProductParamMap.containsKey(cargo.getId()))
         .collect(Collectors.toList());
      cargoListProductLinks.forEach(
         link -> {
            TechProductDTO techProductDTO = this.productBiz.getProductInfoBy(link.getProductId(), link.getProductType());
            ProjectReceiveProductDTOParam receiveParam = receiveProductParamMap.get(link.getId());
            ProjectReceivingRecord record = BeanUtil.copy(techProductDTO, ProjectReceivingRecord.class);
            record.setLinkId(link.getId());
            record.setWeight(link.getWeight());
            record.setProductType(link.getProductType());
            record.setProductId(link.getProductId());
            record.setQuantity(receiveParam.getQuantity());
            record.setProjectType(projectType);
            record.setAreaType(AreaTypeEnum.PROCESS.getType());
            record.setProjectType(projectType);
            record.setSourceId(cargoListId);
            record.setSourceType(SourceTypeEnum.SELF_SOURCE.getType());
            record.setBoolProblemReceiving(boolProblemReceiving);
            record.setProblemDesc(receiveParam.getProblemDesc());
            record.setProblemId(problemId);
            if (link.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
               record.setMete(link.getWeight().multiply(receiveParam.getQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(receiveParam.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
               record.setMete(link.getWeight().multiply(receiveParam.getQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(receiveParam.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               record.setMete(link.getWeight().multiply(receiveParam.getQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(receiveParam.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               BigDecimal thickness = techProductDTO.getThickness() != null ? techProductDTO.getThickness() : BigDecimal.ZERO;
               BigDecimal weight = techProductDTO.getUnfoldedWidth() != null ? techProductDTO.getUnfoldedWidth() : BigDecimal.ZERO;
               BigDecimal length = techProductDTO.getLength() != null ? techProductDTO.getLength() : BigDecimal.ZERO;
               record.setSpecification(
                  thickness.stripTrailingZeros().toPlainString()
                     + "*"
                     + weight.stripTrailingZeros().toPlainString()
                     + "*"
                     + length.stripTrailingZeros().toPlainString()
               );
               record.setWidth(techProductDTO.getUnfoldedWidth());
               record.setMete(techProductDTO.getLength().multiply(receiveParam.getQuantity()));
               record.setTotalArea(techProductDTO.getUnfoldedWidth().multiply(techProductDTO.getLength()).multiply(receiveParam.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               record.setMete(link.getWeight().multiply(receiveParam.getQuantity()));
               record.setTotalArea(link.getSurfaceArea().multiply(receiveParam.getQuantity()));
            }

            link.setBoolProblemReceiving(boolProblemReceiving);
            this.cargoListProductLinkService.updateById(link);
            this.receivingRecordService.save(record);
            this.receivingSummaryService.updateReceivingSummary(record);
         }
      );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void saveReceiving(Long cargoListId, Integer projectType) {
      if (!projectType.equals(ProjectTypeEnum.MES.getType()) && !projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         throw new BusinessException("暂不支持改项目类型!!!");
      }

      List<MesBuildingCargoListProductLink> cargoListProductLinks = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId)
               .orderByAsc(MesBuildingCargoListProductLink::getProductType)
               .orderByAsc(MesBuildingCargoListProductLink::getProductId)
         );
      cargoListProductLinks.forEach(
         link -> {
            TechProductDTO techProductDTO = this.productBiz.getProductInfoBy(link.getProductId(), link.getProductType());
            ProjectReceivingRecord record = BeanUtil.copy(techProductDTO, ProjectReceivingRecord.class);
            record.setWeight(link.getWeight());
            record.setProductType(link.getProductType());
            record.setProductId(link.getProductId());
            record.setQuantity(link.getQuantity());
            record.setProjectType(projectType);
            record.setMeasureMode(
               !link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                  ? this.contractTechService.getMeasureMode(techProductDTO.getProjectId(), link.getProductType(), techProductDTO.getCategory())
                  : null
            );
            record.setSourceId(cargoListId);
            record.setAreaType(AreaTypeEnum.PROCESS.getType());
            record.setProjectType(projectType);
            record.setSourceType(SourceTypeEnum.SELF_SOURCE.getType());
            if (link.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
               record.setMete(link.getWeight().multiply(link.getQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(link.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
               record.setMete(link.getWeight().multiply(link.getQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(link.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               record.setMete(link.getWeight().multiply(link.getQuantity()));
               record.setTotalArea(techProductDTO.getSurfaceArea().multiply(link.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               record.setWidth(techProductDTO.getUnfoldedWidth());
               record.setMete(techProductDTO.getLength().multiply(link.getQuantity()));
               record.setTotalArea(techProductDTO.getUnfoldedWidth().multiply(techProductDTO.getLength()).multiply(link.getQuantity()));
            }

            if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               record.setSerialNumber(StringUtils.isNotBlank(techProductDTO.getSerialNumber()) ? techProductDTO.getSerialNumber() : "");
               TechStandardPart standardPart = this.standardPartService.getById(link.getProductId());
               MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
               Preconditions.checkArgument(
                  standardPart != null && cargoList != null && cargoList.getProjectId().equals(standardPart.getProjectId()),
                  "配套件与发货项目不一致"
               );
               Preconditions.checkArgument(
                  standardPart.getQuantity() != null && standardPart.getQuantity().compareTo(BigDecimal.ZERO) > 0
                     && standardPart.getMete() != null && link.getQuantity() != null && link.getQuantity().compareTo(BigDecimal.ZERO) > 0,
                  "配套件数量或核算量无效"
               );
               record.setMete(
                  standardPart.getMete().multiply(link.getQuantity()).divide(standardPart.getQuantity(), 8, RoundingMode.HALF_UP)
               );
            }

            this.receivingRecordService.save(record);
            this.receivingSummaryService.updateReceivingSummary(record);
         }
      );
   }

   @Override
   public PageVO<ProjectReceivingRecordDTO> listReceivingRecord(ReceivingStatementQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目不是承包项目!");
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingRecord> recordList = this.receivingRecordService.listReceivingRecord(param);
      List<ProjectReceivingRecordDTO> recordDTOList = this.listReceivingRecordDTO(recordList);
      return new PageVO<>(PageUtils.getPageInfo(recordDTOList, recordList));
   }

   @Override
   public PageVO<ProjectReceivingRecordDTO> listReceivingRecordV2(ReceivingStatementQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目不是承包项目!");
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingRecord> recordList = this.receivingRecordService.listReceivingRecordV2(param);
      List<ProjectReceivingRecordDTO> recordDTOList = this.listReceivingRecordDTOV2(param, recordList);
      return new PageVO<>(PageUtils.getPageInfo(recordDTOList, recordList));
   }

   private List<ProjectReceivingRecordDTO> listReceivingRecordDTOV2(ReceivingStatementQueryDTOParam param, List<ProjectReceivingRecord> recordList) {
      if (CollectionUtils.isEmpty(recordList)) {
         return new ArrayList<>();
      }

      Map<Long, String> supplierNameMap = new HashMap<>();
      if (SourceTypeEnum.OUT_SOURCE.getType().equals(param.getSourceType())) {
         List<Long> supplierIds = recordList.stream().map(ProjectReceivingRecord::getSupplierId).distinct().collect(Collectors.toList());
         supplierNameMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      }

      Map<Long, String> finalSupplierNameMap = supplierNameMap;
      return recordList.stream()
         .map(
            r -> {
               ProjectReceivingRecordDTO recordDTO = BeanUtil.copy(r, ProjectReceivingRecordDTO.class);
               if (r.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(r.getAreaId());
                  recordDTO.setArea(BeanUtil.copy(enclosurePlan, NameInfo.class));
               } else {
                  recordDTO.setMonomer(this.monomerService.getSimpleById(r.getMonomerId()));
                  recordDTO.setArea(r.getAreaId() != null && r.getAreaId() != 0L ? this.areaService.getSimpleById(r.getAreaId()) : null);
               }

               if (r.getSupplierId() != null) {
                  recordDTO.setSupplierName(finalSupplierNameMap.getOrDefault(r.getSupplierId(), null));
               }

               if (r.getProjectType().equals(ProjectTypeEnum.MES.getType()) || r.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  if (recordDTO.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) || (recordDTO.getProductType() & 17) > 0) {
                     recordDTO.setMeasureUnit("件");
                     recordDTO.setAccountingUnit("kg");
                  }

                  if (recordDTO.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     recordDTO.setMeasureUnit("张");
                     TechEnclosure enclosure = this.enclosureService.getById(r.getProductId());
                     recordDTO.setSpecification(
                        enclosure.getThickness() != null
                           ? enclosure.getThickness().setScale(2, RoundingMode.HALF_UP)
                              + "*"
                              + enclosure.getUnfoldedWidth().intValue()
                              + "*"
                              + enclosure.getLength().intValue()
                           : enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                     );
                     Integer measureMode = this.contractTechService.getMeasureMode(r.getProjectId(), r.getProductType(), r.getCategory());
                     if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                        recordDTO.setMete(r.getMete().divide(BigDecimal.valueOf(1000L)));
                        recordDTO.setAccountingUnit("m");
                     } else {
                        recordDTO.setMete(r.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
                        recordDTO.setAccountingUnit("m2");
                     }
                  }
               }

               if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(recordDTO.getProductType())) {
                  SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(r.getClassifyId());
                  if (subjectMeasureDTO != null) {
                     recordDTO.setMeasureUnit(subjectMeasureDTO.getMeasureUnit());
                     recordDTO.setAccountingUnit(subjectMeasureDTO.getAccountingUnit());
                     recordDTO.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
                     recordDTO.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
                  }

                  PurchaseOrderDetail orderDetail = this.purchaseOrderDetailService.getById(r.getPurchaseDetailsId());
                  if (orderDetail != null) {
                     recordDTO.setBasicClass(orderDetail.getBasicClass());
                     recordDTO.setLength(orderDetail.getLength());
                     recordDTO.setWidth(orderDetail.getWidth());
                     recordDTO.setThickness(orderDetail.getThickness());
                     recordDTO.setColor(orderDetail.getColor());
                     recordDTO.setLength(orderDetail.getLength());
                     recordDTO.setClassifyId(orderDetail.getClassifyId());
                  }
               }

               return recordDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private List<ProjectReceivingRecordDTO> listReceivingRecordDTO(List<ProjectReceivingRecord> recordList) {
      return recordList.stream()
         .map(
            r -> {
               ProjectReceivingRecordDTO recordDTO = BeanUtil.copy(r, ProjectReceivingRecordDTO.class);
               if (r.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(r.getAreaId());
                  recordDTO.setArea(BeanUtil.copy(enclosurePlan, NameInfo.class));
               } else {
                  recordDTO.setMonomer(this.monomerService.getSimpleById(r.getMonomerId()));
                  recordDTO.setArea(r.getAreaId() != null && r.getAreaId() != 0L ? this.areaService.getSimpleById(r.getAreaId()) : null);
               }

               if (r.getProjectType().equals(ProjectTypeEnum.MES.getType()) || r.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  if (recordDTO.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) || (recordDTO.getProductType() & 17) > 0) {
                     recordDTO.setMeasureUnit("件");
                     recordDTO.setAccountingUnit("kg");
                  }

                  if (recordDTO.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     recordDTO.setMeasureUnit("张");
                     TechEnclosure enclosure = this.enclosureService.getById(r.getProductId());
                     recordDTO.setSpecification(
                        enclosure.getThickness() != null
                           ? enclosure.getThickness().setScale(2, RoundingMode.HALF_UP)
                              + "*"
                              + enclosure.getUnfoldedWidth().intValue()
                              + "*"
                              + enclosure.getLength().intValue()
                           : enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                     );
                     Integer measureMode = this.contractTechService.getMeasureMode(r.getProjectId(), r.getProductType(), r.getCategory());
                     if (measureMode.equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
                        recordDTO.setMete(r.getMete().divide(BigDecimal.valueOf(1000L)));
                        recordDTO.setAccountingUnit("m");
                     } else {
                        recordDTO.setMete(r.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
                        recordDTO.setAccountingUnit("m2");
                     }
                  }
               }

               return recordDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListReceivingRecord(ReceivingStatementQueryDTOParam param) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型是承包订单");
      List<ProjectReceivingRecord> recordList = this.receivingRecordService.listReceivingRecord(param);
      List<ProjectReceivingRecordDTO> recordDTOList = this.listReceivingRecordDTO(recordList);
      List<Map<String, Object>> mapList = recordDTOList.stream().map(r -> {
         Map<String, Object> map = BeanUtil.beanToMap(r);
         map.put("areaType", r.getAreaType() == 0 ? "自制" : "外协");
         return map;
      }).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListReceivingRecordV2(ReceivingStatementQueryDTOParam param) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型是承包订单");
      List<ProjectReceivingRecord> recordList = this.receivingRecordService.listReceivingRecordV2(param);
      List<ProjectReceivingRecordDTO> recordDTOList = this.listReceivingRecordDTOV2(param, recordList);
      List<Map<String, Object>> mapList = recordDTOList.stream().map(r -> {
         Map<String, Object> map = BeanUtil.beanToMap(r);
         map.put("areaType", r.getAreaType() == 0 ? "自制" : "外协");
         return map;
      }).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      header.put("productType", ProductTypeUpEnum.getNameByType(param.getProductType()));
      header.put("sourceType", param.getSourceType() == 1 ? "自制" : "外协");
      header.put("totalQuantity", 0);
      if (CollUtil.isNotEmpty(recordDTOList)) {
         Integer totalQuantity = recordDTOList.stream().map(ProjectReceivingRecordDTO::getQuantity).filter(Objects::nonNull).reduce(0, Integer::sum);
         header.put("totalQuantity", totalQuantity);
      }

      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<ProjectReceivingBoardDTO> listReceivingBoard(ReceivingBoardQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "未选择项目!");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      ReceivingBoardQueryDOParam queryDOParam = BeanUtil.copy(param, ReceivingBoardQueryDOParam.class);
      queryDOParam.setProjectType(project.getProjectType());
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingBoardDTO> receivingBoardDTOList = this.receivingSummaryService.listReceivingBoard(queryDOParam);
      return new PageVO<>(receivingBoardDTOList);
   }

   @Override
   public PageVO<ProjectReceivingInstallDTO> listReceivingInstall(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型不是承包订单");
      if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         Preconditions.checkArgument(
            param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
               || param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())
               || param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()),
            "建钢项目-产品类型有误"
         );
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.listReceivingInstall(param);
      this.fillList(installDTOList);
      return new PageVO<>(installDTOList);
   }

   private void fillList(List<ProjectReceivingInstallDTO> installDTOList) {
      installDTOList.forEach(
         a -> {
            if (!a.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !a.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
               throw new BusinessException("暂不支持其他项目类型!!!");
            }

            a.setStockQuantity(a.getReceivingQuantity().subtract(a.getInstallQuantity()));
            TechProductDTO productDTO = this.productBiz.getProductInfoBy(a.getProductId(), a.getProductType());
            a.setQuantity(productDTO.getQuantity());
            if (a.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               a.setMeasureUnit("件");
               a.setAccountingUnit("kg");
               a.setMete(productDTO.getTotalNetWeight());
            }

            if (a.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               a.setMeasureUnit("张");
               a.setAccountingUnit("m");
               a.setSpecification(
                  productDTO.getThickness() != null
                     ? productDTO.getThickness().setScale(2, RoundingMode.HALF_UP)
                        + "*"
                        + productDTO.getUnfoldedWidth().intValue()
                        + "*"
                        + productDTO.getLength().intValue()
                     : productDTO.getUnfoldedWidth().intValue() + "*" + productDTO.getLength().intValue()
               );
               a.setMete(productDTO.getTotalLength().divide(BigDecimal.valueOf(1000L)));
            }

            if (a.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               a.setMeasureUnit(productDTO.getMeasureUnit());
               a.setAccountingUnit(productDTO.getMeasureUnit());
               a.setMete(BigDecimal.valueOf(productDTO.getQuantity().intValue()));
            }
         }
      );
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListReceivingInstall(ProjectBaseQueryDTOParam param) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         Preconditions.checkArgument(
            param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
               || param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())
               || param.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()),
            "建钢项目-产品类型有误"
         );
      }

      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      header.put("productType", ProductTypeEnum.getNameByType(param.getProductType()));
      List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.listReceivingInstall(param);
      this.fillList(installDTOList);
      header.put("totalQuantity", 0);
      header.put("totalWeight", 0);
      if (CollUtil.isNotEmpty(installDTOList)) {
         Integer totalQuantity = installDTOList.stream().map(ProjectReceivingInstallDTO::getQuantity).filter(Objects::nonNull).reduce(0, Integer::sum);
         header.put("totalQuantity", totalQuantity);
         BigDecimal totalWeight = installDTOList.stream()
            .map(ProjectReceivingInstallDTO::getMete)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalWeight", totalWeight);
      }

      List<Map<String, Object>> mapList = installDTOList.stream().map(dto -> {
         Map<String, Object> beanToMap = BeanUtil.beanToMap(dto);
         if (dto.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            beanToMap.put("productType", ProductTypeEnum.getNameByType(dto.getProductType()));
         }

         return beanToMap;
      }).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ProjectReceivingInstallSumDTO getReceivingInstallSum(ProjectBaseQueryDTOParam param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "该项目类型为加工承揽订单");
      ProjectReceivingMeteDTO receivingMete = this.receivingSummaryService
         .getReceivingMete(param.getProjectId(), param.getMonomerId(), param.getAreaId(), param.getProductType(), null);
      ProjectInstallMeteSummaryDTO installMete = this.projectInstallBizUtil
         .getActualInstallMete(param.getProjectId(), param.getMonomerId(), param.getAreaId(), param.getProductType(), null);
      ProjectReceivingInstallSumDTO sumDTO = ProjectReceivingInstallSumDTO.builder()
         .receivingQuantity(receivingMete.getQuantity())
         .receivingMete(receivingMete.getMete())
         .installQuantity(installMete.getActualQuantity())
         .installMete(installMete.getActualMete())
         .build();
      if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         ProductMeteDTO productMeteDTO = this.productBiz.getDeepenMete(param.getProjectId(), param.getMonomerId(), param.getAreaId(), param.getProductType());
         sumDTO.setQuantity(BigDecimal.valueOf(productMeteDTO.getQuantity().intValue()));
         sumDTO.setMete(productMeteDTO.getMete());
         if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            sumDTO.setMeasureUnit("张");
            sumDTO.setAccountingUnit("m");
         } else {
            sumDTO.setMeasureUnit("件");
            sumDTO.setAccountingUnit("kg");
         }
      }

      return sumDTO;
   }

   @Override
   public PageVO<ProjectReceivingInstallDTO> listCanInstall(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.listReceivingInstall(param);
      if (CollectionUtils.isNotEmpty(installDTOList)) {
         List<String> serialNumberList = installDTOList.stream().map(ProjectReceivingInstallDTO::getSerialNumber).collect(Collectors.toList());
         Map<Long, Map<String, List<TechDrawing>>> drawMap = this.drawingService
            .list(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getProjectId, param.getProjectId()))
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, param.getProductType()))
                  .in(TechDrawing::getSerialNumber, serialNumberList)
            )
            .stream()
            .collect(Collectors.groupingBy(TechDrawing::getMonomerId, Collectors.groupingBy(TechDrawing::getSerialNumber)));
         installDTOList.forEach(
            a -> {
               if (a.getProjectType().equals(ProjectTypeEnum.MES.getType()) || a.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  TechProductDTO productDTO = this.productBiz.getProductInfoBy(a.getProductId(), a.getProductType());
                  a.setQuantity(productDTO.getQuantity());
                  if (a.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     a.setMeasureUnit("件");
                     a.setAccountingUnit("kg");
                     a.setMete(productDTO.getTotalNetWeight());
                  }

                  if (a.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     Integer measureMode = this.contractTechService.getMeasureMode(a.getProjectId(), a.getProductType(), a.getCategory());
                     a.setMeasureUnit("张");
                     if (measureMode.equals(EnclosureMeasureModeEnum.AREA_MODE.getType())) {
                        a.setAccountingUnit("m2");
                        a.setMete(productDTO.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
                     } else {
                        a.setAccountingUnit("m");
                        a.setMete(productDTO.getTotalLength().divide(BigDecimal.valueOf(1000L)));
                     }

                     EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(a.getAreaId());
                     a.setArea(BeanUtil.copy(enclosurePlan, NameInfo.class));
                     a.setSpecification(
                        productDTO.getThickness() != null
                           ? productDTO.getThickness().intValue() + "*" + productDTO.getUnfoldedWidth().intValue() + "*" + productDTO.getLength().intValue()
                           : productDTO.getUnfoldedWidth().intValue() + "*" + productDTO.getLength().intValue()
                     );
                  }
               }

               if (drawMap.containsKey(a.getMonomerId()) && drawMap.get(a.getMonomerId()).containsKey(a.getSerialNumber())) {
                  a.setNumbers(drawMap.get(a.getMonomerId()).get(a.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                  a.setDrawingAndSerialNumber(
                     drawMap.get(a.getMonomerId())
                        .get(a.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }
            }
         );
      }

      return new PageVO<>(installDTOList);
   }

   @Override
   public PageVO<ProjectReceivingInstallDTO> listCanInstallV2(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      Integer installDivideMethod = project.getInstallDivideMethod();
      if (installDivideMethod == null) {
         return new PageVO<>();
      } else if (DivideMethodEnum.AREA.getType().equals(installDivideMethod)) {
         return this.areaDivideModeCanInstall(param, pageNumber, pageSize);
      } else {
         return DivideMethodEnum.LIST.getType().equals(installDivideMethod) ? this.listDivideModeCanInstall(param, pageNumber, pageSize) : new PageVO<>();
      }
   }

   private PageVO<ProjectReceivingInstallDTO> areaDivideModeCanInstall(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目ID不能为空");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.listReceivingInstallV2(param);
      if (CollectionUtils.isNotEmpty(installDTOList)) {
         List<String> serialNumberList = installDTOList.stream().map(ProjectReceivingInstallDTO::getSerialNumber).collect(Collectors.toList());
         Map<Long, Map<String, List<TechDrawing>>> drawMap = this.drawingService
            .list(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getProjectId, param.getProjectId()))
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, param.getProductType()))
                  .in(TechDrawing::getSerialNumber, serialNumberList)
            )
            .stream()
            .collect(Collectors.groupingBy(TechDrawing::getMonomerId, Collectors.groupingBy(TechDrawing::getSerialNumber)));
         installDTOList.forEach(
            a -> {
               if (a.getProjectType().equals(ProjectTypeEnum.MES.getType()) || a.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  TechProductDTO productDTO = this.productBiz.getProductInfoBy(a.getProductId(), a.getProductType());
                  a.setQuantity(productDTO.getQuantity());
                  if (a.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     a.setMeasureUnit("件");
                     a.setAccountingUnit("kg");
                     a.setMete(a.getCanInstallQuantity().multiply(a.getNetWeight()));
                  }

                  if (a.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     a.setMeasureUnit("张");
                     a.setSpecification(
                        productDTO.getThickness() != null
                           ? productDTO.getThickness().intValue() + "*" + productDTO.getUnfoldedWidth().intValue() + "*" + productDTO.getLength().intValue()
                           : productDTO.getUnfoldedWidth().intValue() + "*" + productDTO.getLength().intValue()
                     );
                  }
               }

               if (drawMap.containsKey(a.getMonomerId()) && drawMap.get(a.getMonomerId()).containsKey(a.getSerialNumber())) {
                  a.setNumbers(drawMap.get(a.getMonomerId()).get(a.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                  a.setDrawingAndSerialNumber(
                     drawMap.get(a.getMonomerId())
                        .get(a.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }
            }
         );
      }

      return new PageVO<>(installDTOList);
   }

   private PageVO<ProjectReceivingInstallDTO> listDivideModeCanInstall(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.getListMethodReceivingInstall(param);
      if (CollectionUtils.isNotEmpty(installDTOList)) {
         List<String> serialNumberList = installDTOList.stream().map(ProjectReceivingInstallDTO::getSerialNumber).collect(Collectors.toList());
         Map<Long, Map<String, List<TechDrawing>>> drawMap = this.drawingService
            .list(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getProjectId, param.getProjectId()))
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, param.getProductType()))
                  .in(TechDrawing::getSerialNumber, serialNumberList)
            )
            .stream()
            .collect(Collectors.groupingBy(TechDrawing::getMonomerId, Collectors.groupingBy(TechDrawing::getSerialNumber)));
         installDTOList.forEach(
            a -> {
               if (drawMap.containsKey(a.getMonomerId()) && drawMap.get(a.getMonomerId()).containsKey(a.getSerialNumber())) {
                  a.setNumbers(drawMap.get(a.getMonomerId()).get(a.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                  a.setDrawingAndSerialNumber(
                     drawMap.get(a.getMonomerId())
                        .get(a.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }
            }
         );
      }

      return new PageVO<>(installDTOList);
   }

   @Override
   public PageVO<ProjectSubAppReceivingDTO> listSubAppAbleInstall(
      Integer productType, Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      List<ProjectSupplierAreaLink> areaLinkList = this.supplierAreaLinkService.listBySupplierId(supplierId, projectId, monomerId);
      List<Long> areaIds = areaLinkList.stream().map(ProjectSupplierAreaLink::getAreaId).collect(Collectors.toList());
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingSummary> summaryList = this.receivingSummaryService
         .list(
            Wrappers.lambdaQuery(ProjectReceivingSummary.class)
               .eq(ProjectReceivingSummary::getProjectId, projectId)
               .eq(ProjectReceivingSummary::getProductType, productType)
               .in(ProjectReceivingSummary::getAreaId, areaIds)
               .last(" and quantity > install_quantity")
         );
      List<ProjectSubAppReceivingDTO> appReceivingDTOList = summaryList.stream().map(s -> {
         ProjectSubAppReceivingDTO appReceivingDTO = BeanUtil.copy(s, ProjectSubAppReceivingDTO.class);
         appReceivingDTO.setReceivingQuantity(s.getQuantity());
         appReceivingDTO.setUnAuditQuantity(this.installReportService.getUnCheckReportedQuantity(s.getProjectType(), s.getProductType(), s.getProductId()));
         appReceivingDTO.setMonomer(this.monomerService.getSimpleById(s.getMonomerId()));
         appReceivingDTO.setArea(this.areaService.getSimpleById(s.getAreaId()));
         if (s.getProjectType().equals(ProjectTypeEnum.MES.getType()) || s.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            ProductDeepenMeteDTO deepenMete = this.productBiz.getDeepenMete(s.getProductType(), s.getProductId());
            appReceivingDTO.setQuantity(deepenMete.getQuantity());
            appReceivingDTO.setMete(deepenMete.getMete());
         }

         return appReceivingDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(appReceivingDTOList, summaryList));
   }

   @Override
   public PageVO<ProjectSubAppReceivingDTO> listSubAppAbleInstallV2(
      Integer productType, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.rosterService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getProjectId, projectId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null) {
         return new PageVO<>();
      } else {
         Long supplierId = roster.getSupplierId();
         ContractProject project = this.projectService.checkProjectStatus(projectId);
         Integer installDivideMethod = project.getInstallDivideMethod();
         if (DivideMethodEnum.AREA.getType().equals(installDivideMethod)) {
            List<ProjectSupplierAreaLink> areaLinkList = this.supplierAreaLinkService
               .list(
                  Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                     .eq(ProjectSupplierAreaLink::getProjectId, project.getId())
                     .eq(ProjectSupplierAreaLink::getSupplierId, roster.getSupplierId())
                     .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                     .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
               );
            List<Long> areaIds = areaLinkList.stream().map(ProjectSupplierAreaLink::getAreaId).distinct().collect(Collectors.toList());
            return CollectionUtils.isEmpty(areaIds)
               ? new PageVO<>()
               : this.getCanInstallProductByArea(productType, projectId, supplierId, monomerId, areaId, areaIds, serialNumber, pageNumber, pageSize);
         } else {
            return DivideMethodEnum.LIST.getType().equals(installDivideMethod)
               ? this.getCanInstallProductByList(productType, projectId, supplierId, monomerId, areaId, serialNumber, pageNumber, pageSize)
               : new PageVO<>();
         }
      }
   }

   @Override
   public List<ProjectReceivedInstallStoreSummaryDTO> getReceivedInstallStore(LocalDate year, Long projectId, Integer productType) {
      List<ProjectReceivedInstallStoreMeteDTO> receivedMeteList = this.receivingRecordService.getReceivedMete(projectId, productType);
      List<ProjectReceivedInstallStoreMeteDTO> rejectMeteList = this.receivingRecordService.getRejectMete(projectId, productType);
      List<ProjectReceivedInstallStoreMeteDTO> installMeteList = this.receivingRecordService.getInstallMete(projectId, productType);
      String start = receivedMeteList.stream().map(ProjectReceivedInstallStoreMeteDTO::getDate).min(String::compareTo).orElse(null);
      if (start == null) {
         return new ArrayList<>();
      }

      Map<String, BigDecimal> receivedMeteMap = receivedMeteList.stream()
         .collect(Collectors.toMap(ProjectReceivedInstallStoreMeteDTO::getDate, ProjectReceivedInstallStoreMeteDTO::getMete));
      Map<String, BigDecimal> installMeteMap = new HashMap<>();
      Map<String, BigDecimal> rejectMeteMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(installMeteList)) {
         installMeteMap = installMeteList.stream()
            .collect(Collectors.toMap(ProjectReceivedInstallStoreMeteDTO::getDate, ProjectReceivedInstallStoreMeteDTO::getMete));
      }

      if (CollectionUtils.isNotEmpty(rejectMeteList)) {
         rejectMeteMap = rejectMeteList.stream()
            .collect(Collectors.toMap(ProjectReceivedInstallStoreMeteDTO::getDate, ProjectReceivedInstallStoreMeteDTO::getMete));
      }

      Date parse = DateUtil.parse(start, "yyyy-MM");
      LocalDate localDate = LocalDateTimeUtil.of(parse).toLocalDate();
      List<String> yearMonthList = getTimePeriodFromMouthTime(localDate, LocalDate.now());
      ArrayList<ProjectReceivedInstallStoreSummaryDTO> summaryDTOList = new ArrayList<>();
      BigDecimal initMete = BigDecimal.ZERO;

      for (String yearMonth : yearMonthList) {
         ProjectReceivedInstallStoreSummaryDTO summaryDTO = new ProjectReceivedInstallStoreSummaryDTO();
         BigDecimal rejectMete = rejectMeteMap.getOrDefault(yearMonth, BigDecimal.ZERO).stripTrailingZeros();
         BigDecimal receivedMete = receivedMeteMap.getOrDefault(yearMonth, BigDecimal.ZERO).stripTrailingZeros().subtract(rejectMete);
         BigDecimal installMete = installMeteMap.getOrDefault(yearMonth, BigDecimal.ZERO).stripTrailingZeros();
         BigDecimal endMete = initMete.add(receivedMete).subtract(installMete).stripTrailingZeros();
         summaryDTO.setDate(yearMonth);
         summaryDTO.setInitMete(initMete);
         summaryDTO.setReceivedMete(receivedMete);
         summaryDTO.setInstallMete(installMete);
         summaryDTO.setEndMete(endMete);
         summaryDTOList.add(summaryDTO);
         initMete = endMete;
      }

      return summaryDTOList.stream()
         .filter(e -> StrUtil.subBefore(e.getDate(), "-", false).equals(String.valueOf(year.getYear())))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectProductDTO> getReceivedInstallStoreDetails(
      String yearMonth, Long projectId, Integer productType, Integer storeType, Integer pageNumber, Integer pageSize
   ) {
      List<ProjectProductDTO> dtoList = new ArrayList<>();
      Page page = null;
      if (StoreTypeEnum.BEGINNING.getType().equals(storeType) || StoreTypeEnum.STOCK.getType().equals(storeType)) {
         page = PageHelper.startPage(pageNumber, pageSize);
         dtoList = this.receivingRecordService.getStoreDetails(yearMonth, projectId, productType, storeType);
      }

      if (StoreTypeEnum.OUTBOUND.getType().equals(storeType)) {
         page = PageHelper.startPage(pageNumber, pageSize);
         dtoList = this.receivingRecordService.getReceivedInstallDetails(yearMonth, projectId, productType, storeType);
      }

      if (StoreTypeEnum.INBOUND.getType().equals(storeType)) {
         dtoList = this.receivingRecordService.getReceivedInstallDetails(yearMonth, projectId, productType, storeType);
         if (CollectionUtils.isEmpty(dtoList)) {
            dtoList = this.receivingRecordService.getReceivedReject(yearMonth, projectId, productType, storeType);
         } else {
            Map<Long, List<ProjectProductDTO>> rejectMap = this.receivingRecordService
               .getReceivedReject(yearMonth, projectId, productType, storeType)
               .stream()
               .collect(Collectors.groupingBy(ProjectProductDTO::getProductId));
            List<ProjectProductDTO> matchedProductList = new ArrayList<>();

            for (ProjectProductDTO productDTO : dtoList) {
               Long productId = productDTO.getProductId();
               if (rejectMap.containsKey(productId)) {
                  matchedProductList.addAll(rejectMap.get(productDTO.getProductId()));
                  rejectMap.remove(productId);
               }
            }

            dtoList.addAll(matchedProductList);
            dtoList.sort(Comparator.comparingLong(ProjectProductDTO::getProductId));
            dtoList.addAll(rejectMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
         }
      }

      Map<Long, PlanMonomer> monomerMap = new HashMap<>();
      Map<Long, PlanArea> areaMap = new HashMap<>();
      List<Long> monomerIds = dtoList.stream().map(ProjectProductDTO::getMonomerId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<Long> areaIds = dtoList.stream().map(ProjectProductDTO::getAreaId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(monomerIds)) {
         monomerMap = this.monomerService.listByIds(monomerIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      }

      if (CollectionUtils.isNotEmpty(areaIds)) {
         areaMap = this.areaService.listByIds(areaIds).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      }

      for (ProjectProductDTO productDTO : dtoList) {
         if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            productDTO.setAccountingUnit("kg").setMeasureUnit("件");
         }

         if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
            productDTO.setMeasureUnit("张").setAccountingUnit("m");
         }

         PlanMonomer monomer = monomerMap.get(productDTO.getMonomerId());
         if (monomer != null) {
            productDTO.setMonomer(BeanUtil.copy(monomer, NameInfo.class));
         }

         PlanArea area = areaMap.get(productDTO.getAreaId());
         if (area != null) {
            productDTO.setArea(BeanUtil.copy(area, NameInfo.class));
         }
      }

      if (CollectionUtils.isEmpty(dtoList)) {
         return new PageVO<>();
      } else {
         return page != null ? new PageVO<>(page, dtoList) : PageUtil.listPage(pageNumber, pageSize, dtoList);
      }
   }

   @Override
   public PageVO<ProjectProductDTO> getReceivedPage(
      Long projectId,
      Integer sourceType,
      Integer productType,
      Long supplierId,
      String name,
      String serialNumber,
      LocalDate startTime,
      LocalDate endTime,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectProductDTO> productDTOList = this.getProjectProductDTOList(
         projectId, sourceType, productType, supplierId, name, serialNumber, startTime, endTime
      );
      return new PageVO<>(page, productDTOList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getReceivedPrint(
      Long projectId, Integer sourceType, Integer productType, Long supplierId, String name, String serialNumber, LocalDate startTime, LocalDate endTime
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      header.put("productType", ProductTypeUpEnum.getNameByType(productType));
      header.put("sourceType", sourceType == 1 ? "自制" : "外协");
      printVO.setHeader(header);
      printVO.setTable(
         this.getProjectProductDTOList(projectId, sourceType, productType, supplierId, name, serialNumber, startTime, endTime)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   private List<ProjectProductDTO> getProjectProductDTOList(
      Long projectId, Integer sourceType, Integer productType, Long supplierId, String name, String serialNumber, LocalDate startTime, LocalDate endTime
   ) {
      LambdaQueryWrapper<ProjectReceivingRecord> query = Wrappers.lambdaQuery(ProjectReceivingRecord.class);
      query.eq(ProjectReceivingRecord::getProjectId, projectId);
      query.eq(sourceType != null, ProjectReceivingRecord::getSourceType, sourceType);
      query.eq(supplierId != null, ProjectReceivingRecord::getSupplierId, supplierId);
      query.like(StringUtils.isNotBlank(name), ProjectReceivingRecord::getName, name);
      query.like(StringUtils.isNotBlank(serialNumber), ProjectReceivingRecord::getSerialNumber, serialNumber);
      query.apply("date_format(create_time, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", startTime);
      query.apply("date_format(create_time, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", endTime);
      query.apply(productType != null, "product_type & {0} > 0", productType);
      query.orderByDesc(BaseEntity::getCreateTime);
      List<ProjectReceivingRecord> recordList = this.receivingRecordService.list(query);
      if (CollectionUtils.isEmpty(recordList)) {
         return new ArrayList<>();
      }

      List<Long> cargoListIds = recordList.stream()
         .filter(e -> SourceTypeEnum.SELF_SOURCE.getType().equals(e.getSourceType()))
         .map(ProjectReceivingRecord::getSourceId)
         .collect(Collectors.toList());
      List<Long> operateRecordIds = recordList.stream()
         .filter(e -> SourceTypeEnum.OUT_SOURCE.getType().equals(e.getSourceType()))
         .map(ProjectReceivingRecord::getOperateRecordId)
         .collect(Collectors.toList());
      Map<Long, String> nameMap1 = new HashMap<>();
      Map<Long, String> nameMap2 = new HashMap<>();
      if (CollectionUtils.isNotEmpty(cargoListIds)) {
         nameMap1 = this.cargoListService
            .listByIds(cargoListIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingCargoList::getId, MesBuildingCargoList::getAuditReceiptName));
      }

      if (CollectionUtils.isNotEmpty(operateRecordIds)) {
         nameMap2 = this.receivedOperateRecordService
            .listByIds(operateRecordIds)
            .stream()
            .collect(Collectors.toMap(ProjectPurchaseOrderReceivedOperateRecord::getId, ProjectPurchaseOrderReceivedOperateRecord::getUserName));
      }

      Map<Long, PlanMonomer> monomerMap = new HashMap<>();
      Map<Long, PlanArea> areaMap = new HashMap<>();
      List<Long> monomerIds = recordList.stream().map(ProjectReceivingRecord::getMonomerId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<Long> areaIds = recordList.stream().map(ProjectReceivingRecord::getAreaId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(monomerIds)) {
         monomerMap = this.monomerService.listByIds(monomerIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      }

      if (CollectionUtils.isNotEmpty(areaIds)) {
         areaMap = this.areaService.listByIds(areaIds).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      }

      Map<Long, String> finalNameMap = nameMap1;
      Map<Long, String> finalNameMap1 = nameMap2;
      Map<Long, PlanMonomer> finalMonomerMap = monomerMap;
      Map<Long, PlanArea> finalAreaMap = areaMap;
      return recordList.stream().map(e -> {
         ProjectProductDTO productDTO = BeanUtil.copy(e, ProjectProductDTO.class);
         productDTO.setReceivedDate(e.getCreateTime());
         PlanMonomer monomer = finalMonomerMap.get(e.getMonomerId());
         if (monomer != null) {
            productDTO.setMonomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build());
         }

         PlanArea area = finalAreaMap.get(e.getAreaId());
         if (area != null) {
            productDTO.setArea(NameInfo.builder().id(area.getId()).name(area.getName()).build());
         }

         if (SourceTypeEnum.SELF_SOURCE.getType().equals(e.getSourceType())) {
            productDTO.setUserName(finalNameMap.getOrDefault(e.getSourceId(), null));
         }

         if (SourceTypeEnum.OUT_SOURCE.getType().equals(e.getSourceType())) {
            productDTO.setUserName(finalNameMap1.getOrDefault(e.getOperateRecordId(), null));
         }

         if (ProductTypeUpEnum.ENCLOSURE.getType().equals(e.getProductType())) {
            productDTO.setMeasureUnit("张");
            productDTO.setAccountingUnit("m");
            productDTO.setMete(productDTO.getMete().divide(BigDecimal.valueOf(1000L)));
         } else if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(e.getProductType())) {
            productDTO.setAccountingUnit(e.getAccountingUnit());
            productDTO.setMeasureUnit(e.getMeasureUnit());
         } else {
            productDTO.setAccountingUnit("kg");
            productDTO.setMeasureUnit("件");
         }

         if (ProductTypeUpEnum.RAW_MATERIAL.getType().equals(productDTO.getProductType())) {
            SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(e.getClassifyId());
            if (subjectMeasureDTO != null) {
               productDTO.setMeasureUnit(subjectMeasureDTO.getMeasureUnit());
               productDTO.setAccountingUnit(subjectMeasureDTO.getAccountingUnit());
               productDTO.setMeasurePrecision(subjectMeasureDTO.getMeasurePrecision());
               productDTO.setAccountingPrecision(subjectMeasureDTO.getAccountingPrecision());
            }

            PurchaseOrderDetail orderDetail = this.purchaseOrderDetailService.getById(e.getPurchaseDetailsId());
            productDTO.setBasicClass(orderDetail.getBasicClass());
            productDTO.setLength(orderDetail.getLength());
            productDTO.setWidth(orderDetail.getWidth());
            productDTO.setThickness(orderDetail.getThickness());
            productDTO.setColor(orderDetail.getColor());
            productDTO.setLength(orderDetail.getLength());
            productDTO.setClassifyId(orderDetail.getClassifyId());
         } else if (SourceTypeEnum.OUT_SOURCE.getType().equals(e.getSourceType())) {
            PurchaseOrderDetail orderDetail = this.purchaseOrderDetailService.getById(e.getPurchaseDetailsId());
            if (WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType() == orderDetail.getWageQuotaType()) {
               productDTO.setMete(e.getQuantity());
               productDTO.setActualReceivedMete(e.getQuantity());
               productDTO.setAccountingUnit(ProductTypeUpEnum.ENCLOSURE.getType().equals(e.getProductType()) ? "张" : "件");
            } else if (WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType() == orderDetail.getWageQuotaType()) {
               productDTO.setMete(e.getMete().divide(BigDecimal.valueOf(1000L)));
               productDTO.setActualReceivedMete(e.getActualReceivedMete().divide(BigDecimal.valueOf(1000L)));
               productDTO.setAccountingUnit("m");
            } else if (WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType() == orderDetail.getWageQuotaType()) {
               productDTO.setMete(e.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
               productDTO.setActualReceivedMete(e.getActualReceivedMete().divide(BigDecimal.valueOf(1000000L)));
               productDTO.setAccountingUnit("㎡");
            } else {
               if (WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType() != orderDetail.getWageQuotaType()) {
                  throw new BusinessException("制成品计价方式类型不存在！");
               }

               productDTO.setMete(e.getMete());
               productDTO.setActualReceivedMete(e.getActualReceivedMete().divide(BigDecimal.valueOf(1000L)));
               productDTO.setAccountingUnit("kg");
            }
         }

         return productDTO;
      }).collect(Collectors.toList());
   }

   private static List<String> getTimePeriodFromMouthTime(LocalDate start, LocalDate end) {
      List<String> result = new ArrayList<>();
      YearMonth from = YearMonth.from(start);
      YearMonth to = YearMonth.from(end);

      for (long i = 0L; i <= ChronoUnit.MONTHS.between(from, to); i++) {
         YearMonth currentMonth = from.plusMonths(i);
         result.add(currentMonth.getYear() + "-" + String.format("%02d", currentMonth.getMonthValue()));
      }

      return result;
   }

   private PageVO<ProjectSubAppReceivingDTO> getCanInstallProductByArea(
      Integer productType,
      Long projectId,
      Long supplierId,
      Long monomerId,
      Long areaId,
      List<Long> areaIds,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      ProjectBaseQueryDTOParam param = new ProjectBaseQueryDTOParam();
      param.setSupplierId(supplierId);
      param.setProductType(productType);
      param.setProjectId(projectId);
      param.setMonomerId(monomerId);
      param.setAreaId(areaId);
      param.setAreaIds(areaIds);
      param.setSerialNumber(serialNumber);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingInstallDTO> installDTOList = this.receivingSummaryService.listReceivingInstallV2(param);
      if (CollectionUtils.isEmpty(installDTOList)) {
         return new PageVO<>();
      }

      List<String> serialNumberList = installDTOList.stream().map(ProjectReceivingInstallDTO::getSerialNumber).collect(Collectors.toList());
      Map<Long, Map<String, List<TechDrawing>>> drawMap = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getProjectId, param.getProjectId()))
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechDrawing::getProductType, param.getProductType()))
               .in(TechDrawing::getSerialNumber, serialNumberList)
         )
         .stream()
         .collect(Collectors.groupingBy(TechDrawing::getMonomerId, Collectors.groupingBy(TechDrawing::getSerialNumber)));
      List<ProjectSubAppReceivingDTO> appReceivingDTOList = installDTOList.stream()
         .map(
            a -> {
               ProjectSubAppReceivingDTO subAppReceivingDTO = BeanUtil.copy(a, ProjectSubAppReceivingDTO.class);
               if (drawMap.containsKey(a.getMonomerId()) && drawMap.get(a.getMonomerId()).containsKey(a.getSerialNumber())) {
                  subAppReceivingDTO.setNumbers(
                     drawMap.get(a.getMonomerId()).get(a.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList())
                  );
                  subAppReceivingDTO.setDrawingAndSerialNumber(
                     drawMap.get(a.getMonomerId())
                        .get(a.getSerialNumber())
                        .stream()
                        .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                        .collect(Collectors.toList())
                  );
               }

               return subAppReceivingDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, appReceivingDTOList);
   }

   private PageVO<ProjectSubAppReceivingDTO> getCanInstallProductByList(
      Integer productType, Long projectId, Long supplierId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      ProjectBaseQueryDTOParam param = new ProjectBaseQueryDTOParam();
      param.setSupplierId(supplierId);
      param.setProductType(productType);
      param.setProjectId(projectId);
      param.setMonomerId(monomerId);
      param.setAreaId(areaId);
      param.setSerialNumber(serialNumber);
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectReceivingInstallDTO> summaryList = this.receivingSummaryService.getListMethodReceivingInstall(param);
      if (CollectionUtils.isEmpty(summaryList)) {
         return new PageVO<>();
      }

      List<String> serialNumberList = summaryList.stream().map(ProjectReceivingInstallDTO::getSerialNumber).collect(Collectors.toList());
      Map<Long, Map<String, List<TechDrawing>>> drawMap = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getProjectId, param.getProjectId()))
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechDrawing::getProductType, param.getProductType()))
               .in(TechDrawing::getSerialNumber, serialNumberList)
         )
         .stream()
         .collect(Collectors.groupingBy(TechDrawing::getMonomerId, Collectors.groupingBy(TechDrawing::getSerialNumber)));
      List<ProjectSubAppReceivingDTO> appReceivingDTOList = summaryList.stream()
         .map(a -> BeanUtil.copy(a, ProjectSubAppReceivingDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(page, appReceivingDTOList);
   }
}
