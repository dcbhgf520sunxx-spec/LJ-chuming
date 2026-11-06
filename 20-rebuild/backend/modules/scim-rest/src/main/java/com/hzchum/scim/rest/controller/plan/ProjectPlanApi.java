package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-项目计划")
@RequestMapping("/api/plan/project")
@RestController
@Validated
public class ProjectPlanApi {
   private static final Logger log = LoggerFactory.getLogger(ProjectPlanApi.class);
   @Resource
   private ContractProjectBiz contractProjectBiz;

   @ApiOperation("项目计划信息汇总")
   @GetMapping("/getProjectSummaryInfo")
   public ResultVO<ContractProjectInfoDTO> getProjectSummaryInfo() {
      log.info("API 调用 ：项目计划信息汇总");
      return ResultBuilder.success(this.contractProjectBiz.getProjectSummaryInfo());
   }

   public ResultVO<PageVO<ProjectSimpleInfoDTO>> getProjectList(
      Integer status, String noOrName, Integer year, Integer pageNumber, Integer pageSize
   ) {
      return this.getProjectList(status, noOrName, year, pageNumber, pageSize, null, null);
   }

   @ApiOperation("项目计划列表")
   @GetMapping("/getProjectList")
   public ResultVO<PageVO<ProjectSimpleInfoDTO>> getProjectList(
      @RequestParam(value = "status", required = false) Integer status,
      @RequestParam(value = "noOrName", required = false) String noOrName,
      @RequestParam(value = "year", required = false) Integer year,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(value = "projectType", required = false) Integer projectType,
      @RequestParam(value = "lumpSumSystemType", required = false) Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：项目计划列表");
      return ResultBuilder.success(this.contractProjectBiz.getProjectList(status, noOrName, year, pageNumber, pageSize, projectType, lumpSumSystemType));
   }
}
