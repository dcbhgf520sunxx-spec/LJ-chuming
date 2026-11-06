package com.hzchum.scim.project.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.contract.core.api.enums.DivideMethodEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.project.core.api.biz.ProjectLaborSubsupplierOrderBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSubcontractManageBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSupplierAccountBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrder;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrderProductLink;
import com.hzchum.scim.project.core.api.pojo.dto.sub.ProjectLaborOrderDTO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.ProjectLaborProductDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.ProjectLaborOrderDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.ProjectLaborProductDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderProductLinkService;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderService;
import com.hzchum.scim.project.core.mapper.ProjectLaborSubsupplierOrderMapper;
import com.hzchum.scim.scm.core.api.enums.SupplierClassEnum;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectLaborSubsupplierOrderBizImpl
   extends IBizImpl<ProjectLaborSubsupplierOrderService, ProjectLaborSubsupplierOrderMapper, ProjectLaborSubsupplierOrder>
   implements ProjectLaborSubsupplierOrderBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ProjectLaborSubsupplierOrderProductLinkService orderProductLinkService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private ProjectSupplierAccountBiz supplierAccountBiz;
   @Resource
   private ProjectSubcontractManageBiz subcontractManageBiz;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;

   @Override
   public PageVO<ProjectLaborProductDTO> getCanSubSupplierProductPage(
      Integer productType, Long areaId, String name, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      Preconditions.checkArgument(
         ProductTypeEnum.ARTIFACT.getType().equals(productType) || ProductTypeEnum.ENCLOSURE.getType().equals(productType), "操作失败！不支持的产品类型！"
      );
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectLaborProductDTO> canSubSupplierProductList = this.baseMapper.getCanSubSupplierProductList(productType, areaId, name, serialNumber);
      canSubSupplierProductList.forEach(
         product -> {
            if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
               product.setMeasureUnit("张");
               product.setAccountingUnit("m");
               BigDecimal thickness = product.getThickness() != null ? product.getThickness() : BigDecimal.ZERO;
               BigDecimal weight = product.getUnfoldedWidth() != null ? product.getUnfoldedWidth() : BigDecimal.ZERO;
               BigDecimal length = product.getLength() != null ? product.getLength() : BigDecimal.ZERO;
               product.setSpecification(
                  thickness.stripTrailingZeros().toPlainString()
                     + "*"
                     + weight.stripTrailingZeros().toPlainString()
                     + "*"
                     + length.stripTrailingZeros().toPlainString()
               );
            } else {
               product.setMeasureUnit("件");
               product.setAccountingUnit("kg");
            }
         }
      );
      return new PageVO<>(page, canSubSupplierProductList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean saveSupplierOrder(ProjectLaborOrderDTOParam dtoParam) {
      Preconditions.checkArgument(
         ProductTypeEnum.ARTIFACT.getType().equals(dtoParam.getProductType()) || ProductTypeEnum.ENCLOSURE.getType().equals(dtoParam.getProductType()),
         "操作失败！不支持的产品类型！"
      );
      ContractProject project = this.projectService.checkProjectStatus(dtoParam.getProjectId());
      Supplier supplier = this.supplierService.getById(dtoParam.getSupplierId());
      List<ProjectLaborProductDTOParam> productParamList = dtoParam.getProductParamList();
      List<ProjectLaborProductDTO> canSubProductList = this.baseMapper
         .getCanSubSupplierProductList(dtoParam.getProductType(), dtoParam.getAreaId(), null, null);
      Map<Long, ProjectLaborProductDTO> canSubProductMap = canSubProductList.stream()
         .collect(Collectors.toMap(ProjectLaborProductDTO::getId, Function.identity()));
      this.checkDTOParam(dtoParam, project, supplier, productParamList, canSubProductMap);
      ProjectLaborSubsupplierOrder subSupplierOrder = this.baseService
         .getOne(
            Wrappers.lambdaQuery(ProjectLaborSubsupplierOrder.class)
               .eq(ProjectLaborSubsupplierOrder::getSupplierId, dtoParam.getSupplierId())
               .eq(ProjectLaborSubsupplierOrder::getProductType, dtoParam.getProductType())
               .eq(ProjectLaborSubsupplierOrder::getProjectId, dtoParam.getProjectId())
         );
      if (subSupplierOrder == null) {
         ProjectLaborSubsupplierOrder laborSaveOrder = BeanUtil.copy(dtoParam, ProjectLaborSubsupplierOrder.class);
         Integer sum = this.baseMapper.getProjectOrderCount(dtoParam.getProjectId());
         String number = LocalDate.now() + "-" + NumberUtil.getDigitsNumber(sum + 1, 2);
         laborSaveOrder.setSerialNumber(number);
         laborSaveOrder.setUserId(UserUtil.getCurrentUserId());
         laborSaveOrder.setUserName(UserUtil.getCurrentName());
         this.baseService.save(laborSaveOrder);
         subSupplierOrder = laborSaveOrder;
      }

      List<ProjectLaborSubsupplierOrderProductLink> productLinkList = this.orderProductLinkService
         .list(
            Wrappers.lambdaQuery(ProjectLaborSubsupplierOrderProductLink.class)
               .eq(ProjectLaborSubsupplierOrderProductLink::getSupplierOrderId, subSupplierOrder.getId())
         );
      Map<Long, ProjectLaborSubsupplierOrderProductLink> productLinkMap = productLinkList.stream()
         .collect(Collectors.toMap(ProjectLaborSubsupplierOrderProductLink::getProductId, Function.identity()));
      ArrayList<ProjectLaborSubsupplierOrderProductLink> saveOrUpdateList = new ArrayList<>();
      ProjectLaborSubsupplierOrder finalSubSupplierOrder = subSupplierOrder;
      productParamList.forEach(
         param -> {
            ProjectLaborProductDTO productDTO = canSubProductMap.get(param.getProductId());
            if (!productLinkMap.containsKey(param.getProductId())) {
               ProjectLaborSubsupplierOrderProductLink saveProductLink = BeanUtil.copy(productDTO, ProjectLaborSubsupplierOrderProductLink.class);
               saveProductLink.setProjectId(project.getId());
               saveProductLink.setProjectType(project.getProjectType());
               saveProductLink.setSupplierOrderId(finalSubSupplierOrder.getId());
               saveProductLink.setSupplierId(supplier.getId());
               saveProductLink.setProductType(dtoParam.getProductType());
               saveProductLink.setProductId(param.getProductId());
               saveProductLink.setQuantity(param.getQuantity());
               saveProductLink.setMonomerId(productDTO.getMonomer().getId());
               saveProductLink.setAreaId(productDTO.getArea().getId());
               if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  saveProductLink.setMete(productDTO.getNetWeight().multiply(param.getQuantity()));
                  saveProductLink.setTotalArea(productDTO.getSurfaceArea().multiply(param.getQuantity()));
                  saveProductLink.setMeasureUnit("件");
                  saveProductLink.setAccountingUnit("kg");
               }

               if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  saveProductLink.setWidth(productDTO.getUnfoldedWidth());
                  saveProductLink.setMete(productDTO.getLength().multiply(param.getQuantity()));
                  saveProductLink.setTotalArea(productDTO.getUnfoldedWidth().multiply(productDTO.getLength()).multiply(param.getQuantity()));
                  saveProductLink.setSpecification(
                     productDTO.getThickness() != null
                        ? productDTO.getThickness().setScale(2, RoundingMode.HALF_UP)
                           + "*"
                           + productDTO.getUnfoldedWidth().intValue()
                           + "*"
                           + productDTO.getLength().intValue()
                        : productDTO.getUnfoldedWidth().intValue() + "*" + productDTO.getLength().intValue()
                  );
                  saveProductLink.setAccountingUnit("m");
               }

               saveOrUpdateList.add(saveProductLink);
            } else {
               ProjectLaborSubsupplierOrderProductLink updateProductLink = productLinkMap.get(param.getProductId());
               updateProductLink.setQuantity(updateProductLink.getQuantity().add(param.getQuantity()));
               Preconditions.checkArgument(
                  dtoParam.getSupplierId().equals(updateProductLink.getSupplierId()),
                  "操作失败！该产品已划分给" + this.supplierService.getById(updateProductLink.getSupplierId()).getName()
               );
               if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  updateProductLink.setMete(productDTO.getNetWeight().multiply(updateProductLink.getQuantity()));
                  updateProductLink.setTotalArea(productDTO.getSurfaceArea().multiply(updateProductLink.getQuantity()));
               }

               if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  updateProductLink.setMete(productDTO.getLength().multiply(updateProductLink.getQuantity()));
                  updateProductLink.setTotalArea(
                     productDTO.getUnfoldedWidth().multiply(updateProductLink.getLength()).multiply(updateProductLink.getQuantity())
                  );
               }

               saveOrUpdateList.add(updateProductLink);
            }
         }
      );
      this.orderProductLinkService.saveOrUpdateBatch(saveOrUpdateList);
      return true;
   }

   private void checkDTOParam(
      ProjectLaborOrderDTOParam dtoParam,
      ContractProject project,
      Supplier supplier,
      List<ProjectLaborProductDTOParam> productParamList,
      Map<Long, ProjectLaborProductDTO> canSubProductMap
   ) {
      PlanArea area = this.planAreaService.getById(dtoParam.getAreaId());
      Preconditions.checkArgument(area != null, "操作失败！区域/批次信息不存在！");
      Preconditions.checkArgument(dtoParam.getProjectId().equals(area.getProjectId()), "操作失败！参数信息有误！");
      List<SupplierInfo> supplierInfoList = this.subcontractManageBiz.getInstallOrderSupplierInfoList(project.getId());
      Preconditions.checkArgument(DivideMethodEnum.LIST.getType().equals(project.getInstallDivideMethod()), "操作失败！该项目分包划分方式不是清单划分！");
      Preconditions.checkArgument(supplier != null, "操作失败！供应商不存在!!!");
      Preconditions.checkArgument(
         (SupplierClassEnum.LABOR_SUB.getType() & supplier.getSupplierClassification()) > 0
            || (SupplierClassEnum.PRO_SUB.getType() & supplier.getSupplierClassification()) > 0,
         "操作失败！分包商类型不正确！"
      );
      Preconditions.checkArgument(supplierInfoList.stream().map(SupplierInfo::getSupplierId).anyMatch(e -> e.equals(supplier.getId())), "操作失败！供应商不存在劳务合同！");
      Preconditions.checkArgument(
         productParamList.stream().map(ProjectLaborProductDTOParam::getProductId).distinct().count() == productParamList.size(), "操作失败！产品id重复！"
      );
      Preconditions.checkArgument(productParamList.stream().allMatch(param -> {
         ProjectLaborProductDTO canSubProduct = canSubProductMap.get(param.getProductId());
         return canSubProduct != null && param.getQuantity().compareTo(canSubProduct.getQuantity()) <= 0;
      }), "操作失败！产品可划分数量不足！请刷新重试！");
   }

   @Override
   public List<ProjectLaborOrderDTO> getLaborOrderList(Long projectId) {
      return this.baseMapper.getLaborOrderList(projectId);
   }

   @Override
   public PageVO<ProjectLaborProductDTO> getLaborOrderDetailsPage(
      Long projectId, Long orderId, String name, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectLaborProductDTO> productDTOList = this.getProjectLaborProductDTOList(projectId, orderId, name, serialNumber);
      return new PageVO<>(page, productDTOList);
   }

   private List<ProjectLaborProductDTO> getProjectLaborProductDTOList(Long projectId, Long orderId, String name, String serialNumber) {
      List<ProjectLaborSubsupplierOrderProductLink> detailsList = this.orderProductLinkService
         .list(
            Wrappers.lambdaQuery(ProjectLaborSubsupplierOrderProductLink.class)
               .eq(ProjectLaborSubsupplierOrderProductLink::getProjectId, projectId)
               .eq(orderId != null, ProjectLaborSubsupplierOrderProductLink::getSupplierOrderId, orderId)
               .like(StringUtils.isNotBlank(name), ProjectLaborSubsupplierOrderProductLink::getName, name)
               .like(StringUtils.isNotBlank(serialNumber), ProjectLaborSubsupplierOrderProductLink::getSerialNumber, name)
         );
      if (CollectionUtils.isEmpty(detailsList)) {
         return new ArrayList<>();
      }

      List<Long> monomerIds = detailsList.stream().map(ProjectLaborSubsupplierOrderProductLink::getMonomerId).distinct().collect(Collectors.toList());
      List<Long> areaId = detailsList.stream().map(ProjectLaborSubsupplierOrderProductLink::getAreaId).distinct().collect(Collectors.toList());
      Map<Long, PlanMonomer> monomerMap = this.monomerService.listByIds(monomerIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Map<Long, PlanArea> areaMap = this.areaService.listByIds(areaId).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      return detailsList.stream().map(e -> {
         ProjectLaborProductDTO productDTO = BeanUtil.copy(e, ProjectLaborProductDTO.class);
         if (ProductTypeEnum.ARTIFACT.getType().equals(e.getProductType())) {
            PlanMonomer planMonomer = monomerMap.get(e.getMonomerId());
            PlanArea planArea = areaMap.get(e.getAreaId());
            productDTO.setMonomer(NameInfo.builder().id(planMonomer.getId()).name(planMonomer.getName()).build());
            productDTO.setArea(NameInfo.builder().id(planArea.getId()).name(planArea.getName()).build());
            productDTO.setTotalNetWeight(e.getQuantity().multiply(e.getNetWeight()));
         }

         if (ProductTypeEnum.ENCLOSURE.getType().equals(e.getProductType())) {
            PlanMonomer planMonomer = monomerMap.get(e.getMonomerId());
            PlanArea planArea = areaMap.get(e.getAreaId());
            productDTO.setMonomer(NameInfo.builder().id(planMonomer.getId()).name(planMonomer.getName()).build());
            productDTO.setArea(NameInfo.builder().id(planArea.getId()).name(planArea.getName()).build());
         }

         return productDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getLaborOrderDetailsPrint(Long projectId, Long orderId, String name, String serialNumber) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ProjectLaborProductDTO> list = this.getProjectLaborProductDTOList(projectId, orderId, name, serialNumber);
      List<Map<String, Object>> mapList = list.stream().map(cn.hutool.core.bean.BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo project = this.projectService.getSimpleById(projectId);
      header.put("project", project);
      header.put("totalQuantity", 0);
      header.put("totalWeight", 0);
      if (CollUtil.isNotEmpty(list)) {
         BigDecimal totalQuantity = list.stream().map(ProjectLaborProductDTO::getQuantity).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalQuantity", totalQuantity);
         BigDecimal totalWeight = list.stream()
            .map(ProjectLaborProductDTO::getTotalNetWeight)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalWeight", totalWeight);
      }

      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional
   @Override
   public boolean delete(List<Long> ids) {
      List<ProjectLaborSubsupplierOrderProductLink> productLinkList = this.orderProductLinkService.listByIds(ids);
      Preconditions.checkArgument(ids.size() == productLinkList.size(), "操作失败！产品已删除请刷新重试！");
      Preconditions.checkArgument(
         productLinkList.stream().allMatch(productLink -> productLink.getActualQuantity().compareTo(BigDecimal.ZERO) == 0), "操作失败！所选产品已开始安装！"
      );
      this.orderProductLinkService.removeByIds(ids);
      return true;
   }
}
