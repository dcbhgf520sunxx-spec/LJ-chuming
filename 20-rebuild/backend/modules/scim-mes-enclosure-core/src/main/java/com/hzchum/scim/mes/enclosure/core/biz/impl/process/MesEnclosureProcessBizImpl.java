package com.hzchum.scim.mes.enclosure.core.biz.impl.process;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.enclosure.core.api.biz.process.MesEnclosureProcessBiz;
import com.hzchum.scim.mes.enclosure.core.api.enums.ProcessInspectTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.enums.ProcessReportTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.MesEnclosureProcessDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process.MesEnclosureProcessDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureInspectionTeamService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureLineTeamLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureProcessBizImpl implements MesEnclosureProcessBiz {
   @Autowired
   private MesEnclosureProcessService processService;
   @Autowired
   private MesEnclosureTeamService teamService;
   @Autowired
   private MesEnclosureInspectionTeamService inspectionTeamService;
   @Autowired
   private MesEnclosureTaskService taskService;
   @Autowired
   private MesEnclosureProductionLineService productionLineService;
   @Autowired
   private MesEnclosureTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesEnclosureLineTeamLinkService mesEnclosureLineTeamLinkService;

   @Override
   public Boolean removeByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            Preconditions.checkArgument(
               this.teamService.list((Wrapper<MesEnclosureTeam>)Wrappers.<MesEnclosureTeam>lambdaQuery().eq(MesEnclosureTeam::getProcessId, e)).size() == 0, "删除失败，请先删除对应班组"
            );
            Preconditions.checkArgument(
               this.inspectionTeamService
                     .list((Wrapper<MesEnclosureInspectionTeam>)Wrappers.<MesEnclosureInspectionTeam>lambdaQuery().eq(MesEnclosureInspectionTeam::getProcessId, e))
                     .size()
                  == 0,
               "删除失败，请先删除对应的质检班组"
            );
         }
      );
      this.processService.removeByIds(ids);
      return null;
   }

   @Override
   public List<MesEnclosureProcessDTO> listByCondition(Boolean organizationType) {
      return this.processService
         .list((Wrapper<MesEnclosureProcess>)Wrappers.<MesEnclosureProcess>lambdaQuery().orderByAsc(MesEnclosureProcess::getSort))
         .stream()
         .map(e -> BeanUtil.copy(e, MesEnclosureProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesEnclosureProcessDTO> list() {
      return this.processService
         .list((Wrapper<MesEnclosureProcess>)Wrappers.<MesEnclosureProcess>lambdaQuery().orderByAsc(MesEnclosureProcess::getSort))
         .stream()
         .map(e -> BeanUtil.copy(e, MesEnclosureProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesEnclosureProcessDTO> processPage(MesEnclosureProcessDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, sort),
         this.processService
            .list(
               ((Wrappers.<MesEnclosureProcess>lambdaQuery()
                        .like(dtoParam.getName() != null, MesEnclosureProcess::getName, dtoParam.getName()))
                     .eq(dtoParam.getInspectType() != null, MesEnclosureProcess::getInspectType, dtoParam.getInspectType()))
                  .eq(dtoParam.getReportType() != null, MesEnclosureProcess::getReportType, dtoParam.getReportType())
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesEnclosureProcessDTO.class))
            .collect(Collectors.toList())
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<MesEnclosureProcessDTOParam> list) {
      Set<String> names = list.stream().map(MesEnclosureProcessDTOParam::getName).collect(Collectors.toSet());
      Preconditions.checkArgument(names.size() == list.size(), "操作失败,工序名称不能重复!!!");
      Preconditions.checkArgument(list.size() == 1, "操作失败，围护有且只有一道工序");
      Map<String, Long> oldProcessMap = this.processService.list().stream().collect(Collectors.toMap(MesEnclosureProcess::getName, MesEnclosureProcess::getId));
      list.forEach(
         e -> {
            if (oldProcessMap.get(e.getName()) != null) {
               if (e.getId() != null) {
                  this.processService
                     .updateById(MesEnclosureProcess.builder().id(e.getId()).sort(e.getSort()).name(e.getName()).userId(UserUtil.getCurrentUserId()).build());
               }
            } else {
               this.processService
                  .save(
                     MesEnclosureProcess.builder()
                        .name(e.getName())
                        .inspectType(ProcessInspectTypeEnum.BATCH_UNSCAN.getType())
                        .reportType(ProcessReportTypeEnum.BATCH_UNSCAN.getType())
                        .sort(e.getSort())
                        .userId(UserUtil.getCurrentUserId())
                        .build()
                  );
            }
         }
      );
      List<Long> removeIdList = new ArrayList<>();

      for (String key : oldProcessMap.keySet()) {
         if (list.stream().noneMatch(e -> e.getName().equals(key))) {
            Preconditions.checkArgument(
               this.teamService.list(Wrappers.lambdaQuery(MesEnclosureTeam.class).eq(MesEnclosureTeam::getProcessId, oldProcessMap.get(key))).size() == 0,
               "操作失败：请先删除该工序对应的生产班组"
            );
            Preconditions.checkArgument(
               this.inspectionTeamService
                     .list(Wrappers.lambdaQuery(MesEnclosureInspectionTeam.class).eq(MesEnclosureInspectionTeam::getProcessId, oldProcessMap.get(key)))
                     .size()
                  == 0,
               "操作失败：请先删除该工序对应的质检班组"
            );
            removeIdList.add(oldProcessMap.get(key));
         }
      }

      if (removeIdList.size() > 0) {
         this.processService.removeByIds(removeIdList);
      }

      return Boolean.TRUE;
   }

   @Override
   public List<MesEnclosureProcessDTO> listRivetWeldAssembleList() {
      return this.processService
         .list((Wrapper<MesEnclosureProcess>)Wrappers.<MesEnclosureProcess>lambdaQuery().orderByAsc(MesEnclosureProcess::getSort))
         .stream()
         .map(e -> BeanUtil.copy(e, MesEnclosureProcessDTO.class))
         .collect(Collectors.toList());
   }
}
