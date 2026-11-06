package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.CheckInfoDO;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubBusinessCheckInfoMapper extends BaseMapper<SubBusinessCheckInfo> {
   List<CheckInfoDO> listInfo(@Param("projectId") Long projectId, @Param("status") Integer status);
}
