package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.ZIPUtils;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspection;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDTO;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionDTOParam;
import com.hzchum.scim.system.core.api.service.ProjectInspectionService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectInspectionBizImpl extends IBizImpl<ProjectInspectionService, ProjectInspectionMapper, ProjectInspection> implements ProjectInspectionBiz {
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private ProjectInspectionUserLinkService projectInspectionUserLinkService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private AttachmentService attachmentService;

   @Override
   public boolean saveInspection(ProjectInspectionDTOParam projectInspectionParam) {
      Preconditions.checkArgument(projectInspectionParam.getName() != null, "巡检点名称不可为空");
      this.checkProjectInspectionParam(projectInspectionParam);
      ProjectInspection projectInspection = this.getOne(
         Wrappers.lambdaQuery(ProjectInspection.class).eq(ProjectInspection::getName, projectInspectionParam.getName())
      );
      Preconditions.checkArgument(projectInspection == null, "巡检点已存在");
      this.save(BeanUtil.copy(projectInspectionParam, ProjectInspection.class).setStatus(1).setCreateUserId(UserUtil.getCurrentUserId()));
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateInspectionStatus(Long id) {
      Preconditions.checkArgument(id != null, "巡检点id不可为空");
      ProjectInspection projectInspection = this.getById(id);
      Preconditions.checkArgument(projectInspection != null, "巡检点不存在");
      projectInspection.setStatus(projectInspection.getStatus() == 1 ? 0 : 1);
      this.updateById(projectInspection);
      this.projectInspectionUserLinkService
         .lambdaUpdate()
         .eq(ProjectInspectionUserLink::getProjectInspectionId, id)
         .set(ProjectInspectionUserLink::getStatus, projectInspection.getStatus())
         .update();
      return true;
   }

   @Override
   public boolean updateInspection(ProjectInspectionDTOParam projectInspectionParam) {
      this.checkProjectInspectionParam(projectInspectionParam);
      ProjectInspection projectInspection = this.getById(projectInspectionParam.getId());
      Preconditions.checkArgument(projectInspection != null, "巡检点不存在");
      Preconditions.checkArgument(
         UserUtil.getCurrentUser().isAdmin() || UserUtil.getCurrentUserId().equals(projectInspection.getCreateUserId()), "只有创建人和超管可以修改!"
      );
      BeanUtil.copy(projectInspectionParam, projectInspection);
      this.updateById(projectInspection);
      return true;
   }

   private void checkProjectInspectionParam(ProjectInspectionDTOParam projectInspectionParam) {
      Preconditions.checkArgument(StringUtils.isNotBlank(projectInspectionParam.getPoint()), "请先配置巡检点位");
      Preconditions.checkArgument(projectInspectionParam.getPoint().split(",").length == 2, "点位格式错误,请联系管理人员");
      Preconditions.checkArgument(projectInspectionParam.getAroundRadius() != null, "请先配置巡检点位半径");
      Preconditions.checkArgument(
         projectInspectionParam.getAroundRadius() > 0L && projectInspectionParam.getAroundRadius() < 10000L, "点位半径异常请重新配置，半径范围 1 ~ 10000 米"
      );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean deleteInspection(Long id) {
      ProjectInspection projectInspection = this.getById(id);
      Preconditions.checkArgument(projectInspection != null, "巡检点不存在");
      List<ProjectInspectionUserLink> projectInspectionUserLinkList = this.projectInspectionUserLinkService
         .list(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionId, id));
      Preconditions.checkArgument(CollectionUtils.isEmpty(projectInspectionUserLinkList), "巡检点已被安排线路不可修改");
      Preconditions.checkArgument(
         UserUtil.getCurrentUser().isAdmin() || UserUtil.getCurrentUserId().equals(projectInspection.getCreateUserId()), "只有创建人和超管可以删除!"
      );
      this.projectInspectionUserLinkService
         .remove(Wrappers.lambdaQuery(ProjectInspectionUserLink.class).eq(ProjectInspectionUserLink::getProjectInspectionId, id));
      this.removeById(projectInspection.getId());
      return true;
   }

   @Override
   public PrintVO printQrCode(Long id) {
      PrintVO printVO = new PrintVO();
      ProjectInspection projectInspection = this.getById(id);
      Preconditions.checkArgument(projectInspection != null, "巡检点不存在");
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("inspectionName", projectInspection.getName());
      printVO.setHeader(header);
      printVO.setQrCode("128|4|" + id);
      List<Map<String, Object>> table = new ArrayList<>();
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public List<ProjectInspectionDTO> getPage() {
      List<ProjectInspection> list = this.list();
      return list.stream().map(item -> {
         ProjectInspectionDTO projectInspectionDTO = BeanUtil.copy(item, ProjectInspectionDTO.class);
         if (item.getAttachmentId() != null) {
            AttachmentDTO attachmentDTO = this.attachmentService.getById(item.getAttachmentId());
            projectInspectionDTO.setAttachmentDTO(attachmentDTO);
         }

         return projectInspectionDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public void printQrCodeList(Long projectId) {
      try {
         List<ProjectInspection> projectInspections = this.baseService.list();
         if (CollectionUtils.isNotEmpty(projectInspections)) {
            ContractProject project = this.contractProjectBiz.getById(projectId);
            String qrCode = "128|4|";
            String filePath = this.configProperties.getFilePath();
            String fileName = project.getShortName() + "-巡检点二维码";
            File file = new File(filePath + fileName);
            if (!file.exists()) {
               boolean mkdirs = file.mkdirs();
               Preconditions.checkArgument(mkdirs, "请联系管理员");
            }

            ZIPUtils.toZip(filePath + fileName + ".zip", filePath + fileName, true);
            FileUtil.downloadFile(filePath + fileName + ".zip");
            FileUtil.deleteFile(filePath + fileName + ".zip");
            FileUtil.deleteDir(filePath + fileName);
         }
      } catch (Throwable $ex) {
         throw ProjectInspectionBizImpl.<RuntimeException>rethrow($ex);
      }
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
