package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("产品生产完成量")
public class MesProductCompleteDTO {
   @ApiModelProperty(name = "completedMete", value = "已完成总量 t/m")
   private BigDecimal completedMete;

   public static MesProductCompleteDTO.MesProductCompleteDTOBuilder builder() {
      return new MesProductCompleteDTO.MesProductCompleteDTOBuilder();
   }

   public BigDecimal getCompletedMete() {
      return this.completedMete;
   }

   public void setCompletedMete(final BigDecimal completedMete) {
      this.completedMete = completedMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductCompleteDTO)) {
         return false;
      }

      MesProductCompleteDTO other = (MesProductCompleteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completedMete = this.getCompletedMete();
      Object other$completedMete = other.getCompletedMete();
      return this$completedMete == null ? other$completedMete == null : this$completedMete.equals(other$completedMete);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesProductCompleteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completedMete = this.getCompletedMete();
      return result * 59 + ($completedMete == null ? 43 : $completedMete.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductCompleteDTO(completedMete=" + this.getCompletedMete() + ")";
   }

   public MesProductCompleteDTO(final BigDecimal completedMete) {
      this.completedMete = completedMete;
   }

   public MesProductCompleteDTO() {
   }

   public static class MesProductCompleteDTOBuilder {
      private BigDecimal completedMete;

      MesProductCompleteDTOBuilder() {
      }

      public MesProductCompleteDTO.MesProductCompleteDTOBuilder completedMete(final BigDecimal completedMete) {
         this.completedMete = completedMete;
         return this;
      }

      public MesProductCompleteDTO build() {
         return new MesProductCompleteDTO(this.completedMete);
      }

      @Override
      public String toString() {
         return "MesProductCompleteDTO.MesProductCompleteDTOBuilder(completedMete=" + this.completedMete + ")";
      }
   }
}
