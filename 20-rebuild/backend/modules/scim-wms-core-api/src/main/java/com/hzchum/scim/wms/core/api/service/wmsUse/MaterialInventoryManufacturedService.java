package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialManufacturedDTOParam;
import java.util.List;

public interface MaterialInventoryManufacturedService extends IService<MaterialInventoryManufactured> {
   PageVO<MaterialInventoryManufacturedDTO> pageInfo(QueryMaterialManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<ProjectInfo> getProject();
}
