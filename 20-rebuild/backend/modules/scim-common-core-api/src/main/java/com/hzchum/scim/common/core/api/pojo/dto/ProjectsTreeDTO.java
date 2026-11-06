package com.hzchum.scim.common.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectsTreeDTO", description = "项目树形结构展示信息")
public class ProjectsTreeDTO {
   @ApiModelProperty(name = "id", notes = "项目id", value = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "项目名", value = "项目名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "项目简称", value = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "monomerList", notes = "单体信息", value = "单体信息")
   @JsonProperty("monomerList")
   @JSONField(name = "monomerList")
   @JsonInclude(Include.NON_NULL)
   private List<MonomerTreeDTO> monomerList;

   ProjectsTreeDTO(final Long id, final String name, final String shortName, final String serialNumber, final List<MonomerTreeDTO> monomerList) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.monomerList = monomerList;
   }

   public static ProjectsTreeDTO.ProjectsTreeDTOBuilder builder() {
      return new ProjectsTreeDTO.ProjectsTreeDTOBuilder();
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

   public List<MonomerTreeDTO> getMonomerList() {
      return this.monomerList;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("shortName")
   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("monomerList")
   public void setMonomerList(final List<MonomerTreeDTO> monomerList) {
      this.monomerList = monomerList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectsTreeDTO)) {
         return false;
      }

      ProjectsTreeDTO other = (ProjectsTreeDTO)o;
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
                  Object this$monomerList = this.getMonomerList();
                  Object other$monomerList = other.getMonomerList();
                  return this$monomerList == null ? other$monomerList == null : this$monomerList.equals(other$monomerList);
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
      return other instanceof ProjectsTreeDTO;
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
      Object $monomerList = this.getMonomerList();
      return result * 59 + ($monomerList == null ? 43 : $monomerList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectsTreeDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", monomerList="
         + this.getMonomerList()
         + ")";
   }

   public static class ProjectsTreeDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private List<MonomerTreeDTO> monomerList;

      ProjectsTreeDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectsTreeDTO.ProjectsTreeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProjectsTreeDTO.ProjectsTreeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public ProjectsTreeDTO.ProjectsTreeDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectsTreeDTO.ProjectsTreeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("monomerList")
      public ProjectsTreeDTO.ProjectsTreeDTOBuilder monomerList(final List<MonomerTreeDTO> monomerList) {
         this.monomerList = monomerList;
         return this;
      }

      public ProjectsTreeDTO build() {
         return new ProjectsTreeDTO(this.id, this.name, this.shortName, this.serialNumber, this.monomerList);
      }

      @Override
      public String toString() {
         return "ProjectsTreeDTO.ProjectsTreeDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", monomerList="
            + this.monomerList
            + ")";
      }
   }
}
