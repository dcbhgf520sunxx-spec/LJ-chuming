import { ref as u } from "vue";
import { computed as y } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as b } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as E } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElTooltip as L } from "element-plus";
import { _ as M, jX as V, qS as A, gt as I, o as O, cO as q, jl as K, p as U, aR as F, k4 as P, jG as z, k5 as G, jH as W, k6 as X, ba as J, jN as Q } from "../../../../../../shared/runtime.js";
const Y = { key: 0 }, Z = { style: { color: "brown" } }, ee = { style: { color: "#3a8ee6" } }, ae = { __name: "detail", setup(te) {
  const g = u(), d = u([]), h = u([...V, ["outboundAddress", ["parse-enum", A]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: k, crud: i, detail: n } = I(), { maxHeight: v } = O({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => y(() => !i.detailLoading)), T = y(() => n && n.serialNumber ? `出库单：${n.serialNumber}` : "出库单");
  k.HOOK.beforeDetailLoaded = async (p, e) => {
    await q(e.list), e.list = await K(e.list, { toSmallest: false, toNum: true });
  };
  function j(p) {
    return J(p, { props: ["quantity", ["mete", Q.weight.precision]] });
  }
  return (p, e) => {
    const w = H, m = S, B = L, C = x("common-table"), D = x("common-drawer"), N = $("parse-time");
    return c(), _(D, { ref_key: "drawerRef", ref: g, visible: t(i).detailVisible, "content-loading": t(i).detailLoading, "before-close": t(i).cancelDetail, title: T.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-record-detail" }, { titleAfter: s(() => [t(n).applicant ? (c(), _(w, { key: 0, type: "success", effect: "dark" }, { default: s(() => [f(l(`申请人：${t(n).applicant.name} | ${t(n).applicant.deptName}`), 1)]), _: 1 })) : b("", true), o(w, { effect: "plain" }, { default: s(() => [f(l(`出库申请时间：${t(U)(t(n).createTime)}`), 1)]), _: 1 })]), titleRight: s(() => e[1] || (e[1] = [])), content: s(() => [o(C, { data: t(n).list, "data-format": h.value, "max-height": t(v), "show-summary": "", "summary-method": j, "expand-row-keys": d.value, "row-key": "id" }, { default: s(() => [o(F, { data: t(n).list, "expand-row-keys": d.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (a) => d.value = a), "row-key": "id", fixed: "left" }, { default: s(({ row: a }) => [o(P, { "basic-class": a.basicClass, row: a, "show-remark": "", "show-graphics": "" }, { default: s(() => [a.boolTransfer ? (c(), R("p", Y, [e[2] || (e[2] = f(" 调拨： ")), e[3] || (e[3] = r("span", null, "（来源）", -1)), r("span", Z, l(a.sourceProject), 1), e[4] || (e[4] = r("span", null, " ▶ ", -1)), e[5] || (e[5] = r("span", null, "（目的）", -1)), r("span", ee, l(a.project), 1)])) : b("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), o(z, { "basic-class": t(n).basicClass, fixed: "left", "show-outbound-mode": "" }, null, 8, ["basic-class"]), o(G), o(W), o(X, { "show-project": "", "show-monomer": false, "show-area": false, "show-workshop": "", "show-transfer": "", showOutboundWorkshop: "" }), o(m, { label: "出库目的地", width: "100px", prop: "outboundAddress", align: "center" }), o(m, { key: "recipient", label: "领用人", width: "100px", align: "center" }, { default: s(({ row: a }) => [a.recipient ? (c(), _(B, { key: 0, placement: "top", effect: "light", content: `${a.recipient.deptName}` }, { default: s(() => [r("span", null, l(a.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : b("", true)]), _: 1 }), o(m, { key: "outboundTime", label: "实际出库时间", width: "140px", align: "center" }, { default: s(({ row: a }) => [E(r("span", null, null, 512), [[N, a.outboundTime]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, ne = M(ae, [["__scopeId", "data-v-32128ac3"]]);
export {
  ne as default
};
