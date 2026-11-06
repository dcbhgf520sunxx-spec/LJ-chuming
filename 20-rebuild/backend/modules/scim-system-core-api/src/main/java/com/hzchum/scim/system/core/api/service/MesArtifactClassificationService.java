package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassification;
import com.hzchum.scim.system.core.api.pojo.dto.MesArtifactClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesArtifactClassificationSaveDTOParam;
import java.util.List;

public interface MesArtifactClassificationService extends IService<MesArtifactClassification> {
   List<MesArtifactClassificationDTO> listInfo();

   MesArtifactClassificationDTO detailById(Long id);

   Boolean saveArtifactClassification(MesArtifactClassificationSaveDTOParam param);

   Boolean editArtifactClassification(MesArtifactClassificationSaveDTOParam param);

   Boolean deleteById(Long id);

   List<MesArtifactClassificationDTO> listInfoByIds(List<Long> idList);
}
