package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AllocationPickingDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingAllocationDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingApproveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "WMS-领料排产出库审核")
@RestController
@RequestMapping("/api/wms/picking/approve")
public class WmsPickingApproveController {
   private static final Logger log = LoggerFactory.getLogger(WmsPickingApproveController.class);
   @Resource
   WmsPickingApproveService wmsPickingApproveService;

   @ApiOperation("根据条件分页查询领料排产出库单列表")
   @GetMapping("/record")
   @PreAuthorize("@permission.check('wms_mes_receipt_audit:get')")
   public ResultVO list(
      QueryPickingApproveDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询领料排产出库单列表");
      return ResultBuilder.success(this.wmsPickingApproveService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取领料排产审核详情")
   @GetMapping("/selectById/{id}")
   @PreAuthorize("@permission.check('wms_mes_receipt_audit:detail')")
   public ResultVO getMatByDetailId(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取领料排产审核详情");
      return ResultBuilder.success(this.wmsPickingApproveService.selectById(id));
   }

   @ApiOperation("领料出库单发起申请")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('wms_mes_receipt_review:add')")
   public ResultVO steelPlateBatch(@Valid @RequestBody AllocationPickingDetailDTOParam allocationPickingDetailDTO, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：领料出库单发起申请");
      return ResultBuilder.success(this.wmsPickingApproveService.savePickingApproveNew(allocationPickingDetailDTO));
   }

   @ApiOperation("审核领料审核单")
   @PutMapping("/review")
   public ResultVO reviewOutbound(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核领料审核单");
      return ResultBuilder.success(this.wmsPickingApproveService.reviewPickingApprove(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销领料审核单")
   @PutMapping("/revocation")
   public ResultVO revocation(@RequestParam("id") Long id) {
      log.info("API 调用 ： 撤销领料审核单");
      return ResultBuilder.success(this.wmsPickingApproveService.revocation(id));
   }

   @ApiOperation("查询审核通过的领料出库信息")
   @GetMapping("/getPassDetail")
   public ResultVO getPassDetail(QueryPickingApproveDetailDTOParam param) {
      log.info("API 调用 ： 查询审核通过的领料出库信息");
      return ResultBuilder.success(this.wmsPickingApproveService.getPassDetail(param));
   }

   @ApiOperation("根据领料信息分配领料单数据")
   @PostMapping("/allocation")
   public ResultVO allocation(@RequestBody List<PickingAllocationDTOParam> params) {
      log.info("API 调用 ： 根据领料信息分配领料单数据");
      return ResultBuilder.success(this.wmsPickingApproveService.allocation(params));
   }
}
