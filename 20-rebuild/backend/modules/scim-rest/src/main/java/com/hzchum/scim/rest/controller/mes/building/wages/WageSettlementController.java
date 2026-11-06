package com.hzchum.scim.rest.controller.mes.building.wages;

import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingProduceTeamReportPriceBiz;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES班组工价")
@RestController
@RequestMapping("/api/mes/building/wages")
public class WageSettlementController {
   private static final Logger log = LoggerFactory.getLogger(WageSettlementController.class);
   @Autowired
   private MesBuildingProduceTeamReportPriceBiz mesBuildingProduceTeamReportPriceBiz;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
}
