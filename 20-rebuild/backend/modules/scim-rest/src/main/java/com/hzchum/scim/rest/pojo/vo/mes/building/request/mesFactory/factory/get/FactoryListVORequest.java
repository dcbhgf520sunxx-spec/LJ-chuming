package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FactoryListVORequest", description = "工厂列表请求类")
public class FactoryListVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "branchCompanyId", notes = "分支机构id", value = "分支机构id")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   private Long branchCompanyId;
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

   public static FactoryListVORequest.FactoryListVORequestBuilder builder() {
      return new FactoryListVORequest.FactoryListVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
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
   public FactoryListVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public FactoryListVORequest setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("name")
   public FactoryListVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public FactoryListVORequest setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public FactoryListVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @Override
   public String toString() {
      return "FactoryListVORequest(id="
         + this.getId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
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

      if (!(o instanceof FactoryListVORequest)) {
         return false;
      }

      FactoryListVORequest other = (FactoryListVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FactoryListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      return result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
   }

   public FactoryListVORequest(final Long id, final Long branchCompanyId, final String name, final String shortName, final Boolean boolEnabledEnum) {
      this.id = id;
      this.branchCompanyId = branchCompanyId;
      this.name = name;
      this.shortName = shortName;
      this.boolEnabledEnum = boolEnabledEnum;
   }

   public FactoryListVORequest() {
   }

   public static class FactoryListVORequestBuilder {
      private Long id;
      private Long branchCompanyId;
      private String name;
      private String shortName;
      private Boolean boolEnabledEnum;

      FactoryListVORequestBuilder() {
      }

      @JsonProperty("id")
      public FactoryListVORequest.FactoryListVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public FactoryListVORequest.FactoryListVORequestBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("name")
      public FactoryListVORequest.FactoryListVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public FactoryListVORequest.FactoryListVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public FactoryListVORequest.FactoryListVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      public FactoryListVORequest build() {
         return new FactoryListVORequest(this.id, this.branchCompanyId, this.name, this.shortName, this.boolEnabledEnum);
      }

      @Override
      public String toString() {
         return "FactoryListVORequest.FactoryListVORequestBuilder(id="
            + this.id
            + ", branchCompanyId="
            + this.branchCompanyId
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
