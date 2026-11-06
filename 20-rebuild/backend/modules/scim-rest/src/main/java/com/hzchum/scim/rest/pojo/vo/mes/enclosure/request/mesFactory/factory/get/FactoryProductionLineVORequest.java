package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.factory.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FactoryProductionLineVORequest", description = "查询工厂下的车间请求类")
public class FactoryProductionLineVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工厂名称", value = "工厂名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "工厂简称", value = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "启用状态 [0 禁用, 1 启用]", value = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;

   public static FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder builder() {
      return new FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder();
   }

   public FactoryProductionLineVORequest(final Long id, final String name, final String shortName, final Boolean boolEnabledEnum) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.boolEnabledEnum = boolEnabledEnum;
   }

   public FactoryProductionLineVORequest() {
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

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   @JsonProperty("id")
   public FactoryProductionLineVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public FactoryProductionLineVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public FactoryProductionLineVORequest setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public FactoryProductionLineVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @Override
   public String toString() {
      return "FactoryProductionLineVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FactoryProductionLineVORequest)) {
         return false;
      }

      FactoryProductionLineVORequest other = (FactoryProductionLineVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolEnabledEnum = this.getBoolEnabledEnum();
         Object other$boolEnabledEnum = other.getBoolEnabledEnum();
         if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FactoryProductionLineVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      return result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
   }

   public static class FactoryProductionLineVORequestBuilder {
      private Long id;
      private String name;
      private String shortName;
      private Boolean boolEnabledEnum;

      FactoryProductionLineVORequestBuilder() {
      }

      @JsonProperty("id")
      public FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      public FactoryProductionLineVORequest build() {
         return new FactoryProductionLineVORequest(this.id, this.name, this.shortName, this.boolEnabledEnum);
      }

      @Override
      public String toString() {
         return "FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ")";
      }
   }
}
