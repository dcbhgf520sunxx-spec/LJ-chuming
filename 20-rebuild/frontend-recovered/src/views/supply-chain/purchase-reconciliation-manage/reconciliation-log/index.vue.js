import { ref as T } from "vue";
import { computed as F } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as E } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElTooltip as S } from "element-plus";
import { vLoading as C } from "element-plus";
import { c as D, m as U } from "./module/header.vue.js";
import { D as c, x as Y, v$ as B, o as H, jH as R, P as M, ba as j } from "../../../../shared/runtime.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/index-2cb7c1a5.js";
const q = { class: "app-container" }, L = { class: "spec-box" }, $ = { class: "spec-info ellipsis-text" }, X = { __name: "index", setup(z) {
  const _ = { add: false, edit: false, del: false, download: false }, d = T(), b = F(() => [["amountExcludingVAT", ["to-thousand", c.YUAN]], ["amountNoFreight", ["to-thousand", c.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", c.YUAN]]]), { crud: p, columns: s } = Y({ title: "供应商对账", sort: [], permission: { ...B }, crudApi: { ...D }, invisibleColumns: [], optShow: { ..._ } }, d), { maxHeight: N } = H({ paginate: true });
  function x(f) {
    return j(f, { props: ["quantity", ["mete", 3], ["amountExcludingVATNoFreight", c.YUAN], ["amountExcludingVATNoFreight", c.YUAN]], toThousandFields: ["amountExcludingVATNoFreight"] });
  }
  return (f, G) => {
    const y = g("table-cell-tag"), o = P, h = S, w = g("common-table"), v = C;
    return a(), V("div", q, [i(e(U)), k((a(), l(w, { ref_key: "tableRef", ref: d, data: e(p).data, "data-format": b.value, "max-height": e(N), "highlight-current-row": "", "row-key": "id", "show-summary": "", "summary-method": x }, { default: n(() => [i(o, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }, { default: n(({ row: t, $index: A }) => [i(y, { show: !!t.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), m("span", null, u(A + 1), 1)]), _: 1 }), e(s).visible("classifySerialNumber") ? (a(), l(o, { prop: "classifySerialNumber", key: "classifySerialNumber", label: "物料编号", align: "center", width: "110px", fixed: "left", "show-overflow-tooltip": "" })) : r("", true), e(s).visible("classifyName") ? (a(), l(o, { prop: "classifyName", key: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": "", fixed: "left" }, { default: n(({ row: t }) => [i(h, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [E(u(t.classifyName), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 })) : r("", true), e(s).visible("specification") ? (a(), l(o, { key: "specification", prop: "specification", label: "规格", "min-width": "200", align: "center" }, { default: n(({ row: t }) => [m("div", L, [i(h, { content: t.specTip, placement: "left" }, { default: n(() => [m("span", $, u(t.formatSpec), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 })) : r("", true), i(R), e(s).visible("unitPriceExcludingVATNoFreight") ? (a(), l(o, { "show-overflow-tooltip": "", key: "unitPriceExcludingVATNoFreight", prop: "unitPriceExcludingVATNoFreight", label: "采购单价（不含税）", "min-width": "130", align: "right" })) : r("", true), e(s).visible("amountExcludingVATNoFreight") ? (a(), l(o, { "show-overflow-tooltip": "", key: "amountExcludingVATNoFreight", prop: "amountExcludingVATNoFreight", label: "金额（不含税）", "min-width": "130", align: "right" })) : r("", true), e(s).visible("remark") ? (a(), l(o, { "show-overflow-tooltip": "", key: "remark", prop: "remark", label: "备注", "min-width": "150" })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[v, e(p).loading]]), i(e(M))]);
  };
} };
export {
  X as default
};
