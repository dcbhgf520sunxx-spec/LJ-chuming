package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.system.core.api.biz.SysHomeInformationNoticeBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeInformationNotice;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeInformationNoticeDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeInformationNoticePageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeInformationNoticeSaveParam;
import com.hzchum.scim.system.core.api.service.SysHomeInformationNoticeService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.SysHomeInformationNoticeMapper;
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
public class SysHomeInformationNoticeBizImpl
   extends IBizImpl<SysHomeInformationNoticeService, SysHomeInformationNoticeMapper, SysHomeInformationNotice>
   implements SysHomeInformationNoticeBiz {
   @Resource
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private SysHomeInformationNoticeService sysHomeInformationNoticeService;
   @Resource
   private SysHomeInformationNoticeBiz sysHomeInformationNoticeBiz;

   @Transactional
   @Override
   public Boolean saveSysHomeInformationNotice(SysHomeInformationNoticeSaveParam param) {
      SysHomeInformationNotice sysHomeInformationNotice = BeanUtil.copy(param, SysHomeInformationNotice.class);
      sysHomeInformationNotice.setCreateUserId(UserUtil.getCurrentUserId());
      sysHomeInformationNotice.setCreateUserName(UserUtil.getCurrentName());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         sysHomeInformationNotice.setAttachmentIds(
            StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
         );
      }

      this.baseService.save(sysHomeInformationNotice);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean deleteSysHomeInformationNotice(Long id) {
      SysHomeInformationNotice sysHomeInformationNotice = this.baseService.getById(id);
      Preconditions.checkArgument(sysHomeInformationNotice != null, "公告不存在");
      this.baseService.removeById(id);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public SysHomeInformationNoticeDetailDTO sysHomeInformationNoticeDetailDTO(Long id) {
      SysHomeInformationNotice sysHomeInformationNotice = this.baseService.getById(id);
      Preconditions.checkArgument(sysHomeInformationNotice != null, "公告id不存在");
      SysHomeInformationNoticeDetailDTO sysHomeInformationNoticeDetailDTO = BeanUtil.copy(sysHomeInformationNotice, SysHomeInformationNoticeDetailDTO.class);
      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(sysHomeInformationNotice.getAttachmentIds())) {
         sysHomeInformationNoticeDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(sysHomeInformationNotice.getAttachmentIds()));
      }

      return sysHomeInformationNoticeDetailDTO;
   }

   @Transactional
   @Override
   public PageVO<SysHomeInformationNoticePageDTO> getSysHomeInformationNoticePage(
      LocalDateTime informantDateTime, String createUserName, String title, String content, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      if (informantDateTime != null) {
         List<SysHomeInformationNotice> sysHomeInformationNotices = this.list(
            Wrappers.lambdaQuery(SysHomeInformationNotice.class)
               .apply(informantDateTime != null, "date_format(informant_date_time, '%Y') = {0}", informantDateTime.format(DateTimeFormatter.ofPattern("yyyy")))
               .eq(title != null, SysHomeInformationNotice::getTitle, title)
               .eq(content != null, SysHomeInformationNotice::getContent, content)
               .like(StringUtils.isNotBlank(createUserName), SysHomeInformationNotice::getCreateUserName, createUserName)
               .orderByDesc(SysHomeInformationNotice::getInformantDateTime)
         );
         Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         return new PageVO<>(
            objects,
            sysHomeInformationNotices.stream()
               .map(
                  item -> {
                     SysHomeInformationNoticePageDTO sysHomeInformationNoticePageDTO = BeanUtil.copy(item, SysHomeInformationNoticePageDTO.class);
                     if (item.getCreateUserId() != null) {
                        sysHomeInformationNoticePageDTO.setCreateUserName(
                           userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                        );
                     }

                     if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                        sysHomeInformationNoticePageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
                     }

                     return sysHomeInformationNoticePageDTO;
                  }
               )
               .collect(Collectors.toList())
         );
      } else {
         List<SysHomeInformationNotice> sysHomeInformationNotices = this.list(
            Wrappers.lambdaQuery(SysHomeInformationNotice.class)
               .eq(title != null, SysHomeInformationNotice::getTitle, title)
               .eq(content != null, SysHomeInformationNotice::getContent, content)
               .like(StringUtils.isNotBlank(createUserName), SysHomeInformationNotice::getCreateUserName, createUserName)
               .orderByDesc(SysHomeInformationNotice::getInformantDateTime)
         );
         Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         return new PageVO<>(
            objects,
            sysHomeInformationNotices.stream()
               .map(
                  item -> {
                     SysHomeInformationNoticePageDTO sysHomeInformationNoticePageDTO = BeanUtil.copy(item, SysHomeInformationNoticePageDTO.class);
                     if (item.getCreateUserId() != null) {
                        sysHomeInformationNoticePageDTO.setCreateUserName(
                           userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                        );
                     }

                     if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                        sysHomeInformationNoticePageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
                     }

                     return sysHomeInformationNoticePageDTO;
                  }
               )
               .collect(Collectors.toList())
         );
      }
   }

   @Transactional
   @Override
   public PrintVO<List<Map<String, Object>>> printSysHomeInformationNotice(LocalDateTime informantDateTime, String createUserName, String title, String content) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<SysHomeInformationNotice> sysHomeInformationNotices = this.list(
         Wrappers.lambdaQuery(SysHomeInformationNotice.class)
            .apply(
               informantDateTime != null,
               "date_format(informant_date_time, '%Y-%m-%d') = {0}",
               informantDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            )
            .eq(title != null, SysHomeInformationNotice::getTitle, title)
            .eq(content != null, SysHomeInformationNotice::getContent, content)
            .like(StringUtils.isNotBlank(createUserName), SysHomeInformationNotice::getCreateUserName, createUserName)
            .orderByDesc(SysHomeInformationNotice::getInformantDateTime)
      );
      List<Map<String, Object>> mapList = sysHomeInformationNotices.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void downloadAttachment(DownloadAttachmentCommonDTO dto, HttpServletResponse response) {
      Preconditions.checkArgument(dto != null && CollectionUtils.isNotEmpty(dto.getAttachmentDTOList()), "无附件可下载");
      if (CollectionUtils.isNotEmpty(dto.getAttachmentDTOList())) {
         List<AttachmentDTO> attachmentDTOS = this.attachmentService
            .listByIdList(dto.getAttachmentDTOList().stream().map(AttachmentDTO::getId).collect(Collectors.toList()));
         if (CollectionUtils.isNotEmpty(attachmentDTOS)) {
            String filePath = this.configProperties.getFilePath();
            String fileName1 = filePath + "通知公告-" + System.currentTimeMillis();
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
