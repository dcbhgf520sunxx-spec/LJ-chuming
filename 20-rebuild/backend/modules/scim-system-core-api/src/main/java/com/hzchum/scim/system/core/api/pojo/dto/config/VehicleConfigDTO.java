package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class VehicleConfigDTO {
   @ApiModelProperty("自动获取车牌")
   private boolean showPlateAGButton;
   @ApiModelProperty("空车获取毛重")
   private boolean showEmptyTruckAGButton;
   @ApiModelProperty("空车手工录入毛重")
   private boolean showEmptyTruckMEButton;
   @ApiModelProperty("满载车获取毛重")
   private boolean showFullTruckAGButton;
   @ApiModelProperty("满载车手工录入毛重")
   private boolean showFullTruckMEButton;
   @ApiModelProperty("车牌获取重量")
   private boolean boolGetWeightByPlate;
   @ApiModelProperty("地磅获取毛重")
   private boolean boolGetWeightByDevice;
   private Long requestLimitingTime;

   public static VehicleConfigDTO.VehicleConfigDTOBuilder builder() {
      return new VehicleConfigDTO.VehicleConfigDTOBuilder();
   }

   public boolean isShowPlateAGButton() {
      return this.showPlateAGButton;
   }

   public boolean isShowEmptyTruckAGButton() {
      return this.showEmptyTruckAGButton;
   }

   public boolean isShowEmptyTruckMEButton() {
      return this.showEmptyTruckMEButton;
   }

   public boolean isShowFullTruckAGButton() {
      return this.showFullTruckAGButton;
   }

   public boolean isShowFullTruckMEButton() {
      return this.showFullTruckMEButton;
   }

   public boolean isBoolGetWeightByPlate() {
      return this.boolGetWeightByPlate;
   }

   public boolean isBoolGetWeightByDevice() {
      return this.boolGetWeightByDevice;
   }

   public Long getRequestLimitingTime() {
      return this.requestLimitingTime;
   }

   public void setShowPlateAGButton(final boolean showPlateAGButton) {
      this.showPlateAGButton = showPlateAGButton;
   }

   public void setShowEmptyTruckAGButton(final boolean showEmptyTruckAGButton) {
      this.showEmptyTruckAGButton = showEmptyTruckAGButton;
   }

   public void setShowEmptyTruckMEButton(final boolean showEmptyTruckMEButton) {
      this.showEmptyTruckMEButton = showEmptyTruckMEButton;
   }

   public void setShowFullTruckAGButton(final boolean showFullTruckAGButton) {
      this.showFullTruckAGButton = showFullTruckAGButton;
   }

   public void setShowFullTruckMEButton(final boolean showFullTruckMEButton) {
      this.showFullTruckMEButton = showFullTruckMEButton;
   }

   public void setBoolGetWeightByPlate(final boolean boolGetWeightByPlate) {
      this.boolGetWeightByPlate = boolGetWeightByPlate;
   }

   public void setBoolGetWeightByDevice(final boolean boolGetWeightByDevice) {
      this.boolGetWeightByDevice = boolGetWeightByDevice;
   }

   public void setRequestLimitingTime(final Long requestLimitingTime) {
      this.requestLimitingTime = requestLimitingTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof VehicleConfigDTO)) {
         return false;
      }

      VehicleConfigDTO other = (VehicleConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isShowPlateAGButton() != other.isShowPlateAGButton()) {
         return false;
      }

      if (this.isShowEmptyTruckAGButton() != other.isShowEmptyTruckAGButton()) {
         return false;
      }

      if (this.isShowEmptyTruckMEButton() != other.isShowEmptyTruckMEButton()) {
         return false;
      }

      if (this.isShowFullTruckAGButton() != other.isShowFullTruckAGButton()) {
         return false;
      }

      if (this.isShowFullTruckMEButton() != other.isShowFullTruckMEButton()) {
         return false;
      }

      if (this.isBoolGetWeightByPlate() != other.isBoolGetWeightByPlate()) {
         return false;
      }

      if (this.isBoolGetWeightByDevice() != other.isBoolGetWeightByDevice()) {
         return false;
      }

      Object this$requestLimitingTime = this.getRequestLimitingTime();
      Object other$requestLimitingTime = other.getRequestLimitingTime();
      return this$requestLimitingTime == null ? other$requestLimitingTime == null : this$requestLimitingTime.equals(other$requestLimitingTime);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof VehicleConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isShowPlateAGButton() ? 79 : 97);
      result = result * 59 + (this.isShowEmptyTruckAGButton() ? 79 : 97);
      result = result * 59 + (this.isShowEmptyTruckMEButton() ? 79 : 97);
      result = result * 59 + (this.isShowFullTruckAGButton() ? 79 : 97);
      result = result * 59 + (this.isShowFullTruckMEButton() ? 79 : 97);
      result = result * 59 + (this.isBoolGetWeightByPlate() ? 79 : 97);
      result = result * 59 + (this.isBoolGetWeightByDevice() ? 79 : 97);
      Object $requestLimitingTime = this.getRequestLimitingTime();
      return result * 59 + ($requestLimitingTime == null ? 43 : $requestLimitingTime.hashCode());
   }

   @Override
   public String toString() {
      return "VehicleConfigDTO(showPlateAGButton="
         + this.isShowPlateAGButton()
         + ", showEmptyTruckAGButton="
         + this.isShowEmptyTruckAGButton()
         + ", showEmptyTruckMEButton="
         + this.isShowEmptyTruckMEButton()
         + ", showFullTruckAGButton="
         + this.isShowFullTruckAGButton()
         + ", showFullTruckMEButton="
         + this.isShowFullTruckMEButton()
         + ", boolGetWeightByPlate="
         + this.isBoolGetWeightByPlate()
         + ", boolGetWeightByDevice="
         + this.isBoolGetWeightByDevice()
         + ", requestLimitingTime="
         + this.getRequestLimitingTime()
         + ")";
   }

   public VehicleConfigDTO(
      final boolean showPlateAGButton,
      final boolean showEmptyTruckAGButton,
      final boolean showEmptyTruckMEButton,
      final boolean showFullTruckAGButton,
      final boolean showFullTruckMEButton,
      final boolean boolGetWeightByPlate,
      final boolean boolGetWeightByDevice,
      final Long requestLimitingTime
   ) {
      this.showPlateAGButton = showPlateAGButton;
      this.showEmptyTruckAGButton = showEmptyTruckAGButton;
      this.showEmptyTruckMEButton = showEmptyTruckMEButton;
      this.showFullTruckAGButton = showFullTruckAGButton;
      this.showFullTruckMEButton = showFullTruckMEButton;
      this.boolGetWeightByPlate = boolGetWeightByPlate;
      this.boolGetWeightByDevice = boolGetWeightByDevice;
      this.requestLimitingTime = requestLimitingTime;
   }

   public VehicleConfigDTO() {
   }

   public static class VehicleConfigDTOBuilder {
      private boolean showPlateAGButton;
      private boolean showEmptyTruckAGButton;
      private boolean showEmptyTruckMEButton;
      private boolean showFullTruckAGButton;
      private boolean showFullTruckMEButton;
      private boolean boolGetWeightByPlate;
      private boolean boolGetWeightByDevice;
      private Long requestLimitingTime;

      VehicleConfigDTOBuilder() {
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder showPlateAGButton(final boolean showPlateAGButton) {
         this.showPlateAGButton = showPlateAGButton;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder showEmptyTruckAGButton(final boolean showEmptyTruckAGButton) {
         this.showEmptyTruckAGButton = showEmptyTruckAGButton;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder showEmptyTruckMEButton(final boolean showEmptyTruckMEButton) {
         this.showEmptyTruckMEButton = showEmptyTruckMEButton;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder showFullTruckAGButton(final boolean showFullTruckAGButton) {
         this.showFullTruckAGButton = showFullTruckAGButton;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder showFullTruckMEButton(final boolean showFullTruckMEButton) {
         this.showFullTruckMEButton = showFullTruckMEButton;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder boolGetWeightByPlate(final boolean boolGetWeightByPlate) {
         this.boolGetWeightByPlate = boolGetWeightByPlate;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder boolGetWeightByDevice(final boolean boolGetWeightByDevice) {
         this.boolGetWeightByDevice = boolGetWeightByDevice;
         return this;
      }

      public VehicleConfigDTO.VehicleConfigDTOBuilder requestLimitingTime(final Long requestLimitingTime) {
         this.requestLimitingTime = requestLimitingTime;
         return this;
      }

      public VehicleConfigDTO build() {
         return new VehicleConfigDTO(
            this.showPlateAGButton,
            this.showEmptyTruckAGButton,
            this.showEmptyTruckMEButton,
            this.showFullTruckAGButton,
            this.showFullTruckMEButton,
            this.boolGetWeightByPlate,
            this.boolGetWeightByDevice,
            this.requestLimitingTime
         );
      }

      @Override
      public String toString() {
         return "VehicleConfigDTO.VehicleConfigDTOBuilder(showPlateAGButton="
            + this.showPlateAGButton
            + ", showEmptyTruckAGButton="
            + this.showEmptyTruckAGButton
            + ", showEmptyTruckMEButton="
            + this.showEmptyTruckMEButton
            + ", showFullTruckAGButton="
            + this.showFullTruckAGButton
            + ", showFullTruckMEButton="
            + this.showFullTruckMEButton
            + ", boolGetWeightByPlate="
            + this.boolGetWeightByPlate
            + ", boolGetWeightByDevice="
            + this.boolGetWeightByDevice
            + ", requestLimitingTime="
            + this.requestLimitingTime
            + ")";
      }
   }
}
