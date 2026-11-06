import { ref as v } from "vue";
import { watch as j } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as x } from "vue";
import { createBlock as D } from "vue";
import { withCtx as a } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as m } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as q } from "vue";
import { createElementVNode as w } from "vue";
import { isRef as B } from "vue";
import { ElTag as O } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { dS as M, u as S, G as _, i as E, o as F, p as G, L, c as U } from "../../../shared/runtime.js";
import { l as Y, m as A } from "../../../modules/production-performance-dashboard-bb1cff92.js";
const J = { __name: "target-yield-rate-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, default: () => {
} }, workshopId: { type: Number }, detailData: { type: Object, default: () => {
} }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(i, { emit: I }) {
  const { workshops: V } = M(), h = v([]), b = v(""), T = I, d = i, { visible: g, handleClose: N } = S({ emit: T, props: d, field: "visible", showHook: z });
  j(() => d.visible, (t) => {
    var o, l;
    t && (b.value = (l = (o = V.value) == null ? void 0 : o.find((s) => s.id === d.workshopId)) == null ? void 0 : l.name);
  }, { immediate: true });
  async function z() {
    var o, l, s;
    if (!_((o = d.permission) == null ? void 0 : o.detail)) return false;
    let t = [];
    try {
      if (t = await Y({ ...d.query, workshopId: d.workshopId }) || [], (t == null ? void 0 : t.length) > 0) {
        const c = t == null ? void 0 : t.reduce((n, f) => E(f == null ? void 0 : f.mete) ? n + (f == null ? void 0 : f.mete) : n, 0), e = (l = d.detailData) != null && l.target && c ? (c / ((s = d.detailData) == null ? void 0 : s.target) * 100).toFixed(2) : 0;
        t.push({ type: 2, id: "total_" + Math.random(), index: "年度达成率", dateTime: "", mete: c, ratio: e });
      }
    } catch (y) {
      console.log("获取目标产量达成率详情失败", y);
    } finally {
      h.value = t;
    }
  }
  const { maxHeight: C } = F({ paginate: true });
  function R({ row: t, rowIndex: o }) {
    if (t.index === "年度达成率") return { position: "sticky", bottom: "0 !important", zIndex: 1 };
  }
  return (t, o) => {
    const l = O, s = H, y = k("common-table"), c = k("common-drawer");
    return x(), D(c, { ref: "drawerRef", title: "目标产量达成率详情", modelValue: u(g), "onUpdate:modelValue": o[0] || (o[0] = (e) => B(g) ? g.value = e : null), direction: "rtl", "before-close": u(N), size: "50%" }, { titleAfter: a(() => [r(l, { type: "danger", size: "default" }, { default: a(() => {
      var e;
      return [p(" 二级单位： " + m((e = i.branchInfo) != null && e.name ? i.branchInfo.name : "全部分支机构"), 1)];
    }), _: 1 }), r(l, { size: "default" }, { default: a(() => [p(" 车间： " + m(b.value ? b.value : "全部车间"), 1)]), _: 1 }), r(l, { type: "success", size: "default" }, { default: a(() => [p(" 年度： " + m(i.query.yearDate ? u(G)(i.query.yearDate, "{y}") : "-"), 1)]), _: 1 }), r(l, { type: "warning", size: "default" }, { default: a(() => {
      var e, n;
      return [p(" 目标： " + m((e = i.detailData) != null && e.target ? (n = i.detailData) == null ? void 0 : n.target : 0) + "吨 ", 1)];
    }), _: 1 })]), titleRight: a(() => {
      var e, n;
      return [u(_)((e = i.permission) == null ? void 0 : e.download) ? (x(), D(L, { key: 0, fn: u(A), params: { ...i.query }, disabled: !((n = h.value) != null && n.length) }, { default: a(() => o[1] || (o[1] = [p(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : q("", true)];
    }), content: a(() => [r(y, { ref: "tableRef", data: h.value, "show-empty-symbol": false, "max-height": u(C), "row-style": R, style: { width: "100%" } }, { default: a(() => [r(s, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "100", type: "index" }, { default: a(({ row: e, $index: n }) => [w("span", null, m(e != null && e.type && e.type === 2 ? "年度达成率" : n + 1), 1)]), _: 1 }), r(s, { "show-overflow-tooltip": true, prop: "dateTime", label: "月份", align: "center" }), r(s, { "show-overflow-tooltip": true, prop: "mete", label: "完成量（吨）", align: "center" }, { default: a(({ row: e }) => [w("span", null, m(u(U)(e.mete, "kg", "t", 0) || 0), 1)]), _: 1 }), r(s, { "show-overflow-tooltip": true, prop: "ratio", label: "月度达成率", align: "center" }, { default: a(({ row: e }) => [w("span", null, m(e.ratio ? e.ratio : 0) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
