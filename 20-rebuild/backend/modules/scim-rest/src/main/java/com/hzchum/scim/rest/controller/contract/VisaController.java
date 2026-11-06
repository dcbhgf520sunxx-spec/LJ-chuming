package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.biz.ContractVisaBiz;
import com.hzchum.scim.contract.core.api.enums.visa.VisaModeEnum;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractSettlementDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-签证管理")
@RestController
@RequestMapping("/api/visa")
public class VisaController {
   private static final Logger log = LoggerFactory.getLogger(VisaController.class);
   @Autowired
   private ContractVisaBiz visaBiz;

   @ApiOperation("获取对外签证列表")
   @GetMapping("foreign")
   @PreAuthorize("@permission.check('contract_visa_manage:get','contract_settlement_manage:get')")
   public ResultVO listForeign(
      Long projectId,
      Integer status,
      String userName,
      String checkUerName,
      String year,
      Integer businessType,
      Integer type,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取对外签证列表");
      return ResultBuilder.success(
         this.visaBiz.pageList(projectId, status, userName, checkUerName, VisaModeEnum.FOREIGN.getType(), year, businessType, type, pageNumber, pageSize)
      );
   }

   @ApiOperation("签证详情")
   @PostMapping("/{id}")
   @PreAuthorize(
      "@permission.check('contract_visa_manage:detail','contract_settlement_manage:detail','visa_settle:detail','contract_visa_manage:add','contract_visa_manage:edit','contract_visa_manage:audit','contract_settlement_manage:audit','contract_visa_manage:add','contract_visa_manage:edit','visa_settle:add','visa_settle:edit','visa_settle:audit')"
   )
   public ResultVO getDetail(@PathVariable Long id) {
      log.info("API 调用 ：签证详情");
      return ResultBuilder.success(this.visaBiz.getDetail(id));
   }

   @ApiOperation("签证详情下载")
   @GetMapping("/{id}/export")
   @PreAuthorize("@permission.check('contract_visa_manage:download')")
   public void exportDetail(@PathVariable Long id, HttpServletResponse response) {
      log.info("API 调用 ：签证详情下载");
      this.visaBiz.exportDetail(id, response);
   }

   @ApiOperation("结算详情下载")
   @GetMapping("/{id}/settlement/export")
   @PreAuthorize("@permission.check('contract_settlement_manage:download')")
   public void exportSettlementDetail(@PathVariable Long id, HttpServletResponse response) {
      log.info("API 调用 ：结算详情下载");
      this.visaBiz.exportSettlementDetail(id, response);
   }

   @ApiOperation("新增对外签证")
   @PostMapping("foreign")
   @PreAuthorize("@permission.check('contract_visa_manage:add')")
   public ResultVO saveForeignVisa(@RequestBody @Validated(Add.class) ContractVisaDTOParam param) {
      log.info("API 调用 ：新增签证");
      param.setMode(VisaModeEnum.FOREIGN.getType());
      return ResultBuilder.success(this.visaBiz.save(param));
   }

   @ApiOperation("修改对外签证")
   @PutMapping("foreign")
   @PreAuthorize("@permission.check('contract_visa_manage:edit')")
   public ResultVO updateForeignVisa(@RequestBody @Validated(Update.class) ContractVisaDTOParam param) {
      log.info("API 调用 ：新增签证");
      param.setMode(VisaModeEnum.FOREIGN.getType());
      return ResultBuilder.success(this.visaBiz.update(param));
   }

   @ApiOperation("审核签证")
   @PostMapping
   @PreAuthorize("@permission.check('contract_visa_manage:audit','contract_settlement_manage:audit')")
   public ResultVO update(@RequestBody @Validated ContractCheckDTOParam param) {
      log.info("API 调用 ：审核签证");
      return ResultBuilder.success(this.visaBiz.check(param));
   }

   @ApiOperation("项目信息")
   @GetMapping("/project/{projectId}")
   public ResultVO handle(@PathVariable Long projectId) {
      log.info("API 调用 ：项目结算办理");
      return ResultBuilder.success(this.visaBiz.projectInfoById(projectId));
   }

   @ApiOperation("项目结算办理")
   @PostMapping("/project/handle")
   @PreAuthorize("@permission.check('contract_settlement_manage:add')")
   public ResultVO projectHandle(@RequestBody @Validated(Add.class) ContractSettlementDTOParam param) {
      log.info("API 调用 ：项目结算办理");
      return ResultBuilder.success(this.visaBiz.handle(param));
   }

   @ApiOperation("项目结算办理修改")
   @PutMapping("/project/handle")
   @PreAuthorize("@permission.check('contract_settlement_manage:edit')")
   public ResultVO updateProjectHandle(@RequestBody @Validated(Update.class) ContractSettlementDTOParam param) {
      log.info("API 调用 ：项目结算办理修改");
      return ResultBuilder.success(this.visaBiz.updateProjectHandle(param));
   }
}
