package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.PaintThicknessBiz;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "漆膜厚度检测配置")
@RestController
@RequestMapping("/api/paint/thickness/config")
public class MesInspectPaintThicknessConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesInspectPaintThicknessConfigController.class);
   @Resource
   private PaintThicknessBiz paintThicknessBiz;

   @GetMapping("/get")
   @PreAuthorize("@permission.check('paint_film_config:get')")
   @ApiOperation("获取漆膜厚度检测配置")
   public ResultVO getPaintThicknessConfig() {
      log.info("Api调用:获取漆膜厚度检测配置");
      return ResultBuilder.success(this.paintThicknessBiz.getPaintThicknessConfig());
   }

   @PutMapping("/set")
   @PreAuthorize("@permission.check('paint_film_config:edit')")
   @ApiOperation("设置漆膜厚度检测配置")
   public ResultVO savePaintThickness(@RequestBody @Validated PaintThicknessDO paintThicknessDO) {
      log.info("Api调用:获取漆膜厚度检测配置");
      return ResultBuilder.success(this.paintThicknessBiz.savePaintThickness(paintThicknessDO));
   }

   @ApiOperation("获取构件油漆类工序")
   @GetMapping("/paintProcess")
   @PreAuthorize("@permission.check('paint_film_config:get')")
   public ResultVO listPaintArtyFactList() {
      log.info("API 调用 ：获取构件油漆类工序");
      return ResultBuilder.success(this.paintThicknessBiz.listPaintArtyFactList());
   }
}
