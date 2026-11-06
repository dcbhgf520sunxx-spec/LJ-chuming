package com.hzchum.scim.common.core.service.impl.zhongnanoa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.HttpUrlUtils;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.config.ZhongNanOaProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveSourceEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.FunctionTypeEnum;
import com.hzchum.scim.common.core.api.enums.ModuleTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.oa.OAResultWorkFlowStatusEnum;
import com.hzchum.scim.common.core.api.enums.oa.OaBusinessTypeEnum;
import com.hzchum.scim.common.core.api.enums.oa.OaWorkflowNameEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanFixedDataDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAnnualContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaArgumentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAttachmentsDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaDeepenDrawingDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPaymentDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchasePaymentDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseSettleAccountDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDataIdDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.WorkflowDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.WorkflowRequestTableField;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.WorkflowRequestTableRecord;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaWorkflowResultHandler;
import com.hzchum.scim.common.core.api.utils.ComponentNameUtils;
import com.hzchum.scim.common.core.api.utils.oa.RSA;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.plan.core.api.biz.approve.TechnologicalAchievementBiz;
import com.hzchum.scim.plan.core.api.enums.PlanFileOverlayEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanTechnologicalAchievementApproveRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanApproveOpinionDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.PlanTechnologicalAchievementApproveRecordService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OaBusinessProcessServiceImpl implements OaBusinessProcessService {
   private static final Logger log = LoggerFactory.getLogger(OaBusinessProcessServiceImpl.class);
   private final String CONTENT_TYPE = "application/json";
   private static String PATH = "files" + File.separator;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private ZhongNanOaProperties oaProperties;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private PurchaseOrderService orderService;
   @Resource
   private UserService userService;
   @Resource
   private SupplierPaymentService paymentService;
   @Resource
   private ContractAuditLedgerService auditLedgerService;
   @Resource
   private SupplierSettlementService settlementService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private BranchCompanyService companyService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private WmsApproveRecordService recordService;
   @Resource
   private WmsApproveRecordDetailService recordDetailService;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   private TechDrawingService techDrawingService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanTechnologicalAchievementApproveRecordService approveRecordService;
   private static final String PLAN_KEY = "plan";
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private TechnologicalAchievementBiz technologicalAchievementBiz;
   @Autowired(required = false)
   private List<OaWorkflowResultHandler> oaWorkflowResultHandlers = Collections.emptyList();

   @Override
   public String doCreatePurchaseContractManufacturedGoods(OaPurchaseContractDTOParam purchaseContractDTOParam) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(purchaseContractDTOParam.getSqr(), purchaseContractDTOParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(purchaseContractDTOParam);
         if (StringUtils.isNotBlank(purchaseContractDTOParam.getTitle())) {
            purchaseContractDTOParam.setRequestName(purchaseContractDTOParam.getTitle());
         }
      } catch (Exception e) {
         return e.getMessage();
      }

      return this.doCreateRequest(
         purchaseContractDTOParam.getRequestName(), zhongNanWorkFlowDTO.getWorkflowId(), purchaseContractDTOParam.getSqr(), argumentDTOS, null
      );
   }

   @Override
   public String doCreateAnnualContractRawMaterial(OaAnnualContractDTOParam annualContractDTOParam) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(annualContractDTOParam.getSqr(), annualContractDTOParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(annualContractDTOParam);
         if (StringUtils.isNotBlank(annualContractDTOParam.getTitle())) {
            annualContractDTOParam.setRequestName(annualContractDTOParam.getTitle());
         }
      } catch (Exception e) {
         return e.getMessage();
      }

      return this.doCreateRequest(
         annualContractDTOParam.getRequestName(), zhongNanWorkFlowDTO.getWorkflowId(), annualContractDTOParam.getSqr(), argumentDTOS, null
      );
   }

   @Override
   public String doCreateAnnualContract(OaAnnualContractDTOParam annualContractDTOParam) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(annualContractDTOParam.getSqr(), annualContractDTOParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(annualContractDTOParam);
         if (StringUtils.isNotBlank(annualContractDTOParam.getTitle())) {
            annualContractDTOParam.setRequestName(annualContractDTOParam.getTitle());
         }
      } catch (Exception e) {
         return e.getMessage();
      }

      return this.doCreateRequest(
         annualContractDTOParam.getRequestName(), zhongNanWorkFlowDTO.getWorkflowId(), annualContractDTOParam.getSqr(), argumentDTOS, null
      );
   }

   @Override
   public String doCreatePurchasePayment(OaPurchasePaymentDTOParam purchasePaymentDTOParam) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(purchasePaymentDTOParam.getSqr(), purchasePaymentDTOParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(purchasePaymentDTOParam);
         if (StringUtils.isNotBlank(purchasePaymentDTOParam.getTitle())) {
            purchasePaymentDTOParam.setRequestName(purchasePaymentDTOParam.getTitle());
         }
      } catch (Exception e) {
         return e.getMessage();
      }

      return this.doCreateRequest(
         purchasePaymentDTOParam.getRequestName(),
         zhongNanWorkFlowDTO.getWorkflowId(),
         purchasePaymentDTOParam.getSqr(),
         argumentDTOS,
         this.resultDetailData(purchasePaymentDTOParam.getOaSupplierPaymentDTO())
      );
   }

   @Override
   public String doCreatePurchaseSettleAccountsRawMaterial(OaPurchaseSettleAccountDTOParam purchaseSettleAccountDTOParam) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(purchaseSettleAccountDTOParam.getSqr(), purchaseSettleAccountDTOParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(purchaseSettleAccountDTOParam);
         if (StringUtils.isNotBlank(purchaseSettleAccountDTOParam.getTitle())) {
            purchaseSettleAccountDTOParam.setRequestName(purchaseSettleAccountDTOParam.getTitle());
         }
      } catch (Exception e) {
         return e.getMessage();
      }

      return this.doCreateRequest(
         purchaseSettleAccountDTOParam.getRequestName(), zhongNanWorkFlowDTO.getWorkflowId(), purchaseSettleAccountDTOParam.getSqr(), argumentDTOS, null
      );
   }

   @Override
   public String doCreatePurchaseSettleAccountsManufacturedGoods(OaPurchaseContractDTOParam purchaseContractDTOParam) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(purchaseContractDTOParam.getSqr(), purchaseContractDTOParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(purchaseContractDTOParam);
         if (StringUtils.isNotBlank(purchaseContractDTOParam.getTitle())) {
            purchaseContractDTOParam.setRequestName(purchaseContractDTOParam.getTitle());
         }
      } catch (Exception e) {
         return e.getMessage();
      }

      return this.doCreateRequest(
         purchaseContractDTOParam.getRequestName(), zhongNanWorkFlowDTO.getWorkflowId(), purchaseContractDTOParam.getSqr(), argumentDTOS, null
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO withdrawRequest(OaRevocationDTOParam oaRevocationDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, Object> paramsMap = new HashMap<>();
      paramsMap.put("isremind", oaRevocationDTOParam.getIsremind());
      paramsMap.put("remark", oaRevocationDTOParam.getRemark());
      paramsMap.put("requestId", oaRevocationDTOParam.getRequestId());
      String urlEncodedForm = this.generateUrlEncodedForm(paramsMap);
      log.info("urlEncodedForm：" + urlEncodedForm);
      String data = HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/workflow/paService/doForceDrawBack",
         null,
         this.getHeaderMap(oaRevocationDTOParam.getOaUserId()),
         urlEncodedForm,
         "application/x-www-form-urlencoded"
      );
      JSONObject jsonObject = JSONObject.parseObject(data);
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
         this.checkChuMingData(oaRevocationDTOParam);
      } else {
         build.setMessage("已不可撤回！");
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ResultVO updateOaRequestId(@RequestBody WorkflowDTOParam workflowDTOParam) {
      String serialNumber = "";

      List<WmsApproveRecord> wmsApproveRecords;
      do {
         serialNumber = this.recordService.createApproveSerialNumber("wms_approve_flow_operation");
         wmsApproveRecords = this.recordService.list((Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getSerialNumber, serialNumber));
      } while (!CollectionUtils.isEmpty(wmsApproveRecords));

      WmsApproveRecord record = WmsApproveRecord.builder()
         .moduleType(ModuleTypeEnum.SUPPLY_CHAIN.getType())
         .dataId(workflowDTOParam.getId())
         .serialNumber(serialNumber)
         .startTime(workflowDTOParam.getApplicationTime())
         .applicantId(workflowDTOParam.getApplicationId())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .lastApproverId(workflowDTOParam.getApplicationId())
         .lastApprovalTime(workflowDTOParam.getApplicationTime())
         .requestId(workflowDTOParam.getRequestId())
         .dataSerialNumber(workflowDTOParam.getRequestId())
         .approveSource(ApproveSourceEnum.OA.getType())
         .build();
      WmsApproveRecordDetail recordDetail = WmsApproveRecordDetail.builder()
         .dataId(workflowDTOParam.getId())
         .moduleType(ModuleTypeEnum.SUPPLY_CHAIN.getType())
         .approveRecordSerialNumber(serialNumber)
         .flowType(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())
         .checkUserId(workflowDTOParam.getApplicationId())
         .requestId(workflowDTOParam.getRequestId())
         .arrivalTime(workflowDTOParam.getApplicationTime())
         .approveTime(workflowDTOParam.getApplicationTime())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .approveSource(ApproveSourceEnum.OA.getType())
         .decision(CheckStatusEnum.PASS.getType())
         .build();
      boolean equals = OaBusinessTypeEnum.CONTRACT.getType().equals(workflowDTOParam.getBusinessType());
      if (equals) {
         record.setFunctionType(FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getType());
         record.setApproveProcessType(ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType());
         record.setComponentName(
            ProjectAttributeEnum.SELF_SUPPORT.getType().equals(workflowDTOParam.getModeOperation()) ? "PurchaseOrderV2" : "PurchaseOrderBG"
         );
         recordDetail.setFunctionType(FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER.getType());
         recordDetail.setApproveProcessType(ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType());
      } else {
         if (OaBusinessTypeEnum.PAYMENT.getType().equals(workflowDTOParam.getBusinessType())) {
            record.setComponentName(
               ProjectAttributeEnum.SELF_SUPPORT.getType().equals(workflowDTOParam.getModeOperation()) ? "PurchaseOrderV2Payment" : "PurchaseOrderBGPayment"
            );
            Integer num = ProjectAttributeEnum.SELF_SUPPORT.getType().equals(workflowDTOParam.getModeOperation())
               ? ApproveProcessTypeEnumV2.SELF_BUYING_PAYMENT_AUDIT.getType()
               : ApproveProcessTypeEnumV2.INNER_PACKAGE_PAYMENT_AUDIT.getType();
            record.setApproveProcessType(num);
            recordDetail.setApproveProcessType(num);
         } else {
            Integer num = ProjectAttributeEnum.SELF_SUPPORT.getType().equals(workflowDTOParam.getModeOperation())
               ? ApproveProcessTypeEnumV2.SELF_BUYING_SETTLEANACCOUNT_AUDIT.getType()
               : ApproveProcessTypeEnumV2.INNER_PACKAGE_SETTLEMENT_AUDIT.getType();
            record.setComponentName(
               ProjectAttributeEnum.SELF_SUPPORT.getType().equals(workflowDTOParam.getModeOperation())
                  ? "PurchaseOrderV2Settlement"
                  : "PurchaseOrderBGSettlement"
            );
            record.setApproveProcessType(num);
            recordDetail.setApproveProcessType(num);
         }

         record.setFunctionType(FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getType());
         recordDetail.setFunctionType(FunctionTypeEnum.SUPPLY_CHAIN_PURCHASE_ORDER_AUDIT.getType());
      }

      this.recordService.save(record);
      this.recordDetailService.save(recordDetail);
      if (equals) {
         this.orderService.update(workflowDTOParam.getId());
         PurchaseOrder order = this.orderService.getById(workflowDTOParam.getId());
         order.setRequestId(workflowDTOParam.getRequestId());
         order.setApproveRecordIdNow(record.getId());
         order.setApproveRecordIds(String.valueOf(record.getId()));
         order.setSettlementStatus(SettlementStatusEnum.UN_SETTLED.getType());
         this.orderService.updateById(order);
      } else {
         this.auditLedgerService.update(workflowDTOParam.getId());
         ContractAuditLedger auditLedger = this.auditLedgerService.getById(workflowDTOParam.getId());
         if (OaBusinessTypeEnum.PAYMENT.getType().equals(workflowDTOParam.getBusinessType())) {
            List<String> paymentIds = Arrays.stream(auditLedger.getPaymentId().split(",")).collect(Collectors.toList());
            paymentIds.forEach(item -> this.paymentService.update(Long.parseLong(item)));
         } else {
            this.settlementService.update(Long.parseLong(auditLedger.getPaymentId()));
         }

         auditLedger.setBoolDeleteEnum(Boolean.TRUE);
         auditLedger.setRequestId(workflowDTOParam.getRequestId());
         auditLedger.setApproveRecordId(record.getId());
         auditLedger.setOaNumber(workflowDTOParam.getRequestId());
         this.auditLedgerService.updateById(auditLedger);
      }

      return ResultBuilder.success("响应成功");
   }

   private void checkChuMingData(OaRevocationDTOParam oaRevocationDTOParam) {
      log.info("OA审批撤回成功，开始处理初鸣数据");
      WmsApproveRecord record = this.recordService
         .getOne(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getRequestId, oaRevocationDTOParam.getRequestId()));
      if (record == null) {
         log.warn("OA流程已撤回，但本地审批记录尚未创建，requestId={}", oaRevocationDTOParam.getRequestId());
      } else {
         record.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         record.setStatus(ApproveRecordStatusEnum.END.getType());
         record.setEndTime(LocalDateTime.now());
         record.setLastApprovalTime(LocalDateTime.now());
         record.setLastApproverId(UserUtil.getCurrentUserId());
         List<WmsApproveRecordDetail> resourceRecordDetails = this.recordDetailService
            .list(Wrappers.lambdaQuery(WmsApproveRecordDetail.class).eq(WmsApproveRecordDetail::getRequestId, oaRevocationDTOParam.getRequestId()));
         if (CollectionUtils.isEmpty(resourceRecordDetails)) {
            log.warn("OA流程撤回时未找到本地审批明细，requestId={}", oaRevocationDTOParam.getRequestId());
            this.recordService.updateById(record);
            this.oaWorkflowResultHandlers
               .stream()
               .filter(handler -> handler.supportsWithdraw(record.getApproveProcessType()))
               .forEach(handler -> handler.handleWithdraw(record));
         } else {
            WmsApproveRecordDetail targetRecordDetail = WmsApproveRecordDetail.builder().build();
            BeanUtil.copy(resourceRecordDetails.get(0), targetRecordDetail);
            targetRecordDetail.setDecision(CheckStatusEnum.CANCEL.getType());
            targetRecordDetail.setFlowType(ApproveTemplateVersionsFlowEnum.A_SIGN.getType());
            targetRecordDetail.setArrivalTime(LocalDateTime.now());
            targetRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
            targetRecordDetail.setApproveSource(ApproveSourceEnum.OA.getType());
            targetRecordDetail.setApproveTime(LocalDateTime.now());
            record.setStatus(ApproveRecordStatusEnum.END.getType());
            targetRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
            if (ApproveProcessTypeEnumV2.PURCHASE_ORDER_ADD.getType().equals(oaRevocationDTOParam.getApproveProcessType())) {
               PurchaseOrder order = this.orderService
                  .getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getRequestId, oaRevocationDTOParam.getRequestId()));
               if (ObjectUtils.isNotEmpty(order)) {
                  order.setDataStatus(DataStatusEnum.USELESS.getType());
                  order.setPurchaseStatus(null);
                  this.orderService.updateById(order);
                  log.info("采购订单数据：" + order.toString());
               }
            }

            if (ApproveProcessTypeEnumV2.SELF_BUYING_PAYMENT_AUDIT.getType().equals(oaRevocationDTOParam.getApproveProcessType())
               || ApproveProcessTypeEnumV2.INNER_PACKAGE_PAYMENT_AUDIT.getType().equals(oaRevocationDTOParam.getApproveProcessType())) {
               ContractAuditLedger ledger = this.auditLedgerService
                  .getOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getRequestId, oaRevocationDTOParam.getRequestId()));
               ledger.setAuditStatusEnum(AuditStatusEnum.CANCEL.getType());
               List<String> paymentIds = Arrays.stream(ledger.getPaymentId().split(",")).collect(Collectors.toList());
               List<SupplierPayment> newSupplierPayment = new ArrayList<>();
               List<SupplierPayment> supplierPayments = this.paymentService
                  .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getId, paymentIds));
               supplierPayments.forEach(supplierPayment -> {
                  supplierPayment.setAuditStatus(AuditStatusEnum.CANCEL.getType());
                  supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
                  supplierPayment.setAuditUserName(UserUtil.getCurrentName());
                  supplierPayment.setAuditTime(LocalDateTime.now());
                  newSupplierPayment.add(supplierPayment);
               });
               this.paymentService.updateBatchById(newSupplierPayment);
               this.auditLedgerService.updateById(ledger);
               log.info("付款数据：" + newSupplierPayment.toString());
            }

            if (ApproveProcessTypeEnumV2.SELF_BUYING_SETTLEANACCOUNT_AUDIT.getType().equals(oaRevocationDTOParam.getApproveProcessType())
               || ApproveProcessTypeEnumV2.INNER_PACKAGE_SETTLEMENT_AUDIT.getType().equals(oaRevocationDTOParam.getApproveProcessType())) {
               ContractAuditLedger ledger = this.auditLedgerService
                  .getOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getRequestId, oaRevocationDTOParam.getRequestId()));
               ledger.setAuditStatusEnum(ReviewStatusEnum.CANCEL.getType());
               SupplierSettlement settlement = this.settlementService.getById(ledger.getPaymentId());
               settlement.setAuditStatus(AuditStatusEnum.CANCEL.getType());
               settlement.setAuditUserId(UserUtil.getCurrentUserId());
               settlement.setAuditTime(LocalDateTime.now());
               settlement.setAuditUserName(UserUtil.getCurrentName());
               this.settlementService.updateById(settlement);
               this.auditLedgerService.updateById(ledger);
               log.info("结算数据：" + settlement.toString());
            }

            log.info("修改审批列表数据" + record.toString() + "审批详情数据：" + targetRecordDetail.toString());
            this.recordService.updateById(record);
            this.recordDetailService.updateById(targetRecordDetail);
            List<WmsApproveRecordDetail> resourceRecordDetailList = this.recordDetailService
               .list(
                  Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
                     .eq(WmsApproveRecordDetail::getRequestId, oaRevocationDTOParam.getRequestId())
                     .eq(WmsApproveRecordDetail::getStatus, ApproveRecordStatusEnum.UNDERWAY.getType())
               );
            resourceRecordDetailList.forEach(item -> {
               item.setStatus(ApproveRecordStatusEnum.END.getType());
               item.setDecision(CheckStatusEnum.CANCEL.getType());
               this.recordDetailService.updateById(item);
            });
            this.oaWorkflowResultHandlers
               .stream()
               .filter(handler -> handler.supportsWithdraw(record.getApproveProcessType()))
               .forEach(handler -> handler.handleWithdraw(record));
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ResultVO approvalFlowStatus(OaWorkflowDTOParam workflowDTOParam) {
      Preconditions.checkArgument(
         OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
            || OAResultWorkFlowStatusEnum.REJECT.getType().equals(workflowDTOParam.getApproveStatus()),
         "OA审批状态参数不正确"
      );
      Preconditions.checkArgument(StringUtil.isNotEmpty(workflowDTOParam.getRequestmark()), "OA请求标识不能为空");
      Preconditions.checkArgument(StringUtil.isNotEmpty(workflowDTOParam.getRequestId()), "OA流程requestId不能为空");
      Preconditions.checkArgument(StringUtil.isNotEmpty(workflowDTOParam.getLastOperatorId()), "OA最后操作人ID不能为空");
      if (StringUtils.isNotBlank(workflowDTOParam.getReason())) {
         workflowDTOParam.setReason(workflowDTOParam.getReason().replaceAll("<.*?>", ""));
      }

      Integer targetReviewStatus = OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
         ? ReviewStatusEnum.REVIEWED.getType()
         : ReviewStatusEnum.RETURNED.getType();
      WmsApproveRecord record = this.recordService
         .getOne(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getRequestId, workflowDTOParam.getRequestId()).last("FOR UPDATE"));
      Preconditions.checkArgument(record != null, "未找到requestId对应的本地审批记录");
      if (ApproveRecordStatusEnum.END.getType().equals(record.getStatus())) {
         Preconditions.checkArgument(targetReviewStatus.equals(record.getReviewStatus()), "OA回调结果与已完成的审批结果冲突");
         return ResultBuilder.success("OA回调已处理，无需重复处理");
      }

      User user = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getOaUserId, workflowDTOParam.getLastOperatorId()));
      Preconditions.checkArgument(user != null, "未找到OA最后操作人对应的本地用户");
      record.setReviewStatus(targetReviewStatus);
      record.setStatus(ApproveRecordStatusEnum.END.getType());
      record.setEndTime(LocalDateTime.now());
      record.setLastApprovalTime(LocalDateTime.now());
      record.setLastApproverId(user.getId());
      List<WmsApproveRecordDetail> resourceRecordDetails = this.recordDetailService
         .list(Wrappers.lambdaQuery(WmsApproveRecordDetail.class).eq(WmsApproveRecordDetail::getRequestId, workflowDTOParam.getRequestId()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(resourceRecordDetails), "未找到requestId对应的本地审批明细");
      WmsApproveRecordDetail targetRecordDetail = WmsApproveRecordDetail.builder().build();
      BeanUtil.copy(resourceRecordDetails.get(0), targetRecordDetail);
      targetRecordDetail.setId(null);
      targetRecordDetail.setDecision(
         OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
            ? CheckStatusEnum.PASS.getType()
            : CheckStatusEnum.FAIL.getType()
      );
      targetRecordDetail.setFlowType(ApproveTemplateVersionsFlowEnum.A_SIGN.getType());
      targetRecordDetail.setArrivalTime(LocalDateTime.now());
      targetRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
      targetRecordDetail.setApproveSource(ApproveSourceEnum.OA.getType());
      targetRecordDetail.setApproveTime(LocalDateTime.now());
      targetRecordDetail.setOpinion(workflowDTOParam.getReason());
      targetRecordDetail.setCheckUserId(user.getId());
      record.setStatus(ApproveRecordStatusEnum.END.getType());
      targetRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
      log.info("开始处理业务数据");
      Integer status = OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
         ? AuditStatusEnum.SUCCEED.getType()
         : AuditStatusEnum.FAILED.getType();
      String workflowTypeName = this.normalizeWorkflowName(workflowDTOParam.getWorkflowTypeName());
      String workflowName = this.normalizeWorkflowName(workflowDTOParam.getWorkflowName());
      if (OaWorkflowNameEnum.PROCESS_PAYMENT.getName().equals(workflowTypeName)) {
         BigDecimal amount = BigDecimal.ZERO;
         if (status.equals(AuditStatusEnum.SUCCEED.getType())) {
            amount = new BigDecimal(workflowDTOParam.getActuallySettlementAmount());
         }

         PurchaseOrder order = this.orderService
            .getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getRequestId, workflowDTOParam.getRequestId()));
         if (ObjectUtils.isEmpty(order)) {
            ContractAuditLedger ledger = this.auditLedgerService
               .getOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getRequestId, workflowDTOParam.getRequestId()));
            ledger.setAuditStatusEnum(status);
            ledger.setOaNumber(workflowDTOParam.getRequestmark());
            ledger.setActuallyPayAmount(amount);
            SupplierSettlement settlement = this.settlementService.getById(ledger.getPaymentId());
            settlement.setAuditStatus(status);
            settlement.setAuditUserId(user.getId());
            settlement.setAuditTime(LocalDateTime.now());
            settlement.setAuditUserName(user.getName());
            settlement.setAmount(amount);
            PurchaseOrder one = this.orderService.getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getId, settlement.getOrderId()));
            if (AuditStatusEnum.FAILED.getType().equals(status)) {
               one.setSettlementAmount(null);
            } else {
               one.setSettlementAmount(amount);
               one.setSettlementStatus(SettlementStatusEnum.SETTLED.getType());
            }

            this.orderService.updateById(one);
            this.settlementService.updateById(settlement);
            this.auditLedgerService.updateById(ledger);
         } else {
            order.setReviewStatus(
               OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
                  ? ReviewStatusEnum.REVIEWED.getType()
                  : ReviewStatusEnum.RETURNED.getType()
            );
            order.setDataStatus(
               OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
                  ? DataStatusEnum.SUCCEED.getType()
                  : DataStatusEnum.CANCELLATION.getType()
            );
            order.setPurchaseStatus(
               OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
                  ? PurchaseStatusEnum.DURING.getType()
                  : PurchaseStatusEnum.FINISH.getType()
            );
            this.orderService.updateById(order);
         }
      }

      if (OaWorkflowNameEnum.CONTRACT_SETTLE.getName().equals(workflowTypeName)) {
         PurchaseOrder order = this.orderService
            .getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getRequestId, workflowDTOParam.getRequestId()));
         order.setReviewStatus(
            OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
               ? ReviewStatusEnum.REVIEWED.getType()
               : ReviewStatusEnum.RETURNED.getType()
         );
         order.setDataStatus(
            OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
               ? DataStatusEnum.SUCCEED.getType()
               : DataStatusEnum.CANCELLATION.getType()
         );
         order.setPurchaseStatus(
            OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
               ? PurchaseStatusEnum.DURING.getType()
               : PurchaseStatusEnum.FINISH.getType()
         );
         if (OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())) {
            this.orderService.updateApplyProductQuantityAndMete(order, Boolean.TRUE);
         }

         this.orderService.updateById(order);
      }

      if (OaWorkflowNameEnum.CONTRACT_PAYMENT.getName().equals(workflowTypeName) || OaWorkflowNameEnum.CONTRACT_APPROVE.getName().equals(workflowTypeName)) {
         ContractAuditLedger ledger = this.auditLedgerService
            .getOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getRequestId, workflowDTOParam.getRequestId()));
         ledger.setOaNumber(workflowDTOParam.getRequestmark());
         ledger.setAuditStatusEnum(status);
         ledger.setSubmitDate(LocalDateTime.now());
         if (OaWorkflowNameEnum.CONTRACT_PAYMENT.getName().equals(workflowTypeName)) {
            if (OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())) {
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(workflowDTOParam.getActuallyPaymentDetails()), "OA实付明细不能为空");
               BigDecimal actuallyPaymentAmount = workflowDTOParam.getActuallyPaymentDetails()
                  .stream()
                  .map(OaPaymentDetailDTO::getPaymentAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               ledger.setActuallyPayAmount(AuditStatusEnum.SUCCEED.getType().equals(status) ? actuallyPaymentAmount : new BigDecimal(0));
            }

            this.chenkData(ledger, status, workflowDTOParam, user);
         } else {
            BigDecimal actuallyPayAmount = AuditStatusEnum.SUCCEED.getType().equals(status)
               ? new BigDecimal(workflowDTOParam.getActuallySettlementAmount())
               : new BigDecimal(0);
            SupplierSettlement settlement = this.settlementService.getById(ledger.getPaymentId());
            settlement.setAuditStatus(status);
            settlement.setAuditUserId(user.getId());
            settlement.setAuditTime(LocalDateTime.now());
            settlement.setAuditUserName(user.getName());
            PurchaseOrder one = this.orderService.getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getId, settlement.getOrderId()));
            if (AuditStatusEnum.FAILED.getType().equals(status)) {
               one.setSettlementAmount(new BigDecimal(0));
            } else {
               one.setSettlementAmount(actuallyPayAmount);
               one.setSettlementStatus(SettlementStatusEnum.SETTLED.getType());
            }

            this.orderService.updateById(one);
            this.settlementService.updateById(settlement);
            ledger.setActuallyPayAmount(actuallyPayAmount);
         }

         this.auditLedgerService.updateById(ledger);
      }

      if (OaWorkflowNameEnum.DEEPEN_DRAWINGS.getName().equals(workflowTypeName)) {
         SecurityUser securityUser = new SecurityUser(
            user.getId(),
            user.getUsername(),
            user.getName(),
            user.getSex(),
            user.getPhone(),
            user.getEmail(),
            user.getPassword(),
            user.getCreateTime(),
            user.getLastPasswordResetDate(),
            null,
            null,
            null,
            null,
            null,
            user.getIsEnabled(),
            null,
            null,
            "admin".equals(user.getUsername()),
            user.getInventoryNotifyPerm(),
            user.getUserType(),
            user.getDdUserId(),
            user.getDdDeptId(),
            user.getOaUserId()
         );
         Authentication auth = new UsernamePasswordAuthenticationToken(securityUser, null, null);
         SecurityContextHolder.getContext().setAuthentication(auth);
         PlanApproveOpinionDTOParam opinionDTOParam = new PlanApproveOpinionDTOParam();
         opinionDTOParam.setDataId(record.getDataId());
         opinionDTOParam.setApproveRecordId(record.getId());
         opinionDTOParam.setDecision(
            OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
               ? ReviewStatusEnum.REVIEWED.getType()
               : ReviewStatusEnum.RETURNED.getType()
         );

         try {
            this.technologicalAchievementBiz.OaCommonApprove(opinionDTOParam);
         } catch (Exception e) {
            throw new BusinessException("深化图纸保存失败：" + e.getMessage());
         }
      }

      List<OaWorkflowResultHandler> matchedHandlers = this.oaWorkflowResultHandlers
         .stream()
         .filter(handler -> handler.supportsApproveProcessType(record.getApproveProcessType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(matchedHandlers)) {
         matchedHandlers = this.oaWorkflowResultHandlers
            .stream()
            .filter(handler -> handler.supports(workflowTypeName) || handler.supports(workflowName))
            .collect(Collectors.toList());
      }

      matchedHandlers.forEach(handler -> handler.handle(workflowDTOParam, record));
      List<WmsApproveRecordDetail> underwayDetails = resourceRecordDetails.stream()
         .filter(item -> ApproveRecordStatusEnum.UNDERWAY.getType().equals(item.getStatus()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(underwayDetails)) {
         underwayDetails.forEach(item -> item.setStatus(ApproveRecordStatusEnum.END.getType()));
         Preconditions.checkArgument(this.recordDetailService.updateBatchById(underwayDetails), "结束原审批明细失败");
      }

      Preconditions.checkArgument(this.recordDetailService.save(targetRecordDetail), "保存OA审批结果明细失败");
      record.setLastDetailId(targetRecordDetail.getId());
      Preconditions.checkArgument(this.recordService.updateById(record), "更新OA审批主记录失败");
      return ResultBuilder.success("响应成功");
   }

   private void validateSettlementDraftPreview(ContractAuditLedger ledger, PurchaseOrder order) {
      if (!Boolean.TRUE.equals(ledger.getBoolDeleteEnum())) {
         return;
      }
      SecurityUser actor = UserUtil.getCurrentUser();
      Preconditions.checkArgument(actor.isAdmin() || actor.getPermissions() != null
         && actor.getPermissions().contains("scm_purchaseOrder_v2:pay_application"), "无权限访问");
      Long creator = ledger.getWrittenById() == null ? ledger.getInitiatorId() : ledger.getWrittenById();
      Preconditions.checkArgument(actor.getId().equals(creator), "无权限访问其他用户的结算草稿");
      Preconditions.checkArgument(Integer.valueOf(1).equals(ledger.getAuditStatusEnum())
         && (Integer.valueOf(7).equals(ledger.getPaymentEnum()) || Integer.valueOf(10).equals(ledger.getPaymentEnum())), "结算草稿状态不正确");
      java.util.Set<Long> visible = this.projectService.listSimpleProject(null, null, null, null).getContent().stream()
         .map(project -> project.getId()).collect(Collectors.toSet());
      Preconditions.checkArgument(order.getProjectIds() != null && Arrays.stream(order.getProjectIds().split(","))
         .allMatch(id -> visible.contains(Long.valueOf(id))), "无权限访问该项目");
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ResultVO<ZhongNanFixedDataDTO> getFixedData(@RequestParam("dataId") Long dataId, @RequestParam("businessType") Integer businessType) {
      User user = this.userService.getById(UserUtil.getCurrentUserId());
      ZhongNanFixedDataDTO build = ZhongNanFixedDataDTO.builder()
         .userId(user.getOaUserId())
         .userName(UserUtil.getCurrentName())
         .deptId(user.getOaDeptId())
         .deptName(UserUtil.getCurrentDepartment().getName())
         .sudDeptId(user.getOaSubDeptId())
         .sudDeptName(user.getOaSubDeptName())
         .applicationTime(LocalDateTime.now())
         .build();
      if (OaBusinessTypeEnum.CONTRACT.getType().equals(businessType)) {
         PurchaseOrder order = this.orderService.getById(dataId);
         Object object = this.redisTemplate.opsForValue().get("oa_purchase_order_detail_dataId:" + dataId);
         if (ObjectUtils.isNotEmpty(object)) {
            build.setOrderDetailAttachment((Attachment)object);
            this.redisTemplate.delete("oa_purchase_order_detail_dataId:" + dataId);
         }

         if (ObjectUtils.isNotEmpty(order)) {
            if (StringUtil.isNotEmpty(order.getAttachments())) {
               List<Attachment> attachments = this.attachmentService
                  .list(Wrappers.lambdaQuery(Attachment.class).in(Attachment::getId, order.getAttachments().split(",")));
               build.setAttachmentList(attachments);
            }

            build.setAmount(order.getAmount().setScale(2, RoundingMode.HALF_UP));
            build.setPurchaseType(order.getPurchaseType());
            build.setProjectAttribute(order.getProjectAttribute());
            build.setSerialNumber(order.getSerialNumber());
            build.setBoolAnnual(order.getBoolAnnual());
            StringBuilder builder = new StringBuilder();
            if (StringUtil.isNotEmpty(order.getProjectIds())) {
               Arrays.stream(org.apache.commons.lang3.StringUtils.split(order.getProjectIds(), ",")).map(Long::parseLong).forEach(item -> {
                  ContractProject project = this.projectService.getById(item);
                  builder.append(project.getShortName()).append(" ");
               });
            }

            build.setProjectName(builder.toString());
            BranchCompany company = this.companyService.getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getId, order.getBranchCompanyId()));
            build.setBranchCompanyName(ObjectUtils.isEmpty(company) ? null : company.getName());
            Supplier supplier = this.supplierService.getById(order.getSupplierId());
            build.setSupplierName(ObjectUtils.isEmpty(supplier) ? null : supplier.getName());
            build.setBusinessType(OaBusinessTypeEnum.CONTRACT.getType());
         }
      } else {
         ContractAuditLedger auditLedger = this.auditLedgerService.getById(dataId);
         Preconditions.checkArgument(auditLedger != null, "审批草稿不存在");
         if (OaBusinessTypeEnum.SETTLE.getType().equals(businessType)) {
            if (ObjectUtils.isNotEmpty(auditLedger.getAttachmentIds())) {
               List<Long> attachmentIds = JSON.parseArray(auditLedger.getAttachmentIds(), Long.class);
               List<Attachment> attachments = this.attachmentService.list(Wrappers.lambdaQuery(Attachment.class).in(Attachment::getId, attachmentIds));
               build.setAttachmentList(attachments);
            }

            PurchaseOrder order = this.orderService.getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getId, auditLedger.getContractId()));
            Preconditions.checkArgument(order != null, "采购订单不存在");
            this.validateSettlementDraftPreview(auditLedger, order);
            if (ObjectUtils.isNotEmpty(order)) {
               build.setProjectAttribute(order.getProjectAttribute());
               build.setPurchaseType(order.getPurchaseType());
               build.setSerialNumber(order.getSerialNumber());
               build.setBoolAnnual(order.getBoolAnnual());
               build.setAmount(order.getAmount().setScale(2, RoundingMode.HALF_UP));
               build.setSettlementAmount(this.settlementService.getAount(Long.parseLong(auditLedger.getPaymentId())).setScale(2, RoundingMode.HALF_UP));
            }

            StringBuilder builder = new StringBuilder();
            if (StringUtil.isNotEmpty(order.getProjectIds())) {
               Arrays.stream(org.apache.commons.lang3.StringUtils.split(order.getProjectIds(), ",")).map(Long::parseLong).forEach(item -> {
                  ContractProject project = this.projectService.getById(item);
                  builder.append(project.getShortName()).append(" ");
               });
            }

            build.setProjectName(builder.toString());
            BranchCompany company = this.companyService.getById(order.getBranchCompanyId());
            build.setBranchCompanyName(ObjectUtils.isEmpty(company) ? null : company.getName());
            Supplier supplier = this.supplierService.getById(order.getSupplierId());
            build.setSupplierName(ObjectUtils.isEmpty(supplier) ? null : supplier.getName());
            build.setBusinessType(OaBusinessTypeEnum.CONTRACT.getType());
         }

         if (OaBusinessTypeEnum.PAYMENT.getType().equals(businessType)) {
            if (ObjectUtils.isNotEmpty(auditLedger.getAttachmentIds())) {
               List<Attachment> attachments = this.attachmentService
                  .list(Wrappers.lambdaQuery(Attachment.class).in(Attachment::getId, auditLedger.getAttachmentIds().toString().split(",")));
               build.setAttachmentList(attachments);
            }

            List<String> orderIds = Arrays.asList(auditLedger.getContractId().split(","));
            List<PurchaseOrder> orders = this.orderService.list(Wrappers.lambdaQuery(PurchaseOrder.class).in(PurchaseOrder::getId, orderIds));
            if (CollectionUtils.isNotEmpty(orders)) {
               build.setProjectAttribute(orders.get(0).getProjectAttribute());
               build.setPurchaseType(orders.get(0).getPurchaseType());
               build.setSerialNumber(orders.stream().map(PurchaseOrder::getSerialNumber).collect(Collectors.joining(",")));
               build.setBoolAnnual(orders.get(0).getBoolAnnual());
               build.setAmount(orders.stream().map(order -> order.getAmount().setScale(2, RoundingMode.HALF_UP)).reduce(BigDecimal.ZERO, BigDecimal::add));
               Supplier supplier = this.supplierService.getById(orders.get(0).getSupplierId());
               build.setSupplierName(ObjectUtils.isEmpty(supplier) ? null : supplier.getName());
               build.setBusinessType(OaBusinessTypeEnum.CONTRACT.getType());
               build.setReceivingUnit(supplier.getName());
               build.setReceiveBank(supplier.getBankName());
               build.setReceiveBankAccount(supplier.getBankAccount());
            }

            List<Long> ids = Arrays.stream(auditLedger.getPaymentId().split(",")).map(Long::parseLong).collect(Collectors.toList());
            List<OaSupplierPaymentDataIdDTO> payments = this.paymentService.getDataIdList(ids);
            List<OaSupplierPaymentDTO> oaSupplierPaymentDTO = new ArrayList<>();
            payments.forEach(
               item -> oaSupplierPaymentDTO.add(OaSupplierPaymentDTO.builder().htbh(item.getSerialNumber()).hkje(item.getPaymentAmount().doubleValue()).build())
            );
            build.setOaSupplierPaymentDTO(oaSupplierPaymentDTO);
            BigDecimal paymentAmount = payments.stream()
               .filter(item -> item.getPaymentAmount() != null)
               .map(OaSupplierPaymentDataIdDTO::getPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            build.setPaymentAmount(paymentAmount);
            List<SupplierPayment> list = this.paymentService.list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getOrderId, orderIds));
            BigDecimal reduce = list.stream()
               .filter(item -> item.getActuallyPaymentAmount() != null)
               .map(SupplierPayment::getActuallyPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            build.setActuallyPaymentAmount(reduce.setScale(2, RoundingMode.HALF_UP));
         }
      }

      return new ResultVO<>(20000L, "成功", build);
   }

   @Override
   public ResultVO<ZhongNanFixedDataDTO> getFixedData() {
      User user = this.userService.getById(UserUtil.getCurrentUserId());
      ZhongNanFixedDataDTO build = ZhongNanFixedDataDTO.builder()
         .userId(user.getOaUserId())
         .userName(UserUtil.getCurrentName())
         .deptId(user.getOaDeptId())
         .deptName(UserUtil.getCurrentDepartment().getName())
         .sudDeptId(user.getOaSubDeptId())
         .sudDeptName(user.getOaSubDeptName())
         .applicationTime(LocalDateTime.now())
         .build();
      return new ResultVO<>(20000L, "成功", build);
   }

   @Transactional
   @Override
   public Boolean deepenDrawingUpload(
      MultipartFile multipartFile,
      OaDeepenDrawingDTOParam oaParam,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer dataType,
      Integer productType,
      Long productId,
      Boolean cover
   ) {
      if (!cover) {
         this.techDrawingService.checkParam(multipartFile, projectId, monomerId, dataType, productType);
      }

      Long dataId = null;
      if (cover) {
         dataId = this.techDrawingService.getDataId(productId, productType, dataType, multipartFile, projectId, monomerId);
      }

      Attachment attachment = this.attachmentService.uploadFile(multipartFile, AttachmentTypeEnum.PLAN.getType());
      OaAttachmentsDTO oaAttachmentsDTO = OaAttachmentsDTO.builder().fileName(attachment.getName()).filePath(attachment.getRelativePath()).build();
      oaParam.setFj(Collections.singletonList(oaAttachmentsDTO));
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(oaParam.getSqr(), oaParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");

      List<OaArgumentDTO> argumentDTOS;
      try {
         argumentDTOS = this.resultData(oaParam);
      } catch (Exception e) {
         throw new BusinessException("构建远程请求参数失败！");
      }

      String data = this.doCreateRequest(oaParam.getRequestName(), zhongNanWorkFlowDTO.getWorkflowId(), oaParam.getSqr(), argumentDTOS, null);
      log.info("图纸审批oa请求响应json:" + data);
      JSONObject jsonObject = JSONObject.parseObject(data);
      if (!"SUCCESS".equals(jsonObject.getString("code"))) {
         throw new BusinessException("OA图纸审批请求失败！");
      }

      String requestId = jsonObject.getJSONObject("data").getString("requestid");
      Long id = monomerId != null ? monomerId : projectId;
      List<String> subjoinMsgList = new ArrayList<>();
      ContractProject project = this.projectService.getById(projectId);
      if (monomerId != null) {
         PlanMonomer planMonomer = this.monomerService.getById(monomerId);
         subjoinMsgList.add(project.getShortName() + "/" + planMonomer.getName());
      } else {
         subjoinMsgList.add(project.getShortName());
      }

      String subjoinMsg = JSONArray.toJSONString(subjoinMsgList);
      WorkflowDTOParam workflowDTOParam = WorkflowDTOParam.builder()
         .requestId(requestId)
         .requestName(oaParam.getRequestName())
         .id(id)
         .businessType(4)
         .applicationId(UserUtil.getCurrentUserId())
         .applicationTime(LocalDateTime.now())
         .build();
      String serialNumber = "";

      List<WmsApproveRecord> wmsApproveRecords;
      do {
         serialNumber = this.recordService.createApproveSerialNumber("wms_approve_flow_operation");
         wmsApproveRecords = this.recordService.list((Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getSerialNumber, serialNumber));
      } while (!CollectionUtils.isEmpty(wmsApproveRecords));

      WmsApproveRecord record = WmsApproveRecord.builder()
         .moduleType(ModuleTypeEnum.PLAN_MODULE.getType())
         .dataId(workflowDTOParam.getId())
         .serialNumber(serialNumber)
         .startTime(workflowDTOParam.getApplicationTime())
         .applicantId(workflowDTOParam.getApplicationId())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .lastApproverId(workflowDTOParam.getApplicationId())
         .lastApprovalTime(workflowDTOParam.getApplicationTime())
         .requestId(workflowDTOParam.getRequestId())
         .dataSerialNumber(workflowDTOParam.getRequestId())
         .subjoinMsg(subjoinMsg)
         .approveSource(ApproveSourceEnum.OA.getType())
         .build();
      WmsApproveRecordDetail recordDetail = WmsApproveRecordDetail.builder()
         .dataId(workflowDTOParam.getId())
         .moduleType(ModuleTypeEnum.PLAN_MODULE.getType())
         .approveRecordSerialNumber(serialNumber)
         .flowType(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())
         .checkUserId(workflowDTOParam.getApplicationId())
         .requestId(workflowDTOParam.getRequestId())
         .arrivalTime(workflowDTOParam.getApplicationTime())
         .approveTime(workflowDTOParam.getApplicationTime())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .approveSource(ApproveSourceEnum.OA.getType())
         .decision(CheckStatusEnum.PASS.getType())
         .build();
      record.setFunctionType(ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType());
      record.setApproveProcessType(ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType());
      String componentName = ComponentNameUtils.getComponentName(ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType(), null);
      record.setComponentName(componentName);
      recordDetail.setFunctionType(ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType());
      recordDetail.setApproveProcessType(ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType());
      this.recordService.save(record);
      this.recordDetailService.save(recordDetail);
      PlanTechnologicalAchievementApproveRecord achievementApproveRecord = PlanTechnologicalAchievementApproveRecord.builder()
         .approveRecordId(record.getId())
         .moduleType(dataType)
         .projectId(projectId)
         .dataId(id)
         .deleId(dataId)
         .approveStatus(ReviewStatusEnum.AUDITING.getType())
         .applicantId(UserUtil.getCurrentUser().getId())
         .attachmentIds(attachment.getId().toString())
         .fileNames(attachment.getName())
         .monomerId(monomerId)
         .productType(productType)
         .build();
      this.approveRecordService.save(achievementApproveRecord);
      String key = "plan:" + record.getId() + ":" + id;
      PlanApproveCacheDTOParam planApproveCacheDTOParam = PlanApproveCacheDTOParam.builder()
         .fileName(multipartFile.getOriginalFilename())
         .contentType(multipartFile.getContentType())
         .projectld(projectId)
         .monomerld(monomerId)
         .areaId(areaId)
         .dataType(dataType)
         .productType(productType)
         .cacheObjectDTOParam(
            PlanApproveCacheObjectDTOParam.builder()
               .productId(productId)
               .createUserId(UserUtil.getCurrentUser().getId())
               .normal(false)
               .cover(Boolean.TRUE.equals(cover) ? PlanFileOverlayEnum.DRAWING_NUMERICAL_CONTROL_XML.getType() : null)
               .build()
         )
         .build();
      this.redisUtils.set(key, JSON.toJSONString(planApproveCacheDTOParam));
      return true;
   }

   @Override
   public String doCreateRequest(String requestName, String workflowId, String userid, List<OaArgumentDTO> objs, List<OaDetailDTO> OaDetailDTOs) {
      Map<String, Object> paramsMap = new HashMap<>();
      paramsMap.put("detailData", JSON.toJSONString(OaDetailDTOs));
      paramsMap.put("mainData", JSON.toJSONString(objs));
      paramsMap.put("requestName", requestName);
      paramsMap.put("workflowId", workflowId);
      String urlEncodedForm = this.generateUrlEncodedForm(paramsMap);
      log.info("最后入参" + urlEncodedForm);
      return doPostWithParamHeaderTimeOut(
         this.oaProperties.getHost() + "/api/workflow/paService/doCreateRequest",
         null,
         this.getHeaderMap(userid),
         urlEncodedForm,
         "application/x-www-form-urlencoded"
      );
   }

   @Override
   public ZhongNanWorkFlowDTO checkPermission(String userId, String workflowName) {
      List<ZhongNanWorkFlowDTO> zhongNanWorkFlowDTOS = JSONArray.parseArray(new String(this.getCreateWorkflowList(userId)), ZhongNanWorkFlowDTO.class)
         .stream()
         .filter(item -> item.getWorkflowName().equals(workflowName))
         .collect(Collectors.toList());
      log.info(zhongNanWorkFlowDTOS.toString());
      return CollectionUtils.isEmpty(zhongNanWorkFlowDTOS) ? new ZhongNanWorkFlowDTO() : zhongNanWorkFlowDTOS.get(0);
   }

   @Override
   public String getCreateWorkflowList(String userId) {
      String doPostWithParamHeader = HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/workflow/paService/getCreateWorkflowList", null, this.getHeaderMap(userId), null, "application/json"
      );
      log.info("当前用户可操作流程列表" + doPostWithParamHeader);
      return doPostWithParamHeader;
   }

   private Map getHeaderMap(String userId) {
      Map<String, String> HeaderMap = new HashMap<>();
      HeaderMap.put("appid", this.oaProperties.getAppId());
      HeaderMap.put("secret", this.encrypt(this.oaProperties.getSecret()));
      HeaderMap.put("token", this.getToken());
      HeaderMap.put("userid", this.encrypt(userId));
      return HeaderMap;
   }

   public String getToken() {
      Map<String, String> map = new HashMap<>();
      String encrypt = this.encrypt(this.oaProperties.getSecret());
      map.put("appid", this.oaProperties.getAppId());
      map.put("secret", encrypt);
      String tokenJson = HttpUrlUtils.doPostWithParamHeader(this.oaProperties.getHost() + "/api/ec/dev/auth/applytoken", null, map, null, "application/json");
      JSONObject tokenJsonObject = JSON.parseObject(tokenJson);
      log.info("当前状态码： " + tokenJsonObject.getString("code"));
      if (0 == tokenJsonObject.getInteger("code")) {
         log.info("获取成功");
         return tokenJsonObject.getString("token");
      } else {
         return tokenJson;
      }
   }

   public String generateUrlEncodedForm(Map<String, Object> paramsMap) {
      return paramsMap.entrySet()
         .stream()
         .map(entry -> this.urlEncode(entry.getKey()) + "=" + this.urlEncode(entry.getValue()))
         .collect(Collectors.joining("&"));
   }

   private String urlEncode(Object value) {
      try {
         return URLEncoder.encode(value == null ? "" : String.valueOf(value), StandardCharsets.UTF_8.name());
      } catch (UnsupportedEncodingException e) {
         throw new IllegalStateException("当前运行环境不支持UTF-8编码", e);
      }
   }

   private String normalizeWorkflowName(String workflowName) {
      return workflowName == null ? null : workflowName.trim().replaceFirst("\\s*[\\uFF08(]\\u6d41\\u7a0bID.*$", "").trim();
   }

   public List<OaDetailDTO> resultDetailData(List<OaSupplierPaymentDTO> objs) {
      List<OaDetailDTO> oaDetailDTOs = new ArrayList<>();
      List<WorkflowRequestTableRecord> workflowRequestTableRecords = new ArrayList<>();
      OaDetailDTO oaDetailDTO = new OaDetailDTO();
      oaDetailDTO.setTableDBName("formtable_main_2392_dt1");
      oaDetailDTO.setWorkflowRequestTableRecords(workflowRequestTableRecords);
      objs.forEach(obj -> {
         Map<String, Object> objMap = new HashMap<>();

         try {
            objMap = this.objectToMap(obj);
         } catch (IllegalAccessException e) {
            e.printStackTrace();
         }

         WorkflowRequestTableRecord workflowRequestTableField = new WorkflowRequestTableRecord();
         List<WorkflowRequestTableField> workflowRequestTableFields = new ArrayList<>();

         for (Entry<String, Object> entry : objMap.entrySet()) {
            WorkflowRequestTableField tableField = new WorkflowRequestTableField();
            tableField.setFieldName(entry.getKey());
            tableField.setFieldValue(entry.getValue());
            workflowRequestTableFields.add(tableField);
         }

         workflowRequestTableField.setWorkflowRequestTableFields(workflowRequestTableFields);
         workflowRequestTableRecords.add(workflowRequestTableField);
      });
      oaDetailDTOs.add(oaDetailDTO);
      log.info("resultDetailData:" + JSON.toJSONString(oaDetailDTOs));
      return oaDetailDTOs;
   }

   @Override
   public List<OaArgumentDTO> resultData(Object object) throws IllegalAccessException {
      List<OaArgumentDTO> argumentDTOS = new ArrayList<>();
      Map<String, Object> obj = this.objectToMap(object);

      for (Entry<String, Object> entry : obj.entrySet()) {
         if (!entry.getKey().equals("requestName")
            && !entry.getKey().equals("purchaseContractNumber")
            && !entry.getKey().equals("title")
            && !entry.getKey().equals("oaSupplierPaymentDTO")
            && ObjectUtils.isNotEmpty(entry.getValue())) {
            OaArgumentDTO oaArgumentDTO = new OaArgumentDTO();
            if (!entry.getKey().equals("htfj")
               && !entry.getKey().equals("xgfj")
               && !entry.getKey().equals("fj")
               && !entry.getKey().equals("gjzm")
               && !entry.getKey().equals("zgystzwj")) {
               oaArgumentDTO.setFieldName(entry.getKey());
               oaArgumentDTO.setFieldValue(entry.getValue());
            } else {
               List<OaAttachmentsDTO> resultData = (List<OaAttachmentsDTO>)entry.getValue();
               List<OaAttachmentsDTO> attachmentsDTOS = new ArrayList<>();
               resultData.forEach(item -> {
                  OaAttachmentsDTO attachmentsDTO = new OaAttachmentsDTO();
                  attachmentsDTO.setFileName(item.getFileName());
                  attachmentsDTO.setFilePath(this.configProperties.getUrl() + "files/" + item.getFilePath());
                  attachmentsDTOS.add(attachmentsDTO);
               });
               oaArgumentDTO.setFieldName(entry.getKey());
               oaArgumentDTO.setFieldValue(attachmentsDTOS);
            }

            argumentDTOS.add(oaArgumentDTO);
         }
      }

      log.info("最后入参数据------>resultData:" + JSON.toJSONString(argumentDTOS));
      return argumentDTOS;
   }

   private void chenkData(ContractAuditLedger ledger, Integer auditStatus, OaWorkflowDTOParam workflowDTOParam, User user) {
      List<String> paymentIds = Arrays.stream(ledger.getPaymentId().split(",")).collect(Collectors.toList());
      String lastOperatorId = workflowDTOParam.getLastOperatorId();
      if (Objects.equals(auditStatus, AuditStatusEnum.SUCCEED.getType())) {
         List<SupplierPayment> newSupplierPayment = new ArrayList<>();
         Map<String, BigDecimal> map = workflowDTOParam.getActuallyPaymentDetails()
            .stream()
            .collect(Collectors.toMap(OaPaymentDetailDTO::getSerialNumber, OaPaymentDetailDTO::getPaymentAmount));
         List<SupplierPayment> supplierPayments = this.paymentService.list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getId, paymentIds));
         supplierPayments.forEach(supplierPaymentx -> {
            Preconditions.checkArgument(map.containsKey(supplierPaymentx.getSerialNumber()), "缺少付款记录!");
            Preconditions.checkArgument(map.get(supplierPaymentx.getSerialNumber()) != null, "付款金额不能为空!");
            Preconditions.checkArgument(map.get(supplierPaymentx.getSerialNumber()).compareTo(supplierPaymentx.getApplyAmount()) <= 0, "实付金额不能大于申请金额!");
            supplierPaymentx.setPaymentDate(LocalDate.now());
            supplierPaymentx.setActuallyPaymentAmount(map.get(supplierPaymentx.getSerialNumber()));
            supplierPaymentx.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
            supplierPaymentx.setAuditUserId(user.getId());
            supplierPaymentx.setAuditUserName(user.getName());
            supplierPaymentx.setAuditTime(LocalDateTime.now());
            newSupplierPayment.add(supplierPaymentx);
         });
         this.paymentService.updateBatchById(newSupplierPayment);
      } else {
         for (String item : paymentIds) {
            SupplierPayment supplierPayment = this.paymentService.getById(item);
            supplierPayment.setAuditStatus(auditStatus);
            supplierPayment.setAuditUserId(Long.valueOf(lastOperatorId));
            supplierPayment.setAuditTime(LocalDateTime.now());
            this.paymentService.updateById(supplierPayment);
         }
      }
   }

   private String encrypt(String data) {
      RSA rsa = new RSA();
      return rsa.encrypt(null, data, null, "utf-8", this.oaProperties.getSpk(), false);
   }

   public Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
      Map<String, Object> map = new HashMap<>();
      Class<?> clazz = obj.getClass();

      for (Field field : clazz.getDeclaredFields()) {
         field.setAccessible(true);
         map.put(field.getName(), field.get(obj));
      }

      return map;
   }

   public static String doPostWithParamHeaderTimeOut(String NCUrl, Map<String, String> paramMap, Map<String, String> headerMap, String info, String mediaType) {
      OutputStreamWriter out = null;
      HttpURLConnection conn = null;
      BufferedReader in = null;
      StringBuilder params = new StringBuilder();
      if (paramMap != null && !paramMap.isEmpty()) {
         for (Entry<String, String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String s = key + "=" + value + "&";
            params.append(s);
         }
      }

      try {
         Map<String, String> header = new HashMap<>();
         header.put("accept", "*/*");
         header.put("connection", "Keep-Alive");
         header.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
         header.put("Content-Type", mediaType);
         if (headerMap != null && !headerMap.isEmpty()) {
            for (Entry<String, String> entry : headerMap.entrySet()) {
               header.put(entry.getKey(), entry.getValue());
            }
         }

         StringBuilder result = new StringBuilder();
         URL url = new URL(NCUrl);
         conn = (HttpURLConnection)url.openConnection();
         conn.setDoOutput(true);
         conn.setDoInput(true);
         conn.setRequestMethod("POST");
         conn.setUseCaches(false);
         conn.setRequestProperty("Charset", "UTF-8");
         conn.setConnectTimeout(180000);
         conn.setReadTimeout(180000);

         for (String key : header.keySet()) {
            conn.setRequestProperty(key, header.get(key));
         }

         out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
         if (paramMap != null) {
            for (Entry<String, String> entry : paramMap.entrySet()) {
               header.put(entry.getKey(), entry.getValue());
            }
         }

         if (org.apache.commons.lang3.StringUtils.isNotBlank(params)) {
            out.write(params.toString());
         }

         if (org.apache.commons.lang3.StringUtils.isNotBlank(info)) {
            out.write(info);
         }

         out.flush();
         int code = conn.getResponseCode();
         if (code == 200) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }

         String line;
         while ((line = in.readLine()) != null) {
            result.append(line);
         }

         return result.toString();
      } catch (Exception e) {
         e.printStackTrace();
         throw new BusinessException(e.getMessage());
      } finally {
         try {
            if (conn != null) {
               conn.disconnect();
            }

            if (out != null) {
               out.close();
            }

            if (in != null) {
               in.close();
            }
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
   }
}
