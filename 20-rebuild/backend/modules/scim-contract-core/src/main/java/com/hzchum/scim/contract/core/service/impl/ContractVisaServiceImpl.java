package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.contract.core.mapper.ContractVisaMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ContractVisaServiceImpl extends ServiceImpl<ContractVisaMapper, ContractVisa> implements ContractVisaService {
   @Override
   public List<ContractVisa> listByCondition(
      Long projectId, Integer status, String userName, String checkUerName, Integer mode, String year, Integer businessType, Integer type
   ) {
      return this.baseMapper.selectListByCondition(projectId, status, userName, checkUerName, mode, year, businessType, type);
   }

   @Override
   public int countByProject(Long projectId, Integer mode) {
      return this.baseMapper.countByProject(projectId, mode);
   }

   @Override
   public int getCount(LocalDateTime now, Integer mode) {
      return this.baseMapper.getCount(now, mode);
   }

   @Override
   public BigDecimal sumVisaAmount(Long projectId, Integer mode, Integer type) {
      return this.baseMapper
         .selectList(
            (Wrapper<ContractVisa>)(((Wrappers.<ContractVisa>lambdaQuery()
                        .eq(ContractVisa::getStatus, CheckStatusEnum.PASS.getType()))
                     .eq(ContractVisa::getProjectId, projectId))
                  .eq(ContractVisa::getMode, mode))
               .eq(ContractVisa::getType, type)
         )
         .stream()
         .map(ContractVisa::getVisaAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<Long> listProjectIdsWithSettle() {
      return this.baseMapper
         .selectList((Wrapper<ContractVisa>)Wrappers.<ContractVisa>lambdaQuery().eq(ContractVisa::getType, VisaTypeEnum.SETTLEMENT.getType()))
         .stream()
         .map(ContractVisa::getProjectId)
         .distinct()
         .collect(Collectors.toList());
   }

   @Override
   public Boolean checkProjectIsSettlement(Long projectId) {
      return this.baseMapper
            .selectCount(
               (Wrapper<ContractVisa>)(Wrappers.<ContractVisa>lambdaQuery().eq(ContractVisa::getProjectId, projectId))
                  .eq(ContractVisa::getType, VisaTypeEnum.SETTLEMENT.getType())
            )
         > 0;
   }
}
