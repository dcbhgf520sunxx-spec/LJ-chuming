import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzchum.pangu.common.nesting.ProfileNesting;
import com.hzchum.pangu.common.nesting.pojo.Assemble;
import com.hzchum.pangu.common.nesting.pojo.ProfileNestingInfo;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import java.time.LocalDateTime;
import java.util.*;

/** Same inputs run in separate JVMs against the reference and rebuilt classes. */
public class FoundationParity {
    public static class Record extends BaseEntity<Long> {
        private Long id;
        public Long getId() { return id; }
        public void setId(Long value) { id = value; }
    }

    private static ProfileNestingInfo info(int length, int quantity) {
        Assemble part = new Assemble(1L, 11L, 21L, 31L, 41L, "A1", "Q355",
            "H", "200*100", length, quantity, null, "G1");
        return new ProfileNestingInfo(21L, Arrays.asList(part), "Q355", "H",
            "200*100", 12000, 4, 0, null, 1);
    }

    private static void emit(String name, Object value) {
        System.out.println(name + "=" + JSON.toJSONString(value));
    }

    private static void check(boolean condition, String reason) {
        if (!condition) throw new AssertionError(reason);
    }

    public static void main(String[] args) throws Exception {
        emit("success", ResultBuilder.success(Arrays.asList("A", "B")));
        emit("failure", ResultBuilder.failed("validation fixture"));
        int[] rounded = new int[7];
        int[] input = {0, 1, 9, 10, 11, 11999, 12000};
        for (int i = 0; i < input.length; i++) rounded[i] = ProfileNesting.buildingLength(input[i]);
        check(Arrays.equals(rounded, new int[]{0, 10, 10, 10, 20, 12000, 12000}), "length rounding");
        emit("rounding", rounded);
        emit("specification", ProfileNesting.checkSpecifications(info(1000, 2), info(1000, 2).assembleList));
        try {
            ProfileNestingInfo invalid = info(12000, 1);
            ProfileNesting.checkSpecifications(invalid, invalid.assembleList);
            throw new AssertionError("oversize part accepted");
        } catch (AssertionError error) { throw error; }
        catch (Exception error) { emit("oversize", error.getMessage()); }
        emit("nesting-single", ProfileNesting.nestingALG(info(1000, 1)));
        emit("nesting-repeat", ProfileNesting.nestingALG(info(1000, 4)));
        Record row = new Record();
        row.setId(123L);
        row.setCreateTime(LocalDateTime.of(2026, 1, 2, 3, 4, 5));
        row.setUpdateTime(LocalDateTime.of(2026, 1, 3, 0, 0));
        row.setVersion(2);
        row.setBoolDeleteEnum(false);
        String serialized = new ObjectMapper().writeValueAsString(row);
        check(serialized.contains("123"), "entity identifier missing");
        emit("entity", JSON.parse(serialized));
        Calendar first = Calendar.getInstance();
        first.setTime(DateTimeUtils.monthFirstDay());
        Calendar last = Calendar.getInstance();
        last.setTime(DateTimeUtils.monthLastDay());
        boolean boundaries = first.get(Calendar.DAY_OF_MONTH) == 1
            && last.get(Calendar.DAY_OF_MONTH) == last.getActualMaximum(Calendar.DAY_OF_MONTH);
        check(boundaries, "calendar month boundaries");
        emit("month-boundaries", boundaries);
    }
}
