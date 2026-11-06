package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
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

@Api(tags = "wms-制成品入库申请")
@RestController
@RequestMapping("/api/wms/inbound/manufactured/application")
public class InboundManufacturedRecordController {
   private static final Logger log = LoggerFactory.getLogger(InboundManufacturedRecordController.class);
   @Resource
   InboundManufacturedService inboundManufacturedService;

   @ApiOperation("根据条件分页查询制成品入库记录")
   @GetMapping("/record")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_self_record_manuf:get','wms_report_rawMat_inbound_receipt_manuf:get')")
   public ResultVO list(
      QueryInboundManufacturedDTOParam queryDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询制成品入库记录");
      return ResultBuilder.success(this.inboundManufacturedService.pageInfo(queryDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据条件分页查询制成品入库明细记录")
   @GetMapping("/record/detail")
   @PreAuthorize("@permission.check('wms_report_rawMat_inbound_details_manuf:get')")
   public ResultVO listDetail(
      QueryInboundManufacturedDTOParam queryDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询制成品入库记录");
      return ResultBuilder.success(this.inboundManufacturedService.pageInfoDetail(queryDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据制成品入库单ID查询制成品入库详情")
   @GetMapping("/record/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_self_record_manuf:detail')")
   public ResultVO listDetail(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据制成品入库单ID查询制成品入库详情");
      return ResultBuilder.success(this.inboundManufacturedService.getList(id));
   }

   @ApiOperation("新增制成品入库单")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('wms_manufInbound_application:submit')")
   @SignerCheck(lockKey = "#dtoParam.purchaseId", message = "该采购单正在办理入库中,请稍后刷新重试!")
   public ResultVO addSteel(@Valid @RequestBody InboundManufacturedDTOParam dtoParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增制成品入库单");
      return ResultBuilder.success(this.inboundManufacturedService.saveInboundManufactured(dtoParam));
   }

   @ApiOperation("驳回后或撤销或直接编辑制成品入库单 -> 直接编辑先撤销在发起申请")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('wms_manufInbound_application:submit')")
   @SignerCheck(lockKey = "#dtoParam.id", message = "该入库单正在操作中,请稍后刷新重试!")
   public ResultVO update(@RequestBody InboundManufacturedDTOParam dtoParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 驳回后或撤销或直接编辑制成品入库单 -> 直接编辑先撤销在发起申请");
      return ResultBuilder.success(this.inboundManufacturedService.returnUpdateInboundManufactured(dtoParam));
   }
}
