package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.pojo.dto.TechDataLogDTO;
import com.hzchum.scim.plan.core.api.service.TechDataLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "计划管理-技术资料日志")
@RequestMapping("api/plan/techDataLog")
public class TechDataLogApi {
   private static final Logger log = LoggerFactory.getLogger(TechDataLogApi.class);
   @Resource
   private TechDataLogService dataLogService;

   @ApiOperation("分页查询技术资料日志列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "startDate", value = "开始日期(年月日)", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期(年月日)", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "操作人", paramType = "query"),
            @ApiImplicitParam(name = "operationType", value = "操作类型 1导入 2替换 4删除 8下载", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/listPage")
   public ResultVO<PageVO<TechDataLogDTO>> listPages(
      LocalDate startDate,
      LocalDate endDate,
      String userName,
      Integer operationType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 分页查询技术资料日志列表");
      return ResultBuilder.success(this.dataLogService.listDataLogs(startDate, endDate, userName, operationType, pageNumber, pageSize));
   }
}
