package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MesMachineToolConfigSaveDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "partProcessId", value = "数控切割零件工序id", notes = "数控切割零件工序id")
   @NotNull(message = "工序类型不能为空")
   private Long partProcessId;
   @ApiModelProperty(name = "partProcessName", value = "数控切割零件工序名称", notes = "数控切割零件工序名称")
   private String partProcessName;
   @ApiModelProperty(name = "name", value = "机床名称", notes = "机床名称")
   @NotNull(message = "机床名称不能为空")
   private String name;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "serialNumber", value = "设备编号", notes = "设备编号")
   @NotNull(message = "设备编号不能为空")
   private String serialNumber;
   @ApiModelProperty(name = "userName", value = "生产负责人", notes = "生产负责人")
   @NotEmpty(message = "生产负责人不能为空")
   private List<Long> user;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   private Boolean status;

   public static MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder builder() {
      return new MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder();
   }

   public MesMachineToolConfigSaveDTO() {
   }

   public MesMachineToolConfigSaveDTO(
      final Long id,
      final Long partProcessId,
      final String partProcessName,
      final String name,
      final Long workshopId,
      final String serialNumber,
      final List<Long> user,
      final Boolean status
   ) {
      this.id = id;
      this.partProcessId = partProcessId;
      this.partProcessName = partProcessName;
      this.name = name;
      this.workshopId = workshopId;
      this.serialNumber = serialNumber;
      this.user = user;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPartProcessId() {
      return this.partProcessId;
   }

   public String getPartProcessName() {
      return this.partProcessName;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<Long> getUser() {
      return this.user;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPartProcessId(final Long partProcessId) {
      this.partProcessId = partProcessId;
   }

   public void setPartProcessName(final String partProcessName) {
      this.partProcessName = partProcessName;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUser(final List<Long> user) {
      this.user = user;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMachineToolConfigSaveDTO)) {
         return false;
      }

      MesMachineToolConfigSaveDTO other = (MesMachineToolConfigSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partProcessId = this.getPartProcessId();
         Object other$partProcessId = other.getPartProcessId();
         if (this$partProcessId == null ? other$partProcessId == null : this$partProcessId.equals(other$partProcessId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$partProcessName = this.getPartProcessName();
                  Object other$partProcessName = other.getPartProcessName();
                  if (this$partProcessName == null ? other$partProcessName == null : this$partProcessName.equals(other$partProcessName)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$user = this.getUser();
                           Object other$user = other.getUser();
                           return this$user == null ? other$user == null : this$user.equals(other$user);
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
      return other instanceof MesMachineToolConfigSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partProcessId = this.getPartProcessId();
      result = result * 59 + ($partProcessId == null ? 43 : $partProcessId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $partProcessName = this.getPartProcessName();
      result = result * 59 + ($partProcessName == null ? 43 : $partProcessName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   @Override
   public String toString() {
      return "MesMachineToolConfigSaveDTO(id="
         + this.getId()
         + ", partProcessId="
         + this.getPartProcessId()
         + ", partProcessName="
         + this.getPartProcessName()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", user="
         + this.getUser()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class MesMachineToolConfigSaveDTOBuilder {
      private Long id;
      private Long partProcessId;
      private String partProcessName;
      private String name;
      private Long workshopId;
      private String serialNumber;
      private List<Long> user;
      private Boolean status;

      MesMachineToolConfigSaveDTOBuilder() {
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder partProcessId(final Long partProcessId) {
         this.partProcessId = partProcessId;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder partProcessName(final String partProcessName) {
         this.partProcessName = partProcessName;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder user(final List<Long> user) {
         this.user = user;
         return this;
      }

      public MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesMachineToolConfigSaveDTO build() {
         return new MesMachineToolConfigSaveDTO(
            this.id, this.partProcessId, this.partProcessName, this.name, this.workshopId, this.serialNumber, this.user, this.status
         );
      }

      @Override
      public String toString() {
         return "MesMachineToolConfigSaveDTO.MesMachineToolConfigSaveDTOBuilder(id="
            + this.id
            + ", partProcessId="
            + this.partProcessId
            + ", partProcessName="
            + this.partProcessName
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", serialNumber="
            + this.serialNumber
            + ", user="
            + this.user
            + ", status="
            + this.status
            + ")";
      }
   }
}
