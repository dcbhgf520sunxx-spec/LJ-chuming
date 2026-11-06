package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteClassification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WasteClassificationDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WasteClassificationService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WasteClassificationMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WasteClassificationServiceImpl extends ServiceImpl<WasteClassificationMapper, WasteClassification> implements WasteClassificationService {
   @Override
   public List<WasteClassificationDTO> listWasteClassification(String name) {
      return this.baseMapper.selectListWasteClassification(name);
   }
}
