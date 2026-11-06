package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.get;

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
   @ApiModelProperty(name = "workShopType", notes = "1 建刚 2桥梁 4围护", value = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("workShopType")
   @JSONField(name = "workShopType")
   private Integer workShopType;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @JsonProperty("mesProductEnum")
   @JSONField(name = "mesProductEnum")
   private Integer mesProductEnum;

   public static FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder builder() {
      return new FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder();
   }

   public FactoryProductionLineVORequest(
      final Long id, final String name, final String shortName, final Boolean boolEnabledEnum, final Integer workShopType, final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.boolEnabledEnum = boolEnabledEnum;
      this.workShopType = workShopType;
      this.mesProductEnum = mesProductEnum;
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

   public Integer getWorkShopType() {
      return this.workShopType;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
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

   @JsonProperty("workShopType")
   public FactoryProductionLineVORequest setWorkShopType(final Integer workShopType) {
      this.workShopType = workShopType;
      return this;
   }

   @JsonProperty("mesProductEnum")
   public FactoryProductionLineVORequest setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
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
         + ", workShopType="
         + this.getWorkShopType()
         + ", mesProductEnum="
         + this.getMesProductEnum()
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
            Object this$workShopType = this.getWorkShopType();
            Object other$workShopType = other.getWorkShopType();
            if (this$workShopType == null ? other$workShopType == null : this$workShopType.equals(other$workShopType)) {
               Object this$mesProductEnum = this.getMesProductEnum();
               Object other$mesProductEnum = other.getMesProductEnum();
               if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
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
      Object $workShopType = this.getWorkShopType();
      result = result * 59 + ($workShopType == null ? 43 : $workShopType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
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
      private Integer workShopType;
      private Integer mesProductEnum;

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

      @JsonProperty("workShopType")
      public FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder workShopType(final Integer workShopType) {
         this.workShopType = workShopType;
         return this;
      }

      @JsonProperty("mesProductEnum")
      public FactoryProductionLineVORequest.FactoryProductionLineVORequestBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public FactoryProductionLineVORequest build() {
         return new FactoryProductionLineVORequest(this.id, this.name, this.shortName, this.boolEnabledEnum, this.workShopType, this.mesProductEnum);
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
            + ", workShopType="
            + this.workShopType
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
