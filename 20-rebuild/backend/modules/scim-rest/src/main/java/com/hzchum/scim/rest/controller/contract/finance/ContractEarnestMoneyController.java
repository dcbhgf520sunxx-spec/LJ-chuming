package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractEarnestMoneyBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractEarnestMoneyDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractEarnestMoneyDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "配置管理-保证金")
@RestController
@Validated
@RequestMapping("/api/contractEarnestMoney")
public class ContractEarnestMoneyController {
   private static final Logger log = LoggerFactory.getLogger(ContractEarnestMoneyController.class);
   @Resource
   private ContractEarnestMoneyBiz contractEarnestMoneyBiz;

   @ApiOperation("获取保证金分页")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('management-config:get')")
   public ResultVO<PageVO<ContractEarnestMoneyDto>> contractEarnestMoneyDtoPageSize(
      @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取项目台账分页详情");
      return ResultBuilder.success(this.contractEarnestMoneyBiz.pageSize(pageNumber, pageSize));
   }

   @ApiOperation("新增保证金")
   @PostMapping
   @PreAuthorize("@permission.check('management-config:add')")
   public ResultVO<Boolean> addContractEarnestMoney(@RequestBody @Valid List<ContractEarnestMoneyDtoParam> dto) {
      log.info("API 调用 ：新增保证金");
      return ResultBuilder.success(this.contractEarnestMoneyBiz.addEarnestMoney(dto));
   }

   @ApiOperation("修改保证金")
   @PutMapping
   @PreAuthorize("@permission.check('management-config:edit')")
   public ResultVO<Boolean> updateContractEarnestMoney(@RequestBody ContractEarnestMoneyDtoParam dto) {
      log.info("API 调用 ：修改保证金");
      return ResultBuilder.success(this.contractEarnestMoneyBiz.updateEarnestMoney(dto));
   }

   @ApiOperation("修改保证金-单独")
   @PutMapping("/earnestMoney")
   public ResultVO<Boolean> putContractEarnestMoney(@RequestBody ContractEarnestMoneyDtoParam dto) {
      log.info("API 调用 ：修改保证金-单独");
      return ResultBuilder.success(this.contractEarnestMoneyBiz.putEarnestMoney(dto));
   }

   @ApiOperation("删除保证金")
   @DeleteMapping
   @PreAuthorize("@permission.check('management-config:del')")
   public ResultVO<Boolean> deleteContractEarnestMoney(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除保证金");
      return ResultBuilder.success(this.contractEarnestMoneyBiz.deleteEarnestMoney(ids));
   }

   @ApiOperation("修改保证金状态")
   @PutMapping("/updateStatus")
   @PreAuthorize("@permission.check('management-config:edit')")
   public ResultVO<Boolean> updateContractEarnestMoneyStatus(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 ：修改保证金状态");
      return ResultBuilder.success(this.contractEarnestMoneyBiz.updateEarnestMoneyStatus(id, status));
   }
}
