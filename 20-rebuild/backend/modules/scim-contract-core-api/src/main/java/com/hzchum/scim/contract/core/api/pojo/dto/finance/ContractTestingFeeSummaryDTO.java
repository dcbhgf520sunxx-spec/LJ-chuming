package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ContractTestingFee对象", description = "检测费汇总dto ")
public class ContractTestingFeeSummaryDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "testingFeeTypeId", value = "类型id", notes = "类型id")
   private Long testingFeeTypeId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "testingFeeTypeName", value = "类型名称", notes = "类型名称")
   private String testingFeeTypeName;
   @ApiModelProperty(name = "testingFeeList", value = "费用列表", notes = "费用列表")
   private List<TestingFeeMonthDTO> testingFeeList;

   public static ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder builder() {
      return new ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder();
   }

   public ContractTestingFeeSummaryDTO() {
   }

   public ContractTestingFeeSummaryDTO(
      final ProjectInfo project, final Long testingFeeTypeId, final String testingFeeTypeName, final List<TestingFeeMonthDTO> testingFeeList
   ) {
      this.project = project;
      this.testingFeeTypeId = testingFeeTypeId;
      this.testingFeeTypeName = testingFeeTypeName;
      this.testingFeeList = testingFeeList;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getTestingFeeTypeId() {
      return this.testingFeeTypeId;
   }

   public String getTestingFeeTypeName() {
      return this.testingFeeTypeName;
   }

   public List<TestingFeeMonthDTO> getTestingFeeList() {
      return this.testingFeeList;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setTestingFeeTypeId(final Long testingFeeTypeId) {
      this.testingFeeTypeId = testingFeeTypeId;
   }

   public void setTestingFeeTypeName(final String testingFeeTypeName) {
      this.testingFeeTypeName = testingFeeTypeName;
   }

   public void setTestingFeeList(final List<TestingFeeMonthDTO> testingFeeList) {
      this.testingFeeList = testingFeeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTestingFeeSummaryDTO)) {
         return false;
      }

      ContractTestingFeeSummaryDTO other = (ContractTestingFeeSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$testingFeeTypeId = this.getTestingFeeTypeId();
      Object other$testingFeeTypeId = other.getTestingFeeTypeId();
      if (this$testingFeeTypeId == null ? other$testingFeeTypeId == null : this$testingFeeTypeId.equals(other$testingFeeTypeId)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$testingFeeTypeName = this.getTestingFeeTypeName();
            Object other$testingFeeTypeName = other.getTestingFeeTypeName();
            if (this$testingFeeTypeName == null ? other$testingFeeTypeName == null : this$testingFeeTypeName.equals(other$testingFeeTypeName)) {
               Object this$testingFeeList = this.getTestingFeeList();
               Object other$testingFeeList = other.getTestingFeeList();
               return this$testingFeeList == null ? other$testingFeeList == null : this$testingFeeList.equals(other$testingFeeList);
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
      return other instanceof ContractTestingFeeSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $testingFeeTypeId = this.getTestingFeeTypeId();
      result = result * 59 + ($testingFeeTypeId == null ? 43 : $testingFeeTypeId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $testingFeeTypeName = this.getTestingFeeTypeName();
      result = result * 59 + ($testingFeeTypeName == null ? 43 : $testingFeeTypeName.hashCode());
      Object $testingFeeList = this.getTestingFeeList();
      return result * 59 + ($testingFeeList == null ? 43 : $testingFeeList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTestingFeeSummaryDTO(project="
         + this.getProject()
         + ", testingFeeTypeId="
         + this.getTestingFeeTypeId()
         + ", testingFeeTypeName="
         + this.getTestingFeeTypeName()
         + ", testingFeeList="
         + this.getTestingFeeList()
         + ")";
   }

   public static class ContractTestingFeeSummaryDTOBuilder {
      private ProjectInfo project;
      private Long testingFeeTypeId;
      private String testingFeeTypeName;
      private List<TestingFeeMonthDTO> testingFeeList;

      ContractTestingFeeSummaryDTOBuilder() {
      }

      public ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder testingFeeTypeId(final Long testingFeeTypeId) {
         this.testingFeeTypeId = testingFeeTypeId;
         return this;
      }

      public ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder testingFeeTypeName(final String testingFeeTypeName) {
         this.testingFeeTypeName = testingFeeTypeName;
         return this;
      }

      public ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder testingFeeList(final List<TestingFeeMonthDTO> testingFeeList) {
         this.testingFeeList = testingFeeList;
         return this;
      }

      public ContractTestingFeeSummaryDTO build() {
         return new ContractTestingFeeSummaryDTO(this.project, this.testingFeeTypeId, this.testingFeeTypeName, this.testingFeeList);
      }

      @Override
      public String toString() {
         return "ContractTestingFeeSummaryDTO.ContractTestingFeeSummaryDTOBuilder(project="
            + this.project
            + ", testingFeeTypeId="
            + this.testingFeeTypeId
            + ", testingFeeTypeName="
            + this.testingFeeTypeName
            + ", testingFeeList="
            + this.testingFeeList
            + ")";
      }
   }
}
