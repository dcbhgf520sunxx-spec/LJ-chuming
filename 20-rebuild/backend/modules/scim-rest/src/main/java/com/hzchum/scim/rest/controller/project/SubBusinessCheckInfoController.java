package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.project.core.api.biz.SubBusinessCheckInfoBiz;
import com.hzchum.scim.project.core.api.service.SubBusinessCheckDetailService;
import com.hzchum.scim.project.core.api.service.SubBusinessCheckInfoService;
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

@Api(tags = "分包管理-商务审核")
@RestController
@RequestMapping("/api/sub/business/check")
public class SubBusinessCheckInfoController {
   private static final Logger log = LoggerFactory.getLogger(SubBusinessCheckInfoController.class);
   @Resource
   private SubBusinessCheckInfoService businessCheckInfoService;
   @Resource
   private SubBusinessCheckDetailService businessCheckDetailService;
   @Resource
   private SubBusinessCheckInfoBiz businessCheckInfoBiz;

   @ApiOperation("获取商务审核列表")
   @GetMapping
   public ResultVO list(
      Long projectId, Integer status, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取商务审核列表");
      return ResultBuilder.success(this.businessCheckInfoService.pageInfo(projectId, status, pageNumber, pageSize));
   }

   @ApiOperation("获取商务审核列表数")
   @GetMapping("count")
   public ResultVO count() {
      log.info("API 调用 ：获取商务审核列表数");
      return ResultBuilder.success(this.businessCheckInfoService.countList());
   }

   @ApiOperation("获取商务审核详情")
   @GetMapping("/{id}")
   public ResultVO get(@PathVariable Long id) {
      log.info("API 调用 ：获取商务审核详情");
      return ResultBuilder.success(this.businessCheckDetailService.listByCheckId(id));
   }

   @ApiOperation("审核商务审核列表")
   @PutMapping
   public ResultVO check(@Validated @RequestBody CheckDTOParam request) {
      log.info("API 调用 ：审核商务审核列表");
      return ResultBuilder.success(this.businessCheckInfoBiz.check(request));
   }
}
