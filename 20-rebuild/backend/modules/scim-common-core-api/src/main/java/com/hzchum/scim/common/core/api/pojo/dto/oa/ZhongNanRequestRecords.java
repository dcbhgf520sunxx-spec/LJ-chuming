package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ZhongNanRequestRecords {
   @JsonProperty("记录单号")
   private int recordOrder;
   @JsonProperty("流程表字段")
   private List<ZhongNanWorkflowRequestTableFields> workflowRequestTableFields;
}
