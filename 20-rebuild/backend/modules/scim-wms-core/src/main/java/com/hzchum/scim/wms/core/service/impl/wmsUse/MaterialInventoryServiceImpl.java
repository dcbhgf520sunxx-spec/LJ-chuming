package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.pojo._do.WmsPlantPart;
import com.hzchum.scim.cut.core.api.service.WmsPlantPartService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysSteelClassifyLinkService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsSectionSteelControlTable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsBeginPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriodClosing;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WmsMaterialWarehouseConfigDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OtherMaterialInventoryImportDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectToFreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SteelMaterialInventoryImportDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SteelWeightDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.VirtualMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeviceQueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialIdsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialWarehouseConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsSectionSteelControlTableService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsBeginPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodClosingMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMonthRecordMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.SupplementMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import javax.validation.constraints.NotNull;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaterialInventoryServiceImpl extends ServiceImpl<MaterialInventoryMapper, MaterialInventory> implements MaterialInventoryService {
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   WorkshopService workshopService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MaterialFreezeMapper materialFreezeMapper;
   @Resource
   MaterialFreezeRecordService materialFreezeRecordService;
   @Resource
   private SysSteelClassificationService sysSteelClassificationService;
   @Resource
   private SysSteelClassifyLinkService sysSteelClassifyLinkService;
   @Resource
   private StatisticsMonthRecordMapper statisticsMonthRecordMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsBeginPeriodMapper statisticsBeginPeriodMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   PlanMonomerService monomerService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   WmsMaterialWarehouseConfigService wmsMaterialWarehouseConfigService;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   WmsClosingTimeService wmsClosingTimeService;
   @Resource
   StatisticsEndPeriodClosingMapper statisticsEndPeriodClosingMapper;
   @Resource
   WmsSectionSteelControlTableService wmsSectionSteelControlTableService;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   SupplementMapper supplementMapper;
   @Resource
   NumberConfigService numberConfigService;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   WmsPlantPartService wmsPlantPartService;
   @Resource
   private OutboundService outboundService;

   @Override
   public PageVO<MaterialInventoryDTO> pageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         List<String> split = StrUtil.split(replace, ",");
         if (split.size() > 1) {
            param.setSplit(split);
            param.setHeatNoAndBatchNo(null);
         }
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MaterialInventory> pageInfo = PageHelper.<MaterialInventory>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfo(param));
      List<MaterialInventoryDTO> materialInventoryDTO1 = this.getMaterialInventoryDTO1(pageInfo.getList());
      return new PageVO<>(pageInfo, materialInventoryDTO1);
   }

   @Override
   public PageVO<MaterialInventoryDTO> devicePageInfo(DeviceQueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      List<Classification> classifications = this.classificationService
         .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getName, "设备备件"));
      ArrayList<Long> objects = new ArrayList<>();
      classifications.forEach(
         classification -> {
            if (!classification.getBoolLastEnum()) {
               List<Long> collect = this.classificationService
                  .getLastSubject(classification.getId())
                  .stream()
                  .map(Classification::getId)
                  .collect(Collectors.toList());
               objects.addAll(collect);
            } else {
               objects.add(classification.getId());
            }
         }
      );
      if (CollectionUtil.isNotEmpty(objects)) {
         param.setClassifyIds(objects);
         String s = StringUtils.analyzeSortConditions(sort);
         PageInfo<MaterialInventory> pageInfo = PageHelper.<MaterialInventory>startPage(pageNumber, pageSize, s)
            .doSelectPageInfo(() -> this.deviceListInfo(param));
         List<MaterialInventoryDTO> materialInventoryDTO1 = this.getMaterialInventoryDTO1(pageInfo.getList());
         return new PageVO<>(pageInfo, materialInventoryDTO1);
      } else {
         return new PageVO<>(new PageInfo(), new ArrayList<>());
      }
   }

   @Override
   public List<MaterialInventoryDTO> getSteelPlateDetail(QueryByMaterialDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }

      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         List<String> split = StrUtil.split(replace, ",");
         if (split.size() > 1) {
            param.setSplit(split);
            param.setHeatNoAndBatchNo(null);
         }
      }

      List<MaterialInventory> materialInventories = this.listInfo(param);
      return this.getMaterialInventoryDTO1(materialInventories);
   }

   @Override
   public Map<String, List<MaterialInventoryDTO>> getSteelPlateDetailGroupByClassifyName(Integer basicClass, List<String> classifyNames) {
      List<MaterialInventory> materialInventories = this.materialInventoryMapper.getSteelPlateDetailGroupByClassifyName(basicClass, classifyNames);
      List<MaterialInventoryDTO> materialInventoryDTOList = this.getMaterialInventoryDTO1(materialInventories);
      return materialInventoryDTOList.stream().collect(Collectors.groupingBy(MaterialInventoryDTO::getClassifyName));
   }

   @NotNull
   private MaterialInventoryDTO getMaterialInventoryDTO(MaterialInventory materialInventory) {
      MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(materialInventory, MaterialInventoryDTO.class);
      materialInventoryDTO.setNationalStandard(materialInventory.getStandardName());
      Workshop workshop = this.workshopService.getById(materialInventory.getWorkshopId());
      if (workshop != null) {
         materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      Warehouse warehouse = this.warehouseService.getById(materialInventory.getWarehouseId());
      if (warehouse != null) {
         materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      }

      materialInventoryDTO.setSerialNumber(this.classificationService.getById(materialInventory.getClassifyId()).getSerialNumber());
      if (materialInventory.getProjectId() != null) {
         materialInventoryDTO.setProject(this.contractProjectService.getSimpleById(materialInventory.getProjectId()));
      }

      if (materialInventory.getMonomerId() != null) {
         materialInventoryDTO.setMonomerName(this.monomerService.getById(materialInventory.getMonomerId()).getName());
      }

      if (materialInventory.getAreaId() != null) {
         materialInventoryDTO.setAreaName(this.planAreaService.getById(materialInventory.getAreaId()).getName());
      }

      MaterialFreeze materialFreeze = this.materialFreezeMapper
         .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      materialInventoryDTO.setFrozenMete(
         materialFreeze != null
            ? (materialFreeze.getTotalMete().compareTo(materialInventory.getMete()) > 0 ? materialInventory.getMete() : materialFreeze.getTotalMete())
            : BigDecimal.ZERO
      );
      materialInventoryDTO.setFrozenQuantity(materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO);
      materialInventoryDTO.setBoolHasFrozen(materialFreeze != null);
      List<MaterialFreezeRecord> materialFreezeRecordList = this.materialFreezeRecordService
         .list(
            (Wrapper<MaterialFreezeRecord>)(new LambdaQueryWrapper<MaterialFreezeRecord>()
                  .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze == null ? null : materialFreeze.getId()))
               .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType())
         );
      if (CollectionUtils.isNotEmpty(materialFreezeRecordList)) {
         List<ProjectToFreezeDTO> projectToFreezeDTOS = materialFreezeRecordList.stream()
            .map(e -> BeanUtil.copy(e, ProjectToFreezeDTO.class))
            .collect(Collectors.toList());
         materialInventoryDTO.setProjectFrozen(projectToFreezeDTOS);
      }

      return materialInventoryDTO;
   }

   @NotNull
   @Override
   public List<MaterialInventoryDTO> getMaterialInventoryDTO1(List<MaterialInventory> materialInventories) {
      if (CollectionUtil.isEmpty(materialInventories)) {
         return new ArrayList<>();
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<Long> collect1 = materialInventories.stream().map(MaterialInventory::getClassifyId).collect(Collectors.toList());
      Map<Long, Classification> classificationMap = this.queryUtil.getClassificationMap(collect1);
      Map<Long, MesBuildingFactory> factoryMap = this.queryUtil.getFactoryMap(null);
      Map<Long, Workshop> workshopMap = this.queryUtil.getWorkshopMap(null);
      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      List<Long> projectIdList = materialInventories.stream().map(MaterialInventory::getProjectId).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(projectIdList);
      List<Long> marketIdList = materialInventories.stream().map(MaterialInventory::getId).collect(Collectors.toList());
      Map<Long, MaterialFreeze> materialFreezeMap = this.queryUtil.getMaterialFreezeMap(marketIdList);
      Map<Long, List<MaterialFreezeRecord>> materialFreezeRecordMap = this.queryUtil.getMaterialFreezeRecordMap(MaterialFreezeTypeEnum.STOCK.getType());
      return materialInventories.stream()
         .map(
            materialInventory -> {
               MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(materialInventory, MaterialInventoryDTO.class);
               if (materialInventory.getWorkshopId() != null) {
                  Workshop workshop = workshopMap.get(materialInventory.getWorkshopId());
                  materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               if (StrUtil.isNotBlank(materialInventory.getImgUrl())) {
                  String s1 = this.configProperties.getUrl();
                  materialInventoryDTO.setImgUrl(s1 + "files/" + materialInventory.getImgUrl());
               }

               Warehouse warehouse = warehouseMap.get(materialInventory.getWarehouseId());
               if (warehouse != null) {
                  materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               materialInventoryDTO.setSerialNumber(classificationMap.get(materialInventory.getClassifyId()).getSerialNumber());
               if (materialInventory.getProjectId() != null) {
                  ContractProject contractProject = projectMap.get(materialInventory.getProjectId());
                  ProjectInfo copy = BeanUtil.copy(contractProject, ProjectInfo.class);
                  materialInventoryDTO.setProject(copy);
               }

               MaterialFreeze materialFreeze = materialFreezeMap.get(materialInventory.getId());
               materialInventoryDTO.setFrozenMete(
                  materialFreeze != null
                     ? (materialFreeze.getTotalMete().compareTo(materialInventory.getMete()) > 0 ? materialInventory.getMete() : materialFreeze.getTotalMete())
                     : BigDecimal.ZERO
               );
               materialInventoryDTO.setFrozenQuantity(materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO);
               materialInventoryDTO.setBoolHasFrozen(materialFreeze != null);
               if (materialFreeze != null) {
                  List<MaterialFreezeRecord> materialFreezeRecordList = materialFreezeRecordMap.get(materialFreeze.getId());
                  if (CollectionUtils.isNotEmpty(materialFreezeRecordList)) {
                     List<ProjectToFreezeDTO> projectToFreezeDTOS = materialFreezeRecordList.stream()
                        .map(e -> BeanUtil.copy(e, ProjectToFreezeDTO.class))
                        .collect(Collectors.toList());
                     materialInventoryDTO.setProjectFrozen(projectToFreezeDTOS);
                  }
               }

               MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(materialInventory);
               if (price != null) {
                  if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                     WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                     if (wholeWeightedAveragePrice != null) {
                        price.setMete(wholeWeightedAveragePrice.getMete());
                        price.setAmount(wholeWeightedAveragePrice.getAmount());
                        price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                     }
                  }

                  BigDecimal p = materialInventoryDTO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                  BigDecimal amount = price.getAmount().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(this.amountAccuracy, RoundingMode.HALF_UP);
                  BigDecimal avgPrice = NumberUtil.div(amount, materialInventoryDTO.getMete(), 12);
                  BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, materialInventoryDTO.getMete(), 12);
                  materialInventoryDTO.setAmount(amount);
                  materialInventoryDTO.setAmountExcludingVAT(amountExcludingVat);
                  materialInventoryDTO.setUnitPrice(avgPrice);
                  materialInventoryDTO.setUnitPriceExcludingVAT(excludingVatAvgPrice);
               } else {
                  materialInventoryDTO.setAmount(BigDecimal.ZERO);
                  materialInventoryDTO.setAmountExcludingVAT(BigDecimal.ZERO);
                  materialInventoryDTO.setUnitPrice(BigDecimal.ZERO);
                  materialInventoryDTO.setUnitPriceExcludingVAT(BigDecimal.ZERO);
               }

               return materialInventoryDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MaterialInventory> listInfo(QueryByMaterialDTOParam param) {
      return this.materialInventoryMapper.listInfo(param);
   }

   @Override
   public List<MaterialInventory> deviceListInfo(DeviceQueryByMaterialDTOParam param) {
      return this.materialInventoryMapper.listInfoForDevice(param);
   }

   @Override
   public MaterialInventory getByInboundDetail(InboundDetail inboundDetail) {
      return this.materialInventoryMapper.getByInboundDetail(inboundDetail);
   }

   @Override
   public MaterialInventory getByBeginInboundDetail(InboundDetail inboundDetail) {
      return this.materialInventoryMapper.getByBeginInboundDetail(inboundDetail);
   }

   @Override
   public MaterialInventory getBySurplusDetail(WmsSurplusDetail WmsSurplusDetail) {
      return this.materialInventoryMapper.getBySurplusDetail(WmsSurplusDetail);
   }

   @Override
   public MaterialInventory getByMaterial(MaterialInventory materialInventory) {
      return this.materialInventoryMapper.getByMaterial(materialInventory);
   }

   @Override
   public MaterialInventory getByMoveMaterialDetail(MoveMaterialDetail wmsMoveMaterialDetail) {
      return this.materialInventoryMapper.getByMoveMaterialDetail(wmsMoveMaterialDetail);
   }

   @Override
   public MaterialInventoryDTO getMatById(Long id) {
      MaterialInventory materialInventory = this.materialInventoryMapper.selectById(id);
      return materialInventory != null ? this.getMaterialInventoryDTO(materialInventory) : null;
   }

   @Override
   public ListVO<MaterialInventoryDTO> getMatByIds(QueryByMaterialIdsDTOParam param) {
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(param.getIds()), "请传物料id");
      List<MaterialInventory> materialInventories = this.materialInventoryMapper.selectBatchIds(param.getIds());
      List<MaterialInventoryDTO> materialInventoryDTO1 = this.getMaterialInventoryDTO1(materialInventories);
      return new ListVO<>(materialInventoryDTO1);
   }

   @Override
   public ListVO<MaterialInventoryDTO> getByClassIds(QueryByMaterialIdsDTOParam param) {
      List<MaterialInventory> materialInventories = this.materialInventoryMapper
         .selectList(
            (Wrapper<MaterialInventory>)(new LambdaQueryWrapper<MaterialInventory>().in(MaterialInventory::getClassifyId, param.getIds()))
               .eq(MaterialInventory::getBoolPartyA, param.getBoolPartyA())
         );
      ArrayList<MaterialInventoryDTO> objects = new ArrayList<>();
      materialInventories.forEach(materialInventory -> {
         MaterialInventoryDTO materialInventoryDTO = this.getMaterialInventoryDTO(materialInventory);
         objects.add(materialInventoryDTO);
      });
      return new ListVO<>(objects);
   }

   @Override
   public void updateBoolHasFrozen(Long id, Boolean bool) {
      this.materialInventoryMapper.updateBoolHasFrozen(id, bool);
   }

   @Override
   public BigDecimal getMeteById(Long classifyId) {
      return this.materialInventoryMapper.getMeteById(classifyId);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void materialMonthSummary() {
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);

      for (Statistics statistics : this.statisticsMapper.selectList(null)) {
         StatisticsMonthRecord record = BeanUtil.copy(statistics, StatisticsMonthRecord.class, "createTime");
         record.setStatId(statistics.getId());
         record.setUpdateTime(LocalDateTime.now().minusMonths(1L));
         record.setWeightedPriceType(weightedPriceConf.getWeightedType());
         this.statisticsMonthRecordMapper.insert(record);
         if (statistics.getEndMete() != null && statistics.getEndMete().compareTo(BigDecimal.ZERO) > 0) {
            statistics.setInboundMete(null);
            statistics.setInboundQuantity(null);
            statistics.setInboundUnitPrice(null);
            statistics.setInboundUnitPriceExcludingVat(null);
            statistics.setInboundAmount(null);
            statistics.setInboundAmountExcludingVat(null);
            statistics.setOutboundMete(null);
            statistics.setOutboundQuantity(null);
            statistics.setOutboundAmount(null);
            statistics.setOutboundAmountExcludingVat(null);
            statistics.setOutboundUnitPrice(null);
            statistics.setOutboundUnitPriceExcludingVat(null);
            statistics.setEndUnitPriceExcludingVat(null);
            statistics.setEndUnitPrice(null);
            statistics.setEndAmount(null);
            statistics.setEndAmountExcludingVat(null);
            statistics.setInboundUnitPriceNoFreight(null);
            statistics.setInboundUnitPriceExcludingVatNoFreight(null);
            statistics.setInboundAmountNoFreight(null);
            statistics.setInboundAmountExcludingVatNoFreight(null);
            statistics.setOutboundAmountNoFreight(null);
            statistics.setOutboundAmountExcludingVatNoFreight(null);
            statistics.setOutboundUnitPriceNoFreight(null);
            statistics.setOutboundUnitPriceExcludingVatNoFreight(null);
            statistics.setEndUnitPriceExcludingVatNoFreight(null);
            statistics.setEndUnitPriceNoFreight(null);
            statistics.setEndAmountNoFreight(null);
            statistics.setEndAmountExcludingVatNoFreight(null);
            statistics.setTransferUnitPriceExcludingVat(null);
            statistics.setTransferUnitPrice(null);
            statistics.setTransferUnitPriceExcludingVatNoFreight(null);
            statistics.setTransferUnitPriceNoFreight(null);
            statistics.setTransferAmount(null);
            statistics.setTransferAmountNoFreight(null);
            statistics.setTransferAmountExcludingVat(null);
            statistics.setTransferAmountExcludingVatNoFreight(null);
            statistics.setTransferMete(null);
            statistics.setTransferQuantity(null);
            this.statisticsMapper.updateById(statistics);
         } else {
            this.statisticsMapper.deleteById(statistics.getId());
         }
      }

      for (StatisticsEndPeriod statisticsEndPeriod : this.statisticsEndPeriodMapper.selectList(null)) {
         if (statisticsEndPeriod.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.statisticsEndPeriodMapper.deleteById(statisticsEndPeriod);
         } else {
            StatisticsBeginPeriod beginPeriod = BeanUtil.copy(statisticsEndPeriod, StatisticsBeginPeriod.class, "createTime");
            this.statisticsBeginPeriodMapper.insert(beginPeriod);
            statisticsEndPeriod.setUnitPrice(null);
            statisticsEndPeriod.setUnitPriceExcludingVat(null);
            statisticsEndPeriod.setAmount(null);
            statisticsEndPeriod.setAmountExcludingVat(null);
            this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
         }
      }

      if (weightedPriceConf.getBoolUpdate()) {
         weightedPriceConf.setWeightedType(
            WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())
               ? WeightedPriceEnum.WHOLE.getType()
               : WeightedPriceEnum.SINGLE.getType()
         );
         weightedPriceConf.setBoolUpdate(false);
         String value = JSON.toJSONString(weightedPriceConf);
         basicConfig.setValue(value);
         this.basicConfigService.updateById(basicConfig);
      }
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public void materialMonthSummaryUser(WmsClosingTime build) {
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      WmsClosingTime one = this.wmsClosingTimeService
         .getOne(
            (Wrapper<WmsClosingTime>)((new LambdaQueryWrapper<WmsClosingTime>().lt(WmsClosingTime::getId, build.getId()))
                  .orderByDesc(WmsClosingTime::getId))
               .last("limit 1")
         );

      for (Statistics statistics : this.statisticsMapper.selectList(null)) {
         StatisticsMonthRecord record = BeanUtil.copy(statistics, StatisticsMonthRecord.class, "createTime");
         record.setStatId(statistics.getId());
         record.setUpdateTime(LocalDateTime.now().minusMonths(1L));
         record.setWeightedPriceType(weightedPriceConf.getWeightedType());
         record.setWmsClosingTimeId(build.getId());
         statistics.setInboundMete(null);
         statistics.setInboundQuantity(null);
         statistics.setInboundUnitPrice(null);
         statistics.setInboundUnitPriceExcludingVat(null);
         statistics.setInboundAmount(null);
         statistics.setInboundAmountExcludingVat(null);
         statistics.setInboundUnitPriceNoFreight(null);
         statistics.setInboundUnitPriceExcludingVatNoFreight(null);
         statistics.setInboundAmountNoFreight(null);
         statistics.setInboundAmountExcludingVatNoFreight(null);
         statistics.setOutboundMete(null);
         statistics.setOutboundQuantity(null);
         statistics.setOutboundAmount(null);
         statistics.setOutboundAmountExcludingVat(null);
         statistics.setOutboundUnitPrice(null);
         statistics.setOutboundUnitPriceExcludingVat(null);
         statistics.setOutboundAmountNoFreight(null);
         statistics.setOutboundAmountExcludingVatNoFreight(null);
         statistics.setOutboundUnitPriceNoFreight(null);
         statistics.setOutboundUnitPriceExcludingVatNoFreight(null);
         statistics.setTransferUnitPriceExcludingVat(null);
         statistics.setTransferUnitPrice(null);
         statistics.setTransferUnitPriceExcludingVatNoFreight(null);
         statistics.setTransferUnitPriceNoFreight(null);
         statistics.setTransferAmount(null);
         statistics.setTransferAmountNoFreight(null);
         statistics.setTransferAmountExcludingVat(null);
         statistics.setTransferAmountExcludingVatNoFreight(null);
         statistics.setTransferMete(null);
         statistics.setTransferQuantity(null);
         List<StatisticsInbound> inboundDetailList = this.statisticsInboundMapper
            .selectList(
               (Wrapper<StatisticsInbound>)((new LambdaQueryWrapper<StatisticsInbound>()
                        .eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                     .in(StatisticsInbound::getReceiptType, ReceiptTypeEnum.getInbound()))
                  .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " BETWEEN {0} AND {1}", build.getStartTime(), build.getEndTime())
            );
         List<StatisticsInbound> transferDetailList = this.statisticsInboundMapper
            .selectList(
               (Wrapper<StatisticsInbound>)((new LambdaQueryWrapper<StatisticsInbound>()
                        .eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                     .notIn(StatisticsInbound::getReceiptType, ReceiptTypeEnum.getInbound()))
                  .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " BETWEEN {0} AND {1}", build.getStartTime(), build.getEndTime())
            );
         List<StatisticsOutbound> outboundDetailList = this.statisticsOutboundMapper
            .selectList(
               (Wrapper<StatisticsOutbound>)(new LambdaQueryWrapper<StatisticsOutbound>().eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
                  .between(StatisticsOutbound::getOutboundTime, build.getStartTime(), build.getEndTime())
            );
         BigDecimal endMete = BigDecimal.ZERO;
         BigDecimal endQuantity = BigDecimal.ZERO;
         BigDecimal endAmountExcludingVat = BigDecimal.ZERO;
         BigDecimal endAmount = BigDecimal.ZERO;
         BigDecimal endAmountNoFreight = BigDecimal.ZERO;
         BigDecimal endAmountExcludingVatNoFreight = BigDecimal.ZERO;
         if (one != null) {
            List<StatisticsBeginPeriod> beginDetailList = this.statisticsBeginPeriodMapper
               .selectList(
                  (Wrapper<StatisticsBeginPeriod>)(new LambdaQueryWrapper<StatisticsBeginPeriod>().eq(StatisticsBeginPeriod::getStatisticsId, statistics.getId()))
                     .eq(StatisticsBeginPeriod::getWmsClosingTimeId, one.getId())
               );
            if (CollectionUtil.isNotEmpty(beginDetailList)) {
               BigDecimal beginDetailAmountExcludingVatReduce = beginDetailList.stream()
                  .map(StatisticsBeginPeriod::getAmountExcludingVat)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal beginDetailAmountReduce = beginDetailList.stream()
                  .map(StatisticsBeginPeriod::getAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal beginDetailAmountReduceNoFreight = beginDetailList.stream()
                  .map(StatisticsBeginPeriod::getAmountNoFreight)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal beginDetailAmountExcludingVatReduceNoFreight = beginDetailList.stream()
                  .map(StatisticsBeginPeriod::getAmountExcludingVatNoFreight)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal beginDetailMeteReduce = beginDetailList.stream()
                  .map(StatisticsBeginPeriod::getMete)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal beginDetailQuantityReduce = beginDetailList.stream()
                  .map(StatisticsBeginPeriod::getQuantity)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               endMete = endMete.add(beginDetailMeteReduce);
               endQuantity = endQuantity.add(beginDetailQuantityReduce);
               endAmountExcludingVat = endAmountExcludingVat.add(beginDetailAmountExcludingVatReduce);
               endAmount = endAmount.add(beginDetailAmountReduce);
               endAmountNoFreight = endAmountNoFreight.add(beginDetailAmountReduceNoFreight);
               endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(beginDetailAmountExcludingVatReduceNoFreight);
            }
         }

         if (CollectionUtil.isNotEmpty(inboundDetailList)) {
            BigDecimal inboundDetailAmountExcludingVatReduce = inboundDetailList.stream()
               .map(StatisticsInbound::getAmountExcludingVat)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduce = inboundDetailList.stream()
               .map(StatisticsInbound::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduceNoFreight = inboundDetailList.stream()
               .map(StatisticsInbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = inboundDetailList.stream()
               .map(StatisticsInbound::getAmountExcludingVatNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailMeteReduce = inboundDetailList.stream()
               .map(StatisticsInbound::getMete)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailQuantityReduce = inboundDetailList.stream()
               .map(StatisticsInbound::getQuantity)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endMete = endMete.add(inboundDetailMeteReduce);
            endQuantity = endQuantity.add(inboundDetailQuantityReduce);
            endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
            endAmount = endAmount.add(inboundDetailAmountReduce);
            endAmountNoFreight = endAmountNoFreight.add(inboundDetailAmountReduceNoFreight);
            endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(inboundDetailAmountExcludingVatReduceNoFreight);
            record.setInboundAmountExcludingVat(inboundDetailAmountExcludingVatReduce);
            record.setInboundAmount(inboundDetailAmountReduce);
            record.setInboundMete(inboundDetailMeteReduce);
            record.setInboundQuantity(inboundDetailQuantityReduce);
            record.setInboundAmountNoFreight(inboundDetailAmountReduceNoFreight);
            record.setInboundAmountExcludingVatNoFreight(inboundDetailAmountExcludingVatReduceNoFreight);
            if (inboundDetailMeteReduce.compareTo(BigDecimal.ZERO) != 0) {
               record.setInboundUnitPrice(NumberUtil.div(inboundDetailAmountReduce, inboundDetailMeteReduce, 12));
               record.setInboundUnitPriceExcludingVat(NumberUtil.div(inboundDetailAmountExcludingVatReduce, inboundDetailMeteReduce, 12));
               record.setInboundUnitPriceNoFreight(NumberUtil.div(inboundDetailAmountReduceNoFreight, inboundDetailMeteReduce, 12));
               record.setInboundUnitPriceExcludingVatNoFreight(NumberUtil.div(inboundDetailAmountExcludingVatReduceNoFreight, inboundDetailMeteReduce, 12));
            }
         } else {
            record.setInboundAmountExcludingVat(null);
            record.setInboundAmount(null);
            record.setInboundAmountNoFreight(null);
            record.setInboundAmountExcludingVatNoFreight(null);
            record.setInboundMete(null);
            record.setInboundQuantity(null);
            record.setInboundUnitPriceNoFreight(null);
            record.setInboundUnitPriceExcludingVatNoFreight(null);
            record.setInboundUnitPrice(null);
            record.setInboundUnitPriceExcludingVat(null);
         }

         if (CollectionUtil.isNotEmpty(transferDetailList)) {
            BigDecimal inboundDetailAmountExcludingVatReduce = transferDetailList.stream()
               .map(StatisticsInbound::getAmountExcludingVat)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduce = transferDetailList.stream()
               .map(StatisticsInbound::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduceNoFreight = transferDetailList.stream()
               .map(StatisticsInbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = transferDetailList.stream()
               .map(StatisticsInbound::getAmountExcludingVatNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailMeteReduce = transferDetailList.stream()
               .map(StatisticsInbound::getMete)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailQuantityReduce = transferDetailList.stream()
               .map(StatisticsInbound::getQuantity)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endMete = endMete.add(inboundDetailMeteReduce);
            endQuantity = endQuantity.add(inboundDetailQuantityReduce);
            endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
            endAmount = endAmount.add(inboundDetailAmountReduce);
            endAmountNoFreight = endAmountNoFreight.add(inboundDetailAmountReduceNoFreight);
            endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.add(inboundDetailAmountExcludingVatReduceNoFreight);
            record.setTransferAmountExcludingVat(inboundDetailAmountExcludingVatReduce);
            record.setTransferAmount(inboundDetailAmountReduce);
            record.setTransferAmountNoFreight(inboundDetailAmountReduceNoFreight);
            record.setTransferAmountExcludingVatNoFreight(inboundDetailAmountExcludingVatReduceNoFreight);
            record.setTransferMete(inboundDetailMeteReduce);
            record.setTransferQuantity(inboundDetailQuantityReduce);
            if (inboundDetailMeteReduce.compareTo(BigDecimal.ZERO) != 0) {
               record.setTransferUnitPrice(NumberUtil.div(inboundDetailAmountReduce, inboundDetailMeteReduce, 12));
               record.setTransferUnitPriceExcludingVat(NumberUtil.div(inboundDetailAmountExcludingVatReduce, inboundDetailMeteReduce, 12));
               record.setTransferUnitPriceNoFreight(NumberUtil.div(inboundDetailAmountReduceNoFreight, inboundDetailMeteReduce, 12));
               record.setTransferUnitPriceExcludingVatNoFreight(NumberUtil.div(inboundDetailAmountExcludingVatReduceNoFreight, inboundDetailMeteReduce, 12));
            }
         } else {
            record.setTransferAmountExcludingVat(null);
            record.setTransferAmount(null);
            record.setTransferAmountExcludingVatNoFreight(null);
            record.setTransferAmountNoFreight(null);
            record.setTransferMete(null);
            record.setTransferQuantity(null);
            record.setTransferUnitPrice(null);
            record.setTransferUnitPriceExcludingVat(null);
            record.setTransferUnitPriceNoFreight(null);
            record.setTransferUnitPriceExcludingVatNoFreight(null);
         }

         if (CollectionUtil.isNotEmpty(outboundDetailList)) {
            BigDecimal outboundDetailAmountExcludingVatReduce = outboundDetailList.stream()
               .map(StatisticsOutbound::getAmountExcludingVat)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailAmountReduce = outboundDetailList.stream()
               .map(StatisticsOutbound::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailAmountReduceNoFreight = outboundDetailList.stream()
               .map(StatisticsOutbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailAmountExcludingVatReduceNoFreight = outboundDetailList.stream()
               .map(StatisticsOutbound::getAmountExcludingVatNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailMeteReduce = outboundDetailList.stream()
               .map(StatisticsOutbound::getMete)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailQuantityReduce = outboundDetailList.stream()
               .map(StatisticsOutbound::getQuantity)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endMete = endMete.subtract(outboundDetailMeteReduce);
            endQuantity = endQuantity.subtract(outboundDetailQuantityReduce);
            endAmountExcludingVat = endAmountExcludingVat.subtract(outboundDetailAmountExcludingVatReduce);
            endAmount = endAmount.subtract(outboundDetailAmountReduce);
            endAmountNoFreight = endAmountNoFreight.subtract(outboundDetailAmountReduceNoFreight);
            endAmountExcludingVatNoFreight = endAmountExcludingVatNoFreight.subtract(outboundDetailAmountExcludingVatReduceNoFreight);
            record.setOutboundAmountExcludingVat(outboundDetailAmountExcludingVatReduce);
            record.setOutboundAmount(outboundDetailAmountReduce);
            record.setOutboundAmountNoFreight(outboundDetailAmountReduceNoFreight);
            record.setOutboundAmountExcludingVatNoFreight(outboundDetailAmountExcludingVatReduceNoFreight);
            record.setOutboundMete(outboundDetailMeteReduce);
            record.setOutboundQuantity(outboundDetailQuantityReduce);
            if (outboundDetailMeteReduce.compareTo(BigDecimal.ZERO) != 0) {
               record.setOutboundUnitPrice(NumberUtil.div(outboundDetailAmountReduce, outboundDetailMeteReduce, 12));
               record.setOutboundUnitPriceExcludingVat(NumberUtil.div(outboundDetailAmountExcludingVatReduce, outboundDetailMeteReduce, 12));
               record.setOutboundUnitPriceNoFreight(NumberUtil.div(outboundDetailAmountReduceNoFreight, outboundDetailMeteReduce, 12));
               record.setOutboundUnitPriceExcludingVatNoFreight(NumberUtil.div(outboundDetailAmountExcludingVatReduceNoFreight, outboundDetailMeteReduce, 12));
            }
         } else {
            record.setOutboundAmountExcludingVat(null);
            record.setOutboundAmount(null);
            record.setOutboundAmountExcludingVatNoFreight(null);
            record.setOutboundAmountNoFreight(null);
            record.setOutboundMete(null);
            record.setOutboundQuantity(null);
            record.setOutboundUnitPrice(null);
            record.setOutboundUnitPriceExcludingVat(null);
            record.setOutboundUnitPriceNoFreight(null);
            record.setOutboundUnitPriceExcludingVatNoFreight(null);
         }

         record.setEndAmount(endAmount);
         record.setEndAmountExcludingVat(endAmountExcludingVat);
         record.setEndAmountNoFreight(endAmountNoFreight);
         record.setEndAmountExcludingVatNoFreight(endAmountExcludingVatNoFreight);
         record.setEndMete(endMete);
         record.setEndQuantity(endQuantity);
         if (endMete.compareTo(BigDecimal.ZERO) != 0) {
            record.setEndUnitPrice(NumberUtil.div(endAmount, endMete, 12));
            record.setEndUnitPriceExcludingVat(NumberUtil.div(endAmountExcludingVat, endMete, 12));
            record.setEndUnitPriceNoFreight(NumberUtil.div(endAmountNoFreight, endMete, 12));
            record.setEndUnitPriceExcludingVatNoFreight(NumberUtil.div(endAmountExcludingVatNoFreight, endMete, 12));
         }

         MonthWeightedAveragePrice monthWeightedAveragePrice = this.monthWAPMapper.selectById(record.getWapId());
         if (ObjectUtil.isNotEmpty(monthWeightedAveragePrice)
            && record.getEndMete().compareTo(BigDecimal.ZERO) == 0
            && record.getEndAmountExcludingVat().compareTo(BigDecimal.ZERO) != 0
            && monthWeightedAveragePrice.getMete().compareTo(BigDecimal.ZERO) == 0
            && monthWeightedAveragePrice.getAmountExcludingVat().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal m = record.getEndAmount().negate();
            BigDecimal me = record.getEndAmountExcludingVat().negate();
            BigDecimal mNoFreight = record.getEndAmountNoFreight().negate();
            BigDecimal meNoFreight = record.getEndAmountExcludingVatNoFreight().negate();
            record.setEndAmount(m.add(record.getEndAmount()));
            record.setEndAmountExcludingVat(me.add(record.getEndAmountExcludingVat()));
            record.setEndAmountNoFreight(mNoFreight.add(record.getEndAmountNoFreight()));
            record.setEndAmountExcludingVatNoFreight(meNoFreight.add(record.getEndAmountExcludingVatNoFreight()));
            endAmountExcludingVat = endAmountExcludingVat.add(me);
            this.getSupplement1(BeanUtil.copy(monthWeightedAveragePrice, MaterialInventory.class), statistics, null, m, me, mNoFreight, meNoFreight, build);
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               monthWeightedAveragePrice.setAmount(monthWeightedAveragePrice.getAmount().add(m).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               monthWeightedAveragePrice.setAmountExcludingVat(
                  monthWeightedAveragePrice.getAmountExcludingVat().add(me).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               monthWeightedAveragePrice.setAmountNoFreight(
                  monthWeightedAveragePrice.getAmountNoFreight().add(mNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               monthWeightedAveragePrice.setAmountExcludingVatNoFreight(
                  monthWeightedAveragePrice.getAmountExcludingVatNoFreight().add(meNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
            } else {
               monthWeightedAveragePrice.setAmount(null);
               monthWeightedAveragePrice.setAmountExcludingVat(null);
               monthWeightedAveragePrice.setAmountNoFreight(null);
               monthWeightedAveragePrice.setAmountExcludingVatNoFreight(null);
            }

            this.monthWAPMapper.updateById(monthWeightedAveragePrice);
            record.setInboundAmount(record.getInboundAmount() != null ? record.getInboundAmount().add(m) : m);
            record.setInboundAmountExcludingVat(record.getInboundAmountExcludingVat() != null ? record.getInboundAmountExcludingVat().add(me) : me);
            record.setInboundAmountNoFreight(record.getInboundAmountNoFreight() != null ? record.getInboundAmountNoFreight().add(mNoFreight) : mNoFreight);
            record.setInboundAmountExcludingVatNoFreight(
               record.getInboundAmountExcludingVatNoFreight() != null ? record.getInboundAmountExcludingVatNoFreight().add(meNoFreight) : meNoFreight
            );
            if (record.getInboundMete() != null
               && record.getInboundAmountExcludingVat().compareTo(BigDecimal.ZERO) != 0
               && record.getInboundMete().compareTo(BigDecimal.ZERO) != 0) {
               record.setInboundUnitPrice(NumberUtil.div(record.getInboundAmount(), record.getInboundMete(), 12));
               record.setInboundUnitPriceExcludingVat(NumberUtil.div(record.getInboundAmountExcludingVat(), record.getInboundMete(), 12));
               record.setInboundUnitPriceNoFreight(NumberUtil.div(record.getInboundAmountNoFreight(), record.getInboundMete(), 12));
               record.setInboundUnitPriceExcludingVatNoFreight(NumberUtil.div(record.getInboundAmountExcludingVatNoFreight(), record.getInboundMete(), 12));
            }
         }

         this.statisticsMonthRecordMapper.insert(record);
         statistics.setEndUnitPriceExcludingVat(null);
         statistics.setEndUnitPrice(null);
         statistics.setEndAmount(null);
         statistics.setEndAmountExcludingVat(null);
         statistics.setEndUnitPriceExcludingVatNoFreight(null);
         statistics.setEndUnitPriceNoFreight(null);
         statistics.setEndAmountExcludingVatNoFreight(null);
         statistics.setEndAmountNoFreight(null);
         List<StatisticsInbound> inboundDetailList1 = this.statisticsInboundMapper
            .selectList(
               (Wrapper<StatisticsInbound>)((new LambdaQueryWrapper<StatisticsInbound>()
                        .eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                     .in(StatisticsInbound::getReceiptType, ReceiptTypeEnum.getInbound()))
                  .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " >= {0}", build.getEndTime())
            );
         List<StatisticsInbound> transferDetailList1 = this.statisticsInboundMapper
            .selectList(
               (Wrapper<StatisticsInbound>)((new LambdaQueryWrapper<StatisticsInbound>()
                        .eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                     .notIn(StatisticsInbound::getReceiptType, ReceiptTypeEnum.getInbound()))
                  .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " >= {0}", build.getEndTime())
            );
         List<StatisticsOutbound> outboundDetailList1 = this.statisticsOutboundMapper
            .selectList(
               (Wrapper<StatisticsOutbound>)(new LambdaQueryWrapper<StatisticsOutbound>().eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
                  .ge(StatisticsOutbound::getOutboundTime, build.getEndTime())
            );
         if (CollectionUtil.isNotEmpty(inboundDetailList1)) {
            BigDecimal inboundDetailAmountExcludingVatReduce = inboundDetailList1.stream()
               .map(StatisticsInbound::getAmountExcludingVat)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduce = inboundDetailList1.stream()
               .map(StatisticsInbound::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailMeteReduce = inboundDetailList1.stream()
               .map(StatisticsInbound::getMete)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailQuantityReduce = inboundDetailList1.stream()
               .map(StatisticsInbound::getQuantity)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduceNoFreight = inboundDetailList.stream()
               .map(StatisticsInbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = inboundDetailList.stream()
               .map(StatisticsInbound::getAmountExcludingVatNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            statistics.setInboundAmount(inboundDetailAmountReduce);
            statistics.setInboundAmountExcludingVat(inboundDetailAmountExcludingVatReduce);
            statistics.setInboundAmountNoFreight(inboundDetailAmountReduceNoFreight);
            statistics.setInboundAmountExcludingVatNoFreight(inboundDetailAmountExcludingVatReduceNoFreight);
            statistics.setInboundQuantity(inboundDetailQuantityReduce);
            statistics.setInboundMete(inboundDetailMeteReduce);
            endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
            endMete = endMete.add(inboundDetailMeteReduce);
            if (inboundDetailMeteReduce.compareTo(BigDecimal.ZERO) != 0) {
               statistics.setInboundUnitPrice(NumberUtil.div(inboundDetailAmountReduce, inboundDetailMeteReduce, 12));
               statistics.setInboundUnitPriceExcludingVat(NumberUtil.div(inboundDetailAmountExcludingVatReduce, inboundDetailMeteReduce, 12));
               statistics.setInboundUnitPriceNoFreight(NumberUtil.div(inboundDetailAmountReduceNoFreight, inboundDetailMeteReduce, 12));
               statistics.setInboundUnitPriceExcludingVatNoFreight(NumberUtil.div(inboundDetailAmountExcludingVatReduceNoFreight, inboundDetailMeteReduce, 12));
            }
         }

         if (CollectionUtil.isNotEmpty(transferDetailList1)) {
            BigDecimal inboundDetailAmountExcludingVatReduce = transferDetailList1.stream()
               .map(StatisticsInbound::getAmountExcludingVat)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduce = transferDetailList1.stream()
               .map(StatisticsInbound::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailMeteReduce = transferDetailList1.stream()
               .map(StatisticsInbound::getMete)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailQuantityReduce = transferDetailList1.stream()
               .map(StatisticsInbound::getQuantity)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountReduceNoFreight = transferDetailList1.stream()
               .map(StatisticsInbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = transferDetailList1.stream()
               .map(StatisticsInbound::getAmountExcludingVatNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            statistics.setTransferAmount(inboundDetailAmountReduce);
            statistics.setTransferAmountExcludingVat(inboundDetailAmountExcludingVatReduce);
            statistics.setTransferAmountNoFreight(inboundDetailAmountReduceNoFreight);
            statistics.setTransferAmountExcludingVatNoFreight(inboundDetailAmountExcludingVatReduceNoFreight);
            endAmountExcludingVat = endAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
            endMete = endMete.add(inboundDetailMeteReduce);
            statistics.setTransferQuantity(inboundDetailQuantityReduce);
            statistics.setTransferMete(inboundDetailMeteReduce);
            if (inboundDetailMeteReduce.compareTo(BigDecimal.ZERO) != 0) {
               statistics.setTransferUnitPrice(NumberUtil.div(inboundDetailAmountReduce, inboundDetailMeteReduce, 12));
               statistics.setTransferUnitPriceExcludingVat(NumberUtil.div(inboundDetailAmountExcludingVatReduce, inboundDetailMeteReduce, 12));
               statistics.setTransferUnitPriceNoFreight(NumberUtil.div(inboundDetailAmountReduceNoFreight, inboundDetailMeteReduce, 12));
               statistics.setTransferUnitPriceExcludingVatNoFreight(NumberUtil.div(inboundDetailAmountExcludingVatReduceNoFreight, inboundDetailMeteReduce, 12));
            }
         }

         if (CollectionUtil.isNotEmpty(outboundDetailList1)) {
            BigDecimal outboundDetailAmountExcludingVatReduce = outboundDetailList1.stream()
               .map(StatisticsOutbound::getAmountExcludingVat)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailAmountReduce = outboundDetailList1.stream()
               .map(StatisticsOutbound::getAmount)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailMeteReduce = outboundDetailList1.stream()
               .map(StatisticsOutbound::getMete)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailQuantityReduce = outboundDetailList1.stream()
               .map(StatisticsOutbound::getQuantity)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailAmountReduceNoFreight = outboundDetailList.stream()
               .map(StatisticsOutbound::getAmountNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundDetailAmountExcludingVatReduceNoFreight = outboundDetailList.stream()
               .map(StatisticsOutbound::getAmountExcludingVatNoFreight)
               .filter(Objects::nonNull)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endAmountExcludingVat = endAmountExcludingVat.add(outboundDetailAmountExcludingVatReduce);
            endMete = endMete.add(outboundDetailMeteReduce);
            statistics.setOutboundAmountExcludingVat(outboundDetailAmountExcludingVatReduce);
            statistics.setOutboundAmount(outboundDetailAmountReduce);
            statistics.setOutboundAmountNoFreight(outboundDetailAmountReduceNoFreight);
            statistics.setOutboundAmountExcludingVatNoFreight(outboundDetailAmountExcludingVatReduceNoFreight);
            statistics.setOutboundMete(outboundDetailMeteReduce);
            statistics.setOutboundQuantity(outboundDetailQuantityReduce);
            if (outboundDetailMeteReduce.compareTo(BigDecimal.ZERO) != 0) {
               statistics.setOutboundUnitPrice(NumberUtil.div(outboundDetailAmountReduce, outboundDetailMeteReduce, 12));
               statistics.setOutboundUnitPriceExcludingVat(NumberUtil.div(outboundDetailAmountExcludingVatReduce, outboundDetailMeteReduce, 12));
               statistics.setOutboundUnitPriceNoFreight(NumberUtil.div(outboundDetailAmountReduceNoFreight, outboundDetailMeteReduce, 12));
               statistics.setOutboundUnitPriceExcludingVatNoFreight(
                  NumberUtil.div(outboundDetailAmountExcludingVatReduceNoFreight, outboundDetailMeteReduce, 12)
               );
            }
         }

         boolean isEmptyData = endMete.compareTo(BigDecimal.ZERO) == 0
            && inboundDetailList1.isEmpty()
            && outboundDetailList1.isEmpty()
            && transferDetailList1.isEmpty();
         if (isEmptyData && endAmountExcludingVat.compareTo(BigDecimal.ZERO) == 0) {
            this.statisticsMapper.deleteById(statistics);
         } else {
            this.statisticsMapper.updateById(statistics);
         }

         BigDecimal detailEndAmount = record.getEndAmount();
         BigDecimal detailEndAmountExcludingVat = record.getEndAmountExcludingVat();
         BigDecimal detailEndAmountNoFreight = record.getEndAmountNoFreight();
         BigDecimal detailEndAmountExcludingVatNoFreight = record.getEndAmountExcludingVatNoFreight();
         BigDecimal mete1 = record.getEndMete();

         for (StatisticsEndPeriod statisticsEndPeriod : this.statisticsEndPeriodMapper
            .selectList(
               (Wrapper<StatisticsEndPeriod>)(new LambdaQueryWrapper<StatisticsEndPeriod>().isNull(StatisticsEndPeriod::getWmsClosingTimeId))
                  .eq(StatisticsEndPeriod::getStatisticsId, record.getStatId())
            )) {
            StatisticsBeginPeriod beginPeriod = BeanUtil.copy(statisticsEndPeriod, StatisticsBeginPeriod.class, "createTime");
            beginPeriod.setWmsClosingTimeId(build.getId());
            beginPeriod.setCreateTime(build.getEndTime());
            BigDecimal detailEndMete = BigDecimal.ZERO;
            BigDecimal detailEndQuantity = BigDecimal.ZERO;
            BigDecimal beginPeriodAmount = BigDecimal.ZERO;
            BigDecimal beginPeriodAmountExcludingVat = BigDecimal.ZERO;
            BigDecimal beginPeriodAmountNoFreight = BigDecimal.ZERO;
            BigDecimal beginPeriodAmountExcludingVatNoFreight = BigDecimal.ZERO;
            if (ObjectUtil.isNotEmpty(one)) {
               List<StatisticsBeginPeriod> beginDetailList = this.statisticsBeginPeriodMapper
                  .selectList(
                     (Wrapper<StatisticsBeginPeriod>)((new LambdaQueryWrapper<StatisticsBeginPeriod>()
                              .eq(StatisticsBeginPeriod::getStatisticsId, statisticsEndPeriod.getStatisticsId()))
                           .eq(StatisticsBeginPeriod::getWmsClosingTimeId, one.getId()))
                        .eq(StatisticsBeginPeriod::getMaterialInventoryId, statisticsEndPeriod.getMaterialInventoryId())
                  );
               if (CollectionUtil.isNotEmpty(beginDetailList)) {
                  BigDecimal beginDetailAmountReduce = beginDetailList.stream()
                     .map(StatisticsBeginPeriod::getAmount)
                     .filter(Objects::nonNull)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal beginDetailAmountExcludingVatReduce = beginDetailList.stream()
                     .map(StatisticsBeginPeriod::getAmountExcludingVat)
                     .filter(Objects::nonNull)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal beginDetailAmountReduceNoFreightReduce = beginDetailList.stream()
                     .map(StatisticsBeginPeriod::getAmountNoFreight)
                     .filter(Objects::nonNull)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal beginDetailAmountExcludingVatReduceNoFreightReduce = beginDetailList.stream()
                     .map(StatisticsBeginPeriod::getAmountExcludingVatNoFreight)
                     .filter(Objects::nonNull)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  beginPeriodAmount = beginDetailAmountReduce;
                  beginPeriodAmountExcludingVat = beginDetailAmountExcludingVatReduce;
                  beginPeriodAmountNoFreight = beginDetailAmountReduceNoFreightReduce;
                  beginPeriodAmountExcludingVatNoFreight = beginDetailAmountExcludingVatReduceNoFreightReduce;
                  BigDecimal beginDetailMeteReduce = beginDetailList.stream()
                     .map(StatisticsBeginPeriod::getMete)
                     .filter(Objects::nonNull)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal beginQuantity = beginDetailList.stream()
                     .map(StatisticsBeginPeriod::getQuantity)
                     .filter(Objects::nonNull)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  detailEndMete = beginDetailMeteReduce;
                  detailEndQuantity = beginQuantity;
               }
            }

            List<StatisticsInbound> detailInboundDetailList = this.statisticsInboundMapper
               .selectList(
                  (Wrapper<StatisticsInbound>)(((new LambdaQueryWrapper<StatisticsInbound>()
                              .eq(StatisticsInbound::getStatisticsId, statisticsEndPeriod.getStatisticsId()))
                           .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " <= {0}", build.getEndTime()))
                        .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " >= {0}", build.getStartTime()))
                     .eq(StatisticsInbound::getMaterialInventoryId, statisticsEndPeriod.getMaterialInventoryId())
               );
            List<StatisticsOutbound> detailOutboundDetailList = this.statisticsOutboundMapper
               .selectList(
                  (Wrapper<StatisticsOutbound>)(((new LambdaQueryWrapper<StatisticsOutbound>()
                              .eq(StatisticsOutbound::getStatisticsId, statisticsEndPeriod.getStatisticsId()))
                           .le(StatisticsOutbound::getOutboundTime, build.getEndTime()))
                        .ge(StatisticsOutbound::getOutboundTime, build.getStartTime()))
                     .eq(StatisticsOutbound::getMaterialInventoryId, statisticsEndPeriod.getMaterialInventoryId())
               );
            if (CollectionUtil.isNotEmpty(detailInboundDetailList)) {
               BigDecimal inboundDetailAmountReduce = detailInboundDetailList.stream()
                  .map(StatisticsInbound::getAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailAmountExcludingVatReduce = detailInboundDetailList.stream()
                  .map(StatisticsInbound::getAmountExcludingVat)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailAmountReduceNoFreight = detailInboundDetailList.stream()
                  .map(StatisticsInbound::getAmountNoFreight)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundDetailAmountExcludingVatReduceNoFreight = detailInboundDetailList.stream()
                  .map(StatisticsInbound::getAmountExcludingVatNoFreight)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               beginPeriodAmount = beginPeriodAmount.add(inboundDetailAmountReduce);
               beginPeriodAmountExcludingVat = beginPeriodAmountExcludingVat.add(inboundDetailAmountExcludingVatReduce);
               beginPeriodAmountNoFreight = beginPeriodAmountNoFreight.add(inboundDetailAmountReduceNoFreight);
               beginPeriodAmountExcludingVatNoFreight = beginPeriodAmountExcludingVatNoFreight.add(inboundDetailAmountExcludingVatReduceNoFreight);
               BigDecimal inboundDetailMeteReduce = detailInboundDetailList.stream()
                  .map(StatisticsInbound::getMete)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inQuantity = detailInboundDetailList.stream()
                  .map(StatisticsInbound::getQuantity)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               detailEndMete = detailEndMete.add(inboundDetailMeteReduce);
               detailEndQuantity = detailEndQuantity.add(inQuantity);
            }

            if (CollectionUtil.isNotEmpty(detailOutboundDetailList)) {
               BigDecimal outboundDetailAmountReduce = detailOutboundDetailList.stream()
                  .map(StatisticsOutbound::getAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailAmountExcludingVatReduce = detailOutboundDetailList.stream()
                  .map(StatisticsOutbound::getAmountExcludingVat)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailAmountReduceNoFreight = detailOutboundDetailList.stream()
                  .map(StatisticsOutbound::getAmountNoFreight)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailAmountExcludingVatReduceNoFreight = detailOutboundDetailList.stream()
                  .map(StatisticsOutbound::getAmountExcludingVatNoFreight)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               beginPeriodAmount = beginPeriodAmount.subtract(outboundDetailAmountReduce);
               beginPeriodAmountExcludingVat = beginPeriodAmountExcludingVat.subtract(outboundDetailAmountExcludingVatReduce);
               beginPeriodAmountNoFreight = beginPeriodAmountNoFreight.subtract(outboundDetailAmountReduceNoFreight);
               beginPeriodAmountExcludingVatNoFreight = beginPeriodAmountExcludingVatNoFreight.subtract(outboundDetailAmountExcludingVatReduceNoFreight);
               BigDecimal outboundDetailMeteReduce = detailOutboundDetailList.stream()
                  .map(StatisticsOutbound::getMete)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundDetailQuantityReduce = detailOutboundDetailList.stream()
                  .map(StatisticsOutbound::getQuantity)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               detailEndMete = detailEndMete.subtract(outboundDetailMeteReduce);
               detailEndQuantity = detailEndQuantity.subtract(outboundDetailQuantityReduce);
            }

            beginPeriod.setMete(detailEndMete);
            beginPeriod.setQuantity(detailEndQuantity);
            if (record.getEndMete().compareTo(BigDecimal.ZERO) == 0 && beginPeriod.getMete().compareTo(BigDecimal.ZERO) == 0) {
               beginPeriod.setAmount(beginPeriodAmount);
               beginPeriod.setAmountExcludingVat(beginPeriodAmountExcludingVat);
               beginPeriod.setAmountNoFreight(beginPeriodAmountNoFreight);
               beginPeriod.setAmountExcludingVatNoFreight(beginPeriodAmountExcludingVatNoFreight);
            }

            if (beginPeriod.getMete().compareTo(BigDecimal.ZERO) != 0 && mete1.compareTo(BigDecimal.ZERO) != 0) {
               BigDecimal divide = beginPeriod.getMete().divide(mete1, 12, RoundingMode.HALF_UP);
               beginPeriod.setAmount(divide.multiply(detailEndAmount).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               beginPeriod.setAmountExcludingVat(divide.multiply(detailEndAmountExcludingVat).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               beginPeriod.setUnitPrice(beginPeriod.getAmount().divide(beginPeriod.getMete(), 12, RoundingMode.HALF_UP));
               beginPeriod.setUnitPriceExcludingVat(beginPeriod.getAmountExcludingVat().divide(beginPeriod.getMete(), 12, RoundingMode.HALF_UP));
               beginPeriod.setAmountNoFreight(divide.multiply(detailEndAmountNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP));
               beginPeriod.setAmountExcludingVatNoFreight(
                  divide.multiply(detailEndAmountExcludingVatNoFreight).setScale(this.amountAccuracy, RoundingMode.HALF_UP)
               );
               beginPeriod.setUnitPriceNoFreight(beginPeriod.getAmountNoFreight().divide(beginPeriod.getMete(), 12, RoundingMode.HALF_UP));
               beginPeriod.setUnitPriceExcludingVatNoFreight(
                  beginPeriod.getAmountExcludingVatNoFreight().divide(beginPeriod.getMete(), 12, RoundingMode.HALF_UP)
               );
               mete1 = mete1.subtract(beginPeriod.getMete());
               detailEndAmount = detailEndAmount.subtract(beginPeriod.getAmount());
               detailEndAmountExcludingVat = detailEndAmountExcludingVat.subtract(beginPeriod.getAmountExcludingVat());
               detailEndAmountNoFreight = detailEndAmountNoFreight.subtract(beginPeriod.getAmountNoFreight());
               detailEndAmountExcludingVatNoFreight = detailEndAmountExcludingVatNoFreight.subtract(beginPeriod.getAmountExcludingVatNoFreight());
            }

            StatisticsEndPeriod statisticsEndPeriod1 = BeanUtil.copy(beginPeriod, StatisticsEndPeriod.class, "createTime");
            if (ObjectUtil.isNotEmpty(monthWeightedAveragePrice)
               && endMete.compareTo(BigDecimal.ZERO) != 0
               && monthWeightedAveragePrice.getMete().compareTo(BigDecimal.ZERO) != 0) {
               statisticsEndPeriod1.setUnitPrice(NumberUtil.div(endAmount, endMete, 12));
               statisticsEndPeriod1.setUnitPriceExcludingVat(NumberUtil.div(endAmountExcludingVat, endMete, 12));
               beginPeriod.setUnitPrice(NumberUtil.div(endAmount, endMete, 12));
               beginPeriod.setUnitPriceExcludingVat(NumberUtil.div(endAmountExcludingVat, endMete, 12));
            }

            if (beginPeriod.getBoolPartyA()) {
               if (endMete.compareTo(BigDecimal.ZERO) != 0) {
                  StatisticsEndPeriodClosing copy = BeanUtil.copy(statisticsEndPeriod1, StatisticsEndPeriodClosing.class);
                  this.statisticsEndPeriodClosingMapper.insert(copy);
                  this.statisticsBeginPeriodMapper.insert(beginPeriod);
               }
            } else {
               boolean isBeginAmountValid = Objects.nonNull(beginPeriod.getAmountExcludingVat())
                  && BigDecimal.ZERO.compareTo(beginPeriod.getAmountExcludingVat()) != 0;
               boolean isEndAmountValid = Objects.nonNull(record.getEndAmountExcludingVat())
                  && BigDecimal.ZERO.compareTo(record.getEndAmountExcludingVat()) != 0;
               if (isBeginAmountValid && isEndAmountValid || endMete.compareTo(BigDecimal.ZERO) != 0) {
                  StatisticsEndPeriodClosing copy = BeanUtil.copy(statisticsEndPeriod1, StatisticsEndPeriodClosing.class);
                  this.statisticsEndPeriodClosingMapper.insert(copy);
                  this.statisticsBeginPeriodMapper.insert(beginPeriod);
               }
            }

            UpdateWrapper<StatisticsEndPeriod> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", statisticsEndPeriod.getId())
               .set("unit_price", null)
               .set("unit_price_excluding_vat", null)
               .set("amount", null)
               .set("amount_excluding_vat", null)
               .set("unit_price_no_freight", null)
               .set("unit_price_excluding_vat_no_freight", null)
               .set("amount_no_freight", null)
               .set("amount_excluding_vat_no_freight", null);
            boolean isMeteZero = statisticsEndPeriod.getMete().compareTo(BigDecimal.ZERO) == 0;
            boolean isAmountNull = beginPeriod.getAmountExcludingVat() == null;
            boolean isAmountZero = !isAmountNull && beginPeriod.getAmountExcludingVat().compareTo(BigDecimal.ZERO) == 0;
            if (!isMeteZero || !isAmountNull && !isAmountZero) {
               this.statisticsEndPeriodMapper.update(null, updateWrapper);
            } else {
               this.statisticsEndPeriodMapper.deleteById(statisticsEndPeriod);
            }
         }
      }
   }

   @Override
   public PageVO<VirtualMaterialDTO> getVirtual(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.materialInventoryMapper.getVirtual(param));
   }

   @Override
   public List<MaterialInventory> getInventoryDetails(Integer basicClass) {
      return this.materialInventoryMapper.listInfo(QueryByMaterialDTOParam.builder().basicClass(basicClass).build());
   }

   @Override
   public PageVO getInventoryDetails(Long projectId, List<Long> classifyIds, BigDecimal thickness, String spec) {
      List<MaterialInventory> materialInventories = this.materialInventoryMapper
         .listInfoForMes(
            QueryByMaterialDTOParam.builder()
               .basicClass(BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.STEEL_PLATE.getType())
               .projectId(projectId)
               .classifyIds(classifyIds)
               .thickness(thickness)
               .specification(spec)
               .build()
         );
      PageVO pageVO = new PageVO<>(materialInventories);
      pageVO.setContent(materialInventories.stream().map(this::getMaterialInventoryDTO).collect(Collectors.toList()));
      return pageVO;
   }

   @Override
   public ListVO<BriefIdAndNameDTO> getClassifyIdByPid(Integer warehouseType, Long projectId) {
      List<MaterialInventory> list = this.materialInventoryMapper
         .listInfo(
            QueryByMaterialDTOParam.builder()
               .basicClass(BasicClassEnum.GENERAL_MATERIAL.getType())
               .projectWarehouseType(warehouseType)
               .projectId(projectId)
               .build()
         );
      Map<Long, BriefIdAndNameDTO> map = new HashMap<>();

      for (MaterialInventory materialInventory : list) {
         String path = this.classificationService.getById(materialInventory.getClassifyId()).getPath();
         if (StrUtil.isNotBlank(path)) {
            Classification classification = this.classificationService.getById(Long.parseLong(path.split(",")[0]));
            BriefIdAndNameDTO briefIdAndNameDTO = map.get(classification.getId());
            if (briefIdAndNameDTO == null) {
               map.put(classification.getId(), BriefIdAndNameDTO.builder().id(classification.getId()).name(classification.getName()).build());
            }
         }
      }

      return new ListVO<>(new ArrayList<>(map.values()));
   }

   @Override
   public ListVO<MaterialInventoryDTO> getByCondition(
      Integer warehouseType, Long classifyId, Integer basicClass, BigDecimal thickness, BigDecimal width, BigDecimal length, String spec
   ) {
      List<MaterialInventoryDTO> list = this.baseMapper
         .getByCondition(warehouseType == 1 ? warehouseType : null, classifyId, thickness, spec, basicClass)
         .stream()
         .peek(
            m -> {
               MaterialFreeze materialFreeze = this.materialFreezeMapper
                  .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, m.getId()));
               if (materialFreeze != null) {
                  m.setFrozenMete(materialFreeze.getTotalMete());
                  m.setFrozenQuantity(materialFreeze.getTotalQuantity());
               } else {
                  m.setFrozenMete(BigDecimal.ZERO);
                  m.setFrozenQuantity(BigDecimal.ZERO);
               }
            }
         )
         .collect(Collectors.toList());
      List<MaterialInventoryDTO> allMatched = new ArrayList<>();
      List<MaterialInventoryDTO> dtoList = new ArrayList<>();
      int index = 0;
      if (!BasicClassEnum.checkIsSteel(basicClass)) {
         return new ListVO<>(list);
      }

      for (int i = 0; i < list.size(); i++) {
         MaterialInventoryDTO dto = list.get(i);
         if (basicClass.equals(BasicClassEnum.STEEL_PLATE.getType())) {
            if (dto.getLength().compareTo(length) == 0 && dto.getWidth().compareTo(width) == 0) {
               allMatched.add(dto);
            } else if (dto.getLength().compareTo(length) != 0 && dto.getWidth().compareTo(width) != 0) {
               dtoList.add(dto);
            } else {
               dtoList.add(i == 0 ? i : index, dto);
               index++;
            }
         } else if (basicClass.equals(BasicClassEnum.COLOR_ROLL.getType())) {
            if (dto.getWidth().compareTo(width) == 0) {
               allMatched.add(dto);
            } else {
               dtoList.add(dto);
            }
         } else if (basicClass.equals(BasicClassEnum.SECTION_STEEL.getType())) {
            if (dto.getLength().compareTo(length) == 0) {
               allMatched.add(dto);
            } else {
               dtoList.add(dto);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(allMatched)) {
         dtoList.addAll(0, allMatched);
      }

      return new ListVO<>(dtoList);
   }

   @Override
   public PageVO<MaterialInventoryDTO> pageInfoV2(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }

      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         List<String> split = StrUtil.split(replace, ",");
         if (split.size() > 1) {
            param.setSplit(split);
            param.setHeatNoAndBatchNo(null);
         }
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long currentUserId = null;
      if (!currentUser.isAdmin()) {
         currentUserId = currentUser.getId();
      }

      List<Long> workshopIds = this.workshopService
         .list(new LambdaQueryWrapper<Workshop>().last(currentUserId != null, "and find_in_set(" + currentUserId + ",workshop_user)"))
         .stream()
         .map(Workshop::getId)
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(workshopIds)) {
         return new PageVO<>();
      }

      if (CollectionUtil.isNotEmpty(param.getWorkshopIds())) {
         param.setWorkshopIds(param.getWorkshopIds().stream().filter(workshopIds::contains).collect(Collectors.toList()));
      } else {
         param.setWorkshopIds(workshopIds);
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MaterialInventory> pageInfo = PageHelper.<MaterialInventory>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.listInfoV2(param));
      List<MaterialInventoryDTO> materialInventoryDTO1 = this.getMaterialInventoryDTO1(pageInfo.getList());
      return new PageVO<>(pageInfo, materialInventoryDTO1);
   }

   @Override
   public PageVO<MaterialInventoryDTO> getMaterialList(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "物料仓分类配置"));
      MaterialWarehouseConfig materialWarehouseConfig = JSON.parseObject(basicConfig.getValue(), MaterialWarehouseConfig.class);
      if (materialWarehouseConfig.getMaterialWarehouseType() == 3 && param.getWarehouseConfigId() != null) {
         WmsMaterialWarehouseConfig byId = this.wmsMaterialWarehouseConfigService.getById(param.getWarehouseConfigId());
         List<Long> spilt = CommonUtil.spilt(byId.getClassifyIds(), ",");
         ArrayList<Long> objects = new ArrayList<>();
         objects.addAll(spilt);
         param.setClassifyIds(objects);
      }

      if (materialWarehouseConfig.getMaterialWarehouseType() == 3 && param.getWarehouseConfigId() == null) {
         List<WmsMaterialWarehouseConfigDTO> wmsMaterialWarehouseConfig = this.wmsMaterialWarehouseConfigService.getWmsMaterialWarehouseConfig();
         List<WmsMaterialWarehouseConfigDTO> filteredConfigs = wmsMaterialWarehouseConfig.stream()
            .filter(dto -> "默认仓库".equals(dto.getName()))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(filteredConfigs)) {
            List<Long> collect = filteredConfigs.get(0).getList().stream().map(Classification::getId).collect(Collectors.toList());
            ArrayList<Long> objects = new ArrayList<>();
            objects.addAll(collect);
            param.setClassifyIds(objects);
         }
      }

      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         List<String> split = StrUtil.split(replace, ",");
         if (split.size() > 1) {
            param.setSplit(split);
            param.setHeatNoAndBatchNo(null);
         }
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long currentUserId = null;
      if (!currentUser.isAdmin()) {
         currentUserId = currentUser.getId();
      }

      List<Long> workshopIds = this.workshopService
         .list(new LambdaQueryWrapper<Workshop>().last(currentUserId != null, "and find_in_set(" + currentUserId + ",workshop_user)"))
         .stream()
         .map(Workshop::getId)
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(workshopIds)) {
         return new PageVO<>();
      }

      if (CollectionUtil.isNotEmpty(param.getWorkshopIds())) {
         param.setWorkshopIds(param.getWorkshopIds().stream().filter(workshopIds::contains).collect(Collectors.toList()));
      } else {
         param.setWorkshopIds(workshopIds);
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MaterialInventory> pageInfo = PageHelper.<MaterialInventory>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.listInfoV2(param));
      List<MaterialInventoryDTO> materialInventoryDTO1 = this.getMaterialInventoryDTO1(pageInfo.getList());
      return new PageVO<>(pageInfo, materialInventoryDTO1);
   }

   @NotNull
   private MaterialInventoryDTO getMaterialInventoryDTOV2(MaterialInventory materialInventory) {
      MaterialInventoryDTO materialInventoryDTO = BeanUtil.copy(materialInventory, MaterialInventoryDTO.class);
      materialInventoryDTO.setNationalStandard(materialInventory.getStandardName());
      Workshop workshop = this.workshopService.getById(materialInventory.getWorkshopId());
      if (workshop != null) {
         materialInventoryDTO.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
      }

      Warehouse warehouse = this.warehouseService.getById(materialInventory.getWarehouseId());
      if (warehouse != null) {
         materialInventoryDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
      }

      materialInventoryDTO.setSerialNumber(this.classificationService.getById(materialInventory.getClassifyId()).getSerialNumber());
      if (materialInventory.getProjectId() != null) {
         ProjectInfo projectInfo = this.contractProjectService.getSimpleById(materialInventory.getProjectId());
         materialInventoryDTO.setProject(
            ProjectInfo.builder().id(projectInfo.getId()).name(projectInfo.getName()).shortName(projectInfo.getShortName()).build()
         );
         materialInventoryDTO.setBranchCompanyId(projectInfo.getContractSignBodyId());
      }

      if (materialInventory.getMonomerId() != null) {
         PlanMonomer byId = this.monomerService.getById(materialInventory.getMonomerId());
         materialInventoryDTO.setMonomerName(ObjectUtil.isNotEmpty(byId) ? byId.getName() : null);
      }

      if (materialInventory.getAreaId() != null) {
         PlanArea byId = this.planAreaService.getById(materialInventory.getAreaId());
         materialInventoryDTO.setAreaName(ObjectUtil.isNotEmpty(byId) ? byId.getName() : null);
      }

      MaterialFreeze materialFreeze = this.materialFreezeMapper
         .selectOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      materialInventoryDTO.setFrozenMete(
         materialFreeze != null
            ? (materialFreeze.getTotalMete().compareTo(materialInventory.getMete()) > 0 ? materialInventory.getMete() : materialFreeze.getTotalMete())
            : BigDecimal.ZERO
      );
      materialInventoryDTO.setFrozenQuantity(materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO);
      materialInventoryDTO.setBoolHasFrozen(materialFreeze != null);
      List<MaterialFreezeRecord> materialFreezeRecordList = this.materialFreezeRecordService
         .list(
            (Wrapper<MaterialFreezeRecord>)(new LambdaQueryWrapper<MaterialFreezeRecord>()
                  .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze == null ? null : materialFreeze.getId()))
               .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType())
         );
      if (CollectionUtils.isNotEmpty(materialFreezeRecordList)) {
         List<ProjectToFreezeDTO> projectToFreezeDTOS = materialFreezeRecordList.stream()
            .map(e -> BeanUtil.copy(e, ProjectToFreezeDTO.class))
            .collect(Collectors.toList());
         materialInventoryDTO.setProjectFrozen(projectToFreezeDTOS);
      }

      return materialInventoryDTO;
   }

   @Override
   public List<MaterialInventory> listInfoV2(QueryByMaterialDTOParam param) {
      return this.materialInventoryMapper.listInfoV2(param);
   }

   @Override
   public BigDecimal realtimeInventory(QueryByMaterialDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collect);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }

      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         List<String> split = StrUtil.split(replace, ",");
         if (split.size() > 1) {
            param.setSplit(split);
            param.setHeatNoAndBatchNo(null);
         }
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long currentUserId = null;
      if (!currentUser.isAdmin()) {
         currentUserId = currentUser.getId();
      }

      List<Long> workshopIds = this.workshopService
         .list(new LambdaQueryWrapper<Workshop>().last(currentUserId != null, "and find_in_set(" + currentUserId + ",workshop_user)"))
         .stream()
         .map(Workshop::getId)
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(workshopIds)) {
         return BigDecimal.ZERO;
      }

      if (CollectionUtil.isNotEmpty(param.getWorkshopIds())) {
         param.setWorkshopIds(param.getWorkshopIds().stream().filter(workshopIds::contains).collect(Collectors.toList()));
      } else {
         param.setWorkshopIds(workshopIds);
      }

      return this.materialInventoryMapper.realtimeInventory(param);
   }

   @Override
   public void exportSteelMaterialsList(QueryByMaterialDTOParam param, HttpServletResponse response) {
      List<MaterialInventory> materialInventories = this.materialInventoryMapper.listInfoV2(param);
      String title = null;
      String sheetName = null;
      String fileName = null;
      if ((param.getBasicClass() & BasicClassEnum.STEEL_PLATE.getType()) > 0) {
         title = "自采仓库钢板库存清单";
         sheetName = "自采仓库钢材库存清单";
         fileName = "自采仓库钢材库存清单.xlsx";
      } else if ((param.getBasicClass() & BasicClassEnum.SECTION_STEEL.getType()) > 0) {
         title = "自采仓库型材库存清单";
         sheetName = "自采仓库型材库存清单";
         fileName = "自采仓库型材库存清单.xlsx";
      } else if ((param.getBasicClass() & BasicClassEnum.COLOR_ROLL.getType()) > 0) {
         title = "自采仓库钢卷库存清单";
         sheetName = "自采仓库钢卷库存清单";
         fileName = "自采仓库钢卷库存清单.xlsx";
      } else if ((param.getBasicClass() & BasicClassEnum.OTHER_STEEL_MATERIALS.getType()) > 0) {
         title = "自采仓库其它钢材库存清单";
         sheetName = "自采仓库其它钢材库存清单";
         fileName = "自采仓库其它钢材库存清单.xlsx";
      }

      Integer order = 1;
      List<SteelMaterialInventoryImportDTO> steelMaterialInventoryImportDTOS = new ArrayList<>();

      for (MaterialInventory materialInventory : materialInventories) {
         SteelMaterialInventoryImportDTO m = BeanUtil.copy(materialInventory, SteelMaterialInventoryImportDTO.class);
         Integer warehouse = order;
         order = order + 1;
         m.setOrder(warehouse);
         if (materialInventory.getProjectId() != null) {
            ContractProject contractProject = this.contractProjectService.getById(materialInventory.getProjectId());
            m.setProjectName(contractProject.getName() + contractProject.getShortName());
         }

         if (materialInventory.getQuantity() != null) {
            BigDecimal quantity = materialInventory.getQuantity().setScale(0, 1);
            m.setQuantity(quantity);
         }

         if (materialInventory.getThickness() != null) {
            BigDecimal thickness = materialInventory.getThickness().setScale(0, 1);
            m.setThickness(thickness);
         }

         if (materialInventory.getWidth() != null) {
            BigDecimal width = materialInventory.getWidth().setScale(0, 1);
            m.setWidth(width);
         }

         if (materialInventory.getLength() != null) {
            BigDecimal length = materialInventory.getLength().setScale(0, 1);
            m.setLength(length);
         }

         if (materialInventory.getMete() != null) {
            BigDecimal mete = materialInventory.getMete().setScale(0, 1);
            m.setMete(mete);
         }

         if (materialInventory.getWorkshopId() != null) {
            Workshop workshop = this.workshopService.getById(materialInventory.getWorkshopId());
            if (materialInventory.getWarehouseId() != null) {
               Warehouse warehousex = this.warehouseService.getById(materialInventory.getWarehouseId());
               m.setWorkshopName(workshop.getName() + "-" + warehousex.getName());
            }
         } else {
            Warehouse warehousex = this.warehouseService.getById(materialInventory.getWarehouseId());
            m.setWorkshopName(warehousex.getName());
         }

         steelMaterialInventoryImportDTOS.add(m);
      }

      PoiUtils.wmsExportExcel(steelMaterialInventoryImportDTOS, title, sheetName, SteelMaterialInventoryImportDTO.class, fileName, response);
   }

   @Override
   public void exportOtherMaterialsList(QueryByMaterialDTOParam param, HttpServletResponse response) {
      List<MaterialInventory> materialInventories = this.materialInventoryMapper.listInfoV2(param);
      String title = null;
      String sheetName = null;
      String fileName = null;
      if ((param.getBasicClass() & BasicClassEnum.GENERAL_MATERIAL.getType()) > 0) {
         title = "自采仓库辅材库存清单";
         sheetName = "自采仓库辅材库存清单";
         fileName = "自采仓库辅材库存清单.xlsx";
      } else if ((param.getBasicClass() & BasicClassEnum.GAS.getType()) > 0) {
         title = "自采仓库气体库存清单";
         sheetName = "自采仓库气体库存清单";
         fileName = "自采仓库气体库存清单.xlsx";
      } else if ((param.getBasicClass() & BasicClassEnum.OTHER.getType()) > 0) {
         title = "自采仓库办公用品库存清单";
         sheetName = "自采仓库办公用品库存清单";
         fileName = "自采仓库办公用品库存清单.xlsx";
      }

      Integer order = 1;
      List<OtherMaterialInventoryImportDTO> otherMaterialInventoryImportDTOS = new ArrayList<>();

      for (MaterialInventory materialInventory : materialInventories) {
         OtherMaterialInventoryImportDTO otherMaterialInventoryImportDTO = BeanUtil.copy(materialInventory, OtherMaterialInventoryImportDTO.class);
         Integer warehouse = order;
         order = order + 1;
         otherMaterialInventoryImportDTO.setOrder(warehouse);
         if (materialInventory.getProjectId() != null) {
            ContractProject contractProject = this.contractProjectService.getById(materialInventory.getProjectId());
            otherMaterialInventoryImportDTO.setProjectName(contractProject.getName() + contractProject.getShortName());
         }

         if (materialInventory.getQuantity() != null) {
            BigDecimal quantity = materialInventory.getQuantity().setScale(0, 1);
            otherMaterialInventoryImportDTO.setQuantity(quantity);
         }

         if (materialInventory.getMete() != null) {
            BigDecimal mete = materialInventory.getMete().setScale(0, 1);
            otherMaterialInventoryImportDTO.setMete(mete);
         }

         if (materialInventory.getWorkshopId() != null) {
            Workshop workshop = this.workshopService.getById(materialInventory.getWorkshopId());
            if (materialInventory.getWarehouseId() != null) {
               Warehouse warehousex = this.warehouseService.getById(materialInventory.getWarehouseId());
               otherMaterialInventoryImportDTO.setWorkshopName(workshop.getName() + "-" + warehousex.getName());
            }
         } else {
            Warehouse warehousex = this.warehouseService.getById(materialInventory.getWarehouseId());
            otherMaterialInventoryImportDTO.setWorkshopName(warehousex.getName());
         }

         otherMaterialInventoryImportDTOS.add(otherMaterialInventoryImportDTO);
      }

      PoiUtils.wmsExportExcel(otherMaterialInventoryImportDTOS, title, sheetName, OtherMaterialInventoryImportDTO.class, fileName, response);
   }

   @Override
   public SteelWeightDTO objectRealtimeInventory(QueryByMaterialDTOParam param) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collectx = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collectx);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }

      if (StrUtil.isNotBlank(param.getHeatNoAndBatchNo())) {
         String replace = StrUtil.replace(param.getHeatNoAndBatchNo(), "，", ",");
         List<String> split = StrUtil.split(replace, ",");
         if (split.size() > 1) {
            param.setSplit(split);
            param.setHeatNoAndBatchNo(null);
         }
      }

      SteelWeightDTO steelWeightDTO = new SteelWeightDTO();
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long currentUserId = null;
      if (!currentUser.isAdmin()) {
         currentUserId = currentUser.getId();
      }

      List<Long> workshopIds = this.workshopService
         .list(new LambdaQueryWrapper<Workshop>().last(currentUserId != null, "and find_in_set(" + currentUserId + ",workshop_user)"))
         .stream()
         .map(Workshop::getId)
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(workshopIds)) {
         return steelWeightDTO;
      }

      if (CollectionUtil.isNotEmpty(param.getWorkshopIds())) {
         param.setWorkshopIds(param.getWorkshopIds().stream().filter(workshopIds::contains).collect(Collectors.toList()));
      } else {
         param.setWorkshopIds(workshopIds);
      }

      List<MaterialInventory> materialInventories = this.listInfoV2(param);
      BigDecimal sumWeight = materialInventories.stream()
         .map(MaterialInventory::getMete)
         .filter(ObjectUtil::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      steelWeightDTO.setSumWeight(sumWeight);
      if (ObjectUtil.isNotEmpty(param.getObjectType())) {
         switch (param.getObjectType()) {
            case 1:
               List<SteelWeightDTO> workshopWeightList = new ArrayList<>();
               List<Workshop> workshopList = this.workshopService.list();
               Map<Long, Workshop> workshopMap = workshopList.stream().collect(Collectors.toMap(Workshop::getId, Function.identity()));
               TreeSet<MaterialInventory> groupByWorkshop = new TreeSet<>(Comparator.comparing(MaterialInventory::getWorkshopId));
               groupByWorkshop.addAll(materialInventories);

               for (MaterialInventory materialInventory : groupByWorkshop) {
                  SteelWeightDTO workshopWeight = new SteelWeightDTO();
                  Workshop workshop = workshopMap.get(materialInventory.getWorkshopId());
                  List<MaterialInventory> collect = materialInventories.stream()
                     .filter(m -> m.getWorkshopId().equals(materialInventory.getWorkshopId()))
                     .collect(Collectors.toList());
                  BigDecimal workshopSumWeight = collect.stream()
                     .map(MaterialInventory::getMete)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  workshopWeight.setSumWeight(workshopSumWeight);
                  workshopWeight.setName(ObjectUtil.isNotEmpty(workshop) ? workshop.getName() : null);
                  workshopWeight.setId(ObjectUtil.isNotEmpty(workshop) ? workshop.getId() : null);
                  workshopWeightList.add(workshopWeight);
               }

               steelWeightDTO.setWorkshop(workshopWeightList);
               break;
            case 2:
               List<SteelWeightDTO> warehouseWeightList = new ArrayList<>();
               List<Warehouse> warehouseList = this.warehouseService.list();
               Map<Long, Warehouse> warehouseMap = warehouseList.stream().collect(Collectors.toMap(Warehouse::getId, Function.identity()));
               TreeSet<MaterialInventory> groupByWarehouse = new TreeSet<>(Comparator.comparing(MaterialInventory::getWarehouseId));
               groupByWarehouse.addAll(materialInventories);

               for (MaterialInventory materialInventory : groupByWarehouse) {
                  SteelWeightDTO warehouseWeight = new SteelWeightDTO();
                  Warehouse warehouse = warehouseMap.get(materialInventory.getWarehouseId());
                  List<MaterialInventory> collect = materialInventories.stream()
                     .filter(m -> m.getWarehouseId().equals(materialInventory.getWarehouseId()))
                     .collect(Collectors.toList());
                  BigDecimal warehouseSumWeight = collect.stream()
                     .map(MaterialInventory::getMete)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  warehouseWeight.setSumWeight(warehouseSumWeight);
                  warehouseWeight.setName(ObjectUtil.isNotEmpty(warehouse) ? warehouse.getName() : null);
                  warehouseWeight.setId(ObjectUtil.isNotEmpty(warehouse) ? warehouse.getId() : null);
                  warehouseWeightList.add(warehouseWeight);
               }

               steelWeightDTO.setWarehouse(warehouseWeightList);
               break;
            case 3:
               List<SteelWeightDTO> projectWeightList = new ArrayList<>();
               List<ContractProject> projectList = this.contractProjectService.list();
               Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
               TreeSet<MaterialInventory> groupByProject = new TreeSet<>(Comparator.comparing(MaterialInventory::getProjectId));
               List<MaterialInventory> materialInventoryNotProject = materialInventories.stream()
                  .filter(m -> ObjectUtil.isNotEmpty(m.getProjectId()))
                  .collect(Collectors.toList());
               sumWeight = materialInventoryNotProject.stream()
                  .map(MaterialInventory::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               steelWeightDTO.setSumWeight(sumWeight);
               groupByProject.addAll(materialInventoryNotProject);

               for (MaterialInventory materialInventory : groupByProject) {
                  SteelWeightDTO projectWeight = new SteelWeightDTO();
                  ContractProject project = projectMap.get(materialInventory.getProjectId());
                  List<MaterialInventory> collect = materialInventoryNotProject.stream()
                     .filter(m -> m.getProjectId().equals(materialInventory.getProjectId()))
                     .collect(Collectors.toList());
                  BigDecimal projectSumWeight = collect.stream()
                     .map(MaterialInventory::getMete)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  projectWeight.setSumWeight(projectSumWeight);
                  projectWeight.setName(ObjectUtil.isNotEmpty(project) ? project.getName() : null);
                  projectWeight.setId(ObjectUtil.isNotEmpty(project) ? project.getId() : null);
                  projectWeightList.add(projectWeight);
               }

               steelWeightDTO.setProject(projectWeightList);
         }
      }

      return steelWeightDTO;
   }

   @Override
   public PageVO<MaterialInventoryDTO> nestingDockingPageInfo(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setBasicClass(1);
      List<WmsSectionSteelControlTable> wmsSectionSteelControlTables = this.wmsSectionSteelControlTableService
         .list((Wrapper<WmsSectionSteelControlTable>)new LambdaQueryWrapper<WmsSectionSteelControlTable>().eq(WmsSectionSteelControlTable::getBasicClass, param.getBasicClass()));
      Preconditions.checkArgument(wmsSectionSteelControlTables.size() > 0, "未找到该截面规格的配置信息,请先配置截面规格对照信息");
      List<Long> ids = wmsSectionSteelControlTables.stream().map(WmsSectionSteelControlTable::getWmsClassifyId).collect(Collectors.toList());
      param.setClassifyIds(ids);
      if (param.getThickness() != null) {
         BigDecimal thickness = param.getThickness().add(wmsSectionSteelControlTables.get(0).getErrorD());
         BigDecimal minThickness = param.getThickness().subtract(wmsSectionSteelControlTables.get(0).getErrorD());
         param.setMinThickness(minThickness);
         param.setThickness(thickness);
      }

      if (CollectionUtil.isEmpty(param.getWorkshopIds())) {
         return new PageVO<>();
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MaterialInventory> pageInfo = PageHelper.<MaterialInventory>startPage(pageNumber, pageSize, s)
         .doSelectPageInfo(() -> this.nestingDockingList(param));
      List<MaterialInventoryDTO> materialInventoryDTO1 = this.getMaterialInventoryDTO1(pageInfo.getList());
      return new PageVO<>(pageInfo, materialInventoryDTO1);
   }

   @Override
   public List<MaterialInventory> nestingDockingList(QueryByMaterialDTOParam param) {
      return this.materialInventoryMapper.nestingDockingList(param);
   }

   @Override
   public PageVO<MaterialInventoryDTO> sectionSteelNestingDockingPageInfo(
      QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      List<MaterialInventory> materialInventoryList = this.getMaterialInventoryList(param);
      PageInfo<MaterialInventory> pageInfo = new PageInfo<>();
      List<MaterialInventoryDTO> materialInventoryDTO1 = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(materialInventoryList)) {
         List<Long> MaterialIds = materialInventoryList.stream().map(MaterialInventory::getId).collect(Collectors.toList());
         String s = StringUtils.analyzeSortConditions(sort);
         pageInfo = PageHelper.<MaterialInventory>startPage(pageNumber, pageSize, s)
            .doSelectPageInfo(() -> this.sectionSteelNestingDockingList(QueryByMaterialDTOParam.builder().ids(MaterialIds).build()));
         materialInventoryDTO1 = this.getMaterialInventoryDTO1(pageInfo.getList());
      }

      return new PageVO<>(pageInfo, materialInventoryDTO1);
   }

   @Override
   public Integer getCount(LocalDateTime date) {
      return this.materialInventoryMapper.getCount(date);
   }

   public List<MaterialInventory> sectionSteelNestingDockingList(QueryByMaterialDTOParam param) {
      return this.materialInventoryMapper.nestingDockingList(param);
   }

   public List<MaterialInventory> getMaterialInventoryList(QueryByMaterialDTOParam param) {
      List<WmsSectionSteelControlTable> wmsSectionSteelControlTables = this.wmsSectionSteelControlTableService
         .list(
            (Wrapper<WmsSectionSteelControlTable>)new LambdaQueryWrapper<WmsSectionSteelControlTable>().eq(WmsSectionSteelControlTable::getMesSectionSpecification, param.getSpecNumber())
         );
      Preconditions.checkArgument(wmsSectionSteelControlTables.size() > 0, "未找到该截面规格的配置信息,请先配置截面规格对照信息");
      List<Long> ids = wmsSectionSteelControlTables.stream().map(WmsSectionSteelControlTable::getWmsClassifyId).collect(Collectors.toList());
      param.setClassifyIds(ids);
      List<String> ErrorTypeList = Arrays.asList(wmsSectionSteelControlTables.get(0).getErrorType().split(","));
      int lastIndexOf = param.getSpecification().lastIndexOf(" * ");
      String specification = param.getSpecification().substring(0, lastIndexOf);
      String substring = param.getSpecification().substring(lastIndexOf + 3);
      List<BigDecimal> specs = Arrays.asList(specification.split("\\*")).stream().map(e -> {
         String collect = e.chars().filter(Character::isDigit).mapToObj(cx -> String.valueOf((char)cx)).collect(Collectors.joining());
         return new BigDecimal(collect);
      }).collect(Collectors.toList());
      param.setBasicClass(2);
      List<MaterialInventory> materialInventories = this.materialInventoryMapper.nestingDockingList(param);
      List<MaterialInventory> materialInventoryList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(materialInventories)) {
         for (MaterialInventory materialInventory : materialInventories) {
            int lastIndexOf1 = materialInventory.getSpecification().lastIndexOf(" * ");
            String substring1 = materialInventory.getSpecification().substring(lastIndexOf1 + 3);
            List<BigDecimal> specs1 = Arrays.asList(materialInventory.getSpecification().substring(0, lastIndexOf1).split("\\*")).stream().map(e -> {
               String collect = e.chars().filter(Character::isDigit).mapToObj(cx -> String.valueOf((char)cx)).collect(Collectors.joining());
               return new BigDecimal(collect);
            }).collect(Collectors.toList());
            BigDecimal a = BigDecimal.ZERO;
            BigDecimal a1 = BigDecimal.ZERO;
            BigDecimal b = BigDecimal.ZERO;
            BigDecimal b1 = BigDecimal.ZERO;
            BigDecimal c = BigDecimal.ZERO;
            BigDecimal c1 = BigDecimal.ZERO;
            BigDecimal d = BigDecimal.ZERO;
            BigDecimal d1 = BigDecimal.ZERO;
            if (substring.equals(substring1)) {
               for (int i = 0; i < specs.size(); i++) {
                  if (i == 0) {
                     if (ErrorTypeList.get(i).equals("a")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorA());
                     }

                     if (ErrorTypeList.get(i).equals("b")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorB());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorB());
                     }

                     if (ErrorTypeList.get(i).equals("d")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorD());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorD());
                     }

                     if (ErrorTypeList.get(i).equals("h")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorH());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorH());
                     }

                     if (ErrorTypeList.get(i).equals("t")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorT());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorT());
                     }

                     if (ErrorTypeList.get(i).equals("s")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorS());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorS());
                     }

                     if (ErrorTypeList.get(i).equals("B")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigB());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigB());
                     }

                     if (ErrorTypeList.get(i).equals("D")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigD());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigD());
                     }

                     if (ErrorTypeList.get(i).equals("H")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigH());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigH());
                     }

                     if (ErrorTypeList.get(i).equals("T")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigT());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigT());
                     }

                     if (ErrorTypeList.get(i).equals("S")) {
                        a = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigS());
                        a1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigS());
                     }
                  }

                  if (i == 1) {
                     if (ErrorTypeList.get(i).equals("a")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                        b1 = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                     }

                     if (ErrorTypeList.get(i).equals("b")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorB());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorB());
                     }

                     if (ErrorTypeList.get(i).equals("d")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorD());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorD());
                     }

                     if (ErrorTypeList.get(i).equals("h")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorH());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorH());
                     }

                     if (ErrorTypeList.get(i).equals("t")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorT());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorT());
                     }

                     if (ErrorTypeList.get(i).equals("s")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorS());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorS());
                     }

                     if (ErrorTypeList.get(i).equals("B")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigB());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigB());
                     }

                     if (ErrorTypeList.get(i).equals("D")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigD());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigD());
                     }

                     if (ErrorTypeList.get(i).equals("H")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigH());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigH());
                     }

                     if (ErrorTypeList.get(i).equals("T")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigT());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigT());
                     }

                     if (ErrorTypeList.get(i).equals("S")) {
                        b = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigS());
                        b1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigS());
                     }
                  }

                  if (i == 2) {
                     if (ErrorTypeList.get(i).equals("a")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                        c1 = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                     }

                     if (ErrorTypeList.get(i).equals("b")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorB());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorB());
                     }

                     if (ErrorTypeList.get(i).equals("d")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorD());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorD());
                     }

                     if (ErrorTypeList.get(i).equals("h")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorH());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorH());
                     }

                     if (ErrorTypeList.get(i).equals("t")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorT());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorT());
                     }

                     if (ErrorTypeList.get(i).equals("s")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorS());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorS());
                     }

                     if (ErrorTypeList.get(i).equals("B")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigB());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigB());
                     }

                     if (ErrorTypeList.get(i).equals("D")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigD());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigD());
                     }

                     if (ErrorTypeList.get(i).equals("H")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigH());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigH());
                     }

                     if (ErrorTypeList.get(i).equals("T")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigT());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigT());
                     }

                     if (ErrorTypeList.get(i).equals("S")) {
                        c = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigS());
                        c1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigS());
                     }
                  }

                  if (i == 3) {
                     if (ErrorTypeList.get(i).equals("a")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                        d1 = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorA());
                     }

                     if (ErrorTypeList.get(i).equals("b")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorB());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorB());
                     }

                     if (ErrorTypeList.get(i).equals("d")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorD());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorD());
                     }

                     if (ErrorTypeList.get(i).equals("h")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorH());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorH());
                     }

                     if (ErrorTypeList.get(i).equals("t")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorT());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorT());
                     }

                     if (ErrorTypeList.get(i).equals("s")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorS());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorS());
                     }

                     if (ErrorTypeList.get(i).equals("B")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigB());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigB());
                     }

                     if (ErrorTypeList.get(i).equals("D")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigD());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigD());
                     }

                     if (ErrorTypeList.get(i).equals("H")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigH());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigH());
                     }

                     if (ErrorTypeList.get(i).equals("T")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigT());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigT());
                     }

                     if (ErrorTypeList.get(i).equals("S")) {
                        d = specs.get(i).add(wmsSectionSteelControlTables.get(0).getErrorBigS());
                        d1 = specs.get(i).subtract(wmsSectionSteelControlTables.get(0).getErrorBigS());
                     }
                  }
               }

               if (specs.size() <= specs1.size()) {
                  if (specs.size() == 1 && a.compareTo(specs1.get(0)) >= 0 && a1.compareTo(specs1.get(0)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }

                  if (specs.size() == 2
                     && a.compareTo(specs1.get(0)) >= 0
                     && a1.compareTo(specs1.get(0)) <= 0
                     && b.compareTo(specs1.get(1)) >= 0
                     && b1.compareTo(specs1.get(1)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }

                  if (specs.size() == 3
                     && a.compareTo(specs1.get(0)) >= 0
                     && a1.compareTo(specs1.get(0)) <= 0
                     && b.compareTo(specs1.get(1)) >= 0
                     && b1.compareTo(specs1.get(1)) <= 0
                     && c.compareTo(specs1.get(2)) >= 0
                     && c1.compareTo(specs1.get(2)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }

                  if (specs.size() == 4
                     && a.compareTo(specs1.get(0)) >= 0
                     && a1.compareTo(specs1.get(0)) <= 0
                     && b.compareTo(specs1.get(1)) >= 0
                     && b1.compareTo(specs1.get(1)) <= 0
                     && c.compareTo(specs1.get(2)) >= 0
                     && c1.compareTo(specs1.get(2)) <= 0
                     && d.compareTo(specs1.get(3)) >= 0
                     && d1.compareTo(specs1.get(3)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }
               } else if (specs1.size() <= specs.size()) {
                  if (specs1.size() == 1 && a.compareTo(specs1.get(0)) >= 0 && a1.compareTo(specs1.get(0)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }

                  if (specs1.size() == 2
                     && a.compareTo(specs1.get(0)) >= 0
                     && a1.compareTo(specs1.get(0)) <= 0
                     && b.compareTo(specs1.get(1)) >= 0
                     && b1.compareTo(specs1.get(1)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }

                  if (specs1.size() == 3
                     && a.compareTo(specs1.get(0)) >= 0
                     && a1.compareTo(specs1.get(0)) <= 0
                     && b.compareTo(specs1.get(1)) >= 0
                     && b1.compareTo(specs1.get(1)) <= 0
                     && c.compareTo(specs1.get(2)) >= 0
                     && c1.compareTo(specs1.get(2)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }

                  if (specs1.size() == 4
                     && a.compareTo(specs1.get(0)) >= 0
                     && a1.compareTo(specs1.get(0)) <= 0
                     && b.compareTo(specs1.get(1)) >= 0
                     && b1.compareTo(specs1.get(1)) <= 0
                     && c.compareTo(specs1.get(2)) >= 0
                     && c1.compareTo(specs1.get(2)) <= 0
                     && d.compareTo(specs1.get(3)) >= 0
                     && d1.compareTo(specs1.get(3)) <= 0) {
                     materialInventoryList.add(materialInventory);
                  }
               }
            }
         }
      }

      return materialInventoryList;
   }

   @Override
   public BigDecimal getCountLength(QueryByMaterialDTOParam param) {
      List<MaterialInventory> materialInventoryList = this.getMaterialInventoryList(param);
      BigDecimal lengthCount = BigDecimal.ZERO;
      if (CollectionUtil.isNotEmpty(materialInventoryList)) {
         List<Long> MaterialIds = materialInventoryList.stream().map(MaterialInventory::getId).collect(Collectors.toList());

         for (MaterialInventory materialInventory : this.materialInventoryMapper.selectBatchIds(MaterialIds)) {
            BigDecimal multiply = materialInventory.getLength().multiply(materialInventory.getQuantity());
            lengthCount = lengthCount.add(multiply);
         }
      }

      return lengthCount;
   }

   @Override
   public List<MaterialInventoryDTO> getNumericalControlDetail(List<String> guids) {
      List<MaterialInventoryDTO> materialInventoryDTOS = new ArrayList<>();

      for (String guid : guids) {
         List<WmsPlantPart> wmsPlantPartList = this.wmsPlantPartService
            .list((Wrapper<WmsPlantPart>)new LambdaQueryWrapper<WmsPlantPart>().eq(WmsPlantPart::getStockGuid, guid));
         if (!CollectionUtil.isEmpty(wmsPlantPartList)) {
            MaterialInventory materialInventory = this.materialInventoryMapper.selectByIdIncludeDel(wmsPlantPartList.get(0).getSyncId());
            if (materialInventory != null) {
               BigDecimal mete = materialInventory.getMete().divide(materialInventory.getQuantity(), 5, RoundingMode.HALF_UP);
               MaterialInventoryDTO build = MaterialInventoryDTO.builder()
                  .classifyName(materialInventory.getClassifyName())
                  .specification(materialInventory.getSpecification())
                  .mete(mete)
                  .length(materialInventory.getLength())
                  .width(materialInventory.getWidth())
                  .thickness(materialInventory.getThickness())
                  .materialIsWhole(materialInventory.getMaterialIsWhole())
                  .surplusSn(materialInventory.getSurplusSn())
                  .area(materialInventory.getArea())
                  .build();
               if (materialInventory.getWorkshopId() != null) {
                  Workshop workshop = this.workshopService.getById(materialInventory.getWorkshopId());
                  build.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               }

               if (materialInventory.getWarehouseId() != null) {
                  Warehouse warehouse = this.warehouseService.getById(materialInventory.getWarehouseId());
                  build.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               materialInventoryDTOS.add(build);
            }
         }
      }

      return materialInventoryDTOS;
   }

   @Override
   public MaterialInventory selectById(Long id) {
      return this.materialInventoryMapper.selectByIdIncludeDel(id);
   }

   private Supplement getSupplement1(
      MaterialInventory materialInventory,
      Statistics statistics,
      BigDecimal mete,
      BigDecimal amount,
      BigDecimal amountExcludingVat,
      BigDecimal amountNoFreight,
      BigDecimal amountExcludingVatNoFreight,
      WmsClosingTime monthTimeRange
   ) {
      Supplement supplement = Supplement.builder()
         .classifyId(materialInventory.getClassifyId())
         .basicClass(materialInventory.getBasicClass())
         .specification(materialInventory.getSpecification())
         .projectId(materialInventory.getProjectId())
         .length(materialInventory.getLength())
         .width(materialInventory.getWidth())
         .thickness(materialInventory.getThickness())
         .brand(materialInventory.getBrand())
         .color(materialInventory.getColor())
         .workshopId(materialInventory.getWorkshopId())
         .accountingUnit(materialInventory.getAccountingUnit())
         .mete(mete)
         .amount(amount)
         .amountExcludingVat(amountExcludingVat)
         .amountNoFreight(amountNoFreight)
         .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
         .realTime(monthTimeRange.getEndTime().minusMinutes(1L))
         .build();
      Integer maxDayNumber = this.supplementMapper.getMaxDayNumber(LocalDateTime.now());
      supplement.setSerialNumber(this.numberConfigService.getNumber(NumberTypeEnum.SUPPLEMENT, maxDayNumber));
      this.supplementMapper.insert(supplement);
      StatisticsInbound inboundSupplement = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
      inboundSupplement.setMete(mete);
      inboundSupplement.setAmount(amount);
      inboundSupplement.setAmountExcludingVat(amountExcludingVat);
      inboundSupplement.setAmountNoFreight(amountNoFreight);
      inboundSupplement.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
      inboundSupplement.setStatisticsId(statistics.getId());
      inboundSupplement.setReceiptType(ReceiptTypeEnum.SUPPLEMENT.getType());
      inboundSupplement.setReceiptId(supplement.getId());
      inboundSupplement.setReceiptSerialNumber(supplement.getSerialNumber());
      inboundSupplement.setRealTime(monthTimeRange.getEndTime().minusMinutes(1L));
      this.statisticsInboundMapper.insert(inboundSupplement);
      return supplement;
   }
}
