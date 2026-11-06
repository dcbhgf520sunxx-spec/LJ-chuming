import { ref as g } from "vue";
import { watch as z } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as d } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as H } from "vue";
import { createElementVNode as c } from "vue";
import { isRef as q } from "vue";
import { ElTag as A } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { dS as O, u as E, G as I, i as M, o as F, p as G, L, c as D } from "../../../shared/runtime.js";
import { p as U, q as P } from "../../../modules/production-performance-dashboard-bb1cff92.js";
const J = { __name: "workshop-task-rate-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object }, workshopId: { type: Number }, searchDate: { type: [Number, String] }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(p, { emit: N }) {
  const { workshops: V } = O(), b = g([]), k = g(""), j = N, n = p, { visible: u, handleClose: B } = E({ emit: j, props: n, field: "visible", showHook: R });
  z(() => n.visible, (a) => {
    var s, i;
    a && (k.value = (i = (s = V.value) == null ? void 0 : s.find((l) => l.id === n.workshopId)) == null ? void 0 : i.name);
  }, { immediate: true });
  async function R() {
    var s;
    if (!I((s = n.permission) == null ? void 0 : s.detail)) return false;
    let a = [];
    try {
      if (a = await U({ ...n.query, workshopId: n.workshopId, yearDate: n.searchDate }) || [], (a == null ? void 0 : a.length) > 0) {
        const l = a == null ? void 0 : a.reduce((e, t) => M(t == null ? void 0 : t.mete) ? e + (t == null ? void 0 : t.mete) : e, 0), f = a == null ? void 0 : a.reduce((e, t) => M(t == null ? void 0 : t.taskMete) ? e + (t == null ? void 0 : t.taskMete) : e, 0), y = l && f ? (l / f * 100).toFixed(2) : 0;
        a.push({ type: 2, id: "total_" + Math.random(), index: "平均达成率", dateTime: "", taskMete: f, mete: l, ratio: y });
      }
    } catch (i) {
      console.log("获取车间任务达成率详情失败", i);
    } finally {
      b.value = a;
    }
  }
  const { maxHeight: C } = F({ mainBox: ".workshop-task-detail-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: false, navbar: false }, u);
  function T({ row: a, rowIndex: s }) {
    if (a.index === "合计") return { position: "sticky", bottom: "0 !important", zIndex: 1 };
  }
  return (a, s) => {
    const i = A, l = S, f = v("common-table"), y = v("common-drawer");
    return _(), x(y, { "custom-class": "workshop-task-detail-class", ref: "drawerRef", title: "车间任务达成率详情", modelValue: m(u), "onUpdate:modelValue": s[0] || (s[0] = (e) => q(u) ? u.value = e : null), direction: "rtl", "before-close": m(B), size: "50%" }, { titleAfter: o(() => [r(i, { type: "danger", size: "default" }, { default: o(() => {
      var e, t;
      return [h(" 二级单位： " + d((e = p.branchInfo) != null && e.name ? (t = p.branchInfo) == null ? void 0 : t.name : "全部分支机构"), 1)];
    }), _: 1 }), r(i, { size: "default" }, { default: o(() => [h(" 车间： " + d(k.value ? k.value : "全部车间"), 1)]), _: 1 }), r(i, { type: "success", size: "default" }, { default: o(() => [h(" 月份： " + d(p.searchDate ? m(G)(p.searchDate, "{y}-{m}") : "-"), 1)]), _: 1 })]), titleRight: o(() => {
      var e, t;
      return [m(I)((e = p.permission) == null ? void 0 : e.download) ? (_(), x(L, { key: 0, fn: m(P), params: { ...n.query, workshopId: n.workshopId, yearDate: n.searchDate }, disabled: !((t = b.value) != null && t.length) }, { default: o(() => s[1] || (s[1] = [h(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : H("", true)];
    }), content: o(() => [r(f, { ref: "tableRef", data: b.value, "show-empty-symbol": false, "row-style": T, "max-height": m(C), style: { width: "100%" } }, { default: o(() => [r(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "130", type: "index" }, { default: o(({ row: e, $index: t }) => [c("span", null, d(e != null && e.type && e.type === 2 ? "平均达成率" : t + 1), 1)]), _: 1 }), r(l, { "show-overflow-tooltip": true, prop: "projectInfo", label: "项目", "header-align": "center", align: "left", "min-width": "120" }, { default: o(({ row: e }) => {
      var t, w;
      return [c("span", null, d(e.projectInfo ? ((t = e.projectInfo) == null ? void 0 : t.serialNumber) + "-" + ((w = e.projectInfo) == null ? void 0 : w.name) : ""), 1)];
    }), _: 1 }), r(l, { "show-overflow-tooltip": true, prop: "taskMete", label: "排产量（吨）", align: "center" }, { default: o(({ row: e }) => [c("span", null, d(e.taskMete ? m(D)(e.taskMete, "kg", "t", 0) : 0), 1)]), _: 1 }), r(l, { "show-overflow-tooltip": true, prop: "mete", label: "完成量（吨）", align: "center" }, { default: o(({ row: e }) => [c("span", null, d(e.mete ? m(D)(e.mete, "kg", "t", 0) : 0), 1)]), _: 1 }), r(l, { "show-overflow-tooltip": true, prop: "ratio", label: "达成率", align: "center" }, { default: o(({ row: e }) => [c("span", null, d(e.ratio ? e.ratio : 0) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
