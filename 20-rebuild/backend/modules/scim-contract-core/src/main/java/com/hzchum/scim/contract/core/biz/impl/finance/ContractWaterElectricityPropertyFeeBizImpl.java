package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWaterElectricityPropertyFeeBiz;
import com.hzchum.scim.contract.core.api.biz.finance.FinanceFillFeeUtils;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountExportDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityPropertyFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWaterElectricityPropertyFeeSaveParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWaterElectricityPropertyFeeMapper;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWaterElectricityPropertyFeeBizImpl
   extends IBizImpl<ContractWaterElectricityPropertyFeeService, ContractWaterElectricityPropertyFeeMapper, ContractWaterElectricityPropertyFee>
   implements ContractWaterElectricityPropertyFeeBiz {
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Resource
   private FinanceFillFeeUtils financeFillFeeUtils;

   @Override
   public PageVO<ContractWaterElectricityPropertyFeeDTO> pageInfo(
      Integer year, Integer type, Long branchCompanyId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ContractWaterElectricityPropertyFeeDTO> dtoList = this.baseMapper.listInfo(year, type, branchCompanyId);
      return new PageVO<>(page, dtoList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInfo(ContractWaterElectricityPropertyFeeSaveParam param) {
      this.verifyParameters(param);
      ContractWaterElectricityPropertyFee waterElectricityPropertyFee = BeanUtil.toBean(param, ContractWaterElectricityPropertyFee.class);
      this.populateData(waterElectricityPropertyFee);
      this.baseMapper.insert(waterElectricityPropertyFee);
      Integer reviewStatus = this.financeFillFeeUtils
         .addApproveData(
            waterElectricityPropertyFee.getId(),
            AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType(),
            ApproveProcessTypeEnumV2.CONTRACT_WATER_ELECTRICITY_AUDIT.getType(),
            param.getBranchCompanyId(),
            param.getTotalFee(),
            null
         );
      if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
         waterElectricityPropertyFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         waterElectricityPropertyFee.setAuditTime(LocalDateTime.now());
         waterElectricityPropertyFee.setAuditorId(waterElectricityPropertyFee.getUserId());
         waterElectricityPropertyFee.setAuditorName(UserUtil.getCurrentName());
         this.baseService.updateById(waterElectricityPropertyFee);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInfo(ContractWaterElectricityPropertyFeeSaveParam param) {
      ContractWaterElectricityPropertyFee oldWaterElectricityPropertyFee = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldWaterElectricityPropertyFee != null, "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldWaterElectricityPropertyFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "费用填报已审批!!修改失败!!");
      this.verifyParameters(param);
      ContractWaterElectricityPropertyFee waterElectricityPropertyFee = BeanUtil.toBean(param, ContractWaterElectricityPropertyFee.class);
      this.populateData(waterElectricityPropertyFee);
      this.baseMapper.updateById(waterElectricityPropertyFee);
      this.financeFillFeeUtils
         .removeApproveData(
            param.getId(), AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType(), ApproveProcessTypeEnumV2.CONTRACT_WATER_ELECTRICITY_AUDIT.getType()
         );
      Integer reviewStatus = this.financeFillFeeUtils
         .addApproveData(
            param.getId(),
            AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType(),
            ApproveProcessTypeEnumV2.CONTRACT_WATER_ELECTRICITY_AUDIT.getType(),
            waterElectricityPropertyFee.getBranchCompanyId(),
            waterElectricityPropertyFee.getTotalFee(),
            null
         );
      if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
         waterElectricityPropertyFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         waterElectricityPropertyFee.setAuditTime(LocalDateTime.now());
         waterElectricityPropertyFee.setAuditorId(waterElectricityPropertyFee.getUserId());
         waterElectricityPropertyFee.setAuditorName(UserUtil.getCurrentName());
         this.baseService.updateById(waterElectricityPropertyFee);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean boolStatus) {
      ContractWaterElectricityPropertyFee oldWaterElectricityPropertyFee = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldWaterElectricityPropertyFee != null, "当前数据不存在, 请刷新后重试");
      this.baseMapper.updateById(ContractWaterElectricityPropertyFee.builder().id(id).boolStatus(boolStatus).build());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      ContractWaterElectricityPropertyFee oldWaterElectricityPropertyFee = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldWaterElectricityPropertyFee != null, "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldWaterElectricityPropertyFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "费用填报已审批!!删除失败!!");
      this.baseMapper.deleteById(id);
      this.financeFillFeeUtils
         .removeApproveData(id, AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType(), ApproveProcessTypeEnumV2.CONTRACT_WATER_ELECTRICITY_AUDIT.getType());
      return Boolean.TRUE;
   }

   private void verifyParameters(ContractWaterElectricityPropertyFeeSaveParam param) {
      BranchCompany branchCompany = this.branchCompanyService
         .getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getId, param.getBranchCompanyId()).eq(BranchCompany::getEnabled, true));
      Preconditions.checkArgument(branchCompany != null, "费用归属已禁用或不存在");
      List<Integer> waterElectric = Arrays.asList(
         WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType(), WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType()
      );
      if (waterElectric.contains(param.getType())) {
         Preconditions.checkArgument(param.getConsumption() != null, "消耗量不能不能为空");
      }
   }

   private void populateData(ContractWaterElectricityPropertyFee waterElectricityPropertyFee) {
      waterElectricityPropertyFee.setYear(waterElectricityPropertyFee.getYearMonthDate().getYear());
      waterElectricityPropertyFee.setMonth(waterElectricityPropertyFee.getYearMonthDate().getMonthValue());
      List<Integer> waterElectric = Arrays.asList(
         WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType(), WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType()
      );
      if (waterElectric.contains(waterElectricityPropertyFee.getType())) {
         waterElectricityPropertyFee.setAverageUnitPrice(
            waterElectricityPropertyFee.getTotalFee().divide(waterElectricityPropertyFee.getConsumption(), 8, RoundingMode.HALF_UP)
         );
      }

      waterElectricityPropertyFee.setUserId(UserUtil.getCurrentUserId());
      waterElectricityPropertyFee.setBoolStatus(true);
   }

   @Override
   public List<ContractWaterElectricityCountDto> waterElectricityFeeStatistics(Integer year) {
      Map<String, BigDecimal> meteOutPutByYear = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(year, 1, 1, 1, 1), null);
      Map<Integer, Map<Integer, List<ContractWaterElectricityPropertyFeeDTO>>> waterElectricityFeeGroup = this.baseMapper
         .listInfo(year, null, null)
         .stream()
         .collect(Collectors.groupingBy(ContractWaterElectricityPropertyFee::getMonth, Collectors.groupingBy(ContractWaterElectricityPropertyFee::getType)));
      List<ContractWaterElectricityCountDto> resultList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         ContractWaterElectricityCountDto result = new ContractWaterElectricityCountDto();
         result.setMonth(i);
         result.setMonthOutput(meteOutPutByYear.getOrDefault(year + "-" + String.format("%02d", i), BigDecimal.ZERO));
         result.setUsedWaterMete(BigDecimal.ZERO);
         result.setWaterPrice(BigDecimal.ZERO);
         result.setUsedElectricityMete(BigDecimal.ZERO);
         result.setElectricityPrice(BigDecimal.ZERO);
         if (waterElectricityFeeGroup.containsKey(i)) {
            Map<Integer, List<ContractWaterElectricityPropertyFeeDTO>> wefMap = waterElectricityFeeGroup.get(i);
            List<ContractWaterElectricityPropertyFeeDTO> wfs = wefMap.get(WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType());
            if (CollUtil.isNotEmpty(wfs)) {
               BigDecimal usedWaterMete = wfs.stream().map(ContractWaterElectricityPropertyFee::getConsumption).reduce(BigDecimal.ZERO, BigDecimal::add);
               result.setUsedWaterMete(usedWaterMete);
               BigDecimal waterPrice = wfs.stream().map(ContractWaterElectricityPropertyFee::getTotalFee).reduce(BigDecimal.ZERO, BigDecimal::add);
               result.setWaterPrice(waterPrice);
            }

            List<ContractWaterElectricityPropertyFeeDTO> efMap = wefMap.get(WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType());
            if (CollUtil.isNotEmpty(efMap)) {
               BigDecimal usedElectricityMete = efMap.stream()
                  .map(ContractWaterElectricityPropertyFee::getConsumption)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               result.setUsedElectricityMete(usedElectricityMete);
               BigDecimal electricityPrice = efMap.stream().map(ContractWaterElectricityPropertyFee::getTotalFee).reduce(BigDecimal.ZERO, BigDecimal::add);
               result.setElectricityPrice(electricityPrice);
            }
         }

         resultList.add(result);
      }

      return resultList;
   }

   @Override
   public void waterElectricityFeeStatisticsExport(Integer year, HttpServletResponse response) {
      int currentYear = LocalDate.now().getYear();
      Preconditions.checkArgument(year <= currentYear, "统计年份暂未开始！");
      Map<String, BigDecimal> meteOutPutByYear = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(year, 1, 1, 1, 1), null);
      Map<Integer, Map<Integer, List<ContractWaterElectricityPropertyFeeDTO>>> waterElectricityFeeGroup = this.baseMapper
         .listInfo(year, null, null)
         .stream()
         .collect(Collectors.groupingBy(ContractWaterElectricityPropertyFee::getMonth, Collectors.groupingBy(ContractWaterElectricityPropertyFee::getType)));
      List<ContractWaterElectricityCountExportDto> exportList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         ContractWaterElectricityCountExportDto export = new ContractWaterElectricityCountExportDto();
         export.setMonth(String.valueOf(i));
         export.setMonthOutput(meteOutPutByYear.getOrDefault(year + String.format("%02d", i), BigDecimal.ZERO));
         export.setUsedWaterMete(BigDecimal.ZERO);
         export.setWaterPrice(BigDecimal.ZERO);
         export.setUsedElectricityMete(BigDecimal.ZERO);
         export.setElectricityPrice(BigDecimal.ZERO);
         export.setWaterAvgPrice(BigDecimal.ZERO);
         export.setElectricityAvgPrice(BigDecimal.ZERO);
         export.setConvertElectricityPrice(BigDecimal.ZERO);
         export.setConvertWaterPrice(BigDecimal.ZERO);
         if (waterElectricityFeeGroup.containsKey(i)) {
            Map<Integer, List<ContractWaterElectricityPropertyFeeDTO>> wefMap = waterElectricityFeeGroup.get(i);
            List<ContractWaterElectricityPropertyFeeDTO> wfs = wefMap.get(WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType());
            if (CollUtil.isNotEmpty(wfs)) {
               BigDecimal usedWaterMete = wfs.stream().map(ContractWaterElectricityPropertyFee::getConsumption).reduce(BigDecimal.ZERO, BigDecimal::add);
               export.setUsedWaterMete(usedWaterMete);
               BigDecimal waterPrice = wfs.stream().map(ContractWaterElectricityPropertyFee::getTotalFee).reduce(BigDecimal.ZERO, BigDecimal::add);
               export.setWaterPrice(waterPrice);
               if (BigDecimal.ZERO.compareTo(usedWaterMete) == 0) {
                  export.setWaterAvgPrice(waterPrice);
               } else {
                  export.setWaterAvgPrice(waterPrice.divide(export.getMonthOutput(), 2, RoundingMode.HALF_UP));
               }
            } else {
               export.setUsedWaterMete(BigDecimal.ZERO);
               export.setWaterPrice(BigDecimal.ZERO);
               export.setWaterAvgPrice(BigDecimal.ZERO);
            }

            List<ContractWaterElectricityPropertyFeeDTO> efMap = wefMap.get(WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType());
            if (CollUtil.isNotEmpty(efMap)) {
               BigDecimal usedElectricityMete = efMap.stream()
                  .map(ContractWaterElectricityPropertyFee::getConsumption)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               export.setUsedElectricityMete(usedElectricityMete);
               BigDecimal electricityPrice = efMap.stream().map(ContractWaterElectricityPropertyFee::getTotalFee).reduce(BigDecimal.ZERO, BigDecimal::add);
               export.setElectricityPrice(electricityPrice);
               if (BigDecimal.ZERO.compareTo(usedElectricityMete) == 0) {
                  export.setElectricityAvgPrice(electricityPrice);
               } else {
                  export.setElectricityAvgPrice(electricityPrice.divide(export.getMonthOutput(), 2, RoundingMode.HALF_UP));
               }
            } else {
               export.setUsedElectricityMete(BigDecimal.ZERO);
               export.setElectricityPrice(BigDecimal.ZERO);
               export.setElectricityAvgPrice(BigDecimal.ZERO);
            }
         }

         if (BigDecimal.ZERO.compareTo(export.getMonthOutput()) == 0) {
            export.setConvertElectricityPrice(export.getElectricityPrice());
            export.setConvertWaterPrice(export.getWaterPrice());
         } else {
            export.setConvertElectricityPrice(export.getElectricityPrice().divide(export.getMonthOutput(), 2, RoundingMode.HALF_UP));
            export.setConvertWaterPrice(export.getWaterPrice().divide(export.getMonthOutput(), 2, RoundingMode.HALF_UP));
         }

         exportList.add(export);
      }

      ContractWaterElectricityCountExportDto total = new ContractWaterElectricityCountExportDto();
      total.setMonth("合计");
      total.setMonthOutput(
         exportList.stream()
            .map(ContractWaterElectricityCountExportDto::getMonthOutput)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP)
      );
      total.setUsedElectricityMete(
         exportList.stream()
            .map(ContractWaterElectricityCountExportDto::getUsedElectricityMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP)
      );
      total.setElectricityPrice(
         exportList.stream()
            .map(ContractWaterElectricityCountExportDto::getElectricityPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP)
      );
      total.setUsedWaterMete(
         exportList.stream()
            .map(ContractWaterElectricityCountExportDto::getUsedWaterMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP)
      );
      total.setWaterPrice(
         exportList.stream()
            .map(ContractWaterElectricityCountExportDto::getWaterPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP)
      );
      if (BigDecimal.ZERO.compareTo(total.getUsedElectricityMete()) == 0) {
         total.setElectricityAvgPrice(total.getElectricityPrice());
      } else {
         total.setElectricityAvgPrice(total.getElectricityPrice().divide(total.getUsedElectricityMete(), 2, RoundingMode.HALF_UP));
      }

      if (BigDecimal.ZERO.compareTo(total.getUsedWaterMete()) == 0) {
         total.setWaterAvgPrice(total.getWaterPrice());
      } else {
         total.setWaterAvgPrice(total.getWaterPrice().divide(total.getUsedWaterMete(), 2, RoundingMode.HALF_UP));
      }

      if (BigDecimal.ZERO.compareTo(total.getMonthOutput()) == 0) {
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
   }
}
