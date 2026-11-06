package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsOutboundRemind;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsOutboundRemindDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsOutboundRemindService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MoveOutboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsOutboundRemindMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WmsOutboundRemindServiceImpl extends ServiceImpl<WmsOutboundRemindMapper, WmsOutboundRemind> implements WmsOutboundRemindService {
   @Resource
   private MoveOutboundDetailMapper moveOutboundDetailMapper;
   @Resource
   private ClassificationMapper classificationMapper;
   @Resource
   private ContractProjectService contractProjectService;

   @Override
   public Boolean saveOutboundRemind(Outbound outbound) {
      List<MoveOutboundDetail> detailList = this.moveOutboundDetailMapper
         .selectList((Wrapper<MoveOutboundDetail>)new LambdaQueryWrapper<MoveOutboundDetail>().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      if (CollectionUtils.isEmpty(detailList)) {
         return Boolean.TRUE;
      }

      List<MoveOutboundDetail> details = detailList.stream()
         .filter(e -> e.getIsNeedRemind() != null)
         .filter(MoveOutboundDetail::getIsNeedRemind)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(details)) {
         return Boolean.TRUE;
      }

      Map<Long, String> classifyNameMap = this.classificationMapper
         .selectBatchIds(details.stream().map(MoveOutboundDetail::getClassifyId).distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      List<WmsOutboundRemind> remindList = new ArrayList<>();

      for (MoveOutboundDetail detail : details) {
         WmsOutboundRemind build = WmsOutboundRemind.builder()
            .projectId(detail.getProjectId())
            .outboundId(outbound.getId())
            .outboundSn(outbound.getSerialNumber())
            .content(StrUtil.concat(true, "\"", classifyNameMap.getOrDefault(detail.getClassifyId(), ""), "\"", " 已成功出库。"))
            .applicantId(outbound.getApplicantId())
            .applicantName(outbound.getApplicantName())
            .build();
         remindList.add(build);
      }

      this.saveBatch(remindList);
      return Boolean.TRUE;
   }

   @Override
   public List<WmsOutboundRemindDTO> getRemindList() {
      List<WmsOutboundRemind> remindList = this.list(
         Wrappers.lambdaQuery(WmsOutboundRemind.class)
            .eq(WmsOutboundRemind::getApplicantId, UserUtil.getCurrentUserId())
            .eq(WmsOutboundRemind::getIsCheck, Boolean.FALSE)
            .orderByDesc(WmsOutboundRemind::getId)
      );
      return CollectionUtils.isEmpty(remindList)
         ? new ArrayList<>()
         : remindList.stream()
            .map(
               e -> WmsOutboundRemindDTO.builder()
                  .id(e.getId())
                  .project(this.contractProjectService.getSimpleById(e.getProjectId()))
                  .content(e.getContent())
                  .receipt(
                     BriefIdAndSNDTO.builder().id(e.getOutboundId()).serialNumber(e.getOutboundSn()).receiptType(ReceiptTypeEnum.OUTBOUND.getType()).build()
                  )
                  .build()
            )
            .collect(Collectors.toList());
   }

   @Override
   public Integer getRemindNumbers() {
      return this.count(
         Wrappers.lambdaQuery(WmsOutboundRemind.class)
            .eq(WmsOutboundRemind::getApplicantId, UserUtil.getCurrentUserId())
            .eq(WmsOutboundRemind::getIsCheck, Boolean.FALSE)
      );
   }

   @Override
   public Boolean closeList(List<Long> ids) {
      if (CollectionUtils.isEmpty(ids)) {
         return Boolean.TRUE;
      }

      List<WmsOutboundRemind> updateList = this.list(
         Wrappers.lambdaQuery(WmsOutboundRemind.class).in(WmsOutboundRemind::getId, ids).eq(WmsOutboundRemind::getIsCheck, Boolean.FALSE)
      );
      updateList.forEach(e -> e.setIsCheck(Boolean.TRUE));
      this.updateBatchById(updateList);
      return Boolean.TRUE;
   }
}
