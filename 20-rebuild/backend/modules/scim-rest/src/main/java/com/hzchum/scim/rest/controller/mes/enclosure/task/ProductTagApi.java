package com.hzchum.scim.rest.controller.mes.enclosure.task;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.PrintDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.get.PlanDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "围护-产品标签")
@RestController
@RequestMapping("/api/mes/enclosure")
public class ProductTagApi {
   private static final Logger log = LoggerFactory.getLogger(ProductTagApi.class);
   @Resource
   private EnclosurePlanService planService;
   @Resource
   private MesEnclosureTaskBiz taskBiz;

   @ApiOperation(value = "围护-获取项目下计划的信息", notes = "围护-获取项目下计划的信息", nickname = "63")
   @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true)
   @GetMapping("/listByProjectId")
   public ResultVO<List<PlanDTO>> listSimpleByProjectId(Long projectId, Integer category) {
      log.info("API 调用 : 根据 项目id 查询 单体简单信息 列表");
      return ResultBuilder.success(this.planService.listPlansByProjectId(projectId, category));
   }

   @ApiOperation("围护-获取含有任务的生产线")
   @GetMapping("/productionLine/hasTask")
   public ResultVO<Map<Long, String>> getHasTask(Long projectId, Long planId, Integer category) {
      log.info("API 调用 ：围护-获取含有任务的生产线");
      return ResultBuilder.success(this.taskBiz.listHasTaskProductionLineId(projectId, planId, category));
   }

   @ApiOperation("产品标签-围护列表")
   @GetMapping
   @PreAuthorize("@permission.check('enclosure_label:get')")
   public ResultVO listEnclosurePrint(
      Long projectId,
      Long planId,
      Integer category,
      Long lineId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer warehousingStatusEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      log.info("API 调用 ：产品标签-围护列表");
      return ResultBuilder.success(
         this.taskBiz
            .listEnclosurePrint(projectId, planId, category, lineId, name, serialNumber, specification, material, warehousingStatusEnum, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增围护打印记录")
   @PostMapping("/print")
   @PreAuthorize("@permission.check('enclosure_label:print', 'enclosure_label:batchPrint')")
   public ResultVO savePrint(@RequestBody PrintDTO printDTO) {
      log.info("API 调用 ：新增围护打印记录");
      return ResultBuilder.success(this.taskBiz.savePrint(printDTO.getTaskId(), printDTO.getQuantity()));
   }

   @ApiOperation("查询围护打印记录")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('enclosure_label:record')")
   public ResultVO<List<EnclosurePrint>> getPrint(Long taskId) {
      log.info("API 调用 ：查询围护打印记录");
      return ResultBuilder.success(this.taskBiz.getPrint(taskId));
   }
}
