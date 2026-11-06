package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanSummaryDO;
import java.util.List;

public interface PlanMonomerDetailService extends IService<PlanMonomerDetail> {
   List<PlanSummaryDO> listByYearAndType(String year, Integer type, List<Long> projectIds);
}
