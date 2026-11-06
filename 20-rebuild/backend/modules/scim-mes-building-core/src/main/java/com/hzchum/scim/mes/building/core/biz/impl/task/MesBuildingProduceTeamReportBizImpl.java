package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingBoreholeConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingGroupRivetWeldConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.statistica.MesBuildingLayingOffConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingPriceChangeBiz;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban.MesBuildingPainting;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingPriceChange;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeHoleRadiusLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingCoatingConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingLayingOffConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.projectKanban.MesBuildingPaintingService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingCoatingConfigService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class MesBuildingProduceTeamReportBizImpl implements MesBuildingProduceTeamReportBiz {
   @Autowired
   private MesBuildingProduceTeamReportService teamReportService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private MesBuildingProduceTeamReportPriceService teamReportPriceService;
   @Autowired
   private ConfigService configService;
   @Autowired
   private MesBuildingPaintingService paintingService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private TechMachineHoleRadiusLinkService techMachineHoleRadiusLinkService;
   @Autowired
   private MesBuildingCoatingConfigService coatingConfigService;
   @Autowired
   private MesBuildingGroupRivetWeldConfigBiz configBiz;
   @Autowired
   private MesBuildingBoreholeConfigBiz boreholeConfigBiz;
   @Autowired
   private MesBuildingLayingOffConfigBiz layingOffConfigBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Autowired
   private MesBuildingPriceChangeBiz priceChangeBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePice(Long id, Integer inspectionQuantity) {
      MesBuildingProduceTeamReport teamReport = this.teamReportService.getById(id);
      Preconditions.checkArgument(teamReport != null, "操作失败，参数不正确");
      MesBuildingProcess process = this.processService.getById(teamReport.getProcessId());
      List<MesBuildingProduceTeamReportPrice> priceList = this.teamReportPriceService
         .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class).eq(MesBuildingProduceTeamReportPrice::getTeamReoprtId, id));
      if (priceList.size() == 0) {
         MesBuildingTask task = this.taskBiz.getById(teamReport.getTaskId());
         MesBuildingStructureProcessPriceDTO weldConfigPrice = this.configBiz
            .getWeldConfigPrice(teamReport.getProductId(), teamReport.getTaskTypeEnum(), teamReport.getProcessId());
         MesBuildingProduceTeamReportPrice teamReportPrice = BeanUtil.copy(teamReport, MesBuildingProduceTeamReportPrice.class);
         teamReportPrice.setTeamReoprtId(teamReport.getId());
         teamReportPrice.setCreateTime(LocalDateTime.now());
         teamReportPrice.setTaskOrderId(task.getTaskOrderId());
         teamReportPrice.setQuantity(teamReport.getQuantity());
         teamReportPrice.setInspectionQuantity(inspectionQuantity);
         if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService.getById(teamReport.getProductId());
            if (process.getType().equals(ProcessTypeEnum.PAINT.getType())) {
               List<MesBuildingPainting> paintingList = this.paintingService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingPainting.class)
                        .eq(MesBuildingPainting::getMonomerId, task.getMonomerId())
                        .eq(MesBuildingPainting::getProjectId, task.getProjectId())
                  );
               Map<Integer, MesBuildingCoatingConfigDTO> coatingConfigMap = this.coatingConfigService
                  .list()
                  .stream()
                  .map(e -> BeanUtil.copy(e, MesBuildingCoatingConfigDTO.class))
                  .collect(Collectors.toMap(MesBuildingCoatingConfigDTO::getType, Function.identity()));
               paintingList.forEach(
                  painting -> {
                     if (coatingConfigMap.get(painting.getPaintingType()) != null) {
                        MesBuildingCoatingConfigDTO coatingConfig = coatingConfigMap.get(painting.getPaintingType());
                        teamReportPrice.setPaintingTypeEnum(painting.getPaintingType());
                        teamReportPrice.setWageQuotaType(coatingConfig.getMeasureUnit() == null ? 1 : coatingConfig.getMeasureUnit());
                        teamReportPrice.setPaintingThickness(painting.getThickness());
                        teamReportPrice.setThickness(BigDecimal.valueOf(coatingConfig.getThickness() == null ? 0L : coatingConfig.getThickness().intValue()));
                        teamReportPrice.setUnitPrice(coatingConfig.getUnitPrice());
                        teamReportPrice.setOutThickness(
                           BigDecimal.valueOf(coatingConfig.getOutThickness() == null ? 0L : coatingConfig.getOutThickness().intValue())
                        );
                        teamReportPrice.setOutUnitPrice(coatingConfig.getOutUnitPrice());
                        if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                           teamReportPrice.setWage(teamReportPrice.getUnitPrice());
                           BigDecimal totalNetWeight = artifact.getNetWeight()
                              .multiply(new BigDecimal(teamReport.getQuantity()).divide(BigDecimal.valueOf(1000L)));
                           teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalNetWeight));
                        }

                        if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                           teamReportPrice.setWage(teamReportPrice.getUnitPrice());
                           BigDecimal totalLength = artifact.getLength().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000L));
                           teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalLength));
                        }

                        if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                           teamReportPrice.setWage(teamReportPrice.getUnitPrice());
                           teamReportPrice.setPrice(teamReportPrice.getWage().multiply(new BigDecimal(teamReport.getQuantity())));
                        }

                        if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                           BigDecimal totalArea = artifact.getSurfaceArea()
                              .multiply(new BigDecimal(teamReport.getQuantity()))
                              .divide(BigDecimal.valueOf(1000000L));
                           teamReportPrice.setWage(
                              this.calculatePriceWage(
                                 artifact.getId(), teamReport.getProcessId(), painting.getPaintingType(), coatingConfigMap, painting.getThickness()
                              )
                           );
                           teamReportPrice.setPrice(totalArea.multiply(teamReportPrice.getWage()));
                        }

                        this.teamReportPriceService.save(teamReportPrice);
                     }
                  }
               );
               List<Integer> paintingTypeList = paintingList.stream().map(MesBuildingPainting::getPaintingType).collect(Collectors.toList());
               List<Integer> paintingTypeEnumList = new ArrayList<>();
               paintingTypeEnumList.add(PaintingTypeEnum.PRIMER.getType());
               paintingTypeEnumList.add(PaintingTypeEnum.INTERMEDIATE_PAINT.getType());
               paintingTypeEnumList.add(PaintingTypeEnum.TOPCOAT.getType());
               paintingTypeEnumList.forEach(e -> {
                  if (!paintingTypeList.contains(e)) {
                     teamReportPrice.setPaintingTypeEnum(e);
                     teamReportPrice.setWageQuotaType(WageQuotaTypeEnum.AREA_PRICE.getType());
                     teamReportPrice.setThickness(BigDecimal.ZERO);
                     teamReportPrice.setUnitPrice(BigDecimal.ZERO);
                     teamReportPrice.setOutThickness(BigDecimal.ZERO);
                     teamReportPrice.setOutUnitPrice(BigDecimal.ZERO);
                     teamReportPrice.setWage(BigDecimal.ZERO);
                     teamReportPrice.setPrice(BigDecimal.ZERO);
                     this.teamReportPriceService.save(teamReportPrice);
                  }
               });
            }

            if (process.getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())) {
               teamReportPrice.setWageQuotaType(weldConfigPrice != null ? weldConfigPrice.getWageQuotaType() : WageQuotaTypeEnum.WEIGHT_PRICE.getType());
               teamReportPrice.setWage(
                  this.calculatePriceWage(
                     teamReportPrice.getProductId(),
                     teamReportPrice.getTaskTypeEnum(),
                     teamReportPrice.getProcessId(),
                     weldConfigPrice == null ? BigDecimal.ZERO : weldConfigPrice.getPrice()
                  )
               );
               BigDecimal totalMete = BigDecimal.ZERO;
               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                  totalMete = artifact.getNetWeight().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                  totalMete = artifact.getLength().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                  totalMete = new BigDecimal(teamReportPrice.getQuantity());
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                  totalMete = artifact.getSurfaceArea().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000000L));
               }

               teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalMete));
               this.teamReportPriceService.save(teamReportPrice);
            }
         }

         if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
            TechMachinePart techMachinePart = this.machinePartService.getById(teamReport.getProductId());
            if (process.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType())) {
               List<MesBuildingBoreholeHoleRadiusLinkDTO> holeRadiusLinkList = this.boreholeConfigBiz.getBoreholeConfigPrice(techMachinePart.getId());
               List<TechMachineHoleRadiusLink> radiusLinkList = this.techMachineHoleRadiusLinkService
                  .list(
                     Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                        .eq(TechMachineHoleRadiusLink::getSerialNumber, techMachinePart.getSerialNumber())
                        .eq(TechMachineHoleRadiusLink::getMonomerId, techMachinePart.getMonomerId())
                  );
               radiusLinkList.forEach(
                  e -> holeRadiusLinkList.stream()
                     .filter(item -> item.getMaxBoreDiameter().compareTo(e.getRadius()) >= 0 && item.getMinBoreDiameter().compareTo(e.getRadius()) <= 0)
                     .forEach(
                        item -> {
                           teamReportPrice.setWage(item.getUnitPrice());
                           teamReportPrice.setRadius(e.getRadius());
                           teamReportPrice.setRadiusQuantity(e.getQuantity());
                           teamReportPrice.setWageQuotaType(WageQuotaTypeEnum.QUANTITY_PRICE.getType());
                           teamReportPrice.setPrice(
                              teamReportPrice.getWage()
                                 .multiply(new BigDecimal(teamReportPrice.getQuantity()))
                                 .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                           );
                           this.teamReportPriceService.save(teamReportPrice);
                        }
                     )
               );
            } else {
               MesBuildingLayingOffConfigDTO layingOffConfigDTO = this.layingOffConfigBiz
                  .getLayingOffConfig(
                     teamReportPrice.getProductId(),
                     this.machinePartSchedulingBiz.getById(this.taskBiz.getById(teamReport.getTaskId()).getMachinePartSchedulingId()).getCutConfigId()
                  );
               teamReportPrice.setWage(layingOffConfigDTO != null ? layingOffConfigDTO.getUnitPrice() : BigDecimal.ZERO);
               teamReportPrice.setWageQuotaType(layingOffConfigDTO != null ? layingOffConfigDTO.getWageQuotaType() : WageQuotaTypeEnum.WEIGHT_PRICE.getType());
               BigDecimal totalMete = BigDecimal.ZERO;
               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                  totalMete = techMachinePart.getNetWeight().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                  totalMete = techMachinePart.getLength().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                  totalMete = new BigDecimal(teamReportPrice.getQuantity());
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                  totalMete = techMachinePart.getSurfaceArea().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000000L));
               }

               teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalMete));
               this.teamReportPriceService.save(teamReportPrice);
            }
         }

         if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            TechAssemble assemble = this.assembleService.getById(teamReport.getProductId());
            teamReportPrice.setWageQuotaType(weldConfigPrice != null ? weldConfigPrice.getWageQuotaType() : WageQuotaTypeEnum.WEIGHT_PRICE.getType());
            teamReportPrice.setWage(
               this.calculatePriceWage(
                  teamReportPrice.getProductId(),
                  teamReportPrice.getTaskTypeEnum(),
                  teamReportPrice.getProcessId(),
                  weldConfigPrice != null ? weldConfigPrice.getPrice() : BigDecimal.ZERO
               )
            );
            BigDecimal totalMete = BigDecimal.ZERO;
            if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
               totalMete = assemble.getNetWeight().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
            }

            if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
               totalMete = assemble.getLength().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
            }

            if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
               totalMete = new BigDecimal(teamReportPrice.getQuantity());
            }

            if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
               totalMete = assemble.getSurfaceArea().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000000L));
            }

            teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalMete));
            this.teamReportPriceService.save(teamReportPrice);
         }
      } else {
         priceList.forEach(
            e -> {
               e.setInspectionQuantity(e.getQuantity() + inspectionQuantity);
               if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(teamReport.getProductId());
                  if (process.getType().equals(ProcessTypeEnum.PAINT.getType())) {
                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                        BigDecimal totalNetWeight = artifact.getNetWeight().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                        e.setPrice(e.getUnitPrice().multiply(totalNetWeight).add(e.getOutUnitPrice().multiply(totalNetWeight)));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                        BigDecimal totalLength = artifact.getLength().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                        e.setPrice(e.getUnitPrice().multiply(totalLength).add(e.getOutUnitPrice().multiply(totalLength)));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                        e.setPrice(
                           e.getUnitPrice().multiply(new BigDecimal(e.getQuantity())).add(e.getOutUnitPrice().multiply(new BigDecimal(e.getQuantity())))
                        );
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                        BigDecimal totalArea = artifact.getSurfaceArea().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                        e.setPrice(
                           this.calculatePaintingPrice(
                              totalArea, e.getPaintingThickness(), e.getThickness(), e.getUnitPrice(), e.getOutUnitPrice(), e.getUnitPrice()
                           )
                        );
                     }

                     this.teamReportPriceService.updateById(e);
                  }

                  if (process.getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())) {
                     BigDecimal totalMetexxx = BigDecimal.ZERO;
                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                        totalMetexxx = artifact.getNetWeight().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000L));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                        totalMetexxx = artifact.getLength().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000L));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                        totalMetexxx = new BigDecimal(e.getQuantity());
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                        totalMetexxx = artifact.getSurfaceArea().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                     }

                     e.setPrice(e.getWage().multiply(totalMetexxx));
                     this.teamReportPriceService.updateById(e);
                  }
               }

               if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart techMachinePart = this.machinePartService.getById(teamReport.getProductId());
                  if (process.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType())) {
                     e.setPrice(e.getWage().multiply(new BigDecimal(e.getQuantity())).multiply(BigDecimal.valueOf(e.getRadiusQuantity().intValue())));
                     this.teamReportPriceService.updateById(e);
                  } else {
                     BigDecimal totalMetexx = BigDecimal.ZERO;
                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                        totalMetexx = techMachinePart.getNetWeight().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                        totalMetexx = techMachinePart.getLength().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                        totalMetexx = new BigDecimal(e.getQuantity());
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                        totalMetexx = techMachinePart.getSurfaceArea().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                     }

                     e.setPrice(e.getWage().multiply(totalMetexx));
                     this.teamReportPriceService.updateById(e);
                  }
               }

               if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  TechAssemble assemblex = this.assembleService.getById(teamReport.getProductId());
                  BigDecimal totalMetex = BigDecimal.ZERO;
                  if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                     totalMetex = assemblex.getNetWeight().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                  }

                  if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                     totalMetex = assemblex.getLength().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                  }

                  if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                     totalMetex = new BigDecimal(e.getQuantity());
                  }

                  if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                     totalMetex = assemblex.getSurfaceArea().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                  }

                  e.setPrice(e.getWage().multiply(totalMetex));
                  this.teamReportPriceService.updateById(e);
               }
            }
         );
      }

      return Boolean.TRUE;
   }

   @Override
   public BigDecimal calculatePrice(Long productId, Integer productType, BigDecimal wage, Integer wageQuotaType, Integer quantity) {
      if (wageQuotaType.equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
         return wage.multiply(BigDecimal.valueOf(quantity.intValue()));
      }

      BigDecimal mate;
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getByIdIgnoreDelete(productId);
         if (wageQuotaType.equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
            mate = artifact.getNetWeight().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
         } else if (wageQuotaType.equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
            mate = artifact.getLength().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
         } else {
            mate = artifact.getSurfaceArea().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000000), 5, RoundingMode.HALF_UP);
         }
      } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getByIdIgnoreDelete(productId);
         if (wageQuotaType.equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
            mate = enclosure.getWeight().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
         } else if (wageQuotaType.equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
            if (enclosure.getCategory().equals(EnclosureCategoryEnum.FLANG_PIECE.getCategory())
               && this.configService.getFlangingPiecePrice().getPriceType().equals(false)) {
               if (enclosure.getBendTimes() == null) {
                  enclosure.setBendTimes(1);
               }

               mate = enclosure.getLength()
                  .multiply(new BigDecimal(quantity))
                  .divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP)
                  .multiply(BigDecimal.valueOf(enclosure.getBendTimes().intValue()));
            } else {
               mate = enclosure.getLength().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
            }
         } else {
            mate = enclosure.getLength()
               .multiply(enclosure.getWidth())
               .multiply(new BigDecimal(quantity))
               .divide(new BigDecimal(1000000), 5, RoundingMode.HALF_UP);
         }
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.assembleService.getByIdIgnoreDelete(productId);
         mate = assemble.getLength().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
      } else {
         TechMachinePart machinePart = this.machinePartService.getByIdIgnoreDelete(productId);
         if (wageQuotaType.equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
            mate = machinePart.getNetWeight().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
         } else {
            mate = machinePart.getLength().multiply(new BigDecimal(quantity)).divide(new BigDecimal(1000), 5, RoundingMode.HALF_UP);
         }
      }

      return mate.multiply(wage);
   }

   @Override
   public List<ReportSourceDO> reportSourceList(Long id, Integer prodcutType) {
      return this.teamReportService.reportSourceList(id, prodcutType);
   }

   @Override
   public List<InspectionReportSourceDO> inspectionReportSourceList(Long id, Integer prodcutType) {
      return this.inspectionTeamReportService.inspectionReportSourceList(id, prodcutType);
   }

   private BigDecimal calculatePaintingPrice(
      BigDecimal totalArea, BigDecimal paintingThickness, BigDecimal thickness, BigDecimal unitPrice, BigDecimal outThickness, BigDecimal outUnitPrice
   ) {
      if (paintingThickness == null || unitPrice == null) {
         return BigDecimal.ZERO;
      } else {
         return paintingThickness.compareTo(thickness) <= 0
            ? totalArea.multiply(unitPrice)
            : totalArea.multiply(unitPrice.add(paintingThickness.subtract(thickness).divide(outThickness, 1).multiply(outUnitPrice)));
      }
   }

   private BigDecimal calculatePriceWage(
      Long productId, Long processId, Integer paintingTypeEnum, Map<Integer, MesBuildingCoatingConfigDTO> coatingConfigMap, BigDecimal paintingThickness
   ) {
      MesBuildingPriceChange change = this.priceChangeBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingPriceChange.class)
               .eq(MesBuildingPriceChange::getProductId, productId)
               .eq(MesBuildingPriceChange::getProcessId, processId)
         );
      if (change != null) {
         if (paintingTypeEnum.equals(PaintingTypeEnum.PRIMER.getType())) {
            return change.getPrimerWage();
         }

         if (paintingTypeEnum.equals(PaintingTypeEnum.INTERMEDIATE_PAINT.getType())) {
            return change.getIntermediatePaintWage();
         }

         if (paintingTypeEnum.equals(PaintingTypeEnum.TOPCOAT.getType())) {
            return change.getTopcoatWage();
         }
      }

      MesBuildingCoatingConfigDTO coatingConfig = coatingConfigMap.get(paintingTypeEnum);
      if (paintingThickness == null || coatingConfig.getUnitPrice() == null) {
         return BigDecimal.ZERO;
      } else {
         return paintingThickness.compareTo(BigDecimal.valueOf(coatingConfig.getThickness().intValue())) <= 0
            ? coatingConfig.getUnitPrice()
            : coatingConfig.getUnitPrice()
               .add(
                  paintingThickness.subtract(BigDecimal.valueOf(coatingConfig.getThickness().intValue()))
                     .divide(BigDecimal.valueOf(coatingConfig.getOutThickness().intValue()), 1)
                     .multiply(coatingConfig.getOutUnitPrice())
               );
      }
   }

   private BigDecimal calculatePriceWage(Long productId, Integer taskTypeEnum, Long processId, BigDecimal weldConfigPrice) {
      MesBuildingPriceChange change = this.priceChangeBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingPriceChange.class)
               .eq(MesBuildingPriceChange::getProductId, productId)
               .eq(MesBuildingPriceChange::getProcessId, processId)
               .eq(MesBuildingPriceChange::getProductType, taskTypeEnum)
         );
      if (change != null) {
         return change.getWage();
      } else {
         return weldConfigPrice != null ? weldConfigPrice : BigDecimal.ZERO;
      }
   }

   @Override
   public void savePiceByData(Map<Long, Integer> dataMap) {
      List<MesBuildingProduceTeamReportPrice> allPriceList = this.teamReportPriceService
         .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class).in(MesBuildingProduceTeamReportPrice::getTeamReoprtId, dataMap.keySet()));
      Map<Long, List<MesBuildingProduceTeamReportPrice>> priceMap = allPriceList.stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReportPrice::getTeamReoprtId));
      List<MesBuildingProduceTeamReport> allReports = this.teamReportService.listByIds(dataMap.keySet());
      Map<Long, MesBuildingProduceTeamReport> reportMap = allReports.stream()
         .collect(Collectors.toMap(MesBuildingProduceTeamReport::getId, Function.identity()));
      List<Long> processIds = allReports.stream().map(MesBuildingProduceTeamReport::getProcessId).distinct().collect(Collectors.toList());
      List<MesBuildingProcess> allProcessList = this.processService.listByIds(processIds);
      Map<Long, MesBuildingProcess> processMap = allProcessList.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      List<Integer> taskTypes = allReports.stream().map(MesBuildingProduceTeamReport::getTaskTypeEnum).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(taskTypes.size() == 1, "操作失败!!!");
      List<Long> productIds = allReports.stream().map(MesBuildingProduceTeamReport::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(productIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, TechAssemble> assembleMap = this.assembleService
         .listByIds(productIds)
         .stream()
         .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, TechMachinePart> partMap = this.machinePartService
         .listByIds(productIds)
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      List<Long> allTaskIds = allReports.stream().map(MesBuildingProduceTeamReport::getTaskId).distinct().collect(Collectors.toList());
      List<MesBuildingTask> allTasks = this.taskBiz.listByIds(allTaskIds);
      Map<Long, MesBuildingTask> taskMap = allTasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      List<Long> monIds = allTasks.stream().map(MesBuildingTask::getMonomerId).distinct().collect(Collectors.toList());
      List<MesBuildingPainting> allPaintings = this.paintingService
         .list(Wrappers.lambdaQuery(MesBuildingPainting.class).in(MesBuildingPainting::getMonomerId, monIds));
      Map<Long, List<MesBuildingPainting>> monPaintMap = allPaintings.stream().collect(Collectors.groupingBy(MesBuildingPainting::getMonomerId));
      Map<Integer, MesBuildingCoatingConfigDTO> coatingConfigMap = this.coatingConfigService
         .list()
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingCoatingConfigDTO.class))
         .collect(Collectors.toMap(MesBuildingCoatingConfigDTO::getType, Function.identity()));
      MesBuildingStructureProcessPriceDTO weldConfigPrice = this.configBiz
         .getWeldConfigPrice(allReports.get(0).getProductId(), allReports.get(0).getTaskTypeEnum(), allReports.get(0).getProcessId());
      List<MesBuildingProduceTeamReportPrice> needSaveTeamReportPrice = new ArrayList<>();
      List<MesBuildingProduceTeamReportPrice> needUpdateReportPrice = new ArrayList<>();

      for (Long id : dataMap.keySet()) {
         Integer inspectionQuantity = dataMap.get(id);
         MesBuildingProduceTeamReport teamReport = reportMap.get(id);
         Preconditions.checkArgument(teamReport != null, "操作失败，参数不正确");
         MesBuildingProcess process = processMap.get(teamReport.getProcessId());
         List<MesBuildingProduceTeamReportPrice> priceList = priceMap.get(id);
         if (CollectionUtils.isEmpty(priceList)) {
            MesBuildingTask task = taskMap.get(teamReport.getTaskId());
            MesBuildingProduceTeamReportPrice teamReportPrice = BeanUtil.copy(teamReport, MesBuildingProduceTeamReportPrice.class);
            teamReportPrice.setTeamReoprtId(teamReport.getId());
            teamReportPrice.setCreateTime(LocalDateTime.now());
            teamReportPrice.setTaskOrderId(task.getTaskOrderId());
            teamReportPrice.setQuantity(teamReport.getQuantity());
            teamReportPrice.setInspectionQuantity(inspectionQuantity);
            if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(teamReport.getProductId());
               if (process.getType().equals(ProcessTypeEnum.PAINT.getType())) {
                  List<MesBuildingPainting> paintingList = monPaintMap.get(task.getMonomerId());
                  if (!CollectionUtils.isEmpty(paintingList)) {
                     paintingList.forEach(
                        painting -> {
                           if (coatingConfigMap.get(painting.getPaintingType()) != null) {
                              MesBuildingCoatingConfigDTO coatingConfig = coatingConfigMap.get(painting.getPaintingType());
                              teamReportPrice.setPaintingTypeEnum(painting.getPaintingType());
                              teamReportPrice.setWageQuotaType(coatingConfig.getMeasureUnit() == null ? 1 : coatingConfig.getMeasureUnit());
                              teamReportPrice.setPaintingThickness(painting.getThickness());
                              teamReportPrice.setThickness(
                                 BigDecimal.valueOf(coatingConfig.getThickness() == null ? 0L : coatingConfig.getThickness().intValue())
                              );
                              teamReportPrice.setUnitPrice(coatingConfig.getUnitPrice());
                              teamReportPrice.setOutThickness(
                                 BigDecimal.valueOf(coatingConfig.getOutThickness() == null ? 0L : coatingConfig.getOutThickness().intValue())
                              );
                              teamReportPrice.setOutUnitPrice(coatingConfig.getOutUnitPrice());
                              if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                                 teamReportPrice.setWage(teamReportPrice.getUnitPrice());
                                 BigDecimal totalNetWeight = artifact.getNetWeight()
                                    .multiply(new BigDecimal(teamReport.getQuantity()).divide(BigDecimal.valueOf(1000L)));
                                 teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalNetWeight));
                              }

                              if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                                 teamReportPrice.setWage(teamReportPrice.getUnitPrice());
                                 BigDecimal totalLength = artifact.getLength()
                                    .multiply(new BigDecimal(teamReport.getQuantity()))
                                    .divide(BigDecimal.valueOf(1000L));
                                 teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalLength));
                              }

                              if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                                 teamReportPrice.setWage(teamReportPrice.getUnitPrice());
                                 teamReportPrice.setPrice(teamReportPrice.getWage().multiply(new BigDecimal(teamReport.getQuantity())));
                              }

                              if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                                 BigDecimal totalArea = artifact.getSurfaceArea()
                                    .multiply(new BigDecimal(teamReport.getQuantity()))
                                    .divide(BigDecimal.valueOf(1000000L));
                                 teamReportPrice.setWage(
                                    this.calculatePriceWage(
                                       artifact.getId(), teamReport.getProcessId(), painting.getPaintingType(), coatingConfigMap, painting.getThickness()
                                    )
                                 );
                                 teamReportPrice.setPrice(totalArea.multiply(teamReportPrice.getWage()));
                              }
                           }
                        }
                     );
                     List<Integer> paintingTypeList = paintingList.stream().map(MesBuildingPainting::getPaintingType).collect(Collectors.toList());
                     List<Integer> paintingTypeEnumList = new ArrayList<>();
                     paintingTypeEnumList.add(PaintingTypeEnum.PRIMER.getType());
                     paintingTypeEnumList.add(PaintingTypeEnum.INTERMEDIATE_PAINT.getType());
                     paintingTypeEnumList.add(PaintingTypeEnum.TOPCOAT.getType());
                     paintingTypeEnumList.forEach(e -> {
                        if (!paintingTypeList.contains(e)) {
                           teamReportPrice.setPaintingTypeEnum(e);
                           teamReportPrice.setWageQuotaType(WageQuotaTypeEnum.AREA_PRICE.getType());
                           teamReportPrice.setThickness(BigDecimal.ZERO);
                           teamReportPrice.setUnitPrice(BigDecimal.ZERO);
                           teamReportPrice.setOutThickness(BigDecimal.ZERO);
                           teamReportPrice.setOutUnitPrice(BigDecimal.ZERO);
                           teamReportPrice.setWage(BigDecimal.ZERO);
                           teamReportPrice.setPrice(BigDecimal.ZERO);
                           needSaveTeamReportPrice.add(teamReportPrice);
                        }
                     });
                  }
               }

               if (process.getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())) {
                  teamReportPrice.setWageQuotaType(weldConfigPrice != null ? weldConfigPrice.getWageQuotaType() : WageQuotaTypeEnum.WEIGHT_PRICE.getType());
                  teamReportPrice.setWage(
                     this.calculatePriceWage(
                        teamReportPrice.getProductId(),
                        teamReportPrice.getTaskTypeEnum(),
                        teamReportPrice.getProcessId(),
                        weldConfigPrice == null ? BigDecimal.ZERO : weldConfigPrice.getPrice()
                     )
                  );
                  BigDecimal totalMete = BigDecimal.ZERO;
                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                     totalMete = artifact.getNetWeight().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
                  }

                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                     totalMete = artifact.getLength().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
                  }

                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                     totalMete = new BigDecimal(teamReportPrice.getQuantity());
                  }

                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                     totalMete = artifact.getSurfaceArea().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                  }

                  teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalMete));
                  needSaveTeamReportPrice.add(teamReportPrice);
               }
            }

            if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
               TechMachinePart techMachinePart = partMap.get(teamReport.getProductId());
               if (process.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType())) {
                  List<MesBuildingBoreholeHoleRadiusLinkDTO> holeRadiusLinkList = this.boreholeConfigBiz.getBoreholeConfigPrice(techMachinePart.getId());
                  List<TechMachineHoleRadiusLink> radiusLinkList = this.techMachineHoleRadiusLinkService
                     .list(
                        Wrappers.lambdaQuery(TechMachineHoleRadiusLink.class)
                           .eq(TechMachineHoleRadiusLink::getSerialNumber, techMachinePart.getSerialNumber())
                           .eq(TechMachineHoleRadiusLink::getMonomerId, techMachinePart.getMonomerId())
                     );
                  radiusLinkList.forEach(
                     e -> holeRadiusLinkList.stream()
                        .filter(item -> item.getMaxBoreDiameter().compareTo(e.getRadius()) >= 0 && item.getMinBoreDiameter().compareTo(e.getRadius()) <= 0)
                        .forEach(
                           item -> {
                              teamReportPrice.setWage(item.getUnitPrice());
                              teamReportPrice.setRadius(e.getRadius());
                              teamReportPrice.setRadiusQuantity(e.getQuantity());
                              teamReportPrice.setWageQuotaType(WageQuotaTypeEnum.QUANTITY_PRICE.getType());
                              teamReportPrice.setPrice(
                                 teamReportPrice.getWage()
                                    .multiply(new BigDecimal(teamReportPrice.getQuantity()))
                                    .multiply(BigDecimal.valueOf(e.getQuantity().intValue()))
                              );
                              needSaveTeamReportPrice.add(teamReportPrice);
                           }
                        )
                  );
               } else {
                  MesBuildingLayingOffConfigDTO layingOffConfigDTO = this.layingOffConfigBiz
                     .getLayingOffConfig(
                        teamReportPrice.getProductId(),
                        this.machinePartSchedulingBiz.getById(this.taskBiz.getById(teamReport.getTaskId()).getMachinePartSchedulingId()).getCutConfigId()
                     );
                  teamReportPrice.setWage(layingOffConfigDTO != null ? layingOffConfigDTO.getUnitPrice() : BigDecimal.ZERO);
                  teamReportPrice.setWageQuotaType(
                     layingOffConfigDTO != null ? layingOffConfigDTO.getWageQuotaType() : WageQuotaTypeEnum.WEIGHT_PRICE.getType()
                  );
                  BigDecimal totalMete = BigDecimal.ZERO;
                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                     totalMete = techMachinePart.getNetWeight().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
                  }

                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                     totalMete = techMachinePart.getLength().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
                  }

                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                     totalMete = new BigDecimal(teamReportPrice.getQuantity());
                  }

                  if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                     totalMete = techMachinePart.getSurfaceArea().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                  }

                  teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalMete));
                  needSaveTeamReportPrice.add(teamReportPrice);
               }
            }

            if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
               TechAssemble assemble = assembleMap.get(teamReport.getProductId());
               teamReportPrice.setWageQuotaType(weldConfigPrice != null ? weldConfigPrice.getWageQuotaType() : WageQuotaTypeEnum.WEIGHT_PRICE.getType());
               teamReportPrice.setWage(
                  this.calculatePriceWage(
                     teamReportPrice.getProductId(),
                     teamReportPrice.getTaskTypeEnum(),
                     teamReportPrice.getProcessId(),
                     weldConfigPrice != null ? weldConfigPrice.getPrice() : BigDecimal.ZERO
                  )
               );
               BigDecimal totalMete = BigDecimal.ZERO;
               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                  totalMete = assemble.getNetWeight().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                  totalMete = assemble.getLength().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000L));
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                  totalMete = new BigDecimal(teamReportPrice.getQuantity());
               }

               if (teamReportPrice.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                  totalMete = assemble.getSurfaceArea().multiply(new BigDecimal(teamReportPrice.getQuantity())).divide(BigDecimal.valueOf(1000000L));
               }

               teamReportPrice.setPrice(teamReportPrice.getWage().multiply(totalMete));
               needSaveTeamReportPrice.add(teamReportPrice);
            }
         } else {
            priceList.forEach(
               e -> {
                  e.setInspectionQuantity(e.getQuantity() + inspectionQuantity);
                  if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = artifactMap.get(teamReport.getProductId());
                     if (process.getType().equals(ProcessTypeEnum.PAINT.getType())) {
                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                           BigDecimal totalNetWeight = artifact.getNetWeight().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                           e.setPrice(e.getUnitPrice().multiply(totalNetWeight).add(e.getOutUnitPrice().multiply(totalNetWeight)));
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                           BigDecimal totalLength = artifact.getLength().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                           e.setPrice(e.getUnitPrice().multiply(totalLength).add(e.getOutUnitPrice().multiply(totalLength)));
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                           e.setPrice(
                              e.getUnitPrice().multiply(new BigDecimal(e.getQuantity())).add(e.getOutUnitPrice().multiply(new BigDecimal(e.getQuantity())))
                           );
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                           BigDecimal totalArea = artifact.getSurfaceArea().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                           e.setPrice(
                              this.calculatePaintingPrice(
                                 totalArea, e.getPaintingThickness(), e.getThickness(), e.getUnitPrice(), e.getOutUnitPrice(), e.getUnitPrice()
                              )
                           );
                        }

                        needUpdateReportPrice.add(e);
                     }

                     if (process.getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())) {
                        BigDecimal totalMetexxx = BigDecimal.ZERO;
                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                           totalMetexxx = artifact.getNetWeight().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000L));
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                           totalMetexxx = artifact.getLength().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000L));
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                           totalMetexxx = new BigDecimal(e.getQuantity());
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                           totalMetexxx = artifact.getSurfaceArea().multiply(new BigDecimal(teamReport.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                        }

                        e.setPrice(e.getWage().multiply(totalMetexxx));
                        needUpdateReportPrice.add(e);
                     }
                  }

                  if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart techMachinePart = partMap.get(teamReport.getProductId());
                     if (process.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType())) {
                        e.setPrice(e.getWage().multiply(new BigDecimal(e.getQuantity())).multiply(BigDecimal.valueOf(e.getRadiusQuantity().intValue())));
                        needUpdateReportPrice.add(e);
                     } else {
                        BigDecimal totalMetexx = BigDecimal.ZERO;
                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                           totalMetexx = techMachinePart.getNetWeight().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                           totalMetexx = techMachinePart.getLength().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                           totalMetexx = new BigDecimal(e.getQuantity());
                        }

                        if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                           totalMetexx = techMachinePart.getSurfaceArea().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                        }

                        e.setPrice(e.getWage().multiply(totalMetexx));
                        needUpdateReportPrice.add(e);
                     }
                  }

                  if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemblex = assembleMap.get(teamReport.getProductId());
                     BigDecimal totalMetex = BigDecimal.ZERO;
                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
                        totalMetex = assemblex.getNetWeight().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
                        totalMetex = assemblex.getLength().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000L));
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
                        totalMetex = new BigDecimal(e.getQuantity());
                     }

                     if (e.getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
                        totalMetex = assemblex.getSurfaceArea().multiply(new BigDecimal(e.getQuantity())).divide(BigDecimal.valueOf(1000000L));
                     }

                     e.setPrice(e.getWage().multiply(totalMetex));
                     needUpdateReportPrice.add(e);
                  }
               }
            );
         }
      }

      this.teamReportPriceService.saveBatch(needSaveTeamReportPrice);
      this.teamReportPriceService.updateBatchById(needUpdateReportPrice);
   }
}
