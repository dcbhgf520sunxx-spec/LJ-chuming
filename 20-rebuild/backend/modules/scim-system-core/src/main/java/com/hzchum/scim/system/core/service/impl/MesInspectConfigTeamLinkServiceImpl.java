package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigTeamLinkDTO;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.mapper.MesInspectConfigTeamLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesInspectConfigTeamLinkServiceImpl
   extends ServiceImpl<MesInspectConfigTeamLinkMapper, MesInspectConfigTeamLink>
   implements MesInspectConfigTeamLinkService {
   @Override
   public List<MesInspectConfigTeamLinkDTO> findInspectInfoByInspectId(List<Long> inspectId) {
      return this.baseMapper.findInspectInfoByInspectId(inspectId);
   }
}
