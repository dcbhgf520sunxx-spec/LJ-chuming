package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteClassification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WasteClassificationDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WasteClassificationMapper extends BaseMapper<WasteClassification> {
   List<WasteClassificationDTO> selectListWasteClassification(@Param("name") String name);
}
