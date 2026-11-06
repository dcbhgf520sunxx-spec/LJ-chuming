package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-退库报表")
@RestController
@RequestMapping("/api/v2/wms/report/raw-materials/return")
public class ReturnReportControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ReturnReportControllerV2.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-查询退库明细")
   @GetMapping("/details")
   @PreAuthorize("@permission.check('wms_report_rawMat_return_details:get')")
   public ResultVO detailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询退库明细");
      return ResultBuilder.success(this.reportService.getReturnDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询退库明细汇总")
   @GetMapping("/detailsCount")
   @PreAuthorize("@permission.check('wms_report_rawMat_return_details:get')")
   public ResultVO detailListCount(QueryDetailDTOParam param) {
      log.info("API 调用 ：报表-查询退库明细汇总");
      return ResultBuilder.success(this.reportService.getReturnDetailCount(param));
   }
}
