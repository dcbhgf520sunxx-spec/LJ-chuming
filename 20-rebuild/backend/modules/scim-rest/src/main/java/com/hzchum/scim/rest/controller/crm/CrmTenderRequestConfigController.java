package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmTenderRequestConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmTenderRequestConfigUpdateVO;
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

@Api(tags = "crm-配置管理-投标申请配置")
@RestController
@RequestMapping("/api/crm/tender/request/config")
public class CrmTenderRequestConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmTenderRequestConfigController.class);
   @Resource
   private CrmTenderRequestConfigBiz crmTenderRequestConfigBiz;

   @ApiOperation("投标申请配置修改")
   @PostMapping("")
   @PreAuthorize("@crmAccess.catalogConfig('tender',#crmTenderRequestConfigEnum)")
   public ResultVO updateByList(
      @RequestBody List<CrmTenderRequestConfigUpdateVO> voList, @RequestParam Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum
   ) {
      log.info("API调用:基础配置修改");
      return ResultBuilder.success(
         this.crmTenderRequestConfigBiz
            .updateByList(
               voList.stream().map(item -> BeanUtil.copy(item, CrmTenderRequestConfigUpdateParam.class)).collect(Collectors.toList()),
               crmTenderRequestConfigEnum,
               crmSpecialBubmissionStatusEnum
            )
      );
   }

   @ApiOperation("投标申请配置查询")
   @GetMapping("")
   public ResultVO getList(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum) {
      log.info("API调用:基础配置查询");
      return ResultBuilder.success(this.crmTenderRequestConfigBiz.getList(crmTenderRequestConfigEnum, crmSpecialBubmissionStatusEnum));
   }

   @ApiOperation("投标申请配置查询(跨越权限)")
   @GetMapping("/skip/permissions")
   public ResultVO getListSkipPermissions(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum) {
      log.info("API调用:投标申请配置查询(跨越权限)");
      return ResultBuilder.success(this.crmTenderRequestConfigBiz.getListSkipPermissions(crmTenderRequestConfigEnum, crmSpecialBubmissionStatusEnum));
   }
}
