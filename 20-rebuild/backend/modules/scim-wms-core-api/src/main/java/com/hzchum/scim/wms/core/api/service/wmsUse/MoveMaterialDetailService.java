package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDetailDTO;
import java.util.List;

public interface MoveMaterialDetailService extends IService<MoveMaterialDetail> {
   List<MoveMaterialDetailDTO> getMoveMaterialDetailDTO(List<Long> ids);
}
