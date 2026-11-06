package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-进销存记录")
@RestController
@RequestMapping("/api/wms/report/raw-materials/psi")
public class PSIRecordController {
   private static final Logger log = LoggerFactory.getLogger(PSIRecordController.class);
   @Resource
   ReportService reportService;

   @ApiOperation("报表-进销存列表查询")
   @GetMapping
   @PreAuthorize("@permission.check('wms_report_rawMat_psi:get')")
   public ResultVO list(
      Integer basicClass,
      @RequestParam(name = "times") List<LocalDateTime> times,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) BigDecimal thickness,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-进销存列表查询");
      return ResultBuilder.success(this.reportService.getPSIList(basicClass, times, material, thickness, classifyId, pageNumber, pageSize, sort));
   }

   @ApiOperation("报表-进销存列表查询")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('wms_report_rawMat_psi:detail')")
   public ResultVO detailList(
      Integer type,
      @RequestParam(name = "times") List<LocalDateTime> times,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) BigDecimal width,
      @RequestParam(required = false) BigDecimal length,
      @RequestParam(required = false) BigDecimal thickness,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-进销存列表查询");
      return ResultBuilder.success(
         this.reportService.getPSIDetailList(classifyId, specification, width, length, thickness, type, times, pageNumber, pageSize, sort)
      );
   }
}
