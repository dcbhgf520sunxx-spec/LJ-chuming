package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsOutboundRemind;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsOutboundRemindDTO;
import java.util.List;

public interface WmsOutboundRemindService extends IService<WmsOutboundRemind> {
   Boolean saveOutboundRemind(Outbound outbound);

   List<WmsOutboundRemindDTO> getRemindList();

   Integer getRemindNumbers();

   Boolean closeList(List<Long> ids);
}
