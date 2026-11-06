package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SurplusDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-盘盈管理")
@RestController
@RequestMapping("/api/wms/surplus")
public class SurplusController {
   private static final Logger log = LoggerFactory.getLogger(SurplusController.class);
   @Resource
   WmsSurplusService wmsSurplusService;

   @ApiOperation("保存至清单")
   @PostMapping("/saveSurplusToList")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_profit:add')")
   public ResultVO saveSurplusToList(@Valid @RequestBody SurplusDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：保存至清单");
      return ResultBuilder.success(this.wmsSurplusService.saveSurplusToList(param));
   }

   @ApiOperation("当前用户清单列表")
   @GetMapping("/getByCurrentUser")
   public ResultVO getByCurrentUser() {
      log.info("API 调用 ：当前用户清单列表");
      return ResultBuilder.success(this.wmsSurplusService.getByCurrentUser());
   }

   @ApiOperation("当前用户清单列表数量")
   @GetMapping("/getByCurrentUser/number")
   public ResultVO getByCurrentUserNumber() {
      log.info("API 调用 ：当前用户清单列表数量");
      return ResultBuilder.success(this.wmsSurplusService.getByCurrentUserNumber());
   }

   @ApiOperation("删除盘盈清单")
   @DeleteMapping("/deleteByList")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_profit:add')")
   public ResultVO deleteDetailByList(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除盘盈清单");
      return ResultBuilder.success(this.wmsSurplusService.deleteDetailByList(ids));
   }

   @ApiOperation("清空盘盈清单")
   @DeleteMapping("/clearDetailList")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_profit:add')")
   public ResultVO clearDetailList() {
      log.info("API 调用 ：清空盘盈清单");
      return ResultBuilder.success(this.wmsSurplusService.clearDetailList());
   }

   @ApiOperation("提交审核盘盈")
   @PostMapping("/submitReview")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_profit:add')")
   @SignerCheck(boolMethodAndClassName = true, message = "盘盈单提交审核中", timeout = 30L)
   public ResultVO submitReview(@Valid @RequestBody SurplusDTOParam param) {
      log.info("API 调用 ：提交审核盘盈");
      return ResultBuilder.success(this.wmsSurplusService.submitReview(param));
   }

   @ApiOperation("审核盘盈单")
   @PutMapping("/check")
   public ResultVO update(@RequestBody @Validated WmsApproveOpinionDTOParam param) {
      log.info("API 调用 ：审核盘盈单");
      return ResultBuilder.success(this.wmsSurplusService.check(param));
   }

   @ApiOperation("撤销盘盈单")
   @PostMapping("/cancelApproveDetail/{id}")
   public ResultVO cancelApproveDetail(@PathVariable Long id) {
      log.info("API 调用 ：撤销盘盈单");
      return ResultBuilder.success(this.wmsSurplusService.cancelApproveDetail(id));
   }

   @ApiOperation("盘盈单据单")
   @GetMapping("/receiptList")
   public ResultVO deficit(
      QueryReportSurplusDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：盘盈单据单");
      return ResultBuilder.success(this.wmsSurplusService.getWmsSurplus(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("盘盈详情")
   @GetMapping("/{id}")
   public ResultVO deficit(@PathVariable("id") Long id) {
      log.info("API 调用 ：盘盈详情");
      return ResultBuilder.success(this.wmsSurplusService.getSurplusById(id));
   }

   @ApiOperation("盘盈明细报表")
   @GetMapping("/detailList")
   @PreAuthorize("@permission.check('report_rawMat_inventory_profit:get')")
   public ResultVO deficitDetails(
      QueryReportSurplusDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：盘盈明细报表");
      return ResultBuilder.success(this.wmsSurplusService.getSurplusDetailPage(param, pageNumber, pageSize, sort));
   }
}
