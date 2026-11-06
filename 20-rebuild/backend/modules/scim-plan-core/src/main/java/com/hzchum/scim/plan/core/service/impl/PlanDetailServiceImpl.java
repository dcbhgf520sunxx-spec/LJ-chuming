package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailTraceDTO;
import com.hzchum.scim.plan.core.api.service.PlanDetailService;
import com.hzchum.scim.plan.core.mapper.PlanDetailMapper;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanDetailServiceImpl extends ServiceImpl<PlanDetailMapper, PlanDetail> implements PlanDetailService {
   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean setCompleteDate(Long areaId, Integer planDetailType, LocalDate completeDate) {
      PlanDetail planDetail = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(PlanDetail.class).eq(PlanDetail::getAreaId, areaId).eq(PlanDetail::getType, planDetailType));
      if (planDetail != null) {
         planDetail.setCompleteDate(completeDate);
         this.baseMapper.updateById(planDetail);
      }

      return true;
   }

   @Override
   public PlanDetailTraceDTO getMaxMInDate(Long monomerId, Integer areaProductType, Long areaId, Integer planType) {
      return this.baseMapper.selectPlanDate(monomerId, areaProductType, areaId, planType);
   }

   @Override
   public List<PlanDetailResponseDTO> listDetailByConditions(Long projectId, Long monomerId, Integer areaProductType, Integer type) {
      return this.baseMapper.selectListDetailByCondition(projectId, monomerId, areaProductType, type);
   }

   @Override
   public List<PlanDetailTraceDTO> listDetailTrace(Long monomerId, Integer areaProductType) {
      return this.baseMapper.selectListDetailTrace(monomerId, areaProductType);
   }
}
