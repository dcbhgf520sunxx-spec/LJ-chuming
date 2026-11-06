package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureEditDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.BoolStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractTechBaseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecord;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecordDetail;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureRecord;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.service.check.MesTechEnclosureInventoryOperationService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordDetailService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureRecordService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskOrderService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import com.hzchum.scim.plan.core.api.biz.check.MesTechEnclosureInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ArtifactChangeTypeEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureChangeLogTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.OperationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ProjectPlanProductCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.AreaSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.MonomerSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.ProjectSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChangeLog;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureImportAllDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureSubscribeDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechEnclosureChangeRecordDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureNeedSchedulingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectSchedulingStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.EnclosureSubscribeQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeCheckDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechEnclosureChangeRecordQueryVoParam;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechDeepenRecordService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeLogService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.SysProfiledPlateEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionary;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionaryDetail;
import com.hzchum.scim.system.core.api.pojo.dto.SysTrussFloorPlateCodeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TechnicalTypeDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryDetailService;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechEnclosureBizImpl implements TechEnclosureBiz {
   private static final Logger log = LoggerFactory.getLogger(TechEnclosureBizImpl.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private UserService userService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private BusinessCheckInfoService businessCheckInfoService;
   @Resource
   private BusinessCheckDetailService businessCheckDetailService;
   @Resource
   private BusinessPriceTempService businessPriceTempService;
   @Resource
   private TechDeepenRecordService deepenRecordService;
   @Resource
   private ConfigService configService;
   @Resource
   private SysEnclosureDictionaryService enclosureDictionaryService;
   @Resource
   private SysEnclosureDictionaryDetailService dictionaryDetailService;
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private TechEnclosureChangeRecordService enclosureChangeRecordService;
   @Resource
   private MesTechEnclosureInventoryOperationService enclosureInventoryOperationService;
   @Resource
   private MesTechInventoryOperationService mesTechInventoryOperationService;
   @Resource
   private TechEnclosureRecordService enclosureRecordService;
   @Resource
   private TechEnclosureChangeRecordDetailService enclosureChangeRecordDetailService;
   @Resource
   private MesEnclosureTaskService taskService;
   @Resource
   private MesEnclosureTaskOrderService taskOrderService;
   @Resource
   private MesEnclosureProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private TechEnclosureChangeLogService changeLogService;
   @Resource
   private BusinessEnclosureService businessService;
   @Value("${enclosure.dictionaries}")
   private String dictionaries;

   @Override
   public PageVO<EnclosureResponseDTO> pageListEnclosure(EnclosureListQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, orderBy);
      List<EnclosureResponseDTO> responseDTOS = this.enclosureService.listByCondition(queryDTOParam);
      if (CollectionUtils.isNotEmpty(responseDTOS)) {
         responseDTOS.forEach(responseDTO -> {
            responseDTO.setTotalLength(responseDTO.getTotalLength().divide(BigDecimal.valueOf(1000L)).setScale(3, RoundingMode.HALF_UP));
            responseDTO.setTotalArea(responseDTO.getTotalArea().divide(BigDecimal.valueOf(1000000L)).setScale(3, RoundingMode.HALF_UP));
            responseDTO.setTotalWeight(responseDTO.getTotalWeight().setScale(3, RoundingMode.HALF_UP));
         });
         List<Long> attachmentIds = responseDTOS.stream().map(EnclosureResponseDTO::getAttachmentId).collect(Collectors.toList());
         Map<Long, AttachmentDTO> attachmentDTOMap = this.attachmentService
            .listByIdList(attachmentIds)
            .stream()
            .collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
         responseDTOS.forEach(e -> e.setAttachmentDTO(attachmentDTOMap.get(e.getAttachmentId())));
      }

      return new PageVO<>(responseDTOS);
   }

   @Override
   public PageVO<EnclosureResponseDTO> pageListEnclosureV2(EnclosureListQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, orderBy);
      List<EnclosureResponseDTO> responseDTOS = this.enclosureService.listByCondition(queryDTOParam);
      if (CollectionUtils.isNotEmpty(responseDTOS)) {
         Map<Long, MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                  .in(MesBuildingWarehouseSummary::getProductId, responseDTOS.stream().map(e -> e.getId()).collect(Collectors.toList()))
                  .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ENCLOSURE.getType())
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getProductId(), Function.identity()));
         responseDTOS.forEach(responseDTO -> {
            MesBuildingWarehouseSummary summary = warehouseSummaryList.get(responseDTO.getId());
            if (summary != null) {
               responseDTO.setShippedQuantity(summary.getPackageQuantity().intValue() + summary.getCargoQuantity().intValue());
            } else {
               responseDTO.setShippedQuantity(0);
            }

            responseDTO.setSurfaceArea(responseDTO.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP));
            responseDTO.setTotalArea(responseDTO.getTotalArea().divide(BigDecimal.valueOf(1000000L), 6, RoundingMode.HALF_UP));
            responseDTO.setTotalWeight(responseDTO.getTotalWeight());
         });
         List<Long> attachmentIds = responseDTOS.stream().map(EnclosureResponseDTO::getAttachmentId).collect(Collectors.toList());
         Map<Long, AttachmentDTO> attachmentDTOMap = this.attachmentService
            .listByIdList(attachmentIds)
            .stream()
            .collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
         responseDTOS.forEach(e -> e.setAttachmentDTO(attachmentDTOMap.get(e.getAttachmentId())));
      }

      return new PageVO<>(responseDTOS);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importEnclosure(MultipartFile file, Long enclosurePlanId, Integer importType, HttpServletResponse response) {
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(enclosurePlanId);
      Preconditions.checkArgument(enclosurePlan != null, "导入失败,该区域不存在");
      this.projectService.checkProjectStatus(enclosurePlan.getProjectId());
      Integer category = enclosurePlan.getCategory();
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ContractTech contractTech = this.contractTechService
         .getOne(Wrappers.lambdaQuery(ContractTech.builder().projectId(enclosurePlan.getProjectId()).type(enclosurePlan.getCategory()).build()));
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(128);
      List<TechEnclosure> enclosureList = this.enclosureService
         .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getEnclosurePlanId, enclosurePlanId));
      if (importType.equals(ImportTypeEnum.COVER_IMPORT.getType())) {
         enclosureList.forEach(enclosurex -> {
            if (enclosurex.getSchedulingQuantity() > 0) {
               mistakeExportDTOList.add(this.getMistakeDTO(null, "围护编号(" + enclosurex.getSerialNumber() + ")已排产,无法覆盖导入!"));
            }

            if (!currentUser.isAdmin() && !currentUser.getId().equals(enclosurex.getUserId())) {
               mistakeExportDTOList.add(this.getMistakeDTO(null, "您无权限覆盖编号(" + enclosurex.getSerialNumber() + ")!"));
            }
         });
         if (mistakeExportDTOList.isEmpty()) {
            this.enclosureService.remove(Wrappers.lambdaQuery(TechEnclosure.builder().enclosurePlanId(enclosurePlanId).build()));
            enclosureList = new ArrayList<>(16);
         }
      }

      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         this.exportResult(mistakeExportDTOList, category, response);
      } else {
         int titleRows = 1;
         int headerRows = 1;
         Integer startSheetIndex = 0;
         List<EnclosureImportDTO> importDTOList = PoiUtils.importExcel(file, titleRows, headerRows, startSheetIndex, EnclosureImportDTO.class);
         if (importDTOList.isEmpty()) {
            mistakeExportDTOList.add(this.getMistakeDTO(0, "导入失败,导入的围护清单为空"));
            this.exportResult(mistakeExportDTOList, category, response);
         } else {
            importDTOList = importDTOList.stream().filter(importDTOx -> importDTOx.getOrderNo() != null).collect(Collectors.toList());
            if (importDTOList.isEmpty()) {
               mistakeExportDTOList.add(this.getMistakeDTO(null, "围护清单每行数据必须携带序号!"));
               this.exportResult(mistakeExportDTOList, category, response);
            }

            this.checkField(importDTOList, category, mistakeExportDTOList);
            if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
               this.exportResult(mistakeExportDTOList, category, response);
            }

            Boolean boolTechnicalType = this.getBoolTechnicalType();
            List<String> plateList = this.contractTechService.listPlate(enclosurePlan.getProjectId(), category);
            this.checkPlateType(importDTOList, boolTechnicalType, plateList, category, mistakeExportDTOList);
            if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
               this.exportResult(mistakeExportDTOList, category, response);
            }

            Map<String, TechEnclosure> categorySnMap = this.enclosureService
               .list(Wrappers.lambdaQuery(TechEnclosure.builder().enclosurePlanId(enclosurePlanId).build()))
               .stream()
               .collect(Collectors.toMap(TechEnclosure::getSerialNumber, Function.identity()));
            Map<String, EnclosureImportDTO> firstSnMap = new HashMap<>(16);
            importDTOList.forEach(importDTOx -> {
               if (categorySnMap.containsKey(importDTOx.getSerialNumber())) {
                  TechEnclosure enclosurexx = categorySnMap.get(importDTOx.getSerialNumber());
                  List<MistakeExportDTO> exportDTOList = this.checkImportEquals(importDTOx, enclosurexx);
                  mistakeExportDTOList.addAll(exportDTOList);
               } else if (firstSnMap.containsKey(importDTOx.getSerialNumber())) {
                  EnclosureImportDTO enclosureImportDTO = firstSnMap.get(importDTOx.getSerialNumber());
                  TechEnclosure enclosurex = BeanUtil.copy(enclosureImportDTO, TechEnclosure.class);
                  enclosurex.setCategory(enclosurePlan.getCategory());
                  List<MistakeExportDTO> exportDTOList = this.checkImportEquals(importDTOx, enclosurex);
                  mistakeExportDTOList.addAll(exportDTOList);
               } else {
                  firstSnMap.put(importDTOx.getSerialNumber(), importDTOx);
               }
            });
            if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
               this.exportResult(mistakeExportDTOList, category, response);
            }

            Map<String, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getSerialNumber, Function.identity()));
            List<TechEnclosure> newEnclosureList = new ArrayList<>(16);
            Map<String, TechEnclosure> newEnclosureMap = new HashMap<>(16);
            List<TechDeepenRecord> deepenRecordList = new ArrayList<>(16);

            for (EnclosureImportDTO importDTO : importDTOList) {
               if (enclosureMap.containsKey(importDTO.getSerialNumber())) {
                  TechEnclosure enclosure = enclosureMap.get(importDTO.getSerialNumber());
                  enclosure.setQuantity(enclosure.getQuantity() + importDTO.getQuantity());
                  this.setTotal(enclosure);
                  enclosure.setBoolStatusEnum(enclosure.getBoolStatusEnum() == null || enclosure.getBoolStatusEnum());
                  enclosure.setBoolAbnormalEnum(!enclosure.getBoolStatusEnum());
                  enclosure.setUserId(UserUtil.getCurrentUserId());
                  TechDeepenRecord techDeepenRecord = this.buildDeepenRecord(enclosure, importDTO.getQuantity());
                  deepenRecordList.add(techDeepenRecord);
                  EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
                     .businessId(enclosure.getBusinessId())
                     .quantity(importDTO.getQuantity())
                     .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)))
                     .totalArea(
                        enclosure.getUnfoldedWidth()
                           .multiply(enclosure.getLength())
                           .multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000000L))
                     )
                     .build();
                  this.businessEnclosureService.editBusinessInfo(editDTOParam);
               } else if (newEnclosureMap.containsKey(importDTO.getSerialNumber())) {
                  TechEnclosure enclosure = newEnclosureMap.get(importDTO.getSerialNumber());
                  enclosure.setQuantity(enclosure.getQuantity() + importDTO.getQuantity());
                  this.setTotal(enclosure);
                  EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
                     .businessId(enclosure.getBusinessId())
                     .quantity(importDTO.getQuantity())
                     .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)))
                     .totalArea(
                        enclosure.getUnfoldedWidth()
                           .multiply(enclosure.getLength())
                           .multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue()))
                           .divide(BigDecimal.valueOf(1000000L))
                     )
                     .build();
                  this.businessEnclosureService.editBusinessInfo(editDTOParam);
               } else {
                  TechEnclosure enclosure = TechEnclosure.builder()
                     .projectId(enclosurePlan.getProjectId())
                     .enclosurePlanId(enclosurePlanId)
                     .category(category)
                     .userId(UserUtil.getCurrentUserId())
                     .boolAbnormalEnum(false)
                     .boolStatusEnum(true)
                     .build();
                  BeanUtil.copy(importDTO, enclosure);
                  enclosure.setCategory(category);
                  this.setWith(enclosure, boolTechnicalType);
                  this.setTotal(enclosure);
                  EnclosureAddDTOParam addBusiness = BeanUtil.copy(enclosure, EnclosureAddDTOParam.class);
                  addBusiness.setTotalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)));
                  addBusiness.setTotalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
                  addBusiness.setPricingManner(contractTech.getMeasureMode());
                  Long businessId = this.businessEnclosureService.addBusinessInfo(addBusiness);
                  enclosure.setBusinessId(businessId);
                  newEnclosureList.add(enclosure);
                  newEnclosureMap.put(importDTO.getSerialNumber(), enclosure);
               }
            }

            this.enclosureService.updateBatchById(enclosureList);
            this.enclosureService.saveBatch(newEnclosureList);
            newEnclosureList.forEach(enclosurex -> {
               TechDeepenRecord deepenRecord = this.buildDeepenRecord(enclosurex, enclosurex.getQuantity());
               deepenRecordList.add(deepenRecord);
            });
            this.deepenRecordService.saveBatch(deepenRecordList);
            this.exportResult(mistakeExportDTOList, category, response);
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean importEnclosureV2(MesTechEnclosureInventoryOperationDTOParam dtoParam) {
      MesTechInventoryOperation inventoryOperation = this.mesTechInventoryOperationService.getById(dtoParam.getId());
      Preconditions.checkArgument(InventoryReviewedEnum.UNAUDITED.getType().equals(inventoryOperation.getInventoryReviewedEnum()), "操作失败,该操作记录非待审核状态");
      PlanArea area = this.areaService.getById(inventoryOperation.getAreaId());
      Preconditions.checkArgument(area != null, "区域不存在!!!");
      inventoryOperation.setInventoryReviewedEnum(dtoParam.getCheckStatus());
      inventoryOperation.setReviewedBy(UserUtil.getCurrentUserId());
      inventoryOperation.setReviewedName(UserUtil.getCurrentName());
      inventoryOperation.setReviewedTime(LocalDateTime.now());
      if (dtoParam.getCheckStatus().equals(InventoryReviewedEnum.REVOKED.getType())) {
         Preconditions.checkArgument(inventoryOperation.getImportUserId().equals(UserUtil.getCurrentUserId()), "仅导入人可撤回!!!");
      }

      this.mesTechInventoryOperationService.updateById(inventoryOperation);
      if (!InventoryReviewedEnum.PASSED.getType().equals(dtoParam.getCheckStatus())) {
         return Boolean.TRUE;
      }

      List<TechEnclosure> enclosureList = this.enclosureService
         .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getAreaId, inventoryOperation.getAreaId()));
      Map<String, TechEnclosure> enclosureMap = enclosureList.stream()
         .collect(Collectors.toMap(e -> e.getDictionaryId() + e.getSerialNumber(), Function.identity()));
      List<TechEnclosure> newEnclosureList = new ArrayList<>(16);
      Map<String, TechEnclosure> newEnclosureMap = new HashMap<>(16);
      List<TechDeepenRecord> deepenRecordList = new ArrayList<>(16);

      for (TechEnclosureRecord importDTO : this.enclosureRecordService
         .list((Wrapper<TechEnclosureRecord>)new LambdaQueryWrapper<TechEnclosureRecord>().eq(TechEnclosureRecord::getInventoryOperationId, inventoryOperation.getId()))) {
         if (enclosureMap.containsKey(importDTO.getDictionaryId() + importDTO.getSerialNumber())) {
            TechEnclosure enclosure = enclosureMap.get(importDTO.getDictionaryId() + importDTO.getSerialNumber());
            enclosure.setQuantity(enclosure.getQuantity() + importDTO.getQuantity());
            enclosure.setTotalLength(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getLength()));
            enclosure.setTotalArea(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getSurfaceArea()));
            enclosure.setTotalWeight(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getWeight()));
            enclosure.setBoolStatusEnum(enclosure.getBoolStatusEnum() == null || enclosure.getBoolStatusEnum());
            enclosure.setBoolAbnormalEnum(!enclosure.getBoolStatusEnum());
            enclosure.setUserId(UserUtil.getCurrentUserId());
            TechDeepenRecord techDeepenRecord = this.buildDeepenRecord(enclosure, importDTO.getQuantity());
            deepenRecordList.add(techDeepenRecord);
            EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
               .businessId(enclosure.getBusinessId())
               .quantity(importDTO.getQuantity())
               .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)))
               .totalArea(
                  enclosure.getUnfoldedWidth()
                     .multiply(enclosure.getLength())
                     .multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue()))
                     .divide(BigDecimal.valueOf(1000000L))
               )
               .build();
            this.businessEnclosureService.editBusinessInfo(editDTOParam);
         } else if (newEnclosureMap.containsKey(importDTO.getDictionaryId() + importDTO.getSerialNumber())) {
            TechEnclosure enclosure = newEnclosureMap.get(importDTO.getDictionaryId() + importDTO.getSerialNumber());
            enclosure.setQuantity(enclosure.getQuantity() + importDTO.getQuantity());
            enclosure.setTotalLength(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getLength()));
            enclosure.setTotalArea(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getSurfaceArea()));
            enclosure.setTotalWeight(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getWeight()));
            EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
               .businessId(enclosure.getBusinessId())
               .quantity(importDTO.getQuantity())
               .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)))
               .totalArea(
                  enclosure.getUnfoldedWidth()
                     .multiply(enclosure.getLength())
                     .multiply(BigDecimal.valueOf(importDTO.getQuantity().intValue()))
                     .divide(BigDecimal.valueOf(1000000L))
               )
               .build();
            this.businessEnclosureService.editBusinessInfo(editDTOParam);
         } else {
            TechEnclosure enclosure = TechEnclosure.builder()
               .projectId(area.getProjectId())
               .areaId(area.getId())
               .userId(UserUtil.getCurrentUserId())
               .boolAbnormalEnum(false)
               .boolStatusEnum(true)
               .build();
            BeanUtil.copy(importDTO, enclosure);
            SysEnclosureDictionary dictionary = this.enclosureDictionaryService.getById(importDTO.getDictionaryId());
            Preconditions.checkArgument(dictionary != null && EnclosureCategoryEnum.isExist(dictionary.getType()), "围护字典类型不存在!");
            enclosure.setCategory(dictionary.getType());
            enclosure.setTotalLength(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getLength()));
            enclosure.setTotalArea(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getSurfaceArea()));
            enclosure.setTotalWeight(new BigDecimal(enclosure.getQuantity()).multiply(enclosure.getWeight()));
            EnclosureAddDTOParam addBusiness = BeanUtil.copy(enclosure, EnclosureAddDTOParam.class);
            addBusiness.setTotalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)));
            addBusiness.setTotalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
            addBusiness.setPricingManner(1);
            Long businessId = this.businessEnclosureService.addBusinessInfo(addBusiness);
            enclosure.setBusinessId(businessId);
            newEnclosureList.add(enclosure);
            newEnclosureMap.put(importDTO.getDictionaryId() + importDTO.getSerialNumber(), enclosure);
         }
      }

      this.enclosureService.updateBatchById(enclosureList);
      this.enclosureService.saveBatch(newEnclosureList);
      newEnclosureList.forEach(enclosurex -> {
         TechDeepenRecord deepenRecord = this.buildDeepenRecord(enclosurex, enclosurex.getQuantity());
         deepenRecordList.add(deepenRecord);
      });
      this.deepenRecordService.saveBatch(deepenRecordList);
      return Boolean.TRUE;
   }

   private boolean extracted(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         this.exportResultV2(mistakeExportDTOList, response);
         return true;
      } else {
         return false;
      }
   }

   private Long saveImportPieceImg(Long projectId, Long enclosurePlanId, String imageUrl) {
      log.info("=====================折边件图片上传地址:" + imageUrl);
      List<String> suffixList = Arrays.asList("jpg", "png", "jpeg");
      String originalFilename = imageUrl.substring(imageUrl.lastIndexOf(File.separator) + 1);
      log.info("上传原文件名========================:" + originalFilename);
      String suffix = FileUtil.getFileExtension(originalFilename);
      boolean anyMatch = suffixList.stream().anyMatch(s -> s.equalsIgnoreCase(suffix));
      Long attachmentId = null;
      if (anyMatch) {
         String relativePath = AttachmentTypeEnum.PLAN.getName()
            + File.separator
            + EnclosureCategoryEnum.FLANG_PIECE.getFileName()
            + File.separator
            + projectId
            + File.separator
            + enclosurePlanId
            + File.separator;
         FileUtil.mkdirs(this.configProperties.getFilePath() + relativePath);
         String name = System.currentTimeMillis() + "_" + originalFilename;
         File file = new File(imageUrl);

         try (InputStream inputStream = new FileInputStream(file)) {
            File outFile = new File(this.configProperties.getFilePath() + relativePath + name);
            boolean boolSave = FileUtil.copyInputStreamToFile(inputStream, outFile);
            if (boolSave) {
               Attachment attachment = Attachment.builder()
                  .name(name)
                  .type(AttachmentTypeEnum.PLAN.getType())
                  .relativePath(relativePath + name)
                  .mediaType("image/*")
                  .createUserId(UserUtil.getCurrentUserId())
                  .createUserName(UserUtil.getCurrentName())
                  .build();
               this.attachmentService.save(attachment);
               attachmentId = attachment.getId();
            }
         } catch (IOException e) {
            log.info("折边件图纸上传失败!");
            e.printStackTrace();
         }

         if (file.exists()) {
            file.delete();
         }
      }

      return attachmentId;
   }

   private void exportResult(List<MistakeExportDTO> mistakeExportDTOList, Integer category, HttpServletResponse response) {
      if (mistakeExportDTOList.isEmpty()) {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("全部导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      } else {
         String name = EnclosureCategoryEnum.getNameByCategory(category);
         ExportParams params = new ExportParams();
         params.setTitle(name + "清单导入出错信息");
         params.setSheetName(name + "清单导入失败表");
         params.setType(ExcelType.XSSF);
         String fileName = name + "清单导入失败信息表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("导入失败，具体信息请查看失败信息表", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         Workbook workbook = ExcelExportUtil.exportExcel(params, MistakeExportDTO.class, mistakeExportDTOList);
         PoiUtils.downLoadExcel(fileName, response, workbook);
         throw new BusinessException(ResultCodeEnum.ERROR, "导入失败!");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importInventory(MultipartFile file, Long areaId, Integer importType, HttpServletResponse response) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(128);

      PlanArea area;
      try {
         Preconditions.checkArgument(ImportTypeEnum.ADD_IMPORT.getType().equals(importType), "导入失败,仅支持增量导入!");
         area = this.areaService.getById(areaId);
         Preconditions.checkArgument(
            area != null && ProjectPlanProductCategoryEnum.ENCLOSURE.getType().equals(area.getProjectPlanProductCategory()), "导入失败,该围护区域不存在"
         );
         this.projectService.checkProjectStatus(area.getProjectId());
         List<MesTechInventoryOperation> mesTechInventoryOperationList = this.mesTechInventoryOperationService
            .list(
               (Wrapper<MesTechInventoryOperation>)(new LambdaQueryWrapper<MesTechInventoryOperation>().eq(MesTechInventoryOperation::getAreaId, areaId))
                  .in(
                     MesTechInventoryOperation::getInventoryReviewedEnum,
                     Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType())
                  )
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(mesTechInventoryOperationList), "导入失败,该区域下存在未审核或待确认的清单导入记录!");
      } catch (Exception exception) {
         mistakeExportDTOList.add(this.getMistakeDTO(0, exception.getMessage()));
         this.exportResultV2(mistakeExportDTOList, response);
         return;
      }

      int titleRows = 1;
      int headerRows = 1;
      Integer startSheetIndex = 0;
      List<EnclosureImportAllDTO> importDTOList = PoiUtils.importExcel(file, titleRows, headerRows, startSheetIndex, EnclosureImportAllDTO.class);
      if (importDTOList.isEmpty()) {
         mistakeExportDTOList.add(this.getMistakeDTO(null, "导入失败,导入的围护清单为空"));
         this.exportResultV2(mistakeExportDTOList, response);
      } else {
         List<EnclosureImportAllDTO> nameAndSerialNumberList = importDTOList.stream()
            .filter(
               e -> org.apache.commons.lang3.StringUtils.isNotBlank(e.getName())
                  || org.apache.commons.lang3.StringUtils.isNotBlank(e.getSerialNumber())
                  || org.apache.commons.lang3.StringUtils.isNotBlank(e.getDictionaryName())
            )
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(nameAndSerialNumberList) && nameAndSerialNumberList.stream().anyMatch(e -> e.getOrderNo() == null)) {
            mistakeExportDTOList.add(this.getMistakeDTO(null, "导入失败,导入的表单序号不能为空!"));
            this.exportResultV2(mistakeExportDTOList, response);
         } else {
            importDTOList = importDTOList.stream().filter(importDTO -> importDTO.getOrderNo() != null).collect(Collectors.toList());
            if (importDTOList.isEmpty()) {
               mistakeExportDTOList.add(this.getMistakeDTO(null, "围护清单的序号不存在!"));
               this.exportResultV2(mistakeExportDTOList, response);
            } else {
               List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
               Map<Long, SysDictionary> sysDictionaryMap = sysDictionaries.stream().collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
               List<String> dictionaryList = sysDictionaries.stream().map(SysDictionary::getLabel).collect(Collectors.toList());
               Set<String> setSerialNumberList = new HashSet<>();
               Map<String, List<TechEnclosure>> enclosureMap = this.enclosureService
                  .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getAreaId, areaId))
                  .stream()
                  .collect(Collectors.groupingBy(TechEnclosure::getSerialNumber));
               Map<String, Long> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(SysDictionary::getLabel, SysDictionary::getId));

               for (EnclosureImportAllDTO importAllDTO : importDTOList) {
                  StringUtils.removeTrimSpaces(importAllDTO, null);
                  if (org.apache.commons.lang3.StringUtils.isBlank(importAllDTO.getName())) {
                     mistakeExportDTOList.add(this.getMistakeDTO(importAllDTO.getOrderNo(), "导入失败,围护名称不能为空"));
                  }

                  if (org.apache.commons.lang3.StringUtils.isBlank(importAllDTO.getPlate())) {
                     mistakeExportDTOList.add(this.getMistakeDTO(importAllDTO.getOrderNo(), "导入失败,围护板型/规格不能为空"));
                  }

                  if (org.apache.commons.lang3.StringUtils.isBlank(importAllDTO.getSerialNumber())) {
                     mistakeExportDTOList.add(this.getMistakeDTO(importAllDTO.getOrderNo(), "导入失败,围护编号不能为空!"));
                  } else {
                     importAllDTO.setSerialNumber(org.apache.commons.lang3.StringUtils.deleteWhitespace(importAllDTO.getSerialNumber()));
                     importAllDTO.setSerialNumber(importAllDTO.getSerialNumber().replaceAll("\\p{Z}+", ""));
                     if (setSerialNumberList.contains(importAllDTO.getSerialNumber())) {
                        mistakeExportDTOList.add(this.getMistakeDTO(importAllDTO.getOrderNo(), "导入失败,围护的编号" + importAllDTO.getSerialNumber() + "在清单中不可重复!"));
                     }

                     if (enclosureMap.containsKey(importAllDTO.getSerialNumber())) {
                        mistakeExportDTOList.add(this.getMistakeDTO(importAllDTO.getOrderNo(), "导入失败,围护的编号" + importAllDTO.getSerialNumber() + "在该区域中已存在!"));
                     }

                     setSerialNumberList.add(importAllDTO.getSerialNumber());
                  }

                  if (org.apache.commons.lang3.StringUtils.isBlank(importAllDTO.getDictionaryName())) {
                     mistakeExportDTOList.add(this.getMistakeDTO(importAllDTO.getOrderNo(), "导入失败,围护类型不能为空!"));
                  } else if (!dictionaryList.contains(importAllDTO.getDictionaryName())) {
                     mistakeExportDTOList.add(this.getMistakeDTO(null, "围护类型(" + importAllDTO.getDictionaryName() + ")不存在!"));
                  } else {
                     importAllDTO.setDictionaryId(enclosureDictMap.get(importAllDTO.getDictionaryName()));
                  }
               }

               if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
                  this.exportResultV2(mistakeExportDTOList, response);
               } else {
                  this.checkFieldV2(importDTOList, mistakeExportDTOList);
                  if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
                     this.exportResultV2(mistakeExportDTOList, response);
                  } else {
                     importDTOList.forEach(
                        e -> {
                           if ("折边件".contains(e.getDictionaryName())) {
                              e.setSurfaceArea(e.getUnfoldedWidth().multiply(e.getLength()));
                           } else {
                              e.setSurfaceArea(e.getWidth().multiply(e.getLength()));
                           }

                           e.setAccountingVolume(e.getLength().multiply(BigDecimal.valueOf(e.getQuantity().intValue())).divide(BigDecimal.valueOf(1000L)));
                           if (!"夹芯板".contains(e.getDictionaryName()) && (e.getWidth() == null || NumberUtil.equals(e.getWidth(), BigDecimal.ZERO))) {
                              e.setWeight(
                                 e.getUnfoldedWidth()
                                    .multiply(e.getThickness())
                                    .multiply(e.getLength())
                                    .multiply(BigDecimal.valueOf(7.85))
                                    .divide(BigDecimal.valueOf(1000000L))
                              );
                           }
                        }
                     );
                     List<TechEnclosure> enclosures = this.enclosureService
                        .list(Wrappers.lambdaQuery(TechEnclosure.builder().projectId(area.getProjectId()).build()));
                     Map<String, Map<String, TechEnclosure>> allDictionarySnMap = enclosures.stream()
                        .collect(
                           Collectors.groupingBy(
                              e -> e.getDictionaryId() + e.getSerialNumber(),
                              Collectors.toMap(TechEnclosure::getSerialNumber, Function.identity(), (existing, replacement) -> existing)
                           )
                        );
                     Map<String, EnclosureImportAllDTO> firstSnMap = new HashMap<>(16);
                     importDTOList.forEach(importDTO -> {
                        Map<String, TechEnclosure> dictionarySnMap = allDictionarySnMap.get(importDTO.getDictionaryId() + importDTO.getSerialNumber());
                        if (dictionarySnMap != null) {
                           if (dictionarySnMap.containsKey(importDTO.getDictionaryId() + importDTO.getSerialNumber())) {
                              TechEnclosure enclosure = dictionarySnMap.get(importDTO.getDictionaryId() + importDTO.getSerialNumber());
                              List<MistakeExportDTO> exportDTOList = this.checkImportEqualsV2(importDTO, enclosure);
                              mistakeExportDTOList.addAll(exportDTOList);
                           } else if (firstSnMap.containsKey(importDTO.getDictionaryId() + importDTO.getSerialNumber())) {
                              EnclosureImportAllDTO enclosureImportDTO = firstSnMap.get(importDTO.getDictionaryId() + importDTO.getSerialNumber());
                              TechEnclosure enclosure = BeanUtil.copy(enclosureImportDTO, TechEnclosure.class);
                              List<MistakeExportDTO> exportDTOList = this.checkImportEqualsV2(importDTO, enclosure);
                              mistakeExportDTOList.addAll(exportDTOList);
                           }
                        } else {
                           firstSnMap.put(importDTO.getDictionaryId() + importDTO.getSerialNumber(), importDTO);
                        }
                     });
                     if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
                        this.exportResultV2(mistakeExportDTOList, response);
                     }

                     MesTechInventoryOperation inventoryOperation = MesTechInventoryOperation.builder()
                        .projectId(area.getProjectId())
                        .monomerId(area.getMonomerId())
                        .areaId(areaId)
                        .importType(importType)
                        .inventoryReviewedEnum(InventoryReviewedEnum.UNAUDITED.getType())
                        .buildingType(InventoryTypeEnum.ENCLOSURE.getType())
                        .operationTypeEnum(OperationTypeEnum.ADD_IMPORT.getType())
                        .importUserId(UserUtil.getCurrentUserId())
                        .createUserName(UserUtil.getCurrentName())
                        .type(2)
                        .build();
                     this.mesTechInventoryOperationService.save(inventoryOperation);
                     List<TechEnclosureRecord> records = importDTOList.stream()
                        .map(
                           s -> {
                              TechEnclosureRecord record = BeanUtil.copy(s, TechEnclosureRecord.class);
                              if ((record.getWeight() == null || record.getWeight().compareTo(BigDecimal.ZERO) == 0)
                                 && (
                                    sysDictionaryMap.get(s.getDictionaryId()).getLabel().equals("折边件")
                                       || sysDictionaryMap.get(s.getDictionaryId()).getLabel().equals("压型彩板")
                                 )) {
                                 record.setWeight(
                                    record.getUnfoldedWidth()
                                       .multiply(record.getThickness())
                                       .multiply(record.getLength())
                                       .multiply(BigDecimal.valueOf(7.85))
                                       .divide(BigDecimal.valueOf(1000000L))
                                 );
                              }

                              if ((record.getWeight() == null || record.getWeight().compareTo(BigDecimal.ZERO) == 0)
                                 && (
                                    sysDictionaryMap.get(s.getDictionaryId()).getLabel().equals("压型楼承板")
                                       || sysDictionaryMap.get(s.getDictionaryId()).getLabel().equals("桁架楼承板")
                                 )) {
                                 record.setWeight(
                                    record.getWidth()
                                       .multiply(record.getThickness())
                                       .multiply(record.getLength())
                                       .multiply(BigDecimal.valueOf(7.85))
                                       .divide(BigDecimal.valueOf(1000000L))
                                 );
                              }

                              record.setInventoryOperationId(inventoryOperation.getId());
                              record.setProjectId(area.getProjectId());
                              record.setMonomerId(area.getMonomerId());
                              record.setAreaId(area.getId());
                              record.setUserId(UserUtil.getCurrentUserId());
                              record.setTotalWeight(s.getWeight().multiply(BigDecimal.valueOf(s.getQuantity().intValue())));
                              record.setTotalArea(s.getSurfaceArea().multiply(BigDecimal.valueOf(s.getQuantity().intValue())));
                              return record;
                           }
                        )
                        .collect(Collectors.toList());
                     this.enclosureRecordService.saveBatch(records);
                     this.exportResultV2(mistakeExportDTOList, response);
                  }
               }
            }
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean commitChangeRecord(EnclosureUpdateDTOParam param) {
      TechEnclosure enclosure = this.enclosureService.getById(param.getId());
      this.mesTechInventoryOperationService
         .checkInventoryOperationByAreaId(
            param.getAreaId(), Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType())
         );
      ContractProject project = this.projectService.checkProjectStatus(enclosure.getProjectId());
      Preconditions.checkArgument(param.getQuantity() >= enclosure.getProducedQuantity() + enclosure.getSubscribeQuantity(), "操作失败,数量不能小于已生产数量+已申购数量");
      boolean boolSame = Objects.equals(param.getName(), enclosure.getName())
         && Objects.equals(param.getSerialNumber(), enclosure.getSerialNumber())
         && Objects.equals(param.getPlate(), enclosure.getPlate())
         && param.getUnfoldedWidth().compareTo(enclosure.getUnfoldedWidth()) == 0
         && param.getLength().compareTo(enclosure.getLength()) == 0
         && param.getThickness().compareTo(enclosure.getThickness()) == 0
         && param.getSurfaceArea().compareTo(enclosure.getSurfaceArea().divide(BigDecimal.valueOf(1000000L))) == 0
         && Objects.equals(param.getRemark(), enclosure.getRemark());
      if (boolSame && param.getQuantity() > enclosure.getQuantity()) {
         enclosure.setQuantity(param.getQuantity());
         this.enclosureService.updateById(enclosure);
         return true;
      }

      if (boolSame && param.getQuantity() == enclosure.getQuantity()) {
         Preconditions.checkArgument(param.getQuantity() != enclosure.getQuantity(), "操作失败,数据未发生变化");
      }

      String yearMonthDay = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
      int sortNumber = this.enclosureChangeRecordService.getSortNumber(project.getId(), yearMonthDay);
      String serialNumber = "变-" + project.getShortName() + "-" + yearMonthDay + "-" + sortNumber;
      TechEnclosureChangeRecord changeRecord = BeanUtil.copy(param, TechEnclosureChangeRecord.class);
      changeRecord.setProjectId(project.getId());
      changeRecord.setMonomerId(enclosure.getMonomerId());
      changeRecord.setAreaId(enclosure.getAreaId());
      changeRecord.setYearMonthDay(yearMonthDay);
      changeRecord.setSortNumber(sortNumber);
      changeRecord.setSerialNumber(serialNumber);
      changeRecord.setType(ArtifactChangeTypeEnum.UPDATE_BASIC.getType());
      changeRecord.setUserId(UserUtil.getCurrentUserId());
      changeRecord.setCheckStatus(CheckStatusEnum.PENDING.getType());
      this.enclosureChangeRecordService.save(changeRecord);
      this.changeBasicUpdtae(param, changeRecord);
      return Boolean.TRUE;
   }

   private void changeBasicUpdtae(EnclosureUpdateDTOParam basicChangeDTOParam, TechEnclosureChangeRecord changeRecord) {
      if (Objects.nonNull(basicChangeDTOParam)) {
         TechEnclosure enclosure = this.enclosureService.getById(basicChangeDTOParam.getId());
         Preconditions.checkArgument(enclosure != null, "操作失败,围护信息不存在");
         Preconditions.checkArgument(enclosure.getBoolStatusEnum(), "操作失败,改围护状态已暂停,不可变更");
         List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
            .list(
               Wrappers.lambdaQuery(
                  MesBuildingWarehouseSummary.builder()
                     .productId(basicChangeDTOParam.getId())
                     .type(WarehouseTypeEnum.INTO.getType())
                     .productType(ProductTypeEnum.ENCLOSURE.getType())
                     .build()
               )
            );
         BigDecimal sumPackageQuantity = warehouseSummaryList.stream()
            .map(MesBuildingWarehouseSummary::getPackageQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal sumCargoQuantity = warehouseSummaryList.stream()
            .map(MesBuildingWarehouseSummary::getCargoQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(
            sumPackageQuantity.add(sumCargoQuantity)
                  .add(BigDecimal.valueOf(enclosure.getSubscribeQuantity().intValue()))
                  .compareTo(BigDecimal.valueOf(basicChangeDTOParam.getQuantity().intValue()))
               <= 0,
            "围护变更数量必须大于已打包装车发运数 + 已申购数量"
         );
         TechEnclosureChangeRecordDetail changeRecordDetail = BeanUtil.copy(enclosure, TechEnclosureChangeRecordDetail.class);
         changeRecordDetail.setChangeRecordId(changeRecord.getId());
         changeRecordDetail.setType(changeRecord.getType());
         changeRecordDetail.setEnclosureId(enclosure.getId());
         boolean equalsZero = basicChangeDTOParam.getQuantity().equals(0);
         if (enclosure.getSchedulingQuantity() == 0) {
            changeRecordDetail.setChangeSerialNumber(basicChangeDTOParam.getSerialNumber());
            changeRecordDetail.setChangeQuantity(basicChangeDTOParam.getQuantity());
            changeRecordDetail.setChangeLength(basicChangeDTOParam.getLength());
            changeRecordDetail.setChangeWeight(
               equalsZero
                  ? BigDecimal.ZERO
                  : basicChangeDTOParam.getTotalWeight().divide(BigDecimal.valueOf(basicChangeDTOParam.getQuantity().intValue()), 4, 4)
            );
            changeRecordDetail.setChangeName(basicChangeDTOParam.getName());
            changeRecordDetail.setChangeDictionaryId(basicChangeDTOParam.getDictionaryId());
            changeRecordDetail.setChangePlate(basicChangeDTOParam.getPlate());
            changeRecordDetail.setChangeWidth(basicChangeDTOParam.getWidth());
            changeRecordDetail.setChangeUnfoldedWidth(basicChangeDTOParam.getUnfoldedWidth());
            changeRecordDetail.setChangeThickness(basicChangeDTOParam.getThickness());
            changeRecordDetail.setChangeSurfaceArea(
               equalsZero
                  ? BigDecimal.ZERO
                  : basicChangeDTOParam.getTotalArea()
                     .divide(BigDecimal.valueOf(basicChangeDTOParam.getQuantity().intValue()), 4, 4)
                     .multiply(BigDecimal.valueOf(1000000L))
            );
            changeRecordDetail.setChangeAccountingVolume(basicChangeDTOParam.getAccountingVolume());
            changeRecordDetail.setChangeRemark(basicChangeDTOParam.getRemark());
         } else {
            changeRecordDetail.setChangeName(basicChangeDTOParam.getName());
            changeRecordDetail.setChangeQuantity(basicChangeDTOParam.getQuantity());
            changeRecordDetail.setChangeUnfoldedWidth(basicChangeDTOParam.getUnfoldedWidth());
            changeRecordDetail.setChangeWeight(
               equalsZero
                  ? BigDecimal.ZERO
                  : basicChangeDTOParam.getTotalWeight().divide(BigDecimal.valueOf(basicChangeDTOParam.getQuantity().intValue()), 4, 4)
            );
            changeRecordDetail.setChangeThickness(basicChangeDTOParam.getThickness());
            changeRecordDetail.setChangeSurfaceArea(
               equalsZero
                  ? BigDecimal.ZERO
                  : basicChangeDTOParam.getTotalArea()
                     .divide(BigDecimal.valueOf(basicChangeDTOParam.getQuantity().intValue()), 4, 4)
                     .multiply(BigDecimal.valueOf(1000000L))
            );
         }

         this.enclosureChangeRecordDetailService.save(changeRecordDetail);
         enclosure.setBoolStatusEnum(Boolean.FALSE);
         this.enclosureService.updateById(enclosure);
      }
   }

   private void exportResultV2(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (mistakeExportDTOList.isEmpty()) {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("全部导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      } else {
         ExportParams params = new ExportParams();
         params.setTitle("围护清单导入出错信息");
         params.setSheetName("围护清单导入出错信息");
         params.setType(ExcelType.XSSF);
         String fileName = "围护清单导入出错信息.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("导入失败，具体信息请查看失败信息表", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         Workbook workbook = ExcelExportUtil.exportExcel(params, MistakeExportDTO.class, mistakeExportDTOList);
         PoiUtils.downLoadExcel(fileName, response, workbook);
         throw new BusinessException(ResultCodeEnum.ERROR, "导入失败!");
      }
   }

   private MistakeExportDTO getMistakeDTO(Integer orderNo, String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(orderNo);
      mistake.setErrorMessage(message);
      return mistake;
   }

   private TechDeepenRecord buildDeepenRecord(TechEnclosure enclosure, Integer importQuantity) {
      return TechDeepenRecord.builder()
         .projectId(enclosure.getProjectId())
         .monomerId(0L)
         .areaId(enclosure.getEnclosurePlanId())
         .productType(ProductTypeEnum.ENCLOSURE.getType())
         .category(enclosure.getCategory())
         .productId(enclosure.getId())
         .quantity(importQuantity)
         .mete(enclosure.getLength().multiply(BigDecimal.valueOf(importQuantity.intValue())))
         .areaMete(enclosure.getLength().multiply(enclosure.getUnfoldedWidth()).multiply(BigDecimal.valueOf(importQuantity.intValue())))
         .userId(UserUtil.getCurrentUserId())
         .build();
   }

   private Boolean getBoolTechnicalType() {
      TechnicalTypeDTO technicalType = this.configService.getTechnicalType();
      return technicalType.getTechnicalType();
   }

   private void checkField(List<EnclosureImportDTO> importDTOList, Integer category, List<MistakeExportDTO> mistakeExportDTOList) {
      importDTOList.forEach(
         importDTO -> {
            Integer orderNo = importDTO.getOrderNo();
            if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getName())) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "名称不能为空"));
            }

            if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getSerialNumber())) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号不能为空"));
            } else {
               if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getPlate()) && !category.equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
                  mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的板型不能为空"));
               }

               if ((
                     category.equals(EnclosureCategoryEnum.SANDWICH_BOARD.getCategory())
                        || category.equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
                  )
                  && (importDTO.getWidth() == null || importDTO.getWidth().compareTo(BigDecimal.ZERO) <= 0)) {
                  mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的有效宽度必须大于0"));
               }

               if (category.equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
                  if (importDTO.getBendTimes() == null || importDTO.getBendTimes() < 1) {
                     mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的弯折次数最低是1次!"));
                  }

                  if (importDTO.getUnfoldedWidth() == null || importDTO.getUnfoldedWidth().compareTo(BigDecimal.ZERO) <= 0) {
                     mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的展宽必须大于0!"));
                  }
               }

               if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
                  mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的单长必须大于0!"));
               }

               if (!category.equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
                  && (importDTO.getThickness() == null || importDTO.getThickness().compareTo(BigDecimal.ZERO) <= 0)) {
                  mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的板厚必须大于0!"));
               }

               if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
                  mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的数量必须大于0!"));
               }
            }
         }
      );
   }

   private void checkFieldV2(List<EnclosureImportAllDTO> importDTOList, List<MistakeExportDTO> mistakeExportDTOList) {
      importDTOList.forEach(
         importDTO -> {
            Integer orderNo = importDTO.getOrderNo();
            if (!this.dictionaries.contains(importDTO.getDictionaryName())
               && (importDTO.getWidth() == null || importDTO.getWidth().compareTo(BigDecimal.ZERO) <= 0)) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的有效宽度必须大于0"));
            }

            if (this.dictionaries.contains(importDTO.getDictionaryName()) && importDTO.getBendTimes() == null) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的折边件必须有折弯次数"));
            }

            if (importDTO.getUnfoldedWidth() == null || importDTO.getUnfoldedWidth().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的展宽必须大于0!"));
            }

            if (importDTO.getLength() == null || importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的单长必须大于0!"));
            }

            if (importDTO.getThickness() == null || importDTO.getThickness().compareTo(BigDecimal.ZERO) <= 0) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的板厚必须大于0!"));
            }

            if (importDTO.getQuantity() == null || importDTO.getQuantity() <= 0) {
               mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号(" + importDTO.getSerialNumber() + ")的数量必须大于0!"));
            }
         }
      );
   }

   private void checkPlateType(
      List<EnclosureImportDTO> importDTOList, Boolean technicalType, List<String> plateList, Integer category, List<MistakeExportDTO> mistakeExportDTOList
   ) {
      List<String> enclosureDictionaryLabels = Collections.emptyList();
      if (category.equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())) {
         enclosureDictionaryLabels = this.enclosureDictionaryService
            .listCodes(true)
            .stream()
            .map(SysTrussFloorPlateCodeDTO::getCode)
            .collect(Collectors.toList());
      } else if (!category.equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
         String plateType = "plate_type";
         enclosureDictionaryLabels = this.enclosureDictionaryService
            .list(Wrappers.lambdaQuery(SysEnclosureDictionary.builder().type(category).name(plateType).build()))
            .stream()
            .map(SysEnclosureDictionary::getLabel)
            .collect(Collectors.toList());
      }

      List<String> finalEnclosureDictionaryLabels = enclosureDictionaryLabels;
      importDTOList.forEach(
         importDTO -> {
            if (!category.equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
               if (technicalType) {
                  if (!plateList.contains(importDTO.getPlate())) {
                     mistakeExportDTOList.add(
                        this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的版型[ " + importDTO.getPlate() + " ]在合同技术交底中未添加!")
                     );
                  }
               } else if (!plateList.contains(importDTO.getPlate()) && !finalEnclosureDictionaryLabels.contains(importDTO.getPlate())) {
                  mistakeExportDTOList.add(
                     this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的版型[ " + importDTO.getPlate() + " ]在围护字典中未配置或者已被禁用!")
                  );
               }
            }
         }
      );
   }

   private List<MistakeExportDTO> checkImportEquals(EnclosureImportDTO importDTO, TechEnclosure enclosure) {
      List<MistakeExportDTO> mistakeExportDTOS = new ArrayList<>();
      if (!Objects.equals(enclosure.getName(), importDTO.getName())) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的名称和已导入的不一致!"));
      }

      if (!Objects.equals(enclosure.getPlate(), importDTO.getPlate())) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的板型和已导入的不一致!"));
      }

      if (enclosure.getLength().compareTo(importDTO.getLength()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的单长和已导入的不一致!"));
      }

      if (!enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
         && enclosure.getThickness().compareTo(importDTO.getThickness()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的板厚和已导入的不一致!"));
      }

      if (enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())
         && enclosure.getUnfoldedWidth().compareTo(importDTO.getUnfoldedWidth()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的展宽和已导入的不一致!"));
      }

      if ((
            enclosure.getCategory().equals(EnclosureCategoryEnum.SANDWICH_BOARD.getCategory())
               || enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
         )
         && enclosure.getWidth().compareTo(importDTO.getWidth()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的有效宽度和已导入的不一致!"));
      }

      return mistakeExportDTOS;
   }

   private List<MistakeExportDTO> checkImportEqualsV2(EnclosureImportAllDTO importDTO, TechEnclosure enclosure) {
      List<MistakeExportDTO> mistakeExportDTOS = new ArrayList<>();
      if (!Objects.equals(enclosure.getName(), importDTO.getName())) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的名称和已导入的不一致!"));
      }

      if (!Objects.equals(enclosure.getPlate(), importDTO.getPlate())) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的板型和已导入的不一致!"));
      }

      if (enclosure.getUnfoldedWidth().compareTo(importDTO.getUnfoldedWidth()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的展宽和已导入的不一致!"));
      }

      if (enclosure.getWidth().compareTo(importDTO.getWidth()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的有效宽度和已导入的不一致!"));
      }

      if (enclosure.getThickness().compareTo(importDTO.getThickness()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的厚度和已导入的不一致!"));
      }

      if (enclosure.getLength().compareTo(importDTO.getLength()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的单长和已导入的不一致!"));
      }

      if (enclosure.getAccountingVolume().compareTo(importDTO.getAccountingVolume()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的核算量和已导入的不一致!"));
      }

      if (importDTO.getSurfaceArea() != null && enclosure.getSurfaceArea().compareTo(importDTO.getSurfaceArea()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的单面积和已导入的不一致!"));
      }

      if (importDTO.getWeight() != null && enclosure.getWeight().compareTo(importDTO.getWeight()) != 0) {
         mistakeExportDTOS.add(this.getMistakeDTO(importDTO.getOrderNo(), "编号(" + importDTO.getSerialNumber() + ")的单重量和已导入的不一致!"));
      }

      return mistakeExportDTOS;
   }

   private void setWith(TechEnclosure enclosure, Boolean technicalType) {
      if (!enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_COLOR_PLATE.getCategory())
         && !enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_FLOOR_BEARING_PLATE.getCategory())) {
         if (enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
            enclosure.setWidth(enclosure.getUnfoldedWidth());
         } else {
            enclosure.setUnfoldedWidth(enclosure.getWidth());
         }
      } else if (technicalType) {
         ContractTechBaseDTO withDTO = this.contractTechService.getWithDTO(enclosure.getProjectId(), enclosure.getCategory(), enclosure.getPlate());
         enclosure.setWidth(withDTO.getEffectiveWidth());
         enclosure.setUnfoldedWidth(withDTO.getUnfoldedWidth());
      } else {
         SysEnclosureDictionary dictionary = this.enclosureDictionaryService
            .getOne(
               Wrappers.lambdaQuery(SysEnclosureDictionary.class)
                  .eq(SysEnclosureDictionary::getLabel, enclosure.getPlate())
                  .eq(SysEnclosureDictionary::getName, "plate_type")
            );
         SysEnclosureDictionaryDetail dictionaryDetail = this.dictionaryDetailService
            .getOne(
               Wrappers.lambdaQuery(SysEnclosureDictionaryDetail.class)
                  .eq(SysEnclosureDictionaryDetail::getEnclosureDictionaryId, dictionary.getId())
                  .eq(SysEnclosureDictionaryDetail::getPlateType, enclosure.getPlate())
            );
         enclosure.setWidth(dictionaryDetail.getEffectiveWidth());
         enclosure.setUnfoldedWidth(dictionaryDetail.getUnfoldedWidth());
      }
   }

   private void setTotal(TechEnclosure enclosure) {
      enclosure.setTotalLength(enclosure.getLength().multiply(BigDecimal.valueOf(enclosure.getQuantity().intValue())));
      if (!enclosure.getCategory().equals(EnclosureCategoryEnum.SANDWICH_BOARD.getCategory())
         && !enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
         && !enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_COLOR_PLATE.getCategory())) {
         enclosure.setSurfaceArea(enclosure.getUnfoldedWidth().multiply(enclosure.getLength()));
         enclosure.setTotalArea(enclosure.getUnfoldedWidth().multiply(enclosure.getTotalLength()));
      } else {
         enclosure.setSurfaceArea(enclosure.getWidth().multiply(enclosure.getLength()));
         enclosure.setTotalArea(enclosure.getWidth().multiply(enclosure.getTotalLength()));
      }

      if (enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())) {
         Boolean technicalType = this.getBoolTechnicalType();
         BigDecimal weightMeter = this.contractTechService.getWeightMeter(enclosure.getProjectId(), enclosure.getPlate());
         if (!technicalType && weightMeter == null) {
            SysEnclosureDictionary dictionary = this.enclosureDictionaryService
               .getOne(
                  Wrappers.lambdaQuery(SysEnclosureDictionary.class)
                     .eq(SysEnclosureDictionary::getCode, enclosure.getPlate())
                     .eq(SysEnclosureDictionary::getName, "weightMeter")
               );
            enclosure.setWeightMeter(new BigDecimal(dictionary.getLabel()));
            enclosure.setWeight(enclosure.getLength().multiply(enclosure.getWeightMeter()).divide(BigDecimal.valueOf(1000L), 8, 4));
            enclosure.setTotalWeight(enclosure.getTotalLength().multiply(enclosure.getWeightMeter()).divide(BigDecimal.valueOf(1000L), 8, 4));
         } else {
            enclosure.setWeightMeter(weightMeter);
            enclosure.setWeight(enclosure.getLength().multiply(weightMeter).divide(BigDecimal.valueOf(1000L), 8, 4));
            enclosure.setTotalWeight(enclosure.getTotalLength().multiply(weightMeter).divide(BigDecimal.valueOf(1000L), 8, 4));
         }
      }

      if (enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_COLOR_PLATE.getCategory())
         || enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_FLOOR_BEARING_PLATE.getCategory())
         || enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
         enclosure.setWeight(
            enclosure.getThickness()
               .multiply(enclosure.getUnfoldedWidth())
               .multiply(BigDecimal.valueOf(7.85))
               .multiply(enclosure.getLength())
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
         );
         enclosure.setTotalWeight(
            enclosure.getThickness()
               .multiply(enclosure.getUnfoldedWidth())
               .multiply(BigDecimal.valueOf(7.85))
               .multiply(enclosure.getTotalLength())
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
         );
      }

      if (enclosure.getCategory().equals(EnclosureCategoryEnum.SANDWICH_BOARD.getCategory())) {
         enclosure.setWeight(
            enclosure.getThickness()
               .multiply(enclosure.getSurfaceArea())
               .multiply(BigDecimal.valueOf(7.85))
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
         );
         enclosure.setTotalWeight(
            enclosure.getThickness()
               .multiply(enclosure.getTotalArea())
               .multiply(BigDecimal.valueOf(7.85))
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
         );
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveEnclosure(Long enclosurePlanId, EnclosureSaveDTOParam saveDTOParam) {
      return Boolean.TRUE;
   }

   private void checkInputIsNull(
      EnclosurePlan enclosurePlan,
      Boolean technicalType,
      List<String> contractPlateTypeList,
      List<String> dictionaryPlateList,
      EnclosureSaveDTOParam saveDTOParam
   ) {
      Preconditions.checkArgument(enclosurePlan.getCategory().equals(AreaProductTypeEnum.EDGEFOLD.getType()) || saveDTOParam.getPlate() != null, "版型不能为空!");
      if (technicalType) {
         Preconditions.checkArgument(
            enclosurePlan.getCategory().equals(AreaProductTypeEnum.EDGEFOLD.getType())
               || saveDTOParam.getPlate() != null && contractPlateTypeList.contains(saveDTOParam.getPlate()),
            "板型(" + saveDTOParam.getPlate() + ")在合同技术交底中未添加!"
         );
      } else {
         Preconditions.checkArgument(
            enclosurePlan.getCategory().equals(AreaProductTypeEnum.EDGEFOLD.getType())
               || saveDTOParam.getPlate() != null
                  && (contractPlateTypeList.contains(saveDTOParam.getPlate()) || dictionaryPlateList.contains(saveDTOParam.getPlate())),
            "板型(" + saveDTOParam.getPlate() + ")在合同技术交底中未添加,也未在字典中配置!"
         );
      }

      Preconditions.checkArgument(
         enclosurePlan.getCategory().equals(AreaProductTypeEnum.TRUSS_FLOOR_PLATE.getType()) || saveDTOParam.getThickness() != null, "板厚不能为空"
      );
      Preconditions.checkArgument(
         !enclosurePlan.getCategory().equals(AreaProductTypeEnum.EDGEFOLD.getType()) || saveDTOParam.getBendTimes() != null && saveDTOParam.getBendTimes() > 0,
         "折边件弯折次数必须大于0"
      );
      if (enclosurePlan.getCategory().equals(AreaProductTypeEnum.SANDWICH_BOARD.getType())
         || enclosurePlan.getCategory().equals(AreaProductTypeEnum.TRUSS_FLOOR_PLATE.getType())) {
         Preconditions.checkArgument(saveDTOParam.getWidth() != null && saveDTOParam.getWidth().compareTo(BigDecimal.ZERO) > 0, "有效宽度必须大于0");
      }

      if (enclosurePlan.getCategory().equals(AreaProductTypeEnum.PRESSURE_PLATE.getType())
         || enclosurePlan.getCategory().equals(AreaProductTypeEnum.PRESSURE_FLOOR_PLATE.getType())) {
         ContractTechBaseDTO withDTO = this.contractTechService.getWithDTO(enclosurePlan.getProjectId(), enclosurePlan.getCategory(), saveDTOParam.getPlate());
         Preconditions.checkArgument(!technicalType || withDTO != null, "合同技术技术交底中未添加该板型!");
         if (withDTO != null) {
            saveDTOParam.setWidth(withDTO.getEffectiveWidth());
            saveDTOParam.setUnfoldedWidth(withDTO.getUnfoldedWidth());
         } else {
            List<SysEnclosureDictionary> dictionaryList = this.enclosureDictionaryService
               .list(
                  Wrappers.lambdaQuery(
                     SysEnclosureDictionary.builder().type(enclosurePlan.getCategory()).name(SysProfiledPlateEnum.PLATE_TYPE.getName()).build()
                  )
               );
            Map<String, Long> plateTypeIdMap = dictionaryList.stream()
               .collect(Collectors.toMap(SysEnclosureDictionary::getLabel, SysEnclosureDictionary::getId));
            Preconditions.checkArgument(plateTypeIdMap.containsKey(saveDTOParam.getPlate()), "请在字典中配置板型!");
            Long dictionaryId = plateTypeIdMap.get(saveDTOParam.getPlate());
            SysEnclosureDictionaryDetail dictionaryDetail = this.dictionaryDetailService
               .getOne(Wrappers.lambdaQuery(SysEnclosureDictionaryDetail.builder().enclosureDictionaryId(dictionaryId).build()));
            saveDTOParam.setWidth(dictionaryDetail.getEffectiveWidth());
            saveDTOParam.setUnfoldedWidth(dictionaryDetail.getUnfoldedWidth());
         }
      }

      if (enclosurePlan.getCategory().equals(AreaProductTypeEnum.EDGEFOLD.getType())) {
         Preconditions.checkArgument(saveDTOParam.getUnfoldedWidth() != null, "折边件的展宽不能为空!");
         Preconditions.checkArgument(saveDTOParam.getBendTimes() != null, "折边件的弯折次数不能为空!");
      }
   }

   private void checkInputIsNullV2(PlanArea area, Boolean technicalType, EnclosureSaveDTOParam saveDTOParam) {
      Preconditions.checkArgument(saveDTOParam.getPlate() != null, "版型不能为空!");
      Preconditions.checkArgument(saveDTOParam.getThickness() != null, "板厚不能为空");
      Preconditions.checkArgument(saveDTOParam.getWidth() != null && saveDTOParam.getWidth().compareTo(BigDecimal.ZERO) > 0, "有效宽度必须大于0");
   }

   private void insertEnclosure(EnclosurePlan enclosurePlan, Integer measureMode, EnclosureSaveDTOParam saveDTOParam) {
      TechEnclosure enclosure = this.enclosureService
         .getOne(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getEnclosurePlanId, enclosurePlan.getId())
               .eq(TechEnclosure::getSerialNumber, saveDTOParam.getSerialNumber())
         );
      Preconditions.checkArgument(enclosure == null, "围护编号已存在!");
      enclosure = TechEnclosure.builder()
         .projectId(enclosurePlan.getProjectId())
         .enclosurePlanId(enclosurePlan.getId())
         .category(enclosurePlan.getCategory())
         .userId(UserUtil.getCurrentUserId())
         .boolStatusEnum(true)
         .boolAbnormalEnum(false)
         .build();
      BeanUtil.copy(saveDTOParam, enclosure);
      if (enclosure.getWidth() == null) {
         enclosure.setWidth(enclosure.getUnfoldedWidth());
      }

      if (enclosure.getUnfoldedWidth() == null) {
         enclosure.setUnfoldedWidth(enclosure.getWidth());
      }

      this.setTotal(enclosure);
      EnclosureAddDTOParam addBusiness = BeanUtil.copy(enclosure, EnclosureAddDTOParam.class);
      addBusiness.setTotalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)));
      addBusiness.setTotalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
      addBusiness.setPricingManner(measureMode);
      Long businessId = this.businessEnclosureService.addBusinessInfo(addBusiness);
      enclosure.setBusinessId(businessId);
      this.enclosureService.save(enclosure);
      TechDeepenRecord deepenRecord = TechDeepenRecord.builder()
         .projectId(enclosure.getProjectId())
         .monomerId(0L)
         .areaId(enclosurePlan.getId())
         .productType(ProductTypeEnum.ENCLOSURE.getType())
         .category(enclosure.getCategory())
         .productId(enclosure.getId())
         .quantity(enclosure.getQuantity())
         .mete(enclosure.getTotalLength())
         .areaMete(enclosure.getTotalArea())
         .userId(UserUtil.getCurrentUserId())
         .build();
      this.deepenRecordService.save(deepenRecord);
   }

   private void insertEnclosureV2(PlanArea area, EnclosureSaveDTOParam saveDTOParam) {
      TechEnclosure enclosure = this.enclosureService
         .getOne(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getAreaId, area.getId())
               .eq(TechEnclosure::getSerialNumber, saveDTOParam.getSerialNumber())
         );
      Preconditions.checkArgument(enclosure == null, "围护编号已存在!");
      enclosure = TechEnclosure.builder()
         .projectId(area.getProjectId())
         .areaId(area.getId())
         .userId(UserUtil.getCurrentUserId())
         .boolStatusEnum(true)
         .boolAbnormalEnum(false)
         .build();
      BeanUtil.copy(saveDTOParam, enclosure);
      if (enclosure.getWidth() == null) {
         enclosure.setWidth(enclosure.getUnfoldedWidth());
      }

      if (enclosure.getUnfoldedWidth() == null) {
         enclosure.setUnfoldedWidth(enclosure.getWidth());
      }

      enclosure.setTotalLength(enclosure.getLength().multiply(BigDecimal.valueOf(enclosure.getQuantity().intValue())));
      enclosure.setTotalArea(enclosure.getWidth().multiply(BigDecimal.valueOf(enclosure.getQuantity().intValue())));
      enclosure.setTotalWeight(enclosure.getWeight().multiply(BigDecimal.valueOf(enclosure.getQuantity().intValue())));
      EnclosureAddDTOParam addBusiness = BeanUtil.copy(enclosure, EnclosureAddDTOParam.class);
      addBusiness.setTotalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)));
      addBusiness.setTotalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
      addBusiness.setPricingManner(1);
      Long businessId = this.businessEnclosureService.addBusinessInfo(addBusiness);
      enclosure.setBusinessId(businessId);
      this.enclosureService.save(enclosure);
      TechDeepenRecord deepenRecord = TechDeepenRecord.builder()
         .projectId(enclosure.getProjectId())
         .monomerId(0L)
         .areaId(area.getId())
         .productType(ProductTypeEnum.ENCLOSURE.getType())
         .category(enclosure.getCategory())
         .productId(enclosure.getId())
         .quantity(enclosure.getQuantity())
         .mete(enclosure.getTotalLength())
         .areaMete(enclosure.getTotalArea())
         .userId(UserUtil.getCurrentUserId())
         .build();
      this.deepenRecordService.save(deepenRecord);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveEnclosureList(Long enclosurePlanId, List<EnclosureSaveDTOParam> saveDTOParamList) {
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(enclosurePlanId);
      Preconditions.checkArgument(enclosurePlan != null, "围护计划不存在!");
      this.projectService.checkProjectStatus(enclosurePlan.getProjectId());
      List<String> plateTypeList = this.contractTechService.listPlate(enclosurePlan.getProjectId(), enclosurePlan.getCategory());
      ContractTech contractTech = this.contractTechService
         .getOne(Wrappers.lambdaQuery(ContractTech.builder().projectId(enclosurePlan.getProjectId()).type(enclosurePlan.getCategory()).build()));
      Integer measureMode = contractTech.getMeasureMode();
      Boolean boolTechnicalType = this.getBoolTechnicalType();
      List<String> dictionaryPlateList = Collections.emptyList();
      if (!enclosurePlan.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
         List<SysEnclosureDictionary> enclosureDictionaryList = this.enclosureDictionaryService
            .list(
               Wrappers.lambdaQuery(SysEnclosureDictionary.class)
                  .eq(SysEnclosureDictionary::getType, enclosurePlan.getCategory())
                  .eq(
                     enclosurePlan.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory()), SysEnclosureDictionary::getStatus, true
                  )
            );
         if (enclosurePlan.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())) {
            dictionaryPlateList = enclosureDictionaryList.stream().map(SysEnclosureDictionary::getCode).distinct().collect(Collectors.toList());
         } else {
            dictionaryPlateList = enclosureDictionaryList.stream()
               .filter(s -> s.getName().equals(SysProfiledPlateEnum.PLATE_TYPE.getName()))
               .map(SysEnclosureDictionary::getLabel)
               .collect(Collectors.toList());
         }
      }

      List<String> finalDictionaryPlateList = dictionaryPlateList;
      saveDTOParamList.forEach(saveDTOParam -> {
         saveDTOParam.setSurfaceArea(saveDTOParam.getSurfaceArea().multiply(BigDecimal.valueOf(1000000L)));
         this.checkInputIsNull(enclosurePlan, boolTechnicalType, plateTypeList, finalDictionaryPlateList, saveDTOParam);
         this.checkSaveEquals(saveDTOParam, enclosurePlan.getProjectId(), null);
         this.insertEnclosure(enclosurePlan, measureMode, saveDTOParam);
      });
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveEnclosureListV2(Long areaId, List<EnclosureSaveDTOParam> saveDTOParamList) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null && area.getProjectPlanProductCategory() == ProjectPlanProductCategoryEnum.ENCLOSURE.getType(), "围护区域不存在!");
      this.projectService.checkProjectStatus(area.getProjectId());
      this.mesTechInventoryOperationService
         .checkInventoryOperationByAreaId(areaId, Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType()));
      Set<String> serialNumberList = saveDTOParamList.stream().map(e -> e.getSerialNumber()).collect(Collectors.toSet());
      Preconditions.checkArgument(
         saveDTOParamList.stream().map(e -> e.getSerialNumber()).collect(Collectors.toSet()).size() == saveDTOParamList.size(), "编号不能重复"
      );
      List<TechEnclosure> enclosures = this.enclosureService.list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getAreaId, areaId));
      List<TechEnclosure> enclosureList = enclosures.stream().filter(e -> serialNumberList.contains(e.getSerialNumber())).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(enclosureList)) {
         String sb = enclosureList.stream().map(TechEnclosure::getSerialNumber).collect(Collectors.joining(","));
         Preconditions.checkArgument(false, sb + "编号已存在");
      }

      MesTechInventoryOperation inventoryOperation = MesTechInventoryOperation.builder()
         .projectId(area.getProjectId())
         .monomerId(area.getMonomerId())
         .areaId(areaId)
         .importType(1)
         .buildingType(4)
         .totalWeight(saveDTOParamList.stream().filter(e -> e.getWeight() != null).map(e -> e.getWeight()).reduce(BigDecimal.ZERO, BigDecimal::add))
         .inventoryReviewedEnum(InventoryReviewedEnum.UNAUDITED.getType())
         .operationTypeEnum(OperationTypeEnum.ADD_IMPORT.getType())
         .importUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .type(2)
         .build();
      this.mesTechInventoryOperationService.save(inventoryOperation);
      List<TechEnclosureRecord> techEnclosureRecords = new ArrayList<>();
      saveDTOParamList.forEach(
         saveDTOParam -> {
            this.checkSaveEquals(saveDTOParam, area.getProjectId(), saveDTOParam.getDictionaryId());
            TechEnclosureRecord record = BeanUtil.copy(saveDTOParam, TechEnclosureRecord.class);
            record.setProjectId(area.getProjectId());
            record.setMonomerId(area.getMonomerId());
            record.setAreaId(area.getId());
            record.setInventoryOperationId(inventoryOperation.getId());
            record.setUserId(UserUtil.getCurrentUserId());
            record.setSurfaceArea(saveDTOParam.getSurfaceArea().multiply(BigDecimal.valueOf(1000000L)));
            record.setTotalArea(
               saveDTOParam.getSurfaceArea().multiply(BigDecimal.valueOf(saveDTOParam.getQuantity().intValue()).multiply(BigDecimal.valueOf(1000000L)))
            );
            record.setTotalWeight(saveDTOParam.getWeight().multiply(BigDecimal.valueOf(saveDTOParam.getQuantity().intValue())));
            techEnclosureRecords.add(record);
         }
      );
      this.enclosureRecordService.saveBatch(techEnclosureRecords);
      return Boolean.TRUE;
   }

   private void checkSaveEquals(EnclosureSaveDTOParam param, Long projectId, Long dictionaryId) {
      Map<String, TechEnclosure> enclosureMap = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .eq(TechEnclosure::getDictionaryId, dictionaryId)
               .eq(TechEnclosure::getSerialNumber, param.getSerialNumber())
         )
         .stream()
         .collect(Collectors.toMap(TechEnclosure::getSerialNumber, Function.identity(), (s1, s2) -> s1));
      TechEnclosure enclosure = enclosureMap.get(param.getSerialNumber());
      if (enclosure != null) {
         Preconditions.checkArgument(enclosure.getName().equals(param.getName()), "名称和已存在的相同编号的名称不一致!");
         Preconditions.checkArgument(Objects.equals(enclosure.getPlate(), param.getPlate()), "板型和已存在的相同编号的板型不一致!");
         Preconditions.checkArgument(
            param.getUnfoldedWidth() == null || param.getUnfoldedWidth().compareTo(enclosure.getUnfoldedWidth()) == 0, "展宽和已存在的相同编号的展宽不相同!"
         );
         Preconditions.checkArgument(param.getWidth() == null || param.getWidth().compareTo(enclosure.getWidth()) == 0, "有效宽度和已存在的相同编号的有效宽度不相同!");
         Preconditions.checkArgument(param.getThickness().equals(enclosure.getThickness()), "板厚和已存在的相同编号的板厚不相同!");
         Preconditions.checkArgument(param.getUnit().compareTo(enclosure.getUnit()) == 0, "计量单位和已存在的相同编号的计量单位不相同!");
         Preconditions.checkArgument(Objects.equals(param.getMaterial(), enclosure.getMaterial()), "材质和已存在的相同编号的材质不相同!");
         Preconditions.checkArgument(Objects.equals(param.getBrand(), enclosure.getBrand()), "品牌和已存在的相同编号的品牌不相同!");
         Preconditions.checkArgument(Objects.equals(param.getColor(), enclosure.getColor()), "颜色和已存在的相同编号的颜色不相同!");
         Preconditions.checkArgument(Objects.equals(param.getCoating(), enclosure.getCoating()), "涂层和已存在的相同编号的涂层不相同!");
         Preconditions.checkArgument(Objects.equals(param.getPlating(), enclosure.getPlating()), "镀层和已存在的相同编号的镀层不相同!");
      }
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateEnclosure(EnclosureUpdateDTOParam updateDTOParam) {
      TechEnclosure enclosure = this.enclosureService.getById(updateDTOParam.getId());
      Preconditions.checkArgument(enclosure != null, "围护不存在");
      this.projectService.checkProjectStatus(enclosure.getProjectId());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Preconditions.checkArgument(currentUser.isAdmin() || currentUser.getId().equals(enclosure.getUserId()), "您无权限修改!");
      ContractTech contractTech = this.contractTechService
         .getOne(Wrappers.lambdaQuery(ContractTech.builder().projectId(enclosure.getProjectId()).type(enclosure.getCategory()).build()));
      List<String> plateTypeList = this.contractTechService.listPlate(enclosure.getProjectId(), enclosure.getCategory());
      this.checkUpdate(updateDTOParam, enclosure, plateTypeList);
      EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
         .businessId(enclosure.getBusinessId())
         .quantity(-enclosure.getQuantity())
         .totalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)).negate())
         .totalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)).negate())
         .build();
      this.businessEnclosureService.editBusinessInfo(editDTOParam);
      BeanUtil.copy(updateDTOParam, enclosure);
      if (enclosure.getWidth() == null) {
         enclosure.setWidth(enclosure.getUnfoldedWidth());
      }

      if (enclosure.getUnfoldedWidth() == null) {
         enclosure.setUnfoldedWidth(enclosure.getWidth());
      }

      this.setTotal(enclosure);
      EnclosureAddDTOParam newBusiness = BeanUtil.copy(enclosure, EnclosureAddDTOParam.class);
      newBusiness.setQuantity(enclosure.getQuantity());
      newBusiness.setTotalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)));
      newBusiness.setTotalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)));
      newBusiness.setPricingManner(contractTech.getMeasureMode());
      Long businessId = this.businessEnclosureService.addBusinessInfo(newBusiness);
      enclosure.setBusinessId(businessId);
      enclosure.setUserId(currentUser.getId());
      this.enclosureService.updateById(enclosure);
      return true;
   }

   private void checkUpdate(EnclosureUpdateDTOParam updateDTOParam, TechEnclosure enclosure, List<String> plateTypeList) {
      Preconditions.checkArgument(enclosure.getBoolStatusEnum(), "围护处于暂停状态!");
      if (!updateDTOParam.getSerialNumber().equals(enclosure.getSerialNumber())) {
         TechEnclosure techEnclosure = this.enclosureService
            .getOne(
               Wrappers.lambdaQuery(
                  TechEnclosure.builder().enclosurePlanId(enclosure.getEnclosurePlanId()).serialNumber(updateDTOParam.getSerialNumber()).build()
               )
            );
         Preconditions.checkArgument(techEnclosure == null, "编号已存在!");
      }

      Preconditions.checkArgument(updateDTOParam.getQuantity() >= enclosure.getSchedulingQuantity(), "修改数量不能小于已排产数!");
      Preconditions.checkArgument(updateDTOParam.getQuantity() >= enclosure.getSubscribeQuantity(), "修改数量不能小于已申购数量!");
      Preconditions.checkArgument(updateDTOParam.getQuantity() >= enclosure.getSchedulingQuantity() + enclosure.getSubscribeQuantity(), "修改数量超出数量限制!!");
      Boolean boolTechnicalType = this.getBoolTechnicalType();
      if (boolTechnicalType) {
         Preconditions.checkArgument(
            enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())
               || updateDTOParam.getPlate() != null && plateTypeList.contains(updateDTOParam.getPlate()),
            "板型在合同技术交底中未添加"
         );
      }

      Preconditions.checkArgument(
         enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory()) || updateDTOParam.getThickness() != null, "板厚不能为空"
      );
      Preconditions.checkArgument(
         !enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())
            || updateDTOParam.getBendTimes() != null && updateDTOParam.getBendTimes() > 0,
         "折边件弯折次数必须大于0"
      );
      if (!enclosure.getCategory().equals(EnclosureCategoryEnum.SANDWICH_BOARD.getCategory())
         && !enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())) {
         if (enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_COLOR_PLATE.getCategory())
            || enclosure.getCategory().equals(EnclosureCategoryEnum.PRESSURE_FLOOR_BEARING_PLATE.getCategory())) {
            ContractTechBaseDTO withDTO = this.contractTechService.getWithDTO(enclosure.getProjectId(), enclosure.getCategory(), updateDTOParam.getPlate());
            if (boolTechnicalType) {
               Preconditions.checkArgument(withDTO != null, "合同技术交底中未添加该板型!");
               updateDTOParam.setWidth(withDTO.getEffectiveWidth());
               updateDTOParam.setUnfoldedWidth(withDTO.getUnfoldedWidth());
            } else if (withDTO != null) {
               updateDTOParam.setWidth(withDTO.getEffectiveWidth());
               updateDTOParam.setUnfoldedWidth(withDTO.getUnfoldedWidth());
            } else {
               String plate = "plate_type";
               List<SysEnclosureDictionary> dictionaryList = this.enclosureDictionaryService
                  .list(Wrappers.lambdaQuery(SysEnclosureDictionary.builder().type(enclosure.getCategory()).name(plate).build()));
               Map<String, Long> plateTypeIdMap = dictionaryList.stream()
                  .collect(Collectors.toMap(SysEnclosureDictionary::getLabel, SysEnclosureDictionary::getId));
               Preconditions.checkArgument(plateTypeIdMap.containsKey(updateDTOParam.getPlate()), "请在字典中配置板型!");
               Long dictionaryId = plateTypeIdMap.get(updateDTOParam.getPlate());
               SysEnclosureDictionaryDetail dictionaryDetail = this.dictionaryDetailService
                  .getOne(
                     (Wrapper<SysEnclosureDictionaryDetail>)new LambdaQueryWrapper<SysEnclosureDictionaryDetail>().eq(SysEnclosureDictionaryDetail::getEnclosureDictionaryId, dictionaryId)
                  );
               updateDTOParam.setWidth(dictionaryDetail.getEffectiveWidth());
               updateDTOParam.setUnfoldedWidth(dictionaryDetail.getUnfoldedWidth());
            }
         } else if (enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
            Preconditions.checkArgument(
               updateDTOParam.getUnfoldedWidth() == null || updateDTOParam.getUnfoldedWidth().compareTo(BigDecimal.ZERO) > 0, "展宽必须大于0"
            );
         }
      } else {
         Preconditions.checkArgument(updateDTOParam.getWidth() == null || updateDTOParam.getWidth().compareTo(BigDecimal.ZERO) > 0, "有效宽度必须大于0");
      }
   }

   private void checkUpdateEquals(EnclosureUpdateDTOParam param, TechEnclosure enclosure) {
      if (param.getSerialNumber().equals(enclosure.getSerialNumber())) {
         List<TechEnclosure> enclosureList = this.enclosureService
            .list(
               Wrappers.lambdaQuery(
                  TechEnclosure.builder()
                     .projectId(enclosure.getProjectId())
                     .category(enclosure.getCategory())
                     .serialNumber(enclosure.getSerialNumber())
                     .build()
               )
            );
         if (enclosureList.size() > 1) {
            Preconditions.checkArgument(enclosure.getName().equals(param.getName()), "名称和已存在的相同编号的名称不一致!");
            Preconditions.checkArgument(Objects.equals(enclosure.getPlate(), param.getPlate()), "板型和已存在的相同编号的板型不一致!");
            Preconditions.checkArgument(
               param.getUnfoldedWidth() == null || param.getUnfoldedWidth().compareTo(enclosure.getUnfoldedWidth()) == 0, "展宽和已存在的相同编号的展看不相同!"
            );
            Preconditions.checkArgument(param.getWidth() == null || param.getWidth().compareTo(enclosure.getWidth()) == 0, "有效宽度和已存在的相同编号的有效宽度不相同!");
            Preconditions.checkArgument(
               enclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
                  || param.getThickness().compareTo(enclosure.getThickness()) == 0,
               "板厚和已存在的相同编号的板厚不相同!"
            );
            Preconditions.checkArgument(param.getLength().compareTo(enclosure.getLength()) == 0, "单长度和已存在的相同编号的单长度不相同!");
            Preconditions.checkArgument(Objects.equals(param.getMaterial(), enclosure.getMaterial()), "材质和已存在的相同编号的材质不相同!");
            Preconditions.checkArgument(Objects.equals(param.getBrand(), enclosure.getBrand()), "品牌和已存在的相同编号的品牌不相同!");
            Preconditions.checkArgument(Objects.equals(param.getColor(), enclosure.getColor()), "颜色和已存在的相同编号的颜色不相同!");
            Preconditions.checkArgument(Objects.equals(param.getCoating(), enclosure.getCoating()), "涂层和已存在的相同编号的涂层不相同!");
            Preconditions.checkArgument(Objects.equals(param.getPlating(), enclosure.getPlating()), "镀层和已存在的相同编号的镀层不相同!");
            Preconditions.checkArgument(param.getBendTimes() == null || param.getBendTimes().equals(enclosure.getBendTimes()), "弯折次数和已存在的相同编号的弯折次数不相同!");
         }
      } else {
         Map<String, TechEnclosure> enclosureMap = this.enclosureService
            .list(
               Wrappers.lambdaQuery(
                  TechEnclosure.builder().projectId(enclosure.getProjectId()).category(enclosure.getCategory()).serialNumber(param.getSerialNumber()).build()
               )
            )
            .stream()
            .collect(Collectors.toMap(TechEnclosure::getSerialNumber, Function.identity(), (s1, s2) -> s1));
         TechEnclosure techEnclosure = enclosureMap.get(param.getSerialNumber());
         if (techEnclosure != null) {
            Preconditions.checkArgument(enclosure.getName().equals(param.getName()), "名称和已存在的相同编号的名称不一致!");
            Preconditions.checkArgument(Objects.equals(techEnclosure.getPlate(), param.getPlate()), "板型和已存在的相同编号的板型不一致!");
            Preconditions.checkArgument(
               param.getUnfoldedWidth() == null || param.getUnfoldedWidth().compareTo(techEnclosure.getUnfoldedWidth()) == 0, "展宽和已存在的相同编号的展看不相同!"
            );
            Preconditions.checkArgument(param.getWidth() == null || param.getWidth().compareTo(techEnclosure.getWidth()) == 0, "有效宽度和已存在的相同编号的有效宽度不相同!");
            Preconditions.checkArgument(
               techEnclosure.getCategory().equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())
                  || param.getThickness().compareTo(techEnclosure.getThickness()) == 0,
               "板厚和已存在的相同编号的板厚不相同!"
            );
            Preconditions.checkArgument(param.getLength().compareTo(techEnclosure.getLength()) == 0, "单长度和已存在的相同编号的单长度不相同!");
            Preconditions.checkArgument(Objects.equals(param.getMaterial(), techEnclosure.getMaterial()), "材质和已存在的相同编号的材质不相同!");
            Preconditions.checkArgument(Objects.equals(param.getBrand(), techEnclosure.getBrand()), "品牌和已存在的相同编号的品牌不相同!");
            Preconditions.checkArgument(Objects.equals(param.getColor(), techEnclosure.getColor()), "颜色和已存在的相同编号的颜色不相同!");
            Preconditions.checkArgument(Objects.equals(param.getCoating(), techEnclosure.getCoating()), "涂层和已存在的相同编号的涂层不相同!");
            Preconditions.checkArgument(Objects.equals(param.getPlating(), techEnclosure.getPlating()), "镀层和已存在的相同编号的镀层不相同!");
            Preconditions.checkArgument(param.getBendTimes() == null || param.getBendTimes().equals(techEnclosure.getBendTimes()), "弯折次数和已存在的相同编号的弯折次数不相同!");
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean oneClear(Long enclosurePlanId) {
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(enclosurePlanId);
      Preconditions.checkArgument(enclosurePlan != null, "围护计划不存在!");
      this.projectService.checkProjectStatus(enclosurePlan.getProjectId());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<TechEnclosure> enclosureList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getEnclosurePlanId, enclosurePlanId)
               .eq(TechEnclosure::getBoolStatusEnum, BoolStatusEnum.NORMAL.getType())
         );
      List<Long> removeIds = new ArrayList<>(16);
      List<Long> removeBusinessIds = new ArrayList<>(16);
      Preconditions.checkArgument(!enclosureList.stream().anyMatch(e -> e.getSchedulingQuantity() > 0), "存在已经排产数据无法一键清空");
      enclosureList.forEach(
         e -> {
            if (e.getSchedulingQuantity() == 0 && e.getSubscribeQuantity() == 0 && (currentUser.isAdmin() || currentUser.getId().equals(e.getUserId()))) {
               removeIds.add(e.getId());
               EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
                  .businessId(e.getBusinessId())
                  .quantity(-e.getQuantity())
                  .totalLength(e.getTotalLength().divide(BigDecimal.valueOf(1000L)).negate())
                  .totalArea(e.getTotalArea().divide(BigDecimal.valueOf(1000000L)).negate())
                  .build();
               this.businessEnclosureService.editBusinessInfo(editDTOParam);
               BusinessEnclosure businessEnclosure = this.businessEnclosureService.getById(e.getBusinessId());
               if (businessEnclosure == null) {
                  removeBusinessIds.add(e.getBusinessId());
               }
            }
         }
      );
      this.enclosureService.removeByIds(removeIds);
      if (CollectionUtils.isNotEmpty(removeBusinessIds)) {
         this.removeBusiness(removeBusinessIds);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean enclosureAreaClear(Long areaId) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "围护区域不存在!");
      this.projectService.checkProjectStatus(area.getProjectId());
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<TechEnclosure> enclosureList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getAreaId, area.getId())
               .eq(TechEnclosure::getBoolStatusEnum, BoolStatusEnum.NORMAL.getType())
         );
      List<Long> removeIds = new ArrayList<>(16);
      List<Long> removeBusinessIds = new ArrayList<>(16);
      this.enclosureChangeRecordService.checkChangeRecordByAreaId(areaId);
      Preconditions.checkArgument(!enclosureList.stream().anyMatch(e -> e.getSchedulingQuantity() > 0), "存在已经排产数据无法一键清空");
      Preconditions.checkArgument(!enclosureList.stream().anyMatch(e -> e.getSubscribeQuantity() > 0), "存在已经申购数据，请先清除申购");
      enclosureList.forEach(
         e -> {
            if (e.getSchedulingQuantity() == 0 && (currentUser.isAdmin() || currentUser.getId().equals(e.getUserId()))) {
               removeIds.add(e.getId());
               EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
                  .businessId(e.getBusinessId())
                  .quantity(-e.getQuantity())
                  .totalLength(e.getTotalLength().divide(BigDecimal.valueOf(1000L)).negate())
                  .totalArea(e.getTotalArea().divide(BigDecimal.valueOf(1000000L)).negate())
                  .build();
               this.businessEnclosureService.editBusinessInfo(editDTOParam);
               BusinessEnclosure businessEnclosure = this.businessEnclosureService.getById(e.getBusinessId());
               if (businessEnclosure == null) {
                  removeBusinessIds.add(e.getBusinessId());
               }
            }
         }
      );
      this.enclosureService.removeByIds(removeIds);
      if (CollectionUtils.isNotEmpty(removeBusinessIds)) {
         this.removeBusiness(removeBusinessIds);
      }

      return Boolean.TRUE;
   }

   private void removeBusiness(List<Long> removeBusinessIds) {
      this.businessPriceTempService
         .remove(
            Wrappers.lambdaQuery(BusinessPriceTemp.class)
               .eq(BusinessPriceTemp::getType, ProductTypeEnum.ENCLOSURE.getType())
               .in(BusinessPriceTemp::getBusinessId, removeBusinessIds)
         );
      List<BusinessCheckDetail> checkDetailList = this.businessCheckDetailService
         .list(
            Wrappers.lambdaQuery(BusinessCheckDetail.class)
               .eq(BusinessCheckDetail::getType, ProductTypeEnum.ENCLOSURE.getType())
               .in(BusinessCheckDetail::getBusinessId, removeBusinessIds)
         );
      if (CollectionUtils.isNotEmpty(checkDetailList)) {
         Map<Long, List<BusinessCheckDetail>> checkInfoIdGroupMap = checkDetailList.stream()
            .collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         List<BusinessCheckDetail> checkDetails = this.businessCheckDetailService
            .list(
               Wrappers.lambdaQuery(BusinessCheckDetail.class)
                  .eq(BusinessCheckDetail::getType, ProductTypeEnum.ENCLOSURE.getType())
                  .in(BusinessCheckDetail::getCheckInfoId, checkInfoIdGroupMap.keySet())
            );
         Map<Long, List<BusinessCheckDetail>> checkInfoIdDetailsMap = checkDetails.stream().collect(Collectors.groupingBy(BusinessCheckDetail::getCheckInfoId));
         checkInfoIdGroupMap.forEach((checkInfoId, details) -> {
            List<BusinessCheckDetail> detailList = checkInfoIdDetailsMap.get(checkInfoId);
            this.businessCheckDetailService.removeByIds(details.stream().map(BusinessCheckDetail::getId).collect(Collectors.toList()));
            if (details.size() == detailList.size()) {
               this.businessCheckInfoService.removeById(checkInfoId);
            }
         });
      }
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateStatus(Long enclosureId, Boolean boolStatusEnum) {
      TechEnclosure enclosure = this.enclosureService.getById(enclosureId);
      Preconditions.checkArgument(enclosure != null, "该围护不存在");
      this.projectService.checkProjectStatus(enclosure.getProjectId());
      enclosure.setBoolStatusEnum(boolStatusEnum);
      enclosure.setBoolAbnormalEnum(!boolStatusEnum);
      this.enclosureService.updateById(enclosure);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateStatusV2(Long enclosureId, Boolean boolStatusEnum) {
      TechEnclosure enclosure = this.enclosureService.getById(enclosureId);
      Preconditions.checkArgument(enclosure != null, "该围护不存在");
      this.projectService.checkProjectStatus(enclosure.getProjectId());
      this.mesTechInventoryOperationService
         .checkInventoryOperationByAreaId(enclosure.getAreaId(), Collections.singletonList(InventoryReviewedEnum.UNAUDITED.getType()));
      this.enclosureChangeRecordService.checkChangeRecordByEnclosureId(enclosure.getId());
      enclosure.setBoolStatusEnum(boolStatusEnum);
      enclosure.setBoolAbnormalEnum(!boolStatusEnum);
      this.enclosureService.updateById(enclosure);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteEnclosure(List<Long> enclosureIds) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      List<Long> businessIds = new ArrayList<>();
      enclosureIds.forEach(
         enclosureId -> {
            TechEnclosure enclosure = this.enclosureService.getById(enclosureId);
            Preconditions.checkArgument(enclosure != null, "该围护不存在");
            this.projectService.checkProjectStatus(enclosure.getProjectId());
            this.enclosureChangeRecordService.checkChangeRecordByEnclosureId(enclosure.getId());
            Preconditions.checkArgument(enclosure.getSchedulingQuantity() == 0, "删除失败,围护已进行排产!");
            Preconditions.checkArgument(enclosure.getSubscribeQuantity() == 0, "删除失败,围护已进行创建申购!");
            Preconditions.checkArgument(
               currentUser.isAdmin() || currentUser.getId().equals(enclosure.getUserId()), "您无权限删除编号[" + enclosure.getSerialNumber() + "]!"
            );
            this.enclosureService.removeById(enclosureId);
            EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
               .businessId(enclosure.getBusinessId())
               .quantity(-enclosure.getQuantity())
               .totalLength(enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L)).negate())
               .totalArea(enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L)).negate())
               .build();
            this.businessEnclosureService.editBusinessInfo(editDTOParam);
            BusinessEnclosure businessEnclosure = this.businessEnclosureService.getById(enclosure.getBusinessId());
            if (businessEnclosure == null) {
               businessIds.add(enclosure.getBusinessId());
            }
         }
      );
      if (CollectionUtils.isNotEmpty(businessIds)) {
         this.removeBusiness(businessIds);
      }

      return Boolean.TRUE;
   }

   @Override
   public EnclosureDTO getEnclosureDTOById(Long id) {
      TechEnclosure enclosure = this.enclosureService.getById(id);
      Preconditions.checkArgument(enclosure != null, "围护不存在,传入的围护id可能有误!");
      EnclosureDTO enclosureDTO = BeanUtil.copy(enclosure, EnclosureDTO.class);
      ProjectInfo project = this.projectService.getSimpleById(enclosure.getProjectId());
      enclosureDTO.setProject(project);
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      enclosureDTO.setDictionaryName(enclosureDictMap.get(enclosureDTO.getDictionaryId()));
      PlanArea area = this.areaService.getById(enclosure.getAreaId());
      PlanMonomer monomer = this.planMonomerService.getById(area.getMonomerId());
      NameInfo areaInfo = NameInfo.builder().id(area.getId()).name(area.getName()).build();
      NameInfo monomerInfo = NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build();
      enclosureDTO.setArea(areaInfo);
      enclosureDTO.setMonomer(monomerInfo);
      enclosureDTO.setUserName(this.userService.getNameById(enclosure.getUserId()));
      return enclosureDTO;
   }

   @Override
   public EnclosureDTO getEnclosureDTOByIdV2(Long id) {
      TechEnclosure enclosure = this.enclosureService.getById(id);
      Preconditions.checkArgument(enclosure != null, "围护不存在,传入的围护id可能有误!");
      EnclosureDTO enclosureDTO = BeanUtil.copy(enclosure, EnclosureDTO.class);
      ProjectInfo project = this.projectService.getSimpleById(enclosure.getProjectId());
      enclosureDTO.setProject(project);
      PlanArea area = this.areaService.getById(enclosure.getEnclosurePlanId());
      NameInfo areaInfo = NameInfo.builder().id(area.getId()).name(area.getName()).build();
      enclosureDTO.setArea(areaInfo);
      enclosureDTO.setUserName(this.userService.getNameById(enclosure.getUserId()));
      return enclosureDTO;
   }

   @Override
   public List<EnclosureProjectSchedulingStateDTO> listByType(Integer year, Integer state, String name, Integer projectType, Integer lumpSumSystemType) {
      List<EnclosureProjectSchedulingStateDTO> schedulings = this.enclosureService.listByType(year, name);
      schedulings = schedulings.stream().filter(s -> s.getQuantity() > s.getSchedulingQuantity() + s.getSubscribeQuantity()).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(schedulings)) {
         return new ArrayList<>();
      }

      List<ProjectSimpleInfoDTO> projects = this.contractProjectBiz.listSimpleProjectInfo(projectType, null, null, null, lumpSumSystemType, null);
      List<Long> userProjectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      projects = projects.stream().filter(s -> userProjectIds.contains(s.getId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projects)) {
         return new ArrayList<>();
      }

      List<Long> projectIds = projects.stream().map(ProjectSimpleInfoDTO::getId).collect(Collectors.toList());
      List<EnclosureProjectSchedulingStateDTO> schedulingStateDTOS = new ArrayList<>();
      Map<Long, List<EnclosureProjectSchedulingStateDTO>> projectMap = schedulings.stream().collect(Collectors.groupingBy(s -> s.getProject().getId()));

      for (Long id : projectMap.keySet()) {
         List<EnclosureProjectSchedulingStateDTO> dtos = projectMap.get(id);
         EnclosureProjectSchedulingStateDTO build = EnclosureProjectSchedulingStateDTO.builder().build();
         build.setProject(dtos.get(0).getProject());
         long count = dtos.stream().filter(s -> s.getSchedulingQuantity() > 0).count();
         if (count > 0L) {
            long count1 = dtos.stream().filter(s -> s.getQuantity() > s.getSchedulingQuantity()).count();
            if (count1 > 0L) {
               build.setStatus(2);
            } else {
               build.setStatus(4);
            }
         } else {
            build.setStatus(1);
         }

         schedulingStateDTOS.add(build);
      }

      if (state != null) {
         schedulingStateDTOS = schedulingStateDTOS.stream().filter(s -> s.getStatus().equals(state)).collect(Collectors.toList());
      }

      return schedulingStateDTOS.stream()
         .filter(s -> projectIds.contains(s.getProject().getId()))
         .filter(s -> !s.getStatus().equals(4))
         .sorted(Comparator.comparing(s -> s.getProject().getId()))
         .sorted(Comparator.comparing(EnclosureProjectSchedulingStateDTO::getStatus))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectSchedulingTreeDO> enclosureSchedulingTree(Integer year, Integer state, String name) {
      List<ProjectSchedulingTreeDO> schedulingTree = this.enclosureService.getSchedulingTree(year, name);
      if (state != null) {
         schedulingTree = schedulingTree.stream()
            .peek(
               project -> {
                  List<MonomerSchedulingTreeDO> filteredMonomers = project.getMonomerSchedulingTreeDO()
                     .stream()
                     .peek(
                        monomer -> {
                           List<AreaSchedulingTreeDO> filteredAreas = monomer.getAreaSchedulingTreeDO()
                              .stream()
                              .filter(area -> area.getStatus() == state)
                              .collect(Collectors.toList());
                           monomer.setAreaSchedulingTreeDO(filteredAreas);
                        }
                     )
                     .filter(monomer -> !monomer.getAreaSchedulingTreeDO().isEmpty())
                     .collect(Collectors.toList());
                  project.setMonomerSchedulingTreeDO(filteredMonomers);
               }
            )
            .filter(e -> !e.getMonomerSchedulingTreeDO().isEmpty())
            .collect(Collectors.toList());
      }

      return schedulingTree;
   }

   @Override
   public List<Integer> projectCategory(Long projectId) {
      List<TechEnclosure> enclosureList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .apply("quantity>scheduling_quantity")
         );
      return enclosureList.stream()
         .filter(s -> s.getQuantity() > s.getSchedulingQuantity())
         .map(TechEnclosure::getCategory)
         .distinct()
         .collect(Collectors.toList());
   }

   @Override
   public Map<Long, String> projectEnclosureDictionary(List<Long> areaIds) {
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      List<TechEnclosure> enclosureList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .in(TechEnclosure::getAreaId, areaIds)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .apply("quantity>scheduling_quantity")
         );
      List<Long> types = enclosureList.stream()
         .filter(s -> s.getQuantity() > s.getSchedulingQuantity())
         .map(TechEnclosure::getDictionaryId)
         .distinct()
         .collect(Collectors.toList());
      return enclosureDictMap.entrySet().stream().filter(entry -> types.contains(entry.getKey())).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
   }

   @Override
   public List<EnclosurePlanDTO> planByCondition(Long projectId, Integer type) {
      List<TechEnclosure> enclosures = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .eq(TechEnclosure::getCategory, type)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .apply("quantity>scheduling_quantity")
         );
      enclosures = enclosures.stream().filter(s -> s.getQuantity() > s.getSchedulingQuantity()).collect(Collectors.toList());
      List<Long> areaIds = enclosures.stream().map(TechEnclosure::getEnclosurePlanId).distinct().collect(Collectors.toList());
      List<EnclosurePlanDTO> dtos = new ArrayList<>();

      for (EnclosurePlan plan : this.enclosurePlanService.listByIds(areaIds)) {
         EnclosurePlanDTO copy = BeanUtil.copy(plan, EnclosurePlanDTO.class);
         dtos.add(copy);
      }

      return dtos;
   }

   @Override
   public PageVO<EnclosureNeedSchedulingDTO> listEnclosure(List<Long> planIds, Integer category, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechEnclosure> enclosures = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .in(TechEnclosure::getEnclosurePlanId, planIds)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .apply(" category & {0} ", category)
               .apply("quantity > (scheduling_quantity + subscribe_quantity)")
         );
      PageVO pageVO = new PageVO<>(enclosures);
      if (CollectionUtils.isEmpty(enclosures)) {
         return pageVO;
      }

      List<Long> ids = enclosures.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList());
      List<EnclosureNeedSchedulingDTO> dtos = new ArrayList<>();
      Map<Long, EnclosurePlan> planMap = this.enclosurePlanService.listByIds(ids).stream().collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));

      for (TechEnclosure enclosure : enclosures) {
         EnclosureNeedSchedulingDTO copy = BeanUtil.copy(enclosure, EnclosureNeedSchedulingDTO.class);
         String name = planMap.get(enclosure.getEnclosurePlanId()).getName();
         copy.setPlanName(name);
         dtos.add(copy);
      }

      dtos = dtos.stream().map(s -> s.setNeedSchedulingQuantity(s.getQuantity() - s.getSchedulingQuantity())).collect(Collectors.toList());
      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public PageVO<EnclosureNeedSchedulingDTO> schedulingListEnclosure(List<Long> areaIds, Integer dictionaryId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechEnclosure> enclosures = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .in(TechEnclosure::getAreaId, areaIds)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .eq(TechEnclosure::getDictionaryId, dictionaryId)
               .apply("quantity > (scheduling_quantity + subscribe_quantity)")
         );
      PageVO pageVO = new PageVO<>(enclosures);
      if (CollectionUtils.isEmpty(enclosures)) {
         return pageVO;
      }

      List<Long> ids = enclosures.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList());
      List<EnclosureNeedSchedulingDTO> dtos = new ArrayList<>();
      Map<Long, String> monomerMap = this.planMonomerService
         .listByIds(enclosures.stream().map(e -> e.getMonomerId()).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(e -> e.getId(), s -> s.getName()));
      Map<Long, String> areaMap = this.areaService
         .listByIds(enclosures.stream().map(e -> e.getAreaId()).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(e -> e.getId(), s -> s.getName()));

      for (TechEnclosure enclosure : enclosures) {
         EnclosureNeedSchedulingDTO copy = BeanUtil.copy(enclosure, EnclosureNeedSchedulingDTO.class);
         copy.setMonomerName(monomerMap.get(enclosure.getMonomerId()));
         copy.setAreaName(areaMap.get(enclosure.getAreaId()));
         dtos.add(copy);
      }

      dtos = dtos.stream().map(s -> s.setNeedSchedulingQuantity(s.getQuantity() - s.getSchedulingQuantity())).collect(Collectors.toList());
      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public PageVO<EnclosureResponseDTO> enclosureV2(EnclosureListQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, orderBy);
      List<EnclosureResponseDTO> responseDTOS = this.enclosureListV2(queryDTOParam);
      return new PageVO<>(responseDTOS);
   }

   @Override
   public List<EnclosureResponseDTO> enclosureListV2(EnclosureListQueryDTOParam queryDTOParam) {
      List<EnclosureResponseDTO> responseDTOS = this.enclosureService.listByCondition(queryDTOParam);
      if (CollectionUtils.isNotEmpty(responseDTOS)) {
         Long areaId = responseDTOS.get(0).getAreaId();
         PlanArea area = this.areaService.getById(areaId);
         PlanMonomer monomer = this.planMonomerService.getById(area.getMonomerId());

         for (EnclosureResponseDTO enclosureDTO : responseDTOS) {
            enclosureDTO.setArea(NameInfo.builder().id(area.getId()).name(area.getName()).build());
            enclosureDTO.setMonomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build());
            BigDecimal thickness = enclosureDTO.getThickness() != null ? enclosureDTO.getThickness() : BigDecimal.ZERO;
            BigDecimal weight = enclosureDTO.getUnfoldedWidth() != null ? enclosureDTO.getUnfoldedWidth() : BigDecimal.ZERO;
            BigDecimal length = enclosureDTO.getLength() != null ? enclosureDTO.getLength() : BigDecimal.ZERO;
            enclosureDTO.setSpecification(
               thickness.stripTrailingZeros().toPlainString()
                  + "*"
                  + weight.stripTrailingZeros().toPlainString()
                  + "*"
                  + length.stripTrailingZeros().toPlainString()
            );
         }
      }

      return responseDTOS;
   }

   @Override
   public PageVO<TechEnclosureChangeRecordDTO> pageListChangeRecord(TechEnclosureChangeRecordQueryVoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechEnclosureChangeRecordDTO> changeRecordList = this.enclosureRecordService.listChangeRecord(param);
      if (CollectionUtils.isNotEmpty(changeRecordList)) {
         List<Long> changeRecordIds = changeRecordList.stream().map(TechEnclosureChangeRecordDTO::getId).collect(Collectors.toList());
         Map<Long, TechEnclosureChangeRecordDetail> changeRecordIdDetailListMap = this.enclosureChangeRecordDetailService
            .list(Wrappers.lambdaQuery(TechEnclosureChangeRecordDetail.class).in(TechEnclosureChangeRecordDetail::getChangeRecordId, changeRecordIds))
            .stream()
            .collect(Collectors.toMap(TechEnclosureChangeRecordDetail::getChangeRecordId, Function.identity()));
         changeRecordList.forEach(dto -> {
            TechEnclosureChangeRecordDetail changeRecordDetail = changeRecordIdDetailListMap.get(dto.getId());
            TechEnclosureChangeRecordDetailDTO copy = BeanUtil.copy(changeRecordDetail, TechEnclosureChangeRecordDetailDTO.class);
            dto.setChangeRecordDetail(copy);
         });
      }

      return new PageVO<>(changeRecordList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean checkChange(TechChangeCheckDtoParam param) {
      TechEnclosureChangeRecord changeRecord = this.enclosureChangeRecordService.getById(param.getId());
      Preconditions.checkArgument(changeRecord != null, "变更记录不存在!");
      Preconditions.checkArgument(changeRecord.getCheckStatus().equals(CheckStatusEnum.PENDING.getType()), "变更记录已审核!");
      BeanUtil.copy(param, changeRecord);
      changeRecord.setCheckUserId(UserUtil.getCurrentUserId());
      changeRecord.setCheckTime(LocalDateTime.now());
      this.enclosureChangeRecordService.updateById(changeRecord);
      TechEnclosureChangeRecordDetail recordDetail = this.checkFail(changeRecord.getId());
      if (param.getCheckStatus().equals(CheckStatusEnum.PASS.getType())) {
         this.checkPass(recordDetail);
         this.approvalChange(recordDetail);
      }

      return true;
   }

   private TechEnclosureChangeRecordDetail checkFail(Long changeRecordId) {
      TechEnclosureChangeRecordDetail recordDetail = this.enclosureChangeRecordDetailService
         .getOne(Wrappers.lambdaQuery(TechEnclosureChangeRecordDetail.builder().changeRecordId(changeRecordId).build()));
      Preconditions.checkArgument(recordDetail != null, "变更记录详情不存在!");
      TechEnclosure enclosure = this.enclosureService.getById(recordDetail.getEnclosureId());
      if (enclosure != null) {
         enclosure.setBoolStatusEnum(Boolean.TRUE);
         this.enclosureService.updateById(enclosure);
      }

      return recordDetail;
   }

   private void checkPass(TechEnclosureChangeRecordDetail recordDetail) {
      if (ArtifactChangeTypeEnum.UPDATE_BASIC.getType().equals(recordDetail.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(recordDetail.getEnclosureId());
         if (enclosure != null) {
            enclosure.setWeight(recordDetail.getChangeWeight());
            enclosure.setTotalWeight(recordDetail.getChangeWeight().multiply(BigDecimal.valueOf(recordDetail.getChangeQuantity().intValue())));
            enclosure.setTotalLength(recordDetail.getChangeLength().multiply(BigDecimal.valueOf(recordDetail.getChangeQuantity().intValue())));
            enclosure.setTotalArea(recordDetail.getChangeSurfaceArea().multiply(BigDecimal.valueOf(recordDetail.getChangeQuantity().intValue())).setScale(4, 4));
            enclosure.setSurfaceArea(recordDetail.getChangeSurfaceArea());
            enclosure.setName(recordDetail.getChangeName());
            enclosure.setLength(recordDetail.getChangeLength());
            enclosure.setDictionaryId(recordDetail.getChangeDictionaryId());
            enclosure.setSerialNumber(recordDetail.getChangeSerialNumber());
            enclosure.setPlate(recordDetail.getChangePlate());
            enclosure.setWidth(recordDetail.getChangeWidth());
            enclosure.setUnfoldedWidth(recordDetail.getChangeUnfoldedWidth());
            enclosure.setThickness(recordDetail.getChangeThickness());
            enclosure.setAccountingVolume(recordDetail.getChangeAccountingVolume());
            enclosure.setRemark(recordDetail.getChangeRemark());
            this.enclosureService.updateById(enclosure);
         }
      }
   }

   @Override
   public PageVO<MesTechInventoryOperationDTO> getInventoryList(
      String projectName, String createUserName, String reviewedName, Integer inventoryReviewedEnum, Integer pageNumber, Integer pageSize
   ) {
      List<ContractProject> projects = this.projectService
         .list(Wrappers.lambdaQuery(ContractProject.class).like(ContractProject::getName, projectName).or().like(ContractProject::getShortName, projectName));
      Page<MesTechInventoryOperationDTO> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesTechInventoryOperation> inventoryOperationList = this.mesTechInventoryOperationService
         .list(
            (Wrapper<MesTechInventoryOperation>)((((((new LambdaQueryWrapper<MesTechInventoryOperation>()
                                 .ne(MesTechInventoryOperation::getInventoryReviewedEnum, InventoryReviewedEnum.FIXUP_RECORD.getType()))
                              .ne(MesTechInventoryOperation::getInventoryReviewedEnum, InventoryReviewedEnum.REVOKED.getType()))
                           .in(
                              CollectionUtils.isNotEmpty(projects),
                              MesTechInventoryOperation::getProjectId,
                              projects.stream().map(e -> e.getId()).collect(Collectors.toList())
                           ))
                        .eq(inventoryReviewedEnum != null, MesTechInventoryOperation::getInventoryReviewedEnum, inventoryReviewedEnum))
                     .like(org.apache.commons.lang3.StringUtils.isNotBlank(createUserName), MesTechInventoryOperation::getCreateUserName, createUserName))
                  .like(org.apache.commons.lang3.StringUtils.isNotBlank(reviewedName), MesTechInventoryOperation::getReviewedName, reviewedName))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(inventoryOperationList)) {
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getProjectId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         Map<Long, PlanMonomer> monomerMap = this.planMonomerService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getMonomerId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
         Map<Long, PlanArea> areaMap = this.areaService
            .listByIds(inventoryOperationList.stream().map(MesTechInventoryOperation::getAreaId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
         Map<Long, List<TechEnclosureRecord>> enclosureRecordMap = this.enclosureRecordService
            .list(
               (Wrapper<TechEnclosureRecord>)new LambdaQueryWrapper<TechEnclosureRecord>()
                  .in(
                     TechEnclosureRecord::getInventoryOperationId,
                     inventoryOperationList.stream().map(MesTechInventoryOperation::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(TechEnclosureRecord::getInventoryOperationId));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(enclosureRecordMap), "查询失败,导入的构件清单不存在!");
         return new PageVO<>(
            page,
            inventoryOperationList.stream()
               .map(
                  e -> {
                     MesTechInventoryOperationDTO inventoryOperationDTO = BeanUtil.copy(e, MesTechInventoryOperationDTO.class);
                     ContractProject project = projectMap.get(e.getProjectId());
                     PlanMonomer monomer = monomerMap.get(e.getMonomerId());
                     PlanArea area = areaMap.get(e.getAreaId());
                     List<TechEnclosureRecord> enclosureRecordList = enclosureRecordMap.get(e.getId());
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(enclosureRecordList), "查询失败,导入的构件清单不存在!");
                     inventoryOperationDTO.setProjectInfo(
                        ProjectInfo.builder().serialNumber(project.getSerialNumber()).name(project.getName()).shortName(project.getShortName()).build()
                     );
                     inventoryOperationDTO.setMonomer(NameInfo.builder().name(monomer.getName()).build());
                     inventoryOperationDTO.setArea(NameInfo.builder().name(area.getName()).build());
                     inventoryOperationDTO.setTotalQuantity(enclosureRecordList.stream().mapToInt(TechEnclosureRecord::getQuantity).sum());
                     inventoryOperationDTO.setTotalWeight(
                        enclosureRecordList.stream().map(TechEnclosureRecord::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                     );
                     return inventoryOperationDTO;
                  }
               )
               .sorted(Comparator.comparing(MesTechInventoryOperationDTO::getInventoryReviewedEnum))
               .collect(Collectors.toList())
         );
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<EnclosureNeedSchedulingDTO> listEnclosureV2(List<Long> areaIds, Long dictionaryId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechEnclosure> enclosures = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .in(TechEnclosure::getAreaId, areaIds)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .eq(TechEnclosure::getDictionaryId, dictionaryId)
               .apply("quantity > scheduling_quantity")
         );
      PageVO pageVO = new PageVO<>(enclosures);
      if (CollectionUtils.isEmpty(enclosures)) {
         return pageVO;
      }

      List<Long> ids = enclosures.stream().map(TechEnclosure::getAreaId).collect(Collectors.toList());
      List<EnclosureNeedSchedulingDTO> dtos = new ArrayList<>();
      Map<Long, PlanArea> planMap = this.areaService.listByIds(ids).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));

      for (TechEnclosure enclosure : enclosures) {
         EnclosureNeedSchedulingDTO copy = BeanUtil.copy(enclosure, EnclosureNeedSchedulingDTO.class);
         String name = planMap.get(enclosure.getAreaId()).getName();
         copy.setPlanName(name);
         dtos.add(copy);
      }

      dtos = dtos.stream().map(s -> s.setNeedSchedulingQuantity(s.getQuantity() - s.getSchedulingQuantity())).collect(Collectors.toList());
      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public PageVO<TechEnclosureSubscribeDTO> getUnSchedulingEnclosureList(EnclosureSubscribeQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechEnclosure> enclosureList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .orderByAsc(TechEnclosure::getId)
               .eq(param.getProjectId() != null, TechEnclosure::getProjectId, param.getProjectId())
               .eq(param.getCategory() != null, TechEnclosure::getCategory, param.getCategory())
               .eq(param.getEnclosurePlanId() != null, TechEnclosure::getEnclosurePlanId, param.getEnclosurePlanId())
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(param.getName()), TechEnclosure::getName, param.getName())
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(param.getSerialNumber()), TechEnclosure::getSerialNumber, param.getSerialNumber())
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(param.getBrand()), TechEnclosure::getBrand, param.getBrand())
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(param.getPlate()), TechEnclosure::getPlate, param.getPlate())
               .apply("quantity > scheduling_quantity + subscribe_quantity")
         );
      if (enclosureList.isEmpty()) {
         return new PageVO<>();
      }

      ProjectInfo projectInfo = this.projectService.getSimpleById(param.getProjectId());
      Map<Long, NameInfo> enclosurePlanMap = this.enclosurePlanService
         .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toSet()))
         .stream()
         .map(s -> BeanUtil.copy(s, NameInfo.class))
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      List<TechEnclosureSubscribeDTO> dtoList = enclosureList.stream().map(e -> {
         TechEnclosureSubscribeDTO enclosureSubscribeDTO = BeanUtil.copy(e, TechEnclosureSubscribeDTO.class);
         enclosureSubscribeDTO.setProject(projectInfo);
         enclosureSubscribeDTO.setSpecification(enclosureSubscribeDTO.getPlate());
         enclosureSubscribeDTO.setEnclosurePlan(enclosurePlanMap.get(e.getEnclosurePlanId()));
         enclosureSubscribeDTO.setQuantity(e.getQuantity() - e.getSchedulingQuantity());
         return enclosureSubscribeDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(dtoList, enclosureList));
   }

   private static void setTotalInfo(Integer quantity, TechEnclosure enclosure) {
      enclosure.setTotalLength(new BigDecimal(quantity).multiply(enclosure.getLength()));
      enclosure.setTotalArea(new BigDecimal(quantity).multiply(enclosure.getSurfaceArea()));
      enclosure.setTotalWeight(new BigDecimal(quantity).multiply(enclosure.getWeight()));
   }

   public Boolean approvalChange(TechEnclosureChangeRecordDetail change) {
      Long enclosureId = change.getEnclosureId();
      Integer reduceQuantity = change.getQuantity() - change.getChangeQuantity();
      List<TechEnclosureChangeLog> logLists = new ArrayList<>();
      TechEnclosure enclosure = this.enclosureService.getById(enclosureId);
      if (enclosure == null) {
         return false;
      }

      Preconditions.checkArgument(enclosure.getQuantity() - reduceQuantity >= 0, "删除数量超出清单数，无法变更！");
      TechEnclosureChangeLog techEnclosureLog = TechEnclosureChangeLog.builder()
         .productId(enclosureId)
         .changeId(change.getId())
         .tableId(enclosure.getId())
         .oldQuantity(enclosure.getQuantity())
         .changeQuantity(reduceQuantity)
         .quantity(enclosure.getQuantity() - reduceQuantity)
         .userId(UserUtil.getCurrentUserId())
         .category(enclosure.getCategory())
         .type(EnclosureChangeLogTypeEnum.TECH_ENCLOSURE.getType())
         .build();
      logLists.add(techEnclosureLog);
      int afterChangeCount = change.getChangeQuantity();
      int quantityCount = reduceQuantity - (enclosure.getQuantity() - enclosure.getSchedulingQuantity());
      enclosure.setQuantity(afterChangeCount);
      setTotalInfo(afterChangeCount, enclosure);
      if (quantityCount > 0) {
         enclosure.setSchedulingQuantity(enclosure.getSchedulingQuantity() - quantityCount);
         List<MesEnclosureTask> tasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getProductId, enclosureId));
         List<MesEnclosureTaskOrder> taskOrders = this.taskOrderService
            .list(
               Wrappers.lambdaQuery(MesEnclosureTaskOrder.class)
                  .in(MesEnclosureTaskOrder::getId, tasks.stream().map(MesEnclosureTask::getTaskOrderId).collect(Collectors.toSet()))
            );
         Map<Long, Long> taskOrderMap = tasks.stream().collect(Collectors.toMap(MesEnclosureTask::getId, MesEnclosureTask::getTaskOrderId));
         Map<Long, MesEnclosureTaskOrder> orderMap = taskOrders.stream().collect(Collectors.toMap(MesEnclosureTaskOrder::getId, Function.identity()));
         List<MesEnclosureTaskOrder> updateOrDelOrderList = new ArrayList<>();
         List<MesEnclosureTask> updateOrDelTaskList = new ArrayList<>();

         for (MesEnclosureTask task : tasks) {
            if (task.getTaskQuantity() > task.getCompleteQuantity() && quantityCount > 0) {
               int canReduce = task.getTaskQuantity() - task.getCompleteQuantity();
               int trueReduce = Math.min(canReduce, quantityCount);
               task.setTaskQuantity(task.getTaskQuantity() - trueReduce);
               task.setBoolCompleteEnum(task.getTaskQuantity().equals(task.getCompleteQuantity()));
               MesEnclosureTaskOrder order = orderMap.get(task.getTaskOrderId());
               order.setQuantity(order.getQuantity() - trueReduce);
               if (order.getQuantity() == 0) {
                  updateOrDelOrderList.add(order);
               } else {
                  if (order.getQuantity().equals(order.getCompleteQuantity())) {
                     order.setBoolCompleteEnum(Boolean.TRUE);
                  }

                  updateOrDelOrderList.add(order);
               }

               if (task.getTaskQuantity() == 0) {
                  updateOrDelTaskList.add(task);
               } else {
                  updateOrDelTaskList.add(task);
               }

               quantityCount -= trueReduce;
            }
         }

         HashMap<Long, Integer> taskReduceMap = new HashMap<>();

         for (MesEnclosureTask task : tasks) {
            if (quantityCount > 0) {
               int canReduce = task.getCompleteQuantity();
               int trueReduce = Math.min(canReduce, quantityCount);
               task.setTaskQuantity(task.getTaskQuantity() - trueReduce);
               task.setCompleteQuantity(task.getCompleteQuantity() - trueReduce);
               MesEnclosureTaskOrder order = orderMap.get(task.getTaskOrderId());
               order.setQuantity(order.getQuantity() - trueReduce);
               order.setCompleteQuantity(order.getCompleteQuantity() - trueReduce);
               Integer i = taskReduceMap.get(task.getId());
               if (i == null) {
                  taskReduceMap.put(task.getId(), trueReduce);
               } else {
                  taskReduceMap.put(task.getId(), i + trueReduce);
               }

               if (order.getQuantity() == 0) {
                  updateOrDelOrderList.add(order);
               } else {
                  if (order.getQuantity().equals(order.getCompleteQuantity())) {
                     order.setBoolCompleteEnum(Boolean.TRUE);
                  }

                  updateOrDelOrderList.add(order);
               }

               if (task.getTaskQuantity() == 0) {
                  updateOrDelTaskList.add(task);
               } else {
                  if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
                     task.setBoolCompleteEnum(Boolean.TRUE);
                  }

                  updateOrDelTaskList.add(task);
               }

               quantityCount -= trueReduce;
            }
         }

         this.taskOrderService.updateBatchById(updateOrDelOrderList.stream().filter(s -> s.getQuantity() != 0).collect(Collectors.toList()));
         this.taskOrderService
            .removeByIds(updateOrDelOrderList.stream().filter(s -> s.getQuantity() == 0).map(MesEnclosureTaskOrder::getId).collect(Collectors.toList()));
         this.taskService.updateBatchById(updateOrDelTaskList.stream().filter(s -> s.getTaskQuantity() != 0).collect(Collectors.toList()));
         this.taskService
            .removeByIds(updateOrDelTaskList.stream().filter(s -> s.getTaskQuantity() == 0).map(MesEnclosureTask::getId).collect(Collectors.toList()));
         int reduceProduceCount = taskReduceMap.values().stream().mapToInt(Integer::intValue).sum();
         enclosure.setProducedQuantity(enclosure.getProducedQuantity() - reduceProduceCount);
         if (!taskReduceMap.isEmpty()) {
            for (Long taskId : taskReduceMap.keySet()) {
               Integer needReduceProduce = taskReduceMap.get(taskId);
               List<MesEnclosureProduceTeamReport> list = this.teamReportService
                  .list(
                     Wrappers.lambdaQuery(MesEnclosureProduceTeamReport.class)
                        .eq(MesEnclosureProduceTeamReport::getProductId, enclosureId)
                        .eq(MesEnclosureProduceTeamReport::getTaskId, taskId)
                  );
               List<MesEnclosureProduceTeamReport> reportList = new ArrayList<>();
               int i = needReduceProduce;

               for (MesEnclosureProduceTeamReport teamReport : list) {
                  if (i > 0) {
                     TechEnclosureChangeLog reportLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(teamReport.getId())
                        .oldQuantity(teamReport.getQuantity())
                        .changeQuantity(i)
                        .quantity(teamReport.getQuantity() - i)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.TEAM_REPORT.getType())
                        .build();
                     logLists.add(reportLog);
                     int reduceCount = Math.min(teamReport.getQuantity(), i);
                     teamReport.setQuantity(teamReport.getQuantity() - reduceCount);
                     reportList.add(teamReport);
                     i -= reduceCount;
                  }
               }

               this.teamReportService.updateBatchById(reportList.stream().filter(s -> s.getQuantity() != 0).collect(Collectors.toList()));
               this.teamReportService
                  .removeByIds(reportList.stream().filter(s -> s.getQuantity() == 0).map(MesEnclosureProduceTeamReport::getId).collect(Collectors.toList()));
               List<MesBuildingComplete> completeList = this.completeService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingComplete.class)
                        .eq(MesBuildingComplete::getProductId, enclosureId)
                        .eq(MesBuildingComplete::getTaskId, taskId)
                        .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ENCLOSURE.getType())
                  );
               List<MesBuildingComplete> compleList = new ArrayList<>();
               int j = needReduceProduce;

               for (MesBuildingComplete complete : completeList) {
                  if (j > 0) {
                     TechEnclosureChangeLog completeLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(complete.getId())
                        .oldQuantity(complete.getQuantity())
                        .changeQuantity(j)
                        .quantity(complete.getQuantity() - j)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.ENCLOSURE_COMPLETE.getType())
                        .build();
                     logLists.add(completeLog);
                     int reduceCount = Math.min(complete.getQuantity(), j);
                     complete.setQuantity(complete.getQuantity() - reduceCount);
                     compleList.add(complete);
                     this.completeService.updateById(complete);
                     if (complete.getQuantity() == 0) {
                        this.completeService.removeById(complete.getId());
                     }

                     j -= reduceCount;
                  }
               }

               this.completeService.updateBatchById(compleList.stream().filter(s -> s.getQuantity() != 0).collect(Collectors.toList()));
               this.completeService
                  .removeByIds(compleList.stream().filter(s -> s.getQuantity() == 0).map(MesBuildingComplete::getId).collect(Collectors.toList()));
               List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                        .eq(MesBuildingWarehouseRecord::getProductId, enclosureId)
                        .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ENCLOSURE.getType())
                        .eq(MesBuildingWarehouseRecord::getType, WarehouseRecordStatusTypeEnum.INTO.getType())
                  );
               List<MesBuildingWarehouseRecord> recordList = new ArrayList<>();
               int k = needReduceProduce;

               for (MesBuildingWarehouseRecord record : warehouseRecordList) {
                  if (k > 0) {
                     TechEnclosureChangeLog recordLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(record.getId())
                        .oldQuantity(record.getQuantity().intValue())
                        .changeQuantity(k)
                        .quantity(record.getQuantity().intValue() - k)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.ENCLOSURE_WAREHOUSE.getType())
                        .build();
                     logLists.add(recordLog);
                     int reduceCount = Math.min(record.getQuantity().intValue(), k);
                     record.setQuantity(record.getQuantity().subtract(BigDecimal.valueOf(reduceCount)));
                     recordList.add(record);
                     k -= reduceCount;
                  }
               }

               this.warehouseRecordService.updateBatchById(recordList.stream().filter(s -> s.getQuantity().intValue() != 0).collect(Collectors.toList()));
               this.warehouseRecordService
                  .removeByIds(
                     recordList.stream().filter(s -> s.getQuantity().intValue() == 0).map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
                  );
               List<MesBuildingWarehouseSummary> summary = this.warehouseSummaryService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                        .eq(MesBuildingWarehouseSummary::getProductId, enclosureId)
                        .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ENCLOSURE.getType())
                  );
               List<MesBuildingWarehouseSummary> summaryList = new ArrayList<>();
               int z = needReduceProduce;

               for (MesBuildingWarehouseSummary warehouseSummary : summary) {
                  if (z > 0) {
                     TechEnclosureChangeLog summaryLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(warehouseSummary.getId())
                        .oldQuantity(warehouseSummary.getQuantity().intValue())
                        .changeQuantity(z)
                        .quantity(warehouseSummary.getQuantity().intValue() - z)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.ENCLOSURE_WAREHOUSE_SUMMARY.getType())
                        .build();
                     logLists.add(summaryLog);
                     int reduceCount = Math.min(warehouseSummary.getQuantity().intValue(), z);
                     warehouseSummary.setQuantity(warehouseSummary.getQuantity().subtract(BigDecimal.valueOf(reduceCount)));
                     summaryList.add(warehouseSummary);
                     z -= reduceCount;
                  }
               }

               this.warehouseSummaryService.updateBatchById(summaryList.stream().filter(s -> s.getQuantity().intValue() != 0).collect(Collectors.toList()));
               this.warehouseSummaryService
                  .removeByIds(
                     summaryList.stream().filter(s -> s.getQuantity().intValue() == 0).map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList())
                  );
            }
         }

         this.changeLogService.saveBatch(logLists);
      }

      EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
         .businessId(enclosure.getBusinessId())
         .quantity(-reduceQuantity)
         .totalArea(enclosure.getSurfaceArea().multiply(BigDecimal.valueOf(reduceQuantity.intValue())).divide(BigDecimal.valueOf(1000000L)).negate())
         .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(reduceQuantity.intValue())).divide(BigDecimal.valueOf(1000L)).negate())
         .build();
      this.businessService.editBusinessInfo(editDTOParam);
      if (enclosure.getQuantity() == 0) {
         this.enclosureService.removeById(enclosure.getId());
      } else {
         this.enclosureService.updateById(enclosure);
      }

      return true;
   }
}
