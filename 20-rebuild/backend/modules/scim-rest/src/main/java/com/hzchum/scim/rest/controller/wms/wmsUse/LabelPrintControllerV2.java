package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-标签打印")
@RestController
@RequestMapping("/api/v2/wms/material/label-print/")
public class LabelPrintControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(LabelPrintControllerV2.class);
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
      return ResultBuilder.success(this.printService.receiptListV2(param, pageNumber, pageSize, sort));
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
      return ResultBuilder.success(this.printService.materialListV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询未打印标签数量")
   @GetMapping("/not-printed-number")
   public ResultVO listDetail(Boolean boolPartyA) {
      log.info("API 调用 ：查询未打印标签数量");
      return ResultBuilder.success(this.printService.getNumberV2(boolPartyA));
   }
}
