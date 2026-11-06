package com.hzchum.scim.wms.core.api.biz.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteClassification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WasteClassificationDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WasteClassificationDtoParam;
import java.util.List;

public interface WasteClassificationBiz extends IBiz<WasteClassification> {
   List<WasteClassificationDTO> listAll(String name);

   PageVO<WasteClassificationDTO> pageList(String name, Integer pageNumber, Integer pageSize);

   Boolean saveList(List<WasteClassificationDtoParam> paramList);

   Boolean updateList(List<WasteClassificationDtoParam> paramList);

   Boolean deleteList(List<Long> ids);
}
