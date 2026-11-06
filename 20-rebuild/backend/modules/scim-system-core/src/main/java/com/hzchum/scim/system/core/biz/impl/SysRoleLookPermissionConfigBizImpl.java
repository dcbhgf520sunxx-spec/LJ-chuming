package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.SysRoleLookPermissionConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.SysRoleLookPermissionConfig;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.pojo.dto.SysRoleLookPermissionConfigDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysRoleLookPermissionConfigUpdateParam;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysRoleLookPermissionConfigService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.SysRoleLookPermissionConfigMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysRoleLookPermissionConfigBizImpl
   extends IBizImpl<SysRoleLookPermissionConfigService, SysRoleLookPermissionConfigMapper, SysRoleLookPermissionConfig>
   implements SysRoleLookPermissionConfigBiz {
   @Resource
   private UserRoleLinkService userRoleLinkService;
   @Resource
   private UserService userService;
   @Resource
   private DepartmentService departmentService;

   @Override
   public Set<Long> getCrmCanLookInfoDeptIdsByModuleAndUserId(Integer sysModuleTypeEnum, Long userId) {
      Set<Long> departIds = new HashSet<>();
      SecurityUser currentUser = UserUtil.getCurrentUser();
      if (currentUser.isAdmin()) {
         departIds.addAll(this.departmentService.getAllDepartmentList().stream().map(Department::getId).collect(Collectors.toSet()));
      }

      if (currentUser.getDepartment() != null && currentUser.getDepartment().getId() != null) {
         List<UserRoleLink> userRoleLinks = this.userRoleLinkService.list(Wrappers.lambdaQuery(UserRoleLink.class).eq(UserRoleLink::getUserId, userId));
         if (CollectionUtils.isEmpty(userRoleLinks)) {
            return departIds;
         }

         List<SysRoleLookPermissionConfig> sysRoleLookPermissionConfigs = this.baseService
            .list(
               Wrappers.lambdaQuery(SysRoleLookPermissionConfig.class)
                  .eq(SysRoleLookPermissionConfig::getSysModuleTypeEnum, sysModuleTypeEnum)
                  .in(SysRoleLookPermissionConfig::getSysRoleId, userRoleLinks.stream().map(UserRoleLink::getRoleId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isEmpty(sysRoleLookPermissionConfigs)) {
            return departIds;
         }

         Set<Boolean> allLookBooleans = sysRoleLookPermissionConfigs.stream()
            .filter(SysRoleLookPermissionConfig::getIsFullPermissions)
            .map(SysRoleLookPermissionConfig::getIsFullPermissions)
            .collect(Collectors.toSet());
         if (CollectionUtils.isNotEmpty(allLookBooleans)) {
            departIds.addAll(this.departmentService.getAllDepartmentList().stream().map(Department::getId).collect(Collectors.toSet()));
            return departIds;
         }

         Set<Boolean> thisDepartmentLookBooleans = sysRoleLookPermissionConfigs.stream()
            .filter(SysRoleLookPermissionConfig::getIsThisDepartment)
            .map(SysRoleLookPermissionConfig::getIsFullPermissions)
            .collect(Collectors.toSet());
         if (CollectionUtils.isNotEmpty(thisDepartmentLookBooleans)) {
            departIds.add(currentUser.getDepartment().getId());
         }

         Set<Boolean> isIndividualAndThisDept = sysRoleLookPermissionConfigs.stream()
            .filter(SysRoleLookPermissionConfig::getIsIndividualAndThisDept)
            .map(SysRoleLookPermissionConfig::getIsIndividualAndThisDept)
            .collect(Collectors.toSet());
         if (CollectionUtils.isNotEmpty(isIndividualAndThisDept)) {
            departIds.add(currentUser.getDepartment().getId());
         }

         Set<Boolean> subordinateDepartmentLookBooleans = sysRoleLookPermissionConfigs.stream()
            .filter(SysRoleLookPermissionConfig::getIsThisDepartmentAndSubordinateDepartments)
            .map(SysRoleLookPermissionConfig::getIsFullPermissions)
            .collect(Collectors.toSet());
         if (CollectionUtils.isNotEmpty(subordinateDepartmentLookBooleans)) {
            List<Long> subDepartmentIds = this.getDepartmentSimpleTree(currentUser.getDepartment().getId());
            departIds.addAll(subDepartmentIds);
            departIds.add(currentUser.getDepartment().getId());
         }

         sysRoleLookPermissionConfigs.forEach(item -> {
            if (StringUtils.isNotBlank(item.getDepartmentIds())) {
               List<Long> departmentIds = Arrays.stream(item.getDepartmentIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(departmentIds)) {
                  departIds.addAll(departmentIds);
               }
            }
         });
         if (departIds.size() == 1 && CollectionUtils.isNotEmpty(isIndividualAndThisDept)) {
            departIds.add(0L);
         }
      }

      return departIds;
   }

   @Transactional
   @Override
   public Boolean updateLookPermissionsByModuleAndRoleId(SysRoleLookPermissionConfigUpdateParam copy) {
      this.baseService
         .remove(
            Wrappers.lambdaQuery(SysRoleLookPermissionConfig.class)
               .eq(SysRoleLookPermissionConfig::getSysRoleId, copy.getSysRoleId())
               .eq(SysRoleLookPermissionConfig::getSysModuleTypeEnum, copy.getSysModuleTypeEnum())
         );
      SysRoleLookPermissionConfig sysRoleLookPermissionConfig = new SysRoleLookPermissionConfig();
      BeanUtil.copy(copy, sysRoleLookPermissionConfig);
      if (CollectionUtils.isNotEmpty(copy.getDepartmentIdList())) {
         sysRoleLookPermissionConfig.setDepartmentIds(copy.getDepartmentIdList().stream().map(String::valueOf).collect(Collectors.joining(",")));
      }

      this.baseService.save(sysRoleLookPermissionConfig);
      return Boolean.TRUE;
   }

   @Override
   public SysRoleLookPermissionConfigDTO getLookPermissionsByModuleAndRoleId(Integer sysModuleTypeEnum, Long roleId) {
      SysRoleLookPermissionConfig sysRoleLookPermissionConfig = this.baseService
         .getOne(
            Wrappers.lambdaQuery(SysRoleLookPermissionConfig.class)
               .eq(SysRoleLookPermissionConfig::getSysRoleId, roleId)
               .eq(SysRoleLookPermissionConfig::getSysModuleTypeEnum, sysModuleTypeEnum)
         );
      SysRoleLookPermissionConfigDTO sysRoleLookPermissionConfigDTO = new SysRoleLookPermissionConfigDTO();
      if (sysRoleLookPermissionConfig != null) {
         BeanUtil.copy(sysRoleLookPermissionConfig, sysRoleLookPermissionConfigDTO);
         if (StringUtils.isNotBlank(sysRoleLookPermissionConfig.getDepartmentIds())) {
            sysRoleLookPermissionConfigDTO.setDepartmentIds(
               Arrays.stream(sysRoleLookPermissionConfig.getDepartmentIds().split(",")).map(Long::valueOf).collect(Collectors.toList())
            );
         }
      }

      return sysRoleLookPermissionConfigDTO;
   }

   private List<Long> getDepartmentSimpleTree(Long id) {
      List<Department> departmentTree = this.departmentService.getAllDepartmentList();
      Map<Long, List<Department>> subjectMap = departmentTree.stream().collect(Collectors.groupingBy(Department::getPid));
      return this.build(id, subjectMap);
   }

   private List<Long> build(Long pid, Map<Long, List<Department>> deptMap) {
      List<Department> subDepartments = deptMap.get(pid);
      if (subDepartments != null && !subDepartments.isEmpty()) {
         List<Long> allSubIds = new ArrayList<>();

         for (Department department : subDepartments) {
            allSubIds.add(department.getId());
            allSubIds.addAll(this.build(department.getId(), deptMap));
         }

         return allSubIds;
      } else {
         return new ArrayList<>();
      }
   }
}
