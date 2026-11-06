package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterDTO;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterSimpleDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectManageRosterQuery;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageRosterSaveParam;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProjectManageRosterBiz extends IBiz<ProjectManageRoster> {
   PageVO<ProjectManageRosterDTO> rosterPage(ProjectManageRosterQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   ProjectManageRosterDTO getRosterInfo(Long id);

   ProjectManageRosterDTO getBaseUserInfo();

   Boolean saveRoster(ProjectManageRosterSaveParam param);

   Boolean updateRoster(ProjectManageRosterSaveParam param);

   Boolean updateStatus(Long id, Integer status);

   Boolean deleteRoster(Long id);

   Map<String, Integer> ageStatistics(Long projectId);

   List<String> nationList();

   PrintVO<List<Map<String, Object>>> qrCodePrint(Long id);

   void exportRosterTemplate(HttpServletResponse response);

   boolean importRoster(MultipartFile file, Long projectId, HttpServletResponse response);

   void downloadRosterQR(ProjectManageRosterQuery query);

   List<ProjectManageRosterSimpleDTO> simpleInfoList(ProjectManageRosterQuery query);

   Integer getRemainingBehaviorScore(Long projectId, Long userId);

   void rosterDownload(ProjectManageRosterQuery query, HttpServletResponse response);
}
