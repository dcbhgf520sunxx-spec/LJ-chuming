package com.hzchum.scim.contract.core.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.utils.ExcelExportStyler;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ContractFieldEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractAnalysisQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractPooledAnalysisDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractQuarterPooledAnalysisDTO;
import com.hzchum.scim.contract.core.api.service.ContractCatalogueService;
import com.hzchum.scim.contract.core.api.service.ContractFieldConfigService;
import com.hzchum.scim.contract.core.api.service.ContractPooledAnalysisService;
import com.hzchum.scim.system.core.api.pojo._do.SysLocation;
import com.hzchum.scim.system.core.api.service.SysLocationService;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class ContractPooledAnalysisServiceImpl implements ContractPooledAnalysisService {
   @Resource
   private ContractCatalogueService contractCatalogueService;
   @Resource
   private ContractFieldConfigService contractConfigService;
   @Resource
   private SysLocationService locationService;
   private static final BigDecimal TEN_THOUSAND = new BigDecimal(10000);
   private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

   @Override
   public List<ContractPooledAnalysisDTO> analyse(ContractAnalysisQueryDTOParam param) {
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(param.getRegisterDate()), "请选择登记时间");
      DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy");
      List<ContractCatalogue> contracts = this.contractCatalogueService
         .list(
            (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>()
                  .last("AND YEAR(" + (param.getType().equals(7) ? "sign_date" : "register_date") + ") = " + yyyy.format(param.getRegisterDate())))
               .eq(ContractCatalogue::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         );
      if (CollectionUtil.isEmpty(contracts)) {
         return new ArrayList<>();
      }

      Map<Long, List<ContractCatalogue>> collect = contracts.stream()
         .filter(c -> c.getFirstLevelDept() != null)
         .collect(Collectors.groupingBy(ContractCatalogue::getFirstLevelDept));
      Map<Long, ContractFieldConfig> firstLevelDeptMap = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.FIRST_LEVEL_DEPT.getType()))
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, Function.identity()));
      Map<Long, ContractFieldConfig> secondLevelDeptMap = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.SECOND_LEVEL_DEPT.getType()))
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, Function.identity()));
      List<ContractPooledAnalysisDTO> contractPooledAnalysisDTOS = new ArrayList<>();
      switch (param.getType()) {
         case 1:
            LocalDateTime lastYearDate = param.getRegisterDate().plusYears(-1L);
            List<ContractCatalogue> lastContracts = this.contractCatalogueService
               .list(
                  (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>()
                        .last("AND YEAR(" + (param.getType().equals(7) ? "sign_date" : "register_date") + ") = " + yyyy.format(lastYearDate)))
                     .eq(ContractCatalogue::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               );

            for (Long l : collect.keySet()) {
               List<ContractCatalogue> contractCatalogues = collect.get(l);
               BigDecimal totalAmount = contractCatalogues.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal signAmount = contractCatalogues.stream()
                  .filter(c -> ObjectUtil.isNotEmpty(c.getSignStatus()) && c.getSignStatus())
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal unSignAmount = contractCatalogues.stream()
                  .filter(c -> ObjectUtil.isNotEmpty(c.getSignStatus()) && !c.getSignStatus())
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal lastYearTotalAmount = lastContracts.stream()
                  .filter(c -> ObjectUtil.equal(c.getFirstLevelDept(), l))
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(l).getFieldValue())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .signAmount(signAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .unSignAmount(unSignAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .lastYearAmount(lastYearTotalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 2:
            for (Long l : collect.keySet()) {
               List<ContractCatalogue> contractCatalogues = collect.get(l);
               BigDecimal totalAmount = contractCatalogues.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal coordinateAmount = contractCatalogues.stream()
                  .filter(c -> ObjectUtil.isNotEmpty(c.getBoolCoordinate()) && c.getBoolCoordinate())
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal unCoordinateAmount = contractCatalogues.stream()
                  .filter(c -> ObjectUtil.isNotEmpty(c.getBoolCoordinate()) && !c.getBoolCoordinate())
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(l).getFieldValue())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .coordinateAmount(coordinateAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .unCoordinateAmount(unCoordinateAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 3:
            Map<Long, String> structureNameMap = this.contractConfigService
               .list(
                  (Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.STRUCTURE_TYPE.getType())
               )
               .stream()
               .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));

            for (Long l : collect.keySet()) {
               List<ContractCatalogue> contractCatalogues = collect.get(l);
               BigDecimal totalAmount = contractCatalogues.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Map<String, BigDecimal> map = new HashMap<>();

               for (Long aLong : structureNameMap.keySet()) {
                  BigDecimal reduce = contractCatalogues.stream()
                     .filter(c -> ObjectUtil.equal(c.getStructureType(), aLong))
                     .map(ContractCatalogue::getContractAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  map.put(structureNameMap.get(aLong), reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
               }

               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(l).getFieldValue())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .mapAmount(map)
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 4:
            Map<Long, String> biddingMethodMap = this.contractConfigService
               .list(
                  (Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.BIDDING_METHOD.getType())
               )
               .stream()
               .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));

            for (Long l : collect.keySet()) {
               List<ContractCatalogue> contractCatalogues = collect.get(l);
               BigDecimal totalAmount = contractCatalogues.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Map<String, BigDecimal> map = new HashMap<>();

               for (Long aLong : biddingMethodMap.keySet()) {
                  BigDecimal reduce = contractCatalogues.stream()
                     .filter(c -> ObjectUtil.equal(c.getBiddingMethod(), aLong))
                     .map(ContractCatalogue::getContractAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  map.put(biddingMethodMap.get(aLong), reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
               }

               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(l).getFieldValue())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .mapAmount(map)
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 5:
            Map<Long, String> partyTypeMap = this.contractConfigService
               .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.PARTY_TYPE.getType()))
               .stream()
               .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));

            for (Long l : collect.keySet()) {
               List<ContractCatalogue> contractCatalogues = collect.get(l);
               BigDecimal totalAmount = contractCatalogues.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Map<String, BigDecimal> map = new HashMap<>();

               for (Long aLong : partyTypeMap.keySet()) {
                  BigDecimal reduce = contractCatalogues.stream()
                     .filter(c -> ObjectUtil.equal(c.getPartyType(), aLong))
                     .map(ContractCatalogue::getContractAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  map.put(partyTypeMap.get(aLong), reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
               }

               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(l).getFieldValue())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .mapAmount(map)
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 6:
            List<SysLocation> sysLocationList = this.locationService.list(null);

            for (Long l : collect.keySet()) {
               List<ContractCatalogue> contractCatalogues = collect.get(l);
               BigDecimal totalAmount = contractCatalogues.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               Map<String, BigDecimal> map = new HashMap<>();

               for (SysLocation sysLocation : sysLocationList) {
                  List<ContractCatalogue> contractCatalogues1 = contractCatalogues.stream()
                     .filter(c -> ObjectUtil.equal(sysLocation.getId(), c.getLocationId()))
                     .collect(Collectors.toList());
                  BigDecimal reduce = contractCatalogues1.stream()
                     .map(ContractCatalogue::getContractAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  map.put(sysLocation.getName(), reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
               }

               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(l).getFieldValue())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .mapAmount(map)
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 7:
            DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
            LocalDateTime registerDate = param.getRegisterDate();
            int year = registerDate.getYear();
            List<String> yearMonthStrList = new ArrayList<>();

            for (int month = 1; month <= 12; month++) {
               LocalDateTime localDateTime = LocalDateTime.of(year, month, 1, 1, 1);
               String format = yyyyMM.format(localDateTime);
               yearMonthStrList.add(format);
            }

            for (String yearMonthStr : yearMonthStrList) {
               Map<String, BigDecimal> map = new HashMap<>();
               List<ContractCatalogue> contractCatalogues = contracts.stream()
                  .filter(
                     contractCataloguex -> ObjectUtil.isNotEmpty(contractCataloguex.getRegisterDate())
                        && yyyyMM.format(contractCataloguex.getRegisterDate()).equals(yearMonthStr)
                        && contractCataloguex.getSignStatus()
                  )
                  .collect(Collectors.toList());

               for (Long l : firstLevelDeptMap.keySet()) {
                  BigDecimal reduce = contractCatalogues.stream()
                     .filter(c -> ObjectUtil.equal(c.getFirstLevelDept(), l))
                     .map(ContractCatalogue::getContractAmount)
                     .filter(ObjectUtil::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  map.put(firstLevelDeptMap.get(l).getFieldValue(), reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
               }

               int monthValue = YearMonth.parse(yearMonthStr, yyyyMM).getMonthValue();
               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .monthStr(monthValue + "月")
                  .totalAmount(new BigDecimal("0"))
                  .mapAmount(map)
                  .build();
               contractPooledAnalysisDTOS.add(build);
            }
            break;
         case 8:
         case 9:
            TreeSet<ContractCatalogue> contractCataloguesGroup = param.getType().equals(9)
               ? new TreeSet<>(Comparator.comparing(c -> c.getSignerId() + "-" + c.getFirstLevelDept() + "-" + c.getSecondLevelDept()))
               : new TreeSet<>(Comparator.comparing(c -> c.getFirstLevelDept() + "-" + c.getSecondLevelDept()));
            contractCataloguesGroup.addAll(contracts);

            for (ContractCatalogue contractCatalogue : contractCataloguesGroup) {
               List<ContractCatalogue> contractCatalogueList = param.getType().equals(9)
                  ? contracts.stream()
                     .filter(
                        c -> ObjectUtil.equal(c.getSignerId(), contractCatalogue.getSignerId())
                           && ObjectUtil.equal(c.getFirstLevelDept(), contractCatalogue.getFirstLevelDept())
                           && ObjectUtil.equal(c.getSecondLevelDept(), contractCatalogue.getSecondLevelDept())
                     )
                     .collect(Collectors.toList())
                  : contracts.stream()
                     .filter(
                        c -> ObjectUtil.equal(c.getFirstLevelDept(), contractCatalogue.getFirstLevelDept())
                           && ObjectUtil.equal(c.getSecondLevelDept(), contractCatalogue.getSecondLevelDept())
                     )
                     .collect(Collectors.toList());
               BigDecimal totalAmount = contractCatalogueList.stream()
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal reduce = contractCatalogueList.stream()
                  .filter(ContractCatalogue::getSignStatus)
                  .map(ContractCatalogue::getContractAmount)
                  .filter(ObjectUtil::isNotEmpty)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal unSignAmount = totalAmount.subtract(reduce);
               ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
                  .firstLevelDeptValue(firstLevelDeptMap.get(contractCatalogue.getFirstLevelDept()).getFieldValue())
                  .secondLevelDeptValue(
                     ObjectUtil.isNotEmpty(contractCatalogue.getSecondLevelDept())
                        ? secondLevelDeptMap.get(contractCatalogue.getSecondLevelDept()).getFieldValue()
                        : ""
                  )
                  .signerName(contractCatalogue.getSignerName())
                  .totalAmount(totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .signAmount(reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .unSignAmount(unSignAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
                  .build();
               if (param.getType().equals(9)) {
                  BigDecimal targetAmount = null;
                  if (ObjectUtil.isNotEmpty(contractCatalogue.getSecondLevelDept())) {
                     ContractFieldConfig secondLevelDept = secondLevelDeptMap.get(contractCatalogue.getSecondLevelDept());
                     Map secondMap = ObjectUtil.isNotEmpty(secondLevelDept.getFieldJson()) ? JSON.parseObject(secondLevelDept.getFieldJson()) : new HashMap();
                     targetAmount = secondMap.get(String.valueOf(param.getRegisterDate().getYear())) != null
                        ? new BigDecimal(String.valueOf(secondMap.get(String.valueOf(param.getRegisterDate().getYear()))))
                        : null;
                  } else {
                     ContractFieldConfig firstLevelDept = firstLevelDeptMap.get(contractCatalogue.getFirstLevelDept());
                     Map firstMap = ObjectUtil.isNotEmpty(firstLevelDept.getFieldJson()) ? JSON.parseObject(firstLevelDept.getFieldJson()) : new HashMap();
                     targetAmount = firstMap.get(String.valueOf(param.getRegisterDate().getYear())) != null
                        ? new BigDecimal(String.valueOf(firstMap.get(String.valueOf(param.getRegisterDate().getYear()))))
                        : null;
                  }

                  build.setTargetAmount(targetAmount);
                  BigDecimal completeRate = totalAmount.compareTo(BigDecimal.ZERO) == 0
                     ? BigDecimal.ZERO
                     : (
                        targetAmount == null
                           ? BigDecimal.ZERO
                           : totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).divide(targetAmount, 2, RoundingMode.HALF_UP)
                     );
                  build.setCompleteRate(completeRate.multiply(ONE_HUNDRED));
               }

               contractPooledAnalysisDTOS.add(build);
            }
      }

      return contractPooledAnalysisDTOS;
   }

   @Override
   public ContractQuarterPooledAnalysisDTO departmentQuarter(ContractAnalysisQueryDTOParam param) {
      List<ContractCatalogue> contracts = this.contractCatalogueService
         .list(
            (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>()
                  .between(ContractCatalogue::getTransferDate, param.getStartTime(), param.getEndTime()))
               .eq(ContractCatalogue::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         );
      Map<Long, String> firstLevelDeptValueMap = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.FIRST_LEVEL_DEPT.getType()))
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));
      Map<Long, String> secondLevelDeptValueMap = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.SECOND_LEVEL_DEPT.getType()))
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));
      List<ContractPooledAnalysisDTO> listTwo = new ArrayList<>();
      TreeSet<ContractCatalogue> contractCataloguesGroup = new TreeSet<>(
         Comparator.comparing(c -> c.getSignerId() + "-" + c.getFirstLevelDept() + "-" + c.getSecondLevelDept())
      );
      contractCataloguesGroup.addAll(contracts);

      for (ContractCatalogue contractCatalogue : contractCataloguesGroup) {
         List<ContractCatalogue> contractCatalogueList = contracts.stream()
            .filter(
               c -> ObjectUtil.equal(c.getSignerId(), contractCatalogue.getSignerId())
                  && ObjectUtil.equal(c.getFirstLevelDept(), contractCatalogue.getFirstLevelDept())
                  && ObjectUtil.equal(c.getSecondLevelDept(), contractCatalogue.getSecondLevelDept())
            )
            .collect(Collectors.toList());
         BigDecimal coordinateAmount = contractCatalogueList.stream()
            .filter(c -> ObjectUtil.isNotEmpty(c.getBoolCoordinate()) && c.getBoolCoordinate())
            .map(ContractCatalogue::getContractAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal unCoordinateAmount = contractCatalogueList.stream()
            .filter(c -> ObjectUtil.isEmpty(c.getBoolCoordinate()) || !c.getBoolCoordinate())
            .map(ContractCatalogue::getContractAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal coordinateProjectAmount = coordinateAmount.divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
         ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
            .firstLevelDept(contractCatalogue.getFirstLevelDept())
            .firstLevelDeptValue(firstLevelDeptValueMap.get(contractCatalogue.getFirstLevelDept()))
            .secondLevelDept(contractCatalogue.getSecondLevelDept())
            .secondLevelDeptValue(secondLevelDeptValueMap.get(contractCatalogue.getSecondLevelDept()))
            .signerName(contractCatalogue.getSignerName())
            .coordinateAmount(coordinateAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
            .unCoordinateAmount(unCoordinateAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
            .coordinateProjectAmount(coordinateProjectAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
            .totalAmount(
               unCoordinateAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).add(coordinateProjectAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP))
            )
            .build();
         listTwo.add(build);
      }

      List<ContractPooledAnalysisDTO> listOne = new ArrayList<>();

      for (Long l : secondLevelDeptValueMap.keySet()) {
         BigDecimal totalAmount = listTwo.stream()
            .filter(c -> ObjectUtil.equal(c.getSecondLevelDept(), l))
            .map(ContractPooledAnalysisDTO::getTotalAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         ContractPooledAnalysisDTO build = ContractPooledAnalysisDTO.builder()
            .secondLevelDept(l)
            .secondLevelDeptValue(secondLevelDeptValueMap.get(l))
            .totalAmount(totalAmount)
            .build();
         listOne.add(build);
      }

      return ContractQuarterPooledAnalysisDTO.builder()
         .listOne(listOne.stream().sorted(Comparator.comparing(ContractPooledAnalysisDTO::getTotalAmount).reversed()).collect(Collectors.toList()))
         .listTwo(listTwo.stream().sorted(Comparator.comparing(ContractPooledAnalysisDTO::getTotalAmount).reversed()).collect(Collectors.toList()))
         .build();
   }

   @Override
   public Boolean pooledExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response) {
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(param.getRegisterDate()), "请选择登记时间");

      try {
         String downloadTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
         Workbook workbook = new XSSFWorkbook();
         param.setType(1);
         this.typeExport(param, workbook, downloadTime);
         param.setType(2);
         this.typeExport(param, workbook, downloadTime);
         param.setType(3);
         this.typeExport(param, workbook, downloadTime);
         param.setType(4);
         this.typeExport(param, workbook, downloadTime);
         param.setType(5);
         this.typeExport(param, workbook, downloadTime);
         param.setType(6);
         this.typeExport(param, workbook, downloadTime);
         param.setType(7);
         this.typeExport(param, workbook, downloadTime);
         ServletOutputStream outputStream = response.getOutputStream();
         response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
         response.setHeader(
            "Content-disposition",
            "attachment;filename=" + URLEncoder.encode(DateTimeFormatter.ofPattern("yyyy").format(param.getRegisterDate()) + "汇总分析.xls", "UTF-8")
         );
         workbook.write(outputStream);
         outputStream.flush();
         outputStream.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return true;
   }

   private void typeExport(ContractAnalysisQueryDTOParam param, Workbook workbook, String downloadTime) {
      List<ExcelExportEntity> columnList = new ArrayList<>();
      if (param.getType() == 7) {
         columnList.add(new ExcelExportEntity("月份", "index", 20));
      } else {
         columnList.add(new ExcelExportEntity("序号", "index", 20));
         columnList.add(new ExcelExportEntity("所属一级部门名称", "firstLevelDept", 20));
         columnList.add(new ExcelExportEntity("总合同额", "amount", 20));
      }

      switch (param.getType()) {
         case 1:
            columnList.add(new ExcelExportEntity("其中：已签订", "signAmount", 20));
            columnList.add(new ExcelExportEntity("其中：中标未签", "unSignAmount", 20));
            columnList.add(new ExcelExportEntity("上年度遗留（独立数据）", "lastYearAmount", 20));
            break;
         case 2:
            columnList.add(new ExcelExportEntity("其中：配合项目部的合同额", "coordinateAmount", 20));
            columnList.add(new ExcelExportEntity("其中：自主承接的合同额", "unCoordinateAmount", 20));
            break;
         case 3:
         case 4:
         case 5:
         case 7:
            ContractFieldEnum contractFieldEnum = null;
            if (param.getType() == 3) {
               contractFieldEnum = ContractFieldEnum.STRUCTURE_TYPE;
            } else if (param.getType() == 4) {
               contractFieldEnum = ContractFieldEnum.BIDDING_METHOD;
            } else if (param.getType() == 5) {
               contractFieldEnum = ContractFieldEnum.PARTY_TYPE;
            } else if (param.getType() == 7) {
               contractFieldEnum = ContractFieldEnum.FIRST_LEVEL_DEPT;
            }

            for (ContractFieldConfig contractFieldConfig : this.contractConfigService
               .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, contractFieldEnum.getType()))) {
               columnList.add(new ExcelExportEntity(contractFieldConfig.getFieldValue(), contractFieldConfig.getFieldValue(), 20));
            }
            break;
         case 6:
            for (SysLocation sysLocation : this.locationService.list(null)) {
               columnList.add(new ExcelExportEntity(sysLocation.getName(), sysLocation.getName(), 20));
            }
      }

      List<Map<String, Object>> dataList = new ArrayList<>();
      List<ContractPooledAnalysisDTO> analyse = this.analyse(param);
      BigDecimal sumAmount = new BigDecimal("0");
      BigDecimal sumSignAmount = new BigDecimal("0");
      BigDecimal sumUnSignAmount = new BigDecimal("0");
      BigDecimal sumLastYearAmount = new BigDecimal("0");
      BigDecimal sumCoordinateAmount = new BigDecimal("0");
      BigDecimal sumUnCoordinateAmount = new BigDecimal("0");
      Map<String, BigDecimal> sumMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(analyse)) {
         for (int i = 0; i < analyse.size(); i++) {
            ContractPooledAnalysisDTO contractPooledAnalysisDTO = analyse.get(i);
            Map<String, Object> row = new HashMap<>();
            row.put("index", i + 1 + (param.getType() == 7 ? "月" : ""));
            row.put("firstLevelDept", contractPooledAnalysisDTO.getFirstLevelDeptValue());
            row.put("amount", contractPooledAnalysisDTO.getTotalAmount().stripTrailingZeros().toPlainString());
            sumAmount = sumAmount.add(contractPooledAnalysisDTO.getTotalAmount());
            switch (param.getType()) {
               case 1:
                  row.put("signAmount", contractPooledAnalysisDTO.getSignAmount().stripTrailingZeros().toPlainString());
                  sumSignAmount = sumSignAmount.add(contractPooledAnalysisDTO.getSignAmount());
                  row.put("unSignAmount", contractPooledAnalysisDTO.getUnSignAmount().stripTrailingZeros().toPlainString());
                  sumUnSignAmount = sumUnSignAmount.add(contractPooledAnalysisDTO.getUnSignAmount());
                  row.put("lastYearAmount", contractPooledAnalysisDTO.getLastYearAmount().stripTrailingZeros().toPlainString());
                  sumLastYearAmount = sumLastYearAmount.add(contractPooledAnalysisDTO.getLastYearAmount());
                  break;
               case 2:
                  row.put("coordinateAmount", contractPooledAnalysisDTO.getCoordinateAmount().stripTrailingZeros().toPlainString());
                  sumCoordinateAmount = sumCoordinateAmount.add(contractPooledAnalysisDTO.getCoordinateAmount());
                  row.put("unCoordinateAmount", contractPooledAnalysisDTO.getUnCoordinateAmount().stripTrailingZeros().toPlainString());
                  sumUnCoordinateAmount = sumUnCoordinateAmount.add(contractPooledAnalysisDTO.getUnCoordinateAmount());
                  break;
               case 3:
               case 4:
               case 5:
               case 7:
                  ContractFieldEnum contractFieldEnum = null;
                  if (param.getType() == 3) {
                     contractFieldEnum = ContractFieldEnum.STRUCTURE_TYPE;
                  } else if (param.getType() == 4) {
                     contractFieldEnum = ContractFieldEnum.BIDDING_METHOD;
                  } else if (param.getType() == 5) {
                     contractFieldEnum = ContractFieldEnum.PARTY_TYPE;
                  } else if (param.getType() == 7) {
                     contractFieldEnum = ContractFieldEnum.FIRST_LEVEL_DEPT;
                  }

                  for (ContractFieldConfig contractFieldConfig : this.contractConfigService
                     .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, contractFieldEnum.getType()))) {
                     Map<String, BigDecimal> mapAmount = contractPooledAnalysisDTO.getMapAmount();
                     BigDecimal amount = mapAmount.get(contractFieldConfig.getFieldValue());
                     row.put(contractFieldConfig.getFieldValue(), amount.stripTrailingZeros().toPlainString());
                     BigDecimal bigDecimal = sumMap.get(contractFieldConfig.getFieldValue());
                     sumMap.put(contractFieldConfig.getFieldValue(), bigDecimal == null ? amount : bigDecimal.add(amount));
                  }
                  break;
               case 6:
                  for (SysLocation sysLocation : this.locationService.list(null)) {
                     Map<String, BigDecimal> mapAmount = contractPooledAnalysisDTO.getMapAmount();
                     BigDecimal amount = mapAmount.get(sysLocation.getName());
                     row.put(sysLocation.getName(), amount.stripTrailingZeros().toPlainString());
                     BigDecimal bigDecimal = sumMap.get(sysLocation.getName());
                     sumMap.put(sysLocation.getName(), bigDecimal == null ? amount : bigDecimal.add(amount));
                  }
            }

            dataList.add(row);
         }

         Map<String, Object> row = new HashMap<>();
         row.put("index", "合计");
         row.put("amount", sumAmount.stripTrailingZeros().toPlainString());
         switch (param.getType()) {
            case 1:
               row.put("signAmount", sumSignAmount.stripTrailingZeros().toPlainString());
               row.put("unSignAmount", sumUnSignAmount.stripTrailingZeros().toPlainString());
               row.put("lastYearAmount", sumLastYearAmount.stripTrailingZeros().toPlainString());
               break;
            case 2:
               row.put("coordinateAmount", sumCoordinateAmount.stripTrailingZeros().toPlainString());
               row.put("unCoordinateAmount", sumUnCoordinateAmount.stripTrailingZeros().toPlainString());
               break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
               for (String s : sumMap.keySet()) {
                  row.put(s, sumMap.get(s).stripTrailingZeros().toPlainString());
               }
         }

         dataList.add(row);
      } else {
         Map<String, Object> row = new HashMap<>();
         row.put("index", "");
         row.put("firstLevelDept", "");
         row.put("amount", "");
         switch (param.getType()) {
            case 1:
               row.put("signAmount", "");
               row.put("unSignAmount", "");
               row.put("lastYearAmount", "");
               break;
            case 2:
               row.put("coordinateAmount", "");
               row.put("unCoordinateAmount", "");
               break;
            case 3:
            case 4:
            case 5:
            case 7:
               ContractFieldEnum contractFieldEnum = null;
               if (param.getType() == 3) {
                  contractFieldEnum = ContractFieldEnum.STRUCTURE_TYPE;
               } else if (param.getType() == 4) {
                  contractFieldEnum = ContractFieldEnum.BIDDING_METHOD;
               } else if (param.getType() == 5) {
                  contractFieldEnum = ContractFieldEnum.PARTY_TYPE;
               } else if (param.getType() == 7) {
                  contractFieldEnum = ContractFieldEnum.FIRST_LEVEL_DEPT;
               }

               for (ContractFieldConfig contractFieldConfig : this.contractConfigService
                  .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, contractFieldEnum.getType()))) {
                  row.put(contractFieldConfig.getFieldValue(), "");
               }
               break;
            case 6:
               for (SysLocation sysLocation : this.locationService.list(null)) {
                  row.put(sysLocation.getName(), "");
               }
         }

         dataList.add(row);
      }

      String sheetName = param.getType() == 1
         ? "按签订情况"
         : (
            param.getType() == 2
               ? "按承接方式"
               : (
                  param.getType() == 3
                     ? "按结构类型"
                     : (
                        param.getType() == 4
                           ? "按招标方式"
                           : (param.getType() == 5 ? "按甲方类别" : (param.getType() == 6 ? "按业务区域" : (param.getType() == 7 ? "按月统计(已签订合同额)" : "")))
                     )
               )
         );
      ExportParams exportParams = new ExportParams(DateTimeFormatter.ofPattern("yyyy").format(param.getRegisterDate()) + "汇总分析表", sheetName, ExcelType.XSSF);
      exportParams.setSecondTitle("下载时间：" + downloadTime + "  单位：万元");
      exportParams.setStyle(ExcelExportStyler.class);
      ExcelExportService service = new ExcelExportService();
      service.createSheetForMap(workbook, exportParams, columnList, dataList);
   }

   @Override
   public Boolean departmentExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response) {
      HashMap<String, Object> map = new HashMap<>();
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(param.getRegisterDate()), "请选择登记时间");
      DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy");
      map.put("year", yyyy.format(param.getRegisterDate()));
      map.put("downloadTime", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(param.getRegisterDate()));
      List<ContractCatalogue> contracts = this.contractCatalogueService
         .list(
            (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>().last("AND YEAR(register_date) = " + yyyy.format(param.getRegisterDate())))
               .eq(ContractCatalogue::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         );
      BigDecimal alltotalAmount = contracts.stream()
         .map(ContractCatalogue::getContractAmount)
         .filter(ObjectUtil::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      map.put("allTotalAmount", alltotalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
      BigDecimal allSignAmount = contracts.stream()
         .filter(ContractCatalogue::getSignStatus)
         .map(ContractCatalogue::getContractAmount)
         .filter(ObjectUtil::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      map.put("allSignAmount", allSignAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
      BigDecimal allUnSignAmount = alltotalAmount.subtract(allSignAmount);
      map.put("allUnSignAmount", allUnSignAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
      Map<Long, ContractFieldConfig> firstLevelDeptMap = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.FIRST_LEVEL_DEPT.getType()))
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, Function.identity()));
      Map<Long, ContractFieldConfig> secondLevelDeptMap = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.SECOND_LEVEL_DEPT.getType()))
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, Function.identity()));
      List<Map<String, Object>> mapList = new ArrayList<>();
      TreeSet<ContractCatalogue> contractCataloguesGroup = new TreeSet<>(
         Comparator.comparing(c -> c.getSignerId() + "-" + c.getFirstLevelDept() + "-" + c.getSecondLevelDept())
      );
      contractCataloguesGroup.addAll(contracts);
      Integer num = 0;

      for (ContractCatalogue contractCatalogue : contractCataloguesGroup) {
         List<ContractCatalogue> contractCatalogueList = contracts.stream()
            .filter(
               c -> ObjectUtil.equal(c.getSignerId(), contractCatalogue.getSignerId())
                  && ObjectUtil.equal(c.getFirstLevelDept(), contractCatalogue.getFirstLevelDept())
                  && ObjectUtil.equal(c.getSecondLevelDept(), contractCatalogue.getSecondLevelDept())
            )
            .collect(Collectors.toList());
         BigDecimal totalAmount = contractCatalogueList.stream()
            .map(ContractCatalogue::getContractAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal reduce = contractCatalogueList.stream()
            .filter(ContractCatalogue::getSignStatus)
            .map(ContractCatalogue::getContractAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal unSignAmount = totalAmount.subtract(reduce);
         Map<String, Object> mapNew = new HashMap<>();
         mapNew.put("id", num = num + 1);
         mapNew.put("userName", contractCatalogue.getSignerName());
         mapNew.put(
            "firstLevelDept",
            ObjectUtil.isNotEmpty(contractCatalogue.getFirstLevelDept()) ? firstLevelDeptMap.get(contractCatalogue.getFirstLevelDept()).getFieldValue() : "-"
         );
         mapNew.put(
            "secondLevelDept",
            ObjectUtil.isNotEmpty(contractCatalogue.getSecondLevelDept())
               ? secondLevelDeptMap.get(contractCatalogue.getSecondLevelDept()).getFieldValue()
               : "-"
         );
         mapNew.put("totalAmount", totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
         mapNew.put("signAmount", reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
         mapNew.put("unSignAmount", unSignAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
         mapList.add(mapNew);
      }

      map.put("mapList", mapList);
      TreeSet<ContractCatalogue> contractCataloguesGroupNew = new TreeSet<>(Comparator.comparing(c -> c.getFirstLevelDept() + "-" + c.getSecondLevelDept()));
      contractCataloguesGroupNew.addAll(contracts);
      List<Map<String, Object>> mapListOne = new ArrayList<>();
      num = 0;

      for (ContractCatalogue contractCatalogue : contractCataloguesGroupNew) {
         List<ContractCatalogue> contractCatalogueList = contracts.stream()
            .filter(
               c -> ObjectUtil.equal(c.getFirstLevelDept(), contractCatalogue.getFirstLevelDept())
                  && ObjectUtil.equal(c.getSecondLevelDept(), contractCatalogue.getSecondLevelDept())
            )
            .collect(Collectors.toList());
         BigDecimal totalAmount = contractCatalogueList.stream()
            .map(ContractCatalogue::getContractAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal reduce = contractCatalogueList.stream()
            .filter(ContractCatalogue::getSignStatus)
            .map(ContractCatalogue::getContractAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal unSignAmount = totalAmount.subtract(reduce);
         Map<String, Object> mapNew = new HashMap<>();
         mapNew.put("id", num = num + 1);
         mapNew.put(
            "firstLevelDept",
            ObjectUtil.isNotEmpty(contractCatalogue.getFirstLevelDept()) ? firstLevelDeptMap.get(contractCatalogue.getFirstLevelDept()).getFieldValue() : "-"
         );
         mapNew.put(
            "secondLevelDept",
            ObjectUtil.isNotEmpty(contractCatalogue.getSecondLevelDept())
               ? secondLevelDeptMap.get(contractCatalogue.getSecondLevelDept()).getFieldValue()
               : "-"
         );
         mapNew.put("totalAmount", totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
         mapNew.put("signAmount", reduce.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
         mapNew.put("unSignAmount", unSignAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
         BigDecimal targetAmount = null;
         if (ObjectUtil.isNotEmpty(contractCatalogue.getSecondLevelDept())) {
            ContractFieldConfig secondLevelDept = secondLevelDeptMap.get(contractCatalogue.getSecondLevelDept());
            Map secondMap = ObjectUtil.isNotEmpty(secondLevelDept.getFieldJson()) ? JSON.parseObject(secondLevelDept.getFieldJson()) : new HashMap();
            targetAmount = secondMap.get(String.valueOf(param.getRegisterDate().getYear())) != null
               ? new BigDecimal(String.valueOf(secondMap.get(String.valueOf(param.getRegisterDate().getYear()))))
               : null;
         } else {
            ContractFieldConfig firstLevelDept = firstLevelDeptMap.get(contractCatalogue.getFirstLevelDept());
            Map firstMap = ObjectUtil.isNotEmpty(firstLevelDept.getFieldJson()) ? JSON.parseObject(firstLevelDept.getFieldJson()) : new HashMap();
            targetAmount = firstMap.get(String.valueOf(param.getRegisterDate().getYear())) != null
               ? new BigDecimal(String.valueOf(firstMap.get(String.valueOf(param.getRegisterDate().getYear()))))
               : null;
         }

         mapNew.put("targetAmount", targetAmount);
         BigDecimal completeRate = totalAmount.compareTo(BigDecimal.ZERO) == 0
            ? BigDecimal.ZERO
            : (targetAmount == null ? BigDecimal.ZERO : totalAmount.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP).divide(targetAmount, 2, RoundingMode.HALF_UP));
         mapNew.put("completeRate", completeRate.multiply(ONE_HUNDRED).stripTrailingZeros().toPlainString() + "%");
         mapListOne.add(mapNew);
      }

      map.put("mapListOne", mapListOne);
      String resourcePath = "files/departmentUndertakingAnalysis.xlsx";
      String tempFileName = "departmentUndertakingAnalysis";
      String exportFileName = "部门承接分析.xlsx";
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, null);
      return true;
   }

   @Override
   public Boolean departmentQuarterExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response) {
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(param.getRegisterDate()), "请选择登记时间");

      try {
         int year = param.getRegisterDate().getYear();
         Workbook workbook = new XSSFWorkbook();
         String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
         param.setStartTime(LocalDate.of(year, 1, 1).atTime(0, 0, 0));
         param.setEndTime(LocalDate.of(year, 3, 31).atTime(23, 59, 59));
         this.departmentQuarterExportWorkbook(param, workbook, 0, "第一季度", year, format);
         param.setStartTime(LocalDate.of(year, 4, 1).atTime(0, 0, 0));
         param.setEndTime(LocalDate.of(year, 6, 30).atTime(23, 59, 59));
         this.departmentQuarterExportWorkbook(param, workbook, 1, "第二季度", year, format);
         param.setStartTime(LocalDate.of(year, 7, 1).atTime(0, 0, 0));
         param.setEndTime(LocalDate.of(year, 9, 30).atTime(23, 59, 59));
         this.departmentQuarterExportWorkbook(param, workbook, 2, "第三季度", year, format);
         param.setStartTime(LocalDate.of(year, 10, 1).atTime(0, 0, 0));
         param.setEndTime(LocalDate.of(year, 12, 31).atTime(23, 59, 59));
         this.departmentQuarterExportWorkbook(param, workbook, 3, "第四季度", year, format);
         ServletOutputStream outputStream = response.getOutputStream();
         response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
         response.setHeader(
            "Content-disposition",
            "attachment;filename=" + URLEncoder.encode(DateTimeFormatter.ofPattern("yyyy").format(param.getRegisterDate()) + "季度排名表 .xls", "UTF-8")
         );
         workbook.write(outputStream);
         outputStream.flush();
         outputStream.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return true;
   }

   private void departmentQuarterExportWorkbook(ContractAnalysisQueryDTOParam param, Workbook workbook, int index, String sheetName, int year, String format) {
      workbook.createSheet(sheetName);
      Sheet sheet = workbook.getSheetAt(index);
      int rowIndex = 0;
      Row titleRow = sheet.createRow(rowIndex++);
      Cell titleCell = titleRow.createCell(0);
      titleCell.setCellValue(year + "销售部" + sheetName + "排名表");
      List<ContractFieldConfig> secondLevelDeptList = this.contractConfigService
         .list((Wrapper<ContractFieldConfig>)new LambdaQueryWrapper<ContractFieldConfig>().eq(ContractFieldConfig::getFieldEnumType, ContractFieldEnum.SECOND_LEVEL_DEPT.getType()));
      int totalCols = Math.max(secondLevelDeptList.size(), 8);
      sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, totalCols));
      CellStyle titleStyle = sheet.getWorkbook().createCellStyle();
      Font titleFont = sheet.getWorkbook().createFont();
      titleFont.setBold(true);
      titleFont.setFontHeightInPoints((short)16);
      titleStyle.setFont(titleFont);
      titleStyle.setAlignment(HorizontalAlignment.CENTER);
      titleCell.setCellStyle(titleStyle);
      Row row1 = sheet.createRow(rowIndex++);
      Cell twoCell = row1.createCell(0);
      twoCell.setCellValue("下载时间：" + format + "  单位：万元");
      sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, secondLevelDeptList.size() + 1));
      Row deptTitleRow = sheet.createRow(rowIndex++);
      Cell deptTitleCell = deptTitleRow.createCell(0);
      deptTitleCell.setCellValue("部门业绩排名");
      sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, secondLevelDeptList.size() + 1));
      CellStyle deptTitleStyle = sheet.getWorkbook().createCellStyle();
      Font deptTitleFont = sheet.getWorkbook().createFont();
      deptTitleFont.setBold(true);
      deptTitleFont.setFontHeightInPoints((short)12);
      deptTitleStyle.setFont(deptTitleFont);
      deptTitleStyle.setAlignment(HorizontalAlignment.CENTER);
      deptTitleCell.setCellStyle(deptTitleStyle);
      ContractQuarterPooledAnalysisDTO contractQuarterPooledAnalysisDTO = this.departmentQuarter(param);
      List<ContractPooledAnalysisDTO> listOne = contractQuarterPooledAnalysisDTO.getListOne();
      BigDecimal totalAmount = new BigDecimal("0");

      for (int i = 0; i < 3; i++) {
         int num = 0;
         Row deptRow = sheet.createRow(rowIndex++);
         Cell cellDept = deptRow.createCell(num);
         if (i == 0) {
            cellDept.setCellValue("");
         } else if (i == 1) {
            cellDept.setCellValue("合同额");
         } else {
            cellDept.setCellValue("排名");
         }

         for (int i1 = 0; i1 <= listOne.size(); i1++) {
            Cell cellDeptValue = deptRow.createCell(++num);
            if (i1 != listOne.size()) {
               ContractPooledAnalysisDTO contractPooledAnalysisDTO = listOne.get(i1);
               if (i == 0) {
                  cellDeptValue.setCellValue(contractPooledAnalysisDTO.getSecondLevelDeptValue());
               } else if (i == 1) {
                  totalAmount = totalAmount.add(contractPooledAnalysisDTO.getTotalAmount());
                  cellDeptValue.setCellValue(contractPooledAnalysisDTO.getTotalAmount().stripTrailingZeros().toPlainString());
               } else if (i == 2) {
                  cellDeptValue.setCellValue(i1 + 1);
               }
            } else if (i == 0) {
               cellDeptValue.setCellValue("合计");
            } else if (i == 1) {
               cellDeptValue.setCellValue(totalAmount.stripTrailingZeros().toPlainString());
            } else if (i == 2) {
               cellDeptValue.setCellValue("");
            }
         }
      }

      int var58 = ++rowIndex;
      rowIndex++;
      Row salesTitleRow = sheet.createRow(var58);
      Cell salesTitleCell = salesTitleRow.createCell(0);
      salesTitleCell.setCellValue("销售员业绩明细");
      sheet.addMergedRegion(new CellRangeAddress(rowIndex - 1, rowIndex - 1, 0, 8));
      CellStyle salesTitleStyle = sheet.getWorkbook().createCellStyle();
      Font salesTitleFont = sheet.getWorkbook().createFont();
      salesTitleFont.setBold(true);
      salesTitleFont.setFontHeightInPoints((short)12);
      salesTitleStyle.setFont(salesTitleFont);
      salesTitleStyle.setAlignment(HorizontalAlignment.CENTER);
      salesTitleCell.setCellStyle(salesTitleStyle);
      Row salesHeaderRow = sheet.createRow(rowIndex++);
      String[] salesHeaders = new String[]{"序号", "姓名", "所属一级部门", "所属二级部门", "自主承接", "配合项目", "配合项目合同额", "累计合同额", "排名"};

      for (int col = 0; col < salesHeaders.length; col++) {
         Cell cell = salesHeaderRow.createCell(col);
         cell.setCellValue(salesHeaders[col]);
         CellStyle headerStyle = sheet.getWorkbook().createCellStyle();
         headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
         headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
         headerStyle.setBorderBottom(BorderStyle.THIN);
         headerStyle.setBorderTop(BorderStyle.THIN);
         headerStyle.setBorderLeft(BorderStyle.THIN);
         headerStyle.setBorderRight(BorderStyle.THIN);
         cell.setCellStyle(headerStyle);
      }

      List<ContractPooledAnalysisDTO> listTwo = contractQuarterPooledAnalysisDTO.getListTwo();
      if (listTwo != null && !listTwo.isEmpty()) {
         int serialNumber = 1;

         for (ContractPooledAnalysisDTO contractPooledAnalysisDTO : listTwo) {
            int num = serialNumber++;
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(num);
            dataRow.createCell(1).setCellValue(contractPooledAnalysisDTO.getSignerName());
            dataRow.createCell(2).setCellValue(contractPooledAnalysisDTO.getFirstLevelDeptValue());
            dataRow.createCell(3).setCellValue(contractPooledAnalysisDTO.getSecondLevelDeptValue());
            dataRow.createCell(4).setCellValue(contractPooledAnalysisDTO.getUnCoordinateAmount().stripTrailingZeros().toPlainString());
            dataRow.createCell(5).setCellValue(contractPooledAnalysisDTO.getCoordinateAmount().stripTrailingZeros().toPlainString());
            dataRow.createCell(6).setCellValue(contractPooledAnalysisDTO.getCoordinateProjectAmount().stripTrailingZeros().toPlainString());
            dataRow.createCell(7).setCellValue(contractPooledAnalysisDTO.getTotalAmount().stripTrailingZeros().toPlainString());
            dataRow.createCell(8).setCellValue(num);

            for (int col = 0; col < salesHeaders.length; col++) {
               CellStyle dataStyle = sheet.getWorkbook().createCellStyle();
               dataStyle.setBorderBottom(BorderStyle.THIN);
               dataStyle.setBorderTop(BorderStyle.THIN);
               dataStyle.setBorderLeft(BorderStyle.THIN);
               dataStyle.setBorderRight(BorderStyle.THIN);
               if (col >= 4 && col <= 7) {
                  dataStyle.setAlignment(HorizontalAlignment.RIGHT);
               }

               dataRow.getCell(col).setCellStyle(dataStyle);
            }
         }
      }

      for (int col = 0; col < totalCols; col++) {
         sheet.autoSizeColumn(col);
      }
   }
}
