package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.ContractFixedAssetsDepreciationBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFixedAssetsDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.FactoryBuildingDepreciationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractFixedAssetsDepreciationDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractFixedAssetsDepreciationSaveDtoParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractFixedAssetsDepreciationService;
import com.hzchum.scim.contract.core.mapper.finance.ContractFixedAssetsDepreciationMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractFixedAssetsDepreciationBizImpl
   extends IBizImpl<ContractFixedAssetsDepreciationService, ContractFixedAssetsDepreciationMapper, ContractFixedAssetsDepreciation>
   implements ContractFixedAssetsDepreciationBiz {
   @Autowired
   private BranchCompanyService branchCompanyService;

   @Override
   public PageVO<ContractFixedAssetsDepreciationDTO> listByCondition(Integer type, String name, Boolean boolStatus, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.baseService.listByCondition(type, name, boolStatus));
   }

   @Override
   public Boolean saveList(List<ContractFixedAssetsDepreciationDtoParam> paramList) {
      paramList.forEach(param -> {
         Preconditions.checkArgument(!this.baseService.isExist(param.getType(), param.getName()), "折旧记录已存在");
         ContractFixedAssetsDepreciation depreciation = BeanUtil.copy(param, ContractFixedAssetsDepreciation.class);
         this.setField(param, depreciation);
         depreciation.setUserId(UserUtil.getCurrentUserId());
         depreciation.setBoolStatus(true);
         depreciation.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
         this.baseService.save(depreciation);
      });
      return true;
   }

   void setField(ContractFixedAssetsDepreciationDtoParam param, ContractFixedAssetsDepreciation depreciation) {
      depreciation.setResidualValueRate(param.getResidualValueRate());
      depreciation.setResidualValue(param.getOriginalValue().multiply(param.getResidualValueRate()));
      depreciation.setYearDepreciationRate(BigDecimal.ONE.subtract(param.getResidualValueRate()).divide(param.getDepreciationYear(), 8, 4));
      depreciation.setYearDepreciationAmount(
         BigDecimal.ONE.subtract(param.getResidualValueRate()).multiply(param.getOriginalValue()).divide(param.getDepreciationYear(), 2, 4)
      );
      depreciation.setMonthDepreciationRate(
         BigDecimal.ONE.subtract(param.getResidualValueRate()).divide(param.getDepreciationYear().multiply(BigDecimal.valueOf(12L)), 8, 4)
      );
      depreciation.setMonthDepreciationAmount(
         BigDecimal.ONE
            .subtract(param.getResidualValueRate())
            .multiply(param.getOriginalValue())
            .divide(param.getDepreciationYear().multiply(BigDecimal.valueOf(12L)), 2, 4)
      );
      depreciation.setYearMonthValue(param.getStartDate().getYear() * 100 + param.getStartDate().getMonthValue());
      depreciation.setEndYearMonth(this.getEndYearMonth(param.getDepreciationYear(), param.getStartDate()));
   }

   private Integer getEndYearMonth(BigDecimal depreciationYear, LocalDate startDate) {
      int monthCount = depreciationYear.multiply(BigDecimal.valueOf(12L)).setScale(0, RoundingMode.UP).intValue();
      int endYear = monthCount / 12 + startDate.getYear();
      int months = monthCount % 12 + startDate.getMonthValue();
      return (endYear + months / 12) * 100 + months % 12;
   }

   @Override
   public Boolean updateList(List<ContractFixedAssetsDepreciationDtoParam> paramList) {
      paramList.forEach(param -> {
         ContractFixedAssetsDepreciation depreciation = this.baseService.getById(param.getId());
         Preconditions.checkArgument(depreciation != null, "记录不存在");
         Preconditions.checkArgument(depreciation.getBoolStatus().equals(true), "修改失败,状态已关闭!");
         if (!param.getType().equals(depreciation.getType()) || !param.getName().equals(depreciation.getName())) {
            Preconditions.checkArgument(!this.baseService.isExist(param.getType(), param.getName()), "折旧记录已存在");
         }

         this.setField(param, depreciation);
         BeanUtil.copy(param, depreciation);
         depreciation.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
         this.baseService.updateById(depreciation);
      });
      return true;
   }

   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractFixedAssetsDepreciation depreciation = this.baseService.getById(id);
         Preconditions.checkArgument(depreciation != null, "删除失败,记录不存在");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public Boolean updateStatus(Long id, Boolean boolStatus) {
      ContractFixedAssetsDepreciation depreciation = this.baseService.getById(id);
      Preconditions.checkArgument(depreciation != null, "记录不存在");
      Preconditions.checkArgument(boolStatus.equals(false) || depreciation.getBoolStatus().equals(true), "状态已关闭");
      if (depreciation.getBoolStatus().equals(true) && boolStatus.equals(false)) {
         depreciation.setEndYearMonth(LocalDate.now().getYear() * 100 + LocalDate.now().getMonthValue());
      }

      depreciation.setBoolStatus(boolStatus);
      this.baseService.updateById(depreciation);
      return true;
   }

   @Override
   public PageVO<FactoryBuildingDepreciationDTO> factoryBuildingDepreciationPage(
      Long branchCompanyId, String name, Boolean boolStatus, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort));
      List<FactoryBuildingDepreciationDTO> dtoList = this.baseMapper.factoryBuildingDepreciationList(branchCompanyId, name, boolStatus);
      LocalDate now = LocalDate.now();
      dtoList.forEach(e -> {
         if (e.getEndDate() != null) {
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
         }
      });
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> factoryBuildingDepreciationPrint(Long branchCompanyId, String name, Boolean boolStatus) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "厂房折旧");
      printVO.setHeader(header);
      List<FactoryBuildingDepreciationDTO> dtoList = this.baseMapper.factoryBuildingDepreciationList(branchCompanyId, name, boolStatus);
      LocalDate now = LocalDate.now();
      dtoList.forEach(e -> {
         if (e.getEndDate() != null) {
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
         }
      });
      List<Map<String, Object>> mapList = dtoList.stream().map(cn.hutool.core.bean.BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveFactoryBuildingDepreciation(ContractFixedAssetsDepreciationSaveDtoParam param) {
      this.verifyParameters(param);
      ContractFixedAssetsDepreciation factoryBuildingDepreciation = cn.hutool.core.bean.BeanUtil.toBean(param, ContractFixedAssetsDepreciation.class);
      this.populateData(factoryBuildingDepreciation);
      this.baseMapper.insert(factoryBuildingDepreciation);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateFactoryBuildingDepreciation(ContractFixedAssetsDepreciationSaveDtoParam param) {
      ContractFixedAssetsDepreciation factoryBuildingDepreciation = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(factoryBuildingDepreciation != null, "当前数据不存在, 请刷新后重试");
      this.verifyParameters(param);
      ContractFixedAssetsDepreciation newFactoryBuildingDepreciation = cn.hutool.core.bean.BeanUtil.toBean(param, ContractFixedAssetsDepreciation.class);
      this.populateData(newFactoryBuildingDepreciation);
      this.baseMapper.updateById(newFactoryBuildingDepreciation);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatusFactoryBuildingDepreciation(Long id, Boolean boolStatus) {
      ContractFixedAssetsDepreciation factoryBuildingDepreciation = this.baseMapper.selectById(id);
      Preconditions.checkArgument(factoryBuildingDepreciation != null, "当前数据不存在, 请刷新后重试");
      this.baseMapper.updateById(ContractFixedAssetsDepreciation.builder().id(id).boolStatus(boolStatus).build());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteFactoryBuildingDepreciation(Long id) {
      ContractFixedAssetsDepreciation factoryBuildingDepreciation = this.baseMapper.selectById(id);
      Preconditions.checkArgument(factoryBuildingDepreciation != null, "当前数据不存在, 请刷新后重试");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   private void populateData(ContractFixedAssetsDepreciation factoryBuildingDepreciation) {
      factoryBuildingDepreciation.setType(1);
      factoryBuildingDepreciation.setResidualValue(factoryBuildingDepreciation.getOriginalValue().multiply(factoryBuildingDepreciation.getResidualValueRate()));
      factoryBuildingDepreciation.setYearDepreciationRate(
         BigDecimal.ONE.subtract(factoryBuildingDepreciation.getResidualValueRate()).divide(factoryBuildingDepreciation.getDepreciationYear(), 8, 4)
      );
      factoryBuildingDepreciation.setYearDepreciationAmount(
         BigDecimal.ONE
            .subtract(factoryBuildingDepreciation.getResidualValueRate())
            .multiply(factoryBuildingDepreciation.getOriginalValue())
            .divide(factoryBuildingDepreciation.getDepreciationYear(), 2, 4)
      );
      factoryBuildingDepreciation.setMonthDepreciationRate(
         BigDecimal.ONE
            .subtract(factoryBuildingDepreciation.getResidualValueRate())
            .divide(factoryBuildingDepreciation.getDepreciationYear().multiply(BigDecimal.valueOf(12L)), 8, 4)
      );
      factoryBuildingDepreciation.setMonthDepreciationAmount(
         BigDecimal.ONE
            .subtract(factoryBuildingDepreciation.getResidualValueRate())
            .multiply(factoryBuildingDepreciation.getOriginalValue())
            .divide(factoryBuildingDepreciation.getDepreciationYear().multiply(BigDecimal.valueOf(12L)), 2, 4)
      );
      factoryBuildingDepreciation.setYearMonthValue(
         factoryBuildingDepreciation.getStartDate().getYear() * 100 + factoryBuildingDepreciation.getStartDate().getMonthValue()
      );
      factoryBuildingDepreciation.setEndYearMonth(
         this.getEndYearMonth(factoryBuildingDepreciation.getDepreciationYear(), factoryBuildingDepreciation.getStartDate())
      );
      factoryBuildingDepreciation.setUserId(UserUtil.getCurrentUserId());
      factoryBuildingDepreciation.setBoolStatus(true);
   }

   private void verifyParameters(ContractFixedAssetsDepreciationSaveDtoParam param) {
      Integer nameRepeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(ContractFixedAssetsDepreciation.class)
               .ne(param.getId() != null, ContractFixedAssetsDepreciation::getId, param.getId())
               .eq(ContractFixedAssetsDepreciation::getName, param.getName())
         );
      Preconditions.checkArgument(nameRepeat == 0, "名称重复");
      BranchCompany branchCompany = this.branchCompanyService
         .getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getId, param.getBranchCompanyId()).eq(BranchCompany::getEnabled, true));
      Preconditions.checkArgument(branchCompany != null, "费用归属已禁用或不存在");
   }
}
