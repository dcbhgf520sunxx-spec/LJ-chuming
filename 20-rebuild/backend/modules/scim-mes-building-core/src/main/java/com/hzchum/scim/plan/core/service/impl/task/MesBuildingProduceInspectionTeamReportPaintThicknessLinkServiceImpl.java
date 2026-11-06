package com.hzchum.scim.plan.core.service.impl.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseInspectionLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessSaveDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.PaintThicknessRecordQueryParam;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseInspectionLinkService;
import com.hzchum.scim.plan.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReportPaintThicknessLink;
import com.hzchum.scim.plan.core.api.service.task.MesBuildingProduceInspectionTeamReportPaintThicknessLinkService;
import com.hzchum.scim.plan.core.mapper.task.MesBuildingProduceInspectionTeamReportPaintThicknessLinkMapper;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceInspectionTeamReportPaintThicknessLinkServiceImpl
   extends ServiceImpl<MesBuildingProduceInspectionTeamReportPaintThicknessLinkMapper, MesBuildingProduceInspectionTeamReportPaintThicknessLink>
   implements MesBuildingProduceInspectionTeamReportPaintThicknessLinkService {
   @Autowired
   private MesBuildingQhseInspectionLinkService qhseInspectionLinkService;
   @Resource
   private MesBuildingQhseBiz qhseBiz;

   @Override
   public void buildInspectionPaintThicknessMap(
      HashMap<String, List<PaintThicknessSaveDTO>> paintThicknessMap,
      PaintThicknessDO paintThicknessConfig,
      MesBuildingTaskProcess taskProcess,
      InspectionReportSavedDTO dto,
      MesBuildingProduceInspectionTeamReport inspectionTeamReport
   ) {
      if (paintThicknessConfig != null
         && paintThicknessConfig.getEnable()
         && paintThicknessConfig.getProcesses().contains(taskProcess.getProcessId())
         && TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())) {
         if (paintThicknessConfig.getDetectionWay() == 1) {
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(dto.getPaintThicknessList()), "该构件工序配置了必须完成漆膜厚度检测，漆膜厚度检测记录不能为空！");
         }

         if (CollectionUtils.isNotEmpty(dto.getPaintThicknessList())) {
            if (paintThicknessConfig.getMustScope()) {
               boolean allIsScope = dto.getPaintThicknessList()
                  .stream()
                  .allMatch(
                     e -> e.getThickness().compareTo(paintThicknessConfig.getMinThickness()) >= 0
                        && e.getThickness().compareTo(paintThicknessConfig.getMaxThickness()) <= 0
                  );
               Preconditions.checkArgument(
                  allIsScope, "该工序配置了漆膜厚度检测必须在" + paintThicknessConfig.getMinThickness() + " - " + paintThicknessConfig.getMinThickness() + "范围内！"
               );
            }

            paintThicknessMap.put(
               inspectionTeamReport.getTeamId()
                  + "-"
                  + inspectionTeamReport.getTaskTypeEnum()
                  + "-"
                  + inspectionTeamReport.getProductId()
                  + "-"
                  + inspectionTeamReport.getNumber(),
               dto.getPaintThicknessList()
            );
            BigDecimal avgThickness = dto.getPaintThicknessList()
               .stream()
               .map(PaintThicknessSaveDTO::getThickness)
               .filter(Objects::nonNull)
               .reduce(BigDecimal::add)
               .map(sum -> sum.divide(new BigDecimal(dto.getPaintThicknessList().stream().filter(e -> e.getThickness() != null).count()), 2, 4))
               .get();
            inspectionTeamReport.setAvgThickness(avgThickness);
            boolean allIsScope = dto.getPaintThicknessList()
               .stream()
               .allMatch(
                  e -> e.getThickness().compareTo(paintThicknessConfig.getMinThickness()) >= 0
                     && e.getThickness().compareTo(paintThicknessConfig.getMaxThickness()) <= 0
               );
            inspectionTeamReport.setBoolPaintThicknessAdoptEnum(allIsScope);
         }

         inspectionTeamReport.setMaxThickness(paintThicknessConfig.getMaxThickness());
         inspectionTeamReport.setMinThickness(paintThicknessConfig.getMinThickness());
      }
   }

   @Override
   public List<MesBuildingProduceInspectionTeamReportPaintThicknessLink> getPaintThicknessLinkSaveList(
      List<MesBuildingProduceInspectionTeamReport> inspectReports, HashMap<String, List<PaintThicknessSaveDTO>> paintThicknessMap
   ) {
      return inspectReports.stream()
         .flatMap(
            inspectionTeamReport -> {
               List<PaintThicknessSaveDTO> paintThicknessSaveDTOS = paintThicknessMap.getOrDefault(
                  inspectionTeamReport.getTeamId()
                     + "-"
                     + inspectionTeamReport.getTaskTypeEnum()
                     + "-"
                     + inspectionTeamReport.getProductId()
                     + "-"
                     + inspectionTeamReport.getNumber(),
                  Collections.emptyList()
               );
               return paintThicknessSaveDTOS.stream()
                  .map(
                     e -> MesBuildingProduceInspectionTeamReportPaintThicknessLink.builder()
                        .inspectionId(inspectionTeamReport.getId())
                        .thickness(e.getThickness())
                        .name(e.getName())
                        .detectionTime(e.getDetectionTime())
                        .build()
                  );
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<PaintThicknessRecordDTO> getPaintThicknessRecordPage(PaintThicknessRecordQueryParam param, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<PaintThicknessRecordDTO> recordDTOList = this.baseMapper.getPaintThicknessRecordPage(param);
      return new PageVO<>(page, recordDTOList);
   }

   @Override
   public PaintThicknessRecordDTO getPaintThicknessDetail(Long id) {
      PaintThicknessRecordDTO paintThicknessDetail = this.baseMapper.getPaintThicknessDetail(id);
      Preconditions.checkArgument(paintThicknessDetail != null, "质检记录不存在！");
      List<PaintThicknessDTO> collect = this.list(
            Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReportPaintThicknessLink.class)
               .eq(MesBuildingProduceInspectionTeamReportPaintThicknessLink::getInspectionId, paintThicknessDetail.getId())
         )
         .stream()
         .map(e -> BeanUtil.copy(e, PaintThicknessDTO.class))
         .collect(Collectors.toList());
      paintThicknessDetail.setPaintThicknessDTOList(collect);
      if (!paintThicknessDetail.getBoolAdoptEnum()) {
         MesBuildingQhseInspectionLink inspectionLink = this.qhseInspectionLinkService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getInspectionReportId, paintThicknessDetail.getId())
            );
         paintThicknessDetail.setQhseId(inspectionLink.getQhseId());
         MesBuildingQhseDTO qhseDTO = this.qhseBiz.getQhseById(inspectionLink.getQhseId(), null, null);
         paintThicknessDetail.setQhseDTO(qhseDTO);
      }

      return paintThicknessDetail;
   }
}
