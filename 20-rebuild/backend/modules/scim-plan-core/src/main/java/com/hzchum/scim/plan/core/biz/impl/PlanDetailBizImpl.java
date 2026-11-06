package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.biz.PlanDetailBiz;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.AreaTypeEnum;
import com.hzchum.scim.plan.core.api.enums.PlanDetailTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailTraceDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ProjectManagePlanAreaVO;
import com.hzchum.scim.plan.core.api.pojo.vo.ProjectManagePlanMonomerVO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallMeteSummaryDTO;
import com.hzchum.scim.project.core.api.utils.ProjectInstallBizUtil;
import com.hzchum.scim.scm.core.api.pojo.dto.AreaDTO;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanDetailBizImpl implements PlanDetailBiz {
   private static final Logger log = LoggerFactory.getLogger(PlanDetailBizImpl.class);
   @Resource
   private PlanDetailService planDetailService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanMonomerDetailService monomerDetailService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingCompleteService buildingCompleteService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private ProjectInstallBizUtil installBizUtil;
   @Resource
   private MesBuildingCargoListService mesBuildingCargoListService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private ContractProjectBiz projectBiz;
   @Resource
   private MesEnclosureTaskService enclosureTaskService;
   @Resource
   private MesEnclosureProcessService enclosureProcessService;
   @Resource
   private TechEnclosureBiz enclosureBiz;

   @Override
   public ListVO<PlanMonomerDTO> listDetailsByConditions(Long projectId, Long monomerId) {
      List<PlanMonomerDTO> monomerDTOList = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId).eq(monomerId != null, PlanMonomer::getId, monomerId))
         .stream()
         .map(m -> BeanUtil.copy(m, PlanMonomerDTO.class))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(monomerDTOList)) {
         monomerDTOList.forEach(
            m -> {
               List<PlanMonomerDetailDTO> monomerDetailDTOS = this.monomerDetailService
                  .list(Wrappers.lambdaQuery(PlanMonomerDetail.class).eq(PlanMonomerDetail::getMonomerId, m.getId()))
                  .stream()
                  .map(d -> BeanUtil.copy(d, PlanMonomerDetailDTO.class))
                  .collect(Collectors.toList());
               monomerDetailDTOS.forEach(
                  md -> {
                     List<PlanAreaDTO> areaDTOList = this.areaService
                        .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, md.getMonomerId()).eq(PlanArea::getProductType, md.getType()))
                        .stream()
                        .map(a -> BeanUtil.copy(a, PlanAreaDTO.class))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(areaDTOList)) {
                        areaDTOList.forEach(
                           a -> {
                              List<PlanDetailDTO> planDetailDTOList = this.planDetailService
                                 .list(Wrappers.lambdaQuery(PlanDetail.class).eq(PlanDetail::getAreaId, a.getId()))
                                 .stream()
                                 .map(pd -> BeanUtil.copy(pd, PlanDetailDTO.class))
                                 .collect(Collectors.toList());
                              a.setPlanDetailList(planDetailDTOList);
                           }
                        );
                     }

                     md.setAreaList(areaDTOList);
                  }
               );
               m.setMonomerDetailList(monomerDetailDTOS);
            }
         );
      }

      return new ListVO<>(monomerDTOList);
   }

   @Override
   public void exportPlanDetails(Long monomerId, Integer productType, HttpServletResponse response) {
      Map<String, Object> map = new HashMap<>(16);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "下载失败，单体不存在！");
      ProjectInfo project = this.projectService.getSimpleById(monomer.getProjectId());
      List<PlanDetailResponseDTO> planDetailResponseVOS = this.planDetailService.listDetailByConditions(null, monomerId, productType, null);
      String desc = AreaProductTypeEnum.getDescByType(productType);
      map.put("projectName", project.getName());
      map.put("monomerName", monomer.getName());
      map.put("areaProductTypeName", AreaProductTypeEnum.getNameByType(productType));
      String resourcePath = "template/PlanDetailExportTemplate.xlsx";
      String tempFileName = "PlanDetailExportTemplate";
      String exportFileName = "计划制定-" + desc + ".xlsx";
      this.setOverallPlan(map, planDetailResponseVOS);
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   private void setOverallPlan(Map<String, Object> map, List<PlanDetailResponseDTO> planDetailResponseVOS) {
      List<Map<String, Object>> deepenPlanList = new ArrayList<>();
      List<Map<String, Object>> machiningPlanList = new ArrayList<>();
      List<Map<String, Object>> installationPlanList = new ArrayList<>();
      AtomicInteger id = new AtomicInteger(1);
      AtomicInteger j = new AtomicInteger(1);
      AtomicInteger i = new AtomicInteger(1);
      if (CollectionUtils.isNotEmpty(planDetailResponseVOS)) {
         planDetailResponseVOS.forEach(vo -> {
            HashMap<String, Object> planMap = new HashMap<>(16);
            planMap.put("area", vo.getName());
            planMap.put("axis", vo.getAxis());
            planMap.put("areaType", AreaTypeEnum.getNameByType(vo.getAreaType()));
            planMap.put("startDate", vo.getStartDate() == null ? "/" : vo.getStartDate());
            planMap.put("endDate", vo.getEndDate() == null ? "/" : vo.getEndDate());
            planMap.put("remark", StringUtils.isBlank(vo.getRemark()) ? "/" : vo.getRemark());
            if (null != vo.getStartDate() && null != vo.getEndDate()) {
               Integer days = DateTimeUtil.getBetweenDays(vo.getStartDate(), vo.getEndDate());
               planMap.put("totalDate", days + 1);
            } else {
               planMap.put("totalDate", "/");
            }

            if (vo.getType().equals(PlanDetailTypeEnum.DEEPEN_PLAN.getType())) {
               planMap.put("id", id.getAndIncrement());
               deepenPlanList.add(planMap);
            } else if (vo.getType().equals(PlanDetailTypeEnum.PROCESSING_PLAN.getType())) {
               planMap.put("id", i.getAndIncrement());
               machiningPlanList.add(planMap);
            } else if (vo.getType().equals(PlanDetailTypeEnum.INSTALL_PLAN.getType())) {
               planMap.put("id", j.getAndIncrement());
               installationPlanList.add(planMap);
            }
         });
      }

      map.put("deepenPlanList", deepenPlanList);
      map.put("machiningPlanList", machiningPlanList);
      map.put("installationPlanList", installationPlanList);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updatePlanDetail(PlanDetailUpdateDTOParam updateDTOParam) {
      PlanDetail planDetail = this.planDetailService.getById(updateDTOParam.getId());
      Preconditions.checkArgument(planDetail != null, "计划详情不存在");
      PlanArea area = this.areaService.getById(planDetail.getAreaId());
      Preconditions.checkArgument(area != null, "区域不存在!");
      ContractProject project = this.projectService.checkProjectStatus(planDetail.getProjectId());
      if (updateDTOParam.getEndDate() != null && !planDetail.getType().equals(PlanDetailTypeEnum.INSTALL_PLAN.getType())) {
         Preconditions.checkArgument(!updateDTOParam.getEndDate().isAfter(area.getDate()), "计划结束日期不能晚于区域结束日期");
      }

      if (updateDTOParam.getStartDate() != null) {
         Preconditions.checkArgument(!updateDTOParam.getStartDate().isAfter(area.getDate()), "计划开始日期不能晚于区域结束日期");
         Preconditions.checkArgument(project.getStartDate() == null || !updateDTOParam.getStartDate().isBefore(project.getStartDate()), "计划结束日期不能早于项目开始日期");
      }

      if (updateDTOParam.getStartDate() != null && updateDTOParam.getEndDate() != null) {
         Preconditions.checkArgument(!updateDTOParam.getStartDate().isAfter(updateDTOParam.getEndDate()), "计划开始日期不能晚于计划结束日期");
      }

      BeanUtil.copy(updateDTOParam, planDetail);
      this.planDetailService.updateById(planDetail);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean editPlanDetailList(Long areaId, List<PlanDetailUpdateDTOParam> paramList) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(paramList), "计划列表为空");
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在!");
      PlanMonomer monomer = this.monomerService.getById(area.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在!");
      ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
      Map<Integer, PlanDetail> planDetailTypeMap = this.planDetailService
         .list(Wrappers.lambdaQuery(PlanDetail.builder().areaId(areaId).build()))
         .stream()
         .collect(Collectors.toMap(PlanDetail::getType, Function.identity()));
      paramList.forEach(
         param -> {
            if (param.getStartDate() != null && param.getEndDate() != null) {
               Preconditions.checkArgument(!param.getStartDate().isAfter(param.getEndDate()), "计划开始日期不能晚于计划结束日期");
            }

            if (param.getStartDate() != null) {
               Preconditions.checkArgument(!param.getStartDate().isAfter(area.getDate()), "计划开始日期不能晚于区域结束日期");
               Preconditions.checkArgument(monomer.getStartDate() == null || !param.getStartDate().isBefore(monomer.getStartDate()), "计划开始日期不能早于单体开始日期");
               Preconditions.checkArgument(project.getStartDate() == null || !param.getStartDate().isBefore(project.getStartDate()), "计划开始日期不能早于项目开始日期");
            }

            if (param.getEndDate() != null && !param.getType().equals(PlanDetailTypeEnum.INSTALL_PLAN.getType())) {
               Preconditions.checkArgument(!param.getEndDate().isAfter(area.getDate()), "计划结束日期不能晚于区域结束日期");
            }

            if (planDetailTypeMap.containsKey(param.getType())) {
               PlanDetail planDetail = planDetailTypeMap.get(param.getType());
               BeanUtil.copy(param, planDetail);
               this.planDetailService.updateById(planDetail);
            } else {
               PlanDetail planDetail = PlanDetail.builder()
                  .projectId(area.getProjectId())
                  .monomerId(area.getMonomerId())
                  .areaId(areaId)
                  .areaProductType(area.getProductType())
                  .productCategory(area.getProductCategory())
                  .build();
               BeanUtil.copy(param, planDetail);
               this.planDetailService.save(planDetail);
            }
         }
      );
      return true;
   }

   @Override
   public PrintVO printOverallPlan(Long monomerId, Integer productType, Integer type) {
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "下载失败，单体不存在！");
      PrintVO<List<Map<String, Object>>> print = new PrintVO<>();
      Map<String, Object> header = print.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(monomer.getProjectId());
      header.put("project", projectInfo);
      header.put("monomer", monomer.getName());
      header.put("productType", AreaProductTypeEnum.getDescByType(productType));
      header.put("type", PlanDetailTypeEnum.getNameByType(type));
      print.setHeader(header);
      List<PlanDetailResponseDTO> planDetailResponseDTOS = this.planDetailService.listDetailByConditions(null, monomerId, productType, type);
      List<Map<String, Object>> table = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(planDetailResponseDTOS)) {
         table = planDetailResponseDTOS.stream().map(plan -> {
            Map<String, Object> planMap = BeanUtil.beanToMap(plan);
            planMap.put("startDate", plan.getStartDate() != null ? DateTimeUtil.localDateToString(plan.getStartDate()) : "/");
            planMap.put("endDate", plan.getEndDate() != null ? DateTimeUtil.localDateToString(plan.getEndDate()) : "/");
            planMap.put("type", PlanDetailTypeEnum.getNameByType(plan.getType()));
            planMap.put("areaType", AreaTypeEnum.getNameByType(plan.getAreaType()));
            if (null != plan.getStartDate() && null != plan.getEndDate()) {
               Integer day = DateTimeUtil.getBetweenDays(plan.getStartDate(), plan.getEndDate());
               planMap.put("day", day + 1);
            } else {
               planMap.put("day", "/");
            }

            return planMap;
         }).collect(Collectors.toList());
      }

      print.setTable(table);
      return print;
   }

   @Override
   public ListVO<PlanMonomerDTO> listDetailsByCondition(Long projectId, Long monomerId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<PlanMonomerDTO> monomerDTOList = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId).eq(monomerId != null, PlanMonomer::getId, monomerId))
         .stream()
         .map(m -> BeanUtil.copy(m, PlanMonomerDTO.class))
         .collect(Collectors.toList());
      monomerDTOList.forEach(
         m -> {
            List<PlanMonomerDetail> monomerDetailList = this.monomerDetailService
               .list(Wrappers.lambdaQuery(PlanMonomerDetail.class).eq(PlanMonomerDetail::getMonomerId, m.getId()));
            List<PlanMonomerDetailDTO> monomerDetailDTOList = new ArrayList<>(16);
            monomerDetailList.forEach(
               monomerDetail -> {
                  PlanMonomerDetailDTO md = BeanUtil.copy(monomerDetail, PlanMonomerDetailDTO.class);
                  BigDecimal bizDeepenMete = BigDecimal.ZERO;
                  if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                     bizDeepenMete = this.productBiz.getDeepenMete(md.getMonomerId(), md.getType()).getMete();
                  }

                  BigDecimal finalBizDeepenMete = bizDeepenMete;
                  List<PlanDetailTraceDTO> detailTraceDTOList = this.planDetailService.listDetailTrace(md.getMonomerId(), md.getType());
                  detailTraceDTOList.forEach(
                     dt -> {
                        if (dt.getType().equals(PlanDetailTypeEnum.DEEPEN_PLAN.getType())) {
                           dt.setMete(md.getMete());
                           dt.setCompletedMete(finalBizDeepenMete);
                        }

                        if (dt.getType().equals(PlanDetailTypeEnum.PROCESSING_PLAN.getType())) {
                           dt.setMete(finalBizDeepenMete);
                           if ((
                                 project.getProjectType().equals(ProjectTypeEnum.MES.getType())
                                    || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
                              )
                              && md.getType().equals(AreaProductTypeEnum.STRUCTURE.getType())) {
                              dt.setCompletedMete(this.buildingCompleteService.getSumStructureCompleteMete(md.getMonomerId(), null));
                           }
                        }

                        if (dt.getType().equals(PlanDetailTypeEnum.INSTALL_PLAN.getType())) {
                           dt.setMete(finalBizDeepenMete);
                           if (project.getProjectType().equals(ProjectTypeEnum.MES.getType())
                              || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                              ProjectInstallMeteSummaryDTO actualMete = this.installBizUtil
                                 .getActualInstallMete(null, md.getMonomerId(), null, ProductTypeEnum.ARTIFACT.getType(), null);
                              dt.setCompletedMete(actualMete.getActualMete().divide(BigDecimal.valueOf(1000L)));
                           }
                        }

                        if (dt.getType().equals(PlanDetailTypeEnum.SHIP_PLAN.getType())) {
                           dt.setMete(finalBizDeepenMete);
                           if (project.getProjectType().equals(ProjectTypeEnum.MES.getType())
                              || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                              BigDecimal shipMete = this.mesBuildingCargoListService.getShipMete(m.getId(), null);
                              dt.setCompletedMete(shipMete.divide(BigDecimal.valueOf(1000L)));
                           }
                        }
                     }
                  );
                  md.setDetailTraceList(detailTraceDTOList);
                  List<PlanAreaDTO> areaDTOList = this.areaService
                     .list(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, md.getMonomerId()).eq(PlanArea::getProductType, md.getType()))
                     .stream()
                     .map(a -> BeanUtil.copy(a, PlanAreaDTO.class))
                     .collect(Collectors.toList());
                  areaDTOList.forEach(
                     a -> {
                        List<PlanDetailDTO> planDetailDTOList = this.planDetailService
                           .list(Wrappers.lambdaQuery(PlanDetail.class).eq(PlanDetail::getAreaId, a.getId()))
                           .stream()
                           .map(pd -> BeanUtil.copy(pd, PlanDetailDTO.class))
                           .sorted(Comparator.comparing(PlanDetailDTO::getType))
                           .collect(Collectors.toList());
                        BigDecimal deepenMete = BigDecimal.ZERO;
                        if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
                           )
                         {
                           deepenMete = this.productBiz.getDeepenMete(a.getId()).getMete();
                        }

                        BigDecimal finalDeepenMete = deepenMete;
                        planDetailDTOList.forEach(
                           pd -> {
                              if (pd.getType().equals(PlanDetailTypeEnum.DEEPEN_PLAN.getType())) {
                                 pd.setCompletedMete(finalDeepenMete);
                              }

                              if (pd.getType().equals(PlanDetailTypeEnum.PROCESSING_PLAN.getType())) {
                                 pd.setMete(finalDeepenMete);
                                 if ((
                                       project.getProjectType().equals(ProjectTypeEnum.MES.getType())
                                          || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())
                                    )
                                    && a.getProductType().equals(AreaProductTypeEnum.STRUCTURE.getType())) {
                                    pd.setCompletedMete(this.buildingCompleteService.getSumStructureCompleteMete(null, a.getId()));
                                 }
                              }

                              if (pd.getType().equals(PlanDetailTypeEnum.INSTALL_PLAN.getType())) {
                                 pd.setMete(finalDeepenMete);
                                 if (project.getProjectType().equals(ProjectTypeEnum.MES.getType())
                                    || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                                    ProjectInstallMeteSummaryDTO actualMete = this.installBizUtil.getActualInstallMete(pd.getAreaId());
                                    pd.setCompletedMete(
                                       a.getProductCategory().equals(ProjectContentCategoryEnum.ENCLOSURE.getType())
                                          ? actualMete.getActualMete()
                                          : actualMete.getActualMete().divide(BigDecimal.valueOf(1000L))
                                    );
                                 }
                              }

                              if (pd.getType().equals(PlanDetailTypeEnum.SHIP_PLAN.getType())) {
                                 pd.setMete(finalDeepenMete);
                                 if (a.getProductCategory().equals(ProjectContentCategoryEnum.STRUCTURE.getType())) {
                                    BigDecimal shipMete = this.mesBuildingCargoListService.getShipMete(m.getId(), a.getId());
                                    pd.setCompletedMete(shipMete.divide(BigDecimal.valueOf(1000L)));
                                 }
                              }
                           }
                        );
                        a.setPlanDetailList(planDetailDTOList);
                     }
                  );
                  md.setAreaList(areaDTOList);
                  monomerDetailDTOList.add(md);
               }
            );
            m.setMonomerDetailList(monomerDetailDTOList);
         }
      );
      return new ListVO<>(monomerDTOList);
   }

   @Override
   public List<ProjectManagePlanMonomerVO> listDetailsByConditionV4(Long projectId, Long monomerId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(cn.hutool.core.bean.BeanUtil.isNotEmpty(project), "项目不存在");
      List<ProjectManagePlanMonomerVO> monomerList = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId).eq(monomerId != null, PlanMonomer::getId, monomerId))
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectManagePlanMonomerVO.class))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(monomerList)) {
         return new ArrayList<>();
      }

      Map<Long, List<ProjectManagePlanAreaVO>> areaByMonomerIdGroup = this.areaService
         .getListByProjectId(projectId)
         .stream()
         .filter(e -> !ProjectPlanProductCategoryEnum.ACCESSORY.getType().equals(e.getProjectPlanProductCategory()))
         .map(e -> BeanUtil.copy(e, ProjectManagePlanAreaVO.class))
         .collect(Collectors.groupingBy(ProjectPlanAreaDTO::getMonomerId));
      monomerList.forEach(monomer -> {
         List<ProjectManagePlanAreaVO> areas = areaByMonomerIdGroup.getOrDefault(monomer.getId(), new ArrayList<>());
         areas.forEach(e -> {
            if (ProjectPlanProductCategoryEnum.ARTIFACT.getType().equals(e.getProjectPlanProductCategory())) {
               BigDecimal deepenMete = this.productBiz.getDeepenMete(e.getId()).getMete();
               BigDecimal produceMete = this.buildingCompleteService.getSumStructureCompleteMete(null, e.getId());
               BigDecimal installMete = this.installBizUtil.getActualInstallMete(e.getId()).getActualMete();
               BigDecimal shippingMete = this.mesBuildingCargoListService.getShipMete(e.getMonomerId(), e.getId());
               e.setDeepenMete(deepenMete == null ? BigDecimal.ZERO : deepenMete);
               e.setProduceMete(produceMete == null ? BigDecimal.ZERO : produceMete);
               e.setInstallMete(installMete == null ? BigDecimal.ZERO : installMete.divide(BigDecimal.valueOf(1000L)));
               e.setShippingMete(shippingMete == null ? BigDecimal.ZERO : shippingMete.divide(BigDecimal.valueOf(1000L)));
            } else if (ProjectPlanProductCategoryEnum.ENCLOSURE.getType().equals(e.getProjectPlanProductCategory())) {
               BigDecimal deepenMete = this.productBiz.getDeepenMeteV2(e.getId()).getMete();
               BigDecimal produceMete = this.buildingCompleteService.getSumEnclosureCompleteMete(Arrays.asList(e.getId()));
               BigDecimal installMete = this.installBizUtil.getActualInstallMete(e.getId()).getActualMete();
               BigDecimal shippingMete = this.mesBuildingCargoListService.getEnclosureShipMete(e.getMonomerId(), e.getId());
               e.setDeepenMete(deepenMete == null ? BigDecimal.ZERO : deepenMete);
               e.setProduceMete(produceMete == null ? BigDecimal.ZERO : produceMete);
               e.setInstallMete(installMete == null ? BigDecimal.ZERO : installMete.divide(BigDecimal.valueOf(1000L)));
               e.setShippingMete(shippingMete == null ? BigDecimal.ZERO : shippingMete);
            }
         });
         monomer.setManageAreaList(areas);
      });
      return monomerList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> areaArtifactDetailsPrint(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域信息不存在！");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(area.getProjectId());
      NameInfo monomer = this.monomerService.getSimpleById(area.getMonomerId());
      header.put("project", project);
      header.put("area", BeanUtil.copy(area, AreaDTO.class));
      header.put("monomer", monomer);
      printVO.setHeader(header);
      List<ArtifactResponseDTO> list = this.artifactService
         .listByCondition(area.getProjectId(), area.getMonomerId(), areaId, null, null, null, null, null, null, null, null, null, null);
      Integer totalQuantity = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(ArtifactResponseDTO::getQuantity).filter(Objects::nonNull).reduce(0, Integer::sum))
         .orElse(0);
      header.put("totalQuantity", totalQuantity);
      BigDecimal totalNetWeight = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(ArtifactResponseDTO::getTotalNetWeight).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
         .orElse(BigDecimal.ZERO);
      header.put("totalNetWeight", totalNetWeight);
      List<Map<String, Object>> mapList = list.stream()
         .sorted((a1, a2) -> Comparator.nullsFirst(Long::compare).compare(a1.getId(), a2.getId()))
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<ProjectProductDTO> getAreaArtifactOneCodeCompleteDetails(Long areaId, Long processId, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectProductDTO> detailsList = this.buildingCompleteService.getAreaArtifactOneCodeCompleteDetails(areaId, processId);
      return new PageVO<>(page, detailsList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> areaArtifactOneCodeCompleteDetailsPrint(Long areaId, Long processId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域信息不存在！");
      Map<Long, String> processNameMap = this.getAreaArtifactOneCodeCompleteProcessList(areaId)
         .stream()
         .collect(Collectors.toMap(NameInfo::getId, NameInfo::getName));
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(area.getProjectId());
      NameInfo monomer = this.monomerService.getSimpleById(area.getMonomerId());
      header.put("project", project);
      header.put("area", BeanUtil.copy(area, AreaDTO.class));
      header.put("monomer", monomer);
      header.put("processName", processId.equals(0L) ? "已入库" : processNameMap.getOrDefault(processId, ""));
      List<ProjectProductDTO> list = this.buildingCompleteService.getAreaArtifactOneCodeCompleteDetails(areaId, processId);
      Integer totalActualQuantity = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(ProjectProductDTO::getActualQuantity).filter(Objects::nonNull).reduce(0, Integer::sum))
         .orElse(0);
      header.put("totalActualQuantity", totalActualQuantity);
      List<Map<String, Object>> mapList = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ArtifactSumDTO getAreaArtifactOneCodeCompleteSummary(Long areaId, Long processId) {
      return this.buildingCompleteService.listOneCodeByConditionsSummary(areaId, processId);
   }

   @Override
   public List<NameInfo> getAreaArtifactOneCodeCompleteProcessList(Long areaId) {
      List<MesBuildingProcessDTO> processDTOList = this.buildingCompleteService.listOneCodeByConditionsProcessList(areaId);
      return processDTOList.stream()
         .map(e -> BeanUtil.copy(e, NameInfo.class))
         .sorted(Comparator.comparing(NameInfo::getId).reversed())
         .collect(Collectors.toList());
   }

   @Override
   public List<NameInfo> getEnclosureCompleteProcessList(Long areaId) {
      return this.enclosureTaskService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getAreaId, areaId).apply("task_quantity - complete_quantity > 0"))
         .stream()
         .map(MesEnclosureTask::getProcessId)
         .distinct()
         .map(e -> {
            MesEnclosureProcess byId = this.enclosureProcessService.getById(e);
            return NameInfo.builder().id(byId.getId()).name(byId.getName()).build();
         })
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectProductDTO> getEnclosureCompleteDetails(Long areaId, Long processId, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectProductDTO> detailsList = this.getEnclosureCompleteDetailList(areaId, processId);
      return new PageVO<>(page, detailsList);
   }

   private List<ProjectProductDTO> getEnclosureCompleteDetailList(Long areaId, Long processId) {
      List<ProjectProductDTO> detailsList;
      if (processId == 0L) {
         detailsList = this.buildingCompleteService.getEnclosureCompleteDetails(areaId);
      } else {
         detailsList = this.enclosureTaskService.getEnclosureTaskDetails(areaId, processId);
      }

      this.fillSpecifications(detailsList);
      return detailsList;
   }

   @Override
   public ArtifactSumDTO getEnclosureCompleteSummary(Long areaId, Long processId) {
      List<ProjectProductDTO> enclosureCompleteDetailList = this.getEnclosureCompleteDetailList(areaId, processId);
      ArtifactSumDTO dto = ArtifactSumDTO.builder()
         .quantity(0)
         .totalGrossWeight(BigDecimal.ZERO)
         .totalNetWeight(BigDecimal.ZERO)
         .totalLength(BigDecimal.ZERO)
         .build();
      enclosureCompleteDetailList.forEach(e -> {
         dto.setQuantity(dto.getQuantity() + e.getActualQuantity());
         dto.setTotalLength(dto.getTotalLength().add(e.getTotalLength()));
      });
      return dto;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getEnclosureCompleteDetailsPrint(Long areaId, Long processId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域信息不存在！");
      Map<Long, String> processNameMap = this.getEnclosureCompleteProcessList(areaId).stream().collect(Collectors.toMap(NameInfo::getId, NameInfo::getName));
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(area.getProjectId());
      NameInfo monomer = this.monomerService.getSimpleById(area.getMonomerId());
      header.put("project", project);
      header.put("area", BeanUtil.copy(area, AreaDTO.class));
      header.put("monomer", monomer);
      header.put("processName", processId.equals(0L) ? "已入库" : processNameMap.getOrDefault(processId, ""));
      List<ProjectProductDTO> list = this.getEnclosureCompleteDetailList(areaId, processId);
      Integer totalActualQuantity = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(ProjectProductDTO::getActualQuantity).filter(Objects::nonNull).reduce(0, Integer::sum))
         .orElse(0);
      header.put("totalActualQuantity", totalActualQuantity);
      List<Map<String, Object>> mapList = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> areaEnclosureDetailsPrint(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域信息不存在！");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(area.getProjectId());
      NameInfo monomer = this.monomerService.getSimpleById(area.getMonomerId());
      header.put("project", project);
      header.put("area", BeanUtil.copy(area, AreaDTO.class));
      header.put("monomer", monomer);
      printVO.setHeader(header);
      EnclosureListQueryDTOParam param = new EnclosureListQueryDTOParam();
      param.setAreaId(areaId);
      List<EnclosureResponseDTO> list = this.enclosureBiz.enclosureListV2(param);
      Integer totalQuantity = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(EnclosureResponseDTO::getQuantity).filter(Objects::nonNull).reduce(0, Integer::sum))
         .orElse(0);
      header.put("totalQuantity", totalQuantity);
      BigDecimal totalLength = Optional.ofNullable(list)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(EnclosureResponseDTO::getTotalLength).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
         .orElse(BigDecimal.ZERO);
      header.put("totalLength", totalLength);
      List<Map<String, Object>> mapList = list.stream()
         .sorted((a1, a2) -> Comparator.nullsFirst(Long::compare).compare(a1.getId(), a2.getId()))
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   private void fillSpecifications(List<ProjectProductDTO> detailsList) {
      for (ProjectProductDTO projectProductDTO : detailsList) {
         BigDecimal thickness = projectProductDTO.getThickness() != null ? projectProductDTO.getThickness() : BigDecimal.ZERO;
         BigDecimal weight = projectProductDTO.getUnfoldedWidth() != null ? projectProductDTO.getUnfoldedWidth() : BigDecimal.ZERO;
         BigDecimal length = projectProductDTO.getLength() != null ? projectProductDTO.getLength() : BigDecimal.ZERO;
         projectProductDTO.setSpecification(
            thickness.stripTrailingZeros().toPlainString()
               + "*"
               + weight.stripTrailingZeros().toPlainString()
               + "*"
               + length.stripTrailingZeros().toPlainString()
         );
         projectProductDTO.setTotalLength(projectProductDTO.getLength().multiply(BigDecimal.valueOf(projectProductDTO.getActualQuantity().intValue())));
      }
   }
}
