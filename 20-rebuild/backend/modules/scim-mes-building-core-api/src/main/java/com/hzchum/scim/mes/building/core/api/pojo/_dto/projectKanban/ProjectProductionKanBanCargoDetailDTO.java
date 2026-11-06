package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class ProjectProductionKanBanCargoDetailDTO {
   @ApiModelProperty(name = "name", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "cargoSerialNumbers", notes = "车次编号(多个以逗号分隔)")
   @JsonProperty("cargoSerialNumbers")
   @JSONField(name = "cargoSerialNumbers")
   private String cargoSerialNumbers;
   @ApiModelProperty(notes = "车牌")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   private String licensePlate;
   @ApiModelProperty(name = "workShopName", notes = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "userNames", notes = "操作人,多个以逗号分隔")
   @JsonProperty("userNames")
   @JSONField(name = "userNames")
   private String userNames;
   @ApiModelProperty(name = "dateTimes", notes = "操作时间,多个以逗号分隔")
   @JsonProperty("dateTimes")
   @JSONField(name = "dateTime")
   private String dateTimes;

   public static ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder builder() {
      return new ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getCargoSerialNumbers() {
      return this.cargoSerialNumbers;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public String getUserNames() {
      return this.userNames;
   }

   public String getDateTimes() {
      return this.dateTimes;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("status")
   public void setStatus(final Integer status) {
      this.status = status;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("cargoSerialNumbers")
   public void setCargoSerialNumbers(final String cargoSerialNumbers) {
      this.cargoSerialNumbers = cargoSerialNumbers;
   }

   @JsonProperty("licensePlate")
   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("userNames")
   public void setUserNames(final String userNames) {
      this.userNames = userNames;
   }

   @JsonProperty("dateTimes")
   public void setDateTimes(final String dateTimes) {
      this.dateTimes = dateTimes;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionKanBanCargoDetailDTO)) {
         return false;
      }

      ProjectProductionKanBanCargoDetailDTO other = (ProjectProductionKanBanCargoDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$cargoSerialNumbers = this.getCargoSerialNumbers();
                     Object other$cargoSerialNumbers = other.getCargoSerialNumbers();
                     if (this$cargoSerialNumbers == null ? other$cargoSerialNumbers == null : this$cargoSerialNumbers.equals(other$cargoSerialNumbers)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                           Object this$workShopName = this.getWorkShopName();
                           Object other$workShopName = other.getWorkShopName();
                           if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                              Object this$userNames = this.getUserNames();
                              Object other$userNames = other.getUserNames();
                              if (this$userNames == null ? other$userNames == null : this$userNames.equals(other$userNames)) {
                                 Object this$dateTimes = this.getDateTimes();
                                 Object other$dateTimes = other.getDateTimes();
                                 return this$dateTimes == null ? other$dateTimes == null : this$dateTimes.equals(other$dateTimes);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectProductionKanBanCargoDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $cargoSerialNumbers = this.getCargoSerialNumbers();
      result = result * 59 + ($cargoSerialNumbers == null ? 43 : $cargoSerialNumbers.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $userNames = this.getUserNames();
      result = result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
      Object $dateTimes = this.getDateTimes();
      return result * 59 + ($dateTimes == null ? 43 : $dateTimes.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionKanBanCargoDetailDTO(name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", status="
         + this.getStatus()
         + ", quantity="
         + this.getQuantity()
         + ", cargoSerialNumbers="
         + this.getCargoSerialNumbers()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", workShopName="
         + this.getWorkShopName()
         + ", userNames="
         + this.getUserNames()
         + ", dateTimes="
         + this.getDateTimes()
         + ")";
   }

   public ProjectProductionKanBanCargoDetailDTO() {
   }

   public ProjectProductionKanBanCargoDetailDTO(
      final String name,
      final String serialNumber,
      final String specification,
      final Integer status,
      final Integer quantity,
      final String cargoSerialNumbers,
      final String licensePlate,
      final String workShopName,
      final String userNames,
      final String dateTimes
   ) {
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.status = status;
      this.quantity = quantity;
      this.cargoSerialNumbers = cargoSerialNumbers;
      this.licensePlate = licensePlate;
      this.workShopName = workShopName;
      this.userNames = userNames;
      this.dateTimes = dateTimes;
   }

   public static class ProjectProductionKanBanCargoDetailDTOBuilder {
      private String name;
      private String serialNumber;
      private String specification;
      private Integer status;
      private Integer quantity;
      private String cargoSerialNumbers;
      private String licensePlate;
      private String workShopName;
      private String userNames;
      private String dateTimes;

      ProjectProductionKanBanCargoDetailDTOBuilder() {
      }

      @JsonProperty("name")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("status")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("cargoSerialNumbers")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder cargoSerialNumbers(final String cargoSerialNumbers) {
         this.cargoSerialNumbers = cargoSerialNumbers;
         return this;
      }

      @JsonProperty("licensePlate")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("workShopName")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("userNames")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder userNames(final String userNames) {
         this.userNames = userNames;
         return this;
      }

      @JsonProperty("dateTimes")
      public ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder dateTimes(final String dateTimes) {
         this.dateTimes = dateTimes;
         return this;
      }

      public ProjectProductionKanBanCargoDetailDTO build() {
         return new ProjectProductionKanBanCargoDetailDTO(
            this.name,
            this.serialNumber,
            this.specification,
            this.status,
            this.quantity,
            this.cargoSerialNumbers,
            this.licensePlate,
            this.workShopName,
            this.userNames,
            this.dateTimes
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionKanBanCargoDetailDTO.ProjectProductionKanBanCargoDetailDTOBuilder(name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", status="
            + this.status
            + ", quantity="
            + this.quantity
            + ", cargoSerialNumbers="
            + this.cargoSerialNumbers
            + ", licensePlate="
            + this.licensePlate
            + ", workShopName="
            + this.workShopName
            + ", userNames="
            + this.userNames
            + ", dateTimes="
            + this.dateTimes
            + ")";
      }
   }
}
