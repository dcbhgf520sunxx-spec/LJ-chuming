package com.hzchum.scim.rest.controller.business;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessArtifactBiz;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.business.core.api.biz.BusinessCheckInfoBiz;
import com.hzchum.scim.business.core.api.biz.BusinessEnclosureBiz;
import com.hzchum.scim.business.core.api.biz.BusinessMachinePartBiz;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessMachinePartDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindVOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactMergeAreaDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.CheckInfoDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureFindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.TrainTrackingDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "销售管理-商务管理")
@RestController
@RequestMapping("/api/business")
public class BusinessController {
   private static final Logger log = LoggerFactory.getLogger(BusinessController.class);
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private BusinessMachinePartBiz businessMachinePartBiz;
   @Resource
   private BusinessCheckInfoBiz businessCheckInfoBiz;
   @Resource
   private BusinessBiz businessBiz;
   @Resource
   private BusinessArtifactBiz businessArtifactBiz;
   @Resource
   private BusinessEnclosureBiz businessEnclosureBiz;

   @ApiOperation("获取商务汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('sale_price_manage:get')")
   public ResultVO summary(@RequestParam Long projectId, Long monomerId, Long areaId, @RequestParam Integer type) {
      log.info("API 调用 ：获取商务汇总");
      return ResultBuilder.success(this.businessBiz.summary(projectId, monomerId, areaId, type));
   }

   @ApiOperation("获取结构商务列表")
   @GetMapping("/artifact")
   @PreAuthorize("@permission.check('sale_price_manage:get')")
   public ResultVO listArtifact(
      ArtifactFindVOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取结构商务列表");
      return ResultBuilder.success(this.businessArtifactBiz.listByCondition(param, pageNumber, pageSize));
   }

   @ApiOperation("打印结构商务汇总")
   @GetMapping("/artifact/print")
   @PreAuthorize("@permission.check('sale_price_manage:print')")
   public ResultVO printListByCondition(ArtifactFindVOParam param) {
      log.info("API 调用 ：打印结构商务汇总");
      return ResultBuilder.success(this.businessArtifactBiz.printListByCondition(param));
   }

   @ApiOperation("获取结构商务详情")
   @GetMapping("/artifact/{businessId}")
   @PreAuthorize("@permission.check('sale_price_manage:detail')")
   public ResultVO getArtifact(@PathVariable Long businessId) {
      log.info("API 调用 ：获取结构商务详情");
      return ResultBuilder.success(this.businessBiz.listArtifactByBusinessId(businessId));
   }

   @ApiOperation("下载结构商务详情")
   @GetMapping(value = "/artifact/download/{businessId}", produces = "application/octet-stream")
   @PreAuthorize("@permission.check('sale_price_manage:print')")
   public void downloadArtifact(@PathVariable Long businessId, HttpServletResponse response) {
      log.info("API 调用 ：下载结构商务详情");
      this.businessBiz.downloadArtifactByBusinessId(businessId, response);
   }

   @ApiOperation("获取结构商务汇总")
   @GetMapping("/artifact/summary")
   @PreAuthorize("@permission.check('sale_price_manage:get')")
   public ResultVO artifactSummary(Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：获取结构商务汇总");
      return ResultBuilder.success(this.businessArtifactService.summary(projectId, monomerId, areaId));
   }

   @ApiOperation("构件合并区域")
   @PostMapping("/artifact/mergeArea")
   public ResultVO mergeArtifactBusinessArea(@RequestBody @Valid ArtifactMergeAreaDTOParam param) {
      log.info("API 调用:合并结构商务区域");
      return ResultBuilder.success(this.businessArtifactBiz.mergeArtifactArea(param));
   }

   @ApiOperation("获取围护商务列表")
   @GetMapping("/enclosure")
   @PreAuthorize("@permission.check('sale_price_manage:get')")
   public ResultVO listEnclosure(
      EnclosureFindDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取围护商务列表");
      return ResultBuilder.success(this.businessEnclosureBiz.pageListByCondition(param, pageNumber, pageSize));
   }

   @ApiOperation("打印围护商务列表")
   @GetMapping("/enclosure/print")
   @PreAuthorize("@permission.check('sale_price_manage:print')")
   public ResultVO printListByCondition(EnclosureFindDTOParam param) {
      log.info("API 调用 ：打印围护商务列表");
      return ResultBuilder.success(this.businessEnclosureBiz.printListByCondition(param));
   }

   @ApiOperation("获取围护商务详情")
   @GetMapping("/enclosure/{businessId}")
   @PreAuthorize("@permission.check('sale_price_manage:detail')")
   public ResultVO getEnclosure(@PathVariable Long businessId) {
      log.info("API 调用 ：获取围护商务详情");
      return ResultBuilder.success(this.businessBiz.listEnclosureByBusinessId(businessId));
   }

