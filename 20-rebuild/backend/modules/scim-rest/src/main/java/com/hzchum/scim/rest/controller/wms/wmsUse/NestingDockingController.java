package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "WMS-排产对接")
@RestController
@RequestMapping("/api/wms/nesting-docking")
public class NestingDockingController {
   private static final Logger log = LoggerFactory.getLogger(NestingDockingController.class);
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   OutboundService outboundService;

   @ApiOperation("套料-钢板查询")
   @GetMapping("/steel-plate")
   public ResultVO getNestingDockingSteelPlate(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：钢板查询");
      return ResultBuilder.success(this.materialInventoryService.nestingDockingPageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("钢板排产出库")
   @PutMapping("/steel-plate/batchNestingDocking")
   public ResultVO steelPlateBatch(@Valid @RequestBody BatchSchedulingOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：钢板排产出库");
      return ResultBuilder.success(this.outboundService.BatchNestingDockingOutbound(param));
   }

   @ApiOperation("根据条件查询排产出库领料列表")
   @GetMapping("/nestingDockingPageInfo")
   public ResultVO nestingDockingPageInfo(
      QueryOutboundDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件查询排产出库领料列表");
      return ResultBuilder.success(this.outboundService.nestingDockingPageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据出库单Id查询排产出库明细")
   @GetMapping("/nestingDockingGetById/{id}")
   public ResultVO nestingDockingGetById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据条件查询排产出库领料列表");
      return ResultBuilder.success(this.outboundService.nestingDockingGetById(id));
   }

   @ApiOperation("工单套料冻结明细")
   @GetMapping("/getNestingFreezeDetail")
   @PreAuthorize("@permission.check('wms_mes_receipt_review:detail')")
   public ResultVO getNestingFreezeDetail(@RequestParam(value = "id", required = false) Long id) {
      if (id == null || id <= 0) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, "工单id不能为空");
      }
      return ResultBuilder.success(this.materialFreezeService.getNestingFreezeDetail(id));
   }

   @ApiOperation("查询零件排产钢板绑定物料")
   @GetMapping("/getSchedulingMaterial")
   public ResultVO getSchedulingMaterial(Long id) {
      log.info("API 调用 ：查询零件排产钢板绑定物料信息");
      return ResultBuilder.success(this.outboundService.getSchedulingMaterial(id));
   }

   @ApiOperation("项目领料查询")
   @GetMapping("/getProjectPicking")
   @PreAuthorize("@permission.check('mes_project_material:get')")
   public ResultVO getProjectPicking(QueryProjectPickingDTOParam param) {
      log.info("API 调用 ：项目领料查询");
      return ResultBuilder.success(this.outboundService.getProjectPicking(param));
   }

   @ApiOperation("项目领料查询获取领料量")
   @GetMapping("/PickingMete")
   public ResultVO PickingMete(QueryProjectPickingDTOParam param) {
      log.info("API 调用 ：项目领料查询获取领料量");
      return ResultBuilder.success(this.outboundService.PickingMete(param));
   }

   @ApiOperation("项目领料查询获取累计领料量")
   @GetMapping("/CumulativePickingMete")
   @PreAuthorize("@permission.check('mes_project_material:get')")
   public ResultVO CumulativePickingMete(QueryProjectPickingDTOParam param) {
      log.info("API 调用 ：项目领料查询获取累计领料量");
      return ResultBuilder.success(this.outboundService.CumulativePickingMete(param));
   }

   @ApiOperation("项目领料下载")
   @GetMapping("/ProjectPickingDownload")
   @PreAuthorize("@permission.check('mes_project_material:print')")
   public void ProjectPickingDownload(QueryProjectPickingDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：项目领料下载");
      this.outboundService.ProjectPickingDownload(param, response);
   }

   @ApiOperation("套料型材库存总长度")
   @GetMapping("/countLength")
   @PreAuthorize("@permission.check('mes_scheduling_section_machine_part:noNestingSave')")
   public ResultVO countLength(QueryByMaterialDTOParam param) {
      if (param.getSpecNumber() == null || param.getSpecification() == null || !param.getSpecification().contains(" * ")) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, "截面编号和完整规格不能为空");
      }
      return ResultBuilder.success(this.materialInventoryService.getCountLength(param));
   }

   @ApiOperation("套料-型材查询")
   @GetMapping("/section-steel")
   public ResultVO getSectionSteelNestingDockingPageInfo(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：型材查询");
      return ResultBuilder.success(this.materialInventoryService.sectionSteelNestingDockingPageInfo(param, pageNumber, pageSize, sort));
   }
}
