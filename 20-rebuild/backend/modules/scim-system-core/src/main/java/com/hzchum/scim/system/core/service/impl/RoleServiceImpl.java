package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.common.utils.ArgumentCheckUtils;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo.dto.RoleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleSaveVO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleUpdateVO;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.mapper.RoleMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
   @Override
   public List<RoleDTO> listByCondition(String name) {
      return this.baseMapper.selectByCondition(name);
   }

   @Override
   public ListVO<Role> listRole(String name) {
      return new ListVO<>(this.baseMapper.selectList(Wrappers.lambdaQuery(Role.class).like(name != null, Role::getName, name).orderByAsc(Role::getSort)));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long saveRole(RoleSaveVO saveVO) {
      Preconditions.checkArgument(!"超级管理员".equals(saveVO.getName()), "添加角色失败，不能和系统默认提供的角色名称重复");
      int count = this.baseMapper.selectCount(Wrappers.lambdaQuery(Role.class).eq(Role::getName, saveVO.getName()));
      Preconditions.checkArgument(count == 0, "已有该名称的角色了");
      Role role = BeanUtil.copy(saveVO, Role.class);
      role.setIsDefault(false);
      this.baseMapper.insert(role);
      GeneratorUserDetailService.USER_MAP.clear();
      return role.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateRole(RoleUpdateVO requestVO) {
      Role role = this.baseMapper.selectById(requestVO.getId());
      ArgumentCheckUtils.checkNonNull(role, "对应的角色不存在");
      Preconditions.checkArgument(!role.getIsDefault(), "更新失败，禁止修改系统默认角色");
      Preconditions.checkArgument(!"超级管理员".equals(requestVO.getName()), "更新失败，不能和系统默认的角色名重复");
      if (!Objects.equals(requestVO.getName(), role.getName())) {
         int count = this.baseMapper.selectCount(Wrappers.lambdaQuery(Role.class).eq(Role::getName, requestVO.getName()));
         Preconditions.checkArgument(count == 0, "已有该名称的角色了");
      }

      BeanUtil.copy(requestVO, role);
      this.baseMapper.updateById(role);
      GeneratorUserDetailService.USER_MAP.clear();
      return true;
   }

   @Override
   public Role getByName(String name) {
      return this.baseMapper.selectOne((Wrapper<Role>)Wrappers.<Role>lambdaQuery().eq(Role::getName, name));
   }

   @Override
   public List<Role> listByUserId(Long userId) {
      return this.baseMapper.listByUserId(userId);
   }
}
