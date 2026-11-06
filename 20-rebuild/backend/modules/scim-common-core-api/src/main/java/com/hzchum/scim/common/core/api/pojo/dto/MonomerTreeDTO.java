package com.hzchum.scim.common.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MonomerTreeDTO", description = "单体树形结构展示信息")
public class MonomerTreeDTO {
   @ApiModelProperty(name = "id", notes = "单体id", value = "单体id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名", value = "单体名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "areaList", notes = "区域信息", value = "区域信息")
   @JsonProperty("areaList")
   @JSONField(name = "areaList")
   @JsonInclude(Include.NON_NULL)
   private List<AreaTreeDTO> areaList;
   @ApiModelProperty(name = "children", notes = "区域信息", value = "区域信息")
   @JsonProperty("children")
   @JSONField(name = "children")
   @JsonInclude(Include.NON_NULL)
   private List<AreaTreeDTO> children;

   public static MonomerTreeDTO.MonomerTreeDTOBuilder builder() {
      return new MonomerTreeDTO.MonomerTreeDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<AreaTreeDTO> getAreaList() {
      return this.areaList;
   }

   public List<AreaTreeDTO> getChildren() {
      return this.children;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("areaList")
   public void setAreaList(final List<AreaTreeDTO> areaList) {
      this.areaList = areaList;
   }

   @JsonProperty("children")
   public void setChildren(final List<AreaTreeDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerTreeDTO)) {
         return false;
      }

      MonomerTreeDTO other = (MonomerTreeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$areaList = this.getAreaList();
            Object other$areaList = other.getAreaList();
            if (this$areaList == null ? other$areaList == null : this$areaList.equals(other$areaList)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerTreeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $areaList = this.getAreaList();
      result = result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerTreeDTO(id=" + this.getId() + ", name=" + this.getName() + ", areaList=" + this.getAreaList() + ", children=" + this.getChildren() + ")";
   }

   public MonomerTreeDTO() {
   }

   public MonomerTreeDTO(final Long id, final String name, final List<AreaTreeDTO> areaList, final List<AreaTreeDTO> children) {
      this.id = id;
      this.name = name;
      this.areaList = areaList;
      this.children = children;
   }

   public static class MonomerTreeDTOBuilder {
      private Long id;
      private String name;
      private List<AreaTreeDTO> areaList;
      private List<AreaTreeDTO> children;

      MonomerTreeDTOBuilder() {
      }

      @JsonProperty("id")
      public MonomerTreeDTO.MonomerTreeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MonomerTreeDTO.MonomerTreeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("areaList")
      public MonomerTreeDTO.MonomerTreeDTOBuilder areaList(final List<AreaTreeDTO> areaList) {
         this.areaList = areaList;
         return this;
      }

      @JsonProperty("children")
      public MonomerTreeDTO.MonomerTreeDTOBuilder children(final List<AreaTreeDTO> children) {
         this.children = children;
         return this;
      }

      public MonomerTreeDTO build() {
         return new MonomerTreeDTO(this.id, this.name, this.areaList, this.children);
      }

      @Override
      public String toString() {
         return "MonomerTreeDTO.MonomerTreeDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", areaList="
            + this.areaList
            + ", children="
            + this.children
            + ")";
      }
   }
}
