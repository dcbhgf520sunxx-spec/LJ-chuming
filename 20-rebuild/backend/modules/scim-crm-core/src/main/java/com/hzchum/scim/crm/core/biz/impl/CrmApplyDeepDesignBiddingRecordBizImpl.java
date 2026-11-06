package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.service.CrmApplyDeepDesignBiddingRecordService;
import com.hzchum.scim.crm.core.mapper.CrmApplyDeepDesignBiddingRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmApplyDeepDesignBiddingRecordBizImpl
   extends IBizImpl<CrmApplyDeepDesignBiddingRecordService, CrmApplyDeepDesignBiddingRecordMapper, CrmApplyDeepDesignBiddingRecord>
   implements CrmApplyDeepDesignBiddingRecordBiz {
}
