package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechPaintTechnologyBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyArtifactQueryParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologySaveParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "技术管理-涂装工艺")
@RequestMapping("/api/tech/paintTechnology")
@RestController
public class TechPaintTechnologyController {
   private static final Logger log = LoggerFactory.getLogger(TechPaintTechnologyController.class);
   private final TechPaintTechnologyBiz paintTechnologyBiz;

   @ApiOperation("涂装工艺-列表(按项目分组)")
   @GetMapping("/page/list")
   @PreAuthorize("@permission.check('paint_technology:get')")
   public ResultVO<PageVO<TechPaintTechnologyProjectGroupDTO>> getPaintTechnologyProjectList(
      TechPaintTechnologyQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:获取涂装工艺列表");
      return ResultBuilder.success(this.paintTechnologyBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("未创建涂装工艺-构件列表")
   @GetMapping("/available/artifact/list")
   public ResultVO<PageVO<TechPaintTechnologyArtifactDTO>> getUnPaintTechnologyArtifactList(
      TechPaintTechnologyArtifactQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:获取未创建涂装工艺构件列表");
      return ResultBuilder.success(this.paintTechnologyBiz.getUnPaintTechnologyArtifactList(param, pageNumber, pageSize));
   }

   @ApiOperation("涂装工艺-关联构件列表")
   @GetMapping("/related/artifact/list")
   public ResultVO<PageVO<TechPaintTechnologyArtifactDTO>> getPaintTechnologyArtifactList(
      @Valid TechPaintTechnologyArtifactQueryParam param,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "100000") Integer pageSize
   ) {
      log.info("Api调用:获取涂装工艺关联构件列表");
      return ResultBuilder.success(this.paintTechnologyBiz.getPaintTechnologyArtifactList(param, pageNumber, pageSize));
   }

   @ApiOperation("项目内-涂装工艺-列表")
   @GetMapping("/project/list")
   public ResultVO<ListVO<TechPaintTechnologyDTO>> getListByProject(@RequestParam Long projectId) {
      log.info("Api调用:获取项目内全部涂装工艺");
      return ResultBuilder.success(new ListVO<>(this.paintTechnologyBiz.getProjectPaintTechnologyList(projectId)));
   }

   @ApiOperation("涂装工艺-新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('paint_technology:add')")
   public ResultVO<Boolean> save(@RequestBody @Valid TechPaintTechnologySaveParam param) {
      log.info("Api调用:新增涂装工艺");
      return ResultBuilder.success(this.paintTechnologyBiz.savePaintTechnology(param));
   }

   @ApiOperation("涂装工艺-修改")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('paint_technology:edit')")
   public ResultVO<Boolean> update(@RequestBody @Valid TechPaintTechnologyUpdateParam param) {
      log.info("Api调用:修改涂装工艺");
      return ResultBuilder.success(this.paintTechnologyBiz.updatePaintTechnology(param));
   }

   @ApiOperation("涂装工艺-删除")
   @DeleteMapping("/delete/{id}")
   @PreAuthorize("@permission.check('paint_technology:del')")
   public ResultVO<Boolean> delete(@PathVariable Long id) {
      log.info("Api调用:删除涂装工艺");
      return ResultBuilder.success(this.paintTechnologyBiz.removePaintTechnology(id));
   }

   public TechPaintTechnologyController(final TechPaintTechnologyBiz paintTechnologyBiz) {
      this.paintTechnologyBiz = paintTechnologyBiz;
   }
}
