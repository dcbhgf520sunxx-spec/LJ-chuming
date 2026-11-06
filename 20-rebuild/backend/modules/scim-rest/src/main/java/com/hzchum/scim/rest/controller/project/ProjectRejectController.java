package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReceivedQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectDetailQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectRejectProductDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReceivingRecordService;
import com.hzchum.scim.project.core.api.service.ProjectRejectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-外购退货管理")
@RestController
@RequestMapping("/api/project/reject")
public class ProjectRejectController {
   private static final Logger log = LoggerFactory.getLogger(ProjectRejectController.class);
   @Resource
   private ProjectReceivingRecordService receivingRecordService;
   @Resource
   private ProjectRejectService projectRejectService;

   @ApiOperation("外购可退货记录")
   @GetMapping("/outCanReject/page")
   public ResultVO getOutReceivedPage(
      @Validated ProjectReceivedQueryDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 外购可退货记录");
      return ResultBuilder.success(this.receivingRecordService.getOutReceivedPage(param, pageNumber, pageSize));
   }

   @ApiOperation("提交外购退库单")
   @PostMapping("/save")
   public ResultVO saveProjectReject(Long projectId, @RequestBody @Valid List<ProjectRejectProductDTOParam> paramList) {
      log.info("Api调用: 提交外购退库单");
      return ResultBuilder.success(this.projectRejectService.saveProjectReject(projectId, paramList));
   }

   @ApiOperation("外购退货单列表")
   @GetMapping("/page")
   public ResultVO getProjectRejectPage(
      ProjectRejectQueryDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 外购退货单列表");
      return ResultBuilder.success(this.projectRejectService.getProjectRejectPage(param, pageNumber, pageSize));
   }

   @ApiOperation("审核外购退货单")
   @PutMapping("/check")
   public ResultVO update(@RequestBody @Validated WmsApproveOpinionDTOParam param) {
      log.info("API 调用 ：审核外购退货单");
      return ResultBuilder.success(this.projectRejectService.check(param));
   }

   @ApiOperation("外购退货单详情")
   @GetMapping("/detail")
   public ResultVO getDetail(@RequestParam Long rejectId, @RequestParam(required = false) Integer productType) {
      log.info("Api调用: 外购退货单详情");
      return ResultBuilder.success(this.projectRejectService.getDetail(rejectId, productType));
   }

   @ApiOperation("外购退货记录")
   @GetMapping("/detail/page")
   public ResultVO getProjectRejectDetailPage(
      ProjectRejectDetailQueryDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 外购退货单列表");
      return ResultBuilder.success(this.projectRejectService.getProjectRejectDetailPage(param, pageNumber, pageSize));
   }

   @ApiOperation("外购退货记录(打印)")
   @GetMapping("/detail/print")
   public ResultVO getProjectRejectDetailPrint(ProjectRejectDetailQueryDTOParam param) {
      log.info("Api调用:外购退货记录(打印)");
      return ResultBuilder.success(this.projectRejectService.getProjectRejectDetailPrint(param));
   }
}
