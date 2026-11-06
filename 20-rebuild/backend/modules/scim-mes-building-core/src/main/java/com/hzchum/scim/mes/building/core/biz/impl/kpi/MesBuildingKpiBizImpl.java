package com.hzchum.scim.mes.building.core.biz.impl.kpi;

import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.kpi.MesBuildingKpiBiz;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CargoListKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CompleteMeteYearDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.CarModleKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.CargoListKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.CargoListSummayKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.ProductionLineCompleteYieldKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.ProjectCargoListKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.ProjectCompleteYieldKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.QhseKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.QhseTypeKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingProductionLineDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingKpiBizImpl implements MesBuildingKpiBiz {
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;
   @Autowired
   private MesBuildingQhseService qhseService;

   @Override
   public CompleteMeteYearDTO completeByYear(LocalDateTime dateTime) {
      return CompleteMeteYearDTO.builder()
         .target(this.productionLineService.list().stream().map(MesBuildingProductionLine::getTargetProduction).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeMete(
            this.completeService.completeYieldGropMonth(dateTime).stream().map(ProductionCompleteYieldKpiDO::getYield).reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .build();
   }

   @Override
   public List<ProductionCompleteYieldKpiDO> completeYieldGropMonth(LocalDateTime dateTime) {
      return this.completeService.completeYieldGropMonth(dateTime);
   }

   @Override
   public List<ProductionLineCompleteYieldKpiDTO> productionLineCompleteYieldGropMonth(LocalDateTime dateTime) {
      List<ProductionLineCompleteYieldKpiDTO> dtoList = this.productionLineBiz
         .listByCondition(MesBuildingProductionLineDTOParam.builder().productType(ProductTypeEnum.ARTIFACT.getType()).build())
         .stream()
         .map(e -> BeanUtil.copy(e, ProductionLineCompleteYieldKpiDTO.class))
         .collect(Collectors.toList());
      if (dtoList.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, BigDecimal> lastMonthYield = this.completeService
         .completeYield(dateTime.minusMonths(1L), dtoList.stream().map(ProductionLineCompleteYieldKpiDTO::getId).collect(Collectors.toList()));
      Map<Long, BigDecimal> yield = this.completeService
         .completeYield(dateTime, dtoList.stream().map(ProductionLineCompleteYieldKpiDTO::getId).collect(Collectors.toList()));
      dtoList.forEach(e -> {
         e.setLastMonthYield(lastMonthYield.get(e.getId()));
         e.setYield(yield.get(e.getId()));
      });
      return dtoList;
   }

   @Override
   public List<ProjectCompleteYieldKpiDTO> projectCompleteYield(LocalDateTime dateTime) {
      return this.completeService
         .projectCompleteYield(dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectCompleteYieldKpiDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<CargoListKpiDTO> cargoListGroupByMonth(LocalDateTime dateTime) {
      return this.cargoListService.cargoListGroupByMonth(dateTime).stream().map(e -> BeanUtil.copy(e, CargoListKpiDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<QhseKpiDTO> qhseType(LocalDateTime dateTime) {
      List<QhseKpiDTO> dtoList = new ArrayList<>();
      dtoList.add(
         QhseKpiDTO.builder()
            .type(QhseTypeEnum.QUALITY.getType())
            .name(QhseTypeEnum.QUALITY.getName())
            .quantity(this.qhseService.getQuantityType(dateTime, QhseTypeEnum.QUALITY.getType() + QhseTypeEnum.SPECIAL_QUALITY.getType()))
            .build()
      );
      dtoList.add(
         QhseKpiDTO.builder()
            .type(QhseTypeEnum.ENVIRONMENT.getType())
            .name(QhseTypeEnum.ENVIRONMENT.getName())
            .quantity(this.qhseService.getQuantityType(dateTime, QhseTypeEnum.ENVIRONMENT.getType()))
            .build()
      );
      dtoList.add(
         QhseKpiDTO.builder()
            .type(QhseTypeEnum.SECURITY.getType())
            .name(QhseTypeEnum.SECURITY.getName())
            .quantity(this.qhseService.getQuantityType(dateTime, QhseTypeEnum.SECURITY.getType()))
            .build()
      );
      return dtoList;
   }

   @Override
   public List<QhseTypeKpiDTO> qualityQhseType(LocalDateTime dateTime) {
      List<QhseTypeKpiDTO> dtoList = new ArrayList<>();
      Map<String, String> dictionary = this.dictionaryService.getValueLabelByName(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName());
      List<MesBuildingQhse> qhseList = this.qhseService.getListByTimeAndType(dateTime, QhseTypeEnum.QUALITY.getType() + QhseTypeEnum.SPECIAL_QUALITY.getType());

      for (String key : dictionary.keySet()) {
         dtoList.add(QhseTypeKpiDTO.builder().type(dictionary.get(key)).quantity(this.decide(key, qhseList)).build());
      }

      return dtoList;
   }

   @Override
   public CargoListSummayKpiDTO cargoListSummary(LocalDateTime dateTime) {
      return CargoListSummayKpiDTO.builder()
         .cargoListAmount(this.cargoListService.cargoListAmountByYear(dateTime, ProductTypeEnum.ARTIFACT.getType()))
         .cargoListQuantity(this.cargoListService.cargoListGroupByMonth(dateTime).stream().mapToInt(CargoListKpiDO::getQuantity).sum())
         .lastDayAmount(this.cargoListService.cargoListAmountByDay(LocalDateTime.now().plusDays(-1L), ProductTypeEnum.ARTIFACT.getType()))
         .amount(this.cargoListService.cargoListAmountByDay(LocalDateTime.now(), ProductTypeEnum.ARTIFACT.getType()))
         .lastDayQuantity(this.cargoListService.cargoListQuantityByDay(LocalDateTime.now().plusDays(-1L), ProductTypeEnum.ARTIFACT.getType()))
         .quantity(this.cargoListService.cargoListQuantityByDay(LocalDateTime.now(), ProductTypeEnum.ARTIFACT.getType()))
         .stock(this.cargoListService.stockByDay(LocalDateTime.now(), ProductTypeEnum.ARTIFACT.getType()))
         .build();
   }

   @Override
   public List<CargoListKpiDTO> cargoListAmountGroupByMonth(LocalDateTime dateTime) {
      return this.cargoListService
         .cargoListAmountGroupByMonth(dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, CargoListKpiDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<CarModleKpiDTO> carModelByYear(LocalDateTime dateTime) {
      return this.cargoListService.carModelByYear(dateTime).stream().map(e -> BeanUtil.copy(e, CarModleKpiDTO.class)).collect(Collectors.toList());
   }

   @Override
   public List<ProjectCargoListKpiDTO> projectCargoListByYear(LocalDateTime dateTime) {
      return this.cargoListService
         .projectCargoListByYear(dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectCargoListKpiDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectCargoListKpiDTO> projectCargoListByDay(LocalDateTime dateTime) {
      return this.cargoListService
         .projectCargoListByDay(dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectCargoListKpiDTO.class))
         .collect(Collectors.toList());
   }

   private Integer decide(String a, List<MesBuildingQhse> qhseList) {
      Integer quantity = 0;
      StringBuilder stringBuilder = new StringBuilder();
      qhseList.forEach(e -> stringBuilder.append(",").append(e.getQualityType()));
      if (a != null && qhseList.size() != 0) {
         String[] typeArray = stringBuilder.toString().split(",");

         for (String s : typeArray) {
            if (a.equals(s)) {
               quantity = quantity + 1;
            }
         }

         return quantity;
      } else {
         return quantity;
      }
   }
}
