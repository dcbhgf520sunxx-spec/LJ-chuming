package com.hzchum.scim.common.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectProductInfoDTO", description = "项目产品生产表单信息")
public class ProjectProductInfoDTO {
   @ApiModelProperty(name = "Id", notes = "构件id")
   @JsonProperty("Id")
   @JSONField(name = "Id")
   private Long Id;
   @ApiModelProperty(value = "构件名称", notes = "构件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "taskQuantity", value = "排产数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "processDTOList", notes = "工序信息")
   @JsonProperty("processDTOList")
   @JSONField(name = "processDTOList")
   private List<ProjectProductProcessDTO> processDTOList;

   public Long getId() {
      return this.Id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public List<ProjectProductProcessDTO> getProcessDTOList() {
      return this.processDTOList;
   }

   @JsonProperty("Id")
   public void setId(final Long Id) {
      this.Id = Id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("processDTOList")
   public void setProcessDTOList(final List<ProjectProductProcessDTO> processDTOList) {
      this.processDTOList = processDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductInfoDTO)) {
         return false;
      }

      ProjectProductInfoDTO other = (ProjectProductInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$Id = this.getId();
      Object other$Id = other.getId();
      if (this$Id == null ? other$Id == null : this$Id.equals(other$Id)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$processDTOList = this.getProcessDTOList();
                     Object other$processDTOList = other.getProcessDTOList();
                     return this$processDTOList == null ? other$processDTOList == null : this$processDTOList.equals(other$processDTOList);
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
      return other instanceof ProjectProductInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $Id = this.getId();
      result = result * 59 + ($Id == null ? 43 : $Id.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $processDTOList = this.getProcessDTOList();
      return result * 59 + ($processDTOList == null ? 43 : $processDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductInfoDTO(Id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", processDTOList="
         + this.getProcessDTOList()
         + ")";
   }
}
