import { inject as S } from "vue";
import { provide as s } from "vue";
import { ref as o } from "vue";
import { computed as j } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as Q } from "vue";
import { createVNode as l } from "vue";
import { unref as i } from "vue";
import { createElementVNode as C } from "vue";
import { createBlock as h } from "vue";
import { withCtx as v } from "vue";
import { withDirectives as E } from "vue";
import { createTextVNode as F } from "vue";
import { ElBadge as P } from "element-plus";
import { c as $ } from "../../../../modules/index-31ff7034.js";
import { aY as L, s1 as q, m as O, a3 as U } from "../../../../shared/runtime.js";
import G from "./summary-list/index.vue.js";
import M from "./detail-list/index.vue.js";
import W from "./module/edit-drawer.vue.js";
import Y from "./module/audit-drawer.vue.js";
import "../../../../modules/detail-bead30a9.js";
import "../../../../modules/mes-ee117a22.js";
import "./summary-list/module/header.vue.js";
import "../../../../modules/use-unshow-productType-by-mode-dfef77e4.js";
import "../../../../modules/index-490fd9d7.js";
import "../../../../modules/index-897a9ea4.js";
import "./detail-list/module/header.vue.js";
import "../../../../modules/index-3b2628f3.js";
import "./module/edit-preview.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "./module/audit-detail-drawer.vue.js";
const H = { style: { display: "flex" } }, ce = { __name: "index", props: { organizationType: { type: Boolean, default: L.IN_STAFF.V } }, setup(k) {
  const y = k, b = S("permission", q);
  s("permission", b);
  const n = o(), _ = o(), a = j(() => {
    var t;
    return (t = n == null ? void 0 : n.value) == null ? void 0 : t.query;
  }), { globalProjectId: g } = O("globalProjectId");
  s("projectId", g), s("fQuery", a), s("organizationType", y.organizationType);
  const u = o(), I = o(), p = o(false), d = o(false), f = o(0);
  function B(t) {
    var e;
    u.value = Object.assign({}, t), (e = _.value) == null || e.toQuery();
  }
  function T(t) {
    I.value = Object.assign({}, t), p.value = true;
  }
  function N() {
    u.value = void 0;
  }
  async function m() {
    f.value = await $({ projectId: g.value, organizationType: y.organizationType });
  }
  const V = j(() => {
    var t, e;
    return (e = U.V[(t = a.value) == null ? void 0 : t.productType]) == null ? void 0 : e.SL;
  });
  return (t, e) => {
    var x;
    const w = A("common-button"), z = P, R = D("permission");
    return c(), Q("div", H, [l(i(G), { style: { width: "50%" }, ref_key: "summaryListRef", ref: n, onSetInfo: B, onSetDetailInfo: T, onRefreshAuditNumber: m }, null, 512), e[5] || (e[5] = C("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 100px)" } }, null, -1)), (c(), h(i(M), { key: 1, ref_key: "detailListRef", ref: _, style: { width: "49%" }, fQuery: a.value, fInfo: u.value, onSetInfo: T, onClearInfo: N }, { auditBox: v(() => [E((c(), h(z, { value: f.value, hidden: !f.value, style: { "margin-right": "5px" } }, { default: v(() => [l(w, { size: "default", type: "primary", onClick: e[0] || (e[0] = (r) => d.value = true) }, { default: v(() => e[4] || (e[4] = [F("审核记录")])), _: 1, __: [4] })]), _: 1 }, 8, ["value", "hidden"])), [[R, i(b).audit]])]), _: 1 }, 8, ["fQuery", "fInfo"])), l(i(W), { visible: p.value, "onUpdate:visible": e[1] || (e[1] = (r) => p.value = r), productType: (x = a.value) == null ? void 0 : x.productType, detailInfo: I.value, productTypeText: V.value, onRefresh: m }, null, 8, ["visible", "productType", "detailInfo", "productTypeText"]), l(i(Y), { visible: d.value, "onUpdate:visible": e[2] || (e[2] = (r) => d.value = r), onRefresh: m }, null, 8, ["visible"])]);
  };
} };
export {
  ce as default
};
