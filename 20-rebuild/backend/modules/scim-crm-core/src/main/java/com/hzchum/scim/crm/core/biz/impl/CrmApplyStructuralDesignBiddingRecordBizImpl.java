package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.service.CrmApplyStructuralDesignBiddingRecordService;
import com.hzchum.scim.crm.core.mapper.CrmApplyStructuralDesignBiddingRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmApplyStructuralDesignBiddingRecordBizImpl
   extends IBizImpl<CrmApplyStructuralDesignBiddingRecordService, CrmApplyStructuralDesignBiddingRecordMapper, CrmApplyStructuralDesignBiddingRecord>
   implements CrmApplyStructuralDesignBiddingRecordBiz {
}
