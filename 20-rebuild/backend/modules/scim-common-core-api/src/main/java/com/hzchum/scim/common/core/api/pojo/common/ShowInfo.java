package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("显示信息")
public class ShowInfo {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @ApiModelProperty("简称")
   @JsonInclude(Include.NON_NULL)
   private String shortName;
   @ApiModelProperty("单号")
   @JsonInclude(Include.NON_NULL)
   private String orderNumber;
   @ApiModelProperty("代号")
   @JsonInclude(Include.NON_NULL)
   private String codename;
   @ApiModelProperty("班组属性(0:编制外, 1:编制内)")
   @JsonInclude(Include.NON_NULL)
   private Boolean organizationType;
   @ApiModelProperty("类型")
   @JsonInclude(Include.NON_NULL)
   private Integer type;
   @ApiModelProperty("子信息List")
   @JsonInclude(Include.NON_NULL)
   private List<ShowInfo> subList;

   public static ShowInfo.ShowInfoBuilder builder() {
      return new ShowInfo.ShowInfoBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getCodename() {
      return this.codename;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Integer getType() {
      return this.type;
   }

   public List<ShowInfo> getSubList() {
      return this.subList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setCodename(final String codename) {
      this.codename = codename;
   }

   public void setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSubList(final List<ShowInfo> subList) {
      this.subList = subList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShowInfo)) {
         return false;
      }

      ShowInfo other = (ShowInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$organizationType = this.getOrganizationType();
         Object other$organizationType = other.getOrganizationType();
         if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$shortName = this.getShortName();
                     Object other$shortName = other.getShortName();
                     if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                        Object this$orderNumber = this.getOrderNumber();
                        Object other$orderNumber = other.getOrderNumber();
                        if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                           Object this$codename = this.getCodename();
                           Object other$codename = other.getCodename();
                           if (this$codename == null ? other$codename == null : this$codename.equals(other$codename)) {
                              Object this$subList = this.getSubList();
                              Object other$subList = other.getSubList();
                              return this$subList == null ? other$subList == null : this$subList.equals(other$subList);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ShowInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $codename = this.getCodename();
      result = result * 59 + ($codename == null ? 43 : $codename.hashCode());
      Object $subList = this.getSubList();
      return result * 59 + ($subList == null ? 43 : $subList.hashCode());
   }

   @Override
   public String toString() {
      return "ShowInfo(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shortName="
         + this.getShortName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", codename="
         + this.getCodename()
         + ", organizationType="
         + this.getOrganizationType()
         + ", type="
         + this.getType()
         + ", subList="
         + this.getSubList()
         + ")";
   }

   public ShowInfo() {
   }

   public ShowInfo(
      final Long id,
      final String name,
      final String serialNumber,
      final String shortName,
      final String orderNumber,
      final String codename,
      final Boolean organizationType,
      final Integer type,
      final List<ShowInfo> subList
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.shortName = shortName;
      this.orderNumber = orderNumber;
      this.codename = codename;
      this.organizationType = organizationType;
      this.type = type;
      this.subList = subList;
   }

   public static class ShowInfoBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private String shortName;
      private String orderNumber;
      private String codename;
      private Boolean organizationType;
      private Integer type;
      private List<ShowInfo> subList;

      ShowInfoBuilder() {
      }

      public ShowInfo.ShowInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ShowInfo.ShowInfoBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ShowInfo.ShowInfoBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ShowInfo.ShowInfoBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ShowInfo.ShowInfoBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public ShowInfo.ShowInfoBuilder codename(final String codename) {
         this.codename = codename;
         return this;
      }

      public ShowInfo.ShowInfoBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public ShowInfo.ShowInfoBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ShowInfo.ShowInfoBuilder subList(final List<ShowInfo> subList) {
         this.subList = subList;
         return this;
      }

      public ShowInfo build() {
         return new ShowInfo(
            this.id, this.name, this.serialNumber, this.shortName, this.orderNumber, this.codename, this.organizationType, this.type, this.subList
         );
      }

      @Override
      public String toString() {
         return "ShowInfo.ShowInfoBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", shortName="
            + this.shortName
            + ", orderNumber="
            + this.orderNumber
            + ", codename="
            + this.codename
            + ", organizationType="
            + this.organizationType
            + ", type="
            + this.type
            + ", subList="
            + this.subList
            + ")";
      }
   }
}
