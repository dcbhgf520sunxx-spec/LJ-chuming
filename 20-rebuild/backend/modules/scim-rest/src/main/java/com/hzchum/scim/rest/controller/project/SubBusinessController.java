package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.SubBusinessCheckInfoBiz;
import com.hzchum.scim.project.core.api.service.SubBusinessService;
import com.hzchum.scim.rest.pojo.vo.project.CheckInfoVORequest;
import com.hzchum.scim.rest.pojo.vo.project.SubBusinessConditionVOParam;
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
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "分包管理-商务管理")
@RestController
@RequestMapping("/api/sub/business")
public class SubBusinessController {
   private static final Logger log = LoggerFactory.getLogger(SubBusinessController.class);
   @Resource
   private SubBusinessService subBusinessService;
   @Resource
   private SubBusinessCheckInfoBiz subBusinessCheckInfoBiz;

   @ApiOperation("获取分包商务列表")
   @GetMapping("")
   public ResultVO listArtifact(SubBusinessConditionVOParam param) {
      log.info("API 调用 ：获取分包商务列表");
      return ResultBuilder.success(this.subBusinessService.listByCondition(param));
   }

   @ApiOperation("获取分包商务详情")
   @GetMapping("/{businessId}")
   public ResultVO getArtifact(@PathVariable Long businessId) {
      log.info("API 调用 ：获取分包商务详情");
      return ResultBuilder.success(this.subBusinessService.listByBusinessId(businessId));
   }

   @ApiOperation("设置商务价格")
   @PutMapping
   public ResultVO update(@Validated @RequestBody CheckInfoVORequest request) {
      log.info("API 调用 ：设置商务价格");
      return ResultBuilder.success(this.subBusinessCheckInfoBiz.setUnitPrice(request));
   }
}
