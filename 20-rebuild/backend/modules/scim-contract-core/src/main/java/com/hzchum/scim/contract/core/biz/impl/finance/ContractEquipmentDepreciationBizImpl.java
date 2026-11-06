package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.biz.finance.ContractEquipmentDepreciationBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractEquipmentDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractEquipmentDepreciationSaveDTOParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractEquipmentDepreciationService;
import com.hzchum.scim.contract.core.mapper.finance.ContractEquipmentDepreciationMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractEquipmentDepreciationBizImpl
   extends IBizImpl<ContractEquipmentDepreciationService, ContractEquipmentDepreciationMapper, ContractEquipmentDepreciation>
   implements ContractEquipmentDepreciationBiz {
   @Autowired
   private BranchCompanyService branchCompanyService;

   @Override
   public PageVO<ContractEquipmentDepreciationDTO> pageInfo(
      Long branchCompanyId, String classificationName, String equipmentName, Boolean boolStatus, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ContractEquipmentDepreciationDTO> dtoList = this.baseMapper.listInfo(branchCompanyId, classificationName, equipmentName, boolStatus);
      LocalDate now = LocalDate.now();
      dtoList.forEach(e -> {
         if (e.getEndDate().equals(now)) {
            e.setRemainingYears("0天");
         } else if (e.getEndDate().isAfter(now)) {
            Period period = Period.between(now, e.getEndDate());
            StringBuilder remainingYearsBuilder = new StringBuilder();
            if (period.getYears() != 0) {
               remainingYearsBuilder.append(period.getYears()).append("年");
            }

            if (period.getMonths() != 0) {
               remainingYearsBuilder.append(period.getMonths()).append("个月");
            }

            if (period.getDays() != 0) {
               remainingYearsBuilder.append(period.getDays()).append("天");
            }

            e.setRemainingYears(remainingYearsBuilder.toString());
         } else {
            e.setRemainingYears("已过年限");
         }
      });
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> pagePrint(Long branchCompanyId, String classificationName, String equipmentName, Boolean boolStatus) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "设备折旧");
      printVO.setHeader(header);
      List<ContractEquipmentDepreciationDTO> dtoList = this.baseMapper.listInfo(branchCompanyId, classificationName, equipmentName, boolStatus);
      LocalDate now = LocalDate.now();
      dtoList.forEach(e -> {
         if (e.getEndDate().equals(now)) {
            e.setRemainingYears("0天");
         } else if (e.getEndDate().isAfter(now)) {
            Period period = Period.between(now, e.getEndDate());
            StringBuilder remainingYearsBuilder = new StringBuilder();
            if (period.getYears() != 0) {
               remainingYearsBuilder.append(period.getYears()).append("年");
            }

            if (period.getMonths() != 0) {
               remainingYearsBuilder.append(period.getMonths()).append("个月");
            }

            if (period.getDays() != 0) {
               remainingYearsBuilder.append(period.getDays()).append("天");
            }

            e.setRemainingYears(remainingYearsBuilder.toString());
         } else {
            e.setRemainingYears("已过年限");
         }
      });
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInfo(ContractEquipmentDepreciationSaveDTOParam param) {
      this.verifyParameters(param);
      ContractEquipmentDepreciation equipmentDepreciation = BeanUtil.toBean(param, ContractEquipmentDepreciation.class);
      this.populateData(equipmentDepreciation);
      System.out.println(equipmentDepreciation);
      this.baseMapper.insert(equipmentDepreciation);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInfo(ContractEquipmentDepreciationSaveDTOParam param) {
      ContractEquipmentDepreciation oldEquipmentDepreciation = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldEquipmentDepreciation != null, "当前数据不存在, 请刷新后重试");
      this.verifyParameters(param);
      ContractEquipmentDepreciation equipmentDepreciation = BeanUtil.toBean(param, ContractEquipmentDepreciation.class);
      this.populateData(equipmentDepreciation);
      this.baseMapper.updateById(equipmentDepreciation);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean boolStatus) {
      ContractEquipmentDepreciation oldEquipmentDepreciation = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldEquipmentDepreciation != null, "当前数据不存在, 请刷新后重试");
      this.baseMapper.updateById(ContractEquipmentDepreciation.builder().id(id).boolStatus(boolStatus).build());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      ContractEquipmentDepreciation oldEquipmentDepreciation = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldEquipmentDepreciation != null, "当前数据不存在, 请刷新后重试");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   private void populateData(ContractEquipmentDepreciation equipmentDepreciation) {
      equipmentDepreciation.setResidualValue(equipmentDepreciation.getOriginalValue().multiply(equipmentDepreciation.getResidualValueRate()));
      equipmentDepreciation.setYearDepreciationRate(
         BigDecimal.ONE.subtract(equipmentDepreciation.getResidualValueRate()).divide(equipmentDepreciation.getDepreciationYear(), 8, 4)
      );
      equipmentDepreciation.setYearDepreciationAmount(
         BigDecimal.ONE
            .subtract(equipmentDepreciation.getResidualValueRate())
            .multiply(equipmentDepreciation.getOriginalValue())
            .divide(equipmentDepreciation.getDepreciationYear(), 2, 4)
      );
      equipmentDepreciation.setMonthDepreciationRate(
         BigDecimal.ONE
            .subtract(equipmentDepreciation.getResidualValueRate())
            .divide(equipmentDepreciation.getDepreciationYear().multiply(BigDecimal.valueOf(12L)), 8, 4)
      );
      equipmentDepreciation.setMonthDepreciationAmount(
         BigDecimal.ONE
            .subtract(equipmentDepreciation.getResidualValueRate())
            .multiply(equipmentDepreciation.getOriginalValue())
            .divide(equipmentDepreciation.getDepreciationYear().multiply(BigDecimal.valueOf(12L)), 2, 4)
      );
      equipmentDepreciation.setUserId(UserUtil.getCurrentUserId());
      equipmentDepreciation.setBoolStatus(true);
   }

   private void verifyParameters(ContractEquipmentDepreciationSaveDTOParam param) {
      Integer equipmentNameRepeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(ContractEquipmentDepreciation.class)
               .ne(param.getId() != null, ContractEquipmentDepreciation::getId, param.getId())
               .eq(ContractEquipmentDepreciation::getEquipmentName, param.getEquipmentName())
         );
      Preconditions.checkArgument(equipmentNameRepeat == 0, "设备名称重复");
      BranchCompany branchCompany = this.branchCompanyService
         .getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getId, param.getBranchCompanyId()).eq(BranchCompany::getEnabled, true));
      Preconditions.checkArgument(branchCompany != null, "费用归属已禁用或不存在");
   }
}
