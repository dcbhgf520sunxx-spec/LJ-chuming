package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.SecurityDepositAndManagementCostBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.SaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.SecurityDepositAndManagementCostDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理费和保证金")
@RestController
@Validated
@RequestMapping("/api/securityAndManagementCost")
public class SecurityDepositAndManagementCostController {
   private static final Logger log = LoggerFactory.getLogger(SecurityDepositAndManagementCostController.class);
   @Resource
   private SecurityDepositAndManagementCostBiz securityDepositAndManagementCostBiz;

   @ApiOperation("管理费和保证金分页接口")
   @GetMapping("/page")
   public ResultVO<PageVO<SecurityDepositAndManagementCostDto>> securityDepositAndManagementCostDtoPageSize(
      Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 : 获取管理费和保证金分页接口");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.pagingQuery(projectId, pageNumber, pageSize));
   }

   @ApiOperation("新增管理费和保证金")
   @PostMapping
   public ResultVO<Boolean> addSecurityDepositAndManagementCost(@RequestBody @Valid List<SecurityDepositAndManagementCostDtoParam> dto) {
      log.info("API 调用 : 新增管理费和保证金");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.addSecurityDepositAndManagementCost(dto));
   }

   @ApiOperation("修改管理费和保证金")
   @PutMapping
   public ResultVO<Boolean> updateSecurityDepositAndManagementCost(@RequestBody SecurityDepositAndManagementCostDtoParam dto) {
      log.info("API 调用 : 修改管理费和保证金");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.updateSecurityDepositAndManagementCost(dto));
   }

   @ApiOperation("删除管理费和保证金")
   @DeleteMapping
   public ResultVO<Boolean> deleteSecurityDepositAndManagementCost(@RequestBody List<Long> ids) {
      log.info("API 调用 : 删除管理费和保证金");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.deleteSecurityDepositAndManagementCost(ids));
   }

   @ApiOperation("退还保证金或管理费的原始金额查询")
   @GetMapping("/accruingAmounts")
   public ResultVO<BigDecimal> sendBackSecurityDepositAndManagementCost(@RequestParam Long projectId, @RequestParam("auditStatus") Integer amountType) {
      log.info("API 调用 : 退还保证金或管理费的原始金额查询");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.accruingAmounts(projectId, amountType));
   }

   @ApiOperation("退还保证金或管理费")
   @PostMapping("/sendBack")
   public ResultVO<Boolean> sendBackSecurityDepositAndManagementCost(@RequestBody @Valid SaveDtoParam saveDtoParam) {
      log.info("API 调用 : 退还保证金或管理费");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.sendBackSecurityDepositAndManagementCost(saveDtoParam));
   }

   @ApiOperation("修改保证金原始金额查询")
   @GetMapping("/accruingAmounts/{projectId}")
   public ResultVO updateSecurityDepositAndManagementCost(@PathVariable Long projectId) {
      log.info("API 调用 : 修改保证金原始金额查询");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.getAccruingAmounts(projectId));
   }

   @ApiOperation("获取项目保证金或管理费")
   @GetMapping("/getProjectInterest")
   public ResultVO<PageVO<SecurityDepositAndManagementCostDetailDTO>> getSecurityDepositAndManagementCostDetail(
      @RequestParam Long projectId, @RequestParam Integer type, @RequestParam Integer pageNumber, @RequestParam Integer pageSize
   ) {
      log.info("API 调用 : 获取项目保证金或管理费");
      return ResultBuilder.success(this.securityDepositAndManagementCostBiz.getSecurityDepositAndManagementCostDetail(projectId, type, pageNumber, pageSize));
   }
}
