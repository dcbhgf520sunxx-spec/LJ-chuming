package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckDetail;
import com.hzchum.scim.project.core.api.pojo.dto.SubBusinessCheckDetailDO;
import java.util.List;

public interface SubBusinessCheckDetailMapper extends BaseMapper<SubBusinessCheckDetail> {
   List<SubBusinessCheckDetailDO> listByCheckId(Long id);
}
