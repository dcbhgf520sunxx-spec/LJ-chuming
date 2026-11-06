package com.hzchum.scim.rest.controller.business;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessCheckInfoBiz;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商务管理-商务审核")
@RestController
@RequestMapping("/api/business/check")
public class BusinessCheckInfoController {
   private static final Logger log = LoggerFactory.getLogger(BusinessCheckInfoController.class);
   @Resource
   private BusinessCheckInfoService businessCheckInfoService;
   @Resource
   private BusinessCheckDetailService businessCheckDetailService;
   @Resource
   private BusinessCheckInfoBiz businessCheckInfoBiz;

   @ApiOperation("获取商务修改记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "类型 1建钢直发件 2构件 4围护 8配套件(标准件,成品件) 16桥梁-分段件(临时定义类型)", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "审核状态 1未审核 2已通过 4已驳回 ", paramType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('sale_price_manage:modify')")
   public ResultVO list(
      Long projectId,
      Integer type,
      Integer status,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取商务修改记录");
      return ResultBuilder.success(this.businessCheckInfoService.listInfo(projectId, type, status, dateTimeList, pageNumber, pageSize));
   }

   @ApiOperation("获取商务修改记录excel")
   @ApiImplicitParams(@ApiImplicitParam(name = "type", value = "类型 1建钢直发件 2构件 4围护 8配套件(标准件,成品件) 16桥梁-分段件(临时定义类型)", paramType = "query"))
   @GetMapping("excel")
   public void listExcel(Long projectId, Integer type, HttpServletResponse response) {
      log.info("API 调用 ：获取商务修改记录excel");
      this.businessCheckInfoService.listExcel(projectId, type, response);
   }

   @ApiOperation("获取商务修改记录数")
   @GetMapping("count")
   public ResultVO count() {
      log.info("API 调用 ：获取商务修改记录数");
      return ResultBuilder.success(this.businessCheckInfoService.countList());
   }

   @ApiOperation("获取商务修改详情")
   @GetMapping("/{checkId}")
   @PreAuthorize("@permission.check('sale_price_manage:detail')")
   public ResultVO get(@PathVariable Long checkId) {
      log.info("API 调用 ：获取商务修改详情");
      return ResultBuilder.success(this.businessCheckDetailService.listByCheckId(checkId));
   }

   @ApiOperation("审核商务修改记录")
   @PutMapping
   @PreAuthorize("@permission.check('sale_price_manage:audit')")
   public ResultVO check(@Validated @RequestBody CheckDTOParam request) {
      log.info("API 调用 ：审核商务修改记录");
      return ResultBuilder.success(this.businessCheckInfoBiz.check(request));
   }
}
