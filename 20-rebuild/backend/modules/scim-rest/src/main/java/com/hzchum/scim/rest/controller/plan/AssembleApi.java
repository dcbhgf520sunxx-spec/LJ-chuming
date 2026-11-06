package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechAssembleBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleArtifactSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleDTO;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-组立")
@RequestMapping("/api/plan/assemble")
@RestController
public class AssembleApi {
   private static final Logger log = LoggerFactory.getLogger(AssembleApi.class);
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechAssembleBiz assembleBiz;

   @ApiOperation(value = "下载组立清单模板", notes = "下载组立清单模板")
   @GetMapping("/download")
   public void downloadTemplate() {
      log.info("Api调用: 下载组立清单模板");
      this.assembleService.downloadTemplate();
   }

   @ApiOperation(value = "组立清单列表", notes = "组立清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "serialNumber.asc")
      }
   )
   @GetMapping("/listAssemble")
   @PreAuthorize("@permission.check('plan_assembly_list:get')")
   public ResultVO listAssembleByConditions(
      @RequestParam Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(defaultValue = "id.asc") List<String> sort,
      @RequestParam(name = "permissionCheck", required = false) Integer permissionCheck
   ) {
      log.info("Api调用: 查询组立清单列表");
      PageVO pageVO = this.assembleBiz
         .pageListByCondition(areaId, areaBatchId, serialNumber, specification, material, pageNumber, pageSize, sort, permissionCheck);
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("根据区域id,获取所有异常组立编号")
   @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query", required = true)
   @GetMapping("/listAbnormal")
   public ResultVO listAbnormalAssembleSn(@RequestParam Long areaId) {
      log.info("Api调用: 根据区域id,获取所有异常组立编号");
      ListVO<String> listAbnormalAssemble = this.assembleService.listAbnormalAssemble(areaId);
      return ResultBuilder.success(listAbnormalAssemble);
   }

   @ApiOperation(value = "导出 组立清单列表", notes = "根据条件查询组立清单 导出")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "areaId", value = "区域Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query")
      }
   )
   @GetMapping("/export")
   @PreAuthorize("@permission.check('plan_assembly_list:download')")
   public void exportAssembles(
      @RequestParam Long areaId,
      @RequestParam(required = false) Long areabatchId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      HttpServletResponse response
   ) {
      log.info("Api调用: 导出 组立清单列表");
      this.assembleBiz.exportAssembles(areaId, areabatchId, serialNumber, specification, material, response);
   }

   @ApiOperation(value = "删除组立", notes = "删除组立")
   @ApiImplicitParam(name = "id", value = "组立id", paramType = "path", required = true)
   @DeleteMapping("/deleteAssemble/{id}")
   public ResultVO deleteAssemble(@PathVariable Long id) {
      log.info("Api调用 : 删除组立");
      return ResultBuilder.success(this.assembleService.deleteAssembleById(id));
   }

   @ApiOperation(value = "批量删除组立", notes = "批量删除组立")
   @DeleteMapping("/deleteAssembleList")
   public ResultVO deleteAssembleList(@RequestBody List<Long> ids) {
      log.info("Api调用 : 批量删除组立");
      return ResultBuilder.success(this.assembleService.deleteByIdList(ids));
   }

   @ApiOperation("根据区域id,一键清空组立列表(未排产的)")
   @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query", required = true)
   @DeleteMapping("/clear")
   public ResultVO clearAssembles(@RequestParam Long areaId) {
      log.info("Api调用 : 根据区域id,一键清空未排产的组立列表");
      return ResultBuilder.success(this.assembleService.clearAssembles(areaId));
   }

   @ApiOperation(value = "删除组立下的构件", notes = "解除组立和构件的关联")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "assembleId", value = "组立id", paramType = "query", required = true),
            @ApiImplicitParam(name = "artifactNo", value = "构件编号", paramType = "query", required = true)
      }
   )
   @DeleteMapping("/deleteArtifact")
   public ResultVO deleteAssembleArtifact(@RequestParam Long assembleId, @RequestParam String artifactNo) {
      log.info("Api调用 : 删除组立下的构件");
      return ResultBuilder.success(this.assembleService.deleteAssembleArtifact(assembleId, artifactNo));
   }

   @ApiOperation(value = "新增组立的构件", notes = "新增组立的构件")
   @PostMapping("/saveArtifact")
   public ResultVO saveAssembleArtifact(@RequestBody @Valid AssembleArtifactSaveDTOParam saveDTOParam) {
      log.info("Api调用 : 新增组立的构件");
      return ResultBuilder.success(this.assembleService.insertAssembleArtifact(saveDTOParam));
   }

   @ApiOperation(value = "根据组立id查询组立信息", notes = "根据组立id查询组立信息")
   @ApiImplicitParam(name = "id", value = "组立id", paramType = "path", required = true)
   @GetMapping("/app/getById/{id}")
   public ResultVO<AssembleDTO> getAssembleInfoById(@PathVariable("id") Long id) {
      log.info("app端 Api调用: 根据组立id查询组立信息");
      return ResultBuilder.success(this.assembleService.getAssembleById(id));
   }
}
