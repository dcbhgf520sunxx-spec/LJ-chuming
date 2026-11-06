package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterial;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MoveMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MoveMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMoveMaterialDTOParam;
import java.util.List;

public interface MoveMaterialService extends IService<MoveMaterial> {
   PageVO<MoveMaterialDTO> pageInfo(QueryMoveMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   MoveMaterialDTO queryById(Long id);

   Boolean saveMoveMaterial(MoveMaterialDTOParam request);

   Boolean passed(Long id, String approvalComments);

   Boolean returned(Long id, String approvalComments);

   List<Long> getIds(QueryMoveMaterialDTOParam param);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);
}
