package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.biz.wmsReport.WasteSaleBiz;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleCheckDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleQueryDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-废料出售")
@Validated
@RequestMapping("/api/wms/report/wasteSale")
@RestController
public class WasteSaleController {
   private static final Logger log = LoggerFactory.getLogger(WasteSaleController.class);
   private final WasteSaleBiz wasteSaleBiz;

   @ApiOperation("列表")
   @GetMapping
   @PreAuthorize("@permission.check('wms_scrap_sell:get')")
   public ResultVO<PageVO<WasteSaleDTO>> pageList(
      WasteSaleQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料出售记录列表");
      return ResultBuilder.success(this.wasteSaleBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("列表-打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('wms_scrap_sell:print')")
   public ResultVO printList(WasteSaleQueryDtoParam param) {
      log.info("Api调用:废料出售记录列表打印");
      return ResultBuilder.success(this.wasteSaleBiz.printList(param));
   }

   @ApiOperation("下载-出售单")
   @GetMapping("/downLoad/{id}")
   @PreAuthorize("@permission.check('wms_scrap_sell:downLoad')")
   public ResultVO downLoad(@PathVariable Long id, HttpServletResponse response) {
      log.info("Api调用:废料出售记录列表打印");
      return ResultBuilder.success(this.wasteSaleBiz.downLoadWasteSale(id, response));
   }

   @ApiOperation("明细列表")
   @GetMapping("/detail")
   public ResultVO<PageVO<WasteSaleDetailWholeInfoDTO>> pageListDetail(
      WasteSaleDetailQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料出售记录明细列表");
      return ResultBuilder.success(this.wasteSaleBiz.pageListDetail(param, pageNumber, pageSize));
   }

   @ApiOperation("明细列表-打印")
   @GetMapping("/detail/print")
   public ResultVO printListDetail(WasteSaleDetailQueryDtoParam param) {
      log.info("Api调用:废料出售记录明细列表打印");
      return ResultBuilder.success(this.wasteSaleBiz.printListDetail(param));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('wms_scrap_sell:add')")
   public ResultVO saveList(@RequestBody @Valid List<WasteSaleDtoParam> paramList) {
      log.info("Api调用:废料出售新增");
      return ResultBuilder.success(this.wasteSaleBiz.saveList(paramList));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('wms_scrap_sell:edit')")
   public ResultVO updateList(@RequestBody @Valid List<WasteSaleDtoParam> paramList) {
      log.info("Api调用:废料出售记录修改");
      return ResultBuilder.success(this.wasteSaleBiz.updateList(paramList));
   }

   @ApiOperation("审核")
   @PutMapping("/check")
   @PreAuthorize("@permission.check('wms_scrap_sell:check')")
   public ResultVO check(@RequestBody @Valid WasteSaleCheckDtoParam param) {
      log.info("Api调用:废料出售记录审核");
      return ResultBuilder.success(this.wasteSaleBiz.auditWasteSale(param));
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('wms_scrap_sell:del')")
   public ResultVO deleteList(@RequestBody List<Long> ids) {
      log.info("Api调用:废料出售记录删除");
      return ResultBuilder.success(this.wasteSaleBiz.deleteList(ids));
   }

   public WasteSaleController(final WasteSaleBiz wasteSaleBiz) {
      this.wasteSaleBiz = wasteSaleBiz;
   }
}
