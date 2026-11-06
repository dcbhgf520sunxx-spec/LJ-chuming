package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.PlanMonomerBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.ModifyAndAddAndDeleteParm;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.PlanMonomerUpdateVORequest;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-单体")
@RestController
@RequestMapping("/api/plan/monomer")
public class MonomerApi {
   private static final Logger log = LoggerFactory.getLogger(MonomerApi.class);
   private final PlanMonomerService monomerService;
   private final PlanMonomerBiz monomerBiz;

   @ApiOperation(value = "单体列表", notes = "分页获取某个项目下面的单体列表", nickname = "63")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('plan_monomer_manage:get')")
   public ResultVO<PageVO<PlanMonomerDTO>> pageByProjectIdAndName(
      @RequestParam Long projectId,
      @RequestParam(required = false) String name,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某个项目下面的单体列表");
      return ResultBuilder.success(this.monomerBiz.pageListMonomer(projectId, name, pageNumber, pageSize));
   }

   @ApiOperation(value = "单体列表", notes = "分页获取某个项目下面的单体列表", nickname = "63")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("/app")
   public ResultVO<PageVO<PlanMonomerDTO>> appPageByProjectIdAndName(
      @RequestParam Long projectId,
      @RequestParam(required = false) String name,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某个项目下面的单体列表");
      return ResultBuilder.success(this.monomerBiz.pageListMonomer(projectId, name, pageNumber, pageSize));
   }

