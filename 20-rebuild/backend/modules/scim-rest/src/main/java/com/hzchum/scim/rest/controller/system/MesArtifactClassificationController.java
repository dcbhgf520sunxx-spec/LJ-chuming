package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.pojo.request.MesArtifactClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "工价配置-构件分类")
@RequestMapping("/api/system/artifact-classification")
@RestController
@Validated
public class MesArtifactClassificationController {
   private static final Logger log = LoggerFactory.getLogger(MesArtifactClassificationController.class);
   @Autowired
   private MesArtifactClassificationService artifactClassificationService;
   @Autowired
   private MesSectionWarehouseConfigService sectionWarehouseConfigService;

   @ApiOperation("获取清单构件名称索引列表")
   @GetMapping("name-index-list")
   @ApiImplicitParams(@ApiImplicitParam(name = "artifactType", value = "构件类型", required = true, paramType = "query"))
   public ResultVO getNameIndexList(@RequestParam @EnumValidator(value = ArtifactTypeEnum.class, message = "构件类型不存在") Integer artifactType) {
      log.info("API 调用 ：获取清单构件名称索引列表");
      return ResultBuilder.success(
         this.sectionWarehouseConfigService
            .getSectionConfigNameList(ProductTypeEnum.ARTIFACT.getType(), artifactType, ProductSectionNameEnum.PRODUCT_NAME.getType())
      );
   }

   @ApiOperation("获取截面类型索引列表")
   @GetMapping("type-index-list")
   @ApiImplicitParams(@ApiImplicitParam(name = "artifactType", value = "构件类型", required = true, paramType = "query"))
   public ResultVO getTypeIndexList(@RequestParam @EnumValidator(value = ArtifactTypeEnum.class, message = "构件类型不存在") Integer artifactType) {
      log.info("API 调用 ：获取截面类型索引列表");
      return ResultBuilder.success(
         this.sectionWarehouseConfigService
            .getSectionConfigNameList(ProductTypeEnum.ARTIFACT.getType(), artifactType, ProductSectionNameEnum.SECTION_TYPE_ENUM.getType())
      );
   }

   @ApiOperation("构件分类列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：构件分类列表");
      return ResultBuilder.success(new ListVO<>(this.artifactClassificationService.listInfo()));
   }

   @ApiOperation("构件分类详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：构件分类详情");
      return ResultBuilder.success(this.artifactClassificationService.detailById(id));
   }

   @ApiOperation("构件分类新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesArtifactClassificationSaveDTOParam param) {
      log.info("API 调用 ：构件分类新增");
      return ResultBuilder.success(this.artifactClassificationService.saveArtifactClassification(param));
   }

   @ApiOperation("构件分类修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesArtifactClassificationSaveDTOParam param) {
      log.info("API 调用 ：构件分类修改");
      return ResultBuilder.success(this.artifactClassificationService.editArtifactClassification(param));
   }

   @ApiOperation("构件分类删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：构件分类删除");
      return ResultBuilder.success(this.artifactClassificationService.deleteById(id));
   }
}
