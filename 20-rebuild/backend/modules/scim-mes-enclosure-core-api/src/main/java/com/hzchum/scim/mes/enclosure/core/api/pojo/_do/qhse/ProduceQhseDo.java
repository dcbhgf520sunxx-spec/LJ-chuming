package com.hzchum.scim.mes.enclosure.core.api.pojo._do.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ProduceQhseDo对象", description = "产线问题数据信息统计返回")
public class ProduceQhseDo {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "artifactSerialNumber", value = "构件编号")
   @JsonProperty("artifactSerialNumber")
   @JSONField(name = "artifactSerialNumber")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "remark", value = "问题描述", notes = "问题描述")
   @JsonProperty("remark")
   private String remark;
   @ApiModelProperty(name = "questionType", value = "问题类型", notes = "问题类型")
   @JsonProperty("questionType")
   private String questionType;
   @ApiModelProperty(name = "productUserId", value = "生产人id", notes = "生产人id")
   @JsonProperty("productUserId")
   @JSONField(name = "productUserId")
   private Long productUserId;
   @ApiModelProperty(name = "productUserName", value = "生产人名称", notes = "生产人名称")
   @JsonProperty("productUserName")
   @JSONField(name = "productUserName")
   private String productUserName;
   @ApiModelProperty(name = "InspectionUserId", value = "质检人id", notes = "质检人id")
   @JsonProperty("InspectionUserId")
   @JSONField(name = "InspectionUserId")
   private Long inspectionUserId;
   @ApiModelProperty(name = "InspectionUserName", value = "质检人名称", notes = "质检人名称")
   @JsonProperty("InspectionUserName")
   @JSONField(name = "InspectionUserName")
   private String inspectionUserName;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "createTime", value = "时间", notes = "时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "qualityType", value = "质量问题类型", notes = "质量问题类型")
   @JsonProperty("qualityType")
   @JSONField(name = "qualityType")
   private String qualityType;

   public static ProduceQhseDo.ProduceQhseDoBuilder builder() {
      return new ProduceQhseDo.ProduceQhseDoBuilder();
   }

   public ProduceQhseDo() {
   }

   public ProduceQhseDo(
      final ProjectDetailDO project,
      final String artifactSerialNumber,
      final String remark,
      final String questionType,
      final Long productUserId,
      final String productUserName,
      final Long inspectionUserId,
      final String inspectionUserName,
      final Long processId,
      final String processName,
      final LocalDateTime createTime,
      final Integer quantity,
      final Integer number,
      final String qualityType
   ) {
      this.project = project;
      this.artifactSerialNumber = artifactSerialNumber;
      this.remark = remark;
      this.questionType = questionType;
      this.productUserId = productUserId;
      this.productUserName = productUserName;
      this.inspectionUserId = inspectionUserId;
      this.inspectionUserName = inspectionUserName;
      this.processId = processId;
      this.processName = processName;
      this.createTime = createTime;
      this.quantity = quantity;
      this.number = number;
      this.qualityType = qualityType;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getQuestionType() {
      return this.questionType;
   }

   public Long getProductUserId() {
      return this.productUserId;
   }

   public String getProductUserName() {
      return this.productUserName;
   }

   public Long getInspectionUserId() {
      return this.inspectionUserId;
   }

   public String getInspectionUserName() {
      return this.inspectionUserName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getQualityType() {
      return this.qualityType;
   }

   @JsonProperty("project")
   public void setProject(final ProjectDetailDO project) {
      this.project = project;
   }

   @JsonProperty("artifactSerialNumber")
   public void setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("questionType")
   public void setQuestionType(final String questionType) {
      this.questionType = questionType;
   }

   @JsonProperty("productUserId")
   public void setProductUserId(final Long productUserId) {
      this.productUserId = productUserId;
   }

   @JsonProperty("productUserName")
   public void setProductUserName(final String productUserName) {
      this.productUserName = productUserName;
   }

   @JsonProperty("InspectionUserId")
   public void setInspectionUserId(final Long inspectionUserId) {
      this.inspectionUserId = inspectionUserId;
   }

   @JsonProperty("InspectionUserName")
   public void setInspectionUserName(final String inspectionUserName) {
      this.inspectionUserName = inspectionUserName;
   }

   @JsonProperty("processId")
   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("createTime")
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("number")
   public void setNumber(final Integer number) {
      this.number = number;
   }

   @JsonProperty("qualityType")
   public void setQualityType(final String qualityType) {
      this.qualityType = qualityType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceQhseDo)) {
         return false;
      }

      ProduceQhseDo other = (ProduceQhseDo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productUserId = this.getProductUserId();
      Object other$productUserId = other.getProductUserId();
      if (this$productUserId == null ? other$productUserId == null : this$productUserId.equals(other$productUserId)) {
         Object this$inspectionUserId = this.getInspectionUserId();
         Object other$inspectionUserId = other.getInspectionUserId();
         if (this$inspectionUserId == null ? other$inspectionUserId == null : this$inspectionUserId.equals(other$inspectionUserId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$number = this.getNumber();
                  Object other$number = other.getNumber();
                  if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                        Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                        if (this$artifactSerialNumber == null
                           ? other$artifactSerialNumber == null
                           : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$questionType = this.getQuestionType();
                              Object other$questionType = other.getQuestionType();
                              if (this$questionType == null ? other$questionType == null : this$questionType.equals(other$questionType)) {
                                 Object this$productUserName = this.getProductUserName();
                                 Object other$productUserName = other.getProductUserName();
                                 if (this$productUserName == null ? other$productUserName == null : this$productUserName.equals(other$productUserName)) {
                                    Object this$inspectionUserName = this.getInspectionUserName();
                                    Object other$inspectionUserName = other.getInspectionUserName();
                                    if (this$inspectionUserName == null
                                       ? other$inspectionUserName == null
                                       : this$inspectionUserName.equals(other$inspectionUserName)) {
                                       Object this$processName = this.getProcessName();
                                       Object other$processName = other.getProcessName();
                                       if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                             Object this$qualityType = this.getQualityType();
                                             Object other$qualityType = other.getQualityType();
                                             return this$qualityType == null ? other$qualityType == null : this$qualityType.equals(other$qualityType);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProduceQhseDo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productUserId = this.getProductUserId();
      result = result * 59 + ($productUserId == null ? 43 : $productUserId.hashCode());
      Object $inspectionUserId = this.getInspectionUserId();
      result = result * 59 + ($inspectionUserId == null ? 43 : $inspectionUserId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $questionType = this.getQuestionType();
      result = result * 59 + ($questionType == null ? 43 : $questionType.hashCode());
      Object $productUserName = this.getProductUserName();
      result = result * 59 + ($productUserName == null ? 43 : $productUserName.hashCode());
      Object $inspectionUserName = this.getInspectionUserName();
      result = result * 59 + ($inspectionUserName == null ? 43 : $inspectionUserName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $qualityType = this.getQualityType();
      return result * 59 + ($qualityType == null ? 43 : $qualityType.hashCode());
   }

   @Override
   public String toString() {
      return "ProduceQhseDo(project="
         + this.getProject()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", remark="
         + this.getRemark()
         + ", questionType="
         + this.getQuestionType()
         + ", productUserId="
         + this.getProductUserId()
         + ", productUserName="
         + this.getProductUserName()
         + ", inspectionUserId="
         + this.getInspectionUserId()
         + ", inspectionUserName="
         + this.getInspectionUserName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", createTime="
         + this.getCreateTime()
         + ", quantity="
         + this.getQuantity()
         + ", number="
         + this.getNumber()
         + ", qualityType="
         + this.getQualityType()
         + ")";
   }

   public static class ProduceQhseDoBuilder {
      private ProjectDetailDO project;
      private String artifactSerialNumber;
      private String remark;
      private String questionType;
      private Long productUserId;
      private String productUserName;
      private Long inspectionUserId;
      private String inspectionUserName;
      private Long processId;
      private String processName;
      private LocalDateTime createTime;
      private Integer quantity;
      private Integer number;
      private String qualityType;

      ProduceQhseDoBuilder() {
      }

      @JsonProperty("project")
      public ProduceQhseDo.ProduceQhseDoBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("artifactSerialNumber")
      public ProduceQhseDo.ProduceQhseDoBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      @JsonProperty("remark")
      public ProduceQhseDo.ProduceQhseDoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("questionType")
      public ProduceQhseDo.ProduceQhseDoBuilder questionType(final String questionType) {
         this.questionType = questionType;
         return this;
      }

      @JsonProperty("productUserId")
      public ProduceQhseDo.ProduceQhseDoBuilder productUserId(final Long productUserId) {
         this.productUserId = productUserId;
         return this;
      }

      @JsonProperty("productUserName")
      public ProduceQhseDo.ProduceQhseDoBuilder productUserName(final String productUserName) {
         this.productUserName = productUserName;
         return this;
      }

      @JsonProperty("InspectionUserId")
      public ProduceQhseDo.ProduceQhseDoBuilder inspectionUserId(final Long inspectionUserId) {
         this.inspectionUserId = inspectionUserId;
         return this;
      }

      @JsonProperty("InspectionUserName")
      public ProduceQhseDo.ProduceQhseDoBuilder inspectionUserName(final String inspectionUserName) {
         this.inspectionUserName = inspectionUserName;
         return this;
      }

      @JsonProperty("processId")
      public ProduceQhseDo.ProduceQhseDoBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public ProduceQhseDo.ProduceQhseDoBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("createTime")
      public ProduceQhseDo.ProduceQhseDoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("quantity")
      public ProduceQhseDo.ProduceQhseDoBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("number")
      public ProduceQhseDo.ProduceQhseDoBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("qualityType")
      public ProduceQhseDo.ProduceQhseDoBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      public ProduceQhseDo build() {
         return new ProduceQhseDo(
            this.project,
            this.artifactSerialNumber,
            this.remark,
            this.questionType,
            this.productUserId,
            this.productUserName,
            this.inspectionUserId,
            this.inspectionUserName,
            this.processId,
            this.processName,
            this.createTime,
            this.quantity,
            this.number,
            this.qualityType
         );
      }

      @Override
      public String toString() {
         return "ProduceQhseDo.ProduceQhseDoBuilder(project="
            + this.project
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", remark="
            + this.remark
            + ", questionType="
            + this.questionType
            + ", productUserId="
            + this.productUserId
            + ", productUserName="
            + this.productUserName
            + ", inspectionUserId="
            + this.inspectionUserId
            + ", inspectionUserName="
            + this.inspectionUserName
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", createTime="
            + this.createTime
            + ", quantity="
            + this.quantity
            + ", number="
            + this.number
            + ", qualityType="
            + this.qualityType
            + ")";
      }
   }
}
