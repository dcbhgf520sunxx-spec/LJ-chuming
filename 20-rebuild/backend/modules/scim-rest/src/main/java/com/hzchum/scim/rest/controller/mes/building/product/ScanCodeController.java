package com.hzchum.scim.rest.controller.mes.building.product;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskScanCodeBiz;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-产品扫码")
@RestController
@RequestMapping("/api/plan/qr/info")
public class ScanCodeController {
   private static final Logger log = LoggerFactory.getLogger(ScanCodeController.class);
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingTaskScanCodeBiz taskScanCodeBiz;
   @Autowired
   private TechAuxiliaryMaterialService auxiliaryMaterialService;

   @ApiOperation("构件信息")
   @GetMapping("artifact/{productId}")
   public ResultVO getArtifactTask(@PathVariable Long productId) {
      log.info("API 调用 ：构件信息");
      return ResultBuilder.success(this.taskBiz.getArtifactTask(productId));
   }

   @ApiOperation("产品信息V2")
   @GetMapping("product/task/v2")
   public ResultVO getProductTaskV2(
      @RequestParam(required = false) Long taskId,
      @RequestParam(required = false) Long productId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Integer number
   ) {
      log.info("API 调用 ：产品信息V2");
      return ResultBuilder.success(this.taskScanCodeBiz.getProductTaskV2(taskId, productId, productType, number));
   }

   @ApiOperation("产品信息V2")
   @GetMapping("product/task/v3")
   public ResultVO getProductTaskV3(
      @RequestParam(required = false) Long taskId,
      @RequestParam(required = false) Long productId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Integer number
   ) {
      log.info("API 调用 ：产品信息V2");
      return ResultBuilder.success(this.taskScanCodeBiz.getProductTaskV3(taskId, productId, productType, number));
   }

   @ApiOperation("围护信息")
   @GetMapping("enclosure/{productId}")
   public ResultVO getEnclosureTask(@PathVariable Long productId) {
      log.info("API 调用 ：围护信息");
      return ResultBuilder.success(this.taskBiz.getEnclosureTask(productId));
   }

   @ApiOperation("新围护信息")
   @GetMapping("/v2/enclosure/{productId}")
   public ResultVO getEnclosureTaskV2(@PathVariable Long productId) {
      log.info("API 调用 ：新围护信息");
      return ResultBuilder.success(this.taskBiz.getEnclosureTaskV2(productId));
   }

   @ApiOperation("辅材信息")
   @GetMapping("auxiliary-material/{productId}")
   public ResultVO getAuxiliaryMaterial(@PathVariable Long productId) {
      log.info("API 调用 ：辅材信息");
      return ResultBuilder.success(this.auxiliaryMaterialService.getInfoById(productId));
   }

   @ApiOperation("构件喷码信息")
   @GetMapping("artifact/marking/{productId}")
   public ResultVO getArtifactMarkingTask(@PathVariable Long productId) {
      log.info("API 调用 ：构件喷码信息");
      return ResultBuilder.success(this.taskScanCodeBiz.getArtifactMarkingTask(productId));
   }

   @ApiOperation("部件喷码信息")
   @GetMapping("assemble/marking/{productId}")
   public ResultVO getAssembleMarkingTask(@PathVariable Long productId) {
      log.info("API 调用 ：构件喷码信息");
      return ResultBuilder.success(this.taskScanCodeBiz.getAssembleMarkingTask(productId));
   }
}
