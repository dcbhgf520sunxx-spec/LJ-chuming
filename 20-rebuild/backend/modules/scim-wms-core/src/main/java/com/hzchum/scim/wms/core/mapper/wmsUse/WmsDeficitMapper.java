package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsDeficit;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface WmsDeficitMapper extends BaseMapper<WmsDeficit> {
   Integer getCount(LocalDateTime date);

   List<WmsDeficit> getDeficitList(QueryReportDeficitDTOParam param);
}
