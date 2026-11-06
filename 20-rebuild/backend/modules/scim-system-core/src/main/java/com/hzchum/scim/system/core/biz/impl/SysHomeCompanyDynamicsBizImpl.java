package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.system.core.api.biz.SysHomeCompanyDynamicsBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeCompanyDynamics;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCompanyDynamicsDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCompanyDynamicsPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeCompanyDynamicsSaveParam;
import com.hzchum.scim.system.core.api.service.SysHomeCompanyDynamicsService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.SysHomeCompanyDynamicsMapper;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysHomeCompanyDynamicsBizImpl
   extends IBizImpl<SysHomeCompanyDynamicsService, SysHomeCompanyDynamicsMapper, SysHomeCompanyDynamics>
   implements SysHomeCompanyDynamicsBiz {
   @Resource
   private UserService userService;
   @Resource
   private SysHomeCompanyDynamicsService sysHomeCompanyDynamicsService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ConfigProperties configProperties;

   @Transactional
   @Override
   public Boolean saveSysHomeCompanyDynamics(SysHomeCompanyDynamicsSaveParam param) {
      SysHomeCompanyDynamics sysHomeCompanyDynamics = BeanUtil.copy(param, SysHomeCompanyDynamics.class);
      sysHomeCompanyDynamics.setCreateUserId(UserUtil.getCurrentUserId());
      sysHomeCompanyDynamics.setCreateUserName(UserUtil.getCurrentName());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         sysHomeCompanyDynamics.setAttachmentIds(
            StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
         );
      }

      this.baseService.save(sysHomeCompanyDynamics);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean deleteSysHomeCompanyDynamics(Long id) {
      SysHomeCompanyDynamics sysHomeCompanyDynamics = this.baseService.getById(id);
      Preconditions.checkArgument(sysHomeCompanyDynamics != null, "动态id不存在");
      this.baseService.removeById(id);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public SysHomeCompanyDynamicsDetailDTO sysHomeCompanyDynamicsDetailDTO(Long id) {
      SysHomeCompanyDynamics sysHomeCompanyDynamics = this.baseService.getById(id);
      Preconditions.checkArgument(sysHomeCompanyDynamics != null, "动态id不存在");
      SysHomeCompanyDynamicsDetailDTO sysHomeCompanyDynamicsDetailDTO = BeanUtil.copy(sysHomeCompanyDynamics, SysHomeCompanyDynamicsDetailDTO.class);
      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(sysHomeCompanyDynamicsDetailDTO.getAttachmentIds())) {
         sysHomeCompanyDynamicsDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(sysHomeCompanyDynamicsDetailDTO.getAttachmentIds()));
      }

      return sysHomeCompanyDynamicsDetailDTO;
   }

   @Transactional
   @Override
   public PageVO<SysHomeCompanyDynamicsPageDTO> getSysHomeCompanyDynamicsPage(
      LocalDateTime informantDateTime, String createUserName, String title, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      if (informantDateTime != null) {
         List<SysHomeCompanyDynamics> sysHomeCompanyDynamics = this.list(
            Wrappers.lambdaQuery(SysHomeCompanyDynamics.class)
               .apply(informantDateTime != null, "date_format(informant_date_time, '%Y') = {0}", informantDateTime.format(DateTimeFormatter.ofPattern("yyyy")))
               .eq(title != null, SysHomeCompanyDynamics::getTitle, title)
               .like(StringUtils.isNotBlank(createUserName), SysHomeCompanyDynamics::getCreateUserName, createUserName)
               .orderByDesc(SysHomeCompanyDynamics::getInformantDateTime)
         );
         Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         return new PageVO<>(
            objects,
            sysHomeCompanyDynamics.stream()
               .map(
                  item -> {
                     SysHomeCompanyDynamicsPageDTO sysHomeCompanyDynamicsPageDTO = BeanUtil.copy(item, SysHomeCompanyDynamicsPageDTO.class);
                     if (sysHomeCompanyDynamicsPageDTO.getCreateUserName() != null) {
                        sysHomeCompanyDynamicsPageDTO.setCreateUserName(
                           userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                        );
                     }

                     if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                        sysHomeCompanyDynamicsPageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
                     }

                     return sysHomeCompanyDynamicsPageDTO;
                  }
               )
               .collect(Collectors.toList())
         );
      } else {
         List<SysHomeCompanyDynamics> sysHomeCompanyDynamics = this.list(
            Wrappers.lambdaQuery(SysHomeCompanyDynamics.class)
               .eq(title != null, SysHomeCompanyDynamics::getTitle, title)
               .like(StringUtils.isNotBlank(createUserName), SysHomeCompanyDynamics::getCreateUserName, createUserName)
               .orderByDesc(SysHomeCompanyDynamics::getInformantDateTime)
         );
         Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         return new PageVO<>(
            objects,
            sysHomeCompanyDynamics.stream()
               .map(
                  item -> {
                     SysHomeCompanyDynamicsPageDTO sysHomeCompanyDynamicsPageDTO = BeanUtil.copy(item, SysHomeCompanyDynamicsPageDTO.class);
                     if (sysHomeCompanyDynamicsPageDTO.getCreateUserName() != null) {
                        sysHomeCompanyDynamicsPageDTO.setCreateUserName(
                           userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                        );
                     }

                     if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                        sysHomeCompanyDynamicsPageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
                     }

                     return sysHomeCompanyDynamicsPageDTO;
                  }
               )
               .collect(Collectors.toList())
         );
      }
   }

   @Override
   public void downloadAttachment(DownloadAttachmentCommonDTO dto, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(dto.getAttachmentDTOList())) {
         List<AttachmentDTO> attachmentDTOS = this.attachmentService
            .listByIdList(dto.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()));
         if (CollectionUtils.isNotEmpty(attachmentDTOS)) {
            String filePath = this.configProperties.getFilePath();
            String fileName1 = filePath + "公司动态-" + System.currentTimeMillis();
            File[] files = new File[attachmentDTOS.size()];
            String zipPath = fileName1 + ".zip";

            for (int i = 0; i < attachmentDTOS.size(); i++) {
               files[i] = new File(filePath + attachmentDTOS.get(i).getRelativePath());
            }

            File file = new File(zipPath);
            ZipUtil.zip(file, Boolean.FALSE, files);
            FileUtil.downloadFile(zipPath);
            file.delete();
         }
      }
   }
}
