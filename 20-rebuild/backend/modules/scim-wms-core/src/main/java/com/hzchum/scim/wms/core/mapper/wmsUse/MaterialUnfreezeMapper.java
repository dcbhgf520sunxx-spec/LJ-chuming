package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialUnfreeze;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import java.util.List;

public interface MaterialUnfreezeMapper extends BaseMapper<MaterialUnfreeze> {
   List<MaterialUnfreeze> listInfo(QueryByMaterialDTOParam param);
}
