package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesMachinePartQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesMachinePartQuotaConfigDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesMachinePartQuotaConfigDetailServiceImpl
   extends ServiceImpl<MesMachinePartQuotaConfigDetailMapper, MesMachinePartQuotaConfigDetail>
   implements MesMachinePartQuotaConfigDetailService {
   @Override
   public Boolean isIntersection(List<MesMachinePartQuotaConfigDetail> list) {
      if (list.size() > 1) {
         for (int i = 0; i < list.size() - 1; i++) {
            MesMachinePartQuotaConfigDetail iDetail = list.get(i);
            Preconditions.checkArgument(BeanUtil.isNotEmpty(iDetail, "id", "machinePartQuotaConfigId", "price"), "范围不能为空");
            MaxAndMin imm = MaxAndMin.getMaxAndMin(
               iDetail.getComparisonOperatorOne(), iDetail.getNumberOne(), iDetail.getComparisonOperatorTwo(), iDetail.getNumberTwo()
            );

            for (int j = i + 1; j < list.size(); j++) {
               MesMachinePartQuotaConfigDetail jDetail = list.get(j);
               Preconditions.checkArgument(BeanUtil.isNotEmpty(jDetail, "id", "machinePartQuotaConfigId", "price"), "范围不能为空");
               MaxAndMin jmm = MaxAndMin.getMaxAndMin(
                  jDetail.getComparisonOperatorOne(), jDetail.getNumberOne(), jDetail.getComparisonOperatorTwo(), jDetail.getNumberTwo()
               );
               if (MaxAndMin.isTwoRegionIntersection(imm.getMin(), imm.getMax(), jmm.getMin(), jmm.getMax())) {
                  return true;
               }
            }
         }
      }

      MesMachinePartQuotaConfigDetail detail = list.get(0);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(detail, "id", "machinePartQuotaConfigId", "price"), "范围不能为空");
      MaxAndMin.getMaxAndMin(detail.getComparisonOperatorOne(), detail.getNumberOne(), detail.getComparisonOperatorTwo(), detail.getNumberTwo());
      return false;
   }
}
