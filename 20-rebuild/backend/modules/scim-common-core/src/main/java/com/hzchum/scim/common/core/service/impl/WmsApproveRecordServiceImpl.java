package com.hzchum.scim.common.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveFlowStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveSourceEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.InformTypeEnum;
import com.hzchum.scim.common.core.api.enums.ModuleTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReadStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersionsFlow;
import com.hzchum.scim.common.core.api.pojo._do.WmsInformMsg;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import com.hzchum.scim.common.core.api.pojo.export.ApproveRecordDetailExportDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateVersionsFlowService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateVersionsService;
import com.hzchum.scim.common.core.api.service.WmsInformMsgService;
import com.hzchum.scim.common.core.api.utils.ComponentNameUtils;
import com.hzchum.scim.common.core.mapper.WmsApproveRecordDetailMapper;
import com.hzchum.scim.common.core.mapper.WmsApproveRecordMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.ApproveMesssagePushDingdingUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.ApprovePushDTO;
import com.hzchum.scim.system.core.api.service.UserService;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsApproveRecordServiceImpl extends ServiceImpl<WmsApproveRecordMapper, WmsApproveRecord> implements WmsApproveRecordService {
   @Resource
   private WmsApproveRecordDetailMapper wmsApproveRecordDetailMapper;
   @Resource
   private WmsApproveTemplateService wmsApproveTemplateService;
   @Resource
   private UserService userService;
   @Resource
   private WmsApproveRecordMapper wmsApproveRecordMapper;
   @Resource
   private WmsInformMsgService wmsInformMsgService;
   @Resource
   private WmsApproveTemplateVersionsFlowService wmsApproveTemplateVersionsFlowService;
   @Resource
   private WmsApproveTemplateVersionsService wmsApproveTemplateVersionsService;
   @Resource
   private RedisTemplate redisTemplate;
   @Value("${server.port}")
   private Integer port;
   @Resource
   private ServerProperties serverProperties;
   @Resource
   private ApproveMesssagePushDingdingUtil pushUtil;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean commonApproveStep(Long id, Integer decision, String opinion, String serialNumber, String jsonData) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordMapper
         .selectOne((Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getSerialNumber, serialNumber));
      User user = this.userService.getById(wmsApproveRecord.getApplicantId());
      NameInfo applicationUser = NameInfo.builder().id(user.getId()).name(user.getName()).build();
      List<WmsApproveRecordDetail> wmsApproveRecordDetails = this.wmsApproveRecordDetailMapper
         .selectList(
            (Wrapper<WmsApproveRecordDetail>)((new LambdaQueryWrapper<WmsApproveRecordDetail>()
                     .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, serialNumber))
                  .eq(WmsApproveRecordDetail::getApproveSource, ApproveSourceEnum.SYSTEM.getType()))
               .orderByAsc(WmsApproveRecordDetail::getId)
         );
      List<WmsApproveRecordDetail> wmsApproveRecordDetailList = wmsApproveRecordDetails.stream()
         .filter(w -> w.getDecision().equals(CheckStatusEnum.PENDING.getType()) && w.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()))
         .collect(Collectors.toList());
      WmsApproveRecordDetail wmsApproveRecordDetailNow = null;
      wmsApproveRecordDetailNow = wmsApproveRecordDetailList.stream().filter(w -> ObjectUtil.isEmpty(w.getCheckUserId())).findAny().orElse(null);
      if (ObjectUtil.isEmpty(wmsApproveRecordDetailNow)) {
         wmsApproveRecordDetailNow = wmsApproveRecordDetailList.stream().filter(w -> w.getCheckUserId().equals(currentUser.getId())).findAny().orElse(null);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecordDetailNow), "该审批流程未存在或已被审批，请刷新页面重试");
      }

      if (ObjectUtil.isEmpty(wmsApproveRecordDetailNow.getCheckUserId())) {
         wmsApproveRecordDetailNow.setCheckUserId(currentUser.getId());
      }

      wmsApproveRecordDetailNow.setApproveTime(LocalDateTime.now());
      wmsApproveRecordDetailNow.setDecision(decision);
      wmsApproveRecordDetailNow.setOpinion(opinion);
      wmsApproveRecordDetailNow.setStatus(ApproveRecordStatusEnum.END.getType());
      wmsApproveRecordDetailNow.setJsonData(jsonData);
      int i = this.wmsApproveRecordDetailMapper.updateById(wmsApproveRecordDetailNow);
      Preconditions.checkArgument(i == 1, "审批失败");
      Integer flowTypeNow = wmsApproveRecordDetailNow.getFlowType();
      if (flowTypeNow.equals(ApproveTemplateVersionsFlowEnum.OR_SIGN.getType())) {
         this.wmsApproveRecordDetailMapper
            .update(
               null,
               (Wrapper<WmsApproveRecordDetail>)((new LambdaUpdateWrapper<WmsApproveRecordDetail>()
                        .set(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.END.getType()))
                     .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, serialNumber))
                  .eq(WmsApproveRecordDetail::getFlowId, wmsApproveRecordDetailNow.getFlowId())
            );
      }

      if (decision.equals(CheckStatusEnum.FAIL.getType())) {
         this.wmsApproveRecordMapper
            .update(
               null,
               (((((((new LambdaUpdateWrapper<WmsApproveRecord>()
                                       .eq(WmsApproveRecord::getSerialNumber, wmsApproveRecordDetailNow.getApproveRecordSerialNumber()))
                                    .set(WmsApproveRecord::getLastDetailId, wmsApproveRecordDetailNow.getId()))
                                 .set(WmsApproveRecord::getLastApproverId, wmsApproveRecordDetailNow.getCheckUserId()))
                              .set(WmsApproveRecord::getLastApprovalTime, LocalDateTime.now()))
                           .set(WmsApproveRecord::getEndTime, LocalDateTime.now()))
                        .set(WmsApproveRecord::getStatus, ApproveRecordStatusEnum.END.getType()))
                     .set(WmsApproveRecord::getReviewStatus, decision))
                  .set(ApproveProcessTypeEnumV2.boolRewrite(wmsApproveRecord.getApproveProcessType()), WmsApproveRecord::getBoolRewrite, true)
            );
         WmsApproveRecordDetail wmsApproveRecordDetail = new WmsApproveRecordDetail();
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
         this.wmsApproveRecordDetailMapper
            .update(
               wmsApproveRecordDetail,
               (Wrapper<WmsApproveRecordDetail>)new LambdaQueryWrapper<WmsApproveRecordDetail>()
                  .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecordDetailNow.getApproveRecordSerialNumber())
            );
         String content = currentUser.getName()
            + "审批驳回了【"
            + ApproveProcessTypeEnumV2.getName(wmsApproveRecordDetailNow.getApproveProcessType())
            + "】申请("
            + wmsApproveRecord.getDataSerialNumber()
            + ")。请及时查看！";
         this.createMsg(applicationUser, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
         return true;
      }

      WmsApproveRecordDetail finalWmsApproveRecordDetailNow = wmsApproveRecordDetailNow;
      if (flowTypeNow.equals(ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType())) {
         List<WmsApproveRecordDetail> collect = wmsApproveRecordDetails.stream()
            .filter(
               w -> ObjectUtil.isNotEmpty(w.getFlowId())
                  && w.getFlowId().equals(finalWmsApproveRecordDetailNow.getFlowId())
                  && w.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType())
                  && w.getDecision().equals(CheckStatusEnum.PENDING.getType())
                  && w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType())
                  && !w.getId().equals(finalWmsApproveRecordDetailNow.getId())
            )
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(collect)) {
            return false;
         }
      }

      List<WmsApproveRecordDetail> wmsApproveRecordDetailsNext = wmsApproveRecordDetails.stream()
         .filter(
            w -> ObjectUtil.isNotEmpty(w.getFlowId())
               && w.getId() > finalWmsApproveRecordDetailNow.getId()
               && !w.getFlowId().equals(finalWmsApproveRecordDetailNow.getFlowId())
         )
         .sorted(Comparator.comparing(WmsApproveRecordDetail::getId))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(wmsApproveRecordDetailsNext)) {
         this.wmsApproveRecordMapper
            .update(
               null,
               (Wrapper<WmsApproveRecord>)((((((new LambdaUpdateWrapper<WmsApproveRecord>()
                                    .eq(WmsApproveRecord::getSerialNumber, wmsApproveRecordDetailNow.getApproveRecordSerialNumber()))
                                 .set(WmsApproveRecord::getLastDetailId, wmsApproveRecordDetailNow.getId()))
                              .set(WmsApproveRecord::getLastApproverId, wmsApproveRecordDetailNow.getCheckUserId()))
                           .set(WmsApproveRecord::getLastApprovalTime, LocalDateTime.now()))
                        .set(WmsApproveRecord::getEndTime, LocalDateTime.now()))
                     .set(WmsApproveRecord::getStatus, ApproveRecordStatusEnum.END.getType()))
                  .set(WmsApproveRecord::getReviewStatus, decision)
            );
         String content = "【"
            + ApproveProcessTypeEnumV2.getName(wmsApproveRecordDetailNow.getApproveProcessType())
            + "】申请("
            + wmsApproveRecord.getDataSerialNumber()
            + ")已全部审批通过。请及时查看！";
         this.createMsg(applicationUser, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
         return true;
      }

      WmsApproveRecordDetail wmsApproveRecordDetail = wmsApproveRecordDetailsNext.get(0);
      List<WmsApproveRecordDetail> collect = wmsApproveRecordDetails.stream()
         .filter(w -> ObjectUtil.isNotEmpty(w.getFlowId()) && w.getFlowId().equals(wmsApproveRecordDetail.getFlowId()))
         .collect(Collectors.toList());
      this.pushUtil.sendMessage(null, collect, false, wmsApproveRecord.getId());
      Integer flowTypeNext = collect.get(0).getFlowType();
      collect.forEach(c -> c.setArrivalTime(LocalDateTime.now()));
      Boolean result = false;
      switch (ApproveTemplateVersionsFlowEnum.selectType(flowTypeNext)) {
         case COPY_SEND:
            WmsApproveRecordDetail wmsApproveRecordDetailMax = collect.stream().max(Comparator.comparing(WmsApproveRecordDetail::getId)).orElse(null);
            List<WmsApproveRecordDetail> wmsApproveRecordDetailsNoCopySend = wmsApproveRecordDetails.stream()
               .filter(
                  w -> w.getId() > wmsApproveRecordDetailMax.getId()
                     && ObjectUtil.isNotEmpty(w.getFlowId())
                     && !w.getFlowId().equals(wmsApproveRecordDetailMax.getFlowId())
                     && !w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType())
               )
               .collect(Collectors.toList());
            String content = "";
            if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailsNoCopySend)) {
               content = currentUser.getName()
                  + "审批通过了【"
                  + ApproveProcessTypeEnumV2.getName(wmsApproveRecord.getApproveProcessType())
                  + "】申请("
                  + wmsApproveRecord.getDataSerialNumber()
                  + ")，已流转至下一道审批。请及时查看！";
            } else {
               content = "【"
                  + ApproveProcessTypeEnumV2.getName(wmsApproveRecord.getApproveProcessType())
                  + "】申请("
                  + wmsApproveRecord.getDataSerialNumber()
                  + ")已全部审批通过。请及时查看！";
            }

            result = this.executeCopySend(collect, wmsApproveRecordDetails, wmsApproveRecord, content);
            break;
         case ALL_SIGN:
            result = this.executeAllSign(collect, wmsApproveRecord);
            break;
         case A_SIGN:
            result = this.executeAAndOrSign(collect, wmsApproveRecord);
            break;
         case OR_SIGN:
            result = this.executeAAndOrSign(collect, wmsApproveRecord);
            break;
         default:
            Preconditions.checkArgument(false, "未知状态");
      }

      if (result) {
         this.wmsApproveRecordMapper
            .update(
               null,
               (Wrapper<WmsApproveRecord>)((((((new LambdaUpdateWrapper<WmsApproveRecord>()
                                    .eq(WmsApproveRecord::getSerialNumber, wmsApproveRecordDetailNow.getApproveRecordSerialNumber()))
                                 .set(WmsApproveRecord::getLastDetailId, wmsApproveRecordDetailNow.getId()))
                              .set(WmsApproveRecord::getLastApproverId, wmsApproveRecordDetailNow.getCheckUserId()))
                           .set(WmsApproveRecord::getLastApprovalTime, LocalDateTime.now()))
                        .set(WmsApproveRecord::getEndTime, LocalDateTime.now()))
                     .set(WmsApproveRecord::getStatus, ApproveRecordStatusEnum.END.getType()))
                  .set(WmsApproveRecord::getReviewStatus, decision)
            );
         String content = "【"
            + ApproveProcessTypeEnumV2.getName(wmsApproveRecord.getApproveProcessType())
            + "】申请("
            + wmsApproveRecord.getDataSerialNumber()
            + ")已全部审批通过。请及时查看！";
         this.createMsg(applicationUser, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
      } else {
         this.wmsApproveRecordMapper
            .update(
               null,
               (Wrapper<WmsApproveRecord>)(((new LambdaUpdateWrapper<WmsApproveRecord>()
                           .eq(WmsApproveRecord::getSerialNumber, wmsApproveRecordDetailNow.getApproveRecordSerialNumber()))
                        .set(WmsApproveRecord::getLastDetailId, wmsApproveRecordDetailNow.getId()))
                     .set(WmsApproveRecord::getLastApproverId, wmsApproveRecordDetailNow.getCheckUserId()))
                  .set(WmsApproveRecord::getLastApprovalTime, LocalDateTime.now())
            );
      }

      return result;
   }

   private Boolean executeAAndOrSign(List<WmsApproveRecordDetail> collect, WmsApproveRecord wmsApproveRecord) {
      for (WmsApproveRecordDetail wmsApproveRecordDetail : collect) {
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         int i = this.wmsApproveRecordDetailMapper.updateById(wmsApproveRecordDetail);
         Preconditions.checkArgument(i == 1, "开启单签或者或签流程失败");
         String content = "您有一条新的待审核订单(" + wmsApproveRecord.getDataSerialNumber() + ")，请及时处理！";
         User user = this.userService.getById(wmsApproveRecordDetail.getCheckUserId());
         NameInfo nameInfo = NameInfo.builder().id(user.getId()).name(user.getName()).build();
         this.createMsg(nameInfo, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
      }

      return false;
   }

   private Boolean executeAllSign(List<WmsApproveRecordDetail> collect, WmsApproveRecord wmsApproveRecord) {
      for (WmsApproveRecordDetail wmsApproveRecordDetail : collect) {
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         int i = this.wmsApproveRecordDetailMapper.updateById(wmsApproveRecordDetail);
         Preconditions.checkArgument(i == 1, "开启会签流程失败");
         String content = "您有一条新的待审核订单(" + wmsApproveRecord.getSerialNumber() + ")，请及时处理！";
         User user = this.userService.getById(wmsApproveRecordDetail.getCheckUserId());
         NameInfo nameInfo = NameInfo.builder().id(user.getId()).name(user.getName()).build();
         this.createMsg(nameInfo, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
      }

      return false;
   }

   private Boolean executeCopySend(
      List<WmsApproveRecordDetail> collect, List<WmsApproveRecordDetail> wmsApproveRecordDetails, WmsApproveRecord wmsApproveRecord, String content
   ) {
      for (WmsApproveRecordDetail wmsApproveRecordDetail : collect) {
         wmsApproveRecordDetail.setDecision(CheckStatusEnum.PASS.getType());
         wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
         wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
         this.wmsApproveRecordDetailMapper.updateById(wmsApproveRecordDetail);
         User user = this.userService.getById(wmsApproveRecordDetail.getCheckUserId());
         NameInfo nameInfo = NameInfo.builder().id(user.getId()).name(user.getName()).build();
         this.createMsg(nameInfo, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
      }

      WmsApproveRecordDetail wmsApproveRecordDetailNow = collect.get(0);
      List<WmsApproveRecordDetail> wmsApproveRecordDetailsNext = wmsApproveRecordDetails.stream()
         .filter(w -> w.getId() > wmsApproveRecordDetailNow.getId() && !w.getFlowId().equals(wmsApproveRecordDetailNow.getFlowId()))
         .sorted(Comparator.comparing(WmsApproveRecordDetail::getId))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(wmsApproveRecordDetailsNext)) {
         return true;
      }

      WmsApproveRecordDetail wmsApproveRecordDetail = wmsApproveRecordDetailsNext.get(0);
      List<WmsApproveRecordDetail> wmsApproveRecordDetailList = wmsApproveRecordDetails.stream()
         .filter(w -> ObjectUtil.isNotEmpty(w.getFlowId()) && w.getFlowId().equals(wmsApproveRecordDetail.getFlowId()))
         .collect(Collectors.toList());
      Integer flowType = wmsApproveRecordDetailList.get(0).getFlowType();
      switch (ApproveTemplateVersionsFlowEnum.selectType(flowType)) {
         case COPY_SEND:
            return this.executeCopySend(wmsApproveRecordDetailList, wmsApproveRecordDetails, wmsApproveRecord, content);
         case ALL_SIGN:
            return this.executeAllSign(wmsApproveRecordDetailList, wmsApproveRecord);
         case A_SIGN:
            return this.executeAAndOrSign(wmsApproveRecordDetailList, wmsApproveRecord);
         case OR_SIGN:
            return this.executeAAndOrSign(wmsApproveRecordDetailList, wmsApproveRecord);
         default:
            Preconditions.checkArgument(false, "未知状态");
            return false;
      }
   }

   @Override
   public WmsApproveRecord createRecord(
      Long dataId,
      String dataSerialNumber,
      Integer approveProcessType,
      String cause,
      WmsApproveRecordDetail wmsApproveRecordDetailFront,
      String jsonData,
      Boolean mustCheck,
      MountMessageDTO mountMessageDTO,
      String subjoinMsg,
      String classifyOne
   ) {
      String componentName = ComponentNameUtils.getComponentName(approveProcessType, mountMessageDTO);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<WmsApproveTemplateVersionsFlow> wmsApproveTemplateVersionsFlows = this.wmsApproveTemplateService
         .getWmsApproveTemplateVersionsFlows(approveProcessType, null, mountMessageDTO);
      if (mustCheck) {
         if (CollectionUtils.isEmpty(wmsApproveTemplateVersionsFlows) && ObjectUtil.isEmpty(wmsApproveRecordDetailFront)) {
            Preconditions.checkArgument(false, "未配置审批流程信息，请先配置审批流程");
         }

         if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlows)) {
            List<WmsApproveTemplateVersionsFlow> noCopyList = wmsApproveTemplateVersionsFlows.stream()
               .filter(w -> !w.getType().equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType()))
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(noCopyList), "配置的流程中仅为抄送，请配置至少一人审批");
         }
      }

      WmsApproveTemplateVersions wmsApproveTemplateVersions = null;
      if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlows)) {
         wmsApproveTemplateVersions = this.wmsApproveTemplateVersionsService.getById(wmsApproveTemplateVersionsFlows.get(0).getApproveVersionsId());
      }

      WmsApproveTemplateDTO wmsApproveTemplateDTO = new WmsApproveTemplateDTO();

      for (ApproveProcessTypeEnumV2 value : ApproveProcessTypeEnumV2.values()) {
         if (value.getType().equals(approveProcessType)) {
            wmsApproveTemplateDTO.setModuleType(value.getModuleType());
            wmsApproveTemplateDTO.setFunctionType(value.getFunctionType());
            wmsApproveTemplateDTO.setApproveProcessType(value.getType());
            wmsApproveTemplateDTO.setName(value.getName());
            wmsApproveTemplateDTO.setModuleName(value.getModuleTypeName());
         }
      }

      WmsApproveRecord wmsApproveRecord = new WmsApproveRecord();
      wmsApproveRecord.setCreateTime(LocalDateTime.now());
      if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlows)) {
         wmsApproveRecord.setApproveVersionsId(wmsApproveTemplateVersionsFlows.get(0).getApproveVersionsId());
      }

      wmsApproveRecord.setModuleType(wmsApproveTemplateDTO.getModuleType());
      wmsApproveRecord.setFunctionType(wmsApproveTemplateDTO.getFunctionType());
      wmsApproveRecord.setApproveProcessType(wmsApproveTemplateDTO.getApproveProcessType());
      wmsApproveRecord.setDataId(dataId);
      wmsApproveRecord.setDataSerialNumber(dataSerialNumber);
      wmsApproveRecord.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      wmsApproveRecord.setComponentName(componentName);
      wmsApproveRecord.setSubjoinMsg(subjoinMsg);
      wmsApproveRecord.setClassifyOne(classifyOne);
      wmsApproveRecord.setApproveSource(ApproveSourceEnum.SYSTEM.getType());
      String serialNumber = "";

      List<WmsApproveRecord> wmsApproveRecords;
      do {
         serialNumber = this.createApproveSerialNumber("wms_approve_flow_operation");
         wmsApproveRecords = this.wmsApproveRecordMapper
            .selectList((Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getSerialNumber, serialNumber));
      } while (!CollectionUtils.isEmpty(wmsApproveRecords));

      wmsApproveRecord.setSerialNumber(serialNumber);
      wmsApproveRecord.setStartTime(LocalDateTime.now());
      wmsApproveRecord.setApplicantId(currentUser.getId());
      Preconditions.checkArgument(currentUser.getDepartment() != null, "当前用户不存在部门");
      wmsApproveRecord.setDepartmentId(currentUser.getDepartment().getId());
      wmsApproveRecord.setCause(cause);
      wmsApproveRecord.setLastApprovalTime(LocalDateTime.now());
      wmsApproveRecord.setLastApproverId(currentUser.getId());
      WmsApproveRecordDetail wmsApproveRecordDetailApply = new WmsApproveRecordDetail();
      wmsApproveRecordDetailApply.setApproveRecordSerialNumber(wmsApproveRecord.getSerialNumber());
      wmsApproveRecordDetailApply.setCreateTime(LocalDateTime.now());
      wmsApproveRecordDetailApply.setArrivalTime(LocalDateTime.now());
      wmsApproveRecordDetailApply.setDataId(dataId);
      wmsApproveRecordDetailApply.setModuleType(wmsApproveTemplateDTO.getModuleType());
      wmsApproveRecordDetailApply.setFunctionType(wmsApproveTemplateDTO.getFunctionType());
      wmsApproveRecordDetailApply.setApproveProcessType(wmsApproveTemplateDTO.getApproveProcessType());
      wmsApproveRecordDetailApply.setFlowType(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType());
      wmsApproveRecordDetailApply.setStatus(ApproveRecordStatusEnum.END.getType());
      wmsApproveRecordDetailApply.setDecision(CheckStatusEnum.PASS.getType());
      wmsApproveRecordDetailApply.setArrivalTime(LocalDateTime.now());
      wmsApproveRecordDetailApply.setApproveTime(LocalDateTime.now());
      wmsApproveRecordDetailApply.setUpdateTime(LocalDateTime.now());
      wmsApproveRecordDetailApply.setCheckUserId(currentUser.getId());
      wmsApproveRecordDetailApply.setApproveSource(wmsApproveRecord.getApproveSource());
      int insert2 = this.wmsApproveRecordDetailMapper.insert(wmsApproveRecordDetailApply);
      Preconditions.checkArgument(insert2 == 1, "添加流程日志失败");
      Integer num = 0;
      if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailFront)) {
         num = num + 1;
         wmsApproveRecordDetailFront.setApproveRecordSerialNumber(wmsApproveRecord.getSerialNumber());
         wmsApproveRecordDetailFront.setArrivalTime(LocalDateTime.now());
         int insert = this.wmsApproveRecordDetailMapper.insert(wmsApproveRecordDetailFront);
         Preconditions.checkArgument(insert == 1, "添加流程日志失败");
      }

      Integer status = ApproveRecordStatusEnum.UNDERWAY.getType();

      for (WmsApproveTemplateVersionsFlow wmsApproveTemplateVersionsFlow : wmsApproveTemplateVersionsFlows) {
         num = num + 1;
         WmsApproveRecordDetail wmsApproveRecordDetail = new WmsApproveRecordDetail();
         wmsApproveRecordDetail.setCreateTime(DateTimeUtils.dateToLocalDateTime(new Date()));
         wmsApproveRecordDetail.setDataId(dataId);
         wmsApproveRecordDetail.setModuleType(wmsApproveTemplateDTO.getModuleType());
         wmsApproveRecordDetail.setFunctionType(wmsApproveTemplateDTO.getFunctionType());
         wmsApproveRecordDetail.setApproveProcessType(wmsApproveTemplateDTO.getApproveProcessType());
         wmsApproveRecordDetail.setApproveVersionsId(ObjectUtil.isNotEmpty(wmsApproveTemplateVersions) ? wmsApproveTemplateVersions.getId() : null);
         wmsApproveRecordDetail.setApproveRecordSerialNumber(wmsApproveRecord.getSerialNumber());
         wmsApproveRecordDetail.setFlowId(wmsApproveTemplateVersionsFlow.getId());
         wmsApproveRecordDetail.setFlowType(wmsApproveTemplateVersionsFlow.getType());
         wmsApproveRecordDetailApply.setApproveSource(wmsApproveRecord.getApproveSource());
         Integer type = wmsApproveTemplateVersionsFlow.getType();
         String userIds = wmsApproveTemplateVersionsFlow.getUserIds();

         for (Long userId : Arrays.stream(userIds.split(",")).map(Long::new).collect(Collectors.toList())) {
            wmsApproveRecordDetail.setCheckUserId(userId);
            if (!userId.equals(0L)) {
               User byId = this.userService.getById(userId);
               NameInfo user = NameInfo.builder().id(byId.getId()).name(byId.getName()).build();
               if (num.equals(1)) {
                  wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
                  wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
                  status = ApproveRecordStatusEnum.UNDERWAY.getType();
                  if (type.equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType())) {
                     wmsApproveRecordDetail.setDecision(CheckStatusEnum.PASS.getType());
                     wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
                     status = ApproveRecordStatusEnum.END.getType();
                     String content = currentUser.getName()
                        + "提交了 【"
                        + ApproveProcessTypeEnumV2.getName(approveProcessType)
                        + "】 申请("
                        + dataSerialNumber
                        + ")。请及时查看!";
                     this.createMsg(user, content, dataId, wmsApproveRecord.getSerialNumber(), componentName);
                  } else {
                     String content = "您有一条新的待审核订单(" + dataSerialNumber + ")，请及时处理！";
                     this.createMsg(user, content, dataId, wmsApproveRecord.getSerialNumber(), componentName);
                  }
               }

               if (status.equals(ApproveRecordStatusEnum.END.getType())) {
                  wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.UNDERWAY.getType());
                  wmsApproveRecordDetail.setArrivalTime(LocalDateTime.now());
                  status = ApproveRecordStatusEnum.UNDERWAY.getType();
                  if (type.equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType())) {
                     wmsApproveRecordDetail.setDecision(CheckStatusEnum.PASS.getType());
                     wmsApproveRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
                     status = ApproveRecordStatusEnum.END.getType();
                     String content = currentUser.getName()
                        + "提交了 【"
                        + ApproveProcessTypeEnumV2.getName(approveProcessType)
                        + "】 申请("
                        + dataSerialNumber
                        + ")。请及时查看!";
                     this.createMsg(user, content, dataId, wmsApproveRecord.getSerialNumber(), componentName);
                  } else {
                     String content = "您有一条新的待审核订单(" + dataSerialNumber + ")，请及时处理！";
                     this.createMsg(user, content, dataId, wmsApproveRecord.getSerialNumber(), componentName);
                  }
               }

               int insert1 = this.wmsApproveRecordDetailMapper.insert(wmsApproveRecordDetail);
               Preconditions.checkArgument(insert1 == 1, "添加流程日志失败");
            }
         }
      }

      wmsApproveRecord.setStatus(status);
      if (status.equals(ApproveRecordStatusEnum.END.getType())
         || CollectionUtils.isEmpty(wmsApproveTemplateVersionsFlows) && ObjectUtil.isEmpty(wmsApproveRecordDetailFront)) {
         wmsApproveRecord.setEndTime(LocalDateTime.now());
         wmsApproveRecord.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         wmsApproveRecord.setStatus(ApproveRecordStatusEnum.END.getType());
         String content = "【"
            + ApproveProcessTypeEnumV2.getName(wmsApproveRecord.getApproveProcessType())
            + "】申请("
            + wmsApproveRecord.getDataSerialNumber()
            + ")已全部审批通过。请及时查看！";
         User user = this.userService.getById(wmsApproveRecord.getApplicantId());
         NameInfo nameInfo = NameInfo.builder().id(user.getId()).name(user.getName()).build();
         this.createMsg(nameInfo, content, wmsApproveRecord.getDataId(), wmsApproveRecord.getSerialNumber(), wmsApproveRecord.getComponentName());
      }

      wmsApproveRecord.setJsonData(jsonData);
      int insert = this.wmsApproveRecordMapper.insert(wmsApproveRecord);
      Preconditions.checkArgument(insert == 1, "添加审批日志主信息失败");
      if (ObjectUtil.isNotEmpty(wmsApproveTemplateVersionsFlows)) {
         ApprovePushDTO approvePushDTO = new ApprovePushDTO();
         approvePushDTO.setApproveRecordSerialNumber(wmsApproveRecordDetailApply.getApproveRecordSerialNumber());
         approvePushDTO.setUserIds(wmsApproveTemplateVersionsFlows.get(0).getUserIds());
         approvePushDTO.setType(wmsApproveTemplateVersionsFlows.get(0).getType());
         approvePushDTO.setApproveProcessName(wmsApproveTemplateDTO.getApproveProcessType());
         approvePushDTO.setApplicantTime(wmsApproveRecord.getStartTime());
         approvePushDTO.setApplicantUser(wmsApproveRecord.getLastApproverId());
         this.pushUtil.sendMessage(approvePushDTO, null, true, wmsApproveRecord.getId());
      }

      return wmsApproveRecord;
   }

   @Override
   public List<WmsApproveRecordDetail> getCheckDataIdList(Integer functionType) {
      Long currentUserId = UserUtil.getCurrentUserId();
      return this.wmsApproveRecordDetailMapper
         .selectList(
            (Wrapper<WmsApproveRecordDetail>)((((new LambdaQueryWrapper<WmsApproveRecordDetail>()
                           .eq(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.UNDERWAY.getType()))
                        .eq(functionType != null, WmsApproveRecordDetail::getFunctionType, functionType))
                     .eq(WmsApproveRecordDetail::getCheckUserId, currentUserId))
                  .ne(WmsApproveRecordDetail::getFlowType, ApproveTemplateVersionsFlowEnum.COPY_SEND.getType()))
               .eq(WmsApproveRecordDetail::getApproveSource, ApproveSourceEnum.SYSTEM.getType())
         );
   }

   @Override
   public WmsApproveRecordFlowDTO getApproveRecordDTO(Long id) {
      if (ObjectUtil.isEmpty(id)) {
         return null;
      }

      List<UserSimpleResponseVO> userAllListVOSystem = this.userService.getUserAllListVO();
      List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllListVO = BeanUtil.copyToList(
         userAllListVOSystem, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO.class
      );
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap = userAllListVO.stream()
         .collect(Collectors.toMap(com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO::getId, Function.identity()));
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志记录未查到Id为:" + id);
      List<WmsApproveRecordDetail> wmsApproveRecordDetails = this.wmsApproveRecordDetailMapper
         .selectList(
            (Wrapper<WmsApproveRecordDetail>)(new LambdaUpdateWrapper<WmsApproveRecordDetail>()
                  .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecord.getSerialNumber()))
               .eq(WmsApproveRecordDetail::getApproveSource, ApproveSourceEnum.SYSTEM.getType())
         );
      return this.getRecordFlowDTO(wmsApproveRecord, wmsApproveRecordDetails, userAllMap);
   }

   public WmsApproveRecordFlowDTO getRecordFlowDTO(
      WmsApproveRecord wmsApproveRecord,
      List<WmsApproveRecordDetail> wmsApproveRecordDetails,
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap
   ) {
      WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = new WmsApproveRecordFlowDTO();
      List<WmsApproveRecordDetail> wmsApproveRecordDetailFlowIdList = wmsApproveRecordDetails.stream()
         .filter(w -> ObjectUtil.isNotEmpty(w.getFlowId()))
         .collect(Collectors.toList());
      TreeSet<WmsApproveRecordDetail> wmsApproveRecordDetailTreeSet = new TreeSet<>(Comparator.comparing(WmsApproveRecordDetail::getFlowId));
      wmsApproveRecordDetailTreeSet.addAll(wmsApproveRecordDetailFlowIdList);
      List<WmsApproveFlowDTO> wmsApproveFlowDTOS = new ArrayList<>();
      List<WmsApproveRecordDetail> wmsApproveRecordDetailsDistinct = new ArrayList<>();
      WmsApproveRecordDetail wmsApproveRecordDetailApply = wmsApproveRecordDetails.stream()
         .filter(w -> w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType()))
         .findAny()
         .orElse(null);
      if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailApply)) {
         wmsApproveRecordDetailsDistinct.add(wmsApproveRecordDetailApply);
      }

      WmsApproveRecordDetail wmsApproveRecordDetailQualityTesting = wmsApproveRecordDetails.stream()
         .filter(w -> w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType()))
         .findAny()
         .orElse(null);
      if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailQualityTesting)) {
         wmsApproveRecordDetailsDistinct.add(wmsApproveRecordDetailQualityTesting);
      }

      if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailTreeSet)) {
         wmsApproveRecordDetailsDistinct.addAll(wmsApproveRecordDetailTreeSet);
      }

      Integer reviewStatus = null;

      for (WmsApproveRecordDetail wmsApproveRecordDetailDistinct : wmsApproveRecordDetailsDistinct) {
         WmsApproveFlowDTO wmsApproveFlowDTO = new WmsApproveFlowDTO();
         wmsApproveFlowDTO.setType(wmsApproveRecordDetailDistinct.getFlowType());
         wmsApproveFlowDTO.setTypeName(ApproveTemplateVersionsFlowEnum.getName(wmsApproveRecordDetailDistinct.getFlowType()));
         List<WmsApproveRecordDetail> recordDetails = new ArrayList<>();
         if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailDistinct.getFlowId())) {
            recordDetails = wmsApproveRecordDetailFlowIdList.stream()
               .filter(w -> w.getFlowId().equals(wmsApproveRecordDetailDistinct.getFlowId()))
               .collect(Collectors.toList());
         } else {
            recordDetails.add(wmsApproveRecordDetailDistinct);
         }

         if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())) {
            reviewStatus = ApproveFlowStatusEnum.PASS.getType();
         } else if (ObjectUtil.isNotEmpty(reviewStatus) && reviewStatus.equals(ApproveFlowStatusEnum.CANCEL.getType())) {
            reviewStatus = ApproveFlowStatusEnum.CANCEL.getType();
         } else {
            List<WmsApproveRecordDetail> noStartList = recordDetails.stream()
               .filter(r -> r.getStatus().equals(ApproveRecordStatusEnum.NO_START.getType()))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(noStartList)) {
               reviewStatus = ApproveFlowStatusEnum.NO_START.getType();
            } else {
               List<WmsApproveRecordDetail> underwayList = recordDetails.stream()
                  .filter(r -> r.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(underwayList)) {
                  reviewStatus = ApproveFlowStatusEnum.UNDERWAY.getType();
               } else {
                  List<WmsApproveRecordDetail> endAndCancelList = recordDetails.stream()
                     .filter(r -> r.getStatus().equals(ApproveRecordStatusEnum.END.getType()) && r.getDecision().equals(CheckStatusEnum.CANCEL.getType()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(endAndCancelList)) {
                     reviewStatus = ApproveFlowStatusEnum.CANCEL.getType();
                  } else {
                     List<WmsApproveRecordDetail> endAndPendingList = recordDetails.stream()
                        .filter(r -> r.getStatus().equals(ApproveRecordStatusEnum.END.getType()) && r.getDecision().equals(CheckStatusEnum.FAIL.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(endAndPendingList)) {
                        reviewStatus = ApproveFlowStatusEnum.FAIL.getType();
                     } else {
                        List<WmsApproveRecordDetail> endAndNoDecisionList = recordDetails.stream()
                           .filter(
                              r -> r.getStatus().equals(ApproveRecordStatusEnum.END.getType()) && r.getDecision().equals(CheckStatusEnum.PENDING.getType())
                           )
                           .collect(Collectors.toList());
                        if (recordDetails.size() == endAndNoDecisionList.size()) {
                           reviewStatus = ApproveFlowStatusEnum.FAIL.getType();
                        } else {
                           List<WmsApproveRecordDetail> endAndPassList = recordDetails.stream()
                              .filter(
                                 r -> r.getStatus().equals(ApproveRecordStatusEnum.END.getType()) && r.getDecision().equals(CheckStatusEnum.PASS.getType())
                              )
                              .collect(Collectors.toList());
                           if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType())
                              && CollectionUtils.isNotEmpty(endAndPassList)) {
                              reviewStatus = ApproveFlowStatusEnum.PASS.getType();
                           } else if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.OR_SIGN.getType())
                              && CollectionUtils.isNotEmpty(endAndPassList)) {
                              reviewStatus = ApproveFlowStatusEnum.PASS.getType();
                           } else if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType())
                              && recordDetails.size() == endAndPassList.size()) {
                              reviewStatus = ApproveFlowStatusEnum.PASS.getType();
                           } else if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.A_SIGN.getType())) {
                              reviewStatus = ApproveFlowStatusEnum.PASS.getType();
                           } else if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType())) {
                              reviewStatus = ApproveFlowStatusEnum.PASS.getType();
                           }
                        }
                     }
                  }
               }
            }
         }

         List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS = new ArrayList<>();

         for (WmsApproveRecordDetail l : recordDetails) {
            WmsApproveRecordDetailDTO wmsApproveRecordDetailDTO = BeanUtil.toBean(l, WmsApproveRecordDetailDTO.class);
            if (ObjectUtil.isNotEmpty(l.getCheckUserId())) {
               com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(l.getCheckUserId());
               wmsApproveRecordDetailDTO.setUserSimpleResponseVOS(userSimpleResponseVO);
            }

            wmsApproveRecordDetailDTOS.add(wmsApproveRecordDetailDTO);
         }

         wmsApproveFlowDTO.setReviewStatus(reviewStatus);
         wmsApproveFlowDTO.setWmsApproveRecordDetailDTOS(wmsApproveRecordDetailDTOS);
         wmsApproveFlowDTOS.add(wmsApproveFlowDTO);
      }

      String name = this.getName(wmsApproveRecord.getReviewStatus(), wmsApproveRecord.getApproveProcessType());
      wmsApproveRecordFlowDTO.setId(wmsApproveRecord.getId());
      wmsApproveRecordFlowDTO.setName(name);
      wmsApproveRecordFlowDTO.setWmsApproveFlowDTOS(wmsApproveFlowDTOS);
      return wmsApproveRecordFlowDTO;
   }

   private WmsApproveRecordFlowDTO getOaApproveRecordDTO(Long id) {
      WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = new WmsApproveRecordFlowDTO();
      List<UserSimpleResponseVO> userAllListVOSystem = this.userService.getUserAllListVO();
      List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllListVO = BeanUtil.copyToList(
         userAllListVOSystem, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO.class
      );
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap = userAllListVO.stream()
         .collect(Collectors.toMap(com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO::getId, Function.identity()));
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志记录未查到Id为:" + id);
      List<WmsApproveRecordDetail> wmsApproveRecordDetails = this.wmsApproveRecordDetailMapper
         .selectList(
            (Wrapper<WmsApproveRecordDetail>)new LambdaUpdateWrapper<WmsApproveRecordDetail>()
               .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecord.getSerialNumber())
         );
      List<WmsApproveFlowDTO> wmsApproveFlowDTOS = new ArrayList<>();
      List<WmsApproveRecordDetail> wmsApproveRecordDetailsDistinct = new ArrayList<>();
      WmsApproveRecordDetail wmsApproveRecordDetailApply = wmsApproveRecordDetails.stream()
         .filter(w -> w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType()))
         .findAny()
         .orElse(null);
      if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailApply)) {
         wmsApproveRecordDetailsDistinct.add(wmsApproveRecordDetailApply);
      }

      WmsApproveRecordDetail wmsApproveRecordDetailQualityTesting = wmsApproveRecordDetails.stream()
         .filter(w -> w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.A_SIGN.getType()))
         .findAny()
         .orElse(null);
      if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailQualityTesting)) {
         wmsApproveRecordDetailsDistinct.add(wmsApproveRecordDetailQualityTesting);
      }

      Integer reviewStatus = null;

      for (WmsApproveRecordDetail wmsApproveRecordDetailDistinct : wmsApproveRecordDetailsDistinct) {
         WmsApproveFlowDTO wmsApproveFlowDTO = new WmsApproveFlowDTO();
         wmsApproveFlowDTO.setType(wmsApproveRecordDetailDistinct.getFlowType());
         wmsApproveFlowDTO.setTypeName(ApproveTemplateVersionsFlowEnum.getName(wmsApproveRecordDetailDistinct.getFlowType()));
         List<WmsApproveRecordDetail> recordDetails = new ArrayList<>();
         recordDetails.add(wmsApproveRecordDetailDistinct);
         if (wmsApproveRecordDetailDistinct.getFlowType().equals(ApproveTemplateVersionsFlowEnum.A_SIGN.getType())) {
            reviewStatus = ApproveFlowStatusEnum.PASS.getType();
         }

         List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS = new ArrayList<>();

         for (WmsApproveRecordDetail l : recordDetails) {
            WmsApproveRecordDetailDTO wmsApproveRecordDetailDTO = BeanUtil.toBean(l, WmsApproveRecordDetailDTO.class);
            if (ObjectUtil.isNotEmpty(l.getCheckUserId())) {
               com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(l.getCheckUserId());
               wmsApproveRecordDetailDTO.setUserSimpleResponseVOS(userSimpleResponseVO);
            }

            wmsApproveRecordDetailDTOS.add(wmsApproveRecordDetailDTO);
         }

         wmsApproveFlowDTO.setReviewStatus(reviewStatus);
         wmsApproveFlowDTO.setWmsApproveRecordDetailDTOS(wmsApproveRecordDetailDTOS);
         wmsApproveFlowDTOS.add(wmsApproveFlowDTO);
      }

      wmsApproveRecordFlowDTO.setId(wmsApproveRecord.getId());
      wmsApproveRecordFlowDTO.setName("新增");
      wmsApproveRecordFlowDTO.setWmsApproveFlowDTOS(wmsApproveFlowDTOS);
      return wmsApproveRecordFlowDTO;
   }

   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordMapper.selectById(id);
      if (wmsApproveRecord.getRequestId() == null) {
         List<WmsApproveRecordDetail> wmsApproveRecordDetails = this.wmsApproveRecordDetailMapper
            .selectList(
               (Wrapper<WmsApproveRecordDetail>)((new LambdaQueryWrapper<WmsApproveRecordDetail>()
                        .eq(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.UNDERWAY.getType()))
                     .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecord.getSerialNumber()))
                  .eq(WmsApproveRecordDetail::getApproveSource, ApproveSourceEnum.SYSTEM.getType())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(wmsApproveRecordDetails), "该审批已完成或未存在审批信息，撤销失败");
         List<Long> ids = wmsApproveRecordDetails.stream().map(WmsApproveRecordDetail::getId).collect(Collectors.toList());
         this.wmsApproveRecordDetailMapper
            .update(
               null,
               (Wrapper<WmsApproveRecordDetail>)((new LambdaUpdateWrapper<WmsApproveRecordDetail>().in(WmsApproveRecordDetail::getId, ids))
                     .set(WmsApproveRecordDetail::getDecision, ReviewStatusEnum.CANCEL.getType()))
                  .set(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.END.getType())
            );
      }

      wmsApproveRecord.setStatus(ApproveRecordStatusEnum.END.getType());
      wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      wmsApproveRecord.setLastApproverId(currentUser.getId());
      wmsApproveRecord.setLastApprovalTime(LocalDateTime.now());
      if (ApproveProcessTypeEnumV2.boolRewrite(wmsApproveRecord.getApproveProcessType())) {
         wmsApproveRecord.setBoolRewrite(true);
      }

      int i = this.wmsApproveRecordMapper.updateById(wmsApproveRecord);
      return i == 1;
   }

   @Override
   public PageVO<WmsApproveRecordDTO> getList(
      WmsApproveRecordDTOParam wmsApproveRecordDTOParam, Integer pageNumber, Integer pageSize, List<String> sort, Integer facility
   ) {
      List<WmsApproveRecordDTO> returnApproveRecordDTOS = new ArrayList<>();
      List<UserSimpleResponseVO> userSimpleResponseVOList = this.userService.getUserAllListVO();
      List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllListVO = BeanUtil.copyToList(
         userSimpleResponseVOList, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO.class
      );
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap = userAllListVO.stream()
         .collect(Collectors.toMap(com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO::getId, Function.identity()));
      Long currentUserId = UserUtil.getCurrentUserId();
      String s = StringUtils.analyzeSortConditions(sort);
      Page<WmsApproveRecordDTO> wmsApproveRecordDTOPage = PageHelper.startPage(pageNumber, pageSize, s);
      List<WmsApproveRecordDTO> wmsApproveRecordDTOS = this.wmsApproveRecordMapper.getList(wmsApproveRecordDTOParam, currentUserId);
      List<WmsApproveRecordDTO> systemApproveRecordDTOS = wmsApproveRecordDTOS.stream()
         .filter(w -> w.getApproveSource().equals(ApproveSourceEnum.SYSTEM.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(systemApproveRecordDTOS)) {
         List<WmsApproveRecordDTO> list = this.systemApproveRecordDTOS(systemApproveRecordDTOS, userAllMap, currentUserId, facility);
         returnApproveRecordDTOS.addAll(list);
      }

      List<WmsApproveRecordDTO> OaApproveRecordDTOS = wmsApproveRecordDTOS.stream()
         .filter(w -> w.getApproveSource().equals(ApproveSourceEnum.OA.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(OaApproveRecordDTOS)) {
         List<WmsApproveRecordDTO> list = this.OaApproveRecordDTOS(OaApproveRecordDTOS, userAllMap, currentUserId);
         returnApproveRecordDTOS.addAll(list);
      }

      returnApproveRecordDTOS = returnApproveRecordDTOS.stream()
         .sorted(Comparator.<WmsApproveRecordDTO, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed())
         .collect(Collectors.toList());
      return new PageVO<>(wmsApproveRecordDTOPage, returnApproveRecordDTOS);
   }

   private List<WmsApproveRecordDTO> systemApproveRecordDTOS(
      List<WmsApproveRecordDTO> systemApproveRecordDTOS,
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap,
      Long currentUserId,
      Integer facility
   ) {
      List<String> serialNumberList = systemApproveRecordDTOS.stream().map(WmsApproveRecord::getSerialNumber).collect(Collectors.toList());
      List<WmsApproveRecordDetail> wmsApproveRecordDetailsAll = this.wmsApproveRecordDetailMapper
         .selectList(
            (Wrapper<WmsApproveRecordDetail>)(new LambdaQueryWrapper<WmsApproveRecordDetail>()
                  .in(WmsApproveRecordDetail::getApproveRecordSerialNumber, serialNumberList))
               .eq(WmsApproveRecordDetail::getApproveSource, ApproveSourceEnum.SYSTEM.getType())
         );
      List<Long> flowIds = wmsApproveRecordDetailsAll.stream()
         .map(WmsApproveRecordDetail::getFlowId)
         .filter(ObjectUtil::isNotEmpty)
         .distinct()
         .collect(Collectors.toList());
      List<WmsApproveTemplateVersionsFlow> wmsApproveTemplateVersionsFlows = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(flowIds)) {
         wmsApproveTemplateVersionsFlows = this.wmsApproveTemplateVersionsFlowService.listByIds(flowIds);
      }

      for (WmsApproveRecordDTO wmsApproveRecordDTO : systemApproveRecordDTOS) {
         wmsApproveRecordDTO.setApplicantUserVO(userAllMap.get(wmsApproveRecordDTO.getApplicantId()));
         wmsApproveRecordDTO.setModuleTypeName(ModuleTypeEnum.getName(wmsApproveRecordDTO.getModuleType()));
         wmsApproveRecordDTO.setApproveProcessTypeName(ApproveProcessTypeEnumV2.getName(wmsApproveRecordDTO.getApproveProcessType()));
         List<WmsApproveRecordDetail> wmsApproveRecordDetails = wmsApproveRecordDetailsAll.stream()
            .filter(w -> w.getApproveRecordSerialNumber().equals(wmsApproveRecordDTO.getSerialNumber()))
            .sorted(Comparator.comparing(WmsApproveRecordDetail::getId))
            .collect(Collectors.toList());
         List<WmsApproveRecordDetail> wmsApproveRecordDetailsUnderway = wmsApproveRecordDetails.stream()
            .filter(w -> w.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()))
            .collect(Collectors.toList());
         WmsApproveFlowDTO wmsApproveFlowDTO = new WmsApproveFlowDTO();
         List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userSimpleResponseVOS = new ArrayList<>();
         Boolean boolCheck = false;
         Boolean boolCancel = false;
         Boolean boolOperation = ApproveProcessTypeEnumV2.boolShowButton(facility, wmsApproveRecordDTO.getApproveProcessType());
         new WmsApproveRecordDetail();
         WmsApproveRecordDetail wmsApproveRecordDetail;
         if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailsUnderway)) {
            if (wmsApproveRecordDTO.getApplicantId().equals(currentUserId)) {
               boolCancel = true;
            }

            WmsApproveRecordDetail wmsApproveRecordDetail1 = wmsApproveRecordDetailsUnderway.stream()
               .filter(w -> ObjectUtil.isNotEmpty(w.getCheckUserId()) && currentUserId.equals(w.getCheckUserId()))
               .findAny()
               .orElse(null);
            if (ObjectUtil.isNotEmpty(wmsApproveRecordDetail1)) {
               boolCheck = true;
            }

            wmsApproveRecordDetail = wmsApproveRecordDetailsUnderway.get(0);
         } else if (ObjectUtil.isNotEmpty(wmsApproveRecordDTO.getLastDetailId())) {
            wmsApproveRecordDetail = wmsApproveRecordDetails.stream()
               .filter(w -> w.getId().equals(wmsApproveRecordDTO.getLastDetailId()))
               .findAny()
               .orElse(null);
         } else {
            wmsApproveRecordDetail = wmsApproveRecordDetails.stream().min(Comparator.comparing(WmsApproveRecordDetail::getId)).orElse(null);
         }

         wmsApproveRecordDTO.setFlowArrivalTime(wmsApproveRecordDetail.getArrivalTime());
         wmsApproveFlowDTO.setType(wmsApproveRecordDetail.getFlowType());
         wmsApproveFlowDTO.setTypeName(ApproveTemplateVersionsFlowEnum.getName(wmsApproveRecordDetail.getFlowType()));
         if (ObjectUtil.isNotEmpty(wmsApproveRecordDetail.getFlowId())) {
            WmsApproveRecordDetail finalWmsApproveRecordDetail = wmsApproveRecordDetail;
            WmsApproveTemplateVersionsFlow byId = wmsApproveTemplateVersionsFlows.stream()
               .filter(w -> w.getId().equals(finalWmsApproveRecordDetail.getFlowId()))
               .findAny()
               .orElse(null);

            for (Long l : Arrays.stream(byId.getUserIds().split(",")).map(Long::new).collect(Collectors.toList())) {
               if (!l.equals(0L)) {
                  com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(l);
                  userSimpleResponseVOS.add(userSimpleResponseVO);
               }
            }
         } else if (ObjectUtil.isNotEmpty(wmsApproveRecordDetail.getCheckUserId())) {
            com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(wmsApproveRecordDetail.getCheckUserId());
            userSimpleResponseVOS.add(userSimpleResponseVO);
         }

         wmsApproveFlowDTO.setUserSimpleResponseVOS(userSimpleResponseVOS);
         wmsApproveRecordDTO.setWmsApproveFlowDTO(wmsApproveFlowDTO);
         wmsApproveRecordDTO.setBoolCheck(boolCheck);
         wmsApproveRecordDTO.setBoolCancel(boolCancel);
         wmsApproveRecordDTO.setBoolOperation(boolOperation);
         if (ObjectUtil.isNotEmpty(wmsApproveRecordDTO.getSubjoinMsg())) {
            List<String> subjoinMsgList = JSONArray.parseArray(wmsApproveRecordDTO.getSubjoinMsg(), String.class);
            wmsApproveRecordDTO.setSubjoinMsgList(subjoinMsgList);
         }
      }

      return systemApproveRecordDTOS;
   }

   private List<WmsApproveRecordDTO> OaApproveRecordDTOS(
      List<WmsApproveRecordDTO> OaApproveRecordDTOS, Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap, Long currentUserId
   ) {
      for (WmsApproveRecordDTO wmsApproveRecordDTO : OaApproveRecordDTOS) {
         wmsApproveRecordDTO.setApplicantUserVO(userAllMap.get(wmsApproveRecordDTO.getApplicantId()));
         wmsApproveRecordDTO.setModuleTypeName(ModuleTypeEnum.getName(wmsApproveRecordDTO.getModuleType()));
         wmsApproveRecordDTO.setApproveProcessTypeName(ApproveProcessTypeEnumV2.getName(wmsApproveRecordDTO.getApproveProcessType()));
         List<WmsApproveRecordDetail> wmsApproveRecordDetailsAll = this.wmsApproveRecordDetailMapper
            .selectList(
               (Wrapper<WmsApproveRecordDetail>)(new LambdaQueryWrapper<WmsApproveRecordDetail>()
                     .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecordDTO.getSerialNumber()))
                  .orderByAsc(WmsApproveRecordDetail::getId)
            );
         List<WmsApproveRecordDetail> wmsApproveRecordDetailsUnderway = wmsApproveRecordDetailsAll.stream()
            .filter(w -> w.getStatus().equals(ApproveRecordStatusEnum.UNDERWAY.getType()))
            .collect(Collectors.toList());
         WmsApproveFlowDTO wmsApproveFlowDTO = new WmsApproveFlowDTO();
         List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userSimpleResponseVOS = new ArrayList<>();
         new WmsApproveRecordDetail();
         WmsApproveRecordDetail wmsApproveRecordDetail;
         if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailsUnderway)) {
            wmsApproveRecordDetail = wmsApproveRecordDetailsUnderway.get(0);
         } else if (ObjectUtil.isNotEmpty(wmsApproveRecordDTO.getLastDetailId())) {
            wmsApproveRecordDetail = wmsApproveRecordDetailsAll.stream()
               .filter(w -> w.getId().equals(wmsApproveRecordDTO.getLastDetailId()))
               .findAny()
               .orElse(null);
         } else {
            wmsApproveRecordDetail = wmsApproveRecordDetailsAll.stream().min(Comparator.comparing(WmsApproveRecordDetail::getId)).orElse(null);
         }

         wmsApproveRecordDTO.setFlowArrivalTime(wmsApproveRecordDetail.getArrivalTime());
         wmsApproveFlowDTO.setType(wmsApproveRecordDetail.getFlowType());
         wmsApproveFlowDTO.setTypeName(ApproveTemplateVersionsFlowEnum.getName(wmsApproveRecordDetail.getFlowType()));
         if (ObjectUtil.isNotEmpty(wmsApproveRecordDetail.getFlowId())) {
            WmsApproveTemplateVersionsFlow byId = this.wmsApproveTemplateVersionsFlowService.getById(wmsApproveRecordDetail.getFlowId());

            for (Long l : Arrays.stream(byId.getUserIds().split(",")).map(Long::new).collect(Collectors.toList())) {
               if (!l.equals(0L)) {
                  com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(l);
                  userSimpleResponseVOS.add(userSimpleResponseVO);
               }
            }
         } else if (ObjectUtil.isNotEmpty(wmsApproveRecordDetail.getCheckUserId())) {
            com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(wmsApproveRecordDetail.getCheckUserId());
            userSimpleResponseVOS.add(userSimpleResponseVO);
         }

         if (wmsApproveRecordDTO.getApplicantId().equals(currentUserId) && wmsApproveRecordDTO.getReviewStatus().equals(ReviewStatusEnum.AUDITING.getType())) {
            wmsApproveRecordDTO.setBoolCancel(true);
         }

         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.getOaApproveRecordDTO(wmsApproveRecordDTO.getId());
         wmsApproveFlowDTO.setUserSimpleResponseVOS(userSimpleResponseVOS);
         wmsApproveRecordDTO.setWmsApproveFlowDTO(wmsApproveFlowDTO);
         wmsApproveRecordDTO.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return OaApproveRecordDTOS;
   }

   @Override
   public Integer getCanCheckCount(List<String> componentNameList) {
      Long currentUserId = UserUtil.getCurrentUserId();
      return this.wmsApproveRecordDetailMapper
         .selectCanCheckCount(
            currentUserId,
            ApproveRecordStatusEnum.UNDERWAY.getType(),
            ApproveTemplateVersionsFlowEnum.COPY_SEND.getType(),
            componentNameList,
            ApproveSourceEnum.SYSTEM.getType()
         );
   }

   @Override
   public Integer getRejectedCanCheckCount(List<String> componentNameList) {
      Long currentUserId = UserUtil.getCurrentUserId();
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = new Date();
      DateTime startTime = DateUtil.beginOfDay(DateUtil.offsetDay(date, -6));
      String startTimeStr = simpleDateFormat.format(startTime);
      return this.baseMapper
         .selectRejectedCanCheckCount(
            ApproveRecordStatusEnum.END.getType(), ReviewStatusEnum.RETURNED.getType(), currentUserId, startTimeStr, componentNameList
         );
   }

   @Override
   public Integer getSubmitAndReview(List<String> componentNameList) {
      Long currentUserId = UserUtil.getCurrentUserId();
      return this.baseMapper.selectSubmitAndReviewCount(ApproveRecordStatusEnum.UNDERWAY.getType(), currentUserId, componentNameList);
   }

   @Override
   public Boolean judgeRewrite(Long id) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordMapper.selectById(id);
      Preconditions.checkArgument(wmsApproveRecord.getBoolRewrite().equals(Boolean.TRUE), "该日志禁止重写，请刷新页面");
      return true;
   }

   @Override
   public List<ApproveRecordDetailExportDTO> getExport(Long id) {
      List<ApproveRecordDetailExportDTO> approveRecordDetailExportDTOS = new ArrayList<>();
      WmsApproveRecordFlowDTO approveRecordDTO = this.getApproveRecordDTO(id);

      for (WmsApproveFlowDTO wmsApproveFlowDTO : approveRecordDTO.getWmsApproveFlowDTOS()) {
         for (WmsApproveRecordDetailDTO wmsApproveRecordDetailDTO : wmsApproveFlowDTO.getWmsApproveRecordDetailDTOS()) {
            ApproveRecordDetailExportDTO approveRecordDetailExportDTO = new ApproveRecordDetailExportDTO();
            approveRecordDetailExportDTO.setFlowTypeName(wmsApproveFlowDTO.getTypeName());
            approveRecordDetailExportDTO.setCheckUserName("/");
            if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailDTO.getUserSimpleResponseVOS())) {
               approveRecordDetailExportDTO.setCheckUserName(wmsApproveRecordDetailDTO.getUserSimpleResponseVOS().getName());
            }

            approveRecordDetailExportDTO.setArrivalTimeStr("/");
            if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailDTO.getArrivalTime())) {
               approveRecordDetailExportDTO.setArrivalTimeStr(
                  wmsApproveRecordDetailDTO.getArrivalTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:ss"))
               );
            }

            approveRecordDetailExportDTO.setApproveTimeStr("/");
            if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailDTO.getApproveTime())) {
               approveRecordDetailExportDTO.setApproveTimeStr(
                  wmsApproveRecordDetailDTO.getApproveTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
               );
            }

            Integer decision = wmsApproveRecordDetailDTO.getDecision();
            approveRecordDetailExportDTO.setDecisionStr(
               decision.equals(CheckStatusEnum.PENDING.getType())
                  ? "/"
                  : (
                     decision.equals(CheckStatusEnum.PASS.getType())
                        ? "通过"
                        : (decision.equals(CheckStatusEnum.FAIL.getType()) ? "驳回" : (decision.equals(CheckStatusEnum.CANCEL.getType()) ? "撤销" : "其他"))
                  )
            );
            approveRecordDetailExportDTO.setOpinion("/");
            if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailDTO.getOpinion())) {
               approveRecordDetailExportDTO.setOpinion(wmsApproveRecordDetailDTO.getOpinion());
            }

            approveRecordDetailExportDTO.setFlowType(wmsApproveRecordDetailDTO.getFlowType());
            if (ObjectUtil.isNotEmpty(wmsApproveRecordDetailDTO.getFlowId())) {
               approveRecordDetailExportDTO.setFlowId(wmsApproveRecordDetailDTO.getFlowId());
            }

            approveRecordDetailExportDTOS.add(approveRecordDetailExportDTO);
         }
      }

      return approveRecordDetailExportDTOS;
   }

   @Override
   public String getSerialNumberById(Long id) {
      WmsApproveRecord wmsApproveRecord = this.getById(id);
      return wmsApproveRecord == null ? "" : wmsApproveRecord.getSerialNumber();
   }

   @Override
   public String getApproveUserInfo(Long approveRecordId, String symbol) {
      if (approveRecordId == null) {
         return "";
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordMapper.selectById(approveRecordId);
      List<WmsApproveRecordDetail> wmsApproveRecordDetails = this.wmsApproveRecordDetailMapper
         .selectList(
            (Wrapper<WmsApproveRecordDetail>)new LambdaQueryWrapper<WmsApproveRecordDetail>()
               .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, wmsApproveRecord.getSerialNumber())
         );
      List<Long> userIds = wmsApproveRecordDetails.stream()
         .sorted(Comparator.comparing(WmsApproveRecordDetail::getId))
         .filter(
            w -> (
                  w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType())
                     || w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.OR_SIGN.getType())
                     || w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.A_SIGN.getType())
                     || w.getFlowType().equals(ApproveTemplateVersionsFlowEnum.QUALITY_TESTING.getType())
               )
               && (w.getDecision().equals(CheckStatusEnum.PASS.getType()) || w.getDecision().equals(CheckStatusEnum.FAIL.getType()))
         )
         .map(WmsApproveRecordDetail::getCheckUserId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(userIds)) {
         return "";
      }

      Map<Long, User> collect = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<String> userNameList = new ArrayList<>();

      for (Long userId : userIds) {
         User user = collect.get(userId);
         if (user != null) {
            userNameList.add(user.getName());
         }
      }

      return String.join(symbol, userNameList);
   }

   @Override
   public String createApproveSerialNumber(String tableNameKey) {
      String yyyy_mm_dd = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
      String key = MessageFormat.format("{0}:{1}", tableNameKey, yyyy_mm_dd);
      Long increment = this.redisTemplate.opsForValue().increment(key, 1L);
      if (increment.equals(1L)) {
         this.redisTemplate.expire(key, 24L, TimeUnit.HOURS);
      }

      String datetime = new SimpleDateFormat("yyyyMMdd").format(new Date());
      String value = org.apache.commons.lang.StringUtils.leftPad(String.valueOf(increment), 6, "0");
      return MessageFormat.format("{0}{1}", datetime, value);
   }

   private String getName(Integer reviewStatus, Integer ApproveProcessType) {
      String name = "";
      switch (ApproveProcessTypeEnumV2.selectType(ApproveProcessType)) {
         case APPLY_PURCHASE_ADD:
            name = "新增";
            if (reviewStatus.equals(ReviewStatusEnum.CANCEL.getType())) {
               name = "新增撤销";
            }
            break;
         case APPLY_PURCHASE_CANCELLATION:
            name = "作废";
            if (reviewStatus.equals(ReviewStatusEnum.CANCEL.getType())) {
               name = "作废撤销";
            }
            break;
         case PURCHASE_ORDER_ADD:
            name = "采购单新增";
            if (reviewStatus.equals(ReviewStatusEnum.CANCEL.getType())) {
               name = "新增撤销";
            }
            break;
         case PURCHASE_ORDER_CANCELLATION:
            name = "采购单作废";
            if (reviewStatus.equals(ReviewStatusEnum.CANCEL.getType())) {
               name = "作废撤销";
            }
      }

      return name;
   }

   private boolean createMsg(NameInfo user, String content, Long dataId, String approveRecordSerialNumber, String componentName) {
      String url = "http://127.0.0.1:" + this.serverProperties.getPort() + "/socket/push";
      WmsInformMsg wmsInformMsg = WmsInformMsg.builder()
         .headline("审批")
         .userId(user.getId())
         .dataId(dataId)
         .approveRecordSerialNumber(approveRecordSerialNumber)
         .content(content)
         .status(ReadStatusEnum.UNREAD.getType())
         .remark("")
         .componentName(componentName)
         .informType(InformTypeEnum.APPROVE_NOTICE.getType())
         .build();
      wmsInformMsg.setCreateTime(LocalDateTime.now());
      this.wmsInformMsgService.save(wmsInformMsg);
      return true;
   }
}
