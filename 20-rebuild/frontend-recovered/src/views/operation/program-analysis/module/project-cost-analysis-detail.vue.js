import { ref as w } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as v } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as c } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as R } from "vue";
import { createElementVNode as T } from "vue";
import { isRef as A } from "vue";
import { ElTag as D } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { o as L } from "../../../../modules/program-analysis-f1c6c876.js";
import { u as O, G as j, i as x, o as q, z as E, L as F } from "../../../../shared/runtime.js";
const S = { __name: "project-cost-analysis-detail", props: { visible: { type: Boolean, default: false }, projectInfo: { type: Object, default: () => {
} }, detailList: { type: Array, default: () => [] }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: C }) {
  const r = w([]), u = w(0), V = C, m = s, { visible: p, handleClose: k } = O({ emit: V, props: m, field: "visible", showHook: I });
  function I() {
    var d, o;
    if (!j((d = m.permission) == null ? void 0 : d.detail)) return false;
    r.value = m.detailList || [], u.value = (o = r.value) == null ? void 0 : o.reduce((i, e) => x(e == null ? void 0 : e.amount) ? i + (e == null ? void 0 : e.amount) : i, 0);
  }
  const { maxHeight: N } = q({ extraBox: [".head-container"], paginate: false });
  return (d, o) => {
    const i = D, e = H, B = g("common-table"), z = g("common-drawer");
    return _(), v(z, { ref: "drawerRef", title: "项目成本分析详情", modelValue: n(p), "onUpdate:modelValue": o[0] || (o[0] = (a) => A(p) ? p.value = a : null), direction: "rtl", "before-close": n(k), size: "50%" }, { titleAfter: t(() => [l(i, { effect: "plain", size: "large", type: "primary", class: "filter-item" }, { default: t(() => [f(" 项目： " + c(n(E)(s.projectInfo.project) || "-"), 1)]), _: 1 }), l(i, { effect: "plain", size: "large", type: "warning", class: "filter-item" }, { default: t(() => [f(" 累计总成本（元）： " + c(u.value || 0), 1)]), _: 1 })]), titleRight: t(() => {
      var a, b, y, h;
      return [n(j)((a = s.permission) == null ? void 0 : a.download) ? (_(), v(F, { key: 0, fn: n(L), params: { projectId: (b = s.projectInfo) == null ? void 0 : b.id, branchCompanyId: (y = s.query) == null ? void 0 : y.branchCompanyId }, disabled: !((h = r.value) != null && h.length) }, { default: t(() => o[1] || (o[1] = [f(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : R("", true)];
    }), content: t(() => [l(B, { ref: "tableRef", data: r.value, "max-height": n(N), style: { width: "100%" }, "show-empty-symbol": false }, { default: t(() => [l(e, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), l(e, { "show-overflow-tooltip": true, prop: "costTypeName", label: "类别", align: "center" }), l(e, { "show-overflow-tooltip": true, prop: "amount", label: "累计成本（元）", align: "center" }), l(e, { "show-overflow-tooltip": true, prop: "proportion", label: "占比", align: "center" }, { default: t(({ row: a }) => [T("span", null, c(n(x)(a.proportion) ? a.proportion + "%" : "0%"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
