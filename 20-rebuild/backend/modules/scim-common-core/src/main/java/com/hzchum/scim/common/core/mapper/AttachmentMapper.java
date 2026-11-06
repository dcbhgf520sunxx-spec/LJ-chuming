package com.hzchum.scim.common.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachmentMapper extends BaseMapper<Attachment> {
   List<Attachment> listByIds(@Param("ids") String ids);
}
