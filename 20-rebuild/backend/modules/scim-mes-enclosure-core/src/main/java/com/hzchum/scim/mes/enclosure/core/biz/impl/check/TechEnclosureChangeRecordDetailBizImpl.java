package com.hzchum.scim.mes.enclosure.core.biz.impl.check;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.check.TechEnclosureChangeRecordDetailBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecordDetail;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordDetailService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.TechEnclosureChangeRecordDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeRecordDetailBizImpl
   extends IBizImpl<TechEnclosureChangeRecordDetailService, TechEnclosureChangeRecordDetailMapper, TechEnclosureChangeRecordDetail>
   implements TechEnclosureChangeRecordDetailBiz {
}
