package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.biz.ProjectConstructionDataBiz;
import com.hzchum.scim.project.core.api.enums.FileFormatTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectConstructionData;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectConstructionDataDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ConstructionDataQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ConstructionDataSaveDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectConstructionDataService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProjectConstructionDataBizImpl implements ProjectConstructionDataBiz {
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectConstructionDataService constructionDataService;
   @Resource
   private ContractProjectService projectService;

   @Override
   public PageVO<ProjectConstructionDataDTO> list(ConstructionDataQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectConstructionData> dataList = this.constructionDataService
         .list(
            Wrappers.lambdaQuery(ProjectConstructionData.class)
               .eq(param.getProjectId() != null, ProjectConstructionData::getProjectId, param.getProjectId())
               .eq(param.getConstructionStageType() != null, ProjectConstructionData::getConstructionStageType, param.getConstructionStageType())
               .eq(param.getFileFormatType() != null, ProjectConstructionData::getFileFormatType, param.getFileFormatType())
               .like(param.getFileName() != null, ProjectConstructionData::getFileName, param.getFileName())
               .like(param.getUserName() != null, ProjectConstructionData::getUserName, param.getUserName())
               .eq(param.getCreateTime() != null, BaseEntity::getCreateTime, param.getCreateTime())
               .orderByDesc(ProjectConstructionData::getId)
         );
      List<ProjectConstructionDataDTO> dataDTOList = dataList.stream()
         .map(s -> BeanUtil.copy(s, ProjectConstructionDataDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(dataDTOList, dataList));
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean uploadFile(MultipartFile file, ConstructionDataSaveDTOParam param) {
      this.projectService.checkProjectStatus(param.getProjectId());
      String originalFilename = file.getOriginalFilename();
      Preconditions.checkArgument(StringUtils.isNotBlank(originalFilename), "上传文件不合法");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Attachment attachment = this.attachmentService.uploadFile(file, AttachmentTypeEnum.DATA_CONSTRUCTION.getType(), param.getFileName());
      ProjectConstructionData constructionData = BeanUtil.copy(param, ProjectConstructionData.class);
      constructionData.setAttachmentId(attachment.getId());
      constructionData.setFileName(attachment.getName());
      constructionData.setFileFormatType(FileFormatTypeEnum.getTypeBySuffix(suffix));
      constructionData.setUserId(UserUtil.getCurrentUserId());
      constructionData.setUserName(UserUtil.getCurrentName());
      this.constructionDataService.save(constructionData);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean removeData(List<Long> ids) {
      ids.forEach(id -> {
         ProjectConstructionData data = this.constructionDataService.getById(id);
         Preconditions.checkArgument(data != null, "施工资料不存在");
         this.constructionDataService.removeById(data.getId());
         this.attachmentService.deleteFile(data.getAttachmentId());
      });
      return true;
   }
}
