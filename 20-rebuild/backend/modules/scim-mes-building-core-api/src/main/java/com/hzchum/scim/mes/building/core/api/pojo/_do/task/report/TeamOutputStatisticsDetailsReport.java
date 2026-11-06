package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamOutputStatisticsDetailsReportDO", description = "班组产量统计详情报表")
public class TeamOutputStatisticsDetailsReport {
   @ApiModelProperty("序号")
   private Integer typeNumber;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("批次名称")
   private String batchName;
   @ApiModelProperty("构件类型")
   private String structureType;
   @ApiModelProperty("构件种类ID")
   private Long structureClassId;
   @ApiModelProperty("构件种类")
   private String classificationName;
   @ApiModelProperty("构件名称")
   private String artifactName;
   @ApiModelProperty("构件编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度")
   private BigDecimal length;
   @ApiModelProperty("单毛重")
   private BigDecimal grossWeight;
   @ApiModelProperty("任务数量")
   private Integer taskQuantity;
   @ApiModelProperty("总任务总毛重")
   private BigDecimal totalTaskGrossWeight;
   @ApiModelProperty("完成数量")
   private Integer completeQuantity;
   @ApiModelProperty("总完成总毛重")
   private BigDecimal totalCompleteGrossWeight;
   @ApiModelProperty("上报人名称")
   private String reportUserName;

   public static TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder builder() {
      return new TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder();
   }

   public TeamOutputStatisticsDetailsReport() {
   }

   public TeamOutputStatisticsDetailsReport(
      final Integer typeNumber,
      final String projectName,
      final String batchName,
      final String structureType,
      final Long structureClassId,
      final String classificationName,
      final String artifactName,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final BigDecimal grossWeight,
      final Integer taskQuantity,
      final BigDecimal totalTaskGrossWeight,
      final Integer completeQuantity,
      final BigDecimal totalCompleteGrossWeight,
      final String reportUserName
   ) {
      this.typeNumber = typeNumber;
      this.projectName = projectName;
      this.batchName = batchName;
      this.structureType = structureType;
      this.structureClassId = structureClassId;
      this.classificationName = classificationName;
      this.artifactName = artifactName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.grossWeight = grossWeight;
      this.taskQuantity = taskQuantity;
      this.totalTaskGrossWeight = totalTaskGrossWeight;
      this.completeQuantity = completeQuantity;
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      this.reportUserName = reportUserName;
   }

