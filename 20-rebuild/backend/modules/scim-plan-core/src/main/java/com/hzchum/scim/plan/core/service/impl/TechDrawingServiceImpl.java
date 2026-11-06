package com.hzchum.scim.plan.core.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.aliyun.oss.OSS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.nesting.NC1.NC1Parser;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.DXFUploadFailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.PicturePathDTO;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductWeldingMapBiz;
import com.hzchum.scim.plan.core.api.biz.approve.TechnologicalAchievementBiz;
import com.hzchum.scim.plan.core.api.enums.CappCraftTypeEnum;
import com.hzchum.scim.plan.core.api.enums.DataOperationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ImageTypeEnums;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.PlanFileOverlayEnum;
import com.hzchum.scim.plan.core.api.enums.SourcePartEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanTechnologicalAchievementApproveRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductWelding;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductWeldingMap;
import com.hzchum.scim.plan.core.api.pojo._do.TechDataLog;
import com.hzchum.scim.plan.core.api.pojo._do.TechDataLogLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactNumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldingJsonObjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.HoleRadiusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.IdsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechCappCraftCardProductWeldingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechCappCraftCardProductWeldingMapDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechDrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.WeldMapDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.AreaDrawingDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.DownloadDrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.InstructionLinkDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.ProductDrawingsSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.ProductDrawingsSummaryDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mark.WeldDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.PlanTechnologicalAchievementApproveRecordService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductLinkService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductWeldingService;
import com.hzchum.scim.plan.core.api.service.TechDataLogLinkService;
import com.hzchum.scim.plan.core.api.service.TechDataLogService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.DxfUtils;
import com.hzchum.scim.plan.core.api.util.OssUtils;
import com.hzchum.scim.plan.core.api.util.PlanFileUtils;
import com.hzchum.scim.plan.core.biz.impl.utils.ZIPUtils;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardProductWeldingMapMapper;
import com.hzchum.scim.plan.core.mapper.TechDrawingMapper;
import com.hzchum.scim.plan.core.utils.CorrectDXF;
import com.hzchum.scim.system.core.api.common.enums.SysDrawingRecognitionRulesEnums;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo._do.DrawingRecognitionRules;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysDrawingRecognitionRulesService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechDrawingServiceImpl extends ServiceImpl<TechDrawingMapper, TechDrawing> implements TechDrawingService {
   private static final Logger log = LoggerFactory.getLogger(TechDrawingServiceImpl.class);
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private TechDataLogService dataLogService;
   @Resource
   private TechDataLogLinkService dataLogLinkService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private OssUtils ossUtils;
   @Resource
   private SysDrawingRecognitionRulesService sysDrawingRecognitionRulesService;
   @Resource
   private TechMachineHoleRadiusLinkService machineHoleRadiusLinkService;
   @Resource
   private MesBuildingNestCutPlatePartService mesBuildingNestCutPlatePartService;
   @Resource
   private MesBuildingMachinePartSchedulingLinkService mesBuildingMachinePartSchedulingLinkService;
   @Resource
   private TechnologicalAchievementBiz achievementBiz;
   @Resource
   private HttpServletResponse response;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private PlanTechnologicalAchievementApproveRecordService recordService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private TechCappCraftCardProductLinkService techCappCraftCardProductLinkService;
   @Resource
   private TechCappCraftCardProductWeldingService techCappCraftCardProductWeldingService;
   @Resource
   private PlanAreaService areaService;
   @Value("${chum.config.url}")
   private String ip;
   @Resource
   private ConfigService configService;
   @Resource
   private TechCappCraftCardProductWeldingMapBiz techCappCraftCardProductWeldingMapBiz;
   @Resource
   private TechCappCraftCardProductWeldingMapMapper techCappCraftCardProductWeldingMapMapper;

   @Override
   public PageVO<DrawingDTO> listDrawingByCondition(
      Long projectId,
      Long monomerId,
      String serialNumber,
      String fileName,
      Integer dataType,
      Integer productType,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      ContractProject project = this.projectService.getById(projectId);
      project.setProjectType(ProjectTypeEnum.MES.getType());
      Preconditions.checkArgument(project != null, "项目不存在");
      String conditions = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, conditions);
      List<DrawingDTO> drawingResponseVOS = this.baseMapper
         .listByConditions(projectId, monomerId, serialNumber, fileName, project.getProjectType(), dataType, productType);
      if (CollectionUtils.isNotEmpty(drawingResponseVOS)) {
         drawingResponseVOS.forEach(vo -> {
            String absolutePath = this.configProperties.getFilePath() + vo.getFilePath() + vo.getFileName();
            vo.setAbsolutePath(absolutePath);
            if (vo.getNumber() != null && vo.getNumber() != 0) {
               vo.setSerialNumber(vo.getSerialNumber() + "_" + vo.getNumber());
            }
         });
      }

      return new PageVO<>(drawingResponseVOS);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO newUploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   ) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      if ("zip".equalsIgnoreCase(suffix)) {
         ContractProject project = this.projectService.getById(projectId);
         boolean flag = true;
         List<String> fileNameList = null;
         String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, areaId);
         String absolutePath = this.configProperties.getFilePath() + filePath;
         FileUtil.mkdirs(absolutePath);
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
         File destinationFile = new File(absolutePath, originalFilename);

         try {
            copyTheFileToANewPath(multipartFile, destinationFile);
            fileNameList = this.unzipFileByMark(destinationFile, absolutePath);
         } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传过程发生错误", e);
         }

         if (CollectionUtils.isNotEmpty(fileNameList)) {
            Map<String, List<String>> map = fileNameList.stream().collect(Collectors.groupingBy(item -> (String)item));
            map.forEach((k, v) -> Preconditions.checkArgument(v.size() == 1, k + "文件重复,请剔除!!!"));

            for (String name : fileNameList) {
               if (!"mark".equalsIgnoreCase(FileUtil.getFileExtension(name))) {
                  flag = false;
               }
            }
         }

         if (!flag
            || !dataType.equals(TechDataTypeEnum.DEEPEN.getType())
            || !productType.equals(ProductTypeEnum.ARTIFACT.getType()) && !productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
               Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "产品类型不存在!");
               Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
               this.uploadPartFileZip(multipartFile, projectId, monomerId, productType, cacheObjectDTOParam, areaId, response);
            } else if (dataType.equals(TechDataTypeEnum.XML_FILE.getType())) {
               this.uploadXMLFileAndUnzip(multipartFile, projectId, monomerId, dataType, productType, fileName, cacheObjectDTOParam);
            } else {
               this.uploadFileZip(multipartFile, projectId, monomerId, dataType, productType, fileName, cacheObjectDTOParam);
            }
         } else {
            fileNameList.forEach(item -> {
               MultipartFile muFile = null;

               try (FileInputStream fileInputStream = new FileInputStream(new File(absolutePath + item))) {
                  muFile = new MockMultipartFile("file", new File(absolutePath + item).getName(), "application/octet-stream", fileInputStream);
                  fileInputStream.close();
               } catch (Exception e) {
                  throw new RuntimeException(e);
               }

               this.uploadMarkFile(muFile, projectId, monomerId, dataType, productType, item, absolutePath + item, areaId);
            });
         }
      } else if (!"mark".equalsIgnoreCase(suffix)
         || !dataType.equals(TechDataTypeEnum.DEEPEN.getType())
         || !productType.equals(ProductTypeEnum.ARTIFACT.getType()) && !productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         this.uploadFile(multipartFile, projectId, monomerId, dataType, productType, fileName, suffix, cacheObjectDTOParam, areaId);
      } else {
         this.uploadMarkFile(multipartFile, projectId, monomerId, dataType, productType, fileName, null, areaId);
      }

      return ResultVO.builder().message("上传成功").build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO newAllUploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   ) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      if ("zip".equalsIgnoreCase(suffix)) {
         ContractProject project = this.projectService.getById(projectId);
         List<String> fileNameList = null;
         String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, areaId);
         String absolutePath = this.configProperties.getFilePath() + filePath;
         FileUtil.mkdirs(absolutePath);
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
         File destinationFile = new File(absolutePath, originalFilename);

         try {
            copyTheFileToANewPath(multipartFile, destinationFile);
            fileNameList = this.unzipFileByMark(destinationFile, absolutePath);
         } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传过程发生错误", e);
         }

         if (CollectionUtils.isNotEmpty(fileNameList)) {
            Map<String, List<String>> map = fileNameList.stream().collect(Collectors.groupingBy(item -> (String)item));
            map.forEach((k, v) -> Preconditions.checkArgument(v.size() == 1, k + "文件重复,请剔除!!!"));
         }

         this.uploadAllFileZip(multipartFile, projectId, monomerId, dataType, productType, fileName, cacheObjectDTOParam);
      }

      return ResultVO.builder().message("上传成功").build();
   }

   private static void copyTheFileToANewPath(MultipartFile multipartFile, File destinationFile) {
      try (InputStream inputStream = multipartFile.getInputStream()) {
         Files.copy(inputStream, destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
         if (!destinationFile.exists() || destinationFile.length() == 0L) {
            throw new IOException("文件保存失败");
         }
      } catch (IOException e) {
         log.error("文件传输失败: {}", e.getMessage());
         throw new BusinessException("文件上传失败，请重试");
      }
   }

   public void deleteDirectoryRecursively(String directoryPath) throws IOException {
      Path dir = Paths.get(directoryPath);
      Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
         public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Files.delete(file);
            return FileVisitResult.CONTINUE;
         }

         public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
         }
      });
   }

   private void deleteMarkTypeFile(String absolutePath, File destinationFile) {
      if (destinationFile.exists()) {
         boolean delete = destinationFile.delete();
         System.out.println(delete);
      }
   }

   private List<String> unzipFileByMark(File file, String targetPath) throws IOException {
      Preconditions.checkArgument(file != null && file.getName().endsWith(".zip"), "请传入zip格式压缩文件!");
      List<String> fileNameList = new ArrayList<>();
      FileOutputStream fos = null;
      InputStream is = null;

      try (ZipFile zipFile = new ZipFile(file, Charset.forName("gbk"))) {
         Enumeration<?> entries = zipFile.entries();

         while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            if (!entry.isDirectory()) {
               System.out.println("解压>>>>>>>>>>>>" + entry.getName());
               String fileName = entry.getName().substring(entry.getName().lastIndexOf("/") + 1);
               fileName = this.transformLowercaseSuffix(fileName);
               fileNameList.add(fileName);
               File targetFile = new File(targetPath + fileName);
               is = zipFile.getInputStream(entry);
               fos = new FileOutputStream(targetFile);
               byte[] buf = new byte[1024];

               int len;
               while ((len = is.read(buf)) != -1) {
                  fos.write(buf, 0, len);
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (fos != null) {
            fos.close();
         }

         if (is != null) {
            is.close();
         }
      }

      return fileNameList;
   }

   private void uploadMarkFile(
      MultipartFile multipartFile, Long projectId, Long monomerId, Integer dataType, Integer productType, String fileName, String filePath, Long areaId
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "导入失败，项目不存在");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingService
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
               .eq(TechCappCraftCardProductWelding::getProjectId, projectId)
               .eq(TechCappCraftCardProductWelding::getSerialNumber, fileName.substring(0, fileName.lastIndexOf(".")))
               .eq(TechCappCraftCardProductWelding::getMonomerId, monomerId)
               .eq(TechCappCraftCardProductWelding::getDataType, dataType)
               .eq(TechCappCraftCardProductWelding::getProductType, productType)
         );
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(128);
      if (CollectionUtils.isNotEmpty(techCappCraftCardProductWeldings)) {
         techCappCraftCardProductWeldings.forEach(
            item -> {
               List<TechCappCraftCardProductLink> cappCraftCardProductLinks = this.techCappCraftCardProductLinkService
                  .list(
                     Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
                        .eq(TechCappCraftCardProductLink::getMonomerId, monomerId)
                        .eq(TechCappCraftCardProductLink::getProductSerialNumber, item.getSerialNumber())
                  );
               Preconditions.checkArgument(CollectionUtils.isEmpty(cappCraftCardProductLinks), "【" + item.getSerialNumber() + "】产品已经存在工艺绑定信息");
            }
         );
      }

      if (!CollectionUtils.isEmpty(mistakeExportDTOList)) {
         this.exportResult(mistakeExportDTOList, this.response);
      } else {
         Map<String, List<TechCappCraftCardProductWelding>> map = this.techCappCraftCardProductWeldingService
            .list(
               Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
                  .eq(TechCappCraftCardProductWelding::getProjectId, projectId)
                  .eq(TechCappCraftCardProductWelding::getMonomerId, monomerId)
                  .eq(TechCappCraftCardProductWelding::getDataType, dataType)
                  .eq(TechCappCraftCardProductWelding::getProductType, productType)
            )
            .stream()
            .collect(Collectors.groupingBy(TechCappCraftCardProductWelding::getSerialNumber));
         List<Long> needDeleteIds = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(map)) {
            List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldingList = map.get(fileName.substring(0, fileName.lastIndexOf(".")));
            if (CollectionUtils.isNotEmpty(techCappCraftCardProductWeldingList)) {
               needDeleteIds.addAll(techCappCraftCardProductWeldingList.stream().map(TechCappCraftCardProductWelding::getId).collect(Collectors.toList()));
            }
         }

         new ArrayList();

         List<CappCraftCardProductWeldingJsonObjectDTO> var22;
         try {
            String fileContent = new String(multipartFile.getBytes());
            if (fileContent.trim().isEmpty()) {
               throw new IllegalArgumentException("文件内容为空，无法解析JSON");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            var22 = objectMapper.readValue(
               fileContent, objectMapper.getTypeFactory().constructCollectionType(List.class, CappCraftCardProductWeldingJsonObjectDTO.class)
            );
         } catch (Exception e) {
            throw new RuntimeException("解析失败", e);
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(var22), fileName + "文件内容为空，无法解析焊缝编号信息!!!!");
         if (org.apache.commons.lang3.StringUtils.isBlank(filePath)) {
            String originalFilename = multipartFile.getOriginalFilename();
            Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
            filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, areaId);
            String absolutePath = this.configProperties.getFilePath() + filePath;
            FileUtil.mkdirs(absolutePath);
            File destinationFile = new File(absolutePath, originalFilename);

            try {
               multipartFile.transferTo(destinationFile);
            } catch (IOException e) {
               e.printStackTrace();
               throw new RuntimeException("文件上传过程发生错误", e);
            }
         }

         if (CollectionUtils.isNotEmpty(var22)) {
            var22.forEach(item -> Preconditions.checkArgument(item.getMarkName() != null, "解析失败:【" + fileName + "】文件中缺少焊缝信息!!!!!"));
            Map<String, List<CappCraftCardProductWeldingJsonObjectDTO>> cappCraftCardProductWeldingJsonObjectMap = var22.stream()
               .collect(Collectors.groupingBy(CappCraftCardProductWeldingJsonObjectDTO::getMarkName));
            cappCraftCardProductWeldingJsonObjectMap.forEach((k, v) -> {
               if (CollectionUtil.isNotEmpty(v) && v.size() > 1) {
                  Preconditions.checkArgument(CollectionUtil.isNotEmpty(v), "解析失败:【" + fileName + "】文件中缺少焊缝信息");
                  Preconditions.checkArgument(v.size() == 1, fileName + "文件中焊缝编号【" + k + "】字段重复");
               }
            });
            if (CollectionUtils.isNotEmpty(needDeleteIds)) {
               this.techCappCraftCardProductWeldingService.removeByIds(needDeleteIds);
            }

            List<TechCappCraftCardProductWelding> needSaveTechCappCraftCardProductWeldingList = new ArrayList<>();
            String finalFilePath = filePath;
            var22.forEach(
               item -> needSaveTechCappCraftCardProductWeldingList.add(
                  TechCappCraftCardProductWelding.builder()
                     .projectId(projectId)
                     .monomerId(monomerId)
                     .fileName(fileName)
                     .filePath(finalFilePath)
                     .serialNumber(fileName.substring(0, fileName.lastIndexOf(".")))
                     .projectType(project.getProjectType())
                     .weldingSerialNumber(item.getMarkName())
                     .createUserId(UserUtil.getCurrentUserId())
                     .craftType(CappCraftTypeEnum.WELDING.getType())
                     .productType(productType)
                     .dataType(dataType)
                     .build()
               )
            );
            this.techCappCraftCardProductWeldingService.saveBatch(needSaveTechCappCraftCardProductWeldingList);
         }
      }
   }

   private MistakeExportDTO getMistakeDTO(Integer orderNo, String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(orderNo);
      mistake.setErrorMessage(message);
      return mistake;
   }

   private void exportResult(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (mistakeExportDTOList.isEmpty()) {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("全部导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      } else {
         ExportParams params = new ExportParams();
         params.setTitle("焊缝编号导入出错信息");
         params.setSheetName("焊缝编号导入失败表");
         params.setType(ExcelType.XSSF);
         String fileName = "焊缝编号导入失败信息表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("导入失败，具体信息请查看失败信息表", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         Workbook workbook = ExcelExportUtil.exportExcel(params, MistakeExportDTO.class, mistakeExportDTOList);
         PoiUtils.downLoadExcel(fileName, response, workbook);
         throw new BusinessException(ResultCodeEnum.ERROR, "导入失败!");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<TechDrawing> nestingUploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer dataType,
      Integer productType,
      String fileName,
      HttpServletResponse response
   ) {
      List<TechDrawing> techDrawingList = new ArrayList<>();
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument(suffix.equalsIgnoreCase("zip"), "覆盖失败，上传文件格式只支持zip文件!");
      if ("zip".equalsIgnoreCase(suffix) && dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "产品类型不存在!");
         Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
         techDrawingList = this.nestingUploadPartFileZip(multipartFile, projectId, monomerId, areaId, productType, response);
         techDrawingList.forEach(techDrawing -> techDrawing.setSerialNumber(techDrawing.getSerialNumber().trim()));
      }

      return techDrawingList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean uploadFile(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      String suffix,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId
   ) {
      Long drawingId = null;
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      project.setProjectType(ProjectTypeEnum.MES.getType());
      PlanMonomer monomer = null;
      PlanArea area = null;
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), drawingMatchRange, areaId);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(!originalFilename.contains(" "), "文件名不能包含空格");
      originalFilename = this.transformLowercaseSuffix(originalFilename);
      String serialNumber = originalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
      originalFilename = originalFilename.replaceAll(" ", "");
      FileUtil.mkdirs(absolutePath);
      if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
         }

         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            new ArrayList();
            List<Long> drawing = this.techAssembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).eq(TechAssemble::getInitialSerialNumber, serialNumber))
               .stream()
               .distinct()
               .filter(s -> serialNumber.equals(s.getInitialSerialNumber()))
               .map(TechAssemble::getId)
               .collect(Collectors.toList());
            this.checkDrawing(drawing, project.getProjectType(), productType);
            Preconditions.checkArgument("nc1".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "部件图纸格式不正确!");

            try {
               File file = new File(absolutePath + originalFilename);
               multipartFile.transferTo(file);
            } catch (IOException e) {
               e.printStackTrace();
            }

            TechDrawing drawingx = this.baseMapper
               .selectOne(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(TechDrawing::getProductType, productType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .eq(TechDrawing::getSerialNumber, serialNumber)
               );
            BigDecimal Nc1Length = BigDecimal.ZERO;

            try {
               Nc1Length = BigDecimal.valueOf(NC1Parser.getAssembleRealLength(absolutePath + originalFilename));
            } catch (IOException e) {
               e.printStackTrace();
               Preconditions.checkArgument(false, "图纸解析异常,请重新导入");
            }

            if (drawingx != null) {
               drawingx.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
               drawingx.setCreateTime(LocalDateTime.now());
               drawingx.setMonomerId(monomerId);
               drawingx.setNc1Length(Nc1Length);
               this.baseMapper.updateById(drawingx);
            } else {
               drawingx = TechDrawing.builder()
                  .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                  .projectId(projectId)
                  .monomerId(monomerId)
                  .serialNumber(serialNumber)
                  .productType(productType)
                  .nc1Length(Nc1Length)
                  .filePath(filePath)
                  .fileName(originalFilename)
                  .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                  .build();
               this.baseMapper.insert(drawingx);
            }

            drawingId = drawingx.getId();
            List<TechAssemble> techAssembles = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).eq(TechAssemble::getInitialSerialNumber, serialNumber));
            if (CollectionUtils.isNotEmpty(techAssembles)) {
               BigDecimal finalNc1Length = Nc1Length;
               List<TechAssemble> collect = techAssembles.stream()
                  .map(s -> s.setBoolHaveNC1(Boolean.TRUE))
                  .map(e -> e.setNc1Length(finalNc1Length))
                  .collect(Collectors.toList());
               this.assembleService.updateBatchById(collect);
            }
         }

         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               area = this.areaService.getById(areaId);
               Preconditions.checkArgument(area != null, "导入失败，区域不存在");
            }

            List<String> originalFilenameList = new ArrayList<>();
            originalFilenameList.add(originalFilename);
            Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "零件图纸格式不正确!");
            if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
               List<TechMachinePart> machineParts = this.machinePartService
                  .list(
                     Wrappers.lambdaQuery(TechMachinePart.class)
                        .eq(TechMachinePart::getMonomerId, monomerId)
                        .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                        .eq(TechMachinePart::getSerialNumber, serialNumber)
                  );
               if (CollectionUtils.isNotEmpty(machineParts)) {
                  List<TechMachinePart> wingWebPlateList = machineParts.stream()
                     .filter(
                        e -> e.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                           && !e.getSourcePartEnum().equals(SourcePartEnum.DIRECTLY_IMPORT.getType())
                     )
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(wingWebPlateList)) {
                     List<String> initialSerialNumbers = wingWebPlateList.stream()
                        .map(TechMachinePart::getInitialSerialNumber)
                        .distinct()
                        .collect(Collectors.toList());
                     Map<String, List<TechMachinePart>> machinePartMap = this.machinePartService
                        .list(
                           Wrappers.lambdaQuery(TechMachinePart.class)
                              .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                              .eq(TechMachinePart::getMonomerId, monomerId)
                              .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                              .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                              .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_DISASSEMBLY.getType())
                              .in(TechMachinePart::getInitialSerialNumber, initialSerialNumbers)
                              .notIn(TechMachinePart::getSerialNumber, initialSerialNumbers)
                        )
                        .stream()
                        .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
                     Map<String, List<TechMachinePart>> wingWebPlateListMap = wingWebPlateList.stream()
                        .collect(Collectors.groupingBy(e -> e.getSourcePartEnum() + "#" + e.getInitialSerialNumber()));
                     wingWebPlateListMap.forEach(
                        (initialSerialNumberAndSourcePartEnum, partList) -> {
                           Integer sourcePartEnum = Integer.valueOf(initialSerialNumberAndSourcePartEnum.split("#")[0]);
                           String initialSerialNumber = initialSerialNumberAndSourcePartEnum.split("#")[1];
                           if (SourcePartEnum.COMPONENT_DISASSEMBLY.getType().equals(sourcePartEnum)) {
                              List<TechMachinePart> machinePartList = partList.stream()
                                 .filter(e -> !e.getSerialNumber().equals(initialSerialNumber) && e.getSourcePartEnum().equals(sourcePartEnum))
                                 .collect(Collectors.toList());
                              if (CollectionUtils.isEmpty(machinePartList)) {
                                 List<TechMachinePart> techMachineParts = machinePartMap.get(initialSerialNumber);
                                 if (CollectionUtils.isNotEmpty(techMachineParts)) {
                                    List<String> serialNumbers = techMachineParts.stream()
                                       .map(TechMachinePart::getSerialNumber)
                                       .distinct()
                                       .collect(Collectors.toList());
                                    if (serialNumbers.size() == 1) {
                                       machineParts.addAll(techMachineParts);
                                       originalFilenameList.add(serialNumbers.get(0) + ".dxf");
                                    }
                                 }
                              } else {
                                 machinePartList.forEach(e -> e.setBoolItsOwnDrawing(Boolean.TRUE));
                                 this.machinePartService.updateBatchById(machinePartList);
                              }
                           }
                        }
                     );
                  }
               }

               List<TechMachinePart> componentCombinationPartList = this.machinePartService
                  .list(
                     Wrappers.lambdaQuery(TechMachinePart.class)
                        .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        .eq(TechMachinePart::getMonomerId, monomerId)
                        .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                        .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                        .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_COMBINATION.getType())
                        .eq(TechMachinePart::getInitialSerialNumber, serialNumber)
                  );
               if (CollectionUtils.isNotEmpty(componentCombinationPartList)) {
                  machineParts.addAll(componentCombinationPartList);

                  for (String componentCombinationPart : componentCombinationPartList.stream()
                     .map(TechMachinePart::getSerialNumber)
                     .distinct()
                     .collect(Collectors.toList())) {
                     originalFilenameList.add(componentCombinationPart + ".dxf");
                  }
               }

               List<Long> productIds = machineParts.stream().map(TechMachinePart::getId).distinct().collect(Collectors.toList());
               this.checkDrawing(productIds, project.getProjectType(), productType);
            }

            File file = null;

            try {
               file = new File(absolutePath + originalFilename);
               multipartFile.transferTo(file);
               CorrectDXF.resolverDXFForImport(file);
            } catch (Exception e) {
               throw new IllegalArgumentException(e.getMessage());
            }

            for (String newOriginalFilename : originalFilenameList) {
               String newSerialNumber = newOriginalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
               if (!newOriginalFilename.equals(originalFilename)) {
                  try {
                     Files.copy(file.toPath(), Paths.get(absolutePath + newOriginalFilename), StandardCopyOption.COPY_ATTRIBUTES);
                  } catch (IOException e) {
                     throw new RuntimeException(e);
                  }
               }

               String ossRelativePath = projectId + "/" + monomerId + "/" + newOriginalFilename;
               if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                  ossRelativePath = projectId + "/" + monomerId + "/" + areaId + "/" + newOriginalFilename;
               }

               String localAbsoluteFilePath = absolutePath + newOriginalFilename;
               OSS client = this.ossUtils.openClient();
               String dxfUrl = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
               this.setMachinePartPath(project, monomerId, newSerialNumber, dxfUrl, ossRelativePath, drawingMatchRange, areaId);
               TechDrawing drawing = this.baseMapper
                  .selectOne(
                     Wrappers.lambdaQuery(TechDrawing.class)
                        .eq(TechDrawing::getProjectId, projectId)
                        .isNull(
                           project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()),
                           TechDrawing::getProductType
                        )
                        .eq(TechDrawing::getMonomerId, monomerId)
                        .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                        .eq(TechDrawing::getSerialNumber, newSerialNumber)
                  );
               if (drawing != null) {
                  drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                  drawing.setCreateTime(LocalDateTime.now());
                  drawing.setCloudPath(dxfUrl);
                  String drawingUrl = this.transformationDxf(drawing.getFilePath(), drawing.getFileName(), drawing.getSerialNumber(), 1);
                  drawing.setPicturePath(drawingUrl);
                  this.baseMapper.updateById(drawing);
               } else {
                  drawing = TechDrawing.builder()
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .projectId(projectId)
                     .projectType(project.getProjectType())
                     .productType(null)
                     .monomerId(monomerId)
                     .serialNumber(newSerialNumber)
                     .filePath(filePath)
                     .cloudPath(dxfUrl)
                     .fileName(newOriginalFilename)
                     .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                     .build();
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     drawing.setAreaId(areaId);
                  }

                  this.baseMapper.insert(drawing);
                  String drawingUrl = this.transformationDxf(drawing.getFilePath(), drawing.getFileName(), drawing.getSerialNumber(), 1);
                  drawing.setPicturePath(drawingUrl);
                  this.baseMapper.updateById(drawing);
               }

               drawingId = drawing.getId();
               this.updateRadius(drawing);
            }
         }
      }

      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         Preconditions.checkArgument("dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
            }

            Map<String, Object> map;
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               map = this.getSerialAndOrder(serialNumber, rules.getType());
            } else {
               map = new HashMap<>();
            }

            this.setDrawingArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);

            try {
               File file = new File(absolutePath + originalFilename);
               multipartFile.transferTo(file);
            } catch (IOException e) {
               e.printStackTrace();
            } finally {
               System.gc();
            }

            QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("project_id", projectId)
               .eq("monomer_id", monomerId)
               .eq("data_type", dataType)
               .eq("product_type", productType)
               .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               if (map.get("number") == null) {
                  queryWrapper.eq("number", 0);
               } else {
                  queryWrapper.eq("number", map.get("number"));
               }

               if (map.get("dwgNum") == null) {
                  queryWrapper.isNull("dwg_num");
               } else {
                  queryWrapper.eq("dwg_num", map.get("dwgNum"));
               }
            }

            List<TechDrawing> drawings = this.baseMapper.selectList(queryWrapper);
            TechDrawing drawing = drawings.stream()
               .filter(s -> s.getSerialNumber().equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber))
               .findFirst()
               .orElse(null);
            if (drawing != null) {
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
                  && SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(rules.getType())) {
                  Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
               }

               drawing.setFileName(originalFilename);
               drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
               drawing.setCreateTime(LocalDateTime.now());
               this.baseMapper.updateById(drawing);
            }

            if (drawing == null) {
               drawing = TechDrawing.builder()
                  .projectId(projectId)
                  .projectType(project.getProjectType())
                  .monomerId(monomerId)
                  .dataType(dataType)
                  .productType(productType)
                  .serialNumber(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? (String)map.get("serialNumber") : serialNumber)
                  .filePath(filePath)
                  .fileName(originalFilename)
                  .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                  .build();
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                  drawing.setNumber(map.get("number") == null ? 0 : (Integer)map.get("number"));
                  drawing.setDwgNum((String)map.get("dwgNum"));
               }

               this.baseMapper.insert(drawing);
            }

            drawingId = drawing.getId();
         }
      }

      if (dataType.equals(TechDataTypeEnum.XML_FILE.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         Preconditions.checkArgument(ProductTypeEnum.ARTIFACT.getType().equals(productType), ProductTypeEnum.getNameByType(dataType) + "只有构件存在xml图纸!");
         Preconditions.checkArgument("xml".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "构件图纸格式不正确!");
         List<Long> productIds = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, monomerId).eq(TechArtifact::getSerialNumber, serialNumber))
            .stream()
            .map(TechArtifact::getId)
            .distinct()
            .collect(Collectors.toList());
         this.checkDrawing(productIds, project.getProjectType(), productType);

         try {
            File file = new File(absolutePath + originalFilename);
            multipartFile.transferTo(file);
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            System.gc();
         }

         List<TechDrawing> drawings = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getProjectId, projectId)
                  .eq(TechDrawing::getMonomerId, monomerId)
                  .eq(TechDrawing::getProductType, productType)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.XML_FILE.getType())
                  .eq(TechDrawing::getSerialNumber, serialNumber)
            );
         TechDrawing drawing = drawings.stream().filter(s -> s.getSerialNumber().equals(serialNumber)).findFirst().orElse(null);
         if (drawing != null) {
            drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
            drawing.setCreateTime(LocalDateTime.now());
            this.baseMapper.updateById(drawing);
         } else {
            drawing = TechDrawing.builder()
               .dataType(TechDataTypeEnum.XML_FILE.getType())
               .projectId(projectId)
               .monomerId(monomerId)
               .serialNumber(serialNumber)
               .productType(productType)
               .filePath(filePath)
               .fileName(originalFilename)
               .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
               .build();
            this.baseMapper.insert(drawing);
         }

         drawingId = drawing.getId();
      }

      if (dataType.equals(TechDataTypeEnum.Technical_Instructions.getType())) {
         Preconditions.checkArgument(
            "pdf".equalsIgnoreCase(suffix) || "png".equalsIgnoreCase(suffix) || "jpg".equalsIgnoreCase(suffix),
            ProductTypeEnum.getNameByType(dataType) + "技术指导书图纸格式不正确!"
         );
         if (org.apache.commons.lang3.StringUtils.isNotEmpty(fileName)) {
            String fileExtension = FileUtil.getFileExtension(fileName);
            if (!"pdf".equalsIgnoreCase(fileExtension) && !"png".equalsIgnoreCase(fileExtension) && !"jpg".equalsIgnoreCase(fileExtension)) {
               originalFilename = fileName + "." + suffix + "";
            } else {
               originalFilename = fileName;
            }
         }

         try {
            File file = new File(absolutePath + originalFilename);
            multipartFile.transferTo(file);
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            System.gc();
         }

         TechDrawing drawing = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getProjectId, projectId)
                  .eq(TechDrawing::getFileName, originalFilename)
                  .eq(TechDrawing::getProductType, productType)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.Technical_Instructions.getType())
            );
         if (drawing != null) {
            drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
            drawing.setCreateTime(LocalDateTime.now());
            this.baseMapper.updateById(drawing);
         } else {
            drawing = TechDrawing.builder()
               .dataType(TechDataTypeEnum.Technical_Instructions.getType())
               .projectId(projectId)
               .productType(productType)
               .filePath(filePath)
               .fileName(originalFilename)
               .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
               .build();
            this.baseMapper.insert(drawing);
         }

         drawingId = drawing.getId();
      }

      if (drawingId != null) {
         this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, Collections.singletonList(drawingId));
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   public void uploadFileZip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      project.setProjectType(ProjectTypeEnum.MES.getType());
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         Preconditions.checkArgument(productType != null, "上传深化图纸,缺少产品类型");
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "建钢产品类型有误");
         }
      }

      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "深化图纸单体id不能为空");
      PlanMonomer monomer = null;
      if (monomerId != null) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称不能为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "导入失败，只能上传zip压缩文件");
      String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, null);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      if (org.apache.commons.lang3.StringUtils.isBlank(fileName)) {
         fileName = originalFilename;
      } else {
         String fileSuffix = FileUtil.getFileExtension(fileName);
         fileName = "zip".equalsIgnoreCase(fileSuffix) ? fileName : fileName + ".zip";
      }

      File file = new File(absolutePath + fileName);
      List<Long> drawingIds = null;
      if (dataType.equals(TechDataTypeEnum.CHANGE_FILE.getType()) || dataType.equals(TechDataTypeEnum.BLUEPRINT.getType())) {
         drawingIds = new ArrayList<>();
         TechDrawing drawing = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getProjectId, projectId)
                  .eq(monomerId != null, TechDrawing::getMonomerId, monomerId)
                  .eq(TechDrawing::getDataType, dataType)
                  .eq(TechDrawing::getFileName, fileName)
            );
         if (drawing != null) {
            drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
            drawing.setCreateTime(LocalDateTime.now());
         } else {
            drawing = TechDrawing.builder()
               .projectId(projectId)
               .projectType(project.getProjectType())
               .monomerId(monomerId)
               .dataType(dataType)
               .projectType(project.getProjectType())
               .filePath(filePath)
               .fileName(fileName)
               .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
               .build();
            this.baseMapper.insert(drawing);
         }

         drawingIds.add(drawing.getId());
      }

      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         List<String> fileNameList = null;

         try {
            fileNameList = this.unzipFile(file, absolutePath, new HashMap<>());
            Preconditions.checkArgument(fileNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
         } catch (IOException e) {
            e.printStackTrace();
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(fileNameList), "压缩包解压出现异常!");
         drawingIds = new ArrayList<>(fileNameList.size());
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
            }

            Map<String, Object> map = new HashMap<>();
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               try {
                  List<String> zipNameList = this.getZipNameList(file);
                  Set<String> nameSet = new HashSet<>(zipNameList);
                  Preconditions.checkArgument(nameSet.size() == zipNameList.size(), "存在重复文件,请审查后重新导入!");
                  Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");

                  for (String s : zipNameList) {
                     String serialNumber = s.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
                     map = this.getSerialAndOrder(serialNumber, rules.getType());
                     this.setDrawingArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);
                  }
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }

            try {
               for (String name : fileNameList) {
                  String fileSuffix = FileUtil.getFileExtension(name);
                  Preconditions.checkArgument(
                     "dwg".equalsIgnoreCase(fileSuffix) || "pdf".equalsIgnoreCase(fileSuffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!"
                  );
                  String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
                  if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                     map = this.getSerialAndOrder(serialNumber, rules.getType());
                  }

                  QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
                  queryWrapper.eq("project_id", projectId)
                     .eq("monomer_id", monomerId)
                     .eq("data_type", dataType)
                     .eq("product_type", productType)
                     .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
                  if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                     if (map.get("number") == null) {
                        queryWrapper.eq("number", 0);
                     } else {
                        queryWrapper.eq("number", map.get("number"));
                     }

                     if (map.get("dwgNum") == null) {
                        queryWrapper.isNull("dwg_num");
                     } else {
                        queryWrapper.eq("dwg_num", map.get("dwgNum"));
                     }
                  }

                  List<TechDrawing> drawings = this.baseMapper.selectList(queryWrapper);
                  Map<String, Object> finalMap = map;
                  TechDrawing drawing = drawings.stream()
                     .filter(
                        s -> s.getSerialNumber()
                           .equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? finalMap.get("serialNumber") : serialNumber)
                     )
                     .findFirst()
                     .orElse(null);
                  this.setDrawingArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);
                  if (drawing != null) {
                     if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
                        && SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(rules.getType())) {
                        Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
                     }

                     drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                     drawing.setCreateTime(LocalDateTime.now());
                     this.baseMapper.updateById(drawing);
                  }

                  if (drawing == null) {
                     drawing = TechDrawing.builder()
                        .projectId(projectId)
                        .monomerId(monomerId)
                        .dataType(dataType)
                        .productType(productType)
                        .projectType(project.getProjectType())
                        .serialNumber(serialNumber)
                        .filePath(filePath)
                        .fileName(name)
                        .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                        .build();
                     if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                        drawing.setSerialNumber((String)map.get("serialNumber"));
                        drawing.setNumber(map.get("number") == null ? 0 : (Integer)map.get("number"));
                        drawing.setDwgNum((String)map.get("dwgNum"));
                     }

                     this.baseMapper.insert(drawing);
                  }

                  drawingIds.add(drawing.getId());
               }
            } finally {
               System.gc();
               file.delete();
            }
         }
      }

      this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, drawingIds);
   }

   @Transactional(rollbackFor = Exception.class)
   public void uploadAllFileZip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      project.setProjectType(ProjectTypeEnum.MES.getType());
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         Preconditions.checkArgument(productType != null, "上传深化图纸,缺少产品类型");
      }

      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "深化图纸单体id不能为空");
      PlanMonomer monomer = null;
      if (monomerId != null) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称不能为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "导入失败，只能上传zip压缩文件");
      String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, null);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      if (org.apache.commons.lang3.StringUtils.isBlank(fileName)) {
         fileName = originalFilename;
      } else {
         String fileSuffix = FileUtil.getFileExtension(fileName);
         fileName = "zip".equalsIgnoreCase(fileSuffix) ? fileName : fileName + ".zip";
      }

      File file = new File(absolutePath + fileName);
      List<Long> drawingIds = null;
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         List<String> fileNameList = null;

         try {
            fileNameList = this.unAllZipFile(file, absolutePath, new HashMap<>());
            Preconditions.checkArgument(fileNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
         } catch (IOException e) {
            e.printStackTrace();
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(fileNameList), "压缩包解压出现异常!");
         drawingIds = new ArrayList<>(fileNameList.size());
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            List<String> artifactSerialNumbers = this.artifactService
               .list((new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, monomerId)).select(TechArtifact::getSerialNumber))
               .stream()
               .map(TechArtifact::getSerialNumber)
               .distinct()
               .collect(Collectors.toList());
            List<String> assembleSerialNumbers = this.assembleService
               .list((new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getMonomerId, monomerId)).select(TechAssemble::getSerialNumber))
               .stream()
               .map(TechAssemble::getSerialNumber)
               .distinct()
               .collect(Collectors.toList());
            List<String> partSerialNumbers = this.machinePartService
               .list((new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getMonomerId, monomerId)).select(TechMachinePart::getSerialNumber))
               .stream()
               .map(TechMachinePart::getSerialNumber)
               .distinct()
               .collect(Collectors.toList());
            DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());

            try {
               for (String name : fileNameList) {
                  String fileSuffix = FileUtil.getFileExtension(name);
                  Preconditions.checkArgument(
                     "dwg".equalsIgnoreCase(fileSuffix) || "pdf".equalsIgnoreCase(fileSuffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!"
                  );
                  String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
                  if (partSerialNumbers.contains(serialNumber)) {
                     this.updateAndSaveTechDrawing(
                        projectId,
                        monomerId,
                        dataType,
                        ProductTypeEnum.MACHINE_PART.getType(),
                        serialNumber,
                        cacheObjectDTOParam,
                        project.getProjectType(),
                        filePath,
                        name,
                        null,
                        null,
                        drawingIds
                     );
                  } else if (assembleSerialNumbers.contains(serialNumber)) {
                     this.updateAndSaveTechDrawing(
                        projectId,
                        monomerId,
                        dataType,
                        ProductTypeEnum.ASSEMBLE.getType(),
                        serialNumber,
                        cacheObjectDTOParam,
                        project.getProjectType(),
                        filePath,
                        name,
                        null,
                        null,
                        drawingIds
                     );
                  } else {
                     Map<String, Object> map = this.getAllSerialAndOrder(serialNumber, rules.getType());
                     if (!map.isEmpty() && artifactSerialNumbers.contains(map.get("serialNumber").toString())) {
                        Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
                        this.setDrawingArtifact(
                           projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), ProductTypeEnum.ARTIFACT.getType()
                        );
                        this.updateAndSaveTechDrawing(
                           projectId,
                           monomerId,
                           dataType,
                           ProductTypeEnum.ARTIFACT.getType(),
                           map.get("serialNumber").toString(),
                           cacheObjectDTOParam,
                           project.getProjectType(),
                           filePath,
                           name,
                           map,
                           rules,
                           drawingIds
                        );
                     } else {
                        this.updateAndSaveTechDrawing(
                           projectId,
                           monomerId,
                           dataType,
                           ProductTypeEnum.ALL_PRODUCT.getType(),
                           map.isEmpty() ? serialNumber : map.get("serialNumber").toString(),
                           cacheObjectDTOParam,
                           project.getProjectType(),
                           filePath,
                           name,
                           null,
                           null,
                           drawingIds
                        );
                     }
                  }
               }
            } finally {
               System.gc();
               file.delete();
            }
         }
      }

      this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, drawingIds);
   }

   private void updateAndSaveTechDrawing(
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String serialNumber,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Integer projectType,
      String filePath,
      String fileName,
      Map<String, Object> map,
      DrawingRecognitionRules rules,
      List<Long> drawingIds
   ) {
      QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
      queryWrapper.eq("project_id", projectId)
         .eq("monomer_id", monomerId)
         .eq("data_type", dataType)
         .eq("product_type", productType)
         .eq("serial_number", serialNumber);
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         if (map.get("number") == null) {
            queryWrapper.eq("number", 0);
         } else {
            queryWrapper.eq("number", map.get("number"));
         }

         if (map.get("dwgNum") == null) {
            queryWrapper.isNull("dwg_num");
         } else {
            queryWrapper.eq("dwg_num", map.get("dwgNum"));
         }
      }

      List<TechDrawing> drawings = this.baseMapper.selectList(queryWrapper);
      TechDrawing drawing = drawings.stream().filter(s -> s.getSerialNumber().equals(serialNumber)).findFirst().orElse(null);
      if (drawing != null) {
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
            && SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(rules.getType())) {
            Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
         }

         drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
         drawing.setCreateTime(LocalDateTime.now());
         this.baseMapper.updateById(drawing);
      }

      if (drawing == null) {
         drawing = TechDrawing.builder()
            .projectId(projectId)
            .monomerId(monomerId)
            .dataType(dataType)
            .productType(productType)
            .projectType(projectType)
            .serialNumber(serialNumber)
            .filePath(filePath)
            .fileName(fileName)
            .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
            .build();
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            drawing.setSerialNumber((String)map.get("serialNumber"));
            drawing.setNumber(map.get("number") == null ? 0 : (Integer)map.get("number"));
            drawing.setDwgNum((String)map.get("dwgNum"));
         }

         if (!drawing.getProductType().equals(ProductTypeEnum.ALL_PRODUCT.getType())) {
            String newFilePath = this.getFilePath(projectId, monomerId, dataType, productType, projectType, null, null);
            drawing.setFilePath(newFilePath);

            try {
               PlanFileUtils.moveFile(this.configProperties.getFilePath() + filePath + fileName, this.configProperties.getFilePath() + newFilePath + fileName);
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }

         this.baseMapper.insert(drawing);
      }

      drawingIds.add(drawing.getId());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized void uploadPartFileZip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer productType,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   ) {
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      project.setProjectType(ProjectTypeEnum.MES.getType());
      Preconditions.checkArgument(monomerId != null, "单体id不能为空");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称为空!");
      String filePath = this.getFilePath(
         projectId, monomerId, TechDataTypeEnum.NC_DRAWING.getType(), productType, project.getProjectType(), drawingMatchRange, areaId
      );
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      File file = new File(absolutePath + originalFilename);

      try {
         List<Long> drawingIds = new ArrayList<>();
         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               PlanArea area = this.areaService.getById(areaId);
               Preconditions.checkArgument(area != null, "操作失败,区域不存在!");
            }

            multipartFile.transferTo(file);
            List<String> zipNameList = this.getZipNameList(file);
            Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
            zipNameList = zipNameList.stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
            List<String> finalZipNameList = zipNameList;
            List<TechMachinePart> machineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .in(TechMachinePart::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, List<String>> newfileNameListMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(machineParts)) {
               List<TechMachinePart> wingWebPlateList = machineParts.stream()
                  .filter(
                     ex -> ex.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        && !ex.getSourcePartEnum().equals(SourcePartEnum.DIRECTLY_IMPORT.getType())
                  )
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(wingWebPlateList)) {
                  List<String> initialSerialNumbers = wingWebPlateList.stream()
                     .map(TechMachinePart::getInitialSerialNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  Map<String, List<TechMachinePart>> machinePartMap = this.machinePartService
                     .list(
                        Wrappers.lambdaQuery(TechMachinePart.class)
                           .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                           .eq(TechMachinePart::getMonomerId, monomerId)
                           .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                           .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                           .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_DISASSEMBLY.getType())
                           .in(TechMachinePart::getInitialSerialNumber, initialSerialNumbers)
                           .notIn(TechMachinePart::getSerialNumber, initialSerialNumbers)
                     )
                     .stream()
                     .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
                  Map<String, List<TechMachinePart>> wingWebPlateListMap = wingWebPlateList.stream()
                     .collect(Collectors.groupingBy(ex -> ex.getSourcePartEnum() + "#" + ex.getInitialSerialNumber()));
                  wingWebPlateListMap.forEach(
                     (initialSerialNumberAndSourcePartEnum, partList) -> {
                        Integer sourcePartEnum = Integer.valueOf(initialSerialNumberAndSourcePartEnum.split("#")[0]);
                        String initialSerialNumber = initialSerialNumberAndSourcePartEnum.split("#")[1];
                        if (SourcePartEnum.COMPONENT_DISASSEMBLY.getType().equals(sourcePartEnum)) {
                           List<TechMachinePart> machinePartList = partList.stream()
                              .filter(ex -> !ex.getSerialNumber().equals(initialSerialNumber) && ex.getSourcePartEnum().equals(sourcePartEnum))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(machinePartList)) {
                              List<TechMachinePart> techMachineParts = machinePartMap.get(initialSerialNumber);
                              if (CollectionUtils.isNotEmpty(techMachineParts)) {
                                 List<String> serialNumbers = techMachineParts.stream()
                                    .map(TechMachinePart::getSerialNumber)
                                    .distinct()
                                    .collect(Collectors.toList());
                                 if (serialNumbers.size() == 1) {
                                    machineParts.addAll(techMachineParts);
                                    newfileNameListMap.put(initialSerialNumber + ".dxf", Arrays.asList(serialNumbers.get(0) + ".dxf"));
                                    finalZipNameList.add(serialNumbers.get(0));
                                 }
                              }
                           } else {
                              machinePartList.forEach(ex -> ex.setBoolItsOwnDrawing(Boolean.TRUE));
                              this.machinePartService.updateBatchById(machinePartList);
                           }
                        }
                     }
                  );
               }
            }

            List<TechMachinePart> techMachineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                     .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_COMBINATION.getType())
                     .in(TechMachinePart::getInitialSerialNumber, zipNameList)
               );
            if (CollectionUtils.isNotEmpty(techMachineParts)) {
               machineParts.addAll(techMachineParts);
               Map<String, List<TechMachinePart>> techMachinePartMaps = techMachineParts.stream()
                  .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
               techMachinePartMaps.forEach(
                  (initialSerialNumber, partList) -> {
                     List<String> componentCombinationPartSerialNumbers = partList.stream()
                        .map(TechMachinePart::getSerialNumber)
                        .distinct()
                        .collect(Collectors.toList());
                     List<String> dxfSerialNumbers = new ArrayList<>();

                     for (String serialNumberx : componentCombinationPartSerialNumbers) {
                        dxfSerialNumbers.add(serialNumberx + ".dxf");
                        finalZipNameList.add(serialNumberx);
                     }

                     newfileNameListMap.put(initialSerialNumber + ".dxf", dxfSerialNumbers);
                  }
               );
            }

            List<Long> productIds = machineParts.stream().map(TechMachinePart::getId).distinct().collect(Collectors.toList());
            this.checkDrawing(productIds, project.getProjectType(), productType);
            Map<String, List<TechMachinePart>> partMap = machineParts.stream().collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
            List<String> fileNameList = this.unzipFile(file, absolutePath, newfileNameListMap);
            OSS client = this.ossUtils.openClient();
            List<TechMachinePart> partUpdateList = new ArrayList<>();
            List<TechDrawing> drawingUpdateList = new ArrayList<>();
            List<TechDrawing> drawingInsertList = new ArrayList<>();
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                     .isNull(
                        project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()),
                        TechDrawing::getProductType
                     )
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .in(TechDrawing::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
            List<Long> holeRadiusLinkIds = this.machineHoleRadiusLinkService
               .list(
                  Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                     .eq(TechMachineHoleRadiusLink::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachineHoleRadiusLink::getAreaId, areaId)
                     .in(TechMachineHoleRadiusLink::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .map(TechMachineHoleRadiusLink::getId)
               .collect(Collectors.toList());
            this.machineHoleRadiusLinkService.removeByIds(holeRadiusLinkIds);
            Map<String, HoleRadiusDTO> holeRadiusDTOMap = new HashMap<>();
            List<DXFUploadFailDTO> dxfUploadFailDTOList = new ArrayList<>();

            for (String name : fileNameList) {
               String localAbsoluteFilePath = absolutePath + name;
               File f = new File(localAbsoluteFilePath);

               try {
                  CorrectDXF.resolverDXFForImport(f);
               } catch (Exception e) {
                  dxfUploadFailDTOList.add(new DXFUploadFailDTO(f.getName(), e.getMessage()));
               }
            }

            if (CollectionUtils.isNotEmpty(dxfUploadFailDTOList)) {
               exportMistakeList(dxfUploadFailDTOList, response);
            }

            fileNameList.forEach(
               namex -> {
                  boolean booleUpdate = false;
                  String fileSuffix = FileUtil.getFileExtension(namex);
                  Preconditions.checkArgument("dxf".equalsIgnoreCase(fileSuffix), "零件图纸格式不正确!");
                  String serialNumberx = namex.replaceAll("[.][^.]+$", "");
                  String ossRelativePath;
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     ossRelativePath = projectId + "/" + monomerId + "/" + areaId + "/" + namex;
                  } else {
                     ossRelativePath = projectId + "/" + monomerId + "/" + namex;
                  }

                  String localAbsoluteFilePath = absolutePath + namex;
                  String dxfUrl = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
                  TechDrawing drawingx = drawingMap.get(serialNumberx);
                  if (drawingx != null) {
                     booleUpdate = true;
                     drawingx.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                     drawingx.setCreateTime(LocalDateTime.now());
                  } else {
                     drawingx = TechDrawing.builder()
                        .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                        .projectId(projectId)
                        .projectType(project.getProjectType())
                        .productType(null)
                        .monomerId(monomerId)
                        .serialNumber(serialNumberx)
                        .filePath(filePath)
                        .cloudPath(dxfUrl)
                        .fileName(namex)
                        .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                        .build();
                     if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                        drawingx.setAreaId(areaId);
                     }
                  }

                  List<TechMachinePart> parts = partMap.get(serialNumberx) == null ? new ArrayList<>() : partMap.get(serialNumberx);
                  HoleRadiusDTO holeRadiusDTOx = this.parseDrawing(drawingx.getFilePath(), drawingx.getFileName());
                  holeRadiusDTOMap.put(serialNumberx, holeRadiusDTOx);
                  parts.forEach(part -> {
                     part.setPath(dxfUrl);
                     part.setOssRelativePath(ossRelativePath);
                     part.setBoolHaveHole(holeRadiusDTOx.getHoleNumber() > 0);
                     part.setHoleNumber((long)holeRadiusDTOx.getHoleNumber().intValue());
                  });
                  partUpdateList.addAll(parts);
                  String drawingUrl = this.transformationDxf(drawingx.getFilePath(), drawingx.getFileName(), drawingx.getSerialNumber(), 1);
                  drawingx.setPicturePath(drawingUrl);
                  if (booleUpdate) {
                     drawingUpdateList.add(drawingx);
                  } else {
                     drawingInsertList.add(drawingx);
                  }
               }
            );
            List<TechMachineHoleRadiusLink> holeRadiusLinks = new ArrayList<>();
            this.saveBatch(drawingInsertList);
            this.updateBatchById(drawingUpdateList);
            this.machinePartService.updateBatchById(partUpdateList);

            for (TechDrawing drawing : drawingUpdateList) {
               HoleRadiusDTO holeRadiusDTO = holeRadiusDTOMap.get(drawing.getSerialNumber());
               Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

               for (Double aDouble : map.keySet()) {
                  TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
                     .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
                     .quantity(map.get(aDouble).intValue())
                     .serialNumber(drawing.getSerialNumber())
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .monomerId(drawing.getMonomerId())
                     .drawingId(drawing.getId())
                     .fileName(drawing.getFileName())
                     .build();
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     build.setAreaId(areaId);
                  }

                  holeRadiusLinks.add(build);
               }

               drawingIds.add(drawing.getId());
            }

            for (TechDrawing drawing : drawingInsertList) {
               HoleRadiusDTO holeRadiusDTO = holeRadiusDTOMap.get(drawing.getSerialNumber());
               Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

               for (Double aDouble : map.keySet()) {
                  TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
                     .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
                     .quantity(map.get(aDouble).intValue())
                     .serialNumber(drawing.getSerialNumber())
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .monomerId(drawing.getMonomerId())
                     .drawingId(drawing.getId())
                     .fileName(drawing.getFileName())
                     .build();
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     build.setAreaId(areaId);
                  }

                  holeRadiusLinks.add(build);
               }

               drawingIds.add(drawing.getId());
            }

            this.machineHoleRadiusLinkService.saveBatch(holeRadiusLinks);
            this.ossUtils.closeClient(client);
         }

         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            multipartFile.transferTo(file);
            List<String> zipNameList = this.getZipNameList(file);
            Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
            zipNameList = this.getZipNameList(file).stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
            List<String> finalZipNameList = zipNameList;
            List<TechAssemble> allAssemble = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).in(TechAssemble::getInitialSerialNumber, zipNameList))
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, List<TechAssemble>> assMap = allAssemble.stream().collect(Collectors.groupingBy(TechAssemble::getInitialSerialNumber));
            List<Long> ids = allAssemble.stream().map(TechAssemble::getId).distinct().collect(Collectors.toList());
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(TechDrawing::getProductType, productType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .in(TechDrawing::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
            this.checkDrawing(ids, project.getProjectType(), productType);
            List<TechAssemble> needUpdateAss = new ArrayList<>();
            List<TechDrawing> needUpdateDrawings = new ArrayList<>();
            List<TechDrawing> needInsertDrawings = new ArrayList<>();

            for (String name : this.unzipFile(file, absolutePath, new HashMap<>())) {
               String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
               BigDecimal Nc1Length = BigDecimal.ZERO;

               try {
                  Nc1Length = BigDecimal.valueOf(NC1Parser.getAssembleRealLength(absolutePath + name));
               } catch (IOException e) {
                  e.printStackTrace();
                  Preconditions.checkArgument(false, "图纸解析异常,请重新导入");
               }

               TechDrawing drawing = drawingMap.get(serialNumber);
               if (drawing != null) {
                  drawing.setFilePath(
                     this.getFilePath(projectId, monomerId, TechDataTypeEnum.NC_DRAWING.getType(), productType, project.getProjectType(), null, null)
                  );
                  drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                  drawing.setCreateTime(LocalDateTime.now());
                  needUpdateDrawings.add(drawing);
               } else {
                  drawing = TechDrawing.builder()
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .projectId(projectId)
                     .monomerId(monomerId)
                     .serialNumber(serialNumber)
                     .productType(productType)
                     .filePath(filePath)
                     .nc1Length(Nc1Length)
                     .fileName(name)
                     .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                     .build();
                  needInsertDrawings.add(drawing);
               }

               drawingIds.add(drawing.getId());
               List<TechAssemble> techAssembles = assMap.get(serialNumber);
               if (CollectionUtils.isNotEmpty(techAssembles)) {
                  BigDecimal finalNc1Length = Nc1Length;
                  List<TechAssemble> collect = techAssembles.stream()
                     .map(s -> s.setBoolHaveNC1(Boolean.TRUE))
                     .map(ex -> ex.setNc1Length(finalNc1Length))
                     .collect(Collectors.toList());
                  needUpdateAss.addAll(collect);
               }
            }

            this.saveBatch(needInsertDrawings);
            this.updateBatchById(needUpdateDrawings);
            this.assembleService.updateBatchById(needUpdateAss);
         }

         this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), TechDataTypeEnum.NC_DRAWING.getType(), productType, project, monomer, drawingIds);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         System.gc();
         file.delete();
      }
   }

   public static void exportMistakeList(List<DXFUploadFailDTO> dxfUploadFailDTOList, HttpServletResponse response) {
      if (CollectionUtils.isNotEmpty(dxfUploadFailDTOList)) {
         String title = "dxf图片错误表";
         String sheetName = "dxf图片错误表";
         String fileName = "dxf图片错误表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("图片导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.exportExcel(dxfUploadFailDTOList, title, sheetName, DXFUploadFailDTO.class, fileName, ExcelType.XSSF, response);
      }

      try {
         response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "result");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
   }

   @Override
   public String getFilePath(Long projectId, Long monomerId, Integer dataType, Integer productType, Integer projectType, Integer drawingMatchRange, Long areaId) {
      StringBuilder builder = new StringBuilder()
         .append(AttachmentTypeEnum.TECH_DATA.getName())
         .append(File.separator)
         .append(TechDataTypeEnum.getDirByType(dataType))
         .append(File.separator);
      if (TechDataTypeEnum.XML_FILE.getType().equals(dataType)) {
         Preconditions.checkArgument(productType != null, "XML文件必须传产品类型值!");
         if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
            builder.append(DrawingProductTypeEnum.getDirByType(productType)).append(File.separator);
         }
      }

      if (TechDataTypeEnum.NC_DRAWING.getType().equals(dataType)
         && productType.equals(ProductTypeEnum.ASSEMBLE.getType())
         && (projectType.equals(ProjectTypeEnum.MES.getType()) || productType.equals(ProjectTypeEnum.BRIDGE.getType()))) {
         builder.append(DrawingProductTypeEnum.getDirByType(productType)).append(File.separator);
      }

      if (TechDataTypeEnum.DEEPEN.getType().equals(dataType)) {
         Preconditions.checkArgument(productType != null, "深化图纸必传产品类型值!");
         if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
            builder.append(DrawingProductTypeEnum.getDirByType(productType)).append(File.separator);
         }
      }

      if (projectId != null) {
         builder.append(projectId).append(File.separator);
      }

      if (monomerId != null) {
         builder.append(monomerId).append(File.separator);
      }

      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)
         && TechDataTypeEnum.NC_DRAWING.getType().equals(dataType)
         && areaId != null
         && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         builder.append(areaId).append(File.separator);
      }

      return builder.toString();
   }

   private void setMachinePartPath(
      ContractProject project, Long monomerId, String serialNumber, String ossDxfPath, String ossRelativePath, Integer drawingMatchRange, Long areaId
   ) {
      if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         List<TechMachinePart> machinePartList = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .eq(TechMachinePart::getProjectId, project.getId())
                  .eq(TechMachinePart::getMonomerId, monomerId)
                  .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange) && areaId != null, TechMachinePart::getAreaId, areaId)
                  .eq(TechMachinePart::getSerialNumber, serialNumber)
            );
         machinePartList = machinePartList.stream().filter(s -> s.getSerialNumber().equals(serialNumber)).collect(Collectors.toList());
         machinePartList.forEach(part -> {
            part.setPath(ossDxfPath);
            part.setOssRelativePath(ossRelativePath);
         });
         this.machinePartService.updateBatchById(machinePartList);
      }
   }

   private List<String> unzipFile(File file, String targetPath, Map<String, List<String>> newfileNameListMap) throws IOException {
      Preconditions.checkArgument(file != null && file.getName().endsWith(".zip"), "请传入zip格式压缩文件!");
      List<String> fileNameList = new ArrayList<>();
      FileOutputStream fos = null;
      InputStream is = null;

      try (ZipFile zipFile = new ZipFile(file, Charset.forName("gbk"))) {
         Enumeration<?> entries = zipFile.entries();

         while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            if (!entry.isDirectory()) {
               System.out.println("解压>>>>>>>>>>>>" + entry.getName());
               String fileName = entry.getName().substring(entry.getName().lastIndexOf("/") + 1);
               fileName = this.transformLowercaseSuffix(fileName);
               if (fileName.contains("dxf") && CollectionUtils.isNotEmpty(newfileNameListMap.get(fileName))) {
                  for (String newfileName : newfileNameListMap.get(fileName)) {
                     fileNameList.add(newfileName);
                     File targetFile = new File(targetPath + newfileName);
                     is = zipFile.getInputStream(entry);
                     fos = new FileOutputStream(targetFile);
                     byte[] buf = new byte[1024];

                     int len;
                     while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                     }

                     CorrectDXF.resolverDXFForImport(targetFile);
                  }
               }

               fileNameList.add(fileName);
               File targetFile = new File(targetPath + fileName);
               is = zipFile.getInputStream(entry);
               fos = new FileOutputStream(targetFile);
               byte[] buf = new byte[1024];

               int len;
               while ((len = is.read(buf)) != -1) {
                  fos.write(buf, 0, len);
               }
            }
         }
      } catch (Exception e) {
         throw new IllegalArgumentException(e.getMessage());
      } finally {
         if (fos != null) {
            fos.close();
         }

         if (is != null) {
            is.close();
         }
      }

      return fileNameList;
   }

   private List<String> unAllZipFile(File file, String targetPath, Map<String, List<String>> newfileNameListMap) throws IOException {
      Preconditions.checkArgument(file != null && file.getName().endsWith(".zip"), "请传入zip格式压缩文件!");
      List<String> fileNameList = new ArrayList<>();

      try {
         try (ZipFile zipFile = new ZipFile(file, Charset.forName("gbk"))) {
            Enumeration<?> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
               ZipEntry entry = (ZipEntry)entries.nextElement();
               if (!entry.isDirectory()) {
                  System.out.println("解压>>>>>>>>>>>>" + entry.getName());
                  String fileName = entry.getName().substring(entry.getName().lastIndexOf("/") + 1);
                  fileName = this.transformLowercaseSuffix(fileName);
                  if (fileName.contains("dxf") && CollectionUtils.isNotEmpty(newfileNameListMap.get(fileName))) {
                     for (String newfileName : newfileNameListMap.get(fileName)) {
                        fileNameList.add(newfileName);
                        File targetFile = new File(targetPath + newfileName);

                        try (
                           InputStream is = zipFile.getInputStream(entry);
                           FileOutputStream fos = new FileOutputStream(targetFile);
                        ) {
                           byte[] buf = new byte[1024];

                           int len;
                           while ((len = is.read(buf)) != -1) {
                              fos.write(buf, 0, len);
                           }
                        }

                        CorrectDXF.resolverDXFForImport(targetFile);
                     }
                  }

                  fileNameList.add(fileName);
                  File targetFile = new File(targetPath + fileName);

                  try (
                     InputStream is = zipFile.getInputStream(entry);
                     FileOutputStream fos = new FileOutputStream(targetFile);
                  ) {
                     byte[] buf = new byte[1024];

                     int len;
                     while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                     }
                  }
               }
            }
         }

         return fileNameList;
      } catch (Exception e) {
         if (e instanceof IOException) {
            throw (IOException)e;
         } else {
            throw new IOException("解压失败", e);
         }
      }
   }

   private List<String> getZipNameList(File file) throws IOException {
      Preconditions.checkArgument(file != null && file.getName().endsWith(".zip"), "请传入zip格式压缩文件!");
      List<String> fileNameList = new ArrayList<>();

      try (ZipFile zipFile = new ZipFile(file, Charset.forName("gbk"))) {
         Enumeration<?> entries = zipFile.entries();

         while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            if (!entry.isDirectory()) {
               String fileName = entry.getName().substring(entry.getName().lastIndexOf("/") + 1);
               fileName = this.transformLowercaseSuffix(fileName);
               fileNameList.add(fileName);
            }
         }
      } catch (Exception e) {
         Preconditions.checkArgument(false, "文件解压失败请联系管理员!!");
      }

      return fileNameList;
   }

   private String transformLowercaseSuffix(String fileName) {
      String[] split = org.apache.commons.lang3.StringUtils.split(fileName, ".");
      split[split.length - 1] = split[split.length - 1].toLowerCase();
      return org.apache.commons.lang3.StringUtils.join(split, ".");
   }

   private void saveLog(Integer operationType, Integer dataType, Integer productType, ContractProject project, PlanMonomer monomer, List<Long> drawingIds) {
      StringBuilder builder = new StringBuilder(project.getShortName()).append(">");
      if (monomer != null) {
         builder.append(monomer.getName()).append(">");
      }

      if (productType != null
         && (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))) {
         builder.append(ProductTypeEnum.getNameByType(productType));
      }

      String remark = builder.append(TechDataTypeEnum.getNameByType(dataType)).append(DataOperationTypeEnum.getNameByType(operationType)).toString();
      TechDataLog log = TechDataLog.builder()
         .operationType(operationType)
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .remark(remark)
         .build();
      this.dataLogService.save(log);
      List<TechDataLogLink> links = new ArrayList<>();
      drawingIds.forEach(id -> {
         TechDataLogLink link = TechDataLogLink.builder().logId(log.getId()).drawingId(id).build();
         links.add(link);
      });
      this.dataLogLinkService.saveBatch(links);
   }

   @Override
   public ResultVO updateDrawing(Long id, MultipartFile multipartFile, String fileName, Long monomerId) throws Exception {
      TechDrawing drawing = this.baseMapper.selectById(id);
      Preconditions.checkArgument(drawing != null, "技术资料不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "技术资料导入失败!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      if (drawing.getDataType().equals(TechDataTypeEnum.CHANGE_FILE.getType()) || drawing.getDataType().equals(TechDataTypeEnum.BLUEPRINT.getType())) {
         Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(drawing.getDataType()) + "格式不正确!");
      }

      return this.achievementBiz
         .createDrawingApprove(
            multipartFile,
            drawing.getProjectId(),
            monomerId,
            null,
            id,
            drawing.getDataType(),
            null,
            null,
            fileName,
            PlanFileOverlayEnum.ALTER_CONSTRUCTION_BLUEPRINT.getType(),
            false,
            this.response
         );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean newUpdateDrawing(Long id, MultipartFile multipartFile, String fileName, PlanApproveCacheObjectDTOParam cacheObjectDTOParam) {
      TechDrawing drawing = this.baseMapper.selectById(id);
      Preconditions.checkArgument(drawing != null, "技术资料不存在!");
      ContractProject project = this.projectService.checkProjectStatus(drawing.getProjectId());
      PlanMonomer monomer = null;
      if (drawing.getMonomerId() != null) {
         monomer = this.monomerService.getById(drawing.getMonomerId());
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "技术资料导入失败!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      if (drawing.getDataType().equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         if (null != drawing.getProductType() && drawing.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            Preconditions.checkArgument("nc1".equalsIgnoreCase(suffix), "部件图纸格式不正确!");
            String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();

            try {
               File file = new File(absolutePath + originalFilename);
               multipartFile.transferTo(file);
            } catch (IOException e) {
               e.printStackTrace();
            }

            drawing.setCreateTime(LocalDateTime.now());
            drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
            this.baseMapper.updateById(drawing);
            return Boolean.TRUE;
         } else {
            Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), "零件图纸格式不正确!");
            String ossRelativePath = drawing.getProjectId() + "/" + drawing.getMonomerId() + "/" + drawing.getFileName();

            try (InputStream is = multipartFile.getInputStream()) {
               OSS client = this.ossUtils.openClient();
               this.ossUtils.uploadFile(client, ossRelativePath, is);
               this.ossUtils.closeClient(client);
            } catch (IOException e) {
               e.printStackTrace();
            }

            drawing.setCreateTime(LocalDateTime.now());
            drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
            this.baseMapper.updateById(drawing);
            return Boolean.TRUE;
         }
      } else if (drawing.getDataType().equals(TechDataTypeEnum.XML_FILE.getType())) {
         Preconditions.checkArgument("xml".equalsIgnoreCase(suffix), "XML文件格式不正确!");
         String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();

         try {
            File file = new File(absolutePath + originalFilename);
            multipartFile.transferTo(file);
         } catch (IOException e) {
            e.printStackTrace();
         }

         drawing.setCreateTime(LocalDateTime.now());
         drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
         this.baseMapper.updateById(drawing);
         return Boolean.TRUE;
      } else {
         String oldFilePath = this.configProperties.getFilePath() + drawing.getFilePath() + drawing.getFileName();
         File file = new File(oldFilePath);
         if (drawing.getDataType().equals(TechDataTypeEnum.DEEPEN.getType())) {
            Preconditions.checkArgument(
               "dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(drawing.getDataType()) + "格式不正确!"
            );
         }

         if (drawing.getDataType().equals(TechDataTypeEnum.CHANGE_FILE.getType()) || drawing.getDataType().equals(TechDataTypeEnum.BLUEPRINT.getType())) {
            Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(drawing.getDataType()) + "格式不正确!");
            if (org.apache.commons.lang3.StringUtils.isNotBlank(fileName)) {
               FileUtil.deleteFile(oldFilePath);
               String newFilePath = this.configProperties.getFilePath() + drawing.getFilePath() + fileName;
               file = new File(newFilePath);
               drawing.setFileName(fileName + "." + suffix.toLowerCase());
            }
         }

         try (
            InputStream is = multipartFile.getInputStream();
            OutputStream out = new FileOutputStream(file);
         ) {
            byte[] buf = new byte[1024];

            int len;
            while ((len = is.read(buf)) != -1) {
               out.write(buf, 0, len);
               out.flush();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }

         drawing.setCreateTime(LocalDateTime.now());
         drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
         this.baseMapper.updateById(drawing);
         this.saveLog(
            DataOperationTypeEnum.DATA_REPLACE.getType(),
            drawing.getDataType(),
            drawing.getProductType(),
            project,
            monomer,
            Collections.singletonList(drawing.getId())
         );
         return Boolean.TRUE;
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ResultVO deleteDrawings(List<Long> ids) {
      List<Long> newIds = new ArrayList<>();
      ResultVO<Object> build = ResultVO.<Object>builder().build();

      for (int i = 0; i < ids.size(); i++) {
         PlanTechnologicalAchievementApproveRecord record = this.recordService
            .getOne(
               (Wrapper<PlanTechnologicalAchievementApproveRecord>)(new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
                     .eq(PlanTechnologicalAchievementApproveRecord::getDeleId, ids.get(i)))
                  .eq(PlanTechnologicalAchievementApproveRecord::getApproveStatus, ReviewStatusEnum.AUDITING.getType())
            );
         if (ObjectUtils.isNotEmpty(record)) {
            build.setMessage("审批流中存在的数据无法删除!");
         } else {
            newIds.add(ids.get(i));
         }
      }

      build.setData(false);
      if (CollectionUtils.isEmpty(newIds)) {
         return build;
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(newIds), "图纸id列表为空!");
      boolean hasOssDrawing = this.listByIds(newIds).stream()
         .anyMatch(drawing -> TechDataTypeEnum.NC_DRAWING.getType().equals(drawing.getDataType()) && drawing.getProductType() == null);
      OSS client = hasOssDrawing ? this.ossUtils.openClient() : null;
      try {
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         newIds.forEach(
            id -> {
               TechDrawing drawing = this.baseMapper.selectById(id);
               Preconditions.checkArgument(drawing != null, "删除失败，对应的图纸不存在!");
               ContractProject project = this.projectService.checkProjectStatus(drawing.getProjectId());
               PlanMonomer monomer = null;
               if (drawing.getMonomerId() != null) {
                  monomer = this.monomerService.getById(drawing.getMonomerId());
               }

               String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath() + drawing.getFileName();
               File file = new File(absolutePath);
               if (file.exists()) {
                  file.delete();
               }

               if (drawing.getDataType().equals(TechDataTypeEnum.NC_DRAWING.getType())) {
                  if (null == drawing.getProductType()) {
                     File pictureFile = new File(this.configProperties.getFilePath() + drawing.getPicturePath());
                     if (pictureFile.exists()) {
                        pictureFile.delete();
                     }

                     this.setMachinePartPath(project, drawing.getMonomerId(), drawing.getSerialNumber(), null, null, drawingMatchRange, drawing.getAreaId());
                     String ossRelativePath = SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)
                        ? drawing.getProjectId() + "/" + drawing.getMonomerId() + "/" + drawing.getAreaId() + "/" + drawing.getFileName()
                        : drawing.getProjectId() + "/" + drawing.getMonomerId() + "/" + drawing.getFileName();
                     this.ossUtils.deleteFile(client, ossRelativePath);
                  } else if (ProductTypeEnum.ASSEMBLE.getType().equals(drawing.getProductType())) {
                     List<TechAssemble> techAssembles = this.assembleService
                        .list(
                           Wrappers.lambdaQuery(TechAssemble.class)
                              .eq(TechAssemble::getMonomerId, drawing.getMonomerId())
                              .eq(TechAssemble::getInitialSerialNumber, drawing.getSerialNumber())
                        );
                     if (CollectionUtils.isNotEmpty(techAssembles)) {
                        List<TechAssemble> collect = techAssembles.stream()
                           .map(s -> s.setBoolHaveNC1(Boolean.FALSE))
                           .map(e -> e.setNc1Length(BigDecimal.ZERO))
                           .collect(Collectors.toList());
                        this.assembleService.updateBatchById(collect);
                     }

                     if (org.apache.commons.lang3.StringUtils.isNotBlank(drawing.getPicturePath())) {
                        File nc1File = new File(this.configProperties.getFilePath() + drawing.getPicturePath());
                        if (nc1File.exists()) {
                           nc1File.delete();
                        }
                     }
                  } else {
                     Preconditions.checkArgument(false, "只有零件和部件存在数控图纸");
                  }
               }

               this.baseMapper.deleteById(id);
               this.saveLog(
                  DataOperationTypeEnum.DATA_DELETE.getType(), drawing.getDataType(), drawing.getProductType(), project, monomer, Collections.singletonList(id)
               );
            }
         );
      } finally {
         if (client != null) {
            this.ossUtils.closeClient(client);
         }
      }
      if (build.getMessage() == null) {
         build.setData(true);
      }

      return build;
   }

   @Override
   public void downloadFileByProduct(Integer projectType, Long productId, Integer productType, Integer number, String serialNumber, Long monomerId, Long areaId) {
      if (ProjectTypeEnum.MES.getType().equals(projectType) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            Preconditions.checkArgument(number != null, "该构件下的图纸不存在!!!");
            Preconditions.checkArgument(productId != null || org.apache.commons.lang3.StringUtils.isNotBlank(serialNumber), "操作失败,构件编号和构件产品Id不能同时为空!");
            if (org.apache.commons.lang3.StringUtils.isNotBlank(serialNumber)) {
               this.filePreview(monomerId, TechDataTypeEnum.DEEPEN.getType(), productType, serialNumber, number, null);
            } else if (productId != null) {
               TechArtifact artifact = this.artifactService.getById(productId);
               Preconditions.checkArgument(artifact != null, "构件不存在");
               this.filePreview(artifact.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), productType, artifact.getSerialNumber(), number, null);
            }
         } else if (DrawingProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            TechMachinePart machinePart = this.machinePartService.getById(productId);
            Preconditions.checkArgument(machinePart != null, "零件不存在");
            Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
            this.filePreview(
               machinePart.getMonomerId(),
               TechDataTypeEnum.NC_DRAWING.getType(),
               null,
               machinePart.getSerialNumber(),
               number,
               SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange) ? machinePart.getAreaId() : null
            );
         } else {
            if (!DrawingProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
               throw new BusinessException("请传入正确的产品类型!");
            }

            TechAssemble assemble = this.assembleService.getById(productId);
            Preconditions.checkArgument(assemble != null, "组立不存在");
            this.filePreview(assemble.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), productType, assemble.getInitialSerialNumber(), number, null);
         }
      }
   }

   private void filePreview(Long monomerId, Integer dataType, Integer productType, String serialNumber, Integer number, Long areaId) {
      List<TechDrawing> drawingList = this.baseMapper.getByMonomerIdAndTypeAndSerialNumber(monomerId, dataType, productType, serialNumber, number, areaId);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(drawingList) && drawingList.size() == 1, "下载失败，对应的图纸不存在。");
      TechDrawing drawing = drawingList.get(0);
      String path = this.configProperties.getFilePath() + drawing.getFilePath() + drawing.getFileName();
      File file = new File(path);
      Preconditions.checkArgument(file.exists(), "查看失败，实际图纸不存在");
      FileUtil.downloadFile(file, drawing.getFileName());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void downloadFileByDrawing(Long drawingId) {
      TechDrawing drawing = this.baseMapper.selectById(drawingId);
      Preconditions.checkArgument(drawing != null, "下载失败，对应的图纸不存在。");
      String path = this.configProperties.getFilePath() + drawing.getFilePath() + drawing.getFileName();
      File file = new File(path);
      Preconditions.checkArgument(file.exists(), "图纸不存在");
      FileUtil.downloadFile(file, drawing.getFileName());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void downloadFileByMonomerId(Long projectId, Long monomerId, Long areaId, Integer dataType, Integer productType) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      PlanMonomer monomer = null;
      PlanArea area = null;
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         Preconditions.checkArgument(monomerId != null, "该类型资料,单体id不能为空!");
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "单体不存在!");
         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)
            && TechDataTypeEnum.NC_DRAWING.getType().equals(dataType)
            && ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            area = this.areaService.getById(areaId);
            Preconditions.checkArgument(area != null, "区域不存在!");
         }
      }

      String filePath = this.getFilePath(projectId, monomerId, dataType, project.getProjectType(), productType, drawingMatchRange, areaId);
      String fileName = project.getName() + "-" + TechDataTypeEnum.getNameByType(dataType) + ".zip";
      if (monomer != null) {
         fileName = monomer.getName() + "-" + TechDataTypeEnum.getNameByType(dataType) + ".zip";
      }

      if (area != null) {
         fileName = monomer.getName() + "-" + area.getName() + "-" + TechDataTypeEnum.getNameByType(dataType) + ".zip";
      }

      File file = ZipUtil.zip(this.configProperties.getFilePath() + filePath);
      FileUtil.downloadFile(file, fileName);
   }

   @Override
   public Map<String, Object> checkDrawingExist(Integer projectType, Long productId, Integer productType) {
      List<TechDrawing> drawingList = null;
      if (ProjectTypeEnum.MES.getType().equals(projectType) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            TechArtifact artifact = this.artifactService.getById(productId);
            Preconditions.checkArgument(artifact != null, "该构件不存在");
            drawingList = this.baseMapper
               .getByMonomerIdAndTypeAndSerialNumber(
                  artifact.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), productType, artifact.getSerialNumber(), null, null
               );
         } else if (DrawingProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            TechMachinePart machinePart = this.machinePartService.getById(productId);
            Preconditions.checkArgument(machinePart != null, "该零件不存在");
            drawingList = this.baseMapper
               .getByMonomerIdAndTypeAndSerialNumber(
                  machinePart.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), null, machinePart.getSerialNumber(), null, null
               );
         } else {
            if (!DrawingProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
               throw new BusinessException("请传入正确的产品类型");
            }

            TechAssemble assemble = this.assembleService.getById(productId);
            Preconditions.checkArgument(assemble != null, "该组立不存在");
            drawingList = this.baseMapper
               .getByMonomerIdAndTypeAndSerialNumber(
                  assemble.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), productType, assemble.getInitialSerialNumber(), null, null
               );
         }
      }

      HashMap<String, Object> map = new HashMap<>(8);
      Set<Integer> drawingFileTypes = new HashSet<>();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(drawingList), "图纸不存在");

      for (TechDrawing techDrawing : drawingList) {
         String path = this.configProperties.getFilePath() + techDrawing.getFilePath() + techDrawing.getFileName();
         File file = new File(path);
         Preconditions.checkArgument(file.exists(), "深化图纸位置不存在");
         String suffix = FileUtil.getFileExtension(techDrawing.getFileName());
         int drawingFileType;
         if ("pdf".equalsIgnoreCase(suffix)) {
            drawingFileType = 1;
         } else {
            if (!"dwg".equalsIgnoreCase(suffix)) {
               throw new BusinessException("文件后缀名不规范");
            }

            drawingFileType = 2;
         }

         drawingFileTypes.add(drawingFileType);
      }

      Preconditions.checkArgument(drawingFileTypes.size() == 1, "同一编号下的文件后缀名不统一");
      map.put("drawingFileType", drawingFileTypes.iterator().next());
      map.put("isExist", true);
      return map;
   }

   @Override
   public ArtifactNumDTO getArtifactDwgNum(Integer projectType, Long productId, Integer productType) {
      ArtifactNumDTO artifactNumDTO = new ArtifactNumDTO();
      artifactNumDTO.setBoolExist(false);
      if ((projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()))
         && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "构件不存在");
         List<TechDrawing> drawingList = this.baseMapper
            .selectList(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getMonomerId, artifact.getMonomerId()))
                        .eq(TechDrawing::getProductType, productType))
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechDrawing::getSerialNumber, artifact.getSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(drawingList)) {
            List<Integer> numbers = drawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList());
            artifactNumDTO.setBoolExist(true);
            artifactNumDTO.setNumbers(numbers);
         }
      } else if ((projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()))
         && DrawingProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "部件不存在");
         List<TechDrawing> drawingList = this.baseMapper
            .selectList(
               (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                           .eq(TechDrawing::getMonomerId, assemble.getMonomerId()))
                        .eq(TechDrawing::getProductType, productType))
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechDrawing::getSerialNumber, assemble.getInitialSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(drawingList)) {
            List<Integer> numbers = drawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList());
            artifactNumDTO.setBoolExist(true);
            artifactNumDTO.setNumbers(numbers);
         }
      }

      return artifactNumDTO;
   }

   private Map<String, Object> getSerialAndOrder(String serialNumber, Integer type) {
      Map<String, Object> map = new HashMap<>();
      if (SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(type)) {
         Preconditions.checkArgument(
            serialNumber.contains("(") && serialNumber.contains(")") && serialNumber.contains("_"), "规则为图号+构件号,编号:" + serialNumber + "不规范!!!"
         );
         String dwgNum = serialNumber.split("_")[0];
         map.put("dwgNum", dwgNum);
         serialNumber = serialNumber.substring(serialNumber.indexOf("(") + 1, serialNumber.indexOf(")"));
      }

      if (SysDrawingRecognitionRulesEnums.ARTIFACTS.getType().equals(type)) {
         Preconditions.checkArgument(!serialNumber.contains("(") && !serialNumber.contains(")"), "规则为构件号,编号:" + serialNumber + "不规范!!!");
      }

      Integer number = null;
      String[] artifactSplit = serialNumber.split("_");
      Preconditions.checkArgument(artifactSplit.length <= 2 && artifactSplit.length >= 1, "编号:" + serialNumber + "不规范!!!");
      if (artifactSplit.length == 2) {
         String num = artifactSplit[artifactSplit.length - 1];
         Preconditions.checkArgument(Pattern.matches("^[1-9]\\d*$", num), "序列号必须为非0开头的数字");
         number = Integer.valueOf(num);
      }

      String serial = artifactSplit[0];
      map.put("serialNumber", serial == null ? serialNumber : serial);
      map.put("number", number);
      return map;
   }

   private Map<String, Object> getAllSerialAndOrder(String serialNumber, Integer type) {
      Map<String, Object> map = new HashMap<>();
      if (SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(type)) {
         if (!serialNumber.contains("(") || !serialNumber.contains(")") || !serialNumber.contains("_")) {
            return map;
         }

         String dwgNum = serialNumber.split("_")[0];
         map.put("dwgNum", dwgNum);
         serialNumber = serialNumber.substring(serialNumber.indexOf("(") + 1, serialNumber.indexOf(")"));
      }

      if (!SysDrawingRecognitionRulesEnums.ARTIFACTS.getType().equals(type) || !serialNumber.contains("(") && !serialNumber.contains(")")) {
         Integer number = null;
         String[] artifactSplit = serialNumber.split("_");
         if (artifactSplit.length <= 2 && artifactSplit.length >= 1) {
            if (artifactSplit.length == 2) {
               String num = artifactSplit[artifactSplit.length - 1];
               Preconditions.checkArgument(Pattern.matches("^[1-9]\\d*$", num), "序列号必须为非0开头的数字");
               number = Integer.valueOf(num);
            }

            String serial = artifactSplit[0];
            map.put("serialNumber", serial == null ? serialNumber : serial);
            map.put("number", number);
            return map;
         } else {
            return map;
         }
      } else {
         return map;
      }
   }

   private void setDrawingArtifact(Long projectId, Long monomerId, Integer dataType, String serialNumber, Integer type, Integer productType) {
      Boolean flag = false;
      QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
      queryWrapper.eq("project_id", projectId)
         .eq("monomer_id", monomerId)
         .eq("data_type", dataType)
         .eq("product_type", productType)
         .eq("serial_number", serialNumber);
      if (SysDrawingRecognitionRulesEnums.ARTIFACTS.getType().equals(type) && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         queryWrapper.isNotNull("dwg_num");
         flag = true;
      }

      if (SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(type) && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         queryWrapper.isNull("dwg_num");
         flag = true;
      }

      if (flag) {
         List<TechDrawing> drawingList = this.baseMapper.selectList(queryWrapper);
         if (CollectionUtils.isNotEmpty(drawingList)) {
            for (TechDrawing techDrawing : drawingList) {
               this.baseMapper.deleteById(techDrawing);
               String absolutePath = this.configProperties.getFilePath() + techDrawing.getFilePath() + techDrawing.getFileName();
               File file = new File(absolutePath);
               if (file.exists()) {
                  Preconditions.checkArgument(file.delete(), "磁盘文件清理失败");
               }
            }
         }
      }
   }

   @Override
   public PageVO<ProductDrawingsSummaryDTO> getArtifactDwg(
      Long projectId, Integer productType, Integer dataType, Integer steelPlateTypeEnum, Long monomerId, Long areaId, Integer pageSize, Integer pageNumber
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ProductDrawingsSummaryDTO> artifactXMLDwg = new ArrayList<>();
      Preconditions.checkArgument(dataType != null, "文件类型未确定");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      PageHelper.startPage(pageNumber, pageSize);
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         List<PlanMonomer> mons = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId));
         PageVO pageVO = new PageVO<>(mons);

         for (PlanMonomer mon : mons) {
            ProductDrawingsSummaryDTO build = ProductDrawingsSummaryDTO.builder()
               .productType(productType)
               .dataType(dataType)
               .monomerId(mon.getId())
               .monomerName(mon.getName())
               .projectId(projectId)
               .drawingQuantity(0)
               .productWeldQuantity(0)
               .productWeldMapQuantity(0)
               .quantity(0)
               .build();
            if (ProductTypeEnum.ALL_PRODUCT.getType().equals(productType)) {
               ProductDrawingsSummaryDetailDTO summaryDetailDTO = ProductDrawingsSummaryDetailDTO.builder()
                  .artifactDrawingQuantity(0)
                  .artifactQuantity(0)
                  .assembleDrawingQuantity(0)
                  .assembleQuantity(0)
                  .partDrawingQuantity(0)
                  .partQuantity(0)
                  .build();

               for (Integer newProductType : Arrays.asList(
                  ProductTypeEnum.ARTIFACT.getType(), ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType()
               )) {
                  List<AreaDrawingDetailsDTO> contrast = this.baseMapper
                     .contrast(
                        projectId,
                        mon.getId(),
                        null,
                        null,
                        project.getProjectType(),
                        newProductType,
                        null,
                        dataType,
                        null,
                        steelPlateTypeEnum,
                        null,
                        drawingMatchRange
                     );
                  if (CollectionUtils.isNotEmpty(contrast)) {
                     for (AreaDrawingDetailsDTO dto : contrast) {
                        if (ProductTypeEnum.ARTIFACT.getType().equals(newProductType)) {
                           summaryDetailDTO.setArtifactQuantity(summaryDetailDTO.getArtifactQuantity() + dto.getQuantity());
                        }

                        if (ProductTypeEnum.ASSEMBLE.getType().equals(newProductType)) {
                           summaryDetailDTO.setAssembleQuantity(summaryDetailDTO.getAssembleQuantity() + dto.getQuantity());
                        }

                        if (ProductTypeEnum.MACHINE_PART.getType().equals(newProductType)) {
                           summaryDetailDTO.setPartQuantity(summaryDetailDTO.getPartQuantity() + dto.getQuantity());
                        }

                        if (dto.getSign() == 1) {
                           if (ProductTypeEnum.ARTIFACT.getType().equals(newProductType)) {
                              summaryDetailDTO.setArtifactDrawingQuantity(summaryDetailDTO.getArtifactDrawingQuantity() + dto.getQuantity());
                           }

                           if (ProductTypeEnum.ASSEMBLE.getType().equals(newProductType)) {
                              summaryDetailDTO.setAssembleDrawingQuantity(summaryDetailDTO.getAssembleDrawingQuantity() + dto.getQuantity());
                           }

                           if (ProductTypeEnum.MACHINE_PART.getType().equals(newProductType)) {
                              summaryDetailDTO.setPartDrawingQuantity(summaryDetailDTO.getPartDrawingQuantity() + dto.getQuantity());
                           }
                        }
                     }
                  }
               }

               build.setSummaryDetailDTO(summaryDetailDTO);
            }

            if (!ProductTypeEnum.ALL_PRODUCT.getType().equals(productType)) {
               List<AreaDrawingDetailsDTO> contrast = this.baseMapper
                  .contrast(
                     projectId,
                     mon.getId(),
                     null,
                     null,
                     project.getProjectType(),
                     productType,
                     null,
                     dataType,
                     null,
                     steelPlateTypeEnum,
                     null,
                     drawingMatchRange
                  );
               if (CollectionUtils.isNotEmpty(contrast)) {
                  for (AreaDrawingDetailsDTO dto : contrast) {
                     build.setQuantity(build.getQuantity() + dto.getQuantity());
                     if (dto.getSign() == 1) {
                        build.setDrawingQuantity(build.getDrawingQuantity() + dto.getQuantity());
                     }
                  }
               }

               List<WeldDetailsDTO> weldContrast = this.baseMapper
                  .weldContrast(
                     projectId, mon.getId(), null, project.getProjectType(), productType, null, dataType, null, steelPlateTypeEnum, null, drawingMatchRange
                  );
               if (CollectionUtils.isNotEmpty(weldContrast)) {
                  for (WeldDetailsDTO dto : weldContrast) {
                     if (dto.getSign() == 1) {
                        build.setProductWeldQuantity(build.getProductWeldQuantity() + dto.getQuantity());
                     }
                  }
               }

               List<WeldMapDetailsDTO> weldMapContrast = this.baseMapper
                  .weldMapContrast(
                     projectId, mon.getId(), null, project.getProjectType(), productType, null, dataType, null, steelPlateTypeEnum, null, drawingMatchRange
                  );
               if (CollectionUtils.isNotEmpty(weldMapContrast)) {
                  for (WeldMapDetailsDTO dto : weldMapContrast) {
                     if (dto.getSign() == 1) {
                        build.setProductWeldMapQuantity(build.getProductWeldMapQuantity() + dto.getQuantity());
                     }
                  }
               }
            }

            artifactXMLDwg.add(build);
         }

         pageVO.setContent(artifactXMLDwg);
         return pageVO;
      } else {
         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)
            && dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())
            && ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            artifactXMLDwg = this.baseMapper
               .getArtifactV2Dwg(projectId, project.getProjectType(), productType, dataType, steelPlateTypeEnum, monomerId, areaId);
         } else {
            artifactXMLDwg = this.baseMapper.getArtifactDwg(projectId, project.getProjectType(), productType, dataType, steelPlateTypeEnum, monomerId);
         }

         return new PageVO<>(artifactXMLDwg);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void uploadXMLFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      project.setProjectType(ProjectTypeEnum.MES.getType());
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "单体id不能为空");
      PlanMonomer monomer = null;
      if (monomerId != null) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "导入失败，只能上传zip压缩文件");
      String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, null);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      List<Long> drawingIds = null;
      File file = new File(absolutePath + originalFilename);

      try {
         copyTheFileToANewPath(multipartFile, file);
         List<String> fileNameList = this.unzipFile(file, absolutePath, new HashMap<>());
         drawingIds = new ArrayList<>(fileNameList.size());
         List<String> zipNameList = this.getZipNameList(file);
         Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
         zipNameList = zipNameList.stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
         List<String> finalZipNameList = zipNameList;
         List<TechDrawing> drawings = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getMonomerId, monomerId)
                  .eq(TechDrawing::getProductType, productType)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.XML_FILE.getType())
                  .in(TechDrawing::getSerialNumber, zipNameList)
            )
            .stream()
            .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
            .collect(Collectors.toList());
         Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
         List<TechArtifact> artifacts = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, monomerId).in(TechArtifact::getSerialNumber, zipNameList))
            .stream()
            .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
            .collect(Collectors.toList());
         List<Long> ids = artifacts.stream().map(TechArtifact::getId).collect(Collectors.toList());
         this.checkDrawing(ids, project.getProjectType(), productType);
         List<TechDrawing> needUpdateDrawings = new ArrayList<>();
         List<TechDrawing> needInsertDrawings = new ArrayList<>();

         for (String name : fileNameList) {
            String fileSuffix = FileUtil.getFileExtension(name);
            Preconditions.checkArgument("xml".equalsIgnoreCase(fileSuffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
            String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
            TechDrawing drawing = drawingMap.get(serialNumber);
            if (drawing != null) {
               drawing.setFilePath(filePath);
               drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
               drawing.setCreateTime(LocalDateTime.now());
               needUpdateDrawings.add(drawing);
            }

            if (drawing == null) {
               drawing = TechDrawing.builder()
                  .projectId(projectId)
                  .monomerId(monomerId)
                  .dataType(dataType)
                  .productType(productType)
                  .serialNumber(serialNumber)
                  .filePath(filePath)
                  .fileName(name)
                  .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                  .build();
               needInsertDrawings.add(drawing);
            }

            drawingIds.add(drawing.getId());
         }

         this.updateBatchById(needUpdateDrawings);
         this.saveBatch(needInsertDrawings);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         System.gc();
         file.delete();
      }

      this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, drawingIds);
   }

   @Override
   public PageVO<AreaDrawingDetailsDTO> contrast(
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
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      PageHelper.startPage(pageNumber, pageSize);
      List<AreaDrawingDetailsDTO> aredtos = this.baseMapper
         .contrast(
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            project.getProjectType(),
            productType,
            serialNumber,
            dataType,
            sign,
            steelPlateTypeEnum,
            userName,
            drawingMatchRange
         );
      if (CollectionUtils.isNotEmpty(aredtos)) {
         for (AreaDrawingDetailsDTO aredto : aredtos) {
            ArrayList<String> serialNumbers = new ArrayList<>();
            serialNumbers.add(aredto.getSerialNumber());
            List<TechDrawingDTO> techDrawings = this.baseMapper.selectByType(monomerId, serialNumbers, dataType, productType, drawingMatchRange, areaId);
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               List<Long> ids = techDrawings.stream().map(TechDrawingDTO::getId).collect(Collectors.toList());
               aredto.setDrawingID(ids);
               aredto.setUserName(techDrawings.get(0).getCreateUserName());
               aredto.setCreateTime(techDrawings.get(0).getCreateTime());
               aredto.setUpdateTime(techDrawings.get(0).getUpdateTime());
            }

            if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)
               && org.apache.commons.lang3.StringUtils.isNotBlank(aredto.getSerialNumber())
               && !Character.isDigit(aredto.getSerialNumber().charAt(aredto.getSerialNumber().length() - 1))) {
               aredto.setSign(1);
            }
         }
      }

      return new PageVO<>(aredtos);
   }

   @Override
   public void contrastDownload(
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
   ) {
      PageVO<AreaDrawingDetailsDTO> result = this.contrast(
         projectId, monomerId, areaId, areaBatchId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, 1, 100000
      );
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");

      for (int i = 1; i <= result.getContent().size(); i++) {
         result.getContent().get(i - 1).setIndex(i);
      }

      Map<String, Object> dataMap = new HashMap<>(4);
      dataMap.put("projectName", project.getShortName());
      dataMap.put("monomerName", monomer.getName());
      dataMap.put("tableList", result.getContent());
      dataMap.put("fileType", "产品图纸");
      TemplateExportParams params = new TemplateExportParams("files/FileMatchDetails.xlsx");

      try (Workbook workbook = ExcelExportUtil.exportExcel(params, dataMap)) {
         PoiUtils.unBuilderDownLoadExcel("文件匹配详情-（" + project.getShortName() + "）.xlsx", this.response, workbook);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public PageVO InstructionLink(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      String serialNumber,
      Integer dataType,
      Integer drawingid,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<InstructionLinkDTO> instructionLink = this.baseMapper.InstructionLink(projectId, monomerId, areaId, productType, serialNumber, dataType, drawingid);
      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO deleteDrawing(IdsDTO ids) {
      Set<Long> set = ids.getIds();
      List<TechDrawing> techDrawings = this.baseMapper.selectList(Wrappers.lambdaQuery(TechDrawing.class).in(TechDrawing::getId, set));
      List<Long> monomerIds = techDrawings.stream().map(TechDrawing::getMonomerId).distinct().collect(Collectors.toList());
      if (!UserUtil.getCurrentUser().isAdmin()) {
         for (Long monomerId : monomerIds) {
            List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
               .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, monomerId));
            Preconditions.checkArgument(
               CollectionUtils.isNotEmpty(monomerUserLinkList)
                  && monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList()).contains(UserUtil.getCurrentUserId()),
               "您不是该单体深化负责人,不允许删除文件!"
            );
         }
      }

      List<Long> projectIds = techDrawings.stream().map(TechDrawing::getProjectId).distinct().collect(Collectors.toList());
      Map<Long, Integer> projectMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, ContractProject::getProjectType));
      Map<Long, List<TechDrawing>> collect = techDrawings.stream().collect(Collectors.groupingBy(TechDrawing::getMonomerId));

      for (Long aLong : collect.keySet()) {
         List<TechDrawing> techDrawings1 = collect.get(aLong);
         Long projectId = techDrawings1.get(0).getProjectId();
         Map<String, List<TechDrawing>> collect1 = techDrawings1.stream().collect(Collectors.groupingBy(s -> s.getProductType() + ""));
         if (collect1.get(ProductTypeEnum.ARTIFACT.getType() + "") != null) {
            Set<String> serialNumbers = collect1.get(ProductTypeEnum.ARTIFACT.getType() + "")
               .stream()
               .map(TechDrawing::getSerialNumber)
               .collect(Collectors.toSet());
            List<Long> artids = this.artifactService
               .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, aLong).in(TechArtifact::getSerialNumber, serialNumbers))
               .stream()
               .map(TechArtifact::getId)
               .distinct()
               .collect(Collectors.toList());
            this.checkDrawing(artids, projectMap.get(projectId), ProductTypeEnum.ARTIFACT.getType());
         }

         if (collect1.get(ProductTypeEnum.ASSEMBLE.getType() + "") != null) {
            List<TechDrawing> techDrawings2 = collect1.get(ProductTypeEnum.ASSEMBLE.getType() + "");
            Set<String> serialNumbers = techDrawings2.stream().map(TechDrawing::getSerialNumber).collect(Collectors.toSet());
            List<Long> assids = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, aLong).in(TechAssemble::getInitialSerialNumber, serialNumbers))
               .stream()
               .map(TechAssemble::getId)
               .distinct()
               .collect(Collectors.toList());
            this.checkDrawing(assids, projectMap.get(projectId), ProductTypeEnum.ASSEMBLE.getType());
         }

         if (collect1.get("null") != null) {
            Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
            List<Long> areaIds = new ArrayList<>();
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               areaIds = techDrawings1.stream().map(TechDrawing::getAreaId).distinct().collect(Collectors.toList());
            }

            Set<String> serialNumbers = collect1.get("null").stream().map(TechDrawing::getSerialNumber).collect(Collectors.toSet());
            List<Long> machids = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getMonomerId, aLong)
                     .in(CollectionUtils.isNotEmpty(areaIds), TechMachinePart::getAreaId, areaIds)
                     .in(TechMachinePart::getSerialNumber, serialNumbers)
               )
               .stream()
               .map(TechMachinePart::getId)
               .distinct()
               .collect(Collectors.toList());
            this.checkDrawing(machids, projectMap.get(projectId), ProductTypeEnum.MACHINE_PART.getType());
         }
      }

      List<Long> list = new ArrayList<>(set);
      return this.deleteDrawings(list);
   }

   @Override
   public ResultVO updateFile(
      Long productId,
      Integer productType,
      Integer dataType,
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) throws Exception {
      Long deleId = this.getDataId(productId, productType, dataType, multipartFile, projectId, monomerId);
      return this.achievementBiz
         .createDrawingApprove(
            multipartFile,
            projectId,
            monomerId,
            areaId,
            deleId,
            dataType,
            productType,
            productId,
            null,
            PlanFileOverlayEnum.DRAWING_NUMERICAL_CONTROL_XML.getType(),
            false,
            this.response
         );
   }

   @Override
   public Long getDataId(Long productId, Integer productType, Integer dataType, MultipartFile multipartFile, Long projectId, Long monomerId) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      Long deleId = null;
      List<Long> pid = new ArrayList<>();
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact techart = this.artifactService.getById(productId);
         if (techart != null) {
            pid.add(techart.getId());
         }
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.techAssembleService.getById(productId);
         if (assemble != null) {
            pid.add(assemble.getId());
         }
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         if (machinePart != null) {
            pid.add(machinePart.getId());
         }
      } else {
         Preconditions.checkArgument(false, "产品类型不正确");
      }

      String serial = this.artifactService.selectByTypeAndId(productType, productId);
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      this.checkDrawing(pid, project.getProjectType(), productType);
      String originalFilename = multipartFile.getOriginalFilename();
      originalFilename = this.transformLowercaseSuffix(originalFilename);
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      PlanMonomer monomer = null;
      String serialNumber = originalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
      if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "修改失败，单体不存在");
         Preconditions.checkArgument(serial.equals(serialNumber), "修改失败,本张图纸与本构件编号不符!");
         if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(TechDrawing::getProductType, productType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .eq(TechDrawing::getSerialNumber, serialNumber)
               );
            TechDrawing drawing = drawings.stream().filter(s -> s.getSerialNumber().equals(serialNumber)).findFirst().orElse(null);
            Preconditions.checkArgument(drawing != null, "修改失败原图纸不存在");
            Preconditions.checkArgument("nc1".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "部件图纸格式不正确!");
            deleId = drawing.getId();
         } else {
            Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "零件图纸格式不正确!");
            TechDrawing drawing = this.baseMapper
               .selectOne(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .isNull(TechDrawing::getProductType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .eq(TechDrawing::getSerialNumber, serialNumber)
               );
            Preconditions.checkArgument(drawing != null, "修改失败原图纸不存在");
            deleId = drawing.getId();
         }
      }

      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
         }

         Map<String, Object> map = new HashMap<>();
         Preconditions.checkArgument("dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            map = this.getSerialAndOrder(serialNumber, rules.getType());
         }

         QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("project_id", projectId)
            .eq("monomer_id", monomerId)
            .eq("data_type", dataType)
            .eq("product_type", productType)
            .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
         Preconditions.checkArgument(
            serial.equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber), "修改失败,本张图纸与本构件编号不符!"
         );
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            if (map.get("number") == null) {
               queryWrapper.eq("number", 0);
            } else {
               queryWrapper.eq("number", map.get("number"));
            }

            if (map.get("dwgNum") == null) {
               queryWrapper.isNull("dwg_num");
            } else {
               queryWrapper.eq("dwg_num", map.get("dwgNum"));
            }
         }

         List<TechDrawing> drawings = this.baseMapper.selectList(queryWrapper);
         Map<String, Object> finalMap = map;
         TechDrawing drawing = drawings.stream()
            .filter(
               s -> s.getSerialNumber().equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? finalMap.get("serialNumber") : serialNumber)
            )
            .findFirst()
            .orElse(null);
         Preconditions.checkArgument(drawing != null, "修改失败本张图纸与本构件编号不符");
         deleId = drawing.getId();
      }

      return deleId;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO newUpdateFile(
      Long productId,
      Integer productType,
      Integer dataType,
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      if (monomerId != null && !UserUtil.getCurrentUser().isAdmin()) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, monomerId));
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(monomerUserLinkList)
               || !monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList()).contains(UserUtil.getCurrentUserId()),
            "您不是该单体深化负责人,不允许导入文件!"
         );
      }

      List<Long> pid = new ArrayList<>();
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact techart = this.artifactService.getById(productId);
         if (techart != null) {
            pid.add(techart.getId());
         }
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.techAssembleService.getById(productId);
         if (assemble != null) {
            pid.add(assemble.getId());
         }
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         if (machinePart != null) {
            pid.add(machinePart.getId());
         }
      } else {
         Preconditions.checkArgument(false, "产品类型不正确");
      }

      ContractProject project = this.projectService.checkProjectStatus(projectId);
      this.checkDrawing(pid, project.getProjectType(), productType);
      String originalFilename = multipartFile.getOriginalFilename();
      originalFilename = this.transformLowercaseSuffix(originalFilename);
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      PlanMonomer monomer = null;
      String serialNumber = originalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
      ArrayList<Long> drawingIds = new ArrayList<>();
      String serial = this.artifactService.selectByTypeAndId(productType, productId);
      if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "修改失败，单体不存在");
         Preconditions.checkArgument(serial.equals(serialNumber), "修改失败,本张图纸与本构件编号不符!");
         if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(TechDrawing::getProductType, productType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .eq(TechDrawing::getSerialNumber, serialNumber)
               );
            TechDrawing drawing = drawings.stream().filter(s -> s.getSerialNumber().equals(serialNumber)).findFirst().orElse(null);
            Preconditions.checkArgument(drawing != null, "修改失败原图纸不存在");
            Preconditions.checkArgument("nc1".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "部件图纸格式不正确!");
            String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();
            File destinationFile = new File(absolutePath, originalFilename);
            copyTheFileToANewPath(multipartFile, destinationFile);
            BigDecimal Nc1Length = BigDecimal.ZERO;

            try {
               Nc1Length = BigDecimal.valueOf(NC1Parser.getAssembleRealLength(absolutePath + originalFilename));
            } catch (IOException e) {
               e.printStackTrace();
               Preconditions.checkArgument(false, "图纸解析异常,请重新导入");
            }

            List<TechAssemble> techAssembles = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).eq(TechAssemble::getInitialSerialNumber, serialNumber));
            if (CollectionUtils.isNotEmpty(techAssembles)) {
               BigDecimal finalNc1Length = Nc1Length;
               List<TechAssemble> collect = techAssembles.stream()
                  .map(s -> s.setBoolHaveNC1(Boolean.TRUE))
                  .map(ex -> ex.setNc1Length(finalNc1Length))
                  .collect(Collectors.toList());
               this.assembleService.updateBatchById(collect);
            }

            drawing.setNc1Length(Nc1Length);
            drawing.setCreateTime(LocalDateTime.now());
            drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
            this.baseMapper.updateById(drawing);
            drawingIds.add(drawing.getId());
         } else {
            Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               PlanArea area = this.areaService.getById(areaId);
               Preconditions.checkArgument(area != null, "操作失败,区域不存在!");
            }

            Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "零件图纸格式不正确!");
            List<String> originalFilenameList = new ArrayList<>();
            originalFilenameList.add(originalFilename);
            List<TechMachinePart> machineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .eq(TechMachinePart::getSerialNumber, serialNumber)
               );
            if (CollectionUtils.isNotEmpty(machineParts)) {
               List<TechMachinePart> wingWebPlateList = machineParts.stream()
                  .filter(
                     ex -> ex.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        && !ex.getSourcePartEnum().equals(SourcePartEnum.DIRECTLY_IMPORT.getType())
                  )
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(wingWebPlateList)) {
                  List<String> initialSerialNumbers = wingWebPlateList.stream()
                     .map(TechMachinePart::getInitialSerialNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  Map<String, List<TechMachinePart>> machinePartMap = this.machinePartService
                     .list(
                        Wrappers.lambdaQuery(TechMachinePart.class)
                           .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                           .eq(TechMachinePart::getMonomerId, monomerId)
                           .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                           .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                           .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_DISASSEMBLY.getType())
                           .in(TechMachinePart::getInitialSerialNumber, initialSerialNumbers)
                           .notIn(TechMachinePart::getSerialNumber, initialSerialNumbers)
                     )
                     .stream()
                     .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
                  Map<String, List<TechMachinePart>> wingWebPlateListMap = wingWebPlateList.stream()
                     .collect(Collectors.groupingBy(ex -> ex.getSourcePartEnum() + "#" + ex.getInitialSerialNumber()));
                  wingWebPlateListMap.forEach(
                     (initialSerialNumberAndSourcePartEnum, partList) -> {
                        Integer sourcePartEnum = Integer.valueOf(initialSerialNumberAndSourcePartEnum.split("#")[0]);
                        String initialSerialNumber = initialSerialNumberAndSourcePartEnum.split("#")[1];
                        if (SourcePartEnum.COMPONENT_DISASSEMBLY.getType().equals(sourcePartEnum)) {
                           List<TechMachinePart> machinePartList = partList.stream()
                              .filter(ex -> !ex.getSerialNumber().equals(initialSerialNumber) && ex.getSourcePartEnum().equals(sourcePartEnum))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(machinePartList)) {
                              List<TechMachinePart> techMachineParts = machinePartMap.get(initialSerialNumber);
                              if (CollectionUtils.isNotEmpty(techMachineParts)) {
                                 List<String> serialNumbers = techMachineParts.stream()
                                    .map(TechMachinePart::getSerialNumber)
                                    .distinct()
                                    .collect(Collectors.toList());
                                 if (serialNumbers.size() == 1) {
                                    machineParts.addAll(techMachineParts);
                                    originalFilenameList.add(serialNumbers.get(0) + ".dxf");
                                 }
                              }
                           } else {
                              machinePartList.forEach(ex -> ex.setBoolItsOwnDrawing(Boolean.TRUE));
                              this.machinePartService.updateBatchById(machinePartList);
                           }
                        }
                     }
                  );
               }
            }

            List<TechMachinePart> componentCombinationPartList = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                     .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_COMBINATION.getType())
                     .eq(TechMachinePart::getInitialSerialNumber, serialNumber)
               );
            if (CollectionUtils.isNotEmpty(componentCombinationPartList)) {
               machineParts.addAll(componentCombinationPartList);

               for (String componentCombinationPart : componentCombinationPartList.stream()
                  .map(TechMachinePart::getSerialNumber)
                  .distinct()
                  .collect(Collectors.toList())) {
                  originalFilenameList.add(componentCombinationPart + ".dxf");
               }
            }

            TechDrawing drawing = this.baseMapper
               .selectOne(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                     .isNull(TechDrawing::getProductType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .eq(TechDrawing::getSerialNumber, serialNumber)
               );
            Preconditions.checkArgument(drawing != null, "修改失败原图纸不存在");
            String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();
            File file = null;
            List<DXFUploadFailDTO> dxfUploadFailDTOList = new ArrayList<>();

            try {
               File destinationFile = new File(absolutePath, originalFilename);
               copyTheFileToANewPath(multipartFile, destinationFile);
               CorrectDXF.resolverDXFForImport(destinationFile);
            } catch (Exception e) {
               throw new IllegalArgumentException(e.getMessage());
            }

            if (CollectionUtils.isNotEmpty(dxfUploadFailDTOList)) {
               exportMistakeList(dxfUploadFailDTOList, this.response);
               return ResultVO.builder().build();
            }

            for (String newOriginalFilename : originalFilenameList) {
               String newSerialNumber = newOriginalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
               if (!newOriginalFilename.equals(originalFilename)) {
                  try {
                     Files.copy(file.toPath(), Paths.get(absolutePath + newOriginalFilename), StandardCopyOption.COPY_ATTRIBUTES);
                  } catch (IOException e) {
                     throw new RuntimeException(e);
                  }
               }

               TechDrawing newDrawing = this.baseMapper
                  .selectOne(
                     Wrappers.lambdaQuery(TechDrawing.class)
                        .eq(TechDrawing::getProjectId, projectId)
                        .eq(TechDrawing::getMonomerId, monomerId)
                        .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                        .isNull(TechDrawing::getProductType)
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                        .eq(TechDrawing::getSerialNumber, newSerialNumber)
                  );
               Preconditions.checkArgument(newDrawing != null, "修改失败原图纸不存在");
               String newOssRelativePath = projectId + "/" + monomerId + "/" + newOriginalFilename;
               String newLocalAbsoluteFilePath = absolutePath + newOriginalFilename;
               OSS client = this.ossUtils.openClient();
               String dxfUrl = this.ossUtils.uploadFile(client, newOssRelativePath, newLocalAbsoluteFilePath);
               this.setMachinePartPath(project, monomerId, newSerialNumber, dxfUrl, newOssRelativePath, drawingMatchRange, areaId);
               newDrawing.setCreateTime(LocalDateTime.now());
               newDrawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
               String drawingUrl = this.transformationDxf(newDrawing.getFilePath(), newDrawing.getFileName(), newDrawing.getSerialNumber(), 1);
               newDrawing.setPicturePath(drawingUrl);
               this.baseMapper.updateById(newDrawing);
               this.baseMapper.updateById(drawing);
               this.updateRadius(newDrawing);
               drawingIds.add(newDrawing.getId());
            }
         }
      }

      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
         }

         Map<String, Object> map = new HashMap<>();
         Preconditions.checkArgument("dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            map = this.getSerialAndOrder(serialNumber, rules.getType());
         }

         QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("project_id", projectId)
            .eq("monomer_id", monomerId)
            .eq("data_type", dataType)
            .eq("product_type", productType)
            .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
         Preconditions.checkArgument(
            serial.equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber), "修改失败,本张图纸与本构件编号不符!"
         );
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            if (map.get("number") == null) {
               queryWrapper.eq("number", 0);
            } else {
               queryWrapper.eq("number", map.get("number"));
            }

            if (map.get("dwgNum") == null) {
               queryWrapper.isNull("dwg_num");
            } else {
               queryWrapper.eq("dwg_num", map.get("dwgNum"));
            }
         }

         List<TechDrawing> drawings = this.baseMapper.selectList(queryWrapper);
         Map<String, Object> finalMap = map;
         TechDrawing drawing = drawings.stream()
            .filter(
               s -> s.getSerialNumber().equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? finalMap.get("serialNumber") : serialNumber)
            )
            .findFirst()
            .orElse(null);
         Preconditions.checkArgument(drawing != null, "修改失败本张图纸与本构件编号不符");
         this.setDrawingArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);
         String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
            && rules.getType().equals(SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType())) {
            Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
         }

         File destinationFile = new File(absolutePath, originalFilename);
         copyTheFileToANewPath(multipartFile, destinationFile);
         drawing.setCreateTime(LocalDateTime.now());
         drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
         drawing.setFileName(originalFilename);
         this.baseMapper.updateById(drawing);
         drawingIds.add(drawing.getId());
      }

      if (dataType.equals(TechDataTypeEnum.XML_FILE.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         Preconditions.checkArgument(serial.equals(serialNumber), "修改失败,本张图纸与本构件编号不符!");
         Preconditions.checkArgument(ProductTypeEnum.ARTIFACT.getType().equals(productType), ProductTypeEnum.getNameByType(dataType) + "只有构件存在xml图纸!");
         Preconditions.checkArgument("xml".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "构件图纸格式不正确!");
         List<TechDrawing> drawings = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getProjectId, projectId)
                  .eq(TechDrawing::getMonomerId, monomerId)
                  .eq(TechDrawing::getProductType, productType)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.XML_FILE.getType())
                  .eq(TechDrawing::getSerialNumber, serialNumber)
            );
         TechDrawing drawing = drawings.stream().filter(s -> s.getSerialNumber().equals(serialNumber)).findFirst().orElse(null);
         Preconditions.checkArgument(drawing != null, "修改失败原图纸不存在");
         String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();
         File destinationFile = new File(absolutePath, originalFilename);
         copyTheFileToANewPath(multipartFile, destinationFile);
         drawing.setCreateTime(LocalDateTime.now());
         drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
         this.baseMapper.updateById(drawing);
         drawingIds.add(drawing.getId());
      }

      this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, drawingIds);
      return ResultVO.builder().build();
   }

   public static File createTempFileFromMultipart(MultipartFile multipartFile) throws IOException {
      Path tempFile = Files.createTempFile(null, ".tmp");
      multipartFile.transferTo(tempFile.toFile());
      return tempFile.toFile();
   }

   public static void deleteTempFile(File tempFile) {
      if (tempFile.exists()) {
         boolean deleted = tempFile.delete();
         if (deleted) {
            System.out.println("临时文件删除成功");
         } else {
            System.out.println("临时文件删除失败");
         }
      }
   }

   @Override
   public Boolean deletefileByUrls(List<String> paths) {
      for (String path : paths) {
         File file = new File(path);
         if (file.exists()) {
            file.delete();
         }
      }

      return Boolean.TRUE;
   }

   public Boolean updateRadius(TechDrawing drawing) {
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      HoleRadiusDTO holeRadiusDTO = this.parseDrawing(drawing.getFilePath(), drawing.getFileName());
      if (drawing.getProjectType().equals(ProjectTypeEnum.MES.getType()) || drawing.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
         List<TechMachinePart> list = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .eq(TechMachinePart::getSerialNumber, drawing.getSerialNumber())
                  .eq(TechMachinePart::getMonomerId, drawing.getMonomerId())
                  .eq(
                     SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange) && drawing.getAreaId() != null, TechMachinePart::getAreaId, drawing.getAreaId()
                  )
                  .in(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ARTIFACT.getType(), MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
            );
         list.forEach(machinePart -> {
            machinePart.setBoolHaveHole(holeRadiusDTO.getHoleNumber() > 0);
            machinePart.setHoleNumber((long)holeRadiusDTO.getHoleNumber().intValue());
         });
         this.machinePartService.updateBatchById(list);
      }

      this.machineHoleRadiusLinkService
         .remove(
            Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
               .eq(TechMachineHoleRadiusLink::getMonomerId, drawing.getMonomerId())
               .eq(
                  SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange) && drawing.getAreaId() != null,
                  TechMachineHoleRadiusLink::getAreaId,
                  drawing.getAreaId()
               )
               .eq(TechMachineHoleRadiusLink::getSerialNumber, drawing.getSerialNumber())
         );
      Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

      for (Double aDouble : map.keySet()) {
         TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
            .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
            .quantity(map.get(aDouble).intValue())
            .serialNumber(drawing.getSerialNumber())
            .dataType(TechDataTypeEnum.NC_DRAWING.getType())
            .monomerId(drawing.getMonomerId())
            .drawingId(drawing.getId())
            .fileName(drawing.getFileName())
            .build();
         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            build.setAreaId(drawing.getAreaId());
         }

         this.machineHoleRadiusLinkService.save(build);
      }

      return Boolean.TRUE;
   }

   @Override
   public HoleRadiusDTO parseDrawing(String filePath, String fileName) {
      try {
         String path = this.configProperties.getFilePath() + filePath + fileName;
         HoleRadiusDTO numberAndRadius = DxfUtils.getNumberAndRadius(path);
         Integer holeNumber = numberAndRadius.getHoleNumber();
         Integer sum = 0;
         Map<Double, Long> holeRadiusMap = numberAndRadius.getHoleRadiusMap();

         for (Long value : holeRadiusMap.values()) {
            sum = sum + value.intValue();
         }

         Preconditions.checkArgument(holeNumber.equals(sum), fileName + "图纸解析错误请联系管理员");
         return numberAndRadius;
      } catch (Exception e) {
         log.error("dxf文件解析报错-------------------->", e);
         throw new BusinessException(fileName + "文件解析报错");
      }
   }

   @Override
   public String transformationDxf(String filePath, String fileName, String serialNumber, Integer imageType) {
      String path = this.configProperties.getFilePath() + filePath + fileName;
      String outDirectory = this.configProperties.getFilePath() + filePath;

      try {
         DxfUtils.getPicture(path, imageType, outDirectory);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return filePath + serialNumber + "." + ImageTypeEnums.getNameByType(imageType);
   }

   @Override
   public void downloadDrawingPDF(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException {
      try {
         ContractProject project = this.projectService.getById(projectId);
         PlanMonomer monomer = this.monomerService.getById(monomerId);
         response.setCharacterEncoding("UTF-8");
         response.setHeader("Content-Type", "application/pdf");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader(
            "Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8")
         );
         if (project == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("项目信息不存在", "UTF-8"));
            return;
         }

         if (monomer == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("单体信息不存在", "UTF-8"));
            return;
         }

         TechDrawing techDrawing = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getMonomerId, monomerId)
                  .eq(TechDrawing::getProductType, taskTypeEnum)
                  .eq(TechDrawing::getSerialNumber, serialNumber)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType())
            );
         if (techDrawing != null) {
            String dirByType = DrawingProductTypeEnum.getDirByType(taskTypeEnum);
            String sourcepath = this.configProperties.getFilePath()
               + "tech_data"
               + File.separator
               + "deepen_drawing"
               + File.separator
               + dirByType
               + File.separator
               + projectId
               + File.separator
               + monomerId
               + File.separator
               + serialNumber
               + ".pdf";
            File sourcefolder = new File(sourcepath);
            if (!sourcefolder.exists()) {
               response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("未找到对应文件", "UTF-8"));
            } else {
               FileUtil.downloadFile(sourcefolder, serialNumber + ".pdf");
            }

            return;
         }

         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("未查询到深化图纸", "UTF-8"));
      } catch (Exception e) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.ERROR.getMessage(), "UTF-8"));
         return;
      } finally {
         System.gc();
      }
   }

   @Override
   public void downloadDrawingPDFFile(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, DownloadDrawingDTO drawingDTO, Integer taskTypeEnum, HttpServletResponse response
   ) throws IOException {
      ContractProject project = this.projectService.getById(projectId);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      response.setCharacterEncoding("UTF-8");
      response.setHeader("Content-Type", "application/zip");
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Expose-Headers", "*");
      response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8"));
      if (project == null) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("项目信息不存在", "UTF-8"));
      } else if (monomer == null) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("单体信息不存在", "UTF-8"));
      } else {
         String dirByType = DrawingProductTypeEnum.getDirByType(taskTypeEnum);
         String projectShortName = project.getShortName();
         String monomerName = monomer.getName();
         String sourcepath = this.configProperties.getFilePath()
            + "tech_data"
            + File.separator
            + "deepen_drawing"
            + File.separator
            + dirByType
            + File.separator
            + projectId
            + File.separator
            + monomerId
            + File.separator;
         String weldMapPath = this.configProperties.getFilePath()
            + "tech_data"
            + File.separator
            + "deepen_drawing"
            + File.separator
            + dirByType
            + File.separator
            + projectId
            + File.separator
            + monomerId
            + File.separator
            + "map"
            + File.separator;
         String runId = UUID.randomUUID().toString().replace("-", "");
         String runRootPath = this.configProperties.getFilePath()
            + "DrawingPDFAndWeldMark"
            + File.separator
            + dirByType
            + File.separator
            + runId
            + File.separator;
         String targetpath = runRootPath + project.getShortName() + "_" + monomer.getName() + File.separator;
         String matchedTargetpath = targetpath + "已匹配图纸" + File.separator;
         String noMatchedTargetpath = targetpath + "未匹配图纸" + File.separator;
         String zipPath = this.configProperties.getFilePath() + "DrawingPDFAndWeldMark" + File.separator + dirByType + File.separator + runId + ".zip";
         List<String> serialNumberList = this.getFilteredSerialNumbers(
            this.baseMapper.findDwg(projectId, monomerId, areaId, areaBatchId, project.getProjectType(), taskTypeEnum, TechDataTypeEnum.DEEPEN.getType(), null),
            drawingDTO.getSerialNumbers(),
            ".pdf"
         );
         List<String> weldSerialNumberList = this.baseMapper
            .findWeld(projectId, monomerId, areaId, project.getProjectType(), taskTypeEnum, TechDataTypeEnum.DEEPEN.getType(), null);
         if (CollectionUtils.isNotEmpty(weldSerialNumberList) && CollectionUtils.isNotEmpty(drawingDTO.getSerialNumbers())) {
            weldSerialNumberList = weldSerialNumberList.stream().filter(drawingDTO.getSerialNumbers()::contains).distinct().collect(Collectors.toList());
         }

         weldSerialNumberList = weldSerialNumberList.stream().map(ex -> ex.concat(".mark")).collect(Collectors.toList());
         serialNumberList.addAll(weldSerialNumberList);
         List<String> weldMapSerialNumberList = this.baseMapper
            .findWeldMap(
               projectId, monomerId, areaId, project.getProjectType(), taskTypeEnum, TechDataTypeEnum.DEEPEN.getType(), null, drawingDTO.getSerialNumbers()
            );
         serialNumberList.addAll(weldMapSerialNumberList);
         serialNumberList.removeAll(Collections.singleton(null));
         File sourcefolder = new File(sourcepath);
         File weldMapFolder = new File(weldMapPath);
         File targetfolder = new File(targetpath);
         File matchedTargetfolder = new File(matchedTargetpath);
         File noMatchedTargetfolder = new File(noMatchedTargetpath);

         try {
            if (!targetfolder.exists()) {
               targetfolder.mkdirs();
            }

            if (!matchedTargetfolder.exists()) {
               matchedTargetfolder.mkdirs();
            }

            if (!noMatchedTargetfolder.exists()) {
               noMatchedTargetfolder.mkdirs();
            }

            boolean onlyMatched = CollectionUtils.isNotEmpty(drawingDTO.getSerialNumbers());
            this.copyFilesFromDirectory(sourcefolder, targetfolder, matchedTargetfolder, noMatchedTargetfolder, serialNumberList, onlyMatched);
            File[] weldMapFiles = weldMapFolder.listFiles();
            if (weldMapFiles != null) {
               for (File file : weldMapFiles) {
                  if (file.isFile()) {
                     if (isContains(file, serialNumberList)) {
                        File newTargetFile = new File(matchedTargetfolder, "(焊缝图纸)" + file.getName());
                        FileUtils.copyFile(file, newTargetFile);
                     } else if (!onlyMatched) {
                        File newTargetFile = new File(noMatchedTargetfolder, "(焊缝图纸)" + file.getName());
                        FileUtils.copyFile(file, newTargetFile);
                     }
                  }
               }
            }

            PlanArea area = this.areaService.getById(areaId);
            ZIPUtils.toZip(zipPath, targetpath, true);
            File dwfile = new File(zipPath);
            StringBuilder FileName = new StringBuilder(project.getShortName() + "_" + monomer.getName());
            if (area != null) {
               FileName.append(area.getName());
            }

            FileName.append(".zip");
            FileUtil.downloadFile(dwfile, FileName.toString());
         } catch (Exception e) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.ERROR.getMessage(), "UTF-8"));
         } finally {
            FileUtil.deleteDir(runRootPath);
            FileUtil.deleteFile(zipPath);
            System.gc();
         }
      }
   }

   @Override
   public void downloadAllDrawingPDFFile(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, DownloadDrawingDTO drawingDTO, Integer taskTypeEnum, HttpServletResponse response
   ) throws IOException {
      ContractProject project = this.projectService.getById(projectId);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      if (project != null && monomer != null) {
         PlanArea area = null;
         if (areaId != null) {
            area = this.areaService.getById(areaId);
         }

         StringBuilder fileNameSb = new StringBuilder(project.getShortName()).append("_").append(monomer.getName());
         if (area != null && StrUtil.isNotBlank(area.getName())) {
            fileNameSb.append(area.getName());
         }

         fileNameSb.append(".zip");
         String downloadFileName = fileNameSb.toString();
         response.setCharacterEncoding("UTF-8");
         response.setHeader("Content-Type", "application/zip");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader(
            "Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8")
         );
         if (project == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("项目信息不存在", "UTF-8"));
         } else if (monomer == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("单体信息不存在", "UTF-8"));
         } else {
            try (ZipOutputStream zos = new ZipOutputStream(response.getOutputStream())) {
               for (Integer taskType : Arrays.asList(
                  ProductTypeEnum.ARTIFACT.getType(),
                  ProductTypeEnum.ASSEMBLE.getType(),
                  ProductTypeEnum.MACHINE_PART.getType(),
                  ProductTypeEnum.ALL_PRODUCT.getType()
               )) {
                  String dirByType = DrawingProductTypeEnum.getDirByType(taskType);
                  if (StrUtil.isBlank(dirByType)) {
                     log.warn("该taskType:{} 获取dirByType为空，跳过", taskType);
                  } else {
                     List<String> serialNumberList = new ArrayList<>();
                     if (!ProductTypeEnum.ALL_PRODUCT.getType().equals(taskType)) {
                        serialNumberList = this.getFilteredSerialNumbers(
                           this.baseMapper
                              .findDwg(projectId, monomerId, areaId, areaBatchId, project.getProjectType(), taskType, TechDataTypeEnum.DEEPEN.getType(), null),
                           drawingDTO.getSerialNumbers(),
                           ".pdf"
                        );
                     }

                     if (ProductTypeEnum.ALL_PRODUCT.getType().equals(taskType)) {
                        serialNumberList = this.baseMapper
                           .selectList(
                              (Wrapper<TechDrawing>)(new LambdaQueryWrapper<TechDrawing>().eq(TechDrawing::getProductType, taskType))
                                 .eq(TechDrawing::getMonomerId, monomerId)
                           )
                           .stream()
                           .map(TechDrawing::getSerialNumber)
                           .distinct()
                           .collect(Collectors.toList());
                     }

                     serialNumberList.removeIf(Objects::isNull);
                     String sourcepath = this.configProperties.getFilePath()
                        + "tech_data"
                        + File.separator
                        + "deepen_drawing"
                        + File.separator
                        + dirByType
                        + File.separator
                        + projectId
                        + File.separator
                        + monomerId
                        + File.separator;
                     File sourcefolder = new File(sourcepath);
                     if (sourcefolder.exists() && sourcefolder.isDirectory()) {
                        if (!ProductTypeEnum.ALL_PRODUCT.getType().equals(taskType)) {
                           zos.putNextEntry(new ZipEntry(DrawingProductTypeEnum.getNameByType(taskType) + "/已匹配图纸/"));
                           zos.closeEntry();
                        }

                        zos.putNextEntry(new ZipEntry(DrawingProductTypeEnum.getNameByType(taskType) + "/未匹配图纸/"));
                        zos.closeEntry();
                        File[] files = sourcefolder.listFiles();
                        if (files != null) {
                           for (File file : files) {
                              if (file.isFile() && !file.getName().contains("zip")) {
                                 boolean matched = isContains(file, serialNumberList);
                                 String prefix = file.getName().toLowerCase().contains("pdf") ? "(工艺图纸)" : "";
                                 String innerZipDir = "";
                                 if (!ProductTypeEnum.ALL_PRODUCT.getType().equals(taskType)) {
                                    innerZipDir = matched
                                       ? DrawingProductTypeEnum.getNameByType(taskType) + "/已匹配图纸/"
                                       : DrawingProductTypeEnum.getNameByType(taskType) + "/未匹配图纸/";
                                 }

                                 if (ProductTypeEnum.ALL_PRODUCT.getType().equals(taskType)) {
                                    if (!matched) {
                                       continue;
                                    }

                                    innerZipDir = DrawingProductTypeEnum.getNameByType(taskType) + "/未匹配图纸/";
                                 }

                                 String zipEntryPath = innerZipDir + prefix + file.getName();
                                 ZipEntry zipEntry = new ZipEntry(zipEntryPath);
                                 zos.putNextEntry(zipEntry);

                                 try (FileInputStream fis = new FileInputStream(file)) {
                                    byte[] buffer = new byte[8192];

                                    int len;
                                    while ((len = fis.read(buffer)) != -1) {
                                       zos.write(buffer, 0, len);
                                    }
                                 }

                                 zos.closeEntry();
                              }
                           }
                        }
                     } else {
                        log.warn("产品类型{} 源目录不存在 sourcepath={}", taskType, sourcepath);
                     }
                  }
               }

               zos.finish();
            } catch (IOException e) {
               log.error("多产品图纸打包下载IO异常", e);
               throw new RuntimeException("图纸打包下载异常", e);
            }
         }
      } else {
         throw new RuntimeException("项目或单体信息不存在");
      }
   }

   private List<String> getFilteredSerialNumbers(List<String> sourceList, List<String> filterList, String extension) {
      if (CollectionUtils.isEmpty(sourceList)) {
         return new ArrayList<>();
      }

      List<String> filteredList = CollectionUtils.isNotEmpty(filterList)
         ? sourceList.stream().filter(filterList::contains).distinct().collect(Collectors.toList())
         : sourceList;
      return filteredList.stream().map(e -> e + extension).collect(Collectors.toList());
   }

   private void copyFilesFromDirectory(
      File sourceDir, File targetDir, File matchedTargetDir, File noMatchedTargetDir, List<String> serialNumberList, boolean onlyMatched
   ) throws IOException {
      File[] files = sourceDir.listFiles();
      if (files != null) {
         for (File file : files) {
            if (file.isFile()) {
               boolean matched = isContains(file, serialNumberList);
               if (matched) {
                  String prefix = file.getName().toLowerCase().contains("pdf") ? "(工艺图纸)" : "";
                  FileUtils.copyFile(file, new File(matchedTargetDir, prefix + file.getName()));
               } else if (!onlyMatched) {
                  String prefix = file.getName().toLowerCase().contains("pdf") ? "(工艺图纸)" : "";
                  FileUtils.copyFile(file, new File(noMatchedTargetDir, prefix + file.getName()));
               }
            }
         }
      }
   }

   private static boolean isContains(File file, List<String> serialNumberList) {
      AtomicReference<Boolean> boolContains = new AtomicReference<>(false);
      serialNumberList.forEach(e -> {
         String replaced = e.replaceAll("(\\(|（)[^)]*(\\)|）)", "");
         String result = "";
         if (replaced.contains(" ")) {
            String[] parts = replaced.split(" ");
            result = parts[parts.length - 1];
         } else {
            result = replaced;
         }

         if (file.getName().contains(result)) {
            boolContains.set(true);
         }
      });
      return boolContains.get();
   }

   @Override
   public void downloadMachinePartDxfFile(Long projectId, Long monomerId, Long areaId) {
      ContractProject project = this.projectService.getById(projectId);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(project != null, "项目信息不存在");
      Preconditions.checkArgument(monomer != null, "单体不存在");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
         PlanArea area = this.areaService.getById(areaId);
         Preconditions.checkArgument(area != null, "区域不存在!");
         List<ProductDrawingsSummaryDTO> artifactDwg = this.baseMapper
            .getArtifactV2Dwg(
               projectId, project.getProjectType(), ProductTypeEnum.MACHINE_PART.getType(), TechDataTypeEnum.NC_DRAWING.getType(), null, monomerId, areaId
            );
         ProductDrawingsSummaryDTO productDrawingsSummaryDTO = artifactDwg.stream()
            .filter(ex -> ex.getAreaId().equals(areaId))
            .collect(Collectors.toList())
            .get(0);
         Preconditions.checkArgument(productDrawingsSummaryDTO.getDrawingQuantity() > 0, "该区域下未匹配零件数控图纸");
         String sourcepath = this.configProperties.getFilePath()
            + "tech_data"
            + File.separator
            + "machine_part_drawing"
            + File.separator
            + projectId
            + File.separator
            + monomerId
            + File.separator
            + areaId
            + File.separator;
         String targetpath = this.configProperties.getFilePath()
            + "machine_part_drawingDXF"
            + File.separator
            + project.getShortName()
            + "_"
            + monomer.getName()
            + "_"
            + area.getName()
            + File.separator;
         String zipPath = this.configProperties.getFilePath()
            + "machine_part_drawingDXF"
            + File.separator
            + project.getShortName()
            + "_"
            + monomer.getName()
            + "_"
            + area.getName()
            + ".zip";
         List<String> SerialNumberList = this.baseMapper
            .selectList(
               (Wrapper<TechDrawing>)((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)new QueryWrapper()
                                    .select("serial_number")
                                    .eq("project_id", projectId))
                                 .eq("monomer_id", monomerId))
                              .eq("area_id", areaId))
                           .eq("bool_delete_enum", 0))
                        .eq("data_type", TechDataTypeEnum.NC_DRAWING.getType()))
                     .isNotNull("cloud_path"))
                  .isNull("product_type")
            )
            .stream()
            .map(ex -> ex.getSerialNumber() + ".dxf")
            .collect(Collectors.toList());
         File sourcefolder = new File(sourcepath);
         File targetfolder = new File(targetpath);

         try {
            if (!targetfolder.exists()) {
               targetfolder.mkdirs();
            }

            File[] files = sourcefolder.listFiles();
            if (files != null) {
               for (File file : files) {
                  if (file.isFile() && isContains(file, SerialNumberList)) {
                     File newTargetFile = new File(targetfolder, file.getName());
                     FileUtils.copyFile(file, newTargetFile);
                  }
               }
            }

            ZIPUtils.toZip(zipPath, targetpath, true);
            File dwfile = new File(zipPath);
            FileUtil.downloadFile(dwfile, project.getShortName() + "_" + monomer.getName() + "_" + area.getName() + ".zip");
         } catch (Exception e) {
            Preconditions.checkArgument(false, "文件下载失败,请联系管理员!");
         } finally {
            FileUtil.deleteDir(targetpath);
            FileUtil.deleteFile(zipPath);
            System.gc();
         }
      }

      if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
         List<ProductDrawingsSummaryDTO> artifactDwg = this.baseMapper
            .getArtifactDwg(projectId, project.getProjectType(), ProductTypeEnum.MACHINE_PART.getType(), TechDataTypeEnum.NC_DRAWING.getType(), null, null);
         ProductDrawingsSummaryDTO productDrawingsSummaryDTO = artifactDwg.stream()
            .filter(ex -> ex.getMonomerId().equals(monomerId))
            .collect(Collectors.toList())
            .get(0);
         Preconditions.checkArgument(productDrawingsSummaryDTO.getDrawingQuantity() > 0, "该单体下未匹配零件数控图纸");
         String sourcepath = this.configProperties.getFilePath()
            + "tech_data"
            + File.separator
            + "machine_part_drawing"
            + File.separator
            + projectId
            + File.separator
            + monomerId
            + File.separator;
         String targetpath = this.configProperties.getFilePath()
            + "machine_part_drawingDXF"
            + File.separator
            + project.getShortName()
            + "_"
            + monomer.getName()
            + File.separator;
         String zipPath = this.configProperties.getFilePath()
            + "machine_part_drawingDXF"
            + File.separator
            + project.getShortName()
            + "_"
            + monomer.getName()
            + ".zip";
         List<String> SerialNumberList = this.baseMapper
            .selectList(
               (Wrapper<TechDrawing>)((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)((QueryWrapper)new QueryWrapper()
                                 .select("serial_number")
                                 .eq("project_id", projectId))
                              .eq("monomer_id", monomerId))
                           .eq("bool_delete_enum", 0))
                        .eq("data_type", TechDataTypeEnum.NC_DRAWING.getType()))
                     .isNotNull("cloud_path"))
                  .isNull("product_type")
            )
            .stream()
            .map(ex -> ex.getSerialNumber() + ".dxf")
            .collect(Collectors.toList());
         File sourcefolder = new File(sourcepath);
         File targetfolder = new File(targetpath);

         try {
            if (!targetfolder.exists()) {
               targetfolder.mkdirs();
            }

            File[] files = sourcefolder.listFiles();
            if (files != null) {
               for (File file : files) {
                  if (file.isFile() && isContains(file, SerialNumberList)) {
                     File newTargetFile = new File(targetfolder, file.getName());
                     FileUtils.copyFile(file, newTargetFile);
                  }
               }
            }

            ZIPUtils.toZip(zipPath, targetpath, true);
            File dwfile = new File(zipPath);
            FileUtil.downloadFile(dwfile, project.getShortName() + "_" + monomer.getName() + ".zip");
         } catch (Exception e) {
            Preconditions.checkArgument(false, "文件下载失败,请联系管理员!");
         } finally {
            FileUtil.deleteDir(targetpath);
            FileUtil.deleteFile(zipPath);
            System.gc();
         }
      }
   }

   @Override
   public void downloadFileBySerialNumber(Integer projectType, String serialNumber, Integer productType, Integer number, Long monomerId, Long areaId) {
      Preconditions.checkArgument(
         ProjectTypeEnum.MES.getType().equals(projectType) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()), "暂只支持建刚/桥梁类型的项目产品!"
      );
      Preconditions.checkArgument(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType), "暂只支持构件产品!");
      Preconditions.checkArgument(number != null, "该构件下的图纸不存在!!!");
      this.filePreview(monomerId, TechDataTypeEnum.DEEPEN.getType(), productType, serialNumber, number, null);
   }

   @Override
   public PageVO<WeldDetailsDTO> weldContrast(
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
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      PageHelper.startPage(pageNumber, pageSize);
      List<WeldDetailsDTO> aredtos = this.baseMapper
         .weldContrast(
            projectId, monomerId, areaId, project.getProjectType(), productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, drawingMatchRange
         );
      if (CollectionUtils.isNotEmpty(aredtos)) {
         for (WeldDetailsDTO aredto : aredtos) {
            ArrayList<String> serialNumbers = new ArrayList<>();
            serialNumbers.add(aredto.getSerialNumber());
            List<TechCappCraftCardProductWeldingDTO> welds = this.baseMapper
               .selectWeldByType(monomerId, serialNumbers, dataType, productType, drawingMatchRange, areaId);
            if (CollectionUtils.isNotEmpty(welds)) {
               List<Long> ids = welds.stream().map(TechCappCraftCardProductWeldingDTO::getId).collect(Collectors.toList());
               aredto.setWeldIds(ids);
               aredto.setUserName(welds.get(0).getCreateUserName());
               aredto.setCreateTime(welds.get(0).getCreateTime());
               aredto.setUpdateTime(welds.get(0).getUpdateTime());
            }
         }
      }

      return new PageVO<>(aredtos);
   }

   @Override
   public void downloadWeldMark(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException {
      try {
         ContractProject project = this.projectService.getById(projectId);
         PlanMonomer monomer = this.monomerService.getById(monomerId);
         response.setCharacterEncoding("UTF-8");
         response.setHeader("Content-Type", "application/pdf");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader(
            "Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8")
         );
         if (project == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("项目信息不存在", "UTF-8"));
            return;
         }

         if (monomer == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("单体信息不存在", "UTF-8"));
            return;
         }

         TechCappCraftCardProductWelding weld = null;
         List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingService
            .list(
               Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
                  .eq(TechCappCraftCardProductWelding::getMonomerId, monomerId)
                  .eq(TechCappCraftCardProductWelding::getProductType, taskTypeEnum)
                  .eq(TechCappCraftCardProductWelding::getSerialNumber, serialNumber)
                  .eq(TechCappCraftCardProductWelding::getDataType, TechDataTypeEnum.DEEPEN.getType())
            );
         if (CollectionUtils.isNotEmpty(techCappCraftCardProductWeldings)) {
            weld = techCappCraftCardProductWeldings.get(0);
         }

         if (weld != null) {
            String dirByType = DrawingProductTypeEnum.getDirByType(taskTypeEnum);
            String sourcepath = this.configProperties.getFilePath()
               + "tech_data"
               + File.separator
               + "deepen_drawing"
               + File.separator
               + dirByType
               + File.separator
               + projectId
               + File.separator
               + monomerId
               + File.separator
               + serialNumber
               + ".mark";
            File sourcefolder = new File(sourcepath);
            if (!sourcefolder.exists()) {
               response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("未找到对应文件", "UTF-8"));
            } else {
               FileUtil.downloadFile(sourcefolder, serialNumber + ".mark");
            }

            return;
         }

         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("未查询到焊缝MARK文件", "UTF-8"));
      } catch (Exception e) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.ERROR.getMessage(), "UTF-8"));
         return;
      } finally {
         System.gc();
      }
   }

   @Transactional
   @Override
   public ResultVO deleteDeepenMark(List<IdsDTO> ids) {
      Set<Long> set = new HashSet<>();

      for (IdsDTO dto : ids) {
         set.addAll(dto.getIds());
      }

      List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingService
         .list(Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class).in(TechCappCraftCardProductWelding::getId, set));
      List<Long> projectIds = techCappCraftCardProductWeldings.stream()
         .map(TechCappCraftCardProductWelding::getProjectId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, Integer> projectMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, ContractProject::getProjectType));
      Map<Long, List<TechCappCraftCardProductWelding>> weldMap = techCappCraftCardProductWeldings.stream()
         .collect(Collectors.groupingBy(TechCappCraftCardProductWelding::getMonomerId));

      for (Long aLong : weldMap.keySet()) {
         List<TechCappCraftCardProductWelding> welds = weldMap.get(aLong);
         Long projectId = welds.get(0).getProjectId();
         Map<String, List<TechCappCraftCardProductWelding>> collect1 = welds.stream().collect(Collectors.groupingBy(s -> s.getProductType() + ""));
         if (collect1.get(ProductTypeEnum.ARTIFACT.getType() + "") != null) {
            Set<String> serialNumbers = collect1.get(ProductTypeEnum.ARTIFACT.getType() + "")
               .stream()
               .map(TechCappCraftCardProductWelding::getSerialNumber)
               .collect(Collectors.toSet());
            List<Long> artids = this.artifactService
               .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, aLong).in(TechArtifact::getSerialNumber, serialNumbers))
               .stream()
               .map(TechArtifact::getId)
               .distinct()
               .collect(Collectors.toList());
            this.checkWeld(artids, ProductTypeEnum.ARTIFACT.getType());
         }

         if (collect1.get(ProductTypeEnum.ASSEMBLE.getType() + "") != null) {
            List<TechCappCraftCardProductWelding> welds2 = collect1.get(ProductTypeEnum.ASSEMBLE.getType() + "");
            Set<String> serialNumbers = welds2.stream().map(TechCappCraftCardProductWelding::getSerialNumber).collect(Collectors.toSet());
            List<Long> assids = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, aLong).in(TechAssemble::getInitialSerialNumber, serialNumbers))
               .stream()
               .map(TechAssemble::getId)
               .distinct()
               .collect(Collectors.toList());
            this.checkWeld(assids, ProductTypeEnum.ASSEMBLE.getType());
         }
      }

      List<Long> list = new ArrayList<>(set);
      if (CollectionUtils.isEmpty(list)) {
         return ResultVO.builder().build();
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "焊缝id列表为空!");
      OSS client = this.ossUtils.openClient();
      list.forEach(id -> {
         TechCappCraftCardProductWelding weld = this.techCappCraftCardProductWeldingService.getById(id);
         Preconditions.checkArgument(weld != null, "删除失败，对应的图纸不存在!");
         ContractProject project = this.projectService.checkProjectStatus(weld.getProjectId());
         PlanMonomer monomer = null;
         if (weld.getMonomerId() != null) {
            monomer = this.monomerService.getById(weld.getMonomerId());
         }

         String absolutePath = this.configProperties.getFilePath() + weld.getFilePath() + weld.getFileName();
         File file = new File(absolutePath);
         if (file.exists()) {
            file.delete();
         }
      });
      this.ossUtils.closeClient(client);
      if (list.size() > 0) {
         this.techCappCraftCardProductWeldingService.removeByIds(list);
      }

      return ResultVO.builder().build();
   }

   @Transactional
   @Override
   public ResultVO updateMarkFile(
      Long productId, Integer productType, Integer dataType, MultipartFile multipartFile, Long projectId, Long monomerId, Long areaId
   ) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      List<Long> pid = new ArrayList<>();
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact techart = this.artifactService.getById(productId);
         if (techart != null) {
            pid.add(techart.getId());
         }
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.techAssembleService.getById(productId);
         if (assemble != null) {
            pid.add(assemble.getId());
         }
      } else {
         Preconditions.checkArgument(false, "产品类型不正确");
      }

      ContractProject project = this.projectService.checkProjectStatus(projectId);
      this.checkDrawing(pid, project.getProjectType(), productType);
      String originalFilename = multipartFile.getOriginalFilename();
      originalFilename = this.transformLowercaseSuffix(originalFilename);
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      PlanMonomer monomer = null;
      String serialNumber = originalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
      String serial = this.artifactService.selectByTypeAndId(productType, productId);
      String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, areaId);
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
         Preconditions.checkArgument("mark".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
         QueryWrapper<TechCappCraftCardProductWelding> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("project_id", projectId)
            .eq("monomer_id", monomerId)
            .eq("data_type", dataType)
            .eq("product_type", productType)
            .eq("serial_number", serialNumber);
         List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingService.list(queryWrapper);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(techCappCraftCardProductWeldings), "修改失败本焊缝mark文件与本构件编号不符");
         this.techCappCraftCardProductWeldingService
            .remove(
               Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
                  .eq(TechCappCraftCardProductWelding::getProductType, productType)
                  .eq(TechCappCraftCardProductWelding::getDataType, dataType)
                  .eq(TechCappCraftCardProductWelding::getSerialNumber, serialNumber)
                  .eq(TechCappCraftCardProductWelding::getMonomerId, monomerId)
                  .eq(TechCappCraftCardProductWelding::getProjectId, projectId)
            );
         new ArrayList();

         List<CappCraftCardProductWeldingJsonObjectDTO> myJsonObjectList;
         try {
            String fileContent = new String(multipartFile.getBytes());
            if (fileContent.trim().isEmpty()) {
               throw new IllegalArgumentException("文件内容为空，无法解析JSON");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            myJsonObjectList = objectMapper.readValue(
               fileContent, objectMapper.getTypeFactory().constructCollectionType(List.class, CappCraftCardProductWeldingJsonObjectDTO.class)
            );
         } catch (Exception e) {
            throw new RuntimeException(e);
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(myJsonObjectList), "文件内容为空，无法解析焊缝编号信息!!!!");
         List<TechCappCraftCardProductWelding> needSaveTechCappCraftCardProductWeldingList = new ArrayList<>();
         myJsonObjectList.forEach(
            item -> needSaveTechCappCraftCardProductWeldingList.add(
               TechCappCraftCardProductWelding.builder()
                  .projectId(projectId)
                  .monomerId(monomerId)
                  .fileName(serial + ".mark")
                  .filePath(filePath)
                  .serialNumber(serial)
                  .projectType(project.getProjectType())
                  .weldingSerialNumber(item.getMarkName())
                  .createUserId(UserUtil.getCurrentUserId())
                  .craftType(CappCraftTypeEnum.WELDING.getType())
                  .productType(productType)
                  .dataType(dataType)
                  .build()
            )
         );
         String absolutePath = this.configProperties.getFilePath() + techCappCraftCardProductWeldings.get(0).getFilePath();

         try {
            File file = new File(absolutePath + originalFilename);
            multipartFile.transferTo(file);
         } catch (IOException e) {
            e.printStackTrace();
         }

         if (CollectionUtils.isNotEmpty(needSaveTechCappCraftCardProductWeldingList)) {
            this.techCappCraftCardProductWeldingService.saveBatch(needSaveTechCappCraftCardProductWeldingList);
         }
      }

      return ResultVO.builder().build();
   }

   @Override
   public void weldContrastDownload(
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
   ) {
      PageVO<WeldDetailsDTO> result = this.weldContrast(
         projectId, monomerId, areaId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, 1, 100000
      );
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");

      for (int i = 1; i <= result.getContent().size(); i++) {
         result.getContent().get(i - 1).setIndex(i);
      }

      Map<String, Object> dataMap = new HashMap<>(4);
      dataMap.put("projectName", project.getShortName());
      dataMap.put("monomerName", monomer.getName());
      dataMap.put("tableList", result.getContent());
      dataMap.put("fileType", "产品焊缝");
      TemplateExportParams params = new TemplateExportParams("files/FileMatchDetails.xlsx");

      try (Workbook workbook = ExcelExportUtil.exportExcel(params, dataMap)) {
         PoiUtils.unBuilderDownLoadExcel("焊缝文件匹配详情-（" + project.getShortName() + "）.xlsx", this.response, workbook);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO newUploadWeldMapFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   ) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      if ("zip".equalsIgnoreCase(suffix)) {
         this.uploadWeldMapFileZip(multipartFile, projectId, monomerId, dataType, productType, fileName, cacheObjectDTOParam);
      } else {
         this.uploadWeldMapFile(multipartFile, projectId, monomerId, dataType, productType, fileName, suffix, cacheObjectDTOParam, areaId);
      }

      return ResultVO.builder().message("上传成功").build();
   }

   @Override
   public PageVO<WeldMapDetailsDTO> weldMapContrast(
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
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      PageHelper.startPage(pageNumber, pageSize);
      List<WeldMapDetailsDTO> aredtos = this.baseMapper
         .weldMapContrast(
            projectId, monomerId, areaId, project.getProjectType(), productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, drawingMatchRange
         );
      if (CollectionUtils.isNotEmpty(aredtos)) {
         for (WeldMapDetailsDTO aredto : aredtos) {
            ArrayList<String> serialNumbers = new ArrayList<>();
            serialNumbers.add(aredto.getSerialNumber());
            List<TechCappCraftCardProductWeldingMapDTO> welds = this.baseMapper
               .selectWeldMapByType(monomerId, serialNumbers, dataType, productType, drawingMatchRange, areaId);
            if (CollectionUtils.isNotEmpty(welds)) {
               List<Long> ids = welds.stream().map(TechCappCraftCardProductWeldingMapDTO::getId).collect(Collectors.toList());
               aredto.setWeldIds(ids);
               aredto.setUserName(welds.get(0).getCreateUserName());
               aredto.setCreateTime(welds.get(0).getCreateTime());
               aredto.setUpdateTime(welds.get(0).getUpdateTime());
            }
         }
      }

      return new PageVO<>(aredtos);
   }

   @Override
   public void downloadWeldMap(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException {
      try {
         ContractProject project = this.projectService.getById(projectId);
         PlanMonomer monomer = this.monomerService.getById(monomerId);
         response.setCharacterEncoding("UTF-8");
         response.setHeader("Content-Type", "application/pdf");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader(
            "Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8")
         );
         if (project == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("项目信息不存在", "UTF-8"));
            return;
         }

         if (monomer == null) {
            response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("单体信息不存在", "UTF-8"));
            return;
         }

         TechCappCraftCardProductWeldingMap weld = null;
         List<TechCappCraftCardProductWeldingMap> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingMapBiz
            .list(
               Wrappers.lambdaQuery(TechCappCraftCardProductWeldingMap.class)
                  .eq(TechCappCraftCardProductWeldingMap::getMonomerId, monomerId)
                  .eq(TechCappCraftCardProductWeldingMap::getProductType, taskTypeEnum)
                  .eq(TechCappCraftCardProductWeldingMap::getSerialNumber, serialNumber)
                  .eq(TechCappCraftCardProductWeldingMap::getDataType, TechDataTypeEnum.DEEPEN.getType())
            );
         if (CollectionUtils.isNotEmpty(techCappCraftCardProductWeldings)) {
            weld = techCappCraftCardProductWeldings.get(0);
         }

         if (weld != null) {
            String dirByType = DrawingProductTypeEnum.getDirByType(taskTypeEnum);
            String sourcepath = this.configProperties.getFilePath()
               + "tech_data"
               + File.separator
               + "deepen_drawing"
               + File.separator
               + dirByType
               + File.separator
               + projectId
               + File.separator
               + monomerId
               + File.separator
               + "map"
               + File.separator
               + serialNumber
               + ".pdf";
            File sourcefolder = new File(sourcepath);
            if (!sourcefolder.exists()) {
               response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("未找到对应文件", "UTF-8"));
            } else {
               FileUtil.downloadFile(sourcefolder, serialNumber + ".mark");
            }

            return;
         }

         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode("未查询到焊缝MARK文件", "UTF-8"));
      } catch (Exception e) {
         response.setHeader("Result", "code=" + ResultCodeEnum.ERROR.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.ERROR.getMessage(), "UTF-8"));
         return;
      } finally {
         System.gc();
      }
   }

   @Transactional
   @Override
   public ResultVO deleteDeepenWeldMap(List<IdsDTO> ids) {
      Set<Long> set = new HashSet<>();

      for (IdsDTO dto : ids) {
         set.addAll(dto.getIds());
      }

      List<TechCappCraftCardProductWeldingMap> techCappCraftCardProductWeldingMaps = this.techCappCraftCardProductWeldingMapBiz
         .list(Wrappers.lambdaQuery(TechCappCraftCardProductWeldingMap.class).in(TechCappCraftCardProductWeldingMap::getId, set));
      List<Long> projectIds = techCappCraftCardProductWeldingMaps.stream()
         .map(TechCappCraftCardProductWeldingMap::getProjectId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, Integer> projectMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, ContractProject::getProjectType));
      Map<Long, List<TechCappCraftCardProductWeldingMap>> weldMap = techCappCraftCardProductWeldingMaps.stream()
         .collect(Collectors.groupingBy(TechCappCraftCardProductWeldingMap::getMonomerId));

      for (Long aLong : weldMap.keySet()) {
         List<TechCappCraftCardProductWeldingMap> welds = weldMap.get(aLong);
         Long projectId = welds.get(0).getProjectId();
         Map<String, List<TechCappCraftCardProductWeldingMap>> collect1 = welds.stream().collect(Collectors.groupingBy(s -> s.getProductType() + ""));
         if (collect1.get(ProductTypeEnum.ARTIFACT.getType() + "") != null) {
            Set<String> serialNumbers = collect1.get(ProductTypeEnum.ARTIFACT.getType() + "")
               .stream()
               .map(TechCappCraftCardProductWeldingMap::getSerialNumber)
               .collect(Collectors.toSet());
            List serialNumbersx = this.artifactService
               .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, aLong).in(TechArtifact::getSerialNumber, serialNumbers))
               .stream()
               .map(TechArtifact::getId)
               .distinct()
               .collect(Collectors.toList());
         }

         if (collect1.get(ProductTypeEnum.ASSEMBLE.getType() + "") != null) {
            List<TechCappCraftCardProductWeldingMap> welds2 = collect1.get(ProductTypeEnum.ASSEMBLE.getType() + "");
            Set<String> serialNumbers = welds2.stream().map(TechCappCraftCardProductWeldingMap::getSerialNumber).collect(Collectors.toSet());
            List var14 = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, aLong).in(TechAssemble::getInitialSerialNumber, serialNumbers))
               .stream()
               .map(TechAssemble::getId)
               .distinct()
               .collect(Collectors.toList());
         }
      }

      List<Long> list = new ArrayList<>(set);
      if (CollectionUtils.isEmpty(list)) {
         return ResultVO.builder().build();
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "焊缝id列表为空!");
      OSS client = this.ossUtils.openClient();
      list.forEach(id -> {
         TechCappCraftCardProductWeldingMap weld = this.techCappCraftCardProductWeldingMapBiz.getById(id);
         Preconditions.checkArgument(weld != null, "删除失败，对应的图纸不存在!");
         ContractProject project = this.projectService.checkProjectStatus(weld.getProjectId());
         PlanMonomer monomer = null;
         if (weld.getMonomerId() != null) {
            monomer = this.monomerService.getById(weld.getMonomerId());
         }

         String absolutePath = this.configProperties.getFilePath() + weld.getFilePath() + weld.getFileName();
         File file = new File(absolutePath);
         if (file.exists()) {
            file.delete();
         }
      });
      this.ossUtils.closeClient(client);
      if (list.size() > 0) {
         this.techCappCraftCardProductWeldingMapBiz.removeByIds(list);
      }

      return ResultVO.builder().build();
   }

   @Transactional
   @Override
   public ResultVO updateMarkMapFile(
      Long productId, Integer productType, Integer dataType, MultipartFile multipartFile, Long projectId, Long monomerId, Long areaId
   ) {
      TechCappCraftCardProductWeldingMap techCappCraftCardProductWeldingMap = this.techCappCraftCardProductWeldingMapBiz
         .getOne(
            Wrappers.lambdaQuery(TechCappCraftCardProductWeldingMap.class)
               .eq(TechCappCraftCardProductWeldingMap::getProductType, productType)
               .eq(TechCappCraftCardProductWeldingMap::getProjectId, productId)
               .eq(TechCappCraftCardProductWeldingMap::getDataType, dataType)
               .eq(TechCappCraftCardProductWeldingMap::getMonomerId, monomerId)
         );
      Preconditions.checkArgument(techCappCraftCardProductWeldingMap != null, "技术资料不存在!");
      ContractProject project = this.projectService.checkProjectStatus(techCappCraftCardProductWeldingMap.getProjectId());
      PlanMonomer monomer = null;
      if (techCappCraftCardProductWeldingMap.getMonomerId() != null) {
         monomer = this.monomerService.getById(techCappCraftCardProductWeldingMap.getMonomerId());
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "技术资料导入失败!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      String oldFilePath = this.configProperties.getFilePath()
         + techCappCraftCardProductWeldingMap.getFilePath()
         + techCappCraftCardProductWeldingMap.getFileName();
      File file = new File(oldFilePath);
      if (techCappCraftCardProductWeldingMap.getDataType().equals(TechDataTypeEnum.DEEPEN.getType())) {
         Preconditions.checkArgument(
            "dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix),
            TechDataTypeEnum.getNameByType(techCappCraftCardProductWeldingMap.getDataType()) + "格式不正确!"
         );
      }

      try (
         InputStream is = multipartFile.getInputStream();
         OutputStream out = new FileOutputStream(file);
      ) {
         byte[] buf = new byte[1024];

         int len;
         while ((len = is.read(buf)) != -1) {
            out.write(buf, 0, len);
            out.flush();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      techCappCraftCardProductWeldingMap.setCreateTime(LocalDateTime.now());
      techCappCraftCardProductWeldingMap.setCreateUserId(UserUtil.getCurrentUserId());
      this.techCappCraftCardProductWeldingMapBiz.updateById(techCappCraftCardProductWeldingMap);
      return ResultVO.builder().build();
   }

   @Override
   public void weldMapContrastDownload(
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
   ) {
      PageVO<WeldMapDetailsDTO> result = this.weldMapContrast(
         projectId, monomerId, areaId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, 1, 100000
      );
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");

      for (int i = 1; i <= result.getContent().size(); i++) {
         result.getContent().get(i - 1).setIndex(i);
      }

      Map<String, Object> dataMap = new HashMap<>(4);
      dataMap.put("projectName", project.getShortName());
      dataMap.put("monomerName", monomer.getName());
      dataMap.put("tableList", result.getContent());
      dataMap.put("fileType", "产品焊缝地图");
      TemplateExportParams params = new TemplateExportParams("files/FileMatchDetails.xlsx");

      try (Workbook workbook = ExcelExportUtil.exportExcel(params, dataMap)) {
         PoiUtils.unBuilderDownLoadExcel("焊缝地图文件匹配详情-（" + project.getShortName() + "）.xlsx", this.response, workbook);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public void downloadFileByMapProduct(
      Integer projectType, Long productId, Integer productType, Integer number, String serialNumber, Long monomerId, Long areaId
   ) {
      if (ProjectTypeEnum.MES.getType().equals(projectType) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            Preconditions.checkArgument(number != null, "该构件下的图纸不存在!!!");
            Preconditions.checkArgument(productId != null || org.apache.commons.lang3.StringUtils.isNotBlank(serialNumber), "操作失败,构件编号和构件产品Id不能同时为空!");
            if (org.apache.commons.lang3.StringUtils.isNotBlank(serialNumber)) {
               this.mapFilePreview(monomerId, TechDataTypeEnum.DEEPEN.getType(), productType, serialNumber, number, null);
            } else if (productId != null) {
               TechArtifact artifact = this.artifactService.getById(productId);
               Preconditions.checkArgument(artifact != null, "构件不存在");
               this.mapFilePreview(artifact.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), productType, artifact.getSerialNumber(), number, null);
            }
         } else if (DrawingProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            TechMachinePart machinePart = this.machinePartService.getById(productId);
            Preconditions.checkArgument(machinePart != null, "零件不存在");
            Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
            this.mapFilePreview(
               machinePart.getMonomerId(),
               TechDataTypeEnum.NC_DRAWING.getType(),
               null,
               machinePart.getSerialNumber(),
               number,
               SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange) ? machinePart.getAreaId() : null
            );
         } else {
            if (!DrawingProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
               throw new BusinessException("请传入正确的产品类型!");
            }

            TechAssemble assemble = this.assembleService.getById(productId);
            Preconditions.checkArgument(assemble != null, "组立不存在");
            this.mapFilePreview(assemble.getMonomerId(), TechDataTypeEnum.DEEPEN.getType(), productType, assemble.getInitialSerialNumber(), number, null);
         }
      }
   }

   @Override
   public ArtifactNumDTO getArtifactMapDwgNum(Integer projectType, Long productId, Integer productType) {
      ArtifactNumDTO artifactNumDTO = new ArtifactNumDTO();
      artifactNumDTO.setBoolExist(false);
      if ((projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()))
         && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "构件不存在");
         List<TechCappCraftCardProductWeldingMap> drawingList = this.techCappCraftCardProductWeldingMapMapper
            .selectList(
               (Wrapper<TechCappCraftCardProductWeldingMap>)(((new LambdaQueryWrapper<TechCappCraftCardProductWeldingMap>()
                           .eq(TechCappCraftCardProductWeldingMap::getMonomerId, artifact.getMonomerId()))
                        .eq(TechCappCraftCardProductWeldingMap::getProductType, productType))
                     .eq(TechCappCraftCardProductWeldingMap::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechCappCraftCardProductWeldingMap::getSerialNumber, artifact.getSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(drawingList)) {
            List<Integer> numbers = drawingList.stream().map(TechCappCraftCardProductWeldingMap::getNumber).collect(Collectors.toList());
            artifactNumDTO.setBoolExist(true);
            artifactNumDTO.setNumbers(numbers);
         }
      } else if ((projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()))
         && DrawingProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "部件不存在");
         List<TechCappCraftCardProductWeldingMap> drawingList = this.techCappCraftCardProductWeldingMapMapper
            .selectList(
               (Wrapper<TechCappCraftCardProductWeldingMap>)(((new LambdaQueryWrapper<TechCappCraftCardProductWeldingMap>()
                           .eq(TechCappCraftCardProductWeldingMap::getMonomerId, assemble.getMonomerId()))
                        .eq(TechCappCraftCardProductWeldingMap::getProductType, productType))
                     .eq(TechCappCraftCardProductWeldingMap::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechCappCraftCardProductWeldingMap::getSerialNumber, assemble.getInitialSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(drawingList)) {
            List<Integer> numbers = drawingList.stream().map(TechCappCraftCardProductWeldingMap::getNumber).collect(Collectors.toList());
            artifactNumDTO.setBoolExist(true);
            artifactNumDTO.setNumbers(numbers);
         }
      }

      return artifactNumDTO;
   }

   private void mapFilePreview(Long monomerId, Integer dataType, Integer productType, String serialNumber, Integer number, Long areaId) {
      List<TechCappCraftCardProductWeldingMap> mapDrawingList = this.techCappCraftCardProductWeldingMapMapper
         .getByMonomerIdAndTypeAndSerialNumber(monomerId, dataType, productType, serialNumber, number, areaId);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(mapDrawingList) && mapDrawingList.size() == 1, "下载失败，对应的图纸不存在。");
      TechCappCraftCardProductWeldingMap mapDrawing = mapDrawingList.get(0);
      String path = this.configProperties.getFilePath() + mapDrawing.getFilePath() + mapDrawing.getFileName();
      File file = new File(path);
      Preconditions.checkArgument(file.exists(), "查看失败，实际图纸不存在");
      FileUtil.downloadFile(file, mapDrawing.getFileName());
   }

   private void setWeldMapArtifact(Long projectId, Long monomerId, Integer dataType, String serialNumber, Integer type, Integer productType) {
      Boolean flag = false;
      QueryWrapper<TechCappCraftCardProductWeldingMap> queryWrapper = new QueryWrapper<>();
      queryWrapper.eq("project_id", projectId)
         .eq("monomer_id", monomerId)
         .eq("data_type", dataType)
         .eq("product_type", productType)
         .eq("serial_number", serialNumber);
      if (SysDrawingRecognitionRulesEnums.ARTIFACTS.getType().equals(type) && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         queryWrapper.isNotNull("dwg_num");
         flag = true;
      }

      if (SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(type) && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         queryWrapper.isNull("dwg_num");
         flag = true;
      }

      if (flag) {
         List<TechCappCraftCardProductWeldingMap> drawingList = this.techCappCraftCardProductWeldingMapMapper.selectList(queryWrapper);
         if (CollectionUtils.isNotEmpty(drawingList)) {
            for (TechCappCraftCardProductWeldingMap techDrawing : drawingList) {
               this.baseMapper.deleteById(techDrawing);
               String absolutePath = this.configProperties.getFilePath() + techDrawing.getFilePath() + techDrawing.getFileName();
               File file = new File(absolutePath);
               if (file.exists()) {
                  Preconditions.checkArgument(file.delete(), "磁盘文件清理失败");
               }
            }
         }
      }
   }

   public Boolean uploadWeldMapFile(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      String suffix,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId
   ) {
      Long drawingId = null;
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      PlanMonomer monomer = null;
      PlanArea area = null;
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      String filePath = this.getWeldMapFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), drawingMatchRange, areaId);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(!originalFilename.contains(" "), "文件名不能包含空格");
      originalFilename = this.transformLowercaseSuffix(originalFilename);
      String serialNumber = originalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
      originalFilename = originalFilename.replaceAll(" ", "");
      FileUtil.mkdirs(absolutePath);
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         Preconditions.checkArgument("dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
            }

            Map<String, Object> map;
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               map = this.getSerialAndOrder(serialNumber, rules.getType());
            } else {
               map = new HashMap<>();
            }

            this.setWeldMapArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);

            try {
               File file = new File(absolutePath + originalFilename);
               multipartFile.transferTo(file);
            } catch (IOException e) {
               e.printStackTrace();
            } finally {
               System.gc();
            }

            QueryWrapper<TechCappCraftCardProductWeldingMap> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("project_id", projectId)
               .eq("monomer_id", monomerId)
               .eq("data_type", dataType)
               .eq("product_type", productType)
               .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               if (map.get("number") == null) {
                  queryWrapper.eq("number", 0);
               } else {
                  queryWrapper.eq("number", map.get("number"));
               }

               if (map.get("dwgNum") == null) {
                  queryWrapper.isNull("dwg_num");
               } else {
                  queryWrapper.eq("dwg_num", map.get("dwgNum"));
               }
            }

            List<TechCappCraftCardProductWeldingMap> drawings = this.techCappCraftCardProductWeldingMapMapper.selectList(queryWrapper);
            TechCappCraftCardProductWeldingMap drawing = drawings.stream()
               .filter(s -> s.getSerialNumber().equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber))
               .findFirst()
               .orElse(null);
            if (drawing != null) {
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
                  && SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(rules.getType())) {
                  Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
               }

               drawing.setFileName(originalFilename);
               drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
               drawing.setCreateTime(LocalDateTime.now());
               this.techCappCraftCardProductWeldingMapMapper.updateById(drawing);
            }

            if (drawing == null) {
               drawing = TechCappCraftCardProductWeldingMap.builder()
                  .projectId(projectId)
                  .projectType(project.getProjectType())
                  .monomerId(monomerId)
                  .dataType(dataType)
                  .productType(productType)
                  .serialNumber(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? (String)map.get("serialNumber") : serialNumber)
                  .filePath(filePath)
                  .fileName(originalFilename)
                  .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                  .build();
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                  drawing.setNumber(map.get("number") == null ? 0 : (Integer)map.get("number"));
                  drawing.setDwgNum((String)map.get("dwgNum"));
               }

               this.techCappCraftCardProductWeldingMapMapper.insert(drawing);
            }
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   public void uploadWeldMapFileZip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         Preconditions.checkArgument(productType != null, "上传深化图纸,缺少产品类型");
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "建钢产品类型有误");
         }
      }

      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "深化图纸单体id不能为空");
      PlanMonomer monomer = null;
      if (monomerId != null) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称不能为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "导入失败，只能上传zip压缩文件");
      String filePath = this.getWeldMapFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, null);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      if (org.apache.commons.lang3.StringUtils.isBlank(fileName)) {
         fileName = originalFilename;
      } else {
         String fileSuffix = FileUtil.getFileExtension(fileName);
         fileName = "zip".equalsIgnoreCase(fileSuffix) ? fileName : fileName + ".zip";
      }

      File file = new File(absolutePath + fileName);
      List<Long> drawingIds = null;
      if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         List<String> fileNameList = null;

         try {
            fileNameList = this.unzipFile(file, absolutePath, new HashMap<>());
            Preconditions.checkArgument(fileNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
         } catch (IOException e) {
            e.printStackTrace();
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(fileNameList), "压缩包解压出现异常!");
         drawingIds = new ArrayList<>(fileNameList.size());
         if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
            DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
            }

            Map<String, Object> map = new HashMap<>();
            if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               try {
                  List<String> zipNameList = this.getZipNameList(file);
                  Set<String> nameSet = new HashSet<>(zipNameList);
                  Preconditions.checkArgument(nameSet.size() == zipNameList.size(), "存在重复文件,请审查后重新导入!");
                  Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");

                  for (String s : zipNameList) {
                     String serialNumber = s.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
                     map = this.getSerialAndOrder(serialNumber, rules.getType());
                     this.setWeldMapArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);
                  }
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }

            try {
               for (String name : fileNameList) {
                  String fileSuffix = FileUtil.getFileExtension(name);
                  Preconditions.checkArgument(
                     "dwg".equalsIgnoreCase(fileSuffix) || "pdf".equalsIgnoreCase(fileSuffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!"
                  );
                  String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
                  if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                     map = this.getSerialAndOrder(serialNumber, rules.getType());
                  }

                  QueryWrapper<TechCappCraftCardProductWeldingMap> queryWrapper = new QueryWrapper<>();
                  queryWrapper.eq("project_id", projectId)
                     .eq("monomer_id", monomerId)
                     .eq("data_type", dataType)
                     .eq("product_type", productType)
                     .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
                  if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                     if (map.get("number") == null) {
                        queryWrapper.eq("number", 0);
                     } else {
                        queryWrapper.eq("number", map.get("number"));
                     }

                     if (map.get("dwgNum") == null) {
                        queryWrapper.isNull("dwg_num");
                     } else {
                        queryWrapper.eq("dwg_num", map.get("dwgNum"));
                     }
                  }

                  List<TechCappCraftCardProductWeldingMap> drawings = this.techCappCraftCardProductWeldingMapMapper.selectList(queryWrapper);
                  Map<String, Object> finalMap = map;
                  TechCappCraftCardProductWeldingMap drawing = drawings.stream()
                     .filter(
                        s -> s.getSerialNumber()
                           .equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? finalMap.get("serialNumber") : serialNumber)
                     )
                     .findFirst()
                     .orElse(null);
                  this.setWeldMapArtifact(projectId, monomerId, dataType, (String)map.get("serialNumber"), rules.getType(), productType);
                  if (drawing != null) {
                     if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
                        && SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(rules.getType())) {
                        Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
                     }

                     drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                     drawing.setCreateTime(LocalDateTime.now());
                     this.techCappCraftCardProductWeldingMapMapper.updateById(drawing);
                  }

                  if (drawing == null) {
                     drawing = TechCappCraftCardProductWeldingMap.builder()
                        .projectId(projectId)
                        .monomerId(monomerId)
                        .dataType(dataType)
                        .productType(productType)
                        .projectType(project.getProjectType())
                        .serialNumber(serialNumber)
                        .filePath(filePath)
                        .fileName(name)
                        .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                        .build();
                     if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                        drawing.setSerialNumber((String)map.get("serialNumber"));
                        drawing.setNumber(map.get("number") == null ? 0 : (Integer)map.get("number"));
                        drawing.setDwgNum((String)map.get("dwgNum"));
                     }

                     this.techCappCraftCardProductWeldingMapMapper.insert(drawing);
                  }

                  drawingIds.add(drawing.getId());
               }
            } finally {
               System.gc();
               file.delete();
            }
         }
      }
   }

   public String getWeldMapFilePath(
      Long projectId, Long monomerId, Integer dataType, Integer productType, Integer projectType, Integer drawingMatchRange, Long areaId
   ) {
      StringBuilder builder = new StringBuilder()
         .append(AttachmentTypeEnum.TECH_DATA.getName())
         .append(File.separator)
         .append(TechDataTypeEnum.getDirByType(dataType))
         .append(File.separator);
      if (TechDataTypeEnum.XML_FILE.getType().equals(dataType)) {
         Preconditions.checkArgument(productType != null, "XML文件必须传产品类型值!");
         if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
            builder.append(DrawingProductTypeEnum.getDirByType(productType)).append(File.separator);
         }
      }

      if (TechDataTypeEnum.NC_DRAWING.getType().equals(dataType)
         && productType.equals(ProductTypeEnum.ASSEMBLE.getType())
         && (projectType.equals(ProjectTypeEnum.MES.getType()) || productType.equals(ProjectTypeEnum.BRIDGE.getType()))) {
         builder.append(DrawingProductTypeEnum.getDirByType(productType)).append(File.separator);
      }

      if (TechDataTypeEnum.DEEPEN.getType().equals(dataType)) {
         Preconditions.checkArgument(productType != null, "深化图纸必传产品类型值!");
         if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
            builder.append(DrawingProductTypeEnum.getDirByType(productType)).append(File.separator);
         }
      }

      if (projectId != null) {
         builder.append(projectId).append(File.separator);
      }

      if (monomerId != null) {
         builder.append(monomerId).append(File.separator);
      }

      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)
         && TechDataTypeEnum.NC_DRAWING.getType().equals(dataType)
         && areaId != null
         && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         builder.append(areaId).append(File.separator);
      }

      builder.append("map").append(File.separator);
      return builder.toString();
   }

   private void checkWeld(List<Long> productIds, Integer productType) {
      if (!productType.equals(ProductTypeEnum.ARTIFACT.getType()) && !productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         throw new BusinessException("请选择正确的产品类型");
      }

      List<TechCappCraftCardProductLink> techCappCraftCardProductLinks = this.techCappCraftCardProductLinkService
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
               .in(TechCappCraftCardProductLink::getProductId, productIds)
               .eq(TechCappCraftCardProductLink::getProductType, productType)
         );
      List<String> collect = techCappCraftCardProductLinks.stream()
         .map(TechCappCraftCardProductLink::getProductSerialNumber)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(techCappCraftCardProductLinks.size() == 0, collect + "已绑定工艺卡信息，请先解除绑定关系");
   }

   @Override
   public String getFilePathByAssemble(Long monomerId, String serialNumber) {
      TechDrawing techDrawing = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(TechDrawing.class)
               .eq(TechDrawing::getMonomerId, monomerId)
               .eq(TechDrawing::getSerialNumber, serialNumber)
               .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
               .eq(TechDrawing::getProductType, ProductTypeEnum.ASSEMBLE.getType())
         );
      return BeanUtil.checkObjAllFieldsIsNull(techDrawing) ? null : this.configProperties.getFilePath() + techDrawing.getFilePath() + techDrawing.getFileName();
   }

   @Override
   public List<PicturePathDTO> selectMachDrawing(List<Long> machinePartIds) {
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      return this.baseMapper.selectMachDrawing(machinePartIds, drawingMatchRange);
   }

   @Override
   public Map<String, String> getDxfPictures(Long monomerId, Set<String> serialNumbers) {
      List<TechDrawing> list = this.list(
         Wrappers.lambdaQuery(TechDrawing.class)
            .eq(TechDrawing::getMonomerId, monomerId)
            .in(TechDrawing::getSerialNumber, serialNumbers)
            .isNull(TechDrawing::getProductType)
            .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
      );
      Map<String, String> collect = list.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, TechDrawing::getPicturePath, (s1, s2) -> s2));

      for (String s : collect.keySet()) {
         if (org.apache.commons.lang3.StringUtils.isEmpty(collect.get(s))) {
            collect.put(s, null);
         } else {
            collect.put(s, this.ip + "files/" + collect.get(s));
         }
      }

      for (String serialNumber : serialNumbers) {
         if (!collect.containsKey(serialNumber)) {
            collect.put(serialNumber, null);
         }
      }

      return collect;
   }

   @Override
   public Map<String, String> getDxfPicturesByArea(Long areaId, Set<String> serialNumbers) {
      List<TechDrawing> list = this.list(
         Wrappers.lambdaQuery(TechDrawing.class)
            .eq(TechDrawing::getAreaId, areaId)
            .in(TechDrawing::getSerialNumber, serialNumbers)
            .isNull(TechDrawing::getProductType)
            .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
      );
      Map<String, String> collect = list.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, TechDrawing::getPicturePath, (s1, s2) -> s2));

      for (String s : collect.keySet()) {
         if (org.apache.commons.lang3.StringUtils.isEmpty(collect.get(s))) {
            collect.put(s, null);
         } else {
            collect.put(s, this.ip + "files/" + collect.get(s));
         }
      }

      for (String serialNumber : serialNumbers) {
         if (!collect.containsKey(serialNumber)) {
            collect.put(serialNumber, null);
         }
      }

      return collect;
   }

   @Override
   public Map<String, List<TechDrawing>> getDrawingMap(Long monomerId, Integer dataType, Integer productType) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(TechDrawing.class)
               .eq(TechDrawing::getMonomerId, monomerId)
               .eq(TechDrawing::getDataType, dataType)
               .eq(productType != null, TechDrawing::getProductType, productType)
               .isNull(productType == null, TechDrawing::getProductType)
         )
         .stream()
         .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
   }

   @Override
   public Boolean checkDrawing(List<Long> productIds, Integer projectType, Integer productType) {
      if (productIds.size() == 0) {
         return Boolean.TRUE;
      }

      List<String> serialNumbers = new ArrayList<>();
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         List<MesBuildingMachinePartSchedulingLink> links = this.mesBuildingMachinePartSchedulingLinkService
            .list(Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).in(MesBuildingMachinePartSchedulingLink::getProductId, productIds));
         if (CollectionUtils.isNotEmpty(links)) {
            Set<Long> collect = links.stream().map(MesBuildingMachinePartSchedulingLink::getProductId).collect(Collectors.toSet());
            List<TechMachinePart> techMachineParts = this.machinePartService.listByIds(collect);
            serialNumbers = techMachineParts.stream().map(TechMachinePart::getSerialNumber).collect(Collectors.toList());
         }
      } else if (!productType.equals(ProductTypeEnum.ARTIFACT.getType()) && !productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         Preconditions.checkArgument(false, "产品类型不正确");
      }

      if (CollectionUtils.isNotEmpty(serialNumbers)) {
         StringBuilder s = new StringBuilder();
         int i = 0;

         for (String serialNumber : serialNumbers) {
            i++;
            s.append(serialNumber).append(",");
            if (i % 15 == 0) {
               s.append("\n");
            }
         }

         Preconditions.checkArgument(false, s + "已参与套料或排产,图纸无法进行操作");
      }

      return Boolean.TRUE;
   }

   @Override
   public List bridgeSelectMachDrawing(List<Long> machinePartIds) {
      return this.baseMapper.bridgeSelectMachDrawing(machinePartIds);
   }

   @Override
   public ResultVO uploadZipFileChoose(MultipartFile multipartFile, Long projectId, Long monomerId, Integer dataType, Integer productType, String fileName) throws Exception {
      if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "产品类型不存在!");
         Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
         ContractProject project = this.projectService.checkProjectStatus(projectId);
         Preconditions.checkArgument(monomerId != null, "单体id不能为空");
         PlanMonomer monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         String originalFilename = multipartFile.getOriginalFilename();
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称为空!");
      } else if (dataType.equals(TechDataTypeEnum.XML_FILE.getType())) {
         Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
         ContractProject project = this.projectService.checkProjectStatus(projectId);
         Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "单体id不能为空");
         PlanMonomer monomer = null;
         if (monomerId != null) {
            monomer = this.monomerService.getById(monomerId);
            Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         }
      }

      return this.achievementBiz.createDrawingApprove(multipartFile, projectId, monomerId, null, null, dataType, productType, null, fileName, null, true, null);
   }

   @Override
   public ResultVO newUploadZipFileChoose(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      HttpServletResponse response
   ) {
      if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "产品类型不存在!");
         Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
         this.uploadPartFileZipChoose(multipartFile, projectId, monomerId, areaId, productType, cacheObjectDTOParam);
      } else if (dataType.equals(TechDataTypeEnum.XML_FILE.getType())) {
         this.uploadXMLFileAndUnzipChoose(multipartFile, projectId, monomerId, dataType, productType, fileName, cacheObjectDTOParam);
      }

      return null;
   }

   @Override
   public Boolean uploadPartFileZipChoose(
      MultipartFile multipartFile, Long projectId, Long monomerId, Long areaId, Integer productType, PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      Preconditions.checkArgument(monomerId != null, "单体id不能为空");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称为空!");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      String filePath = this.getFilePath(
         projectId, monomerId, TechDataTypeEnum.NC_DRAWING.getType(), productType, project.getProjectType(), drawingMatchRange, areaId
      );
      String absolutePath = this.configProperties.getFilePath() + filePath;
      String temporarilyPath = this.configProperties.getFilePath() + filePath + "temporarily" + File.separator;
      FileUtil.mkdirs(absolutePath);
      FileUtil.mkdirs(temporarilyPath);
      File file = new File(temporarilyPath + originalFilename);

      try {
         List<Long> drawingIds = new ArrayList<>();
         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               PlanArea area = this.areaService.getById(areaId);
               Preconditions.checkArgument(area != null, "导入失败，区域不存在");
            }

            multipartFile.transferTo(file);
            List<String> zipNameList = this.getZipNameList(file).stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
            List<TechMachinePart> machineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .in(TechMachinePart::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> zipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, List<String>> newfileNameListMap = new HashMap<>();
            List<String> finalZipNameList = zipNameList;
            if (CollectionUtils.isNotEmpty(machineParts)) {
               List<TechMachinePart> wingWebPlateList = machineParts.stream()
                  .filter(
                     e -> e.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        && !e.getSourcePartEnum().equals(SourcePartEnum.DIRECTLY_IMPORT.getType())
                  )
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(wingWebPlateList)) {
                  List<String> initialSerialNumbers = wingWebPlateList.stream()
                     .map(TechMachinePart::getInitialSerialNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  Map<String, List<TechMachinePart>> machinePartMap = this.machinePartService
                     .list(
                        Wrappers.lambdaQuery(TechMachinePart.class)
                           .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                           .eq(TechMachinePart::getMonomerId, monomerId)
                           .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                           .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                           .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_DISASSEMBLY.getType())
                           .in(TechMachinePart::getInitialSerialNumber, initialSerialNumbers)
                           .notIn(TechMachinePart::getSerialNumber, initialSerialNumbers)
                     )
                     .stream()
                     .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
                  Map<String, List<TechMachinePart>> wingWebPlateListMap = wingWebPlateList.stream()
                     .collect(Collectors.groupingBy(e -> e.getSourcePartEnum() + "#" + e.getInitialSerialNumber()));
                  wingWebPlateListMap.forEach(
                     (initialSerialNumberAndSourcePartEnum, partList) -> {
                        Integer sourcePartEnum = Integer.valueOf(initialSerialNumberAndSourcePartEnum.split("#")[0]);
                        String initialSerialNumber = initialSerialNumberAndSourcePartEnum.split("#")[1];
                        if (SourcePartEnum.COMPONENT_DISASSEMBLY.getType().equals(sourcePartEnum)) {
                           List<TechMachinePart> machinePartList = partList.stream()
                              .filter(e -> !e.getSerialNumber().equals(initialSerialNumber) && e.getSourcePartEnum().equals(sourcePartEnum))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(machinePartList)) {
                              List<TechMachinePart> techMachineParts = machinePartMap.get(initialSerialNumber);
                              if (CollectionUtils.isNotEmpty(techMachineParts)) {
                                 List<String> serialNumbers = techMachineParts.stream()
                                    .map(TechMachinePart::getSerialNumber)
                                    .distinct()
                                    .collect(Collectors.toList());
                                 if (serialNumbers.size() == 1) {
                                    machineParts.addAll(techMachineParts);
                                    newfileNameListMap.put(initialSerialNumber + ".dxf", Arrays.asList(serialNumbers.get(0) + ".dxf"));
                                    finalZipNameList.add(serialNumbers.get(0));
                                 }
                              }
                           } else {
                              machinePartList.forEach(e -> e.setBoolItsOwnDrawing(Boolean.TRUE));
                              this.machinePartService.updateBatchById(machinePartList);
                           }
                        }
                     }
                  );
               }
            }

            List<TechMachinePart> techMachineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                     .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_COMBINATION.getType())
                     .in(TechMachinePart::getInitialSerialNumber, zipNameList)
               );
            if (CollectionUtils.isNotEmpty(techMachineParts)) {
               machineParts.addAll(techMachineParts);
               Map<String, List<TechMachinePart>> techMachinePartMaps = techMachineParts.stream()
                  .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
               techMachinePartMaps.forEach(
                  (initialSerialNumber, partList) -> {
                     List<String> componentCombinationPartSerialNumbers = partList.stream()
                        .map(TechMachinePart::getSerialNumber)
                        .distinct()
                        .collect(Collectors.toList());
                     List<String> dxfSerialNumbers = new ArrayList<>();

                     for (String serialNumberx : componentCombinationPartSerialNumbers) {
                        dxfSerialNumbers.add(serialNumberx + ".dxf");
                        finalZipNameList.add(serialNumberx);
                     }

                     newfileNameListMap.put(initialSerialNumber + ".dxf", dxfSerialNumbers);
                  }
               );
            }

            List<String> fileNameList = this.unzipFile(file, temporarilyPath, newfileNameListMap);
            Preconditions.checkArgument(fileNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
            List<Long> productIds = machineParts.stream().map(TechMachinePart::getId).distinct().collect(Collectors.toList());
            List<String> serialNumbers = this.chooseDrawing(productIds, project.getProjectType(), productType);
            List<String> collect = serialNumbers.stream().map(s -> s + ".dxf").collect(Collectors.toList());
            Map<String, List<TechMachinePart>> partMap = machineParts.stream().collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
            OSS client = this.ossUtils.openClient();
            List<TechMachinePart> partUpdateList = new ArrayList<>();
            List<TechDrawing> drawingUpdateList = new ArrayList<>();
            List<TechDrawing> drawingInsertList = new ArrayList<>();
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                     .isNull(
                        project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()),
                        TechDrawing::getProductType
                     )
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .in(TechDrawing::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> zipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
            List<Long> holeRadiusLinkIds = this.machineHoleRadiusLinkService
               .list(
                  Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                     .eq(TechMachineHoleRadiusLink::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachineHoleRadiusLink::getAreaId, areaId)
                     .in(TechMachineHoleRadiusLink::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> zipNameList.contains(s.getSerialNumber()))
               .map(TechMachineHoleRadiusLink::getId)
               .collect(Collectors.toList());
            this.machineHoleRadiusLinkService.removeByIds(holeRadiusLinkIds);
            Map<String, HoleRadiusDTO> holeRadiusDTOMap = new HashMap<>();

            for (String name : fileNameList) {
               if (!collect.contains(name)) {
                  boolean booleUpdate = false;
                  String fileSuffix = FileUtil.getFileExtension(name);
                  Preconditions.checkArgument("dxf".equalsIgnoreCase(fileSuffix), "零件图纸格式不正确!");
                  String serialNumber = name.replaceAll("[.][^.]+$", "");
                  String ossRelativePath;
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     ossRelativePath = projectId + "/" + monomerId + "/" + areaId + "/" + name;
                  } else {
                     ossRelativePath = projectId + "/" + monomerId + "/" + name;
                  }

                  String localAbsoluteFilePath = temporarilyPath + name;
                  String dxfUrl = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
                  TechDrawing drawing = drawingMap.get(serialNumber);
                  if (drawing != null) {
                     booleUpdate = true;
                     drawing.setCreateTime(LocalDateTime.now());
                     drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                  } else {
                     drawing = TechDrawing.builder()
                        .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                        .projectId(projectId)
                        .projectType(project.getProjectType())
                        .productType(null)
                        .monomerId(monomerId)
                        .serialNumber(serialNumber)
                        .filePath(filePath)
                        .cloudPath(dxfUrl)
                        .fileName(name)
                        .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                        .build();
                     if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                        drawing.setAreaId(areaId);
                     }
                  }

                  List<TechMachinePart> parts = partMap.get(serialNumber) == null ? new ArrayList<>() : partMap.get(serialNumber);
                  HoleRadiusDTO holeRadiusDTO = this.parseDrawing(filePath + "temporarily" + File.separator, drawing.getFileName());
                  holeRadiusDTOMap.put(serialNumber, holeRadiusDTO);
                  parts.forEach(part -> {
                     part.setPath(dxfUrl);
                     part.setOssRelativePath(ossRelativePath);
                     part.setBoolHaveHole(holeRadiusDTO.getHoleNumber() > 0);
                     part.setHoleNumber((long)holeRadiusDTO.getHoleNumber().intValue());
                  });
                  partUpdateList.addAll(parts);
                  String drawingUrl = this.transformationDxf(filePath + "temporarily" + File.separator, drawing.getFileName(), drawing.getSerialNumber(), 1);
                  drawing.setPicturePath(filePath + serialNumber + "." + ImageTypeEnums.getNameByType(1));
                  if (booleUpdate) {
                     drawingUpdateList.add(drawing);
                  } else {
                     drawingInsertList.add(drawing);
                  }
               }
            }

            List<TechMachineHoleRadiusLink> holeRadiusLinks = new ArrayList<>();
            this.saveBatch(drawingInsertList);
            this.updateBatchById(drawingUpdateList);
            this.machinePartService.updateBatchById(partUpdateList);

            for (TechDrawing drawing : drawingUpdateList) {
               HoleRadiusDTO holeRadiusDTO = holeRadiusDTOMap.get(drawing.getSerialNumber());
               Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

               for (Double aDouble : map.keySet()) {
                  TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
                     .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
                     .quantity(map.get(aDouble).intValue())
                     .serialNumber(drawing.getSerialNumber())
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .monomerId(drawing.getMonomerId())
                     .drawingId(drawing.getId())
                     .fileName(drawing.getFileName())
                     .build();
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     build.setAreaId(areaId);
                  }

                  holeRadiusLinks.add(build);
               }

               drawingIds.add(drawing.getId());
            }

            this.machineHoleRadiusLinkService.saveBatch(holeRadiusLinks);
            this.ossUtils.closeClient(client);
            PlanFileUtils.copyFile(temporarilyPath, absolutePath, collect);
         }

         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            multipartFile.transferTo(file);
            List<String> zipNameList = this.getZipNameList(file);
            Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
            zipNameList = zipNameList.stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
            List<String> fileNameList = this.unzipFile(file, temporarilyPath, new HashMap<>());
            List<String> finalZipNameList = zipNameList;
            List<TechAssemble> allAssemble = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).in(TechAssemble::getInitialSerialNumber, zipNameList))
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, List<TechAssemble>> assMap = allAssemble.stream().collect(Collectors.groupingBy(TechAssemble::getInitialSerialNumber));
            List<Long> ids = allAssemble.stream().map(TechAssemble::getId).distinct().collect(Collectors.toList());
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(TechDrawing::getProductType, productType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .in(TechDrawing::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
            List<String> chooseSerialNumbers = this.chooseDrawing(ids, project.getProjectType(), productType);
            List<String> collect1 = chooseSerialNumbers.stream().map(s -> s + ".nc1").collect(Collectors.toList());
            System.gc();
            List<TechAssemble> needUpdateAss = new ArrayList<>();
            List<TechDrawing> needUpdateDrawings = new ArrayList<>();
            List<TechDrawing> needInsertDrawings = new ArrayList<>();

            for (String name : fileNameList) {
               if (!collect1.contains(name)) {
                  String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
                  BigDecimal Nc1Length = BigDecimal.ZERO;

                  try {
                     Nc1Length = BigDecimal.valueOf(NC1Parser.getAssembleRealLength(temporarilyPath + name));
                  } catch (IOException e) {
                     Preconditions.checkArgument(false, "图纸解析异常,请重新导入");
                  }

                  TechDrawing drawing = drawingMap.get(serialNumber);
                  if (drawing != null) {
                     drawing.setFilePath(
                        this.getFilePath(projectId, monomerId, TechDataTypeEnum.NC_DRAWING.getType(), productType, project.getProjectType(), null, null)
                     );
                     drawing.setCreateTime(LocalDateTime.now());
                     drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                     needUpdateDrawings.add(drawing);
                  } else {
                     drawing = TechDrawing.builder()
                        .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                        .projectId(projectId)
                        .monomerId(monomerId)
                        .serialNumber(serialNumber)
                        .productType(productType)
                        .filePath(filePath)
                        .nc1Length(Nc1Length)
                        .fileName(name)
                        .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                        .build();
                     needInsertDrawings.add(drawing);
                  }

                  drawingIds.add(drawing.getId());
                  List<TechAssemble> techAssembles = assMap.get(serialNumber);
                  if (CollectionUtils.isNotEmpty(techAssembles)) {
                     BigDecimal finalNc1Length = Nc1Length;
                     List<TechAssemble> collect = techAssembles.stream()
                        .map(s -> s.setBoolHaveNC1(Boolean.TRUE))
                        .map(e -> e.setNc1Length(finalNc1Length))
                        .collect(Collectors.toList());
                     needUpdateAss.addAll(collect);
                  }
               }
            }

            this.saveBatch(needInsertDrawings);
            this.updateBatchById(needUpdateDrawings);
            this.assembleService.updateBatchById(needUpdateAss);
            PlanFileUtils.copyFile(temporarilyPath, absolutePath, collect1);
         }

         this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), TechDataTypeEnum.NC_DRAWING.getType(), productType, project, monomer, drawingIds);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         System.gc();
         File file1 = new File(temporarilyPath);
         PlanFileUtils.deleteFolder(file1);
      }

      return true;
   }

   @Override
   public void uploadXMLFileAndUnzipChoose(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam
   ) {
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "单体id不能为空");
      PlanMonomer monomer = null;
      if (monomerId != null) {
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      }

      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "导入失败，只能上传zip压缩文件");
      String filePath = this.getFilePath(projectId, monomerId, dataType, productType, project.getProjectType(), null, null);
      String absolutePath = this.configProperties.getFilePath() + filePath;
      String temporarilyPath = this.configProperties.getFilePath() + filePath + "temporarily" + File.separator;
      FileUtil.mkdirs(absolutePath);
      FileUtil.mkdirs(temporarilyPath);
      List<Long> drawingIds = null;
      File file = new File(temporarilyPath + originalFilename);

      try {
         multipartFile.transferTo(file);
         List<String> zipNameList = this.getZipNameList(file);
         Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
         zipNameList = zipNameList.stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
         List<String> fileNameList = this.unzipFile(file, temporarilyPath, new HashMap<>());
         drawingIds = new ArrayList<>(fileNameList.size());
         List<String> finalZipNameList = zipNameList;
         List<TechDrawing> drawings = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getMonomerId, monomerId)
                  .eq(TechDrawing::getProductType, productType)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.XML_FILE.getType())
                  .in(TechDrawing::getSerialNumber, zipNameList)
            )
            .stream()
            .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
            .collect(Collectors.toList());
         Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
         List<TechArtifact> artifacts = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getMonomerId, monomerId).in(TechArtifact::getSerialNumber, zipNameList))
            .stream()
            .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
            .collect(Collectors.toList());
         Map<String, List<TechArtifact>> artfactMap = artifacts.stream().collect(Collectors.groupingBy(TechArtifact::getSerialNumber));
         List<Long> ids = artifacts.stream().map(TechArtifact::getId).collect(Collectors.toList());
         this.checkDrawing(ids, project.getProjectType(), productType);
         List<String> serialNumbers = this.chooseDrawing(ids, project.getProjectType(), productType);
         List<String> collect = serialNumbers.stream().map(s -> s + ".xml").collect(Collectors.toList());
         List<TechDrawing> needUpdateDrawings = new ArrayList<>();
         List<TechDrawing> needInsertDrawings = new ArrayList<>();

         for (String name : fileNameList) {
            if (!collect.contains(name)) {
               String fileSuffix = FileUtil.getFileExtension(name);
               Preconditions.checkArgument("xml".equalsIgnoreCase(fileSuffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
               String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
               TechDrawing drawing = drawingMap.get(serialNumber);
               if (drawing != null) {
                  drawing.setFilePath(filePath);
                  drawing.setCreateTime(LocalDateTime.now());
                  drawing.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
                  needUpdateDrawings.add(drawing);
               }

               if (drawing == null) {
                  drawing = TechDrawing.builder()
                     .projectId(projectId)
                     .monomerId(monomerId)
                     .dataType(dataType)
                     .productType(productType)
                     .serialNumber(serialNumber)
                     .filePath(filePath)
                     .fileName(name)
                     .createUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId())
                     .build();
                  needInsertDrawings.add(drawing);
               }

               drawingIds.add(drawing.getId());
            }
         }

         this.updateBatchById(needUpdateDrawings);
         this.saveBatch(needInsertDrawings);
         PlanFileUtils.copyFile(temporarilyPath, absolutePath, collect);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         System.gc();
         file.delete();
      }

      this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, drawingIds);
   }

   private List<String> chooseDrawing(List<Long> productIds, Integer projectType, Integer productType) {
      if (productIds.size() == 0) {
         return new ArrayList<>();
      }

      if ((projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType()))
         && !productType.equals(ProductTypeEnum.ARTIFACT.getType())
         && !productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            List<MesBuildingNestCutPlatePart> list = this.mesBuildingNestCutPlatePartService
               .list(Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class).in(MesBuildingNestCutPlatePart::getPartId, productIds));
            if (CollectionUtils.isNotEmpty(list)) {
               Set<Long> collect = list.stream().map(MesBuildingNestCutPlatePart::getPartId).collect(Collectors.toSet());
               List<TechMachinePart> techMachineParts = this.machinePartService.listByIds(collect);
               return techMachineParts.stream().map(TechMachinePart::getSerialNumber).collect(Collectors.toList());
            }
         } else {
            Preconditions.checkArgument(false, "产品类型不正确");
         }
      }

      return new ArrayList<>();
   }

   @Override
   public ResultVO uploadFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   ) {
      try {
         this.checkParam(multipartFile, projectId, monomerId, dataType, productType);
         return this.achievementBiz
            .createDrawingApprove(multipartFile, projectId, monomerId, areaId, null, dataType, productType, null, fileName, null, false, response);
      } catch (Throwable $ex) {
         throw TechDrawingServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public ResultVO uploadAllFileAndUnzip(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Integer dataType,
      Integer productType,
      String fileName,
      PlanApproveCacheObjectDTOParam cacheObjectDTOParam,
      Long areaId,
      HttpServletResponse response
   ) {
      try {
         this.checkAllParam(multipartFile, projectId, monomerId, dataType, productType);
         return this.achievementBiz
            .createAllDrawingApprove(multipartFile, projectId, monomerId, areaId, null, dataType, productType, null, fileName, null, false, response);
      } catch (Throwable $ex) {
         throw TechDrawingServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public void checkParam(MultipartFile multipartFile, Long projectId, Long monomerId, Integer dataType, Integer productType) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      if (ProductTypeEnum.ALL_PRODUCT.getType().equals(productType)) {
         Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "仅支持上传zip文件类型!");
      }

      if ("zip".equalsIgnoreCase(suffix)) {
         if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
            Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "产品类型不存在!");
            Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
            ContractProject project = this.projectService.checkProjectStatus(projectId);
            Preconditions.checkArgument(monomerId != null, "单体id不能为空");
            PlanMonomer monomer = this.monomerService.getById(monomerId);
            Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
            String originalFilenameOne = multipartFile.getOriginalFilename();
            Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilenameOne), "压缩文件名称为空!");
            if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) && !productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
               Preconditions.checkArgument(false, "产品类型不正确(暂时只能覆盖导入零件)");
            }
         } else if (dataType.equals(TechDataTypeEnum.XML_FILE.getType())) {
            Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
            ContractProject project = this.projectService.checkProjectStatus(projectId);
            Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "单体id不能为空");
            PlanMonomer monomer = null;
            if (monomerId != null) {
               monomer = this.monomerService.getById(monomerId);
               Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
            }

            String filename = multipartFile.getOriginalFilename();
            Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(filename), "压缩文件名称为空!");
            String suffix1 = FileUtil.getFileExtension(originalFilename);
            Preconditions.checkArgument("zip".equalsIgnoreCase(suffix1), "导入失败，只能上传zip压缩文件");
            String originalFilenameOne = multipartFile.getOriginalFilename();
            Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilenameOne), "压缩文件名称为空!");
         } else {
            if (monomerId != null && !UserUtil.getCurrentUser().isAdmin()) {
               List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
                  .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, monomerId));
               Preconditions.checkArgument(
                  CollectionUtils.isNotEmpty(monomerUserLinkList)
                     && monomerUserLinkList.stream()
                        .map(MonomerUserLink::getDeepenedPersonId)
                        .collect(Collectors.toList())
                        .contains(UserUtil.getCurrentUserId()),
                  "您不是该单体深化负责人,不允许导入文件!"
               );
            }

            Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
            ContractProject project = this.projectService.checkProjectStatus(projectId);
            if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
               Preconditions.checkArgument(productType != null, "上传深化图纸,缺少产品类型");
               if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "建钢产品类型有误");
               }
            }

            Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "深化图纸单体id不能为空");
            PlanMonomer monomer = null;
            if (monomerId != null) {
               monomer = this.monomerService.getById(monomerId);
               Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
            }

            String filename1 = multipartFile.getOriginalFilename();
            Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(filename1), "压缩文件名称不能为空!");
            String suffix2 = FileUtil.getFileExtension(filename1);
            Preconditions.checkArgument("zip".equalsIgnoreCase(suffix2), "导入失败，只能上传zip压缩文件");
            List<String> zipNameList = null;

            try {
               zipNameList = this.getZipFileNames(multipartFile);
            } catch (Exception e) {
               throw new BusinessException("获取压缩包内文件名称失败！");
            }

            Set<String> nameSet = new HashSet<>(zipNameList);
            Preconditions.checkArgument(nameSet.size() == zipNameList.size(), "存在重复文件,请审查后重新导入!");
            Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
         }
      } else {
         ContractProject project = this.projectService.checkProjectStatus(projectId);
         PlanMonomer monomer = null;
         String originalFilenameOne = multipartFile.getOriginalFilename();
         Preconditions.checkArgument(!originalFilenameOne.contains(" "), "文件名不能包含空格");
         originalFilenameOne = this.transformLowercaseSuffix(originalFilenameOne);
         String serialNumber = originalFilenameOne.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
         if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
            monomer = this.monomerService.getById(monomerId);
            Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
            if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
               Preconditions.checkArgument(!productType.equals(ProductTypeEnum.ARTIFACT.getType()), "构件没有数控图纸!");
            }

            if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
               && productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
               new ArrayList();
               List<Long> var37 = this.techAssembleService
                  .list(
                     Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).eq(TechAssemble::getInitialSerialNumber, serialNumber)
                  )
                  .stream()
                  .distinct()
                  .filter(s -> serialNumber.equals(s.getSerialNumber()))
                  .map(TechAssemble::getId)
                  .collect(Collectors.toList());
               this.checkDrawing(var37, project.getProjectType(), productType);
               Preconditions.checkArgument("nc1".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "部件图纸格式不正确!");
            }

            if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
               && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
               if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
                  List<Long> productIds = this.machinePartService
                     .list(
                        Wrappers.lambdaQuery(TechMachinePart.class)
                           .eq(TechMachinePart::getMonomerId, monomerId)
                           .eq(TechMachinePart::getSerialNumber, serialNumber)
                     )
                     .stream()
                     .filter(s -> serialNumber.contains(s.getSerialNumber()))
                     .map(TechMachinePart::getId)
                     .distinct()
                     .collect(Collectors.toList());
                  this.checkDrawing(productIds, project.getProjectType(), productType);
               }

               Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "零件图纸格式不正确!");
            }
         }

         if (dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
            if (monomerId != null && !UserUtil.getCurrentUser().isAdmin()) {
               List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
                  .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, monomerId));
               Preconditions.checkArgument(
                  CollectionUtils.isNotEmpty(monomerUserLinkList)
                     && monomerUserLinkList.stream()
                        .map(MonomerUserLink::getDeepenedPersonId)
                        .collect(Collectors.toList())
                        .contains(UserUtil.getCurrentUserId()),
                  "您不是该单体深化负责人,不允许导入文件!"
               );
            }

            monomer = this.monomerService.getById(monomerId);
            Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
            Preconditions.checkArgument("dwg".equalsIgnoreCase(suffix) || "pdf".equalsIgnoreCase(suffix), TechDataTypeEnum.getNameByType(dataType) + "格式不正确!");
            if (project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType())) {
               DrawingRecognitionRules rules = this.sysDrawingRecognitionRulesService.getOne(new LambdaQueryWrapper<>());
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                  Preconditions.checkArgument(rules != null, "图纸识别规则未配置!!!");
               }

               Map<String, Object> map;
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                  map = this.getSerialAndOrder(serialNumber, rules.getType());
               } else {
                  map = new HashMap<>();
               }

               QueryWrapper<TechDrawing> queryWrapper = new QueryWrapper<>();
               queryWrapper.eq("project_id", projectId)
                  .eq("monomer_id", monomerId)
                  .eq("data_type", dataType)
                  .eq("product_type", productType)
                  .eq("serial_number", DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber);
               if (DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                  if (map.get("number") == null) {
                     queryWrapper.eq("number", 0);
                  } else {
                     queryWrapper.eq("number", map.get("number"));
                  }

                  if (map.get("dwgNum") == null) {
                     queryWrapper.isNull("dwg_num");
                  } else {
                     queryWrapper.eq("dwg_num", map.get("dwgNum"));
                  }
               }

               List<TechDrawing> drawings = this.baseMapper.selectList(queryWrapper);
               TechDrawing drawing = drawings.stream()
                  .filter(
                     s -> s.getSerialNumber().equals(DrawingProductTypeEnum.ARTIFACT.getType().equals(productType) ? map.get("serialNumber") : serialNumber)
                  )
                  .findFirst()
                  .orElse(null);
               if (drawing != null
                  && DrawingProductTypeEnum.ARTIFACT.getType().equals(productType)
                  && SysDrawingRecognitionRulesEnums.DRAWING__ARTIFACTS.getType().equals(rules.getType())) {
                  Preconditions.checkArgument(drawing.getDwgNum().equals(map.get("dwgNum")), "导入失败同一单体下图纸的图号默认相同");
               }
            }
         }
      }
   }

   public void checkAllParam(MultipartFile multipartFile, Long projectId, Long monomerId, Integer dataType, Integer productType) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument("zip".equalsIgnoreCase(suffix), "操作失败,仅支持上传zip压缩文件!");
      if ("zip".equalsIgnoreCase(suffix) && dataType.equals(TechDataTypeEnum.DEEPEN.getType())) {
         if (monomerId != null && !UserUtil.getCurrentUser().isAdmin()) {
            List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
               .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, monomerId));
            Preconditions.checkArgument(
               CollectionUtils.isNotEmpty(monomerUserLinkList)
                  && monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList()).contains(UserUtil.getCurrentUserId()),
               "您不是该单体深化负责人,不允许导入文件!"
            );
         }

         Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.NC_DRAWING.getType()), "资料类型错误!");
         ContractProject project = this.projectService.checkProjectStatus(projectId);
         Preconditions.checkArgument(!dataType.equals(TechDataTypeEnum.DEEPEN.getType()) || monomerId != null, "深化图纸单体id不能为空");
         PlanMonomer monomer = null;
         if (monomerId != null) {
            monomer = this.monomerService.getById(monomerId);
            Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
         }

         String filename1 = multipartFile.getOriginalFilename();
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(filename1), "压缩文件名称不能为空!");
         String suffix2 = FileUtil.getFileExtension(filename1);
         Preconditions.checkArgument("zip".equalsIgnoreCase(suffix2), "导入失败，只能上传zip压缩文件");
         List<String> zipNameList = null;

         try {
            zipNameList = this.getZipFileNames(multipartFile);
         } catch (Exception e) {
            throw new BusinessException("获取压缩包内文件名称失败！");
         }

         Set<String> nameSet = new HashSet<>(zipNameList);
         Preconditions.checkArgument(nameSet.size() == zipNameList.size(), "存在重复文件,请审查后重新导入!");
         Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
      }
   }

   public List<String> getZipFileNames(MultipartFile zipFile) throws Exception {
      List<String> fileNames = new ArrayList<>();

      ZipArchiveEntry entry;
      try (
         InputStream is = zipFile.getInputStream();
         ZipArchiveInputStream zis = new ZipArchiveInputStream(is, "GBK", false);
      ) {
         while ((entry = zis.getNextZipEntry()) != null) {
            if (!entry.isDirectory()) {
               fileNames.add(entry.getName());
            }
         }
      }

      return fileNames;
   }

   @Override
   public Map<String, String> bridgeGetDxfPictures(Long monomerId, Set<String> serialNumbers) {
      List<TechDrawing> list = this.list(
         Wrappers.lambdaQuery(TechDrawing.class)
            .eq(TechDrawing::getMonomerId, monomerId)
            .in(TechDrawing::getSerialNumber, serialNumbers)
            .eq(TechDrawing::getProductType, TaskTypeEnum.MACHINE_PART.getType())
            .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
      );
      Map<String, String> collect = list.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, TechDrawing::getPicturePath, (s1, s2) -> s2));

      for (String s : collect.keySet()) {
         if (org.apache.commons.lang3.StringUtils.isEmpty(collect.get(s))) {
            collect.put(s, null);
         } else {
            String path = collect.get(s) == null ? null : this.ip + "files/" + collect.get(s);
            if (org.apache.commons.lang3.StringUtils.isNotBlank(path) && path.contains("#")) {
               path = path.replaceAll("#", "%23");
            }

            collect.put(s, path);
         }
      }

      for (String serialNumber : serialNumbers) {
         if (!collect.keySet().contains(serialNumber)) {
            collect.put(serialNumber, null);
         }
      }

      return collect;
   }

   @Transactional(rollbackFor = Exception.class)
   public synchronized List<TechDrawing> nestingUploadPartFileZip(
      MultipartFile multipartFile, Long projectId, Long monomerId, Long areaId, Integer productType, HttpServletResponse response
   ) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      List<TechDrawing> needUpdateDrawingsReturn = new ArrayList<>();
      Preconditions.checkArgument(monomerId != null, "单体id不能为空");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "导入失败，单体不存在");
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "压缩文件名称为空!");
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      String filePath = this.getFilePath(
         projectId, monomerId, TechDataTypeEnum.NC_DRAWING.getType(), productType, project.getProjectType(), drawingMatchRange, areaId
      );
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      File file = new File(absolutePath + originalFilename);

      try {
         List<Long> drawingIds = new ArrayList<>();
         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               PlanArea area = this.areaService.getById(areaId);
               Preconditions.checkArgument(area != null, "操作失败,区域不存在!");
            }

            multipartFile.transferTo(file);
            List<String> zipNameList = this.getZipNameList(file);
            Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
            zipNameList = zipNameList.stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
            List<String> finalZipNameList = zipNameList;
            List<TechMachinePart> machineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .in(TechMachinePart::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, List<String>> newfileNameListMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(machineParts)) {
               List<TechMachinePart> wingWebPlateList = machineParts.stream()
                  .filter(
                     ex -> ex.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        && !ex.getSourcePartEnum().equals(SourcePartEnum.DIRECTLY_IMPORT.getType())
                  )
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(wingWebPlateList)) {
                  List<String> initialSerialNumbers = wingWebPlateList.stream()
                     .map(TechMachinePart::getInitialSerialNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  Map<String, List<TechMachinePart>> machinePartMap = this.machinePartService
                     .list(
                        Wrappers.lambdaQuery(TechMachinePart.class)
                           .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                           .eq(TechMachinePart::getMonomerId, monomerId)
                           .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                           .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                           .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_DISASSEMBLY.getType())
                           .in(TechMachinePart::getInitialSerialNumber, initialSerialNumbers)
                           .notIn(TechMachinePart::getSerialNumber, initialSerialNumbers)
                     )
                     .stream()
                     .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
                  Map<String, List<TechMachinePart>> wingWebPlateListMap = wingWebPlateList.stream()
                     .collect(Collectors.groupingBy(ex -> ex.getSourcePartEnum() + "#" + ex.getInitialSerialNumber()));
                  wingWebPlateListMap.forEach(
                     (initialSerialNumberAndSourcePartEnum, partList) -> {
                        Integer sourcePartEnum = Integer.valueOf(initialSerialNumberAndSourcePartEnum.split("#")[0]);
                        String initialSerialNumber = initialSerialNumberAndSourcePartEnum.split("#")[1];
                        if (SourcePartEnum.COMPONENT_DISASSEMBLY.getType().equals(sourcePartEnum)) {
                           List<TechMachinePart> machinePartList = partList.stream()
                              .filter(ex -> !ex.getSerialNumber().equals(initialSerialNumber) && ex.getSourcePartEnum().equals(sourcePartEnum))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(machinePartList)) {
                              List<TechMachinePart> techMachineParts = machinePartMap.get(initialSerialNumber);
                              if (CollectionUtils.isNotEmpty(techMachineParts)) {
                                 List<String> serialNumbers = techMachineParts.stream()
                                    .map(TechMachinePart::getSerialNumber)
                                    .distinct()
                                    .collect(Collectors.toList());
                                 if (serialNumbers.size() == 1) {
                                    machineParts.addAll(techMachineParts);
                                    newfileNameListMap.put(initialSerialNumber + ".dxf", Arrays.asList(serialNumbers.get(0) + ".dxf"));
                                    finalZipNameList.add(serialNumbers.get(0));
                                 }
                              }
                           } else {
                              machinePartList.forEach(ex -> ex.setBoolItsOwnDrawing(Boolean.TRUE));
                              this.machinePartService.updateBatchById(machinePartList);
                           }
                        }
                     }
                  );
               }
            }

            List<TechMachinePart> techMachineParts = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                     .eq(TechMachinePart::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                     .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                     .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_COMBINATION.getType())
                     .in(TechMachinePart::getInitialSerialNumber, zipNameList)
               );
            if (CollectionUtils.isNotEmpty(techMachineParts)) {
               machineParts.addAll(techMachineParts);
               Map<String, List<TechMachinePart>> techMachinePartMaps = techMachineParts.stream()
                  .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
               techMachinePartMaps.forEach(
                  (initialSerialNumber, partList) -> {
                     List<String> componentCombinationPartSerialNumbers = partList.stream()
                        .map(TechMachinePart::getSerialNumber)
                        .distinct()
                        .collect(Collectors.toList());
                     List<String> dxfSerialNumbers = new ArrayList<>();

                     for (String serialNumberx : componentCombinationPartSerialNumbers) {
                        dxfSerialNumbers.add(serialNumberx + ".dxf");
                        finalZipNameList.add(serialNumberx);
                     }

                     newfileNameListMap.put(initialSerialNumber + ".dxf", dxfSerialNumbers);
                  }
               );
            }

            List<Long> productIds = machineParts.stream().map(TechMachinePart::getId).distinct().collect(Collectors.toList());
            this.checkDrawing(productIds, project.getProjectType(), productType);
            Map<String, List<TechMachinePart>> partMap = machineParts.stream().collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
            List<String> fileNameList = this.unzipFile(file, absolutePath, newfileNameListMap);
            OSS client = this.ossUtils.openClient();
            List<TechMachinePart> partUpdateList = new ArrayList<>();
            List<TechDrawing> drawingUpdateList = new ArrayList<>();
            List<TechDrawing> drawingInsertList = new ArrayList<>();
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                     .isNull(
                        project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()),
                        TechDrawing::getProductType
                     )
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .in(TechDrawing::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
            List<Long> holeRadiusLinkIds = this.machineHoleRadiusLinkService
               .list(
                  Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                     .eq(TechMachineHoleRadiusLink::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachineHoleRadiusLink::getAreaId, areaId)
                     .in(TechMachineHoleRadiusLink::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .map(TechMachineHoleRadiusLink::getId)
               .collect(Collectors.toList());
            this.machineHoleRadiusLinkService.removeByIds(holeRadiusLinkIds);
            Map<String, HoleRadiusDTO> holeRadiusDTOMap = new HashMap<>();
            List<DXFUploadFailDTO> dxfUploadFailDTOList = new ArrayList<>();

            for (String name : fileNameList) {
               String localAbsoluteFilePath = absolutePath + name;
               File f = new File(localAbsoluteFilePath);

               try {
                  CorrectDXF.resolverDXFForImport(f);
               } catch (Exception e) {
                  dxfUploadFailDTOList.add(new DXFUploadFailDTO(f.getName(), e.getMessage()));
               }
            }

            if (CollectionUtils.isNotEmpty(dxfUploadFailDTOList)) {
               exportMistakeList(dxfUploadFailDTOList, response);
               return new ArrayList<>();
            }

            fileNameList.forEach(
               namex -> {
                  boolean booleUpdate = false;
                  String fileSuffix = FileUtil.getFileExtension(namex);
                  Preconditions.checkArgument("dxf".equalsIgnoreCase(fileSuffix), "零件图纸格式不正确!");
                  String serialNumberx = namex.replaceAll("[.][^.]+$", "");
                  String ossRelativePath;
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     ossRelativePath = projectId + "/" + monomerId + "/" + areaId + "/" + namex;
                  } else {
                     ossRelativePath = projectId + "/" + monomerId + "/" + namex;
                  }

                  String localAbsoluteFilePath = absolutePath + namex;
                  String dxfUrl = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
                  TechDrawing drawingx = drawingMap.get(serialNumberx);
                  if (drawingx != null) {
                     booleUpdate = true;
                     drawingx.setCreateUserId(UserUtil.getCurrentUserId());
                  } else {
                     drawingx = TechDrawing.builder()
                        .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                        .projectId(projectId)
                        .projectType(project.getProjectType())
                        .productType(null)
                        .monomerId(monomerId)
                        .serialNumber(serialNumberx)
                        .filePath(filePath)
                        .cloudPath(dxfUrl)
                        .fileName(namex)
                        .createUserId(UserUtil.getCurrentUserId())
                        .build();
                     if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                        drawingx.setAreaId(areaId);
                     }
                  }

                  List<TechMachinePart> parts = partMap.get(serialNumberx) == null ? new ArrayList<>() : partMap.get(serialNumberx);
                  HoleRadiusDTO holeRadiusDTOx = this.parseDrawing(drawingx.getFilePath(), drawingx.getFileName());
                  holeRadiusDTOMap.put(serialNumberx, holeRadiusDTOx);
                  parts.forEach(part -> {
                     part.setPath(dxfUrl);
                     part.setOssRelativePath(ossRelativePath);
                     part.setBoolHaveHole(holeRadiusDTOx.getHoleNumber() > 0);
                     part.setHoleNumber((long)holeRadiusDTOx.getHoleNumber().intValue());
                  });
                  partUpdateList.addAll(parts);
                  String drawingUrl = this.transformationDxf(drawingx.getFilePath(), drawingx.getFileName(), drawingx.getSerialNumber(), 1);
                  drawingx.setPicturePath(drawingUrl);
                  if (booleUpdate) {
                     drawingUpdateList.add(drawingx);
                  } else {
                     drawingInsertList.add(drawingx);
                  }
               }
            );
            List<TechMachineHoleRadiusLink> holeRadiusLinks = new ArrayList<>();
            needUpdateDrawingsReturn.addAll(drawingUpdateList);
            needUpdateDrawingsReturn.addAll(drawingInsertList);
            this.saveBatch(drawingInsertList);
            this.updateBatchById(drawingUpdateList);
            this.machinePartService.updateBatchById(partUpdateList);

            for (TechDrawing drawing : drawingUpdateList) {
               HoleRadiusDTO holeRadiusDTO = holeRadiusDTOMap.get(drawing.getSerialNumber());
               Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

               for (Double aDouble : map.keySet()) {
                  TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
                     .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
                     .quantity(map.get(aDouble).intValue())
                     .serialNumber(drawing.getSerialNumber())
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .monomerId(drawing.getMonomerId())
                     .drawingId(drawing.getId())
                     .fileName(drawing.getFileName())
                     .build();
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     build.setAreaId(areaId);
                  }

                  holeRadiusLinks.add(build);
               }

               drawingIds.add(drawing.getId());
            }

            for (TechDrawing drawing : drawingInsertList) {
               HoleRadiusDTO holeRadiusDTO = holeRadiusDTOMap.get(drawing.getSerialNumber());
               Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

               for (Double aDouble : map.keySet()) {
                  TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
                     .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
                     .quantity(map.get(aDouble).intValue())
                     .serialNumber(drawing.getSerialNumber())
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .monomerId(drawing.getMonomerId())
                     .drawingId(drawing.getId())
                     .fileName(drawing.getFileName())
                     .build();
                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     build.setAreaId(areaId);
                  }

                  holeRadiusLinks.add(build);
               }

               drawingIds.add(drawing.getId());
            }

            this.machineHoleRadiusLinkService.saveBatch(holeRadiusLinks);
            this.ossUtils.closeClient(client);
         }

         if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
            && productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            multipartFile.transferTo(file);
            List<String> zipNameList = this.getZipNameList(file);
            Preconditions.checkArgument(zipNameList.stream().noneMatch(s -> s.contains(" ")), "文件名不应该包含空格");
            zipNameList = this.getZipNameList(file).stream().map(s -> s.replaceAll("[.][^.]+$", "")).collect(Collectors.toList());
            List<String> finalZipNameList = zipNameList;
            List<TechAssemble> allAssemble = this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getMonomerId, monomerId).in(TechAssemble::getInitialSerialNumber, zipNameList))
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, List<TechAssemble>> assMap = allAssemble.stream().collect(Collectors.groupingBy(TechAssemble::getSerialNumber));
            List<Long> ids = allAssemble.stream().map(TechAssemble::getId).distinct().collect(Collectors.toList());
            List<TechDrawing> drawings = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(TechDrawing::getProductType, productType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .in(TechDrawing::getSerialNumber, zipNameList)
               )
               .stream()
               .filter(s -> finalZipNameList.contains(s.getSerialNumber()))
               .collect(Collectors.toList());
            Map<String, TechDrawing> drawingMap = drawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, Function.identity()));
            this.checkDrawing(ids, project.getProjectType(), productType);
            List<TechAssemble> needUpdateAss = new ArrayList<>();
            List<TechDrawing> needUpdateDrawings = new ArrayList<>();
            List<TechDrawing> needInsertDrawings = new ArrayList<>();

            for (String name : this.unzipFile(file, absolutePath, new HashMap<>())) {
               String serialNumber = name.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
               BigDecimal Nc1Length = BigDecimal.ZERO;

               try {
                  Nc1Length = BigDecimal.valueOf(NC1Parser.getAssembleRealLength(absolutePath + name));
               } catch (IOException e) {
                  e.printStackTrace();
                  Preconditions.checkArgument(false, "图纸解析异常,请重新导入");
               }

               TechDrawing drawing = drawingMap.get(serialNumber);
               if (drawing != null) {
                  drawing.setFilePath(
                     this.getFilePath(projectId, monomerId, TechDataTypeEnum.NC_DRAWING.getType(), productType, project.getProjectType(), null, null)
                  );
                  drawing.setCreateUserId(UserUtil.getCurrentUserId());
                  needUpdateDrawings.add(drawing);
               } else {
                  drawing = TechDrawing.builder()
                     .dataType(TechDataTypeEnum.NC_DRAWING.getType())
                     .projectId(projectId)
                     .monomerId(monomerId)
                     .serialNumber(serialNumber)
                     .productType(productType)
                     .filePath(filePath)
                     .nc1Length(Nc1Length)
                     .fileName(name)
                     .createUserId(UserUtil.getCurrentUserId())
                     .build();
                  needInsertDrawings.add(drawing);
               }

               drawingIds.add(drawing.getId());
               List<TechAssemble> techAssembles = assMap.get(serialNumber);
               if (CollectionUtils.isNotEmpty(techAssembles)) {
                  BigDecimal finalNc1Length = Nc1Length;
                  List<TechAssemble> collect = techAssembles.stream()
                     .map(s -> s.setBoolHaveNC1(Boolean.TRUE))
                     .map(ex -> ex.setNc1Length(finalNc1Length))
                     .collect(Collectors.toList());
                  needUpdateAss.addAll(collect);
               }
            }

            this.saveBatch(needInsertDrawings);
            this.updateBatchById(needUpdateDrawings);
            this.assembleService.updateBatchById(needUpdateAss);
         }

         this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), TechDataTypeEnum.NC_DRAWING.getType(), productType, project, monomer, drawingIds);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         System.gc();
         file.delete();
      }

      return needUpdateDrawingsReturn;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean nestingUpdateFile(
      Long productId,
      Integer productType,
      Integer dataType,
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      HttpServletResponse response
   ) {
      Preconditions.checkArgument(TechDataTypeEnum.isExist(dataType), "资料类型不存在!");
      List<Long> pid = new ArrayList<>();
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         if (machinePart != null) {
            areaId = machinePart.getAreaId();
            pid.add(machinePart.getId());
         }
      } else {
         Preconditions.checkArgument(false, "产品类型不正确");
      }

      ContractProject project = this.projectService.checkProjectStatus(projectId);
      this.checkDrawing(pid, project.getProjectType(), productType);
      String originalFilename = multipartFile.getOriginalFilename();
      originalFilename = this.transformLowercaseSuffix(originalFilename);
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      PlanMonomer monomer = null;
      String serialNumber = originalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
      ArrayList<Long> drawingIds = new ArrayList<>();
      String serial = this.artifactService.selectByTypeAndId(productType, productId);
      if (dataType.equals(TechDataTypeEnum.NC_DRAWING.getType())) {
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "修改失败，单体不存在");
         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            PlanArea area = this.areaService.getById(areaId);
            Preconditions.checkArgument(area != null, "导入失败，区域不存在");
         }

         Preconditions.checkArgument(serial.equals(serialNumber), "修改失败,本张图纸与本构件编号不符!");
         List<String> originalFilenameList = new ArrayList<>();
         originalFilenameList.add(originalFilename);
         Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), ProductTypeEnum.getNameByType(dataType) + "零件图纸格式不正确!");
         List<TechMachinePart> machineParts = this.machinePartService
            .list(Wrappers.lambdaQuery(TechMachinePart.class).eq(TechMachinePart::getMonomerId, monomerId).eq(TechMachinePart::getSerialNumber, serialNumber));
         if (CollectionUtils.isNotEmpty(machineParts)) {
            List<TechMachinePart> wingWebPlateList = machineParts.stream()
               .filter(
                  e -> e.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                     && !e.getSourcePartEnum().equals(SourcePartEnum.DIRECTLY_IMPORT.getType())
               )
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(wingWebPlateList)) {
               List<String> initialSerialNumbers = wingWebPlateList.stream()
                  .map(TechMachinePart::getInitialSerialNumber)
                  .distinct()
                  .collect(Collectors.toList());
               Map<String, List<TechMachinePart>> machinePartMap = this.machinePartService
                  .list(
                     Wrappers.lambdaQuery(TechMachinePart.class)
                        .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        .eq(TechMachinePart::getMonomerId, monomerId)
                        .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                        .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                        .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_DISASSEMBLY.getType())
                        .in(TechMachinePart::getInitialSerialNumber, initialSerialNumbers)
                        .notIn(TechMachinePart::getSerialNumber, initialSerialNumbers)
                  )
                  .stream()
                  .collect(Collectors.groupingBy(TechMachinePart::getInitialSerialNumber));
               Map<String, List<TechMachinePart>> wingWebPlateListMap = wingWebPlateList.stream()
                  .collect(Collectors.groupingBy(e -> e.getSourcePartEnum() + "#" + e.getInitialSerialNumber()));
               wingWebPlateListMap.forEach(
                  (initialSerialNumberAndSourcePartEnum, partList) -> {
                     Integer sourcePartEnum = Integer.valueOf(initialSerialNumberAndSourcePartEnum.split("#")[0]);
                     String initialSerialNumber = initialSerialNumberAndSourcePartEnum.split("#")[1];
                     if (SourcePartEnum.COMPONENT_DISASSEMBLY.getType().equals(sourcePartEnum)) {
                        List<TechMachinePart> machinePartList = partList.stream()
                           .filter(e -> !e.getSerialNumber().equals(initialSerialNumber) && e.getSourcePartEnum().equals(sourcePartEnum))
                           .collect(Collectors.toList());
                        if (CollectionUtils.isEmpty(machinePartList)) {
                           List<TechMachinePart> techMachineParts = machinePartMap.get(initialSerialNumber);
                           if (CollectionUtils.isNotEmpty(techMachineParts)) {
                              List<String> serialNumbers = techMachineParts.stream()
                                 .map(TechMachinePart::getSerialNumber)
                                 .distinct()
                                 .collect(Collectors.toList());
                              if (serialNumbers.size() == 1) {
                                 machineParts.addAll(techMachineParts);
                                 originalFilenameList.add(serialNumbers.get(0) + ".dxf");
                              }
                           }
                        } else {
                           machinePartList.forEach(e -> e.setBoolItsOwnDrawing(Boolean.TRUE));
                           this.machinePartService.updateBatchById(machinePartList);
                        }
                     }
                  }
               );
            }
         }

         List<TechMachinePart> componentCombinationPartList = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                  .eq(TechMachinePart::getMonomerId, monomerId)
                  .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechMachinePart::getAreaId, areaId)
                  .eq(TechMachinePart::getBoolItsOwnDrawing, Boolean.FALSE)
                  .eq(TechMachinePart::getSourcePartEnum, SourcePartEnum.COMPONENT_COMBINATION.getType())
                  .eq(TechMachinePart::getInitialSerialNumber, serialNumber)
            );
         if (CollectionUtils.isNotEmpty(componentCombinationPartList)) {
            machineParts.addAll(componentCombinationPartList);

            for (String componentCombinationPart : componentCombinationPartList.stream()
               .map(TechMachinePart::getSerialNumber)
               .distinct()
               .collect(Collectors.toList())) {
               originalFilenameList.add(componentCombinationPart + ".dxf");
            }
         }

         TechDrawing drawing = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(TechDrawing.class)
                  .eq(TechDrawing::getProjectId, projectId)
                  .eq(TechDrawing::getMonomerId, monomerId)
                  .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                  .isNull(TechDrawing::getProductType)
                  .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                  .eq(TechDrawing::getSerialNumber, serialNumber)
            );
         Preconditions.checkArgument(drawing != null, "修改失败原图纸不存在");
         String absolutePath = this.configProperties.getFilePath() + drawing.getFilePath();
         File file = null;
         List<DXFUploadFailDTO> dxfUploadFailDTOList = new ArrayList<>();

         try {
            file = new File(absolutePath + originalFilename);
            multipartFile.transferTo(file);
            CorrectDXF.resolverDXFForImport(file);
         } catch (Exception e) {
            dxfUploadFailDTOList.add(new DXFUploadFailDTO(file == null ? "" : file.getName(), e.getMessage()));
         }

         if (CollectionUtils.isNotEmpty(dxfUploadFailDTOList)) {
            exportMistakeList(dxfUploadFailDTOList, response);
            return Boolean.FALSE;
         }

         for (String newOriginalFilename : originalFilenameList) {
            if (!newOriginalFilename.equals(originalFilename)) {
               try {
                  Files.copy(file.toPath(), Paths.get(absolutePath + newOriginalFilename), StandardCopyOption.COPY_ATTRIBUTES);
               } catch (IOException e) {
                  throw new RuntimeException(e);
               }
            }

            String newSerialNumber = newOriginalFilename.replaceAll("[.][^.]+$", "").replaceAll(" ", "");
            TechDrawing newDrawing = this.baseMapper
               .selectOne(
                  Wrappers.lambdaQuery(TechDrawing.class)
                     .eq(TechDrawing::getProjectId, projectId)
                     .eq(TechDrawing::getMonomerId, monomerId)
                     .eq(SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange), TechDrawing::getAreaId, areaId)
                     .isNull(TechDrawing::getProductType)
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
                     .eq(TechDrawing::getSerialNumber, newSerialNumber)
               );
            Preconditions.checkArgument(newDrawing != null, "修改失败原图纸不存在");
            String newAbsolutePath = this.configProperties.getFilePath() + newDrawing.getFilePath();
            String ossRelativePath = projectId + "/" + monomerId + "/" + newOriginalFilename;
            if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
               ossRelativePath = projectId + "/" + monomerId + "/" + areaId + "/" + newOriginalFilename;
            }

            String localAbsoluteFilePath = newAbsolutePath + newOriginalFilename;
            OSS client = this.ossUtils.openClient();
            String dxfUrl = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
            this.setMachinePartPath(project, monomerId, newSerialNumber, dxfUrl, ossRelativePath, drawingMatchRange, areaId);
            String drawingUrl = this.transformationDxf(newDrawing.getFilePath(), newDrawing.getFileName(), newDrawing.getSerialNumber(), 1);
            if (newDrawing != null) {
               newDrawing.setCreateUserId(UserUtil.getCurrentUserId());
               this.baseMapper.updateById(drawing);
               newDrawing.setPicturePath(drawingUrl);
               this.baseMapper.updateById(drawing);
               this.updateRadius(newDrawing);
               drawingIds.add(newDrawing.getId());
            } else {
               TechDrawing drawingNew = new TechDrawing();
               drawingNew.setProjectId(projectId);
               drawingNew.setMonomerId(monomerId);
               drawingNew.setSerialNumber(newSerialNumber);
               drawingNew.setProjectType(1);
               drawingNew.setDataType(dataType);
               drawingNew.setProductType(1);
               drawingNew.setFileName(newOriginalFilename);
               drawingNew.setFilePath(ossRelativePath);
               drawingNew.setCloudPath(dxfUrl);
               drawingNew.setCreateUserId(UserUtil.getCurrentUserId());
               drawing.setPicturePath(drawingUrl);
               if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                  drawing.setAreaId(areaId);
               }

               this.baseMapper.insert(drawingNew);
            }
         }
      }

      this.saveLog(DataOperationTypeEnum.DATA_IMPORT.getType(), dataType, productType, project, monomer, drawingIds);
      return Boolean.TRUE;
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
