import { inject as _ } from "vue";
import { ref as x } from "vue";
import { watchEffect as j } from "vue";
import { computed as w } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as o } from "vue";
import { withCtx as e } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as p } from "vue";
import { unref as d } from "vue";
import { createTextVNode as D } from "vue";
import { InfoFilled as E } from "@element-plus/icons-vue";
import { ElIcon as g } from "element-plus";
import { ElPopover as k } from "element-plus";
import { ElButton as C } from "element-plus";
import { s as V } from "../../../../../../../modules/pc-insourc-data-b34c8a60.js";
import { _ as T, ia as B, bv as F, iW as L, ec as z, e3 as N, iv as A, e5 as P } from "../../../../../../../shared/runtime.js";
import { d as M } from "../../../../../../../modules/upload-file-download-812f558c.js";
const O = { class: "second-container" }, U = { class: "label-container" }, $ = { style: { "font-size": "14px" } }, R = { class: "label-container" }, W = { style: { "font-size": "14px" } }, q = { key: 0, class: "notSlotValue" }, G = { key: 1, class: "notSlotValue" }, H = { key: 0, class: "downLoad" }, J = { key: 1, class: "notSlotValue" }, K = `
内包制：当前项目下的 项目经理注资 + 收入的钱；

合营 ：当前项目下的 项目经理注资 + 签订主体注资 + 收入的钱
`, Q = { __name: "second-table", setup(X) {
  const b = _("purchaseForm"), { purchaseInfo: c, attachmentId: y } = _("purchaseInfo"), v = _("tableItemData"), m = x([]);
  j(() => {
    if (c && c.projectSupplierDto) {
      const a = c.projectSupplierDto;
      Object.assign(v, a, { attachmentId: y }), a.paymentAmount && (a.capital = B(a.paymentAmount)), a.basicClass = F.getBits(L.ENUM, a.basicClass, "L").join(" | ");
      const l = z([a]);
      m.value = N(V, ...l);
    }
  });
  const I = `
内包制： 项目经理下所有项目的收入金额 + 当前项目的注资金额；

合营： ${w(() => c.projectAttribute === 2 ? "" : "项目经理下的所有项目的 项目经理注资 + 签订主体注资 + 收入的钱").value}
`;
  return (a, l) => {
    const u = E, f = g, h = k, S = C;
    return s(), n("div", O, [o(P, { column: 3, "form-data": d(b), "table-list": m.value, "item-width": "8vw", size: "default" }, { collectionSummary_label: e(({ label: t }) => [i("div", U, [i("span", $, p(t), 1), o(h, { content: I, width: 300, placement: "left", title: "总结余", trigger: "hover" }, { reference: e(() => [o(f, { class: "icon" }, { default: e(() => [o(u)]), _: 1 })]), _: 1 })])]), contractCollectionSummary_label: e(({ label: t }) => [i("div", R, [i("span", W, p(t), 1), o(h, { content: K, width: 300, placement: "left", title: "本项目结余", trigger: "hover" }, { reference: e(() => [o(f, { class: "icon" }, { default: e(() => [o(u)]), _: 1 })]), _: 1 })])]), paymentReasonId: e(({ val: t }) => {
      var r;
      return [t ? (s(), n("span", q, p((r = d(A).V[t]) == null ? void 0 : r.L), 1)) : (s(), n("span", G, "无"))];
    }), attachmentId: e(({ val: t }) => [t ? (s(), n("div", H, [o(S, { icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (r) => d(M)(t) }, { default: e(() => l[0] || (l[0] = [D("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])])) : (s(), n("span", J, "无"))]), _: 1 }, 8, ["form-data", "table-list"])]);
  };
} }, ot = T(Q, [["__scopeId", "data-v-8d863c08"]]);
export {
  ot as default
};
