package com.hzchum.scim.cut.core.api.param;

public class JobParam {
   private String prdRefDst;
   private String machine;
   private String material;
   private Double thickness;
   private int quantity;
   private int disPriority;

   JobParam(final String prdRefDst, final String machine, final String material, final Double thickness, final int quantity, final int disPriority) {
      this.prdRefDst = prdRefDst;
      this.machine = machine;
      this.material = material;
      this.thickness = thickness;
      this.quantity = quantity;
      this.disPriority = disPriority;
   }

   public static JobParam.JobParamBuilder builder() {
      return new JobParam.JobParamBuilder();
   }

   public String getPrdRefDst() {
      return this.prdRefDst;
   }

   public String getMachine() {
      return this.machine;
   }

   public String getMaterial() {
      return this.material;
   }

   public Double getThickness() {
      return this.thickness;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public int getDisPriority() {
      return this.disPriority;
   }

   public void setPrdRefDst(final String prdRefDst) {
      this.prdRefDst = prdRefDst;
   }

   public void setMachine(final String machine) {
      this.machine = machine;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final Double thickness) {
      this.thickness = thickness;
   }

   public void setQuantity(final int quantity) {
      this.quantity = quantity;
   }

   public void setDisPriority(final int disPriority) {
      this.disPriority = disPriority;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JobParam)) {
         return false;
      }

      JobParam other = (JobParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getQuantity() != other.getQuantity()) {
         return false;
      }

      if (this.getDisPriority() != other.getDisPriority()) {
         return false;
      }

      Object this$thickness = this.getThickness();
      Object other$thickness = other.getThickness();
      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
         Object this$prdRefDst = this.getPrdRefDst();
         Object other$prdRefDst = other.getPrdRefDst();
         if (this$prdRefDst == null ? other$prdRefDst == null : this$prdRefDst.equals(other$prdRefDst)) {
            Object this$machine = this.getMachine();
            Object other$machine = other.getMachine();
            if (this$machine == null ? other$machine == null : this$machine.equals(other$machine)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof JobParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getQuantity();
      result = result * 59 + this.getDisPriority();
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $prdRefDst = this.getPrdRefDst();
      result = result * 59 + ($prdRefDst == null ? 43 : $prdRefDst.hashCode());
      Object $machine = this.getMachine();
      result = result * 59 + ($machine == null ? 43 : $machine.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "JobParam(prdRefDst="
         + this.getPrdRefDst()
         + ", machine="
         + this.getMachine()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", quantity="
         + this.getQuantity()
         + ", disPriority="
         + this.getDisPriority()
         + ")";
   }

   public static class JobParamBuilder {
      private String prdRefDst;
      private String machine;
      private String material;
      private Double thickness;
      private int quantity;
      private int disPriority;

      JobParamBuilder() {
      }

      public JobParam.JobParamBuilder prdRefDst(final String prdRefDst) {
         this.prdRefDst = prdRefDst;
         return this;
      }

      public JobParam.JobParamBuilder machine(final String machine) {
         this.machine = machine;
         return this;
      }

      public JobParam.JobParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public JobParam.JobParamBuilder thickness(final Double thickness) {
         this.thickness = thickness;
         return this;
      }

      public JobParam.JobParamBuilder quantity(final int quantity) {
         this.quantity = quantity;
         return this;
      }

      public JobParam.JobParamBuilder disPriority(final int disPriority) {
         this.disPriority = disPriority;
         return this;
      }

      public JobParam build() {
         return new JobParam(this.prdRefDst, this.machine, this.material, this.thickness, this.quantity, this.disPriority);
      }

      @Override
      public String toString() {
         return "JobParam.JobParamBuilder(prdRefDst="
            + this.prdRefDst
            + ", machine="
            + this.machine
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", quantity="
            + this.quantity
            + ", disPriority="
            + this.disPriority
            + ")";
      }
   }
}
