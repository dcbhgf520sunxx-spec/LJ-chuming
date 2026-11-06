package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.ClassificationCheckDTO;
import com.hzchum.scim.common.core.api.pojo.common.IdsStatusDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.ClassifySpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectSpecMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectTreeDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.ClassificationDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ClassificationService extends IService<Classification> {
   List<SubjectTreeDTO> treeNew(Boolean status);

   List<SubjectTreeDTO> tree(Integer type);

   void exportClassificationList(HttpServletResponse response);

   boolean batchAddSubject(List<ClassificationDTOParam> classificationDTOParams);

   boolean delete(List<Long> ids);

   List<SubjectSpecMeasureDTO> detailTree();

   String getFullPath(Long subjectId, String symbol);

   String getFullPath(String idPath, String symbol);

   List<Classification> getLastSubject(Long subjectId);

   List<Classification> getLastSubjectNew(Long subjectId);

   List<Long> getClassifyIdsByName(List<String> classifyName);

   List<SubjectSpecMeasureDTO> getByBasicClass(Long basicClass);

   Map<Integer, List<Classification>> getMaterialClassification(Long basicClass);

   Map<Integer, List<Classification>> getPurchaseClassification(Long basicClass);

   List<Classification> getMaterialClassificationLevel(Long basicClass);

   ClassifySpecDTO getClassifyById(Long id);

   List<ClassifySpecDTO> getClassifyListByIds(List<Long> ids);

   void excel(MultipartFile file);

   Boolean updateClassify(List<ClassificationDTOParam> dtoParams);

   Boolean updateClassifyStatus(IdsStatusDTO dto);

   Boolean updateClassifyUsed(IdsStatusDTO dto);

   Boolean deleteDataUpdateClass(IdsStatusDTO dto);

   Classification getClassificationById(Long id);

   Map<Long, Classification> getClassificationByIds(List<Long> ids);

   Map<Long, Classification> checkClassification(List<ClassificationCheckDTO> classificationCheckDTOS, LocalDateTime clickTime);

   void exportClassificationListV2(HttpServletResponse response);

   void updateClassifyUpdateStatus();

   List<Classification> getClassificationByBasicClassAndUnit(Integer basicClass, String unit);

   Map<Long, String> getClassFullPathNameMap(List<Long> ids, String symbol);

   Classification getSteelPlateByColorRollId(Long classifyId);
}
