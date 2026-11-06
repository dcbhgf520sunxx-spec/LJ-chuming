package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleUser;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MesMachineToolConfigDTO {
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
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @NotNull(message = "车间id不能为空")
   private SimpleWorkShopDTO workshop;
   @ApiModelProperty(name = "serialNumber", value = "设备编号", notes = "设备编号")
   @NotNull(message = "设备编号不能为空")
   private String serialNumber;
   @ApiModelProperty(name = "userName", value = "生产负责人", notes = "生产负责人")
   @NotEmpty(message = "生产负责人不能为空")
   private List<SimpleUser> user;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   private Boolean status;

   public static MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder builder() {
      return new MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder();
   }

   public MesMachineToolConfigDTO() {
   }

   public MesMachineToolConfigDTO(
      final Long id,
      final Long partProcessId,
      final String partProcessName,
      final String name,
      final SimpleWorkShopDTO workshop,
      final String serialNumber,
      final List<SimpleUser> user,
      final Boolean status
   ) {
      this.id = id;
      this.partProcessId = partProcessId;
      this.partProcessName = partProcessName;
      this.name = name;
      this.workshop = workshop;
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

   public SimpleWorkShopDTO getWorkshop() {
      return this.workshop;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<SimpleUser> getUser() {
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

   public void setWorkshop(final SimpleWorkShopDTO workshop) {
      this.workshop = workshop;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUser(final List<SimpleUser> user) {
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

      if (!(o instanceof MesMachineToolConfigDTO)) {
         return false;
      }

      MesMachineToolConfigDTO other = (MesMachineToolConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partProcessId = this.getPartProcessId();
         Object other$partProcessId = other.getPartProcessId();
         if (this$partProcessId == null ? other$partProcessId == null : this$partProcessId.equals(other$partProcessId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$partProcessName = this.getPartProcessName();
               Object other$partProcessName = other.getPartProcessName();
               if (this$partProcessName == null ? other$partProcessName == null : this$partProcessName.equals(other$partProcessName)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
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
      return other instanceof MesMachineToolConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partProcessId = this.getPartProcessId();
      result = result * 59 + ($partProcessId == null ? 43 : $partProcessId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $partProcessName = this.getPartProcessName();
      result = result * 59 + ($partProcessName == null ? 43 : $partProcessName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   @Override
   public String toString() {
      return "MesMachineToolConfigDTO(id="
         + this.getId()
         + ", partProcessId="
         + this.getPartProcessId()
         + ", partProcessName="
         + this.getPartProcessName()
         + ", name="
         + this.getName()
         + ", workshop="
         + this.getWorkshop()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", user="
         + this.getUser()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class MesMachineToolConfigDTOBuilder {
      private Long id;
      private Long partProcessId;
      private String partProcessName;
      private String name;
      private SimpleWorkShopDTO workshop;
      private String serialNumber;
      private List<SimpleUser> user;
      private Boolean status;

      MesMachineToolConfigDTOBuilder() {
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder partProcessId(final Long partProcessId) {
         this.partProcessId = partProcessId;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder partProcessName(final String partProcessName) {
         this.partProcessName = partProcessName;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder workshop(final SimpleWorkShopDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder user(final List<SimpleUser> user) {
         this.user = user;
         return this;
      }

      public MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesMachineToolConfigDTO build() {
         return new MesMachineToolConfigDTO(
            this.id, this.partProcessId, this.partProcessName, this.name, this.workshop, this.serialNumber, this.user, this.status
         );
      }

      @Override
      public String toString() {
         return "MesMachineToolConfigDTO.MesMachineToolConfigDTOBuilder(id="
            + this.id
            + ", partProcessId="
            + this.partProcessId
            + ", partProcessName="
            + this.partProcessName
            + ", name="
            + this.name
            + ", workshop="
            + this.workshop
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
