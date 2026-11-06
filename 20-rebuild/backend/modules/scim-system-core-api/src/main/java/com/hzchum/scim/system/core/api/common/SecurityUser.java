package com.hzchum.scim.system.core.api.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {
   private final Long id;
   private final String name;
   private final String username;
   private String ddUserId;
   private Long ddDeptId;
   private Long oaUserId;
   private final String companyName;
   private final Integer sex;
   private final String phone;
   private final String email;
   private final String password;
   private final LocalDateTime createTime;
   private final LocalDateTime lastPasswordResetDate;
   private final List<Role> roles;
   private final Department department;
   private final Job job;
   private final Boolean inventoryNotifyPerm;
   private final Collection<? extends GrantedAuthority> authorities;
   private final List<Menu> menus;
   private final List<String> permissions;
   private final Boolean isEnabled;
   private boolean isAdmin;
   private final Integer userType;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   @JsonIgnore
   @Override
   public String getPassword() {
      return this.password;
   }

   @Override
   public String getUsername() {
      return this.username;
   }

   @JsonIgnore
   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @JsonIgnore
   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @JsonIgnore
   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @JsonIgnore
   @Override
   public boolean isEnabled() {
      return this.isEnabled;
   }

   public SecurityUser(
      Long id,
      String username,
      String name,
      Integer sex,
      String phone,
      String email,
      String password,
      LocalDateTime createTime,
      LocalDateTime lastPasswordResetDate,
      List<Role> roles,
      Department department,
      Job job,
      Collection<? extends GrantedAuthority> authorities,
      List<Menu> menus,
      Boolean isEnabled,
      String companyName,
      List<String> permissions,
      Boolean isAdmin,
      Boolean inventoryNotifyPerm,
      Integer userType,
      String ddUserUId,
      Long ddDeptId,
      Long oaUserId
   ) {
      this.id = id;
      this.username = username;
      this.name = name;
      this.sex = sex;
      this.phone = phone;
      this.email = email;
      this.password = password;
      this.createTime = createTime;
      this.lastPasswordResetDate = lastPasswordResetDate;
      this.roles = roles;
      this.department = department;
      this.job = job;
      this.authorities = authorities;
      this.menus = menus;
      this.isEnabled = isEnabled;
      this.companyName = companyName;
      this.permissions = permissions;
      this.isAdmin = isAdmin;
      this.inventoryNotifyPerm = inventoryNotifyPerm;
      this.userType = userType;
      this.ddUserId = ddUserUId;
      this.ddDeptId = ddDeptId;
      this.oaUserId = oaUserId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getDdUserId() {
      return this.ddUserId;
   }

   public Long getDdDeptId() {
      return this.ddDeptId;
   }

   public Long getOaUserId() {
      return this.oaUserId;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public Integer getSex() {
      return this.sex;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getEmail() {
      return this.email;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getLastPasswordResetDate() {
      return this.lastPasswordResetDate;
   }

   public List<Role> getRoles() {
      return this.roles;
   }

   public Department getDepartment() {
      return this.department;
   }

   public Job getJob() {
      return this.job;
   }

   public Boolean getInventoryNotifyPerm() {
      return this.inventoryNotifyPerm;
   }

   public List<Menu> getMenus() {
      return this.menus;
   }

   public List<String> getPermissions() {
      return this.permissions;
   }

   public Boolean getIsEnabled() {
      return this.isEnabled;
   }

   public boolean isAdmin() {
      return this.isAdmin;
   }

   public Integer getUserType() {
      return this.userType;
   }

   public void setDdUserId(final String ddUserId) {
      this.ddUserId = ddUserId;
   }

   public void setDdDeptId(final Long ddDeptId) {
      this.ddDeptId = ddDeptId;
   }

   public void setOaUserId(final Long oaUserId) {
      this.oaUserId = oaUserId;
   }

   public void setAdmin(final boolean isAdmin) {
      this.isAdmin = isAdmin;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SecurityUser)) {
         return false;
      }

      SecurityUser other = (SecurityUser)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isAdmin() != other.isAdmin()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$ddDeptId = this.getDdDeptId();
         Object other$ddDeptId = other.getDdDeptId();
         if (this$ddDeptId == null ? other$ddDeptId == null : this$ddDeptId.equals(other$ddDeptId)) {
            Object this$oaUserId = this.getOaUserId();
            Object other$oaUserId = other.getOaUserId();
            if (this$oaUserId == null ? other$oaUserId == null : this$oaUserId.equals(other$oaUserId)) {
               Object this$sex = this.getSex();
               Object other$sex = other.getSex();
               if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
                  Object this$inventoryNotifyPerm = this.getInventoryNotifyPerm();
                  Object other$inventoryNotifyPerm = other.getInventoryNotifyPerm();
                  if (this$inventoryNotifyPerm == null ? other$inventoryNotifyPerm == null : this$inventoryNotifyPerm.equals(other$inventoryNotifyPerm)) {
                     Object this$isEnabled = this.getIsEnabled();
                     Object other$isEnabled = other.getIsEnabled();
                     if (this$isEnabled == null ? other$isEnabled == null : this$isEnabled.equals(other$isEnabled)) {
                        Object this$userType = this.getUserType();
                        Object other$userType = other.getUserType();
                        if (this$userType == null ? other$userType == null : this$userType.equals(other$userType)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$username = this.getUsername();
                              Object other$username = other.getUsername();
                              if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                                 Object this$ddUserId = this.getDdUserId();
                                 Object other$ddUserId = other.getDdUserId();
                                 if (this$ddUserId == null ? other$ddUserId == null : this$ddUserId.equals(other$ddUserId)) {
                                    Object this$companyName = this.getCompanyName();
                                    Object other$companyName = other.getCompanyName();
                                    if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                                       Object this$phone = this.getPhone();
                                       Object other$phone = other.getPhone();
                                       if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                          Object this$email = this.getEmail();
                                          Object other$email = other.getEmail();
                                          if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                                             Object this$password = this.getPassword();
                                             Object other$password = other.getPassword();
                                             if (this$password == null ? other$password == null : this$password.equals(other$password)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$lastPasswordResetDate = this.getLastPasswordResetDate();
                                                   Object other$lastPasswordResetDate = other.getLastPasswordResetDate();
                                                   if (this$lastPasswordResetDate == null
                                                      ? other$lastPasswordResetDate == null
                                                      : this$lastPasswordResetDate.equals(other$lastPasswordResetDate)) {
                                                      Object this$roles = this.getRoles();
                                                      Object other$roles = other.getRoles();
                                                      if (this$roles == null ? other$roles == null : this$roles.equals(other$roles)) {
                                                         Object this$department = this.getDepartment();
                                                         Object other$department = other.getDepartment();
                                                         if (this$department == null ? other$department == null : this$department.equals(other$department)) {
                                                            Object this$job = this.getJob();
                                                            Object other$job = other.getJob();
                                                            if (this$job == null ? other$job == null : this$job.equals(other$job)) {
                                                               Object this$authorities = this.getAuthorities();
                                                               Object other$authorities = other.getAuthorities();
                                                               if (this$authorities == null
                                                                  ? other$authorities == null
                                                                  : this$authorities.equals(other$authorities)) {
                                                                  Object this$menus = this.getMenus();
                                                                  Object other$menus = other.getMenus();
                                                                  if (this$menus == null ? other$menus == null : this$menus.equals(other$menus)) {
                                                                     Object this$permissions = this.getPermissions();
                                                                     Object other$permissions = other.getPermissions();
                                                                     return this$permissions == null
                                                                        ? other$permissions == null
                                                                        : this$permissions.equals(other$permissions);
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
      return other instanceof SecurityUser;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isAdmin() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $ddDeptId = this.getDdDeptId();
      result = result * 59 + ($ddDeptId == null ? 43 : $ddDeptId.hashCode());
      Object $oaUserId = this.getOaUserId();
      result = result * 59 + ($oaUserId == null ? 43 : $oaUserId.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $inventoryNotifyPerm = this.getInventoryNotifyPerm();
      result = result * 59 + ($inventoryNotifyPerm == null ? 43 : $inventoryNotifyPerm.hashCode());
      Object $isEnabled = this.getIsEnabled();
      result = result * 59 + ($isEnabled == null ? 43 : $isEnabled.hashCode());
      Object $userType = this.getUserType();
      result = result * 59 + ($userType == null ? 43 : $userType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $ddUserId = this.getDdUserId();
      result = result * 59 + ($ddUserId == null ? 43 : $ddUserId.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $password = this.getPassword();
      result = result * 59 + ($password == null ? 43 : $password.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $lastPasswordResetDate = this.getLastPasswordResetDate();
      result = result * 59 + ($lastPasswordResetDate == null ? 43 : $lastPasswordResetDate.hashCode());
      Object $roles = this.getRoles();
      result = result * 59 + ($roles == null ? 43 : $roles.hashCode());
      Object $department = this.getDepartment();
      result = result * 59 + ($department == null ? 43 : $department.hashCode());
      Object $job = this.getJob();
      result = result * 59 + ($job == null ? 43 : $job.hashCode());
      Object $authorities = this.getAuthorities();
      result = result * 59 + ($authorities == null ? 43 : $authorities.hashCode());
      Object $menus = this.getMenus();
      result = result * 59 + ($menus == null ? 43 : $menus.hashCode());
      Object $permissions = this.getPermissions();
      return result * 59 + ($permissions == null ? 43 : $permissions.hashCode());
   }

   @Override
   public String toString() {
      return "SecurityUser(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", username="
         + this.getUsername()
         + ", ddUserId="
         + this.getDdUserId()
         + ", ddDeptId="
         + this.getDdDeptId()
         + ", oaUserId="
         + this.getOaUserId()
         + ", companyName="
         + this.getCompanyName()
         + ", sex="
         + this.getSex()
         + ", phone="
         + this.getPhone()
         + ", email="
         + this.getEmail()
         + ", password="
         + this.getPassword()
         + ", createTime="
         + this.getCreateTime()
         + ", lastPasswordResetDate="
         + this.getLastPasswordResetDate()
         + ", roles="
         + this.getRoles()
         + ", department="
         + this.getDepartment()
         + ", job="
         + this.getJob()
         + ", inventoryNotifyPerm="
         + this.getInventoryNotifyPerm()
         + ", authorities="
         + this.getAuthorities()
         + ", menus="
         + this.getMenus()
         + ", permissions="
         + this.getPermissions()
         + ", isEnabled="
         + this.getIsEnabled()
         + ", isAdmin="
         + this.isAdmin()
         + ", userType="
         + this.getUserType()
         + ")";
   }
}
