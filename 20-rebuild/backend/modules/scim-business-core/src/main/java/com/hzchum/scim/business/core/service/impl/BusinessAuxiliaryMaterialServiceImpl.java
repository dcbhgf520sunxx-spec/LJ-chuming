package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.pojo._do.AuxiliaryMaterialSummaryDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessAuxiliaryMaterial;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialFindDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessAuxiliaryMaterialService;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.mapper.BusinessAuxiliaryMaterialMapper;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessAuxiliaryMaterialServiceImpl
   extends ServiceImpl<BusinessAuxiliaryMaterialMapper, BusinessAuxiliaryMaterial>
   implements BusinessAuxiliaryMaterialService {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private BusinessCheckInfoService businessCheckInfoService;
   @Autowired
   private BusinessCheckDetailService businessCheckDetailService;

   @Override
   public Long addBusinessInfo(AuxiliaryMaterialAddDTOParam param) {
      BusinessAuxiliaryMaterial business = this.getByCondition(BeanUtil.copy(param, AuxiliaryMaterialFindDTOParam.class));
      if (business == null) {
         BusinessAuxiliaryMaterial copy = BeanUtil.copy(param, BusinessAuxiliaryMaterial.class);
         this.baseMapper.insert(copy);
         return copy.getId();
      } else {
         business.setMete(business.getMete().add(param.getMete()));
         this.baseMapper.updateById(business);
         return business.getId();
      }
   }

   @Override
   public void editBusinessInfo(AuxiliaryMaterialEditDTOParam param) {
      BusinessAuxiliaryMaterial business = this.baseMapper.selectById(param.getBusinessId());
      Preconditions.checkArgument(business != null, "记录不存在");
      business.setMete(param.getMete());
      if (param.getMete().equals(BigDecimal.ZERO)) {
         this.baseMapper.deleteById(business);
      } else {
         this.baseMapper.updateById(business);
      }
   }

   @Override
   public BusinessAuxiliaryMaterial getByCondition(AuxiliaryMaterialFindDTOParam param) {
      return this.baseMapper
         .selectOne(
            (Wrapper<BusinessAuxiliaryMaterial>)(((Wrappers.<BusinessAuxiliaryMaterial>lambdaQuery()
                        .eq(BusinessAuxiliaryMaterial::getMonomerId, param.getMonomerId()))
                     .eq(BusinessAuxiliaryMaterial::getClassifyId, param.getClassifyId()))
                  .eq(BusinessAuxiliaryMaterial::getSpecification, param.getSpecification()))
               .eq(BusinessAuxiliaryMaterial::getColor, param.getColor())
         );
   }

   @Override
   public ListVO<BusinessAuxiliaryMaterial> listByCondition(AuxiliaryMaterialFindDTOParam param) {
      List<BusinessAuxiliaryMaterial> businessAuxiliaryMaterials = this.baseMapper
         .selectList(
            (Wrapper<BusinessAuxiliaryMaterial>)((((Wrappers.<BusinessAuxiliaryMaterial>lambdaQuery()
                           .eq(param.getMonomerId() != null, BusinessAuxiliaryMaterial::getMonomerId, param.getMonomerId()))
                        .eq(param.getClassifyId() != null, BusinessAuxiliaryMaterial::getClassifyId, param.getClassifyId()))
                     .like(StringUtils.isNotBlank(param.getSpecification()), BusinessAuxiliaryMaterial::getSpecification, param.getSpecification()))
                  .like(StringUtils.isNotBlank(param.getColor()), BusinessAuxiliaryMaterial::getColor, param.getColor()))
               .ge(BusinessAuxiliaryMaterial::getMete, 0)
         );
      if (CollectionUtils.isNotEmpty(businessAuxiliaryMaterials)) {
         List<BusinessCheckInfo> businessCheckInfos = this.businessCheckInfoService
            .list(
               (Wrapper<BusinessCheckInfo>)(new LambdaQueryWrapper<BusinessCheckInfo>().eq(BusinessCheckInfo::getStatus, CheckStatusEnum.PENDING.getType()))
                  .eq(BusinessCheckInfo::getType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
            );
         if (CollectionUtils.isNotEmpty(businessCheckInfos)) {
            List<BusinessCheckDetail> details = this.businessCheckDetailService
               .list(
                  (Wrapper<BusinessCheckDetail>)Wrappers.<BusinessCheckDetail>lambdaQuery()
                     .in(BusinessCheckDetail::getCheckInfoId, businessCheckInfos.stream().map(BusinessCheckInfo::getId).collect(Collectors.toList()))
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(details), "待审核详情不存在!!!");
            Map<Long, List<BusinessCheckDetail>> detailMap = details.stream().collect(Collectors.groupingBy(BusinessCheckDetail::getBusinessId));
            businessAuxiliaryMaterials.forEach(e -> {
               BusinessCheckDetail businessCheckDetail = detailMap.get(e.getId()).get(0);
               if (businessCheckDetail != null) {
                  e.setUnitPrice(businessCheckDetail.getNewUnitPrice());
                  e.setStatus(CheckStatusEnum.PENDING.getType());
               }
            });
         }
      }

      return new ListVO<>(businessAuxiliaryMaterials);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListByCondition(AuxiliaryMaterialFindDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      ProjectInfo project = this.projectService.getByIdFromCache(monomer.getProjectId());
      header.put("monomer", monomer);
      header.put("project", project);
      printVO.setHeader(header);
      printVO.setTable(
         this.baseMapper
            .selectList(Wrappers.<BusinessAuxiliaryMaterial>lambdaQuery().eq(param.getMonomerId() != null, BusinessAuxiliaryMaterial::getMonomerId, param.getMonomerId()))
            .stream()
            .map(e -> {
               Map<String, Object> result = BeanUtil.beanToMap(e);
               result.put("totalPrice", e.getUnitPrice() == null ? BigDecimal.ZERO : e.getUnitPrice().multiply(e.getMete()));
               return result;
            })
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public AuxiliaryMaterialSummaryDO summary(Long projectId, Long monomerId) {
      return this.baseMapper.summary(projectId, monomerId);
   }
}
