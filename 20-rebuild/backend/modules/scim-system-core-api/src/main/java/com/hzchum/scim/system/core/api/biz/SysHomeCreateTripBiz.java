package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeCreateTrip;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCreateTripPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeCreateTripSaveParam;
import java.time.LocalDate;
import java.util.List;

public interface SysHomeCreateTripBiz extends IBiz<SysHomeCreateTrip> {
   Boolean saveSysHomeCreateTrip(SysHomeCreateTripSaveParam param);

   Boolean deleteSysHomeCreateTrip(Long id);

   List<SysHomeCreateTripPageDTO> getSysHomeCreateTripPage(String createUserName, String title, LocalDate startTime);
}
