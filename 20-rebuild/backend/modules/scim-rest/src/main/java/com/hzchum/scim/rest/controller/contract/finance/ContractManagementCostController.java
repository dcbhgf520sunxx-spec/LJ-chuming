package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractManagementCostBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractManagementCostDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.SaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractManagementCostDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配置管理-管理费")
@RestController
@Validated
@RequestMapping("/api/contractManagementCost")
public class ContractManagementCostController {
   private static final Logger log = LoggerFactory.getLogger(ContractManagementCostController.class);
   @Resource
   private ContractManagementCostBiz contractManagementCostBiz;

   @ApiOperation("获取管理费分页")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('management-config:get')")
   public ResultVO<PageVO<ContractManagementCostDto>> contractManagementCostDtoPageSize(
      @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取管理费分页详情");
      return ResultBuilder.success(this.contractManagementCostBiz.pageSize(pageNumber, pageSize));
   }

   @ApiOperation("新增管理费")
   @PostMapping
   @PreAuthorize("@permission.check('management-config:add')")
   public ResultVO<Boolean> addContractManagementCost(@RequestBody @Valid List<ContractManagementCostDtoParam> dto) {
      log.info("API 调用 ：新增管理费");
      return ResultBuilder.success(this.contractManagementCostBiz.addEarnestMoney(dto));
   }

   @ApiOperation("修改管理费")
   @PutMapping
   @PreAuthorize("@permission.check('management-config:edit')")
   public ResultVO<Boolean> updateContractManagementCost(@RequestBody @Valid ContractManagementCostDtoParam dto) {
      log.info("API 调用 ：修改管理费");
      return ResultBuilder.success(this.contractManagementCostBiz.updateEarnestMoney(dto));
   }

   @ApiOperation("修改管理费-单独")
   @PostMapping("/projectManagementCost")
   public ResultVO<Boolean> updateProjectManagementCost(@RequestBody @Valid SaveDtoParam dtoParam) {
      log.info("API 调用 ：修改管理费-单独");
      return ResultBuilder.success(this.contractManagementCostBiz.updateProjectManagementCost(dtoParam));
   }

   @ApiOperation("删除管理费")
   @DeleteMapping
   @PreAuthorize("@permission.check('management-config:del')")
   public ResultVO<Boolean> deleteContractManagementCost(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除管理费");
      return ResultBuilder.success(this.contractManagementCostBiz.deleteEarnestMoney(ids));
   }

   @ApiOperation("修改管理费状态")
   @PutMapping("/updateStatus")
   @PreAuthorize("@permission.check('management-config:edit')")
   public ResultVO<Boolean> updateContractManagementCostStatus(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 ：修改管理费状态");
      return ResultBuilder.success(this.contractManagementCostBiz.updateEarnestMoneyStatus(id, status));
   }

   @ApiOperation("获取项目管理费")
   @GetMapping("/getProjectManagementCost")
   public ResultVO<BigDecimal> getProjectManagementCost(@RequestParam Long projectId) {
      log.info("API 调用 ：获取项目管理费");
      return ResultBuilder.success(this.contractManagementCostBiz.getProjectManagementCost(projectId));
   }
}
