package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectQhseProblemDO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface ProjectQhseProblemService extends IService<ProjectQhseProblem> {
   List<ProjectQhseProblemDO> listQhseProblem(QhseProblemQueryDTOParam param);

   BigDecimal getPenaltySum(Long subcontractOrderId, Boolean boolDeductStatus);

   List<ProjectQhseProblem> listByCondition(Long projectId, Long supplierId, Long problemTypeId, Boolean boolChangeStatus);

   int countNumber(Long projectId);
}
