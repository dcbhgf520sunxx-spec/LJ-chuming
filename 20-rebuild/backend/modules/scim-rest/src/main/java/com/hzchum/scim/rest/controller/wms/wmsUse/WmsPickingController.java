package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.WmsPickingDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "WMS-排产领料信息")
@RestController
@RequestMapping("/api/wms/picking-information")
public class WmsPickingController {
   private static final Logger log = LoggerFactory.getLogger(WmsPickingController.class);
   @Resource
   WmsPickingService wmsPickingService;

   @ApiModelProperty("添加排产领料信息")
   @PostMapping("/saveWmsPicking")
   public ResultVO saveWmsPicking(@RequestBody WmsPickingDTOParam param) {
      log.info("API 调用：添加排产领料信息");
      return ResultBuilder.success(this.wmsPickingService.saveWmsPicking(param));
   }

   @ApiModelProperty("查询排产领料信息")
   @GetMapping("/getWmsPicking")
   @PreAuthorize("@permission.check('wms_mes_receipt_review:get')")
   public ResultVO getWmsPicking(
      WmsPickingDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用：查询排产领料信息");
      return ResultBuilder.success(this.wmsPickingService.getWmsPicking(param, pageNumber, pageSize, sort));
   }

   @ApiModelProperty("根据ID查询排产领料信息明细")
   @GetMapping("/selectById/{id}")
   @PreAuthorize("@permission.check('wms_mes_receipt_review:detail')")
   public ResultVO selectById(@PathVariable("id") Long id) {
      log.info("API 调用：根据ID查询排产领料信息明细");
      return ResultBuilder.success(this.wmsPickingService.selectById(id));
   }

   @ApiModelProperty("根据ID集合查询排产领料信息明细")
   @GetMapping("/getWmsPickingDetail")
   @PreAuthorize("@permission.check('wms_mes_receipt_review:detail')")
   public ResultVO getWmsPickingDetail(@RequestParam(required = false, name = "ids") List<Long> ids) {
      log.info("API 调用：根据ID查询排产领料信息明细");
      return ResultBuilder.success(this.wmsPickingService.getWmsPickingDetail(ids));
   }

   @ApiModelProperty("根据车间查询排产领料信息")
   @GetMapping("/accordingToWorkshopGetWmsPicking")
   public ResultVO accordingToWorkshopGetWmsPicking(
      @RequestParam(required = false, name = "mesWorkshopIds") List<Long> mesWorkshopIds,
      @RequestParam(required = false, name = "materialType") String materialType,
      @RequestParam(required = false, name = "projectId") Long projectId
   ) {
      log.info("API 调用：根据ID查询排产领料信息明细");
      return ResultBuilder.success(this.wmsPickingService.accordingToWorkshopGetWmsPicking(mesWorkshopIds, materialType, projectId));
   }
}
