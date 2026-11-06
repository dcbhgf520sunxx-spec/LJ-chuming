package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;

public interface CrmApplyStructuralDesignBiddingRecordMapper extends BaseMapper<CrmApplyStructuralDesignBiddingRecord> {
   CrmApplyStructuralDesignBiddingRecord getDetailByDelete(Long id);
}
