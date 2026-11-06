package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Convert;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ConvertDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ConvertService extends IService<Convert> {
   PageVO<ConvertDTO> pageInfo(ConvertDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   ResultVO<ConvertDTO> convertDetail(Long id);

   void convertDetailExport(Long id, HttpServletResponse response, int type);

   void exportList(ConvertDTOParam param, HttpServletResponse response);

   Boolean saveConvert(SteelPlateOutboundDTOParam param);

   Boolean passed(Long id);

   Boolean convertReturn(Long id);

   Integer reviewedNum();

   ResultVO<List<ProjectConvertDTO>> getProjectConvert(ConvertDTOParam param);

   PageVO<ConvertDTO> pageInfoV2(ConvertDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   void exportListV2(ConvertDTOParam param, HttpServletResponse response);

   Integer reviewedNumV2(Boolean boolPartyA);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);
}
