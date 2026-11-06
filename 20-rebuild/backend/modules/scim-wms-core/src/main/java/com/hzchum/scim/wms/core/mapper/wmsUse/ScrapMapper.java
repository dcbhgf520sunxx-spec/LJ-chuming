package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import java.util.List;

public interface ScrapMapper extends BaseMapper<Scrap> {
   List<Scrap> listInfo(QueryByMaterialDTOParam param);
}
