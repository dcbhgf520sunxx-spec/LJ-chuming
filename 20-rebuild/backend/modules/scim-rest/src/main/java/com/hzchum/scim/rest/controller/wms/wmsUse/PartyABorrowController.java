package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyAReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPartyABorrowDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.PartyABorrowService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wms/transfer/party-a/borrow")
public class PartyABorrowController {
   private static final Logger log = LoggerFactory.getLogger(PartyABorrowController.class);
   @Resource
   PartyABorrowService partyABorrowService;

   @ApiOperation("借用归还-获取借用列表")
   @GetMapping
   public ResultVO list(
      QueryPartyABorrowDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：借用归还-获取借用列表");
      return ResultBuilder.success(this.partyABorrowService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("借用归还-创建归还记录")
   @PutMapping("/return")
   public ResultVO setReturn(@Valid @RequestBody PartyAReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：借用归还-创建归还记录");
      return ResultBuilder.success(this.partyABorrowService.setReturn(param));
   }

   @ApiOperation("借用归还-查询可归还物料")
   @GetMapping("/{id}/return-mat-list")
   public ResultVO list(@PathVariable("id") Long id) {
      log.info("API 调用 ：借用归还-查询可归还物料");
      return ResultBuilder.success(this.partyABorrowService.getMat(id));
   }
}
