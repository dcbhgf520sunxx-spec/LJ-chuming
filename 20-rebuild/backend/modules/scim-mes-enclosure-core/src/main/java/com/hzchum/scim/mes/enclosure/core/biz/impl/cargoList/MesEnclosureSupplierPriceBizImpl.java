package com.hzchum.scim.mes.enclosure.core.biz.impl.cargoList;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.enclosure.core.api.biz.cargoList.MesEnclosureSupplierPriceBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoList;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureLicencePlate;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPrice;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPriceCarLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.SupplierPriceCarLinkDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.save.SupplierPriceCarLinkDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.update.SupplierPriceUpdateDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListService;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureLicencePlateService;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureSupplierPriceCarLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureSupplierPriceService;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import java.math.BigDecimal;
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
public class MesEnclosureSupplierPriceBizImpl implements MesEnclosureSupplierPriceBiz {
   @Autowired
   private MesEnclosureSupplierPriceService supplierPriceService;
   @Autowired
   private MesEnclosureCargoListService cargoListService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private MesEnclosureSupplierPriceCarLinkService carLinkService;
   @Resource
   private MesEnclosureLicencePlateService mesEnclosureLicencePlateService;

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
         MesEnclosureSupplierPrice one = this.supplierPriceService
            .getOne(
               (Wrapper<MesEnclosureSupplierPrice>)(Wrappers.<MesEnclosureSupplierPrice>lambdaQuery()
                     .eq(MesEnclosureSupplierPrice::getProjectId, param.getProjectId()))
                  .eq(MesEnclosureSupplierPrice::getSupplierId, param.getSupplierId())
            );
         Preconditions.checkArgument(one == null, "操作失败，该物流公司已设置价格");
         Preconditions.checkArgument(param.getPrice() != null && param.getPriceType() != null, "操作失败,基础价格和计价方式不能为空!!!");
      }

      MesEnclosureSupplierPrice supplierPrice = BeanUtil.copy(param, MesEnclosureSupplierPrice.class);
      supplierPrice.setUserId(UserUtil.getCurrentUserId());
      supplierPrice.setUserName(UserUtil.getCurrentName());
      if (param.getBoolPersonalEnum()) {
         Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
         MesEnclosureSupplierPrice one = this.supplierPriceService
            .getOne(
               (Wrapper<MesEnclosureSupplierPrice>)(Wrappers.<MesEnclosureSupplierPrice>lambdaQuery()
                     .eq(MesEnclosureSupplierPrice::getProjectId, param.getProjectId()))
                  .eq(MesEnclosureSupplierPrice::getLicensePlate, param.getLicensePlate())
            );
         Preconditions.checkArgument(one == null, "操作失败，该车牌号在该项目中已设置价格");
         SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
         supplierPrice.setPrice(carLinkDTOParam.getPrice());
         supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
         synchronized (this) {
            MesEnclosureLicencePlate licencePlate = this.mesEnclosureLicencePlateService
               .getOne((Wrapper<MesEnclosureLicencePlate>)new LambdaQueryWrapper<MesEnclosureLicencePlate>().eq(MesEnclosureLicencePlate::getLicensePlate, param.getLicensePlate()));
            if (licencePlate == null) {
               MesEnclosureLicencePlate mesEnclosureLicencePlate = MesEnclosureLicencePlate.builder().licensePlate(param.getLicensePlate()).build();
               this.mesEnclosureLicencePlateService.save(mesEnclosureLicencePlate);
            }
         }
      }

      this.supplierPriceService.save(supplierPrice);
      if (CollectionUtil.isNotEmpty(param.getLinkList())) {
         param.getLinkList().forEach(e -> {
            MesEnclosureSupplierPriceCarLink newSave = BeanUtil.copy(e, MesEnclosureSupplierPriceCarLink.class);
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

      MesEnclosureSupplierPrice supplierPrice = this.supplierPriceService.getById(param.getId());
      Preconditions.checkArgument(supplierPrice != null, "操作失败:id有误");
      this.contractProjectService.checkProjectStatus(param.getProjectId());
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      int count = this.cargoListService
         .count((Wrapper<MesEnclosureCargoList>)Wrappers.<MesEnclosureCargoList>lambdaQuery().eq(MesEnclosureCargoList::getSupplierPriceId, supplierPrice.getId()));
      if (count == 0) {
         if (supplierPrice.getBoolPersonalEnum()) {
            Preconditions.checkArgument(param.getLinkList().size() == 1, "操作失败,个人承运车型有误!!!");
            if (!supplierPrice.getLicensePlate().equals(param.getLicensePlate())) {
               MesEnclosureSupplierPrice one = this.supplierPriceService
                  .getOne(
                     (Wrapper<MesEnclosureSupplierPrice>)((Wrappers.<MesEnclosureSupplierPrice>lambdaQuery()
                              .eq(MesEnclosureSupplierPrice::getProjectId, param.getProjectId()))
                           .eq(MesEnclosureSupplierPrice::getLicensePlate, param.getLicensePlate()))
                        .ne(MesEnclosureSupplierPrice::getId, supplierPrice.getId())
                  );
               Preconditions.checkArgument(one == null, "操作失败，该车牌号在该项目中已设置价格");
            }

            BeanUtil.copy(param, supplierPrice);
            SupplierPriceCarLinkDTOParam carLinkDTOParam = param.getLinkList().get(0);
            supplierPrice.setPrice(carLinkDTOParam.getPrice());
            supplierPrice.setPriceType(carLinkDTOParam.getPriceType());
            synchronized (this) {
               MesEnclosureLicencePlate plate = this.mesEnclosureLicencePlateService
                  .getOne((Wrapper<MesEnclosureLicencePlate>)new LambdaQueryWrapper<MesEnclosureLicencePlate>().eq(MesEnclosureLicencePlate::getLicensePlate, param.getLicensePlate()));
               if (plate == null) {
                  MesEnclosureLicencePlate mesEnclosureLicencePlate = MesEnclosureLicencePlate.builder().licensePlate(param.getLicensePlate()).build();
                  this.mesEnclosureLicencePlateService.save(mesEnclosureLicencePlate);
               }
            }
         }

         if (!supplierPrice.getBoolPersonalEnum()) {
            if (!supplierPrice.getSupplierId().equals(param.getSupplierId())) {
               MesEnclosureSupplierPrice one = this.supplierPriceService
                  .getOne(
                     (Wrapper<MesEnclosureSupplierPrice>)((Wrappers.<MesEnclosureSupplierPrice>lambdaQuery()
                              .eq(MesEnclosureSupplierPrice::getProjectId, param.getProjectId()))
                           .eq(MesEnclosureSupplierPrice::getSupplierId, param.getSupplierId()))
                        .ne(MesEnclosureSupplierPrice::getId, supplierPrice.getId())
                  );
               Preconditions.checkArgument(one == null, "操作失败，该物流公司已设置价格");
            }

            BeanUtil.copy(param, supplierPrice);
         }
      } else {
         Preconditions.checkArgument(
            supplierPrice.getProjectId().equals(param.getProjectId()) && supplierPrice.getInvoiceTypeEnum().equals(param.getInvoiceTypeEnum()),
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
            (Wrapper<MesEnclosureSupplierPriceCarLink>)Wrappers.<MesEnclosureSupplierPriceCarLink>lambdaQuery().eq(MesEnclosureSupplierPriceCarLink::getSupplierPriceId, supplierPrice.getId())
         );
      if (CollectionUtil.isNotEmpty(param.getLinkList())) {
         param.getLinkList().forEach(e -> {
            MesEnclosureSupplierPriceCarLink newSave = BeanUtil.copy(e, MesEnclosureSupplierPriceCarLink.class);
            newSave.setProjectId(param.getProjectId());
            newSave.setSupplierPriceId(supplierPrice.getId());
            this.carLinkService.save(newSave);
         });
      }

      return true;
   }

   @Override
   public boolean deleteById(Long id) {
      MesEnclosureSupplierPrice supplierPrice = this.supplierPriceService.getById(id);
      Preconditions.checkArgument(supplierPrice != null, "物流单位价格不存在");
      this.contractProjectService.checkProjectStatus(supplierPrice.getProjectId());
      this.projectUserLinkService.checkProjectUser(supplierPrice.getProjectId());
      int count = this.cargoListService
         .count((Wrapper<MesEnclosureCargoList>)Wrappers.<MesEnclosureCargoList>lambdaQuery().eq(MesEnclosureCargoList::getSupplierPriceId, supplierPrice.getId()));
      Preconditions.checkArgument(count == 0, "物流单位价格使用中，无法删除");
      this.supplierPriceService.removeById(supplierPrice.getId());
      this.carLinkService
         .remove((Wrapper<MesEnclosureSupplierPriceCarLink>)Wrappers.<MesEnclosureSupplierPriceCarLink>lambdaQuery().eq(MesEnclosureSupplierPriceCarLink::getSupplierPriceId, id));
      return true;
   }

   @Override
   public Map<String, Object> getInfo(Long projectId, String licensePlate) {
      Map<String, Object> result = new HashMap<>();
      if (StringUtils.isNotBlank(licensePlate)) {
         MesEnclosureSupplierPrice supplierPrice = this.supplierPriceService
            .getOne(
               (Wrapper<MesEnclosureSupplierPrice>)((new LambdaQueryWrapper<MesEnclosureSupplierPrice>()
                        .eq(MesEnclosureSupplierPrice::getProjectId, projectId))
                     .eq(MesEnclosureSupplierPrice::getLicensePlate, licensePlate))
                  .eq(MesEnclosureSupplierPrice::getBoolPersonalEnum, Boolean.TRUE)
            );
         if (supplierPrice == null) {
            licensePlate = null;
         }

         if (supplierPrice != null) {
            MesEnclosureSupplierPriceCarLink carLink = this.carLinkService
               .getOne(
                  (Wrapper<MesEnclosureSupplierPriceCarLink>)(new LambdaQueryWrapper<MesEnclosureSupplierPriceCarLink>()
                        .eq(MesEnclosureSupplierPriceCarLink::getProjectId, projectId))
                     .eq(MesEnclosureSupplierPriceCarLink::getSupplierPriceId, supplierPrice.getId())
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

      result.put("supplierPrices", supplierPrices);
      result.put("customerOneName", project.getCustomerManagerOne());
      result.put("customerOnePhone", project.getCustomerManagerOnePhone());
      result.put("customerTwoName", project.getCustomerManagerTwo());
      result.put("customerTwoPhone", project.getCustomerManagerTwoPhone());
      result.put("transportMode", project.getTransportMode());
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
         .list((Wrapper<MesEnclosureSupplierPriceCarLink>)Wrappers.<MesEnclosureSupplierPriceCarLink>lambdaQuery().eq(MesEnclosureSupplierPriceCarLink::getSupplierPriceId, id))
         .stream()
         .map(carLink -> BeanUtil.copy(carLink, SupplierPriceCarLinkDTO.class))
         .collect(Collectors.toList());
   }
}
