package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.project.core.api.pojo._do.ProjectVisaReason;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectVisaReasonDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectVisaReasonDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectVisaReasonService;
import com.hzchum.scim.project.core.mapper.ProjectVisaReasonMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectVisaReasonServiceImpl extends ServiceImpl<ProjectVisaReasonMapper, ProjectVisaReason> implements ProjectVisaReasonService {
   @Override
   public List<ProjectVisaReasonDTO> listVisaReason(String name) {
      List<ProjectVisaReason> visaReasonList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ProjectVisaReason.class).like(name != null, ProjectVisaReason::getName, name));
      return visaReasonList.stream().map(r -> BeanUtil.copy(r, ProjectVisaReasonDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveVisaReason(List<ProjectVisaReasonDTOParam> params) {
      params.forEach(param -> {
         int count = this.baseMapper.selectCount(Wrappers.lambdaQuery(ProjectVisaReason.class).eq(ProjectVisaReason::getName, param.getName()));
         Preconditions.checkArgument(count == 0, "新增失败,签证原因已存在");
         ProjectVisaReason reason = ProjectVisaReason.builder().name(param.getName()).build();
         this.baseMapper.insert(reason);
      });
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateVisaReason(ProjectVisaReasonDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "签证原因id不能为空");
      ProjectVisaReason reason = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(reason != null, "签证原因不存在");
      if (!reason.getName().equals(param.getName())) {
         int count = this.baseMapper.selectCount(Wrappers.lambdaQuery(ProjectVisaReason.class).eq(ProjectVisaReason::getName, param.getName()));
         Preconditions.checkArgument(count == 0, "修改失败,该签证原因已存在");
      }

      BeanUtil.copy(param, reason);
      this.baseMapper.updateById(reason);
      return true;
   }
}
