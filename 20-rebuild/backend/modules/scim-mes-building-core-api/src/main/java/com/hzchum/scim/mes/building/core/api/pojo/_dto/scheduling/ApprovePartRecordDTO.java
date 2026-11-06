package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ApprovePartRecordDTO", description = "型材排产记录 ")
public class ApprovePartRecordDTO {
   private Long id;
   private Long schedulingId;
   private Integer jobId;
   private String orderNumber;
   private Integer approveType;
   private LocalDateTime approveDate;
   private String workshopName;
   private String teamName;
   private String type;
   private Integer status;
   private String projectName;
   private Long projectId;
   private String projectSerialNumber;
   @ApiModelProperty(name = "weight", value = "领用重量", notes = "领用重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private Double weight;
   @ApiModelProperty(name = "boolRequest", value = "是否领料", notes = "是否领料")
   @JsonProperty("boolRequest")
   @JSONField(name = "boolRequest")
   private Boolean boolRequest;
   @ApiModelProperty(name = "wmsApproveRecordId", value = "审批记录id", notes = "审批记录id")
   @JsonProperty("wmsApproveRecordId")
   @JSONField(name = "wmsApproveRecordId")
   private Long wmsApproveRecordId;

   public static ApprovePartRecordDTO.ApprovePartRecordDTOBuilder builder() {
      return new ApprovePartRecordDTO.ApprovePartRecordDTOBuilder();
   }

   public ApprovePartRecordDTO() {
   }

   public ApprovePartRecordDTO(
      final Long id,
      final Long schedulingId,
      final Integer jobId,
      final String orderNumber,
      final Integer approveType,
      final LocalDateTime approveDate,
      final String workshopName,
      final String teamName,
      final String type,
      final Integer status,
      final String projectName,
      final Long projectId,
      final String projectSerialNumber,
      final Double weight,
      final Boolean boolRequest,
      final Long wmsApproveRecordId
   ) {
      this.id = id;
      this.schedulingId = schedulingId;
      this.jobId = jobId;
      this.orderNumber = orderNumber;
      this.approveType = approveType;
      this.approveDate = approveDate;
      this.workshopName = workshopName;
      this.teamName = teamName;
      this.type = type;
      this.status = status;
      this.projectName = projectName;
      this.projectId = projectId;
      this.projectSerialNumber = projectSerialNumber;
      this.weight = weight;
      this.boolRequest = boolRequest;
      this.wmsApproveRecordId = wmsApproveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getApproveType() {
      return this.approveType;
   }

   public LocalDateTime getApproveDate() {
      return this.approveDate;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getType() {
      return this.type;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public Double getWeight() {
      return this.weight;
   }

   public Boolean getBoolRequest() {
      return this.boolRequest;
   }

   public Long getWmsApproveRecordId() {
      return this.wmsApproveRecordId;
   }

   public ApprovePartRecordDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ApprovePartRecordDTO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   public ApprovePartRecordDTO setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public ApprovePartRecordDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public ApprovePartRecordDTO setApproveType(final Integer approveType) {
      this.approveType = approveType;
      return this;
   }

   public ApprovePartRecordDTO setApproveDate(final LocalDateTime approveDate) {
      this.approveDate = approveDate;
      return this;
   }

   public ApprovePartRecordDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public ApprovePartRecordDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public ApprovePartRecordDTO setType(final String type) {
      this.type = type;
      return this;
   }

   public ApprovePartRecordDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ApprovePartRecordDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ApprovePartRecordDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ApprovePartRecordDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   @JsonProperty("weight")
   public ApprovePartRecordDTO setWeight(final Double weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("boolRequest")
   public ApprovePartRecordDTO setBoolRequest(final Boolean boolRequest) {
      this.boolRequest = boolRequest;
      return this;
   }

   @JsonProperty("wmsApproveRecordId")
   public ApprovePartRecordDTO setWmsApproveRecordId(final Long wmsApproveRecordId) {
      this.wmsApproveRecordId = wmsApproveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "ApprovePartRecordDTO(id="
         + this.getId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", jobId="
         + this.getJobId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", approveType="
         + this.getApproveType()
         + ", approveDate="
         + this.getApproveDate()
         + ", workshopName="
         + this.getWorkshopName()
         + ", teamName="
         + this.getTeamName()
         + ", type="
         + this.getType()
         + ", status="
         + this.getStatus()
         + ", projectName="
         + this.getProjectName()
         + ", projectId="
         + this.getProjectId()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", weight="
         + this.getWeight()
         + ", boolRequest="
         + this.getBoolRequest()
         + ", wmsApproveRecordId="
         + this.getWmsApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApprovePartRecordDTO)) {
         return false;
      }

      ApprovePartRecordDTO other = (ApprovePartRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$schedulingId = this.getSchedulingId();
         Object other$schedulingId = other.getSchedulingId();
         if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$approveType = this.getApproveType();
               Object other$approveType = other.getApproveType();
               if (this$approveType == null ? other$approveType == null : this$approveType.equals(other$approveType)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$weight = this.getWeight();
                        Object other$weight = other.getWeight();
                        if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                           Object this$boolRequest = this.getBoolRequest();
                           Object other$boolRequest = other.getBoolRequest();
                           if (this$boolRequest == null ? other$boolRequest == null : this$boolRequest.equals(other$boolRequest)) {
                              Object this$wmsApproveRecordId = this.getWmsApproveRecordId();
                              Object other$wmsApproveRecordId = other.getWmsApproveRecordId();
                              if (this$wmsApproveRecordId == null ? other$wmsApproveRecordId == null : this$wmsApproveRecordId.equals(other$wmsApproveRecordId)
                                 )
                               {
                                 Object this$orderNumber = this.getOrderNumber();
                                 Object other$orderNumber = other.getOrderNumber();
                                 if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                    Object this$approveDate = this.getApproveDate();
                                    Object other$approveDate = other.getApproveDate();
                                    if (this$approveDate == null ? other$approveDate == null : this$approveDate.equals(other$approveDate)) {
                                       Object this$workshopName = this.getWorkshopName();
                                       Object other$workshopName = other.getWorkshopName();
                                       if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                          Object this$teamName = this.getTeamName();
                                          Object other$teamName = other.getTeamName();
                                          if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                             Object this$type = this.getType();
                                             Object other$type = other.getType();
                                             if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                Object this$projectName = this.getProjectName();
                                                Object other$projectName = other.getProjectName();
                                                if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                   Object this$projectSerialNumber = this.getProjectSerialNumber();
                                                   Object other$projectSerialNumber = other.getProjectSerialNumber();
                                                   return this$projectSerialNumber == null
                                                      ? other$projectSerialNumber == null
                                                      : this$projectSerialNumber.equals(other$projectSerialNumber);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApprovePartRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $approveType = this.getApproveType();
      result = result * 59 + ($approveType == null ? 43 : $approveType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $boolRequest = this.getBoolRequest();
      result = result * 59 + ($boolRequest == null ? 43 : $boolRequest.hashCode());
      Object $wmsApproveRecordId = this.getWmsApproveRecordId();
      result = result * 59 + ($wmsApproveRecordId == null ? 43 : $wmsApproveRecordId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $approveDate = this.getApproveDate();
      result = result * 59 + ($approveDate == null ? 43 : $approveDate.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      return result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
   }

   public static class ApprovePartRecordDTOBuilder {
      private Long id;
      private Long schedulingId;
      private Integer jobId;
      private String orderNumber;
      private Integer approveType;
      private LocalDateTime approveDate;
      private String workshopName;
      private String teamName;
      private String type;
      private Integer status;
      private String projectName;
      private Long projectId;
      private String projectSerialNumber;
      private Double weight;
      private Boolean boolRequest;
      private Long wmsApproveRecordId;

      ApprovePartRecordDTOBuilder() {
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder approveType(final Integer approveType) {
         this.approveType = approveType;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder approveDate(final LocalDateTime approveDate) {
         this.approveDate = approveDate;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      @JsonProperty("weight")
      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder weight(final Double weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("boolRequest")
      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder boolRequest(final Boolean boolRequest) {
         this.boolRequest = boolRequest;
         return this;
      }

      @JsonProperty("wmsApproveRecordId")
      public ApprovePartRecordDTO.ApprovePartRecordDTOBuilder wmsApproveRecordId(final Long wmsApproveRecordId) {
         this.wmsApproveRecordId = wmsApproveRecordId;
         return this;
      }

      public ApprovePartRecordDTO build() {
         return new ApprovePartRecordDTO(
            this.id,
            this.schedulingId,
            this.jobId,
            this.orderNumber,
            this.approveType,
            this.approveDate,
            this.workshopName,
            this.teamName,
            this.type,
            this.status,
            this.projectName,
            this.projectId,
            this.projectSerialNumber,
            this.weight,
            this.boolRequest,
            this.wmsApproveRecordId
         );
      }

      @Override
      public String toString() {
         return "ApprovePartRecordDTO.ApprovePartRecordDTOBuilder(id="
            + this.id
            + ", schedulingId="
            + this.schedulingId
            + ", jobId="
            + this.jobId
            + ", orderNumber="
            + this.orderNumber
            + ", approveType="
            + this.approveType
            + ", approveDate="
            + this.approveDate
            + ", workshopName="
            + this.workshopName
            + ", teamName="
            + this.teamName
            + ", type="
            + this.type
            + ", status="
            + this.status
            + ", projectName="
            + this.projectName
            + ", projectId="
            + this.projectId
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", weight="
            + this.weight
            + ", boolRequest="
            + this.boolRequest
            + ", wmsApproveRecordId="
            + this.wmsApproveRecordId
            + ")";
      }
   }
}
