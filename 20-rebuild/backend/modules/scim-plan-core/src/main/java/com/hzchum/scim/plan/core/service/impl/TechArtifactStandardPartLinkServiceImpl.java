package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactStandardPartLinkDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.mapper.TechArtifactStandardPartLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactStandardPartLinkServiceImpl
   extends ServiceImpl<TechArtifactStandardPartLinkMapper, TechArtifactStandardPartLink>
   implements TechArtifactStandardPartLinkService {
   @Override
   public List<TechArtifactStandardPartLinkDTO> listByCondition(List<Long> artifactIdList, List<String> nameList) {
      return this.baseMapper.listByCondition(artifactIdList, nameList);
   }
}
