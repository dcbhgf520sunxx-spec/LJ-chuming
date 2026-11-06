package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleUser;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolUserLink;
import java.util.List;

public interface MesMachineToolUserLinkService extends IService<MesMachineToolUserLink> {
   List<SimpleUser> findUserInfoByCondition(Long partProcessId, List<Long> toolConfigIds, List<Long> userId);
}
