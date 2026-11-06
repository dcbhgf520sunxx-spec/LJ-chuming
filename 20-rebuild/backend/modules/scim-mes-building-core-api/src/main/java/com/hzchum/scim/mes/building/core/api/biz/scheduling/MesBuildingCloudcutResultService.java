package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutResultSendVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutResultVO;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface MesBuildingCloudcutResultService extends IService<MesBuildingCloudcutResult> {
   PageVO<MesBuildingCloudcutResultVO> pageMesBuildingCloudcutResult(MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO);

   String saveMesBuildingCloudcutResult(MultipartFile multipartFile, Long cloudcutId, Integer partType);

   MesBuildingCloudcutResultSendVO checkFile(MultipartFile multipartFile, Long cloudcutId);

   Integer updateMesBuildingCloudcutResult(MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO);

   String updateMesBuildingCloudcutResultStatus(List<MesBuildingCloudcutResultDTO> mesBuildingCloudcutResultDTOList);

   Boolean sendMesBuildingCloudcutResult(List<MesBuildingCloudcutResultDTO> mesBuildingCloudcutResultDTOList);

   Boolean deleteMesBuildingCloudcutResult(List<Long> idList);
}
