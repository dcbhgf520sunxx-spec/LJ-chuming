package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.PaintingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ArtifactPaintingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.PaintingDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.put.ArtifactPaintingSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.put.PaintingSaveVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES涂装计算")
@RestController
@RequestMapping("/api/mes/building/kanban/painting")
public class PaintingController {
   private static final Logger log = LoggerFactory.getLogger(PaintingController.class);
   @Autowired
   private PaintingBiz paintingBiz;

   @ApiOperation("涂装计算设置列表")
   @GetMapping("/setting/list")
   @PreAuthorize("@permission.check('mes_painting:get')")
   public ResultVO settingList(@RequestParam("projectId") Long projectId, @RequestParam(value = "monomerId", required = false) Long monomerId) {
      log.info("API 调用 ：涂装计算列表");
      return ResultBuilder.success(new ListVO<>(this.paintingBiz.settingList(projectId, monomerId)));
   }

   @ApiOperation("涂装计算设置列表")
   @PostMapping("")
   @PreAuthorize("@permission.check('mes_painting:edit')")
   public ResultVO settingPainting(@RequestBody @Valid PaintingSaveVORequest request) {
      log.info("API 调用 ：涂装计算列表");
      return ResultBuilder.success(this.paintingBiz.settingPainting(BeanUtil.copy(request, PaintingDTOParam.class)));
   }

   @ApiOperation("获取单体下各个类型的构件油漆消耗")
   @GetMapping("/type")
   @PreAuthorize("@permission.check('mes_painting:get')")
   public ResultVO artifactTypePainting(@RequestParam("projectId") Long projectId, @RequestParam(value = "monomerId", required = false) Long monomerId) {
      log.info("API 调用 ：获取单体下各个类型的构件油漆消耗");
      return ResultBuilder.success(new ListVO<>(this.paintingBiz.artifactTypePainting(projectId, monomerId)));
   }

   @ApiOperation("获取构件")
   @GetMapping("/artifact/page")
   public ResultVO artifactPage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam("configId") Long configId,
      @RequestParam(value = "areaId", required = false) Long areaId,
      @RequestParam(value = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取构件");
      return ResultBuilder.success(this.paintingBiz.artifactPage(projectId, monomerId, configId, areaId, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("获取构件汇总信息")
   @GetMapping("/artifact/page/summary")
   public ResultVO artifactSummary(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam("configId") Long configId,
      @RequestParam(value = "areaId", required = false) Long areaId,
      @RequestParam(value = "serialNumber", required = false) String serialNumber
   ) {
      log.info("API 调用 ：获取构件汇总信息");
      return ResultBuilder.success(this.paintingBiz.artifactSummary(projectId, monomerId, configId, areaId, serialNumber));
   }

   @ApiOperation("修改构件面积")
   @PostMapping("/artifact")
   @PreAuthorize("@permission.check('mes_painting:editArea')")
   public ResultVO artifactSetting(@RequestBody @Valid List<ArtifactPaintingSaveVORequest> requestList) {
      log.info("API 调用 ：获取构件");
      return ResultBuilder.success(
         this.paintingBiz.artifactSetting(requestList.stream().map(e -> BeanUtil.copy(e, ArtifactPaintingDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("涂装计算列表打印")
   @GetMapping("/print")
   public ResultVO artifactTypePaintingPrint(@RequestParam("projectId") Long projectId, @RequestParam(value = "monomerId", required = false) Long monomerId) {
      log.info("API 调用 ：涂装计算列表打印");
      return ResultBuilder.success(this.paintingBiz.artifactTypePaintingPrint(projectId, monomerId));
   }
}
