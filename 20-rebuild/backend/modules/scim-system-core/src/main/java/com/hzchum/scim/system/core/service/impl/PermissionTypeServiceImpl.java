package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.PermissionType;
import com.hzchum.scim.system.core.api.pojo.request.PermissionTypeSaveVO;
import com.hzchum.scim.system.core.api.pojo.request.PermissionTypeUpdateVO;
import com.hzchum.scim.system.core.api.service.PermissionTypeService;
import com.hzchum.scim.system.core.mapper.MenuMapper;
import com.hzchum.scim.system.core.mapper.PermissionTypeMapper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermissionTypeServiceImpl extends ServiceImpl<PermissionTypeMapper, PermissionType> implements PermissionTypeService {
   @Resource
   private MenuMapper menuMapper;

   @Override
   public PageVO<PermissionType> listByBlurryName(String blurryName, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(
         this.baseMapper.selectList(Wrappers.lambdaQuery(PermissionType.class).like(StringUtils.isNotBlank(blurryName), PermissionType::getName, blurryName))
      );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean deletePermissionType(List<Long> ids) {
      ids.forEach(id -> {
         PermissionType permissionType = this.baseMapper.selectById(id);
         Preconditions.checkArgument(permissionType != null, "更新失败，传入id对应的权限类型不存在");
         Integer countNumber = this.menuMapper.countByPermissionTypeId(id);
         Preconditions.checkArgument(countNumber == 0, "删除失败，这个权限类型正在被使用");
         this.baseMapper.deleteById(id);
      });
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updatePermissionType(PermissionTypeUpdateVO requestVO) {
      PermissionType permissionType = this.baseMapper.selectById(requestVO.getId());
      Preconditions.checkArgument(permissionType != null, "更新失败，传入id对应的权限类型不存在");
      if (!requestVO.getName().equals(permissionType.getName())) {
         Integer count = this.baseMapper.selectCount(Wrappers.lambdaQuery(PermissionType.class).eq(PermissionType::getName, requestVO.getName()));
         Preconditions.checkArgument(count == 0, "更新失败，权限类型名称已存在");
      }

      BeanUtil.copy(requestVO, permissionType);
      return this.baseMapper.updateById(permissionType) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long savePermissionType(PermissionTypeSaveVO saveVO) {
      Integer count = this.baseMapper.selectCount(Wrappers.lambdaQuery(PermissionType.class).eq(PermissionType::getName, saveVO.getName()));
      Preconditions.checkArgument(count == 0, "保存失败，权限类型名称已存在");
      PermissionType permissionType = BeanUtil.copy(saveVO, PermissionType.class);
      this.baseMapper.insert(permissionType);
      return permissionType.getId();
   }

   @Override
   public ListVO<PermissionType> listAll() {
      return new ListVO<>(this.baseMapper.selectList(Wrappers.lambdaQuery(PermissionType.class).orderByAsc(PermissionType::getSort)));
   }
}
