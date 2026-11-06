package com.hzchum.scim.mes.building.core.biz.impl.warehouse;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
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
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.ContractTechTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseInboundIssuedDepositedEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.DeliverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.MesBuildingWarehouseRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class WarehouseBizImpl implements WarehouseBiz {
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleService assembleService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private TechStandardPartService standardPartService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MesBuildingFactoryService mesBuildingFactoryService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private BusinessStandardPartService businessStandardPartService;
   @Resource
   private BusinessMachinePartService businessMachinePartService;
   @Resource
   private BusinessBiz businessBiz;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private MesAuxiliaryService mesAuxiliaryService;
   @Resource
   private SysDictionaryService dictionaryService;

   @Override
   public ProductWarehouseSummaryDTO sumMete(Long monomerId, Long factoryId, Integer productType) {
      ProductMeteDTO productMete = new ProductMeteDTO();
      if (!ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(productType)) {
         if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            productMete = this.artifactService.sumMeteByCondition(null, monomerId, null);
         } else if (ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
            productMete = this.enclosureService.sumMeteByProjectIdOrMonomerId(null, monomerId, null);
         }
      }

      ProductMeteDO taskMete = this.taskService.sumTaskMeteByCondition(monomerId, factoryId, productType);
      ProductMeteDO inMete = this.warehouseSummaryService.sumMeteByCondition(null, monomerId, factoryId, productType, WarehouseTypeEnum.INTO.getType());
      ProductMeteDO outMete = this.warehouseSummaryService.sumMeteByCondition(null, monomerId, factoryId, productType, WarehouseTypeEnum.OUT.getType());
      return ProductWarehouseSummaryDTO.builder()
         .quantity(productMete.getQuantity())
         .mete(productMete.getMete())
         .taskQuantity(taskMete.getQuantity())
         .taskMete(taskMete.getMete())
         .inboundQuantity(inMete.getQuantity())
         .inboundMete(inMete.getMete())
         .outboundQuantity(outMete.getQuantity())
         .outboundMete(outMete.getMete())
         .stockQuantity(inMete.getQuantity() - outMete.getQuantity())
         .stockMete(inMete.getMete().subtract(outMete.getMete()))
         .build();
   }

   @Override
   public void setStockQuantity(WarehouseSaveDTOParam param) {
      MesBuildingWarehouseSummary summary = this.warehouseSummaryService
         .getOne(
            (Wrapper<MesBuildingWarehouseSummary>)(((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                              .eq(MesBuildingWarehouseSummary::getFactoryId, param.getFactoryId()))
                           .eq(MesBuildingWarehouseSummary::getProductId, param.getProductId()))
                        .eq(MesBuildingWarehouseSummary::getProductType, param.getProductType()))
                     .eq(MesBuildingWarehouseSummary::getWorkshopId, param.getWorkshopId()))
                  .eq(MesBuildingWarehouseSummary::getType, param.getType()))
               .eq(MesBuildingWarehouseSummary::getWarehouseType, param.getWarehouseType())
         );
      if (summary == null) {
         summary = BeanUtil.copy(param, MesBuildingWarehouseSummary.class);
         if (summary.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService.getById(summary.getProductId());
            summary.setCategory(enclosure.getCategory());
         }

         summary.setPackageQuantity(BigDecimal.ZERO);
         summary.setCargoQuantity(BigDecimal.ZERO);
         this.warehouseSummaryService.save(summary);
      } else {
         summary.setQuantity(summary.getQuantity().add(param.getQuantity()));
         this.warehouseSummaryService.updateById(summary);
      }

      MesBuildingWarehouseRecord record = BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
      record.setCompleteId(param.getCompleteId());
      record.setQuantity(param.getQuantity());
      record.setUserId(UserUtil.getCurrentUserId());
      record.setUserName(UserUtil.getCurrentName());
      record.setNumber(param.getNumber());
      record.setStatus(
         record.getType().equals(WarehouseTypeEnum.INTO.getType()) ? WarehouseRecordStatusTypeEnum.INTO.getType() : WarehouseRecordStatusTypeEnum.OUT.getType()
      );
      if (record.getType().equals(WarehouseTypeEnum.OUT.getType()) && param.getNumber() != null) {
         this.warehouseRecordService
            .update(
               Wrappers.lambdaUpdate(MesBuildingWarehouseRecord.class)
                  .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.OUT.getType())
                  .eq(MesBuildingWarehouseRecord::getFactoryId, record.getFactoryId())
                  .eq(MesBuildingWarehouseRecord::getWorkshopId, record.getWorkshopId())
                  .eq(MesBuildingWarehouseRecord::getProductId, param.getProductId())
                  .eq(MesBuildingWarehouseRecord::getProductType, param.getProductType())
                  .eq(MesBuildingWarehouseRecord::getNumber, param.getNumber())
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseRecord::getWarehouseType, record.getWarehouseType())
            );
      }

      this.warehouseRecordService.save(record);
   }

   @Override
   public void setWmsWarehousing(WarehouseSaveDTOParam param) {
      TechStandardPart standardPart = this.standardPartService.getById(param.getId());
      Preconditions.checkArgument(standardPart != null, "配套件不存在");
      this.checkTechStandardPart(param.getId(), param.getMete());
      TechStandardPart splitPart = this.standardPartService
         .getOne(Wrappers.lambdaQuery(TechStandardPart.class).eq(TechStandardPart::getOriginalId, standardPart.getId()));
      BigDecimal setQuantity = standardPart.getQuantity().compareTo(param.getQuantity()) >= 0
         ? standardPart.getQuantity().subtract(param.getQuantity())
         : BigDecimal.ZERO;
      BigDecimal setMete = standardPart.getMete().compareTo(param.getMete()) >= 0 ? standardPart.getMete().subtract(param.getMete()) : BigDecimal.ZERO;
      standardPart.setQuantity(setQuantity);
      standardPart.setMete(setMete);
      this.standardPartService.updateById(standardPart);
      if (splitPart != null) {
         splitPart.setQuantity(splitPart.getQuantity().add(param.getQuantity()));
         splitPart.setMete(splitPart.getMete().add(param.getMete()));
      } else {
         splitPart = standardPart.clone();
         splitPart.setMete(param.getMete())
            .setAccountingUnit(param.getAccountingUnit())
            .setMeasureUnit(param.getMeasureUnit())
            .setUnitNet(param.getUnitNet())
            .setQuantity(param.getQuantity());
         splitPart.setOriginalId(standardPart.getId());
         splitPart.setId(null);
      }

      this.standardPartService.saveOrUpdate(splitPart);
      if (!standardPart.getUseProperty().equals(AuxiliaryUsePropertyEnum.FACTORY_USE.getType())) {
         MesBuildingWarehouseSummary summary = this.warehouseSummaryService
            .getOne(
               (Wrapper<MesBuildingWarehouseSummary>)((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                              .eq(MesBuildingWarehouseSummary::getAreaId, splitPart.getAreaId()))
                           .eq(MesBuildingWarehouseSummary::getProductId, splitPart.getId()))
                        .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.AUXILIARY_MATERIAL.getType()))
                     .eq(MesBuildingWarehouseSummary::getType, param.getType()))
                  .eq(MesBuildingWarehouseSummary::getMaterialInventoryId, param.getMaterialInventoryId())
            );
         if (summary == null) {
            summary = BeanUtil.copy(param, MesBuildingWarehouseSummary.class);
            summary.setOutboundDetailId(null);
            summary.setProjectId(splitPart.getProjectId());
            summary.setMonomerId(splitPart.getMonomerId());
            summary.setAreaId(splitPart.getAreaId());
            summary.setProductId(splitPart.getId());
            summary.setProductType(ProductTypeEnum.AUXILIARY_MATERIAL.getType());
            summary.setFactoryId(0L);
            summary.setWorkshopId(0L);
            summary.setType(WarehouseTypeEnum.INTO.getType());
            summary.setPackageQuantity(BigDecimal.ZERO);
            summary.setCargoQuantity(BigDecimal.ZERO);
            summary.setUserName(UserUtil.getCurrentName());
            this.warehouseSummaryService.save(summary);
         } else {
            summary.setQuantity(summary.getQuantity().add(param.getQuantity()));
            this.warehouseSummaryService.updateById(summary);
         }

         MesBuildingWarehouseRecord record = BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
         record.setCompleteId(param.getCompleteId());
         record.setQuantity(param.getQuantity());
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(param.getNumber());
         record.setStatus(
            record.getType().equals(WarehouseTypeEnum.INTO.getType())
               ? WarehouseRecordStatusTypeEnum.INTO.getType()
               : WarehouseRecordStatusTypeEnum.OUT.getType()
         );
         if (record.getType().equals(WarehouseTypeEnum.OUT.getType()) && param.getNumber() != null) {
            this.warehouseRecordService
               .update(
                  Wrappers.lambdaUpdate(MesBuildingWarehouseRecord.class)
                     .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.OUT.getType())
                     .eq(MesBuildingWarehouseRecord::getProductId, standardPart.getId())
                     .eq(MesBuildingWarehouseRecord::getProductType, param.getProductType())
                     .eq(MesBuildingWarehouseRecord::getNumber, param.getNumber())
                     .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               );
         }

         this.warehouseRecordService.save(record);
      }
   }

   @Override
   public boolean checkTechStandardPart(Long id, BigDecimal inboundMete) {
      TechStandardPart standardPart = this.standardPartService.getById(id);
      Preconditions.checkArgument(standardPart.getMete().compareTo(BigDecimal.ZERO) == 1, "配套件清单已全部入库完成，无法继续操作");
      TechStandardPart splitPart = this.standardPartService
         .getOne(Wrappers.lambdaQuery(TechStandardPart.class).eq(TechStandardPart::getOriginalId, standardPart.getId()));
      BigDecimal splitMete = splitPart == null ? BigDecimal.ZERO : splitPart.getMete();
      BigDecimal totalMete = standardPart.getMete().add(splitMete);
      Map<String, MesAuxiliary> auxiliaryMap = this.mesAuxiliaryService.list().stream().flatMap(auxiliaryx -> {
         String[] names = auxiliaryx.getAuxiliaryName().split(",");
         return Arrays.stream(names).map(name -> new SimpleEntry<>(name.trim() + "_" + auxiliaryx.getAccountingUnit(), auxiliaryx));
      }).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
      MesAuxiliary auxiliary = auxiliaryMap.get(standardPart.getName() + "_" + standardPart.getAccountingUnit());
      BigDecimal meteDiff = BigDecimal.ZERO;
      if (auxiliary != null) {
         meteDiff = auxiliary.getMeteDiff() == null ? BigDecimal.ZERO : auxiliary.getMeteDiff().divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
      }

      Preconditions.checkArgument(totalMete.add(totalMete.multiply(meteDiff)).compareTo(splitMete.add(inboundMete)) >= 0, "入库数量已可超出清单数量误差范围");
      return Boolean.TRUE;
   }

   @Override
   public void setStockQuantityProductReturn(WarehouseSaveDTOParam param) {
      MesBuildingWarehouseSummary summary = this.warehouseSummaryService
         .getOne(
            (Wrapper<MesBuildingWarehouseSummary>)(((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                              .eq(MesBuildingWarehouseSummary::getFactoryId, param.getFactoryId()))
                           .eq(MesBuildingWarehouseSummary::getProductId, param.getProductId()))
                        .eq(MesBuildingWarehouseSummary::getProductType, param.getProductType()))
                     .eq(MesBuildingWarehouseSummary::getWorkshopId, param.getWorkshopId()))
                  .eq(MesBuildingWarehouseSummary::getType, param.getType()))
               .eq(MesBuildingWarehouseSummary::getWarehouseType, param.getWarehouseType())
         );
      if (summary == null) {
         summary = BeanUtil.copy(param, MesBuildingWarehouseSummary.class);
         if (summary.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService.getById(summary.getProductId());
            summary.setCategory(enclosure.getCategory());
         }

         this.warehouseSummaryService.save(summary);
      } else {
         summary.setQuantity(summary.getQuantity().add(param.getQuantity()));
         this.warehouseSummaryService.updateById(summary);
      }

      if (CollectionUtils.isNotEmpty(param.getNumberList())) {
         for (Integer number : param.getNumberList()) {
            MesBuildingWarehouseRecord record = BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
            record.setCompleteId(param.getCompleteId());
            record.setQuantity(BigDecimal.ONE);
            record.setUserId(UserUtil.getCurrentUserId());
            record.setUserName(UserUtil.getCurrentName());
            record.setNumber(number);
            record.setWarehouseType(param.getWarehouseType());
            record.setStatus(
               record.getType().equals(WarehouseTypeEnum.INTO.getType())
                  ? WarehouseRecordStatusTypeEnum.INTO.getType()
                  : WarehouseRecordStatusTypeEnum.OUT.getType()
            );
            this.warehouseRecordService.save(record);
         }
      } else {
         MesBuildingWarehouseRecord record = BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
         record.setCompleteId(param.getCompleteId());
         record.setQuantity(param.getQuantity());
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setWarehouseType(param.getWarehouseType());
         record.setStatus(
            record.getType().equals(WarehouseTypeEnum.INTO.getType())
               ? WarehouseRecordStatusTypeEnum.INTO.getType()
               : WarehouseRecordStatusTypeEnum.OUT.getType()
         );
         this.warehouseRecordService.save(record);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void removeWarehouseRecord(List<Long> productIds, Integer productType) {
      List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                     .eq(MesBuildingWarehouseSummary::getProductType, productType))
                  .in(MesBuildingWarehouseSummary::getProductId, productIds))
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
         );
      if (CollectionUtils.isNotEmpty(summaryList)) {
         this.warehouseSummaryService.removeByIds(summaryList.stream().map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList()));
      }

      List<MesBuildingWarehouseRecord> records = this.warehouseRecordService
         .list(
            (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                     .eq(MesBuildingWarehouseRecord::getProductType, productType))
                  .in(MesBuildingWarehouseRecord::getProductId, productIds))
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
         );
      if (CollectionUtils.isNotEmpty(records)) {
         this.warehouseRecordService.removeByIds(records.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList()));
      }
   }

   @Override
   public void reduceQuantity(Long completeId, Integer quantity) {
      MesBuildingComplete complete = this.completeService.getById(completeId);
      Preconditions.checkArgument(complete != null, "完成记录不存在");
      MesBuildingWarehouseSummary summary = this.warehouseSummaryService
         .getOne(
            (Wrapper<MesBuildingWarehouseSummary>)(((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                        .eq(MesBuildingWarehouseSummary::getFactoryId, complete.getFactoryId()))
                     .eq(MesBuildingWarehouseSummary::getProductId, complete.getProductId()))
                  .eq(MesBuildingWarehouseSummary::getProductType, complete.getTaskTypeEnum()))
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
         );
      summary.setQuantity(summary.getQuantity().subtract(BigDecimal.valueOf(quantity.intValue())));
      this.warehouseSummaryService.updateById(summary);
      MesBuildingWarehouseRecord record = this.warehouseRecordService
         .getOne((Wrapper<MesBuildingWarehouseRecord>)Wrappers.<MesBuildingWarehouseRecord>lambdaQuery().eq(MesBuildingWarehouseRecord::getCompleteId, completeId));
      Preconditions.checkArgument(record != null, "完成记录不存在");
      record.setQuantity(record.getQuantity().subtract(BigDecimal.valueOf(quantity.intValue())));
      this.warehouseRecordService.updateById(record);
   }

   @Override
   public Map<String, Object> sumAppMete(Long projectId, Long monomerId) {
      ProductMeteDTO artifactMenu = this.artifactService.sumMeteByCondition(projectId, monomerId, null);
      ProductMeteDTO enclosureMenu = this.enclosureService.sumMeteByProjectIdOrMonomerId(projectId, monomerId, null);
      ProductMeteDO artifactIntoMete = this.warehouseSummaryService
         .sumMeteByCondition(
            projectId, monomerId, null, com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum.ARTIFACT.getType(), WarehouseTypeEnum.INTO.getType()
         );
      ProductMeteDO artifactOutMete = this.warehouseSummaryService
         .sumMeteByCondition(
            projectId, monomerId, null, com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum.ARTIFACT.getType(), WarehouseTypeEnum.OUT.getType()
         );
      ProductMeteDO enclosureIntoMete = this.warehouseSummaryService
         .sumMeteByCondition(
            projectId, monomerId, null, com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum.ENCLOSURE.getType(), WarehouseTypeEnum.INTO.getType()
         );
      ProductMeteDO enclosureOutMete = this.warehouseSummaryService
         .sumMeteByCondition(
            projectId, monomerId, null, com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum.ENCLOSURE.getType(), WarehouseTypeEnum.OUT.getType()
         );
      ProductWarehouseSummaryDTO artifact = ProductWarehouseSummaryDTO.builder()
         .quantity(artifactMenu.getQuantity())
         .mete(artifactMenu.getMete())
         .inboundMete(artifactIntoMete.getMete())
         .inboundQuantity(artifactIntoMete.getQuantity())
         .outboundMete(artifactOutMete.getMete())
         .outboundQuantity(artifactOutMete.getQuantity())
         .build();
      ProductWarehouseSummaryDTO enclosure = ProductWarehouseSummaryDTO.builder()
         .quantity(enclosureMenu.getQuantity())
         .mete(enclosureMenu.getMete())
         .inboundMete(enclosureIntoMete.getMete())
         .inboundQuantity(enclosureIntoMete.getQuantity())
         .outboundMete(enclosureOutMete.getMete())
         .outboundQuantity(enclosureOutMete.getQuantity())
         .build();
      Map<String, Object> result = new HashMap<>();
      result.put("artifact", artifact);
      result.put("enclosure", enclosure);
      return result;
   }

   @Override
   public List<DeliverDTO> DeliverGroupByMonth(LocalDateTime dateTime) {
      return this.warehouseRecordService.DeliverGroupByMonth(dateTime);
   }

   @Override
   public PageVO<MesBuildingWarehouseRecordDTO> listWareHouseRecord(Long projectId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService.findWarehouseRecordByProjectId(projectId);
      List<MesBuildingWarehouseRecordDTO> recordDTOList = this.convertList(recordList);
      return new PageVO<>(PageUtils.getPageInfo(recordDTOList, recordList));
   }

   private List<MesBuildingWarehouseRecordDTO> convertList(List<MesBuildingWarehouseRecord> recordList) {
      List<MesBuildingWarehouseRecordDTO> recordDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(recordList)) {
         Map<Long, ProjectInfo> projectInfoMap = this.projectService
            .listSimpleByIdList(recordList.stream().map(MesBuildingWarehouseRecord::getProjectId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         Set<Long> monomerIds = recordList.stream()
            .filter(w -> w.getMonomerId() != null && !w.getMonomerId().equals(0L))
            .map(MesBuildingWarehouseRecord::getMonomerId)
            .collect(Collectors.toSet());
         Map<Long, NameInfo> monomerMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(monomerIds)) {
            monomerMap = this.monomerService.listNameInfo(monomerIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> finalMonomerMap = monomerMap;
         Set<Long> areaIds = recordList.stream()
            .filter(w -> w.getAreaId() != null && !w.getAreaId().equals(0L))
            .map(MesBuildingWarehouseRecord::getAreaId)
            .collect(Collectors.toSet());
         Map<Long, NameInfo> areaMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(areaIds)) {
            areaMap = this.areaService.listSimpleByIds(areaIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> finalAreaMap = areaMap;
         Set<Long> factoryIds = recordList.stream()
            .filter(w -> w.getFactoryId() != null && !w.getFactoryId().equals(0L))
            .map(MesBuildingWarehouseRecord::getFactoryId)
            .collect(Collectors.toSet());
         Map<Long, NameInfo> factoryMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(factoryIds)) {
            factoryMap = this.mesBuildingFactoryService
               .listByIds(factoryIds)
               .stream()
               .map(f -> BeanUtil.copy(f, NameInfo.class))
               .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         }

         Map<Long, NameInfo> finalFactoryMap = factoryMap;
         Set<Long> artifactIds = recordList.stream()
            .filter(r -> r.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
            .map(MesBuildingWarehouseRecord::getProductId)
            .collect(Collectors.toSet());
         Set<Long> standardIds = recordList.stream()
            .filter(r -> r.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
            .map(MesBuildingWarehouseRecord::getProductId)
            .collect(Collectors.toSet());
         Set<Long> machinePartIds = recordList.stream()
            .filter(r -> r.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
            .map(MesBuildingWarehouseRecord::getProductId)
            .collect(Collectors.toSet());
         Set<Long> assembleIds = recordList.stream()
            .filter(r -> r.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
            .map(MesBuildingWarehouseRecord::getProductId)
            .collect(Collectors.toSet());
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
         Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
         Map<Long, TechAssemble> assembleMap;
         if (CollectionUtils.isNotEmpty(assembleIds)) {
            List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
            assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            businessAssembleMap = this.businessMachinePartService
               .listByIds(assembleList.stream().map(TechAssemble::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
         } else {
            assembleMap = Collections.emptyMap();
         }

         Map<Long, TechAssemble> finalAssembleMap = assembleMap;
         Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
         Map<Long, TechMachinePart> machinePartMap = Collections.emptyMap();
         Map<Long, BusinessMachinePart> businessMachinePartMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(machinePartIds)) {
            List<TechMachinePart> machinePartList = this.machinePartService.listByIds(machinePartIds);
            machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            businessMachinePartMap = this.businessMachinePartService
               .listByIds(machinePartList.stream().map(TechMachinePart::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
         }

         Map<Long, TechMachinePart> finalMachinePartMap = machinePartMap;
         Map<Long, BusinessMachinePart> finalBusinessMachinePartMap = businessMachinePartMap;
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
         recordDTOList = recordList.stream()
            .map(
               r -> {
                  MesBuildingWarehouseRecordDTO recordDTO = BeanUtil.copy(r, MesBuildingWarehouseRecordDTO.class);
                  recordDTO.setMonomer(finalMonomerMap.get(r.getMonomerId()));
                  recordDTO.setArea(finalAreaMap.get(r.getAreaId()));
                  recordDTO.setFactory(finalFactoryMap.get(r.getFactoryId()));
                  if (r.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = finalAllArtifactMap.get(r.getProductId());
                     recordDTO.setName(artifact.getName());
                     recordDTO.setSerialNumber(artifact.getSerialNumber());
                     recordDTO.setSpecification(artifact.getSpecification());
                     recordDTO.setMaterial(artifact.getMaterial());
                     recordDTO.setMeasureUnit("件");
                     recordDTO.setBoolAllPartSendDirectly(artifact.getBoolAllPartSendDirectly());
                     if (!artifact.getBoolAllPartSendDirectly()) {
                        BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                        BigDecimal totalPrice = BigDecimal.ZERO;
                        if (businessArtifact.getUnitPrice() != null) {
                           totalPrice = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? artifact.getNetWeight().multiply(r.getQuantity()).multiply(businessArtifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L))
                              : artifact.getLength().multiply(r.getQuantity()).multiply(businessArtifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L));
                        }

                        BigDecimal mete = businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                           ? artifact.getNetWeight().multiply(r.getQuantity()).divide(BigDecimal.valueOf(1000L))
                           : artifact.getLength().multiply(r.getQuantity()).divide(BigDecimal.valueOf(1000L));
                        recordDTO.setMete(mete);
                        recordDTO.setAccountingUnit(businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType()) ? "吨" : "米");
                        recordDTO.setUnitPrice(businessArtifact.getUnitPrice());
                        recordDTO.setTotalPrice(totalPrice);
                     }
                  }

                  if (r.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = finalStandardPartMap.get(r.getProductId());
                     recordDTO.setName(standardPart.getName());
                     recordDTO.setSpecification(standardPart.getSpecification());
                     recordDTO.setMete(standardPart.getMete().multiply(r.getQuantity()).divide(standardPart.getQuantity(), 4, RoundingMode.HALF_UP));
                     recordDTO.setMeasureUnit(standardPart.getMeasureUnit());
                     recordDTO.setAccountingUnit(standardPart.getAccountingUnit());
                     BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                     recordDTO.setUnitPrice(businessStandardPart.getUnitPrice());
                     recordDTO.setTotalPrice(
                        businessStandardPart.getUnitPrice() != null ? businessStandardPart.getUnitPrice().multiply(r.getQuantity()) : BigDecimal.ZERO
                     );
                  }

                  if (r.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = finalAssembleMap.get(r.getProductId());
                     recordDTO.setName(assemble.getName());
                     recordDTO.setSerialNumber(assemble.getSerialNumber());
                     recordDTO.setSpecification(assemble.getSpecification());
                     recordDTO.setMaterial(assemble.getMaterial());
                     recordDTO.setMeasureUnit("件");
                     if (assemble.getBoolAllPartSendDirectly() && assemble.getBoolSendDirectly()) {
                        recordDTO.setBoolPurLineSendDirectly(true);
                     } else if (assemble.getBoolSendDirectly()) {
                        recordDTO.setBoolPurLineSendDirectly(false);
                     }

                     BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                     BigDecimal totalPrice = BigDecimal.ZERO;
                     if (businessAssemble != null) {
                        if (businessAssemble.getUnitPrice() != null) {
                           totalPrice = businessAssemble.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? assemble.getNetWeight().multiply(r.getQuantity()).multiply(businessAssemble.getUnitPrice()).divide(BigDecimal.valueOf(1000L))
                              : assemble.getLength().multiply(r.getQuantity()).multiply(businessAssemble.getUnitPrice()).divide(BigDecimal.valueOf(1000L));
                        }

                        BigDecimal mete = businessAssemble.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                           ? assemble.getNetWeight().multiply(r.getQuantity()).divide(BigDecimal.valueOf(1000L))
                           : assemble.getLength().multiply(r.getQuantity()).divide(BigDecimal.valueOf(1000L));
                        recordDTO.setMete(mete);
                        recordDTO.setAccountingUnit(businessAssemble.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType()) ? "吨" : "米");
                        recordDTO.setUnitPrice(businessAssemble.getUnitPrice());
                     }

                     recordDTO.setTotalPrice(totalPrice);
                  }

                  if (r.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart machinePart = finalMachinePartMap.get(r.getProductId());
                     recordDTO.setName(machinePart.getName());
                     recordDTO.setSerialNumber(machinePart.getSerialNumber());
                     recordDTO.setSpecification(machinePart.getSpecification());
                     recordDTO.setMaterial(machinePart.getMaterial());
                     recordDTO.setMeasureUnit("件");
                     if (machinePart.getBoolAllPartSendDirectly() && machinePart.getBoolSendDirectly()) {
                        recordDTO.setBoolPurLineSendDirectly(true);
                     } else if (machinePart.getBoolSendDirectly()) {
                        recordDTO.setBoolPurLineSendDirectly(false);
                     }

                     BusinessMachinePart businessMachinePart = finalBusinessMachinePartMap.get(machinePart.getBusinessId());
                     BigDecimal totalPrice = BigDecimal.ZERO;
                     if (businessMachinePart != null) {
                        if (businessMachinePart.getUnitPrice() != null) {
                           totalPrice = businessMachinePart.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                              ? machinePart.getNetWeight()
                                 .multiply(r.getQuantity())
                                 .multiply(businessMachinePart.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L))
                              : machinePart.getLength()
                                 .multiply(r.getQuantity())
                                 .multiply(businessMachinePart.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L));
                        }

                        BigDecimal mete = businessMachinePart.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                           ? machinePart.getNetWeight().multiply(r.getQuantity()).divide(BigDecimal.valueOf(1000L))
                           : machinePart.getLength().multiply(r.getQuantity()).divide(BigDecimal.valueOf(1000L));
                        recordDTO.setMete(mete);
                        recordDTO.setAccountingUnit(businessMachinePart.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType()) ? "吨" : "米");
                        recordDTO.setUnitPrice(businessMachinePart.getUnitPrice());
                     }

                     recordDTO.setTotalPrice(totalPrice);
                  }

                  return recordDTO;
               }
            )
            .collect(Collectors.toList());
      }

      return recordDTOList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printInWareHouseRecord(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", this.projectService.getSimpleById(projectId));
      header.put("amount", this.businessBiz.getWarehouseAmount(projectId));
      printVO.setHeader(header);
      List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getProjectId, projectId)
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .orderByDesc(MesBuildingWarehouseRecord::getId)
         );
      List<Map<String, Object>> mapList = this.convertList(recordList).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public FinishProductWarehouseDTO finishedWarehouseSummary(
      Long projectId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Long workShopId,
      Integer productType,
      String projectName,
      List<Long> projectIds,
      Integer projectStatus
   ) {
      List<FinishProductWarehouseDTO> warehouseDTOS = this.finishedWarehouse(
         projectId, workShopId, dateTime, dateTimeList, productType, projectName, projectIds, projectStatus
      );
      FinishProductWarehouseDTO build = FinishProductWarehouseDTO.builder()
         .inboundNetWeight(BigDecimal.ZERO)
         .inboundGrossWeight(BigDecimal.ZERO)
         .outboundNetWeight(BigDecimal.ZERO)
         .outboundGrossWeight(BigDecimal.ZERO)
         .stockNetWeight(BigDecimal.ZERO)
         .stockGrossWeight(BigDecimal.ZERO)
         .inboundMete(BigDecimal.ZERO)
         .outboundMete(BigDecimal.ZERO)
         .stockMete(BigDecimal.ZERO)
         .beginningMete(BigDecimal.ZERO)
         .beginningNetWeight(BigDecimal.ZERO)
         .beginningGrossWeight(BigDecimal.ZERO)
         .build();
      warehouseDTOS.forEach(e -> {
         build.setInboundNetWeight(build.getInboundNetWeight().add(e.getInboundNetWeight()));
         build.setInboundGrossWeight(build.getInboundGrossWeight().add(e.getInboundGrossWeight()));
         build.setOutboundNetWeight(build.getOutboundNetWeight().add(e.getOutboundNetWeight()));
         build.setOutboundGrossWeight(build.getOutboundGrossWeight().add(e.getOutboundGrossWeight()));
         build.setStockNetWeight(build.getStockNetWeight().add(e.getStockNetWeight()));
         build.setStockGrossWeight(build.getStockGrossWeight().add(e.getStockGrossWeight()));
         build.setInboundMete(build.getInboundMete().add(e.getInboundMete()));
         build.setOutboundMete(build.getOutboundMete().add(e.getOutboundMete()));
         build.setStockMete(build.getStockMete().add(e.getStockMete()));
         build.setBeginningMete(build.getBeginningMete().add(e.getBeginningMete()));
         build.setBeginningNetWeight(build.getBeginningNetWeight().add(e.getBeginningNetWeight()));
         build.setBeginningGrossWeight(build.getBeginningGrossWeight().add(e.getBeginningGrossWeight()));
      });
      return build;
   }

   @Override
   public FinishProductWarehouseEnclosureDTO finishedWarehouseEnclosureSummary(
      Integer category, Long projectId, LocalDateTime dateTime, Long workShopId, Integer productType, String projectName, List<Long> projectIds
   ) {
      projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return null;
      }

      List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.finishedWarehouseEnclosure(
         category, projectId, workShopId, dateTime, productType, projectName, projectIds
      );
      return CollectionUtils.isNotEmpty(enclosureDTOS)
         ? FinishProductWarehouseEnclosureDTO.builder()
            .inboundTotalLength(enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getInboundTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add))
            .inboundTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getInboundTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .outboundTotalLength(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getOutboundTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .outboundTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getOutboundTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .stockTotalLength(enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getStockTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add))
            .stockTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getStockTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .beginningTotalLength(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getBeginningTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .beginningTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getBeginningTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .build()
         : null;
   }

   @Override
   public FinishProductWarehouseEnclosureDTO finishedWarehouseEnclosureSummaryV2(
      Long dictionaryId, Long projectId, LocalDateTime dateTime, Long workShopId, Integer productType, String projectName, List<Long> projectIds
   ) {
      projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return null;
      }

      List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.finishedWarehouseEnclosureV2(
         dictionaryId, projectId, workShopId, dateTime, productType, projectName, projectIds
      );
      return CollectionUtils.isNotEmpty(enclosureDTOS)
         ? FinishProductWarehouseEnclosureDTO.builder()
            .inboundTotalLength(enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getInboundTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add))
            .inboundTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getInboundTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .outboundTotalLength(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getOutboundTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .outboundTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getOutboundTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .stockTotalLength(enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getStockTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add))
            .stockTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getStockTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .beginningTotalLength(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getBeginningTotalLength).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .beginningTotalSurfaceArea(
               enclosureDTOS.stream().map(FinishProductWarehouseEnclosureDTO::getBeginningTotalSurfaceArea).reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .build()
         : null;
   }

   @Override
   public List<FinishProductWarehouseDTO> finishedWarehouse(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      List<Long> projectIds,
      Integer projectStatus
   ) {
      List<FinishProductWarehouseDTO> warehouseDTOList = new ArrayList<>(32);
      List<FinishProductWarehouseDTO> finishProductWarehouseDTOS = new ArrayList<>();
      String nowDate = LocalDateTime.now().format(DatePattern.NORM_DATE_FORMATTER);
      Boolean boolNowDate = false;
      if (CollectionUtils.isNotEmpty(dateTimeList) && dateTimeList.size() == 2) {
         LocalDateTime maxDateTime = dateTimeList.get(1);
         boolNowDate = maxDateTime.format(DatePattern.NORM_DATE_FORMATTER).equals(nowDate);
      }

      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         finishProductWarehouseDTOS = this.warehouseSummaryService
            .finishedWarehouse(projectId, workShopId, dateTime, dateTimeList, productType, projectName, projectIds, projectStatus, boolNowDate);
      }

      if ((productType & ProductTypeEnum.MACHINE_PART.getType()) > 0 && (productType & ProductTypeEnum.ASSEMBLE.getType()) > 0) {
         List<FinishProductWarehouseDTO> assemblyProductWarehouseDTOS = this.warehouseSummaryService
            .finishedWarehouse(projectId, workShopId, dateTime, dateTimeList, ProductTypeEnum.ASSEMBLE.getType(), null, projectIds, projectStatus, boolNowDate);
         List<FinishProductWarehouseDTO> pratProductWarehouseDTOS = this.warehouseSummaryService
            .finishedWarehouse(
               projectId, workShopId, dateTime, dateTimeList, ProductTypeEnum.MACHINE_PART.getType(), null, projectIds, projectStatus, boolNowDate
            );
         finishProductWarehouseDTOS.addAll(assemblyProductWarehouseDTOS);
         finishProductWarehouseDTOS.addAll(pratProductWarehouseDTOS);
      }

      if (CollectionUtils.isNotEmpty(finishProductWarehouseDTOS)) {
         Map<Long, List<FinishProductWarehouseDTO>> warehouseDTOMap = finishProductWarehouseDTOS.stream()
            .collect(Collectors.groupingBy(e -> e.getProject().getId()));
         warehouseDTOMap.forEach(
            (id, dtoList) -> {
               FinishProductWarehouseDTO dto = FinishProductWarehouseDTO.builder()
                  .project(dtoList.get(0).getProject())
                  .inboundQuantity(dtoList.stream().mapToInt(FinishProductWarehouseDTO::getInboundQuantity).sum())
                  .inboundMete(dtoList.stream().map(FinishProductWarehouseDTO::getInboundMete).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .inboundNetWeight(dtoList.stream().map(FinishProductWarehouseDTO::getInboundNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .inboundGrossWeight(dtoList.stream().map(FinishProductWarehouseDTO::getInboundGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .outboundQuantity(dtoList.stream().mapToInt(FinishProductWarehouseDTO::getOutboundQuantity).sum())
                  .outboundMete(dtoList.stream().map(FinishProductWarehouseDTO::getOutboundMete).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .outboundNetWeight(dtoList.stream().map(FinishProductWarehouseDTO::getOutboundNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .outboundGrossWeight(dtoList.stream().map(FinishProductWarehouseDTO::getOutboundGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .stockQuantity(dtoList.stream().mapToInt(FinishProductWarehouseDTO::getStockQuantity).sum())
                  .stockMete(dtoList.stream().map(FinishProductWarehouseDTO::getStockMete).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .stockNetWeight(dtoList.stream().map(FinishProductWarehouseDTO::getStockNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .stockGrossWeight(dtoList.stream().map(FinishProductWarehouseDTO::getStockGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .beginningQuantity(dtoList.stream().mapToInt(FinishProductWarehouseDTO::getBeginningQuantity).sum())
                  .beginningMete(dtoList.stream().map(FinishProductWarehouseDTO::getBeginningMete).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .beginningNetWeight(dtoList.stream().map(FinishProductWarehouseDTO::getBeginningNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .beginningGrossWeight(dtoList.stream().map(FinishProductWarehouseDTO::getBeginningGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .quantity(dtoList.stream().mapToInt(FinishProductWarehouseDTO::getQuantity).sum())
                  .mete(dtoList.stream().map(FinishProductWarehouseDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .totalNetWeight(dtoList.stream().map(FinishProductWarehouseDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .totalGrossWeight(dtoList.stream().map(FinishProductWarehouseDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .build();
               if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
                  dto.setPackageGrossWeight(dtoList.stream().map(FinishProductWarehouseDTO::getPackageGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
                  dto.setPackageMete(dtoList.stream().map(FinishProductWarehouseDTO::getPackageMete).reduce(BigDecimal.ZERO, BigDecimal::add));
                  dto.setPackageNetWeight(dtoList.stream().map(FinishProductWarehouseDTO::getPackageMete).reduce(BigDecimal.ZERO, BigDecimal::add));
                  dto.setPackageQuantity(dtoList.stream().mapToInt(FinishProductWarehouseDTO::getPackageQuantity).sum());
               }

               warehouseDTOList.add(dto);
            }
         );
      }

      return warehouseDTOList.stream()
         .sorted(
            Comparator.comparing(FinishProductWarehouseDTO::getBeginningQuantity, Comparator.reverseOrder())
               .thenComparing(FinishProductWarehouseDTO::getInboundQuantity, Comparator.reverseOrder())
               .thenComparing(FinishProductWarehouseDTO::getOutboundQuantity, Comparator.reverseOrder())
               .thenComparing(FinishProductWarehouseDTO::getStockQuantity, Comparator.reverseOrder())
               .thenComparing(FinishProductWarehouseDTO::getQuantity, Comparator.reverseOrder())
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosure(
      Integer category, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   ) {
      List<FinishProductWarehouseEnclosureDTO> warehouseDTOList = new ArrayList<>(32);
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.warehouseSummaryService
            .finishedWarehouseEnclosure(category, projectId, workShopId, dateTime, productType, projectName, projectIds);
         if (CollectionUtils.isNotEmpty(enclosureDTOS)) {
            Map<Long, List<FinishProductWarehouseEnclosureDTO>> warehouseDTOMap = enclosureDTOS.stream()
               .collect(Collectors.groupingBy(e -> e.getProject().getId()));
            warehouseDTOMap.forEach(
               (id, dtoList) -> {
                  FinishProductWarehouseEnclosureDTO dto = FinishProductWarehouseEnclosureDTO.builder()
                     .project(dtoList.get(0).getProject())
                     .inboundQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getInboundQuantity).sum())
                     .inboundTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getInboundTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .inboundTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getInboundTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .outboundQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getOutboundQuantity).sum())
                     .outboundTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getOutboundTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .outboundTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getOutboundTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .stockQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getStockQuantity).sum())
                     .stockTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getStockTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .stockTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getStockTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .beginningQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getBeginningQuantity).sum())
                     .beginningTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getBeginningTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .beginningTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getBeginningTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .quantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getQuantity).sum())
                     .totalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .totalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .build();
                  warehouseDTOList.add(dto);
               }
            );
         }
      }

      return warehouseDTOList.stream()
         .filter(e -> e.getBeginningQuantity() != 0 || e.getOutboundQuantity() != 0 || e.getInboundQuantity() != 0 || e.getStockQuantity() != 0)
         .sorted(Comparator.comparing(FinishProductWarehouseEnclosureDTO::getQuantity).reversed())
         .collect(Collectors.toList());
   }

   @Override
   public List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   ) {
      List<FinishProductWarehouseEnclosureDTO> warehouseDTOList = new ArrayList<>(32);
      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.warehouseSummaryService
            .finishedWarehouseEnclosureV2(dictionaryId, projectId, workShopId, dateTime, productType, projectName, projectIds);
         if (CollectionUtils.isNotEmpty(enclosureDTOS)) {
            Map<Long, List<FinishProductWarehouseEnclosureDTO>> warehouseDTOMap = enclosureDTOS.stream()
               .collect(Collectors.groupingBy(e -> e.getProject().getId()));
            warehouseDTOMap.forEach(
               (id, dtoList) -> {
                  FinishProductWarehouseEnclosureDTO dto = FinishProductWarehouseEnclosureDTO.builder()
                     .project(dtoList.get(0).getProject())
                     .inboundQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getInboundQuantity).sum())
                     .inboundTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getInboundTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .inboundTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getInboundTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .outboundQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getOutboundQuantity).sum())
                     .outboundTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getOutboundTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .outboundTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getOutboundTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .stockQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getStockQuantity).sum())
                     .stockTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getStockTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .stockTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getStockTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .beginningQuantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getBeginningQuantity).sum())
                     .beginningTotalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getBeginningTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .beginningTotalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getBeginningTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .quantity(dtoList.stream().mapToInt(FinishProductWarehouseEnclosureDTO::getQuantity).sum())
                     .totalLength(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getTotalLength)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP)
                     )
                     .totalSurfaceArea(
                        dtoList.stream()
                           .map(FinishProductWarehouseEnclosureDTO::getTotalSurfaceArea)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                           .divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP)
                     )
                     .build();
                  warehouseDTOList.add(dto);
               }
            );
         }
      }

      return warehouseDTOList.stream()
         .filter(e -> e.getBeginningQuantity() != 0 || e.getOutboundQuantity() != 0 || e.getInboundQuantity() != 0 || e.getStockQuantity() != 0)
         .sorted(Comparator.comparing(FinishProductWarehouseEnclosureDTO::getQuantity).reversed())
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<FinishProductWarehouseDTO> finishedWarehousePage(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      Integer lumpSumSystemType,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.STRUCTURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<FinishProductWarehouseDTO> finishProductWarehouseDTOS = this.finishedWarehouse(
         projectId, workShopId, dateTime, dateTimeList, productType, projectName, projectIds, projectStatus
      );
      finishProductWarehouseDTOS = finishProductWarehouseDTOS.stream().map(s -> {
         if (s.getBeginningQuantity() < 0) {
            s.setBeginningQuantity(0);
            s.setBeginningMete(BigDecimal.valueOf(0L));
            s.setBeginningNetWeight(BigDecimal.valueOf(0L));
            s.setBeginningGrossWeight(BigDecimal.valueOf(0L));
         }

         if (s.getStockQuantity() < 0) {
            s.setStockQuantity(0);
            s.setStockMete(BigDecimal.valueOf(0L));
            s.setStockNetWeight(BigDecimal.valueOf(0L));
            s.setStockGrossWeight(BigDecimal.valueOf(0L));
         }

         return (FinishProductWarehouseDTO)s;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageVO(finishProductWarehouseDTOS, pageNumber, pageSize));
   }

   @Override
   public PageVO<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosurePage(
      Integer category,
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      Integer productType,
      String projectName,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.finishedWarehouseEnclosure(
         category, projectId, workShopId, dateTime, productType, projectName, projectIds
      );
      if (CollectionUtils.isNotEmpty(enclosureDTOS)) {
         Page<FinishProductWarehouseEnclosureDTO> pages = new Page<>(pageNumber, pageSize);
         int total = enclosureDTOS.size();
         pages.setTotal(total);
         int startIndex = (pageNumber - 1) * pageSize;
         if (startIndex > enclosureDTOS.size()) {
            startIndex = 0;
         }

         int endIndex = Math.min(startIndex + pageSize, total);
         pages.addAll(enclosureDTOS.subList(startIndex, endIndex));
         return new PageVO<>(pages);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosurePageV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.finishedWarehouseEnclosureV2(
         dictionaryId, projectId, workShopId, dateTime, productType, projectName, projectIds
      );
      if (CollectionUtils.isNotEmpty(enclosureDTOS)) {
         Page<FinishProductWarehouseEnclosureDTO> pages = new Page<>(pageNumber, pageSize);
         int total = enclosureDTOS.size();
         pages.setTotal(total);
         int startIndex = (pageNumber - 1) * pageSize;
         if (startIndex > enclosureDTOS.size()) {
            startIndex = 0;
         }

         int endIndex = Math.min(startIndex + pageSize, total);
         pages.addAll(enclosureDTOS.subList(startIndex, endIndex));
         return new PageVO<>(pages);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> finishedWarehousePrint(
      Long projectId,
      Long workShopId,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      String projectName,
      Integer lumpSumSystemType,
      Integer projectStatus
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.STRUCTURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("datetime", "全部");
      if (CollectionUtils.isNotEmpty(dateTimeList) && dateTimeList.size() == 2) {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String startTime = df.format(dateTimeList.get(0));
         String endTime = df.format(dateTimeList.get(1));
         header.put("datetime", startTime + "-" + endTime);
      }

      header.put("workShopName", workShopId == null ? "全部" : this.mesBuildingWorkshopService.getById(workShopId).getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.finishedWarehouse(projectId, workShopId, dateTime, dateTimeList, productType, projectName, projectIds, projectStatus)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> finishedWarehouseEnclosurePrint(
      Integer category, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, Integer lumpSumSystemType
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("datetime", dateTime == null ? "全部" : dateTime);
      header.put("workShopName", workShopId == null ? "全部" : this.mesBuildingWorkshopService.getById(workShopId).getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.finishedWarehouseEnclosure(category, projectId, workShopId, dateTime, productType, projectName, projectIds)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> finishedWarehouseEnclosurePrintV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("datetime", dateTime == null ? "全部" : dateTime);
      header.put("workShopName", workShopId == null ? "全部" : this.mesBuildingWorkshopService.getById(workShopId).getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.finishedWarehouseEnclosureV2(dictionaryId, projectId, workShopId, dateTime, productType, projectName, projectIds)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<FinishProductWarehouseDTO> finishedWarehouseDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList
   ) {
      return this.warehouseSummaryService.finishedWarehouseDetail(projectId, monomerId, areaId, serialNumber, workshopId, productType, dateTime, dateTimeList);
   }

   @Override
   public List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureDetail(
      Integer category, Long projectId, Long enclosurePlanId, String serialNumber, Long workshopId, Integer productType, LocalDateTime dateTime
   ) {
      return this.warehouseSummaryService
         .finishedWarehouseEnclosureDetail(category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime);
   }

   @Override
   public PageVO<FinishProductWarehouseDTO> finishedWarehouseDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<FinishProductWarehouseDTO> warehouseDTOList = this.finishedWarehouseDetail(
         projectId, monomerId, areaId, serialNumber, workshopId, productType, dateTime, dateTimeList
      );
      if (CollectionUtils.isNotEmpty(warehouseDTOList) && CollectionUtils.isNotEmpty(warehouseDTOList)) {
         Page<FinishProductWarehouseDTO> pages = new Page<>(pageNumber, pageSize);
         int total = warehouseDTOList.size();
         pages.setTotal(total);
         int startIndex = (pageNumber - 1) * pageSize;
         if (startIndex > warehouseDTOList.size()) {
            startIndex = 0;
         }

         int endIndex = Math.min(startIndex + pageSize, total);
         pages.addAll(warehouseDTOList.subList(startIndex, endIndex));
         return new PageVO<>(pages);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureDetailPage(
      Integer category,
      Long projectId,
      Long enclosurePlanId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.finishedWarehouseEnclosureDetail(
         category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime
      );
      return new PageVO<>(enclosureDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> finishedWarehouseDetailPrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer productType,
      LocalDateTime dateTime,
      List<LocalDateTime> dateTimeList,
      Integer weightStatus
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("dateTime", "全部");
      if (CollectionUtils.isNotEmpty(dateTimeList) && dateTimeList.size() == 2) {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String startTime = df.format(dateTimeList.get(0));
         String endTime = df.format(dateTimeList.get(1));
         header.put("datetime", startTime + "-" + endTime);
      }

      header.put("projectName", project.getName());
      header.put("serialNumber", project.getSerialNumber());
      header.put("weightStatus", weightStatus);
      printVO.setHeader(header);
      List<FinishProductWarehouseDTO> dtoList = this.finishedWarehouseDetail(
         projectId, monomerId, areaId, serialNumber, workshopId, productType, dateTime, dateTimeList
      );
      printVO.setTable(dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> finishedWarehouseEnclosureDetailPrint(
      Integer category, Long projectId, Long enclosurePlanId, String serialNumber, Long workshopId, Integer productType, LocalDateTime dateTime
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("dateTime", dateTime == null ? "全部" : dateTime);
      header.put("projectName", project.getName());
      header.put("serialNumber", project.getSerialNumber());
      printVO.setHeader(header);
      List<FinishProductWarehouseEnclosureDTO> enclosureDTOS = this.finishedWarehouseEnclosureDetail(
         category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime
      );
      List<FinishProductWarehouseEnclosureDTO> warehouseDTOS = enclosureDTOS.stream()
         .filter(e -> e.getBeginningQuantity() != 0 || e.getOutboundQuantity() != 0 || e.getInboundQuantity() != 0 || e.getStockQuantity() != 0)
         .collect(Collectors.toList());
      printVO.setTable(warehouseDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO finishArtifactReport(WarehouseReportDetailDOParam param) {
      Preconditions.checkArgument(param.getType() != null && WarehouseInboundIssuedDepositedEnum.isExist(param.getType().intValue()), "入发存类型不存在!!");
      if (ProductTypeEnum.ARTIFACT.getType().equals(param.getProductType())) {
         List<Integer> productTypeList = Collections.singletonList(ProductTypeEnum.ARTIFACT.getType());
         param.setProductTypeList(productTypeList);
      }

      if ((ProductTypeEnum.MACHINE_PART.getType() & param.getProductType()) > 0 && (ProductTypeEnum.ASSEMBLE.getType() & param.getProductType()) > 0) {
         List<Integer> productTypeList = Arrays.asList(ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType());
         param.setProductTypeList(productTypeList);
      }

      Page<Object> page = PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<WarehouseReportArtifactDO> result = this.warehouseRecordService.finishArtifactReport(param);
      return new PageVO<>(page, result);
   }

   @Override
   public Map<String, Object> finishArtifactReportSum(WarehouseReportDetailDOParam param) {
      Preconditions.checkArgument(param.getType() != null && WarehouseInboundIssuedDepositedEnum.isExist(param.getType().intValue()), "入发存类型不存在!!");
      if (ProductTypeEnum.ARTIFACT.getType().equals(param.getProductType())) {
         List<Integer> productTypeList = Collections.singletonList(ProductTypeEnum.ARTIFACT.getType());
         param.setProductTypeList(productTypeList);
      }

      if ((ProductTypeEnum.MACHINE_PART.getType() & param.getProductType()) > 0 && (ProductTypeEnum.ASSEMBLE.getType() & param.getProductType()) > 0) {
         List<Integer> productTypeList = Arrays.asList(ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType());
         param.setProductTypeList(productTypeList);
      }

      List<WarehouseReportArtifactDO> result = this.warehouseRecordService.finishArtifactReport(param);
      Map<String, Object> map = new HashMap<>();
      if (CollectionUtils.isNotEmpty(result)) {
         map.put("quantity", result.stream().map(ArtifactBaseInfo::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add));
         map.put("totalNetWeight", result.stream().map(ArtifactBaseInfo::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         map.put("totalGrossWeight", result.stream().map(ArtifactBaseInfo::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
      }

      return map;
   }

   @Override
   public PageVO finishEnclosureReport(WarehouseReportDetailDOParam param) {
      Preconditions.checkArgument(param.getType() != null && WarehouseInboundIssuedDepositedEnum.isExist(param.getType().intValue()), "入发存类型不存在!!");
      Preconditions.checkArgument(param.getCategory() != null && ContractTechTypeEnum.isExist(param.getCategory()), "围护产品类型不存在");
      return new PageVO(
         PageHelper.startPage(param.getPageNumber(), param.getPageSize()).doSelectPage(() -> this.warehouseRecordService.finishEnclosureReport(param))
      );
   }

   @Override
   public PageVO finishEnclosureReportV2(WarehouseReportDetailDOParam param) {
      Preconditions.checkArgument(param.getType() != null && WarehouseInboundIssuedDepositedEnum.isExist(param.getType().intValue()), "入发存类型不存在!!");
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      Preconditions.checkArgument(param.getDictionaryId() == null || enclosureDictMap.get(param.getDictionaryId()) != null, "围护产品类型不存在");
      return new PageVO(
         PageHelper.startPage(param.getPageNumber(), param.getPageSize()).doSelectPage(() -> this.warehouseRecordService.finishEnclosureReport(param))
      );
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printFinishedWarehousePrint(WarehouseReportDetailDOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      ContractProject project = this.projectService.getById(param.getProjectId());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getDateTime() != null) {
         header.put("dateTime", param.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      }

      header.put("dateTime", param.getDateTime());
      if (project != null) {
         header.put("project", project.getShortName() + "-" + project.getSerialNumber());
      }

      if (CollectionUtils.isNotEmpty(param.getDateTimeList())) {
         String dateTimeStart = param.getDateTimeList().get(0).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         String dateTimeEnd = param.getDateTimeList().get(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         header.put("dateTime", dateTimeStart + "-" + dateTimeEnd);
      }

      header.put("totalNetWeight", BigDecimal.ZERO);
      header.put("totalGrossWeight", BigDecimal.ZERO);
      List<WarehouseReportArtifactDO> list = this.warehouseRecordService.finishArtifactReport(param);
      if (CollUtil.isNotEmpty(list)) {
         BigDecimal totalNetWeight = list.stream().map(ArtifactBaseInfo::getTotalNetWeight).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalNetWeight", totalNetWeight);
         BigDecimal totalGrossWeight = list.stream()
            .map(ArtifactBaseInfo::getTotalGrossWeight)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalGrossWeight", totalGrossWeight);
      }

      printVO.setHeader(header);
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<Integer> productTypeList = Collections.singletonList(ProductTypeEnum.ARTIFACT.getType());
         param.setProductTypeList(productTypeList);
      }

      if ((ProductTypeEnum.MACHINE_PART.getType() & param.getProductType()) > 0 && (ProductTypeEnum.ASSEMBLE.getType() & param.getProductType()) > 0) {
         List<Integer> productTypeList = Arrays.asList(ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType());
         param.setProductTypeList(productTypeList);
      }

      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printFinishedWarehouseEnclosurePrint(WarehouseReportDetailDOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(this.warehouseRecordService.finishEnclosureReport(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }
}
