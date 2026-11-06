package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWaterElectricityPropertyFeeBiz;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWaterElectricityPropertyFeeSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-水、电、物业费")
@RestController
@RequestMapping("/api/contract/water-electricity-property-fee")
public class ContractWaterElectricityPropertyFeeController {
   private static final Logger log = LoggerFactory.getLogger(ContractWaterElectricityPropertyFeeController.class);
   @Autowired
   private ContractWaterElectricityPropertyFeeBiz waterElectricityPropertyFeeBiz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('water_electricity_property_cost:get')")
   public ResultVO page(
      @ApiParam("年份") Integer year,
      @ApiParam("类型(1: 水, 2: 电, 3: 物业)") Integer type,
      @ApiParam("费用归属") Long branchCompanyId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(defaultValue = "id.asc") List<String> sort
   ) {
      log.info("API调用: 水、电、物业费-分页查询");
      return ResultBuilder.success(this.waterElectricityPropertyFeeBiz.pageInfo(year, type, branchCompanyId, pageNumber, pageSize, sort));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('water_electricity_property_cost:add')")
   public ResultVO save(@RequestBody @Validated(Add.class) ContractWaterElectricityPropertyFeeSaveParam param) {
      log.info("API调用: 水、电、物业费-新增");
      return ResultBuilder.success(this.waterElectricityPropertyFeeBiz.saveInfo(param));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('water_electricity_property_cost:edit')")
   public ResultVO update(@RequestBody @Validated(Update.class) ContractWaterElectricityPropertyFeeSaveParam param) {
      log.info("API调用: 水、电、物业费-修改");
      return ResultBuilder.success(this.waterElectricityPropertyFeeBiz.updateInfo(param));
   }

   @ApiOperation("修改状态")
   @PutMapping("/update-status")
   @PreAuthorize("@permission.check('water_electricity_property_cost:edit')")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean boolStatus) {
      log.info("API调用: 水、电、物业费-修改状态");
      return ResultBuilder.success(this.waterElectricityPropertyFeeBiz.updateStatus(id, boolStatus));
   }

   @ApiOperation("删除")
   @DeleteMapping("/{id}")
   @PreAuthorize("@permission.check('water_electricity_property_cost:del')")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API调用: 水、电、物业费-根据ID删除");
      return ResultBuilder.success(this.waterElectricityPropertyFeeBiz.deleteById(id));
   }

   @ApiOperation("水电费统计")
   @GetMapping("water-electricity-fee-statistics")
   public ResultVO waterElectricityFeeStatistics(@RequestParam Integer year) {
      log.info("API调用: 水电费统计");
      return ResultBuilder.success(new ListVO<>(this.waterElectricityPropertyFeeBiz.waterElectricityFeeStatistics(year)));
   }

   @ApiOperation("水电费统计导出")
   @GetMapping("water-electricity-fee-statistics/export")
   public void waterElectricityFeeStatisticsExport(@RequestParam Integer year, HttpServletResponse response) {
      log.info("API调用: 水电费统计导出");
      this.waterElectricityPropertyFeeBiz.waterElectricityFeeStatisticsExport(year, response);
   }
}
