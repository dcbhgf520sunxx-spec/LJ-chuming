package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import java.util.List;

public interface TechAssembleExtService extends IService<TechAssembleExt> {
   void addReduceExt(TechAssemble assemble, Integer quantity);

   List<TechAssembleExt> listAssExt(List<NumberInfoDTO> assNumberInfors);

   List<TechAssembleExt> listAllAssembleExt(Long monomerId, List<String> serialNumberList);
}
