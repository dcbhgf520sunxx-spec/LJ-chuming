package com.hzchum.scim.wms.core.biz.impl.wmsUse;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.wms.core.api.biz.wmsUse.WmsSurplusBiz;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusService;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsSurplusMapper;
import org.springframework.stereotype.Service;

@Service
public class WmsSurplusBizImpl extends IBizImpl<WmsSurplusService, WmsSurplusMapper, WmsSurplus> implements WmsSurplusBiz {
}
