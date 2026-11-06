package com.hzchum.scim.mes.enclosure.core.biz.impl.check;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.check.TechEnclosureChangeRecordBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecord;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.TechEnclosureChangeRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeRecordBizImpl
   extends IBizImpl<TechEnclosureChangeRecordService, TechEnclosureChangeRecordMapper, TechEnclosureChangeRecord>
   implements TechEnclosureChangeRecordBiz {
}
