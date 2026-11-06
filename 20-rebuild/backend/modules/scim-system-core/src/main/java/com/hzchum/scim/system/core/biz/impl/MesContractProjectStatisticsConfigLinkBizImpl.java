package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesContractProjectStatisticsConfigLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.service.MesContractProjectStatisticsConfigLinkService;
import com.hzchum.scim.system.core.mapper.MesContractProjectStatisticsConfigLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesContractProjectStatisticsConfigLinkBizImpl
   extends IBizImpl<MesContractProjectStatisticsConfigLinkService, MesContractProjectStatisticsConfigLinkMapper, MesContractProjectStatisticsConfigLink>
   implements MesContractProjectStatisticsConfigLinkBiz {
}
