package com.hzchum.scim.rest.controller.zhongnanoa;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.biz.sync.SyncAppBiz;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanFixedDataDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAnnualContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaDeepenDrawingDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseContractDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchasePaymentDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaPurchaseSettleAccountDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.WorkflowDTOParam;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "oa业务流程")
@RestController
@RequestMapping("/api/oa/flow")
public class OaBusinessProcessApi {
   private static final Logger log = LoggerFactory.getLogger(OaBusinessProcessApi.class);
   @Resource
   private OaBusinessProcessService processService;
   @Resource
   private SyncAppBiz syncAppBiz;

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
      log.info("采购合同创建审批（制成品）");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      String data = this.processService.doCreatePurchaseContractManufacturedGoods(purchaseContractDTOParam);
      JSONObject jsonObject = JSONObject.parseObject(data);
      log.info("采购合同创建审批(制成品)--->" + data);
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
      log.info("采购合同创建审批（原材料）");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      String data = this.processService.doCreateAnnualContractRawMaterial(annualContractDTOParam);
      log.info("采购合同创建审批（原材料）中南OA回传数据----->" + data);
      JSONObject jsonObject = JSONObject.parseObject(data);
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
      log.info("供应商年度合同创建审批");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      String data = this.processService.doCreateAnnualContract(annualContractDTOParam);
      JSONObject jsonObject = JSONObject.parseObject(data);
      log.info("供应商年度合同创建审批--->" + data);
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
      log.info("采购合同付款申请审批");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      String data = this.processService.doCreatePurchasePayment(purchasePaymentDTOParam);
      JSONObject jsonObject = JSONObject.parseObject(data);
      log.info("采购合同付款申请审批请求返回数据--->" + data);
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
      log.info("采购合同结算审批(原材料)");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      String data = this.processService.doCreatePurchaseSettleAccountsRawMaterial(purchaseSettleAccountDTOParam);
      JSONObject jsonObject = JSONObject.parseObject(data);
      log.info("采购合同结算审批(原材料)--->" + data);
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
      log.info("采购合同结算审批(制成品)");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      String data = this.processService.doCreatePurchaseSettleAccountsManufacturedGoods(purchaseContractDTOParam);
      JSONObject jsonObject = JSONObject.parseObject(data);
      log.info("采购合同结算审批(制成品)--->" + data);
      if (jsonObject.getString("code").equals("SUCCESS")) {
         build.setCode(20000L);
         build.setMessage("成功");
      } else {
         build.setMessage(jsonObject.getString("errMsg"));
      }

      build.setData(jsonObject.getString("data"));
      return build;
   }

   public ZhongNanWorkFlowDTO checkPermission(String userId, String workflowName) {
      List<ZhongNanWorkFlowDTO> zhongNanWorkFlowDTOS = JSONArray.parseArray(new String(this.getCreateWorkflowList(userId)), ZhongNanWorkFlowDTO.class)
         .stream()
         .filter(item -> item.getWorkflowName().equals(workflowName))
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(zhongNanWorkFlowDTOS) ? new ZhongNanWorkFlowDTO() : zhongNanWorkFlowDTOS.get(0);
   }

   @ApiOperation("获取人员可以创建的流程列表")
   @GetMapping("/getCreateWorkflowList")
   public String getCreateWorkflowList(@RequestParam("userId") String userId) {
      log.info("接收参数userId：" + userId);
      return this.processService.getCreateWorkflowList(userId);
   }

   @ApiOperation("OA审批流程撤回")
   @PostMapping("/withdrawRequest")
   public ResultVO withdrawRequest(OaRevocationDTOParam oaRevocationDTOParam) {
      log.info("OA审批流程撤回RequestId：" + oaRevocationDTOParam.getRequestId());
      return this.processService.withdrawRequest(oaRevocationDTOParam);
   }

   @ApiOperation("OA审批流程生成后，根据数据id更新RequestId")
   @PutMapping("/updateRequestId")
   public ResultVO updateOaRequestId(@RequestBody WorkflowDTOParam workflowDTOParam) {
      log.info("OA审批流程生成后，根据数据id更新RequestId：workflowDTOParam" + workflowDTOParam.toString());
      return this.processService.updateOaRequestId(workflowDTOParam);
   }

   @ApiOperation("OA同步审批流程状态")
   @PostMapping("/syncApprovalFlowStatus")
   public ResultVO approvalFlowStatus(@RequestBody OaWorkflowDTOParam workflowDTOParam, @RequestHeader("oaToken") String oaToken) {
      log.info("OA同步审批流程状态" + workflowDTOParam.toString());
      this.syncAppBiz.checkToken(oaToken);
      return this.processService.approvalFlowStatus(workflowDTOParam);
   }

   @ApiOperation("根据dataId获取固定数据")
   @GetMapping("/getFixedData")
   public ResultVO<ZhongNanFixedDataDTO> getFixedData(@RequestParam("dataId") Long dataId, @RequestParam("businessType") Integer businessType) {
      log.info("根据dataId获取固定数据:dataId" + dataId + "businessType:" + businessType);
      return this.processService.getFixedData(dataId, businessType);
   }

   @ApiOperation("获取固定数据")
   @GetMapping("/deepenDrawing/getFixedData")
   public ResultVO<ZhongNanFixedDataDTO> getFixedData() {
      return this.processService.getFixedData();
   }

   @ApiOperation("深化图纸创建审批")
   @PostMapping("/deepenDrawing")
   public ResultVO deepenDrawingUpload(
      @RequestPart MultipartFile multipartFile,
      OaDeepenDrawingDTOParam oaParam,
      Long projectId,
      Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long productId,
      Integer dataType,
      Integer productType,
      Boolean cover
   ) {
      log.info("深化图纸创建审批");
      return ResultBuilder.success(
         this.processService.deepenDrawingUpload(multipartFile, oaParam, projectId, monomerId, areaId, dataType, productType, productId, cover)
      );
   }
}
