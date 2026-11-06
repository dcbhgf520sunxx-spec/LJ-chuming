package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleTypesettingPartLink;
import java.util.List;

public interface TechAssembleTypesettingPartLinkService extends IService<TechAssembleTypesettingPartLink> {
   List listByTypeSettingId(List<Long> ids);
}
