package com.hzchum.scim.rest.controller.wms.wmsApp;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundQualityTestingDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-App入库质检")
@RestController
@RequestMapping("/api/v2/app/wms/inbound")
public class InboundControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(InboundControllerV2.class);
   @Resource
   InboundService inboundService;

   @ApiOperation("质检审核")
   @PutMapping("/quality-testing")
   @PreAuthorize("@permission.check('materialStorageInspectionV2')")
   public ResultVO qualityTesting(@RequestBody InboundQualityTestingDTOParam param) {
      log.info("API 调用 : 质检审核");
      return ResultBuilder.success(this.inboundService.qualityTestingV2(param));
   }
}
