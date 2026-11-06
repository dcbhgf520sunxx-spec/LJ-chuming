package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends BaseMapper<Role> {
   List<RoleDTO> selectByCondition(@Param("name") String name);

   List<Role> listByUserId(@Param("userId") Long userId);
}
