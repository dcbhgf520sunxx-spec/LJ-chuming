package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechAssembleExtMapper extends BaseMapper<TechAssembleExt> {
   List<TechAssembleExt> listAssExt(@Param("assNumberInfors") List<NumberInfoDTO> assNumberInfors);

   List<TechAssembleExt> listAllAssembleExt(@Param("monomerId") Long monomerId, @Param("serialNumberList") List<String> serialNumberList);
}
