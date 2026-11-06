package com.hzchum.scim.mes.building.core.service.impl.task;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingMachinePartDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingSchedulingProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingAssembleSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingEnclosureSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingMachinePartSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.SchedulingDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MachinePartSummartDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingAssembleDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingEnclosureDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingMachinePartDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.SchedulingSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.get.SchedulingDetailListDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.DrawingAndSerialNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.SchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MachinePartSummartDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingArtifactDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingAssembleDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingEnclosureDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingMachinePartDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingClearDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingSchedulingMapper;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductLineSummary;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MesBuildingSchedulingServiceImpl extends ServiceImpl<MesBuildingSchedulingMapper, MesBuildingScheduling> implements MesBuildingSchedulingService {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingSchedulingBiz mesBuildingSchedulingBiz;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechEnclosureService enclosureService;

   @Override
   public List<MesBuildingSchedulingDO> listByCondition(SchedulingDetailListDOParam copy) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(copy.getProductType()), "传入产品数据有误");
      return this.baseMapper.listByCondition(copy);
   }

   @Override
   public MesBuildingSchedulingDO listById(Long id, Integer productType) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "传入产品数据有误");
      return this.baseMapper.listById(id, productType);
   }

   @Override
   public PageVO<MesBuildingSchedulingDO> pageByCondition(SchedulingDetailListDOParam copy, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listByCondition(copy));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printByCondition(SchedulingDetailListDOParam copy) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(copy.getProductType()), "传入产品数据有误");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (copy.getProjectId() != null) {
         header.put("project", this.projectService.getSimpleById(copy.getProjectId()));
      }

      if (copy.getProjectId() != null) {
         header.put("monomer", BeanUtil.copy(this.monomerService.getById(copy.getMonomerId()), NameInfo.class));
      }

      if (copy.getProjectId() != null) {
         header.put("area", BeanUtil.copy(this.areaService.getById(copy.getAreaId()), NameInfo.class));
      }

      if (copy.getProjectId() != null) {
         header.put("factory", BeanUtil.copy(this.factoryService.getById(copy.getFactoryId()), NameInfo.class));
      }

      if (copy.getProjectId() != null) {
         header.put("productionLine", BeanUtil.copy(this.productionLineService.getById(copy.getProductionLineId()), NameInfo.class));
      }

      printVO.setHeader(header);
      List<MesBuildingSchedulingDO> list = this.listByCondition(copy);
      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<MesBuildingAssembleSchedulingSummaryDO> getAssembleSchedulingGroupByDay(SchedulingSummaryDOParam doParam) {
      return this.baseMapper.getAssembleSchedulingGroupByDay(doParam);
   }

   @Override
   public List<MesBuildingArtifactSchedulingSummaryDO> getArtifactSchedulingGroupByDay(SchedulingSummaryDOParam doParam) {
      return this.baseMapper.getArtifactSchedulingGroupByDay(doParam);
   }

   @Override
   public List<MesBuildingEnclosureSchedulingSummaryDO> getEnclosureSchedulingGroupByDay(SchedulingSummaryDOParam doParam) {
      return this.baseMapper.getEnclosureSchedulingGroupByDay(doParam);
   }

   @Override
   public List<MesBuildingMachinePartSchedulingSummaryDO> getMachinePartSchedulingGroupByDay(SchedulingSummaryDOParam doParam) {
      return this.baseMapper.getMachinePartSchedulingGroupByDay(doParam);
   }

   @Override
   public Boolean updateSchedulingQuantity(MesBuildingSchedulingDTOParam dtoParam) {
      Preconditions.checkArgument(this.utilsBiz.checkSchedulingQuantity(dtoParam.getId(), dtoParam.getSchedulingQuantity()), "修改失败,排产数量不正确");
      MesBuildingScheduling scheduling = BeanUtil.copy(dtoParam, MesBuildingScheduling.class);
      if (scheduling.getSchedulingQuantity() > 0) {
         this.baseMapper.updateById(scheduling);
      } else {
         this.baseMapper.deleteById(scheduling);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean clearSchedulingQuantity(MesBuildingSchedulingClearDTOParam dtoParam) {
      dtoParam.getProductId()
         .forEach(
            e -> {
               List<MesBuildingScheduling> schedulingList = this.baseMapper
                  .selectList(
                     (Wrapper<MesBuildingScheduling>)(Wrappers.<MesBuildingScheduling>lambdaQuery().eq(MesBuildingScheduling::getProductId, e))
                        .eq(MesBuildingScheduling::getProductType, dtoParam.getProductType())
                  )
                  .stream()
                  .filter(temp -> temp.getSchedulingQuantity() > temp.getTaskQuantity())
                  .collect(Collectors.toList());
               schedulingList.forEach(temp -> this.baseMapper.deleteById(temp.getId()));
            }
         );
      return true;
   }

   @Override
   public MesBuildingSchedulingSummaryDO selectSummary(MesBuildingSchedulingDOParam build) {
      return this.baseMapper.selectSummary(build);
   }

   @Override
   public SchedulingDetailDTO getSchedulingDetailByProductIdAndProductType(Long productId, Integer productType, Long assembleId) {
      SchedulingDetailDTO detailDTO = BeanUtil.copy(
         this.baseMapper.selectSchedulingDetailByProductIdAndProductType(productId, productType, assembleId), SchedulingDetailDTO.class
      );
      if (assembleId != null && productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         SchedulingDetailDO detailDO = this.baseMapper.selectSchedulingDetailByProductIdAndProductType(assembleId, ProductTypeEnum.ASSEMBLE.getType(), null);
         TechAssembleMachinePartLink link = this.assembleMachinePartLinkService
            .getOne(
               (Wrapper<TechAssembleMachinePartLink>)(Wrappers.<TechAssembleMachinePartLink>lambdaQuery().eq(TechAssembleMachinePartLink::getAssembleId, assembleId))
                  .eq(TechAssembleMachinePartLink::getMachinePartId, productId)
            );
         detailDTO.setTotalSchedulingQuantity(detailDO.getTotalSchedulingQuantity() * link.getQuantity());
      }

      return detailDTO;
   }

   @Override
   public Boolean checkStatus(Long productionLine) {
      return this.baseMapper
         .selectList((Wrapper<MesBuildingScheduling>)Wrappers.<MesBuildingScheduling>lambdaQuery().eq(MesBuildingScheduling::getProductionLineId, productionLine))
         .stream()
         .noneMatch(e -> e.getSchedulingQuantity().equals(e.getCompleteQuantity()));
   }

   @Override
   public List<MesBuildingArtifactDTO> listSchedulingArtifactByCondition(MesBuildingArtifactDTOParam copy) {
      List<MesBuildingArtifactDTO> dtoList = this.baseMapper
         .listSchedulingArtifactByCondition(BeanUtil.copy(copy, MesBuildingArtifactDO.class).setAssembleLink(true))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactDTO.class))
         .collect(Collectors.toList());
      List<MesBuildingSchedulingProductionLineDO> productionLineDOS = this.baseMapper
         .getSchedulingGroupProductionLineIds(
            dtoList.stream().map(MesBuildingArtifactDTO::getId).distinct().collect(Collectors.toList()), ProductTypeEnum.ARTIFACT.getType()
         );
      Map<String, List<TechDrawing>> techMap = null;
      List<TechDrawing> techDrawings = this.techDrawingService
         .list(
            (Wrapper<TechDrawing>)((new LambdaQueryWrapper<TechDrawing>()
                     .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                  .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
               .eq(TechDrawing::getMonomerId, copy.getMonomerId())
         );
      if (CollectionUtils.isNotEmpty(techDrawings)) {
         techMap = techDrawings.stream()
            .collect(
               Collectors.toMap(TechDrawing::getSerialNumber, drawing -> new ArrayList<>(Collections.singleton((TechDrawing)drawing)), (oldList, newList) -> {
                  oldList.addAll(newList);
                  return oldList;
               })
            );
      }

      Map<String, List<TechDrawing>> finalTechMap = techMap;
      dtoList.forEach(
         e -> {
            e.setSurfaceArea(e.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
            e.setSchedulingProductionLineDTOS(productionLineDOS.stream().filter(filter -> filter.getProductId().equals(e.getId())).collect(Collectors.toList()));
            if (CollectionUtils.isNotEmpty(finalTechMap) && CollectionUtils.isNotEmpty(finalTechMap.get(e.getSerialNumber()))) {
               List<TechDrawing> drawingList = finalTechMap.get(e.getSerialNumber());
               e.setNumbers(drawingList.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               e.setDrawingAndSerialNumber(
                  drawingList.stream().map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }
         }
      );
      return dtoList;
   }

   @Override
   public PageVO listSchedulingArtifactByConditionPage(MesBuildingArtifactDTOParam copy, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listSchedulingArtifactByCondition(copy));
   }

   @Override
   public List<MesBuildingAssembleDTO> listSchedulingAssembleByCondition(MesBuildingAssembleDTOParam copy) {
      List<MesBuildingAssembleDTO> dtoList = this.baseMapper
         .listSchedulingAssembleByCondition(BeanUtil.copy(copy, MesBuildingAssembleDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingAssembleDTO.class))
         .collect(Collectors.toList());
      List<MesBuildingSchedulingProductionLineDO> productionLineDOS = this.baseMapper
         .getSchedulingGroupProductionLineIds(
            dtoList.stream().map(MesBuildingAssembleDTO::getId).distinct().collect(Collectors.toList()), ProductTypeEnum.ASSEMBLE.getType()
         );
      dtoList.forEach(
         e -> e.setSchedulingProductionLineDTOS(
            productionLineDOS.stream().filter(filter -> filter.getProductId().equals(e.getId())).collect(Collectors.toList())
         )
      );
      return dtoList;
   }

   @Override
   public PageVO<MesBuildingAssembleDTO> listSchedulingAssembleByConditionPage(
      MesBuildingAssembleDTOParam copy, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listSchedulingAssembleByCondition(copy));
   }

   @Override
   public List<MesBuildingEnclosureDTO> listSchedulingEnclosureByCondition(MesBuildingEnclosureDTOParam copy) {
      List<MesBuildingEnclosureDTO> dtoList = this.baseMapper
         .listSchedulingEnclosureByCondition(BeanUtil.copy(copy, MesBuildingEnclosureDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingEnclosureDTO.class))
         .collect(Collectors.toList());
      List<MesBuildingSchedulingProductionLineDO> productionLineDOS = this.baseMapper
         .getSchedulingGroupProductionLineIds(
            dtoList.stream().map(MesBuildingEnclosureDTO::getId).distinct().collect(Collectors.toList()), ProductTypeEnum.ENCLOSURE.getType()
         );
      dtoList.forEach(
         e -> e.setSchedulingProductionLineDTOS(
            productionLineDOS.stream().filter(filter -> filter.getProductId().equals(e.getId())).collect(Collectors.toList())
         )
      );
      return dtoList;
   }

   @Override
   public PageVO<MesBuildingEnclosureDTO> listSchedulingEnclosureByConditionPage(
      MesBuildingEnclosureDTOParam copy, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listSchedulingEnclosureByCondition(copy));
   }

   @Override
   public List<MesBuildingMachinePartDTO> listSchedulingMachinePartByCondition(MesBuildingMachinePartDTOParam copy) {
      List<MesBuildingMachinePartDTO> dtoList = this.baseMapper
         .listSchedulingMachinePartByCondition(BeanUtil.copy(copy, MesBuildingMachinePartDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingMachinePartDTO.class))
         .collect(Collectors.toList());
      List<MesBuildingSchedulingProductionLineDO> productionLineDOS = this.baseMapper
         .getSchedulingGroupProductionLineIds(
            dtoList.stream().map(MesBuildingMachinePartDO::getId).distinct().collect(Collectors.toList()), ProductTypeEnum.ENCLOSURE.getType()
         );
      dtoList.forEach(
         e -> e.setSchedulingProductionLineDTOS(
            productionLineDOS.stream().filter(filter -> filter.getProductId().equals(e.getId())).collect(Collectors.toList())
         )
      );
      return dtoList;
   }

   @Override
   public PageVO<MesBuildingMachinePartDTO> listSchedulingMachinePartByConditionPage(
      MesBuildingMachinePartDTOParam copy, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listSchedulingMachinePartByCondition(copy));
   }

   @Override
   public PageVO<MesBuildingMachinePartSummaryDTO> schedulingSummaryMachinePartByConditionPage(
      MachinePartSummartDTOParam copy, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.schedulingSummaryMachinePartByConditionList(copy));
   }

   @Override
   public List<MesBuildingMachinePartSummaryDTO> schedulingSummaryMachinePartByConditionList(MachinePartSummartDTOParam copy) {
      return this.baseMapper
         .schedulingSummaryMachinePartByConditionList(BeanUtil.copy(copy, MachinePartSummartDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingMachinePartSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public MesBuildingScheduling getScheduling(LocalDateTime today, LocalDateTime askTime, Long productId, Integer productType, Long productionLineId) {
      return this.baseMapper.getScheduling(today, askTime, productId, productType, productionLineId);
   }

   @Override
   public int getTotalScheduling(Long productId) {
      return this.baseMapper.selectTotalScheduling(productId);
   }

   @Override
   public ProductLineSummary selectSummaryData(Long lineId, Long projectId) {
      return this.baseMapper.selectSummaryData(lineId, projectId);
   }

   @Override
   public List<NameInfo> getProductLine(Integer productType) {
      return this.baseMapper.getProductLine(productType);
   }

   @Override
   public void exportArtifactPartTemplate(HttpServletResponse response, Long areaId, Integer productType, Integer statusType) {
      ServletOutputStream out = null;
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("files/ArtifactSchedule.xlsx");
      String fileName = "工单排产清单.xlsx";

      try {
         response.setContentType("application/vnd.ms-excel;charset=UTF-8");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("utf-8");
         out = response.getOutputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      ExcelWriter excelWriter = EasyExcel.write(out).withTemplate(inputStream).build();
      WriteSheet writeSheet = EasyExcel.writerSheet().build();
      FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
      List<NameInfo> productLine = this.getProductLine(productType);
      productLine.add(NameInfo.builder().id(Long.valueOf("-1")).name("完成日期").build());
      excelWriter.fill(new FillWrapper("data", productLine), fillConfig, writeSheet);
      excelWriter.finish();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean importArtifact(MultipartFile file, Long areaId, Integer productType) {
      List<Map<String, String>> importDTOS = new ArrayList<>();
      XSSFWorkbook wb = null;

      try {
         InputStream inputStream = file.getInputStream();
         String fileName = file.getOriginalFilename();
         if (!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls")) {
            throw new IllegalArgumentException("文件格式不正确！");
         }

         if (file.isEmpty()) {
            throw new Exception("文件为空！");
         }

         wb = new XSSFWorkbook(inputStream);
      } catch (Exception e) {
         e.printStackTrace();
      }

      Sheet sheet = wb.getSheetAt(0);
      int totalRow = sheet.getLastRowNum();
      List<String> headList = new ArrayList<>();

      for (int rowNum = 1; rowNum <= totalRow; rowNum++) {
         List<String> dataList = new ArrayList<>();
         Map<String, String> map = new HashMap<>();
         if (rowNum == 1) {
            Row row = sheet.getRow(rowNum);
            int totalCellNum = row.getLastCellNum();

            for (int cellNum = 0; cellNum < totalCellNum; cellNum++) {
               String cell = String.valueOf(row.getCell(cellNum));
               headList.add(cell);
            }
         } else {
            Row rowData = sheet.getRow(rowNum);
            int totalCellNum = rowData.getLastCellNum();

            for (int cellNum = 0; cellNum < totalCellNum; cellNum++) {
               Cell cell = rowData.getCell(cellNum);
               String cellValue = null;
               Preconditions.checkArgument(cell != null, "生产线数据不能为空");
               if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                  if (!DateUtil.isCellDateFormatted(cell)) {
                     cell.setCellType(CellType.STRING);
                     cellValue = cell.getStringCellValue();
                  }
               } else {
                  cell.setCellType(CellType.STRING);
                  cellValue = cell.getStringCellValue();
               }

               dataList.add(cellValue == "" ? "0" : cellValue);
               if (cellValue == "") {
                  throw new BusinessException("生产线数据不能为空");
               }
            }

            for (int i = 0; i < headList.size(); i++) {
               if (dataList.size() > i) {
                  map.put(headList.get(i), dataList.get(i));
               } else {
                  map.put(headList.get(i), "0");
               }
            }

            importDTOS.add(map);
         }
      }

      Preconditions.checkArgument(headList.size() > 4, "至少有一条生产线");

      for (Map<String, String> map : importDTOS) {
         Integer sum = 0;

         for (int i = 4; i < headList.size() - 1; i++) {
            if (!map.get(headList.get(i)).isEmpty()) {
               sum = sum + Integer.parseInt(map.get(headList.get(i)));
            }
         }

         Preconditions.checkArgument(sum == Integer.parseInt(map.get(headList.get(3))), "排产数量不等于汇总数量");
      }

      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不能为空");
      Long productId = null;

      for (int i = 0; i < importDTOS.size(); i++) {
         String erialNumber = importDTOS.get(i).get(headList.get(2)).trim();
         if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService
               .getOne(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getAreaId, areaId).eq(TechArtifact::getSerialNumber, erialNumber));
            Preconditions.checkArgument(artifact != null, "构件不能为空");
            productId = artifact.getId();
         } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            TechAssemble assemble = this.assembleService
               .getOne(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getAreaId, areaId).eq(TechAssemble::getSerialNumber, erialNumber));
            Preconditions.checkArgument(assemble != null, "组立不能为空");
            productId = assemble.getId();
         } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService
               .getOne(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getEnclosurePlanId, areaId).eq(TechEnclosure::getSerialNumber, erialNumber));
            Preconditions.checkArgument(enclosure != null, "围护不能为空");
            productId = enclosure.getId();
         }

         LocalDateTime localDateTime = null;
         List<MesBuildingSchedulingDTOParam> schedulingList = new ArrayList<>();

         for (int j = 4; j < headList.size() - 1; j++) {
            Integer sum = Integer.valueOf(importDTOS.get(i).get(headList.get(j)));
            MesBuildingProductionLine buildingProductionLine = this.productionLineService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingProductionLine.class)
                     .eq(MesBuildingProductionLine::getName, headList.get(j))
                     .eq(MesBuildingProductionLine::getProductType, productType)
               );
            if (sum != 0) {
               MesBuildingSchedulingDTOParam dtoParam = MesBuildingSchedulingDTOParam.builder()
                  .projectId(area.getProjectId())
                  .factoryId(buildingProductionLine.getFactoryId())
                  .workshopId(buildingProductionLine.getWorkshopId())
                  .productionLineId(buildingProductionLine.getId())
                  .areaId(areaId)
                  .monomerId(area.getMonomerId())
                  .productId(productId)
                  .productType(productType)
                  .schedulingQuantity(sum)
                  .build();
               schedulingList.add(dtoParam);
               String date = importDTOS.get(i).get(headList.get(headList.size() - 1));
               Boolean aBoolean = this.isFormat(date);
               Preconditions.checkArgument(aBoolean.equals(true), "日期格式不正确(例:2022-01-01)");
               localDateTime = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
            }
         }

         this.mesBuildingSchedulingBiz.saveScheduling(schedulingList, localDateTime, true);
      }

      return true;
   }

   private Boolean isFormat(String date) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      boolean falg = true;
      simpleDateFormat.setLenient(false);

      try {
         simpleDateFormat.parse(date);
      } catch (ParseException e) {
         falg = false;
      }

      return falg;
   }
}
