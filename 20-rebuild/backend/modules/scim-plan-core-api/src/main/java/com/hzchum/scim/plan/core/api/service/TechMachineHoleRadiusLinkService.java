package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import java.util.Map;

public interface TechMachineHoleRadiusLinkService extends IService<TechMachineHoleRadiusLink> {
   Map<String, Long> getMachinePartHoleNumberMap(Long monomerId);
}
