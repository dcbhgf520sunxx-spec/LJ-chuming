package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechArtifactBiz;
import com.hzchum.scim.plan.core.api.biz.TechArtifactSpecAmendBiz;
import com.hzchum.scim.plan.core.api.manager.TechMesWmsManager;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactNoSchedulingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactRemarkUpdateDtoParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-构件")
@Validated
@RequestMapping("/api/plan/artifact")
@RestController
public class ArtifactApi {
   private static final Logger log = LoggerFactory.getLogger(ArtifactApi.class);
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechArtifactBiz artifactBiz;
   @Resource
   private TechArtifactSpecAmendBiz artifactSpecAmendBiz;
   @Resource
   private TechMesWmsManager techMesWmsManager;

   @ApiOperation(value = "构件清单列表", notes = "构件清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "构件名称", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "构件规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "构件材质", paramType = "query"),
            @ApiImplicitParam(name = "boolSchedulingEnum", value = "能否排产 true可排产 false不可排产", dataType = "Boolean", paramType = "query"),
            @ApiImplicitParam(name = "batchNumber", value = "批次", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = true, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = true, defaultValue = "10"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query")
      }
   )
   @GetMapping("/listByCondition")
   @PreAuthorize("@permission.check('plan_artifact_list:get','projectPlanList','product_progress:detail')")
   public ResultVO<PageVO<ArtifactResponseDTO>> listPageArtifactByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      Integer status,
      String name,
      String serialNumber,
      String specification,
      String material,
      Boolean boolSchedulingEnum,
      @RequestParam(required = false) String batchNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false, name = "sort", defaultValue = "id.desc") List<String> sort,
      @RequestParam(name = "permissionCheck", required = false) Integer permissionCheck
   ) {
      log.info("API调用：构件清单列表");
      PageVO<ArtifactResponseDTO> pageVO = this.artifactBiz
         .ListByConditions(
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            status,
            name,
            serialNumber,
            specification,
            material,
            boolSchedulingEnum,
            pageNumber,
            pageSize,
            sort,
            permissionCheck
         );
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("根据构件id 查询构件信息")
   @ApiImplicitParam(name = "id", value = "构件id", paramType = "path", required = true)
   @GetMapping("/getById/{id}")
   public ResultVO<ArtifactDTO> getArtifactById(@PathVariable("id") Long id) {
      log.info("Api调用: 根据构件id查询构件信息");
      return ResultBuilder.success(this.artifactService.getInfoById(id));
   }

   @ApiOperation("构件详情")
   @GetMapping("info")
   public ResultVO artifactInfo(Long monomerId, Long areaId, @RequestParam String serialNumber) {
      log.info("API 调用 ：构件详情");
      return ResultBuilder.success(this.artifactService.getInfo(monomerId, areaId, serialNumber));
   }

   @ApiOperation("构件规格修正列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "oldSpecification", value = "原规格", paramType = "query"),
            @ApiImplicitParam(name = "newSpecification", value = "修正后规格", paramType = "query"),
            @ApiImplicitParam(name = "boolAmendStatus", value = "修正状态 false未修正 true已修正", paramType = "query")
      }
   )
   @GetMapping("/list-specAmend")
   @PreAuthorize("@permission.check('artifact-specification-revise:get')")
   public ResultVO<PageVO<TechArtifactSpecAmendDTO>> listArtifactSpecAmend(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String oldSpecification,
      String newSpecification,
      String specification,
      Boolean boolAmendStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("构件规格修正列表");
      return ResultBuilder.success(
         this.artifactSpecAmendBiz
            .listSpecAmend(
               projectId, monomerId, areaId, name, serialNumber, oldSpecification, newSpecification, specification, boolAmendStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("构件规格修正规格列表")
   @GetMapping("/list-spec")
   public ResultVO listArtifactSpec(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String oldSpecification, String newSpecification, Boolean boolAmendStatus
   ) {
      log.info("构件规格修正列表");
      return ResultBuilder.success(
         this.artifactSpecAmendBiz.listArtifactSpec(projectId, monomerId, areaId, name, serialNumber, oldSpecification, newSpecification, boolAmendStatus)
      );
   }

   @ApiOperation("批量修正规格")
   @PutMapping("/save-specAmend")
   @PreAuthorize("@permission.check('artifact-specification-revise:edit')")
   public ResultVO saveSpecAmend(@RequestBody @Valid List<TechArtifactSpecAmendUpdateDTOParam> paramList) {
      log.info("Api调用: 批量构件修正规格");
      return ResultBuilder.success(this.artifactSpecAmendBiz.amendArtifactSpec(paramList));
   }

   @ApiOperation(value = "下载构件清单列表", notes = "下载构件清单列表")
   @GetMapping("/listByCondition/downLoad")
   public ResultVO listPageArtifactByConditionDownLoad(
      @RequestParam("areaId") Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      HttpServletResponse response
   ) {
      log.info("API 调用 ： 下载构件清单列表");
      return ResultBuilder.success(
         this.artifactService.listByConditionsDownLoad(areaId, areaBatchId, status, name, serialNumber, specification, material, response)
      );
   }

   @ApiOperation(value = "获取构件清单汇总", notes = "获取构件清单汇总")
   @GetMapping("/listByCondition/summary")
   public ResultVO listPageArtifactByConditionSummary(
      @RequestParam("areaId") Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material
   ) {
      log.info("API 调用 ： 获取构件清单汇总");
      return ResultBuilder.success(this.artifactService.listByConditionsSummary(areaId, areaBatchId, status, name, serialNumber, specification, material));
   }

   @ApiOperation("修改-构件备注")
   @PutMapping("/updateRemark")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:edit')")
   public ResultVO updateArtifactRemark(@RequestBody @Valid List<ArtifactRemarkUpdateDtoParam> paramList) {
      log.info("Api调用:修改构件备注");
      return ResultBuilder.success(this.artifactBiz.updateArtifactRemark(paramList));
   }

   @ApiOperation("app构件树-根据构件编号搜索")
   @GetMapping("/getArtifactListBySerialNumber")
   public ResultVO getArtifactListBySerialNumber(
      @RequestParam String serialNumber,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用:app构件树-根据构件编号搜索");
      return ResultBuilder.success(this.artifactBiz.getArtifactListBySerialNumber(serialNumber, pageNumber, pageSize, projectId, monomerId, areaId));
   }

   @ApiOperation("涂装工艺-根据项目ID和构件种类ID查询列表")
   @GetMapping("/list-by-project-id-and-structure-class-id")
   public ResultVO listByProjectIdAndStructureClassId(
      @RequestParam Long projectId,
      @RequestParam Long structureClassId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material
   ) {
      log.info("Api调用:涂装工艺-根据项目ID和构件种类ID查询列表");
      return ResultBuilder.success(
         this.artifactBiz.listByProjectIdAndStructureClassId(projectId, structureClassId, name, serialNumber, specification, material)
      );
   }

   @ApiOperation(value = "获取构件未排产列表", notes = "获取构件未排产列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "构件名称", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "构件规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "构件材质", paramType = "query"),
            @ApiImplicitParam(name = "structureClassId", value = "构件种类Id", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = true, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = true, defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query")
      }
   )
   @GetMapping("/no/scheduling/listByCondition")
   public ResultVO<PageVO<PlanArtifactNoSchedulingDTO>> listPageArtifactNoSchedulingByCondition(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) Long structureClassId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API调用：获取构件未排产列表");
      return ResultBuilder.success(
         this.techMesWmsManager
            .listPageArtifactNoSchedulingByCondition(
               projectId, monomerId, areaId, name, serialNumber, specification, material, structureClassId, pageNumber, pageSize, sort
            )
      );
   }
}
