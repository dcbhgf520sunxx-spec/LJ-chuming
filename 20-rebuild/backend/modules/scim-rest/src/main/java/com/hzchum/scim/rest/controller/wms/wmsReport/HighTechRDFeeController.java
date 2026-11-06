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

@Api(tags = "wms-报表高新研发费")
@RestController
@RequestMapping("/api/wms/report/raw-materials/high-tech-rd-fee")
public class HighTechRDFeeController {
   private static final Logger log = LoggerFactory.getLogger(HighTechRDFeeController.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-高新研发费列表")
   @GetMapping("")
   @PreAuthorize("@permission.check('wms_report_rawMat_highTechRDFee:get')")
   public ResultVO list(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-高新研发费列表");
      return ResultBuilder.success(this.reportService.getHighTechRDFee(param, pageNumber, pageSize, sort));
   }
}
