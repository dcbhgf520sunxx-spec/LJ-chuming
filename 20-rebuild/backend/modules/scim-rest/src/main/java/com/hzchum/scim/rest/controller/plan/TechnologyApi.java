package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectInfoDTO;
import com.hzchum.scim.plan.core.api.biz.TechnologyBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.TechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.CreateDeeperLeaderDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "技术管理-部门任务")
@Validated
@RequestMapping("/api/plan/technology")
@RestController
public class TechnologyApi {
   private static final Logger log = LoggerFactory.getLogger(TechnologyApi.class);
   @Resource
   private ContractProjectBiz contractProjectBiz;
   @Resource
   private TechnologyBiz technologyBiz;

   @ApiOperation(value = "创建单体深化负责人", notes = "根据单体创建深化负责人")
   @PostMapping("")
   public ResultVO createDeepArchivist(@RequestBody CreateDeeperLeaderDTOParam createDeeperLeaderDTOParam) {
      log.info("API 调用 ：根据单体创建深化负责人");
      return ResultBuilder.success(this.technologyBiz.createDeepArchivist(createDeeperLeaderDTOParam));
   }

   @ApiOperation(value = "部门任务列表", notes = "根据年份和项目名称查询部门任务")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query")
      }
   )
   @GetMapping("")
   public ResultVO<PageVO<TechnologyDTO>> pageByYearAndName(
      @RequestParam(required = false) Integer year,
      @RequestParam(required = false) String name,
      @RequestParam(defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "27") Integer lumpSumSystemType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：根据年份和项目名称查询部门任务");
      PageVO<TechnologyDTO> pageVo = this.technologyBiz.pageByYearAndName(year, name, projectType, lumpSumSystemType, pageNumber, pageSize);
      return ResultBuilder.success(pageVo);
   }

   @ApiImplicitParam(name = "year", value = "项目年份 例如 2021", paramType = "query")
   @GetMapping("/getProjectInfo")
   @ApiOperation(value = "任务数据汇总", notes = "任务数据汇总")
   public ResultVO<ContractProjectInfoDTO> departmentTaskDataSummary(
      @RequestParam(required = false) Integer year,
      @RequestParam(defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "27") Integer lumpSumSystemType,
      Integer level
   ) {
      log.info("API 调用 ：查询部门任务数据汇总");
      return ResultBuilder.success(this.contractProjectBiz.getMyProjectInfo(year, projectType, lumpSumSystemType, level));
   }
}
