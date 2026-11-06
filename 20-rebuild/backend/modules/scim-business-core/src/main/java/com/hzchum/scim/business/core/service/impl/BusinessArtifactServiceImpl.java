package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.pojo._do.ArtifactSummaryDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessArtifactSimpleDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.mapper.BusinessArtifactMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class BusinessArtifactServiceImpl extends ServiceImpl<BusinessArtifactMapper, BusinessArtifact> implements BusinessArtifactService {
   @Override
   public Long addBusinessInfo(ArtifactAddDTOParam param) {
      BusinessArtifact business = this.getByCondition(BeanUtil.copy(param, ArtifactFindDTOParam.class));
      if (business == null) {
         BusinessArtifact copy = BeanUtil.copy(param, BusinessArtifact.class);
         copy.setTotalQuantity(param.getQuantity());
         copy.setTotalWeight(param.getTotalWeight());
         copy.setTotalLength(param.getTotalLength());
         this.baseMapper.insert(copy);
         return copy.getId();
      } else {
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         business.setTotalWeight(business.getTotalWeight().add(param.getTotalWeight()));
         business.setTotalLength(business.getTotalLength().add(param.getTotalLength()));
         this.baseMapper.updateById(business);
         return business.getId();
      }
   }

   @Override
   public BusinessArtifact editBusinessInfo(ArtifactEditDTOParam param) {
      BusinessArtifact business = this.baseMapper.selectById(param.getBusinessId());
      if (business != null) {
         business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
         business.setTotalWeight(business.getTotalWeight().add(param.getTotalWeight()));
         business.setTotalLength(business.getTotalLength().add(param.getTotalLength()));
         if (StringUtils.isNotBlank(param.getSpecification()) && !business.getSpecification().equals(param.getSpecification())) {
            business.setSpecification(param.getSpecification());
         }

         if (business.getTotalQuantity() == 0) {
            this.baseMapper.deleteById(business.getId());
            return null;
         } else {
            this.baseMapper.updateById(business);
            return business;
         }
      } else {
         return null;
      }
   }

   @Override
   public BusinessArtifact getByCondition(ArtifactFindDTOParam param) {
      LambdaQueryWrapper<BusinessArtifact> query = (LambdaQueryWrapper<BusinessArtifact>)(Wrappers.<BusinessArtifact>lambdaQuery()
            .eq(BusinessArtifact::getAreaId, param.getAreaId()))
         .eq(BusinessArtifact::getName, param.getName());
      if (param.getMaterial() != null) {
         query.eq(BusinessArtifact::getMaterial, param.getMaterial());
      }

      if (param.getSpecification() != null) {
         query.eq(BusinessArtifact::getSpecification, param.getSpecification());
      }

      List<BusinessArtifact> businessArtifactList = this.baseMapper.selectList(query);
      return businessArtifactList.isEmpty() ? null : businessArtifactList.get(0);
   }

   @Override
   public SummaryDTO summary(Long projectId, Long monomerId, Long areaId) {
      ArtifactSummaryDO summary = this.baseMapper.summary(projectId, monomerId, areaId);
      return SummaryDTO.builder().quantity(summary.getTotalQuantity()).mete(summary.getTotalWeight()).price(summary.getTotalPrice()).build();
   }

   @Override
   public ListVO<BusinessArtifactSimpleDTO> listSimple(Long monomerId) {
      return new ListVO<>(
         this.baseMapper
            .selectList((Wrapper<BusinessArtifact>)Wrappers.<BusinessArtifact>lambdaQuery().eq(BusinessArtifact::getMonomerId, monomerId))
            .stream()
            .map(artifact -> BeanUtil.copy(artifact, BusinessArtifactSimpleDTO.class))
            .collect(Collectors.toList())
      );
   }
}
