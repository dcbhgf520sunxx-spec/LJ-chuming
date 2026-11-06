package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.biz.ProjectQhseChangeBiz;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.project.core.api.enums.BoolChangeStatusEnum;
import com.hzchum.scim.project.core.api.enums.QhseStatusEnumV2;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseChange;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseChangeDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeAuditDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeSaveDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeUpdateDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectQhseChangeService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectQhseChangeBizImpl implements ProjectQhseChangeBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseChangeBizImpl.class);
   @Resource
   private ProjectQhseProblemService qhseProblemService;
   @Resource
   private ProjectQhseChangeService qhseChangeService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractProjectService projectService;

   @Override
   public PageVO<ProjectQhseChangeDTO> listProblemChange(Long problemId, Integer auditStatus, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseChange> qhseChangeList = this.qhseChangeService.listProblemChange(problemId, auditStatus);
      List<ProjectQhseChangeDTO> changeDTOList = qhseChangeList.stream().map(q -> {
         ProjectQhseChangeDTO changeDTO = BeanUtil.copy(q, ProjectQhseChangeDTO.class);
         changeDTO.setAfterChangeImgs(this.attachmentService.listByIds(q.getAfterChangeImgs()));
         return changeDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(changeDTOList, qhseChangeList));
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveChange(ProjectQhseChangeSaveDTOParam param) {
      ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(param.getProblemId());
      Preconditions.checkArgument(qhseProblem != null, "质安问题不存在");
      Preconditions.checkArgument(qhseProblem.getBoolChangeStatus().equals(BoolChangeStatusEnum.NOT_CHANGE.isType()), "质安问题已整改");
      int count = this.qhseChangeService.count(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, param.getProblemId()));
      Preconditions.checkArgument(count == 0, "问题已提交整改报告");
      ProjectQhseChange qhseChange = BeanUtil.copy(param, ProjectQhseChange.class);
      qhseChange.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      qhseChange.setAfterChangeImgs(StringUtils.join(param.getAfterChangeImgIds(), ","));
      this.qhseChangeService.save(qhseChange);
      return true;
   }

   @Transactional
   @Override
   public Boolean saveChangeV2(ProjectQhseChangeSaveDTOParam param) {
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(param.getProblemId());
      Preconditions.checkArgument(qhseProblem != null, "质安问题不存在");
      Preconditions.checkArgument(qhseProblem.getUserId().equals(currentUserId), "操作失败，您不是质安问题责任人！");
      Preconditions.checkArgument(QhseStatusEnumV2.NO_REPLY.getType().equals(qhseProblem.getBoolChangeStatusV2()), "操作失败，质安问题无需整改！请刷新重试！");
      ProjectQhseChange qhseChange = this.qhseChangeService
         .getOne(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, param.getProblemId()));
      if (qhseChange == null) {
         qhseChange = BeanUtil.copy(param, ProjectQhseChange.class);
         qhseChange.setAuditStatus(AuditStatusEnum.AUDITING.getType());
         qhseChange.setAfterChangeImgs(StringUtils.join(param.getAfterChangeImgIds(), ","));
         this.qhseChangeService.save(qhseChange);
         qhseProblem.setBoolChangeStatusV2(QhseStatusEnumV2.REPLIED.getType());
         this.qhseProblemService.updateById(qhseProblem);
      } else {
         Preconditions.checkArgument(AuditStatusEnum.AUDITING.getType().equals(qhseChange.getAuditStatus()), "操作失败，整改报告已审核！");
         qhseChange.setProblemDesc(param.getProblemDesc());
         qhseChange.setAfterChangeImgs(StringUtils.join(param.getAfterChangeImgIds(), ","));
         this.qhseChangeService.updateById(qhseChange);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateChange(ProjectQhseChangeUpdateDTOParam param) {
      ProjectQhseChange qhseChange = this.qhseChangeService.getById(param.getId());
      Preconditions.checkArgument(qhseChange != null, "整改报告不存在");
      Preconditions.checkArgument(!qhseChange.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "整改报告已审核通过");
      BeanUtil.copy(param, qhseChange);
      qhseChange.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.attachmentService.replaceAttachment(qhseChange.getAfterChangeImgs(), param.getAfterChangeImgIds());
      qhseChange.setAfterChangeImgs(StringUtils.join(param.getAfterChangeImgIds(), ","));
      this.qhseChangeService.updateById(qhseChange);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean checkChange(ProjectQhseChangeAuditDTOParam param) {
      Preconditions.checkArgument(
         param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType()), "审核状态有误"
      );
      ProjectQhseChange qhseChange = this.qhseChangeService.getById(param.getId());
      Preconditions.checkArgument(qhseChange != null, "审核失败,整改报告不存在");
      Preconditions.checkArgument(qhseChange.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "整改报告已审核");
      ProjectQhseProblem problem = this.qhseProblemService.getById(qhseChange.getProblemId());
      Preconditions.checkArgument(problem != null, "问题不存在");
      Preconditions.checkArgument(problem.getBoolChangeStatus().equals(false), "问题已整改");
      Preconditions.checkArgument(problem.getBoolReply().equals(true), "该问题不需要回复");
      qhseChange.setAuditStatus(param.getAuditStatus());
      if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(qhseChange.getProblemId());
         qhseProblem.setBoolChangeStatus(BoolChangeStatusEnum.CHANGED.isType());
         qhseProblem.setAfterChangeImgs(qhseChange.getAfterChangeImgs());
         this.qhseProblemService.updateById(qhseProblem);
      }

      this.qhseChangeService.updateById(qhseChange);
      return true;
   }

   @Transactional
   @Override
   public Boolean checkChangeV2(ProjectQhseChangeAuditDTOParam param) {
      Preconditions.checkArgument(
         param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType()), "审核状态有误"
      );
      ProjectQhseChange qhseChange = this.qhseChangeService.getById(param.getId());
      Preconditions.checkArgument(qhseChange != null, "操作失败,整改报告不存在");
      Preconditions.checkArgument(qhseChange.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "整改报告已审核");
      ProjectQhseProblem problem = this.qhseProblemService.getById(qhseChange.getProblemId());
      Preconditions.checkArgument(problem != null, "操作失败，问题不存在");
      Preconditions.checkArgument(problem.getBoolReply().equals(true), "操作失败，该问题不需要回复");
      Preconditions.checkArgument(QhseStatusEnumV2.REPLIED.getType().equals(problem.getBoolChangeStatusV2()), "操作失败，未回复或已关闭！");
      qhseChange.setAuditStatus(param.getAuditStatus());
      ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(qhseChange.getProblemId());
      qhseProblem.setAfterChangeImgs(qhseChange.getAfterChangeImgs());
      qhseProblem.setBoolChangeStatusV2(QhseStatusEnumV2.CLOSED.getType());
      this.qhseProblemService.updateById(qhseProblem);
      this.qhseChangeService.updateById(qhseChange);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean delete(Long id) {
      ProjectQhseChange qhseChange = this.qhseChangeService.getById(id);
      Preconditions.checkArgument(qhseChange != null, "整改报告不存在");
      Preconditions.checkArgument(!qhseChange.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "整改报告已审核");
      this.qhseChangeService.removeById(id);
      this.attachmentService.deleteIds(qhseChange.getAfterChangeImgs());
      return true;
   }
}
