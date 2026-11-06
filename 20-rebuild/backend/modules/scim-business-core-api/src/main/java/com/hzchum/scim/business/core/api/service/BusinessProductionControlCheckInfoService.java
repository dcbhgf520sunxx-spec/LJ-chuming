package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessProductionControlCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dto.ProductionControlCheckListDTO;

public interface BusinessProductionControlCheckInfoService extends IService<BusinessProductionControlCheckInfo> {
   PageVO<ProductionControlCheckListDTO> pageInfo(Integer status, Integer pageNumber, Integer pageSize);

   Integer countList();
}
