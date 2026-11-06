package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingAssembleTypesettingDTOParam", description = "套料保存DTO")
public class MesBuildingAssembleTypesettingDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "typesettingTypeEnum", value = "套料方式")
   @JsonProperty("typesettingTypeEnum")
   @JSONField(name = "typesettingTypeEnum")
   private Integer typesettingTypeEnum;
   @ApiModelProperty(name = "kerfLength", value = "预留割缝长度（mm）")
   @JsonProperty("kerfLength")
   @JSONField(name = "kerfLength")
   private BigDecimal kerfLength;
   @ApiModelProperty(name = "length", value = "母材长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "assembleSettingList", value = "套料型材信息）")
   @JsonProperty("assembleSettingList")
   @JSONField(name = "assembleSettingList")
   private List<MesBuildingAssembleSettingDTOParam> assembleSettingList;

   public static MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder builder() {
      return new MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder();
   }

   public MesBuildingAssembleTypesettingDTOParam() {
   }

   public MesBuildingAssembleTypesettingDTOParam(
      final Long projectId,
      final Long monomerId,
      final Integer typesettingTypeEnum,
      final BigDecimal kerfLength,
      final BigDecimal length,
      final Integer productionLineTypeEnum,
      final List<MesBuildingAssembleSettingDTOParam> assembleSettingList
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.typesettingTypeEnum = typesettingTypeEnum;
      this.kerfLength = kerfLength;
      this.length = length;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.assembleSettingList = assembleSettingList;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getTypesettingTypeEnum() {
      return this.typesettingTypeEnum;
   }

   public BigDecimal getKerfLength() {
      return this.kerfLength;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<MesBuildingAssembleSettingDTOParam> getAssembleSettingList() {
      return this.assembleSettingList;
   }

   @JsonProperty("projectId")
   public MesBuildingAssembleTypesettingDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingAssembleTypesettingDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("typesettingTypeEnum")
   public MesBuildingAssembleTypesettingDTOParam setTypesettingTypeEnum(final Integer typesettingTypeEnum) {
      this.typesettingTypeEnum = typesettingTypeEnum;
      return this;
   }

   @JsonProperty("kerfLength")
   public MesBuildingAssembleTypesettingDTOParam setKerfLength(final BigDecimal kerfLength) {
      this.kerfLength = kerfLength;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingAssembleTypesettingDTOParam setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingAssembleTypesettingDTOParam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("assembleSettingList")
   public MesBuildingAssembleTypesettingDTOParam setAssembleSettingList(final List<MesBuildingAssembleSettingDTOParam> assembleSettingList) {
      this.assembleSettingList = assembleSettingList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleTypesettingDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", typesettingTypeEnum="
         + this.getTypesettingTypeEnum()
         + ", kerfLength="
         + this.getKerfLength()
         + ", length="
         + this.getLength()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", assembleSettingList="
         + this.getAssembleSettingList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleTypesettingDTOParam)) {
         return false;
      }

      MesBuildingAssembleTypesettingDTOParam other = (MesBuildingAssembleTypesettingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$typesettingTypeEnum = this.getTypesettingTypeEnum();
            Object other$typesettingTypeEnum = other.getTypesettingTypeEnum();
            if (this$typesettingTypeEnum == null ? other$typesettingTypeEnum == null : this$typesettingTypeEnum.equals(other$typesettingTypeEnum)) {
               Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
               Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
               if (this$productionLineTypeEnum == null
                  ? other$productionLineTypeEnum == null
                  : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                  Object this$kerfLength = this.getKerfLength();
                  Object other$kerfLength = other.getKerfLength();
                  if (this$kerfLength == null ? other$kerfLength == null : this$kerfLength.equals(other$kerfLength)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$assembleSettingList = this.getAssembleSettingList();
                        Object other$assembleSettingList = other.getAssembleSettingList();
                        return this$assembleSettingList == null
                           ? other$assembleSettingList == null
                           : this$assembleSettingList.equals(other$assembleSettingList);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAssembleTypesettingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $typesettingTypeEnum = this.getTypesettingTypeEnum();
      result = result * 59 + ($typesettingTypeEnum == null ? 43 : $typesettingTypeEnum.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $kerfLength = this.getKerfLength();
      result = result * 59 + ($kerfLength == null ? 43 : $kerfLength.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $assembleSettingList = this.getAssembleSettingList();
      return result * 59 + ($assembleSettingList == null ? 43 : $assembleSettingList.hashCode());
   }

   public static class MesBuildingAssembleTypesettingDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer typesettingTypeEnum;
      private BigDecimal kerfLength;
      private BigDecimal length;
      private Integer productionLineTypeEnum;
      private List<MesBuildingAssembleSettingDTOParam> assembleSettingList;

      MesBuildingAssembleTypesettingDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("typesettingTypeEnum")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder typesettingTypeEnum(final Integer typesettingTypeEnum) {
         this.typesettingTypeEnum = typesettingTypeEnum;
         return this;
      }

      @JsonProperty("kerfLength")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder kerfLength(final BigDecimal kerfLength) {
         this.kerfLength = kerfLength;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("assembleSettingList")
      public MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder assembleSettingList(
         final List<MesBuildingAssembleSettingDTOParam> assembleSettingList
      ) {
         this.assembleSettingList = assembleSettingList;
         return this;
      }

      public MesBuildingAssembleTypesettingDTOParam build() {
         return new MesBuildingAssembleTypesettingDTOParam(
            this.projectId, this.monomerId, this.typesettingTypeEnum, this.kerfLength, this.length, this.productionLineTypeEnum, this.assembleSettingList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleTypesettingDTOParam.MesBuildingAssembleTypesettingDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", typesettingTypeEnum="
            + this.typesettingTypeEnum
            + ", kerfLength="
            + this.kerfLength
            + ", length="
            + this.length
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", assembleSettingList="
            + this.assembleSettingList
            + ")";
      }
   }
}
