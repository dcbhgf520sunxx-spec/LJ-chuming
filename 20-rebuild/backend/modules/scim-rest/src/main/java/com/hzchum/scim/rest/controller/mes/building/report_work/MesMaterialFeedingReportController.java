package com.hzchum.scim.rest.controller.mes.building.report_work;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.mes.building.core.api.biz.report_work.MesMaterialFeedingReportBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "投料填报")
@RestController
@RequestMapping("/api/mes/building/report-work/material-feeding-report")
public class MesMaterialFeedingReportController {
   private static final Logger log = LoggerFactory.getLogger(MesMaterialFeedingReportController.class);
   @Autowired
   private MesMaterialFeedingReportBiz biz;

   @ApiOperation("有清单数据的项目列表")
   @GetMapping("have-list-data-project-list")
   @PreAuthorize("@permission.check('mes_feedstock_reporting:get','mes_feedstock_reporting:add')")
   public ResultVO haveListDataProjectList() {
      log.info("API调用: 投料填报-有清单数据的项目列表");
      return ResultBuilder.success(new ListVO<>(this.biz.haveListDataProjectList()));
   }

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('mes_feedstock_reporting:get')")
   public ResultVO pageInfo(
      MesMaterialFeedingReportQuery query, @RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 投料填报-分页查询");
      return ResultBuilder.success(this.biz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("详情")
   @GetMapping("detail")
   @PreAuthorize("@permission.check('mes_feedstock_reporting:details')")
   public ResultVO detail(@RequestParam Long id) {
      log.info("API调用: 投料填报-详情查询");
      return ResultBuilder.success(this.biz.detail(id));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('mes_feedstock_reporting:add')")
   public ResultVO add(@RequestBody @Validated(Add.class) MesMaterialFeedingReportParam param) {
      log.info("API调用: 投料填报-新增");
      return ResultBuilder.success(this.biz.add(param));
   }

   @ApiOperation("构件类别列表")
   @GetMapping("artifact-class_list")
   @PreAuthorize("@permission.check('mes_feedstock_reporting:get','mes_feedstock_reporting:add')")
   public ResultVO artifactClassList(
      @ApiParam("项目id") @RequestParam Long projectId,
      @ApiParam("单体id") @RequestParam(required = false) Long monomerId,
      @ApiParam("批次id") @RequestParam(required = false) Long area_batch_id,
      @ApiParam("构件类别") @RequestParam(required = false) String structureType
   ) {
      log.info("API调用: 投料填报-构件类别列表");
      return ResultBuilder.success(new ListVO<>(this.biz.artifactClassList(projectId, monomerId, area_batch_id, structureType)));
   }
}
