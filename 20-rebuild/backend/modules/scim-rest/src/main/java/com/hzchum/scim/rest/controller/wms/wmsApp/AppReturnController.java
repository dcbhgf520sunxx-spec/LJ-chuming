package com.hzchum.scim.rest.controller.wms.wmsApp;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-App余料拍照退库")
@RestController
@RequestMapping("/api/app/wms/return")
public class AppReturnController {
   private static final Logger log = LoggerFactory.getLogger(AppReturnController.class);
   @Resource
   ReturnService returnService;
   @Resource
   ReturnDetailService returnDetailService;

   @ApiOperation("app拍照退库")
   @PostMapping("/saveAPPInbound")
   public ResultVO saveAppInbound(@Valid @RequestBody APPInboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : app拍照退库");
      return ResultBuilder.success(this.returnService.saveAppReturn(request));
   }

   @ApiOperation("根据条件分页查询退库记录")
   @GetMapping("/record/returnList")
   public ResultVO InboundList(
      QueryInboundDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询退库记录");
      return ResultBuilder.success(this.returnService.selectAppReturnDetailDTO(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("用户确认退库")
   @PutMapping("/application/review/raw-materials/passed")
   public ResultVO appReturnPassed(@Valid @RequestBody ReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：用户确认退库");
      return ResultBuilder.success(this.returnService.passed(param));
   }

   @ApiOperation("审核退回")
   @PutMapping("/raw-materials/returned")
   public ResultVO returned(@RequestBody ReturnDTOParam request) {
      log.info("API 调用 : 审核退回");
      return ResultBuilder.success(this.returnService.returned(request));
   }

   @ApiOperation("app查询可退库列表-只查没退过的并且核算量符合的")
   @GetMapping("/returnable")
   public ResultVO list(
      APPInboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询可退库列表-只查没退过的并且核算量符合的");
      return ResultBuilder.success(this.returnService.getAppReturnableList(param, pageNumber, pageSize, sort));
   }
}
