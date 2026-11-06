package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("主合同项目列表")
public class ContractProjectPrimeListDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "status", value = "项目状态 0：进行中，1：暂停，2：已完工")
   private Integer status;

   public static ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder builder() {
      return new ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectPrimeListDTO)) {
         return false;
      }

      ContractProjectPrimeListDTO other = (ContractProjectPrimeListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof ContractProjectPrimeListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectPrimeListDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", createTime="
         + this.getCreateTime()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public ContractProjectPrimeListDTO(
      final Long id, final String serialNumber, final String name, final String shortName, final LocalDateTime createTime, final Integer status
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.createTime = createTime;
      this.status = status;
   }

   public ContractProjectPrimeListDTO() {
   }

   public static class ContractProjectPrimeListDTOBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private String shortName;
      private LocalDateTime createTime;
      private Integer status;

      ContractProjectPrimeListDTOBuilder() {
      }

      public ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractProjectPrimeListDTO build() {
         return new ContractProjectPrimeListDTO(this.id, this.serialNumber, this.name, this.shortName, this.createTime, this.status);
      }

      @Override
      public String toString() {
         return "ContractProjectPrimeListDTO.ContractProjectPrimeListDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", createTime="
            + this.createTime
            + ", status="
            + this.status
            + ")";
      }
   }
}
