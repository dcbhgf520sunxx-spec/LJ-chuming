package com.hzchum.scim.rest.controller.plan;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.biz.TechStandardPartBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartUpdateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.StandardPartSaveVoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechStandardPartQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "计划管理-标准件(构件)")
@RestController
@Validated
@RequestMapping("/api/plan/standardPart")
public class StandardPartController {
   private static final Logger log = LoggerFactory.getLogger(StandardPartController.class);
   private final TechStandardPartBiz standardPartBiz;

   @ApiOperation("标准件-列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "useProperty", value = "使用属性 1工地 2工厂", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "measureUnit", value = "单位", paramType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('plan_standard_part:get')")
   public ResultVO<PageVO<TechStandardPartDTO>> pageList(
      @Valid TechStandardPartQueryVoParam param,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(name = "permissionCheck", required = false) Integer permissionCheck
   ) {
      log.info("Api调用:标准件列表");
      TechStandardPartQueryDtoParam dtoParam = BeanUtil.copy(param, TechStandardPartQueryDtoParam.class);
      dtoParam.setRelationType(ProductTypeEnum.ARTIFACT.getType());
      return ResultBuilder.success(this.standardPartBiz.pageListByCondition(dtoParam, pageNumber, pageSize, permissionCheck));
   }

   @ApiOperation("下载配套件表单")
   @GetMapping("/downloadlist")
   @PreAuthorize("@permission.check('plan_standard_part:get')")
   public Boolean DownList(@Valid TechStandardPartQueryVoParam param, HttpServletResponse response) {
      log.info("Api调用:下载配套件表单");
      TechStandardPartQueryDtoParam dtoParam = BeanUtil.copy(param, TechStandardPartQueryDtoParam.class);
      Preconditions.checkArgument(dtoParam.getRelationType() != null, "请选择标准件类型");
      return this.standardPartBiz.exportStandardPartList(dtoParam, response);
   }

   @ApiOperation("下载标准件模板")
   @GetMapping("/download-template")
   @PreAuthorize("@permission.check('plan_standard_part:templateDownload')")
   public void DownloadTemplate(HttpServletResponse response) {
      log.info("Api调用:下载标准件模板");
      this.standardPartBiz.exportStandardPartTemplate(response);
   }

   @ApiOperation("导入-标准件")
   @PostMapping("/import")
   @PreAuthorize("@permission.check('plan_standard_part:import')")
   public void Import(@RequestPart MultipartFile file, @Valid TechStandardPartImportDtoParam param, HttpServletResponse response) {
      log.info("Api调用:导入-构件标准件");
      TechStandardPartImportDtoParam dtoParam = BeanUtil.copy(param, TechStandardPartImportDtoParam.class);
      dtoParam.setProductType(ProductTypeEnum.ARTIFACT.getType());
      this.standardPartBiz.importStandardPart(file, dtoParam, response);
   }

   @ApiOperation("标准件-新增")
   @PostMapping
   @PreAuthorize("@permission.check('plan_standard_part:add')")
   public ResultVO saveList(@RequestBody @Valid StandardPartSaveVoParam param) {
      log.info("Api调用:手动新增-标准件");
      return ResultBuilder.success(this.standardPartBiz.saveList(ProductTypeEnum.ARTIFACT.getType(), param));
   }

   @ApiOperation("标准件-修改")
   @PutMapping
   @PreAuthorize("@permission.check('plan_standard_part:edit')")
   public ResultVO updateList(@RequestBody @Valid List<TechStandardPartUpdateDtoParam> paramList) {
      log.info("Api调用:修改-标准件");
      return ResultBuilder.success(this.standardPartBiz.updateList(paramList));
   }

   @ApiOperation("标准件-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('plan_standard_part:del')")
   public ResultVO deleteList(@RequestBody List<Long> ids) {
      log.info("Api调用:删除-标准件");
      return ResultBuilder.success(this.standardPartBiz.deleteList(ProductTypeEnum.ARTIFACT.getType(), ids));
   }

   public StandardPartController(final TechStandardPartBiz standardPartBiz) {
      this.standardPartBiz = standardPartBiz;
   }
}
