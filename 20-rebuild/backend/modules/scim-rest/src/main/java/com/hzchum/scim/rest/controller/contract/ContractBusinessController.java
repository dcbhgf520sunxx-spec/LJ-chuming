package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-客户交易")
@RestController
@RequestMapping("/api/business/check")
public class ContractBusinessController {
   private static final Logger log = LoggerFactory.getLogger(ContractBusinessController.class);
   @Autowired
   private ContractProjectService projectService;

   @ApiOperation("获取客户交易汇总记录")
   @GetMapping("summary")
   @PreAuthorize("@permission.check('transaction_record:get')")
   public ResultVO customerTransactionSummary(
      String name,
      Integer businessType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取客户交易汇总记录");
      return ResultBuilder.success(this.projectService.customerTransactionSummaryPage(name, businessType, startDate, endDate, pageNumber, pageSize, sort));
   }

   @ApiOperation("打印客户交易汇总记录")
   @GetMapping("summary/print")
   @PreAuthorize("@permission.check('transaction_record:print')")
   public ResultVO printCustomerTransactionSummary(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      log.info("API 调用 ：打印客户交易汇总记录");
      return ResultBuilder.success(this.projectService.printCustomerTransactionSummary(name, businessType, startDate, endDate));
   }

   @ApiOperation("获取客户交易详情")
   @GetMapping("detail")
   @PreAuthorize("@permission.check('transaction_record:detail')")
   public ResultVO customerTransactionDetail(@RequestParam String name, @RequestParam Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      log.info("API 调用 ：获取客户交易详情");
      return ResultBuilder.success(this.projectService.customerTransactionDetail(name, businessType, startDate, endDate));
   }

   @ApiOperation("打印客户交易详情")
   @GetMapping("detail/print")
   @PreAuthorize("@permission.check('transaction_record:detail')")
   public ResultVO printCustomerTransactionDetail(@RequestParam String name, @RequestParam Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      log.info("API 调用 ：打印客户交易详情");
      return ResultBuilder.success(this.projectService.printCustomerTransactionDetail(name, businessType, startDate, endDate));
   }
}
