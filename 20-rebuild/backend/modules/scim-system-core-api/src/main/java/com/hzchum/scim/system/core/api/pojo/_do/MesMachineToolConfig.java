package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesMachineToolConfig对象", description = "机床配置")
@Entity
@TableName("mes_machine_tool_config")
@Table(name = "mes_machine_tool_config")
@org.hibernate.annotations.Table(appliesTo = "mes_machine_tool_config", comment = "机床配置")
public class MesMachineToolConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "partProcessId", value = "数控切割零件工序id", notes = "数控切割零件工序id")
   @TableField("part_process_id")
   @Column(name = "part_process_id", columnDefinition = "bigint(20)  COMMENT '数控切割零件工序id'", nullable = false)
   private Long partProcessId;
   @ApiModelProperty(name = "name", value = "机床名称", notes = "机床名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '机床名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "serialNumber", value = "设备编号", notes = "设备编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '设备编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "userId", value = "生产负责人", notes = "生产负责人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "int(11)  COMMENT '生产负责人'", nullable = true)
   private Integer userId;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '0' COMMENT '状态  0 未冻结 1 冻结'", nullable = false)
   private Boolean status;

   public static MesMachineToolConfig.MesMachineToolConfigBuilder builder() {
      return new MesMachineToolConfig.MesMachineToolConfigBuilder();
   }

   public MesMachineToolConfig() {
   }

   public MesMachineToolConfig(
      final Long id, final Long partProcessId, final String name, final Long workshopId, final String serialNumber, final Integer userId, final Boolean status
   ) {
      this.id = id;
      this.partProcessId = partProcessId;
      this.name = name;
      this.workshopId = workshopId;
      this.serialNumber = serialNumber;
      this.userId = userId;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPartProcessId() {
      return this.partProcessId;
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

   public Integer getUserId() {
      return this.userId;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesMachineToolConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesMachineToolConfig setPartProcessId(final Long partProcessId) {
      this.partProcessId = partProcessId;
      return this;
   }

   public MesMachineToolConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public MesMachineToolConfig setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesMachineToolConfig setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesMachineToolConfig setUserId(final Integer userId) {
      this.userId = userId;
      return this;
   }

   public MesMachineToolConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesMachineToolConfig(id="
         + this.getId()
         + ", partProcessId="
         + this.getPartProcessId()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", userId="
         + this.getUserId()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMachineToolConfig)) {
         return false;
      }

      MesMachineToolConfig other = (MesMachineToolConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesMachineToolConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partProcessId = this.getPartProcessId();
      result = result * 59 + ($partProcessId == null ? 43 : $partProcessId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class MesMachineToolConfigBuilder {
      private Long id;
      private Long partProcessId;
      private String name;
      private Long workshopId;
      private String serialNumber;
      private Integer userId;
      private Boolean status;

      MesMachineToolConfigBuilder() {
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder partProcessId(final Long partProcessId) {
         this.partProcessId = partProcessId;
         return this;
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder userId(final Integer userId) {
         this.userId = userId;
         return this;
      }

      public MesMachineToolConfig.MesMachineToolConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesMachineToolConfig build() {
         return new MesMachineToolConfig(this.id, this.partProcessId, this.name, this.workshopId, this.serialNumber, this.userId, this.status);
      }

      @Override
      public String toString() {
         return "MesMachineToolConfig.MesMachineToolConfigBuilder(id="
            + this.id
            + ", partProcessId="
            + this.partProcessId
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", serialNumber="
            + this.serialNumber
            + ", userId="
            + this.userId
            + ", status="
            + this.status
            + ")";
      }
   }
}
