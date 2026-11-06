package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目分析数据")
public class ProjectAnalysisDataDTO {
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "structureStatus", value = "项目类型")
   private Integer structureStatus;
   @ApiModelProperty(name = "structureStatusName", value = "项目类型")
   private String structureStatusName;
   @ApiModelProperty(name = "unit", value = "单位")
   private String unit;
   @ApiModelProperty(name = "structureQuantityWork", value = "结构工程量")
   private BigDecimal structureQuantityWork;
   @ApiModelProperty(name = "deepenTon", value = "深化量")
   private BigDecimal deepenTon;
   @ApiModelProperty(name = "productionCompleteTon", value = "生产完成量")
   private BigDecimal productionCompleteTon;
   @ApiModelProperty(name = "shippedCompleteTon", value = "发运完成量")
   private BigDecimal shippedCompleteTon;

   public static ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder builder() {
      return new ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder();
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public String getStructureStatusName() {
      return this.structureStatusName;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getStructureQuantityWork() {
      return this.structureQuantityWork;
   }

   public BigDecimal getDeepenTon() {
      return this.deepenTon;
   }

   public BigDecimal getProductionCompleteTon() {
      return this.productionCompleteTon;
   }

   public BigDecimal getShippedCompleteTon() {
      return this.shippedCompleteTon;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureStatusName(final String structureStatusName) {
      this.structureStatusName = structureStatusName;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setStructureQuantityWork(final BigDecimal structureQuantityWork) {
      this.structureQuantityWork = structureQuantityWork;
   }

   public void setDeepenTon(final BigDecimal deepenTon) {
      this.deepenTon = deepenTon;
   }

   public void setProductionCompleteTon(final BigDecimal productionCompleteTon) {
      this.productionCompleteTon = productionCompleteTon;
   }

   public void setShippedCompleteTon(final BigDecimal shippedCompleteTon) {
      this.shippedCompleteTon = shippedCompleteTon;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAnalysisDataDTO)) {
         return false;
      }

      ProjectAnalysisDataDTO other = (ProjectAnalysisDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureStatus = this.getStructureStatus();
      Object other$structureStatus = other.getStructureStatus();
      if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
         Object this$shortName = this.getShortName();
         Object other$shortName = other.getShortName();
         if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$structureStatusName = this.getStructureStatusName();
               Object other$structureStatusName = other.getStructureStatusName();
               if (this$structureStatusName == null ? other$structureStatusName == null : this$structureStatusName.equals(other$structureStatusName)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$structureQuantityWork = this.getStructureQuantityWork();
                     Object other$structureQuantityWork = other.getStructureQuantityWork();
                     if (this$structureQuantityWork == null
                        ? other$structureQuantityWork == null
                        : this$structureQuantityWork.equals(other$structureQuantityWork)) {
                        Object this$deepenTon = this.getDeepenTon();
                        Object other$deepenTon = other.getDeepenTon();
                        if (this$deepenTon == null ? other$deepenTon == null : this$deepenTon.equals(other$deepenTon)) {
                           Object this$productionCompleteTon = this.getProductionCompleteTon();
                           Object other$productionCompleteTon = other.getProductionCompleteTon();
                           if (this$productionCompleteTon == null
                              ? other$productionCompleteTon == null
                              : this$productionCompleteTon.equals(other$productionCompleteTon)) {
                              Object this$shippedCompleteTon = this.getShippedCompleteTon();
                              Object other$shippedCompleteTon = other.getShippedCompleteTon();
                              return this$shippedCompleteTon == null
                                 ? other$shippedCompleteTon == null
                                 : this$shippedCompleteTon.equals(other$shippedCompleteTon);
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
      return other instanceof ProjectAnalysisDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $structureStatusName = this.getStructureStatusName();
      result = result * 59 + ($structureStatusName == null ? 43 : $structureStatusName.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $structureQuantityWork = this.getStructureQuantityWork();
      result = result * 59 + ($structureQuantityWork == null ? 43 : $structureQuantityWork.hashCode());
      Object $deepenTon = this.getDeepenTon();
      result = result * 59 + ($deepenTon == null ? 43 : $deepenTon.hashCode());
      Object $productionCompleteTon = this.getProductionCompleteTon();
      result = result * 59 + ($productionCompleteTon == null ? 43 : $productionCompleteTon.hashCode());
      Object $shippedCompleteTon = this.getShippedCompleteTon();
      return result * 59 + ($shippedCompleteTon == null ? 43 : $shippedCompleteTon.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAnalysisDataDTO(super="
         + super.toString()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureStatusName="
         + this.getStructureStatusName()
         + ", unit="
         + this.getUnit()
         + ", structureQuantityWork="
         + this.getStructureQuantityWork()
         + ", deepenTon="
         + this.getDeepenTon()
         + ", productionCompleteTon="
         + this.getProductionCompleteTon()
         + ", shippedCompleteTon="
         + this.getShippedCompleteTon()
         + ")";
   }

   public ProjectAnalysisDataDTO(
      final String shortName,
      final String serialNumber,
      final Integer structureStatus,
      final String structureStatusName,
      final String unit,
      final BigDecimal structureQuantityWork,
      final BigDecimal deepenTon,
      final BigDecimal productionCompleteTon,
      final BigDecimal shippedCompleteTon
   ) {
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.structureStatus = structureStatus;
      this.structureStatusName = structureStatusName;
      this.unit = unit;
      this.structureQuantityWork = structureQuantityWork;
      this.deepenTon = deepenTon;
      this.productionCompleteTon = productionCompleteTon;
      this.shippedCompleteTon = shippedCompleteTon;
   }

   public ProjectAnalysisDataDTO() {
   }

   public static class ProjectAnalysisDataDTOBuilder {
      private String shortName;
      private String serialNumber;
      private Integer structureStatus;
      private String structureStatusName;
      private String unit;
      private BigDecimal structureQuantityWork;
      private BigDecimal deepenTon;
      private BigDecimal productionCompleteTon;
      private BigDecimal shippedCompleteTon;

      ProjectAnalysisDataDTOBuilder() {
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder structureStatus(final Integer structureStatus) {
         this.structureStatus = structureStatus;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder structureStatusName(final String structureStatusName) {
         this.structureStatusName = structureStatusName;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder structureQuantityWork(final BigDecimal structureQuantityWork) {
         this.structureQuantityWork = structureQuantityWork;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder deepenTon(final BigDecimal deepenTon) {
         this.deepenTon = deepenTon;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder productionCompleteTon(final BigDecimal productionCompleteTon) {
         this.productionCompleteTon = productionCompleteTon;
         return this;
      }

      public ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder shippedCompleteTon(final BigDecimal shippedCompleteTon) {
         this.shippedCompleteTon = shippedCompleteTon;
         return this;
      }

      public ProjectAnalysisDataDTO build() {
         return new ProjectAnalysisDataDTO(
            this.shortName,
            this.serialNumber,
            this.structureStatus,
            this.structureStatusName,
            this.unit,
            this.structureQuantityWork,
            this.deepenTon,
            this.productionCompleteTon,
            this.shippedCompleteTon
         );
      }

      @Override
      public String toString() {
         return "ProjectAnalysisDataDTO.ProjectAnalysisDataDTOBuilder(shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", structureStatus="
            + this.structureStatus
            + ", structureStatusName="
            + this.structureStatusName
            + ", unit="
            + this.unit
            + ", structureQuantityWork="
            + this.structureQuantityWork
            + ", deepenTon="
            + this.deepenTon
            + ", productionCompleteTon="
            + this.productionCompleteTon
            + ", shippedCompleteTon="
            + this.shippedCompleteTon
            + ")";
      }
   }
}
