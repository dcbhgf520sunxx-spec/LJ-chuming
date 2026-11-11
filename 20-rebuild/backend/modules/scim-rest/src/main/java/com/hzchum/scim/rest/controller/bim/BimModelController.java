package com.hzchum.scim.rest.controller.bim;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bim.core.api.biz.BimModelBiz;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskRecordBiz;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldCountDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.annotation.Log;
import com.hzchum.scim.system.core.api.common.enums.BusinessTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ModuleEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "bim-模型管理")
@RestController
@RequestMapping("/api/model/3DModel")
public class BimModelController {
   private static final Logger log = LoggerFactory.getLogger(BimModelController.class);
   @Resource
   private BimModelBiz bimModelBiz;
   @Resource
   private BimModelCommonService bimModelCommonService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private TechCappCraftProductPassTaskRecordBiz techCappCraftProductPassTaskRecordBiz;

   @ApiOperation("根据配置查询单体模型信息")
   @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
   @GetMapping("/monomer")
   @PreAuthorize("@permission.check('plan_model_file:detail')")
   public ResultVO getModelByMonomer(@RequestParam Long monomerId) {
      log.info("API 调用 ： 根据配置查询单体模型信息");
      return ResultBuilder.success(this.bimModelCommonService.getModelByMonomer(monomerId));
   }

   @ApiOperation("根据配置查询结构区域下的模型信息")
   @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
   @GetMapping("/area")
   @PreAuthorize("@permission.check('plan_model_file:detail')")
   public ResultVO getModelByArea(@RequestParam Long monomerId) {
      log.info("API 调用 ： 根据配置查询结构区域下的模型信息");
      return ResultBuilder.success(this.bimModelCommonService.getModelByArea(monomerId));
   }

