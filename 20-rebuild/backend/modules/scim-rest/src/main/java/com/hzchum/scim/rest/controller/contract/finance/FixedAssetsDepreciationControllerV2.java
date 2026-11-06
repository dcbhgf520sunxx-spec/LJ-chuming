package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.contract.core.api.biz.finance.ContractFixedAssetsDepreciationBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-费用管理")
@RestController
@RequestMapping("/api/contract/fixed-assets-depreciation/V2")
public class FixedAssetsDepreciationControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(FixedAssetsDepreciationControllerV2.class);
   @Resource
   private ContractFixedAssetsDepreciationBiz fixedAssetsDepreciationBiz;

   @ApiOperation("厂房折旧-分页查询")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "isTrue", value = "是否启用", required = false, dataType = "Boolean"),
            @ApiImplicitParam(name = "collectionUnitId", value = "签订主体", required = false, dataType = "Long")
      }
   )
   @GetMapping("/listByCondition")
   public ResultVO listByCondition(Boolean isTrue, Long collectionUnitId, Integer pageNumber, Integer pageSize) {
      log.info("API 调用 ： 厂房折旧分页查询");
      return null;
   }
}
