package com.hzchum.scim.rest.controller.plan.approve;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.approve.TechnologicalAchievementBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanApproveOpinionDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "计划管理-技术成果审批")
@RestController
@RequestMapping("/api/plan/technological_achievement_approve")
public class TechnologicalAchievementApi {
   private static final Logger log = LoggerFactory.getLogger(TechnologicalAchievementApi.class);
   @Resource
   private TechnologicalAchievementBiz technologicalAchievementBiz;

   @ApiOperation(value = "创建审批流", notes = "创建审批流")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML文件", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "  产品类型 (建钢项目) 1零件 2构件 16组立 (桥梁项目)1分段件 2单元件 4零件 (深化图纸必传)", paramType = "query")
      }
   )
   @PostMapping("/createApprove")
   public ResultVO uploadFileAndUnzip(
      @RequestPart MultipartFile file, @RequestParam Long projectId, Long monomerId, @RequestParam Integer dataType, Integer productType, String fileName
   ) throws Exception {
      log.info("API 调用 ：创建审批流");
      return ResultBuilder.success(
         this.technologicalAchievementBiz
            .createDrawingApprove(file, projectId, monomerId, null, null, dataType, productType, null, fileName, null, false, null)
      );
   }

   @ApiOperation("技术成果-处理审批")
   @PutMapping("/commonApprove")
   public ResultVO commonApprove(@RequestBody PlanApproveOpinionDTOParam planApproveOpinionDTOParam) throws Exception {
      log.info("API 调用 ：技术成果-处理审批");
      return ResultBuilder.success(this.technologicalAchievementBiz.commonApprove(planApproveOpinionDTOParam));
   }

   @ApiImplicitParams(@ApiImplicitParam(name = "approvalRecordId", value = "审批流主日志Id", paramType = "query", required = true))
   @ApiOperation("技术成果-查询审批详情")
   @GetMapping("/getApproveDetail/{approvalRecordId}")
   @PreAuthorize("@technicalApprovalAccess.read(#approvalRecordId)")
   public ResultVO<Object> getApproveDetail(@PathVariable long approvalRecordId) {
      log.info("API 调用 ：技术成果-查询审批详情");
      return ResultBuilder.success(this.technologicalAchievementBiz.getApproveDetail(approvalRecordId));
   }

   @ApiImplicitParams(@ApiImplicitParam(name = "approvalRecordId", value = "审批流主日志Id", paramType = "query", required = true))
   @ApiOperation("技术成果-撤销审批")
   @PutMapping("/cancelApproveDetail")
   public ResultVO cancelApproveDetail(@RequestParam long approvalRecordId) {
      log.info("API 调用 ：技术成果-撤销审批");
      return ResultBuilder.success(this.technologicalAchievementBiz.cancelApproveDetail(approvalRecordId));
   }

   @ApiOperation("下载附件")
   @GetMapping("/download/{id}")
   @PreAuthorize("@technicalApprovalAccess.read(#approvalRecordId)")
   public void downloadAttachment(@PathVariable Long id, @RequestParam Long approvalRecordId) {
      log.info("API 调用 ：根据附件id下载文件");
      this.technologicalAchievementBiz.downloadFile(id, approvalRecordId);
   }
}
