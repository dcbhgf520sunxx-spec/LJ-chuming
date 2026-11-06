package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesArtifactQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesArtifactQuotaConfigDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesArtifactQuotaConfigDetailServiceImpl
   extends ServiceImpl<MesArtifactQuotaConfigDetailMapper, MesArtifactQuotaConfigDetail>
   implements MesArtifactQuotaConfigDetailService {
   @Override
   public Boolean isIntersection(List<MesArtifactQuotaConfigDetail> list) {
      if (list.size() > 1) {
         for (int i = 0; i < list.size() - 1; i++) {
            MesArtifactQuotaConfigDetail iDetail = list.get(i);
            Preconditions.checkArgument(BeanUtil.isNotEmpty(iDetail, "id", "artifactQuotaConfigId", "price"), "范围不能为空");
            MaxAndMin imm = MaxAndMin.getMaxAndMin(
               iDetail.getComparisonOperatorOne(), iDetail.getNumberOne(), iDetail.getComparisonOperatorTwo(), iDetail.getNumberTwo()
            );

            for (int j = i + 1; j < list.size(); j++) {
               MesArtifactQuotaConfigDetail jDetail = list.get(j);
               Preconditions.checkArgument(BeanUtil.isNotEmpty(jDetail, "id", "artifactQuotaConfigId", "price"), "范围不能为空");
               MaxAndMin jmm = MaxAndMin.getMaxAndMin(
                  jDetail.getComparisonOperatorOne(), jDetail.getNumberOne(), jDetail.getComparisonOperatorTwo(), jDetail.getNumberTwo()
               );
               if (MaxAndMin.isTwoRegionIntersection(imm.getMin(), imm.getMax(), jmm.getMin(), jmm.getMax())) {
                  return true;
               }
            }
         }
      }

      MesArtifactQuotaConfigDetail detail = list.get(0);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(detail, "id", "artifactQuotaConfigId", "price"), "范围不能为空");
      MaxAndMin.getMaxAndMin(detail.getComparisonOperatorOne(), detail.getNumberOne(), detail.getComparisonOperatorTwo(), detail.getNumberTwo());
      return false;
   }
}
