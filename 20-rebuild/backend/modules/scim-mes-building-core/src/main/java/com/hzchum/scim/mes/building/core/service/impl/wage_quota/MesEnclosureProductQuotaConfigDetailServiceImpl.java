package com.hzchum.scim.mes.building.core.service.impl.wage_quota;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDetailDTO;
import com.hzchum.scim.mes.building.core.api.service.wage_quota.MesEnclosureProductQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.wage_quota.MesEnclosureProductQuotaConfigDetailMapper;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureProductQuotaConfigDetailServiceImpl
   extends ServiceImpl<MesEnclosureProductQuotaConfigDetailMapper, MesEnclosureProductQuotaConfigDetail>
   implements MesEnclosureProductQuotaConfigDetailService {
   @Override
   public Map<Long, List<MesEnclosureProductQuotaConfigDetailDTO>> groupByQuotaConfigIds(List<Long> quotaConfigIdList) {
      return CollUtil.isNotEmpty(quotaConfigIdList)
         ? this.list(
               (Wrapper<MesEnclosureProductQuotaConfigDetail>)new LambdaQueryWrapper<MesEnclosureProductQuotaConfigDetail>()
                  .in(MesEnclosureProductQuotaConfigDetail::getQuotaConfigId, quotaConfigIdList)
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  MesEnclosureProductQuotaConfigDetail::getQuotaConfigId,
                  Collectors.mapping(v -> BeanUtil.toBean(v, MesEnclosureProductQuotaConfigDetailDTO.class), Collectors.toList())
               )
            )
         : Collections.emptyMap();
   }

   @Override
   public Boolean isIntersection(List<MesEnclosureProductQuotaConfigDetail> list) {
      if (list.size() > 1) {
         for (int i = 0; i < list.size() - 1; i++) {
            MesEnclosureProductQuotaConfigDetail iDetail = list.get(i);
            Preconditions.checkArgument(BeanUtil.isNotEmpty(iDetail, "id", "quotaConfigId", "price"), "范围不能为空");
            MaxAndMin imm = MaxAndMin.getMaxAndMin(
               iDetail.getComparisonOperatorOne(), iDetail.getNumberOne(), iDetail.getComparisonOperatorTwo(), iDetail.getNumberTwo()
            );

            for (int j = i + 1; j < list.size(); j++) {
               MesEnclosureProductQuotaConfigDetail jDetail = list.get(j);
               Preconditions.checkArgument(BeanUtil.isNotEmpty(jDetail, "id", "quotaConfigId", "price"), "范围不能为空");
               MaxAndMin jmm = MaxAndMin.getMaxAndMin(
                  jDetail.getComparisonOperatorOne(), jDetail.getNumberOne(), jDetail.getComparisonOperatorTwo(), jDetail.getNumberTwo()
               );
               if (MaxAndMin.isTwoRegionIntersection(imm.getMin(), imm.getMax(), jmm.getMin(), jmm.getMax())) {
                  return true;
               }
            }
         }
      }

      MesEnclosureProductQuotaConfigDetail detail = list.get(0);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(detail, "id", "quotaConfigId", "price"), "范围不能为空");
      MaxAndMin.getMaxAndMin(detail.getComparisonOperatorOne(), detail.getNumberOne(), detail.getComparisonOperatorTwo(), detail.getNumberTwo());
      return false;
   }
}
