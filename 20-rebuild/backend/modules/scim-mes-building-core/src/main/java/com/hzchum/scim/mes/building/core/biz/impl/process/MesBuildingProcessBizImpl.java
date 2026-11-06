package com.hzchum.scim.mes.building.core.biz.impl.process;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProcessBiz;
import com.hzchum.scim.mes.building.core.api.enums.PartProdModeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProcessInspectTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProcessReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.BuildingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcessWage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessNode;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessRequestDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.ProcessListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.ProcessWageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.ProcessWageDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessWageService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingProcessBizImpl implements MesBuildingProcessBiz {
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingInspectionTeamService inspectionTeamService;
   @Autowired
   private MesBuildingProcessWageService wageService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingGroupsTeamLinkService mesBuildingGroupsTeamLinkService;
   @Autowired
   private MesBuildingAssistService assistService;

   @Override
   public Boolean removeByIds(List<Long> ids) {
      List<MesBuildingTeam> teamList = this.teamService.list((Wrapper<MesBuildingTeam>)Wrappers.<MesBuildingTeam>lambdaQuery().in(MesBuildingTeam::getProcessId, ids));
      Preconditions.checkArgument(CollectionUtils.isEmpty(teamList), "删除失败，请先删除对应班组");
      this.processService.removeByIds(ids);
      return null;
   }

   @Override
   public List<MesBuildingProcessDTO> listByCondition(Integer productType, Boolean organizationType) {
      return this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(((Wrappers.<MesBuildingProcess>lambdaQuery()
                        .eq(productType != null, MesBuildingProcess::getProductType, productType))
                     .orderByAsc(MesBuildingProcess::getProductType))
                  .orderByAsc(MesBuildingProcess::getProductionLineTypeEnum))
               .orderByAsc(MesBuildingProcess::getSort)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProcessNode> getPartListTree() {
      LambdaQueryWrapper<MesBuildingProcess> mesBuildingProcessLambdaQueryWrapper = new LambdaQueryWrapper<>();
      mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getProductType, 1);
      mesBuildingProcessLambdaQueryWrapper.in(MesBuildingProcess::getType, 4, 8);
      mesBuildingProcessLambdaQueryWrapper.in(MesBuildingProcess::getProductCategoryType, 1, 2);
      mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getBoolFixedProcess, 1);
      List<MesBuildingProcess> mesBuildingProcessList = this.processService.list(mesBuildingProcessLambdaQueryWrapper);
      return buildTree(mesBuildingProcessList);
   }

   public static List<MesBuildingProcessNode> buildTree(List<MesBuildingProcess> mesBuildingProcessList) {
      List<MesBuildingProcessNode> rootNodes = new ArrayList<>();

      for (MesBuildingProcess process : mesBuildingProcessList) {
         MesBuildingProcessNode categoryNode = findOrCreateNode(rootNodes, process.getProductCategoryType() == 1 ? "板材零件" : "型材零件");
         MesBuildingProcessNode modeNode = findOrCreateNode(categoryNode.getChildren(), process.getPartProdMode() == 1 ? "数控切割" : "半自动切割");
         MesBuildingProcessNode typeNode = findOrCreateNode(modeNode.getChildren(), process.getType() == 4 ? "下料类" : "钻孔类");
         typeNode.addProcessName(process.getId(), process.getName());
      }

      return rootNodes;
   }

   private static MesBuildingProcessNode findOrCreateNode(List<MesBuildingProcessNode> nodes, String name) {
      for (MesBuildingProcessNode node : nodes) {
         if (node.getName().equals(name)) {
            return node;
         }
      }

      MesBuildingProcessNode newNode = new MesBuildingProcessNode(name);
      nodes.add(newNode);
      return newNode;
   }

   @Override
   public List<MesBuildingProcessDTO> listByCondition(Integer productType, Integer ProductionLineTypeEnum) {
      return this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(((((Wrappers.<MesBuildingProcess>lambdaQuery()
                              .eq(productType != null, MesBuildingProcess::getProductType, productType))
                           .eq(BaseEntity::getBoolDeleteEnum, 0))
                        .eq(MesBuildingProcess::getProductionLineTypeEnum, ProductionLineTypeEnum))
                     .orderByAsc(MesBuildingProcess::getProductType))
                  .orderByAsc(MesBuildingProcess::getProductionLineTypeEnum))
               .orderByAsc(MesBuildingProcess::getSort)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public Map<String, ProcessListDTO> listGroupByCondition() {
      List<MesBuildingProcess> processList = this.processService.list();
      List<MesBuildingProcess> fixedList = processList.stream().filter(MesBuildingProcess::getBoolFixedProcess).collect(Collectors.toList());
      List<MesBuildingProcess> unFixedList = processList.stream().filter(s -> !s.getBoolFixedProcess()).collect(Collectors.toList());
      HashMap<String, ProcessListDTO> map = new HashMap<>();
      map.put("fixedList", this.processInventory(fixedList));
      map.put("unFixedList", this.processInventory(unFixedList));
      return map;
   }

   @Override
   public List<MesBuildingProcessDTO> listByConditionV2(Integer productType, Integer boolFixedProcess) {
      List<MesBuildingProcess> processList = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getBoolFixedProcess, boolFixedProcess)
               .eq(MesBuildingProcess::getProductType, productType)
         );
      return processList.stream().sorted(Comparator.comparingInt(MesBuildingProcess::getSort)).map(e -> {
         MesBuildingProcessDTO copy = BeanUtil.copy(e, MesBuildingProcessDTO.class);
         copy.setBoolFixedProcess(e.getBoolFixedProcess() ? 1 : 0);
         return copy;
      }).collect(Collectors.toList());
   }

   public ProcessListDTO processInventory(List<MesBuildingProcess> list) {
      return ProcessListDTO.builder()
         .assembleProcessList(
            list.stream()
               .filter(s -> s.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
               .sorted(Comparator.comparingInt(MesBuildingProcess::getSort))
               .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
               .collect(Collectors.toList())
         )
         .artifactProcessList(
            list.stream()
               .filter(s -> s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
               .sorted(Comparator.comparingInt(MesBuildingProcess::getSort))
               .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
               .collect(Collectors.toList())
         )
         .machinePartProcessList(
            list.stream()
               .filter(s -> s.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
               .sorted(Comparator.comparingInt(MesBuildingProcess::getSort))
               .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
               .collect(Collectors.toList())
         )
         .build();
   }

   @Override
   public ProcessListDTO listGroupByCondition(Integer productionLineTypeEnum) {
      return ProcessListDTO.builder()
         .assembleProcessList(
            this.processService
               .list(
                  (Wrapper<MesBuildingProcess>)((Wrappers.<MesBuildingProcess>lambdaQuery()
                           .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                        .eq(MesBuildingProcess::getProductionLineTypeEnum, productionLineTypeEnum))
                     .orderByAsc(MesBuildingProcess::getSort)
               )
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
               .collect(Collectors.toList())
         )
         .artifactProcessList(
            this.processService
               .list(
                  (Wrapper<MesBuildingProcess>)((Wrappers.<MesBuildingProcess>lambdaQuery()
                           .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingProcess::getProductionLineTypeEnum, productionLineTypeEnum))
                     .orderByAsc(MesBuildingProcess::getSort)
               )
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
               .collect(Collectors.toList())
         )
         .machinePartProcessList(
            this.processService
               .list(
                  (Wrapper<MesBuildingProcess>)((Wrappers.<MesBuildingProcess>lambdaQuery()
                           .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType()))
                        .eq(MesBuildingProcess::getProductionLineTypeEnum, productionLineTypeEnum))
                     .orderByAsc(MesBuildingProcess::getId)
               )
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
               .collect(Collectors.toList())
         )
         .build();
   }

   @Override
   public PageVO<MesBuildingProcessDTO> processPage(MesBuildingProcessDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize, sort),
         this.processService
            .list(
               ((((Wrappers.<MesBuildingProcess>lambdaQuery()
                              .like(dtoParam.getName() != null, MesBuildingProcess::getName, dtoParam.getName()))
                           .eq(dtoParam.getInspectType() != null, MesBuildingProcess::getInspectType, dtoParam.getInspectType()))
                        .eq(dtoParam.getProductType() != null, MesBuildingProcess::getProductType, dtoParam.getProductType()))
                     .eq(dtoParam.getProductionLineTypeEnum() != null, MesBuildingProcess::getProductionLineTypeEnum, dtoParam.getProductionLineTypeEnum()))
                  .eq(dtoParam.getReportType() != null, MesBuildingProcess::getReportType, dtoParam.getReportType())
            )
            .stream()
            .map(
               e -> BeanUtil.copy(e, MesBuildingProcessDTO.class)
                  .setProcessWageList(
                     this.wageService
                        .list(
                           (Wrappers.<MesBuildingProcessWage>lambdaQuery().eq(MesBuildingProcessWage::getProcessId, e.getId()))
                              .eq(dtoParam.getOrganizationType() != null, MesBuildingProcessWage::getOrganizationType, dtoParam.getOrganizationType())
                        )
                        .stream()
                        .map(wage -> BeanUtil.copy(wage, ProcessWageDTO.class))
                        .collect(Collectors.toList())
                  )
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public Boolean saveProcessWage(List<ProcessWageDTOParam> dtoParamList) {
      dtoParamList.forEach(
         e -> this.wageService
            .saveOrUpdate(
               BeanUtil.copy(e, MesBuildingProcessWage.class).setUserId(UserUtil.getCurrentUserId()),
               (Wrapper<MesBuildingProcessWage>)((Wrappers.<MesBuildingProcessWage>lambdaQuery()
                        .eq(MesBuildingProcessWage::getProcessId, e.getProcessId()))
                     .eq(MesBuildingProcessWage::getOrganizationType, e.getOrganizationType()))
                  .eq(MesBuildingProcessWage::getWageQuotaType, e.getWageQuotaType())
            )
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<MesBuildingProcessDTOParam> list, Integer productType) {
      Preconditions.checkArgument(!ProductTypeEnum.MACHINE_PART.getType().equals(productType), "操作失败，零件不可编辑工序!!!");
      Preconditions.checkArgument(ProductTypeEnum.isExist(productType) && !productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()), "操作失败，产品类型不正确");
      Set<String> names = list.stream().map(MesBuildingProcessDTOParam::getName).collect(Collectors.toSet());
      Preconditions.checkArgument(names.size() == list.size(), "操作失败,工序名称不能重复!!!");
      List<MesBuildingProcessDTOParam> collect = list.stream().filter(e -> e.getType().equals(ProcessTypeEnum.PAINT.getType())).collect(Collectors.toList());
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         Preconditions.checkArgument(list.size() > 0, "操作失败，零件最少有一道工序");
      }

      Map<String, Long> oldProcessMap = this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(Wrappers.<MesBuildingProcess>lambdaQuery().eq(MesBuildingProcess::getProductType, productType))
               .eq(MesBuildingProcess::getProductionLineTypeEnum, ProductionLineTypeEnum.TRADITIONAL_LINE.getType())
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getName, MesBuildingProcess::getId));
      list.forEach(
         e -> {
            if (oldProcessMap.get(e.getName()) != null) {
               if (e.getId() != null) {
                  this.processService
                     .updateById(
                        MesBuildingProcess.builder()
                           .id(e.getId())
                           .sort(e.getSort())
                           .name(e.getName())
                           .type(e.getType())
                           .userId(UserUtil.getCurrentUserId())
                           .build()
                     );
               }
            } else {
               this.processService
                  .save(
                     MesBuildingProcess.builder()
                        .name(e.getName())
                        .inspectType(ProcessInspectTypeEnum.BATCH_UNSCAN.getType())
                        .reportType(ProcessReportTypeEnum.BATCH_UNSCAN.getType())
                        .productType(productType)
                        .sort(e.getSort())
                        .type(e.getType())
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
               this.productProcessLinkService
                     .list(
                        (Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery().eq(MesBuildingProductProcessLink::getProcessId, oldProcessMap.get(key))
                     )
                     .size()
                  == 0,
               "操作失败:请先删除对应工序定义"
            );
            Preconditions.checkArgument(
               this.teamService.list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProcessId, oldProcessMap.get(key))).size() == 0,
               "操作失败：请先删除对应的生产班组"
            );
            Preconditions.checkArgument(
               this.inspectionTeamService
                     .list(Wrappers.lambdaQuery(MesBuildingInspectionTeam.class).eq(MesBuildingInspectionTeam::getProcessId, oldProcessMap.get(key)))
                     .size()
                  == 0,
               "操作失败：请先删除对应的质检班组"
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
   public List<MesBuildingProcessDO> getByProcess(Long id) {
      MesBuildingTask task = this.taskService.getById(id);
      Preconditions.checkArgument(task != null, "任务不能为空");
      List<MesBuildingTeam> mesBuildingTeams = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProductionLineId, task.getProductionLineId()));
      List<MesBuildingProcess> mesBuildingProcesses = this.processService
         .listByIds(mesBuildingTeams.stream().map(s -> s.getProcessId()).collect(Collectors.toSet()));
      return mesBuildingProcesses.stream().map(e -> BeanUtil.copy(e, MesBuildingProcessDO.class)).collect(Collectors.toList());
   }

   @Override
   public List<BuildingTeamDTO> getByTeam(Long taskId, Long processId) {
      List<Long> productionLineIdList = new ArrayList<>();
      MesBuildingTask task = this.taskService.getById(taskId);
      Preconditions.checkArgument(task != null, "任务不能为空");
      MesBuildingProductionLine productionLine = this.productionLineService.getById(task.getProductionLineId());
      Preconditions.checkArgument(productionLine != null, "生产线不能为空");
      productionLineIdList.add(productionLine.getId());
      List<MesBuildingAssist> assistList = this.assistService
         .list(
            (Wrapper<MesBuildingAssist>)(new LambdaQueryWrapper<MesBuildingAssist>().eq(MesBuildingAssist::getTaskId, task.getId()))
               .eq(MesBuildingAssist::getProcessId, processId)
         );
      if (CollectionUtils.isNotEmpty(assistList)) {
         int assistQuantity = assistList.stream().mapToInt(MesBuildingAssist::getQuantity).sum();
         List<Long> assistProductionLineIds = assistList.stream().map(MesBuildingAssist::getProductionLineId).distinct().collect(Collectors.toList());
         productionLineIdList.addAll(assistProductionLineIds);
         if (assistQuantity >= task.getTaskQuantity() && !assistProductionLineIds.contains(productionLine.getId())) {
            productionLineIdList.remove(productionLine.getId());
         }
      }

      return this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(
                  MesBuildingTeamUserLink::getTeamId,
                  this.teamService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTeam.class)
                           .in(MesBuildingTeam::getProductionLineId, productionLineIdList)
                           .eq(MesBuildingTeam::getProcessId, processId)
                     )
                     .stream()
                     .map(MesBuildingTeam::getId)
                     .collect(Collectors.toList())
               )
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE)
         )
         .stream()
         .map(e -> BuildingTeamDTO.builder().id(e.getId()).leaderId(e.getUserId()).leaderName(e.getUserName()).build())
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProcessDTO> listRivetWeldArtyFactList() {
      return this.processService
         .list(
            (Wrapper<MesBuildingProcess>)((Wrappers.<MesBuildingProcess>lambdaQuery()
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType()))
               .orderByAsc(MesBuildingProcess::getSort)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProcessDTO> listRivetWeldAssembleList() {
      return this.processService
         .list(
            (Wrapper<MesBuildingProcess>)((Wrappers.<MesBuildingProcess>lambdaQuery()
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType()))
               .orderByAsc(MesBuildingProcess::getSort)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProcessDTO> getWorkshopByProcessList(Long workshopId) {
      return this.processService.getWorkshopByProcessList(workshopId);
   }

   @Override
   public List<MesBuildingProcessDTO> partCutWayList(Integer partProdMode, Integer productCategoryType, Integer type) {
      LambdaQueryWrapper<MesBuildingProcess> mesBuildingProcessLambdaQueryWrapper = new LambdaQueryWrapper<>();
      if (partProdMode != null) {
         mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getPartProdMode, partProdMode);
      }

      if (productCategoryType != null) {
         mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getProductCategoryType, productCategoryType);
      }

      if (type != null) {
         mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getType, type);
      }

      mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getProductType, 1);
      mesBuildingProcessLambdaQueryWrapper.eq(MesBuildingProcess::getBoolFixedProcess, true);
      List<MesBuildingProcess> mesBuildingProcesseList = this.processService.list(mesBuildingProcessLambdaQueryWrapper);
      return mesBuildingProcesseList != null && mesBuildingProcesseList.size() > 0
         ? mesBuildingProcesseList.stream().map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class)).collect(Collectors.toList())
         : new ArrayList<>();
   }

   @Override
   public Boolean saveOrUpdateProcess(MesBuildingProcessRequestDTO voRequest) {
      if (voRequest.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
         Preconditions.checkArgument(voRequest.getPartProdMode() != null, "零件生产类型不能为空");
         Preconditions.checkArgument(PartProdModeEnum.isExist(voRequest.getPartProdMode()), "零件生产类型传参类型不存在");
      }

      if (StrUtil.isNotBlank(voRequest.getCodename())) {
         List<MesBuildingProcess> processList = this.processService
            .list(
               (Wrapper<MesBuildingProcess>)((new LambdaQueryWrapper<MesBuildingProcess>()
                        .ne(voRequest.getId() != null, MesBuildingProcess::getId, voRequest.getId()))
                     .eq(MesBuildingProcess::getProductType, voRequest.getProductType()))
                  .eq(MesBuildingProcess::getCodename, voRequest.getCodename())
            );
         Preconditions.checkArgument(CollUtil.isEmpty(processList), "代号重复");
      }

      if (voRequest.getId() == null) {
         LambdaQueryWrapper<MesBuildingProcess> wrapper = (LambdaQueryWrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>()
               .eq(MesBuildingProcess::getName, voRequest.getName()))
            .eq(MesBuildingProcess::getProductType, voRequest.getProductType());
         Preconditions.checkArgument(this.processService.count(wrapper) == 0, "新增失败，工序名重复");
      } else {
         if (voRequest.isOnlySortModified(this.processService.getById(voRequest.getId()))) {
            this.processService.updateById(BeanUtil.copy(voRequest, MesBuildingProcess.class));
            return true;
         }

         List<MesBuildingTeam> teamList = this.teamService
            .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProcessId, voRequest.getId()));
         MesBuildingProcess processOld = this.processService.getById(voRequest.getId());
         if (!StrUtil.isNotBlank(voRequest.getCodename()) || !StrUtil.isBlank(processOld.getCodename())) {
            Preconditions.checkArgument(CollectionUtils.isEmpty(teamList), "工序已存在班组配置使用不可编辑");
         }
      }

      MesBuildingProcess process = BeanUtil.copy(voRequest, MesBuildingProcess.class);
      process.setUserId(UserUtil.getCurrentUserId());
      this.processService.saveOrUpdate(process);
      return true;
   }
}
