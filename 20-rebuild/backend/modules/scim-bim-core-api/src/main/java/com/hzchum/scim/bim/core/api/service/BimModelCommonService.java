package com.hzchum.scim.bim.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimEngineStatusResponseVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimModelCommonResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import java.util.List;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

public interface BimModelCommonService extends IService<BimModelCommonDO> {
   BimModelCommonResponseVO getModelByMonomer(Long monomerId);

   ListVO getModelByArea(Long monomerId);

   ResultVO uploadModel(MultipartFile file, Long monomerId, Long areaId, PlanApproveCacheObjectDTOParam cacheObjectDTOParam) throws Exception;

   ResultVO newUploadModel(MultipartFile file, Long monomerId, Long areaId, PlanApproveCacheObjectDTOParam cacheObjectDTOParam);

   void setTranslateStatusCallback(Long modelId, String token);

   BimEngineStatusResponseVO getTranslate(Long monomerId, Long areaId);

   Boolean delete(Long monomerId, Long areaId);

   List<String> getElementIds(String serialNumber, Long fileId);

   List<String> getBridgeElementIds(String serialNumber, Long fileId);

   Boolean modelIntegration(Set<Long> areaIds, Long monomerId);

   void setIntegrateStatusCallback(Long modelId, String areaIds, Long userId, String token);

   Boolean removeIntegration(Long monomerId);

   Integer selectSuccessQuantity(Long monomerId);

   BimEngineStatusResponseVO getModelInfoByFileId(Long fileId);

   Boolean migration();

   List<String> getArtifactElementIdList(String fileId, String serialNumber, String targetType);
}
