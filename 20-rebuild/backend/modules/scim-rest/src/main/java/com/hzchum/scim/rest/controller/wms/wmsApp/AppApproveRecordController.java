package com.hzchum.scim.rest.controller.wms.wmsApp;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.system.core.api.common.enums.InstallReportClientTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-审批日志")
@Validated
@RequestMapping("/api/v2/app/wms/config/record")
@RestController
public class AppApproveRecordController {
   private static final Logger log = LoggerFactory.getLogger(AppApproveRecordController.class);
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;

   @ApiOperation("获取approveRecord分页列表")
   @GetMapping("/list")
   public ResultVO list(
      WmsApproveRecordDTOParam wmsApproveRecordDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(name = "sort", required = false) List<String> sort
   ) {
      log.info("API 调用 ：获取approveRecord分页列表");
      return ResultBuilder.success(
         this.wmsApproveRecordService.getList(wmsApproveRecordDTOParam, pageNumber, pageSize, sort, InstallReportClientTypeEnum.APP.getType())
      );
   }
}
