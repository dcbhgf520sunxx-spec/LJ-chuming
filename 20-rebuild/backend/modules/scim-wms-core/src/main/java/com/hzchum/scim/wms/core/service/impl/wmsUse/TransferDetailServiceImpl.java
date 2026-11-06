package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferDetailService;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class TransferDetailServiceImpl extends ServiceImpl<TransferDetailMapper, TransferDetail> implements TransferDetailService {
}
