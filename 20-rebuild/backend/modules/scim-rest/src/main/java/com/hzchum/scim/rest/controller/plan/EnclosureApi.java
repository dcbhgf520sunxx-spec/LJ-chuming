package com.hzchum.scim.rest.controller.plan;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.enclosure.core.api.biz.check.MesTechEnclosureInventoryOperationBiz;
import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import com.hzchum.scim.plan.core.api.biz.check.MesTechEnclosureInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.biz.check.MesTechInventoryOperationBiz;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDrawingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSimpleSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureSubscribeDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.TechEnclosureRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.EnclosureSubscribeQueryDtoParam;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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

@Api(tags = "计划管理-围护")
@RequestMapping("/api/plan/enclosure")
@RestController
@Validated
public class EnclosureApi {
   private static final Logger log = LoggerFactory.getLogger(EnclosureApi.class);
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private TechEnclosureBiz enclosureBiz;
   @Resource
   private MesTechInventoryOperationBiz mesTechInventoryOperationBiz;
   @Resource
   private MesTechEnclosureInventoryOperationBiz mesTechEnclosureInventoryOperationBiz;

   @ApiOperation(value = "导入围护清单", notes = "根据 区域id 围护类别 导入围护清单")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "category", value = "围护分类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", paramType = "query", required = true),
            @ApiImplicitParam(name = "importType", value = "导入方式 1增量导入 2覆盖导入 ", paramType = "query", required = true)
      }
   )
   @PostMapping("/import")
   @PreAuthorize("@permission.check('plan_enclosure_list:import')")
   public void enclosureImport(
      @RequestPart MultipartFile file, @RequestParam Long enclosurePlanId, @RequestParam(defaultValue = "1") Integer importType, HttpServletResponse response
   ) {
      log.info("Api调用: 围护导入");
      this.enclosureBiz.importEnclosure(file, enclosurePlanId, importType, response);
   }

   @ApiOperation(value = "导入围护清单新版", notes = "根据 区域id 围护类别 导入围护清单")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "areaId", value = "区域id ", paramType = "query", required = true),
            @ApiImplicitParam(name = "file", value = "导入的文件 ", paramType = "query", required = true),
            @ApiImplicitParam(name = "importType", value = "导入方式 1增量导入 2覆盖导入 ", paramType = "query", required = true)
      }
   )
   @PostMapping("/v2/import")
   @SignerCheck(lockKey = "#areaId", message = "该区域正在导入围护清单中,请稍后刷新页面重试!", timeout = 60L)
   public void enclosureImportV2(
      @RequestParam(name = "areaId") Long areaId,
      @RequestPart(name = "file") MultipartFile file,
      @RequestParam(name = "importType", defaultValue = "1") Integer importType,
      HttpServletResponse response
   ) {
      log.info("Api调用: 围护导入");
      this.enclosureBiz.importInventory(file, areaId, importType, response);
   }

   @ApiOperation("查询围护清单导入审核记录列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectName", value = "项目名", paramType = "query", required = false),
            @ApiImplicitParam(name = "createUserName", value = "创建人", paramType = "query", required = false),
            @ApiImplicitParam(name = "reviewedName", value = "审核人", paramType = "query", required = false),
            @ApiImplicitParam(name = "inventoryReviewedEnum", value = "审核状态", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = false)
      }
   )
   @GetMapping("/inventory/list")
   public ResultVO<PageVO<MesTechInventoryOperationDTO>> getInventoryList(
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) String createUserName,
      @RequestParam(required = false) String reviewedName,
      @RequestParam(required = false) @EnumValidator(value = InventoryReviewedEnum.class, message = "审核状态不存在!") Integer inventoryReviewedEnum,
      @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询清单导入审核记录列表");
      return ResultBuilder.success(this.enclosureBiz.getInventoryList(projectName, createUserName, reviewedName, inventoryReviewedEnum, pageNumber, pageSize));
   }

   @ApiOperation("查询清单导入审核详情列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "inventoryId", value = "审核记录Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", required = false)
      }
   )
   @GetMapping("/inventory/detail")
   public ResultVO<PageVO<TechEnclosureRecordDTO>> getInventoryDetailList(
      @RequestParam Long inventoryId,
      @RequestParam(required = false) String dictionaryId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询清单导入审核详情列表");
      return ResultBuilder.success(
         this.mesTechInventoryOperationBiz.getInventoryEnclosureDetailList(inventoryId, dictionaryId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation(value = "围护清单导入操作审核", notes = "围护清单导入操作审核", httpMethod = "PUT")
   @PutMapping("/inventory/check")
   @SignerCheck(lockKey = "#dtoParam.id", message = "该区域围护清单正在审核中,请稍后刷新页面重试!")
   public ResultVO inventoryCheck(@RequestBody @Valid MesTechEnclosureInventoryOperationDTOParam dtoParam) {
      log.info("Api调用: 围护清单导入操作审核");
      return ResultBuilder.success(this.enclosureBiz.importEnclosureV2(dtoParam));
   }

   @ApiOperation(value = "下载围护清单模板", notes = "根据 类别 下载围护清单模板")
   @ApiImplicitParam(name = "category", value = "围护分类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", paramType = "path", required = true)
   @GetMapping("/download/{category}")
   @PreAuthorize("@permission.check('plan_enclosure_list:templateDownload')")
   public void downloadEnclosureTemplate(@PathVariable("category") Integer category) {
      log.info("Api调用: 下载围护类清单模板");
      this.enclosureService.downloadEnclosureTemplate(category);
   }

   @ApiOperation(value = "下载围护清单模板", notes = "根据 类别 下载围护清单模板")
   @GetMapping("/inventory/download")
   public void downloadInventoryEnclosureTemplate() {
      log.info("Api调用: 下载围护类清单模板");
      this.enclosureService.downloadInventoryEnclosureTemplate();
   }

   @ApiOperation(value = "围护清单列表", notes = "围护清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.asc")
      }
   )
   @GetMapping("/listPage")
   @PreAuthorize("@permission.check('plan_enclosure_list:get')")
   public ResultVO<PageVO<EnclosureResponseDTO>> listEnclosures(
      EnclosureListQueryDTOParam queryDTOParam,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(name = "sort", defaultValue = "id.asc") List<String> sort
   ) {
      log.info("Api调用: 查询围护清单列表");
      return ResultBuilder.success(this.enclosureBiz.pageListEnclosure(queryDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation(value = "围护清单列表", notes = "围护清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.asc")
      }
   )
   @GetMapping("/v2/listPage")
   public ResultVO<PageVO<EnclosureResponseDTO>> listEnclosuresV2(
      EnclosureListQueryDTOParam queryDTOParam,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(name = "sort", defaultValue = "id.asc") List<String> sort
   ) {
      log.info("Api调用: 查询围护清单列表");
      return ResultBuilder.success(this.enclosureBiz.pageListEnclosureV2(queryDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation(value = "导出围护清单列表", notes = "根据条件查询,然后导出围护清单列表")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('plan_enclosure_list:download')")
   public void exportEnclosureList(EnclosureListQueryDTOParam queryDTOParam, HttpServletResponse response) {
      log.info("Api调用: 根据条件查询,导出围护清单列表");
      this.enclosureService.exportEnclosureList(queryDTOParam, response);
   }

   @ApiOperation(value = "导出围护清单列表", notes = "(新)根据条件查询,然后导出围护清单列表")
   @GetMapping("/v2/export")
   public void exportEnclosureList2(EnclosureListQueryDTOParam queryDTOParam, HttpServletResponse response) {
      log.info("Api调用: (新)根据条件查询,导出围护清单列表");
      this.enclosureService.exportEnclosureList2(queryDTOParam, response);
   }

   @ApiOperation(value = "编辑修改围护", notes = "编辑修改围护")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('plan_enclosure_list:edit')")
   public ResultVO updateEnclosure(@RequestBody @Valid EnclosureUpdateDTOParam updateDTOParam) {
      log.info("Api调用 : 修改围护");
      return ResultBuilder.success(this.enclosureBiz.updateEnclosure(updateDTOParam));
   }

   @ApiOperation("查询总长度,总面积和总数量")
   @GetMapping("/getSum")
   public ResultVO<EnclosureSimpleSumDTO> getSumBy(EnclosureListQueryDTOParam param) {
      log.info("Api调用:根据条件,查询总长度和总数量");
      return ResultBuilder.success(this.enclosureService.getSumEnclosure(param));
   }

   @ApiOperation("(新)查询总长度,总面积和总数量")
   @GetMapping("/v2/getSum")
   public ResultVO<EnclosureSimpleSumDTO> getSumEnclosure2(EnclosureListQueryDTOParam param) {
      log.info("Api调用:根据条件,查询总长度和总数量");
      return ResultBuilder.success(this.enclosureService.getSumEnclosure2(param));
   }

   @ApiOperation(value = "手动新增围护", notes = "新增围护")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('plan_enclosure_list:save')")
   public ResultVO saveEnclosure(@RequestParam Long planId, @RequestBody @Valid EnclosureSaveDTOParam saveDTOParam) {
      log.info("Api调用 : 手动新增围护");
      return ResultBuilder.success(this.enclosureBiz.saveEnclosure(planId, saveDTOParam));
   }

   @ApiOperation("批量手动新增围护")
   @ApiImplicitParam(name = "planId", value = "区域id", paramType = "query", required = true)
   @PostMapping("/saveList")
   @PreAuthorize("@permission.check('plan_enclosure_list:save')")
   public ResultVO saveEnclosureList(@RequestParam Long planId, @RequestBody @Valid List<EnclosureSaveDTOParam> saveDTOParamList) {
      log.info("Api调用 : 批量手动新增围护");
      return ResultBuilder.success(this.enclosureBiz.saveEnclosureList(planId, saveDTOParamList));
   }

   @ApiOperation("(新)批量手动新增围护")
   @PostMapping("/V2/saveList")
   public ResultVO saveEnclosureListV2(@RequestParam Long areaId, @RequestBody @Valid List<EnclosureSaveDTOParam> saveDTOParamList) {
      log.info("Api调用 : (新)批量手动新增围护");
      return ResultBuilder.success(this.enclosureBiz.saveEnclosureListV2(areaId, saveDTOParamList));
   }

   @ApiOperation("根据区域id,一键清空未排产的围护")
   @DeleteMapping("/clearByAreaId/{areaId}")
   public ResultVO oneClearEnclosure(@PathVariable Long areaId) {
      log.info("Api调用 : 根据区域id,一键清空未排产的围护");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultBuilder.success(this.enclosureBiz.enclosureAreaClear(areaId));
   }

   @ApiOperation("围护清单合计")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "category", value = "围护类型 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", paramType = "query", required = true)
      }
   )
   @GetMapping("/listSum")
   public ResultVO<ListVO<EnclosureSumDTO>> listSum(Long projectId, Long monomerId, @RequestParam Integer category) {
      log.info("Api调用 : 查看围护清单合计");
      return ResultBuilder.success(this.enclosureService.listSum(projectId, monomerId, category));
   }

   @ApiOperation(value = "导入 围护折边件附件", notes = "导入 围护折边件附件")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @PostMapping("/importAttachment")
   @PreAuthorize("@permission.check('plan_enclosure_list:import','plan_enclosure_list:save')")
   public ResultVO importAttachment(@RequestPart MultipartFile file, HttpServletRequest request) {
      log.info("Api调用: 围护附件导入");
      return ResultBuilder.success(this.enclosureService.importEnclosureAttachment(file));
   }

   @ApiOperation(value = "保存 围护折边件附件画图", notes = "画图 围护折边件附件")
   @PostMapping("/saveDrawing")
   @PreAuthorize("@permission.check('plan_enclosure_list:draw')")
   public ResultVO saveEnclosureDrawing(@RequestBody @Valid EnclosureDrawingDTOParam drawingDTOParam) {
      log.info("Api调用: 保存 围护折边件附件画图");
      return ResultBuilder.success(this.enclosureService.saveEnclosureDrawing(drawingDTOParam));
   }

   @ApiOperation("预览折边件 附件")
   @ApiImplicitParam(name = "attachmentId", value = "附件id", paramType = "path", required = true)
   @GetMapping("/preview/{attachmentId}")
   @PreAuthorize("@permission.check('plan_enclosure_list:get')")
   public void down(@PathVariable("attachmentId") Long attachmentId) {
      log.info("Api调用: 折边件附件 预览");
      this.enclosureService.downEnclosureAttachment(attachmentId);
   }

   @ApiOperation("APP预览折边件 附件")
   @ApiImplicitParam(name = "attachmentId", value = "附件id", paramType = "path", required = true)
   @GetMapping("/app/preview/{attachmentId}")
   public void downAndPreview(@PathVariable("attachmentId") Long attachmentId) {
      log.info("Api调用: 折边件附件 预览");
      this.enclosureService.downEnclosureAttachment(attachmentId);
   }

   @ApiOperation("修改围护状态 暂停/启用")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "围护id", paramType = "path", required = true),
            @ApiImplicitParam(name = "boolStatusEnum", value = "状态 true启用 false暂停", dataType = "Boolean", paramType = "query", required = true)
      }
   )
   @PreAuthorize("@permission.check('plan_enclosure_list:edit')")
   @PutMapping("/updateStatus/{id}")
   public ResultVO updateStatus(@PathVariable Long id, @RequestParam Boolean boolStatusEnum) {
      log.info("Api调用: 修改围护的状态 暂停/启用");
      return ResultBuilder.success(this.enclosureBiz.updateStatus(id, boolStatusEnum));
   }

   @ApiOperation("修改围护状态 暂停/启用")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "围护id", paramType = "path", required = true),
            @ApiImplicitParam(name = "boolStatusEnum", value = "状态 true启用 false暂停", dataType = "Boolean", paramType = "query", required = true)
      }
   )
   @PutMapping("/v2/updateStatus/{id}")
   public ResultVO updateStatusV2(@PathVariable Long id, @RequestParam Boolean boolStatusEnum) {
      log.info("Api调用: 修改围护的状态 暂停/启用");
      return ResultBuilder.success(this.enclosureBiz.updateStatusV2(id, boolStatusEnum));
   }

   @ApiOperation(value = "删除围护", notes = "根据围护id删除围护")
   @DeleteMapping
   public ResultVO deleteEnclosure(@RequestBody List<Long> ids) {
      log.info("Api调用: 根据围护id删除围护");
      return ResultBuilder.success(this.enclosureBiz.deleteEnclosure(ids));
   }

   @ApiOperation("根据围护id 查询 围护信息")
   @ApiImplicitParam(name = "id", value = "围护id", paramType = "path", required = true)
   @GetMapping("/app/id/{id}")
   public ResultVO<EnclosureDTO> getById(@PathVariable("id") Long id) {
      log.info("app端 Api调用: 根据围护id 查询围护信息");
      return ResultBuilder.success(this.enclosureBiz.getEnclosureDTOById(id));
   }

   @ApiOperation(value = "导入围护折边件图纸", notes = "导入 围护折边件图纸")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @PostMapping("/importAttachment/drawing")
   @PreAuthorize("@permission.check('plan_enclosure_list:import','plan_enclosure_list:save')")
   public ResultVO importAttachment(@RequestPart MultipartFile file, @RequestParam("id") Long id, HttpServletRequest request) {
      log.info("Api调用: 导入围护折边件图纸");
      return ResultBuilder.success(this.enclosureService.importEnclosureAttachmentDrawing(file, id));
   }

   @ApiOperation(value = "批量导入导入围护折边件图纸", notes = "批量导入围护折边件图纸")
   @ApiImplicitParam(name = "Authorization", value = "token", paramType = "header", required = true)
   @PostMapping("/importAttachment/zip")
   @PreAuthorize("@permission.check('plan_enclosure_list:import','plan_enclosure_list:save')")
   public ResultVO importAttachmentZip(@RequestPart MultipartFile file, @RequestParam Long enclosurePlanId, HttpServletRequest request) {
      log.info("Api调用: 批量导入导入围护折边件图纸");
      return ResultBuilder.success(this.enclosureService.importEnclosureAttachmentZip(file, enclosurePlanId));
   }

   @ApiOperation("围护-可申购(未排产)列表")
   @GetMapping("/unScheduling/list")
   public ResultVO<PageVO<TechEnclosureSubscribeDTO>> getUnSchedulingEnclosureList(
      @Valid EnclosureSubscribeQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:围护-可申购(未排产)列表");
      return ResultBuilder.success(this.enclosureBiz.getUnSchedulingEnclosureList(param, pageNumber, pageSize));
   }

   @ApiOperation(value = "围护清单列表", notes = "围护清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.asc")
      }
   )
   @GetMapping("/enclosureV2/listPage")
   public ResultVO<PageVO<EnclosureResponseDTO>> enclosureV2(
      EnclosureListQueryDTOParam queryDTOParam,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(name = "sort", defaultValue = "id.asc") List<String> sort
   ) {
      log.info("Api调用: 查询围护清单列表");
      return ResultBuilder.success(this.enclosureBiz.enclosureV2(queryDTOParam, pageNumber, pageSize, sort));
   }
}
