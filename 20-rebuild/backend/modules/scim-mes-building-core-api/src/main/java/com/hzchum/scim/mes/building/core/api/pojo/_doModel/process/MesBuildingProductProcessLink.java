package com.hzchum.scim.mes.building.core.api.pojo._doModel.process;

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

@ApiModel(value = "MesBuildingProductProcessLink对象", description = "总工序关联工序表 ")
@Entity
@TableName("mes_building_product_process_link")
@Table(name = "mes_building_product_process_link")
public class MesBuildingProductProcessLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productProcessId", value = "产品工序id", notes = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   @TableField("product_process_id")
   @Column(name = "product_process_id", columnDefinition = "bigint(20)  COMMENT '产品工序id'", nullable = false)
   private Long productProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @TableField("sequence")
   @Column(name = "sequence", columnDefinition = "int(11)  COMMENT '工序顺序'", nullable = false)
   private Integer sequence;
   @ApiModelProperty(name = "nodeTime", value = "时间节点", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   @TableField("node_time")
   @Column(name = "node_time", columnDefinition = "int(11) default 0 COMMENT '时间节点'", nullable = false)
   private Integer nodeTime;
   @ApiModelProperty(name = "partProdMode", value = "零件生产方式", notes = "零件生产方式")
   @JsonProperty("partProdMode")
   @JSONField(name = "partProdMode")
   @TableField("part_prod_mode")
   @Column(name = "part_prod_mode", columnDefinition = "int(11)  COMMENT '零件生产方式[1 数控切割 2 半自动切割]'")
   private Integer partProdMode;
   @ApiModelProperty(name = "boolFixedProcess", value = "是否为固定工序[0 灵活工序 1 固定工序 ]", notes = "是否为固定工序[0 灵活工序 1 固定工序 ]")
   @JsonProperty("boolFixedProcess")
   @JSONField(name = "boolFixedProcess")
   @TableField("bool_fixed_process")
   @Column(name = "bool_fixed_process", columnDefinition = "tinyint(1) default '0' COMMENT '是否为固定工序[0 灵活工序 1 固定工序 ]'", nullable = false)
   private Boolean boolFixedProcess;
   @ApiModelProperty(name = "boolParallelProcess", value = "是否为并行工序[0 单工序 1 并行工序 ]", notes = "是否为并行工序[0 单工序 1 并行工序 ]")
   @JsonProperty("boolParallelProcess")
   @JSONField(name = "boolParallelProcess")
   @Column(name = "bool_parallel_process", columnDefinition = "tinyint(1) default '0' COMMENT '是否为并行工序[0 单工序 1 并行工序 ]'", nullable = false)
   private Boolean boolParallelProcess;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "boolHistory", value = "是否历史数据")
   @JsonProperty("boolHistory")
   @JSONField(name = "bool_history")
   @TableField("bool_history")
   @Column(name = "bool_history", columnDefinition = "tinyint(1) default '0' COMMENT '是否历史数据 1是 0否'", nullable = false)
   private Boolean boolHistory;

   public static MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder builder() {
      return new MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder();
   }

   public MesBuildingProductProcessLink() {
   }

   public MesBuildingProductProcessLink(
      final Long id,
      final Long productProcessId,
      final Long processId,
      final Integer sequence,
      final Integer nodeTime,
      final Integer partProdMode,
      final Boolean boolFixedProcess,
      final Boolean boolParallelProcess,
      final Long teamId,
      final Boolean boolHistory
   ) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.sequence = sequence;
      this.nodeTime = nodeTime;
      this.partProdMode = partProdMode;
      this.boolFixedProcess = boolFixedProcess;
      this.boolParallelProcess = boolParallelProcess;
      this.teamId = teamId;
      this.boolHistory = boolHistory;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   public Integer getPartProdMode() {
      return this.partProdMode;
   }

   public Boolean getBoolFixedProcess() {
      return this.boolFixedProcess;
   }

   public Boolean getBoolParallelProcess() {
      return this.boolParallelProcess;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Boolean getBoolHistory() {
      return this.boolHistory;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingProductProcessLink setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProductProcessLink setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingProductProcessLink setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesBuildingProductProcessLink setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @JsonProperty("partProdMode")
   public MesBuildingProductProcessLink setPartProdMode(final Integer partProdMode) {
      this.partProdMode = partProdMode;
      return this;
   }

   @JsonProperty("boolFixedProcess")
   public MesBuildingProductProcessLink setBoolFixedProcess(final Boolean boolFixedProcess) {
      this.boolFixedProcess = boolFixedProcess;
      return this;
   }

   @JsonProperty("boolParallelProcess")
   public MesBuildingProductProcessLink setBoolParallelProcess(final Boolean boolParallelProcess) {
      this.boolParallelProcess = boolParallelProcess;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProductProcessLink setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("boolHistory")
   public MesBuildingProductProcessLink setBoolHistory(final Boolean boolHistory) {
      this.boolHistory = boolHistory;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessLink(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ", nodeTime="
         + this.getNodeTime()
         + ", partProdMode="
         + this.getPartProdMode()
         + ", boolFixedProcess="
         + this.getBoolFixedProcess()
         + ", boolParallelProcess="
         + this.getBoolParallelProcess()
         + ", teamId="
         + this.getTeamId()
         + ", boolHistory="
         + this.getBoolHistory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessLink)) {
         return false;
      }

      MesBuildingProductProcessLink other = (MesBuildingProductProcessLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productProcessId = this.getProductProcessId();
         Object other$productProcessId = other.getProductProcessId();
         if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                  Object this$nodeTime = this.getNodeTime();
                  Object other$nodeTime = other.getNodeTime();
                  if (this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime)) {
                     Object this$partProdMode = this.getPartProdMode();
                     Object other$partProdMode = other.getPartProdMode();
                     if (this$partProdMode == null ? other$partProdMode == null : this$partProdMode.equals(other$partProdMode)) {
                        Object this$boolFixedProcess = this.getBoolFixedProcess();
                        Object other$boolFixedProcess = other.getBoolFixedProcess();
                        if (this$boolFixedProcess == null ? other$boolFixedProcess == null : this$boolFixedProcess.equals(other$boolFixedProcess)) {
                           Object this$boolParallelProcess = this.getBoolParallelProcess();
                           Object other$boolParallelProcess = other.getBoolParallelProcess();
                           if (this$boolParallelProcess == null
                              ? other$boolParallelProcess == null
                              : this$boolParallelProcess.equals(other$boolParallelProcess)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$boolHistory = this.getBoolHistory();
                                 Object other$boolHistory = other.getBoolHistory();
                                 return this$boolHistory == null ? other$boolHistory == null : this$boolHistory.equals(other$boolHistory);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductProcessLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $nodeTime = this.getNodeTime();
      result = result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
      Object $partProdMode = this.getPartProdMode();
      result = result * 59 + ($partProdMode == null ? 43 : $partProdMode.hashCode());
      Object $boolFixedProcess = this.getBoolFixedProcess();
      result = result * 59 + ($boolFixedProcess == null ? 43 : $boolFixedProcess.hashCode());
      Object $boolParallelProcess = this.getBoolParallelProcess();
      result = result * 59 + ($boolParallelProcess == null ? 43 : $boolParallelProcess.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $boolHistory = this.getBoolHistory();
      return result * 59 + ($boolHistory == null ? 43 : $boolHistory.hashCode());
   }

   public static class MesBuildingProductProcessLinkBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private Integer sequence;
      private Integer nodeTime;
      private Integer partProdMode;
      private Boolean boolFixedProcess;
      private Boolean boolParallelProcess;
      private Long teamId;
      private Boolean boolHistory;

      MesBuildingProductProcessLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      @JsonProperty("partProdMode")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder partProdMode(final Integer partProdMode) {
         this.partProdMode = partProdMode;
         return this;
      }

      @JsonProperty("boolFixedProcess")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder boolFixedProcess(final Boolean boolFixedProcess) {
         this.boolFixedProcess = boolFixedProcess;
         return this;
      }

      @JsonProperty("boolParallelProcess")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder boolParallelProcess(final Boolean boolParallelProcess) {
         this.boolParallelProcess = boolParallelProcess;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("boolHistory")
      public MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder boolHistory(final Boolean boolHistory) {
         this.boolHistory = boolHistory;
         return this;
      }

      public MesBuildingProductProcessLink build() {
         return new MesBuildingProductProcessLink(
            this.id,
            this.productProcessId,
            this.processId,
            this.sequence,
            this.nodeTime,
            this.partProdMode,
            this.boolFixedProcess,
            this.boolParallelProcess,
            this.teamId,
            this.boolHistory
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessLink.MesBuildingProductProcessLinkBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", sequence="
            + this.sequence
            + ", nodeTime="
            + this.nodeTime
            + ", partProdMode="
            + this.partProdMode
            + ", boolFixedProcess="
            + this.boolFixedProcess
            + ", boolParallelProcess="
            + this.boolParallelProcess
            + ", teamId="
            + this.teamId
            + ", boolHistory="
            + this.boolHistory
            + ")";
      }
   }
}
