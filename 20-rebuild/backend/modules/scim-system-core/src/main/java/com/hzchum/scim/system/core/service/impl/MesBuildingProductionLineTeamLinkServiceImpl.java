package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.common.enums.TeamTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingProductionLineTeamLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingProductionLineTeamLinkDTO;
import com.hzchum.scim.system.core.api.service.MesBuildingProductionLineTeamLinkService;
import com.hzchum.scim.system.core.mapper.MesBuildingProductionLineTeamLinkMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProductionLineTeamLinkServiceImpl
   extends ServiceImpl<MesBuildingProductionLineTeamLinkMapper, MesBuildingProductionLineTeamLink>
   implements MesBuildingProductionLineTeamLinkService {
   @Override
   public MesBuildingProductionLineTeamLinkDTO getTeamByProdLine(MesBuildingProductionLineTeamLinkDTO dtoParam, Integer pageNumber, Integer pageSize) {
      List<MesBuildingProductionLineTeamLink> teamLinkList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingProductionLineTeamLink.class)
               .eq(dtoParam.getProductionLineId() != null, MesBuildingProductionLineTeamLink::getProductionLineId, dtoParam.getProductionLineId())
         );
      List<Long> teamids = teamLinkList.stream()
         .filter(s -> s.getTeamType().equals(TeamTypeEnum.COMMON_TEAM.getType()))
         .map(MesBuildingProductionLineTeamLink::getTeamId)
         .collect(Collectors.toList());
      List<Long> inspectTeamids = teamLinkList.stream()
         .filter(s -> s.getTeamType().equals(TeamTypeEnum.INSPECT_TEAM.getType()))
         .map(MesBuildingProductionLineTeamLink::getTeamId)
         .collect(Collectors.toList());
      return MesBuildingProductionLineTeamLinkDTO.builder().teamIds(teamids).inspectionTeamIds(inspectTeamids).build();
   }

   @Override
   public Boolean saveProdLineTeamLink(MesBuildingProductionLineTeamLinkDTO dtoParam) {
      Preconditions.checkArgument(dtoParam.getProductionLineId() != null || dtoParam.getTeamType() != null, "产线或班组类型不能为空");
      List<MesBuildingProductionLineTeamLink> addList = new ArrayList<>();
      MesBuildingProductionLineTeamLink teamLink = new MesBuildingProductionLineTeamLink();
      teamLink.setProductionLineId(dtoParam.getProductionLineId());
      if (dtoParam.getTeamType().equals(TeamTypeEnum.COMMON_TEAM.getType())) {
         teamLink.setTeamType(Boolean.FALSE);

         for (Long teamId : dtoParam.getTeamIds()) {
            teamLink.setTeamId(teamId);
            addList.add(teamLink);
         }
      } else if (dtoParam.getTeamType().equals(TeamTypeEnum.INSPECT_TEAM.getType())) {
         teamLink.setTeamType(Boolean.TRUE);

         for (Long teamId : dtoParam.getInspectionTeamIds()) {
            teamLink.setTeamId(teamId);
            addList.add(teamLink);
         }
      }

      this.saveBatch(addList);
      return Boolean.TRUE;
   }
}
