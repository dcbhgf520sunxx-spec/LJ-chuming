package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-配置管理-基础配置")
@RestController
@RequestMapping("/api/app/crm/basics/config")
public class AppCrmBasicsConfigController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmBasicsConfigController.class);
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;

   @ApiOperation("app-基础配置查询(跨越权限)")
   @GetMapping("/skip/permissions")
   public ResultVO getListSkipPermissions(Integer crmBasicsConfigEnum) {
      log.info("API调用:app-基础配置查询");
      return ResultBuilder.success(this.crmBasicsConfigBiz.getListSkipPermissions(crmBasicsConfigEnum));
   }
}
