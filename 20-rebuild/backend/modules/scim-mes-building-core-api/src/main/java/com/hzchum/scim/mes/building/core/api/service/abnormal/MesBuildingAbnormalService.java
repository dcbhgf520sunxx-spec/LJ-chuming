package com.hzchum.scim.mes.building.core.api.service.abnormal;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalProcessPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.MesBuildingAbnormalDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormal;
import com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal.MesBuildingAbnormalDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingAbnormalService extends IService<MesBuildingAbnormal> {
   List<MesBuildingAbnormalDTO> abnormalList(
      Long id, Integer productType, String projectName, String serialNumber, Integer status, Long projectId, Long monomerId, Long areaId, LocalDateTime date
   );

   PageVO<MesBuildingAbnormalDTO> abnormalPage(
      Long id,
      Integer productType,
      String projectName,
      String serialNumber,
      Integer status,
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime date,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   MesBuildingAbnormalDO selectDetailById(Long id);

   List<AbnormalProcessPreviewDO> changePreview(Long productId, Integer productType);

   List<AbnormalPreviewDO> preview(Long productId, Integer productType, Integer type);
}
