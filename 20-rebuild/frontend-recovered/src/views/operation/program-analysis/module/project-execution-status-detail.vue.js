import { ref as D } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as v } from "vue";
import { createBlock as j } from "vue";
import { withCtx as a } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as m } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as E } from "vue";
import { createElementVNode as g } from "vue";
import { isRef as R } from "vue";
import { ElTag as T } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { l as z, m as H } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as O, G as k, o as S, z as F, L, c as f } from "../../../../shared/runtime.js";
const G = { __name: "project-execution-status-detail", props: { visible: { type: Boolean, default: false }, projectInfo: { type: Object, default: () => {
} }, query: { type: Object }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(c, { emit: x }) {
  const y = D([]), I = x, b = c, { visible: w, handleClose: N } = O({ emit: I, props: b, field: "visible", showHook: C });
  async function C() {
    var r, p, e;
    if (!k((r = b.permission) == null ? void 0 : r.detail)) return false;
    let u = [];
    try {
      u = await z({ projectId: (p = b.projectInfo) == null ? void 0 : p.id, branchCompanyId: (e = b.query) == null ? void 0 : e.branchCompanyId }) || {};
    } catch (o) {
      console.log("获取项目执行状态详情失败", o);
    } finally {
      y.value = u;
    }
  }
  const { maxHeight: V } = S({ extraBox: [".head-container"], paginate: true });
  function B(u) {
    const { columns: r, data: p } = u, e = [];
    return r.forEach((o, i) => {
      if (i === 0) {
        e[i] = "合计";
        return;
      }
      if (o.property === "deepMete" || o.property === "produceMete" || o.property === "shippingMete" || o.property === "installMete") {
        const t = p.map((n) => Number(n[o.property]));
        t.every((n) => isNaN(n)) || (e[i] = t.reduce((n, d) => {
          const h = Number(d);
          return isNaN(h) ? n : n + d;
        }, 0)), e[i] = f(e[i], "kg", "t", 0);
      }
    }), e;
  }
  return (u, r) => {
    const p = T, e = q, o = _("common-table"), i = _("common-drawer");
    return v(), j(i, { ref: "drawerRef", title: "项目执行状态详情", modelValue: l(w), "onUpdate:modelValue": r[0] || (r[0] = (t) => R(w) ? w.value = t : null), direction: "rtl", "before-close": l(N), size: "50%" }, { titleAfter: a(() => [s(p, { effect: "plain", size: "large", class: "filter-item" }, { default: a(() => [M(" 项目： " + m(l(F)(c.projectInfo.project) || "-"), 1)]), _: 1 })]), titleRight: a(() => {
      var t, n, d, h;
      return [l(k)((t = c.permission) == null ? void 0 : t.download) ? (v(), j(L, { key: 0, fn: l(H), params: { projectId: (n = c.projectInfo) == null ? void 0 : n.id, branchCompanyId: (d = c.query) == null ? void 0 : d.branchCompanyId }, disabled: !((h = y.value) != null && h.length) }, { default: a(() => r[1] || (r[1] = [M(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : E("", true)];
    }), content: a(() => [s(o, { ref: "tableRef", data: y.value, "max-height": l(V), style: { width: "100%" }, "show-summary": "", "summary-method": B }, { default: a(() => [s(e, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), s(e, { "show-overflow-tooltip": true, prop: "dateTime", label: "月份", align: "center" }), s(e, { "show-overflow-tooltip": true, prop: "deepMete", label: "图纸深化", align: "center" }, { default: a(({ row: t }) => [g("span", null, m(l(f)(t.deepMete, "kg", "t", 0) || 0), 1)]), _: 1 }), s(e, { "show-overflow-tooltip": true, prop: "produceMete", label: "生产加工", align: "center" }, { default: a(({ row: t }) => [g("span", null, m(l(f)(t.produceMete, "kg", "t", 0) || 0), 1)]), _: 1 }), s(e, { "show-overflow-tooltip": true, prop: "shippingMete", label: "物流发运", align: "center" }, { default: a(({ row: t }) => [g("span", null, m(l(f)(t.shippingMete, "kg", "t", 0) || 0), 1)]), _: 1 }), s(e, { "show-overflow-tooltip": true, prop: "installMete", label: "项目安装", align: "center" }, { default: a(({ row: t }) => [g("span", null, m(l(f)(t.installMete, "kg", "t", 0) || 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  G as default
};
