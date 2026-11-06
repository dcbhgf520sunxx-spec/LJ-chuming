package com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessSummaryDeatil", description = "工序详情")
public class ProcessSummaryDetailsDO {
   @ApiModelProperty(name = "productLineName", notes = "生产线名称")
   @JsonProperty("productLineName")
   @JSONField(name = "productLineName")
   private String productLineName;
   @ApiModelProperty(name = "groupName", notes = "生产组名称")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "groupId", notes = "生产组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "sequence", notes = "顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "userNames", notes = "上报人")
   @JsonProperty("userNames")
   @JSONField(name = "userNames")
   private String userNames;

   public static ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder builder() {
      return new ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder();
   }

   public ProcessSummaryDetailsDO() {
   }

   public ProcessSummaryDetailsDO(
      final String productLineName,
      final String groupName,
      final Long groupId,
      final String name,
      final Long processId,
      final Integer completeQuantity,
      final Integer sequence,
      final Integer inspectionQuantity,
      final String userNames
   ) {
      this.productLineName = productLineName;
      this.groupName = groupName;
      this.groupId = groupId;
      this.name = name;
      this.processId = processId;
      this.completeQuantity = completeQuantity;
      this.sequence = sequence;
      this.inspectionQuantity = inspectionQuantity;
      this.userNames = userNames;
   }

   public String getProductLineName() {
      return this.productLineName;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getName() {
      return this.name;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public String getUserNames() {
      return this.userNames;
   }

   @JsonProperty("productLineName")
   public ProcessSummaryDetailsDO setProductLineName(final String productLineName) {
      this.productLineName = productLineName;
      return this;
   }

   @JsonProperty("groupName")
   public ProcessSummaryDetailsDO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   @JsonProperty("groupId")
   public ProcessSummaryDetailsDO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("name")
   public ProcessSummaryDetailsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("processId")
   public ProcessSummaryDetailsDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ProcessSummaryDetailsDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("sequence")
   public ProcessSummaryDetailsDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public ProcessSummaryDetailsDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("userNames")
   public ProcessSummaryDetailsDO setUserNames(final String userNames) {
      this.userNames = userNames;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSummaryDetailsDO(productLineName="
         + this.getProductLineName()
         + ", groupName="
         + this.getGroupName()
         + ", groupId="
         + this.getGroupId()
         + ", name="
         + this.getName()
         + ", processId="
         + this.getProcessId()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", sequence="
         + this.getSequence()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", userNames="
         + this.getUserNames()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessSummaryDetailsDO)) {
         return false;
      }

      ProcessSummaryDetailsDO other = (ProcessSummaryDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupId = this.getGroupId();
      Object other$groupId = other.getGroupId();
      if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                  Object this$inspectionQuantity = this.getInspectionQuantity();
                  Object other$inspectionQuantity = other.getInspectionQuantity();
                  if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                     Object this$productLineName = this.getProductLineName();
                     Object other$productLineName = other.getProductLineName();
                     if (this$productLineName == null ? other$productLineName == null : this$productLineName.equals(other$productLineName)) {
                        Object this$groupName = this.getGroupName();
                        Object other$groupName = other.getGroupName();
                        if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$userNames = this.getUserNames();
                              Object other$userNames = other.getUserNames();
                              return this$userNames == null ? other$userNames == null : this$userNames.equals(other$userNames);
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
      return other instanceof ProcessSummaryDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $productLineName = this.getProductLineName();
      result = result * 59 + ($productLineName == null ? 43 : $productLineName.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $userNames = this.getUserNames();
      return result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
   }

   public static class ProcessSummaryDetailsDOBuilder {
      private String productLineName;
      private String groupName;
      private Long groupId;
      private String name;
      private Long processId;
      private Integer completeQuantity;
      private Integer sequence;
      private Integer inspectionQuantity;
      private String userNames;

      ProcessSummaryDetailsDOBuilder() {
      }

      @JsonProperty("productLineName")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder productLineName(final String productLineName) {
         this.productLineName = productLineName;
         return this;
      }

      @JsonProperty("groupName")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      @JsonProperty("groupId")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("name")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("processId")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("sequence")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("userNames")
      public ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder userNames(final String userNames) {
         this.userNames = userNames;
         return this;
      }

      public ProcessSummaryDetailsDO build() {
         return new ProcessSummaryDetailsDO(
            this.productLineName,
            this.groupName,
            this.groupId,
            this.name,
            this.processId,
            this.completeQuantity,
            this.sequence,
            this.inspectionQuantity,
            this.userNames
         );
      }

      @Override
      public String toString() {
         return "ProcessSummaryDetailsDO.ProcessSummaryDetailsDOBuilder(productLineName="
            + this.productLineName
            + ", groupName="
            + this.groupName
            + ", groupId="
            + this.groupId
            + ", name="
            + this.name
            + ", processId="
            + this.processId
            + ", completeQuantity="
            + this.completeQuantity
            + ", sequence="
            + this.sequence
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", userNames="
            + this.userNames
            + ")";
      }
   }
}
