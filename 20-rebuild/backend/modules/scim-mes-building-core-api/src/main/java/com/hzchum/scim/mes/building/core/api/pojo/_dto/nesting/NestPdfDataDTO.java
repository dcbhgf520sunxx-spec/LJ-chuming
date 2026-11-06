package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ExcelTarget("NestPdfDataDTO")
@ApiModel(value = "零件套料在线PDF数据", description = "零件套料在线PDF数据")
public class NestPdfDataDTO {
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "teamName", value = "班组名称", notes = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "jobName", value = "作业名称", notes = "作业名称")
   @JsonProperty("jobName")
   @JSONField(name = "jobName")
   private String jobName;
   @ApiModelProperty(name = "deviceName", value = "设备名称", notes = "设备名称")
   @JsonProperty("deviceName")
   @JSONField(name = "deviceName")
   private String deviceName;
   @ApiModelProperty(name = "schedulingDate", value = "排产日期", notes = "排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   private String schedulingDate;
   @ApiModelProperty(name = "schedulingUser", value = "排产人", notes = "排产人")
   @JsonProperty("schedulingUser")
   @JSONField(name = "schedulingUser")
   private String schedulingUser;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private String thickness;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "utilization", value = "利用率", notes = "利用率")
   @JsonProperty("utilization")
   @JSONField(name = "utilization")
   private String utilization;
   @ApiModelProperty(name = "cutLength", value = "切割长度", notes = "切割长度")
   @JsonProperty("cutLength")
   @JSONField(name = "cutLength")
   private String cutLength;
   @ApiModelProperty(name = "cutTime", value = "切割时长", notes = "切割时长")
   @JsonProperty("cutTime")
   @JSONField(name = "cutTime")
   private String cutTime;
   @ApiModelProperty(name = "imageUrl", value = "图片地址", notes = "图片地址")
   @JsonProperty("imageUrl")
   @JSONField(name = "imageUrl")
   private String imageUrl;
   @ApiModelProperty(name = "partInfoList", value = "零件集合", notes = "零件集合")
   @JsonProperty("partInfoList")
   @JSONField(name = "partInfoList")
   private List<List<String>> partInfoList;

   public static NestPdfDataDTO.NestPdfDataDTOBuilder builder() {
      return new NestPdfDataDTO.NestPdfDataDTOBuilder();
   }

   public NestPdfDataDTO(
      final String projectName,
      final String teamName,
      final String jobName,
      final String deviceName,
      final String schedulingDate,
      final String schedulingUser,
      final String thickness,
      final String material,
      final String specification,
      final String utilization,
      final String cutLength,
      final String cutTime,
      final String imageUrl,
      final List<List<String>> partInfoList
   ) {
      this.projectName = projectName;
      this.teamName = teamName;
      this.jobName = jobName;
      this.deviceName = deviceName;
      this.schedulingDate = schedulingDate;
      this.schedulingUser = schedulingUser;
      this.thickness = thickness;
      this.material = material;
      this.specification = specification;
      this.utilization = utilization;
      this.cutLength = cutLength;
      this.cutTime = cutTime;
      this.imageUrl = imageUrl;
      this.partInfoList = partInfoList;
   }

   public NestPdfDataDTO() {
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getJobName() {
      return this.jobName;
   }

   public String getDeviceName() {
      return this.deviceName;
   }

   public String getSchedulingDate() {
      return this.schedulingDate;
   }

   public String getSchedulingUser() {
      return this.schedulingUser;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getUtilization() {
      return this.utilization;
   }

   public String getCutLength() {
      return this.cutLength;
   }

   public String getCutTime() {
      return this.cutTime;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public List<List<String>> getPartInfoList() {
      return this.partInfoList;
   }

   @JsonProperty("projectName")
   public NestPdfDataDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("teamName")
   public NestPdfDataDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("jobName")
   public NestPdfDataDTO setJobName(final String jobName) {
      this.jobName = jobName;
      return this;
   }

   @JsonProperty("deviceName")
   public NestPdfDataDTO setDeviceName(final String deviceName) {
      this.deviceName = deviceName;
      return this;
   }

   @JsonProperty("schedulingDate")
   public NestPdfDataDTO setSchedulingDate(final String schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("schedulingUser")
   public NestPdfDataDTO setSchedulingUser(final String schedulingUser) {
      this.schedulingUser = schedulingUser;
      return this;
   }

   @JsonProperty("thickness")
   public NestPdfDataDTO setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("material")
   public NestPdfDataDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("specification")
   public NestPdfDataDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("utilization")
   public NestPdfDataDTO setUtilization(final String utilization) {
      this.utilization = utilization;
      return this;
   }

   @JsonProperty("cutLength")
   public NestPdfDataDTO setCutLength(final String cutLength) {
      this.cutLength = cutLength;
      return this;
   }

   @JsonProperty("cutTime")
   public NestPdfDataDTO setCutTime(final String cutTime) {
      this.cutTime = cutTime;
      return this;
   }

   @JsonProperty("imageUrl")
   public NestPdfDataDTO setImageUrl(final String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
   }

   @JsonProperty("partInfoList")
   public NestPdfDataDTO setPartInfoList(final List<List<String>> partInfoList) {
      this.partInfoList = partInfoList;
      return this;
   }

   @Override
   public String toString() {
      return "NestPdfDataDTO(projectName="
         + this.getProjectName()
         + ", teamName="
         + this.getTeamName()
         + ", jobName="
         + this.getJobName()
         + ", deviceName="
         + this.getDeviceName()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", schedulingUser="
         + this.getSchedulingUser()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", utilization="
         + this.getUtilization()
         + ", cutLength="
         + this.getCutLength()
         + ", cutTime="
         + this.getCutTime()
         + ", imageUrl="
         + this.getImageUrl()
         + ", partInfoList="
         + this.getPartInfoList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestPdfDataDTO)) {
         return false;
      }

      NestPdfDataDTO other = (NestPdfDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$teamName = this.getTeamName();
         Object other$teamName = other.getTeamName();
         if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
            Object this$jobName = this.getJobName();
            Object other$jobName = other.getJobName();
            if (this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName)) {
               Object this$deviceName = this.getDeviceName();
               Object other$deviceName = other.getDeviceName();
               if (this$deviceName == null ? other$deviceName == null : this$deviceName.equals(other$deviceName)) {
                  Object this$schedulingDate = this.getSchedulingDate();
                  Object other$schedulingDate = other.getSchedulingDate();
                  if (this$schedulingDate == null ? other$schedulingDate == null : this$schedulingDate.equals(other$schedulingDate)) {
                     Object this$schedulingUser = this.getSchedulingUser();
                     Object other$schedulingUser = other.getSchedulingUser();
                     if (this$schedulingUser == null ? other$schedulingUser == null : this$schedulingUser.equals(other$schedulingUser)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$utilization = this.getUtilization();
                                 Object other$utilization = other.getUtilization();
                                 if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                                    Object this$cutLength = this.getCutLength();
                                    Object other$cutLength = other.getCutLength();
                                    if (this$cutLength == null ? other$cutLength == null : this$cutLength.equals(other$cutLength)) {
                                       Object this$cutTime = this.getCutTime();
                                       Object other$cutTime = other.getCutTime();
                                       if (this$cutTime == null ? other$cutTime == null : this$cutTime.equals(other$cutTime)) {
                                          Object this$imageUrl = this.getImageUrl();
                                          Object other$imageUrl = other.getImageUrl();
                                          if (this$imageUrl == null ? other$imageUrl == null : this$imageUrl.equals(other$imageUrl)) {
                                             Object this$partInfoList = this.getPartInfoList();
                                             Object other$partInfoList = other.getPartInfoList();
                                             return this$partInfoList == null ? other$partInfoList == null : this$partInfoList.equals(other$partInfoList);
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
      return other instanceof NestPdfDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $deviceName = this.getDeviceName();
      result = result * 59 + ($deviceName == null ? 43 : $deviceName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $schedulingUser = this.getSchedulingUser();
      result = result * 59 + ($schedulingUser == null ? 43 : $schedulingUser.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $cutLength = this.getCutLength();
      result = result * 59 + ($cutLength == null ? 43 : $cutLength.hashCode());
      Object $cutTime = this.getCutTime();
      result = result * 59 + ($cutTime == null ? 43 : $cutTime.hashCode());
      Object $imageUrl = this.getImageUrl();
      result = result * 59 + ($imageUrl == null ? 43 : $imageUrl.hashCode());
      Object $partInfoList = this.getPartInfoList();
      return result * 59 + ($partInfoList == null ? 43 : $partInfoList.hashCode());
   }

   public static class NestPdfDataDTOBuilder {
      private String projectName;
      private String teamName;
      private String jobName;
      private String deviceName;
      private String schedulingDate;
      private String schedulingUser;
      private String thickness;
      private String material;
      private String specification;
      private String utilization;
      private String cutLength;
      private String cutTime;
      private String imageUrl;
      private List<List<String>> partInfoList;

      NestPdfDataDTOBuilder() {
      }

      @JsonProperty("projectName")
      public NestPdfDataDTO.NestPdfDataDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("teamName")
      public NestPdfDataDTO.NestPdfDataDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("jobName")
      public NestPdfDataDTO.NestPdfDataDTOBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      @JsonProperty("deviceName")
      public NestPdfDataDTO.NestPdfDataDTOBuilder deviceName(final String deviceName) {
         this.deviceName = deviceName;
         return this;
      }

      @JsonProperty("schedulingDate")
      public NestPdfDataDTO.NestPdfDataDTOBuilder schedulingDate(final String schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("schedulingUser")
      public NestPdfDataDTO.NestPdfDataDTOBuilder schedulingUser(final String schedulingUser) {
         this.schedulingUser = schedulingUser;
         return this;
      }

      @JsonProperty("thickness")
      public NestPdfDataDTO.NestPdfDataDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("material")
      public NestPdfDataDTO.NestPdfDataDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("specification")
      public NestPdfDataDTO.NestPdfDataDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("utilization")
      public NestPdfDataDTO.NestPdfDataDTOBuilder utilization(final String utilization) {
         this.utilization = utilization;
         return this;
      }

      @JsonProperty("cutLength")
      public NestPdfDataDTO.NestPdfDataDTOBuilder cutLength(final String cutLength) {
         this.cutLength = cutLength;
         return this;
      }

      @JsonProperty("cutTime")
      public NestPdfDataDTO.NestPdfDataDTOBuilder cutTime(final String cutTime) {
         this.cutTime = cutTime;
         return this;
      }

      @JsonProperty("imageUrl")
      public NestPdfDataDTO.NestPdfDataDTOBuilder imageUrl(final String imageUrl) {
         this.imageUrl = imageUrl;
         return this;
      }

      @JsonProperty("partInfoList")
      public NestPdfDataDTO.NestPdfDataDTOBuilder partInfoList(final List<List<String>> partInfoList) {
         this.partInfoList = partInfoList;
         return this;
      }

      public NestPdfDataDTO build() {
         return new NestPdfDataDTO(
            this.projectName,
            this.teamName,
            this.jobName,
            this.deviceName,
            this.schedulingDate,
            this.schedulingUser,
            this.thickness,
            this.material,
            this.specification,
            this.utilization,
            this.cutLength,
            this.cutTime,
            this.imageUrl,
            this.partInfoList
         );
      }

      @Override
      public String toString() {
         return "NestPdfDataDTO.NestPdfDataDTOBuilder(projectName="
            + this.projectName
            + ", teamName="
            + this.teamName
            + ", jobName="
            + this.jobName
            + ", deviceName="
            + this.deviceName
            + ", schedulingDate="
            + this.schedulingDate
            + ", schedulingUser="
            + this.schedulingUser
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", utilization="
            + this.utilization
            + ", cutLength="
            + this.cutLength
            + ", cutTime="
            + this.cutTime
            + ", imageUrl="
            + this.imageUrl
            + ", partInfoList="
            + this.partInfoList
            + ")";
      }
   }
}
