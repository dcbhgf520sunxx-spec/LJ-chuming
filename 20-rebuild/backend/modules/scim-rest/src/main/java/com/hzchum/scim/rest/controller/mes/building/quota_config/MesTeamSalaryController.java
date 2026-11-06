package com.hzchum.scim.rest.controller.mes.building.quota_config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesTeamSalaryBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesTeamSalaryQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "班组工资")
@RequestMapping("/api/mes/building/quota-config/team-salary")
public class MesTeamSalaryController {
   private static final Logger log = LoggerFactory.getLogger(MesTeamSalaryController.class);
   @Autowired
   private MesTeamSalaryBiz biz;

   @ApiOperation("汇总")
   @GetMapping("summary")
   @PreAuthorize("@permission.check('mes_group_payroll_summary:get')")
   public ResultVO summary(MesTeamSalaryQuery query) {
      log.info("API调用: 班组工资-汇总");
      return ResultBuilder.success(this.biz.summary(query));
   }

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('mes_group_payroll_summary:get')")
   public ResultVO pageInfo(
      MesTeamSalaryQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 班组工资-分页");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("打印")
   @GetMapping("print")
   @PreAuthorize("@permission.check('mes_group_payroll_summary:groupPayrollSummaryPrint')")
   public ResultVO print(MesTeamSalaryQuery query) {
      log.info("API调用: 班组工资-打印");
      return ResultBuilder.success(this.biz.print(query));
   }

   @ApiOperation("班组产量列表")
   @GetMapping("team-production-list")
   @PreAuthorize("@permission.check('mes_group_payroll_summary:details')")
   public ResultVO teamProductionList(MesTeamSalaryQuery query) {
      log.info("API调用: 班组工资-班组产量列表");
      return ResultBuilder.success(this.biz.teamProductionList(query));
   }

   @ApiOperation("班组产量列表打印")
   @GetMapping("team-production-list/print")
   @PreAuthorize("@permission.check('mes_group_payroll_summary:detailsPrint')")
   public ResultVO teamProductionListPrint(MesTeamSalaryQuery query) {
      log.info("API调用: 班组工资-班组产量列表打印");
      return ResultBuilder.success(this.biz.teamProductionListPrint(query));
   }
}
