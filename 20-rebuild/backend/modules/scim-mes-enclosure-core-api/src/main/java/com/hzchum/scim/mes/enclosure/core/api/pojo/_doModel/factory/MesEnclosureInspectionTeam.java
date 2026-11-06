package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureInspectionTeam对象", description = "")
@Entity
@TableName("mes_enclosure_inspection_team")
@Table(name = "mes_enclosure_inspection_team")
public class MesEnclosureInspectionTeam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;

   public static MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder builder() {
      return new MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder();
   }

   public MesEnclosureInspectionTeam() {
   }

   public MesEnclosureInspectionTeam(final Long id, final Long factoryId, final Long processId, final Long userId) {
      this.id = id;
      this.factoryId = factoryId;
      this.processId = processId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesEnclosureInspectionTeam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureInspectionTeam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureInspectionTeam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureInspectionTeam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureInspectionTeam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", processId="
         + this.getProcessId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureInspectionTeam)) {
         return false;
      }

      MesEnclosureInspectionTeam other = (MesEnclosureInspectionTeam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof MesEnclosureInspectionTeam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesEnclosureInspectionTeamBuilder {
      private Long id;
      private Long factoryId;
      private Long processId;
      private Long userId;

      MesEnclosureInspectionTeamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesEnclosureInspectionTeam build() {
         return new MesEnclosureInspectionTeam(this.id, this.factoryId, this.processId, this.userId);
      }

      @Override
      public String toString() {
         return "MesEnclosureInspectionTeam.MesEnclosureInspectionTeamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
