package com.hzchum.scim.contract.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractWaste对象", description = "废料合同表 ")
@Entity
@TableName("contract_waste")
@Table(name = "contract_waste")
@org.hibernate.annotations.Table(appliesTo = "contract_waste", comment = "废料合同表 ")
public class ContractWaste extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '合同编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   @TableField("purchaser")
   @Column(name = "purchaser", columnDefinition = "varchar(64)  COMMENT '购买方'", nullable = false)
   private String purchaser;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "lastEditUserId", value = "最近修改人id", notes = "最近修改人id")
   @TableField("last_edit_user_id")
   @Column(name = "last_edit_user_id", columnDefinition = "bigint(20)  COMMENT '最近修改人id'", nullable = true)
   private Long lastEditUserId;
   @ApiModelProperty(name = "lastEditTime", value = "最近修改时间", notes = "最近修改时间")
   @TableField("last_edit_time")
   @Column(name = "last_edit_time", columnDefinition = "datetime(6)  COMMENT '最近修改时间'", nullable = true)
   private LocalDateTime lastEditTime;

   public static ContractWaste.ContractWasteBuilder builder() {
      return new ContractWaste.ContractWasteBuilder();
   }

   public ContractWaste() {
   }

   public ContractWaste(
      final Long id, final String serialNumber, final String purchaser, final Long userId, final Long lastEditUserId, final LocalDateTime lastEditTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.userId = userId;
      this.lastEditUserId = lastEditUserId;
      this.lastEditTime = lastEditTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getLastEditUserId() {
      return this.lastEditUserId;
   }

   public LocalDateTime getLastEditTime() {
      return this.lastEditTime;
   }

   public ContractWaste setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractWaste setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ContractWaste setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
      return this;
   }

   public ContractWaste setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractWaste setLastEditUserId(final Long lastEditUserId) {
      this.lastEditUserId = lastEditUserId;
      return this;
   }

   public ContractWaste setLastEditTime(final LocalDateTime lastEditTime) {
      this.lastEditTime = lastEditTime;
      return this;
   }

   @Override
   public String toString() {
      return "ContractWaste(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", userId="
         + this.getUserId()
         + ", lastEditUserId="
         + this.getLastEditUserId()
         + ", lastEditTime="
         + this.getLastEditTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaste)) {
         return false;
      }

      ContractWaste other = (ContractWaste)o;
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
            Object this$lastEditUserId = this.getLastEditUserId();
            Object other$lastEditUserId = other.getLastEditUserId();
            if (this$lastEditUserId == null ? other$lastEditUserId == null : this$lastEditUserId.equals(other$lastEditUserId)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$purchaser = this.getPurchaser();
                  Object other$purchaser = other.getPurchaser();
                  if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                     Object this$lastEditTime = this.getLastEditTime();
                     Object other$lastEditTime = other.getLastEditTime();
                     return this$lastEditTime == null ? other$lastEditTime == null : this$lastEditTime.equals(other$lastEditTime);
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
      return other instanceof ContractWaste;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $lastEditUserId = this.getLastEditUserId();
      result = result * 59 + ($lastEditUserId == null ? 43 : $lastEditUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $lastEditTime = this.getLastEditTime();
      return result * 59 + ($lastEditTime == null ? 43 : $lastEditTime.hashCode());
   }

   public static class ContractWasteBuilder {
      private Long id;
      private String serialNumber;
      private String purchaser;
      private Long userId;
      private Long lastEditUserId;
      private LocalDateTime lastEditTime;

      ContractWasteBuilder() {
      }

      public ContractWaste.ContractWasteBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWaste.ContractWasteBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractWaste.ContractWasteBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ContractWaste.ContractWasteBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWaste.ContractWasteBuilder lastEditUserId(final Long lastEditUserId) {
         this.lastEditUserId = lastEditUserId;
         return this;
      }

      public ContractWaste.ContractWasteBuilder lastEditTime(final LocalDateTime lastEditTime) {
         this.lastEditTime = lastEditTime;
         return this;
      }

      public ContractWaste build() {
         return new ContractWaste(this.id, this.serialNumber, this.purchaser, this.userId, this.lastEditUserId, this.lastEditTime);
      }

      @Override
      public String toString() {
         return "ContractWaste.ContractWasteBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", userId="
            + this.userId
            + ", lastEditUserId="
            + this.lastEditUserId
            + ", lastEditTime="
            + this.lastEditTime
            + ")";
      }
   }
}
