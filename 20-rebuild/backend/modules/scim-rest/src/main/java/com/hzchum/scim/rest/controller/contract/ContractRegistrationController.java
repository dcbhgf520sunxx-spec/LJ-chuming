package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractRegistrationQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractRegistrationDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同登记")
@RestController
@RequestMapping("/api/contract/registration")
public class ContractRegistrationController {
   private static final Logger log = LoggerFactory.getLogger(ContractRegistrationController.class);
   @Resource
   private ContractRegistrationService contractRegistrationService;

   @ApiOperation("获取合同评审登记列表")
   @GetMapping("/listJudge")
   @PreAuthorize("@permission.check('catalog_review_register:get')")
   public ResultVO listJudge(
      ContractRegistrationQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:获取合同评审登记列表");
      param.setRegistrationType(1);
      return ResultBuilder.success(this.contractRegistrationService.getList(param, pageNumber, pageSize));
   }

   @ApiOperation("获取合同直接登记列表")
   @GetMapping("/listDirect")
   @PreAuthorize("@permission.check('catalog_direct_register:get')")
   public ResultVO listDirect(
      ContractRegistrationQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:获取合同直接登记列表");
      param.setRegistrationType(2);
      return ResultBuilder.success(this.contractRegistrationService.getList(param, pageNumber, pageSize));
   }

   @ApiOperation("新增合同评审登记申请")
   @PostMapping("/saveJudge")
   @PreAuthorize("@permission.check('catalog_review_register:add','catalog_review_register:add')")
   public ResultVO saveJudge(@RequestBody ContractRegistrationDTOParam dtoParam) {
      log.info("Api调用:新增合同登记申请");
      dtoParam.setRegistrationType(1);
      return ResultBuilder.success(this.contractRegistrationService.saveContractRegistration(dtoParam));
   }

   @ApiOperation("新增合同直接登记申请")
   @PostMapping("/saveDirect")
   @PreAuthorize("@permission.check('catalog_direct_register:add')")
   public ResultVO saveDirect(@RequestBody ContractRegistrationDTOParam dtoParam) {
      log.info("Api调用:新增合同登记申请");
      dtoParam.setRegistrationType(2);
      return ResultBuilder.success(this.contractRegistrationService.saveContractRegistration(dtoParam));
   }

   @ApiOperation("根据ID查看合同评审登记详情")
   @GetMapping("/judge/{id}")
   @PreAuthorize("@permission.check('catalog_review_register:detail')")
   public ResultVO selectJudgeById(@PathVariable("id") Long id) {
      log.info("Api调用:根据ID查看合同评审登记详情");
      return ResultBuilder.success(this.contractRegistrationService.selectById(id));
   }

   @ApiOperation("根据ID查看合同直接登记详情")
   @GetMapping("/direct/{id}")
   @PreAuthorize("@permission.check('catalog_direct_register:detail')")
   public ResultVO selectDirectById(@PathVariable("id") Long id) {
      log.info("Api调用:根据ID查看合同直接登记详情");
      return ResultBuilder.success(this.contractRegistrationService.selectById(id));
   }

   @ApiOperation("审核评审合同登记单")
   @PutMapping("/review")
   public ResultVO review(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核评审合同登记单");
      return ResultBuilder.success(this.contractRegistrationService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销合同登记单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销合同登记单");
      return ResultBuilder.success(this.contractRegistrationService.revocation(id));
   }

   @ApiOperation("重新编辑评审合同登记单")
   @PutMapping("/edit")
   public ResultVO edit(@RequestBody ContractRegistrationDTOParam dtoParam) {
      log.info("API 调用 ：重新编辑评审合同登记单");
      return ResultBuilder.success(this.contractRegistrationService.edit(dtoParam));
   }

   @ApiOperation("合同评审登记单下载")
   @GetMapping("/exportJudge")
   @PreAuthorize("@permission.check('catalog_review_register:download')")
   public ResultVO judgeExport(ContractRegistrationQueryDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：合同评审登记单下载");
      param.setRegistrationType(1);
      return ResultBuilder.success(this.contractRegistrationService.export(param, response));
   }

   @ApiOperation("合同直接登记单下载")
   @GetMapping("/exportDirect")
   @PreAuthorize("@permission.check('catalog_direct_register:download')")
   public ResultVO directExport(ContractRegistrationQueryDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：合同直接登记单下载");
      param.setRegistrationType(2);
      return ResultBuilder.success(this.contractRegistrationService.export(param, response));
   }
}
