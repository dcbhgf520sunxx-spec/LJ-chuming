package com.hzchum.scim.rest.controller.contract.audit;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** Fee detail reads preserve the originating menu and actual workflow participants. */
@Component("contractFeeAuditAccess")
public class ContractFeeAuditAccess {
   @Resource private ContractAuditLedgerService ledgers;
   @Resource private WmsApproveRecordService records;
   @Resource private WmsApproveRecordDetailService details;

   public boolean read(Long auditId, Integer paymentType, String menu) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || auditId == null) return false;
      ContractAuditLedger ledger = ledgers.getById(auditId);
      if (ledger == null || !Objects.equals(ledger.getPaymentEnum(), paymentType)) return false;
      if (user.isAdmin()) return true;
      if (user.getPermissions() != null && Arrays.asList(menu + ":get", "examine-manage:get", "examine-manage:detail")
            .stream().anyMatch(user.getPermissions()::contains)) return true;
      Long userId = UserUtil.getCurrentUserId();
      if (Objects.equals(ledger.getInitiatorId(), userId)) return true;
      if (ledger.getApproveRecordId() == null) return false;
      WmsApproveRecord record = records.getById(ledger.getApproveRecordId());
      if (record == null || !Objects.equals(record.getDataId(), ledger.getId())) return false;
      if (Objects.equals(record.getApplicantId(), userId)) return true;
      return details.count(Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
         .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber())
         .eq(WmsApproveRecordDetail::getCheckUserId, userId)) > 0;
   }
}
