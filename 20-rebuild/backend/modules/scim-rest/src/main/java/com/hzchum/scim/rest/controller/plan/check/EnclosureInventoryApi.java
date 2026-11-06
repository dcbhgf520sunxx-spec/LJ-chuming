package com.hzchum.scim.rest.controller.plan.check;

import com.hzchum.scim.plan.core.api.biz.TechEnclosureBiz;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-清单操作(审核)")
@RestController
@RequestMapping("/api/plan/enclosure/inventory")
@Valid
public class EnclosureInventoryApi {
   private static final Logger log = LoggerFactory.getLogger(EnclosureInventoryApi.class);
   @Resource
   private TechEnclosureBiz enclosureBiz;
}
