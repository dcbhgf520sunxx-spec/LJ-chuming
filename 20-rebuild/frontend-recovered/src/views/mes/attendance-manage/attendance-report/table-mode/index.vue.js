import { ref as h } from "vue";
import { watch as S } from "vue";
import { resolveComponent as W } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as O } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as l } from "vue";
import { toDisplayString as r } from "vue";
import { Fragment as u } from "vue";
import { renderList as _ } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as P } from "element-plus";
import { x as V, n2 as A, o as E, p as m, i as w, P as F, ba as U } from "../../../../../shared/runtime.js";
import { b as j } from "../../../../../modules/attendance-report-ce8c4447.js";
import q from "./module/header.vue.js";
const K = { class: "head-container", style: { "margin-bottom": "0" } }, I = { __name: "index", props: { isRefresh: { type: Boolean, default: false } }, setup(T) {
  const b = T, v = [], C = { add: true, edit: false, del: false, download: false }, f = h(), x = h([]), { crud: p, CRUD: N } = V({ title: "考勤报表", sort: [], optShow: { ...C }, permission: { ...A }, crudApi: { get: j } }, f), { maxHeight: R } = E({ wrapperBox: [".app-container"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  S(() => b.isRefresh, () => {
    p.toQuery();
  });
  function H(g) {
    return U(g, { props: ["actualHours", "overHours"] });
  }
  return N.HOOK.handleRefresh = (g, y) => {
  }, (g, y) => {
    const a = M, D = W("common-table"), L = P;
    return i(), s("div", null, [d("div", K, [o(t(q), { workShopList: x.value }, null, 8, ["workShopList"])]), B((i(), O(D, { ref_key: "tableRef", ref: f, data: t(p).data, "data-format": v, "empty-text": t(p).emptyText, "max-height": t(R), style: { width: "100%" }, "row-key": "id", "show-summary": "", "summary-method": H }, { default: n(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), o(a, { key: "attendanceDate", prop: "attendanceDate", "show-overflow-tooltip": true, label: "日期", "min-width": "120", align: "center" }, { default: n(({ row: e }) => [l(r(t(m)(e.attendanceDate, "{y}-{m}-{d}")), 1)]), _: 1 }), o(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "姓名", "min-width": "100px", align: "center" }, { default: n(({ row: e }) => [d("span", null, r(e.name), 1)]), _: 1 }), o(a, { key: "deptName", prop: "deptName", label: "部门", align: "center" }), o(a, { key: "wokeName", prop: "wokeName", label: "工种", align: "center" }), o(a, { key: "codeName", prop: "codeName", label: "上午考勤", align: "center" }, { default: n(() => [o(a, { key: "morning", prop: "morningWorkingTime", label: "上午", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [l(r(e.morningWorkingTime ? t(m)(e.morningWorkingTime, "{h}:{i}") : "-"), 1)]), _: 1 }), o(a, { key: "morningClosingTime", prop: "morningClosingTime", label: "中午", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [l(r(e.morningClosingTime ? t(m)(e.morningClosingTime, "{h}:{i}") : "-"), 1)]), _: 1 })]), _: 1 }), o(a, { key: "overtime", prop: "overtime", label: "下午考勤", align: "center" }, { default: n(() => [o(a, { key: "afternoonWorkingTime", prop: "afternoonWorkingTime", label: "下午", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [l(r(e.afternoonWorkingTime ? t(m)(e.afternoonWorkingTime, "{h}:{i}") : "-"), 1)]), _: 1 }), o(a, { key: "afternoonClosingTime", prop: "afternoonClosingTime", label: "下班", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [l(r(e.afternoonClosingTime ? t(m)(e.afternoonClosingTime, "{h}:{i}") : "-"), 1)]), _: 1 })]), _: 1 }), o(a, { key: "actualHours", prop: "actualHours", label: "正常时长", align: "center" }), o(a, { key: "codeName", prop: "codeName", label: "加班考勤", align: "center" }, { default: n(() => [o(a, { key: "overtimeWorkingTime", prop: "overtimeWorkingTime", label: "上班", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(w)(e.overClockDTOList) ? (i(true), s(u, { key: 0 }, _(e.overClockDTOList, (c, k) => (i(), s("div", { key: k }, [d("span", null, r(c.workingTime ? t(m)(c.workingTime, "{h}:{i}") : "-"), 1)]))), 128)) : (i(), s(u, { key: 1 }, [l("-")], 64))]), _: 1 }), o(a, { key: "overtimeClosingTime", prop: "overtimeClosingTime", label: "下班", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [t(w)(e.overClockDTOList) ? (i(true), s(u, { key: 0 }, _(e.overClockDTOList, (c, k) => (i(), s("div", { key: k }, [d("span", null, r(c.closingTime ? t(m)(c.closingTime, "{h}:{i}") : "-"), 1)]))), 128)) : (i(), s(u, { key: 1 }, [l("-")], 64))]), _: 1 })]), _: 1 }), o(a, { key: "overHours", prop: "overHours", label: "加班时长", align: "center" }), o(a, { key: "codeName", prop: "codeName", label: "合计", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [l(r(e.actualHours + e.overHours || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[L, t(p).loading]]), o(t(F))]);
  };
} };
export {
  I as default
};
