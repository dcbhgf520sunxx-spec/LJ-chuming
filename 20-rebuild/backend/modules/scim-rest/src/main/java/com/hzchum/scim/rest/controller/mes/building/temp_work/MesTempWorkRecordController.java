package com.hzchum.scim.rest.controller.mes.building.temp_work;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.temp_work.MesTempWorkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkRecordQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "点工记录")
@RestController
@RequestMapping("/api/mes/temp-work-record")
public class MesTempWorkRecordController {
   private static final Logger log = LoggerFactory.getLogger(MesTempWorkRecordController.class);
   @Autowired
   private MesTempWorkBiz tempWorkBiz;

   @ApiOperation("分页")
   @GetMapping("page")
   @PreAuthorize("@permission.check('mes_hourly_work_record:get')")
   public ResultVO page(
      MesTempWorkRecordQuery query,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) List<String> sortList
   ) {
      log.info("API 调用 ：点工记录-分页");
      return ResultBuilder.success(this.tempWorkBiz.recordPage(query, pageNumber, pageSize, sortList));
   }

   @ApiOperation("汇总")
   @GetMapping("summary")
   @PreAuthorize("@permission.check('mes_hourly_work_record:get')")
   public ResultVO summary(MesTempWorkRecordQuery query) {
      log.info("API 调用 ：点工记录-汇总");
      return ResultBuilder.success(this.tempWorkBiz.recordSummary(query));
   }

   @ApiOperation("累计汇总")
   @GetMapping("cumulative-summary")
   @PreAuthorize("@permission.check('mes_hourly_work_record:get')")
   public ResultVO cumulativeSummary() {
      log.info("API 调用 ：点工记录-累计汇总");
      return ResultBuilder.success(this.tempWorkBiz.recordCumulativeSummary());
   }

   @ApiOperation("下载")
   @GetMapping("download")
   @PreAuthorize("@permission.check('mes_hourly_work_record:download')")
   public void download(MesTempWorkRecordQuery query, HttpServletResponse response) {
      log.info("API 调用 ：点工记录-下载");
      this.tempWorkBiz.recordDownload(query, response);
   }
}
