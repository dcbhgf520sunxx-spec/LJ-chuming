package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.SpringUtil;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimModelConfigurationVO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.biz.PlanAreaBiz;
import com.hzchum.scim.plan.core.api.biz.PlanMonomerBiz;
import com.hzchum.scim.plan.core.api.biz.TechArtifactMachinePartBiz;
import com.hzchum.scim.plan.core.api.biz.TechStandardPartBiz;
import com.hzchum.scim.plan.core.api.biz.TechnologyBiz;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.ItemizedTypeEnum;
import com.hzchum.scim.plan.core.api.enums.LumpSumSystemEnum;
import com.hzchum.scim.plan.core.api.enums.MonomerDetailTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.manager.ProjectLevelManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ModifyAndAddAndDeleteParm;
import com.hzchum.scim.plan.core.api.pojo.dto.MonomerTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaBatchDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDetailDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanMonomerBizImpl implements PlanMonomerBiz {
   private static final Logger log = LoggerFactory.getLogger(PlanMonomerBizImpl.class);
   private final PlanAreaBiz planAreaBiz;
   private final PlanMonomerDetailService monomerDetailService;
   private final PlanAreaService areaService;
   private final PlanAreaBiz areaBiz;
   private final PlanMonomerService monomerService;
   private final ContractProjectService projectService;
   private final BimModelCommonService bimModelCommonService;
   private final ContractProjectContentService contractProjectContentService;
   private final BimModelConfigurationService bimModelConfigurationService;
   private final InboundDetailService wmsInboundDetailService;
   private final MoveOutboundDetailService moveOutboundDetailService;
   private final SubcontractMonomerLinkService subcontractMonomerLinkService;
   private final TransferService transferService;
   private final TechArtifactService techArtifactService;
   private final MonomerUserLinkService monomerUserLinkService;
   private final TechArtifactMachinePartBiz techArtifactMachinePartBiz;
   private final TechStandardPartBiz techStandardPartBiz;
   private final TechnologyBiz technologyBiz;
   private final MesTechInventoryOperationService mesTechInventoryOperationService;
   private final PlanAreaBatchService areaBatchService;
   private final SysPushFlowConfigBiz sysPushFlowConfigBiz;
   private final NotificationTemplateDetailsUtils detailsUtils;
   private final TechArtifactService artifactService;
   private final ProjectLevelManager projectLevelManager;
   private final MessagePushUtil messagePushUtil;
   private final MesBuildingTaskService taskService;
   private final RedisUtils redisUtils;
   private final MesEnclosureTaskService enclosureTaskServicevate;
   private final MesBuildingTaskProcessService taskProcessService;
   private final MesBuildingTeamUserLinkService teamUserLinkService;

   @Override
   public PageVO<PlanMonomerDTO> pageListMonomer(Long projectId, String name, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<PlanMonomerDTO> monomerDTOList = this.monomerService.listByCondition(projectId, name);
      monomerDTOList.forEach(
         m -> {
            List<PlanMonomerDetailDTO> monomerDetailDTOS = this.monomerDetailService
               .list((Wrapper<PlanMonomerDetail>)new LambdaQueryWrapper<PlanMonomerDetail>().eq(PlanMonomerDetail::getMonomerId, m.getId()))
               .stream()
               .map(d -> BeanUtil.copy(d, PlanMonomerDetailDTO.class))
               .collect(Collectors.toList());
            m.setMonomerDetailList(monomerDetailDTOS);
         }
      );
      return new PageVO<>(monomerDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMonomer(PlanMonomerSaveDTOParam saveDTOParam) {
      ContractProject project = this.projectService.checkProjectStatus(saveDTOParam.getProjectId());
      int count = this.monomerService
         .count(
            (Wrapper<PlanMonomer>)(new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, saveDTOParam.getProjectId()))
               .eq(PlanMonomer::getName, saveDTOParam.getName())
         );
      Preconditions.checkArgument(count == 0, "保存失败，该项目下已存在同名单体");
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
         && !saveDTOParam.getLumpSumSystemType().equals(LumpSumSystemEnum.NO_FACTORY_PROCESSING_NO_CONTROL.getType())) {
      }

      if (saveDTOParam.getStartDate() == null) {
         saveDTOParam.setStartDate(project.getStartDate());
      }

      PlanMonomer monomer = BeanUtil.copy(saveDTOParam, PlanMonomer.class);
      monomer.setUserId(UserUtil.getCurrentUserId());
      PlanMonomer planMonomer = SpringUtil.getBean(PlanMonomerService.class).saveWithCache(monomer);
      this.technologyBiz.addDefaultDeepArchivist(planMonomer);
      if (CollectionUtils.isNotEmpty(saveDTOParam.getAreaList())) {
         saveDTOParam.getAreaList().forEach(p -> {
            p.setMonomerId(planMonomer.getId());
            this.areaBiz.saveArea(p);
         });
      }

      return Boolean.TRUE;
   }

   private void saveMonomerDetail(PlanMonomer monomer, List<PlanMonomerDetailDTOParam> detailSaveDTOParamList) {
      detailSaveDTOParamList.forEach(
         d -> {
            PlanMonomerDetail monomerDetail = PlanMonomerDetail.builder()
               .projectId(monomer.getProjectId())
               .monomerId(monomer.getId())
               .type(d.getType())
               .date(d.getDate())
               .mete(d.getMete())
               .build();
            ContractProjectContent contractProjectContent = this.contractProjectContentService
               .getOne((Wrapper<ContractProjectContent>)new LambdaQueryWrapper<ContractProjectContent>().eq(ContractProjectContent::getNo, monomerDetail.getType()));
            monomerDetail.setProductCategory(contractProjectContent.getCategoryType());
            this.monomerDetailService.save(monomerDetail);
         }
      );
   }

   @Override
   public Boolean updateMonomer(PlanMonomerUpdateDTOParam updateDTOParam) {
      PlanMonomer monomer = this.monomerService.getById(updateDTOParam.getId());
      Preconditions.checkArgument(monomer != null, "修改失败，对应的单体不存在!");
      ContractProject project = this.projectService.checkProjectStatus(monomer.getProjectId());
      if (!updateDTOParam.getName().equals(monomer.getName())) {
         int count = this.monomerService
            .count(
               (Wrapper<PlanMonomer>)(new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, monomer.getProjectId()))
                  .eq(PlanMonomer::getName, updateDTOParam.getName())
            );
         Preconditions.checkArgument(count == 0, "修改失败，该项目下已存在同名单体");
      }

      if (updateDTOParam.getStartDate() != null) {
         Preconditions.checkArgument(!updateDTOParam.getStartDate().isAfter(updateDTOParam.getDate()), "单体开始日期不能晚于单体完成日期!");
      }

      Preconditions.checkArgument(!updateDTOParam.getDate().isBefore(project.getStartDate()), "单体完成日期不能早于项目开始日期");
      Preconditions.checkArgument(!updateDTOParam.getDate().isAfter(project.getEndDate()), "单体完成日期不能晚于项目完工日期");
      PlanMaxMinDateDTO maxMinDateDto = this.areaService.getMaxMinDate(updateDTOParam.getId(), null);
      if (maxMinDateDto != null && maxMinDateDto.getMinDate() != null) {
         Preconditions.checkArgument(
            updateDTOParam.getStartDate() == null || !updateDTOParam.getStartDate().isAfter(maxMinDateDto.getMinDate()), "单体开始日期不能晚于区域完成日期!"
         );
         Preconditions.checkArgument(!updateDTOParam.getDate().isBefore(maxMinDateDto.getMaxDate()), "单体完成日期不能早于区域完成日期!");
      }

      updateDTOParam.getDetailSaveDTOParamList().forEach(d -> {
         Preconditions.checkArgument(MonomerDetailTypeEnum.isExist(d.getType()), "单体内产品类型传值有误!");
         String nameByType = MonomerDetailTypeEnum.getNameByType(d.getType());
         Preconditions.checkArgument(d.getMete().compareTo(BigDecimal.ZERO) >= 0, nameByType + "计划量不能小于0!");
         if (updateDTOParam.getStartDate() != null) {
            Preconditions.checkArgument(!d.getDate().isBefore(updateDTOParam.getStartDate()), nameByType + "完成日期不能早于单体开始日期!");
         } else if (monomer.getStartDate() != null) {
            Preconditions.checkArgument(!d.getDate().isBefore(monomer.getStartDate()), nameByType + "完成日期不能早于单体开始日期!");
         } else {
            Preconditions.checkArgument(!d.getDate().isBefore(project.getStartDate()), nameByType + "完成日期不能早于项目开始日期!");
         }

         Preconditions.checkArgument(!d.getDate().isAfter(updateDTOParam.getDate()), nameByType + "完成日期不能晚于单体完成日期");
      });
      updateDTOParam.getDetailSaveDTOParamList()
         .forEach(
            d -> {
               PlanMaxMinDateDTO areaMaxMinDateDTO = this.areaService.getMaxMinDate(updateDTOParam.getId(), d.getType());
               if (areaMaxMinDateDTO != null && areaMaxMinDateDTO.getMinDate() != null) {
                  Preconditions.checkArgument(
                     !d.getDate().isBefore(areaMaxMinDateDTO.getMaxDate()), MonomerDetailTypeEnum.getNameByType(d.getType()) + "完成日期不能早于区域完成日期"
                  );
               }
            }
         );
      List<PlanArea> areaList = this.areaService.list(Wrappers.lambdaQuery(PlanArea.builder().monomerId(updateDTOParam.getId()).build()));
      if (CollectionUtils.isNotEmpty(areaList)) {
         Set<Integer> areaProductTypeList = areaList.stream().map(PlanArea::getProductType).collect(Collectors.toSet());
         List<Integer> monomerDetailTypeList = updateDTOParam.getDetailSaveDTOParamList()
            .stream()
            .map(PlanMonomerDetailDTOParam::getType)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
         areaProductTypeList.forEach(areaProductType -> {
            String descByType = AreaProductTypeEnum.getDescByType(areaProductType);
            Preconditions.checkArgument(monomerDetailTypeList.contains(areaProductType), "已创建" + descByType + "区域,必须填写工程量和完成日期!");
         });
      }

      this.monomerDetailService.remove(Wrappers.lambdaQuery(PlanMonomerDetail.builder().monomerId(updateDTOParam.getId()).build()));
      this.saveMonomerDetail(monomer, updateDTOParam.getDetailSaveDTOParamList());
      BeanUtil.copy(updateDTOParam, monomer);
      SpringUtil.getBean(PlanMonomerService.class).updateWithCache(monomer);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeMonomer(List<Long> ids) {
      ids.forEach(
         id -> {
            PlanMonomer monomer = this.monomerService.getById(id);
            Preconditions.checkArgument(monomer != null, "删除失败，单体不存在");
            this.projectService.checkProjectStatus(monomer.getProjectId());
            int count = this.areaService.count((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, id));
            Preconditions.checkArgument(count == 0, "该单体已创建区域，请先删除区域!");
            count = this.transferService.count(Wrappers.lambdaQuery(Transfer.builder().directionMonomerId(id).build()));
            Preconditions.checkArgument(count == 0, "删除失败,单体已存在物料调拨记录!");
            count = this.wmsInboundDetailService.count(Wrappers.lambdaQuery(InboundDetail.builder().monomerId(id).build()));
            Preconditions.checkArgument(count == 0, "删除失败,单体已关联物料入库记录!");
            count = this.moveOutboundDetailService.count(Wrappers.lambdaQuery(MoveOutboundDetail.builder().monomerId(id).build()));
            Preconditions.checkArgument(count == 0, "删除失败,单体已关联物料出库记录!");
            int subRelationCount = this.subcontractMonomerLinkService.count(Wrappers.lambdaQuery(SubcontractMonomerLink.builder().monomerId(id).build()));
            Preconditions.checkArgument(subRelationCount == 0, "单体已创建分包订单!");
            List<MesTechInventoryOperation> inventoryOperationList = this.mesTechInventoryOperationService
               .list((Wrapper<MesTechInventoryOperation>)new LambdaQueryWrapper<MesTechInventoryOperation>().eq(MesTechInventoryOperation::getMonomerId, id));
            if (CollectionUtils.isNotEmpty(inventoryOperationList)) {
               Preconditions.checkArgument(
                  inventoryOperationList.stream().noneMatch(e -> e.getInventoryReviewedEnum().equals(InventoryReviewedEnum.FIXUP_RECORD.getType())),
                  "操作失败,存在待确认的清单导入记录!"
               );
               Preconditions.checkArgument(
                  inventoryOperationList.stream().noneMatch(e -> e.getInventoryReviewedEnum().equals(InventoryReviewedEnum.UNAUDITED.getType())),
                  "操作失败,存在待审核的清单导入记录!"
               );
               this.mesTechInventoryOperationService
                  .removeByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getId).collect(Collectors.toList()));
            }

            List<TechArtifact> techArtifactList = this.techArtifactService.list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, id));
            Preconditions.checkArgument(techArtifactList.size() == 0, "单体已导入清单");
            this.monomerDetailService.remove(Wrappers.lambdaQuery(PlanMonomerDetail.builder().monomerId(id).build()));
            SpringUtil.getBean(PlanMonomerService.class).deleteWithCache(id);
         }
      );
      return true;
   }

   @Override
   public PlanMonomerSimpleDTO getMonomerSimpleById(Long monomerId) {
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在,ID输入有误");
      PlanMonomerSimpleDTO simpleDTO = BeanUtil.copy(monomer, PlanMonomerSimpleDTO.class);
      List<PlanMonomerDetail> monomerDetails = this.monomerDetailService
         .list((Wrapper<PlanMonomerDetail>)new LambdaQueryWrapper<PlanMonomerDetail>().eq(PlanMonomerDetail::getMonomerId, monomerId));
      if (monomerDetails.isEmpty()) {
         simpleDTO.setProductTypeList(new ArrayList<>());
         return simpleDTO;
      } else {
         List<Map<String, Object>> mapList = monomerDetails.stream().filter(d -> d.getMete() != null && d.getMete().compareTo(BigDecimal.ZERO) > 0).map(d -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("no", d.getType());
            map.put("name", AreaProductTypeEnum.getDescByType(d.getType()));
            map.put("date", d.getDate());
            return map;
         }).collect(Collectors.toList());
         simpleDTO.setProductTypeList(mapList);
         return simpleDTO;
      }
   }

   @Override
   public ListVO<ProjectTreeResponseVO> listProjectTreeResponseVO(
      Integer status,
      Integer settlementStatus,
      Integer projectType,
      Boolean ifUserRelated,
      Integer lumpSumSystemType,
      Integer level,
      Integer productType,
      Boolean hasTask,
      Boolean hasInspectTask
   ) {
      projectType = projectType != null && projectType != 1 && projectType != 2
         ? projectType
         : ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType();
      if (hasTask || hasInspectTask) {
         projectType = ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType();
      }

      List<ContractProject> projectList;
      if (!ifUserRelated) {
         projectList = this.projectService.listTree(null, status, settlementStatus, projectType, lumpSumSystemType, level);
      } else {
         SecurityUser user = UserUtil.getCurrentUser();
         Long userId = user.isAdmin() ? null : user.getId();
         projectList = this.projectService.listTree(userId, status, settlementStatus, projectType, lumpSumSystemType, level);
      }

      Map<Long, List<PlanMonomer>> monomerProjectMap = this.monomerService.list().stream().collect(Collectors.groupingBy(PlanMonomer::getProjectId));
      Map<Long, List<PlanArea>> areaMonomerMap = this.areaService.list().stream().collect(Collectors.groupingBy(PlanArea::getMonomerId));
      Map<Long, List<PlanAreaBatch>> areaBatchMonomerMap = this.areaBatchService.list().stream().collect(Collectors.groupingBy(PlanAreaBatch::getMonomerId));
      Map<Long, List<PlanAreaBatch>> areaBatchMap = this.areaBatchService.list().stream().collect(Collectors.groupingBy(PlanAreaBatch::getAreaId));
      List<ProjectTreeResponseVO> responseList = projectList.stream()
         .map(
            project -> {
               ProjectTreeResponseVO projectVO = BeanUtil.copy(project, ProjectTreeResponseVO.class);
               List<PlanMonomer> monomerList = monomerProjectMap.getOrDefault(project.getId(), new ArrayList<>());
               List<MonomerTreeResponseVO> monomerVOList = monomerList.stream()
                  .map(
                     monomer -> {
                        MonomerTreeResponseVO monomerVO = BeanUtil.copy(monomer, MonomerTreeResponseVO.class);
                        List<PlanArea> areaList = areaMonomerMap.getOrDefault(monomer.getId(), new ArrayList<>());
                        List<AreaTreeResponseVO> areaVOList = areaList.stream()
                           .map(area -> BeanUtil.copy(area, AreaTreeResponseVO.class))
                           .collect(Collectors.toList());
                        if (CollectionUtils.isNotEmpty(areaVOList)) {
                           for (AreaTreeResponseVO areaTreeResponseVO : areaVOList) {
                              List<PlanAreaBatch> areaBatchList = areaBatchMap.getOrDefault(areaTreeResponseVO.getId(), new ArrayList<>());
                              areaTreeResponseVO.setAreaBatchList(cn.hutool.core.bean.BeanUtil.copyToList(areaBatchList, NameInfo.class));
                              areaTreeResponseVO.setChildren(areaTreeResponseVO.getAreaBatchList());
                           }
                        }

                        monomerVO.setChildren(areaVOList);
                        List<PlanAreaBatch> areaBatchList = areaBatchMonomerMap.getOrDefault(monomer.getId(), new ArrayList<>());
                        List<AreaTreeResponseVO> areaTreeResponseVOList = areaBatchList.stream()
                           .map(area -> BeanUtil.copy(area, AreaTreeResponseVO.class))
                           .collect(Collectors.toList());
                        monomerVO.setAreaBatchList(areaTreeResponseVOList);
                        return monomerVO;
                     }
                  )
                  .collect(Collectors.toList());
               projectVO.setChildren(monomerVOList);
               return projectVO;
            }
         )
         .collect(Collectors.toList());
      List<MesBuildingTeamUserLink> teamUserLinkList = this.teamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      Set<Long> teamIds = teamUserLinkList.stream().map(e -> e.getTeamId()).collect(Collectors.toSet());
      if (hasTask) {
         Set<Long> projectIds = responseList.stream().map(e -> e.getId()).collect(Collectors.toSet());
         if (CollectionUtils.isNotEmpty(projectIds)) {
            Set<Long> hasTaskProjectIds;
            if (projectType == ProjectTypeEnum.ENCLOSURE.getType()) {
               hasTaskProjectIds = this.enclosureTaskServicevate
                  .list(
                     Wrappers.lambdaQuery(MesEnclosureTask.class).in(MesEnclosureTask::getProjectId, projectIds).last(" and complete_quantity < task_quantity")
                  )
                  .stream()
                  .map(e -> e.getProjectId())
                  .collect(Collectors.toSet());
            } else {
               hasTaskProjectIds = this.taskProcessService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .in(MesBuildingTaskProcess::getProjectId, projectIds)
                        .eq(productType != null, MesBuildingTaskProcess::getTaskTypeEnum, productType)
                        .in(CollectionUtils.isNotEmpty(teamIds), MesBuildingTaskProcess::getTeamId, teamIds)
                        .last(" and complete_quantity < task_quantity")
                  )
                  .stream()
                  .map(e -> e.getProjectId())
                  .collect(Collectors.toSet());
            }

            if (CollectionUtils.isNotEmpty(hasTaskProjectIds)) {
               responseList = responseList.stream().filter(e -> hasTaskProjectIds.contains(e.getId())).collect(Collectors.toList());
            }
         }
      }

      if (hasInspectTask && projectType != ProjectTypeEnum.ENCLOSURE.getType()) {
         List<Long> projectIds = responseList.stream().map(e -> e.getId()).collect(Collectors.toList());
         Set<Long> hasInspectTaskProjectIds = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .in(MesBuildingTaskProcess::getProjectId, projectIds)
                  .eq(productType != null, MesBuildingTaskProcess::getTaskTypeEnum, productType)
                  .in(CollectionUtils.isNotEmpty(teamIds), MesBuildingTaskProcess::getTeamId, teamIds)
                  .last(" and complete_quantity > inspection_quantity")
            )
            .stream()
            .map(e -> e.getProjectId())
            .collect(Collectors.toSet());
         if (CollectionUtils.isNotEmpty(hasInspectTaskProjectIds)) {
            responseList = responseList.stream().filter(e -> hasInspectTaskProjectIds.contains(e.getId())).collect(Collectors.toList());
         }
      }

      return new ListVO<>(responseList);
   }

   @Override
   public ListVO<Map<String, Object>> listMonomerSimpleByProjectId(Long projectId, Long monomerId, Integer productType) {
      List<PlanMonomer> monomers = this.monomerService
         .list(
            (Wrapper<PlanMonomer>)((new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, projectId))
                  .eq(monomerId != null, PlanMonomer::getId, monomerId))
               .orderByAsc(PlanMonomer::getSort)
         );
      if (CollectionUtils.isEmpty(monomers)) {
         return new ListVO<>();
      }

      Map<Long, List<PlanArea>> areaListMap = this.areaService
         .list(
            (new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getProjectId, projectId))
               .apply(productType != null, " itemized_type & {0} ", productType)
         )
         .stream()
         .collect(Collectors.groupingBy(PlanArea::getMonomerId));
      List<PlanAreaBatch> areaBatchList = this.areaBatchService
         .list(
            (new LambdaQueryWrapper<PlanAreaBatch>().eq(PlanAreaBatch::getProjectId, projectId))
               .apply(productType != null, " itemized_type & {0} ", productType)
         );
      Map<Long, List<PlanAreaBatch>> areaMonomerIdListBatchMap = areaBatchList.stream().collect(Collectors.groupingBy(PlanAreaBatch::getMonomerId));
      Map<Long, List<PlanAreaBatch>> areaListBatchMap = areaBatchList.stream().collect(Collectors.groupingBy(PlanAreaBatch::getAreaId));
      if (CollectionUtils.isNotEmpty(areaListMap) && productType != null) {
         monomers = this.monomerService
            .list(
               (Wrapper<PlanMonomer>)((new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, projectId))
                     .in(PlanMonomer::getId, areaListMap.keySet()))
                  .orderByAsc(PlanMonomer::getSort)
            );
      }

      List<Map<String, Object>> mapList = monomers.stream()
         .map(
            monomer -> {
               Map<String, Object> map = new LinkedHashMap<>();
               map.put("id", monomer.getId());
               map.put("name", monomer.getName());
               map.put("startDate", monomer.getStartDate());
               map.put("endDate", monomer.getEndDate());
               map.put("mesProductEnum", BuildingTypeEnum.getMesProductTypeByType(monomer.getBuildingTypeEnum()));
               List<PlanArea> planAreaList = areaListMap.get(monomer.getId());
               List<PlanAreaBatch> planMonomerAreaBatchList = areaMonomerIdListBatchMap.get(monomer.getId());
               if (CollectionUtils.isNotEmpty(planAreaList)) {
                  List<PlanAreaDTO> areaSimpleList = planAreaList.stream().map(area -> {
                     area.setProductCategory(ProjectContentCategoryEnum.getTypeByItemizedType(area.getItemizedType()));
                     return BeanUtil.copy(area, PlanAreaDTO.class);
                  }).collect(Collectors.toList());

                  for (PlanAreaDTO areaDTO : areaSimpleList) {
                     List<PlanAreaBatch> areaBatches = areaListBatchMap.get(areaDTO.getId());
                     if (CollectionUtils.isNotEmpty(areaBatches)) {
                        List<PlanAreaBatchDTO> planAreaBatchDTOS = cn.hutool.core.bean.BeanUtil.copyToList(areaBatches, PlanAreaBatchDTO.class);
                        areaDTO.setPlanAreaBatchDTOS(planAreaBatchDTOS);
                     }
                  }

                  map.put("areaSimpleList", areaSimpleList);
                  BimModelConfigurationDO bimModelConfigurationDO = this.bimModelConfigurationService
                     .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomer.getId()));
                  Integer quantity = this.bimModelCommonService.selectSuccessQuantity(monomer.getId());
                  map.put("successQuantity", quantity);
                  map.put("bimConfig", BeanUtil.copy(bimModelConfigurationDO, BimModelConfigurationVO.class));
               }

               if (CollectionUtils.isNotEmpty(planMonomerAreaBatchList)) {
                  List<PlanAreaDTO> areaBatchSimpleList = planMonomerAreaBatchList.stream().map(area -> {
                     area.setProductCategory(ProjectContentCategoryEnum.getTypeByItemizedType(area.getItemizedType()));
                     return BeanUtil.copy(area, PlanAreaDTO.class);
                  }).collect(Collectors.toList());
                  map.put("areaBatchSimpleList", areaBatchSimpleList);
               }

               return map;
            }
         )
         .collect(Collectors.toList());
      return new ListVO<>(mapList);
   }

   @Override
   public ProjectPlanDetailDTO enclosureMonomerAreaByProjectId(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(cn.hutool.core.bean.BeanUtil.isNotEmpty(project), "项目不存在");
      List<ProjectPlanMonomerDTO> monomerList = this.monomerService.getListByProjectId(projectId);
      List<ProjectPlanAreaDTO> areaList = this.areaService.getListByProjectId(projectId);
      Map<Long, List<ProjectPlanAreaDTO>> areaByMonomerIdGroup = areaList.stream().collect(Collectors.groupingBy(ProjectPlanAreaDTO::getMonomerId));
      monomerList.forEach(
         monomer -> {
            List<ProjectPlanAreaDTO> areas = areaByMonomerIdGroup.get(monomer.getId());
            if (CollectionUtils.isNotEmpty(areas)) {
               areas = areas.stream()
                  .filter(s -> s.getProjectPlanProductCategory().equals(ProjectPlanProductCategoryEnum.ENCLOSURE.getType()))
                  .collect(Collectors.toList());
               monomer.setAreaList(areas);
            }
         }
      );
      monomerList = monomerList.stream().filter(e -> CollectionUtils.isNotEmpty(e.getAreaList())).collect(Collectors.toList());
      return ProjectPlanDetailDTO.builder().projectId(projectId).monomerList(monomerList).build();
   }

   @Override
   public List<Map<String, Object>> listSimpleByProjectId(Long projectId) {
      Map<Long, List<PlanArea>> monomerAreaListMap = this.areaService
         .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getProjectId, projectId))
         .stream()
         .collect(Collectors.groupingBy(PlanArea::getMonomerId));
      List<PlanMonomer> monomerList = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId));
      return monomerList.stream().map(m -> {
         Map<String, Object> monomer = new LinkedHashMap<>();
         monomer.put("id", m.getId());
         monomer.put("name", m.getName());
         monomer.put("children", Collections.emptyList());
         if (monomerAreaListMap.containsKey(m.getId())) {
            List<NameInfo> areaList = monomerAreaListMap.get(m.getId()).stream().map(area -> BeanUtil.copy(area, NameInfo.class)).collect(Collectors.toList());
            monomer.put("children", areaList);
         }

         return monomer;
      }).collect(Collectors.toList());
   }

   @Override
   public ListVO<PlanMonomerDTO> getMonomerAndAreaByProjectId(Long projectId) {
      Preconditions.checkArgument(projectId != null, "projectId不能为空");
      List<PlanMonomer> planMonomerList = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId));
      List<PlanMonomerDTO> planMonomerDTOList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(planMonomerList)) {
         for (PlanMonomer planMonomer : planMonomerList) {
            PlanMonomerDTO planMonomerDTO = new PlanMonomerDTO();
            BeanUtil.copy(planMonomer, planMonomerDTO);
            List<PlanArea> areaList = this.areaService
               .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getProjectId, projectId).eq(PlanArea::getMonomerId, planMonomer.getId()));
            if (CollectionUtils.isNotEmpty(areaList)) {
               List<PlanAreaDTO> areaDTOList = new ArrayList<>();

               for (PlanArea planArea : areaList) {
                  PlanAreaDTO planAreaDTO = new PlanAreaDTO();
                  BeanUtil.copy(planArea, planAreaDTO);
                  if (planArea.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType())) {
                     List<TechArtifactDTO> techArtifactDTOList = this.techArtifactMachinePartBiz
                        .listArtifactDTOByConditions(planArea.getId(), null, null, null, null, null, null, null, null, null, null, 1, 10000, null, null, null)
                        .getContent();
                     planAreaDTO.setHaveDetailedList(CollectionUtils.isNotEmpty(techArtifactDTOList) ? 1 : 0);
                  }

                  if (planArea.getItemizedType().equals(ItemizedTypeEnum.OTHER.getType())) {
                     TechStandardPartQueryDtoParam param = TechStandardPartQueryDtoParam.builder()
                        .projectId(projectId)
                        .relationType(ProductTypeEnum.ARTIFACT.getType())
                        .build();
                     List<TechStandardPartDTO> techStandardPartDTOList = this.techStandardPartBiz.pageListByCondition(param, 1, 1000, null).getContent();
                     planAreaDTO.setHaveDetailedList(CollectionUtils.isNotEmpty(techStandardPartDTOList) ? 1 : 0);
                  }

                  areaDTOList.add(planAreaDTO);
               }

               planMonomerDTO.setAreaDTOList(areaDTOList);
            }

            planMonomerDTOList.add(planMonomerDTO);
         }
      }

      return new ListVO<>(planMonomerDTOList);
   }

   @Transactional
   @Override
   public boolean modifyAndAddAndDelete(ModifyAndAddAndDeleteParm modifyAndAddAndDeleteParm) {
      this.checkLumpSumSystemTypeProject(modifyAndAddAndDeleteParm);
      ContractProject contractProject = null;
      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getUpdateAreaVO())) {
         List<Long> areaIds = modifyAndAddAndDeleteParm.getUpdateAreaVO().stream().map(AreaSaveDTOParam::getId).collect(Collectors.toList());
         Map<Long, PlanArea> planAreaMap = this.areaService
            .listByIds(modifyAndAddAndDeleteParm.getUpdateAreaVO().stream().map(AreaSaveDTOParam::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(planAreaMap), "修改区域失败,区域不存在!!!");
         Map<Long, List<TechArtifact>> artifactMap = this.techArtifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getAreaId, areaIds))
            .stream()
            .collect(Collectors.groupingBy(TechArtifact::getAreaId));
         Map<Long, List<TechStandardPart>> standardPartMap = this.techStandardPartBiz
            .list((Wrapper<TechStandardPart>)new LambdaQueryWrapper<TechStandardPart>().in(TechStandardPart::getAreaId, areaIds))
            .stream()
            .collect(Collectors.groupingBy(TechStandardPart::getAreaId));
         List<AreaSaveDTOParam> updateAreaVO = modifyAndAddAndDeleteParm.getUpdateAreaVO();
         contractProject = this.projectService.getById(updateAreaVO.get(0).getProjectId());

         for (AreaSaveDTOParam areaSaveDTOParam : updateAreaVO) {
            PlanArea planArea = new PlanArea();
            BeanUtil.copy(areaSaveDTOParam, planArea);
            PlanArea area = planAreaMap.get(areaSaveDTOParam.getId());
            if (!planArea.getItemizedType().equals(area.getItemizedType())) {
               Preconditions.checkArgument(
                  CollectionUtils.isEmpty(artifactMap.get(planArea.getId())) && CollectionUtils.isEmpty(standardPartMap.get(planArea.getId())),
                  "修改失败，区域下已导入清单，不可修改类型!!!"
               );
               if (planArea.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType())) {
                  planArea.setProductType(AreaProductTypeEnum.STRUCTURE.getType());
                  planArea.setProductCategory(ProjectContentCategoryEnum.STRUCTURE.getType());
               }

               if (planArea.getItemizedType().equals(ItemizedTypeEnum.ENCLOSURE.getType())) {
                  planArea.setProductType(
                     AreaProductTypeEnum.PRESSURE_PLATE.getType()
                        | AreaProductTypeEnum.SANDWICH_BOARD.getType()
                        | AreaProductTypeEnum.TRUSS_FLOOR_PLATE.getType()
                        | AreaProductTypeEnum.PRESSURE_FLOOR_PLATE.getType()
                        | AreaProductTypeEnum.EDGEFOLD.getType()
                  );
                  planArea.setProductCategory(ProjectContentCategoryEnum.ENCLOSURE.getType());
               }
            }

            this.projectLevelManager.updateAreaByType(area.getProjectId(), area.getId(), area.getType(), planArea.getType());
            this.areaService.updateById(planArea);
         }
      }

      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getSaveVO())) {
         List<PlanMonomerSaveDTOParam> saveVO = modifyAndAddAndDeleteParm.getSaveVO();
         List<String> planMonomerSaveDTOParamNames = saveVO.stream().map(PlanMonomerSaveDTOParam::getName).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(saveVO.size() == planMonomerSaveDTOParamNames.size(), "单体名称不能重复");
         contractProject = this.projectService.getById(saveVO.get(0).getProjectId());

         for (PlanMonomerSaveDTOParam planMonomerSaveDTOParam : saveVO) {
            Preconditions.checkArgument(contractProject != null, "项目不存在");
            if (contractProject.getProjectAttribute() != null && contractProject.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) {
               Preconditions.checkArgument(planMonomerSaveDTOParam.getLumpSumSystemType() != null, "内包制项目管理选项不能为空");
            }

            Preconditions.checkArgument(planMonomerSaveDTOParam.getAreaList() != null && planMonomerSaveDTOParam.getAreaList().size() > 0, "单体下区域不能为空");
            if (planMonomerSaveDTOParam.getId() != null) {
               PlanMonomer planMonomer = new PlanMonomer();
               BeanUtil.copy(planMonomerSaveDTOParam, planMonomer);
               this.monomerService.updateById(planMonomer);

               for (AreaSaveDTOParam areaSaveDTOParam : planMonomerSaveDTOParam.getAreaList()) {
                  Long areaId = areaSaveDTOParam.getId();
                  if (areaId != null) {
                     PlanArea planArea = new PlanArea();
                     BeanUtil.copy(areaSaveDTOParam, planArea);
                     if (planArea.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType())) {
                        planArea.setProductType(AreaProductTypeEnum.STRUCTURE.getType());
                        planArea.setProductCategory(ProjectContentCategoryEnum.STRUCTURE.getType());
                     }

                     if (planArea.getItemizedType().equals(ItemizedTypeEnum.ENCLOSURE.getType())) {
                        planArea.setProductType(
                           AreaProductTypeEnum.PRESSURE_PLATE.getType()
                              | AreaProductTypeEnum.SANDWICH_BOARD.getType()
                              | AreaProductTypeEnum.TRUSS_FLOOR_PLATE.getType()
                              | AreaProductTypeEnum.PRESSURE_FLOOR_PLATE.getType()
                              | AreaProductTypeEnum.EDGEFOLD.getType()
                        );
                        planArea.setProductCategory(ProjectContentCategoryEnum.ENCLOSURE.getType());
                     }

                     PlanArea area = this.areaService.getById(planArea.getId());
                     this.projectLevelManager.updateAreaByType(area.getProjectId(), area.getId(), area.getType(), planArea.getType());
                     this.areaService.updateById(planArea);
                  } else {
                     this.areaBiz.saveArea(areaSaveDTOParam);
                  }
               }
            } else {
               this.saveMonomer(planMonomerSaveDTOParam);
            }
         }

         List<Integer> lumpSumSystemTypeList = saveVO.stream().map(PlanMonomerSaveDTOParam::getLumpSumSystemType).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(lumpSumSystemTypeList)) {
            Integer lumpSumSystemType = lumpSumSystemTypeList.get(0);
            contractProject.setLumpSumSystemType(lumpSumSystemType);
         }
      }

      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getDeleteAreaVO())) {
         List<AreaSaveDTOParam> deleteAreaVO = modifyAndAddAndDeleteParm.getDeleteAreaVO();
         contractProject = this.projectService.getById(deleteAreaVO.get(0).getProjectId());
         List<Long> areaIds = deleteAreaVO.stream().map(AreaSaveDTOParam::getId).collect(Collectors.toList());
         this.areaBiz.deleteAreas(areaIds);

         for (AreaSaveDTOParam areaSaveDTOParam : deleteAreaVO) {
            Long monomerId = areaSaveDTOParam.getMonomerId();
            List<PlanArea> list = this.areaService.list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, monomerId));
            if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getDeleteMonomerVO())) {
               List<Long> deleteMonomerVO = modifyAndAddAndDeleteParm.getDeleteMonomerVO()
                  .stream()
                  .map(PlanMonomerSaveDTOParam::getId)
                  .collect(Collectors.toList());
               if (deleteMonomerVO.contains(areaSaveDTOParam.getMonomerId())) {
                  continue;
               }
            }

            Preconditions.checkArgument(list.size() > 0, "单体下区域不能为空");
         }
      }

      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getDeleteMonomerVO())) {
         List<PlanMonomerSaveDTOParam> deleteMonomerVO = modifyAndAddAndDeleteParm.getDeleteMonomerVO();
         contractProject = this.projectService.getById(deleteMonomerVO.get(0).getProjectId());
         List<Long> monomerIds = deleteMonomerVO.stream().map(PlanMonomerSaveDTOParam::getId).collect(Collectors.toList());
         this.removeMonomer(monomerIds);
      }

      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getUpdateMonomerVO())) {
         List<PlanMonomerSaveDTOParam> updateMonomerVO = modifyAndAddAndDeleteParm.getUpdateMonomerVO();
         contractProject = this.projectService.getById(updateMonomerVO.get(0).getProjectId());

         for (PlanMonomerSaveDTOParam planMonomerSaveDTOParam : updateMonomerVO) {
            PlanMonomer planMonomer = new PlanMonomer();
            BeanUtil.copy(planMonomerSaveDTOParam, planMonomer);
            this.monomerService.updateById(planMonomer);
         }
      }

      Preconditions.checkArgument(contractProject != null, "操作失败!!项目不存在!!");
      List<PlanArea> areas = this.areaService.list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getProjectId, contractProject.getId()));
      List<Integer> itemizedType = areas.stream().map(PlanArea::getItemizedType).distinct().collect(Collectors.toList());
      int projectType = 0;

      for (int number : itemizedType) {
         projectType |= number;
      }

      contractProject.setProjectType(projectType);
      int productCategory = 0;
      if (itemizedType.contains(ItemizedTypeEnum.ARTIFACT.getType())) {
         productCategory |= ProjectContentCategoryEnum.STRUCTURE.getType();
      }

      if (itemizedType.contains(ItemizedTypeEnum.ENCLOSURE.getType())) {
         productCategory |= ProjectContentCategoryEnum.ENCLOSURE.getType();
      }

      if (itemizedType.contains(ItemizedTypeEnum.OTHER.getType())) {
         productCategory |= ProjectContentCategoryEnum.AUXILIARY.getType();
      }

      contractProject.setProductCategory(productCategory);
      ContractProject project = this.projectService.getById(contractProject.getId());
      contractProject.setVersion(project.getVersion());
      contractProject.setLevel(project.getLevel());
      this.projectService.updateById(contractProject);
      this.redisUtils.del("simpleProjectList");
      List<PlanAreaBatch> areaBatchAllList = this.areaBatchService
         .list((Wrapper<PlanAreaBatch>)new LambdaQueryWrapper<PlanAreaBatch>().eq(PlanAreaBatch::getProjectId, contractProject.getId()));
      if (CollectionUtils.isNotEmpty(areaBatchAllList)) {
         Map<Long, List<PlanAreaBatch>> areaBatchMap = areaBatchAllList.stream().collect(Collectors.groupingBy(PlanAreaBatch::getAreaId));
         List<PlanArea> areaList = this.areaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getProjectId, contractProject.getId()));
         if (CollectionUtils.isNotEmpty(areaList)) {
            for (PlanArea planArea : areaList) {
               List<PlanAreaBatch> areaBatchList = areaBatchMap.get(planArea.getId());
               if (CollectionUtils.isNotEmpty(areaBatchList)) {
                  for (PlanAreaBatch areaBatch : areaBatchList) {
                     areaBatch.setDate(planArea.getDate());
                     areaBatch.setType(planArea.getType());
                     areaBatch.setProductType(planArea.getProductType());
                     areaBatch.setProductCategory(planArea.getProductCategory());
                     areaBatch.setDeepenStartDate(planArea.getDeepenStartDate());
                     areaBatch.setDeepenEndDate(planArea.getDeepenEndDate());
                     areaBatch.setPurchaseEndDate(planArea.getPurchaseEndDate());
                     areaBatch.setPurchaseStartDate(planArea.getPurchaseStartDate());
                     areaBatch.setProcessStartDate(planArea.getProcessStartDate());
                     areaBatch.setProcessEndDate(planArea.getProcessEndDate());
                     areaBatch.setShippingStartDate(planArea.getShippingStartDate());
                     areaBatch.setShippingEndDate(planArea.getShippingEndDate());
                     areaBatch.setInstallStartDate(planArea.getInstallStartDate());
                     areaBatch.setInstallEndDate(planArea.getInstallEndDate());
                     areaBatch.setItemizedType(planArea.getItemizedType());
                     areaBatch.setMete(planArea.getMete());
                     areaBatch.setAllDays(planArea.getAllDays());
                     areaBatch.setUnitName(planArea.getUnitName());
                     areaBatch.setPid(planArea.getPid());
                  }

                  this.areaBatchService.updateBatchById(areaBatchList);
               }
            }
         }
      }

      return true;
   }

   private void checkLumpSumSystemTypeProject(ModifyAndAddAndDeleteParm modifyAndAddAndDeleteParm) {
      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getSaveVO())) {
         List<PlanMonomerSaveDTOParam> saveMonomerDTOList = modifyAndAddAndDeleteParm.getSaveVO();
         ContractProject contractProject = this.projectService.getById(saveMonomerDTOList.get(0).getProjectId());
         Preconditions.checkArgument(contractProject != null, "项目不存在");
         if (ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType().equals(contractProject.getProjectAttribute())) {
            List<PlanMonomer> planMonomerList = this.monomerService
               .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, contractProject.getId()));
            if (CollectionUtils.isNotEmpty(planMonomerList)) {
               Preconditions.checkArgument(
                  saveMonomerDTOList.stream().allMatch(save -> contractProject.getLumpSumSystemType().equals(save.getLumpSumSystemType())),
                  "操作失败,包干制项目管理选项不一致!!!"
               );
            }

            if (CollectionUtils.isEmpty(planMonomerList)) {
               saveMonomerDTOList.forEach(e -> Preconditions.checkArgument(e.getLumpSumSystemType() != null, "内包制项目管理选项不能为空"));
               List<Integer> lumpSumSystemTypes = saveMonomerDTOList.stream()
                  .map(PlanMonomerSaveDTOParam::getLumpSumSystemType)
                  .distinct()
                  .collect(Collectors.toList());
               Preconditions.checkArgument(lumpSumSystemTypes.size() == 1, "包干制项目管理选择需保持一致!!!");
               Preconditions.checkArgument(!LumpSumSystemEnum.OTHER.getType().equals(lumpSumSystemTypes.get(0)), "包干制项目管理类型错误!!!");
               contractProject.setLumpSumSystemType(lumpSumSystemTypes.get(0));
            }
         }
      }

      if (CollectionUtils.isNotEmpty(modifyAndAddAndDeleteParm.getUpdateMonomerVO())) {
         List<PlanMonomerSaveDTOParam> updateMonomerVOList = modifyAndAddAndDeleteParm.getUpdateMonomerVO();
         ContractProject contractProject = this.projectService.getById(updateMonomerVOList.get(0).getProjectId());
         Preconditions.checkArgument(contractProject != null, "项目不存在");
         if (ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType().equals(contractProject.getProjectAttribute())) {
            Preconditions.checkArgument(
               updateMonomerVOList.stream().allMatch(update -> contractProject.getLumpSumSystemType().equals(update.getLumpSumSystemType())),
               "操作失败,包干制项目管理选项不一致!!!"
            );
         }
      }
   }

   public PlanMonomerBizImpl(
      final PlanAreaBiz planAreaBiz,
      final PlanMonomerDetailService monomerDetailService,
      final PlanAreaService areaService,
      final PlanAreaBiz areaBiz,
      final PlanMonomerService monomerService,
      final ContractProjectService projectService,
      final BimModelCommonService bimModelCommonService,
      final ContractProjectContentService contractProjectContentService,
      final BimModelConfigurationService bimModelConfigurationService,
      final InboundDetailService wmsInboundDetailService,
      final MoveOutboundDetailService moveOutboundDetailService,
      final SubcontractMonomerLinkService subcontractMonomerLinkService,
      final TransferService transferService,
      final TechArtifactService techArtifactService,
      final MonomerUserLinkService monomerUserLinkService,
      final TechArtifactMachinePartBiz techArtifactMachinePartBiz,
      final TechStandardPartBiz techStandardPartBiz,
      final TechnologyBiz technologyBiz,
      final MesTechInventoryOperationService mesTechInventoryOperationService,
      final PlanAreaBatchService areaBatchService,
      final SysPushFlowConfigBiz sysPushFlowConfigBiz,
      final NotificationTemplateDetailsUtils detailsUtils,
      final TechArtifactService artifactService,
      final ProjectLevelManager projectLevelManager,
      final MessagePushUtil messagePushUtil,
      final MesBuildingTaskService taskService,
      final RedisUtils redisUtils,
      final MesEnclosureTaskService enclosureTaskServicevate,
      final MesBuildingTaskProcessService taskProcessService,
      final MesBuildingTeamUserLinkService teamUserLinkService
   ) {
      this.planAreaBiz = planAreaBiz;
      this.monomerDetailService = monomerDetailService;
      this.areaService = areaService;
      this.areaBiz = areaBiz;
      this.monomerService = monomerService;
      this.projectService = projectService;
      this.bimModelCommonService = bimModelCommonService;
      this.contractProjectContentService = contractProjectContentService;
      this.bimModelConfigurationService = bimModelConfigurationService;
      this.wmsInboundDetailService = wmsInboundDetailService;
      this.moveOutboundDetailService = moveOutboundDetailService;
      this.subcontractMonomerLinkService = subcontractMonomerLinkService;
      this.transferService = transferService;
      this.techArtifactService = techArtifactService;
      this.monomerUserLinkService = monomerUserLinkService;
      this.techArtifactMachinePartBiz = techArtifactMachinePartBiz;
      this.techStandardPartBiz = techStandardPartBiz;
      this.technologyBiz = technologyBiz;
      this.mesTechInventoryOperationService = mesTechInventoryOperationService;
      this.areaBatchService = areaBatchService;
      this.sysPushFlowConfigBiz = sysPushFlowConfigBiz;
      this.detailsUtils = detailsUtils;
      this.artifactService = artifactService;
      this.projectLevelManager = projectLevelManager;
      this.messagePushUtil = messagePushUtil;
      this.taskService = taskService;
      this.redisUtils = redisUtils;
      this.enclosureTaskServicevate = enclosureTaskServicevate;
      this.taskProcessService = taskProcessService;
      this.teamUserLinkService = teamUserLinkService;
   }
}
