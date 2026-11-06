package com.hzchum.scim.plan.core.service.impl;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.ProjectSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDrawingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureFreezeOrNotDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureImportV2DTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSimpleSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProductDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectOverviewStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectSchedulingStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.EnclosureCategoryMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.mapper.TechEnclosureMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

@Service
public class TechEnclosureServiceImpl extends ServiceImpl<TechEnclosureMapper, TechEnclosure> implements TechEnclosureService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private TechEnclosureChangeService enclosureChangeService;

   @Override
   public void downloadEnclosureTemplate(Integer category) {
      String fileName = EnclosureCategoryEnum.getFileNameByCategory(category);
      String name = EnclosureCategoryEnum.getNameByCategory(category);
      String resourcePath = "template/" + fileName + ".xlsx";
      String exportFileName = name + "清单模版.xlsx";
      File file = null;
      ClassPathResource pathResource = new ClassPathResource(resourcePath);

      try (InputStream fis = pathResource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(fis, file);
      } catch (IOException e) {
         this.log.error("文件下载异常，请联系管理员, {}", e);
      }

      FileUtil.downloadFile(file, exportFileName);
   }

   @Override
   public void downloadInventoryEnclosureTemplate() {
      String resourcePath = "template/EnclosureInventoryTemplate.xlsx";
      String exportFileName = "围护清单模版.xlsx";
      File file = null;
      ClassPathResource pathResource = new ClassPathResource(resourcePath);

      try (InputStream fis = pathResource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(fis, file);
      } catch (IOException e) {
         this.log.error("文件下载异常，请联系管理员, {}", e);
      }

      FileUtil.downloadFile(file, exportFileName);
   }

   @Override
   public List<EnclosureResponseDTO> listByCondition(EnclosureListQueryDTOParam queryDTOParam) {
      return this.baseMapper.selectListByConditions(queryDTOParam);
   }

   @Override
   public List<String> listPlateTypeList(Long projectId, Integer category) {
      Preconditions.checkArgument(projectId != null, "项目id不能为空!");
      List<TechEnclosure> enclosureList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getProjectId, projectId).eq(category != null, TechEnclosure::getCategory, category)
         );
      return enclosureList.isEmpty() ? new ArrayList<>() : enclosureList.stream().map(TechEnclosure::getPlate).collect(Collectors.toList());
   }

   @Override
   public EnclosureSimpleSumDTO getSumEnclosure(EnclosureListQueryDTOParam param) {
      return this.baseMapper.selectSumLengthQuantity(param);
   }

   @Override
   public EnclosureSimpleSumDTO getSumEnclosure2(EnclosureListQueryDTOParam param) {
      return this.baseMapper.selectSumLengthQuantity2(param);
   }

   @Override
   public void exportEnclosureList(EnclosureListQueryDTOParam queryDTOParam, HttpServletResponse response) {
      Preconditions.checkArgument(queryDTOParam.getEnclosurePlanId() != null, "区域ID不能为空");
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(queryDTOParam.getEnclosurePlanId());
      Preconditions.checkArgument(enclosurePlan != null, "区域不存在");
      ProjectInfo projectInfo = this.projectService.getSimpleById(enclosurePlan.getProjectId());
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      List<EnclosureResponseDTO> responseDTOS = this.baseMapper.selectListByConditions(queryDTOParam);
      String categoryName = EnclosureCategoryEnum.getNameByCategory(queryDTOParam.getCategory());
      String title = projectInfo.getName() + " - " + categoryName + " - " + enclosurePlan.getName();
      String sheetName = categoryName + "清单";
      String fileName = categoryName + "清单.xlsx";
      int scale = 2;
      int orderNo = 1;
      List<EnclosureImportDTO> enclosureImportDTOList = new ArrayList<>();

      for (EnclosureResponseDTO responseDTO : responseDTOS) {
         EnclosureImportDTO copy = BeanUtil.copy(responseDTO, EnclosureImportDTO.class);
         copy.setOrderNo(orderNo++);
         copy.setThickness(responseDTO.getThickness() != null ? responseDTO.getThickness().setScale(scale, RoundingMode.HALF_UP) : null);
         if (EnclosureCategoryEnum.SANDWICH_BOARD.getCategory().equals(queryDTOParam.getCategory())) {
            copy.setTotalWeight(null);
         } else {
            copy.setTotalWeight(responseDTO.getTotalWeight() != null ? responseDTO.getTotalWeight().setScale(scale, RoundingMode.HALF_UP) : null);
         }

         copy.setWidth(responseDTO.getWidth() != null ? responseDTO.getWidth().setScale(scale, RoundingMode.HALF_UP) : null);
         copy.setUnfoldedWidth(responseDTO.getUnfoldedWidth() != null ? responseDTO.getUnfoldedWidth().setScale(scale, RoundingMode.HALF_UP) : null);
         copy.setLength(responseDTO.getLength().setScale(scale, RoundingMode.HALF_UP));
         copy.setTotalLength(responseDTO.getTotalLength().setScale(3, RoundingMode.HALF_UP).toString());
         copy.setTotalArea(responseDTO.getTotalArea().setScale(3, RoundingMode.HALF_UP).toString());
         copy.setBendTimes(responseDTO.getBendTimes() == null ? 0 : responseDTO.getBendTimes());
         copy.setPlate(StringUtils.isBlank(responseDTO.getPlate()) ? "/" : responseDTO.getPlate());
         copy.setRemark(StringUtils.isBlank(responseDTO.getRemark()) ? "/" : responseDTO.getRemark());
         enclosureImportDTOList.add(copy);
      }

      PoiUtils.exportExcel(enclosureImportDTOList, title, sheetName, EnclosureImportDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public void exportEnclosureList2(EnclosureListQueryDTOParam queryDTOParam, HttpServletResponse response) {
      Preconditions.checkArgument(queryDTOParam.getAreaId() != null, "区域ID不能为空");
      PlanArea area = this.areaService.getById(queryDTOParam.getAreaId());
      Preconditions.checkArgument(area != null, "区域不存在");
      ProjectInfo projectInfo = this.projectService.getSimpleById(area.getProjectId());
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      List<EnclosureResponseDTO> responseDTOS = this.baseMapper.selectListByConditions(queryDTOParam);
      String title = projectInfo.getName() + " - 围护 - " + area.getName();
      String sheetName = "围护清单";
      String fileName = area.getName() + "-围护清单清单.xlsx";
      int scale = 2;
      int orderNo = 1;
      List<EnclosureImportV2DTO> enclosureImportDTOList = new ArrayList<>();

      for (EnclosureResponseDTO responseDTO : responseDTOS) {
         EnclosureImportV2DTO copy = BeanUtil.copy(responseDTO, EnclosureImportV2DTO.class);
         copy.setOrderNo(orderNo++);
         copy.setThickness(responseDTO.getThickness() != null ? responseDTO.getThickness().setScale(scale, RoundingMode.HALF_UP) : null);
         copy.setTotalWeight(responseDTO.getTotalWeight() != null ? responseDTO.getTotalWeight().setScale(scale, RoundingMode.HALF_UP) : null);
         copy.setWidth(responseDTO.getWidth() != null ? responseDTO.getWidth().setScale(scale, RoundingMode.HALF_UP) : null);
         copy.setUnfoldedWidth(responseDTO.getUnfoldedWidth() != null ? responseDTO.getUnfoldedWidth().setScale(scale, RoundingMode.HALF_UP) : null);
         copy.setLength(responseDTO.getLength().setScale(scale, RoundingMode.HALF_UP));
         copy.setTotalLength(responseDTO.getTotalLength().setScale(3, RoundingMode.HALF_UP).toString());
         copy.setTotalArea(responseDTO.getTotalArea().setScale(3, RoundingMode.HALF_UP));
         copy.setBendTimes(responseDTO.getBendTimes() == null ? 0 : responseDTO.getBendTimes());
         copy.setPlate(StringUtils.isBlank(responseDTO.getPlate()) ? "/" : responseDTO.getPlate());
         copy.setAccountingVolume(responseDTO.getAccountingVolume().setScale(3, RoundingMode.HALF_UP));
         copy.setUnit(StringUtils.isBlank(responseDTO.getUnit()) ? "/" : responseDTO.getPlating());
         copy.setRemark(StringUtils.isBlank(responseDTO.getRemark()) ? "/" : responseDTO.getRemark());
         enclosureImportDTOList.add(copy);
      }

      PoiUtils.exportExcel(enclosureImportDTOList, title, sheetName, EnclosureImportV2DTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public ListVO<EnclosureSumDTO> listSum(Long projectId, Long monomerId, Integer category) {
      Preconditions.checkArgument(projectId != null || monomerId != null, "项目id和单体id不能全为空!");
      Preconditions.checkArgument(EnclosureCategoryEnum.isExist(category), "围护类型有误!");
      List<EnclosureSumDTO> enclosureSumDTOList = new ArrayList<>();
      if (category.equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())) {
         enclosureSumDTOList = this.baseMapper.selectSumFlangPiece(projectId, monomerId, category);
      }

      if (category.equals(EnclosureCategoryEnum.SANDWICH_BOARD.getCategory())) {
         enclosureSumDTOList = this.baseMapper.selectSumSandwich(projectId, monomerId, category);
      }

      if (category.equals(EnclosureCategoryEnum.TRUSS_FLOOR_BEARING_PLATE.getCategory())) {
         enclosureSumDTOList = this.baseMapper.selectSumTrussFloorPlate(projectId, monomerId, category);
      }

      if (category.equals(EnclosureCategoryEnum.PRESSURE_COLOR_PLATE.getCategory())
         || category.equals(EnclosureCategoryEnum.PRESSURE_FLOOR_BEARING_PLATE.getCategory())) {
         enclosureSumDTOList = this.baseMapper.selectSumPressurePlate(projectId, monomerId, category);
      }

      return new ListVO<>(enclosureSumDTOList);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Long importEnclosureAttachment(MultipartFile file) {
      Attachment attachment = this.attachmentService.uploadFile(file, AttachmentTypeEnum.PLAN.getType());
      attachment.setCreateUserId(UserUtil.getCurrentUserId());
      attachment.setCreateUserName(UserUtil.getCurrentName());
      this.attachmentService.updateById(attachment);
      return attachment.getId();
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveEnclosureDrawing(EnclosureDrawingDTOParam drawingDTOParam) {
      TechEnclosure enclosure = this.baseMapper.selectById(drawingDTOParam.getId());
      Preconditions.checkArgument(enclosure != null, "折边件不存在");
      this.projectService.checkProjectStatus(enclosure.getProjectId());
      String fileName = drawingDTOParam.getFileName();
      String img = drawingDTOParam.getImg();
      fileName = this.transformLowercaseSuffix(fileName);
      if (enclosure.getAttachmentId() != null) {
         Attachment attachment = this.attachmentService
            .getOne((Wrapper<Attachment>)new LambdaQueryWrapper<Attachment>().eq(Attachment::getId, enclosure.getAttachmentId()));
         if (attachment != null) {
            this.attachmentService.deleteFile(attachment.getId());
         }
      }

      String filePath = AttachmentTypeEnum.PLAN.getName()
         + File.separator
         + EnclosureCategoryEnum.FLANG_PIECE.getFileName()
         + File.separator
         + enclosure.getProjectId()
         + File.separator;
      String absolutePath = this.configProperties.getFilePath() + filePath;

      try {
         FileUtil.mkdirs(absolutePath);
         File file = new File(absolutePath + fileName);
         img = img.split(",")[1];
         byte[] decoders = new BASE64Decoder().decodeBuffer(img);

         for (int i = 0; i < decoders.length; i++) {
            if (decoders[i] < 0) {
               decoders[i] = (byte)(decoders[i] + 256);
            }
         }

         OutputStream out = new FileOutputStream(file);
         out.write(decoders);
         out.flush();
         out.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

      Attachment attachment = Attachment.builder()
         .name(fileName)
         .type(AttachmentTypeEnum.PLAN.getType())
         .relativePath(filePath + fileName)
         .mediaType("image/*")
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .build();
      this.attachmentService.save(attachment);
      enclosure.setAttachmentId(attachment.getId());
      this.baseMapper.updateById(enclosure);
      return true;
   }

   private String transformLowercaseSuffix(String fileName) {
      String[] split = StringUtils.split(fileName, ".");
      Preconditions.checkArgument(split != null && split.length >= 2, "文件名称格式不正确");
      split[split.length - 1] = split[split.length - 1].toLowerCase();
      return StringUtils.join(split, ".");
   }

   @Override
   public void downEnclosureAttachment(Long attachmentId) {
      Attachment attachment = this.attachmentService.getOne((Wrapper<Attachment>)new LambdaQueryWrapper<Attachment>().eq(Attachment::getId, attachmentId));
      Preconditions.checkArgument(attachment != null, "折边件附件不存在!");
      String filePath = this.configProperties.getFilePath() + attachment.getRelativePath();
      FileUtil.downloadFile(filePath);
   }

   @Override
   public List<TechEnclosure> listByBusinessId(Long businessId) {
      return this.baseMapper.selectList((Wrapper<TechEnclosure>)Wrappers.<TechEnclosure>lambdaQuery().eq(TechEnclosure::getBusinessId, businessId));
   }

   @Override
   public ProductMeteDTO sumMeteByProjectIdOrMonomerId(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.sumMete(projectId, monomerId, areaId);
   }

   @Override
   public List<EnclosureCategoryMeteDTO> sumCategoryMete(Long projectId) {
      return this.baseMapper.sumCategoryMete(projectId);
   }

   @Override
   public List<EnclosureCategoryMeteDTO> sumCategoryByAreaId(Long areaId) {
      return this.baseMapper.sumCategoryByAreaId(areaId);
   }

   @Override
   public List<ProductMeteGroupDTO> sumMeteGroup(Long projectId, Long monomerId, Integer category, Integer permissionCheck, Long userId) {
      return monomerId == null
         ? this.baseMapper.sumMeteGroupByMonomerId(projectId, category, permissionCheck, userId)
         : this.baseMapper.sumMeteGroupByAreaId(monomerId, category, permissionCheck, userId);
   }

   @Override
   public TechEnclosure getByIdIgnoreDelete(Long id) {
      Preconditions.checkArgument(id != null, "围护id为空!");
      return this.baseMapper.selectByIdIgnoreDelete(id);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean importEnclosureAttachmentDrawing(MultipartFile multipartFile, Long id) {
      TechEnclosure enclosure = this.baseMapper.selectById(id);
      Preconditions.checkArgument(enclosure != null, "折边件不存在");
      this.projectService.checkProjectStatus(enclosure.getProjectId());
      String suffix = FileUtil.getFileExtension(Objects.requireNonNull(multipartFile.getOriginalFilename()));
      Preconditions.checkArgument(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("jpeg"), "导入失败，上传文件格式不支持");
      String filePath = AttachmentTypeEnum.PLAN.getName()
         + File.separator
         + EnclosureCategoryEnum.FLANG_PIECE.getFileName()
         + File.separator
         + enclosure.getProjectId()
         + File.separator;
      String absolutePath = this.configProperties.getFilePath() + filePath;

      try {
         FileUtil.mkdirs(absolutePath);
         String fileName = enclosure.getSerialNumber() + "." + suffix;
         File file = new File(new File(absolutePath).getAbsolutePath() + File.separator + fileName);
         AttachmentDTO attachmentDTO = this.attachmentService.getById(enclosure.getAttachmentId());
         if (attachmentDTO != null) {
            this.attachmentService.deleteFile(attachmentDTO.getId());
         }

         Attachment attachment = Attachment.builder()
            .name(fileName)
            .type(AttachmentTypeEnum.PLAN.getType())
            .relativePath(filePath + fileName)
            .mediaType("image/*")
            .createUserId(UserUtil.getCurrentUserId())
            .createUserName(UserUtil.getCurrentName())
            .build();
         this.attachmentService.save(attachment);
         enclosure.setAttachmentId(attachment.getId());
         this.baseMapper.updateById(enclosure);
         multipartFile.transferTo(file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean importEnclosureAttachmentZip(MultipartFile multipartFile, Long planId) {
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(planId);
      Preconditions.checkArgument(enclosurePlan != null, "导入失败，围护计划不存在");
      this.projectService.checkProjectStatus(enclosurePlan.getProjectId());
      String originalFilename = multipartFile.getOriginalFilename();
      Preconditions.checkArgument(StringUtils.isNotBlank(originalFilename), "文件名称为空!");
      String suffix = FileUtil.getFileExtension(originalFilename);
      Preconditions.checkArgument(
         suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("zip"),
         "导入失败，上传文件格式不支持"
      );
      String filePath = AttachmentTypeEnum.PLAN.getName()
         + File.separator
         + EnclosureCategoryEnum.FLANG_PIECE.getFileName()
         + File.separator
         + enclosurePlan.getProjectId()
         + File.separator;
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      File file = new File(absolutePath + originalFilename);

      try {
         if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("jpeg")) {
            String serialNumber = StringUtils.split(originalFilename, ".")[0];
            this.setAttachment(enclosurePlan.getId(), serialNumber, originalFilename, filePath);
            multipartFile.transferTo(file);
         }

         if (suffix.equalsIgnoreCase("zip")) {
            multipartFile.transferTo(file);

            for (String name : FileUtil.unzipFile(file, absolutePath)) {
               String fileSuffix = FileUtil.getFileExtension(name);
               Preconditions.checkArgument(
                  fileSuffix.equalsIgnoreCase("jpg") || fileSuffix.equalsIgnoreCase("png") || fileSuffix.equalsIgnoreCase("jpeg"), "导入失败，上传文件格式不支持"
               );
               String serialNumber = name.replaceAll("[.][^.]+$", "");
               this.setAttachment(enclosurePlan.getId(), serialNumber, name, filePath);
            }

            Preconditions.checkArgument(file.delete(), "zip文件删除失败");
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         System.gc();
      }

      return true;
   }

   private void setAttachment(Long enclosurePlanId, String serialNumber, String name, String filePath) {
      TechEnclosure techEnclosure = this.baseMapper
         .selectOne(
            (Wrapper<TechEnclosure>)((new LambdaQueryWrapper<TechEnclosure>()
                     .eq(TechEnclosure::getCategory, EnclosureCategoryEnum.FLANG_PIECE.getCategory()))
                  .eq(TechEnclosure::getEnclosurePlanId, enclosurePlanId))
               .eq(TechEnclosure::getSerialNumber, serialNumber)
         );
      Preconditions.checkArgument(techEnclosure != null, "图纸编号：" + serialNumber + "对应的折边件不存在");
      AttachmentDTO attachmentDTO = this.attachmentService.getById(techEnclosure.getAttachmentId());
      if (attachmentDTO != null && !attachmentDTO.getRelativePath().equals(filePath + name)) {
         this.attachmentService.deleteFile(attachmentDTO.getId());
      }

      Attachment attachment = Attachment.builder()
         .name(name)
         .type(AttachmentTypeEnum.PLAN.getType())
         .relativePath(filePath + name)
         .mediaType("image/*")
         .createUserId(UserUtil.getCurrentUserId())
         .createUserName(UserUtil.getCurrentName())
         .build();
      this.attachmentService.save(attachment);
      techEnclosure.setAttachmentId(attachment.getId());
      this.baseMapper.updateById(techEnclosure);
   }

   @Override
   public List<EnclosureProjectSchedulingStateDTO> listByType(Integer year, String name) {
      return this.baseMapper.listByType(year, name);
   }

   @Override
   public List<EnclosureProjectOverviewStateDTO> getProjectOverview(List<Long> projectIds) {
      return this.baseMapper.getProjectOverview(projectIds);
   }

   @Override
   public List<EnclosureProductDetailDTO> getproductDetaile(List<Long> planIds, Integer status, Integer category) {
      return this.baseMapper.getproductDetaile(planIds, status, category);
   }

   @Override
   public List<EnclosureProductDetailDTO> getproductDetaileV2(List<Long> areaIds, Integer status, Long dictionaryId) {
      return this.baseMapper.getproductDetaileV2(areaIds, status, dictionaryId);
   }

   @Override
   public List<EnclosureFreezeOrNotDTO> findFreezeStatusByOrder(List<Long> orderIds) {
      return this.baseMapper.findFreezeStatusByOrder(orderIds);
   }

   @Override
   public List<ProjectSchedulingTreeDO> getSchedulingTree(Integer year, String name) {
      return this.baseMapper.getSchedulingTree(year, name);
   }

   @Override
   public List<ArtifactSimpleVO> getEnclosure(String serialNumber, Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getEnclosure(serialNumber, projectId, monomerId, areaId);
   }
}
