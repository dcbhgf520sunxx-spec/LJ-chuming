package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeImportImage;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeImportImagePageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeImportImageSaveParam;

public interface SysHomeImportImageBiz extends IBiz<SysHomeImportImage> {
   Boolean saveSysHomeImportImage(SysHomeImportImageSaveParam param);

   SysHomeImportImagePageDTO getSysHomeImportImagePage();
}
