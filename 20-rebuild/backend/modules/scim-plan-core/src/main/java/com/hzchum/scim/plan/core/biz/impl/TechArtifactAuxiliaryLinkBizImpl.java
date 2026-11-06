package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechArtifactAuxiliaryLinkBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import com.hzchum.scim.plan.core.api.service.TechArtifactAuxiliaryLinkService;
import com.hzchum.scim.plan.core.mapper.TechArtifactAuxiliaryLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactAuxiliaryLinkBizImpl
   extends IBizImpl<TechArtifactAuxiliaryLinkService, TechArtifactAuxiliaryLinkMapper, TechArtifactAuxiliaryLink>
   implements TechArtifactAuxiliaryLinkBiz {
}
