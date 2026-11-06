package com.hzchum.scim.rest.controller.mes.building.abnormal;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.abnormal.MesBuildingAbnormalBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal.MesBuildingAbnormalDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalChangeReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceAbonrmalReportAndLimitDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.TaskChangeDTOParam;
import com.hzchum.scim.mes.building.core.api.service.abnormal.MesBuildingAbnormalService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.abnormal.put.AbnormalHandleVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.abnormal.put.HandlePreviewVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.abnormal.put.TaskChangeListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdVoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES异常处理")
@RestController
@RequestMapping("/api/mes/building/abnormal")
public class MesBuildingAbnormalController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAbnormalController.class);
   @Autowired
   private MesBuildingAbnormalBiz abnormalBiz;
   @Autowired
   private MesBuildingAbnormalService abnormalService;

   @ApiOperation("获取生产上报记录")
   @GetMapping("/report")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   public ResultVO<ProduceAbonrmalReportAndLimitDTO> reportList(Long id) {
      log.info("API 调用 ：获取生产上报记录");
      return ResultBuilder.success(this.abnormalBiz.reportList(id));
   }

   @ApiOperation("测试清单修改")
   @GetMapping("/test")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", dataType = "Long", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "quantity", value = "数量", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "changeType", value = "修改类型", dataType = "Integer", paramType = "query", required = true)
      }
   )
   public ResultVO<Boolean> test(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Integer productType,
      Integer oldQuantity,
      Integer newQuantity,
      String changeType,
      Boolean boolSurplusEnum,
      Long artifactId,
      String artifactSerialNumber
   ) {
      log.info("API 调用 ：测试清单修改");
      return ResultBuilder.success(
         this.abnormalBiz
            .changeProductQuantity(
               projectId, monomerId, areaId, productId, productType, oldQuantity, newQuantity, changeType, true, artifactId, artifactSerialNumber, null, null
            )
      );
   }

   @ApiOperation("获取异常列表")
   @GetMapping("")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "projectName", value = "项目名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "date", value = "时间", dataType = "LocalDateTime", paramType = "query")
      }
   )
   public ResultVO<ListVO<MesBuildingAbnormalDTO>> abnormalList(
      Long id,
      @RequestParam("productType") Integer productType,
      String projectName,
      String serialNumber,
      Integer status,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime date
   ) {
      log.info("API 调用 ：获取异常列表");
      return ResultBuilder.success(
         new ListVO<>(this.abnormalService.abnormalList(id, productType, projectName, serialNumber, status, projectId, monomerId, areaId, date))
      );
   }

   @ApiOperation("获取异常-分页")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "projectName", value = "项目名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "编号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "区域", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "date", value = "时间", dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "条数", dataType = "Integer", paramType = "query")
      }
   )
   public ResultVO<PageVO<MesBuildingAbnormalDTO>> abnormalPage(
      Long id,
      @RequestParam("productType") Integer productType,
      String projectName,
      String serialNumber,
      Integer status,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime date,
      String sort,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取异常-分页");
      return ResultBuilder.success(
         this.abnormalService.abnormalPage(id, productType, projectName, serialNumber, status, projectId, monomerId, areaId, date, sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("修改处理状态")
   @PutMapping("/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   public ResultVO<Integer> changeStatus(@PathVariable Long id) {
      log.info("API 调用 ：修改处理状态");
      return ResultBuilder.success(this.abnormalBiz.updateAbnormalStatus(id));
   }

   @ApiOperation("修改任务")
   @PutMapping("/handle/task")
   public ResultVO<Boolean> changeTaskQuantity(@RequestBody TaskChangeListVORequest voRequestList) {
      log.info("API 调用 ：修改任务");
      return ResultBuilder.success(
         this.abnormalBiz
            .changeTaskQuantity(
               voRequestList.getAbnormalId(),
               voRequestList.getTaskChange().stream().map(e -> BeanUtil.copy(e, TaskChangeDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("处理异常")
   @PutMapping("/handle/abnormal")
   public ResultVO<Boolean> handleAbnormal(@RequestBody AbnormalHandleVORequest voRequestList) {
      log.info("API 调用 ：新增异常生产记录");
      return ResultBuilder.success(this.abnormalBiz.handleAbnormal(voRequestList.getVoList(), voRequestList.getAbnormalId()));
   }

   @ApiOperation("查询任务数")
   @GetMapping("/task")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", dataType = "Long", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型", dataType = "Integer", paramType = "query", required = true)
      }
   )
   public ResultVO<AbnormalTaskDTO> taskQuantity(Long productId, Integer productType) {
      log.info("API 调用 ：查询任务数");
      return ResultBuilder.success(this.abnormalBiz.taskQuantityList(productId, productType));
   }

   @ApiOperation("查询处理记录")
   @GetMapping("/change/report")
   public ResultVO<ListVO<AbnormalChangeReportDTO>> abonrmalChangeReport(Long id) {
      log.info("API 调用 ：查询任务数");
      return ResultBuilder.success(new ListVO<>(this.abnormalBiz.abonrmalChangeReport(id)));
   }

   @ApiOperation("处理异常预览")
   @PutMapping("/handle/preview")
   public ResultVO handlePreview(@RequestBody HandlePreviewVORequest request) {
      log.info("API 调用 ：处理异常预览");
      return ResultBuilder.success(new ListVO<>(this.abnormalBiz.handlePreview(request.getAbnormalId(), request.getTaskList(), request.getReportList())));
   }

   @ApiOperation("修改数量预览")
   @GetMapping("/change/preview")
   public ResultVO changePreview(Long productId, Integer productType, Integer oldQuantity, Integer newQuantity) {
      log.info("API 调用 ：修改数量预览");
      return ResultBuilder.success(new ListVO<>(this.abnormalBiz.changePreview(productId, productType, oldQuantity, newQuantity)));
   }

   @ApiOperation("变更预览")
   @GetMapping("/preview")
   public ResultVO preview(Long id) {
      log.info("API 调用 ：变更预览");
      return ResultBuilder.success(this.abnormalBiz.preview(id));
   }

   @ApiOperation("变更产品信息预览")
   @GetMapping("/product/info")
   public ResultVO productInfo(Long id, Integer productType) {
      log.info("API 调用 ：变更产品信息预览");
      return ResultBuilder.success(this.abnormalBiz.productInfo(id, productType));
   }

   @ApiOperation("处理零件变更异常")
   @PutMapping("/handle/part")
   public ResultVO handlePart(@RequestBody IdVoRequest id) {
      log.info("API 调用 ：变更产品信息预览");
      return ResultBuilder.success(this.abnormalBiz.handlePart(id.getId()));
   }
}
