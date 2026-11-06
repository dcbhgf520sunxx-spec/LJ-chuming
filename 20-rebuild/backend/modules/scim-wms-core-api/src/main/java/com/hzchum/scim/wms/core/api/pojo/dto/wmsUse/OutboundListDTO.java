package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OutboundListDTO {
   private Long id;
   private Integer basicClass;
   private Boolean boolPrinted;
   private List<ProjectInfoDTO> projects;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private String applicationSN;
   @JsonInclude(Include.NON_NULL)
   private String applicantName;
   @JsonInclude(Include.NON_NULL)
   private String reviewerName;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime reviewTime;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime userUpdateTime;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime outboundTime;
   private LocalDateTime createTime;
   private LocalDateTime outboundEarliestTime;
   private LocalDateTime outboundLatestTime;
   private String materialSerialNumber;
   private BriefIdAndNameDTO mesWorkshop;
   private BriefIdAndNameDTO applicant;
   private BigDecimal quantityCount;
   private BigDecimal meteCount;
   private String taskOrderNumber;
   private Integer reviewStatus;
   private Integer schedulingDataSource;
   private BriefIdAndNameDTO Scheduler;
   private List<OutboundDetailDTO> details;
   private Integer outboundTypeSelection;

   public static OutboundListDTO.OutboundListDTOBuilder builder() {
      return new OutboundListDTO.OutboundListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getApplicationSN() {
      return this.applicationSN;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getOutboundEarliestTime() {
      return this.outboundEarliestTime;
   }

   public LocalDateTime getOutboundLatestTime() {
      return this.outboundLatestTime;
   }

   public String getMaterialSerialNumber() {
      return this.materialSerialNumber;
   }

   public BriefIdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public BriefIdAndNameDTO getApplicant() {
      return this.applicant;
   }

   public BigDecimal getQuantityCount() {
      return this.quantityCount;
   }

   public BigDecimal getMeteCount() {
      return this.meteCount;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getSchedulingDataSource() {
      return this.schedulingDataSource;
   }

   public BriefIdAndNameDTO getScheduler() {
      return this.Scheduler;
   }

   public List<OutboundDetailDTO> getDetails() {
      return this.details;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicationSN(final String applicationSN) {
      this.applicationSN = applicationSN;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setOutboundEarliestTime(final LocalDateTime outboundEarliestTime) {
      this.outboundEarliestTime = outboundEarliestTime;
   }

   public void setOutboundLatestTime(final LocalDateTime outboundLatestTime) {
      this.outboundLatestTime = outboundLatestTime;
   }

   public void setMaterialSerialNumber(final String materialSerialNumber) {
      this.materialSerialNumber = materialSerialNumber;
   }

   public void setMesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setApplicant(final BriefIdAndNameDTO applicant) {
      this.applicant = applicant;
   }

   public void setQuantityCount(final BigDecimal quantityCount) {
      this.quantityCount = quantityCount;
   }

   public void setMeteCount(final BigDecimal meteCount) {
      this.meteCount = meteCount;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setSchedulingDataSource(final Integer schedulingDataSource) {
      this.schedulingDataSource = schedulingDataSource;
   }

   public void setScheduler(final BriefIdAndNameDTO Scheduler) {
      this.Scheduler = Scheduler;
   }

   public void setDetails(final List<OutboundDetailDTO> details) {
      this.details = details;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundListDTO)) {
         return false;
      }

      OutboundListDTO other = (OutboundListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolPrinted = this.getBoolPrinted();
            Object other$boolPrinted = other.getBoolPrinted();
            if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$schedulingDataSource = this.getSchedulingDataSource();
                  Object other$schedulingDataSource = other.getSchedulingDataSource();
                  if (this$schedulingDataSource == null ? other$schedulingDataSource == null : this$schedulingDataSource.equals(other$schedulingDataSource)) {
                     Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                     Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                     if (this$outboundTypeSelection == null
                        ? other$outboundTypeSelection == null
                        : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                        Object this$projects = this.getProjects();
                        Object other$projects = other.getProjects();
                        if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$applicationSN = this.getApplicationSN();
                              Object other$applicationSN = other.getApplicationSN();
                              if (this$applicationSN == null ? other$applicationSN == null : this$applicationSN.equals(other$applicationSN)) {
                                 Object this$applicantName = this.getApplicantName();
                                 Object other$applicantName = other.getApplicantName();
                                 if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                    Object this$reviewerName = this.getReviewerName();
                                    Object other$reviewerName = other.getReviewerName();
                                    if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                       Object this$reviewTime = this.getReviewTime();
                                       Object other$reviewTime = other.getReviewTime();
                                       if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                          Object this$userUpdateTime = this.getUserUpdateTime();
                                          Object other$userUpdateTime = other.getUserUpdateTime();
                                          if (this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime)) {
                                             Object this$outboundTime = this.getOutboundTime();
                                             Object other$outboundTime = other.getOutboundTime();
                                             if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$outboundEarliestTime = this.getOutboundEarliestTime();
                                                   Object other$outboundEarliestTime = other.getOutboundEarliestTime();
                                                   if (this$outboundEarliestTime == null
                                                      ? other$outboundEarliestTime == null
                                                      : this$outboundEarliestTime.equals(other$outboundEarliestTime)) {
                                                      Object this$outboundLatestTime = this.getOutboundLatestTime();
                                                      Object other$outboundLatestTime = other.getOutboundLatestTime();
                                                      if (this$outboundLatestTime == null
                                                         ? other$outboundLatestTime == null
                                                         : this$outboundLatestTime.equals(other$outboundLatestTime)) {
                                                         Object this$materialSerialNumber = this.getMaterialSerialNumber();
                                                         Object other$materialSerialNumber = other.getMaterialSerialNumber();
                                                         if (this$materialSerialNumber == null
                                                            ? other$materialSerialNumber == null
                                                            : this$materialSerialNumber.equals(other$materialSerialNumber)) {
                                                            Object this$mesWorkshop = this.getMesWorkshop();
                                                            Object other$mesWorkshop = other.getMesWorkshop();
                                                            if (this$mesWorkshop == null
                                                               ? other$mesWorkshop == null
                                                               : this$mesWorkshop.equals(other$mesWorkshop)) {
                                                               Object this$applicant = this.getApplicant();
                                                               Object other$applicant = other.getApplicant();
                                                               if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                                                                  Object this$quantityCount = this.getQuantityCount();
                                                                  Object other$quantityCount = other.getQuantityCount();
                                                                  if (this$quantityCount == null
                                                                     ? other$quantityCount == null
                                                                     : this$quantityCount.equals(other$quantityCount)) {
                                                                     Object this$meteCount = this.getMeteCount();
                                                                     Object other$meteCount = other.getMeteCount();
                                                                     if (this$meteCount == null
                                                                        ? other$meteCount == null
                                                                        : this$meteCount.equals(other$meteCount)) {
                                                                        Object this$taskOrderNumber = this.getTaskOrderNumber();
                                                                        Object other$taskOrderNumber = other.getTaskOrderNumber();
                                                                        if (this$taskOrderNumber == null
                                                                           ? other$taskOrderNumber == null
                                                                           : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                                                           Object this$Scheduler = this.getScheduler();
                                                                           Object other$Scheduler = other.getScheduler();
                                                                           if (this$Scheduler == null
                                                                              ? other$Scheduler == null
                                                                              : this$Scheduler.equals(other$Scheduler)) {
                                                                              Object this$details = this.getDetails();
                                                                              Object other$details = other.getDetails();
                                                                              return this$details == null
                                                                                 ? other$details == null
                                                                                 : this$details.equals(other$details);
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
      return other instanceof OutboundListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $schedulingDataSource = this.getSchedulingDataSource();
      result = result * 59 + ($schedulingDataSource == null ? 43 : $schedulingDataSource.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicationSN = this.getApplicationSN();
      result = result * 59 + ($applicationSN == null ? 43 : $applicationSN.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $outboundEarliestTime = this.getOutboundEarliestTime();
      result = result * 59 + ($outboundEarliestTime == null ? 43 : $outboundEarliestTime.hashCode());
      Object $outboundLatestTime = this.getOutboundLatestTime();
      result = result * 59 + ($outboundLatestTime == null ? 43 : $outboundLatestTime.hashCode());
      Object $materialSerialNumber = this.getMaterialSerialNumber();
      result = result * 59 + ($materialSerialNumber == null ? 43 : $materialSerialNumber.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $Scheduler = this.getScheduler();
      result = result * 59 + ($Scheduler == null ? 43 : $Scheduler.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundListDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", projects="
         + this.getProjects()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicationSN="
         + this.getApplicationSN()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", createTime="
         + this.getCreateTime()
         + ", outboundEarliestTime="
         + this.getOutboundEarliestTime()
         + ", outboundLatestTime="
         + this.getOutboundLatestTime()
         + ", materialSerialNumber="
         + this.getMaterialSerialNumber()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", applicant="
         + this.getApplicant()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", schedulingDataSource="
         + this.getSchedulingDataSource()
         + ", Scheduler="
         + this.getScheduler()
         + ", details="
         + this.getDetails()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ")";
   }

   public OutboundListDTO(
      final Long id,
      final Integer basicClass,
      final Boolean boolPrinted,
      final List<ProjectInfoDTO> projects,
      final String serialNumber,
      final String applicationSN,
      final String applicantName,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final LocalDateTime userUpdateTime,
      final LocalDateTime outboundTime,
      final LocalDateTime createTime,
      final LocalDateTime outboundEarliestTime,
      final LocalDateTime outboundLatestTime,
      final String materialSerialNumber,
      final BriefIdAndNameDTO mesWorkshop,
      final BriefIdAndNameDTO applicant,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final String taskOrderNumber,
      final Integer reviewStatus,
      final Integer schedulingDataSource,
      final BriefIdAndNameDTO Scheduler,
      final List<OutboundDetailDTO> details,
      final Integer outboundTypeSelection
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.boolPrinted = boolPrinted;
      this.projects = projects;
      this.serialNumber = serialNumber;
      this.applicationSN = applicationSN;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.userUpdateTime = userUpdateTime;
      this.outboundTime = outboundTime;
      this.createTime = createTime;
      this.outboundEarliestTime = outboundEarliestTime;
      this.outboundLatestTime = outboundLatestTime;
      this.materialSerialNumber = materialSerialNumber;
      this.mesWorkshop = mesWorkshop;
      this.applicant = applicant;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.taskOrderNumber = taskOrderNumber;
      this.reviewStatus = reviewStatus;
      this.schedulingDataSource = schedulingDataSource;
      this.Scheduler = Scheduler;
      this.details = details;
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public OutboundListDTO() {
   }

   public static class OutboundListDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Boolean boolPrinted;
      private List<ProjectInfoDTO> projects;
      private String serialNumber;
      private String applicationSN;
      private String applicantName;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private LocalDateTime userUpdateTime;
      private LocalDateTime outboundTime;
      private LocalDateTime createTime;
      private LocalDateTime outboundEarliestTime;
      private LocalDateTime outboundLatestTime;
      private String materialSerialNumber;
      private BriefIdAndNameDTO mesWorkshop;
      private BriefIdAndNameDTO applicant;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private String taskOrderNumber;
      private Integer reviewStatus;
      private Integer schedulingDataSource;
      private BriefIdAndNameDTO Scheduler;
      private List<OutboundDetailDTO> details;
      private Integer outboundTypeSelection;

      OutboundListDTOBuilder() {
      }

      public OutboundListDTO.OutboundListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder projects(final List<ProjectInfoDTO> projects) {
         this.projects = projects;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder applicationSN(final String applicationSN) {
         this.applicationSN = applicationSN;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder outboundEarliestTime(final LocalDateTime outboundEarliestTime) {
         this.outboundEarliestTime = outboundEarliestTime;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder outboundLatestTime(final LocalDateTime outboundLatestTime) {
         this.outboundLatestTime = outboundLatestTime;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder materialSerialNumber(final String materialSerialNumber) {
         this.materialSerialNumber = materialSerialNumber;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder mesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder applicant(final BriefIdAndNameDTO applicant) {
         this.applicant = applicant;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder schedulingDataSource(final Integer schedulingDataSource) {
         this.schedulingDataSource = schedulingDataSource;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder Scheduler(final BriefIdAndNameDTO Scheduler) {
         this.Scheduler = Scheduler;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder details(final List<OutboundDetailDTO> details) {
         this.details = details;
         return this;
      }

      public OutboundListDTO.OutboundListDTOBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public OutboundListDTO build() {
         return new OutboundListDTO(
            this.id,
            this.basicClass,
            this.boolPrinted,
            this.projects,
            this.serialNumber,
            this.applicationSN,
            this.applicantName,
            this.reviewerName,
            this.reviewTime,
            this.userUpdateTime,
            this.outboundTime,
            this.createTime,
            this.outboundEarliestTime,
            this.outboundLatestTime,
            this.materialSerialNumber,
            this.mesWorkshop,
            this.applicant,
            this.quantityCount,
            this.meteCount,
            this.taskOrderNumber,
            this.reviewStatus,
            this.schedulingDataSource,
            this.Scheduler,
            this.details,
            this.outboundTypeSelection
         );
      }

      @Override
      public String toString() {
         return "OutboundListDTO.OutboundListDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", boolPrinted="
            + this.boolPrinted
            + ", projects="
            + this.projects
            + ", serialNumber="
            + this.serialNumber
            + ", applicationSN="
            + this.applicationSN
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", outboundTime="
            + this.outboundTime
            + ", createTime="
            + this.createTime
            + ", outboundEarliestTime="
            + this.outboundEarliestTime
            + ", outboundLatestTime="
            + this.outboundLatestTime
            + ", materialSerialNumber="
            + this.materialSerialNumber
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", applicant="
            + this.applicant
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", reviewStatus="
            + this.reviewStatus
            + ", schedulingDataSource="
            + this.schedulingDataSource
            + ", Scheduler="
            + this.Scheduler
            + ", details="
            + this.details
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ")";
      }
   }
}
