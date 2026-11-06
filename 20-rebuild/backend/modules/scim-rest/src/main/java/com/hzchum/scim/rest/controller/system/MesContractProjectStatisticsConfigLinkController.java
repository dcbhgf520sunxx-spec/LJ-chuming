package com.hzchum.scim.rest.controller.system;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.biz.MesContractProjectWageConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectStatisticsConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectStatisticsConfigLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价配置-项目统计配置")
@RequestMapping("/api/system/contract-project-statistics-config-link")
@RestController
@Validated
public class MesContractProjectStatisticsConfigLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectStatisticsConfigLinkController.class);
   @Autowired
   private MesContractProjectStatisticsConfigLinkService contractProjectStatisticsConfigLinkService;
   @Autowired
   private MesContractProjectWageConfigBiz wageConfigBiz;
   @Autowired
   private ContractProjectService projectService;

   @ApiOperation("未关联工价配置项目列表")
   @GetMapping("unassociated-project-list")
   public ResultVO unassociatedProjectList() {
      log.info("API 调用 ：未关联工价配置项目列表");
      List<Long> projectIdList = this.contractProjectStatisticsConfigLinkService
         .list(Wrappers.emptyWrapper())
         .stream()
         .map(MesContractProjectStatisticsConfigLink::getContractProjectId)
         .distinct()
         .collect(Collectors.toList());
      List<ContractProject> projectList = this.projectService
         .list(Wrappers.lambdaQuery(ContractProject.class).notIn(CollUtil.isNotEmpty(projectIdList), ContractProject::getId, projectIdList));
      return ResultBuilder.success(new ListVO(projectList.stream().map(p -> BeanUtil.toBean(p, NameInfo.class)).collect(Collectors.toList())));
   }

   @ApiOperation("项目统计配置关联列表")
   @GetMapping("list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "statisticsMode", value = "统计模式", required = true, paramType = "query"),
            @ApiImplicitParam(name = "projectNumberOrName", value = "项目编号/名称", paramType = "query")
      }
   )
   public ResultVO list(
      @RequestParam @EnumValidator(value = StatisticsConfigStatisticsModeEnum.class, message = "统计模式不存在") Integer statisticsMode,
      @RequestParam(required = false) String projectNumberOrName
   ) {
      log.info("API 调用 ：项目统计配置关联列表");
      return ResultBuilder.success(new ListVO<>(this.contractProjectStatisticsConfigLinkService.listInfo(statisticsMode, projectNumberOrName)));
   }

   @ApiOperation("项目统计配置关联分页")
   @GetMapping("page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "statisticsMode", value = "统计模式", required = true, paramType = "query"),
            @ApiImplicitParam(name = "projectNumberOrName", value = "项目编号/名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "20", paramType = "query")
      }
   )
   public ResultVO page(
      @RequestParam @EnumValidator(value = StatisticsConfigStatisticsModeEnum.class, message = "统计模式不存在") Integer statisticsMode,
      @RequestParam(required = false) String projectNumberOrName,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：项目统计配置关联分页");
      return ResultBuilder.success(this.contractProjectStatisticsConfigLinkService.pageInfo(statisticsMode, projectNumberOrName, pageNumber, pageSize));
   }

   @ApiOperation("项目统计配置关联修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectStatisticsConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目统计配置关联修改");
      return ResultBuilder.success(this.contractProjectStatisticsConfigLinkService.updateContractProjectStatisticsConfig(param));
   }

   @ApiOperation("项目工价配置保存")
   @PostMapping("save-config")
   public ResultVO saveConfig(@RequestParam Long projectId) {
      log.info("API 调用 ：项目工价配置保存");
      return ResultBuilder.success(this.wageConfigBiz.saveContractProjectWageConfig(projectId));
   }

   @ApiOperation("项目工价配置删除")
   @DeleteMapping("delete-config")
   public ResultVO deleteConfig(@RequestParam Long projectId) {
      log.info("API 调用 ：项目工价配置删除");
      return ResultBuilder.success(this.wageConfigBiz.deleteContractProjectWageConfig(projectId));
   }
}
