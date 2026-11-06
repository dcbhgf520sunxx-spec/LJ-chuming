package com.hzchum.scim.common.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveFlowOperation;
import com.hzchum.scim.common.core.api.service.WmsApproveFlowOperationService;
import com.hzchum.scim.common.core.mapper.WmsApproveFlowOperationMapper;
import org.springframework.stereotype.Service;

@Service
public class WmsApproveFlowOperationServiceImpl
   extends ServiceImpl<WmsApproveFlowOperationMapper, WmsApproveFlowOperation>
   implements WmsApproveFlowOperationService {
}
