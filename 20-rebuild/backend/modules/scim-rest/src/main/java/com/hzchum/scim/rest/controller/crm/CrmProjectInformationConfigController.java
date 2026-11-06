package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmCustomQuantityUpdateParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectInformationConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmCustomQuantityUpdateVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmProjectInformationConfigUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "crm-配置管理-项目信息配置")
@RestController
@RequestMapping("/api/crm/project/information/config")
public class CrmProjectInformationConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectInformationConfigController.class);
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;

   @ApiOperation("项目信息配置修改")
   @PostMapping("")
   @PreAuthorize("@crmAccess.catalogConfig('project',#crmProjectInformationConfigEnum)")
   public ResultVO updateByList(@RequestBody List<CrmProjectInformationConfigUpdateVO> voList, @RequestParam Integer crmProjectInformationConfigEnum) {
      log.info("API调用:项目信息配置修改");
      return ResultBuilder.success(
         this.crmProjectInformationConfigBiz
            .updateByList(
               voList.stream().map(item -> BeanUtil.copy(item, CrmProjectInformationConfigUpdateParam.class)).collect(Collectors.toList()),
               crmProjectInformationConfigEnum
            )
      );
   }

   @ApiOperation("项目信息配置查询")
   @GetMapping("")
   public ResultVO getList(Integer crmProjectInformationConfigEnum) {
      log.info("API调用:项目信息配置查询");
      return ResultBuilder.success(this.crmProjectInformationConfigBiz.getList(crmProjectInformationConfigEnum));
   }

   @ApiOperation("项目信息配置查询(跨越权限)")
   @GetMapping("/skip/permissions")
   public ResultVO getListSkipPermissions(Integer crmProjectInformationConfigEnum) {
      log.info("API调用:项目信息配置查询(跨越权限)");
      return ResultBuilder.success(this.crmProjectInformationConfigBiz.getListSkipPermissions(crmProjectInformationConfigEnum));
   }

   @ApiOperation("项目名额自定义配置数量")
   @PostMapping("/custom/quantity/update")
   @PreAuthorize("@permission.check('crm_expiration_date_config:editProjectNumberConfig')")
   public ResultVO customQuantityUpdate(@RequestBody List<CrmCustomQuantityUpdateVO> voList) {
      log.info("API调用:项目名额自定义配置数量");
      return ResultBuilder.success(
         this.crmProjectInformationConfigBiz
            .customQuantityUpdate(voList.stream().map(item -> BeanUtil.copy(item, CrmCustomQuantityUpdateParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("项目名额自定义配置数量清除")
   @DeleteMapping("/custom/quantity/clean")
   @PreAuthorize("@permission.check('crm_expiration_date_config:editProjectNumberConfig')")
   public ResultVO customQuantityClean() {
      log.info("API调用:项目名额自定义配置数量清除");
      return ResultBuilder.success(this.crmProjectInformationConfigBiz.customQuantityClean());
   }

   @ApiOperation("项目名额自定义配置数量查询")
   @GetMapping("/custom/quantity/list")
   public ResultVO customQuantityList(Long userId) {
      log.info("API调用:项目名额自定义配置数量查询");
      return ResultBuilder.success(this.crmProjectInformationConfigBiz.customQuantityList(userId));
   }
}
