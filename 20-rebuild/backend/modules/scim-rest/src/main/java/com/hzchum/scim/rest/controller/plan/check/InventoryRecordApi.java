package com.hzchum.scim.rest.controller.plan.check;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.plan.core.api.biz.TechArtifactMachinePartBiz;
import com.hzchum.scim.plan.core.api.biz.check.MesTechInventoryOperationBiz;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechArtifactRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechAssemblyAutomaticCombinationVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordBaseVO;
import com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "计划管理-清单操作(审核)")
@RestController
@RequestMapping("/api/plan/inventory/record")
@Valid
public class InventoryRecordApi {
   private static final Logger log = LoggerFactory.getLogger(InventoryRecordApi.class);
   @Resource
   private MesTechInventoryOperationBiz mesTechInventoryOperationBiz;
   @Resource
   private TechArtifactMachinePartBiz artifactMachinePartBiz;

   @ApiOperation(value = "清单excel导入", notes = "导入清单", httpMethod = "POST")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query", required = true),
            @ApiImplicitParam(name = "file", value = "导入的文件", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "importType", value = "导入类型: 1增量导入 2覆盖导入 ", paramType = "query", required = true),
            @ApiImplicitParam(name = "inventoryTypeEnum", value = "清单类型: 1.建钢 2.桥梁 ", paramType = "query", required = true),
            @ApiImplicitParam(name = "remark", value = "备注 ", paramType = "query", required = false),
            @ApiImplicitParam(name = "areaBatchName", value = "批次名称 ", paramType = "query")
      }
   )
   @PostMapping("/import")
   @SignerCheck(lockKey = "#monomerId", constantKey = "techArtifact", message = "该单体正在发起(变更、导入、删除)中,请稍后刷新页面重试!")
   public void importInventory(
      @RequestPart MultipartFile file,
      @RequestParam(name = "monomerId") Long monomerId,
      @RequestParam Long areaId,
      @RequestParam Integer importType,
      @RequestParam Integer inventoryTypeEnum,
      @RequestParam(required = false) String remark,
      @RequestParam String areaBatchName,
      HttpServletResponse response
   ) {
      log.info("Api调用: 清单导入接口");
      this.mesTechInventoryOperationBiz.importInventory(file, monomerId, areaId, importType, inventoryTypeEnum, remark, areaBatchName, response);
   }

   @ApiOperation("查询清单导入审核记录列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query", required = false),
            @ApiImplicitParam(name = "areaId", value = "区域id", paramType = "query", required = false),
            @ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query", required = false),
            @ApiImplicitParam(name = "createUserName", value = "创建人", paramType = "query", required = false),
            @ApiImplicitParam(name = "reviewedName", value = "审核人", paramType = "query", required = false),
            @ApiImplicitParam(name = "inventoryReviewedEnum", value = "审核状态", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = false)
      }
   )
   @GetMapping("/inventory/list")
   public ResultVO<PageVO<MesTechInventoryOperationDTO>> getInventoryList(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long areaBatchId,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String createUserName,
      @RequestParam(required = false) String reviewedName,
      @RequestParam(required = false) Integer buildingType,
      @RequestParam(required = false) @EnumValidator(value = InventoryReviewedEnum.class, message = "审核状态不存在!") Integer inventoryReviewedEnum,
      @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询清单导入审核记录列表");
      return ResultBuilder.success(
         this.mesTechInventoryOperationBiz
            .getInventoryList(
               projectId, monomerId, areaId, areaBatchId, projectName, createUserName, reviewedName, buildingType, inventoryReviewedEnum, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("查询清单导入审核详情列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "inventoryId", value = "审核记录Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "审核记录Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "审核记录Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = false)
      }
   )
   @GetMapping("/inventory/detail")
   public ResultVO<PageVO<TechArtifactRecordDTO>> getInventoryDetailList(
      @RequestParam Long inventoryId,
      @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询清单导入审核详情列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.getInventoryDetailList(inventoryId, pageNumber, pageSize));
   }

   @ApiOperation("下载清单导入审核详情列表")
   @GetMapping("/export")
   public void exportInventoryDetailList(@RequestParam Long inventoryId, HttpServletResponse response) {
      log.info("API 调用 :  下载清单导入审核详情列表");
      this.mesTechInventoryOperationBiz.exportInventoryDetailList(inventoryId, response);
   }

   @ApiOperation("下载围护清单导入审核详情列表")
   @GetMapping("/enclosure/export")
   public void exportEnclosureInventoryDetailList(@RequestParam Long inventoryId, HttpServletResponse response) {
      log.info("API 调用 :  下载清单导入审核详情列表");
      this.mesTechInventoryOperationBiz.exportEnclosureInventoryDetailList(inventoryId, response);
   }

   @ApiOperation("查询批次下导入的清单状态")
   @ApiImplicitParams(@ApiImplicitParam(name = "areaBatchId", value = "批次Id", paramType = "query", required = true))
   @GetMapping("/status")
   public ResultVO getInventoryStatusByArea(@RequestParam Long areaBatchId) {
      log.info("Api调用: 查询区域下导入的清单状态");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.getInventoryStatusByArea(areaBatchId));
   }

   @ApiOperation("查询待确认的清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "inventoryId", value = "清单审核记录Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "构件编号", paramType = "query", required = false),
            @ApiImplicitParam(name = "specification", value = "构件规格", paramType = "query", required = false),
            @ApiImplicitParam(name = "material", value = "构件材质", paramType = "query", required = false),
            @ApiImplicitParam(name = "maxLength", value = "构件长度范围", paramType = "query", required = false),
            @ApiImplicitParam(name = "minLength", value = "构件长度范围", paramType = "query", required = false),
            @ApiImplicitParam(name = "boolCombination", value = "是否组合", paramType = "query", required = false),
            @ApiImplicitParam(name = "structureClassId", value = "构件特征定义Id", paramType = "query", required = false)
      }
   )
   @GetMapping("/repetition")
   public ResultVO getRepetitionInventoryList(
      @RequestParam Long inventoryId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String material,
      @RequestParam(required = false) Long maxLength,
      @RequestParam(required = false) Long minLength,
      @RequestParam(required = false) Boolean boolCombination,
      @RequestParam(required = false) Long structureClassId
   ) {
      log.info("Api调用: 查询待确认的清单列表");
      return ResultBuilder.success(
         this.mesTechInventoryOperationBiz
            .getRepetitionInventoryList(inventoryId, serialNumber, specification, material, maxLength, minLength, boolCombination, structureClassId)
      );
   }

   @ApiOperation("查询待确认零件列表")
   @ApiImplicitParams(@ApiImplicitParam(name = "artifactId", value = "构件id", paramType = "query", required = true))
   @GetMapping("/repetition/machine")
   public ResultVO getRepetitionArtifactList(@RequestParam Long artifactId) {
      log.info("Api调用: 查询待确认零件列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.getRepetitionInventoryMachineList(artifactId));
   }

   @ApiOperation("查询待确认零件列表Two")
   @ApiImplicitParams(@ApiImplicitParam(name = "artifactId", value = "构件id", paramType = "query", required = true))
   @GetMapping("/repetition/machineTwo")
   public ResultVO getRepetitionArtifactListTwo(@RequestParam Long artifactId) {
      log.info("Api调用: 查询待确认零件列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.getRepetitionInventoryMachineListTwo(artifactId));
   }

   @ApiOperation("查询待确认零件规格")
   @ApiImplicitParams(@ApiImplicitParam(name = "artifactId", value = "构件id", paramType = "query", required = true))
   @GetMapping("/repetition/getMachineSpecification")
   public ResultVO<List<String>> getMachineSpecification(@RequestParam Long artifactId) {
      log.info("Api调用: 查询待确认零件列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.getMachineSpecification(artifactId));
   }

   @ApiOperation("保存零件部件列表")
   @ApiImplicitParams(
      @ApiImplicitParam(
         name = "paramList",
         value = "规格修正列表",
         required = true,
         dataType = "com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordVO",
         paramType = "body"
      )
   )
   @PostMapping("/repetition/assembleSave")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:import')")
   @SignerCheck(boolMethodAndClassName = true, message = "正在保存中,请勿重复操作,稍后刷新重试!")
   public ResultVO partSave(@RequestBody(required = false) @Valid TechUnitRecordBaseVO unitRecordBaseVO) {
      log.info("Api调用: 添加部件列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.partSave(unitRecordBaseVO));
   }

   @ApiOperation("根据配置自动组合部件")
   @PostMapping("/automatic/assembleSave")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:import')")
   @SignerCheck(lockKey = "#automaticCombinationVO.inventoryOperationId", timeout = 30L, message = "正在保存中,请勿重复操作,稍后刷新重试!")
   public ResultVO saveAutomaticCombinationAssemble(@RequestBody @Valid TechAssemblyAutomaticCombinationVO automaticCombinationVO) {
      log.info("Api调用: 根据配置自动组合部件");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.saveAutomaticCombinationAssemble(automaticCombinationVO));
   }

   @ApiOperation("删除零件部件列表")
   @ApiImplicitParams(
      @ApiImplicitParam(
         name = "paramList",
         value = "规格修正列表",
         required = true,
         dataType = "com.hzchum.scim.plan.core.api.pojo.vo.TechUnitRecordVO",
         paramType = "body"
      )
   )
   @PostMapping("/repetition/assembleDelete")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:import')")
   public ResultVO partDelete(@RequestBody(required = false) @Valid Map<String, List<TechUnitRecordVO>> techUnitRecordVOMap) {
      List<TechUnitRecordVO> techUnitRecordVOList = techUnitRecordVOMap.get("techUnitRecordVOList");
      log.info("Api调用: 删除零件部件列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.partDelete(techUnitRecordVOList));
   }

   @ApiOperation("确认导入的清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "inventoryId", value = "清单审核记录Id", paramType = "query", required = true),
            @ApiImplicitParam(
               name = "paramList",
               value = "规格修正列表",
               required = true,
               dataType = "com.hzchum.scim.plan.core.api.pojo.vo.TechArtifactSpecAmendUpdateVORequest",
               paramType = "body"
            )
      }
   )
   @PutMapping("/repetition/check")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:import')")
   @SignerCheck(lockKey = "#dtoParam.id", message = "正在保存中,请勿重复操作,请稍后刷新页面重试!")
   public ResultVO fixUpRecordInventory(@RequestBody @Valid MesTechInventoryOperationDTOParam dtoParam) {
      log.info("Api调用: 确认导入的清单列表");
      return ResultBuilder.success(this.mesTechInventoryOperationBiz.fixUpRecordInventory(dtoParam));
   }

   @ApiOperation(value = "零构件清单导入操作审核", notes = "零构件清单操作审核", httpMethod = "POST")
   @PutMapping("/inventory/check")
   @SignerCheck(lockKey = "#dtoParam.id", message = "该区域清单正在审核中,请稍后刷新页面重试!")
   public ResultVO inventoryCheck(@RequestBody @Valid MesTechInventoryOperationDTOParam dtoParam) {
      log.info("Api调用: 零构件清单导入操作审核");
      return ResultBuilder.success(this.artifactMachinePartBiz.inventoryCheck(dtoParam));
   }
}
