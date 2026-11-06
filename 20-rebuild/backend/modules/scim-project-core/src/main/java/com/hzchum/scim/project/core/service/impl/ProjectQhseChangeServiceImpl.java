package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseChange;
import com.hzchum.scim.project.core.api.service.ProjectQhseChangeService;
import com.hzchum.scim.project.core.mapper.ProjectQhseChangeMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectQhseChangeServiceImpl extends ServiceImpl<ProjectQhseChangeMapper, ProjectQhseChange> implements ProjectQhseChangeService {
   @Override
   public List<ProjectQhseChange> listProblemChange(Long problemId, Integer auditStatus) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ProjectQhseChange.class)
               .eq(problemId != null, ProjectQhseChange::getProblemId, problemId)
               .eq(auditStatus != null, ProjectQhseChange::getAuditStatus, auditStatus)
         );
   }
}
