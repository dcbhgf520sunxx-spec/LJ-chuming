package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesBoltSleeve;
import com.hzchum.scim.system.core.api.pojo.dto.MesBoltSleeveDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBoltSleeveMapper extends BaseMapper<MesBoltSleeve> {
   Boolean isTypeExistence(@Param("id") Long id, @Param("typeList") List<String> typeList);

   MesBoltSleeveDTO detailById(@Param("id") Long id);

   List<MesBoltSleeveDTO> selectListInfo();
}
