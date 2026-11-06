package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingCutConfigDTO", description = "切割配置DTO ")
public class MesBuildingCutConfigDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否套料", notes = "是否套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "cutTypeId")
   @JSONField(name = "cutTypeId")
   private Long cutTypeId;
   @ApiModelProperty(name = "name", value = "切割方式名称", notes = "切割方式名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "cutType", notes = "切割方式", value = "切割方式")
   @JsonProperty("cutType")
   @JSONField(name = "cutType")
   private Integer cutType;
   @ApiModelProperty(name = "cutTypeName", notes = "切割方式", value = "切割方式")
   @JsonProperty("cutTypeName")
   @JSONField(name = "cutTypeName")
   private String cutTypeName;
   @ApiModelProperty(name = "minThickness", value = "钢板厚度范围", notes = "钢板厚度范围")
   @JsonProperty("minThickness")
   @JSONField(name = "minThickness")
   private String minThickness;
   @ApiModelProperty(name = "maxThickness", value = "钢板厚度范围", notes = "钢板厚度范围")
   @JsonProperty("maxThickness")
   @JSONField(name = "maxThickness")
   private String maxThickness;
   @ApiModelProperty(name = "cuttingHolesJoint", value = "切孔联割半径范围", notes = "切孔联割半径范围")
   @JsonProperty("cuttingHolesJoint")
   @JSONField(name = "cuttingHolesJoint")
   private BigDecimal cuttingHolesJoint;
   @ApiModelProperty(name = "boolDrillHole", value = "是否板孔联割", notes = "是否板孔联割")
   @JsonProperty("boolDrillHole")
   @JSONField(name = "boolDrillHole")
   private Integer boolDrillHole;

   public static MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder builder() {
      return new MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder();
   }

   public MesBuildingCutConfigDTO() {
   }

   public MesBuildingCutConfigDTO(
      final Long id,
      final Boolean boolNestCutEnum,
      final Long cutTypeId,
      final String name,
      final Integer cutType,
      final String cutTypeName,
      final String minThickness,
      final String maxThickness,
      final BigDecimal cuttingHolesJoint,
      final Integer boolDrillHole
   ) {
      this.id = id;
      this.boolNestCutEnum = boolNestCutEnum;
      this.cutTypeId = cutTypeId;
      this.name = name;
      this.cutType = cutType;
      this.cutTypeName = cutTypeName;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
      this.cuttingHolesJoint = cuttingHolesJoint;
      this.boolDrillHole = boolDrillHole;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Long getCutTypeId() {
      return this.cutTypeId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCutType() {
      return this.cutType;
   }

   public String getCutTypeName() {
      return this.cutTypeName;
   }

   public String getMinThickness() {
      return this.minThickness;
   }

   public String getMaxThickness() {
      return this.maxThickness;
   }

   public BigDecimal getCuttingHolesJoint() {
      return this.cuttingHolesJoint;
   }

   public Integer getBoolDrillHole() {
      return this.boolDrillHole;
   }

   @JsonProperty("id")
   public MesBuildingCutConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingCutConfigDTO setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   public MesBuildingCutConfigDTO setCutTypeId(final Long cutTypeId) {
      this.cutTypeId = cutTypeId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingCutConfigDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("cutType")
   public MesBuildingCutConfigDTO setCutType(final Integer cutType) {
      this.cutType = cutType;
      return this;
   }

   @JsonProperty("cutTypeName")
   public MesBuildingCutConfigDTO setCutTypeName(final String cutTypeName) {
      this.cutTypeName = cutTypeName;
      return this;
   }

   @JsonProperty("minThickness")
   public MesBuildingCutConfigDTO setMinThickness(final String minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   @JsonProperty("maxThickness")
   public MesBuildingCutConfigDTO setMaxThickness(final String maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   @JsonProperty("cuttingHolesJoint")
   public MesBuildingCutConfigDTO setCuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
      this.cuttingHolesJoint = cuttingHolesJoint;
      return this;
   }

   @JsonProperty("boolDrillHole")
   public MesBuildingCutConfigDTO setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCutConfigDTO(id="
         + this.getId()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", cutTypeId="
         + this.getCutTypeId()
         + ", name="
         + this.getName()
         + ", cutType="
         + this.getCutType()
         + ", cutTypeName="
         + this.getCutTypeName()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", cuttingHolesJoint="
         + this.getCuttingHolesJoint()
         + ", boolDrillHole="
         + this.getBoolDrillHole()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCutConfigDTO)) {
         return false;
      }

      MesBuildingCutConfigDTO other = (MesBuildingCutConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolNestCutEnum = this.getBoolNestCutEnum();
         Object other$boolNestCutEnum = other.getBoolNestCutEnum();
         if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
            Object this$cutTypeId = this.getCutTypeId();
            Object other$cutTypeId = other.getCutTypeId();
            if (this$cutTypeId == null ? other$cutTypeId == null : this$cutTypeId.equals(other$cutTypeId)) {
               Object this$cutType = this.getCutType();
               Object other$cutType = other.getCutType();
               if (this$cutType == null ? other$cutType == null : this$cutType.equals(other$cutType)) {
                  Object this$boolDrillHole = this.getBoolDrillHole();
                  Object other$boolDrillHole = other.getBoolDrillHole();
                  if (this$boolDrillHole == null ? other$boolDrillHole == null : this$boolDrillHole.equals(other$boolDrillHole)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$cutTypeName = this.getCutTypeName();
                        Object other$cutTypeName = other.getCutTypeName();
                        if (this$cutTypeName == null ? other$cutTypeName == null : this$cutTypeName.equals(other$cutTypeName)) {
                           Object this$minThickness = this.getMinThickness();
                           Object other$minThickness = other.getMinThickness();
                           if (this$minThickness == null ? other$minThickness == null : this$minThickness.equals(other$minThickness)) {
                              Object this$maxThickness = this.getMaxThickness();
                              Object other$maxThickness = other.getMaxThickness();
                              if (this$maxThickness == null ? other$maxThickness == null : this$maxThickness.equals(other$maxThickness)) {
                                 Object this$cuttingHolesJoint = this.getCuttingHolesJoint();
                                 Object other$cuttingHolesJoint = other.getCuttingHolesJoint();
                                 return this$cuttingHolesJoint == null
                                    ? other$cuttingHolesJoint == null
                                    : this$cuttingHolesJoint.equals(other$cuttingHolesJoint);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCutConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $cutTypeId = this.getCutTypeId();
      result = result * 59 + ($cutTypeId == null ? 43 : $cutTypeId.hashCode());
      Object $cutType = this.getCutType();
      result = result * 59 + ($cutType == null ? 43 : $cutType.hashCode());
      Object $boolDrillHole = this.getBoolDrillHole();
      result = result * 59 + ($boolDrillHole == null ? 43 : $boolDrillHole.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $cutTypeName = this.getCutTypeName();
      result = result * 59 + ($cutTypeName == null ? 43 : $cutTypeName.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      result = result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
      Object $cuttingHolesJoint = this.getCuttingHolesJoint();
      return result * 59 + ($cuttingHolesJoint == null ? 43 : $cuttingHolesJoint.hashCode());
   }

   public static class MesBuildingCutConfigDTOBuilder {
      private Long id;
      private Boolean boolNestCutEnum;
      private Long cutTypeId;
      private String name;
      private Integer cutType;
      private String cutTypeName;
      private String minThickness;
      private String maxThickness;
      private BigDecimal cuttingHolesJoint;
      private Integer boolDrillHole;

      MesBuildingCutConfigDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder cutTypeId(final Long cutTypeId) {
         this.cutTypeId = cutTypeId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("cutType")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder cutType(final Integer cutType) {
         this.cutType = cutType;
         return this;
      }

      @JsonProperty("cutTypeName")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder cutTypeName(final String cutTypeName) {
         this.cutTypeName = cutTypeName;
         return this;
      }

      @JsonProperty("minThickness")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder minThickness(final String minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      @JsonProperty("maxThickness")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder maxThickness(final String maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      @JsonProperty("cuttingHolesJoint")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder cuttingHolesJoint(final BigDecimal cuttingHolesJoint) {
         this.cuttingHolesJoint = cuttingHolesJoint;
         return this;
      }

      @JsonProperty("boolDrillHole")
      public MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      public MesBuildingCutConfigDTO build() {
         return new MesBuildingCutConfigDTO(
            this.id,
            this.boolNestCutEnum,
            this.cutTypeId,
            this.name,
            this.cutType,
            this.cutTypeName,
            this.minThickness,
            this.maxThickness,
            this.cuttingHolesJoint,
            this.boolDrillHole
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCutConfigDTO.MesBuildingCutConfigDTOBuilder(id="
            + this.id
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", cutTypeId="
            + this.cutTypeId
            + ", name="
            + this.name
            + ", cutType="
            + this.cutType
            + ", cutTypeName="
            + this.cutTypeName
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", cuttingHolesJoint="
            + this.cuttingHolesJoint
            + ", boolDrillHole="
            + this.boolDrillHole
            + ")";
      }
   }
}
