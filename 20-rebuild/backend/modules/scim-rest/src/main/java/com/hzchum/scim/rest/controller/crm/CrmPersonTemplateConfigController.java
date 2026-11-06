package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmPersonTemplateConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmPersonTemplateConfigService;
import com.hzchum.scim.rest.pojo.vo.crm.CrmPersonTemplateConfigUpdateVO;
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

@Api(tags = "crm-配置管理-人员模板配置")
@RestController
@RequestMapping("/api/crm/person/template/config")
public class CrmPersonTemplateConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmPersonTemplateConfigController.class);
   @Resource
   private CrmPersonTemplateConfigService crmPersonTemplateConfigService;

   @ApiOperation("CRM人员模板配置列表")
   @GetMapping("/template/list")
   public ResultVO getTemplateList() {
      log.info("API调用:CRM人员模板配置列表");
      return ResultBuilder.success(this.crmPersonTemplateConfigService.getTemplateList());
   }

   @ApiOperation("根据类型查看详情")
   @GetMapping("/detail")
   public ResultVO getTemplateDetail(Integer crmPersonTemplateEnum) {
      log.info("API调用:根据类型查看详情");
      return ResultBuilder.success(this.crmPersonTemplateConfigService.getTemplateDetail(crmPersonTemplateEnum));
   }

   @ApiOperation("根据类型修改模板")
   @PostMapping("/update/template")
   @PreAuthorize("@crmAccess.personTemplateWrite(#crmpersonTemplateConfigUpdateVO.crmPersonTemplateEnum)")
   public ResultVO updateTemplate(@RequestBody CrmPersonTemplateConfigUpdateVO crmpersonTemplateConfigUpdateVO) {
      log.info("API调用:根据类型修改模板");
      return ResultBuilder.success(
         this.crmPersonTemplateConfigService.updateTemplate(BeanUtil.copy(crmpersonTemplateConfigUpdateVO, CrmPersonTemplateConfigUpdateParam.class))
      );
   }

   @ApiOperation("根据类型删除配置")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_user_template_config:del')")
   public ResultVO deleteTemplate(Integer crmPersonTemplateEnum) {
      log.info("API调用:根据类型删除配置");
      return ResultBuilder.success(this.crmPersonTemplateConfigService.deleteTemplate(crmPersonTemplateEnum));
   }
}
