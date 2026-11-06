package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.common.core.api.pojo.common.IdsStatusDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.ClassificationDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "wms配置-科目配置")
@RestController
@RequestMapping("/api/config/classification")
public class ClassificationController {
   private static final Logger log = LoggerFactory.getLogger(ClassificationController.class);
   @Resource
   ClassificationService classificationService;

   @ApiOperation("获取科目列表-科目配置掉此接口")
   @GetMapping("/tree-new")
   @PreAuthorize("@permission.check('config_classConfig:get')")
   public ResultVO listNew(Boolean status) {
      log.info("API 调用 ：获取科目列表");
      return ResultBuilder.success(this.classificationService.treeNew(status));
   }

   @ApiOperation("获取科目列表")
   @GetMapping("/tree")
   @PreAuthorize("@permission.check('config_classConfig:get')")
   public ResultVO list() {
      log.info("API 调用 ：获取科目列表");
      return ResultBuilder.success(this.classificationService.tree(1));
   }

   @ApiOperation("导出科目配置清单")
   @GetMapping("/exportClassificationList")
   @PreAuthorize("@permission.check('config_classConfig:get')")
   public void exportClassificationList(HttpServletResponse response) {
      log.info("API 调用 ：导出科目配置清单");
      this.classificationService.exportClassificationList(response);
   }

   @ApiOperation("批量新增科目")
   @PostMapping
   @PreAuthorize("@permission.check('config_classConfig:add')")
   public ResultVO batchAdd(@Valid @RequestBody ValidList<ClassificationDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：批量新增科目");
      return ResultBuilder.success(this.classificationService.batchAddSubject(params));
   }

   @ApiOperation("删除科目配置")
   @DeleteMapping
   @PreAuthorize("@permission.check('config_classConfig:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除科目配置");
      return ResultBuilder.success(this.classificationService.delete(ids));
   }

   @ApiOperation("获取科目规格计量配置列表")
   @GetMapping("/detail-tree")
   public ResultVO detailTree() {
      log.info("API 调用 ：获取科目规格计量配置列表");
      return ResultBuilder.success(this.classificationService.detailTree());
   }

   @ApiOperation("根据基础物料分类查询科目")
   @GetMapping("/{basicClass}")
   public ResultVO getByBasicClassId(@PathVariable Long basicClass) {
      log.info("API 调用 ：根据基础物料分类查询科目");
      return ResultBuilder.success(this.classificationService.getByBasicClass(basicClass));
   }

   @ApiOperation("根据基础物料分类库存科目")
   @GetMapping("/getMaterialClassification")
   public ResultVO getMaterialClassification(Long basicClass) {
      log.info("API 调用 ：根据基础物料分类库存科目");
      return ResultBuilder.success(this.classificationService.getMaterialClassification(basicClass));
   }

   @ApiOperation("根据基础物料分类采购科目")
   @GetMapping("/getPurchaseClassification")
   public ResultVO getPurchaseClassification(Long basicClass) {
      log.info("API 调用 ：根据基础物料分类库存科目");
      return ResultBuilder.success(this.classificationService.getPurchaseClassification(basicClass));
   }

   @ApiOperation("根据基础物料分类库存获取一级科目")
   @GetMapping("/getMaterialClassification/level")
   public ResultVO getMaterialClassificationLevel(Long basicClass) {
      log.info("API 调用 ：根据基础物料分类库存获取一级科目");
      return ResultBuilder.success(this.classificationService.getMaterialClassificationLevel(basicClass));
   }

   @ApiOperation("获取材料类科目")
   @GetMapping("/material/tree")
   public ResultVO getByBasic() {
      log.info("API 调用 ：获取材料类科目");
      return ResultBuilder.success(this.classificationService.tree(2));
   }

   @ApiOperation("根据末级科目ID获取当前科目所有信息,以及科目规格信息")
   @GetMapping("/final-material/{id}")
   public ResultVO getClassifyById(@PathVariable Long id) {
      log.info("API 调用 ：获取材料类科目");
      return ResultBuilder.success(this.classificationService.getClassifyById(id));
   }

   @ApiOperation("根据末级科目IDS获取当前科目所有信息,以及科目规格信息")
   @GetMapping("/final-materials")
   public ResultVO getClassifyListByIds(@RequestParam("ids") List<Long> ids) {
      log.info("API 调用 ：获取材料类科目");
      return ResultBuilder.success(this.classificationService.getClassifyListByIds(ids));
   }

   @PostMapping("/excel")
   public void excel(@RequestPart MultipartFile file) {
      this.classificationService.excel(file);
   }

   @ApiOperation("获取科目列表-公共接口")
   @GetMapping("/tree/all")
   public ResultVO listAll() {
      log.info("API 调用 ：获取科目列表");
      return ResultBuilder.success(this.classificationService.tree(1));
   }

   @ApiOperation("修改科目名称或代码")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('config_classConfig:edit')")
   public ResultVO update(@Valid @RequestBody ValidList<ClassificationDTOParam> subjectsVORequests, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改科目名称或代码");
      List<ClassificationDTOParam> dtoParams = subjectsVORequests.stream()
         .map(subject -> BeanUtil.copy(subject, ClassificationDTOParam.class))
         .collect(Collectors.toList());
      return ResultBuilder.success(this.classificationService.updateClassify(dtoParams));
   }

   @ApiOperation("启用或禁用科目")
   @PostMapping("/updateStatus")
   @PreAuthorize("@permission.check('config_classConfig:editStatus')")
   public ResultVO updateStatus(@RequestBody IdsStatusDTO dto) {
      log.info("API 调用 ：启用或禁用科目");
      return ResultBuilder.success(this.classificationService.updateClassifyStatus(dto));
   }

   @ApiOperation("根据钢卷Id获取到钢板的数据信息")
   @GetMapping("/getSteelPlate/{id}")
   public ResultVO getSteelPlateByColorRollId(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据钢卷Id获取到钢板的数据信息");
      return ResultBuilder.success(this.classificationService.getSteelPlateByColorRollId(id));
   }
}
