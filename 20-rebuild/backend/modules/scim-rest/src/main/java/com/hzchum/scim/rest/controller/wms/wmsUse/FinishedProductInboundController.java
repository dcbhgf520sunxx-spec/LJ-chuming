package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-制成品入库")
@RestController
@RequestMapping("/api/wms/inbound/finished_product")
public class FinishedProductInboundController {
   private static final Logger log = LoggerFactory.getLogger(FinishedProductInboundController.class);
   @Resource
   InboundService inboundService;

   @ApiOperation("根据条件分页查询入库记录")
   @GetMapping
   @PreAuthorize("@permission.check('wms_rawMat_inbound_record:get')")
   public ResultVO list(
      QueryInboundDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询入库记录");
      return ResultBuilder.success(this.inboundService.pageInfo(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据入库单ID查询入库详情")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_record:get')")
   public ResultVO listDetail(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据入库单ID查询入库详情");
      return ResultBuilder.success(this.inboundService.getList(id, false, false));
   }

   @ApiOperation("新增入库单")
   @PostMapping
   @PreAuthorize("@permission.check('wms_steelInbound_application:submit')")
   public ResultVO addSteel(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增入库单");
      return ResultBuilder.success(this.inboundService.saveInbound(request));
   }

   @ApiOperation("修改入库单")
   @PutMapping
   @PreAuthorize("@permission.check('wms_rawMat_inbound_record:edit')")
   public ResultVO update(@RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 修改入库单");
      return ResultBuilder.success(this.inboundService.updateInbound(request));
   }

   @ApiOperation("删除入库单详情")
   @DeleteMapping
   @PreAuthorize("@permission.check('wms_rawMat_inbound_record:del')")
   public ResultVO del(@RequestBody List<Long> ids) {
      log.info("API 调用 : 删除入库单详情");
      return ResultBuilder.success(this.inboundService.deleteByIds(ids));
   }
}
