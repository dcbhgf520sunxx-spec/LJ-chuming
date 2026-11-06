package com.hzchum.scim.rest.controller.mes.building.craft;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.craft.MesBuildingPaintCalculateRecordBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintCalculateRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintStructureClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintTechnologyArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintCalculateRecordSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintTechnologyQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintTechnologyArtifactQueryParam;
import com.hzchum.scim.plan.core.api.biz.TechPaintTechnologyBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyArtifactQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-涂装工艺")
@RequestMapping("/api/mes/building/paint/technology")
@RestController
public class MesBuildingPaintCalculateController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingPaintCalculateController.class);
   private final TechPaintTechnologyBiz paintTechnologyBiz;
   private final MesBuildingPaintCalculateRecordBiz paintCalculateRecordBiz;

   @ApiOperation("列表(按项目分组)")
   @GetMapping("/groupByProject/list")
   @PreAuthorize("@permission.check('mes_paint_technology:list')")
   public ResultVO<PageVO<MesBuildingPaintTechnologyProjectGroupDTO>> pageListProjectPaintTechnology(
      MesBuildingPaintTechnologyQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:涂装工艺列表(按项目分组)");
      return ResultBuilder.success(this.paintCalculateRecordBiz.pageListProjectPaintTechnology(param, pageNumber, pageSize));
   }

   @ApiOperation("未计算-构件类型列表")
   @GetMapping("/notCalculate/structureClass/list")
   public ResultVO<ListVO<MesPaintStructureClassDTO>> notCalculateStructureClassList(@RequestParam Long paintTechnologyId) {
      log.info("Api调用:未计算-构件分类列表");
      return ResultBuilder.success(new ListVO<>(this.paintCalculateRecordBiz.getUnCalculateStructureClassList(paintTechnologyId)));
   }

   @ApiOperation("清单表")
   @GetMapping("/related/artifact/list")
   @PreAuthorize("@permission.check('mes_paint_technology:list-detail')")
   public ResultVO<PageVO<TechPaintTechnologyArtifactDTO>> listRelationArtifact(
      @Valid TechPaintTechnologyArtifactQueryParam param,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:涂装工艺关联构件列表");
      return ResultBuilder.success(this.paintTechnologyBiz.getPaintTechnologyArtifactList(param, pageNumber, pageSize));
   }

   @ApiOperation("清单表-打印")
   @GetMapping("/related/artifact/list/print")
   @PreAuthorize("@permission.check('mes_paint_technology:list-print')")
   public ResultVO<PrintVO<List<TechPaintTechnologyArtifactDTO>>> printListRelationArtifact(@RequestParam Long paintTechnologyId) {
      log.info("Api调用:涂装工艺关联构件列表-打印");
      return ResultBuilder.success(this.paintTechnologyBiz.printPaintTechnologyArtifactList(paintTechnologyId));
   }

   @ApiOperation("保存-油漆计算记录")
   @PostMapping("/save/calculate")
   @PreAuthorize("@permission.check('mes_paint_technology:calc-save')")
   public ResultVO<Boolean> savePaintCalculate(@RequestBody @Valid MesBuildingPaintCalculateRecordSaveParam param) {
      log.info("Api调用:保存油漆计算记录");
      return ResultBuilder.success(this.paintCalculateRecordBiz.savePaintCalculateRecord(param));
   }

   @ApiOperation("统计表(油漆计算记录)-删除")
   @DeleteMapping("/paintCalculateRecord/remove")
   @PreAuthorize("@permission.check('mes_paint_technology:stat-del')")
   public ResultVO<Boolean> removePaintCalculateRecord(@RequestBody List<Long> calculateRecordIds) {
      log.info("Api调用:统计表(油漆计算记录)");
      return ResultBuilder.success(this.paintCalculateRecordBiz.removeCalculateRecord(calculateRecordIds));
   }

   @ApiOperation("统计表(油漆计算记录-列表)")
   @GetMapping("/paintCalculateRecord/list")
   @PreAuthorize("@permission.check('mes_paint_technology:stat-detail')")
   public ResultVO<ListVO<MesBuildingPaintCalculateRecordDTO>> listPaintCalculateRecord(@RequestParam Long paintTechnologyId) {
      log.info("Api调用:统计表(油漆计算记录-列表)");
      return ResultBuilder.success(new ListVO<>(this.paintCalculateRecordBiz.listPaintCalculateRecord(paintTechnologyId)));
   }

   @ApiOperation("统计表-单个油漆计算记录-打印")
   @GetMapping("/paintCalculateRecord/print")
   @PreAuthorize("@permission.check('mes_paint_technology:stat-print')")
   public ResultVO<PrintVO<List<MesPaintStructureClassDTO>>> printPaintCalculateRecord(@RequestParam Long calculateRecordId) {
      log.info("Api调用:统计表(油漆计算记录)");
      return ResultBuilder.success(this.paintCalculateRecordBiz.printListPaintCalculateRecord(calculateRecordId));
   }

   @ApiOperation("统计表(油漆计算记录表)-构件类型-构件列表")
   @GetMapping("/paintCalculateRecord/structureClass/artifact/list")
   @PreAuthorize("@permission.check('mes_paint_technology:stat-detail')")
   public ResultVO<PageVO<MesPaintTechnologyArtifactDTO>> listPaintCalculateRecordStructureClassArtifactList(
      MesPaintTechnologyArtifactQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:油漆计算记录-构件类型-构件列表");
      return ResultBuilder.success(this.paintCalculateRecordBiz.calculateRecordArtifactList(param, pageNumber, pageSize));
   }

   @ApiOperation("统计表(油漆计算记录表)-构件类型-构件列表-打印")
   @GetMapping("/paintCalculateRecord/structureClass/artifact/list/print")
   @PreAuthorize("@permission.check('mes_paint_technology:stat-list-print')")
   public ResultVO<PrintVO<List<MesPaintTechnologyArtifactDTO>>> printListPaintCalculateRecordStructureClassArtifactList(
      MesPaintTechnologyArtifactQueryParam param
   ) {
      log.info("Api调用:油漆计算记录-构件类型-构件列表-打印");
      return ResultBuilder.success(this.paintCalculateRecordBiz.printCalculateRecordArtifactList(param));
   }

   public MesBuildingPaintCalculateController(final TechPaintTechnologyBiz paintTechnologyBiz, final MesBuildingPaintCalculateRecordBiz paintCalculateRecordBiz) {
      this.paintTechnologyBiz = paintTechnologyBiz;
      this.paintCalculateRecordBiz = paintCalculateRecordBiz;
   }
}
