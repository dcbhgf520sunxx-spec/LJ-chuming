package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricity;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWaterElectricityDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWaterElectricityMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ContractWaterElectricityServiceImpl
   extends ServiceImpl<ContractWaterElectricityMapper, ContractWaterElectricity>
   implements ContractWaterElectricityService {
   @Override
   public List<ContractWaterElectricityDTO> listByCondition(Integer year, Integer type, Integer childType) {
      List<ContractWaterElectricity> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractWaterElectricity.class)
               .eq(year != null, ContractWaterElectricity::getYear, year)
               .eq(type != null, ContractWaterElectricity::getType, type)
               .eq(childType != null, ContractWaterElectricity::getChildType, childType)
               .orderByAsc(ContractWaterElectricity::getType)
               .orderByAsc(ContractWaterElectricity::getChildType)
               .orderByDesc(ContractWaterElectricity::getYear)
               .orderByAsc(ContractWaterElectricity::getMonth)
         );
      return list.stream().map(s -> BeanUtil.copy(s, ContractWaterElectricityDTO.class)).collect(Collectors.toList());
   }

   @Override
   public Boolean isExist(Integer year, Integer month, Integer type, Integer childType) {
      ContractWaterElectricity waterElectricity = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ContractWaterElectricity.class)
               .eq(ContractWaterElectricity::getYear, year)
               .eq(ContractWaterElectricity::getMonth, month)
               .eq(ContractWaterElectricity::getType, type)
               .eq(WaterElectricityEnum.ELECTRICITY.getType().equals(type), ContractWaterElectricity::getChildType, childType)
         );
      return waterElectricity != null;
   }

   @Override
   public List<MonthAmountInfo> listWaterEleMonthAmount(Integer startMonth, Integer endMonth, Integer type) {
      return this.baseMapper.selectMonthMeteAmount(startMonth, endMonth, type);
   }
}
