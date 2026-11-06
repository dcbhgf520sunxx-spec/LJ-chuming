package com.hzchum.scim.business.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingWeightTypeEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dto.ArtifactBasicsCountDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ArtifactBasicsDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ArtifactDetailsExportDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessReturnProductDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessShipCargoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ContractSaleLedgerDTO;
import com.hzchum.scim.business.core.api.pojo.dto.EnclosureBasicsDTO;
import com.hzchum.scim.business.core.api.pojo.dto.EnclosureSummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentRecordDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryPriceDTO;
import com.hzchum.scim.business.core.api.pojo.dto.TechStandardPartShipDTO;
import com.hzchum.scim.business.core.api.pojo.dto.TrackingDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.TrainTrackingDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.business.core.api.service.bridge.BusinessBridgeBoxService;
import com.hzchum.scim.business.core.api.utils.BusinessPriceUtils;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReturnProductStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.CargoListProductLinkPriceDTO;
import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo.dto.CostShipAmountDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractLedgerSimpleDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactBasicsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.CargoListDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.TechStandardPartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList.CargoListDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListProductLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.TechMachinePartShipDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessBizImpl implements BusinessBiz {
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Resource
   private TechStandardPartService standardPartService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private ContractProjectContentService projectContentService;
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Resource
   private MesBuildingWarehouseSummaryService buildingWarehouseSummaryService;
   @Autowired
   private BusinessArtifactService businessArtifactService;
   @Autowired
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private BusinessMachinePartService businessMachinePartService;
   @Resource
   private BusinessStandardPartService businessStandardPartService;
   @Autowired
   private BusinessBridgeBoxService businessBridgeBoxService;
   @Resource
   private BusinessPriceUtils businessPriceUtils;
   @Resource
   private ProjectReturnProductChildService returnProductChildService;

   @Override
   public Boolean bind(BindDTOParam param) {
      TechArtifact artifact = this.artifactService.getById(param.getProductId());
      int count = this.artifactService.count((Wrapper<TechArtifact>)Wrappers.<TechArtifact>lambdaQuery().eq(TechArtifact::getBusinessId, artifact.getBusinessId()));
      Preconditions.checkArgument(count != 1, "商务仅有一条记录，无需绑定");
      Long businessId;
      if (StringUtils.isNotBlank(param.getName())) {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getName()), "商务名称不能为空");
         ArtifactFindDTOParam artifactFind = ArtifactFindDTOParam.builder().monomerId(artifact.getMonomerId()).name(param.getName()).build();
         BusinessArtifact business = this.businessArtifactService.getByCondition(artifactFind);
         Preconditions.checkArgument(business == null, "单独计价已存在名称为" + param.getName() + "商务");
         BusinessArtifact save = BusinessArtifact.builder()
            .projectId(artifact.getProjectId())
            .monomerId(artifact.getMonomerId())
            .areaId(artifact.getAreaId())
            .material(artifact.getMaterial())
            .boolMergeEnum(false)
            .name(param.getName())
            .specification(artifact.getSpecification())
            .totalQuantity(artifact.getQuantity())
            .totalWeight(artifact.getTotalNetWeight())
            .totalLength(
               artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
            )
            .build();
         this.businessArtifactService.save(save);
         businessId = save.getId();
      } else {
         Preconditions.checkArgument(param.getBusinessId() != null, "商务id不能为空");
         BusinessArtifact business = this.businessArtifactService.getById(param.getBusinessId());
         Preconditions.checkArgument(business != null, "商务记录不存在");
         Preconditions.checkArgument(business.getMaterial().equals(artifact.getMaterial()), "仅可材质相同另行计价");
         business.setTotalQuantity(business.getTotalQuantity() + artifact.getQuantity());
         business.setTotalWeight(business.getTotalWeight().add(artifact.getTotalNetWeight()));
         this.businessArtifactService.updateById(business);
         businessId = param.getBusinessId();
      }

      BusinessArtifact oldBusiness = this.businessArtifactService.getById(artifact.getBusinessId());
      Preconditions.checkArgument(oldBusiness != null, "原有商务不存在");
      oldBusiness.setTotalQuantity(oldBusiness.getTotalQuantity() - artifact.getQuantity());
      oldBusiness.setTotalWeight(oldBusiness.getTotalWeight().subtract(artifact.getTotalNetWeight()));
      oldBusiness.setTotalLength(
         oldBusiness.getTotalLength()
            .subtract(
               artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
            )
      );
      this.businessArtifactService.updateById(oldBusiness);
      artifact.setBusinessId(businessId);
      this.artifactService.updateById(artifact);
      return true;
   }

   @Override
   public SummaryDTO summaryEnclosure(Long projectId, Long monomerId) {
      ContractProject project = this.projectService.getById(projectId);
      EnclosureSummaryDTO summary = this.businessEnclosureService.summary(projectId, monomerId);
      return SummaryDTO.builder().quantity(summary.getTotalQuantity()).mete(summary.getTotalLength()).price(summary.getTotalPrice()).build();
   }

   @Override
   public SummaryPriceDTO summary(Long projectId, Long monomerId, Long areaId, Integer type) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      SummaryPriceDTO summary = SummaryPriceDTO.builder().projectPrice(BigDecimal.ZERO).monomerPrice(BigDecimal.ZERO).areaPrice(BigDecimal.ZERO).build();
      if (project.getProjectType() != null && (project.getProjectType() & 65) > 0) {
         if (type.equals(ProductTypeEnum.ARTIFACT.getType())) {
            SummaryDTO projectPrice = this.businessArtifactService.summary(projectId, null, null);
            summary.setProjectPrice(projectPrice.getPrice());
            if (monomerId != null) {
               SummaryDTO monomerPrice = this.businessArtifactService.summary(projectId, monomerId, null);
               summary.setMonomerPrice(monomerPrice.getPrice());
            }

            if (areaId != null) {
               SummaryDTO areaPrice = this.businessArtifactService.summary(projectId, monomerId, areaId);
               summary.setAreaPrice(areaPrice.getPrice());
            }
         }

         if (type.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            List<BusinessMachinePart> businessMachinePartList = this.businessMachinePartService
               .list(Wrappers.lambdaQuery(BusinessMachinePart.builder().projectId(projectId).build()));
            BigDecimal projectPrice = businessMachinePartList.stream()
               .filter(b -> b.getUnitPrice() != null)
               .map(BusinessMachinePart::getTotalPrice)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            summary.setProjectPrice(projectPrice);
            if (monomerId != null) {
               BigDecimal monomerPrice = businessMachinePartList.stream()
                  .filter(b -> b.getMonomerId().equals(monomerId))
                  .filter(b -> b.getUnitPrice() != null)
                  .map(BusinessMachinePart::getTotalPrice)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               summary.setMonomerPrice(monomerPrice);
            }

            if (areaId != null) {
               BigDecimal areaPrice = businessMachinePartList.stream()
                  .filter(b -> b.getAreaId().equals(areaId))
                  .filter(b -> b.getUnitPrice() != null)
                  .map(BusinessMachinePart::getTotalPrice)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               summary.setAreaPrice(areaPrice);
            }
         }

         if (type.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            List<BusinessStandardPart> standardPartList = this.businessStandardPartService
               .list(Wrappers.lambdaQuery(BusinessStandardPart.builder().projectId(projectId).build()));
            BigDecimal reduce = standardPartList.stream()
               .filter(b -> b.getUnitPrice() != null)
               .map(BusinessStandardPart::getTotalPrice)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            summary.setProjectPrice(reduce);
         }
      }

      return summary;
   }

   @Override
   public PageVO<TrackingDTO> pageTrainTracking(TrainTrackingDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      PageVO<CargoListDO> cargoLists = this.cargoListService.pageByCondition(copy);
      PageVO<TrackingDTO> result = new PageVO<>();
      result.setContent(
         cargoLists.getContent()
            .stream()
            .map(
               e -> {
                  TrackingDTO tracking = BeanUtil.copy(e, TrackingDTO.class);
                  Map<String, Object> map = this.cargoListBiz
                     .getShipAmountByCargoListId(e.getId(), e.getStructureMeasureMode(), e.getEnclosureMeasureMode(), e.getProject().getId());
                  tracking.setShipAmount(new BigDecimal(map.get("shipAmount").toString()));
                  return tracking;
               }
            )
            .collect(Collectors.toList())
      );
      result.setHasNextPage(cargoLists.isHasNextPage());
      result.setHasPreviousPage(cargoLists.isHasPreviousPage());
      result.setTotalElements(cargoLists.getTotalElements());
      return result;
   }

   @Override
   public Map<String, Object> getTrainTracking(Long id) {
      Map<String, Object> result = new HashMap<>();
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      result.put("artifacts", this.cargoListProductLinkService.listArtifactAllById(id));
      result.put("enclosures", this.cargoListProductLinkService.listEnclosureAllById(id));
      result.put("auxiliaryMaterials", this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id));
      result.put("structureMeasureMode", cargoList.getStructureMeasureMode());
      result.put("enclosureMeasureMode", cargoList.getEnclosureMeasureMode());
      return result;
   }

   @Override
   public PageVO<ContractSaleLedgerDTO> pageListSalesLedger(
      Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType, Integer pageNumber, Integer pageSize
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      Long userId = user.isAdmin() ? null : user.getId();
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractLedgerSimpleDTO> contractLedgerSimpleDTOS = this.projectService
         .listSalesLedger(userId, year, projectStatus, name, orderSourceType, productType);
      List<ContractSaleLedgerDTO> saleLedgerDTOList = this.listSaleLedger(contractLedgerSimpleDTOS);
      return new PageVO<>(PageUtils.getPageInfo(saleLedgerDTOList, contractLedgerSimpleDTOS));
   }

   private List<ContractSaleLedgerDTO> listSaleLedger(List<ContractLedgerSimpleDTO> contractLedgerSimpleDTOS) {
      List<ContractSaleLedgerDTO> saleLedgerDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(contractLedgerSimpleDTOS)) {
         List<Long> projectIds = contractLedgerSimpleDTOS.stream().map(s -> s.getProject().getId()).collect(Collectors.toList());
         List<ContractProjectContent> projectContentList = this.projectContentService.list();
         Map<String, String> projectContentMap = projectContentList.stream()
            .collect(Collectors.toMap(c -> c.getId().toString(), ContractProjectContent::getName));
         Map<Long, BigDecimal> projectWarehouseAmountMap = this.getProjectWarehouseAmountMap(projectIds);
         Map<Long, BigDecimal> projectShipAmountMap = this.getProjectAllProduceAmountMap(projectIds, null, null);
         Map<Long, Integer> transportQuantityMap = this.getProjectTransportQuantityMap(projectIds);
         saleLedgerDTOList = contractLedgerSimpleDTOS.stream().map(s -> {
            ContractSaleLedgerDTO saleLedgerDTO = BeanUtil.copy(s, ContractSaleLedgerDTO.class);
            saleLedgerDTO.setHappenedAmount(projectShipAmountMap.getOrDefault(s.getProject().getId(), BigDecimal.ZERO));
            saleLedgerDTO.setWarehouseAmount(projectWarehouseAmountMap.getOrDefault(s.getProject().getId(), BigDecimal.ZERO));
            saleLedgerDTO.setTransportQuantity(transportQuantityMap.getOrDefault(s.getProject().getId(), 0));
            return saleLedgerDTO;
         }).collect(Collectors.toList());
      }

      return saleLedgerDTOList;
   }

   @Override
   public Map<Long, BigDecimal> getProjectWarehouseAmountMap(List<Long> projectIds) {
      if (CollectionUtils.isEmpty(projectIds)) {
         return Collections.emptyMap();
      }

      Map<Long, BigDecimal> projectWarehouseAmountMap = new HashMap<>(32);
      List<ContractProject> projectList = this.projectService.listByIds(projectIds);
      List<Long> buildingProjectIds = projectList.stream()
         .filter(
            cp -> cp.getProjectType().equals(ProjectTypeEnum.MES.getType())
               || cp.getProjectType().equals(ProjectTypeEnum.ENCLOSURE.getType())
               || cp.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
         )
         .map(ContractProject::getId)
         .collect(Collectors.toList());
      this.buildingProjectWarehouseAmount(buildingProjectIds, projectWarehouseAmountMap);
      return projectWarehouseAmountMap;
   }

   private void buildingProjectWarehouseAmount(List<Long> projectIds, Map<Long, BigDecimal> projectWarehouseAmountMap) {
      if (!CollectionUtils.isEmpty(projectIds)) {
         List<MesBuildingWarehouseSummary> warehouseSummaryList = this.buildingWarehouseSummaryService
            .findAllWarehouseSummary(projectIds, WarehouseTypeEnum.INTO.getType());
         List<Long> artifactIds = warehouseSummaryList.stream()
            .filter(w -> w.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
            .map(MesBuildingWarehouseSummary::getProductId)
            .collect(Collectors.toList());
         List<Long> standardIds = warehouseSummaryList.stream()
            .filter(w -> w.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
            .map(MesBuildingWarehouseSummary::getProductId)
            .collect(Collectors.toList());
         List<Long> enclosureIds = warehouseSummaryList.stream()
            .filter(w -> w.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()))
            .map(MesBuildingWarehouseSummary::getProductId)
            .collect(Collectors.toList());
         List<Long> purLineIds = warehouseSummaryList.stream()
            .filter(w -> w.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
            .map(MesBuildingWarehouseSummary::getProductId)
            .collect(Collectors.toList());
         List<Long> assembleIds = warehouseSummaryList.stream()
            .filter(w -> w.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
            .map(MesBuildingWarehouseSummary::getProductId)
            .collect(Collectors.toList());
         Map<Long, TechArtifact> allArtifactMap = Collections.emptyMap();
         Map<Long, BusinessArtifact> businessArtifactMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(artifactIds)) {
            List<TechArtifact> allArtifactList = this.artifactService.listByIds(artifactIds);
            allArtifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
            List<TechArtifact> artifactList = allArtifactList.stream().filter(a -> !a.getBoolAllPartSendDirectly()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(artifactList)) {
               List<BusinessArtifact> businessArtifactList = this.businessArtifactService
                  .listByIds(artifactList.stream().map(TechArtifact::getBusinessId).collect(Collectors.toSet()));
               businessArtifactMap = businessArtifactList.stream().collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
            }
         }

         Map<Long, TechArtifact> finalAllArtifactMap = allArtifactMap;
         Map<Long, BusinessArtifact> finalBusinessArtifactMap = businessArtifactMap;
         Map<Long, TechStandardPart> standardPartMap = Collections.emptyMap();
         Map<Long, BusinessStandardPart> businessStandardPartMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(standardIds)) {
            List<TechStandardPart> standardPartList = this.standardPartService.listByIds(standardIds);
            standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
            businessStandardPartMap = this.businessStandardPartService
               .listByIds(standardPartList.stream().map(TechStandardPart::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
         }

         Map<Long, TechStandardPart> finalStandardPartMap = standardPartMap;
         Map<Long, BusinessStandardPart> finalBusinessStandardPartMap = businessStandardPartMap;
         Map<Long, TechEnclosure> enclosureMap = Collections.emptyMap();
         Map<Long, BusinessEnclosure> businessEnclosureMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(enclosureIds)) {
            List<TechEnclosure> enclosureList = this.enclosureService.listByIds(enclosureIds);
            enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
            businessEnclosureMap = this.businessEnclosureService
               .listByIds(enclosureList.stream().map(TechEnclosure::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
         }

         Map<Long, TechEnclosure> finalEnclosureMap = enclosureMap;
         Map<Long, BusinessEnclosure> finalBusinessEnclosureMap = businessEnclosureMap;
         Map<Long, TechAssemble> assembleMap = Collections.emptyMap();
         Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(assembleIds)) {
            List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
            assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            businessAssembleMap = this.businessMachinePartService
               .listByIds(assembleList.stream().map(TechAssemble::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
         }

         Map<Long, TechAssemble> finalAssembleMap = assembleMap;
         Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
         Map<Long, TechMachinePart> purLineMap = Collections.emptyMap();
         Map<Long, BusinessMachinePart> businessPurLineMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(purLineIds)) {
            List<TechMachinePart> purLineList = this.machinePartService.listByIds(purLineIds);
            purLineMap = purLineList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            businessPurLineMap = this.businessMachinePartService
               .listByIds(purLineList.stream().map(TechMachinePart::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
         }

         Map<Long, TechMachinePart> finalPurLineMap = purLineMap;
         Map<Long, BusinessMachinePart> finalBusinessPurLineMap = businessPurLineMap;
         Map<Long, List<MesBuildingWarehouseSummary>> projectWarehouseListMap = warehouseSummaryList.stream()
            .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProjectId));
         projectWarehouseListMap.forEach(
            (projectId, warehouseList) -> {
               List<BigDecimal> productAmountList = new ArrayList<>(1024);
               warehouseList.forEach(
                  product -> {
                     BigDecimal productAmount = BigDecimal.ZERO;
                     if (product.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        TechArtifact artifact = finalAllArtifactMap.get(product.getProductId());
                        if (!artifact.getBoolAllPartSendDirectly()) {
                           BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                           if (businessArtifact != null && businessArtifact.getUnitPrice() != null) {
                              productAmount = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                                 ? artifact.getNetWeight()
                                    .multiply(product.getQuantity())
                                    .multiply(businessArtifact.getUnitPrice())
                                    .divide(BigDecimal.valueOf(1000L))
                                 : artifact.getLength()
                                    .multiply(product.getQuantity())
                                    .multiply(businessArtifact.getUnitPrice())
                                    .divide(BigDecimal.valueOf(1000L));
                           }
                        }
                     }

                     if (product.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                        TechStandardPart standardPart = finalStandardPartMap.get(product.getProductId());
                        BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                        if (businessStandardPart.getUnitPrice() != null) {
                           productAmount = businessStandardPart.getUnitPrice().multiply(product.getQuantity());
                        }
                     }

                     if (product.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                        TechEnclosure enclosure = finalEnclosureMap.get(product.getProductId());
                        BusinessEnclosure businessEnclosure = finalBusinessEnclosureMap.get(enclosure.getBusinessId());
                        if (businessEnclosure != null && businessEnclosure.getUnitPrice() != null) {
                           productAmount = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                              ? businessEnclosure.getUnitPrice()
                                 .multiply(enclosure.getLength())
                                 .multiply(product.getQuantity())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : businessEnclosure.getUnitPrice()
                                 .multiply(enclosure.getSurfaceArea())
                                 .multiply(product.getQuantity())
                                 .divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP);
                        }
                     }

                     if (product.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                        TechAssemble assemble = finalAssembleMap.get(product.getProductId());
                        BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                        if (businessAssemble != null && businessAssemble.getUnitPrice() != null) {
                           productAmount = businessAssemble.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                              ? businessAssemble.getUnitPrice()
                                 .multiply(assemble.getLength())
                                 .multiply(product.getQuantity())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : businessAssemble.getUnitPrice()
                                 .multiply(assemble.getNetWeight())
                                 .multiply(product.getQuantity())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }
                     }

                     if (product.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                        TechMachinePart part = finalPurLineMap.get(product.getProductId());
                        BusinessMachinePart businessMachinePart = finalBusinessPurLineMap.get(part.getBusinessId());
                        if (businessMachinePart != null && businessMachinePart.getUnitPrice() != null) {
                           productAmount = businessMachinePart.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                              ? businessMachinePart.getUnitPrice()
                                 .multiply(part.getLength())
                                 .multiply(product.getQuantity())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : businessMachinePart.getUnitPrice()
                                 .multiply(part.getNetWeight())
                                 .multiply(product.getQuantity())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }
                     }

                     productAmountList.add(productAmount);
                  }
               );
               BigDecimal projectAmount = productAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
               projectWarehouseAmountMap.put(projectId, projectAmount);
            }
         );
      }
   }

   @Override
   public Map<Long, BigDecimal> getProjectShipAmountMap(List<Long> projectIds) {
      Map<Long, BigDecimal> projectShipAmountMap = new HashMap<>(32);
      List<CargoListProductLinkDTO> productLinkDTOList = this.cargoListProductLinkService.listShipProductRecord(projectIds, null, null, null, null, null, null);
      List<Long> artifactIds = new ArrayList<>(1024);
      List<Long> enclosureIds = new ArrayList<>(256);
      List<Long> standardIds = new ArrayList<>(128);
      List<Long> purLineIds = new ArrayList<>(128);
      List<Long> assembleIds = new ArrayList<>(128);
      productLinkDTOList.forEach(link -> {
         if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            artifactIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            enclosureIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            purLineIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            assembleIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            standardIds.add(link.getProductId());
         }
      });
      Map<Long, TechArtifact> allArtifactMap = Collections.emptyMap();
      Map<Long, BusinessArtifact> businessArtifactMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         List<TechArtifact> allArtifactList = this.artifactService.listByIds(artifactIds);
         allArtifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechArtifact> artifactList = allArtifactList.stream().filter(a -> !a.getBoolAllPartSendDirectly()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artifactList)) {
            businessArtifactMap = this.businessArtifactService
               .listByIds(artifactList.stream().map(TechArtifact::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
         }
      }

      Map<Long, TechArtifact> finalAllArtifactMap = allArtifactMap;
      Map<Long, BusinessArtifact> finalBusinessArtifactMap = businessArtifactMap;
      Map<Long, TechEnclosure> enclosureMap = Collections.emptyMap();
      Map<Long, BusinessEnclosure> businessEnclosureMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(enclosureIds)) {
         List<TechEnclosure> enclosureList = this.enclosureService.listByIds(enclosureIds);
         enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
            .listByIds(enclosureList.stream().map(TechEnclosure::getBusinessId).collect(Collectors.toSet()));
         businessEnclosureMap = businessEnclosureList.stream().collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
      }

      Map<Long, TechEnclosure> finalEnclosureMap = enclosureMap;
      Map<Long, BusinessEnclosure> finalBusinessEnclosureMap = businessEnclosureMap;
      Map<Long, TechStandardPart> standardPartMap = Collections.emptyMap();
      Map<Long, BusinessStandardPart> businessStandardPartMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(standardIds)) {
         List<TechStandardPart> standardPartList = this.standardPartService.listByIds(standardIds);
         standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
            .listByIds(standardPartList.stream().map(TechStandardPart::getBusinessId).collect(Collectors.toSet()));
         businessStandardPartMap = businessStandardPartList.stream().collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
      }

      Map<Long, TechStandardPart> finalStandardPartMap = standardPartMap;
      Map<Long, BusinessStandardPart> finalBusinessStandardPartMap = businessStandardPartMap;
      Map<Long, TechMachinePart> purLineMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businesspurLineMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(purLineIds)) {
         List<TechMachinePart> machinePartList = this.machinePartService.listByIds(purLineIds);
         purLineMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         List<BusinessMachinePart> businessMachinePartList = this.businessMachinePartService
            .listByIds(machinePartList.stream().map(TechMachinePart::getBusinessId).collect(Collectors.toSet()));
         businesspurLineMap = businessMachinePartList.stream().collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
      }

      Map<Long, TechMachinePart> finalPurLineMap = purLineMap;
      Map<Long, BusinessMachinePart> finalBusinessPurLineMap = businesspurLineMap;
      Map<Long, TechAssemble> assembleMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
         assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         businessAssembleMap = this.businessMachinePartService
            .listByIds(assembleList.stream().map(TechAssemble::getBusinessId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
      }

      Map<Long, TechAssemble> finalAssembleMap = assembleMap;
      Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
      Map<Long, List<CargoListProductLinkDTO>> projectProductLinkMap = productLinkDTOList.stream()
         .collect(Collectors.groupingBy(CargoListProductLinkDTO::getProjectId));
      projectProductLinkMap.forEach(
         (projectId, list) -> {
            List<BigDecimal> productAmountList = new ArrayList<>(128);
            list.forEach(
               product -> {
                  BigDecimal productAmount = BigDecimal.ZERO;
                  if (product.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = finalAllArtifactMap.get(product.getProductId());
                     if (!artifact.getBoolAllPartSendDirectly()) {
                        BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                        if (businessArtifact.getUnitPrice() != null) {
                           productAmount = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? product.getWeight()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : artifact.getLength()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = finalEnclosureMap.get(product.getProductId());
                     BusinessEnclosure businessEnclosure = finalBusinessEnclosureMap.get(enclosure.getBusinessId());
                     if (businessEnclosure.getUnitPrice() != null) {
                        productAmount = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? enclosure.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : enclosure.getSurfaceArea()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000000L));
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = finalStandardPartMap.get(product.getProductId());
                     BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                     if (businessStandardPart.getUnitPrice() != null) {
                        productAmount = standardPart.getMete()
                           .multiply(businessStandardPart.getUnitPrice())
                           .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                           .divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP);
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = finalAssembleMap.get(product.getProductId());
                     BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                     if (businessAssemble != null && businessAssemble.getUnitPrice() != null) {
                        productAmount = businessAssemble.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? businessAssemble.getUnitPrice()
                              .multiply(assemble.getLength())
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : businessAssemble.getUnitPrice()
                              .multiply(assemble.getNetWeight())
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart machinePart = finalPurLineMap.get(product.getProductId());
                     BusinessMachinePart businessPurLine = finalBusinessPurLineMap.get(machinePart.getBusinessId());
                     if (businessPurLine != null && businessPurLine.getUnitPrice() != null) {
                        productAmount = businessPurLine.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? machinePart.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPurLine.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : machinePart.getNetWeight()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPurLine.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L));
                     }
                  }

                  productAmountList.add(productAmount);
               }
            );
            BigDecimal projectShipAmount = productAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            projectShipAmountMap.put(projectId, projectShipAmount);
         }
      );
      return projectShipAmountMap;
   }

   @Override
   public Map<Long, BigDecimal> getProjectShipAmountMapMonth(List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate) {
      Map<Long, BigDecimal> projectShipAmountMap = new HashMap<>(32);
      List<CargoListProductLinkDTO> productLinkDTOList = this.cargoListProductLinkService
         .listShipProductRecord(projectIds, null, null, null, null, auditStartDate, auditEndDate);
      List<Long> artifactIds = new ArrayList<>(1024);
      List<Long> enclosureIds = new ArrayList<>(256);
      List<Long> standardIds = new ArrayList<>(128);
      productLinkDTOList.forEach(link -> {
         if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            artifactIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            enclosureIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            standardIds.add(link.getProductId());
         }
      });
      Map<Long, TechArtifact> allArtifactMap = Collections.emptyMap();
      Map<Long, BusinessArtifact> businessArtifactMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         List<TechArtifact> allArtifactList = this.artifactService.listByIds(artifactIds);
         allArtifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechArtifact> artifactList = allArtifactList.stream().filter(a -> !a.getBoolAllPartSendDirectly()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artifactList)) {
            businessArtifactMap = this.businessArtifactService
               .listByIds(artifactList.stream().map(TechArtifact::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
         }
      }

      Map<Long, TechArtifact> finalAllArtifactMap = allArtifactMap;
      Map<Long, BusinessArtifact> finalBusinessArtifactMap = businessArtifactMap;
      Map<Long, TechEnclosure> enclosureMap = Collections.emptyMap();
      Map<Long, BusinessEnclosure> businessEnclosureMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(enclosureIds)) {
         List<TechEnclosure> enclosureList = this.enclosureService.listByIds(enclosureIds);
         enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
            .listByIds(enclosureList.stream().map(TechEnclosure::getBusinessId).collect(Collectors.toSet()));
         businessEnclosureMap = businessEnclosureList.stream().collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
      }

      Map<Long, TechEnclosure> finalEnclosureMap = enclosureMap;
      Map<Long, BusinessEnclosure> finalBusinessEnclosureMap = businessEnclosureMap;
      Map<Long, TechStandardPart> standardPartMap = Collections.emptyMap();
      Map<Long, BusinessStandardPart> businessStandardPartMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(standardIds)) {
         List<TechStandardPart> standardPartList = this.standardPartService.listByIds(standardIds);
         standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
            .listByIds(standardPartList.stream().map(TechStandardPart::getBusinessId).collect(Collectors.toSet()));
         businessStandardPartMap = businessStandardPartList.stream().collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
      }

      Map<Long, TechStandardPart> finalStandardPartMap = standardPartMap;
      Map<Long, BusinessStandardPart> finalBusinessStandardPartMap = businessStandardPartMap;
      Map<Long, TechMachinePart> purLineMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businesspurLineMap = Collections.emptyMap();
      Map<Long, TechMachinePart> finalPurLineMap = purLineMap;
      Map<Long, BusinessMachinePart> finalBusinessPurLineMap = businesspurLineMap;
      Map<Long, TechAssemble> assembleMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
      Map<Long, TechAssemble> finalAssembleMap = assembleMap;
      Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
      Map<Long, List<CargoListProductLinkDTO>> projectProductLinkMap = productLinkDTOList.stream()
         .collect(Collectors.groupingBy(CargoListProductLinkDTO::getProjectId));
      projectProductLinkMap.forEach(
         (projectId, list) -> {
            List<BigDecimal> productAmountList = new ArrayList<>(128);
            list.forEach(
               product -> {
                  BigDecimal productAmount = BigDecimal.ZERO;
                  if (product.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = finalAllArtifactMap.get(product.getProductId());
                     if (!artifact.getBoolAllPartSendDirectly()) {
                        BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                        if (businessArtifact.getUnitPrice() != null) {
                           productAmount = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? product.getWeight()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : artifact.getLength()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = finalEnclosureMap.get(product.getProductId());
                     BusinessEnclosure businessEnclosure = finalBusinessEnclosureMap.get(enclosure.getBusinessId());
                     if (businessEnclosure.getUnitPrice() != null) {
                        productAmount = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? enclosure.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : enclosure.getSurfaceArea()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000000L));
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = finalStandardPartMap.get(product.getProductId());
                     BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                     if (businessStandardPart.getUnitPrice() != null) {
                        productAmount = standardPart.getMete()
                           .multiply(businessStandardPart.getUnitPrice())
                           .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                           .divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP);
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = finalAssembleMap.get(product.getProductId());
                     BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                     if (businessAssemble != null && businessAssemble.getUnitPrice() != null) {
                        productAmount = businessAssemble.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? businessAssemble.getUnitPrice()
                              .multiply(assemble.getLength())
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : businessAssemble.getUnitPrice()
                              .multiply(assemble.getNetWeight())
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart machinePart = finalPurLineMap.get(product.getProductId());
                     BusinessMachinePart businessPurLine = finalBusinessPurLineMap.get(machinePart.getBusinessId());
                     if (businessPurLine != null && businessPurLine.getUnitPrice() != null) {
                        productAmount = businessPurLine.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? machinePart.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPurLine.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : machinePart.getNetWeight()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPurLine.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L));
                     }
                  }

                  productAmountList.add(productAmount);
               }
            );
            BigDecimal projectShipAmount = productAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            projectShipAmountMap.put(projectId, projectShipAmount);
         }
      );
      return projectShipAmountMap;
   }

   @Override
   public CostShipAmountDTO getProjectCostShipAmountDTOMonth(List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate) {
      CostShipAmountDTO costShipAmountDTO = new CostShipAmountDTO();
      List<CargoListProductLinkDTO> productLinkDTOList = this.cargoListProductLinkService
         .listShipProductRecord(projectIds, null, null, null, null, auditStartDate, auditEndDate);
      productLinkDTOList.forEach(
         link -> {
            if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact techArtifact = this.artifactService.getById(link.getProductId());
               BigDecimal totalOutputArtifact = BigDecimal.ZERO;
               if (costShipAmountDTO.getTotalOutputArtifact() == null) {
                  totalOutputArtifact = totalOutputArtifact.add(
                     new BigDecimal(link.getQuantity()).multiply(techArtifact.getNetWeight()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
                  );
               } else {
                  totalOutputArtifact = costShipAmountDTO.getTotalOutputArtifact();
                  totalOutputArtifact = totalOutputArtifact.add(
                     new BigDecimal(link.getQuantity()).multiply(techArtifact.getNetWeight()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
                  );
               }

               costShipAmountDTO.setTotalOutputArtifact(totalOutputArtifact);
            }

            if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               TechEnclosure techEnclosure = this.enclosureService.getById(link.getProductId());
               BigDecimal totalOutputEnclosure = BigDecimal.ZERO;
               if (costShipAmountDTO.getTotalOutputEnclosure() == null) {
                  totalOutputEnclosure = totalOutputEnclosure.add(
                     new BigDecimal(link.getQuantity()).multiply(techEnclosure.getLength()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
                  );
               } else {
                  totalOutputEnclosure = costShipAmountDTO.getTotalOutputEnclosure();
                  totalOutputEnclosure = totalOutputEnclosure.add(
                     new BigDecimal(link.getQuantity()).multiply(techEnclosure.getLength()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
                  );
               }

               costShipAmountDTO.setTotalOutputEnclosure(totalOutputEnclosure);
            }

            if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
               TechStandardPart techStandardPart = this.standardPartService.getById(link.getProductId());
               BigDecimal totalOutputStandard = BigDecimal.ZERO;
               if (costShipAmountDTO.getTotalOutputStandard() == null) {
                  totalOutputStandard = totalOutputStandard.add(new BigDecimal(link.getQuantity()));
               } else {
                  totalOutputStandard = costShipAmountDTO.getTotalOutputStandard();
                  totalOutputStandard = totalOutputStandard.add(new BigDecimal(link.getQuantity()));
               }

               costShipAmountDTO.setTotalOutputStandard(totalOutputStandard);
            }
         }
      );
      return costShipAmountDTO;
   }

   @Override
   public Map<Long, Integer> getProjectTransportQuantityMap(List<Long> projectIds) {
      Map<Long, Integer> projectTransportQuantityMap = new HashMap<>(16);
      if (CollectionUtils.isNotEmpty(projectIds)) {
         this.cargoListService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoList.class)
                  .in(MesBuildingCargoList::getProjectId, projectIds)
                  .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
                  .eq(MesBuildingCargoList::getDeliveryStatus, ShipmentStatusEnum.DELIVERY.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingCargoList::getProjectId, Collectors.counting()))
            .forEach((projectId, count) -> {
               Integer var10000 = projectTransportQuantityMap.put(projectId, Math.toIntExact(count));
            });
      }

      return projectTransportQuantityMap;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListSalesLedger(
      Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      printVO.setHeader(header);
      Long userId = user.isAdmin() ? null : user.getId();
      List<ContractLedgerSimpleDTO> contractLedgerSimpleDTOS = this.projectService
         .listSalesLedger(userId, year, projectStatus, name, orderSourceType, productType);
      List<ContractSaleLedgerDTO> saleLedgerDTOList = this.listSaleLedger(contractLedgerSimpleDTOS);
      List<Map<String, Object>> mapList = saleLedgerDTOList.stream()
         .map(
            e -> {
               Map<String, Object> result = BeanUtil.beanToMap(e);
               result.put(
                  "collectionAmountRate",
                  e.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? e.getCollectionAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                     : e.getCollectionAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getContractAmount(), 2, RoundingMode.HALF_UP)
               );
               result.put(
                  "invoiceAmountRate",
                  e.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? e.getInvoiceAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                     : e.getInvoiceAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getContractAmount(), 2, RoundingMode.HALF_UP)
               );
               result.put(
                  "happenedAmountRate",
                  e.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? e.getHappenedAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                     : e.getHappenedAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getContractAmount(), 2, RoundingMode.HALF_UP)
               );
               result.put(
                  "warehouseAmountRate",
                  e.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? e.getWarehouseAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getSettlementAmount(), 2, RoundingMode.HALF_UP)
                     : e.getWarehouseAmount().multiply(BigDecimal.valueOf(100L)).divide(e.getContractAmount(), 2, RoundingMode.HALF_UP)
               );
               return result;
            }
         )
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<ShipmentInfoDTO> pageTracking(
      Long projectId,
      Long monomerId,
      Integer productType,
      String name,
      String serialNumber,
      LocalDateTime auditStartDate,
      LocalDateTime auditEndDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<CargoListProductLinkDTO> productShips = this.cargoListProductLinkService
         .listAllProductRecord(Collections.singletonList(projectId), monomerId, productType, name, serialNumber, auditStartDate, auditEndDate);
      List<ShipmentInfoDTO> shipmentInfoDTOList = this.getShipList(productShips);
      return new PageVO<>(PageUtils.getPageInfo(shipmentInfoDTOList, productShips));
   }

   private List<ShipmentInfoDTO> getShipList(List<CargoListProductLinkDTO> productShips) {
      List<ShipmentInfoDTO> shipmentInfoDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(productShips)) {
         Set<Long> projectIds = productShips.stream().map(CargoListProductLinkDTO::getProjectId).collect(Collectors.toSet());
         Set<Long> monomerIds = productShips.stream().map(CargoListProductLinkDTO::getMonomerId).filter(Objects::nonNull).collect(Collectors.toSet());
         Set<Long> areaIds = productShips.stream()
            .filter(s -> !s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()))
            .map(CargoListProductLinkDTO::getAreaId)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
         Set<Long> enclosurePlanIds = productShips.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()))
            .map(CargoListProductLinkDTO::getAreaId)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
         Map<Long, ProjectInfo> projectMap = this.projectService
            .listSimpleByIdList(projectIds)
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         Map<Long, NameInfo> monomerMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(monomerIds)) {
            monomerMap = this.monomerService.listNameInfo(monomerIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> areaMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(areaIds)) {
            areaMap = this.areaService.listSimpleByIds(areaIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> enclosurePlanMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(enclosurePlanIds)) {
            enclosurePlanMap = this.enclosurePlanService
               .listByIds(enclosurePlanIds)
               .stream()
               .map(s -> BeanUtil.copy(s, NameInfo.class))
               .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> finalMonomerMap = monomerMap;
         Map<Long, NameInfo> finalAreaMap = areaMap;
         Map<Long, NameInfo> finalEnclosurePlanMap = enclosurePlanMap;
         Set<Long> purLineIds = productShips.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
            .map(CargoListProductLinkDTO::getProductId)
            .collect(Collectors.toSet());
         Set<Long> artifactIds = productShips.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
            .map(CargoListProductLinkDTO::getProductId)
            .collect(Collectors.toSet());
         Set<Long> standardIds = productShips.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
            .map(CargoListProductLinkDTO::getProductId)
            .collect(Collectors.toSet());
         Set<Long> enclosureIds = productShips.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()))
            .map(CargoListProductLinkDTO::getProductId)
            .collect(Collectors.toSet());
         Set<Long> assembleIds = productShips.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
            .map(CargoListProductLinkDTO::getProductId)
            .collect(Collectors.toSet());
         Map<Long, TechArtifact> allArtifactMap = Collections.emptyMap();
         Map<Long, BusinessArtifact> businessArtifactMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(artifactIds)) {
            List<TechArtifact> allArtifactList = this.artifactService.listByIds(artifactIds);
            allArtifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
            List<TechArtifact> artifactList = allArtifactList.stream().filter(a -> !a.getBoolAllPartSendDirectly()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(artifactList)) {
               businessArtifactMap = this.businessArtifactService
                  .listByIds(artifactList.stream().map(TechArtifact::getBusinessId).collect(Collectors.toSet()))
                  .stream()
                  .collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
            }
         }

         Map<Long, TechArtifact> finalAllArtifactMap = allArtifactMap;
         Map<Long, BusinessArtifact> finalBusinessArtifactMap = businessArtifactMap;
         Map<Long, TechStandardPart> standardPartMap = Collections.emptyMap();
         Map<Long, BusinessStandardPart> businessStandardPartMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(standardIds)) {
            List<TechStandardPart> standardPartList = this.standardPartService.listByIds(standardIds);
            standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
            List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
               .listByIds(standardPartList.stream().map(TechStandardPart::getBusinessId).collect(Collectors.toSet()));
            businessStandardPartMap = businessStandardPartList.stream().collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
         }

         Map<Long, TechStandardPart> finalStandardPartMap = standardPartMap;
         Map<Long, BusinessStandardPart> finalBusinessStandardPartMap = businessStandardPartMap;
         Map<Long, TechEnclosure> enclosureMap = Collections.emptyMap();
         Map<Long, BusinessEnclosure> businessEnclosureMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(enclosureIds)) {
            List<TechEnclosure> enclosureList = this.enclosureService.listByIds(enclosureIds);
            enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
            businessEnclosureMap = this.businessEnclosureService
               .listByIds(enclosureList.stream().map(TechEnclosure::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
         }

         Map<Long, TechEnclosure> finalEnclosureMap = enclosureMap;
         Map<Long, BusinessEnclosure> finalBusinessEnclosureMap = businessEnclosureMap;
         Map<Long, TechAssemble> assembleMap = Collections.emptyMap();
         Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(assembleIds)) {
            List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
            assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            businessAssembleMap = this.businessMachinePartService
               .listByIds(assembleList.stream().map(TechAssemble::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
         }

         Map<Long, TechAssemble> finalAssembleMap = assembleMap;
         Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
         Map<Long, TechMachinePart> purLineMap = Collections.emptyMap();
         Map<Long, BusinessMachinePart> businessPurLineMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(purLineIds)) {
            List<TechMachinePart> machinePartList = this.machinePartService.listByIds(purLineIds);
            purLineMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            businessPurLineMap = this.businessMachinePartService
               .listByIds(machinePartList.stream().map(TechMachinePart::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
         }

         Map<Long, TechMachinePart> finalPurLineMap = purLineMap;
         Map<Long, BusinessMachinePart> finalBusinessPurLineMap = businessPurLineMap;
         shipmentInfoDTOList = productShips.stream()
            .map(
               e -> {
                  ShipmentInfoDTO info = BeanUtil.copy(e, ShipmentInfoDTO.class);
                  info.setProject(projectMap.get(e.getProjectId()));
                  info.setMonomer(finalMonomerMap.get(e.getMonomerId()));
                  info.setArea(finalAreaMap.get(e.getAreaId()));
                  if (e.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = finalAllArtifactMap.get(e.getProductId());
                     info.setMeasure("件");
                     if (!artifact.getBoolAllPartSendDirectly()) {
                        BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                        BigDecimal totalPrice = BigDecimal.ZERO;
                        if (businessArtifact.getUnitPrice() != null) {
                           totalPrice = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? e.getWeight()
                                 .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : artifact.getLength()
                                 .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }

                        BigDecimal mete = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                           ? e.getWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : artifact.getLength()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        info.setTotalMete(mete);
                        info.setNuclear(businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType()) ? "吨" : "米");
                        info.setUnitPrice(businessArtifact.getUnitPrice());
                        info.setTotalPrice(totalPrice);
                        info.setBoolAllPartSendDirectly(artifact.getBoolAllPartSendDirectly());
                        if (artifact.getBoolAllPartSendDirectly() && artifact.getBoolSendDirectly()) {
                           info.setBoolPurLineSendDirectly(true);
                        } else if (artifact.getBoolSendDirectly()) {
                           info.setBoolPurLineSendDirectly(false);
                        }
                     }
                  }

                  if (e.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = finalEnclosureMap.get(e.getProductId());
                     BusinessEnclosure businessEnclosure = finalBusinessEnclosureMap.get(enclosure.getBusinessId());
                     info.setMeasure("张");
                     info.setSpecification(
                        enclosure.getThickness() != null
                           ? enclosure.getThickness().setScale(4, RoundingMode.HALF_UP)
                              + "*"
                              + enclosure.getUnfoldedWidth().intValue()
                              + "*"
                              + enclosure.getLength().intValue()
                           : enclosure.getUnfoldedWidth().intValue() + "*" + enclosure.getLength().intValue()
                     );
                     info.setArea(finalEnclosurePlanMap.get(e.getAreaId()));
                     BigDecimal totalPrice = BigDecimal.ZERO;
                     if (businessEnclosure.getUnitPrice() != null) {
                        totalPrice = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? enclosure.getLength()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : enclosure.getSurfaceArea()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP);
                     }

                     BigDecimal mete = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                        ? enclosure.getLength()
                           .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                        : enclosure.getSurfaceArea()
                           .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP);
                     info.setTotalMete(mete);
                     info.setNuclear(businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType()) ? "米" : "平方米");
                     info.setUnitPrice(businessEnclosure.getUnitPrice());
                     info.setTotalPrice(totalPrice);
                  }

                  if (e.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = finalStandardPartMap.get(e.getProductId());
                     BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                     info.setTotalMete(
                        standardPart.getMete()
                           .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                           .divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP)
                     );
                     info.setMeasure(standardPart.getMeasureUnit());
                     info.setNuclear(standardPart.getAccountingUnit());
                     info.setUnitPrice(businessStandardPart.getUnitPrice());
                     info.setTotalPrice(
                        businessStandardPart.getUnitPrice() != null ? businessStandardPart.getUnitPrice().multiply(info.getTotalMete()) : BigDecimal.ZERO
                     );
                  }

                  if (e.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = finalAssembleMap.get(e.getProductId());
                     BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                     BigDecimal totalPrice = BigDecimal.ZERO;
                     if (businessAssemble != null && businessAssemble.getUnitPrice() != null) {
                        totalPrice = businessAssemble.getPricingManner().equals(PricingMannerEnum.LENGTH.getType())
                           ? assemble.getLength()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .multiply(businessAssemble.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : assemble.getNetWeight()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .multiply(businessAssemble.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                     }

                     BigDecimal mete = businessAssemble.getPricingManner().equals(PricingMannerEnum.LENGTH.getType())
                        ? assemble.getLength()
                           .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                        : assemble.getNetWeight()
                           .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                     info.setTotalMete(mete);
                     info.setMeasure("件");
                     info.setNuclear(businessAssemble.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType()) ? "吨" : "米");
                     info.setUnitPrice(businessAssemble.getUnitPrice());
                     info.setTotalPrice(totalPrice);
                     info.setBoolAllPartSendDirectly(assemble.getBoolAllPartSendDirectly());
                     if (assemble.getBoolAllPartSendDirectly() && assemble.getBoolSendDirectly()) {
                        info.setBoolPurLineSendDirectly(true);
                     } else if (assemble.getBoolSendDirectly()) {
                        info.setBoolPurLineSendDirectly(false);
                     }
                  }

                  if (e.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart machinePart = finalPurLineMap.get(e.getProductId());
                     BusinessMachinePart businessmachinePart = finalBusinessPurLineMap.get(machinePart.getBusinessId());
                     BigDecimal totalPrice = BigDecimal.ZERO;
                     BigDecimal mete = BigDecimal.ZERO;
                     if (businessmachinePart != null) {
                        if (businessmachinePart.getUnitPrice() != null) {
                           totalPrice = businessmachinePart.getPricingManner().equals(PricingMannerEnum.LENGTH.getType())
                              ? machinePart.getLength()
                                 .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                                 .multiply(businessmachinePart.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : machinePart.getNetWeight()
                                 .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                                 .multiply(businessmachinePart.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }

                        mete = businessmachinePart.getPricingManner().equals(PricingMannerEnum.LENGTH.getType())
                           ? machinePart.getLength()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : machinePart.getNetWeight()
                              .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        info.setMeasure("件");
                        info.setNuclear(businessmachinePart.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType()) ? "吨" : "米");
                        info.setUnitPrice(businessmachinePart.getUnitPrice());
                     }

                     info.setTotalMete(mete);
                     info.setTotalPrice(totalPrice);
                     info.setBoolAllPartSendDirectly(machinePart.getBoolAllPartSendDirectly());
                     if (machinePart.getBoolAllPartSendDirectly() && machinePart.getBoolSendDirectly()) {
                        info.setBoolPurLineSendDirectly(true);
                     } else if (machinePart.getBoolSendDirectly()) {
                        info.setBoolPurLineSendDirectly(false);
                     }
                  }

                  return info;
               }
            )
            .collect(Collectors.toList());
      }

      return shipmentInfoDTOList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printTracking(
      Long projectId, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.projectService.getById(projectId);
      header.put("amount", project.getHappenedAmount());
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      List<CargoListProductLinkDTO> productShips = this.cargoListProductLinkService
         .listShipProductRecord(Collections.singletonList(projectId), monomerId, productType, name, serialNumber, auditStartDate, auditEndDate);
      List<Map<String, Object>> mapList = this.getShipList(productShips).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      printVO.setHeader(header);
      return printVO;
   }

   @Override
   public PageVO<ShipmentRecordDTO> listShipByProjectId(Long projectId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<CargoListProductLinkDTO> productShips = this.cargoListProductLinkService
         .listShipProductRecord(Collections.singletonList(projectId), null, null, null, null, null, null);
      List<ShipmentInfoDTO> shipmentInfoDTOList = this.getShipList(productShips);
      List<ShipmentRecordDTO> shipmentRecordDTOList = shipmentInfoDTOList.stream()
         .map(s -> BeanUtil.copy(s, ShipmentRecordDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(shipmentRecordDTOList, productShips));
   }

   @Override
   public ListVO<TechArtifact> listArtifactByBusinessId(Long businessId) {
      return new ListVO<>(this.artifactService.listByBusinessId(businessId));
   }

   @Override
   public void downloadArtifactByBusinessId(Long businessId, HttpServletResponse response) {
      BusinessArtifact businessArtifact = this.businessArtifactService.getById(businessId);
      Preconditions.checkArgument(businessArtifact != null, "数据不存在!");
      ContractProject project = this.projectService.getById(businessArtifact.getProjectId());
      PlanMonomer monomer = this.monomerService.getById(businessArtifact.getMonomerId());
      Map<Long, String> areaMap = this.areaService
         .listAreaByMonomerId(businessArtifact.getMonomerId())
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, PlanArea::getName));
      List<ArtifactDetailsExportDTO> dataList = this.artifactService
         .listByBusinessId(businessId)
         .stream()
         .map(
            artifact -> {
               ArtifactDetailsExportDTO exportDTO = BeanUtil.copy(artifact, ArtifactDetailsExportDTO.class);
               exportDTO.setProject(project.getShortName());
               exportDTO.setMonomer(monomer.getName());
               exportDTO.setArea(areaMap.get(artifact.getAreaId()));
               exportDTO.setLength(artifact.getLength().setScale(0, RoundingMode.HALF_UP));
               exportDTO.setNetWeight(artifact.getNetWeight().setScale(2, RoundingMode.HALF_UP));
               exportDTO.setTotalNetWeight(artifact.getTotalNetWeight().setScale(2, RoundingMode.HALF_UP));
               BigDecimal totalLength = artifact.getLength().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue()));
               exportDTO.setTotalLength(totalLength.divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
               exportDTO.setPricingManner(businessArtifact.getPricingManner());
               exportDTO.setUnitPrice(businessArtifact.getUnitPrice() != null ? businessArtifact.getUnitPrice().setScale(2, RoundingMode.HALF_UP) : null);
               if (businessArtifact.getUnitPrice() != null) {
                  BigDecimal totalPrice = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                     ? artifact.getTotalNetWeight().multiply(businessArtifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                     : totalLength.multiply(businessArtifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                  exportDTO.setTotalPrice(totalPrice);
               }

               return exportDTO;
            }
         )
         .collect(Collectors.toList());
      ExportParams exportParams = new ExportParams();
      exportParams.setType(ExcelType.XSSF);
      exportParams.setFixedTitle(false);
      exportParams.setTitle(businessArtifact.getName());
      exportParams.setTitleHeight((short)15);
      String fileName = dataList.get(0).getName();
      Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ArtifactDetailsExportDTO.class, dataList);
      PoiUtils.unBuilderDownLoadExcel(fileName + "详情.xlsx", response, workbook);
   }

   @Override
   public ListVO<TechEnclosure> listEnclosureByBusinessId(Long businessId) {
      return new ListVO<>(this.enclosureService.listByBusinessId(businessId));
   }

   @Override
   public BigDecimal getWarehouseAmount(Long projectId) {
      BigDecimal warehouseAmount = BigDecimal.ZERO;
      if (projectId != null) {
         warehouseAmount = this.getProjectWarehouseAmountMap(Collections.singletonList(projectId)).getOrDefault(projectId, BigDecimal.ZERO);
      }

      return warehouseAmount;
   }

   @Override
   public BusinessShipCargoDTO shipCargoSummary(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      String name,
      Integer projectStatus
   ) {
      AtomicReference<BigDecimal> shipAmount = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipMet = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipLength = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipArea = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipAmountTime = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipMetTime = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipLengthTime = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<BigDecimal> shipAreaTime = new AtomicReference<>(BigDecimal.ZERO);
      int count = 0;
      int countTime = 0;
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoList.class)
               .eq(projectId != null, MesBuildingCargoList::getProjectId, projectId)
               .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
               .in(MesBuildingCargoList::getShipmentStatus, ShipmentStatusEnum.DELIVERY.getType(), ShipmentStatusEnum.SIGN_IN.getType())
               .apply("product_type & {0} > 0", productType)
         );
      if (CollectionUtils.isNotEmpty(cargoListList)) {
         List<MesBuildingCargoListProductLink> listProductLinks = this.cargoListProductLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
                  .in(
                     MesBuildingCargoListProductLink::getWarehouseType,
                     WarehouseTypeProductReturnEnum.NORMAL.getType(),
                     WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                  )
                  .in(MesBuildingCargoListProductLink::getCargoListId, cargoListList.stream().map(MesBuildingCargoList::getId).collect(Collectors.toList()))
                  .apply("product_type & {0} > 0", productType)
            );
         List<MesBuildingCargoList> timeCargoListList = cargoListList.stream()
            .filter(c -> startDate == null || !startDate.toLocalDate().isAfter(c.getAuditTime().toLocalDate()))
            .filter(c -> endDate == null || !endDate.toLocalDate().isBefore(c.getAuditTime().toLocalDate()))
            .collect(Collectors.toList());
         count = cargoListList.size();
         countTime = timeCargoListList.size();
         List<Long> timeCargoListIds = timeCargoListList.stream().map(MesBuildingCargoList::getId).collect(Collectors.toList());
         List<MesBuildingCargoListProductLink> timeListProductLinks = listProductLinks.stream()
            .filter(s -> timeCargoListIds.contains(s.getCargoListId()))
            .collect(Collectors.toList());
         List<Long> timeCargoLinkIds = timeListProductLinks.stream().map(MesBuildingCargoListProductLink::getId).collect(Collectors.toList());
         List<CargoListProductLinkPriceDTO> cargoLinkPriceList = this.businessPriceUtils.getCargoLinkPrice(listProductLinks);
         List<CargoListProductLinkPriceDTO> timeCargoLinkPriceList = cargoLinkPriceList.stream()
            .filter(c -> timeCargoLinkIds.contains(c.getId()))
            .collect(Collectors.toList());
         shipAmount.set(
            cargoLinkPriceList.stream().map(CargoListProductLinkPriceDTO::getTotalPrice).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         shipAmountTime.set(
            timeCargoLinkPriceList.stream().map(CargoListProductLinkPriceDTO::getTotalPrice).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         if (productType.equals(ProductTypeEnum.ARTIFACT.getType()) || productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            shipMet.set(listProductLinks.stream().map(s -> s.getWeight().multiply(s.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add));
            shipMetTime.set(timeListProductLinks.stream().map(s -> s.getWeight().multiply(s.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add));
         }

         if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            shipLength.set(listProductLinks.stream().map(s -> s.getLength().multiply(s.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add));
            shipArea.set(listProductLinks.stream().map(s -> s.getSurfaceArea().multiply(s.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add));
            shipLengthTime.set(timeListProductLinks.stream().map(s -> s.getLength().multiply(s.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add));
            shipAreaTime.set(timeListProductLinks.stream().map(s -> s.getSurfaceArea().multiply(s.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add));
         }

         if ((productType & 17) > 0) {
            Map<Integer, Set<Long>> productLinksMap = listProductLinks.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingCargoListProductLink::getProductType, Collectors.mapping(MesBuildingCargoListProductLink::getProductId, Collectors.toSet())
                  )
               );
            Map<Integer, Map<Long, BigDecimal>> productTypeProductIdWeightMap = new HashMap<>(listProductLinks.size());
            productLinksMap.forEach(
               (type, productIds) -> {
                  if (type.equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     productTypeProductIdWeightMap.put(
                        type,
                        this.machinePartService
                           .listByIds(productIds)
                           .stream()
                           .collect(Collectors.toMap(TechMachinePart::getId, TechMachinePart::getGrossWeight))
                     );
                  }

                  if (type.equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     productTypeProductIdWeightMap.put(
                        type, this.assembleService.listByIds(productIds).stream().collect(Collectors.toMap(TechAssemble::getId, TechAssemble::getGrossWeight))
                     );
                  }
               }
            );
            BigDecimal mete = listProductLinks.stream()
               .map(
                  s -> productTypeProductIdWeightMap.getOrDefault(s.getProductType(), Collections.emptyMap())
                     .getOrDefault(s.getProductId(), BigDecimal.ZERO)
                     .multiply(s.getQuantity())
               )
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal meteTime = timeListProductLinks.stream()
               .map(
                  s -> productTypeProductIdWeightMap.getOrDefault(s.getProductType(), Collections.emptyMap())
                     .getOrDefault(s.getProductId(), BigDecimal.ZERO)
                     .multiply(s.getQuantity())
               )
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            shipMet.set(mete);
            shipMetTime.set(meteTime);
         }
      }

      return BusinessShipCargoDTO.builder()
         .shipAmount(shipAmount.get())
         .shipMet(shipMet.get().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : shipMet.get().divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP))
         .shipAmountTime(shipAmountTime.get())
         .shipMetTime(
            shipMetTime.get().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : shipMetTime.get().divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
         )
         .shipArea(shipArea.get().setScale(3, RoundingMode.HALF_UP))
         .shipAreaTime(shipAreaTime.get().setScale(3, RoundingMode.HALF_UP))
         .shipLength(shipLength.get().divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP))
         .shipLengthTime(shipLengthTime.get().divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP))
         .cargoQuantity(count)
         .cargoQuantityTime(countTime)
         .shipMetAvg(
            shipMet.get().compareTo(BigDecimal.ZERO) == 0
               ? BigDecimal.ZERO
               : shipMetTime.get().divide(BigDecimal.valueOf(count).multiply(new BigDecimal(1000)), 3, RoundingMode.HALF_UP)
         )
         .startDate(startDate)
         .endDate(endDate)
         .build();
   }

   @Override
   public List<ArtifactBasicsDTO> shipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      String name
   ) {
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         List<ArtifactBasicsDO> doList = this.cargoListProductLinkService
            .artifactCargoShipDetail(
               projectId, monomerId, areaId, handleMethod, specification, material, serialNumber, monomerName, areaName, startDate, endDate, name
            );
         if (CollectionUtils.isEmpty(doList)) {
            return new ArrayList<>();
         }

         List<CargoListProductLinkPriceDTO> cargoLinkPriceList = this.businessPriceUtils
            .getCargoLinkPriceByLinkIds(doList.stream().map(ArtifactShipMeteDO::getLinkId).collect(Collectors.toList()));
         Map<Long, List<CargoListProductLinkPriceDTO>> linkIdListMap = cargoLinkPriceList.stream()
            .filter(c -> c.getTotalPrice() != null)
            .collect(Collectors.groupingBy(CargoListProductLinkPriceDTO::getId));
         doList.forEach(
            e -> {
               if (null != e.getWarehouseType() && e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                  e.setTotalPrice(BigDecimal.ZERO);
               } else {
                  List<CargoListProductLinkPriceDTO> priceDTOList = linkIdListMap.getOrDefault(e.getLinkId(), Collections.emptyList());
                  e.setWeight(
                     !priceDTOList.isEmpty()
                           && priceDTOList.get(0).getPricingMannerEnum().equals(PricingMannerEnum.WEIGHT.getType())
                           && priceDTOList.get(0).getPricingWeightTypeEnum().equals(PricingWeightTypeEnum.NET_WEIGHT.getType())
                        ? e.getTotalNetWeight()
                        : e.getTotalGrossWeight()
                  );
                  e.setUnitPrice(priceDTOList.isEmpty() ? BigDecimal.ZERO : priceDTOList.get(0).getUnitPrice());
                  e.setTotalPrice(priceDTOList.stream().map(CargoListProductLinkPriceDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
               }
            }
         );
         return doList.stream().map(e -> BeanUtil.copy(e, ArtifactBasicsDTO.class)).collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<ArtifactBasicsDTO> pageShipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   ) {
      PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort));
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort)),
         this.shipCargoDetail(
            productType, projectId, monomerId, areaId, handleMethod, monomerName, areaName, startDate, endDate, specification, material, serialNumber, name
         )
      );
   }

   @Override
   public List<TechStandardPartShipDTO> shipStandardPartCargoDetail(
      Integer productType, Long projectId, Long monomerId, Long areaId, LocalDateTime startDate, LocalDateTime endDate, String specification, String name
   ) {
      if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(productType)) {
         List<TechStandardPartShipDO> shipDOSByTime = this.cargoListProductLinkService
            .listStandardPartCargoShipDetail(projectId, monomerId, areaId, specification, name, startDate, endDate);
         if (CollectionUtils.isEmpty(shipDOSByTime)) {
            return new ArrayList<>();
         }

         List<CargoListProductLinkPriceDTO> cargoLinkPriceList = this.businessPriceUtils
            .getCargoLinkPriceByLinkIds(shipDOSByTime.stream().map(TechStandardPartBaseInfo::getLinkId).collect(Collectors.toList()));
         Map<Long, List<CargoListProductLinkPriceDTO>> linkIdListMap = cargoLinkPriceList.stream()
            .filter(c -> c.getTotalPrice() != null)
            .collect(Collectors.groupingBy(CargoListProductLinkPriceDTO::getId));
         shipDOSByTime.forEach(e -> {
            if (null != e.getWarehouseType() && e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
               e.setTotalPrice(BigDecimal.ZERO);
            } else {
               List<CargoListProductLinkPriceDTO> priceDTOList = linkIdListMap.getOrDefault(e.getLinkId(), Collections.emptyList());
               e.setUnitPrice(priceDTOList.isEmpty() ? BigDecimal.ZERO : priceDTOList.get(0).getUnitPrice());
               e.setTotalPrice(priceDTOList.stream().map(CargoListProductLinkPriceDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
         });
         return shipDOSByTime.stream().map(e -> BeanUtil.copy(e, TechStandardPartShipDTO.class)).collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<TechStandardPartShipDTO> pageShipStandardPartCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   ) {
      PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort));
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort)),
         this.shipStandardPartCargoDetail(productType, projectId, monomerId, areaId, startDate, endDate, specification, name)
      );
   }

   @Override
   public List<EnclosureBasicsDTO> shipCargoEnclosureDetail(
      Integer productType,
      Long projectId,
      Long enclosurePlanId,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String plate,
      String serialNumber,
      String name
   ) {
      if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         List<EnclosureShipDO> enclosureShipDOS = this.cargoListProductLinkService
            .enclosureCargoShipDetail(projectId, enclosurePlanId, plate, serialNumber, planName, startDate, endDate, name);
         if (CollectionUtils.isEmpty(enclosureShipDOS)) {
            return new ArrayList<>();
         }

         List<CargoListProductLinkPriceDTO> cargoLinkPriceList = this.businessPriceUtils
            .getCargoLinkPriceByLinkIds(enclosureShipDOS.stream().map(EnclosureBaseInfo::getLinkId).collect(Collectors.toList()));
         Map<Long, List<CargoListProductLinkPriceDTO>> linkIdListMap = cargoLinkPriceList.stream()
            .filter(c -> c.getTotalPrice() != null)
            .collect(Collectors.groupingBy(CargoListProductLinkPriceDTO::getId));
         enclosureShipDOS.forEach(e -> {
            e.setTotalLength(e.getTotalLength() == null ? BigDecimal.ZERO : e.getTotalLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
            e.setTotalArea(e.getTotalArea() == null ? BigDecimal.ZERO : e.getTotalArea().divide(BigDecimal.valueOf(1000000L), 3, RoundingMode.HALF_UP));
            if (null != e.getWarehouseType() && e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
               e.setTotalPrice(BigDecimal.ZERO);
            } else {
               List<CargoListProductLinkPriceDTO> priceDTOList = linkIdListMap.getOrDefault(e.getLinkId(), Collections.emptyList());
               e.setUnitPrice(priceDTOList.isEmpty() ? BigDecimal.ZERO : priceDTOList.get(0).getUnitPrice());
               e.setTotalPrice(priceDTOList.stream().map(CargoListProductLinkPriceDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
         });
         return enclosureShipDOS.stream().map(e -> BeanUtil.copy(e, EnclosureBasicsDTO.class)).collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<EnclosureBasicsDTO> pageShipCargoEnclosureDetail(
      Integer productType,
      Long projectId,
      Long enclosurePlanId,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String plate,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   ) {
      PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort));
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort)),
         this.shipCargoEnclosureDetail(productType, projectId, enclosurePlanId, planName, startDate, endDate, plate, serialNumber, name)
      );
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printShipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long enclosurePlanId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String plate,
      String material,
      String serialNumber,
      String name
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      header.put("date", df.format(startDate) + "~" + df.format(endDate));
      if (projectId != null) {
         ProjectInfo project = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(project != null, "项目不存在!");
         header.put("project", project);
      }

      header.put("productType", ProductTypeEnum.getNameByType(productType));
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = new ArrayList<>();
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         List<ArtifactBasicsDTO> artifactBasicsDTOS = this.shipCargoDetail(
            productType, projectId, monomerId, areaId, handleMethod, monomerName, areaName, startDate, endDate, specification, material, serialNumber, name
         );
         mapList = artifactBasicsDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(productType)) {
         List<TechStandardPartShipDTO> techStandardPartShipDTOS = this.shipStandardPartCargoDetail(
            productType, projectId, monomerId, areaId, startDate, endDate, specification, name
         );
         mapList = techStandardPartShipDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         List<EnclosureBasicsDTO> enclosureBasicsDTOS = this.shipCargoEnclosureDetail(
            productType, projectId, enclosurePlanId, planName, startDate, endDate, plate, serialNumber, name
         );
         mapList = enclosureBasicsDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      int i = ProductTypeEnum.MACHINE_PART.getType() | ProductTypeEnum.ASSEMBLE.getType();
      if (i == productType) {
         List<TechMachinePartShipDTO> partShipDTOS = this.partCargoDetail(
            productType, projectId, monomerId, areaId, monomerName, areaName, startDate, endDate, specification, material, serialNumber, name
         );
         mapList = partShipDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      }

      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void downloadShipCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long enclosurePlanId,
      Integer handleMethod,
      String monomerName,
      String areaName,
      String planName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String plate,
      String material,
      String serialNumber,
      String name,
      HttpServletResponse response
   ) {
      try {
         Map<String, Object> exportMap = new HashMap<>();
         String currentName = UserUtil.getCurrentName();
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String startTime = df.format(startDate);
         String endTime = df.format(endDate);
         String printTime = df.format(LocalDateTime.now());
         exportMap.put("currentName", currentName);
         exportMap.put("startTime", startTime);
         exportMap.put("endTime", endTime);
         exportMap.put("printTime", printTime);
         List<ArtifactBasicsCountDTO> basicsCountDTOList = new ArrayList<>();
         if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            List<ArtifactBasicsDTO> artifactBasicsDTOS = this.shipCargoDetail(
               productType, projectId, monomerId, areaId, handleMethod, monomerName, areaName, startDate, endDate, specification, material, serialNumber, name
            );
            if (CollectionUtils.isNotEmpty(artifactBasicsDTOS)) {
               AtomicInteger detailOrderNumber = new AtomicInteger(1);
               artifactBasicsDTOS.forEach(e -> {
                  e.setOrderNumber(detailOrderNumber.getAndIncrement());
                  e.setUnitPrice(e.getUnitPrice().setScale(3));
                  e.setShipTime(df.format(e.getCreateTime()));
                  e.setWeight(e.getWeight().setScale(3));
                  e.setProjectName(e.getProject().getSerialNumber() + e.getProject().getShortName());
               });
               Map<String, List<ArtifactBasicsDTO>> summarizingList = artifactBasicsDTOS.stream()
                  .collect(
                     Collectors.groupingBy(e -> e.getProject().getId() + e.getName() + e.getMaterial() + e.getUnitPrice().stripTrailingZeros().toPlainString())
                  );
               AtomicInteger countOrderNumber = new AtomicInteger(1);
               summarizingList.forEach(
                  (summarizing, list) -> {
                     ArtifactBasicsDTO artifactBasicsDTO = list.get(0);
                     BigDecimal totalWeight = list.stream()
                        .map(ArtifactBasicsDTO::getWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP);
                     BigDecimal totalPrice = list.stream().map(ArtifactBasicsDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                     ArtifactBasicsCountDTO basicsCountDTO = ArtifactBasicsCountDTO.builder()
                        .projectName(artifactBasicsDTO.getProject().getSerialNumber() + artifactBasicsDTO.getProject().getShortName())
                        .name(artifactBasicsDTO.getName())
                        .material(artifactBasicsDTO.getMaterial())
                        .totalWeight(totalWeight)
                        .totalPrice(totalPrice)
                        .unitPrice(artifactBasicsDTO.getUnitPrice().setScale(3))
                        .unit("t")
                        .orderNumber(countOrderNumber.getAndIncrement())
                        .build();
                     basicsCountDTOList.add(basicsCountDTO);
                  }
               );
               exportMap.put("countList", basicsCountDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
               exportMap.put(
                  "countTotalWeight", basicsCountDTOList.stream().map(ArtifactBasicsCountDTO::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
               );
               exportMap.put("countTotalPrice", basicsCountDTOList.stream().map(ArtifactBasicsCountDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
               exportMap.put("detailList", artifactBasicsDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
               exportMap.put("detailTotalWeight", artifactBasicsDTOS.stream().map(ArtifactBasicsDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
               exportMap.put("detailTotalPrice", artifactBasicsDTOS.stream().map(ArtifactBasicsDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
               exportMap.put("detailTotalQuantity", artifactBasicsDTOS.stream().mapToInt(ArtifactBasicsDTO::getTotalQuantity).sum());
               String tempFileName = "StructureShipmentTracking";
               String resourcePath = "files/StructureShipmentTracking.xlsx";
               String exportFileName = "结构发运跟踪.xlsx";
               org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
               InputStream inputStream = resource.getInputStream();
               File file = File.createTempFile(tempFileName, "xlsx");
               FileUtil.copyInputStreamToFile(inputStream, file);
               TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
               params.setColForEach(true);
               Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
               PoiUtils.downLoadExcel(exportFileName, response, workbook, Arrays.asList(0, 1));
            }
         }
      } catch (Throwable $ex) {
         throw BusinessBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public PageVO<TechMachinePartShipDTO> pageShipDirectCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String name
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort)),
         this.partCargoDetail(productType, projectId, monomerId, areaId, monomerName, areaName, startDate, endDate, specification, material, serialNumber, name)
      );
   }

   public List<TechMachinePartShipDTO> partCargoDetail(
      Integer productType,
      Long projectId,
      Long monomerId,
      Long areaId,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String specification,
      String material,
      String serialNumber,
      String name
   ) {
      List<TechMachinePartShipDTO> partPurLineSendList = this.cargoListProductLinkService
         .partPurLineSendCargoShipDetail(projectId, monomerId, areaId, specification, material, serialNumber, monomerName, areaName, startDate, endDate);
      partPurLineSendList.forEach(e -> {
         if (null != e.getWarehouseType() && e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
            e.setTotalPrice(BigDecimal.ZERO);
         }
      });
      return partPurLineSendList;
   }

   @Override
   public Map<Long, BigDecimal> getProjectAllProduceAmountMap(List<Long> projectIds, LocalDateTime secondStartDate, LocalDateTime secondEndDate) {
      Map<Long, BigDecimal> projectShipAmountMap = new HashMap<>(32);
      List<CargoListProductLinkDTO> productLinkDTOList = this.cargoListProductLinkService
         .listShipProductRecord(projectIds, null, null, null, null, secondStartDate, secondEndDate);
      List<Long> artifactIds = new ArrayList<>(1024);
      List<Long> enclosureIds = new ArrayList<>(256);
      List<Long> standardIds = new ArrayList<>(128);
      List<Long> purLineIds = new ArrayList<>(128);
      List<Long> assembleIds = new ArrayList<>(128);
      productLinkDTOList.forEach(link -> {
         if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            artifactIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            enclosureIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            purLineIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            assembleIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            standardIds.add(link.getProductId());
         }
      });
      Map<Long, TechArtifact> allArtifactMap = Collections.emptyMap();
      Map<Long, BusinessArtifact> businessArtifactMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         List<TechArtifact> allArtifactList = this.artifactService.listByIds(artifactIds);
         allArtifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechArtifact> artifactList = allArtifactList.stream().filter(a -> !a.getBoolAllPartSendDirectly()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artifactList)) {
            businessArtifactMap = this.businessArtifactService
               .listByIds(artifactList.stream().map(TechArtifact::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
         }
      }

      Map<Long, TechArtifact> finalAllArtifactMap = allArtifactMap;
      Map<Long, BusinessArtifact> finalBusinessArtifactMap = businessArtifactMap;
      Map<Long, TechEnclosure> enclosureMap = Collections.emptyMap();
      Map<Long, BusinessEnclosure> businessEnclosureMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(enclosureIds)) {
         List<TechEnclosure> enclosureList = this.enclosureService.listByIds(enclosureIds);
         enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
            .listByIds(enclosureList.stream().map(TechEnclosure::getBusinessId).collect(Collectors.toSet()));
         businessEnclosureMap = businessEnclosureList.stream().collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
      }

      Map<Long, TechEnclosure> finalEnclosureMap = enclosureMap;
      Map<Long, BusinessEnclosure> finalBusinessEnclosureMap = businessEnclosureMap;
      Map<Long, TechStandardPart> standardPartMap = Collections.emptyMap();
      Map<Long, BusinessStandardPart> businessStandardPartMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(standardIds)) {
         List<TechStandardPart> standardPartList = this.standardPartService.listByIds(standardIds);
         standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
            .listByIds(standardPartList.stream().map(TechStandardPart::getBusinessId).collect(Collectors.toSet()));
         businessStandardPartMap = businessStandardPartList.stream().collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
      }

      Map<Long, TechStandardPart> finalStandardPartMap = standardPartMap;
      Map<Long, BusinessStandardPart> finalBusinessStandardPartMap = businessStandardPartMap;
      Map<Long, TechMachinePart> purLineMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businesspurLineMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(purLineIds)) {
         List<TechMachinePart> machinePartList = this.machinePartService.listByIds(purLineIds);
         purLineMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         List<BusinessMachinePart> businessMachinePartList = this.businessMachinePartService
            .listByIds(machinePartList.stream().map(TechMachinePart::getBusinessId).collect(Collectors.toSet()));
         businesspurLineMap = businessMachinePartList.stream().collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
      }

      Map<Long, TechMachinePart> finalPurLineMap = purLineMap;
      Map<Long, BusinessMachinePart> finalBusinessPurLineMap = businesspurLineMap;
      Map<Long, TechAssemble> assembleMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
         assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         businessAssembleMap = this.businessMachinePartService
            .listByIds(assembleList.stream().map(TechAssemble::getBusinessId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
      }

      Map<Long, TechAssemble> finalAssembleMap = assembleMap;
      Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
      Map<Long, List<CargoListProductLinkDTO>> projectProductLinkMap = productLinkDTOList.stream()
         .collect(Collectors.groupingBy(CargoListProductLinkDTO::getProjectId));
      projectProductLinkMap.forEach(
         (projectId, list) -> {
            List<BigDecimal> productAmountList = new ArrayList<>(128);
            list.forEach(
               product -> {
                  BigDecimal productAmount = BigDecimal.ZERO;
                  if (product.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = finalAllArtifactMap.get(product.getProductId());
                     if (!artifact.getBoolAllPartSendDirectly()) {
                        BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                        if (businessArtifact.getUnitPrice() != null) {
                           productAmount = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? product.getWeight()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : artifact.getLength()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = finalEnclosureMap.get(product.getProductId());
                     BusinessEnclosure businessEnclosure = finalBusinessEnclosureMap.get(enclosure.getBusinessId());
                     if (businessEnclosure.getUnitPrice() != null) {
                        productAmount = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? enclosure.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : enclosure.getSurfaceArea()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000000L));
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = finalStandardPartMap.get(product.getProductId());
                     BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                     if (businessStandardPart.getUnitPrice() != null) {
                        productAmount = standardPart.getMete()
                           .multiply(businessStandardPart.getUnitPrice())
                           .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                           .divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP);
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = finalAssembleMap.get(product.getProductId());
                     BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                     if (businessAssemble != null && businessAssemble.getUnitPrice() != null) {
                        productAmount = businessAssemble.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? businessAssemble.getUnitPrice()
                              .multiply(assemble.getLength())
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                           : businessAssemble.getUnitPrice()
                              .multiply(assemble.getNetWeight())
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart machinePart = finalPurLineMap.get(product.getProductId());
                     BusinessMachinePart businessPurLine = finalBusinessPurLineMap.get(machinePart.getBusinessId());
                     if (businessPurLine != null && businessPurLine.getUnitPrice() != null) {
                        productAmount = businessPurLine.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? machinePart.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPurLine.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : machinePart.getNetWeight()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPurLine.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L));
                     }
                  }

                  productAmountList.add(productAmount);
               }
            );
            BigDecimal projectShipAmount = productAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            projectShipAmountMap.put(projectId, projectShipAmount);
         }
      );
      return projectShipAmountMap;
   }

   @Override
   public List<BusinessReturnProductDTO> listReturnProduct(Long linkId) {
      MesBuildingCargoListProductLink link = this.cargoListProductLinkService.getById(linkId);
      Preconditions.checkArgument(link != null, "发运记录不存在!");
      MesBuildingCargoList cargoList = this.cargoListService.getById(link.getCargoListId());
      Preconditions.checkArgument(cargoList != null, "发运记录不存在!");
      List<ProjectReturnProductChild> returnChildList = this.returnProductChildService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductChild.class)
               .eq(ProjectReturnProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(ProjectReturnProductChild::getStatus, ReturnProductStatusEnum.SHIPPED.getType())
               .eq(ProjectReturnProductChild::getCargoLinkId, linkId)
               .orderByDesc(ProjectReturnProductChild::getId)
         );
      if (returnChildList.isEmpty()) {
         return Collections.emptyList();
      }

      List<BusinessReturnProductDTO> returnProductList = new ArrayList<>(returnChildList.size());
      ProjectInfo projectInfo = this.projectService.getSimpleById(cargoList.getProjectId());
      if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(link.getProductId());
         PlanMonomer monomer = this.monomerService.getById(artifact.getMonomerId());
         PlanArea area = this.areaService.getById(artifact.getAreaId());
         returnChildList.forEach(returnChild -> {
            BusinessReturnProductDTO dto = BeanUtil.copy(returnChild, BusinessReturnProductDTO.class);
            dto.setProject(projectInfo);
            dto.setMonomerName(monomer.getName());
            dto.setAreaName(area.getName());
            dto.setProductName(artifact.getName());
            dto.setSerialNumber(artifact.getSerialNumber());
            dto.setSpecification(artifact.getSpecification());
            dto.setMaterial(artifact.getMaterial());
            dto.setNetWeight(artifact.getNetWeight().divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            dto.setTotalNetWeight(artifact.getNetWeight().multiply(returnChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 6, RoundingMode.HALF_UP));
            dto.setLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
            dto.setTotalLength(artifact.getLength().multiply(returnChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
            returnProductList.add(dto);
         });
      }

      if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(link.getProductId());
         EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(enclosure.getEnclosurePlanId());
         returnChildList.forEach(returnChild -> {
            BusinessReturnProductDTO dto = BeanUtil.copy(returnChild, BusinessReturnProductDTO.class);
            dto.setProject(projectInfo);
            dto.setAreaName(enclosurePlan.getName());
            dto.setPlanName(enclosurePlan.getName());
            dto.setProductName(enclosure.getName());
            dto.setSerialNumber(enclosure.getSerialNumber());
            dto.setSpecification(enclosure.getPlate());
            dto.setMaterial(enclosure.getMaterial());
            dto.setLength(enclosure.getLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
            dto.setTotalLength(enclosure.getLength().multiply(returnChild.getQuantity()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
            dto.setSurfaceArea(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
            dto.setTotalArea(enclosure.getSurfaceArea().multiply(returnChild.getQuantity()).divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
            returnProductList.add(dto);
         });
      }

      if (link.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         TechStandardPart standardPart = this.standardPartService.getById(link.getProductId());
         PlanMonomer monomer = this.monomerService.getById(standardPart.getMonomerId());
         PlanArea area = this.areaService.getById(standardPart.getAreaId());
         EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(standardPart.getEnclosurePlanId());
         returnChildList.forEach(returnChild -> {
            BusinessReturnProductDTO dto = BeanUtil.copy(returnChild, BusinessReturnProductDTO.class);
            dto.setProject(projectInfo);
            if (standardPart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               dto.setMonomerName(monomer != null ? monomer.getName() : null);
               dto.setAreaName(area != null ? area.getName() : null);
            }

            if (standardPart.getRelationType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               dto.setAreaName(enclosurePlan != null ? enclosurePlan.getName() : null);
               dto.setPlanName(enclosurePlan != null ? enclosurePlan.getName() : null);
            }

            dto.setProductName(standardPart.getName());
            dto.setSpecification(standardPart.getSpecification());
            dto.setMeasureUnit(standardPart.getMeasureUnit());
            dto.setAccountingUnit(standardPart.getAccountingUnit());
            returnProductList.add(dto);
         });
      }

      return returnProductList;
   }

   @Override
   public PrintVO<List<BusinessReturnProductDTO>> printListReturnProduct(Long linkId) {
      MesBuildingCargoListProductLink link = this.cargoListProductLinkService.getById(linkId);
      Preconditions.checkArgument(link != null, "发运记录不存在!");
      MesBuildingCargoList cargoList = this.cargoListService.getById(link.getCargoListId());
      Preconditions.checkArgument(cargoList != null, "发运记录不存在!");
      PrintVO<List<BusinessReturnProductDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", this.projectService.getSimpleById(cargoList.getProjectId()));
      printVO.setHeader(header);
      List<BusinessReturnProductDTO> dtoList = this.listReturnProduct(linkId);
      printVO.setTable(dtoList);
      return printVO;
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
