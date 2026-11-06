package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;

public interface ProjectUserLinkService extends IService<ProjectUserLink> {
   ListVO listUser(Long projectId);

   void checkProjectUser(Long projectId);
}
