import { ref as r } from "vue";
import y from "moment";
import { resolveComponent as _ } from "vue";
import { openBlock as x } from "vue";
import { createBlock as T } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { createTextVNode as m } from "vue";
import { withDirectives as J } from "vue";
import { toDisplayString as g } from "vue";
import { isRef as Y } from "vue";
import { ElMessage as z } from "element-plus";
import { ElButton as A } from "element-plus";
import { ElDatePicker as G } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { j as Z, k as ee } from "../../../../../modules/attendance-report-ce8c4447.js";
import { u as te, o as ae, J as ne, p as V } from "../../../../../shared/runtime.js";
import oe from "./overtime-form.vue.js";
const ue = { __name: "overtime-config", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) } }, emits: ["update:visible", "close", "success", "handleDel", "handleBatchDel"], setup(D, { emit: w }) {
  const b = w, N = D, { visible: d, handleClose: C } = te({ emit: b, props: N, field: "visible", showHook: u, closeHook: () => {
    b("close");
  } }), { maxHeight: E } = ae({ wrapperBox: [".el-dialog__body"], minHeight: 300, navbar: false }, d), { handleSizeChange: S, handleCurrentChange: B, total: H, setTotalPage: L, queryPage: p } = ne({ fetchHook: u }), O = r(false), c = r(false), P = r(false), v = r(void 0), l = r([y().subtract(30, "days").valueOf(), y().valueOf()]), k = r([]);
  function u() {
    console.log(": date.value", l.value), Z({ endDate: l.value && l.value.length ? l.value[1] : void 0, startDate: l.value && l.value.length ? l.value[0] : void 0, ...p }).then((s) => {
      k.value = s.content.map((t) => (t.overtimeRoster = t.rosterList.map((f) => f.name).join(" / "), t)), L(s.totalElements);
    });
  }
  async function R(s) {
    try {
      await ee({ id: s.id }), z.success("删除成功"), u();
    } catch (t) {
      z.error(t.message);
    }
  }
  function j(s) {
    v.value = s.id, c.value = true;
  }
  function I() {
    v.value = void 0, c.value = true;
  }
  return (s, t) => {
    const f = A, W = G, h = _("common-button"), i = K, M = _("common-table"), U = Q, $ = _("common-drawer"), q = X;
    return x(), T($, { title: "加班考勤数据", modelValue: n(d), "onUpdate:modelValue": t[2] || (t[2] = (e) => Y(d) ? d.value = e : null), "show-close": false, "before-close": n(C), size: "70%", closeOnClickModal: false }, { titleRight: o(() => [a(f, { size: "mini", type: "info", onClick: n(C), loading: P.value }, { default: o(() => t[3] || (t[3] = [m("取消")])), _: 1, __: [3] }, 8, ["onClick", "loading"])]), content: o(() => [a(W, { modelValue: l.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => l.value = e), type: "daterange", "range-separator": ":", size: "small", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "270px" }, class: "filter-item", onChange: u }, null, 8, ["modelValue"]), a(h, { type: "warning", icon: "el-icon-document", size: "mini", style: { float: "right", "margin-bottom": "10px" }, onClick: I }, { default: o(() => t[4] || (t[4] = [m(" 加班考勤 ")])), _: 1, __: [4] }), J((x(), T(M, { "return-source-data": "", data: k.value, "max-height": n(E), style: { width: "100%" } }, { default: o(() => [a(i, { label: "序号", type: "index", align: "center", width: "60" }), a(i, { key: "deptName", prop: "deptName", label: "部门", align: "center" }), a(i, { key: "userName", prop: "userName", label: "创建人", align: "center" }, { default: o(({ row: e }) => [m(g((e == null ? void 0 : e.userName) || "-"), 1)]), _: 1 }), a(i, { key: "overtimeWorkingTime", prop: "overtimeWorkingTime", label: "上班时间", align: "center" }, { default: o(({ row: e }) => [m(g(n(V)(e.overtimeWorkingTime, "{y}-{m}-{d} {h}:{i}") || "-"), 1)]), _: 1 }), a(i, { key: "overtimeClosingTime", prop: "overtimeClosingTime", label: "下班时间", align: "center" }, { default: o(({ row: e }) => [m(g(n(V)(e.overtimeClosingTime, "{y}-{m}-{d} {h}:{i}") || "-"), 1)]), _: 1 }), a(i, { key: "length", prop: "length", label: "时长（分钟）", align: "center" }, { default: o(({ row: e }) => [m(g((e.overtimeClosingTime - e.overtimeWorkingTime) / 1e3 / 60 || "-"), 1)]), _: 1 }), a(i, { key: "overtimeRoster", prop: "overtimeRoster", label: "加班名单", align: "center", width: "200" }), a(i, { label: "操作", width: "160", align: "center" }, { default: o(({ row: e }) => [a(h, { type: "primary", icon: "el-icon-edit", size: "mini", onClick: (F) => j(e) }, null, 8, ["onClick"]), a(h, { type: "danger", icon: "el-icon-delete", size: "mini", onClick: (F) => R(e) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[q, O.value]]), a(U, { total: n(H), "current-page": n(p).pageNumber, "page-size": n(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(S), onCurrentChange: n(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(n(oe), { visible: c.value, "onUpdate:visible": t[1] || (t[1] = (e) => c.value = e), overConfigId: v.value, onSuccess: u }, null, 8, ["visible", "overConfigId"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ue as default
};
