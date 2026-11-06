package com.hzchum.scim.common.core.api.pojo._do;

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

@ApiModel(value = "Backups对象", description = "物料库存")
@Entity
@TableName("backups")
@Table(name = "backups")
public class Backups extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "databaseName", value = "备份数据库名称", notes = "备份数据库名称")
   @JsonProperty("databaseName")
   @JSONField(name = "databaseName")
   @TableField("database_name")
   @Column(name = "database_name", columnDefinition = "varchar(255)  COMMENT '备份数据库名称'", nullable = true)
   private String databaseName;
   @ApiModelProperty(name = "backupsName", value = "备份文件名称", notes = "备份文件名称")
   @JsonProperty("backupsName")
   @JSONField(name = "backupsName")
   @TableField("backups_name")
   @Column(name = "backups_name", columnDefinition = "varchar(255)  COMMENT '备份文件名称'", nullable = true)
   private String backupsName;
   @ApiModelProperty(name = "backupsPath", value = "备份文件路径", notes = "备份文件路径")
   @JsonProperty("backupsPath")
   @JSONField(name = "backupsPath")
   @TableField("backups_path")
   @Column(name = "backups_path", columnDefinition = "varchar(255)  COMMENT '备份文件路径'", nullable = true)
   private String backupsPath;

   public static Backups.BackupsBuilder builder() {
      return new Backups.BackupsBuilder();
   }

   public Backups() {
   }

   public Backups(final Long id, final String databaseName, final String backupsName, final String backupsPath) {
      this.id = id;
      this.databaseName = databaseName;
      this.backupsName = backupsName;
      this.backupsPath = backupsPath;
   }

   public Long getId() {
      return this.id;
   }

   public String getDatabaseName() {
      return this.databaseName;
   }

   public String getBackupsName() {
      return this.backupsName;
   }

   public String getBackupsPath() {
      return this.backupsPath;
   }

   @JsonProperty("id")
   public Backups setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("databaseName")
   public Backups setDatabaseName(final String databaseName) {
      this.databaseName = databaseName;
      return this;
   }

   @JsonProperty("backupsName")
   public Backups setBackupsName(final String backupsName) {
      this.backupsName = backupsName;
      return this;
   }

   @JsonProperty("backupsPath")
   public Backups setBackupsPath(final String backupsPath) {
      this.backupsPath = backupsPath;
      return this;
   }

   @Override
   public String toString() {
      return "Backups(id="
         + this.getId()
         + ", databaseName="
         + this.getDatabaseName()
         + ", backupsName="
         + this.getBackupsName()
         + ", backupsPath="
         + this.getBackupsPath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Backups)) {
         return false;
      }

      Backups other = (Backups)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$databaseName = this.getDatabaseName();
         Object other$databaseName = other.getDatabaseName();
         if (this$databaseName == null ? other$databaseName == null : this$databaseName.equals(other$databaseName)) {
            Object this$backupsName = this.getBackupsName();
            Object other$backupsName = other.getBackupsName();
            if (this$backupsName == null ? other$backupsName == null : this$backupsName.equals(other$backupsName)) {
               Object this$backupsPath = this.getBackupsPath();
               Object other$backupsPath = other.getBackupsPath();
               return this$backupsPath == null ? other$backupsPath == null : this$backupsPath.equals(other$backupsPath);
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
      return other instanceof Backups;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $databaseName = this.getDatabaseName();
      result = result * 59 + ($databaseName == null ? 43 : $databaseName.hashCode());
      Object $backupsName = this.getBackupsName();
      result = result * 59 + ($backupsName == null ? 43 : $backupsName.hashCode());
      Object $backupsPath = this.getBackupsPath();
      return result * 59 + ($backupsPath == null ? 43 : $backupsPath.hashCode());
   }

   public static class BackupsBuilder {
      private Long id;
      private String databaseName;
      private String backupsName;
      private String backupsPath;

      BackupsBuilder() {
      }

      @JsonProperty("id")
      public Backups.BackupsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("databaseName")
      public Backups.BackupsBuilder databaseName(final String databaseName) {
         this.databaseName = databaseName;
         return this;
      }

      @JsonProperty("backupsName")
      public Backups.BackupsBuilder backupsName(final String backupsName) {
         this.backupsName = backupsName;
         return this;
      }

      @JsonProperty("backupsPath")
      public Backups.BackupsBuilder backupsPath(final String backupsPath) {
         this.backupsPath = backupsPath;
         return this;
      }

      public Backups build() {
         return new Backups(this.id, this.databaseName, this.backupsName, this.backupsPath);
      }

      @Override
      public String toString() {
         return "Backups.BackupsBuilder(id="
            + this.id
            + ", databaseName="
            + this.databaseName
            + ", backupsName="
            + this.backupsName
            + ", backupsPath="
            + this.backupsPath
            + ")";
      }
   }
}
