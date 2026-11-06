package com.hzchum.scim.wms.core.biz.impl.wmsUse;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.wms.core.api.biz.wmsUse.WmsSurplusDetailBiz;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusDetailService;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsSurplusDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class WmsSurplusDetailBizImpl extends IBizImpl<WmsSurplusDetailService, WmsSurplusDetailMapper, WmsSurplusDetail> implements WmsSurplusDetailBiz {
}
