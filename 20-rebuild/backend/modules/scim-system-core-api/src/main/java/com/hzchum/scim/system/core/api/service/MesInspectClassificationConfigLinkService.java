package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectClassificationConfigLinkDTO;
import java.util.List;

public interface MesInspectClassificationConfigLinkService extends IService<MesInspectClassificationConfigLink> {
   List<MesInspectClassificationConfigLinkDTO> findClassInfoByInspectId(List<Long> idList);
}
