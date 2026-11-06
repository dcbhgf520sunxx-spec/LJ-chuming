package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.service.CrmApplyBusinessBiddingRecordService;
import com.hzchum.scim.crm.core.mapper.CrmApplyBusinessBiddingRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmApplyBusinessBiddingRecordBizImpl
   extends IBizImpl<CrmApplyBusinessBiddingRecordService, CrmApplyBusinessBiddingRecordMapper, CrmApplyBusinessBiddingRecord>
   implements CrmApplyBusinessBiddingRecordBiz {
}
