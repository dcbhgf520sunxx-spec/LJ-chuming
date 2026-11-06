package com.hzchum.scim.wms.core.service.impl.wmsReport;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjust;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficit;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import com.hzchum.scim.wms.core.api.service.wmsReport.WmsClosingTimeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ConvertService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveMaterialService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsDeficitService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusService;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.WmsClosingTimeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WmsClosingTimeServiceImpl extends ServiceImpl<WmsClosingTimeMapper, WmsClosingTime> implements WmsClosingTimeService {
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   InboundMapper inboundMapper;
   @Resource
   ReturnMapper returnMapper;
   @Resource
   RejectMapper rejectMapper;
   @Resource
   WmsDeficitService wmsDeficitService;
   @Resource
   WmsAdjustService wmsAdjustService;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   WmsSurplusService wmsSurplusService;
   @Resource
   ConvertService convertService;
   @Resource
   TransferService transfersService;
   @Resource
   MoveMaterialService moveMaterialService;

   @Override
   public Boolean checkBoolWmsClosing() {
      Integer integer = this.outboundMapper
         .selectCount(
            (Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>()
               .in(
                  Outbound::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      Integer integer1 = this.inboundMapper
         .selectCount(
            (Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>()
               .in(
                  Inbound::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      Integer integer2 = this.returnMapper
         .selectCount(
            (Wrapper<Return>)new LambdaQueryWrapper<Return>()
               .in(
                  Return::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      Integer integer3 = this.rejectMapper
         .selectCount(
            (Wrapper<Reject>)new LambdaQueryWrapper<Reject>()
               .in(
                  Reject::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      int count = this.wmsDeficitService
         .count(
            (Wrapper<WmsDeficit>)new LambdaQueryWrapper<WmsDeficit>()
               .in(
                  WmsDeficit::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      int count2 = this.wmsAdjustService
         .count(
            (Wrapper<WmsAdjust>)new LambdaQueryWrapper<WmsAdjust>()
               .in(
                  WmsAdjust::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      int count1 = this.wmsSurplusService
         .count(
            (Wrapper<WmsSurplus>)new LambdaQueryWrapper<WmsSurplus>()
               .in(
                  WmsSurplus::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      int count3 = this.transfersService
         .count(
            (Wrapper<Transfer>)new LambdaQueryWrapper<Transfer>()
               .in(
                  Transfer::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      int count4 = this.moveMaterialService
         .count(
            (Wrapper<MoveMaterial>)new LambdaQueryWrapper<MoveMaterial>()
               .in(
                  MoveMaterial::getReviewStatus,
                  ReviewStatusEnum.UN_REVIEWED.getType(),
                  ReviewStatusEnum.AUDITING.getType(),
                  ReviewStatusEnum.NOT_SUBMITTED.getType()
               )
         );
      int sum = integer + integer1 + integer2 + integer3 + count + count2 + count1 + count3 + count4;
      Preconditions.checkArgument(sum == 0, "存在未审核的单据,请审核之后再关账");
      return true;
   }

   @Override
   public Boolean checkInventoryMete(LocalDateTime endTime, Long materialInventoryId, BigDecimal mete) {
      MaterialInventory byId = this.materialInventoryService.getById(materialInventoryId);
      Statistics statistics = this.statisticsMapper.get(byId);
      BigDecimal endMete = BigDecimal.ZERO;
      if (ObjectUtil.isNotEmpty(statistics)) {
         endMete = statistics.getEndMete() != null ? statistics.getEndMete() : BigDecimal.ZERO;
         List<StatisticsInbound> inboundDetailList = this.statisticsInboundMapper
            .selectList(
               (Wrapper<StatisticsInbound>)(new LambdaQueryWrapper<StatisticsInbound>().eq(StatisticsInbound::getStatisticsId, statistics.getId()))
                  .apply(StatisticsInboundMapper.EFFECTIVE_REAL_TIME_SQL + " > {0}", endTime)
            );
         List<StatisticsOutbound> moveOutboundDetails = this.statisticsOutboundMapper
            .selectList(
               (Wrapper<StatisticsOutbound>)(new LambdaQueryWrapper<StatisticsOutbound>().eq(StatisticsOutbound::getStatisticsId, statistics.getId()))
                  .gt(StatisticsOutbound::getOutboundTime, endTime)
            );
         if (CollectionUtil.isNotEmpty(inboundDetailList)) {
            BigDecimal inboundDetailMeteReduce = inboundDetailList.stream()
               .filter(inboundDetail -> inboundDetail.getMete() != null)
               .map(StatisticsInbound::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endMete = endMete.subtract(inboundDetailMeteReduce);
         }

         if (CollectionUtil.isNotEmpty(moveOutboundDetails)) {
            BigDecimal outboundDetailMeteReduce = moveOutboundDetails.stream()
               .filter(moveOutboundDetail -> moveOutboundDetail.getMete() != null)
               .map(StatisticsOutbound::getMete)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            endMete = endMete.add(outboundDetailMeteReduce);
         }
      }

      Preconditions.checkArgument(mete.compareTo(endMete) <= 0, byId.getClassifyName() + "当前操作核算量大于当前节点实际库存量,当前可操作核算量为" + endMete);
      return true;
   }
}
