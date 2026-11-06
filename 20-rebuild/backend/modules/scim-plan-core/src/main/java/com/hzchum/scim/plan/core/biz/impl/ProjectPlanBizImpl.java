package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.PlanAreaBiz;
import com.hzchum.scim.plan.core.api.biz.PlanMonomerBiz;
import com.hzchum.scim.plan.core.api.biz.ProjectPlanBiz;
import com.hzchum.scim.plan.core.api.manager.ProjectLevelManager;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ProjectPlanDetailSaveParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.mapper.ProjectPlanMapper;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSaveDTOParam;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectPlanBizImpl implements ProjectPlanBiz {
   @Autowired
   private ProjectPlanMapper projectPlanMapper;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private PlanMonomerBiz monomerBiz;
   @Autowired
   private PlanAreaBiz areaBiz;
   @Autowired
   private ProjectLevelManager projectLevelManager;
   @Autowired
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Autowired
   private NotificationTemplateDetailsUtils detailsUtils;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private RedisUtils redisUtils;
   @Autowired
   private TechStandardPartService standardPartService;
   @Autowired
   private MesTechInventoryOperationService inventoryOperationService;

   @Override
   public PageVO<ProjectPlanDTO> page(Integer year, String projectNoOrName, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectPlanDTO> dtoList = this.projectPlanMapper.projectList(year, projectNoOrName);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PageVO<ProjectPlanDTO> enclosurePlanPage(Integer year, String projectNoOrName, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectPlanDTO> dtoList = this.projectPlanMapper.enclosureProjectPlanList(year, projectNoOrName);
      return CollectionUtils.isEmpty(dtoList) ? new PageVO<>() : new PageVO<>(page, dtoList);
   }

   @Override
   public Map<String, Object> countInfo(Integer year, String projectNoOrName) {
      List<ProjectPlanDTO> dtoList = this.projectPlanMapper.projectList(year, projectNoOrName);
      int projectCount = dtoList.size();
      long createdCount = dtoList.stream().filter(dto -> dto.getPlanStatus().equals(1)).count();
      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("projectCount", projectCount);
      resultMap.put("createdCount", createdCount);
      resultMap.put("notCreatedCount", NumberUtil.sub(projectCount, (float)createdCount));
      return resultMap;
   }

   @Override
   public ProjectPlanDetailDTO DetailByProjectId(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(project), "项目不存在");
      List<ProjectPlanMonomerDTO> monomerList = this.monomerService.getListByProjectId(projectId);
      List<ProjectPlanAreaDTO> areaList = this.areaService.getListByProjectId(projectId);
      Map<Long, List<ProjectPlanAreaDTO>> areaByMonomerIdGroup = areaList.stream().collect(Collectors.groupingBy(ProjectPlanAreaDTO::getMonomerId));
      monomerList.forEach(monomer -> {
         List<ProjectPlanAreaDTO> areas = areaByMonomerIdGroup.get(monomer.getId());
         monomer.setAreaList(areas);
      });
      return ProjectPlanDetailDTO.builder().projectId(projectId).monomerList(monomerList).build();
   }

   private Integer getDuration(List<LocalDate> startDateList, List<LocalDate> endDateList) {
      if (CollUtil.isNotEmpty(startDateList) && CollUtil.isNotEmpty(endDateList)) {
         LocalDate startDate = (LocalDate)startDateList.stream().filter(Objects::nonNull).min(Comparator.naturalOrder()).orElse(null);
         LocalDate endDate = (LocalDate)endDateList.stream().filter(Objects::nonNull).max(Comparator.naturalOrder()).orElse(null);
         if (startDate != null && endDate != null) {
            long duration = ChronoUnit.DAYS.between(startDate, endDate);
            return (int)duration;
         }
      }

      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean detailBatchSave(ProjectPlanDetailSaveParam param) {
      List<ProjectPlanDetailSaveParam.MonomerSaveParam> saves = param.getMonomerSaveParams() == null ? Collections.emptyList() : param.getMonomerSaveParams();
      Set<Long> removeMonomers = new HashSet<>(param.getRemoveMonomerIds() == null ? Collections.emptyList() : param.getRemoveMonomerIds());
      Set<Long> removeAreas = new HashSet<>(param.getRemoveAreaIds() == null ? Collections.emptyList() : param.getRemoveAreaIds());
      Set<Long> projects = new HashSet<>();
      Set<Long> submittedAreas = new HashSet<>();
      Set<Long> touchedMonomers = new HashSet<>();
      for (ProjectPlanDetailSaveParam.MonomerSaveParam save : saves) {
         Preconditions.checkArgument(save.getProjectId() != null, "项目不能为空");
         projects.add(save.getProjectId());
         if (save.getId() != null) {
            PlanMonomer actual = this.monomerService.getById(save.getId());
            Preconditions.checkArgument(actual != null && Objects.equals(actual.getProjectId(), save.getProjectId()), "单体不属于当前项目");
         }
         for (ProjectPlanDetailSaveParam.AreaSaveParam area : save.getAreaList() == null ? Collections.<ProjectPlanDetailSaveParam.AreaSaveParam>emptyList() : save.getAreaList()) {
            Preconditions.checkArgument(Objects.equals(area.getProjectId(), save.getProjectId()), "区域不属于当前项目");
            if (area.getId() != null) {
               Preconditions.checkArgument(submittedAreas.add(area.getId()), "区域不能重复提交");
               PlanArea actual = this.areaService.getById(area.getId());
               Preconditions.checkArgument(actual != null && Objects.equals(actual.getProjectId(), save.getProjectId())
                  && Objects.equals(actual.getMonomerId(), save.getId()), "区域不属于当前单体");
            }
         }
      }
      for (Long id : removeMonomers) {
         PlanMonomer monomer = this.monomerService.getById(id);
         Preconditions.checkArgument(monomer != null, "单体不存在");
         projects.add(monomer.getProjectId());
         this.areaService.list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, id)).forEach(a -> removeAreas.add(a.getId()));
      }
      for (Long id : removeAreas) {
         PlanArea area = this.areaService.getById(id);
         Preconditions.checkArgument(area != null, "区域不存在");
         projects.add(area.getProjectId());
         if (!removeMonomers.contains(area.getMonomerId())) touchedMonomers.add(area.getMonomerId());
      }
      Preconditions.checkArgument(projects.size() == 1, "一次仅可保存同一项目的计划");
      Long projectId = projects.iterator().next();
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      if (!removeAreas.isEmpty()) this.areaBiz.deleteAreas(new ArrayList<>(removeAreas));
      if (!removeMonomers.isEmpty()) this.monomerBiz.removeMonomer(new ArrayList<>(removeMonomers));
      Set<String> monomerNames = new HashSet<>();
      for (ProjectPlanDetailSaveParam.MonomerSaveParam save : saves) {
         if (removeMonomers.contains(save.getId())) continue;
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(save.getName()) && monomerNames.add(save.getName()), "单体名称不能为空或重复");
         List<ProjectPlanDetailSaveParam.AreaSaveParam> areas = (save.getAreaList() == null ? Collections.<ProjectPlanDetailSaveParam.AreaSaveParam>emptyList() : save.getAreaList())
            .stream().filter(a -> !removeAreas.contains(a.getId())).collect(Collectors.toList());
         Preconditions.checkArgument(!areas.isEmpty(), "单体下区域不能为空");
         PlanMonomer monomer;
         if (save.getId() == null) {
            PlanMonomerSaveDTOParam legacy = new PlanMonomerSaveDTOParam();
            legacy.setProjectId(projectId);legacy.setName(save.getName());legacy.setRemark(save.getRemark());legacy.setSort(save.getSort());
            legacy.setStartDate(areas.stream().map(ProjectPlanDetailSaveParam.AreaSaveParam::getDeliveryStartDate).filter(Objects::nonNull).min(Comparator.naturalOrder()).orElse(null));
            legacy.setEndDate(areas.stream().map(ProjectPlanDetailSaveParam.AreaSaveParam::getDeliveryEndDate).filter(Objects::nonNull).max(Comparator.naturalOrder()).orElse(null));
            legacy.setLumpSumSystemType(project.getLumpSumSystemType());
            if (Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()))
               Preconditions.checkArgument(legacy.getLumpSumSystemType() != null, "内包制项目管理选项不能为空");
            this.monomerBiz.saveMonomer(legacy);
            monomer = this.monomerService.getOne(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId).eq(PlanMonomer::getName, save.getName()));
         } else {
            monomer = this.monomerService.getById(save.getId());
            Preconditions.checkArgument(this.monomerService.count(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId)
               .eq(PlanMonomer::getName, save.getName()).ne(PlanMonomer::getId, monomer.getId())) == 0, "该项目下已存在同名单体");
            monomer.setName(save.getName());monomer.setRemark(save.getRemark());monomer.setSort(save.getSort());
            this.monomerService.updateWithCache(monomer);
         }
         touchedMonomers.add(monomer.getId());
         Set<String> areaNames = new HashSet<>();
         for (ProjectPlanDetailSaveParam.AreaSaveParam area : areas) {
            Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(area.getName()) && areaNames.add(area.getName()), "区域名称不能为空或重复");
            savePlanArea(monomer, area);
         }
      }
      // Deletion-only requests retain the same nonempty-monomer rule as the legacy editor.
      for (Long monomerId : touchedMonomers)
         Preconditions.checkArgument(this.areaService.count(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, monomerId)) > 0, "单体下区域不能为空");
      List<ProjectSimpleInfoDTO> projectSimpleList = this.contractProjectBiz.listAllProjectSimple();
      this.redisUtils.set("simpleProjectList", projectSimpleList);
      return true;
   }

   private void savePlanArea(PlanMonomer monomer, ProjectPlanDetailSaveParam.AreaSaveParam param) {
      Integer category = param.getProjectPlanProductCategory();
      Preconditions.checkArgument(Arrays.asList(2, 4, 8).contains(category), "制品类别不存在");
      Preconditions.checkArgument(param.getBudgetVolume() != null && param.getBudgetVolume().compareTo(BigDecimal.ZERO) >= 0, "预算量不能小于0");
      Preconditions.checkArgument(Arrays.asList(0, 1).contains(param.getProductionWay()), "生产方式不存在");
      Preconditions.checkArgument(param.getDeliveryStartDate() != null && param.getDeliveryEndDate() != null
         && !param.getDeliveryStartDate().isAfter(param.getDeliveryEndDate()), "交货日期范围有误");
      validatePlanDates(param.getDeepenStartDate(), param.getDeepenEndDate());validatePlanDates(param.getPurchaseStartDate(), param.getPurchaseEndDate());
      validatePlanDates(param.getProcessStartDate(), param.getProcessEndDate());validatePlanDates(param.getShippedStartDate(), param.getShippedEndDate());
      validatePlanDates(param.getInstallStartDate(), param.getInstallEndDate());
      int itemized = category == 2 ? 1 : category == 4 ? 8 : 64;
      Preconditions.checkArgument(this.areaService.count(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, monomer.getId())
         .eq(PlanArea::getName, param.getName()).eq(PlanArea::getItemizedType, itemized).ne(param.getId() != null, PlanArea::getId, param.getId())) == 0, "该区域名称已存在");
      PlanArea area;
      if (param.getId() == null) {
         AreaSaveDTOParam legacy = new AreaSaveDTOParam();BeanUtil.copyProperties(param, legacy);
         legacy.setMonomerId(monomer.getId());legacy.setProjectId(monomer.getProjectId());legacy.setItemizedType(itemized);
         legacy.setType(param.getProductionWay());legacy.setMete(param.getBudgetVolume());legacy.setUnitName(param.getUnit());
         legacy.setStartDate(param.getDeliveryStartDate());legacy.setEndDate(param.getDeliveryEndDate());
         legacy.setShippingStartDate(param.getShippedStartDate());legacy.setShippingEndDate(param.getShippedEndDate());
         this.areaBiz.saveArea(legacy);
         area = this.areaService.getOne(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, monomer.getId())
            .eq(PlanArea::getName, param.getName()).eq(PlanArea::getItemizedType, itemized));
      } else {
         area = this.areaService.getById(param.getId());
         if (!Objects.equals(area.getProjectPlanProductCategory(), category) || !Objects.equals(area.getType(), param.getProductionWay())) {
            Preconditions.checkArgument(this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getAreaId, area.getId())) == 0
               && this.enclosureService.count(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getAreaId, area.getId())) == 0
               && this.standardPartService.count(Wrappers.lambdaQuery(TechStandardPart.class).eq(TechStandardPart::getAreaId, area.getId())) == 0,
               "该区域已导入清单，不可修改类型");
            this.inventoryOperationService.checkInventoryOperationByAreaId(area.getId(), Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType()));
            this.projectLevelManager.updateAreaByType(monomer.getProjectId(), area.getId(), area.getType(), param.getProductionWay());
         }
      }
      area.setName(param.getName());area.setRemark(param.getRemark());area.setSort(param.getSort());
      area.setProjectPlanProductCategory(category);area.setItemizedType(itemized);area.setType(param.getProductionWay());
      if (category == 2) {area.setProductType(AreaProductTypeEnum.STRUCTURE.getType());area.setProductCategory(ProjectContentCategoryEnum.STRUCTURE.getType());}
      if (category == 4) {area.setProductType(2 | 4 | 8 | 16 | 32);area.setProductCategory(ProjectContentCategoryEnum.ENCLOSURE.getType());}
      if (category == 8) {area.setProductType(null);area.setProductCategory(ProjectContentCategoryEnum.AUXILIARY.getType());}
      area.setMete(param.getBudgetVolume());area.setUnitName(param.getUnit());
      area.setDeliveryStartDate(param.getDeliveryStartDate());area.setDeliveryEndDate(param.getDeliveryEndDate());
      area.setDeepenStartDate(param.getDeepenStartDate());area.setDeepenEndDate(param.getDeepenEndDate());
      area.setPurchaseStartDate(param.getPurchaseStartDate());area.setPurchaseEndDate(param.getPurchaseEndDate());
      area.setProcessStartDate(param.getProcessStartDate());area.setProcessEndDate(param.getProcessEndDate());
      area.setShippingStartDate(param.getShippedStartDate());area.setShippingEndDate(param.getShippedEndDate());
      area.setInstallStartDate(param.getInstallStartDate());area.setInstallEndDate(param.getInstallEndDate());area.setInstallDuration(param.getInstallDuration());
      // Explicit nullable assignments allow the current editor to clear an optional stage without changing legacy update semantics.
      this.areaService.update(Wrappers.<PlanArea>lambdaUpdate().eq(PlanArea::getId, area.getId())
         .set(PlanArea::getRemark, param.getRemark()).set(PlanArea::getUnitName, param.getUnit())
         .set(category == 8, PlanArea::getProductType, null)
         .set(PlanArea::getDeepenStartDate, param.getDeepenStartDate()).set(PlanArea::getDeepenEndDate, param.getDeepenEndDate())
         .set(PlanArea::getPurchaseStartDate, param.getPurchaseStartDate()).set(PlanArea::getPurchaseEndDate, param.getPurchaseEndDate())
         .set(PlanArea::getProcessStartDate, param.getProcessStartDate()).set(PlanArea::getProcessEndDate, param.getProcessEndDate())
         .set(PlanArea::getShippingStartDate, param.getShippedStartDate()).set(PlanArea::getShippingEndDate, param.getShippedEndDate())
         .set(PlanArea::getInstallStartDate, param.getInstallStartDate()).set(PlanArea::getInstallEndDate, param.getInstallEndDate())
         .set(PlanArea::getInstallDuration, param.getInstallDuration()));
      this.areaService.updateAreaWithCache(area);
   }

   private void validatePlanDates(LocalDate start, LocalDate end) {
      Preconditions.checkArgument((start == null && end == null) || (start != null && end != null && !start.isAfter(end)), "阶段日期范围有误");
   }

}
