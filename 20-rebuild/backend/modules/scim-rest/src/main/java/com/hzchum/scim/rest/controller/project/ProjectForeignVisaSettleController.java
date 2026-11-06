package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.common.valid.Update;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.contract.core.api.biz.ContractVisaBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaModeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractSettlementDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaApproveOpinionDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.visa.ContractVisaDTOParamV2;
import com.hzchum.scim.project.core.api.biz.ProjectForeignVisaBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Api(tags = "项目管理-项目承包项目-签证结算")
@RestController
@RequestMapping("/api/project/foreign/visa-settle")
public class ProjectForeignVisaSettleController {
   private static final Logger log = LoggerFactory.getLogger(ProjectForeignVisaSettleController.class);
   @Resource
   private ContractVisaBiz contractVisaBiz;
   @Resource
   ProjectForeignVisaBiz projectForeignVisaBiz;
   @Resource
   private ContractVisaService contractVisaService;
   @Resource
   private WmsApproveRecordDetailService approveRecordDetailService;

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "status", value = "审核状态 1审核中 2通过 4驳回", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "审核状态 申请人", paramType = "query"),
            @ApiImplicitParam(name = "checkUerName", value = "审核状态 审核人", paramType = "query"),
            @ApiImplicitParam(name = "type", value = " 类型: 1签证 2结算", paramType = "query")
      }
   )
   @ApiOperation("签证结算列表")
   @GetMapping
   @PreAuthorize("@permission.check('visa_settle:get')")
   public ResultVO<PageVO<ContractVisaDTO>> list(
      Long projectId,
      Integer status,
      String userName,
      String checkUerName,
      String year,
      Integer type,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目管理-签证结算列表");
      return ResultBuilder.success(
         this.contractVisaBiz
            .pageList(
               projectId,
               status,
               userName,
               checkUerName,
               VisaModeEnum.FOREIGN.getType(),
               year,
               ProjectBusinessTypeEnum.JOB.getType(),
               type,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("新增-签证")
   @PostMapping("/visa")
   @PreAuthorize("@permission.check('visa_settle:add')")
   public ResultVO saveVisa(@RequestBody @Validated(Add.class) ContractVisaDTOParam param) {
      log.info("API 调用 ：新增签证");
      param.setMode(VisaModeEnum.FOREIGN.getType());
      return ResultBuilder.success(this.contractVisaBiz.save(param));
   }

   @ApiOperation("新增签证V2")
   @PostMapping("/visaV2")
   @PreAuthorize("@permission.check('visa_manage:save')")
   @SignerCheck(lockKey = "#param.projectId", message = "操作失败,正在创建签证请刷新稍后重试")
   public ResultVO saveVisa(@RequestBody @Validated(Add.class) ContractVisaDTOParamV2 param) {
      log.info("API 调用 ：新增签证V2");
      return ResultBuilder.success(this.contractVisaBiz.saveV2(param));
   }

   @ApiOperation("审核签证V2")
   @PutMapping("/checkV2")
   @PreAuthorize("@permission.check('visa_manage:pass','visa_manage:reject') or @projectForeignVisaSettleController.canReadVisaV2(#p0.dataId)")
   public ResultVO update(@RequestBody @Validated ContractVisaApproveOpinionDTOParam param) {
      log.info("API 调用 ：审核签证V2");
      return ResultBuilder.success(this.contractVisaBiz.checkV2(param));
   }

   @ApiOperation("签证撤销审批")
   @PutMapping("/cancelApproveDetail/{id}")
   @PreAuthorize("@permission.check('visa_manage:del') or @projectForeignVisaSettleController.canReadVisaV2(#p0)")
   public ResultVO cancelApproveDetail(@PathVariable Long id) {
      log.info("API 调用 ：签证撤销审批");
      return ResultBuilder.success(this.contractVisaBiz.cancelApproveDetail(id));
   }

   @ApiOperation("签证详情V2")
   @GetMapping("/V2/{id}")
   @PreAuthorize("@permission.check('visa_manage:detail') or @projectForeignVisaSettleController.canReadVisaV2(#p0)")
   public ResultVO getDetailV2(@PathVariable Long id) {
      log.info("API 调用 ：签证详情V2");
      return ResultBuilder.success(this.contractVisaBiz.getDetailV2(id));
   }

   public boolean canReadVisaV2(Long id) {
      ContractVisa visa = this.contractVisaService.getById(id);
      if (visa == null) {
         return false;
      }
      Long userId = UserUtil.getCurrentUserId();
      return userId.equals(visa.getUserId()) || this.approveRecordDetailService.count(
         Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
            .eq(WmsApproveRecordDetail::getDataId, id)
            .eq(WmsApproveRecordDetail::getApproveProcessType, ApproveProcessTypeEnumV2.PROJECT_MANAGE_VISA.getType())
            .eq(WmsApproveRecordDetail::getCheckUserId, userId)
      ) > 0;
   }

   @ApiOperation("签证详情V2下载")
   @GetMapping("/V2/download/{id}")
   @PreAuthorize("@permission.check('visa_manage:export') or @projectForeignVisaSettleController.canReadVisaV2(#p0)")
   public void getDetailDownloadV2(@PathVariable Long id) {
      log.info("API 调用 ：签证详情V2下载");
      this.contractVisaBiz.getDetailDownloadV2(id);
   }

   @ApiOperation("签证单列表V2")
   @GetMapping("/list/v2")
   @PreAuthorize("@permission.check('visa_manage:get')")
   public ResultVO<PageVO<ContractVisaDTO>> listV2(
      Long projectId,
      Integer status,
      String userName,
      String checkUerName,
      Integer mode,
      LocalDate year,
      Integer type,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目管理-签证单列表V2");
      return ResultBuilder.success(this.contractVisaBiz.pageListV2(projectId, status, userName, checkUerName, mode, year, type, pageNumber, pageSize));
   }

   @ApiOperation("修改-签证")
   @PutMapping("/visa")
   @PreAuthorize("@permission.check('visa_settle:edit')")
   public ResultVO updateForeignVisa(@RequestBody @Validated(Update.class) ContractVisaDTOParam param) {
      log.info("API 调用 ：新增签证");
      param.setMode(VisaModeEnum.FOREIGN.getType());
      return ResultBuilder.success(this.contractVisaBiz.update(param));
   }

   @ApiOperation("结算-办理")
   @PostMapping("/settle")
   @PreAuthorize("@permission.check('visa_settle:add')")
   public ResultVO projectHandle(@RequestBody @Validated(Add.class) ContractSettlementDTOParam param) {
      log.info("API 调用 ：项目结算办理");
      return ResultBuilder.success(this.contractVisaBiz.handle(param));
   }

   @ApiOperation("结算-修改")
   @PutMapping("/settle")
   @PreAuthorize("@permission.check('visa_settle:edit')")
   public ResultVO updateProjectHandle(@RequestBody @Validated(Update.class) ContractSettlementDTOParam param) {
      log.info("API 调用 ：项目结算办理修改");
      return ResultBuilder.success(this.contractVisaBiz.updateProjectHandle(param));
   }

   @ApiOperation("审核-签证结算")
   @PutMapping("/check")
   @PreAuthorize("@permission.check('visa_settle:audit')")
   public ResultVO update(@RequestBody @Validated ContractCheckDTOParam param) {
      log.info("API 调用 ：审核签证");
      return ResultBuilder.success(this.contractVisaBiz.check(param));
   }

   @ApiOperation("导出-结算单")
   @GetMapping("/export-settle/{id}")
   @PreAuthorize("@permission.check('visa_settle:download')")
   public void exportSettle(@PathVariable Long id, HttpServletResponse response) {
      log.info("Api调用: 导出-项目承包对外结算单");
      this.projectForeignVisaBiz.exportSettlement(id, response);
   }

   @ApiOperation("删除签证")
   @DeleteMapping("/deleteVisa")
   @PreAuthorize("@permission.check('visa_manage:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除签证");
      return ResultBuilder.success(this.contractVisaBiz.deleteVisa(ids));
   }
}
