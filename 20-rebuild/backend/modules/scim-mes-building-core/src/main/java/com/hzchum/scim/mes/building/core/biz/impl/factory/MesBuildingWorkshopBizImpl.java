package com.hzchum.scim.mes.building.core.biz.impl.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWorkshopBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.IdsVoRequest;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWorkshopDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingWorkshopMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingWorkshopBizImpl
   extends IBizImpl<MesBuildingWorkshopService, MesBuildingWorkshopMapper, MesBuildingWorkshop>
   implements MesBuildingWorkshopBiz {
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesEnclosureProductionLineService enclosureLineService;
   @Autowired
   private OutboundService outboundService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesInspectConfigService inspectConfigService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean workshopStateUpdate(MesBuildingWorkshopDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getId() != null & dtoParam.getBoolEnabledEnum() != null, "传入数据有误");
      MesBuildingWorkshop workshop = this.baseService.getById(dtoParam.getId());
      if (dtoParam.getBoolEnabledEnum()) {
         Preconditions.checkArgument(this.factoryService.getById(workshop.getFactoryId()).getBoolEnabledEnum(), "启用失败，请先启用工厂");
      } else {
         LambdaQueryWrapper<MesBuildingProductionLine> wrapper = (LambdaQueryWrapper<MesBuildingProductionLine>)new LambdaQueryWrapper<MesBuildingProductionLine>()
            .eq(dtoParam.getId() != null, MesBuildingProductionLine::getWorkshopId, dtoParam.getId());
         List<MesBuildingProductionLine> mesBuildingProductionLines = this.productionLineService.list(wrapper);
         mesBuildingProductionLines.forEach(e -> Preconditions.checkArgument(!e.getBoolEnabledEnum(), "修改失败,该车间下有生产线处于未禁用状态,请先禁用生产线"));
      }

      workshop.setBoolEnabledEnum(dtoParam.getBoolEnabledEnum());
      this.baseService.updateById(workshop);
      return null;
   }

   @Override
   public MesBuildingWorkshop getById(Long workshopId) {
      return this.baseService.getById(workshopId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean workshopDelete(IdsVoRequest voRequest) {
      voRequest.getIds()
         .forEach(
            e -> {
               Preconditions.checkArgument(
                  this.productionLineService
                        .list((Wrapper<MesBuildingProductionLine>)Wrappers.<MesBuildingProductionLine>lambdaQuery().eq(MesBuildingProductionLine::getWorkshopId, e))
                        .size()
                     == 0,
                  "删除失败，请先删除该车间下全部生产线"
               );
               Preconditions.checkArgument(
                  this.enclosureLineService
                        .list((Wrapper<MesEnclosureProductionLine>)Wrappers.<MesEnclosureProductionLine>lambdaQuery().eq(MesEnclosureProductionLine::getWorkshopId, e))
                        .size()
                     == 0,
                  "删除失败，请先删除该车间下围护生产线"
               );
               Preconditions.checkArgument(this.outboundService.getWorkshopCount(e) == 0, "删除失败，已有原材料出库到该车间.");
               Preconditions.checkArgument(
                  this.teamService.count((Wrapper<MesBuildingTeam>)Wrappers.<MesBuildingTeam>lambdaQuery().eq(MesBuildingTeam::getWorkshopId, e)) == 0, "删除失败，车间下存在关联班组"
               );
               Preconditions.checkArgument(
                  this.productProcessService.count(Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getWorkshopId, e)) == 0,
                  "删除失败，车间下已配置工序无法删除"
               );
               Preconditions.checkArgument(
                  this.inspectConfigService.count(Wrappers.lambdaQuery(MesInspectConfig.class).eq(MesInspectConfig::getWorkshopId, e)) == 0,
                  "删除失败，车间已在质检基础配置中使用无法删除"
               );
            }
         );
      return this.removeByIds(voRequest.getIds());
   }

   @Override
   public List<MesBuildingProjectWorkshopDTO> getWorkShopQueryCondition() {
      List<MesBuildingWorkshop> workshopList = this.list();
      Map<Long, List<MesBuildingProductionLine>> productionLineMap = this.productionLineService
         .list()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductionLine::getWorkshopId));
      List<MesBuildingTeam> teamList = this.teamService.list();
      Map<Long, List<MesBuildingTeam>> teamMap = this.teamService.list().stream().collect(Collectors.groupingBy(MesBuildingTeam::getProductionLineId));
      List<MesBuildingProcess> mesBuildingProcesses = this.processService.list();
      Map<Long, MesBuildingProcess> processMap = mesBuildingProcesses.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingTeamUserLink> teamUserLinkMap = this.teamUserLinkService
         .list(
            (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>()
                  .in(MesBuildingTeamUserLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList())))
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
      return workshopList.stream()
         .map(
            workshop -> {
               MesBuildingProjectWorkshopDTO workshopDTO = BeanUtil.copy(workshop, MesBuildingProjectWorkshopDTO.class);
               List<MesBuildingProductionLine> productionLineList = productionLineMap.get(workshop.getId());
               if (CollectionUtil.isEmpty(productionLineList)) {
                  return workshopDTO;
               }

               List<MesBuildingProjectProductionLineDTO> projectProductionLineDTOS = cn.hutool.core.bean.BeanUtil.copyToList(
                  productionLineList, MesBuildingProjectProductionLineDTO.class
               );

               for (MesBuildingProjectProductionLineDTO projectProductionLineDTO : projectProductionLineDTOS) {
                  List<MesBuildingTeam> mesBuildingTeams = teamMap.get(projectProductionLineDTO.getId());
                  if (!CollectionUtil.isEmpty(mesBuildingTeams)) {
                     List<MesBuildingProjectTeamDTO> projectTeamDTOS = mesBuildingTeams.stream()
                        .map(
                           team -> {
                              MesBuildingTeamUserLink userLink = teamUserLinkMap.get(team.getId());
                              return MesBuildingProjectTeamDTO.builder()
                                 .id(team.getId())
                                 .userName(userLink.getUserName())
                                 .userId(userLink.getUserId())
                                 .processId(team.getProcessId())
                                 .processName(processMap.get(team.getProcessId()).getName())
                                 .build();
                           }
                        )
                        .collect(Collectors.toList());
                     projectProductionLineDTO.setProjectTeamDTOS(projectTeamDTOS);
                  }
               }

               workshopDTO.setProjectProductionLineDTOS(projectProductionLineDTOS);
               return workshopDTO;
            }
         )
         .collect(Collectors.toList());
   }
}
