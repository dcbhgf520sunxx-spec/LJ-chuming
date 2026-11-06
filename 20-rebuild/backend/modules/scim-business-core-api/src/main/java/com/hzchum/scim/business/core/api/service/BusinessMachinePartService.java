package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartAddDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartEditDtoParam;
import java.util.List;

public interface BusinessMachinePartService extends IService<BusinessMachinePart> {
   List<BusinessMachinePart> listByCondition(Long monomerId, Long areaId, String specification, String material, List<Long> ids);

   Long addBusinessInfo(MachinePartAddDtoParam param);

   void editBusinessInfo(MachinePartEditDtoParam param);
}
