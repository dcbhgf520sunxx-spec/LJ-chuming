package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmPersonTemplateUserLinkBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPersonTemplateUserLink;
import com.hzchum.scim.crm.core.api.service.CrmPersonTemplateUserLinkService;
import com.hzchum.scim.crm.core.mapper.CrmPersonTemplateUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmPersonTemplateUserLinkBizImpl
   extends IBizImpl<CrmPersonTemplateUserLinkService, CrmPersonTemplateUserLinkMapper, CrmPersonTemplateUserLink>
   implements CrmPersonTemplateUserLinkBiz {
}
