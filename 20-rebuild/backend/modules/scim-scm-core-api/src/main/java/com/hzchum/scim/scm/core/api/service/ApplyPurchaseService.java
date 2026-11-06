package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseInboundDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndSNDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseStatusDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ApplyPurchaseService extends IService<ApplyPurchase> {
   PageVO<ApplyPurchaseDTO> pageInfo(
      List<LocalDateTime> times,
      Integer basicClass,
      String serialNumber,
      Integer status,
      Boolean enabled,
      Boolean boolInitiateApprove,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   PageVO<ApplyPurchaseDTO> pageInfoV2(
      List<LocalDateTime> times,
      Integer basicClass,
      String serialNumber,
      Integer status,
      Boolean enabled,
      Boolean boolInitiateApprove,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String departmentName,
      String applicantName,
      Long projectId,
      Integer projectAttribute,
      Integer purchaseCreationStateInteger,
      Integer level,
      Long branchCompanyId
   );

   PageVO<ApplyPurchaseDTO> getListAndDetailPageInfoV2(
      List<LocalDateTime> times,
      Integer materialType,
      String serialNumber,
      Integer status,
      Boolean enabled,
      Boolean boolInitiateApprove,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String departmentName,
      String applicantName,
      Long projectId,
      Integer projectAttribute,
      Integer purchaseCreationState,
      Integer level,
      Long branchCompanyId
   );

   Boolean save(ApplyPurchaseDTOParam param);

   Boolean saveV2(ApplyPurchaseDTOParam param, Boolean boolAgainSubmit);

   ApplyPurchaseDTO selectById(Long id);

   ApplyPurchaseDTO selectByIdV2(Long id);

   void updateStatus(Long id, Integer status);

   Boolean delete(Long id);

   Boolean deleteV2(Long id);

   PrintVO print(Long id);

   Boolean checkClassify(Long classifyId);

   Boolean updateEnabled(Long id, boolean enabled);

   ListVO<BriefIdAndSNDTO> briefList(List<LocalDateTime> times, Integer materialType, Boolean filterUseInventory, Integer purchaseCreationState);

   Boolean updateInfo(ApplyPurchaseDTOParam param);

   List<ApplyPurchaseDetailDTO> canPurchaseDetail(List<Long> ids);

   List<ApplyPurchaseDetailDTO> canPurchaseDetailV2(List<Long> ids);

   ApplyPurchase updatePurchaseStatus(Long applyPurchaseId, Long applyPurchaseDetailId, PurchaseOrderDetail productDetail);

   void updateInboundMete(Long applyPurchaseId, BigDecimal inboundMete);

   ApplyPurchaseDTO schedule(Long id);

   void excel(Long id, HttpServletResponse response);

   List<ApplyPurchaseDTO> listByLevelV2(Integer level);

   Boolean approvalApplyPurchase(WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam);

   List<ApplyPurchaseDTO> getTSApplyPurchase();

   Integer getTSCount();

   Boolean saveTS(ApplyPurchaseDTOParam param);

   Boolean saveCheck(ApplyPurchaseDTOParam param);

   List<ApplyPurchaseDTO> getCanCheck();

   ListVO<BriefIdAndSNDTO> briefListV2(
      List<LocalDateTime> times,
      Integer materialType,
      Boolean filterUseInventory,
      Integer purchaseCreationState,
      Integer level,
      Integer projectAttribute,
      Long branchCompanyId,
      Long projectId
   );

   List<BriefIdAndSNDTO> manufacturedBriefList(Long projectId, Integer materialType, Long branchCompanyId);

   Integer getCanCheckCount();

   Boolean revocation(Long id);

   Boolean cancellation(Long id);

   Boolean updatePurchaseCreationStateById(List<ApplyPurchaseStatusDTOParam> list);

   Boolean removeTs();

   Boolean againSubmitApplyPurchase(ApplyPurchaseDTOParam param);

   Object updateUnderReviewApplyPurchase(ApplyPurchaseDTOParam param);

   Boolean deleteType(ApplyPurchaseDTOParam param);

   List<PurchaseOrderDetailDTO> getPurchaseDetailById(Long id);

   List<ApplyPurchaseInboundDetailDTO> getInboundDetailById(Long id);
}
