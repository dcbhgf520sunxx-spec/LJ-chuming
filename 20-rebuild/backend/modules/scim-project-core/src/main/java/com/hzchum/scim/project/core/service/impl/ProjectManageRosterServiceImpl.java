package com.hzchum.scim.project.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.NationEnum;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRosterCert;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterCertDTO;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectManageRosterQuery;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterCertService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.mapper.ProjectManageRosterMapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageRosterServiceImpl extends ServiceImpl<ProjectManageRosterMapper, ProjectManageRoster> implements ProjectManageRosterService {
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private ProjectManageRosterCertService rosterCertService;

   @Override
   public List<ProjectManageRosterDTO> rosterList(ProjectManageRosterQuery query) {
      List<ProjectManageRosterDTO> list = this.baseMapper.rosterList(query);
      String avatarAttachmentIds = CollUtil.join(CollUtil.removeNull(CollUtil.getFieldValues(list, "avatarAttachmentId", Long.class)), ",");
      Map<Long, AttachmentDTO> avatarAttachmentGroup = this.attachmentService
         .listByIds(avatarAttachmentIds)
         .stream()
         .collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
      String certAttachmentIds = CollUtil.join(CollUtil.removeBlank(CollUtil.getFieldValues(list, "certAttachmentIds", String.class)), ",");
      List<AttachmentDTO> certAttachmentList = this.attachmentService.listByIds(certAttachmentIds);
      String physicalExaminationAttachmentIds = CollUtil.join(
         CollUtil.removeBlank(CollUtil.getFieldValues(list, "physicalExaminationAttachmentIds", String.class)), ","
      );
      List<AttachmentDTO> physicalExaminationAttachmentList = this.attachmentService.listByIds(physicalExaminationAttachmentIds);
      List<Long> ids = CollUtil.removeNull(CollUtil.getFieldValues(list, "id", Long.class));
      Map<Long, List<ProjectManageRosterCertDTO>> certGroup = new HashMap<>();
      if (ids.size() > 0) {
         certGroup = this.rosterCertService
            .list(Wrappers.lambdaQuery(ProjectManageRosterCert.class).in(ProjectManageRosterCert::getRosterId, ids))
            .stream()
            .map(cert -> BeanUtil.toBean(cert, ProjectManageRosterCertDTO.class))
            .collect(Collectors.groupingBy(ProjectManageRosterCert::getRosterId));
      }

      Map<Long, List<ProjectManageRosterCertDTO>> finalCertGroup = certGroup;
      list.forEach(
         i -> {
            if (i.getAvatarAttachmentId() != null) {
               i.setAvatarAttachment(avatarAttachmentGroup.get(i.getAvatarAttachmentId()));
            }

            if (StrUtil.isNotBlank(i.getCertAttachmentIds())) {
               List<AttachmentDTO> currentCertAttachments = certAttachmentList.stream()
                  .filter(attachment -> i.getCertAttachmentIdList().contains(attachment.getId()))
                  .collect(Collectors.toList());
               i.setCertAttachments(currentCertAttachments);
            }

            if (StrUtil.isNotBlank(i.getPhysicalExaminationAttachmentIds())) {
               List<AttachmentDTO> currentPhysicalExaminationAttachments = physicalExaminationAttachmentList.stream()
                  .filter(attachment -> i.getPhysicalExaminationAttachmentIdList().contains(attachment.getId()))
                  .collect(Collectors.toList());
               i.setPhysicalExaminationAttachment(currentPhysicalExaminationAttachments);
            }

            i.setCerts(finalCertGroup.getOrDefault(i.getId(), Collections.emptyList()));
         }
      );
      return list;
   }

   @Override
   public List<String> nationList() {
      return Stream.of(NationEnum.values()).map(NationEnum::getName).collect(Collectors.toList());
   }

   @Override
   public ProjectManageRosterDTO getByUserId(Long userId) {
      List<ProjectManageRosterDTO> list = this.rosterList(ProjectManageRosterQuery.builder().userId(userId).build());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list) && list.size() == 1, "数据不存在, 请刷新后重试");
      return list.get(0);
   }
}
