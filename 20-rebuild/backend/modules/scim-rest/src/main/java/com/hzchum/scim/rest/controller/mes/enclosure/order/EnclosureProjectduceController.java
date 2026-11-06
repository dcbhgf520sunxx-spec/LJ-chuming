package com.hzchum.scim.rest.controller.mes.enclosure.order;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.TechEnclosureDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectProduceStateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目任务跟踪-围护")
@RestController
@RequestMapping("/api/mes/enclosure/produce")
public class EnclosureProjectduceController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureProjectduceController.class);
   @Resource
   private MesEnclosureTaskBiz taskBiz;

   @ApiOperation("获取所有项目生产状态(围护)")
   @GetMapping("/project")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份"),
            @ApiImplicitParam(name = "state", value = "排产状态 1: 生产中 2:已完成"),
            @ApiImplicitParam(name = "name", value = "模糊查询字段")
      }
   )
   @PreAuthorize("@permission.check('enclosure_task_tracking:get')")
   public ResultVO<List<EnclosureProjectProduceStateDTO>> getProjectWithOrder(
      Integer year,
      Integer state,
      String name,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：获取所有项目生产状态(围护)");
      return ResultBuilder.success(this.taskBiz.getProjectProduce(year, state, name, projectType, lumpSumSystemType));
   }

   @ApiOperation("任务跟踪查询项目下的工单生产情况(围护)")
   @GetMapping("/order/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderNumber", value = "工单号"),
            @ApiImplicitParam(name = "projectId", value = "项目id"),
            @ApiImplicitParam(name = "userName", value = "排产人")
      }
   )
   public ResultVO<PageVO<MesEnclosureTaskOrderDTO>> getOrders(
      String orderNumber,
      @RequestParam Long projectId,
      String userName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：任务跟踪查询项目下的工单生产情况(围护)");
      return ResultBuilder.success(this.taskBiz.getOrders(orderNumber, projectId, userName, pageNumber, pageSize));
   }

   @ApiOperation("任务跟踪查询工单详情(围护)")
   @GetMapping("/order/detail")
   @PreAuthorize("@permission.check('enclosure_task_tracking:detail')")
   public ResultVO<PageVO<TechEnclosureDetailDTO>> orderDetail(Long id) {
      log.info("API 调用 ：任务跟踪查询工单详情(围护)");
      return ResultBuilder.success(this.taskBiz.orderDetailV2(id));
   }

   @ApiOperation("打印查询工单详情(围护)")
   @GetMapping("/order/detail/print")
   @ApiImplicitParam(name = "id", value = "工单id", paramType = "query")
   @PreAuthorize("@permission.check('enclosure_task_tracking:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> orderDetailPrint(Long id) {
      log.info("API 调用 ：打印工单详情(围护)");
      return ResultBuilder.success(this.taskBiz.orderDetailPrint(id));
   }

   @ApiOperation("(新)打印查询工单详情(围护)")
   @GetMapping("/v2/order/detail/print")
   @ApiImplicitParam(name = "id", value = "工单id", paramType = "query")
   @PreAuthorize("@permission.check('enclosure_task_tracking:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> orderDetailPrintV2(Long id) {
      log.info("API 调用 ：(新)打印工单详情(围护)");
      return ResultBuilder.success(this.taskBiz.orderDetailPrintV2(id));
   }
}
