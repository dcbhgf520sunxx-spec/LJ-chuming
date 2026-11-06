package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface WmsSurplusMapper extends BaseMapper<WmsSurplus> {
   int getCount(LocalDateTime now);

   List<WmsSurplus> getSurplusList(QueryReportSurplusDTOParam param);
}
