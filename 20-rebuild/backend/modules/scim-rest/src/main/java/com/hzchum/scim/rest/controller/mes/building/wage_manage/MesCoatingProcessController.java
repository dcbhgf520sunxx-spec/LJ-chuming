package com.hzchum.scim.rest.controller.mes.building.wage_manage;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesCoatingProcessSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesCoatingProcessService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工艺管理-涂装工艺")
@RequestMapping("/api/mes/building/wage-manage/coating-process")
@RestController
@Validated
public class MesCoatingProcessController {
   private static final Logger log = LoggerFactory.getLogger(MesCoatingProcessController.class);
   @Autowired
   private MesCoatingProcessService mesCoatingProcessService;

   @ApiOperation("涂装工艺-构件类型列表")
   @GetMapping("artifact-type-list")
   public ResultVO artifactTypeList(@RequestParam Long projectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId) {
      log.info("API 调用 ：涂装工艺-构件类型列表");
      return ResultBuilder.success(new ListVO<>(this.mesCoatingProcessService.artifactTypeList(projectId, monomerId, areaId)));
   }

   @ApiOperation("涂装工艺-构件清单列表")
   @GetMapping("artifact-list")
   public ResultVO artifactList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Long artifactTypeId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：涂装工艺-构件清单列表");
      return ResultBuilder.success(
         this.mesCoatingProcessService
            .artifactList(projectId, monomerId, areaId, artifactTypeId, name, serialNumber, specification, material, pageNumber, pageSize)
      );
   }

   @ApiOperation("涂装工艺列表")
   @GetMapping("list")
   public ResultVO list(@RequestParam Long contractProjectId) {
      log.info("API 调用 ：涂装工艺列表");
      return ResultBuilder.success(new ListVO<>(this.mesCoatingProcessService.listInfo(contractProjectId)));
   }

   @ApiOperation("涂装工艺列表下载")
   @GetMapping("list/print")
   public ResultVO listPrint(@RequestParam Long contractProjectId) {
      log.info("API 调用 ：涂装工艺列表下载");
      return ResultBuilder.success(this.mesCoatingProcessService.listPrint(contractProjectId));
   }

   @ApiOperation("涂装工艺详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：涂装工艺详情");
      return ResultBuilder.success(this.mesCoatingProcessService.detailById(id));
   }

   @ApiOperation("涂装工艺新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesCoatingProcessSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：涂装工艺新增");
      return ResultBuilder.success(this.mesCoatingProcessService.saveCoatingProcess(saveDTOParam));
   }

   @ApiOperation("涂装工艺编辑")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesCoatingProcessSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：涂装工艺编辑");
      return ResultBuilder.success(this.mesCoatingProcessService.updateCoatingProcess(saveDTOParam));
   }

   @ApiOperation("涂装工艺删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：涂装工艺删除");
      return ResultBuilder.success(this.mesCoatingProcessService.deleteById(id));
   }

   @ApiOperation("涂装工艺清单列表")
   @GetMapping("coating-process-artifact-list")
   public ResultVO coatingProcessArtifactList(
      @RequestParam Long id,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material
   ) {
      log.info("API 调用 ：涂装工艺清单列表");
      return ResultBuilder.success(new ListVO<>(this.mesCoatingProcessService.coatingProcessArtifactList(id, name, serialNumber, specification, material)));
   }

   @ApiOperation("涂装工艺清单详情分页")
   @GetMapping("coating-process-artifact-detail-page")
   public ResultVO coatingProcessArtifactDetailPage(
      @RequestParam Long id,
      @RequestParam Long artifactId,
      @RequestParam BigDecimal area,
      @RequestParam(required = false) Boolean boolTask,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：涂装工艺清单详情分页");
      return ResultBuilder.success(this.mesCoatingProcessService.coatingProcessArtifactDetailPage(id, artifactId, area, boolTask, pageNumber, pageSize));
   }

   @ApiOperation("涂装工艺清单详情删除")
   @DeleteMapping("coating-process-artifact-detail-delete")
   public ResultVO coatingProcessArtifactDetailDelete(@RequestParam Long coatingProcessId, @RequestBody List<Long> ids) {
      log.info("API 调用 ：涂装工艺清单详情删除");
      return ResultBuilder.success(this.mesCoatingProcessService.coatingProcessArtifactDetailDelete(coatingProcessId, ids));
   }

   @ApiOperation("涂装工艺-修改清单")
   @PutMapping("edit-artifact-list")
   public ResultVO editArtifactList(@RequestBody @Validated(Update.class) MesCoatingProcessSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：涂装工艺-修改清单");
      return ResultBuilder.success(this.mesCoatingProcessService.editArtifactList(saveDTOParam));
   }

   @ApiOperation("涂装工艺-增加清单")
   @PutMapping("add-artifact-list")
   public ResultVO addArtifactList(@RequestBody @Validated(Update.class) MesCoatingProcessSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：涂装工艺-增加清单");
      return ResultBuilder.success(this.mesCoatingProcessService.addArtifactList(saveDTOParam));
   }

   @ApiOperation("涂装工艺-删除清单")
   @DeleteMapping("delete-artifact")
   public ResultVO deleteArtifact(@RequestBody @Validated(Update.class) MesCoatingProcessSaveDTOParam saveDTOParam) {
      log.info("API 调用 ：涂装工艺-删除清单");
      return ResultBuilder.success(this.mesCoatingProcessService.deleteArtifact(saveDTOParam));
   }

   @ApiOperation("涂装工艺-无需涂装")
   @PutMapping("no-painting-required")
   public ResultVO noPaintingRequired(@RequestBody List<TechArtifact> artifactList) {
      log.info("API 调用 ：涂装工艺-无需涂装");
      return ResultBuilder.success(this.mesCoatingProcessService.noPaintingRequired(artifactList));
   }
}
