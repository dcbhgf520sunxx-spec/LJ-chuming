package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesAssembleQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesAssembleQuotaConfigDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesAssembleQuotaConfigDetailServiceImpl
   extends ServiceImpl<MesAssembleQuotaConfigDetailMapper, MesAssembleQuotaConfigDetail>
   implements MesAssembleQuotaConfigDetailService {
   @Override
   public Boolean isIntersection(List<MesAssembleQuotaConfigDetail> list) {
      if (list.size() > 1) {
         for (int i = 0; i < list.size() - 1; i++) {
            MesAssembleQuotaConfigDetail iDetail = list.get(i);
            Preconditions.checkArgument(BeanUtil.isNotEmpty(iDetail, "id", "assembleQuotaConfigId", "price"), "范围不能为空");
            MaxAndMin iSectionHeight = MaxAndMin.getMaxAndMin(
               iDetail.getSectionHeightComparisonOperatorOne(),
               iDetail.getSectionHeightNumberOne(),
               iDetail.getSectionHeightComparisonOperatorTwo(),
               iDetail.getSectionHeightNumberTwo()
            );
            MaxAndMin iWebThickness = MaxAndMin.getMaxAndMin(
               iDetail.getWebThicknessComparisonOperatorOne(),
               iDetail.getWebThicknessNumberOne(),
               iDetail.getWebThicknessComparisonOperatorTwo(),
               iDetail.getWebThicknessNumberTwo()
            );

            for (int j = i + 1; j < list.size(); j++) {
               MesAssembleQuotaConfigDetail jDetail = list.get(j);
               Preconditions.checkArgument(BeanUtil.isNotEmpty(jDetail, "id", "assembleQuotaConfigId", "price"), "范围不能为空");
               MaxAndMin jSectionHeight = MaxAndMin.getMaxAndMin(
                  jDetail.getSectionHeightComparisonOperatorOne(),
                  jDetail.getSectionHeightNumberOne(),
                  jDetail.getSectionHeightComparisonOperatorTwo(),
                  jDetail.getSectionHeightNumberTwo()
               );
               MaxAndMin jWebThickness = MaxAndMin.getMaxAndMin(
                  jDetail.getWebThicknessComparisonOperatorOne(),
                  jDetail.getWebThicknessNumberOne(),
                  jDetail.getWebThicknessComparisonOperatorTwo(),
                  jDetail.getWebThicknessNumberTwo()
               );
               if (MaxAndMin.isTwoRegionIntersection(iSectionHeight.getMin(), iSectionHeight.getMax(), jSectionHeight.getMin(), jSectionHeight.getMax())
                  && MaxAndMin.isTwoRegionIntersection(iWebThickness.getMin(), iWebThickness.getMax(), jWebThickness.getMin(), jWebThickness.getMax())) {
                  return true;
               }
            }
         }
      }

      MesAssembleQuotaConfigDetail detail = list.get(0);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(detail, "id", "assembleQuotaConfigId", "price"), "范围不能为空");
      MaxAndMin.getMaxAndMin(
         detail.getSectionHeightComparisonOperatorOne(),
         detail.getSectionHeightNumberOne(),
         detail.getSectionHeightComparisonOperatorTwo(),
         detail.getSectionHeightNumberTwo()
      );
      MaxAndMin.getMaxAndMin(
         detail.getWebThicknessComparisonOperatorOne(),
         detail.getWebThicknessNumberOne(),
         detail.getWebThicknessComparisonOperatorTwo(),
         detail.getWebThicknessNumberTwo()
      );
      return false;
   }
}
