package com.hzchum.scim.rest.controller.cut.lantek;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.service.CutTaskProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "切割套料工单")
@RestController
@RequestMapping("/api/order")
public class OrderController {
   private static final Logger log = LoggerFactory.getLogger(OrderController.class);
   @Resource
   private CutTaskProjectService cutTaskProjectService;

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @ApiOperation("投料操作")
   @PostMapping("/feedingOperation")
   public ResultVO feedingOperation(
      Integer pageNumber,
      Integer pageSize,
      @RequestBody List<Long> areaIdList,
      Long projectId,
      String thick,
      String material,
      Integer relationType,
      String serialNumber,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      return this.cutTaskProjectService.feedingOperation(pageNumber, pageSize, areaIdList, projectId, thick, material, relationType, serialNumber, sort);
   }

   @ApiOperation("创建工单")
   @PostMapping("/createOrder")
   public ResultVO createOrder(@RequestBody List<Long> techMachinePartIds, Long projectId) {
      return this.cutTaskProjectService.createOrder(techMachinePartIds, projectId);
   }

   @ApiOperation("从工单删除零件")
   @PostMapping("/deletePartFromOrder")
   public ResultVO deletePartFromOrder(@RequestBody List<Long> techMachinePartIds, String cutTaskId) {
      return this.cutTaskProjectService.deletePartFromOrder(techMachinePartIds, cutTaskId);
   }

   @ApiOperation("增加零件到工单")
   @PostMapping("/addPartFromOrder")
   public ResultVO addPartFromOrder(@RequestBody List<Long> techMachinePartIds, String cutTaskId) {
      return this.cutTaskProjectService.addPartFromOrder(techMachinePartIds, cutTaskId);
   }

   @ApiOperation("修改工单按钮 nestingState=1(需要删除)  nestingState=2(需要新增)")
   @GetMapping("/updateOrder")
   public ResultVO updateOrder(String cutTaskId) {
      return this.cutTaskProjectService.updateOrder(cutTaskId);
   }

   @ApiOperation("撤销工单")
   @DeleteMapping("/deletesOrder/{cutTaskId}")
   @Transactional(rollbackFor = Exception.class)
   public ResultVO deletesTask(@PathVariable("cutTaskId") String cutTaskId) {
      return this.cutTaskProjectService.deleteTask(cutTaskId);
   }

   @ApiOperation("上传工单")
   @GetMapping("/uploadOrder/{cutTaskId}")
   public ResultVO uploadTask(@PathVariable("cutTaskId") String cutTaskId) {
      return this.cutTaskProjectService.uploadTask(cutTaskId);
   }

   @ApiOperation("区域id查零件清单")
   @GetMapping("/getPartByAreaId/{areaId}")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO getPartByAreaId(
      Integer pageNumber, Integer pageSize, @PathVariable("areaId") String areaId, @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      return this.cutTaskProjectService.getPartByAreaId(pageNumber, pageSize, areaId, sort);
   }

   @ApiOperation("删除板材")
   @DeleteMapping("/deletePlate/{plateId}")
   public ResultVO deletePlate(@PathVariable("plateId") String plateId) {
      return null;
   }
}
