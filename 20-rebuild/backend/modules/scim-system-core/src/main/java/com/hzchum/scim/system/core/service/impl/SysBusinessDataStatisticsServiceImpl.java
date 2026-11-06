package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.common.enums.BimModelRestrictedTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysBusinessDataStatistics;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelRestrictConfigDTO;
import com.hzchum.scim.system.core.api.service.BimModelRestrictConfigService;
import com.hzchum.scim.system.core.mapper.SysBusinessDataStatisticsMapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SysBusinessDataStatisticsServiceImpl
   extends ServiceImpl<SysBusinessDataStatisticsMapper, SysBusinessDataStatistics>
   implements BimModelRestrictConfigService {
   @Override
   public void updateValue(List<BimModelRestrictConfigDTO> dtos) {
      Map<String, List<SysBusinessDataStatistics>> statisticsListMap = this.baseMapper
         .selectList(Wrappers.lambdaQuery(SysBusinessDataStatistics.class))
         .stream()
         .collect(Collectors.groupingBy(SysBusinessDataStatistics::getCode));
      dtos.forEach(item -> {
         if (statisticsListMap.containsKey(item.getCode())) {
            statisticsListMap.get(item.getCode()).stream().forEach(statistics -> {
               if (BimModelRestrictedTypeEnum.TOTAL_QUANTITY.getName().equals(statistics.getCode())) {
                  Integer num = Integer.valueOf(statistics.getValue()) + Integer.valueOf(item.getValue());
                  statistics.setValue(String.valueOf(num));
               } else {
                  Double num = Double.parseDouble(statistics.getValue()) + Double.parseDouble(item.getValue());
                  statistics.setValue(String.valueOf(num));
               }

               this.baseMapper.updateById(statistics);
            });
         } else {
            this.baseMapper.insert(SysBusinessDataStatistics.builder().code(item.getCode()).value(item.getValue()).name(item.getName()).build());
         }
      });
   }
}
