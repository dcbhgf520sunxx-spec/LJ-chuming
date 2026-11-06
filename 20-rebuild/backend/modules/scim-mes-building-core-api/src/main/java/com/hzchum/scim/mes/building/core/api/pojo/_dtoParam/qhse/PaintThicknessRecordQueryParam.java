package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "PaintThicknessRecordQueryParam", description = "厚度质检记录")
public class PaintThicknessRecordQueryParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "boolAdoptEnum", value = "是否质检通过")
   private Boolean boolAdoptEnum;
   @ApiModelProperty(name = "boolPaintThicknessAdoptEnum", value = "是否通过漆膜厚度检测 [0 未通过, 1 已通过]", notes = "是否通过漆膜厚度检测 [0 未通过, 1 已通过]")
   private Boolean boolPaintThicknessAdoptEnum;
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "截止日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   private String serialNumber;
   @ApiModelProperty("工序上报人名称")
   private String reporterName;
   @ApiModelProperty("质检人名称")
   private String inspectionName;
   @ApiModelProperty("1：平均厚度 0：实际厚度")
   private Boolean isAvgThickness;
   @ApiModelProperty(name = "minThickness", value = "本次漆膜检测最小限制厚度", notes = "本次漆膜检测最小限制厚度")
   private BigDecimal minThickness;
   @ApiModelProperty(name = "maxThickness", value = "本次漆膜检测最大限制厚度", notes = "本次漆膜检测最大限制厚度")
   private BigDecimal maxThickness;

   public static PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder builder() {
      return new PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder();
   }

   public PaintThicknessRecordQueryParam() {
   }

   public PaintThicknessRecordQueryParam(
      final Long projectId,
      final Boolean boolAdoptEnum,
      final Boolean boolPaintThicknessAdoptEnum,
      final LocalDate startDate,
      final LocalDate endDate,
      final String serialNumber,
      final String reporterName,
      final String inspectionName,
      final Boolean isAvgThickness,
      final BigDecimal minThickness,
      final BigDecimal maxThickness
   ) {
      this.projectId = projectId;
      this.boolAdoptEnum = boolAdoptEnum;
      this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
      this.startDate = startDate;
      this.endDate = endDate;
      this.serialNumber = serialNumber;
      this.reporterName = reporterName;
      this.inspectionName = inspectionName;
      this.isAvgThickness = isAvgThickness;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Boolean getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   public Boolean getBoolPaintThicknessAdoptEnum() {
      return this.boolPaintThicknessAdoptEnum;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getReporterName() {
      return this.reporterName;
   }

   public String getInspectionName() {
      return this.inspectionName;
   }

   public Boolean getIsAvgThickness() {
      return this.isAvgThickness;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   public PaintThicknessRecordQueryParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public PaintThicknessRecordQueryParam setBoolAdoptEnum(final Boolean boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
      return this;
   }

   public PaintThicknessRecordQueryParam setBoolPaintThicknessAdoptEnum(final Boolean boolPaintThicknessAdoptEnum) {
      this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
      return this;
   }

   public PaintThicknessRecordQueryParam setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
      return this;
   }

   public PaintThicknessRecordQueryParam setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
      return this;
   }

   public PaintThicknessRecordQueryParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public PaintThicknessRecordQueryParam setReporterName(final String reporterName) {
      this.reporterName = reporterName;
      return this;
   }

   public PaintThicknessRecordQueryParam setInspectionName(final String inspectionName) {
      this.inspectionName = inspectionName;
      return this;
   }

   public PaintThicknessRecordQueryParam setIsAvgThickness(final Boolean isAvgThickness) {
      this.isAvgThickness = isAvgThickness;
      return this;
   }

   public PaintThicknessRecordQueryParam setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   public PaintThicknessRecordQueryParam setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintThicknessRecordQueryParam)) {
         return false;
      }

      PaintThicknessRecordQueryParam other = (PaintThicknessRecordQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$boolAdoptEnum = this.getBoolAdoptEnum();
         Object other$boolAdoptEnum = other.getBoolAdoptEnum();
         if (this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum)) {
            Object this$boolPaintThicknessAdoptEnum = this.getBoolPaintThicknessAdoptEnum();
            Object other$boolPaintThicknessAdoptEnum = other.getBoolPaintThicknessAdoptEnum();
            if (this$boolPaintThicknessAdoptEnum == null
               ? other$boolPaintThicknessAdoptEnum == null
               : this$boolPaintThicknessAdoptEnum.equals(other$boolPaintThicknessAdoptEnum)) {
               Object this$isAvgThickness = this.getIsAvgThickness();
               Object other$isAvgThickness = other.getIsAvgThickness();
               if (this$isAvgThickness == null ? other$isAvgThickness == null : this$isAvgThickness.equals(other$isAvgThickness)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$reporterName = this.getReporterName();
                           Object other$reporterName = other.getReporterName();
                           if (this$reporterName == null ? other$reporterName == null : this$reporterName.equals(other$reporterName)) {
                              Object this$inspectionName = this.getInspectionName();
                              Object other$inspectionName = other.getInspectionName();
                              if (this$inspectionName == null ? other$inspectionName == null : this$inspectionName.equals(other$inspectionName)) {
                                 Object this$minThickness = this.getMinThickness();
                                 Object other$minThickness = other.getMinThickness();
                                 if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
                                    Object this$maxThickness = this.getMaxThickness();
                                    Object other$maxThickness = other.getMaxThickness();
                                    return this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness);
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
      return other instanceof PaintThicknessRecordQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      result = result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
      Object $boolPaintThicknessAdoptEnum = this.getBoolPaintThicknessAdoptEnum();
      result = result * 59 + ($boolPaintThicknessAdoptEnum == null ? 43 : $boolPaintThicknessAdoptEnum.hashCode());
      Object $isAvgThickness = this.getIsAvgThickness();
      result = result * 59 + ($isAvgThickness == null ? 43 : $isAvgThickness.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reporterName = this.getReporterName();
      result = result * 59 + ($reporterName == null ? 43 : $reporterName.hashCode());
      Object $inspectionName = this.getInspectionName();
      result = result * 59 + ($inspectionName == null ? 43 : $inspectionName.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      return result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
   }

   @Override
   public String toString() {
      return "PaintThicknessRecordQueryParam(projectId="
         + this.getProjectId()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ", boolPaintThicknessAdoptEnum="
         + this.getBoolPaintThicknessAdoptEnum()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reporterName="
         + this.getReporterName()
         + ", inspectionName="
         + this.getInspectionName()
         + ", isAvgThickness="
         + this.getIsAvgThickness()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ")";
   }

   public static class PaintThicknessRecordQueryParamBuilder {
      private Long projectId;
      private Boolean boolAdoptEnum;
      private Boolean boolPaintThicknessAdoptEnum;
      private LocalDate startDate;
      private LocalDate endDate;
      private String serialNumber;
      private String reporterName;
      private String inspectionName;
      private Boolean isAvgThickness;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;

      PaintThicknessRecordQueryParamBuilder() {
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder boolAdoptEnum(final Boolean boolAdoptEnum) {
         this.boolAdoptEnum = boolAdoptEnum;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder boolPaintThicknessAdoptEnum(final Boolean boolPaintThicknessAdoptEnum) {
         this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder reporterName(final String reporterName) {
         this.reporterName = reporterName;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder inspectionName(final String inspectionName) {
         this.inspectionName = inspectionName;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder isAvgThickness(final Boolean isAvgThickness) {
         this.isAvgThickness = isAvgThickness;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      public PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      public PaintThicknessRecordQueryParam build() {
         return new PaintThicknessRecordQueryParam(
            this.projectId,
            this.boolAdoptEnum,
            this.boolPaintThicknessAdoptEnum,
            this.startDate,
            this.endDate,
            this.serialNumber,
            this.reporterName,
            this.inspectionName,
            this.isAvgThickness,
            this.minThickness,
            this.maxThickness
         );
      }

      @Override
      public String toString() {
         return "PaintThicknessRecordQueryParam.PaintThicknessRecordQueryParamBuilder(projectId="
            + this.projectId
            + ", boolAdoptEnum="
            + this.boolAdoptEnum
            + ", boolPaintThicknessAdoptEnum="
            + this.boolPaintThicknessAdoptEnum
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", serialNumber="
            + this.serialNumber
            + ", reporterName="
            + this.reporterName
            + ", inspectionName="
            + this.inspectionName
            + ", isAvgThickness="
            + this.isAvgThickness
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ")";
      }
   }
}
