package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "新版wms配置-科目配置")
@RestController
@RequestMapping("/api/v2/config/classification")
public class ClassificationControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ClassificationControllerV2.class);
   @Resource
   ClassificationService classificationService;

   @ApiOperation("导出科目配置清单")
   @GetMapping("/exportClassificationList")
   public void exportClassificationList(HttpServletResponse response) {
      log.info("API 调用 ：导出科目配置清单");
      this.classificationService.exportClassificationListV2(response);
   }
}
