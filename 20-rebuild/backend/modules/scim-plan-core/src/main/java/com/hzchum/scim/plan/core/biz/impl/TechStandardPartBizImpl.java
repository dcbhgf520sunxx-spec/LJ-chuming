package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartAddDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageBiz;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.TechStandardPartBiz;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.enums.ItemizedTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSAcceptanceDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.StandardPartImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartUpdateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.StandardPartSaveVoParam;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.mapper.TechStandardPartMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.KitWmsCommonConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysKitWmsCommonConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryService;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysKitWmsCommonConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(rollbackFor = Exception.class)
public class TechStandardPartBizImpl extends IBizImpl<TechStandardPartService, TechStandardPartMapper, TechStandardPart> implements TechStandardPartBiz {
   private static final Logger log = LoggerFactory.getLogger(TechStandardPartBizImpl.class);
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final BusinessStandardPartService businessStandardPartService;
   private final WarehouseBiz warehouseBiz;
   private final MesBuildingWarehouseSummaryService summaryService;
   private final MesBuildingWarehouseRecordService recordService;
   private final MesBuildingPackageBiz packageBiz;
   private final MesBuildingPackageLinkService packageLinkService;
   private final UserService userService;
   private final EnclosurePlanService enclosurePlanService;
   private final BusinessPriceTempService businessPriceTempService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final BusinessCheckDetailService businessCheckDetailService;
   private final MonomerUserLinkService monomerUserLinkService;
   private final MesBuildingCargoListProductLinkService cargoListProductLinkService;
   private final SysDictionaryService dictionaryService;
   private final SysKitWmsCommonConfigService kitWmsCommonConfigService;
   private final MesAuxiliaryService mesAuxiliaryService;
   private final MesBuildingWarehouseSummaryService warehouseSummaryService;
   private static final List<String> WEIGHT_UNIT_LIST = Arrays.asList("KG", "千克", "吨", "t");

   @Override
   public PageVO<TechStandardPartDTO> pageListByCondition(TechStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize, Integer permissionCheck) {
      if (UserUtil.getCurrentUser().isAdmin() || param.getMonomerId() == null) {
         permissionCheck = null;
      }

      if (permissionCheck != null && param.getMonomerId() != null) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(
               Wrappers.lambdaQuery(MonomerUserLink.class)
                  .eq(MonomerUserLink::getMonomerId, param.getMonomerId())
                  .eq(MonomerUserLink::getDeepenedPersonId, UserUtil.getCurrentUser().getId())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(monomerUserLinkList), "您没有查看此清单的权限!");
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<TechStandardPart> standardPartList = this.baseService.listByCondition(param, permissionCheck, UserUtil.getCurrentUser().getId());
      List<TechStandardPartDTO> standardPartDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(standardPartList)) {
         List<Long> projectIds = standardPartList.stream().map(TechStandardPart::getProjectId).collect(Collectors.toList());
         List<Long> monomerIds = standardPartList.stream().map(TechStandardPart::getMonomerId).collect(Collectors.toList());
         List<Long> areaIds = standardPartList.stream().map(TechStandardPart::getAreaId).collect(Collectors.toList());
         Set<Long> userIds = standardPartList.stream().map(TechStandardPart::getUserId).collect(Collectors.toSet());
         Map<Long, ProjectInfo> projectMap = this.projectService
            .listSimpleByIdList(projectIds)
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         Map<Long, NameInfo> monomerMap = this.monomerService.listNameInfo(monomerIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         Map<Long, NameInfo> areaMap = this.areaService.listSimpleByIds(areaIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
         List<MesBuildingWarehouseSummary> summary = this.warehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                        .in(MesBuildingWarehouseSummary::getAreaId, areaMap.keySet()))
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
            );
         Map<Long, MesBuildingWarehouseSummary> summaryMap = summary.stream().collect(Collectors.toMap(e -> e.getProductId(), Function.identity()));
         standardPartDTOList = standardPartList.stream().map(s -> {
            TechStandardPartDTO standardPartDTO = BeanUtil.copy(s, TechStandardPartDTO.class);
            standardPartDTO.setMete(s.getMete().setScale(3, RoundingMode.HALF_UP));
            standardPartDTO.setProject(projectMap.get(s.getProjectId()));
            standardPartDTO.setMonomer(monomerMap.get(s.getMonomerId()));
            standardPartDTO.setArea(areaMap.get(s.getAreaId()));
            standardPartDTO.setUserName(userMap.get(s.getUserId()));
            standardPartDTO.setBoolInbound(summaryMap.get(s.getId()) == null ? s.getOriginalId() != null : true);
            return standardPartDTO;
         }).collect(Collectors.toList());
      }

