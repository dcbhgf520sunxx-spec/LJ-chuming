package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmPageManagementConfigBiz;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmPageManagementConfigUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmPageManagementConfigUpdateVO;
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

@Api(tags = "crm-配置管理-页面配置")
@RestController
@RequestMapping("/api/crm/page/management/config")
public class CrmPageManagementConfigController {
   private static final Logger log = LoggerFactory.getLogger(CrmPageManagementConfigController.class);
   @Resource
   private CrmPageManagementConfigBiz crmPageManagementConfigBiz;

   @ApiOperation("样式布局查询")
   @GetMapping("/get/style/layout")
   public ResultVO getStyleLayoutList() {
      log.info("API调用:样式布局查询");
      return ResultBuilder.success(this.crmPageManagementConfigBiz.getStyleLayoutList());
   }

   @ApiOperation("页面详情查询")
   @GetMapping("")
   public ResultVO getPageDetailByPageEnum(@RequestParam Integer crmPageManagementConfigEnum, Integer crmCountryTypeEnum) {
      log.info("API调用:页面详情查询");
      return ResultBuilder.success(this.crmPageManagementConfigBiz.getPageDetailByPageEnum(crmPageManagementConfigEnum, crmCountryTypeEnum));
   }

   @ApiOperation("页面详情布局修改")
   @PostMapping("")
   @PreAuthorize("@permission.check('crm_detail_config:save')")
   public ResultVO updateByList(@RequestBody List<CrmPageManagementConfigUpdateVO> ListVO) {
      log.info("API调用:页面详情布局修改");
      return ResultBuilder.success(
         this.crmPageManagementConfigBiz
            .updateByList(ListVO.stream().map(item -> BeanUtil.copy(item, CrmPageManagementConfigUpdateParam.class)).collect(Collectors.toList()))
      );
   }
}
