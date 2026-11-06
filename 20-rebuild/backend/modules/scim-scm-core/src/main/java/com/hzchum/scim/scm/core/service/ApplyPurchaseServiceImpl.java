package com.hzchum.scim.scm.core.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.aliyun.dingtalkdrive_1_0.models.AddFileResponseBody;
import com.aliyun.dingtalkdrive_1_0.models.ListSpacesResponseBody;
import com.aliyun.dingtalkdrive_1_0.models.GetUploadInfoResponseBody.GetUploadInfoResponseBodyStsUploadInfo;
import com.aliyun.dingtalkdrive_1_0.models.ListSpacesResponseBody.ListSpacesResponseBodySpaces;
import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.comm.Protocol;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingtalk.api.response.OapiV2UserGetResponse.UserGetResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.FunctionTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.common.ClassificationCheckDTO;
import com.hzchum.scim.common.core.api.pojo.common.FormComponentValue;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.IdsStatusDTO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.common.MapConstants;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.manager.TechMesWmsManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechProductSubscribeUpdateVORequest;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.scm.core.api.common.ApplyPurchaseEnclosure;
import com.hzchum.scim.scm.core.api.enums.ApplyPurchaseMaterialTypeEnum;
import com.hzchum.scim.scm.core.api.enums.ApplyPurchaseStateEnum;
import com.hzchum.scim.scm.core.api.enums.ApplyPurchaseTypeEnum;
import com.hzchum.scim.scm.core.api.enums.DelButtonTypeEnum;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseInboundDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndSNDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.MaterialFreezeNumDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseOrderDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseDetailDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.ApplyPurchaseStatusDTOParam;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.mapper.ApplyPurchaseDetailMapper;
import com.hzchum.scim.scm.core.mapper.ApplyPurchaseMapper;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.ApproveStatusEnum;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.common.utils.NumberUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.ApproveInstance;
import com.hzchum.scim.system.core.api.pojo._do.ApproveProcess;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.DDAttachment;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.ApproveInstanceService;
import com.hzchum.scim.system.core.api.service.ApproveProcessService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.biz.SectionSteelSpecService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.MeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SectionSteelSpecStandardDetailService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.StandardService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectDetailService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.list.TreeList;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplyPurchaseServiceImpl extends ServiceImpl<ApplyPurchaseMapper, ApplyPurchase> implements ApplyPurchaseService {
   @Resource
   private ApplyPurchaseDetailMapper applyPurchaseDetailMapper;
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   ClassificationService classificationService;
   @Resource
   MeasureService measureService;
   @Resource
   UnitService unitService;
   @Resource
   ContractProjectService projectService;
   @Resource
   ProjectReceivingRecordService receivingRecordService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   TechEnclosureService enclosureService;
   @Resource
   ConfigProperties configProperties;
   @Resource
   ApproveInstanceService approveInstanceService;
   @Resource
   ApproveProcessService approveProcessService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordService materialFreezeRecordService;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   InboundService inboundService;
   @Resource
   InboundManufacturedService inboundManufacturedService;
   @Resource
   InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   private PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   private WmsApproveTemplateService wmsApproveTemplateService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SectionSteelSpecService sectionSteelSpecService;
   @Resource
   private SectionSteelSpecStandardDetailService sectionSteelSpecStandardDetailService;
   @Resource
   private StandardService standardService;
   @Resource
   private SpecificationService specificationService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private TechMesWmsManager techMesWmsManager;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   RejectDetailService rejectDetailService;
   @Resource
   BasicConfigService basicConfigService;
   private static final BigDecimal thousand = new BigDecimal("1000");

   @Override
   public PageVO<ApplyPurchaseDTO> pageInfo(
      List<LocalDateTime> times,
      Integer materialType,
      String serialNumber,
      Integer status,
      Boolean enabled,
      Boolean boolInitiateApprove,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(
         page,
         this.baseMapper
            .list(times, materialType, serialNumber, status, enabled, boolInitiateApprove)
            .stream()
            .peek(
               l -> {
                  if (l.getApproveProcessId() != null) {
                     l.setApproveInfoName(this.approveProcessService.getById(l.getApproveProcessId()).getApproveInfoName());
                  }

                  if (ApplyPurchaseMaterialTypeEnum.checkIsSteelAddOtherSteelMaterials(l.getMaterialType())) {
                     l.setTotalMete(this.applyPurchaseDetailMapper.getTotalMete(l.getId()));
                     l.setInboundMete(
                        this.inboundDetailService
                           .getListByApplyPurchaseId(l.getId())
                           .stream()
                           .map(InboundDetail::getMete)
                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                     );
                  }
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<ApplyPurchaseDTO> pageInfoV2(
      List<LocalDateTime> times,
      Integer materialType,
      String serialNumber,
      Integer status,
      Boolean enabled,
      Boolean boolInitiateApprove,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String departmentName,
      String applicantName,
      Long projectId,
      Integer projectAttribute,
      Integer purchaseCreationState,
      Integer level,
      Long branchCompanyId
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<ApplyPurchaseDTO> applyPurchaseDTOS = this.baseMapper
         .applyPurchaseDTOListV2(
            times,
            materialType,
            serialNumber,
            status,
            enabled,
            boolInitiateApprove,
            departmentName,
            applicantName,
            projectId,
            projectAttribute,
            purchaseCreationState,
            level,
            branchCompanyId
         );
      if (CollectionUtils.isEmpty(applyPurchaseDTOS)) {
         return new PageVO<>(page, applyPurchaseDTOS);
      }

      List<String> projectIdsList = applyPurchaseDTOS.stream()
         .filter(a -> ObjectUtil.isNotEmpty(a.getProjectIds()))
         .collect(Collectors.toList())
         .stream()
         .map(ApplyPurchaseDTO::getProjectIds)
         .collect(Collectors.toList());
      List<Long> applyIds = applyPurchaseDTOS.stream().map(ApplyPurchaseDTO::getId).collect(Collectors.toList());
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().in(ApplyPurchaseDetail::getApplyPurchaseId, applyIds));
      List<Long> classifyIds = applyPurchaseDetails.stream()
         .map(ApplyPurchaseDetail::getClassifyId)
         .filter(ObjectUtil::isNotEmpty)
         .distinct()
         .collect(Collectors.toList());
      List<MeasureDTO> measureDTOList = this.measureService.getMeasureDTO(classifyIds);
      List<ProjectInfo> projectInfos = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(projectIdsList)) {
         List<Long> projectIdList = new ArrayList<>();

         for (String string : projectIdsList) {
            List<Long> collect = Arrays.stream(string.split(",")).map(Long::valueOf).collect(Collectors.toList());
            projectIdList.addAll(collect);
         }

         List<ContractProject> contractProjects = this.contractProjectService.listByIds(projectIdList);
         projectInfos = BeanUtil.copyToList(contractProjects, ProjectInfo.class);
      }

      List<BranchCompany> branchCompanyList = this.branchCompanyService.list(null);
      Map<Long, BranchCompany> branchCompanyMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(branchCompanyList)) {
         branchCompanyMap = branchCompanyList.stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      }

      for (ApplyPurchaseDTO applyPurchaseDTO : applyPurchaseDTOS) {
         List<ApplyPurchaseDetail> details = applyPurchaseDetails.stream()
            .filter(a -> a.getApplyPurchaseId().equals(applyPurchaseDTO.getId()))
            .collect(Collectors.toList());
         this.calculateHaveAndUnPurchaseMete(applyPurchaseDTO, details, measureDTOList);
         this.calculateInboundMete(applyPurchaseDTO, details, measureDTOList);
         if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getProjectIds())) {
            String projectIds = applyPurchaseDTO.getProjectIds();
            List<Long> list = Arrays.stream(projectIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
            List<ProjectInfo> projectInfoList = projectInfos.stream().filter(p -> list.contains(p.getId())).collect(Collectors.toList());
            applyPurchaseDTO.setProjectInfos(projectInfoList);
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getBranchCompanyId())) {
            BranchCompany branchCompany = branchCompanyMap.get(applyPurchaseDTO.getBranchCompanyId());
            IdAndNameDTO copy = BeanUtil.toBean(branchCompany, IdAndNameDTO.class);
            applyPurchaseDTO.setBranchCompany(copy);
         }
      }

      return new PageVO<>(page, applyPurchaseDTOS);
   }

   private void calculateInboundMete(ApplyPurchaseDTO applyPurchaseDTO, List<ApplyPurchaseDetail> details, List<MeasureDTO> measureDTOList) {
      List<Long> applyDetailIds = details.stream().map(ApplyPurchaseDetail::getId).collect(Collectors.toList());
      if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchaseDTO.getType())) {
         List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService.selectPassDetailByApplyDetailIds(applyDetailIds);
         List<Long> purchaseDetailIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getId).collect(Collectors.toList());
         List<InboundDetailManufactured> inboundDetailManufactureds = this.inboundDetailManufacturedService
            .selectPassDetailByPurchaseDetailIds(purchaseDetailIds);
         BigDecimal sumInboundQuantity = inboundDetailManufactureds.stream()
            .map(InboundDetailManufactured::getQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal receivedQuantity = BigDecimal.ZERO;
         if (CollectionUtils.isNotEmpty(purchaseOrderDetails)) {
            List<Long> hasReceivingPurchaseDetailIds = this.receivingRecordService
               .list(Wrappers.lambdaQuery(ProjectReceivingRecord.class).in(ProjectReceivingRecord::getPurchaseDetailsId, purchaseDetailIds))
               .stream()
               .map(ProjectReceivingRecord::getPurchaseDetailsId)
               .distinct()
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(hasReceivingPurchaseDetailIds)) {
               receivedQuantity = this.purchaseOrderDetailService
                  .listByIds(hasReceivingPurchaseDetailIds)
                  .stream()
                  .map(PurchaseOrderDetail::getReceivedQuantity)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
            }
         }

         applyPurchaseDTO.setInboundMete(sumInboundQuantity.add(receivedQuantity));
      } else {
         List<Long> detailClassifyIds = details.stream().map(ApplyPurchaseDetail::getClassifyId).collect(Collectors.toList());
         List<MeasureDTO> detailMeasureDTOs = measureDTOList.stream()
            .filter(m -> detailClassifyIds.contains(m.getClassificationId()))
            .collect(Collectors.toList());
         TreeSet<MeasureDTO> measureDTOS = new TreeSet<>(Comparator.comparing(MeasureDTO::getUnitType));
         measureDTOS.addAll(detailMeasureDTOs);
         if (measureDTOS.size() > 1) {
            applyPurchaseDTO.setInboundMete(null);
         } else {
            List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService.selectPassDetailByApplyDetailIds(applyDetailIds);
            List<Long> purchaseDetailIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getId).collect(Collectors.toList());
            List<InboundDetail> inboundDetails = this.inboundDetailService.selectPassDetailByPurchaseDetailIds(purchaseDetailIds);
            BigDecimal sumInboundMete = inboundDetails.stream().map(InboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            List<Long> inboundDetailIds = inboundDetails.stream().map(InboundDetail::getId).collect(Collectors.toList());
            List<RejectDetail> rejectDetails = this.rejectDetailService.selectPassDetailByInboundDetailIds(inboundDetailIds);
            BigDecimal sumRejectMete = rejectDetails.stream().map(RejectDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal receivingMete = BigDecimal.ZERO;
            if (CollectionUtils.isNotEmpty(purchaseOrderDetails)) {
               List<Long> hasReceivingPurchaseDetailIds = this.receivingRecordService
                  .list(Wrappers.lambdaQuery(ProjectReceivingRecord.class).in(ProjectReceivingRecord::getPurchaseDetailsId, purchaseDetailIds))
                  .stream()
                  .map(ProjectReceivingRecord::getPurchaseDetailsId)
                  .distinct()
                  .collect(Collectors.toList());
               if (CollectionUtil.isNotEmpty(hasReceivingPurchaseDetailIds)) {
                  receivingMete = this.purchaseOrderDetailService
                     .listByIds(hasReceivingPurchaseDetailIds)
                     .stream()
                     .map(PurchaseOrderDetail::getReceivedMete)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
               }
            }

            BigDecimal realityInboundMete = sumInboundMete.add(receivingMete).subtract(sumRejectMete);
            MeasureDTO firstMeasureDTO = measureDTOS.first();
            if (UnitEnum.DIGIT.getType().equals(firstMeasureDTO.getUnitType())) {
               applyPurchaseDTO.setInboundMete(realityInboundMete);
               applyPurchaseDTO.setMeteUnit(null);
            } else if (UnitEnum.WEIGHT.getType().equals(firstMeasureDTO.getUnitType())) {
               applyPurchaseDTO.setInboundMete(realityInboundMete.divide(UnitsPrecisionEnum.EG_T.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("吨");
            } else if (UnitEnum.LENGTH.getType().equals(firstMeasureDTO.getUnitType())) {
               applyPurchaseDTO.setInboundMete(realityInboundMete.divide(UnitsPrecisionEnum.LG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("米");
            } else if (UnitEnum.AREA.getType().equals(firstMeasureDTO.getUnitType())) {
               applyPurchaseDTO.setInboundMete(realityInboundMete.divide(UnitsPrecisionEnum.AG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("平方米");
            } else if (UnitEnum.VOLUME.getType().equals(firstMeasureDTO.getUnitType())) {
               applyPurchaseDTO.setInboundMete(realityInboundMete.divide(UnitsPrecisionEnum.VG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("立方米");
            } else {
               Preconditions.checkArgument(false, "未知单位类型！！！");
            }
         }
      }
   }

   private void calculateHaveAndUnPurchaseMete(ApplyPurchaseDTO applyPurchaseDTO, List<ApplyPurchaseDetail> details, List<MeasureDTO> measureDTOList) {
      if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchaseDTO.getType())) {
         BigDecimal sumProductQuantity = details.stream().map(ApplyPurchaseDetail::getProductQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
         applyPurchaseDTO.setHavePurchasedMete(sumProductQuantity);
         BigDecimal sumApplyQuantity = details.stream().map(ApplyPurchaseDetail::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
         applyPurchaseDTO.setUnPurchaseMete(sumApplyQuantity.subtract(sumProductQuantity));
      } else {
         List<Long> detailClassifyIds = details.stream().map(ApplyPurchaseDetail::getClassifyId).collect(Collectors.toList());
         List<MeasureDTO> detailMeasureDTOs = measureDTOList.stream()
            .filter(m -> detailClassifyIds.contains(m.getClassificationId()))
            .collect(Collectors.toList());
         TreeSet<MeasureDTO> measureDTOS = new TreeSet<>(Comparator.comparing(MeasureDTO::getUnitType));
         measureDTOS.addAll(detailMeasureDTOs);
         if (measureDTOS.size() > 1) {
            applyPurchaseDTO.setHavePurchasedMete(null);
            applyPurchaseDTO.setUnPurchaseMete(null);
         } else {
            BigDecimal havePurchaseMete = new BigDecimal("0");
            BigDecimal unPurchaseMete = new BigDecimal("0");
            MeasureDTO firstMeasureDTO = measureDTOS.first();
            if (UnitEnum.DIGIT.getType().equals(firstMeasureDTO.getUnitType())) {
               for (ApplyPurchaseDetail detail : details) {
                  havePurchaseMete = havePurchaseMete.add(detail.getProductMete());
                  if (detail.getProductMete().compareTo(detail.getMete()) <= -1) {
                     unPurchaseMete = unPurchaseMete.add(detail.getMete().subtract(detail.getProductMete()));
                  }
               }

               applyPurchaseDTO.setHavePurchasedMete(havePurchaseMete);
               applyPurchaseDTO.setUnPurchaseMete(unPurchaseMete);
               applyPurchaseDTO.setMeteUnit(null);
            } else if (UnitEnum.WEIGHT.getType().equals(firstMeasureDTO.getUnitType())) {
               for (ApplyPurchaseDetail detail : details) {
                  havePurchaseMete = havePurchaseMete.add(detail.getProductMete());
                  if (detail.getProductMete().compareTo(detail.getMete()) <= -1) {
                     unPurchaseMete = unPurchaseMete.add(detail.getMete().subtract(detail.getProductMete()));
                  }
               }

               applyPurchaseDTO.setHavePurchasedMete(havePurchaseMete.divide(UnitsPrecisionEnum.EG_T.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setUnPurchaseMete(unPurchaseMete.divide(UnitsPrecisionEnum.EG_T.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("吨");
            } else if (UnitEnum.LENGTH.getType().equals(firstMeasureDTO.getUnitType())) {
               for (ApplyPurchaseDetail detail : details) {
                  havePurchaseMete = havePurchaseMete.add(detail.getProductMete());
                  if (detail.getProductMete().compareTo(detail.getMete()) <= -1) {
                     unPurchaseMete = unPurchaseMete.add(detail.getMete().subtract(detail.getProductMete()));
                  }
               }

               applyPurchaseDTO.setHavePurchasedMete(havePurchaseMete.divide(UnitsPrecisionEnum.LG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setUnPurchaseMete(unPurchaseMete.divide(UnitsPrecisionEnum.LG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("米");
            } else if (UnitEnum.AREA.getType().equals(firstMeasureDTO.getUnitType())) {
               for (ApplyPurchaseDetail detail : details) {
                  havePurchaseMete = havePurchaseMete.add(detail.getProductMete());
                  if (detail.getProductMete().compareTo(detail.getMete()) <= -1) {
                     unPurchaseMete = unPurchaseMete.add(detail.getMete().subtract(detail.getProductMete()));
                  }
               }

               applyPurchaseDTO.setHavePurchasedMete(havePurchaseMete.divide(UnitsPrecisionEnum.AG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setUnPurchaseMete(unPurchaseMete.divide(UnitsPrecisionEnum.AG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("平方米");
            } else if (UnitEnum.VOLUME.getType().equals(firstMeasureDTO.getUnitType())) {
               for (ApplyPurchaseDetail detail : details) {
                  havePurchaseMete = havePurchaseMete.add(detail.getProductMete());
                  if (detail.getProductMete().compareTo(detail.getMete()) <= -1) {
                     unPurchaseMete = unPurchaseMete.add(detail.getMete().subtract(detail.getProductMete()));
                  }
               }

               applyPurchaseDTO.setHavePurchasedMete(havePurchaseMete.divide(UnitsPrecisionEnum.VG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setUnPurchaseMete(unPurchaseMete.divide(UnitsPrecisionEnum.VG_M.getRate(), 3, RoundingMode.HALF_UP));
               applyPurchaseDTO.setMeteUnit("立方米");
            } else {
               Preconditions.checkArgument(false, "未知单位类型！！！");
            }
         }
      }
   }

   @Override
   public PageVO<ApplyPurchaseDTO> getListAndDetailPageInfoV2(
      List<LocalDateTime> times,
      Integer materialType,
      String serialNumber,
      Integer status,
      Boolean enabled,
      Boolean boolInitiateApprove,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      String departmentName,
      String applicantName,
      Long projectId,
      Integer projectAttribute,
      Integer purchaseCreationState,
      Integer level,
      Long branchCompanyId
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<ApplyPurchaseDTO> applyPurchaseDTOS = this.baseMapper
         .applyPurchaseDTOListV2(
            times,
            materialType,
            serialNumber,
            status,
            enabled,
            boolInitiateApprove,
            departmentName,
            applicantName,
            projectId,
            projectAttribute,
            purchaseCreationState,
            level,
            branchCompanyId
         )
         .stream()
         .peek(l -> {
            if (l.getApproveProcessId() != null) {
               l.setApproveInfoName(this.approveProcessService.getById(l.getApproveProcessId()).getApproveInfoName());
            }

            if (ObjectUtil.isNotEmpty(l.getMaterialType()) && ApplyPurchaseMaterialTypeEnum.checkIsSteelAddOtherSteelMaterials(l.getMaterialType())) {
               l.setTotalMete(this.applyPurchaseDetailMapper.getTotalMete(l.getId()));
            }

            if (ObjectUtil.isNotEmpty(l.getBranchCompanyId())) {
               BranchCompany branchCompany = this.branchCompanyService.getById(l.getBranchCompanyId());
               IdAndNameDTO andNameDTO = IdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build();
               l.setBranchCompany(andNameDTO);
            }
         })
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(applyPurchaseDTOS)) {
         List<Long> ids = applyPurchaseDTOS.stream().map(ApplyPurchaseDTO::getId).collect(Collectors.toList());
         List<ApplyPurchaseDetail> applyPurchaseDetailsAll = this.applyPurchaseDetailMapper
            .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().in(ApplyPurchaseDetail::getApplyPurchaseId, ids));
         List<Long> classifyIds = applyPurchaseDetailsAll.stream()
            .map(ApplyPurchaseDetail::getClassifyId)
            .filter(ObjectUtil::isNotEmpty)
            .distinct()
            .collect(Collectors.toList());
         List<MeasureDTO> measureDTOList = this.measureService.getMeasureDTO(classifyIds);
         List<String> projectIdsList = applyPurchaseDTOS.stream()
            .filter(a -> ObjectUtil.isNotEmpty(a.getProjectIds()))
            .collect(Collectors.toList())
            .stream()
            .map(ApplyPurchaseDTO::getProjectIds)
            .collect(Collectors.toList());
         List<ProjectInfo> projectInfos = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(projectIdsList)) {
            List<Long> projectIdList = new ArrayList<>();

            for (String string : projectIdsList) {
               List<Long> collect = Arrays.stream(string.split(",")).map(Long::valueOf).collect(Collectors.toList());
               projectIdList.addAll(collect);
            }

            List<ContractProject> contractProjects = this.contractProjectService.listByIds(projectIdList);
            projectInfos = BeanUtil.copyToList(contractProjects, ProjectInfo.class);
         }

         for (ApplyPurchaseDTO applyPurchaseDTO : applyPurchaseDTOS) {
            List<ApplyPurchaseDetail> applyPurchaseDetails = applyPurchaseDetailsAll.stream()
               .filter(a -> a.getApplyPurchaseId().equals(applyPurchaseDTO.getId()))
               .collect(Collectors.toList());
            List<ApplyPurchaseDetailDTO> applyPurchaseDetailDTOS = new ArrayList<>();

            for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
               ApplyPurchaseDetailDTO copy = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchaseDetail, ApplyPurchaseDetailDTO.class);
               if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getProjectId())) {
                  ProjectInfo projectInfo = projectInfos.stream().filter(p -> p.getId().equals(applyPurchaseDetail.getProjectId())).findAny().orElse(null);
                  copy.setProject(projectInfo);
               }

               applyPurchaseDetailDTOS.add(copy);
            }

            this.calculateHaveAndUnPurchaseMete(applyPurchaseDTO, applyPurchaseDetails, measureDTOList);
            this.calculateInboundMete(applyPurchaseDTO, applyPurchaseDetails, measureDTOList);
            applyPurchaseDTO.setDetailList(applyPurchaseDetailDTOS);
            if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getProjectIds())) {
               String projectIds = applyPurchaseDTO.getProjectIds();
               List<Long> list = Arrays.stream(projectIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
               List<ProjectInfo> projectInfoList = projectInfos.stream().filter(p -> list.contains(p.getId())).collect(Collectors.toList());
               applyPurchaseDTO.setProjectInfos(projectInfoList);
            }
         }
      }

      return new PageVO<>(page, applyPurchaseDTOS);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean save(ApplyPurchaseDTOParam param) {
      Boolean status = this.approveProcessService.getStatus();
      if (status) {
         Preconditions.checkArgument(StrUtil.isNotBlank(MapConstants.getStringConstantsMap().get("ddAccessToken")), "钉钉审批未启用,请联系管理员启用");
         ApproveProcess approveProcess = this.approveProcessService.getById(param.getApproveProcessId());
         Preconditions.checkArgument(approveProcess != null, "申购失败，审批流程异常");
         Preconditions.checkArgument(CommonUtil.spilt(approveProcess.getApplicantIds(), ",").contains(UserUtil.getCurrentUserId()), "当前用户不可发起申购审批");
      }

      if (!param.getType().equals(ApplyPurchaseTypeEnum.PUBLIC.getType())) {
         Preconditions.checkArgument(param.getProjectId() != null, "非公共库申购,请选择项目");
      }

      ApplyPurchase applyPurchase = ApplyPurchase.builder()
         .projectId(param.getProjectId())
         .type(param.getType())
         .reviewStatus(status ? ReviewStatusEnum.REVIEWED.getType() : ReviewStatusEnum.UN_REVIEWED.getType())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .materialType(param.getMaterialType())
         .userUpdateTime(LocalDateTime.now())
         .approveProcessId(param.getApproveProcessId())
         .remark(param.getRemark())
         .boolInitiateApprove(status)
         .purchaseCreationState(ApplyPurchaseStateEnum.NOT_STARTED.getType())
         .build();
      ContractProject project = this.projectService.getById(param.getProjectId());
      int count = this.baseMapper.getCountByDate();
      String s;
      if (project != null) {
         s = project.getShortName() + "-";
      } else {
         s = "公备-";
      }

      applyPurchase.setSerialNumber(s + DateTimeUtils.getCurrentDateOfYYMMDD() + "-" + NumberUtils.getDigitsNumber(count + 1, 2));
      this.baseMapper.insert(applyPurchase);
      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(applyPurchase.getProjectId())
               .dataId(applyPurchase.getId())
               .contentDetails(this.detailsUtils.getSubscribeTemplateDetails(String.valueOf(applyPurchase.getProjectId()), applyPurchase.getSerialNumber()))
               .notificationTypeEnum(NotificationModuleTypeEnum.SUBSCRIBE.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      List<ApplyPurchaseEnclosure> list = null;
      List<String> basicClassNames = null;
      if (status) {
         list = new ArrayList<>();
         basicClassNames = new ArrayList<>();
      }

      this.setDetail(param, applyPurchase, list, basicClassNames);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(applyPurchase.getClassifyIds()).build());
      if (CollectionUtils.isNotEmpty(list)) {
         this.initiateApproval(applyPurchase, list, basicClassNames);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveV2(ApplyPurchaseDTOParam param, Boolean boolAgainSubmit) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      this.checkApplyPurchase(param);
      ApplyPurchase applyPurchase = ApplyPurchase.builder()
         .applicantId(currentUser.getId())
         .applicantName(currentUser.getName())
         .departmentId(currentUser.getDepartment().getId())
         .departmentName(currentUser.getDepartment().getName())
         .materialType(param.getMaterialType())
         .userUpdateTime(LocalDateTime.now())
         .remark(param.getRemark())
         .tsData(param.getTsData())
         .boolIsProjectDetail(param.getBoolIsProjectDetail())
         .projectIds(param.getProjectIds())
         .boolTemporaryStorage(param.getBoolTemporaryStorage())
         .parentId(param.getParentId())
         .dataStatus(param.getDataStatus())
         .projectAttribute(param.getProjectAttribute())
         .branchCompanyId(param.getBranchCompanyId())
         .classifyIds(param.getClassifyIds())
         .passParentId(boolAgainSubmit ? param.getId() : null)
         .purchaseCreationState(boolAgainSubmit ? param.getPurchaseCreationState() : null)
         .type(param.getType())
         .finishedProductType(param.getFinishedProductType())
         .build();
      applyPurchase.setAttachmentsStr(CollectionUtil.isNotEmpty(param.getAttachmentIds()) ? StrUtil.join(",", param.getAttachmentIds()) : null);
      if (param.getBranchCompanyId() != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
         if (branchCompany != null) {
            Optional.ofNullable(branchCompany.getLevel()).ifPresent(applyPurchase::setLevel);
            Optional.ofNullable(branchCompany.getBranchAttributeEnum()).ifPresent(applyPurchase::setBranchAttributeEnum);
         }

         if (ObjectUtil.isNotEmpty(param.getProjectIds())) {
            this.projectService.checkContractSignBodyId(null, null, param.getProjectIds(), param.getBranchCompanyId());
         }
      }

      this.creatApplyPurchaseSD(param);
      applyPurchase.setBoolSysgen(param.getBoolSysgen());
      applyPurchase.setSerialNumberParent(param.getSerialNumberParent());
      applyPurchase.setSerialNumber(param.getSerialNumber());
      if (param.getBoolTemporaryStorage()) {
         applyPurchase.setBoolInitiateApprove(Boolean.FALSE);
         return this.baseMapper.insert(applyPurchase) == 1;
      }

      applyPurchase.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      applyPurchase.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
      applyPurchase.setBoolInitiateApprove(Boolean.TRUE);
      this.baseMapper.insert(applyPurchase);
      List<ApplyPurchaseEnclosure> list = null;
      List<String> basicClassNames = null;
      this.setDetailV2(param, applyPurchase, list, basicClassNames);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(applyPurchase.getClassifyIds()).build());
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            applyPurchase.getId(),
            applyPurchase.getSerialNumber(),
            boolAgainSubmit ? ApproveProcessTypeEnumV2.APPLY_PURCHASE_UPDATE_ADD.getType() : ApproveProcessTypeEnumV2.APPLY_PURCHASE_ADD.getType(),
            param.getCause(),
            null,
            null,
            false,
            null,
            null,
            null
         );
      applyPurchase.setApproveRecordIds(String.valueOf(wmsApproveRecord.getId()));
      applyPurchase.setApproveRecordIdNow(wmsApproveRecord.getId());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         applyPurchase.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         applyPurchase.setDataStatus(DataStatusEnum.SUCCEED.getType());
         if (ObjectUtil.isEmpty(applyPurchase.getPurchaseCreationState())) {
            applyPurchase.setPurchaseCreationState(ApplyPurchaseStateEnum.NOT_STARTED.getType());
         }

         if (ObjectUtil.isNotEmpty(applyPurchase.getPassParentId()) && ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
            ApplyPurchase oldApplyPurchase = this.baseMapper.getByIdAll(applyPurchase.getPassParentId());
            this.applyBoolAgainSubmitManufactured(oldApplyPurchase, applyPurchase, true);
         }
      }

      this.baseMapper.updateById(applyPurchase);
      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(applyPurchase.getProjectId())
               .dataId(applyPurchase.getId())
               .contentDetails(this.detailsUtils.getSubscribeTemplateDetails(applyPurchase.getProjectIds(), applyPurchase.getSerialNumber()))
               .notificationTypeEnum(NotificationModuleTypeEnum.SUBSCRIBE.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return true;
   }

   @Override
   public ApplyPurchaseDTO selectById(Long id) {
      ApplyPurchaseDTO purchaseDTO = this.baseMapper.getById(id);
      Preconditions.checkArgument(purchaseDTO != null, "当前申购单不存在,请核对后操作");
      ApproveProcess approveProcess = this.approveProcessService.getById(purchaseDTO.getApproveProcessId());
      purchaseDTO.setApproveInfoName(approveProcess != null ? approveProcess.getApproveInfoName() : null);
      List<ApplyPurchaseDetail> list = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, purchaseDTO.getId()));
      List<ApplyPurchaseDetailDTO> dtoList = list.stream()
         .map(
            d -> {
               ApplyPurchaseDetailDTO dto = com.hzchum.pangu.common.util.BeanUtil.copy(d, ApplyPurchaseDetailDTO.class);
               if (dto.getMaterialInventoryId() != null) {
                  MaterialInventoryDTO mat = this.materialInventoryService.getMatById(dto.getMaterialInventoryId());
                  if (mat != null) {
                     dto.setMaterialFreezeNum(
                        MaterialFreezeNumDTO.builder()
                           .mete(mat.getMete())
                           .quantity(mat.getQuantity())
                           .frozenMete(mat.getFrozenMete())
                           .frozenQuantity(mat.getFrozenQuantity())
                           .build()
                     );
                  }
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      purchaseDTO.setDetailList(dtoList);
      return purchaseDTO;
   }

   @Override
   public ApplyPurchaseDTO selectByIdV2(Long id) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      ApplyPurchaseDTO applyPurchaseDTO = BeanUtil.toBean(applyPurchase, ApplyPurchaseDTO.class);
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      List<ProjectInfo> projectInfoList = new ArrayList<>();
      List<Long> projectIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getProjectId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      if (ObjectUtil.isNotEmpty(projectIds)) {
         projectInfoList = this.projectService.getSimpleByIds(projectIds);
         applyPurchaseDTO.setProjectInfos(projectInfoList);
      }

      List<ApplyPurchaseDetailDTO> applyPurchaseDetailDTOS = new ArrayList<>();
      List<Long> monomerIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getMonomerId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      List<Long> areaIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getAreaId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);
      List<Long> applyDetailIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getId).collect(Collectors.toList());
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService.selectPassDetailByApplyDetailIds(applyDetailIds);
      List<Long> purchaseDetailIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getId).collect(Collectors.toList());
      List<InboundDetail> inboundDetails = this.inboundDetailService.selectPassDetailByPurchaseDetailIds(purchaseDetailIds);
      List<Long> inboundDetailIds = inboundDetails.stream().map(InboundDetail::getId).collect(Collectors.toList());
      List<RejectDetail> rejectDetails = this.rejectDetailService.selectPassDetailByInboundDetailIds(inboundDetailIds);

      for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
         ApplyPurchaseDetailDTO copy = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchaseDetail, ApplyPurchaseDetailDTO.class);
         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getProjectId())) {
            ProjectInfo projectInfo = projectInfoList.stream().filter(p -> p.getId().equals(applyPurchaseDetail.getProjectId())).findAny().orElse(null);
            copy.setProject(projectInfo);
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getMonomerId())) {
            PlanMonomer monomer = planMonomerMap.get(applyPurchaseDetail.getMonomerId());
            copy.setMonomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getAreaId())) {
            PlanArea area = planAreaMap.get(applyPurchaseDetail.getAreaId());
            copy.setArea(NameInfo.builder().id(area.getId()).name(area.getName()).build());
         }

         if (copy.getAccountingUnit() != null) {
            String symbol = this.unitService
               .getOne(new LambdaQueryWrapper<Unit>().eq(copy.getAccountingUnit() != null, Unit::getName, copy.getAccountingUnit()))
               .getSymbol();
            copy.setSymbol(symbol);
         }

         BigDecimal unPurchaseMete = new BigDecimal("0");
         if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
            if (applyPurchaseDetail.getProductQuantity().compareTo(applyPurchaseDetail.getQuantity()) > -1) {
               unPurchaseMete = BigDecimal.ZERO;
            } else {
               unPurchaseMete = unPurchaseMete.add(applyPurchaseDetail.getQuantity().subtract(applyPurchaseDetail.getProductQuantity()));
            }
         } else if (applyPurchaseDetail.getProductMete().compareTo(applyPurchaseDetail.getMete()) > -1) {
            unPurchaseMete = BigDecimal.ZERO;
         } else {
            unPurchaseMete = unPurchaseMete.add(applyPurchaseDetail.getMete().subtract(applyPurchaseDetail.getProductMete()));
         }

         if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
            copy.setHavePurchasedMete(applyPurchaseDetail.getProductQuantity());
         } else {
            copy.setHavePurchasedMete(applyPurchaseDetail.getProductMete());
         }

         copy.setUnPurchaseMete(unPurchaseMete);
         copy.setInboundMete(this.getInboundMete(applyPurchaseDetail.getId()));
         applyPurchaseDetailDTOS.add(copy);
      }

      applyPurchaseDTO.setDetailList(applyPurchaseDetailDTOS);
      if (!applyPurchase.getBoolTemporaryStorage()) {
         List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS = new ArrayList<>();
         if (ObjectUtil.isNotEmpty(applyPurchase.getApproveRecordIds())) {
            String approveRecordIds = applyPurchase.getApproveRecordIds();

            for (Long approveRecordId : Arrays.stream(approveRecordIds.split(",")).map(Long::valueOf).collect(Collectors.toList())) {
               WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(approveRecordId);
               wmsApproveRecordFlowDTOS.add(approveRecordFlowDTO);
            }
         }

         applyPurchaseDTO.setWmsApproveRecordFlowDTOS(wmsApproveRecordFlowDTOS);
      }

      if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getBranchCompanyId())) {
         BranchCompany byId = this.branchCompanyService.getById(applyPurchaseDTO.getBranchCompanyId());
         IdAndNameDTO copy = BeanUtil.toBean(byId, IdAndNameDTO.class);
         applyPurchaseDTO.setBranchCompany(copy);
      }

      if (StrUtil.isNotBlank(applyPurchase.getAttachmentsStr())) {
         applyPurchaseDTO.setAttachments(this.attachmentService.listByIds(applyPurchase.getAttachmentsStr()));
      }

      applyPurchaseDTO.setDelButtonType(DelButtonTypeEnum.BU_ZHAN_SHI.getType());
      if (ObjectUtil.isNotEmpty(applyPurchase.getDataStatus())) {
         if (applyPurchase.getDataStatus().equals(DataStatusEnum.SUCCEED.getType())) {
            applyPurchaseDTO.setDelButtonType(DelButtonTypeEnum.SHAN_CHU.getType());
         }

         if (applyPurchase.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType())) {
            if (ObjectUtil.isNotEmpty(applyPurchase.getPassParentId())) {
               applyPurchaseDTO.setDelButtonType(DelButtonTypeEnum.CHE_XIAO_BIAN_JI.getType());
            } else {
               applyPurchaseDTO.setDelButtonType(DelButtonTypeEnum.CHE_XIAO.getType());
            }
         }

         if (applyPurchase.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType())) {
            applyPurchaseDTO.setDelButtonType(DelButtonTypeEnum.CHE_XIAO_SHAN_CHU.getType());
         }
      }

      applyPurchaseDTO.setBoolUsed(this.checkCancellation(applyPurchase.getId(), false));
      return applyPurchaseDTO;
   }

   @Override
   public void updateStatus(Long id, Integer status) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      if (applyPurchase != null) {
         applyPurchase.setReviewStatus(status);
         this.baseMapper.updateById(applyPurchase);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(Long id) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      Preconditions.checkArgument(applyPurchase != null, "当前申购单不存在,请核对后操作");
      applyPurchase.setReviewStatus(ApproveStatusEnum.CANCEL.getType());
      applyPurchase.setReviewTime(LocalDateTime.now());
      applyPurchase.setUserUpdateTime(LocalDateTime.now());
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
      if (ObjectUtil.isNotEmpty(applyPurchase.getClassifyIds())) {
         idsStatusDTO.setIdsStr(applyPurchase.getClassifyIds());
      } else {
         List<Long> classifyIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getClassifyId).collect(Collectors.toList());
         idsStatusDTO.setIds(classifyIds);
      }

      idsStatusDTO.setDataType(1);
      idsStatusDTO.setDataId(applyPurchase.getId());
      this.deleteDetail(applyPurchase, applyPurchaseDetails);
      this.classificationService.deleteDataUpdateClass(idsStatusDTO);
      if (applyPurchase.getBoolInitiateApprove()) {
         ApproveInstance approveInstance = this.approveInstanceService
            .getOne((Wrapper<ApproveInstance>)Wrappers.<ApproveInstance>lambdaQuery().eq(ApproveInstance::getActualId, id));
         if (approveInstance != null) {
            DingDingUtils.terminateProcessInstance(approveInstance.getInstanceId());
            approveInstance.setStatus(ApproveStatusEnum.CANCEL.getType());
            this.approveInstanceService.updateById(approveInstance);
         }

         return this.baseMapper.updateById(applyPurchase) == 1;
      } else {
         return this.baseMapper.deleteById(applyPurchase) == 1;
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteV2(Long id) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      Preconditions.checkArgument(applyPurchase != null, "当前申购单不存在,请核对后操作");
      Preconditions.checkArgument(
         applyPurchase.getBoolTemporaryStorage() || applyPurchase.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()), "申购单状态为-暂存-结束-状态时才可进行删除"
      );
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService
         .list((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getApplyPurchaseId, applyPurchase.getId()));
      if (CollectionUtils.isNotEmpty(purchaseOrderDetails)) {
         List<Long> purchaseIds = purchaseOrderDetails.stream()
            .map(PurchaseOrderDetail::getPurchaseId)
            .collect(Collectors.toList())
            .stream()
            .distinct()
            .collect(Collectors.toList());
         List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(purchaseIds);
         if (CollectionUtils.isNotEmpty(purchaseOrders)) {
            List<PurchaseOrder> collect = purchaseOrders.stream()
               .filter(
                  p -> p.getDataStatus().equals(DataStatusEnum.SUCCEED.getType())
                     || p.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType())
                     || p.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType())
               )
               .collect(Collectors.toList());
            List<String> serialNumberList = collect.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(serialNumberList), "该申购单已被采购单引用，采购单编号:" + serialNumberList + ",删除失败");
         }
      }

      applyPurchase.setUserUpdateTime(LocalDateTime.now());
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
      if (ObjectUtil.isNotEmpty(applyPurchase.getClassifyIds())) {
         idsStatusDTO.setIdsStr(applyPurchase.getClassifyIds());
      } else {
         List<Long> classifyIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getClassifyId).collect(Collectors.toList());
         idsStatusDTO.setIds(classifyIds);
      }

      this.deleteDetail(applyPurchase, applyPurchaseDetails);
      this.baseMapper.deleteById(applyPurchase);
      this.classificationService.deleteDataUpdateClass(idsStatusDTO);
      return true;
   }

   @Override
   public PrintVO print(Long id) {
      ApplyPurchaseDTO applyPurchaseDTO = this.selectByIdV2(id);
      PrintVO vo = new PrintVO();
      Map<String, Object> header = vo.initHeader(UserUtil.getCurrentName());
      header.put("createTime", applyPurchaseDTO.getCreateTime());
      header.put("department", applyPurchaseDTO.getDepartmentName());
      header.put("branchCompany", applyPurchaseDTO.getBranchCompany().getName());
      header.put("purchaseCreationState", applyPurchaseDTO.getPurchaseCreationState());
      header.put("applicantName", applyPurchaseDTO.getApplicantName());
      header.put("project", applyPurchaseDTO.getProject());
      header.put("type", applyPurchaseDTO.getType());
      header.put("serialNumber", applyPurchaseDTO.getSerialNumber());
      header.put("remark", applyPurchaseDTO.getRemark());
      header.put("approveInfoName", applyPurchaseDTO.getApproveInfoName());
      List<ApplyPurchaseDetailDTO> table = applyPurchaseDTO.getDetailList();
      vo.setHeader(header);
      vo.setTable(table);
      return vo;
   }

   @Override
   public Boolean checkClassify(Long classifyId) {
      Integer i = this.applyPurchaseDetailMapper
         .selectCount((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getClassifyId, classifyId));
      Integer i1 = this.baseMapper.selectCount((Wrapper<ApplyPurchase>)new LambdaQueryWrapper<ApplyPurchase>().last("and find_in_set(" + classifyId + ",classify_ids)"));
      return i <= 0 && i1 <= 0 ? false : true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateEnabled(Long id, boolean enabled) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      Preconditions.checkArgument(applyPurchase != null, "当前申购单不存在,请核对后操作");
      applyPurchase.setEnabled(enabled);
      return this.baseMapper.updateById(applyPurchase) == 1;
   }

   @Override
   public ListVO<BriefIdAndSNDTO> briefList(List<LocalDateTime> times, Integer materialType, Boolean filterUseInventory, Integer purchaseCreationState) {
      LambdaQueryWrapper<ApplyPurchase> applyPurchaseLambdaQueryWrapper = (LambdaQueryWrapper<ApplyPurchase>)((((Wrappers.<ApplyPurchase>lambdaQuery()
                     .eq(ApplyPurchase::getEnabled, 1))
                  .eq(purchaseCreationState != null, ApplyPurchase::getPurchaseCreationState, purchaseCreationState))
               .eq(ApplyPurchase::getMaterialType, materialType))
            .orderByAsc(ApplyPurchase::getPurchaseCreationState))
         .orderByAsc(ApplyPurchase::getId);
      if (CollectionUtils.isNotEmpty(times)) {
         applyPurchaseLambdaQueryWrapper.lt(BaseEntity::getCreateTime, times.get(1)).gt(BaseEntity::getCreateTime, times.get(0));
      }

      return new ListVO<>(
         this.baseMapper
            .selectList(applyPurchaseLambdaQueryWrapper)
            .stream()
            .filter(
               l -> filterUseInventory
                  ? this.applyPurchaseDetailMapper
                        .selectCount(
                           (Wrapper<ApplyPurchaseDetail>)(Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, l.getId()))
                              .isNull(ApplyPurchaseDetail::getMaterialInventoryId)
                        )
                     > 0
                  : true
            )
            .map(l -> BriefIdAndSNDTO.builder().id(l.getId()).serialNumber(l.getSerialNumber()).purchaseCreationState(l.getPurchaseCreationState()).build())
            .collect(Collectors.toList())
      );
   }

   @Override
   public Boolean updateInfo(ApplyPurchaseDTOParam param) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(applyPurchase != null, "当前申购单不存在");
      List<PurchaseOrderDetail> list1 = this.purchaseOrderDetailService
         .list((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getApplyPurchaseId, param.getId()));
      Preconditions.checkArgument(CollectionUtil.isEmpty(list1), "当前申购单已经绑定，请勿修改");
      com.hzchum.pangu.common.util.BeanUtil.copy(param, applyPurchase);
      applyPurchase.setUserUpdateTime(LocalDateTime.now());
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
      if (ObjectUtil.isNotEmpty(applyPurchase.getClassifyIds())) {
         idsStatusDTO.setIdsStr(applyPurchase.getClassifyIds());
      } else {
         List<Long> classifyIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getClassifyId).collect(Collectors.toList());
         idsStatusDTO.setIds(classifyIds);
      }

      this.deleteDetail(applyPurchase, applyPurchaseDetails);
      this.classificationService.deleteDataUpdateClass(idsStatusDTO);
      Boolean status = this.approveProcessService.getStatus();
      if (status) {
         ApproveInstance approveInstance = this.approveInstanceService
            .getOne((Wrapper<ApproveInstance>)Wrappers.<ApproveInstance>lambdaQuery().eq(ApproveInstance::getActualId, applyPurchase.getId()));
         if (approveInstance != null) {
            DingDingUtils.terminateProcessInstance(approveInstance.getInstanceId());
            approveInstance.setStatus(ApproveStatusEnum.CANCEL.getType());
            this.approveInstanceService.updateById(approveInstance);
         }
      }

      this.materialFreezeService.materialUnfreeze(applyPurchase.getId(), -1L, MaterialFreezeTypeEnum.REQUISITIONS.getType(), false);
      List<ApplyPurchaseEnclosure> list = null;
      List<String> basicClassNames = null;
      if (status) {
         list = new ArrayList<>();
         basicClassNames = new ArrayList<>();
      }

      this.setDetail(param, applyPurchase, list, basicClassNames);
      this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(applyPurchase.getClassifyIds()).build());
      if (CollectionUtils.isNotEmpty(list)) {
         this.initiateApproval(applyPurchase, list, basicClassNames);
      }

      return this.baseMapper.updateById(applyPurchase) == 1;
   }

   @Override
   public List<ApplyPurchaseDetailDTO> canPurchaseDetail(List<Long> ids) {
      List<ApplyPurchaseDetail> list = this.applyPurchaseDetailMapper
         .selectList(
            (Wrapper<ApplyPurchaseDetail>)(Wrappers.<ApplyPurchaseDetail>lambdaQuery().isNull(ApplyPurchaseDetail::getMaterialInventoryId))
               .in(ApplyPurchaseDetail::getApplyPurchaseId, ids)
         );
      return list.stream().map(l -> {
         if (l.getArtifactEnclosureId() != null) {
            ArtifactDTO artifactDTO = this.artifactService.getInfoById(l.getArtifactEnclosureId());
            ApplyPurchaseDetailDTO dto = com.hzchum.pangu.common.util.BeanUtil.copy(artifactDTO, ApplyPurchaseDetailDTO.class);
            dto.setQuantity(l.getQuantity());
            dto.setNetWeight(artifactDTO.getNetWeight());
            return dto;
         } else {
            return com.hzchum.pangu.common.util.BeanUtil.copy(l, ApplyPurchaseDetailDTO.class);
         }
      }).collect(Collectors.toList());
   }

   @Override
   public List<ApplyPurchaseDetailDTO> canPurchaseDetailV2(List<Long> ids) {
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().in(ApplyPurchaseDetail::getApplyPurchaseId, ids));
      List<ApplyPurchaseDetailDTO> applyPurchaseDetailDTOS = new ArrayList<>();
      List<Long> monomerIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getMonomerId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, PlanMonomer> planMonomerMap = this.queryUtilService.getMonomerMapByIds(monomerIds);
      List<Long> areaIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getAreaId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      Map<Long, PlanArea> planAreaMap = this.queryUtilService.getAreaMapByIds(areaIds);
      List<Long> projectIds = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getProjectId).filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
      List<ProjectInfo> projectInfoList = this.projectService.listSimpleByIdList(projectIds);

      for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
         ApplyPurchaseDetailDTO copy = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchaseDetail, ApplyPurchaseDetailDTO.class);
         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getProjectId())) {
            ProjectInfo projectInfo = projectInfoList.stream().filter(p -> p.getId().equals(applyPurchaseDetail.getProjectId())).findAny().orElse(null);
            copy.setProject(projectInfo);
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getMonomerId())) {
            PlanMonomer monomer = planMonomerMap.get(applyPurchaseDetail.getMonomerId());
            copy.setMonomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build());
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDetail.getAreaId())) {
            PlanArea area = planAreaMap.get(applyPurchaseDetail.getAreaId());
            copy.setArea(NameInfo.builder().id(area.getId()).name(area.getName()).build());
         }

         if (copy.getAccountingUnit() != null) {
            String symbol = this.unitService
               .getOne(new LambdaQueryWrapper<Unit>().eq(copy.getAccountingUnit() != null, Unit::getName, copy.getAccountingUnit()))
               .getSymbol();
            copy.setSymbol(symbol);
         }

         applyPurchaseDetailDTOS.add(copy);
      }

      return applyPurchaseDetailDTOS;
   }

   @Override
   public ApplyPurchase updatePurchaseStatus(Long applyPurchaseId, Long applyPurchaseDetailId, PurchaseOrderDetail productDetail) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(applyPurchaseId);
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      int state = ApplyPurchaseStateEnum.CREATED.getType();

      for (ApplyPurchaseDetail detail : applyPurchaseDetails) {
         if (applyPurchaseDetailId != null && applyPurchaseDetailId.equals(detail.getId())) {
            if (productDetail.getMete() != null) {
               detail.setProductMete(detail.getProductMete().add(productDetail.getMete()));
            }

            if (productDetail.getQuantity() != null) {
               detail.setProductQuantity(detail.getProductQuantity().add(productDetail.getQuantity()));
            }

            if (detail.getMete().compareTo(detail.getProductMete()) <= 0) {
               detail.setBoolPurchase(true);
            }

            this.applyPurchaseDetailMapper.updateById(detail);
         }
      }

      BigDecimal mete = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal productMete = applyPurchaseDetails.stream().map(ApplyPurchaseDetail::getProductMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      if (mete.compareTo(productMete) > 0) {
         state = ApplyPurchaseStateEnum.PARTIAL_CREATED.getType();
      }

      applyPurchase.setPurchaseCreationState(state);
      this.baseMapper.updateById(applyPurchase);
      return applyPurchase;
   }

   @Override
   public void updateInboundMete(Long applyPurchaseId, BigDecimal inboundMete) {
      this.baseMapper.updateInboundMete(applyPurchaseId, inboundMete);
   }

   @Override
   public ApplyPurchaseDTO schedule(Long id) {
      ApplyPurchaseDTO purchase = this.baseMapper.getById(id);
      purchase.setDetailList(
         this.applyPurchaseDetailMapper
            .selectList(
               (Wrapper<ApplyPurchaseDetail>)(((Wrappers.<ApplyPurchaseDetail>lambdaQuery()
                           .eq(ApplyPurchaseDetail::getApplyPurchaseId, purchase.getId()))
                        .isNull(ApplyPurchaseDetail::getMaterialInventoryId))
                     .orderByAsc(ApplyPurchaseDetail::getBasicClass))
                  .orderByAsc(ApplyPurchaseDetail::getThickness)
            )
            .stream()
            .map(l -> com.hzchum.pangu.common.util.BeanUtil.copy(l, ApplyPurchaseDetailDTO.class))
            .collect(Collectors.toList())
      );
      purchase.setInboundList(
         this.inboundDetailService
            .getListByApplyPurchaseId(purchase.getId())
            .stream()
            .map(l -> com.hzchum.pangu.common.util.BeanUtil.copy(l, ApplyPurchaseDetailDTO.class))
            .collect(Collectors.toList())
      );
      return purchase;
   }

   @Override
   public void excel(Long id, HttpServletResponse response) {
      ApplyPurchaseDTO dto = this.schedule(id);
      Preconditions.checkArgument(dto != null, "下载失败，对应订单不存在");
      HashMap<String, Object> map = new HashMap<>(16);
      String resourcePath = "files/template/supplier/applyPurchaseSchedule.xlsx";
      String tempFileName = "applyPurchaseSchedule";
      String exportFileName = "采购跟踪.xlsx";
      List<ApplyPurchaseDetailDTO> aList = dto.getDetailList();
      List<ApplyPurchaseDetailDTO> bList = dto.getInboundList();
      map.put("serialNumber", dto.getSerialNumber());
      map.put("project", dto.getProject() != null ? dto.getProject().getSerialNumber() + dto.getProject().getShortName() : "-");
      BigDecimal aMete = BigDecimal.ZERO;
      BigDecimal bMete = BigDecimal.ZERO;
      List<Map<String, Object>> mapList = new ArrayList<>();
      int size = Math.max(aList.size(), bList.size());

      for (int i = 0; i < size; i++) {
         Map<String, Object> mapObject = new HashMap<>();
         mapObject.put("id", i + 1);
         ApplyPurchaseDetailDTO aDTO = null;
         if (aList.size() > i) {
            aDTO = aList.get(i);
         }

         ApplyPurchaseDetailDTO inboundDTO = null;
         if (bList.size() > i) {
            inboundDTO = bList.get(i);
         }

         if (aDTO != null) {
            Measure measure = this.getMeasure(aDTO.getClassifyId());
            StringBuilder sb = new StringBuilder();
            this.setSpec(aDTO, sb);
            mapObject.put("aName", this.classificationService.getById(aDTO.getClassifyId()).getName());
            mapObject.put("aSpec", sb);
            mapObject.put("aMunit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "-");
            mapObject.put(
               "aQuantity",
               aDTO.getQuantity() != null
                  ? this.unitConversion(aDTO.getQuantity(), measure.getMeasureUnit(), measure.getMeasurePrecision()).get(1).toPlainString()
                  : "-"
            );
            mapObject.put("aAunit", measure.getAccountingUnit());
            BigDecimal mete = this.unitConversion(aDTO.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision()).get(1);
            mapObject.put("aMete", mete.toPlainString());
            aMete = aMete.add(mete);
         } else {
            mapObject.put("aName", "");
            mapObject.put("aSpec", "");
            mapObject.put("aMunit", "");
            mapObject.put("aQuantity", "");
            mapObject.put("aAunit", "");
            mapObject.put("aMete", "");
         }

         if (inboundDTO != null) {
            Measure measure = this.getMeasure(inboundDTO.getClassifyId());
            StringBuilder si = new StringBuilder();
            this.setSpec(inboundDTO, si);
            mapObject.put("bName", this.classificationService.getById(inboundDTO.getClassifyId()).getName());
            mapObject.put("bSpec", si);
            mapObject.put("bMunit", StrUtil.isNotBlank(measure.getMeasureUnit()) ? measure.getMeasureUnit() : "-");
            mapObject.put(
               "bQuantity",
               inboundDTO.getQuantity() != null
                  ? this.unitConversion(inboundDTO.getQuantity(), measure.getMeasureUnit(), measure.getMeasurePrecision()).get(1).toPlainString()
                  : "-"
            );
            mapObject.put("bAunit", measure.getAccountingUnit());
            BigDecimal mete = this.unitConversion(inboundDTO.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision()).get(1);
            mapObject.put("bMete", mete.toPlainString());
            bMete = bMete.add(mete);
         } else {
            mapObject.put("bName", "");
            mapObject.put("bSpec", "");
            mapObject.put("bMunit", "");
            mapObject.put("bQuantity", "");
            mapObject.put("bAunit", "");
            mapObject.put("bMete", "");
         }

         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      map.put("aSum", aMete.toPlainString());
      map.put("bSum", bMete.toPlainString());
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath());
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   @Override
   public List<ApplyPurchaseDTO> listByLevelV2(Integer level) {
      List<ApplyPurchase> applyPurchases = this.baseMapper.selectList(Wrappers.<ApplyPurchase>lambdaQuery().eq(level != null, ApplyPurchase::getLevel, level));
      List<ApplyPurchaseDTO> applyPurchaseDTOS = new ArrayList<>();

      for (ApplyPurchase applyPurchase : applyPurchases) {
         if (ReviewStatusEnum.REVIEWED.getType().equals(applyPurchase.getReviewStatus())) {
            ApplyPurchaseDTO copy = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchase, ApplyPurchaseDTO.class);
            List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
               .selectList(
                  Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(applyPurchase.getApproveProcessId() != null, ApplyPurchaseDetail::getId, applyPurchase.getApproveProcessId())
               );
            List<ApplyPurchaseDetailDTO> applyPurchaseDetailDTOS = new ArrayList<>();

            for (ApplyPurchaseDetail applyPurchaseDetail : applyPurchaseDetails) {
               ApplyPurchaseDetailDTO copy1 = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchaseDetail, ApplyPurchaseDetailDTO.class);
               applyPurchaseDetailDTOS.add(copy1);
            }

            applyPurchaseDTOS.add(copy);
         }
      }

      return applyPurchaseDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalApplyPurchase(WmsApproveOpinionDTOParam wmsApproveOpinionDTOParam) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(wmsApproveOpinionDTOParam.getDataId());
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(wmsApproveOpinionDTOParam.getApproveRecordId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "未存在审批日志信息");
      String jsonData = null;
      Boolean b = this.wmsApproveRecordService
         .commonApproveStep(
            wmsApproveOpinionDTOParam.getDataId(),
            wmsApproveOpinionDTOParam.getDecision(),
            wmsApproveOpinionDTOParam.getOpinion(),
            wmsApproveRecord.getSerialNumber(),
            jsonData
         );
      if (!b) {
         return true;
      }

      label51: {
         if (wmsApproveOpinionDTOParam.getDecision().equals(ReviewStatusEnum.REVIEWED.getType())) {
            if (ApproveProcessTypeEnumV2.APPLY_PURCHASE_ADD.getType().equals(wmsApproveRecord.getApproveProcessType())) {
               applyPurchase.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               applyPurchase.setDataStatus(DataStatusEnum.SUCCEED.getType());
               applyPurchase.setPurchaseCreationState(ApplyPurchaseStateEnum.NOT_STARTED.getType());
               break label51;
            }

            if (ApproveProcessTypeEnumV2.APPLY_PURCHASE_CANCELLATION.getType().equals(wmsApproveRecord.getApproveProcessType())) {
               applyPurchase.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               applyPurchase.setDataStatus(DataStatusEnum.CANCELLATION.getType());
               applyPurchase.setPurchaseCreationState(null);
               this.wmsApproveRecordService
                  .update(
                     null,
                     (Wrapper<WmsApproveRecord>)(new LambdaUpdateWrapper<WmsApproveRecord>().set(WmsApproveRecord::getBoolRewrite, Boolean.TRUE))
                        .eq(WmsApproveRecord::getId, wmsApproveRecord.getId())
                  );
               if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
                  this.applyUpdateManufactured(applyPurchase, false);
               }
               break label51;
            }

            if (ApproveProcessTypeEnumV2.APPLY_PURCHASE_UPDATE_ADD.getType().equals(wmsApproveRecord.getApproveProcessType())) {
               applyPurchase.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               applyPurchase.setDataStatus(DataStatusEnum.SUCCEED.getType());
               if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
                  ApplyPurchase oldApplyPurchase = this.baseMapper.getByIdAll(applyPurchase.getPassParentId());
                  this.applyBoolAgainSubmitManufactured(oldApplyPurchase, applyPurchase, true);
               }
               break label51;
            }
         }

         if (wmsApproveOpinionDTOParam.getDecision().equals(ReviewStatusEnum.RETURNED.getType())) {
            if (ApproveProcessTypeEnumV2.APPLY_PURCHASE_ADD.getType().equals(wmsApproveRecord.getApproveProcessType())) {
               applyPurchase.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
               applyPurchase.setDataStatus(DataStatusEnum.USELESS.getType());
               if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
                  this.applyUpdateManufactured(applyPurchase, false);
               }
            } else if (ApproveProcessTypeEnumV2.APPLY_PURCHASE_CANCELLATION.getType().equals(wmsApproveRecord.getApproveProcessType())) {
               applyPurchase.setReviewStatus(ApproveStatusEnum.PASS.getType());
               applyPurchase.setDataStatus(DataStatusEnum.SUCCEED.getType());
            } else if (ApproveProcessTypeEnumV2.APPLY_PURCHASE_UPDATE_ADD.getType().equals(wmsApproveRecord.getApproveProcessType())) {
               applyPurchase.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
               applyPurchase.setDataStatus(DataStatusEnum.USELESS.getType());
               applyPurchase.setBoolDeleteEnum(true);
               if (ObjectUtil.isNotEmpty(applyPurchase.getPassParentId())) {
                  this.baseMapper.updateBoolDeleteById(applyPurchase.getPassParentId());
                  if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
                     ApplyPurchase oldApplyPurchase = this.baseMapper.getByIdAll(applyPurchase.getPassParentId());
                     this.applyBoolAgainSubmitManufactured(oldApplyPurchase, applyPurchase, false);
                  }
               } else if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
                  this.applyUpdateManufactured(applyPurchase, false);
               }
            }
         }
      }

      int i = this.baseMapper.updateById(applyPurchase);
      Preconditions.checkArgument(i == 1, "审批失败");
      return null;
   }

   @Override
   public List<ApplyPurchaseDTO> getTSApplyPurchase() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long id = currentUser.getId();
      List<ApplyPurchase> applyPurchases = this.baseMapper
         .selectList(
            (Wrapper<ApplyPurchase>)(new LambdaQueryWrapper<ApplyPurchase>().eq(ApplyPurchase::getBoolTemporaryStorage, true))
               .eq(ApplyPurchase::getApplicantId, id)
         );
      List<ApplyPurchaseDTO> applyPurchaseDTOS = BeanUtil.copyToList(applyPurchases, ApplyPurchaseDTO.class);
      if (CollectionUtils.isNotEmpty(applyPurchaseDTOS)) {
         List<Long> ids = applyPurchaseDTOS.stream().map(ApplyPurchaseDTO::getId).collect(Collectors.toList());
         List<String> projectIdsList = applyPurchaseDTOS.stream()
            .filter(a -> ObjectUtil.isNotEmpty(a.getProjectIds()))
            .collect(Collectors.toList())
            .stream()
            .map(ApplyPurchaseDTO::getProjectIds)
            .collect(Collectors.toList());
         List<ProjectInfo> projectInfos = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(projectIdsList)) {
            List<Long> projectIdList = new ArrayList<>();

            for (String string : projectIdsList) {
               List<Long> collect = Arrays.asList(string.split(",")).stream().map(Long::valueOf).collect(Collectors.toList());
               projectIdList.addAll(collect);
            }

            List<ContractProject> contractProjects = this.contractProjectService.listByIds(projectIdList);
            projectInfos = BeanUtil.copyToList(contractProjects, ProjectInfo.class);
         }

         for (ApplyPurchaseDTO applyPurchaseDTO : applyPurchaseDTOS) {
            if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getProjectIds())) {
               String projectIds = applyPurchaseDTO.getProjectIds();
               List<Long> list = Arrays.stream(projectIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
               List<ProjectInfo> projectInfoList = projectInfos.stream().filter(p -> list.contains(p.getId())).collect(Collectors.toList());
               applyPurchaseDTO.setProjectInfos(projectInfoList);
            }

            if (applyPurchaseDTO.getBranchCompanyId() != null) {
               BranchCompany branchCompany = this.branchCompanyService.getById(applyPurchaseDTO.getBranchCompanyId());
               IdAndNameDTO andNameDTO = IdAndNameDTO.builder().id(branchCompany.getId()).name(branchCompany.getName()).build();
               applyPurchaseDTO.setBranchCompany(andNameDTO);
            }
         }
      }

      return applyPurchaseDTOS;
   }

   @Override
   public Integer getTSCount() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long id = currentUser.getId();
      return this.baseMapper
         .selectCount(
            (Wrapper<ApplyPurchase>)(new LambdaQueryWrapper<ApplyPurchase>().eq(ApplyPurchase::getBoolTemporaryStorage, true))
               .eq(ApplyPurchase::getApplicantId, id)
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveTS(ApplyPurchaseDTOParam param) {
      Preconditions.checkArgument(!ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(param.getType()), "制成品申购不可以暂存！！！");
      param.setClassifyIds(null);
      ApplyPurchase applyPurchase = null;
      if (ObjectUtil.isNotEmpty(param.getId())) {
         applyPurchase = this.baseMapper.selectById(param.getId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "申购单不存在");
         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         idsStatusDTO.setDataType(1);
         idsStatusDTO.setDataId(applyPurchase.getId());
         idsStatusDTO.setIdsStr(applyPurchase.getClassifyIds());
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
      }

      if (CollectionUtil.isNotEmpty(param.getList())) {
         if (CollectionUtil.isNotEmpty(param.getList())) {
            List<ClassificationCheckDTO> classificationCheckDTOS = param.getList()
               .stream()
               .map(d -> BeanUtil.toBean(d, ClassificationCheckDTO.class))
               .collect(Collectors.toList());
            this.classificationService.checkClassification(classificationCheckDTOS, null);
         }

         List<String> collect = param.getList().stream().map(c -> String.valueOf(c.getClassifyId())).distinct().collect(Collectors.toList());
         String classifyIds = StringUtils.list2String(collect, ",");
         this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(classifyIds).build());
         param.setClassifyIds(classifyIds);
      }

      param.setDataStatus(null);
      param.setBoolTemporaryStorage(Boolean.TRUE);
      if (ObjectUtil.isEmpty(param.getId())) {
         this.saveV2(param, false);
      } else {
         if (ObjectUtil.isNotEmpty(applyPurchase.getDataStatus())) {
            Integer dataStatus = applyPurchase.getDataStatus();
            Preconditions.checkArgument(
               !dataStatus.equals(DataStatusEnum.UNDER_REVIEW.getType())
                  && !dataStatus.equals(DataStatusEnum.SUCCEED.getType())
                  && !dataStatus.equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType()),
               "该订单正在审核或已审核通过，操作失败"
            );
         }

         if (ObjectUtil.isNotEmpty(applyPurchase.getDataStatus())) {
            if (applyPurchase.getDataStatus().equals(DataStatusEnum.USELESS.getType())
               || applyPurchase.getDataStatus().equals(DataStatusEnum.CANCELLATION.getType())) {
               param.setParentId(applyPurchase.getId());
               this.saveV2(param, false);
            }
         } else {
            this.creatApplyPurchaseSD(param);
            SecurityUser currentUser = UserUtil.getCurrentUser();
            this.checkApplyPurchase(param);
            applyPurchase = ApplyPurchase.builder()
               .id(param.getId())
               .serialNumber(param.getSerialNumber())
               .serialNumberParent(param.getSerialNumberParent())
               .boolSysgen(param.getBoolSysgen())
               .reviewStatus(param.getReviewStatus())
               .materialType(param.getMaterialType())
               .userUpdateTime(LocalDateTime.now())
               .editorId(currentUser.getId())
               .editorName(currentUser.getName())
               .remark(param.getRemark())
               .boolInitiateApprove(Boolean.FALSE)
               .tsData(param.getTsData())
               .boolTemporaryStorage(param.getBoolTemporaryStorage())
               .projectIds(param.getProjectIds())
               .projectAttribute(param.getProjectAttribute())
               .branchCompanyId(param.getBranchCompanyId())
               .classifyIds(param.getClassifyIds())
               .type(param.getType())
               .finishedProductType(param.getFinishedProductType())
               .build();
            applyPurchase.setAttachmentsStr(CollectionUtil.isNotEmpty(param.getAttachmentIds()) ? StrUtil.join(",", param.getAttachmentIds()) : null);
            if (param.getBranchCompanyId() != null) {
               BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
               if (branchCompany != null) {
                  Optional.ofNullable(branchCompany.getLevel()).ifPresent(applyPurchase::setLevel);
                  Optional.ofNullable(branchCompany.getBranchAttributeEnum()).ifPresent(applyPurchase::setBranchAttributeEnum);
               }

               if (ObjectUtil.isNotEmpty(param.getProjectIds())) {
                  this.projectService.checkContractSignBodyId(null, null, param.getProjectIds(), param.getBranchCompanyId());
               }
            }

            this.baseMapper.updateById(applyPurchase);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveCheck(ApplyPurchaseDTOParam param) {
      param.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      param.setDataStatus(DataStatusEnum.UNDER_REVIEW.getType());
      param.setBoolTemporaryStorage(Boolean.FALSE);
      if (ObjectUtil.isEmpty(param.getId())) {
         this.saveV2(param, false);
      } else {
         ApplyPurchase applyPurchase = this.baseMapper.selectById(param.getId());
         if (ObjectUtil.isNotEmpty(param.getId())) {
            IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
            idsStatusDTO.setIdsStr(applyPurchase.getClassifyIds());
            this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         }

         String dataSerialNumber = applyPurchase.getSerialNumber();
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "申购单不存在");
         if (ObjectUtil.isNotEmpty(applyPurchase.getDataStatus())) {
            Integer dataStatus = applyPurchase.getDataStatus();
            Preconditions.checkArgument(
               !dataStatus.equals(DataStatusEnum.UNDER_REVIEW.getType())
                  && !dataStatus.equals(DataStatusEnum.SUCCEED.getType())
                  && !dataStatus.equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType()),
               "该订单正在审核或已审核通过，操作失败"
            );
         }

         if (ObjectUtil.isNotEmpty(applyPurchase.getDataStatus())) {
            if (applyPurchase.getDataStatus().equals(DataStatusEnum.USELESS.getType())
               || applyPurchase.getDataStatus().equals(DataStatusEnum.CANCELLATION.getType())) {
               this.saveV2(param, false);
            }
         } else {
            this.creatApplyPurchaseSD(param);
            SecurityUser currentUser = UserUtil.getCurrentUser();
            this.checkApplyPurchase(param);
            BranchCompany byId = this.branchCompanyService.getById(param.getBranchCompanyId());
            applyPurchase = ApplyPurchase.builder()
               .id(param.getId())
               .serialNumber(param.getSerialNumber())
               .serialNumberParent(param.getSerialNumberParent())
               .boolSysgen(param.getBoolSysgen())
               .reviewStatus(ReviewStatusEnum.AUDITING.getType())
               .materialType(param.getMaterialType())
               .userUpdateTime(LocalDateTime.now())
               .editorId(currentUser.getId())
               .editorName(currentUser.getName())
               .remark(param.getRemark())
               .boolInitiateApprove(Boolean.TRUE)
               .tsData(param.getTsData())
               .level(byId.getLevel())
               .branchAttributeEnum(byId.getBranchAttributeEnum())
               .boolIsProjectDetail(param.getBoolIsProjectDetail())
               .projectIds(param.getProjectIds())
               .boolTemporaryStorage(param.getBoolTemporaryStorage())
               .dataStatus(DataStatusEnum.UNDER_REVIEW.getType())
               .projectAttribute(param.getProjectAttribute())
               .branchCompanyId(param.getBranchCompanyId())
               .type(param.getType())
               .finishedProductType(param.getFinishedProductType())
               .build();
            applyPurchase.setAttachmentsStr(CollectionUtil.isNotEmpty(param.getAttachmentIds()) ? StrUtil.join(",", param.getAttachmentIds()) : null);
            if (ObjectUtil.isNotEmpty(param.getProjectIds())) {
               this.projectService.checkContractSignBodyId(null, null, param.getProjectIds(), param.getBranchCompanyId());
            }

            WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
               .createRecord(
                  applyPurchase.getId(),
                  dataSerialNumber,
                  ApproveProcessTypeEnumV2.APPLY_PURCHASE_ADD.getType(),
                  param.getCause(),
                  null,
                  null,
                  false,
                  null,
                  null,
                  null
               );
            applyPurchase.setApproveRecordIds(String.valueOf(wmsApproveRecord.getId()));
            applyPurchase.setApproveRecordIdNow(wmsApproveRecord.getId());
            List<ApplyPurchaseEnclosure> list = null;
            List<String> basicClassNames = null;
            this.setDetailV2(param, applyPurchase, list, basicClassNames);
            this.classificationService.updateClassifyUsed(IdsStatusDTO.builder().idsStr(applyPurchase.getClassifyIds()).build());
            if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
               param.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               applyPurchase.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
               applyPurchase.setDataStatus(DataStatusEnum.SUCCEED.getType());
               applyPurchase.setPurchaseCreationState(ApplyPurchaseStateEnum.NOT_STARTED.getType());
            }

            this.baseMapper.updateById(applyPurchase);
         }
      }

      return true;
   }

   @Override
   public List<ApplyPurchaseDTO> getCanCheck() {
      List<ApplyPurchaseDTO> applyPurchaseDTOS = new ArrayList<>();
      List<WmsApproveRecordDetail> checkDataIdList = this.wmsApproveRecordService.getCheckDataIdList(FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getType());
      if (CollectionUtils.isEmpty(checkDataIdList)) {
         return applyPurchaseDTOS;
      }

      List<Long> dataIds = checkDataIdList.stream().map(WmsApproveRecordDetail::getDataId).collect(Collectors.toList());
      List<ApplyPurchase> applyPurchases = this.baseMapper.selectBatchIds(dataIds);
      applyPurchaseDTOS = BeanUtil.copyToList(applyPurchases, ApplyPurchaseDTO.class);
      List<String> projectIdsList = applyPurchaseDTOS.stream()
         .filter(a -> ObjectUtil.isNotEmpty(a.getProjectIds()))
         .collect(Collectors.toList())
         .stream()
         .map(ApplyPurchaseDTO::getProjectIds)
         .collect(Collectors.toList());
      List<ProjectInfo> projectInfos = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(projectIdsList)) {
         List<Long> projectIdList = new ArrayList<>();

         for (String string : projectIdsList) {
            List<Long> collect = Arrays.stream(string.split(",")).map(Long::valueOf).collect(Collectors.toList());
            projectIdList.addAll(collect);
         }

         List<ContractProject> contractProjects = this.contractProjectService.listByIds(projectIdList);
         projectInfos = BeanUtil.copyToList(contractProjects, ProjectInfo.class);
      }

      for (ApplyPurchaseDTO applyPurchaseDTO : applyPurchaseDTOS) {
         if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getApproveRecordIds())) {
            String approveRecordIds = applyPurchaseDTO.getApproveRecordIds();
            List<Long> approveRecordIdList = Arrays.stream(approveRecordIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
            List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS = new ArrayList<>();

            for (Long approveRecordId : approveRecordIdList) {
               WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(approveRecordId);
               wmsApproveRecordFlowDTOS.add(approveRecordFlowDTO);
            }

            applyPurchaseDTO.setWmsApproveRecordFlowDTOS(wmsApproveRecordFlowDTOS);
         }

         if (ObjectUtil.isNotEmpty(applyPurchaseDTO.getProjectIds())) {
            String projectIds = applyPurchaseDTO.getProjectIds();
            List<Long> list = Arrays.stream(projectIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
            List<ProjectInfo> projectInfoList = projectInfos.stream().filter(p -> list.contains(p.getId())).collect(Collectors.toList());
            applyPurchaseDTO.setProjectInfos(projectInfoList);
         }
      }

      return applyPurchaseDTOS;
   }

   @Override
   public ListVO<BriefIdAndSNDTO> briefListV2(
      List<LocalDateTime> times,
      Integer materialType,
      Boolean filterUseInventory,
      Integer purchaseCreationState,
      Integer level,
      Integer projectAttribute,
      Long branchCompanyId,
      Long projectId
   ) {
      return new ListVO<>(
         this.baseMapper
            .selectApplyPurchaseList(times, materialType, purchaseCreationState, level, projectAttribute, branchCompanyId, projectId)
            .stream()
            .filter(
               l -> filterUseInventory
                  ? this.applyPurchaseDetailMapper
                        .selectCount(
                           (Wrapper<ApplyPurchaseDetail>)(Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, l.getId()))
                              .isNull(ApplyPurchaseDetail::getMaterialInventoryId)
                        )
                     > 0
                  : true
            )
            .map(
               l -> BriefIdAndSNDTO.builder()
                  .id(l.getId())
                  .serialNumber(l.getSerialNumber())
                  .purchaseCreationState(l.getPurchaseCreationState())
                  .projects(ObjectUtil.isNotEmpty(l.getProjectIds()) ? this.contractProjectService.listByIds(l.getProjectIds()) : null)
                  .build()
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<BriefIdAndSNDTO> manufacturedBriefList(Long projectId, Integer materialType, Long branchCompanyId) {
      return this.baseMapper.selectApplyPurchaseManufacturedList(projectId, materialType, branchCompanyId);
   }

   @Override
   public Integer getCanCheckCount() {
      List<WmsApproveRecordDetail> checkDataIdList = this.wmsApproveRecordService.getCheckDataIdList(FunctionTypeEnum.SUPPLY_CHAIN_APPLY_PURCHASE.getType());
      return checkDataIdList.size();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "未查询到该申购单");
      WmsApproveRecord byId = this.wmsApproveRecordService.getById(applyPurchase.getApproveRecordIdNow());
      Preconditions.checkArgument(currentUser.getId().equals(byId.getApplicantId()), "仅创建此审批流程的人才可进行撤销操作");
      Preconditions.checkArgument(
         DataStatusEnum.UNDER_REVIEW.getType().equals(applyPurchase.getDataStatus())
            || DataStatusEnum.CANCELLATION_UNDER_WAY.getType().equals(applyPurchase.getDataStatus()),
         "只可在创建中或作废中才可撤销申请，撤销失败"
      );
      if (ObjectUtil.isNotEmpty(applyPurchase.getApproveRecordIdNow())) {
         this.wmsApproveRecordService.revocation(applyPurchase.getApproveRecordIdNow());
      }

      if (applyPurchase.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType())) {
         applyPurchase.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         applyPurchase.setDataStatus(DataStatusEnum.USELESS.getType());
         if (ObjectUtil.isNotEmpty(applyPurchase.getPassParentId())) {
            this.baseMapper.updateBoolDeleteById(applyPurchase.getPassParentId());
            applyPurchase.setBoolDeleteEnum(true);
            if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
               ApplyPurchase oldApplyPurchase = this.baseMapper.getByIdAll(applyPurchase.getPassParentId());
               this.applyBoolAgainSubmitManufactured(oldApplyPurchase, applyPurchase, false);
            }
         } else if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
            this.applyUpdateManufactured(applyPurchase, false);
         }
      }

      if (applyPurchase.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType())) {
         applyPurchase.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         applyPurchase.setDataStatus(DataStatusEnum.SUCCEED.getType());
      }

      int i = this.baseMapper.updateById(applyPurchase);
      Preconditions.checkArgument(i == 1, "撤销失败");
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean cancellation(Long id) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "申购单不存在！！！");
      Preconditions.checkArgument(applyPurchase.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "仅创建成功的申购单可操作，删除失败！！！");
      this.checkCancellation(id, true);
      applyPurchase.setDataStatus(DataStatusEnum.CANCELLATION_UNDER_WAY.getType());
      applyPurchase.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            applyPurchase.getId(),
            applyPurchase.getSerialNumber(),
            ApproveProcessTypeEnumV2.APPLY_PURCHASE_CANCELLATION.getType(),
            "",
            null,
            null,
            false,
            null,
            null,
            null
         );
      applyPurchase.setApproveRecordIdNow(wmsApproveRecord.getId());
      if (ObjectUtil.isNotEmpty(applyPurchase.getApproveRecordIds())) {
         applyPurchase.setApproveRecordIds(applyPurchase.getApproveRecordIds() + "," + wmsApproveRecord.getId());
      } else {
         applyPurchase.setApproveRecordIds(wmsApproveRecord.getId().toString());
      }

      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         applyPurchase.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         applyPurchase.setDataStatus(DataStatusEnum.CANCELLATION.getType());
         applyPurchase.setPurchaseCreationState(null);
         this.wmsApproveRecordService
            .update(
               null,
               (Wrapper<WmsApproveRecord>)(new LambdaUpdateWrapper<WmsApproveRecord>().set(WmsApproveRecord::getBoolRewrite, Boolean.TRUE))
                  .eq(WmsApproveRecord::getId, wmsApproveRecord.getId())
            );
         if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(applyPurchase.getType())) {
            this.applyUpdateManufactured(applyPurchase, false);
         }
      }

      return this.baseMapper.updateById(applyPurchase) == 1;
   }

   private Boolean checkCancellation(Long id, Boolean boolError) {
      Boolean boolUsed = false;
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list((Wrapper<PurchaseOrder>)new LambdaQueryWrapper<PurchaseOrder>().last("and find_in_set(" + id + ",apply_purchase_ids)"));
      if (CollectionUtils.isNotEmpty(purchaseOrders)) {
         List<PurchaseOrder> collect = purchaseOrders.stream().filter(PurchaseOrder::getBoolTemporaryStorage).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(collect)) {
            List<String> collectName = collect.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
            if (boolError) {
               Preconditions.checkArgument(false, "该申购单已被暂存状态采购单绑定，采购单编号：" + collectName + "，请先删除采购单，在执行此操作！！！");
            }

            boolUsed = true;
         }

         List<PurchaseOrder> collect1 = purchaseOrders.stream()
            .filter(p -> ObjectUtil.isNotEmpty(p.getDataStatus()) && p.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()))
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(collect1)) {
            List<String> collectName = collect1.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
            if (boolError) {
               Preconditions.checkArgument(false, "该申购单已被通过的采购单绑定，采购单编号：" + collectName + "，请先删除采购单，在执行此操作！！！");
            }

            boolUsed = true;
         }

         List<PurchaseOrder> collect2 = purchaseOrders.stream()
            .filter(
               p -> ObjectUtil.isNotEmpty(p.getDataStatus())
                  && (
                     p.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType())
                        || p.getDataStatus().equals(DataStatusEnum.CANCELLATION_UNDER_WAY.getType())
                  )
            )
            .collect(Collectors.toList());
         if (CollectionUtil.isNotEmpty(collect2)) {
            List<String> collectName = collect2.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
            if (boolError) {
               Preconditions.checkArgument(false, "该申购单已被审核中的采购单绑定，采购单编号：" + collectName + "，请先完成审批！！！");
            }

            boolUsed = true;
         }
      }

      return boolUsed;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePurchaseCreationStateById(List<ApplyPurchaseStatusDTOParam> list) {
      BasicInbound purchaseSpecBasicConf = this.basicConfigService.getPurchaseSpecBasicConf();

      for (ApplyPurchaseStatusDTOParam dtoParam : list) {
         Preconditions.checkArgument(dtoParam.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.CREATED.getType()), "只可将申购单采购状态修改为已采购！！！");
         ApplyPurchase applyPurchase = this.baseMapper.selectById(dtoParam.getId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "申购单不存在！！！");
         Preconditions.checkArgument(ObjectUtil.notEqual(applyPurchase.getType(), ApplyPurchaseTypeEnum.MANUFACTURES.getType()), "制成品申购单不可修改状态！！！");
         Preconditions.checkArgument(
            applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.PARTIAL_CREATED.getType()), "仅申购单采购状态为部分创建的可修改为已采购！！！"
         );
         List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
            .list(
               (Wrapper<PurchaseOrder>)(new LambdaQueryWrapper<PurchaseOrder>()
                     .and(
                        p -> {
                           LambdaQueryWrapper var10000 = ((p.eq(
                                    PurchaseOrder::getDataStatus, DataStatusEnum.UNDER_REVIEW.getType()
                                 ))
                                 .or())
                              .eq(PurchaseOrder::getDataStatus, DataStatusEnum.CANCELLATION_UNDER_WAY.getType());
                        }
                     ))
                  .last("and find_in_set(" + dtoParam.getId() + ",apply_purchase_ids)")
            );
         if (CollectionUtils.isNotEmpty(purchaseOrders)) {
            List<String> collect1 = purchaseOrders.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
            Preconditions.checkArgument(false, "绑定该申购的采购单存在审核中状态，采购单号：" + collect1 + "，请先进审核在操作！！！");
         }

         for (ApplyPurchaseDetail applyPurchaseDetail : this.applyPurchaseDetailMapper
            .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()))) {
            Preconditions.checkArgument(
               applyPurchaseDetail.getProductMete().compareTo(BigDecimal.ZERO) != 0, applyPurchaseDetail.getClassifyName() + "还未进行采购！！！"
            );
            BigDecimal multiply = applyPurchaseDetail.getMete().multiply(purchaseSpecBasicConf.getApplyAndProcureDetailMeteRatio().divide(new BigDecimal(100)));
            Preconditions.checkArgument(multiply.compareTo(applyPurchaseDetail.getProductMete()) < 1, applyPurchaseDetail.getClassifyName() + "采购量未达申购量！！！");
         }

         this.baseMapper
            .update(
               null,
               (Wrapper<ApplyPurchase>)(new LambdaUpdateWrapper<ApplyPurchase>().eq(ApplyPurchase::getId, dtoParam.getId()))
                  .set(ApplyPurchase::getPurchaseCreationState, dtoParam.getPurchaseCreationState())
            );
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeTs() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long id = currentUser.getId();

      for (ApplyPurchase applyPurchase : this.baseMapper
         .selectList(
            (Wrapper<ApplyPurchase>)(new LambdaQueryWrapper<ApplyPurchase>().eq(ApplyPurchase::getBoolTemporaryStorage, true))
               .eq(ApplyPurchase::getApplicantId, id)
         )) {
         IdsStatusDTO idsStatusDTO = new IdsStatusDTO();
         idsStatusDTO.setIdsStr(applyPurchase.getClassifyIds());
         idsStatusDTO.setDataType(1);
         idsStatusDTO.setDataId(applyPurchase.getId());
         this.classificationService.deleteDataUpdateClass(idsStatusDTO);
         this.baseMapper.deleteById(applyPurchase.getId());
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean againSubmitApplyPurchase(ApplyPurchaseDTOParam param) {
      param.setBoolTemporaryStorage(false);
      ApplyPurchase applyPurchase = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "未查询到申购单信息");
      Preconditions.checkArgument(applyPurchase.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "未通过的申购单禁止再次发起申请");
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            (Wrapper<PurchaseOrder>)(new LambdaQueryWrapper<PurchaseOrder>().eq(PurchaseOrder::getDataStatus, DataStatusEnum.UNDER_REVIEW.getType()))
               .last("and find_in_set(" + applyPurchase.getId() + ",apply_purchase_ids)")
         );
      if (CollectionUtil.isNotEmpty(purchaseOrders)) {
         List<String> purchaseSN = purchaseOrders.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.toList());
         Preconditions.checkArgument(false, "该申购单已被审核中的采购单绑定，请先撤销采购单" + purchaseSN + "！！！");
      }

      Preconditions.checkArgument(applyPurchase.getPurchaseCreationState().equals(ApplyPurchaseStateEnum.NOT_STARTED.getType()), "仅采购状态为【未采购】的申购单才可进行再次发起申请");
      param.setPurchaseCreationState(applyPurchase.getPurchaseCreationState());
      this.baseMapper.deleteById(applyPurchase.getId());
      this.saveV2(param, true);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   public Boolean updateUnderReviewApplyPurchase(ApplyPurchaseDTOParam param) {
      ApplyPurchase applyPurchase = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(applyPurchase), "该采购单不存在");
      Preconditions.checkArgument(applyPurchase.getDataStatus().equals(DataStatusEnum.UNDER_REVIEW.getType()), "采购单状态已改变，请刷新页面！！！");
      this.revocation(param.getId());
      if (ObjectUtil.isNotEmpty(applyPurchase.getPassParentId())) {
         Preconditions.checkArgument(!param.getBoolTemporaryStorage(), "该采购单为通过的采购单再次发起审批，禁止暂存！！！");
         param.setId(applyPurchase.getPassParentId());
         this.againSubmitApplyPurchase(param);
      } else if (param.getBoolTemporaryStorage()) {
         this.saveTS(param);
      } else {
         this.saveCheck(param);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteType(ApplyPurchaseDTOParam param) {
      if (param.getDelButtonType().equals(DelButtonTypeEnum.CHE_XIAO.getType())) {
         this.revocation(param.getId());
      } else if (param.getDelButtonType().equals(DelButtonTypeEnum.SHAN_CHU.getType())) {
         this.cancellation(param.getId());
      } else if (param.getDelButtonType().equals(DelButtonTypeEnum.CHE_XIAO_SHAN_CHU.getType())) {
         this.revocation(param.getId());
      } else if (param.getDelButtonType().equals(DelButtonTypeEnum.CHE_XIAO_BIAN_JI.getType())) {
         this.revocation(param.getId());
      }

      return true;
   }

   @Override
   public List<PurchaseOrderDetailDTO> getPurchaseDetailById(Long id) {
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService.selectPassDetailByApplyDetailIds(Collections.singletonList(id));
      if (CollectionUtils.isEmpty(purchaseOrderDetails)) {
         return new ArrayList<>();
      }

      List<Long> purchaseIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getPurchaseId).distinct().collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(purchaseIds);
      List<Long> projectIds = purchaseOrderDetails.stream()
         .map(PurchaseOrderDetail::getProjectId)
         .filter(ObjectUtil::isNotEmpty)
         .distinct()
         .collect(Collectors.toList());
      List<ProjectInfo> projectInfoList = this.contractProjectService.listSimpleByIdList(projectIds);
      List<PurchaseOrderDetailDTO> purchaseOrderDetailDTOS = new ArrayList<>();

      for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetails) {
         PurchaseOrder purchaseOrder = purchaseOrders.stream().filter(p -> p.getId().equals(purchaseOrderDetail.getPurchaseId())).findAny().orElse(null);
         if (!ObjectUtil.isEmpty(purchaseOrder.getReviewStatus()) && purchaseOrder.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
            PurchaseOrderDetailDTO purchaseOrderDetailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(purchaseOrderDetail, PurchaseOrderDetailDTO.class);
            purchaseOrderDetailDTO.setSerialNumber(purchaseOrder.getSerialNumber());
            purchaseOrderDetailDTO.setProject(projectInfoList.stream().filter(p -> p.getId().equals(purchaseOrderDetail.getProjectId())).findAny().orElse(null));
            purchaseOrderDetailDTOS.add(purchaseOrderDetailDTO);
         }
      }

      return purchaseOrderDetailDTOS;
   }

   @Override
   public List<ApplyPurchaseInboundDetailDTO> getInboundDetailById(Long id) {
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService.selectPassDetailByApplyDetailIds(CollectionUtil.newArrayList(id));
      if (CollectionUtils.isEmpty(purchaseOrderDetails)) {
         return new ArrayList<>();
      }

      List<Long> purchaseOrderDetailIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getPurchaseId).distinct().collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(purchaseOrderDetailIds);
      List<ApplyPurchaseInboundDetailDTO> dtoList = new ArrayList<>();

      for (PurchaseOrder order : purchaseOrders) {
         List<Long> purchaseDetailIds = purchaseOrderDetails.stream()
            .filter(p -> p.getPurchaseId().equals(order.getId()))
            .map(PurchaseOrderDetail::getId)
            .collect(Collectors.toList());
         List<ApplyPurchaseInboundDetailDTO> puchaseInboundDetailDTOS1 = new ArrayList<>();
         if (PlaceEnum.FACTORY.getType().equals(order.getOrderPlace())) {
            if (PurchaseEnum.MATERIAL.getType().equals(order.getPurchaseType())) {
               List<PuchaseInboundDetailDTO> factoryInboundDetailList = this.inboundService.getFactoryInboundDetailList(order.getId(), purchaseDetailIds);
               puchaseInboundDetailDTOS1 = BeanUtil.copyToList(factoryInboundDetailList, ApplyPurchaseInboundDetailDTO.class);
            }

            if (PurchaseEnum.FINISHED_GOODS.getType().equals(order.getPurchaseType())) {
               List<PuchaseInboundDetailDTO> puchaseInboundDetailDTOS = this.inboundManufacturedService.orderDetailV2(order.getId(), purchaseDetailIds);
               puchaseInboundDetailDTOS1 = BeanUtil.copyToList(puchaseInboundDetailDTOS, ApplyPurchaseInboundDetailDTO.class);
            }
         }

         if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(order.getOrderPlace())) {
            List<PuchaseInboundDetailDTO> constructionInboundDetailList = this.inboundService
               .getConstructionInboundDetailList(order.getId(), purchaseDetailIds);
            puchaseInboundDetailDTOS1 = BeanUtil.copyToList(constructionInboundDetailList, ApplyPurchaseInboundDetailDTO.class);
         }

         puchaseInboundDetailDTOS1.forEach(p -> p.setPurchaseSerialNumber(order.getSerialNumber()));
         dtoList.addAll(puchaseInboundDetailDTOS1);
      }

      return dtoList;
   }

   private void deleteDetail(ApplyPurchase applyPurchase, List<ApplyPurchaseDetail> applyPurchaseDetails) {
      for (ApplyPurchaseDetail detail : applyPurchaseDetails) {
         if (detail.getArtifactEnclosureId() != null) {
            TechArtifact artifact = this.artifactService.getById(detail.getArtifactEnclosureId());
            artifact.setPurchaseQuantity(artifact.getPurchaseQuantity().subtract(detail.getQuantity()));
            this.artifactService.updateById(artifact);
         }

         if (detail.getMaterialInventoryId() != null) {
            this.materialFreezeService.materialUnfreeze(applyPurchase.getId(), detail.getId(), MaterialFreezeTypeEnum.REQUISITIONS.getType(), false);
         }
      }

      this.applyPurchaseDetailMapper
         .delete((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getOutboundUnitType() != null) {
         return m;
      }

      Classification classification = this.classificationService.getById(pid);
      return this.getMeasure(classification.getParentId());
   }

   public void uploadFileToDD(GetUploadInfoResponseBodyStsUploadInfo uploadInfo, String filePath) {
      String accessKeyId = uploadInfo.getAccessKeyId();
      String accessKeySecret = uploadInfo.getAccessKeySecret();
      String securityToken = uploadInfo.getAccessToken();
      String endpoint = uploadInfo.getEndPoint();
      String bucket = uploadInfo.getBucket();
      String ossKey = uploadInfo.getMediaId();
      CredentialsProvider credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret, securityToken);
      ClientConfiguration clientConfiguration = new ClientConfiguration();
      clientConfiguration.setProtocol(Protocol.HTTPS);
      OSSClient ossClient = new OSSClient(endpoint, credentialsProvider, clientConfiguration);
      PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, ossKey, new File(filePath));
      ossClient.putObject(putObjectRequest);
      ossClient.shutdown();
   }

   private DDAttachment uploadDD(String path, Long fileSize, String fileName) throws Exception {
      UserGetResponse ddUser = DingDingUtils.getUserByUserId(UserUtil.getCurrentUser().getDdUserId());
      assert ddUser != null;
      ListSpacesResponseBody ddSpaceList = DingDingUtils.getDDSpaceList(ddUser.getUnionid(), "org", null);
      ListSpacesResponseBodySpaces space = null;
      String cnName = "材料申购审批附件";
      if (Objects.nonNull(ddSpaceList)) {
         for (ListSpacesResponseBodySpaces s : ddSpaceList.getSpaces()) {
            if (s.getSpaceName().equals(cnName)) {
               space = s;
            }
         }
      }

      Preconditions.checkArgument(space != null, "获取钉盘空间列表失败，请让钉钉管理员分配钉钉云盘的相应权限");
      GetUploadInfoResponseBodyStsUploadInfo tempInfo = DingDingUtils.addFileInfo(
         ddUser.getUnionid(), fileName, fileSize, fileSize.toString(), "autoRename", null, space.getSpaceId(), "0"
      );
      Preconditions.checkArgument(tempInfo != null, "获取钉盘空间列表失败，请让钉钉管理员分配钉钉云盘的相应权限");
      this.log.warn("上传文件信息结束：" + JSON.toJSONString(tempInfo));
      GetUploadInfoResponseBodyStsUploadInfo uploadInfo = new GetUploadInfoResponseBodyStsUploadInfo();
      uploadInfo.setBucket(tempInfo.getBucket());
      uploadInfo.setEndPoint(tempInfo.getEndPoint());
      uploadInfo.setAccessKeyId(tempInfo.getAccessKeyId());
      uploadInfo.setAccessKeySecret(tempInfo.getAccessKeySecret());
      uploadInfo.setAccessToken(tempInfo.getAccessToken());
      uploadInfo.setMediaId(tempInfo.getMediaId());
      this.uploadFileToDD(uploadInfo, path);
      this.log.warn("上传到云盘完成");
      AddFileResponseBody fileOrFolder = DingDingUtils.addFileOrFolder(
         "0", "file", fileName, uploadInfo.getMediaId(), null, ddUser.getUnionid(), space.getSpaceId()
      );
      return DDAttachment.builder()
         .spaceId(space.getSpaceId())
         .fileSize(fileSize)
         .fileName(fileOrFolder.getFileName())
         .fileId(fileOrFolder.getFileId())
         .fileType(fileOrFolder.getFileType())
         .build();
   }

   private void setDetail(ApplyPurchaseDTOParam param, ApplyPurchase applyPurchase, List<ApplyPurchaseEnclosure> list, List<String> basicClassNames) {
      List<String> classifyIds = new ArrayList<>();
      List<String> checkDetail = new ArrayList<>();
      Map<Long, Classification> classificationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(param.getList())) {
         List<ClassificationCheckDTO> classificationCheckDTOS = param.getList()
            .stream()
            .map(d -> BeanUtil.toBean(d, ClassificationCheckDTO.class))
            .collect(Collectors.toList());
         classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, null);
      }

      for (int i = 0; i < param.getList().size(); i++) {
         ApplyPurchaseDetailDTOParam detailDTOParam = param.getList().get(i);
         Preconditions.checkArgument(detailDTOParam.getArrivalTime() != null, "请设置到厂日期");
         Preconditions.checkArgument(LocalDateTime.now().minus(1L, ChronoUnit.DAYS).compareTo(detailDTOParam.getArrivalTime()) < 0, "到厂日期不能小于当天");
         ApplyPurchaseDetail detail = com.hzchum.pangu.common.util.BeanUtil.copy(detailDTOParam, ApplyPurchaseDetail.class);
         detail.setApplyPurchaseId(applyPurchase.getId());
         if (ApplyPurchaseMaterialTypeEnum.checkIsManufacturedGoods(param.getMaterialType())) {
            TechArtifact artifact = this.artifactService.getById(detailDTOParam.getArtifactEnclosureId());
            BigDecimal quantity = artifact.getPurchaseQuantity().add(detail.getQuantity());
            Preconditions.checkArgument(quantity.compareTo(new BigDecimal(artifact.getQuantity())) <= 0, "新增失败,申购数量超出清单数量");
            artifact.setPurchaseQuantity(quantity);
            this.artifactService.updateById(artifact);
            detail.setBasicClass(BasicClassEnum.STRUC_MANUFACTURED.getType());
         } else {
            if (detailDTOParam.getMaterialInventoryId() == null) {
               String s = detailDTOParam.getClassifyId()
                  + detailDTOParam.getSpecification()
                  + (detailDTOParam.getLength() != null ? detailDTOParam.getLength() : "-")
                  + (detailDTOParam.getWidth() != null ? detailDTOParam.getWidth() : "-")
                  + (detailDTOParam.getThickness() != null ? detailDTOParam.getThickness() : "-")
                  + (detailDTOParam.getBrand() != null ? detailDTOParam.getBrand() : "-");
               Preconditions.checkArgument(!checkDetail.contains(s), "新增失败,请勿添加相同规格物料");
               checkDetail.add(s);
            }

            Classification classify = classificationMap.get(detailDTOParam.getClassifyId());
            classifyIds.add(classify.getId().toString());
            Measure measure = this.getMeasure(classify.getId());
            if (measure.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
               Preconditions.checkArgument(ObjectUtil.isEmpty(detail.getQuantity()), classify.getName() + "为核算方式，但提交了数量，请检查该科目计量配置！！！");
            }

            Preconditions.checkArgument(StrUtil.isNotBlank(measure.getAccountingUnit()), "新增失败,当前科目未配置核算单位");
            detail.setClassifyName(classify.getName());
            detail.setMeasureUnit(measure.getMeasureUnit());
            detail.setAccountingUnit(measure.getAccountingUnit());
            if (list != null) {
               String basicName = BasicClassEnum.getNameByType(detailDTOParam.getBasicClass());
               if (!basicClassNames.contains(basicName)) {
                  basicClassNames.add(basicName);
               }

               ApplyPurchaseEnclosure purchaseEnclosure = ApplyPurchaseEnclosure.builder()
                  .id(i + 1)
                  .className(classify.getName())
                  .measureUnit(measure.getMeasureUnit())
                  .accountingUnit(measure.getAccountingUnit())
                  .brand(detail.getBrand())
                  .build();
               if (BasicClassEnum.checkIsSteel(classify.getBasicClass())) {
                  purchaseEnclosure.setMete(CommonUtil.unitConversion(detail.getMete(), "吨", 2).stripTrailingZeros().toEngineeringString());
                  if (BasicClassEnum.COLOR_ROLL.getType().equals(classify.getBasicClass())) {
                     purchaseEnclosure.setQuantity(CommonUtil.unitConversion(detail.getQuantity(), "米", 2).stripTrailingZeros().toEngineeringString());
                  } else {
                     purchaseEnclosure.setQuantity(detail.getQuantity().toEngineeringString());
                  }
               } else if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(classify.getBasicClass())) {
                  if (StrUtil.isNotBlank(measure.getMeasureUnit())) {
                     Unit unit = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getMeasureUnit()));
                     purchaseEnclosure.setQuantity(
                        unit.getType().equals(UnitEnum.DIGIT.getType())
                           ? detail.getQuantity().toEngineeringString()
                           : CommonUtil.unitConversion(detail.getQuantity(), unit.getName(), 2).stripTrailingZeros().toEngineeringString()
                     );
                  } else {
                     purchaseEnclosure.setQuantity("-");
                  }

                  Unit unit = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getAccountingUnit()));
                  purchaseEnclosure.setMete(
                     unit.getType().equals(UnitEnum.DIGIT.getType())
                        ? detail.getMete().toEngineeringString()
                        : CommonUtil.unitConversion(detail.getMete(), unit.getName(), 2).stripTrailingZeros().toEngineeringString()
                  );
               }

               StringBuilder sb = new StringBuilder("");
               CommonUtil.getSpec(com.hzchum.pangu.common.util.BeanUtil.copy(detail, MaterialInventory.class), sb);
               purchaseEnclosure.setSpec(sb.toString());
               list.add(purchaseEnclosure);
            }
         }

         this.applyPurchaseDetailMapper.insert(detail);
         if (detailDTOParam.getMaterialInventoryId() != null) {
            MaterialInventory materialInventory = this.materialInventoryService.getById(detailDTOParam.getMaterialInventoryId());
            Preconditions.checkArgument(materialInventory != null, "新增失败,申购冻结物料不存在");
            Preconditions.checkArgument(!checkDetail.contains(materialInventory.getId() + ""), "新增失败,请勿重复冻结物料");
            checkDetail.add(materialInventory.getId() + "");
            MaterialFreeze materialFreeze = this.materialFreezeService
               .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, detailDTOParam.getMaterialInventoryId()));
            if (materialFreeze == null) {
               materialFreeze = com.hzchum.pangu.common.util.BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
               materialFreeze.setTotalQuantity(
                  BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? detailDTOParam.getLength() : detailDTOParam.getQuantity()
               );
               materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.REQUISITIONS.getType() + "");
               materialFreeze.setMaterialInventoryId(materialInventory.getId());
               materialFreeze.setTotalMete(detailDTOParam.getMete());
               this.materialFreezeService.save(materialFreeze);
            } else {
               if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
                  materialFreeze.setTotalQuantity(materialFreeze.getTotalQuantity().add(detailDTOParam.getLength()));
               } else {
                  materialFreeze.setTotalQuantity(
                     detailDTOParam.getQuantity() != null ? materialFreeze.getTotalQuantity().add(detailDTOParam.getQuantity()) : null
                  );
               }

               materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(detailDTOParam.getMete()));
               Preconditions.checkArgument(materialFreeze.getTotalMete().compareTo(materialInventory.getMete()) <= 0, "新增失败,申购冻结量超出物料可操作量");
               this.materialFreezeService.updateById(materialFreeze);
            }

            Preconditions.checkArgument(
               this.materialFreezeRecordService
                     .getOne(
                        (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                                 .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                              .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.REQUISITIONS.getType()))
                           .eq(MaterialFreezeRecord::getProjectId, param.getProjectId())
                     )
                  == null,
               "新增失败,物料已存在同项目申购冻结"
            );
            MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
               .materialFreezeId(materialFreeze.getId())
               .freezeType(MaterialFreezeTypeEnum.REQUISITIONS.getType())
               .freezeSourceId(applyPurchase.getId())
               .freezeDetailId(detail.getId())
               .freezeSourceSn(applyPurchase.getSerialNumber())
               .operatorId(UserUtil.getCurrentUserId())
               .operatorName(UserUtil.getCurrentName())
               .mete(detailDTOParam.getMete())
               .quantity(
                  BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? detailDTOParam.getLength() : detailDTOParam.getQuantity()
               )
               .projectId(applyPurchase.getProjectId())
               .frozenTime(LocalDateTime.now())
               .build();
            this.materialFreezeRecordService.save(materialFreezeRecord);
         }
      }

      if (CollectionUtils.isNotEmpty(classifyIds)) {
         classifyIds = classifyIds.stream().distinct().collect(Collectors.toList());
         applyPurchase.setClassifyIds(StringUtils.list2String(classifyIds, ","));
      }
   }

   public void setDetailV2(ApplyPurchaseDTOParam param, ApplyPurchase applyPurchase, List<ApplyPurchaseEnclosure> list, List<String> basicClassNames) {
      List<String> classifyIds = new ArrayList<>();
      Map<Long, Classification> classificationMap = new HashMap<>();
      if (!ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(param.getType()) && CollectionUtil.isNotEmpty(param.getList())) {
         List<ClassificationCheckDTO> classificationCheckDTOS = param.getList()
            .stream()
            .map(d -> BeanUtil.toBean(d, ClassificationCheckDTO.class))
            .collect(Collectors.toList());
         classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, null);
      }

      if (ApplyPurchaseTypeEnum.MANUFACTURES.getType().equals(param.getType())) {
         this.insertManufacturedDetail(param, applyPurchase);
      } else {
         Integer materialType = 0;

         for (int i = 0; i < param.getList().size(); i++) {
            ApplyPurchaseDetailDTOParam detailDTOParam = param.getList().get(i);
            ApplyPurchaseDetail detail = com.hzchum.pangu.common.util.BeanUtil.copy(detailDTOParam, ApplyPurchaseDetail.class);
            materialType = materialType | detail.getBasicClass();
            detail.setApplyPurchaseId(applyPurchase.getId());
            Classification classify = classificationMap.get(detailDTOParam.getClassifyId());
            classifyIds.add(detail.getClassifyId().toString());
            Measure measure = this.getMeasure(classify.getId());
            if (!BasicClassEnum.checkIsSteel(measure.getBasicClass()) && measure.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(detail.getQuantity()), classify.getName() + "为计量方式，但未提交数量，请检查该科目计量配置！！！");
            }

            Preconditions.checkArgument(StrUtil.isNotBlank(measure.getAccountingUnit()), "新增失败,当前科目未配置核算单位");
            detail.setClassifyName(classify.getName());
            detail.setMeasureUnit(measure.getMeasureUnit());
            if (StrUtil.isBlank(detail.getAccountingUnit())) {
               detail.setAccountingUnit(measure.getAccountingUnit());
            }

            if (list != null) {
               String basicName = BasicClassEnum.getNameByType(detailDTOParam.getBasicClass());
               if (!basicClassNames.contains(basicName)) {
                  basicClassNames.add(basicName);
               }

               ApplyPurchaseEnclosure purchaseEnclosure = ApplyPurchaseEnclosure.builder()
                  .id(i + 1)
                  .className(classify.getName())
                  .measureUnit(measure.getMeasureUnit())
                  .accountingUnit(measure.getAccountingUnit())
                  .brand(detail.getBrand())
                  .build();
               if (BasicClassEnum.checkIsSteel(classify.getBasicClass())) {
                  purchaseEnclosure.setMete(CommonUtil.unitConversion(detail.getMete(), "吨", 2).stripTrailingZeros().toEngineeringString());
                  if (BasicClassEnum.COLOR_ROLL.getType().equals(classify.getBasicClass())) {
                     purchaseEnclosure.setQuantity(CommonUtil.unitConversion(detail.getQuantity(), "米", 2).stripTrailingZeros().toEngineeringString());
                  } else {
                     purchaseEnclosure.setQuantity(detail.getQuantity().toEngineeringString());
                  }
               } else if (BasicClassEnum.GENERAL_MATERIAL.getType().equals(classify.getBasicClass())) {
                  if (StrUtil.isNotBlank(measure.getMeasureUnit())) {
                     Unit unit = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getMeasureUnit()));
                     purchaseEnclosure.setQuantity(
                        unit.getType().equals(UnitEnum.DIGIT.getType())
                           ? detail.getQuantity().toEngineeringString()
                           : CommonUtil.unitConversion(detail.getQuantity(), unit.getName(), 2).stripTrailingZeros().toEngineeringString()
                     );
                  } else {
                     purchaseEnclosure.setQuantity("-");
                  }

                  Unit unit = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getAccountingUnit()));
                  purchaseEnclosure.setMete(
                     unit.getType().equals(UnitEnum.DIGIT.getType())
                        ? detail.getMete().toEngineeringString()
                        : CommonUtil.unitConversion(detail.getMete(), unit.getName(), 2).stripTrailingZeros().toEngineeringString()
                  );
               }

               StringBuilder sb = new StringBuilder("");
               CommonUtil.getSpec(com.hzchum.pangu.common.util.BeanUtil.copy(detail, MaterialInventory.class), sb);
               purchaseEnclosure.setSpec(sb.toString());
               list.add(purchaseEnclosure);
            }

            detail.setDoNotSectionSteelSpec(
               ObjectUtil.isNotEmpty(detailDTOParam.getDoNotSectionSteelSpec()) ? detailDTOParam.getDoNotSectionSteelSpec() : detailDTOParam.getSpecification()
            );
            StringBuilder specification = new StringBuilder();
            if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDTOParam.getBasicClass())) {
               String sn = "";
               String specCode = "";
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailDTOParam.getSectionSteelSpec()), "该型材未配置国标规格");
               SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecService
                  .getOne(
                     (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery()
                           .eq(SectionSteelSpec::getClassificationId, detailDTOParam.getClassifyId()))
                        .eq(SectionSteelSpec::getSpecification, detailDTOParam.getSectionSteelSpec())
                  );
               Preconditions.checkArgument(sectionSteelSpec != null, "当前型材库规格为[" + detailDTOParam.getSectionSteelSpec() + "]的型材不存在.");
               Preconditions.checkArgument(sectionSteelSpec.getStatus(), "当前型材库规格为[" + detailDTOParam.getSectionSteelSpec() + "]的型材已禁用.");
               SectionSteelSpecStandardDetail standardDetail = this.sectionSteelSpecStandardDetailService
                  .getOne(
                     (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                              .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId()))
                           .eq(SectionSteelSpecStandardDetail::getStandardId, detailDTOParam.getStandardId()))
                        .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelSpec.getSectionSteelId())
                  );
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(standardDetail), "申购失败," + classify.getName() + "未查询到型材规格国标重量");
               Preconditions.checkArgument(
                  standardDetail.getUnitNet() != null && standardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "入库失败,当前型材规格未配置国标重量"
               );
               Standard standard = this.standardService.getById(standardDetail.getStandardId());
               sn = standard.getCode() + "-" + standardDetail.getCode();
               detail.setStandardId(standard.getId());
               detail.setSectionSteelSpecId(sectionSteelSpec.getId());
               detail.setSectionSteelSpec(sectionSteelSpec.getSpecification());
               detail.setDoNotSectionSteelSpec(detailDTOParam.getDoNotSectionSteelSpec());
               if (ObjectUtil.isNotEmpty(detailDTOParam.getDoNotSectionSteelSpec())) {
                  Map<String, String> map = this.specificationService
                     .checkClassifySpec(detailDTOParam.getClassifyId(), detailDTOParam.getDoNotSectionSteelSpec());
                  specCode = map.get("code");
                  specification.append(map.get("ids"));
               }

               detail.setMaterialSn(classify.getSerialNumber() + "-" + sn + specCode);
            } else {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailDTOParam.getClassifyId(), detailDTOParam.getSpecification());
               String specCode = map.get("code");
               specification.append(map.get("ids"));
               detail.setMaterialSn(classify.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            }

            detail.setSpecificationIds(specification.toString());
            this.applyPurchaseDetailMapper.insert(detail);
         }

         applyPurchase.setMaterialType(materialType);
      }

      if (CollectionUtils.isNotEmpty(classifyIds)) {
         classifyIds = classifyIds.stream().distinct().collect(Collectors.toList());
         applyPurchase.setClassifyIds(StringUtils.list2String(classifyIds, ","));
      }
   }

   public void insertManufacturedDetail(ApplyPurchaseDTOParam param, ApplyPurchase applyPurchase) {
      Preconditions.checkArgument(!param.getBoolTemporaryStorage(), "制成品申购不可进行暂存！！！");
      switch (param.getFinishedProductType()) {
         case 1:
            List<ApplyPurchaseDetailDTOParam> collect = param.getList()
               .stream()
               .filter(d -> !d.getBasicClass().equals(BasicClassEnum.STRUC_MANUFACTURED.getType()))
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(collect), "申购制成品类型为结构制品，明细中存在其他材料类型，申购失败！！！");
            break;
         case 2:
            List<ApplyPurchaseDetailDTOParam> collect1 = param.getList()
               .stream()
               .filter(d -> !d.getBasicClass().equals(BasicClassEnum.ENCL_MANUFACTURED.getType()))
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(collect1), "申购制成品类型为围护制品，明细中存在其他材料类型，申购失败！！！");
            break;
         default:
            Preconditions.checkArgument(false, "制成品类型不明确！！！");
      }

      List<String> projectIds = new ArrayList<>();
      List<TechProductSubscribeUpdateVORequest> techProductSubscribeUpdateVORequests = new ArrayList<>();
      Integer materialType = 0;

      for (ApplyPurchaseDetailDTOParam applyPurchaseDetailDTOParam : param.getList()) {
         ApplyPurchaseDetail detail = com.hzchum.pangu.common.util.BeanUtil.copy(applyPurchaseDetailDTOParam, ApplyPurchaseDetail.class);
         materialType = materialType | detail.getBasicClass();
         detail.setApplyPurchaseId(applyPurchase.getId());
         detail.setBasicClass(applyPurchaseDetailDTOParam.getBasicClass());
         if (applyPurchaseDetailDTOParam.getBasicClass().equals(BasicClassEnum.STRUC_MANUFACTURED.getType())) {
            TechArtifact byId = this.artifactService.getById(applyPurchaseDetailDTOParam.getArtifactEnclosureId());
            detail.setProjectId(byId.getProjectId());
            detail.setMonomerId(byId.getMonomerId());
            detail.setAreaId(byId.getAreaId());
            detail.setManufacturedName(byId.getName());
            detail.setManufacturedSn(byId.getSerialNumber());
            detail.setManufacturedUnit("件");
            detail.setSpecification(byId.getSpecification());
            detail.setLength(byId.getLength());
            detail.setSurfaceArea(byId.getSurfaceArea());
            detail.setMaterial(byId.getMaterial());
            detail.setManufacturedType(byId.getArtifactType());
            detail.setWeight(byId.getNetWeight().multiply(thousand));
            BigDecimal totalWeight = applyPurchaseDetailDTOParam.getQuantity().multiply(byId.getNetWeight()).multiply(thousand);
            detail.setTotalWeight(totalWeight);
            BigDecimal totalLength = applyPurchaseDetailDTOParam.getQuantity().multiply(byId.getLength());
            detail.setTotalLength(totalLength);
            if (ObjectUtil.isNotEmpty(byId.getSurfaceArea())) {
               BigDecimal totalArea = applyPurchaseDetailDTOParam.getQuantity().multiply(byId.getSurfaceArea());
               detail.setTotalArea(totalArea);
            }
         } else if (applyPurchaseDetailDTOParam.getBasicClass().equals(BasicClassEnum.ENCL_MANUFACTURED.getType())) {
            TechEnclosure byId = this.enclosureService.getById(applyPurchaseDetailDTOParam.getArtifactEnclosureId());
            detail.setProjectId(byId.getProjectId());
            detail.setManufacturedType(byId.getCategory());
            detail.setManufacturedName(byId.getName());
            detail.setManufacturedSn(byId.getSerialNumber());
            detail.setManufacturedUnit("张");
            detail.setWidth(byId.getWidth());
            detail.setThickness(byId.getThickness());
            detail.setLength(byId.getLength());
            BigDecimal totalLength = applyPurchaseDetailDTOParam.getQuantity().multiply(byId.getLength());
            detail.setTotalLength(totalLength);
            detail.setSurfaceArea(byId.getSurfaceArea());
            BigDecimal totalArea = applyPurchaseDetailDTOParam.getQuantity().multiply(byId.getSurfaceArea());
            detail.setTotalArea(totalArea);
            detail.setBrand(byId.getBrand());
            detail.setColor(byId.getColor());
            detail.setMaterial(byId.getMaterial());
            detail.setWeight(byId.getWeight().multiply(thousand));
            BigDecimal totalWeight = applyPurchaseDetailDTOParam.getQuantity().multiply(byId.getWeight()).multiply(thousand);
            detail.setTotalWeight(totalWeight);
            detail.setSpecification(byId.getPlate());
         } else {
            Preconditions.checkArgument(false, "制成品类型不明确！！！");
         }

         projectIds.add(detail.getProjectId().toString());
         this.applyPurchaseDetailMapper.insert(detail);
         TechProductSubscribeUpdateVORequest build = TechProductSubscribeUpdateVORequest.builder()
            .productId(applyPurchaseDetailDTOParam.getArtifactEnclosureId())
            .quantity(applyPurchaseDetailDTOParam.getQuantity().intValue())
            .build();
         techProductSubscribeUpdateVORequests.add(build);
      }

      applyPurchase.setMaterialType(materialType);
      if (ObjectUtil.isNotEmpty(applyPurchase.getPassParentId())) {
         ApplyPurchase oldApplyPurchase = this.baseMapper.getByIdAll(applyPurchase.getPassParentId());
         this.applyBoolAgainSubmitManufactured(oldApplyPurchase, applyPurchase, null);
      } else {
         this.applyManufactured(param.getFinishedProductType(), techProductSubscribeUpdateVORequests, true);
      }

      if (CollectionUtils.isNotEmpty(projectIds)) {
         List<String> collect = projectIds.stream().distinct().collect(Collectors.toList());
         applyPurchase.setProjectIds(StringUtils.list2String(collect, ","));
      }
   }

   private void initiateApproval(ApplyPurchase applyPurchase, List<ApplyPurchaseEnclosure> list, List<String> basicClassNames) {
      Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("申购详情列表", "申购附件"), ApplyPurchaseEnclosure.class, list);
      String path = this.configProperties.getFilePath() + applyPurchase.getSerialNumber() + ".xlsx";
      File file = new File(path);
      FileOutputStream os = null;
      Long fileSize = 0L;
      DDAttachment ddAttachment = null;

      try {
         file.createNewFile();
         os = new FileOutputStream(file);
         workbook.write(os);
         os.close();
         workbook.close();
         fileSize = file.length();
         ddAttachment = this.uploadDD(path, fileSize, applyPurchase.getSerialNumber() + ".xlsx");
         file.delete();
      } catch (Exception e) {
         e.printStackTrace();
      }

      List<FormComponentValue> values = new ArrayList<>();
      values.add(new FormComponentValue("申请人", UserUtil.getCurrentName()));
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      values.add(new FormComponentValue("申请日期", dateTimeFormatter.format(LocalDateTime.now())));
      values.add(new FormComponentValue("申购单号", applyPurchase.getSerialNumber()));
      values.add(new FormComponentValue("物料类型", StrUtil.join(",", basicClassNames)));
      if (applyPurchase.getProjectId() != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(applyPurchase.getProjectId());
         values.add(new FormComponentValue("所属项目", projectInfo.getSerialNumber() + "-" + projectInfo.getShortName()));
      }

      if (ddAttachment != null) {
         values.add(new FormComponentValue("申购详情", JSONArray.toJSONString(Collections.singletonList(ddAttachment))));
      }

      this.approveInstanceService.createApproveInstance(applyPurchase.getId(), applyPurchase.getApproveProcessId(), values, JSON.toJSONString(applyPurchase));
   }

   private void setSpec(ApplyPurchaseDetailDTO date, StringBuilder sb) {
      String thickness = date.getThickness() != null ? date.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = date.getWidth() != null ? date.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = date.getLength() != null ? date.getLength().stripTrailingZeros().toPlainString() : null;
      boolean b = StrUtil.isNotBlank(date.getSpecification());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(date.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append("*").append(length);
         if (b) {
            sb.append(" * ").append(date.getSpecification());
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(date.getBasicClass())) {
         sb.append(length);
         if (b) {
            sb.append(" * ").append(date.getSpecification());
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(date.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append(" * ");
         if (b) {
            sb.append(date.getSpecification());
         }

         if (StrUtil.isNotBlank(date.getColor())) {
            sb.append(" * ").append(date.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(date.getBasicClass())) {
         if (StrUtil.isNotBlank(date.getSpecification())) {
            sb.append(date.getSpecification());
            if (StrUtil.isNotBlank(date.getColor())) {
               sb.append(" * ").append(date.getColor());
            }
         } else if (StrUtil.isNotBlank(date.getColor())) {
            sb.append(date.getColor());
         }
      }
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
         map.put(2, BigDecimal.ONE);
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   private void checkApplyPurchase(ApplyPurchaseDTOParam param) {
      List<Integer> basicClassList = param.getList().stream().map(ApplyPurchaseDetailDTOParam::getBasicClass).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(basicClassList)) {
         Integer basicClass = null;

         for (Integer i : basicClassList) {
            if (basicClass == null) {
               basicClass = i;
            }

            basicClass = basicClass | i;
         }

         param.setMaterialType(basicClass);
      }

      List<ApplyPurchaseDetailDTOParam> collect = param.getList().stream().filter(d -> ObjectUtil.isEmpty(d.getProjectId())).collect(Collectors.toList());
      boolean boolIsProjectDetail = CollectionUtils.isNotEmpty(collect);
      List<ApplyPurchaseDetailDTOParam> notEmpty = param.getList().stream().filter(d -> ObjectUtil.isNotEmpty(d.getProjectId())).collect(Collectors.toList());
      List<Long> projectIdList = new TreeList<>();
      String projectIds = null;
      if (CollectionUtils.isNotEmpty(notEmpty)) {
         List<ApplyPurchaseDetailDTOParam> collect2 = param.getList()
            .stream()
            .filter(d -> ObjectUtil.isNotEmpty(d.getProjectId()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(collect2)) {
            List<String> collect1 = collect2.stream()
               .map(ApplyPurchaseDetailDTOParam::getProjectId)
               .collect(Collectors.toList())
               .stream()
               .distinct()
               .map(String::valueOf)
               .collect(Collectors.toList());
            projectIds = StringUtils.list2String(collect1, ",");
         }
      }

      for (ApplyPurchaseDetailDTOParam applyPurchaseDetailDTOParam : param.getList()) {
         if (ObjectUtil.isNotEmpty(applyPurchaseDetailDTOParam.getProjectId())) {
            projectIdList.add(applyPurchaseDetailDTOParam.getProjectId());
         }
      }

      param.setProjectIds(projectIds);
      param.setBoolIsProjectDetail(boolIsProjectDetail);
   }

   public void creatApplyPurchaseSD(ApplyPurchaseDTOParam param) {
      String serialNumber = null;
      String serialNumberParent = null;
      if (ObjectUtil.isEmpty(param.getId()) && ObjectUtil.isEmpty(param.getSerialNumber())) {
         int count = this.baseMapper.getCountByDateV2();

         while (true) {
            serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.REQUISITIONS, count, DateTimeUtils.getCurrentDateOfYYMMDD());
            List<ApplyPurchase> applyPurchases = this.baseMapper
               .selectList((Wrapper<ApplyPurchase>)new LambdaQueryWrapper<ApplyPurchase>().eq(ApplyPurchase::getSerialNumber, serialNumber));
            if (CollectionUtils.isEmpty(applyPurchases)) {
               serialNumberParent = serialNumber;
               param.setBoolSysgen(true);
               break;
            }

            count++;
         }
      }

      if (ObjectUtil.isEmpty(param.getId()) && ObjectUtil.isNotEmpty(param.getSerialNumber())) {
         List<ApplyPurchase> applyPurchases = this.baseMapper
            .selectList((Wrapper<ApplyPurchase>)new LambdaQueryWrapper<ApplyPurchase>().eq(ApplyPurchase::getSerialNumber, param.getSerialNumber()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(applyPurchases), "申购单编号已存在");
         serialNumber = param.getSerialNumber();
         serialNumberParent = param.getSerialNumber();
         param.setBoolSysgen(false);
      }

      if (ObjectUtil.isNotEmpty(param.getId()) && ObjectUtil.isNotEmpty(param.getSerialNumber())) {
         ApplyPurchase applyPurchase = this.baseMapper.getByIdAll(param.getId());
         if (applyPurchase.getSerialNumber().equals(param.getSerialNumber())) {
            param.setBoolSysgen(applyPurchase.getBoolSysgen());
            if (applyPurchase.getBoolSysgen() && !applyPurchase.getBoolTemporaryStorage()) {
               serialNumberParent = applyPurchase.getSerialNumberParent();
               Integer count = this.baseMapper.selectCountBySerialNumberParent(serialNumberParent);
               serialNumber = serialNumberParent + "-" + count;
            } else {
               serialNumber = applyPurchase.getSerialNumber();
               serialNumberParent = applyPurchase.getSerialNumberParent();
            }
         } else {
            serialNumber = param.getSerialNumber();
            serialNumberParent = applyPurchase.getSerialNumberParent();
         }

         List<ApplyPurchase> applyPurchases = this.baseMapper
            .selectList(
               (Wrapper<ApplyPurchase>)((new LambdaQueryWrapper<ApplyPurchase>().eq(ApplyPurchase::getSerialNumber, serialNumber))
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.isNull(ApplyPurchase::getDataStatus))
                                 .or())
                              .in(
                                 ApplyPurchase::getDataStatus,
                                 DataStatusEnum.UNDER_REVIEW.getType(),
                                 DataStatusEnum.SUCCEED.getType(),
                                 DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                              );
                        }
                     ))
                  .ne(ApplyPurchase::getId, param.getId())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(applyPurchases), "申购单编号已存在");
      }

      if (ObjectUtil.isEmpty(serialNumber) || ObjectUtil.isEmpty(serialNumberParent)) {
         Preconditions.checkArgument(false, "申购单编号设置失败");
      }

      param.setSerialNumber(serialNumber);
      param.setSerialNumberParent(serialNumberParent);
   }

   private void applyUpdateManufactured(ApplyPurchase applyPurchase, Boolean boolAdd) {
      List<ApplyPurchaseDetail> applyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, applyPurchase.getId()));
      List<TechProductSubscribeUpdateVORequest> techProductSubscribeUpdateVORequests = applyPurchaseDetails.stream()
         .map(a -> TechProductSubscribeUpdateVORequest.builder().productId(a.getArtifactEnclosureId()).quantity(a.getQuantity().intValue()).build())
         .collect(Collectors.toList());
      this.applyManufactured(applyPurchase.getFinishedProductType(), techProductSubscribeUpdateVORequests, boolAdd);
   }

   private void applyBoolAgainSubmitManufactured(ApplyPurchase oldApplyPurchase, ApplyPurchase newApplyPurchase, Boolean boolResult) {
      new ArrayList();
      new ApplyPurchase();
      List<ApplyPurchaseDetail> oldApplyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, oldApplyPurchase.getId()));
      List<ApplyPurchaseDetail> newApplyPurchaseDetails = this.applyPurchaseDetailMapper
         .selectList((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getApplyPurchaseId, newApplyPurchase.getId()));
      boolean boolType = oldApplyPurchase.getFinishedProductType().equals(newApplyPurchase.getFinishedProductType());
      List<ApplyPurchaseDetail> applyPurchaseDetails;
      ApplyPurchase applyPurchase;
      if (null == boolResult) {
         List<Long> artifactEnclosureOldIds = oldApplyPurchaseDetails.stream().map(ApplyPurchaseDetail::getArtifactEnclosureId).collect(Collectors.toList());
         applyPurchaseDetails = boolType
            ? newApplyPurchaseDetails.stream().filter(t -> !artifactEnclosureOldIds.contains(t.getArtifactEnclosureId())).collect(Collectors.toList())
            : newApplyPurchaseDetails;
         applyPurchase = newApplyPurchase;
      } else if (boolResult) {
         List<Long> newArtifactEnclosureIds = newApplyPurchaseDetails.stream().map(ApplyPurchaseDetail::getArtifactEnclosureId).collect(Collectors.toList());
         applyPurchaseDetails = boolType
            ? oldApplyPurchaseDetails.stream().filter(a -> !newArtifactEnclosureIds.contains(a.getArtifactEnclosureId())).collect(Collectors.toList())
            : oldApplyPurchaseDetails;
         applyPurchase = oldApplyPurchase;
      } else {
         List<Long> oldArtifactEnclosureIds = oldApplyPurchaseDetails.stream().map(ApplyPurchaseDetail::getArtifactEnclosureId).collect(Collectors.toList());
         applyPurchaseDetails = boolType
            ? newApplyPurchaseDetails.stream().filter(a -> !oldArtifactEnclosureIds.contains(a.getArtifactEnclosureId())).collect(Collectors.toList())
            : newApplyPurchaseDetails;
         applyPurchase = newApplyPurchase;
      }

      List<TechProductSubscribeUpdateVORequest> techProductSubscribeUpdateVORequests = applyPurchaseDetails.stream()
         .map(a -> TechProductSubscribeUpdateVORequest.builder().productId(a.getArtifactEnclosureId()).quantity(a.getQuantity().intValue()).build())
         .collect(Collectors.toList());
      this.applyManufactured(applyPurchase.getFinishedProductType(), techProductSubscribeUpdateVORequests, boolResult == null);
   }

   private void applyManufactured(Integer finishedProductType, List<TechProductSubscribeUpdateVORequest> techProductSubscribeUpdateVORequests, Boolean boolAdd) {
      if (!CollectionUtil.isEmpty(techProductSubscribeUpdateVORequests)) {
         switch (finishedProductType) {
            case 1:
               if (boolAdd) {
                  this.techMesWmsManager.addSubscribeArtifactQuantity(techProductSubscribeUpdateVORequests);
               } else {
                  this.techMesWmsManager.removeSubscribeArtifactQuantity(techProductSubscribeUpdateVORequests);
               }
               break;
            case 2:
               if (boolAdd) {
                  this.techMesWmsManager.addEnclosureSubscribeQuantity(techProductSubscribeUpdateVORequests);
               } else {
                  this.techMesWmsManager.removeEnclosureSubscribeQuantity(techProductSubscribeUpdateVORequests);
               }
               break;
            default:
               Preconditions.checkArgument(false, "属于制成品申购，但成品类型未知！！！");
         }
      }
   }

   private BigDecimal getInboundMete(Long applyDetailId) {
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService
         .selectPassDetailByApplyDetailIds(Collections.singletonList(applyDetailId));
      if (CollectionUtil.isEmpty(purchaseOrderDetails)) {
         return BigDecimal.ZERO;
      }

      List<Long> purchaseIds = purchaseOrderDetails.stream().map(PurchaseOrderDetail::getPurchaseId).distinct().collect(Collectors.toList());
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.listByIds(purchaseIds);
      BigDecimal bigDecimal = new BigDecimal("0");

      for (PurchaseOrder order : purchaseOrders) {
         List<Long> orderDetailIds = purchaseOrderDetails.stream()
            .filter(t -> t.getPurchaseId().equals(order.getId()))
            .map(PurchaseOrderDetail::getId)
            .collect(Collectors.toList());
         if (PlaceEnum.FACTORY.getType().equals(order.getOrderPlace())) {
            if (PurchaseEnum.MATERIAL.getType().equals(order.getPurchaseType())) {
               List<PuchaseInboundDetailDTO> factoryInboundDetailList = this.inboundService.getFactoryInboundDetailList(order.getId(), orderDetailIds);
               if (CollectionUtil.isNotEmpty(factoryInboundDetailList)) {
                  bigDecimal = bigDecimal.add(
                     factoryInboundDetailList.stream().map(PuchaseInboundDetailDTO::getRealityMete).reduce(BigDecimal.ZERO, BigDecimal::add)
                  );
               }
            }

            if (PurchaseEnum.FINISHED_GOODS.getType().equals(order.getPurchaseType())) {
               List<PuchaseInboundDetailDTO> puchaseInboundDetailDTOS = this.inboundManufacturedService.orderDetailV2(order.getId(), orderDetailIds);
               bigDecimal = bigDecimal.add(
                  puchaseInboundDetailDTOS.stream().map(PuchaseInboundDetailDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add)
               );
            }
         }

         if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(order.getOrderPlace())) {
            List<PuchaseInboundDetailDTO> constructionInboundDetailList = this.inboundService.getConstructionInboundDetailList(order.getId(), orderDetailIds);
            bigDecimal = bigDecimal.add(
               constructionInboundDetailList.stream().map(PuchaseInboundDetailDTO::getRealityMete).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         }
      }

      return bigDecimal;
   }
}
