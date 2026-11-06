package com.hzchum.scim.plan.core.biz.impl.change;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.onecodeChange.MesBuildingOneCodeChangBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingTaskManager;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleExtTaskCargoDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.biz.change.TechChangeRecordBiz;
import com.hzchum.scim.plan.core.api.enums.AreaTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ArtifactChangeTypeEnum;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.enums.ChangeScopeEnum;
import com.hzchum.scim.plan.core.api.enums.ImportTypeEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryReviewedEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.manager.TechUtilManager;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecord;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactBasicChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeArtifactBasicUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeArtifactDelDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeArtifactUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordExPortDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ZnTechChangeImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechAreaProductInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.manager.TechConfigUtilsDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactBoxImportDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactMachinePartImportTemplateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactPartImportCommonDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactDelDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactUpdateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactUseDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeCheckDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeSaveDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeArtifactService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeMachinePartService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordDetailService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordService;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.plan.core.mapper.change.TechChangeRecordMapper;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.enums.SmallArtifactClassEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpecNumberLink;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysChangeReasonService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecNumberLinkService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechChangeRecordBizImpl extends IBizImpl<TechChangeRecordService, TechChangeRecordMapper, TechChangeRecord> implements TechChangeRecordBiz {
   private final RedisUtils redisUtils;
   private final AttachmentService attachmentService;
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final PlanAreaBatchService areaBatchService;
   private final SysStructureSpecService structureSpecService;
   private final SysStructureSpecNumberLinkService structureSpecNumberLinkService;
   private final SysAssembleSpecService assembleSpecService;
   private final SysSteelClassificationMatchService steelClassificationMatchService;
   private final TechArtifactService artifactService;
   private final BusinessArtifactService businessArtifactService;
   private final TechMachinePartService machinePartService;
   private final TechAssembleService assembleService;
   private final TechAssembleDetailService assembleDetailService;
   private final TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final TechDrawingService drawingService;
   private final TechMachineHoleRadiusLinkService machineHoleRadiusLinkService;
   private final TechArtifactExtService artifactExtService;
   private final TechAssembleExtService assembleExtService;
   private final SysChangeReasonService changeReasonService;
   private final TechChangeArtifactService changeArtifactService;
   private final TechChangeMachinePartService changeMachinePartService;
   private final TechChangeRecordDetailService changeRecordDetailService;
   private final List<String> SEND_DIRECTLY_MARK_LIST = Arrays.asList("直发件", "散发件", "发车件", "直发", "散发");
   private final MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   private final MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager;
   private final MesBuildingOneCodeChangBiz mesBuildingOneCodeChangBiz;
   private final SysStructureClassificationService structureClassificationService;
   private final MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   private final MesBuildingTaskBiz mesBuildingTaskBiz;
   private final MesBuildingProductProcessService productProcessService;
   private final TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   private final TechStandardPartService standardPartService;
   private final MesTechInventoryOperationService inventoryOperationService;
   private final MonomerUserLinkService monomerUserLinkService;
   private final List<String> ASSEMBLE_PART_CODE_LIST = Arrays.asList("翼板", "腹板");
   @Resource
   private TechUtilManager techUtilManager;
   private final SysPushFlowConfigBiz sysPushFlowConfigBiz;
   private final NotificationTemplateDetailsUtils detailsUtils;
   private final MesTechInventoryOperationService mesTechInventoryOperationService;
   private final TechChangeRecordService changeRecordService;
   private final MesBuildingTaskManager taskManager;
   private final TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;
   private final TechCappCraftCardProductLinkBiz techCappCraftCardProductLinkBiz;
   private final MoveOutboundDetailService outboundDetailService;

   @Override
   public PageVO<ArtifactResponseDTO> pageListArtifact(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer artifactType,
      String name,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactResponseDTO> responseDTOList = this.artifactService
         .listByCondition(projectId, monomerId, areaId, areaBatchId, null, name, serialNumber, null, null, null, artifactType, null, null);
      if (CollectionUtils.isNotEmpty(responseDTOList)) {
         responseDTOList.forEach(responseDTO -> {
            if (responseDTO.getSurfaceArea() != null) {
               responseDTO.setSurfaceArea(responseDTO.getSurfaceArea().divide(new BigDecimal(1000000), 3, RoundingMode.HALF_UP));
            }
         });
      }

      return new PageVO<>(responseDTOList);
   }

   @Override
   public TechChangeImportDTO importChangeArtifactList(Long monomerId, MultipartFile multipartFile) {
      return null;
   }

   @Override
   public ZnTechChangeImportDTO importChangeArtifactListV2(Long monomerId, MultipartFile multipartFile, HttpServletResponse response) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      this.projectService.checkProjectStatus(monomer.getProjectId());
      if (!UserUtil.getCurrentUser().isAdmin()) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, monomerId));
         List<Long> deepenedPersonIds = monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList());
         if (!deepenedPersonIds.contains(UserUtil.getCurrentUserId())) {
            mistakeExportDTOList.add(TechUtils.buildMistakeDTO("您不是该单体深化负责人,不允许导入文件!"));
            TechUtils.exportMistakeListV3(mistakeExportDTOList, response);
            return null;
         }
      }

      TechConfigUtilsDTO utilsDTO = this.techUtilManager.getTechConfigUtilsDto(BuildingTypeEnum.getMesProductTypeByType(monomer.getBuildingTypeEnum()));
      List<ArtifactBoxImportDTO> artifactBoxDtoParamList = this.techUtilManager
         .getArtifactBoxImportDTOS(
            multipartFile, monomer.getBuildingTypeEnum(), response, mistakeExportDTOList, utilsDTO, monomerId, ImportTypeEnum.REUTILIZATION.getType()
         );
      if (!CollectionUtils.isNotEmpty(mistakeExportDTOList) && !CollectionUtils.isEmpty(artifactBoxDtoParamList)) {
         String key = monomerId + "_" + System.currentTimeMillis();
         this.redisUtils.set(key, artifactBoxDtoParamList, 86400L);
         ZnTechChangeImportDTO changeImportDTO = new ZnTechChangeImportDTO();
         changeImportDTO.setRedisKey(key);
         changeImportDTO.setArtifactList(artifactBoxDtoParamList);
         return changeImportDTO;
      } else {
         TechUtils.exportMistakeListV3(mistakeExportDTOList, response);
         return null;
      }
   }

   @Override
   public List<TechArtifactChangeDetailDTO> listChangeArtifactDetail(TechChangeQueryDtoParam param) {
      param.setGroupIds(param.getGroupIds() == null ? new ArrayList<>() : param.getGroupIds());
      List<TechArtifact> artifactList = this.artifactService.listByIds(param.getArtifactIds());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactList) && artifactList.size() == param.getArtifactIds().size(), "构件ID有误!");
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, param.getArtifactIds())
               .eq(param.getAreaId() != null, TechArtifactExt::getAreaId, param.getAreaId())
               .orderByAsc(TechArtifactExt::getArtifactId)
               .orderByAsc(TechArtifactExt::getSortNumber)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtList), "构件ID有误!");
      Set<Long> artifactIds = artifactExtList.stream().map(TechArtifactExt::getArtifactId).collect(Collectors.toSet());
      Preconditions.checkArgument(artifactIds.size() == param.getArtifactIds().size(), "构件ID有误!");
      Map<Long, NameInfo> areaMap = this.areaService
         .listByIds(artifactExtList.stream().map(TechArtifactExt::getAreaId).collect(Collectors.toSet()))
         .stream()
         .map(area -> BeanUtil.copy(area, NameInfo.class))
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExtList.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      Map<Long, TechArtifact> allArtifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<ArtifactStatusDTO> statusDTOS = this.taskManager.listBatchArtifactStatus(allArtifactMap, artifactExtMap);
      Map<String, ArtifactStatusDTO> artifactStatusDTOMap = statusDTOS.stream()
         .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getNumber(), Function.identity(), (s1, s2) -> s1));
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(artifactIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<NumberInfoDTO> numberInfoDTOS = artifactExtList.stream()
         .map(e -> NumberInfoDTO.builder().productId(e.getArtifactId()).number(e.getSortNumber()).build())
         .collect(Collectors.toList());
      List<MesBuildingAssembleExtTaskCargoDTO> allResult = new ArrayList<>();
      if (!CollectionUtils.isEmpty(numberInfoDTOS)) {
         int total = numberInfoDTOS.size();

         for (int i = 0; i < total; i += 50) {
            int end = Math.min(i + 50, total);
            List<NumberInfoDTO> subBatch = numberInfoDTOS.subList(i, end);
            List<MesBuildingAssembleExtTaskCargoDTO> batchData = this.mesBuildingTaskNumberLinkService.listAssembleExtWarehouseStatusList(subBatch);
            allResult.addAll(batchData);
         }
      }

      Map<String, List<MesBuildingAssembleExtTaskCargoDTO>> assembleExtTaskCargoDTOMap = allResult.stream()
         .collect(Collectors.groupingBy(e -> e.getArtifactId() + "-" + e.getArtifactNumber()));
      List<TechArtifactChangeDetailDTO> collect = artifactExtList.stream()
         .map(
            ext -> {
               TechArtifact artifact = artifactMap.get(ext.getArtifactId());
               TechArtifactChangeDetailDTO changeDetailDTO = BeanUtil.copy(ext, TechArtifactChangeDetailDTO.class);
               changeDetailDTO.setArea(areaMap.get(ext.getAreaId()));
               ArtifactStatusDTO artifactStatusDTO = artifactStatusDTOMap.get(ext.getArtifactId() + "-" + ext.getSortNumber());
               Preconditions.checkArgument(artifactStatusDTO != null, "产品信息有误!!!");
               changeDetailDTO.setStatus(artifactStatusDTO.getProcessName());
               changeDetailDTO.setBoolCargo(!artifactStatusDTO.getBoolCargo());
               changeDetailDTO.setProductionLine(NameInfo.builder().name(artifactStatusDTO.getLineName()).build());
               changeDetailDTO.setStructureClassId(artifact.getStructureClassId());
               changeDetailDTO.setBoolAllPartSendDirectly(artifact.getBoolAllPartSendDirectly());
               changeDetailDTO.setMaterial(artifact.getMaterial());
               changeDetailDTO.setTeam(
                  NameInfo.builder()
                     .id(artifactStatusDTO.getTeamId())
                     .name(
                        StringUtils.isBlank(artifactStatusDTO.getLeaderName())
                           ? "-"
                           : artifactStatusDTO.getLeaderName() + "-" + artifactStatusDTO.getProcessName()
                     )
                     .build()
               );
               List<MesBuildingAssembleExtTaskCargoDTO> assembleExtTaskCargoDTOS = assembleExtTaskCargoDTOMap.get(
                  ext.getArtifactId() + "-" + ext.getSortNumber()
               );
               if (CollectionUtils.isNotEmpty(assembleExtTaskCargoDTOS) && !changeDetailDTO.getBoolCargo()) {
                  changeDetailDTO.setBoolCargo(assembleExtTaskCargoDTOS.stream().allMatch(e -> WarehouseRecordStatusTypeEnum.INTO.getType() == e.getStatus()));
               }

               return changeDetailDTO;
            }
         )
         .filter(e -> CollectionUtils.isEmpty(param.getGroupIds()) ? Boolean.TRUE : param.getGroupIds().contains(e.getTeam().getId()))
         .collect(Collectors.toList());
      return collect.stream().sorted(Comparator.comparing(TechArtifactChangeDetailDTO::getBoolCargo).reversed()).collect(Collectors.toList());
   }

   @Override
   public List<TechChangeMachinePartDTO> listMachinePart(Long monomerId, String serialNumber) {
      List<TechArtifact> artifactList = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(monomerId).serialNumber(serialNumber).build()));
      List<TechChangeMachinePartDTO> changeMachinePartDTOList = new ArrayList<>(Collections.emptyList());
      if (CollectionUtils.isNotEmpty(artifactList)) {
         TechArtifact artifact = artifactList.iterator().next();
         List<TechArtifactMachinePartLink> machinePartLinkList = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.builder().artifactId(artifact.getId()).build()));
         if (CollectionUtils.isNotEmpty(machinePartLinkList)) {
            Map<Long, TechMachinePart> machinePartMap = this.machinePartService
               .listByIds(machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            List<TechChangeMachinePartDTO> collect = machinePartLinkList.stream()
               .map(
                  link -> {
                     TechMachinePart machinePart = machinePartMap.get(link.getMachinePartId());
                     TechChangeMachinePartDTO dto = BeanUtil.copy(machinePart, TechChangeMachinePartDTO.class);
                     dto.setQuantity(link.getQuantity());
                     dto.setTotalNetWeight(dto.getNetWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
                     dto.setTotalGrossWeight(dto.getGrossWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
                     dto.setSurfaceArea(
                        machinePart.getSurfaceArea() != null
                           ? machinePart.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP)
                           : BigDecimal.ZERO
                     );
                     return dto;
                  }
               )
               .collect(Collectors.toList());
            changeMachinePartDTOList.addAll(collect);
         }

         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            Map<Long, TechAssemble> assembleMap = this.assembleService
               .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            List<TechChangeMachinePartDTO> collect = assembleDetailList.stream()
               .map(
                  link -> {
                     TechAssemble assemble = assembleMap.get(link.getAssembleId());
                     TechChangeMachinePartDTO dto = BeanUtil.copy(assemble, TechChangeMachinePartDTO.class);
                     dto.setQuantity(link.getQuantity());
                     dto.setTotalNetWeight(dto.getNetWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
                     dto.setTotalGrossWeight(dto.getGrossWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
                     dto.setSurfaceArea(
                        assemble.getSurfaceArea() != null
                           ? assemble.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP)
                           : BigDecimal.ZERO
                     );
                     return dto;
                  }
               )
               .collect(Collectors.toList());
            changeMachinePartDTOList.addAll(collect);
         }
      }

      return changeMachinePartDTOList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean commitChangeRecord(TechChangeSaveDtoParam param) {
      this.inventoryOperationService
         .checkInventoryOperationByMonomerId(
            param.getMonomerId(), Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType())
         );
      ContractProject project = this.checkParam(param);
      String yearMonthDay = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
      int sortNumber = this.baseService.getSortNumber(project.getId(), yearMonthDay);
      String serialNumber = "变-" + project.getShortName() + "-" + yearMonthDay + "-" + sortNumber;
      TechChangeRecord changeRecord = BeanUtil.copy(param, TechChangeRecord.class);
      changeRecord.setProjectId(project.getId());
      changeRecord.setYearMonthDay(yearMonthDay);
      changeRecord.setSortNumber(sortNumber);
      changeRecord.setSerialNumber(serialNumber);
      if (CollectionUtils.isNotEmpty(param.getUpdateArtifactList())) {
         changeRecord.setType(ArtifactChangeTypeEnum.UPDATE.getType());
      }

      if (CollectionUtils.isNotEmpty(param.getDelArtifactList())) {
         changeRecord.setType(ArtifactChangeTypeEnum.DEL.getType());
      }

      if (Objects.nonNull(param.getArtifactBasicChangeDTOParam())) {
         changeRecord.setChangeScopeEnum(ChangeScopeEnum.AREA.getType());
         changeRecord.setType(ArtifactChangeTypeEnum.UPDATE_BASIC.getType());
      }

      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         changeRecord.setChangeAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      }

      changeRecord.setUserId(UserUtil.getCurrentUserId());
      changeRecord.setCheckStatus(CheckStatusEnum.PENDING.getType());
      this.baseService.save(changeRecord);
      PlanMonomer monomer = this.monomerService.getById(changeRecord.getMonomerId());
      Integer mesProductEnum = MesProductEnum.BUILDING.getType();
      if (monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.BRIDGE.getType())) {
         mesProductEnum = MesProductEnum.BRIDGE.getType();
      }

      this.changeUpdate(param.getRedisKey(), changeRecord, param.getUpdateArtifactList(), mesProductEnum);
      this.changeDel(changeRecord.getId(), param.getDelArtifactList());
      this.changeBasicUpdtae(param, changeRecord);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean commitChangeRecordV2(TechChangeSaveDtoParam param) {
      ContractProject project = this.checkParam(param);
      String yearMonthDay = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
      int sortNumber = this.baseService.getSortNumber(project.getId(), yearMonthDay);
      String serialNumber = "变-" + project.getShortName() + "-" + yearMonthDay + "-" + sortNumber;
      TechChangeRecord changeRecord = BeanUtil.copy(param, TechChangeRecord.class);
      changeRecord.setProjectId(project.getId());
      changeRecord.setYearMonthDay(yearMonthDay);
      changeRecord.setSortNumber(sortNumber);
      changeRecord.setSerialNumber(serialNumber);
      if (param.getChangeScopeEnum().equals(ChangeScopeEnum.AREA_BATCH.getType())) {
         PlanAreaBatch areaBatch = this.areaBatchService.getById(param.getAreaBatchId());
         Preconditions.checkArgument(areaBatch != null, "操作失败,批次不存在!");
         changeRecord.setAreaId(areaBatch.getAreaId());
      }

      if (CollectionUtils.isNotEmpty(param.getUpdateArtifactList())) {
         changeRecord.setType(ArtifactChangeTypeEnum.UPDATE.getType());
      }

      if (CollectionUtils.isNotEmpty(param.getDelArtifactList())) {
         changeRecord.setType(ArtifactChangeTypeEnum.DEL.getType());
      }

      if (Objects.nonNull(param.getArtifactBasicChangeDTOParam())) {
         changeRecord.setChangeScopeEnum(ChangeScopeEnum.AREA.getType());
         changeRecord.setType(ArtifactChangeTypeEnum.UPDATE_BASIC.getType());
      }

      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         changeRecord.setChangeAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      }

      changeRecord.setUserId(UserUtil.getCurrentUserId());
      changeRecord.setCheckStatus(CheckStatusEnum.PENDING.getType());
      this.baseService.save(changeRecord);
      this.changeUpdateV2(param.getRedisKey(), changeRecord, param.getUpdateArtifactList());
      this.changeDel(changeRecord.getId(), param.getDelArtifactList());
      this.changeBasicUpdtae(param, changeRecord);
      return Boolean.TRUE;
   }

   private void changeBasicUpdtae(TechChangeSaveDtoParam param, TechChangeRecord changeRecord) {
      if (Objects.nonNull(param.getArtifactBasicChangeDTOParam())) {
         ArtifactBasicChangeDTOParam basicChangeDTOParam = param.getArtifactBasicChangeDTOParam();
         TechArtifact artifact = this.artifactService.getById(basicChangeDTOParam.getId());
         Preconditions.checkArgument(artifact != null, "操作失败,改构件不存在");
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败,改构件状态已暂停,不可变更");
         Preconditions.checkArgument(basicChangeDTOParam.getQuantity() >= artifact.getQuantity(), "操作失败,仅支持追加数量!!!");
         boolean boolChangeWeight = artifact.getNetWeight().compareTo(basicChangeDTOParam.getNetWeight()) != 0
            || artifact.getGrossWeight().compareTo(basicChangeDTOParam.getGrossWeight()) != 0
            || artifact.getLength().compareTo(basicChangeDTOParam.getLength()) != 0
            || artifact.getSurfaceArea().compareTo(basicChangeDTOParam.getSurfaceArea()) != 0;
         boolean boolChangeName = artifact.getName().equals(basicChangeDTOParam.getName());
         boolean boolChangePrintedCode = StringUtils.equals(artifact.getPrintedCode(), basicChangeDTOParam.getPrintedCode());
         Preconditions.checkArgument(
            boolChangeWeight || !boolChangeName || !basicChangeDTOParam.getQuantity().equals(artifact.getQuantity()) || !boolChangePrintedCode, "构件数据未做修改!"
         );
         Preconditions.checkArgument(
            !boolChangeWeight || basicChangeDTOParam.getGrossWeight().compareTo(basicChangeDTOParam.getNetWeight()) >= 0, "构件毛重不能小于构件净重!"
         );
         List<MesBuildingWarehouseSummary> warehouseSummaryList = this.mesBuildingWarehouseSummaryService
            .list(
               Wrappers.lambdaQuery(
                  MesBuildingWarehouseSummary.builder()
                     .productId(basicChangeDTOParam.getId())
                     .type(WarehouseTypeEnum.INTO.getType())
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .build()
               )
            );
         int sumPackageQuantity = warehouseSummaryList.stream().mapToInt(s -> s.getPackageQuantity().intValue()).sum();
         int sumCargoQuantity = warehouseSummaryList.stream().mapToInt(s -> s.getCargoQuantity().intValue()).sum();
         Preconditions.checkArgument(sumPackageQuantity + sumCargoQuantity == 0 || !boolChangeWeight, "构件已打包或者装车发运,不能变更重量/长度!");
         List<TechArtifactExt> artifactExts = this.artifactExtService
            .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getArtifactId, basicChangeDTOParam.getId()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,构件一物一码序号不存在!!!");
         Preconditions.checkArgument(artifactExts.stream().allMatch(TechArtifactExt::getBoolStatusEnum), "操作失败,存在暂停状态的一物一码序号!!!");
         TechChangeRecordDetail changeRecordDetail = BeanUtil.copy(artifact, TechChangeRecordDetail.class);
         changeRecordDetail.setChangeRecordId(changeRecord.getId());
         changeRecordDetail.setType(changeRecord.getType());
         changeRecordDetail.setArtifactId(artifact.getId());
         changeRecordDetail.setChangeQuantity(basicChangeDTOParam.getQuantity());
         changeRecordDetail.setChangeLength(basicChangeDTOParam.getLength());
         changeRecordDetail.setChangeNetWeight(basicChangeDTOParam.getNetWeight());
         changeRecordDetail.setChangeGrossWeight(basicChangeDTOParam.getGrossWeight());
         changeRecordDetail.setChangeSurfaceArea(basicChangeDTOParam.getSurfaceArea());
         changeRecordDetail.setChangeName(basicChangeDTOParam.getName());
         changeRecordDetail.setChangePrintedCode(basicChangeDTOParam.getPrintedCode());
         this.changeRecordDetailService.save(changeRecordDetail);
         if (!boolChangeWeight && boolChangeName) {
            changeRecord.setCheckStatus(CheckStatusEnum.PASS.getType());
            this.baseService.updateById(changeRecord);
            this.mesBuildingCalcMaxNumManager.changeArtifact(artifact, basicChangeDTOParam);
         } else {
            artifact.setBoolStatusEnum(Boolean.FALSE);
            artifactExts.forEach(e -> {
               e.setBoolStatusEnum(Boolean.FALSE);
               this.artifactExtService.updateById(e);
            });
            this.artifactService.updateById(artifact);
         }
      }
   }

   @Override
   public PageVO<TechChangeRecordDTO> pageListChangeRecord(TechChangeRecordQueryVoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechChangeRecordDTO> changeRecordList = this.baseService.listChangeRecord(param);
      if (CollectionUtils.isNotEmpty(changeRecordList)) {
         List<Long> changeRecordIds = changeRecordList.stream().map(TechChangeRecordDTO::getId).collect(Collectors.toList());
         Map<Long, List<TechChangeRecordDetail>> changeRecordIdDetailListMap = this.changeRecordDetailService
            .list(Wrappers.lambdaQuery(TechChangeRecordDetail.class).in(TechChangeRecordDetail::getChangeRecordId, changeRecordIds))
            .stream()
            .collect(Collectors.groupingBy(TechChangeRecordDetail::getChangeRecordId));
         Map<Long, Map<String, TechChangeArtifact>> changeRecordIdChangeArtifactSnMap = this.changeArtifactService
            .list(Wrappers.lambdaQuery(TechChangeArtifact.class).in(TechChangeArtifact::getChangeRecordId, changeRecordIds))
            .stream()
            .collect(Collectors.groupingBy(TechChangeArtifact::getChangeRecordId, Collectors.toMap(TechChangeArtifact::getSerialNumber, Function.identity())));
         changeRecordList.forEach(
            dto -> {
               List<TechChangeRecordDetail> changeRecordDetails = changeRecordIdDetailListMap.get(dto.getId());
               Map<String, TechChangeArtifact> changeArtifactSnMap = changeRecordIdChangeArtifactSnMap.get(dto.getId());
               List<TechChangeArtifactUpdateDTO> updateArtifactList = new ArrayList<>(16);
               List<TechChangeArtifactDelDTO> delArtifactList = new ArrayList<>(16);
               List<TechChangeArtifactBasicUpdateDTO> updateBasicDTOList = new ArrayList<>(16);
               changeRecordDetails.forEach(
                  de -> {
                     if (de.getType().equals(ArtifactChangeTypeEnum.UPDATE.getType())) {
                        TechChangeArtifactUpdateDTO updateDTO = BeanUtil.copy(de, TechChangeArtifactUpdateDTO.class);
                        updateDTO.setSurfaceArea(de.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP));
                        TechChangeArtifact changeArtifact = changeArtifactSnMap.get(de.getChangeSerialNumber());
                        updateDTO.setChangeLength(changeArtifact.getLength());
                        updateDTO.setChangeNetWeight(changeArtifact.getNetWeight());
                        updateDTO.setChangeGrossWeight(changeArtifact.getGrossWeight());
                        updateDTO.setChangeSurfaceArea(changeArtifact.getSurfaceArea());
                        updateDTO.setChangeName(changeArtifact.getName());
                        updateArtifactList.add(updateDTO);
                     }

                     if (de.getType().equals(ArtifactChangeTypeEnum.DEL.getType())) {
                        TechChangeArtifactDelDTO delDTO = BeanUtil.copy(de, TechChangeArtifactDelDTO.class);
                        delDTO.setSurfaceArea(
                           de.getSurfaceArea() != null ? de.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, RoundingMode.HALF_UP) : BigDecimal.ZERO
                        );
                        delDTO.setName(de.getName());
                        delArtifactList.add(delDTO);
                     }

                     if (de.getType().equals(ArtifactChangeTypeEnum.UPDATE_BASIC.getType())) {
                        TechChangeArtifactBasicUpdateDTO artifactBasicUpdateDTO = BeanUtil.copy(de, TechChangeArtifactBasicUpdateDTO.class);
                        updateBasicDTOList.add(artifactBasicUpdateDTO);
                     }
                  }
               );
               dto.setUpdateArtifactList(updateArtifactList);
               dto.setDelArtifactList(delArtifactList);
               dto.setArtifactBasicUpdateDTOList(updateBasicDTOList);
               dto.setChangeAttachmentList(this.attachmentService.listByIds(dto.getChangeAttachmentIds()));
            }
         );
      }

      return new PageVO<>(changeRecordList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean checkChange(TechChangeCheckDtoParam param) {
      TechChangeRecord changeRecord = this.baseService.getById(param.getId());
      Preconditions.checkArgument(changeRecord != null, "变更记录不存在!");
      Preconditions.checkArgument(changeRecord.getCheckStatus().equals(CheckStatusEnum.PENDING.getType()), "变更记录已审核!");
      BeanUtil.copy(param, changeRecord);
      changeRecord.setCheckUserId(UserUtil.getCurrentUserId());
      changeRecord.setCheckTime(LocalDateTime.now());
      this.baseService.updateById(changeRecord);
      if (param.getCheckStatus().equals(CheckStatusEnum.FAIL.getType()) || param.getCheckStatus().equals(CheckStatusEnum.CANCEL.getType())) {
         this.checkFail(changeRecord.getId());
      }

      if (param.getCheckStatus().equals(CheckStatusEnum.PASS.getType())) {
         this.checkPass(changeRecord);
         int count = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(changeRecord.getMonomerId()).build()));
         if (count == 0) {
            PlanMonomer monomer = PlanMonomer.builder().id(changeRecord.getMonomerId()).buildingTypeEnum(BuildingTypeEnum.UNKNOWN.getType()).build();
            this.monomerService.updateById(monomer);
         }

         long projectId = ObjectUtils.isNotEmpty(changeRecord.getProjectId()) ? changeRecord.getProjectId() : 0L;
         long monomerId = ObjectUtils.isNotEmpty(changeRecord.getMonomerId()) ? changeRecord.getMonomerId() : 0L;
         long areaId = ObjectUtils.isNotEmpty(changeRecord.getAreaId()) ? changeRecord.getAreaId() : 0L;
         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(projectId)
                  .monomerId(monomerId)
                  .contentDetails(this.detailsUtils.getDetailedChangeTemplateDetails(projectId, monomerId, areaId, "构件"))
                  .areaId(areaId)
                  .notificationTypeEnum(NotificationModuleTypeEnum.CREATE_DETAILED.getNotificationType())
                  .userList(new ArrayList<>())
                  .build()
            );
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importListDirectChange(
      Long monomerId, Long areaId, Integer inventoryTypeEnum, Long changeReasonId, String remark, MultipartFile file, HttpServletResponse response
   ) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);

      ContractProject project;
      PlanMonomer monomer;
      try {
         PlanArea area = this.areaService.getById(areaId);
         Preconditions.checkArgument(area != null, "区域不存在!");
         monomer = this.monomerService.getById(monomerId);
         Preconditions.checkArgument(monomer != null, "单体不存在!");
         Preconditions.checkArgument(area.getMonomerId().equals(monomerId), "操作失败,所选区域和单体不一致!");
         this.mesTechInventoryOperationService
            .checkInventoryOperationByMonomerId(
               monomerId, Arrays.asList(InventoryReviewedEnum.FIXUP_RECORD.getType(), InventoryReviewedEnum.UNAUDITED.getType())
            );
         this.changeRecordService.checkExistsChangeRecord(monomerId);
         project = this.projectService.checkProjectStatus(area.getProjectId());
         this.changeRecordService.checkChangeRecordByMonomerId(monomerId);
      } catch (Exception exception) {
         mistakeExportDTOList.add(TechUtils.buildMistakeDTO(exception.getMessage()));
         TechUtils.exportMistakeList(mistakeExportDTOList, response);
         return;
      }

      List<ArtifactMachinePartImportTemplateDtoParam> importDTOS;
      try {
         importDTOS = PoiUtils.importExcel(file, 1, 1, 0, ArtifactMachinePartImportTemplateDtoParam.class);
      } catch (Exception e) {
         mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,Excel文件格式出现异常!"));
         TechUtils.exportMistakeList(mistakeExportDTOList, response);
         return;
      }

      importDTOS = importDTOS.stream().filter(e -> e.getOrderNo() != null).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(importDTOS)) {
         mistakeExportDTOList.add(TechUtils.buildMistakeDTO("导入失败,导入的表单不能为空!"));
         TechUtils.exportMistakeList(mistakeExportDTOList, response);
      } else {
         TechAreaProductInfoDTO areaProductInfo = this.techUtilManager.getAreaProductInfo(areaId);
         TechConfigUtilsDTO utilsDTO = this.techUtilManager.getTechConfigUtilsDto(inventoryTypeEnum);
         List<ArtifactBoxImportDTO> artifactBoxDtoParamList = this.techUtilManager
            .getArtifactBoxImportDTOS(file, inventoryTypeEnum, response, mistakeExportDTOList, utilsDTO, monomerId, ImportTypeEnum.REUTILIZATION.getType());
         if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
            TechUtils.exportMistakeList(mistakeExportDTOList, response);
         } else {
            List<String> artifactSerialNumberList = artifactBoxDtoParamList.stream()
               .map(ArtifactPartImportCommonDTO::getSerialNumber)
               .collect(Collectors.toList());
            List<TechArtifact> artifacts = this.artifactService
               .list(
                  (Wrapper<TechArtifact>)((new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, monomerId))
                        .eq(TechArtifact::getBuildingType, inventoryTypeEnum))
                     .in(TechArtifact::getSerialNumber, artifactSerialNumberList)
               );
            if (CollectionUtils.isEmpty(artifacts)) {
               mistakeExportDTOList.add(TechUtils.buildMistakeDTO("变更失败,清单内的构件编号在该单体下不存在!" + InventoryTypeEnum.getNameByType(inventoryTypeEnum)));
               TechUtils.exportMistakeList(mistakeExportDTOList, response);
            } else {
               Map<String, ArtifactBoxImportDTO> artifactBoxImportDTOMap = artifactBoxDtoParamList.stream()
                  .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
               List<TechArtifact> changeArtifactList = new ArrayList<>();

               for (TechArtifact artifact : artifacts) {
                  ArtifactBoxImportDTO artifactBoxImportDTO = artifactBoxImportDTOMap.get(artifact.getSerialNumber());
                  if (!artifactBoxImportDTO.getName().equals(artifact.getName())
                     || artifactBoxImportDTO.getLength().compareTo(artifact.getLength()) != 0
                     || artifactBoxImportDTO.getNetWeight().compareTo(artifact.getNetWeight()) != 0
                     || artifactBoxImportDTO.getGrossWeight().compareTo(artifact.getGrossWeight()) != 0
                     || artifactBoxImportDTO.getSurfaceArea().compareTo(artifact.getSurfaceArea()) != 0
                     || artifactBoxImportDTO.getQuantity() > artifact.getQuantity()
                     || !artifact.getPrintedCode().equals(artifactBoxImportDTO.getPrintedCode())) {
                     changeArtifactList.add(artifact);
                  }
               }

               if (CollectionUtils.isEmpty(changeArtifactList)) {
                  mistakeExportDTOList.add(TechUtils.buildMistakeDTO("变更失败,暂只支持构件的名称/长度/单净重/单毛重/面积/增加数量的变更"));
                  TechUtils.exportMistakeList(mistakeExportDTOList, response);
               } else {
                  List<Long> changeArtifactIds = changeArtifactList.stream().map(TechArtifact::getId).collect(Collectors.toList());
                  Map<Long, List<MesBuildingWarehouseSummary>> warehouseSummaryMap = this.mesBuildingWarehouseSummaryService
                     .list(
                        (Wrapper<MesBuildingWarehouseSummary>)((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                                 .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType()))
                              .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                           .in(MesBuildingWarehouseSummary::getProductId, changeArtifactIds)
                     )
                     .stream()
                     .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductId));
                  List<TechArtifactExt> artifactExtList = this.artifactExtService
                     .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().in(TechArtifactExt::getArtifactId, changeArtifactIds));
                  Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExtList.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
                  String yearMonthDay = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
                  int sortNumber = this.baseService.getSortNumber(project.getId(), yearMonthDay);
                  String serialNumber = "变-" + project.getShortName() + "-" + yearMonthDay + "-" + sortNumber;
                  TechChangeRecord changeRecord = TechChangeRecord.builder()
                     .projectId(project.getId())
                     .monomerId(monomer.getId())
                     .areaId(areaId)
                     .changeScopeEnum(ChangeScopeEnum.MONOMER.getType())
                     .serialNumber(serialNumber)
                     .changeReasonId(changeReasonId)
                     .remark(remark)
                     .userId(UserUtil.getCurrentUserId())
                     .yearMonthDay(yearMonthDay)
                     .sortNumber(sortNumber)
                     .type(ArtifactChangeTypeEnum.UPDATE_BASIC.getType())
                     .checkStatus(CheckStatusEnum.PENDING.getType())
                     .build();

                  for (TechArtifact artifact : changeArtifactList) {
                     ArtifactBoxImportDTO artifactBoxImportDTO = artifactBoxImportDTOMap.get(artifact.getSerialNumber());
                     boolean boolChangeWeight = artifact.getNetWeight().compareTo(artifactBoxImportDTO.getNetWeight()) != 0
                        || artifact.getGrossWeight().compareTo(artifactBoxImportDTO.getGrossWeight()) != 0
                        || artifact.getLength().compareTo(artifactBoxImportDTO.getLength()) != 0
                        || artifact.getSurfaceArea().compareTo(artifactBoxImportDTO.getSurfaceArea()) != 0;
                     boolean boolChangeName = artifact.getName().equals(artifactBoxImportDTO.getName());
                     if (artifactBoxImportDTO.getGrossWeight().compareTo(artifactBoxImportDTO.getNetWeight()) < 0) {
                        mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxImportDTO.getOrderNo(), "导入的清单构件毛重不能小于构件净重!"));
                     }

                     if (boolChangeWeight) {
                        int sumPackageQuantity = warehouseSummaryMap.getOrDefault(artifact.getId(), new ArrayList<>())
                           .stream()
                           .mapToInt(s -> s.getPackageQuantity().intValue())
                           .sum();
                        int sumCargoQuantity = warehouseSummaryMap.getOrDefault(artifact.getId(), new ArrayList<>())
                           .stream()
                           .mapToInt(s -> s.getCargoQuantity().intValue())
                           .sum();
                        if (sumPackageQuantity + sumCargoQuantity > 0) {
                           mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxImportDTO.getOrderNo(), "构件已打包或者装车发运,不能变更重量/长度!"));
                        }
                     }

                     List<TechArtifactExt> artifactExts = artifactExtMap.get(artifact.getId());
                     if (CollectionUtils.isEmpty(artifactExts)) {
                        mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxImportDTO.getOrderNo(), "操作失败,构件一物一码序号不存在!"));
                     }

                     if (!artifactExts.stream().allMatch(TechArtifactExt::getBoolStatusEnum)) {
                        mistakeExportDTOList.add(new MistakeExportDTO(artifactBoxImportDTO.getOrderNo(), "操作失败,存在暂停状态的一物一码序号!"));
                     }
                  }

                  if (CollectionUtils.isEmpty(mistakeExportDTOList) && CollectionUtils.isNotEmpty(changeArtifactList)) {
                     this.baseService.save(changeRecord);

                     for (TechArtifact artifact : changeArtifactList) {
                        ArtifactBoxImportDTO artifactBoxImportDTO = artifactBoxImportDTOMap.get(artifact.getSerialNumber());
                        List<TechArtifactExt> artifactExts = artifactExtMap.get(artifact.getId());
                        TechChangeRecordDetail changeRecordDetail = BeanUtil.copy(artifact, TechChangeRecordDetail.class);
                        changeRecordDetail.setChangeRecordId(changeRecord.getId());
                        changeRecordDetail.setType(changeRecord.getType());
                        changeRecordDetail.setArtifactId(artifact.getId());
                        changeRecordDetail.setChangeQuantity(artifactBoxImportDTO.getQuantity());
                        changeRecordDetail.setChangeLength(artifactBoxImportDTO.getLength());
                        changeRecordDetail.setChangeNetWeight(artifactBoxImportDTO.getNetWeight());
                        changeRecordDetail.setChangeGrossWeight(artifactBoxImportDTO.getGrossWeight());
                        changeRecordDetail.setChangeSurfaceArea(artifactBoxImportDTO.getSurfaceArea());
                        changeRecordDetail.setChangeName(artifactBoxImportDTO.getName());
                        changeRecordDetail.setChangePrintedCode(artifactBoxImportDTO.getPrintedCode());
                        this.changeRecordDetailService.save(changeRecordDetail);
                        artifact.setBoolStatusEnum(Boolean.FALSE);
                        artifactExts.forEach(e -> e.setBoolStatusEnum(Boolean.FALSE));
                        this.artifactExtService.updateBatchById(artifactExts);
                     }

                     this.artifactService.updateBatchById(changeArtifactList);
                  }

                  TechUtils.exportMistakeList(mistakeExportDTOList, response);
               }
            }
         }
      }
   }

   @Override
   public void exportChangeRecord(TechChangeRecordQueryVoParam param, Integer pageNumber, Integer pageSize, HttpServletResponse response) {
      PageVO<TechChangeRecordDTO> techChangeRecordDTOPageVO = this.pageListChangeRecord(param, pageNumber, pageSize);
      Map<String, Object> exportMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(techChangeRecordDTOPageVO.getContent())) {
         int orderNumber = 1;
         int index = 1;
         List<Integer> indexList = new ArrayList<>();
         List<Map<String, Object>> typeList = new ArrayList<>();
         List<TechChangeRecordExPortDTO> typesettingExportDOS = new ArrayList<>();

         for (TechChangeRecordDTO changeRecordDTO : techChangeRecordDTOPageVO.getContent()) {
            TechChangeRecordExPortDTO build = TechChangeRecordExPortDTO.builder()
               .id(changeRecordDTO.getId())
               .orderNumber(String.valueOf(orderNumber++))
               .projectName(changeRecordDTO.getProject().getShortName())
               .monomerName(changeRecordDTO.getMonomer().getName())
               .createTimeDate(DateUtil.format(changeRecordDTO.getCreateTime(), "yyyy-MM-dd"))
               .serialNumber(changeRecordDTO.getSerialNumber())
               .userName(changeRecordDTO.getUser().getName())
               .changeReasonName(changeRecordDTO.getChangeReason().getName())
               .checkUserName(changeRecordDTO.getCheckUserName())
               .checkStatusName(CheckStatusEnum.getNameByType(changeRecordDTO.getCheckStatus()))
               .build();
            List<String> artifactSerialNumberList = new ArrayList<>();
            List<TechChangeArtifactBasicUpdateDTO> artifactBasicUpdateDTOList = changeRecordDTO.getArtifactBasicUpdateDTOList();
            List<TechChangeArtifactDelDTO> delArtifactList = changeRecordDTO.getDelArtifactList();
            List<TechChangeArtifactUpdateDTO> updateArtifactList = changeRecordDTO.getUpdateArtifactList();
            if (CollectionUtils.isNotEmpty(artifactBasicUpdateDTOList)) {
               artifactSerialNumberList = artifactBasicUpdateDTOList.stream()
                  .map(TechChangeArtifactBasicUpdateDTO::getSerialNumber)
                  .distinct()
                  .collect(Collectors.toList());
            }

            if (CollectionUtils.isNotEmpty(delArtifactList)) {
               artifactSerialNumberList = delArtifactList.stream().map(TechChangeArtifactDelDTO::getSerialNumber).distinct().collect(Collectors.toList());
            }

            if (CollectionUtils.isNotEmpty(updateArtifactList)) {
               artifactSerialNumberList = updateArtifactList.stream().map(TechChangeArtifactUpdateDTO::getSerialNumber).distinct().collect(Collectors.toList());
            }

            if (CollectionUtils.isNotEmpty(artifactSerialNumberList)) {
               build.setArtifactNames(String.join(",", artifactSerialNumberList));
            }

            typesettingExportDOS.add(build);
            indexList.add(++index);
            if (CollectionUtils.isNotEmpty(artifactSerialNumberList)) {
               TechChangeRecordExPortDTO exPortDTO = TechChangeRecordExPortDTO.builder()
                  .orderNumber("")
                  .projectName("构件编号")
                  .monomerName("变更类型")
                  .createTimeDate("构件名称")
                  .serialNumber("数量")
                  .userName("规格")
                  .changeReasonName("长度")
                  .artifactNames("面积")
                  .checkUserName("材质")
                  .checkStatusName("单净重")
                  .build();
               typesettingExportDOS.add(exPortDTO);
               index++;
               if (CollectionUtils.isNotEmpty(delArtifactList)) {
                  index += delArtifactList.size();

                  for (TechChangeArtifactDelDTO techChangeArtifactDelDTO : delArtifactList) {
                     TechChangeRecordExPortDTO build1 = TechChangeRecordExPortDTO.builder()
                        .orderNumber("")
                        .projectName(techChangeArtifactDelDTO.getSerialNumber() + "(" + techChangeArtifactDelDTO.getSortNumber() + ")")
                        .monomerName("删除")
                        .createTimeDate(techChangeArtifactDelDTO.getName())
                        .serialNumber("1")
                        .userName(techChangeArtifactDelDTO.getSpecification())
                        .changeReasonName(techChangeArtifactDelDTO.getLength().toString())
                        .artifactNames(techChangeArtifactDelDTO.getSurfaceArea().toString())
                        .checkUserName(techChangeArtifactDelDTO.getMaterial())
                        .checkStatusName(techChangeArtifactDelDTO.getNetWeight().toString())
                        .build();
                     typesettingExportDOS.add(build1);
                  }
               }

               if (CollectionUtils.isNotEmpty(artifactBasicUpdateDTOList)) {
                  index += artifactBasicUpdateDTOList.size();

                  for (TechChangeArtifactBasicUpdateDTO techChangeArtifactDelDTO : artifactBasicUpdateDTOList) {
                     TechChangeRecordExPortDTO build1 = TechChangeRecordExPortDTO.builder()
                        .orderNumber("")
                        .projectName(techChangeArtifactDelDTO.getSerialNumber())
                        .monomerName("基础信息变更")
                        .createTimeDate(techChangeArtifactDelDTO.getName())
                        .serialNumber(techChangeArtifactDelDTO.getQuantity().toString())
                        .userName(techChangeArtifactDelDTO.getSpecification())
                        .changeReasonName(techChangeArtifactDelDTO.getLength().toString())
                        .artifactNames(techChangeArtifactDelDTO.getSurfaceArea().toString())
                        .checkUserName(techChangeArtifactDelDTO.getMaterial())
                        .checkStatusName(techChangeArtifactDelDTO.getNetWeight().toString())
                        .build();
                     if (!techChangeArtifactDelDTO.getName().equals(techChangeArtifactDelDTO.getChangeName())) {
                        build1.setCreateTimeDate(techChangeArtifactDelDTO.getName() + "->" + techChangeArtifactDelDTO.getChangeName());
                     }

                     if (!techChangeArtifactDelDTO.getQuantity().equals(techChangeArtifactDelDTO.getChangeQuantity())) {
                        build1.setSerialNumber(techChangeArtifactDelDTO.getQuantity() + "->" + techChangeArtifactDelDTO.getChangeQuantity().toString());
                     }

                     if (techChangeArtifactDelDTO.getLength().compareTo(techChangeArtifactDelDTO.getChangeLength()) != 0) {
                        build1.setChangeReasonName(techChangeArtifactDelDTO.getLength() + "->" + techChangeArtifactDelDTO.getLength().toString());
                     }

                     if (techChangeArtifactDelDTO.getSurfaceArea().compareTo(techChangeArtifactDelDTO.getChangeSurfaceArea()) != 0) {
                        build1.setArtifactNames(techChangeArtifactDelDTO.getSurfaceArea() + "->" + techChangeArtifactDelDTO.getChangeSurfaceArea());
                     }

                     if (techChangeArtifactDelDTO.getNetWeight().compareTo(techChangeArtifactDelDTO.getChangeNetWeight()) != 0) {
                        build1.setArtifactNames(techChangeArtifactDelDTO.getNetWeight().toString() + "->" + techChangeArtifactDelDTO.getChangeNetWeight());
                     }

                     typesettingExportDOS.add(build1);
                  }
               }

               if (CollectionUtils.isNotEmpty(updateArtifactList)) {
                  index += updateArtifactList.size();

                  for (TechChangeArtifactUpdateDTO techChangeArtifactDelDTO : updateArtifactList) {
                     TechChangeRecordExPortDTO build1 = TechChangeRecordExPortDTO.builder()
                        .orderNumber("")
                        .projectName(techChangeArtifactDelDTO.getSerialNumber() + "(" + techChangeArtifactDelDTO.getSortNumber() + ")")
                        .monomerName("二次利用变更")
                        .createTimeDate(techChangeArtifactDelDTO.getName())
                        .serialNumber("")
                        .userName(techChangeArtifactDelDTO.getSpecification())
                        .changeReasonName(techChangeArtifactDelDTO.getLength().toString())
                        .artifactNames(techChangeArtifactDelDTO.getSurfaceArea().toString())
                        .checkUserName(techChangeArtifactDelDTO.getMaterial())
                        .checkStatusName(techChangeArtifactDelDTO.getNetWeight().toString())
                        .build();
                     if (!techChangeArtifactDelDTO.getName().equals(techChangeArtifactDelDTO.getChangeName())) {
                        build1.setCreateTimeDate(techChangeArtifactDelDTO.getName() + "->" + techChangeArtifactDelDTO.getChangeName());
                     }

                     if (!techChangeArtifactDelDTO.getSerialNumber().equals(techChangeArtifactDelDTO.getChangeSerialNumber())
                        || !techChangeArtifactDelDTO.getSortNumber().equals(techChangeArtifactDelDTO.getChangeSortNumber())) {
                        build1.setProjectName(
                           techChangeArtifactDelDTO.getSerialNumber()
                              + "("
                              + techChangeArtifactDelDTO.getSortNumber()
                              + ")"
                              + techChangeArtifactDelDTO.getChangeSerialNumber()
                              + "("
                              + techChangeArtifactDelDTO.getChangeSortNumber()
                              + ")"
                        );
                     }

                     if (techChangeArtifactDelDTO.getLength().compareTo(techChangeArtifactDelDTO.getChangeLength()) != 0) {
                        build1.setChangeReasonName(techChangeArtifactDelDTO.getLength() + "->" + techChangeArtifactDelDTO.getLength().toString());
                     }

                     if (techChangeArtifactDelDTO.getSurfaceArea().compareTo(techChangeArtifactDelDTO.getChangeSurfaceArea()) != 0) {
                        build1.setArtifactNames(techChangeArtifactDelDTO.getSurfaceArea() + "->" + techChangeArtifactDelDTO.getChangeSurfaceArea());
                     }

                     if (techChangeArtifactDelDTO.getNetWeight().compareTo(techChangeArtifactDelDTO.getChangeNetWeight()) != 0) {
                        build1.setArtifactNames(techChangeArtifactDelDTO.getNetWeight().toString() + "->" + techChangeArtifactDelDTO.getChangeNetWeight());
                     }

                     typesettingExportDOS.add(build1);
                  }
               }
            }
         }

         for (TechChangeRecordExPortDTO typesettingDO : typesettingExportDOS) {
            Map<String, Object> typesettingMap = BeanUtil.beanToMap(typesettingDO);
            typeList.add(typesettingMap);
         }

         exportMap.put("typeList", typeList);

         try {
            String tempFileName = "TechChangeRecord";
            String resourcePath = "files/TechChangeRecord.xlsx";
            String exportFileName = "构件变更记录.xlsx";
            org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
            InputStream inputStream = resource.getInputStream();
            File file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
            TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
            params.setColForEach(true);
            Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
            Sheet sheetAt = workbook.getSheetAt(0);

            for (Integer indexNum : indexList) {
               for (Cell cell : sheetAt.getRow(indexNum)) {
                  Font font = workbook.createFont();
                  font.setFontName("宋体");
                  font.setFontHeightInPoints((short)12);
                  font.setBold(true);
                  CellStyle cellStyle = workbook.createCellStyle();
                  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                  cellStyle.setAlignment(HorizontalAlignment.CENTER);
                  cellStyle.setBorderBottom(BorderStyle.THIN);
                  cellStyle.setBorderTop(BorderStyle.THIN);
                  cellStyle.setBorderLeft(BorderStyle.THIN);
                  cellStyle.setBorderRight(BorderStyle.THIN);
                  cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                  cell.setCellStyle(cellStyle);
                  cellStyle.setFont(font);
               }
            }

            PoiUtils.downNoBuildCellLoadExcel(exportFileName, response, workbook);
         } catch (IOException e) {
            throw new BusinessException(ResultCodeEnum.ERROR, e.getMessage());
         }
      }
   }

   private void checkFail(Long changeRecordId) {
      List<TechChangeRecordDetail> recordDetailList = this.changeRecordDetailService
         .list(Wrappers.lambdaQuery(TechChangeRecordDetail.builder().changeRecordId(changeRecordId).build()));
      List<TechArtifact> artifactList = this.artifactService
         .listByIds(recordDetailList.stream().map(TechChangeRecordDetail::getArtifactId).collect(Collectors.toList()));
      artifactList.forEach(artifact -> {
         artifact.setBoolStatusEnum(Boolean.TRUE);
         this.artifactService.updateById(artifact);
      });
      recordDetailList.forEach(
         recordDetail -> {
            if (recordDetail.getType().equals(ArtifactChangeTypeEnum.UPDATE_BASIC.getType())) {
               List<TechArtifactExt> artifactExts = this.artifactExtService
                  .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getArtifactId, recordDetail.getArtifactId()));
               artifactExts.forEach(e -> {
                  e.setBoolStatusEnum(Boolean.TRUE);
                  this.artifactExtService.updateById(e);
               });
            } else {
               TechArtifactExt artifactExt = this.artifactExtService
                  .getOne(
                     Wrappers.lambdaQuery(TechArtifactExt.builder().artifactId(recordDetail.getArtifactId()).sortNumber(recordDetail.getSortNumber()).build())
                  );
               artifactExt.setBoolStatusEnum(true);
               this.artifactExtService.updateById(artifactExt);
            }
         }
      );
   }

   private void checkPass(TechChangeRecord changeRecord) {
      List<TechChangeRecordDetail> recordDetailList = this.changeRecordDetailService
         .list(Wrappers.lambdaQuery(TechChangeRecordDetail.builder().changeRecordId(changeRecord.getId()).build()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(recordDetailList), "操作失败,变更记录不存在!!!");
      Preconditions.checkArgument(recordDetailList.stream().allMatch(detail -> detail.getType().equals(changeRecord.getType())), "操作失败变更类型不一致");
      PlanMonomer monomer = this.monomerService.getById(changeRecord.getMonomerId());
      Integer mesProductEnum = BuildingTypeEnum.getMesProductTypeByType(monomer.getBuildingTypeEnum());
      if (!changeRecord.getType().equals(ArtifactChangeTypeEnum.UPDATE_BASIC.getType())) {
         Map<Long, List<Integer>> artifactIdSortNumberListMap = recordDetailList.stream()
            .collect(
               Collectors.groupingBy(TechChangeRecordDetail::getArtifactId, Collectors.mapping(TechChangeRecordDetail::getSortNumber, Collectors.toList()))
            );
         this.mesBuildingCalcMaxNumManager.checkArtifactNumberChanger(artifactIdSortNumberListMap, Boolean.TRUE);
         List<Long> artifactIds = recordDetailList.stream().map(TechChangeRecordDetail::getArtifactId).collect(Collectors.toList());
         List<TechArtifact> artifactList = this.artifactService.listByIds(artifactIds);
         Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<String, TechArtifactExt> artifactExtMap = this.artifactExtService
            .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().in(TechArtifactExt::getArtifactId, artifactIds))
            .stream()
            .collect(Collectors.toMap(e -> e.getArtifactId() + "-" + e.getSortNumber(), Function.identity()));
         Map<String, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = this.mesBuildingTaskNumberLinkService
            .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getArtifactId, artifactIds))
            .stream()
            .collect(Collectors.groupingBy(e -> e.getArtifactId() + "-" + e.getArtifactNumber()));
         List<Long> areaBatchIds = artifactList.stream().map(TechArtifact::getAreaBatchId).distinct().collect(Collectors.toList());
         Map<Long, TechMachinePart> machinePartMap = new HashMap<>();
         Map<Long, List<TechArtifactMachinePartLink>> machinePartLinkMap = new HashMap<>();
         Map<Long, List<TechArtifactStandardPartLink>> standardPartLinkMap = new HashMap<>();
         Map<Long, TechStandardPart> standardPartMap = new HashMap<>();
         Map<Long, TechAssemble> assembleMap = new HashMap<>();
         Map<Long, List<MesBuildingTaskNumberLink>> assembleNumberLinkMap = new HashMap<>();
         Map<Long, List<TechAssembleDetail>> assembleDetailMap = new HashMap<>();
         Map<Long, List<TechAssembleExt>> assembleExtMap = new HashMap<>();
         Map<Long, TechMachinePart> wingWebMachinePartMap = new HashMap<>();
         Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkMap = new HashMap<>();
         if (ArtifactChangeTypeEnum.DEL.getType().equals(changeRecord.getType())) {
            this.removeArtifactList(
               recordDetailList,
               artifactMap,
               artifactExtMap,
               taskNumberLinkMap,
               machinePartMap,
               machinePartLinkMap,
               assembleMap,
               assembleDetailMap,
               assembleExtMap,
               artifactIds,
               changeRecord.getType(),
               assembleNumberLinkMap,
               wingWebMachinePartMap,
               assembleMachinePartLinkMap,
               standardPartLinkMap,
               standardPartMap
            );
            if (CollectionUtils.isNotEmpty(areaBatchIds)) {
               for (Long areaBatchId : areaBatchIds) {
                  int areaBatchCount = this.artifactService.count(Wrappers.lambdaQuery(TechArtifact.builder().areaBatchId(areaBatchId).build()));
                  int outboundAreaBatchCount = this.outboundDetailService
                     .count(Wrappers.lambdaQuery(MoveOutboundDetail.class).eq(MoveOutboundDetail::getAreaBatchId, areaBatchId));
                  if (areaBatchCount == 0 && outboundAreaBatchCount == 0) {
                     this.areaBatchService.removeById(areaBatchId);
                  }
               }
            }
         }

         if (ArtifactChangeTypeEnum.UPDATE.getType().equals(changeRecord.getType())) {
            this.updateArtifactList(
               changeRecord,
               recordDetailList,
               artifactMap,
               artifactExtMap,
               taskNumberLinkMap,
               machinePartMap,
               machinePartLinkMap,
               assembleMap,
               assembleDetailMap,
               assembleExtMap,
               artifactIds,
               assembleNumberLinkMap,
               wingWebMachinePartMap,
               assembleMachinePartLinkMap,
               standardPartLinkMap,
               standardPartMap,
               mesProductEnum
            );
         }
      }

      if (ArtifactChangeTypeEnum.UPDATE_BASIC.getType().equals(changeRecord.getType())) {
         List<Long> artifactIds = recordDetailList.stream().map(TechChangeRecordDetail::getArtifactId).collect(Collectors.toList());
         Map<Long, TechArtifact> artifactMap = this.artifactService
            .listByIds(artifactIds)
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechArtifactExt> artifactExtList = this.artifactExtService
            .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().in(TechArtifactExt::getArtifactId, artifactIds));
         Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExtList.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
         recordDetailList.forEach(
            recordDetail -> {
               TechArtifact artifact = artifactMap.get(recordDetail.getArtifactId());
               List<TechArtifactExt> artifactExts = artifactExtMap.get(artifact.getId());
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,构件一物一码序号不存在!!!");
               ArtifactBasicChangeDTOParam basicChangeDTOParam = ArtifactBasicChangeDTOParam.builder()
                  .quantity(recordDetail.getChangeQuantity())
                  .netWeight(recordDetail.getChangeNetWeight())
                  .grossWeight(recordDetail.getChangeGrossWeight())
                  .length(recordDetail.getChangeLength())
                  .surfaceArea(recordDetail.getChangeSurfaceArea())
                  .name(recordDetail.getChangeName())
                  .printedCode(recordDetail.getChangePrintedCode())
                  .build();
               this.mesBuildingCalcMaxNumManager.changeArtifact(artifact, basicChangeDTOParam);
            }
         );
         artifactExtList.forEach(e -> e.setBoolStatusEnum(Boolean.TRUE));
         this.artifactExtService.updateBatchById(artifactExtList);
      }

      this.techCappCraftCardProductLinkBiz
         .remove(
            Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
               .in(
                  TechCappCraftCardProductLink::getProductId, recordDetailList.stream().map(TechChangeRecordDetail::getArtifactId).collect(Collectors.toList())
               )
         );
   }

   private void updateArtifactList(
      TechChangeRecord changeRecord,
      List<TechChangeRecordDetail> recordDetailList,
      Map<Long, TechArtifact> artifactMap,
      Map<String, TechArtifactExt> artifactExtMap,
      Map<String, List<MesBuildingTaskNumberLink>> taskNumberLinkMap,
      Map<Long, TechMachinePart> machinePartMap,
      Map<Long, List<TechArtifactMachinePartLink>> machinePartLinkMap,
      Map<Long, TechAssemble> assembleMap,
      Map<Long, List<TechAssembleDetail>> assembleDetailMap,
      Map<Long, List<TechAssembleExt>> assembleExtMap,
      List<Long> artifactIds,
      Map<Long, List<MesBuildingTaskNumberLink>> assembleNumberLinkMap,
      Map<Long, TechMachinePart> wingWebMachinePartMap,
      Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkMap,
      Map<Long, List<TechArtifactStandardPartLink>> standardPartLinkMap,
      Map<Long, TechStandardPart> standardPartMap,
      Integer mesProductEnum
   ) {
      ContractProject project = this.projectService.getById(changeRecord.getProjectId());
      Map<String, List<TechDrawing>> monomerPartDrawingMap = this.drawingService
         .getDrawingMap(changeRecord.getMonomerId(), TechDataTypeEnum.NC_DRAWING.getType(), null);
      Map<String, List<TechDrawing>> monomerAssembleDrawingMap = this.drawingService
         .getDrawingMap(changeRecord.getMonomerId(), TechDataTypeEnum.NC_DRAWING.getType(), ProductTypeEnum.ASSEMBLE.getType());
      Map<String, Long> holeNumberMap = this.machineHoleRadiusLinkService.getMachinePartHoleNumberMap(changeRecord.getMonomerId());
      Map<String, SysAssembleSpec> assembleSpecMap = this.assembleSpecService
         .list((Wrapper<SysAssembleSpec>)new LambdaQueryWrapper<SysAssembleSpec>().eq(SysAssembleSpec::getMesProductEnum, mesProductEnum))
         .stream()
         .collect(Collectors.toMap(SysAssembleSpec::getSpecPrefix, Function.identity()));
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list((Wrapper<MesBuildingProductProcess>)new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE))
         .stream()
         .filter(p -> p.getTypeId() != null)
         .collect(Collectors.toList());
      Map<Long, MesBuildingProductProcess> assembleProcessMap = productProcessList.stream()
         .filter(p -> p.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
         .collect(Collectors.toMap(MesBuildingProductProcess::getTypeId, Function.identity(), (s1, s2) -> s2));
      Map<String, SysSteelClassificationMatch> steelMatchMap = this.steelClassificationMatchService
         .list(
            (Wrapper<SysSteelClassificationMatch>)(new LambdaQueryWrapper<SysSteelClassificationMatch>()
                  .eq(SysSteelClassificationMatch::getMesProductEnum, mesProductEnum))
               .ne(SysSteelClassificationMatch::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
         )
         .stream()
         .collect(Collectors.toMap(SysSteelClassificationMatch::getKeyword, Function.identity()));
      Map<String, SysStructureSpecNumberLink> specNumberLinkMap = this.structureSpecNumberLinkService
         .list((Wrapper<SysStructureSpecNumberLink>)new LambdaQueryWrapper<SysStructureSpecNumberLink>().eq(SysStructureSpecNumberLink::getMesProductEnum, mesProductEnum))
         .stream()
         .collect(Collectors.toMap(e -> e.getSpecPrefix() + "-" + e.getSnPrefix(), Function.identity()));
      Map<String, SysStructureSpec> sysStructureSpecMap = this.structureSpecService
         .list(
            (Wrapper<SysStructureSpec>)(new LambdaQueryWrapper<SysStructureSpec>().eq(SysStructureSpec::getMesProductEnum, mesProductEnum))
               .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType())
         )
         .stream()
         .collect(Collectors.toMap(SysStructureSpec::getSpecPrefix, Function.identity()));
      Map<String, TechChangeArtifact> changeArtifactMap = this.changeArtifactService
         .list((Wrapper<TechChangeArtifact>)new LambdaQueryWrapper<TechChangeArtifact>().eq(TechChangeArtifact::getChangeRecordId, changeRecord.getId()))
         .stream()
         .collect(Collectors.toMap(TechChangeArtifact::getSerialNumber, Function.identity()));
      List<TechChangeMachinePart> changeMachineParts = this.changeMachinePartService
         .list((Wrapper<TechChangeMachinePart>)new LambdaQueryWrapper<TechChangeMachinePart>().eq(TechChangeMachinePart::getChangeRecordId, changeRecord.getId()));
      Map<Long, List<TechChangeMachinePart>> changeMachinePartMap = changeMachineParts.stream()
         .collect(Collectors.groupingBy(TechChangeMachinePart::getChangeArtifactId));
      Map<String, TechArtifact> existArtifactMap = this.artifactService
         .list(
            (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getMonomerId, changeRecord.getMonomerId()))
               .in(TechArtifact::getSerialNumber, recordDetailList.stream().map(TechChangeRecordDetail::getChangeSerialNumber).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getAreaBatchId() + "-" + e.getSerialNumber(), Function.identity()));
      Map<String, List<TechArtifactExt>> existArtifactExtMap = this.artifactExtService
         .listAllArtifactExt(
            changeRecord.getMonomerId(), recordDetailList.stream().map(TechChangeRecordDetail::getChangeSerialNumber).collect(Collectors.toList())
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getSerialNumber));
      List<TechChangeArtifactUseDtoParam> artifactUseDtoParams = new ArrayList<>();
      recordDetailList = recordDetailList.stream()
         .sorted(Comparator.comparing(TechChangeRecordDetail::getBoolSameNumber).reversed())
         .collect(Collectors.toList());

      for (TechChangeRecordDetail detail : recordDetailList) {
         TechChangeArtifactUseDtoParam artifactUseDtoParam = new TechChangeArtifactUseDtoParam();
         TechArtifact artifact = artifactMap.get(detail.getArtifactId());
         Preconditions.checkArgument(artifact != null, "构件不存在!!");
         Preconditions.checkArgument(artifact.getQuantity() > 0, "构件数量有误!!");
         TechArtifactExt artifactExt = artifactExtMap.get(detail.getArtifactId() + "-" + detail.getSortNumber());
         Preconditions.checkArgument(artifactExt != null, "构件序列号不存在!!");
         artifactUseDtoParam.setLastArtifactId(artifact.getId());
         artifactUseDtoParam.setLastSortNumber(artifactExt.getSortNumber());
         this.checkPassUpdate(
            artifactUseDtoParam,
            artifact,
            artifactMap,
            changeRecord,
            detail.getChangeSerialNumber(),
            existArtifactMap,
            existArtifactExtMap,
            changeArtifactMap,
            changeMachinePartMap,
            specNumberLinkMap,
            sysStructureSpecMap,
            monomerPartDrawingMap,
            monomerAssembleDrawingMap,
            holeNumberMap,
            assembleSpecMap,
            steelMatchMap,
            assembleProcessMap,
            project,
            detail.getBoolSameNumber()
         );
         if (artifactExt.getBoolScheduling()) {
            artifactUseDtoParams.add(artifactUseDtoParam);
         }

         detail.setChangeSortNumber(artifactUseDtoParam.getNewSortNumber().toString());
      }

      this.mesBuildingOneCodeChangBiz.useArtifact(artifactUseDtoParams);
      this.removeArtifactList(
         recordDetailList,
         artifactMap,
         artifactExtMap,
         taskNumberLinkMap,
         machinePartMap,
         machinePartLinkMap,
         assembleMap,
         assembleDetailMap,
         assembleExtMap,
         artifactIds,
         changeRecord.getType(),
         assembleNumberLinkMap,
         wingWebMachinePartMap,
         assembleMachinePartLinkMap,
         standardPartLinkMap,
         standardPartMap
      );
   }

   private void removeArtifactList(
      List<TechChangeRecordDetail> recordDetailList,
      Map<Long, TechArtifact> artifactMap,
      Map<String, TechArtifactExt> artifactExtMap,
      Map<String, List<MesBuildingTaskNumberLink>> taskNumberLinkMap,
      Map<Long, TechMachinePart> machinePartMap,
      Map<Long, List<TechArtifactMachinePartLink>> machinePartLinkMap,
      Map<Long, TechAssemble> assembleMap,
      Map<Long, List<TechAssembleDetail>> assembleDetailMap,
      Map<Long, List<TechAssembleExt>> assembleExtMap,
      List<Long> artifactIds,
      Integer type,
      Map<Long, List<MesBuildingTaskNumberLink>> assembleNumberLinkMap,
      Map<Long, TechMachinePart> wingWebMachinePartMap,
      Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkMap,
      Map<Long, List<TechArtifactStandardPartLink>> standardPartLinkMap,
      Map<Long, TechStandardPart> standardPartMap
   ) {
      List<TechArtifactMachinePartLink> machinePartLinkList = this.artifactMachinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
      if (CollectionUtils.isNotEmpty(machinePartLinkList)) {
         machinePartLinkMap = machinePartLinkList.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<TechMachinePart> machinePartList = this.machinePartService
            .listByIds(machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().in(TechAssembleDetail::getArtifactId, artifactIds));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         assembleDetailMap = assembleDetailList.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         List<TechAssemble> assembleList = this.assembleService
            .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
         assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         assembleNumberLinkMap = this.mesBuildingTaskNumberLinkService
            .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getAssembleId, assembleMap.keySet()))
            .stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         assembleExtMap = this.assembleExtService
            .list((Wrapper<TechAssembleExt>)new LambdaQueryWrapper<TechAssembleExt>().in(TechAssembleExt::getAssembleId, assembleMap.keySet()))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
         List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
            .list((Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>().in(TechAssembleMachinePartLink::getAssembleId, assembleMap.keySet()));
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
            assembleMachinePartLinkMap = assembleMachinePartLinks.stream().collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
            wingWebMachinePartMap = this.machinePartService
               .list(
                  (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>()
                        .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType()))
                     .in(
                        TechMachinePart::getId,
                        assembleMachinePartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         }
      }

      List<TechArtifactStandardPartLink> artifactStandardPartLinkList = this.artifactStandardPartLinkService
         .list((Wrapper<TechArtifactStandardPartLink>)new LambdaQueryWrapper<TechArtifactStandardPartLink>().in(TechArtifactStandardPartLink::getArtifactId, artifactIds));
      if (CollectionUtils.isNotEmpty(artifactStandardPartLinkList)) {
         standardPartLinkMap = artifactStandardPartLinkList.stream().collect(Collectors.groupingBy(TechArtifactStandardPartLink::getArtifactId));
         List<TechStandardPart> standardPartLinks = this.standardPartService
            .listByIds(artifactStandardPartLinkList.stream().map(TechArtifactStandardPartLink::getStandardPartId).collect(Collectors.toList()));
         standardPartMap = standardPartLinks.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
      }

      for (TechChangeRecordDetail detail : recordDetailList) {
         TechArtifact artifact = artifactMap.get(detail.getArtifactId());
         Preconditions.checkArgument(artifact != null, "构件不存在!!");
         Preconditions.checkArgument(artifact.getQuantity() > 0, "构件数量有误!!");
         TechArtifactExt artifactExt = artifactExtMap.get(detail.getArtifactId() + "-" + detail.getSortNumber());
         Preconditions.checkArgument(artifactExt != null, "构件序列号不存在!!");
         artifactExt.setQuantity(0);
         artifact.setBoolStatusEnum(Boolean.TRUE);
         artifact.setQuantity(artifact.getQuantity() - 1);
         artifact.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
         artifact.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
         ArtifactEditDTOParam editDTOParam = ArtifactEditDTOParam.builder()
            .businessId(artifact.getBusinessId())
            .quantity(-1)
            .totalWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(-1L)))
            .totalLength(artifact.getLength().multiply(BigDecimal.valueOf(-1L)).divide(BigDecimal.valueOf(1000L), 4).negate())
            .build();
         this.businessArtifactService.editBusinessInfo(editDTOParam);
         this.checkPassDel(
            detail,
            taskNumberLinkMap,
            machinePartMap,
            machinePartLinkMap,
            assembleMap,
            assembleDetailMap,
            assembleExtMap,
            assembleNumberLinkMap,
            wingWebMachinePartMap,
            assembleMachinePartLinkMap,
            standardPartLinkMap,
            standardPartMap
         );
      }

      if (ArtifactChangeTypeEnum.DEL.getType().equals(type)) {
         LambdaQueryWrapper<TechArtifactExt> queryWrapper = Wrappers.<TechArtifactExt>lambdaQuery();
         List<TechChangeRecordDetail> recordDetails = recordDetailList.stream()
            .filter(e -> ArtifactChangeTypeEnum.DEL.getType().equals(e.getType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(recordDetails)) {
            for (TechChangeRecordDetail recordDetail : recordDetailList) {
               if (queryWrapper.isEmptyOfNormal()) {
                  queryWrapper.eq(TechArtifactExt::getArtifactId, recordDetail.getArtifactId());
                  queryWrapper.in(TechArtifactExt::getSortNumber, recordDetail.getSortNumber());
               } else {
                  queryWrapper.or(
                     subQuery -> {
                        LambdaQueryWrapper var10000 = subQuery.eq(TechArtifactExt::getArtifactId, recordDetail.getArtifactId())
                           .in(TechArtifactExt::getSortNumber, recordDetail.getSortNumber());
                     }
                  );
               }
            }

            List<TechChangeArtifactDelDtoParam> artifactDelDtoParams = this.artifactExtService
               .list(queryWrapper)
               .stream()
               .filter(TechArtifactExt::getBoolScheduling)
               .map(e -> BeanUtil.copy(e, TechChangeArtifactDelDtoParam.class))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(artifactDelDtoParams)) {
               this.mesBuildingOneCodeChangBiz.deleteArtifacts(artifactDelDtoParams, Boolean.FALSE);
            }
         }
      }

      List<TechAssemble> delAssembleList = assembleMap.values().stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<TechAssemble> updateAssembleList = assembleMap.values().stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
      List<TechAssembleExt> delTechAssembleExts = assembleExtMap.values()
         .stream()
         .flatMap(Collection::stream)
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<TechAssembleExt> updateTechAssembleExts = assembleExtMap.values()
         .stream()
         .flatMap(Collection::stream)
         .filter(e -> e.getQuantity() != 0)
         .collect(Collectors.toList());
      List<TechMachinePart> delMachinePartList = machinePartMap.values().stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<TechMachinePart> updateMachinePartList = machinePartMap.values().stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
      List<TechArtifact> delArtifacts = artifactMap.values().stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<TechArtifact> updateArtifacts = artifactMap.values().stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
      List<TechArtifactExt> delArtifactExtList = artifactExtMap.values().stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<TechMachinePart> delWingWebMachinePartList = wingWebMachinePartMap.values().stream().filter(e -> e.getQuantity() <= 0).collect(Collectors.toList());
      List<TechMachinePart> updateWingWebMachinePartList = wingWebMachinePartMap.values()
         .stream()
         .filter(e -> e.getQuantity() > 0)
         .collect(Collectors.toList());
      List<TechStandardPart> delStandardPartList = standardPartMap.values()
         .stream()
         .filter(e -> e.getQuantity().compareTo(BigDecimal.ZERO) == 0)
         .collect(Collectors.toList());
      List<TechStandardPart> updateStandardPartList = standardPartMap.values()
         .stream()
         .filter(e -> e.getQuantity().compareTo(BigDecimal.ZERO) != 0)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(delAssembleList)) {
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinkMap)) {
            for (TechAssemble assemble : delAssembleList) {
               List<TechAssembleMachinePartLink> assembleMachinePartLinks = assembleMachinePartLinkMap.get(assemble.getId());
               if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
                  this.assembleMachinePartLinkService
                     .removeByIds(assembleMachinePartLinks.stream().map(TechAssembleMachinePartLink::getId).collect(Collectors.toList()));
               }
            }
         }

         this.assembleService.removeByIds(delAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTechAssembleExts)) {
         this.assembleExtService.removeByIds(delTechAssembleExts.stream().map(TechAssembleExt::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delMachinePartList)) {
         this.machinePartService.removeByIds(delMachinePartList.stream().map(TechMachinePart::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delArtifactExtList)) {
         this.artifactExtService.removeByIds(delArtifactExtList.stream().map(TechArtifactExt::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delWingWebMachinePartList)) {
         this.machinePartService.removeByIds(delWingWebMachinePartList.stream().map(TechMachinePart::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delStandardPartList)) {
         this.standardPartService.removeByIds(delStandardPartList.stream().map(TechStandardPart::getId).collect(Collectors.toList()));
      }

      for (TechArtifact delArtifact : delArtifacts) {
         List<TechArtifactMachinePartLink> delMachinePartLinks = machinePartLinkMap.get(delArtifact.getId());
         List<TechAssembleDetail> delAssembleDetailList = assembleDetailMap.get(delArtifact.getId());
         List<TechArtifactStandardPartLink> delStandardPartLinkList = standardPartLinkMap.get(delArtifact.getId());
         if (CollectionUtils.isNotEmpty(delMachinePartLinks)) {
            this.artifactMachinePartLinkService.removeByIds(delMachinePartLinks.stream().map(TechArtifactMachinePartLink::getId).collect(Collectors.toList()));
         }

         if (CollectionUtils.isNotEmpty(delAssembleDetailList)) {
            this.assembleDetailService.removeByIds(delAssembleDetailList.stream().map(TechAssembleDetail::getId).collect(Collectors.toList()));
         }

         if (CollectionUtils.isNotEmpty(delStandardPartLinkList)) {
            this.artifactStandardPartLinkService
               .removeByIds(delStandardPartLinkList.stream().map(TechArtifactStandardPartLink::getId).collect(Collectors.toList()));
         }

         this.artifactService.removeById(delArtifact.getId());
      }

      if (CollectionUtils.isNotEmpty(updateAssembleList)) {
         Map<Long, TechAssemble> techAssembleMap = this.assembleService
            .listByIds(updateAssembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (TechAssemble assemble : updateAssembleList) {
            TechAssemble techAssemble = techAssembleMap.get(assemble.getId());
            Preconditions.checkArgument(techAssemble != null && assemble.getQuantity() >= techAssemble.getProducedQuantity(), "操作失败，数据有误!!!");
            this.assembleService
               .update(
                  (Wrapper<TechAssemble>)(((new LambdaUpdateWrapper<TechAssemble>()
                              .eq(TechAssemble::getId, assemble.getId()))
                           .set(TechAssemble::getTotalNetWeight, assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue()))))
                        .set(
                           TechAssemble::getTotalGrossWeight,
                           assemble.getGrossWeight() == null
                              ? BigDecimal.ZERO
                              : assemble.getGrossWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue()))
                        ))
                     .set(TechAssemble::getQuantity, assemble.getQuantity())
               );
         }
      }

      if (CollectionUtils.isNotEmpty(updateTechAssembleExts)) {
         updateTechAssembleExts.forEach(this.assembleExtService::updateById);
      }

      if (CollectionUtils.isNotEmpty(updateMachinePartList)) {
         Map<Long, TechMachinePart> partMap = this.machinePartService
            .listByIds(updateMachinePartList.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

         for (TechMachinePart machinePart : updateMachinePartList) {
            TechMachinePart techMachinePart = partMap.get(machinePart.getId());
            Preconditions.checkArgument(techMachinePart != null && machinePart.getQuantity() >= techMachinePart.getProducedQuantity(), "操作失败，数据有误!!!");
            this.machinePartService
               .update(
                  (Wrapper<TechMachinePart>)(((new LambdaUpdateWrapper<TechMachinePart>()
                              .eq(TechMachinePart::getId, techMachinePart.getId()))
                           .set(
                              TechMachinePart::getTotalNetWeight, machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
                           ))
                        .set(
                           TechMachinePart::getTotalGrossWeight,
                           machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
                        ))
                     .set(TechMachinePart::getQuantity, machinePart.getQuantity())
               );
         }
      }

      if (CollectionUtils.isNotEmpty(updateWingWebMachinePartList)) {
         Map<Long, TechMachinePart> partMap = this.machinePartService
            .listByIds(updateWingWebMachinePartList.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

         for (TechMachinePart machinePart : updateWingWebMachinePartList) {
            TechMachinePart techMachinePart = partMap.get(machinePart.getId());
            this.machinePartService
               .update(
                  (Wrapper<TechMachinePart>)(((new LambdaUpdateWrapper<TechMachinePart>()
                              .eq(TechMachinePart::getId, techMachinePart.getId()))
                           .set(
                              TechMachinePart::getTotalNetWeight, machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
                           ))
                        .set(
                           TechMachinePart::getTotalGrossWeight,
                           machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue()))
                        ))
                     .set(TechMachinePart::getQuantity, machinePart.getQuantity())
               );
         }
      }

      if (CollectionUtils.isNotEmpty(updateArtifacts)) {
         Map<Long, TechArtifact> techArtifactMap = this.artifactService
            .listByIds(updateArtifacts.stream().map(TechArtifact::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));

         for (TechArtifact updateArtifact : updateArtifacts) {
            TechArtifact artifact = techArtifactMap.get(updateArtifact.getId());
            Preconditions.checkArgument(artifact != null && updateArtifact.getQuantity() >= artifact.getProducedQuantity(), "操作失败，数据有误!!!");
            this.artifactService
               .update(
                  (Wrapper<TechArtifact>)((((new LambdaUpdateWrapper<TechArtifact>()
                                 .eq(TechArtifact::getId, updateArtifact.getId()))
                              .set(TechArtifact::getQuantity, updateArtifact.getQuantity()))
                           .set(
                              TechArtifact::getTotalNetWeight,
                              updateArtifact.getNetWeight().multiply(BigDecimal.valueOf(updateArtifact.getQuantity().intValue()))
                           ))
                        .set(
                           TechArtifact::getTotalGrossWeight,
                           updateArtifact.getGrossWeight().multiply(BigDecimal.valueOf(updateArtifact.getQuantity().intValue()))
                        ))
                     .set(TechArtifact::getBoolStatusEnum, Boolean.TRUE)
               );
         }
      }

      if (CollectionUtils.isNotEmpty(updateStandardPartList)) {
         Map<Long, TechStandardPart> techStandardPartMap = this.standardPartService
            .listByIds(updateStandardPartList.stream().map(TechStandardPart::getId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));

         for (TechStandardPart standardPart : updateStandardPartList) {
            TechStandardPart techStandardPart = techStandardPartMap.get(standardPart.getId());
            this.standardPartService
               .update(
                  (Wrapper<TechStandardPart>)((new LambdaUpdateWrapper<TechStandardPart>()
                           .eq(TechStandardPart::getId, techStandardPart.getId()))
                        .set(TechStandardPart::getQuantity, standardPart.getQuantity()))
                     .set(TechStandardPart::getMete, standardPart.getQuantity())
               );
         }
      }

      recordDetailList.forEach(this.changeRecordDetailService::updateById);
   }

   private void checkPassDel(
      TechChangeRecordDetail detail,
      Map<String, List<MesBuildingTaskNumberLink>> taskNumberLinkMap,
      Map<Long, TechMachinePart> machinePartMap,
      Map<Long, List<TechArtifactMachinePartLink>> machinePartLinkMap,
      Map<Long, TechAssemble> assembleMap,
      Map<Long, List<TechAssembleDetail>> assembleDetailMap,
      Map<Long, List<TechAssembleExt>> assembleExtMap,
      Map<Long, List<MesBuildingTaskNumberLink>> assembleNumberLinkMap,
      Map<Long, TechMachinePart> wingWebMachinePartMap,
      Map<Long, List<TechAssembleMachinePartLink>> assembleMachinePartLinkMap,
      Map<Long, List<TechArtifactStandardPartLink>> standardPartLinkMap,
      Map<Long, TechStandardPart> standardPartMap
   ) {
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = machinePartLinkMap.get(detail.getArtifactId());
      if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
         artifactMachinePartLinkList.forEach(link -> {
            TechMachinePart machinePart = machinePartMap.get(link.getMachinePartId());
            Preconditions.checkArgument(machinePart.getQuantity() >= link.getQuantity(), "操作失败,删除后零件数量不能为负数!!!");
            machinePart.setQuantity(machinePart.getQuantity() - link.getQuantity());
            machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
            machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
         });
      }

      if (CollectionUtils.isNotEmpty(assembleDetailMap)) {
         List<TechAssembleDetail> assembleDetailList = assembleDetailMap.get(detail.getArtifactId());
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            List<MesBuildingTaskNumberLink> taskNumberLinkList = taskNumberLinkMap.get(detail.getArtifactId() + "-" + detail.getSortNumber());
            Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = CollectionUtils.isEmpty(taskNumberLinkList)
               ? new HashMap<>()
               : taskNumberLinkList.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
            assembleDetailList.forEach(
               assembleDetail -> {
                  TechAssemble assemble = assembleMap.get(assembleDetail.getAssembleId());
                  Preconditions.checkArgument(assemble.getQuantity() >= assembleDetail.getQuantity(), "操作失败,删除后零件数量不能为负数!!!");
                  assemble.setQuantity(assemble.getQuantity() - assembleDetail.getQuantity());
                  assemble.setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
                  assemble.setTotalGrossWeight(assemble.getGrossWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
                  Map<Integer, TechAssembleExt> assembleExtNumberMap = assembleExtMap.get(assemble.getId())
                     .stream()
                     .collect(Collectors.toMap(TechAssembleExt::getSortNumber, Function.identity()));
                  List<MesBuildingTaskNumberLink> taskNumberLinks = assembleTaskNumberLinkMap.get(assemble.getId());
                  if (CollectionUtils.isNotEmpty(taskNumberLinks)) {
                     Preconditions.checkArgument(taskNumberLinks.size() == assembleDetail.getQuantity(), "操作失败,构件关联的部件一物一码序号数量有误!!!");

                     for (MesBuildingTaskNumberLink numberLink : taskNumberLinks) {
                        TechAssembleExt techAssembleExt = assembleExtNumberMap.get(numberLink.getAssembleNumber());
                        Preconditions.checkArgument(techAssembleExt.getQuantity() != 0, "操作失败，数据有误!!!");
                        techAssembleExt.setQuantity(0);
                     }
                  }

                  if (CollectionUtils.isEmpty(taskNumberLinks)) {
                     List<Integer> assembleNumberList = new ArrayList<>();
                     List<MesBuildingTaskNumberLink> linkList = assembleNumberLinkMap.get(assemble.getId());
                     if (CollectionUtils.isNotEmpty(linkList)) {
                        assembleNumberList = linkList.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).collect(Collectors.toList());
                     }

                     List<Integer> finalAssembleNumberList = assembleNumberList;
                     List<TechAssembleExt> assembleExtList = assembleExtNumberMap.values()
                        .stream()
                        .filter(e -> !finalAssembleNumberList.contains(e.getSortNumber()))
                        .filter(e -> e.getQuantity() != 0)
                        .sorted(Comparator.comparing(TechAssembleExt::getSortNumber))
                        .collect(Collectors.toList());
                     Preconditions.checkArgument(
                        CollectionUtils.isNotEmpty(assembleExtList) && assembleExtList.size() >= assembleDetail.getQuantity(), "操作失败,构件关联的部件一物一码序号数量有误!!!"
                     );

                     for (int i = 0; i < assembleDetail.getQuantity(); i++) {
                        TechAssembleExt techAssembleExt = assembleExtList.get(i);
                        Preconditions.checkArgument(techAssembleExt.getQuantity() == 1, "操作失败,构件关联的部件一物一码序号数量有误!!!");
                        techAssembleExt.setQuantity(0);
                     }
                  }

                  if (CollectionUtils.isNotEmpty(assembleMachinePartLinkMap)) {
                     List<TechAssembleMachinePartLink> assembleMachinePartLinks = assembleMachinePartLinkMap.get(assemble.getId());
                     if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
                        assembleMachinePartLinks.forEach(assembleMachinePartLink -> {
                           TechMachinePart machinePart = wingWebMachinePartMap.get(assembleMachinePartLink.getMachinePartId());
                           machinePart.setQuantity(machinePart.getQuantity() - assembleMachinePartLink.getQuantity());
                           machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                           machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                        });
                     }
                  }
               }
            );
         }
      }

      List<TechArtifactStandardPartLink> artifactStandardPartLinkList = standardPartLinkMap.get(detail.getArtifactId());
      if (CollectionUtils.isNotEmpty(artifactStandardPartLinkList)) {
         artifactStandardPartLinkList.forEach(link -> {
            TechStandardPart standardPart = standardPartMap.get(link.getStandardPartId());
            Preconditions.checkArgument(standardPart.getQuantity().intValue() >= link.getQuantity(), "操作失败,删除后配套件数量不能为负数!!!");
            standardPart.setQuantity(standardPart.getQuantity().subtract(BigDecimal.valueOf(link.getQuantity().intValue())));
            standardPart.setMete(standardPart.getQuantity());
         });
      }
   }

   private void checkPassUpdate(
      TechChangeArtifactUseDtoParam artifactUseDtoParam,
      TechArtifact oldArtifact,
      Map<Long, TechArtifact> artifactMap,
      TechChangeRecord changeRecord,
      String changeSerialNumber,
      Map<String, TechArtifact> existArtifactMap,
      Map<String, List<TechArtifactExt>> existArtifactExtMap,
      Map<String, TechChangeArtifact> changeArtifactMap,
      Map<Long, List<TechChangeMachinePart>> changeMachinePartMap,
      Map<String, SysStructureSpecNumberLink> specNumberLinkMap,
      Map<String, SysStructureSpec> sysStructureSpecMap,
      Map<String, List<TechDrawing>> monomerPartDrawingMap,
      Map<String, List<TechDrawing>> monomerAssembleDrawingMap,
      Map<String, Long> holeNumberMap,
      Map<String, SysAssembleSpec> assembleSpecMap,
      Map<String, SysSteelClassificationMatch> steelMatchMap,
      Map<Long, MesBuildingProductProcess> assembleProcessMap,
      ContractProject project,
      Boolean boolSameNumber
   ) {
      TechArtifact artifact = existArtifactMap.get(oldArtifact.getAreaBatchId() + "-" + changeSerialNumber);
      if (artifact != null && !boolSameNumber) {
         this.checkPassUpdateAddQuantity(artifact, existArtifactExtMap, artifactUseDtoParam, artifactMap, existArtifactMap);
      } else {
         this.checkPassUpdateInsertNew(
            artifactUseDtoParam,
            oldArtifact,
            changeRecord,
            changeSerialNumber,
            existArtifactMap,
            existArtifactExtMap,
            changeArtifactMap,
            changeMachinePartMap,
            specNumberLinkMap,
            sysStructureSpecMap,
            monomerPartDrawingMap,
            monomerAssembleDrawingMap,
            holeNumberMap,
            assembleSpecMap,
            steelMatchMap,
            assembleProcessMap,
            project
         );
      }
   }

   private void checkPassUpdateAddQuantity(
      TechArtifact artifact,
      Map<String, List<TechArtifactExt>> existArtifactExtMap,
      TechChangeArtifactUseDtoParam artifactUseDtoParam,
      Map<Long, TechArtifact> artifactMap,
      Map<String, TechArtifact> existArtifactMap
   ) {
      List<TechArtifactExt> artifactExtList = existArtifactExtMap.get(artifact.getSerialNumber());
      artifactUseDtoParam.setNewArtifactId(artifact.getId());
      if (CollectionUtils.isNotEmpty(artifactExtList)) {
         List<Integer> sortNumberList = artifactExtList.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList());
         Integer max = Collections.max(sortNumberList);
         int sortNumber = (max >= artifactExtList.size() ? max : artifactExtList.size()) + 1;
         TechArtifactExt ext = BeanUtil.copy(artifact, TechArtifactExt.class);
         ext.setArtifactId(artifact.getId());
         ext.setSortNumber(sortNumber);
         ext.setBoolStatusEnum(true);
         ext.setQuantity(1);
         ext.setImportUserId(UserUtil.getCurrentUserId());
         ext.setImportUserName(UserUtil.getCurrentName());
         this.artifactExtService.save(ext);
         artifactExtList.add(ext);
         artifactUseDtoParam.setNewSortNumber(ext.getSortNumber());
      }

      artifact.setQuantity(artifact.getQuantity() + 1);
      artifact.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      artifact.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(artifact.getQuantity().intValue())));
      this.artifactService.updateById(artifact);
      if (artifactMap.get(artifact.getId()) != null) {
         artifactMap.put(artifact.getId(), artifact);
      }

      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.builder().artifactId(artifact.getId()).build()));
      if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
         Map<Long, TechMachinePart> machinePartMap = this.machinePartService
            .listByIds(artifactMachinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         artifactMachinePartLinkList.forEach(link -> {
            TechMachinePart machinePart = machinePartMap.get(link.getMachinePartId());
            machinePart.setQuantity(machinePart.getQuantity() + link.getQuantity());
            machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
            machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
         });
         this.machinePartService.updateBatchById(machinePartMap.values());
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         Map<Long, TechAssemble> assembleMap = this.assembleService
            .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         assembleDetailList.forEach(
            assembleDetail -> {
               TechAssemble assemble = assembleMap.get(assembleDetail.getAssembleId());
               assemble.setQuantity(assemble.getQuantity() + assembleDetail.getQuantity());
               assemble.setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
               assemble.setTotalGrossWeight(assemble.getGrossWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
               this.assembleExtService.addReduceExt(assemble, assembleDetail.getQuantity());
               List<TechAssembleMachinePartLink> assembleMachinePartLinkList = this.assembleMachinePartLinkService
                  .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.builder().assembleId(assemble.getId()).build()));
               if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
                  Map<Long, TechMachinePart> assemblePartIdMap = this.machinePartService
                     .listByIds(assembleMachinePartLinkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toSet()))
                     .stream()
                     .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
                  assembleMachinePartLinkList.forEach(assembleMachinePartLink -> {
                     TechMachinePart assemblePart = assemblePartIdMap.get(assembleMachinePartLink.getMachinePartId());
                     assemblePart.setQuantity(assemblePart.getQuantity() + assembleDetail.getQuantity() * assembleMachinePartLink.getQuantity());
                     assemblePart.setTotalNetWeight(assemblePart.getNetWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                     assemblePart.setTotalGrossWeight(assemblePart.getGrossWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                  });
                  this.machinePartService.updateBatchById(assemblePartIdMap.values());
               }
            }
         );
         this.assembleService.updateBatchById(assembleMap.values());
      }

      List<TechArtifactStandardPartLink> artifactStandardPartLinkList = this.artifactStandardPartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactStandardPartLink.builder().artifactId(artifact.getId()).build()));
      if (CollectionUtils.isNotEmpty(artifactStandardPartLinkList)) {
         Map<Long, TechStandardPart> standardPartMap = this.standardPartService
            .listByIds(artifactStandardPartLinkList.stream().map(TechArtifactStandardPartLink::getStandardPartId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         artifactStandardPartLinkList.forEach(link -> {
            TechStandardPart standardPart = standardPartMap.get(link.getStandardPartId());
            standardPart.setQuantity(standardPart.getQuantity().add(BigDecimal.valueOf(link.getQuantity().intValue())));
            standardPart.setMete(standardPart.getQuantity());
         });
         this.standardPartService.updateBatchById(standardPartMap.values());
      }
   }

   private void checkPassUpdateInsertNew(
      TechChangeArtifactUseDtoParam artifactUseDtoParam,
      TechArtifact oldArtifact,
      TechChangeRecord changeRecord,
      String changeSerialNumber,
      Map<String, TechArtifact> existArtifactMap,
      Map<String, List<TechArtifactExt>> existArtifactExtMap,
      Map<String, TechChangeArtifact> changeArtifactMap,
      Map<Long, List<TechChangeMachinePart>> changeMachinePartMap,
      Map<String, SysStructureSpecNumberLink> specNumberLinkMap,
      Map<String, SysStructureSpec> sysStructureSpecMap,
      Map<String, List<TechDrawing>> monomerPartDrawingMap,
      Map<String, List<TechDrawing>> monomerAssembleDrawingMap,
      Map<String, Long> holeNumberMap,
      Map<String, SysAssembleSpec> assembleSpecMap,
      Map<String, SysSteelClassificationMatch> steelMatchMap,
      Map<Long, MesBuildingProductProcess> assembleProcessMap,
      ContractProject project
   ) {
      TechChangeArtifact changeArtifact = changeArtifactMap.get(changeSerialNumber);
      TechArtifact artifact = BeanUtil.copy(changeArtifact, TechArtifact.class);
      artifact.setProjectId(changeRecord.getProjectId());
      artifact.setMonomerId(changeRecord.getMonomerId());
      artifact.setAreaId(oldArtifact.getAreaId());
      artifact.setAreaBatchId(oldArtifact.getAreaBatchId());
      artifact.setAreaType(AreaTypeEnum.PROCESS.getType());
      artifact.setQuantity(1);
      artifact.setTotalNetWeight(artifact.getNetWeight());
      artifact.setTotalGrossWeight(artifact.getGrossWeight());
      artifact.setSurfaceArea(
         changeArtifact.getSurfaceArea() != null ? changeArtifact.getSurfaceArea().multiply(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO
      );
      artifact.setBoolStatusEnum(true);
      artifact.setBoolAbnormalEnum(false);
      artifact.setProductionLineTypeEnum(ProductionLineTypeEnum.TRADITIONAL_LINE.getType());
      artifact.setBoolAllPartSendDirectly(false);
      artifact.setBoolSinglePartEnum(false);
      artifact.setBoolCoatingEnum(true);
      artifact.setCodingType(oldArtifact.getCodingType());
      artifact.setUserId(changeArtifact.getUserId());
      SysStructureSpecNumberLink specNumberLink = specNumberLinkMap.get(changeArtifact.getSpecPrefix() + "-" + changeArtifact.getSerialNumberPrefix());
      SysStructureSpec structureSpec = sysStructureSpecMap.get(changeArtifact.getSpecPrefix());
      Preconditions.checkArgument(specNumberLink != null || structureSpec != null, "操作失败,构件规格定义未配置!!!");
      if (specNumberLink != null) {
         artifact.setArtifactType(ArtifactTypeEnum.SMALL.getType());
         artifact.setStructureClassId(specNumberLink.getStructureClassificationId());
         artifact.setBoolSchedulingEnum(true);
         artifact.setBoolAllPartSendDirectly(
            specNumberLink.getSmallArtifactClassEnum().equals(SmallArtifactClassEnum.PURLIN.getType())
               && StringUtils.isNotBlank(artifact.getName())
               && this.SEND_DIRECTLY_MARK_LIST.stream().anyMatch(s -> artifact.getName().contains(s))
         );
      } else {
         artifact.setArtifactType(ArtifactTypeEnum.COMMON.getType());
         artifact.setStructureClassId(structureSpec.getStructureClassificationId());
         artifact.setBoolSchedulingEnum(Boolean.TRUE);
      }

      ArtifactAddDTOParam addDTOParam = BeanUtil.copy(artifact, ArtifactAddDTOParam.class);
      addDTOParam.setTotalWeight(artifact.getTotalNetWeight());
      addDTOParam.setTotalLength(artifact.getLength().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
      artifact.setBusinessId(this.businessArtifactService.addBusinessInfo(addDTOParam));
      this.artifactService.save(artifact);
      artifactUseDtoParam.setNewArtifactId(artifact.getId());
      existArtifactMap.put(artifact.getAreaBatchId() + "-" + artifact.getSerialNumber(), artifact);
      List<TechArtifactExt> artifactExts = existArtifactExtMap.getOrDefault(artifact.getSerialNumber(), new ArrayList<>());
      Integer max = CollectionUtils.isNotEmpty(artifactExts)
         ? Collections.max(artifactExts.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList()))
         : 0;
      int sortNumber = (max >= artifactExts.size() ? max : artifactExts.size()) + 1;
      TechArtifactExt artifactExt = BeanUtil.copy(artifact, TechArtifactExt.class);
      artifactExt.setArtifactId(artifact.getId());
      artifactExt.setSortNumber(sortNumber);
      artifactExt.setQuantity(1);
      artifactExt.setImportUserId(UserUtil.getCurrentUserId());
      artifactExt.setImportUserName(UserUtil.getCurrentName());
      this.artifactExtService.save(artifactExt);
      artifactExts.add(artifactExt);
      existArtifactExtMap.put(artifact.getSerialNumber(), artifactExts);
      artifactUseDtoParam.setNewSortNumber(artifactExt.getSortNumber());
      List<TechChangeMachinePart> changeMachinePartAndAssembleList = changeMachinePartMap.get(changeArtifact.getId());
      if (!CollectionUtils.isEmpty(changeMachinePartAndAssembleList)) {
         List<TechChangeMachinePart> changeMachinePartList = changeMachinePartAndAssembleList.stream()
            .filter(
               e -> SteelPlateTypeEnum.PRIMARY_MEMBER.getType().equals(e.getSteelPlateTypeEnum())
                  || SteelPlateTypeEnum.SECTIONSTEEL.getType().equals(e.getSteelPlateTypeEnum())
            )
            .collect(Collectors.toList());
         List<TechChangeMachinePart> changeAssembleList = changeMachinePartAndAssembleList.stream()
            .filter(e -> e.getProductClassificationEnum().equals(ProductClassificationEnum.ASSEMBLE.getType()))
            .collect(Collectors.toList());
         List<TechChangeMachinePart> changeassembleMachinePartList = changeMachinePartAndAssembleList.stream()
            .filter(e -> SteelPlateTypeEnum.SECONDARY_MEMBER.getType().equals(e.getSteelPlateTypeEnum()))
            .collect(Collectors.toList());
         Map<Long, List<TechChangeMachinePart>> changeassembleMachinePartMap = changeassembleMachinePartList.stream()
            .collect(Collectors.groupingBy(TechChangeMachinePart::getChangeAssembleId));
         List<TechChangeMachinePart> changeStandPrtList = changeMachinePartAndAssembleList.stream()
            .filter(e -> e.getProductClassificationEnum().equals(ProductClassificationEnum.AUXILIARY_MATERIAL.getType()))
            .collect(Collectors.toList());
         List<TechAssembleDetail> artifactAssembleLinkList = new ArrayList<>(32);
         List<TechAssembleMachinePartLink> addAssembleMachinePartLinkList = new ArrayList<>(32);
         List<TechArtifactMachinePartLink> artifactMachinePartLinkList = new ArrayList<>(32);
         if (CollectionUtils.isNotEmpty(changeMachinePartList)) {
            List<TechMachinePart> machinePartList = this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .eq(TechMachinePart::getAreaBatchId, artifact.getAreaBatchId())
                     .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ARTIFACT.getType())
                     .in(
                        TechMachinePart::getSerialNumber,
                        changeMachinePartList.stream().map(TechChangeMachinePart::getSerialNumber).collect(Collectors.toList())
                     )
               );
            Map<String, Map<Boolean, List<TechMachinePart>>> machinePartSnGroupMap = machinePartList.stream()
               .collect(Collectors.groupingBy(TechMachinePart::getSerialNumber, Collectors.groupingBy(TechMachinePart::getBoolSendDirectly)));
            changeMachinePartList.forEach(
               changeMachinePart -> {
                  boolean boolSendDirectly = changeMachinePart.getBoolSendDirectly();
                  TechMachinePart machinePart = null;
                  List<TechMachinePart> partList = CollectionUtils.isEmpty(machinePartSnGroupMap)
                     ? new ArrayList<>()
                     : (
                        CollectionUtils.isEmpty(machinePartSnGroupMap.get(changeMachinePart.getSerialNumber()))
                           ? new ArrayList<>()
                           : machinePartSnGroupMap.get(changeMachinePart.getSerialNumber()).get(boolSendDirectly)
                     );
                  if (CollectionUtils.isNotEmpty(partList)) {
                     if (artifact.getBoolAllPartSendDirectly()) {
                        Map<String, TechMachinePart> partMap = partList.stream().collect(Collectors.toMap(TechMachinePart::getName, Function.identity()));
                        machinePart = partMap.get(artifact.getName());
                     } else {
                        machinePart = partList.get(0);
                     }
                  }

                  if (machinePart != null) {
                     machinePart.setQuantity(machinePart.getQuantity() + changeMachinePart.getArtifactRate());
                     machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                     machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                     this.machinePartService.updateById(machinePart);
                     TechArtifactMachinePartLink link = TechArtifactMachinePartLink.builder()
                        .artifactId(artifact.getId())
                        .machinePartId(machinePart.getId())
                        .quantity(changeMachinePart.getArtifactRate())
                        .build();
                     artifactMachinePartLinkList.add(link);
                  } else {
                     machinePart = BeanUtil.copy(changeMachinePart, TechMachinePart.class);
                     if (artifact.getBoolAllPartSendDirectly()) {
                        machinePart.setName(artifact.getName());
                     }

                     machinePart.setProjectId(changeRecord.getProjectId());
                     machinePart.setMonomerId(changeRecord.getMonomerId());
                     machinePart.setAreaId(artifact.getAreaId());
                     machinePart.setAreaBatchId(artifact.getAreaBatchId());
                     machinePart.setAreaType(AreaTypeEnum.PROCESS.getType());
                     machinePart.setQuantity(changeMachinePart.getArtifactRate());
                     machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                     machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
                     machinePart.setRelationType(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
                     machinePart.setSteelId(steelMatchMap.get(machinePart.getSpecPrefix()).getSteelId());
                     machinePart.setSurfaceArea(
                        changeMachinePart.getSurfaceArea() != null
                           ? changeMachinePart.getSurfaceArea().multiply(BigDecimal.valueOf(1000000L))
                           : BigDecimal.ZERO
                     );
                     if (machinePart.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType())) {
                        machinePart.setThick(TechUtils.getMachinePartThick(machinePart.getSpecification()));
                        machinePart.setSteelSpec(machinePart.getThick());
                        if (machinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType())) {
                           machinePart.setThick(TechUtils.getMachinePartThick(machinePart.getSpecification()));
                        }

                        if (machinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())) {
                           machinePart.setThick(TechUtils.getMachinePartThick(machinePart.getSpecification()));
                        }

                        if (machinePart.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECTIONSTEEL.getType())) {
                           machinePart.setThick(machinePart.getSpecification());
                           machinePart.setSteelSpec(machinePart.getSpecification());
                        }

                        machinePart.setBoolHaveHole(holeNumberMap.containsKey(machinePart.getSerialNumber()));
                        machinePart.setHoleNumber(holeNumberMap.getOrDefault(machinePart.getSerialNumber(), 0L));
                        machinePart.setBoolSchedulingEnum(false);
                        machinePart.setBoolProcess(false);
                        if (monomerPartDrawingMap.containsKey(machinePart.getSerialNumber())) {
                           TechDrawing drawing = monomerPartDrawingMap.get(machinePart.getSerialNumber()).get(0);
                           machinePart.setPath(drawing.getCloudPath());
                           machinePart.setOssRelativePath(machinePart.getProjectId() + "/" + machinePart.getMonomerId() + "/" + drawing.getFileName());
                        }
                     }

                     this.machinePartService.save(machinePart);
                     TechArtifactMachinePartLink link = TechArtifactMachinePartLink.builder()
                        .artifactId(artifact.getId())
                        .machinePartId(machinePart.getId())
                        .quantity(changeMachinePart.getArtifactRate())
                        .build();
                     artifactMachinePartLinkList.add(link);
                  }
               }
            );
         }

         if (CollectionUtils.isNotEmpty(changeAssembleList)) {
            List<TechAssemble> assembleList = this.assembleService
               .list(
                  Wrappers.lambdaQuery(TechAssemble.class)
                     .eq(TechAssemble::getAreaBatchId, artifact.getAreaBatchId())
                     .in(TechAssemble::getSerialNumber, changeAssembleList.stream().map(TechChangeMachinePart::getSerialNumber).collect(Collectors.toList()))
               );
            Map<String, Map<Boolean, List<TechAssemble>>> machinePartSnGroupMap = assembleList.stream()
               .collect(Collectors.groupingBy(TechAssemble::getSerialNumber, Collectors.groupingBy(TechAssemble::getBoolSendDirectly)));
            changeAssembleList.forEach(
               changeAssemble -> {
                  Boolean boolSendDirectly = changeAssemble.getBoolSendDirectly();
                  TechAssemble techAssemble = null;
                  List<TechAssemble> assembles = CollectionUtils.isEmpty(machinePartSnGroupMap)
                     ? new ArrayList<>()
                     : (
                        CollectionUtils.isEmpty(machinePartSnGroupMap.get(changeAssemble.getSerialNumber()))
                           ? new ArrayList<>()
                           : machinePartSnGroupMap.get(changeAssemble.getSerialNumber()).get(boolSendDirectly)
                     );
                  if (CollectionUtils.isNotEmpty(assembles)) {
                     if (artifact.getBoolAllPartSendDirectly()) {
                        Map<String, TechAssemble> assembleSnMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getName, Function.identity()));
                        techAssemble = assembleSnMap.get(artifact.getName());
                     } else {
                        techAssemble = assembles.get(0);
                     }
                  }

                  if (techAssemble != null) {
                     techAssemble.setQuantity(techAssemble.getQuantity() + changeAssemble.getArtifactRate());
                     techAssemble.setTotalNetWeight(techAssemble.getNetWeight().multiply(BigDecimal.valueOf(techAssemble.getQuantity().intValue())));
                     techAssemble.setTotalGrossWeight(techAssemble.getGrossWeight().multiply(BigDecimal.valueOf(techAssemble.getQuantity().intValue())));
                     this.assembleService.updateById(techAssemble);
                     this.assembleExtService.addReduceExt(techAssemble, changeAssemble.getArtifactRate());
                     List<TechAssembleMachinePartLink> assembleMachinePartLinkList = this.assembleMachinePartLinkService
                        .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.builder().assembleId(techAssemble.getId()).build()));
                     if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
                        Map<Long, TechMachinePart> assemblePartMap = this.machinePartService
                           .listByIds(assembleMachinePartLinkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList()))
                           .stream()
                           .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
                        assembleMachinePartLinkList.forEach(link -> {
                           TechMachinePart assemblePart = assemblePartMap.get(link.getMachinePartId());
                           assemblePart.setQuantity(assemblePart.getQuantity() + changeAssemble.getArtifactRate() * link.getQuantity());
                           assemblePart.setTotalNetWeight(assemblePart.getNetWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                           assemblePart.setTotalGrossWeight(assemblePart.getGrossWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                        });
                        this.machinePartService.updateBatchById(assemblePartMap.values());
                     }

                     TechAssembleDetail assembleDetail = TechAssembleDetail.builder()
                        .artifactId(artifact.getId())
                        .assembleId(techAssemble.getId())
                        .quantity(changeAssemble.getArtifactRate())
                        .build();
                     artifactAssembleLinkList.add(assembleDetail);
                  } else {
                     techAssemble = BeanUtil.copy(changeAssemble, TechAssemble.class);
                     if (artifact.getBoolAllPartSendDirectly()) {
                        techAssemble.setName(artifact.getName());
                     }

                     techAssemble.setProjectId(changeRecord.getProjectId());
                     techAssemble.setMonomerId(changeRecord.getMonomerId());
                     techAssemble.setAreaId(artifact.getAreaId());
                     techAssemble.setAreaBatchId(artifact.getAreaBatchId());
                     techAssemble.setAreaType(AreaTypeEnum.PROCESS.getType());
                     techAssemble.setQuantity(changeAssemble.getArtifactRate());
                     techAssemble.setTotalNetWeight(techAssemble.getNetWeight().multiply(BigDecimal.valueOf(techAssemble.getQuantity().intValue())));
                     techAssemble.setTotalGrossWeight(techAssemble.getGrossWeight().multiply(BigDecimal.valueOf(techAssemble.getQuantity().intValue())));
                     techAssemble.setProductionLineTypeEnum(artifact.getProductionLineTypeEnum());
                     techAssemble.setBoolMainAssemble(
                        artifact.getProductionLineTypeEnum().equals(ProductionLineTypeEnum.TRADITIONAL_LINE.getType())
                           && techAssemble.getSpecification().equals(artifact.getSpecification())
                     );
                     techAssemble.setBoolHaveNC1(monomerAssembleDrawingMap.containsKey(techAssemble.getSerialNumber()));
                     techAssemble.setAssembleConfigId(assembleSpecMap.get(techAssemble.getSpecPrefix()).getAssembleConfigId());
                     techAssemble.setBoolSectionSteel(assembleSpecMap.get(techAssemble.getSpecPrefix()).getBoolSectionSteel());
                     techAssemble.setBoolSchedulingEnum(
                        project.getMode().equals(ProjectModeEnum.STANDARD_MODE.getType()) && assembleProcessMap.containsKey(techAssemble.getAssembleConfigId())
                     );
                     techAssemble.setBoolProcess(techAssemble.getBoolSchedulingEnum());
                     techAssemble.setSurfaceArea(
                        changeAssemble.getSurfaceArea() != null ? changeAssemble.getSurfaceArea().multiply(BigDecimal.valueOf(1000000L)) : BigDecimal.ZERO
                     );
                     this.assembleService.save(techAssemble);
                     this.assembleExtService.addReduceExt(techAssemble, techAssemble.getQuantity());
                     TechAssembleDetail assembleDetail = TechAssembleDetail.builder()
                        .artifactId(artifact.getId())
                        .assembleId(techAssemble.getId())
                        .quantity(changeAssemble.getArtifactRate())
                        .build();
                     artifactAssembleLinkList.add(assembleDetail);
                     List<TechChangeMachinePart> changeAssembleParts = changeassembleMachinePartMap.get(changeAssemble.getId());
                     if (CollectionUtils.isNotEmpty(changeAssembleParts)) {
                        List<TechMachinePart> machinePartList = this.machinePartService
                           .list(
                              Wrappers.lambdaQuery(TechMachinePart.class)
                                 .eq(TechMachinePart::getAreaBatchId, artifact.getAreaBatchId())
                                 .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
                                 .in(
                                    TechMachinePart::getSerialNumber,
                                    changeAssembleParts.stream().map(TechChangeMachinePart::getSerialNumber).collect(Collectors.toList())
                                 )
                           );
                        Map<String, List<TechMachinePart>> assemblePartSnGroupMap = machinePartList.stream()
                           .collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
                        TechAssemble finalTechAssemble = techAssemble;
                        changeAssembleParts.forEach(
                           changeAssemblePart -> {
                              TechMachinePart assemblePart = null;
                              List<TechMachinePart> assemblePartList = assemblePartSnGroupMap.getOrDefault(changeAssemblePart.getSerialNumber(), null);
                              if (CollectionUtils.isNotEmpty(assemblePartList)) {
                                 assemblePart = assemblePartList.get(0);
                              }

                              if (assemblePart != null) {
                                 assemblePart.setQuantity(assemblePart.getQuantity() + changeAssemblePart.getArtifactRate());
                                 assemblePart.setTotalNetWeight(assemblePart.getNetWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                                 assemblePart.setTotalGrossWeight(
                                    assemblePart.getGrossWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue()))
                                 );
                                 this.machinePartService.updateById(assemblePart);
                                 TechAssembleMachinePartLink link = TechAssembleMachinePartLink.builder()
                                    .assembleId(finalTechAssemble.getId())
                                    .machinePartId(assemblePart.getId())
                                    .quantity(changeAssemblePart.getArtifactRate())
                                    .build();
                                 addAssembleMachinePartLinkList.add(link);
                              } else {
                                 assemblePart = BeanUtil.copy(changeAssemblePart, TechMachinePart.class);
                                 assemblePart.setProjectId(changeRecord.getProjectId());
                                 assemblePart.setMonomerId(changeRecord.getMonomerId());
                                 assemblePart.setAreaId(artifact.getAreaId());
                                 assemblePart.setAreaBatchId(artifact.getAreaBatchId());
                                 assemblePart.setAreaType(AreaTypeEnum.PROCESS.getType());
                                 assemblePart.setQuantity(changeAssemblePart.getArtifactRate());
                                 assemblePart.setSteelId(steelMatchMap.get(assemblePart.getSpecPrefix()).getSteelId());
                                 assemblePart.setThick(TechUtils.getMachinePartThick(assemblePart.getSpecification()));
                                 assemblePart.setSteelSpec(assemblePart.getThick());
                                 assemblePart.setBoolHaveHole(holeNumberMap.containsKey(assemblePart.getSerialNumber()));
                                 assemblePart.setHoleNumber(holeNumberMap.getOrDefault(assemblePart.getSerialNumber(), 0L));
                                 assemblePart.setBoolSchedulingEnum(false);
                                 assemblePart.setBoolProcess(false);
                                 if (monomerPartDrawingMap.containsKey(assemblePart.getSerialNumber())) {
                                    TechDrawing drawing = monomerPartDrawingMap.get(assemblePart.getSerialNumber()).get(0);
                                    assemblePart.setPath(drawing.getCloudPath());
                                    assemblePart.setOssRelativePath(
                                       assemblePart.getProjectId() + "/" + assemblePart.getMonomerId() + "/" + drawing.getFileName()
                                    );
                                 }

                                 this.machinePartService.save(assemblePart);
                                 TechAssembleMachinePartLink link = TechAssembleMachinePartLink.builder()
                                    .assembleId(finalTechAssemble.getId())
                                    .machinePartId(assemblePart.getId())
                                    .quantity(changeAssemblePart.getArtifactRate())
                                    .build();
                                 addAssembleMachinePartLinkList.add(link);
                              }
                           }
                        );
                     }
                  }
               }
            );
         }

         this.assembleDetailService.saveBatch(artifactAssembleLinkList);
         this.artifactMachinePartLinkService.saveBatch(artifactMachinePartLinkList);
         this.assembleMachinePartLinkService.saveBatch(addAssembleMachinePartLinkList);
      }
   }

   private void changeUpdate(String redisKey, TechChangeRecord changeRecord, List<TechChangeArtifactUpdateDtoParam> updateArtifactList, Integer mesProductEnum) {
      if (CollectionUtils.isNotEmpty(updateArtifactList)) {
         List<TechChangeArtifactDTO> techChangeArtifactDTOS = Convert.toList(TechChangeArtifactDTO.class, this.redisUtils.get(redisKey));
         Preconditions.checkArgument(techChangeArtifactDTOS != null, "redisKey出现错误或者已过期!!");
         List<String> sameSerialNumberList = techChangeArtifactDTOS.stream()
            .filter(TechChangeArtifactDTO::getBoolSameNumber)
            .map(TechChangeArtifactDTO::getSerialNumber)
            .collect(Collectors.toList());
         Map<String, TechChangeArtifactDTO> changeImportArtifactMap = techChangeArtifactDTOS.stream()
            .collect(Collectors.toMap(TechChangeArtifactDTO::getSerialNumber, Function.identity()));
         Set<Long> artifactIds = updateArtifactList.stream().map(TechChangeArtifactUpdateDtoParam::getArtifactId).collect(Collectors.toSet());
         Map<Long, TechArtifact> artifactMap = this.artifactService
            .listByIds(artifactIds)
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<String, SysStructureSpecNumberLink> specNumberLinkMap = this.structureSpecNumberLinkService
            .list((Wrapper<SysStructureSpecNumberLink>)new LambdaQueryWrapper<SysStructureSpecNumberLink>().eq(SysStructureSpecNumberLink::getMesProductEnum, mesProductEnum))
            .stream()
            .collect(Collectors.toMap(e -> e.getSpecPrefix() + "-" + e.getSnPrefix(), Function.identity()));
         Map<String, SysStructureSpec> sysStructureSpecMap = this.structureSpecService
            .list(
               (Wrapper<SysStructureSpec>)(new LambdaQueryWrapper<SysStructureSpec>().eq(SysStructureSpec::getMesProductEnum, mesProductEnum))
                  .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType())
            )
            .stream()
            .collect(Collectors.toMap(SysStructureSpec::getSpecPrefix, Function.identity()));
         Map<String, TechChangeArtifact> changeArtifactMap = new LinkedHashMap<>(16);
         updateArtifactList.forEach(
            dtoParam -> {
               TechArtifact artifact = artifactMap.get(dtoParam.getArtifactId());
               Preconditions.checkArgument(artifact != null, "原构件不存在!");
               TechArtifactExt artifactExt = this.artifactExtService
                  .getOne(Wrappers.lambdaQuery(TechArtifactExt.builder().artifactId(dtoParam.getArtifactId()).sortNumber(dtoParam.getSortNumber()).build()));
               Preconditions.checkArgument(artifactExt != null, "原构件序号不存在!");
               Preconditions.checkArgument(!artifactExt.getBoolSubscription(), "构件码号{" + dtoParam.getSortNumber() + "}已办理过申购,不可变更");
               Preconditions.checkArgument(changeImportArtifactMap.containsKey(dtoParam.getChangeSerialNumber()), "变更清单编号未导入!");
               TechChangeArtifactDTO changeImportArtifactDTO = changeImportArtifactMap.get(dtoParam.getChangeSerialNumber());
               Preconditions.checkArgument(
                  artifact.getBoolAllPartSendDirectly().equals(changeImportArtifactDTO.getBoolAllPartSendDirectly()), "直发檩条与非直发檩条不可相互利用!"
               );
               Preconditions.checkArgument(artifact.getSpecification().equals(changeImportArtifactDTO.getSpecification()), "构件规格不可变更!!");
               Preconditions.checkArgument(
                  specNumberLinkMap.get(changeImportArtifactDTO.getSpecPrefix() + "-" + changeImportArtifactDTO.getSerialNumberPrefix()) != null
                     || sysStructureSpecMap.get(changeImportArtifactDTO.getSpecPrefix()) != null,
                  "操作失败,导入的变更清单规格类型在未配置!!!"
               );
               Preconditions.checkArgument(artifact.getCodingType().equals(changeImportArtifactDTO.getCodingType()), "变更的构件与原构件扫码方式不一致!");
               Preconditions.checkArgument(changeImportArtifactDTO.getStructureClassId() != null, "变更的构件未匹配到相关特征定义!!!");
               Preconditions.checkArgument(artifact.getStructureClassId().equals(changeImportArtifactDTO.getStructureClassId()), "变更后的构件与原构件构件特征定义id不一致!");
               artifactExt.setBoolStatusEnum(Boolean.FALSE);
               this.artifactExtService.updateById(artifactExt);
               artifact.setBoolStatusEnum(Boolean.FALSE);
               this.artifactService.updateById(artifact);
               if (!changeArtifactMap.containsKey(dtoParam.getChangeSerialNumber())) {
                  TechChangeArtifactDTO artifactDTO = changeImportArtifactMap.get(dtoParam.getChangeSerialNumber());
                  TechChangeArtifact changeArtifact = BeanUtil.copy(artifactDTO, TechChangeArtifact.class);
                  changeArtifact.setChangeRecordId(changeRecord.getId());
                  changeArtifact.setUserId(UserUtil.getCurrentUserId());
                  changeArtifact.setTotalGrossWeight(changeArtifact.getGrossWeight().multiply(BigDecimal.valueOf(changeArtifact.getQuantity().intValue())));
                  changeArtifact.setTotalNetWeight(changeArtifact.getNetWeight().multiply(BigDecimal.valueOf(changeArtifact.getQuantity().intValue())));
                  this.changeArtifactService.save(changeArtifact);
                  changeArtifactMap.put(dtoParam.getChangeSerialNumber(), changeArtifact);
                  List<TechChangeMachinePart> changeMachineParts = new ArrayList<>(32);
                  artifactDTO.getMachinePartList()
                     .forEach(
                        changeMachinePartDTO -> {
                           TechChangeMachinePart changeMachinePart = BeanUtil.copy(changeMachinePartDTO, TechChangeMachinePart.class);
                           changeMachinePart.setChangeRecordId(changeRecord.getId());
                           changeMachinePart.setChangeArtifactId(changeArtifact.getId());
                           changeMachinePart.setArtifactRate(changeMachinePartDTO.getQuantity() / artifactDTO.getQuantity());
                           changeMachinePart.setTotalGrossWeight(
                              changeMachinePart.getGrossWeight() == null
                                 ? BigDecimal.ZERO
                                 : changeMachinePart.getGrossWeight().multiply(BigDecimal.valueOf(changeMachinePart.getQuantity().intValue()))
                           );
                           changeMachinePart.setTotalNetWeight(
                              changeMachinePart.getNetWeight() == null
                                 ? BigDecimal.ZERO
                                 : changeMachinePart.getNetWeight().multiply(BigDecimal.valueOf(changeMachinePart.getQuantity().intValue()))
                           );
                           changeMachineParts.add(changeMachinePart);
                        }
                     );
                  this.changeMachinePartService.saveBatch(changeMachineParts);
               }

               TechChangeRecordDetail changeRecordDetail = BeanUtil.copy(artifact, TechChangeRecordDetail.class);
               BeanUtil.copy(dtoParam, changeRecordDetail);
               changeRecordDetail.setChangeRecordId(changeRecord.getId());
               changeRecordDetail.setType(ArtifactChangeTypeEnum.UPDATE.getType());
               this.changeRecordDetailService.save(changeRecordDetail);
            }
         );
      }
   }

   private void changeUpdateV2(String redisKey, TechChangeRecord changeRecord, List<TechChangeArtifactUpdateDtoParam> updateArtifactList) {
      if (CollectionUtils.isNotEmpty(updateArtifactList)) {
         PlanMonomer monomer = this.monomerService.getById(changeRecord.getMonomerId());
         List<ArtifactBoxImportDTO> techChangeArtifactDTOS = Convert.toList(ArtifactBoxImportDTO.class, this.redisUtils.get(redisKey));
         Preconditions.checkArgument(techChangeArtifactDTOS != null, "redisKey出现错误或者已过期!!");
         List<String> sameSerialNumberList = techChangeArtifactDTOS.stream()
            .filter(ArtifactBoxImportDTO::getBoolSameNumber)
            .map(ArtifactPartImportCommonDTO::getSerialNumber)
            .collect(Collectors.toList());
         Map<String, ArtifactBoxImportDTO> changeImportArtifactMap = techChangeArtifactDTOS.stream()
            .collect(Collectors.toMap(ArtifactPartImportCommonDTO::getSerialNumber, Function.identity()));
         Set<Long> artifactIds = updateArtifactList.stream().map(TechChangeArtifactUpdateDtoParam::getArtifactId).collect(Collectors.toSet());
         Map<Long, TechArtifact> artifactMap = this.artifactService
            .listByIds(artifactIds)
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<String, SysStructureSpecNumberLink> specNumberLinkMap = this.structureSpecNumberLinkService
            .list(
               (Wrapper<SysStructureSpecNumberLink>)new LambdaQueryWrapper<SysStructureSpecNumberLink>()
                  .eq(SysStructureSpecNumberLink::getMesProductEnum, BuildingTypeEnum.getMesProductTypeByType(monomer.getBuildingTypeEnum()))
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getSpecPrefix() + "-" + e.getSnPrefix(), Function.identity()));
         Map<String, SysStructureSpec> sysStructureSpecMap = this.structureSpecService
            .list(
               (Wrapper<SysStructureSpec>)((new LambdaQueryWrapper<SysStructureSpec>()
                        .eq(SysStructureSpec::getMesProductEnum, monomer.getBuildingTypeEnum()))
                     .eq(SysStructureSpec::getProductionLineTypeEnum, ProductionLineTypeEnum.TRADITIONAL_LINE.getType()))
                  .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType())
            )
            .stream()
            .collect(Collectors.toMap(SysStructureSpec::getSpecPrefix, Function.identity()));
         Map<String, TechChangeArtifact> changeArtifactMap = new LinkedHashMap<>(16);
         updateArtifactList.forEach(
            dtoParam -> {
               TechArtifact artifact = artifactMap.get(dtoParam.getArtifactId());
               Preconditions.checkArgument(artifact != null, "原构件不存在!");
               TechArtifactExt artifactExt = this.artifactExtService
                  .getOne(Wrappers.lambdaQuery(TechArtifactExt.builder().artifactId(dtoParam.getArtifactId()).sortNumber(dtoParam.getSortNumber()).build()));
               Preconditions.checkArgument(artifactExt != null, "原构件序号不存在!");
               Preconditions.checkArgument(changeImportArtifactMap.containsKey(dtoParam.getChangeSerialNumber()), "变更清单编号未导入!");
               ArtifactBoxImportDTO changeImportArtifactDTO = changeImportArtifactMap.get(dtoParam.getChangeSerialNumber());
               Preconditions.checkArgument(
                  artifact.getBoolAllPartSendDirectly().equals(changeImportArtifactDTO.getBoolAllPartSendDirectly()), "直发檩条与非直发檩条不可相互利用!"
               );
               Preconditions.checkArgument(
                  artifact.getSpecification().equals(changeImportArtifactDTO.getSpecification())
                     && artifact.getMaterial().equals(changeImportArtifactDTO.getMaterial()),
                  "构件规格和材质不可变更!!"
               );
               Preconditions.checkArgument(
                  specNumberLinkMap.get(changeImportArtifactDTO.getSpecPrefix() + "-" + changeImportArtifactDTO.getSerialNumberPrefix()) != null
                     || sysStructureSpecMap.get(changeImportArtifactDTO.getSpecPrefix()) != null,
                  "操作失败,导入的变更清单规格类型在未配置!!!"
               );
               Preconditions.checkArgument(artifact.getCodingType().equals(changeImportArtifactDTO.getCodingType()), "变更的构件与原构件扫码方式不一致!!!");
               Preconditions.checkArgument(changeImportArtifactDTO.getStructureClassId() != null, "变更的构件未匹配到相关特征定义!!!");
               Preconditions.checkArgument(artifact.getStructureClassId().equals(changeImportArtifactDTO.getStructureClassId()), "变更的构件与原构件构件特征定义id不一致!");
               artifactExt.setBoolStatusEnum(Boolean.FALSE);
               this.artifactExtService.updateById(artifactExt);
               artifact.setBoolStatusEnum(Boolean.FALSE);
               this.artifactService.updateById(artifact);
               List<TechChangeMachinePart> changeMachineParts = new ArrayList<>(32);
               if (!changeArtifactMap.containsKey(dtoParam.getChangeSerialNumber())) {
                  ArtifactBoxImportDTO artifactDTO = changeImportArtifactMap.get(dtoParam.getChangeSerialNumber());
                  TechChangeArtifact changeArtifact = BeanUtil.copy(artifactDTO, TechChangeArtifact.class);
                  changeArtifact.setChangeRecordId(changeRecord.getId());
                  changeArtifact.setUserId(UserUtil.getCurrentUserId());
                  changeArtifact.setTotalGrossWeight(changeArtifact.getGrossWeight().multiply(BigDecimal.valueOf(changeArtifact.getQuantity().intValue())));
                  changeArtifact.setTotalNetWeight(changeArtifact.getNetWeight().multiply(BigDecimal.valueOf(changeArtifact.getQuantity().intValue())));
                  changeArtifact.setSurfaceArea(changeArtifact.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 5, RoundingMode.HALF_UP));
                  this.changeArtifactService.save(changeArtifact);
                  changeArtifactMap.put(dtoParam.getChangeSerialNumber(), changeArtifact);
                  artifactDTO.getMachinePartImportDtoParamList()
                     .forEach(
                        changeMachinePartDTO -> {
                           TechChangeMachinePart changeMachinePart = BeanUtil.copy(changeMachinePartDTO, TechChangeMachinePart.class);
                           changeMachinePart.setChangeRecordId(changeRecord.getId());
                           changeMachinePart.setChangeArtifactId(changeArtifact.getId());
                           changeMachinePart.setTotalNetWeight(
                              changeMachinePart.getNetWeight() == null
                                 ? BigDecimal.ZERO
                                 : changeMachinePart.getNetWeight().multiply(BigDecimal.valueOf(changeMachinePart.getQuantity().intValue()))
                           );
                           changeMachinePart.setTotalNetWeight(
                              changeMachinePart.getGrossWeight() == null
                                 ? BigDecimal.ZERO
                                 : changeMachinePart.getGrossWeight().multiply(BigDecimal.valueOf(changeMachinePart.getQuantity().intValue()))
                           );
                           changeMachineParts.add(changeMachinePart);
                        }
                     );
                  artifactDTO.getAssembleImportDtoParamList()
                     .forEach(
                        changeAssembleDTO -> {
                           TechChangeMachinePart changeAssemble = BeanUtil.copy(changeAssembleDTO, TechChangeMachinePart.class);
                           changeAssemble.setChangeRecordId(changeRecord.getId());
                           changeAssemble.setChangeArtifactId(changeArtifact.getId());
                           changeAssemble.setArtifactRate(changeAssemble.getQuantity() / artifactDTO.getQuantity());
                           changeAssemble.setTotalNetWeight(
                              changeAssemble.getNetWeight() == null
                                 ? BigDecimal.ZERO
                                 : changeAssemble.getNetWeight().multiply(BigDecimal.valueOf(changeAssemble.getQuantity().intValue()))
                           );
                           changeAssemble.setTotalNetWeight(
                              changeAssemble.getGrossWeight() == null
                                 ? BigDecimal.ZERO
                                 : changeAssemble.getGrossWeight().multiply(BigDecimal.valueOf(changeAssemble.getQuantity().intValue()))
                           );
                           this.changeMachinePartService.save(changeAssemble);
                           changeAssembleDTO.getAssembleElementMachinePartList()
                              .forEach(
                                 changeAssemblePartDTO -> {
                                    TechChangeMachinePart changeAssemblePart = BeanUtil.copy(changeAssemblePartDTO, TechChangeMachinePart.class);
                                    changeAssemblePart.setChangeRecordId(changeRecord.getId());
                                    changeAssemblePart.setChangeArtifactId(changeArtifact.getId());
                                    changeAssemblePart.setChangeAssembleId(changeAssemble.getId());
                                    changeAssemblePart.setArtifactRate(changeAssemblePartDTO.getQuantityRatio());
                                    changeAssemblePart.setTotalNetWeight(
                                       changeAssemblePart.getNetWeight() == null
                                          ? BigDecimal.ZERO
                                          : changeAssemblePart.getNetWeight().multiply(BigDecimal.valueOf(changeAssemblePart.getQuantity().intValue()))
                                    );
                                    changeAssemblePart.setTotalNetWeight(
                                       changeAssemblePart.getGrossWeight() == null
                                          ? BigDecimal.ZERO
                                          : changeAssemblePart.getGrossWeight().multiply(BigDecimal.valueOf(changeAssemblePart.getQuantity().intValue()))
                                    );
                                    changeMachineParts.add(changeAssemblePart);
                                 }
                              );
                        }
                     );
                  artifactDTO.getStandardPartImportDTOParamList().forEach(changeStandardPartDTO -> {
                     TechChangeMachinePart changeStandardPart = BeanUtil.copy(changeStandardPartDTO, TechChangeMachinePart.class);
                     changeStandardPart.setChangeRecordId(changeRecord.getId());
                     changeStandardPart.setChangeArtifactId(changeArtifact.getId());
                     changeStandardPart.setArtifactRate(changeStandardPart.getQuantity() / artifactDTO.getQuantity());
                     changeStandardPart.setTotalNetWeight(BigDecimal.ZERO);
                     changeStandardPart.setTotalGrossWeight(BigDecimal.ZERO);
                     changeStandardPart.setSurfaceArea(BigDecimal.ZERO);
                     changeMachineParts.add(changeStandardPart);
                  });
               }

               this.changeMachinePartService.saveBatch(changeMachineParts);
               TechChangeRecordDetail changeRecordDetail = BeanUtil.copy(artifact, TechChangeRecordDetail.class);
               BeanUtil.copy(dtoParam, changeRecordDetail);
               changeRecordDetail.setChangeRecordId(changeRecord.getId());
               changeRecordDetail.setType(ArtifactChangeTypeEnum.UPDATE.getType());
               if (changeRecordDetail.getSerialNumber().equals(changeRecordDetail.getChangeSerialNumber())) {
                  Preconditions.checkArgument(
                     CollectionUtils.isNotEmpty(sameSerialNumberList)
                        && sameSerialNumberList.contains(changeRecordDetail.getSerialNumber())
                        && artifact.getQuantity() == 1,
                     "操作失败,构件编号" + artifact.getSerialNumber() + "在该单体下的数量大于1,暂不支持相同编号的变更!"
                  );
                  changeRecordDetail.setBoolSameNumber(Boolean.TRUE);
               }

               this.changeRecordDetailService.save(changeRecordDetail);
            }
         );
      }
   }

   private void changeDel(Long changeRecordId, List<TechChangeArtifactDelDtoParam> delArtifactList) {
      if (CollectionUtils.isNotEmpty(delArtifactList)) {
         Set<Long> artifactIds = delArtifactList.stream().map(TechChangeArtifactDelDtoParam::getArtifactId).collect(Collectors.toSet());
         Map<Long, TechArtifact> artifactMap = this.artifactService
            .listByIds(artifactIds)
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<String, TechArtifactExt> artifactExtMap = this.artifactExtService
            .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().in(TechArtifactExt::getArtifactId, artifactIds))
            .stream()
            .collect(Collectors.toMap(e -> e.getArtifactId() + "-" + e.getSortNumber(), Function.identity()));
         delArtifactList.forEach(dtoParam -> {
            TechArtifact artifact = artifactMap.get(dtoParam.getArtifactId());
            TechArtifactExt artifactExt = artifactExtMap.get(dtoParam.getArtifactId() + "-" + dtoParam.getSortNumber());
            Preconditions.checkArgument(!artifactExt.getBoolSubscription(), "构件码号{" + dtoParam.getSortNumber() + "}已办理过申购,不可变更");
            artifactExt.setBoolStatusEnum(Boolean.FALSE);
            this.artifactExtService.updateById(artifactExt);
            artifact.setBoolStatusEnum(Boolean.FALSE);
            this.artifactService.updateById(artifact);
            TechChangeRecordDetail changeRecordDetail = BeanUtil.copy(artifact, TechChangeRecordDetail.class);
            changeRecordDetail.setArtifactId(dtoParam.getArtifactId());
            changeRecordDetail.setSortNumber(dtoParam.getSortNumber());
            changeRecordDetail.setChangeRecordId(changeRecordId);
            changeRecordDetail.setType(ArtifactChangeTypeEnum.DEL.getType());
            this.changeRecordDetailService.save(changeRecordDetail);
         });
      }
   }

   private ContractProject checkParam(TechChangeSaveDtoParam param) {
      Preconditions.checkArgument(
         CollectionUtils.isNotEmpty(param.getDelArtifactList())
            || CollectionUtils.isNotEmpty(param.getUpdateArtifactList())
            || param.getArtifactBasicChangeDTOParam() != null,
         "变更数据不能为空!"
      );
      List<List<?>> collect = Stream.<List<?>>of(
            param.getDelArtifactList(),
            param.getUpdateArtifactList(),
            param.getArtifactBasicChangeDTOParam() != null ? Collections.singletonList(param.getArtifactBasicChangeDTOParam()) : new ArrayList()
         )
         .collect(Collectors.toList());
      Preconditions.checkArgument(collect.stream().filter(e -> CollectionUtils.isNotEmpty(e) && !e.isEmpty()).count() == 1L, "操作失败,数据有误!!!");
      if (CollectionUtils.isNotEmpty(param.getUpdateArtifactList())) {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getRedisKey()), "redisKey不能为空!");
         Preconditions.checkArgument(this.redisUtils.get(param.getRedisKey()) != null, "redisKey不存在或已过期!!");
      }

      SysChangeReason changeReason = this.changeReasonService.getById(param.getChangeReasonId());
      Preconditions.checkArgument(changeReason != null, "变更原因未配置!");
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在!");
      ContractProject project = this.projectService.checkProjectStatus(monomer.getProjectId());
      if (ChangeScopeEnum.AREA.getType().equals(param.getChangeScopeEnum())) {
         Preconditions.checkArgument(param.getAreaId() != null, "区域id不存在!!!");
         PlanArea area = this.areaService.getById(param.getAreaId());
         Preconditions.checkArgument(area != null, "区域不存在!");
         Preconditions.checkArgument(param.getMonomerId().equals(area.getMonomerId()), "单体id和区域id不匹配!");
      }

      if (ChangeScopeEnum.AREA_BATCH.getType().equals(param.getChangeScopeEnum())) {
         Preconditions.checkArgument(param.getAreaBatchId() != null, "批次id不存在!!!");
         PlanAreaBatch areaBatch = this.areaBatchService.getById(param.getAreaBatchId());
         Preconditions.checkArgument(areaBatch != null, "区域不存在!");
         Preconditions.checkArgument(param.getMonomerId().equals(areaBatch.getMonomerId()), "单体id和批次id不匹配!");
      }

      if (CollectionUtils.isNotEmpty(param.getUpdateArtifactList())) {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getAttachmentIds()), "变更构件,附件不能为空!!!");
         Preconditions.checkArgument(param.getChangeScopeEnum() != null, "变更构件,变更范围不能为空!!!");
      }

      Map<Long, List<Integer>> artifactIdSortNumberListMap = new HashMap<>(16);
      if (CollectionUtils.isNotEmpty(param.getUpdateArtifactList())) {
         param.getUpdateArtifactList()
            .forEach(
               artifactUpdateDtoParam -> {
                  Preconditions.checkArgument(
                     !artifactIdSortNumberListMap.containsKey(artifactUpdateDtoParam.getArtifactId())
                        || !artifactIdSortNumberListMap.get(artifactUpdateDtoParam.getArtifactId()).contains(artifactUpdateDtoParam.getSortNumber()),
                     "同一构件序列号,不能变更多次!"
                  );
                  List<Integer> sortNumberList = artifactIdSortNumberListMap.getOrDefault(artifactUpdateDtoParam.getArtifactId(), new ArrayList<>(16));
                  sortNumberList.add(artifactUpdateDtoParam.getSortNumber());
                  artifactIdSortNumberListMap.put(artifactUpdateDtoParam.getArtifactId(), sortNumberList);
               }
            );
      }

      if (CollectionUtils.isNotEmpty(param.getDelArtifactList())) {
         param.getDelArtifactList()
            .forEach(
               artifactDelDtoParam -> {
                  Preconditions.checkArgument(
                     !artifactIdSortNumberListMap.containsKey(artifactDelDtoParam.getArtifactId())
                        || !artifactIdSortNumberListMap.get(artifactDelDtoParam.getArtifactId()).contains(artifactDelDtoParam.getSortNumber()),
                     "同一构件序列号,不能变更多次!"
                  );
                  List<Integer> sortNumberList = artifactIdSortNumberListMap.getOrDefault(artifactDelDtoParam.getArtifactId(), new ArrayList<>(16));
                  sortNumberList.add(artifactDelDtoParam.getSortNumber());
                  artifactIdSortNumberListMap.put(artifactDelDtoParam.getArtifactId(), sortNumberList);
               }
            );
      }

      if (CollectionUtils.isNotEmpty(param.getUpdateArtifactList())) {
         List<TechCappCraftProductTask> techCappCraftProductTasks = this.techCappCraftProductTaskBiz
            .list(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .in(
                     TechCappCraftProductTask::getProductId,
                     param.getUpdateArtifactList().stream().map(TechChangeArtifactUpdateDtoParam::getArtifactId).collect(Collectors.toList())
                  )
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(techCappCraftProductTasks), "当前区域存在构件焊接任务不可删除!!!");
      }

      if (CollectionUtils.isNotEmpty(param.getDelArtifactList())) {
         List<TechCappCraftProductTask> techCappCraftProductTaskList = this.techCappCraftProductTaskBiz
            .list(
               Wrappers.lambdaQuery(TechCappCraftProductTask.class)
                  .eq(TechCappCraftProductTask::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .in(
                     TechCappCraftProductTask::getProductId,
                     param.getDelArtifactList().stream().map(TechChangeArtifactDelDtoParam::getArtifactId).collect(Collectors.toList())
                  )
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(techCappCraftProductTaskList), "当前区域存在构件焊接任务不可删除!!!");
      }

      if (CollectionUtils.isNotEmpty(artifactIdSortNumberListMap)) {
         this.mesBuildingCalcMaxNumManager.checkArtifactNumberChanger(artifactIdSortNumberListMap, Boolean.FALSE);
      }

      return project;
   }

   public TechChangeRecordBizImpl(
      final RedisUtils redisUtils,
      final AttachmentService attachmentService,
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final PlanAreaBatchService areaBatchService,
      final SysStructureSpecService structureSpecService,
      final SysStructureSpecNumberLinkService structureSpecNumberLinkService,
      final SysAssembleSpecService assembleSpecService,
      final SysSteelClassificationMatchService steelClassificationMatchService,
      final TechArtifactService artifactService,
      final BusinessArtifactService businessArtifactService,
      final TechMachinePartService machinePartService,
      final TechAssembleService assembleService,
      final TechAssembleDetailService assembleDetailService,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechDrawingService drawingService,
      final TechMachineHoleRadiusLinkService machineHoleRadiusLinkService,
      final TechArtifactExtService artifactExtService,
      final TechAssembleExtService assembleExtService,
      final SysChangeReasonService changeReasonService,
      final TechChangeArtifactService changeArtifactService,
      final TechChangeMachinePartService changeMachinePartService,
      final TechChangeRecordDetailService changeRecordDetailService,
      final MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService,
      final MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager,
      final MesBuildingOneCodeChangBiz mesBuildingOneCodeChangBiz,
      final SysStructureClassificationService structureClassificationService,
      final MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService,
      final MesBuildingTaskBiz mesBuildingTaskBiz,
      final MesBuildingProductProcessService productProcessService,
      final TechArtifactStandardPartLinkService artifactStandardPartLinkService,
      final TechStandardPartService standardPartService,
      final MesTechInventoryOperationService inventoryOperationService,
      final MonomerUserLinkService monomerUserLinkService,
      final SysPushFlowConfigBiz sysPushFlowConfigBiz,
      final NotificationTemplateDetailsUtils detailsUtils,
      final MesTechInventoryOperationService mesTechInventoryOperationService,
      final TechChangeRecordService changeRecordService,
      final MesBuildingTaskManager taskManager,
      final TechCappCraftProductTaskBiz techCappCraftProductTaskBiz,
      final TechCappCraftCardProductLinkBiz techCappCraftCardProductLinkBiz,
      final MoveOutboundDetailService outboundDetailService
   ) {
      this.redisUtils = redisUtils;
      this.attachmentService = attachmentService;
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.areaBatchService = areaBatchService;
      this.structureSpecService = structureSpecService;
      this.structureSpecNumberLinkService = structureSpecNumberLinkService;
      this.assembleSpecService = assembleSpecService;
      this.steelClassificationMatchService = steelClassificationMatchService;
      this.artifactService = artifactService;
      this.businessArtifactService = businessArtifactService;
      this.machinePartService = machinePartService;
      this.assembleService = assembleService;
      this.assembleDetailService = assembleDetailService;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.drawingService = drawingService;
      this.machineHoleRadiusLinkService = machineHoleRadiusLinkService;
      this.artifactExtService = artifactExtService;
      this.assembleExtService = assembleExtService;
      this.changeReasonService = changeReasonService;
      this.changeArtifactService = changeArtifactService;
      this.changeMachinePartService = changeMachinePartService;
      this.changeRecordDetailService = changeRecordDetailService;
      this.mesBuildingTaskNumberLinkService = mesBuildingTaskNumberLinkService;
      this.mesBuildingCalcMaxNumManager = mesBuildingCalcMaxNumManager;
      this.mesBuildingOneCodeChangBiz = mesBuildingOneCodeChangBiz;
      this.structureClassificationService = structureClassificationService;
      this.mesBuildingWarehouseSummaryService = mesBuildingWarehouseSummaryService;
      this.mesBuildingTaskBiz = mesBuildingTaskBiz;
      this.productProcessService = productProcessService;
      this.artifactStandardPartLinkService = artifactStandardPartLinkService;
      this.standardPartService = standardPartService;
      this.inventoryOperationService = inventoryOperationService;
      this.monomerUserLinkService = monomerUserLinkService;
      this.sysPushFlowConfigBiz = sysPushFlowConfigBiz;
      this.detailsUtils = detailsUtils;
      this.mesTechInventoryOperationService = mesTechInventoryOperationService;
      this.changeRecordService = changeRecordService;
      this.taskManager = taskManager;
      this.techCappCraftProductTaskBiz = techCappCraftProductTaskBiz;
      this.techCappCraftCardProductLinkBiz = techCappCraftCardProductLinkBiz;
      this.outboundDetailService = outboundDetailService;
   }
}
