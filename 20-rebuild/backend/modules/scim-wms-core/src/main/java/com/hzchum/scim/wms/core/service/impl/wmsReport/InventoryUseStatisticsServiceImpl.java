package com.hzchum.scim.wms.core.service.impl.wmsReport;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.InventoryUseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatisticsDate;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseStatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseStatisticsMergeDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseRecordService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryUseStatisticsDateMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryUseStatisticsMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryUseStatisticsServiceImpl
   extends ServiceImpl<InventoryUseStatisticsMapper, InventoryUseStatistics>
   implements InventoryUseStatisticsService {
   @Resource
   private InventoryUseRecordService inventoryUseRecordService;
   @Resource
   private InventoryUseStatisticsMapper inventoryUseStatisticsMapper;
   @Resource
   private InventoryUseStatisticsDateMapper inventoryUseStatisticsDateMapper;
   @Resource
   private MeasureService measureService;
   @Resource
   private QueryUtilService queryUtilService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   QueryUtilImpl queryUtil;

   @Override
   public List<InventoryUseStatisticsDate> getTimeList() {
      return this.inventoryUseStatisticsDateMapper
         .selectList((Wrapper<InventoryUseStatisticsDate>)new LambdaQueryWrapper<InventoryUseStatisticsDate>().orderByDesc(InventoryUseStatisticsDate::getId));
   }

   @Override
   public PageVO<InventoryUseStatisticsDTO> getInventoryUseStatistics(
      QueryInventoryUseStatisticsDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<InventoryUseStatistics> inventoryUseStatistics = this.inventoryUseStatisticsMapper.getInventoryUseStatistics(dtoParam);
      if (CollectionUtil.isEmpty(inventoryUseStatistics)) {
         return new PageVO<>();
      }

      List<Long> statisticsIds = new ArrayList<>();
      List<Long> classifyIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();
      List<Long> projectIds = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatistics) {
         statisticsIds.add(inventoryUseStatistic.getId());
         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getClassifyId())) {
            classifyIds.add(inventoryUseStatistic.getClassifyId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWorkshopId())) {
            workshopIds.add(inventoryUseStatistic.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWarehouseId())) {
            warehouseIds.add(inventoryUseStatistic.getWarehouseId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getProjectId())) {
            projectIds.add(inventoryUseStatistic.getProjectId());
         }
      }

      Map<Long, Classification> classificationMap = this.queryUtilService.getClassificationMapByIds(classifyIds);
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseIds);
      Map<Long, ContractProject> projectMapByIds = this.queryUtilService.getProjectMapByIds(projectIds);
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, statisticsIds));
      List<InventoryUseStatisticsDTO> inventoryUseStatisticsDTOS = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatistics) {
         InventoryUseStatisticsDTO copy = BeanUtil.copy(inventoryUseStatistic, InventoryUseStatisticsDTO.class);
         Measure measure = measureMap.get(inventoryUseStatistic.getClassifyId());
         List<InventoryUseRecord> inventoryUseRecordList = inventoryUseRecords.stream()
            .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistic.getId()))
            .collect(Collectors.toList());
         List<InventoryUseRecord> inboundInventoryUseRecordList = inventoryUseRecordList.stream()
            .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(1))
            .collect(Collectors.toList());
         BigDecimal inboundQuantity = inboundInventoryUseRecordList.stream()
            .map(InventoryUseRecord::getQuantity)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         copy.setInboundStageTotalQuantity(inboundQuantity);
         BigDecimal inboundMete = inboundInventoryUseRecordList.stream()
            .map(InventoryUseRecord::getMete)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         copy.setInboundStageTotalMete(inboundMete);
         List<InventoryUseRecord> outboundInventoryUseRecordList = inventoryUseRecordList.stream()
            .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(2))
            .collect(Collectors.toList());
         BigDecimal outboundQuantity = outboundInventoryUseRecordList.stream()
            .map(InventoryUseRecord::getQuantity)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         copy.setOutboundStageTotalQuantity(outboundQuantity);
         BigDecimal outboundMete = outboundInventoryUseRecordList.stream()
            .map(InventoryUseRecord::getMete)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         copy.setOutboundStageTotalMete(outboundMete);
         copy.setEndStageTotalQuantity(copy.getBeginStageTotalQuantity().add(inboundQuantity).subtract(outboundQuantity));
         copy.setEndStageTotalMete(copy.getBeginStageTotalMete().add(inboundMete).subtract(outboundMete));
         ContractProject contractProject = projectMapByIds.get(inventoryUseStatistic.getProjectId());
         copy.setProject(BeanUtil.copy(contractProject, ProjectInfo.class));
         copy.setClassifyName(classificationMap.get(inventoryUseStatistic.getClassifyId()).getName());
         copy.setClassifySerialNumber(classificationMap.get(inventoryUseStatistic.getClassifyId()).getSerialNumber());
         copy.setMeasure(measure);
         Workshop workshop = workshopMap.get(inventoryUseStatistic.getWorkshopId());
         copy.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         Warehouse warehouse = warehouseMap.get(inventoryUseStatistic.getWarehouseId());
         copy.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         String s1 = this.queryUtil
            .buildCompositeKey(inventoryUseStatistic.getClassifyId(), inventoryUseStatistic.getSpecification(), inventoryUseStatistic.getThickness());
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         copy.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         inventoryUseStatisticsDTOS.add(copy);
         if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            copy.setBeginStageTotalQuantity(null);
            copy.setEndStageTotalQuantity(null);
            copy.setInboundStageTotalQuantity(null);
            copy.setOutboundStageTotalQuantity(null);
         }

         inventoryUseStatisticsDTOS.add(copy);
      }

      return new PageVO<>(page, inventoryUseStatisticsDTOS);
   }

   @Override
   public PageVO<InventoryUseStatisticsMergeDTO> getInventoryUseStatisticsNew(
      QueryInventoryUseStatisticsDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      InventoryUseConfig inventoryBasicConf = this.basicConfigService.getInventoryBasicConf();
      Page page = PageHelper.startPage(pageNumber, pageSize, null);
      List<String> idsStr = this.inventoryUseStatisticsMapper.getInventoryUseStatisticsNew(dtoParam, inventoryBasicConf);
      if (CollectionUtil.isEmpty(idsStr)) {
         return new PageVO<>();
      }

      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateMapper.selectById(dtoParam.getStatisticsDateId());
      List<InventoryUseStatisticsMergeDTO> inventoryUseStatisticsMergeDTOS = this.convertMergeDTO(idsStr, inventoryUseStatisticsDate.getBoolBalance());
      return new PageVO<>(page, inventoryUseStatisticsMergeDTOS);
   }

   @Override
   public List<InventoryUseStatisticsMergeDTO> convertMergeDTO(List<String> idsStr, Boolean boolBalance) {
      List<Long> idsAll = idsStr.stream().flatMap(str -> Arrays.stream(str.split(",")).map(Long::valueOf)).collect(Collectors.toList());
      List<InventoryUseStatistics> inventoryUseStatisticsAll = this.inventoryUseStatisticsMapper.selectBatchIds(idsAll);
      List<Long> statisticsIds = new ArrayList<>();
      List<Long> classifyIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();
      List<Long> projectIds = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatisticsAll) {
         statisticsIds.add(inventoryUseStatistic.getId());
         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getClassifyId())) {
            classifyIds.add(inventoryUseStatistic.getClassifyId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWorkshopId())) {
            workshopIds.add(inventoryUseStatistic.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWarehouseId())) {
            warehouseIds.add(inventoryUseStatistic.getWarehouseId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getProjectId())) {
            projectIds.add(inventoryUseStatistic.getProjectId());
         }
      }

      Map<Long, Classification> classificationMap = this.queryUtilService.getClassificationMapByIds(classifyIds);
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseIds);
      Map<Long, ProjectInfo> projectInfoMap = this.queryUtilService.getProjectInfoMapByIds(projectIds);
      Map<String, WmsMaterialCodeConfig> materialCodeConfigMaps = this.queryUtil.getMaterialCodeConfigMaps(null);
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, statisticsIds));
      List<InventoryUseStatisticsMergeDTO> inventoryUseStatisticsMergeDTOS = new ArrayList<>();

      for (String string : idsStr) {
         List<Long> ids = Arrays.stream(string.split(",")).map(Long::valueOf).collect(Collectors.toList());
         List<InventoryUseStatistics> inventoryUseStatisticsList = inventoryUseStatisticsAll.stream()
            .filter(i -> ids.contains(i.getId()))
            .collect(Collectors.toList());
         InventoryUseStatistics inventoryUseStatisticsGetOne = inventoryUseStatisticsList.get(0);
         InventoryUseStatisticsMergeDTO inventoryUseStatisticsMergeDTO = BeanUtil.copy(inventoryUseStatisticsGetOne, InventoryUseStatisticsMergeDTO.class);
         Measure measure = measureMap.get(inventoryUseStatisticsGetOne.getClassifyId());
         inventoryUseStatisticsMergeDTO.setClassifyName(classificationMap.get(inventoryUseStatisticsGetOne.getClassifyId()).getName());
         inventoryUseStatisticsMergeDTO.setClassifySerialNumber(classificationMap.get(inventoryUseStatisticsGetOne.getClassifyId()).getSerialNumber());
         inventoryUseStatisticsMergeDTO.setMeasure(measure);
         List<Long> idList = new ArrayList<>();
         List<String> specificationList = new ArrayList<>();
         List<String> brandList = new ArrayList<>();
         List<ProjectInfo> projectInfos = new ArrayList<>();
         List<BriefIdAndNameDTO> workshopInfoList = new ArrayList<>();
         List<BriefIdAndNameDTO> warehouseInfoList = new ArrayList<>();
         List<String> colorList = new ArrayList<>();
         List<String> warehouseNameList = new ArrayList<>();
         List<String> heatNoAndBatchNoList = new ArrayList<>();
         List<String> classSerialNumber = new ArrayList<>();
         BigDecimal beginStageTotalQuantity = new BigDecimal("0");
         BigDecimal beginStageTotalMete = new BigDecimal("0");
         BigDecimal inboundStageTotalQuantity = new BigDecimal("0");
         BigDecimal inboundStageTotalMete = new BigDecimal("0");
         BigDecimal transferStageTotalQuantity = new BigDecimal("0");
         BigDecimal transferStageTotalMete = new BigDecimal("0");
         BigDecimal outboundStageTotalQuantity = new BigDecimal("0");
         BigDecimal outboundStageTotalMete = new BigDecimal("0");

         for (InventoryUseStatistics inventoryUseStatistics : inventoryUseStatisticsList) {
            idList.add(inventoryUseStatistics.getId());
            StringBuilder spec = new StringBuilder();
            if (BasicClassEnum.STEEL_PLATE.getType().equals(inventoryUseStatistics.getBasicClass())) {
               spec.append(inventoryUseStatistics.getThickness().stripTrailingZeros().toPlainString());
               if (inventoryUseStatistics.getWidth() != null) {
                  spec.append("*").append(inventoryUseStatistics.getWidth().stripTrailingZeros().toPlainString());
               }

               if (inventoryUseStatistics.getLength() != null) {
                  spec.append("*").append(inventoryUseStatistics.getLength().stripTrailingZeros().toPlainString());
               }

               if (inventoryUseStatistics.getSpecification() != null) {
                  spec.append(" * ").append(inventoryUseStatistics.getSpecification());
               }
            } else if (BasicClassEnum.COLOR_ROLL.getType().equals(inventoryUseStatistics.getBasicClass())) {
               spec.append(inventoryUseStatistics.getThickness().stripTrailingZeros().toPlainString());
               if (inventoryUseStatistics.getWidth() != null) {
                  spec.append("*").append(inventoryUseStatistics.getWidth().stripTrailingZeros().toPlainString());
               }

               if (inventoryUseStatistics.getSpecification() != null) {
                  spec.append(" * ").append(inventoryUseStatistics.getSpecification());
               }
            } else if (BasicClassEnum.SECTION_STEEL.getType().equals(inventoryUseStatistics.getBasicClass())
               || BasicClassEnum.checkNotSteel(inventoryUseStatistics.getBasicClass())) {
               if (inventoryUseStatistics.getLength() != null) {
                  spec.append(inventoryUseStatistics.getLength().stripTrailingZeros().toPlainString());
               }

               if (spec.length() > 0) {
                  spec.append(" * ");
               }

               if (inventoryUseStatistics.getSpecification() != null) {
                  spec.append(inventoryUseStatistics.getSpecification());
               }
            }

            if (spec.length() > 0 && !specificationList.contains(spec.toString())) {
               specificationList.add(spec.toString());
            }

            if (inventoryUseStatistics.getBrand() != null && !brandList.contains(inventoryUseStatistics.getBrand())) {
               brandList.add(inventoryUseStatistics.getBrand());
            }

            if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getProjectId())
               && !projectInfos.stream().map(ProjectInfo::getId).collect(Collectors.toList()).contains(inventoryUseStatistics.getProjectId())
               && inventoryUseStatistics.getProjectId() > 0L) {
               projectInfos.add(projectInfoMap.get(inventoryUseStatistics.getProjectId()));
            }

            StringBuilder warehouseName = new StringBuilder();
            if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getWorkshopId())
               && !workshopInfoList.stream().map(BriefIdAndNameDTO::getId).collect(Collectors.toList()).contains(inventoryUseStatistics.getWorkshopId())) {
               Workshop workshop = workshopMap.get(inventoryUseStatistics.getWorkshopId());
               workshopInfoList.add(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
               warehouseName.append(workshop.getName()).append("->");
            }

            if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getWarehouseId())
               && !warehouseInfoList.stream().map(BriefIdAndNameDTO::getId).collect(Collectors.toList()).contains(inventoryUseStatistics.getWarehouseId())) {
               Warehouse warehouse = warehouseMap.get(inventoryUseStatistics.getWarehouseId());
               warehouseInfoList.add(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               warehouseName.append(warehouse.getName());
            }

            if (warehouseName.length() > 0 && !warehouseNameList.contains(warehouseName.toString())) {
               warehouseNameList.add(warehouseName.toString());
            }

            if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getColor()) && !colorList.contains(inventoryUseStatistics.getColor())) {
               colorList.add(inventoryUseStatistics.getColor());
            }

            if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getHeatNoAndBatchNo())
               && !heatNoAndBatchNoList.contains(inventoryUseStatistics.getHeatNoAndBatchNo())) {
               heatNoAndBatchNoList.add(inventoryUseStatistics.getHeatNoAndBatchNo());
            }

            if (ObjectUtil.isNotEmpty(inventoryUseStatistics.getSerialNumber()) && !classSerialNumber.contains(inventoryUseStatistics.getSerialNumber())) {
               classSerialNumber.add(inventoryUseStatistics.getSerialNumber());
            }

            beginStageTotalQuantity = beginStageTotalQuantity.add(inventoryUseStatistics.getBeginStageTotalQuantity());
            beginStageTotalMete = beginStageTotalMete.add(inventoryUseStatistics.getBeginStageTotalMete());
            if (boolBalance) {
               inboundStageTotalQuantity = inboundStageTotalQuantity.add(inventoryUseStatistics.getInboundStageTotalQuantity());
               inboundStageTotalMete = inboundStageTotalMete.add(inventoryUseStatistics.getInboundStageTotalMete());
               transferStageTotalQuantity = transferStageTotalQuantity.add(inventoryUseStatistics.getTransferStageTotalQuantity());
               transferStageTotalMete = transferStageTotalMete.add(inventoryUseStatistics.getTransferStageTotalMete());
               outboundStageTotalQuantity = outboundStageTotalQuantity.add(inventoryUseStatistics.getOutboundStageTotalQuantity());
               outboundStageTotalMete = outboundStageTotalMete.add(inventoryUseStatistics.getOutboundStageTotalMete());
            } else {
               List<InventoryUseRecord> inventoryUseRecordList = inventoryUseRecords.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistics.getId()))
                  .collect(Collectors.toList());
               List<InventoryUseRecord> inboundInventoryUseRecordList = inventoryUseRecordList.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(1))
                  .collect(Collectors.toList());
               BigDecimal inboundQuantity = inboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               inboundStageTotalQuantity = inboundStageTotalQuantity.add(inboundQuantity);
               BigDecimal inboundMete = inboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               inboundStageTotalMete = inboundStageTotalMete.add(inboundMete);
               List<InventoryUseRecord> transferInventoryUseRecordList = inventoryUseRecordList.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(3))
                  .collect(Collectors.toList());
               BigDecimal transferQuantity = transferInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               transferStageTotalQuantity = transferStageTotalQuantity.add(transferQuantity);
               BigDecimal transferMete = transferInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               transferStageTotalMete = transferStageTotalMete.add(transferMete);
               List<InventoryUseRecord> outboundInventoryUseRecordList = inventoryUseRecordList.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(2))
                  .collect(Collectors.toList());
               BigDecimal outboundQuantity = outboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               outboundStageTotalQuantity = outboundStageTotalQuantity.add(outboundQuantity);
               BigDecimal outboundMete = outboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               outboundStageTotalMete = outboundStageTotalMete.add(outboundMete);
            }
         }

         inventoryUseStatisticsMergeDTO.setIdList(idList);
         inventoryUseStatisticsMergeDTO.setSpecificationList(specificationList);
         inventoryUseStatisticsMergeDTO.setBrandList(brandList);
         inventoryUseStatisticsMergeDTO.setProjectInfoList(projectInfos);
         inventoryUseStatisticsMergeDTO.setWorkshopInfoList(workshopInfoList);
         inventoryUseStatisticsMergeDTO.setWarehouseInfoList(warehouseInfoList);
         inventoryUseStatisticsMergeDTO.setWarehouseNameList(warehouseNameList);
         inventoryUseStatisticsMergeDTO.setColorList(colorList);
         inventoryUseStatisticsMergeDTO.setHeatNoAndBatchNoList(heatNoAndBatchNoList);
         inventoryUseStatisticsMergeDTO.setClassSerialNumber(classSerialNumber);
         inventoryUseStatisticsMergeDTO.setBeginStageTotalQuantity(beginStageTotalQuantity);
         inventoryUseStatisticsMergeDTO.setBeginStageTotalMete(beginStageTotalMete);
         inventoryUseStatisticsMergeDTO.setInboundStageTotalQuantity(inboundStageTotalQuantity);
         inventoryUseStatisticsMergeDTO.setInboundStageTotalMete(inboundStageTotalMete);
         inventoryUseStatisticsMergeDTO.setTransferStageTotalQuantity(transferStageTotalQuantity);
         inventoryUseStatisticsMergeDTO.setTransferStageTotalMete(transferStageTotalMete);
         inventoryUseStatisticsMergeDTO.setOutboundStageTotalQuantity(outboundStageTotalQuantity);
         inventoryUseStatisticsMergeDTO.setOutboundStageTotalMete(outboundStageTotalMete);
         String s1 = this.queryUtil
            .buildCompositeKey(
               inventoryUseStatisticsGetOne.getClassifyId(), inventoryUseStatisticsGetOne.getSpecification(), inventoryUseStatisticsGetOne.getThickness()
            );
         WmsMaterialCodeConfig wmsMaterialCodeConfig = materialCodeConfigMaps.get(s1);
         inventoryUseStatisticsMergeDTO.setMaterialSnNew(ObjectUtil.isNotEmpty(wmsMaterialCodeConfig) ? wmsMaterialCodeConfig.getMaterialSnNew() : "");
         inventoryUseStatisticsMergeDTO.setEndStageTotalQuantity(
            beginStageTotalQuantity.add(inboundStageTotalQuantity).add(transferStageTotalQuantity).subtract(outboundStageTotalQuantity)
         );
         inventoryUseStatisticsMergeDTO.setEndStageTotalMete(
            beginStageTotalMete.add(inboundStageTotalMete).add(transferStageTotalMete).subtract(outboundStageTotalMete)
         );
         if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            inventoryUseStatisticsMergeDTO.setBeginStageTotalQuantity(null);
            inventoryUseStatisticsMergeDTO.setEndStageTotalQuantity(null);
            inventoryUseStatisticsMergeDTO.setInboundStageTotalQuantity(null);
            inventoryUseStatisticsMergeDTO.setOutboundStageTotalQuantity(null);
         }

         inventoryUseStatisticsMergeDTOS.add(inventoryUseStatisticsMergeDTO);
      }

      return inventoryUseStatisticsMergeDTOS;
   }

   @Override
   public InventoryUseStatistics getInventoryUseStatisticsByMaterialInventory(MaterialInventory materialInventory, Long statisticsDateId) {
      return this.inventoryUseStatisticsMapper.getInventoryUseStatisticsByMaterialInventory(materialInventory, statisticsDateId);
   }

   @Override
   public Map<String, String> getSteelCount(QueryInventoryUseStatisticsDTOParam dtoParam) {
      Map<String, String> map = new LinkedHashMap<>();
      if (!ObjectUtil.isEmpty(dtoParam.getBasicClass())
         && (
            BasicClassEnum.STEEL_PLATE.getType().equals(dtoParam.getBasicClass())
               || BasicClassEnum.SECTION_STEEL.getType().equals(dtoParam.getBasicClass())
               || BasicClassEnum.COLOR_ROLL.getType().equals(dtoParam.getBasicClass())
         )) {
         InventoryUseConfig inventoryBasicConf = this.basicConfigService.getInventoryBasicConf();
         List<String> idsStr = this.inventoryUseStatisticsMapper.getInventoryUseStatisticsNew(dtoParam, inventoryBasicConf);
         if (CollectionUtil.isEmpty(idsStr)) {
            return map;
         }

         List<Long> idsAll = idsStr.stream().flatMap(str -> Arrays.stream(str.split(",")).map(Long::valueOf)).collect(Collectors.toList());
         List<InventoryUseStatistics> inventoryUseStatisticsAll = this.inventoryUseStatisticsMapper.selectBatchIds(idsAll);
         InventoryUseStatistics inventoryUseStatisticsGet = inventoryUseStatisticsAll.get(0);
         InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateMapper
            .selectOne(
               (Wrapper<InventoryUseStatisticsDate>)new LambdaQueryWrapper<InventoryUseStatisticsDate>()
                  .eq(InventoryUseStatisticsDate::getId, inventoryUseStatisticsGet.getStatisticsDateId())
            );
         Integer basicClass = inventoryUseStatisticsGet.getBasicClass();
         String measureUnit = BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)
            ? "张"
            : (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass) ? "根" : (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass) ? "米" : "-"));
         boolean boolColorRoll = BasicClassEnum.COLOR_ROLL.getType().equals(basicClass);
         if (inventoryUseStatisticsDate.getBoolBalance()) {
            BigDecimal beginStageTotalQuantity = new BigDecimal("0");
            BigDecimal beginStageTotalMete = new BigDecimal("0");
            BigDecimal inboundStageTotalQuantity = new BigDecimal("0");
            BigDecimal inboundStageTotalMete = new BigDecimal("0");
            BigDecimal transferStageTotalQuantity = new BigDecimal("0");
            BigDecimal transferStageTotalMete = new BigDecimal("0");
            BigDecimal outboundStageTotalQuantity = new BigDecimal("0");
            BigDecimal outboundStageTotalMete = new BigDecimal("0");
            BigDecimal endStageTotalQuantity = new BigDecimal("0");
            BigDecimal endStageTotalMete = new BigDecimal("0");

            for (InventoryUseStatistics inventoryUseStatistics : inventoryUseStatisticsAll) {
               beginStageTotalQuantity = beginStageTotalQuantity.add(inventoryUseStatistics.getBeginStageTotalQuantity());
               beginStageTotalMete = beginStageTotalMete.add(inventoryUseStatistics.getBeginStageTotalMete());
               inboundStageTotalQuantity = inboundStageTotalQuantity.add(inventoryUseStatistics.getInboundStageTotalQuantity());
               inboundStageTotalMete = inboundStageTotalMete.add(inventoryUseStatistics.getInboundStageTotalMete());
               transferStageTotalQuantity = transferStageTotalQuantity.add(inventoryUseStatistics.getTransferStageTotalQuantity());
               transferStageTotalMete = transferStageTotalMete.add(inventoryUseStatistics.getTransferStageTotalMete());
               outboundStageTotalQuantity = outboundStageTotalQuantity.add(inventoryUseStatistics.getOutboundStageTotalQuantity());
               outboundStageTotalMete = outboundStageTotalMete.add(inventoryUseStatistics.getOutboundStageTotalMete());
               endStageTotalQuantity = endStageTotalQuantity.add(inventoryUseStatistics.getEndStageTotalQuantity());
               endStageTotalMete = endStageTotalMete.add(inventoryUseStatistics.getEndStageTotalMete());
            }

            String begin = (
                  boolColorRoll
                     ? beginStageTotalQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                     : beginStageTotalQuantity.stripTrailingZeros().toPlainString()
               )
               + measureUnit
               + "/"
               + beginStageTotalMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
               + "吨";
            map.put("期初", begin);
            String inbound = (
                  boolColorRoll
                     ? inboundStageTotalQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                     : inboundStageTotalQuantity.stripTrailingZeros().toPlainString()
               )
               + measureUnit
               + "/"
               + inboundStageTotalMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
               + "吨";
            map.put("入库", inbound);
            String transfer = (
                  boolColorRoll
                     ? transferStageTotalQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                     : transferStageTotalQuantity.stripTrailingZeros().toPlainString()
               )
               + measureUnit
               + "/"
               + transferStageTotalMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
               + "吨";
            map.put("调拨", transfer);
            String outbound = (
                  boolColorRoll
                     ? outboundStageTotalQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                     : outboundStageTotalQuantity.stripTrailingZeros().toPlainString()
               )
               + measureUnit
               + "/"
               + outboundStageTotalMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
               + "吨";
            map.put("出库", outbound);
            String end = (
                  boolColorRoll
                     ? endStageTotalQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                     : endStageTotalQuantity.stripTrailingZeros().toPlainString()
               )
               + measureUnit
               + "/"
               + endStageTotalMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
               + "吨";
            map.put("期末", end);
         } else {
            List<Long> statisticsIds = inventoryUseStatisticsAll.stream().map(InventoryUseStatistics::getId).collect(Collectors.toList());
            List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
               .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, statisticsIds));
            BigDecimal beginStageTotalQuantity = inventoryUseStatisticsAll.stream()
               .map(InventoryUseStatistics::getBeginStageTotalQuantity)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal beginStageTotalMete = inventoryUseStatisticsAll.stream()
               .map(InventoryUseStatistics::getBeginStageTotalMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            map.put(
               "期初",
               (
                     boolColorRoll
                        ? beginStageTotalQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                        : beginStageTotalQuantity.stripTrailingZeros().toPlainString()
                  )
                  + measureUnit
                  + "/"
                  + beginStageTotalMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
                  + "吨"
            );
            List<InventoryUseRecord> inboundInventoryUseRecordList = inventoryUseRecords.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(1))
               .collect(Collectors.toList());
            BigDecimal inboundQuantity = inboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundMete = inboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            map.put(
               "入库",
               (
                     boolColorRoll
                        ? inboundQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                        : inboundQuantity.stripTrailingZeros().toPlainString()
                  )
                  + measureUnit
                  + "/"
                  + inboundMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
                  + "吨"
            );
            List<InventoryUseRecord> transferInventoryUseRecordList = inventoryUseRecords.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(3))
               .collect(Collectors.toList());
            BigDecimal transferQuantity = transferInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal transferMete = transferInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            map.put(
               "调拨",
               (
                     boolColorRoll
                        ? transferQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                        : transferQuantity.stripTrailingZeros().toPlainString()
                  )
                  + measureUnit
                  + "/"
                  + transferMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
                  + "吨"
            );
            List<InventoryUseRecord> outboundInventoryUseRecordList = inventoryUseRecords.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(2))
               .collect(Collectors.toList());
            BigDecimal outboundQuantity = outboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getQuantity)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundMete = outboundInventoryUseRecordList.stream()
               .map(InventoryUseRecord::getMete)
               .filter(ObjectUtil::isNotEmpty)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            map.put(
               "出库",
               (
                     boolColorRoll
                        ? outboundQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                        : outboundQuantity.stripTrailingZeros().toPlainString()
                  )
                  + measureUnit
                  + "/"
                  + outboundMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
                  + "吨"
            );
            BigDecimal endQuantity = beginStageTotalQuantity.add(inboundQuantity).add(transferQuantity).subtract(outboundQuantity);
            BigDecimal endMete = beginStageTotalMete.add(inboundMete).add(transferMete).subtract(outboundMete);
            map.put(
               "期末",
               (
                     boolColorRoll
                        ? endQuantity.divide(UnitsPrecisionEnum.LG_M.getRate()).stripTrailingZeros().toPlainString()
                        : endQuantity.stripTrailingZeros().toPlainString()
                  )
                  + measureUnit
                  + "/"
                  + endMete.divide(UnitsPrecisionEnum.EG_T.getRate()).stripTrailingZeros().toPlainString()
                  + "吨"
            );
         }

         return map;
      } else {
         return map;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean weighting(Boolean boolMonth, LocalDateTime endTime, String name) {
      InventoryUseConfig inventoryBasicConf = this.basicConfigService.getInventoryBasicConf();
      if (boolMonth && !inventoryBasicConf.getBoolEndMonth()) {
         return true;
      }

      LocalDateTime now = LocalDateTime.now();
      endTime = endTime.with(LocalTime.MAX);
      if (!boolMonth) {
         if (inventoryBasicConf.getBoolEndMonth()) {
            Preconditions.checkArgument(false, "库存使用配置为月末计算，禁止手动计算");
         }

         LocalDateTime yesterdayMax = now.plusDays(-1L).with(LocalTime.MAX);
         if (endTime.isAfter(yesterdayMax)) {
            Preconditions.checkArgument(false, "最小日期需为昨日");
         }
      }

      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateMapper
         .selectOne((Wrapper<InventoryUseStatisticsDate>)new LambdaQueryWrapper<InventoryUseStatisticsDate>().eq(InventoryUseStatisticsDate::getBoolBalance, false));
      Preconditions.checkArgument(
         inventoryUseStatisticsDate.getStartTime().isBefore(endTime),
         "当前时间已结存,请在<" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(inventoryUseStatisticsDate.getStartTime()) + ">后执行"
      );
      List<InventoryUseStatistics> inventoryUseStatistics = this.inventoryUseStatisticsMapper
         .selectList(
            (Wrapper<InventoryUseStatistics>)new LambdaQueryWrapper<InventoryUseStatistics>().eq(InventoryUseStatistics::getStatisticsDateId, inventoryUseStatisticsDate.getId())
         );
      if (CollectionUtil.isEmpty(inventoryUseStatistics)) {
         return true;
      }

      LocalDateTime tomorrowMin = endTime.plusDays(1L).with(LocalTime.MIN);
      InventoryUseStatisticsDate newInventoryUseStatisticsDate = InventoryUseStatisticsDate.builder().startTime(tomorrowMin).boolBalance(false).build();
      this.inventoryUseStatisticsDateMapper.insert(newInventoryUseStatisticsDate);
      LocalDateTime startTime = inventoryUseStatisticsDate.getStartTime();
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list(
            (Wrapper<InventoryUseRecord>)(new LambdaQueryWrapper<InventoryUseRecord>().ge(BaseEntity::getCreateTime, startTime))
               .le(BaseEntity::getCreateTime, endTime)
         );
      List<InventoryUseRecord> afterInventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().gt(BaseEntity::getCreateTime, endTime));

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatistics) {
         List<InventoryUseRecord> collect = inventoryUseRecords.stream()
            .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistic.getId()))
            .collect(Collectors.toList());
         if (CollectionUtil.isEmpty(collect) && inventoryUseStatistic.getBeginStageTotalMete().compareTo(BigDecimal.ZERO) == 0) {
            inventoryUseStatistic.setStatisticsDateId(newInventoryUseStatisticsDate.getId());
            inventoryUseStatistic.setUpdateTime(now);
            this.inventoryUseStatisticsMapper.updateById(inventoryUseStatistic);
         } else {
            List<InventoryUseRecord> inboundData = collect.stream().filter(c -> c.getEmbodyType().equals(1)).collect(Collectors.toList());
            List<InventoryUseRecord> outboundData = collect.stream().filter(c -> c.getEmbodyType().equals(2)).collect(Collectors.toList());
            List<InventoryUseRecord> transferData = collect.stream().filter(c -> c.getEmbodyType().equals(3)).collect(Collectors.toList());
            BigDecimal inboundSumQuantity = inboundData.stream().map(InventoryUseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inboundSumMete = inboundData.stream().map(InventoryUseRecord::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal transferSumQuantity = transferData.stream().map(InventoryUseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal transferSumMete = transferData.stream().map(InventoryUseRecord::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundSumQuantity = outboundData.stream().map(InventoryUseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal outboundSumMete = outboundData.stream().map(InventoryUseRecord::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            inventoryUseStatistic.setInboundStageTotalQuantity(inboundSumQuantity);
            inventoryUseStatistic.setInboundStageTotalMete(inboundSumMete);
            inventoryUseStatistic.setTransferStageTotalQuantity(transferSumQuantity);
            inventoryUseStatistic.setTransferStageTotalMete(transferSumMete);
            inventoryUseStatistic.setOutboundStageTotalQuantity(outboundSumQuantity);
            inventoryUseStatistic.setOutboundStageTotalMete(outboundSumMete);
            inventoryUseStatistic.setEndStageTotalQuantity(
               inventoryUseStatistic.getBeginStageTotalQuantity().add(inboundSumQuantity).add(transferSumQuantity).subtract(outboundSumQuantity)
            );
            inventoryUseStatistic.setEndStageTotalMete(
               inventoryUseStatistic.getBeginStageTotalMete().add(inboundSumMete).add(transferSumMete).subtract(outboundSumMete)
            );
            inventoryUseStatistic.setUpdateTime(now);
            this.inventoryUseStatisticsMapper.updateById(inventoryUseStatistic);
            List<InventoryUseRecord> afterInventoryUseRecordList = afterInventoryUseRecords.stream()
               .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistic.getId()))
               .collect(Collectors.toList());
            if (inventoryUseStatistic.getEndStageTotalMete().compareTo(BigDecimal.ZERO) > 0 || CollectionUtil.isNotEmpty(afterInventoryUseRecordList)) {
               BigDecimal endStageTotalQuantity = inventoryUseStatistic.getEndStageTotalQuantity();
               BigDecimal endStageTotalMete = inventoryUseStatistic.getEndStageTotalMete();
               InventoryUseStatistics copy = BeanUtil.copy(inventoryUseStatistic, InventoryUseStatistics.class);
               copy.setStatisticsDateId(newInventoryUseStatisticsDate.getId());
               copy.setBeginStageTotalQuantity(endStageTotalQuantity);
               copy.setBeginStageTotalMete(endStageTotalMete);
               copy.setInboundStageTotalQuantity(BigDecimal.ZERO);
               copy.setInboundStageTotalMete(BigDecimal.ZERO);
               copy.setTransferStageTotalQuantity(BigDecimal.ZERO);
               copy.setTransferStageTotalMete(BigDecimal.ZERO);
               copy.setOutboundStageTotalQuantity(BigDecimal.ZERO);
               copy.setOutboundStageTotalMete(BigDecimal.ZERO);
               copy.setEndStageTotalQuantity(BigDecimal.ZERO);
               copy.setEndStageTotalMete(BigDecimal.ZERO);
               copy.setId(null);
               this.inventoryUseStatisticsMapper.insert(copy);
               if (CollectionUtil.isNotEmpty(afterInventoryUseRecordList)) {
                  List<Long> inventoryUseRecordIds = afterInventoryUseRecordList.stream().map(InventoryUseRecord::getId).collect(Collectors.toList());
                  this.inventoryUseRecordService
                     .update(
                        null,
                        (Wrapper<InventoryUseRecord>)(new LambdaUpdateWrapper<InventoryUseRecord>()
                              .set(InventoryUseRecord::getInventoryUseStatisticsId, copy.getId()))
                           .in(InventoryUseRecord::getId, inventoryUseRecordIds)
                     );
               }
            }
         }
      }

      inventoryUseStatisticsDate.setName(name);
      endTime = endTime.plus(-1L, ChronoUnit.SECONDS);
      inventoryUseStatisticsDate.setEndTime(endTime);
      inventoryUseStatisticsDate.setBoolBalance(true);
      this.inventoryUseStatisticsDateMapper.updateById(inventoryUseStatisticsDate);
      return true;
   }

   @Override
   public List<InventoryUseRecordDTO> getUseRecordByStatisticsId(Long id, Integer formType) {
      InventoryUseStatistics inventoryUseStatistics = this.inventoryUseStatisticsMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inventoryUseStatistics), "库存使用统计信息不存在");
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateMapper.selectById(inventoryUseStatistics.getStatisticsDateId());
      LocalDateTime startTime = inventoryUseStatisticsDate.getStartTime();
      LocalDateTime endTime = inventoryUseStatisticsDate.getEndTime();
      List<InventoryUseRecordDTO> detailDTOList;
      switch (formType) {
         case 1:
            detailDTOList = this.inventoryUseRecordService.getDetailDTOList(id, startTime, endTime, formType);
            break;
         case 2:
            detailDTOList = this.inventoryUseRecordService.getDetailDTOList(id, startTime, endTime, formType).stream().peek(l -> {
               if (BasicClassEnum.COLOR_ROLL.getType().equals(l.getBasicClass()) && l.getLength() != null) {
                  l.setMeasureUnit("张");
                  l.setMeasurePrecision(0);
               }
            }).collect(Collectors.toList());
            break;
         default:
            detailDTOList = new ArrayList<>();
      }

      List<Long> classifyIds = detailDTOList.stream().map(InventoryUseRecordDTO::getClassifyId).collect(Collectors.toList());
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);

      for (InventoryUseRecordDTO inventoryUseRecordDTO : detailDTOList) {
         Measure measure = measureMap.get(inventoryUseRecordDTO.getClassifyId());
         if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            inventoryUseRecordDTO.setQuantity(null);
         }
      }

      return detailDTOList;
   }

   @Override
   public List<InventoryUseRecordDTO> getUseRecordByStatisticsNew(List<Long> ids, Integer formType) {
      List<InventoryUseStatistics> inventoryUseStatisticsList = this.inventoryUseStatisticsMapper.selectBatchIds(ids);
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(inventoryUseStatisticsList), "库存使用统计信息不存在");
      InventoryUseStatistics inventoryUseStatistics = inventoryUseStatisticsList.get(0);
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateMapper.selectById(inventoryUseStatistics.getStatisticsDateId());
      LocalDateTime startTime = inventoryUseStatisticsDate.getStartTime();
      LocalDateTime endTime = inventoryUseStatisticsDate.getEndTime();
      List<InventoryUseRecordDTO> detailDTOList;
      switch (formType) {
         case 1:
            detailDTOList = this.inventoryUseRecordService.getDetailDTOListNew(ids, startTime, endTime, formType);
            break;
         case 2:
            detailDTOList = this.inventoryUseRecordService.getDetailDTOListNew(ids, startTime, endTime, formType);
            break;
         case 3:
            detailDTOList = this.inventoryUseRecordService.getDetailDTOListNew(ids, startTime, endTime, formType);
            break;
         case 4:
         case 5:
            detailDTOList = this.getUseStatisticsDTO(inventoryUseStatisticsList, formType, inventoryUseStatisticsDate.getBoolBalance());
            break;
         default:
            detailDTOList = new ArrayList<>();
      }

      List<Long> classifyIds = detailDTOList.stream().map(InventoryUseRecordDTO::getClassifyId).collect(Collectors.toList());
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);

      for (InventoryUseRecordDTO inventoryUseRecordDTO : detailDTOList) {
         Measure measure = measureMap.get(inventoryUseRecordDTO.getClassifyId());
         if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            inventoryUseRecordDTO.setQuantity(null);
         }
      }

      return detailDTOList;
   }

   private List<InventoryUseRecordDTO> getUseStatisticsDTO(List<InventoryUseStatistics> inventoryUseStatisticsList, Integer formType, Boolean boolBalance) {
      List<Long> statisticsIds = new ArrayList<>();
      List<Long> classifyIds = new ArrayList<>();
      List<Long> workshopIds = new ArrayList<>();
      List<Long> warehouseIds = new ArrayList<>();
      List<Long> projectIds = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatisticsList) {
         statisticsIds.add(inventoryUseStatistic.getId());
         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getClassifyId())) {
            classifyIds.add(inventoryUseStatistic.getClassifyId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWorkshopId())) {
            workshopIds.add(inventoryUseStatistic.getWorkshopId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getWarehouseId())) {
            warehouseIds.add(inventoryUseStatistic.getWarehouseId());
         }

         if (ObjectUtil.isNotEmpty(inventoryUseStatistic.getProjectId())) {
            projectIds.add(inventoryUseStatistic.getProjectId());
         }
      }

      Map<Long, Classification> classificationMap = this.queryUtilService.getClassificationMapByIds(classifyIds);
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
      Map<Long, Workshop> workshopMap = this.queryUtilService.getWorkshopMapByIds(workshopIds);
      Map<Long, Warehouse> warehouseMap = this.queryUtilService.getWarehouseMapByIds(warehouseIds);
      Map<Long, ContractProject> projectMapByIds = this.queryUtilService.getProjectMapByIds(projectIds);
      List<InventoryUseRecord> inventoryUseRecords = this.inventoryUseRecordService
         .list((Wrapper<InventoryUseRecord>)new LambdaQueryWrapper<InventoryUseRecord>().in(InventoryUseRecord::getInventoryUseStatisticsId, statisticsIds));
      List<InventoryUseRecordDTO> inventoryUseRecordDTOS = new ArrayList<>();

      for (InventoryUseStatistics inventoryUseStatistic : inventoryUseStatisticsList) {
         InventoryUseRecordDTO copy = BeanUtil.copy(inventoryUseStatistic, InventoryUseRecordDTO.class);
         if (formType == 4) {
            if (inventoryUseStatistic.getBeginStageTotalMete().compareTo(BigDecimal.ZERO) == 0) {
               continue;
            }

            copy.setQuantity(inventoryUseStatistic.getBeginStageTotalQuantity());
            copy.setMete(inventoryUseStatistic.getBeginStageTotalMete());
         } else if (formType == 5) {
            if (boolBalance) {
               copy.setQuantity(inventoryUseStatistic.getEndStageTotalQuantity());
               copy.setMete(inventoryUseStatistic.getEndStageTotalMete());
            } else {
               List<InventoryUseRecord> inventoryUseRecordList = inventoryUseRecords.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getInventoryUseStatisticsId().equals(inventoryUseStatistic.getId()))
                  .collect(Collectors.toList());
               List<InventoryUseRecord> inboundInventoryUseRecordList = inventoryUseRecordList.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(1))
                  .collect(Collectors.toList());
               BigDecimal inboundQuantity = inboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal inboundMete = inboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               List<InventoryUseRecord> transferInventoryUseRecordList = inventoryUseRecordList.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(3))
                  .collect(Collectors.toList());
               BigDecimal transferQuantity = transferInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal transferMete = transferInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               List<InventoryUseRecord> outboundInventoryUseRecordList = inventoryUseRecordList.stream()
                  .filter(inventoryUseRecord -> inventoryUseRecord.getEmbodyType().equals(2))
                  .collect(Collectors.toList());
               BigDecimal outboundQuantity = outboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getQuantity)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal outboundMete = outboundInventoryUseRecordList.stream()
                  .map(InventoryUseRecord::getMete)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal endQuantity = inventoryUseStatistic.getBeginStageTotalQuantity()
                  .add(inboundQuantity)
                  .add(transferQuantity)
                  .subtract(outboundQuantity);
               BigDecimal endMete = inventoryUseStatistic.getBeginStageTotalMete().add(inboundMete).add(transferMete).subtract(outboundMete);
               copy.setQuantity(endQuantity);
               copy.setMete(endMete);
            }
         } else {
            Preconditions.checkArgument(false, "未知类型");
         }

         Measure measure = measureMap.get(inventoryUseStatistic.getClassifyId());
         ContractProject contractProject = projectMapByIds.get(inventoryUseStatistic.getProjectId());
         copy.setProject(BeanUtil.copy(contractProject, ProjectInfo.class));
         copy.setClassifyName(classificationMap.get(inventoryUseStatistic.getClassifyId()).getName());
         copy.setClassifySerialNumber(classificationMap.get(inventoryUseStatistic.getClassifyId()).getSerialNumber());
         copy.setMeasure(measure);
         Workshop workshop = workshopMap.get(inventoryUseStatistic.getWorkshopId());
         copy.setWorkshop(BriefIdAndNameDTO.builder().id(workshop.getId()).name(workshop.getName()).build());
         Warehouse warehouse = warehouseMap.get(inventoryUseStatistic.getWarehouseId());
         copy.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
         if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            copy.setQuantity(null);
         }

         inventoryUseRecordDTOS.add(copy);
      }

      return inventoryUseRecordDTOS;
   }
}
