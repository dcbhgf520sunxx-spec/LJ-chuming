package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.biz.TechProductSummaryBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-清单合计")
@RestController
@RequestMapping("/api/plan/product")
public class TechProductSummaryApi {
   private static final Logger log = LoggerFactory.getLogger(TechProductSummaryApi.class);
   @Autowired
   private TechProductSummaryBiz productSummaryBiz;

   @ApiOperation("清单合计-项目构件")
   @GetMapping("/artifact/project")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageProjectArtifactSummary(@RequestParam Long projectId, @RequestParam(name = "permissionCheck", required = false) Integer permissionCheck) {
      log.info("API 调用 ： 清单合计-项目构件");
      return ResultBuilder.success(this.productSummaryBiz.summaryProduct(projectId, null, ProductTypeEnum.ARTIFACT.getType(), null, permissionCheck));
   }

   @ApiOperation("清单合计-项目")
   @GetMapping("/project/sum")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageProjectSummary(@RequestParam Long projectId, @RequestParam Integer productType) {
      log.info("API 调用 ： 清单合计-项目");
      return ResultBuilder.success(this.productSummaryBiz.summaryProject(projectId, productType));
   }

   @ApiOperation("清单合计-单体构件")
   @GetMapping("/artifact/monomer")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageMonomerArtifactSummary(@RequestParam Long monomerId) {
      log.info("API 调用 ： 清单合计-单体构件");
      return ResultBuilder.success(this.productSummaryBiz.summaryProduct(null, monomerId, ProductTypeEnum.ARTIFACT.getType(), null, null));
   }

   @ApiOperation("清单合计-项目围护")
   @GetMapping("/enclosure/project")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageProjectEnclosureSummary(@RequestParam Long projectId, @RequestParam Integer category) {
      log.info("API 调用 ： 清单合计-项目围护");
      return ResultBuilder.success(this.productSummaryBiz.summaryProduct(projectId, null, ProductTypeEnum.ENCLOSURE.getType(), category, null));
   }

   @ApiOperation("清单合计-单体围护")
   @GetMapping("/enclosure/monomer")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageMonomerEnclosureSummary(@RequestParam Long monomerId, @RequestParam Integer category) {
      log.info("API 调用 ： 清单合计-单体围护");
      return ResultBuilder.success(this.productSummaryBiz.summaryProduct(null, monomerId, ProductTypeEnum.ENCLOSURE.getType(), category, null));
   }

   @ApiOperation("清单合计-项目零件")
   @GetMapping("/part/project")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageProjectMachinePartSummary(@RequestParam Long projectId, @RequestParam Integer permissionCheck) {
      log.info("API 调用 ： 清单合计-项目零件");
      return ResultBuilder.success(this.productSummaryBiz.summaryProduct(projectId, null, ProductTypeEnum.MACHINE_PART.getType(), null, permissionCheck));
   }

   @ApiOperation("清单合计-单体零件")
   @GetMapping("/part/monomer")
   @PreAuthorize("@permission.check('summary_list:get')")
   public ResultVO pageMonomerMachinePartSummary(@RequestParam Long monomerId) {
      log.info("API 调用 ： 清单合计-单体零件");
      return ResultBuilder.success(this.productSummaryBiz.summaryProduct(null, monomerId, ProductTypeEnum.MACHINE_PART.getType(), null, null));
   }
}
