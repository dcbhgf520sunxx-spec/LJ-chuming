package com.hzchum.scim.wms.core.service.impl.wmsReport;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsMonthManufacturedCountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsMonthManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsMonthManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMonthManufacturedMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatisticsMonthManufacturedServiceImpl
   extends ServiceImpl<StatisticsMonthManufacturedMapper, StatisticsMonthManufactured>
   implements StatisticsMonthManufacturedService {
   @Resource
   private StatisticsMonthManufacturedMapper statisticsMonthManufacturedMapper;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void manufacturedStatistics(LocalDateTime now) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
      String nowMonth = now.format(dateTimeFormatter);
      String nextMonth = now.plusMonths(1L).format(dateTimeFormatter);
      List<StatisticsMonthManufactured> statisticsMonthManufactureds = this.statisticsMonthManufacturedMapper
         .selectList((Wrapper<StatisticsMonthManufactured>)new LambdaQueryWrapper<StatisticsMonthManufactured>().eq(StatisticsMonthManufactured::getMonthStr, nowMonth));
      if (!CollectionUtil.isEmpty(statisticsMonthManufactureds)) {
         BigDecimal zero = new BigDecimal(0);

         for (StatisticsMonthManufactured statisticsMonthManufactured : statisticsMonthManufactureds) {
            BigDecimal beginMonthTotalQuantity = ObjectUtil.isNotEmpty(statisticsMonthManufactured.getBeginMonthTotalQuantity())
               ? statisticsMonthManufactured.getBeginMonthTotalQuantity()
               : BigDecimal.ZERO;
            BigDecimal inboundTotalQuantity = ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalQuantity())
               ? statisticsMonthManufactured.getInboundTotalQuantity()
               : BigDecimal.ZERO;
            BigDecimal outboundTotalQuantity = ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalQuantity())
               ? statisticsMonthManufactured.getOutboundTotalQuantity()
               : BigDecimal.ZERO;
            BigDecimal returnTotalQuantity = ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalQuantity())
               ? statisticsMonthManufactured.getReturnTotalQuantity()
               : BigDecimal.ZERO;
            BigDecimal endMonthTotalQuantity = beginMonthTotalQuantity.add(inboundTotalQuantity).add(returnTotalQuantity).subtract(outboundTotalQuantity);
            statisticsMonthManufactured.setEndMonthTotalQuantity(endMonthTotalQuantity);
            BigDecimal endMonthTotalWeight = null;
            BigDecimal endMonthTotalLength = null;
            BigDecimal endMonthTotalArea = null;
            if (ObjectUtil.isNotEmpty(statisticsMonthManufactured.getBeginMonthTotalWeight())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalWeight())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalWeight())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalWeight())) {
               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getBeginMonthTotalWeight())) {
                  statisticsMonthManufactured.setBeginMonthTotalWeight(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getInboundTotalWeight())) {
                  statisticsMonthManufactured.setInboundTotalWeight(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getOutboundTotalWeight())) {
                  statisticsMonthManufactured.setOutboundTotalWeight(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getReturnTotalWeight())) {
                  statisticsMonthManufactured.setReturnTotalWeight(zero);
               }

               endMonthTotalWeight = statisticsMonthManufactured.getBeginMonthTotalWeight()
                  .add(statisticsMonthManufactured.getInboundTotalWeight())
                  .add(statisticsMonthManufactured.getReturnTotalWeight())
                  .subtract(statisticsMonthManufactured.getOutboundTotalWeight());
               statisticsMonthManufactured.setEndMonthTotalWeight(endMonthTotalWeight);
            }

            if (ObjectUtil.isNotEmpty(statisticsMonthManufactured.getBeginMonthTotalLength())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalLength())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalLength())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalLength())) {
               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getBeginMonthTotalLength())) {
                  statisticsMonthManufactured.setBeginMonthTotalLength(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getInboundTotalLength())) {
                  statisticsMonthManufactured.setInboundTotalLength(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getOutboundTotalLength())) {
                  statisticsMonthManufactured.setOutboundTotalLength(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getReturnTotalLength())) {
                  statisticsMonthManufactured.setReturnTotalLength(zero);
               }

               endMonthTotalLength = statisticsMonthManufactured.getBeginMonthTotalLength()
                  .add(statisticsMonthManufactured.getInboundTotalLength())
                  .add(statisticsMonthManufactured.getReturnTotalLength())
                  .subtract(statisticsMonthManufactured.getOutboundTotalLength());
               statisticsMonthManufactured.setEndMonthTotalLength(endMonthTotalLength);
            }

            if (ObjectUtil.isNotEmpty(statisticsMonthManufactured.getBeginMonthTotalArea())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalArea())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalArea())
               || ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalArea())) {
               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getBeginMonthTotalArea())) {
                  statisticsMonthManufactured.setBeginMonthTotalArea(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getInboundTotalArea())) {
                  statisticsMonthManufactured.setInboundTotalArea(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getOutboundTotalArea())) {
                  statisticsMonthManufactured.setOutboundTotalArea(zero);
               }

               if (ObjectUtil.isEmpty(statisticsMonthManufactured.getReturnTotalArea())) {
                  statisticsMonthManufactured.setReturnTotalArea(zero);
               }

               endMonthTotalArea = statisticsMonthManufactured.getBeginMonthTotalArea()
                  .add(statisticsMonthManufactured.getInboundTotalArea())
                  .add(statisticsMonthManufactured.getReturnTotalArea())
                  .subtract(statisticsMonthManufactured.getOutboundTotalArea());
               statisticsMonthManufactured.setEndMonthTotalArea(endMonthTotalArea);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getBeginMonthAmount())) {
               statisticsMonthManufactured.setBeginMonthAmount(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getBeginMonthAmountExcludingVat())) {
               statisticsMonthManufactured.setBeginMonthAmountExcludingVat(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getInboundAmount())) {
               statisticsMonthManufactured.setInboundAmount(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getInboundAmountExcludingVat())) {
               statisticsMonthManufactured.setInboundAmountExcludingVat(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getOutboundAmount())) {
               statisticsMonthManufactured.setOutboundAmount(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getOutboundAmountExcludingVat())) {
               statisticsMonthManufactured.setOutboundAmountExcludingVat(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getReturnAmount())) {
               statisticsMonthManufactured.setReturnAmount(zero);
            }

            if (ObjectUtil.isEmpty(statisticsMonthManufactured.getReturnAmountExcludingVat())) {
               statisticsMonthManufactured.setReturnAmountExcludingVat(zero);
            }

            BigDecimal endMonthAmount = statisticsMonthManufactured.getBeginMonthAmount()
               .add(statisticsMonthManufactured.getInboundAmount())
               .add(statisticsMonthManufactured.getReturnAmount())
               .subtract(statisticsMonthManufactured.getOutboundAmount());
            statisticsMonthManufactured.setEndMonthAmount(endMonthAmount);
            BigDecimal endMonthAmountExcludingVat = statisticsMonthManufactured.getBeginMonthAmountExcludingVat()
               .add(statisticsMonthManufactured.getInboundAmountExcludingVat())
               .add(statisticsMonthManufactured.getReturnAmountExcludingVat())
               .subtract(statisticsMonthManufactured.getOutboundAmountExcludingVat());
            statisticsMonthManufactured.setEndMonthAmountExcludingVat(endMonthAmountExcludingVat);
            this.statisticsMonthManufacturedMapper.updateById(statisticsMonthManufactured);
            if (endMonthTotalQuantity.compareTo(zero) != 0 || endMonthAmount.compareTo(zero) != 0) {
               statisticsMonthManufactured.setBeginMonthTotalQuantity(endMonthTotalQuantity);
               statisticsMonthManufactured.setBeginMonthTotalWeight(endMonthTotalWeight);
               statisticsMonthManufactured.setBeginMonthTotalLength(endMonthTotalLength);
               statisticsMonthManufactured.setBeginMonthTotalArea(endMonthTotalArea);
               statisticsMonthManufactured.setBeginMonthAmount(endMonthAmount);
               statisticsMonthManufactured.setBeginMonthAmountExcludingVat(endMonthAmountExcludingVat);
               statisticsMonthManufactured.setInboundTotalQuantity(null);
               statisticsMonthManufactured.setInboundTotalWeight(null);
               statisticsMonthManufactured.setInboundTotalLength(null);
               statisticsMonthManufactured.setInboundTotalArea(null);
               statisticsMonthManufactured.setInboundAmount(null);
               statisticsMonthManufactured.setInboundAmountExcludingVat(null);
               statisticsMonthManufactured.setOutboundTotalQuantity(null);
               statisticsMonthManufactured.setOutboundTotalWeight(null);
               statisticsMonthManufactured.setOutboundTotalLength(null);
               statisticsMonthManufactured.setOutboundTotalArea(null);
               statisticsMonthManufactured.setOutboundAmount(null);
               statisticsMonthManufactured.setOutboundAmountExcludingVat(null);
               statisticsMonthManufactured.setReturnTotalQuantity(null);
               statisticsMonthManufactured.setReturnTotalWeight(null);
               statisticsMonthManufactured.setReturnTotalLength(null);
               statisticsMonthManufactured.setReturnTotalArea(null);
               statisticsMonthManufactured.setReturnAmount(null);
               statisticsMonthManufactured.setReturnAmountExcludingVat(null);
               statisticsMonthManufactured.setEndMonthTotalQuantity(null);
               statisticsMonthManufactured.setEndMonthTotalWeight(null);
               statisticsMonthManufactured.setEndMonthTotalLength(null);
               statisticsMonthManufactured.setEndMonthTotalArea(null);
               statisticsMonthManufactured.setEndMonthAmount(null);
               statisticsMonthManufactured.setEndMonthAmountExcludingVat(null);
               statisticsMonthManufactured.setMonthStr(nextMonth);
               statisticsMonthManufactured.setId(null);
               statisticsMonthManufactured.setCreateTime(null);
               this.statisticsMonthManufacturedMapper.insert(statisticsMonthManufactured);
            }
         }
      }
   }

   @Override
   public List<StatisticsMonthManufacturedDTO> statistics(QueryStatisticsMonthManufacturedDTOParam param) {
      List<StatisticsMonthManufactured> list = this.statisticsMonthManufacturedMapper.list(param);
      return this.convertDto(list);
   }

   @Override
   public StatisticsMonthManufacturedCountDTO statisticsCount(QueryStatisticsMonthManufacturedDTOParam param) {
      return this.statisticsMonthManufacturedMapper.statisticsCount(param);
   }

   private List<StatisticsMonthManufacturedDTO> convertDto(List<StatisticsMonthManufactured> statisticsMonthManufactureds) {
      if (CollectionUtil.isEmpty(statisticsMonthManufactureds)) {
         return new ArrayList<>();
      }

      List<StatisticsMonthManufacturedDTO> statisticsMonthManufacturedDTOS = new ArrayList<>();

      for (StatisticsMonthManufactured statisticsMonthManufactured : statisticsMonthManufactureds) {
         StatisticsMonthManufacturedDTO statisticsMonthManufacturedDTO = BeanUtil.toBean(statisticsMonthManufactured, StatisticsMonthManufacturedDTO.class);
         statisticsMonthManufacturedDTOS.add(statisticsMonthManufacturedDTO);
      }

      return statisticsMonthManufacturedDTOS;
   }
}
