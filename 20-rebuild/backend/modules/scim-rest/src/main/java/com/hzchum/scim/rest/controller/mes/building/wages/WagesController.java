package com.hzchum.scim.rest.controller.mes.building.wages;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingPriceChangeBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingProduceTeamReportPriceBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.put.ChangeProductWageDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.wages.put.ChangeProductWageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES产线工资")
@RestController
@RequestMapping("/api/mes/building/price")
public class WagesController {
   private static final Logger log = LoggerFactory.getLogger(WagesController.class);
   @Autowired
   private MesBuildingProduceTeamReportPriceBiz priceBiz;
   @Autowired
   private MesBuildingPriceChangeBiz priceChangeBiz;

   @ApiOperation("根据时间获取全年价格汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('mes_production_statistics:statistics')")
   public ResultVO getProductionPriceSummary(LocalDateTime dateTime) {
      log.info("API 调用 ：根据时间获取全年价格汇总");
      return ResultBuilder.success(this.priceBiz.getProductionPriceSummary(dateTime));
   }

   @ApiOperation("根据条件获取工序价格汇总")
   @GetMapping("process/list")
   @PreAuthorize("@permission.check('mes_production_statistics:get')")
   public ResultVO getProcessPriceList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId) {
      log.info("API 调用 ：根据条件获取工序价格汇总");
      return ResultBuilder.success(new ListVO<>(this.priceBiz.getProcessPriceList(startTime, endTime, workshopId)));
   }

   @ApiOperation("根据条件获取工序价格详情列表")
   @GetMapping("process/details/list")
   public ResultVO getProcessPriceDetailsList(
      LocalDateTime startTime, LocalDateTime endTime, Long workshopId, @RequestParam(name = "processId") Long processId, String userName
   ) {
      log.info("API 调用 ：根据条件获取工序价格详情-分页");
      return ResultBuilder.success(new ListVO<>(this.priceBiz.getProcessPriceDetailsList(startTime, endTime, workshopId, processId, userName)));
   }

   @ApiOperation("下载表单")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('mes_production_statistics:export')")
   public void exportPriceExcel(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long workshopId,
      @RequestParam(name = "processId") Long processId,
      String userName,
      HttpServletRequest request,
      HttpServletResponse response
   ) {
      log.info("Api 调用 : 下载表单");
      this.priceBiz.exportPriceExcel(startTime, endTime, workshopId, processId, userName, request, response);
   }

   @ApiOperation("工价调整-构件类型汇总列表")
   @GetMapping("/change/product/type")
   public ResultVO getProductTypeList(
      @RequestParam(name = "projectId") Long projectId, Long monomerId, Long areaId, @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum
   ) {
      log.info("Api 调用 : 构件类型汇总列表");
      return ResultBuilder.success(new ListVO<>(this.priceChangeBiz.getProductTypeList(projectId, monomerId, areaId, taskTypeEnum)));
   }

   @ApiOperation("工价调整-工序列表")
   @GetMapping("/change/product/type/{id}/process")
   @PreAuthorize("@permission.check('mes_wage_adjust:get')")
   public ResultVO getProductTypeProcessList(Long configId, @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum) {
      log.info("Api 调用 : 构件类型汇总列表");
      return ResultBuilder.success(new ListVO<>(this.priceChangeBiz.getProductTypeProcessList(configId, taskTypeEnum)));
   }

   @ApiOperation("工价调整-构件类型汇总列表")
   @GetMapping("/change/product/page")
   public ResultVO getProductPriceList(
      @RequestParam(name = "configId") Long configId,
      @RequestParam(name = "processId") Long processId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("Api 调用 : 构件类型汇总列表");
      return ResultBuilder.success(
         this.priceChangeBiz.getProductPricePage(configId, processId, projectId, monomerId, areaId, serialNumber, taskTypeEnum, pageNumber, pageSize)
      );
   }

   @ApiOperation("工价调整—批量修改工价")
   @PutMapping("/change/product")
   @PreAuthorize("@permission.check('mes_wage_adjust:edit')")
   public ResultVO changeProductWage(@RequestBody List<ChangeProductWageRequest> requestList) {
      log.info("Api 调用 : 修改工价");
      return ResultBuilder.success(
         this.priceChangeBiz
            .changeProductWage(requestList.stream().map(request -> BeanUtil.copy(request, ChangeProductWageDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("栓钉套筒统计")
   @GetMapping("/stud/sleeve/page")
   public ResultVO studSleevePage(
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer auxiliaryTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("Api 调用 : 栓钉套筒统计");
      return ResultBuilder.success(this.priceChangeBiz.studSleevePage(projectId, startDate, endDate, auxiliaryTypeEnum, pageNumber, pageSize));
   }

   @ApiOperation("栓钉套筒统计--打印")
   @GetMapping("/stud/sleeve/print")
   public ResultVO studSleevePrint(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum) {
      log.info("Api 调用 : 栓钉套筒统计--打印");
      return ResultBuilder.success(this.priceChangeBiz.studSleevePrint(projectId, startDate, endDate, auxiliaryTypeEnum));
   }
}
