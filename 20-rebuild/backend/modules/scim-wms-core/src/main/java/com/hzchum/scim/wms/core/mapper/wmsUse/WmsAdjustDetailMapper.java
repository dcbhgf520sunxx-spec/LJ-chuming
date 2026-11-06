package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import java.util.List;

public interface WmsAdjustDetailMapper extends BaseMapper<WmsAdjustDetail> {
   List<AdjustDetailDTO> listInfo(QueryReportAdjustDTOParam param);
}
