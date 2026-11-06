package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.SupplierUserInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserInfoResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserUpdateDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UserBiz extends IBiz<User> {
   UserInfoResponseVO getInfo(SecurityUser securityUser, Integer category);

   SupplierUserInfoDTO getTempUserInfo(SecurityUser securityUser);

   SupplierUserInfoDTO getTempUserInfoV2(SecurityUser securityUser);

   PageVO<UserResponseVO> pageUser(Long deptId, String blurry, Boolean isEnabled, Integer userType, Integer pageNumber, Integer pageSize);

   boolean register(UserSaveRequestVO requestVO);

   boolean changeUserDisable(Long userId, Boolean enabled, Boolean needCheck);

   boolean updateUser(UserUpdateDTOParam updateDTOParam);

   boolean deleteUser(List<Long> ids);

   List<DeptUserTreeResponseVO> userTree(Boolean hasRoot);

   DeptUserResponseVO getUserDept(Long deptId, Long jobId);

   Boolean exportUserTemplate(HttpServletResponse response);

   Boolean importUser(Long branchCompanyId, MultipartFile file, HttpServletResponse response);

   UserResponseVO getUserByPhone(String phone);

   Object weChatLogin(String code);

   Object weChatBindAndLogin(String key, String phone, String verifyCode);

   void logoutAndRelieveBind();

   void getQrCode();

   boolean sendCode(String phone);
}
