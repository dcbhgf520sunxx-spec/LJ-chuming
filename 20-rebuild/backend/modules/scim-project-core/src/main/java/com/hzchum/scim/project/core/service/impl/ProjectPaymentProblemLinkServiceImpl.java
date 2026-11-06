package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectPaymentProblemLink;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.service.ProjectPaymentProblemLinkService;
import com.hzchum.scim.project.core.mapper.ProjectPaymentProblemLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectPaymentProblemLinkServiceImpl
   extends ServiceImpl<ProjectPaymentProblemLinkMapper, ProjectPaymentProblemLink>
   implements ProjectPaymentProblemLinkService {
   @Override
   public void saveLink(Long paymentId, List<ProjectQhseProblem> problemList) {
      problemList.forEach(
         problem -> {
            int count = this.baseMapper
               .selectCount(
                  Wrappers.lambdaQuery(ProjectPaymentProblemLink.class)
                     .eq(ProjectPaymentProblemLink::getProblemId, problem.getId())
                     .eq(ProjectPaymentProblemLink::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               );
            Preconditions.checkArgument(count == 0, "问题违约处罚金已扣除");
            ProjectPaymentProblemLink link = ProjectPaymentProblemLink.builder()
               .paymentId(paymentId)
               .problemId(problem.getId())
               .auditStatus(AuditStatusEnum.AUDITING.getType())
               .build();
            this.baseMapper.insert(link);
         }
      );
   }
}