   @ApiOperation(value = "单体简要信息列表", notes = "根据项目id查询单体简要信息列表", nickname = "63")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型 2构件 4围护 8配套件", paramType = "query")
      }
   )
   @GetMapping("/listByProjectId/{projectId}")
   public ResultVO<ListVO<Map<String, Object>>> listSimpleByProjectId(@PathVariable("projectId") Long projectId, Long monomerId, Integer productType) {
      log.info("API 调用 : 根据 项目id 查询 单体简单信息 列表");
      return ResultBuilder.success(this.monomerBiz.listMonomerSimpleByProjectId(projectId, monomerId, productType));
   }

   @ApiOperation(value = "围护单体区域信息列表", notes = "围护单体区域信息列表")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true))
   @GetMapping("/monomer_area/list")
   public ResultVO<ProjectPlanDetailDTO> enclosureMonomerAreaByProjectId(Long projectId) {
      log.info("API 调用 : 根据 项目id 查询 单体简单信息 列表");
      return ResultBuilder.success(this.monomerBiz.enclosureMonomerAreaByProjectId(projectId));
   }

   @ApiOperation(value = "查询一个单体", notes = "查询一个单体信息", nickname = "63")
   @ApiImplicitParam(name = "id", value = "单体id", paramType = "path", required = true)
   @GetMapping("/getById/{id}")
   public ResultVO<PlanMonomerDTO> getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：查询一个单体信息");
      return ResultBuilder.success(this.monomerService.getMonomerById(id));
   }

   @ApiOperation(value = "查看对应项目单体与区域", notes = "查看对应项目单体与区域")
   @GetMapping("/getMonomerAndAreaByProjectId")
   @PreAuthorize("@permission.check('plan_project_plan:get','plan_department_plan:get','plan_monomer_manage:get','sectional_entry_plan:getPlanDetails')")
   public ResultVO<ListVO<PlanMonomerDTO>> getMonomerAndAreaByProjectId(@RequestParam Long projectId) {
      log.info("API 调用 ：查看对应项目单体与区域");
      return ResultBuilder.success(this.monomerBiz.getMonomerAndAreaByProjectId(projectId));
   }

   @ApiOperation(value = "单体,区域修改,新增,删除", notes = "单体,区域修改,新增,删除", nickname = "63")
   @PostMapping("")
   // Mixed batches require every requested action; IDs inside saveVO also require edit rights.
   @PreAuthorize(
      "#p0 != null"
      + " and @permission.check('plan_project_plan:add','plan_project_plan:edit','plan_project_plan:del','plan_monomer_manage:add','plan_monomer_manage:edit','plan_monomer_manage:del','plan_area_manage:add','plan_area_manage:edit','plan_area_manage:del')"
      + " and (#p0.saveVO == null or #p0.saveVO.?[id == null].isEmpty() or @permission.check('plan_project_plan:add','plan_monomer_manage:add'))"
      + " and (#p0.saveVO == null or #p0.saveVO.?[id != null].isEmpty() or @permission.check('plan_project_plan:edit','plan_monomer_manage:edit'))"
      + " and (#p0.saveVO == null or #p0.saveVO.?[id != null and areaList != null and !areaList.?[id == null].isEmpty()].isEmpty() or @permission.check('plan_project_plan:add','plan_area_manage:add'))"
      + " and (#p0.saveVO == null or #p0.saveVO.?[areaList != null and !areaList.?[id != null].isEmpty()].isEmpty() or @permission.check('plan_project_plan:edit','plan_area_manage:edit'))"
      + " and (#p0.updateMonomerVO == null or #p0.updateMonomerVO.isEmpty() or @permission.check('plan_project_plan:edit','plan_monomer_manage:edit'))"
      + " and (#p0.updateAreaVO == null or #p0.updateAreaVO.isEmpty() or @permission.check('plan_project_plan:edit','plan_area_manage:edit'))"
      + " and (#p0.deleteMonomerVO == null or #p0.deleteMonomerVO.isEmpty() or @permission.check('plan_project_plan:del','plan_monomer_manage:del'))"
      + " and (#p0.deleteAreaVO == null or #p0.deleteAreaVO.isEmpty() or @permission.check('plan_project_plan:del','plan_area_manage:del'))"
   )
   public ResultVO modifyAndAddAndDelete(@RequestBody ModifyAndAddAndDeleteParm modifyAndAddAndDeleteParm) {
      log.info("API 调用 ：单体,区域修改,新增,删除");
      return ResultBuilder.success(this.monomerBiz.modifyAndAddAndDelete(modifyAndAddAndDeleteParm));
   }

   @ApiOperation(value = "修改单体", nickname = "63")
   @PutMapping("")
   @PreAuthorize("@permission.check('plan_monomer_manage:edit','plan_monomer_manage:productTypeEdit','plan_monomer_manage:productTypeDel')")
   public ResultVO updateMonomer(@Valid @RequestBody PlanMonomerUpdateVORequest requestVO) {
      log.info("API 调用 ： 更新单体的信息");
      return ResultBuilder.success(this.monomerBiz.updateMonomer(requestVO));
   }

   @ApiOperation(value = "删除单体", notes = "根据 单体id列表 删除单体列表", nickname = "63")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('plan_monomer_manage:del')")
   public ResultVO removeMonomer(@RequestBody List<Long> ids) {
      log.info("API 调用 ：根据id删除单体");
      return ResultBuilder.success(this.monomerBiz.removeMonomer(ids));
   }

   @ApiOperation(value = "根据单体id 查询单体里吨数大于0的产品类型和完成日期", nickname = "63")
   @ApiImplicitParam(name = "id", value = "单体id", paramType = "path", required = true)
   @GetMapping("/listProductTypeListById/{id}")
   public ResultVO<PlanMonomerSimpleDTO> listMonomerProductTypeList(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据单体id 查询单体里吨数大于0的产品类型和完成日期");
      return ResultBuilder.success(this.monomerBiz.getMonomerSimpleById(id));
   }

   @ApiOperation("根据项目id,查询单体-区域树")
   @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true)
   @GetMapping("/getTreeByProjectId/{projectId}")
   public ResultVO<ListVO<Map<String, Object>>> listByProjectId(@PathVariable("projectId") Long projectId) {
      log.info("API 调用 : 根据项目id查询单体区域树");
      return ResultBuilder.success(new ListVO<>(this.monomerBiz.listSimpleByProjectId(projectId)));
   }

   public MonomerApi(final PlanMonomerService monomerService, final PlanMonomerBiz monomerBiz) {
      this.monomerService = monomerService;
      this.monomerBiz = monomerBiz;
   }
}
