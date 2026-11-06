package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectPaymentProblemLink;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import java.util.List;

public interface ProjectPaymentProblemLinkService extends IService<ProjectPaymentProblemLink> {
   void saveLink(Long paymentId, List<ProjectQhseProblem> problemList);
}
