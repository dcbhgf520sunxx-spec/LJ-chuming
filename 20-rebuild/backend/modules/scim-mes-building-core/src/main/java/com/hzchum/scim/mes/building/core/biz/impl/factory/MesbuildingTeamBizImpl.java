package com.hzchum.scim.mes.building.core.biz.impl.factory;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesBuildingInspectionAndTeamEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamUserLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamByProLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamLeaderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamUserLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.UseTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamUserLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingMachinePartTeamService;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingMachinePartTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingTeamMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceTeamReportMapper;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesbuildingTeamBizImpl extends IBizImpl<MesBuildingTeamService, MesBuildingTeamMapper, MesBuildingTeam> implements MesBuildingTeamBiz {
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingMachinePartTeamService machinePartTeamService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingMachinePartTeamUserLinkService machinePartTeamUserLinkService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingGroupsTeamLinkBiz productionLineTeamLinkBiz;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingGroupsTeamLinkService groupsTeamLinkService;
   @Autowired
   private MesBuildingGroupsService groupsService;
   @Autowired
   private MesBuildingInspectionTeamService inspectionTeamService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesInspectConfigTeamLinkService inspectConfigTeamLinkService;
   @Autowired
   private MesInspectConfigService inspectConfigService;
   @Autowired
   private MesBuildingProductProcessLinkService processLinkService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService machinePartTeamDetailService;
   @Autowired
   private MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Resource
   private MesBuildingProduceTeamReportMapper mesBuildingProduceTeamReportMapper;
   @Autowired
   private MesBuildingTeamUserLinkService mesBuildingTeamUserLinkService;
   @Autowired
   private MesBuildingProductionLineService mesBuildingProductionLineService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveTeam(MesBuildingTeamDTOParam dtoParam) {
      this.utilsBiz
         .checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(
            dtoParam.getFactoryId(),
            dtoParam.getWorkshopId(),
            null,
            dtoParam.getProcessId(),
            dtoParam.getProductionLineTypeEnum(),
            MesBuildingInspectionAndTeamEnum.Team.getType()
         );
      MesBuildingWorkshop workshop = this.workshopService.getById(dtoParam.getWorkshopId());
      this.checkTeamUser(dtoParam.getUserLinks(), dtoParam.getProcessId());
      MesBuildingTeam team = BeanUtil.copy(dtoParam, MesBuildingTeam.class);
      team.setFactoryId(workshop.getFactoryId());
      team.setProductionLineTypeEnum(this.processService.getById(dtoParam.getProcessId()).getProductionLineTypeEnum());
      this.teamService.save(team);
      dtoParam.getUserLinks().forEach(e -> this.teamUserLinkService.save(BeanUtil.copy(e, MesBuildingTeamUserLink.class).setTeamId(team.getId())));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMachinePartTeam(MesBuildingPartTeamDTOParam dtoParam) {
      String mid = dtoParam.getMID();
      String deviceName = dtoParam.getDeviceName();
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.machinePartTeamDetailService
         .list((Wrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>().eq(MesBuildingMachinePartTeamDetail::getMID, mid));
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailList), "添加失败,MID已存在");
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailListTwo = this.machinePartTeamDetailService
         .list((Wrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>().eq(MesBuildingMachinePartTeamDetail::getDeviceName, deviceName));
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailListTwo), "添加失败,设备名称已存在");
      Long groupsId = dtoParam.getGroupsId();
      Integer partType = dtoParam.getPartType();
      Integer deviceType = dtoParam.getDeviceType();
      Integer partProdMode = dtoParam.getPartProdMode();
      String dtoParamMID = dtoParam.getMID();
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailCheckList = this.machinePartTeamDetailService
         .list(
            ((((new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
                           .eq(MesBuildingMachinePartTeamDetail::getGroupsId, groupsId))
                        .eq(MesBuildingMachinePartTeamDetail::getPartType, partType))
                     .eq(MesBuildingMachinePartTeamDetail::getDeviceType, deviceType))
                  .eq(MesBuildingMachinePartTeamDetail::getPartProdMode, partProdMode))
               .eq(StringUtils.isNotBlank(dtoParamMID), MesBuildingMachinePartTeamDetail::getMID, dtoParamMID)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailCheckList), "该班组零件切割配置已存在");
      MesBuildingProductionLine productionLine = this.productionLineService.getById(dtoParam.getProductionLineId());
      MesBuildingMachinePartTeamDetail teamDetail = BeanUtil.copy(dtoParam, MesBuildingMachinePartTeamDetail.class);
      List<String> teamId = dtoParam.getTeamId();
      String teamIds = StringUtils.join(teamId, ",");
      teamDetail.setTeamId(teamIds);
      teamDetail.setTeamStatus(true);
      teamDetail.setPartTeamId(teamIds);
      teamDetail.setProductionLineId(dtoParam.getProductionLineId());
      if (CollectionUtils.isNotEmpty(dtoParam.getPartFeature())) {
         String partFeatureStr = dtoParam.getPartFeature().stream().map(String::valueOf).collect(Collectors.joining(","));
         teamDetail.setPartFeature(partFeatureStr);
      }

      this.machinePartTeamDetailService.save(teamDetail);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveTeam2(MesBuildingTeamDTOParam dtoParam) {
      this.utilsBiz
         .checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(
            null, null, dtoParam.getProductionLineId(), dtoParam.getProcessId(), null, MesBuildingInspectionAndTeamEnum.Team.getType()
         );
      MesBuildingProductionLine productionLine = this.productionLineService.getById(dtoParam.getProductionLineId());
      this.checkTeamUser2(dtoParam.getUserLinks(), dtoParam.getProcessId(), dtoParam.getProductionLineId(), dtoParam.getOrganizationType(), null);
      Preconditions.checkArgument(
         dtoParam.getHasMen() && dtoParam.getUserLinks().size() > 1 || !dtoParam.getHasMen() && dtoParam.getUserLinks().size() == 1, "组员传参有误"
      );
      MesBuildingTeam team = BeanUtil.copy(dtoParam, MesBuildingTeam.class);
      team.setFactoryId(productionLine.getFactoryId());
      team.setWorkshopId(productionLine.getWorkshopId());
      team.setProductionLineId(productionLine.getId());
      team.setProductionLineTypeEnum(ProductionLineTypeEnum.TRADITIONAL_LINE.getType());
      team.setMesProductEnum(productionLine.getMesProductEnum());
      this.teamService.save(team);
      dtoParam.getUserLinks().forEach(e -> this.teamUserLinkService.save(BeanUtil.copy(e, MesBuildingTeamUserLink.class).setTeamId(team.getId())));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean teamUpdate(MesBuildingTeamDTOParam dtoParam) {
      MesBuildingTeam teamInfo = this.teamService.getById(dtoParam.getId());
      Preconditions.checkArgument(teamInfo != null, "修改失败，未查询到相关班组");
      MesBuildingTeam team = BeanUtil.copy(dtoParam, MesBuildingTeam.class);
      if (!teamInfo.getProductionLineId().equals(dtoParam.getProductionLineId())) {
         MesBuildingProductionLine productionLine = this.productionLineService.getById(dtoParam.getProductionLineId());
         Preconditions.checkArgument(productionLine != null, "操作失败,生产线不存在!");
         Preconditions.checkArgument(productionLine.getMesProductEnum().equals(team.getMesProductEnum()), "操作失败,不可修改mes分类");
         Preconditions.checkArgument(
            this.productProcessService
                  .count(
                     Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getProductionLineId, teamInfo.getProductionLineId())
                  )
               == 0,
            "操作失败，请先删除班组关联的产线工序配置"
         );
      }

      if (!teamInfo.getProcessId().equals(dtoParam.getProcessId())) {
         Preconditions.checkArgument(
            this.processLinkService
                  .count(Wrappers.lambdaQuery(MesBuildingProductProcessLink.class).eq(MesBuildingProductProcessLink::getTeamId, dtoParam.getId()))
               == 0,
            "操作失败，请先删除班组关联的产线工序配置"
         );
      }

      this.teamService.updateById(team);
      this.teamUserLinkService.remove((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getTeamId, team.getId()));
      this.checkTeamUser2(dtoParam.getUserLinks(), team.getProcessId(), dtoParam.getProductionLineId(), dtoParam.getOrganizationType(), dtoParam.getId());
      dtoParam.getUserLinks().forEach(e -> this.teamUserLinkService.save(BeanUtil.copy(e, MesBuildingTeamUserLink.class)));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean machinePartTeamUpdate(MesBuildingPartTeamDTOParam dtoParam) {
      String mid = dtoParam.getMID();
      String deviceName = dtoParam.getDeviceName();
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailMidCheckList = this.machinePartTeamDetailService
         .list(
            (Wrapper<MesBuildingMachinePartTeamDetail>)(new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>().eq(MesBuildingMachinePartTeamDetail::getMID, mid))
               .notIn(MesBuildingMachinePartTeamDetail::getId, dtoParam.getId())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailMidCheckList), "修改失败,MID已存在");
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailListTwo = this.machinePartTeamDetailService
         .list(
            (Wrapper<MesBuildingMachinePartTeamDetail>)(new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
                  .eq(MesBuildingMachinePartTeamDetail::getDeviceName, deviceName))
               .notIn(MesBuildingMachinePartTeamDetail::getId, dtoParam.getId())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailListTwo), "修改失败,设备名称已存在");
      Long groupsId = dtoParam.getGroupsId();
      Integer partType = dtoParam.getPartType();
      Integer deviceType = dtoParam.getDeviceType();
      Integer partProdMode = dtoParam.getPartProdMode();
      String dtoParamMID = dtoParam.getMID();
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailCheckList = this.machinePartTeamDetailService
         .list(
            (Wrapper<MesBuildingMachinePartTeamDetail>)(((((new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
                              .eq(MesBuildingMachinePartTeamDetail::getGroupsId, groupsId))
                           .eq(MesBuildingMachinePartTeamDetail::getPartType, partType))
                        .eq(MesBuildingMachinePartTeamDetail::getDeviceType, deviceType))
                     .eq(MesBuildingMachinePartTeamDetail::getPartProdMode, partProdMode))
                  .eq(StringUtils.isNotBlank(dtoParamMID), MesBuildingMachinePartTeamDetail::getMID, dtoParamMID))
               .ne(MesBuildingMachinePartTeamDetail::getId, dtoParam.getId())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingMachinePartTeamDetailCheckList), "该班组的零件切割配置已存在");
      MesBuildingMachinePartTeamDetail teamDetail = BeanUtil.copy(dtoParam, MesBuildingMachinePartTeamDetail.class);
      List<String> teamId = dtoParam.getTeamId();
      String teamIds = StringUtils.join(teamId, ",");
      teamDetail.setTeamId(teamIds);
      teamDetail.setTeamStatus(true);
      teamDetail.setPartTeamId(teamIds);
      if (teamDetail.getPartProdMode() == 2) {
         teamDetail.setDeviceName("");
         teamDetail.setMID("");
         teamDetail.setNcSystem(0);
         teamDetail.setNcFileFormat(0);
      }

      if (CollectionUtils.isNotEmpty(dtoParam.getPartFeature())) {
         String partFeatureStr = dtoParam.getPartFeature().stream().map(String::valueOf).collect(Collectors.joining(","));
         teamDetail.setPartFeature(partFeatureStr);
      }

      this.machinePartTeamDetailService.updateById(teamDetail);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean deleteTeamByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            Preconditions.checkArgument(this.teamService.getById(e) != null, "删除失败，未查询到相关班组");
            List<MesBuildingProductProcessLink> processLinks = this.processLinkService
               .list(Wrappers.lambdaQuery(MesBuildingProductProcessLink.class).eq(MesBuildingProductProcessLink::getTeamId, e));
            Preconditions.checkArgument(processLinks.size() == 0, "删除失败，班组存在关联的产线工序配置");
            Preconditions.checkArgument(
               this.inspectConfigTeamLinkService.count(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).eq(MesInspectConfigTeamLink::getTeamId, e)) == 0,
               "删除失败，班组已在质检基础配置中使用无法删除"
            );
            Preconditions.checkArgument(!this.mesBuildingProduceTeamReportMapper.existTeamId(e), "操作失败,历史生产记录存在该班组,无法删除");
            List<MesBuildingMachinePartTeamDetail> machinePartTeamDetails = this.machinePartTeamDetailService
               .list((Wrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>().eq(MesBuildingMachinePartTeamDetail::getGroupsId, e));
            Preconditions.checkArgument(CollectionUtils.isEmpty(machinePartTeamDetails), "操作失败,班组存在关联的零件切割配置!");
            this.teamService.removeById(e);
            this.teamUserLinkService.remove(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getTeamId, e));
            this.machinePartTeamDetailService
               .remove(Wrappers.lambdaQuery(MesBuildingMachinePartTeamDetail.class).eq(MesBuildingMachinePartTeamDetail::getPartTeamId, e));
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean deleteMachinePartTeamByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            List<MesBuildingTaskOrder> mesBuildingTaskOrderList = this.mesBuildingTaskOrderService
               .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getCutConfigId, e));
            Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingTaskOrderList), "操作失败，该零件切割配置已绑定工单，无法删除");
            List<MesBuildingTaskOrder> drillMesBuildingTaskOrderList = this.mesBuildingTaskOrderService
               .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getDrillCutConfigId, e));
            Preconditions.checkArgument(CollectionUtils.isEmpty(drillMesBuildingTaskOrderList), "操作失败,该零件切割配置已关联钻孔任务单，无法删除");
            MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.machinePartTeamDetailService.getById(e);
            Preconditions.checkArgument(mesBuildingMachinePartTeamDetail != null, "删除失败，未查询到零件切割配置信息");
            this.machinePartTeamDetailService.removeById(e);
         }
      );
      return true;
   }

   @Override
   public List<MesBuildingTeamDTO> listByCondition(MesBuildingTeamDTOParam dtoParam) {
      List<MesBuildingTeamDTO> teamDTOList = new ArrayList<>();
      List<MesBuildingTeam> mesBuildingTeamList = this.teamService.listByCondition(BeanUtil.copy(dtoParam, MesBuildingTeamDOParam.class));
      if (CollectionUtil.isEmpty(mesBuildingTeamList)) {
         return teamDTOList;
      }

      List<Long> teamIds = mesBuildingTeamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      Map<Long, List<MesBuildingProductProcessLink>> processLinkMap = this.processLinkService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcessLink.class).in(MesBuildingProductProcessLink::getTeamId, teamIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductProcessLink::getTeamId));
      Map<Long, MesBuildingProcess> processMap = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .in(MesBuildingProcess::getId, mesBuildingTeamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingWorkshop> workshopMap = this.workshopService
         .list(
            Wrappers.lambdaQuery(MesBuildingWorkshop.class)
               .in(MesBuildingWorkshop::getId, mesBuildingTeamList.stream().map(MesBuildingTeam::getWorkshopId).distinct().collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> lineMap = this.productionLineService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      mesBuildingTeamList.forEach(e -> {
         MesBuildingTeamDTO teamDTO = BeanUtil.copy(e, MesBuildingTeamDTO.class);
         teamDTO.setWorkshopName(workshopMap.get(e.getWorkshopId()).getName());
         teamDTO.setProductionLineName(lineMap.get(e.getProductionLineId()) == null ? "" : lineMap.get(e.getProductionLineId()).getName());
         teamDTO.setBoolBindProcess(processLinkMap.get(e.getId()) == null ? Boolean.FALSE : Boolean.TRUE);
         if (processMap.get(e.getProcessId()) != null) {
            MesBuildingProcess process = processMap.get(e.getProcessId());
            teamDTO.setProcessName(process.getName());
            teamDTO.setProductType(process.getProductType());
         }

         teamDTOList.add(teamDTO);
      });
      Map<Long, List<MesBuildingTeamUserLinkDTO>> teams = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(MesBuildingTeamUserLink::getTeamId, CollUtil.getFieldValues(mesBuildingTeamList, "id", Long.class))
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingTeamUserLinkDTO.class))
         .collect(Collectors.groupingBy(MesBuildingTeamUserLinkDTO::getTeamId));
      teamDTOList.forEach(e -> {
         List<MesBuildingTeamUserLinkDTO> userLinks = teams.get(e.getId());
         e.setUserLinkList(userLinks);
         List<MesBuildingTeamUserLinkDTO> collect = userLinks.stream().filter(u -> u.getBoolLeaderEnum() == Boolean.TRUE).collect(Collectors.toList());
         e.setTeamName(collect.size() > 0 ? collect.get(0).getUserName() : "");
         e.setProcessTeamName(e.getProcessName() + "-" + e.getTeamName());
      });
      return teamDTOList;
   }

   @Override
   public List<MesBuildingTeamLeaderDTO> findAllTeamLeader(MesBuildingTeamDTOParam dtoParam) {
      return this.teamService.findAllTeamLeader(BeanUtil.copy(dtoParam, MesBuildingTeamDOParam.class));
   }

   @Override
   public List<MesProcessTeamListDTO> findProcessTeamList(Long workShopId, Long productionLineId) {
      return this.teamService.findProcessTeamList(workShopId, productionLineId);
   }

   @Override
   public List<UseTeamDTO> listByProcessId(Long processId, Long workshopId) {
      return this.baseMapper.listByProcessId(processId, workshopId);
   }

   @Override
   public PageVO<MesBuildingMachinePartTeamDTO> machinePartListByCondition(MesBuildingPartTeamDTOParam dtoParam) {
      List<MesBuildingMachinePartTeamDTO> machinePratTeamList = this.machinePartTeamService.machinePartListByConditionNoGroup(dtoParam);
      Map<String, Map<String, String>> dictMap = this.dictionaryService
         .moreDistNameAndLabelLike(Arrays.asList("device_type", "nc_system", "nc_file_type"))
         .stream()
         .collect(Collectors.groupingBy(SysDictionary::getName, Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel)));
      Map<String, String> ncSystem = dictMap.get("nc_system");
      Map<String, String> ncFileType = dictMap.get("nc_file_type");

      for (MesBuildingMachinePartTeamDTO teamDTO : machinePratTeamList) {
         List<MesBuildingTaskOrder> mesBuildingTaskOrderList = this.mesBuildingTaskOrderService
            .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getCutConfigId, teamDTO.getId()));
         teamDTO.setProductionStatus(Boolean.FALSE);
         if (CollectionUtil.isNotEmpty(mesBuildingTaskOrderList)) {
            teamDTO.setProductionStatus(Boolean.TRUE);
         }

         if (MapUtils.isNotEmpty(ncSystem) && teamDTO.getNcSystem() != null) {
            teamDTO.getNcSystem().setName(ncSystem.get(teamDTO.getNcSystem().getId().toString()));
         }

         if (MapUtils.isNotEmpty(ncFileType) && teamDTO.getNcFileFormat() != null) {
            teamDTO.getNcFileFormat().setName(ncFileType.get(teamDTO.getNcFileFormat().getId().toString()));
         }

         if (null != teamDTO.getPartFeature()) {
            List<Long> longList = Arrays.stream(teamDTO.getPartFeature().split(",")).map(Long::parseLong).collect(Collectors.toList());
            teamDTO.setPartFeatureList(longList);
         }
      }

      machinePratTeamList.forEach(
         e -> {
            MesBuildingTeam mesBuildingTeam = this.teamService.getById(e.getGroupsId());
            LambdaQueryWrapper<MesBuildingTeamUserLink> queryWrapper = (LambdaQueryWrapper<MesBuildingTeamUserLink>)new LambdaQueryWrapper<MesBuildingTeamUserLink>()
               .eq(MesBuildingTeamUserLink::getTeamId, mesBuildingTeam.getId());
            List<MesBuildingTeamUserLink> teamUserLinkList = this.mesBuildingTeamUserLinkService.list(queryWrapper);
            List<MesBuildingMachinePartTeamUserLinkDTO> teamUserLinkDTOList = new ArrayList<>();
            teamUserLinkList.forEach(teamUser -> teamUserLinkDTOList.add(BeanUtil.copy(teamUser, MesBuildingMachinePartTeamUserLinkDTO.class)));
            e.setUserLinks(teamUserLinkDTOList);
         }
      );
      return listPage(dtoParam.getPageNumber(), dtoParam.getPageSize(), machinePratTeamList);
   }

   @Override
   public MesBuildingTeamDTO teamById(Long id) {
      MesBuildingTeam team = this.teamService.getById(id);
      Preconditions.checkArgument(team != null, "查询失败，未查询到相关班组");
      MesBuildingTeamDTO teamDTO = BeanUtil.copy(team, MesBuildingTeamDTO.class);
      teamDTO.setProcessName(this.processService.getById(team.getProcessId()).getName());
      teamDTO.setUserLinkList(
         this.teamUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getTeamId, teamDTO.getId()))
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingTeamUserLinkDTO.class))
            .collect(Collectors.toList())
      );
      return teamDTO;
   }

   @Override
   public MesBuildingMachinePartTeamDTO machinePartTeamById(Long id) {
      List<MesBuildingMachinePartTeamDTO> mesBuildingTeamList = this.machinePartTeamService
         .machinePartListByCondition(MesBuildingPartTeamDTOParam.builder().id(id).build());
      MesBuildingMachinePartTeamDTO teamDTO = mesBuildingTeamList.get(0);
      LambdaQueryWrapper<MesBuildingMachinePartTeamUserLink> queryWrapper = (LambdaQueryWrapper<MesBuildingMachinePartTeamUserLink>)new LambdaQueryWrapper<MesBuildingMachinePartTeamUserLink>()
         .eq(MesBuildingMachinePartTeamUserLink::getPartTeamId, teamDTO.getId());
      List<MesBuildingMachinePartTeamUserLink> teamUserLinkList = this.machinePartTeamUserLinkService.list(queryWrapper);
      List<MesBuildingMachinePartTeamUserLinkDTO> teamUserLinkDTOList = new ArrayList<>();
      teamUserLinkList.forEach(teamUser -> teamUserLinkDTOList.add(BeanUtil.copy(teamUser, MesBuildingMachinePartTeamUserLinkDTO.class)));
      teamDTO.setUserLinks(teamUserLinkDTOList);
      return teamDTO;
   }

   @Override
   public PageVO<MesBuildingTeamDTO> teamPage(MesBuildingTeamDTOParam dtoParam, Long sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(dtoParam));
   }

   @Override
   public List<UseTeamDTO> useTeam(Long userId) {
      List<Long> teamIds = this.teamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, userId))
         .stream()
         .map(MesBuildingTeamUserLink::getTeamId)
         .collect(Collectors.toList());
      return teamIds.size() == 0
         ? null
         : this.teamService.list((Wrapper<MesBuildingTeam>)Wrappers.<MesBuildingTeam>lambdaQuery().in(MesBuildingTeam::getId, teamIds)).stream().map(e -> {
            UseTeamDTO dto = BeanUtil.copy(e, UseTeamDTO.class);
            dto.setFactory(FactoryDetailDO.builder().id(e.getFactoryId()).name(this.factoryService.getById(e.getFactoryId()).getName()).build());
            dto.setProcessName(this.processService.getById(e.getProcessId()).getName());
            dto.setLeaderName(this.teamUserLinkService.getLeaderName(dto.getId()));
            dto.setProductionLineName(this.productionLineService.getById(e.getProductionLineId()).getName());
            return dto;
         }).collect(Collectors.toList());
   }

   @Override
   public boolean teamStatus(Long teamId, Boolean teamStatus) {
      MesBuildingTeam mesBuildingTeam = this.teamService.getById(teamId);
      Preconditions.checkArgument(this.teamService.getById(teamId) != null, "修改失败，未查询到相关班组");
      if (teamStatus.equals(Boolean.FALSE)) {
         List<MesInspectConfigTeamLink> list = this.inspectConfigTeamLinkService
            .list(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).eq(MesInspectConfigTeamLink::getTeamId, teamId));
         if (CollectionUtils.isNotEmpty(list)) {
            List<MesInspectConfig> configs = this.inspectConfigService
               .list(
                  Wrappers.lambdaQuery(MesInspectConfig.class)
                     .in(MesInspectConfig::getId, list.stream().map(e -> e.getInspectConfigId()).distinct().collect(Collectors.toList()))
                     .eq(MesInspectConfig::getStatus, 1)
               );
            Preconditions.checkArgument(CollectionUtils.isEmpty(configs), "操作失败,请清除质检基础配置中班组关联信息");
         }
      }

      mesBuildingTeam.setTeamStatus(teamStatus);
      return this.teamService.updateById(mesBuildingTeam);
   }

   @Override
   public boolean machinePartTeamStatus(Long teamId, Boolean teamStatus) {
      MesBuildingMachinePartTeam mesBuildingTeam = this.machinePartTeamService.getById(teamId);
      Preconditions.checkArgument(mesBuildingTeam != null, "修改失败，未查询到相关班组");
      mesBuildingTeam.setTeamStatus(teamStatus);
      return this.machinePartTeamService.updateById(mesBuildingTeam);
   }

   @Override
   public List<MesBuildingTeamDTO> workshopProductionLineTeamLeader(MesBuildingTeamDTOParam mesBuildingTeamDTOParam) {
      Long productionLineId = mesBuildingTeamDTOParam.getProductionLineId();
      Long processId = mesBuildingTeamDTOParam.getProcessId();
      MesBuildingProductionLine mesBuildingProductionLine = this.mesBuildingProductionLineService.getById(productionLineId);
      mesBuildingTeamDTOParam.setWorkshopId(mesBuildingProductionLine.getWorkshopId());
      List<MesBuildingTeamDTO> teamDTOList = new ArrayList<>();
      List<MesBuildingTeam> mesBuildingTeamList = this.teamService.listByCondition(BeanUtil.copy(mesBuildingTeamDTOParam, MesBuildingTeamDOParam.class));
      if (CollectionUtil.isEmpty(mesBuildingTeamList)) {
         return teamDTOList;
      }

      List<Long> teamIds = mesBuildingTeamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      Map<Long, List<MesBuildingProductProcessLink>> processLinkMap = this.processLinkService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcessLink.class).in(MesBuildingProductProcessLink::getTeamId, teamIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductProcessLink::getTeamId));
      Map<Long, MesBuildingProcess> processMap = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .in(MesBuildingProcess::getId, mesBuildingTeamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, List<MesBuildingTeamUserLinkDTO>> teams = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(MesBuildingTeamUserLink::getTeamId, CollUtil.getFieldValues(mesBuildingTeamList, "id", Long.class))
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingTeamUserLinkDTO.class))
         .collect(Collectors.groupingBy(MesBuildingTeamUserLinkDTO::getTeamId));
      Map<Long, MesBuildingWorkshop> workshopMap = this.workshopService
         .list(
            Wrappers.lambdaQuery(MesBuildingWorkshop.class)
               .in(MesBuildingWorkshop::getId, mesBuildingTeamList.stream().map(MesBuildingTeam::getWorkshopId).distinct().collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> lineMap = this.productionLineService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      mesBuildingTeamList.forEach(e -> {
         MesBuildingTeamDTO teamDTO = BeanUtil.copy(e, MesBuildingTeamDTO.class);
         teamDTO.setWorkshopName(workshopMap.get(e.getWorkshopId()).getName());
         teamDTO.setProductionLineName(lineMap.get(e.getProductionLineId()) == null ? "" : lineMap.get(e.getProductionLineId()).getName());
         teamDTO.setBoolBindProcess(processLinkMap.get(e.getId()) == null ? Boolean.FALSE : Boolean.TRUE);
         if (processMap.get(e.getProcessId()) != null) {
            MesBuildingProcess process = processMap.get(e.getProcessId());
            teamDTO.setProcessName(process.getName());
            teamDTO.setProductType(process.getProductType());
         }

         teamDTOList.add(teamDTO);
      });
      teamDTOList.forEach(e -> {
         List<MesBuildingTeamUserLinkDTO> userLinks = teams.get(e.getId());
         e.setUserLinkList(userLinks);
      });
      return teamDTOList;
   }

   private void checkTeamUser(List<MesBuildingTeamUserLinkDTOParam> mesBuildingTeamUserLinkList, Long processId) {
      List<MesBuildingTeamUserLinkDTOParam> leaderList = mesBuildingTeamUserLinkList.stream()
         .filter(MesBuildingTeamUserLinkDTOParam::getBoolLeaderEnum)
         .collect(Collectors.toList());
      Preconditions.checkArgument(leaderList.size() == 1, "添加失败，添加的组长只能有一位");
      Preconditions.checkArgument(mesBuildingTeamUserLinkList.stream().noneMatch(e -> e.getUserName() == null), "添加失败，人员姓名不能为空");
      Preconditions.checkArgument(mesBuildingTeamUserLinkList.stream().noneMatch(e -> e.getUserId() == null), "添加失败，人员id不能为空");
      Preconditions.checkArgument(mesBuildingTeamUserLinkList.size() > 1, "添加失败,未添加组长或组员");
      List<MesBuildingTeamUserLink> userLinks = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(
                  MesBuildingTeamUserLink::getUserId,
                  mesBuildingTeamUserLinkList.stream().map(MesBuildingTeamUserLinkDTOParam::getUserId).collect(Collectors.toList())
               )
         );
   }

   private void checkTeamUser2(
      List<MesBuildingTeamUserLinkDTOParam> mesBuildingTeamUserLinkList, Long processId, Long prodLineId, Boolean organizationType, Long teamId
   ) {
      Preconditions.checkArgument(
         mesBuildingTeamUserLinkList.stream().filter(MesBuildingTeamUserLinkDTOParam::getBoolLeaderEnum).count() == 1L, "添加失败，添加的组长只能有一位"
      );
      Preconditions.checkArgument(mesBuildingTeamUserLinkList.stream().noneMatch(e -> e.getUserName() == null), "添加失败，人员姓名不能为空");
      Preconditions.checkArgument(mesBuildingTeamUserLinkList.stream().noneMatch(e -> e.getUserId() == null), "添加失败，人员id不能为空");
      Preconditions.checkArgument(mesBuildingTeamUserLinkList.size() >= 1, "添加失败,未添加组长或组员");
      List<MesBuildingTeamUserLink> userLinks = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(
                  MesBuildingTeamUserLink::getUserId,
                  mesBuildingTeamUserLinkList.stream().map(MesBuildingTeamUserLinkDTOParam::getUserId).collect(Collectors.toList())
               )
         );
      if (userLinks != null && userLinks.size() > 0) {
         List<MesBuildingTeam> teamList = this.teamService.listByIds(userLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()));
         Preconditions.checkArgument(
            teamList.stream().noneMatch(e -> e.getProcessId().equals(processId) && e.getProductionLineId().equals(prodLineId)), "添加失败：用户已存在其他班组"
         );
      }
   }

   @Override
   public MesBuildingTeamByProLineDTO findProductionLineTeam(Long prodLineId) {
      List<MesBuildingTeam> teamList = this.baseMapper.listByLineId(prodLineId);
      List<MesBuildingInspectionTeam> inspectionTeamList = this.inspectionTeamService
         .list(Wrappers.lambdaQuery(MesBuildingInspectionTeam.class).in(prodLineId != null, MesBuildingInspectionTeam::getProductionLineId, prodLineId));
      MesBuildingTeamByProLineDTO lineTeamDTO = new MesBuildingTeamByProLineDTO();
      lineTeamDTO.setTeamList(teamList);
      lineTeamDTO.setInspectionTeamList(inspectionTeamList);
      return lineTeamDTO;
   }

   private void checkMachinePartTeamUser(MesBuildingPartTeamDTOParam dtoParam, Long processId) {
      List<MesBuildingMachinePartTeamUserLinkDTO> leaderList = dtoParam.getUserLinks()
         .stream()
         .filter(MesBuildingMachinePartTeamUserLinkDTO::getBoolLeaderEnum)
         .collect(Collectors.toList());
      Preconditions.checkArgument(leaderList.size() == 1, "添加失败，添加的组长只能有一位");
      Preconditions.checkArgument(dtoParam.getUserLinks().stream().noneMatch(e -> e.getUserName() == null), "添加失败，人员姓名不能为空");
      Preconditions.checkArgument(dtoParam.getUserLinks().stream().noneMatch(e -> e.getUserId() == null), "添加失败，人员id不能为空");
      Preconditions.checkArgument(dtoParam.getUserLinks().size() > 1, "添加失败,未添加组长或组员");
      List<MesBuildingMachinePartTeamDetail> teamDetails = this.machinePartTeamDetailService
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartTeamDetail.class)
               .eq(MesBuildingMachinePartTeamDetail::getMID, dtoParam.getMID())
               .eq(MesBuildingMachinePartTeamDetail::getDeviceName, dtoParam.getDeviceName())
         );
      if (dtoParam.getId() != null && teamDetails != null) {
         Preconditions.checkArgument(teamDetails.stream().allMatch(e -> e.getPartTeamId().equals(dtoParam.getId())), "(MID  + 设备名称)唯一的班组已存在");
      } else {
         Preconditions.checkArgument(CollectionUtils.isEmpty(teamDetails), "(MID  + 设备名称)唯一的班组已存在");
      }

      List<MesBuildingMachinePartTeamUserLink> userLinks = this.machinePartTeamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartTeamUserLink.class)
               .in(
                  MesBuildingMachinePartTeamUserLink::getUserId,
                  dtoParam.getUserLinks().stream().map(MesBuildingMachinePartTeamUserLinkDTO::getUserId).collect(Collectors.toList())
               )
         );
      if (userLinks != null && userLinks.size() > 0) {
         List<MesBuildingMachinePartTeam> teamList = this.machinePartTeamService
            .listByIds(userLinks.stream().map(MesBuildingMachinePartTeamUserLink::getPartTeamId).distinct().collect(Collectors.toList()));
         teamList = teamList.stream().filter(e -> e.getProcessId().equals(processId)).collect(Collectors.toList());
         Preconditions.checkArgument(
            teamList.stream().allMatch(s -> s.getOrganizationType().equals(dtoParam.getOrganizationType())), "班组配置的用户与该用户在其他班组配置的编制信息不一致"
         );
      }
   }

   public static <T> PageVO<T> listPage(Integer pageNum, Integer pageSize, List<T> collect) {
      Page<T> pages = new Page<>(pageNum, pageSize);
      int total = collect.size();
      pages.setTotal(total);
      int startIndex = (pageNum - 1) * pageSize;
      int endIndex = Math.min(startIndex + pageSize, total);
      pages.addAll(collect.subList(startIndex, endIndex));
      return new PageVO<>(pages);
   }
}
