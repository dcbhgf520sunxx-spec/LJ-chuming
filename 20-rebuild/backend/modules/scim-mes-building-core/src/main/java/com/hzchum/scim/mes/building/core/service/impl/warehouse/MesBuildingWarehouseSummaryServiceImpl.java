package com.hzchum.scim.mes.building.core.service.impl.warehouse;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QueryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductCategoryMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WareSubscribeArtifactPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.ProductPackageDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.WareSubscribeArtifactPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseArtifactFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseEnclosureFindDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingLineChangeListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.FinishProductWarehouseEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.MesEnclosureWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.UnEqualDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.ArtifactWarehouseTonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.WorkShopTonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.productionCapacity.ProductionCapacityVO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingWarehouseSummaryMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingWarehouseSummaryServiceImpl
   extends ServiceImpl<MesBuildingWarehouseSummaryMapper, MesBuildingWarehouseSummary>
   implements MesBuildingWarehouseSummaryService {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseStorageProductService warehouseStorageProductService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesEnclosureTaskService enclosureTaskService;
   @Autowired
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Autowired
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Autowired
   private TechArtifactService techArtifactService;
   @Autowired
   private TechAssembleService techAssembleService;
   @Autowired
   private TechMachinePartService techMachinePartService;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public PageVO<WarehouseArtifactDO> pageArtifact(WarehouseArtifactFindDOParam param) {
      return new PageVO<>(
         PageHelper.<WarehouseArtifactDO>startPage(param.getPageNumber(), param.getPageSize())
            .doSelectPage(() -> this.baseMapper.listArtifactByCondition(param))
      );
   }

   @Override
   public PrintVO printArtifact(WarehouseArtifactFindDOParam param) {
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      header.put("project", this.projectService.getSimpleById(monomer.getProjectId()));
      header.put("monomer", BeanUtil.copy(monomer, PlanMonomer.class));
      printVO.setHeader(header);
      printVO.setTable(this.baseMapper.listArtifactByCondition(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<WarehouseEnclosureDO> pageEnclosure(WarehouseEnclosureFindDOParam param) {
      return new PageVO<>(
         PageHelper.<WarehouseEnclosureDO>startPage(param.getPageNumber(), param.getPageSize())
            .doSelectPage(() -> this.baseMapper.listEnclosureByCondition(param))
      );
   }

   @Override
   public PrintVO printEnclosure(WarehouseEnclosureFindDOParam param) {
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      header.put("project", this.projectService.getSimpleById(monomer.getProjectId()));
      header.put("monomer", BeanUtil.copy(monomer, PlanMonomer.class));
      printVO.setHeader(header);
      printVO.setTable(this.baseMapper.listEnclosureByCondition(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public ProductMeteDO sumMeteByCondition(Long projectId, Long monomerId, Long factoryId, Integer productType, Integer type) {
      return this.baseMapper.sumMeteByCondition(projectId, monomerId, factoryId, productType, type);
   }

   @Override
   public List<ProductCategoryMeteDO> sumEnclosureMeteGroupCategory(Long projectId) {
      return this.baseMapper.sumEnclosureMeteGroupCategoryByCondition(projectId);
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
      Integer projectStatus,
      Boolean boolNowDate
   ) {
      return this.baseMapper.finishedWarehouse(projectId, workShopId, dateTime, dateTimeList, productType, projectName, projectIds, projectStatus, boolNowDate);
   }

   @Override
   public List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosure(
      Integer category, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   ) {
      return this.baseMapper.finishedWarehouseEnclosure(category, projectId, workShopId, dateTime, productType, projectName, projectIds);
   }

   @Override
   public List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureV2(
      Long dictionaryId, Long projectId, Long workShopId, LocalDateTime dateTime, Integer productType, String projectName, List<Long> projectIds
   ) {
      return this.baseMapper.finishedWarehouseEnclosureV2(dictionaryId, projectId, workShopId, dateTime, productType, projectName, projectIds);
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
      List<FinishProductWarehouseDTO> result = new ArrayList<>();
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         result = this.baseMapper
            .finishedWarehouseDetail(projectId, monomerId, areaId, serialNumber, workshopId, ProductTypeEnum.ARTIFACT.getType(), dateTime, dateTimeList);
      }

      if ((productType & ProductTypeEnum.MACHINE_PART.getType()) > 0 && (productType & ProductTypeEnum.ASSEMBLE.getType()) > 0) {
         result.addAll(
            this.baseMapper
               .finishedWarehouseDetail(projectId, monomerId, areaId, serialNumber, workshopId, ProductTypeEnum.MACHINE_PART.getType(), dateTime, dateTimeList)
         );
         result.addAll(
            this.baseMapper
               .finishedWarehouseDetail(projectId, monomerId, areaId, serialNumber, workshopId, ProductTypeEnum.ASSEMBLE.getType(), dateTime, dateTimeList)
         );
      }

      return result;
   }

   @Override
   public List<FinishProductWarehouseEnclosureDTO> finishedWarehouseEnclosureDetail(
      Integer category, Long projectId, Long enclosurePlanId, String serialNumber, Long workshopId, Integer productType, LocalDateTime dateTime
   ) {
      return productType.equals(ProductTypeEnum.ENCLOSURE.getType())
         ? this.baseMapper.finishedWarehouseEnclosureDetail(category, projectId, enclosurePlanId, serialNumber, workshopId, productType, dateTime)
         : new ArrayList<>();
   }

   @Override
   public QuantityAndWeightDetailDO getMeteSummaryByCondition(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Long workshopId) {
      return this.baseMapper.getMeteSummaryByCondition(projectId, startDate, endDate, workshopId);
   }

   @Override
   public List<QuantityAndWeightDetailDO> getMeteSummaryByProjectIds(List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate, Long workshopId) {
      return this.baseMapper.getMeteSummaryByProjectIds(projectIds, startDate, endDate, workshopId);
   }

   @Override
   public PageVO<ArtifactDetailDO> listArtifactPackageByCondition(ProductPackageDOParam copy) {
      PageHelper.startPage(copy.getPageNumber(), copy.getPageSize(), StringUtils.analyzeSortConditions(copy.getSort()));
      List<ArtifactDetailDO> packs = this.baseMapper.listArtifactPackageByCondition(copy);
      if (CollectionUtils.isNotEmpty(packs)) {
         List<Long> productIds = packs.stream().map(ArtifactDetailDO::getProductId).distinct().collect(Collectors.toList());
         Map<String, List<ArtifactStockNumberDO>> numberMap = this.baseMapper
            .listArtifactPackageNumberByCondition(copy.getFactoryId(), productIds)
            .stream()
            .collect(Collectors.groupingBy(e -> e.getWorkshop().getId() + "-" + e.getProductId() + "-" + e.getWarehouseType()));
         List<MesBuildingQhse> qhseList = this.qhseService
            .list(
               Wrappers.lambdaQuery(MesBuildingQhse.class)
                  .eq(MesBuildingQhse::getType, QhseTypeEnum.SPECIAL_QUALITY.getType())
                  .in(MesBuildingQhse::getStatus, QhseStatusEnum.UN_RECTIFIED.getType(), QhseStatusEnum.UN_ADOPT.getType())
                  .in(MesBuildingQhse::getProductId, productIds)
            );
         Map<Long, List<Integer>> qhseNumberMap = qhseList.stream()
            .collect(Collectors.groupingBy(MesBuildingQhse::getProductId, Collectors.mapping(MesBuildingQhse::getNumber, Collectors.toList())));
         Map<Long, Boolean> artifactCodingTypeMap = this.utilsBiz.getBoolBatchCode(productIds);
         packs.forEach(
            e -> {
               e.setBoolOneCode(artifactCodingTypeMap.get(e.getProductId()));
               List<Integer> number = qhseNumberMap.get(e.getProductId());
               e.setQhseNumbers(number);
               List<ArtifactStockNumberDO> numberDOS = numberMap.getOrDefault(
                  (e.getWorkshopInf() != null ? e.getWorkshopInf().getId() : 0L) + "-" + e.getProductId() + "-" + e.getWarehouseType(), Collections.emptyList()
               );
               e.setNumberList(
                  e.getBoolOneCode()
                     ? numberDOS.stream().filter(y -> number == null || !number.contains(y.getNumber())).collect(Collectors.toList())
                     : Collections.emptyList()
               );
            }
         );
      }

      return new PageVO<>(packs);
   }

   @Override
   public PageVO<SendDirectlyDetailDO> listPartPackageByCondition(ProductPackageDOParam copy) {
      copy.setProductTypeList(
         copy.getProductType() != null
            ? Collections.singletonList(copy.getProductType())
            : Arrays.asList(ProductTypeEnum.MACHINE_PART.getType(), ProductTypeEnum.ASSEMBLE.getType())
      );
      PageHelper.startPage(copy.getPageNumber(), copy.getPageSize());
      List<SendDirectlyDetailDO> sendDirectlyDetailDOS = this.baseMapper.listDirectlyPackageByCondition(copy);
      return new PageVO<>(sendDirectlyDetailDOS);
   }

   @Override
   public List<EnclosureDetailDO> listEnclosurePackageByCondition(ProductPackageDOParam copy) {
      PageHelper.startPage(copy.getPageNumber(), copy.getPageSize(), StringUtils.analyzeSortConditions(copy.getSort()));
      return this.baseMapper.listEnclosurePackageByCondition(copy);
   }

   @Override
   public PageVO<TechStandardPartDetailDO> listTechStandardPartPackageByCondition(ProductPackageDOParam copy) {
      PageHelper.startPage(copy.getPageNumber(), copy.getPageSize(), StringUtils.analyzeSortConditions(copy.getSort()));
      List<TechStandardPartDetailDO> partDetailDOS = this.baseMapper.listTechStandardPartPackageByCondition(copy);
      return new PageVO<>(partDetailDOS);
   }

   @Override
   public Map<String, Object> listByProduct(Long factoryId, Long productId, Long taskId, Integer productType, Long workshopId, Long warehouseId, Integer number) {
      MesBuildingWorkshop workshop = null;
      if (workshopId != null) {
         workshop = this.mesBuildingWorkshopService.getById(workshopId);
      } else if (taskId != null) {
         if (productType.equals(TaskTypeEnum.ENCLOSURE.getType())) {
            MesEnclosureTask task = this.enclosureTaskService.getById(taskId);
            Preconditions.checkArgument(task != null, "任务不存在");
            workshopId = task.getWorkshopId();
            workshop = this.mesBuildingWorkshopService.getById(task.getWorkshopId());
         } else {
            MesBuildingTask task = this.taskService.getById(taskId);
            Preconditions.checkArgument(task != null, "任务不存在");
            workshopId = task.getWorkshopId();
            workshop = this.mesBuildingWorkshopService.getById(task.getWorkshopId());
         }
      } else {
         if (warehouseId == null) {
            throw new IllegalArgumentException("装车失败!");
         }

         MesBuildingWarehouseSummary warehouseSummary = this.warehouseSummaryService.getById(warehouseId);
         Preconditions.checkArgument(warehouseSummary != null, "操作失败,库存记录不存在!");
         workshopId = warehouseSummary.getWorkshopId();
      }

      MesBuildingWarehouseSummary record = null;
      if (warehouseId != null) {
         record = this.warehouseSummaryService.getById(warehouseId);
      } else {
         if (number == null) {
            record = this.baseMapper
               .selectOne(
                  (Wrapper<MesBuildingWarehouseSummary>)((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                                 .eq(factoryId != null, MesBuildingWarehouseSummary::getFactoryId, factoryId))
                              .eq(MesBuildingWarehouseSummary::getWorkshopId, workshopId))
                           .eq(MesBuildingWarehouseSummary::getProductId, productId))
                        .eq(MesBuildingWarehouseSummary::getProductType, productType))
                     .eq(MesBuildingWarehouseSummary::getType, 1)
               );
         }

         if ((productType.equals(ProductTypeEnum.ARTIFACT.getType()) || productType.equals(ProductTypeEnum.ASSEMBLE.getType())) && number != null) {
            MesBuildingWarehouseRecord warehouseRecord = this.warehouseRecordService
               .getOne(
                  (((((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                                    .eq(MesBuildingWarehouseRecord::getNumber, number))
                                 .eq(MesBuildingWarehouseRecord::getProductId, productId))
                              .eq(MesBuildingWarehouseRecord::getProductType, productType))
                           .eq(MesBuildingWarehouseRecord::getType, 1))
                        .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType()))
                     .eq(factoryId != null, MesBuildingWarehouseRecord::getFactoryId, factoryId)
               );
            if (warehouseRecord == null && ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
                  .list(
                     (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>().eq(MesBuildingTaskNumberLink::getArtifactId, productId))
                        .eq(MesBuildingTaskNumberLink::getArtifactNumber, number)
                  );
               if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
                  MesBuildingTaskNumberLink taskNumberLink = mesBuildingTaskNumberLinks.get(0);
                  Long artifactTaskProcessId = taskNumberLink.getArtifactTaskProcessId();
                  if (artifactTaskProcessId != null && artifactTaskProcessId != 0L) {
                     MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(artifactTaskProcessId);
                     if (taskProcess != null) {
                        MesBuildingProcess process = this.processService.getById(taskProcess.getProcessId());
                        throw new IllegalArgumentException("装车失败,当前构件正处于" + process.getName() + "工序状态!");
                     }
                  }
               }
            }

            Preconditions.checkArgument(warehouseRecord != null, "操作失败,该产品未入库存或库存不足!");
            record = this.baseMapper
               .selectOne(
                  (Wrapper<MesBuildingWarehouseSummary>)((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                                 .eq(factoryId != null, MesBuildingWarehouseSummary::getFactoryId, factoryId))
                              .eq(MesBuildingWarehouseSummary::getWorkshopId, warehouseRecord.getWorkshopId()))
                           .eq(MesBuildingWarehouseSummary::getProductId, productId))
                        .eq(MesBuildingWarehouseSummary::getProductType, productType))
                     .eq(MesBuildingWarehouseSummary::getType, 1)
               );
         }
      }

      Preconditions.checkArgument(record != null, "该产品未入库!");
      Preconditions.checkArgument(
         record.getQuantity().subtract(record.getCargoQuantity()).subtract(record.getPackageQuantity()).compareTo(BigDecimal.ZERO) > 0, "该产品库存不足!"
      );
      this.checkArtifactSavedWarehouseQuantity(record, number);
      HashMap<String, Object> map = new HashMap<>();
      map.put("id", record.getId());
      map.put("quantity", record.getQuantity().subtract(record.getCargoQuantity()).subtract(record.getPackageQuantity()));
      map.put("workshopId", workshopId);
      map.put("workshopName", workshop != null ? workshop.getName() : null);
      map.put("boolOneCode", record.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) ? this.utilsBiz.getBoolOneCode(record.getProductId()) : false);
      if (record.getWarehouseType().equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())) {
         map.put("boolOneCode", false);
      }

      if ("true".equals(map.get("boolOneCode") + "")) {
         map.put(
            "numberList",
            this.warehouseRecordService
               .list(
                  (Wrapper<MesBuildingWarehouseRecord>)((((((Wrappers.<MesBuildingWarehouseRecord>lambdaQuery()
                                       .eq(factoryId != null, MesBuildingWarehouseRecord::getFactoryId, factoryId))
                                    .eq(workshopId != null, MesBuildingWarehouseRecord::getWorkshopId, workshopId))
                                 .eq(MesBuildingWarehouseRecord::getProductId, productId))
                              .eq(MesBuildingWarehouseRecord::getProductType, productType))
                           .eq(MesBuildingWarehouseRecord::getType, 1))
                        .eq(MesBuildingWarehouseRecord::getWarehouseType, record.getWarehouseType()))
                     .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
               )
               .stream()
               .map(MesBuildingWarehouseRecord::getNumber)
               .collect(Collectors.toList())
         );
      }

      return map;
   }

   private void checkArtifactSavedWarehouseQuantity(MesBuildingWarehouseSummary record, Integer number) {
      if (record.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         ContractProject project = this.projectService.getById(record.getProjectId());
         if (project.getBoolRequiredWarehouse()) {
            List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class).eq(MesBuildingWarehouseStorageProduct::getWarehouseSummaryId, record.getId())
               );
            int sum = warehouseStorageProductList.stream().mapToInt(MesBuildingWarehouseStorageProduct::getQuantity).sum();
            Preconditions.checkArgument(record.getCargoQuantity().intValue() + record.getPackageQuantity().intValue() < sum, "操作失败,构件产品未保存库位!");
            if (number != null) {
               MesBuildingWarehouseStorageProduct warehouseStorageProduct = warehouseStorageProductList.stream()
                  .filter(wsp -> wsp.getNumber().equals(number))
                  .findFirst()
                  .orElse(null);
               Preconditions.checkArgument(warehouseStorageProduct != null, "操作失败,该产品未保存库位!");
               MesBuildingWarehouseRecord warehouseRecord = this.warehouseRecordService.getById(warehouseStorageProduct.getWarehouseRecordId());
               Preconditions.checkArgument(warehouseRecord != null, "操作失败,产品入库记录数据有误!!");
               Preconditions.checkArgument(warehouseRecord.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType()), "操作失败,构件产品已出库!!");
            }
         }
      }
   }

   @Override
   public MesBuildingWarehouseSummary updateQuantity(Long warehouseRecordId, BigDecimal quantity, Integer productType, int type) {
      MesBuildingWarehouseSummary record = this.baseMapper.selectById(warehouseRecordId);
      Preconditions.checkArgument(record != null, "库存记录不存在");
      BigDecimal useQuantity = record.getQuantity().subtract(record.getCargoQuantity()).subtract(record.getPackageQuantity());
      Preconditions.checkArgument(quantity.compareTo(useQuantity) <= 0, (type == 1 ? "打包" : "装车") + "数量不能超过剩余库存数量");
      if (type == 1) {
         record.setPackageQuantity(record.getPackageQuantity().add(quantity));
         if (productType != null) {
            Preconditions.checkArgument((productType & record.getProductType()) > 0, "仅支持相同类型打包");
         }
      } else {
         record.setCargoQuantity(record.getCargoQuantity().add(quantity));
      }

      this.baseMapper.updateById(record);
      return record;
   }

   @Override
   public List<ArtifactWarehouseTonVO> techArtifactWarehouseSummaryWarehouse() {
      BigDecimal in = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.INTO.getType(), new Date(), null);
      BigDecimal out = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.OUT.getType(), new Date(), null);
      ArtifactWarehouseTonVO vo1 = new ArtifactWarehouseTonVO();
      vo1.setKey("入库");
      vo1.setTon(in);
      ArtifactWarehouseTonVO vo2 = new ArtifactWarehouseTonVO();
      vo2.setKey("出库");
      vo2.setTon(out);
      ArtifactWarehouseTonVO vo3 = new ArtifactWarehouseTonVO();
      vo3.setKey("发运");
      vo3.setTon(out);
      List<ArtifactWarehouseTonVO> list = new ArrayList<>();
      list.add(vo1);
      list.add(vo2);
      list.add(vo3);
      return list;
   }

   @Override
   public ProductionCapacityVO productionCapacity() {
      BigDecimal targetProduction = this.baseMapper.getTargetProduction();
      BigDecimal yearTargetProduction = NumberUtil.mul(targetProduction, 12);
      BigDecimal monthProduction = this.baseMapper.getProduction(new Date(), WarehouseTypeEnum.INTO.getType(), "%Y-%m");
      BigDecimal lastMonthProduction = this.baseMapper.getProduction(DateUtil.lastMonth(), WarehouseTypeEnum.INTO.getType(), "%Y-%m");
      BigDecimal productionThanLastRate = NumberUtil.round(NumberUtil.div(monthProduction, lastMonthProduction), 2);
      int thisDayOfMonth = DateUtil.thisDayOfMonth();
      BigDecimal avgDayTon = BigDecimal.ZERO;
      if (monthProduction.compareTo(BigDecimal.ZERO) != 0 && thisDayOfMonth != 0) {
         avgDayTon = NumberUtil.round(NumberUtil.div(monthProduction, thisDayOfMonth), 2);
      }

      BigDecimal yearProduction = this.baseMapper.getProduction(new Date(), WarehouseTypeEnum.OUT.getType(), "%Y");
      ProductionCapacityVO vo = new ProductionCapacityVO();
      vo.setYearTargetProduction(yearTargetProduction);
      vo.setMonthProduction(monthProduction);
      vo.setPrevMonthProduction(lastMonthProduction);
      vo.setAvgDayProduction(avgDayTon);
      vo.setYearDespatchProduction(yearProduction);
      vo.setProductionThanLastRate(productionThanLastRate);
      return vo;
   }

   @Override
   public List<TonVO> techArtifactProductionAnalysis(String type) {
      if (Objects.isNull(type)) {
         type = QueryTypeEnum.DAY.getTypeEn();
      }

      List<TonVO> listVo = new ArrayList<>();
      if (type.equals(QueryTypeEnum.DAY.getTypeEn())) {
         listVo = this.baseMapper.getTonOfDimension(WarehouseTypeEnum.INTO.getType(), "%Y-%m-%d", 29);
      } else if (type.equals(QueryTypeEnum.MONTH.getTypeEn())) {
         listVo = this.baseMapper.getTonOfDimension(WarehouseTypeEnum.INTO.getType(), "%Y-%m", 11);
      } else if (type.equals(QueryTypeEnum.YEAY.getTypeEn())) {
         listVo = this.baseMapper.getTonOfDimension(WarehouseTypeEnum.INTO.getType(), "%Y", 9);
      }

      return listVo;
   }

   @Override
   public List<WorkShopTonVO> manufacturingDeptProduction(String type) {
      if (Objects.isNull(type)) {
         type = QueryTypeEnum.YEAY.getTypeEn();
      }

      Date now = new Date();
      List<WorkShopTonVO> listVo = new ArrayList<>();
      if (type.equals(QueryTypeEnum.DAY.getTypeEn())) {
         listVo = this.baseMapper.manufacturingDeptProduction("%Y-%m-%d", new Date());
      } else if (type.equals(QueryTypeEnum.MONTH.getTypeEn())) {
         listVo = this.baseMapper.manufacturingDeptProduction("%Y-%m", now);
      } else if (type.equals(QueryTypeEnum.YEAY.getTypeEn())) {
         for (MesBuildingWorkshop workshop : this.mesBuildingWorkshopService.list()) {
            List<WorkShopTonVO> workshopYearVo = this.baseMapper.manufacturingDeptProductionOfMonth(workshop.getId());
            int count = 0;
            int quarter = 0;
            BigDecimal ton = BigDecimal.ZERO;

            for (WorkShopTonVO vo : workshopYearVo) {
               BigDecimal tonVal = Objects.isNull(vo.getTon()) ? BigDecimal.ZERO : vo.getTon();
               count++;
               ton = ton.add(tonVal);
               if (count % 3 == 0) {
                  quarter++;
                  WorkShopTonVO tonVO = new WorkShopTonVO();
                  tonVO.setQuarter(quarter + "季度");
                  boolean flag = Objects.isNull(workshop.getShortName()) || StrUtil.isBlank(workshop.getShortName());
                  tonVO.setWorkShopShortName(flag ? workshop.getName() : workshop.getShortName());
                  tonVO.setTon(ton);
                  listVo.add(tonVO);
                  ton = BigDecimal.ZERO;
               }
            }
         }
      }

      return listVo;
   }

   @Override
   public BigDecimal techArtifactWarehouseSummaryStock() {
      BigDecimal in = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.INTO.getType(), null, null);
      BigDecimal out = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.OUT.getType(), null, null);
      BigDecimal rate = BigDecimal.ZERO;
      if (in.compareTo(BigDecimal.ZERO) != 0 && out.compareTo(BigDecimal.ZERO) != 0) {
         rate = NumberUtil.round(NumberUtil.sub(in, out), 2);
      }

      return rate;
   }

   @Override
   public BigDecimal techArtifactWarehouseSummaryRate() {
      BigDecimal in = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.INTO.getType(), new Date(), null);
      BigDecimal targetProduction = this.baseMapper.getTargetProduction();
      BigDecimal rate = BigDecimal.ZERO;
      if (in.compareTo(BigDecimal.ZERO) != 0 && targetProduction.compareTo(BigDecimal.ZERO) != 0) {
         rate = NumberUtil.round(NumberUtil.div(in, targetProduction), 2);
      }

      return rate;
   }

   @Override
   public List<TonVO> techArtifactWarehouseSummaryTrend() {
      List<TonVO> inRecentMonthTonVOs = this.baseMapper.getTonOfDimension(WarehouseTypeEnum.INTO.getType(), "%Y-%m-%d", 30);
      inRecentMonthTonVOs = inRecentMonthTonVOs.stream().peek(item -> item.setKey("当日入库吨位")).collect(Collectors.toList());
      List<TonVO> outRecentMonthTonVOs = this.baseMapper.getTonOfDimension(WarehouseTypeEnum.OUT.getType(), "%Y-%m-%d", 30);
      outRecentMonthTonVOs = outRecentMonthTonVOs.stream().peek(item -> item.setKey("当日发货吨位")).collect(Collectors.toList());
      List<TonVO> inAverageRecentMonthTonVOs = new ArrayList<>();
      BigDecimal tempInTon = BigDecimal.ZERO;

      for (int i = 0; i < inRecentMonthTonVOs.size(); i++) {
         TonVO recentMonthTonVO = inRecentMonthTonVOs.get(i);
         tempInTon = NumberUtil.add(tempInTon, recentMonthTonVO.getTon());
         TonVO vo = new TonVO();
         vo.setDateValue(recentMonthTonVO.getDateValue());
         vo.setTon(NumberUtil.round(NumberUtil.div(tempInTon, i + 1), 2));
         vo.setKey("日均入库吨位");
         inAverageRecentMonthTonVOs.add(vo);
      }

      List<TonVO> outAverageRecentMonthTonVOs = new ArrayList<>();
      BigDecimal tempOutTon = BigDecimal.ZERO;

      for (int i = 0; i < outRecentMonthTonVOs.size(); i++) {
         TonVO recentMonthTonVO = outRecentMonthTonVOs.get(i);
         tempOutTon = NumberUtil.add(tempOutTon, recentMonthTonVO.getTon());
         TonVO vo = new TonVO();
         vo.setDateValue(recentMonthTonVO.getDateValue());
         vo.setTon(NumberUtil.round(NumberUtil.div(tempOutTon, i + 1), 2));
         vo.setKey("日均发货吨位");
         outAverageRecentMonthTonVOs.add(vo);
      }

      List<TonVO> list = new ArrayList<>();
      list.addAll(inRecentMonthTonVOs);
      list.addAll(outRecentMonthTonVOs);
      list.addAll(inAverageRecentMonthTonVOs);
      list.addAll(outAverageRecentMonthTonVOs);
      return list;
   }

   @Override
   public BigDecimal manufacturingDeptProductionRate() {
      List<TaskProductionVO> buildingTaskList = this.taskService.getTaskProduction(new Date());
      BigDecimal rate = BigDecimal.ZERO;
      if (CollectionUtils.isNotEmpty(buildingTaskList)) {
         List<String> taskIds = buildingTaskList.stream().map(TaskProductionVO::getTaskId).collect(Collectors.toList());
         List<TaskProductionVO> completeProductionList = this.mesBuildingCompleteService.getCompleteProduction(new Date(), taskIds);
         BigDecimal taskTon = buildingTaskList.stream().map(TaskProductionVO::getTon).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal completeTon = completeProductionList.stream().map(TaskProductionVO::getTon).reduce(BigDecimal.ZERO, BigDecimal::add);
         rate = NumberUtil.round(NumberUtil.div(completeTon, taskTon), 2);
      }

      return rate;
   }

   @Override
   public List<ResponseVO> structureDespatchAndCarNumber(Long projectId) {
      return this.baseMapper.structureDespatchAndCarNumber(projectId);
   }

   @Override
   public BigDecimal carGoDetailTon() {
      return this.baseMapper.getProduction(new Date(), WarehouseTypeEnum.OUT.getType(), "%Y-%m-%d");
   }

   @Override
   public List<ResponseVO> overviewOfEnclosureProduction() {
      List<ResponseVO> list = new ArrayList<>();
      ResponseVO vo1 = new ResponseVO();
      vo1.setKey("彩板");
      vo1.setVal(new BigDecimal("2000"));
      ResponseVO vo2 = new ResponseVO();
      vo2.setKey("夹芯板");
      vo2.setVal(new BigDecimal("3000"));
      ResponseVO vo3 = new ResponseVO();
      vo3.setKey("楼承板");
      vo3.setVal(new BigDecimal("1500"));
      ResponseVO vo4 = new ResponseVO();
      vo4.setKey("檀条");
      vo4.setVal(new BigDecimal("3500"));
      list.add(vo1);
      list.add(vo2);
      list.add(vo3);
      list.add(vo4);
      return list;
   }

   @Override
   public List<ResponseVO> overviewOfEnclosureProductionOfMonth() {
      List<String> monthList = new ArrayList<>();

      for (int i = 1; i <= 6; i++) {
         monthList.add(DateUtil.format(DateUtil.offsetDay(new Date(), -i), "yyyy-MM-dd"));
      }

      List<ResponseVO> list = new ArrayList<>();

      for (String month : monthList) {
         ResponseVO vo1 = new ResponseVO();
         vo1.setKey("彩板");
         vo1.setKey(month);
         vo1.setVal(new BigDecimal("2000"));
         ResponseVO vo2 = new ResponseVO();
         vo2.setKey("夹芯板");
         vo1.setKey(month);
         vo2.setVal(new BigDecimal("3000"));
         ResponseVO vo3 = new ResponseVO();
         vo3.setKey("楼承板");
         vo1.setKey(month);
         vo3.setVal(new BigDecimal("1500"));
         ResponseVO vo4 = new ResponseVO();
         vo4.setKey("檀条");
         vo1.setKey(month);
         vo4.setVal(new BigDecimal("3500"));
         list.add(vo1);
         list.add(vo2);
         list.add(vo3);
         list.add(vo4);
      }

      return list;
   }

   @Override
   public List<ResponseVO> trafficVolumeOfEnclosure() {
      List<String> monthList = new ArrayList<>();

      for (int i = 1; i <= 6; i++) {
         monthList.add(DateUtil.format(DateUtil.offsetDay(new Date(), -i), "yyyy-MM-dd"));
      }

      List<ResponseVO> list = new ArrayList<>();

      for (String month : monthList) {
         ResponseVO vo1 = new ResponseVO();
         vo1.setKey("彩板");
         vo1.setKey(month);
         vo1.setVal(new BigDecimal("2000"));
         ResponseVO vo2 = new ResponseVO();
         vo2.setKey("夹芯板");
         vo1.setKey(month);
         vo2.setVal(new BigDecimal("3000"));
         ResponseVO vo3 = new ResponseVO();
         vo3.setKey("楼承板");
         vo1.setKey(month);
         vo3.setVal(new BigDecimal("1500"));
         ResponseVO vo4 = new ResponseVO();
         vo4.setKey("檀条");
         vo1.setKey(month);
         vo4.setVal(new BigDecimal("3500"));
         list.add(vo1);
         list.add(vo2);
         list.add(vo3);
         list.add(vo4);
      }

      return list;
   }

   @Override
   public BigDecimal sumOutTon(Long projectId) {
      return this.baseMapper.sumOutTon(projectId);
   }

   @Override
   public Map<String, Object> techArtifactProduceOutInfo(Long projectId) {
      BigDecimal inventoryTon = this.techArtifactService.sumTnventoryTon(projectId);
      BigDecimal produceTon = this.mesBuildingCompleteService.sumProduceTon(projectId);
      BigDecimal produceRate = BigDecimal.ZERO;
      if (produceTon.compareTo(BigDecimal.ZERO) != 0 && inventoryTon.compareTo(BigDecimal.ZERO) != 0) {
         produceRate = NumberUtil.round(NumberUtil.div(produceTon, inventoryTon), 2);
      }

      BigDecimal outTon = this.sumOutTon(projectId);
      BigDecimal outRate = BigDecimal.ZERO;
      if (outTon.compareTo(BigDecimal.ZERO) != 0 && inventoryTon.compareTo(BigDecimal.ZERO) != 0) {
         outRate = NumberUtil.round(NumberUtil.div(outTon, inventoryTon), 2);
      }

      BigDecimal inT = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.INTO.getType(), null, projectId);
      BigDecimal outT = this.baseMapper.artifactWarehouseTon(WarehouseTypeEnum.OUT.getType(), null, projectId);
      BigDecimal stockTon = NumberUtil.round(NumberUtil.sub(inT, outT), 2);
      BigDecimal inQuantity = this.baseMapper.artifactWarehouseQuantity(WarehouseTypeEnum.INTO.getType(), null, projectId);
      BigDecimal outQuantity = this.baseMapper.artifactWarehouseQuantity(WarehouseTypeEnum.OUT.getType(), null, projectId);
      BigDecimal stockQuantity = NumberUtil.round(NumberUtil.sub(inQuantity, outQuantity), 2);
      HashMap<String, Object> map = new HashMap<>();
      map.put("produceRate", produceRate);
      map.put("outRate", outRate);
      map.put("produceTon", produceTon);
      map.put("outTon", outTon);
      map.put("stockQuantity", stockQuantity);
      map.put("stockTon", stockTon);
      map.put("inventoryTon", inventoryTon);
      return map;
   }

   @Override
   public Map<String, Object> techArtifactInventoryInfo(Long projectId) {
      BigDecimal techArtifactInventoryTon = this.techArtifactService.sumTnventoryTon(projectId);
      BigDecimal techAssembleInventoryTon = this.techAssembleService.sumTnventoryTon(projectId);
      BigDecimal techMachinePartInventoryTon = this.techMachinePartService.sumTnventoryTon(projectId);
      HashMap<String, Object> map = new HashMap<>();
      map.put("techArtifactInventoryTon", techArtifactInventoryTon);
      map.put("techAssembleInventoryTon", techAssembleInventoryTon);
      map.put("techMachinePartInventoryTon", techMachinePartInventoryTon);
      return map;
   }

   @Override
   public List<MesBuildingProductionTaskDTO> produceStatisticsFinishList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      return this.baseMapper.produceStatisticsFinishList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId);
   }

   @Override
   public List<KevMeteDO> listUnCarQuantity(Integer type, List<Long> ids, Long workshopId) {
      return this.baseMapper.listUnCarQuantity(type, ids, workshopId);
   }

   @Override
   public List<MesEnclosureWarehouseSummaryDTO> findEnclosureWarehouse(Long orderId, List<Long> taskIds) {
      return this.baseMapper.findEnclosureWarehouse(orderId, taskIds);
   }

   @Override
   public List<UnEqualDTO> listUnEqual() {
      return this.baseMapper.listUnEqual();
   }

   @Override
   public List<MesBuildingWarehouseSummary> findAllWarehouseSummary(List<Long> projectIds, Integer type) {
      return this.baseMapper.findAllWarehouseSummary(projectIds, type);
   }

   @Override
   public List<MesBuildingWarehouseSummary> listWareHouseSummary(List<AddWarehouseDTO> addWarehouseDTOS) {
      return this.baseMapper.listWareHouseSummary(addWarehouseDTOS);
   }

   @Override
   public List<MesBuildingWarehouseSummary> listSummarysByData(List<MesBuildingLineChangeListDTO> listDtos) {
      return this.baseMapper.listSummarysByData(listDtos);
   }

   @Override
   public BigDecimal selectTotalReceive(List<Long> projectIds, Long projectId, List<Long> workshopIds, Integer year) {
      return this.baseMapper.selectTotalReceive(projectIds, projectId, workshopIds, year);
   }

   @Override
   public PageVO listArtifactPrint(WareSubscribeArtifactPrintDOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize(), StringUtils.analyzeSortConditions(param.getSort()));
      List<WareSubscribeArtifactPrintDO> taskArtifactPrintDOS = this.baseMapper.listArtifactPrint(param);
      return new PageVO<>(taskArtifactPrintDOS);
   }

   @Override
   public PageVO listEnclosurePrint(
      Long projectId,
      Long planId,
      Integer category,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.baseMapper.listEnclosurePrint(projectId, planId, category, name, serialNumber, specification, material));
   }

   @Override
   public PageVO listTechStandardPartPrint(AuxiliaryMaterialPrintDTOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      return new PageVO<>(this.baseMapper.listTechStandardPart(param));
   }

   @Override
   public List<KevMeteDO> getProductOutMeteDetailV2(List<LocalDate> dateList, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductOutMeteDetailV2(dateList, yearDate, branchCompanyId, workshopId);
   }

   @Override
   public List<KevMeteDO> getProductOutMete(List<LocalDate> dateList, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductOutMete(dateList, branchCompanyId, workshopId);
   }
}
