package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;

public interface CrmApplyBusinessBiddingRecordMapper extends BaseMapper<CrmApplyBusinessBiddingRecord> {
   CrmApplyBusinessBiddingRecord getDetailByDelete(Long id);
}