   @ApiOperation("获取围护商务汇总")
   @GetMapping("/enclosure/summary")
   @PreAuthorize("@permission.check('sale_price_manage:get')")
   public ResultVO enclosureSummary(Long projectId, Long monomerId) {
      log.info("API 调用 ：获取围护商务汇总");
      return ResultBuilder.success(this.businessEnclosureService.summary(projectId, monomerId));
   }

   @ApiOperation("获取零件-直发件商务列表")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "specification", value = "规格", paramType = "query"), @ApiImplicitParam(name = "material", value = "材质", paramType = "query")}
   )
   @GetMapping("/machine-part")
   public ResultVO<PageVO<BusinessMachinePartDTO>> listBusinessMachinePart(
      @RequestParam Long monomerId,
      Long areaId,
      String specification,
      String material,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取零件直发件商务列表");
      return ResultBuilder.success(this.businessMachinePartBiz.pageListBusinessMachinePart(monomerId, areaId, specification, material, pageNumber, pageSize));
   }

   @ApiOperation("零件直发件商务列表-打印")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "specification", value = "规格", paramType = "query"), @ApiImplicitParam(name = "material", value = "材质", paramType = "query")}
   )
   @GetMapping("/machine-part/print")
   public ResultVO printListBusinessMachinePart(
      @RequestParam Long monomerId, Long areaId, String specification, String material, @RequestParam(required = false) List<Long> ids
   ) {
      log.info("API 调用 ：打印零件直发件商务列表");
      return ResultBuilder.success(this.businessMachinePartBiz.printListBusinessMachinePart(monomerId, areaId, specification, material, ids));
   }

   @ApiOperation("根据零件商务ID,查询零件列表")
   @GetMapping("/machine-part/{businessId}")
   public ResultVO listMachinePartByBusinessId(@PathVariable Long businessId) {
      log.info("API 调用 ：根据零件直发件商务ID,查询零件列表");
      return ResultBuilder.success(this.businessMachinePartBiz.listMachinePartByBusinessId(businessId));
   }

   @ApiOperation("根据零件商务ID,打印零件列表")
   @GetMapping("/machine-part/{businessId}/print")
   public ResultVO printMachinePartByBusinessId(@PathVariable Long businessId) {
      log.info("API 调用 ：根据零件直发件商务ID,打印零件列表");
      return ResultBuilder.success(this.businessMachinePartBiz.printMachinePartByBusinessId(businessId));
   }

   @ApiOperation("获取零件直发件-商务汇总")
   @GetMapping("/machine-part/summary")
   public ResultVO<SummaryDTO> machinePartSummary(Long monomerId) {
      log.info("API 调用 ：获取零件-直发件商务汇总");
      return ResultBuilder.success(this.businessMachinePartBiz.summaryMachinePart(monomerId));
   }

   @ApiOperation("构件商务下拉框")
   @GetMapping("/artifact/simple")
   @PreAuthorize("@permission.check('sale_price_manage:get')")
   public ResultVO listStructureBusiness(@RequestParam Long monomerId) {
      log.info("API 调用 ：构件商务下拉框");
      return ResultBuilder.success(this.businessArtifactService.listSimple(monomerId));
   }

   @ApiOperation("批量修改商务")
   @PutMapping
   @PreAuthorize("@permission.check('sale_price_manage:edit')")
   public ResultVO update(@Validated @RequestBody CheckInfoDTOParam request) {
      log.info("API 调用 ：批量修改商务");
      return ResultBuilder.success(this.businessCheckInfoBiz.setUnitPrice(request));
   }

   @ApiOperation("商务绑定")
   @PutMapping("bind")
   public ResultVO bind(@RequestBody @Validated BindDTOParam param) {
      log.info("API 调用 ：商务绑定");
      return ResultBuilder.success(this.businessBiz.bind(param));
   }

   @ApiOperation("车次跟踪列表")
   @GetMapping("/train/tracking")
   public ResultVO pageTrainTracking(TrainTrackingDTOParam param) {
      log.info("API 调用 ：车次跟踪列表");
      return ResultBuilder.success(this.businessBiz.pageTrainTracking(param));
   }

   @ApiOperation("车次详情")
   @GetMapping("/train/tracking/{id}")
   @PreAuthorize("@permission.check('sale_price_manage:detail')")
   public ResultVO getTrainTracking(@PathVariable Long id) {
      log.info("API 调用 ：车次详情");
      return ResultBuilder.success(this.businessBiz.getTrainTracking(id));
   }
}
