package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechEnclosureChangeLog对象", description = "围护变更日志表 ")
@Entity
@TableName("tech_enclosure_change_log")
@Table(name = "tech_enclosure_change_log")
@org.hibernate.annotations.Table(appliesTo = "tech_enclosure_change_log", comment = "围护变更日志表 ")
public class TechEnclosureChangeLog extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "changeId", value = "围护变更记录表id", notes = "围护变更记录表id")
   @TableField("change_id")
   @Column(name = "change_id", columnDefinition = "bigint(20)  COMMENT '围护变更记录表id'", nullable = false)
   private Long changeId;
   @ApiModelProperty(name = "tableId", value = "围护变更记录表id", notes = "围护变更记录表id")
   @TableField("table_id")
   @Column(name = "table_id", columnDefinition = "bigint(20)  COMMENT '围护变更记录表id'", nullable = false)
   private Long tableId;
   @ApiModelProperty(name = "oldQuantity", value = "变更前的数量", notes = "变更前的数量")
   @TableField("old_quantity")
   @Column(name = "old_quantity", columnDefinition = "int(11) default '0'  COMMENT '变更前的数量'", nullable = false)
   private Integer oldQuantity;
   @ApiModelProperty(name = "changeQuantity", value = "变更数", notes = "变更数")
   @TableField("change_quantity")
   @Column(name = "change_quantity", columnDefinition = "int(11) default '0' COMMENT '变更数'", nullable = false)
   private Integer changeQuantity;
   @ApiModelProperty(name = "quantity", value = "变更后的数量", notes = "变更后的数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '变更后的数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  default null comment '围护品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件' ")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型id", notes = "字典类型id")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint  COMMENT '字典类型id'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "type", value = "数据类型 1:入库汇总 2:入库记录 4:完成记录 ", notes = "数据类型 1:入库汇总 2:入库记录 4:完成记录 ")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '数据类型 1:入库汇总 2:入库记录 4:完成记录 '", nullable = false)
   private Integer type;

   public static TechEnclosureChangeLog.TechEnclosureChangeLogBuilder builder() {
      return new TechEnclosureChangeLog.TechEnclosureChangeLogBuilder();
   }

   public TechEnclosureChangeLog() {
   }

   public TechEnclosureChangeLog(
      final Long id,
      final Long productId,
      final Long changeId,
      final Long tableId,
      final Integer oldQuantity,
      final Integer changeQuantity,
      final Integer quantity,
      final Long userId,
      final Integer category,
      final Long dictionaryId,
      final Integer type
   ) {
      this.id = id;
      this.productId = productId;
      this.changeId = changeId;
      this.tableId = tableId;
      this.oldQuantity = oldQuantity;
      this.changeQuantity = changeQuantity;
      this.quantity = quantity;
      this.userId = userId;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getChangeId() {
      return this.changeId;
   }

   public Long getTableId() {
      return this.tableId;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getChangeQuantity() {
      return this.changeQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Integer getType() {
      return this.type;
   }

   public TechEnclosureChangeLog setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosureChangeLog setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechEnclosureChangeLog setChangeId(final Long changeId) {
      this.changeId = changeId;
      return this;
   }

   public TechEnclosureChangeLog setTableId(final Long tableId) {
      this.tableId = tableId;
      return this;
   }

   public TechEnclosureChangeLog setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
      return this;
   }

   public TechEnclosureChangeLog setChangeQuantity(final Integer changeQuantity) {
      this.changeQuantity = changeQuantity;
      return this;
   }

   public TechEnclosureChangeLog setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechEnclosureChangeLog setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechEnclosureChangeLog setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public TechEnclosureChangeLog setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public TechEnclosureChangeLog setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureChangeLog(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", changeId="
         + this.getChangeId()
         + ", tableId="
         + this.getTableId()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", changeQuantity="
         + this.getChangeQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureChangeLog)) {
         return false;
      }

      TechEnclosureChangeLog other = (TechEnclosureChangeLog)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$changeId = this.getChangeId();
            Object other$changeId = other.getChangeId();
            if (this$changeId == null ? other$changeId == null : this$changeId.equals(other$changeId)) {
               Object this$tableId = this.getTableId();
               Object other$tableId = other.getTableId();
               if (this$tableId == null ? other$tableId == null : this$tableId.equals(other$tableId)) {
                  Object this$oldQuantity = this.getOldQuantity();
                  Object other$oldQuantity = other.getOldQuantity();
                  if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                     Object this$changeQuantity = this.getChangeQuantity();
                     Object other$changeQuantity = other.getChangeQuantity();
                     if (this$changeQuantity == null ? other$changeQuantity == null : this$changeQuantity.equals(other$changeQuantity)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$category = this.getCategory();
                              Object other$category = other.getCategory();
                              if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                 Object this$dictionaryId = this.getDictionaryId();
                                 Object other$dictionaryId = other.getDictionaryId();
                                 if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                    Object this$type = this.getType();
                                    Object other$type = other.getType();
                                    return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof TechEnclosureChangeLog;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $changeId = this.getChangeId();
      result = result * 59 + ($changeId == null ? 43 : $changeId.hashCode());
      Object $tableId = this.getTableId();
      result = result * 59 + ($tableId == null ? 43 : $tableId.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $changeQuantity = this.getChangeQuantity();
      result = result * 59 + ($changeQuantity == null ? 43 : $changeQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public static class TechEnclosureChangeLogBuilder {
      private Long id;
      private Long productId;
      private Long changeId;
      private Long tableId;
      private Integer oldQuantity;
      private Integer changeQuantity;
      private Integer quantity;
      private Long userId;
      private Integer category;
      private Long dictionaryId;
      private Integer type;

      TechEnclosureChangeLogBuilder() {
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder tableId(final Long tableId) {
         this.tableId = tableId;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder changeQuantity(final Integer changeQuantity) {
         this.changeQuantity = changeQuantity;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechEnclosureChangeLog.TechEnclosureChangeLogBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechEnclosureChangeLog build() {
         return new TechEnclosureChangeLog(
            this.id,
            this.productId,
            this.changeId,
            this.tableId,
            this.oldQuantity,
            this.changeQuantity,
            this.quantity,
            this.userId,
            this.category,
            this.dictionaryId,
            this.type
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureChangeLog.TechEnclosureChangeLogBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", changeId="
            + this.changeId
            + ", tableId="
            + this.tableId
            + ", oldQuantity="
            + this.oldQuantity
            + ", changeQuantity="
            + this.changeQuantity
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", type="
            + this.type
            + ")";
      }
   }
}
