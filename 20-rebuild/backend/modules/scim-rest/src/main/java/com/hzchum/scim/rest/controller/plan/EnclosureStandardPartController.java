package com.hzchum.scim.rest.controller.plan;

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
import com.hzchum.scim.plan.core.api.pojo.voParam.TechStandardPartImportVoParam;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "计划管理-(围护)标准件")
@RestController
@Validated
@RequestMapping("/api/plan/enclosureStandardPart")
public class EnclosureStandardPartController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureStandardPartController.class);
   private final TechStandardPartBiz standardPartBiz;

   @ApiOperation("(围护)标准件-列表")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "specification", value = "规格", paramType = "query"), @ApiImplicitParam(name = "measureUnit", value = "单位", paramType = "query")}
   )
   @GetMapping
   public ResultVO<PageVO<TechStandardPartDTO>> pageEnclosureStandardPartList(
      @Valid TechStandardPartQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:标准件列表");
      TechStandardPartQueryDtoParam dtoParam = BeanUtil.copy(param, TechStandardPartQueryDtoParam.class);
      dtoParam.setRelationType(ProductTypeEnum.ENCLOSURE.getType());
      return ResultBuilder.success(this.standardPartBiz.pageListByCondition(dtoParam, pageNumber, pageSize, null));
   }

   @ApiOperation("查询项目是否关联物料")
   @ApiImplicitParams(@ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"))
   @GetMapping("/findWmsLink")
   public ResultVO<Boolean> findStandPartWmsLink(@RequestParam Long projectId) {
      log.info("Api调用:标准件列表");
      return ResultBuilder.success(this.standardPartBiz.findStandPartWmsLink(projectId));
   }

   @ApiOperation("下载标准件模板-围护")
   @GetMapping("/download-template")
   public void DownloadEnclosureStandardPartTemplate(HttpServletResponse response) {
      log.info("Api调用:下载标准件模板");
      this.standardPartBiz.exportStandardPartTemplate(response);
   }

   @ApiOperation("导入-(围护)标准件")
   @PostMapping("/import")
   public void ImportEnclosureStandardPart(@RequestPart MultipartFile file, @Valid TechStandardPartImportVoParam param, HttpServletResponse response) {
      log.info("Api调用:导入-(围护)标准件");
      TechStandardPartImportDtoParam dtoParam = BeanUtil.copy(param, TechStandardPartImportDtoParam.class);
      dtoParam.setProductType(ProductTypeEnum.ENCLOSURE.getType());
      this.standardPartBiz.importStandardPart(file, dtoParam, response);
   }

   @ApiOperation("导入-(围护)标准件")
   @PostMapping("v2/import")
   public void ImportEnclosureStandardPartV2(@RequestPart MultipartFile file, @Valid TechStandardPartImportVoParam param, HttpServletResponse response) {
      log.info("Api调用:导入-(围护)标准件");
      TechStandardPartImportDtoParam dtoParam = BeanUtil.copy(param, TechStandardPartImportDtoParam.class);
      dtoParam.setProductType(ProductTypeEnum.ENCLOSURE.getType());
      this.standardPartBiz.importStandardPartV2(file, dtoParam, response);
   }

   @ApiOperation("标准件-新增(围护)")
   @PostMapping("")
   public ResultVO saveEnclosureStandardPartList(@RequestBody @Valid StandardPartSaveVoParam param) {
      log.info("Api调用:手动新增-标准件");
      return ResultBuilder.success(this.standardPartBiz.saveList(ProductTypeEnum.ENCLOSURE.getType(), param));
   }

   @ApiOperation("标准件-修改(围护)")
   @PutMapping("")
   public ResultVO updateEnclosureStandardPartList(@RequestBody @Valid List<TechStandardPartUpdateDtoParam> paramList) {
      log.info("Api调用:修改-标准件");
      return ResultBuilder.success(this.standardPartBiz.updateList(paramList));
   }

   @ApiOperation("标准件-删除(围护)")
   @DeleteMapping("")
   public ResultVO deleteEnclosureStandardPartList(@RequestBody List<Long> ids) {
      log.info("Api调用:删除-标准件");
      return ResultBuilder.success(this.standardPartBiz.deleteList(ProductTypeEnum.ENCLOSURE.getType(), ids));
   }

   public EnclosureStandardPartController(final TechStandardPartBiz standardPartBiz) {
      this.standardPartBiz = standardPartBiz;
   }
}
