package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysStructureSpecMapper extends BaseMapper<SysStructureSpec> {
   List<String> selectAllPrefix(@Param("productionLineTypeEnum") Integer productionLineTypeEnum);

   int selectCountPrefix(@Param("productionLineTypeEnum") Integer productionLineTypeEnum, @Param("prefix") String prefix);
}
