package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUserLinkDTO;
import java.util.List;

public interface MesInspectConfigUserLinkService extends IService<MesInspectConfigUserLink> {
   List<MesInspectConfigUserLinkDTO> findInspectUserInfoByInspectId(List<Long> idList);

   List<InsepctUserConditionDTO> findInspectUserReturnConditions(Long userId);
}
