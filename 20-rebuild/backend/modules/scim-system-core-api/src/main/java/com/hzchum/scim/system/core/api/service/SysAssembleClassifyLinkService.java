package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLink;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import java.util.List;

public interface SysAssembleClassifyLinkService extends IService<SysAssembleClassifyLink> {
   List<SteelClassifyLinkDTO> listByCondition(Long assembleConfigId);
}
