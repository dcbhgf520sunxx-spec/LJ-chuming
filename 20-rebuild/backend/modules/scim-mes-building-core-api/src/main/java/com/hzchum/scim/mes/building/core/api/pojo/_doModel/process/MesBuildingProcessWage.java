package com.hzchum.scim.mes.building.core.api.pojo._doModel.process;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProcessWage对象", description = "工序工价 ")
@TableName("mes_building_process_wage")
@Table(name = "mes_building_process_wage")
public class MesBuildingProcessWage extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度，4 面积]", notes = "计价方式 [1 重量, 2 长度，4 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(20) default '1' COMMENT '计价方式 [1 重量, 2 长度，4 面积]'", nullable = false)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "price", value = "重量价格", notes = "重量价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '重量价格'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "organizationType")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @TableField("organization_type")
   @Column(name = "organization_type", columnDefinition = "bit(1)  COMMENT ''", nullable = true)
   private Boolean organizationType;

   public static MesBuildingProcessWage.MesBuildingProcessWageBuilder builder() {
      return new MesBuildingProcessWage.MesBuildingProcessWageBuilder();
   }

   public MesBuildingProcessWage() {
   }

   public MesBuildingProcessWage(
      final Long id, final Long processId, final Integer wageQuotaType, final BigDecimal price, final Long userId, final Boolean organizationType
   ) {
      this.id = id;
      this.processId = processId;
      this.wageQuotaType = wageQuotaType;
      this.price = price;
      this.userId = userId;
      this.organizationType = organizationType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public MesBuildingProcessWage setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProcessWage setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingProcessWage setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingProcessWage setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProcessWage setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingProcessWage setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessWage(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", price="
         + this.getPrice()
         + ", userId="
         + this.getUserId()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessWage)) {
         return false;
      }

      MesBuildingProcessWage other = (MesBuildingProcessWage)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$organizationType = this.getOrganizationType();
                  Object other$organizationType = other.getOrganizationType();
                  if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesBuildingProcessWage;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBuildingProcessWageBuilder {
      private Long id;
      private Long processId;
      private Integer wageQuotaType;
      private BigDecimal price;
      private Long userId;
      private Boolean organizationType;

      MesBuildingProcessWageBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProcessWage.MesBuildingProcessWageBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProcessWage.MesBuildingProcessWageBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingProcessWage.MesBuildingProcessWageBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingProcessWage.MesBuildingProcessWageBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProcessWage.MesBuildingProcessWageBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingProcessWage.MesBuildingProcessWageBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public MesBuildingProcessWage build() {
         return new MesBuildingProcessWage(this.id, this.processId, this.wageQuotaType, this.price, this.userId, this.organizationType);
      }

      @Override
      public String toString() {
         return "MesBuildingProcessWage.MesBuildingProcessWageBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", price="
            + this.price
            + ", userId="
            + this.userId
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
