package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOtherApportionmentLink;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目其他分摊关联DTO类")
public class MesContractProjectOtherApportionmentLinkDTO extends MesContractProjectOtherApportionmentLink {
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "factoryName", value = "工厂名称", notes = "工厂名称")
   private String factoryName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesContractProjectOtherApportionmentLinkDTO)) {
         return false;
      } else {
         MesContractProjectOtherApportionmentLinkDTO other = (MesContractProjectOtherApportionmentLinkDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$factoryName = this.getFactoryName();
               Object other$factoryName = other.getFactoryName();
               return this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectOtherApportionmentLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $factoryName = this.getFactoryName();
      return result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   @Override
   public String toString() {
      return "MesContractProjectOtherApportionmentLinkDTO(super="
         + super.toString()
         + ", processName="
         + this.getProcessName()
         + ", factoryName="
         + this.getFactoryName()
         + ")";
   }
}
