package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "PaintThicknessRecordDTO", description = "油漆厚度检测DTO")
public class PaintThicknessRecordDTO {
   @ApiModelProperty(name = "id", notes = "质检记录id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "number", value = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "avgThickness", value = "本次漆膜检测记录平均值", notes = "本次漆膜检测记录平均值")
   private BigDecimal avgThickness;
   @ApiModelProperty(name = "boolAdoptEnum", value = "是否通过质检 [0 未通过, 1 已通过]")
   private Boolean boolAdoptEnum;
   @ApiModelProperty(name = "boolPaintThicknessAdoptEnum", value = "是否通过质检 [0 未通过, 1 已通过]")
   private Boolean boolPaintThicknessAdoptEnum;
   @ApiModelProperty("工序上报人名称")
   private String reporterName;
   @ApiModelProperty("质检人名称")
   private String inspectionName;
   @ApiModelProperty("生产上报日期")
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime reportTime;
   @ApiModelProperty("质检上报日期")
   private LocalDateTime reportTime2;
   @ApiModelProperty(name = "productionLine", value = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   @JsonInclude(Include.NON_NULL)
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "teamUserName", value = "班组长", notes = "班组长")
   @JsonInclude(Include.NON_NULL)
   private String teamUserName;
   @ApiModelProperty(name = "minThickness", value = "本次漆膜检测最小限制厚度", notes = "本次漆膜检测最小限制厚度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal minThickness;
   @ApiModelProperty(name = "maxThickness", value = "本次漆膜检测最大限制厚度", notes = "本次漆膜检测最大限制厚度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal maxThickness;
   @ApiModelProperty(name = "qhseId", value = "问题id", notes = "问题id")
   @JsonInclude(Include.NON_NULL)
   private Long qhseId;
   @ApiModelProperty(name = "paintThicknessDTOList", notes = "漆膜检测记录")
   @JsonInclude(Include.NON_NULL)
   private List<PaintThicknessDTO> paintThicknessDTOList;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonInclude(Include.NON_NULL)
   private IdAndNameDTO process;
   @ApiModelProperty(name = "qhseDTO", notes = "问题")
   @JsonInclude(Include.NON_NULL)
   private MesBuildingQhseDTO qhseDTO;

   public static PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder builder() {
      return new PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder();
   }

   public PaintThicknessRecordDTO() {
   }

   public PaintThicknessRecordDTO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final String serialNumber,
      final Integer number,
      final BigDecimal avgThickness,
      final Boolean boolAdoptEnum,
      final Boolean boolPaintThicknessAdoptEnum,
      final String reporterName,
      final String inspectionName,
      final LocalDateTime reportTime,
      final LocalDateTime reportTime2,
      final ProductionLineDetailDO productionLine,
      final String teamUserName,
      final BigDecimal minThickness,
      final BigDecimal maxThickness,
      final Long qhseId,
      final List<PaintThicknessDTO> paintThicknessDTOList,
      final IdAndNameDTO process,
      final MesBuildingQhseDTO qhseDTO
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.serialNumber = serialNumber;
      this.number = number;
      this.avgThickness = avgThickness;
      this.boolAdoptEnum = boolAdoptEnum;
      this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
      this.reporterName = reporterName;
      this.inspectionName = inspectionName;
      this.reportTime = reportTime;
      this.reportTime2 = reportTime2;
      this.productionLine = productionLine;
      this.teamUserName = teamUserName;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
      this.qhseId = qhseId;
      this.paintThicknessDTOList = paintThicknessDTOList;
      this.process = process;
      this.qhseDTO = qhseDTO;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getNumber() {
      return this.number;
   }

   public BigDecimal getAvgThickness() {
      return this.avgThickness;
   }

   public Boolean getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   public Boolean getBoolPaintThicknessAdoptEnum() {
      return this.boolPaintThicknessAdoptEnum;
   }

   public String getReporterName() {
      return this.reporterName;
   }

   public String getInspectionName() {
      return this.inspectionName;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public LocalDateTime getReportTime2() {
      return this.reportTime2;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public List<PaintThicknessDTO> getPaintThicknessDTOList() {
      return this.paintThicknessDTOList;
   }

   public IdAndNameDTO getProcess() {
      return this.process;
   }

   public MesBuildingQhseDTO getQhseDTO() {
      return this.qhseDTO;
   }

   public PaintThicknessRecordDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public PaintThicknessRecordDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public PaintThicknessRecordDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public PaintThicknessRecordDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("serialNumber")
   public PaintThicknessRecordDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("number")
   public PaintThicknessRecordDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public PaintThicknessRecordDTO setAvgThickness(final BigDecimal avgThickness) {
      this.avgThickness = avgThickness;
      return this;
   }

   public PaintThicknessRecordDTO setBoolAdoptEnum(final Boolean boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
      return this;
   }

   public PaintThicknessRecordDTO setBoolPaintThicknessAdoptEnum(final Boolean boolPaintThicknessAdoptEnum) {
      this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
      return this;
   }

   public PaintThicknessRecordDTO setReporterName(final String reporterName) {
      this.reporterName = reporterName;
      return this;
   }

   public PaintThicknessRecordDTO setInspectionName(final String inspectionName) {
      this.inspectionName = inspectionName;
      return this;
   }

   public PaintThicknessRecordDTO setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   public PaintThicknessRecordDTO setReportTime2(final LocalDateTime reportTime2) {
      this.reportTime2 = reportTime2;
      return this;
   }

   @JsonProperty("productionLine")
   public PaintThicknessRecordDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   public PaintThicknessRecordDTO setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
      return this;
   }

   public PaintThicknessRecordDTO setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   public PaintThicknessRecordDTO setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   public PaintThicknessRecordDTO setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   public PaintThicknessRecordDTO setPaintThicknessDTOList(final List<PaintThicknessDTO> paintThicknessDTOList) {
      this.paintThicknessDTOList = paintThicknessDTOList;
      return this;
   }

   public PaintThicknessRecordDTO setProcess(final IdAndNameDTO process) {
      this.process = process;
      return this;
   }

   public PaintThicknessRecordDTO setQhseDTO(final MesBuildingQhseDTO qhseDTO) {
      this.qhseDTO = qhseDTO;
      return this;
   }

   @Override
   public String toString() {
      return "PaintThicknessRecordDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", number="
         + this.getNumber()
         + ", avgThickness="
         + this.getAvgThickness()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ", boolPaintThicknessAdoptEnum="
         + this.getBoolPaintThicknessAdoptEnum()
         + ", reporterName="
         + this.getReporterName()
         + ", inspectionName="
         + this.getInspectionName()
         + ", reportTime="
         + this.getReportTime()
         + ", reportTime2="
         + this.getReportTime2()
         + ", productionLine="
         + this.getProductionLine()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", qhseId="
         + this.getQhseId()
         + ", paintThicknessDTOList="
         + this.getPaintThicknessDTOList()
         + ", process="
         + this.getProcess()
         + ", qhseDTO="
         + this.getQhseDTO()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintThicknessRecordDTO)) {
         return false;
      }

      PaintThicknessRecordDTO other = (PaintThicknessRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$boolAdoptEnum = this.getBoolAdoptEnum();
            Object other$boolAdoptEnum = other.getBoolAdoptEnum();
            if (this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum)) {
               Object this$boolPaintThicknessAdoptEnum = this.getBoolPaintThicknessAdoptEnum();
               Object other$boolPaintThicknessAdoptEnum = other.getBoolPaintThicknessAdoptEnum();
               if (this$boolPaintThicknessAdoptEnum == null
                  ? other$boolPaintThicknessAdoptEnum == null
                  : this$boolPaintThicknessAdoptEnum.equals(other$boolPaintThicknessAdoptEnum)) {
                  Object this$qhseId = this.getQhseId();
                  Object other$qhseId = other.getQhseId();
                  if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$avgThickness = this.getAvgThickness();
                                 Object other$avgThickness = other.getAvgThickness();
                                 if (this$avgThickness == null ? other$avgThickness == null : this$avgThickness.equals(other$avgThickness)) {
                                    Object this$reporterName = this.getReporterName();
                                    Object other$reporterName = other.getReporterName();
                                    if (this$reporterName == null ? other$reporterName == null : this$reporterName.equals(other$reporterName)) {
                                       Object this$inspectionName = this.getInspectionName();
                                       Object other$inspectionName = other.getInspectionName();
                                       if (this$inspectionName == null ? other$inspectionName == null : this$inspectionName.equals(other$inspectionName)) {
                                          Object this$reportTime = this.getReportTime();
                                          Object other$reportTime = other.getReportTime();
                                          if (this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime)) {
                                             Object this$reportTime2 = this.getReportTime2();
                                             Object other$reportTime2 = other.getReportTime2();
                                             if (this$reportTime2 == null ? other$reportTime2 == null : this$reportTime2.equals(other$reportTime2)) {
                                                Object this$productionLine = this.getProductionLine();
                                                Object other$productionLine = other.getProductionLine();
                                                if (this$productionLine == null
                                                   ? other$productionLine == null
                                                   : this$productionLine.equals(other$productionLine)) {
                                                   Object this$teamUserName = this.getTeamUserName();
                                                   Object other$teamUserName = other.getTeamUserName();
                                                   if (this$teamUserName == null ? other$teamUserName == null : this$teamUserName.equals(other$teamUserName)) {
                                                      Object this$minThickness = this.getMinThickness();
                                                      Object other$minThickness = other.getMinThickness();
                                                      if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)
                                                         )
                                                       {
                                                         Object this$maxThickness = this.getMaxThickness();
                                                         Object other$maxThickness = other.getMaxThickness();
                                                         if (this$maxThickness == null
                                                            ? other$maxThickness == null
                                                            : this$maxThickness.equals(other$maxThickness)) {
                                                            Object this$paintThicknessDTOList = this.getPaintThicknessDTOList();
                                                            Object other$paintThicknessDTOList = other.getPaintThicknessDTOList();
                                                            if (this$paintThicknessDTOList == null
                                                               ? other$paintThicknessDTOList == null
                                                               : this$paintThicknessDTOList.equals(other$paintThicknessDTOList)) {
                                                               Object this$process = this.getProcess();
                                                               Object other$process = other.getProcess();
                                                               if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                                  Object this$qhseDTO = this.getQhseDTO();
                                                                  Object other$qhseDTO = other.getQhseDTO();
                                                                  return this$qhseDTO == null ? other$qhseDTO == null : this$qhseDTO.equals(other$qhseDTO);
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaintThicknessRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      result = result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
      Object $boolPaintThicknessAdoptEnum = this.getBoolPaintThicknessAdoptEnum();
      result = result * 59 + ($boolPaintThicknessAdoptEnum == null ? 43 : $boolPaintThicknessAdoptEnum.hashCode());
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $avgThickness = this.getAvgThickness();
      result = result * 59 + ($avgThickness == null ? 43 : $avgThickness.hashCode());
      Object $reporterName = this.getReporterName();
      result = result * 59 + ($reporterName == null ? 43 : $reporterName.hashCode());
      Object $inspectionName = this.getInspectionName();
      result = result * 59 + ($inspectionName == null ? 43 : $inspectionName.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $reportTime2 = this.getReportTime2();
      result = result * 59 + ($reportTime2 == null ? 43 : $reportTime2.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      result = result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
      Object $paintThicknessDTOList = this.getPaintThicknessDTOList();
      result = result * 59 + ($paintThicknessDTOList == null ? 43 : $paintThicknessDTOList.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $qhseDTO = this.getQhseDTO();
      return result * 59 + ($qhseDTO == null ? 43 : $qhseDTO.hashCode());
   }

   public static class PaintThicknessRecordDTOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private String serialNumber;
      private Integer number;
      private BigDecimal avgThickness;
      private Boolean boolAdoptEnum;
      private Boolean boolPaintThicknessAdoptEnum;
      private String reporterName;
      private String inspectionName;
      private LocalDateTime reportTime;
      private LocalDateTime reportTime2;
      private ProductionLineDetailDO productionLine;
      private String teamUserName;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;
      private Long qhseId;
      private List<PaintThicknessDTO> paintThicknessDTOList;
      private IdAndNameDTO process;
      private MesBuildingQhseDTO qhseDTO;

      PaintThicknessRecordDTOBuilder() {
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("serialNumber")
      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("number")
      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder avgThickness(final BigDecimal avgThickness) {
         this.avgThickness = avgThickness;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder boolAdoptEnum(final Boolean boolAdoptEnum) {
         this.boolAdoptEnum = boolAdoptEnum;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder boolPaintThicknessAdoptEnum(final Boolean boolPaintThicknessAdoptEnum) {
         this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder reporterName(final String reporterName) {
         this.reporterName = reporterName;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder inspectionName(final String inspectionName) {
         this.inspectionName = inspectionName;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder reportTime2(final LocalDateTime reportTime2) {
         this.reportTime2 = reportTime2;
         return this;
      }

      @JsonProperty("productionLine")
      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder paintThicknessDTOList(final List<PaintThicknessDTO> paintThicknessDTOList) {
         this.paintThicknessDTOList = paintThicknessDTOList;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder process(final IdAndNameDTO process) {
         this.process = process;
         return this;
      }

      public PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder qhseDTO(final MesBuildingQhseDTO qhseDTO) {
         this.qhseDTO = qhseDTO;
         return this;
      }

      public PaintThicknessRecordDTO build() {
         return new PaintThicknessRecordDTO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.serialNumber,
            this.number,
            this.avgThickness,
            this.boolAdoptEnum,
            this.boolPaintThicknessAdoptEnum,
            this.reporterName,
            this.inspectionName,
            this.reportTime,
            this.reportTime2,
            this.productionLine,
            this.teamUserName,
            this.minThickness,
            this.maxThickness,
            this.qhseId,
            this.paintThicknessDTOList,
            this.process,
            this.qhseDTO
         );
      }

      @Override
      public String toString() {
         return "PaintThicknessRecordDTO.PaintThicknessRecordDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", serialNumber="
            + this.serialNumber
            + ", number="
            + this.number
            + ", avgThickness="
            + this.avgThickness
            + ", boolAdoptEnum="
            + this.boolAdoptEnum
            + ", boolPaintThicknessAdoptEnum="
            + this.boolPaintThicknessAdoptEnum
            + ", reporterName="
            + this.reporterName
            + ", inspectionName="
            + this.inspectionName
            + ", reportTime="
            + this.reportTime
            + ", reportTime2="
            + this.reportTime2
            + ", productionLine="
            + this.productionLine
            + ", teamUserName="
            + this.teamUserName
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", qhseId="
            + this.qhseId
            + ", paintThicknessDTOList="
            + this.paintThicknessDTOList
            + ", process="
            + this.process
            + ", qhseDTO="
            + this.qhseDTO
            + ")";
      }
   }
}
