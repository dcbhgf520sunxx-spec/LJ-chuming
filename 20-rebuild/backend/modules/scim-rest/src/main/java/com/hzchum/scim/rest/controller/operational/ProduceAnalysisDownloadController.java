package com.hzchum.scim.rest.controller.operational;

import com.hzchum.scim.operational.analysis.core.api.biz.ProduceAchievementBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "生产分析下载")
@RestController
@RequestMapping("/api/pc/operational/produce/download")
public class ProduceAnalysisDownloadController {
   private static final Logger log = LoggerFactory.getLogger(ProduceAnalysisDownloadController.class);
   @Resource
   private ProduceAchievementBiz produceAchievementBiz;

   @ApiOperation("MES-主材损耗详情下载")
   @GetMapping("/mainOutMeteDetails/download")
   @PreAuthorize("@permission.check('loss_dashboard:download')")
   public void getMaterialLossDetailsDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：主材损耗详情下载");
      this.produceAchievementBiz.getMaterialLossDetailsDownloadV2(yearDate, branchCompanyId, workshopId);
   }
}
