package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.business.core.api.pojo._do.BusinessProductionControlCheckDetailDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckDetail;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlCheckDetailService;
import com.hzchum.scim.business.core.mapper.BusinessProductionControlCheckDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class BusinessProductionControlCheckDetailServiceImpl
   extends ServiceImpl<BusinessProductionControlCheckDetailMapper, BusinessProductionControlCheckDetail>
   implements BusinessProductionControlCheckDetailService {
   @Override
   public ListVO<BusinessProductionControlCheckDetailDO> listByCheckId(Long id) {
      return new ListVO<>(this.baseMapper.listByCheckId(id));
   }
}
