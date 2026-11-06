package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmBiddingPlatformWarehousingSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmBiddingPlatformWarehousingSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-crm-办事大厅-招标平台注册")
@RestController
@RequestMapping("/api/app/crm/bidding/platform/warehousing")
public class AppCrmBiddingPlatformWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmBiddingPlatformWarehousingController.class);
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;

   @ApiOperation("app-招标备案新增")
   @PostMapping("/save")
   public ResultVO saveCrmBiddingPlatformWarehousing(@RequestBody CrmBiddingPlatformWarehousingSaveVO crmBiddingPlatformWarehousingSaveVO) {
      log.info("API调用:app-招标备案新增");
      return ResultBuilder.success(
         this.crmBiddingPlatformWarehousingBiz
            .saveCrmBiddingPlatformWarehousing(BeanUtil.copy(crmBiddingPlatformWarehousingSaveVO, CrmBiddingPlatformWarehousingSaveParam.class))
      );
   }
}
