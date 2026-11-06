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
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.system.core.api.biz.SysHomeEnterpriseNetdiskBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeEnterpriseNetdisk;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DownloadAttachmentCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeEnterpriseNetdiskPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeEnterpriseNetdiskSaveParam;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import com.hzchum.scim.system.core.api.service.SysHomeEnterpriseNetdiskService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.MenuMapper;
import com.hzchum.scim.system.core.mapper.SysHomeEnterpriseNetdiskMapper;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
public class SysHomeEnterpriseNetdiskBizImpl
   extends IBizImpl<SysHomeEnterpriseNetdiskService, SysHomeEnterpriseNetdiskMapper, SysHomeEnterpriseNetdisk>
   implements SysHomeEnterpriseNetdiskBiz {
   @Resource
   private UserService userService;
   @Resource
   private SysHomeEnterpriseNetdiskService sysHomeEnterpriseNetdiskService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private RoleMenuLinkService roleMenuLinkService;
   @Resource
   private MenuService menuService;
   @Resource
   MenuMapper menuMapper;
   @Resource
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;

   @Transactional
   @Override
   public Boolean saveSysHomeEnterpriseNetdisk(SysHomeEnterpriseNetdiskSaveParam param) {
      SysHomeEnterpriseNetdisk sysHomeEnterpriseNetdisk = BeanUtil.copy(param, SysHomeEnterpriseNetdisk.class);
      sysHomeEnterpriseNetdisk.setCreateUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         sysHomeEnterpriseNetdisk.setAttachmentIds(
            StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
         );
      }

      this.baseService.save(sysHomeEnterpriseNetdisk);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean deleteSysHomeEnterpriseNetdisk(Long id) {
      SysHomeEnterpriseNetdisk sysHomeEnterpriseNetdisk = this.baseService.getById(id);
      Preconditions.checkArgument(id != null, "云盘不存在");
      this.baseService.removeById(id);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public PageVO<SysHomeEnterpriseNetdiskPageDTO> getSysHomeEnterpriseNetdiskPage(
      LocalDateTime informantDateTime, String createUserName, Integer sysHomeFileType, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      if (informantDateTime != null) {
         List<SysHomeEnterpriseNetdisk> sysHomeEnterpriseNetdisks = this.baseService
            .list(
               Wrappers.lambdaQuery(SysHomeEnterpriseNetdisk.class)
                  .apply(true, "date_format(informant_date_time, '%Y') = {0}", informantDateTime.format(DateTimeFormatter.ofPattern("yyyy")))
                  .like(StringUtils.isNotBlank(createUserName), SysHomeEnterpriseNetdisk::getCreateUserName, createUserName)
                  .eq(sysHomeFileType != null, SysHomeEnterpriseNetdisk::getSysHomeFileType, sysHomeFileType)
                  .orderByDesc(SysHomeEnterpriseNetdisk::getInformantDateTime)
            );
         Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         return new PageVO<>(
            objects,
            sysHomeEnterpriseNetdisks.stream()
               .map(
                  item -> {
                     SysHomeEnterpriseNetdiskPageDTO sysHomeEnterpriseNetdiskPageDTO = BeanUtil.copy(item, SysHomeEnterpriseNetdiskPageDTO.class);
                     if (item.getCreateUserId() != null) {
                        sysHomeEnterpriseNetdiskPageDTO.setCreateUserName(
                           userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                        );
                     }

                     sysHomeEnterpriseNetdiskPageDTO.setSysHomeFileType(item.getSysHomeFileType());
                     if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                        sysHomeEnterpriseNetdiskPageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
                     }

                     return sysHomeEnterpriseNetdiskPageDTO;
                  }
               )
               .collect(Collectors.toList())
         );
      } else {
         List<SysHomeEnterpriseNetdisk> sysHomeEnterpriseNetdisks = this.baseService
            .list(
               Wrappers.lambdaQuery(SysHomeEnterpriseNetdisk.class)
                  .like(StringUtils.isNotBlank(createUserName), SysHomeEnterpriseNetdisk::getCreateUserName, createUserName)
                  .eq(sysHomeFileType != null, SysHomeEnterpriseNetdisk::getSysHomeFileType, sysHomeFileType)
                  .orderByDesc(SysHomeEnterpriseNetdisk::getInformantDateTime)
            );
         Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
         return new PageVO<>(
            objects,
            sysHomeEnterpriseNetdisks.stream()
               .map(
                  item -> {
                     SysHomeEnterpriseNetdiskPageDTO sysHomeEnterpriseNetdiskPageDTO = BeanUtil.copy(item, SysHomeEnterpriseNetdiskPageDTO.class);
                     if (item.getCreateUserId() != null) {
                        sysHomeEnterpriseNetdiskPageDTO.setCreateUserName(
                           userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                        );
                     }

                     sysHomeEnterpriseNetdiskPageDTO.setSysHomeFileType(item.getSysHomeFileType());
                     if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(item.getAttachmentIds())) {
                        sysHomeEnterpriseNetdiskPageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
                     }

                     return sysHomeEnterpriseNetdiskPageDTO;
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
            String fileName1 = filePath + "网盘内容-" + System.currentTimeMillis();
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

   @Transactional
   @Override
   public HashMap<String, Object> getUserBasicInfo() {
      HashMap<String, Object> map = new HashMap<>();
      Period period = Period.between(UserUtil.getCurrentUser().getCreateTime().toLocalDate(), LocalDate.now());
      int years = period.getYears();
      int months = period.getMonths();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(years);
      stringBuilder.append("年");
      stringBuilder.append(months);
      stringBuilder.append("月");
      map.put("registerTime", stringBuilder);
      Long userId = UserUtil.getCurrentUserId();
      List<Long> projectId = this.contractProjectService.listProjectIdByUser(userId, null);
      Integer projectCount = projectId.size();
      map.put("projectCount", projectCount);
      Integer canCheckCount1 = this.wmsApproveRecordService.getCanCheckCount(new ArrayList<>());
      map.put("canCheckCount", canCheckCount1);
      return map;
   }
}
