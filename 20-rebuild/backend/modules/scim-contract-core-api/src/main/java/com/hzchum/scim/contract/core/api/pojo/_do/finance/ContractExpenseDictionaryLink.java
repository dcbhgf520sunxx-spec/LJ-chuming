package com.hzchum.scim.contract.core.api.pojo._do.finance;

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

@ApiModel(value = "ContractExpenseDictionaryLink对象", description = "")
@Entity
@TableName("contract_expense_dictionary_link")
@Table(name = "contract_expense_dictionary_link")
public class ContractExpenseDictionaryLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "expenseTypeId", value = "费用分类表id")
   @TableField("expense_type_id")
   @Column(name = "expense_type_id", columnDefinition = "bigint(20) comment '费用分类表ID'", nullable = false)
   private Long expenseTypeId;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(20) comment '字典表id'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "value", notes = "字典详情值(在某个字典类型name下，value都是唯一的)")
   @TableField("dictionary_value")
   @Column(name = "dictionary_value", columnDefinition = "varchar(255) comment '字典详情值(在某个字典类型name下，value都是唯一的)'")
   private String dictionaryValue;
   @ApiModelProperty(name = "dictionaryLabel", value = "字典标签(在某个字典类型name下，label都是唯一的)")
   @TableField("dictionary_label")
   @Column(name = "dictionary_label", columnDefinition = "varchar(255) comment '字典标签label'", nullable = false)
   private String dictionaryLabel;

   public static ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder builder() {
      return new ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder();
   }

   public ContractExpenseDictionaryLink() {
   }

   public ContractExpenseDictionaryLink(
      final Long id, final Long expenseTypeId, final Long dictionaryId, final String dictionaryValue, final String dictionaryLabel
   ) {
      this.id = id;
      this.expenseTypeId = expenseTypeId;
      this.dictionaryId = dictionaryId;
      this.dictionaryValue = dictionaryValue;
      this.dictionaryLabel = dictionaryLabel;
   }

   public Long getId() {
      return this.id;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getDictionaryValue() {
      return this.dictionaryValue;
   }

   public String getDictionaryLabel() {
      return this.dictionaryLabel;
   }

   public ContractExpenseDictionaryLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractExpenseDictionaryLink setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
      return this;
   }

   public ContractExpenseDictionaryLink setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public ContractExpenseDictionaryLink setDictionaryValue(final String dictionaryValue) {
      this.dictionaryValue = dictionaryValue;
      return this;
   }

   public ContractExpenseDictionaryLink setDictionaryLabel(final String dictionaryLabel) {
      this.dictionaryLabel = dictionaryLabel;
      return this;
   }

   @Override
   public String toString() {
      return "ContractExpenseDictionaryLink(id="
         + this.getId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dictionaryValue="
         + this.getDictionaryValue()
         + ", dictionaryLabel="
         + this.getDictionaryLabel()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractExpenseDictionaryLink)) {
         return false;
      }

      ContractExpenseDictionaryLink other = (ContractExpenseDictionaryLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$expenseTypeId = this.getExpenseTypeId();
         Object other$expenseTypeId = other.getExpenseTypeId();
         if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
            Object this$dictionaryId = this.getDictionaryId();
            Object other$dictionaryId = other.getDictionaryId();
            if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
               Object this$dictionaryValue = this.getDictionaryValue();
               Object other$dictionaryValue = other.getDictionaryValue();
               if (this$dictionaryValue == null ? other$dictionaryValue == null : this$dictionaryValue.equals(other$dictionaryValue)) {
                  Object this$dictionaryLabel = this.getDictionaryLabel();
                  Object other$dictionaryLabel = other.getDictionaryLabel();
                  return this$dictionaryLabel == null ? other$dictionaryLabel == null : this$dictionaryLabel.equals(other$dictionaryLabel);
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
      return other instanceof ContractExpenseDictionaryLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $dictionaryValue = this.getDictionaryValue();
      result = result * 59 + ($dictionaryValue == null ? 43 : $dictionaryValue.hashCode());
      Object $dictionaryLabel = this.getDictionaryLabel();
      return result * 59 + ($dictionaryLabel == null ? 43 : $dictionaryLabel.hashCode());
   }

   public static class ContractExpenseDictionaryLinkBuilder {
      private Long id;
      private Long expenseTypeId;
      private Long dictionaryId;
      private String dictionaryValue;
      private String dictionaryLabel;

      ContractExpenseDictionaryLinkBuilder() {
      }

      public ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder dictionaryValue(final String dictionaryValue) {
         this.dictionaryValue = dictionaryValue;
         return this;
      }

      public ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder dictionaryLabel(final String dictionaryLabel) {
         this.dictionaryLabel = dictionaryLabel;
         return this;
      }

      public ContractExpenseDictionaryLink build() {
         return new ContractExpenseDictionaryLink(this.id, this.expenseTypeId, this.dictionaryId, this.dictionaryValue, this.dictionaryLabel);
      }

      @Override
      public String toString() {
         return "ContractExpenseDictionaryLink.ContractExpenseDictionaryLinkBuilder(id="
            + this.id
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", dictionaryId="
            + this.dictionaryId
            + ", dictionaryValue="
            + this.dictionaryValue
            + ", dictionaryLabel="
            + this.dictionaryLabel
            + ")";
      }
   }
}
