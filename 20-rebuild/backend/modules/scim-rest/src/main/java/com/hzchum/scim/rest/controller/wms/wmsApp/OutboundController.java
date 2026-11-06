package com.hzchum.scim.rest.controller.wms.wmsApp;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAppService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-App出库")
@RestController
@RequestMapping("/api/app/wms/outbound")
public class OutboundController {
   private static final Logger log = LoggerFactory.getLogger(OutboundController.class);
   @Resource
   WmsAppService wmsAppService;

   @ApiOperation("App-出库详情列表查询")
   @GetMapping("/details")
   public ResultVO detailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：App-出库详情列表查询");
      return ResultBuilder.success(this.wmsAppService.getOutboundDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("App-申请出库")
   @PutMapping("/application")
   public ResultVO outbound(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：申请出库");
      return ResultBuilder.success(this.wmsAppService.saveOutbound(param));
   }

   @ApiOperation("扫码出库根据条形码获取物料信息")
   @GetMapping("/{barcode}")
   @PreAuthorize("@permission.check('materialOutBoundV2','machinePartManufacture')")
   public ResultVO getById(@PathVariable("barcode") String barcode) {
      log.info("API 调用 ：扫码出库根据条形码获取物料信息");
      return ResultBuilder.success(this.wmsAppService.getOutboundMaterial(barcode));
   }

   @ApiOperation("app-用户确认出库")
   @PutMapping("/passed")
   @PreAuthorize("@permission.check('materialOutBound')")
   public ResultVO passed(@RequestBody OutboundDTOParam param) {
      log.info("API 调用 ：用户确认出库");
      return ResultBuilder.success(this.wmsAppService.outPassed(param));
   }

   @ApiOperation("app-删除出库单")
   @PutMapping("/{id}/returned")
   @PreAuthorize("@permission.check('materialOutBoundV2')")
   public ResultVO returned(@PathVariable("id") Long id) {
      log.info("API 调用 ：app-删除出库单");
      return ResultBuilder.success(this.wmsAppService.outReturned(id));
   }

   @ApiOperation("app-查询当前用户未审核的出库单")
   @GetMapping("/current-user")
   @PreAuthorize("@permission.check('materialPool','materialOutBoundV2')")
   public ResultVO getByCurrentUser() {
      log.info("API 调用 ：app-查询当前用户未审核的出库单");
      return ResultBuilder.success(this.wmsAppService.getByCurrentUser());
   }

   @ApiOperation("app-根据ID删除对应的单条出库详情")
   @PutMapping("/material-del")
   @PreAuthorize("@permission.check('materialOutBoundV2')")
   public ResultVO delete(Long listId, Long materialId) {
      log.info("API 调用 ：app-根据ID删除对应的单条出库详情");
      return ResultBuilder.success(this.wmsAppService.outDeleteById(listId, materialId));
   }

   @ApiOperation("app-出库列表查询")
   @GetMapping("/list")
   public ResultVO list(
      QueryOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：app-出库列表查询");
      return ResultBuilder.success(this.wmsAppService.outboundList(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取出库清单")
   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('materialOutBoundV2')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取出库清单");
      return ResultBuilder.success(this.wmsAppService.getOutboundDetail(id));
   }
}
