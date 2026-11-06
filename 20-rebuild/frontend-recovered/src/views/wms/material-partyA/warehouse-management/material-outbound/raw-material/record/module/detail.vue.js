import { ref as f } from "vue";
import { computed as y } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as c } from "vue";
import { createBlock as b } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as w } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as E } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElTooltip as A } from "element-plus";
import { _ as L, jX as M, qS as V, gt as I, o as O, cO as q, jl as K, p as U, aR as F, k4 as P, jG as z, k5 as G, jH as W, k6 as X, ba as J, jN as Q } from "../../../../../../../../shared/runtime.js";
const Y = { key: 0 }, Z = { style: { color: "brown" } }, ee = { style: { color: "#3a8ee6" } }, ae = { __name: "detail", setup(te) {
  const x = f(), m = f([]), g = f([...M, ["outboundAddress", ["parse-enum", V]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: k, crud: i, detail: n } = I(), { maxHeight: v } = O({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => y(() => !i.detailLoading)), T = y(() => n && n.serialNumber ? `出库单：${n.serialNumber}` : "出库单");
  k.HOOK.beforeDetailLoaded = async (p, e) => {
    await q(e.list), e.list = await K(e.list, { toSmallest: false, toNum: true });
  };
  function j(p) {
    return J(p, { props: ["quantity", ["mete", Q.weight.precision]] });
  }
  return (p, e) => {
    const u = H, _ = S, B = A, N = h("common-table"), C = h("common-drawer"), D = $("parse-time");
    return c(), b(C, { ref_key: "drawerRef", ref: x, "before-close": t(i).cancelDetail, "content-loading": t(i).detailLoading, "show-close": true, title: T.value, visible: t(i).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: s(() => [t(n).applicant ? (c(), b(u, { key: 0, effect: "dark", type: "success" }, { default: s(() => [d(l(`申请人：${t(n).applicant.name} | ${t(n).applicant.deptName}`), 1)]), _: 1 })) : w("", true), o(u, { effect: "plain" }, { default: s(() => [d(l(`出库申请时间：${t(U)(t(n).createTime)}`), 1)]), _: 1 }), o(u, { effect: "plain" }, { default: s(() => [d("备注：" + l(t(n).remark || "-"), 1)]), _: 1 })]), titleRight: s(() => e[1] || (e[1] = [])), content: s(() => [o(N, { data: t(n).list, "data-format": g.value, "expand-row-keys": m.value, "max-height": t(v), "summary-method": j, "row-key": "id", "show-summary": "" }, { default: s(() => [o(F, { "expand-row-keys": m.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (a) => m.value = a), data: t(n).list, fixed: "left", "row-key": "id" }, { default: s(({ row: a }) => [o(P, { "basic-class": a.basicClass, row: a, "show-graphics": "", "show-remark": "" }, { default: s(() => [a.boolTransfer ? (c(), R("p", Y, [e[2] || (e[2] = d(" 调拨： ")), e[3] || (e[3] = r("span", null, "（来源）", -1)), r("span", Z, l(a.sourceProject), 1), e[4] || (e[4] = r("span", null, " ▶ ", -1)), e[5] || (e[5] = r("span", null, "（目的）", -1)), r("span", ee, l(a.project), 1)])) : w("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), o(z, { "basic-class": t(n).basicClass, fixed: "left", "show-outbound-mode": "" }, null, 8, ["basic-class"]), o(G), o(W), o(X, { "show-area": false, "show-monomer": false, "show-project": "", showAreaBatchName: "", "show-transfer": "", "show-workshop": "", showOutboundWorkshop: "" }), o(_, { align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" }), o(_, { key: "recipient", align: "center", label: "领用人", width: "100px" }, { default: s(({ row: a }) => [a.recipient ? (c(), b(B, { key: 0, content: `${a.recipient.deptName}`, effect: "light", placement: "top" }, { default: s(() => [r("span", null, l(a.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : w("", true)]), _: 1 }), o(_, { key: "outboundTime", align: "center", label: "出库时间", width: "140px" }, { default: s(({ row: a }) => [E(r("span", null, null, 512), [[D, a.outboundTime]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, ne = L(ae, [["__scopeId", "data-v-604827bd"]]);
export {
  ne as default
};
