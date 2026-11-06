package com.hzchum.scim.business.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.biz.BusinessMachinePartBiz;
import com.hzchum.scim.business.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessPriceTemp;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessMachinePartDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessPriceTempService;
import com.hzchum.scim.business.core.mapper.BusinessMachinePartMapper;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BusinessMachinePartBizImpl
   extends IBizImpl<BusinessMachinePartService, BusinessMachinePartMapper, BusinessMachinePart>
   implements BusinessMachinePartBiz {
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final TechMachinePartService machinePartService;
   private final BusinessCheckInfoService businessCheckInfoService;
   private final BusinessCheckDetailService businessCheckDetailService;
   private final BusinessPriceTempService businessPriceTempService;

   @Override
   public PageVO<BusinessMachinePartDTO> pageListBusinessMachinePart(
      Long monomerId, Long areaId, String specification, String material, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<BusinessMachinePart> businessMachinePartList = this.baseService.listByCondition(monomerId, areaId, specification, material, null);
      List<BusinessMachinePartDTO> dtoList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(businessMachinePartList)) {
         Map<Long, BusinessCheckDetail> checkDetailMap = this.businessCheckDetailService
            .list(
               Wrappers.lambdaQuery(BusinessCheckDetail.class)
                  .eq(BusinessCheckDetail::getStatus, CheckStatusEnum.PENDING.getType())
                  .in(BusinessCheckDetail::getBusinessId, businessMachinePartList.stream().map(BusinessMachinePart::getId).collect(Collectors.toSet()))
            )
            .stream()
            .collect(Collectors.toMap(BusinessCheckDetail::getBusinessId, Function.identity(), (s1, s2) -> s2));
         List<BusinessPriceTemp> priceTempList = this.businessPriceTempService
            .list(
               Wrappers.lambdaQuery(BusinessPriceTemp.class)
                  .eq(monomerId != null, BusinessPriceTemp::getMonomerId, monomerId)
                  .eq(areaId != null, BusinessPriceTemp::getAreaId, areaId)
                  .apply("project_type & 3")
                  .eq(BusinessPriceTemp::getType, ProductTypeEnum.MACHINE_PART.getType())
            );
         Map<Long, BusinessPriceTemp> priceTempMap = priceTempList.stream()
            .collect(Collectors.toMap(BusinessPriceTemp::getBusinessId, Function.identity(), (s1, s2) -> s2));
         List<Long> businessId = businessMachinePartList.stream().map(BusinessMachinePart::getId).collect(Collectors.toList());
         Map<Long, Boolean> boolAllPartSendMap = this.machinePartService
            .list(Wrappers.lambdaQuery(TechMachinePart.class).in(TechMachinePart::getBusinessId, businessId))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getBusinessId, TechMachinePart::getBoolAllPartSendDirectly, (s1, s2) -> s2));
         dtoList = businessMachinePartList.stream()
            .map(
               businessMachinePart -> {
                  BusinessMachinePartDTO dto = BeanUtil.copy(businessMachinePart, BusinessMachinePartDTO.class);
                  dto.setBoolAllPartSendDirectly(boolAllPartSendMap.get(businessMachinePart.getId()));
                  dto.setStatus(CheckStatusEnum.PASS.getType());
                  if (checkDetailMap.containsKey(businessMachinePart.getId())) {
                     BusinessCheckDetail checkDetail = checkDetailMap.get(businessMachinePart.getId());
                     dto.setStatus(CheckStatusEnum.PENDING.getType());
                     dto.setPricingManner(checkDetail.getNewPricingManner());
                     dto.setUnitPrice(checkDetail.getNewUnitPrice());
                     dto.setTotalPrice(
                        checkDetail.getNewPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                           ? businessMachinePart.getTotalWeight().multiply(checkDetail.getNewUnitPrice()).divide(BigDecimal.valueOf(1000L))
                           : businessMachinePart.getTotalLength().multiply(checkDetail.getNewUnitPrice())
                     );
                  }

                  if (priceTempMap.containsKey(businessMachinePart.getId())) {
                     BusinessPriceTemp priceTemp = priceTempMap.get(businessMachinePart.getId());
                     dto.setStatus(CheckStatusEnum.PENDING.getType());
                     dto.setPricingManner(priceTemp.getPricingManner());
                     dto.setUnitPrice(priceTemp.getUnitPrice());
                     dto.setTotalPrice(
                        priceTemp.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                           ? businessMachinePart.getTotalWeight().multiply(priceTemp.getUnitPrice()).divide(BigDecimal.valueOf(1000L))
                           : businessMachinePart.getTotalLength().multiply(priceTemp.getUnitPrice())
                     );
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList());
      }

      return new PageVO<>(PageUtils.getPageInfo(dtoList, businessMachinePartList));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListBusinessMachinePart(Long monomerId, Long areaId, String specification, String material, List<Long> ids) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      NameInfo monomer = this.monomerService.getSimpleById(monomerId);
      header.put("monomer", monomer);
      if (areaId != null) {
         NameInfo nameInfo = this.areaService.getSimpleById(areaId);
         header.put("area", nameInfo);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.baseService
         .listByCondition(monomerId, areaId, specification, material, ids)
         .stream()
         .map(
            b -> {
               b.setTotalPrice(
                  b.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())
                     ? b.getTotalWeight()
                        .multiply(b.getUnitPrice() == null ? BigDecimal.ZERO : b.getUnitPrice())
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                     : b.getTotalLength().multiply(b.getUnitPrice() == null ? BigDecimal.ZERO : b.getUnitPrice())
               );
               return BeanUtil.beanToMap(b);
            }
         )
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public SummaryDTO summaryMachinePart(Long monomerId) {
      List<BusinessMachinePart> businessMachinePartList = this.baseService
         .list(Wrappers.lambdaQuery(BusinessMachinePart.builder().monomerId(monomerId).build()));
      int sumQuantity = businessMachinePartList.stream().mapToInt(BusinessMachinePart::getTotalQuantity).sum();
      BigDecimal sumWeight = businessMachinePartList.stream().map(BusinessMachinePart::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal sumPrice = businessMachinePartList.stream()
         .filter(b -> b.getUnitPrice() != null)
         .map(BusinessMachinePart::getTotalPrice)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      return SummaryDTO.builder().quantity(sumQuantity).mete(sumWeight).price(sumPrice).build();
   }

   @Override
   public ListVO<TechMachinePart> listMachinePartByBusinessId(Long id) {
      return new ListVO<>(this.machinePartService.listByBusinessId(id));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printMachinePartByBusinessId(Long id) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<TechMachinePart> machinePartList = this.machinePartService.listByBusinessId(id);
      List<Map<String, Object>> mapList = machinePartList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   public BusinessMachinePartBizImpl(
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final TechMachinePartService machinePartService,
      final BusinessCheckInfoService businessCheckInfoService,
      final BusinessCheckDetailService businessCheckDetailService,
      final BusinessPriceTempService businessPriceTempService
   ) {
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.machinePartService = machinePartService;
      this.businessCheckInfoService = businessCheckInfoService;
      this.businessCheckDetailService = businessCheckDetailService;
      this.businessPriceTempService = businessPriceTempService;
   }
}
