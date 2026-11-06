package com.hzchum.scim.mes.enclosure.core.biz.impl.check;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.check.MesTechEnclosureInventoryOperationBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.MesTechEnclosureInventoryOperation;
import com.hzchum.scim.mes.enclosure.core.api.service.check.MesTechEnclosureInventoryOperationService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureRecordService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.MesTechEnclosureInventoryOperationMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesTechEnclosureInventoryOperationBizImpl
   extends IBizImpl<MesTechEnclosureInventoryOperationService, MesTechEnclosureInventoryOperationMapper, MesTechEnclosureInventoryOperation>
   implements MesTechEnclosureInventoryOperationBiz {
   @Resource
   private TechEnclosureRecordService enclosureRecordService;
}
