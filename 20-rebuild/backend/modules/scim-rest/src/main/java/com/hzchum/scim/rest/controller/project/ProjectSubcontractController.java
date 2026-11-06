package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectInstallDivideMethodDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.project.core.api.biz.ProjectLaborSubsupplierOrderBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSubcontractManageBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectProductInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSupplierAccountDTO;
import com.hzchum.scim.project.core.api.pojo.dto.plan.ProjectMonomerDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectInstallPlanDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.ProjectLaborOrderDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-分包管理")
@RestController
@RequestMapping("/api/project/install-plan")
public class ProjectSubcontractController {
   private static final Logger log = LoggerFactory.getLogger(ProjectSubcontractController.class);
   @Resource
   private ProjectSubcontractManageBiz subcontractManageBiz;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ProjectLaborSubsupplierOrderBiz laborSubsupplierOrderBiz;

   @ApiOperation("安装计划表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
      }
   )
   @GetMapping("/list")
   @PreAuthorize("@permission.check('subcontract_plan:get')")
   public ResultVO<ListVO<ProjectMonomerDTO>> listInstallPlan(@RequestParam Long projectId, Long monomerId) {
      log.info("Api调用: 查看项目的安装工期制定表");
      return ResultBuilder.success(this.subcontractManageBiz.listInstallPlan(projectId, monomerId));
   }

   @GetMapping("/listV2")
   @ApiOperation("安装计划表V2")
   public ResultVO listInstallPlanV2(@RequestParam Long projectId, @RequestParam(required = false) Long monomerId) {
      log.info("Api调用: 查看项目的安装工期制定表");
      return ResultBuilder.success(this.subcontractManageBiz.listInstallPlanV4(projectId, monomerId));
   }

   @ApiOperation("设置劳务分包供应商和安装计划")
   @PostMapping("/setSupplier")
   public ResultVO setInstallPlan(@RequestBody @Valid ProjectInstallPlanDTOParam param) {
      log.info("Api调用: 设置劳务分包供应商和修改安装计划");
      return ResultBuilder.success(this.subcontractManageBiz.setInstallPlan(param));
   }

   @ApiOperation("设置劳务分包供应商和安装计划V2")
   @PostMapping("/setSupplierV2")
   public ResultVO setInstallPlanV2(@RequestBody @Valid ProjectInstallPlanDTOParam param) {
      log.info("Api调用: 设置劳务分包供应商和修改安装计划");
      return ResultBuilder.success(this.subcontractManageBiz.setInstallPlanV2(param));
   }

   @ApiOperation("分包供应商账号列表")
   @GetMapping("/listSupplier")
   @PreAuthorize("@permission.check('subcontract_plan:account','subcontract_progress:get','siteQhse')")
   public ResultVO<ListVO<ProjectSupplierAccountDTO>> listInstallSupplier(@RequestParam Long projectId, Long monomerId) {
      log.info("Api调用: 分包供应商账号列表");
      return ResultBuilder.success(new ListVO<>(this.subcontractManageBiz.listInstallSupplier(projectId, monomerId)));
   }

   @ApiOperation("分包商-安装产品统计表")
   @GetMapping("/list-supplier-install-product-sum")
   @PreAuthorize("@permission.check('subcontract_progress:detail')")
   public ResultVO<ListVO<ProjectProductInstallSummaryDTO>> listSupplierProductSummary(
      @RequestParam Long projectId, Long monomerId, Integer monomerDetailType, Long areaId, @RequestParam Long supplierId
   ) {
      log.info("Api调用: 分包商安装产品列表");
      return ResultBuilder.success(
         new ListVO<>(this.subcontractManageBiz.listProductInstallSummary(projectId, monomerId, monomerDetailType, areaId, supplierId))
      );
   }

   @ApiOperation("获取签订分包订单的分包商")
   @GetMapping("/getInstallSupplier/list")
   public ResultVO getInstallSupplier(@RequestParam Long projectId) {
      log.info("Api调用: 获取签订分包订单的分包商");
      return ResultBuilder.success(this.subcontractManageBiz.getInstallOrderSupplierInfoList(projectId));
   }

   @ApiOperation("项目安装内容划分方式配置")
   @PutMapping("/updateDivideMethod")
   @PreAuthorize("@permission.check('install_labor_setting:get')")
   public ResultVO updateInstallDivideMethod(@RequestBody @Valid ProjectInstallDivideMethodDTOParam param) {
      log.info("Api调用: 项目安装内容划分方式配置");
      return ResultBuilder.success(this.projectService.updateInstallDivideMethod(param));
   }

   @ApiOperation("清单可划分产品")
   @GetMapping("/getCanSubSupplierProductPage")
   public ResultVO getCanSubSupplierProductPage(
      @RequestParam @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不正确！") Integer productType,
      @RequestParam Long areaId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:清单可划分产品");
      return ResultBuilder.success(this.laborSubsupplierOrderBiz.getCanSubSupplierProductPage(productType, areaId, name, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("保存清单划分")
   @PostMapping("/subSupplierOrder/save")
   @SignerCheck(lockKey = "#dtoParam.projectId")
   public ResultVO save(@RequestBody @Valid ProjectLaborOrderDTOParam dtoParam) {
      log.info("API调用:保存清单划分");
      return ResultBuilder.success(this.laborSubsupplierOrderBiz.saveSupplierOrder(dtoParam));
   }

   @ApiOperation("清单划分汇总信息")
   @GetMapping("/getLaborOrderList")
   public ResultVO getLaborOrderList(@RequestParam Long projectId) {
      log.info("API调用:清单划分汇总信息");
      return ResultBuilder.success(this.laborSubsupplierOrderBiz.getLaborOrderList(projectId));
   }

   @ApiOperation("清单划分详细信息")
   @GetMapping("/getLaborOrderDetailsPage")
   public ResultVO getLaborOrderDetailsPage(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long orderId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:清单划分详细信息");
      return ResultBuilder.success(this.laborSubsupplierOrderBiz.getLaborOrderDetailsPage(projectId, orderId, name, serialNumber, pageNumber, pageSize));
   }

   @ApiOperation("清单划分详细信息打印")
   @GetMapping("/getLaborOrderDetailsPage/print")
   public ResultVO getLaborOrderDetailsPrint(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long orderId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String serialNumber
   ) {
      log.info("API调用:清单划分详细信息");
      return ResultBuilder.success(this.laborSubsupplierOrderBiz.getLaborOrderDetailsPrint(projectId, orderId, name, serialNumber));
   }

   @ApiOperation("划分详情删除")
   @DeleteMapping("/orderDetailsDelete")
   public ResultVO deleteList(@RequestBody List<Long> ids) {
      log.info("Api调用: 划分详情删除");
      return ResultBuilder.success(this.laborSubsupplierOrderBiz.delete(ids));
   }
}
