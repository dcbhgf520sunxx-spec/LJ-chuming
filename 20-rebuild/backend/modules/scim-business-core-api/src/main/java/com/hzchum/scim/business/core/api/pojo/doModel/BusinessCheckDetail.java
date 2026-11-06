package com.hzchum.scim.business.core.api.pojo.doModel;

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

@ApiModel(value = "BusinessCheckDetail对象", description = "商务价格修改详情表 ")
@TableName("business_check_detail")
@Table(name = "business_check_detail")
@Entity
public class BusinessCheckDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "checkInfoId", value = "商务价格修改记录表id")
   @TableField("check_info_id")
   @Column(name = "check_info_id", columnDefinition = "bigint(20) COMMENT '修改记录表id'", nullable = false)
   private Long checkInfoId;
   @ApiModelProperty(name = "projectType", notes = "项目类型   1建筑钢结构 2桥梁钢结构  4立体停车库 8围护项目")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) comment '项目类型  1建筑钢结构 2桥梁钢结构  4立体停车库'")
   private Integer projectType;
   @ApiModelProperty(name = "type", value = "建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件")
   @Column(name = "type", columnDefinition = "int(11) COMMENT '类型 1零件 2构件 4围护 8标准件'")
   private Integer type;
   @ApiModelProperty(name = "businessId", value = "商务id")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = " bigint(20) COMMENT '商务表id'", nullable = false)
   private Long businessId;
   @ApiModelProperty(name = "oldUnitPrice", value = "原有单价")
   @TableField("old_unit_price")
   @Column(name = "old_unit_price", columnDefinition = "decimal(32,8) COMMENT '原单价'")
   private BigDecimal oldUnitPrice;
   @ApiModelProperty(name = "newUnitPrice", value = "新单价")
   @TableField("new_unit_price")
   @Column(name = "new_unit_price", columnDefinition = "decimal(32,8) COMMENT '新单价'", nullable = false)
   private BigDecimal newUnitPrice;
   @ApiModelProperty(name = "oldPricingManner", value = "原有计价方式")
   @TableField("old_pricing_manner")
   @Column(name = "old_pricing_manner", columnDefinition = "int(1) default 0 COMMENT '计价方式'", nullable = false)
   private Integer oldPricingManner;
   @ApiModelProperty(name = "newPricingManner", value = "新计价方式")
   @TableField("new_pricing_manner")
   @Column(name = "new_pricing_manner", columnDefinition = "int(1) default 0 COMMENT '计价方式'", nullable = false)
   private Integer newPricingManner;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2通过 4驳回")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) DEFAULT 1 COMMENT '审核状态 1未审核 2通过 4驳回'", nullable = false)
   private Integer status;

   public static BusinessCheckDetail.BusinessCheckDetailBuilder builder() {
      return new BusinessCheckDetail.BusinessCheckDetailBuilder();
   }

   public BusinessCheckDetail() {
   }

   public BusinessCheckDetail(
      final Long id,
      final Long checkInfoId,
      final Integer projectType,
      final Integer type,
      final Long businessId,
      final BigDecimal oldUnitPrice,
      final BigDecimal newUnitPrice,
      final Integer oldPricingManner,
      final Integer newPricingManner,
      final Integer status
   ) {
      this.id = id;
      this.checkInfoId = checkInfoId;
      this.projectType = projectType;
      this.type = type;
      this.businessId = businessId;
      this.oldUnitPrice = oldUnitPrice;
      this.newUnitPrice = newUnitPrice;
      this.oldPricingManner = oldPricingManner;
      this.newPricingManner = newPricingManner;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCheckInfoId() {
      return this.checkInfoId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public BigDecimal getOldUnitPrice() {
      return this.oldUnitPrice;
   }

   public BigDecimal getNewUnitPrice() {
      return this.newUnitPrice;
   }

   public Integer getOldPricingManner() {
      return this.oldPricingManner;
   }

   public Integer getNewPricingManner() {
      return this.newPricingManner;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public BusinessCheckDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessCheckDetail setCheckInfoId(final Long checkInfoId) {
      this.checkInfoId = checkInfoId;
      return this;
   }

   public BusinessCheckDetail setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public BusinessCheckDetail setType(final Integer type) {
      this.type = type;
      return this;
   }

   public BusinessCheckDetail setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public BusinessCheckDetail setOldUnitPrice(final BigDecimal oldUnitPrice) {
      this.oldUnitPrice = oldUnitPrice;
      return this;
   }

   public BusinessCheckDetail setNewUnitPrice(final BigDecimal newUnitPrice) {
      this.newUnitPrice = newUnitPrice;
      return this;
   }

   public BusinessCheckDetail setOldPricingManner(final Integer oldPricingManner) {
      this.oldPricingManner = oldPricingManner;
      return this;
   }

   public BusinessCheckDetail setNewPricingManner(final Integer newPricingManner) {
      this.newPricingManner = newPricingManner;
      return this;
   }

   public BusinessCheckDetail setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessCheckDetail(id="
         + this.getId()
         + ", checkInfoId="
         + this.getCheckInfoId()
         + ", projectType="
         + this.getProjectType()
         + ", type="
         + this.getType()
         + ", businessId="
         + this.getBusinessId()
         + ", oldUnitPrice="
         + this.getOldUnitPrice()
         + ", newUnitPrice="
         + this.getNewUnitPrice()
         + ", oldPricingManner="
         + this.getOldPricingManner()
         + ", newPricingManner="
         + this.getNewPricingManner()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessCheckDetail)) {
         return false;
      }

      BusinessCheckDetail other = (BusinessCheckDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$checkInfoId = this.getCheckInfoId();
         Object other$checkInfoId = other.getCheckInfoId();
         if (this$checkInfoId == null ? other$checkInfoId == null : this$checkInfoId.equals(other$checkInfoId)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$businessId = this.getBusinessId();
                  Object other$businessId = other.getBusinessId();
                  if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                     Object this$oldPricingManner = this.getOldPricingManner();
                     Object other$oldPricingManner = other.getOldPricingManner();
                     if (this$oldPricingManner == null ? other$oldPricingManner == null : this$oldPricingManner.equals(other$oldPricingManner)) {
                        Object this$newPricingManner = this.getNewPricingManner();
                        Object other$newPricingManner = other.getNewPricingManner();
                        if (this$newPricingManner == null ? other$newPricingManner == null : this$newPricingManner.equals(other$newPricingManner)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$oldUnitPrice = this.getOldUnitPrice();
                              Object other$oldUnitPrice = other.getOldUnitPrice();
                              if (this$oldUnitPrice == null ? other$oldUnitPrice == null : this$oldUnitPrice.equals(other$oldUnitPrice)) {
                                 Object this$newUnitPrice = this.getNewUnitPrice();
                                 Object other$newUnitPrice = other.getNewUnitPrice();
                                 return this$newUnitPrice == null ? other$newUnitPrice == null : this$newUnitPrice.equals(other$newUnitPrice);
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
      return other instanceof BusinessCheckDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $checkInfoId = this.getCheckInfoId();
      result = result * 59 + ($checkInfoId == null ? 43 : $checkInfoId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $oldPricingManner = this.getOldPricingManner();
      result = result * 59 + ($oldPricingManner == null ? 43 : $oldPricingManner.hashCode());
      Object $newPricingManner = this.getNewPricingManner();
      result = result * 59 + ($newPricingManner == null ? 43 : $newPricingManner.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $oldUnitPrice = this.getOldUnitPrice();
      result = result * 59 + ($oldUnitPrice == null ? 43 : $oldUnitPrice.hashCode());
      Object $newUnitPrice = this.getNewUnitPrice();
      return result * 59 + ($newUnitPrice == null ? 43 : $newUnitPrice.hashCode());
   }

   public static class BusinessCheckDetailBuilder {
      private Long id;
      private Long checkInfoId;
      private Integer projectType;
      private Integer type;
      private Long businessId;
      private BigDecimal oldUnitPrice;
      private BigDecimal newUnitPrice;
      private Integer oldPricingManner;
      private Integer newPricingManner;
      private Integer status;

      BusinessCheckDetailBuilder() {
      }

      @JsonProperty("id")
      public BusinessCheckDetail.BusinessCheckDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder checkInfoId(final Long checkInfoId) {
         this.checkInfoId = checkInfoId;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder oldUnitPrice(final BigDecimal oldUnitPrice) {
         this.oldUnitPrice = oldUnitPrice;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder newUnitPrice(final BigDecimal newUnitPrice) {
         this.newUnitPrice = newUnitPrice;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder oldPricingManner(final Integer oldPricingManner) {
         this.oldPricingManner = oldPricingManner;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder newPricingManner(final Integer newPricingManner) {
         this.newPricingManner = newPricingManner;
         return this;
      }

      public BusinessCheckDetail.BusinessCheckDetailBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessCheckDetail build() {
         return new BusinessCheckDetail(
            this.id,
            this.checkInfoId,
            this.projectType,
            this.type,
            this.businessId,
            this.oldUnitPrice,
            this.newUnitPrice,
            this.oldPricingManner,
            this.newPricingManner,
            this.status
         );
      }

      @Override
      public String toString() {
         return "BusinessCheckDetail.BusinessCheckDetailBuilder(id="
            + this.id
            + ", checkInfoId="
            + this.checkInfoId
            + ", projectType="
            + this.projectType
            + ", type="
            + this.type
            + ", businessId="
            + this.businessId
            + ", oldUnitPrice="
            + this.oldUnitPrice
            + ", newUnitPrice="
            + this.newUnitPrice
            + ", oldPricingManner="
            + this.oldPricingManner
            + ", newPricingManner="
            + this.newPricingManner
            + ", status="
            + this.status
            + ")";
      }
   }
}
