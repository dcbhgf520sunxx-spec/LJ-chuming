package com.hzchum.scim.plan.core.service.impl.change;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordDetailService;
import com.hzchum.scim.plan.core.mapper.change.TechChangeRecordDetailMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechChangeRecordDetailServiceImpl
   extends ServiceImpl<TechChangeRecordDetailMapper, TechChangeRecordDetail>
   implements TechChangeRecordDetailService {
   @Override
   public List<TechChangeRecordDetail> listChangeRecordDetailList(List<Long> artifactIds, Integer checkStats) {
      return this.baseMapper.listChangeRecordDetailList(artifactIds, checkStats);
   }
}
