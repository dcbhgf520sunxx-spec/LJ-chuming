package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ManagementFeeDto;
import com.hzchum.scim.contract.core.api.service.finance.ManagementFeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contract/Management-fee")
@Api(tags = "管理费报表")
public class ManagementFeeController {
   private static final Logger log = LoggerFactory.getLogger(ManagementFeeController.class);
   @Resource
   private ManagementFeeService managementFeeService;

   @GetMapping("/findAll/{year}")
   @ApiOperation("管理费报表查询")
   @PreAuthorize("@permission.check('operation_management:get')")
   public ResultVO<ListVO<ManagementFeeDto>> findAll(@ApiParam(value = "year", name = "年", readOnly = true) @PathVariable("year") Integer year) {
      return ResultBuilder.success(this.managementFeeService.findAll(year));
   }

   @GetMapping("/export/{year}")
   @ApiOperation("管理费报表导出")
   @PreAuthorize("@permission.check('operation_management:download')")
   public void export(@ApiParam(value = "year", name = "年", readOnly = true) @PathVariable("year") Integer year, HttpServletResponse response) {
      this.managementFeeService.export(year, response);
   }
}
