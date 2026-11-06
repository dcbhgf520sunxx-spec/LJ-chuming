package com.hzchum.scim.plan.core.biz.impl.change;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeMachinePartBiz;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeMachinePart;
import com.hzchum.scim.plan.core.api.service.change.TechChangeMachinePartService;
import com.hzchum.scim.plan.core.mapper.change.TechChangeMachinePartMapper;
import org.springframework.stereotype.Service;

@Service
public class TechChangeMachinePartBizImpl
   extends IBizImpl<TechChangeMachinePartService, TechChangeMachinePartMapper, TechChangeMachinePart>
   implements TechChangeMachinePartBiz {
}
