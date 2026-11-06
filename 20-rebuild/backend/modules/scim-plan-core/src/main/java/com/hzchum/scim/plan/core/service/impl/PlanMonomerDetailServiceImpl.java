package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanSummaryDO;
import com.hzchum.scim.plan.core.api.service.PlanMonomerDetailService;
import com.hzchum.scim.plan.core.mapper.PlanMonomerDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlanMonomerDetailServiceImpl extends ServiceImpl<PlanMonomerDetailMapper, PlanMonomerDetail> implements PlanMonomerDetailService {
   @Override
   public List<PlanSummaryDO> listByYearAndType(String year, Integer type, List<Long> projectIds) {
      return this.baseMapper.listByYearAndType(year, type, projectIds);
   }
}
