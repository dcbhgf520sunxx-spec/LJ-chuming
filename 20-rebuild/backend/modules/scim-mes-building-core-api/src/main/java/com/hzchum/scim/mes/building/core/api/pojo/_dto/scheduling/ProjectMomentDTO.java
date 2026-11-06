package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ProjectMomentDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty(notes = "单体")
   private List<NameInfo> monomers;

   public static ProjectMomentDTO.ProjectMomentDTOBuilder builder() {
      return new ProjectMomentDTO.ProjectMomentDTOBuilder();
   }

   public ProjectMomentDTO(final Long id, final String name, final String shortName, final String serialNumber, final List<NameInfo> monomers) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.monomers = monomers;
   }

   public ProjectMomentDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<NameInfo> getMonomers() {
      return this.monomers;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMonomers(final List<NameInfo> monomers) {
      this.monomers = monomers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMomentDTO)) {
         return false;
      }

      ProjectMomentDTO other = (ProjectMomentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$monomers = this.getMonomers();
                  Object other$monomers = other.getMonomers();
                  return this$monomers == null ? other$monomers == null : this$monomers.equals(other$monomers);
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
      return other instanceof ProjectMomentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $monomers = this.getMonomers();
      return result * 59 + ($monomers == null ? 43 : $monomers.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMomentDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", monomers="
         + this.getMonomers()
         + ")";
   }

   public static class ProjectMomentDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private List<NameInfo> monomers;

      ProjectMomentDTOBuilder() {
      }

      public ProjectMomentDTO.ProjectMomentDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectMomentDTO.ProjectMomentDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectMomentDTO.ProjectMomentDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectMomentDTO.ProjectMomentDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectMomentDTO.ProjectMomentDTOBuilder monomers(final List<NameInfo> monomers) {
         this.monomers = monomers;
         return this;
      }

      public ProjectMomentDTO build() {
         return new ProjectMomentDTO(this.id, this.name, this.shortName, this.serialNumber, this.monomers);
      }

      @Override
      public String toString() {
         return "ProjectMomentDTO.ProjectMomentDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", monomers="
            + this.monomers
            + ")";
      }
   }
}
