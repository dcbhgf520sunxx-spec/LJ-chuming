package com.hzchum.scim.rest.controller.zhongnanoa;

import cn.hutool.http.HttpRequest;
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
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.HttpUrlUtils;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.biz.sync.SyncAppBiz;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveSourceEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
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
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPaymentDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchasePaymentDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseSettleAccountDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaSupplierPaymentDataIdDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.WorkflowDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.biz.impl.ContractSupplierPaymentBizImpl;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "远程调用")
@RestController
@RequestMapping("/api/oa/flow/test")
public class TestBusinessProcessDemo {
   private static final Logger log = LoggerFactory.getLogger(TestBusinessProcessDemo.class);
   private static final String AUTHORIZATION = System.getenv("LJAPS_OA_DEMO_AUTHORIZATION");
   private static String PATH = "files" + File.separator;
   @Resource
   private PurchaseOrderService orderService;
   @Autowired
   private ContractSupplierPaymentBizImpl contractSupplierPaymentBiz;
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
   private SyncAppBiz syncAppBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;

   @ApiOperation("校验用户权限")
   @GetMapping("/doCheckPermission")
   public ResultVO doCheckPermission(@RequestParam("sqr") String sqr, @RequestParam("requestName") String requestName) {
      ZhongNanWorkFlowDTO zhongNanWorkFlowDTO = this.checkPermission(sqr, requestName);
      Preconditions.checkArgument(StringUtils.isNotBlank(zhongNanWorkFlowDTO.getWorkflowId()), "该用户没有提交审批流程权限!");
      return ResultBuilder.success("响应成功");
   }

