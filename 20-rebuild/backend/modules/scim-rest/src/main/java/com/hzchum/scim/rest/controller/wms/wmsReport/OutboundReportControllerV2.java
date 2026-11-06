package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
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

@Api(tags = "wms-出库报表")
@RestController
@RequestMapping("/api/v2/wms/report/raw-materials/outbound")
public class OutboundReportControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(OutboundReportControllerV2.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-查询外协原料出库明细")
   @GetMapping("/outsourcingDetails")
   public ResultVO OutsourcingDetailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询出库库明细");
      param.setOutReviewStatus(2);
      param.setOutboundTypeSelection(OutboundTypeEnum.OUTSOURCING_RAW_MATERIALS.getType());
      return ResultBuilder.success(this.reportService.getOutsourcingOutboundDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-查询废料出库单表")
   @GetMapping("/scrapsList")
   public ResultVO scrapsList(
      QueryOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询报废出库单表");
      return ResultBuilder.success(this.reportService.getScrapsOutbound(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-对外出售 -> 对外出售明细 or 对外出售价格差异明细")
   @GetMapping("/forSale/details")
   @PreAuthorize(
      "@permission.check('wms_report_self_purchased_warehouse_external_sales_details:get','wms_report_price_difference_for_external_sales_details:get')"
   )
   public ResultVO forSaleDetailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-对外出售 -> 对外出售明细 or 对外出售价格差异明细");
      param.setOutReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.reportService.getForSaleOutboundDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-对外出售 -> 对外出售重量差异、价格差异 or 出售含税金额汇总")
   @GetMapping("/forSale/detailsCount")
   @PreAuthorize("@permission.check('wms_report_self_purchased_warehouse_external_sales_details:get','wms_report_price_difference_for_external_sales_details:get')")
   public ResultVO forSaleDetailList(QueryDetailDTOParam param) {
      log.info("API 调用 ：报表-对外出售 -> 对外出售重量差异、价格差异 or 出售含税金额汇总");
      param.setOutReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      param.setOutboundTypeSelection(OutboundTypeEnum.FOR_SALE.getType());
      return ResultBuilder.success(this.reportService.getForSaleOutboundDetailCount(param));
   }

   @ApiOperation("报表-对外出售价格差异表统计")
   @GetMapping("/forSale/statistics")
   @PreAuthorize("@permission.check('wms_report_price_difference_for_external_sales_details:get')")
   public ResultVO forSaleStatisticsList() {
      log.info("API 调用 ：报表-对外出售价格差异表统计");
      return ResultBuilder.success(this.reportService.forSaleStatistics());
   }
}
