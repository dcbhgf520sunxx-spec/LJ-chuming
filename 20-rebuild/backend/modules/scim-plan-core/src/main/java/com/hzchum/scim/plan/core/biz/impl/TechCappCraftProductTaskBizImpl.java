package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.CappEquipmentCurrentVoltageIofo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.CappEquipmentInfo;
import com.hzchum.scim.iot.core.api.service.equiment.EquimentService;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseCraftparameterPassLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskRecordBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductWeldTaskBiz;
import com.hzchum.scim.plan.core.api.enums.TechCappProductTaskWorkTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouse;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseCraftParameterPassLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTask;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTaskRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductWeldTask;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppEquipmentDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassBindEquipmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassCodeScanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppWeldListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftProductTaskSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppEquipmentVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassRecordVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppWeldVO;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftProductTaskService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftProductTaskMapper;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo.dto.config.CappWeldingCraftConfigDTO;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.ConfigMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechCappCraftProductTaskBizImpl
   extends IBizImpl<TechCappCraftProductTaskService, TechCappCraftProductTaskMapper, TechCappCraftProductTask>
   implements TechCappCraftProductTaskBiz {
   @Resource
   private TechCappCraftProductPassTaskBiz techCappCraftProductPassTaskBiz;
   @Resource
   private TechCappCraftProductWeldTaskBiz techCappCraftProductWeldTaskBiz;
   @Resource
   private TechCappCraftCardProductLinkBiz techCappCraftCardProductLinkBiz;
   @Resource
   private TechCappCraftCardStorehouseBiz techCappCraftCardStorehouseBiz;
   @Resource
   private TechCappCraftCardStorehouseCraftparameterPassLinkBiz techCappCraftCardStorehouseCraftparameterPassLinkBiz;
   @Resource
   private MesBuildingTeamUserLinkService mesBuildingTeamUserLinkService;
   @Resource
   private MesBuildingTeamService mesBuildingTeamService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ConfigMapper configMapper;
   @Resource
   private EquimentService equimentService;
   @Resource
   private TechCappCraftProductPassTaskRecordBiz techCappCraftProductPassTaskRecordBiz;
   @Resource
   private TechArtifactExtService techArtifactExtService;
   @Resource
   private TechAssembleExtService techAssembleExtService;
   @Resource
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;

   @Override
   public void generateCappTaksRecord(
      List<TechAssembleExt> neeUpdateAssexts,
      List<TechArtifactExt> needUpdateExts,
      List<CappCraftProductTaskSaveDTO> cappCraftProductTaskSaveDTOS,
      Integer productType
   ) {
      List<TechCappCraftCardProductLink> techCappCraftCardProductLinks = this.techCappCraftCardProductLinkBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
               .eq(TechCappCraftCardProductLink::getProductType, productType)
               .in(
                  TechCappCraftCardProductLink::getProductId,
                  cappCraftProductTaskSaveDTOS.stream().map(CappCraftProductTaskSaveDTO::getProductId).collect(Collectors.toList())
               )
         );
      Map<Long, List<TechCappCraftCardStorehouseCraftParameterPassLink>> passMap = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .getAllList()
         .stream()
         .collect(Collectors.groupingBy(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId));
      if (CollectionUtils.isNotEmpty(techCappCraftCardProductLinks)) {
         Map<Long, List<TechCappCraftCardProductLink>> techCappCraftCardProductLinkMap = techCappCraftCardProductLinks.stream()
            .collect(Collectors.groupingBy(TechCappCraftCardProductLink::getProductId));
         cappCraftProductTaskSaveDTOS.forEach(
            item -> {
               List<TechCappCraftCardProductLink> techCappCraftCardProductLinkList = techCappCraftCardProductLinkMap.get(item.getProductId());
               if (CollectionUtils.isNotEmpty(techCappCraftCardProductLinkList)) {
                  if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
                     needUpdateExts.stream()
                        .filter(e -> e.getArtifactId().equals(item.getProductId()))
                        .forEach(
                           ext -> {
                              TechCappCraftProductTask techCappCraftProductTask = new TechCappCraftProductTask();
                              techCappCraftProductTask.setOneCodeExtId(ext.getId());
                              techCappCraftProductTask.setMesBuildingTaskId(item.getMesBuildingTaskId());
                              techCappCraftProductTask.setProductSerialNumber(ext.getSerialNumber());
                              techCappCraftProductTask.setProductId(ext.getArtifactId());
                              techCappCraftProductTask.setProjectId(item.getProjectId());
                              techCappCraftProductTask.setMonomerId(item.getMonomerId());
                              techCappCraftProductTask.setAreaId(item.getAreaId());
                              techCappCraftProductTask.setProductType(ProductTypeEnum.ARTIFACT.getType());
                              techCappCraftProductTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                              techCappCraftProductTask.setProductionLineId(item.getProductionLineId());
                              this.baseService.save(techCappCraftProductTask);
                              techCappCraftCardProductLinkList.forEach(
                                 link -> {
                                    TechCappCraftProductWeldTask techCappCraftProductWeldTask = new TechCappCraftProductWeldTask();
                                    techCappCraftProductWeldTask.setProductId(ext.getArtifactId());
                                    techCappCraftProductWeldTask.setTechCappCraftCardStorehouseId(link.getTechCappCraftCardStorehouseId());
                                    techCappCraftProductWeldTask.setWeldingSerialNumber(link.getWeldingSerialNumber());
                                    techCappCraftProductWeldTask.setMonomerId(item.getMonomerId());
                                    techCappCraftProductWeldTask.setProjectId(item.getProjectId());
                                    techCappCraftProductWeldTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                                    techCappCraftProductWeldTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                                    techCappCraftProductWeldTask.setAreaId(item.getAreaId());
                                    techCappCraftProductWeldTask.setProductType(ProductTypeEnum.ARTIFACT.getType());
                                    techCappCraftProductWeldTask.setProductSerialNumber(ext.getSerialNumber());
                                    this.techCappCraftProductWeldTaskBiz.save(techCappCraftProductWeldTask);
                                    List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = passMap.get(
                                       link.getTechCappCraftCardStorehouseId()
                                    );
                                    techCappCraftCardStorehouseCraftParameterPassLinks.forEach(pass -> {
                                       TechCappCraftProductPassTask techCappCraftProductPassTask = new TechCappCraftProductPassTask();
                                       techCappCraftProductPassTask.setProductSerialNumber(ext.getSerialNumber());
                                       techCappCraftProductPassTask.setProductId(ext.getArtifactId());
                                       techCappCraftProductPassTask.setProjectId(item.getProjectId());
                                       techCappCraftProductPassTask.setMonomerId(item.getMonomerId());
                                       techCappCraftProductPassTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                                       techCappCraftProductPassTask.setProductType(ProductTypeEnum.ARTIFACT.getType());
                                       techCappCraftProductPassTask.setAreaId(item.getAreaId());
                                       techCappCraftProductPassTask.setTechCappCraftProductWeldTaskId(techCappCraftProductWeldTask.getId());
                                       techCappCraftProductPassTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                                       techCappCraftProductPassTask.setSort(pass.getSort());
                                       techCappCraftProductPassTask.setTechCappCraftCardStorehouseCraftParameterPassLinkId(pass.getId());
                                       techCappCraftProductPassTask.setTechCappCraftCardStorehouseId(pass.getTechCappCraftCardStorehouseId());
                                       this.techCappCraftProductPassTaskBiz.save(techCappCraftProductPassTask);
                                    });
                                 }
                              );
                           }
                        );
                  } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     neeUpdateAssexts.stream()
                        .filter(e -> e.getAssembleId().equals(item.getProductId()))
                        .forEach(
                           ext -> {
                              TechCappCraftProductTask techCappCraftProductTask = new TechCappCraftProductTask();
                              techCappCraftProductTask.setOneCodeExtId(ext.getId());
                              techCappCraftProductTask.setMesBuildingTaskId(item.getMesBuildingTaskId());
                              techCappCraftProductTask.setProductSerialNumber(ext.getSerialNumber());
                              techCappCraftProductTask.setProductId(ext.getAssembleId());
                              techCappCraftProductTask.setProjectId(item.getProjectId());
                              techCappCraftProductTask.setMonomerId(item.getMonomerId());
                              techCappCraftProductTask.setAreaId(item.getAreaId());
                              techCappCraftProductTask.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                              techCappCraftProductTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                              techCappCraftProductTask.setProductionLineId(item.getProductionLineId());
                              this.baseService.save(techCappCraftProductTask);
                              techCappCraftCardProductLinkList.forEach(
                                 link -> {
                                    TechCappCraftProductWeldTask techCappCraftProductWeldTask = new TechCappCraftProductWeldTask();
                                    techCappCraftProductWeldTask.setProductId(ext.getAssembleId());
                                    techCappCraftProductWeldTask.setTechCappCraftCardStorehouseId(link.getTechCappCraftCardStorehouseId());
                                    techCappCraftProductWeldTask.setWeldingSerialNumber(link.getWeldingSerialNumber());
                                    techCappCraftProductWeldTask.setMonomerId(item.getMonomerId());
                                    techCappCraftProductWeldTask.setProjectId(ext.getProjectId());
                                    techCappCraftProductWeldTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                                    techCappCraftProductWeldTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                                    techCappCraftProductWeldTask.setAreaId(item.getAreaId());
                                    techCappCraftProductWeldTask.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                                    techCappCraftProductWeldTask.setProductSerialNumber(ext.getSerialNumber());
                                    this.techCappCraftProductWeldTaskBiz.save(techCappCraftProductWeldTask);
                                    List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = passMap.get(
                                       link.getTechCappCraftCardStorehouseId()
                                    );
                                    techCappCraftCardStorehouseCraftParameterPassLinks.forEach(pass -> {
                                       TechCappCraftProductPassTask techCappCraftProductPassTask = new TechCappCraftProductPassTask();
                                       techCappCraftProductPassTask.setProductSerialNumber(ext.getSerialNumber());
                                       techCappCraftProductPassTask.setProductId(ext.getAssembleId());
                                       techCappCraftProductPassTask.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                                       techCappCraftProductPassTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                                       techCappCraftProductPassTask.setProjectId(item.getProjectId());
                                       techCappCraftProductPassTask.setMonomerId(item.getMonomerId());
                                       techCappCraftProductPassTask.setAreaId(item.getAreaId());
                                       techCappCraftProductPassTask.setTechCappCraftProductWeldTaskId(techCappCraftProductWeldTask.getId());
                                       techCappCraftProductPassTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                                       techCappCraftProductPassTask.setSort(pass.getSort());
                                       techCappCraftProductPassTask.setTechCappCraftCardStorehouseId(pass.getTechCappCraftCardStorehouseId());
                                       techCappCraftProductPassTask.setTechCappCraftCardStorehouseCraftParameterPassLinkId(pass.getId());
                                       this.techCappCraftProductPassTaskBiz.save(techCappCraftProductPassTask);
                                    });
                                 }
                              );
                           }
                        );
                  }
               }
            }
         );
      }
   }

   @Override
   public void deleteCappTaksRecord(List<TechAssembleExt> removeAssnumbers, List<TechArtifactExt> removeArtifactNumbers, Integer productType) {
      if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         List<TechCappCraftProductTask> techCappCraftProductTasks = this.baseService
            .list(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, productType)
                  .in(TechCappCraftProductTask::getOneCodeExtId, removeAssnumbers.stream().map(TechAssembleExt::getId).collect(Collectors.toList()))
            );
         techCappCraftProductTasks.forEach(
            item -> Preconditions.checkArgument(
               item.getTechCappProductTaskWorkType().equals(TechCappProductTaskWorkTypeEnum.UNSTART.getType()), "该任务单正在生产中,不可进行撤回"
            )
         );
         this.baseService
            .remove(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, productType)
                  .in(TechCappCraftProductTask::getOneCodeExtId, removeAssnumbers.stream().map(TechAssembleExt::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(techCappCraftProductTasks)) {
            this.techCappCraftProductWeldTaskBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftProductWeldTask.class)
                     .in(
                        TechCappCraftProductWeldTask::getTechCappCraftProductTaskId,
                        techCappCraftProductTasks.stream().map(TechCappCraftProductTask::getId).collect(Collectors.toList())
                     )
               );
            this.techCappCraftProductPassTaskBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftProductPassTask.class)
                     .in(
                        TechCappCraftProductPassTask::getTechCappCraftProductTaskId,
                        techCappCraftProductTasks.stream().map(TechCappCraftProductTask::getId).collect(Collectors.toList())
                     )
               );
         }
      } else if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<TechCappCraftProductTask> techCappCraftProductTasks = this.baseService
            .list(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, productType)
                  .in(TechCappCraftProductTask::getOneCodeExtId, removeArtifactNumbers.stream().map(TechArtifactExt::getId).collect(Collectors.toList()))
            );
         techCappCraftProductTasks.forEach(
            item -> Preconditions.checkArgument(
               item.getTechCappProductTaskWorkType().equals(TechCappProductTaskWorkTypeEnum.UNSTART.getType()), "该任务单正在生产中,不可进行撤回"
            )
         );
         this.baseService
            .remove(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, productType)
                  .in(TechCappCraftProductTask::getOneCodeExtId, removeArtifactNumbers.stream().map(TechArtifactExt::getId).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(techCappCraftProductTasks)) {
            this.techCappCraftProductWeldTaskBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftProductWeldTask.class)
                     .in(
                        TechCappCraftProductWeldTask::getTechCappCraftProductTaskId,
                        techCappCraftProductTasks.stream().map(TechCappCraftProductTask::getId).collect(Collectors.toList())
                     )
               );
            this.techCappCraftProductPassTaskBiz
               .remove(
                  Wrappers.lambdaQuery(TechCappCraftProductPassTask.class)
                     .in(
                        TechCappCraftProductPassTask::getTechCappCraftProductTaskId,
                        techCappCraftProductTasks.stream().map(TechCappCraftProductTask::getId).collect(Collectors.toList())
                     )
               );
         }
      }
   }

   @Override
   public PageVO<CappCraftCardProductAppVO> productList(CappCraftCardProductAppListDTO dto) {
      List<MesBuildingTeamUserLink> mesBuildingTeamUserLinks = this.mesBuildingTeamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(mesBuildingTeamUserLinks)) {
         return new PageVO<>();
      }

      List<MesBuildingTeam> mesBuildingTeams = this.mesBuildingTeamService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeam.class)
               .in(MesBuildingTeam::getId, mesBuildingTeamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()))
         );
      if (CollectionUtils.isEmpty(mesBuildingTeams)) {
         return new PageVO<>();
      }

      List<MesBuildingTask> mesBuildingTasks = this.mesBuildingTaskService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .in(MesBuildingTask::getProductionLineId, mesBuildingTeams.stream().map(MesBuildingTeam::getProductionLineId).collect(Collectors.toList()))
         );
      if (CollectionUtils.isEmpty(mesBuildingTasks)) {
         return new PageVO<>();
      }

      Page<Object> objects = PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
      List<CappCraftCardProductAppVO> cappCraftCardProductAppVOS = this.baseMapper
         .productList(dto, mesBuildingTasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()));
      return new PageVO<>(objects, cappCraftCardProductAppVOS);
   }

   @Override
   public List<CappCraftCardProductAppCodeNumberVO> productCodeNumberList(CappCraftCardProductAppCodeNumberListDTO dto) {
      return this.baseMapper.productCodeNumberList(dto);
   }

   @Override
   public List<CappCraftCardProductAppWeldVO> productWeldList(CappCraftCardProductAppWeldListDTO dto) {
      return this.baseMapper.productWeldList(dto);
   }

   @Override
   public List<CappCraftCardProductAppPassVO> productPassList(CappCraftCardProductAppPassListDTO dto) {
      Map<Long, TechCappCraftCardStorehouse> storehouseMap = this.techCappCraftCardStorehouseBiz
         .listAll()
         .stream()
         .collect(Collectors.toMap(TechCappCraftCardStorehouse::getId, Function.identity()));
      List<CappCraftCardProductAppPassVO> cappCraftCardProductAppPassVOS = this.baseMapper.productPassList(dto);
      cappCraftCardProductAppPassVOS.forEach(item -> {
         List<AttachmentDTO> attachmentDTOS = new ArrayList<>();
         if (item.getTechCappCraftCardStorehouseId() != null) {
            TechCappCraftCardStorehouse techCappCraftCardStorehouse = storehouseMap.get(item.getTechCappCraftCardStorehouseId());
            if (techCappCraftCardStorehouse != null) {
               if (techCappCraftCardStorehouse.getJointSchematicDiagramAttachmentId() != null) {
                  AttachmentDTO attachmentDTO = this.attachmentService.getById(techCappCraftCardStorehouse.getJointSchematicDiagramAttachmentId());
                  attachmentDTOS.add(attachmentDTO);
               }

               if (techCappCraftCardStorehouse.getWeldingSchematicDiagramAttachmentId() != null) {
                  AttachmentDTO attachmentDTO = this.attachmentService.getById(techCappCraftCardStorehouse.getWeldingSchematicDiagramAttachmentId());
                  attachmentDTOS.add(attachmentDTO);
               }
            }
         }

         item.setAttachmentDTOS(attachmentDTOS);
      });
      return cappCraftCardProductAppPassVOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean productPassBindEquipment(CappCraftCardProductAppPassBindEquipmentDTO dto) {
      TechCappCraftProductPassTask techCappCraftProductPassTask = this.techCappCraftProductPassTaskBiz.getById(dto.getId());
      Preconditions.checkArgument(techCappCraftProductPassTask != null, "焊道任务不存在!!!");
      techCappCraftProductPassTask.setWeldUserId(dto.getWeldUserId());
      techCappCraftProductPassTask.setWeldingGunCode(dto.getWeldingGunCode());
      techCappCraftProductPassTask.setEquimentName(dto.getEquimentName());
      techCappCraftProductPassTask.setEquimentCode(dto.getEquimentCode());
      techCappCraftProductPassTask.setWeldUserName(dto.getWeldUserName());
      techCappCraftProductPassTask.setEquimentSerialNumber(dto.getEquimentSerialNumber());
      return this.techCappCraftProductPassTaskBiz.updateById(techCappCraftProductPassTask);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean productPassStart(Long id) {
      TechCappCraftProductPassTask techCappCraftProductPassTask = this.techCappCraftProductPassTaskBiz.getById(id);
      Preconditions.checkArgument(techCappCraftProductPassTask != null, "焊道任务不存在!!!");
      Preconditions.checkArgument(StringUtils.isNotBlank(techCappCraftProductPassTask.getEquimentSerialNumber()), "请先绑定设备!!!!");
      Map<Long, TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinkMap = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .getAllList()
         .stream()
         .collect(Collectors.toMap(item -> item.getId(), Function.identity()));
      TechCappCraftCardStorehouseCraftParameterPassLink techCappCraftCardStorehouseCraftParameterPassLink = techCappCraftCardStorehouseCraftParameterPassLinkMap.get(
         techCappCraftProductPassTask.getTechCappCraftCardStorehouseCraftParameterPassLinkId()
      );
      Preconditions.checkArgument(techCappCraftCardStorehouseCraftParameterPassLink != null, "焊接道次信息不存在!!!");
      String[] electricityArray = techCappCraftCardStorehouseCraftParameterPassLink.getElectricity().split("~");
      Preconditions.checkArgument(electricityArray.length == 2, "焊接道次信息格式错误!!!");
      BigDecimal currentLowerLimit = new BigDecimal(electricityArray[0]);
      BigDecimal currentUpperLimit = new BigDecimal(electricityArray[1]);
      String[] voltageArray = techCappCraftCardStorehouseCraftParameterPassLink.getVoltage().split("~");
      Preconditions.checkArgument(voltageArray.length == 2, "焊接道次信息格式错误!!!");
      BigDecimal voltageLowerLimit = new BigDecimal(voltageArray[0]);
      BigDecimal voltageUpperLimit = new BigDecimal(voltageArray[1]);
      String cappAddWeldTask = null;
      if (StringUtils.isBlank(techCappCraftProductPassTask.getEquimentId())) {
         cappAddWeldTask = this.equimentService
            .cappAddWeldTask(
               techCappCraftProductPassTask.getId().toString(),
               1,
               currentLowerLimit,
               currentUpperLimit,
               Long.valueOf(techCappCraftProductPassTask.getEquimentSerialNumber()),
               voltageLowerLimit,
               voltageUpperLimit,
               techCappCraftProductPassTask.getWeldingGunCode()
            );
      } else {
         cappAddWeldTask = techCappCraftProductPassTask.getEquimentId();
      }

      if (StringUtils.isNotBlank(cappAddWeldTask)) {
         techCappCraftProductPassTask.setIsMonitoring(Boolean.TRUE);
         techCappCraftProductPassTask.setIsPause(Boolean.FALSE);
         techCappCraftProductPassTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.PROCESSING.getType());
         techCappCraftProductPassTask.setEquimentId(cappAddWeldTask);
         if (techCappCraftProductPassTask.getStartTime() == null) {
            techCappCraftProductPassTask.setStartTime(LocalDateTime.now());
         }

         this.techCappCraftProductPassTaskBiz.updateById(techCappCraftProductPassTask);
         TechCappCraftProductWeldTask techCappCraftProductWeldTask = this.techCappCraftProductWeldTaskBiz
            .getById(techCappCraftProductPassTask.getTechCappCraftProductWeldTaskId());
         Preconditions.checkArgument(techCappCraftProductWeldTask != null, "焊缝任务不存在");
         if (techCappCraftProductWeldTask.getTechCappProductTaskWorkType().equals(TechCappProductTaskWorkTypeEnum.UNSTART.getType())) {
            techCappCraftProductWeldTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.PROCESSING.getType());
            this.techCappCraftProductWeldTaskBiz.updateById(techCappCraftProductWeldTask);
            TechCappCraftProductTask techCappCraftProductTask = this.baseService.getById(techCappCraftProductWeldTask.getTechCappCraftProductTaskId());
            Preconditions.checkArgument(techCappCraftProductTask != null, "产品任务不存在");
            if (techCappCraftProductTask.getTechCappProductTaskWorkType().equals(TechCappProductTaskWorkTypeEnum.UNSTART.getType())) {
               techCappCraftProductTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.PROCESSING.getType());
               this.baseService.updateById(techCappCraftProductTask);
            }
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public CappCraftCardProductAppPassRecordVO productPassRecord(Long id) {
      Object o = this.redisUtils.get("CAPP_CRAFT_CARD_PRODUCT_APP_PASS_RECORD_" + id);
      CappCraftCardProductAppPassRecordVO cappCraftCardProductAppPassRecordVO = new CappCraftCardProductAppPassRecordVO();
      if (o == null) {
         Config config = this.configMapper.getByCode("CAPP_WELDING_CRAFT");
         CappWeldingCraftConfigDTO cappWeldingCraftConfigDTO = JSONUtil.toBean(config.getValue(), CappWeldingCraftConfigDTO.class);
         TechCappCraftProductPassTask techCappCraftProductPassTask = this.techCappCraftProductPassTaskBiz.getById(id);
         Preconditions.checkArgument(techCappCraftProductPassTask != null, "焊道任务不存在!!!");
         Preconditions.checkArgument(StringUtils.isNotBlank(techCappCraftProductPassTask.getEquimentSerialNumber()), "请先绑定设备!!!!");
         CappEquipmentCurrentVoltageIofo cappEquipmentCurrentVoltageIofo = this.equimentService
            .cappFindEquipmentCurrentVoltageInfo(Long.valueOf(techCappCraftProductPassTask.getEquimentId()));
         if (cappEquipmentCurrentVoltageIofo == null
            || cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage() == null && cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric() == null
            || cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage().equals(BigDecimal.ZERO)
               && cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric().equals(BigDecimal.ZERO)) {
            Object failCount = this.redisUtils.get("CAPP_CRAFT_CARD_PRODUCT_APP_PASS_FAIL_COUNT" + id);
            if (failCount == null) {
               this.redisUtils.set("CAPP_CRAFT_CARD_PRODUCT_APP_PASS_FAIL_COUNT" + id, 1);
            } else {
               int count = (Integer)failCount;
               if (count == 10) {
                  techCappCraftProductPassTask.setIsPause(Boolean.TRUE);
                  techCappCraftProductPassTask.setIsMonitoring(Boolean.FALSE);
                  this.techCappCraftProductPassTaskBiz.updateById(techCappCraftProductPassTask);
               } else {
                  this.redisUtils.set("CAPP_CRAFT_CARD_PRODUCT_APP_PASS_FAIL_COUNT" + id, count + 1);
               }
            }
         }

         if (cappEquipmentCurrentVoltageIofo != null
            && cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage() != null
            && cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric() != null
            && !cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage().equals(BigDecimal.ZERO)
            && !cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric().equals(BigDecimal.ZERO)) {
            cappCraftCardProductAppPassRecordVO.setVoltage(cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage().toString());
            cappCraftCardProductAppPassRecordVO.setElectricity(cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric().toString());
            this.techCappCraftProductPassTaskRecordBiz
               .save(
                  TechCappCraftProductPassTaskRecord.builder()
                     .techCappCraftProductPassTaskId(id)
                     .electricity(cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric())
                     .voltage(cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage())
                     .techCappCraftProductTaskId(techCappCraftProductPassTask.getTechCappCraftProductTaskId())
                     .build()
               );
            this.redisUtils
               .set("CAPP_CRAFT_CARD_PRODUCT_APP_PASS_RECORD_" + id, cappEquipmentCurrentVoltageIofo, cappWeldingCraftConfigDTO.getAcquisitionFrequency());
         }
      } else {
         ObjectMapper objectMapper = new ObjectMapper();
         CappEquipmentCurrentVoltageIofo cappEquipmentCurrentVoltageIofo = objectMapper.convertValue(o, CappEquipmentCurrentVoltageIofo.class);
         cappCraftCardProductAppPassRecordVO.setElectricity(cappEquipmentCurrentVoltageIofo.getCurrentWeldElectric().toString());
         cappCraftCardProductAppPassRecordVO.setVoltage(cappEquipmentCurrentVoltageIofo.getCurrentWeldVoltage().toString());
         this.redisUtils.del("CAPP_CRAFT_CARD_PRODUCT_APP_PASS_FAIL_COUNT" + id);
      }

      return cappCraftCardProductAppPassRecordVO;
   }

   @Transactional
   @Override
   public Boolean productPassStop(Long id) {
      TechCappCraftProductPassTask techCappCraftProductPassTask = this.techCappCraftProductPassTaskBiz.getById(id);
      Preconditions.checkArgument(techCappCraftProductPassTask != null, "焊道任务不存在!!!");
      techCappCraftProductPassTask.setIsMonitoring(Boolean.FALSE);
      techCappCraftProductPassTask.setIsPause(Boolean.TRUE);
      return this.techCappCraftProductPassTaskBiz.updateById(techCappCraftProductPassTask);
   }

   @Transactional
   @Override
   public Boolean productPassComplete(Long id) {
      TechCappCraftProductPassTask techCappCraftProductPassTask = this.techCappCraftProductPassTaskBiz.getById(id);
      Preconditions.checkArgument(techCappCraftProductPassTask != null, "焊道任务不存在!!!");
      techCappCraftProductPassTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.COMPLETED.getType());
      techCappCraftProductPassTask.setEndTime(LocalDateTime.now());
      this.techCappCraftProductPassTaskBiz.updateById(techCappCraftProductPassTask);
      TechCappCraftProductWeldTask techCappCraftProductWeldTask = this.techCappCraftProductWeldTaskBiz
         .getOne(
            Wrappers.lambdaQuery(TechCappCraftProductWeldTask.class)
               .eq(TechCappCraftProductWeldTask::getId, techCappCraftProductPassTask.getTechCappCraftProductWeldTaskId())
         );
      List<TechCappCraftProductPassTask> techCappCraftProductPassTasks = this.techCappCraftProductPassTaskBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductPassTask.class)
               .eq(TechCappCraftProductPassTask::getTechCappCraftProductWeldTaskId, techCappCraftProductWeldTask.getId())
               .ne(TechCappCraftProductPassTask::getTechCappProductTaskWorkType, TechCappProductTaskWorkTypeEnum.COMPLETED.getType())
         );
      if (CollectionUtils.isEmpty(techCappCraftProductPassTasks)) {
         techCappCraftProductWeldTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.COMPLETED.getType());
         this.techCappCraftProductWeldTaskBiz.updateById(techCappCraftProductWeldTask);
         List<TechCappCraftProductWeldTask> techCappCraftProductWeldTasks = this.techCappCraftProductWeldTaskBiz
            .list(
               Wrappers.lambdaQuery(TechCappCraftProductWeldTask.class)
                  .eq(TechCappCraftProductWeldTask::getTechCappCraftProductTaskId, techCappCraftProductWeldTask.getTechCappCraftProductTaskId())
                  .ne(TechCappCraftProductWeldTask::getTechCappProductTaskWorkType, TechCappProductTaskWorkTypeEnum.COMPLETED.getType())
            );
         if (CollectionUtils.isEmpty(techCappCraftProductWeldTasks)) {
            TechCappCraftProductTask techCappCraftProductTask = this.baseService.getById(techCappCraftProductWeldTask.getTechCappCraftProductTaskId());
            techCappCraftProductTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.COMPLETED.getType());
            this.baseService.updateById(techCappCraftProductTask);
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public CappCraftCardProductAppVO productPassCodeScan(CappCraftCardProductAppPassCodeScanDTO dto) {
      CappCraftCardProductAppVO cappCraftCardProductAppVO = new CappCraftCardProductAppVO();
      if (dto.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifactExt techArtifactExt = this.techArtifactExtService
            .getOne(
               Wrappers.lambdaQuery(TechArtifactExt.class)
                  .eq(TechArtifactExt::getArtifactId, dto.getProductId())
                  .eq(TechArtifactExt::getSortNumber, dto.getNumber())
            );
         Preconditions.checkArgument(techArtifactExt != null, "产品信息不存在!!!");
         List<MesBuildingTeamUserLink> mesBuildingTeamUserLinks = this.mesBuildingTeamUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTeamUserLinks), "产品信息不存在!!!");
         List<MesBuildingTeam> mesBuildingTeams = this.mesBuildingTeamService
            .list(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .in(MesBuildingTeam::getId, mesBuildingTeamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTeams), "产品信息不存在!!!");
         List<MesBuildingTask> mesBuildingTasks = this.mesBuildingTaskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .in(MesBuildingTask::getProductionLineId, mesBuildingTeams.stream().map(MesBuildingTeam::getProductionLineId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTasks), "产品信息不存在!!!");
         TechCappCraftProductTask techCappCraftProductTask = this.baseService
            .getOne(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductId, techArtifactExt.getArtifactId())
                  .eq(TechCappCraftProductTask::getProductType, dto.getProductType())
                  .in(TechCappCraftProductTask::getMesBuildingTaskId, mesBuildingTasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
                  .eq(TechCappCraftProductTask::getOneCodeExtId, techArtifactExt.getId())
            );
         Preconditions.checkArgument(techCappCraftProductTask != null, "产品任务不存在!!!");
         cappCraftCardProductAppVO.setProjectId(techCappCraftProductTask.getProjectId());
         cappCraftCardProductAppVO.setMonomerId(techCappCraftProductTask.getMonomerId());
         cappCraftCardProductAppVO.setAreaId(techCappCraftProductTask.getAreaId());
         cappCraftCardProductAppVO.setProductId(techCappCraftProductTask.getProductId());
         cappCraftCardProductAppVO.setProductType(ProductTypeEnum.ARTIFACT.getType());
         cappCraftCardProductAppVO.setProductSerialNumber(techCappCraftProductTask.getProductSerialNumber());
         cappCraftCardProductAppVO.setTechCappProductTaskWorkType(techCappCraftProductTask.getTechCappProductTaskWorkType());
      } else if (dto.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssembleExt techAssembleExt = this.techAssembleExtService
            .getOne(
               Wrappers.lambdaQuery(TechAssembleExt.class)
                  .eq(TechAssembleExt::getAssembleId, dto.getProductId())
                  .eq(TechAssembleExt::getSortNumber, dto.getNumber())
            );
         Preconditions.checkArgument(techAssembleExt != null, "产品信息不存在!!!");
         List<MesBuildingTeamUserLink> mesBuildingTeamUserLinks = this.mesBuildingTeamUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTeamUserLinks), "产品信息不存在!!!");
         List<MesBuildingTeam> mesBuildingTeams = this.mesBuildingTeamService
            .list(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .in(MesBuildingTeam::getId, mesBuildingTeamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTeams), "产品信息不存在!!!");
         List<MesBuildingTask> mesBuildingTasks = this.mesBuildingTaskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .in(MesBuildingTask::getProductionLineId, mesBuildingTeams.stream().map(MesBuildingTeam::getProductionLineId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTasks), "产品信息不存在!!!");
         TechCappCraftProductTask techCappCraftProductTask = this.baseService
            .getOne(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductId, techAssembleExt.getAssembleId())
                  .eq(TechCappCraftProductTask::getProductType, dto.getProductType())
                  .in(TechCappCraftProductTask::getMesBuildingTaskId, mesBuildingTasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
                  .eq(TechCappCraftProductTask::getOneCodeExtId, techAssembleExt.getId())
            );
         Preconditions.checkArgument(techCappCraftProductTask != null, "产品任务不存在!!!");
         cappCraftCardProductAppVO.setProjectId(techCappCraftProductTask.getProjectId());
         cappCraftCardProductAppVO.setMonomerId(techCappCraftProductTask.getMonomerId());
         cappCraftCardProductAppVO.setAreaId(techCappCraftProductTask.getAreaId());
         cappCraftCardProductAppVO.setProductType(ProductTypeEnum.ASSEMBLE.getType());
         cappCraftCardProductAppVO.setProductId(techCappCraftProductTask.getProductId());
         cappCraftCardProductAppVO.setProductSerialNumber(techCappCraftProductTask.getProductSerialNumber());
         cappCraftCardProductAppVO.setTechCappProductTaskWorkType(techCappCraftProductTask.getTechCappProductTaskWorkType());
      }

      return cappCraftCardProductAppVO;
   }

   @Override
   public CappCraftCardProductAppEquipmentVO productEquipmentDetail(CappCraftCardProductAppEquipmentDetailDTO dto) {
      CappEquipmentInfo cappEquipmentInfo = this.equimentService.cappFindEquipmentInfo(dto.getId());
      Preconditions.checkArgument(cappEquipmentInfo != null, "设备信息获取失败!!!");
      return CappCraftCardProductAppEquipmentVO.builder()
         .id(cappEquipmentInfo.getId())
         .equimentCode(cappEquipmentInfo.getCode())
         .name(cappEquipmentInfo.getName())
         .serialNumber(cappEquipmentInfo.getCode())
         .weldingGunCodes(cappEquipmentInfo.getWeldingGunCodes())
         .build();
   }

   @Transactional
   @Override
   public void reissuedCappTask(Long productId, Integer productType) {
      Map<Long, List<TechCappCraftCardStorehouseCraftParameterPassLink>> passMap = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .getAllList()
         .stream()
         .collect(Collectors.groupingBy(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId));
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<TechArtifactExt> techArtifactExts = this.techArtifactExtService
            .list(
               Wrappers.lambdaQuery(TechArtifactExt.class)
                  .eq(TechArtifactExt::getArtifactId, productId)
                  .isNotNull(TechArtifactExt::getTaskId)
                  .ne(TechArtifactExt::getTaskId, 0)
            );
         if (CollectionUtils.isNotEmpty(techArtifactExts)) {
            Map<Long, TechCappCraftProductTask> productTaskMap = this.baseService
               .list(
                  Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                     .in(TechCappCraftProductTask::getOneCodeExtId, techArtifactExts.stream().map(TechArtifactExt::getId).collect(Collectors.toList()))
                     .eq(TechCappCraftProductTask::getProductType, productType)
               )
               .stream()
               .collect(Collectors.toMap(TechCappCraftProductTask::getOneCodeExtId, Function.identity()));
            techArtifactExts.forEach(
               ext -> {
                  if (productTaskMap.get(ext.getId()) == null) {
                     MesBuildingTask mesBuildingTask = this.mesBuildingTaskService.getById(ext.getTaskId());
                     TechCappCraftProductTask techCappCraftProductTask = new TechCappCraftProductTask();
                     techCappCraftProductTask.setOneCodeExtId(ext.getId());
                     techCappCraftProductTask.setMesBuildingTaskId(ext.getTaskId());
                     techCappCraftProductTask.setProductSerialNumber(ext.getSerialNumber());
                     techCappCraftProductTask.setProductId(ext.getArtifactId());
                     techCappCraftProductTask.setProjectId(ext.getProjectId());
                     techCappCraftProductTask.setMonomerId(ext.getMonomerId());
                     techCappCraftProductTask.setAreaId(ext.getAreaId());
                     techCappCraftProductTask.setProductType(ProductTypeEnum.ARTIFACT.getType());
                     techCappCraftProductTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                     techCappCraftProductTask.setProductionLineId(mesBuildingTask.getProductionLineId());
                     this.baseService.save(techCappCraftProductTask);
                     List<TechCappCraftCardProductLink> techCappCraftCardProductLinkList = this.techCappCraftCardProductLinkBiz
                        .list(
                           Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
                              .eq(TechCappCraftCardProductLink::getProductType, productType)
                              .eq(TechCappCraftCardProductLink::getProductId, productId)
                        );
                     techCappCraftCardProductLinkList.forEach(
                        link -> {
                           TechCappCraftProductWeldTask techCappCraftProductWeldTask = new TechCappCraftProductWeldTask();
                           techCappCraftProductWeldTask.setProductId(ext.getArtifactId());
                           techCappCraftProductWeldTask.setTechCappCraftCardStorehouseId(link.getTechCappCraftCardStorehouseId());
                           techCappCraftProductWeldTask.setWeldingSerialNumber(link.getWeldingSerialNumber());
                           techCappCraftProductWeldTask.setMonomerId(ext.getMonomerId());
                           techCappCraftProductWeldTask.setProjectId(ext.getProjectId());
                           techCappCraftProductWeldTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                           techCappCraftProductWeldTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                           techCappCraftProductWeldTask.setAreaId(ext.getAreaId());
                           techCappCraftProductWeldTask.setProductType(ProductTypeEnum.ARTIFACT.getType());
                           techCappCraftProductWeldTask.setProductSerialNumber(ext.getSerialNumber());
                           this.techCappCraftProductWeldTaskBiz.save(techCappCraftProductWeldTask);
                           List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = passMap.get(
                              link.getTechCappCraftCardStorehouseId()
                           );
                           techCappCraftCardStorehouseCraftParameterPassLinks.forEach(pass -> {
                              TechCappCraftProductPassTask techCappCraftProductPassTask = new TechCappCraftProductPassTask();
                              techCappCraftProductPassTask.setProductSerialNumber(ext.getSerialNumber());
                              techCappCraftProductPassTask.setProductId(ext.getArtifactId());
                              techCappCraftProductPassTask.setProjectId(ext.getProjectId());
                              techCappCraftProductPassTask.setMonomerId(ext.getMonomerId());
                              techCappCraftProductPassTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                              techCappCraftProductPassTask.setProductType(ProductTypeEnum.ARTIFACT.getType());
                              techCappCraftProductPassTask.setAreaId(ext.getAreaId());
                              techCappCraftProductPassTask.setTechCappCraftProductWeldTaskId(techCappCraftProductWeldTask.getId());
                              techCappCraftProductPassTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                              techCappCraftProductPassTask.setSort(pass.getSort());
                              techCappCraftProductPassTask.setTechCappCraftCardStorehouseCraftParameterPassLinkId(pass.getId());
                              techCappCraftProductPassTask.setTechCappCraftCardStorehouseId(pass.getTechCappCraftCardStorehouseId());
                              this.techCappCraftProductPassTaskBiz.save(techCappCraftProductPassTask);
                           });
                        }
                     );
                  }
               }
            );
         }
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleExt> techAssembleExts = this.techAssembleExtService
            .list(Wrappers.lambdaQuery(TechAssembleExt.class).eq(TechAssembleExt::getAssembleId, productId).eq(TechAssembleExt::getBoolTask, Boolean.TRUE));
         if (CollectionUtils.isNotEmpty(techAssembleExts)) {
            Map<Long, TechCappCraftProductTask> productTaskMap = this.baseService
               .list(
                  Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                     .in(TechCappCraftProductTask::getOneCodeExtId, techAssembleExts.stream().map(TechAssembleExt::getId).collect(Collectors.toList()))
                     .eq(TechCappCraftProductTask::getProductType, productType)
               )
               .stream()
               .collect(Collectors.toMap(TechCappCraftProductTask::getOneCodeExtId, Function.identity()));
            techAssembleExts.forEach(
               ext -> {
                  if (productTaskMap.get(ext.getId()) == null) {
                     MesBuildingTaskNumberLink mesBuildingTaskNumberLink = this.mesBuildingTaskNumberLinkService
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                              .eq(MesBuildingTaskNumberLink::getAssembleId, ext.getAssembleId())
                              .eq(MesBuildingTaskNumberLink::getAssembleNumber, ext.getSortNumber())
                        );
                     if (mesBuildingTaskNumberLink != null && mesBuildingTaskNumberLink.getAssembleTaskId() != null) {
                        MesBuildingTask mesBuildingTask = this.mesBuildingTaskService.getById(mesBuildingTaskNumberLink.getAssembleTaskId());
                        TechCappCraftProductTask techCappCraftProductTask = new TechCappCraftProductTask();
                        techCappCraftProductTask.setOneCodeExtId(ext.getId());
                        techCappCraftProductTask.setMesBuildingTaskId(mesBuildingTask.getId());
                        techCappCraftProductTask.setProductSerialNumber(ext.getSerialNumber());
                        techCappCraftProductTask.setProductId(ext.getAssembleId());
                        techCappCraftProductTask.setProjectId(ext.getProjectId());
                        techCappCraftProductTask.setMonomerId(ext.getMonomerId());
                        techCappCraftProductTask.setAreaId(ext.getAreaId());
                        techCappCraftProductTask.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                        techCappCraftProductTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                        techCappCraftProductTask.setProductionLineId(mesBuildingTask.getProductionLineId());
                        this.baseService.save(techCappCraftProductTask);
                        List<TechCappCraftCardProductLink> techCappCraftCardProductLinkList = this.techCappCraftCardProductLinkBiz
                           .list(
                              Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
                                 .eq(TechCappCraftCardProductLink::getProductType, productType)
                                 .eq(TechCappCraftCardProductLink::getProductId, productId)
                           );
                        techCappCraftCardProductLinkList.forEach(
                           link -> {
                              TechCappCraftProductWeldTask techCappCraftProductWeldTask = new TechCappCraftProductWeldTask();
                              techCappCraftProductWeldTask.setProductId(ext.getAssembleId());
                              techCappCraftProductWeldTask.setTechCappCraftCardStorehouseId(link.getTechCappCraftCardStorehouseId());
                              techCappCraftProductWeldTask.setWeldingSerialNumber(link.getWeldingSerialNumber());
                              techCappCraftProductWeldTask.setMonomerId(ext.getMonomerId());
                              techCappCraftProductWeldTask.setProjectId(ext.getProjectId());
                              techCappCraftProductWeldTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                              techCappCraftProductWeldTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                              techCappCraftProductWeldTask.setAreaId(ext.getAreaId());
                              techCappCraftProductWeldTask.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                              techCappCraftProductWeldTask.setProductSerialNumber(ext.getSerialNumber());
                              this.techCappCraftProductWeldTaskBiz.save(techCappCraftProductWeldTask);
                              List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = passMap.get(
                                 link.getTechCappCraftCardStorehouseId()
                              );
                              techCappCraftCardStorehouseCraftParameterPassLinks.forEach(pass -> {
                                 TechCappCraftProductPassTask techCappCraftProductPassTask = new TechCappCraftProductPassTask();
                                 techCappCraftProductPassTask.setProductSerialNumber(ext.getSerialNumber());
                                 techCappCraftProductPassTask.setProductId(ext.getAssembleId());
                                 techCappCraftProductPassTask.setProjectId(ext.getProjectId());
                                 techCappCraftProductPassTask.setMonomerId(ext.getMonomerId());
                                 techCappCraftProductPassTask.setTechCappCraftProductTaskId(techCappCraftProductTask.getId());
                                 techCappCraftProductPassTask.setProductType(ProductTypeEnum.ASSEMBLE.getType());
                                 techCappCraftProductPassTask.setAreaId(ext.getAreaId());
                                 techCappCraftProductPassTask.setTechCappCraftProductWeldTaskId(techCappCraftProductWeldTask.getId());
                                 techCappCraftProductPassTask.setTechCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType());
                                 techCappCraftProductPassTask.setSort(pass.getSort());
                                 techCappCraftProductPassTask.setTechCappCraftCardStorehouseCraftParameterPassLinkId(pass.getId());
                                 techCappCraftProductPassTask.setTechCappCraftCardStorehouseId(pass.getTechCappCraftCardStorehouseId());
                                 this.techCappCraftProductPassTaskBiz.save(techCappCraftProductPassTask);
                              });
                           }
                        );
                     }
                  }
               }
            );
         }
      }
   }
}
