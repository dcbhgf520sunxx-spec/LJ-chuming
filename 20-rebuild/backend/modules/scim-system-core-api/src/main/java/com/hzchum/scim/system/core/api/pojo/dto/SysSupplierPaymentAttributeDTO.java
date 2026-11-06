package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysSupplierPaymentReason对象", description = "付款属性配置表")
public class SysSupplierPaymentAttributeDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "boolEnableStatus", value = "启用状态 1启用 0禁用", notes = "启用状态 1启用 0禁用")
   private Boolean boolEnableStatus;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public static SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder builder() {
      return new SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder();
   }

   public SysSupplierPaymentAttributeDTO() {
   }

   public SysSupplierPaymentAttributeDTO(
      final Long id, final String name, final Boolean boolEnableStatus, final Long createUserId, final String createUserName, final Integer sort
   ) {
      this.id = id;
      this.name = name;
      this.boolEnableStatus = boolEnableStatus;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolEnableStatus() {
      return this.boolEnableStatus;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolEnableStatus(final Boolean boolEnableStatus) {
      this.boolEnableStatus = boolEnableStatus;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSupplierPaymentAttributeDTO)) {
         return false;
      }

      SysSupplierPaymentAttributeDTO other = (SysSupplierPaymentAttributeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolEnableStatus = this.getBoolEnableStatus();
         Object other$boolEnableStatus = other.getBoolEnableStatus();
         if (this$boolEnableStatus == null ? other$boolEnableStatus == null : this$boolEnableStatus.equals(other$boolEnableStatus)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof SysSupplierPaymentAttributeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnableStatus = this.getBoolEnableStatus();
      result = result * 59 + ($boolEnableStatus == null ? 43 : $boolEnableStatus.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   @Override
   public String toString() {
      return "SysSupplierPaymentAttributeDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolEnableStatus="
         + this.getBoolEnableStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", sort="
         + this.getSort()
         + ")";
   }

   public static class SysSupplierPaymentAttributeDTOBuilder {
      private Long id;
      private String name;
      private Boolean boolEnableStatus;
      private Long createUserId;
      private String createUserName;
      private Integer sort;

      SysSupplierPaymentAttributeDTOBuilder() {
      }

      public SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder boolEnableStatus(final Boolean boolEnableStatus) {
         this.boolEnableStatus = boolEnableStatus;
         return this;
      }

      public SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysSupplierPaymentAttributeDTO build() {
         return new SysSupplierPaymentAttributeDTO(this.id, this.name, this.boolEnableStatus, this.createUserId, this.createUserName, this.sort);
      }

      @Override
      public String toString() {
         return "SysSupplierPaymentAttributeDTO.SysSupplierPaymentAttributeDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolEnableStatus="
            + this.boolEnableStatus
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
