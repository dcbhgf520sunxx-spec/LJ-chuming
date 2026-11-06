package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmOaConfigBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmOaConfig;
import com.hzchum.scim.rest.pojo.vo.crm.CrmOaConfigUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "crm-配置管理-OA审批")
@RestController
@RequestMapping("/api/crm/oa/config")
public class CrmOaConfigController {
   @Resource
   private CrmOaConfigBiz crmOaConfigBiz;

   @ApiOperation("CRM OA审批配置查询")
   @GetMapping("")
   public ResultVO<CrmOaConfig> getOaConfig() {
      return ResultBuilder.success(this.crmOaConfigBiz.getOaConfig());
   }

   @ApiOperation("CRM OA审批配置修改")
   @PostMapping("")
   @PreAuthorize("@permission.check('crmOa_config:edit')")
   public ResultVO<Boolean> updateOaConfig(@RequestBody @Valid CrmOaConfigUpdateVO vo) {
      return ResultBuilder.success(this.crmOaConfigBiz.updateOaConfig(vo.getEnabled()));
   }
}
