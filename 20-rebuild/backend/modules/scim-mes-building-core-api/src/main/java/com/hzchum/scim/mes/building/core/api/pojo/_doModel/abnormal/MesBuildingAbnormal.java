package com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingAbnormal对象", description = "")
@Entity
@TableName("mes_building_abnormal")
@Table(name = "mes_building_abnormal")
public class MesBuildingAbnormal extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "oldQuantity", value = "原清单数量", notes = "原清单数量")
   @JsonProperty("oldQuantity")
   @JSONField(name = "oldQuantity")
   @TableField("old_quantity")
   @Column(name = "old_quantity", columnDefinition = "int(11)  COMMENT '原清单数量'", nullable = false)
   private Integer oldQuantity;
   @ApiModelProperty(name = "taskQuantity", value = "任务下发数", notes = "任务下发数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @TableField("task_quantity")
   @Column(name = "task_quantity", columnDefinition = "int(11)  COMMENT '任务下发数'", nullable = false)
   private Integer taskQuantity;
   @ApiModelProperty(name = "newQuantity", value = "变更后数量", notes = "变更后数量")
   @JsonProperty("newQuantity")
   @JSONField(name = "newQuantity")
   @TableField("new_quantity")
   @Column(name = "new_quantity", columnDefinition = "int(11)  COMMENT '变更后数量'", nullable = false)
   private Integer newQuantity;
   @ApiModelProperty(name = "changeType", value = "变更原因", notes = "变更原因")
   @JsonProperty("changeType")
   @JSONField(name = "changeType")
   @TableField("change_type")
   @Column(name = "change_type", columnDefinition = "varchar(20)  COMMENT '变更原因'", nullable = false)
   private String changeType;
   @ApiModelProperty(name = "userId", value = "变更人", notes = "变更人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '变更人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "status", value = "处理状态", notes = "处理状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '处理状态'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "type", value = "类型 [1 排产异常, 2 生产异常]", notes = "类型 [1 排产异常, 2 生产异常]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '类型 [1 排产异常, 2 生产异常]'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "price", value = "损失金额", notes = "损失金额")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '损失金额'", nullable = false)
   private BigDecimal price;
   @ApiModelProperty(name = "boolSurplusEnum", value = "是否进多余列表", notes = "是否进多余列表")
   @JsonProperty("boolSurplusEnum")
   @JSONField(name = "boolSurplusEnum")
   @TableField("bool_surplus_enum")
   @Column(name = "bool_surplus_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否进多余列表'", nullable = false)
   private Boolean boolSurplusEnum;
   @ApiModelProperty(name = "artifactId", value = "关联的构件id", notes = "关联的构件id")
   @JsonProperty("artifactId")
   @JSONField(name = "artifactId")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '关联的构件id'", nullable = true)
   private Long artifactId;
   @ApiModelProperty(name = "artifactSerialNumber", value = "关联的构件编号", notes = "关联的构件编号")
   @JsonProperty("artifactSerialNumber")
   @JSONField(name = "artifactSerialNumber")
   @TableField("artifact_serial_number")
   @Column(name = "artifact_serial_number", columnDefinition = "varchar(255)  COMMENT '关联的构件编号'", nullable = true)
   private String artifactSerialNumber;
   @ApiModelProperty(name = "assembleId", value = "关联的组立id", notes = "关联的组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   @TableField("assemble_id")
   @Column(name = "assemble_id", columnDefinition = "bigint(20)  COMMENT '关联的组立id'", nullable = true)
   private Long assembleId;
   @ApiModelProperty(name = "assembleSerialNumber", value = "关联的组立编号", notes = "关联的组立编号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   @TableField("assemble_serial_number")
   @Column(name = "assemble_serial_number", columnDefinition = "varchar(255)  COMMENT '关联的组立编号'", nullable = true)
   private String assembleSerialNumber;
   @ApiModelProperty(name = "inProductionQuantity", value = "进入生产数量", notes = "进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   @TableField("in_production_quantity")
   @Column(name = "in_production_quantity", columnDefinition = "int(11)  COMMENT '进入生产数量'", nullable = true)
   private Integer inProductionQuantity;

   public static MesBuildingAbnormal.MesBuildingAbnormalBuilder builder() {
      return new MesBuildingAbnormal.MesBuildingAbnormalBuilder();
   }

   public MesBuildingAbnormal() {
   }

   public MesBuildingAbnormal(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long productId,
      final Integer productType,
      final Integer oldQuantity,
      final Integer taskQuantity,
      final Integer newQuantity,
      final String changeType,
      final Long userId,
      final Integer status,
      final Integer type,
      final BigDecimal price,
      final Boolean boolSurplusEnum,
      final Long artifactId,
      final String artifactSerialNumber,
      final Long assembleId,
      final String assembleSerialNumber,
      final Integer inProductionQuantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productId = productId;
      this.productType = productType;
      this.oldQuantity = oldQuantity;
      this.taskQuantity = taskQuantity;
      this.newQuantity = newQuantity;
      this.changeType = changeType;
      this.userId = userId;
      this.status = status;
      this.type = type;
      this.price = price;
      this.boolSurplusEnum = boolSurplusEnum;
      this.artifactId = artifactId;
      this.artifactSerialNumber = artifactSerialNumber;
      this.assembleId = assembleId;
      this.assembleSerialNumber = assembleSerialNumber;
      this.inProductionQuantity = inProductionQuantity;
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

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public String getChangeType() {
      return this.changeType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getBoolSurplusEnum() {
      return this.boolSurplusEnum;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   @JsonProperty("id")
   public MesBuildingAbnormal setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingAbnormal setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingAbnormal setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingAbnormal setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAbnormal setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingAbnormal setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("oldQuantity")
   public MesBuildingAbnormal setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingAbnormal setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("newQuantity")
   public MesBuildingAbnormal setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
      return this;
   }

   @JsonProperty("changeType")
   public MesBuildingAbnormal setChangeType(final String changeType) {
      this.changeType = changeType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingAbnormal setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingAbnormal setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingAbnormal setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingAbnormal setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("boolSurplusEnum")
   public MesBuildingAbnormal setBoolSurplusEnum(final Boolean boolSurplusEnum) {
      this.boolSurplusEnum = boolSurplusEnum;
      return this;
   }

   @JsonProperty("artifactId")
   public MesBuildingAbnormal setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @JsonProperty("artifactSerialNumber")
   public MesBuildingAbnormal setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
      return this;
   }

   @JsonProperty("assembleId")
   public MesBuildingAbnormal setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public MesBuildingAbnormal setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public MesBuildingAbnormal setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAbnormal(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", changeType="
         + this.getChangeType()
         + ", userId="
         + this.getUserId()
         + ", status="
         + this.getStatus()
         + ", type="
         + this.getType()
         + ", price="
         + this.getPrice()
         + ", boolSurplusEnum="
         + this.getBoolSurplusEnum()
         + ", artifactId="
         + this.getArtifactId()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAbnormal)) {
         return false;
      }

      MesBuildingAbnormal other = (MesBuildingAbnormal)o;
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
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$oldQuantity = this.getOldQuantity();
                        Object other$oldQuantity = other.getOldQuantity();
                        if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                           Object this$taskQuantity = this.getTaskQuantity();
                           Object other$taskQuantity = other.getTaskQuantity();
                           if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                              Object this$newQuantity = this.getNewQuantity();
                              Object other$newQuantity = other.getNewQuantity();
                              if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$status = this.getStatus();
                                    Object other$status = other.getStatus();
                                    if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                          Object this$boolSurplusEnum = this.getBoolSurplusEnum();
                                          Object other$boolSurplusEnum = other.getBoolSurplusEnum();
                                          if (this$boolSurplusEnum == null ? other$boolSurplusEnum == null : this$boolSurplusEnum.equals(other$boolSurplusEnum)
                                             )
                                           {
                                             Object this$artifactId = this.getArtifactId();
                                             Object other$artifactId = other.getArtifactId();
                                             if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                                                Object this$assembleId = this.getAssembleId();
                                                Object other$assembleId = other.getAssembleId();
                                                if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                                                   Object this$inProductionQuantity = this.getInProductionQuantity();
                                                   Object other$inProductionQuantity = other.getInProductionQuantity();
                                                   if (this$inProductionQuantity == null
                                                      ? other$inProductionQuantity == null
                                                      : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                                                      Object this$changeType = this.getChangeType();
                                                      Object other$changeType = other.getChangeType();
                                                      if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
                                                         Object this$price = this.getPrice();
                                                         Object other$price = other.getPrice();
                                                         if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                            Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                                            Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                                            if (this$artifactSerialNumber == null
                                                               ? other$artifactSerialNumber == null
                                                               : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                                                               Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                               Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                               return this$assembleSerialNumber == null
                                                                  ? other$assembleSerialNumber == null
                                                                  : this$assembleSerialNumber.equals(other$assembleSerialNumber);
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
      return other instanceof MesBuildingAbnormal;
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
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolSurplusEnum = this.getBoolSurplusEnum();
      result = result * 59 + ($boolSurplusEnum == null ? 43 : $boolSurplusEnum.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      return result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
   }

   public static class MesBuildingAbnormalBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long productId;
      private Integer productType;
      private Integer oldQuantity;
      private Integer taskQuantity;
      private Integer newQuantity;
      private String changeType;
      private Long userId;
      private Integer status;
      private Integer type;
      private BigDecimal price;
      private Boolean boolSurplusEnum;
      private Long artifactId;
      private String artifactSerialNumber;
      private Long assembleId;
      private String assembleSerialNumber;
      private Integer inProductionQuantity;

      MesBuildingAbnormalBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("oldQuantity")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("newQuantity")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder newQuantity(final Integer newQuantity) {
         this.newQuantity = newQuantity;
         return this;
      }

      @JsonProperty("changeType")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder changeType(final String changeType) {
         this.changeType = changeType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("boolSurplusEnum")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder boolSurplusEnum(final Boolean boolSurplusEnum) {
         this.boolSurplusEnum = boolSurplusEnum;
         return this;
      }

      @JsonProperty("artifactId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      @JsonProperty("artifactSerialNumber")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      @JsonProperty("assembleId")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public MesBuildingAbnormal.MesBuildingAbnormalBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      public MesBuildingAbnormal build() {
         return new MesBuildingAbnormal(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productId,
            this.productType,
            this.oldQuantity,
            this.taskQuantity,
            this.newQuantity,
            this.changeType,
            this.userId,
            this.status,
            this.type,
            this.price,
            this.boolSurplusEnum,
            this.artifactId,
            this.artifactSerialNumber,
            this.assembleId,
            this.assembleSerialNumber,
            this.inProductionQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAbnormal.MesBuildingAbnormalBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", oldQuantity="
            + this.oldQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", newQuantity="
            + this.newQuantity
            + ", changeType="
            + this.changeType
            + ", userId="
            + this.userId
            + ", status="
            + this.status
            + ", type="
            + this.type
            + ", price="
            + this.price
            + ", boolSurplusEnum="
            + this.boolSurplusEnum
            + ", artifactId="
            + this.artifactId
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", assembleId="
            + this.assembleId
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ")";
      }
   }
}
