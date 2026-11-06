package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppRrtunrnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnableDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MaterialReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialReturnableDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateReturnDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface ReturnService extends IService<Return> {
   PageVO<ReturnableDTO> getReturnable(QueryMaterialReturnableDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean saveReturn(ValidList<MaterialReturnDTOParam> params);

   Boolean saveAppReturnV2(ValidList<MaterialReturnDTOParam> params);

   PageVO<ReturnDTO> getReturn(QueryReturnDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<ReturnDTO> getReturnList(QueryReturnDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   ReturnDTO getReturnDetailById(Long id);

   ReturnDTO getReturnDetailById2(Long id);

   PrintVO<List<ReturnDetailDTO>> returnPrint(Long id);

   List<Long> getIds(QueryReturnDTOParam param);

   Boolean passed(ReturnDTOParam param);

   Boolean returned(ReturnDTOParam param);

   Boolean updateReturn(UpdateReturnDTOParam param);

   Boolean detailByIds(List<Long> ids);

   List<MaterialInventoryDTO> getDetailByCondition(Integer basicClass, Long projectId, LocalDateTime startDate, LocalDateTime endDate);

   PageVO<ReturnableDTO> getReturnableV2(QueryMaterialReturnableDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Return outsourcingReturnable(ValidList<MaterialReturnDTOParam> params);

   Boolean directSubmitReviewOutsourcingReturnable(ValidList<MaterialReturnDTOParam> params);

   Boolean sourcingReturnApproval(ReturnDTOParam param, Long approveRecordId, Integer decision, String opinion);

   Boolean saveAppReturn(APPInboundDTOParam request);

   PageVO<AppRrtunrnDetailDTO> selectAppReturnDetailDTO(QueryInboundDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<ReturnableDTO> getAppReturnableList(APPInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   Boolean updateReturnV2(UpdateReturnDTOParam param);
}
