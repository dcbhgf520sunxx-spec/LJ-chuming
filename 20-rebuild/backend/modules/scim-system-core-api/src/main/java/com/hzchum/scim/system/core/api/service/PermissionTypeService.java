package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.PermissionType;
import com.hzchum.scim.system.core.api.pojo.request.PermissionTypeSaveVO;
import com.hzchum.scim.system.core.api.pojo.request.PermissionTypeUpdateVO;
import java.util.List;

public interface PermissionTypeService extends IService<PermissionType> {
   PageVO<PermissionType> listByBlurryName(String blurryName, Integer pageNumber, Integer pageSize);

   boolean deletePermissionType(List<Long> ids);

   boolean updatePermissionType(PermissionTypeUpdateVO updateVO);

   Long savePermissionType(PermissionTypeSaveVO saveVO);

   ListVO<PermissionType> listAll();
}
