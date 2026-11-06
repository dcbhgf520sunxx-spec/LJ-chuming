package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesAuxiliaryMapper extends BaseMapper<MesAuxiliary> {
   List<MesAuxiliary> list(@Param("basicClass") Integer basicClass, @Param("auxiliaryName") String auxiliaryName, @Param("className") String className);
}
