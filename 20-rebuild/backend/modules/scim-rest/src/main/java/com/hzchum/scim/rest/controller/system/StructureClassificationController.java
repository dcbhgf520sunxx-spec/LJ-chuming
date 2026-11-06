package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.biz.SysStructureClassificationBiz;
import com.hzchum.scim.system.core.api.biz.SysStructureClassificationChangeBiz;
import com.hzchum.scim.system.core.api.pojo.dto.PartArtAssClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.StructureParentTypeDTO;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationChangeAuditDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.StructureClassificationUpdateTOParam;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-构件类型配置")
@RestController
@RequestMapping("/api/system/structure-classification")
public class StructureClassificationController {
   private static final Logger log = LoggerFactory.getLogger(StructureClassificationController.class);
   @Resource
   private SysStructureClassificationBiz structureClassificationBiz;
   @Resource
   private SysStructureSpecService structureSpecService;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private SysStructureClassificationChangeBiz structureClassificationChangeBiz;
   @Resource
   private ConfigService configService;

   @ApiOperation("列表-构件种类")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", paramType = "query"),
            @ApiImplicitParam(name = "classificationName", value = "构件种类名称", paramType = "query"),
            @ApiImplicitParam(name = "artifactType", value = "构件分类 1主构件 2次构件", paramType = "query"),
            @ApiImplicitParam(name = "mesProductEnum", value = "mes分类 1建刚构件 2桥梁构件", paramType = "query"),
            @ApiImplicitParam(name = "sectionAndNameAndType", value = "名称/截面/类型筛选", paramType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('artifact_config:get')")
   public ResultVO<ListVO<StructureParentTypeDTO>> list(
      Integer productionLineTypeEnum,
      String classificationName,
      @RequestParam(required = false) Integer artifactType,
      @RequestParam Integer mesProductEnum,
      @RequestParam(required = false) String sectionAndNameAndType
   ) {
      log.info("Api调用:构件种类列表");
      return ResultBuilder.success(
         this.structureClassificationBiz.listByCondition(productionLineTypeEnum, classificationName, artifactType, mesProductEnum, sectionAndNameAndType)
      );
   }

   @ApiOperation("列表-构件种类")
   @GetMapping("all")
   public ResultVO listArtifactSysAll(@RequestParam(required = false) Integer mesProductEnum) {
      log.info("Api调用:构件种类列表");
      return ResultBuilder.success(this.structureClassificationBiz.listArtifactSysAll(mesProductEnum));
   }

   @ApiOperation("列表-构件种类(焊接型材+无需组立次构件)")
   @GetMapping("welding/all")
   public ResultVO listArtifactWeldingProfilessAll(@RequestParam(required = false) Integer mesProductEnum) {
      log.info("Api调用:列表-构件种类(焊接型材+无需组立次构件)");
      return ResultBuilder.success(this.structureClassificationBiz.listArtifactWeldingProfilessAll(mesProductEnum));
   }

   @ApiOperation("列表-全部构件种类(无权限)")
   @GetMapping("/listAll")
   public ResultVO<ListVO<NameInfo>> listAll(@RequestParam Integer mesProductEnum) {
      log.info("Api调用: 所有构件种类");
      return ResultBuilder.success(new ListVO<>(this.structureClassificationService.listAll(mesProductEnum)));
   }

   @ApiOperation("列表-全部种类")
   @GetMapping("/allClass/list")
   public ResultVO<ListVO<PartArtAssClassificationDTO>> allTypeClassList(@RequestParam Integer mesProductEnum) {
      log.info("Api调用: 全部种类");
      return ResultBuilder.success(new ListVO<>(this.structureClassificationBiz.findAllTypeClassification(mesProductEnum)));
   }

   @ApiOperation("新增-构件种类")
   @PostMapping
   @PreAuthorize("@permission.check('artifact_config:add')")
   public ResultVO save(@RequestBody @Valid StructureClassificationSaveDTOParam saveDTOParam) {
      log.info("Api调用:新增构件种类");
      return ResultBuilder.success(this.structureClassificationBiz.saveOne(saveDTOParam));
   }

   @ApiOperation("修改-构件种类")
   @PutMapping
   @PreAuthorize("@permission.check('artifact_config:edit')")
   public ResultVO update(@RequestBody @Valid StructureClassificationUpdateTOParam param) {
      log.info("Api调用:新增构件种类");
      Boolean result;
      if (this.configService.getFeatureDefinitionConfig().getAuditType()) {
         result = this.structureClassificationChangeBiz.change(param);
      } else {
         result = this.structureClassificationBiz.updateStructureClassification(param);
      }

      return ResultBuilder.success(result);
   }

   @ApiOperation("审批修改-构件种类")
   @PutMapping("/auditUpdate")
   @PreAuthorize("@permission.check('artifact_config:audit')")
   public ResultVO<?> auditUpdate(@RequestBody @Valid StructureClassificationChangeAuditDTOParam param) {
      log.info("Api调用:变更审批构件种类");
      return ResultBuilder.success(this.structureClassificationChangeBiz.audit(param));
   }

   @ApiOperation("删除-构件种类")
   @DeleteMapping
   @PreAuthorize("@permission.check('artifact_config:del')")
   public ResultVO delByIds(@RequestBody @Valid List<Long> ids) {
      log.info("Api调用:删除构件种类");
      return ResultBuilder.success(this.structureClassificationBiz.deleteIds(ids));
   }

   @ApiOperation("构件规格前缀列表")
   @GetMapping("list-specPrefix")
   @PreAuthorize("@permission.check('artifact_config:get','artifact-specification-revise:get')")
   public ResultVO<ListVO<String>> listSpecPrefix(@RequestParam(required = false) Integer mesProductEnum) {
      log.info("Api调用: 根据产品线类型,查询构件规格前缀列表");
      return ResultBuilder.success(new ListVO<>(this.structureSpecService.listSpecPrefix(mesProductEnum)));
   }

   @ApiOperation("涂装工艺-按项目查询构件种类列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "contractProjectId", value = "合同项目ID", required = true, paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体ID", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域ID", paramType = "query")
      }
   )
   @GetMapping("list-by-contract-project-id")
   public ResultVO listByContractProjectId(
      @RequestParam Long contractProjectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId
   ) {
      log.info("Api调用: 涂装工艺-按项目查询构件种类列表");
      return ResultBuilder.success(new ListVO<>(this.structureClassificationBiz.listByContractProjectId(contractProjectId, monomerId, areaId)));
   }
}
