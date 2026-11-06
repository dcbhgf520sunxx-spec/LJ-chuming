package com.hzchum.scim.common.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo._do.WmsInformMsg;
import com.hzchum.scim.common.core.api.pojo.dto.WmsInformMsgDTO;
import java.util.List;

public interface WmsInformMsgService extends IService<WmsInformMsg> {
   List<WmsInformMsgDTO> getAll(Integer status);

   Boolean updateStatusById(Long id, Boolean status);

   Boolean readAll();

   Boolean cleanReadAll();

   Boolean del(List<Long> ids);

   Integer getSkipPage(Long id);
}
