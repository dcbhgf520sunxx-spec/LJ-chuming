package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTypeSettingMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleTypesettingPartLink;
import com.hzchum.scim.plan.core.api.service.TechAssembleTypesettingPartLinkService;
import com.hzchum.scim.plan.core.mapper.TechAssembleTypesettingPartLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechAssembleTypesettingPartLinkServiceImpl
   extends ServiceImpl<TechAssembleTypesettingPartLinkMapper, TechAssembleTypesettingPartLink>
   implements TechAssembleTypesettingPartLinkService {
   @Override
   public List<MesBuildingTypeSettingMachinePartDTO> listByTypeSettingId(List<Long> ids) {
      return this.baseMapper.listByTypeSettingId(ids);
   }
}
