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

@ApiModel(value = "MesMachineToolUserLink对象", description = "机床生产负责人关联表")
@Entity
@TableName("mes_machine_tool_user_link")
@Table(name = "mes_machine_tool_user_link")
@org.hibernate.annotations.Table(appliesTo = "mes_machine_tool_user_link", comment = "机床生产负责人关联表")
public class MesMachineToolUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "machineToolId", value = "机床id", notes = "机床id")
   @TableField("machine_tool_id")
   @Column(name = "machine_tool_id", columnDefinition = "int(11)  COMMENT '机床id'", nullable = true)
   private Long machineToolId;
   @ApiModelProperty(name = "userId", value = "生产负责人", notes = "生产负责人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "int(11)  COMMENT '生产负责人'", nullable = true)
   private Long userId;

   public static MesMachineToolUserLink.MesMachineToolUserLinkBuilder builder() {
      return new MesMachineToolUserLink.MesMachineToolUserLinkBuilder();
   }

   public MesMachineToolUserLink() {
   }

   public MesMachineToolUserLink(final Long id, final Long machineToolId, final Long userId) {
      this.id = id;
      this.machineToolId = machineToolId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public MesMachineToolUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesMachineToolUserLink setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   public MesMachineToolUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesMachineToolUserLink(id=" + this.getId() + ", machineToolId=" + this.getMachineToolId() + ", userId=" + this.getUserId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMachineToolUserLink)) {
         return false;
      }

      MesMachineToolUserLink other = (MesMachineToolUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machineToolId = this.getMachineToolId();
         Object other$machineToolId = other.getMachineToolId();
         if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesMachineToolUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesMachineToolUserLinkBuilder {
      private Long id;
      private Long machineToolId;
      private Long userId;

      MesMachineToolUserLinkBuilder() {
      }

      public MesMachineToolUserLink.MesMachineToolUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesMachineToolUserLink.MesMachineToolUserLinkBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      public MesMachineToolUserLink.MesMachineToolUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesMachineToolUserLink build() {
         return new MesMachineToolUserLink(this.id, this.machineToolId, this.userId);
      }

      @Override
      public String toString() {
         return "MesMachineToolUserLink.MesMachineToolUserLinkBuilder(id="
            + this.id
            + ", machineToolId="
            + this.machineToolId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
