package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseInformationBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-办事大厅-工商信息库存信息")
@RestController
@RequestMapping("/api/app/crm/business/license/information")
public class AppCrmBusinessLicenseInformationController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmBusinessLicenseInformationController.class);
   @Resource
   private CrmBusinessLicenseInformationBiz crmBusinessLicenseInformationBiz;

   @ApiOperation("app-crm—调用三方查询工商信息")
   @GetMapping("")
   @SignerCheck(boolMethodAndClassName = true, message = "当前工商信息正在查询请稍后!!!!!")
   public ResultVO queryBusinessLicenseInformation(@RequestParam String companyNameOrCreditCode) {
      log.info("API调用:app-crm—调用三方查询工商信息");
      return ResultBuilder.success(this.crmBusinessLicenseInformationBiz.queryBusinessLicenseInformation(companyNameOrCreditCode));
   }
}
