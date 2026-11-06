package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "PlateProduceAnalysisDTO", description = "版型分析")
public class PlateProduceAnalysisDTO {
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "completeLength", notes = "生产量", value = "生产量")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "proportion", notes = "占比", value = "占比")
   @JsonProperty("proportion")
   @JSONField(name = "proportion")
   private BigDecimal proportion;

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getProportion() {
      return this.proportion;
   }

   @JsonProperty("plate")
   public PlateProduceAnalysisDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("completeLength")
   public PlateProduceAnalysisDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("proportion")
   public PlateProduceAnalysisDTO setProportion(final BigDecimal proportion) {
      this.proportion = proportion;
      return this;
   }

   @Override
   public String toString() {
      return "PlateProduceAnalysisDTO(plate=" + this.getPlate() + ", completeLength=" + this.getCompleteLength() + ", proportion=" + this.getProportion() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlateProduceAnalysisDTO)) {
         return false;
      }

      PlateProduceAnalysisDTO other = (PlateProduceAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$plate = this.getPlate();
      Object other$plate = other.getPlate();
      if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
         Object this$completeLength = this.getCompleteLength();
         Object other$completeLength = other.getCompleteLength();
         if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
            Object this$proportion = this.getProportion();
            Object other$proportion = other.getProportion();
            return this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlateProduceAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $proportion = this.getProportion();
      return result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
   }
}
