package com.hzchum.scim.mes.enclosure.core.server.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecordDetail;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordDetailService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.TechEnclosureChangeRecordDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeRecordDetailServiceImpl
   extends ServiceImpl<TechEnclosureChangeRecordDetailMapper, TechEnclosureChangeRecordDetail>
   implements TechEnclosureChangeRecordDetailService {
}
