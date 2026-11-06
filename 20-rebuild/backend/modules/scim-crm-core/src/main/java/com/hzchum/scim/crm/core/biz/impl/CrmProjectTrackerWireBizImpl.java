package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmProjectTrackerWireBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectTrackerWire;
import com.hzchum.scim.crm.core.api.service.CrmProjectTrackerWireService;
import com.hzchum.scim.crm.core.mapper.CrmProjectTrackerWireMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectTrackerWireBizImpl
   extends IBizImpl<CrmProjectTrackerWireService, CrmProjectTrackerWireMapper, CrmProjectTrackerWire>
   implements CrmProjectTrackerWireBiz {
}
