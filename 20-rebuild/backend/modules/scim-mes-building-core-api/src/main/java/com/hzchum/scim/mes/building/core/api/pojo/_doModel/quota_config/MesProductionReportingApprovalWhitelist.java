package com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config;

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

@ApiModel(value = "MesProductionReportingApprovalWhitelist对象", description = "报工审核白名单表")
@Entity
@TableName("mes_production_reporting_approval_whitelist")
@Table(name = "mes_production_reporting_approval_whitelist")
@org.hibernate.annotations.Table(appliesTo = "mes_production_reporting_approval_whitelist", comment = "报工审核白名单表")
public class MesProductionReportingApprovalWhitelist extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("车间ids")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(500) COMMENT '车间ids'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty("班组ids")
   @TableField("team_ids")
   @Column(name = "team_ids", columnDefinition = "varchar(500) COMMENT '班组ids'", nullable = true)
   private String teamIds;

   public static MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder builder() {
      return new MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder();
   }

   public MesProductionReportingApprovalWhitelist() {
   }

   public MesProductionReportingApprovalWhitelist(final Long id, final String workshopIds, final Long processId, final String teamIds) {
      this.id = id;
      this.workshopIds = workshopIds;
      this.processId = processId;
      this.teamIds = teamIds;
   }

   public Long getId() {
      return this.id;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getTeamIds() {
      return this.teamIds;
   }

   public MesProductionReportingApprovalWhitelist setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesProductionReportingApprovalWhitelist setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesProductionReportingApprovalWhitelist setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesProductionReportingApprovalWhitelist setTeamIds(final String teamIds) {
      this.teamIds = teamIds;
      return this;
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalWhitelist(id="
         + this.getId()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", processId="
         + this.getProcessId()
         + ", teamIds="
         + this.getTeamIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalWhitelist)) {
         return false;
      }

      MesProductionReportingApprovalWhitelist other = (MesProductionReportingApprovalWhitelist)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$workshopIds = this.getWorkshopIds();
            Object other$workshopIds = other.getWorkshopIds();
            if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
               Object this$teamIds = this.getTeamIds();
               Object other$teamIds = other.getTeamIds();
               return this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds);
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
      return other instanceof MesProductionReportingApprovalWhitelist;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $teamIds = this.getTeamIds();
      return result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
   }

   public static class MesProductionReportingApprovalWhitelistBuilder {
      private Long id;
      private String workshopIds;
      private Long processId;
      private String teamIds;

      MesProductionReportingApprovalWhitelistBuilder() {
      }

      public MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder teamIds(final String teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      public MesProductionReportingApprovalWhitelist build() {
         return new MesProductionReportingApprovalWhitelist(this.id, this.workshopIds, this.processId, this.teamIds);
      }

      @Override
      public String toString() {
         return "MesProductionReportingApprovalWhitelist.MesProductionReportingApprovalWhitelistBuilder(id="
            + this.id
            + ", workshopIds="
            + this.workshopIds
            + ", processId="
            + this.processId
            + ", teamIds="
            + this.teamIds
            + ")";
      }
   }
}
