package com.hzchum.scim.rest.controller.business;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessProductionControlCheckInfoBiz;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlCheckInfoService;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "成本管理-生产控制审核")
@RestController
@RequestMapping("/api/production/control/check")
public class BusinessProductionControlCheckController {
   private static final Logger log = LoggerFactory.getLogger(BusinessProductionControlCheckController.class);
   @Resource
   private BusinessProductionControlCheckInfoService businessProductionControlCheckInfoService;
   @Resource
   private BusinessProductionControlCheckDetailService businessProductionControlCheckDetailService;
   @Resource
   private BusinessProductionControlCheckInfoBiz businessProductionControlCheckInfoBiz;

   @ApiOperation("获取生产控制审核列表")
   @GetMapping
   public ResultVO list(Integer status, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize) {
      log.info("API 调用 ：获取生产控制审核列表");
      return ResultBuilder.success(this.businessProductionControlCheckInfoService.pageInfo(status, pageNumber, pageSize));
   }

   @ApiOperation("获取商务修改记录数")
   @GetMapping("count")
   public ResultVO count() {
      log.info("API 调用 ：获取商务修改记录数");
      return ResultBuilder.success(this.businessProductionControlCheckInfoService.countList());
   }

   @ApiOperation("获取生产控制审核详情")
   @GetMapping("/{id}")
   public ResultVO get(@PathVariable Long id) {
      log.info("API 调用 ：获取生产控制审核详情");
      return ResultBuilder.success(this.businessProductionControlCheckDetailService.listByCheckId(id));
   }

   @ApiOperation("审核生产控制审核")
   @PutMapping
   public ResultVO check(@Validated @RequestBody CheckDTOParam request) {
      log.info("API 调用 ：审核生产控制审核");
      return ResultBuilder.success(this.businessProductionControlCheckInfoBiz.check(request));
   }
}
