package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBasicsConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmBasicsConfigUpdateVO;
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

@Api(tags = "crm-配置管理-基础配置")
@RestController
@RequestMapping("/api/crm/basics/config")
public class CrmBasicsConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmBasicsConfigController.class);
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;

   @ApiOperation("基础配置修改")
   @PostMapping("")
   @PreAuthorize("@crmAccess.catalogConfig('base',#crmBasicsConfigEnum)")
   public ResultVO updateByList(@RequestBody List<CrmBasicsConfigUpdateVO> crmBasicsConfigUpdateVO, @RequestParam Integer crmBasicsConfigEnum) {
      log.info("API调用:基础配置修改");
      return ResultBuilder.success(
         this.crmBasicsConfigBiz
            .updateByList(
               crmBasicsConfigUpdateVO.stream().map(item -> BeanUtil.copy(item, CrmBasicsConfigUpdateParam.class)).collect(Collectors.toList()),
               crmBasicsConfigEnum
            )
      );
   }

   @ApiOperation("基础配置查询")
   @GetMapping("")
   public ResultVO getList(Integer crmBasicsConfigEnum) {
      log.info("API调用:基础配置查询");
      return ResultBuilder.success(this.crmBasicsConfigBiz.getList(crmBasicsConfigEnum));
   }

   @ApiOperation("基础配置查询(跨越权限)")
   @GetMapping("/skip/permissions")
   public ResultVO getListSkipPermissions(Integer crmBasicsConfigEnum) {
      log.info("API调用:基础配置查询");
      return ResultBuilder.success(this.crmBasicsConfigBiz.getListSkipPermissions(crmBasicsConfigEnum));
   }
}
