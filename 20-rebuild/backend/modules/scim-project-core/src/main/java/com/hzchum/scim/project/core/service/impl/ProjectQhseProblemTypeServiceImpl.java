package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblemType;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemTypeDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemTypeDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemTypeService;
import com.hzchum.scim.project.core.mapper.ProjectQhseProblemTypeMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectQhseProblemTypeServiceImpl
   extends ServiceImpl<ProjectQhseProblemTypeMapper, ProjectQhseProblemType>
   implements ProjectQhseProblemTypeService {
   @Override
   public List<ProjectQhseProblemTypeDTO> listTypes(String name) {
      return this.baseMapper
         .selectList(Wrappers.lambdaQuery(ProjectQhseProblemType.class).like(name != null, ProjectQhseProblemType::getName, name))
         .stream()
         .map(s -> BeanUtil.copy(s, ProjectQhseProblemTypeDTO.class))
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveList(List<ProjectQhseProblemTypeDTOParam> params) {
      params.forEach(
         param -> {
            int count = this.baseMapper
               .selectCount(Wrappers.lambdaQuery(ProjectQhseProblemType.class).eq(ProjectQhseProblemType::getName, param.getName().trim()));
            Preconditions.checkArgument(count == 0, "新增失败,名称出现重复");
            ProjectQhseProblemType problemType = ProjectQhseProblemType.builder().name(param.getName().trim()).build();
            this.baseMapper.insert(problemType);
         }
      );
      return true;
   }

   @Override
   public Boolean updateType(ProjectQhseProblemTypeDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "修改失败,问题类型ID不能为空");
      ProjectQhseProblemType problemType = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(problemType != null, "修改失败,问题类型不存在");
      if (!param.getName().trim().equals(problemType.getName())) {
         int count = this.baseMapper
            .selectCount(Wrappers.lambdaQuery(ProjectQhseProblemType.class).eq(ProjectQhseProblemType::getName, param.getName().trim()));
         Preconditions.checkArgument(count == 0, "新增失败,名称出现重复");
      }

      problemType.setName(param.getName().trim());
      this.baseMapper.updateById(problemType);
      return true;
   }
}
