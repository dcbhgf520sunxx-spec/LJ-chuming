package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.SubBusiness;
import com.hzchum.scim.project.core.api.pojo.dao.SubBusinessDO;
import com.hzchum.scim.project.core.api.pojo.dto.SubBusinessDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessAddDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessConditionDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessDeleteDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessFindDTOParam;
import com.hzchum.scim.project.core.api.service.SubBusinessService;
import com.hzchum.scim.project.core.mapper.SubBusinessMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class SubBusinessServiceImpl extends ServiceImpl<SubBusinessMapper, SubBusiness> implements SubBusinessService {
   @Override
   public Long addBusinessInfo(SubBusinessAddDTOParam param) {
      SubBusiness business = this.getByCondition(BeanUtil.copy(param, SubBusinessFindDTOParam.class));
      if (business == null) {
         SubBusiness copy = BeanUtil.copy(param, SubBusiness.class);
         this.baseMapper.insert(copy);
         return copy.getId();
      }

      business.setTotalQuantity(business.getTotalQuantity() + param.getQuantity());
      business.setTotalMete(business.getTotalMete().add(param.getTotalMete()));
      if (param.getTotalArea() != null) {
         business.setTotalArea(business.getTotalArea().add(param.getTotalArea()));
      }

      this.baseMapper.updateById(business);
      return business.getId();
   }

   @Override
   public void deleteBusinessInfo(SubBusinessDeleteDTOParam param) {
      SubBusiness business = this.baseMapper.selectById(param.getBusinessId());
      Preconditions.checkArgument(business != null, "记录不存在");
      business.setTotalQuantity(business.getTotalQuantity() - param.getQuantity());
      business.setTotalMete(business.getTotalMete().multiply(param.getTotalMete()));
      if (param.getTotalArea() != null) {
         business.setTotalArea(business.getTotalArea().add(param.getTotalArea()));
      }

      this.baseMapper.updateById(business);
   }

   @Override
   public SubBusiness getByCondition(SubBusinessFindDTOParam param) {
      LambdaQueryWrapper<SubBusiness> query = (LambdaQueryWrapper<SubBusiness>)(Wrappers.<SubBusiness>lambdaQuery()
            .eq(SubBusiness::getAreaId, param.getAreaId()))
         .eq(SubBusiness::getName, param.getName());
      if (param.getMaterial() == null) {
         query.isNull(SubBusiness::getMaterial);
      } else {
         query.eq(SubBusiness::getMaterial, param.getMaterial());
      }

      return this.baseMapper.selectOne(query);
   }

   @Override
   public ListVO<SubBusinessDTO> listByCondition(SubBusinessConditionDTOParam param) {
      List<SubBusinessDO> businessList = this.baseMapper.listByCondition(param.getProjectId(), param.getMonomerId(), param.getSupplierId());
      return new ListVO<>(businessList.stream().map(e -> {
         SubBusinessDTO copy = BeanUtil.copy(e, SubBusinessDTO.class);
         if (ProductTypeEnum.ARTIFACT.getType().equals(e.getType())) {
            copy.setNuclear("t");
            copy.setMeasure("件");
         } else if (ProductTypeEnum.ENCLOSURE.getType().equals(e.getType())) {
            Integer method = 1;
            copy.setTotalMete(method == 1 ? e.getTotalMete() : e.getTotalArea());
            copy.setNuclear(method == 1 ? "m" : "㎡");
            copy.setMeasure("张");
         }

         return copy;
      }).collect(Collectors.toList()));
   }

   @Override
   public ListVO<Object> listByBusinessId(Long businessId) {
      return new ListVO<>(Arrays.stream(new Object[10]).map(e -> BeanUtil.getRandomBean(SubBusiness.class)).collect(Collectors.toList()));
   }
}
