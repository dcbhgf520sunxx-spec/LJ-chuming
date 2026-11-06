package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGivingCreditDetailBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDetailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "授信管理--授信使用明细")
@RestController
@Validated
@RequestMapping("/api/creditDetail")
public class CreditDetailController {
   private static final Logger log = LoggerFactory.getLogger(CreditDetailController.class);
   @Resource
   private ContractGivingCreditDetailBiz contractGivingCreditDetailBiz;

   @ApiOperation("获取授信使用明细分页")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "creditId", value = "授信id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", required = false, dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", required = false, dataType = "LocalDateTime", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审批状态 审批状态：1 待审核 2 通过 4 不通过", required = false, dataType = "Integer", paramType = "query")
      }
   )
   @GetMapping("/pageSize")
   @PreAuthorize("@permission.check('grant-extension:get')")
   public ResultVO<PageVO<ContractGivingCreditDetailDto>> pageSize(
      @RequestParam Long creditId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 : 获取授信使用明细分页查询");
      return ResultBuilder.success(this.contractGivingCreditDetailBiz.pageSize(creditId, startDate, endDate, auditStatus, pageNumber, pageSize));
   }
}
