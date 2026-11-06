package com.hzchum.scim.rest.controller.mes.building.qhse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.PaintThicknessRecordQueryParam;
import com.hzchum.scim.plan.core.api.service.task.MesBuildingProduceInspectionTeamReportPaintThicknessLinkService;
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

@Api(tags = "油漆厚度检测记录")
@RestController
@RequestMapping("/api/mes/building/paintThickness/check")
public class InspectionTeamReportPaintThicknessController {
   private static final Logger log = LoggerFactory.getLogger(InspectionTeamReportPaintThicknessController.class);
   @Autowired
   private MesBuildingProduceInspectionTeamReportPaintThicknessLinkService paintThicknessLinkService;

   @ApiOperation("油漆厚度检测记录分页")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('paint_film_record:get')")
   public ResultVO getPaintThicknessRecordPage(
      PaintThicknessRecordQueryParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：油漆厚度检测记录分页");
      return ResultBuilder.success(this.paintThicknessLinkService.getPaintThicknessRecordPage(param, pageNumber, pageSize));
   }

   @ApiOperation("油漆厚度检测记录详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('paint_film_record:detail')")
   public ResultVO getPaintThicknessDetail(Long id) {
      log.info("API 调用 ：油漆厚度检测记录详情");
      return ResultBuilder.success(this.paintThicknessLinkService.getPaintThicknessDetail(id));
   }
}
