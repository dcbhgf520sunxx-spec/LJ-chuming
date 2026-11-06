package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.project.core.api.biz.ProjectQhseProblemTypeBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblemType;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemTypeService;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectQhseProblemTypeBizImpl implements ProjectQhseProblemTypeBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseProblemTypeBizImpl.class);
   @Resource
   private ProjectQhseProblemTypeService qhseProblemTypeService;
   @Resource
   private ProjectQhseProblemService qhseProblemService;

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         ProjectQhseProblemType problemType = this.qhseProblemTypeService.getById(id);
         Preconditions.checkArgument(problemType != null, "删除失败,问题类型不存在");
         int count = this.qhseProblemService.count(Wrappers.lambdaQuery(ProjectQhseProblem.class).eq(ProjectQhseProblem::getProblemTypeId, id));
         Preconditions.checkArgument(count == 0, "删除失败,问题类型正在使用");
         this.qhseProblemTypeService.removeById(id);
      });
      return true;
   }
}
