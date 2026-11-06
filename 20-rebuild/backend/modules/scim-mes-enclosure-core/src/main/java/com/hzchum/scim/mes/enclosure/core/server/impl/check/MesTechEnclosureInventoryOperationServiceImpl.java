package com.hzchum.scim.mes.enclosure.core.server.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.MesTechEnclosureInventoryOperation;
import com.hzchum.scim.mes.enclosure.core.api.service.check.MesTechEnclosureInventoryOperationService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.MesTechEnclosureInventoryOperationMapper;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesTechEnclosureInventoryOperationServiceImpl
   extends ServiceImpl<MesTechEnclosureInventoryOperationMapper, MesTechEnclosureInventoryOperation>
   implements MesTechEnclosureInventoryOperationService {
   @Resource
   TechEnclosureChangeRecordService enclosureChangeRecordService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private PlanAreaService planAreaService;
}
