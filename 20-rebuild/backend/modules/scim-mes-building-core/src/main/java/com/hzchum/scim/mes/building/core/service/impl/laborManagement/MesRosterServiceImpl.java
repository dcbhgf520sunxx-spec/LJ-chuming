package com.hzchum.scim.mes.building.core.service.impl.laborManagement;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.NationEnum;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRosterCert;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterCertDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterQuery;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterCertService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.laborManagement.MesRosterMapper;
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
public class MesRosterServiceImpl extends ServiceImpl<MesRosterMapper, MesRoster> implements MesRosterService {
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private MesRosterCertService rosterCertService;

   @Override
   public List<MesRosterDTO> rosterList(MesRosterQuery query) {
      List<MesRosterDTO> list = this.baseMapper.rosterList(query);
      if (CollUtil.isNotEmpty(list)) {
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
         Map<Long, List<MesRosterCertDTO>> certGroup = CollUtil.isNotEmpty(ids)
            ? this.rosterCertService
               .list(Wrappers.lambdaQuery(MesRosterCert.class).in(MesRosterCert::getRosterId, ids))
               .stream()
               .map(cert -> BeanUtil.toBean(cert, MesRosterCertDTO.class))
               .collect(Collectors.groupingBy(MesRosterCert::getRosterId))
            : new HashMap<>();
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

               i.setCerts(certGroup.getOrDefault(i.getId(), Collections.emptyList()));
            }
         );
      }

      return list;
   }

   @Override
   public List<String> nationList() {
      return Stream.of(NationEnum.values()).map(NationEnum::getName).collect(Collectors.toList());
   }

   @Override
   public MesRosterDTO getByUserId(Long userId) {
      List<MesRosterDTO> list = this.rosterList(MesRosterQuery.builder().userId(userId).build());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list) && list.size() == 1, "数据不存在, 请刷新后重试");
      return list.get(0);
   }
}
