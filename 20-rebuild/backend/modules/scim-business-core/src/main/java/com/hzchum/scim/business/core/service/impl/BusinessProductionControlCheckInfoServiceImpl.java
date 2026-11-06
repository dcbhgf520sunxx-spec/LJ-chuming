package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dto.ProductionControlCheckListDTO;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlCheckInfoService;
import com.hzchum.scim.business.core.mapper.BusinessProductionControlCheckInfoMapper;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class BusinessProductionControlCheckInfoServiceImpl
   extends ServiceImpl<BusinessProductionControlCheckInfoMapper, BusinessProductionControlCheckInfo>
   implements BusinessProductionControlCheckInfoService {
   @Override
   public PageVO<ProductionControlCheckListDTO> pageInfo(Integer status, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.<ProductionControlCheckListDTO>startPage(pageNumber, pageSize).doSelectPage(() -> this.baseMapper.listInfo(status)));
   }

   @Override
   public Integer countList() {
      return this.baseMapper
         .selectCount(
            (Wrapper<BusinessProductionControlCheckInfo>)Wrappers.<BusinessProductionControlCheckInfo>lambdaQuery()
               .eq(BusinessProductionControlCheckInfo::getStatus, CheckStatusEnum.PENDING.getType())
         );
   }
}
