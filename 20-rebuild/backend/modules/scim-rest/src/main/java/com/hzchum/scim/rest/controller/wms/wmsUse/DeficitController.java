package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportDeficitDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeficitDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsDeficitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-盘亏管理")
@RestController
@RequestMapping("/api/wms/deficit")
public class DeficitController {
   private static final Logger log = LoggerFactory.getLogger(DeficitController.class);
   @Resource
   WmsDeficitService wmsDeficitService;

   @ApiOperation("保存盘亏")
   @PutMapping("/saveDeficit")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_loss:add')")
   public ResultVO saveDeficit(@Valid @RequestBody DeficitDTOParam deficitDTOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：保存盘亏");
      return ResultBuilder.success(this.wmsDeficitService.saveDeficit(deficitDTOParam));
   }

   @ApiOperation("根据id查询盘亏单详情")
   @GetMapping("/deficit/{id}")
   public ResultVO deficit(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据id查询盘亏单详情");
      return ResultBuilder.success(this.wmsDeficitService.getDefictById(id));
   }

   @ApiOperation("报表-查询盘亏明细")
   @GetMapping("/deficitDetails")
   @PreAuthorize("@permission.check('report_rawMat_inventory_loss:get')")
   public ResultVO deficitDetails(
      QueryReportDeficitDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-查询盘亏明细");
      return ResultBuilder.success(this.wmsDeficitService.getWmsDeficitDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询盘亏单")
   @GetMapping("/deficit")
   public ResultVO deficit(
      QueryReportDeficitDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询盘亏单");
      return ResultBuilder.success(this.wmsDeficitService.getWmsDeficit(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("撤销盘亏单")
   @PostMapping("/revocation/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_loss:add')")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销盘亏单");
      return ResultBuilder.success(this.wmsDeficitService.revocation(id));
   }

   @ApiOperation("审核盘亏单")
   @PostMapping("/approval")
   @PreAuthorize("@permission.check('wms_rawMat_inventory_loss:audit')")
   public ResultVO approvalDeficit(
      @RequestParam(name = "id", required = true) Long id,
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核盘亏单");
      return ResultBuilder.success(this.wmsDeficitService.approvalDeficit(id, approveRecordId, decision, opinion));
   }
}
