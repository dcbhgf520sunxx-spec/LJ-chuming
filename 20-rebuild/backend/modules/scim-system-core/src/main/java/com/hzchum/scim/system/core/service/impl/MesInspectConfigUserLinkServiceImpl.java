package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TeamInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUserLinkDTO;
import com.hzchum.scim.system.core.api.service.MesInspectClassificationConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.mapper.MesInspectConfigUserLinkMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesInspectConfigUserLinkServiceImpl
   extends ServiceImpl<MesInspectConfigUserLinkMapper, MesInspectConfigUserLink>
   implements MesInspectConfigUserLinkService {
   @Autowired
   private MesInspectConfigUserLinkService inspectConfigUserLinkService;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;
   @Autowired
   private MesInspectClassificationConfigLinkService classificationConfigLinkService;

   @Override
   public List<MesInspectConfigUserLinkDTO> findInspectUserInfoByInspectId(List<Long> idList) {
      return this.baseMapper.findInspectUserInfoByInspectId(idList);
   }

   @Override
   public List<InsepctUserConditionDTO> findInspectUserReturnConditions(Long userId) {
      List<MesInspectConfigUserLink> inspectConfigs = this.inspectConfigUserLinkService
         .list(
            Wrappers.lambdaQuery(MesInspectConfigUserLink.class)
               .eq(MesInspectConfigUserLink::getInspectUserId, userId == null ? UserUtil.getCurrentUserId() : userId)
         );
      if (CollectionUtils.isEmpty(inspectConfigs)) {
         return new ArrayList<>();
      }

      List<InsepctUserConditionDTO> treeDOS = null;
      List<Long> inspectConfigIds = inspectConfigs.stream().map(MesInspectConfigUserLink::getInspectConfigId).collect(Collectors.toList());
      treeDOS = this.productionLineBiz.getInspectTeamLink(inspectConfigIds).stream().map(s -> {
         InsepctUserConditionDTO dto = new InsepctUserConditionDTO();
         dto.setId(s.getId());
         dto.setClassIds(s.getClassIds());
         dto.setTeamList(s.getTeamList().stream().map(e -> BeanUtil.copyProperties(e, TeamInfoDTO.class)).collect(Collectors.toList()));
         return dto;
      }).collect(Collectors.toList());
      Map<Long, List<Long>> classMap = this.classificationConfigLinkService
         .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).in(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfigIds))
         .stream()
         .collect(Collectors.groupingBy(s -> s.getInspectConfigId(), Collectors.mapping(s -> s.getClassificationId(), Collectors.toList())));
      treeDOS.forEach(s -> s.setClassIds(classMap.get(s.getId())));
      return treeDOS;
   }
}
