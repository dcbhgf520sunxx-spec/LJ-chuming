package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWorkshopBiz;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.IdsVoRequest;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.WorkshopSaveVORequest;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.WorkshopUpdateVORequest;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWorkshopDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.workShop.get.WorkshopListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.workShop.put.WorkshopStatusUpdateVORequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES车间")
@RestController
@RequestMapping("/api/mes/building/workshop")
public class MesBuildingWorkshopController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWorkshopController.class);
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingWorkshopBiz workshopBiz;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private OutboundService outboundService;
   @Autowired
   private MesBuildingCompleteService completeService;

   @ApiOperation("获取车间列表")
   @GetMapping
   public ResultVO<ListVO<MesBuildingWorkshop>> workshopList(WorkshopListVORequest voRequest) {
      log.info("API 调用 ：获取车间列表");
      Integer requestedType = Arrays.stream(WorkShopTypeEnum.values())
         .map(WorkShopTypeEnum::getType)
         .filter(type -> type.toString().equals(voRequest.getType()))
         .findFirst()
         .orElse(null);
      return ResultBuilder.success(
         new ListVO<>(this.workshopService.listByCondition(BeanUtil.copy(voRequest, MesBuildingWorkshopDTOParam.class), requestedType))
      );
   }

   @ApiOperation("获取车间")
   @GetMapping("/{id}")
   public ResultVO<MesBuildingWorkshop> workshopById(@PathVariable Long id) {
      log.info("API 调用 ：获取车间列表");
      return ResultBuilder.success(this.workshopService.getById(id));
   }

   @ApiOperation("获取车间列表-分页")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "分页请求类", paramType = "query", dataTypeClass = WorkshopListVORequest.class),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('workshop:get','factorySummary')")
   public ResultVO<PageVO<MesBuildingWorkshop>> workshopPage(
      WorkshopListVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取车间列表-分页");
      return ResultBuilder.success(
         this.workshopService
            .workshopPage(BeanUtil.copy(voRequest, MesBuildingWorkshopDTOParam.class), sort, pageNumber, pageSize, WorkShopTypeEnum.BUILDING.getType())
      );
   }

   @ApiOperation("新增车间")
   @PostMapping
   @PreAuthorize("@permission.check('workshop:add','factorySummary')")
   public ResultVO<Boolean> workshopSave(@RequestBody @Valid WorkshopSaveVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增车间");
      return ResultBuilder.success(this.workshopService.workshopSave(voRequest, UserUtil.getCurrentUserId()));
   }

   @ApiOperation("修改车间")
   @PutMapping
   @PreAuthorize("@permission.check('workshop:edit','factorySummary')")
   public ResultVO<Boolean> workshopUpdate(@RequestBody @Valid WorkshopUpdateVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改车间");
      return ResultBuilder.success(this.workshopService.workshopUpdate(voRequest, UserUtil.getCurrentUserId()));
   }

   @ApiOperation("删除车间")
   @DeleteMapping
   @PreAuthorize("@permission.check('workshop:del','factorySummary')")
   public ResultVO<Boolean> workshopDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除车间");
      return ResultBuilder.success(this.workshopBiz.workshopDelete(voRequest));
   }

   @ApiOperation("修改车间禁用状态")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('workshop:editStatus')")
   public ResultVO<Boolean> workshopStateUpdate(@RequestBody @Valid WorkshopStatusUpdateVORequest voRequest) {
      log.info("API 调用 ：修改车间禁用状态");
      return ResultBuilder.success(
         this.workshopBiz.workshopStateUpdate(BeanUtil.copy(voRequest, MesBuildingWorkshopDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("获取车间报表")
   @GetMapping("/report")
   public ResultVO getWorkshopReport(LocalDateTime dateTime, Long workShopId, Long productionLineId, Integer type) {
      log.info("API 调用 ：获取车间报表");
      return ResultBuilder.success(this.completeService.getWorkshopReport(dateTime, workShopId, productionLineId, type));
   }

   @ApiOperation("全年累计产量")
   @GetMapping("/year/mete/summary")
   public ResultVO meteSummaryByYear(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      log.info("API 调用 ：全年累计产量");
      return ResultBuilder.success(this.completeService.meteSummaryByYear(dateTime, workShopId, productionLineId));
   }

   @ApiOperation("车间报表清单-分页")
   @GetMapping("/artifact/summary/page")
   @PreAuthorize("@permission.check('mes_factory_report:get')")
   public ResultVO artifactSummaryPage(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      @RequestParam(name = "workShopId", required = false) Long workShopId,
      @RequestParam(name = "productionLineId", required = false) Long productionLineId,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：车间报表清单-分页");
      return ResultBuilder.success(
         this.completeService.artifactSummaryPage(startTime, endTime, workShopId, productionLineId, projectId, name, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印车间报表清单")
   @GetMapping("/artifact/summary/print")
   @PreAuthorize("@permission.check('mes_factory_report:print')")
   public ResultVO artifactSummaryPrint(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      @RequestParam(name = "workShopId", required = false) Long workShopId,
      @RequestParam(name = "productionLineId", required = false) Long productionLineId,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "name", required = false) String name
   ) {
      log.info("API 调用 ：打印车间报表清单");
      return ResultBuilder.success(this.completeService.artifactSummaryPrint(startTime, endTime, workShopId, productionLineId, projectId, name));
   }

   @ApiOperation("产量汇总")
   @GetMapping("/mete/summary")
   public ResultVO meteSummary(
      @RequestParam(name = "startTime", required = false) LocalDateTime startTime,
      @RequestParam(name = "endTime", required = false) LocalDateTime endTime,
      @RequestParam(name = "workShopId", required = false) Long workShopId,
      @RequestParam(name = "productionLineId", required = false) Long productionLineId,
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "name", required = false) String name
   ) {
      log.info("API 调用 ：产量汇总");
      return ResultBuilder.success(this.completeService.meteSummary(startTime, endTime, workShopId, productionLineId, projectId, name));
   }

   @ApiOperation("获取车间产线班组列表")
   @GetMapping("/query/condition")
   public ResultVO getProjectQueryCondition() {
      log.info("API 调用 ：获取车间产线班组列表");
      return ResultBuilder.success(new ListVO<>(this.workshopBiz.getWorkShopQueryCondition()));
   }
}
