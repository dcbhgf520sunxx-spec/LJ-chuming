package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("安装填报新增-请求类")
public class ProjectInstallReportSaveDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "productType", value = "产品类型: 建钢项目 2构件 4围护 8配套件 桥梁项目: 1分段件 2单元件 4零件 8配套件")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @Valid
   @NotEmpty(message = "产品类型不能为空")
   @ApiModelProperty(name = "reportDTOParamList", value = "产品列表")
   private List<InstallReportDTOParam> reportDTOParamList;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public List<InstallReportDTOParam> getReportDTOParamList() {
      return this.reportDTOParamList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setReportDTOParamList(final List<InstallReportDTOParam> reportDTOParamList) {
      this.reportDTOParamList = reportDTOParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallReportSaveDTOParam)) {
         return false;
      }

      ProjectInstallReportSaveDTOParam other = (ProjectInstallReportSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$reportDTOParamList = this.getReportDTOParamList();
            Object other$reportDTOParamList = other.getReportDTOParamList();
            return this$reportDTOParamList == null ? other$reportDTOParamList == null : this$reportDTOParamList.equals(other$reportDTOParamList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallReportSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $reportDTOParamList = this.getReportDTOParamList();
      return result * 59 + ($reportDTOParamList == null ? 43 : $reportDTOParamList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallReportSaveDTOParam(projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", reportDTOParamList="
         + this.getReportDTOParamList()
         + ")";
   }
}
