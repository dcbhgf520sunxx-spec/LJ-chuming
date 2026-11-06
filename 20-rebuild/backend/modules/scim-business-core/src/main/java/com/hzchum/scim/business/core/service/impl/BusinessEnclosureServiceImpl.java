package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.dto.EnclosureSummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureFindDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.mapper.BusinessEnclosureMapper;
import com.hzchum.scim.contract.core.api.enums.EnclosureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessEnclosureServiceImpl extends ServiceImpl<BusinessEnclosureMapper, BusinessEnclosure> implements BusinessEnclosureService {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @Override
   public Long addBusinessInfo(EnclosureAddDTOParam param) {
      BusinessEnclosure business = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(BusinessEnclosure.class)
               .eq(BusinessEnclosure::getProjectId, param.getProjectId())
               .eq(BusinessEnclosure::getCategory, param.getCategory())
               .eq(BusinessEnclosure::getEnclosurePlanId, param.getEnclosurePlanId())
               .eq(BusinessEnclosure::getName, param.getName())
               .eq(BusinessEnclosure::getPlate, param.getPlate())
               .eq(BusinessEnclosure::getBrand, param.getBrand())
               .eq(BusinessEnclosure::getColor, param.getColor())
               .eq(BusinessEnclosure::getThickness, param.getThickness())
               .eq(BusinessEnclosure::getUnfoldedWidth, param.getUnfoldedWidth())
               .eq(BusinessEnclosure::getBendTimes, param.getBendTimes())
               .eq(param.getCoating() != null, BusinessEnclosure::getCoating, param.getCoating())
               .isNull(param.getCoating() == null, BusinessEnclosure::getCoating)
               .eq(param.getPlating() != null, BusinessEnclosure::getPlating, param.getPlating())
               .isNull(param.getPlating() == null, BusinessEnclosure::getPlating)
         );
      if (business == null) {
         BusinessEnclosure copy = BeanUtil.copy(param, BusinessEnclosure.class);
         copy.setTotalQuantity(param.getQuantity());
         this.baseMapper.insert(copy);
         return copy.getId();
      } else {
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         business.setTotalArea(business.getTotalArea().add(param.getTotalArea()));
         business.setTotalLength(business.getTotalLength().add(param.getTotalLength()));
         this.baseMapper.updateById(business);
         return business.getId();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void editBusinessInfo(EnclosureEditDTOParam param) {
      BusinessEnclosure business = this.baseMapper.selectById(param.getBusinessId());
      Preconditions.checkArgument(business != null, "记录不存在");
      business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
      business.setTotalLength(business.getTotalLength().add(param.getTotalLength()));
      business.setTotalArea(business.getTotalArea().add(param.getTotalArea()));
      if (business.getUnitPrice() != null) {
         if (business.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())) {
            business.setTotalPrice(business.getUnitPrice().multiply(business.getTotalLength()));
         } else {
            business.setTotalPrice(business.getUnitPrice().multiply(business.getTotalArea()));
         }
      }

      if (business.getTotalQuantity() == 0) {
         this.baseMapper.deleteById(param.getBusinessId());
      } else {
         this.baseMapper.updateById(business);
      }
   }

   @Override
   public List<BusinessEnclosure> listByCondition(EnclosureFindDTOParam param) {
      return this.baseMapper
         .selectList(
            (((((((Wrappers.<BusinessEnclosure>lambdaQuery()
                                    .eq(param.getProjectId() != null, BusinessEnclosure::getProjectId, param.getProjectId()))
                                 .eq(param.getEnclosurePlanId() != null, BusinessEnclosure::getEnclosurePlanId, param.getEnclosurePlanId()))
                              .eq(param.getCategory() != null, BusinessEnclosure::getCategory, param.getCategory()))
                           .like(StringUtils.isNotBlank(param.getName()), BusinessEnclosure::getName, param.getName()))
                        .like(StringUtils.isNotBlank(param.getPlate()), BusinessEnclosure::getPlate, param.getPlate()))
                     .like(StringUtils.isNotBlank(param.getBrand()), BusinessEnclosure::getBrand, param.getBrand()))
                  .like(StringUtils.isNotBlank(param.getColor()), BusinessEnclosure::getColor, param.getColor()))
               .eq(param.getThickness() != null, BusinessEnclosure::getThickness, param.getThickness())
         );
   }

   @Override
   public EnclosureSummaryDTO summary(Long projectId, Long monomerId) {
      Map<Integer, Integer> priceTypeMap = this.utilsBiz.listEnclosureMeasureMode(projectId);
      EnclosureSummaryDTO dto = EnclosureSummaryDTO.builder()
         .totalPrice(BigDecimal.ZERO)
         .totalLength(BigDecimal.ZERO)
         .totalArea(BigDecimal.ZERO)
         .totalQuantity(0)
         .build();
      this.baseMapper.summary(projectId, monomerId).forEach(e -> {
         if (priceTypeMap.get(e.getCategory()).equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())) {
            dto.setTotalPrice(dto.getTotalPrice().add(e.getUnitPrice().multiply(e.getTotalLength().divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP))));
         } else {
            dto.setTotalPrice(dto.getTotalArea().add(e.getUnitPrice().multiply(e.getTotalArea())));
         }

         dto.setTotalArea(dto.getTotalArea().add(e.getTotalArea()));
         dto.setTotalLength(dto.getTotalLength().add(e.getTotalLength()));
         dto.setTotalQuantity(dto.getTotalQuantity() + e.getTotalQuantity());
      });
      return dto;
   }
}
