package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.service.ShrUserChangeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-用户")
@RestController
@RequestMapping("/api/shrUserChangeRecord")
public class ShrUserChangeRecordApi {
   private static final Logger log = LoggerFactory.getLogger(ShrUserChangeRecordApi.class);
   @Autowired
   private ShrUserChangeRecordService userChangeRecordService;

   @ApiOperation("列表-SHR用户变化记录")
   @GetMapping("/getChangeRecordAll")
   public Result pageUser(
      String deptName,
      String jobName,
      String name,
      String phone,
      Integer userType,
      Integer crudType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ： 根据项目id，用户名，状态分页获取公司职员列表");
      return ResultGenerator.genSuccessResult(this.userChangeRecordService.getAll(deptName, jobName, name, phone, userType, crudType, pageNumber, pageSize));
   }

   public ShrUserChangeRecordApi(final ShrUserChangeRecordService userChangeRecordService) {
      this.userChangeRecordService = userChangeRecordService;
   }
}