   public Integer getTypeNumber() {
      return this.typeNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getBatchName() {
      return this.batchName;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTotalTaskGrossWeight() {
      return this.totalTaskGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTotalCompleteGrossWeight() {
      return this.totalCompleteGrossWeight;
   }

   public String getReportUserName() {
      return this.reportUserName;
   }

   public TeamOutputStatisticsDetailsReport setTypeNumber(final Integer typeNumber) {
      this.typeNumber = typeNumber;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setBatchName(final String batchName) {
      this.batchName = batchName;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setTotalTaskGrossWeight(final BigDecimal totalTaskGrossWeight) {
      this.totalTaskGrossWeight = totalTaskGrossWeight;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setTotalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      return this;
   }

   public TeamOutputStatisticsDetailsReport setReportUserName(final String reportUserName) {
      this.reportUserName = reportUserName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamOutputStatisticsDetailsReport)) {
         return false;
      }

      TeamOutputStatisticsDetailsReport other = (TeamOutputStatisticsDetailsReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeNumber = this.getTypeNumber();
      Object other$typeNumber = other.getTypeNumber();
      if (this$typeNumber == null ? other$typeNumber == null : this$typeNumber.equals(other$typeNumber)) {
         Object this$structureClassId = this.getStructureClassId();
         Object other$structureClassId = other.getStructureClassId();
         if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$batchName = this.getBatchName();
                     Object other$batchName = other.getBatchName();
                     if (this$batchName == null ? other$batchName == null : this$batchName.equals(other$batchName)) {
                        Object this$structureType = this.getStructureType();
                        Object other$structureType = other.getStructureType();
                        if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                           Object this$classificationName = this.getClassificationName();
                           Object other$classificationName = other.getClassificationName();
                           if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
                              Object this$artifactName = this.getArtifactName();
                              Object other$artifactName = other.getArtifactName();
                              if (this$artifactName == null ? other$artifactName == null : this$artifactName.equals(other$artifactName)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$grossWeight = this.getGrossWeight();
                                          Object other$grossWeight = other.getGrossWeight();
                                          if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                             Object this$totalTaskGrossWeight = this.getTotalTaskGrossWeight();
                                             Object other$totalTaskGrossWeight = other.getTotalTaskGrossWeight();
                                             if (this$totalTaskGrossWeight == null
                                                ? other$totalTaskGrossWeight == null
                                                : this$totalTaskGrossWeight.equals(other$totalTaskGrossWeight)) {
                                                Object this$totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
                                                Object other$totalCompleteGrossWeight = other.getTotalCompleteGrossWeight();
                                                if (this$totalCompleteGrossWeight == null
                                                   ? other$totalCompleteGrossWeight == null
                                                   : this$totalCompleteGrossWeight.equals(other$totalCompleteGrossWeight)) {
                                                   Object this$reportUserName = this.getReportUserName();
                                                   Object other$reportUserName = other.getReportUserName();
                                                   return this$reportUserName == null
                                                      ? other$reportUserName == null
                                                      : this$reportUserName.equals(other$reportUserName);
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
      return other instanceof TeamOutputStatisticsDetailsReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeNumber = this.getTypeNumber();
      result = result * 59 + ($typeNumber == null ? 43 : $typeNumber.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $batchName = this.getBatchName();
      result = result * 59 + ($batchName == null ? 43 : $batchName.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $artifactName = this.getArtifactName();
      result = result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalTaskGrossWeight = this.getTotalTaskGrossWeight();
      result = result * 59 + ($totalTaskGrossWeight == null ? 43 : $totalTaskGrossWeight.hashCode());
      Object $totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
      result = result * 59 + ($totalCompleteGrossWeight == null ? 43 : $totalCompleteGrossWeight.hashCode());
      Object $reportUserName = this.getReportUserName();
      return result * 59 + ($reportUserName == null ? 43 : $reportUserName.hashCode());
   }

   @Override
   public String toString() {
      return "TeamOutputStatisticsDetailsReport(typeNumber="
         + this.getTypeNumber()
         + ", projectName="
         + this.getProjectName()
         + ", batchName="
         + this.getBatchName()
         + ", structureType="
         + this.getStructureType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", classificationName="
         + this.getClassificationName()
         + ", artifactName="
         + this.getArtifactName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", totalTaskGrossWeight="
         + this.getTotalTaskGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", totalCompleteGrossWeight="
         + this.getTotalCompleteGrossWeight()
         + ", reportUserName="
         + this.getReportUserName()
         + ")";
   }

   public static class TeamOutputStatisticsDetailsReportBuilder {
      private Integer typeNumber;
      private String projectName;
      private String batchName;
      private String structureType;
      private Long structureClassId;
      private String classificationName;
      private String artifactName;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private BigDecimal grossWeight;
      private Integer taskQuantity;
      private BigDecimal totalTaskGrossWeight;
      private Integer completeQuantity;
      private BigDecimal totalCompleteGrossWeight;
      private String reportUserName;

      TeamOutputStatisticsDetailsReportBuilder() {
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder typeNumber(final Integer typeNumber) {
         this.typeNumber = typeNumber;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder batchName(final String batchName) {
         this.batchName = batchName;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder artifactName(final String artifactName) {
         this.artifactName = artifactName;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder totalTaskGrossWeight(final BigDecimal totalTaskGrossWeight) {
         this.totalTaskGrossWeight = totalTaskGrossWeight;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder totalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
         this.totalCompleteGrossWeight = totalCompleteGrossWeight;
         return this;
      }

      public TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder reportUserName(final String reportUserName) {
         this.reportUserName = reportUserName;
         return this;
      }

      public TeamOutputStatisticsDetailsReport build() {
         return new TeamOutputStatisticsDetailsReport(
            this.typeNumber,
            this.projectName,
            this.batchName,
            this.structureType,
            this.structureClassId,
            this.classificationName,
            this.artifactName,
            this.serialNumber,
            this.specification,
            this.length,
            this.grossWeight,
            this.taskQuantity,
            this.totalTaskGrossWeight,
            this.completeQuantity,
            this.totalCompleteGrossWeight,
            this.reportUserName
         );
      }

      @Override
      public String toString() {
         return "TeamOutputStatisticsDetailsReport.TeamOutputStatisticsDetailsReportBuilder(typeNumber="
            + this.typeNumber
            + ", projectName="
            + this.projectName
            + ", batchName="
            + this.batchName
            + ", structureType="
            + this.structureType
            + ", structureClassId="
            + this.structureClassId
            + ", classificationName="
            + this.classificationName
            + ", artifactName="
            + this.artifactName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", grossWeight="
            + this.grossWeight
            + ", taskQuantity="
            + this.taskQuantity
            + ", totalTaskGrossWeight="
            + this.totalTaskGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", totalCompleteGrossWeight="
            + this.totalCompleteGrossWeight
            + ", reportUserName="
            + this.reportUserName
            + ")";
      }
   }
}
