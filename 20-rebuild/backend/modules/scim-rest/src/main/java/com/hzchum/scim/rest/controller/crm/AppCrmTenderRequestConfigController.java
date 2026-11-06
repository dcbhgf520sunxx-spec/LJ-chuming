package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-配置管理-投标申请配置")
@RestController
@RequestMapping("/api/app/crm/tender/request/config")
public class AppCrmTenderRequestConfigController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmTenderRequestConfigController.class);
   @Resource
   private CrmTenderRequestConfigBiz crmTenderRequestConfigBiz;

   @ApiOperation("app-投标申请配置查询(跨越权限)")
   @GetMapping("/skip/permissions")
   public ResultVO getListSkipPermissions(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum) {
      log.info("API调用:app-投标申请配置查询(跨越权限)");
      return ResultBuilder.success(this.crmTenderRequestConfigBiz.getListSkipPermissions(crmTenderRequestConfigEnum, crmSpecialBubmissionStatusEnum));
   }
}
