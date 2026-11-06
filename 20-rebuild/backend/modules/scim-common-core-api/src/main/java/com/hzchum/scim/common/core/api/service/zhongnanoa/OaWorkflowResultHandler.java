package com.hzchum.scim.common.core.api.service.zhongnanoa;

import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;

public interface OaWorkflowResultHandler {
   boolean supports(String workflowName);

   void handle(OaWorkflowDTOParam workflow, WmsApproveRecord approveRecord);

   default boolean supportsWithdraw(Integer approveProcessType) {
      return false;
   }

   default boolean supportsApproveProcessType(Integer approveProcessType) {
      return false;
   }

   default void handleWithdraw(WmsApproveRecord approveRecord) {
   }
}
