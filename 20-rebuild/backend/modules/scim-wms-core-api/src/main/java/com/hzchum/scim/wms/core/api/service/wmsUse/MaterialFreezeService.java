package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialUnfreeze;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialFreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialFreezeRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialUnfreezeDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.FreezeDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryFreezeDetailsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UnfreezeDTOParam;
import java.util.List;

public interface MaterialFreezeService extends IService<MaterialFreeze> {
   PageVO<MaterialFreezeDTO> freezePageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer pageSize, List<String> sort);

   PageVO<MaterialFreezeRecordDTO> freezeRecordPageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer pageSize, List<String> sort);

   PageVO<MaterialFreezeDTO> getFreezeDetails(QueryFreezeDetailsDTOParam detailsDTOParam, Integer pageNum, Integer pageSize);

   List<MaterialFreeze> freezeListInfo(QueryByMaterialDTOParam param);

   PageVO<MaterialUnfreezeDTO> unfreezePageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer pageSize, List<String> sort);

   List<MaterialUnfreeze> unfreezeListInfo(QueryByMaterialDTOParam param);

   List<MaterialUnfreezeDTO> getUnfreezeDTOS(List<MaterialUnfreeze> list);

   ListVO<MaterialFreezeRecordDTO> getRecord(Long materialId);

   Boolean setUnfreeze(UnfreezeDTOParam param);

   void materialUnfreeze(Long id, Long detailId, Integer freezeType, boolean isOutboundDelete);

   Boolean ManualFreeze(FreezeDTOParam freezeDTOParam);

   boolean BatchManualFreeze(List<FreezeDTOParam> freezeDTOParams);

   MaterialFreezeDTO getNestingFreezeDetail(Long id);
}
