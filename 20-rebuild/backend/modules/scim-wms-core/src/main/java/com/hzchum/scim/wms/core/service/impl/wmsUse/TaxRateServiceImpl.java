package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.TaxRate;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.TaxRateDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.RDRateDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.TaxRateDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.TaxRateService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.TaxRateMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaxRateServiceImpl extends ServiceImpl<TaxRateMapper, TaxRate> implements TaxRateService {
   @Resource
   TaxRateMapper taxRateMapper;
   @Resource
   MeasureService measureService;

   @Override
   public ListVO<TaxRateDTO> listInfo() {
      TaxRate taxRate1 = this.taxRateMapper.selectOne((Wrapper<TaxRate>)new LambdaQueryWrapper<TaxRate>().eq(TaxRate::getClassification, 128));
      if (taxRate1 == null) {
         this.taxRateMapper.insert(TaxRate.builder().taxRateList("13").classification(128).userUpdateTime(LocalDateTime.now()).build());
      }

      List<TaxRateDTO> taxRates = this.taxRateMapper
         .selectList(null)
         .stream()
         .map(
            taxRate -> {
               TaxRateDTO rateDTO = TaxRateDTO.builder()
                  .id(taxRate.getId())
                  .classification(taxRate.getClassification())
                  .createTime(taxRate.getCreateTime())
                  .userUpdateTime(taxRate.getUserUpdateTime())
                  .build();
               rateDTO.setTaxRateList(Arrays.stream(taxRate.getTaxRateList().split(",")).map(BigDecimal::new).collect(Collectors.toList()));
               return rateDTO;
            }
         )
         .collect(Collectors.toList());
      return new ListVO<>(taxRates);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateTaxRate(TaxRateDTOParam param) {
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(param.getTaxRateList()), "至少保留一条税率数据");
      Preconditions.checkArgument(param.getTaxRateList().stream().allMatch(value -> value != null
         && value.compareTo(BigDecimal.ZERO) >= 0 && value.compareTo(new BigDecimal("100")) <= 0), "税率范围必须在0到100之间");
      Preconditions.checkArgument(param.getTaxRateList().stream().map(BigDecimal::stripTrailingZeros).distinct().count()
         == param.getTaxRateList().size(), "修改失败,当前税率重复");
      TaxRate taxRate = this.taxRateMapper.selectById(param.getId());
      Preconditions.checkArgument(taxRate != null, "税率信息不存在");
      if (CollectionUtil.isNotEmpty(param.getTaxRateList())) {
         for (BigDecimal value : param.getTaxRateList()) {
            Preconditions.checkArgument(Collections.frequency(param.getTaxRateList(), value) <= 1, "修改失败,当前税率重复");
         }

         taxRate.setTaxRateList(StrUtil.join(",", param.getTaxRateList()));
      }

      taxRate.setUserUpdateTime(LocalDateTime.now());
      return this.taxRateMapper.updateById(taxRate) == 1;
   }

   @Override
   public ListVO<TaxRateDTO> getTaxRateBrief() {
      ListVO<TaxRateDTO> taxRateDTOListVO = this.listInfo();
      List<TaxRateDTO> list = taxRateDTOListVO.getContent().stream().peek(taxRateDTO -> {
         taxRateDTO.setCreateTime(null);
         taxRateDTO.setUserUpdateTime(null);
      }).collect(Collectors.toList());
      return new ListVO<>(list);
   }

   @Override
   public ListVO<SubjectMeasureDTO> rdRateList() {
      return this.measureService.listTree(1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateRdRate(List<RDRateDTOParam> params) {
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(params), "请选择需要修改的研发费用比例");
      for (RDRateDTOParam param : params) {
         Preconditions.checkArgument(param != null && param.getId() != null, "当前科目信息异常");
         Preconditions.checkArgument(param.getRdRate() == null || (param.getRdRate().compareTo(BigDecimal.ZERO) >= 0
            && param.getRdRate().compareTo(new BigDecimal("100")) <= 0), "当前研发费用占比范围必须在0到100之间");
         Measure m = this.measureService.getById(param.getId());
         Preconditions.checkArgument(m != null, "当前科目信息异常");
         if (param.getRdRate() != null && param.getRdRate().compareTo(BigDecimal.ZERO) > 0) {
            Preconditions.checkArgument(param.getRdRate().compareTo(new BigDecimal(100)) <= 0, "当前研发费用占比不能超过100%");
         }

         this.measureService.update(Wrappers.<Measure>lambdaUpdate().eq(Measure::getId, m.getId()).set(Measure::getRdRate, param.getRdRate()));
      }

      return true;
   }
}
