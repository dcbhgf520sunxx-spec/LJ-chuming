package com.hzchum.scim.common.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import com.hzchum.scim.common.core.api.pojo.export.ApproveRecordDetailExportDTO;
import java.util.List;

public interface WmsApproveRecordService extends IService<WmsApproveRecord> {
   Boolean commonApproveStep(Long id, Integer decision, String opinion, String serialNumber, String jsonData);

   WmsApproveRecord createRecord(
      Long dataId,
      String dataSerialNumber,
      Integer approveProcessType,
      String cause,
      WmsApproveRecordDetail wmsApproveRecordDetail,
      String jsonData,
      Boolean mustCheck,
      MountMessageDTO mountMessageDTO,
      String subjoinMsg,
      String classifyOne
   );

   List<WmsApproveRecordDetail> getCheckDataIdList(Integer type);

   WmsApproveRecordFlowDTO getApproveRecordDTO(Long id);

   Boolean revocation(Long id);

   PageVO<WmsApproveRecordDTO> getList(
      WmsApproveRecordDTOParam wmsApproveRecordDTOParam, Integer pageNumber, Integer pageSize, List<String> sort, Integer facility
   );

   Integer getCanCheckCount(List<String> componentNameList);

   Integer getRejectedCanCheckCount(List<String> componentNameList);

   Integer getSubmitAndReview(List<String> componentNameList);

   Boolean judgeRewrite(Long id);

   List<ApproveRecordDetailExportDTO> getExport(Long id);

   String getSerialNumberById(Long id);

   String getApproveUserInfo(Long approveRecordId, String symbol);

   String createApproveSerialNumber(String tableNameKey);
}
