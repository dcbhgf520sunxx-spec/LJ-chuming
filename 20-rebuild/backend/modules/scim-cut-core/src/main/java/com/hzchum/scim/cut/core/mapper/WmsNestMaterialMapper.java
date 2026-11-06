package com.hzchum.scim.cut.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.cut.core.api.pojo._do.WmsNestMaterial;
import java.util.List;

public interface WmsNestMaterialMapper extends BaseMapper<WmsNestMaterial> {
   List<String> getMaterialList();
}
