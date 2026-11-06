import { ref as m } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as o } from "vue";
import { withCtx as v } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as k, _ as N } from "./module/header.vue.js";
import { x as E, vY as V, o as y, jG as F, jH as P, P as U, ba as C, D as u } from "../../../../shared/runtime.js";
import "../../../../modules/index-2cb7c1a5.js";
const D = { class: "app-container" }, j = { __name: "index", setup(Y) {
  const d = { add: false, edit: false, del: false, download: false }, s = m(), g = m([["amountExcludingVATNoFreight", ["to-thousand-ck", "YUAN"]], ["amountExcludingVAT", ["to-thousand-ck", "YUAN"]], ["inboundTime", "parse-time"]]), { crud: l, columns: i } = E({ title: "验收记录", sort: [], permission: { ...V }, crudApi: { ...k }, invisibleColumns: [], optShow: { ...d } }, s), { maxHeight: h } = y({ paginate: true });
  function p(c) {
    return C(c, { props: ["quantity", ["mete", 3], ["amountExcludingVAT", u.YUAN], ["amountExcludingVATNoFreight", u.YUAN]], toThousandFields: ["amountExcludingVATNoFreight"] });
  }
  return (c, B) => {
    const a = A, b = _("common-table"), f = T;
    return t(), w("div", D, [r(e(N)), x((t(), o(b, { ref_key: "tableRef", ref: s, data: e(l).data, "data-format": g.value, "max-height": e(h), "highlight-current-row": "", "row-key": "id", "show-summary": "", "summary-method": p }, { default: v(() => [r(F), r(P), e(i).visible("budgetUnitPrice") ? (t(), o(a, { "show-overflow-tooltip": "", key: "budgetUnitPrice", prop: "budgetUnitPrice", label: "预算单价（不含税）", "min-width": "130", align: "right" })) : n("", true), e(i).visible("unitPriceExcludingVATNoFreight") ? (t(), o(a, { "show-overflow-tooltip": "", key: "unitPriceExcludingVATNoFreight", prop: "unitPriceExcludingVATNoFreight", label: "采购单价（不含税）", "min-width": "130", align: "right" })) : n("", true), e(i).visible("amountExcludingVATNoFreight") ? (t(), o(a, { "show-overflow-tooltip": "", key: "amountExcludingVATNoFreight", prop: "amountExcludingVATNoFreight", label: "金额（不含税）", "min-width": "130", align: "right" })) : n("", true), e(i).visible("inboundTime") ? (t(), o(a, { "show-overflow-tooltip": "", key: "inboundTime", prop: "inboundTime", label: "入库时间", width: "150", align: "center" })) : n("", true), e(i).visible("remark") ? (t(), o(a, { "show-overflow-tooltip": "", key: "remark", prop: "remark", label: "备注", "min-width": "150" })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[f, e(l).loading]]), r(e(U))]);
  };
} };
export {
  j as default
};
