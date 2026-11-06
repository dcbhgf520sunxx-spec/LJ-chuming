package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactNumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.HoleRadiusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.IdsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.WeldMapDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.AreaDrawingDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.DownloadDrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.ProductDrawingsSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mark.WeldDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface TechDrawingService extends IService<TechDrawing> {
   ResultVO uploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   );

   ResultVO uploadAllFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   );

   ResultVO newUploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   );

   ResultVO newAllUploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   );

   List<TechDrawing> nestingUploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer dataType,
      Integer productType,
      String fileName,
      HttpServletResponse response
   );

   Boolean uploadFile(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      String suffix,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId
   );

   @Transactional(rollbackFor = Exception.class)
   void uploadPartFileZip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer productType,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   );

   String getFilePath(Long projectId, Long monomerId, Integer dataType, Integer productType, Integer projectType, Integer drawingMatchRange, Long areaId);

   Boolean newUpdateDrawing(Long id, MultipartFile multipartFile, String fileName, PlanApproveCacheObjectDTOParam cacheObjectDTOParam);

   ResultVO updateDrawing(Long id, MultipartFile multipartFile, String fileName, Long monomerId) throws Exception;

   PageVO<DrawingDTO> listDrawingByCondition(
      Long projectId,
      Long monomerId,
      String serialNumber,
      String fileName,
      Integer dataType,
      Integer productType,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   ResultVO deleteDrawings(List<Long> ids);

   void downloadFileByProduct(Integer projectType, Long productId, Integer productType, Integer number, String serialNumber, Long monomerId, Long areaId);

   void downloadFileByDrawing(Long drawingId);

   void downloadFileByMonomerId(Long projectId, Long monomerId, Long areaId, Integer dataType, Integer productType);

   Map<String, Object> checkDrawingExist(Integer projectType, Long productId, Integer productType);

   ArtifactNumDTO getArtifactDwgNum(Integer projectType, Long productId, Integer productType);

   PageVO<ProductDrawingsSummaryDTO> getArtifactDwg(
      Long projectId, Integer productType, Integer dataType, Integer steelPlateTypeEnum, Long monomerId, Long areaId, Integer pageSize, Integer pageNumber
   );

   void uploadXMLFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   );

   PageVO<AreaDrawingDetailsDTO> contrast(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Boolean sign,
      Integer steelPlateTypeEnum,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   void contrastDownload(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Boolean sign,
      Integer steelPlateTypeEnum,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO InstructionLink(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Integer drawingid,
      Integer pageNumber,
      Integer pageSize
   );

   ResultVO deleteDrawing(IdsDTO ids);

   ResultVO updateFile(
      Long productId,
      Integer productType,
      Integer dataType,
      MultipartFile multipartFile,
      Long projectid,
      Long monomerId,
      Long areaId,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) throws Exception;

   ResultVO newUpdateFile(
      Long productId,
      Integer productType,
      Integer dataType,
      MultipartFile multipartFile,
      Long projectid,
      Long monomerId,
      Long areaId,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) throws Exception;

   Boolean nestingUpdateFile(
      Long productId,
      Integer productType,
      Integer dataType,
      MultipartFile multipartFile,
      Long projectid,
      Long monomerId,
      Long areaId,
      HttpServletResponse response
   );

   Boolean deletefileByUrls(List<String> paths);

   String getFilePathByAssemble(Long monomerId, String serialNumber);

   List selectMachDrawing(List<Long> machinePartIds);

   Map<String, String> getDxfPictures(Long monomerId, Set<String> serialNumbers);

   Map<String, String> getDxfPicturesByArea(Long areaId, Set<String> serialNumbers);

   Map<String, List<TechDrawing>> getDrawingMap(Long monomerId, Integer dataType, Integer productType);

   Boolean checkDrawing(List<Long> productIds, Integer projectType, Integer productType);

   List bridgeSelectMachDrawing(List<Long> machinePartIds);

   Map<String, String> bridgeGetDxfPictures(Long monomerId, Set<String> serialNumbers);

   HoleRadiusDTO parseDrawing(String filePath, String fileName);

   String transformationDxf(String filePath, String fileName, String serialNumber, Integer imageType);

   ResultVO uploadZipFileChoose(MultipartFile multipartFile, Long projectId, Long monomerId, Integer dataType, Integer productType, String fileName) throws Exception;

   ResultVO newUploadZipFileChoose(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      HttpServletResponse response
   );

   Boolean uploadPartFileZipChoose(
      MultipartFile multipartFile, Long projectId, Long monomerId, Long areaId, Integer productType, PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   );

   void uploadXMLFileAndUnzipChoose(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   );

   void downloadDrawingPDF(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException;

   void downloadDrawingPDFFile(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, DownloadDrawingDTO drawingDTO, Integer taskTypeEnum, HttpServletResponse response
   ) throws IOException;

   void downloadAllDrawingPDFFile(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, DownloadDrawingDTO drawingDTO, Integer taskTypeEnum, HttpServletResponse response
   ) throws IOException;

   void downloadMachinePartDxfFile(Long projectId, Long monomerId, Long areaId);

   void downloadFileBySerialNumber(Integer projectType, String serialNumber, Integer productType, Integer number, Long monomerId, Long areaId);

   PageVO<WeldDetailsDTO> weldContrast(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Boolean sign,
      Integer steelPlateTypeEnum,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   void downloadWeldMark(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException;

   ResultVO deleteDeepenMark(List<IdsDTO> asList);

   ResultVO updateMarkFile(Long productId, Integer productType, Integer dataType, MultipartFile file, Long projectId, Long monomerId, Long areaId);

   void weldContrastDownload(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Boolean sign,
      Integer steelPlateTypeEnum,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   ResultVO newUploadWeldMapFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   );

   PageVO<WeldMapDetailsDTO> weldMapContrast(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Boolean sign,
      Integer steelPlateTypeEnum,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   void downloadWeldMap(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException;

   ResultVO deleteDeepenWeldMap(List<IdsDTO> asList);

   ResultVO updateMarkMapFile(Long productId, Integer productType, Integer dataType, MultipartFile file, Long projectId, Long monomerId, Long areaId);

   void weldMapContrastDownload(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Boolean sign,
      Integer steelPlateTypeEnum,
      String userName,
      Integer pageNumber,
      Integer pageSize
   );

   void downloadFileByMapProduct(Integer projectType, Long productId, Integer productType, Integer number, String serialNumber, Long monomerId, Long areaId);

   ArtifactNumDTO getArtifactMapDwgNum(Integer projectType, Long productId, Integer productType);

   void checkParam(MultipartFile multipartFile, Long projectId, Long monomerId, Integer dataType, Integer productType);

   Long getDataId(Long productId, Integer productType, Integer dataType, MultipartFile multipartFile, Long projectId, Long monomerId);
}
