package com.hzchum.scim.mes.building.core.api.pojo._do.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingAssembleDO对象", description = "组立信息  ")
public class MesBuildingAssembleDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", notes = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "totalSchedulingQuantity", notes = "排产总数量")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalTaskQuantity", notes = "已下发总数量")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "projectName", value = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;

   public static MesBuildingAssembleDO.MesBuildingAssembleDOBuilder builder() {
      return new MesBuildingAssembleDO.MesBuildingAssembleDOBuilder();
   }

   public MesBuildingAssembleDO() {
   }

   public MesBuildingAssembleDO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String serialNumber,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final String remark,
      final BigDecimal length,
      final Integer totalSchedulingQuantity,
      final Integer totalTaskQuantity,
      final String projectName,
      final String monomerName,
      final String areaName,
      final Boolean boolAbnormalEnum
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.remark = remark;
      this.length = length;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
      this.projectName = projectName;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.boolAbnormalEnum = boolAbnormalEnum;
   }

   public Long getId() {
      return this.id;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   @JsonProperty("id")
   public MesBuildingAssembleDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingAssembleDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingAssembleDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingAssembleDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAssembleDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssembleDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesBuildingAssembleDO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public MesBuildingAssembleDO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingAssembleDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingAssembleDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public MesBuildingAssembleDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalTaskQuantity")
   public MesBuildingAssembleDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingAssembleDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingAssembleDO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingAssembleDO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MesBuildingAssembleDO setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", remark="
         + this.getRemark()
         + ", length="
         + this.getLength()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleDO)) {
         return false;
      }

      MesBuildingAssembleDO other = (MesBuildingAssembleDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$producedQuantity = this.getProducedQuantity();
                     Object other$producedQuantity = other.getProducedQuantity();
                     if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                        Object this$usedQuantity = this.getUsedQuantity();
                        Object other$usedQuantity = other.getUsedQuantity();
                        if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                           Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                           Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                           if (this$totalSchedulingQuantity == null
                              ? other$totalSchedulingQuantity == null
                              : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                              Object this$totalTaskQuantity = this.getTotalTaskQuantity();
                              Object other$totalTaskQuantity = other.getTotalTaskQuantity();
                              if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
                                 Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                 Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                 if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$projectName = this.getProjectName();
                                             Object other$projectName = other.getProjectName();
                                             if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                Object this$monomerName = this.getMonomerName();
                                                Object other$monomerName = other.getMonomerName();
                                                if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                   Object this$areaName = this.getAreaName();
                                                   Object other$areaName = other.getAreaName();
                                                   return this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAssembleDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      return result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
   }

   public static class MesBuildingAssembleDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String serialNumber;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private String remark;
      private BigDecimal length;
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private String projectName;
      private String monomerName;
      private String areaName;
      private Boolean boolAbnormalEnum;

      MesBuildingAssembleDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MesBuildingAssembleDO.MesBuildingAssembleDOBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public MesBuildingAssembleDO build() {
         return new MesBuildingAssembleDO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.serialNumber,
            this.quantity,
            this.producedQuantity,
            this.usedQuantity,
            this.remark,
            this.length,
            this.totalSchedulingQuantity,
            this.totalTaskQuantity,
            this.projectName,
            this.monomerName,
            this.areaName,
            this.boolAbnormalEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleDO.MesBuildingAssembleDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", remark="
            + this.remark
            + ", length="
            + this.length
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", projectName="
            + this.projectName
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ")";
      }
   }
}
