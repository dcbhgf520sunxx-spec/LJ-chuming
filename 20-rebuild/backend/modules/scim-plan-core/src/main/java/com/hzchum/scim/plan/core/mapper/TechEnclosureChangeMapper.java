package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChange;
import com.hzchum.scim.plan.core.api.pojo.vo.change.EnclosureChangeVo;
import com.hzchum.scim.plan.core.api.pojo.voParam.EnclosureChangeVoParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechEnclosureChangeMapper extends BaseMapper<TechEnclosureChange> {
   List<EnclosureChangeVo> findAllEnclosureList(@Param("voParam") EnclosureChangeVoParam voParam);
}
