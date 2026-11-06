package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingProductProcessDOParam对象", description = "")
public class MesBuildingProductProcessDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "总工序名")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "总工序名不能为空")
   private String name;
   @ApiModelProperty(name = "alias", notes = "别名")
   @JsonProperty("alias")
   @JSONField(name = "alias")
   private String alias;
   @ApiModelProperty(name = "productType", notes = "产品类型 [0 零件,1 构件,2 围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "medBuildingProductProcessLinkList", notes = "工序")
   @JsonProperty("medBuildingProductProcessLinkList")
   @JSONField(name = "medBuildingProductProcessLinkList")
   @Valid
   private List<MesBuildingProductProcessLinkDTO> medBuildingProductProcessLinkList;

   public static MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder builder() {
      return new MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder();
   }

   public MesBuildingProductProcessDTO() {
   }

   public MesBuildingProductProcessDTO(
      final Long id,
      final String name,
      final String alias,
      final Integer productType,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final Long userId,
      final List<MesBuildingProductProcessLinkDTO> medBuildingProductProcessLinkList
   ) {
      this.id = id;
      this.name = name;
      this.alias = alias;
      this.productType = productType;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.userId = userId;
      this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getAlias() {
      return this.alias;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getUserId() {
      return this.userId;
   }

   public List<MesBuildingProductProcessLinkDTO> getMedBuildingProductProcessLinkList() {
      return this.medBuildingProductProcessLinkList;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("alias")
   public MesBuildingProductProcessDTO setAlias(final String alias) {
      this.alias = alias;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcessDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingProductProcessDTO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProductProcessDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductProcessDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("medBuildingProductProcessLinkList")
   public MesBuildingProductProcessDTO setMedBuildingProductProcessLinkList(final List<MesBuildingProductProcessLinkDTO> medBuildingProductProcessLinkList) {
      this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", alias="
         + this.getAlias()
         + ", productType="
         + this.getProductType()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", sort="
         + this.getSort()
         + ", userId="
         + this.getUserId()
         + ", medBuildingProductProcessLinkList="
         + this.getMedBuildingProductProcessLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessDTO)) {
         return false;
      }

      MesBuildingProductProcessDTO other = (MesBuildingProductProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolEnabledEnum = this.getBoolEnabledEnum();
            Object other$boolEnabledEnum = other.getBoolEnabledEnum();
            if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$alias = this.getAlias();
                        Object other$alias = other.getAlias();
                        if (this$alias == null ? other$alias == null : this$alias.equals(other$alias)) {
                           Object this$medBuildingProductProcessLinkList = this.getMedBuildingProductProcessLinkList();
                           Object other$medBuildingProductProcessLinkList = other.getMedBuildingProductProcessLinkList();
                           return this$medBuildingProductProcessLinkList == null
                              ? other$medBuildingProductProcessLinkList == null
                              : this$medBuildingProductProcessLinkList.equals(other$medBuildingProductProcessLinkList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $alias = this.getAlias();
      result = result * 59 + ($alias == null ? 43 : $alias.hashCode());
      Object $medBuildingProductProcessLinkList = this.getMedBuildingProductProcessLinkList();
      return result * 59 + ($medBuildingProductProcessLinkList == null ? 43 : $medBuildingProductProcessLinkList.hashCode());
   }

   public static class MesBuildingProductProcessDTOBuilder {
      private Long id;
      private String name;
      private String alias;
      private Integer productType;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private Long userId;
      private List<MesBuildingProductProcessLinkDTO> medBuildingProductProcessLinkList;

      MesBuildingProductProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("alias")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder alias(final String alias) {
         this.alias = alias;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("medBuildingProductProcessLinkList")
      public MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder medBuildingProductProcessLinkList(
         final List<MesBuildingProductProcessLinkDTO> medBuildingProductProcessLinkList
      ) {
         this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
         return this;
      }

      public MesBuildingProductProcessDTO build() {
         return new MesBuildingProductProcessDTO(
            this.id, this.name, this.alias, this.productType, this.boolEnabledEnum, this.sort, this.userId, this.medBuildingProductProcessLinkList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessDTO.MesBuildingProductProcessDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", alias="
            + this.alias
            + ", productType="
            + this.productType
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", sort="
            + this.sort
            + ", userId="
            + this.userId
            + ", medBuildingProductProcessLinkList="
            + this.medBuildingProductProcessLinkList
            + ")";
      }
   }
}
