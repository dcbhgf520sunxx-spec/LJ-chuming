package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmInformationValidityPeriodConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmInformationValidityPeriodConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmInformationValidityPeriodConfigUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "crm-配置管理-信息有效期配置")
@RestController
@RequestMapping("/api/crm/information/validity/period/config")
public class CrmInformationValidityPeriodConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmInformationValidityPeriodConfigController.class);
   @Resource
   private CrmInformationValidityPeriodConfigBiz crmInformationValidityPeriodConfigBiz;

   @ApiOperation("获取信息有效期配置列表")
   @GetMapping("")
   public ResultVO getList(Integer crmInformationValidityPeriodConfigEnum) {
      log.info("API调用:获取信息有效期配置列表");
      return ResultBuilder.success(this.crmInformationValidityPeriodConfigBiz.getList(crmInformationValidityPeriodConfigEnum));
   }

   @ApiOperation("获取信息有效期配置修改")
   @PostMapping("")
   @PreAuthorize("@crmAccess.validityConfig(#crmInformationValidityPeriodConfigEnum)")
   public ResultVO updateByList(
      @RequestBody List<CrmInformationValidityPeriodConfigUpdateVO> list, @RequestParam Integer crmInformationValidityPeriodConfigEnum
   ) {
      log.info("API调用:获取信息有效期配置修改");
      return ResultBuilder.success(
         this.crmInformationValidityPeriodConfigBiz
            .updateByList(
               list.stream().map(item -> BeanUtil.copy(item, CrmInformationValidityPeriodConfigUpdateParam.class)).collect(Collectors.toList()),
               crmInformationValidityPeriodConfigEnum
            )
      );
   }

   @ApiOperation("获取信息有效期配置列表(跨越权限)")
   @GetMapping("/skip/permissions")
   public ResultVO getListSkipPermissions(Integer crmInformationValidityPeriodConfigEnum) {
      log.info("API调用:获取信息有效期配置列表(跨越权限)");
      return ResultBuilder.success(this.crmInformationValidityPeriodConfigBiz.getListSkipPermissions(crmInformationValidityPeriodConfigEnum));
   }
}
