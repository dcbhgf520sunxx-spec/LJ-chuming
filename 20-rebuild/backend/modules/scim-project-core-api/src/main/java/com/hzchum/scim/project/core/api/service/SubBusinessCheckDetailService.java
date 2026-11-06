package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckDetail;
import com.hzchum.scim.project.core.api.pojo.dto.SubBusinessCheckDetailDTO;

public interface SubBusinessCheckDetailService extends IService<SubBusinessCheckDetail> {
   ListVO<SubBusinessCheckDetailDTO> listByCheckId(Long id);
}
