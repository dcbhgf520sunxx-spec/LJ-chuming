package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.enums.BoolChangeStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectQhseProblemDO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.mapper.ProjectQhseProblemMapper;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectQhseProblemServiceImpl extends ServiceImpl<ProjectQhseProblemMapper, ProjectQhseProblem> implements ProjectQhseProblemService {
   @Override
   public List<ProjectQhseProblemDO> listQhseProblem(QhseProblemQueryDTOParam param) {
      return this.baseMapper.selectQhseProblemList(param);
   }

   @Override
   public BigDecimal getPenaltySum(Long subcontractOrderId, Boolean boolDeductStatus) {
      List<ProjectQhseProblem> problemList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .eq(ProjectQhseProblem::getSubcontractOrderId, subcontractOrderId)
               .eq(ProjectQhseProblem::getBoolChangeStatus, BoolChangeStatusEnum.CHANGED.isType())
               .eq(boolDeductStatus != null, ProjectQhseProblem::getBoolDeductStatus, boolDeductStatus)
         );
      return problemList.stream().map(ProjectQhseProblem::getPenalty).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<ProjectQhseProblem> listByCondition(Long projectId, Long supplierId, Long problemTypeId, Boolean boolChangeStatus) {
      return this.baseMapper.selectByCondition(projectId, supplierId, problemTypeId, boolChangeStatus);
   }

   @Override
   public int countNumber(Long projectId) {
      return this.baseMapper.countNumber(projectId);
   }
}
