package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.SpringUtil;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.PlanAreaBiz;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.ItemizedTypeEnum;
import com.hzchum.scim.plan.core.api.enums.LumpSumSystemEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.manager.ProjectLevelManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailTraceDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanAreaBizImpl implements PlanAreaBiz {
   private static final Logger log = LoggerFactory.getLogger(PlanAreaBizImpl.class);
   private final PlanDetailService planDetailService;
   private final PlanMonomerService monomerService;
   private final ContractProjectService projectService;
   private final PlanAreaService areaService;
   private final ContractProjectContentService contractProjectContentService;
   private final InboundDetailService wmsInboundDetailService;
   private final MoveOutboundDetailService moveOutboundDetailService;
   private final TechArtifactService artifactService;
   private final TransferService transferService;
   private final BimModelCommonService bimModelCommonService;
   private final MesTechInventoryOperationService mesTechInventoryOperationService;
   private final TechStandardPartService standardPartService;
   private final SysPushFlowConfigBiz sysPushFlowConfigBiz;
   private final NotificationTemplateDetailsUtils detailsUtils;
   private final ProjectLevelManager projectLevelManager;
   private final PlanAreaBatchService areaBatchService;
   @Autowired
   private TechEnclosureService enclosureService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveArea(AreaSaveDTOParam requestVO) {
      Long monomerId = requestVO.getMonomerId();
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在,无法添加区域");
      ContractProject project = this.projectService.checkProjectStatus(monomer.getProjectId());
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())
         && !monomer.getLumpSumSystemType().equals(LumpSumSystemEnum.NO_FACTORY_PROCESSING_NO_CONTROL.getType())) {
         Preconditions.checkArgument(!requestVO.getEndDate().isAfter(monomer.getEndDate()), "区域完成日期不能超过单体日期");
      }

      int count = this.areaService
         .count(
            (Wrapper<PlanArea>)((new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, monomerId))
                  .eq(PlanArea::getName, requestVO.getName()))
               .eq(PlanArea::getItemizedType, requestVO.getItemizedType())
         );
      Preconditions.checkArgument(count == 0, "该区域名称已存在!");
      PlanArea area = BeanUtil.copy(requestVO, PlanArea.class);
      Preconditions.checkArgument(area.getItemizedType() != null, area.getName() + "区域分项类型不可为空!");
      if (area.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType())) {
         area.setProductType(AreaProductTypeEnum.STRUCTURE.getType());
         area.setProductCategory(ProjectContentCategoryEnum.STRUCTURE.getType());
         area.setDate(requestVO.getProcessEndDate());
      }

      if (area.getItemizedType().equals(ItemizedTypeEnum.ENCLOSURE.getType())) {
         area.setProductType(
            AreaProductTypeEnum.PRESSURE_PLATE.getType()
               | AreaProductTypeEnum.SANDWICH_BOARD.getType()
               | AreaProductTypeEnum.TRUSS_FLOOR_PLATE.getType()
               | AreaProductTypeEnum.PRESSURE_FLOOR_PLATE.getType()
               | AreaProductTypeEnum.EDGEFOLD.getType()
         );
         area.setProductCategory(ProjectContentCategoryEnum.ENCLOSURE.getType());
      }

      area.setProjectId(monomer.getProjectId());
      area.setUserId(UserUtil.getCurrentUserId());
      SpringUtil.getBean(PlanAreaService.class).saveAreaWithCache(area);

      try {
         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(area.getProjectId())
                  .monomerId(area.getMonomerId())
                  .areaId(area.getId())
                  .notificationTypeEnum(NotificationModuleTypeEnum.CREATE_MONOMER_AREA.getNotificationType())
                  .userList(new ArrayList<>())
                  .dataId(area.getId())
                  .createUserId(UserUtil.getCurrentUserId())
                  .contentDetails(
                     this.detailsUtils.getMonomerAreaTemplateDetails(project.getSerialNumber(), project.getShortName(), monomer.getName(), area.getName())
                  )
                  .build()
            );
      } catch (Exception e) {
         e.printStackTrace();
      }

      this.projectLevelManager.saveAreaByType(project.getId(), area.getType());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateArea(AreaUpdateDTOParam param) {
      PlanArea area = this.areaService.getById(param.getId());
      Preconditions.checkArgument(area != null, "区域不存在!");
      ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
      if (!param.getName().equals(area.getName()) || !param.getProductType().equals(area.getProductType())) {
         int count = this.areaService
            .count(Wrappers.lambdaQuery(PlanArea.builder().monomerId(area.getMonomerId()).name(param.getName()).productType(param.getProductType()).build()));
         Preconditions.checkArgument(count == 0, "该产品类型内,区域名称已存在!");
      }

      PlanMonomer monomer = this.monomerService.getById(area.getMonomerId());
      Preconditions.checkArgument(!param.getDate().isAfter(monomer.getEndDate()), "区域的完成日期不能超过单体完成日期");
      PlanDetailTraceDTO maxMinDate = this.planDetailService.getMaxMInDate(null, null, param.getId(), null);
      if (maxMinDate != null) {
         Preconditions.checkArgument(maxMinDate.getEndDate() == null || !param.getDate().isBefore(maxMinDate.getEndDate()), "区域完成时间不能早于具体计划完成时间");
         Preconditions.checkArgument(maxMinDate.getStartDate() == null || !param.getDate().isBefore(maxMinDate.getStartDate()), "区域完成时间不能早于具体计划完成时间");
      }

      if (!param.getProductType().equals(area.getProductType()) || !param.getType().equals(area.getType())) {
         int count = 0;
         if (area.getProductCategory().equals(ProjectContentCategoryEnum.STRUCTURE.getType())) {
            count = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaId(param.getId()).build()));
         }

         Preconditions.checkArgument(count == 0, "该区域已导入清单!");
      }

      ContractProjectContent projectContent = this.contractProjectContentService
         .getOne((Wrapper<ContractProjectContent>)new LambdaQueryWrapper<ContractProjectContent>().eq(ContractProjectContent::getNo, param.getProductType()));
      if (!param.getProductType().equals(area.getProductType())) {
         List<PlanDetail> planDetailList = this.planDetailService.list(Wrappers.lambdaQuery(PlanDetail.class).eq(PlanDetail::getAreaId, param.getId()));
         planDetailList.forEach(detail -> {
            detail.setAreaProductType(param.getProductType());
            detail.setProductCategory(projectContent.getCategoryType());
            this.planDetailService.updateById(detail);
         });
      }

      this.projectLevelManager.updateAreaByType(project.getId(), area.getId(), area.getType(), param.getType());
      BeanUtil.copy(param, area);
      area.setProductCategory(projectContent.getCategoryType());
      SpringUtil.getBean(PlanAreaService.class).updateAreaWithCache(area);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteAreas(List<Long> ids) {
      this.projectLevelManager.removeAreaByIds(ids);
      ids.forEach(
         id -> {
            PlanArea area = this.areaService.getById(id);
            Preconditions.checkArgument(area != null, "区域不存在!");
            ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
            if (area.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType())) {
               List<TechArtifact> techArtifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getAreaId, id));
               Preconditions.checkArgument(CollectionUtils.isEmpty(techArtifactList), "删除失败,该区域已导入清单!");
               List<MesTechInventoryOperation> inventoryOperationList = this.mesTechInventoryOperationService
                  .list((Wrapper<MesTechInventoryOperation>)new LambdaQueryWrapper<MesTechInventoryOperation>().eq(MesTechInventoryOperation::getAreaId, id));
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
            }

            if (area.getItemizedType().equals(ItemizedTypeEnum.OTHER.getType())) {
               List<TechStandardPart> standardParts = this.standardPartService
                  .list(Wrappers.lambdaQuery(TechStandardPart.class).eq(TechStandardPart::getAreaId, id));
               Preconditions.checkArgument(CollectionUtils.isEmpty(standardParts), "删除失败,该区域已导入清单!");
            }

            if (area.getProjectPlanProductCategory().equals(ProjectPlanProductCategoryEnum.ENCLOSURE.getType())) {
               int count = this.enclosureService.count(Wrappers.lambdaQuery(TechEnclosure.builder().areaId(id).build()));
               Preconditions.checkArgument(count == 0, "删除失败,该围护区域已导入清单!");
            }

            this.planDetailService.remove(Wrappers.lambdaQuery(PlanDetail.class).eq(PlanDetail::getAreaId, id));
            SpringUtil.getBean(PlanAreaService.class).deleteAreaWithCache(id);
            this.bimModelCommonService.delete(area.getMonomerId(), area.getId());
         }
      );
      List<PlanAreaBatch> areaBatchList = this.areaBatchService.list((Wrapper<PlanAreaBatch>)new LambdaQueryWrapper<PlanAreaBatch>().in(PlanAreaBatch::getAreaId, ids));
      if (CollectionUtils.isNotEmpty(areaBatchList)) {
         this.areaBatchService.removeByIds(areaBatchList.stream().map(PlanAreaBatch::getId).collect(Collectors.toList()));
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean exportArea(Long monomerId, HttpServletResponse response) throws IOException {
      HashMap<String, Object> structureMap = new HashMap<>();
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "导出失败，单体不存在！");
      ContractProject project = this.projectService.getById(monomer.getProjectId());
      structureMap.put("projectName", project.getName());
      structureMap.put("monomerName", monomer.getName());
      String resourcePath = "template/AreaExportTemplate.xlsx";
      String tempFileName = "AreaExportTemplate";
      String exportFileName = "计划制定表.xlsx";
      List<PlanArea> planAreaList = this.areaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, monomerId));
      this.setArea(planAreaList, structureMap);
      Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = resource.getInputStream();
      File file = File.createTempFile(tempFileName, ".xlsx");
      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams();
      params.setScanAllsheet(Boolean.TRUE);
      params.setTemplateUrl(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, structureMap);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   private void setArea(List<PlanArea> Areas, HashMap<String, Object> structureMap) {
      List<Map<String, Object>> structureList = new ArrayList<>();
      List<Map<String, Object>> sandwichBoardList = new ArrayList<>();
      List<Map<String, Object>> pressurePlateList = new ArrayList<>();
      List<Map<String, Object>> edgefoldList = new ArrayList<>();
      List<Map<String, Object>> pressureFloorPlateList = new ArrayList<>();
      List<Map<String, Object>> trussFloorPlateList = new ArrayList<>();

      for (PlanArea Area : Areas) {
         HashMap<String, Object> areaMap = new HashMap<>(16);
         areaMap.put("name", Area.getName());
         areaMap.put("type", Area.getType() == 0 ? "自制" : "外包");
         areaMap.put("remark", Area.getRemark());
         if (Area.getProductType().equals(AreaProductTypeEnum.STRUCTURE.getType())) {
            areaMap.put("id", structureList.size() + 1);
            structureList.add(areaMap);
         }

         if (Area.getProductType().equals(AreaProductTypeEnum.SANDWICH_BOARD.getType())) {
            areaMap.put("id", sandwichBoardList.size() + 1);
            sandwichBoardList.add(areaMap);
         }

         if (Area.getProductType().equals(AreaProductTypeEnum.PRESSURE_PLATE.getType())) {
            areaMap.put("id", pressurePlateList.size() + 1);
            pressurePlateList.add(areaMap);
         }

         if (Area.getProductType().equals(AreaProductTypeEnum.EDGEFOLD.getType())) {
            areaMap.put("id", edgefoldList.size() + 1);
            edgefoldList.add(areaMap);
         }

         if (Area.getProductType().equals(AreaProductTypeEnum.PRESSURE_FLOOR_PLATE.getType())) {
            areaMap.put("id", pressureFloorPlateList.size() + 1);
            pressureFloorPlateList.add(areaMap);
         }

         if (Area.getProductType().equals(AreaProductTypeEnum.TRUSS_FLOOR_PLATE.getType())) {
            areaMap.put("id", trussFloorPlateList.size() + 1);
            trussFloorPlateList.add(areaMap);
         }
      }

      structureMap.put("structureList", structureList);
      structureMap.put("sandwichBoardList", sandwichBoardList);
      structureMap.put("pressurePlateList", pressurePlateList);
      structureMap.put("edgefoldList", edgefoldList);
      structureMap.put("pressureFloorPlateList", pressureFloorPlateList);
      structureMap.put("trussFloorPlateList", trussFloorPlateList);
   }

   @Override
   public PrintVO printArea(Long monomerId, Integer productType) {
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "导出失败，单体不存在！");
      ProjectInfo projectInfo = this.projectService.getSimpleById(monomer.getProjectId());
      PrintVO<List<Map<String, Object>>> print = new PrintVO<>();
      Map<String, Object> header = print.initHeader(UserUtil.getCurrentName());
      header.put("project", projectInfo);
      header.put("monomer", monomer.getName());
      header.put("type", productType);
      print.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      List<PlanArea> Areas = this.areaService
         .list(
            (Wrapper<PlanArea>)(new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, monomerId)).eq(PlanArea::getProductType, productType)
         );
      Areas.forEach(d -> {
         Map<String, Object> areaMap = new HashMap<>(16);
         areaMap.put("name", d.getName());
         areaMap.put("manufactureType", d.getType());
         areaMap.put("remark", d.getRemark());
         table.add(areaMap);
      });
      print.setTable(table);
      return print;
   }

   @Override
   public List<Map<String, Object>> listProjectTree(List<Long> projectIds) {
      LambdaQueryWrapper<ContractProject> wrapper = (LambdaQueryWrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>()
         .in(CollectionUtils.isNotEmpty(projectIds), ContractProject::getId, projectIds);
      List<ContractProject> projectList = this.projectService.list(wrapper);
      if (projectList.isEmpty()) {
         return new ArrayList<>();
      }

      List<Map<String, Object>> projectMapList = new ArrayList<>();
      projectList.forEach(
         project -> {
            Map<String, Object> projectMap = new LinkedHashMap<>();
            projectMap.put("id", project.getId());
            projectMap.put("name", project.getName());
            List<PlanMonomer> monomerList = this.monomerService
               .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, project.getId()));
            List<Map<String, Object>> monomerMapList = new ArrayList<>();
            if (!monomerList.isEmpty()) {
               monomerList.forEach(monomer -> {
                  Map<String, Object> mMap = new LinkedHashMap<>();
                  mMap.put("id", monomer.getId());
                  mMap.put("name", monomer.getName());
                  List<PlanArea> AreaList = this.areaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, monomer.getId()));
                  List<Map<String, Object>> AreaMapList = new ArrayList<>();
                  if (CollectionUtils.isNotEmpty(AreaList)) {
                     AreaList.forEach(d -> {
                        Map<String, Object> AreaMap = new LinkedHashMap<>();
                        AreaMap.put("id", d.getId());
                        AreaMap.put("name", d.getName());
                        AreaMap.put("type", d.getType().equals(AreaProductTypeEnum.STRUCTURE.getType()) ? 1 : 2);
                        AreaMapList.add(AreaMap);
                     });
                  }

                  mMap.put("children", AreaMapList);
                  monomerMapList.add(mMap);
               });
            }

            projectMap.put("children", monomerMapList);
            projectMapList.add(projectMap);
         }
      );
      return projectMapList;
   }

   public PlanAreaBizImpl(
      final PlanDetailService planDetailService,
      final PlanMonomerService monomerService,
      final ContractProjectService projectService,
      final PlanAreaService areaService,
      final ContractProjectContentService contractProjectContentService,
      final InboundDetailService wmsInboundDetailService,
      final MoveOutboundDetailService moveOutboundDetailService,
      final TechArtifactService artifactService,
      final TransferService transferService,
      final BimModelCommonService bimModelCommonService,
      final MesTechInventoryOperationService mesTechInventoryOperationService,
      final TechStandardPartService standardPartService,
      final SysPushFlowConfigBiz sysPushFlowConfigBiz,
      final NotificationTemplateDetailsUtils detailsUtils,
      final ProjectLevelManager projectLevelManager,
      final PlanAreaBatchService areaBatchService
   ) {
      this.planDetailService = planDetailService;
      this.monomerService = monomerService;
      this.projectService = projectService;
      this.areaService = areaService;
      this.contractProjectContentService = contractProjectContentService;
      this.wmsInboundDetailService = wmsInboundDetailService;
      this.moveOutboundDetailService = moveOutboundDetailService;
      this.artifactService = artifactService;
      this.transferService = transferService;
      this.bimModelCommonService = bimModelCommonService;
      this.mesTechInventoryOperationService = mesTechInventoryOperationService;
      this.standardPartService = standardPartService;
      this.sysPushFlowConfigBiz = sysPushFlowConfigBiz;
      this.detailsUtils = detailsUtils;
      this.projectLevelManager = projectLevelManager;
      this.areaBatchService = areaBatchService;
   }
}
