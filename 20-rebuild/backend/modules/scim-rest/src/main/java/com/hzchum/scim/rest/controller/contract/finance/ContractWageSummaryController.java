package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWageSummaryBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWageSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWageSummaryDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-人员工资")
@RestController
@RequestMapping("/api/contract/wage-summary")
public class ContractWageSummaryController {
   private static final Logger log = LoggerFactory.getLogger(ContractWageSummaryController.class);
   @Resource
   private ContractWageSummaryBiz wageSummaryBiz;

   @ApiOperation("工资统计-列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份 2022", dataType = "query", required = true),
            @ApiImplicitParam(name = "wageType", value = "工资类型 1管理人员工资 2生产人员工资", dataType = "query", required = true)
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('salary_cost:get')")
   public ResultVO<ListVO<ContractWageSummaryDTO>> list(@RequestParam Integer year, @RequestParam Integer wageType) {
      log.info("Api调用:工资统计列表");
      return ResultBuilder.success(this.wageSummaryBiz.listByCondition(year, wageType));
   }

   @ApiOperation("工资统计-新增/修改")
   @PostMapping
   @PreAuthorize("@permission.check('salary_cost:add','salary_cost:edit')")
   public ResultVO saveList(@RequestBody @Valid List<ContractWageSummaryDtoParam> paramList) {
      log.info("Api调用:工资统计列表");
      return ResultBuilder.success(this.wageSummaryBiz.saveList(paramList));
   }

   @ApiOperation("工资统计-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('salary_cost:del')")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("Api调用:工资统计记录删除");
      return ResultBuilder.success(this.wageSummaryBiz.deleteList(ids));
   }

   @ApiOperation("工资统计-列表打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('salary_cost:print')")
   public ResultVO printList(@RequestParam Integer year, @RequestParam Integer wageType) {
      log.info("Api调用:工资统计列表打印");
      return ResultBuilder.success(this.wageSummaryBiz.printList(year, wageType));
   }
}
