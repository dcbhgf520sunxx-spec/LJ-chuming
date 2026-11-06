package com.hzchum.scim.rest.controller.mes.building.productionAnalysis;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.productionAnalysis.ProjectMaterialRequisitionAnalysisBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProjectMaterialRequisitionAnalysisDOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-项目领料分析")
@RestController
@RequestMapping("/api/mes/building/project/material/analysis")
public class ProjectMaterialRequisitionAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(ProjectMaterialRequisitionAnalysisController.class);
   @Resource
   private ProjectMaterialRequisitionAnalysisBiz projectMaterialRequisitionAnalysisBiz;

   @ApiOperation("获取项目下构件累计生产量汇总")
   @GetMapping("/production_summary")
   @PreAuthorize("@permission.check('mes_project_material:get')")
   public ResultVO productionCompanySummary(@Valid ProjectMaterialRequisitionAnalysisDOParam param) {
      log.info("API 调用 ：获取项目下构件累计生产量汇总");
      return ResultBuilder.success(this.projectMaterialRequisitionAnalysisBiz.productionCompanySummary(param));
   }

   @ApiOperation("获取项目下零件列表(清单/领料/损耗率)")
   @GetMapping("/part/requisition")
   @PreAuthorize("@permission.check('mes_project_material:get')")
   public ResultVO getProjectPartsAndRequisitionList(@Valid ProjectMaterialRequisitionAnalysisDOParam param) {
      log.info("API 调用 ：获取项目下零件列表(清单/领料/损耗率)");
      return ResultBuilder.success(new ListVO<>(this.projectMaterialRequisitionAnalysisBiz.getProjectPartsAndRequisitionList(param)));
   }
}
