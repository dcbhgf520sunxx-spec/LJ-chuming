package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmNumberPrefixConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmNumberPrefixConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmNumberPrefixConfigUpdateVO;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "crm-配置管理-编号配置")
@RestController
@RequestMapping("/api/crm/number/prefix/config")
public class CrmNumberPrefixConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmNumberPrefixConfigController.class);
   @Resource
   private CrmNumberPrefixConfigBiz crmNumberPrefixConfigBiz;

   @ApiOperation("编号配置列表获取")
   @GetMapping("")
   public ResultVO getList() {
      log.info("API调用:编号配置列表获取");
      return ResultBuilder.success(this.crmNumberPrefixConfigBiz.getList());
   }

   @ApiOperation("编号配置批量修改")
   @PostMapping("")
   @PreAuthorize("@permission.check('crm_number_config:save')")
   public ResultVO updateByList(@RequestBody List<CrmNumberPrefixConfigUpdateVO> list) {
      log.info("API调用:编号配置列表获取");
      return ResultBuilder.success(
         this.crmNumberPrefixConfigBiz
            .updateByList(list.stream().map(item -> BeanUtil.copy(item, CrmNumberPrefixConfigUpdateParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("编号前缀命名")
   @PostMapping("/generate")
   public ResultVO generate(Integer crmNumberPrefixConfigEnum) {
      log.info("API调用:编号前缀命名");
      return ResultBuilder.success(this.crmNumberPrefixConfigBiz.generateSerialNumber(crmNumberPrefixConfigEnum));
   }
}
