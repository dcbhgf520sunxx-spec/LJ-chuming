import { ref as D } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as h } from "vue";
import { createBlock as j } from "vue";
import { withCtx as l } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as f } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as E } from "vue";
import { createElementVNode as k } from "vue";
import { createElementBlock as I } from "vue";
import { isRef as F } from "vue";
import { ElTag as T } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { d as z, n as H } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as O, G as N, o as S, z as L, L as U, c as m } from "../../../../shared/runtime.js";
const A = { key: 0, class: "tc-danger" }, G = { key: 1 }, K = { __name: "project-feeding-status-detail", props: { visible: { type: Boolean, default: false }, projectInfo: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(d, { emit: C }) {
  const y = D([]), w = C, g = d, { visible: _, handleClose: V } = O({ emit: w, props: g, field: "visible", showHook: x });
  async function x() {
    var o, c, t;
    if (!N((o = g.permission) == null ? void 0 : o.detail)) return false;
    let p = [];
    try {
      p = await z({ projectId: (c = g.projectInfo) == null ? void 0 : c.id, branchCompanyId: (t = g.query) == null ? void 0 : t.branchCompanyId, isRecently: false }) || [];
    } catch (n) {
      console.log("获取投料详情失败", n);
    } finally {
      y.value = p;
    }
  }
  const { maxHeight: B } = S({ extraBox: [".head-container"], paginate: true });
  function R(p) {
    const { columns: o, data: c } = p, t = [];
    return o.forEach((n, r) => {
      if (r === 0) {
        t[r] = "合计";
        return;
      }
      if (n.property === "feedingMete" || n.property === "productMete" || n.property === "judgeMete") {
        const e = c.map((s) => Number(s[n.property]));
        e.every((s) => isNaN(s)) || (t[r] = e.reduce((s, u) => {
          const b = Number(u);
          return isNaN(b) ? s : s + u;
        }, 0)), t[r] = m(t[r], "kg", "t", 0);
      }
    }), t;
  }
  return (p, o) => {
    const c = T, t = q, n = v("common-table"), r = v("common-drawer");
    return h(), j(r, { ref: "drawerRef", title: "项目投料分析详情", modelValue: a(_), "onUpdate:modelValue": o[0] || (o[0] = (e) => F(_) ? _.value = e : null), direction: "rtl", "before-close": a(V), size: "50%" }, { titleAfter: l(() => [i(c, { effect: "plain", size: "large", class: "filter-item" }, { default: l(() => [M(" 项目： " + f(a(L)(d.projectInfo.project) || "-"), 1)]), _: 1 })]), titleRight: l(() => {
      var e, s, u, b;
      return [a(N)((e = d.permission) == null ? void 0 : e.download) ? (h(), j(U, { key: 0, fn: a(H), params: { projectId: (s = d.projectInfo) == null ? void 0 : s.id, branchCompanyId: (u = d.query) == null ? void 0 : u.branchCompanyId }, disabled: !((b = y.value) != null && b.length) }, { default: l(() => o[1] || (o[1] = [M(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : E("", true)];
    }), content: l(() => [i(n, { ref: "tableRef", data: y.value, "max-height": a(B), style: { width: "100%" }, "show-summary": "", "summary-method": R }, { default: l(() => [i(t, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), i(t, { "show-overflow-tooltip": true, prop: "dateTime", label: "日期", align: "center" }), i(t, { "show-overflow-tooltip": true, prop: "feedingMete", label: "投料量", align: "center" }, { default: l(({ row: e }) => [k("span", null, f(a(m)(e == null ? void 0 : e.feedingMete, "kg", "t", 0) || 0), 1)]), _: 1 }), i(t, { "show-overflow-tooltip": true, prop: "produceMete", label: "产量", align: "center" }, { default: l(({ row: e }) => [k("span", null, f(a(m)(e == null ? void 0 : e.produceMete, "kg", "t", 0) || 0), 1)]), _: 1 }), i(t, { "show-overflow-tooltip": true, prop: "judgeMete", label: "差异", align: "center" }, { default: l(({ row: e }) => [e.produceMete - e.feedingMete < 0 ? (h(), I("span", A, f(a(m)(e.produceMete - e.feedingMete, "kg", "t", 0)), 1)) : (h(), I("span", G, f(a(m)(e.produceMete - e.feedingMete, "kg", "t", 0)), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  K as default
};
