package com.hzchum.scim.system.core.api.pojo._do.script;

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

@ApiModel(value = "InitSqlScript对象", description = "")
@Entity
@TableName("init_sql_script")
@Table(name = "init_sql_script")
public class InitSqlScript extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "moduleName", value = "模块名称", notes = "模块名称")
   @JsonProperty("moduleName")
   @JSONField(name = "moduleName")
   @TableField("module_name")
   @Column(name = "module_name", columnDefinition = "varchar(256)  COMMENT '模块名称'")
   private String moduleName;
   @ApiModelProperty(name = "scriptName", value = "执行内容", notes = "执行内容")
   @JsonProperty("scriptName")
   @JSONField(name = "scriptName")
   @TableField("script_name")
   @Column(name = "script_name", columnDefinition = "varchar(256)  COMMENT '执行内容'")
   private String scriptName;
   @ApiModelProperty(name = "sqlContent", value = "需要执行的初始化 SQL 语句内容", notes = "需要执行的初始化 SQL 语句内容")
   @JsonProperty("sqlContent")
   @JSONField(name = "sqlContent")
   @TableField("sql_content")
   @Column(name = "sql_content", columnDefinition = "varchar(2000)  COMMENT '需要执行的初始化 SQL 语句内容'", nullable = false, unique = true)
   private String sqlContent;
   @ApiModelProperty(name = "author", value = "编写人", notes = "编写人")
   @JsonProperty("author")
   @JSONField(name = "author")
   @TableField("author")
   @Column(name = "author", columnDefinition = "varchar(256)  COMMENT '编写人'")
   private String author;
   @ApiModelProperty(name = "executionCount", value = "执行次数")
   @JsonProperty("executionCount")
   @JSONField(name = "executionCount")
   @TableField("execution_count")
   @Column(name = "execution_count", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '执行次数'")
   private Integer executionCount;
   @ApiModelProperty(name = "executeOrder", value = "执行顺序")
   @JsonProperty("executeOrder")
   @JSONField(name = "executeOrder")
   @TableField("execute_order")
   @Column(name = "execute_order", columnDefinition = "bigint(20) DEFAULT 1 COMMENT '执行顺序'")
   private Integer executeOrder;
   @ApiModelProperty(name = "executeTime", value = "执行时间", notes = "执行时间")
   @JsonProperty("executeTime")
   @JSONField(name = "executeTime")
   @TableField("execute_time")
   @Column(name = "execute_time", columnDefinition = "datetime  COMMENT '执行时间'")
   private LocalDateTime executeTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(256)  COMMENT '备注'")
   private String remark;

   public static InitSqlScript.InitSqlScriptBuilder builder() {
      return new InitSqlScript.InitSqlScriptBuilder();
   }

   public InitSqlScript() {
   }

   public InitSqlScript(
      final Long id,
      final String moduleName,
      final String scriptName,
      final String sqlContent,
      final String author,
      final Integer executionCount,
      final Integer executeOrder,
      final LocalDateTime executeTime,
      final String remark
   ) {
      this.id = id;
      this.moduleName = moduleName;
      this.scriptName = scriptName;
      this.sqlContent = sqlContent;
      this.author = author;
      this.executionCount = executionCount;
      this.executeOrder = executeOrder;
      this.executeTime = executeTime;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getModuleName() {
      return this.moduleName;
   }

   public String getScriptName() {
      return this.scriptName;
   }

   public String getSqlContent() {
      return this.sqlContent;
   }

   public String getAuthor() {
      return this.author;
   }

   public Integer getExecutionCount() {
      return this.executionCount;
   }

   public Integer getExecuteOrder() {
      return this.executeOrder;
   }

   public LocalDateTime getExecuteTime() {
      return this.executeTime;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public InitSqlScript setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("moduleName")
   public InitSqlScript setModuleName(final String moduleName) {
      this.moduleName = moduleName;
      return this;
   }

   @JsonProperty("scriptName")
   public InitSqlScript setScriptName(final String scriptName) {
      this.scriptName = scriptName;
      return this;
   }

   @JsonProperty("sqlContent")
   public InitSqlScript setSqlContent(final String sqlContent) {
      this.sqlContent = sqlContent;
      return this;
   }

   @JsonProperty("author")
   public InitSqlScript setAuthor(final String author) {
      this.author = author;
      return this;
   }

   @JsonProperty("executionCount")
   public InitSqlScript setExecutionCount(final Integer executionCount) {
      this.executionCount = executionCount;
      return this;
   }

   @JsonProperty("executeOrder")
   public InitSqlScript setExecuteOrder(final Integer executeOrder) {
      this.executeOrder = executeOrder;
      return this;
   }

   @JsonProperty("executeTime")
   public InitSqlScript setExecuteTime(final LocalDateTime executeTime) {
      this.executeTime = executeTime;
      return this;
   }

   @JsonProperty("remark")
   public InitSqlScript setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "InitSqlScript(id="
         + this.getId()
         + ", moduleName="
         + this.getModuleName()
         + ", scriptName="
         + this.getScriptName()
         + ", sqlContent="
         + this.getSqlContent()
         + ", author="
         + this.getAuthor()
         + ", executionCount="
         + this.getExecutionCount()
         + ", executeOrder="
         + this.getExecuteOrder()
         + ", executeTime="
         + this.getExecuteTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InitSqlScript)) {
         return false;
      }

      InitSqlScript other = (InitSqlScript)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$executionCount = this.getExecutionCount();
         Object other$executionCount = other.getExecutionCount();
         if (this$executionCount == null ? other$executionCount == null : this$executionCount.equals(other$executionCount)) {
            Object this$executeOrder = this.getExecuteOrder();
            Object other$executeOrder = other.getExecuteOrder();
            if (this$executeOrder == null ? other$executeOrder == null : this$executeOrder.equals(other$executeOrder)) {
               Object this$moduleName = this.getModuleName();
               Object other$moduleName = other.getModuleName();
               if (this$moduleName == null ? other$moduleName == null : this$moduleName.equals(other$moduleName)) {
                  Object this$scriptName = this.getScriptName();
                  Object other$scriptName = other.getScriptName();
                  if (this$scriptName == null ? other$scriptName == null : this$scriptName.equals(other$scriptName)) {
                     Object this$sqlContent = this.getSqlContent();
                     Object other$sqlContent = other.getSqlContent();
                     if (this$sqlContent == null ? other$sqlContent == null : this$sqlContent.equals(other$sqlContent)) {
                        Object this$author = this.getAuthor();
                        Object other$author = other.getAuthor();
                        if (this$author == null ? other$author == null : this$author.equals(other$author)) {
                           Object this$executeTime = this.getExecuteTime();
                           Object other$executeTime = other.getExecuteTime();
                           if (this$executeTime == null ? other$executeTime == null : this$executeTime.equals(other$executeTime)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof InitSqlScript;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $executionCount = this.getExecutionCount();
      result = result * 59 + ($executionCount == null ? 43 : $executionCount.hashCode());
      Object $executeOrder = this.getExecuteOrder();
      result = result * 59 + ($executeOrder == null ? 43 : $executeOrder.hashCode());
      Object $moduleName = this.getModuleName();
      result = result * 59 + ($moduleName == null ? 43 : $moduleName.hashCode());
      Object $scriptName = this.getScriptName();
      result = result * 59 + ($scriptName == null ? 43 : $scriptName.hashCode());
      Object $sqlContent = this.getSqlContent();
      result = result * 59 + ($sqlContent == null ? 43 : $sqlContent.hashCode());
      Object $author = this.getAuthor();
      result = result * 59 + ($author == null ? 43 : $author.hashCode());
      Object $executeTime = this.getExecuteTime();
      result = result * 59 + ($executeTime == null ? 43 : $executeTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class InitSqlScriptBuilder {
      private Long id;
      private String moduleName;
      private String scriptName;
      private String sqlContent;
      private String author;
      private Integer executionCount;
      private Integer executeOrder;
      private LocalDateTime executeTime;
      private String remark;

      InitSqlScriptBuilder() {
      }

      @JsonProperty("id")
      public InitSqlScript.InitSqlScriptBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("moduleName")
      public InitSqlScript.InitSqlScriptBuilder moduleName(final String moduleName) {
         this.moduleName = moduleName;
         return this;
      }

      @JsonProperty("scriptName")
      public InitSqlScript.InitSqlScriptBuilder scriptName(final String scriptName) {
         this.scriptName = scriptName;
         return this;
      }

      @JsonProperty("sqlContent")
      public InitSqlScript.InitSqlScriptBuilder sqlContent(final String sqlContent) {
         this.sqlContent = sqlContent;
         return this;
      }

      @JsonProperty("author")
      public InitSqlScript.InitSqlScriptBuilder author(final String author) {
         this.author = author;
         return this;
      }

      @JsonProperty("executionCount")
      public InitSqlScript.InitSqlScriptBuilder executionCount(final Integer executionCount) {
         this.executionCount = executionCount;
         return this;
      }

      @JsonProperty("executeOrder")
      public InitSqlScript.InitSqlScriptBuilder executeOrder(final Integer executeOrder) {
         this.executeOrder = executeOrder;
         return this;
      }

      @JsonProperty("executeTime")
      public InitSqlScript.InitSqlScriptBuilder executeTime(final LocalDateTime executeTime) {
         this.executeTime = executeTime;
         return this;
      }

      @JsonProperty("remark")
      public InitSqlScript.InitSqlScriptBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InitSqlScript build() {
         return new InitSqlScript(
            this.id, this.moduleName, this.scriptName, this.sqlContent, this.author, this.executionCount, this.executeOrder, this.executeTime, this.remark
         );
      }

      @Override
      public String toString() {
         return "InitSqlScript.InitSqlScriptBuilder(id="
            + this.id
            + ", moduleName="
            + this.moduleName
            + ", scriptName="
            + this.scriptName
            + ", sqlContent="
            + this.sqlContent
            + ", author="
            + this.author
            + ", executionCount="
            + this.executionCount
            + ", executeOrder="
            + this.executeOrder
            + ", executeTime="
            + this.executeTime
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
