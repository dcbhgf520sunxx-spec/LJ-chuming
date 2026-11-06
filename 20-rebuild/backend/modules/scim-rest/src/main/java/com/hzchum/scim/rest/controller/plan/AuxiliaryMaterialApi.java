package com.hzchum.scim.rest.controller.plan;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechAuxiliaryMaterialBiz;
import com.hzchum.scim.plan.core.api.biz.TechStandardPartBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDetailDTO;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import com.hzchum.scim.project.core.api.biz.ProjectAuxiliaryMaterialClassBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAuxiliaryMaterialClassDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-配套件")
@RequestMapping("/api/plan/auxiliaryMaterial")
@RestController
public class AuxiliaryMaterialApi {
   private static final Logger log = LoggerFactory.getLogger(AuxiliaryMaterialApi.class);
   @Resource
   private TechAuxiliaryMaterialService auxiliaryMaterialService;
   @Resource
   private TechAuxiliaryMaterialBiz auxiliaryMaterialBiz;
   @Resource
   ProjectAuxiliaryMaterialClassBiz auxiliaryMaterialClassBiz;
   @Resource
   private TechStandardPartBiz techStandardPartBiz;

   @ApiOperation("分页查询 配套件辅材列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "classifyName", value = "科目名称", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.desc")
      }
   )
   @GetMapping("/listPage")
   public ResultVO<PageVO<AuxiliaryMaterialDTO>> listPage(
      @RequestParam Long projectId,
      Long monomerId,
      String classifyName,
      String serialNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id.desc") List<String> sort
   ) {
      log.info("Api调用: 条件分页查询 配套件列表");
      return ResultBuilder.success(
         this.auxiliaryMaterialService.listAuxiliaryMaterials(projectId, monomerId, classifyName, serialNumber, pageNumber, pageSize, sort)
      );
   }

   @ApiOperation("批量新增配套件(辅材)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true)
      }
   )
   @PostMapping("/save")
   public ResultVO saveAuxiliaryMaterial(
      @RequestParam Long projectId, @RequestParam Long monomerId, @RequestBody @Valid List<AuxiliaryMaterialSaveDTOParam> saveDTOParamList
   ) {
      log.info("Api调用: 批量新增-配套件(辅材)");
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Preconditions.checkArgument(currentUser != null, "添加失败,无法获取到用户token!");
      return ResultBuilder.success(this.auxiliaryMaterialService.saveAuxiliaryMaterial(projectId, monomerId, saveDTOParamList));
   }

   @ApiOperation("修改配套件(辅材)")
   @PutMapping("/update")
   public ResultVO updateAuxiliaryMaterial(@RequestBody @Valid AuxiliaryMaterialUpdateDTOParam updateDTOParam) {
      log.info("Api调用: 修改-配套件(辅材)");
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Preconditions.checkArgument(currentUser != null, "修改失败,无法获取到用户token!");
      return ResultBuilder.success(this.auxiliaryMaterialService.updateAuxiliaryMaterial(updateDTOParam));
   }

   @ApiOperation("根据id列表 删除配套件辅材")
   @DeleteMapping("/delete")
   public ResultVO deleteAuxiliaryMaterials(@RequestParam Long projectId, @RequestBody List<Long> ids) {
      log.info("Api调用: 根据id列表 删除配套件辅材");
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Preconditions.checkArgument(currentUser != null, "删除失败,无法获取到用户token!");
      return ResultBuilder.success(this.auxiliaryMaterialService.deleteAuxiliaryMaterials(projectId, ids));
   }

   @ApiOperation("查询配套件详情")
   @GetMapping("/app/id/{id}")
   public ResultVO<TechStandardPartDetailDTO> getById(@PathVariable Long id) {
      log.info("Api调用:根据配套件ID,查询配套件详情");
      return ResultBuilder.success(this.techStandardPartBiz.getTechStandardPartById(id));
   }

   @ApiOperation("配套件分类-列表")
   @GetMapping("/class-list")
   public ResultVO<PageVO<ProjectAuxiliaryMaterialClassDTO>> listClass(
      @RequestParam Long projectId,
      String classifyName,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 项目配套件分类-列表");
      return ResultBuilder.success(this.auxiliaryMaterialClassBiz.list(projectId, classifyName, pageNumber, pageSize));
   }
}
