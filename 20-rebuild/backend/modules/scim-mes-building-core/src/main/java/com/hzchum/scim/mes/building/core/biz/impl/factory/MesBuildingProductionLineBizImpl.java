package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsInspectionTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingProductionLineTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingTeamTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLineLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ArtifactSchedulingLineInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductionLineSchedulingInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingLineSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingProductionLineDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingProductionLineMapper;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.system.core.api.biz.MesBuildingProductionLineTeamLinkBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingProductionLineTeamLink;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
public class MesBuildingProductionLineBizImpl
   extends IBizImpl<MesBuildingProductionLineService, MesBuildingProductionLineMapper, MesBuildingProductionLine>
   implements MesBuildingProductionLineBiz {
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private SysAssembleConfigService sysAssembleConfigService;
   @Autowired
   private SysStructureClassificationService sysStructureClassificationService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private SysSteelClassificationService sysSteelClassificationService;
   @Autowired
   private MesBuildingProductionLineLinkService productionLineLinkService;
   @Autowired
   private MesBuildingGroupsTeamLinkBiz teamLinkBiz;
   @Autowired
   private MesBuildingGroupsInspectionTeamLinkBiz inspectionTeamLinkBiz;
   @Autowired
   private MesBuildingGroupsService mesBuildingGroupsService;
   @Resource
   private MesBuildingProductionLineTeamLinkBiz lineTeamLinkBiz;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private MesBuildingTeamBiz teamBiz;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesInspectConfigTeamLinkService configTeamLinkService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public Boolean productionLineUpdateState(MesBuildingProductionLineDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getId() != null & dtoParam.getBoolEnabledEnum() != null, "传入数据有误");
      MesBuildingProductionLine productionLine = this.baseService.getById(dtoParam.getId());
      productionLine.setBoolEnabledEnum(dtoParam.getBoolEnabledEnum());
      if (dtoParam.getBoolEnabledEnum()) {
         Preconditions.checkArgument(this.workshopService.getById(productionLine.getWorkshopId()).getBoolEnabledEnum(), "操作失败，请先启用车间");
      }

      MesBuildingTask taskList = this.taskService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getProductionLineId, dtoParam.getId())
               .apply("task_quantity > complete_quantity")
               .last("limit 1")
         );
      Preconditions.checkArgument(taskList == null, "存在未完成任务");
      List<MesBuildingTeam> teamList = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProductionLineId, productionLine.getId()));
      teamList.forEach(e -> e.setTeamStatus(dtoParam.getBoolEnabledEnum()));
      this.teamService.updateBatchById(teamList);
      Preconditions.checkArgument(
         this.baseService
               .list(
                  (Wrapper<MesBuildingProductionLine>)(((Wrappers.<MesBuildingProductionLine>lambdaQuery()
                              .eq(MesBuildingProductionLine::getWorkshopId, productionLine.getWorkshopId()))
                           .eq(MesBuildingProductionLine::getFactoryId, productionLine.getFactoryId()))
                        .eq(MesBuildingProductionLine::getProductType, dtoParam.getProductType()))
                     .eq(MesBuildingProductionLine::getName, productionLine.getName())
               )
               .size()
            <= 1,
         "操作失败，该车间下不允许有重名生产线"
      );
      this.baseService.updateById(productionLine);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProductionLine(MesBuildingProductionLineDTOParam dtoParam) {
      MesBuildingProductionLine productionLine = BeanUtil.copy(dtoParam, MesBuildingProductionLine.class);
      MesBuildingWorkshop workshop = this.workshopService.getById(dtoParam.getWorkshopId());
      List<MesBuildingProductProcess> processList = this.productProcessService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getProductionLineId, dtoParam.getId()));
      Preconditions.checkArgument(CollectionUtils.isEmpty(processList), "操作失败，产线已在质检基础配置");
      productionLine.setFactoryId(workshop.getFactoryId());
      this.utilsBiz.checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(null, productionLine.getWorkshopId(), null, null, null, null);
      Preconditions.checkArgument(
         this.baseService
               .list(
                  (Wrapper<MesBuildingProductionLine>)(((Wrappers.<MesBuildingProductionLine>lambdaQuery()
                              .eq(MesBuildingProductionLine::getWorkshopId, productionLine.getWorkshopId()))
                           .eq(MesBuildingProductionLine::getFactoryId, productionLine.getFactoryId()))
                        .eq(MesBuildingProductionLine::getProductType, dtoParam.getProductType()))
                     .eq(MesBuildingProductionLine::getName, productionLine.getName())
               )
               .size()
            == 0,
         "操作失败，该车间下不允许有重名生产线"
      );
      productionLine.setBoolEnabledEnum(true);
      productionLine.setMesProductEnum(workshop.getType());
      this.baseService.save(productionLine);
      if (dtoParam.getLinkIdList() != null) {
         dtoParam.getLinkIdList()
            .forEach(
               e -> this.productionLineLinkService.save(MesBuildingProductionLineLink.builder().productionLineId(productionLine.getId()).linkId(e).build())
            );
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeByIds(List<Long> ids) {
      ids.forEach(e -> {});
      Preconditions.checkArgument(
         this.productProcessService.count(Wrappers.lambdaQuery(MesBuildingProductProcess.class).in(MesBuildingProductProcess::getProductionLineId, ids)) == 0,
         "删除失败，产线下关联配置工序无法删除"
      );
      Preconditions.checkArgument(
         this.teamBiz.count(Wrappers.lambdaQuery(MesBuildingTeam.class).in(MesBuildingTeam::getProductionLineId, ids)) == 0, "删除失败，产线下关联班组无法删除"
      );
      Preconditions.checkArgument(
         this.productProcessService.count(Wrappers.lambdaQuery(MesBuildingProductProcess.class).in(MesBuildingProductProcess::getProductionLineId, ids)) == 0,
         "删除失败，产线下已配置工序无法删除"
      );
      this.baseService.removeByIds(ids);
      this.productionLineLinkService
         .remove((Wrapper<MesBuildingProductionLineLink>)Wrappers.<MesBuildingProductionLineLink>lambdaQuery().in(MesBuildingProductionLineLink::getProductionLineId, ids));
      return Boolean.TRUE;
   }

   @Override
   public List<ProductionLineDTO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType) {
      return this.baseService
         .productionLineList(factoryId, workshopId, productionLineId, productType)
         .stream()
         .map(e -> BeanUtil.copy(e, ProductionLineDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<IdAndNameDTO> getTypeByProductType(Integer productType, Integer productionLineType) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "操作失败，参数不正确");
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         return this.sysStructureClassificationService
            .list(Wrappers.lambdaQuery())
            .stream()
            .map(e -> IdAndNameDTO.builder().id(e.getId()).name(e.getClassificationName()).build())
            .collect(Collectors.toList());
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         return this.sysAssembleConfigService
            .list()
            .stream()
            .map(e -> IdAndNameDTO.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         return this.sysSteelClassificationService
            .list()
            .stream()
            .map(e -> IdAndNameDTO.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
      } else {
         throw new IllegalArgumentException("操作失败：暂时不支持的类型");
      }
   }

   @Override
   public PageVO<MesBuildingProductionLineDTO> productionLinePage(MesBuildingProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listByCondition(dtoParam));
   }

   @Override
   public List<MesBuildingProductionLineDTO> listByCondition(MesBuildingProductionLineDTOParam dtoParam) {
      List<MesBuildingProductionLineDTO> dotList = this.baseService
         .list(
            (Wrapper<MesBuildingProductionLine>)((((((((Wrappers.<MesBuildingProductionLine>lambdaQuery()
                                       .like(dtoParam.getName() != null, MesBuildingProductionLine::getName, dtoParam.getName()))
                                    .eq(dtoParam.getFactoryId() != null, MesBuildingProductionLine::getFactoryId, dtoParam.getFactoryId()))
                                 .eq(dtoParam.getWorkshopId() != null, MesBuildingProductionLine::getWorkshopId, dtoParam.getWorkshopId()))
                              .eq(dtoParam.getBoolEnabledEnum() != null, MesBuildingProductionLine::getBoolEnabledEnum, dtoParam.getBoolEnabledEnum()))
                           .eq(
                              dtoParam.getProductionLineTypeEnum() != null,
                              MesBuildingProductionLine::getProductionLineTypeEnum,
                              dtoParam.getProductionLineTypeEnum()
                           ))
                        .eq(dtoParam.getProductType() != null, MesBuildingProductionLine::getProductType, dtoParam.getProductType()))
                     .eq(dtoParam.getMesProductEnum() != null, MesBuildingProductionLine::getMesProductEnum, dtoParam.getMesProductEnum()))
                  .orderByDesc(MesBuildingProductionLine::getBoolEnabledEnum))
               .orderByAsc(MesBuildingProductionLine::getSort)
         )
         .stream()
         .map(e -> {
            MesBuildingProductionLineDTO dto = BeanUtil.copy(e, MesBuildingProductionLineDTO.class);
            dto.setFactoryName(this.factoryService.getById(dto.getFactoryId()).getName());
            dto.setWorkshopName(this.workshopService.getById(dto.getWorkshopId()).getName());
            return dto;
         })
         .collect(Collectors.toList());
      if (dotList.size() != 0) {
         List<MesBuildingProductionLineLink> linkList = this.productionLineLinkService
            .list(
               (Wrapper<MesBuildingProductionLineLink>)Wrappers.<MesBuildingProductionLineLink>lambdaQuery()
                  .in(MesBuildingProductionLineLink::getProductionLineId, dotList.stream().map(MesBuildingProductionLineDO::getId).collect(Collectors.toList()))
            );
         Map<Long, String> artifactTraditionalMap = this.sysStructureClassificationService
            .list(Wrappers.<SysStructureClassification>lambdaQuery())
            .stream()
            .collect(Collectors.toMap(SysStructureClassification::getId, SysStructureClassification::getClassificationName));
         Map<Long, String> assembleMap = this.sysAssembleConfigService
            .list()
            .stream()
            .collect(Collectors.toMap(SysAssembleConfig::getId, SysAssembleConfig::getName));
         Map<Long, String> factoryMap = this.factoryService
            .list(
               (Wrapper<MesBuildingFactory>)Wrappers.<MesBuildingFactory>lambdaQuery()
                  .in(MesBuildingFactory::getId, dotList.stream().map(MesBuildingProductionLineDO::getFactoryId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingFactory::getId, MesBuildingFactory::getName));
         Map<Long, String> workshopMap = this.workshopService
            .list(
               (Wrapper<MesBuildingWorkshop>)Wrappers.<MesBuildingWorkshop>lambdaQuery()
                  .in(MesBuildingWorkshop::getId, dotList.stream().map(MesBuildingProductionLineDO::getWorkshopId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingWorkshop::getId, MesBuildingWorkshop::getName));
         dotList.forEach(
            e -> {
               e.setFactoryName(factoryMap.get(e.getFactoryId()));
               e.setWorkshopName(workshopMap.get(e.getWorkshopId()));
               e.setTypeList(
                  e.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())
                     ? null
                     : linkList.stream().filter(item -> item.getProductionLineId().equals(e.getId())).map(item -> {
                        if (e.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                           return IdAndNameDTO.builder().id(item.getLinkId()).name(artifactTraditionalMap.get(item.getLinkId())).build();
                        } else if (e.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                           return IdAndNameDTO.builder().id(item.getLinkId()).name(assembleMap.get(item.getLinkId())).build();
                        } else if (e.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                           return null;
                        } else {
                           throw new IllegalArgumentException("操作失败：暂时不支持的类型");
                        }
                     }).collect(Collectors.toList())
               );
            }
         );
      }

      return dotList;
   }

   @Override
   public Boolean update(MesBuildingProductionLineDTOParam dtoParam) {
      MesBuildingProductionLine productionLine = BeanUtil.copy(dtoParam, MesBuildingProductionLine.class).setUserId(UserUtil.getCurrentUserId());
      MesBuildingProductionLine line = this.baseService.getById(dtoParam.getId());
      Preconditions.checkArgument(line != null, "操作失败，id不正确");
      if (!line.getProductType().equals(dtoParam.getProductType())) {
         Preconditions.checkArgument(
            this.productProcessService
                  .count((Wrapper<MesBuildingProductProcess>)Wrappers.<MesBuildingProductProcess>lambdaQuery().eq(MesBuildingProductProcess::getProductionLineId, dtoParam.getId()))
               == 0,
            "操作失败，产线已配置 " + ProductTypeEnum.getNameByType(line.getProductType()) + " 工序"
         );
         Preconditions.checkArgument(
            this.teamBiz.count((Wrapper<MesBuildingTeam>)Wrappers.<MesBuildingTeam>lambdaQuery().eq(MesBuildingTeam::getProductionLineId, dtoParam.getId())) == 0,
            "操作失败，产线已关联班组，请删除关联班组后修改"
         );
      }

      this.baseService.updateById(productionLine);
      this.productionLineLinkService
         .remove((Wrapper<MesBuildingProductionLineLink>)Wrappers.<MesBuildingProductionLineLink>lambdaQuery().eq(MesBuildingProductionLineLink::getProductionLineId, productionLine.getId()));
      if (dtoParam.getLinkIdList() != null) {
         dtoParam.getLinkIdList()
            .forEach(e -> this.productionLineLinkService.save(MesBuildingProductionLineLink.builder().linkId(e).productionLineId(dtoParam.getId()).build()));
      }

      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingProductionLineSumDO> selectProductLine(
      String factoryId, String workShopId, String productionLineId, Integer pageNumber, Integer pageSize, int type
   ) {
      return this.baseService.selectProductLine(factoryId, workShopId, productionLineId, type);
   }

   @Override
   public MesBuildingProductionLine selectByid(Long productionLineId) {
      return this.baseService.getById(productionLineId);
   }

   @Override
   public List<MesBuildingProductionLineSumDO> selectProductLineByids(Set<Long> lineIds) {
      return this.baseService.selectProductLineByids(lineIds);
   }

   @Override
   public List<String> productionLineByNameList(MesBuildingProductionLineDTOParam dtoParam) {
      List<MesBuildingProductionLineDTO> mesBuildingProductionLineDTOS = this.listByCondition(dtoParam);
      return mesBuildingProductionLineDTOS.stream().map(MesBuildingProductionLineDO::getName).distinct().collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingFactoryDTO> getSchedulingLineTree(MesBuildingTeamDTOParam dtoParam, Integer type) {
      if (type == null) {
         if (dtoParam.getStructureClassId() != null) {
            if (dtoParam.getProductType().equals(TaskTypeEnum.ARTIFACT.getType())) {
               SysStructureClassification structureClassification = this.sysStructureClassificationService.getById(dtoParam.getStructureClassId());
               Preconditions.checkArgument(structureClassification != null, "操作失败,产品种类不存在");
               if (structureClassification.getMesProductEnum().equals(BuildingTypeEnum.BUILDING.getType())) {
                  type = 1;
               } else {
                  type = 2;
               }
            } else if (dtoParam.getProductType().equals(TaskTypeEnum.ASSEMBLE.getType())) {
               SysAssembleConfig assembleConfig = this.sysAssembleConfigService.getById(dtoParam.getStructureClassId());
               Preconditions.checkArgument(assembleConfig != null, "操作失败,产品种类不存在");
               if (assembleConfig.getMesProductEnum().equals(BuildingTypeEnum.BUILDING.getType())) {
                  type = 1;
               } else {
                  type = 2;
               }
            }
         } else {
            type = 1;
         }
      }

      List<MesBuildingFactoryDTO> schedulingLineTree = this.baseService.getSchedulingLineTree(BeanUtil.copy(dtoParam, MesBuildingTeamDOParam.class), type);
      if (schedulingLineTree == null) {
         return Collections.emptyList();
      }

      List<MesBuildingProductProcess> mesBuildingProductProcessList = this.productProcessService
         .list((Wrapper<MesBuildingProductProcess>)new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
      mesBuildingProductProcessList = mesBuildingProductProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
      Map<String, MesBuildingProductProcess> productProcessMap = mesBuildingProductProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductionLineId() + "_" + s.getProductType() + "_" + s.getTypeId(), Function.identity()));
      schedulingLineTree.forEach(
         e -> {
            if (e.getWorkshopList() != null) {
               e.getWorkshopList()
                  .forEach(
                     w -> {
                        if (w.getProductionLineList() != null) {
                           w.getProductionLineList()
                              .forEach(
                                 p -> p.setHasProcess(
                                    productProcessMap.containsKey(p.getId() + "_" + dtoParam.getProductType() + "_" + dtoParam.getStructureClassId())
                                 )
                              );
                        }
                     }
                  );
            }
         }
      );
      return schedulingLineTree;
   }

   @Override
   public List<ProductionLineSchedulingInfoDTO> getProductionLineSchedulingInfoV8(LineSchedulingInfoDTOParam dtoParam, Integer type) {
      if (type == null) {
         if (dtoParam.getTypeId() != null) {
            if (dtoParam.getProductType().equals(TaskTypeEnum.ARTIFACT.getType())) {
               SysStructureClassification structureClassification = this.sysStructureClassificationService.getById(dtoParam.getTypeId());
               Preconditions.checkArgument(structureClassification != null, "操作失败,产品种类不存在");
               if (structureClassification.getMesProductEnum().equals(BuildingTypeEnum.BUILDING.getType())) {
                  type = 1;
               } else {
                  type = 2;
               }
            } else if (dtoParam.getProductType().equals(TaskTypeEnum.ASSEMBLE.getType())) {
               SysAssembleConfig assembleConfig = this.sysAssembleConfigService.getById(dtoParam.getTypeId());
               Preconditions.checkArgument(assembleConfig != null, "操作失败,产品种类不存在");
               if (assembleConfig.getMesProductEnum().equals(BuildingTypeEnum.BUILDING.getType())) {
                  type = 1;
               } else {
                  type = 2;
               }
            }
         } else {
            type = 1;
         }
      }

      List<MesBuildingProductProcess> mesBuildingProductProcessList = this.productProcessService
         .list((Wrapper<MesBuildingProductProcess>)new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
      mesBuildingProductProcessList = mesBuildingProductProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
      Map<String, MesBuildingProductProcess> productProcessMap = mesBuildingProductProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductionLineId() + "_" + s.getProductType() + "_" + s.getTypeId(), Function.identity()));
      List<ProductionLineSchedulingInfoDTO> productionLineDTOS = this.baseMapper
         .productionLineSchedulingInfo(dtoParam.getProjectId(), dtoParam.getWorkshopId(), dtoParam.getProductType(), dtoParam.getTypeId(), type);
      if (CollectionUtils.isEmpty(productionLineDTOS)) {
         return Collections.emptyList();
      }

      Map<Long, SchedulingInfoDTO> schedulingInfoMap = this.baseMapper
         .findLineSchedulingInfo(dtoParam.getProjectId(), dtoParam.getWorkshopId(), dtoParam.getProductType(), dtoParam.getTypeId())
         .stream()
         .collect(Collectors.toMap(SchedulingInfoDTO::getLineId, Function.identity()));
      productionLineDTOS.forEach(lineDTO -> {
         SchedulingInfoDTO schedulingInfoDTO = schedulingInfoMap.get(lineDTO.getProductionLineId());
         this.setSchedulingInfo(lineDTO, schedulingInfoDTO);
      });
      productionLineDTOS.forEach(
         e -> e.setHasProcess(productProcessMap.containsKey(e.getProductionLineId() + "_" + dtoParam.getProductType() + "_" + dtoParam.getTypeId()))
      );
      return productionLineDTOS;
   }

   private void setSchedulingInfo(ProductionLineSchedulingInfoDTO lineDTO, SchedulingInfoDTO schedulingInfoDTO) {
      if (schedulingInfoDTO != null) {
         lineDTO.setAvgScheduleTon(this.safeBigDecimal(schedulingInfoDTO.getAvgScheduleTon()));
         lineDTO.setAvgScheduleCount(this.safeBigDecimal(schedulingInfoDTO.getAvgScheduleCount()));
         lineDTO.setTotalScheduleCount(this.safeBigDecimal(schedulingInfoDTO.getTotalScheduleCount()));
         lineDTO.setTotalScheduleTon(this.safeBigDecimal(schedulingInfoDTO.getTotalScheduleTon()));
         lineDTO.setUncompletedCount(this.safeBigDecimal(schedulingInfoDTO.getUncompletedCount()));
         lineDTO.setUncompletedTon(this.safeBigDecimal(schedulingInfoDTO.getUncompletedTon()));
         lineDTO.setThisProjectCompletedCount(this.safeBigDecimal(schedulingInfoDTO.getThisProjectCompletedCount()));
         lineDTO.setThisProjectCompletedTon(this.safeBigDecimal(schedulingInfoDTO.getThisProjectCompletedTon()));
      } else {
         lineDTO.setAvgScheduleTon(BigDecimal.ZERO);
         lineDTO.setAvgScheduleCount(BigDecimal.ZERO);
         lineDTO.setTotalScheduleCount(BigDecimal.ZERO);
         lineDTO.setTotalScheduleTon(BigDecimal.ZERO);
         lineDTO.setUncompletedCount(BigDecimal.ZERO);
         lineDTO.setUncompletedTon(BigDecimal.ZERO);
         lineDTO.setThisProjectCompletedCount(BigDecimal.ZERO);
         lineDTO.setThisProjectCompletedTon(BigDecimal.ZERO);
      }
   }

   private BigDecimal safeBigDecimal(BigDecimal value) {
      return value != null && value.compareTo(BigDecimal.ZERO) != 0 ? value : BigDecimal.ZERO;
   }

   @Override
   public List<MesBuildingFactoryDTO> getEnclosureSchedulingLineTree(MesBuildingTeamDTOParam dtoParam) {
      List<MesBuildingFactoryDTO> schedulingLineTree = this.baseService
         .getEnclosureSchedulingLineTree(BeanUtil.copy(dtoParam, MesBuildingTeamDOParam.class), MesProductEnum.ENCLOSURE.getType());
      return schedulingLineTree == null ? Collections.emptyList() : schedulingLineTree;
   }

   @Override
   public List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getLinesRecordSummary(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingLineSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary2(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getLinesRecordSummary(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingLineSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProductionLine> getProdLinesList(Long userId, Boolean teamType) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(userId == null ? UserUtil.getCurrentUserId() : userId);
      if (CollectionUtils.isEmpty(teamList)) {
         return Collections.emptyList();
      }

      List<Long> productionIds = this.lineTeamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingProductionLineTeamLink.class)
               .in(MesBuildingProductionLineTeamLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
               .eq(teamType != null, MesBuildingProductionLineTeamLink::getTeamType, teamType)
         )
         .stream()
         .map(MesBuildingProductionLineTeamLink::getProductionLineId)
         .collect(Collectors.toList());
      return this.listByIds(productionIds);
   }

   @Override
   public List<MesBuildingProductionLineTreeDO> getInspectTeamLink(List<Long> inspectConfigIds) {
      List<MesInspectConfigTeamLink> teamLinks = this.configTeamLinkService
         .list(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).in(MesInspectConfigTeamLink::getInspectConfigId, inspectConfigIds));
      Map<Long, List<MesBuildingTeamTreeDO>> inspectTeamMap = teamLinks.stream()
         .collect(
            Collectors.groupingBy(
               s -> s.getInspectConfigId(), Collectors.mapping(s -> MesBuildingTeamTreeDO.builder().id(s.getTeamId()).build(), Collectors.toList())
            )
         );
      if (teamLinks.size() == 0) {
         return new ArrayList<>();
      }

      ArrayList<MesBuildingProductionLineTreeDO> dos = new ArrayList<>();
      inspectTeamMap.forEach(
         (inspectId, treeDOS) -> dos.add(MesBuildingProductionLineTreeDO.builder().id(inspectId).teamList((List<MesBuildingTeamTreeDO>)treeDOS).build())
      );
      return dos;
   }

   @Override
   public Boolean saveTeam(Long id, List<Long> teamIds, Boolean teamType) {
      MesBuildingProductionLine prodLine = this.baseService.getById(id);
      Preconditions.checkArgument(prodLine != null, "操作失败,生产组不存在!!!");
      this.lineTeamLinkBiz
         .remove(
            (Wrappers.<MesBuildingProductionLineTeamLink>lambdaQuery().eq(MesBuildingProductionLineTeamLink::getProductionLineId, id))
               .eq(teamType != null, MesBuildingProductionLineTeamLink::getTeamType, teamType)
         );
      if (teamIds != null && teamIds.size() > 0) {
         List<MesBuildingTeam> teamList = this.teamBiz.listByIds(teamIds);
         Preconditions.checkArgument(teamIds.size() == teamList.size(), "操作失败，id有误");
         Preconditions.checkArgument(teamIds.size() == teamList.stream().map(MesBuildingTeam::getProcessId).distinct().count(), "操作失败，同一工序只能有一个班组");
         teamList.forEach(
            team -> {
               MesBuildingProcess process = this.mesBuildingProcessService.getById(team.getProcessId());
               if (ProcessTypeEnum.DRILL_HOLE.getType().equals(process.getType())) {
                  List<MesBuildingProductionLineTeamLink> teamLinks = this.lineTeamLinkBiz
                     .list((Wrapper<MesBuildingProductionLineTeamLink>)new LambdaQueryWrapper<MesBuildingProductionLineTeamLink>().eq(MesBuildingProductionLineTeamLink::getTeamId, team.getId()));
                  Preconditions.checkArgument(CollectionUtils.isEmpty(teamLinks), "新增失败,该钻孔类型班组已存在!!!");
               }
            }
         );
         teamIds.forEach(e -> this.lineTeamLinkBiz.save(MesBuildingProductionLineTeamLink.builder().productionLineId(id).teamId(e).teamType(teamType).build()));
      }

      return Boolean.TRUE;
   }

   @Override
   public List<GroupDetailDTO> getWorkShopAndProductionLineList(Integer productType, Long structureClassId, Integer mesProductEnum) {
      return this.baseMapper.getWorkShopAndProductionLineList(productType, structureClassId, mesProductEnum);
   }

   @Override
   public List<ArtifactSchedulingLineInfoDTO> getArtifactSchedulingLineInfoSummaryV8(Long areaId) {
      return this.baseMapper.getArtifactSchedulingLineInfoSummaryV8(areaId);
   }
}
