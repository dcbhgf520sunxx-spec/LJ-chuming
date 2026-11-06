package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingExtraSalary对象", description = "编外工资单价设置 ")
@Entity
@TableName("mes_building_extra_salary")
@Table(name = "mes_building_extra_salary")
public class MesBuildingExtraSalary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "wage", value = "工价设置", notes = "工价设置")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   @TableField("wage")
   @Column(name = "wage", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '工价设置'", nullable = false)
   private BigDecimal wage;
   @ApiModelProperty(name = "userId", value = "修改人", notes = "修改人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '修改人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "auditUserId", value = "审核人", notes = "审核人")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default '1' COMMENT '审核状态'", nullable = false)
   private Integer auditStatus;
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
   @ApiModelProperty(name = "boolUsedEnum")
   @JsonProperty("boolUsedEnum")
   @JSONField(name = "boolUsedEnum")
   @TableField("bool_used_enum")
   @Column(name = "bool_used_enum", columnDefinition = "bit(1)  COMMENT ''", nullable = true)
   private Boolean boolUsedEnum;

   public static MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder builder() {
      return new MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder();
   }

   public MesBuildingExtraSalary() {
   }

   public MesBuildingExtraSalary(
      final Long id,
      final Long teamId,
      final BigDecimal wage,
      final Long userId,
      final Long auditUserId,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final Long productId,
      final Integer productType,
      final Boolean boolUsedEnum
   ) {
      this.id = id;
      this.teamId = teamId;
      this.wage = wage;
      this.userId = userId;
      this.auditUserId = auditUserId;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.productId = productId;
      this.productType = productType;
      this.boolUsedEnum = boolUsedEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolUsedEnum() {
      return this.boolUsedEnum;
   }

   @JsonProperty("id")
   public MesBuildingExtraSalary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingExtraSalary setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("wage")
   public MesBuildingExtraSalary setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingExtraSalary setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("auditUserId")
   public MesBuildingExtraSalary setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditTime")
   public MesBuildingExtraSalary setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("auditStatus")
   public MesBuildingExtraSalary setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingExtraSalary setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingExtraSalary setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolUsedEnum")
   public MesBuildingExtraSalary setBoolUsedEnum(final Boolean boolUsedEnum) {
      this.boolUsedEnum = boolUsedEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingExtraSalary(id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ", wage="
         + this.getWage()
         + ", userId="
         + this.getUserId()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", boolUsedEnum="
         + this.getBoolUsedEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingExtraSalary)) {
         return false;
      }

      MesBuildingExtraSalary other = (MesBuildingExtraSalary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$auditUserId = this.getAuditUserId();
               Object other$auditUserId = other.getAuditUserId();
               if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                  Object this$auditStatus = this.getAuditStatus();
                  Object other$auditStatus = other.getAuditStatus();
                  if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$boolUsedEnum = this.getBoolUsedEnum();
                           Object other$boolUsedEnum = other.getBoolUsedEnum();
                           if (this$boolUsedEnum == null ? other$boolUsedEnum == null : this$boolUsedEnum.equals(other$boolUsedEnum)) {
                              Object this$wage = this.getWage();
                              Object other$wage = other.getWage();
                              if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                 Object this$auditTime = this.getAuditTime();
                                 Object other$auditTime = other.getAuditTime();
                                 return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof MesBuildingExtraSalary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolUsedEnum = this.getBoolUsedEnum();
      result = result * 59 + ($boolUsedEnum == null ? 43 : $boolUsedEnum.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class MesBuildingExtraSalaryBuilder {
      private Long id;
      private Long teamId;
      private BigDecimal wage;
      private Long userId;
      private Long auditUserId;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private Long productId;
      private Integer productType;
      private Boolean boolUsedEnum;

      MesBuildingExtraSalaryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("wage")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("auditUserId")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditTime")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("auditStatus")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolUsedEnum")
      public MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder boolUsedEnum(final Boolean boolUsedEnum) {
         this.boolUsedEnum = boolUsedEnum;
         return this;
      }

      public MesBuildingExtraSalary build() {
         return new MesBuildingExtraSalary(
            this.id,
            this.teamId,
            this.wage,
            this.userId,
            this.auditUserId,
            this.auditTime,
            this.auditStatus,
            this.productId,
            this.productType,
            this.boolUsedEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingExtraSalary.MesBuildingExtraSalaryBuilder(id="
            + this.id
            + ", teamId="
            + this.teamId
            + ", wage="
            + this.wage
            + ", userId="
            + this.userId
            + ", auditUserId="
            + this.auditUserId
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", boolUsedEnum="
            + this.boolUsedEnum
            + ")";
      }
   }
}
