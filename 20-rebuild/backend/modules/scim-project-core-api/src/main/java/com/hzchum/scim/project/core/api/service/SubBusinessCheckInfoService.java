package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckInfo;
import java.util.List;

public interface SubBusinessCheckInfoService extends IService<SubBusinessCheckInfo> {
   List listInfo(Long projectId, Integer status);

   PageVO pageInfo(Long projectId, Integer status, Integer pageNumber, Integer pageSize);

   Integer countList();
}
