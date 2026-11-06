package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;

public interface CrmApplyTechnologyBiddingRecordMapper extends BaseMapper<CrmApplyTechnologyBiddingRecord> {
   CrmApplyTechnologyBiddingRecord getDetailByDelete(Long id);
}
