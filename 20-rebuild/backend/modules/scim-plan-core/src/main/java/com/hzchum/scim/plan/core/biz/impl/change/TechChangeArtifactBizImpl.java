package com.hzchum.scim.plan.core.biz.impl.change;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeArtifactBiz;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeArtifact;
import com.hzchum.scim.plan.core.api.service.change.TechChangeArtifactService;
import com.hzchum.scim.plan.core.mapper.change.TechChangeArtifactMapper;
import org.springframework.stereotype.Service;

@Service
public class TechChangeArtifactBizImpl
   extends IBizImpl<TechChangeArtifactService, TechChangeArtifactMapper, TechChangeArtifact>
   implements TechChangeArtifactBiz {
}
