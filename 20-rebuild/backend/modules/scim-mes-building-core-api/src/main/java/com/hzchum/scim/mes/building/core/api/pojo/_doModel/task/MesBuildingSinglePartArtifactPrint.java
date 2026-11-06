package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

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

@ApiModel(value = "MesBuildingSinglePartArtifactPrint对象", description = "")
@Entity
@TableName("mes_building_single_part_artifact_print")
@Table(name = "mes_building_single_part_artifact_print")
@org.hibernate.annotations.Table(appliesTo = "mes_building_single_part_artifact_print", comment = "可打印上报产品表 ")
public class MesBuildingSinglePartArtifactPrint extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "taskId", value = "构件任务id", notes = "构件任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '构件任务id'")
   private Long taskId;
   @ApiModelProperty(name = "partTaskId", value = "零件或部件任务id", notes = "零件或部件任务id")
   @JsonProperty("partTaskId")
   @JSONField(name = "partTaskId")
   @TableField("part_task_id")
   @Column(name = "part_task_id", columnDefinition = "bigint(20)  COMMENT '零件或部件任务id'")
   private Long partTaskId;
   @ApiModelProperty(name = "taskQuantity", value = "下发数", notes = "下发数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @TableField("task_quantity")
   @Column(name = "task_quantity", columnDefinition = "int(11)  COMMENT '下发数'")
   private Integer taskQuantity;
   @ApiModelProperty(name = "quantity", value = "可入库数量", notes = "可入库数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '可入库数量'")
   private Integer quantity;
   @ApiModelProperty(name = "reportQuantity", value = "已打印入库数量", notes = "已入库数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   @TableField("report_quantity")
   @Column(name = "report_quantity", columnDefinition = "int(11) default '0' COMMENT '已入库数量'")
   private Integer reportQuantity;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'")
   private Long teamId;
   @ApiModelProperty(name = "number", value = "一物一码编号", notes = "一物一码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '一物一码编号'")
   private Integer number;
   @ApiModelProperty(name = "bool_all_report", value = "是否全部入库", notes = "是否全部入库")
   @JsonProperty("bool_all_report")
   @JSONField(name = "bool_all_report")
   @TableField("bool_all_report")
   @Column(name = "bool_all_report", columnDefinition = "tinyint(1) default '0' COMMENT '是否全部入库'")
   private Boolean boolAllReport;
   @ApiModelProperty(name = "completeId", value = "完成id", notes = "完成id")
   @JsonProperty("completeId")
   @JSONField(name = "completeId")
   @TableField("complete_id")
   @Column(name = "complete_id", columnDefinition = "bigint(20)  COMMENT '完成id'")
   private Long completeId;
   @ApiModelProperty(name = "bool_assist", value = "是否是外协构件", notes = "是否是外协构件")
   @JsonProperty("bool_assist")
   @JSONField(name = "bool_assist")
   @TableField("bool_assist")
   @Column(name = "bool_assist", columnDefinition = "tinyint(1) default '0' COMMENT '是否是外协构件 0:否 1:4'")
   private Boolean boolAssist;
   @ApiModelProperty(value = "操作人(外协采购人,生产人)ID", notes = "操作人(外协采购人,生产人)ID")
   @JsonProperty("operationId")
   @JSONField(name = "operationId")
   @TableField("operation_id")
   @Column(name = "operation_id", columnDefinition = "bigint(20)  COMMENT '操作人(外协采购人,生产人)ID'")
   private Long operationId;
   @ApiModelProperty(name = "warehousingType", value = "外协产品采购类型", notes = "外协产品采购类型")
   @JsonProperty("warehousingType")
   @JSONField(name = "warehousingType")
   @TableField("warehousing_type")
   @Column(name = "warehousing_type", columnDefinition = "int(11)  COMMENT '外协产品类型 0:非及入及出  1:及入及出'")
   private Integer warehousingType;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "boolSendPurlin", value = "是否是直发类型的檩条", notes = "是否是直发类型的檩条")
   @JsonProperty("boolSendPurlin")
   @JSONField(name = "boolSendPurlin")
   @TableField("bool_send_purlin")
   @Column(name = "bool_send_purlin", columnDefinition = "tinyint(1) default '0' COMMENT '是否是直发类型的檩条 0:否 1:是'")
   private Boolean boolSendPurlin;

   public static MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder builder() {
      return new MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder();
   }

   public MesBuildingSinglePartArtifactPrint() {
   }

   public MesBuildingSinglePartArtifactPrint(
      final Long id,
      final Long productId,
      final Long taskId,
      final Long partTaskId,
      final Integer taskQuantity,
      final Integer quantity,
      final Integer reportQuantity,
      final Long groupsId,
      final Long teamId,
      final Integer number,
      final Boolean boolAllReport,
      final Long completeId,
      final Boolean boolAssist,
      final Long operationId,
      final Integer warehousingType,
      final Long workshopId,
      final Boolean boolSendPurlin
   ) {
      this.id = id;
      this.productId = productId;
      this.taskId = taskId;
      this.partTaskId = partTaskId;
      this.taskQuantity = taskQuantity;
      this.quantity = quantity;
      this.reportQuantity = reportQuantity;
      this.groupsId = groupsId;
      this.teamId = teamId;
      this.number = number;
      this.boolAllReport = boolAllReport;
      this.completeId = completeId;
      this.boolAssist = boolAssist;
      this.operationId = operationId;
      this.warehousingType = warehousingType;
      this.workshopId = workshopId;
      this.boolSendPurlin = boolSendPurlin;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getPartTaskId() {
      return this.partTaskId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Boolean getBoolAllReport() {
      return this.boolAllReport;
   }

   public Long getCompleteId() {
      return this.completeId;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public Long getOperationId() {
      return this.operationId;
   }

   public Integer getWarehousingType() {
      return this.warehousingType;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Boolean getBoolSendPurlin() {
      return this.boolSendPurlin;
   }

   @JsonProperty("id")
   public MesBuildingSinglePartArtifactPrint setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingSinglePartArtifactPrint setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingSinglePartArtifactPrint setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("partTaskId")
   public MesBuildingSinglePartArtifactPrint setPartTaskId(final Long partTaskId) {
      this.partTaskId = partTaskId;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingSinglePartArtifactPrint setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingSinglePartArtifactPrint setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("reportQuantity")
   public MesBuildingSinglePartArtifactPrint setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingSinglePartArtifactPrint setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingSinglePartArtifactPrint setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingSinglePartArtifactPrint setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("bool_all_report")
   public MesBuildingSinglePartArtifactPrint setBoolAllReport(final Boolean boolAllReport) {
      this.boolAllReport = boolAllReport;
      return this;
   }

   @JsonProperty("completeId")
   public MesBuildingSinglePartArtifactPrint setCompleteId(final Long completeId) {
      this.completeId = completeId;
      return this;
   }

   @JsonProperty("bool_assist")
   public MesBuildingSinglePartArtifactPrint setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
      return this;
   }

   @JsonProperty("operationId")
   public MesBuildingSinglePartArtifactPrint setOperationId(final Long operationId) {
      this.operationId = operationId;
      return this;
   }

   @JsonProperty("warehousingType")
   public MesBuildingSinglePartArtifactPrint setWarehousingType(final Integer warehousingType) {
      this.warehousingType = warehousingType;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingSinglePartArtifactPrint setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("boolSendPurlin")
   public MesBuildingSinglePartArtifactPrint setBoolSendPurlin(final Boolean boolSendPurlin) {
      this.boolSendPurlin = boolSendPurlin;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSinglePartArtifactPrint(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", taskId="
         + this.getTaskId()
         + ", partTaskId="
         + this.getPartTaskId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
         + ", number="
         + this.getNumber()
         + ", boolAllReport="
         + this.getBoolAllReport()
         + ", completeId="
         + this.getCompleteId()
         + ", boolAssist="
         + this.getBoolAssist()
         + ", operationId="
         + this.getOperationId()
         + ", warehousingType="
         + this.getWarehousingType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", boolSendPurlin="
         + this.getBoolSendPurlin()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSinglePartArtifactPrint)) {
         return false;
      }

      MesBuildingSinglePartArtifactPrint other = (MesBuildingSinglePartArtifactPrint)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$partTaskId = this.getPartTaskId();
               Object other$partTaskId = other.getPartTaskId();
               if (this$partTaskId == null ? other$partTaskId == null : this$partTaskId.equals(other$partTaskId)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$reportQuantity = this.getReportQuantity();
                        Object other$reportQuantity = other.getReportQuantity();
                        if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                           Object this$groupsId = this.getGroupsId();
                           Object other$groupsId = other.getGroupsId();
                           if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$boolAllReport = this.getBoolAllReport();
                                    Object other$boolAllReport = other.getBoolAllReport();
                                    if (this$boolAllReport == null ? other$boolAllReport == null : this$boolAllReport.equals(other$boolAllReport)) {
                                       Object this$completeId = this.getCompleteId();
                                       Object other$completeId = other.getCompleteId();
                                       if (this$completeId == null ? other$completeId == null : this$completeId.equals(other$completeId)) {
                                          Object this$boolAssist = this.getBoolAssist();
                                          Object other$boolAssist = other.getBoolAssist();
                                          if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
                                             Object this$operationId = this.getOperationId();
                                             Object other$operationId = other.getOperationId();
                                             if (this$operationId == null ? other$operationId == null : this$operationId.equals(other$operationId)) {
                                                Object this$warehousingType = this.getWarehousingType();
                                                Object other$warehousingType = other.getWarehousingType();
                                                if (this$warehousingType == null
                                                   ? other$warehousingType == null
                                                   : this$warehousingType.equals(other$warehousingType)) {
                                                   Object this$workshopId = this.getWorkshopId();
                                                   Object other$workshopId = other.getWorkshopId();
                                                   if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                      Object this$boolSendPurlin = this.getBoolSendPurlin();
                                                      Object other$boolSendPurlin = other.getBoolSendPurlin();
                                                      return this$boolSendPurlin == null
                                                         ? other$boolSendPurlin == null
                                                         : this$boolSendPurlin.equals(other$boolSendPurlin);
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
      return other instanceof MesBuildingSinglePartArtifactPrint;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $partTaskId = this.getPartTaskId();
      result = result * 59 + ($partTaskId == null ? 43 : $partTaskId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolAllReport = this.getBoolAllReport();
      result = result * 59 + ($boolAllReport == null ? 43 : $boolAllReport.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $operationId = this.getOperationId();
      result = result * 59 + ($operationId == null ? 43 : $operationId.hashCode());
      Object $warehousingType = this.getWarehousingType();
      result = result * 59 + ($warehousingType == null ? 43 : $warehousingType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolSendPurlin = this.getBoolSendPurlin();
      return result * 59 + ($boolSendPurlin == null ? 43 : $boolSendPurlin.hashCode());
   }

   public static class MesBuildingSinglePartArtifactPrintBuilder {
      private Long id;
      private Long productId;
      private Long taskId;
      private Long partTaskId;
      private Integer taskQuantity;
      private Integer quantity;
      private Integer reportQuantity;
      private Long groupsId;
      private Long teamId;
      private Integer number;
      private Boolean boolAllReport;
      private Long completeId;
      private Boolean boolAssist;
      private Long operationId;
      private Integer warehousingType;
      private Long workshopId;
      private Boolean boolSendPurlin;

      MesBuildingSinglePartArtifactPrintBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("partTaskId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder partTaskId(final Long partTaskId) {
         this.partTaskId = partTaskId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("reportQuantity")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("bool_all_report")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder boolAllReport(final Boolean boolAllReport) {
         this.boolAllReport = boolAllReport;
         return this;
      }

      @JsonProperty("completeId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder completeId(final Long completeId) {
         this.completeId = completeId;
         return this;
      }

      @JsonProperty("bool_assist")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      @JsonProperty("operationId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder operationId(final Long operationId) {
         this.operationId = operationId;
         return this;
      }

      @JsonProperty("warehousingType")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder warehousingType(final Integer warehousingType) {
         this.warehousingType = warehousingType;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("boolSendPurlin")
      public MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder boolSendPurlin(final Boolean boolSendPurlin) {
         this.boolSendPurlin = boolSendPurlin;
         return this;
      }

      public MesBuildingSinglePartArtifactPrint build() {
         return new MesBuildingSinglePartArtifactPrint(
            this.id,
            this.productId,
            this.taskId,
            this.partTaskId,
            this.taskQuantity,
            this.quantity,
            this.reportQuantity,
            this.groupsId,
            this.teamId,
            this.number,
            this.boolAllReport,
            this.completeId,
            this.boolAssist,
            this.operationId,
            this.warehousingType,
            this.workshopId,
            this.boolSendPurlin
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSinglePartArtifactPrint.MesBuildingSinglePartArtifactPrintBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", taskId="
            + this.taskId
            + ", partTaskId="
            + this.partTaskId
            + ", taskQuantity="
            + this.taskQuantity
            + ", quantity="
            + this.quantity
            + ", reportQuantity="
            + this.reportQuantity
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
            + ", number="
            + this.number
            + ", boolAllReport="
            + this.boolAllReport
            + ", completeId="
            + this.completeId
            + ", boolAssist="
            + this.boolAssist
            + ", operationId="
            + this.operationId
            + ", warehousingType="
            + this.warehousingType
            + ", workshopId="
            + this.workshopId
            + ", boolSendPurlin="
            + this.boolSendPurlin
            + ")";
      }
   }
}
