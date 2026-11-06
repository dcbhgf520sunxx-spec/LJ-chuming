package com.hzchum.scim.rest.controller.mes.building.report_work;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.report_work.MesWageAdjustBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustListSelectQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价调整")
@RestController
@RequestMapping("/api/mes/building/report-work/wage-adjust")
public class MesWageAdjustController {
   private static final Logger log = LoggerFactory.getLogger(MesWageAdjustController.class);
   @Autowired
   private MesWageAdjustBiz wageAdjustBiz;

   @ApiOperation("清单选择")
   @GetMapping("list-select")
   public ResultVO listSelect(
      MesWageAdjustListSelectQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API 调用 ：工价调整-清单选择");
      return ResultBuilder.success(this.wageAdjustBiz.listSelect(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("获取构件工价")
   @PostMapping("get-artifact-wage")
   public ResultVO getArtifactWage(@RequestParam Long workshopId, @RequestParam Long processId, @RequestBody List<Long> artifactIds) {
      log.info("API 调用 ：工价调整-获取构件工价");
      return ResultBuilder.success(new ListVO<>(this.wageAdjustBiz.getArtifactWageV2(workshopId, processId, artifactIds)));
   }

   @ApiOperation("获取部件工价")
   @PostMapping("get-assemble-wage")
   public ResultVO getAssembleWage(@RequestParam Long workshopId, @RequestParam Long processId, @RequestBody List<Long> assembleIds) {
      log.info("API 调用 ：工价调整-获取部件工价");
      return ResultBuilder.success(new ListVO<>(this.wageAdjustBiz.getAssembleWageV2(workshopId, processId, assembleIds)));
   }

   @ApiOperation("获取零件工价")
   @PostMapping("get-machine-part-wage")
   public ResultVO getMachinePartWage(@RequestParam Long workshopId, @RequestParam Long processId, @RequestBody List<Long> machinePartIds) {
      log.info("API 调用 ：工价调整-获取零件工价");
      return ResultBuilder.success(new ListVO<>(this.wageAdjustBiz.getMachinePartWageV2(workshopId, processId, machinePartIds)));
   }

   @ApiOperation("发起审批")
   @PostMapping("initiate-approval")
   public ResultVO initiateApproval(@RequestBody @Validated MesWageAdjustParam param) {
      log.info("API 调用 ：工价调整-发起审批");
      return ResultBuilder.success(this.wageAdjustBiz.initiateApproval(param));
   }

   @ApiOperation("审批")
   @PostMapping("approval")
   public ResultVO approval(@RequestBody MesWageAdjustApprovalParam param) {
      log.info("API 调用 ：工价调整-审批");
      return ResultBuilder.success(this.wageAdjustBiz.approval(param));
   }

   @ApiOperation("撤销")
   @PostMapping("cancel-approval")
   public ResultVO cancelApproval(@RequestParam Long id) {
      log.info("API 调用 ：工价调整-撤销");
      return ResultBuilder.success(this.wageAdjustBiz.revocation(id));
   }

   @ApiOperation("分页查询")
   @GetMapping("page")
   public ResultVO pageInfo(
      MesWageAdjustQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API 调用 ：工价调整-分页查询");
      return ResultBuilder.success(this.wageAdjustBiz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{id}")
   public ResultVO detail(@PathVariable Long id) {
      log.info("API 调用 ：工价调整-详情");
      return ResultBuilder.success(this.wageAdjustBiz.detailById(id));
   }
}