   @ApiOperation("采购合同创建审批(制成品)")
   @PostMapping("/doCreatePurchaseContract/manufacturedGoods")
   public ResultVO doCreatePurchaseContractManufacturedGoods(@RequestBody OaPurchaseContractDTOParam purchaseContractDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, String> map1 = new HashMap<>();
      map1.put(
         "Authorization",
         System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
      );
      String data = HttpUrlUtils.doPostWithParamHeader(
         "http://123.157.218.70:6006/api/oa/flow/doCreatePurchaseContract/manufacturedGoods",
         null,
         map1,
         JSON.toJSONString(purchaseContractDTOParam),
         "application/json"
      );
      JSONObject jsonObject = JSONObject.parseObject(new String(data));
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @ApiOperation("采购合同创建审批(原材料)")
   @PostMapping("/doCreateAnnualContract/rawMaterial")
   public ResultVO doCreateAnnualContractRawMaterial(@RequestBody OaAnnualContractDTOParam annualContractDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, String> map1 = new HashMap<>();
      map1.put(
         "Authorization",
         System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
      );
      String data = HttpUrlUtils.doPostWithParamHeader(
         "http://123.157.218.70:6006/api/oa/flow/doCreateAnnualContract/rawMaterial", null, map1, JSON.toJSONString(annualContractDTOParam), "application/json"
      );
      JSONObject jsonObject = JSONObject.parseObject(new String(data));
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @ApiOperation("供应商年度合同创建审批")
   @PostMapping("/doCreateAnnualContract")
   public ResultVO doCreateAnnualContract(@RequestBody OaAnnualContractDTOParam annualContractDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, String> map1 = new HashMap<>();
      map1.put(
         "Authorization",
         System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
      );
      String data = HttpUrlUtils.doPostWithParamHeader(
         "http://123.157.218.70:6006/api/oa/flow/doCreateAnnualContract", null, map1, JSON.toJSONString(annualContractDTOParam), "application/json"
      );
      JSONObject jsonObject = JSONObject.parseObject(new String(data));
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @ApiOperation("采购合同付款申请审批")
   @PostMapping("/doCreatePurchasePayment")
   public ResultVO doCreatePurchasePayment(@RequestBody OaPurchasePaymentDTOParam purchasePaymentDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, String> map1 = new HashMap<>();
      map1.put(
         "Authorization",
         System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
      );
      String data = HttpUrlUtils.doPostWithParamHeader(
         "http://123.157.218.70:6006/api/oa/flow/doCreatePurchasePayment", null, map1, JSON.toJSONString(purchasePaymentDTOParam), "application/json"
      );
      JSONObject jsonObject = JSONObject.parseObject(new String(data));
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @ApiOperation("采购合同结算审批(原材料)")
   @PostMapping("/doCreatePurchaseSettleAccounts/rawMaterial")
   public ResultVO doCreatePurchaseSettleAccountsRawMaterial(@RequestBody OaPurchaseSettleAccountDTOParam purchaseSettleAccountDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, String> map1 = new HashMap<>();
      map1.put(
         "Authorization",
         System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
      );
      String data = HttpUrlUtils.doPostWithParamHeader(
         "http://123.157.218.70:6006/api/oa/flow/doCreatePurchaseSettleAccounts/rawMaterial",
         null,
         map1,
         JSON.toJSONString(purchaseSettleAccountDTOParam),
         "application/json"
      );
      JSONObject jsonObject = JSONObject.parseObject(new String(data));
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @ApiOperation("采购合同结算审批(制成品)")
   @PostMapping("/doCreatePurchaseSettleAccounts/manufacturedGoods")
   public ResultVO doCreatePurchaseSettleAccountsManufacturedGoods(@RequestBody OaPurchaseContractDTOParam purchaseContractDTOParam) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Map<String, String> map1 = new HashMap<>();
      map1.put(
         "Authorization",
         System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
      );
      String data = HttpUrlUtils.doPostWithParamHeader(
         "http://123.157.218.70:6006/api/oa/flow/doCreatePurchaseSettleAccounts/manufacturedGoods",
         null,
         map1,
         JSON.toJSONString(purchaseContractDTOParam),
         "application/json"
      );
      JSONObject jsonObject = JSONObject.parseObject(new String(data));
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   @ApiOperation("OA审批流程生成后，根据数据id更新RequestId")
   @PutMapping("/updateRequestId")
   public ResultVO updateOaRequestId(@RequestBody WorkflowDTOParam workflowDTOParam) {
      String serialNumber = "";

      List<WmsApproveRecord> wmsApproveRecords;
      do {
         serialNumber = this.createApproveSerialNumber("wms_approve_flow_operation");
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
            Integer num = ApproveProcessTypeEnumV2.INNER_PACKAGE_SETTLEMENT_AUDIT.getType();
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

   @ApiOperation("OA同步审批流程状态")
   @PostMapping("/syncApprovalFlowStatus")
   public ResultVO approvalFlowStatus(OaWorkflowDTOParam workflowDTOParam) {
      Preconditions.checkArgument(
         workflowDTOParam.getApproveStatus().equals(OAResultWorkFlowStatusEnum.PASS.getType())
            || workflowDTOParam.getApproveStatus().equals(OAResultWorkFlowStatusEnum.REJECT.getType()),
         "PRARM_APPROVE_STATUS IS ERROR"
      );
      Preconditions.checkArgument(StringUtil.isNotEmpty(workflowDTOParam.getRequestmark()), "PRARM_REQUEST_MARK IS NOT ERROR");
      Preconditions.checkArgument(StringUtil.isNotEmpty(workflowDTOParam.getRequestId()), "PRARM_REQUEST_ID IS NOT NULL");
      Preconditions.checkArgument(OaWorkflowNameEnum.isExist(workflowDTOParam.getWorkflowName()), "PRARM_WORK_FLOW_NAME IS ERROR");
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(workflowDTOParam.getActuallyPaymentDetails()), "PRARM_ACTUALLY_PAYMENT_DETAILS IS NOT NULL");
      Preconditions.checkArgument(!workflowDTOParam.getActuallySettlementAmount().equals("0"), "实结算金额不能为0");
      User user = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getOaUserId, workflowDTOParam.getLastOperatorId()));
      WmsApproveRecord record = this.recordService
         .getOne(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getRequestId, workflowDTOParam.getRequestId()));
      record.setDataSerialNumber(workflowDTOParam.getRequestId());
      record.setReviewStatus(
         OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
            ? ReviewStatusEnum.REVIEWED.getType()
            : ReviewStatusEnum.RETURNED.getType()
      );
      record.setStatus(ApproveRecordStatusEnum.END.getType());
      record.setEndTime(LocalDateTime.now());
      record.setLastApprovalTime(LocalDateTime.now());
      record.setLastApproverId(user.getId());
      List<WmsApproveRecordDetail> resourceRecordDetails = this.recordDetailService
         .list(Wrappers.lambdaQuery(WmsApproveRecordDetail.class).eq(WmsApproveRecordDetail::getRequestId, workflowDTOParam.getRequestId()));
      WmsApproveRecordDetail targetRecordDetail = WmsApproveRecordDetail.builder().build();
      BeanUtil.copy(resourceRecordDetails.get(0), targetRecordDetail);
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
      record.setStatus(ApproveRecordStatusEnum.END.getType());
      targetRecordDetail.setStatus(ApproveRecordStatusEnum.END.getType());
      Integer status = OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus())
         ? AuditStatusEnum.SUCCEED.getType()
         : AuditStatusEnum.FAILED.getType();
      if (OaWorkflowNameEnum.PROCESS_PAYMENT.getName().equals(workflowDTOParam.getWorkflowName())) {
         PurchaseOrder order = this.orderService
            .getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getRequestId, workflowDTOParam.getRequestId()));
         BigDecimal amount = new BigDecimal(workflowDTOParam.getActuallySettlementAmount());
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
               OAResultWorkFlowStatusEnum.PASS.getType().equals(workflowDTOParam.getApproveStatus()) ? PurchaseStatusEnum.DURING.getType() : null
            );
            this.orderService.updateById(order);
         }
      }

      if (OaWorkflowNameEnum.CONTRACT_SETTLE.getName().equals(workflowDTOParam.getWorkflowName())) {
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
         this.orderService.updateById(order);
      }

      if (OaWorkflowNameEnum.CONTRACT_PAYMENT.getName().equals(workflowDTOParam.getWorkflowName())
         || OaWorkflowNameEnum.CONTRACT_APPROVE.getName().equals(workflowDTOParam.getWorkflowName())) {
         ContractAuditLedger ledger = this.auditLedgerService
            .getOne(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getRequestId, workflowDTOParam.getRequestId()));
         ledger.setOaNumber(workflowDTOParam.getRequestmark());
         ledger.setAuditStatusEnum(status);
         ledger.setSubmitDate(LocalDateTime.now());
         if (OaWorkflowNameEnum.CONTRACT_PAYMENT.getName().equals(workflowDTOParam.getWorkflowName())) {
            BigDecimal actuallyPaymentAmount = workflowDTOParam.getActuallyPaymentDetails()
               .stream()
               .map(OaPaymentDetailDTO::getPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            ledger.setActuallyPayAmount(AuditStatusEnum.SUCCEED.getType().equals(status) ? actuallyPaymentAmount : new BigDecimal(0));
            this.chenkData(ledger, status, workflowDTOParam);
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

      this.recordService.updateById(record);
      this.recordDetailService.save(targetRecordDetail);
      return ResultBuilder.success("响应成功");
   }

   @ApiOperation("根据dataId获取固定数据")
   @GetMapping("/getFixedData")
   @Transactional(rollbackFor = TransactionException.class)
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
         if (ObjectUtils.isNotEmpty(auditLedger.getAttachmentIds())) {
            List<Attachment> attachments = this.attachmentService
               .list(Wrappers.lambdaQuery(Attachment.class).in(Attachment::getId, auditLedger.getAttachmentIds().toString().split(",")));
            build.setAttachmentList(attachments);
         }

         if (OaBusinessTypeEnum.SETTLE.getType().equals(businessType)) {
            PurchaseOrder order = this.orderService.getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getId, auditLedger.getContractId()));
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

   public ZhongNanWorkFlowDTO checkPermission(String userId, String workflowName) {
      List<ZhongNanWorkFlowDTO> zhongNanWorkFlowDTOS = JSONArray.parseArray(new String(this.getCreateWorkflowList(userId)), ZhongNanWorkFlowDTO.class)
         .stream()
         .filter(item -> item.getWorkflowName().equals(workflowName))
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(zhongNanWorkFlowDTOS) ? new ZhongNanWorkFlowDTO() : zhongNanWorkFlowDTOS.get(0);
   }

   public String getCreateWorkflowList(String userId) {
      HttpRequest request = HttpRequest.get(String.format("http://123.157.218.70:6006/api/oa/flow/getCreateWorkflowList?userId=%s", userId))
         .header(
            "Authorization",
            System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
         );
      return request.execute().body();
   }

   private String createApproveSerialNumber(String tableNameKey) {
      String yyyy_mm_dd = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
      String key = MessageFormat.format("{0}:{1}", tableNameKey, yyyy_mm_dd);
      Long increment = this.redisTemplate.opsForValue().increment(key, 1L);
      if (increment.equals(1L)) {
         this.redisTemplate.expire(key, 24L, TimeUnit.HOURS);
      }

      String datetime = new SimpleDateFormat("yyyyMMdd").format(new Date());
      String value = org.apache.commons.lang.StringUtils.leftPad(String.valueOf(increment), 6, "0");
      return MessageFormat.format("{0}{1}", datetime, value);
   }

   private void chenkData(ContractAuditLedger ledger, Integer auditStatus, OaWorkflowDTOParam workflowDTOParam) {
      List<String> paymentIds = Arrays.stream(ledger.getPaymentId().split(",")).collect(Collectors.toList());
      String lastOperatorId = workflowDTOParam.getLastOperatorId();
      if (auditStatus == AuditStatusEnum.SUCCEED.getType()) {
         List<SupplierPayment> newSupplierPayment = new ArrayList<>();
         BigDecimal actuallyPaymentAmount = BigDecimal.valueOf(Double.parseDouble(workflowDTOParam.getActuallySettlementAmount()));
         BigDecimal applyAmountNum = this.paymentService
            .list(Wrappers.lambdaQuery(SupplierPayment.class).in(SupplierPayment::getId, paymentIds))
            .stream()
            .map(SupplierPayment::getApplyAmount)
            .filter(applyAmount -> applyAmount != null)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(actuallyPaymentAmount.compareTo(applyAmountNum) <= 0, "实付金额不能大于申请金额!");
         if (paymentIds.size() == 1) {
            SupplierPayment supplierPayment = this.paymentService.getById(paymentIds.get(0));
            supplierPayment.setActuallyPaymentAmount(new BigDecimal(workflowDTOParam.getActuallySettlementAmount()));
            supplierPayment.setPaymentDate(LocalDate.now());
            supplierPayment.setAuditUserId(Long.valueOf(lastOperatorId));
            supplierPayment.setAuditTime(LocalDateTime.now());
            supplierPayment.setAuditStatus(auditStatus);
            this.paymentService.updateById(supplierPayment);
         } else {
            for (String item : paymentIds) {
               SupplierPayment supplierPayment = this.paymentService.getById(item);
               if (actuallyPaymentAmount.subtract(supplierPayment.getPaymentAmount()).compareTo(BigDecimal.ZERO) > 0) {
                  supplierPayment.setActuallyPaymentAmount(supplierPayment.getPaymentAmount());
                  actuallyPaymentAmount = actuallyPaymentAmount.subtract(supplierPayment.getPaymentAmount());
               } else {
                  supplierPayment.setActuallyPaymentAmount(BigDecimal.ZERO);
               }

               supplierPayment.setPaymentDate(LocalDate.now());
               supplierPayment.setAuditUserId(Long.valueOf(lastOperatorId));
               supplierPayment.setAuditTime(LocalDateTime.now());
               supplierPayment.setAuditStatus(auditStatus);
               newSupplierPayment.add(supplierPayment);
            }

            this.paymentService.updateBatchById(newSupplierPayment);
         }
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
}
