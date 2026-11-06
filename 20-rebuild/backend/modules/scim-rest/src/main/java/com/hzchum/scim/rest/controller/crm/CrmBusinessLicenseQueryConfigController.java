package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseQueryConfigBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "crm-配置管理-企业查询次数")
@RestController
@RequestMapping("/api/crm/business/license/query/config")
public class CrmBusinessLicenseQueryConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmBusinessLicenseQueryConfigController.class);
   @Resource
   private CrmBusinessLicenseQueryConfigBiz crmBusinessLicenseQueryConfigBiz;

   @ApiOperation("企业查询次数修改")
   @PostMapping("")
   @PreAuthorize("@permission.check('crm_expiration_date_config:editBusinessLimitConfig')")
   public ResultVO updateBusinessLicenseQueryConfig(Integer times) {
      log.info("API调用:企业查询次数修改");
      return ResultBuilder.success(this.crmBusinessLicenseQueryConfigBiz.updateBusinessLicenseQueryConfig(times));
   }

   @ApiOperation("配置查询")
   @GetMapping("")
   public ResultVO getBusinessLicenseQueryConfig() {
      log.info("API调用:配置查询");
      return ResultBuilder.success(this.crmBusinessLicenseQueryConfigBiz.getBusinessLicenseQueryConfig());
   }
}
