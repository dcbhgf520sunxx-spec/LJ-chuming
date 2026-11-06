package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import java.util.List;

public interface ReturnDetailManufacturedService extends IService<ReturnDetailManufactured> {
   List<ReturnDetailManufactured> selectList(QueryReturnManufacturedDTOParam param);

   List<ReturnDetailManufacturedDTO> convertDetailDto(List<ReturnDetailManufactured> returnDetailManufactureds);
}
