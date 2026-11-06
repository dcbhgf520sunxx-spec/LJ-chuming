package com.hzchum.scim.rest.controller.mes.building.process;

import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingWageQuotaBiz;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES工序定价")
@RestController
@RequestMapping("/api/mes/building/wageQuota")
public class MesBuildingWageQuotaController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWageQuotaController.class);
   @Autowired
   private MesBuildingWageQuotaBiz wageQuotaBiz;
}
