package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.pangu.common.pojo.ChangeInfo;
import com.hzchum.scim.plan.core.api.pojo._do.TechChangeDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("变更记录详情")
public class ChangeDetailDO {
   @ApiModelProperty("构件变更信息")
   List<ChangeInfo> artifactChanges;
   @ApiModelProperty("组立变更信息")
   List<TechChangeDetail> assembleChanges;
   @ApiModelProperty("零件变更信息")
   List<TechChangeDetail> machinePartChanges;

   ChangeDetailDO(final List<ChangeInfo> artifactChanges, final List<TechChangeDetail> assembleChanges, final List<TechChangeDetail> machinePartChanges) {
      this.artifactChanges = artifactChanges;
      this.assembleChanges = assembleChanges;
      this.machinePartChanges = machinePartChanges;
   }

   public static ChangeDetailDO.ChangeDetailDOBuilder builder() {
      return new ChangeDetailDO.ChangeDetailDOBuilder();
   }

   public List<ChangeInfo> getArtifactChanges() {
      return this.artifactChanges;
   }

   public List<TechChangeDetail> getAssembleChanges() {
      return this.assembleChanges;
   }

   public List<TechChangeDetail> getMachinePartChanges() {
      return this.machinePartChanges;
   }

   public void setArtifactChanges(final List<ChangeInfo> artifactChanges) {
      this.artifactChanges = artifactChanges;
   }

   public void setAssembleChanges(final List<TechChangeDetail> assembleChanges) {
      this.assembleChanges = assembleChanges;
   }

   public void setMachinePartChanges(final List<TechChangeDetail> machinePartChanges) {
      this.machinePartChanges = machinePartChanges;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeDetailDO)) {
         return false;
      }

      ChangeDetailDO other = (ChangeDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactChanges = this.getArtifactChanges();
      Object other$artifactChanges = other.getArtifactChanges();
      if (this$artifactChanges == null ? other$artifactChanges == null : this$artifactChanges.equals(other$artifactChanges)) {
         Object this$assembleChanges = this.getAssembleChanges();
         Object other$assembleChanges = other.getAssembleChanges();
         if (this$assembleChanges == null ? other$assembleChanges == null : this$assembleChanges.equals(other$assembleChanges)) {
            Object this$machinePartChanges = this.getMachinePartChanges();
            Object other$machinePartChanges = other.getMachinePartChanges();
            return this$machinePartChanges == null ? other$machinePartChanges == null : this$machinePartChanges.equals(other$machinePartChanges);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ChangeDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactChanges = this.getArtifactChanges();
      result = result * 59 + ($artifactChanges == null ? 43 : $artifactChanges.hashCode());
      Object $assembleChanges = this.getAssembleChanges();
      result = result * 59 + ($assembleChanges == null ? 43 : $assembleChanges.hashCode());
      Object $machinePartChanges = this.getMachinePartChanges();
      return result * 59 + ($machinePartChanges == null ? 43 : $machinePartChanges.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeDetailDO(artifactChanges="
         + this.getArtifactChanges()
         + ", assembleChanges="
         + this.getAssembleChanges()
         + ", machinePartChanges="
         + this.getMachinePartChanges()
         + ")";
   }

   public static class ChangeDetailDOBuilder {
      private List<ChangeInfo> artifactChanges;
      private List<TechChangeDetail> assembleChanges;
      private List<TechChangeDetail> machinePartChanges;

      ChangeDetailDOBuilder() {
      }

      public ChangeDetailDO.ChangeDetailDOBuilder artifactChanges(final List<ChangeInfo> artifactChanges) {
         this.artifactChanges = artifactChanges;
         return this;
      }

      public ChangeDetailDO.ChangeDetailDOBuilder assembleChanges(final List<TechChangeDetail> assembleChanges) {
         this.assembleChanges = assembleChanges;
         return this;
      }

      public ChangeDetailDO.ChangeDetailDOBuilder machinePartChanges(final List<TechChangeDetail> machinePartChanges) {
         this.machinePartChanges = machinePartChanges;
         return this;
      }

      public ChangeDetailDO build() {
         return new ChangeDetailDO(this.artifactChanges, this.assembleChanges, this.machinePartChanges);
      }

      @Override
      public String toString() {
         return "ChangeDetailDO.ChangeDetailDOBuilder(artifactChanges="
            + this.artifactChanges
            + ", assembleChanges="
            + this.assembleChanges
            + ", machinePartChanges="
            + this.machinePartChanges
            + ")";
      }
   }
}
