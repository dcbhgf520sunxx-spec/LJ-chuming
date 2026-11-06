package com.hzchum.scim.rest.controller.contract;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "合同管理-附件")
@RequestMapping("/api/attachment")
public class ContractAttachmentApi {
   private static final Logger log = LoggerFactory.getLogger(ContractAttachmentApi.class);
}
