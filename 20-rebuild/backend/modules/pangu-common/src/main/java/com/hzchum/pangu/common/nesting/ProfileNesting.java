package com.hzchum.pangu.common.nesting;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.pangu.common.nesting.pojo.Assemble;
import com.hzchum.pangu.common.nesting.pojo.NestingAssemble;
import com.hzchum.pangu.common.nesting.pojo.ProfileNestingInfo;
import com.hzchum.pangu.common.nesting.pojo.ProfileNestingLengthResult;
import com.hzchum.pangu.common.nesting.pojo.ProfileNestingResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;

public class ProfileNesting {
   public static List<ProfileNestingResult> nesting(ProfileNestingInfo info) throws Exception {
      if (CollectionUtils.isEmpty(info.assembleList)) {
         throw new Exception("所选部件不可为空");
      }

      if (info.baseMetalLength == null || info.baseMetalLength == 0) {
         throw new Exception("母材长度必须大于0");
      }

      if (info.kerfLength != null && info.kerfLength != 0) {
         boolean boolSame = checkSpecifications(info, info.assembleList);
         if (!boolSame) {
            throw new Exception("请选择相同截面类型及规格的部件进行套料");
         }

         List<ProfileNestingResult> list = nestingALG(info);
         GeneratePNC.generateByList(list, info.outputDirectoryPath);
         return list;
      } else {
         throw new Exception("割缝长度必须大于0");
      }
   }

   public static void losslessNesting(ProfileNestingInfo info) throws Exception {
   }

   public static void lossNesting(ProfileNestingInfo info) throws Exception {
   }

   public static List<ProfileNestingResult> nestingALG(ProfileNestingInfo info) throws Exception {
      ArrayList<Integer> lengthList = new ArrayList<>();
      Map<Integer, List<Assemble>> assembleLengthMap = new HashMap<>();
      List<Assemble> assembleList = info.assembleList;

      for (int i = 0; i < assembleList.size(); i++) {
         Assemble assemble = assembleList.get(i);
         int fullLength = assemble.length + info.kerfLength;
         if (i == 0 || i == assembleList.size() - 1) {
            fullLength = assemble.length + info.kerfLength * 2 * 3 / 4;
         }

         assemble.setFullLength(fullLength);
         List<Assemble> al = assembleLengthMap.get(fullLength);
         if (CollectionUtils.isEmpty(al)) {
            al = new ArrayList<>();
         }

         al.add(assemble.clone());
         assembleLengthMap.put(fullLength, al);

         for (int z = 0; z < assemble.quantity; z++) {
            lengthList.add(fullLength);
         }
      }

      int[] l = lengthList.stream().mapToInt(Integer::valueOf).toArray();
      DynamicProgramming dp = new DynamicProgramming(info.baseMetalLength);
      List<ProfileNestingLengthResult> nestingResList = dp.nestingLoop(l);
      List<ProfileNestingResult> profileNestingResultList = new ArrayList<>();
      Integer count = info.count;

      for (ProfileNestingLengthResult n : nestingResList) {
         int[] res = n.resultOrderGroup;
         List<NestingAssemble> nestingAssembleList = new ArrayList<>();
         Map<Long, Integer> areaTimes = new HashMap<>();
         Map<Long, Integer> monomerTimes = new HashMap<>();

         for (int len : res) {
            List<Assemble> list = assembleLengthMap.get(len);
            if (CollectionUtils.isEmpty(list)) {
               throw new Exception("解析错误，部件列表为空");
            }

            Assemble assemble = null;
            if (list.size() == 1) {
               assemble = list.get(0);
            } else if (areaTimes.size() == 0) {
               assemble = list.get(0);
            } else {
               List<Entry<Long, Integer>> aList = new ArrayList<>(areaTimes.entrySet());
               aList.sort(Comparator.comparingInt(Entry::getValue));

               for (Entry<Long, Integer> ai : aList) {
                  Optional<Assemble> assembleOptional = list.stream().filter(item -> ai.getKey().equals(item.areaId)).findAny();
                  if (assembleOptional.isPresent()) {
                     assemble = assembleOptional.get();
                     break;
                  }
               }

               if (assemble == null) {
                  List<Entry<Long, Integer>> mList = new ArrayList<>(monomerTimes.entrySet());
                  mList.sort(Comparator.comparingInt(Entry::getValue));

                  for (Entry<Long, Integer> mi : mList) {
                     Optional<Assemble> assembleOptional = list.stream().filter(item -> mi.getKey().equals(item.monomerId)).findAny();
                     if (assembleOptional.isPresent()) {
                        assemble = assembleOptional.get();
                        break;
                     }
                  }
               }

               if (assemble == null) {
                  assemble = list.get(0);
               }
            }

            if (assemble == null) {
               throw new Exception("解析错误, 找不到部件");
            }

            NestingAssemble nestingAssemble = new NestingAssemble(assemble);
            nestingAssembleList.add(nestingAssemble);
            if (assemble.quantity - 1 <= 0) {
               for (Assemble item : list) {
                  if (item.id.equals(assemble.id)) {
                     list.remove(item);
                     break;
                  }
               }
            } else {
               assemble.setQuantity(assemble.quantity - 1);
            }

            Integer at = areaTimes.get(assemble.areaId);
            areaTimes.put(assemble.areaId, at == null ? 1 : (at = at + 1));
            Integer mt = monomerTimes.get(assemble.monomerId);
            monomerTimes.put(assemble.monomerId, at == null ? 1 : Integer.valueOf(mt + 1));
         }

         Integer Length = buildingLength(n.nestingLength);
         StringBuilder var10000 = new StringBuilder().append(Length).append("-").append(info.getSpecifications().replaceAll("\\*", "-")).append("-");
         Integer var33 = count;
         count = count + 1;
         String serialNumber = var10000.append(var33).toString();
         ProfileNestingResult profileNestingResult = new ProfileNestingResult(
            serialNumber, n.nestingLength, Length, n.resultOrderGroup, nestingAssembleList, info
         );
         profileNestingResultList.add(profileNestingResult);
      }

      return profileNestingResultList;
   }

   public static boolean checkSpecifications(ProfileNestingInfo info, List<Assemble> assembleList) throws Exception {
      if (!StringUtils.isBlank(info.material) && !StringUtils.isBlank(info.crossSectionType) && !StringUtils.isBlank(info.specifications)) {
         boolean boolSame = true;

         for (Assemble item : assembleList) {
            if (!info.material.equals(item.material)
               || !info.crossSectionType.equals(item.crossSectionType)
               || !info.specifications.equals(item.specifications)) {
               boolSame = false;
            }

            if (item.length == null || item.length == 0) {
               throw new Exception("部件长度不可为0");
            }

            if (item.length.intValue() + info.kerfLength.intValue() * 1.5 > info.baseMetalLength.intValue()) {
               throw new Exception("【部件长度】+【首位割缝长度】 不可大于 母材长度");
            }

            if (item.quantity <= 0) {
               throw new Exception("部件数量不可为0");
            }
         }

         return boolSame;
      } else {
         throw new Exception("材质、截面类型或规格不可为空");
      }
   }

   public static Integer buildingLength(Integer Length) {
      return Length + (Length % 10 == 0 ? 0 : 10 - Length % 10);
   }
}
