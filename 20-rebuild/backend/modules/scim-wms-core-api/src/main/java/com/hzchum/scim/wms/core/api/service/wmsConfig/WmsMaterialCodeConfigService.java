package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WmsMaterialCodeConfigDTOParam;
import java.util.List;

public interface WmsMaterialCodeConfigService extends IService<WmsMaterialCodeConfig> {
   Boolean saveMaterialCodeConfig(List<WmsMaterialCodeConfigDTOParam> params);

   Boolean updateMaterialCodeConfig(List<WmsMaterialCodeConfigDTOParam> params);

   PageVO<WmsMaterialCodeConfig> pageInfo(WmsMaterialCodeConfigDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort);
}
