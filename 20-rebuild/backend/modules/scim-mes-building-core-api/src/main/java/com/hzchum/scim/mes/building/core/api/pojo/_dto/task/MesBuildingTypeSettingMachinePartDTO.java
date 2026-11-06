package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingTypeSettingMachinePartDTO", description = "母件拆板零件详细信息 ")
public class MesBuildingTypeSettingMachinePartDTO {
   @ApiModelProperty(name = "id", value = "零件")
   private Long id;
   @ApiModelProperty(name = "typeSettingId", value = "母件id")
   private Long typeSettingId;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "type", value = "类型 1剪板2数控")
   private Integer type;
   @ApiModelProperty(name = "path", value = "路径")
   private String path;
   @ApiModelProperty(name = "ossRelativePath", value = "相对路径")
   private String ossRelativePath;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   public BigDecimal width;
   @ApiModelProperty("钢材厚度/规格")
   private String steelSpec;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;

   public static MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder builder() {
      return new MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder();
   }

   public MesBuildingTypeSettingMachinePartDTO(
      final Long id,
      final Long typeSettingId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String serialNumber,
      final Integer type,
      final String path,
      final String ossRelativePath,
      final BigDecimal length,
      final BigDecimal width,
      final String steelSpec,
      final String specPrefix,
      final String specification,
      final Integer productionLineTypeEnum
   ) {
      this.id = id;
      this.typeSettingId = typeSettingId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.type = type;
      this.path = path;
      this.ossRelativePath = ossRelativePath;
      this.length = length;
      this.width = width;
      this.steelSpec = steelSpec;
      this.specPrefix = specPrefix;
      this.specification = specification;
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public MesBuildingTypeSettingMachinePartDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getTypeSettingId() {
      return this.typeSettingId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getType() {
      return this.type;
   }

   public String getPath() {
      return this.path;
   }

   public String getOssRelativePath() {
      return this.ossRelativePath;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public MesBuildingTypeSettingMachinePartDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setTypeSettingId(final Long typeSettingId) {
      this.typeSettingId = typeSettingId;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setPath(final String path) {
      this.path = path;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setOssRelativePath(final String ossRelativePath) {
      this.ossRelativePath = ossRelativePath;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public MesBuildingTypeSettingMachinePartDTO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTypeSettingMachinePartDTO(id="
         + this.getId()
         + ", typeSettingId="
         + this.getTypeSettingId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", type="
         + this.getType()
         + ", path="
         + this.getPath()
         + ", ossRelativePath="
         + this.getOssRelativePath()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", specification="
         + this.getSpecification()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTypeSettingMachinePartDTO)) {
         return false;
      }

      MesBuildingTypeSettingMachinePartDTO other = (MesBuildingTypeSettingMachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$typeSettingId = this.getTypeSettingId();
         Object other$typeSettingId = other.getTypeSettingId();
         if (this$typeSettingId == null ? other$typeSettingId == null : this$typeSettingId.equals(other$typeSettingId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                        Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                        if (this$productionLineTypeEnum == null
                           ? other$productionLineTypeEnum == null
                           : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$path = this.getPath();
                              Object other$path = other.getPath();
                              if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                 Object this$ossRelativePath = this.getOssRelativePath();
                                 Object other$ossRelativePath = other.getOssRelativePath();
                                 if (this$ossRelativePath == null ? other$ossRelativePath == null : this$ossRelativePath.equals(other$ossRelativePath)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$width = this.getWidth();
                                       Object other$width = other.getWidth();
                                       if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                          Object this$steelSpec = this.getSteelSpec();
                                          Object other$steelSpec = other.getSteelSpec();
                                          if (this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec)) {
                                             Object this$specPrefix = this.getSpecPrefix();
                                             Object other$specPrefix = other.getSpecPrefix();
                                             if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                return this$specification == null
                                                   ? other$specification == null
                                                   : this$specification.equals(other$specification);
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
      return other instanceof MesBuildingTypeSettingMachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $typeSettingId = this.getTypeSettingId();
      result = result * 59 + ($typeSettingId == null ? 43 : $typeSettingId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $ossRelativePath = this.getOssRelativePath();
      result = result * 59 + ($ossRelativePath == null ? 43 : $ossRelativePath.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   public static class MesBuildingTypeSettingMachinePartDTOBuilder {
      private Long id;
      private Long typeSettingId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String serialNumber;
      private Integer type;
      private String path;
      private String ossRelativePath;
      private BigDecimal length;
      private BigDecimal width;
      private String steelSpec;
      private String specPrefix;
      private String specification;
      private Integer productionLineTypeEnum;

      MesBuildingTypeSettingMachinePartDTOBuilder() {
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder typeSettingId(final Long typeSettingId) {
         this.typeSettingId = typeSettingId;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder ossRelativePath(final String ossRelativePath) {
         this.ossRelativePath = ossRelativePath;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public MesBuildingTypeSettingMachinePartDTO build() {
         return new MesBuildingTypeSettingMachinePartDTO(
            this.id,
            this.typeSettingId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.serialNumber,
            this.type,
            this.path,
            this.ossRelativePath,
            this.length,
            this.width,
            this.steelSpec,
            this.specPrefix,
            this.specification,
            this.productionLineTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTypeSettingMachinePartDTO.MesBuildingTypeSettingMachinePartDTOBuilder(id="
            + this.id
            + ", typeSettingId="
            + this.typeSettingId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", type="
            + this.type
            + ", path="
            + this.path
            + ", ossRelativePath="
            + this.ossRelativePath
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", steelSpec="
            + this.steelSpec
            + ", specPrefix="
            + this.specPrefix
            + ", specification="
            + this.specification
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }
}
