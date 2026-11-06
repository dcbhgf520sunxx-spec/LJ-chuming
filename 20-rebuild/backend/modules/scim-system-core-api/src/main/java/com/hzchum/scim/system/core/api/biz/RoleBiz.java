package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleAndUserUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDeptUserResponseVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface RoleBiz {
   RoleDTO getRole(Long id);

   PageVO<RoleDTO> pageRole(String name, Integer pageNumber, Integer pageSize);

   boolean deleteRoles(List<Long> ids);

   List<ProjectUserLinkDTO> listUserByRole(Long roleId);

   Boolean updateRoleAndUser(RoleAndUserUpdateDTO roleAndUserUpdateDTO);

   RoleDeptUserResponseVO getUserByRole(Long roleId);

   void roleExport(HttpServletResponse response);
}
