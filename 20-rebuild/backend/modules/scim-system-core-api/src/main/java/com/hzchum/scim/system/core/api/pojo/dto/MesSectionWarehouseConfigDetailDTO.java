package com.hzchum.scim.system.core.api.pojo.dto;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "类型截面库配置详情DTO类 ")
public class MesSectionWarehouseConfigDetailDTO {
   @ApiModelProperty(name = "id", value = "产品截面类型详情Id")
   private Long id;
   @ApiModelProperty(name = "name", value = "产品截面类型名称(产品名称/产品截面名称/截面类型名称)")
   private String name;
   @ApiModelProperty(name = "source", value = "数据来源 1.用户新增 2.系统自定义")
   private Integer source;

   public String getName() {
      return StrUtil.isNotBlank(this.name) ? StrUtil.trim(this.name) : this.name;
   }

   public static MesSectionWarehouseConfigDetailDTO.MesSectionWarehouseConfigDetailDTOBuilder builder() {
      return new MesSectionWarehouseConfigDetailDTO.MesSectionWarehouseConfigDetailDTOBuilder();
   }

   public MesSectionWarehouseConfigDetailDTO() {
   }

   public MesSectionWarehouseConfigDetailDTO(final Long id, final String name, final Integer source) {
      this.id = id;
      this.name = name;
      this.source = source;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getSource() {
      return this.source;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSource(final Integer source) {
      this.source = source;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSectionWarehouseConfigDetailDTO)) {
         return false;
      }

      MesSectionWarehouseConfigDetailDTO other = (MesSectionWarehouseConfigDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$source = this.getSource();
         Object other$source = other.getSource();
         if (this$source == null ? other$source == null : this$source.equals(other$source)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesSectionWarehouseConfigDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MesSectionWarehouseConfigDetailDTO(id=" + this.getId() + ", name=" + this.getName() + ", source=" + this.getSource() + ")";
   }

   public static class MesSectionWarehouseConfigDetailDTOBuilder {
      private Long id;
      private String name;
      private Integer source;

      MesSectionWarehouseConfigDetailDTOBuilder() {
      }

      public MesSectionWarehouseConfigDetailDTO.MesSectionWarehouseConfigDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSectionWarehouseConfigDetailDTO.MesSectionWarehouseConfigDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSectionWarehouseConfigDetailDTO.MesSectionWarehouseConfigDetailDTOBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      public MesSectionWarehouseConfigDetailDTO build() {
         return new MesSectionWarehouseConfigDetailDTO(this.id, this.name, this.source);
      }

      @Override
      public String toString() {
         return "MesSectionWarehouseConfigDetailDTO.MesSectionWarehouseConfigDetailDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", source="
            + this.source
            + ")";
      }
   }
}
