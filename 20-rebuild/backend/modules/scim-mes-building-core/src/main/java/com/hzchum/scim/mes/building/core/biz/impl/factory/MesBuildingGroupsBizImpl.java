package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsInspectionTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingInspectionTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingGroupsTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingTeamTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsInspectionTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingGroupsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessDullDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingGroupsDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingGroupsMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MesBuildingGroupsBizImpl extends IBizImpl<MesBuildingGroupsService, MesBuildingGroupsMapper, MesBuildingGroups> implements MesBuildingGroupsBiz {
   @Autowired
   private MesBuildingGroupsTeamLinkBiz teamLinkBiz;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingGroupsInspectionTeamLinkBiz inspectionTeamLinkBiz;
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private MesBuildingTeamBiz teamBiz;
   @Autowired
   private MesBuildingInspectionTeamBiz inspectionTeamBiz;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private MesBuildingProductionLineService mesBuildingProductionLineService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingArtifactSchedulingBiz artifactSchedulingBiz;
   @Resource
   private MesBuildingGroupsTeamLinkService mesBuildingGroupsTeamLinkService;

   @Override
   public List<MesBuildingGroupsDTO> listByCondition(MesBuildingGroupsDTOParam dtoParam) {
      List<MesBuildingGroupsDTO> dtoList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingGroups.class)
               .eq(dtoParam.getName() != null, MesBuildingGroups::getName, dtoParam.getName())
               .eq(dtoParam.getFactoryId() != null, MesBuildingGroups::getFactoryId, dtoParam.getFactoryId())
               .eq(dtoParam.getWorkshopId() != null, MesBuildingGroups::getWorkshopId, dtoParam.getWorkshopId())
               .eq(dtoParam.getProductionLineId() != null, MesBuildingGroups::getProductionLineId, dtoParam.getProductionLineId())
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingGroupsDTO.class))
         .collect(Collectors.toList());
      List<MesBuildingGroupsTeamLink> teamLinkList = this.teamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.builder().build())
               .in(dtoList.size() > 0, MesBuildingGroupsTeamLink::getGroupsId, dtoList.stream().map(MesBuildingGroupsDO::getId).collect(Collectors.toList()))
         );
      List<MesBuildingGroupsInspectionTeamLink> inspectionTeamLinkList = this.inspectionTeamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.builder().build())
               .in(
                  dtoList.size() > 0,
                  MesBuildingGroupsInspectionTeamLink::getGroupsId,
                  dtoList.stream().map(MesBuildingGroupsDO::getId).collect(Collectors.toList())
               )
         );
      dtoList.forEach(
         e -> {
            e.setTeamIds(
               teamLinkList.stream().filter(t -> e.getId().equals(t.getGroupsId())).map(MesBuildingGroupsTeamLink::getTeamId).collect(Collectors.toList())
            );
            e.setInspectionTeamIds(
               inspectionTeamLinkList.stream()
                  .filter(t -> e.getId().equals(t.getGroupsId()))
                  .map(MesBuildingGroupsInspectionTeamLink::getInspectionTeamId)
                  .collect(Collectors.toList())
            );
         }
      );
      return dtoList;
   }

   @Override
   public PageVO<MesBuildingGroupsDTO> pageByCondition(MesBuildingGroupsDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(dtoParam));
   }

   @Override
   public Boolean saveGroups(MesBuildingGroupsDTOParam dtoParam) {
      return this.baseService.save(BeanUtil.copy(dtoParam, MesBuildingGroups.class).setUserId(UserUtil.getCurrentUserId()));
   }

   @Override
   public Boolean updateGroups(MesBuildingGroupsDTOParam dtoParam) {
      return this.baseService.updateById(BeanUtil.copy(dtoParam, MesBuildingGroups.class).setUserId(UserUtil.getCurrentUserId()));
   }

   @Override
   public Boolean removeGroupsByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            Preconditions.checkArgument(
               this.teamLinkBiz.count(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).eq(MesBuildingGroupsTeamLink::getGroupsId, e)) == 0,
               "操作失败！生产组下有未删除的班组"
            );
            Preconditions.checkArgument(
               this.inspectionTeamLinkBiz
                     .count(Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class).eq(MesBuildingGroupsInspectionTeamLink::getGroupsId, e))
                  == 0,
               "操作失败！生产组下有未删除的质检班组"
            );
            Preconditions.checkArgument(
               this.artifactSchedulingBiz
                     .list(
                        Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                           .eq(MesBuildingArtifactScheduling::getGroupsId, e)
                           .eq(MesBuildingArtifactScheduling::getIssueStatus, Boolean.FALSE)
                     )
                     .size()
                  == 0,
               "操作失败，该生产组下有未下发的构件排产，不可删除"
            );
            Preconditions.checkArgument(
               this.taskBiz
                     .list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getGroupsId, e).apply("complete_quantity<task_quantity"))
                     .size()
                  == 0,
               "操作失败，该生产组下有未完成的任务，不可删除"
            );
         }
      );
      this.teamLinkBiz.remove(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getGroupsId, ids));
      this.inspectionTeamLinkBiz
         .remove(Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class).in(MesBuildingGroupsInspectionTeamLink::getGroupsId, ids));
      this.baseService.removeByIds(ids);
      return null;
   }

   @Override
   public Boolean saveTeam(Long id, List<Long> teamIds) {
      MesBuildingGroups groups = this.baseService.getById(id);
      Preconditions.checkArgument(groups != null, "操作失败,生产组不存在!!!");
      Integer productionLineType = this.mesBuildingProductionLineService.getById(groups.getProductionLineId()).getProductionLineTypeEnum();
      this.teamLinkBiz.remove((Wrapper<MesBuildingGroupsTeamLink>)Wrappers.<MesBuildingGroupsTeamLink>lambdaQuery().eq(MesBuildingGroupsTeamLink::getGroupsId, id));
      if (teamIds != null && teamIds.size() > 0) {
         List<MesBuildingTeam> teamList = this.teamBiz.listByIds(teamIds);
         Preconditions.checkArgument(teamIds.size() == teamList.size(), "操作失败，id有误");
         Preconditions.checkArgument(teamIds.size() == teamList.stream().map(MesBuildingTeam::getProcessId).distinct().count(), "操作失败，同一工序只能有一个班组");
         teamList.forEach(
            team -> {
               Preconditions.checkArgument(team.getProductionLineTypeEnum().equals(productionLineType), "操作失败,班组生产线类型不一致!!!");
               MesBuildingProcess process = this.mesBuildingProcessService.getById(team.getProcessId());
               if (ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType())) {
                  List<MesBuildingGroupsTeamLink> teamLinks = this.teamLinkBiz
                     .list((Wrapper<MesBuildingGroupsTeamLink>)new LambdaQueryWrapper<MesBuildingGroupsTeamLink>().eq(MesBuildingGroupsTeamLink::getTeamId, team.getId()));
                  Preconditions.checkArgument(CollectionUtils.isEmpty(teamLinks), "新增失败,该钻孔类型班组已存在!!!");
               }
            }
         );
         teamIds.forEach(e -> this.teamLinkBiz.save(MesBuildingGroupsTeamLink.builder().groupsId(id).teamId(e).build()));
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean saveInspectionTeam(Long id, List<Long> teamIds) {
      MesBuildingGroups groups = this.baseService.getById(id);
      Preconditions.checkArgument(groups != null, "操作失败,生产组不存在!!!");
      Integer productionLineType = this.mesBuildingProductionLineService.getById(groups.getProductionLineId()).getProductionLineTypeEnum();
      List<Long> inspectionTeamLinkList = this.inspectionTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class).eq(MesBuildingGroupsInspectionTeamLink::getGroupsId, id))
         .stream()
         .map(MesBuildingGroupsInspectionTeamLink::getInspectionTeamId)
         .collect(Collectors.toList());
      Set<Long> removeProcessIdSet = new HashSet<>();
      if (inspectionTeamLinkList.size() != 0) {
         removeProcessIdSet = this.inspectionTeamBiz
            .listByIds(inspectionTeamLinkList)
            .stream()
            .map(MesBuildingInspectionTeam::getProcessId)
            .collect(Collectors.toSet());
      }

      this.inspectionTeamLinkBiz
         .remove((Wrapper<MesBuildingGroupsInspectionTeamLink>)Wrappers.<MesBuildingGroupsInspectionTeamLink>lambdaQuery().eq(MesBuildingGroupsInspectionTeamLink::getGroupsId, id));
      if (teamIds != null && teamIds.size() > 0) {
         List<MesBuildingInspectionTeam> teamList = this.inspectionTeamBiz.listByIds(teamIds);
         removeProcessIdSet = removeProcessIdSet.stream()
            .filter(e -> !teamList.stream().map(MesBuildingInspectionTeam::getProcessId).collect(Collectors.toList()).contains(e))
            .collect(Collectors.toSet());
         Preconditions.checkArgument(teamIds.size() == teamList.size(), "操作失败，id有误");
         teamList.forEach(
            team -> {
               Preconditions.checkArgument(team.getProductionLineTypeEnum().equals(productionLineType), "操作失败,生产线类型不一致!!!");
               MesBuildingProcess process = this.mesBuildingProcessService.getById(team.getProcessId());
               if (ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType())) {
                  List<MesBuildingGroupsInspectionTeamLink> teamLinks = this.inspectionTeamLinkBiz
                     .list(
                        (Wrapper<MesBuildingGroupsInspectionTeamLink>)new LambdaQueryWrapper<MesBuildingGroupsInspectionTeamLink>()
                           .eq(MesBuildingGroupsInspectionTeamLink::getInspectionTeamId, team.getId())
                     );
                  Preconditions.checkArgument(CollectionUtils.isEmpty(teamLinks), "新增失败,该钻孔类型质检班组已存在!!!");
               }
            }
         );
         teamIds.forEach(e -> this.inspectionTeamLinkBiz.save(MesBuildingGroupsInspectionTeamLink.builder().groupsId(id).inspectionTeamId(e).build()));
      }

      removeProcessIdSet.forEach(e -> this.taskBiz.deleteInspection(id, e));
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingFactoryDTO> getSchedulingGroupsTree(MesBuildingGroupsDTOParam dtoParam, Integer type) {
      return this.baseService
         .getSchedulingGroupsTree(BeanUtil.copy(dtoParam, MesBuildingGroupsDOParam.class), type)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingFactoryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingFactoryDTO> getSchedulingGroupsTreeNesting(MesBuildingGroupsDTOParam dtoParam, Integer type) {
      return this.baseService
         .getSchedulingGroupsTreeNesting(BeanUtil.copy(dtoParam, MesBuildingGroupsDOParam.class), type)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingFactoryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingFactoryDTO> getDrillGroupsTree(MesBuildingGroupsDTOParam dtoParam) {
      return this.baseService
         .getDrillGroupsTree(BeanUtil.copy(dtoParam, MesBuildingGroupsDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingFactoryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingGroups> getGroupsList(Long userId) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(userId == null ? UserUtil.getCurrentUserId() : userId);
      if (CollectionUtils.isEmpty(teamList)) {
         return Collections.emptyList();
      }

      List<Long> groupsId = this.teamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class)
               .in(MesBuildingGroupsTeamLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
         )
         .stream()
         .map(MesBuildingGroupsTeamLink::getGroupsId)
         .collect(Collectors.toList());
      return this.listByIds(groupsId);
   }

   @Override
   public List<MesBuildingGroupsTreeDO> getGroupsTreeList(Long userId) {
      Map<Long, MesBuildingTeam> teamMap = this.utilsBiz
         .selectTeamIdByUserId(userId == null ? UserUtil.getCurrentUserId() : userId)
         .stream()
         .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      if (teamMap.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, List<MesBuildingGroupsTeamLink>> teamLinkMap = this.teamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getTeamId, teamMap.keySet()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingGroupsTeamLink::getGroupsId));
      List<MesBuildingGroupsTreeDO> doList = new ArrayList<>();
      teamLinkMap.forEach(
         (groupsId, list) -> doList.add(
            MesBuildingGroupsTreeDO.builder()
               .id(groupsId)
               .teamList(
                  list.stream()
                     .map(e -> MesBuildingTeamTreeDO.builder().id(e.getId()).processId(teamMap.get(e.getTeamId()).getProcessId()).build())
                     .collect(Collectors.toList())
               )
               .build()
         )
      );
      return doList;
   }

   @Override
   public List<MesBuildingGroupsTreeDO> getGroupsListInspection(Long userId) {
      List<MesBuildingInspectionTeam> mesBuildingInspectionTeams = this.utilsBiz
         .selectInspectionTeamIdByUserId(userId == null ? UserUtil.getCurrentUserId() : userId);
      if (CollectionUtils.isEmpty(mesBuildingInspectionTeams)) {
         return new ArrayList<>();
      }

      Map<Long, MesBuildingInspectionTeam> teamMap = mesBuildingInspectionTeams.stream()
         .collect(Collectors.toMap(MesBuildingInspectionTeam::getId, Function.identity()));
      Map<Long, List<MesBuildingGroupsInspectionTeamLink>> teamLinkMap = this.inspectionTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class).in(MesBuildingGroupsInspectionTeamLink::getInspectionTeamId, teamMap.keySet()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingGroupsInspectionTeamLink::getGroupsId));
      List<MesBuildingGroupsTreeDO> doList = new ArrayList<>();
      teamLinkMap.forEach(
         (groupsId, list) -> doList.add(
            MesBuildingGroupsTreeDO.builder()
               .id(groupsId)
               .teamList(
                  list.stream()
                     .map(e -> MesBuildingTeamTreeDO.builder().id(e.getId()).processId(teamMap.get(e.getInspectionTeamId()).getProcessId()).build())
                     .collect(Collectors.toList())
               )
               .build()
         )
      );
      return doList;
   }

   @Override
   public GroupDetailDTO getTreeByGroupId(Long groupsId) {
      return this.baseMapper.getTreeByGroupId(groupsId);
   }

   @Override
   public List<GroupDetailDTO> getTreeByGroupIds(List<Long> groupsIds) {
      return this.baseMapper.getTreeByGroupIds(groupsIds);
   }

   @Override
   public List<TaskProcessDullDTO> processDriling(Long workShopId) {
      return this.baseMapper.processDriling(workShopId);
   }

   @Override
   public List<GroupDetailDTO> getProductionLineAndGroupsList(Integer productType, Long structureClassId) {
      return this.baseMapper.getProductionLineAndGroupsList(productType, structureClassId);
   }

   @Override
   public MesBuildingGroups selectgroupByproductionLine(String workshopName, String productionLineName, Integer productType) {
      return this.baseMapper.selectgroupByproductionLine(workshopName, productionLineName, productType);
   }
}
