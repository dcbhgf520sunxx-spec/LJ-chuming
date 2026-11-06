package com.hzchum.scim.rest.controller.mes.building.task;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES排产")
@RestController
@RequestMapping("/api/mes/building/scheduling")
public class MesBuildingSchedulingController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingSchedulingController.class);
}
