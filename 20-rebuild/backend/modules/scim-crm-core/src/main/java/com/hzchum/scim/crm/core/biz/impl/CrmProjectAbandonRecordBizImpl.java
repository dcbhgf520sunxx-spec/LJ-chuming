package com.hzchum.scim.crm.core.biz.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectAbandonRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectAbandonRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectAbandonRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectAbandonRecordSaveParam;
import com.hzchum.scim.crm.core.api.service.CrmProjectAbandonRecordService;
import com.hzchum.scim.crm.core.mapper.CrmProjectAbandonRecordMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmProjectAbandonRecordBizImpl
   extends IBizImpl<CrmProjectAbandonRecordService, CrmProjectAbandonRecordMapper, CrmProjectAbandonRecord>
   implements CrmProjectAbandonRecordBiz {
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz;
   @Resource
   private CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;

   @Transactional
   @Override
   public Boolean saveCrmProjectAbandonRecord(CrmProjectAbandonRecordSaveParam copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(copy.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getInformationOperatorUserId().equals(UserUtil.getCurrentUserId()), "您不是该项目的操作人员,不可操作");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "项目备案审核暂未通过不可放弃");
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType()), "项目备案已失效不可放弃"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()), "项目已中标不可放弃"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()),
         "项目备案处于投标状态不可放弃"
      );
      CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecordList = this.crmApplyBusinessBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      Preconditions.checkArgument(
         crmApplyBusinessBiddingRecordList == null
            && crmApplyTechnologyBiddingRecord == null
            && crmApplyDeepDesignBiddingRecord == null
            && crmApplyStructuralDesignBiddingRecord == null,
         "投标存在待审核不可放弃!!!!"
      );
      List<CrmProjectAbandonRecord> crmProjectAbandonRecords = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectAbandonRecord.class)
               .eq(CrmProjectAbandonRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
               .eq(CrmProjectAbandonRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(crmProjectAbandonRecords), "当前项目放弃正在审核中!!!");
      CrmProjectAbandonRecord crmProjectAbandonRecord = BeanUtil.copy(copy, CrmProjectAbandonRecord.class);
      crmProjectAbandonRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
      if (CollectionUtils.isNotEmpty(copy.getAbandonAttachment())) {
         crmProjectAbandonRecord.setAbandonAttachment(
            StrUtil.join(",", copy.getAbandonAttachment().stream().map(AttachmentDTO::getId).collect(Collectors.toList()))
         );
      }

      this.baseService.save(crmProjectAbandonRecord);
      WmsApproveRecord record = this.wmsApproveRecordService
         .createRecord(
            crmProjectAbandonRecord.getId(),
            crmProjectInformationWarehousing.getProjectName(),
            ApproveProcessTypeEnumV2.CRM_ABANDON.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      CrmProjectAbandonRecord abandonRecord = this.baseService.getById(crmProjectAbandonRecord.getId());
      if (record.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
         abandonRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType());
         this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
      }

      abandonRecord.setApproveRecordId(record.getId());
      this.baseService.updateById(abandonRecord);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean projectAbandonApproval(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmProjectAbandonRecord crmProjectAbandonRecord = this.baseService.getById(crmAuditCommonDTO.getDataId());
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmProjectAbandonRecord.getCrmProjectInformationWarehousingId());
      if (result) {
         if (crmAuditCommonDTO.getDecision() == 2) {
            crmProjectAbandonRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            projectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType());
            this.crmProjectInformationWarehousingBiz.updateById(projectInformationWarehousing);
         }

         if (crmAuditCommonDTO.getDecision() == 4) {
            crmProjectAbandonRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.baseService.updateById(crmProjectAbandonRecord);
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean projectAbandonQuash(Long id) {
      CrmProjectAbandonRecord abandonRecord = this.baseService.getById(id);
      Preconditions.checkArgument(abandonRecord != null, "放弃项目记录不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(abandonRecord.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "放弃项目审批记录不存在");
      wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      this.wmsApproveRecordService.updateById(wmsApproveRecord);
      this.baseService.removeById(abandonRecord.getId());
      this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
      return Boolean.TRUE;
   }

   @Override
   public CrmProjectAbandonRecordDetailDTO getCrmProjectAbandonRecordDetail(Long id) {
      CrmProjectAbandonRecord projectAbandonRecord = this.baseService.getById(id);
      Preconditions.checkArgument(projectAbandonRecord != null, "放弃项目申请不存在");
      CrmProjectAbandonRecordDetailDTO crmProjectAbandonRecordDetailDTO = BeanUtil.copy(projectAbandonRecord, CrmProjectAbandonRecordDetailDTO.class);
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(projectAbandonRecord.getCrmProjectInformationWarehousingId());
      crmProjectAbandonRecordDetailDTO.setCrmProjectInformationWarehousingName(projectInformationWarehousing.getProjectName());
      if (StringUtil.isNotBlank(projectAbandonRecord.getAbandonAttachment())) {
         crmProjectAbandonRecordDetailDTO.setAbandonAttachment(this.attachmentService.listByIds(projectAbandonRecord.getAbandonAttachment()));
      }

      return crmProjectAbandonRecordDetailDTO;
   }
}
