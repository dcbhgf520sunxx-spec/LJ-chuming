package com.hzchum.scim.project.core.biz.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.biz.ProjectImageProgressBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectImageProgress;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectImageProgressDTO;
import com.hzchum.scim.project.core.api.service.ProjectImageProgressService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectImageProgressBizImpl implements ProjectImageProgressBiz {
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectImageProgressService imageProgressService;
   @Resource
   private ContractProjectService projectService;

   @Override
   public PageVO<AttachmentDTO> listImageAttachment(Long projectId, String yearMonth, String date, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectImageProgress> list = this.imageProgressService.listImageProgress(projectId, yearMonth, date);
      List<AttachmentDTO> attachmentDTOList = list.stream().map(s -> this.attachmentService.getById(s.getAttachmentId())).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(attachmentDTOList, list));
   }

   @Override
   public List<ProjectImageProgressDTO> list(Long projectId, String yearMonth) {
      List<ProjectImageProgressDTO> progressDTOList = this.imageProgressService.listByCondition(projectId, yearMonth);
      progressDTOList.forEach(
         dto -> {
            List<AttachmentDTO> attachmentDTOList = this.imageProgressService
               .listImageProgress(projectId, yearMonth, dto.getDate())
               .stream()
               .map(i -> this.attachmentService.getById(i.getAttachmentId()))
               .collect(Collectors.toList());
            dto.setAttachments(attachmentDTOList);
         }
      );
      return progressDTOList;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveImage(Long projectId, List<Long> attachmentIds) {
      attachmentIds.forEach(attachmentId -> {
         AttachmentDTO attachmentDTO = this.attachmentService.getById(attachmentId);
         Preconditions.checkArgument(attachmentDTO != null, "附件或图片不存在");
         ProjectImageProgress imageProgress = ProjectImageProgress.builder().projectId(projectId).attachmentId(attachmentId).build();
         this.imageProgressService.save(imageProgress);
      });
      return true;
   }
}
