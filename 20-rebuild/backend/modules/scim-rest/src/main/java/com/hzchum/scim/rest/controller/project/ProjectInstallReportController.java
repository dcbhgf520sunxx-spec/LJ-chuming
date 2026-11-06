package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectInstallReportMethodDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.biz.ProjectAuxiliaryMaterialClassBiz;
import com.hzchum.scim.project.core.api.biz.ProjectInstallBiz;
import com.hzchum.scim.project.core.api.biz.ProjectReceivingBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAppInstallReportGroupDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallReportGroupDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubAppReceivingDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallReportQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.AppCheckInstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.AuxiliaryMaterialClassUpdateDtoParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.CheckInstallReportDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectInstallReportSaveDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-安装管理")
@RestController
@RequestMapping("/api/project/install-report")
public class ProjectInstallReportController {
   private static final Logger log = LoggerFactory.getLogger(ProjectInstallReportController.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ProjectInstallBiz installReportBiz;
   @Resource
   private ProjectReceivingBiz projectReceivingRecordBiz;
   @Resource
   ProjectAuxiliaryMaterialClassBiz auxiliaryMaterialClassBiz;

   @ApiOperation("修改安装填报方式")
   @PutMapping("/updateReportMethod")
   @PreAuthorize("@permission.check('install_report_setting:save','install_config_report_method:edit')")
   public ResultVO updateInstallReportMethod(@RequestBody @Valid ProjectInstallReportMethodDTOParam param) {
      log.info("Api调用: 修改项目管理安装填报方式");
      return ResultBuilder.success(this.projectService.updateInstallReportMethod(param));
   }

   @ApiOperation("修改配套件-是否即入即安")
   @PutMapping("/auxiliaryMaterial-report")
   @PreAuthorize("@permission.check('install_config_auxiliary_material:edit')")
   public ResultVO updateAuxiliaryMaterialReport(@RequestBody @Valid List<AuxiliaryMaterialClassUpdateDtoParam> paramList) {
      log.info("Api调用: 修改配套件安装时-是否即入即安");
      return ResultBuilder.success(this.auxiliaryMaterialClassBiz.updateInstallReportMode(paramList));
   }

   @ApiOperation("可安装列表")
   @GetMapping("/list-receiving")
   @PreAuthorize("@permission.check('handle_install:get')")
   public ResultVO<PageVO<ProjectReceivingInstallDTO>> listReceivingInstallStatement(
      @Valid ProjectBaseQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 可安装列表");
      return ResultBuilder.success(this.projectReceivingRecordBiz.listCanInstall(param, pageNumber, pageSize));
   }

   @ApiOperation("PC可安装列表V2")
   @GetMapping("/list-receivingV2")
   public ResultVO<PageVO<ProjectReceivingInstallDTO>> canInstallPage(
      @Valid ProjectBaseQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: PC可安装列表V2");
      return ResultBuilder.success(this.projectReceivingRecordBiz.listCanInstallV2(param, pageNumber, pageSize));
   }

   @ApiOperation("分包app-可安装列表")
   @GetMapping("/list-receiving/sub")
   public ResultVO<PageVO<ProjectSubAppReceivingDTO>> subAppListReceiving(
      @RequestParam Integer productType,
      @RequestParam Long projectId,
      Long monomerId,
      Long areaId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 收货安装报表");
      return ResultBuilder.success(this.projectReceivingRecordBiz.listSubAppAbleInstall(productType, projectId, monomerId, areaId, pageNumber, pageSize));
   }

   @ApiOperation("分包app-可安装列表V2")
   @GetMapping("/list-receiving/subV2")
   public ResultVO<PageVO<ProjectSubAppReceivingDTO>> listSubAppAbleInstallV2(
      @RequestParam Integer productType,
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 可安装列表V2");
      return ResultBuilder.success(
         this.projectReceivingRecordBiz.listSubAppAbleInstallV2(productType, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("PC端安装填报")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('handle_install:add')")
   public ResultVO saveInstallReport(@RequestBody @Valid ProjectInstallReportSaveDTOParam param) {
      log.info("Api调用: PC端安装填报");
      return ResultBuilder.success(this.installReportBiz.saveInstallReport(param));
   }

   @ApiOperation("PC端安装填报v2")
   @PostMapping("/saveV2")
   @SignerCheck(lockKey = "#param.projectId")
   public ResultVO saveInstallReportV2(@RequestBody @Valid ProjectInstallReportSaveDTOParam param) {
      log.info("Api调用: PC端安装填报");
      return ResultBuilder.success(this.installReportBiz.saveInstallReportV2(param));
   }

   @ApiOperation("app端安装填报")
   @PostMapping("/save/app")
   public ResultVO saveInstallReportApp(@RequestBody @Valid ProjectInstallReportSaveDTOParam param) {
      log.info("Api调用: app端安装填报");
      return ResultBuilder.success(this.installReportBiz.saveAppInstallReport(param));
   }

   @ApiOperation("app端安装填报V2")
   @PostMapping("/save/appV2")
   @SignerCheck(lockKey = "#param.projectId")
   public ResultVO saveInstallReportAppV2(@RequestBody @Valid ProjectInstallReportSaveDTOParam param) {
      log.info("Api调用: app端安装填报");
      return ResultBuilder.success(this.installReportBiz.saveAppInstallReportV2(param));
   }

   @ApiOperation("pc端-安装填报分组列表(安装审核列表)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "yearMonth", value = "年月 2022-08", paramType = "query"),
            @ApiImplicitParam(name = "yearMonthDay", value = "年月日 2022/08/25", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('install_audit:get')")
   @GetMapping("/list-group")
   public ResultVO<ListVO<ProjectInstallReportGroupDTO>> listInstallReportGroup(@RequestParam Long projectId, Integer productType, String yearMonth) {
      log.info("Api调用: 安装填报分组列表");
      return ResultBuilder.success(new ListVO<>(this.installReportBiz.listInstallReportGroup(projectId, productType, yearMonth)));
   }

   @ApiOperation("app端-未审核列表")
   @ApiImplicitParam(name = "productType", value = "产品类型 (建钢项目)2构件 4围护 8配套件 (桥梁项目 1分段件 2单元件 4零件 8配套件)")
   @GetMapping("/list-group/app")
   public ResultVO<ListVO<ProjectAppInstallReportGroupDTO>> listAppInstallReportGroup(Long projectId, Integer productType) {
      log.info("Api调用: 未审核安装填报列表");
      return ResultBuilder.success(new ListVO<>(this.installReportBiz.listAppInstallReportGroup(projectId, productType)));
   }

   @ApiOperation("安装填报列表")
   @GetMapping("/list-report")
   @PreAuthorize("@permission.check('install_audit:detail','siteInstallAudit')")
   public ResultVO<PageVO<ProjectInstallReportDTO>> listInstallReport(
      @Valid InstallReportQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 安装填报列表");
      return ResultBuilder.success(this.installReportBiz.pageListInstallReport(param, pageNumber, pageSize));
   }

   @ApiOperation("PC可审核列表")
   @GetMapping("/pcCanExamine/page")
   public ResultVO<PageVO<ProjectInstallReportDTO>> pageListInstallReportV2(
      @Valid InstallReportQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: PC可审核列表");
      return ResultBuilder.success(this.installReportBiz.pageListInstallReportV2(param, pageNumber, pageSize));
   }

   @ApiOperation("安装填报列表")
   @GetMapping("/list-report/app/record")
   public ResultVO<PageVO<ProjectInstallReportDTO>> listInstallReportAppRecord(
      @Valid InstallReportQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 安装填报列表");
      return ResultBuilder.success(this.installReportBiz.pageListInstallReport(param, pageNumber, pageSize));
   }

   @ApiOperation("app安装填报列表 不分页")
   @GetMapping("/list-report/app")
   public ResultVO<ListVO<ProjectInstallReportDTO>> appListInstallReport(@Valid InstallReportQueryDTOParam param) {
      log.info("Api调用: 安装填报列表");
      return ResultBuilder.success(new ListVO<>(this.installReportBiz.listInstallReport(param)));
   }

   @ApiOperation("审核安装填报")
   @PostMapping("/check")
   @PreAuthorize("@permission.check('install_audit:audit')")
   public ResultVO checkInstallReport(@RequestBody @Valid List<CheckInstallReportDTOParam> paramList) {
      log.info("Api调用: 审核填报");
      return ResultBuilder.success(this.installReportBiz.checkInstallReport(paramList));
   }

   @ApiOperation("审核安装填报V2")
   @PostMapping("/checkV2")
   @SignerCheck(lockKey = "#projectId")
   public ResultVO checkInstallReportV2(@RequestBody @Valid List<CheckInstallReportDTOParam> paramList, @RequestParam Long projectId) {
      log.info("Api调用: 审核填报");
      return ResultBuilder.success(this.installReportBiz.checkInstallReportV2(paramList, projectId));
   }

   @ApiOperation("app-审核安装填报")
   @PostMapping("/check/app")
   @PreAuthorize("@permission.check('siteInstallAudit')")
   public ResultVO appCheckInstallReport(@RequestBody @Valid List<AppCheckInstallReportDTOParam> paramList) {
      log.info("Api调用: app-审核填报");
      return ResultBuilder.success(this.installReportBiz.checkAppReport(paramList));
   }

   @ApiOperation("审核安装填报")
   @PostMapping("/check/appV2")
   @PreAuthorize("@permission.check('installation_audit:batchPass','installation_audit:batchReject')"
      + " and (#paramList == null or ((#paramList.?[auditStatus == 2].isEmpty() or @permission.check('installation_audit:batchPass'))"
      + " and (#paramList.?[auditStatus == 4].isEmpty() or @permission.check('installation_audit:batchReject'))))")
   @SignerCheck(lockKey = "#projectId")
   public ResultVO appCheckInstallReportV2(@RequestBody @Valid List<AppCheckInstallReportDTOParam> paramList, @RequestParam Long projectId) {
      log.info("Api调用: app-审核填报");
      return ResultBuilder.success(this.installReportBiz.checkAppReportV2(paramList, projectId));
   }

   @ApiOperation("安装报表")
   @GetMapping("/install-statement")
   @PreAuthorize("@permission.check('install_report_list:get')")
   public ResultVO<PageVO<ProjectInstallSummaryDTO>> listInstallStatement(
      InstallStatementQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看安装报表");
      return ResultBuilder.success(this.installReportBiz.pageListInstallStatement(param, pageNumber, pageSize));
   }

   @ApiOperation("打印安装报表")
   @GetMapping("/install-statement/print")
   @PreAuthorize("@permission.check('install_report_list:print')")
   public ResultVO printListInstallStatement(InstallStatementQueryDTOParam param) {
      log.info("Api调用: 打印安装报表");
      return ResultBuilder.success(this.installReportBiz.printListInstallStatement(param));
   }

   @ApiOperation("安装看板列表")
   @GetMapping("/install-board")
   public ResultVO<PageVO<ProjectInstallBoardDTO>> listInstallBoard(
      @Valid InstallBoardQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看安装看板");
      return ResultBuilder.success(this.installReportBiz.listInstallBoard(param, pageNumber, pageSize));
   }

   @ApiOperation("安装看板列表")
   @GetMapping("/install-boardV2")
   public ResultVO<PageVO<ProjectInstallBoardDTO>> listInstallBoardV2(
      @Valid InstallBoardQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看安装看板");
      return ResultBuilder.success(this.installReportBiz.listInstallBoardV2(param, pageNumber, pageSize));
   }

   @ApiOperation("安装看板详情")
   @GetMapping("/install-board/details")
   public ResultVO installBoardDetails(
      @RequestParam Integer productType,
      @RequestParam Long productId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 安装看板详情");
      return ResultBuilder.success(this.installReportBiz.installBoardDetails(productType, productId, pageNumber, pageSize));
   }

   @ApiOperation("分包商安装信息汇总")
   @GetMapping("/supplierInstall/Summary")
   public ResultVO getSupplierInstallArtifactSummary(@RequestParam Long projectId) {
      log.info("Api调用: 项目下各分包商安装信息汇总");
      return ResultBuilder.success(this.installReportBiz.getSupplierInstallSummary(projectId));
   }

   @ApiOperation("分包商安装信息详情")
   @GetMapping("/supplierInstall/Details")
   public ResultVO getSupplierInstallDetails(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long supplierId,
      @RequestParam Integer productType,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 分包商安装信息详情");
      return ResultBuilder.success(
         this.installReportBiz.getSupplierInstallDetails(projectId, supplierId, productType, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("分包商安装信息详情打印")
   @GetMapping("/supplierInstall/Details/print")
   public ResultVO getSupplierInstallDetails(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long supplierId,
      @RequestParam Integer productType,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate
   ) {
      log.info("Api调用: 分包商安装信息详情打印");
      return ResultBuilder.success(this.installReportBiz.getSupplierInstallDetailsPrint(projectId, supplierId, productType, startDate, endDate));
   }

   @ApiOperation("项目安装信息汇总")
   @GetMapping("/projectInstall/Summary")
   public ResultVO getProjectInstallSummary(@RequestParam Long projectId, @RequestParam Integer productType) {
      log.info("Api调用: 项目安装信息汇总");
      return ResultBuilder.success(this.installReportBiz.getProjectInstallSummary(projectId, productType));
   }

   @ApiOperation("项目安装信息详情")
   @GetMapping("/projectInstall/Details")
   public ResultVO getSupplierInstallDetails(
      @RequestParam Long projectId,
      @RequestParam Integer productType,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("Api调用: 项目安装信息详情");
      return ResultBuilder.success(this.installReportBiz.getProjectInstallDetails(projectId, productType, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("项目安装信息详情打印")
   @GetMapping("/projectInstall/Details/print")
   public ResultVO getSupplierInstallDetails(
      @RequestParam Long projectId,
      @RequestParam Integer productType,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate
   ) {
      log.info("Api调用: 项目安装信息详情打印");
      return ResultBuilder.success(this.installReportBiz.getProjectInstallDetailsPrint(projectId, productType, startDate, endDate));
   }
}
