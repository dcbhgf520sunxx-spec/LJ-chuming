package com.hzchum.scim.plan.core.api.biz.change;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ZnTechChangeImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeCheckDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeSaveDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechChangeRecordBiz extends IBiz<TechChangeRecord> {
   PageVO<ArtifactResponseDTO> pageListArtifact(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer artifactType,
      String name,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   TechChangeImportDTO importChangeArtifactList(Long monomerId, MultipartFile multipartFile);

   ZnTechChangeImportDTO importChangeArtifactListV2(Long monomerId, MultipartFile multipartFile, HttpServletResponse response);

   List<TechArtifactChangeDetailDTO> listChangeArtifactDetail(TechChangeQueryDtoParam param);

   List<TechChangeMachinePartDTO> listMachinePart(Long monomerId, String serialNumber);

   Boolean commitChangeRecord(TechChangeSaveDtoParam param);

   Boolean commitChangeRecordV2(TechChangeSaveDtoParam param);

   PageVO<TechChangeRecordDTO> pageListChangeRecord(TechChangeRecordQueryVoParam param, Integer pageNumber, Integer pageSize);

   Boolean checkChange(TechChangeCheckDtoParam param);

   void importListDirectChange(
      Long monomerId, Long areaId, Integer inventoryTypeEnum, Long changeReasonId, String remark, MultipartFile file, HttpServletResponse response
   );

   void exportChangeRecord(TechChangeRecordQueryVoParam param, Integer pageNumber, Integer pageSize, HttpServletResponse response);
}
