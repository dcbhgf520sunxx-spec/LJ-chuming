package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo.request.MesDrillHoleConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesDrillHoleConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价配置-钻孔配置")
@RequestMapping("/api/system/drill-hole-config")
@RestController
@Validated
public class MesDrillHoleConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesDrillHoleConfigController.class);
   @Autowired
   private MesDrillHoleConfigService drillHoleConfigService;

   @ApiOperation("钻孔配置分页")
   @GetMapping("page")
   public ResultVO page(
      @RequestParam @EnumValidator(value = StatisticsConfigStatisticsModeEnum.class, message = "统计配置-统计模式不存在") Integer statisticsConfigStatisticsMode,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：钻孔配置分页");
      return ResultBuilder.success(this.drillHoleConfigService.pageInfo(statisticsConfigStatisticsMode, pageNumber, pageSize));
   }

   @ApiOperation("钻孔配置列表")
   @GetMapping("list")
   public ResultVO list(
      @RequestParam @EnumValidator(value = StatisticsConfigStatisticsModeEnum.class, message = "统计配置-统计模式不存在") Integer statisticsConfigStatisticsMode
   ) {
      log.info("API 调用 ：钻孔配置列表");
      return ResultBuilder.success(new ListVO<>(this.drillHoleConfigService.listInfo(statisticsConfigStatisticsMode)));
   }

   @ApiOperation("钻孔配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：钻孔配置列表");
      return ResultBuilder.success(this.drillHoleConfigService.detailById(id));
   }

   @ApiOperation("钻孔配置新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesDrillHoleConfigSaveDTOParam param) {
      log.info("API 调用 ：钻孔配置新增");
      return ResultBuilder.success(this.drillHoleConfigService.saveDrillHoleConfig(param));
   }

   @ApiOperation("钻孔配置批量新增")
   @PostMapping("batch-save")
   public ResultVO batchSave(@RequestBody @Validated(Add.class) ValidList<MesDrillHoleConfigSaveDTOParam> paramList) {
      log.info("API 调用 ：钻孔配置批量新增");
      return ResultBuilder.success(this.drillHoleConfigService.batchSaveDrillHoleConfig(paramList));
   }

   @ApiOperation("钻孔配置修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesDrillHoleConfigSaveDTOParam param) {
      log.info("API 调用 ：钻孔配置修改");
      return ResultBuilder.success(this.drillHoleConfigService.updateDrillHoleConfig(param));
   }

   @ApiOperation("钻孔配置批量删除")
   @DeleteMapping("batch-delete")
   public ResultVO batchDelete(@RequestBody @NotEmpty(message = "idList不能为空") List<Long> idList) {
      log.info("API 调用 ：组焊配置批量删除");
      return ResultBuilder.success(this.drillHoleConfigService.batchDelete(idList));
   }
}
