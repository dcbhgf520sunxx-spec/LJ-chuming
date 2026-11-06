package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractPreRegistrationQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractPreRegistrationDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractPreRegistrationService;
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

@Api(tags = "合同预登记")
@RestController
@RequestMapping("/api/contract/pre/registration")
public class ContractPreRegistrationController {
   private static final Logger log = LoggerFactory.getLogger(ContractPreRegistrationController.class);
   @Resource
   private ContractPreRegistrationService contractPreRegistrationService;

   @ApiOperation("获取合同预登记列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('catalog_pre_register:get')")
   public ResultVO getContractFiledConfig(
      ContractPreRegistrationQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:获取合同预登记列表");
      return ResultBuilder.success(this.contractPreRegistrationService.getList(param, pageNumber, pageSize));
   }

   @ApiOperation("新增合同预登记申请")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('catalog_pre_register:add')")
   public ResultVO saveContractFiledConfig(@RequestBody ContractPreRegistrationDTOParam dtoParam) {
      log.info("Api调用:新增合同预登记申请");
      return ResultBuilder.success(this.contractPreRegistrationService.saveContractFiledConfig(dtoParam));
   }

   @ApiOperation("根据ID查看合同预登记详情")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('catalog_pre_register:detail')")
   public ResultVO selectById(@PathVariable("id") Long id) {
      log.info("Api调用:根据ID查看合同预登记详情");
      return ResultBuilder.success(this.contractPreRegistrationService.selectById(id));
   }

   @ApiOperation("审核合同预登记单")
   @PutMapping("/review")
   public ResultVO review(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核合同预登记单");
      return ResultBuilder.success(this.contractPreRegistrationService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销合同预登记单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销合同预登记单");
      return ResultBuilder.success(this.contractPreRegistrationService.revocation(id));
   }

   @ApiOperation("重新编辑合同预登记单")
   @PutMapping("/edit")
   public ResultVO edit(@RequestBody ContractPreRegistrationDTOParam dtoParam) {
      log.info("API 调用 ：重新编辑合同预登记单");
      return ResultBuilder.success(this.contractPreRegistrationService.edit(dtoParam));
   }

   @ApiOperation("合同预登记单下载")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('catalog_pre_register:download')")
   public ResultVO export(ContractPreRegistrationQueryDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：合同预登记单下载");
      return ResultBuilder.success(this.contractPreRegistrationService.export(param, response));
   }

   @ApiOperation("获取未被引用的预登记单信息")
   @GetMapping("/unQuote")
   public ResultVO getUnQuoteList() {
      log.info("Api调用:获取未被引用的预登记单信息");
      return ResultBuilder.success(this.contractPreRegistrationService.getUnQuoteList());
   }
}
