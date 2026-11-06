package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-制成品出库申请")
@RestController
@RequestMapping("/api/wms/outbound/manufactured/application")
public class OutboundManufacturedRecordController {
   private static final Logger log = LoggerFactory.getLogger(OutboundManufacturedRecordController.class);
   @Resource
   OutboundManufacturedService outboundManufacturedService;

   @ApiOperation("根据条件分页查询制成品出库单列表")
   @GetMapping("/record")
   @PreAuthorize("@permission.check('wms_rawMat_manuf_outbound_record:get')")
   public ResultVO list(
      QueryOutboundManufacturedDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询制成品出库单列表");
      return ResultBuilder.success(this.outboundManufacturedService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据条件分页查询制成品出库明细记录")
   @GetMapping("/record/detail")
   @PreAuthorize("@permission.check('wms_report_manuf_outbound_details:get')")
   public ResultVO listDetail(
      QueryOutboundManufacturedDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询制成品出库明细记录");
      return ResultBuilder.success(this.outboundManufacturedService.pageInfoDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取制成品出库详情")
   @GetMapping("/record/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_manuf_outbound_record:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取制成品出库详情");
      return ResultBuilder.success(this.outboundManufacturedService.getOutboundById(id));
   }

   @ApiOperation("制成品出库 -> 保存至制成品出库清单")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('wms_matWarehouse_manufactured_self:get')")
   public ResultVO save(@Valid @RequestBody OutboundManufacturedDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：制成品出库 -> 保存至制成品出库清单");
      return ResultBuilder.success(this.outboundManufacturedService.save(param));
   }

   @ApiOperation("制成品出库 -> 直接提交审核")
   @PostMapping("/submit")
   @PreAuthorize("@permission.check('wms_matWarehouse_manufactured_self:get')")
   public ResultVO saveSubmit(@Valid @RequestBody OutboundManufacturedDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：制成品出库 -> 直接提交审核");
      return ResultBuilder.success(this.outboundManufacturedService.saveSubmit(param));
   }
}
