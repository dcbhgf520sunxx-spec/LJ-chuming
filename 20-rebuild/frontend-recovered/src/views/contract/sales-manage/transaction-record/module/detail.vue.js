import { ref as g } from "vue";
import { watch as S } from "vue";
import { computed as E } from "vue";
import { inject as q } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as m } from "vue";
import { openBlock as b } from "vue";
import { createBlock as v } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as n } from "vue";
import { withDirectives as i } from "vue";
import { createTextVNode as F } from "vue";
import { createCommentVNode as I } from "vue";
import { createVNode as a } from "vue";
import { unref as s } from "vue";
import { isRef as U } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { l as j, t as K, u as Q, o as W } from "../../../../../shared/runtime.js";
function X(t) {
  return j({ module: "contract", url: "business/check/summary", method: "get", params: t });
}
function A(t) {
  return j({ module: "contract", url: "business/check/detail", method: "get", params: t });
}
const ae = { get: X, detail: A }, Y = { class: "print-wrap" }, Z = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(t, { emit: D }) {
  const { decimalPrecision: c } = K(), y = g(), V = D, u = t, { visible: d, handleClose: R } = Q({ emit: V, props: u, field: "visible" }), { maxHeight: z } = W({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, y);
  S(() => u.visible, (r) => {
    r && N();
  }, { immediate: true });
  const p = g(false), w = g([]), B = E(() => [["project", ["parse-project"]], ["signingDate", ["parse-time", "{y}-{m}-{d}"]], ["contractAmount", ["to-thousand", c.value.contract]], ["settlementAmount", ["to-thousand", c.value.contract]]]), C = q("permission");
  async function N() {
    let r = [];
    try {
      p.value = true;
      const { content: e } = await A(u.info);
      r = e;
    } catch {
      console.log("获取详情列表失败");
    } finally {
      w.value = r, p.value = false;
    }
  }
  return (r, e) => {
    const f = $, H = _("print-table"), l = G, O = _("common-table"), T = _("common-drawer"), h = m("parse-time"), k = m("thousand"), x = m("empty-text"), L = m("permission"), M = J;
    return b(), v(T, { ref_key: "drawerRef", ref: y, title: t.info.name, modelValue: s(d), "onUpdate:modelValue": e[0] || (e[0] = (P) => U(d) ? d.value = P : null), direction: "rtl", "close-on-click-modal": false, "before-close": s(R), size: "60%" }, { titleAfter: o(() => [t.info.startDate ? (b(), v(f, { key: 0, effect: "plain", size: "large" }, { default: o(() => [e[1] || (e[1] = n("span", null, "统计日期：", -1)), i(n("span", null, null, 512), [[h, { val: t.info.startDate, fmt: "{y}-{m}" }]]), e[2] || (e[2] = F(" ~ ")), i(n("span", null, null, 512), [[h, { val: t.info.endDate, fmt: "{y}-{m}" }]])]), _: 1, __: [1, 2] })) : I("", true), a(f, { type: "success", effect: "plain", size: "large" }, { default: o(() => [e[3] || (e[3] = n("span", null, "累计合同额：", -1)), i(n("span", null, null, 512), [[k, { val: t.info.totalContractAmount || 0, dp: s(c).contract }], [x]])]), _: 1, __: [3] }), a(f, { type: "success", effect: "plain", size: "large" }, { default: o(() => [e[4] || (e[4] = n("span", null, "累计结算额：", -1)), i(n("span", null, null, 512), [[k, { val: t.info.totalSettlementAmount || 0, dp: s(c).contract }], [x]])]), _: 1, __: [4] })]), titleRight: o(() => [n("div", Y, [i(a(H, { "api-key": "transactionRecord", params: t.info, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, s(C).print]])])]), content: o(() => [i((b(), v(O, { ref: "tableRef", "data-format": B.value, data: w.value, "max-height": s(z), style: { width: "100%" } }, { default: o(() => [a(l, { label: "序号", type: "index", align: "center", width: "60" }), a(l, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }), a(l, { key: "contractAmount", prop: "contractAmount", align: "center", "min-width": "120", label: "合同额" }), a(l, { key: "settlementAmount", prop: "settlementAmount", align: "center", "min-width": "120", label: "结算额" }), a(l, { key: "signingDate", prop: "signingDate", label: "签订日期", align: "center", width: "100" }), a(l, { key: "signerName", prop: "signerName", align: "center", width: "120", label: "业务负责人" })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[M, p.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ne = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  ae as c,
  ne as d
};
