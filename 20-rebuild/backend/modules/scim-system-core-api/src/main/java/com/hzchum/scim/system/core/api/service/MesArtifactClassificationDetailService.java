package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassificationDetail;
import java.util.List;
import java.util.Map;

public interface MesArtifactClassificationDetailService extends IService<MesArtifactClassificationDetail> {
   Map<Long, Map<Integer, List<String>>> getNameAndTypeByArtifactClassificationIdList(List<Long> artifactClassificationIdList);

   Map<Integer, List<String>> getNameAndTypeByArtifactClassificationId(Long artifactClassificationId);

   Boolean removeByArtifactClassificationId(Long artifactClassificationId);
}
