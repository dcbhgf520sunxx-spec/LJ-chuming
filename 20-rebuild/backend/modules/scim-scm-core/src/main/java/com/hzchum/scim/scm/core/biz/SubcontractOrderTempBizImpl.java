package com.hzchum.scim.scm.core.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.project.core.api.biz.ProjectSupplierAccountBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderTempBiz;
import com.hzchum.scim.scm.core.api.enums.SubOrderChangeTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrderTemp;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderTempDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderTempAuditDtoParam;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderTempService;
import com.hzchum.scim.scm.core.mapper.SubcontractOrderTempMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcontractOrderTempBizImpl
   extends IBizImpl<SubcontractOrderTempService, SubcontractOrderTempMapper, SubcontractOrderTemp>
   implements SubcontractOrderTempBiz {
   private final AttachmentService attachmentService;
   private final SubcontractOrderService subcontractOrderService;
   private final WmsApproveRecordService approveRecordService;
   private final ProjectSupplierAreaLinkService supplierAreaLinkService;
   private final ProjectSupplierAccountBiz supplierAccountBiz;

   @Override
   public SubcontractOrderTempDTO getTempById(Long tempId) {
      SubcontractOrderTemp orderTemp = this.baseService.getById(tempId);
      Preconditions.checkArgument(orderTemp != null, "审批信息不存在!");
      SubcontractOrderTempDTO orderTempDTO = BeanUtil.copy(orderTemp, SubcontractOrderTempDTO.class);
      orderTempDTO.setAttachmentList(this.attachmentService.listByIds(orderTemp.getAttachmentIds()));
      WmsApproveRecord approveRecord = this.getApproveRecord(tempId, orderTemp.getChangeTypeEnum());
      List<WmsApproveFlowDTO> approveFlowList = this.getApproveFlowList(approveRecord.getId());
      orderTempDTO.setWmsApproveFlowList(approveFlowList);
      return orderTempDTO;
   }

   private List<WmsApproveFlowDTO> getApproveFlowList(Long approveRecordId) {
      WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.approveRecordService.getApproveRecordDTO(approveRecordId);
      return wmsApproveRecordFlowDTO.getWmsApproveFlowDTOS();
   }

   private WmsApproveRecord getApproveRecord(Long tempId, Integer changeTypeEnum) {
      LambdaQueryWrapper<WmsApproveRecord> wrapper = Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getDataId, tempId);
      return this.approveRecordService.getOne(wrapper);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditSubOrderChange(SubcontractOrderTempAuditDtoParam param) {
      SubcontractOrderTemp orderTemp = this.baseService.getById(param.getId());
      Preconditions.checkArgument(orderTemp != null, "审批信息不存在!");
      Preconditions.checkArgument(SubOrderChangeTypeEnum.boolExist(orderTemp.getChangeTypeEnum()), "订单暂存信息有误!");
      WmsApproveRecord wmsApproveRecord = this.getApproveRecord(param.getId(), orderTemp.getChangeTypeEnum());
      Preconditions.checkArgument(wmsApproveRecord != null, "审批记录缺失!");
      Boolean isTrue = this.approveRecordService
         .commonApproveStep(param.getId(), param.getAuditStatusEnum(), param.getRemark(), wmsApproveRecord.getSerialNumber(), null);
      if (isTrue && param.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType())) {
         this.handleAuditSuccess(orderTemp);
      }

      if (param.getAuditStatusEnum().equals(AuditStatusEnum.FAILED.getType())) {
         orderTemp.setAuditStatusEnum(AuditStatusEnum.FAILED.getType());
         orderTemp.setAuditUserId(UserUtil.getCurrentUserId());
         orderTemp.setAuditUserName(UserUtil.getCurrentName());
         orderTemp.setAuditTime(LocalDateTime.now());
         this.baseService.updateById(orderTemp);
      }

      return true;
   }

   @Override
   public void handleAuditSuccess(SubcontractOrderTemp orderTemp) {
      orderTemp.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
      orderTemp.setAuditUserId(UserUtil.getCurrentUserId());
      orderTemp.setAuditUserName(UserUtil.getCurrentName());
      orderTemp.setAuditTime(LocalDateTime.now());
      this.baseService.updateById(orderTemp);
      if (orderTemp.getChangeTypeEnum().equals(SubOrderChangeTypeEnum.ADD.getType())) {
         SubcontractOrder subcontractOrder = BeanUtil.copy(orderTemp, SubcontractOrder.class);
         subcontractOrder.setAuditTypeEnum(AuditStatusEnum.SUCCEED.getType());
         this.subcontractOrderService.save(subcontractOrder);
      }

      if (orderTemp.getChangeTypeEnum().equals(SubOrderChangeTypeEnum.UPDATE.getType())) {
         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderTemp.getOrderId());
         Preconditions.checkArgument(subcontractOrder != null, "原始订单数据丢失!");
         if (!subcontractOrder.getSupplierId().equals(orderTemp.getSupplierId())
            || !subcontractOrder.getSubcontractClassId().equals(orderTemp.getSubcontractClassId())) {
            this.supplierAreaLinkService
               .remove(
                  Wrappers.lambdaQuery(
                     ProjectSupplierAreaLink.builder().subcontractOrderId(subcontractOrder.getId()).supplierId(subcontractOrder.getSupplierId()).build()
                  )
               );
            this.supplierAccountBiz.shutDownAccount(subcontractOrder.getSupplierId());
         }

         BeanUtil.copy(orderTemp, subcontractOrder);
         subcontractOrder.setId(orderTemp.getOrderId());
         this.subcontractOrderService.updateById(subcontractOrder);
      }

      if (orderTemp.getChangeTypeEnum().equals(SubOrderChangeTypeEnum.DEL.getType())) {
         this.supplierAreaLinkService
            .remove(
               Wrappers.lambdaQuery(ProjectSupplierAreaLink.builder().subcontractOrderId(orderTemp.getOrderId()).supplierId(orderTemp.getSupplierId()).build())
            );
         this.supplierAccountBiz.shutDownAccount(orderTemp.getSupplierId());
         this.subcontractOrderService.removeById(orderTemp.getOrderId());
      }
   }

   public SubcontractOrderTempBizImpl(
      final AttachmentService attachmentService,
      final SubcontractOrderService subcontractOrderService,
      final WmsApproveRecordService approveRecordService,
      final ProjectSupplierAreaLinkService supplierAreaLinkService,
      final ProjectSupplierAccountBiz supplierAccountBiz
   ) {
      this.attachmentService = attachmentService;
      this.subcontractOrderService = subcontractOrderService;
      this.approveRecordService = approveRecordService;
      this.supplierAreaLinkService = supplierAreaLinkService;
      this.supplierAccountBiz = supplierAccountBiz;
   }
}
