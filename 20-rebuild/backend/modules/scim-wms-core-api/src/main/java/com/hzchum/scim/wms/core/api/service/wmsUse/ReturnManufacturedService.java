package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface ReturnManufacturedService extends IService<ReturnManufactured> {
   Integer getCount(LocalDateTime now);

   PageVO<ReturnManufacturedDTO> pageInfo(QueryReturnManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<ReturnDetailManufacturedDTO> pageInfoDetail(QueryReturnManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   ReturnManufacturedDTO getReturnById(Long id);
}
