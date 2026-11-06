package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesEnclosureMachinePartDOParam", description = "")
public class MesEnclosureMachinePartDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "boolStatusEnum")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "planId")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "grossWeight")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "length")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "netWeight")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "quantity")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "remark")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "serialNumber")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "totalGrossWeight")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "type")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "usedQuantity", value = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Long usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Long producedQuantity;
   @ApiModelProperty(name = "steelSpec", notes = "板厚或规格")
   @JsonProperty("steelSpec")
   @JSONField(name = "steelSpec")
   private String steelSpec;
   @ApiModelProperty(name = "steelId", notes = "版型id")
   @JsonProperty("steelId")
   @JSONField(name = "steelId")
   private Integer steelId;
   @ApiModelProperty(name = "planIds")
   @JsonProperty("planIds")
   @JSONField(name = "planIds")
   private List<Long> planIds;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "statusType", notes = "1:未排产,2:未排产完成,4:已排产完成")
   @JsonProperty("statusType")
   @JSONField(name = "statusType")
   private Integer statusType;

   public static MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder builder() {
      return new MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder();
   }

   public MesEnclosureMachinePartDOParam() {
   }

   public MesEnclosureMachinePartDOParam(
      final Long id,
      final Boolean boolStatusEnum,
      final Long planId,
      final BigDecimal grossWeight,
      final BigDecimal length,
      final String material,
      final Long monomerId,
      final BigDecimal netWeight,
      final Long projectId,
      final Integer quantity,
      final String remark,
      final String serialNumber,
      final String specification,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Integer type,
      final Long usedQuantity,
      final Long producedQuantity,
      final String steelSpec,
      final Integer steelId,
      final List<Long> planIds,
      final Boolean boolAbnormalEnum,
      final Integer statusType
   ) {
      this.id = id;
      this.boolStatusEnum = boolStatusEnum;
      this.planId = planId;
      this.grossWeight = grossWeight;
      this.length = length;
      this.material = material;
      this.monomerId = monomerId;
      this.netWeight = netWeight;
      this.projectId = projectId;
      this.quantity = quantity;
      this.remark = remark;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.type = type;
      this.usedQuantity = usedQuantity;
      this.producedQuantity = producedQuantity;
      this.steelSpec = steelSpec;
      this.steelId = steelId;
      this.planIds = planIds;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.statusType = statusType;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getUsedQuantity() {
      return this.usedQuantity;
   }

   public Long getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getSteelId() {
      return this.steelId;
   }

   public List<Long> getPlanIds() {
      return this.planIds;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public Integer getStatusType() {
      return this.statusType;
   }

   @JsonProperty("id")
   public MesEnclosureMachinePartDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public MesEnclosureMachinePartDOParam setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureMachinePartDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureMachinePartDOParam setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureMachinePartDOParam setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureMachinePartDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureMachinePartDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureMachinePartDOParam setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureMachinePartDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureMachinePartDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureMachinePartDOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureMachinePartDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureMachinePartDOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureMachinePartDOParam setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureMachinePartDOParam setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureMachinePartDOParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("usedQuantity")
   public MesEnclosureMachinePartDOParam setUsedQuantity(final Long usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesEnclosureMachinePartDOParam setProducedQuantity(final Long producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("steelSpec")
   public MesEnclosureMachinePartDOParam setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("steelId")
   public MesEnclosureMachinePartDOParam setSteelId(final Integer steelId) {
      this.steelId = steelId;
      return this;
   }

   @JsonProperty("planIds")
   public MesEnclosureMachinePartDOParam setPlanIds(final List<Long> planIds) {
      this.planIds = planIds;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MesEnclosureMachinePartDOParam setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("statusType")
   public MesEnclosureMachinePartDOParam setStatusType(final Integer statusType) {
      this.statusType = statusType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartDOParam(id="
         + this.getId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", planId="
         + this.getPlanId()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", monomerId="
         + this.getMonomerId()
         + ", netWeight="
         + this.getNetWeight()
         + ", projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", type="
         + this.getType()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", steelId="
         + this.getSteelId()
         + ", planIds="
         + this.getPlanIds()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", statusType="
         + this.getStatusType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartDOParam)) {
         return false;
      }

      MesEnclosureMachinePartDOParam other = (MesEnclosureMachinePartDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolStatusEnum = this.getBoolStatusEnum();
         Object other$boolStatusEnum = other.getBoolStatusEnum();
         if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$usedQuantity = this.getUsedQuantity();
                           Object other$usedQuantity = other.getUsedQuantity();
                           if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                              Object this$producedQuantity = this.getProducedQuantity();
                              Object other$producedQuantity = other.getProducedQuantity();
                              if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                 Object this$steelId = this.getSteelId();
                                 Object other$steelId = other.getSteelId();
                                 if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                    Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                    Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                    if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                       Object this$statusType = this.getStatusType();
                                       Object other$statusType = other.getStatusType();
                                       if (this$statusType == null ? other$statusType == null : this$statusType.equals(other$statusType)) {
                                          Object this$grossWeight = this.getGrossWeight();
                                          Object other$grossWeight = other.getGrossWeight();
                                          if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                             Object this$length = this.getLength();
                                             Object other$length = other.getLength();
                                             if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$netWeight = this.getNetWeight();
                                                   Object other$netWeight = other.getNetWeight();
                                                   if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                               Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                               if (this$totalGrossWeight == null
                                                                  ? other$totalGrossWeight == null
                                                                  : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                  Object this$totalNetWeight = this.getTotalNetWeight();
                                                                  Object other$totalNetWeight = other.getTotalNetWeight();
                                                                  if (this$totalNetWeight == null
                                                                     ? other$totalNetWeight == null
                                                                     : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                     Object this$steelSpec = this.getSteelSpec();
                                                                     Object other$steelSpec = other.getSteelSpec();
                                                                     if (this$steelSpec == null
                                                                        ? other$steelSpec == null
                                                                        : this$steelSpec.equals(other$steelSpec)) {
                                                                        Object this$planIds = this.getPlanIds();
                                                                        Object other$planIds = other.getPlanIds();
                                                                        return this$planIds == null
                                                                           ? other$planIds == null
                                                                           : this$planIds.equals(other$planIds);
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
      return other instanceof MesEnclosureMachinePartDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $statusType = this.getStatusType();
      result = result * 59 + ($statusType == null ? 43 : $statusType.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $planIds = this.getPlanIds();
      return result * 59 + ($planIds == null ? 43 : $planIds.hashCode());
   }

   public static class MesEnclosureMachinePartDOParamBuilder {
      private Long id;
      private Boolean boolStatusEnum;
      private Long planId;
      private BigDecimal grossWeight;
      private BigDecimal length;
      private String material;
      private Long monomerId;
      private BigDecimal netWeight;
      private Long projectId;
      private Integer quantity;
      private String remark;
      private String serialNumber;
      private String specification;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Integer type;
      private Long usedQuantity;
      private Long producedQuantity;
      private String steelSpec;
      private Integer steelId;
      private List<Long> planIds;
      private Boolean boolAbnormalEnum;
      private Integer statusType;

      MesEnclosureMachinePartDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("usedQuantity")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder usedQuantity(final Long usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder producedQuantity(final Long producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("steelSpec")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("steelId")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder steelId(final Integer steelId) {
         this.steelId = steelId;
         return this;
      }

      @JsonProperty("planIds")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder planIds(final List<Long> planIds) {
         this.planIds = planIds;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("statusType")
      public MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder statusType(final Integer statusType) {
         this.statusType = statusType;
         return this;
      }

      public MesEnclosureMachinePartDOParam build() {
         return new MesEnclosureMachinePartDOParam(
            this.id,
            this.boolStatusEnum,
            this.planId,
            this.grossWeight,
            this.length,
            this.material,
            this.monomerId,
            this.netWeight,
            this.projectId,
            this.quantity,
            this.remark,
            this.serialNumber,
            this.specification,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.type,
            this.usedQuantity,
            this.producedQuantity,
            this.steelSpec,
            this.steelId,
            this.planIds,
            this.boolAbnormalEnum,
            this.statusType
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartDOParam.MesEnclosureMachinePartDOParamBuilder(id="
            + this.id
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", planId="
            + this.planId
            + ", grossWeight="
            + this.grossWeight
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", monomerId="
            + this.monomerId
            + ", netWeight="
            + this.netWeight
            + ", projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", type="
            + this.type
            + ", usedQuantity="
            + this.usedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", steelSpec="
            + this.steelSpec
            + ", steelId="
            + this.steelId
            + ", planIds="
            + this.planIds
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", statusType="
            + this.statusType
            + ")";
      }
   }
}
