package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.mapper.TechMachineHoleRadiusLinkMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TechMachineHoleRadiusLinkServiceImpl
   extends ServiceImpl<TechMachineHoleRadiusLinkMapper, TechMachineHoleRadiusLink>
   implements TechMachineHoleRadiusLinkService {
   @Override
   public Map<String, Long> getMachinePartHoleNumberMap(Long monomerId) {
      List<TechMachineHoleRadiusLink> linkList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(TechMachineHoleRadiusLink.builder().monomerId(monomerId).build()));
      Map<String, Long> machinePartHoleNumberMap = new HashMap<>(1024);
      linkList.forEach(link -> {
         if (!machinePartHoleNumberMap.containsKey(link.getSerialNumber())) {
            machinePartHoleNumberMap.put(link.getSerialNumber(), (long)link.getQuantity().intValue());
         } else {
            machinePartHoleNumberMap.put(link.getSerialNumber(), machinePartHoleNumberMap.get(link.getSerialNumber()) + link.getQuantity().intValue());
         }
      });
      return machinePartHoleNumberMap;
   }
}
