package com.hzchum.scim.common.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.ImageUtil;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.mapper.AttachmentMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {
   @Resource
   private ConfigProperties configProperties;
   private static String PATH = "files" + File.separator;
   private static final int BUFFER_SIZE = 2048;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Attachment uploadFile(MultipartFile file, int fileType) {
      return this.uploadFile(file, fileType, null);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Attachment uploadFile(MultipartFile file, int fileType, String fileName) {
      String dirName = AttachmentTypeEnum.getNameByType(fileType) + File.separator;
      FileUtil.mkdirs(this.configProperties.getFilePath() + dirName);

      try {
         String sourceFileName = file.getOriginalFilename();
         if (StringUtils.isNotBlank(fileName)) {
            String postfix = '.' + FileUtil.getFileExtension(file.getOriginalFilename());
            if (fileName.toLowerCase().endsWith(postfix.toLowerCase())) {
               sourceFileName = fileName;
            } else {
               sourceFileName = fileName + postfix;
            }
         }

         sourceFileName = StringUtils.deleteWhitespace(sourceFileName);
         fileName = System.currentTimeMillis() + "_" + this.convertChineseToPinyin(sourceFileName);
         String relativePath = dirName + fileName;
         String path = this.configProperties.getFilePath() + relativePath;
         String thumbnailPath = null;
         if (FileUtil.isImage(file.getInputStream())) {
            ImageUtil.imgScale(file.getInputStream(), path, 1.0);
            Integer imageSize = 256;
            int lastLength = fileName.lastIndexOf(".");
            StringBuilder sb = new StringBuilder();
            String thumbnailName = sb.append(fileName, 0, lastLength).append("_").append(imageSize).append(fileName.substring(lastLength)).toString();
            thumbnailPath = dirName + thumbnailName;
            String thumbnailAllPath = this.configProperties.getFilePath() + thumbnailPath;
            ImageUtil.imgThumb(file.getInputStream(), thumbnailAllPath, imageSize, imageSize);
         } else {
            Files.copy(file.getInputStream(), new File(path).toPath(), StandardCopyOption.REPLACE_EXISTING);
         }

         Attachment build = Attachment.builder()
            .name(sourceFileName)
            .mediaType(file.getContentType())
            .type(fileType)
            .relativePath(relativePath)
            .thumbnailPath(thumbnailPath)
            .createUserId(UserUtil.getCurrentUserId())
            .createUserName(UserUtil.getCurrentName())
            .build();
         this.baseMapper.insert(build);
         return build;
      } catch (IOException e) {
         e.printStackTrace();
         this.log.error("上传附件失败：{}", e);
         return null;
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ListVO<Long> uploadFiles(MultipartFile[] files, int fileType) {
      Preconditions.checkArgument(Objects.nonNull(files) && files.length >= 1, "附件不能为空");
      List<Long> ids = new ArrayList<>();

      for (MultipartFile file : files) {
         ids.add(this.uploadFile(file, fileType).getId());
      }

      return new ListVO<>(ids);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateAttachment(Long id, String name) {
      Preconditions.checkArgument(StringUtils.isNotBlank(name), "附件的名字不能为空");
      Attachment attachment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(attachment != null, "附件不存在");
      Attachment build = Attachment.builder().id(id).name(name).build();
      return this.baseMapper.updateById(build) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean deleteFile(Long id) {
      Attachment attachment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(attachment != null, "附件不存在");
      String path = this.configProperties.getFilePath() + attachment.getRelativePath();
      this.baseMapper.deleteById(attachment.getId());
      return FileUtil.deleteFile(path);
   }

   @Override
   public boolean deleteIds(String ids) {
      if (StringUtils.isNotBlank(ids)) {
         Arrays.stream(StringUtils.split(ids, ",")).forEach(id -> this.deleteFile(Long.parseLong(id)));
      }

      return true;
   }

   @Override
   public void downloadFile(Long id, Integer fileType) {
      Attachment attachment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(attachment != null, "附件不存在");
      if (fileType != null) {
         Preconditions.checkArgument(attachment.getType().equals(fileType), "附件下载出错，无法下载该类型附件");
      }

      if (attachment.getType().equals(AttachmentTypeEnum.CRM_RECORD_ATT.getType())) {
         String path = this.configProperties.getFilePath() + attachment.getRelativePath();
         downloadFile(new File(path), attachment.getName());
      } else {
         String path = this.configProperties.getFilePath() + attachment.getRelativePath();
         FileUtil.downloadFile(path);
      }
   }

   public static void downloadFile(File file, String fileName) {
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      HttpServletResponse response = servletRequestAttributes.getResponse();

      try (
         InputStream inputStream = new FileInputStream(file);
         OutputStream outputStream = response.getOutputStream();
      ) {
         response.setContentType("apply/octet-stream;charset=UTF-8");
         response.setContentLengthLong(file.length());
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         byte[] bytes = new byte[1024];

         int length;
         while ((length = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
         }
      } catch (IOException var37) {
         throw new BusinessException(ResultCodeEnum.ERROR, "文件下载失败");
      }
   }

   @Override
   public List<AttachmentDTO> listByIds(String ids) {
      if (StringUtils.isBlank(ids)) {
         return Collections.emptyList();
      }

      String[] split = StringUtils.split(ids, ",");
      List<Long> idList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
      return this.listByIdList(idList);
   }

   @Override
   public List<AttachmentDTO> listByIdList(Collection<Long> idList) {
      return CollectionUtils.isEmpty(idList) ? Collections.emptyList() : this.baseMapper.selectBatchIds(idList).stream().map(attachment -> {
         AttachmentDTO attachmentDTO = BeanUtil.copy(attachment, AttachmentDTO.class);
         String[] nameArr = StringUtils.split(attachment.getName(), "_");
         if (nameArr.length > 1 && StringUtils.isNumeric(nameArr[0])) {
            List<String> list = Arrays.stream(nameArr).skip(1L).collect(Collectors.toList());
            attachmentDTO.setName(StringUtils.join(list, "_"));
         }

         attachmentDTO.setImageUrl(this.configProperties.getUrl() + PATH + attachment.getRelativePath());
         attachmentDTO.setTinyImageUrl(this.configProperties.getUrl() + PATH + attachment.getThumbnailPath());
         return attachmentDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public AttachmentDTO getById(Long id) {
      if (id == null) {
         return null;
      }

      Attachment attachment = this.baseMapper.selectById(id);
      if (attachment == null) {
         return null;
      }

      AttachmentDTO vo = BeanUtil.copy(attachment, AttachmentDTO.class);
      String[] nameArr = StringUtils.split(attachment.getName(), "_");
      if (nameArr.length > 1 && StringUtils.isNumeric(nameArr[0])) {
         List<String> list = Arrays.stream(nameArr).skip(1L).collect(Collectors.toList());
         vo.setName(StringUtils.join(list, "_"));
      }

      vo.setImageUrl(this.configProperties.getUrl() + PATH + attachment.getRelativePath());
      vo.setTinyImageUrl(this.configProperties.getUrl() + PATH + attachment.getThumbnailPath());
      return vo;
   }

   @Override
   public void replaceAttachment(String oldAttachmentIds, String newAttachmentIds) {
      if (!StringUtils.isBlank(oldAttachmentIds)) {
         List<Long> oldIdList = Arrays.stream(StringUtils.split(oldAttachmentIds, ",")).map(Long::parseLong).collect(Collectors.toList());
         if (StringUtils.isBlank(newAttachmentIds)) {
            oldIdList.forEach(this::deleteFile);
         } else {
            List<Long> newIdList = Arrays.stream(StringUtils.split(newAttachmentIds, ",")).map(Long::parseLong).collect(Collectors.toList());
            oldIdList.forEach(oId -> {
               if (!newIdList.contains(oId)) {
                  this.deleteFile(oId);
               }
            });
         }
      }
   }

   @Override
   public void replaceAttachment(String oldAttachmentIds, List<Long> newAttachmentIdList) {
      if (!StringUtils.isBlank(oldAttachmentIds)) {
         List<Long> oldIdList = Arrays.stream(StringUtils.split(oldAttachmentIds, ",")).map(Long::parseLong).collect(Collectors.toList());
         if (CollectionUtils.isEmpty(newAttachmentIdList)) {
            oldIdList.forEach(this::deleteFile);
         } else {
            oldIdList.forEach(oId -> {
               if (!newAttachmentIdList.contains(oId)) {
                  this.deleteFile(oId);
               }
            });
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long toZip(String srcDir, int parentFileTyp, int fileTyp, String fileName, String sign) {
      ZipOutputStream zos = null;
      String outPath = AttachmentTypeEnum.getNameByType(parentFileTyp) + File.separator + AttachmentTypeEnum.getNameByType(fileTyp) + File.separator + sign;
      String parentPath = this.configProperties.getFilePath() + outPath + File.separator;
      FileUtil.mkdirs(parentPath);

      try {
         OutputStream out = new FileOutputStream(parentPath + fileName);
         zos = new ZipOutputStream(out);
         File sourceFile = new File(this.configProperties.getFilePath() + srcDir);
         compress(sourceFile, zos, sourceFile.getName(), true);
         Attachment build = Attachment.builder()
            .name(fileName)
            .mediaType(fileName.split("\\.")[1])
            .type(parentFileTyp)
            .relativePath(outPath + File.separator + fileName)
            .createUserId(UserUtil.getCurrentUserId())
            .createUserName(UserUtil.getCurrentName())
            .build();
         this.baseMapper.insert(build);
         return build.getId();
      } catch (Exception e) {
         e.printStackTrace();
         throw new BusinessException("压缩zip错误");
      } finally {
         if (zos != null) {
            try {
               zos.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

   @Override
   public List<AttachmentDTO> listByIdsAndType(String ids, Integer type) {
      if (StringUtils.isBlank(ids)) {
         return Collections.emptyList();
      }

      String[] split = StringUtils.split(ids, ",");
      List<Long> idList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
      return CollectionUtils.isEmpty(idList)
         ? Collections.emptyList()
         : this.baseMapper.selectBatchIds(idList).stream().filter(p -> p.getType() != null && p.getType().equals(type)).map(attachment -> {
            AttachmentDTO attachmentDTO = BeanUtil.copy(attachment, AttachmentDTO.class);
            String[] nameArr = StringUtils.split(attachment.getName(), "_");
            if (nameArr.length > 1 && StringUtils.isNumeric(nameArr[0])) {
               List<String> list = Arrays.stream(nameArr).skip(1L).collect(Collectors.toList());
               attachmentDTO.setName(StringUtils.join(list, "_"));
            }

            attachmentDTO.setImageUrl(this.configProperties.getUrl() + PATH + attachment.getRelativePath());
            attachmentDTO.setTinyImageUrl(this.configProperties.getUrl() + PATH + attachment.getThumbnailPath());
            return attachmentDTO;
         }).collect(Collectors.toList());
   }

   private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception {
      byte[] buf = new byte[2048];
      if (sourceFile.isFile()) {
         zos.putNextEntry(new ZipEntry(name));
         FileInputStream in = new FileInputStream(sourceFile);

         int len;
         while ((len = in.read(buf)) != -1) {
            zos.write(buf, 0, len);
         }

         zos.closeEntry();
         in.close();
      } else {
         File[] listFiles = sourceFile.listFiles();
         if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
               if (KeepDirStructure) {
                  compress(file, zos, name + "/" + file.getName(), true);
               } else {
                  compress(file, zos, file.getName(), false);
               }
            }
         } else if (KeepDirStructure) {
            zos.putNextEntry(new ZipEntry(name + "/"));
            zos.closeEntry();
         }
      }
   }

   private String convertChineseToPinyin(String source) {
      StringBuilder result = new StringBuilder();
      HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
      format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
      format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

      for (char c : source.toCharArray()) {
         if (this.isChinese(c)) {
            try {
               String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
               if (pinyinArray != null && pinyinArray.length > 0) {
                  result.append(pinyinArray[0]);
               }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
               e.printStackTrace();
            }
         } else {
            result.append(c);
         }
      }

      String fileName = result.toString();

      for (String illegal : Arrays.asList(
         "/", "\\", ":", "*", "?", "\"", "<", ">", "|", ";", "-", "&", "$", "#", "%", "{", "}", "[", "]", "(", ")", "~", "）", "（", "。", "‘’", "、"
      )) {
         fileName = fileName.replace(illegal, "_");
      }

      return fileName;
   }

   private boolean isChinese(char c) {
      return String.valueOf(c).matches("[一-龥]");
   }
}
