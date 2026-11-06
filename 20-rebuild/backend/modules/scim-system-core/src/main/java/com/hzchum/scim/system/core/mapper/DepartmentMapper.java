package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentTree;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentUserTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserTreeResponseVO;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper extends BaseMapper<Department> {
   List<DepartmentTree> listAll();

   Integer checkName(@Param("name") String name);

   @Select("SELECT id,name,id userList,id deptList,pid FROM sys_department WHERE pid=0 and bool_delete_enum = false")
   @Results(
      {
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(property = "userList", column = "userList", many = @Many(select = "com.hzchum.scim.system.core.mapper.UserMapper.listIsEnabledByDeptId")),
            @Result(
               property = "deptList",
               column = "id",
               many = @Many(select = "com.hzchum.scim.system.core.mapper.DepartmentMapper.lisDepartmentUserTreeByPid")
            )
      }
   )
   List<DepartmentUserTreeResponseVO> lisDepartmentUserTree();

   @Select("SELECT id,name FROM sys_department WHERE pid = #{pid} and bool_delete_enum = 0")
   @Results(
      {
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(
               property = "deptList",
               column = "id",
               many = @Many(select = "com.hzchum.scim.system.core.mapper.DepartmentMapper.lisDepartmentUserTreeByPid")
            ),
            @Result(property = "userList", column = "id", many = @Many(select = "com.hzchum.scim.system.core.mapper.UserMapper.listIsEnabledByDeptId"))
      }
   )
   List<DepartmentUserTreeResponseVO> lisDepartmentUserTreeByPid(@Param("pid") Long pid);

   List<User> listIsEnabledByDeptId(@Param("deptId") Long deptId);

   List<DeptUserTreeResponseVO> getDepartmentOne();

   Department selectByUserId(@Param("userId") Long userId);

   List<Department> getAllDepartmentList();

   Department getDepartmentById(Long id);
}
