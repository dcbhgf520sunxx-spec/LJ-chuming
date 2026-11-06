package com.hzchum.scim.contract.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ChineseYuanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.export.ApproveRecordDetailExportDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractVisaBiz;
import com.hzchum.scim.contract.core.api.enums.ProjectBoolArrearsEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaModeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaProjectInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.app.AppVisaDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractSettlementDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaApproveOpinionDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParamV2;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.NumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class ContractVisaBizImpl implements ContractVisaBiz {
   @Autowired
   private ContractVisaService visaService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private UserService userService;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private NumberConfigService numberConfigService;
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private ContractCollectionInvoiceBiz collectionInvoiceBiz;
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private OutboundService outboundService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractProjectContentService projectContentService;
   @Autowired
   private ConfigService configService;
   @Autowired
   private RedisUtils redisUtils;
   @Resource
   private SupplierService supplierService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;

   @Override
   public PageVO<ContractVisaDTO> pageList(
      Long projectId,
      Integer status,
      String userName,
      String checkUerName,
      Integer mode,
      String year,
      Integer businessType,
      Integer type,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractVisa> visaList = this.visaService.listByCondition(projectId, status, userName, checkUerName, mode, year, businessType, type);
      List<ContractVisaDTO> visaDTOList = visaList.stream()
         .map(
            item -> {
               ContractVisaDTO result = BeanUtil.copy(item, ContractVisaDTO.class);
               ContractProject project = this.projectService.getById(item.getProjectId());
               result.setProject(BeanUtil.copy(project, ProjectInfo.class));
               result.setIsSubmitSettle(project.getSettlementStatus());
               result.setContractAmount(project.getContractAmount());
               int count = this.visaService
                  .count(
                     (Wrapper<ContractVisa>)((Wrappers.<ContractVisa>lambdaQuery()
                              .eq(ContractVisa::getType, VisaTypeEnum.SETTLEMENT.getType()))
                           .in(ContractVisa::getStatus, CheckStatusEnum.PENDING.getType(), CheckStatusEnum.PASS.getType()))
                        .eq(ContractVisa::getProjectId, item.getProjectId())
                  );
               result.setSettlementRecord(count > 0);
               result.setAttachments(this.attachmentService.listByIds(item.getAttachmentIds()));
               result.setAmount(item.getType().equals(VisaTypeEnum.VISA.getType()) ? item.getVisaAmount() : item.getSettlementAmount());
               return result;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(visaDTOList, visaList));
   }

   @Override
   public PageVO<ContractVisaDTO> pageListV2(
      Long projectId, Integer status, String userName, String checkUerName, Integer mode, LocalDate year, Integer type, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractVisa> visaList = this.visaService
         .list(
            Wrappers.lambdaQuery(ContractVisa.class)
               .eq(projectId != null, ContractVisa::getProjectId, projectId)
               .eq(status != null, ContractVisa::getStatus, status)
               .like(StrUtil.isNotBlank(userName), ContractVisa::getCreateUserName, userName)
               .like(StrUtil.isNotBlank(checkUerName), ContractVisa::getCheckUserName, userName)
               .eq(mode != null, ContractVisa::getMode, mode)
               .eq(ContractVisa::getType, VisaTypeEnum.VISA.getType())
               .apply(year != null, "date_format(create_time, '%Y') <= date_format({0}, '%Y')", year)
         );
      List<ContractVisaDTO> visaDTOList = visaList.stream()
         .map(
            item -> {
               ContractVisaDTO result = BeanUtil.copy(item, ContractVisaDTO.class);
               ContractProject project = this.projectService.getById(item.getProjectId());
               result.setProject(BeanUtil.copy(project, ProjectInfo.class));
               result.setIsSubmitSettle(project.getSettlementStatus());
               result.setContractAmount(project.getContractAmount());
               int count = this.visaService
                  .count(
                     (Wrapper<ContractVisa>)((Wrappers.<ContractVisa>lambdaQuery()
                              .eq(ContractVisa::getType, VisaTypeEnum.SETTLEMENT.getType()))
                           .in(
                              ContractVisa::getStatus,
                              ReviewStatusEnum.AUDITING.getType(),
                              ReviewStatusEnum.UN_REVIEWED.getType(),
                              ReviewStatusEnum.REVIEWED.getType()
                           ))
                        .eq(ContractVisa::getProjectId, item.getProjectId())
                  );
               result.setSettlementRecord(count > 0);
               result.setAttachments(this.attachmentService.listByIds(item.getAttachmentIds()));
               result.setAmount(item.getType().equals(VisaTypeEnum.VISA.getType()) ? item.getVisaAmount() : item.getSettlementAmount());
               return result;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(visaDTOList, visaList));
   }

   @Override
   public AppVisaDTO appVisa(
      Long projectId, Integer status, String userName, String checkUerName, Integer mode, String year, Integer businessType, Integer type
   ) {
      return AppVisaDTO.builder()
         .internallyVisaList(
            this.visaService
               .list(
                  (Wrapper<ContractVisa>)((((((((Wrappers.<ContractVisa>lambdaQuery()
                                             .eq(projectId != null, ContractVisa::getProjectId, projectId))
                                          .eq(status != null, ContractVisa::getStatus, status))
                                       .eq(type != null, ContractVisa::getType, VisaTypeEnum.VISA.getType()))
                                    .eq(businessType != null, ContractVisa::getBusinessType, businessType))
                                 .like(StringUtils.isNotBlank(userName), ContractVisa::getCreateUserName, userName))
                              .like(StringUtils.isNotBlank(checkUerName), ContractVisa::getCheckUserName, checkUerName))
                           .eq(ContractVisa::getMode, mode))
                        .apply(StringUtils.isNotBlank(year), "year(create_time) = '" + year + "'"))
                     .orderByDesc(BaseEntity::getCreateTime)
               )
               .stream()
               .map(e -> {
                  ContractVisaDTO contractVisaDTO = BeanUtil.copy(e, ContractVisaDTO.class);
                  contractVisaDTO.setAmount(e.getVisaAmount());
                  return contractVisaDTO;
               })
               .collect(Collectors.toList())
         )
         .build();
   }

   @Override
   public ContractVisaDetailDTO getDetail(Long id) {
      ContractVisa visa = this.visaService.getById(id);
      ContractVisaDetailDTO result = BeanUtil.copy(visa, ContractVisaDetailDTO.class);
      ContractVisaProjectInfoDTO project = this.getInfoById(visa.getProjectId());
      result.setProject(project);
      result.setAttachments(this.attachmentService.listByIds(visa.getAttachmentIds()));
      return result;
   }

   @Override
   public ContractVisaDetailDTO getDetailV2(Long id) {
      ContractVisa visa = this.visaService.getById(id);
      Preconditions.checkArgument(visa != null, "签证已不存在！请刷新重试");
      ContractVisaDetailDTO result = BeanUtil.copy(visa, ContractVisaDetailDTO.class);
      ContractVisaProjectInfoDTO project = this.getInfoById(visa.getProjectId());
      result.setProject(project);
      result.setAttachments(this.attachmentService.listByIds(visa.getAttachmentIds()));
      List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(visa.getApproveRecordIdNow())) {
         String approveRecordIds = visa.getApproveRecordIds();

         for (Long approveRecordId : Arrays.stream(approveRecordIds.split(",")).map(Long::valueOf).collect(Collectors.toList())) {
            WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(approveRecordId);
            wmsApproveRecordFlowDTOS.add(wmsApproveRecordFlowDTO);
         }
      }

      result.setWmsApproveRecordFlowDTOS(wmsApproveRecordFlowDTOS);
      return result;
   }

   @Override
   public void getDetailDownloadV2(Long id) {
      ContractVisa visa = this.visaService.getById(id);
      ContractVisaDetailDTO result = BeanUtil.copy(visa, ContractVisaDetailDTO.class);
      ContractVisaProjectInfoDTO project = this.getInfoById(visa.getProjectId());
      result.setProject(project);
      HashMap<String, Object> map = new HashMap<>(16);
      map.put("detailDTO", result);
      String resourcePath = "files/ProjectManageVisa.xlsx";
      String tempFileName = "项目管理签证详情";
      String exportFileName = "项目管理签证详情.xlsx";
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, ".xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      Sheet sheet = workbook.getSheetAt(0);
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      int approvalStartRow = 7;
      Row approvalHeaderRow = sheet.createRow(approvalStartRow);
      Cell approvalHeaderCell = approvalHeaderRow.createCell(0);
      approvalHeaderCell.setCellValue("审批信息");
      CellRangeAddress cellAddresses = new CellRangeAddress(approvalStartRow, approvalStartRow, 0, 5);
      PoiUtils.setRegionStyle(sheet, cellAddresses, cellStyle);
      sheet.addMergedRegion(cellAddresses);
      if (ObjectUtil.isNotEmpty(visa) && ObjectUtil.isNotEmpty(visa.getApproveRecordIdNow())) {
         Row approvalTitleRow = sheet.createRow(approvalStartRow + 1);
         String[] approvalTitles = new String[]{"节点", "审批人", "到达时间", "审批时间", "审批结果", "审批意见"};

         for (int i = 0; i < approvalTitles.length; i++) {
            Cell cell = approvalTitleRow.createCell(i);
            cell.setCellValue(approvalTitles[i]);
            cell.setCellStyle(cellStyle);
         }

         List<ApproveRecordDetailExportDTO> approveRecordDetailExportDTOS = this.wmsApproveRecordService.getExport(visa.getApproveRecordIdNow());
         int startRow = approvalStartRow + 2;

         for (int i = 0; i < approveRecordDetailExportDTOS.size(); i++) {
            ApproveRecordDetailExportDTO info = approveRecordDetailExportDTOS.get(i);
            Row dataRow = sheet.createRow(startRow + i);
            Cell node = dataRow.createCell(0);
            node.setCellValue(info.getFlowTypeName());
            node.setCellStyle(cellStyle);
            Cell approver = dataRow.createCell(1);
            approver.setCellValue(info.getCheckUserName());
            approver.setCellStyle(cellStyle);
            Cell arrivalTime = dataRow.createCell(2);
            arrivalTime.setCellValue(info.getArrivalTimeStr());
            arrivalTime.setCellStyle(cellStyle);
            Cell approvalTime = dataRow.createCell(3);
            approvalTime.setCellValue(info.getApproveTimeStr());
            approvalTime.setCellStyle(cellStyle);
            Cell approvalResult = dataRow.createCell(4);
            approvalResult.setCellValue(info.getDecisionStr());
            approvalResult.setCellStyle(cellStyle);
            Cell approvalComment = dataRow.createCell(5);
            approvalComment.setCellValue(info.getOpinion());
            approvalComment.setCellStyle(cellStyle);
         }

         this.mergeApprovalNodes(sheet, approvalStartRow + 2, approveRecordDetailExportDTOS);
      }

      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      assert response != null;
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   @Override
   public void exportDetail(Long id, HttpServletResponse response) {
      String resourcePath = "files/ProjectVisa.xlsx";
      String tempFileName = "ProjectVisa";
      String exportFileName = "签证单.xlsx";
      ContractVisaDetailDTO visa = this.getDetail(id);
      ContractVisaProjectInfoDTO project = visa.getProject();
      ProjectConfigVO configVO = this.configService.getProjectConfig();
      String projectName;
      if (configVO.getShowProjectFullName()) {
         projectName = project.getName();
      } else {
         projectName = project.getShortName();
      }

      String serialNumber;
      if (configVO.getShowSerialNumber()) {
         serialNumber = project.getSerialNumber();
      } else {
         serialNumber = "";
      }

      Map<String, Object> map = new HashMap<>();
      if (configVO.getArrangement().equals(1)) {
         map.put("projectName", serialNumber + projectName);
      } else {
         map.put("projectName", projectName + serialNumber);
      }

      map.put("visaDate", DateTimeUtil.getLocalDateZhStr(visa.getVisaDate()));
      map.put("userName", visa.getUserName());
      map.put("contractSignBodyName", project.getContractSignBodyName());
      map.put("customerUnit", project.getCustomerUnit());
      map.put("reasonName", visa.getReasonName());
      map.put("visaAmount", NumberUtils.format2Str(visa.getVisaAmount()));
      map.put("supervisionUnit", visa.getSupervisionUnit());
      map.put("designUnit", visa.getDesignUnit());
      map.put("governmentRegulation", visa.getGovernmentRegulation());
      map.put("remark", visa.getRemark());
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
   }

   @Override
   public void exportSettlementDetail(Long id, HttpServletResponse response) {
      String resourcePath = "files/ProjectProcessingSettlement.xlsx";
      String tempFileName = "ProjectProcessingSettlement";
      String exportFileName = "加工结算单.xlsx";
      ContractVisaDetailDTO visa = this.getDetail(id);
      ContractVisaProjectInfoDTO project = visa.getProject();
      ProjectConfigVO configVO = this.configService.getProjectConfig();
      String projectName;
      if (configVO.getShowProjectFullName()) {
         projectName = project.getName();
      } else {
         projectName = project.getShortName();
      }

      String serialNumber;
      if (configVO.getShowSerialNumber()) {
         serialNumber = project.getSerialNumber();
      } else {
         serialNumber = "";
      }

      Map<String, Object> map = new HashMap<>();
      if (configVO.getArrangement().equals(1)) {
         map.put("projectName", serialNumber + projectName);
      } else {
         map.put("projectName", projectName + serialNumber);
      }

      map.put("settlementDate", DateTimeUtil.getLocalDateZhStr(visa.getSettlementDate()));
      map.put("userName", visa.getUserName());
      map.put("contractSignBodyName", project.getContractSignBodyName());
      map.put("customerUnit", project.getCustomerUnit());
      map.put("signingDate", project.getSigningDate() != null ? DateTimeUtil.getLocalDateZhStr(project.getSigningDate()) : null);
      map.put("contractAmount", project.getContractAmount());
      map.put("marginAmount", project.getMarginAmount());
      map.put("happenedAmount", project.getHappenedAmount());
      map.put("breachAmount", visa.getBreachAmount());
      map.put("visaAmount", visa.getVisaAmount());
      map.put("processingSettlementAmount", visa.getProcessingSettlementAmount());
      map.put("processingSettlementAmountStr", ChineseYuanUtil.toChinese(visa.getProcessingSettlementAmount().toString()));
      map.put("settlementAmount", visa.getSettlementAmount());
      map.put("settlementAmountStr", ChineseYuanUtil.toChinese(visa.getSettlementAmount().toString()));
      map.put("collectionAmount", project.getCollectionAmount());
      map.put("invoiceAmount", project.getInvoiceAmount());
      map.put("amountOwed", visa.getSettlementAmount().subtract(project.getCollectionAmount().setScale(2, RoundingMode.HALF_UP)));
      map.put("supplementaryInvoice", visa.getSettlementAmount().subtract(project.getInvoiceAmount().setScale(2, RoundingMode.HALF_UP)));
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
   }

   @Override
   public boolean save(ContractVisaDTOParam param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      ContractVisa visa = BeanUtil.copy(param, ContractVisa.class);
      int count = this.visaService.countByProject(param.getProjectId(), param.getMode());
      String serialNumber = this.numberConfigService
         .getNumber(param.getMode().equals(1) ? NumberTypeEnum.DOMESTIC_VISA : NumberTypeEnum.FOREIGN_VISA, project.getSerialNumber(), count);
      User user = this.userService.getById(param.getUserId());
      Preconditions.checkArgument(user != null, "用户不存在");
      SysDictionary dictionary = this.dictionaryService.getByNameAndValueFromCache(DictionaryEnum.VISA_REASON.getName(), param.getReasonId());
      Preconditions.checkArgument(dictionary != null, "签约原因不存在");
      visa.setBusinessType(project.getBusinessType());
      visa.setSerialNumber(serialNumber);
      visa.setUserId(param.getUserId());
      visa.setUserName(user.getName());
      visa.setReasonId(dictionary.getValue());
      visa.setReasonName(dictionary.getLabel());
      visa.setType(VisaTypeEnum.VISA.getType());
      visa.setCreateUserId(UserUtil.getCurrentUserId());
      visa.setCreateUserName(UserUtil.getCurrentName());
      visa.setStatus(CheckStatusEnum.PENDING.getType());
      return this.visaService.save(visa);
   }

   @Override
   public Boolean saveV2(ContractVisaDTOParamV2 param) {
      this.checkParam(param);
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Integer approveStatus = ReviewStatusEnum.AUDITING.getType();
      ContractVisa visa = BeanUtil.copy(param, ContractVisa.class);
      int count = this.visaService.getCount(LocalDateTime.now(), param.getMode());
      String serialNumber = this.numberConfigService
         .getNumber(
            param.getMode().equals(1) ? NumberTypeEnum.DOMESTIC_VISA : NumberTypeEnum.FOREIGN_VISA, count, new SimpleDateFormat("yyyyMMdd").format(new Date())
         );
      SysDictionary dictionary = this.dictionaryService.getByNameAndValueFromCache(DictionaryEnum.VISA_REASON.getName(), param.getReasonId());
      Preconditions.checkArgument(dictionary != null, "签约原因不存在");
      visa.setBusinessType(project.getBusinessType());
      visa.setSerialNumber(serialNumber);
      visa.setUserId(UserUtil.getCurrentUserId());
      visa.setUserName(UserUtil.getCurrentName());
      visa.setReasonId(dictionary.getValue());
      visa.setReasonName(dictionary.getLabel());
      visa.setType(VisaTypeEnum.VISA.getType());
      visa.setCreateUserId(UserUtil.getCurrentUserId());
      visa.setCreateUserName(UserUtil.getCurrentName());
      visa.setStatus(approveStatus);
      visa.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      this.visaService.save(visa);
      WmsApproveRecord record = this.wmsApproveRecordService
         .createRecord(visa.getId(), serialNumber, ApproveProcessTypeEnumV2.PROJECT_MANAGE_VISA.getType(), null, null, null, false, null, null, null);
      if (ApproveRecordStatusEnum.END.getType().equals(record.getStatus())) {
         approveStatus = ReviewStatusEnum.REVIEWED.getType();
      }

      visa.setStatus(approveStatus);
      visa.setApproveRecordIdNow(record.getId());
      visa.setApproveRecordIds(String.valueOf(record.getId()));
      this.visaService.updateById(visa);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public boolean checkV2(ContractVisaApproveOpinionDTOParam param) {
      Preconditions.checkArgument(
         ReviewStatusEnum.REVIEWED.getType().equals(param.getDecision()) || ReviewStatusEnum.RETURNED.getType().equals(param.getDecision()), "审核类型不正确！"
      );
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(param.getApproveRecordId());
      Boolean isEnd = this.wmsApproveRecordService
         .commonApproveStep(param.getDataId(), param.getDecision(), param.getOpinion(), wmsApproveRecord.getSerialNumber(), null);
      Integer approveStatus;
      if (isEnd) {
         approveStatus = param.getDecision();
      } else {
         approveStatus = ReviewStatusEnum.AUDITING.getType();
      }

      ContractVisa visa = this.visaService.getById(param.getDataId());
      Preconditions.checkArgument(visa != null, "操作失败，签证单不存在！");
      visa.setStatus(approveStatus);
      this.visaService.updateById(visa);
      return Boolean.TRUE;
   }

   @Override
   public boolean cancelApproveDetail(Long dateId) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ContractVisa visa = this.visaService.getById(dateId);
      Preconditions.checkArgument(visa != null, "操作失败！，签证信息已不存在");
      Preconditions.checkArgument(currentUser.getId().equals(visa.getUserId()), "操作失败！，仅创建人可以进行撤销");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(visa.getStatus()), "操作失败！，仅审核中可以撤销申请");
      visa.setStatus(ReviewStatusEnum.CANCEL.getType());
      if (ObjectUtil.isNotEmpty(visa.getApproveRecordIdNow())) {
         this.wmsApproveRecordService.revocation(visa.getApproveRecordIdNow());
      }

      this.visaService.updateById(visa);
      return true;
   }

   @Transactional
   @Override
   public Boolean deleteVisa(List<Long> ids) {
      for (Long id : ids) {
         ContractVisa visa = this.visaService.getById(id);
         Preconditions.checkArgument(visa != null, "操作失败！，签证信息已不存在");
         Preconditions.checkArgument(!ReviewStatusEnum.AUDITING.getType().equals(visa.getStatus()), "删除失败,签证正在审核中！");
         this.visaService.removeById(id);
      }

      return true;
   }

   @Override
   public boolean update(ContractVisaDTOParam param) {
      ContractVisa visa = this.visaService.getById(param.getId());
      Preconditions.checkArgument(visa != null, "更新失败，签证记录不存在");
      Preconditions.checkArgument(!visa.getStatus().equals(CheckStatusEnum.PASS.getType()), "更新失败，签证记录已审核");
      User user = this.userService.getById(param.getUserId());
      Preconditions.checkArgument(user != null, "用户不存在");
      SysDictionary dictionary = this.dictionaryService.getByNameAndValueFromCache(DictionaryEnum.VISA_REASON.getName(), param.getReasonId());
      Preconditions.checkArgument(dictionary != null, "签约原因不存在");
      visa.setStatus(CheckStatusEnum.PENDING.getType());
      visa.setVisaDate(param.getVisaDate());
      visa.setUserId(param.getUserId());
      visa.setUserName(user.getName());
      visa.setReasonId(dictionary.getValue());
      visa.setReasonName(dictionary.getLabel());
      visa.setVisaAmount(param.getVisaAmount());
      visa.setRemark(param.getRemark());
      visa.setSupervisionUnit(param.getSupervisionUnit());
      visa.setDesignUnit(param.getDesignUnit());
      visa.setGovernmentRegulation(param.getGovernmentRegulation());
      visa.setCreateUserId(param.getUserId());
      visa.setCreateUserName(UserUtil.getCurrentName());
      return this.visaService.updateById(visa);
   }

   @Override
   public boolean check(ContractCheckDTOParam param) {
      ContractVisa visa = this.visaService.getById(param.getId());
      Preconditions.checkArgument(visa != null, "签证结算记录不存在");
      Preconditions.checkArgument(CheckStatusEnum.PENDING.getType().equals(visa.getStatus()), "仅待审核的签证结算记录可审核");
      Preconditions.checkArgument(
         CheckStatusEnum.PASS.getType().equals(param.getStatus()) || CheckStatusEnum.FAIL.getType().equals(param.getStatus()), "审核状态类型不正确"
      );
      visa.setCheckUserId(UserUtil.getCurrentUserId());
      visa.setCheckUserName(UserUtil.getCurrentName());
      visa.setStatus(param.getStatus());
      visa.setAttachmentIds(StrUtil.join(",", param.getAttachmentIds()));
      visa.setAttachmentRemark(param.getAttachmentRemark());
      this.visaService.updateById(visa);
      if (visa.getType().equals(VisaTypeEnum.SETTLEMENT.getType())) {
         this.redisUtils.del("simpleProjectList");
      }

      if (visa.getType().equals(VisaTypeEnum.SETTLEMENT.getType()) && param.getStatus().equals(CheckStatusEnum.PASS.getType())) {
         ContractProject project = this.projectService.getById(visa.getProjectId());
         project.setSettlementStatus(SettlementStatusEnum.SETTLED.getType());
         project.setSettlementAmount(visa.getSettlementAmount());
         project.setStatus(ProjectStatusEnum.COMPLETED.getType());
         if (project.getCompleteDate() == null) {
            project.setCompleteDate(LocalDate.now());
         }

         BigDecimal collectionAmount = this.collectionService.getCollectionAmount(visa.getProjectId());
         project.setBoolArrears(
            collectionAmount.compareTo(project.getSettlementAmount()) < 0 ? ProjectBoolArrearsEnum.TRUE.getType() : ProjectBoolArrearsEnum.FALSE.getType()
         );
         this.projectService.updateById(project);
      }

      return true;
   }

   @Override
   public ContractVisaProjectInfoDTO projectInfoById(Long projectId) {
      ContractVisaProjectInfoDTO info = this.getInfoById(projectId);
      BigDecimal visaAmount = this.visaService.sumVisaAmount(projectId, VisaModeEnum.FOREIGN.getType(), VisaTypeEnum.VISA.getType());
      info.setVisaAmount(visaAmount);
      return info;
   }

   public ContractVisaProjectInfoDTO getInfoById(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      ContractVisaProjectInfoDTO result = BeanUtil.copy(project, ContractVisaProjectInfoDTO.class);
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      result.setContractSignBodyName(branchCompany.getName());
      if (project.getProjectManagerId() != null) {
         User user = this.userService.getById(project.getProjectManagerId());
         result.setProjectManagerName(user.getName());
      }

      result.setProjectContentName(this.projectContentService.getProjectContentStr(projectId, "、"));
      return result;
   }

   @Override
   public boolean handle(ContractSettlementDTOParam param) {
      Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "结算金额必须大于0");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(!this.visaService.checkProjectIsSettlement(param.getProjectId()), "项目已添加结算记录");
      this.collectionInvoiceBiz.checkProjectChanging(param.getProjectId());
      Preconditions.checkArgument(this.outboundService.getUnReviewed(param.getProjectId(), OutboundStatusEnum.UN_REVIEWED.getType()) == 0, "有未审核的项目出库单");
      Preconditions.checkArgument(
         this.visaService
               .count(
                  (Wrapper<ContractVisa>)((Wrappers.<ContractVisa>lambdaQuery()
                           .eq(ContractVisa::getType, VisaTypeEnum.VISA.getType()))
                        .eq(ContractVisa::getStatus, CheckStatusEnum.PENDING.getType()))
                     .eq(ContractVisa::getProjectId, param.getProjectId())
               )
            == 0,
         "有未审核的签证记录"
      );
      ContractVisa visa = BeanUtil.copy(param, ContractVisa.class);
      User user = this.userService.getById(param.getUserId());
      Preconditions.checkArgument(user != null, "用户不存在");
      visa.setSettlementDate(param.getSettlementDate() == null ? LocalDate.now() : param.getSettlementDate());
      visa.setBusinessType(project.getBusinessType());
      visa.setUserId(param.getUserId());
      visa.setUserName(user.getName());
      visa.setCreateUserId(UserUtil.getCurrentUserId());
      visa.setCreateUserName(UserUtil.getCurrentName());
      visa.setReasonName("结算");
      visa.setType(VisaTypeEnum.SETTLEMENT.getType());
      visa.setMode(VisaModeEnum.FOREIGN.getType());
      visa.setStatus(CheckStatusEnum.PENDING.getType());
      visa.setAttachmentIds(StrUtil.join(",", param.getAttachmentIds()));
      this.visaService.save(visa);
      this.redisUtils.del("simpleProjectList");
      return true;
   }

   @Override
   public boolean updateProjectHandle(ContractSettlementDTOParam param) {
      ContractVisa visa = this.visaService.getById(param.getId());
      Preconditions.checkArgument(visa != null, "项目不存在");
      Preconditions.checkArgument(!visa.getStatus().equals(CheckStatusEnum.PASS.getType()), "更新失败，签证记录已审核");
      User user = this.userService.getById(param.getUserId());
      Preconditions.checkArgument(user != null, "用户不存在");
      visa.setStatus(CheckStatusEnum.PENDING.getType());
      visa.setSettlementDate(param.getSettlementDate());
      visa.setUserId(param.getUserId());
      visa.setUserName(user.getName());
      visa.setVisaAmount(param.getVisaAmount());
      visa.setBreachAmount(param.getBreachAmount());
      visa.setProcessingSettlementAmount(param.getProcessingSettlementAmount());
      visa.setSettlementAmount(param.getSettlementAmount());
      visa.setRemark(param.getRemark());
      visa.setCreateUserId(UserUtil.getCurrentUserId());
      visa.setCreateUserName(UserUtil.getCurrentName());
      visa.setAttachmentIds(StrUtil.join(",", param.getAttachmentIds()));
      return this.visaService.updateById(visa);
   }

   private void checkParam(ContractVisaDTOParamV2 param) {
      if (VisaModeEnum.INTERNALLY.getType().equals(param.getMode())) {
         Preconditions.checkArgument(param.getSupplierId() != null, "操作失败！,对内签证分包对象不能为空！");
         Supplier supplier = this.supplierService.getById(param.getSupplierId());
         if (supplier != null) {
            param.setRecipients(supplier.getName());
         }
      }

      if (VisaModeEnum.FOREIGN.getType().equals(param.getMode())) {
         Preconditions.checkArgument(param.getRecipients() != null, "操作失败！,对外签证分包对象不能为空！");
      }
   }

   private void mergeApprovalNodes(Sheet sheet, int startRow, List<ApproveRecordDetailExportDTO> approveRecordDetailExportDTOS) {
      int mergeStart = startRow;
      String previousValue = null;
      Long previousFlowId = null;

      for (int i = 0; i < approveRecordDetailExportDTOS.size(); i++) {
         String currentValue = approveRecordDetailExportDTOS.get(i).getFlowTypeName();
         Long currentFlowId = null;
         if (ObjectUtil.isNotEmpty(approveRecordDetailExportDTOS.get(i).getFlowId())) {
            currentFlowId = approveRecordDetailExportDTOS.get(i).getFlowId();
         }

         if (previousValue != null && (ObjectUtil.isEmpty(previousFlowId) || !currentValue.equals(previousValue) || !currentFlowId.equals(previousFlowId))) {
            if (mergeStart != startRow + i - 1) {
               sheet.addMergedRegion(new CellRangeAddress(mergeStart, startRow + i - 1, 0, 0));
            }

            mergeStart = startRow + i;
         }

         previousValue = currentValue;
         previousFlowId = currentFlowId;
      }

      if (mergeStart != startRow + approveRecordDetailExportDTOS.size() - 1) {
         sheet.addMergedRegion(new CellRangeAddress(mergeStart, startRow + approveRecordDetailExportDTOS.size() - 1, 0, 0));
      }
   }
}
