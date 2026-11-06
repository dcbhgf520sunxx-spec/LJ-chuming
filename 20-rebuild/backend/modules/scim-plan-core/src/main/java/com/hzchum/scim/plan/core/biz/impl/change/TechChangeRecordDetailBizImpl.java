package com.hzchum.scim.plan.core.biz.impl.change;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeRecordDetailBiz;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordDetailService;
import com.hzchum.scim.plan.core.mapper.change.TechChangeRecordDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class TechChangeRecordDetailBizImpl
   extends IBizImpl<TechChangeRecordDetailService, TechChangeRecordDetailMapper, TechChangeRecordDetail>
   implements TechChangeRecordDetailBiz {
}
