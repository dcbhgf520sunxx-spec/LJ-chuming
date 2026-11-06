package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingCloudcutResult对象", description = "云切结果")
@Entity
@TableName("mes_building_cloudcut_result")
@Table(name = "mes_building_cloudcut_result")
public class MesBuildingCloudcutResult extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cloudcutId", value = "云切助手作业id", notes = "云切助手作业id")
   @JsonProperty("cloudcutId")
   @JSONField(name = "cloudcutId")
   @TableField("cloudcut_id")
   @Column(name = "cloudcut_id", columnDefinition = "bigint(20) COMMENT '云切助手作业id'", nullable = true)
   private Long cloudcutId;
   @ApiModelProperty(name = "fileName", value = "文件名", notes = "文件名")
   @JsonProperty("fileName")
   @JSONField(name = "fileName")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(225)  COMMENT '文件名'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径", notes = "文件路径")
   @JsonProperty("filePath")
   @JSONField(name = "filePath")
   @TableField("file_path")
   @Column(name = "file_path", columnDefinition = "varchar(1000)  COMMENT '文件路径'", nullable = false)
   private String filePath;
   @ApiModelProperty(name = "importTime", value = "导入日期", notes = "导入日期")
   @JsonProperty("importTime")
   @JSONField(name = "importTime")
   @TableField("import_time")
   @Column(name = "import_time", columnDefinition = "datetime  COMMENT '导入日期'", nullable = true)
   private LocalDateTime importTime;
   @ApiModelProperty(name = "importUserId", value = "导入人id", notes = "导入人id")
   @JsonProperty("importUserId")
   @JSONField(name = "importUserId")
   @TableField("import_user_id")
   @Column(name = "import_user_id", columnDefinition = "bigint(20) COMMENT '导入人id'", nullable = true)
   private Long importUserId;
   @ApiModelProperty(name = "machineToolId", value = "机床id", notes = "机床id")
   @JsonProperty("machineToolId")
   @JSONField(name = "machineToolId")
   @TableField("machine_tool_id")
   @Column(name = "machine_tool_id", columnDefinition = "bigint(20) COMMENT '机床id'", nullable = true)
   private Long machineToolId;
   @ApiModelProperty(name = "cutSendStatus", value = "切割下发状态", notes = "切割下发状态")
   @JsonProperty("cutSendStatus")
   @JSONField(name = "cutSendStatus")
   @TableField("cut_send_status")
   @Column(name = "cut_send_status", columnDefinition = "int(11) COMMENT '切割下发状态'", nullable = true)
   private Integer cutSendStatus;
   @ApiModelProperty(name = "cutSendTime", value = "切割下发时间", notes = "切割下发时间")
   @JsonProperty("cutSendTime")
   @JSONField(name = "cutSendTime")
   @TableField("cut_send_time")
   @Column(name = "cut_send_time", columnDefinition = "datetime COMMENT '切割下发时间'", nullable = true)
   private LocalDateTime cutSendTime;
   @ApiModelProperty(name = "cutSendUserId", value = "切割下发人id", notes = "切割下发人id")
   @JsonProperty("cutSendUserId")
   @JSONField(name = "cutSendUserId")
   @TableField("cut_send_user_id")
   @Column(name = "cut_send_user_id", columnDefinition = "bigint(20) COMMENT '切割下发人id'", nullable = true)
   private Long cutSendUserId;
   @ApiModelProperty(name = "cutStatus", value = "切割状态", notes = "切割状态")
   @JsonProperty("cutStatus")
   @JSONField(name = "cutStatus")
   @TableField("cut_status")
   @Column(name = "cut_status", columnDefinition = "int(11) COMMENT '切割状态'", nullable = true)
   private Integer cutStatus;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   @TableField("complete_time")
   @Column(name = "complete_time", columnDefinition = "datetime COMMENT '完成日期'", nullable = true)
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "partType", value = "零件类型[8 板材零件 4 型材零件]", notes = "零件类型[8 板材零件 4 型材零件]")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   @TableField("part_type")
   @Column(name = "part_type", columnDefinition = "int(11) COMMENT '零件类型[8 板材零件 4 型材零件]'", nullable = true)
   private Integer partType;

   public static MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder builder() {
      return new MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder();
   }

   public MesBuildingCloudcutResult() {
   }

   public MesBuildingCloudcutResult(
      final Long id,
      final Long cloudcutId,
      final String fileName,
      final String filePath,
      final LocalDateTime importTime,
      final Long importUserId,
      final Long machineToolId,
      final Integer cutSendStatus,
      final LocalDateTime cutSendTime,
      final Long cutSendUserId,
      final Integer cutStatus,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Integer partType
   ) {
      this.id = id;
      this.cloudcutId = cloudcutId;
      this.fileName = fileName;
      this.filePath = filePath;
      this.importTime = importTime;
      this.importUserId = importUserId;
      this.machineToolId = machineToolId;
      this.cutSendStatus = cutSendStatus;
      this.cutSendTime = cutSendTime;
      this.cutSendUserId = cutSendUserId;
      this.cutStatus = cutStatus;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.partType = partType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCloudcutId() {
      return this.cloudcutId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public LocalDateTime getImportTime() {
      return this.importTime;
   }

   public Long getImportUserId() {
      return this.importUserId;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public Integer getCutSendStatus() {
      return this.cutSendStatus;
   }

   public LocalDateTime getCutSendTime() {
      return this.cutSendTime;
   }

   public Long getCutSendUserId() {
      return this.cutSendUserId;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getPartType() {
      return this.partType;
   }

   @JsonProperty("id")
   public MesBuildingCloudcutResult setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cloudcutId")
   public MesBuildingCloudcutResult setCloudcutId(final Long cloudcutId) {
      this.cloudcutId = cloudcutId;
      return this;
   }

   @JsonProperty("fileName")
   public MesBuildingCloudcutResult setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @JsonProperty("filePath")
   public MesBuildingCloudcutResult setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   @JsonProperty("importTime")
   public MesBuildingCloudcutResult setImportTime(final LocalDateTime importTime) {
      this.importTime = importTime;
      return this;
   }

   @JsonProperty("importUserId")
   public MesBuildingCloudcutResult setImportUserId(final Long importUserId) {
      this.importUserId = importUserId;
      return this;
   }

   @JsonProperty("machineToolId")
   public MesBuildingCloudcutResult setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   @JsonProperty("cutSendStatus")
   public MesBuildingCloudcutResult setCutSendStatus(final Integer cutSendStatus) {
      this.cutSendStatus = cutSendStatus;
      return this;
   }

   @JsonProperty("cutSendTime")
   public MesBuildingCloudcutResult setCutSendTime(final LocalDateTime cutSendTime) {
      this.cutSendTime = cutSendTime;
      return this;
   }

   @JsonProperty("cutSendUserId")
   public MesBuildingCloudcutResult setCutSendUserId(final Long cutSendUserId) {
      this.cutSendUserId = cutSendUserId;
      return this;
   }

   @JsonProperty("cutStatus")
   public MesBuildingCloudcutResult setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingCloudcutResult setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingCloudcutResult setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("partType")
   public MesBuildingCloudcutResult setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutResult(id="
         + this.getId()
         + ", cloudcutId="
         + this.getCloudcutId()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ", importTime="
         + this.getImportTime()
         + ", importUserId="
         + this.getImportUserId()
         + ", machineToolId="
         + this.getMachineToolId()
         + ", cutSendStatus="
         + this.getCutSendStatus()
         + ", cutSendTime="
         + this.getCutSendTime()
         + ", cutSendUserId="
         + this.getCutSendUserId()
         + ", cutStatus="
         + this.getCutStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", partType="
         + this.getPartType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutResult)) {
         return false;
      }

      MesBuildingCloudcutResult other = (MesBuildingCloudcutResult)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cloudcutId = this.getCloudcutId();
         Object other$cloudcutId = other.getCloudcutId();
         if (this$cloudcutId == null ? other$cloudcutId == null : this$cloudcutId.equals(other$cloudcutId)) {
            Object this$importUserId = this.getImportUserId();
            Object other$importUserId = other.getImportUserId();
            if (this$importUserId == null ? other$importUserId == null : this$importUserId.equals(other$importUserId)) {
               Object this$machineToolId = this.getMachineToolId();
               Object other$machineToolId = other.getMachineToolId();
               if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
                  Object this$cutSendStatus = this.getCutSendStatus();
                  Object other$cutSendStatus = other.getCutSendStatus();
                  if (this$cutSendStatus == null ? other$cutSendStatus == null : this$cutSendStatus.equals(other$cutSendStatus)) {
                     Object this$cutSendUserId = this.getCutSendUserId();
                     Object other$cutSendUserId = other.getCutSendUserId();
                     if (this$cutSendUserId == null ? other$cutSendUserId == null : this$cutSendUserId.equals(other$cutSendUserId)) {
                        Object this$cutStatus = this.getCutStatus();
                        Object other$cutStatus = other.getCutStatus();
                        if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
                           Object this$partType = this.getPartType();
                           Object other$partType = other.getPartType();
                           if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                              Object this$fileName = this.getFileName();
                              Object other$fileName = other.getFileName();
                              if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                 Object this$filePath = this.getFilePath();
                                 Object other$filePath = other.getFilePath();
                                 if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                    Object this$importTime = this.getImportTime();
                                    Object other$importTime = other.getImportTime();
                                    if (this$importTime == null ? other$importTime == null : this$importTime.equals(other$importTime)) {
                                       Object this$cutSendTime = this.getCutSendTime();
                                       Object other$cutSendTime = other.getCutSendTime();
                                       if (this$cutSendTime == null ? other$cutSendTime == null : this$cutSendTime.equals(other$cutSendTime)) {
                                          Object this$askCompleteTime = this.getAskCompleteTime();
                                          Object other$askCompleteTime = other.getAskCompleteTime();
                                          if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)
                                             )
                                           {
                                             Object this$completeTime = this.getCompleteTime();
                                             Object other$completeTime = other.getCompleteTime();
                                             return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
      return other instanceof MesBuildingCloudcutResult;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cloudcutId = this.getCloudcutId();
      result = result * 59 + ($cloudcutId == null ? 43 : $cloudcutId.hashCode());
      Object $importUserId = this.getImportUserId();
      result = result * 59 + ($importUserId == null ? 43 : $importUserId.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $cutSendStatus = this.getCutSendStatus();
      result = result * 59 + ($cutSendStatus == null ? 43 : $cutSendStatus.hashCode());
      Object $cutSendUserId = this.getCutSendUserId();
      result = result * 59 + ($cutSendUserId == null ? 43 : $cutSendUserId.hashCode());
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $importTime = this.getImportTime();
      result = result * 59 + ($importTime == null ? 43 : $importTime.hashCode());
      Object $cutSendTime = this.getCutSendTime();
      result = result * 59 + ($cutSendTime == null ? 43 : $cutSendTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesBuildingCloudcutResultBuilder {
      private Long id;
      private Long cloudcutId;
      private String fileName;
      private String filePath;
      private LocalDateTime importTime;
      private Long importUserId;
      private Long machineToolId;
      private Integer cutSendStatus;
      private LocalDateTime cutSendTime;
      private Long cutSendUserId;
      private Integer cutStatus;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Integer partType;

      MesBuildingCloudcutResultBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cloudcutId")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder cloudcutId(final Long cloudcutId) {
         this.cloudcutId = cloudcutId;
         return this;
      }

      @JsonProperty("fileName")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("filePath")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      @JsonProperty("importTime")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder importTime(final LocalDateTime importTime) {
         this.importTime = importTime;
         return this;
      }

      @JsonProperty("importUserId")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder importUserId(final Long importUserId) {
         this.importUserId = importUserId;
         return this;
      }

      @JsonProperty("machineToolId")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      @JsonProperty("cutSendStatus")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder cutSendStatus(final Integer cutSendStatus) {
         this.cutSendStatus = cutSendStatus;
         return this;
      }

      @JsonProperty("cutSendTime")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder cutSendTime(final LocalDateTime cutSendTime) {
         this.cutSendTime = cutSendTime;
         return this;
      }

      @JsonProperty("cutSendUserId")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder cutSendUserId(final Long cutSendUserId) {
         this.cutSendUserId = cutSendUserId;
         return this;
      }

      @JsonProperty("cutStatus")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("partType")
      public MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      public MesBuildingCloudcutResult build() {
         return new MesBuildingCloudcutResult(
            this.id,
            this.cloudcutId,
            this.fileName,
            this.filePath,
            this.importTime,
            this.importUserId,
            this.machineToolId,
            this.cutSendStatus,
            this.cutSendTime,
            this.cutSendUserId,
            this.cutStatus,
            this.askCompleteTime,
            this.completeTime,
            this.partType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCloudcutResult.MesBuildingCloudcutResultBuilder(id="
            + this.id
            + ", cloudcutId="
            + this.cloudcutId
            + ", fileName="
            + this.fileName
            + ", filePath="
            + this.filePath
            + ", importTime="
            + this.importTime
            + ", importUserId="
            + this.importUserId
            + ", machineToolId="
            + this.machineToolId
            + ", cutSendStatus="
            + this.cutSendStatus
            + ", cutSendTime="
            + this.cutSendTime
            + ", cutSendUserId="
            + this.cutSendUserId
            + ", cutStatus="
            + this.cutStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", partType="
            + this.partType
            + ")";
      }
   }
}
