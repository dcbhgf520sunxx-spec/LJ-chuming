package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWaterElectricityBiz;
import com.hzchum.scim.contract.core.api.enums.finance.ElectricityTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricity;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountExportDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWaterElectricityDtoParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWaterElectricityMapper;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractWaterElectricityBizImpl
   extends IBizImpl<ContractWaterElectricityService, ContractWaterElectricityMapper, ContractWaterElectricity>
   implements ContractWaterElectricityBiz {
   @Resource
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;

   @Override
   public ListVO<ContractWaterElectricityDTO> listByCondition(Integer year, Integer type, Integer childType) {
      return new ListVO<>(this.baseService.listByCondition(year, type, childType));
   }

   @Override
   public Boolean saveList(List<ContractWaterElectricityDtoParam> paramList) {
      paramList.forEach(
         param -> {
            Preconditions.checkArgument(WaterElectricityEnum.isExist(param.getType()), "水电费类型错误");
            Preconditions.checkArgument(
               WaterElectricityEnum.WATER.getType().equals(param.getType())
                  || param.getChildType() != null && ElectricityTypeEnum.isExist(param.getChildType()),
               "用电类型错误"
            );
            if (param.getId() != null) {
               ContractWaterElectricity waterElectricity = this.baseService.getById(param.getId());
               Preconditions.checkArgument(waterElectricity != null, "修改失败,费用记录不存在");
               Preconditions.checkArgument(waterElectricity.getBoolConfirmStatus().equals(false), "修改失败,费用填报已确认");
               Preconditions.checkArgument(param.getType().equals(waterElectricity.getType()), "水电费类型不能修改");
               Preconditions.checkArgument(param.getYear().equals(waterElectricity.getYear()), "水电费年份不能修改");
               Preconditions.checkArgument(param.getMonth().equals(waterElectricity.getMonth()), "水电费月份不能修改");
               Preconditions.checkArgument(
                  waterElectricity.getType().equals(WaterElectricityEnum.WATER.getType()) || param.getChildType().equals(waterElectricity.getChildType()),
                  "电费的用电类型不能修改"
               );
               BeanUtil.copy(param, waterElectricity);
               this.baseService.updateById(waterElectricity);
            } else {
               Preconditions.checkArgument(!this.baseService.isExist(param.getYear(), param.getMonth(), param.getType(), param.getChildType()), "新增失败,费用记录已存在");
               ContractWaterElectricity waterElectricity = BeanUtil.copy(param, ContractWaterElectricity.class);
               waterElectricity.setYearMonthValue(param.getYear() * 100 + param.getMonth());
               waterElectricity.setUserId(UserUtil.getCurrentUserId());
               waterElectricity.setBoolConfirmStatus(false);
               this.baseService.save(waterElectricity);
            }
         }
      );
      return true;
   }

   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractWaterElectricity waterElectricity = this.baseService.getById(id);
         Preconditions.checkArgument(waterElectricity != null, "水电费记录不存在");
         Preconditions.checkArgument(waterElectricity.getBoolConfirmStatus().equals(false), "水电费记录已确认,不能删除");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printWaterElectricityList(Integer year, Integer type, Integer childType) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      printVO.setHeader(header);
      List<ContractWaterElectricityDTO> dtoList = this.baseService.listByCondition(year, type, childType);
      List<Map<String, Object>> mapList = dtoList.stream()
         .map(
            s -> {
               Map<String, Object> map = BeanUtil.beanToMap(s);
               map.put(
                  "unitAmount",
                  s.getUsedMete().compareTo(BigDecimal.ZERO) > 0 ? s.getTotalAmount().divide(s.getUsedMete(), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO
               );
               return map;
            }
         )
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ListVO<ContractWaterElectricityCountDto> countWaterElectricity(Integer year) {
      if (year != null && year != 0) {
         List<ContractWaterElectricity> waterElectricityList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(ContractWaterElectricity.class)
                  .eq(ContractWaterElectricity::getYear, year)
                  .eq(BaseEntity::getBoolDeleteEnum, false)
                  .orderByAsc(ContractWaterElectricity::getMonth)
            );
         Set<Integer> monthSet = waterElectricityList.stream().map(ContractWaterElectricity::getMonth).collect(Collectors.toSet());
         Map<String, BigDecimal> meteOutPutByYear = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(year, 1, 1, 1, 1), null);
         List<ContractWaterElectricityCountDto> waterElectricityDtoList = new ArrayList<>();
         BigDecimal zero = new BigDecimal("0");

         for (int i = 1; i <= 12; i++) {
            ContractWaterElectricityCountDto waterElectricityDtoItem = new ContractWaterElectricityCountDto();
            waterElectricityDtoItem.setMonth(i);
            BigDecimal outputValue;
            if (i < 10) {
               outputValue = meteOutPutByYear.get(year + "-0" + i);
            } else {
               outputValue = meteOutPutByYear.get(year + "-" + i);
            }

            waterElectricityDtoItem.setMonthOutput(Objects.isNull(outputValue) ? zero : outputValue);
            if (!monthSet.contains(i)) {
               waterElectricityDtoItem.setWaterPrice(zero);
               waterElectricityDtoItem.setElectricityPrice(zero);
               waterElectricityDtoItem.setUsedElectricityMete(zero);
               waterElectricityDtoItem.setUsedWaterMete(zero);
            } else {
               Integer finalI = i;
               List<ContractWaterElectricity> currentMonthList = waterElectricityList.stream()
                  .filter(item -> finalI.equals(item.getMonth()))
                  .collect(Collectors.toList());
               List<ContractWaterElectricity> electricityList = currentMonthList.stream()
                  .filter(item -> WaterElectricityEnum.ELECTRICITY.getType().equals(item.getType()))
                  .collect(Collectors.toList());
               waterElectricityDtoItem.setUsedElectricityMete(
                  electricityList.stream().map(ContractWaterElectricity::getUsedMete).filter(Objects::nonNull).reduce(zero, BigDecimal::add)
               );
               waterElectricityDtoItem.setElectricityPrice(
                  electricityList.stream().map(ContractWaterElectricity::getTotalAmount).filter(Objects::nonNull).reduce(zero, BigDecimal::add)
               );
               List<ContractWaterElectricity> waterList = currentMonthList.stream()
                  .filter(item -> WaterElectricityEnum.WATER.getType().equals(item.getType()))
                  .collect(Collectors.toList());
               waterElectricityDtoItem.setUsedWaterMete(
                  waterList.stream().map(ContractWaterElectricity::getUsedMete).filter(Objects::nonNull).reduce(zero, BigDecimal::add)
               );
               waterElectricityDtoItem.setWaterPrice(
                  waterList.stream().map(ContractWaterElectricity::getTotalAmount).filter(Objects::nonNull).reduce(zero, BigDecimal::add)
               );
            }

            waterElectricityDtoList.add(waterElectricityDtoItem);
         }

         return new ListVO<>(waterElectricityDtoList);
      } else {
         throw new RuntimeException("参数有误");
      }
   }

   @Override
   public void exportWaterElectricityExcel(Integer year, HttpServletResponse response) {
      if (year != null && year != 0) {
         Calendar calendar = Calendar.getInstance();
         int currentYear = Calendar.getInstance().get(1);
         Preconditions.checkArgument(year <= currentYear, "统计年份暂未开始！");
         List<ContractWaterElectricity> waterElectricityList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(ContractWaterElectricity.class)
                  .eq(ContractWaterElectricity::getYear, year)
                  .eq(BaseEntity::getBoolDeleteEnum, false)
                  .orderByAsc(ContractWaterElectricity::getMonth)
            );
         Map<String, BigDecimal> meteOutPutByYear = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(year, 1, 1, 1, 1), null);
         List<ContractWaterElectricityCountExportDto> exportList = new ArrayList<>();
         BigDecimal zero = new BigDecimal("0.00");

         for (int i = 1; i <= 12; i++) {
            Integer finalI = i;
            ContractWaterElectricityCountExportDto exportItem = new ContractWaterElectricityCountExportDto();
            exportItem.setMonth(Integer.toString(i));
            int currentMonth = calendar.get(2) + 1;
            if (currentYear != year || i <= currentMonth) {
               BigDecimal outputValue;
               if (i < 10) {
                  outputValue = meteOutPutByYear.get(year + "-0" + i);
               } else {
                  outputValue = meteOutPutByYear.get(year + "-" + i);
               }

               exportItem.setMonthOutput(Objects.isNull(outputValue) ? zero : outputValue.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP));
               List<ContractWaterElectricity> currentMonthList = waterElectricityList.stream()
                  .filter(item -> finalI.equals(item.getMonth()))
                  .collect(Collectors.toList());
               List<ContractWaterElectricity> electricityList = currentMonthList.stream()
                  .filter(item -> WaterElectricityEnum.ELECTRICITY.getType().equals(item.getType()))
                  .collect(Collectors.toList());
               BigDecimal usedElectricityMete = electricityList.stream()
                  .map(ContractWaterElectricity::getUsedMete)
                  .filter(Objects::nonNull)
                  .reduce(zero, BigDecimal::add);
               exportItem.setUsedElectricityMete(usedElectricityMete.setScale(2, RoundingMode.HALF_UP));
               BigDecimal electricityPrice = electricityList.stream()
                  .map(ContractWaterElectricity::getTotalAmount)
                  .filter(Objects::nonNull)
                  .reduce(zero, BigDecimal::add);
               exportItem.setElectricityPrice(electricityPrice.setScale(2, RoundingMode.HALF_UP));
               if (zero.compareTo(usedElectricityMete) == 0) {
                  exportItem.setElectricityAvgPrice(electricityPrice.setScale(2, RoundingMode.HALF_UP));
               } else {
                  exportItem.setElectricityAvgPrice(electricityPrice.divide(usedElectricityMete, 2, RoundingMode.HALF_UP));
               }

               List<ContractWaterElectricity> waterList = currentMonthList.stream()
                  .filter(item -> WaterElectricityEnum.WATER.getType().equals(item.getType()))
                  .collect(Collectors.toList());
               BigDecimal usedWaterMete = waterList.stream().map(ContractWaterElectricity::getUsedMete).filter(Objects::nonNull).reduce(zero, BigDecimal::add);
               exportItem.setUsedWaterMete(usedWaterMete.setScale(2, RoundingMode.HALF_UP));
               BigDecimal waterPrice = waterList.stream().map(ContractWaterElectricity::getTotalAmount).filter(Objects::nonNull).reduce(zero, BigDecimal::add);
               exportItem.setWaterPrice(waterPrice.setScale(2, RoundingMode.HALF_UP));
               if (zero.compareTo(usedWaterMete) == 0) {
                  exportItem.setWaterAvgPrice(waterPrice.setScale(2, RoundingMode.HALF_UP));
               } else {
                  exportItem.setWaterAvgPrice(waterPrice.divide(usedWaterMete, 2, RoundingMode.HALF_UP));
               }

               if (zero.compareTo(exportItem.getMonthOutput()) == 0) {
                  exportItem.setConvertElectricityPrice(exportItem.getElectricityPrice());
                  exportItem.setConvertWaterPrice(exportItem.getWaterPrice());
               } else {
                  exportItem.setConvertElectricityPrice(exportItem.getElectricityPrice().divide(exportItem.getMonthOutput(), 2, RoundingMode.HALF_UP));
                  exportItem.setConvertWaterPrice(exportItem.getWaterPrice().divide(exportItem.getMonthOutput(), 2, RoundingMode.HALF_UP));
               }

               exportList.add(exportItem);
            }
         }

         ContractWaterElectricityCountExportDto total = new ContractWaterElectricityCountExportDto();
         total.setMonth("合计");
         total.setMonthOutput(
            exportList.stream().map(ContractWaterElectricityCountExportDto::getMonthOutput).reduce(zero, BigDecimal::add).setScale(2, RoundingMode.HALF_UP)
         );
         total.setUsedElectricityMete(
            exportList.stream()
               .map(ContractWaterElectricityCountExportDto::getUsedElectricityMete)
               .reduce(zero, BigDecimal::add)
               .setScale(2, RoundingMode.HALF_UP)
         );
         total.setElectricityPrice(
            exportList.stream()
               .map(ContractWaterElectricityCountExportDto::getElectricityPrice)
               .reduce(zero, BigDecimal::add)
               .setScale(2, RoundingMode.HALF_UP)
         );
         total.setUsedWaterMete(
            exportList.stream().map(ContractWaterElectricityCountExportDto::getUsedWaterMete).reduce(zero, BigDecimal::add).setScale(2, RoundingMode.HALF_UP)
         );
         total.setWaterPrice(
            exportList.stream().map(ContractWaterElectricityCountExportDto::getWaterPrice).reduce(zero, BigDecimal::add).setScale(2, RoundingMode.HALF_UP)
         );
         if (zero.compareTo(total.getUsedElectricityMete()) == 0) {
            total.setElectricityAvgPrice(total.getElectricityPrice());
         } else {
            total.setElectricityAvgPrice(total.getElectricityPrice().divide(total.getUsedElectricityMete(), 2, RoundingMode.HALF_UP));
         }

         if (zero.compareTo(total.getUsedWaterMete()) == 0) {
            total.setWaterAvgPrice(total.getWaterPrice());
         } else {
            total.setWaterAvgPrice(total.getWaterPrice().divide(total.getUsedWaterMete(), 2, RoundingMode.HALF_UP));
         }

         if (zero.compareTo(total.getMonthOutput()) == 0) {
            total.setConvertElectricityPrice(total.getElectricityPrice());
            total.setConvertWaterPrice(total.getWaterPrice());
         } else {
            total.setConvertElectricityPrice(total.getElectricityPrice().divide(total.getMonthOutput(), 2, RoundingMode.HALF_UP));
            total.setConvertWaterPrice(total.getWaterPrice().divide(total.getMonthOutput(), 2, RoundingMode.HALF_UP));
         }

         exportList.add(total);
         String title = year + "年 - 水电费统计报表";
         String sheetName = "水电费统计报表";
         String fileName = year + "年水电费统计报表.xlsx";
         PoiUtils.exportExcel(exportList, title, sheetName, ContractWaterElectricityCountExportDto.class, fileName, ExcelType.XSSF, response);
      } else {
         throw new RuntimeException("参数有误");
      }
   }
}
