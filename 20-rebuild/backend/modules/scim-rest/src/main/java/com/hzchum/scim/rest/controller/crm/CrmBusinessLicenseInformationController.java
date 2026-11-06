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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-办事大厅-工商信息库存信息")
@RestController
@RequestMapping("/api/crm/business/license/information")
public class CrmBusinessLicenseInformationController {
   private static final Logger log = LoggerFactory.getLogger(CrmBusinessLicenseInformationController.class);
   @Resource
   private CrmBusinessLicenseInformationBiz crmBusinessLicenseInformationBiz;

   @ApiOperation("crm—调用三方查询工商信息")
   @GetMapping("")
   @PreAuthorize("@permission.check('crm_business_information:add','crm_business_record:add')")
   @SignerCheck(boolMethodAndClassName = true, message = "当前工商信息正在查询请稍后!!!!!")
   public ResultVO queryBusinessLicenseInformation(@RequestParam String companyNameOrCreditCode) {
      log.info("API调用:crm—调用三方查询工商信息");
      return ResultBuilder.success(this.crmBusinessLicenseInformationBiz.queryBusinessLicenseInformation(companyNameOrCreditCode));
   }

   @ApiOperation("crm-工商信息分页列表")
   @GetMapping("/pageList")
   @PreAuthorize("@permission.check('crm_business_information:get','crm_business_record:add')")
   public ResultVO pageList(
      String companyName,
      String creditCode,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:crm-工商信息分页列表");
      return ResultBuilder.success(this.crmBusinessLicenseInformationBiz.pageList(companyName, creditCode, pageNumber, pageSize));
   }

   @ApiOperation("crm-工商信息更新")
   @PostMapping("/update/info")
   @PreAuthorize("@permission.check('crm_business_information:update')")
   @SignerCheck(lockKey = "#id", message = "当前工商信息正在更新!!!")
   public ResultVO updateInfo(@RequestParam Long id) throws Exception {
      log.info("API调用:crm-工商信息更新");
      return ResultBuilder.success(this.crmBusinessLicenseInformationBiz.updateInfo(id));
   }
}
