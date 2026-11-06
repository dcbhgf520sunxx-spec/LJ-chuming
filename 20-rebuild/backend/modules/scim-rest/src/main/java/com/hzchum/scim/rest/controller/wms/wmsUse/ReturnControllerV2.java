package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MaterialReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialReturnableDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateReturnDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
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

@Api(tags = "wms-退库")
@RestController
@RequestMapping("/api/v2/wms/return")
public class ReturnControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ReturnControllerV2.class);
   @Resource
   ReturnService returnService;

   @ApiOperation("新增其它钢材退库")
   @PostMapping("/application/steel-other")
   @PreAuthorize("@permission.check('wms_otherSteel_return_application:submit')")
   public ResultVO steelCoil(@Valid @RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增其它钢材退库");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("查询可退库列表")
   @GetMapping("/returnable/{BasicClass}")
   public ResultVO list(
      QueryMaterialReturnableDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询可退库列表");
      return ResultBuilder.success(this.returnService.getReturnableV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("外协原料退库提交审核")
   @PostMapping("/application/outsourcingReturnable")
   public ResultVO outsourcingReturnable(@RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 外协原料退库提交审核");
      return ResultBuilder.success(this.returnService.directSubmitReviewOutsourcingReturnable(params));
   }

   @ApiOperation("外协原料退库审核")
   @PutMapping("/application/review/raw-materials/sourcingReturnApproval")
   public ResultVO sourcingReturnApproval(
      @RequestBody ReturnDTOParam param,
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：外协原料退库审核");
      return ResultBuilder.success(this.returnService.sourcingReturnApproval(param, approveRecordId, decision, opinion));
   }

   @ApiOperation("审核退库单")
   @PutMapping("/review")
   public ResultVO reviewOutbound(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核退库单");
      return ResultBuilder.success(this.returnService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销退库单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ： 撤销退库单");
      return ResultBuilder.success(this.returnService.revocation(id));
   }

   @ApiOperation("在申请中直接编辑退库单")
   @PutMapping("/application/record/raw-materials")
   public ResultVO update(@Valid @RequestBody UpdateReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 在申请中直接编辑退库单");
      return ResultBuilder.success(this.returnService.updateReturnV2(param));
   }
}
