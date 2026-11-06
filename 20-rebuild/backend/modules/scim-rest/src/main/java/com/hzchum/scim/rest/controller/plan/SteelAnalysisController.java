package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-钢材分析")
@RestController
@RequestMapping("/api/steel/analysis")
public class SteelAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(SteelAnalysisController.class);
   @Autowired
   private SysSteelAnalysisBiz sysSteelAnalysisBiz;

   @ApiOperation("钢材使用用量对比")
   @GetMapping
   public ResultVO analysis(@RequestParam Long projectId, @RequestParam(required = false) List<Long> monomerIds) {
      log.info("API 调用 ：钢材使用用量对比");
      return ResultBuilder.success(this.sysSteelAnalysisBiz.analysis(projectId, monomerIds, null, null));
   }
}
