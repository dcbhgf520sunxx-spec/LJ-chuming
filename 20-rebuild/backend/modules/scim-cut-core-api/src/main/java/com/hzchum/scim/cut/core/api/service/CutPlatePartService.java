package com.hzchum.scim.cut.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlatePart;
import java.util.List;

public interface CutPlatePartService extends IService<CutPlatePart> {
   List getCutPart(String taskId);
}
