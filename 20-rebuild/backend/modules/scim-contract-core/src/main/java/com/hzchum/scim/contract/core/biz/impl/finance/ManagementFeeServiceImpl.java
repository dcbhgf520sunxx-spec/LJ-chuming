package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ManagementFeeDto;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseReimburseService;
import com.hzchum.scim.contract.core.api.service.finance.ContractPropertyFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageSummaryService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ManagementFeeService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementFeeServiceImpl implements ManagementFeeService {
   @Autowired
   private ContractWageSummaryService contractWageSummaryService;
   @Autowired
   private ContractExpenseReimburseService contractExpenseReimburseService;
   @Autowired
   private ContractPropertyFeeService contractPropertyFeeService;
   @Resource
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Autowired
   private ContractReimbursementFeeService reimbursementFeeService;
   @Autowired
   private ContractWageFeeService wageFeeService;
   @Autowired
   private ContractWaterElectricityPropertyFeeService waterElectricityPropertyFeeService;

   @Override
   public ListVO<ManagementFeeDto> findAll(Integer year) {
      return new ListVO<>(this.listManagementFee(year));
   }

   private List<ManagementFeeDto> listManagementFee(Integer year) {
      BigDecimal zero = new BigDecimal("0.00");
      if (year != null && year != 0) {
         List<ManagementFeeDto> managementFeeDtoList = new ArrayList<>();
         ManagementFeeDto managementFeeDto = new ManagementFeeDto();
         managementFeeDto.setManagementUserCount(0);
         managementFeeDto.setManagementUserMoney(zero);
         managementFeeDto.setMonthCapacity(zero);
         managementFeeDto.setOtherMoney(zero);
         managementFeeDto.setAvgMoney(zero);
         managementFeeDto.setSumMoney(zero);
         managementFeeDto.setReimbursementMoney(zero);
         managementFeeDto.setMonth("合计");
         Map<Integer, BigDecimal> monthWageMap = new HashMap<>(16);
         Map<Integer, Integer> monthUserCountMap = new HashMap<>(16);
         Map<Integer, List<ContractWageFee>> wageFeeGroup = this.wageFeeService
            .list(Wrappers.lambdaQuery(ContractWageFee.class).eq(ContractWageFee::getFillInYear, year))
            .stream()
            .collect(Collectors.groupingBy(ContractWageFee::getFillInMonth));
         wageFeeGroup.forEach((month, list) -> {
            BigDecimal reduce = list.stream().map(ContractWageFee::getTotalWage).reduce(BigDecimal.ZERO, BigDecimal::add);
            int sum = list.stream().mapToInt(ContractWageFee::getEmployeeQuantity).sum();
            monthWageMap.put(month, reduce);
            monthUserCountMap.put(month, sum);
         });
         Map<Integer, BigDecimal> expenseMonthMap = new HashMap<>(16);
         Map<Integer, List<ContractReimbursementFee>> reimbursementFeeGroup = this.reimbursementFeeService
            .list(Wrappers.lambdaQuery(ContractReimbursementFee.class).apply("YEAR(reimbursement_date) = {0}", year))
            .stream()
            .collect(Collectors.groupingBy(rf -> rf.getReimbursementDate().getMonthValue()));
         reimbursementFeeGroup.forEach((month, list) -> {
            BigDecimal reduce = list.stream().map(ContractReimbursementFee::getReimbursementAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            expenseMonthMap.put(month, reduce);
         });
         Map<Integer, BigDecimal> propertyFeeMonthMap = this.waterElectricityPropertyFeeService
            .list(
               Wrappers.lambdaQuery(ContractWaterElectricityPropertyFee.class)
                  .eq(ContractWaterElectricityPropertyFee::getYear, year)
                  .eq(ContractWaterElectricityPropertyFee::getType, WaterElectricityPropertyFeeTypeEnum.PROPERTY_FEE.getType())
            )
            .stream()
            .collect(Collectors.toMap(ContractWaterElectricityPropertyFee::getMonth, ContractWaterElectricityPropertyFee::getTotalFee, BigDecimal::add));
         Map<String, BigDecimal> meteByYear = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(year, 1, 1, 1, 1), null, null);

         for (int i = 1; i <= 12; i++) {
            ManagementFeeDto dto = new ManagementFeeDto();
            dto.setMonth(i);
            BigDecimal bigDecimal;
            if (i < 10) {
               bigDecimal = meteByYear.getOrDefault(year + "-0" + i, BigDecimal.ZERO);
            } else {
               bigDecimal = meteByYear.getOrDefault(year + "-" + i, BigDecimal.ZERO);
            }

            dto.setMonthCapacity(bigDecimal);
            managementFeeDto.setMonthCapacity(managementFeeDto.getMonthCapacity().add(bigDecimal));
            dto.setManagementUserCount(monthUserCountMap.getOrDefault(i, 0));
            managementFeeDto.setManagementUserCount(managementFeeDto.getManagementUserCount() + dto.getManagementUserCount());
            dto.setManagementUserMoney(monthWageMap.getOrDefault(i, BigDecimal.ZERO));
            managementFeeDto.setManagementUserMoney(managementFeeDto.getManagementUserMoney().add(dto.getManagementUserMoney()));
            dto.setReimbursementMoney(expenseMonthMap.getOrDefault(i, BigDecimal.ZERO));
            managementFeeDto.setReimbursementMoney(managementFeeDto.getReimbursementMoney().add(dto.getReimbursementMoney()));
            dto.setOtherMoney(propertyFeeMonthMap.getOrDefault(i, BigDecimal.ZERO));
            managementFeeDto.setOtherMoney(managementFeeDto.getOtherMoney().add(dto.getOtherMoney()));
            dto.setSumMoney(dto.getManagementUserMoney().add(dto.getReimbursementMoney()).add(dto.getOtherMoney()));
            managementFeeDto.setSumMoney(managementFeeDto.getSumMoney().add(dto.getSumMoney()));
            dto.setAvgMoney(
               dto.getMonthCapacity().compareTo(BigDecimal.ZERO) != 0
                  ? dto.getSumMoney().multiply(BigDecimal.valueOf(1000L)).divide(dto.getMonthCapacity(), 2, 5)
                  : dto.getSumMoney()
            );
            managementFeeDto.setAvgMoney(
               managementFeeDto.getMonthCapacity().compareTo(BigDecimal.ZERO) != 0
                  ? managementFeeDto.getSumMoney().multiply(BigDecimal.valueOf(1000L)).divide(managementFeeDto.getMonthCapacity(), 2, RoundingMode.HALF_UP)
                  : managementFeeDto.getSumMoney()
            );
            managementFeeDtoList.add(dto);
         }

         managementFeeDtoList.add(managementFeeDto);
         return managementFeeDtoList;
      } else {
         throw new RuntimeException("参数有误");
      }
   }

   @Override
   public void export(Integer year, HttpServletResponse response) {
      List<ManagementFeeDto> feeDtoList = this.listManagementFee(year);
      feeDtoList.forEach(dto -> dto.setMonthCapacity(dto.getMonthCapacity().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)));
      PoiUtils.exportExcel(feeDtoList, year + "管理费用", year + "年汇总", ManagementFeeDto.class, year + "管理费用.xlsx", ExcelType.XSSF, response);
   }
}
