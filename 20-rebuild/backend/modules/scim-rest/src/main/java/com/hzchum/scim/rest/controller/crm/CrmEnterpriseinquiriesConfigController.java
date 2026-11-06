package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseinquiriesConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmEnterpriseinquiriesConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmEnterpriseinquiriesConfigUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "crm-配置管理-工商企业查询密钥")
@RestController
@RequestMapping("/api/crm/enterpriseinquiries/config")
public class CrmEnterpriseinquiriesConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmEnterpriseinquiriesConfigController.class);
   @Resource
   private CrmEnterpriseinquiriesConfigBiz crmEnterpriseinquiriesConfigBiz;

   @ApiOperation("工商企业查询密钥查询")
   @GetMapping("")
   @PreAuthorize("@permission.check('crm_secret_config:get')")
   public ResultVO getEnterpriseinquiriesConfig() {
      log.info("API调用:工商企业查询密钥查询");
      return ResultBuilder.success(this.crmEnterpriseinquiriesConfigBiz.getEnterpriseinquiriesConfig());
   }

   @ApiOperation("工商企业密钥修改")
   @PostMapping("")
   @PreAuthorize("@permission.check('crm_secret_config:save')")
   public ResultVO updateEnterpriseinquiriesConfig(@RequestBody CrmEnterpriseinquiriesConfigUpdateVO vo) {
      log.info("API调用:工商企业密钥修改");
      return ResultBuilder.success(
         this.crmEnterpriseinquiriesConfigBiz.updateEnterpriseinquiriesConfig(BeanUtil.copy(vo, CrmEnterpriseinquiriesConfigUpdateParam.class))
      );
   }
}
