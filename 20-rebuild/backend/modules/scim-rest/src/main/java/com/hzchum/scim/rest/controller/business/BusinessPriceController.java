package com.hzchum.scim.rest.controller.business;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessPriceBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPrice;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessBriceProductDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceDetailDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceProjectDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceSummaryInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceAddParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceCheckParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceProductQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceUpdateParam;
import com.hzchum.scim.business.core.api.service.BusinessPriceService;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "销售管理-产品计价")
@RequestMapping("/api/business/pricing")
@RestController
public class BusinessPriceController {
   private static final Logger log = LoggerFactory.getLogger(BusinessPriceController.class);
   private final BusinessPriceBiz businessPriceBiz;
   @Resource private BusinessPriceService priceRecords;
   @Resource private ContractProjectService projects;
   @Resource private ProjectBranchCompanyLinkService projectBranches;
   @Resource private ProjectUserLinkService projectUsers;

   private void checkPriceReadScope(Long id) {
      BusinessPrice price = priceRecords.getById(id);
      Preconditions.checkArgument(price != null, "计价记录不存在!");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null && projects.getById(price.getProjectId()) != null, "无权限访问");
      org.springframework.web.context.request.RequestAttributes attributes = org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
      if (attributes instanceof org.springframework.web.context.request.ServletRequestAttributes) {
         String branch = ((org.springframework.web.context.request.ServletRequestAttributes) attributes).getRequest().getHeader("financeBranchId");
         if (branch != null) {
            Long branchId = null;
            try { branchId = Long.valueOf(branch); } catch (NumberFormatException invalid) { }
            Preconditions.checkArgument(branchId != null && branchId > 0 && Objects.equals(branchId, price.getBranchCompanyId()), "无权限访问");
         }
      }
      Preconditions.checkArgument(projectBranches.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
         .eq(ProjectBranchCompanyLink::getProjectId, price.getProjectId())
         .eq(ProjectBranchCompanyLink::getBranchCompanyId, price.getBranchCompanyId())) > 0, "无权限访问");
      Preconditions.checkArgument(user.isAdmin() || projectUsers.count(Wrappers.lambdaQuery(ProjectUserLink.class)
         .eq(ProjectUserLink::getProjectId, price.getProjectId()).eq(ProjectUserLink::getUserId, user.getId())) > 0, "无权限访问");
   }

   @ApiOperation("项目列表")
   @GetMapping("/project/list")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:get','sale_unit_list_valuation:create','sale_unit_order_tracking:get')")
   public ResultVO<ListVO<BusinessPriceProjectDTO>> listBusinessProject(
      LocalDateTime dateTime, String name, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用:计价项目列表");
      Preconditions.checkArgument(branchCompanyId != null, "单位信息出现异常!!请刷新页面重试!!");
      return ResultBuilder.success(new ListVO<>(this.businessPriceBiz.listProjectForBusiness(dateTime, name, branchCompanyId)));
   }

   @ApiOperation("项目计价信息")
   @GetMapping("/project/info")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:get','sale_unit_list_valuation:create')")
   public ResultVO<BusinessPriceSummaryInfoDTO> getProjectPriceInfo(
      Long projectId, Integer productType, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用:项目计价信息");
      Preconditions.checkArgument(branchCompanyId != null, "单位信息出现异常!!请刷新页面重试!!");
      return ResultBuilder.success(this.businessPriceBiz.getPriceInfo(projectId, productType, branchCompanyId));
   }

   @ApiOperation("未计价产品-列表")
   @GetMapping("/unPricing/product")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:create')")
   public ResultVO<PageVO<BusinessBriceProductDTO>> pageListUnPricingProduct(
      @Valid BusinessPriceProductQueryParam param,
      @RequestHeader(value = "financeBranchId", required = false) Long financeBranchId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:未计价产品-列表");
      Preconditions.checkArgument(financeBranchId != null, "单位信息出现异常!!请刷新页面重试!!");
      param.setBranchCompanyId(financeBranchId);
      return ResultBuilder.success(this.businessPriceBiz.listUnPricingProduct(param, pageNumber, pageSize));
   }

   @ApiOperation("列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:get')")
   public ResultVO<PageVO<BusinessPriceDTO>> pageListBusinessPrice(
      BusinessPriceQueryParam param,
      @RequestHeader(value = "financeBranchId", required = false) Long financeBranchId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:产品计价记录-列表");
      Preconditions.checkArgument(financeBranchId != null, "单位信息出现异常!!请刷新页面重试!!");
      param.setBranchCompanyId(financeBranchId);
      return ResultBuilder.success(this.businessPriceBiz.pageListBusinessPrice(param, pageNumber, pageSize));
   }

   @ApiOperation("列表-公共接口")
   @GetMapping("/list/public")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:create')")
   public ResultVO<ListVO<BusinessPrice>> listBusinessPrice(@RequestParam Long projectId, @RequestParam Integer productType) {
      log.info("Api调用:产品计价记录-列表(公共接口)");
      List<BusinessPrice> businessPriceList = this.businessPriceBiz
         .list(
            Wrappers.lambdaQuery(BusinessPrice.class)
               .eq(BusinessPrice::getProjectId, projectId)
               .eq(BusinessPrice::getProductType, productType)
               .in(BusinessPrice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(BusinessPrice::getId)
         );
      return ResultBuilder.success(new ListVO<>(businessPriceList));
   }

   @ApiOperation("详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:get')")
   public ResultVO<PageVO<BusinessPriceDetailDTO>> listBusinessPriceDetail(
      @RequestParam Long id, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:计价产品详情列表");
      checkPriceReadScope(id);
      return ResultBuilder.success(this.businessPriceBiz.listBusinessPriceDetail(id, pageNumber, pageSize));
   }

   @ApiOperation("详情-打印")
   @GetMapping("/detail/print")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:print')")
   public ResultVO<PrintVO<List<BusinessPriceDetailDTO>>> printBusinessPriceDetail(@RequestParam Long id) {
      log.info("Api调用:计价产品详情-打印");
      checkPriceReadScope(id);
      return ResultBuilder.success(this.businessPriceBiz.printBusinessPriceDetail(id));
   }

   @ApiOperation("新增")
   @PostMapping("/add")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:create')")
   public ResultVO<Boolean> addBusinessPrice(
      @RequestBody @Valid BusinessPriceAddParam param, @RequestHeader(value = "financeBranchId", required = false) Long financeBranchId
   ) {
      log.info("Api调用:新增产品计价");
      Preconditions.checkArgument(financeBranchId != null, "单位信息出现异常!!请刷新页面重试!!");
      param.setBranchCompanyId(financeBranchId);
      return ResultBuilder.success(this.businessPriceBiz.addBusinessPrice(param));
   }

   @ApiOperation("审核")
   @PutMapping("/check")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:audit')")
   public ResultVO<Boolean> checkBusinessPrice(@RequestBody @Valid BusinessPriceCheckParam param) {
      log.info("Api调用:审核产品计价");
      return ResultBuilder.success(this.businessPriceBiz.checkBusinessPrice(param));
   }

   @ApiOperation("修改")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:edit')")
   public ResultVO<Boolean> updateBusinessPrice(@RequestBody @Valid BusinessPriceUpdateParam param) {
      log.info("Api调用:修改产品计价");
      return ResultBuilder.success(this.businessPriceBiz.updateBusinessPrice(param));
   }

   @ApiOperation("删除")
   @DeleteMapping("/removeById/{id}")
   @PreAuthorize("@permission.check('sale_unit_list_valuation:del')")
   public ResultVO<Boolean> removeBusinessPrice(@PathVariable Long id) {
      log.info("Api调用:删除产品计价");
      return ResultBuilder.success(this.businessPriceBiz.removeBusinessPrice(Collections.singletonList(id)));
   }

   public BusinessPriceController(final BusinessPriceBiz businessPriceBiz) {
      this.businessPriceBiz = businessPriceBiz;
   }
}
