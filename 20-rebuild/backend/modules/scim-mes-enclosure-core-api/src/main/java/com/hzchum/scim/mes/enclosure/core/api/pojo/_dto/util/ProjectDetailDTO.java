package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectDO", description = "项目基础信息")
public class ProjectDetailDTO {
   @ApiModelProperty(name = "id", notes = "项目id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "项目名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "contractNo", value = "项目编号")
   @JsonProperty("contractNo")
   @JSONField(name = "contractNo")
   private String contractNo;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "type", value = "项目类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static ProjectDetailDTO.ProjectDetailDTOBuilder builder() {
      return new ProjectDetailDTO.ProjectDetailDTOBuilder();
   }

   public ProjectDetailDTO() {
   }

   public ProjectDetailDTO(final Long id, final String name, final String contractNo, final String shortName, final Integer type) {
      this.id = id;
      this.name = name;
      this.contractNo = contractNo;
      this.shortName = shortName;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public ProjectDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProjectDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("contractNo")
   public ProjectDetailDTO setContractNo(final String contractNo) {
      this.contractNo = contractNo;
      return this;
   }

   @JsonProperty("shortName")
   public ProjectDetailDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("type")
   public ProjectDetailDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectDetailDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", contractNo="
         + this.getContractNo()
         + ", shortName="
         + this.getShortName()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectDetailDTO)) {
         return false;
      }

      ProjectDetailDTO other = (ProjectDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$contractNo = this.getContractNo();
               Object other$contractNo = other.getContractNo();
               if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  return this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName);
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
      return other instanceof ProjectDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $shortName = this.getShortName();
      return result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
   }

   public static class ProjectDetailDTOBuilder {
      private Long id;
      private String name;
      private String contractNo;
      private String shortName;
      private Integer type;

      ProjectDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectDetailDTO.ProjectDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProjectDetailDTO.ProjectDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("contractNo")
      public ProjectDetailDTO.ProjectDetailDTOBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      @JsonProperty("shortName")
      public ProjectDetailDTO.ProjectDetailDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("type")
      public ProjectDetailDTO.ProjectDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectDetailDTO build() {
         return new ProjectDetailDTO(this.id, this.name, this.contractNo, this.shortName, this.type);
      }

      @Override
      public String toString() {
         return "ProjectDetailDTO.ProjectDetailDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", contractNo="
            + this.contractNo
            + ", shortName="
            + this.shortName
            + ", type="
            + this.type
            + ")";
      }
   }
}
