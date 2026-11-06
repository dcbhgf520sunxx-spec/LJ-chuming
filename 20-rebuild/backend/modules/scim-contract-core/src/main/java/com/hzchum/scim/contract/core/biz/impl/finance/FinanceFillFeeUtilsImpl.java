package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.biz.finance.FinanceFillFeeUtils;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class FinanceFillFeeUtilsImpl implements FinanceFillFeeUtils {
   private final ContractAuditLedgerService auditLedgerService;
   private final WmsApproveRecordService approveRecordService;
   private final WmsApproveRecordDetailService approveRecordDetailService;

   @Override
   public Integer addApproveData(Long id, Integer paymentEnum, Integer approveProcessType, Long branchCompanyId, BigDecimal feeAmount, ContractProject project) {
      ContractAuditLedger auditLedger = ContractAuditLedger.builder()
         .paymentEnum(paymentEnum)
         .contractSignBodyId(branchCompanyId)
         .auditType(AuditTypeEnum.EXPENSE_ENTRY_APPROVE.getType())
         .paymentId(String.valueOf(id))
         .projectId(project != null ? String.valueOf(project.getId()) : null)
         .contractNumber(project != null ? project.getSerialNumber() : null)
         .projectManagerId(project != null ? project.getSignerId() : null)
         .filingDate(LocalDateTime.now())
         .initiatorId(UserUtil.getCurrentUserId())
         .applyAmount(feeAmount)
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .build();
      this.auditLedgerService.save(auditLedger);
      WmsApproveRecord record = this.approveRecordService
         .createRecord(auditLedger.getId(), auditLedger.getContractNumber(), approveProcessType, null, null, null, false, null, null, null);
      auditLedger.setApproveRecordId(record.getId());
      if (record.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
         auditLedger.setWrittenById(UserUtil.getCurrentUserId());
         auditLedger.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         auditLedger.setSubmitDate(LocalDateTime.now());
         auditLedger.setApprovalTime(LocalDateTime.now());
         auditLedger.setActuallyPayAmount(feeAmount);
      }

      this.auditLedgerService.updateById(auditLedger);
      return record.getReviewStatus();
   }

   @Override
   public void removeApproveData(Long id, Integer paymentEnum, Integer approveProcessType) {
      ContractAuditLedger auditLedger = this.auditLedgerService
         .getOne(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getAuditType, AuditTypeEnum.EXPENSE_ENTRY_APPROVE.getType())
               .eq(ContractAuditLedger::getPaymentEnum, paymentEnum)
               .eq(ContractAuditLedger::getPaymentId, String.valueOf(id))
         );
      if (auditLedger != null) {
         this.auditLedgerService.removeById(auditLedger.getId());
         this.approveRecordService.removeById(auditLedger.getApproveRecordId());
         this.approveRecordDetailService
            .remove(
               Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
                  .eq(WmsApproveRecordDetail::getApproveProcessType, approveProcessType)
                  .eq(WmsApproveRecordDetail::getDataId, auditLedger.getId())
            );
      }
   }

   public FinanceFillFeeUtilsImpl(
      final ContractAuditLedgerService auditLedgerService,
      final WmsApproveRecordService approveRecordService,
      final WmsApproveRecordDetailService approveRecordDetailService
   ) {
      this.auditLedgerService = auditLedgerService;
      this.approveRecordService = approveRecordService;
      this.approveRecordDetailService = approveRecordDetailService;
   }
}
