package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractAnalysisQueryDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractPooledAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同分析")
@RestController
@RequestMapping("/api/contract/analysis")
public class ContractPooledAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(ContractPooledAnalysisController.class);
   @Resource
   ContractPooledAnalysisService contractPooledAnalysisService;

   @ApiOperation("汇总分析")
   @GetMapping("/pooled")
   @PreAuthorize("@permission.check('catalog_summary_analysis:get')")
   public ResultVO pooled(ContractAnalysisQueryDTOParam param) {
      log.info("Api调用:汇总分析");
      return ResultBuilder.success(this.contractPooledAnalysisService.analyse(param));
   }

   @ApiOperation("部门承接分析")
   @GetMapping("/department")
   @PreAuthorize("@permission.check('catalog_dept_analysis:get')")
   public ResultVO department(ContractAnalysisQueryDTOParam param) {
      log.info("Api调用:部门承接分析");
      return ResultBuilder.success(this.contractPooledAnalysisService.analyse(param));
   }

   @ApiOperation("部门季度排名")
   @GetMapping("/department/quarter")
   @PreAuthorize("@permission.check('catalog_seller_quarter_analysis:get')")
   public ResultVO departmentQuarter(ContractAnalysisQueryDTOParam param) {
      log.info("Api调用:部门季度排名 ");
      return ResultBuilder.success(this.contractPooledAnalysisService.departmentQuarter(param));
   }

   @ApiOperation("汇总分析下载")
   @GetMapping("/pooled/export")
   @PreAuthorize("@permission.check('catalog_summary_analysis:download')")
   public ResultVO pooledExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response) {
      log.info("Api调用:汇总分析下载");
      return ResultBuilder.success(this.contractPooledAnalysisService.pooledExport(param, response));
   }

   @ApiOperation("部门承接分析下载")
   @GetMapping("/department/export")
   @PreAuthorize("@permission.check('catalog_dept_analysis:download')")
   public ResultVO departmentExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response) {
      log.info("Api调用:部门承接分析下载");
      return ResultBuilder.success(this.contractPooledAnalysisService.departmentExport(param, response));
   }

   @ApiOperation("部门季度排名下载")
   @GetMapping("/department/quarter/export")
   @PreAuthorize("@permission.check('catalog_seller_quarter_analysis:download')")
   public ResultVO departmentQuarterExport(ContractAnalysisQueryDTOParam param, HttpServletResponse response) {
      log.info("Api调用:部门季度排名下载 ");
      return ResultBuilder.success(this.contractPooledAnalysisService.departmentQuarterExport(param, response));
   }
}
