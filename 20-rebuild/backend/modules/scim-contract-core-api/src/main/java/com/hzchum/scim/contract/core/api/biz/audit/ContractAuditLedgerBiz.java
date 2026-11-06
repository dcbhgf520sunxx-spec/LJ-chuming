package com.hzchum.scim.contract.core.api.biz.audit;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.AuditUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractAuditLedgerDto;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractCollectionAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractReimbursementFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractTestingFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractWageFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractWaterElectricityFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.InsourcingAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.InsourcingDetailAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SelfemployedAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierInvoicePurchaseAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierInvoiceSubOrderAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierSettlementEchoAuditDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.AddContractAuditDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.ContractAuditLedgerQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.FillFeeAuditSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PaymentInvoiceDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.ProjectCollectionAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PurchaseInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.SettleAuditSaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.SubOrderInvoiceAuditParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ContractAuditLedgerBiz extends IBiz<ContractAuditLedger> {
   PageVO<ContractAuditLedgerDto> listAuditLedger(ContractAuditLedgerQueryParam param, Integer pageNumber, Integer pageSize);

   Boolean procurementAudit(AddContractAuditDtoParam param);

   SelfemployedAuditDetail getSelfEmployedAuditDetail(Long auditId);

   Boolean procurementSelfAudit(AddContractAuditDtoParam param);

   Boolean invoiceAudit(PurchaseInvoiceAuditParam param);

   InsourcingDetailAuditDetail getInsourcingDetailAuditDetail(Long auditId);

   SupplierInvoicePurchaseAuditDTO getPurchaseInvoiceAuditInfo(Long auditId);

   SupplierInvoiceSubOrderAuditDTO getSupplierSettlementEchoDtos(Long auditId);

   InsourcingAuditDetail getInsourcingAuditDetail(Long auditId);

   List<AuditUserDTO> getAuditList(Long auditId);

   ContractCollectionAuditDTO getProjectCollectionAuditInfo(Long auditId);

   Boolean projectCollectionAudit(ProjectCollectionAuditParam param);

   Boolean outputInvoiceAudit(PaymentInvoiceDTOParam param);

   Boolean printDownload(Long auditId, HttpServletResponse response);

   PrintVO<List<ContractAuditLedgerDto>> printDownloadAll(ContractAuditLedgerQueryParam param);

   ContractAuditLedgerDto getAuditDetail(Long auditId);

   Boolean procurementAudit(Integer paymentEnum, BigDecimal amount, Integer branchCompanyId);

   SupplierSettlementEchoAuditDto settlementAuditDetail(Long auditId);

   Boolean settlementAudit(SettleAuditSaveDtoParam param);

   Map<String, Object> checkBeforeProjectSettlement(Long projectId);

   ProjectSettlementDTO getProjectDetail(Long auditId, Long projectId, Integer level);

   Boolean saveProjectSettlement(ProjectSettlementSaveParam param);

   Boolean projectSettlementAudit(SettleAuditSaveDtoParam param);

   Boolean subcontractSelfAudit(AddContractAuditDtoParam param);

   Boolean subcontractSelfInvoiceAudit(SubOrderInvoiceAuditParam param);

   SupplierSettlementDto subcontractSettlementAuditDetail(Long auditId);

   Boolean subcontractOrderSettlementAudit(SettleAuditSaveDtoParam param);

   Boolean subcontractOrderPreSettlementAudit(SettleAuditSaveDtoParam param);

   Boolean projectPreSettlementAudit(SettleAuditSaveDtoParam param);

   Boolean subcontractAudit(AddContractAuditDtoParam param);

   Boolean subcontractInvoiceAudit(PaymentInvoiceDTOParam param);

   Boolean subcontractOrderSettlementAudit(Long auditId, Integer auditStatusEnum, BigDecimal actuallyPayAmount);

   ContractTestingFeeAuditDTO getTestingFeeInfo(Long auditId);

   Boolean auditTestingFee(FillFeeAuditSaveParam param);

   ContractWaterElectricityFeeAuditDTO getWaterElectricityFeeInfo(Long auditId);

   Boolean auditWaterElectricityFee(FillFeeAuditSaveParam param);

   ContractReimbursementFeeAuditDTO getReimbursementFeeInfo(Long auditId);

   Boolean auditReimbursementFee(FillFeeAuditSaveParam param);

   ContractWageFeeAuditDTO getWageFeeInfo(Long auditId);

   Boolean auditWageFee(FillFeeAuditSaveParam param);
}
