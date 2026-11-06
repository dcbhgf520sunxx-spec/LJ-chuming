package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjust;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface WmsAdjustMapper extends BaseMapper<WmsAdjust> {
   List<WmsAdjust> listInfo(QueryReportAdjustDTOParam param);

   Integer getCount(LocalDateTime date);
}
