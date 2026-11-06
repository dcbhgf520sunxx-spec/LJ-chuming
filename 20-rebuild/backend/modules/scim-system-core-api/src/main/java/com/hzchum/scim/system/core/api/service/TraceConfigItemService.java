package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.TraceConfigItem;
import com.hzchum.scim.system.core.api.pojo.dto.TraceConfigItemDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TraceConfigItemVO;
import java.util.List;

public interface TraceConfigItemService extends IService<TraceConfigItem> {
   List<TraceConfigItemVO> listVO();

   Boolean saveBatch(List<TraceConfigItemDTO> dtoList);

   Boolean updateOne(TraceConfigItemDTO dto);
}
