package com.hzchum.scim.project.core.api.pojo.dto.sub;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("合同类")
public class SubProjectDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "projectType", notes = "项目类型 1.建钢项目  2.桥梁项目 ")
   private Integer projectType;
   @ApiModelProperty(name = "businessType", notes = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "status", notes = "项目状态  0：进行中，1：已暂停，2：已完工 ")
   private Integer status;
   @ApiModelProperty("单体列表")
   private List<SubMonomerDTO> children;

   public static SubProjectDTO.SubProjectDTOBuilder builder() {
      return new SubProjectDTO.SubProjectDTOBuilder();
   }

   public SubProjectDTO() {
   }

   public SubProjectDTO(
      final Long id,
      final String serialNumber,
      final String name,
      final String shortName,
      final Integer projectType,
      final Integer businessType,
      final Integer status,
      final List<SubMonomerDTO> children
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.projectType = projectType;
      this.businessType = businessType;
      this.status = status;
      this.children = children;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<SubMonomerDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setChildren(final List<SubMonomerDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubProjectDTO)) {
         return false;
      }

      SubProjectDTO other = (SubProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$businessType = this.getBusinessType();
            Object other$businessType = other.getBusinessType();
            if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$shortName = this.getShortName();
                        Object other$shortName = other.getShortName();
                        if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                           Object this$children = this.getChildren();
                           Object other$children = other.getChildren();
                           return this$children == null ? other$children == null : this$children.equals(other$children);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubProjectDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", projectType="
         + this.getProjectType()
         + ", businessType="
         + this.getBusinessType()
         + ", status="
         + this.getStatus()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public static class SubProjectDTOBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private String shortName;
      private Integer projectType;
      private Integer businessType;
      private Integer status;
      private List<SubMonomerDTO> children;

      SubProjectDTOBuilder() {
      }

      public SubProjectDTO.SubProjectDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SubProjectDTO.SubProjectDTOBuilder children(final List<SubMonomerDTO> children) {
         this.children = children;
         return this;
      }

      public SubProjectDTO build() {
         return new SubProjectDTO(this.id, this.serialNumber, this.name, this.shortName, this.projectType, this.businessType, this.status, this.children);
      }

      @Override
      public String toString() {
         return "SubProjectDTO.SubProjectDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", projectType="
            + this.projectType
            + ", businessType="
            + this.businessType
            + ", status="
            + this.status
            + ", children="
            + this.children
            + ")";
      }
   }
}
