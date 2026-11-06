package com.hzchum.scim.rest.controller.contract.finance;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGivingCreditBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractGivingCreditDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-授信管理")
@Validated
@RestController
@RequestMapping("/api/contract/givingCredit")
public class ContractGivingCreditController {
   private static final Logger log = LoggerFactory.getLogger(ContractGivingCreditController.class);
   @Resource
   private ContractGivingCreditBiz contractGivingCreditBiz;

   @ApiOperation("授信管理-分页列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "date", value = "时间", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "创建人", paramType = "query"),
            @ApiImplicitParam(name = "suretyId", value = "授信人", paramType = "query"),
            @ApiImplicitParam(name = "idNumber", value = "身份证号", paramType = "query")
      }
   )
   @GetMapping("/page")
   @PreAuthorize("@permission.check('grant-extension:get')")
   public ResultVO<PageVO<ContractGivingCreditDto>> pageSize(
      LocalDateTime date,
      Long userId,
      Long suretyId,
      String idNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 : 授信分页管理");
      return ResultBuilder.success(this.contractGivingCreditBiz.pageSize(date, userId, suretyId, idNumber, pageNumber, pageSize));
   }

   @ApiOperation("授信管理-新增")
   @PostMapping
   @PreAuthorize("@permission.check('grant-extension:add')")
   public ResultVO save(@RequestBody @Valid ContractGivingCreditDtoParam param) {
      log.info("API 调用 : 新增授信");
      return ResultBuilder.success(this.contractGivingCreditBiz.saveContractGivingCredit(param));
   }

   @ApiOperation("授信管理-修改")
   @PutMapping
   @PreAuthorize("@permission.check('grant-extension:edit')")
   public ResultVO update(@RequestBody @Valid ContractGivingCreditDtoParam param) {
      log.info("API 调用 : 修改授信");
      return ResultBuilder.success(this.contractGivingCreditBiz.putContractGivingCredit(param));
   }

   @ApiOperation("授信管理-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('grant-extension:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 : 删除授信");
      return ResultBuilder.success(this.contractGivingCreditBiz.delContractGivingCredit(ids));
   }

   @ApiOperation("授信管理-修改状态")
   @PutMapping("/status")
   @PreAuthorize("@permission.check('grant-extension:edit')")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 : 修改授信状态");
      return ResultBuilder.success(this.contractGivingCreditBiz.putContractGivingCreditStatus(id, status));
   }

   @ApiOperation("授信管理-根据授信人员查询项目")
   @GetMapping("/project/{projectManagerId}")
   @PreAuthorize("@permission.check('grant-extension:add','grant-extension:edit')")
   public ResultVO getProject(@PathVariable Long projectManagerId) {
      log.info("API 调用 : 根据授信人员查询项目");
      return ResultBuilder.success(this.contractGivingCreditBiz.getProject(projectManagerId));
   }

   @ApiOperation("授信管理-授信回显")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('grant-extension:edit')")
   public ResultVO<ContractGivingCreditDto> get(@PathVariable Long id) {
      log.info("API 调用 : 授信回显");
      return ResultBuilder.success(this.contractGivingCreditBiz.getContractGivingCredit(id));
   }

   @ApiOperation("授信管理-授信下载-打印")
   @GetMapping("/download")
   @PreAuthorize("@permission.check('grant-extension:print')")
   public ResultVO download(LocalDateTime date, Long userId, Long suretyId, String idNumber) {
      log.info("API 调用 : 授信下载-打印");
      return ResultBuilder.success(this.contractGivingCreditBiz.download(ObjectUtils.isNotEmpty(date) ? date.getYear() : null, userId, suretyId, idNumber));
   }
}
