package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.enums.ChangeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectRecord;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectRecordDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.ChangeInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectRecordDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectRecordDetailService;
import com.hzchum.scim.contract.core.api.service.ContractProjectRecordService;
import com.hzchum.scim.contract.core.mapper.ContractProjectRecordDetailMapper;
import com.hzchum.scim.contract.core.mapper.ContractProjectRecordMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectRecordServiceImpl extends ServiceImpl<ContractProjectRecordMapper, ContractProjectRecord> implements ContractProjectRecordService {
   @Resource
   private ContractProjectRecordDetailMapper projectRecordDetailMapper;
   @Resource
   private ContractProjectRecordDetailService projectRecordDetailService;

   @Override
   public void insert(Long projectId, Long userId, ChangeEnum changeEnum, List<ChangeInfo> changeInfos) {
      if (CollectionUtils.isNotEmpty(changeInfos)) {
         ContractProjectRecord record = ContractProjectRecord.builder().projectId(projectId).operationUserId(userId).type(changeEnum.getType()).build();
         this.baseMapper.insert(record);
         List<ContractProjectRecordDetail> recordDetails = changeInfos.stream()
            .map(
               info -> ContractProjectRecordDetail.builder()
                  .recordId(record.getId())
                  .field(info.getField())
                  .description(info.getType() == 0 ? info.getBefore() + " -> " + info.getAfter() : info.getDescription())
                  .build()
            )
            .collect(Collectors.toList());
         this.projectRecordDetailService.saveBatch(recordDetails);
      }
   }

   @Override
   public void insert(Long projectId, Long userId, ChangeEnum changeEnum) {
      ContractProjectRecord record = ContractProjectRecord.builder().projectId(projectId).operationUserId(userId).type(changeEnum.getType()).build();
      this.baseMapper.insert(record);
   }

   @Override
   public PageVO<ProjectRecordDTO> listProjectRecord(
      Long projectId, Integer type, LocalDate startDate, LocalDate endDate, String operator, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectRecordDTO> recordDTOS = this.baseMapper.listByConditions(projectId, type, startDate, endDate, operator);
      return new PageVO<>(recordDTOS);
   }
}
