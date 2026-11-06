package com.hzchum.scim.common.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.mapper.WmsApproveRecordDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class WmsApproveRecordDetailServiceImpl
   extends ServiceImpl<WmsApproveRecordDetailMapper, WmsApproveRecordDetail>
   implements WmsApproveRecordDetailService {
}
