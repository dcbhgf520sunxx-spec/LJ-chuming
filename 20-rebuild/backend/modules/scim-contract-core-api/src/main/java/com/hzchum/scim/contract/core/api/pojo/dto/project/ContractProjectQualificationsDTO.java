package com.hzchum.scim.contract.core.api.pojo.dto.project;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;

@ApiOperation("资质证照返回DTO")
public class ContractProjectQualificationsDTO {
   @ApiModelProperty(name = "fnumber", notes = "项目编码")
   private String fnumber;
   @ApiModelProperty(name = "name", notes = "项⽬名称")
   private String name;
   @ApiModelProperty(name = "address", notes = "项⽬所在地")
   private String address;
   @ApiModelProperty(name = "work_out", notes = "预计竣⼯时间")
   private LocalDateTime work_out;
   @ApiModelProperty(name = "customerUnit", notes = "客户名称")
   private String customerUnit;
   @ApiModelProperty(name = "state", notes = "项⽬状态(枚举值)")
   private String state;
   @ApiModelProperty(name = "state_name", notes = "项⽬状态名称")
   private String state_name;
   @ApiModelProperty(name = "parent_number", notes = "父项⽬编码")
   private String parent_number;

   public static ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder builder() {
      return new ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder();
   }

   public String getFnumber() {
      return this.fnumber;
   }

   public String getName() {
      return this.name;
   }

   public String getAddress() {
      return this.address;
   }

   public LocalDateTime getWork_out() {
      return this.work_out;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getState() {
      return this.state;
   }

   public String getState_name() {
      return this.state_name;
   }

   public String getParent_number() {
      return this.parent_number;
   }

   public ContractProjectQualificationsDTO setFnumber(final String fnumber) {
      this.fnumber = fnumber;
      return this;
   }

   public ContractProjectQualificationsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ContractProjectQualificationsDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public ContractProjectQualificationsDTO setWork_out(final LocalDateTime work_out) {
      this.work_out = work_out;
      return this;
   }

   public ContractProjectQualificationsDTO setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
      return this;
   }

   public ContractProjectQualificationsDTO setState(final String state) {
      this.state = state;
      return this;
   }

   public ContractProjectQualificationsDTO setState_name(final String state_name) {
      this.state_name = state_name;
      return this;
   }

   public ContractProjectQualificationsDTO setParent_number(final String parent_number) {
      this.parent_number = parent_number;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectQualificationsDTO)) {
         return false;
      }

      ContractProjectQualificationsDTO other = (ContractProjectQualificationsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$fnumber = this.getFnumber();
      Object other$fnumber = other.getFnumber();
      if (this$fnumber == null ? other$fnumber == null : this$fnumber.equals(other$fnumber)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$address = this.getAddress();
            Object other$address = other.getAddress();
            if (this$address == null ? other$address == null : this$address.equals(other$address)) {
               Object this$work_out = this.getWork_out();
               Object other$work_out = other.getWork_out();
               if (this$work_out == null ? other$work_out == null : this$work_out.equals(other$work_out)) {
                  Object this$customerUnit = this.getCustomerUnit();
                  Object other$customerUnit = other.getCustomerUnit();
                  if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                     Object this$state = this.getState();
                     Object other$state = other.getState();
                     if (this$state == null ? other$state == null : this$state.equals(other$state)) {
                        Object this$state_name = this.getState_name();
                        Object other$state_name = other.getState_name();
                        if (this$state_name == null ? other$state_name == null : this$state_name.equals(other$state_name)) {
                           Object this$parent_number = this.getParent_number();
                           Object other$parent_number = other.getParent_number();
                           return this$parent_number == null ? other$parent_number == null : this$parent_number.equals(other$parent_number);
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
      return other instanceof ContractProjectQualificationsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fnumber = this.getFnumber();
      result = result * 59 + ($fnumber == null ? 43 : $fnumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $work_out = this.getWork_out();
      result = result * 59 + ($work_out == null ? 43 : $work_out.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $state_name = this.getState_name();
      result = result * 59 + ($state_name == null ? 43 : $state_name.hashCode());
      Object $parent_number = this.getParent_number();
      return result * 59 + ($parent_number == null ? 43 : $parent_number.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectQualificationsDTO(fnumber="
         + this.getFnumber()
         + ", name="
         + this.getName()
         + ", address="
         + this.getAddress()
         + ", work_out="
         + this.getWork_out()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", state="
         + this.getState()
         + ", state_name="
         + this.getState_name()
         + ", parent_number="
         + this.getParent_number()
         + ")";
   }

   public ContractProjectQualificationsDTO(
      final String fnumber,
      final String name,
      final String address,
      final LocalDateTime work_out,
      final String customerUnit,
      final String state,
      final String state_name,
      final String parent_number
   ) {
      this.fnumber = fnumber;
      this.name = name;
      this.address = address;
      this.work_out = work_out;
      this.customerUnit = customerUnit;
      this.state = state;
      this.state_name = state_name;
      this.parent_number = parent_number;
   }

   public ContractProjectQualificationsDTO() {
   }

   public static class ContractProjectQualificationsDTOBuilder {
      private String fnumber;
      private String name;
      private String address;
      private LocalDateTime work_out;
      private String customerUnit;
      private String state;
      private String state_name;
      private String parent_number;

      ContractProjectQualificationsDTOBuilder() {
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder fnumber(final String fnumber) {
         this.fnumber = fnumber;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder work_out(final LocalDateTime work_out) {
         this.work_out = work_out;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder state(final String state) {
         this.state = state;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder state_name(final String state_name) {
         this.state_name = state_name;
         return this;
      }

      public ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder parent_number(final String parent_number) {
         this.parent_number = parent_number;
         return this;
      }

      public ContractProjectQualificationsDTO build() {
         return new ContractProjectQualificationsDTO(
            this.fnumber, this.name, this.address, this.work_out, this.customerUnit, this.state, this.state_name, this.parent_number
         );
      }

      @Override
      public String toString() {
         return "ContractProjectQualificationsDTO.ContractProjectQualificationsDTOBuilder(fnumber="
            + this.fnumber
            + ", name="
            + this.name
            + ", address="
            + this.address
            + ", work_out="
            + this.work_out
            + ", customerUnit="
            + this.customerUnit
            + ", state="
            + this.state
            + ", state_name="
            + this.state_name
            + ", parent_number="
            + this.parent_number
            + ")";
      }
   }
}
