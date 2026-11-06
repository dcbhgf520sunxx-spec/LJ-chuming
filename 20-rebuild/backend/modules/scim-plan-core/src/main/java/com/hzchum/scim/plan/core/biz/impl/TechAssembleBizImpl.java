package com.hzchum.scim.plan.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.statistica.SpecPrefixEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.plan.core.api.biz.TechAssembleBiz;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AssembleMachinePartDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.ExportMistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechAssembleBizImpl implements TechAssembleBiz {
   private static final Logger log = LoggerFactory.getLogger(TechAssembleBizImpl.class);
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private SysSteelClassificationBiz steelClassificationBiz;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private SysAssembleSpecService assembleSpecService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private SysSteelClassificationMatchService steelClassificationMatchService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private SysSteelClassificationService sysSteelClassificationService;

   @Override
   public PageVO<AssembleDTO> pageListByCondition(
      Long areaId,
      Long areaBatchId,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Integer permissionCheck
   ) {
      if (UserUtil.getCurrentUser().isAdmin()) {
         permissionCheck = null;
      }

      if (permissionCheck != null && this.areaService.getById(areaId).getMonomerId() != null) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(
               Wrappers.lambdaQuery(MonomerUserLink.class)
                  .eq(MonomerUserLink::getMonomerId, this.areaService.getById(areaId).getMonomerId())
                  .eq(MonomerUserLink::getDeepenedPersonId, UserUtil.getCurrentUser().getId())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(monomerUserLinkList), "您没有查看此清单的权限!");
      }

      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, orderBy);
      List<AssembleDTO> assembleDTOS = this.listByCondition(
         areaId, areaBatchId, serialNumber, specification, material, permissionCheck, UserUtil.getCurrentUser().getId()
      );
      return new PageVO<>(assembleDTOS);
   }

   private List<AssembleDTO> listByCondition(
      Long areaId, Long areaBatchId, String serialNumber, String specification, String material, Integer permissionCheck, Long userId
   ) {
      List<AssembleDTO> assembleDTOS = this.assembleService
         .listByCondition(areaId, areaBatchId, serialNumber, specification, material, permissionCheck, userId);
      if (CollectionUtils.isNotEmpty(assembleDTOS)) {
         List<Long> assembleIds = assembleDTOS.stream().map(AssembleDTO::getId).collect(Collectors.toList());
         List<TechAssembleMachinePartLink> linkList = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleIds));
         Map<Long, List<TechAssembleMachinePartLink>> assembleIdMachinePartIdMap = linkList.stream()
            .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
         Map<Long, TechMachinePart> machinePartIdMap = Collections.emptyMap();
         Map<Long, SysSteelClassification> steelClassificationMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(linkList)) {
            List<Long> machinePartIds = linkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
            machinePartIdMap = this.machinePartService
               .list(Wrappers.lambdaQuery(TechMachinePart.class).in(TechMachinePart::getId, machinePartIds))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            steelClassificationMap = this.sysSteelClassificationService
               .list(
                  (Wrapper<SysSteelClassification>)new LambdaQueryWrapper<SysSteelClassification>()
                     .in(SysSteelClassification::getId, machinePartIdMap.values().stream().map(TechMachinePart::getSteelId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.toMap(SysSteelClassification::getId, Function.identity()));
         }

         Map<Long, TechMachinePart> finalMachinePartIdMap = machinePartIdMap;
         Map<Long, SysSteelClassification> finalSteelClassificationMap = steelClassificationMap;
         assembleDTOS.forEach(assembleDTO -> {
            assembleDTO.setDetailDTOList(Collections.emptyList());
            if (assembleIdMachinePartIdMap.containsKey(assembleDTO.getId())) {
               List<TechAssembleMachinePartLink> list = assembleIdMachinePartIdMap.get(assembleDTO.getId());
               List<AssembleMachinePartDTO> machinePartDTOList = list.stream().map(link -> {
                  TechMachinePart machinePart = finalMachinePartIdMap.get(link.getMachinePartId());
                  AssembleMachinePartDTO machinePartDTO = BeanUtil.copy(machinePart, AssembleMachinePartDTO.class);
                  machinePartDTO.setQuantity(assembleDTO.getQuantity() * link.getQuantity());
                  machinePartDTO.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePartDTO.getQuantity().intValue())));
                  machinePartDTO.setUsedQuantity(assembleDTO.getProducedQuantity() * link.getQuantity());
                  machinePartDTO.setConfigName(finalSteelClassificationMap.get(machinePart.getSteelId()).getName());
                  return machinePartDTO;
               }).collect(Collectors.toList());
               assembleDTO.setDetailDTOList(machinePartDTOList);
            }
         });
      }

      return assembleDTOS;
   }

   @Override
   public void exportAssembles(Long areaId, Long areaBatchId, String serialNumber, String specification, String material, HttpServletResponse response) {
      PlanArea area = this.areaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不存在");
      ProjectInfo projectInfo = this.projectService.getSimpleById(area.getProjectId());
      PlanMonomer monomer = this.monomerService.getById(area.getMonomerId());
      List<AssembleDTO> assembleDTOS = this.listByCondition(areaId, areaBatchId, serialNumber, specification, material, null, null);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleDTOS), "部件清单数据为空!");
      int scale = 2;
      List<AssembleExportDTO> exportDTOList = new ArrayList<>();
      int orderNo = 1;

      for (AssembleDTO assembleDTO : assembleDTOS) {
         AssembleExportDTO exportDTO = BeanUtil.copy(assembleDTO, AssembleExportDTO.class);
         exportDTO.setAssembleNo(assembleDTO.getSerialNumber());
         exportDTO.setLength(exportDTO.getLength().setScale(scale, RoundingMode.HALF_UP));
         exportDTO.setNetWeight(exportDTO.getNetWeight().setScale(scale, RoundingMode.HALF_UP));
         exportDTO.setTotalNetWeight(
            exportDTO.getNetWeight().multiply(BigDecimal.valueOf(assembleDTO.getQuantity().intValue())).setScale(scale, RoundingMode.HALF_UP)
         );
         exportDTO.setOrderNo(orderNo++);
         exportDTOList.add(exportDTO);
         List<AssembleArtifactDTO> artifactDTOList = assembleDTO.getArtifactDTOList();
         if (CollectionUtils.isNotEmpty(artifactDTOList)) {
            for (AssembleArtifactDTO artifactDTO : artifactDTOList) {
               AssembleExportDTO assembleExportDTO = BeanUtil.copy(artifactDTO, AssembleExportDTO.class);
               assembleExportDTO.setOrderNo(orderNo++);
               assembleExportDTO.setDetailSerialNumber(artifactDTO.getSerialNumber());
               if (artifactDTO.getId() != null) {
                  assembleExportDTO.setLength(artifactDTO.getLength().setScale(scale, RoundingMode.HALF_UP));
                  assembleExportDTO.setNetWeight(artifactDTO.getNetWeight().setScale(scale, RoundingMode.HALF_UP));
                  assembleExportDTO.setTotalNetWeight(
                     assembleExportDTO.getNetWeight()
                        .multiply(BigDecimal.valueOf(assembleExportDTO.getQuantity().intValue()))
                        .setScale(scale, RoundingMode.HALF_UP)
                  );
               }

               exportDTOList.add(assembleExportDTO);
            }
         }

         List<AssembleMachinePartDTO> detailDTOList = assembleDTO.getDetailDTOList();
         if (CollectionUtils.isNotEmpty(detailDTOList)) {
            for (AssembleMachinePartDTO detail : detailDTOList) {
               AssembleExportDTO assembleExportDTO = BeanUtil.copy(detail, AssembleExportDTO.class);
               assembleExportDTO.setDetailSerialNumber(detail.getSerialNumber());
               assembleExportDTO.setOrderNo(orderNo++);
               assembleExportDTO.setLength(detail.getLength().setScale(scale, RoundingMode.HALF_UP));
               assembleExportDTO.setNetWeight(detail.getNetWeight().setScale(scale, RoundingMode.HALF_UP));
               assembleExportDTO.setTotalNetWeight(
                  detail.getNetWeight().multiply(BigDecimal.valueOf(detail.getQuantity().intValue())).setScale(scale, RoundingMode.HALF_UP)
               );
               exportDTOList.add(assembleExportDTO);
            }
         }
      }

      String title = projectInfo.getName() + " - " + monomer.getName() + " - " + area.getName();
      String sheetName = "部件清单";
      String fileName = "下载部件清单.xlsx";
      PoiUtils.exportExcel(exportDTOList, title, sheetName, AssembleExportDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public List<ComponentCrderInformationDTO> selectByProjectId(Long projectId) {
      return this.assembleService.selectProjectGroupBySpec(projectId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importAssemble(MultipartFile file, Long areaId, Integer importType, HttpServletResponse response) {
      int machinePartLengthError = 5;
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);
      List<SysAssembleSpec> assembleSpecList = this.assembleSpecService.list();
      if (assembleSpecList.isEmpty()) {
         mistakeExportDTOList.add(this.getMistakeDTO(null, "部件规格前缀没有配置"));
         this.exportMistakeList(response, mistakeExportDTOList);
      }

      List<MesBuildingProductProcess> processList = this.productProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
               .isNotNull(MesBuildingProductProcess::getTypeId)
         );
      Map<Long, MesBuildingProductProcess> assembleProcessMap = processList.stream()
         .filter(p -> p.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
         .collect(Collectors.toMap(MesBuildingProductProcess::getTypeId, Function.identity()));
      Map<Long, MesBuildingProductProcess> machinePartMap = processList.stream()
         .filter(p -> p.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
         .collect(Collectors.toMap(MesBuildingProductProcess::getTypeId, Function.identity()));
      Map<String, SysAssembleSpec> assembleSpecMap = assembleSpecList.stream().collect(Collectors.toMap(SysAssembleSpec::getSpecPrefix, Function.identity()));
      Map<String, SysSteelClassificationMatch> steelMatchMap = this.steelClassificationMatchService
         .list()
         .stream()
         .collect(Collectors.toMap(SysSteelClassificationMatch::getKeyword, Function.identity()));
      PlanArea area = this.beforeImportCheck(areaId, importType, mistakeExportDTOList, response);
      List<AssembleImportDTO> importDTOList = PoiUtils.importExcel(file, 1, 1, 0, AssembleImportDTO.class);
      importDTOList = importDTOList.stream().filter(s -> s.getOrderNo() != null).collect(Collectors.toList());
      if (importDTOList.isEmpty()) {
         mistakeExportDTOList.add(this.getMistakeDTO(null, "导入失败,导入的数据为空!"));
         this.exportMistakeList(response, mistakeExportDTOList);
      }

      List<AssembleDTOParam> assembleDTOParamList = this.transitionImportList(importDTOList, mistakeExportDTOList);
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         this.exportMistakeList(response, mistakeExportDTOList);
      } else {
         assembleDTOParamList.forEach(
            assembleParam -> {
               List<AssembleMachinePartDTOParam> partParamList = assembleParam.getMachinePartParamList();
               String assembleSpecPrefix = TechUtils.getSpecPrefix(assembleParam.getSpecification());
               if (!assembleSpecMap.containsKey(assembleSpecPrefix)) {
                  mistakeExportDTOList.add(this.getMistakeDTO(assembleParam.getOrderNo(), "部件规格前缀类型未配置"));
               }

               TechArtifact artifact = this.artifactService
                  .getOne(Wrappers.lambdaQuery(TechArtifact.builder().areaId(areaId).serialNumber(assembleParam.getSerialNumber()).build()));
               if (artifact == null) {
                  mistakeExportDTOList.add(this.getMistakeDTO(assembleParam.getOrderNo(), "构件编号在构件清单中不存在"));
               }

               if (artifact != null) {
                  List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
                     .list(Wrappers.lambdaQuery(TechAssembleDetail.builder().artifactId(artifact.getId()).build()));
                  if (org.apache.commons.lang3.StringUtils.isNotBlank(artifact.getSmartLineMarkWord())) {
                     List<MistakeExportDTO> mistakeExportDTOS = new ArrayList<>();
                     TechAssembleDetail assembleDetail = assembleDetailList.get(0);
                     TechAssemble assemble = this.assembleService.getById(assembleDetail.getAssembleId());
                     List<TechAssembleMachinePartLink> links = this.assembleMachinePartLinkService
                        .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.builder().assembleId(assemble.getId()).build()));
                     if (!assemble.getSpecification().equals(assembleParam.getSpecification())) {
                        mistakeExportDTOS.add(
                           this.getMistakeDTO(
                              assembleParam.getOrderNo(), "智能线构件(" + assembleParam.getArtifactNo() + ")和部件(" + assembleParam.getSerialNumber() + ")的规格不相同"
                           )
                        );
                     }

                     if (CollectionUtils.isNotEmpty(links)) {
                        mistakeExportDTOS.add(this.getMistakeDTO(assembleParam.getOrderNo(), "部件(" + assembleParam.getSerialNumber() + ")的翼板腹板已存在"));
                     }

                     if (CollectionUtils.isNotEmpty(mistakeExportDTOS)) {
                        mistakeExportDTOList.addAll(mistakeExportDTOS);
                     } else {
                        assemble.setSerialNumber(assembleParam.getSerialNumber());
                        this.assembleService.updateById(assemble);
                        this.assembleDetailService.updateById(assembleDetail);
                        if (CollectionUtils.isNotEmpty(partParamList)) {
                           partParamList.forEach(
                              partParam -> {
                                 String mpSpecPrefix = TechUtils.getSpecPrefix(partParam.getSpecification());
                                 if (!SpecPrefixEnum.isExist(mpSpecPrefix)) {
                                    mistakeExportDTOS.add(this.getMistakeDTO(partParam.getOrderNo(), partParam.getSerialNumber() + " 的规格前缀类型有误"));
                                 }

                                 if (!steelMatchMap.containsKey(mpSpecPrefix)) {
                                    mistakeExportDTOS.add(this.getMistakeDTO(partParam.getOrderNo(), partParam.getSerialNumber() + " 的规格前缀类型未定义"));
                                 }

                                 if (partParam.getQuantity() % assembleParam.getQuantity() > 0) {
                                    mistakeExportDTOS.add(
                                       this.getMistakeDTO(
                                          partParam.getOrderNo(), partParam.getSerialNumber() + " 的数量必须是部件(" + assembleParam.getSerialNumber() + ")数量的整数倍"
                                       )
                                    );
                                 }

                                 if (CollectionUtils.isNotEmpty(mistakeExportDTOS)) {
                                    mistakeExportDTOList.addAll(mistakeExportDTOS);
                                 } else {
                                    TechMachinePart machinePart = this.machinePartService
                                       .getOne(
                                          Wrappers.lambdaQuery(
                                             TechMachinePart.builder()
                                                .areaId(areaId)
                                                .serialNumber(partParam.getSerialNumber())
                                                .relationType(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
                                                .build()
                                          )
                                       );
                                    if (machinePart == null) {
                                       machinePart = this.buildMachinePart(mpSpecPrefix, area, partParam);
                                       this.machinePartService.save(machinePart);
                                    } else {
                                       machinePart.setQuantity(
                                          machinePart.getQuantity() + assemble.getQuantity() * partParam.getQuantity() / assembleParam.getQuantity()
                                       );
                                       machinePart.setTotalNetWeight(
                                          machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
                                       );
                                       machinePart.setTotalGrossWeight(
                                          machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
                                       );
                                       this.machinePartService.updateById(machinePart);
                                    }

                                    TechAssembleMachinePartLink link = TechAssembleMachinePartLink.builder()
                                       .assembleId(assemble.getId())
                                       .machinePartId(machinePart.getId())
                                       .quantity(partParam.getQuantity() / assembleParam.getQuantity())
                                       .build();
                                    this.assembleMachinePartLinkService.save(link);
                                 }
                              }
                           );
                        }
                     }
                  }

                  if (org.apache.commons.lang3.StringUtils.isBlank(artifact.getSmartLineMarkWord())) {
                     if (assembleDetailList.isEmpty()) {
                        mistakeExportDTOList.add(this.getMistakeDTO(assembleParam.getOrderNo(), "构件(" + assembleParam.getArtifactNo() + ")未导入部件"));
                     } else {
                        assembleDetailList.forEach(
                           assembleDetailx -> {
                              TechAssemble assemblex = this.assembleService.getById(assembleDetailx.getAssembleId());
                              assemblex.setSerialNumber(assembleParam.getSerialNumber());
                              this.assembleService.updateById(assemblex);
                              this.assembleDetailService.updateById(assembleDetailx);
                              List<TechAssembleMachinePartLink> assembleMachinePartLinkList = this.assembleMachinePartLinkService
                                 .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.builder().assembleId(assembleDetailx.getAssembleId()).build()));
                              if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
                                 mistakeExportDTOList.add(this.getMistakeDTO(assembleParam.getOrderNo(), "部件(" + assembleParam.getSerialNumber() + ")已导入翼腹板"));
                              }

                              if (!assembleParam.getQuantity().equals(assembleDetailx.getQuantity())) {
                                 mistakeExportDTOList.add(
                                    this.getMistakeDTO(
                                       assembleParam.getOrderNo(),
                                       "部件(" + assembleParam.getSerialNumber() + ")和构件(" + assembleParam.getArtifactNo() + ")的数量比和构件清单导入的不一致"
                                    )
                                 );
                              }

                              partParamList.forEach(partParam -> {});
                           }
                        );
                     }
                  }
               }
            }
         );
         this.exportMistakeList(response, mistakeExportDTOList);
      }
   }

   private void exportMistakeList(HttpServletResponse response, List<MistakeExportDTO> mistakeExportDTOList) {
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         ExportParams params = new ExportParams();
         params.setTitle("组立清单导入失败表");
         params.setSheetName("组立清单导入失败表");
         params.setType(ExcelType.XSSF);
         String fileName = "组立清单导入失败表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("导入失败，失败原因请查看表格", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         Workbook workbook = ExcelExportUtil.exportExcel(params, ExportMistakeExportDTO.class, mistakeExportDTOList);
         PoiUtils.downLoadExcel(fileName, response, workbook);
         throw new BusinessException("组立清单导入失败!");
      } else {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   private MistakeExportDTO getMistakeDTO(Integer orderNo, String message) {
      MistakeExportDTO mistakeExportDTO = new MistakeExportDTO();
      mistakeExportDTO.setOrderNo(orderNo);
      mistakeExportDTO.setErrorMessage(message);
      return mistakeExportDTO;
   }

   private TechMachinePart buildMachinePart(String specPrefix, PlanArea area, AssembleMachinePartDTOParam machinePartDTOParam) {
      TechMachinePart machinePart = TechMachinePart.builder()
         .userId(UserUtil.getCurrentUserId())
         .relationType(ProductTypeEnum.ASSEMBLE.getType())
         .specPrefix(specPrefix)
         .projectId(area.getProjectId())
         .monomerId(area.getMonomerId())
         .areaId(area.getId())
         .areaType(area.getType())
         .build();
      BeanUtil.copy(machinePartDTOParam, machinePart);
      machinePart.setGrossWeight(machinePartDTOParam.getNetWeight());
      machinePart.setTotalNetWeight(machinePartDTOParam.getNetWeight().multiply(BigDecimal.valueOf(machinePartDTOParam.getQuantity().intValue())));
      machinePart.setTotalGrossWeight(machinePart.getTotalNetWeight());
      this.steelClassificationBiz.setPartSteelInfo(machinePart);
      machinePart.setThick(machinePart.getSteelSpec());
      return machinePart;
   }

   private PlanArea beforeImportCheck(Long areaId, Integer importType, List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      PlanArea area = this.areaService.getById(areaId);

      try {
         Preconditions.checkArgument(area != null, "导入失败,区域不存在!");
         ContractProject project = this.projectService.checkProjectStatus(area.getProjectId());
         Preconditions.checkArgument(project.getMode().equals(ProjectModeEnum.STANDARD_MODE.getType()), "该项目模式不支持导入组立清单");
         if (importType.equals(ImportTypeEnum.COVER_IMPORT.getType())) {
            List<TechAssemble> assembleList = this.assembleService.list(Wrappers.lambdaQuery(TechAssemble.class).eq(TechAssemble::getAreaId, areaId));
            assembleList.forEach(a -> this.assembleService.deleteAssembleById(a.getId()));
         }
      } catch (Exception e) {
         e.printStackTrace();
         mistakeExportDTOList.add(this.getMistakeDTO(null, e.getMessage()));
      }

      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         this.exportMistakeList(response, mistakeExportDTOList);
      }

      return area;
   }

   private void delWhite(AssembleImportDTO importDTO) {
      importDTO.setArtifactNo(org.apache.commons.lang3.StringUtils.deleteWhitespace(importDTO.getArtifactNo()));
      importDTO.setSerialNumber(org.apache.commons.lang3.StringUtils.deleteWhitespace(importDTO.getSerialNumber()));
      importDTO.setMaterial(org.apache.commons.lang3.StringUtils.deleteWhitespace(importDTO.getMaterial()));
      importDTO.setSpecification(org.apache.commons.lang3.StringUtils.deleteWhitespace(importDTO.getSpecification()));
      importDTO.setDrawingNumber(org.apache.commons.lang3.StringUtils.deleteWhitespace(importDTO.getDrawingNumber()));
   }

   private List<AssembleDTOParam> transitionImportList(List<AssembleImportDTO> importDTOList, List<MistakeExportDTO> mistakeExportDTOList) {
      List<MistakeExportDTO> mistakeExportDTOS = this.checkField(importDTOList);
      if (CollectionUtils.isNotEmpty(mistakeExportDTOS)) {
         mistakeExportDTOList.addAll(mistakeExportDTOS);
         return new ArrayList<>();
      }

      int size = importDTOList.size();
      List<AssembleDTOParam> assembleDTOParamList = new ArrayList<>(size);
      AssembleDTOParam assembleDTOParam = null;
      List<AssembleMachinePartDTOParam> machinePartParamList = null;

      for (int i = 0; i < size; i++) {
         AssembleImportDTO importDTO = importDTOList.get(i);
         this.delWhite(importDTO);
         if (org.apache.commons.lang3.StringUtils.isNotBlank(importDTO.getArtifactNo())) {
            if (assembleDTOParam != null) {
               assembleDTOParamList.add(assembleDTOParam);
            }

            assembleDTOParam = BeanUtil.copy(importDTO, AssembleDTOParam.class);
            machinePartParamList = new ArrayList<>();
         } else {
            if (assembleDTOParam == null) {
               assembleDTOParam = new AssembleDTOParam();
            }

            if (machinePartParamList == null) {
               machinePartParamList = new ArrayList<>();
            }

            AssembleMachinePartDTOParam machinePartDTOParam = BeanUtil.copy(importDTO, AssembleMachinePartDTOParam.class);
            machinePartParamList.add(machinePartDTOParam);
            assembleDTOParam.setMachinePartParamList(machinePartParamList);
            if (i == size - 1) {
               assembleDTOParamList.add(assembleDTOParam);
            }
         }
      }

      return assembleDTOParamList;
   }

   private List<MistakeExportDTO> checkField(List<AssembleImportDTO> importDTOS) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>();
      if (org.apache.commons.lang3.StringUtils.isBlank(importDTOS.get(0).getArtifactNo())) {
         mistakeExportDTOList.add(this.getMistakeDTO(importDTOS.get(0).getOrderNo(), "首行必须是部件"));
      }

      importDTOS.forEach(importDTO -> {
         Integer orderNo = importDTO.getOrderNo();
         String artifactNo = importDTO.getArtifactNo();
         String serialNumber = importDTO.getSerialNumber();
         if (org.apache.commons.lang3.StringUtils.isBlank(artifactNo) && org.apache.commons.lang3.StringUtils.isBlank(serialNumber)) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "构件号和编号都为空"));
         } else if (org.apache.commons.lang3.StringUtils.isBlank(serialNumber)) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "编号为空"));
         }

         if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getSpecification())) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "规格为空"));
         }

         if (importDTO.getLength() == null) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "长度为空"));
         } else if (importDTO.getLength().compareTo(BigDecimal.ZERO) <= 0) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "长度不合法"));
         }

         if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getMaterial())) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "材质为空"));
         }

         if (importDTO.getQuantity() == null) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "数量为空"));
         } else if (importDTO.getQuantity() <= 0) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "数量不合法"));
         }

         if (importDTO.getNetWeight() == null) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "单净重为空"));
         } else if (importDTO.getNetWeight().compareTo(BigDecimal.ZERO) <= 0) {
            mistakeExportDTOList.add(this.getMistakeDTO(orderNo, "单净重不合法"));
         }
      });
      return mistakeExportDTOList;
   }
}
