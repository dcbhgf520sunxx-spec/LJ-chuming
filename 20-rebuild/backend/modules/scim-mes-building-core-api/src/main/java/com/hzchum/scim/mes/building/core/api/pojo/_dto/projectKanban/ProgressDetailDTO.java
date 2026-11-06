package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProductProcessProgressDetail", description = "项目生产看板 - 产品工序进度详情")
public class ProgressDetailDTO {
   @ApiModelProperty(name = "name", notes = "项目名", value = "项目名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "processName", notes = "工序名称", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "needQuantitySum", value = "任务总数")
   @JsonProperty("needQuantitySum")
   @JSONField(name = "needQuantitySum")
   private Integer needQuantitySum;
   @ApiModelProperty(name = "completeQuantitySum", value = "完成总数")
   @JsonProperty("completeQuantitySum")
   @JSONField(name = "completeQuantitySum")
   private Integer completeQuantitySum;
   @ApiModelProperty(name = "progressList", value = "产品工序进度")
   @JsonProperty("progressList")
   @JSONField(name = "progressList")
   private List<ProductProcessProgressDetailDTO> progressList;

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getNeedQuantitySum() {
      return this.needQuantitySum;
   }

   public Integer getCompleteQuantitySum() {
      return this.completeQuantitySum;
   }

   public List<ProductProcessProgressDetailDTO> getProgressList() {
      return this.progressList;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("needQuantitySum")
   public void setNeedQuantitySum(final Integer needQuantitySum) {
      this.needQuantitySum = needQuantitySum;
   }

   @JsonProperty("completeQuantitySum")
   public void setCompleteQuantitySum(final Integer completeQuantitySum) {
      this.completeQuantitySum = completeQuantitySum;
   }

   @JsonProperty("progressList")
   public void setProgressList(final List<ProductProcessProgressDetailDTO> progressList) {
      this.progressList = progressList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProgressDetailDTO)) {
         return false;
      }

      ProgressDetailDTO other = (ProgressDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$needQuantitySum = this.getNeedQuantitySum();
      Object other$needQuantitySum = other.getNeedQuantitySum();
      if (this$needQuantitySum == null ? other$needQuantitySum == null : this$needQuantitySum.equals(other$needQuantitySum)) {
         Object this$completeQuantitySum = this.getCompleteQuantitySum();
         Object other$completeQuantitySum = other.getCompleteQuantitySum();
         if (this$completeQuantitySum == null ? other$completeQuantitySum == null : this$completeQuantitySum.equals(other$completeQuantitySum)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$progressList = this.getProgressList();
                     Object other$progressList = other.getProgressList();
                     return this$progressList == null ? other$progressList == null : this$progressList.equals(other$progressList);
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
      return other instanceof ProgressDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $needQuantitySum = this.getNeedQuantitySum();
      result = result * 59 + ($needQuantitySum == null ? 43 : $needQuantitySum.hashCode());
      Object $completeQuantitySum = this.getCompleteQuantitySum();
      result = result * 59 + ($completeQuantitySum == null ? 43 : $completeQuantitySum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $progressList = this.getProgressList();
      return result * 59 + ($progressList == null ? 43 : $progressList.hashCode());
   }

   @Override
   public String toString() {
      return "ProgressDetailDTO(name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", processName="
         + this.getProcessName()
         + ", needQuantitySum="
         + this.getNeedQuantitySum()
         + ", completeQuantitySum="
         + this.getCompleteQuantitySum()
         + ", progressList="
         + this.getProgressList()
         + ")";
   }
}
