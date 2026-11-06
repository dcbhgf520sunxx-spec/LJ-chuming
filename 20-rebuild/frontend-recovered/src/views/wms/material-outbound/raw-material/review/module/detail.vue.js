import { ref as u } from "vue";
import { computed as y } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as n } from "vue";
import { unref as a } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as b } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as r } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as D } from "element-plus";
import { ElTooltip as E } from "element-plus";
import { _ as H, jX as R, qS as L, gt as M, o as V, cO as A, jl as I, p as O, aR as K, k4 as U, jG as q, k5 as F, jH as P, k6 as z, ba as G, jN as W } from "../../../../../../shared/runtime.js";
const X = { key: 0 }, J = { style: { color: "brown" } }, Q = { style: { color: "#3a8ee6" } }, Y = { __name: "detail", setup(Z) {
  const g = u(), d = u([]), h = u([...R, ["outboundAddress", ["parse-enum", L]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: k, crud: i, detail: s } = M(), { maxHeight: T } = V({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => y(() => !i.detailLoading)), j = y(() => s && s.applicationSN ? `出库申请单：${s.applicationSN}` : "出库申请单");
  k.HOOK.beforeDetailLoaded = async (p, e) => {
    await A(e.list), e.list = await I(e.list, { toSmallest: false, toNum: true });
  };
  function v(p) {
    return G(p, { props: ["quantity", ["mete", W.weight.precision]] });
  }
  return (p, e) => {
    const w = $, m = D, B = E, C = x("common-table"), N = x("common-drawer");
    return c(), _(N, { ref_key: "drawerRef", ref: g, visible: a(i).detailVisible, "content-loading": a(i).detailLoading, "before-close": a(i).cancelDetail, title: j.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-record-detail" }, { titleAfter: n(() => [a(s).applicant ? (c(), _(w, { key: 0, type: "success", effect: "dark" }, { default: n(() => [f(l(`申请人：${a(s).applicant.name} | ${a(s).applicant.deptName}`), 1)]), _: 1 })) : b("", true), o(w, { effect: "plain" }, { default: n(() => [f(l(`出库申请时间：${a(O)(a(s).createTime)}`), 1)]), _: 1 })]), content: n(() => [o(C, { data: a(s).list, "data-format": h.value, "max-height": a(T), "show-summary": "", "summary-method": v, "expand-row-keys": d.value, "row-key": "id" }, { default: n(() => [o(K, { data: a(s).list, "expand-row-keys": d.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (t) => d.value = t), "row-key": "id", fixed: "left" }, { default: n(({ row: t }) => [o(U, { "basic-class": t.basicClass, row: t, "show-remark": "", "show-graphics": "" }, { default: n(() => [t.boolTransfer ? (c(), S("p", X, [e[1] || (e[1] = f(" 调拨： ")), e[2] || (e[2] = r("span", null, "（来源）", -1)), r("span", J, l(t.sourceProject), 1), e[3] || (e[3] = r("span", null, " ▶ ", -1)), e[4] || (e[4] = r("span", null, "（目的）", -1)), r("span", Q, l(t.project), 1)])) : b("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), o(q, { "basic-class": a(s).basicClass, fixed: "left", "show-outbound-mode": "" }, null, 8, ["basic-class"]), o(F), o(P), o(z, { "show-project": "", "show-monomer": "", "show-area": "", "show-transfer": "", showOutboundWorkshop: "" }), o(m, { label: "出库目的地", width: "100px", prop: "outboundAddress", align: "center" }), o(m, { key: "recipient", label: "领用人", width: "100px", align: "center" }, { default: n(({ row: t }) => [t.recipient ? (c(), _(B, { key: 0, placement: "top", effect: "light", content: `${t.recipient.deptName}` }, { default: n(() => [r("span", null, l(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : b("", true)]), _: 1 }), o(m, { key: "outboundTime", prop: "outboundTime", label: "实际出库时间", width: "145px", align: "center" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, te = H(Y, [["__scopeId", "data-v-830db4b4"]]);
export {
  te as default
};
