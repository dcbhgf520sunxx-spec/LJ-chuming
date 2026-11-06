package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ContractWaste对象", description = "废料合同表 ")
public class ContractWasteDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   private String purchaser;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "lastEditUserId", value = "最近修改人id", notes = "最近修改人id")
   private Long lastEditUserId;
   @ApiModelProperty(name = "lastEditUserName", value = "最近修改人", notes = "最近修改人")
   private String lastEditUserName;
   @ApiModelProperty(name = "lastEditTime", value = "最近修改时间", notes = "最近修改时间")
   private LocalDateTime lastEditTime;

   public static ContractWasteDTO.ContractWasteDTOBuilder builder() {
      return new ContractWasteDTO.ContractWasteDTOBuilder();
   }

   public ContractWasteDTO() {
   }

   public ContractWasteDTO(
      final Long id,
      final String serialNumber,
      final String purchaser,
      final Long userId,
      final String userName,
      final LocalDateTime createTime,
      final Long lastEditUserId,
      final String lastEditUserName,
      final LocalDateTime lastEditTime
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.userId = userId;
      this.userName = userName;
      this.createTime = createTime;
      this.lastEditUserId = lastEditUserId;
      this.lastEditUserName = lastEditUserName;
      this.lastEditTime = lastEditTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getLastEditUserId() {
      return this.lastEditUserId;
   }

   public String getLastEditUserName() {
      return this.lastEditUserName;
   }

   public LocalDateTime getLastEditTime() {
      return this.lastEditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setLastEditUserId(final Long lastEditUserId) {
      this.lastEditUserId = lastEditUserId;
   }

   public void setLastEditUserName(final String lastEditUserName) {
      this.lastEditUserName = lastEditUserName;
   }

   public void setLastEditTime(final LocalDateTime lastEditTime) {
      this.lastEditTime = lastEditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWasteDTO)) {
         return false;
      }

      ContractWasteDTO other = (ContractWasteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$lastEditUserId = this.getLastEditUserId();
            Object other$lastEditUserId = other.getLastEditUserId();
            if (this$lastEditUserId == null ? other$lastEditUserId == null : this$lastEditUserId.equals(other$lastEditUserId)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$purchaser = this.getPurchaser();
                  Object other$purchaser = other.getPurchaser();
                  if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$lastEditUserName = this.getLastEditUserName();
                           Object other$lastEditUserName = other.getLastEditUserName();
                           if (this$lastEditUserName == null ? other$lastEditUserName == null : this$lastEditUserName.equals(other$lastEditUserName)) {
                              Object this$lastEditTime = this.getLastEditTime();
                              Object other$lastEditTime = other.getLastEditTime();
                              return this$lastEditTime == null ? other$lastEditTime == null : this$lastEditTime.equals(other$lastEditTime);
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
      return other instanceof ContractWasteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $lastEditUserId = this.getLastEditUserId();
      result = result * 59 + ($lastEditUserId == null ? 43 : $lastEditUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $lastEditUserName = this.getLastEditUserName();
      result = result * 59 + ($lastEditUserName == null ? 43 : $lastEditUserName.hashCode());
      Object $lastEditTime = this.getLastEditTime();
      return result * 59 + ($lastEditTime == null ? 43 : $lastEditTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWasteDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", lastEditUserId="
         + this.getLastEditUserId()
         + ", lastEditUserName="
         + this.getLastEditUserName()
         + ", lastEditTime="
         + this.getLastEditTime()
         + ")";
   }

   public static class ContractWasteDTOBuilder {
      private Long id;
      private String serialNumber;
      private String purchaser;
      private Long userId;
      private String userName;
      private LocalDateTime createTime;
      private Long lastEditUserId;
      private String lastEditUserName;
      private LocalDateTime lastEditTime;

      ContractWasteDTOBuilder() {
      }

      public ContractWasteDTO.ContractWasteDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder lastEditUserId(final Long lastEditUserId) {
         this.lastEditUserId = lastEditUserId;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder lastEditUserName(final String lastEditUserName) {
         this.lastEditUserName = lastEditUserName;
         return this;
      }

      public ContractWasteDTO.ContractWasteDTOBuilder lastEditTime(final LocalDateTime lastEditTime) {
         this.lastEditTime = lastEditTime;
         return this;
      }

      public ContractWasteDTO build() {
         return new ContractWasteDTO(
            this.id,
            this.serialNumber,
            this.purchaser,
            this.userId,
            this.userName,
            this.createTime,
            this.lastEditUserId,
            this.lastEditUserName,
            this.lastEditTime
         );
      }

      @Override
      public String toString() {
         return "ContractWasteDTO.ContractWasteDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ", lastEditUserId="
            + this.lastEditUserId
            + ", lastEditUserName="
            + this.lastEditUserName
            + ", lastEditTime="
            + this.lastEditTime
            + ")";
      }
   }
}
