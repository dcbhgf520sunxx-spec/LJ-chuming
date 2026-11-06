package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechProductSummary;
import com.hzchum.scim.plan.core.api.service.TechProductSummaryService;
import com.hzchum.scim.plan.core.mapper.TechProductSummaryMapper;
import org.springframework.stereotype.Service;

@Service
public class TechProductSummaryServiceImpl extends ServiceImpl<TechProductSummaryMapper, TechProductSummary> implements TechProductSummaryService {
   @Override
   public ListVO pageProduct(Long projectId, Long monomerId, Integer productType, Integer category) {
      return new ListVO<>(
         monomerId == null
            ? this.baseMapper.listByProjectId(projectId, productType, category)
            : this.baseMapper.listByMonomerId(monomerId, productType, category)
      );
   }
}
