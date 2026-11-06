package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dto.ProductionControlCheckListDTO;
import java.util.List;

public interface BusinessProductionControlCheckInfoMapper extends BaseMapper<BusinessProductionControlCheckInfo> {
   List<ProductionControlCheckListDTO> listInfo(Integer status);
}
