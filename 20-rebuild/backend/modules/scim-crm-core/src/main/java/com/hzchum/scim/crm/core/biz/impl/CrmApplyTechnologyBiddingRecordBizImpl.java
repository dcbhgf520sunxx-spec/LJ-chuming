package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.service.CrmApplyTechnologyBiddingRecordService;
import com.hzchum.scim.crm.core.mapper.CrmApplyTechnologyBiddingRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmApplyTechnologyBiddingRecordBizImpl
   extends IBizImpl<CrmApplyTechnologyBiddingRecordService, CrmApplyTechnologyBiddingRecordMapper, CrmApplyTechnologyBiddingRecord>
   implements CrmApplyTechnologyBiddingRecordBiz {
}
