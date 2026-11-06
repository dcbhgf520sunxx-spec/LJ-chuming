package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingCloudcutJobService;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingCloudcutResultService;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutSendEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutJob;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CreateDto;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CutTaskRequestData;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.NestResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutResultSendVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutResultVO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.client.CutTaskClient;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingCloudcutResultMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MesBuildingCloudcutResultServiceImpl
   extends ServiceImpl<MesBuildingCloudcutResultMapper, MesBuildingCloudcutResult>
   implements MesBuildingCloudcutResultService {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingCloudcutResultServiceImpl.class);
   @Value("${chum.config.url}")
   private String ip;
   @Value("${chum.config.filePath}")
   private String filePath;
   @Resource
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Resource
   private CutTaskClient cutTaskClient;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Resource
   private MesBuildingCloudcutJobService mesBuildingCloudcutJobService;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;

   @Override
   public PageVO<MesBuildingCloudcutResultVO> pageMesBuildingCloudcutResult(MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO) {
      PageHelper.startPage(mesBuildingCloudcutResultDTO.getPageNumber(), mesBuildingCloudcutResultDTO.getPageSize());
      List<MesBuildingCloudcutResultVO> mesBuildingCloudcutResultVOList = this.baseMapper.pageMesBuildingCloudcutResult(mesBuildingCloudcutResultDTO);
      return new PageVO<>(mesBuildingCloudcutResultVOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String saveMesBuildingCloudcutResult(MultipartFile multipartFile, Long cloudcutId, Integer partType) {
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument(suffix.equalsIgnoreCase("zip"), "导入失败，导入文件格式只支持zip文件!");

      try {
         String filePathNew = this.filePath + "cloudcut" + File.separator + cloudcutId + File.separator;
         List<String> fileNameList = this.createFileInRelativeFolder(filePathNew, multipartFile, originalFilename);
         List<MesBuildingCloudcutResult> mesBuildingCloudcutResultList = new ArrayList<>();

         for (String fileName : fileNameList) {
            MesBuildingCloudcutResult mesBuildingCloudcutResult = new MesBuildingCloudcutResult();
            List<MesBuildingCloudcutResult> mesBuildingCloudcutResultOld = this.list(
               (Wrapper<MesBuildingCloudcutResult>)new LambdaQueryWrapper<MesBuildingCloudcutResult>().eq(MesBuildingCloudcutResult::getFilePath, filePathNew + fileName)
            );
            if (CollectionUtils.isNotEmpty(mesBuildingCloudcutResultOld)) {
               this.removeByIds(mesBuildingCloudcutResultOld);
            } else {
               mesBuildingCloudcutResult.setPartType(partType);
               mesBuildingCloudcutResult.setImportUserId(UserUtil.getCurrentUserId());
               mesBuildingCloudcutResult.setImportTime(LocalDateTime.now());
               mesBuildingCloudcutResult.setFileName(fileName);
               mesBuildingCloudcutResult.setFilePath(filePathNew + fileName);
               mesBuildingCloudcutResult.setCutStatus(CutStatusEnum.NOT_CUT.getCode());
               mesBuildingCloudcutResult.setCloudcutId(cloudcutId);
               mesBuildingCloudcutResult.setCutSendStatus(CutSendEnum.NOT_DISPATCHED.getCode());
               mesBuildingCloudcutResultList.add(mesBuildingCloudcutResult);
            }
         }

         this.saveBatch(mesBuildingCloudcutResultList);
         return "导入成功";
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public MesBuildingCloudcutResultSendVO checkFile(MultipartFile multipartFile, Long cloudcutId) {
      String repeatFileName = "";
      String sendFileName = "";
      MesBuildingCloudcutResultSendVO mesBuildingCloudcutResultSendVO = new MesBuildingCloudcutResultSendVO();
      String originalFilename = multipartFile.getOriginalFilename();
      List<MesBuildingCloudcutResult> mesBuildingCloudcutResultList = this.list(
         (Wrapper<MesBuildingCloudcutResult>)new LambdaQueryWrapper<MesBuildingCloudcutResult>().eq(MesBuildingCloudcutResult::getCloudcutId, cloudcutId)
      );
      List<MesBuildingCloudcutResult> mesBuildingCloudcutResultSendList = this.list(
         (Wrapper<MesBuildingCloudcutResult>)(new LambdaQueryWrapper<MesBuildingCloudcutResult>().eq(MesBuildingCloudcutResult::getCloudcutId, cloudcutId))
            .eq(MesBuildingCloudcutResult::getCutSendStatus, CutSendEnum.DISPATCHED.getCode())
      );

      try {
         String filePathNew = this.filePath + "cloudcut_temp" + File.separator + cloudcutId + File.separator;
         List<String> fileNameList = this.createFileInRelativeFolder(filePathNew, multipartFile, originalFilename);
         repeatFileName = this.checkFileNames(mesBuildingCloudcutResultList, fileNameList);
         sendFileName = this.checkFileNamesSend(mesBuildingCloudcutResultSendList, fileNameList);
         mesBuildingCloudcutResultSendVO.setRepeatFileName(repeatFileName);
         mesBuildingCloudcutResultSendVO.setSendFileName(sendFileName);
         mesBuildingCloudcutResultSendVO.setSendResult(Boolean.FALSE);
         if (StringUtils.isNotBlank(sendFileName)) {
            mesBuildingCloudcutResultSendVO.setSendResult(Boolean.TRUE);
         }

         return mesBuildingCloudcutResultSendVO;
      } catch (IOException e) {
         throw new RuntimeException(e);
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

   private String checkFileNames(List<MesBuildingCloudcutResult> list, List<String> fileNameList) {
      StringBuilder result = new StringBuilder();
      List<String> fileNameListOld = list.stream().map(MesBuildingCloudcutResult::getFileName).collect(Collectors.toList());
      result.append("文件名 ");
      Boolean flag = Boolean.FALSE;

      for (String fileName : fileNameList) {
         if (fileNameListOld.contains(fileName)) {
            flag = Boolean.TRUE;
            result.append(fileName).append(" ");
         }
      }

      if (!flag) {
         return "";
      }

      result.append(" 在列表中存在");
      return result.toString();
   }

   private String checkFileNamesSend(List<MesBuildingCloudcutResult> list, List<String> fileNameList) {
      StringBuilder result = new StringBuilder();
      List<String> fileNameListOld = list.stream().map(MesBuildingCloudcutResult::getFileName).collect(Collectors.toList());
      result.append("文件名 ");
      Boolean flag = Boolean.FALSE;

      for (String fileName : fileNameList) {
         if (fileNameListOld.contains(fileName)) {
            flag = Boolean.TRUE;
            result.append(fileName).append(" ");
         }
      }

      if (!flag) {
         return "";
      }

      result.append(" 在列表中已下发");
      return result.toString();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Integer updateMesBuildingCloudcutResult(MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO) {
      MesBuildingCloudcutResult mesBuildingCloudcutResult = new MesBuildingCloudcutResult();
      BeanUtil.copy(mesBuildingCloudcutResultDTO, mesBuildingCloudcutResult);
      return this.baseMapper.updateById(mesBuildingCloudcutResult);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String updateMesBuildingCloudcutResultStatus(List<MesBuildingCloudcutResultDTO> mesBuildingCloudcutResultDTOList) {
      for (MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO : mesBuildingCloudcutResultDTOList) {
         Preconditions.checkArgument(mesBuildingCloudcutResultDTO.getId() != null, "id不能为空");
         Preconditions.checkArgument(mesBuildingCloudcutResultDTO.getCutStatus() != null, "状态不能为空");
         if (mesBuildingCloudcutResultDTO.getId() != null) {
            MesBuildingCloudcutResult mesBuildingCloudcutResult = this.getById(mesBuildingCloudcutResultDTO.getId());
            mesBuildingCloudcutResult.setCutStatus(mesBuildingCloudcutResultDTO.getCutStatus());
            this.baseMapper.updateById(mesBuildingCloudcutResult);
         }
      }

      return "云切作业修改切割任务成功";
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean sendMesBuildingCloudcutResult(List<MesBuildingCloudcutResultDTO> mesBuildingCloudcutResultDTOList) {
      List<MesBuildingCloudcutResult> mesBuildingCloudcutResultList = new ArrayList<>();
      Long machineToolId = mesBuildingCloudcutResultDTOList.get(0).getMachineToolId();
      Long cloudcutId = mesBuildingCloudcutResultDTOList.get(0).getCloudcutId();
      MesBuildingCloudcutJob mesBuildingCloudcutJob = this.mesBuildingCloudcutJobService.getById(cloudcutId);
      Long workshopId = mesBuildingCloudcutJob.getWorkshopId();
      Long parentId = mesBuildingCloudcutJob.getParentId();
      MesBuildingCloudcutJob mesBuildingCloudcutJobParent = this.mesBuildingCloudcutJobService.getById(parentId);
      MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
      CutTaskRequestData cutTaskRequestData = new CutTaskRequestData();
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(machineToolId);
      cutTaskRequestData.setMid(mesBuildingMachinePartTeamDetail.getMID());
      cutTaskRequestData.setCode("-");
      cutTaskRequestData.setWorkshopLevelName(mesBuildingWorkshop.getShortName());
      cutTaskRequestData.setProjectLevelName(mesBuildingCloudcutJobParent.getCloudcutName());
      cutTaskRequestData.setGroupTaskLevelName(mesBuildingCloudcutJob.getCloudcutName());
      cutTaskRequestData.setWorkshopId(mesBuildingCloudcutJob.getWorkshopId().toString());
      cutTaskRequestData.setOrderType(2L);
      Integer deviceTypeFormat = mesBuildingMachinePartTeamDetail.getDeviceType();
      String deviceType = this.mesBuildingTaskNeedMachinePartSchedulingMapper.getDictionaryByNameAndSort("device_type", deviceTypeFormat);
      List<CreateDto> createDtos = new ArrayList<>();

      for (MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO : mesBuildingCloudcutResultDTOList) {
         CreateDto createDto = new CreateDto();
         String filePathNew = mesBuildingCloudcutResultDTO.getFilePath();

         try {
            byte[] fileBytes = this.readFileToByteArray(filePathNew);
            createDto.setFile(fileBytes);
         } catch (IOException e) {
            throw new RuntimeException(e);
         }

         createDto.setFileName(mesBuildingCloudcutJob.getId().toString() + "-" + mesBuildingCloudcutResultDTO.getFileName());
         createDto.setCuttingWay(deviceType);
         createDto.setIdNumber(mesBuildingCloudcutResultDTO.getId().toString());
         createDtos.add(createDto);
         MesBuildingCloudcutResult mesBuildingCloudcutResult = new MesBuildingCloudcutResult();
         BeanUtil.copy(mesBuildingCloudcutResultDTO, mesBuildingCloudcutResult);
         mesBuildingCloudcutResult.setCutSendTime(LocalDateTime.now());
         mesBuildingCloudcutResult.setCutSendUserId(UserUtil.getCurrentUserId());
         mesBuildingCloudcutResult.setCutSendStatus(CutSendEnum.DISPATCHED.getCode());
         mesBuildingCloudcutResultList.add(mesBuildingCloudcutResult);
      }

      cutTaskRequestData.setCreateDtos(createDtos);
      NestResultDTO nestResultDTO = this.cutTaskClient.insertCuttingOrder(cutTaskRequestData);
      log.info("套料下发调用物联接口返回结果：{}", nestResultDTO);
      if (nestResultDTO.getCode().equals("000000")) {
         return this.updateBatchById(mesBuildingCloudcutResultList);
      }

      log.info("物联接口调用异常：", nestResultDTO.getMsg());
      throw new RuntimeException("切割任务下发失败,调用物联接口异常: " + nestResultDTO.getMsg());
   }

   private byte[] readFileToByteArray(String filePathNew) throws IOException {
      Path path = Paths.get(filePathNew);
      long fileSize = Files.size(path);
      if (fileSize == 0L) {
         return new byte[0];
      }

      byte[] fileBytes = new byte[(int)fileSize];

      try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {
         int bytesRead = 0;
         int offset = 0;

         while (offset < fileBytes.length) {
            bytesRead = inputStream.read(fileBytes, offset, fileBytes.length - offset);
            if (bytesRead == -1) {
               break;
            }

            offset += bytesRead;
         }

         if (offset != fileBytes.length) {
            throw new IOException("文件读取不完整！");
         }
      }

      return fileBytes;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteMesBuildingCloudcutResult(List<Long> idList) {
      List<MesBuildingCloudcutResult> mesBuildingCloudcutResultList = this.list(
         (Wrapper<MesBuildingCloudcutResult>)(new LambdaQueryWrapper<MesBuildingCloudcutResult>().in(MesBuildingCloudcutResult::getId, idList))
            .eq(MesBuildingCloudcutResult::getCutSendStatus, CutSendEnum.DISPATCHED.getCode())
      );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingCloudcutResultList), "该排产单下已存在下发的作业单，无法删除!");
      return this.removeByIds(idList);
   }

   private List<String> unzipFile(File file, String targetPath) throws IOException {
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

   private String transformLowercaseSuffix(String fileName) {
      String[] split = StringUtils.split(fileName, ".");
      split[split.length - 1] = split[split.length - 1].toLowerCase();
      return StringUtils.join(split, ".");
   }

   public List<String> createFileInRelativeFolder(String folderPath, MultipartFile multipartFile, String fileName) throws IOException {
      File folder = new File(folderPath);
      fileName = generateUniqueFileName(fileName);
      if (!folder.exists()) {
         boolean dirsCreated = folder.mkdirs();
         if (dirsCreated) {
            log.info("文件夹创建成功: " + folder.getPath());
         } else {
            log.info("文件夹已经存在或创建失败: " + folder.getPath());
         }
      }

      File targetFile = new File(folder, fileName);
      multipartFile.transferTo(targetFile);
      return this.unzipFile(targetFile, folderPath);
   }

   public static String generateUniqueFileName(String originalFileName) {
      String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
      String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
      return originalFileName.replace(fileExtension, "_" + timestamp + fileExtension);
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
}
