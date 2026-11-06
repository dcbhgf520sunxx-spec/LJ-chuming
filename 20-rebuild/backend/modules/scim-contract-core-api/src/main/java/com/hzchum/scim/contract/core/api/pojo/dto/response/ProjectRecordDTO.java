package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("项目操作记录类")
public class ProjectRecordDTO {
   @ApiModelProperty(name = "id", value = "操作记录id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "type", value = "操作类型 1新增 2删除 3修改 4暂停 5继续")
   private int type;
   @ApiModelProperty(name = "operator", value = "操作人姓名")
   private String operator;
   @ApiModelProperty(name = "createTime", value = "操作记录时间")
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public int getType() {
      return this.type;
   }

   public String getOperator() {
      return this.operator;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setType(final int type) {
      this.type = type;
   }

   public void setOperator(final String operator) {
      this.operator = operator;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRecordDTO)) {
         return false;
      }

      ProjectRecordDTO other = (ProjectRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getType() != other.getType()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$operator = this.getOperator();
            Object other$operator = other.getOperator();
            if (this$operator == null ? other$operator == null : this$operator.equals(other$operator)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getType();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $operator = this.getOperator();
      result = result * 59 + ($operator == null ? 43 : $operator.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRecordDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", type="
         + this.getType()
         + ", operator="
         + this.getOperator()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
