package com.hzchum.scim.system.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.system.core.api.biz.RoleBiz;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.RoleMenuLink;
import com.hzchum.scim.system.core.api.pojo._do.SysRoleLookPermissionConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleAndUserUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDeptUserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserDeptResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserJobResponseVO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.api.service.SysRoleLookPermissionConfigService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoleBizImpl implements RoleBiz {
   private static final Logger log = LoggerFactory.getLogger(RoleBizImpl.class);
   private final UserRoleLinkService userRoleLinkService;
   private final RoleMenuLinkService roleMenuLinkService;
   private final UserService userService;
   private final DepartmentService departmentService;
   private final RoleService roleService;
   private final SysRoleLookPermissionConfigService sysRoleLookPermissionConfigService;

   @Override
   public RoleDTO getRole(Long id) {
      Role role = this.roleService.getById(id);
      Preconditions.checkArgument(role != null, "角色不存在！");
      RoleDTO responseVO = new RoleDTO();
      BeanUtil.copy(role, responseVO);
      responseVO.setMenus(this.roleMenuLinkService.listMenuIdByRoleId(id));
      return responseVO;
   }

   @Override
   public PageVO<RoleDTO> pageRole(String name, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<RoleDTO> roles = this.roleService.listByCondition(name);
      roles.forEach(r -> r.setMenus(this.roleMenuLinkService.listMenuIdByRoleId(r.getId())));
      return new PageVO<>(roles);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean deleteRoles(@RequestBody List<Long> ids) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(ids), "删除失败,未选中任何角色");
      ids.forEach(id -> {
         Role role = this.roleService.getById(id);
         Preconditions.checkArgument(role != null, "删除失败，该角色不存在");
         Preconditions.checkArgument(!role.getIsDefault(), "系统或公司的默认角色不能被删除");
         int count = this.userRoleLinkService.count(Wrappers.lambdaQuery(UserRoleLink.class).eq(UserRoleLink::getRoleId, id));
         Preconditions.checkArgument(count == 0, "删除失败,有用户关联该角色");
         this.roleMenuLinkService.remove(Wrappers.lambdaQuery(RoleMenuLink.class).eq(RoleMenuLink::getRoleId, id));
         this.roleService.removeById(id);
      });
      this.sysRoleLookPermissionConfigService
         .remove(Wrappers.lambdaQuery(SysRoleLookPermissionConfig.class).in(SysRoleLookPermissionConfig::getSysRoleId, ids));
      GeneratorUserDetailService.USER_MAP.clear();
      return true;
   }

   @Override
   public List<ProjectUserLinkDTO> listUserByRole(Long roleId) {
      Role role = this.roleService.getById(roleId);
      Preconditions.checkArgument(role != null, "角色不存在！");
      return this.userRoleLinkService.listUserByRoleLink(roleId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateRoleAndUser(RoleAndUserUpdateDTO dto) {
      Role role = this.roleService.getById(dto.getRoleId());
      Preconditions.checkArgument(role != null, "角色不存在");
      Preconditions.checkArgument(!"admin".equals(role.getPermission()), "禁止修改超级管理员角色!");
      this.userRoleLinkService.remove(Wrappers.lambdaQuery(UserRoleLink.builder().roleId(dto.getRoleId()).build()));
      if (CollectionUtils.isNotEmpty(dto.getUserIds())) {
         List<UserRoleLink> userRoleLinkList = this.userRoleLinkService
            .list(Wrappers.lambdaQuery(UserRoleLink.class).in(UserRoleLink::getUserId, dto.getUserIds()));
         Set<Long> roleIds = userRoleLinkList.stream().map(UserRoleLink::getRoleId).collect(Collectors.toSet());
         Map<Long, String> roleIdNameMap = roleIds.isEmpty()
            ? Collections.emptyMap()
            : this.roleService.listByIds(roleIds).stream().collect(Collectors.toMap(Role::getId, Role::getName));
         Map<Long, List<String>> userIdRoleNameListMap = userRoleLinkList.stream()
            .collect(Collectors.groupingBy(UserRoleLink::getUserId, Collectors.mapping(link -> roleIdNameMap.get(link.getRoleId()), Collectors.toList())));
         Map<Long, User> userMap = this.userService.listByIds(dto.getUserIds()).stream().collect(Collectors.toMap(User::getId, Function.identity()));
         List<UserRoleLink> newUserRoleLinkList = new ArrayList<>(dto.getUserIds().size() * 2);
         dto.getUserIds().forEach(userId -> {
            User user = userMap.get(userId);
            Preconditions.checkArgument(user != null, "用户不存在!");
            List<String> roleNameList = userIdRoleNameListMap.getOrDefault(userId, Collections.emptyList());
            Preconditions.checkArgument(!"超级管理员".equals(user.getName()) && !roleNameList.contains("超级管理员"), "超级管理员不可添加该角色!");
            UserRoleLink newUserRoleLink = UserRoleLink.builder().userId(userId).roleId(dto.getRoleId()).build();
            newUserRoleLinkList.add(newUserRoleLink);
         });
         this.userRoleLinkService.saveBatch(newUserRoleLinkList);
      }

      GeneratorUserDetailService.USER_MAP.clear();
      return true;
   }

   @Override
   public RoleDeptUserResponseVO getUserByRole(Long roleId) {
      Role role = this.roleService.getById(roleId);
      Preconditions.checkArgument(role != null, "角色不存在");
      RoleDeptUserResponseVO roleDeptUserResponseVO = RoleDeptUserResponseVO.builder().roleId(roleId).roleName(role.getName()).build();
      List<UserRoleLink> userRoleLinks = this.userRoleLinkService.list((Wrapper<UserRoleLink>)new LambdaQueryWrapper<UserRoleLink>().eq(UserRoleLink::getRoleId, roleId));
      if (CollectionUtils.isNotEmpty(userRoleLinks)) {
         List<Long> userIds = userRoleLinks.stream().map(UserRoleLink::getUserId).collect(Collectors.toList());
         List<User> users = this.userService.listByIds(userIds);
         Preconditions.checkArgument(userIds.size() == users.size(), "用户不存在");
         Map<Long, List<User>> userMap = users.stream()
            .collect(Collectors.toMap(User::getDepartmentId, y -> new ArrayList<>(Collections.singleton((User)y)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         List<UserDeptResponseVO> userDeptResponseVOList = new ArrayList<>(16);
         userMap.forEach((deptId, userList) -> {
            Department department = this.departmentService.getById(deptId);
            Preconditions.checkArgument(department != null, "部门不存在");
            UserDeptResponseVO userDeptResponseVO = UserDeptResponseVO.builder().deptId(department.getId()).deptName(department.getName()).build();
            List<UserJobResponseVO> userJobResponseVOS = new ArrayList<>(16);

            for (User user : userList) {
               UserJobResponseVO userJobResponseVO = UserJobResponseVO.builder().userId(user.getId()).userName(user.getName()).build();
               userJobResponseVOS.add(userJobResponseVO);
            }

            userDeptResponseVO.setUserJobResponseVOList(userJobResponseVOS);
            userDeptResponseVOList.add(userDeptResponseVO);
         });
         roleDeptUserResponseVO.setUserDeptResponseVOList(userDeptResponseVOList);
      }

      return roleDeptUserResponseVO;
   }

   @Override
   public void roleExport(HttpServletResponse response) {
      try {
         List<Role> roles = this.roleService.list();
         Map<String, Object> map = new HashMap<>(32);
         if (CollectionUtils.isNotEmpty(roles)) {
            List<Map<String, Object>> roleList = new ArrayList<>();
            Map<Long, List<UserRoleLink>> userRoleLinkMap = this.userRoleLinkService
               .list(new LambdaQueryWrapper<>())
               .stream()
               .collect(Collectors.toMap(UserRoleLink::getRoleId, y -> new ArrayList<>(Collections.singleton((UserRoleLink)y)), (oldList, newList) -> {
                  oldList.addAll(newList);
                  return oldList;
               }));

            for (int i = 0; i < roles.size(); i++) {
               Map<String, Object> roleMap = new HashMap<>();
               roleMap.put("roleName", roles.get(i).getName());
               roleMap.put("id", i + 1);
               List<Map<String, Object>> deptList = new ArrayList<>();
               List<UserRoleLink> userRoleLinks = userRoleLinkMap.get(roles.get(i).getId());
               if (CollectionUtils.isNotEmpty(userRoleLinks)) {
                  List<Long> userIds = userRoleLinks.stream().map(UserRoleLink::getUserId).collect(Collectors.toList());
                  List<User> users = this.userService.listByIds(userIds);
                  Preconditions.checkArgument(userIds.size() == users.size(), "用户不存在");
                  Map<Long, List<User>> userMap = users.stream()
                     .collect(Collectors.toMap(User::getDepartmentId, y -> new ArrayList<>(Collections.singleton((User)y)), (oldList, newList) -> {
                        oldList.addAll(newList);
                        return oldList;
                     }));
                  userMap.forEach((deptId, userList) -> {
                     Map<String, Object> userDeptMap = new HashMap<>();
                     if (deptId != null) {
                        Department department = this.departmentService.getById(deptId);
                        Preconditions.checkArgument(department != null, "部门不存在");
                        userDeptMap.put("deptName", department.getName());
                     }

                     String userNames = userList.stream().map(User::getName).collect(Collectors.joining(","));
                     userDeptMap.put("userNames", userNames);
                     deptList.add(userDeptMap);
                  });
                  roleMap.put("deptList", deptList);
               }

               roleList.add(roleMap);
            }

            map.put("roleList", roleList);
         }

         String tempFileName = "roleAnduser";
         String resourcePath = "template/roleAnduser.xlsx";
         String exportFileName = "角色用户信息表.xlsx";
         Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, map);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
      } catch (Throwable $ex) {
         throw RoleBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   public RoleBizImpl(
      final UserRoleLinkService userRoleLinkService,
      final RoleMenuLinkService roleMenuLinkService,
      final UserService userService,
      final DepartmentService departmentService,
      final RoleService roleService,
      final SysRoleLookPermissionConfigService sysRoleLookPermissionConfigService
   ) {
      this.userRoleLinkService = userRoleLinkService;
      this.roleMenuLinkService = roleMenuLinkService;
      this.userService = userService;
      this.departmentService = departmentService;
      this.roleService = roleService;
      this.sysRoleLookPermissionConfigService = sysRoleLookPermissionConfigService;
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
