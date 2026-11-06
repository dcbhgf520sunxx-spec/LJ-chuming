package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteClassification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WasteClassificationDTO;
import java.util.List;

public interface WasteClassificationService extends IService<WasteClassification> {
   List<WasteClassificationDTO> listWasteClassification(String name);
}
