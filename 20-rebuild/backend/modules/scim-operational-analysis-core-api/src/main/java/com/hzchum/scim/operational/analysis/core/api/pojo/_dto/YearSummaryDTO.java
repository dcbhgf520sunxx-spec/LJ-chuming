package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class YearSummaryDTO {
   @ApiModelProperty(name = "thickness", value = "板厚", notes = "板厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private String thickness;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   private String classifyName;
   @ApiModelProperty(name = "spec", value = "材质", notes = "材质")
   @JsonProperty("spec")
   @JSONField(name = "spec")
   private String spec;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "ratio", value = "占比率", notes = "占比率")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;

   public static YearSummaryDTO.YearSummaryDTOBuilder builder() {
      return new YearSummaryDTO.YearSummaryDTOBuilder();
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpec() {
      return this.spec;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   @JsonProperty("thickness")
   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("classifyName")
   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   @JsonProperty("spec")
   public void setSpec(final String spec) {
      this.spec = spec;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("ratio")
   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearSummaryDTO)) {
         return false;
      }

      YearSummaryDTO other = (YearSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$thickness = this.getThickness();
      Object other$thickness = other.getThickness();
      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
            Object this$spec = this.getSpec();
            Object other$spec = other.getSpec();
            if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                  Object this$ratio = this.getRatio();
                  Object other$ratio = other.getRatio();
                  return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
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
      return other instanceof YearSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "YearSummaryDTO(thickness="
         + this.getThickness()
         + ", classifyName="
         + this.getClassifyName()
         + ", spec="
         + this.getSpec()
         + ", mete="
         + this.getMete()
         + ", ratio="
         + this.getRatio()
         + ")";
   }

   public YearSummaryDTO(final String thickness, final String classifyName, final String spec, final BigDecimal mete, final BigDecimal ratio) {
      this.thickness = thickness;
      this.classifyName = classifyName;
      this.spec = spec;
      this.mete = mete;
      this.ratio = ratio;
   }

   public YearSummaryDTO() {
   }

   public static class YearSummaryDTOBuilder {
      private String thickness;
      private String classifyName;
      private String spec;
      private BigDecimal mete;
      private BigDecimal ratio;

      YearSummaryDTOBuilder() {
      }

      @JsonProperty("thickness")
      public YearSummaryDTO.YearSummaryDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("classifyName")
      public YearSummaryDTO.YearSummaryDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("spec")
      public YearSummaryDTO.YearSummaryDTOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      @JsonProperty("mete")
      public YearSummaryDTO.YearSummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("ratio")
      public YearSummaryDTO.YearSummaryDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public YearSummaryDTO build() {
         return new YearSummaryDTO(this.thickness, this.classifyName, this.spec, this.mete, this.ratio);
      }

      @Override
      public String toString() {
         return "YearSummaryDTO.YearSummaryDTOBuilder(thickness="
            + this.thickness
            + ", classifyName="
            + this.classifyName
            + ", spec="
            + this.spec
            + ", mete="
            + this.mete
            + ", ratio="
            + this.ratio
            + ")";
      }
   }
}
