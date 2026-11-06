package com.hzchum.scim.mes.enclosure.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureLineTeamLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureProductionLineBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.util.MesEnclosureUtilsBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureFactoryDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineTypeLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureWorkshopDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory.MesEnclosureTeamDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamUserLinkDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.SchedulingTeamTreeDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.UseTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamUserLinkDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineTypeLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureTeamMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureTeamBizImpl extends IBizImpl<MesEnclosureTeamService, MesEnclosureTeamMapper, MesEnclosureTeam> implements MesEnclosureTeamBiz {
   @Autowired
   private MesEnclosureTeamService teamService;
   @Autowired
   private MesEnclosureTeamBiz teamBiz;
   @Autowired
   private MesEnclosureTaskBiz taskBiz;
   @Autowired
   private MesEnclosureTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesEnclosureProcessService processService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesEnclosureProductionLineBiz lineBiz;
   @Autowired
   private MesEnclosureUtilsBiz utilsBiz;
   @Autowired
   private MesEnclosureLineTeamLinkBiz productionLineTeamLinkBiz;
   @Autowired
   private MesEnclosureProductionLineService enclosureProductionLineService;
   @Autowired
   private MesEnclosureProductionLineTypeLinkService productionLineTypeLinkService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveTeam(MesEnclosureTeamDTOParam dtoParam) {
      dtoParam.setProcessId(this.processService.list().get(0).getId());
      MesBuildingFactory factory = this.factoryService.getById(dtoParam.getFactoryId());
      this.checkTeamUser(dtoParam.getUserLinks(), dtoParam.getProcessId());
      MesEnclosureTeam team = BeanUtil.copy(dtoParam, MesEnclosureTeam.class);
      team.setFactoryId(factory.getId());
      this.teamService.save(team);
      dtoParam.getUserLinks().forEach(e -> this.teamUserLinkService.save(BeanUtil.copy(e, MesEnclosureTeamUserLink.class).setTeamId(team.getId())));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean teamUpdate(MesEnclosureTeamDTOParam dtoParam) {
      Preconditions.checkArgument(this.teamService.getById(dtoParam.getId()) != null, "修改失败，未查询到相关班组");
      MesEnclosureTeam team = BeanUtil.copy(dtoParam, MesEnclosureTeam.class);
      MesEnclosureProcess mesEnclosureProcess = this.processService.getById(team.getProcessId());
      this.teamService.updateById(team);
      this.teamUserLinkService.remove((Wrapper<MesEnclosureTeamUserLink>)Wrappers.<MesEnclosureTeamUserLink>lambdaQuery().eq(MesEnclosureTeamUserLink::getTeamId, team.getId()));
      this.checkTeamUser(dtoParam.getUserLinks(), team.getProcessId());
      dtoParam.getUserLinks().forEach(e -> this.teamUserLinkService.save(BeanUtil.copy(e, MesEnclosureTeamUserLink.class)));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean deleteTeamByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            Preconditions.checkArgument(this.teamService.getById(e) != null, "删除失败，未查询到相关班组");
            List<MesEnclosureLineTeamLink> productionLineTeamLinks = this.productionLineTeamLinkBiz
               .list(Wrappers.lambdaQuery(MesEnclosureLineTeamLink.class).eq(MesEnclosureLineTeamLink::getTeamId, e));
            Preconditions.checkArgument(productionLineTeamLinks == null || productionLineTeamLinks.size() == 0, "操作失败,请删除生产线班组配置信息");
            List<MesEnclosureTask> list = this.taskBiz
               .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTeamId, e).eq(MesEnclosureTask::getBoolCompleteEnum, false));
            Preconditions.checkArgument(list.size() == 0, "操作失败,改班组有未完成的任务");
            this.teamService.removeById(e);
            this.teamUserLinkService.remove(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getTeamId, e));
         }
      );
      return true;
   }

   @Override
   public List<MesEnclosureTeamDTO> listByCondition(MesEnclosureTeamDTOParam dtoParam) {
      List<MesEnclosureTeam> mesEnclosureTeamList = this.teamService.listByCondition(BeanUtil.copy(dtoParam, MesEnclosureTeamDOParam.class));
      List<MesEnclosureTeamDTO> teamDTOList = new ArrayList<>();
      mesEnclosureTeamList.forEach(e -> {
         MesEnclosureTeamDTO teamDTO = BeanUtil.copy(e, MesEnclosureTeamDTO.class);
         if (this.processService.getById(e.getProcessId()) != null) {
            MesEnclosureProcess process = this.processService.getById(e.getProcessId());
            teamDTO.setProcessName(process.getName());
         }

         teamDTOList.add(teamDTO);
      });
      Map<Long, String> lineMap;
      if (CollectionUtils.isNotEmpty(mesEnclosureTeamList)) {
         List<MesEnclosureProductionLine> enclosureProductionLines = this.enclosureProductionLineService
            .listByIds(
               mesEnclosureTeamList.stream().filter(e -> e.getProductionLineId() != null).map(e -> e.getProductionLineId()).collect(Collectors.toList())
            );
         lineMap = enclosureProductionLines.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
      } else {
         lineMap = Collections.emptyMap();
      }

      teamDTOList.forEach(
         e -> {
            e.setProductionName(lineMap.get(e.getProductionLineId()));
            LambdaQueryWrapper<MesEnclosureTeamUserLink> queryWrapper = (LambdaQueryWrapper<MesEnclosureTeamUserLink>)new LambdaQueryWrapper<MesEnclosureTeamUserLink>()
               .eq(MesEnclosureTeamUserLink::getTeamId, e.getId());
            List<MesEnclosureTeamUserLink> teamUserLinkList = this.teamUserLinkService.list(queryWrapper);
            List<MesEnclosureTeamUserLinkDTO> teamUserLinkDTOList = new ArrayList<>();
            teamUserLinkList.forEach(teamUser -> teamUserLinkDTOList.add(BeanUtil.copy(teamUser, MesEnclosureTeamUserLinkDTO.class)));
            e.setUserLinks(teamUserLinkDTOList);
         }
      );
      return teamDTOList;
   }

   @Override
   public MesEnclosureTeamDTO teamById(Long id) {
      MesEnclosureTeam team = this.teamService.getById(id);
      Preconditions.checkArgument(team != null, "查询失败，未查询到相关班组");
      MesEnclosureTeamDTO teamDTO = BeanUtil.copy(team, MesEnclosureTeamDTO.class);
      teamDTO.setProcessName(this.processService.getById(team.getProcessId()).getName());
      teamDTO.setUserLinks(
         this.teamUserLinkService
            .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getTeamId, teamDTO.getId()))
            .stream()
            .map(e -> BeanUtil.copy(e, MesEnclosureTeamUserLinkDTO.class))
            .collect(Collectors.toList())
      );
      return teamDTO;
   }

   @Override
   public PageVO<MesEnclosureTeamDTO> teamPage(MesEnclosureTeamDTOParam dtoParam, Long sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(dtoParam));
   }

   @Override
   public List<UseTeamDTO> useTeam(Long userId) {
      List<Long> teamIds = this.teamUserLinkService
         .list((Wrapper<MesEnclosureTeamUserLink>)Wrappers.<MesEnclosureTeamUserLink>lambdaQuery().eq(MesEnclosureTeamUserLink::getUserId, userId))
         .stream()
         .map(MesEnclosureTeamUserLink::getTeamId)
         .collect(Collectors.toList());
      return teamIds.size() == 0
         ? null
         : this.teamService.list((Wrapper<MesEnclosureTeam>)Wrappers.<MesEnclosureTeam>lambdaQuery().in(MesEnclosureTeam::getId, teamIds)).stream().map(e -> {
            UseTeamDTO dto = BeanUtil.copy(e, UseTeamDTO.class);
            dto.setFactory(FactoryDetailDO.builder().id(e.getFactoryId()).name(this.factoryService.getById(e.getFactoryId()).getName()).build());
            dto.setLeaderName(this.teamUserLinkService.getLeaderName(dto.getId()));
            return dto;
         }).collect(Collectors.toList());
   }

   private void checkTeamUser(List<MesEnclosureTeamUserLinkDTOParam> mesEnclosureTeamUserLinkList, Long processId) {
      List<MesEnclosureTeamUserLinkDTOParam> leaderList = mesEnclosureTeamUserLinkList.stream()
         .filter(MesEnclosureTeamUserLinkDTOParam::getBoolLeaderEnum)
         .collect(Collectors.toList());
      Preconditions.checkArgument(leaderList.size() == 1, "添加失败，添加的组长只能有一位");
      Preconditions.checkArgument(mesEnclosureTeamUserLinkList.stream().noneMatch(e -> e.getUserName() == null), "添加失败，人员姓名不能为空");
      Preconditions.checkArgument(mesEnclosureTeamUserLinkList.stream().noneMatch(e -> e.getUserId() == null), "添加失败，人员id不能为空");
      Preconditions.checkArgument(mesEnclosureTeamUserLinkList.size() >= 1, "添加失败,未添加组长或组员");
      List<MesEnclosureTeamUserLink> userLinks = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class)
               .in(
                  MesEnclosureTeamUserLink::getUserId,
                  mesEnclosureTeamUserLinkList.stream().map(MesEnclosureTeamUserLinkDTOParam::getUserId).collect(Collectors.toList())
               )
         );
      if (CollectionUtils.isNotEmpty(userLinks)) {
         Preconditions.checkArgument(false, "添加失败：用户已存在其他班组");
      }
   }

   @Override
   public List<MesEnclosureFactoryDO> getSchedulingGroupsTree(SchedulingTeamTreeDTO voRequest) {
      LambdaQueryWrapper<MesEnclosureProductionLine> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(MesEnclosureProductionLine::getBoolEnabledEnum, 1);
      if (voRequest.getFactoryId() != null) {
         wrapper.eq(MesEnclosureProductionLine::getFactoryId, voRequest.getFactoryId());
      }

      if (voRequest.getWorkshopId() != null) {
         wrapper.eq(MesEnclosureProductionLine::getWorkshopId, voRequest.getWorkshopId());
      }

      if (voRequest.getProductionLineId() != null) {
         wrapper.eq(MesEnclosureProductionLine::getId, voRequest.getProductionLineId());
      }

      if (voRequest.getType() != null) {
         wrapper.apply(voRequest.getType() + "& type>0");
      }

      List<MesEnclosureProductionLine> lineList = this.lineBiz.list(wrapper);
      if (CollectionUtils.isEmpty(lineList)) {
         return new ArrayList<>();
      }

      Map<Long, MesBuildingFactory> fMap = this.factoryService
         .list(
            Wrappers.lambdaQuery(MesBuildingFactory.class)
               .in(MesBuildingFactory::getId, lineList.stream().map(MesEnclosureProductionLine::getFactoryId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingFactory::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, MesBuildingWorkshop> wMap = this.workshopService
         .list(
            Wrappers.lambdaQuery(MesBuildingWorkshop.class)
               .in(MesBuildingWorkshop::getId, lineList.stream().map(MesEnclosureProductionLine::getWorkshopId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, List<MesEnclosureProductionLine>> factoryMap = lineList.stream().collect(Collectors.groupingBy(MesEnclosureProductionLine::getFactoryId));
      List<MesEnclosureFactoryDO> dtos = new ArrayList<>();

      for (Long factoryId : factoryMap.keySet()) {
         MesBuildingFactory factory = fMap.get(factoryId);
         MesEnclosureFactoryDO build = MesEnclosureFactoryDO.builder()
            .id(factory.getId())
            .tagColor(factory.getTagColor())
            .boolEnabledEnum(factory.getBoolEnabledEnum())
            .sort(factory.getSort())
            .remark(factory.getRemark())
            .userId(factory.getUserId())
            .name(factory.getName())
            .shortName(factory.getShortName())
            .build();
         List<MesEnclosureProductionLine> workshops = factoryMap.get(factoryId);
         Map<Long, List<MesEnclosureProductionLine>> workshopMap = workshops.stream().collect(Collectors.groupingBy(MesEnclosureProductionLine::getWorkshopId));
         List<MesEnclosureWorkshopDO> workshopList = new ArrayList<>();

         for (Long workshopId : workshopMap.keySet()) {
            MesBuildingWorkshop workshop = wMap.get(workshopId);
            MesEnclosureWorkshopDO workshopDO = MesEnclosureWorkshopDO.builder()
               .id(workshop.getId())
               .name(workshop.getName())
               .factoryId(factoryId)
               .sort(workshop.getSort())
               .boolEnabledEnum(workshop.getBoolEnabledEnum())
               .userId(workshop.getUserId())
               .build();
            List<MesEnclosureProductionLine> lines = workshopMap.get(workshopId);
            List<MesEnclosureProductionLineDO> productionLineList = new ArrayList<>();

            for (MesEnclosureProductionLine line : lines) {
               MesEnclosureProductionLineDO linedo = MesEnclosureProductionLineDO.builder()
                  .id(line.getId())
                  .name(line.getName())
                  .boolEnabledEnum(line.getBoolEnabledEnum())
                  .factoryId(line.getFactoryId())
                  .factoryName(factory.getName())
                  .workshopId(line.getWorkshopId())
                  .type(line.getType())
                  .userId(line.getUserId())
                  .targetProduction(line.getTargetProduction())
                  .sort(line.getSort())
                  .workshopName(workshop.getName())
                  .build();
               List<MesEnclosureLineTeamLink> teamLinks = this.productionLineTeamLinkBiz
                  .list(Wrappers.lambdaQuery(MesEnclosureLineTeamLink.class).eq(MesEnclosureLineTeamLink::getLineId, line.getId()));
               List<MesEnclosureTeamDTO> teamList = new ArrayList<>();

               for (MesEnclosureLineTeamLink teamLink : teamLinks) {
                  MesEnclosureTeamDTO mesEnclosureTeamDTO = this.teamBiz.teamById(teamLink.getTeamId());
                  teamList.add(mesEnclosureTeamDTO);
               }

               linedo.setTeamList(teamList);
               productionLineList.add(linedo);
            }

            workshopDO.setProductionLineList(productionLineList);
            workshopList.add(workshopDO);
         }

         build.setWorkshopList(workshopList);
         dtos.add(build);
      }

      return dtos;
   }

   @Override
   public List<MesEnclosureFactoryDO> getSchedulingGroupsTreeV2(SchedulingTeamTreeDTO voRequest) {
      LambdaQueryWrapper<MesEnclosureProductionLine> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(MesEnclosureProductionLine::getBoolEnabledEnum, 1);
      if (voRequest.getFactoryId() != null) {
         wrapper.eq(MesEnclosureProductionLine::getFactoryId, voRequest.getFactoryId());
      }

      if (voRequest.getWorkshopId() != null) {
         wrapper.eq(MesEnclosureProductionLine::getWorkshopId, voRequest.getWorkshopId());
      }

      if (voRequest.getProductionLineId() != null) {
         wrapper.eq(MesEnclosureProductionLine::getId, voRequest.getProductionLineId());
      }

      List<MesEnclosureProductionLineTypeLink> lineTypeLinkList = this.productionLineTypeLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureProductionLineTypeLink.class).eq(MesEnclosureProductionLineTypeLink::getDictionaryId, voRequest.getType()));
      List<Long> lineIds;
      if (CollectionUtils.isNotEmpty(lineTypeLinkList)) {
         lineIds = lineTypeLinkList.stream().map(e -> e.getProductionLineId()).distinct().collect(Collectors.toList());
      } else {
         lineIds = Collections.emptyList();
      }

      if (CollectionUtils.isEmpty(lineIds)) {
         return new ArrayList<>();
      }

      List<MesEnclosureProductionLine> lineList = this.lineBiz.list(wrapper);
      lineList = lineList.stream().filter(s -> lineIds.contains(s.getId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(lineList)) {
         return new ArrayList<>();
      }

      Map<Long, MesBuildingFactory> fMap = this.factoryService
         .list(
            Wrappers.lambdaQuery(MesBuildingFactory.class)
               .in(MesBuildingFactory::getId, lineList.stream().map(MesEnclosureProductionLine::getFactoryId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingFactory::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, MesBuildingWorkshop> wMap = this.workshopService
         .list(
            Wrappers.lambdaQuery(MesBuildingWorkshop.class)
               .in(MesBuildingWorkshop::getId, lineList.stream().map(MesEnclosureProductionLine::getWorkshopId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, List<MesEnclosureProductionLine>> factoryMap = lineList.stream().collect(Collectors.groupingBy(MesEnclosureProductionLine::getFactoryId));
      List<MesEnclosureFactoryDO> dtos = new ArrayList<>();

      for (Long factoryId : factoryMap.keySet()) {
         MesBuildingFactory factory = fMap.get(factoryId);
         MesEnclosureFactoryDO build = MesEnclosureFactoryDO.builder()
            .id(factory.getId())
            .tagColor(factory.getTagColor())
            .boolEnabledEnum(factory.getBoolEnabledEnum())
            .sort(factory.getSort())
            .remark(factory.getRemark())
            .userId(factory.getUserId())
            .name(factory.getName())
            .shortName(factory.getShortName())
            .build();
         List<MesEnclosureProductionLine> workshops = factoryMap.get(factoryId);
         Map<Long, List<MesEnclosureProductionLine>> workshopMap = workshops.stream().collect(Collectors.groupingBy(MesEnclosureProductionLine::getWorkshopId));
         List<MesEnclosureWorkshopDO> workshopList = new ArrayList<>();

         for (Long workshopId : workshopMap.keySet()) {
            MesBuildingWorkshop workshop = wMap.get(workshopId);
            MesEnclosureWorkshopDO workshopDO = MesEnclosureWorkshopDO.builder()
               .id(workshop.getId())
               .name(workshop.getName())
               .factoryId(factoryId)
               .sort(workshop.getSort())
               .boolEnabledEnum(workshop.getBoolEnabledEnum())
               .userId(workshop.getUserId())
               .build();
            List<MesEnclosureProductionLine> lines = workshopMap.get(workshopId);
            List<MesEnclosureProductionLineDO> productionLineList = new ArrayList<>();

            for (MesEnclosureProductionLine line : lines) {
               MesEnclosureProductionLineDO linedo = MesEnclosureProductionLineDO.builder()
                  .id(line.getId())
                  .name(line.getName())
                  .boolEnabledEnum(line.getBoolEnabledEnum())
                  .factoryId(line.getFactoryId())
                  .factoryName(factory.getName())
                  .workshopId(line.getWorkshopId())
                  .type(line.getType())
                  .userId(line.getUserId())
                  .targetProduction(line.getTargetProduction())
                  .sort(line.getSort())
                  .workshopName(workshop.getName())
                  .build();
               List<MesEnclosureLineTeamLink> teamLinks = this.productionLineTeamLinkBiz
                  .list(Wrappers.lambdaQuery(MesEnclosureLineTeamLink.class).eq(MesEnclosureLineTeamLink::getLineId, line.getId()));
               List<MesEnclosureTeamDTO> teamList = new ArrayList<>();

               for (MesEnclosureLineTeamLink teamLink : teamLinks) {
                  MesEnclosureTeamDTO mesEnclosureTeamDTO = this.teamBiz.teamById(teamLink.getTeamId());
                  teamList.add(mesEnclosureTeamDTO);
               }

               linedo.setTeamList(teamList);
               productionLineList.add(linedo);
            }

            workshopDO.setProductionLineList(productionLineList);
            workshopList.add(workshopDO);
         }

         build.setWorkshopList(workshopList);
         dtos.add(build);
      }

      return dtos;
   }

   @Override
   public List<IdAndNameDO> listNameByIds(List<Long> teamIds) {
      return this.baseMapper.listNameByIds(teamIds);
   }
}
