package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanSummaryDTO;

public interface PlanSummaryBiz {
   ListVO<PlanSummaryDTO> listMetByProduct(String year, Integer type);
}
