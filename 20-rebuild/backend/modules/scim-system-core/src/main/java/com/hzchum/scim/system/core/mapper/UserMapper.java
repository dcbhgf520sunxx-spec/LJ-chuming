package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
   List<UserResponseVO> selectByCondition(
      @Param("deptId") Long deptId, @Param("blurry") String blurry, @Param("isEnabled") Boolean isEnabled, @Param("userType") Integer userType
   );

   Long getIdByPhone(@Param("phone") String phone);

   User getByPhone(@Param("phone") String phone);

   User getByUsername(@Param("username") String username);

   User getByEmail(@Param("email") String email);

   List<User> listByName(String name);

   List<UserSimpleResponseVO> getSimpleUser();

   List<User> listByDeptId(@Param("deptId") Long deptId);

   List<Long> getByInventoryNotifyPerm();

   List<User> listIsEnabledByDeptId(@Param("deptId") Long deptId);

   List<User> selectByPrimaryKeys(List<Long> ids);

   List<Long> selectIdsByName(@Param("name") String name);

   void updateNotifyType(List<Long> ids, boolean b);

   List<UserSimpleResponseVO> getSimpleUserByIds(@Param("ids") List<Long> ids);

   List<UserSimpleResponseVO> getUserAllListVO();

   UserResponseVO getUserByPhone(@Param("phone") String phone);
}
