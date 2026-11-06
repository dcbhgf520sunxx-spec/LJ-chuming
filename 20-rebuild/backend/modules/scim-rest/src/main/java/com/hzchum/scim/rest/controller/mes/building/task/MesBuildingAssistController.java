package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAssistBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTopTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesbuildingTaskProcessAssistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductFromArtifactDTO;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.AssistListRequest;
import com.hzchum.scim.rest.pojo.vo.mes.utils.IdsVoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES任务-工序协同")
@RestController
@RequestMapping("/api/mes/building/assist")
public class MesBuildingAssistController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAssistController.class);
   @Autowired
   private MesBuildingAssistBiz assistBiz;
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingTopTaskOrderBiz topTaskOrderBiz;
   @Autowired
   private MesBuildingTaskProcessBiz taskProcessBiz;

   @ApiOperation("获取可以班组协同的顶级任务工单")
   @GetMapping("/top_task_order/page")
   @PreAuthorize("@permission.check('mes_process_assistance:get')")
   public ResultVO getTopTaskOrderAssistPage(
      LocalDateTime dateTime,
      Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取可以班组协同的顶级任务工单");
      return ResultBuilder.success(this.topTaskOrderBiz.getTopTaskOrderAssistPage(dateTime, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("获取可以班组协同的任务工单")
   @GetMapping("/{topTaskOrderId}/task_order/list")
   @PreAuthorize("@permission.check('mes_process_assistance:get')")
   public ResultVO getTaskOrderAssistList(@PathVariable("topTaskOrderId") Long topTaskOrderId) {
      log.info("API 调用 ：获取可以班组协同的任务工单");
      return ResultBuilder.success(new ListVO<>(this.taskOrderBiz.getTaskOrderAssistList(topTaskOrderId)));
   }

   @ApiOperation("获取可以班组协同的产品")
   @GetMapping("/task_order/product/list")
   @PreAuthorize("@permission.check('mes_process_assistance:get')")
   public ResultVO<ListVO<MesBuildingAssistProductDTO>> getProductAssistList(
      @RequestParam Long taskOrderId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long processId,
      @RequestParam Integer taskTypeEnum,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) Integer assistEnum
   ) {
      log.info("API 调用 ：获取可以班组协同的产品");
      return ResultBuilder.success(
         new ListVO<>(this.taskProcessBiz.getProductAssistList(taskOrderId, areaId, processId, taskTypeEnum, serialNumber, specification, null, assistEnum))
      );
   }

   @ApiOperation("获取可以班组协同的部件产品(按构件展开)")
   @GetMapping("/task_order/assemble/list")
   @PreAuthorize("@permission.check('mes_process_assistance:get')")
   public ResultVO<ListVO<MesBuildingAssistProductFromArtifactDTO>> getAssembleAssistListByComponent(
      @RequestParam Long taskOrderId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long processId,
      @RequestParam Integer taskTypeEnum,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) Integer assistEnum,
      @RequestParam(required = false) String artifactSerialNumber,
      @RequestParam(required = false) String artifactSpecification
   ) {
      log.info("API 调用 ：获取可以班组协同的部件产品(按构件展开)");
      return ResultBuilder.success(
         new ListVO<>(
            this.taskProcessBiz
               .getAssembleAssistListByComponent(
                  taskOrderId, areaId, processId, taskTypeEnum, serialNumber, specification, null, assistEnum, artifactSerialNumber, artifactSpecification
               )
         )
      );
   }

   @ApiOperation("添加班组协同")
   @PostMapping("")
   @PreAuthorize("@permission.check('mes_process_assistance:save')")
   @SignerCheck(boolMethodAndClassName = true, message = "正在办理工序协同中,请稍后刷新重试")
   public ResultVO assistSave(@RequestBody AssistListRequest request) {
      log.info("API 调用 ：添加班组协同");
      return ResultBuilder.success(
         this.assistBiz.assistSave(request.getAssistList(), request.getId(), request.getNextProcessIds(), request.getArtifactTaskId())
      );
   }

   @ApiOperation("批量办理班组协同")
   @PostMapping("/list")
   @PreAuthorize("@permission.check('mes_process_assistance:save')")
   @SignerCheck(boolMethodAndClassName = true, message = "正在批量办理工序协同中,请稍后刷新重试")
   public ResultVO assistSaveList(@RequestBody List<MesbuildingTaskProcessAssistDTO> taskProcessAssistDTOS) {
      log.info("API 调用 ：批量办理班组协同");
      return ResultBuilder.success(this.assistBiz.assistSaveList(taskProcessAssistDTOS));
   }

   @ApiOperation("删除班组协同")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('mes_process_assistance:del')")
   public ResultVO assistRomve(@RequestBody IdsVoRequest request) {
      log.info("API 调用 ：删除班组协同");
      return ResultBuilder.success(this.assistBiz.assistRomve(request.getIds()));
   }
}
