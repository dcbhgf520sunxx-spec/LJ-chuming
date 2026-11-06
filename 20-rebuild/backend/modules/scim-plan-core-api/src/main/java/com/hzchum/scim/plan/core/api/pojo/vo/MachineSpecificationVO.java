package com.hzchum.scim.plan.core.api.pojo.vo;

public class MachineSpecificationVO {
   private String name;

   public static MachineSpecificationVO.MachineSpecificationVOBuilder builder() {
      return new MachineSpecificationVO.MachineSpecificationVOBuilder();
   }

   public MachineSpecificationVO() {
   }

   public MachineSpecificationVO(final String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public MachineSpecificationVO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "MachineSpecificationVO(name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachineSpecificationVO)) {
         return false;
      }

      MachineSpecificationVO other = (MachineSpecificationVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      return this$name == null ? other$name == null : this$name.equals(other$name);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachineSpecificationVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MachineSpecificationVOBuilder {
      private String name;

      MachineSpecificationVOBuilder() {
      }

      public MachineSpecificationVO.MachineSpecificationVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MachineSpecificationVO build() {
         return new MachineSpecificationVO(this.name);
      }

      @Override
      public String toString() {
         return "MachineSpecificationVO.MachineSpecificationVOBuilder(name=" + this.name + ")";
      }
   }
}
