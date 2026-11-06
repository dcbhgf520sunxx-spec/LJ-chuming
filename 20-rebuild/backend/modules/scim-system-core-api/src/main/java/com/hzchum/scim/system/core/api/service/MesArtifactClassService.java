package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClass;
import com.hzchum.scim.system.core.api.pojo.request.MesArtifactClassDTO;
import java.util.List;

public interface MesArtifactClassService extends IService<MesArtifactClass> {
   Boolean saveMesArtifactClass(MesArtifactClassDTO mesArtifactClassDTO);

   Boolean updateMesArtifactClass(MesArtifactClass mesArtifactClass);

   Boolean deleteMesArtifactClassByIds(List<Long> idList);
}
