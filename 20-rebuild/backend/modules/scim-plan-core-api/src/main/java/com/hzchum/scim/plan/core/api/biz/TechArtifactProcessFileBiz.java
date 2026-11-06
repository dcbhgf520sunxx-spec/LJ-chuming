package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFile;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactClassSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactProcessFileAttachmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSnDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileLinkDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactProcessFileBindDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileEditDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileSaveDTOParam;
import java.util.List;

public interface TechArtifactProcessFileBiz extends IBiz<TechArtifactProcessFile> {
   PageVO<TechArtifactProcessFileDTO> pageListProcessFileByCondition(TechArtifactProcessFileQueryDTOParam param, Integer pageNumber, Integer pageSize);

   ResultVO saveProcessFile(TechArtifactProcessFileSaveDTOParam param) throws RuntimeException;

   ResultVO newSaveProcessFile(TechArtifactProcessFileSaveDTOParam param);

   Boolean updateProcessFile(TechArtifactProcessFileEditDTOParam param);

   Boolean deleteList(List<Long> ids);

   List<ArtifactClassSummaryDTO> listClassSnQuantity(Integer processType, Boolean boolBindStatus, Long projectId, Long monomerId);

   List<ArtifactSnDTO> listArtifactSn(
      Long projectId,
      Long monomerId,
      Long processFileId,
      Boolean boolBindStatus,
      String name,
      String serialNumber,
      String specification,
      String material,
      String structureClassIds
   );

   Boolean bindArtifactProcessFile(ArtifactProcessFileBindDTOParam param);

   PageVO<TechArtifactProcessFileLinkDTO> listBindByCondition(
      Long processFileId,
      Long projectId,
      Long monomerId,
      Long structureClassId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean unbind(ArtifactProcessFileBindDTOParam param);

   Boolean unbindAllArtifact(Long processFileId);

   List<ArtifactProcessFileAttachmentDTO> listAttachment(Long monomerId, String serialNumber);
}
