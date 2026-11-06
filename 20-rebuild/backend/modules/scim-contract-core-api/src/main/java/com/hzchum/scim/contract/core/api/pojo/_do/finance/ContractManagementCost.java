package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "ContractManagementCost对象", description = "管理费配置表")
@Entity
@TableName("contract_management_cost")
@Table(name = "contract_management_cost")
@org.hibernate.annotations.Table(appliesTo = "contract_management_cost", comment = "管理费配置表")
public class ContractManagementCost extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目类型", notes = "项目类型")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "int(11)  COMMENT '项目类型'", nullable = false)
   private Integer projectAttribute;
   @ApiModelProperty(name = "amountMax", value = "合同额(大)", notes = "合同额(大)")
   @TableField("amount_max")
   @Column(name = "amount_max", columnDefinition = "decimal(32,8)  COMMENT '合同额(大)'", nullable = true)
   private BigDecimal amountMax;
   @ApiModelProperty(name = "amountMin", value = "合同额(小)", notes = "合同额(小)")
   @TableField("amount_min")
   @Column(name = "amount_min", columnDefinition = "decimal(32,8)  COMMENT '合同额(小)'", nullable = true)
   private BigDecimal amountMin;
   @ApiModelProperty(name = "cashDeposit", value = "管理费", notes = "管理费")
   @TableField("cash_deposit")
   @Column(name = "cash_deposit", columnDefinition = "decimal(32,8)  COMMENT '管理费'", nullable = false)
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "status", value = "状态 0启用1禁用", notes = "状态 0启用1禁用")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '状态 0启用1禁用'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "startTime", value = "开始时间", notes = "开始时间")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime(6)  COMMENT '开始时间'", nullable = true)
   private LocalDateTime startTime;

   public static ContractManagementCost.ContractManagementCostBuilder builder() {
      return new ContractManagementCost.ContractManagementCostBuilder();
   }

   public ContractManagementCost() {
   }

   public ContractManagementCost(
      final Long id,
      final Long userId,
      final Long projectId,
      final Integer projectAttribute,
      final BigDecimal amountMax,
      final BigDecimal amountMin,
      final BigDecimal cashDeposit,
      final Integer status,
      final LocalDateTime startTime
   ) {
      this.id = id;
      this.userId = userId;
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.amountMax = amountMax;
      this.amountMin = amountMin;
      this.cashDeposit = cashDeposit;
      this.status = status;
      this.startTime = startTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public BigDecimal getAmountMax() {
      return this.amountMax;
   }

   public BigDecimal getAmountMin() {
      return this.amountMin;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Integer getStatus() {
      return this.status;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public ContractManagementCost setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractManagementCost setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractManagementCost setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractManagementCost setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ContractManagementCost setAmountMax(final BigDecimal amountMax) {
      this.amountMax = amountMax;
      return this;
   }

   public ContractManagementCost setAmountMin(final BigDecimal amountMin) {
      this.amountMin = amountMin;
      return this;
   }

   public ContractManagementCost setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
      return this;
   }

   public ContractManagementCost setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ContractManagementCost setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @Override
   public String toString() {
      return "ContractManagementCost(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", amountMax="
         + this.getAmountMax()
         + ", amountMin="
         + this.getAmountMin()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", status="
         + this.getStatus()
         + ", startTime="
         + this.getStartTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractManagementCost)) {
         return false;
      }

      ContractManagementCost other = (ContractManagementCost)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectAttribute = this.getProjectAttribute();
               Object other$projectAttribute = other.getProjectAttribute();
               if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$amountMax = this.getAmountMax();
                     Object other$amountMax = other.getAmountMax();
                     if (this$amountMax == null ? other$amountMax == null : this$amountMax.equals(other$amountMax)) {
                        Object this$amountMin = this.getAmountMin();
                        Object other$amountMin = other.getAmountMin();
                        if (this$amountMin == null ? other$amountMin == null : this$amountMin.equals(other$amountMin)) {
                           Object this$cashDeposit = this.getCashDeposit();
                           Object other$cashDeposit = other.getCashDeposit();
                           if (this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit)) {
                              Object this$startTime = this.getStartTime();
                              Object other$startTime = other.getStartTime();
                              return this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime);
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
      return other instanceof ContractManagementCost;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $amountMax = this.getAmountMax();
      result = result * 59 + ($amountMax == null ? 43 : $amountMax.hashCode());
      Object $amountMin = this.getAmountMin();
      result = result * 59 + ($amountMin == null ? 43 : $amountMin.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $startTime = this.getStartTime();
      return result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
   }

   public static class ContractManagementCostBuilder {
      private Long id;
      private Long userId;
      private Long projectId;
      private Integer projectAttribute;
      private BigDecimal amountMax;
      private BigDecimal amountMin;
      private BigDecimal cashDeposit;
      private Integer status;
      private LocalDateTime startTime;

      ContractManagementCostBuilder() {
      }

      public ContractManagementCost.ContractManagementCostBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder amountMax(final BigDecimal amountMax) {
         this.amountMax = amountMax;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder amountMin(final BigDecimal amountMin) {
         this.amountMin = amountMin;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractManagementCost.ContractManagementCostBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ContractManagementCost build() {
         return new ContractManagementCost(
            this.id, this.userId, this.projectId, this.projectAttribute, this.amountMax, this.amountMin, this.cashDeposit, this.status, this.startTime
         );
      }

      @Override
      public String toString() {
         return "ContractManagementCost.ContractManagementCostBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", projectId="
            + this.projectId
            + ", projectAttribute="
            + this.projectAttribute
            + ", amountMax="
            + this.amountMax
            + ", amountMin="
            + this.amountMin
            + ", cashDeposit="
            + this.cashDeposit
            + ", status="
            + this.status
            + ", startTime="
            + this.startTime
            + ")";
      }
   }
}
