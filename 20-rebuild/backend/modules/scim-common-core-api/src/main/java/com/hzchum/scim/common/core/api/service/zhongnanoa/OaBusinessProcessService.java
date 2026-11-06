package com.hzchum.scim.common.core.api.service.zhongnanoa;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanFixedDataDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAnnualContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaArgumentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaDeepenDrawingDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchasePaymentDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseSettleAccountDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.WorkflowDTOParam;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface OaBusinessProcessService {
   String doCreateRequest(String requestName, String workflowId, String userId, List<OaArgumentDTO> mainData, List<OaDetailDTO> detailData);

   ZhongNanWorkFlowDTO checkPermission(String userId, String workflowName);

   List<OaArgumentDTO> resultData(Object object) throws IllegalAccessException;

   String doCreatePurchaseContractManufacturedGoods(OaPurchaseContractDTOParam purchaseContractDTOParam);

   String doCreateAnnualContractRawMaterial(OaAnnualContractDTOParam annualContractDTOParam);

   String doCreateAnnualContract(OaAnnualContractDTOParam annualContractDTOParam);

   String doCreatePurchasePayment(OaPurchasePaymentDTOParam purchasePaymentDTOParam);

   String doCreatePurchaseSettleAccountsRawMaterial(OaPurchaseSettleAccountDTOParam purchaseSettleAccountDTOParam);

   String doCreatePurchaseSettleAccountsManufacturedGoods(OaPurchaseContractDTOParam purchaseContractDTOParam);

   String getCreateWorkflowList(String userId);

   ResultVO updateOaRequestId(@RequestBody WorkflowDTOParam workflowDTOParam);

   ResultVO withdrawRequest(@RequestBody OaRevocationDTOParam oaRevocationDTOParam);

   ResultVO approvalFlowStatus(@RequestBody OaWorkflowDTOParam workflowDTOParam);

   ResultVO<ZhongNanFixedDataDTO> getFixedData(@RequestParam("dataId") Long dataId, @RequestParam("businessType") Integer businessType);

   ResultVO<ZhongNanFixedDataDTO> getFixedData();

   Boolean deepenDrawingUpload(
      MultipartFile multipartFile,
      OaDeepenDrawingDTOParam oaParam,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer dataType,
      Integer productType,
      Long productId,
      Boolean cover
   );
}
