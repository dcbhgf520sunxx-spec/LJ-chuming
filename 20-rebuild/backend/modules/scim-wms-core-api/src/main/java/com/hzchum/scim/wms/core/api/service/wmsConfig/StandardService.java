package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.StandardDTO;
import java.util.List;

public interface StandardService extends IService<Standard> {
   List<StandardDTO> listStandard();

   Boolean addStandard(String name);

   Boolean delete(Long standardId);
}
