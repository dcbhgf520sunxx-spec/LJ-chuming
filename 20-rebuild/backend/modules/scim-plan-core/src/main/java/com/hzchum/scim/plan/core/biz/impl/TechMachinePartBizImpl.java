package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.aliyun.oss.OSS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.UUIDUtil;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechMachineHoleRadiusLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechMachinePartBiz;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.HoleRadiusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSpacerParallelDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.steel.PlateMatchDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.OssUtils;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTO;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechMachinePartBizImpl implements TechMachinePartBiz {
   @Autowired
   private TechMachinePartService machinePartService;
   @Resource
   private TechDrawingService techDrawingService;
   @Resource
   private ConfigProperties configProperties;
   @Value("${chum.config.url}")
   private String ip;
   @Resource
   private OssUtils ossUtils;
   @Resource
   private SysSteelClassificationBiz steelClassificationBiz;
   @Resource
   private TechMachineHoleRadiusLinkBiz techMachineHoleRadiusLinkBiz;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;

   @Override
   public PageVO<MachinePartResponseDTO> pageListByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MachinePartResponseDTO> machinePartResponseDTOS = this.machinePartService
         .listByCondition(projectId, monomerId, areaId, areaBatchId, status, type, serialNumber, specification, material, thick, steelPlateTypeEnum);
      return new PageVO<>(machinePartResponseDTOS);
   }

   @Override
   public void pageListByConditionExport(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum,
      HttpServletResponse response
   ) {
      List<MachinePartResponseExportDTO> machinePartResponseExportDTOList = this.machinePartService
         .listByConditionExport(projectId, monomerId, areaId, areaBatchId, status, type, serialNumber, specification, material, thick, steelPlateTypeEnum);
      String sheetName = "零件明细";
      String fileName = "零件明细.xlsx";
      String title = "零件明细";
      PoiUtils.exportExcel(machinePartResponseExportDTOList, title, sheetName, MachinePartResponseExportDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public MachinePartDTO getMachinePartInfoById(Long id) {
      TechMachinePart machinePart = this.machinePartService.getById(id);
      Preconditions.checkArgument(machinePart != null, "零件不存在!");
      MachinePartDTO machinePartDTO = BeanUtil.copy(machinePart, MachinePartDTO.class);
      ProjectInfo projectInfo = this.projectService.getSimpleById(machinePart.getProjectId());
      machinePartDTO.setProject(projectInfo);
      NameInfo monomer = this.monomerService.getSimpleById(machinePart.getMonomerId());
      machinePartDTO.setMonomer(monomer);
      NameInfo area = this.areaService.getSimpleById(machinePart.getAreaId());
      machinePartDTO.setArea(area);
      return machinePartDTO;
   }

   @Async
   @Override
   public void updateMachinePartSteel(Long steelId, Boolean isSelectNull, List<PlateMatchDTOParam> links) {
      this.machinePartService.listBySteelId(isSelectNull ? null : steelId).forEach(mp -> links.forEach(link -> {
         String keyword = link.getKeyword();
         Integer specIndex = link.getSpecIndex();
         if (mp.getSpecification() != null && mp.getSpecification().startsWith(keyword)) {
            char c = mp.getSpecification().charAt(keyword.length());
            if (Character.isDigit(c)) {
               String specification = mp.getSpecification().substring(keyword.length());
               String thickness = this.getThicknessBySpec(specIndex, specification);
               if (StringUtils.isNotBlank(thickness) && (mp.getSteelId() == null || mp.getSteelId() != null && !mp.getSteelSpec().equals(thickness))) {
                  mp.setSteelId(steelId);
                  mp.setSteelSpec(thickness);
                  this.machinePartService.updateById(mp);
               }
            }
         }
      }));
   }

   @Async
   @Override
   public List<TechMachinePart> listBySteelId(Long steelId) {
      return this.machinePartService.listBySteelId(steelId);
   }

   @Async
   @Override
   public void initSteelInfo(Long steelId) {
      List<TechMachinePart> techMachineParts = this.listBySteelId(steelId);
      techMachineParts.forEach(techMachinePart -> {
         techMachinePart.setSteelId(null);
         techMachinePart.setSteelSpec(null);
         this.machinePartService.updateById(techMachinePart);
      });
   }

   @Override
   public List<ComponentCrderInformationDTO> selectByProjectId(Long projectId) {
      return this.machinePartService.selectByProjectId(projectId);
   }

   @Override
   public List<TechMachinePartDTO> listSpacerByCondition(String serialNumber, String specification, String thick, String material) {
      List<TechMachinePartDTO> techMachinePartDTOS = this.machinePartService.listSpacerByCondition(serialNumber, specification, thick, material);
      if (CollectionUtils.isNotEmpty(techMachinePartDTOS)) {
         List<TechDrawing> techDrawings = this.techDrawingService
            .list(
               (Wrapper<TechDrawing>)((((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getProjectId, 0))
                           .isNull(TechDrawing::getProductType))
                        .eq(TechDrawing::getMonomerId, 0))
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType()))
                  .in(TechDrawing::getSerialNumber, techMachinePartDTOS.stream().map(TechMachinePartDTO::getSerialNumber).collect(Collectors.toList()))
            );
         if (CollectionUtils.isNotEmpty(techDrawings)) {
            Map<String, TechDrawing> techDrawingMap = techDrawings.stream().collect(Collectors.toMap(TechDrawing::getSerialNumber, e -> (TechDrawing)e));

            for (TechMachinePartDTO dto : techMachinePartDTOS) {
               TechDrawing drawing = techDrawingMap.get(dto.getSerialNumber());
               if (drawing != null) {
                  String picturePath = drawing.getPicturePath();
                  dto.setPicturePath(this.ip + "files/" + picturePath);
               }
            }
         }
      }

      return techMachinePartDTOS;
   }

   @Override
   public PageVO<TechMachinePartDTO> listSpacerByConditionPage(
      String serialNumber, String specification, String thick, String material, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      String s = com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sort);
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, s), this.listSpacerByCondition(serialNumber, specification, thick, material));
   }

   @Override
   public HashMap<String, Set<String>> getScreeningCondition() {
      List<TechMachinePart> techMachineParts = this.machinePartService
         .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.SPACER_PARALLEL.getType()));
      HashMap<String, Set<String>> map = new HashMap<>();
      if (CollectionUtils.isNotEmpty(techMachineParts)) {
         Set<String> thickList = techMachineParts.stream().map(TechMachinePart::getThick).collect(Collectors.toSet());
         Set<String> materialList = techMachineParts.stream().map(TechMachinePart::getMaterial).collect(Collectors.toSet());
         map.put("thick", thickList);
         map.put("material", materialList);
      }

      return map;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSpacerParallelList(List<MachinePartSpacerParallelDTOParam> dtoParamList) {
      Set<String> serialNumberSet = dtoParamList.stream().map(MachinePartSpacerParallelDTOParam::getSerialNumber).collect(Collectors.toSet());
      Preconditions.checkArgument(serialNumberSet.size() == dtoParamList.size(), "新增失败,垫块编号不能重复!!!");
      List<TechMachinePart> techMachineParts = this.machinePartService
         .list(
            (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>()
                  .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.SPACER_PARALLEL.getType()))
               .in(TechMachinePart::getSerialNumber, serialNumberSet)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(techMachineParts), "新增失败,已存在相同编号的垫块!!!");
      dtoParamList.forEach(e -> {
         String mpSpecPrefix = TechUtils.getSpecPrefix(e.getSpecification());
         Preconditions.checkArgument("PL".equals(mpSpecPrefix), "垫块规格前缀只能为PL!!!");
         String machinePartThick = TechUtils.getMachinePartThick(e.getSpecification());
         TechMachinePart techMachinePart = BeanUtil.copy(e, TechMachinePart.class);
         SteelClassificationMatchDTO steelInfo = this.steelClassificationBiz.getSteelInfo(e.getSpecification());
         if (steelInfo != null) {
            techMachinePart.setSteelId(steelInfo.getSteelId());
            techMachinePart.setSteelSpec(steelInfo.getSpec());
         }

         techMachinePart.setProjectId(0L);
         techMachinePart.setMonomerId(0L);
         techMachinePart.setAreaId(0L);
         techMachinePart.setUsedQuantity(0);
         techMachinePart.setQuantity(0);
         techMachinePart.setProducedQuantity(0);
         techMachinePart.setTotalNetWeight(BigDecimal.ZERO);
         techMachinePart.setTotalGrossWeight(BigDecimal.ZERO);
         if (e.getThick() != null) {
            techMachinePart.setThick(e.getThick().toString());
         }

         techMachinePart.setRelationType(MachinePartRelationTypeEnum.SPACER_PARALLEL.getType());
         techMachinePart.setUserId(UserUtil.getCurrentUserId());
         techMachinePart.setBoolProcess(Boolean.TRUE);
         this.machinePartService.save(techMachinePart);
         if (org.apache.commons.lang3.StringUtils.isNotBlank(e.getFilePath())) {
            Preconditions.checkArgument(this.renameFile(e.getFilePath(), TechDataTypeEnum.NC_DRAWING.getType(), techMachinePart.getId()), "文件上传失败!!!");
         }
      });
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeSpacerParallel(List<Long> ids) {
      List<TechMachinePart> techMachineParts = this.machinePartService
         .list(
            (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>()
                  .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.SPACER_PARALLEL.getType()))
               .in(TechMachinePart::getId, ids)
         );
      Preconditions.checkArgument(techMachineParts.size() == ids.size(), "删除失败，所选垫块配置不存在!!!");
      List<String> serialNumberList = techMachineParts.stream().map(TechMachinePart::getSerialNumber).collect(Collectors.toList());
      List<TechDrawing> drawingList = this.techDrawingService
         .list(
            Wrappers.lambdaQuery(TechDrawing.class)
               .eq(TechDrawing::getProjectId, 0)
               .isNull(TechDrawing::getProductType)
               .eq(TechDrawing::getMonomerId, 0)
               .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
               .in(TechDrawing::getSerialNumber, serialNumberList)
         );
      if (CollectionUtils.isNotEmpty(drawingList)) {
         List<Long> idList = drawingList.stream().map(TechDrawing::getId).collect(Collectors.toList());
         List<TechMachineHoleRadiusLink> radiusLinks = this.techMachineHoleRadiusLinkBiz
            .list((Wrapper<TechMachineHoleRadiusLink>)new LambdaQueryWrapper<TechMachineHoleRadiusLink>().in(TechMachineHoleRadiusLink::getDrawingId, idList));
         if (CollectionUtils.isNotEmpty(radiusLinks)) {
            this.techMachineHoleRadiusLinkBiz.removeByIds(radiusLinks.stream().map(TechMachineHoleRadiusLink::getId).collect(Collectors.toList()));
         }

         for (TechDrawing drawing : drawingList) {
            String path = this.configProperties.getFilePath() + drawing.getFilePath();
            FileUtil.deleteFile(path);
         }

         this.techDrawingService.removeByIds(idList);
      }

      this.machinePartService.removeByIds(ids);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean uploadFileAndUnzip(MultipartFile multipartFile, Long id, Integer dataType) {
      TechMachinePart part = this.machinePartService
         .getOne(
            (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>()
                  .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.SPACER_PARALLEL.getType()))
               .eq(TechMachinePart::getId, id)
         );
      Preconditions.checkArgument(part != null, "操作失败，所选垫块信息不存在!!!");
      String originalFilename = multipartFile.getOriginalFilename();
      String suffix = FileUtil.getFileExtension(Objects.requireNonNull(originalFilename));
      Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), "垫块图纸格式不正确!!!");
      originalFilename = part.getSerialNumber() + ".dxf";
      String filePath = AttachmentTypeEnum.TECH_DATA.getName()
         + File.separator
         + TechDataTypeEnum.getDirByType(dataType)
         + File.separator
         + 0L
         + File.separator
         + 0L
         + File.separator;
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);

      try {
         File file = new File(absolutePath + originalFilename);
         multipartFile.transferTo(file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      this.buildFile(originalFilename, absolutePath, filePath, part);
      return Boolean.TRUE;
   }

   @Override
   public String uploadTemporaryFiles(MultipartFile multipartFile, Integer dataType) {
      String originalFilename = multipartFile.getOriginalFilename();
      String suffix = FileUtil.getFileExtension(Objects.requireNonNull(originalFilename));
      Preconditions.checkArgument("dxf".equalsIgnoreCase(suffix), "垫块图纸格式不正确!!!");
      String filePath = AttachmentTypeEnum.TECH_DATA.getName()
         + File.separator
         + TechDataTypeEnum.getDirByType(dataType)
         + File.separator
         + 0L
         + File.separator
         + 0L
         + File.separator;
      String absolutePath = this.configProperties.getFilePath() + filePath;
      FileUtil.mkdirs(absolutePath);
      originalFilename = UUIDUtil.getUUID() + ".dxf";

      try {
         File file = new File(absolutePath + originalFilename);
         multipartFile.transferTo(file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return absolutePath + originalFilename;
   }

   private String getThicknessBySpec(Integer specIndex, String spec) {
      if (specIndex == 0) {
         return spec;
      }

      String[] specArray = spec.split("\\*");
      return specIndex > specArray.length ? "" : specArray[specIndex - 1];
   }

   private Boolean renameFile(String oldAbsolutePath, Integer dataType, Long id) {
      TechMachinePart techMachinePart = this.machinePartService.getById(id);
      Preconditions.checkArgument(techMachinePart != null, "操作失败，所选垫块信息不存在!!!");
      File oldFile = new File(oldAbsolutePath);
      Preconditions.checkArgument(oldFile.exists(), techMachinePart.getSerialNumber() + "dxf文件不存在");
      String filePath = AttachmentTypeEnum.TECH_DATA.getName()
         + File.separator
         + TechDataTypeEnum.getDirByType(dataType)
         + File.separator
         + 0L
         + File.separator
         + 0L
         + File.separator;
      String absolutePath = this.configProperties.getFilePath() + filePath;
      File file = new File(absolutePath + techMachinePart.getSerialNumber() + ".dxf");
      if (file.exists()) {
         Preconditions.checkArgument(file.delete(), "旧文件替换失败");
      }

      Preconditions.checkArgument(oldFile.renameTo(file), "文件上传失败!!!");
      this.buildFile(techMachinePart.getSerialNumber() + ".dxf", absolutePath, filePath, techMachinePart);
      return Boolean.TRUE;
   }

   private void buildFile(String originalFilename, String absolutePath, String filePath, TechMachinePart techMachinePart) {
      String ossRelativePath = "0/0/" + originalFilename;
      String localAbsoluteFilePath = absolutePath + originalFilename;
      OSS client = this.ossUtils.openClient();
      String dxfUrl = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
      TechDrawing drawing = this.techDrawingService
         .getOne(
            Wrappers.lambdaQuery(TechDrawing.class)
               .eq(TechDrawing::getProjectId, 0)
               .isNull(TechDrawing::getProductType)
               .eq(TechDrawing::getMonomerId, 0)
               .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
               .eq(TechDrawing::getSerialNumber, techMachinePart.getSerialNumber())
         );
      if (drawing != null) {
         drawing.setCreateUserId(UserUtil.getCurrentUserId());
         drawing.setCloudPath(dxfUrl);
         String drawingUrl = this.techDrawingService.transformationDxf(drawing.getFilePath(), drawing.getFileName(), drawing.getSerialNumber(), 1);
         drawing.setPicturePath(drawingUrl);
         this.techDrawingService.updateById(drawing);
      } else {
         drawing = TechDrawing.builder()
            .dataType(TechDataTypeEnum.NC_DRAWING.getType())
            .projectId(0L)
            .monomerId(0L)
            .serialNumber(techMachinePart.getSerialNumber())
            .filePath(filePath)
            .cloudPath(dxfUrl)
            .fileName(originalFilename)
            .createUserId(UserUtil.getCurrentUserId())
            .build();
         this.techDrawingService.save(drawing);
         String drawingUrl = this.techDrawingService.transformationDxf(drawing.getFilePath(), drawing.getFileName(), drawing.getSerialNumber(), 1);
         drawing.setPicturePath(drawingUrl);
         this.techDrawingService.updateById(drawing);
         this.updateRadius(0L, techMachinePart.getSerialNumber(), ossRelativePath);
      }
   }

   private void updateRadius(Long monomerId, String serialNumber, String ossRelativePath) {
      TechDrawing drawing = this.techDrawingService
         .getOne(
            Wrappers.lambdaQuery(TechDrawing.class)
               .eq(TechDrawing::getMonomerId, monomerId)
               .isNull(TechDrawing::getProductType)
               .eq(TechDrawing::getDataType, TechDataTypeEnum.NC_DRAWING.getType())
               .eq(TechDrawing::getSerialNumber, serialNumber)
         );
      HoleRadiusDTO holeRadiusDTO = this.techDrawingService.parseDrawing(drawing.getFilePath(), drawing.getFileName());
      TechMachinePart part = this.machinePartService.getOne(Wrappers.lambdaQuery(TechMachinePart.class).eq(TechMachinePart::getSerialNumber, serialNumber));
      Preconditions.checkArgument(part != null, "操作失败，垫块配置不存在");
      part.setBoolHaveHole(holeRadiusDTO.getHoleNumber() > 0);
      part.setHoleNumber((long)holeRadiusDTO.getHoleNumber().intValue());
      part.setPath(drawing.getCloudPath());
      part.setOssRelativePath(ossRelativePath);
      this.machinePartService.updateById(part);
      this.techMachineHoleRadiusLinkBiz
         .remove(
            Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
               .eq(TechMachineHoleRadiusLink::getMonomerId, monomerId)
               .eq(TechMachineHoleRadiusLink::getSerialNumber, serialNumber)
         );
      Map<Double, Long> map = holeRadiusDTO.getHoleRadiusMap();

      for (Double aDouble : map.keySet()) {
         TechMachineHoleRadiusLink build = TechMachineHoleRadiusLink.builder()
            .radius(BigDecimal.valueOf(aDouble).multiply(new BigDecimal(2)))
            .quantity(Integer.valueOf(map.get(aDouble) + ""))
            .serialNumber(serialNumber)
            .dataType(TechDataTypeEnum.NC_DRAWING.getType())
            .monomerId(monomerId)
            .drawingId(drawing.getId())
            .fileName(drawing.getFileName())
            .build();
         this.techMachineHoleRadiusLinkBiz.save(build);
      }
   }
}
