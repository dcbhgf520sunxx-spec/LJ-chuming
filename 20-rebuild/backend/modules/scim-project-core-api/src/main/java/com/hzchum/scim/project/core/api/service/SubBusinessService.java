package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.project.core.api.pojo._do.SubBusiness;
import com.hzchum.scim.project.core.api.pojo.dto.SubBusinessDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessAddDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessConditionDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessDeleteDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.SubBusinessFindDTOParam;

public interface SubBusinessService extends IService<SubBusiness> {
   Long addBusinessInfo(SubBusinessAddDTOParam param);

   void deleteBusinessInfo(SubBusinessDeleteDTOParam param);

   SubBusiness getByCondition(SubBusinessFindDTOParam param);

   ListVO<SubBusinessDTO> listByCondition(SubBusinessConditionDTOParam param);

   ListVO<Object> listByBusinessId(Long businessId);
}
