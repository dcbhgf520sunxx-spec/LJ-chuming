import { ref as g } from "vue";
import { watch as B } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as m } from "vue";
import { unref as d } from "vue";
import { createCommentVNode as D } from "vue";
import { createElementVNode as c } from "vue";
import { isRef as j } from "vue";
import { ElTag as A } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { dS as O, u as S, G as _, i as I, o as E, p as F, L as G, c as M } from "../../../shared/runtime.js";
import { b as L, c as U } from "../../../modules/production-performance-dashboard-bb1cff92.js";
const $ = { __name: "average-task-rate-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object }, workshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(p, { emit: V }) {
  const { workshops: R } = O(), h = g([]), b = g(""), C = V, r = p, { visible: y, handleClose: N } = S({ emit: C, props: r, field: "visible", showHook: T });
  B(() => r.visible, (a) => {
    var l, n;
    a && (b.value = (n = (l = R.value) == null ? void 0 : l.find((s) => s.id === r.workshopId)) == null ? void 0 : n.name);
  }, { immediate: true });
  async function T() {
    var l;
    if (!_((l = r.permission) == null ? void 0 : l.detail)) return false;
    let a = [];
    try {
      if (a = await L({ ...r.query, workshopId: r.workshopId }) || [], (a == null ? void 0 : a.length) > 0) {
        const s = a == null ? void 0 : a.reduce((e, t) => I(t == null ? void 0 : t.mete) ? e + (t == null ? void 0 : t.mete) : e, 0), f = a == null ? void 0 : a.reduce((e, t) => I(t == null ? void 0 : t.taskMete) ? e + (t == null ? void 0 : t.taskMete) : e, 0), k = (s / f * 100).toFixed(2);
        a.push({ type: 2, id: "total_" + Math.random(), index: "平均达成率", dateTime: "", taskMete: f, mete: s, ratio: k });
      }
    } catch (n) {
      console.log("获取年度任务达成率详情失败", n);
    } finally {
      h.value = a;
    }
  }
  const { maxHeight: q } = E({ paginate: true });
  function z({ row: a, rowIndex: l }) {
    if (a.index === "平均达成率") return { position: "sticky", bottom: "0 !important", zIndex: 1 };
  }
  return (a, l) => {
    const n = A, s = H, f = w("common-table"), k = w("common-drawer");
    return v(), x(k, { ref: "drawerRef", title: "年度任务达成率详情", modelValue: d(y), "onUpdate:modelValue": l[0] || (l[0] = (e) => j(y) ? y.value = e : null), direction: "rtl", "before-close": d(N), size: "50%" }, { titleAfter: o(() => [i(n, { type: "danger", size: "default" }, { default: o(() => {
      var e, t;
      return [u(" 二级单位： " + m((e = p.branchInfo) != null && e.name ? (t = p.branchInfo) == null ? void 0 : t.name : "全部分支机构"), 1)];
    }), _: 1 }), i(n, { size: "default" }, { default: o(() => [u(" 车间： " + m(b.value ? b.value : "全部车间"), 1)]), _: 1 }), i(n, { type: "success", size: "default" }, { default: o(() => [u(" 年度： " + m(p.query.yearDate ? d(F)(p.query.yearDate, "{y}") : "-"), 1)]), _: 1 })]), titleRight: o(() => {
      var e, t;
      return [d(_)((e = p.permission) == null ? void 0 : e.download) ? (v(), x(G, { key: 0, fn: d(U), params: { ...r.query, workshopId: r.workshopId }, disabled: !((t = h.value) != null && t.length) }, { default: o(() => l[1] || (l[1] = [u(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : D("", true)];
    }), content: o(() => [i(f, { ref: "tableRef", data: h.value, "show-empty-symbol": false, "row-style": z, "max-height": d(q), style: { width: "100%" } }, { default: o(() => [i(s, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "130", type: "index" }, { default: o(({ row: e, $index: t }) => [c("span", null, m(e != null && e.type && e.type === 2 ? "平均达成率" : t + 1), 1)]), _: 1 }), i(s, { "show-overflow-tooltip": true, prop: "dateTime", label: "月份", align: "center" }), i(s, { "show-overflow-tooltip": true, prop: "taskMete", label: "排产量（吨）", align: "center" }, { default: o(({ row: e }) => [c("span", null, m(e.taskMete ? d(M)(e.taskMete, "kg", "t", 0) : 0), 1)]), _: 1 }), i(s, { "show-overflow-tooltip": true, prop: "mete", label: "完成量（吨）", align: "center" }, { default: o(({ row: e }) => [c("span", null, m(e.mete ? d(M)(e.mete, "kg", "t", 0) : 0), 1)]), _: 1 }), i(s, { "show-overflow-tooltip": true, prop: "ratio", label: "达成率", align: "center" }, { default: o(({ row: e }) => [c("span", null, m(e.ratio ? e.ratio : 0) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  $ as default
};
