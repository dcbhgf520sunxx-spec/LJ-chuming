package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingAreaSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.productionLineInformationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingAreaSchedulingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductMetesDTO;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.put.MesBuildingAreaSchedulingUpdateVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES区域排产")
@RestController
@RequestMapping("/api/mes/building/scheduling/area")
public class MesBuildingAreaSchedulingController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAreaSchedulingController.class);
   @Resource
   private MesBuildingAreaSchedulingBiz areaSchedulingBiz;

   @ApiOperation("获取项目排产列表")
   @GetMapping("/project/list")
   @PreAuthorize("@permission.check('mes_production_order:get')")
   public ResultVO getProjectSchedulingList(
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate
   ) {
      log.info("API 调用 ：获取项目排产列表");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getProjectScheduling(dateTime, status, endDate, null, null)));
   }

   @ApiOperation("获取项目排产分页列表")
   @GetMapping("/project/page")
   @PreAuthorize("@permission.check('mes_production_order:get')")
   public ResultVO getProjectSchedulingPage(
      @RequestParam(name = "year", required = false) LocalDateTime year,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "month", required = false) Integer month,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer level,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取项目排产分页列表");
      return ResultBuilder.success(
         this.areaSchedulingBiz.getProjectSchedulingPage(year, status, endDate, projectType, lumpSumSystemType, pageNumber, pageSize, month, projectId, level)
      );
   }

   @ApiOperation("获取区域排产列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('mes_production_order:detail')")
   public ResultVO getAreaSchedulingList(
      @RequestParam(name = "projectId") Integer projectId, @RequestParam(required = false, defaultValue = "1") Integer projectType
   ) {
      log.info("API 调用 ：获取区域排产列表");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getAreaSchedulingList(projectId, projectType)));
   }

   @ApiOperation("获取区域排产列表")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('mes_production_order:detail')")
   public ResultVO getAreaSchedulingPage(
      @RequestParam(name = "projectId") Integer projectId,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取区域排产列表");
      return ResultBuilder.success(this.areaSchedulingBiz.getAreaSchedulingPage(projectId, projectType, pageNumber, pageSize));
   }

   @ApiOperation("修改区域排产信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('mes_production_order:edit')")
   public ResultVO updateAreaScheduling(@RequestBody @Validated List<MesBuildingAreaSchedulingUpdateVORequest> voRequestList) {
      log.info("API 调用 ：修改区域排产信息");
      return ResultBuilder.success(
         this.areaSchedulingBiz
            .updateAreaScheduling(voRequestList.stream().map(e -> BeanUtil.copy(e, MesBuildingAreaSchedulingDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("获取产品汇总")
   @GetMapping("/summary")
   public ResultVO<ProductMetesDTO> getSumMeteByCondition(@RequestParam(name = "projectId") Long projectId) {
      log.info("API 调用 ：获取产品汇总");
      return ResultBuilder.success(this.areaSchedulingBiz.getSumMeteByCondition(projectId));
   }

   @ApiOperation("获取构件清单列表")
   @GetMapping("/artifact/list")
   @PreAuthorize("@permission.check('mes_production_order:detailList')")
   public ResultVO getArtifactList(
      @RequestParam(name = "classificationName") String classificationName,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：获取构件清单列表");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getArtifactList(classificationName, material, projectId)));
   }

   @ApiOperation("打印构件清单列表")
   @GetMapping("/listArtifact/print")
   public ResultVO listArtifactByCondition(
      @RequestParam(name = "classificationName") String classificationName,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：打印构件清单列表");
      return ResultBuilder.success(this.areaSchedulingBiz.printArtifactByCondition(classificationName, material, projectId));
   }

   @ApiOperation("获取部件清单列表")
   @GetMapping("/assemble/list")
   @PreAuthorize("@permission.check('mes_production_order:detailList')")
   public ResultVO getAssembleList(
      @RequestParam(name = "classificationName") String classificationName,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：获取部件清单列表");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getAssembleList(classificationName, material, projectId)));
   }

   @ApiOperation("打印部件清单列表")
   @GetMapping("/listAssemble/print")
   public ResultVO listAssembleByCondition(
      @RequestParam(name = "classificationName") String classificationName,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：打印部件清单列表");
      return ResultBuilder.success(this.areaSchedulingBiz.printAssembleByCondition(classificationName, material, projectId));
   }

   @ApiOperation("获取零件清单列表")
   @GetMapping("/machinePart/list")
   @PreAuthorize("@permission.check('mes_production_order:detailList')")
   public ResultVO getMachinePartList(
      @RequestParam(name = "classificationName") String classificationName,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "specification", required = false) String specification,
      @RequestParam(name = "boolHaveHole", required = false) Boolean boolHaveHole,
      @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：获取零件清单列表");
      return ResultBuilder.success(
         new ListVO<>(this.areaSchedulingBiz.getMachinePartList(classificationName, material, specification, boolHaveHole, projectId))
      );
   }

   @ApiOperation("打印零件清单列表")
   @GetMapping("/listMachinePart/print")
   public ResultVO listMachinePartByCondition(
      @RequestParam(name = "classificationName") String classificationName,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "specification", required = false) String specification,
      @RequestParam(name = "boolHaveHole", required = false) Boolean boolHaveHole,
      @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：打印零件清单列表");
      return ResultBuilder.success(this.areaSchedulingBiz.printMachinePartByCondition(classificationName, material, specification, boolHaveHole, projectId));
   }

   @ApiOperation("获取排产车间")
   @GetMapping("/tree/workshop")
   public ResultVO getSchedulingWorkshop(
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：获取排产车间");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getSchedulingWorkshop(projectType, lumpSumSystemType, level)));
   }

   @ApiOperation("获取排产时间")
   @GetMapping("/tree/time")
   public ResultVO getSchedulingTime(
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      Long workshopId,
      @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：获取排产时间");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getSchedulingTime(projectType, lumpSumSystemType, workshopId, level)));
   }

   @ApiOperation("获取排产区域")
   @GetMapping("/tree/list")
   public ResultVO getScheduling(
      @RequestParam(name = "dateTime") LocalDateTime dateTime,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      Long workshopId,
      @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：获取排产区域");
      return ResultBuilder.success(new ListVO<>(this.areaSchedulingBiz.getProjectScheduling(dateTime, projectType, lumpSumSystemType, workshopId, level)));
   }

   @ApiOperation("所选车间月份待排产汇总")
   @GetMapping("/tree/summary")
   public ResultVO getSchedulingDataSummary(
      Long factoryId, Long workshopId, @RequestParam(name = "dateTime") LocalDateTime dateTime, @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：所选车间月份待排产汇总");
      return ResultBuilder.success(this.areaSchedulingBiz.getSchedulingDataSummary(factoryId, workshopId, dateTime, level));
   }

   @ApiOperation("获取零构件清单")
   @GetMapping("/project")
   @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "类型"), @ApiImplicitParam(name = "projectId", value = "项目id")})
   @PreAuthorize("@permission.check('mes_production_order:detailList')")
   public ResultVO<List<ComponentCrderInformationDTO>> getComponentsDetailed(
      @RequestParam(name = "type") Integer productType, @RequestParam(name = "projectId") Long projectId
   ) {
      log.info("API 调用 ：获取零构件清单");
      return ResultBuilder.success(this.areaSchedulingBiz.getComponentsDetailed(productType, projectId));
   }

   @ApiOperation("获取车间产线的信息")
   @GetMapping("/factory")
   public ResultVO<List<productionLineInformationDTO>> productionLineInformation(
      @RequestParam(name = "projectId") Long projectId, @RequestParam(name = "factoryId", required = false) Long factoryId
   ) {
      log.info("API 调用 ：获取车间产线的信息");
      List<productionLineInformationDTO> productionLineInformationDTOS = this.areaSchedulingBiz.productionLineInformation(projectId, factoryId);
      return ResultBuilder.success(productionLineInformationDTOS);
   }

   @ApiOperation("获取项目排产汇总信息")
   @GetMapping("/project/summay")
   public ResultVO<ProjectSummaryDTO> getProjectSchedulingSummay(
      @RequestParam(name = "year", required = false) LocalDateTime year,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "month", required = false) Integer month,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(required = false, name = "projectId") Long projectId,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：获取项目排产汇总信息");
      return ResultBuilder.success(this.areaSchedulingBiz.getProjectSchedulingSummay(year, status, endDate, month, projectId, projectType, lumpSumSystemType));
   }
}
