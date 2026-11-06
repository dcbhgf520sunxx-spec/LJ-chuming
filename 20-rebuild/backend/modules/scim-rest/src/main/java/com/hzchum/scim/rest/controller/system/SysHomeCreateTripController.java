package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysHomeCreateTripBiz;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeCreateTripSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-创建行程")
@RestController
@RequestMapping("/api/trip")
public class SysHomeCreateTripController {
   private static final Logger log = LoggerFactory.getLogger(SysHomeCreateTripController.class);
   @Resource
   private SysHomeCreateTripBiz sysHomeCreateTripBiz;

   @ApiOperation("行程创建")
   @PostMapping("/create")
   public ResultVO saveSysHomeCreateTrip(@RequestBody SysHomeCreateTripSaveParam sysHomeCreateTripSaveParam) {
      log.info("API 调用 ：行程创建");
      return ResultBuilder.success(this.sysHomeCreateTripBiz.saveSysHomeCreateTrip(BeanUtil.copy(sysHomeCreateTripSaveParam, SysHomeCreateTripSaveParam.class)));
   }

   @ApiOperation("行程删除")
   @DeleteMapping("/delete")
   public ResultVO deleteSysHomeCreateTrip(@RequestParam Long id) {
      log.info("API 调用 ：行程删除");
      return ResultBuilder.success(this.sysHomeCreateTripBiz.deleteSysHomeCreateTrip(id));
   }

   @ApiOperation("行程列表")
   @GetMapping("/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "createUserName", value = "创建人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "startTime", value = "当月开始时间", paramType = "query", dataType = "LocalDate")
      }
   )
   public ResultVO getSysHomeCreateTripPage(String createUserName, String title, LocalDate startTime) {
      log.info("API调用:行程列表");
      return ResultBuilder.success(this.sysHomeCreateTripBiz.getSysHomeCreateTripPage(createUserName, title, startTime));
   }
}