   @ApiOperation("bim模型上传")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "file", value = "模型文件", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query")
      }
   )
   @PostMapping("/upload")
   @PreAuthorize("@permission.check('plan_model_file:import')")
   @Log(module = ModuleEnum.BIM, name = BusinessTypeEnum.MODEL_IMPORT)
   public ResultVO uploadModel(@RequestPart MultipartFile file, @RequestParam Long monomerId, @RequestParam(required = false) Long areaId) throws Exception {
      log.info("API 调用 ： bim模型上传");
      return ResultBuilder.success(this.bimModelCommonService.newUploadModel(file, monomerId, areaId, null));
   }

   @ApiOperation("回调bim模型转化状态")
   @GetMapping("/translate/status/callback")
   public ResponseEntity<Void> setTranslateStatusCallback(
      @RequestParam(name = "modelId", required = false) String modelId,
      @RequestParam(name = "token", required = false) String token,
      @RequestParam(name = "fileId", required = false) String fileId,
      @RequestParam(name = "status", required = false) String status,
      @RequestParam(name = "nonce", required = false) String nonce,
      @RequestParam(name = "signature", required = false) String signature
   ) {
      if (StringUtils.isAnyBlank(modelId, token, fileId, status, nonce, signature)) {
         return ResponseEntity.badRequest().build();
      }

      try {
         Long parsedModelId = Long.valueOf(modelId);
         Long parsedFileId = Long.valueOf(fileId);
         boolean accepted = this.bimModelCommonService.setTranslateStatusCallback(parsedModelId, token, parsedFileId, status, nonce, signature);
         return ResponseEntity.status(accepted ? HttpStatus.OK : HttpStatus.FORBIDDEN).build();
      } catch (NumberFormatException e) {
         return ResponseEntity.badRequest().build();
      } catch (RuntimeException e) {
         log.warn("BIMFACE转换回调处理暂不可用，异常类型 {}", e.getClass().getSimpleName());
         return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
      }
   }

   @ApiOperation("获取模型转换状态")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"), @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query")}
   )
   @GetMapping("/translate")
   public ResultVO translate(@RequestParam Long monomerId, @RequestParam(required = false) Long areaId) {
      log.info("API 调用 ：获取模型转换状态");
      return ResultBuilder.success(this.bimModelCommonService.getTranslate(monomerId, areaId));
   }

   @ApiOperation("bim模型删除")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"), @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query")}
   )
   @PreAuthorize("@permission.check('plan_model_file:integrationDel')")
   @DeleteMapping("")
   @Log(module = ModuleEnum.BIM, name = BusinessTypeEnum.MODEL_DELETE)
   public ResultVO delete(@RequestParam Long monomerId, @RequestParam(required = false) Long areaId) {
      log.info("API 调用 ： bim模型删除");
      return ResultBuilder.success(this.bimModelCommonService.delete(monomerId, areaId));
   }

   @ApiOperation("获取模型的构件状态信息")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query"), @ApiImplicitParam(name = "menuBar", value = "子菜单类型", paramType = "query")}
   )
   @GetMapping("/artifact/status")
   public ResultVO getArtifactStatus(@RequestParam Long fileId, @RequestParam Integer menuBar) {
      log.info("API 调用 ：获取模型的构件状态信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getArtifactStatus(fileId, menuBar));
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getBridgeStatus(fileId, menuBar));
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("获取模型项目树构件信息")
   @ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query")
   @GetMapping("/project/tree")
   public ResultVO getProjectTree(@RequestParam Long fileId) {
      log.info("API 调用 ：获取单体模型项目树构件信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getProjectTree(fileId));
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getBridgeProjectTree(fileId));
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("获取模型中的构件信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query"),
            @ApiImplicitParam(name = "elementId", value = "元件id", paramType = "query"),
            @ApiImplicitParam(name = "menuBar", value = "子菜单类型", paramType = "query")
      }
   )
   @GetMapping("/artifact")
   public ResultVO getArtifactInfo(@RequestParam Long fileId, @RequestParam String elementId, @RequestParam Integer menuBar) {
      log.info("API 调用 ：获取单体模型中的构件信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         BimArtifactVO bimArtifactVO = this.bimModelBiz.getArtifactInfo(fileId, elementId, menuBar);
         if (bimArtifactVO != null) {
            bimArtifactVO.setProductWeldCount(
               this.techCappCraftProductPassTaskRecordBiz
                  .productWeldCount(
                     CappCraftCardProductWeldCountDTO.builder()
                        .productId(bimArtifactVO.getId())
                        .areaId(bimArtifactVO.getAreaId())
                        .monomerId(bimArtifactVO.getMonomerId())
                        .build()
                  )
            );
         }

         return ResultBuilder.success(bimArtifactVO);
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         BimBoxOrElementsVO bridgeSegmentationInfo = this.bimModelBiz.getBridgeSegmentationInfo(fileId, elementId, menuBar);
         if (bridgeSegmentationInfo != null) {
            bridgeSegmentationInfo.setProductWeldCount(
               this.techCappCraftProductPassTaskRecordBiz
                  .productWeldCount(
                     CappCraftCardProductWeldCountDTO.builder()
                        .productId(bridgeSegmentationInfo.getId())
                        .areaId(bridgeSegmentationInfo.getAreaId())
                        .monomerId(bridgeSegmentationInfo.getMonomerId())
                        .build()
                  )
            );
         }

         return ResultBuilder.success(bridgeSegmentationInfo);
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("根据模型的构件编号获取元件id信息")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query"), @ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query")}
   )
   @GetMapping("/artifact/element")
   public ResultVO getElementIds(@RequestParam String serialNumber, @RequestParam Long fileId) {
      log.info("API 调用 ：根据模型的构件编号获取元件id信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelCommonService.getElementIds(serialNumber, fileId));
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelCommonService.getBridgeElementIds(serialNumber, fileId));
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("获取模型中构件的状态列表信息")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query"), @ApiImplicitParam(name = "menuBar", value = "子菜单类型", paramType = "query")}
   )
   @GetMapping("/artifact/production")
   public ResultVO getProduction(@RequestParam Long fileId, @RequestParam Integer menuBar) {
      log.info("API 调用 ：获取模型中构件的状态列表信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getProduction(fileId, menuBar));
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getBridgeProduction(fileId, menuBar));
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("获取模型中不同状态下的构件信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "构件状态", paramType = "query"),
            @ApiImplicitParam(name = "menuBar", value = "子菜单类型", paramType = "query")
      }
   )
   @GetMapping("/status/details")
   public ResultVO getDetailsByStatus(@RequestParam Long fileId, @RequestParam Integer status, @RequestParam Integer menuBar) {
      log.info("API 调用 ：获取模型中不同状态下的构件信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getDetailsByStatus(fileId, status, menuBar));
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getBridgeDetailsByStatus(fileId, status, menuBar));
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("获取模型中构件物流信息")
   @ApiImplicitParams(@ApiImplicitParam(name = "fileId", value = "文件id", paramType = "query"))
   @GetMapping("/logistics")
   public ResultVO getLogisticsByBim(@RequestParam Long fileId) {
      log.info("API 调用 ：获取单体模型中构件物流信息");
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.monomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "操作失败,单体不存在!");
      Preconditions.checkArgument(monomer.getBuildingTypeEnum() != null, "检查所选单体是否导入清单!");
      if (BuildingTypeEnum.BUILDING.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getLogisticsByBim(fileId));
      } else if (BuildingTypeEnum.BRIDGE.getType().equals(monomer.getBuildingTypeEnum())) {
         return ResultBuilder.success(this.bimModelBiz.getBridgeLogisticsByBim(fileId));
      } else {
         throw new IllegalArgumentException("检查所选单体是否导入清单");
      }
   }

   @ApiOperation("发起模型集成")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "areaIds", value = "区域id集合", paramType = "query"), @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")}
   )
   @PreAuthorize("@permission.check('plan_model_file:integration')")
   @PostMapping("/model/integration")
   public ResultVO modelIntegration(@RequestBody Set<Long> areaIds, @RequestParam Long monomerId) {
      log.info("API 调用 ： 发起模型集成");
      return ResultBuilder.success(this.bimModelCommonService.modelIntegration(areaIds, monomerId));
   }

   @ApiOperation("回调bim模型集成状态")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerIds", value = "模型id集合(逗号分隔)", paramType = "query"),
            @ApiImplicitParam(name = "modelId", value = "集成模型id", paramType = "query"),
            @ApiImplicitParam(name = "token", value = "回调token", paramType = "query")
      }
   )
   @GetMapping("/integrate/status/callback")
   public void setIntegrateStatusCallback(@RequestParam Long modelId, @RequestParam String areaIds, @RequestParam Long userId, @RequestParam String token) {
      log.info("API 调用 ： 回调bim模型集成状态");
      this.bimModelCommonService.setIntegrateStatusCallback(modelId, areaIds, userId, token);
   }

   @ApiOperation("删除集成模型")
   @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
   @DeleteMapping("/remove/integration")
   @PreAuthorize("@permission.check('plan_model_file:integrationDel')")
   public ResultVO removeIntegration(@RequestParam Long monomerId) {
      log.info("API 调用 ： 删除集成模型");
      return ResultBuilder.success(this.bimModelCommonService.removeIntegration(monomerId));
   }

   @ApiOperation("迁移系统现有bim模型到指定项目下")
   @GetMapping("migration")
   public ResultVO migration() {
      log.info("API 调用 ：迁移系统现有bim模型到指定项目下");
      return ResultBuilder.success(this.bimModelCommonService.migration());
   }
}
