package com.hzchum.scim.common.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateVersionsService;
import com.hzchum.scim.common.core.mapper.WmsApproveTemplateVersionsMapper;
import org.springframework.stereotype.Service;

@Service
public class WmsApproveTemplateVersionsServiceImpl
   extends ServiceImpl<WmsApproveTemplateVersionsMapper, WmsApproveTemplateVersions>
   implements WmsApproveTemplateVersionsService {
}
