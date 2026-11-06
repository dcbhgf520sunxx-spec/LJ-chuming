package com.hzchum.scim.rest.controller.mes.enclosure.order;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskOrderBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.TechEnclosureDetailDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目工单-围护")
@RestController
@RequestMapping("/api/mes/enclosure/order")
public class EnclosureOrderController {
   private static final Logger log = LoggerFactory.getLogger(EnclosureOrderController.class);
   @Resource
   private MesEnclosureTaskOrderBiz taskOrderBiz;

   @ApiOperation("工单页面获取项目(围护)")
   @GetMapping("/project/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份"),
            @ApiImplicitParam(name = "name", value = "模糊查询字段"),
            @ApiImplicitParam(name = "projectType", value = "项目产品类型"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型")
      }
   )
   @PreAuthorize("@permission.check('enclosure_scheduling_work_order:get')")
   public ResultVO<List<ProjectInfo>> getProjectWithOrder(
      Integer year,
      String name,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType
   ) {
      log.info("API 调用 ：工单页面获取项目(围护)");
      return ResultBuilder.success(this.taskOrderBiz.getProjectWithOrder(year, name, projectType, lumpSumSystemType));
   }

   @ApiOperation("查询项目下的工单(围护)")
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
      log.info("API 调用 ：查询项目下的工单(围护)");
      return ResultBuilder.success(this.taskOrderBiz.getOrders(orderNumber, projectId, userName, pageNumber, pageSize));
   }

   @ApiOperation("查询工单详情(围护)")
   @GetMapping("/order/detail")
   @PreAuthorize("@permission.check('enclosure_scheduling_work_order:detail')")
   public ResultVO<PageVO<TechEnclosureDetailDTO>> orderDetail(Long id) {
      log.info("API 调用 ：查询工单详情(围护)");
      return ResultBuilder.success(this.taskOrderBiz.orderDetail(id));
   }

   @ApiOperation("打印查询工单详情(围护-前端模板)")
   @GetMapping("/order/detail/print")
   @PreAuthorize("@permission.check('enclosure_scheduling_work_order:print')")
   @ApiImplicitParam(name = "id", value = "工单id", paramType = "query")
   public ResultVO<PrintVO<List<Map<String, Object>>>> orderDetailPrint(Long id) {
      log.info("API 调用 ：打印查询工单详情(围护-前端模板)");
      return ResultBuilder.success(this.taskOrderBiz.orderDetailPrint(id));
   }

   @ApiOperation("打印查询工单详情 (带图)")
   @GetMapping("/detail/download")
   public ResultVO orderDetailDownload(Long id, HttpServletResponse response) {
      log.info("API 调用 ：打印查询工单详情 (带图)");
      return ResultBuilder.success(this.taskOrderBiz.orderDetailDownload(id, response));
   }

   @ApiOperation("新增工单详情打印记录(围护)")
   @PutMapping("/order/detail/save/print")
   @ApiImplicitParam(name = "id", value = "工单id", paramType = "query")
   public ResultVO savePrint(Long id) {
      log.info("API 调用 ：新增工单详情打印记录(围护)");
      return ResultBuilder.success(this.taskOrderBiz.savePrint(id));
   }

   @ApiOperation("删除工单(围护)")
   @DeleteMapping("/order")
   @PreAuthorize("@permission.check('enclosure_scheduling_work_order:del')")
   public ResultVO deleteOrder(@RequestBody Long[] ids) {
      log.info("API 调用 ：删除工单(围护)");
      return ResultBuilder.success(this.taskOrderBiz.deleteOrder(Arrays.asList(ids)));
   }
}
