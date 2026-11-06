package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureProductProcessDOParam对象", description = "")
public class MesEnclosureProductProcessDTO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "medEnclosureProductProcessLinkList", notes = "工序")
   @JsonProperty("medEnclosureProductProcessLinkList")
   @JSONField(name = "medEnclosureProductProcessLinkList")
   @Valid
   private List<MesEnclosureProductProcessLinkDTO> medEnclosureProductProcessLinkList;

   public static MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder builder() {
      return new MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder();
   }

   public MesEnclosureProductProcessDTO() {
   }

   public MesEnclosureProductProcessDTO(
      final Long id,
      final String name,
      final String alias,
      final Integer productType,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final Long userId,
      final List<MesEnclosureProductProcessLinkDTO> medEnclosureProductProcessLinkList
   ) {
      this.id = id;
      this.name = name;
      this.alias = alias;
      this.productType = productType;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.userId = userId;
      this.medEnclosureProductProcessLinkList = medEnclosureProductProcessLinkList;
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

   public List<MesEnclosureProductProcessLinkDTO> getMedEnclosureProductProcessLinkList() {
      return this.medEnclosureProductProcessLinkList;
   }

   @JsonProperty("id")
   public MesEnclosureProductProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureProductProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("alias")
   public MesEnclosureProductProcessDTO setAlias(final String alias) {
      this.alias = alias;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureProductProcessDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesEnclosureProductProcessDTO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesEnclosureProductProcessDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProductProcessDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("medEnclosureProductProcessLinkList")
   public MesEnclosureProductProcessDTO setMedEnclosureProductProcessLinkList(final List<MesEnclosureProductProcessLinkDTO> medEnclosureProductProcessLinkList) {
      this.medEnclosureProductProcessLinkList = medEnclosureProductProcessLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductProcessDTO(id="
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
         + ", medEnclosureProductProcessLinkList="
         + this.getMedEnclosureProductProcessLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductProcessDTO)) {
         return false;
      }

      MesEnclosureProductProcessDTO other = (MesEnclosureProductProcessDTO)o;
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
                           Object this$medEnclosureProductProcessLinkList = this.getMedEnclosureProductProcessLinkList();
                           Object other$medEnclosureProductProcessLinkList = other.getMedEnclosureProductProcessLinkList();
                           return this$medEnclosureProductProcessLinkList == null
                              ? other$medEnclosureProductProcessLinkList == null
                              : this$medEnclosureProductProcessLinkList.equals(other$medEnclosureProductProcessLinkList);
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
      return other instanceof MesEnclosureProductProcessDTO;
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
      Object $medEnclosureProductProcessLinkList = this.getMedEnclosureProductProcessLinkList();
      return result * 59 + ($medEnclosureProductProcessLinkList == null ? 43 : $medEnclosureProductProcessLinkList.hashCode());
   }

   public static class MesEnclosureProductProcessDTOBuilder {
      private Long id;
      private String name;
      private String alias;
      private Integer productType;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private Long userId;
      private List<MesEnclosureProductProcessLinkDTO> medEnclosureProductProcessLinkList;

      MesEnclosureProductProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("alias")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder alias(final String alias) {
         this.alias = alias;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("medEnclosureProductProcessLinkList")
      public MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder medEnclosureProductProcessLinkList(
         final List<MesEnclosureProductProcessLinkDTO> medEnclosureProductProcessLinkList
      ) {
         this.medEnclosureProductProcessLinkList = medEnclosureProductProcessLinkList;
         return this;
      }

      public MesEnclosureProductProcessDTO build() {
         return new MesEnclosureProductProcessDTO(
            this.id, this.name, this.alias, this.productType, this.boolEnabledEnum, this.sort, this.userId, this.medEnclosureProductProcessLinkList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProductProcessDTO.MesEnclosureProductProcessDTOBuilder(id="
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
            + ", medEnclosureProductProcessLinkList="
            + this.medEnclosureProductProcessLinkList
            + ")";
      }
   }
}
