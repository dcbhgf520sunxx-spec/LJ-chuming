package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigMapper extends BaseMapper<Config> {
   List<Config> listAll();

   Config getByCode(@Param("code") String code);

   void remove(@Param("code") String code);
}
