package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectClassificationConfigLinkDTO;
import com.hzchum.scim.system.core.api.service.MesInspectClassificationConfigLinkService;
import com.hzchum.scim.system.core.mapper.MesInspectClassificationConfigLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesInspectClassificationConfigLinkServiceImpl
   extends ServiceImpl<MesInspectClassificationConfigLinkMapper, MesInspectClassificationConfigLink>
   implements MesInspectClassificationConfigLinkService {
   @Override
   public List<MesInspectClassificationConfigLinkDTO> findClassInfoByInspectId(List<Long> idList) {
      return this.baseMapper.findClassInfoByInspectId(idList);
   }
}
