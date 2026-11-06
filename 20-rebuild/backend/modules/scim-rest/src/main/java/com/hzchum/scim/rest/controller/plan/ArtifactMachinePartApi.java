package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.plan.core.api.biz.TechArtifactMachinePartBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.MonomerAndProductIdVO;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-零构件")
@RestController
@RequestMapping("/api/plan/artifactMachinePart")
public class ArtifactMachinePartApi {
   private static final Logger log = LoggerFactory.getLogger(ArtifactMachinePartApi.class);
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechArtifactMachinePartBiz artifactMachinePartBiz;

   @ApiOperation(value = "条件 分页 查询 零构件清单 列表", notes = "查询 零构件清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "artifactName", value = "构件名称", paramType = "query"),
            @ApiImplicitParam(name = "artifactSerialNumber", value = "构件编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "machinePartSerialNumber", value = "零件编号", paramType = "query"),
            @ApiImplicitParam(name = "assembleSerialNumber", value = "部件编号", paramType = "query"),
            @ApiImplicitParam(name = "boolMyself", value = "是否只看自己", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.desc"),
            @ApiImplicitParam(name = "boolImportDrawing", value = "是否导入图纸")
      }
   )
   @GetMapping("/listByCondition")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:get')")
   public ResultVO<PageVO<TechArtifactDTO>> PageListArtifactByConditions(
      @RequestParam Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) String artifactName,
      @RequestParam(required = false) String artifactSerialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) String machinePartSerialNumber,
      @RequestParam(required = false) String assembleSerialNumber,
      @RequestParam(required = false) Boolean boolMyself,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(required = false) String userName,
      @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
      @RequestParam(name = "sort", defaultValue = "id.asc") List<String> sort,
      @RequestParam(name = "permissionCheck", required = false) Integer permissionCheck,
      @RequestParam(required = false) Boolean boolImportDrawing
   ) {
      log.info("Api调用: 分页条件查询 零构件清单列表");
      return ResultBuilder.success(
         this.artifactMachinePartBiz
            .listArtifactDTOByConditions(
               areaId,
               areaBatchId,
               artifactName,
               artifactSerialNumber,
               specification,
               material,
               machinePartSerialNumber,
               boolMyself,
               assembleSerialNumber,
               dateTimeList,
               userName,
               pageNumber,
               pageSize,
               sort,
               permissionCheck,
               boolImportDrawing
            )
      );
   }

   @ApiOperation("根据构件id,查询使用零件列表")
   @ApiImplicitParam(name = "artifactId", value = "构件id", paramType = "query", required = true)
   @GetMapping("/listMachinePart")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:get')")
   public ResultVO<ListVO<TechMachinePartDTO>> listMachinePart(@RequestParam Long artifactId) {
      log.info("Api调用: 根据构件id查询零件列表");
      return ResultBuilder.success(new ListVO<>(this.machinePartService.listMachinePartByArtifact(artifactId)));
   }

   @ApiOperation("根据构件id,查询使用零件列表")
   @ApiImplicitParam(name = "artifactId", value = "构件id", paramType = "query", required = true)
   @GetMapping("/app/listMachinePart")
   public ResultVO<ListVO<TechMachinePartDTO>> appListMachinePart(@RequestParam Long artifactId) {
      log.info("Api调用: 根据构件id查询零件列表");
      return ResultBuilder.success(this.machinePartService.appListMachinePart(artifactId));
   }

   @ApiOperation("下载 零构件清单 导入模版")
   @GetMapping("/template/export")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:templateDownLoad')")
   public void exportArtifactPartTemplate(@RequestParam(required = false) Integer mesInventoryProductEnum, HttpServletResponse response) {
      log.info("API 调用 ： 下载 零构件清单 模版文件");
      this.artifactMachinePartBiz.exportArtifactPartTemplate(mesInventoryProductEnum, response);
   }

   @ApiOperation("下载 零构件清单 变更模版")
   @GetMapping("/template/change/export")
   public void exportArtifactPartChangeTemplate(HttpServletResponse response) {
      log.info("API 调用 ： 下载 零构件清单 模版文件");
      this.artifactMachinePartBiz.exportArtifactPartChangeTemplate(response);
   }

   @ApiOperation("根据查询条件,下载 零构件清单")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:download')")
   public void exportArtifactList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String artifactName,
      String artifactSerialNumber,
      String specification,
      String material,
      String machinePartSerialNumber,
      Long userId,
      String assembleSerialNumber,
      HttpServletResponse response
   ) {
      log.info("API 调用 ： 下载 零构件清单");
      this.artifactMachinePartBiz
         .exportArtifactPartList(
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            artifactName,
            artifactSerialNumber,
            specification,
            material,
            machinePartSerialNumber,
            userId,
            assembleSerialNumber,
            response
         );
   }

   @ApiOperation("根据构件id列表,批量删除构件")
   @DeleteMapping("/deleteArtifact")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:del')")
   @SignerCheck(lockKey = "#vo.monomerId", constantKey = "techArtifact", message = "该单体正在发起(变更、导入、删除)中,请稍后刷新页面重试!")
   public ResultVO deleteArtifact(@RequestBody @Valid MonomerAndProductIdVO vo) {
      log.info("Api调用: 删除构件");
      return ResultBuilder.success(this.artifactMachinePartBiz.deleteArtifact(vo));
   }

   @ApiOperation("根据区域id,一键清空构件")
   @DeleteMapping("/clear")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:del')")
   @SignerCheck(lockKey = "#monomerId", constantKey = "techArtifact", message = "该单体正在发起(变更、导入、删除)中,请稍后刷新页面重试!")
   public ResultVO oneClear(@RequestParam Long areaId, @RequestParam Long monomerId, @RequestParam Long areaBatchId) {
      log.info("Api调用: 根据区域id,一键清空构件列表");
      return ResultBuilder.success(this.artifactMachinePartBiz.oneClearArtifact(areaId, monomerId, areaBatchId));
   }

   @ApiOperation("修改构件或者零件的状态")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "类型 1零件 2构件", paramType = "path", required = true),
            @ApiImplicitParam(name = "id", value = "构件或者零件id", paramType = "path", required = true),
            @ApiImplicitParam(name = "status", value = "ture启用 false 暂停", paramType = "query", required = true)
      }
   )
   @PutMapping("/updateStatus/{type}/{id}")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:edit')")
   public ResultVO updateStatus(@PathVariable("type") Integer type, @PathVariable("id") Long id, @RequestParam Boolean status) {
      log.info("Api调用: 修改构件或者零件的状态");
      return ResultBuilder.success(this.artifactMachinePartBiz.updateStatus(type, id, status));
   }
}
