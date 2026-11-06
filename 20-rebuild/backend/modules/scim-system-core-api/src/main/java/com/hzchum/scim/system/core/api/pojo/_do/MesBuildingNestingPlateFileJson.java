package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ApiModel(value = "MesBuildingNestingPlateFileJson对象", description = "零件套料json")
@TableName("mes_building_nesting_plate_file_json")
@Table(name = "mes_building_nesting_plate_file_json")
public class MesBuildingNestingPlateFileJson extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "jobPatJson", value = "作业json", notes = "作业json")
   @TableField("job_part_json")
   @Column(name = "job_part_json", columnDefinition = "mediumblob  COMMENT '作业json'", nullable = true)
   private byte[] jobPartJson;
   @ApiModelProperty(name = "jobPatFileName", value = "零件作业名", notes = "零件作业名")
   @TableField("job_part_file_name")
   @Column(name = "job_part_file_name", columnDefinition = "varchar(255) COMMENT '零件作业名'", nullable = true)
   private String jobPatFileName;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   @TableField("team_code")
   @Column(name = "team_code", columnDefinition = "varchar(255)  COMMENT '团队码'", nullable = true)
   private String teamCode;
   @ApiModelProperty(name = "jobId", value = "作业id", notes = "作业id")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "bigint(20)  COMMENT '作业id'", nullable = false)
   private Integer jobId;
   @ApiModelProperty(name = "guid", value = "钢板id", notes = "钢板id")
   @Column(name = "guid", columnDefinition = "varchar(255)  COMMENT '钢板id'", nullable = false)
   @TableField("guid")
   private String guid;
   @ApiModelProperty(name = "fileType", value = "文件类型", notes = "文件类型")
   @Column(name = "file_type", columnDefinition = "varchar(255)  COMMENT '文件类型'", nullable = true)
   private String fileType;
   @ApiModelProperty(name = "fileSuffix", value = "文件后缀", notes = "文件后缀")
   @TableField("file_suffix")
   @Column(name = "file_suffix", columnDefinition = "varchar(255)  COMMENT '文件后缀'", nullable = true)
   private String fileSuffix;

   public static MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder builder() {
      return new MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public byte[] getJobPartJson() {
      return this.jobPartJson;
   }

   public String getJobPatFileName() {
      return this.jobPatFileName;
   }

   public String getTeamCode() {
      return this.teamCode;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getFileType() {
      return this.fileType;
   }

   public String getFileSuffix() {
      return this.fileSuffix;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setJobPartJson(final byte[] jobPartJson) {
      this.jobPartJson = jobPartJson;
   }

   public void setJobPatFileName(final String jobPatFileName) {
      this.jobPatFileName = jobPatFileName;
   }

   public void setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
   }

   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   public void setGuid(final String guid) {
      this.guid = guid;
   }

   public void setFileType(final String fileType) {
      this.fileType = fileType;
   }

   public void setFileSuffix(final String fileSuffix) {
      this.fileSuffix = fileSuffix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingPlateFileJson)) {
         return false;
      }

      MesBuildingNestingPlateFileJson other = (MesBuildingNestingPlateFileJson)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            if (!Arrays.equals(this.getJobPartJson(), other.getJobPartJson())) {
               return false;
            }

            Object this$jobPatFileName = this.getJobPatFileName();
            Object other$jobPatFileName = other.getJobPatFileName();
            if (this$jobPatFileName == null ? other$jobPatFileName == null : this$jobPatFileName.equals(other$jobPatFileName)) {
               Object this$teamCode = this.getTeamCode();
               Object other$teamCode = other.getTeamCode();
               if (this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode)) {
                  Object this$guid = this.getGuid();
                  Object other$guid = other.getGuid();
                  if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                     Object this$fileType = this.getFileType();
                     Object other$fileType = other.getFileType();
                     if (this$fileType == null ? other$fileType == null : this$fileType.equals(other$fileType)) {
                        Object this$fileSuffix = this.getFileSuffix();
                        Object other$fileSuffix = other.getFileSuffix();
                        return this$fileSuffix == null ? other$fileSuffix == null : this$fileSuffix.equals(other$fileSuffix);
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
      return other instanceof MesBuildingNestingPlateFileJson;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      result = result * 59 + Arrays.hashCode(this.getJobPartJson());
      Object $jobPatFileName = this.getJobPatFileName();
      result = result * 59 + ($jobPatFileName == null ? 43 : $jobPatFileName.hashCode());
      Object $teamCode = this.getTeamCode();
      result = result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $fileType = this.getFileType();
      result = result * 59 + ($fileType == null ? 43 : $fileType.hashCode());
      Object $fileSuffix = this.getFileSuffix();
      return result * 59 + ($fileSuffix == null ? 43 : $fileSuffix.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingNestingPlateFileJson(id="
         + this.getId()
         + ", jobPartJson="
         + Arrays.toString(this.getJobPartJson())
         + ", jobPatFileName="
         + this.getJobPatFileName()
         + ", teamCode="
         + this.getTeamCode()
         + ", jobId="
         + this.getJobId()
         + ", guid="
         + this.getGuid()
         + ", fileType="
         + this.getFileType()
         + ", fileSuffix="
         + this.getFileSuffix()
         + ")";
   }

   public MesBuildingNestingPlateFileJson() {
   }

   public MesBuildingNestingPlateFileJson(
      final Long id,
      final byte[] jobPartJson,
      final String jobPatFileName,
      final String teamCode,
      final Integer jobId,
      final String guid,
      final String fileType,
      final String fileSuffix
   ) {
      this.id = id;
      this.jobPartJson = jobPartJson;
      this.jobPatFileName = jobPatFileName;
      this.teamCode = teamCode;
      this.jobId = jobId;
      this.guid = guid;
      this.fileType = fileType;
      this.fileSuffix = fileSuffix;
   }

   public static class MesBuildingNestingPlateFileJsonBuilder {
      private Long id;
      private byte[] jobPartJson;
      private String jobPatFileName;
      private String teamCode;
      private Integer jobId;
      private String guid;
      private String fileType;
      private String fileSuffix;

      MesBuildingNestingPlateFileJsonBuilder() {
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder jobPartJson(final byte[] jobPartJson) {
         this.jobPartJson = jobPartJson;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder jobPatFileName(final String jobPatFileName) {
         this.jobPatFileName = jobPatFileName;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder fileType(final String fileType) {
         this.fileType = fileType;
         return this;
      }

      public MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder fileSuffix(final String fileSuffix) {
         this.fileSuffix = fileSuffix;
         return this;
      }

      public MesBuildingNestingPlateFileJson build() {
         return new MesBuildingNestingPlateFileJson(
            this.id, this.jobPartJson, this.jobPatFileName, this.teamCode, this.jobId, this.guid, this.fileType, this.fileSuffix
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestingPlateFileJson.MesBuildingNestingPlateFileJsonBuilder(id="
            + this.id
            + ", jobPartJson="
            + Arrays.toString(this.jobPartJson)
            + ", jobPatFileName="
            + this.jobPatFileName
            + ", teamCode="
            + this.teamCode
            + ", jobId="
            + this.jobId
            + ", guid="
            + this.guid
            + ", fileType="
            + this.fileType
            + ", fileSuffix="
            + this.fileSuffix
            + ")";
      }
   }
}
