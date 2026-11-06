package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleSaveVO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleUpdateVO;
import java.util.List;

public interface RoleService extends IService<Role> {
   List<RoleDTO> listByCondition(String name);

   ListVO<Role> listRole(String name);

   Long saveRole(RoleSaveVO saveVO);

   boolean updateRole(RoleUpdateVO requestVO);

   Role getByName(String name);

   List<Role> listByUserId(Long userId);
}