      return new PageVO<>(page, standardPartDTOList);
   }

   @Override
   public boolean findStandPartWmsLink(Long projectId) {
      return this.checkWmsLink(projectId);
   }

   @Override
   public PageVO<TechStandardPartWMSDTO> findWmsCargoAcceptance(TechStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      boolean wmsLink = this.checkWmsLink(param.getProjectId());
      if (!wmsLink) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      param.setConfigStatus(Boolean.TRUE);
      List<TechStandardPart> standardPartList = this.baseService.listByCondition(param, null, UserUtil.getCurrentUserId());
      if (CollectionUtils.isEmpty(standardPartList)) {
         return new PageVO<>();
      }

      standardPartList = standardPartList.stream().filter(e -> e.getBoolWmsLink().equals(wmsLink)).collect(Collectors.toList());
      Map<Long, TechStandardPart> splitPartMap = standardPartList.stream()
         .filter(e -> e.getOriginalId() != null)
         .collect(Collectors.toMap(e -> e.getOriginalId(), Function.identity()));
      standardPartList = standardPartList.stream().filter(e -> e.getOriginalId() == null).collect(Collectors.toList());
      List<TechStandardPartWMSDTO> standardPartDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(standardPartList)) {
         List<Long> projectIds = standardPartList.stream().map(TechStandardPart::getProjectId).collect(Collectors.toList());
         List<Long> monomerIds = standardPartList.stream().map(TechStandardPart::getMonomerId).collect(Collectors.toList());
         List<Long> areaIds = standardPartList.stream().map(TechStandardPart::getAreaId).collect(Collectors.toList());
         Set<Long> userIds = standardPartList.stream().map(TechStandardPart::getUserId).collect(Collectors.toSet());
         Map<Long, ProjectInfo> projectMap = this.projectService
            .listSimpleByIdList(projectIds)
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         Map<Long, NameInfo> monomerMap = this.monomerService.listNameInfo(monomerIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         Map<Long, NameInfo> areaMap = this.areaService.listSimpleByIds(areaIds).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
         standardPartDTOList = standardPartList.stream().map(s -> {
            TechStandardPartWMSDTO standardPartDTO = BeanUtil.copy(s, TechStandardPartWMSDTO.class);
            standardPartDTO.setMete(s.getMete().setScale(3, RoundingMode.HALF_UP));
            standardPartDTO.setProject(projectMap.get(s.getProjectId()));
            standardPartDTO.setMonomer(monomerMap.get(s.getMonomerId()));
            standardPartDTO.setArea(areaMap.get(s.getAreaId()));
            standardPartDTO.setUserName(userMap.get(s.getUserId()));
            BigDecimal inMete = splitPartMap.get(s.getId()) == null ? BigDecimal.ZERO : splitPartMap.get(s.getId()).getMete();
            standardPartDTO.setTotalCargoNetweight(inMete);
            standardPartDTO.setBoolInbound(inMete.compareTo(BigDecimal.ZERO) == 0 ? 0 : 1);
            return standardPartDTO;
         }).collect(Collectors.toList());
      }

      return new PageVO<>(PageUtils.getPageInfo(standardPartDTOList, standardPartList));
   }

   @Override
   public List<TechStandardPartWMSAcceptanceDTO> findWmsAcceptanceList(List<Long> ids) {
      List<TechStandardPart> standardPartList = this.baseService.listByIds(ids);
      Map<Long, TechStandardPart> splitPartMap = this.baseService
         .list(
            Wrappers.lambdaQuery(TechStandardPart.class)
               .eq(TechStandardPart::getConfigStatus, Boolean.TRUE)
               .in(TechStandardPart::getOriginalId, standardPartList.stream().map(e -> e.getId()).collect(Collectors.toList()))
         )
         .stream()
         .filter(e -> e.getOriginalId() != null)
         .collect(Collectors.toMap(e -> e.getOriginalId(), Function.identity()));
      if (CollectionUtils.isEmpty(standardPartList)) {
         return Collections.emptyList();
      }

      List<TechStandardPartWMSAcceptanceDTO> standardPartDTOList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(standardPartList)) {
         standardPartDTOList = standardPartList.stream().map(s -> {
            TechStandardPartWMSAcceptanceDTO standardPartDTO = BeanUtil.copy(s, TechStandardPartWMSAcceptanceDTO.class);
            standardPartDTO.setMete(s.getMete().setScale(3, RoundingMode.HALF_UP));
            return standardPartDTO;
         }).collect(Collectors.toList());
         Map<String, MesAuxiliary> auxiliaryMap = this.mesAuxiliaryService.list().stream().flatMap(auxiliary -> {
            String[] names = auxiliary.getAuxiliaryName().split(",");
            return Arrays.stream(names).map(name -> new SimpleEntry<>(name.trim() + "_" + auxiliary.getAccountingUnit(), auxiliary));
         }).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         standardPartDTOList.forEach(
            e -> {
               BigDecimal inMete = splitPartMap.get(e.getId()) == null ? BigDecimal.ZERO : splitPartMap.get(e.getId()).getMete();
               e.setOutboundWeight(inMete);
               BigDecimal totalMete = e.getMete().add(inMete);
               e.setCanOutWarehouseWeight(totalMete.subtract(inMete));
               MesAuxiliary auxiliary = auxiliaryMap.get(e.getName() + "_" + e.getAccountingUnit());
               if (auxiliary != null) {
                  BigDecimal decimal = auxiliary.getMeteDiff() == null
                     ? BigDecimal.ZERO
                     : auxiliary.getMeteDiff().divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
                  e.setActualCanOutWarehouseWeight(totalMete.add(totalMete.multiply(decimal)).subtract(inMete));
               }
            }
         );
      }

      return standardPartDTOList;
   }

   @Override
   public Boolean exportStandardPartList(TechStandardPartQueryDtoParam dtoParam, HttpServletResponse response) {
      List<TechStandardPart> standardPartList = this.baseService.listByCondition(dtoParam, null, UserUtil.getCurrentUserId());
      ContractProject project = this.projectService.getById(dtoParam.getProjectId());
      List<TechStandardPartDTO> standardPartDTOList = Collections.emptyList();
      if (!CollectionUtils.isNotEmpty(standardPartList)) {
         Preconditions.checkArgument(false, "没有数据可以导出!");
         return Boolean.FALSE;
      }

      Set<Long> userIds = standardPartList.stream().map(TechStandardPart::getUserId).collect(Collectors.toSet());
      Map<Long, String> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
      standardPartDTOList = standardPartList.stream().map(s -> {
         TechStandardPartDTO standardPartDTO = BeanUtil.copy(s, TechStandardPartDTO.class);
         standardPartDTO.setMete(s.getMete().setScale(3, RoundingMode.HALF_UP));
         standardPartDTO.setUserName(userMap.get(s.getUserId()));
         return standardPartDTO;
      }).collect(Collectors.toList());
      Map<String, Object> result = new HashMap<>();
      ArrayList<Map<String, Object>> objects = new ArrayList<>();
      if (project.getProjectType() == ProjectTypeEnum.MES.getType() || project.getProjectType() == ProjectTypeEnum.BRIDGE.getType()) {
         Preconditions.checkArgument(dtoParam.getMonomerId() != null && dtoParam.getAreaId() != null, "单体和区域id不能为空!");
         PlanArea areaServiceById = this.areaService.getById(dtoParam.getAreaId());
         Preconditions.checkArgument(areaServiceById != null, "区域不存在!");
         result.put("areaProductTypeName", project.getName() + areaServiceById.getName());
      } else if (project.getProjectType() == ProjectTypeEnum.ENCLOSURE.getType()) {
         Long enclosurePlanId = dtoParam.getEnclosurePlanId();
         EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(enclosurePlanId);
         if (enclosurePlan == null) {
            result.put("areaProductTypeName", project.getName() + "全部计划");
         } else {
            result.put("areaProductTypeName", project.getName() + enclosurePlan.getName());
         }
      } else {
         Preconditions.checkArgument(false, "项目类型错误!");
      }

      Preconditions.checkArgument(CollUtil.isNotEmpty(standardPartDTOList), "没有数据可以导出!");
      int number = 1;

      for (TechStandardPartDTO s : standardPartDTOList) {
         Map<String, Object> results = new HashMap<>();
         results.put("number", number);
         results.put("name", s.getName() != null ? s.getName() : "");
         results.put("specification", s.getSpecification());
         results.put("measureUnit", s.getMeasureUnit());
         results.put("quantity", s.getQuantity());
         results.put("accountingUnit", s.getAccountingUnit());
         results.put("mete", s.getMete());
         results.put("projectName", s.getUseProperty() == null ? null : (s.getUseProperty() == 1 ? "工地使用" : "工厂使用"));
         results.put("remark", s.getRemark() == null ? "-" : s.getRemark());
         results.put("username", s.getUserName());
         results.put("createtime", DateUtil.format(s.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
         objects.add(results);
         number++;
      }

      result.put("result", objects);
      String tempFileName = "StandardAllPartTemplate";
      String resourcePath = "template/StandardAllPartTemplate.xlsx";
      String exportFileName = "配套件清单.xlsx";
      Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   @Override
   public void exportStandardPartTemplate(HttpServletResponse response) {
      String resourcePath = "template/StandardPartTemplate.xlsx";
      String exportFileName = "标准件模版.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         log.error("文件下载异常，请联系管理员, {}", e.getMessage());
      }

      FileUtil.downloadFile(file, exportFileName);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void importStandardPart(MultipartFile file, TechStandardPartImportDtoParam param, HttpServletResponse response) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(16);
      List<MistakeExportDTO> exportDTOList = this.check(param);
      if (CollectionUtils.isNotEmpty(exportDTOList)) {
         this.exportMistakeList(response, exportDTOList);
      } else {
         List<StandardPartImportDTO> importDataList = this.importExcelData(file);
         if (importDataList.isEmpty()) {
            mistakeExportDTOList.add(this.getMistakeExportDTO(null, "该清单未找到序号!!"));
            this.exportMistakeList(response, mistakeExportDTOList);
         } else {
            this.check(importDataList, mistakeExportDTOList);
            if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
               this.exportMistakeList(response, mistakeExportDTOList);
            } else {
               boolean isMaterialLinked = this.checkWmsLink(param.getProjectId());
               Map<String, MesAuxiliary> auxiliaryMap = isMaterialLinked ? this.buildAuxiliaryMap() : Collections.emptyMap();
               List<TechStandardPart> newStandardPartList = new ArrayList<>(32);
               importDataList.forEach(importDTO -> {
                  if (isMaterialLinked) {
                     MesAuxiliary auxiliary = auxiliaryMap.get(importDTO.getName().trim() + "_" + importDTO.getAccountingUnit());
                     Preconditions.checkArgument(auxiliary != null, importDTO.getName() + "_" + importDTO.getAccountingUnit() + "对照表配置不存在,请先配置对照表!");
                  }

                  TechStandardPart standardPart = this.buildStandardPart(param, importDTO);
                  if (standardPart.getMeasureUnit() == null) {
                     standardPart.setMeasureUnit(importDTO.getAccountingUnit());
                  }

                  if (standardPart.getUnitNet() == null) {
                     standardPart.setUnitNet(importDTO.getMete());
                  }

                  Long businessId = this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
                  standardPart.setBusinessId(businessId);
                  standardPart.setBoolWmsLink(isMaterialLinked);
                  newStandardPartList.add(standardPart);
               });
               this.baseService.saveBatch(newStandardPartList);
               newStandardPartList.forEach(e -> {
                  if (!isMaterialLinked) {
                     this.intoWarehouse(e);
                  }
               });
               this.exportMistakeList(response, mistakeExportDTOList);
            }
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void importStandardPartV2(MultipartFile file, TechStandardPartImportDtoParam param, HttpServletResponse response) {
      List<MistakeExportDTO> mistakeList = new ArrayList<>(16);
      List<MistakeExportDTO> validationErrors = this.check2(param);
      if (CollectionUtils.isNotEmpty(validationErrors)) {
         this.exportMistakeList(response, validationErrors);
      } else {
         List<StandardPartImportDTO> importDataList = this.importExcelData(file);
         if (CollectionUtils.isEmpty(importDataList)) {
            mistakeList.add(this.getMistakeExportDTO(null, "该清单未找到序号!!"));
            this.exportMistakeList(response, mistakeList);
         } else {
            this.check(importDataList, mistakeList);
            if (CollectionUtils.isNotEmpty(mistakeList)) {
               this.exportMistakeList(response, mistakeList);
            } else {
               boolean isMaterialLinked = this.checkWmsLink(param.getProjectId());
               Map<String, MesAuxiliary> auxiliaryMap = isMaterialLinked ? this.buildAuxiliaryMap() : Collections.emptyMap();
               List<TechStandardPart> standardPartsToSave = new ArrayList<>(importDataList.size());

               for (StandardPartImportDTO importDTO : importDataList) {
                  if (isMaterialLinked) {
                     this.validateMaterialAssociation(importDTO, auxiliaryMap, mistakeList);
                     if (!mistakeList.isEmpty()) {
                        this.exportMistakeList(response, mistakeList);
                        return;
                     }
                  }

                  TechStandardPart standardPart = this.createStandardPart(param, importDTO, isMaterialLinked);
                  standardPartsToSave.add(standardPart);
               }

               this.baseService.saveBatch(standardPartsToSave);
               if (!isMaterialLinked) {
                  standardPartsToSave.forEach(this::intoWarehouse);
               }

               this.exportMistakeList(response, mistakeList);
            }
         }
      }
   }

   private List<StandardPartImportDTO> importExcelData(MultipartFile file) {
      int titleRows = 1;
      int headerRows = 1;
      Integer startSheetIndex = 0;
      List<StandardPartImportDTO> importData = PoiUtils.importExcel(file, titleRows, headerRows, startSheetIndex, StandardPartImportDTO.class);
      return importData.stream().filter(dto -> dto.getOrderNo() != null).collect(Collectors.toList());
   }

   private Map<String, MesAuxiliary> buildAuxiliaryMap() {
      return this.mesAuxiliaryService.list().stream().flatMap(auxiliary -> {
         String[] names = auxiliary.getAuxiliaryName().split(",");
         return Arrays.stream(names).map(name -> new SimpleEntry<>(name.trim() + "_" + auxiliary.getAccountingUnit(), auxiliary));
      }).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
   }

   private void validateMaterialAssociation(StandardPartImportDTO importDTO, Map<String, MesAuxiliary> auxiliaryMap, List<MistakeExportDTO> mistakeList) {
      String key = importDTO.getName().trim() + "_" + importDTO.getAccountingUnit();
      MesAuxiliary auxiliary = auxiliaryMap.get(key);
      if (auxiliary == null) {
         mistakeList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), importDTO.getName() + "_" + importDTO.getAccountingUnit() + "对照表配置不存在,请先配置对照表!"));
      }
   }

   private TechStandardPart createStandardPart(TechStandardPartImportDtoParam param, StandardPartImportDTO importDTO, boolean isMaterialLinked) {
      TechStandardPart standardPart = this.buildStandardPart(param, importDTO);
      if (standardPart.getMeasureUnit() == null) {
         standardPart.setMeasureUnit(importDTO.getAccountingUnit());
      }

      if (standardPart.getUnitNet() == null) {
         standardPart.setUnitNet(importDTO.getMete());
      }

      Long businessId = this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
      standardPart.setBusinessId(businessId);
      standardPart.setBoolWmsLink(isMaterialLinked);
      return standardPart;
   }

   private TechDeepenRecord buildDeepenRecord(TechStandardPart standardPart, Integer importQuantity, BigDecimal importMete) {
      return TechDeepenRecord.builder()
         .projectId(standardPart.getProjectId())
         .monomerId(standardPart.getMonomerId() != null ? standardPart.getMonomerId() : 0L)
         .areaId(standardPart.getAreaId() != null ? standardPart.getAreaId() : 0L)
         .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         .productId(standardPart.getId())
         .quantity(importQuantity)
         .mete(importMete)
         .userId(UserUtil.getCurrentUserId())
         .build();
   }

   private List<MistakeExportDTO> check(TechStandardPartImportDtoParam param) {
      List<MistakeExportDTO> mistakeExportDTOS = new ArrayList<>(16);
      ContractProject project = null;

      try {
         project = this.projectService.checkProjectStatus(param.getProjectId());
      } catch (Exception e) {
         mistakeExportDTOS.add(this.getMistakeExportDTO(null, e.getMessage()));
      }

      if (mistakeExportDTOS.isEmpty()) {
         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            Preconditions.checkArgument(param.getMonomerId() != null && param.getAreaId() != null, "单体和区域id不能为空!");
            PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
            PlanArea area = this.areaService.getById(param.getAreaId());
            Preconditions.checkArgument((area.getItemizedType() & ItemizedTypeEnum.ARTIFACT.getType()) > 0, "区域不是建刚类型");
            if (monomer == null) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "单体不存在!"));
            } else if (!monomer.getProjectId().equals(param.getProjectId())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "单体和项目不匹配!"));
            } else if (area == null) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "区域不存在"));
            } else if (!area.getMonomerId().equals(param.getMonomerId())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "区域和单体不匹配!"));
            }
         }

         if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            Preconditions.checkArgument(param.getCategory() != null && param.getEnclosurePlanId() != null, "围护类型和围护计划ID不能为空!");
            Preconditions.checkArgument(EnclosureCategoryEnum.isExist(param.getCategory()), "围护类型有误!");
            EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(param.getEnclosurePlanId());
            if (enclosurePlan == null) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "围护计划不存在!"));
            } else if (!enclosurePlan.getCategory().equals(param.getCategory())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "围护计划和围护类型不匹配!"));
            } else if (!enclosurePlan.getProjectId().equals(param.getProjectId())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "围护计划和项目不匹配!"));
            }
         }
      }

      return mistakeExportDTOS;
   }

   private List<MistakeExportDTO> check2(TechStandardPartImportDtoParam param) {
      List<MistakeExportDTO> mistakeExportDTOS = new ArrayList<>(16);
      ContractProject project = null;

      try {
         project = this.projectService.checkProjectStatus(param.getProjectId());
      } catch (Exception e) {
         mistakeExportDTOS.add(this.getMistakeExportDTO(null, e.getMessage()));
      }

      if (mistakeExportDTOS.isEmpty()) {
         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            Preconditions.checkArgument(
               project != null
                  && (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())),
               "项目类型不是建钢/桥梁项目!"
            );
         }

         Preconditions.checkArgument(param.getMonomerId() != null && param.getAreaId() != null, "单体和区域id不能为空!");
         PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
         PlanArea area = this.areaService.getById(param.getAreaId());
         if (monomer == null) {
            mistakeExportDTOS.add(this.getMistakeExportDTO(null, "单体不存在!"));
         } else if (!monomer.getProjectId().equals(param.getProjectId())) {
            mistakeExportDTOS.add(this.getMistakeExportDTO(null, "单体和项目不匹配!"));
         } else if (area == null) {
            mistakeExportDTOS.add(this.getMistakeExportDTO(null, "区域不存在"));
         } else if (!area.getMonomerId().equals(param.getMonomerId())) {
            mistakeExportDTOS.add(this.getMistakeExportDTO(null, "区域和单体不匹配!"));
         }
      }

      return mistakeExportDTOS;
   }

   private List<MistakeExportDTO> checkV2(TechStandardPartImportDtoParam param) {
      List<MistakeExportDTO> mistakeExportDTOS = new ArrayList<>(16);
      ContractProject project = null;

      try {
         project = this.projectService.checkProjectStatus(param.getProjectId());
      } catch (Exception e) {
         mistakeExportDTOS.add(this.getMistakeExportDTO(null, e.getMessage()));
      }

      if (mistakeExportDTOS.isEmpty()) {
         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            Preconditions.checkArgument(
               project != null
                  && (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())),
               "项目类型不是建钢/桥梁项目!"
            );
            Preconditions.checkArgument(param.getMonomerId() != null && param.getAreaId() != null, "单体和区域id不能为空!");
            PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
            PlanArea area = this.areaService.getById(param.getAreaId());
            if (monomer == null) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "单体不存在!"));
            } else if (!monomer.getProjectId().equals(param.getProjectId())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "单体和项目不匹配!"));
            } else if (area == null) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "区域不存在"));
            } else if (!area.getMonomerId().equals(param.getMonomerId())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "区域和单体不匹配!"));
            }
         }

         if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            Preconditions.checkArgument(param.getDictionaryId() != null && param.getAreaId() != null, "围护类型和围护计划ID不能为空!");
            List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
            Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
            Preconditions.checkArgument(enclosureDictMap.get(param.getDictionaryId()) != null, "围护类型有误!");
            PlanArea area = this.areaService.getById(param.getAreaId());
            if (area == null) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "围护计划不存在!"));
            } else if (!area.getProjectId().equals(param.getProjectId())) {
               mistakeExportDTOS.add(this.getMistakeExportDTO(null, "围护计划和项目不匹配!"));
            }
         }
      }

      return mistakeExportDTOS;
   }

   private void check(List<StandardPartImportDTO> importDTOS, List<MistakeExportDTO> mistakeExportDTOList) {
      importDTOS.forEach(
         importDTO -> {
            if (importDTO.getUseProperty() == null) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "使用范围不能为空!"));
            } else if (!importDTO.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())
               && !importDTO.getUseProperty().equals(AuxiliaryUsePropertyEnum.FACTORY_USE.getType())) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "使用范围填写错误!"));
            }

            if (StringUtils.isBlank(importDTO.getName())) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "名称不能为空!"));
            }

            if (StringUtils.isBlank(importDTO.getSpecification())) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "规格不能为空!"));
            }

            if (StringUtils.isBlank(importDTO.getMeasureUnit())) {
               importDTO.setMeasureUnit(importDTO.getAccountingUnit());
            }

            if (importDTO.getQuantity() == null) {
               importDTO.setQuantity(importDTO.getMete());
            } else if (importDTO.getQuantity() != null && importDTO.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "数量不能为0或负数!"));
            }

            if (StringUtils.isBlank(importDTO.getAccountingUnit())) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "核算单位不能为空!"));
            } else if ("kg".equalsIgnoreCase(importDTO.getAccountingUnit())) {
               importDTO.setAccountingUnit("千克");
            } else if ("t".equalsIgnoreCase(importDTO.getAccountingUnit())) {
               importDTO.setAccountingUnit("吨");
            }

            if (importDTO.getMete() == null) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "核算量不能为空!"));
            } else if (importDTO.getMete().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(this.getMistakeExportDTO(importDTO.getOrderNo(), "核算量不能为0或负数!"));
            }
         }
      );
   }

   private MistakeExportDTO getMistakeExportDTO(Integer orderNo, String errorMessage) {
      return MistakeExportDTO.builder().orderNo(orderNo).errorMessage(errorMessage).build();
   }

   private void exportMistakeList(HttpServletResponse response, List<MistakeExportDTO> mistakeExportDTOList) {
      try {
         response.setHeader("Access-Control-Expose-Headers", "result");
         if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
            String title = "标准件-导入出错表";
            String sheetName = "标准件-导入出错表";
            String fileName = "标准件-导入出错表.xls";
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            PoiUtils.exportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, response);
         } else {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
         }
      } catch (UnsupportedEncodingException e) {
         log.error("URL编码异常", e);
      }
   }

   private TechStandardPart buildStandardPart(TechStandardPartImportDtoParam param, StandardPartImportDTO importDTO) {
      TechStandardPart standardPart = TechStandardPart.builder()
         .projectId(param.getProjectId())
         .relationType(param.getProductType())
         .monomerId(param.getMonomerId())
         .areaId(param.getAreaId())
         .areaBatchId(param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) ? param.getAreaBatchId() : null)
         .configStatus(Boolean.TRUE)
         .category(param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()) ? param.getCategory() : null)
         .enclosurePlanId(param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()) ? param.getEnclosurePlanId() : null)
         .boolArtifactImport(Boolean.FALSE)
         .userId(UserUtil.getCurrentUserId())
         .boolWeightTypeEnum(WEIGHT_UNIT_LIST.stream().anyMatch(s -> s.equalsIgnoreCase(importDTO.getAccountingUnit())))
         .areaBatchId(param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) ? param.getAreaBatchId() : null)
         .build();
      BeanUtil.copy(importDTO, standardPart);
      return standardPart;
   }

   @Override
   public Boolean saveList(Integer productType, StandardPartSaveVoParam saveVoParam) {
      this.checkSave2(productType, saveVoParam);
      boolean isMaterialLinked = this.checkWmsLink(saveVoParam.getProjectId());
      Map<String, MesAuxiliary> auxiliaryMap = isMaterialLinked ? this.buildAuxiliaryMap() : Collections.emptyMap();
      saveVoParam.getStandardPartList()
         .forEach(
            param -> {
               Preconditions.checkArgument(
                  "千克".equals(param.getAccountingUnit()) || "吨".equals(param.getAccountingUnit()) || !param.getBoolWeightTypeEnum(), "重量单位只可填写(千克)或(吨)!!"
               );
               if (isMaterialLinked) {
                  MesAuxiliary auxiliary = auxiliaryMap.get(param.getName() + "_" + param.getAccountingUnit());
                  Preconditions.checkArgument(auxiliary != null, param.getName() + "_" + param.getAccountingUnit() + "对照表配置不存在,请先配置对照表!");
               }

               TechStandardPart standardPart = BeanUtil.copy(param, TechStandardPart.class);
               BeanUtil.copy(saveVoParam, standardPart);
               standardPart.setBoolArtifactImport(Boolean.FALSE);
               standardPart.setConfigStatus(Boolean.TRUE);
               if (standardPart.getMeasureUnit() == null) {
                  standardPart.setMeasureUnit(param.getAccountingUnit());
               }

               if (standardPart.getQuantity() == null) {
                  standardPart.setQuantity(param.getMete());
               }

               standardPart.setRelationType(productType);
               standardPart.setBoolWmsLink(isMaterialLinked);
               standardPart.setUserId(UserUtil.getCurrentUserId());
               Long businessId = this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
               standardPart.setBusinessId(businessId);
               this.baseService.save(standardPart);
               if (!isMaterialLinked) {
                  this.intoWarehouse(standardPart);
               }
            }
         );
      return true;
   }

   @Override
   public boolean checkWmsLink(Long projectId) {
      boolean boolLink = false;
      List<SysKitWmsCommonConfig> configs = this.kitWmsCommonConfigService.list();
      if (CollectionUtils.isEmpty(configs)) {
         return boolLink;
      }

      SysKitWmsCommonConfig projectWmsLinkConfig = configs.stream().filter(e -> e.getBoolGeneralConfig().equals(false)).findFirst().orElse(null);
      if (projectWmsLinkConfig != null) {
         KitWmsCommonConfigDTO configurationDTO = JSON.parseObject(projectWmsLinkConfig.getValue(), KitWmsCommonConfigDTO.class);
         boolLink = configurationDTO.getDetailList().stream().anyMatch(e -> e.getProjectId().equals(projectId) && e.getBoolLink().equals(true));
         if (boolLink) {
            return boolLink;
         }
      }

      SysKitWmsCommonConfig commonConfig = configs.stream().filter(e -> e.getBoolGeneralConfig().equals(true)).findFirst().orElse(null);
      if (commonConfig != null) {
         KitWmsCommonConfigDTO configurationDTO = JSON.parseObject(commonConfig.getValue(), KitWmsCommonConfigDTO.class);
         boolLink = configurationDTO.getBoolLink() == null ? false : configurationDTO.getBoolLink();
      }

      return boolLink;
   }

   private void intoWarehouse(TechStandardPart standardPart) {
      if (standardPart.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())) {
         this.warehouseBiz
            .setStockQuantity(
               WarehouseSaveDTOParam.builder()
                  .projectId(standardPart.getProjectId())
                  .monomerId(standardPart.getMonomerId())
                  .areaId(standardPart.getAreaId())
                  .areaBatchId(standardPart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType()) ? standardPart.getAreaBatchId() : 0L)
                  .factoryId(0L)
                  .workshopId(0L)
                  .productId(standardPart.getId())
                  .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                  .type(WarehouseTypeEnum.INTO.getType())
                  .quantity(standardPart.getQuantity())
                  .build()
            );
      } else {
         standardPart.setOriginalId(0L);
         this.updateById(standardPart);
      }
   }

   private void checkSave(Integer productType, StandardPartSaveVoParam param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      if (param.getAreaId() != null && param.getMonomerId() != null && !UserUtil.getCurrentUser().isAdmin()) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, param.getMonomerId()));
         Preconditions.checkArgument(
            CollectionUtils.isNotEmpty(monomerUserLinkList)
               || monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList()).contains(UserUtil.getCurrentUserId()),
            "您不是该单体深化负责人,不允许导入文件!"
         );
      }

      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         Preconditions.checkArgument(param.getMonomerId() != null && param.getAreaId() != null, "单体和区域id不能为空!");
         PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
         Preconditions.checkArgument(monomer != null, "单体不存在!");
         Preconditions.checkArgument(monomer.getProjectId().equals(param.getProjectId()), "单体和项目不匹配!");
         PlanArea area = this.areaService.getById(param.getAreaId());
         Preconditions.checkArgument(area != null, "区域不存在!");
         Preconditions.checkArgument(area.getMonomerId().equals(param.getMonomerId()), "区域和单体不匹配");
         Preconditions.checkArgument(area.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType()), "区域不是结构类型");
      }

      if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         Preconditions.checkArgument(param.getCategory() != null && param.getEnclosurePlanId() != null, "围护类型和围护计划ID不能为空!");
         Preconditions.checkArgument(EnclosureCategoryEnum.isExist(param.getCategory()), "围护类型有误!");
         EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(param.getEnclosurePlanId());
         Preconditions.checkArgument(enclosurePlan != null, "围护计划不存在!");
         Preconditions.checkArgument(enclosurePlan.getCategory().equals(param.getCategory()), "围护计划和围护类型不匹配!");
         Preconditions.checkArgument(enclosurePlan.getProjectId().equals(param.getProjectId()), "围护计划和项目不匹配!");
      }
   }

   private void checkSave2(Integer productType, StandardPartSaveVoParam param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         Preconditions.checkArgument(
            project != null
               && (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())),
            "项目类型不是建钢/桥梁项目!"
         );
      }

      Preconditions.checkArgument(param.getMonomerId() != null && param.getAreaId() != null, "单体和区域id不能为空!");
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在!");
      Preconditions.checkArgument(monomer.getProjectId().equals(param.getProjectId()), "单体和项目不匹配!");
      PlanArea area = this.areaService.getById(param.getAreaId());
      Preconditions.checkArgument(area != null, "区域不存在!");
      Preconditions.checkArgument(area.getMonomerId().equals(param.getMonomerId()), "区域和单体不匹配");
   }

   @Override
   public Boolean updateList(List<TechStandardPartUpdateDtoParam> paramList) {
      List<Long> ids = paramList.stream().map(TechStandardPartUpdateDtoParam::getId).collect(Collectors.toList());
      List<MesBuildingWarehouseSummary> warehouseSummaries = this.summaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType()))
                  .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
               .in(MesBuildingWarehouseSummary::getProductId, ids)
         );
      List<MesBuildingWarehouseRecord> recordList = this.recordService
         .list(
            (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                     .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                  .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
               .in(MesBuildingWarehouseRecord::getProductId, ids)
         );
      Map<Long, MesBuildingWarehouseSummary> warehouseSummaryMap = warehouseSummaries.stream()
         .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProductId, Function.identity()));
      Map<Long, MesBuildingWarehouseRecord> recordMap = recordList.stream()
         .collect(Collectors.toMap(MesBuildingWarehouseRecord::getProductId, Function.identity()));
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<Long> removeBusinessIds = new ArrayList<>(16);
      paramList.forEach(
         param -> {
            TechStandardPart standardPart = this.baseService.getById(param.getId());
            Preconditions.checkArgument(standardPart != null, "修改失败,标准件不存在!");
            Preconditions.checkArgument(!standardPart.getBoolArtifactImport(), "该配套件关联了清单，不可修改/编辑");
            Preconditions.checkArgument(
               "千克".equals(param.getAccountingUnit()) || "吨".equals(param.getAccountingUnit()) || !param.getBoolWeightTypeEnum(), "重量单位只可填写(千克)或(吨)!!"
            );
            Integer oldUseProperty = standardPart.getUseProperty();
            if (oldUseProperty.equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())) {
               MesBuildingWarehouseSummary summary = warehouseSummaryMap.get(param.getId());
               MesBuildingWarehouseRecord record = recordMap.get(param.getId());
               if (summary != null) {
                  BigDecimal sumPackageQuantity = summary.getPackageQuantity();
                  BigDecimal sumCargoQuantity = summary.getCargoQuantity();
                  Preconditions.checkArgument(sumPackageQuantity.add(sumCargoQuantity).compareTo(BigDecimal.ZERO) == 0, "配套件已打包或者装车发运,无法变更");
                  Preconditions.checkArgument(
                     param.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())
                        || summary.getCargoQuantity().compareTo(BigDecimal.ZERO) == 0 && summary.getPackageQuantity().compareTo(BigDecimal.ZERO) == 0,
                     "产品已装车发运,不能修改使用位置!"
                  );
                  Preconditions.checkArgument(
                     param.getQuantity().subtract(summary.getCargoQuantity()).subtract(summary.getPackageQuantity()).compareTo(BigDecimal.ZERO) > 0,
                     "修改失败，修改后的数量不能低于已装车发运的数量"
                  );
                  summary.setQuantity(summary.getQuantity().add(param.getQuantity()).subtract(standardPart.getQuantity()));
                  this.summaryService.updateById(summary);
               }

               if (record != null) {
                  record.setQuantity(record.getQuantity().add(param.getQuantity()).subtract(standardPart.getQuantity()));
                  this.recordService.updateById(record);
               }

               if (param.getUseProperty().equals(AuxiliaryUsePropertyEnum.FACTORY_USE.getType())) {
                  if (summary != null) {
                     this.summaryService.removeById(summary.getId());
                  }

                  if (record != null) {
                     this.recordService.removeById(record.getId());
                  }
               }
            }

            BusinessStandardPart businessStandardPart = this.businessStandardPartService.getById(standardPart.getBusinessId());
            businessStandardPart.setQuantity(businessStandardPart.getQuantity().subtract(standardPart.getQuantity()));
            businessStandardPart.setMete(businessStandardPart.getMete().subtract(standardPart.getMete()));
            businessStandardPart.setTotalPrice(
               businessStandardPart.getUnitPrice() != null ? businessStandardPart.getUnitPrice().multiply(businessStandardPart.getMete()) : null
            );
            if (businessStandardPart.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
               this.businessStandardPartService.removeById(businessStandardPart.getId());
               removeBusinessIds.add(businessStandardPart.getId());
            } else {
               this.businessStandardPartService.updateById(businessStandardPart);
            }

            BeanUtil.copy(param, standardPart);
            standardPart.setUserId(UserUtil.getCurrentUserId());
            standardPart.setLastEditorId(UserUtil.getCurrentUserId());
            Long businessId = this.businessStandardPartService.addBusiness(BeanUtil.copy(standardPart, StandardPartAddDtoParam.class));
            standardPart.setBusinessId(businessId);
            this.baseService.updateById(standardPart);
            if (oldUseProperty.equals(AuxiliaryUsePropertyEnum.FACTORY_USE.getType())
               && param.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType())) {
               boolean isMaterialLinked = this.checkWmsLink(standardPart.getProjectId());
               if (!isMaterialLinked) {
                  this.intoWarehouse(standardPart);
               }
            }
         }
      );
      if (CollectionUtils.isNotEmpty(removeBusinessIds)) {
         this.removeBusinessInfo(removeBusinessIds);
      }

      return true;
   }

   @Override
   public Boolean deleteList(Integer productType, List<Long> ids) {
      List<MesBuildingWarehouseSummary> warehouseSummaries = this.summaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType()))
                  .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
               .in(MesBuildingWarehouseSummary::getProductId, ids)
         );
      Map<Long, MesBuildingWarehouseSummary> warehouseSummaryMap = warehouseSummaries.stream()
         .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProductId, Function.identity()));
      Map<Long, TechStandardPart> standardPartMap = this.baseService.listByIds(ids).stream().collect(Collectors.toMap(e -> e.getId(), Function.identity()));

      for (Long id : ids) {
         TechStandardPart standardPart = standardPartMap.get(id);
         Preconditions.checkArgument(standardPart != null, "删除失败,标准件不存在!");
         if (standardPart.getUseProperty().equals(AuxiliaryUsePropertyEnum.FACTORY_USE.getType())) {
            Preconditions.checkArgument(!standardPart.getBoolArtifactImport(), standardPart.getName() + "该配套件关联了清单，不可修改/编辑");
         }

         MesBuildingWarehouseSummary summary = warehouseSummaryMap.get(id);
         if (summary != null) {
            BigDecimal sumPackageQuantity = summary.getPackageQuantity();
            BigDecimal sumCargoQuantity = summary.getCargoQuantity();
            Preconditions.checkArgument(sumPackageQuantity.add(sumCargoQuantity).compareTo(BigDecimal.ZERO) == 0, "配套件已打包或者装车发运,无法变更");
         }

         this.projectService.checkProjectStatus(standardPart.getProjectId());
         this.businessStandardPartService.editBusiness(standardPart.getBusinessId(), standardPart.getQuantity().negate(), standardPart.getMete().negate());
      }

      List<MesBuildingCargoListProductLink> productLinkList = this.cargoListProductLinkService
         .list(
            (Wrapper<MesBuildingCargoListProductLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                     .in(MesBuildingCargoListProductLink::getProductId, ids))
                  .eq(MesBuildingCargoListProductLink::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
               .eq(MesBuildingCargoListProductLink::getBoolCancelShip, Boolean.FALSE)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(productLinkList), "已产生发运,删除失败!!!");
      List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingPackageLink.class)
               .in(MesBuildingPackageLink::getProductId, ids)
               .eq(MesBuildingPackageLink::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         );
      if (CollUtil.isNotEmpty(packageLinkList)) {
         this.packageBiz.deletePackage(packageLinkList.stream().map(MesBuildingPackageLink::getPackageId).collect(Collectors.toList()));
      }

      this.warehouseBiz.removeWarehouseRecord(ids, ProductTypeEnum.AUXILIARY_MATERIAL.getType());
      this.baseService.removeByIds(ids);
      return true;
   }

   private void removeBusinessInfo(List<Long> removeBusinessIds) {
      this.businessPriceTempService
         .remove(
            Wrappers.lambdaQuery(BusinessPriceTemp.class)
               .in(BusinessPriceTemp::getProjectType, ProjectTypeEnum.MES.getType(), ProjectTypeEnum.ENCLOSURE.getType(), ProjectTypeEnum.BRIDGE.getType())
               .eq(BusinessPriceTemp::getType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
               .in(BusinessPriceTemp::getBusinessId, removeBusinessIds)
         );
      List<BusinessCheckDetail> checkDetailList = this.businessCheckDetailService
         .list(
            Wrappers.lambdaQuery(BusinessCheckDetail.class)
               .in(BusinessCheckDetail::getProjectType, ProjectTypeEnum.MES.getType(), ProjectTypeEnum.ENCLOSURE.getType(), ProjectTypeEnum.BRIDGE.getType())
               .eq(BusinessCheckDetail::getType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
               .in(BusinessCheckDetail::getBusinessId, removeBusinessIds)
         );
      if (CollectionUtils.isNotEmpty(checkDetailList)) {
         Map<Long, List<BusinessCheckDetail>> removeInfoIdListMap = checkDetailList.stream()
            .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         Set<Long> checkInfoIds = checkDetailList.stream().map(BusinessCheckDetail::getCheckInfoId).collect(Collectors.toSet());
         Map<Long, List<BusinessCheckDetail>> sourceInfoIdListMap = this.businessCheckDetailService
            .list(Wrappers.lambdaQuery(BusinessCheckDetail.class).in(BusinessCheckDetail::getCheckInfoId, checkInfoIds))
            .stream()
            .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         removeInfoIdListMap.forEach((checkInfoId, list) -> {
            if (list.size() == sourceInfoIdListMap.get(checkInfoId).size()) {
               this.businessCheckInfoService.removeById(checkInfoId);
            }
         });
         this.businessCheckDetailService.removeByIds(checkDetailList.stream().map(BusinessCheckDetail::getId).collect(Collectors.toList()));
      }
   }

   @Override
   public TechStandardPartDetailDTO getTechStandardPartById(Long id) {
      TechStandardPart techStandardPart = this.getById(id);
      Preconditions.checkArgument(techStandardPart != null, "配套件不存在");
      TechStandardPartDetailDTO materialDTO = BeanUtil.copy(techStandardPart, TechStandardPartDetailDTO.class);
      materialDTO.setProject(this.projectService.getSimpleById(techStandardPart.getProjectId()));
      materialDTO.setMonomer(this.monomerService.getSimpleById(techStandardPart.getMonomerId()));
      materialDTO.setUserName(this.userService.getNameById(techStandardPart.getUserId()));
      materialDTO.setSerialNumber("-");
      return materialDTO;
   }

   public TechStandardPartBizImpl(
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final BusinessStandardPartService businessStandardPartService,
      final WarehouseBiz warehouseBiz,
      final MesBuildingWarehouseSummaryService summaryService,
      final MesBuildingWarehouseRecordService recordService,
      final MesBuildingPackageBiz packageBiz,
      final MesBuildingPackageLinkService packageLinkService,
      final UserService userService,
      final EnclosurePlanService enclosurePlanService,
      final BusinessPriceTempService businessPriceTempService,
      final BusinessCheckInfoService businessCheckInfoService,
      final BusinessCheckDetailService businessCheckDetailService,
      final MonomerUserLinkService monomerUserLinkService,
      final MesBuildingCargoListProductLinkService cargoListProductLinkService,
      final SysDictionaryService dictionaryService,
      final SysKitWmsCommonConfigService kitWmsCommonConfigService,
      final MesAuxiliaryService mesAuxiliaryService,
      final MesBuildingWarehouseSummaryService warehouseSummaryService
   ) {
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.businessStandardPartService = businessStandardPartService;
      this.warehouseBiz = warehouseBiz;
      this.summaryService = summaryService;
      this.recordService = recordService;
      this.packageBiz = packageBiz;
      this.packageLinkService = packageLinkService;
      this.userService = userService;
      this.enclosurePlanService = enclosurePlanService;
      this.businessPriceTempService = businessPriceTempService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.businessCheckDetailService = businessCheckDetailService;
      this.monomerUserLinkService = monomerUserLinkService;
      this.cargoListProductLinkService = cargoListProductLinkService;
      this.dictionaryService = dictionaryService;
      this.kitWmsCommonConfigService = kitWmsCommonConfigService;
      this.mesAuxiliaryService = mesAuxiliaryService;
      this.warehouseSummaryService = warehouseSummaryService;
   }
}
