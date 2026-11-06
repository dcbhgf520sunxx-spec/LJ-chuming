package com.hzchum.scim.mes.building.core.biz.impl.cargoList;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.enums.TransportTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingSupplierPriceBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPriceCarLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.SupplierPriceCarLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceCarLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveVORequestParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.SupplierPriceUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceCarLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.scm.core.api.enums.SupplierClassEnum;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingSupplierPriceBizImpl implements MesBuildingSupplierPriceBiz {
   @Autowired
   private MesBuildingSupplierPriceService supplierPriceService;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private MesBuildingSupplierPriceCarLinkService carLinkService;
   @Resource
   private MesBuildingCargoListProductLinkService mesBuildingCargoListProductLinkService;
   @Resource
   private TechStandardPartService techStandardPartService;
   @Resource
   private BranchCompanyService branchCompanyService;

   @Override
   public Boolean save(SupplierPriceSaveDTOParam param) {
      if (param.getInvoiceTypeEnum().equals(InvoiceTypeEnum.DEDICATED.getType())) {
         Preconditions.checkArgument(param.getTax() != null, "税率不能为空");
      } else {
         param.setTax(BigDecimal.ZERO);
      }

      this.contractProjectService.checkProjectStatus(param.getProjectId());
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      Supplier supplier = this.supplierService.getById(param.getSupplierId());
      if (!param.getBoolPersonalEnum()) {
         Preconditions.checkArgument(supplier != null, "供应商不存在");
         MesBuildingSupplierPrice one = this.supplierPriceService
            .getOne(
               (Wrapper<MesBuildingSupplierPrice>)(Wrappers.<MesBuildingSupplierPrice>lambdaQuery().eq(MesBuildingSupplierPrice::getProjectId, param.getProjectId()))
                  .eq(MesBuildingSupplierPrice::getSupplierId, param.getSupplierId())
            );
         Preconditions.checkArgument(one == null, "操作失败，该物流公司已设置价格");
         Preconditions.checkArgument(param.getPrice() != null && param.getPriceType() != null, "操作失败,基础价格和计价方式不能为空!!!");
      }

      MesBuildingSupplierPrice supplierPrice = BeanUtil.copy(param, MesBuildingSupplierPrice.class);
      supplierPrice.setUserId(UserUtil.getCurrentUserId());
      supplierPrice.setUserName(UserUtil.getCurrentName());
      if (param.getBoolPersonalEnum()) {
         Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
         MesBuildingSupplierPrice one = this.supplierPriceService
            .getOne(
               (Wrapper<MesBuildingSupplierPrice>)(Wrappers.<MesBuildingSupplierPrice>lambdaQuery().eq(MesBuildingSupplierPrice::getProjectId, param.getProjectId()))
                  .eq(MesBuildingSupplierPrice::getLicensePlate, param.getLicensePlate())
            );
         Preconditions.checkArgument(one == null, "操作失败，该车牌号在该项目中已设置价格");
         SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
         supplierPrice.setPrice(carLinkDTOParam.getPrice());
         supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
         supplierPrice.setSupplierId(null);
         Supplier personalSupplier = this.supplierService
            .getOne(
               (Wrapper<Supplier>)(new LambdaQueryWrapper<Supplier>().eq(Supplier::getName, param.getLicensePlate()))
                  .eq(Supplier::getBoolPersonalEnum, Boolean.TRUE)
            );
         if (personalSupplier == null) {
            personalSupplier = Supplier.builder()
               .name(param.getLicensePlate())
               .boolPersonalEnum(Boolean.TRUE)
               .supplierClassification(SupplierClassEnum.LOGISTICS.getType())
               .build();
            this.supplierService.save(personalSupplier);
         }

         supplierPrice.setSupplierId(personalSupplier.getId());
      }

      this.supplierPriceService.save(supplierPrice);
      if (CollectionUtil.isNotEmpty(param.getLinkList())) {
         param.getLinkList().forEach(e -> {
            MesBuildingSupplierPriceCarLink newSave = BeanUtil.copy(e, MesBuildingSupplierPriceCarLink.class);
            newSave.setProjectId(param.getProjectId());
            newSave.setSupplierPriceId(supplierPrice.getId());
            this.carLinkService.save(newSave);
         });
      }

      return true;
   }

   @Override
   public Boolean update(SupplierPriceUpdateDTOParam param) {
      if (param.getInvoiceTypeEnum().equals(InvoiceTypeEnum.DEDICATED.getType())) {
         Preconditions.checkArgument(param.getTax() != null, "税率不能为空");
      } else {
         param.setTax(BigDecimal.ZERO);
      }

      MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(param.getId());
      Preconditions.checkArgument(supplierPrice != null, "操作失败:id有误");
      this.contractProjectService.checkProjectStatus(param.getProjectId());
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      int count = this.cargoListService
         .count((Wrapper<MesBuildingCargoList>)Wrappers.<MesBuildingCargoList>lambdaQuery().eq(MesBuildingCargoList::getSupplierPriceId, supplierPrice.getId()));
      if (count == 0) {
         if (supplierPrice.getBoolPersonalEnum()) {
            Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
            if (!supplierPrice.getLicensePlate().equals(param.getLicensePlate())) {
               MesBuildingSupplierPrice one = this.supplierPriceService
                  .getOne(
                     (Wrapper<MesBuildingSupplierPrice>)((Wrappers.<MesBuildingSupplierPrice>lambdaQuery()
                              .eq(MesBuildingSupplierPrice::getProjectId, param.getProjectId()))
                           .eq(MesBuildingSupplierPrice::getLicensePlate, param.getLicensePlate()))
                        .ne(MesBuildingSupplierPrice::getId, supplierPrice.getId())
                  );
               Preconditions.checkArgument(one == null, "操作失败，该车牌号在该项目中已设置价格");
            }

            param.setSupplierId(null);
            BeanUtil.copy(param, supplierPrice);
            SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
            supplierPrice.setPrice(carLinkDTOParam.getPrice());
            supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
            Supplier personalSupplier = this.supplierService
               .getOne(
                  (Wrapper<Supplier>)(new LambdaQueryWrapper<Supplier>().eq(Supplier::getName, param.getLicensePlate()))
                     .eq(Supplier::getBoolPersonalEnum, Boolean.TRUE)
               );
            if (personalSupplier == null) {
               personalSupplier = Supplier.builder()
                  .name(param.getLicensePlate())
                  .boolPersonalEnum(Boolean.TRUE)
                  .supplierClassification(SupplierClassEnum.LOGISTICS.getType())
                  .build();
               this.supplierService.save(personalSupplier);
            }

            supplierPrice.setSupplierId(personalSupplier.getId());
         }

         if (!supplierPrice.getBoolPersonalEnum()) {
            if (!supplierPrice.getSupplierId().equals(param.getSupplierId())) {
               MesBuildingSupplierPrice one = this.supplierPriceService
                  .getOne(
                     (Wrapper<MesBuildingSupplierPrice>)((Wrappers.<MesBuildingSupplierPrice>lambdaQuery()
                              .eq(MesBuildingSupplierPrice::getProjectId, param.getProjectId()))
                           .eq(MesBuildingSupplierPrice::getSupplierId, param.getSupplierId()))
                        .ne(MesBuildingSupplierPrice::getId, supplierPrice.getId())
                  );
               Preconditions.checkArgument(one == null, "操作失败，该物流公司已设置价格");
            }

            BeanUtil.copy(param, supplierPrice);
         }
      } else {
         Preconditions.checkArgument(
            supplierPrice.getProjectId().equals(param.getProjectId()) && supplierPrice.getInvoiceTypeEnum().equals(param.getInvoiceTypeEnum()),
            "修改失败，该物流费配置已被使用，只可修改价格信息"
         );
         if (!supplierPrice.getBoolPersonalEnum()) {
            Preconditions.checkArgument(supplierPrice.getSupplierId().equals(param.getSupplierId()), "操作失败,该物流费配置已被使用，只可修改价格信息!");
         }

         supplierPrice.setPrice(param.getPrice());
         supplierPrice.setPriceType(param.getPriceType());
         if (supplierPrice.getBoolPersonalEnum()) {
            Preconditions.checkArgument(param.getSupplierId() == null, "操作失败,个人承运不可设置物流单位!");
            Preconditions.checkArgument(supplierPrice.getLicensePlate().equals(param.getLicensePlate()), "修改失败，该个人车牌已被使用，只可修改价格信息");
            Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
            SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
            supplierPrice.setPrice(carLinkDTOParam.getPrice());
            supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
         }
      }

      this.supplierPriceService.updateById(supplierPrice);
      this.carLinkService
         .remove(
            (Wrapper<MesBuildingSupplierPriceCarLink>)Wrappers.<MesBuildingSupplierPriceCarLink>lambdaQuery().eq(MesBuildingSupplierPriceCarLink::getSupplierPriceId, supplierPrice.getId())
         );
      if (CollectionUtil.isNotEmpty(param.getLinkList())) {
         param.getLinkList().forEach(e -> {
            MesBuildingSupplierPriceCarLink newSave = BeanUtil.copy(e, MesBuildingSupplierPriceCarLink.class);
            newSave.setProjectId(param.getProjectId());
            newSave.setSupplierPriceId(supplierPrice.getId());
            this.carLinkService.save(newSave);
         });
      }

      return true;
   }

   @Override
   public boolean deleteById(Long id) {
      MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(id);
      Preconditions.checkArgument(supplierPrice != null, "物流单位价格不存在");
      this.contractProjectService.checkProjectStatus(supplierPrice.getProjectId());
      this.projectUserLinkService.checkProjectUser(supplierPrice.getProjectId());
      int count = this.cargoListService
         .count((Wrapper<MesBuildingCargoList>)Wrappers.<MesBuildingCargoList>lambdaQuery().eq(MesBuildingCargoList::getSupplierPriceId, supplierPrice.getId()));
      Preconditions.checkArgument(count == 0, "物流单位价格使用中，无法删除");
      this.supplierPriceService.removeById(supplierPrice.getId());
      this.carLinkService.remove((Wrapper<MesBuildingSupplierPriceCarLink>)Wrappers.<MesBuildingSupplierPriceCarLink>lambdaQuery().eq(MesBuildingSupplierPriceCarLink::getSupplierPriceId, id));
      return true;
   }

   @Override
   public Map<String, Object> getInfo(Long projectId, String licensePlate, Long cargoListId) {
      Map<String, Object> result = new HashMap<>();
      if (StringUtils.isNotBlank(licensePlate)) {
         MesBuildingSupplierPrice supplierPrice = this.supplierPriceService
            .getOne(
               (Wrapper<MesBuildingSupplierPrice>)((new LambdaQueryWrapper<MesBuildingSupplierPrice>()
                        .eq(MesBuildingSupplierPrice::getProjectId, projectId))
                     .eq(MesBuildingSupplierPrice::getLicensePlate, licensePlate))
                  .eq(MesBuildingSupplierPrice::getBoolPersonalEnum, Boolean.TRUE)
            );
         if (supplierPrice == null) {
            licensePlate = null;
         }

         if (supplierPrice != null) {
            MesBuildingSupplierPriceCarLink carLink = this.carLinkService
               .getOne(
                  (Wrapper<MesBuildingSupplierPriceCarLink>)(new LambdaQueryWrapper<MesBuildingSupplierPriceCarLink>()
                        .eq(MesBuildingSupplierPriceCarLink::getProjectId, projectId))
                     .eq(MesBuildingSupplierPriceCarLink::getSupplierPriceId, supplierPrice.getId())
               );
            Preconditions.checkArgument(carLink != null, "车型不存在!!!");
            result.put("carModel", carLink.getCarModel());
         }

         result.put("boolPersonalEnum", supplierPrice != null);
      }

      ContractProject project = this.contractProjectService.getById(projectId);
      List<SupplierPriceDO> supplierPrices = this.supplierPriceService.listByCondition(projectId, null, null, licensePlate);
      if (licensePlate == null && CollectionUtil.isNotEmpty(supplierPrices)) {
         supplierPrices = supplierPrices.stream().filter(e -> e.getBoolPersonalEnum().equals(false)).collect(Collectors.toList());
      }

      Integer transportMode = project.getTransportMode();
      if (cargoListId != null) {
         MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
         Preconditions.checkArgument(cargoList != null, "发运记录不存在!!!");
         Preconditions.checkArgument(cargoList.getTransportMode() != null || cargoList.getEnclosureTransportMode() != null, "运输方式不能为空！！！");
         if ((cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0 && (cargoList.getProductType() & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
            Preconditions.checkArgument(
               cargoList.getTransportMode() != null
                  && cargoList.getEnclosureTransportMode() != null
                  && cargoList.getTransportMode().equals(cargoList.getEnclosureTransportMode()),
               "围护和构件同时发运时,运输方式不能不同!!"
            );
         } else if ((cargoList.getProductType() & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
            transportMode = project.getEnclosureTransportMode();
         } else if (cargoList.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            List<MesBuildingCargoListProductLink> productLinks = this.mesBuildingCargoListProductLinkService
               .list((Wrapper<MesBuildingCargoListProductLink>)new LambdaQueryWrapper<MesBuildingCargoListProductLink>().eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()));
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(productLinks), "配套件装车记录不存在!!!");
            List<TechStandardPart> techStandardParts = this.techStandardPartService
               .listByIds(productLinks.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toList()));
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(techStandardParts), "配套件装车记录不存在!!!");
            List<Integer> relationTypeList = techStandardParts.stream().map(TechStandardPart::getRelationType).distinct().collect(Collectors.toList());
            if (relationTypeList.size() <= 1
               || !TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(project.getTransportMode())
                  && !TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(project.getEnclosureTransportMode())) {
               if (relationTypeList.get(0).equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  transportMode = project.getEnclosureTransportMode();
               }
            } else {
               transportMode = TransportTypeEnum.PRIVATE_TRANSFER.getType();
            }
         }
      }

      result.put("supplierPrices", supplierPrices);
      result.put("customerOneName", project.getReceivingManager());
      result.put("customerOnePhone", project.getReceivingManagerPhone());
      result.put("customerTwoName", project.getCustomerManagerTwo());
      result.put("customerTwoPhone", project.getCustomerManagerTwoPhone());
      result.put("transportMode", transportMode);
      result.put("enclosureTransportMode", project.getEnclosureTransportMode());
      result.put("structureMeasureMode", project.getStructureMeasureMode());
      result.put("enclosureMeasureMode", project.getEnclosureMeasureMode());
      return result;
   }

   @Override
   public ListVO<AppSupplierPersonalDO> getSupplierAndLicensePlate(Long projectId) {
      return new ListVO<>(this.supplierPriceService.getSupplierAndLicensePlate(projectId));
   }

   @Override
   public List<SupplierPriceCarLinkDTO> getCarLinkList(Long id) {
      return this.carLinkService
         .list((Wrapper<MesBuildingSupplierPriceCarLink>)Wrappers.<MesBuildingSupplierPriceCarLink>lambdaQuery().eq(MesBuildingSupplierPriceCarLink::getSupplierPriceId, id))
         .stream()
         .map(carLink -> BeanUtil.copy(carLink, SupplierPriceCarLinkDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<NameInfo> listProjectSupplier(Long projectId) {
      List<MesBuildingSupplierPrice> supplierPriceList = this.supplierPriceService
         .list(Wrappers.lambdaQuery(MesBuildingSupplierPrice.builder().projectId(projectId).build()))
         .stream()
         .filter(s -> s.getSupplierId() != null)
         .collect(Collectors.toList());
      List<NameInfo> nameInfoList = Collections.emptyList();
      if (CollectionUtil.isNotEmpty(supplierPriceList)) {
         nameInfoList = supplierPriceList.stream().map(s -> {
            Supplier supplier = this.supplierService.getById(s.getSupplierId());
            return NameInfo.builder().id(s.getSupplierId()).name(supplier.getName()).build();
         }).collect(Collectors.toList());
      }

      return nameInfoList;
   }

   @Override
   public Boolean saveV2(SupplierPriceSaveVORequestParam param) {
      return true;
   }

   @Override
   public Boolean updateV2(SupplierPriceUpdateDTOParam param) {
      if (param.getInvoiceTypeEnum().equals(InvoiceTypeEnum.DEDICATED.getType())) {
         Preconditions.checkArgument(param.getTax() != null, "税率不能为空");
      } else {
         param.setTax(BigDecimal.ZERO);
      }

      MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(param.getId());
      Preconditions.checkArgument(supplierPrice != null, "操作失败:id有误");
      this.contractProjectService.checkProjectStatus(param.getProjectId());
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      int count = this.cargoListService
         .count((Wrapper<MesBuildingCargoList>)Wrappers.<MesBuildingCargoList>lambdaQuery().eq(MesBuildingCargoList::getSupplierPriceId, supplierPrice.getId()));
      if (count == 0) {
         if (supplierPrice.getBoolPersonalEnum()) {
            Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
            if (!supplierPrice.getLicensePlate().equals(param.getLicensePlate())) {
               MesBuildingSupplierPrice one = this.supplierPriceService
                  .getOne(
                     (Wrapper<MesBuildingSupplierPrice>)((Wrappers.<MesBuildingSupplierPrice>lambdaQuery()
                              .eq(MesBuildingSupplierPrice::getProjectId, param.getProjectId()))
                           .eq(MesBuildingSupplierPrice::getLicensePlate, param.getLicensePlate()))
                        .ne(MesBuildingSupplierPrice::getId, supplierPrice.getId())
                  );
               Preconditions.checkArgument(one == null, "操作失败，该车牌号在该项目中已设置价格");
            }

            BeanUtil.copy(param, supplierPrice);
            SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
            supplierPrice.setPrice(carLinkDTOParam.getPrice());
            supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
            Supplier personalSupplier = this.supplierService
               .getOne(
                  (Wrapper<Supplier>)(new LambdaQueryWrapper<Supplier>().eq(Supplier::getName, param.getLicensePlate()))
                     .eq(Supplier::getBoolPersonalEnum, Boolean.TRUE)
               );
            if (personalSupplier == null) {
               personalSupplier = Supplier.builder()
                  .name(param.getLicensePlate())
                  .boolPersonalEnum(Boolean.TRUE)
                  .supplierClassification(SupplierClassEnum.LOGISTICS.getType())
                  .build();
               this.supplierService.save(personalSupplier);
            }

            supplierPrice.setSupplierId(personalSupplier.getId());
         }

         if (!supplierPrice.getBoolPersonalEnum()) {
            if (!supplierPrice.getSupplierId().equals(param.getSupplierId())) {
               MesBuildingSupplierPrice one = this.supplierPriceService
                  .getOne(
                     (Wrapper<MesBuildingSupplierPrice>)((Wrappers.<MesBuildingSupplierPrice>lambdaQuery()
                              .eq(MesBuildingSupplierPrice::getProjectId, param.getProjectId()))
                           .eq(MesBuildingSupplierPrice::getSupplierId, param.getSupplierId()))
                        .ne(MesBuildingSupplierPrice::getId, supplierPrice.getId())
                  );
               Preconditions.checkArgument(one == null, "操作失败，该物流公司已设置价格");
            }

            BeanUtil.copy(param, supplierPrice);
         }
      } else {
         Preconditions.checkArgument(
            supplierPrice.getProjectId().equals(param.getProjectId())
               && supplierPrice.getInvoiceTypeEnum().equals(param.getInvoiceTypeEnum())
               && supplierPrice.getSupplierId().equals(param.getSupplierId()),
            "修改失败，该物流公司已被使用，只可修改价格信息"
         );
         supplierPrice.setPrice(param.getPrice());
         supplierPrice.setPriceType(param.getPriceType());
         if (supplierPrice.getBoolPersonalEnum()) {
            Preconditions.checkArgument(supplierPrice.getLicensePlate().equals(param.getLicensePlate()), "修改失败，该个人车牌已被使用，只可修改价格信息");
            Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
            SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
            supplierPrice.setPrice(carLinkDTOParam.getPrice());
            supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
         }
      }

      this.supplierPriceService.updateById(supplierPrice);
      this.carLinkService
         .remove(
            (Wrapper<MesBuildingSupplierPriceCarLink>)Wrappers.<MesBuildingSupplierPriceCarLink>lambdaQuery().eq(MesBuildingSupplierPriceCarLink::getSupplierPriceId, supplierPrice.getId())
         );
      if (CollectionUtil.isNotEmpty(param.getLinkList())) {
         param.getLinkList().forEach(e -> {
            MesBuildingSupplierPriceCarLink newSave = BeanUtil.copy(e, MesBuildingSupplierPriceCarLink.class);
            newSave.setProjectId(param.getProjectId());
            newSave.setSupplierPriceId(supplierPrice.getId());
            this.carLinkService.save(newSave);
         });
      }

      return true;
   }
}
