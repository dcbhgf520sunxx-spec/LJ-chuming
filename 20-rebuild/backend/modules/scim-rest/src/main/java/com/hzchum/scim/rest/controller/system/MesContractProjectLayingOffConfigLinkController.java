package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectLayingOffConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkService;
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

@Api(tags = "项目工价配置-下料配置")
@RequestMapping("/api/system/project-laying-off-config")
@RestController
@Validated
public class MesContractProjectLayingOffConfigLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectLayingOffConfigLinkController.class);
   @Autowired
   private MesContractProjectLayingOffConfigLinkService layingOffConfigLinkService;

   @ApiOperation("分页")
   @GetMapping("page")
   public ResultVO page(
      @RequestParam Long projectId,
      @RequestParam @EnumValidator(value = StatisticsConfigStatisticsModeEnum.class, message = "统计配置-统计模式不存在") Integer statisticsConfigStatisticsMode,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：项目工价配置-下料配置分页");
      return ResultBuilder.success(this.layingOffConfigLinkService.pageInfo(projectId, statisticsConfigStatisticsMode, pageNumber, pageSize, sort));
   }

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO list(
      @RequestParam Long projectId,
      @RequestParam @EnumValidator(value = StatisticsConfigStatisticsModeEnum.class, message = "统计配置-统计模式不存在") Integer statisticsConfigStatisticsMode
   ) {
      log.info("API 调用 ：项目工价配置-下料配置列表");
      return ResultBuilder.success(new ListVO<>(this.layingOffConfigLinkService.listInfo(projectId, statisticsConfigStatisticsMode)));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-下料配置列表");
      return ResultBuilder.success(this.layingOffConfigLinkService.detailById(id));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectLayingOffConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-下料配置新增");
      return ResultBuilder.success(this.layingOffConfigLinkService.saveConfig(param));
   }

   @ApiOperation("批量新增")
   @PostMapping("batch-save")
   public ResultVO batchSave(@RequestBody @Validated(Add.class) ValidList<MesContractProjectLayingOffConfigLinkSaveDTOParam> paramList) {
      log.info("API 调用 ：项目工价配置-下料配置批量新增");
      return ResultBuilder.success(this.layingOffConfigLinkService.batchSaveConfig(paramList));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectLayingOffConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-下料配置修改");
      return ResultBuilder.success(this.layingOffConfigLinkService.updateContractProjectLayingOffConfigLink(param));
   }

   @ApiOperation("批量删除")
   @DeleteMapping("batch-delete")
   public ResultVO batchDelete(@RequestBody @NotEmpty(message = "idList不能为空") List<Long> idList) {
      log.info("API 调用 ：项目工价配置-下料配置批量删除");
      return ResultBuilder.success(this.layingOffConfigLinkService.batchDelete(idList));
   }
}
