package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-退库报表")
@RestController
@RequestMapping("/api/wms/report/raw-materials/return")
public class ReturnReportController {
   private static final Logger log = LoggerFactory.getLogger(ReturnReportController.class);
   @Resource
   ReportService reportService;
   @Resource
   ReturnService returnService;

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

   @ApiOperation("退库单列表(体现实时金额)")
   @GetMapping("/receiptList")
   @PreAuthorize("@permission.check('wms_report_rawMat_return_receipt:get')")
   public ResultVO returnList(
      QueryReturnDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：退库单列表(体现实时金额)");
      return ResultBuilder.success(this.returnService.getReturnList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("退库单详情(体现实时金额)")
   @GetMapping("/receiptDetailById/{id}")
   @PreAuthorize("@permission.check('wms_report_rawMat_return_receipt:get','wms_rawMat_return_review:detail')")
   public ResultVO getReturnDetailById2(@PathVariable("id") Long id) {
      log.info("API 调用 ：退库单详情(体现实时金额)");
      return ResultBuilder.success(this.returnService.getReturnDetailById2(id));
   }

   @ApiOperation("退库单打印(体现实时金额)")
   @GetMapping("/receiptDetailById/{id}/print")
   @PreAuthorize("@permission.check('wms_report_rawMat_return_receipt:get','wms_rawMat_return_review:detail')")
   public ResultVO returnPrint(@PathVariable("id") Long id) {
      log.info("API 调用 ：退库单打印(体现实时金额)");
      return ResultBuilder.success(this.returnService.returnPrint(id));
   }
}
