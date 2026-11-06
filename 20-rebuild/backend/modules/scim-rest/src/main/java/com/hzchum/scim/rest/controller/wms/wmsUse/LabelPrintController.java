package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PrintDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryLabelPrintDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-标签打印")
@RestController
@RequestMapping("/api/wms/material/label-print/")
public class LabelPrintController {
   private static final Logger log = LoggerFactory.getLogger(LabelPrintController.class);
   @Resource
   PrintService printService;

   @ApiOperation("标签打印单据模式查询")
   @GetMapping("/receipt-mode")
   @PreAuthorize("@permission.check('wms_mat_labelPrint:get')")
   public ResultVO receiptList(
      QueryLabelPrintDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：标签打印单据模式查询");
      return ResultBuilder.success(this.printService.receiptList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("标签打印单据模式详情查询")
   @GetMapping("/receipt-mode/{id}")
   @PreAuthorize("@permission.check('wms_mat_labelPrint:get')")
   public ResultVO selectById(@PathVariable("id") Long id) {
      log.info("API 调用 ：标签打印单据模式详情查询");
      return ResultBuilder.success(this.printService.selectById(id));
   }

   @ApiOperation("标签打印物料模式查询")
   @GetMapping("/material-mode")
   @PreAuthorize("@permission.check('wms_mat_labelPrint:get')")
   public ResultVO materialList(
      QueryLabelPrintDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：标签打印物料模式查询");
      return ResultBuilder.success(this.printService.materialList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询未打印标签数量")
   @GetMapping("/not-printed-number")
   public ResultVO listDetail() {
      log.info("API 调用 ：查询未打印标签数量");
      return ResultBuilder.success(this.printService.getNumber());
   }

   @ApiOperation("保存打印数量")
   @PostMapping("/print-record")
   @PreAuthorize("@permission.check('wms_mat_labelPrint:get')")
   public ResultVO savePrintNumber(@RequestBody PrintDTOParam param) {
      log.info("API 调用 : 保存打印数量");
      return ResultBuilder.success(this.printService.savePrintNumber(param));
   }
}
