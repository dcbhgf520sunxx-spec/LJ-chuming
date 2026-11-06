import { openBlock as i } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as r } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as t } from "vue";
import { toDisplayString as s } from "vue";
import { unref as a } from "vue";
import { Fragment as g } from "vue";
import { renderList as u } from "vue";
import { createElementVNode as k } from "vue";
import { ElTableColumn as T } from "element-plus";
import { p as m, i as d } from "../../../../../shared/runtime.js";
const C = { __name: "day", setup(f) {
  return (_, y) => {
    const o = T;
    return i(), l(g, null, [r(o, { prop: "attendanceDate", "show-overflow-tooltip": true, label: "时间", align: "center", width: "110" }), r(o, { prop: "name", "show-overflow-tooltip": true, label: "姓名", align: "center" }), r(o, { key: "deptName", prop: "deptName", label: "部门", align: "center" }), r(o, { key: "codeName", prop: "codeName", label: "上午考勤", align: "center" }, { default: n(() => [r(o, { key: "morning", prop: "morningWorkingTime", label: "上午", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(s(e.morningWorkingTime ? a(m)(e.morningWorkingTime, "{h}:{i}") : "-"), 1)]), _: 1 }), r(o, { key: "morningClosingTime", prop: "morningClosingTime", label: "中午", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(s(e.morningClosingTime ? a(m)(e.morningClosingTime, "{h}:{i}") : "-"), 1)]), _: 1 })]), _: 1 }), r(o, { key: "overtime", prop: "overtime", label: "下午考勤", align: "center" }, { default: n(() => [r(o, { key: "afternoonWorkingTime", prop: "afternoonWorkingTime", label: "下午", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(s(e.afternoonWorkingTime ? a(m)(e.afternoonWorkingTime, "{h}:{i}") : "-"), 1)]), _: 1 }), r(o, { key: "afternoonClosingTime", prop: "afternoonClosingTime", label: "下班", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(s(e.afternoonClosingTime ? a(m)(e.afternoonClosingTime, "{h}:{i}") : "-"), 1)]), _: 1 })]), _: 1 }), r(o, { key: "codeName", prop: "codeName", label: "加班考勤", align: "center" }, { default: n(() => [r(o, { key: "overtimeWorkingTime", prop: "overtimeWorkingTime", label: "上班", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [a(d)(e.overClockDTOList) ? (i(true), l(g, { key: 0 }, u(e.overClockDTOList, (c, p) => (i(), l("div", { key: p }, [k("span", null, s(c.workingTime ? a(m)(c.workingTime, "{h}:{i}") : "-"), 1)]))), 128)) : (i(), l(g, { key: 1 }, [t("-")], 64))]), _: 1 }), r(o, { key: "overtimeClosingTime", prop: "overtimeClosingTime", label: "下班", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [a(d)(e.overClockDTOList) ? (i(true), l(g, { key: 0 }, u(e.overClockDTOList, (c, p) => (i(), l("div", { key: p }, [k("span", null, s(c.closingTime ? a(m)(c.closingTime, "{h}:{i}") : "-"), 1)]))), 128)) : (i(), l(g, { key: 1 }, [t("-")], 64))]), _: 1 })]), _: 1 }), r(o, { key: "actualHours", prop: "actualHours", label: "正常时长", align: "center" }), r(o, { key: "overHours", prop: "overHours", label: "加班时长", align: "center" }), r(o, { key: "codeName", prop: "codeName", label: "合计", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(s(e.actualHours + e.overHours || "-"), 1)]), _: 1 })], 64);
  };
} };
export {
  C as default
};
