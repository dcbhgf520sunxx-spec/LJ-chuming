package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "SporadicLogisticsOrder", description = "零星物流订单 ")
@Entity
@TableName("scm_sporadic_logistics_order")
@Table(name = "scm_sporadic_logistics_order")
public class SporadicLogisticsOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "reportDate", value = "日期")
   @JsonProperty("reportDate")
   @JSONField(name = "reportDate")
   @TableField("report_date")
   @Column(name = "report_date")
   private LocalDateTime reportDate;
   @ApiModelProperty(name = "informantName", value = "填报人")
   @JsonProperty("informantName")
   @JSONField(name = "informantName")
   @TableField("informant_name")
   @Column(name = "informant_name")
   private String informantName;
   @ApiModelProperty(name = "carrierType", value = "运承类型（1，个人。2，单位）")
   @JsonProperty("carrierType")
   @JSONField(name = "carrierType")
   @TableField("carrier_type")
   @Column(name = "carrier_type")
   private Integer carrierType;
   @ApiModelProperty(name = "supplierId", value = "供应商id（物流（收款）单位id）")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名称（物流（收款））单位")
   @JsonProperty("supplierName")
   @JSONField(name = "supplierName")
   @TableField("supplier_name")
   @Column(name = "supplier_name")
   private String supplierName;
   @ApiModelProperty(name = "projectId", value = "所属项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private String projectId;
   @ApiModelProperty(name = "applyAmount", value = "申请金额")
   @JsonProperty("applyAmount")
   @JSONField(name = "applyAmount")
   @TableField("apply_amount")
   @Column(name = "apply_amount")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;

   public static SporadicLogisticsOrder.SporadicLogisticsOrderBuilder builder() {
      return new SporadicLogisticsOrder.SporadicLogisticsOrderBuilder();
   }

   public SporadicLogisticsOrder() {
   }

   public SporadicLogisticsOrder(
      final Long id,
      final LocalDateTime reportDate,
      final String informantName,
      final Integer carrierType,
      final Long supplierId,
      final String supplierName,
      final String projectId,
      final BigDecimal applyAmount,
      final String remark
   ) {
      this.id = id;
      this.reportDate = reportDate;
      this.informantName = informantName;
      this.carrierType = carrierType;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectId = projectId;
      this.applyAmount = applyAmount;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getReportDate() {
      return this.reportDate;
   }

   public String getInformantName() {
      return this.informantName;
   }

   public Integer getCarrierType() {
      return this.carrierType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public SporadicLogisticsOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("reportDate")
   public SporadicLogisticsOrder setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
      return this;
   }

   @JsonProperty("informantName")
   public SporadicLogisticsOrder setInformantName(final String informantName) {
      this.informantName = informantName;
      return this;
   }

   @JsonProperty("carrierType")
   public SporadicLogisticsOrder setCarrierType(final Integer carrierType) {
      this.carrierType = carrierType;
      return this;
   }

   @JsonProperty("supplierId")
   public SporadicLogisticsOrder setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("supplierName")
   public SporadicLogisticsOrder setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @JsonProperty("projectId")
   public SporadicLogisticsOrder setProjectId(final String projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("applyAmount")
   public SporadicLogisticsOrder setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
      return this;
   }

   @JsonProperty("remark")
   public SporadicLogisticsOrder setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "SporadicLogisticsOrder(id="
         + this.getId()
         + ", reportDate="
         + this.getReportDate()
         + ", informantName="
         + this.getInformantName()
         + ", carrierType="
         + this.getCarrierType()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectId="
         + this.getProjectId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SporadicLogisticsOrder)) {
         return false;
      }

      SporadicLogisticsOrder other = (SporadicLogisticsOrder)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$carrierType = this.getCarrierType();
         Object other$carrierType = other.getCarrierType();
         if (this$carrierType == null ? other$carrierType == null : this$carrierType.equals(other$carrierType)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$reportDate = this.getReportDate();
               Object other$reportDate = other.getReportDate();
               if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                  Object this$informantName = this.getInformantName();
                  Object other$informantName = other.getInformantName();
                  if (this$informantName == null ? other$informantName == null : this$informantName.equals(other$informantName)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$applyAmount = this.getApplyAmount();
                           Object other$applyAmount = other.getApplyAmount();
                           if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof SporadicLogisticsOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $carrierType = this.getCarrierType();
      result = result * 59 + ($carrierType == null ? 43 : $carrierType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $informantName = this.getInformantName();
      result = result * 59 + ($informantName == null ? 43 : $informantName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SporadicLogisticsOrderBuilder {
      private Long id;
      private LocalDateTime reportDate;
      private String informantName;
      private Integer carrierType;
      private Long supplierId;
      private String supplierName;
      private String projectId;
      private BigDecimal applyAmount;
      private String remark;

      SporadicLogisticsOrderBuilder() {
      }

      @JsonProperty("id")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("reportDate")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder reportDate(final LocalDateTime reportDate) {
         this.reportDate = reportDate;
         return this;
      }

      @JsonProperty("informantName")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder informantName(final String informantName) {
         this.informantName = informantName;
         return this;
      }

      @JsonProperty("carrierType")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder carrierType(final Integer carrierType) {
         this.carrierType = carrierType;
         return this;
      }

      @JsonProperty("supplierId")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("supplierName")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      @JsonProperty("projectId")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder projectId(final String projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("applyAmount")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      @JsonProperty("remark")
      public SporadicLogisticsOrder.SporadicLogisticsOrderBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SporadicLogisticsOrder build() {
         return new SporadicLogisticsOrder(
            this.id, this.reportDate, this.informantName, this.carrierType, this.supplierId, this.supplierName, this.projectId, this.applyAmount, this.remark
         );
      }

      @Override
      public String toString() {
         return "SporadicLogisticsOrder.SporadicLogisticsOrderBuilder(id="
            + this.id
            + ", reportDate="
            + this.reportDate
            + ", informantName="
            + this.informantName
            + ", carrierType="
            + this.carrierType
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectId="
            + this.projectId
            + ", applyAmount="
            + this.applyAmount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
