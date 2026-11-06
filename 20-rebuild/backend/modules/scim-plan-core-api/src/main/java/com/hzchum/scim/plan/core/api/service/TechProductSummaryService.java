package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechProductSummary;

public interface TechProductSummaryService extends IService<TechProductSummary> {
   ListVO pageProduct(Long projectId, Long monomerId, Integer productType, Integer category);
}
