package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountVO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanySaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Api(tags = "系统管理-分支机构")
@RestController
@RequestMapping("/api/branchCompany")
public class BranchCompanyApi {
   private static final Logger log = LoggerFactory.getLogger(BranchCompanyApi.class);
   private final BranchCompanyService branchCompanyService;
   private final BankAccountService bankAccountService;

   @ApiOperation("获取分支机构列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "公司名称", paramType = "query"),
            @ApiImplicitParam(name = "socialCode", value = "统一信用码", paramType = "query"),
            @ApiImplicitParam(name = "enabled", value = "状态 1启用 0禁用", paramType = "query"),
            @ApiImplicitParam(name = "level", value = "单位属性 1一级单位 2二级单位", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('branch_company:get')")
   public ResultVO pageByCondition(
      String name,
      String socialCode,
      Integer enabled,
      @RequestParam(name = "level", required = false) Integer level,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取分支机构列表");
      return ResultBuilder.success(this.branchCompanyService.pageByCondition(name, socialCode, enabled, level, pageNumber, pageSize));
   }

   @PreAuthorize("@permission.check('branch_company:get')")
   public ResultVO pageByCondition(String name, String socialCode, Integer enabled, Integer pageNumber, Integer pageSize) {
      return this.pageByCondition(name, socialCode, enabled, null, pageNumber, pageSize);
   }

   @ApiOperation("公共接口-获取分支机构列表")
   @GetMapping("/all/simple")
   public ResultVO listSimple() {
      log.info("API 调用 ：获取简单的分支机构信息列表");
      return ResultBuilder.success(this.branchCompanyService.listSimple());
   }

   @ApiOperation("采购订单根据单位获取签订主体")
   @GetMapping("/purchaseByLevelList")
   public ResultVO purchaseByLevelList(Integer level) {
      log.info("API 调用 ：采购订单根据单位获取签订主体");
      return ResultBuilder.success(this.branchCompanyService.purchaseByLevelList(level));
   }

   @ApiOperation("保存分支机构信息")
   @PostMapping("")
   @PreAuthorize("@permission.check('branch_company:add')")
   public ResultVO saveInbound(@Valid @RequestBody BranchCompanySaveDTOParam requestVO) {
      log.info("API 调用 ：保存分支机构信息");
      return ResultBuilder.success(this.branchCompanyService.save(requestVO));
   }

   @ApiOperation("更新分支机构的信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('branch_company:edit')")
   public ResultVO update(@Valid @RequestBody BranchCompanyUpdateDTOParam requestVO) {
      log.info("API 调用 ： 更新分支机构的信息");
      return ResultBuilder.success(this.branchCompanyService.update(requestVO));
   }

   @ApiOperation("批量删除分支机构信息")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('branch_company:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除分支机构信息");
      return ResultBuilder.success(this.branchCompanyService.delete(ids));
   }

   @ApiOperation("更新分支机构状态")
   @PutMapping("enabled")
   @PreAuthorize("@permission.check('branch_company:edit')")
   public ResultVO updateEnabled(@RequestParam Long id, @RequestParam Integer enabled) {
      log.info("API 调用 ：更新分支机构状态");
      return ResultBuilder.success(this.branchCompanyService.updateEnabled(id, enabled));
   }

   @ApiOperation("银行账号列表")
   @GetMapping("/bankAccount/all")
   @PreAuthorize("@permission.check('branch_company:get')")
   public ResultVO listAll() {
      log.info("API 调用 ：银行账号列表");
      return ResultBuilder.success(this.branchCompanyService.listBlankAccount());
   }

   @ApiOperation("根据分支机构id,查询银行账号列表")
   @GetMapping("/listBankAccountByCompanyId/{companyId}")
   public ResultVO<ListVO<BankAccountVO>> listBankAccount(@PathVariable("companyId") Long companyId) {
      log.info("Api调用: 根据分支机构id查询银行账号列表");
      return ResultBuilder.success(this.bankAccountService.listByCompanyId(companyId));
   }

   @ApiOperation("公共接口-获取分支机构和项目联动列表")
   @GetMapping("/all/get-branch-project-list")
   public ResultVO getBranchProjectList() {
      log.info("API 调用 ：获取分支机构和项目联动列表");
      return ResultBuilder.success(this.branchCompanyService.getBranchProjectList());
   }

   public BranchCompanyApi(final BranchCompanyService branchCompanyService, final BankAccountService bankAccountService) {
      this.branchCompanyService = branchCompanyService;
      this.bankAccountService = bankAccountService;
   }
}
