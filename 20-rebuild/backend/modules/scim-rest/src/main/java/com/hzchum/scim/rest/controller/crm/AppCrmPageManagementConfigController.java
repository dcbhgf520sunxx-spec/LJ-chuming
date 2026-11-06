package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmPageManagementConfigBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-配置管理-页面配置")
@RestController
@RequestMapping("/api/app/crm/page/management/config")
public class AppCrmPageManagementConfigController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmPageManagementConfigController.class);
   @Resource
   private CrmPageManagementConfigBiz crmPageManagementConfigBiz;

   @ApiOperation("页面详情查询")
   @GetMapping("")
   public ResultVO getPageDetailByPageEnum(@RequestParam Integer crmPageManagementConfigEnum, Integer crmCountryTypeEnum) {
      log.info("API调用:页面详情查询");
      return ResultBuilder.success(this.crmPageManagementConfigBiz.getPageDetailByPageEnum(crmPageManagementConfigEnum, crmCountryTypeEnum));
   }
}
