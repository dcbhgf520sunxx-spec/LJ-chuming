package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesDayProductionDetailClassDTO", description = "当日产量汇总详情")
public class MesDayProductionDetailClassDTO {
   @ApiModelProperty(name = "classificationName", notes = "名称")
   private String classificationName;
   @ApiModelProperty(name = "dayTotalMete", notes = "当日焊接总重")
   private BigDecimal dayTotalMete;
   @ApiModelProperty(name = "totalMete", notes = "焊接总重(t)")
   private BigDecimal totalMete;

   public static MesDayProductionDetailClassDTO.MesDayProductionDetailClassDTOBuilder builder() {
      return new MesDayProductionDetailClassDTO.MesDayProductionDetailClassDTOBuilder();
   }

   public MesDayProductionDetailClassDTO() {
   }

   public MesDayProductionDetailClassDTO(final String classificationName, final BigDecimal dayTotalMete, final BigDecimal totalMete) {
      this.classificationName = classificationName;
      this.dayTotalMete = dayTotalMete;
      this.totalMete = totalMete;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public BigDecimal getDayTotalMete() {
      return this.dayTotalMete;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public MesDayProductionDetailClassDTO setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   public MesDayProductionDetailClassDTO setDayTotalMete(final BigDecimal dayTotalMete) {
      this.dayTotalMete = dayTotalMete;
      return this;
   }

   public MesDayProductionDetailClassDTO setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @Override
   public String toString() {
      return "MesDayProductionDetailClassDTO(classificationName="
         + this.getClassificationName()
         + ", dayTotalMete="
         + this.getDayTotalMete()
         + ", totalMete="
         + this.getTotalMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesDayProductionDetailClassDTO)) {
         return false;
      }

      MesDayProductionDetailClassDTO other = (MesDayProductionDetailClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classificationName = this.getClassificationName();
      Object other$classificationName = other.getClassificationName();
      if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
         Object this$dayTotalMete = this.getDayTotalMete();
         Object other$dayTotalMete = other.getDayTotalMete();
         if (this$dayTotalMete == null ? other$dayTotalMete == null : this$dayTotalMete.equals(other$dayTotalMete)) {
            Object this$totalMete = this.getTotalMete();
            Object other$totalMete = other.getTotalMete();
            return this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesDayProductionDetailClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $dayTotalMete = this.getDayTotalMete();
      result = result * 59 + ($dayTotalMete == null ? 43 : $dayTotalMete.hashCode());
      Object $totalMete = this.getTotalMete();
      return result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
   }

   public static class MesDayProductionDetailClassDTOBuilder {
      private String classificationName;
      private BigDecimal dayTotalMete;
      private BigDecimal totalMete;

      MesDayProductionDetailClassDTOBuilder() {
      }

      public MesDayProductionDetailClassDTO.MesDayProductionDetailClassDTOBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public MesDayProductionDetailClassDTO.MesDayProductionDetailClassDTOBuilder dayTotalMete(final BigDecimal dayTotalMete) {
         this.dayTotalMete = dayTotalMete;
         return this;
      }

      public MesDayProductionDetailClassDTO.MesDayProductionDetailClassDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public MesDayProductionDetailClassDTO build() {
         return new MesDayProductionDetailClassDTO(this.classificationName, this.dayTotalMete, this.totalMete);
      }

      @Override
      public String toString() {
         return "MesDayProductionDetailClassDTO.MesDayProductionDetailClassDTOBuilder(classificationName="
            + this.classificationName
            + ", dayTotalMete="
            + this.dayTotalMete
            + ", totalMete="
            + this.totalMete
            + ")";
      }
   }
}
