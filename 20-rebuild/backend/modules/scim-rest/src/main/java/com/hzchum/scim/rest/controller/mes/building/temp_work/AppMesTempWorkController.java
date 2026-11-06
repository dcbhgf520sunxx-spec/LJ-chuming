package com.hzchum.scim.rest.controller.mes.building.temp_work;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.temp_work.MesTempWorkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-点工管理")
@RestController
@RequestMapping("/api/app/mes/temp-work")
public class AppMesTempWorkController {
   private static final Logger log = LoggerFactory.getLogger(AppMesTempWorkController.class);
   @Autowired
   private MesTempWorkBiz tempWorkBiz;

   @ApiOperation("我的点工")
   @GetMapping("my-temp-work")
   public ResultVO myTempWork(
      @RequestParam LocalDate startDate,
      @RequestParam LocalDate endDate,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, defaultValue = "approvalStatus.asc,id.desc") List<String> sort
   ) {
      log.info("API 调用 ：我的点工");
      return ResultBuilder.success(this.tempWorkBiz.myTempWork(startDate, endDate, pageNumber, pageSize, sort));
   }

   @ApiOperation("点工详情")
   @GetMapping("detail")
   public ResultVO detail(@RequestParam Long id) {
      log.info("API 调用 ：点工详情");
      return ResultBuilder.success(this.tempWorkBiz.tempWorkDetail(id));
   }

   @ApiOperation("点工详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：点工详情");
      return ResultBuilder.success(this.tempWorkBiz.tempWorkDetail(id));
   }

   @ApiOperation("新增点工")
   @PostMapping
   public ResultVO add(@RequestBody @Validated MesTempWorkParam param) {
      log.info("API 调用 ：新增点工");
      return ResultBuilder.success(this.tempWorkBiz.add(param));
   }

   @ApiOperation("我的审批")
   @GetMapping("my-approval")
   public ResultVO myApproval(
      @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false, defaultValue = "id.desc") List<String> sort
   ) {
      log.info("API 调用 ：我的审批");
      return ResultBuilder.success(this.tempWorkBiz.myTempWorkApproval(pageNumber, pageSize, sort));
   }

   @ApiOperation("审批记录")
   @GetMapping("approval-record")
   public ResultVO approvalRecord(
      @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false, defaultValue = "id.desc") List<String> sort
   ) {
      log.info("API 调用 ：审批记录");
      return ResultBuilder.success(this.tempWorkBiz.approvalRecord(pageNumber, pageSize, sort));
   }

   @ApiOperation("点工审批详情")
   @GetMapping("approval-detail")
   public ResultVO approvalDetail(@RequestParam Long id) {
      log.info("API 调用 ：点工审批详情");
      return ResultBuilder.success(this.tempWorkBiz.tempWorkApprovalDetail(id));
   }

   @ApiOperation("审批")
   @PostMapping("approval")
   public ResultVO approval(@RequestBody MesTempWorkApprovalParam param) {
      log.info("API 调用 ：审批");
      return ResultBuilder.success(this.tempWorkBiz.approval(param));
   }
}
