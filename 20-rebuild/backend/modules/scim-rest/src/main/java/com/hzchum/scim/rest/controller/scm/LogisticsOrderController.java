package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.QueryLogisticsOrderDTOParam;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "scm-物流订单")
@RestController
@RequestMapping("/api/scm/logistics-order")
public class LogisticsOrderController {
   private static final Logger log = LoggerFactory.getLogger(LogisticsOrderController.class);
   @Resource
   private LogisticsOrderService logisticsOrderService;

   @ApiOperation("查询物流订单")
   @GetMapping
   @PreAuthorize("@permission.check('scm_logisticsOrder:get')")
   public ResultVO simple(
      QueryLogisticsOrderDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：查询物流订单");
      return ResultBuilder.success(this.logisticsOrderService.pageInfo(param, pageNumber, pageSize));
   }
}
