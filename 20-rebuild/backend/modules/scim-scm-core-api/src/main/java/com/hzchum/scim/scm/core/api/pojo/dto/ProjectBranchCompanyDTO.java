package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目分支机构")
public class ProjectBranchCompanyDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty("分支机构列表")
   private List<NameInfo> branchCompanyList;

   public static ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder builder() {
      return new ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder();
   }

   public ProjectBranchCompanyDTO(final Long id, final String name, final String shortName, final String serialNumber, final List<NameInfo> branchCompanyList) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.branchCompanyList = branchCompanyList;
   }

   public ProjectBranchCompanyDTO() {
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

   public List<NameInfo> getBranchCompanyList() {
      return this.branchCompanyList;
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

   public void setBranchCompanyList(final List<NameInfo> branchCompanyList) {
      this.branchCompanyList = branchCompanyList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBranchCompanyDTO)) {
         return false;
      }

      ProjectBranchCompanyDTO other = (ProjectBranchCompanyDTO)o;
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
                  Object this$branchCompanyList = this.getBranchCompanyList();
                  Object other$branchCompanyList = other.getBranchCompanyList();
                  return this$branchCompanyList == null ? other$branchCompanyList == null : this$branchCompanyList.equals(other$branchCompanyList);
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
      return other instanceof ProjectBranchCompanyDTO;
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
      Object $branchCompanyList = this.getBranchCompanyList();
      return result * 59 + ($branchCompanyList == null ? 43 : $branchCompanyList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBranchCompanyDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", branchCompanyList="
         + this.getBranchCompanyList()
         + ")";
   }

   public static class ProjectBranchCompanyDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private List<NameInfo> branchCompanyList;

      ProjectBranchCompanyDTOBuilder() {
      }

      public ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder branchCompanyList(final List<NameInfo> branchCompanyList) {
         this.branchCompanyList = branchCompanyList;
         return this;
      }

      public ProjectBranchCompanyDTO build() {
         return new ProjectBranchCompanyDTO(this.id, this.name, this.shortName, this.serialNumber, this.branchCompanyList);
      }

      @Override
      public String toString() {
         return "ProjectBranchCompanyDTO.ProjectBranchCompanyDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", branchCompanyList="
            + this.branchCompanyList
            + ")";
      }
   }
}
