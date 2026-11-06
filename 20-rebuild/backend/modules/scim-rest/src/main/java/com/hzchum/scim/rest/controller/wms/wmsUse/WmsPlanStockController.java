package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-备料清单")
@RestController
@RequestMapping("/api/wms/material-preparation/match")
public class WmsPlanStockController {
   private static final Logger log = LoggerFactory.getLogger(WmsPlanStockController.class);
   @Resource
   private MaterialInventoryService materialInventoryService;
}
