package com.hzchum.scim.mes.building.core.api.biz.laborManagement;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterSaveParam;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesRosterBiz extends IBiz<MesRoster> {
   PageVO<MesRosterDTO> rosterPage(MesRosterQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   void rosterDownload(MesRosterQuery query, HttpServletResponse response);

   MesRosterDTO getRosterInfo(Long id);

   Boolean saveRoster(MesRosterSaveParam param);

   Boolean updateRoster(MesRosterSaveParam param);

   Boolean updateStatus(Long id, Integer status);

   Boolean deleteRoster(Long id);

   Map<String, Integer> ageStatistics();

   List<String> nationList();

   PrintVO<List<Map<String, Object>>> qrCodePrint(Long id);

   MesRosterDTO getWxAppRosterInfo();
}
