package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;

public interface CrmApplyDeepDesignBiddingRecordMapper extends BaseMapper<CrmApplyDeepDesignBiddingRecord> {
   CrmApplyDeepDesignBiddingRecord getDetailByDelete(Long id);
}
