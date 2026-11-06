package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchBorrowDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchBorrowReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsBorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-出库（借用）")
@RestController
@RequestMapping("/api/wms/borrow")
public class BorrowController {
   private static final Logger log = LoggerFactory.getLogger(BorrowController.class);
   @Resource
   WmsBorrowService wmsBorrowService;

   @ApiOperation("查询借出单")
   @GetMapping("/review/raw-materials")
   public ResultVO list(QueryOutboundDTOParam param) {
      log.info("API 调用 ：审核页面查询");
      return ResultBuilder.success(this.wmsBorrowService.getWmsBorrowList(param));
   }

   @ApiOperation("批量临时借出")
   @PutMapping("/steel-plate/batch")
   public ResultVO steelPlateBatch(@Valid @RequestBody BatchBorrowDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量临时借出");
      return ResultBuilder.success(this.wmsBorrowService.BatchBorrow(param));
   }

   @ApiOperation("临时借出（单个）")
   @PutMapping("/steel-plate/save")
   public ResultVO ges(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：临时借出(单个)");
      return ResultBuilder.success(this.wmsBorrowService.saveOutbound(param));
   }

   @ApiOperation("用户审核通过借出单")
   @GetMapping("/review/raw-materials/{id}/passed")
   public ResultVO passed(@PathVariable("id") Long id) {
      log.info("API 调用 ：用户审核通过借出单");
      return ResultBuilder.success(this.wmsBorrowService.passed(id));
   }

   @ApiOperation("批量归还(临时借出)")
   @PutMapping("/steel-plate/batchReturn")
   public ResultVO batchReturn(@Valid @RequestBody BatchBorrowReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量归还(临时借出)");
      return ResultBuilder.success(this.wmsBorrowService.saveBatchBorrowReturn(param));
   }

   @ApiOperation("用户审核归还单（临时借出）")
   @GetMapping("/review/raw-materials/{id}/passedBatchBorrowReturn")
   public ResultVO passedBatchBorrowReturn(@PathVariable("id") Long id) {
      log.info("API 调用 ：用户审核归还单");
      return ResultBuilder.success(this.wmsBorrowService.passedBatchBorrowReturn(id));
   }

   @ApiOperation("批量报损保存(临时借出)")
   @PutMapping("/steel-plate/saveBatchWastage")
   public ResultVO saveBatchWastage(@Valid @RequestBody BatchBorrowReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量报损(临时借出)");
      return ResultBuilder.success(this.wmsBorrowService.saveBatchWastage(param));
   }

   @ApiOperation("批量报损审核(临时借出)")
   @GetMapping("/review/raw-materials/{id}/passedBatchWastage")
   public ResultVO passedBatchWastage(@PathVariable("id") Long id) {
      log.info("API 调用 ：用户审核归还单");
      return ResultBuilder.success(this.wmsBorrowService.passedBatchWastage(id));
   }
}
