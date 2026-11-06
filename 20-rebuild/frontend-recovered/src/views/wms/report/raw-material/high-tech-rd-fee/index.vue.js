import { computed as y } from "vue";
import { ref as p } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as u } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as k, M as N } from "./module/header.vue.js";
import { t as F, jX as D, bD as E, D as c, x as V, BJ as S, o as U, cO as B, jl as H, jG as M, jH as j, k5 as q, zE as Y, k6 as $, P as I } from "../../../../../shared/runtime.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../config-manage/wms/high-tech-rd-fee/index.vue.js";
import "../../../../config-manage/wms/high-tech-rd-fee/module/config-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "../../../../config-manage/wms/high-tech-rd-fee/module/header.vue.js";
import "../../../../config-manage/wms/high-tech-rd-fee/module/config.vue.js";
import "../../../../../modules/use-table-change-32e98420.js";
const L = { class: "app-container" }, ae = { __name: "index", setup(O) {
  const { decimalPrecision: r } = F(), f = { batchAdd: false, add: false, edit: false, del: false, download: false }, b = y(() => [...D, ["invoiceType", ["parse-enum", E, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", r.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", r.value.wms]], ["unitPriceNoFreight", ["to-thousand", r.value.wms]], ["amount", ["to-thousand", c.YUAN]], ["amountExcludingVAT", ["to-thousand", c.YUAN]], ["amountNoFreight", ["to-thousand", c.YUAN]], ["inputVAT", ["to-thousand", c.YUAN]], ["outboundTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundReceipt.outboundTime", ["parse-time", "{y}-{m}-{d}"]], ["rdRate", ["suffix", " %"]], ["rdFee", ["to-thousand", c.YUAN]]]), w = p([]), d = p(), { CRUD: _, crud: s, columns: t } = V({ title: "高薪研发费", sort: [], invisibleColumns: ["quantity", "measureUnit", "brand", "warehouse", "invoiceType", "taxRate", "unitPriceExcludingVAT"], permission: { ...S }, optShow: { ...f }, crudApi: { ...k } }, d), { maxHeight: g } = U({ paginate: true });
  return _.HOOK.handleRefresh = async (x, { data: n }) => {
    n.content.forEach((a) => {
      var l;
      a.outboundReceipt || (a.outboundReceipt = {}), a.outboundTime = (l = a.outboundReceipt) == null ? void 0 : l.outboundTime;
    }), await B(n.content), n.content = await H(n.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, (x, n) => {
    const a = A, l = T("common-table"), v = P;
    return i(), R("div", L, [o(e(N)), C((i(), u(l, { ref_key: "tableRef", ref: d, data: e(s).data, "data-format": b.value, "max-height": e(g), "default-expand-all": false, "expand-row-keys": w.value, "row-key": "id", onSortChange: e(s).handleSortChange }, { default: h(() => [o(M, { columns: e(t), "basic-class": e(s).query.basicClass, "show-classification": "", "classify-name-alias": "名称", "show-project": "", "spec-merge": "" }, { afterIndex: h(() => [e(t).visible("outboundTime") ? (i(), u(a, { key: "outboundTime", "show-overflow-tooltip": "", prop: "outboundTime", label: "出库日期", align: "center", width: "120", sortable: "custom" })) : m("", true)]), _: 1 }, 8, ["columns", "basic-class"]), o(j, { columns: e(t), "basic-class": e(s).query.basicClass, "show-steel-unit": "" }, null, 8, ["columns", "basic-class"]), o(q, { columns: e(t), "basic-class": e(s).query.basicClass, "show-batch-no": "" }, null, 8, ["columns", "basic-class"]), o(Y, { columns: e(t), "show-unit-price-e": "", "show-invoice-type": "", "show-tax-rate": "", "show-input-VAT": false }, null, 8, ["columns"]), o($, { columns: e(t) }, null, 8, ["columns"]), e(t).visible("rdRate") ? (i(), u(a, { key: "rdRate", "show-overflow-tooltip": "", prop: "rdRate", label: "研发费占比", align: "center", width: "90" })) : m("", true), e(t).visible("rdFee") ? (i(), u(a, { key: "rdFee", "show-overflow-tooltip": "", prop: "rdFee", label: "研发费", align: "right", width: "135" })) : m("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange"])), [[v, e(s).loading]]), o(e(I))]);
  };
} };
export {
  ae as default
};
