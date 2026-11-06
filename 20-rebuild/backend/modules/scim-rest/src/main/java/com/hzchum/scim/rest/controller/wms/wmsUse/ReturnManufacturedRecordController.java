package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnManufacturedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-制成品退库申请")
@RestController
@RequestMapping("/api/wms/return/manufactured/application")
public class ReturnManufacturedRecordController {
   private static final Logger log = LoggerFactory.getLogger(ReturnManufacturedRecordController.class);
   @Autowired
   private ReturnManufacturedService returnManufacturedService;

   @ApiOperation("根据条件分页查询制成品退货记录")
   @GetMapping("/record")
   public ResultVO list(
      QueryReturnManufacturedDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询制成品退货记录");
      return ResultBuilder.success(this.returnManufacturedService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据条件分页查询制成品退库明细记录")
   @GetMapping("/record/detail")
   @PreAuthorize("@permission.check('wms_report_manuf_return_details:get')")
   public ResultVO listDetail(
      QueryReturnManufacturedDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询制成品退库明细记录");
      return ResultBuilder.success(this.returnManufacturedService.pageInfoDetail(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID获取制成品退库清单")
   @GetMapping("/record/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_Manuf_return_review:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取制成品退库清单");
      return ResultBuilder.success(this.returnManufacturedService.getReturnById(id));
   }
}
