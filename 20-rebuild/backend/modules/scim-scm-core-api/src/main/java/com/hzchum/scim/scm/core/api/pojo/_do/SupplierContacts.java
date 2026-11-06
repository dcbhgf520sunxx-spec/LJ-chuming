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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SupplierContacts对象", description = "")
@Entity
@TableName("scm_supplier_contacts")
@Table(name = "scm_supplier_contacts")
public class SupplierContacts extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "供应商ID")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "name", value = "联系人名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "phone", value = "联系人电话")
   @JsonProperty("phone")
   @JSONField(name = "phone")
   @TableField("phone")
   @Column(name = "phone")
   private String phone;
   @ApiModelProperty(name = "email", value = "联系人邮箱")
   @JsonProperty("email")
   @JSONField(name = "email")
   @TableField("email")
   @Column(name = "email")
   private String email;

   public static SupplierContacts.SupplierContactsBuilder builder() {
      return new SupplierContacts.SupplierContactsBuilder();
   }

   public SupplierContacts() {
   }

   public SupplierContacts(final Long id, final Long supplierId, final String name, final String phone, final String email) {
      this.id = id;
      this.supplierId = supplierId;
      this.name = name;
      this.phone = phone;
      this.email = email;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getName() {
      return this.name;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getEmail() {
      return this.email;
   }

   @JsonProperty("id")
   public SupplierContacts setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierId")
   public SupplierContacts setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("name")
   public SupplierContacts setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("phone")
   public SupplierContacts setPhone(final String phone) {
      this.phone = phone;
      return this;
   }

   @JsonProperty("email")
   public SupplierContacts setEmail(final String email) {
      this.email = email;
      return this;
   }

   @Override
   public String toString() {
      return "SupplierContacts(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", name="
         + this.getName()
         + ", phone="
         + this.getPhone()
         + ", email="
         + this.getEmail()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierContacts)) {
         return false;
      }

      SupplierContacts other = (SupplierContacts)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$phone = this.getPhone();
               Object other$phone = other.getPhone();
               if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                  Object this$email = this.getEmail();
                  Object other$email = other.getEmail();
                  return this$email == null ? other$email == null : this$email.equals(other$email);
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
      return other instanceof SupplierContacts;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $email = this.getEmail();
      return result * 59 + ($email == null ? 43 : $email.hashCode());
   }

   public static class SupplierContactsBuilder {
      private Long id;
      private Long supplierId;
      private String name;
      private String phone;
      private String email;

      SupplierContactsBuilder() {
      }

      @JsonProperty("id")
      public SupplierContacts.SupplierContactsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierId")
      public SupplierContacts.SupplierContactsBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("name")
      public SupplierContacts.SupplierContactsBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("phone")
      public SupplierContacts.SupplierContactsBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      @JsonProperty("email")
      public SupplierContacts.SupplierContactsBuilder email(final String email) {
         this.email = email;
         return this;
      }

      public SupplierContacts build() {
         return new SupplierContacts(this.id, this.supplierId, this.name, this.phone, this.email);
      }

      @Override
      public String toString() {
         return "SupplierContacts.SupplierContactsBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", name="
            + this.name
            + ", phone="
            + this.phone
            + ", email="
            + this.email
            + ")";
      }
   }
}
