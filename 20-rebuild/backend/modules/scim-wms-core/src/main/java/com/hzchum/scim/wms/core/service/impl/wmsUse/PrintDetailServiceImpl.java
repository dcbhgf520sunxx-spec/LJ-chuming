package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintDetailService;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class PrintDetailServiceImpl extends ServiceImpl<PrintDetailMapper, PrintDetail> implements PrintDetailService {
}
