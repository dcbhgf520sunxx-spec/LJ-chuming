package com.hzchum.scim.mes.enclosure.core.biz.impl.check;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.check.TechEnclosureRecordBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureRecord;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureRecordService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.TechEnclosureRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureRecordBizImpl
   extends IBizImpl<TechEnclosureRecordService, TechEnclosureRecordMapper, TechEnclosureRecord>
   implements TechEnclosureRecordBiz {
}
