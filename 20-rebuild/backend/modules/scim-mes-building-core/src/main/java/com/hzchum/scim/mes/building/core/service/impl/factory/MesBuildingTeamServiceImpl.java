package com.hzchum.scim.mes.building.core.service.impl.factory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamLeaderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamUserLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamProductionLineListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.MesBuildingLeaderInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.GroupTeamLinkDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingTeamMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTeamServiceImpl extends ServiceImpl<MesBuildingTeamMapper, MesBuildingTeam> implements MesBuildingTeamService {
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;

   @Override
   public List<MesBuildingTeam> getTeamByProductionLineIdAndProcessIdAndUserId(Long productionLineId, Long processId, Long userId, List<Long> ids) {
      return this.baseMapper.getTeamByProductionLineIdAndProcessIdAndUserId(productionLineId, processId, userId, ids);
   }

   @Override
   public ListVO<ProductProcessDO> listTeamSimple(Long productionLineId) {
      return new ListVO<>(this.baseMapper.listTeamSimple(productionLineId));
   }

   @Override
   public ListVO<ProductProcessDO> listTeamUser(Long productionLineId) {
      return new ListVO<>(this.baseMapper.listTeamUser(productionLineId, UserUtil.getCurrentUserId()));
   }

   @Override
   public List<MesBuildingTeam> listByCondition(MesBuildingTeamDOParam doParam) {
      return this.baseMapper.listByCondition(doParam);
   }

   @Override
   public List<GroupTeamLinkDetailDTO> listTrees() {
      return this.baseMapper.listTrees();
   }

   @Override
   public List<MesProcessTeamListDTO> findProcessTeamList(Long workShopId, Long productionLineId) {
      return this.baseMapper.findProcessTeamList(workShopId, productionLineId);
   }

   @Override
   public List<MesBuildingTeamLeaderDTO> findAllTeamLeader(MesBuildingTeamDOParam doParam) {
      return this.baseMapper.findAllTeamLeader(doParam);
   }

   @Override
   public List<MesProcessTeamProductionLineListDTO> listProductionLineTrees(Long workShopId, Long productionLineId) {
      return this.baseMapper.listProductionLineTrees(workShopId, productionLineId);
   }

   @Override
   public List<MesBuildingLeaderInfoDTO> findAllTeamLeader(List<Long> teamIds) {
      return this.baseMapper.findLeaderInfoByTeamIds(teamIds);
   }

   @Override
   public List<ShowInfo> listInfoByIds(List<Long> idList) {
      return Optional.ofNullable(idList).filter(CollUtil::isNotEmpty).map(this.baseMapper::listInfoByIds).orElseGet(Collections::emptyList);
   }

   @Override
   public List<MesBuildingTeamInfoDTO> listInfo(MesBuildingTeamQuery query) {
      List<MesBuildingTeamInfoDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> idList = list.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
         Map<Long, List<MesBuildingTeamUserLinkDTO>> teamUserLinkGroup = this.teamUserLinkService
            .lambdaQuery()
            .in(MesBuildingTeamUserLink::getTeamId, idList)
            .list()
            .stream()
            .map(tul -> BeanUtil.toBean(tul, MesBuildingTeamUserLinkDTO.class))
            .collect(Collectors.groupingBy(MesBuildingTeamUserLinkDTO::getTeamId));
         list.forEach(i -> i.setMemberList(teamUserLinkGroup.get(i.getId())));
      }

      return list;
   }
}
