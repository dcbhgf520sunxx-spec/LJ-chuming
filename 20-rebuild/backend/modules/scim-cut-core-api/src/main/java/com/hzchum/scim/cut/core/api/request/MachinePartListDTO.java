package com.hzchum.scim.cut.core.api.request;

import com.hzchum.scim.cut.core.api.pojo._do.CutMachine;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MachinePartListDTO", description = "设备+零件")
public class MachinePartListDTO {
   private CutMachine cutMachine;
   private Integer finishNum;
   private BigDecimal finishWeight;

   MachinePartListDTO(final CutMachine cutMachine, final Integer finishNum, final BigDecimal finishWeight) {
      this.cutMachine = cutMachine;
      this.finishNum = finishNum;
      this.finishWeight = finishWeight;
   }

   public static MachinePartListDTO.MachinePartListDTOBuilder builder() {
      return new MachinePartListDTO.MachinePartListDTOBuilder();
   }

   public CutMachine getCutMachine() {
      return this.cutMachine;
   }

   public Integer getFinishNum() {
      return this.finishNum;
   }

   public BigDecimal getFinishWeight() {
      return this.finishWeight;
   }

   public void setCutMachine(final CutMachine cutMachine) {
      this.cutMachine = cutMachine;
   }

   public void setFinishNum(final Integer finishNum) {
      this.finishNum = finishNum;
   }

   public void setFinishWeight(final BigDecimal finishWeight) {
      this.finishWeight = finishWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartListDTO)) {
         return false;
      }

      MachinePartListDTO other = (MachinePartListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$finishNum = this.getFinishNum();
      Object other$finishNum = other.getFinishNum();
      if (this$finishNum == null ? other$finishNum == null : this$finishNum.equals(other$finishNum)) {
         Object this$cutMachine = this.getCutMachine();
         Object other$cutMachine = other.getCutMachine();
         if (this$cutMachine == null ? other$cutMachine == null : this$cutMachine.equals(other$cutMachine)) {
            Object this$finishWeight = this.getFinishWeight();
            Object other$finishWeight = other.getFinishWeight();
            return this$finishWeight == null ? other$finishWeight == null : this$finishWeight.equals(other$finishWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $finishNum = this.getFinishNum();
      result = result * 59 + ($finishNum == null ? 43 : $finishNum.hashCode());
      Object $cutMachine = this.getCutMachine();
      result = result * 59 + ($cutMachine == null ? 43 : $cutMachine.hashCode());
      Object $finishWeight = this.getFinishWeight();
      return result * 59 + ($finishWeight == null ? 43 : $finishWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartListDTO(cutMachine=" + this.getCutMachine() + ", finishNum=" + this.getFinishNum() + ", finishWeight=" + this.getFinishWeight() + ")";
   }

   public static class MachinePartListDTOBuilder {
      private CutMachine cutMachine;
      private Integer finishNum;
      private BigDecimal finishWeight;

      MachinePartListDTOBuilder() {
      }

      public MachinePartListDTO.MachinePartListDTOBuilder cutMachine(final CutMachine cutMachine) {
         this.cutMachine = cutMachine;
         return this;
      }

      public MachinePartListDTO.MachinePartListDTOBuilder finishNum(final Integer finishNum) {
         this.finishNum = finishNum;
         return this;
      }

      public MachinePartListDTO.MachinePartListDTOBuilder finishWeight(final BigDecimal finishWeight) {
         this.finishWeight = finishWeight;
         return this;
      }

      public MachinePartListDTO build() {
         return new MachinePartListDTO(this.cutMachine, this.finishNum, this.finishWeight);
      }

      @Override
      public String toString() {
         return "MachinePartListDTO.MachinePartListDTOBuilder(cutMachine="
            + this.cutMachine
            + ", finishNum="
            + this.finishNum
            + ", finishWeight="
            + this.finishWeight
            + ")";
      }
   }
}
