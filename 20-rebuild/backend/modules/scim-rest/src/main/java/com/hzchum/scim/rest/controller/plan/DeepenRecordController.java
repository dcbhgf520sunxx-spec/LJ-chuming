package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordMonthDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserMonthDTO;
import com.hzchum.scim.plan.core.api.service.TechDeepenRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-深化记录")
@RestController
@RequestMapping("/api/plan/deepenRecord")
public class DeepenRecordController {
   private static final Logger log = LoggerFactory.getLogger(DeepenRecordController.class);
   @Resource
   private TechDeepenRecordService deepenRecordService;

   @ApiOperation("查询全年每个月份的深化量")
   @ApiImplicitParam(name = "year", value = "年份 格式:2022", paramType = "query", required = true)
   @GetMapping("/listMonthMete")
   public ResultVO<ListVO<DeepenRecordMonthDTO>> listMonthDeepen(@RequestParam Integer year) {
      log.info("Api调用: 全年每个月份的深化量");
      return ResultBuilder.success(this.deepenRecordService.listDeepenMeteByYear(year));
   }

   @ApiOperation("查询每个项目的深化量")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份 格式:2022", paramType = "query", required = true),
            @ApiImplicitParam(name = "month", value = "月份 格式:10", paramType = "query")
      }
   )
   @GetMapping("/listProjectMete")
   public ResultVO<ListVO<DeepenRecordProjectDTO>> listProjectDeepen(@RequestParam Integer year, Integer month) {
      log.info("Api调用: 每个项目的深化量");
      return ResultBuilder.success(this.deepenRecordService.listProjectDeepenMete(year, month));
   }

   @ApiOperation("查询全年每个人的深化量")
   @ApiImplicitParam(name = "year", value = "年份 格式:2022", paramType = "query", required = true)
   @GetMapping("/listUserMete")
   public ResultVO<ListVO<DeepenRecordUserDTO>> listUserDeepenMete(@RequestParam Integer year) {
      log.info("Api调用: 全年每个用户的深化量");
      return ResultBuilder.success(this.deepenRecordService.listUserDeepenMete(year));
   }

   @ApiOperation("查询每个人当月份和上月份的深化量")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "year", value = "年份 格式:2022", paramType = "query"), @ApiImplicitParam(name = "month", value = "月份 格式:10", paramType = "query")}
   )
   @GetMapping("/listUserMonthMete")
   public ResultVO<ListVO<DeepenRecordUserMonthDTO>> listUserDeepenMete(Integer year, Integer month) {
      log.info("Api调用: 全年每个用户的深化量");
      return ResultBuilder.success(this.deepenRecordService.listUserMonthMete(year, month));
   }

   @ApiOperation("查询所有项目的深化量和计划量")
   @GetMapping("/list")
   @ApiImplicitParam(name = "year", value = "年份 格式:2022", paramType = "query")
   public ResultVO<ListVO<DeepenRecordProjectDTO>> listAllProjectDeepenMete(Integer year) {
      log.info("Api调用: 所有项目的深化量和计划量");
      return ResultBuilder.success(this.deepenRecordService.listProjectDeepen(year));
   }
}
