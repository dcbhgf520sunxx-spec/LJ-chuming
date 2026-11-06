package com.hzchum.scim.cut.core.api.request;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "PlateExport", description = "钢板清单excel")
public class PlateExport {
   private String projectName;
   private String cutInstructionId;
   private String material;
   private BigDecimal thick;
   private BigDecimal width;
   private BigDecimal length;
   private BigDecimal weight;

   PlateExport(
      final String projectName,
      final String cutInstructionId,
      final String material,
      final BigDecimal thick,
      final BigDecimal width,
      final BigDecimal length,
      final BigDecimal weight
   ) {
      this.projectName = projectName;
      this.cutInstructionId = cutInstructionId;
      this.material = material;
      this.thick = thick;
      this.width = width;
      this.length = length;
      this.weight = weight;
   }

   public static PlateExport.PlateExportBuilder builder() {
      return new PlateExport.PlateExportBuilder();
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlateExport)) {
         return false;
      }

      PlateExport other = (PlateExport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$cutInstructionId = this.getCutInstructionId();
         Object other$cutInstructionId = other.getCutInstructionId();
         if (this$cutInstructionId == null ? other$cutInstructionId == null : this$cutInstructionId.equals(other$cutInstructionId)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$thick = this.getThick();
               Object other$thick = other.getThick();
               if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                  Object this$width = this.getWidth();
                  Object other$width = other.getWidth();
                  if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$weight = this.getWeight();
                        Object other$weight = other.getWeight();
                        return this$weight == null ? other$weight == null : this$weight.equals(other$weight);
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
      return other instanceof PlateExport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "PlateExport(projectName="
         + this.getProjectName()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", material="
         + this.getMaterial()
         + ", thick="
         + this.getThick()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", weight="
         + this.getWeight()
         + ")";
   }

   public static class PlateExportBuilder {
      private String projectName;
      private String cutInstructionId;
      private String material;
      private BigDecimal thick;
      private BigDecimal width;
      private BigDecimal length;
      private BigDecimal weight;

      PlateExportBuilder() {
      }

      public PlateExport.PlateExportBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public PlateExport.PlateExportBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      public PlateExport.PlateExportBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PlateExport.PlateExportBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public PlateExport.PlateExportBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public PlateExport.PlateExportBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PlateExport.PlateExportBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public PlateExport build() {
         return new PlateExport(this.projectName, this.cutInstructionId, this.material, this.thick, this.width, this.length, this.weight);
      }

      @Override
      public String toString() {
         return "PlateExport.PlateExportBuilder(projectName="
            + this.projectName
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", material="
            + this.material
            + ", thick="
            + this.thick
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", weight="
            + this.weight
            + ")";
      }
   }
}
