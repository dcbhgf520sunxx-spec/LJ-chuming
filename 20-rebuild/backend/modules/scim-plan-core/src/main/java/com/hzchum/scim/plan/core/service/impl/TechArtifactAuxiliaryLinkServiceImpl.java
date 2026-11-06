package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactAuxiliaryLinkDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactAuxiliaryLinkService;
import com.hzchum.scim.plan.core.mapper.TechArtifactAuxiliaryLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactAuxiliaryLinkServiceImpl
   extends ServiceImpl<TechArtifactAuxiliaryLinkMapper, TechArtifactAuxiliaryLink>
   implements TechArtifactAuxiliaryLinkService {
   @Override
   public List<TechArtifactAuxiliaryLinkDTO> listByCondition(List<Long> artifactIdList, List<String> auxiliaryPartNameList) {
      return this.baseMapper.listByCondition(artifactIdList, auxiliaryPartNameList);
   }
}
