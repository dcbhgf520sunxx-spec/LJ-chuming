package com.hzchum.scim.mes.building.core.biz.impl.wage_manage;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.wage_manage.MesYieldConfirmBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcessDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesYieldConfirm;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.ApportionReportDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmWorkshopProcessTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesYieldConfirmWorkshopProcessTeamPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesYieldConfirmSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesCoatingProcessService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesYieldConfirmService;
import com.hzchum.scim.mes.building.core.mapper.wage_manage.MesYieldConfirmMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.ComparisonOperatorEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectCoatingConfigLinkDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationService;
import com.hzchum.scim.system.core.api.service.MesAssemblingWeldingConfigService;
import com.hzchum.scim.system.core.api.service.MesBoltSleeveService;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectBoltSleeveLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectCoatingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectGroupWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesContractProjectStatisticsConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesGroupWeldingConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesYieldConfirmBizImpl extends IBizImpl<MesYieldConfirmService, MesYieldConfirmMapper, MesYieldConfirm> implements MesYieldConfirmBiz {
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkService assemblingWeldingConfigLinkService;
   @Autowired
   private MesAssemblingWeldingConfigService assemblingWeldingConfigService;
   @Autowired
   private MesContractProjectGroupWeldingConfigLinkService groupWeldingConfigLinkService;
   @Autowired
   private MesGroupWeldingConfigService groupWeldingConfigService;
   @Autowired
   private MesContractProjectLayingOffConfigLinkService layingOffConfigLinkService;
   @Autowired
   private TechArtifactMachinePartLinkService techArtifactMachinePartLinkService;
   @Autowired
   private MesContractProjectBoltSleeveLinkService boltSleeveLinkService;
   @Autowired
   private MesBoltSleeveService boltSleeveService;
   @Autowired
   private TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesContractProjectCoatingConfigLinkService coatingConfigLinkService;
   @Autowired
   private TechArtifactExtService techArtifactExtService;
   @Autowired
   private MesCoatingProcessService mesCoatingProcessService;
   @Autowired
   private ConfigService configService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private MesArtifactClassificationService artifactClassificationService;
   @Autowired
   private MesContractProjectStatisticsConfigLinkService contractProjectStatisticsConfigLinkService;

   @Override
   public PageVO<MesYieldConfirmWorkshopProcessTeamDTO> unauditedWorkshopProcessTeamList(
      Long workshopId, Integer yearMonthDaySelect, LocalDateTime selectedDate, Long processId, Integer pageNumber, Integer pageSize
   ) {
      Preconditions.checkArgument(CollUtil.newArrayList(1, 2, 3).contains(yearMonthDaySelect), "年月日选择不存在");
      Page<MesYieldConfirmWorkshopProcessTeamDTO> page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(page, this.baseMapper.unauditedWorkshopProcessTeamList(workshopId, yearMonthDaySelect, selectedDate, processId));
   }

   @Override
   public PageVO<MesYieldConfirmDTO> unauditedList(
      Long workshopId,
      Long processId,
      String teamLeaderName,
      Integer productType,
      Integer yearMonthDaySelect,
      LocalDateTime selectedDate,
      String projectName,
      String productSerialNumber,
      Integer pageNum,
      Integer pageSize,
      List<String> sort
   ) {
      Preconditions.checkArgument(
         CollUtil.newArrayList(ProductTypeEnum.ARTIFACT.getType(), ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType())
            .contains(productType),
         "产品类型不存在"
      );
      Page<MesYieldConfirmDTO> page = PageHelper.startPage(pageNum, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesYieldConfirmDTO> unauditedList = this.baseMapper
         .unauditedList(workshopId, processId, teamLeaderName, productType, yearMonthDaySelect, selectedDate, projectName, productSerialNumber);
      Preconditions.checkArgument(CollUtil.isNotEmpty(unauditedList), "无未确认数据");
      unauditedList.forEach(e -> {
         e.setOldMeasurementQuantity(ObjectUtil.defaultIfNull(e.getOldMeasurementQuantity(), e.getMeasurementQuantity()));
         e.setOldWage(ObjectUtil.defaultIfNull(e.getOldWage(), e.getWage()));
      });
      return new PageVO<>(page, unauditedList);
   }

   private BigDecimal getCoatingPrice(MesContractProjectCoatingConfigLinkDTO ccl, MesCoatingProcessDetail coatingProcessDetail) {
      BigDecimal price;
      if (coatingProcessDetail.getThickness() <= ccl.getThickness()) {
         price = ccl.getUnitPrice();
      } else {
         Integer quotientNumber = (coatingProcessDetail.getThickness() - ccl.getThickness()) / ccl.getOutThickness();
         BigDecimal outUnitPrice = ccl.getOutUnitPrice().multiply(BigDecimal.valueOf(quotientNumber.intValue()));
         price = ccl.getUnitPrice().add(outUnitPrice);
      }

      return price;
   }

   private BigDecimal getWebPlateThickness(String specPrefix, String specification) {
      String[] specList = TechUtils.getSpecList(specification);
      if (specPrefix.equals("BH") || specPrefix.equals("H")) {
         if (specList.length == 4) {
            if (!specification.contains("-")) {
               return new BigDecimal(specList[2]);
            }

            return new BigDecimal(specList[1]);
         }

         if (specList.length == 5) {
            return new BigDecimal(specList[2]);
         }

         if (specList.length == 6) {
            return new BigDecimal(specList[1]);
         }

         if (specList.length == 7) {
            return new BigDecimal(specList[2]);
         }
      }

      if (specPrefix.equals("BOX")) {
         return new BigDecimal(specList[2]);
      }

      if (specPrefix.equals("BP")) {
         if (specList.length == 2) {
            return new BigDecimal(specList[1]);
         }

         if (specList.length == 3) {
            return new BigDecimal(specList[2]);
         }

         if (specList.length == 4) {
            return new BigDecimal(specList[2]);
         }

         if (specList.length == 5 && specification.contains("~")) {
            return new BigDecimal(specList[3]);
         }

         if (specList.length == 5 && !specification.contains("~")) {
            return new BigDecimal(specList[4]);
         }
      }

      if (specPrefix.equals("BT") || specPrefix.equals("T")) {
         return new BigDecimal(specList[1]);
      }

      if (specPrefix.equals("HI")) {
         return new BigDecimal(specList[1]);
      }

      if (specPrefix.equals("HK")) {
         if (specList.length == 5) {
            return new BigDecimal(specList[1]);
         }

         if (specList.length == 7) {
            return new BigDecimal(specList[1]);
         }
      }

      if (specPrefix.equals("PHI")) {
         return new BigDecimal(specList[2]);
      }

      if (specification.contains("-")) {
         return new BigDecimal(specList[1]);
      }

      Preconditions.checkArgument(specList.length > 2, "规格格式错误: " + specification);
      return new BigDecimal(specList[2]);
   }

   private String getMeasurementUnit(Integer measurementManner) {
      WageQuotaTypeEnum typeEnum = WageQuotaTypeEnum.getEnumByType(measurementManner);
      if (typeEnum != null) {
         switch (typeEnum) {
            case WEIGHT_PRICE:
               return "吨";
            case LENGTH_PRICE:
               return "米";
            case QUANTITY_PRICE:
               return "张";
            case AREA_PRICE:
               return "平方米";
         }
      }

      return null;
   }

   private BigDecimal getInventoryQuantity(Integer measurementManner, Integer inspectionQuantity, TechArtifact artifact, Integer proportionQuantity) {
      WageQuotaTypeEnum typeEnum = WageQuotaTypeEnum.getEnumByType(measurementManner);
      if (typeEnum == null) {
         return BigDecimal.ZERO;
      }

      BigDecimal inventoryQuantity;
      switch (typeEnum) {
         case WEIGHT_PRICE:
            inventoryQuantity = artifact.getNetWeight()
               .multiply(BigDecimal.valueOf(inspectionQuantity.intValue()).divide(BigDecimal.valueOf(proportionQuantity.intValue()), 2, RoundingMode.HALF_UP))
               .divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
            break;
         case LENGTH_PRICE:
            inventoryQuantity = artifact.getLength()
               .multiply(BigDecimal.valueOf(inspectionQuantity.intValue()).divide(BigDecimal.valueOf(proportionQuantity.intValue()), 2, RoundingMode.HALF_UP))
               .divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP);
            break;
         case QUANTITY_PRICE:
            inventoryQuantity = BigDecimal.valueOf(inspectionQuantity.intValue())
               .divide(BigDecimal.valueOf(proportionQuantity.intValue()), 2, RoundingMode.HALF_UP);
            break;
         default:
            inventoryQuantity = BigDecimal.ZERO;
      }

      return inventoryQuantity;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveYieldConfirm(ValidList<MesYieldConfirmSaveDTOParam> saveDTOParamList) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<MesYieldConfirm> yieldConfirmList = saveDTOParamList.stream().map(e -> {
         Preconditions.checkArgument(e.getWage() != null, "工价不能为空");
         if (!e.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            Preconditions.checkArgument(e.getOldMeasureQuantity() != null || e.getNewMeasureQuantity() != null, "计量量不能为空");
         }

         MesYieldConfirm yieldConfirm = BeanUtil.toBean(e, MesYieldConfirm.class);
         if (yieldConfirm.getNewMeasureQuantity() != null && yieldConfirm.getNewQuotaPrice() != null) {
            BigDecimal wage = yieldConfirm.getNewMeasureQuantity().multiply(yieldConfirm.getNewQuotaPrice());
            yieldConfirm.setWage(wage);
         }

         yieldConfirm.setOperatorId(currentUser.getId());
         yieldConfirm.setOperatorName(currentUser.getName());
         yieldConfirm.setOperateDate(LocalDateTime.now());
         return yieldConfirm;
      }).collect(Collectors.toList());
      this.baseService.saveBatch(yieldConfirmList);
      return Boolean.TRUE;
   }

   @Override
   public List<MesYieldConfirmWorkshopProcessTeamDTO> auditedWorkshopProcessTeamList(Integer statisticsModeEnum, Long workshopId, LocalDateTime selectedDate) {
      return this.baseMapper.auditedWorkshopProcessTeamUniversalConfigurationList(statisticsModeEnum, workshopId, selectedDate);
   }

   @Override
   public PrintVO auditedWorkshopProcessTeamListPrint(Integer statisticsModeEnum, Long workshopId, LocalDateTime selectedDate) {
      PrintVO printVO = new PrintVO();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      List<MesYieldConfirmWorkshopProcessTeamDTO> workshopProcessTeamDTOList = this.baseMapper
         .auditedWorkshopProcessTeamUniversalConfigurationList(statisticsModeEnum, workshopId, selectedDate);
      workshopProcessTeamDTOList.forEach(workshopProcessTeamDTO -> {
         MesYieldConfirmWorkshopProcessTeamPrintDTO printDTO = BeanUtil.toBean(workshopProcessTeamDTO, MesYieldConfirmWorkshopProcessTeamPrintDTO.class);
         table.add(BeanUtil.beanToMap(printDTO));
      });
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public PageVO<MesYieldConfirmDTO> auditedList(
      Long workshopId,
      Long processId,
      Long teamId,
      Integer productType,
      LocalDateTime selectedDate,
      String projectName,
      String productSerialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      Preconditions.checkArgument(
         CollUtil.newArrayList(ProductTypeEnum.ARTIFACT.getType(), ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType())
            .contains(productType),
         "产品类型不存在"
      );
      Page<MesYieldConfirmDTO> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesYieldConfirmDTO> auditedList = this.baseMapper
         .auditedUniversalConfigurationList(workshopId, processId, teamId, productType, selectedDate, projectName, productSerialNumber);
      return new PageVO<>(page, auditedList);
   }

   @Override
   public List<Map<String, Object>> apportionReport(Integer year, Long workshopId) {
      Map<Integer, BigDecimal> totalInboundQuantityMap = this.baseMapper
         .getTotalInboundQuantity(year, workshopId)
         .stream()
         .collect(Collectors.toMap(ApportionReportDataDTO::getMonthValue, ApportionReportDataDTO::getTotalInboundQuantity));
      Map<String, Map<Integer, BigDecimal>> costMap = this.baseMapper
         .getCurrencyCost(year, workshopId)
         .stream()
         .filter(c -> c.getMonthValue() != null)
         .collect(
            Collectors.groupingBy(ApportionReportDataDTO::getTypeName, Collectors.toMap(ApportionReportDataDTO::getMonthValue, ApportionReportDataDTO::getCost))
         );
      List<Map<String, Object>> list = new ArrayList<>();
      costMap.keySet()
         .forEach(
            typeName -> {
               Map<String, Object> map = new HashMap<>();
               Map<Integer, BigDecimal> monthMap = costMap.getOrDefault(typeName, new HashMap<>());
               map.put("type", typeName);
               String january = monthMap.getOrDefault(1, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(1, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("january", january);
               String february = monthMap.getOrDefault(2, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(2, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("february", february);
               String march = monthMap.getOrDefault(3, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(3, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("march", march);
               String april = monthMap.getOrDefault(4, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(4, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("april", april);
               String may = monthMap.getOrDefault(5, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(5, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("may", may);
               String june = monthMap.getOrDefault(6, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(6, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("june", june);
               String july = monthMap.getOrDefault(7, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(7, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("july", july);
               String august = monthMap.getOrDefault(8, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(8, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("august", august);
               String september = monthMap.getOrDefault(9, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(9, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("september", september);
               String october = monthMap.getOrDefault(10, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(10, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("october", october);
               String november = monthMap.getOrDefault(11, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(11, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("november", november);
               String december = monthMap.getOrDefault(12, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP)
                  + "/"
                  + totalInboundQuantityMap.getOrDefault(12, BigDecimal.ZERO).setScale(3, RoundingMode.HALF_UP);
               map.put("december", december);
               list.add(map);
            }
         );
      return list;
   }

   @Override
   public PrintVO apportionReportPrint(Integer year, Long workshopId) {
      PrintVO printVO = new PrintVO();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", year);
      printVO.setHeader(header);
      List<Map<String, Object>> table = this.apportionReport(year, workshopId);
      printVO.setTable(table);
      return printVO;
   }

   private static class MaxAndMin {
      public final Integer max;
      public final Integer min;

      public MaxAndMin(Integer max, Integer min) {
         this.max = max;
         this.min = min;
      }

      private static MesYieldConfirmBizImpl.MaxAndMin getMaxAndMin(
         Integer comparisonOperatorOne, Integer numberOne, Integer comparisonOperatorTwo, Integer numberTwo
      ) {
         Integer max = null;
         Integer min = null;
         if (comparisonOperatorOne != null && numberOne != null) {
            ComparisonOperatorEnum operatorEnum = ComparisonOperatorEnum.getEnum(comparisonOperatorOne);
            if (operatorEnum != null) {
               switch (operatorEnum) {
                  case LESS_THAN:
                     max = numberOne - 1;
                     break;
                  case LESS_THAN_EQUAL:
                     max = numberOne;
                     break;
                  case GREATER_THAN:
                     min = numberOne + 1;
                     break;
                  case GREATER_THAN_EQUAL:
                     min = numberOne;
               }
            }
         }

         if (comparisonOperatorTwo != null && numberTwo != null) {
            ComparisonOperatorEnum operatorEnum = ComparisonOperatorEnum.getEnum(comparisonOperatorTwo);
            if (operatorEnum != null) {
               switch (operatorEnum) {
                  case LESS_THAN:
                     if (max != null) {
                        if (max <= numberTwo) {
                           max = numberTwo - 1;
                        }
                     } else {
                        max = numberTwo - 1;
                     }
                     break;
                  case LESS_THAN_EQUAL:
                     if (max != null) {
                        if (max <= numberTwo) {
                           max = numberTwo;
                        }
                     } else {
                        max = numberTwo;
                     }
                     break;
                  case GREATER_THAN:
                     if (min != null) {
                        if (min >= numberTwo) {
                           min = numberTwo + 1;
                        }
                     } else {
                        min = numberTwo + 1;
                     }
                     break;
                  case GREATER_THAN_EQUAL:
                     if (min != null) {
                        if (min >= numberTwo) {
                           min = numberTwo;
                        }
                     } else {
                        min = numberTwo;
                     }
               }
            }
         }

         return new MesYieldConfirmBizImpl.MaxAndMin(max, min);
      }

      private static boolean isEligible(MesYieldConfirmBizImpl.MaxAndMin maxAndMin, Integer value) {
         if (maxAndMin.max != null && maxAndMin.min != null) {
            if (value >= maxAndMin.min && value <= maxAndMin.max) {
               return Boolean.TRUE;
            }

            if (maxAndMin.min > maxAndMin.max) {
               return value >= maxAndMin.min || value <= maxAndMin.max;
            }
         } else {
            if (maxAndMin.max != null) {
               return value <= maxAndMin.max;
            }

            if (maxAndMin.min != null) {
               return value >= maxAndMin.min;
            }
         }

         return Boolean.FALSE;
      }

      private static boolean isEligible(MesYieldConfirmBizImpl.MaxAndMin maxAndMin, BigDecimal value) {
         BigDecimal max = maxAndMin.max != null ? BigDecimal.valueOf(maxAndMin.max.intValue()) : null;
         BigDecimal min = maxAndMin.min != null ? BigDecimal.valueOf(maxAndMin.min.intValue()) : null;
         if (maxAndMin.max != null && maxAndMin.min != null) {
            if (value.compareTo(min) >= 0 && value.compareTo(max) <= 0) {
               return Boolean.TRUE;
            }

            if (maxAndMin.min > maxAndMin.max) {
               return value.compareTo(min) >= 0 || value.compareTo(max) <= 0;
            }
         } else {
            if (maxAndMin.max != null) {
               return value.compareTo(max) <= 0;
            }

            if (maxAndMin.min != null) {
               return value.compareTo(min) >= 0;
            }
         }

         return Boolean.FALSE;
      }
   }
}
