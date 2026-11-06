package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.MoveMaterialMaterialDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import java.util.List;

public interface MoveMaterialDetailMapper extends BaseMapper<MoveMaterialDetail> {
   List<MoveMaterialMaterialDO> getMoveMaterialDetailList(QueryDetailDTOParam param);

   MoveMaterialMaterialDO getMoveMaterialDetailCount(QueryDetailDTOParam param);

   List<DownLoadDetailDO> getDownLoadDetail(QueryDetailDTOParam param);
}
