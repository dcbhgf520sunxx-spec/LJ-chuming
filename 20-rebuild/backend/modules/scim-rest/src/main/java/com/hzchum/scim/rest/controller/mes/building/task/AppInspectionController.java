package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.onecodeChange.MesBuildingOneCodeChangBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceInspectionTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionReportDOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactDelDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactUseDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES-任务")
@RestController
@RequestMapping("/api/app/mes/building/inspection")
public class AppInspectionController {
   private static final Logger log = LoggerFactory.getLogger(AppInspectionController.class);
   @Autowired
   private MesBuildingInspectionTeamService inspectionTeamService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportBiz inspectionTeamReportBiz;
   @Resource
   private MesBuildingOneCodeChangBiz mesBuildingOneCodeChangBiz;

   @ApiOperation("质检报表-用户汇总")
   @GetMapping("/user/summary")
   public ResultVO listUserSummary(@Valid InspectionReportDOParam param) {
      log.info("API 调用 ：质检报表-用户汇总");
      return ResultBuilder.success(this.inspectionTeamService.listUserSummary(param));
   }

   @ApiOperation("质检报表-用户质检记录")
   @GetMapping("/user")
   public ResultVO listUserDetail(@Valid InspectionDetailDOParam param) {
      log.info("API 调用 ：质检报表-用户质检记录");
      return ResultBuilder.success(this.inspectionTeamService.listUserDetail(param));
   }

   @ApiOperation("质检报表-用户质检记录")
   @PostMapping("/test")
   public ResultVO test(@RequestBody List<TechChangeArtifactDelDtoParam> changeList) {
      log.info("API 调用 ：质检报表-用户质检记录");
      return ResultBuilder.success(this.mesBuildingOneCodeChangBiz.deleteArtifacts(changeList, Boolean.TRUE));
   }

   @ApiOperation("质检报表-用户质检记录")
   @PostMapping("/test2")
   public ResultVO test2(@RequestBody List<TechChangeArtifactUseDtoParam> useArtifacts) {
      log.info("API 调用 ：质检报表-用户质检记录");
      return ResultBuilder.success(this.mesBuildingOneCodeChangBiz.useArtifact(useArtifacts));
   }

   @ApiOperation("质检上报记录详情")
   @GetMapping("/{id}/details")
   public ResultVO inspectionReportDetailList(@PathVariable("id") Long id) {
      log.info("API 调用 ：质检上报记录详情");
      return ResultBuilder.success(this.inspectionTeamReportBiz.inspectionReportDetailList(id));
   }
}
