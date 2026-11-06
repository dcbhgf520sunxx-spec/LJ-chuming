package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWaterElectricityBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityCountDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWaterElectricityDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-水电费")
@RestController
@RequestMapping("/api/contract/water-electricity")
public class WaterElectricityController {
   private static final Logger log = LoggerFactory.getLogger(WaterElectricityController.class);
   @Resource
   private ContractWaterElectricityBiz waterElectricityBiz;

   @ApiOperation("水电费记录-列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份 2022", dataType = "query", required = true),
            @ApiImplicitParam(name = "type", value = "费用类型 1水费 2电费", dataType = "query", required = true),
            @ApiImplicitParam(name = "childType", value = "电费子类型 1工业用电 2民用用电", dataType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('water_electricity_cost:get')")
   public ResultVO<ListVO<ContractWaterElectricityDTO>> list(@RequestParam Integer year, @RequestParam Integer type, Integer childType) {
      log.info("Api调用: 水电费记录列表");
      return ResultBuilder.success(this.waterElectricityBiz.listByCondition(year, type, childType));
   }

   @Validated
   @ApiOperation("水电费记录-新增/修改")
   @PostMapping
   @PreAuthorize("@permission.check('water_electricity_cost:add','water_electricity_cost:edit')")
   public ResultVO saveList(@RequestBody @Valid List<ContractWaterElectricityDtoParam> paramList) {
      log.info("Api调用: 水电费记录录入");
      return ResultBuilder.success(this.waterElectricityBiz.saveList(paramList));
   }

   @ApiOperation("水电费记录-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('water_electricity_cost:del')")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("Api调用: 水电费记录删除");
      return ResultBuilder.success(this.waterElectricityBiz.deleteList(ids));
   }

   @ApiOperation("水电费记录-打印")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('water_electricity_cost:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> printList(@RequestParam Integer year, @RequestParam Integer type, Integer childType) {
      log.info("Api调用:水电费记录列表打印");
      return ResultBuilder.success(this.waterElectricityBiz.printWaterElectricityList(year, type, childType));
   }

   @ApiOperation("运营分析-水电费统计")
   @ApiImplicitParam(name = "year", value = "年份 2022", dataType = "query", required = true)
   @GetMapping("/statistics")
   @PreAuthorize("@permission.check('operation_water_electricity:get')")
   public ResultVO<ListVO<ContractWaterElectricityCountDto>> countWaterElectricity(@RequestParam Integer year) {
      log.info("Api调用:运营分析-水电费统计");
      return ResultBuilder.success(this.waterElectricityBiz.countWaterElectricity(year));
   }

   @ApiOperation("运营分析-水电费统计—导出Excel")
   @ApiImplicitParam(name = "year", value = "年份 2022", dataType = "query", required = true)
   @GetMapping("/exportExcel")
   @PreAuthorize("@permission.check('operation_water_electricity:download')")
   public void exportWaterElectricityExcel(@RequestParam Integer year, HttpServletResponse response) {
      log.info("Api调用:运营分析-水电费统计—导出Excel");
      this.waterElectricityBiz.exportWaterElectricityExcel(year, response);
   }
}
