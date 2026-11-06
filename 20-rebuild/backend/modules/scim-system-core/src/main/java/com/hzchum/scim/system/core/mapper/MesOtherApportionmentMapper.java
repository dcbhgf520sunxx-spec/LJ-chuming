package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesOtherApportionment;
import com.hzchum.scim.system.core.api.pojo.dto.MesOtherApportionmentDTO;
import java.util.List;

public interface MesOtherApportionmentMapper extends BaseMapper<MesOtherApportionment> {
   List<MesOtherApportionmentDTO> listInfo();
}
