package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.rest.pojo.vo.scm.supplierConfig.ScmSupplierConfigVORequest;
import com.hzchum.scim.scm.core.api.biz.scm.ScmSupplierConfigBiz;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ReviewTemplateDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierConfigDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-供应商配置")
@RestController
@RequestMapping("/api/scm/supplierConfig")
public class ScmSupplierConfigController {
   private static final Logger log = LoggerFactory.getLogger(ScmSupplierConfigController.class);
   @Resource
   private ScmSupplierConfigBiz scmSupplierConfigBiz;

   @ApiOperation("评价分类配置-列表")
   @GetMapping("/evaluation-category")
   public ResultVO listEvaluationCategory() {
      log.info("Api调用: 评价分类配置-列表");
      return ResultBuilder.success(new ListVO<>(this.scmSupplierConfigBiz.listEvaluationCategory()));
   }

   @ApiOperation("评价分类配置-批量编辑")
   @PutMapping("/evaluation-category")
   @PreAuthorize("@permission.check('supplier_evaluation_category:edit')")
   public ResultVO editEvaluationCategory(@RequestBody @Valid List<ScmSupplierConfigVORequest> requests) {
      log.info("Api调用: 评价分类配置-批量编辑");
      List<ScmSupplierConfigDTOParam> params = requests.stream().map(r -> BeanUtil.copy(r, ScmSupplierConfigDTOParam.class)).collect(Collectors.toList());
      return ResultBuilder.success(this.scmSupplierConfigBiz.editEvaluationCategory(params));
   }

   @ApiOperation("分数评级配置-列表")
   @GetMapping("/score-rating")
   public ResultVO listScoreRating() {
      log.info("Api调用: 分数评级配置-列表");
      return ResultBuilder.success(new ListVO<>(this.scmSupplierConfigBiz.listScoreRating()));
   }

   @ApiOperation("分数评级配置-批量编辑")
   @PostMapping("/score-rating")
   @PreAuthorize("@permission.check('supplier_score_rating:edit')")
   public ResultVO editScoreRating(@RequestBody @Valid List<ScmSupplierConfigVORequest> requests) {
      log.info("Api调用: 分数评级配置-批量编辑");
      List<ScmSupplierConfigDTOParam> params = requests.stream().map(r -> BeanUtil.copy(r, ScmSupplierConfigDTOParam.class)).collect(Collectors.toList());
      return ResultBuilder.success(this.scmSupplierConfigBiz.editScoreRating(params));
   }

   @ApiOperation("供应商资质配置-列表")
   @GetMapping("/qualification")
   public ResultVO listQualification() {
      log.info("Api调用: 供应商资质配置-列表");
      return ResultBuilder.success(new ListVO<>(this.scmSupplierConfigBiz.listQualification()));
   }

   @ApiOperation("供应商资质配置-批量编辑")
   @PostMapping("/qualification")
   @PreAuthorize("@permission.check('supplier_qualification:edit')")
   public ResultVO editQualification(@RequestBody @Valid List<ScmSupplierConfigVORequest> requests) {
      log.info("Api调用: 供应商资质配置-批量编辑");
      List<ScmSupplierConfigDTOParam> params = requests.stream().map(r -> BeanUtil.copy(r, ScmSupplierConfigDTOParam.class)).collect(Collectors.toList());
      return ResultBuilder.success(this.scmSupplierConfigBiz.editQualification(params));
   }

   @ApiOperation("评审模板配置")
   @GetMapping("/review-template")
   public ResultVO getReviewTemplate(@RequestParam Long classifyId) {
      log.info("Api调用: 评审模板配置-列表");
      return ResultBuilder.success(this.scmSupplierConfigBiz.getReviewTemplate(classifyId));
   }

   @ApiOperation("评审模板配置编辑")
   @PutMapping("/review-template")
   @PreAuthorize("@permission.check('supplier_review_template:edit')")
   public ResultVO editReviewTemplate(@RequestBody @Valid ReviewTemplateDTOParam param) {
      log.info("Api调用: 评审模板配置-批量编辑");
      return ResultBuilder.success(this.scmSupplierConfigBiz.editReviewTemplate(param));
   }
}
