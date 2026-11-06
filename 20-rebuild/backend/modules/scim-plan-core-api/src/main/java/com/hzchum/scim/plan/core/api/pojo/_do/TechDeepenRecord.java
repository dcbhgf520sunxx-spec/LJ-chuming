package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechDeepenRecord对象", description = "深化记录表 ")
@Entity
@TableName("tech_deepen_record")
@Table(name = "tech_deepen_record")
@org.hibernate.annotations.Table(appliesTo = "tech_deepen_record", comment = "深化记录表 ")
public class TechDeepenRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id")
   private Long areaBatchId;
   @ApiModelProperty(name = "productType", value = "产品类型 (只记录 构件、围护、配套件)", notes = "产品类型 (只记录 构件、围护)")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 (只记录构件、围护)'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护分类 (当产品类型是围护时)", notes = "围护分类 (当产品类型是围护时)")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT '围护分类 (当产品类型是围护时)'")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品ID (导入产品ID)", notes = "产品ID (导入产品ID)")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品ID (导入产品ID)'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量 (导入数量)", notes = "数量 (导入数量)")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量 (导入数量)'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "总量(总重量kg/总长度mm/辅材核算量)", notes = "总量(总重量kg/总长度mm/辅材核算量)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '总量(总重量kg/总长度mm/辅材核算量)'", nullable = false)
   private BigDecimal mete;
   @ApiModelProperty(name = "areaMete", value = "围护总面积(mm2)", notes = "围护总面积(mm2)")
   @JsonProperty("areaMete")
   @JSONField(name = "areaMete")
   @TableField("area_mete")
   @Column(name = "area_mete", columnDefinition = "decimal(32,8)  COMMENT '围护总面积(mm2)'")
   private BigDecimal areaMete;
   @ApiModelProperty(name = "userId", value = "用户ID (导入人员)", notes = "用户ID (导入人员)")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户ID (导入人员)'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "remark", value = "备注 备注", notes = "备注 备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注 备注'")
   private String remark;

   public static TechDeepenRecord.TechDeepenRecordBuilder builder() {
      return new TechDeepenRecord.TechDeepenRecordBuilder();
   }

   public TechDeepenRecord() {
   }

   public TechDeepenRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Integer productType,
      final Integer category,
      final Long productId,
      final Integer quantity,
      final BigDecimal mete,
      final BigDecimal areaMete,
      final Long userId,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.quantity = quantity;
      this.mete = mete;
      this.areaMete = areaMete;
      this.userId = userId;
      this.remark = remark;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAreaMete() {
      return this.areaMete;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public TechDeepenRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechDeepenRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechDeepenRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public TechDeepenRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechDeepenRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("productType")
   public TechDeepenRecord setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public TechDeepenRecord setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("productId")
   public TechDeepenRecord setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public TechDeepenRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public TechDeepenRecord setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("areaMete")
   public TechDeepenRecord setAreaMete(final BigDecimal areaMete) {
      this.areaMete = areaMete;
      return this;
   }

   @JsonProperty("userId")
   public TechDeepenRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("remark")
   public TechDeepenRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechDeepenRecord(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", areaMete="
         + this.getAreaMete()
         + ", userId="
         + this.getUserId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechDeepenRecord)) {
         return false;
      }

      TechDeepenRecord other = (TechDeepenRecord)o;
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
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$mete = this.getMete();
                                    Object other$mete = other.getMete();
                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                       Object this$areaMete = this.getAreaMete();
                                       Object other$areaMete = other.getAreaMete();
                                       if (this$areaMete == null ? other$areaMete == null : this$areaMete.equals(other$areaMete)) {
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
      return other instanceof TechDeepenRecord;
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $areaMete = this.getAreaMete();
      result = result * 59 + ($areaMete == null ? 43 : $areaMete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechDeepenRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Integer productType;
      private Integer category;
      private Long productId;
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal areaMete;
      private Long userId;
      private String remark;

      TechDeepenRecordBuilder() {
      }

      @JsonProperty("id")
      public TechDeepenRecord.TechDeepenRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechDeepenRecord.TechDeepenRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechDeepenRecord.TechDeepenRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public TechDeepenRecord.TechDeepenRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechDeepenRecord.TechDeepenRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("productType")
      public TechDeepenRecord.TechDeepenRecordBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public TechDeepenRecord.TechDeepenRecordBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("productId")
      public TechDeepenRecord.TechDeepenRecordBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public TechDeepenRecord.TechDeepenRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public TechDeepenRecord.TechDeepenRecordBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("areaMete")
      public TechDeepenRecord.TechDeepenRecordBuilder areaMete(final BigDecimal areaMete) {
         this.areaMete = areaMete;
         return this;
      }

      @JsonProperty("userId")
      public TechDeepenRecord.TechDeepenRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("remark")
      public TechDeepenRecord.TechDeepenRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechDeepenRecord build() {
         return new TechDeepenRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.productType,
            this.category,
            this.productId,
            this.quantity,
            this.mete,
            this.areaMete,
            this.userId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "TechDeepenRecord.TechDeepenRecordBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", areaMete="
            + this.areaMete
            + ", userId="
            + this.userId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
