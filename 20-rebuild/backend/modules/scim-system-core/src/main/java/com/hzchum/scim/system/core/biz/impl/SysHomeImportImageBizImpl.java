package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.system.core.api.biz.SysHomeImportImageBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeImportImage;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeImportImagePageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeImportImageSaveParam;
import com.hzchum.scim.system.core.api.service.SysHomeImportImageService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.SysHomeImportImageMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysHomeImportImageBizImpl
   extends IBizImpl<SysHomeImportImageService, SysHomeImportImageMapper, SysHomeImportImage>
   implements SysHomeImportImageBiz {
   @Resource
   private SysHomeImportImageBiz sysHomeImportImageBiz;
   @Resource
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;

   @Transactional
   @Override
   public Boolean saveSysHomeImportImage(SysHomeImportImageSaveParam param) {
      SysHomeImportImage sysHomeImportImage = this.baseService.getOne(Wrappers.lambdaQuery(SysHomeImportImage.class));
      if (sysHomeImportImage == null) {
         SysHomeImportImage build = SysHomeImportImage.builder()
            .attachmentIds(StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ","))
            .build();
         this.baseService.save(build);
      } else {
         this.baseService.removeById(sysHomeImportImage.getId());
         SysHomeImportImage build = SysHomeImportImage.builder()
            .attachmentIds(StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ","))
            .build();
         this.baseService.save(build);
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public SysHomeImportImagePageDTO getSysHomeImportImagePage() {
      SysHomeImportImage homeImportImage = this.baseService.getOne(Wrappers.lambdaQuery(SysHomeImportImage.class));
      if (homeImportImage != null) {
         String attachmentIds = homeImportImage.getAttachmentIds();
         String[] split = attachmentIds.split(",");
         List<Long> idList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
         List<AttachmentDTO> attachmentDTOS = new ArrayList<>();
         idList.forEach(item -> {
            AttachmentDTO attachmentDTO = this.attachmentService.getById(item);
            attachmentDTOS.add(attachmentDTO);
         });
         if (CollectionUtils.isNotEmpty(attachmentDTOS)) {
            return SysHomeImportImagePageDTO.builder().attachmentDTOList(attachmentDTOS).build();
         }
      }

      return new SysHomeImportImagePageDTO();
   }
}
