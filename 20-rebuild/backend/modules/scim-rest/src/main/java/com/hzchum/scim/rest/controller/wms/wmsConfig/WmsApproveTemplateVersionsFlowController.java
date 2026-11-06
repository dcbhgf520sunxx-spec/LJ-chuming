package com.hzchum.scim.rest.controller.wms.wmsConfig;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-审批模板流程配置")
@RestController
@RequestMapping("/api/wms/approve/template_version_flow")
public class WmsApproveTemplateVersionsFlowController {
   private static final Logger log = LoggerFactory.getLogger(WmsApproveTemplateVersionsFlowController.class);
}
